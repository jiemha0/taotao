package com.jiem.rest.service;

import com.jiem.commom.TaotaoResult;

public interface RedisService {

	public abstract TaotaoResult syncContent(long contentCid);

}