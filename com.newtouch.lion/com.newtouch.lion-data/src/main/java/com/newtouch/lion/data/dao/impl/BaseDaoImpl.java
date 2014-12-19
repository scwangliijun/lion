/*
 * Copyright (c)  2012, lion
 * All rights reserved. 
 *
 * $id: BaseDaoImpl.java 9552 2012-7-8 上午01:18:39 WangLijun$
 */
package com.newtouch.lion.data.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newtouch.lion.data.dao.BaseDao;
import com.newtouch.lion.data.page.PageResult;
import com.newtouch.lion.data.session.AppContext;
import com.newtouch.lion.model.AuditEntity;
import com.newtouch.lion.model.BaseEntity;

/**
 * <p>
 * Title:数据存储类，用于处理数据
 * </p>
 * <p>
 * Description:该类支持SQL、HSQL等方式进行查询，用保存、查询、更新、分页等功能
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

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	private static final long serialVersionUID = 840623395509475191L;

	protected final Logger log = LoggerFactory.getLogger(super.getClass());

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		if (!(ParameterizedType.class.isAssignableFrom(super.getClass()
				.getGenericSuperclass().getClass())))
			return;
		Type[] actualTypeArguments = ((ParameterizedType) super.getClass()
				.getGenericSuperclass()).getActualTypeArguments();
		this.entityClass = (Class<T>) actualTypeArguments[0];
	}

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	private void addAuditInfo(T obj) {
		if (obj instanceof AuditEntity) {
			AuditEntity obj1 = (AuditEntity) obj;

			Long id = obj1.getId();
			if ((id == null) || (id.longValue() <= 0L)) {
				obj1.setCreatedById(AppContext.getUserInfo().getId());
				if (obj1.getCreatedDate() == null) {
					obj1.setCreatedDate(Calendar.getInstance().getTime());
				}
			}
			obj1.setUpdatedById(AppContext.getUserInfo().getId());
			log.info("userId:{}",AppContext.getUserInfo().getId());
			obj1.setUpdatedDate(Calendar.getInstance().getTime());
		}
	}

	/*
	 * <p>Title: findById</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.lion.framework.dao.BaseDao#findById(java.lang.Long)
	 */

	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) this.getCurrentSession().load(this.entityClass, id);
	}

	/*
	 * <p>Title: findAll</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.lion.framework.dao.BaseDao#findAll()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#getById(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		return (T) this.getCurrentSession().get(this.entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#findByIdNoWaitLock(java.lang.Long)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public T findByIdNoWaitLock(Long id) {
		return ((T) this.getCurrentSession().load(this.entityClass, id,
				LockMode.UPGRADE_NOWAIT));
	}

	/***
	 * @see
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String hql="from "+this.entityClass.getSimpleName();
		Query query = this.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public void eagerLoad(T obj) {
		 Hibernate.initialize(obj);
	}

	public void evict(T obj) {
		this.getCurrentSession().evict(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#find(com.lion.framework.model.
	 * BaseEntity )
	 */

	@Override
	public List<T> find(T obj) {
		//TODO
		// return super.getHibernateTemplate().findByExample(obj);
		// return this.getCurrentSession().bySimpleNaturalId(obj);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#updateHQL(java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public int updateHQL(String hql, Map<String, ?> params) {
		Session session = this.getCurrentSession();
		Query  query=session.createQuery(hql);
		query.setProperties(params);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryName, Map<String, Object> params) {
		Session session = this.getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		query.setProperties(params);
		return query.list();
	}

	/*
	 * <p>Title: flush</p> <p>Description: </p>
	 * 
	 * @see com.lion.framework.dao.BaseDao#flush()
	 */

	public void flush() {
		this.getCurrentSession().flush();
	}

	/*
	 * <p>Title: clear</p> <p>Description: </p>
	 * 
	 * @see com.lion.framework.dao.BaseDao#clear()
	 */

	public void clear() {
		this.getCurrentSession().clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#lock(com.lion.framework.model.
	 * BaseEntity , org.hibernate.LockMode)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void lock(T entity, LockMode lockMode) {
		this.getCurrentSession().lock(entity, lockMode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#nativeQueryCountSQL(java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public Long nativeQueryCountSQL(String countSql, Map<String, ?> params) {

		SQLQuery query = this.getCurrentSession().createSQLQuery(countSql);
		query.setProperties(params);
		return (Long) query.uniqueResult();
	}

	private SQLQuery createSQLQuery(String sql, Map<String, ?> params) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#nativeQuerySQL(java.lang.String,
	 * java.lang.String, java.util.Map, int, int)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageResult<T> nativeQuerySQL(String sql, String countSql,
			Map<String, ?> params, int offsetIndex, int pageSize) {
		PageResult<T> pr = new PageResult<T>();

		pr.setCurrentIndex(offsetIndex);
		pr.setPageSize(pageSize);

		if (countSql != null) {
			pr.setTotalCount(nativeQueryCountSQL(countSql, params));
		}

		if (pageSize != 0) {
			pr.setTotalPage((pr.getTotalCount() + pageSize - 1) / pageSize);
			pr.setCurrentPage((offsetIndex + pageSize) / pageSize);
		}
		SQLQuery query = this.createSQLQuery(sql, params);
		query.setFirstResult(offsetIndex);
		query.setMaxResults(pageSize);
		List content = query.list();
		pr.setContent(content);
		return pr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#nativeUpdateSQL(java.lang.String,
	 * java.util.Map)
	 */

	@Override
	public int nativeUpdateSQL(String sql, Map<String, ?> params) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		sqlQuery.setProperties(params);
		return Integer.valueOf(sqlQuery.executeUpdate());
	}

	@SuppressWarnings("unchecked")
	public List<T> query(String hql, Map<String, ?> params) {

		Query query = this.getCurrentSession().createQuery(hql);
		query.setProperties(params);
		return query.list();
	}

	/*
	 * <p>Title: query</p> <p>Description: </p>
	 * 
	 * @param hql
	 * 
	 * @param countHql
	 * 
	 * @param params
	 * 
	 * @param offsetIndex
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @see com.lion.framework.dao.BaseDao#query(java.lang.String,
	 * java.lang.String, java.util.Map, int, int)
	 */

	@SuppressWarnings({ "unchecked" })
	public PageResult<T> query(String hql, String countHql,
			Map<String, ?> params, int offsetIndex, int pageSize) {
		PageResult<T> pageResult = new PageResult<T>();

		pageResult.setCurrentIndex(offsetIndex);
		pageResult.setPageSize(pageSize);

		if (countHql != null) {

			pageResult.setTotalCount(this.queryCount(countHql, params));
		}

		if (pageSize != 0) {
			pageResult.setTotalPage((pageResult.getTotalCount() + pageSize - 1)
					/ pageSize);
			pageResult.setCurrentPage((offsetIndex + pageSize) / pageSize);
		}
		Query query = this.getCurrentSession().createQuery(hql);
		query.setProperties(params);
		query.setFirstResult(offsetIndex);
		query.setMaxResults(pageSize);
		List<T> content = query.list();
		pageResult.setContent(content);
		return pageResult;
	}

	/*
	 * <p>Title: queryCount</p> <p>Description: </p>
	 * 
	 * @param countHql
	 * 
	 * @param params
	 * 
	 * @return
	 * 
	 * @see com.lion.framework.dao.BaseDao#queryCount(java.lang.String,
	 * java.util.Map)
	 */

	public Long queryCount(final String countHql, final Map<String, ?> params) {

		Query query = this.getCurrentSession().createQuery(countHql);
		query.setProperties(params);
		return (Long) query.uniqueResult();

	}

	/**
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param obj
	 * 
	 * @see com.lion.framework.dao.BaseDao#save(com.lion.framework.model.BaseEntity
	 *      )
	 */

	public void save(T obj) {
		this.addAuditInfo(obj);
		this.getCurrentSession().saveOrUpdate(obj);
	}

	/**
	 * <p>
	 * Title: saveObjects
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param objs
	 * 
	 * @see com.lion.framework.dao.BaseDao#saveObjects(java.util.Collection)
	 */

	public void saveObjects(Collection<T> objs) {
		for (T obj : objs) {
			addAuditInfo(obj);
		}
		// super.getHibernateTemplate().saveOrUpdateAll(objs);
		this.getCurrentSession().saveOrUpdate(objs);
	}

	/***
	 * @see om.lion.framework.dao.BaseDao#mergeObject(com.lion.framework.model.BaseEntity)
	 */
	public void mergeObject(T obj) {
		this.getCurrentSession().merge(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#remove(com.lion.framework.model.
	 * BaseEntity)
	 */
	@Override
	public void remove(T obj) {
		this.getCurrentSession().delete(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#removeObjects(java.util.Collection)
	 */
	@Override
	public void removeObjects(Collection<T> objs) {
		// TODO
		this.getCurrentSession().delete(objs);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#findEntityAll(java.lang.Class)
	 */
	@Override
	public List<T> findEntityAll(Class<T> clazz) {
		// return this.getCurrentSession().l
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#updateByNamedQuery(java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public int updateByNamedQuery(String queryName, Map<String, Object> params) {
		Query query = this.getCurrentSession().getNamedQuery(queryName);
		query.setProperties(params);
		return query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#update(com.lion.framework.model.
	 * BaseEntity)
	 */
	@Override
	public void update(T obj) {
		this.addAuditInfo(obj);
		this.update(obj, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#update(com.lion.framework.model.
	 * BaseEntity, java.util.Date)
	 */
	@Override
	public void update(T obj, Date updateDate) {
		this.updateEntity((AuditEntity) obj, updateDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#updateObjects(com.lion.framework
	 * .model.BaseEntity)
	 */
	@Override
	public void updateObjects(Collection<T> objs) {
		updateObjects(objs, null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#updateObjects(com.lion.framework
	 * .model.BaseEntity, java.util.Date)
	 */
	@Override
	public void updateObjects(Collection<T> objs, Date updateDate) {
		// TODO Auto-generated method stub
		for (Iterator<T> localIterator = objs.iterator(); localIterator
				.hasNext();) {
			Object obj = localIterator.next();
			updateEntity((AuditEntity) obj, updateDate);
		}
	}

	/***
	 * 
	 * @param o
	 * @param updateDate
	 */
	private void updateEntity(AuditEntity obj, Date updateDate) {
		if (updateDate == null) {
			obj.setUpdatedDate(Calendar.getInstance().getTime());
		} else {
			obj.setUpdatedDate(updateDate);
		}
		this.getCurrentSession().merge(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lion.framework.dao.BaseDao#getsSequenceNextval(java.lang.String)
	 */
	public long getsSequenceNextval(String sequenceName) {
		String sql = "select " + sequenceName + ".Nextval as seq from dual";
		return (Long) this.getCurrentSession().createSQLQuery(sql)
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#getTables(java.lang.String,
	 * java.lang.String)
	 */
	public List<String> getTables(String schemaPattern, String tableNamePattern) {
		List<String> tables = new ArrayList<String>();

		// try {
		// Connection con = super.getSession().
		// //DatabaseMetaData meta = con.getMetaData();
		// ResultSet rs = meta.getTables(null, schemaPattern,
		// tableNamePattern, new String[] { "TABLE" });
		// while (rs.next())
		// tables.add(rs.getString(3));
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

		return tables;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.dao.BaseDao#getColumns(java.lang.String)
	 */
	@Override
	public List<String> getColumns(String tableName) {
		List<String> columns = new ArrayList<String>();
		// String sql = "SELECT * FROM " + tableName + " WHERE 1 != 1";
		//
		// try {
		//
		// SQLQuery rs = super.getSession().createSQLQuery(sql);
		// ResultSetMetaData meta = rs.
		// int cols = meta.getColumnCount();
		// for (int i = 1; i <= cols; ++i)
		// columns.add(meta.getColumnName(i));
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

		return columns;
	}

}
