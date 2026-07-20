package test;

import action.CustomerSearchAction;

//単体番号3 CustomerSearchAction ドライバクラス
public class UnitTest_OrderControl03 {

	public static void main(String[] args) {
		CustomerSearchAction action = new CustomerSearchAction();
		try {
			// ===== 1/2 execute 項番1 =====
			// 【正常系】引数("09012345678", "タナカタロウ")を指定する。
			String[][] result1 = action.execute(new String[] {"09012345678", "タナカタロウ"});
			System.out.println(result1.length);
			System.out.println(result1[0][0]);

			// ===== 1/2 execute 項番2 =====
			// 【正常系】引数("", "タナカタロウ")を指定する。
			System.out.println("----------------------------");
			String[][] result2 = action.execute(new String[] {"", "タナカタロウ"});
			System.out.println(result2.length);
			System.out.println(result2[0][0]);

			// ===== 1/2 execute 項番3 =====
			// 【正常系】引数("09012345678", "")を指定する。
			System.out.println("----------------------------");
			String[][] result3 = action.execute(new String[] {"09012345678", ""});
			System.out.println(result3.length);
			System.out.println(result3[0][0]);

			// ===== 2/2 execute 項番4 =====
			// 【正常系】引数("00000000000", "ヤマモトユウスケ")を指定する。
			System.out.println("----------------------------");
			String[][] result4 = action.execute(new String[] {"00000000000", "ヤマモトユウスケ"});
			System.out.println(result4.length);

			// ===== 2/2 execute 項番5 =====
			// 【異常系】引数(null, null)を指定する。→ NullPointerException
			System.out.println("----------------------------");
			String[][] result5 = action.execute(new String[] {null, null});
			System.out.println(result5.length);

			// ===== 2/2 execute 項番6 =====
			// 【異常系】引数("", "")を指定する。
			System.out.println("----------------------------");
			String[][] result6 = action.execute(new String[] {"", ""});
			System.out.println(result6.length);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}