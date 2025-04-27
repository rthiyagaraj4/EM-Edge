/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eCommon.SingleTabHandler.*;

public class HMISMastersServlet extends HttpServlet
{

	PrintWriter out;
	Properties p;

	String client_ip_address;
	String facilityId;
	String tableName = "";
	HttpSession session;
	SimpleDateFormat dateFormat;
	Connection con;
	String locale="";

	public void init(ServletConfig servletconfig)throws ServletException
    {
        super.init(servletconfig);
    }


	public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException
    {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		session = httpservletrequest.getSession(false);
		facilityId = (String)session.getValue("facility_id");
		p = (Properties)session.getValue("jdbc");
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		String table_id = (httpservletrequest.getParameter("tableId")==null)?"":httpservletrequest.getParameter("tableId");        
		
		try
        {
       		con = ConnectionManager.getConnection(httpservletrequest);
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("func");
			if(table_id.equals("UTL_FILE_DIR"))
		    {
				String mysql="SELECT MEDICOM_CODE1 FROM XT_HMIS_LINK WHERE TABLE_ID = 'UTL_FILE_DIR'";
				pstmt=con.prepareStatement(mysql);
				rs=pstmt.executeQuery();
				if (rs.next())
					updateHMISMasters(httpservletrequest, httpservletresponse);
				else
					insertHMISMasters(httpservletrequest, httpservletresponse);

				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}
			else 
			if (s.equals("insert"))
                insertHMISMasters(httpservletrequest, httpservletresponse);
            if (s.equals("delete"))
                deleteHMISMasters(httpservletrequest, httpservletresponse);
          
		}catch(Exception exception)
        {
			exception.printStackTrace();
            //out.println(exception.toString());
        }
		finally
		{
			if(con != null)      
				ConnectionManager.returnConnection(con,httpservletrequest);
		}
	}
 
 
 
	private void  deleteHMISMasters(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
		PreparedStatement preparedstatement = null;  
		try
		{
			Hashtable hashtable;
			String Facility= (httpservletrequest.getParameter("facility")==null)?"":httpservletrequest.getParameter("facility");
			String spec = (httpservletrequest.getParameter("spec")==null)?"":httpservletrequest.getParameter("spec"); 
			String Code =(httpservletrequest.getParameter("Code")==null)?"":httpservletrequest.getParameter("Code");

			con = ConnectionManager.getConnection(httpservletrequest);
			String table_id = (httpservletrequest.getParameter("tableId")==null)?"":httpservletrequest.getParameter("tableId");
			String s = "";
			String s2 = "";
			   
			if(table_id.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
			{
				s = " delete from XT_HMIS_LINK  where  TABLE_ID= '"+table_id +"' and FACILITY_ID='"+Facility+"' and MEDICOM_CODE1='"+Code+"'and  MEDICOM_CODE2='"+spec+"'" ;
				preparedstatement = con.prepareStatement(s);
				int i = 0;
				i = preparedstatement.executeUpdate();
				preparedstatement.close();
				
				if(i >= 1)
				{
					con.commit();
					hashtable = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					s2 = (String)hashtable.get("message");
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");
				}
				else
				{
					con.rollback();
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");
				}
			}
			else if(table_id.equals("IP_NURSING_UNIT")||table_id.equals("OP_CLINIC"))
			{
				s = " delete from XT_HMIS_LINK  where  TABLE_ID='"+table_id +"' and FACILITY_ID='"+Facility+"' and MEDICOM_CODE1='"+Code+"'" ;
				preparedstatement = con.prepareStatement(s);
				int i = 0;
				i = preparedstatement.executeUpdate();
				preparedstatement.close();
				if(i >= 1)
				{
					con.commit();
					hashtable = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					s2 = (String)hashtable.get("message");
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");
				}else
				{
					con.rollback();
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");
				}
			}else
			{ 
				s = " delete from XT_HMIS_LINK  where  TABLE_ID= '"+table_id +"' and  MEDICOM_CODE1='"+Code+"'" ;
				preparedstatement = con.prepareStatement(s);
				int i = 0;
				i = preparedstatement.executeUpdate();
				preparedstatement.close();
				if(i >= 1)
				{
					con.commit();
					hashtable = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					s2 = (String)hashtable.get("message");
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");
				}
				else
				{
					con.rollback();
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");    
				}
			}
			if (preparedstatement != null)	preparedstatement.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)      
				ConnectionManager.returnConnection(con,httpservletrequest);
		}
	}

