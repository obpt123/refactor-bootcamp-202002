package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address,
 * description, quantity, price and amount. It also calculates the sales tax @
 * 10% and prints as part of order. It computes the total order amount (amount
 * of individual lineItems + total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(generateHeader());
        output.append(generateListItems());
        output.append(generateFooter());
        return output.toString();
    }

    private String generateHeader() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日, EEEE", Locale.CHINA);
        return formatLine("======老王超市，值得信赖======") 
                + formatLine("")
                + formatLine(order.getOrderDate().format(formatter)) 
                + formatLine("");
    }

    private String generateListItems() {
        return order.getLineItems().stream().map(this::generateListItem).collect(Collectors.joining());
    }

    private String generateListItem(LineItem lineItem) {
        return formatLine("%s, %.2f×%d, %.2f", lineItem.getDescription(), lineItem.getPrice(), lineItem.getQuantity(),
                lineItem.totalAmount());
    }

    private String generateFooter() {
        return formatLine("-----------------------") 
                + formatLine("税额: %.2f", order.totalTax())
                + formatLineIf(order.hasDiscount(), "折扣: %.2f", order.totalDiscount())
                + formatLine("总价: %.2f", order.totalAmount());
    }

    private String formatLine(String text, Object... args) {
        return String.format(text, args) + '\n';
    }

    private String formatLineIf(Boolean condition, String text, Object... args) {
        return condition ? formatLine(text, args) : "";
    }
}