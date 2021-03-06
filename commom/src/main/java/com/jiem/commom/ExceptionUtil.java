package com.jiem.commom;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 * @author jiem.ha0  
 * @date 2017年9月12日
 * @version 
 */
public class ExceptionUtil {

	/**
	 * 获取异常的堆栈信息
	 * @param t
	 * @return
	 * @author jiem.ha0 
	 * @time 2017年9月12日下午7:54:41
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
