package boardone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnUtil {
	private static DataSource ds;
	
	static {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myOracle");
		}catch (NamingException e) {
			// TODO: handle exception
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//Context init = new InitialContext();
			String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
			String id = "system";
			String pass = "1234";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			
			//ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
			//conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection 생성실패");
		}
		
		return conn;
	}
}
