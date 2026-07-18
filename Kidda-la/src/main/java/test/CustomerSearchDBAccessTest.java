package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.CustomerSearchDBAccess;
import model.Customer;

/**
 * 結合テスト 結合番号2
 * 対象 CustomerSearchDBAccess Customer
 */
public class CustomerSearchDBAccessTest {
	CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
	@Test
	void 電話番号検索でCustomerを組み立てて返せる() throws Exception {
		List<Customer> list = dao.searchCustomerByTel("09012345678");

		// 項番1:1件取得できているかどうか
		assertEquals(1, list.size());

		Customer c = list.get(0);
		// 項番2:custId
		assertEquals(1, c.getCustId());
		// 項番3:custName
		assertEquals("青木まゆみ", c.getCustName());
		// 項番4:kana
		assertEquals("アオキマユミ", c.getKana());
		// 項番5:address
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
		// 項番6:tel
		assertEquals("09012345678", c.getTel());
	}

	@Test
	void カナ検索でCustomerを組み立てて返せる() throws Exception{
		List<Customer> list = dao.searchCustomerByKana("アオキマユミ");
		
		// 項番1:1件取得できているかどうか
		assertEquals(1, list.size());
		
		Customer c = list.get(0); 
		// 項番2:custId
		assertEquals(1, c.getCustId());
		// 項番3:custName
		assertEquals("青木まゆみ", c.getCustName());
		// 項番4:kana
		assertEquals("アオキマユミ", c.getKana());
		// 項番5:address
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
		// 項番6:tel
		assertEquals("09012345678", c.getTel());
	}
	
	@Test
	void カナ電話番号検索でCustomerを組み立てて返せる() throws Exception{
		List<Customer> list = dao.searchCustomer("09012345678","アオキマユミ");
		
		// 項番1:1件取得できているかどうか
		assertEquals(1, list.size());
		
		Customer c = list.get(0); 
		// 項番2:custId
		assertEquals(1, c.getCustId());
		// 項番3:custName
		assertEquals("青木まゆみ", c.getCustName());
		// 項番4:kana
		assertEquals("アオキマユミ", c.getKana());
		// 項番5:address
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
		// 項番6:tel
		assertEquals("09012345678", c.getTel());
	}
}
