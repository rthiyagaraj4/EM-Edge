/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

import eCommon.SingleTabHandler.*;

public class PkgUserAccessServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
			req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = null;

		try
		{
			out = res.getWriter();

			String operation = req.getParameter("mode");
//System.out.println("Operation="+operation);
			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("modify"))    modify(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			System.out.println("Exception 1 from PkgUserAccessServlet.java : "+e.toString());
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
			e.printStackTrace();
			System.out.println("Exception in invoking doPost Method from PkgUserAccessServlet.java : "+e.toString());
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
	//System.out.println("in modify");
		java.util.Properties p;
		Connection con=null;
		ResultSet rs= null;
		PreparedStatement stmt=null;

		String user_id			=	"";
		String user_name	=	"";
		String user_grp_id	=	"";
		String user_grp_name	=	"";	
		String package_creation	=	"";	
		String package_approval	=	"";	
		String package_transfer	=	"";	
		String package_discount	=	"";	
		String package_refund	=	"";	
		String package_cancel	=	"";	
		String package_adhoc_refund	=	"";	

		String facility_id ;
		String client_ip_address ;

		//StringBuffer sql=new StringBuffer();//unused variable

		HttpSession session;
		session = req.getSession(false);

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		facility_id			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");		
		//	String locale		= (String) p.getProperty("LOCALE");//unused variable
		
		try
		{
			user_id				=	req.getParameter("user_id")==null?"":req.getParameter("user_id");
			user_name			=	req.getParameter("user_name")==null?"":req.getParameter("user_name");
			user_grp_id					=	req.getParameter("user_grp_id")==null?"":req.getParameter("user_grp_id") ;
			user_grp_name			=	req.getParameter("user_grp_name")==null?"":req.getParameter("user_grp_name");
			package_creation		=	req.getParameter("package_creation")==null?"N":req.getParameter("package_creation");
			package_approval		=	req.getParameter("package_approval")==null?"N":req.getParameter("package_approval");
			package_transfer		=	req.getParameter("package_transfer")==null?"N":req.getParameter("package_transfer");
			package_discount		=	req.getParameter("package_discount")==null?"N":req.getParameter("package_discount");
			package_refund		=	req.getParameter("package_refund")==null?"N":req.getParameter("package_refund");
			package_cancel		=	req.getParameter("package_cancel")==null?"N":req.getParameter("package_cancel");	
			package_adhoc_refund		=	req.getParameter("package_adhoc_refund")==null?"N":req.getParameter("package_adhoc_refund");	
			/*System.out.println("user_id="+user_id+"@@");
			System.out.println("user_name="+user_name+"@@");
			System.out.println("user_grp_id="+user_grp_id+"@@");
			System.out.println("user_grp_name="+user_grp_name+"@@");
			System.out.println("package_creation="+package_creation+"@@");
			System.out.println("package_approval="+package_approval+"@@");
			System.out.println("package_transfer="+package_transfer+"@@");
			System.out.println("package_discount="+package_discount+"@@");
			System.out.println("package_refund="+package_refund+"@@");
			System.out.println("package_cancel="+package_cancel+"@@");
			System.out.println("package_adhoc_refund="+package_adhoc_refund+"@@");*/
			String addedById				=	p.getProperty( "login_user" ) ;
			String modifiedById				=	addedById ;
			String addedFacilityId			=	facility_id;
			String modifiedFacilityId		=	addedFacilityId ;
			String addedAtWorkstation		=	client_ip_address;
			String modifiedAtWorkstation	=	addedAtWorkstation ;			
			//int count=0;	//unused variable

			try
			{
				con=ConnectionManager.getConnection(req);

				HashMap tabdata=new HashMap();
					
				//tabdata.put("operating_facility_id",addedFacilityId);
				//tabdata.put("bl_user_id",user_id);
				//tabdata.put("user_group_id",user_grp_id);
				tabdata.put("package_creation",package_creation );	
				tabdata.put("package_approval",package_approval );
				tabdata.put("package_transfer",package_transfer  );
				tabdata.put("package_discount",package_discount );
				tabdata.put("package_refund",package_refund );
				tabdata.put("package_cancel",package_cancel );					
				tabdata.put("package_adhoc_refund",package_adhoc_refund );					
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				
				HashMap condflds=new HashMap();
				condflds.put("operating_facility_id",addedFacilityId);
				condflds.put("bl_user_id",user_id);				

				String tabname= "bl_user";
				boolean local_ejbs = false;
		
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
				argArray = null;
				paramArray = null;
				tabdata.clear();
				condflds.clear();
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

				String error = (String) results.get("error") ;
				String error_value = "0" ;

					if ( inserted )
						 error_value = "1" ;

					results.clear();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
					//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
					
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
		}
		catch( Exception ei)
		{
			System.out.println("Exception @ Modify PractRelation"+ei.toString());
			ei.printStackTrace();

		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,req);
		}
	}
	catch ( Exception e )
	{	
		System.out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		System.out.println( "Values sent are : <br>" ) ;
		System.out.println("package_creation="+package_creation+",package_approval="+package_approval+",package_transfer="+package_transfer+",package_discount="+package_discount+",package_refund="+package_refund+",package_cancel="+package_cancel+",package_adhoc_refund="+package_adhoc_refund);
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

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		Connection con=null;
		ResultSet rs= null;
		PreparedStatement stmt=null;
		String user_id			=	"";
		String user_name	=	"";
		String user_grp_id	=	"";
		String user_grp_name	=	"";	
		String package_creation	=	"";	
		String package_approval	=	"";	
		String package_transfer	=	"";	
		String package_discount	=	"";	
		String package_refund	=	"";	
		String package_cancel	=	"";	
		String package_adhoc_refund	=	"";	

		String facility_id ;
		String client_ip_address ;

		StringBuffer sql=new StringBuffer();

		HttpSession session;
		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facility_id			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		String locale		= (String) p.getProperty("LOCALE");
		
		try
		{
			user_id				=	req.getParameter("user_id")==null?"":req.getParameter("user_id");
			user_name			=	req.getParameter("user_name")==null?"":req.getParameter("user_name");
			user_grp_id					=	req.getParameter("user_grp_id")==null?"":req.getParameter("user_grp_id") ;
			user_grp_name			=	req.getParameter("user_grp_name")==null?"":req.getParameter("user_grp_name");
			package_creation		=	req.getParameter("package_creation")==null?"N":req.getParameter("package_creation");
			package_approval		=	req.getParameter("package_approval")==null?"N":req.getParameter("package_approval");
			package_transfer		=	req.getParameter("package_transfer")==null?"N":req.getParameter("package_transfer");
			package_discount		=	req.getParameter("package_discount")==null?"N":req.getParameter("package_discount");
			package_refund		=	req.getParameter("package_refund")==null?"N":req.getParameter("package_refund");
			package_cancel		=	req.getParameter("package_cancel")==null?"N":req.getParameter("package_cancel");	
			package_adhoc_refund		=	req.getParameter("package_adhoc_refund")==null?"N":req.getParameter("package_adhoc_refund");	
		/*	System.out.println("in insert");
			System.out.println("user_id="+user_id+"@@");
			System.out.println("user_name="+user_name+"@@");
			System.out.println("user_grp_id="+user_grp_id+"@@");
			System.out.println("user_grp_name="+user_grp_name+"@@");
			System.out.println("package_creation="+package_creation+"@@");
			System.out.println("package_approval="+package_approval+"@@");
			System.out.println("package_transfer="+package_transfer+"@@");
			System.out.println("package_discount="+package_discount+"@@");
			System.out.println("package_refund="+package_refund+"@@");
			System.out.println("package_cancel="+package_cancel+"@@");
			System.out.println("package_adhoc_refund="+package_adhoc_refund+"@@");*/
			int count=0;

			try
			{
				
				con=ConnectionManager.getConnection(req);

				if(sql.length() > 0) sql.delete(0,sql.length());

				sql.append("select count(*) from bl_user  where operating_facility_id=? and  bl_user_id = ? ");
					
				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,facility_id);
				stmt.setString(2,user_id);
				rs=stmt.executeQuery();
				rs.next();
				count=rs.getInt(1);

				if ( count > 0 )  
				{
					String error = getMessage(locale, "CODE_ALREADY_EXISTS","Common");
				//	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value=0");
					return ;
				}
				else
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					String addedById = p.getProperty( "login_user" ) ;
					String modifiedById = addedById ;
					String addedFacilityId=facility_id;
					String modifiedFacilityId = addedFacilityId ;
					String addedAtWorkstation=client_ip_address;
					String modifiedAtWorkstation = addedAtWorkstation ;

					HashMap tabdata=new HashMap();

					tabdata.put("operating_facility_id",addedFacilityId);
					tabdata.put("bl_user_id",user_id);
					tabdata.put("user_group_id",user_grp_id);
					tabdata.put("enter_service_request_yn","");
					tabdata.put("confirm_service_request_yn","");
					tabdata.put("cancel_confirmed_serv_yn","");
					tabdata.put("cancel_self_entered_srvc_only","");
					tabdata.put("cancel_indirect_serv_yn","");
					tabdata.put("change_confirmed_serv_yn","");
					tabdata.put("adjust_self_entered_srvc_only","");
					tabdata.put("enter_negative_serv_request_yn","");
					tabdata.put("bl_user_password","");
					tabdata.put("added_by_id",addedById);
					tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("added_facility_id", facility_id);
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("added_at_ws_no",addedAtWorkstation);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
					tabdata.put("status","" );
					tabdata.put("cancel_invoice_yn","" );
					tabdata.put("cancel_invoice_pmnt_yn","" );
					tabdata.put("unfinalize_inv_pmnt_yn","N" );
					tabdata.put("package_creation",package_creation );	
					tabdata.put("package_approval",package_approval );
					tabdata.put("package_transfer",package_transfer  );
					tabdata.put("package_discount",package_discount );
					tabdata.put("package_refund",package_refund );
					tabdata.put("package_cancel",package_cancel );
					tabdata.put("package_adhoc_refund",package_adhoc_refund );
					

					String dupflds[]={"operating_facility_id","bl_user_id"};
					String tabname= "bl_user";
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
				//	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
				}
				
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch( Exception e)
			{
				e.printStackTrace(System.err);
				System.out.println("Exception from PkgUserAccessServlet.java :  "+e.toString());
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,req);
			}
		}
		catch ( Exception e )
		{	
			System.out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			System.out.println( "Values sent are : <br>" ) ;
			System.out.println("user_id="+user_id+", user_name="+user_name+", user_grp_id ="+user_grp_id+",user_grp_name= "+user_grp_name+",package_creation="+package_creation+",package_approval="+package_approval+",package_transfer="+package_transfer+",package_discount="+package_discount+",package_refund="+package_refund+",package_cancel="+package_cancel+",package_adhoc_refund="+package_adhoc_refund);
			e.printStackTrace();
		}
	}
}
