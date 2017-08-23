package com.bigdata2017.jdbc.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bigdata2017.jdbc.bookshop.vo.BookVo;

public class BookDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			// JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "dev", "dev");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
	
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = 
				"  select a.no, a.title, a.state, b.name" + 
				"    from book a," + 
				"	      author b" + 
				"    where a.author_no = b.no" + 
				" order by a.no";
			rs = stmt.executeQuery( sql );
			
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String title = rs.getString( 2 );
				String state = rs.getString( 3 );
				String authorName = rs.getString( 4 );
				
				BookVo vo = new BookVo();
				vo.setNo( no );
				vo.setTitle( title );
				vo.setState( state );
				vo.setAuthorName( authorName );
				
				list.add( vo );
			}
		} catch( SQLException e ) {
			System.out.println( "error:" + e );
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
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
		
		return list;
	}
	
	public int delete() {
		int count = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL문 실행
			String sql = "delete from book";
			count = stmt.executeUpdate( sql );

		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			// 자원 정리
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
		
		return count;
	}
	
	public int insert( BookVo vo ) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			// Statement 준비
			String sql = 
				" insert" + 
				"   into book" +
				" values (seq_book.nextval, ?, ?, ?)";			
			pstmt = conn.prepareStatement( sql );
			
			// binding
			pstmt.setString( 1, vo.getTitle() );
			pstmt.setString( 2, vo.getState() );
			pstmt.setLong( 3, vo.getAuthorNo() );
			
			// SQL문 실행
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			// 자원 정리
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
		
		return count;
	}
	
	public int updateState( Long no, String state ) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			// Statement 준비
			String sql = 
				" update book" +
				"    set state = ?" +
				"  where no=?";			
			pstmt = conn.prepareStatement( sql );
			
			// binding
			pstmt.setString( 1, state );
			pstmt.setLong( 2, no );
			
			// SQL문 실행
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			// 자원 정리
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
		
		return count;
	}
}
