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
    public static final double TaxSales = .1d;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        writeHeaderToOutput(output);
        writeListItemToOutput(output);
        wirteFooterToOutput(output);
        return output.toString();
    }

    private void writeHeaderToOutput(StringBuilder output) {
        appendLine(output, "======老王超市，值得信赖======");
        appendLine(output, "");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日, E", Locale.CHINA);
        appendLine(output,order.getDate().format(formatter));
        appendLine(output, "");
        appendLine(output, "%s%s", order.getCustomerName(), order.getCustomerAddress());
    }

    private void writeListItemToOutput(StringBuilder output) {
        order.getLineItems().forEach(lineItem -> {
            appendLine(output, "%s, %.2f×%d, %.2f", lineItem.getDescription(), lineItem.getPrice(),
                    lineItem.getQuantity(), lineItem.totalAmount());
        });
    }

    private void wirteFooterToOutput(StringBuilder output) {
        double totalAmountNoTx = order.getLineItems().stream().mapToDouble(LineItem::totalAmount).sum();
        double totSalesTx = totalAmountNoTx * TaxSales;
        appendLine(output, "税额: %.2f", totSalesTx);
        appendLine(output, "总价: %.2f", totalAmountNoTx + totSalesTx);
    }

    private void appendLine(StringBuilder output, String text, Object... args) {
        output.append(String.format(text, args));
        output.append('\n');
    }
}