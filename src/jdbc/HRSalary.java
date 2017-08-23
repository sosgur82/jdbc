package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSalary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName( "oracle.jdbc.driver.OracleDriver" );

			// 2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( url, "hr", "hr" );
			
			// 3. Statement 준비
			String sql = 
					" select first_name," +
					"        last_name," +
					"        salary" +		
					"   from employees" +
					"  where ? <= salary" +
					"    and salary <= ?";
			pstmt = conn.prepareStatement( sql );
			
			while( true ) {
				//4. 입력값 받기 및 바인딩
				System.out.print( "(min max) >> " );
				int minSalary = scanner.nextInt();
				int maxSalary = scanner.nextInt();
				
				pstmt.setInt( 1, minSalary );
				pstmt.setInt( 2, maxSalary );
				
				//5. SQL문 실행
				rs = pstmt.executeQuery();
		
				//6. 결과 처리
				System.out.println( "=============================" );
				while( rs.next() ) {
					String firstName = rs.getString( 1 );
					String lastName = rs.getString( 2 );
					int salary = rs.getInt( 3 );
					
					String result = String.format("%-20s %d", firstName + " " + lastName, salary );
					System.out.println( result );
				}
				System.out.println( "" );
			}
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch ( SQLException e ) {
			System.out.println( "error :" + e );
		} finally {
			//3.자원 정리
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
				
				scanner.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
