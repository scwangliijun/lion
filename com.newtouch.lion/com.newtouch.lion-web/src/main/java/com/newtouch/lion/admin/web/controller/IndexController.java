/*
* Copyright (c)  2014, Newtouch
* All rights reserved. 
*
* $id: IndexController.java 9552 2014年12月30日 上午10:10:29 WangLijun$
*/
package com.newtouch.lion.admin.web.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newtouch.lion.web.controller.AbstractController;

/**
 * <p>
 * Title: 后台管理首页Controller
 * </p>
 * <p>
 * Description: 后台管理首页Controller
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: Newtouch
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class IndexController extends  AbstractController{
	
	private static final String INDEX_RETURN="/index";
	
	
	@RequestMapping("/index")
	public String index(){
		logger.info("进入首页.....");
		return INDEX_RETURN;
	}
}

	