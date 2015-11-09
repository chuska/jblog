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

	public void insert(BlogUserVo vo) {
		sqlSession.insert("user.insert", vo);
	}

	public BlogUserVo login(BlogUserVo vo) {
		BlogUserVo blogUserVo = sqlSession.selectOne("user.getByIdAndPassword",vo);
		return blogUserVo;
	}
}
