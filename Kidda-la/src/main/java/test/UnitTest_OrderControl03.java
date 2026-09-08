package test;

import action.CustomerSearchAction;

//単体番号3 CustomerSearchAction ドライバクラス
public class UnitTest_OrderControl03 {

	public static void main(String[] args) {
		CustomerSearchAction action = new CustomerSearchAction();

		// ===== 1/3 execute 項番1 =====
		// 【正常系】引数("09012345678", "アオキマユミ")を指定する。
		try {
			String[][] result1 = action.execute(new String[] {"09012345678", "アオキマユミ"});
			System.out.println("項番1: 件数 = " + result1.length);
		} catch (Exception e) {
			System.out.println("項番1: NG 予期しない例外");
			e.printStackTrace();
		}

		// ===== 1/3 execute 項番2 =====
		// 【正常系】引数("", "アオキマユミ")を指定する。
		System.out.println("----------------------------");
		try {
			String[][] result2 = action.execute(new String[] {"", "アオキマユミ"});
			System.out.println("項番2: 件数 = " + result2.length);
		} catch (Exception e) {
			System.out.println("項番2: NG 予期しない例外");
			e.printStackTrace();
		}

		// ===== 1/3 execute 項番3 =====
		// 【正常系】引数("09012345678", "")を指定する。
		System.out.println("----------------------------");
		try {
			String[][] result3 = action.execute(new String[] {"09012345678", ""});
			System.out.println("項番3: 件数 = " + result3.length);
		} catch (Exception e) {
			System.out.println("項番3: NG 予期しない例外");
			e.printStackTrace();
		}

		// ===== 2/3 execute 項番4 =====
		// 【正常系】引数("00000000000", "ヤマモトユウスケ")を指定する。該当なし → null
		System.out.println("----------------------------");
		try {
			String[][] result4 = action.execute(new String[] {"00000000000", "ヤマモトユウスケ"});
			System.out.println("項番4: null  = " + (result4 == null));
		} catch (Exception e) {
			System.out.println("項番4: NG 予期しない例外");
			e.printStackTrace();
		}

		// ===== 2/3 execute 項番5 =====
		// 【異常系】引数(null, null)を指定する。→ NullPointerException
		System.out.println("----------------------------");
		try {
			action.execute(new String[] {null, null});
			System.out.println("項番5: NG 例外が発生しなかった");
		} catch (NullPointerException e) {
			System.out.println("項番5: OK " + e.getMessage());
		} catch (Exception e) {
			System.out.println("項番5: NG 想定外の例外 " + e);
		}

		// ===== 2/3 execute 項番6 =====
		// 【異常系】引数("", "")を指定する。該当なし → null
		System.out.println("----------------------------");
		try {
			String[][] result6 = action.execute(new String[] {"", ""});
			System.out.println("項番6: null  = " + (result6 == null));
		} catch (Exception e) {
			System.out.println("項番6: NG 予期しない例外");
			e.printStackTrace();
		}

		// ===== 3/3 execute 項番7 =====
		// 【異常系】引数("")を指定する。要素数1 → IllegalArgumentException
		System.out.println("----------------------------");
		try {
			action.execute(new String[] {""});
			System.out.println("項番7: NG 例外が発生しなかった");
		} catch (IllegalArgumentException e) {
			System.out.println("項番7: OK " + e.getMessage());
		} catch (Exception e) {
			System.out.println("項番7: NG 想定外の例外 " + e);
		}
	}
}