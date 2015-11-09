package com.bit2015.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.jblog.vo.BlogUserVo;
import com.bit2015.jblog.vo.BlogVo;

@Repository
public class MainDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<BlogVo> searchByTitle(String title){
		
		return sqlSession.selectList("main.searchByTitle");
	}
	
	public List<BlogVo> searchByTag(String tag){

		return sqlSession.selectList("main.searchByTag");
	}
	
	public List<BlogUserVo> searchByBloger(String userName){
		
		return sqlSession.selectList("main.searchByName");
	}

}
