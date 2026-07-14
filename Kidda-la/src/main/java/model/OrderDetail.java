package model;

/**
 * 注文明細情報を保持するモデルクラス。　
 */
public class OrderDetail {
	// 注文ID
	private int orderId;
	// 商品ID
	private int itemId;
	// 商品名
	private String itemName;
	// 個数
	private int quantity;
	// 値段
	private int price;

	public OrderDetail() {
	}

	public OrderDetail(int orderId, int itemId, String itemName, int quantity, int price) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
