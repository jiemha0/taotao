package com.jiem.protal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jiem.commom.HttpClientUtil;
import com.jiem.commom.TaotaoResult;
import com.jiem.pojo.TbUser;
import com.jiem.protal.service.UserService;

/**
 * 用户管理Service
 * @author jiem.ha0  
 * @date 2017年9月23日
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService  {
	
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_DOMAIN_BASE_USRL}")
	public String SSO_DOMAIN_BASE_USRL;
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	
	
	
	/* (non-Javadoc)
	 * @see com.jiem.protal.service.impl.UserService#getUserByToken(java.lang.String)
	 * jiem.ha0 2017年9月23日下午1:59:41
	 */
	@Override
	public TbUser getUserByToken(String token) {
		try {
			//调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			//把json转换成TaotaoREsult
			TaotaoResult result = TaotaoResult.formatToPojo(json, TbUser.class);
			if (result.getStatus() == 200) {
				TbUser user = (TbUser) result.getData();
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
