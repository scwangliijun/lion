/*
 * Copyright (c)  2012, Newtouch
 * All rights reserved. 
 *
 * $id: TsCodeList.java 9552 2012-12-30 下午8:46:28 WangLijun$
 */
package com.newtouch.lion.model.system;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.newtouch.lion.model.VersionEntity;

/**
 * <p>
 * Title: 通用编码列表Model
 * </p>
 * <p>
 * Description: 通用编码列表Model
 * </p>
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 * <p>
 * Company: Newtouch
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class CodeList extends VersionEntity<Long> {

	private static final long serialVersionUID = -3068188326261674873L;
	/** 通用编码列表id */
	private Long id;
	/** 编码值 */
	private String codeValue;
	/** 编码中文名称 */
	private String nameZh;
	/** 编码英文名称 */
	private String nameEn;
	/** 编码排序 */
	private int sortNo;
	/** 是否可编辑 */
	private Boolean editable;
	/** 编码类型对象 */
	private CodeType codeType;
	/** 默认选择 */
	private Boolean selected;
	/** 编辑类型ID */
	private Long codeTypeId;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.model.BaseEntity#getId()
	 */
	@Override
	@Column(name = "BAS_CODE_LIST_ID", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getId() {
		return this.id;
	}

	/**
	 * @return the codeTypeId
	 */
	@Column(name = "BAS_CODE_TYPE_ID", nullable = false, insertable = false, updatable = false)
	public Long getCodeTypeId() {
		return codeTypeId;
	}

	/**
	 * @param codeTypeId
	 *            the codeTypeId to set
	 */
	public void setCodeTypeId(Long codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	/**
	 * @return the codeValue
	 */
	@Column(name = "CODE_VALUE")
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * @return the nameZh
	 */
	@Column(name = "NAME_ZH")
	public String getNameZh() {
		return nameZh;
	}

	/**
	 * @return the nameEn
	 */
	@Column(name = "NAME_EN")
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @return the sortNo
	 */
	@Column(name = "SORT_NO")
	public int getSortNo() {
		return sortNo;
	}

	/**
	 * @return the editable
	 */
	@Column(name = "EDITABLE")
	public Boolean getEditable() {
		return editable;
	}

	/**
	 * @return the tsCodeType
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "BAS_CODE_TYPE_ID", nullable = false, insertable = true, updatable = true)
	public CodeType getCodeType() {
		return this.codeType;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param codeValue
	 *            the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * @param nameZh
	 *            the nameZh to set
	 */
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	/**
	 * @param nameEn
	 *            the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * @param sortNo
	 *            the sortNo to set
	 */
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * @param tsCodeType
	 *            the tsCodeType to set
	 */
	public void setCodeType(CodeType codeType) {
		this.codeType = codeType;
	}

	/**
	 * @param editable
	 *            the editable to set
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	/**
	 * @return the selected
	 */
	@Column(name = "SELECTED")
	public Boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
