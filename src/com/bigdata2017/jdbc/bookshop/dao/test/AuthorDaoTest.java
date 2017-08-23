package com.bigdata2017.jdbc.bookshop.dao.test;

import java.util.List;

import com.bigdata2017.jdbc.bookshop.dao.AuthorDao;
import com.bigdata2017.jdbc.bookshop.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		testDelete();
		testInsert();
		testGetList();
	}
	
	public static void testDelete() {
		new AuthorDao().delete();
	}
	
	public static void testGetList() {
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.getList();
		for( AuthorVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void testInsert() {
		AuthorDao dao = new AuthorDao();
		
		AuthorVo vo = new AuthorVo();
		vo.setName( "스테파니메이어" );
		dao.insert(vo);

		vo.setName( "조정래" );
		dao.insert(vo);

		vo.setName( "김동인" );
		dao.insert(vo);
		
		vo.setName( "김난도" );
		dao.insert(vo);

		vo.setName( "천상병" );
		dao.insert(vo);
		
		vo.setName( "원수연" );
		dao.insert(vo);			
	}

}
