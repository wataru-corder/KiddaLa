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

		// 項番1.1:検索結果が1件取得できること
		assertEquals(1, list.size());

		Customer c = list.get(0);
		// 項番1.2:custId
		assertEquals(1, c.getCustId());
		// 項番1.3:custName
		assertEquals("青木まゆみ", c.getCustName());
		// 項番1.4:kana
		assertEquals("アオキマユミ", c.getKana());
		// 項番1.5:address
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
		// 項番1.6:tel
		assertEquals("09012345678", c.getTel());
	}

	@Test
	void 電話番号検索でnullを渡しても例外は発生せず空リストが返る() {
		// 項番1.7:例外が発生せず空リストで返却されること
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomerByTel(null);
			assertTrue(list.isEmpty());
		});
	}

	@Test
	void カナ検索でCustomerを組み立てて返せる() throws Exception {
		List<Customer> list = dao.searchCustomerByKana("アオキマユミ");

		// 項番2.1:検索結果が1件取得できること
		assertEquals(1, list.size());

		Customer c = list.get(0);
		// 項番2.2:custId
		assertEquals(1, c.getCustId());
		// 項番2.3:custName
		assertEquals("青木まゆみ", c.getCustName());
		// 項番2.4:kana
		assertEquals("アオキマユミ", c.getKana());
		// 項番2.5:address
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
		// 項番2.6:tel
		assertEquals("09012345678", c.getTel());
	}
	
	@Test
	void カナ検索でnullを渡しても例外は発生せず空のリストが返る() {
		// 項番2.7:例外が発生せず空リストで返却されること
		assertDoesNotThrow(() ->{
			List<Customer> list = dao.searchCustomerByKana(null);
			assertTrue(list.isEmpty());
		});
	}

	@Test
	void カナ電話番号検索でCustomerを組み立てて返せる() throws Exception {

		List<Customer> list = dao.searchCustomer("09012345678", "アオキマユミ");

		// 項番3.1:検索結果が1件取得できること
		assertEquals(1, list.size());

		Customer c = list.get(0);
		// 項番3.2:custId
		assertEquals(1, c.getCustId());
		// 項番3.3:custName
		assertEquals("青木まゆみ", c.getCustName());
		// 項番3.4:kana
		assertEquals("アオキマユミ", c.getKana());
		// 項番3.5:address
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
		// 項番3.6:tel
		assertEquals("09012345678", c.getTel());
	}

	@Test
	void カナ電話番号検索でnullを渡しても例外は発生せず空のリストが返る() {
		// 項番3.7:例外が発生せず空リストで返却されること
		assertDoesNotThrow(() ->{
			List<Customer> list = dao.searchCustomer(null, null);
			assertTrue(list.isEmpty());
		});
	}
}
