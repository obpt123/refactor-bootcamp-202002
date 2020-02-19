package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    public static final double TaxSales = .1d;
    public static final double DiscountPercent = .98d;

    private String cName;
    private String addr;
    private LocalDate date;
    private List<LineItem> lineItemList;

    public Order(String cName, String addr, LocalDate orderDate, List<LineItem> lineItemList) {
        if (orderDate == null) {
            throw new IllegalArgumentException("Order date should not be null.");
        }
        if (lineItemList == null) {
            throw new IllegalArgumentException("LineItems should not be null.");
        }
        if (lineItemList.contains(null)) {
            throw new IllegalArgumentException("LineItems should not contains null.");
        }
        this.cName = cName;
        this.addr = addr;
        this.date = orderDate;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public LocalDate getDate() {
        return date;
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
        return DayOfWeek.WEDNESDAY.equals(date.getDayOfWeek());
    }
}
