package com.jiem.protal.service;

import com.jiem.pojo.TbUser;

public interface UserService {

	public abstract TbUser getUserByToken(String token);

}