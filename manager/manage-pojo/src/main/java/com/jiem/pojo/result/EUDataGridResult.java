package com.jiem.pojo.result;

import java.util.List;


/**
 * 包装的EasyUI所需要的结果集POJO对象
 * @author jiem.ha0  <br/>
 * 2017年8月29日
 */
public class EUDataGridResult {

	/**
	 * 记录总条数
	 */
	private long total;
	/**
	 * 返回结果集
	 */
	private List<?> rows;
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "EUDataGridResult [total=" + total + ", rows=" + rows + "]";
	}
	
}
