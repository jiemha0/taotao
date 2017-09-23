package com.jiem.protal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiem.commom.TaotaoResult;
import com.jiem.protal.pojo.CartItem;

/**
 * 购物车Service
 * @author jiem.ha0  
 * @date 2017年9月23日
 * @version 1.0
 */
public interface CartService {

	/**
	 * 添加购物车商品
	 * @param itemId
	 * @param num
	 * @param request
	 * @param response
	 * @return 
	 * @author jiem.ha0 
	 * @time 2017年9月23日下午1:13:16
	 */
	public abstract TaotaoResult addCartItem(long itemId, int num,
			HttpServletRequest request, HttpServletResponse response);

	public abstract List<CartItem> getCartItemList(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 删除购物车商品
	 * @param itemId
	 * @param request
	 * @param response
	 * @return 
	 * @author jiem.ha0 
	 * @time 2017年9月23日下午1:14:28
	 */
	public abstract TaotaoResult deleteCartItem(long itemId,
			HttpServletRequest request, HttpServletResponse response);

}