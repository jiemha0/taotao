package com.jiem.rest.service;

import java.util.List;

import com.jiem.pojo.TbContent;

public interface ContentService {

	public abstract List<TbContent> getContentList(long contentCid);

}