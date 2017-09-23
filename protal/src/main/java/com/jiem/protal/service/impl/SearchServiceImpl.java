package com.jiem.protal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jiem.commom.HttpClientUtil;
import com.jiem.commom.TaotaoResult;
import com.jiem.protal.pojo.SearchResult;
import com.jiem.protal.service.SearchService;



/**
 * 商品搜索Service
 * @author jiem.ha0  
 * @date 2017年9月23日
 * @version 1.0
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;
	
	
	/* (non-Javadoc)
	 * @see com.jiem.protal.service.impl.SearchService#search(java.lang.String, int)
	 * jiem.ha0 2017年9月23日下午2:02:22
	 */
	@Override
	public SearchResult search(String queryString, int page) {
		// 调用taotao-search的服务
		//查询参数
		Map<String, String> param = new HashMap<>();
		param.put("q", queryString);
		param.put("page", page + "");
		try {
			//调用服务
			String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
			//把字符串转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, SearchResult.class);
			if (taotaoResult.getStatus() == 200) {
				SearchResult result = (SearchResult) taotaoResult.getData();
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
