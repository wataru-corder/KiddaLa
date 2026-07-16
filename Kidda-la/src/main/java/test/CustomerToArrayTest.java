package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Customer;
import model.OrderControlUtility;

/**
 * 結合テスト 結合番号1
 * 対象 OrderControlUtility Customer
 */
public class CustomerToArrayTest {
	@Test
	void customerToArray_1件を正しく変換できる() {
		List<Customer> list = new ArrayList<>();

		Customer c = new Customer();
		c.setCustId(1);
		c.setCustName("山田太郎");
		c.setKana("ヤマダタロウ");
		c.setAddress("東京都北区");
		list.add(c);

		// 実行
		String[][] result = OrderControlUtility.customerToArray(list);

		// 検証(項番2~5に対応)
		// 項番2:custId
		assertEquals("1", result[0][0]);
		// 項番3:custName
		assertEquals("山田太郎", result[0][1]);
		// 項番4:kana
		assertEquals("ヤマダタロウ", result[0][2]);
		// 項番5:address
		assertEquals("東京都北区", result[0][3]);
	}

}
