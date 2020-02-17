package cc.xpbootcamp.warmup.cashier;

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
        appendLine(output, "%s%s", order.getCustomerName(), order.getCustomerAddress());
    }

    private void writeListItemToOutput(StringBuilder output) {
        order.getLineItems().forEach(lineItem -> {
            appendLine(output, "%s\t%.1f\t%d\t%.1f", lineItem.getDescription(), lineItem.getPrice(),
                    lineItem.getQuantity(), lineItem.totalAmount());
        });
    }

    private void wirteFooterToOutput(StringBuilder output) {
        double totalAmountNoTx = order.getLineItems().stream().mapToDouble(LineItem::totalAmount).sum();
        double totSalesTx = totalAmountNoTx * TaxSales;
        appendLine(output, "Sales Tax\t%.1f", totSalesTx);
        appendLine(output, "Total Amount\t%.1f", totalAmountNoTx + totSalesTx);
    }

    private void appendLine(StringBuilder output, String text, Object... args) {
        output.append(String.format(text, args));
        output.append('\n');
    }
}