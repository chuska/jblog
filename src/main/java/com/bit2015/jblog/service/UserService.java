package com.bit2015.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.jblog.dao.UserDao;
import com.bit2015.jblog.vo.BlogUserVo;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public List<BlogUserVo> getList() {
		List<BlogUserVo> list = userDao.getList();
		return list;
	}

	public void insert(BlogUserVo vo) {
		userDao.insert(vo);
	}

	public BlogUserVo login(BlogUserVo vo) {
		BlogUserVo blogUserVo = userDao.login(vo);
		return blogUserVo;
	}
}
