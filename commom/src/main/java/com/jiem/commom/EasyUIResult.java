package com.jiem.commom;

import java.util.List;

/**
 * easyUIDataGrid对象返回值
 * @author jiem.ha0  
 * @date 2017年9月12日
 */
public class EasyUIResult {

	private Integer total;
	
	private List<?> rows;
	
	public EasyUIResult(Integer total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public EasyUIResult(long total, List<?> rows) {
		this.total = (int) total;
		this.rows = rows;
	}

	public EasyUIResult() {
		super();
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
