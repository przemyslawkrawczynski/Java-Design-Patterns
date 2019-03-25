package com.design.patterns.decorator.pizza;

import java.math.BigDecimal;

public class ExtraIngriedient extends AbstractPizzaOrder {

    public ExtraIngriedient(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " plus ingriedient";
    }
}

