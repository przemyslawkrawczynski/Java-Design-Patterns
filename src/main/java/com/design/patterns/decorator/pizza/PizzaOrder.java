package com.design.patterns.decorator.pizza;

import java.math.BigDecimal;

public interface PizzaOrder {

    BigDecimal getCost();
    String getDescription();
}
