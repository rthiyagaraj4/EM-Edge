package eMR;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import eCommon.SingleTabHandler.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import java.net.URLEncoder.*;

public class TermCodeOtherDescServlet extends HttpServlet
{ 
	//Connection con = null;//Commented for check style
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	private ServletConfig config=null;
	String added_by_id = "";
	String added_at_ws_no = "";
	String facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String mode = "";
	//String locale="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" );

	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		this.config = config;
	}	//end of init()

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
      	out = response.getWriter();		
		this.p = (java.util.Properties)session.getValue("jdbc");
		
		client_ip_address = this.p.getProperty("client_ip_address");
		//locale = p.getProperty("LOCALE");	
		modified_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		
		modified_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		try
		{
			 mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
			 if(mode.equals("")) insert(request,response);
			 if(mode.equals("update")) update(request,response);
		}
		catch(Exception e)
		{
			//out.println("Exception in try of doPost()"+e);
			e.printStackTrace();
		}
	}	//end of doPost()

	public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			out = response.getWriter();		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}
		catch(Exception e)
		{
			//out.println("Exception in doGet()"+e);
			e.printStackTrace();
		}
	}//end of doGet()

//***********Start of Insert************************
	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		
			try
			{	
			
			added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address;
			String term_set_id = "ICD10";
			String term_code = request.getParameter("term_code")==null ? "":request.getParameter("term_code");
			String description1= request.getParameter("description1")==null ? "":request.getParameter("description1");
			String description2= request.getParameter("description2")==null ? "":request.getParameter("description2");
			String description3= request.getParameter("description3")==null ? "":request.getParameter("description3");
			String description4= request.getParameter("description4")==null ? "":request.getParameter("description4");
			String description5= request.getParameter("description5")==null ? "":request.getParameter("description5");
			String description6= request.getParameter("description6")==null ? "":request.getParameter("description6");
			String description7= request.getParameter("description7")==null ? "":request.getParameter("description7");
			String description8= request.getParameter("description8")==null ? "":request.getParameter("description8");
			String description9= request.getParameter("description9")==null ? "":request.getParameter("description9");
			String description10= request.getParameter("description10")==null ? "":request.getParameter("description10");
			
			
			String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		added_by_id 	= p.getProperty( "login_user" ) ;

		

		HashMap tabData=new HashMap();

		tabData.put("TERM_SET_ID",term_set_id);
		tabData.put("TERM_CODE",term_code);
		tabData.put("description1",description1);
		tabData.put("description2",description2);
		tabData.put("description3",description3);
		tabData.put("description4",description4);
		tabData.put("description5",description5);
		tabData.put("description6",description6);
		tabData.put("description7",description7);
		tabData.put("description8",description8);
		tabData.put("description9",description9);
		tabData.put("description10",description10);

		tabData.put("ADDED_BY_ID", added_by_id);
		tabData.put("ADDED_DATE", addeddate);
		tabData.put("ADDED_AT_WS_NO",  client_ip_address);
		tabData.put("ADDED_FACILITY_ID",  facility_id);
		tabData.put("MODIFIED_BY_ID", added_by_id);
		tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		String tabname="MR_TERM_CODE_OTH_DESC";
		String dupfields[] = {"TERM_SET_ID","TERM_CODE"};
		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			boolean inserted = false; 
			argArray[0] = p;
			argArray[1] = tabData;
			argArray[2] = dupfields;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabData.getClass();
			paramArray[2] = dupfields.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			inserted = (((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value= "1";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			if ( results != null) results.clear();
		}catch(Exception e)
		{
			//out.println("From Servlet--Calling EJB:"+e);
			e.printStackTrace();
			String error = "Error ";
			String error_value = "0" ;
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		if ( tabData != null) tabData.clear();
			
	}catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter
			

private void update(HttpServletRequest request,HttpServletResponse response)
	{
		
			try
			{	
			
			added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address;
			String term_set_id = "ICD10";
			String term_code = request.getParameter("term_code")==null ? "":request.getParameter("term_code");
			String description1= request.getParameter("description1")==null ? "":request.getParameter("description1");
			String description2= request.getParameter("description2")==null ? "":request.getParameter("description2");
			String description3= request.getParameter("description3")==null ? "":request.getParameter("description3");
			String description4= request.getParameter("description4")==null ? "":request.getParameter("description4");
			String description5= request.getParameter("description5")==null ? "":request.getParameter("description5");
			String description6= request.getParameter("description6")==null ? "":request.getParameter("description6");
			String description7= request.getParameter("description7")==null ? "":request.getParameter("description7");
			String description8= request.getParameter("description8")==null ? "":request.getParameter("description8");
			String description9= request.getParameter("description9")==null ? "":request.getParameter("description9");
			String description10= request.getParameter("description10")==null ? "":request.getParameter("description10");
			
			
			String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		added_by_id 	= p.getProperty( "login_user" ) ;

		

		HashMap tabData=new HashMap();

		tabData.put("TERM_SET_ID",term_set_id);
		tabData.put("TERM_CODE",term_code);
		tabData.put("description1",description1);
		tabData.put("description2",description2);
		tabData.put("description3",description3);
		tabData.put("description4",description4);
		tabData.put("description5",description5);
		tabData.put("description6",description6);
		tabData.put("description7",description7);
		tabData.put("description8",description8);
		tabData.put("description9",description9);
		tabData.put("description10",description10);
		tabData.put("MODIFIED_BY_ID", added_by_id);
		tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		HashMap condflds=new HashMap();
			condflds.put("TERM_SET_ID",term_set_id);
			condflds.put("TERM_CODE",term_code);

		String tabname="MR_TERM_CODE_OTH_DESC";
		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			boolean inserted = false; 
			argArray[0] = p;
			argArray[1] = tabData;
			argArray[2] = condflds;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabData.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			inserted = (((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value= "1";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			if ( results != null) results.clear();
		}catch(Exception e)
		{
			//out.println("From Servlet--Calling EJB:"+e);
			e.printStackTrace();
			String error = "Error ";
			String error_value = "0" ;
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		if ( tabData != null) tabData.clear();
			
	}catch ( Exception e )
      {
	  
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the update
			

		
		
	
}