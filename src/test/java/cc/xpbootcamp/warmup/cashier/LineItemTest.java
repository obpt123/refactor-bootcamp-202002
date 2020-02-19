package cc.xpbootcamp.warmup.cashier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineItemTest {
    static final double delta = 0.000001;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDescriptionIsNull() {
        new LineItem(null, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDescriptionIsEmpty() {
        new LineItem("", 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPriceLessThan0() {
        new LineItem("fake desctiption", -1.0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenQuantityLessThan0() {
        new LineItem("fake desctiption", 1.0, -1);
    }

    @Test
    public void shouldReturnExpectedValueWhenGetTotalAmount() {
        LineItem lineItem = new LineItem("fake desctiption", 1.23, 3);
        assertEquals(3.69, lineItem.totalAmount(), delta);
    }
}