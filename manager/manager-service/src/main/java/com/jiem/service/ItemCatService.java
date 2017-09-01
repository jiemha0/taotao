package com.jiem.service;

import java.util.List;

import com.jiem.pojo.TbItemCat;

/**
 * 商品类目 服务层
 * @author jiem.ha0  <br/>
 * 2017年8月30日
 */
public interface ItemCatService {

	
	/**
	 * 获取商品类目列表
	 * @param parentId 父节点
	 * @return 子节点列表
	 * @throws Exception
	 * @author jiem.ha0 
	 * 2017年8月30日下午8:10:13
	 */
	public List<TbItemCat> getItemCatList(Long parentId) throws Exception ;
}
