package com.jiem.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiem.rest.pojo.CatResult;
import com.jiem.rest.service.ItemCatService;

/**
 * 商品分类列表
 * @author jiem.ha0  
 * @date 2017年9月19日
 * @version 1.0
 */
@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}
