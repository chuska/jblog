package com.bit2015.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.jblog.dao.MainDao;


@Service
public class MainService {
	
	private final int LIST_PAGESIZE = 5;
	private final int LIST_BLOCKSIZE = 5;
	
	@Autowired
	MainDao mainDao;

	public Map<String, Object> listBoard(String searchKeyword, String radioValue, Long page ){

		long totalCount = mainDao.getCount(searchKeyword, radioValue);
		long pageCount = (long)Math.ceil((double)totalCount/LIST_PAGESIZE);
		long blockCount =(long)Math.ceil((double)pageCount/LIST_BLOCKSIZE);
		long currentBlock =(long)Math.ceil((double)page/LIST_BLOCKSIZE);

		if(page<1){
			page=1L;
			currentBlock =1;
		}else if(page>pageCount){
			page=pageCount;
			currentBlock =(int)Math.ceil((double)page/LIST_BLOCKSIZE);
		}
		
		long startPage = (currentBlock ==0)?1:(currentBlock-1)*LIST_BLOCKSIZE+1;
		long endPage =(startPage-1) + LIST_BLOCKSIZE;
		long prevPage=(currentBlock>1)?(currentBlock-1)*LIST_BLOCKSIZE :0;
		long nextPage =(currentBlock < blockCount) ? currentBlock * LIST_BLOCKSIZE+1:0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchKeyword", searchKeyword);
		map.put("radioValue", radioValue);
		List <Map<String, Object>> list = mainDao.search(map, page, LIST_PAGESIZE); 
		map.put("list", list);
		map.put("firstItenIndex", totalCount-(page-1)*LIST_PAGESIZE);
		map.put("currentPage", page);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("pageCount", pageCount);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("totalCount", totalCount);
		
		return map;
		
	}
}











