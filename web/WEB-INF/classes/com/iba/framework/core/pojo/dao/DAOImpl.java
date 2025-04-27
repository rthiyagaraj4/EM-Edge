/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.pojo.dao;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.util.QueryGetter;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.JdbcConnectionException;
import com.iba.framework.core.util.ApplicationPropertyReader;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.NamedQuery;
import com.iba.framework.core.util.ServiceLocator;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * 
 * @spring.property name="sessionFactory" ref="sessionFactory"
 */
public class DAOImpl extends AbstractDAO implements CRUDDAO {

	private DTO dto = null;

	/** *Constructors * * */
	public DAOImpl() {
	}

	public final Serializable create(Object transientInstance)
			throws DuplicateRecordException, ApplicationException {
		Serializable obj = null;
		IBALogger.getLogger().debug(this.getClass(),
				" create()  of DAOImpl......", null);
			obj = getOrmTemplate().save(transientInstance);
		return obj;
	}

	public final Serializable create(Object[] transientInstance)
			throws DuplicateRecordException, ApplicationException {
		Serializable obj = null;
		try{
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			for (int i = 0; i < transientInstance.length; i++) {
				transientInstance[i] = getOrmTemplate().save(transientInstance[i]);
			}
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}

		return obj;
	}

	public final void update(Object transientInstance)
			throws DuplicateRecordException, ApplicationException {
		try
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			getOrmTemplate().update(transientInstance);
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}
	}

	public final void update(Object[] transientInstance)
			throws DuplicateRecordException, ApplicationException {
		try{
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			for (int i = 0; i < transientInstance.length; i++) {
				getOrmTemplate().update(transientInstance[i]);
			}
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}

	}

	public final void delete(Object transientInstance)
			throws ApplicationException {
		try{
			IBALogger.getLogger().debug(this.getClass(),
					" delete()  of DAOImpl......", null);
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			getOrmTemplate().delete(transientInstance);
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}
	}

	public final void delete(Object[] transientInstance)
			throws ApplicationException {
		try{
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			for (int i = 0; i < transientInstance.length; i++) {
				getOrmTemplate().delete(transientInstance[i]);
			}
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}
	}

	protected final void CreateOrUpdate(Object transientInstance)
			throws ApplicationException {
		try{
			IBALogger.getLogger().debug(this.getClass(),
					" CreateOrUpdate()  of DAOImpl......", null);
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			getOrmTemplate().saveOrUpdate(transientInstance);
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}
	}

	protected final void CreateOrUpdate(Object[] transientInstance)
			throws ApplicationException {
		try
		{
			IBALogger.getLogger().debug(this.getClass(),
					" CreateOrUpdate()  of DAOImpl......", null);
			getOrmTemplate().getSessionFactory().getCurrentSession().beginTransaction();
			for (int i = 0; i < transientInstance.length; i++) {
				getOrmTemplate().saveOrUpdate(transientInstance[i]);
			}
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		catch(Exception ee)
		{
			getOrmTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
			throw (ApplicationException)ee;
		}
	}

	public final Object findByQuery(DAOCommand command)
			throws ApplicationException {
		dto = new DTO();

		try {
			NamedQuery namedQuery = (NamedQuery) command.getObject();
			Session session = (getOrmTemplate().getSessionFactory())
					.getCurrentSession();
			Query query = null;
			if (ApplicationPropertyReader.getQueryLoadType().equals(
					Constants.STATIC_QUERY_LOAD))
				query = session.getNamedQuery(namedQuery.getQueryID());
			else if (ApplicationPropertyReader.getQueryLoadType().equals(
					Constants.DYNAMIC_QUERY_LOAD)) {
				try {
					query = session.createQuery(getQuery(namedQuery
							.getQueryID()));
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				throw new ApplicationException(
						"Invalid query_load_type attribute set in the application properties; the value should be static/dynamic");
			}

			if (namedQuery.getOrderByClause() != null 
					&& !namedQuery.getOrderByClause().equals("")) {			// Corrected for 35380 by Subhani Sayyad
				StringBuffer hqlString = new StringBuffer(query
						.getQueryString());
				
				if(!(hqlString.toString().indexOf("order by") != -1))
				hqlString.append(" order by ");	
				else{
					hqlString.append(",");		
				}
				hqlString.append(namedQuery.getOrderByClause());
				query = session.createQuery(hqlString.toString());
			}
			query.setCacheable(true);
			query.setCacheMode(CacheMode.NORMAL);
			String[] namedParameters = query.getNamedParameters();

			Map dataList = namedQuery.getDataMap();

			for (int i = 0; i < namedParameters.length; i++) {
				Object paramValue = "%";
				if (dataList != null)
					paramValue = dataList.get(namedParameters[i]);
				paramValue = (paramValue == null ? "%" : paramValue);

				query.setParameter(namedParameters[i], paramValue);
			}

			if (namedQuery.getPage().isPagingEnabled()) {
				query.setFirstResult((namedQuery.getPage().getPageNo() - 1)
						* namedQuery.getPage().getPageSize());
				query.setMaxResults(namedQuery.getPage().getPageSize() + 1);
			}

			List list = query.list();
			dto.setObject(list);
			if (namedQuery.getPage().isPagingEnabled())
				namedQuery.getPage()
						.setNextPage(
								(list.size() > namedQuery.getPage()
										.getPageSize() ? true : false));
			if (namedQuery.getPage().isPagingEnabled()
					&& list.size() > namedQuery.getPage().getPageSize())
				list.remove(list.size() - 1);
			dto.setPage(namedQuery.getPage());
		} catch (HibernateException e) {
			dto.setException(e);
			throw e;
		}

		return dto;
	}

	public final Object findById(DAOCommand command) {
		try {
			Object instance = getOrmTemplate().load(command.getEntityClass(),
					(Serializable) command.getObject());
			dto = new DTO();
			dto.setObject(instance);

		} catch (RuntimeException re) {
			dto.setException(re);
			throw re;
		}
		return dto;
	}

	public final DTO findByObject(DAOCommand command) {

		Object instance = command.getObject();
		try {
			IBALogger.getLogger().debug(this.getClass(),
					" findByObject()  of DAOImpl......", null);
			Session session = (getOrmTemplate().getSessionFactory())
					.getCurrentSession();
			Criteria criteria = session.createCriteria(instance.getClass());

			Example example = Example.create(instance);
			example.enableLike();
			List results = criteria.add(example).list();

			dto = new DTO();
			dto.setObject(results);
		} catch (RuntimeException re) {
			re.printStackTrace();
			dto.setException(re);
			throw re;
		}
		return dto;
	}

	/**
	private String getQuery(String queryId)
			throws ParserConfigurationException, SAXException, IOException {
		String query = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		ClassLoader bundleClassLoader = Thread.currentThread()
				.getContextClassLoader();
		URL url = bundleClassLoader.getResource((String) ServiceLocator
				.getInstance().getBean("queryMapFile"));
		Document doc = builder.parse(new File(url.getFile()));

		// Get the initial query nodes
		NodeList queryNodes = doc.getChildNodes().item(3).getChildNodes();

		for (int queryNodeIndex = 0; queryNodeIndex < queryNodes.getLength(); queryNodeIndex++) {
			// Go only through the query Element nodes
			if (queryNodes.item(queryNodeIndex).getNodeType() == Node.ELEMENT_NODE) {

				Element queryElement = (Element) queryNodes
						.item(queryNodeIndex);
				// Get the query ID
				String queryID = queryElement.getAttribute("name");
				if (queryID.equals(queryId)) {
					query = getContentText(queryElement);
				}

			}
		}

		return query;
	}
*/
	private String getQuery(String queryId)
	throws ParserConfigurationException, SAXException, IOException {
return QueryGetter.getQuery(queryId);
}
	private String getContentText(Element element) {
		StringBuffer buffer = new StringBuffer();
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof CharacterData) {
				CharacterData characterData = (CharacterData) node;
				buffer.append(characterData.getData());
			}
		}
		return buffer.toString();
	}

	public Connection getJdbcConnection() throws JdbcConnectionException {
		Connection connection = null;
		try {
			DataSource dataSource = (DataSource) ServiceLocator.getInstance()
					.getBean("dataSource");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new JdbcConnectionException("JDBC EX", e);
		}

		return connection;
	}
}
