package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerSearchDBAccess {

	/**
	 * データベースと接続をする。
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
	 * データベースと切断する。
	 * @throws Exception
	 */
	private void closeConnection(Connection con) throws Exception {
		con.close();
	}

	/**
	 * 電話番号と検索結果が一致する顧客情報を返す。
	 * @param tel 電話番号
	 * @return cutomer 顧客情報
	 * @throws Exception
	 */
	public List<Customer> searchCustomerByTel(String tel) throws Exception {
		List<Customer> list = new ArrayList<>();
		Connection con = createConnection();
		String query = """
				SELECT CUSTID, CUSTNAME, KANA, ADDRESS, TEL
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
				customer.setTel(rs.getString("TEL"));
				list.add(customer);
			}
		} finally {
			closeConnection(con);
		}
		return list;
	}

	/**
	 * カナを含む検索結果が一致する顧客情報を返す。
	 * @param kana
	 * @return
	 * @throws Exception
	 */
	public List<Customer> searchCustomerByKana(String kana) throws Exception {
		List<Customer> list = new ArrayList<>();
		Connection con = createConnection();
		String query = """
				SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS
				FROM CUSTOMER
				WHERE KANA = ?
				""";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, kana);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustId(rs.getInt("CUSTID"));
				customer.setCustName(rs.getString("CUSTNAME"));
				customer.setKana(rs.getString("KANA"));
				customer.setTel(rs.getString("TEL"));
				customer.setAddress(rs.getString("ADDRESS"));
				list.add(customer);
			}
		} finally {
			closeConnection(con);
		}
		return list;
	}

	/**
	 * 電話番号と一致かつカナを含む検索結果が一致する顧客情報を返す。
	 * @param tel
	 * @param kana
	 * @return
	 * @throws Exception
	 */
	public List<Customer> searchCustomer(String tel, String kana) throws Exception {
		List<Customer> list = new ArrayList<>();
		Connection con = createConnection();
		String query = """
				SELECT CUSTID, CUSTNAME, KANA, ADDRESS, TEL
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
				customer.setTel(rs.getString("TEL"));
				list.add(customer);
			}
		} finally {
			closeConnection(con);
		}

		return list;
	}
}
