package com.bit2015.jblog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.jblog.vo.BlogVo;
import com.bit2015.jblog.vo.CategoryVo;
import com.bit2015.jblog.vo.CommentsVo;
import com.bit2015.jblog.vo.PostVo;

@Repository
public class BlogDao {

	@Autowired
	SqlSession sqlSession;

	public List<Map<String, Object>> getMainList(long blogNo) {

		List<Map<String, Object>> list = sqlSession.selectList("blog.mainList",
				blogNo);
		return list;
	}

	public List<Map<String, Object>> getCountList(long  blogNo) {

		List<Map<String, Object>> list = sqlSession.selectList(
				"blog.getCommentCount", blogNo);
		return list;
	}

	public BlogVo getBlogInfo(long blogNo) {

		BlogVo vo = sqlSession.selectOne("blog.getBasicBlogInfo", blogNo);

		return vo;
	}
	

	public void updateBlogInfo(BlogVo blogVo) {
		sqlSession.update("blog.updateBlogInfo", blogVo);
	}

	public List<CategoryVo> getCategoryList(long blogNo) {

		List<CategoryVo> list = sqlSession.selectList("blog.getCategoryList",
				blogNo);
		return list;
	}

	public CategoryVo getCategoryInsert(CategoryVo categoryVo) {

		sqlSession.insert("blog.categoryInsert", categoryVo);

		CategoryVo category = sqlSession.selectOne("blog.getCategory",
				categoryVo);
		System.out.println("@daoResult : " + category);
		return category;
	}
	
	
	public boolean categoryDelete(long categoryNo) {
		
		int result = -1;
		result = sqlSession.delete("blog.categoryDelete", categoryNo);

		return result == 1;
	}
	
	public void setPostInsert(PostVo PostVo) {
		
		sqlSession.insert("blog.postInsert",PostVo);
	}
	
	public Map<String,Object> getPostInfo(long blogNo) {

		Map<String,Object> map = sqlSession.selectOne("blog.getPostInfo", blogNo);

		return map;
	}
	
	public List<CommentsVo> getCommentsList(long postNo) {
		System.out.println("postNo + " + postNo);
		List<CommentsVo> list = sqlSession.selectList("blog.getCommentsList",postNo);
		System.out.println(" list + " +  list);
		return list;
	}
	
	
}
