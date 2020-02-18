package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemsInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {
            {
                add(new LineItem("milk", 10.0, 2));
                add(new LineItem("biscuits", 5.0, 5));
                add(new LineItem("chocolate", 20.0, 1));
            }
        };
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, LocalDate.of(2020, 2, 17), lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk, 10.00×2, 20.00\n"));
        assertThat(output, containsString("biscuits, 5.00×5, 25.00\n"));
        assertThat(output, containsString("chocolate, 20.00×1, 20.00\n"));
    }

    @Test
    public void shouldPrintSalesAndTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {
            {
                add(new LineItem("milk", 10.0, 2));
                add(new LineItem("biscuits", 5.0, 5));
                add(new LineItem("chocolate", 20.0, 1));
            }
        };
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, LocalDate.of(2020, 2, 17), lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("税额: 6.50"));
        assertThat(output, containsString("总价: 71.50"));
    }

    @Test
    public void shouldPrintAdInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", LocalDate.of(2020, 2, 17), new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();
        assertThat(output, containsString("======老王超市，值得信赖======"));
    }

    @Test
    public void shouldPrintDateInfomationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", LocalDate.of(2020, 2, 17), new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();
        assertThat(output, containsString("2020年2月17日, 星期一"));
    }

    @Test
    public void shouldPrintExpectInfomationOnOrder() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {
            {
                add(new LineItem("巧克力", 21.5, 2));
                add(new LineItem("小白菜", 10.0, 1));
            }
        };
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, LocalDate.of(2020, 2, 17), lineItems));

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
    public void shouldHas98PercentDiscountWhenPrintOrderAndGivenOrderDateIsWednesday(){
        List<LineItem> lineItems = new ArrayList<LineItem>() {
            {
                add(new LineItem("巧克力", 21.5, 2));
                add(new LineItem("小白菜", 10.0, 1));
            }
        };
        // 2020-2-19 is wednesday
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, LocalDate.of(2020, 2, 19), lineItems));
        String output = receipt.printReceipt();

        assertThat(output, containsString("税额: 5.30"));
        assertThat(output, containsString("折扣: 1.17"));
        assertThat(output, containsString("总价: 57.13"));
    }

}