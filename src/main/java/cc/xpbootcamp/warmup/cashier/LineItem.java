package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		if (description == null || "".equals(description)) {
			throw new IllegalArgumentException("The description should not be null or empty.");
		}
		if (price < 0) {
			throw new IllegalArgumentException("The price should not less than 0.");
		}
		if (quantity < 0) {
			throw new IllegalArgumentException("The quantity should not less than 0.");
		}
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double totalAmount() {
		return price * quantity;
	}
}