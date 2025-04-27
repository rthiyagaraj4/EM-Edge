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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class RelnForRespServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
		PrintWriter out = null;
		
		try
		{
			out = res.getWriter();
			String operation = req.getParameter("mode");

			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("delete"))    delete(req, res, out);
			if ( operation.equals("modify"))	modify(req,res, out);
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
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

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
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		
		String resp_id				= "";
		String pract_reln_id		= "";
		String can_asgn_val			= "";
		String can_hold_val			= "";
		String can_terminate_val	= "";
		String facilityId			= "";
		String client_ip_address	= "";

		HttpSession session;
		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");

		try
		{
			resp_id						=	req.getParameter("resp_id");
			pract_reln_id				=	req.getParameter("pract_reln_id");
			can_asgn_val				=	req.getParameter("can_asgn_val");
			can_hold_val				=	req.getParameter("can_hold_val");	
			can_terminate_val			=	req.getParameter("can_terminate_val");
			
			String addedById			=	p.getProperty( "login_user" ) ;
			String modifiedById			=	addedById ;
			String addedFacilityId		=	facilityId;
			String modifiedFacilityId	=	addedFacilityId ;
			String addedAtWorkstation	=	client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();

			tabdata.put("resp_id",resp_id);
			tabdata.put("pract_reln_id",pract_reln_id);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("can_hold_yn",can_hold_val);
			tabdata.put("can_assign_yn",can_asgn_val);
			tabdata.put("can_terminate_yn",can_terminate_val);

			String dupflds[]={"resp_id","pract_reln_id"};
		
			String tabname= "ca_pract_reln_for_resp";
			boolean local_ejbs = false;
		
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
			argArray = null;
			paramArray = null;
			tabdata.clear();
	
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
		
			if ( inserted )
				 error_value = "1" ;

			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			out.println( resp_id+" "+pract_reln_id );
		}
}

private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
		java.util.Properties p;

		Connection con=null;
		PreparedStatement  psn = null;
		
		String resp_id				= "";
		String pract_reln_id		= "";
		String can_asgn_val			= "";
		String can_hold_val			= "";
		String can_terminate_val	= "";
		String facilityId			= "";
		String client_ip_address	= "";

		HttpSession session;
		session = req.getSession(false);
		
		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		String locale		= (String) p.getProperty("LOCALE");
		
		try
		{
						
			con = ConnectionManager.getConnection(req);
			
			resp_id				=	req.getParameter("resp_id1");
			pract_reln_id		=	req.getParameter("pract_reln_id");
			can_asgn_val		=	req.getParameter("can_asgn_val");
			can_hold_val		=	req.getParameter("can_hold_val");	
			can_terminate_val	=	req.getParameter("can_terminate_val");

			String addedById		=	p.getProperty( "login_user" ) ;
			String modifiedById		=	addedById ;
			String addedFacilityId	=	facilityId;
			
			psn = con.prepareStatement("update  ca_pract_reln_for_resp set can_hold_yn =?, can_assign_yn =?,can_terminate_yn = ?,ADDED_BY_ID=?, ADDED_DATE=sysdate,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO =?,MODIFIED_FACILITY_ID=?  where resp_id = ? and pract_reln_id = ? ");
			psn.setString(1,can_hold_val);
			psn.setString(2,can_asgn_val);
			psn.setString(3,can_terminate_val);

			psn.setString(4,modifiedById);
			
			psn.setString(5,addedFacilityId);
			psn.setString(6,addedFacilityId);
			psn.setString(7,modifiedById);

			psn.setString(8,addedFacilityId);
			psn.setString(9,addedFacilityId);
			
			psn.setString(10,resp_id);
			psn.setString(11,pract_reln_id);

			try
			{
				int k = psn.executeUpdate();
				String error = "" ;
				String error_value = "0" ;

				if ( k==1)
				{
					 error_value = "1" ;
					error = getMessage(locale, "RECORD_INSERTED","CA");
					 con.commit();
				}
				else
				{
					error = getMessage(locale, "FAILED_TRANSACTION","CA");
					con.rollback();
				}
			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" )+"&err_value="+error_value);

				if(psn != null) psn.close();
		}
		catch(Exception ee)
		{
			//out.println("here " + ee);//common-icn-0181
			ee.printStackTrace();//COMMON-ICN-0181
		}
		}

	catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
		out.println( "Values sent are : <br>" ) ;
		out.println( resp_id+" "+pract_reln_id );
		
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
}

	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String resp_id =  "";
		String pract_reln_id = "";
	
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		try
		{
			resp_id =  "";
			String relationship1 = "";
			
			resp_id  = req.getParameter("resp_id1");

			if(resp_id == null)
				resp_id = "";

			relationship1  = req.getParameter("pract_reln_id");

			if(relationship1 == null)
				relationship1 = "";

			HashMap condflds=new HashMap();
			condflds.put("resp_id",resp_id);
			condflds.put("pract_reln_id",relationship1);

			String tabname= "ca_pract_reln_for_resp";
			boolean local_ejbs = false;
		
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
					argArray = null;
					paramArray = null;
					condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
				 error_value = "1" ;

			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
			out.println( "Values sent are : <br>" ) ;
			out.println( resp_id+" "+pract_reln_id );

		}
	}
}
