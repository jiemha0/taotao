package com.jiem.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jiem.commom.JsonUtils;
import com.jiem.mapper.TbContentMapper;
import com.jiem.pojo.TbContent;
import com.jiem.pojo.TbContentExample;
import com.jiem.pojo.TbContentExample.Criteria;
import com.jiem.rest.dao.JedisClient;
import com.jiem.rest.service.ContentService;

/**
 * 内容管理
 * @author jiem.ha0  
 * @date 2017年9月19日
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiem.rest.service.impl.ContentService#getContentList(long)
	 * jiem.ha0 2017年9月19日下午8:39:12
	 */
	@Override
	public List<TbContent> getContentList(long contentCid) {
		// 从缓存中取内容
		try {
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY,
					contentCid + "");
			if (!StringUtils.isBlank(result)) {
				// 把字符串转换成list
				List<TbContent> resultList = JsonUtils.jsonToList(result,
						TbContent.class);
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExample(example);

		// 向缓存中添加内容
		try {
			// 把list转换成字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "",
					cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
