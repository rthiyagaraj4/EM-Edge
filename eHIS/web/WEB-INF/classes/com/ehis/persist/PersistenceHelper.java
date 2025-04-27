/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.persist;

import java.sql.Timestamp;
import java.util.Properties;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eCommon.Common.CommonAdapter;

public class PersistenceHelper {

	private static transient SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/* START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE */
	public static Object getBean(String sessionid,String userid,String ws_no,Timestamp session_creation_date,Properties jdbc_props){
		return SpringCacheBean.getCacheBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public static Object getObjectFromBean(String id,String ClassName,HttpSession session){
		Object returnObject = null;
		String sessionid = session.getId();
		
		String userid = (String)session.getValue("login_user");
		Timestamp session_creation_date = new Timestamp(session.getCreationTime());
		Properties jdbc_props = (Properties)session.getValue("jdbc");
		String ws_no = (String)jdbc_props.getProperty("client_ip_address");
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;		
		String key = sessionid;
				
		synchronized (key.intern()) {
			SpringCacheBean cacheBean = (SpringCacheBean)getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
			returnObject = cacheBean.getObject(id,ClassName,sessionid,userid,ws_no,session_creation_date,jdbc_props);
		}
		return returnObject;
	}

	public static void putObjectInBean(String id,Object obj,HttpSession session){
		String sessionid = session.getId();
		
		String userid = (String)session.getValue("login_user");
		Timestamp session_creation_date = new Timestamp(session.getCreationTime());
		Properties jdbc_props = (Properties)session.getValue("jdbc");
		String ws_no = (String)jdbc_props.getProperty("client_ip_address");
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;		
		String key = sessionid;
		
		synchronized (key.intern()) {		

			SpringCacheBean cacheBean = (SpringCacheBean)getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
			cacheBean.putObject(id,obj,sessionid,userid,ws_no,session_creation_date,jdbc_props);
		}
	}

	/* END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/* START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public static Object getBeanObject(String id,String ClassName,HttpServletRequest request){

		HttpSession session = request.getSession(false);
		
		Object returnObject = null;
		
		String sessionid = session.getId();	
		String userid = (String)session.getValue("login_user");
		Timestamp session_creation_date = new Timestamp(session.getCreationTime());
		Properties jdbc_props = (Properties)session.getValue("jdbc");
		String ws_no = (String)jdbc_props.getProperty("client_ip_address");
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;
		
		synchronized (key.intern()) {			
			
			SpringCacheBean cacheBean = (SpringCacheBean)getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
			 
			returnObject = cacheBean.getObject(id,ClassName,sessionid,userid,ws_no,session_creation_date,jdbc_props);
			
			CommonAdapter userBean = (CommonAdapter)returnObject;
			
			userBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
			if(userBean.getProperties() == null || userBean.getLoginById() == null || userBean.getAccEntityID() == null || userBean.getLoginAtWsNo() == null){
				if(userBean.getProperties() == null)
					userBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
				if(userBean.getLoginById() == null)
					userBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
				if(userBean.getAccEntityID() == null)
					userBean.setAccEntityID( (String) session.getValue( "ACC_ENTITY_ID" ) ) ;
				if(userBean.getLoginAtWsNo() == null)
					userBean.setLoginAtWsNo( userBean.getProperties().getProperty( "client_ip_address" ) ) ;
				putObjectInBean( id,returnObject,request);
			}

			 if(userBean.getMode() == null){
	               userBean.setMode("") ;
	               userBean.initialize() ;
				   putObjectInBean( id,returnObject,request);
	         }
		}
		
		return returnObject ;
	}

	public static void putObjectInBean(String id,Object obj,HttpServletRequest request){

		HttpSession session = request.getSession(false);
		String sessionid = session.getId();
		
		String userid = (String)session.getValue("login_user");
		Timestamp session_creation_date = new Timestamp(session.getCreationTime());
		Properties jdbc_props = (Properties)session.getValue("jdbc");
		String ws_no = (String)jdbc_props.getProperty("client_ip_address");
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;
		
		synchronized (key.intern()) {			

			SpringCacheBean cacheBean = (SpringCacheBean)getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
			cacheBean.putObject(id,obj,sessionid,userid,ws_no,session_creation_date,jdbc_props);
		}		
	}

	public static void cleanBeanObject(String id,String className,HttpServletRequest request){

		HttpSession session = request.getSession(false);
		String sessionid = session.getId();
		
		String userid = (String)session.getValue("login_user");
		Timestamp session_creation_date = new Timestamp(session.getCreationTime());
		Properties jdbc_props = (Properties)session.getValue("jdbc");
		String ws_no = (String)jdbc_props.getProperty("client_ip_address");
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;
		
		synchronized (key.intern()) {
			SpringCacheBean cacheBean = (SpringCacheBean)getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);

			Object returnObject = cacheBean.getObject(id,className,sessionid,userid,ws_no,session_creation_date,jdbc_props);
			CommonAdapter userBean = (CommonAdapter)returnObject;
			userBean.clear();
			
			cacheBean.putObject(id,returnObject,sessionid,userid,ws_no,session_creation_date,jdbc_props);
		}		
	} 
	/* END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/* START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER */
	public static void cleanAll(HttpSession session){
		String sessionid = session.getId();
		
		String userid = (String)session.getValue("login_user");
		Timestamp session_creation_date = new Timestamp(session.getCreationTime());
		Properties jdbc_props = (Properties)session.getValue("jdbc");
		String ws_no = (String)jdbc_props.getProperty("client_ip_address");
		
		//String key = sdf.format(session_creation_date)+"::"+sessionid+userid+ws_no;
		String key = sessionid;
	
		synchronized (key.intern()) {		

			SpringCacheBean cacheBean = (SpringCacheBean)getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
			cacheBean.cleanup(sessionid,userid,ws_no,session_creation_date,jdbc_props);		
		}
	}
	/* END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
}
