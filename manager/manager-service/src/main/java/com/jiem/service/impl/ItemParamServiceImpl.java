package com.jiem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiem.commom.TaotaoResult;
import com.jiem.mapper.TbItemParamMapper;
import com.jiem.pojo.TbItemParam;
import com.jiem.pojo.TbItemParamExample;
import com.jiem.pojo.TbItemParamExample.Criteria;
import com.jiem.service.ItemParamService;
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExample(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return TaotaoResult.ok(list.get(0));
		}
		
		return TaotaoResult.ok();
	}

}
