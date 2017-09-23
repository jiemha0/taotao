package com.jiem.protal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jiem.commom.HttpClientUtil;
import com.jiem.commom.JsonUtils;
import com.jiem.commom.TaotaoResult;
import com.jiem.protal.pojo.Order;
import com.jiem.protal.service.OrderService;


/**
 * 订单处理Service
 * @author jiem.ha0  
 * @date 2017年9月23日
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService  {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	

	
	/* (non-Javadoc)
	 * @see com.jiem.protal.service.impl.OrderService#createOrder(com.jiem.protal.pojo.Order)
	 * jiem.ha0 2017年9月23日下午2:04:10
	 */
	@Override
	public String createOrder(Order order) {
		//调用创建订单服务之前补全用户信息。
		//从cookie中后取TT_TOKEN的内容，根据token调用sso系统的服务根据token换取用户信息。
		
		//调用taotao-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成taotaoResult
		TaotaoResult taotaoResult = TaotaoResult.format(json);
		if (taotaoResult.getStatus() == 200) {
			Object orderId = taotaoResult.getData();
			return orderId.toString();
		}
		return "";
	}

}