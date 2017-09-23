package com.jiem.protal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jiem.commom.HttpClientUtil;
import com.jiem.commom.JsonUtils;
import com.jiem.commom.TaotaoResult;
import com.jiem.pojo.TbContent;
import com.jiem.protal.service.ContentService;


/**
 * 调用服务层服务，查询内容列表
 * @author jiem.ha0  
 * @date 2017年9月23日
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService  {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	/* (non-Javadoc)
	 * @see com.jiem.protal.service.impl.ContentService#getContentList()
	 * jiem.ha0 2017年9月23日下午1:50:36
	 */
	@Override
	public String getContentList() {
		//调用服务层的服务
		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
		//把字符串转换成TaotaoResult
		try {
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			//取内容列表
			@SuppressWarnings("unchecked")
			List<TbContent> list = (List<TbContent>) taotaoResult.getData();
			List<Map<String,Object>> resultList = new ArrayList<>();
 			//创建一个jsp页码要求的pojo列表
			for (TbContent tbContent : list) {
				Map<String,Object> map = new HashMap<>();
				map.put("src", tbContent.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", tbContent.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", tbContent.getUrl());
				map.put("alt", tbContent.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
