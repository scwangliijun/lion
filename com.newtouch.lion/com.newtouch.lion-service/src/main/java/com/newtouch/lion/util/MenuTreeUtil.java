/*
 * Copyright (c)  2015, Newtouch
 * All rights reserved. 
 *
 * $id: MenuTreeUtil.java 9552 2015年1月4日 下午4:39:53 WangLijun$
 */
package com.newtouch.lion.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newtouch.lion.common.codelist.CodeListConstant;
import com.newtouch.lion.comparator.ResourceComparator;
import com.newtouch.lion.model.menu.Menu;
import com.newtouch.lion.model.system.Attributes;
import com.newtouch.lion.model.system.Resource;

/**
 * <p>
 * Title: 菜单树生成工具类
 * </p>
 * <p>
 * Description: 菜单树生成工具类，主要实现树递归生成树形结构的菜单
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: Newtouch
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class MenuTreeUtil {
	/** 日志 */
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory
			.getLogger(ResourceTreeUtil.class);
	/** 菜单列表 */
	private static Map<String, String> menusMap = new HashMap<String, String>();
	/** 菜单列表 */
	static {
		menusMap.put(CodeListConstant.RESTYPE_MENU,CodeListConstant.RESTYPE_MENU);
		menusMap.put(CodeListConstant.RESTYPE_MODULE,CodeListConstant.RESTYPE_MODULE);
		menusMap.put(CodeListConstant.RESTYPE_MODULE_MENU_CATEGORY,CodeListConstant.RESTYPE_MODULE_MENU_CATEGORY);
		menusMap.put(CodeListConstant.RESTYPE_APPLICATION,CodeListConstant.RESTYPE_APPLICATION);
		menusMap.put(CodeListConstant.RESTYPE_MODULE_CATEGORY_ITEM,CodeListConstant.RESTYPE_MODULE_CATEGORY_ITEM);
	}

	/***
	 * 
	 * @param resources
	 * @param menuResourcesMap
	 * @param isSort
	 * @param count
	 * @return
	 */
	public static List<Menu> treeResource(List<Resource> resources,
			Map<Long, Resource> menuResourcesMap, Boolean isSort, int count) {
		// 子类菜单
		List<Menu> childrenMenu = new ArrayList<Menu>();
		ResourceComparator resourceComparator = new ResourceComparator();
		if (isSort) {
			Collections.sort(resources, resourceComparator);
		}
		count++;
		for (Resource resource : resources) {
			Boolean checked = Boolean.TRUE;
			Attributes attributes = new Attributes();
			attributes.setPath(resource.getPath());
			attributes.setTarget(resource.getTarget());
			if (CodeListConstant.RESTYPE_MODULE_CATEGORY_ITEM.equals(resource
					.getType())){
				if(menuResourcesMap.containsKey(resource.getId())){
					checked=Boolean.FALSE;
				}
				if(checked){
					continue;
				}

			}
			List<Menu> childrenNext = new ArrayList<Menu>();
			// 当资源子集大于1时，进入递归调用；
			if (resource.getResources().size() > 0) {
				List<Resource> resourcesList = new ArrayList<Resource>(
						resource.getResources());
				childrenNext = treeResource(resourcesList, menuResourcesMap,
						isSort, count);
				if (childrenNext.size() == 0) {
					continue;
				}
			}

			Boolean isLeaf = Boolean.FALSE;
			if (containsKey(resource.getType())
					&& resource.getResources().size() > 0) {
				isLeaf = Boolean.FALSE;
			}
			Menu menu = new Menu(resource.getId(),
					resource.getParentResourceId(), resource.getType(),
					resource.getPath(), resource.getNameZh(),
					resource.getNameEn(), resource.getSeqNum(), isLeaf,
					resource.getTarget(),resource.getIcon(),childrenNext);
			childrenMenu.add(menu);

		}
		return childrenMenu;
	}

	/**
	 * 是根据菜单类型判断是否该菜单资源
	 * 
	 * @param key
	 *            菜单类型的KEY
	 * @return 包括
	 */
	private static boolean containsKey(String key) {
		return menusMap.containsKey(key);
	}

}
