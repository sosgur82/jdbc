package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//1. JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName( "oracle.jdbc.driver.OracleDriver" );

			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( url, "dev", "dev" );
			
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			
			//4. SQL문 실행
			String name = "도우넛";
			Long no = 12L;
			
			String sql = 
				"update author" +
				"   set name='" + name + "'" +
				" where no = " + no;
			
			int count = stmt.executeUpdate(sql);
			
			//5. 성공유무
			System.out.println( count == 1 ? "성공" : "실패" );
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			//3.자원 정리
			try {
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
