/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on May 19, 2006
 */
package com.iba.framework.core.util;

import java.text.MessageFormat;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.iba.framework.core.exception.ServiceLocatorException;

/**
 * This class is implemented as a singleton class and is a central place for
 * looking up objects in the Spring Bean Factory and JNDI.
 * 
 * @author S Sabarinathan
 * 
 */
public class ServiceLocator implements Constants {

	private static ServiceLocator locator;

	private Context context;

	private ApplicationContext springAppContext;

	private ServiceLocator()
    throws ServiceLocatorException
{
    try
    {
        context = new InitialContext();
        String configPropFiles[] = ApplicationPropertyReader.getConfigFiles();
        if(configPropFiles == null)
            configPropFiles = new String[0];
        String configFiles[] = new String[3 + configPropFiles.length];
        configFiles[0] = "spring-orm.xml";
        configFiles[1] = "spring-jms.xml";
        configFiles[2] = "app-beans.xml";
        int j = 3;
        for(int i = 0; i < configPropFiles.length; i++)
        {
            configFiles[j] = configPropFiles[i];
            j++;
        }

        springAppContext = new ClassPathXmlApplicationContext(configFiles);
    }
    catch(NamingException e)
    {
        throw new ServiceLocatorException("SYS_500", e);
    }
    catch(Exception e)
    {
        throw new ServiceLocatorException("Problem unknown. Please check the exception stacktrace.", "Found unknown problem. Please check the log for details.", e);
    }
}


	private ServiceLocator(ServletContext servletCtx)
			throws ServiceLocatorException {
		try {
			context = new InitialContext();
			springAppContext = WebApplicationContextUtils
					.getWebApplicationContext(servletCtx);
		} catch (NamingException e) {
			throw new ServiceLocatorException(Constants.FATAL_ERROR, e);
		} catch (Exception e) {
			throw new ServiceLocatorException(Constants.FATAL_ERROR,
					MessageConstants.PROBLEM_UNKNOWN, e);
		}
	}

	public static ServiceLocator getInstance() throws ServiceLocatorException {
		if (locator == null)
			locator = new ServiceLocator();
		return locator;
	}

	public static ServiceLocator getInstance(ServletContext context)
			throws ServiceLocatorException {
		if (locator == null)
			locator = new ServiceLocator(context);
		return locator;
	}

	/**
	 * Spring Bean Lookup
	 * 
	 * @param beanId
	 * @return
	 */
	public Object getBean(String beanId) throws ServiceLocatorException {
		Object oBean = null;
		if ((beanId == null) || (beanId != null && beanId.equals(""))) {
			throw new ServiceLocatorException(Constants.FATAL_ERROR,
					MessageConstants.BEANID_REQUIRED);
		}
		try {
			oBean = springAppContext.getBean(beanId);
		} catch (NoSuchBeanDefinitionException e) {
			throw new ServiceLocatorException(Constants.FATAL_ERROR,
					MessageFormat.format(MessageConstants.MISSING_BEAN_ENTRY,
							new Object[] { beanId }), e);
		}
		return oBean;
	}

	public String getMessage() {
		return springAppContext.getMessage("DiscreteMeasure.Event", null,
				"Required", null);
	}

	/**
	 * @return Returns the context.
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context
	 *            The context to set.
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	public String getMessage(String key, Object args[], Locale locale) {
		return springAppContext.getMessage(key, null, locale);
	}

}
