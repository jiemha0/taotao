package com.jiem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiem.mapper.TbItemMapper;
import com.jiem.service.ItemService;
import com.jiem.pojo.TbItem;
import com.jiem.pojo.TbItemExample;
import com.jiem.pojo.TbItemExample.Criteria;
import com.jiem.pojo.result.EUDataGridResult;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	/* (non-Javadoc)
	 * @see com.jiem.service.ItemService#getItemById(java.lang.Long)
	 * jiem.ha0 2017年8月29日下午9:32:52
	 */
	@Override
	public TbItem getItemById(Long itemId) {

		// TbItem item = itemMapper.selectByPrimaryKey(itemId);
		// 添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jiem.service.ItemService#getItemList(int, int)
	 * jiem.ha0 2017年8月29日下午9:41:20
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		// 查询商品列表
		TbItemExample example = new TbItemExample();
		// 分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		// 取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
