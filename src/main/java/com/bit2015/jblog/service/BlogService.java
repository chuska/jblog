package com.bit2015.jblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.jblog.dao.BlogDao;
import com.bit2015.jblog.vo.CategoryVo;

//
@Service
public class BlogService {
	
	@Autowired
	BlogDao blogDao;
	
	public List<Map<String, Object>> blogMainList(String categoryNo)
	{
		List<Map<String, Object>> mainList = blogDao.mainList(categoryNo);
		return mainList;
	}
	public List<Map<String, Object>> blogCountList(String categoryNo)
	{
		List<Map<String, Object>> countList = blogDao.countList(categoryNo);
		return countList;
	}
	public List<CategoryVo> blogCategoryList(long blogNo)
	{
		List<CategoryVo> cateList = blogDao.categoryList(blogNo);
		return cateList;
	}
}
