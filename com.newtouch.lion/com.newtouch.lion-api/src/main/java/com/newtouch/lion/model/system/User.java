/**
 * 
 */
package com.newtouch.lion.model.system;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.newtouch.lion.model.VersionEntity;

/**
 * <p>
 * Title: 用户 Model
 * </p>
 * <p>
 * Description: 用户 Model
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
 
public class User extends VersionEntity<Long>{
 
	private static final long serialVersionUID = -3674276844049006131L;

	/***
	 * USERID
	 */
	private Long id;
	/**该用户部门*/
	private Department department;
	/**部门ID*/
	private Long departmentId;
	/**该员工经理*/
	private User user;
	/**经理ID*/
	private Long managerId;
	/**登录用户名*/
	private String username;
	/**超级管理员*/
	private String sapUsername;
	/**登录密码*/
	private String password;
	/**密码提示语*/
	private String passwordHint;
	/**员工号*/
	private String employeeCode;
	/**认证类型 LDAP, DB, DUMMY*/
	private String authtype;
	/**用户类型EMPLOYEE, SUPPLIER, DEALER可自行扩展*/
	private String usertype;
	/**用户描述*/
	private String description;
	/**用户真实姓名－中文*/
	private String realnameZh;
	/**用户真实姓名－英文*/
	private String realnameEn;

	/**联系电话*/
	private String telephone;
	/**联系电话－手机*/
	private String mobile;
	/**联系电话－办公室*/
	private String officePhone;
	/**E-mail*/
	private String email;
	/**性别*/
	private int gender;
	/**办公室位置*/
	private String location;
	/**传真*/
	private String fax;
	/**邮编*/
	private String postcode;
	/**账户是否有效*/
	private Boolean accountExpired;
	/**账户是否被锁定*/
	private Boolean accountLocked;
	/**账户密码是否有效*/
	private Boolean credentialExpired;
	/**账户密码有效日期*/
	private Date credentialExpiredDate;
	/**账户有效日期*/
	private Date accountExpiredDate;
	/**是否可编辑*/
	private Boolean editable;
	/**该用户所有权限列表*/
	private Set<Role> roles = new HashSet<Role>(0);
	/**该管理员工所有下属员工*/
	private Set<User> users = new HashSet<User>(0);
	/**该用户所有用户组*/
	private Set<Group> groups=new HashSet<Group>(0);
	
	@Override
	public Long getId() {
		return this.id;
	}


	/**
	 * @return the department
	 */
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "BAS_DEPARTMENT_ID", updatable =false, insertable = false)
	public Department getDepartment() {
		return department;
	}


	/**
	 * @return the departmentId
	 */
	@Column(name = "BAS_DEPARTMENT_ID", precision = 11, scale = 0)
	public Long getDepartmentId() {
		return departmentId;
	}


	/**
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_USER_ID", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}


	/**
	 * @return the managerId
	 */
	@Column(name = "MANAGER_USER_ID", precision = 10, scale = 0)
	public Long getManagerId() {
		return managerId;
	}


	/**
	 * @return the username
	 */
	@Column(name = "USERNAME", length = 30)
	public String getUsername() {
		return username;
	}


	/**
	 * @return the sapUsername
	 */
	@Column(name = "SAP_USERNAME", length = 30)
	public String getSapUsername() {
		return sapUsername;
	}


	/**
	 * @return the password
	 */
	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return password;
	}


	/**
	 * @return the passwordHint
	 */
	@Column(name = "PASSWORD_HINT", length = 30)
	public String getPasswordHint() {
		return passwordHint;
	}


	/**
	 * @return the employeeCode
	 */
	@Column(name = "EMPLOYEE_NO", length = 30)
	public String getEmployeeCode() {
		return employeeCode;
	}


	/**
	 * @return the authtype
	 */
	@Column(name = "AUTHTYPE", length = 10)
	public String getAuthtype() {
		return authtype;
	}


	/**
	 * @return the usertype
	 */
	@Column(name = "USERTYPE", length = 10)
	public String getUsertype() {
		return usertype;
	}


	/**
	 * @return the description
	 */
	@Column(name = "DESCRIPTION", length = 255)
	public String getDescription() {
		return description;
	}


	/**
	 * @return the realnameZh
	 */
	@Column(name = "REALNAME_ZH", length = 120)
	public String getRealnameZh() {
		return realnameZh;
	}


	/**
	 * @return the realnameEn
	 */
	@Column(name = "REALNAME_EN", length = 120)
	public String getRealnameEn() {
		return realnameEn;
	}


	/**
	 * @return the telephone
	 */
	@Column(name = "TELEPHONE", length = 30)
	public String getTelephone() {
		return telephone;
	}


	/**
	 * @return the mobile
	 */
	@Column(name = "MOBILE", length = 30)
	public String getMobile() {
		return mobile;
	}


	/**
	 * @return the officePhone
	 */
	@Column(name = "OFFICE_TELEPHONE", length = 30)
	public String getOfficePhone() {
		return officePhone;
	}


	/**
	 * @return the email
	 */
	@Column(name = "EMAIL", length = 30)
	public String getEmail() {
		return email;
	}


	/**
	 * @return the gender
	 */
	@Column(name = "GENDER")
	public int getGender() {
		return gender;
	}


	/**
	 * @return the location
	 */
	@Column(name = "LOCATION",length = 120)
	public String getLocation() {
		return location;
	}


	/**
	 * @return the fax
	 */
	@Column(name = "FAX",length = 30)
	public String getFax() {
		return fax;
	}


	/**
	 * @return the postcode
	 */
	@Column(name = "POSTCODE",length = 30)
	public String getPostcode() {
		return postcode;
	}


	/**
	 * @return the accountExpired
	 */
	@Column(name = "ACCOUNT_EXPIRED")
	public Boolean getAccountExpired() {
		return accountExpired;
	}


	/**
	 * @return the accountLocked
	 */
	@Column(name = "ACCOUNT_LOCKED")
	public Boolean getAccountLocked() {
		return accountLocked;
	}


	/**
	 * @return the credentialExpired
	 */
	@Column(name = "CREDENTIAL_EXPIRED")
	public Boolean getCredentialExpired() {
		return credentialExpired;
	}


	/**
	 * @return the credentialExpiredDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREDENTIAL_EXPIRED_DATE")
	public Date getCredentialExpiredDate() {
		return credentialExpiredDate;
	}


	/**
	 * @return the accountExpiredDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACCOUNT_EXPIRED_DATE")
	public Date getAccountExpiredDate() {
		return accountExpiredDate;
	}


	/**
	 * @return the editable
	 */
	@Column(name = "EDITABLE")
	public Boolean getEditable() {
		return editable;
	}


	/**
	 * @return the users
	 */
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<User> getUsers() {
		return users;
	}
	
	
	/**
	 * @return the roles
	 */

	 
	public Set<Role> getRoles() {
		return roles;
	}


	/**
	 * @return the groups
	 */
	
	public Set<Group> getGroups() {
		return groups;
	}


	/**
	 * default
	 * */
	public User() {
		super();
	}

	/***
	 * 
	 * @param tsDepartment
	 * @param tsUser
	 * @param username
	 * @param sapUsername
	 * @param password
	 * @param passwordHint
	 * @param employeeCode
	 * @param authtype
	 * @param usertype
	 * @param description
	 * @param realnameZh
	 * @param realnameEn
	 * @param telephone
	 * @param mobile
	 * @param officePhone
	 * @param email
	 * @param gender
	 * @param location
	 * @param fax
	 * @param postcode
	 * @param accountExpired
	 * @param accountLocked
	 * @param credentialExpired
	 * @param credentialExpiredDate
	 * @param accountExpiredDate
	 * @param editable
	 * @param users
	 */
	public User(Department department, User tsUser, String username,
			String sapUsername, String password, String passwordHint,
			String employeeCode, String authtype, String usertype,
			String description, String realnameZh, String realnameEn,
			String telephone, String mobile, String officePhone, String email,
			int gender, String location, String fax, String postcode,
			Boolean accountExpired, Boolean accountLocked,
			Boolean credentialExpired, Date credentialExpiredDate,
			Date accountExpiredDate, Boolean editable, Set<User> users) {
		super();
		this.department =department;
		this.user = tsUser;
		this.username = username;
		this.sapUsername = sapUsername;
		this.password = password;
		this.passwordHint = passwordHint;
		this.employeeCode = employeeCode;
		this.authtype = authtype;
		this.usertype = usertype;
		this.description = description;
		this.realnameZh = realnameZh;
		this.realnameEn = realnameEn;
		this.telephone = telephone;
		this.mobile = mobile;
		this.officePhone = officePhone;
		this.email = email;
		this.gender = gender;
		this.location = location;
		this.fax = fax;
		this.postcode = postcode;
		this.accountExpired = accountExpired;
		this.accountLocked = accountLocked;
		this.credentialExpired = credentialExpired;
		this.credentialExpiredDate = credentialExpiredDate;
		this.accountExpiredDate = accountExpiredDate;
		this.editable = editable;
		this.users = users;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param tsDepartment the tsDepartment to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}


	/**
	 * @param departmentId the tsDepartmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	/**
	 * @param tsUser the tsUser to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @param sapUsername the sapUsername to set
	 */
	public void setSapUsername(String sapUsername) {
		this.sapUsername = sapUsername;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @param passwordHint the passwordHint to set
	 */
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}


	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}


	/**
	 * @param authtype the authtype to set
	 */
	public void setAuthtype(String authtype) {
		this.authtype = authtype;
	}


	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @param realnameZh the realnameZh to set
	 */
	public void setRealnameZh(String realnameZh) {
		this.realnameZh = realnameZh;
	}


	/**
	 * @param realnameEn the realnameEn to set
	 */
	public void setRealnameEn(String realnameEn) {
		this.realnameEn = realnameEn;
	}


	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	/**
	 * @param officePhone the officePhone to set
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}


	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	/**
	 * @param accountExpired the accountExpired to set
	 */
	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}


	/**
	 * @param accountLocked the accountLocked to set
	 */
	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}


	/**
	 * @param credentialExpired the credentialExpired to set
	 */
	public void setCredentialExpired(Boolean credentialExpired) {
		this.credentialExpired = credentialExpired;
	}


	/**
	 * @param credentialExpiredDate the credentialExpiredDate to set
	 */
	public void setCredentialExpiredDate(Date credentialExpiredDate) {
		this.credentialExpiredDate = credentialExpiredDate;
	}


	/**
	 * @param accountExpiredDate the accountExpiredDate to set
	 */
	public void setAccountExpiredDate(Date accountExpiredDate) {
		this.accountExpiredDate = accountExpiredDate;
	}


	/**
	 * @param editable the editable to set
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}


	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}


	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
}
