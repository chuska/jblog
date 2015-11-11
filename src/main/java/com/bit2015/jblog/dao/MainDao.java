package com.bit2015.jblog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MainDao {
	
	@Autowired
	SqlSession sqlSession;
	

	public List<Map<String, Object>> search(Map<String, Object> map,Long page,Integer pageSize){
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<Map<String, Object>> list = sqlSession.selectList("main.search", map);
		return list;
	}
	
	public Long getCount(String searchKeyword, String radioValue ){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchKeyword", searchKeyword);
		map.put("radioValue",radioValue);
		
		Long count = sqlSession.selectOne("main.getCount", map);
		return count;
	}
	

}
