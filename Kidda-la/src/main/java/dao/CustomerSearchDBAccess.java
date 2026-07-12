package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerSearchDBAccess {
	public static void main(String[] args) {
		try {
			CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
//			List<Customer> list = dao.searchCustomerByTel("0314142135");
			List<Customer> list = dao.searchCustomer("0314142135", "");
			System.out.println(list.size());
			for (Customer c : list) {
				System.out.println(c.getCustId() + c.getCustName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * データベースと接続をします。
	 * @throws Exception
	 */
	private Connection createConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/KIDDA_LA";
		String user = "user1";
		String pass = "pass1";

		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}

	/**
	 * データベースと切断します。
	 * @throws Exception
	 */
	private void closeConnection(Connection con) throws Exception {
		con.close();
	}

	/**
	 * 電話番号と検索結果が一致する顧客情報を返します。
	 * @param tel 電話番号
	 * @return cutomer 顧客情報
	 * @throws Exception
	 */
	public List<Customer> searchCustomerByTel(String tel) throws Exception {
		List<Customer> list = new ArrayList<>();
		Connection con = createConnection();
		String query = """
				SELECT CUSTID, CUSTNAME, KANA, ADDRESS
				FROM CUSTOMER
				WHERE TEL = ?
				""";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tel);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustId(rs.getInt("CUSTID"));
				customer.setCustName(rs.getString("CUSTNAME"));
				customer.setKana(rs.getString("KANA"));
				customer.setAddress(rs.getString("ADDRESS"));
				list.add(customer);
			}
		} finally {
			closeConnection(con);
		}
		return list;
	}

	public List<Customer> searchCustomer(String tel, String kana) throws Exception {
		List<Customer> list = new ArrayList<>();
		Connection con = createConnection();
		String query = """
				SELECT CUSTID, CUSTNAME, KANA, ADDRESS
				FROM CUSTOMER
				WHERE TEL = ? AND KANA LIKE ?
				""";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tel);
			ps.setString(2, "%" + kana + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustId(rs.getInt("CUSTID"));
				customer.setCustName(rs.getString("CUSTNAME"));
				customer.setKana(rs.getString("KANA"));
				customer.setAddress(rs.getString("ADDRESS"));
				list.add(customer);
			}
		} finally {
			closeConnection(con);
		}

		return list;
	}
}
