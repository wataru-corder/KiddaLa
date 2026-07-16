package action;

import java.util.List;

import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

/**
 *  顧客検索用のアクションクラス
 */
public class CustomerSearchAction {
	/**
	 * 一致する電話番号またはカナに該当する顧客情報を返却する。
	 * @param data [0]電話番号 [1]カナ 
	 * @return	顧客情報
	 * @throws Exception
	 */
	public String[][] execute(String[] data) throws Exception {
		data[0] = data[0].replace(" ", "").replace("　", "");
		data[1] = data[1].replace(" ", "").replace("　", "");

		CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
		List<Customer> list;
		
		if (!data[0].isEmpty() && data[1].isEmpty()) {
			list = dao.searchCustomerByTel(data[0]);
		} else if (data[0].isEmpty() && !data[1].isEmpty()) {
			list = dao.searchCustomerByKana(data[1]);
		} else {
			list = dao.searchCustomer(data[0], data[1]);
		}

		String[][] tableData = OrderControlUtility.customerToArray(list);
		return tableData;
	}
}
