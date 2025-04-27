/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class PrintHeaderImageListServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		PrintWriter out = null;

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8 ");
			out = res.getWriter();
			String mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");

			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
			if (mode.trim().equalsIgnoreCase("update"))   modify(req, res, out);
			if (mode.trim().equalsIgnoreCase("delete"))   delete(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}/**********************************************************************************************/

	private void extractData(HttpServletRequest req)
	{
			
			String note_type="";
			String note_type_desc="";
			String file_type="";
			String eff_status	="";
			String beforeUpdateEff_status="";

			String mode					 = (req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			 HttpSession session	= null;
			 session = req.getSession(false);
				
			beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req); 
			
			eff_status				= checkNull("eff_status", req); 
			eff_status  			=(eff_status.equals(""))?"D":eff_status ;
							
			if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
			{
				note_type			= checkNull("note_type_update",req);
				

			}
			else
			{
				note_type			= checkNull("note_type",req);
			                                    
			}
				
				   
				note_type_desc			= checkNull("note_type_desc",req);  
                file_type			    = checkNull("file_type",req);
				
							
		}

	
	public String checkNull(String str,HttpServletRequest req) //flag is true for null feilds
	{
		String tempHolder =  req.getParameter(str)	 ;
		return (tempHolder==null)?"":tempHolder ;
	}

 /**********************************************Pouplates the hashtable with the values*******************/

	public HashMap populateHashMap(HttpServletRequest req)
	{
			
			java.util.Properties p;

			
			String note_type="";
			String note_type_desc="";
			String file_type="";
			String eff_status	="";
			
			

			HashMap tabdata			= null;
			String mode				= (req.getParameter("mode")==null)?"":req.getParameter("mode");
			String beforeUpdateEff_status= "";
			

			String facilityId ;
			String client_ip_address    ;
			String addedById			= "";
			String modifiedById			= "";
			String addedAtWorkstation	= "";
			String modifiedAtWorkstation= "";

			 HttpSession session	= null;
			 session = req.getSession(false);
			 p = (java.util.Properties) session.getValue( "jdbc" ) ;
			 //String locale = (String) p.getProperty("LOCALE");
			 facilityId = (String) session.getValue( "facility_id" ) ;
			 client_ip_address = p.getProperty("client_ip_address");
			 modifiedById =(p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			 modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address; 
			 addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			 addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
			 tabdata=new HashMap();
			
			 beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req); 
				
				eff_status				= checkNull("eff_status", req); 
				eff_status  			=(eff_status.equals(""))?"D":eff_status ;
								
				if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
				{
					note_type			= checkNull("note_type_update",req);
					
				}
				else
				{
					note_type			= checkNull("note_type",req);
					                                    
				}
				
				   
				note_type_desc			= checkNull("note_type_desc",req); 
			    file_type			    = checkNull("file_type",req);
				
			
				
				                          
			

				if(!(beforeUpdateEff_status.equalsIgnoreCase("checked")) &&  mode.trim().equalsIgnoreCase("update"))
				{	
					tabdata.put("LOGO_ID", note_type);
					tabdata.put("EFF_STATUS",eff_status);
					tabdata.put("MODIFIED_BY_ID",modifiedById);
					tabdata.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("MODIFIED_FACILITY_ID",facilityId);
					tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
					//tabdata.put("LOCALE",locale ); //Commented by shaiju Locale should not pass to SingleTabHandler ejb
					return tabdata;
				}
                               
			tabdata.put("LOGO_ID", note_type);
			tabdata.put("LOGO_DESC",note_type_desc);
			tabdata.put("LOGO_EXEC_NAME",file_type);
			
			tabdata.put("EFF_STATUS",eff_status);
			
			
			if (mode.equalsIgnoreCase("insert"))
			{
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
								
			}
			else
		{
		}
		
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",facilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			
				
			return tabdata;
	
	}

/***************************************insert**********************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		HashMap tabdata			= null;

		String facilityId ;
		String client_ip_address ;
		String addedById			= "";
		String addedAtWorkstation	= "";

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		tabdata=new HashMap();
		
		try
		{
			
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
								                                              
			extractData(req) ;

			tabdata = populateHashMap(req); //FILL THE HASHMAP
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 

			String dupflds[]={"LOGO_ID"};

			boolean local_ejbs = false;
			String tabname="CA_NOTE_LOGO_LIST ";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( inserted )
				error_value = "1" ;

			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}


	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
      
		HashMap tabdata			= null;
		

		String note_type = checkNull("note_type_update",req);
		String facilityId ;
		String client_ip_address ;
		String modifiedById			= "";
		String modifiedAtWorkstation= "";

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
		tabdata=new HashMap();
		try
		{
			extractData(req) ;
			tabdata = populateHashMap(req); //FILL THE HASHMap
			HashMap condflds=new HashMap();
			condflds.put("LOGO_ID",note_type);
			
			boolean local_ejbs = false;
			String tabname="CA_NOTE_LOGO_LIST ";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( modified )
				 error_value = "1" ;

			results.clear();
   			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}


/***************************************Delete**********************************************/


	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
        
		String note_type= checkNull("note_type_update",req);

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		try
		{
			extractData(req) ;
			HashMap condflds=new HashMap();
			condflds.put("LOGO_ID",note_type);

			boolean local_ejbs = false;
			String tabname="CA_NOTE_LOGO_LIST ";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = condflds;
			argArray[2] = tabname;

			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = condflds.getClass();
			paramArray[2] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( modified )
				error_value = "1" ;

			results.clear();
      	
			if(!modified)
      			error = getMessage(locale,"NOTE_IN_USE","CA");
		  
      		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8")+"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//Common-icn-0181
			e.printStackTrace();
		}
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }
}

