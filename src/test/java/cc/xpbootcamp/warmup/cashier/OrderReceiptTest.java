package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderReceiptTest {
    static final List<LineItem> DefaultLineItems = new ArrayList<LineItem>() {
        private static final long serialVersionUID = 1L;
        {
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }
    };

    @Test
    public void shouldNoDiscountWhenPrintOrderGivenOrderDateIsNotWednesday() {
        // 2020-02-17 is monday
        LocalDate orderDate = LocalDate.parse("2020-02-17");
        OrderReceipt receipt = createOrderReceiptWithDefaultLineItems(orderDate);
        String expected = "======老王超市，值得信赖======\n" +
                          "\n" +
                          "2020年2月17日, 星期一\n" +
                          "\n" +
                          "巧克力, 21.50×2, 43.00\n" +
                          "小白菜, 10.00×1, 10.00\n" +
                          "-----------------------\n" +
                          "税额: 5.30\n" +
                          "总价: 58.30\n";
        assertEquals(expected, receipt.printReceipt());
    }

    @Test
    public void shouldGetExpectInfomationWhenPrintOrderGivenOrderDateIsWednesday() {
        // 2020-02-19 is wednesday
        LocalDate orderDate = LocalDate.parse("2020-02-19");
        OrderReceipt receipt = createOrderReceiptWithDefaultLineItems(orderDate);
        String expected = "======老王超市，值得信赖======\n" +
                          "\n" +
                          "2020年2月19日, 星期三\n" +
                          "\n" +
                          "巧克力, 21.50×2, 43.00\n" +
                          "小白菜, 10.00×1, 10.00\n" +
                          "-----------------------\n" +
                          "税额: 5.30\n" +
                          "折扣: 1.17\n" +
                          "总价: 57.13\n";
        assertEquals(expected, receipt.printReceipt());
    }

    private OrderReceipt createOrderReceiptWithDefaultLineItems(LocalDate orderDate) {
        Order order = new Order("Fake Name", "Fake Address", orderDate, DefaultLineItems);
        return new OrderReceipt(order);
    }

}