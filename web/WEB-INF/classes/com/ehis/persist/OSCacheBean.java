/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.persist;

import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;

import com.opensymphony.oscache.base.*;
import com.opensymphony.oscache.general.*;

public class OSCacheBean implements Serializable {
    
	static transient GeneralCacheAdministrator generalCacheAdministrator = null;
	static transient Properties p = null;
	static transient ResourceBundle b = null;

	static {
		p = new Properties();
		b = ResourceBundle.getBundle("oscache");
		for (Enumeration e = b.getKeys();e.hasMoreElements() ; ){
			String key = (String) e.nextElement();
			String value = (String) b.getObject(key);
			p.setProperty(key,value);
		}
		p.list(System.out);
		if (generalCacheAdministrator == null)generalCacheAdministrator = new GeneralCacheAdministrator(p);
	}

	HashMap map;
	static transient SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHH");
    
	private OSCacheBean() {
		if (map == null){
			map = new HashMap();
		}
	}
    
    public static OSCacheBean getCacheBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        OSCacheBean cacheBean = null;
		String key = sessionid+userid+ws_no;
		String group [] = {sdf.format(session_creation_date)};		
		try{
           cacheBean =  (OSCacheBean) generalCacheAdministrator.getFromCache(key);
		   if (cacheBean == null) {
				try {
					cacheBean  = new OSCacheBean();
					generalCacheAdministrator.putInCache(key,cacheBean,group);
				} catch (Exception ex) {
					ex.printStackTrace();
					generalCacheAdministrator.cancelUpdate(key);									
				}
		   }
        }catch (NeedsRefreshException nre) {
			try {
				cacheBean  = new OSCacheBean();
				generalCacheAdministrator.putInCache(key,cacheBean,group);
			} catch (Exception ex) {
				ex.printStackTrace();
				cacheBean = (OSCacheBean) nre.getCacheContent();				
				generalCacheAdministrator.cancelUpdate(key);								
			}
		}
        return cacheBean;
    }
    
    public void persist(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		String key = sessionid+userid+ws_no;
		String group [] = {sdf.format(session_creation_date)};
        try{			
				generalCacheAdministrator.putInCache(key,this,group);
			}catch (Exception ex) {
				ex.printStackTrace();
				generalCacheAdministrator.cancelUpdate(key);								
			}         
    }
    
    public void cleanup(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		String key = sessionid+userid+ws_no;
		java.sql.Timestamp checkTimeStamp = (java.sql.Timestamp) session_creation_date.clone();
		checkTimeStamp.setHours(session_creation_date.getHours() - 23);
		try{
			
			generalCacheAdministrator.flushEntry(key);

			try{
				generalCacheAdministrator.flushGroup(sdf.format(checkTimeStamp));	
			}catch(NullPointerException npe){
				
			}
			
		}catch(Exception exc){
			exc.printStackTrace();	
		}
    }
    
    public Object getObject(String id,String className,String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        Object tempObj = null;        
        try{
			
			synchronized (this){
				tempObj = map.get(id);
			}

            if (null == tempObj){
				 Class objClass = Class.forName(className);
                 tempObj = objClass.newInstance();
                 map.put(id,tempObj);
                 persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
            }
        }catch(Exception exc){
               exc.printStackTrace();
        }
        return tempObj;
    }
    
    public  void putObject(String id,Object obj,String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){        
        try{
            map.put(id,obj);
            persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
        }catch(Exception exc){
               exc.printStackTrace();
        }       
    }
    
}
