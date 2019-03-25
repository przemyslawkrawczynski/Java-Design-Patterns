package com.design.patterns.decorator.pizza;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaOrderWithExtraCheeseCost() {

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseOrder(pizzaOrder);

        //When
        BigDecimal getCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(17), getCost);

    }

    @Test
    public void testPizzaOrderWithExtraCheeseEndTwoExtraIngriedients() {

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseOrder(pizzaOrder);
        pizzaOrder = new ExtraIngriedient(pizzaOrder);
        pizzaOrder = new ExtraIngriedient(pizzaOrder);

        //When
        BigDecimal getCost = pizzaOrder.getCost();
        String desc = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(21), getCost);
        assertEquals("Basic pizza extra cheese plus ingriedient plus ingriedient", desc);
    }

}
