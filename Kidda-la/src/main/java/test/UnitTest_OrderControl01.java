package test;

import model.Customer;

//単体番号1 Customer ドライバクラス
public class UnitTest_OrderControl01 {

	public static void main(String[] args) {
		try {
			// ===== 1/11 コンストラクタ 項番1 =====
			// 【正常系】引数(1, "青木まゆみ", "アオキナユミ", "09012345678", "東京都千代田区神田小川町1-1-1")を指定する。
			Customer customer = new Customer(1, "青木まゆみ", "アオキナユミ",
					"09012345678", "東京都千代田区神田小川町1-1-1");
			System.out.println(customer.getCustId());
			System.out.println(customer.getCustName());
			System.out.println(customer.getKana());
			System.out.println(customer.getTel());
			System.out.println(customer.getAddress());

			// ===== 1/11 コンストラクタ 項番2 =====
			// 【正常系】引数(0, null, null, null, null)を指定する。
			System.out.println("----------------------------");
			Customer customer2 = new Customer(0, null, null, null, null);
			System.out.println(customer2.getCustId());
			System.out.println(customer2.getCustName());
			System.out.println(customer2.getKana());
			System.out.println(customer2.getTel());
			System.out.println(customer2.getAddress());

			// ===== 1/11 コンストラクタ 項番3 =====
			// 【正常系】引数()を指定する。
			System.out.println("----------------------------");
			Customer customer3 = new Customer();
			System.out.println(customer3.getCustId());
			System.out.println(customer3.getCustName());
			System.out.println(customer3.getKana());
			System.out.println(customer3.getTel());
			System.out.println(customer3.getAddress());

			// ===== 2/11 setCustId 項番4 =====
			// 【正常系】引数(2)を指定する。
			System.out.println("----------------------------");
			customer.setCustId(2);
			System.out.println(customer.getCustId());

			// ===== 2/11 setCustId 項番5 =====
			// 【正常系】引数(0)を指定する。
			System.out.println("----------------------------");
			customer.setCustId(0);
			System.out.println(customer.getCustId());

			// ===== 2/11 setCustId 項番6 =====
			// 【正常系】引数(-1)を指定する。
			System.out.println("----------------------------");
			customer.setCustId(-1);
			System.out.println(customer.getCustId());

			// ===== 3/11 getCustId 項番1 =====
			// 【正常系】custIdに1が設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setCustId(1);
			System.out.println(customer.getCustId());

			// ===== 3/11 getCustId 項番2 =====
			// 【正常系】custIdに0が設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setCustId(0);
			System.out.println(customer.getCustId());

			// ===== 4/11 setCustName 項番1 =====
			// 【正常系】引数("田中太郎")を指定する。
			System.out.println("----------------------------");
			customer.setCustName("田中太郎");
			System.out.println(customer.getCustName());

			// ===== 4/11 setCustName 項番2 =====
			// 【正常系】引数(null)を指定する。
			System.out.println("----------------------------");
			customer.setCustName(null);
			System.out.println(customer.getCustName());

			// ===== 4/11 setCustName 項番3 =====
			// 【正常系】引数("")を指定する。
			System.out.println("----------------------------");
			customer.setCustName("");
			System.out.println(customer.getCustName());

			// ===== 5/11 getCustName 項番1 =====
			// 【正常系】custNameに"田中太郎"が設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setCustName("田中太郎");
			System.out.println(customer.getCustName());

			// ===== 5/11 getCustName 項番2 =====
			// 【正常系】custNameにnullが設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setCustName(null);
			System.out.println(customer.getCustName());

			// ===== 6/11 setKana 項番1 =====
			// 【正常系】引数("タナカタロウ")を指定する。
			System.out.println("----------------------------");
			customer.setKana("タナカタロウ");
			System.out.println(customer.getKana());

			// ===== 6/11 setKana 項番2 =====
			// 【正常系】引数(null)を指定する。
			System.out.println("----------------------------");
			customer.setKana(null);
			System.out.println(customer.getKana());

			// ===== 6/11 setKana 項番3 =====
			// 【正常系】引数("")を指定する。
			System.out.println("----------------------------");
			customer.setKana("");
			System.out.println(customer.getKana());

			// ===== 7/11 getKana 項番1 =====
			// 【正常系】kanaに"タナカタロウ"が設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setKana("タナカタロウ");
			System.out.println(customer.getKana());

			// ===== 7/11 getKana 項番2 =====
			// 【正常系】kanaにnullが設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setKana(null);
			System.out.println(customer.getKana());

			// ===== 8/11 setTel 項番1 =====
			// 【正常系】引数("09012345678")を指定する。
			System.out.println("----------------------------");
			customer.setTel("09012345678");
			System.out.println(customer.getTel());

			// ===== 8/11 setTel 項番2 =====
			// 【正常系】引数(null)を指定する。
			System.out.println("----------------------------");
			customer.setTel(null);
			System.out.println(customer.getTel());

			// ===== 8/11 setTel 項番3 =====
			// 【正常系】引数("")を指定する。
			System.out.println("----------------------------");
			customer.setTel("");
			System.out.println(customer.getTel());

			// ===== 9/11 getTel 項番1 =====
			// 【正常系】telに"09012345678"が設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setTel("09012345678");
			System.out.println(customer.getTel());

			// ===== 9/11 getTel 項番2 =====
			// 【正常系】telにnullが設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setTel(null);
			System.out.println(customer.getTel());

			// ===== 10/11 setAddress 項番1 =====
			// 【正常系】引数("東京都千代田区神田小川町1-1-1")を指定する。
			System.out.println("----------------------------");
			customer.setAddress("東京都千代田区神田小川町1-1-1");
			System.out.println(customer.getAddress());

			// ===== 10/11 setAddress 項番2 =====
			// 【正常系】引数(null)を指定する。
			System.out.println("----------------------------");
			customer.setAddress(null);
			System.out.println(customer.getAddress());

			// ===== 10/11 setAddress 項番3 =====
			// 【正常系】引数("")を指定する。
			System.out.println("----------------------------");
			customer.setAddress("");
			System.out.println(customer.getAddress());

			// ===== 11/11 getAddress 項番1 =====
			// 【正常系】addressに"東京都千代田区神田小川町1-1-1"が設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setAddress("東京都千代田区神田小川町1-1-1");
			System.out.println(customer.getAddress());

			// ===== 11/11 getAddress 項番2 =====
			// 【正常系】addressにnullが設定された状態で呼び出す。
			System.out.println("----------------------------");
			customer.setAddress(null);
			System.out.println(customer.getAddress());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}