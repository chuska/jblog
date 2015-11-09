package com.bit2015.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.jblog.dao.MainDao;
import com.bit2015.jblog.vo.BlogUserVo;
import com.bit2015.jblog.vo.BlogVo;

@Service
public class MainService {
	
	@Autowired
	MainDao mainDao;
	
	public List<BlogVo> searchByTitle(String title){
		List<BlogVo> list = mainDao.searchByTitle(title);
		return list;
	}
	
	public List<BlogVo> searchByTag(String tag){
		List<BlogVo> list = mainDao.searchByTag(tag);
		return list;
	}
	
	public List<BlogUserVo> searchByBloger(String userName){
		List<BlogUserVo> list = mainDao.searchByBloger(userName);
		return list;
	}


}
