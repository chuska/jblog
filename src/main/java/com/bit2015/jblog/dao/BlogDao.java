package com.bit2015.jblog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.jblog.vo.CategoryVo;


@Repository
public class BlogDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<Map<String, Object>> mainList(String categoryNo){
		
		List<Map<String, Object>> list = sqlSession.selectList("blog.mainList",categoryNo);
		return list;
	}
	
	public List<CategoryVo> countList(String blogNo){
		
		List<CategoryVo>  list = sqlSession.selectList("blog.categoryList",blogNo);
		return list;
	}
	
	public List<CategoryVo> categoryList(long blogNo){
		
		List<CategoryVo>  list = sqlSession.selectList("blog.categoryList",blogNo);
		return list;
	}
}
