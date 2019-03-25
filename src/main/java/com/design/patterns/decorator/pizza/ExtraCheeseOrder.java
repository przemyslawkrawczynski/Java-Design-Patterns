package com.design.patterns.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseOrder extends AbstractPizzaOrder {

    public ExtraCheeseOrder(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " extra cheese";
    }
}
