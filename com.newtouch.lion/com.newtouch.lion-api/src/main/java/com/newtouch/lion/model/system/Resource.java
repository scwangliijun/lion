/**
	* Copyright (c)  2012, lion
	* All rights reserved. 
	*
	* $id: TsResource.java 9552 2012-12-30 下午6:23:34 WangLijun$
*/
package com.newtouch.lion.model.system; 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.newtouch.lion.model.VersionEntity;

/**
 * <p>
 * Title: 资源Model
 * </p>
 * <p>
 * Description: 资源Model
 * </p>
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 * <p>
 * Company: lion
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class Resource extends VersionEntity<Long> {

	private static final long serialVersionUID = 3513003563818178117L;
	
	/***
	 * 资源ID
	 */
	private Long  id;
	/**资源父ID*/
	private Long  parentResourceId;
	/**资源类型*/
	private String type;
	/**资源路径 URL Class.Method*/
	private String path;
	/**资源名称－中文*/
	private String nameZh;
	/**资源名称－英文*/
	private String nameEn;
	/**资源描述*/
	private String description;
	/**资源排序*/
	private int seqNum;
	/**资源是否叶节点，其下没有子资源 默认为：true*/
	private Boolean isLeaf;
	/**资源是否可编辑*/
	private Boolean editable;
	/**资源目标 指HTML链接的target属性*/
	private String  target;
	/**子资源关联父资源对象*/
	private Resource resource;
	/**父资源关联父资源对象*/
	private Set<Resource> resources = new HashSet<Resource>(0);
	/**资源所关联的角色集合*/
	private Set<Role> roles=new HashSet<Role>();
	/**资源性*/
	private Attributes attributes;

	/* (non-Javadoc)
	 * @see com.lion.framework.model.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * @return the parentResourceId
	 */
	@Column(name ="PARENT_BAS_RESOURCE_ID",nullable = false, precision = 11, scale = 0)
	public Long getParentResourceId() {
		return parentResourceId;
	}

	/**
	 * @return the type
	 */
	@Column(name="TYPE",length=255)
	public String getType() {
		return type;
	}

	/**
	 * @return the path
	 */
	@Column(name="PATH", unique=true,length=1024)
	public String getPath() {
		return path;
	}

	/**
	 * @return the nameZh
	 */
	@Column(name="NAME_ZH", unique=true,length=255)
	public String getNameZh() {
		return nameZh;
	}

	/**
	 * @return the nameEn
	 */
	@Column(name="NAME_EN", unique=true,length=255)
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @return the description
	 */
	@Column(name="DESCRIPTION", length=255)
	public String getDescription() {
		return description;
	}

	/**
	 * @return the seqNum
	 */
	@Column(name="SEQ_NUM")
	public int getSeqNum() {
		return seqNum;
	}

	/**
	 * @return the isLeaf
	 */
	@Column(name="IS_LEAF")
	public Boolean getIsLeaf() {
		return isLeaf;
	}

	/**
	 * @return the editable
	 */
	@Column(name="EDITABLE")
	public Boolean getEditable() {
		return editable;
	}

	/**
	 * @return the target
	 */
	@Column(name="TARGET")
	public String getTarget() {
		return target;
	}

	/**
	 * @return the tsResource
	 */
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "PARENT_BAS_RESOURCE_ID", updatable = false, insertable = false)
	public Resource getResource() {
		return resource;
	}

	
	
	/**
	 * @return the tsResources
	 */
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JoinColumn(name = "PARENT_BAS_RESOURCE_ID", updatable = false, insertable = false)
	public Set<Resource> getResources() {
		return resources;
	}

	/**
	 * @return the tsRoles
	 */
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "BAS_ROLE_RESOURCE", joinColumns = { @JoinColumn(name = "BAS_RESOURCE_ID", nullable=false, updatable=false)}, inverseJoinColumns = { @JoinColumn(name = "BAS_ROLE_ID", nullable=false, updatable=false) })
	public Set<Role> getRoles() {
		return roles;
	}

	
	
	/**
	 * @return the attributes
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="path",column=@Column(name="PATH",insertable=false,nullable=false,updatable=false))
	})
	public Attributes getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param parentReourceId the parentReourceId to set
	 */
	public void setParentResourceId(Long parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @param nameZh the nameZh to set
	 */
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	/**
	 * @param nameEn the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param seqNum the seqNum to set
	 */
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	/**
	 * @param isLeaf the isLeaf to set
	 */
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @param tsResource the tsResource to set
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @param tsResources the tsResources to set
	 */
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	/**
	 * @param tsRoles the tsRoles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

	