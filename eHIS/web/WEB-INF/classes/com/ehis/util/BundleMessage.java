/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.util;

import java.util.*;
import javax.servlet.jsp.PageContext;

import org.springframework.context.*;
import org.springframework.web.context.support.*;
import org.springframework.beans.factory.*;

import net.sf.ehcache.*;

public final class BundleMessage
{
	
	//For EHCache 
	private static transient BeanFactory beanFactory = null;
	private static transient Cache labelCache = null;

	public static String getBundleMessage(PageContext pageContext,String messageKey,String bundleName, String[] params ){
		
		String returnText = getBundleMessage(pageContext,messageKey,bundleName);

		for(int i=0;i<params.length; i++) {
			if(params[i] !=null){
				messageKey = params[i];
				if(messageKey !=null){
					if(messageKey.indexOf(".") != -1) {
						int msgLen = messageKey.length();
						String val  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,messageKey,bundleName) ;
						if(!val.equals(""))	params[i] = val ;
					}
				}				
			}
		}		
		returnText = java.text.MessageFormat.format( returnText, params );
		return returnText;	
	}

	public static String getBundleMessage(PageContext pageContext,String messageKey,String bundleName ){
	
		String returnText = "???"+messageKey+"???";

		String newBundleName = "";
			
		if (messageKey.startsWith("Common")){
			newBundleName = "eCommon.resources.Labels";
		}else
			newBundleName = messageKey.substring(0,messageKey.indexOf("."))+".resources.Labels";

		String locale = (String) pageContext.getSession().getAttribute("LOCALE");

		//Check to see if the cache facade is already instantiated
		
		if (beanFactory == null){
			ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
			beanFactory = (BeanFactory)appCtx;
			labelCache =  (Cache)beanFactory.getBean("labelCache");				
		}
		
		String cacheKey = messageKey+"."+locale;		
			
		Element cacheElement = labelCache.get(cacheKey);
		if(cacheElement == null){
			ResourceBundle bundle = ResourceBundle.getBundle(newBundleName,new Locale(locale));
			returnText = bundle.getString(messageKey);	
			cacheElement = new Element(cacheKey,returnText);
			labelCache.put(cacheElement);
		}
		returnText = (String)cacheElement.getObjectValue();			
				
		return returnText;	
	}
}
