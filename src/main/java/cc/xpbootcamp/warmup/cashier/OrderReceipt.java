package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
        writeHeaderToOutput(output);
        writeListItemToOutput(output);
        writeFooterToOutput(output);
        return output.toString();
    }

    private void writeHeaderToOutput(StringBuilder output) {
        appendLine(output, "======老王超市，值得信赖======");
        appendLine(output, "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日, EEEE", Locale.CHINA);
        appendLine(output, order.getOrderDate().format(formatter));
        appendLine(output, "");
    }

    private void writeListItemToOutput(StringBuilder output) {
        order.getLineItems().forEach(lineItem -> {
            appendLine(output, "%s, %.2f×%d, %.2f", lineItem.getDescription(), lineItem.getPrice(),
                    lineItem.getQuantity(), lineItem.totalAmount());
        });
    }

    private void writeFooterToOutput(StringBuilder output) {
        appendLine(output, "-----------------------");
        appendLine(output, "税额: %.2f", order.totalTax());
        if (order.hasDiscount()) {
            appendLine(output, "折扣: %.2f", order.totalDiscount());
        }
        appendLine(output, "总价: %.2f", order.totalAmount());
    }

    private void appendLine(StringBuilder output, String text, Object... args) {
        output.append(String.format(text, args) + '\n');
    }
}