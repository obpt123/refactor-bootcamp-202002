package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    public static final double TaxSales = .1d;
    public static final double DiscountPercent = .98d;

    private String customerName;
    private String customerAddress;
    private LocalDate orderDate;
    private List<LineItem> lineItemList;

    public Order(String customerName, String customerAddress, LocalDate orderDate, List<LineItem> lineItemList) {
        if (orderDate == null) {
            throw new IllegalArgumentException("Order date should not be null.");
        }
        if (lineItemList == null) {
            throw new IllegalArgumentException("LineItems should not be null.");
        }
        if (lineItemList.contains(null)) {
            throw new IllegalArgumentException("LineItems should not contains null.");
        }
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public double originalTotalAmount() {
        return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public double originalTotalAmountWithTax() {
        return originalTotalAmount() * (1 + TaxSales);
    }

    public double totalTax() {
        return originalTotalAmount() * TaxSales;
    }

    public double totalAmount() {
        return hasDiscount() ? originalTotalAmountWithTax() * DiscountPercent : originalTotalAmountWithTax();
    }

    public double totalDiscount() {
        return hasDiscount() ? originalTotalAmountWithTax() * (1 - DiscountPercent) : 0;
    }

    public boolean hasDiscount() {
        return DayOfWeek.WEDNESDAY.equals(orderDate.getDayOfWeek());
    }
}
