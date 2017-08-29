package com.jiem.service;

import com.jiem.pojo.TbItem;
import com.jiem.pojo.result.EUDataGridResult;

/**
 * 
 * @author jiem.ha0  <br/>
 * 2017年8月29日
 */
public interface ItemService {
	
	
	
	/**
	 * 
	 * @param itemId
	 * @return
	 * @author jiem.ha0 
	 * 2017年8月29日下午9:35:56
	 */
	public TbItem getItemById(Long itemId);
	
	
	/**
	 * 商品列表查询
	 * @param page 第几页
	 * @param rows 每页行数
	 * @return 包装的EasyUI所需要的结果集POJO对象
	 * @author jiem.ha0 
	 * 2017年8月29日下午9:39:53
	 */
	public EUDataGridResult getItemList(int page, int rows);
	
}
