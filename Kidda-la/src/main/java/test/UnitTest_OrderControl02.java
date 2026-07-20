package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.CustomerSearchDBAccess;
import model.Customer;

/**
 * 単体テスト 単体番号2
 * 対象 CustomerSearchDBAccess
 */
public class UnitTest_OrderControl02 {
	CustomerSearchDBAccess dao = new CustomerSearchDBAccess();

	// ===== 1/6 searchCustomerByTel =====

	// 項番1【正常系】引数("09012345678")
	@Test
	void byTel_該当ありで各getterの値がDB登録値と一致すること() throws Exception {
		List<Customer> list = dao.searchCustomerByTel("09012345678");

		assertEquals(1, list.size(), "取得件数が1件ではない");
		Customer c = list.get(0);
		assertEquals(1, c.getCustId());
		assertEquals("青木まゆみ", c.getCustName());
		assertEquals("アオキマユミ", c.getKana());
		assertEquals("09012345678", c.getTel(), "telがDB登録値と一致しない");
		assertEquals("東京都千代田区神田小川町1-1-1", c.getAddress());
	}

	// 項番2【正常系】引数("00000000000") 
	@Test
	void byTel_存在しない電話番号では空のリストが返ること() throws Exception {
		List<Customer> list = dao.searchCustomerByTel("00000000000");
		assertTrue(list.isEmpty(), "空のリストが返却されていない");
	}

	// 項番3【異常系】引数(null)
	@Test
	void byTel_nullでも例外は発生せず空のリストが返ること() {
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomerByTel(null);
			assertTrue(list.isEmpty());
		});
	}

	// 項番4【異常系】引数("")
	@Test
	void byTel_空文字でも例外は発生せず空のリストが返ること() {
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomerByTel("");
			assertTrue(list.isEmpty(), "TEL完全一致のため空文字は0件のはず");
		});
	}

	// ===== 3/6〜4/6 searchCustomerByKana =====

	// 項番5【正常系】引数("スズキヒロシ")
	@Test
	void byKana_完全文字列で2件取得できkanaが一致すること() throws Exception {
		List<Customer> list = dao.searchCustomerByKana("スズキヒロシ");

		assertEquals(2, list.size(), "取得件数が2件ではない");
		for (Customer c : list) {
			assertEquals("スズキヒロシ", c.getKana());
		}
	}

	// 項番6【正常系】引数("スズキ") ※部分文字列
	@Test
	void byKana_部分文字列でスズキを含む3件が取得できること() throws Exception {
		List<Customer> list = dao.searchCustomerByKana("スズキ");

		assertEquals(3, list.size(), "部分一致の取得件数が3件ではない");
		for (Customer c : list) {
			assertTrue(c.getKana().contains("スズキ"),
					"カナに'スズキ'を含まないレコードが混入: " + c.getKana());
		}
	}

	// 項番7【正常系】引数("ヤマモトユウスケ") ※存在しないカナ
	@Test
	void byKana_存在しないカナでは空のリストが返ること() throws Exception {
		List<Customer> list = dao.searchCustomerByKana("ヤマモトユウスケ");
		assertTrue(list.isEmpty());
	}

	// 項番8【異常系】引数("") ※LIKE部分一致のため全件【仕様確認中】
	@Test
	void byKana_空文字では例外は発生せず全件が返ること() {
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomerByKana("");
			assertEquals(17, list.size(), "全件(現DB17件)が返却されていない");
		});
	}

	// 項番9【異常系】引数(null)
	@Test
	void byKana_nullでも例外は発生せず空のリストが返ること() {
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomerByKana(null);
			assertTrue(list.isEmpty());
		});
	}

	// ===== 5/6〜6/6 searchCustomer =====

	// 項番10【正常系】マトリクスNo.1(TEL一致=真/KANA一致=真)
	@Test
	void search_両条件一致で1件取得できtelを含む値が一致すること() throws Exception {
		List<Customer> list = dao.searchCustomer("09012345678", "アオキ");

		assertEquals(1, list.size(), "取得件数が1件ではない");
		Customer c = list.get(0);
		assertEquals(1, c.getCustId());
		assertEquals("09012345678", c.getTel(), "telがDB登録値と一致しない");
	}

	// 項番11【正常系】マトリクスNo.2(真/偽)
	@Test
	void search_telのみ一致では空のリストが返ること() throws Exception {
		List<Customer> list = dao.searchCustomer("09012345678", "ヤマモトユウスケ");
		assertTrue(list.isEmpty());
	}

	// 項番12【正常系】マトリクスNo.3(偽/真)
	@Test
	void search_kanaのみ一致では空のリストが返ること() throws Exception {
		List<Customer> list = dao.searchCustomer("00000000000", "アオキ");
		assertTrue(list.isEmpty());
	}

	// 項番13【正常系】マトリクスNo.4(偽/偽)
	@Test
	void search_両条件不一致では空のリストが返ること() throws Exception {
		List<Customer> list = dao.searchCustomer("00000000000", "ヤマモトユウスケ");
		assertTrue(list.isEmpty());
	}

	// 項番14【異常系】引数(null, null)
	@Test
	void search_null同士でも例外は発生せず空のリストが返ること() {
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomer(null, null);
			assertTrue(list.isEmpty());
		});
	}

	// 項番15【異常系】引数("", "")
	@Test
	void search_空文字同士でも例外は発生せず空のリストが返ること() {
		assertDoesNotThrow(() -> {
			List<Customer> list = dao.searchCustomer("", "");
			assertTrue(list.isEmpty(), "TEL完全一致(空文字)のため0件のはず");
		});
	}
}