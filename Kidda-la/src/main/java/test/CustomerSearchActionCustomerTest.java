package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import action.CustomerSearchAction;

/**
* 結合テスト 結合番号4
* 対象 CustomerSearchAction Customer
*/
public class CustomerSearchActionCustomerTest {
	CustomerSearchAction action = new CustomerSearchAction();
	
	@Test
	void Customerの各getterの値の各列に届くこと() throws Exception{
		String[] data = { "09012345678", ""};
		String[][] result = action.execute(data); 
		
		// 項番1.1:Customerが(CustomerToArray内で)使用され例外が発生しないこと
		assertEquals(1, result.length);
		// 項番2.1:cust_idの値(1)とと一致すること
		assertEquals("1",result[0][0]);
		// 項番2.2:cust_nameの値(青木まゆみ)と一致すること
		assertEquals("青木まゆみ", result[0][1]);
		// 項番2.3:kanaの値(アオキマユミ)と一致すること
		assertEquals("アオキマユミ", result[0][2]);
		// 項番2.4:addressの値(東京都千代田区神田小川町1-1-1)と一致すること
		assertEquals("東京都千代田区神田小川町1-1-1", result[0][3]);
	}
}
