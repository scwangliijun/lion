/*
* Copyright (c)  2014, Newtouch
* All rights reserved. 
*
* $id: MenuService.java 9552 2014年12月31日 下午5:17:30 WangLijun$
*/
package com.newtouch.lion.service.menu; 

import com.newtouch.lion.model.menu.Menu;

/**
 * <p>
 * Title: Menu Service 定义 
 * </p>
 * <p>
 * Description: Menu Service 定义 
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
public interface MenuService {
	public  Menu doFindByUser(String userName);
}	

	