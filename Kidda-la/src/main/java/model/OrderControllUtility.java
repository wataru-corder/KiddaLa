package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * 注文管理用ユーティリティ
 * 
 */
public class OrderControllUtility {

	/**
	 * 顧客情報リストを検索結果表示用の二次元配列に変換する。
	 * <p>
	 * 各行は1件の顧客に対応し、列は
	 * [0]顧客Id [1]顧客名 [2]カナ [3]住所の順で格納する。
	 * </p>
	 * 
	 * @param list 顧客情報リスト
	 * @return 検索結果表示用の配列。該当がない場合は空配列で返す。
	 */
	public static String[][] customerToArray(List<Customer> list) {
		String[][] tableData = new String[0][0];
		if (!Objects.isNull(list) && !list.isEmpty()) {
			tableData = new String[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				Customer customer = list.get(i);
				tableData[i] = new String[] {
						// 顧客ID
						String.valueOf(customer.getCustId()),
						// 顧客名
						customer.getCustName(),
						// カナ
						customer.getKana(),
						// 住所
						customer.getAddress()
				};
			}
		}
		return tableData;
	}

	/**
	 * 商品リストを商品情報表示用の２次元配列に変換する。
	 * <p>
	 * 各行は1件の商品に対応し、列は
	 * [0]商品ID [1]商品名 [2]値段の順で格納する。
	 * </p>
	 * @param list 商品情報リスト
	 * @return 商品情報表示用の配列。該当がない場合は空配列で返す。
	 */
	public static String[][] itemToArray(List<Item> list) {
		String[][] tableData = new String[0][0];
		if (!Objects.isNull(list) && !list.isEmpty()) {
			tableData = new String[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				Item item = list.get(i);
				tableData[i] = new String[] {
						// 商品ID
						String.valueOf(item.getItemId()),
						// 商品名
						item.getItemName(),
						// 値段
						String.valueOf(item.getPrice())
				};
			}
		}
		return tableData;
	}

	/**
	 * 注文明細情報リストを注文明細情報表示用の２次元配列に変換する。
	 * <p>
	 * 各行は1件の注文明細情報に対応し、列は
	 * [0]注文ID [1]商品ID [2]商品名 [3]個数 [4]値段の順で格納する。
	 * </p>
	 * @param list 注文明細情報リスト
	 * @return 注文明細情報表示用の配列。該当がない場合は空配列で返す。
	 */
	public static String[][] orderToArray(List<OrderDetail> list) {
		String[][] tableData = new String[0][0];
		if (!Objects.isNull(list) && !list.isEmpty()) {
			tableData = new String[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				OrderDetail orderDetail = list.get(i);
				tableData[i] = new String[] {
						// 注文ID
						String.valueOf(orderDetail.getOrderId()),
						// 商品ID
						String.valueOf(orderDetail.getItemId()),
						// 商品名
						orderDetail.getItemName(),
						// 個数
						String.valueOf(orderDetail.getQuantity()),
						// 値段
						String.valueOf(orderDetail.getPrice())
				};
			}
		}
		return tableData;
	}

	/**
	 * 現在の日付を生成して返却する。
	 * @return 現在の日付（yyyy-mm-dd）
	 */
	public static String getDate() {
		String today = LocalDate.now().toString();
		return today;
	}

}
