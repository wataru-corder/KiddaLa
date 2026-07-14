package model;

/**
 * 商品情報を保持するモデルクラス
 */
public class Item {
	// 商品ID
	private int itemId;
	// 商品名
	private String itemName;
	// 値段
	private int price;

	public Item() {

	}

	public Item(int itemId, String itemName, int price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
