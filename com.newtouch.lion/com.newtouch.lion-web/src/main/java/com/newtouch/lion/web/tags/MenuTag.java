/*
* Copyright (c)  2014, Newtouch
* All rights reserved. 
*
* $id: MenuTag.java 9552 2014年12月31日 下午4:42:30 WangLijun$
*/
package com.newtouch.lion.web.tags; 

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * <p>
 * Title: 菜单Tag
 * </p>
 * <p>
 * Description: 菜单Tag
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
public class MenuTag implements TemplateDirectiveModel{
	
	/**日志*/
	private static final Logger logger=LoggerFactory.getLogger(MenuTag.class);
	

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}

	