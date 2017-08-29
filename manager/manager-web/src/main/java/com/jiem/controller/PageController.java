package com.jiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 * @author jiem.ha0  <br/>
 * 2017年8月29日
 */
@Controller
public class PageController {
	
	/**
	 * 打开首页
	 * @author jiem.ha0 
	 * 2017年8月29日下午8:59:25
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	
	/**
	 * 打开其他页面
	 * @author jiem.ha0 
	 * 2017年8月29日下午9:01:51
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}

	

}
