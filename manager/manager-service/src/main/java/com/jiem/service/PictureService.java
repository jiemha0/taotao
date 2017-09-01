package com.jiem.service;

import org.springframework.web.multipart.MultipartFile;

import com.jim.commom.PictureResult;


/**
 * 图片上传
 * @author jiem.ha0  
 * @date 2017年8月31日
 */
public interface PictureService {

	/**
	 * 图片上传到服务器
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 * @author jiem.ha0 
	 * @time 2017年8月31日下午9:56:32
	 */
	public abstract PictureResult uploadFile(MultipartFile uploadFile)
			throws Exception;

}