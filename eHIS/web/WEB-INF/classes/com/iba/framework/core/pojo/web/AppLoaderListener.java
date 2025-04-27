/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 19, 2006
 */
package com.iba.framework.core.pojo.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.ServiceLocator;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * @author S Sabarinathan
 * 
 * @web.listener
 */
public class AppLoaderListener implements ServletContextListener,
		HttpSessionListener, HttpSessionAttributeListener {
	static Logger logger = LogFactory.getApplicationLogger();

	public void contextInitialized(ServletContextEvent arg0) {
		// This starts the Cache service
		AppLoaderListener.logger.debug(AppLoaderListener.class, "context initialized....", null,
				null);
		// CacheService service = ServiceLocator.getInstance().getCache();
		// Cache service = CacheManager.getCache();
		// Loads the Spring bean definitions
		ServiceLocator.getInstance();
		
		CacheManager service =((CacheManager) ServiceLocator.getInstance().getBean("CacheManager"));
		
		 service.startService();
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		AppLoaderListener.logger
				.debug(AppLoaderListener.class, "context destroy....", null,
						null);
		//Cache service = CacheManager.getCache();
		CacheManager service =((CacheManager) ServiceLocator.getInstance().getBean("CacheManager"));
		service.stopService();
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// Create USER SESSION CACHE region
		// Cache service = CacheManager.getCache();

		// service = JBCache.getCache();
		// TODO: When the first object is pushed into the cache with the session
		// id it automatically creates the region
		// do we need to have this here???
		AppLoaderListener.logger.debug(AppLoaderListener.class, "Session id: "
				+ arg0.getSession().getId(), null, null);
		/*
		 * service.putObject(Constants.USER_SESSION_CACHE, arg0.getSession()
		 * .getId(), "dummy","dummy");
		 * service.removeObject(Constants.USER_SESSION_CACHE,arg0.getSession()
		 * .getId(),"dummy");
		 */
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		AppLoaderListener.logger.debug(AppLoaderListener.class, "Session destroy", null, null);
		((CacheManager) ServiceLocator.getInstance().getBean("CacheManager")).removeObject(Constants.USER_SESSION_CACHE,
				arg0.getSession().getId());
	}

	public void attributeAdded(HttpSessionBindingEvent event) {

		/*
		 * String key = event.getName(); Object value = event.getValue();
		 * 
		 * if (key.startsWith("org.apache.struts") || value instanceof
		 * ActionForm) return; // do-nothing
		 * 
		 * HttpSession session = event.getSession();
		 * CacheManager.getCache().putObject(Constants.USER_SESSION_CACHE,
		 * session.getId(), key, value); session.removeAttribute(key);
		 */}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}
}
