/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
//import oracle.sql.CLOB;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class EventTypeBean implements java.io.Serializable  
{
  public static String strBeanName = "XH_Event_Name";
	 ArrayList recordSet = new ArrayList();
     ArrayList dataRecordSet = new ArrayList();
	public  void removeTempEventCatalogs(String key)
   {
	 dataRecordSet.remove(key);
   }
    public  boolean putTempObject(Object obj)
	throws Exception
   {
		try
		{
			
			if(!dataRecordSet.contains(obj))
			{
				dataRecordSet.add(obj);
				
			}
		}
		catch(Exception exception)
		{
			throw new Exception("Exception@putObjects: " + exception);
		}
		return true;
  }
     public ArrayList returnGetRecord()
	{
		 
         return dataRecordSet;
	}

 public  boolean containsTempObject(Object obj)
        throws Exception
{
        boolean flag = false;
        if(dataRecordSet != null)
            flag = dataRecordSet.contains(obj);
        return flag;
 }
 public static EventTypeBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
     EventTypeBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
      
      session.removeAttribute(strBeanName); 
      xhBean = new EventTypeBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (EventTypeBean) session.getAttribute(strBeanName);
    }
    return(xhBean);
 }
 /*public void clearTempObject()
{
	if(dataRecordSet.size()>0)
	{
		dataRecordSet.clear();
	}
} */
}
