package com.jiem.rest.service;

import com.jiem.commom.TaotaoResult;

public interface ItemService {

	public abstract TaotaoResult getItemBaseInfo(long itemId);

	public abstract TaotaoResult getItemDesc(long itemId);

	public abstract TaotaoResult getItemParam(long itemId);

}