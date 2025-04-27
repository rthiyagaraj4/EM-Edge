/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import eCommon.SingleTabHandler.*;
import eCommon.XSSRequestWrapper;




import java.net.URLEncoder;

import webbeans.eCommon.*;


public class PositionServlet extends HttpServlet
{
	private ServletConfig config = null;
	//PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	
	//StringBuffer err_msg = new StringBuffer();
//////
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	String position_code = "";
	String position_desc = "";
	String role_type= "";
	String staff_type="";
	String position_expl_text="";
	String eff_status = "";
	String grade_code = "";
	String added_by_id = "";
	//String added_date = "";
	//String added_at_ws_no = "";
	//String added_facility_id = "";
	//String modified_by_id= "";
	
	//String modified_at_ws_no = "";
	//String modified_facility_id= "";

	
	
	//////

	public void init(ServletConfig config)
		throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		doPost(request,response);
	}
	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		//MMS-ME-SCF-0096 vulnerability Issue 
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		session = request.getSession(false);
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		
		try{
			response.setContentType("text/html");
			//out = response.getWriter();

			String operation = request.getParameter("operation_type");
			if ( operation.equals("insert")) insertOperation(request, response);
			if ( operation.equals("modify")) modifyOperation(request, response);
		//	if ( operation.equals("delete")) deleteOperation(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void insertOperation(HttpServletRequest request,HttpServletResponse response)
     throws Exception
	{
				
		try{
			
	//		String string1 = dateFormat.format(new java.util.Date());
	//		Date addeddate = java.util.Date.valueOf(string1);
		String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
           position_code = request.getParameter("position_code")==null ? "":request.getParameter("position_code");
           position_desc = request.getParameter("position_desc")==null ? "":request.getParameter("position_desc");
		   position_expl_text = request.getParameter("position_expl_text")==null ? "":request.getParameter("position_expl_text");
		 
		  role_type = request.getParameter("role_type")==null ? "":request.getParameter("role_type");
		  staff_type=request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
		  grade_code=request.getParameter("grade_code")==null ? "":request.getParameter("grade_code");
		  eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");
     		added_by_id 	= p.getProperty( "login_user" ) ;
		//	modified_by_id	= added_by_id ;
			//added_at_ws_no	= client_ip_address;
			//added_facility_id= facility_id;
		//	modified_at_ws_no= added_at_ws_no ;
			//modified_facility_id = facility_id ;

		
		
			HashMap hashtable = new HashMap();


            hashtable.put("position_code", position_code);
			
            hashtable.put("position_desc ",position_desc);
			

			
            hashtable.put("POSITION_EXPL_TEXT", position_expl_text);

            hashtable.put("ROLE_TYPE",role_type);

            hashtable.put("staff_type",staff_type);
            hashtable.put("grade_code",grade_code);
	
            hashtable.put("eff_status",eff_status );
            hashtable.put("ADDED_BY_ID",added_by_id);
            hashtable.put("ADDED_DATE", addeddate);
            hashtable.put("ADDED_AT_WS_NO",client_ip_address);
		
			hashtable.put("ADDED_FACILITY_ID",facility_id);
			hashtable.put("MODIFIED_BY_ID",added_by_id);
            hashtable.put("MODIFIED_DATE",addeddate);
			hashtable.put("MODIFIED_AT_WS_NO",client_ip_address);
			hashtable.put("MODIFIED_FACILITY_ID",facility_id);
	      	String     duplicates[] =  {"position_code"};
				/*  InitialContext initialcontext = new InitialContext();
                  Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
                  SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
                  SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
                 
				 hashtable = singletabhandlermanagerremote.insert(p, hashtable, duplicates, "am_position"); */
				
				boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		


			

			/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("hashtable",hashtable);
				hashmap.put("duplicates",duplicates);
				String table_name="am_position";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				
				argArray[0] =hashmap;
				
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();
			*/

				
				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
			String table_name="am_position";
				argArray[0] =p;
				argArray[1] =hashtable;
				argArray[2] =duplicates;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =hashtable.getClass();
					paramArray[2] =duplicates.getClass();
					paramArray[3] =table_name.getClass();

					



		

		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);





                  
				  boolean flag = ((Boolean)results.get("status")).booleanValue();
				    String error= (String)results.get("error");
         
          
				if(flag)
            {
                String s11 = "1";
				
                response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8" ) + "&err_value=" + s11);
            } else
            {
				
               // String s9 = (String)hashtable.get("error");
              response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8" ));
            }
			hashtable.clear();
			results.clear();
			
 
		}

			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	//End of Insert

	public void modifyOperation(HttpServletRequest request,HttpServletResponse response)
		throws Exception
	{

        	try{
				//InitialContext initialcontext = new InitialContext();
	//		String string1 = dateFormat.format(new java.util.Date());
	//		Date addeddate = java.util.Date.valueOf(string1);
		String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getAttribute( "facility_id" ) ;
           position_code = request.getParameter("position_code")==null ? "":request.getParameter("position_code");
           position_desc = request.getParameter("position_desc")==null ? "":request.getParameter("position_desc");
		   position_expl_text = request.getParameter("position_expl_text")==null ? "":request.getParameter("position_expl_text");
		  role_type = request.getParameter("role_type")==null ? "":request.getParameter("role_type");
		  staff_type=request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
		  grade_code=request.getParameter("grade_code")==null ? "":request.getParameter("grade_code");
		  eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");
     		added_by_id 	= p.getProperty( "login_user" ) ;
			//modified_by_id	= added_by_id ;
			//added_at_ws_no	= client_ip_address;
			//added_facility_id= facility_id;
			//modified_at_ws_no= added_at_ws_no ;
			//modified_facility_id = facility_id ;

						
			HashMap hashtable = new HashMap();


            //hashtable.put("position_code",  position_code);
            hashtable.put("position_desc ",position_desc );
            hashtable.put("POSITION_EXPL_TEXT", position_expl_text);
            hashtable.put("ROLE_TYPE",role_type);
            hashtable.put("staff_type", staff_type);
            hashtable.put("grade_code", grade_code);
            hashtable.put("eff_status",eff_status );
            //hashtable.put("ADDED_BY_ID", added_by_id);
            //hashtable.put("ADDED_DATE", addeddate);
    //        hashtable.put("ADDED_AT_WS_NO",  client_ip_address);
	//		hashtable.put("ADDED_FACILITY_ID",  facility_id);
			hashtable.put("MODIFIED_BY_ID", added_by_id);
            hashtable.put("MODIFIED_DATE", addeddate);
			hashtable.put("MODIFIED_AT_WS_NO", client_ip_address);
			hashtable.put("MODIFIED_FACILITY_ID", facility_id);
	      	HashMap hashtable1 = new HashMap();
			hashtable1.put("position_code",position_code);
			
            /*Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
            SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
            SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
            hashtable1 = singletabhandlermanagerremote.update(p,hashtable,hashtable1,"am_position");*/

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


		/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("hashtable",hashtable);
				hashmap.put("hashtable1",hashtable1);
				String table_name="am_position";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				
				argArray[0] =hashmap;
				
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/
			
					Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
			String table_name="am_position";
				argArray[0] =p;
				argArray[1] =hashtable;
				argArray[2] =hashtable1;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =hashtable.getClass();
					paramArray[2] =hashtable1.getClass();
					paramArray[3] =table_name.getClass();

			

		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);








            boolean flag = ((Boolean)results.get("status")).booleanValue();
			String error = (String)results.get("error");
            
				  
				  
				  
				 
           
				if(flag)
            {
                String s11 = "1";
				
                response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8" ) + "&err_value=" + s11);
            } else
            {
				
                String s9 = (String)hashtable.get("error");
                response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s9,"UTF-8" ));
            }
			hashtable.clear();
			hashtable1.clear();
			results.clear();
 
		}

			catch(Exception e)
			{
				e.printStackTrace();
			} 




	}


	//public void deleteOperation(HttpServletRequest request,HttpServletResponse response)
	//{
		//Connection con=webbeans.eCommon.ConnectionManager.getConnection(request);
		//PreparedStatement pstmt=null;
	//}
}
