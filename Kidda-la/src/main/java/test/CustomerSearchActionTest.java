package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import action.CustomerSearchAction;

/**
 * 結合テスト 結合番号3
 * 対象 CustomerSearchAction CustomerSearchDBAccess
 */
public class CustomerSearchActionTest {
	CustomerSearchAction action = new CustomerSearchAction();

	// 項番1.1:検索結果が、{"1", "青木まゆみ", "アオキマユミ","東京都千代田区神田小川町1-1-1"}と一致すること
	@Test
	void 電話番号検索で該当の顧客データが返ること() throws Exception {
		String[] data = { "09012345678", "" };
		String[][] result = action.execute(data);

		assertArrayEquals(
				new String[] { "1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町1-1-1" },
				result[0]);
	}

	// 項番1.2:検索結果が、{"1", "青木まゆみ", "アオキマユミ","東京都千代田区神田小川町1-1-1"}と一致すること
	@Test
	void カナ検索で該当の顧客データが返ること() throws Exception {
		String[] data = { "", "アオキ" };
		String[][] result = action.execute(data);

		assertArrayEquals(
				new String[] { "1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町1-1-1" },
				result[0]);
	}

	// 項番1.3:検索結果が、{"1", "青木まゆみ", "アオキマユミ","東京都千代田区神田小川町1-1-1"}と一致すること
	@Test
	void カナ電話番号検索で該当の顧客データが返ること() throws Exception {

		String[] data = { "09012345678", "アオキ" };
		String[][] result = action.execute(data);

		assertArrayEquals(
				new String[] { "1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町1-1-1" },
				result[0]);
	}
	
	// 項番2.1:半角空白が除去され、検索結果が、{"1", "青木まゆみ", "アオキマユミ","東京都千代田区神田小川町1-1-1"}と一致すること
	@Test
	void 半角空白が除去され該当の顧客データが返ること() throws Exception {
		String[] data = { "0901234 5678", "" };
		String[][] result = action.execute(data);

		assertArrayEquals(
				new String[] { "1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町1-1-1" },
				result[0]);
	}
	
	// 項番2.2:全角空白が検索結果が、{"1", "青木まゆみ", "アオキマユミ","東京都千代田区神田小川町1-1-1"}と一致すること
	@Test
	void 全角空白が除去され該当の顧客データが返ること() throws Exception {
		String[] data = { "0901234　5678", "" };
		String[][] result = action.execute(data);

		assertArrayEquals(
				new String[] { "1", "青木まゆみ", "アオキマユミ", "東京都千代田区神田小川町1-1-1" },
				result[0]);
	}
	
	// 項番3.1:NullPointerExceptionが送出されること
	@Test
	void 引数がnullの場合はNullPointerExceptionが送出される() {
		assertThrows(NullPointerException.class, () -> action.execute(null));
	}
	
	// 項番3.2:NullPointerExceptionが送出されること
	@Test
	void 要素がnullの場合はNullPointerExceptionが送出される() {
		assertThrows(NullPointerException.class, () -> action.execute(new String[]{null, null}));
	}
	
	// 項番3.3:IllegalArgumentExceptionが送出されること
	@Test
	void 要素数が不足する場合はIllegalArgumentExceptionが送出される() {
		assertThrows(IllegalArgumentException.class,
			() -> action.execute(new String[]{"09012345678"}));
	}
	
	// 項番4.1:該当なしの場合はnullが返却されること
	@Test
	void 存在しない電話番号ではnullが返却されること() throws Exception {
		String[] data = { "00000000000", "" };
		String[][] result = action.execute(data);
		assertNull(result, "該当なし時にnullが返却されていない");
	}
}
