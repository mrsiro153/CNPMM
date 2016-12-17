package connectData;

import java.sql.*;

public class ConnectDatabase {
	private Connection conn;
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "activity";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "moonrider";

	public ResultSet GetData(String sql) throws Exception {
		ResultSet rs = null;
		if(conn.isClosed()){
			openconnect();
		}
		Statement st = conn.createStatement();
		try {
			rs = st.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			System.out.println(e);
		}
		conn.close();
		return rs;
	}

	public int update(String sql) throws Exception {
		int kq = 0;
		openconnect();
		Statement st = conn.createStatement();
		try {
			kq = st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeconnection();
		}
		return kq;
	}

	public ConnectDatabase() throws Exception {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void openconnect() throws Exception
	{
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			System.out.println(e);}
	}

	public void closeconnection() throws Exception {
		if (conn != null && !conn.isClosed())
			conn.close();
	}
}
