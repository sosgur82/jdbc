package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName( "oracle.jdbc.driver.OracleDriver" );

			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( url, "dev", "dev" );
			
			//3. Statement 준비
			String sql = 
					" insert" +
					"   into author" +
					" values( seq_author.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString( 1, "공자" );
			pstmt.setString( 2, "어쩌구저쩌구" );
			
			//5. SQL문 실행
			int count = pstmt.executeUpdate();
			
			//5. 성공유무
			System.out.println( count == 1 ? "성공" : "실패" );
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			//3.자원 정리
			try {
				if( pstmt != null ) {
					pstmt.close();
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
