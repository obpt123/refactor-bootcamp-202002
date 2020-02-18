package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private LocalDate date;
    private List<LineItem> lineItemList;

    public Order(String cName, String addr, LocalDate date, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.date = date;
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
}
