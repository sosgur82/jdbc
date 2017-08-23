package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//1. JDBC 드라이버 로딩(JDBC 클래스 로딩)
			// Class.forName( "com.bigdata2017.jdbc.MyDriver" );
			Class.forName( "oracle.jdbc.driver.OracleDriver" );

			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( url, "hr", "hr" );
			
			System.out.println( "connection 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println( "연결실패 :" + e );
		} finally {
			//3.자원 정리
			try {
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
