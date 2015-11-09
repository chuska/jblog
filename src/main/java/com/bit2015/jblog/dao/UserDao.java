package com.bit2015.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.jblog.vo.BlogUserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	public List<BlogUserVo> getList() {
		List<BlogUserVo> list = sqlSession.selectList("user.list");
		return list;
	}

	public void userInsert(BlogUserVo vo) {
		sqlSession.insert("user.userInsert", vo);
	}

	public void blogInsert(BlogUserVo vo) {
		sqlSession.insert("user.blogInsert", vo);
	}

	public void categoryInsert(BlogUserVo vo) {
		sqlSession.insert("user.categoryInsert", vo);
	}

	public BlogUserVo login(BlogUserVo vo) {
		BlogUserVo blogUserVo = sqlSession.selectOne("user.getByIdAndPassword",
				vo);
		return blogUserVo;
	}

	public BlogUserVo get(String id) {
		BlogUserVo vo = sqlSession.selectOne("user.getById", id);
		return vo;
	}
}
