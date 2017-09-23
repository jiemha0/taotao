package com.jiem.protal.service;

import com.jiem.protal.pojo.SearchResult;

public interface SearchService {

	public abstract SearchResult search(String queryString, int page);

}