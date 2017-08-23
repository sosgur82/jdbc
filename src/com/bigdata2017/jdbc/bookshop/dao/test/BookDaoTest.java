package com.bigdata2017.jdbc.bookshop.dao.test;

import java.util.List;
import com.bigdata2017.jdbc.bookshop.dao.BookDao;
import com.bigdata2017.jdbc.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testDelete();
		testInsert();
		testGetList();
	}

	public static void testDelete() {
		new BookDao().delete();
	}
	
	public static void testInsert() {
		BookDao dao = new BookDao();
		
		BookVo vo = new BookVo();
		
		vo.setTitle( "트와일라잇" );
		vo.setAuthorNo( 1L );
		vo.setState( "대여가능" );
		dao.insert(vo);
		
		vo.setTitle( "뉴문" );
		vo.setAuthorNo( 1L );
		vo.setState( "대여가능" );
		dao.insert(vo);
		
		vo.setTitle( "이클립스" );
		vo.setAuthorNo( 1L );
		vo.setState( "대여가능" );
		dao.insert(vo);		

		vo.setTitle( "브레이킹던" );
		vo.setAuthorNo( 1L );
		vo.setState( "대여가능" );
		dao.insert(vo);	
		
		vo.setTitle( "아리랑" );
		vo.setAuthorNo( 2L );
		vo.setState( "대여가능" );
		dao.insert(vo);	
		
		vo.setTitle( "태백산맥" );
		vo.setAuthorNo( 2L );
		vo.setState( "대여가능" );
		dao.insert(vo);
		
		vo.setTitle( "젊은그들" );
		vo.setAuthorNo( 3L );
		vo.setState( "대여가능" );
		dao.insert(vo);	
		
		vo.setTitle( "아프니까 청춘이다" );
		vo.setAuthorNo( 4L );
		vo.setState( "대여가능" );
		dao.insert(vo);
		
		vo.setTitle( "귀천" );
		vo.setAuthorNo( 5L );
		vo.setState( "대여가능" );
		dao.insert(vo);	
		
		vo.setTitle( "풀하우스" );
		vo.setAuthorNo( 6L );
		vo.setState( "대여가능" );
		dao.insert(vo);			
	}

	public static void testGetList() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		for( BookVo vo : list ) {
			System.out.println( vo );
		}
	}	
}
