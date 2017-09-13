package com.jiem.service;

import com.jiem.commom.TaotaoResult;

public interface ItemParamService {

	/**
	 * 接收商品分类id。调用mapper查询tb_item_param表
	 * @param cid
	 * @return 
	 * @author jiem.ha0 
	 * @time 2017年9月12日下午8:47:24
	 */
	public abstract TaotaoResult getItemParamByCid(long cid);

}