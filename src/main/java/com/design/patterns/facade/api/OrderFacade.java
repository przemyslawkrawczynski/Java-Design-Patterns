package com.design.patterns.facade.api;

import com.design.patterns.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderFacade {
    @Autowired
    private ShopService shopService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    public void processOrder(OrderDto order, Long userId) throws OrderProcessigException {

        boolean wasError = false;
        long orderId = shopService.openOrder(userId);
        LOGGER.info("Reistering new order, ID: " + orderId);
        if (orderId < 0) {
            LOGGER.error(OrderProcessigException.ERR_NOT_AUTHORISED);
            wasError = true;
            throw new OrderProcessigException(OrderProcessigException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto orderItem: order.getItems()) {
                LOGGER.info("Adding item " + orderItem.getProductId() + ", " + orderItem.getQuantity() + " pcs");
                shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQuantity());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Oder value is: " + value + " USD");
            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessigException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessigException(OrderProcessigException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for order was done");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessigException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessigException(OrderProcessigException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessigException.ERR_SUBMITTING_ERROR);
                wasError = true;
                throw new OrderProcessigException(OrderProcessigException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info("Order " + orderId + " submitted");
        } finally {
            if (wasError) {
                LOGGER.info("Cancelling order " + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }

}
