/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.persist;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.jsp.PageContext;

import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringCacheBean implements Serializable,ServletContextListener{
	
	private static transient ServletContext servletContext;
	
	private static transient BeanFactory beanFactory;
	private static transient Cache httpSessionCache;
	private static transient Cache messageCache;
	private static transient Cache labelCache;
	
	private static transient SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static transient String [] modulesInstalled = {"eAE","eAM","eBT","eBL","eCA","eCommon","eDR","eFM","eIP","eMM","eMO","eMP","eMR","eOA","eOP","eOR","eOT","ePH","eSM","eST","eXH","eSS","eMO","eCP","eOH","eRS","eXI","eRD"}; //Added V220107 Mohanapriya /Added eRD module
	private static transient String [] supportedLocales = {"en","th"};
	
	private Map map = null;
	
	public SpringCacheBean() {				
	}
	
	public SpringCacheBean(Map m) {				
		this.map = m;
	}
	
	public void setMap(Map m){
		this.map = m;
	}
	
	public Map getMap(){
		return map;
	}
	
	public static SpringCacheBean getCacheBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){

        SpringCacheBean cacheBean = null;
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;
		
		try{
			if (httpSessionCache == null){
				if(beanFactory == null){
					//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
					ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
					beanFactory = (BeanFactory)appContext;
				}
				httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");					
			}
			Element cacheElement = httpSessionCache.get(key);
			if(cacheElement == null){
				System.out.println("Creating new cache bean for sessionid - "+sessionid);
				cacheBean  = new SpringCacheBean(Collections.synchronizedMap(new HashMap()));
				cacheElement = new Element(key,cacheBean);
				httpSessionCache.put(cacheElement);
			}
			cacheBean =  (SpringCacheBean) cacheElement.getObjectValue();						
        }catch (Exception e) {
			e.printStackTrace();			
		}
        return cacheBean;
    }
	
	public void persist(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;

        try{			
        	if (httpSessionCache == null){
				if(beanFactory == null){
					//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
					ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
					beanFactory = (BeanFactory)appContext;
				}
				httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");					
			}
			Element cacheElement = new Element(key,this);
			httpSessionCache.put(cacheElement);			
		}catch (Exception ex) {
			ex.printStackTrace();									
		}         
    }
	
	public void cleanup(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;
		
		try{
			if (httpSessionCache == null){
				if(beanFactory == null){
					//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
					ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
					beanFactory = (BeanFactory)appContext;
				}
				httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");					
			}
			httpSessionCache.remove(key);					
		}catch(Exception exc){
			exc.printStackTrace();	
		}
    }
	
	@Override
	public String toString() {
		return "SpringCacheBean [map=" + map + "]";
	}
	
	public Object getObject(String id,String className,String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        Object tempObj = null;        
        try{
			synchronized (map){
				tempObj = map.get(id);
			}
            if (null == tempObj){
				synchronized (map){
					Class objClass = Class.forName(className);
					tempObj = objClass.newInstance();
					map.put(id,tempObj);	
					persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
				 }				
            }
        }catch(Exception exc){
               exc.printStackTrace();
        }
        return tempObj;
    }
    
    public  void putObject(String id,Object obj,String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){        
        try{
            synchronized (map){
				map.put(id,obj);
				persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
			}            
        }catch(Exception exc){
               exc.printStackTrace();
        }       
    }
    
    /* Start Methods of ServletContextListener */
	public void contextInitialized(ServletContextEvent sce){
		servletContext = sce.getServletContext();	
		if (beanFactory == null){
			ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			beanFactory = (BeanFactory)appContext;			
		}
		
		servletContext.setAttribute("common_messages", new LocalizationContext(ResourceBundle.getBundle("eCommon.resources.Messages")));
    	servletContext.setAttribute("common_labels", new LocalizationContext(ResourceBundle.getBundle("eCommon.resources.Labels")));
    	
    	servletContext.setAttribute("sm_messages", new LocalizationContext(ResourceBundle.getBundle("eSM.resources.Messages")));
    	servletContext.setAttribute("sm_labels", new LocalizationContext(ResourceBundle.getBundle("eSM.resources.Labels")));
    	
    	servletContext.setAttribute("mp_messages", new LocalizationContext(ResourceBundle.getBundle("eMP.resources.Messages")));
    	servletContext.setAttribute("mp_labels", new LocalizationContext(ResourceBundle.getBundle("eMP.resources.Labels")));
    	
    	servletContext.setAttribute("ip_messages", new LocalizationContext(ResourceBundle.getBundle("eIP.resources.Messages")));
    	servletContext.setAttribute("ip_labels", new LocalizationContext(ResourceBundle.getBundle("eIP.resources.Labels")));
    	
    	servletContext.setAttribute("st_messages", new LocalizationContext(ResourceBundle.getBundle("eST.resources.Messages")));
    	servletContext.setAttribute("st_labels", new LocalizationContext(ResourceBundle.getBundle("eST.resources.Labels")));
    	
    	servletContext.setAttribute("mo_messages", new LocalizationContext(ResourceBundle.getBundle("eMO.resources.Messages")));
    	servletContext.setAttribute("mo_labels", new LocalizationContext(ResourceBundle.getBundle("eMO.resources.Labels")));
    	
    	servletContext.setAttribute("am_messages", new LocalizationContext(ResourceBundle.getBundle("eAM.resources.Messages")));
    	servletContext.setAttribute("am_labels", new LocalizationContext(ResourceBundle.getBundle("eAM.resources.Labels")));
    	
    	servletContext.setAttribute("oa_messages", new LocalizationContext(ResourceBundle.getBundle("eOA.resources.Messages")));
    	servletContext.setAttribute("oa_labels", new LocalizationContext(ResourceBundle.getBundle("eOA.resources.Labels")));
    	
    	servletContext.setAttribute("ae_messages", new LocalizationContext(ResourceBundle.getBundle("eAE.resources.Messages")));
    	servletContext.setAttribute("ae_labels", new LocalizationContext(ResourceBundle.getBundle("eAE.resources.Labels")));
    	
    	servletContext.setAttribute("mr_messages", new LocalizationContext(ResourceBundle.getBundle("eMR.resources.Messages")));
    	servletContext.setAttribute("mr_labels", new LocalizationContext(ResourceBundle.getBundle("eMR.resources.Labels")));
    	
    	servletContext.setAttribute("op_messages", new LocalizationContext(ResourceBundle.getBundle("eOP.resources.Messages")));
    	servletContext.setAttribute("op_labels", new LocalizationContext(ResourceBundle.getBundle("eOP.resources.Labels")));
    	servletContext.setAttribute("op_sqlqueries", new LocalizationContext(ResourceBundle.getBundle("eOP.resources.OPSqlQueries")));
    	
    	servletContext.setAttribute("fm_messages", new LocalizationContext(ResourceBundle.getBundle("eFM.resources.Messages")));
    	servletContext.setAttribute("fm_labels", new LocalizationContext(ResourceBundle.getBundle("eFM.resources.Labels")));
    	
    	servletContext.setAttribute("ca_messages", new LocalizationContext(ResourceBundle.getBundle("eCA.resources.Messages")));
    	servletContext.setAttribute("ca_labels", new LocalizationContext(ResourceBundle.getBundle("eCA.resources.Labels")));
    	
    	servletContext.setAttribute("bl_messages", new LocalizationContext(ResourceBundle.getBundle("eBL.resources.Messages")));
    	servletContext.setAttribute("bl_messagesExt", new LocalizationContext(ResourceBundle.getBundle("eBL.resources.MessagesExtOne")));
    	servletContext.setAttribute("bl_labels", new LocalizationContext(ResourceBundle.getBundle("eBL.resources.Labels")));
		servletContext.setAttribute("bl_sqlqueries", new LocalizationContext(ResourceBundle.getBundle("eBL.resources.BLSqlQueries")));
    	
    	servletContext.setAttribute("ot_messages", new LocalizationContext(ResourceBundle.getBundle("eOT.resources.Messages")));
    	servletContext.setAttribute("ot_labels", new LocalizationContext(ResourceBundle.getBundle("eOT.resources.Labels")));
		servletContext.setAttribute("ot_sqlqueries", new LocalizationContext(ResourceBundle.getBundle("eOT.resources.OTSqlQueries")));
    	
    	servletContext.setAttribute("or_messages", new LocalizationContext(ResourceBundle.getBundle("eOR.resources.Messages")));
    	servletContext.setAttribute("or_labels", new LocalizationContext(ResourceBundle.getBundle("eOR.resources.Labels")));
    	
    	servletContext.setAttribute("bt_messages", new LocalizationContext(ResourceBundle.getBundle("eBT.resources.Messages")));
    	servletContext.setAttribute("bt_labels", new LocalizationContext(ResourceBundle.getBundle("eBT.resources.Labels")));
    	
    	servletContext.setAttribute("dr_messages", new LocalizationContext(ResourceBundle.getBundle("eDR.resources.Messages")));
    	servletContext.setAttribute("dr_labels", new LocalizationContext(ResourceBundle.getBundle("eDR.resources.Labels")));
    	
    	servletContext.setAttribute("ph_messages", new LocalizationContext(ResourceBundle.getBundle("ePH.resources.Messages")));
    	servletContext.setAttribute("ph_labels", new LocalizationContext(ResourceBundle.getBundle("ePH.resources.Labels")));
    	
    	servletContext.setAttribute("xh_messages", new LocalizationContext(ResourceBundle.getBundle("eXH.resources.Messages")));
    	servletContext.setAttribute("xh_labels", new LocalizationContext(ResourceBundle.getBundle("eXH.resources.Labels")));
    	
    	servletContext.setAttribute("oh_messages", new LocalizationContext(ResourceBundle.getBundle("eOH.resources.Messages")));
    	servletContext.setAttribute("oh_labels", new LocalizationContext(ResourceBundle.getBundle("eOH.resources.Labels")));
    	
    	servletContext.setAttribute("ss_messages", new LocalizationContext(ResourceBundle.getBundle("eSS.resources.Messages")));
    	servletContext.setAttribute("ss_labels", new LocalizationContext(ResourceBundle.getBundle("eSS.resources.Labels")));
    	
    	servletContext.setAttribute("cp_messages", new LocalizationContext(ResourceBundle.getBundle("eCP.resources.Messages")));
    	servletContext.setAttribute("cp_labels", new LocalizationContext(ResourceBundle.getBundle("eCP.resources.Labels")));
    	
    	servletContext.setAttribute("rs_messages", new LocalizationContext(ResourceBundle.getBundle("eRS.resources.Messages")));
    	servletContext.setAttribute("rs_labels", new LocalizationContext(ResourceBundle.getBundle("eRS.resources.Labels")));
    	
    	servletContext.setAttribute("xi_messages", new LocalizationContext(ResourceBundle.getBundle("eXI.resources.Messages")));
    	servletContext.setAttribute("xi_labels", new LocalizationContext(ResourceBundle.getBundle("eXI.resources.Labels")));    	
    	
    	servletContext.setAttribute("mm_labels", new LocalizationContext(ResourceBundle.getBundle("eMM.resources.Labels")));

		servletContext.setAttribute("po_messages", new LocalizationContext(ResourceBundle.getBundle("ePO.resources.Messages")));
    	servletContext.setAttribute("po_labels", new LocalizationContext(ResourceBundle.getBundle("ePO.resources.Labels")));    	
    	
    	servletContext.setAttribute("ds_messages", new LocalizationContext(ResourceBundle.getBundle("eDS.resources.Messages")));
    	servletContext.setAttribute("ds_labels", new LocalizationContext(ResourceBundle.getBundle("eDS.resources.Labels")));
    	 //Added V220107 Mohanapriya /Extending a new Messages file Starts
    	servletContext.setAttribute("rd_messages", new LocalizationContext(ResourceBundle.getBundle("eRD.resources.Messages")));
    	servletContext.setAttribute("rd_labels", new LocalizationContext(ResourceBundle.getBundle("eRD.resources.Labels")));
    	 //Added V220107 Mohanapriya /Extending a new Messages file ends
	}

	public void contextDestroyed(ServletContextEvent sce){
		servletContext = null;
		beanFactory = null;
	}
	/*End Methods of ServletContextListener */	

	/* Start Methods for caching labels */
	public static String getLabel(PageContext context,String labelId,String bundle){		
		String locale = (String) context.getSession().getAttribute("LOCALE");
		if (locale == null) locale="en";
		return getLabel(locale,labelId,bundle);
	}

	public static String getLabel(String locale,String labelId,String bundleId){
		String bundleName = "";
		String label = null;

		if (labelId.startsWith("Common")) bundleName = "eCommon.resources.Labels";
		else bundleName = labelId.substring(0,labelId.indexOf("."))+".resources.Labels";
		
		if (labelCache == null){
			if(beanFactory == null){
				//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
				beanFactory = (BeanFactory)appContext;
			}
			labelCache =  (Cache)beanFactory.getBean("labelCache");					
		}

		String cacheKey = labelId+"."+locale;
		Element cacheElement = labelCache.get(cacheKey);
		if(cacheElement == null){
			ResourceBundle bundle = ResourceBundle.getBundle(bundleName,new Locale(locale));
			label = bundle.getString(labelId);			
			cacheElement = new Element(cacheKey,label);
			labelCache.put(cacheElement);
		}
		label = (String)cacheElement.getObjectValue();
		
		//Could not find the message, for the key, so log it 
		if (label == null){
			label ="???"+labelId+"???"; 
			System.out.println("Missing resource for "+labelId+" in "+bundleName+" for locale "+locale);
		}

		return label;
	}
	/* End Methods for caching labels */

	
	/* Start Methods for caching messages */
	public static String getMessage(PageContext context,String messageId,String moduleId){		
		String locale = (String) context.getSession().getAttribute("LOCALE");
		if (locale == null) locale="en";
		return getMessage(locale,messageId,moduleId);
	}

	public static String getMessage(String locale,String messageId,String moduleId){
		String message = null;
		
		String bundleName = "eCommon.resources.Messages";

		if(moduleId.equalsIgnoreCase("mp"))	bundleName="eMP.resources.Messages";
		else if(moduleId.equalsIgnoreCase("sm"))	bundleName="eSM.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ip"))	bundleName="eIP.resources.Messages";
		else if(moduleId.equalsIgnoreCase("st"))	bundleName="eST.resources.Messages";
		else if(moduleId.equalsIgnoreCase("mo"))	bundleName="eMO.resources.Messages";
		else if(moduleId.equalsIgnoreCase("am"))	bundleName="eAM.resources.Messages";
		else if(moduleId.equalsIgnoreCase("oa"))	bundleName="eOA.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ae"))	bundleName="eAE.resources.Messages";
		else if(moduleId.equalsIgnoreCase("mr"))	bundleName="eMR.resources.Messages";
		else if(moduleId.equalsIgnoreCase("op"))	bundleName="eOP.resources.Messages";
		else if(moduleId.equalsIgnoreCase("mm"))	bundleName="eMM.resources.Messages";
		else if(moduleId.equalsIgnoreCase("fm"))	bundleName="eFM.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ca"))	bundleName="eCA.resources.Messages";
		else if(moduleId.equalsIgnoreCase("bl"))	bundleName="eBL.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ot"))	bundleName="eOT.resources.Messages";
		else if(moduleId.equalsIgnoreCase("or"))	bundleName="eOR.resources.Messages";
		else if(moduleId.equalsIgnoreCase("bt"))	bundleName="eBT.resources.Messages";
		else if(moduleId.equalsIgnoreCase("dr"))	bundleName="eDR.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ph"))	bundleName="ePH.resources.Messages";
		else if(moduleId.equalsIgnoreCase("xh"))	bundleName="eXH.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ss"))	bundleName="eSS.resources.Messages";
		else if(moduleId.equalsIgnoreCase("mo"))	bundleName="eMO.resources.Messages";
		else if(moduleId.equalsIgnoreCase("cp"))	bundleName="eCP.resources.Messages";
		else if(moduleId.equalsIgnoreCase("oh"))	bundleName="eOH.resources.Messages";
		else if(moduleId.equalsIgnoreCase("rs"))	bundleName="eRS.resources.Messages";
		else if(moduleId.equalsIgnoreCase("xi"))	bundleName="eXI.resources.Messages";
		else if(moduleId.equalsIgnoreCase("po"))	bundleName="ePO.resources.Messages";
		else if(moduleId.equalsIgnoreCase("ds"))	bundleName="eDS.resources.Messages";
		else if(moduleId.equalsIgnoreCase("blext"))	bundleName="eBL.resources.MessagesExtOne";//Added V191110-Aravindh/Extending a new Messages file
		else if(moduleId.equalsIgnoreCase("opsql"))	bundleName="eOP.resources.OPSqlQueries";
		else if(moduleId.equalsIgnoreCase("otsql"))	bundleName="eOT.resources.OTSqlQueries"; // Added for MOHE-SCF-0208
		else if(moduleId.equalsIgnoreCase("blsql"))	bundleName="eBL.resources.BLSqlQueries"; // Added for MOHE-SCF-0196
		else if(moduleId.equalsIgnoreCase("rd"))	bundleName="eRD.resources.Messages"; //Added V220107 Mohanapriya /Extending a new Messages file

		if (messageCache == null){
			if(beanFactory == null){
				//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
				beanFactory = (BeanFactory)appContext;
			}
			messageCache =  (Cache)beanFactory.getBean("messageCache");					
		}
		

		String cacheKey = moduleId.toUpperCase()+"."+messageId+"."+locale;
		Element cacheElement = messageCache.get(cacheKey);
		if(cacheElement == null){
			ResourceBundle bundle = ResourceBundle.getBundle(bundleName,new Locale(locale));
			message = bundle.getString(messageId);			
			cacheElement = new Element(cacheKey,message);
			messageCache.put(cacheElement);
		}
		message = (String)cacheElement.getObjectValue();		
		
		//Could not find the message, for the key, so log it 
		if (message == null){
			message ="???"+messageId+"???"; 
			System.out.println("Missing resource for "+messageId+" in "+bundleName+" for locale "+locale);
		}

		return message;
	}
	/*End Methods for caching messages */
	
}

