package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    static final double delta = 0.000001;
    static final List<LineItem> DefaultLineItems = new ArrayList<LineItem>() {
        private static final long serialVersionUID = 1L;
        {
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }
    };
    static final LocalDate AWednesday = LocalDate.parse("2020-02-19");
    static final LocalDate NotAWednesday = LocalDate.parse("2020-02-17");
    
    @Test
    public void shouldGetExpectedValueWhenGetOriginalTotalAmountGivenSomeLineItems() {
        Order order = createOrderWithDefaultLineItems(LocalDate.now());
        assertEquals(65.0, order.originalTotalAmount(), delta);
    }

    @Test
    public void shouldGetExpectedValueWhenGetTotalTaxGivenSomeLineItems() {
        Order order = createOrderWithDefaultLineItems(LocalDate.now());
        assertEquals(6.50, order.totalTax(), delta);
    }

    @Test
    public void shouldGetExpectedValueWhenGetOriginalTotalAmountWithTaxGivenSomeLineItems() {
        Order order = createOrderWithDefaultLineItems(LocalDate.now());
        assertEquals(71.5, order.originalTotalAmountWithTax(), delta);
    }

    @Test
    public void shouldHasDiscountWhenOrderDateIsWednesday() {
        Order order = createOrderWithDefaultLineItems(AWednesday);
        assertEquals(true, order.hasDiscount());
    }

    @Test
    public void shouldNoDiscountWhenOrderDateIsNotWednesday() {
        Order order = createOrderWithDefaultLineItems(NotAWednesday);
        assertEquals(false, order.hasDiscount());
    }

    @Test
    public void shouldGetExpectedValueWhenGetTotalDiscountGivenOrderDateIsWednesday() {
        Order order = createOrderWithDefaultLineItems(AWednesday);
        assertEquals(1.43, order.totalDiscount(), delta);
    }

    @Test
    public void shouldGet0WhenGetTotalDiscountGivenOrderDateIsNotWednesday() {
        Order order = createOrderWithDefaultLineItems(NotAWednesday);
        assertEquals(0, order.totalDiscount(), delta);
    }

    @Test
    public void shouldGetExpectedValueWhenGetTotalAmountGivenOrderDateIsNotWednesday() {
        Order order = createOrderWithDefaultLineItems(NotAWednesday);
        assertEquals(71.5, order.totalAmount(), delta);
    }

    @Test
    public void shouldGetExpectedValueWhenGetTotalAmountGivenOrderDateIsWednesday() {
        Order order = createOrderWithDefaultLineItems(AWednesday);
        assertEquals(70.07, order.totalAmount(), delta);
    }

    private Order createOrderWithDefaultLineItems(LocalDate orderDate) {
        return new Order("Fake Name", "Fake Address", orderDate, DefaultLineItems);
    }
}