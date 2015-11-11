package com.bit2015.jblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.jblog.dao.BlogDao;
import com.bit2015.jblog.vo.BlogVo;
import com.bit2015.jblog.vo.CategoryVo;
import com.bit2015.jblog.vo.CommentsVo;
import com.bit2015.jblog.vo.PostVo;

//
@Service
public class BlogService {
	
	@Autowired
	BlogDao blogDao;
	
	public List<Map<String, Object>> blogMainList(long blogNo)
	{
		List<Map<String, Object>> mainList = blogDao.getMainList(blogNo);
		return mainList;
	}
	
	public List<Map<String, Object>> blogCountList(long blogNo)
	{
		List<Map<String, Object>> countList = blogDao.getCountList(blogNo);
		return countList;
	}
	
	public List<CategoryVo> blogCategoryList(long blogNo)
	{
		List<CategoryVo> cateList = blogDao.getCategoryList(blogNo);
		return cateList;
	}
	
	
	public CategoryVo blogCategoryInsert(CategoryVo categoryVo)
	{
		CategoryVo cateList = blogDao.getCategoryInsert(categoryVo);
		
		return cateList;
	}
	
	public boolean blogCategoryDelete(long categoryNo)
	{
		return blogDao.categoryDelete(categoryNo);
	}
	
	public void blogInfoModify(BlogVo blogVo)
	{
		blogDao.updateBlogInfo(blogVo);
	}
	
	public BlogVo blogBlogInfo(long blogNo)
	{
		BlogVo vo = blogDao.getBlogInfo(blogNo);
		return vo;
	}
	
	/*post*/
	public void blogPostInsert(PostVo postVo)
	{
		blogDao.setPostInsert(postVo);
		
	}
	
	public Map<String,Object> blogPostInfo(long blogNo)
	{
		Map<String,Object> map = blogDao.getPostInfo(blogNo);
		return map;
	}
	
	/*comments*/
	public List<CommentsVo> blogCommentsList(long postNo)
	{
		List<CommentsVo> commentsList = blogDao.getCommentsList(postNo);
		return commentsList;
	}
	
}