	private void insertHMISMasters(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
		try
		{
			boolean flag=false; 
			HashMap hashtable1;
			String spec = (httpservletrequest.getParameter("spec")==null)?"":httpservletrequest.getParameter("spec"); 
			String error="";
			String disp = (httpservletrequest.getParameter("disp")==null)?"":httpservletrequest.getParameter("disp"); 
			String emer = (httpservletrequest.getParameter("emer_maternity_yn")==null)?"":httpservletrequest.getParameter("emer_maternity_yn");
			String indicator = (httpservletrequest.getParameter("indicator")==null)?"":httpservletrequest.getParameter("indicator");
			String table_id = (httpservletrequest.getParameter("tableId")==null)?"":httpservletrequest.getParameter("tableId");
			String hospital_code = (httpservletrequest.getParameter("hospital_code")==null)?"":httpservletrequest.getParameter("hospital_code");
			String Facility= (httpservletrequest.getParameter("facility")==null)?"":httpservletrequest.getParameter("facility");
			String Code =(httpservletrequest.getParameter("Code")==null)?"":httpservletrequest.getParameter("Code");
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String hmis_code=(httpservletrequest.getParameter("hmis_code")==null)?"":httpservletrequest.getParameter("hmis_code");

			String login_user = p.getProperty("login_user");
			String string1 = dateFormat.format(new java.util.Date());
			Date addeddate = Date.valueOf(string1);

			HashMap hashtable = new HashMap();
            hashtable.put("TABLE_ID",  table_id);
            hashtable.put("MEDICOM_CODE1",Code);
            hashtable.put("HMIS_CODE1", hmis_code);
            hashtable.put("FACILITY_ID",Facility);
            hashtable.put("HOSPITAL_CODE", hospital_code);
            hashtable.put("MEDICOM_CODE2",spec );
            hashtable.put("HMIS_CODE2", disp);
            hashtable.put("EMER_MATERNITY_YN", emer);
            hashtable.put("INDICATOR", indicator);
            hashtable.put("ADDED_BY_ID", login_user);
            hashtable.put("ADDED_DATE", addeddate);
            hashtable.put("ADDED_AT_WS_NO",  client_ip_address);
			hashtable.put("ADDED_FACILITY_ID",  facilityId);
			hashtable.put("MODIFIED_BY_ID", login_user);
            hashtable.put("MODIFIED_DATE", addeddate);
			hashtable.put("MODIFIED_AT_WS_NO", client_ip_address);
			hashtable.put("MODIFIED_FACILITY_ID", facilityId);

			if(table_id.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
			{
				String     duplicates[] =  {"TABLE_ID","FACILITY_ID","MEDICOM_CODE1","MEDICOM_CODE2"};
/*				
				InitialContext initialcontext = new InitialContext();
				Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
				SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
				SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
				hashtable1 = singletabhandlermanagerremote.insert(p, hashtable, duplicates, "XT_HMIS_LINK");
*/
				tableName = "XT_HMIS_LINK";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = hashtable;
				argArray[2] = duplicates;
				argArray[3] = tableName;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = hashtable.getClass();
				paramArray[2] = duplicates.getClass();
				paramArray[3] = tableName.getClass();

				hashtable1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				flag = ((Boolean)hashtable1.get("status")).booleanValue();
				error= (String)hashtable1.get("error");

			}else if(table_id.equals("IP_NURSING_UNIT"))
			{
				String   	duplicates[]=  {"TABLE_ID","FACILITY_ID","MEDICOM_CODE1"};
/*
				InitialContext initialcontext = new InitialContext();
				Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
				SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
				SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
				hashtable1 = singletabhandlermanagerremote.insert(p, hashtable, duplicates, "XT_HMIS_LINK");
*/

				tableName = "XT_HMIS_LINK";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = hashtable;
				argArray[2] = duplicates;
				argArray[3] = tableName;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = hashtable.getClass();
				paramArray[2] = duplicates.getClass();
				paramArray[3] = tableName.getClass();

				hashtable1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				flag = ((Boolean)hashtable1.get("status")).booleanValue();
				error = (String)hashtable1.get("error");
			}
			else if(table_id.equals("OP_CLINIC"))
			{
				String   	duplicates[]=  {"TABLE_ID","FACILITY_ID","MEDICOM_CODE1"};
/*
				InitialContext initialcontext = new InitialContext();
				Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
				SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
				SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
				hashtable1 = singletabhandlermanagerremote.insert(p, hashtable, duplicates, "XT_HMIS_LINK");
*/
				tableName = "XT_HMIS_LINK";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = hashtable;
				argArray[2] = duplicates;
				argArray[3] = tableName;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = hashtable.getClass();
				paramArray[2] = duplicates.getClass();
				paramArray[3] = tableName.getClass();

				hashtable1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				flag = ((Boolean)hashtable1.get("status")).booleanValue();
				error = (String)hashtable1.get("error");
			}
			else
			{
				String   duplicates[]={"TABLE_ID","MEDICOM_CODE1"};
/*
				InitialContext initialcontext = new InitialContext();
				Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
				SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
				SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
				hashtable1 = singletabhandlermanagerremote.insert(p, hashtable, duplicates, "XT_HMIS_LINK");
*/
				String tableName = "XT_HMIS_LINK";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = hashtable;
				argArray[2] = duplicates;
				argArray[3] = tableName;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = hashtable.getClass();
				paramArray[2] = duplicates.getClass();
				paramArray[3] = tableName.getClass();

				hashtable1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				flag = ((Boolean)hashtable1.get("status")).booleanValue();
				error = (String)hashtable1.get("error");
			}                  
         
			if(flag)
            {
                String s11 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + s11);
            } else
            {
                String s9 = (String)hashtable1.get("error");
                httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s9,"UTF-8"));
            }
			if ( hashtable != null) hashtable.clear();
			if ( hashtable1 != null) hashtable1.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)      
				ConnectionManager.returnConnection(con,httpservletrequest);
		}
	}

		

	private void updateHMISMasters(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
		try
		{
			boolean flag=false; 
            HashMap hashtable1;
	        String spec = (httpservletrequest.getParameter("spec")==null)?"":httpservletrequest.getParameter("spec"); 
            String error="";
	        String disp = (httpservletrequest.getParameter("disp")==null)?"":httpservletrequest.getParameter("disp"); 
	        String emer = (httpservletrequest.getParameter("emer_maternity_yn")==null)?"":httpservletrequest.getParameter("emer_maternity_yn");
			String indicator = (httpservletrequest.getParameter("indicator")==null)?"":httpservletrequest.getParameter("indicator");
            String table_id = (httpservletrequest.getParameter("tableId")==null)?"":httpservletrequest.getParameter("tableId");
			String hospital_code = (httpservletrequest.getParameter("hospital_code")==null)?"":httpservletrequest.getParameter("hospital_code");
			String Facility= (httpservletrequest.getParameter("facility")==null)?"":httpservletrequest.getParameter("facility");
			String Code =(httpservletrequest.getParameter("Code")==null)?"":httpservletrequest.getParameter("Code");
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String hmis_code=(httpservletrequest.getParameter("hmis_code")==null)?"":httpservletrequest.getParameter("hmis_code");

			String login_user = p.getProperty("login_user");
			String string1 = dateFormat.format(new java.util.Date());
			Date addeddate = Date.valueOf(string1);

			HashMap hashtable = new HashMap();
            hashtable.put("TABLE_ID",  table_id);
            hashtable.put("MEDICOM_CODE1",Code);
            hashtable.put("HMIS_CODE1", hmis_code);
            hashtable.put("FACILITY_ID",Facility);
            hashtable.put("HOSPITAL_CODE", hospital_code);
            hashtable.put("MEDICOM_CODE2",spec );
            hashtable.put("HMIS_CODE2", disp);
            hashtable.put("EMER_MATERNITY_YN", emer);
            hashtable.put("INDICATOR", indicator);
            hashtable.put("ADDED_BY_ID", login_user);
            hashtable.put("ADDED_DATE", addeddate);
            hashtable.put("ADDED_AT_WS_NO",  client_ip_address);
			hashtable.put("ADDED_FACILITY_ID",  facilityId);
			hashtable.put("MODIFIED_BY_ID", login_user);
            hashtable.put("MODIFIED_DATE", addeddate);
			hashtable.put("MODIFIED_AT_WS_NO", client_ip_address);
			hashtable.put("MODIFIED_FACILITY_ID", facilityId);
	      				  
			HashMap cond = new HashMap();
			cond.put("TABLE_ID",table_id);
/*
			InitialContext initialcontext = new InitialContext();
			Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
			SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
			hashtable1 = singletabhandlermanagerremote.update(p, hashtable, cond, "XT_HMIS_LINK");
*/
			tableName = "XT_HMIS_LINK";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = cond;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashtable.getClass();
			paramArray[2] = cond.getClass();
			paramArray[3] = tableName.getClass();

			hashtable1 = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			flag = ((Boolean)hashtable1.get("status")).booleanValue();
			error = (String)hashtable1.get("error");
            
			if(flag)
            {
                String s11 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + s11);
            } else
            {
                String s9 = (String)hashtable1.get("error");
                httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s9,"UTF-8"));
            }
			if ( cond != null) cond.clear();
			if ( hashtable != null) hashtable.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)      
				ConnectionManager.returnConnection(con,httpservletrequest);
		}
	}
}


