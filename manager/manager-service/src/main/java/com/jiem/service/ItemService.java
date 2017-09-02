package com.jiem.service;

import com.jiem.commom.TaotaoResult;
import com.jiem.pojo.TbItem;
import com.jiem.pojo.result.EUDataGridResult;

/**
 * 
 * @author jiem.ha0 <br/>
 *         2017年8月29日
 */
public interface ItemService {

	/**
	 * 
	 * @param itemId
	 * @return
	 * @author jiem.ha0 2017年8月29日下午9:35:56
	 */
	public TbItem getItemById(Long itemId);

	/**
	 * 商品列表查询
	 * 
	 * @param page
	 *            第几页
	 * @param rows
	 *            每页行数
	 * @return 包装的EasyUI所需要的结果集POJO对象
	 * @author jiem.ha0 2017年8月29日下午9:39:53
	 */
	public EUDataGridResult getItemList(int page, int rows);

	/**
	 * 商品添加
	 * 
	 * @param item
	 * @param desc
	 * @param itemParams
	 * @throws Exception
	 * @author jiem.ha0
	 * @time 2017年8月31日下午10:21:00
	 */
	public void saveItem(TbItem item, String desc, String itemParams)
			throws Exception;

	/**
	 * 商品描述的保存
	 * 
	 * @param item
	 * @param desc
	 * @return
	 * @throws Exception
	 * @author jiem.ha0
	 * @time 2017年9月1日下午8:30:09
	 */
	TaotaoResult createItem(TbItem item, String desc) throws Exception;

}
