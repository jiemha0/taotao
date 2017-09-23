package com.jiem.protal.service;

import com.jiem.protal.pojo.ItemInfo;

public interface ItemService {

	public abstract ItemInfo getItemById(Long itemId);

	/**
	 * 取商品描述
	 * @param itemId
	 * @return 
	 * @author jiem.ha0 
	 * @time 2017年9月23日下午1:53:37
	 */
	public abstract String getItemDescById(Long itemId);

	/**
	 * 根据商品id查询规格参数
	 * @param itemId
	 * @return 
	 * @author jiem.ha0 
	 * @time 2017年9月23日下午1:54:20
	 */
	public abstract String getItemParam(Long itemId);

}