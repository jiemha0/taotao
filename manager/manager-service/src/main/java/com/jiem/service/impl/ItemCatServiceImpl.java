package com.jiem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiem.mapper.TbItemCatMapper;
import com.jiem.pojo.TbItemCat;
import com.jiem.pojo.TbItemCatExample;
import com.jiem.pojo.TbItemCatExample.Criteria;
import com.jiem.service.ItemCatService;

/**
 * 商品类目实现类
 * @author jiem.ha0  <br/>
 * 2017年8月30日
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	/* (non-Javadoc)
	 * @see com.jiem.service.ItemCatService#getItemCatList(java.lang.Long)
	 * jiem.ha0 2017年8月30日下午8:52:01
	 */
	@Override
	public List<TbItemCat> getItemCatList(Long parentId) throws Exception {

		TbItemCatExample example = new TbItemCatExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		// 根据parentid查询子节点
		criteria.andParentIdEqualTo(parentId);
		// 返回子节点列表
		List<TbItemCat> list = itemCatMapper.selectByExample(example);

		return list;
	}

}
