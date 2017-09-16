package com.jiem.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiem.mapper.TbItemCatMapper;
import com.jiem.pojo.TbItemCat;
import com.jiem.pojo.TbItemCatExample;
import com.jiem.pojo.TbItemCatExample.Criteria;
import com.jiem.rest.pojo.CatNode;
import com.jiem.rest.pojo.CatResult;
import com.jiem.rest.service.ItemCatService;

/**
 * 商品分类服务
 * @author jiem.ha0  
 * @date 2017年9月19日
 * @version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService  {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/* (non-Javadoc)
	 * @see com.jiem.rest.service.ItemCatService#getItemCatList()
	 * jiem.ha0 2017年9月19日下午9:39:07
	 */
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		//查询分类列表
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	/**
	 * 查询分类列表
	 * @param parentId
	 * @return 
	 * @author jiem.ha0 
	 * @time 2017年9月19日下午9:35:07
	 */
	private List<?> getCatList(long parentId) {
		//创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//返回值list
		List<Object> resultList = new ArrayList<>();
		//向list中添加节点
		int count = 0;
		for (TbItemCat tbItemCat : list) {
			//判断是否为父节点
			if (tbItemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				} else {
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/"+tbItemCat.getId()+".html");
				catNode.setItem(getCatList(tbItemCat.getId()));
				
				resultList.add(catNode);
				count ++;
				//第一层只取14条记录
				if (parentId == 0 && count >=14) {
					break;
				}
			//如果是叶子节点
			} else {
				resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
			}
		}
		return resultList;
	}

}
