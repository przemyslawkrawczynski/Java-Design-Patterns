package com.design.patterns.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrder implements PizzaOrder {

    private final PizzaOrder pizzaOrder;

    public AbstractPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
