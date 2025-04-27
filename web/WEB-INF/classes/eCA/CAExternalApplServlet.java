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
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class CAExternalApplServlet extends javax.servlet.http.HttpServlet
{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	

		PrintWriter out = null;
		out = res.getWriter();
		modify(req, res, out);

	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		
		try
		{
			out = res.getWriter();
			doPost(req,res);
		}
		catch(Exception ei)	
		{	
			//out.println(ei.toString());//common-icn-0181
			ei.printStackTrace();
		}
	}
	private void modify(HttpServletRequest request, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		String appl_id				=	"";
		String appl_name			=	"";
		String base_url				=	"";
		String default_user_id		=	"";
		String default_user_pass	=	"";
		String eff_status			=	"";
		String facilityId			=	"";
		String client_ip_address	=	"";
		String addedById			=	"";
		String addedDate			=	"";
		String addedAtWorkstation	=	"";
		String addedFacilityId		=	"";
		String modifiedById			=	"";
		String modifiedDate			=	"";
		String modifiedAtWorkstation=	"";
		String locale				=	"";
		String externalParamResult  =   "";

		Connection con				=	null;

		HttpSession session;
		
		session			= request.getSession(false);
		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

		p						= (Properties)session.getValue("jdbc") ;
		locale					= (String) p.getProperty("LOCALE");
		facilityId				= (String)session.getValue( "facility_id" ) ;
		client_ip_address		= p.getProperty("client_ip_address");
		modifiedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedDate			= dateFormat.format( new java.util.Date());  
				   
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
		addedById				= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate				= dateFormat.format( new java.util.Date() ) ;
		addedFacilityId			= (facilityId == null)?"":facilityId;  
		addedAtWorkstation		= (client_ip_address == null)?"":client_ip_address;  

		try
		{
			con	=	ConnectionManager.getConnection(request);

			appl_id				=	(request.getParameter("appl_id")==null?"":request.getParameter("appl_id"));
			appl_name			=	(request.getParameter("appl_name1")==null?"":request.getParameter("appl_name"));
			base_url			=	(request.getParameter("base_url1")==null?"":request.getParameter("base_url"));
			default_user_id		=	(request.getParameter("default_user_id")==null?"":request.getParameter("default_user_id"));
			default_user_pass	=	(request.getParameter("default_user_pass")==null?"":request.getParameter("default_user_pass"));
			eff_status			=	(request.getParameter("eff_status")==null?"D":request.getParameter("eff_status"));
			externalParamResult	=	(request.getParameter("externalParamResult1")==null?"":request.getParameter("externalParamResult1"));
			String updateSQL = "update  CA_EXT_IMAGE_APPL  set EXT_IMAGE_APPL_NAME=?, BASE_URL=?,DEFAULT_USER_ID=?,DEFAULT_USER_PASSWORD=app_password.ENCRYPT(?),EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where EXT_IMAGE_APPL_ID=? " ;

			PreparedStatement pstmt1 = con.prepareStatement(updateSQL) ;
		
			pstmt1.setString(1,appl_name) ;
			pstmt1.setString(2,base_url) ;
			pstmt1.setString(3,default_user_id) ;
			pstmt1.setString(4,default_user_pass) ;
			pstmt1.setString(5,eff_status) ;
			pstmt1.setString(6,modifiedById) ;
			pstmt1.setString(7,modifiedAtWorkstation) ;
			pstmt1.setString(8,appl_id) ;

			int nUpdStatus = pstmt1.executeUpdate();

			String error = "" ;
			String error_value = "0" ;
			
			if(nUpdStatus > 0) 
			{
				 con.commit();
				 error_value = "1" ;
				 error = getMessage(locale, "RECORD_INSERTED","CA");
			}
			else
			{	 
				con.rollback();
				error_value = "0" ;
				error = getMessage(locale, "FAILED_TRANSACTION","CA");
			}	
			
			if(pstmt1!=null) pstmt1.close();
   			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
			PreparedStatement pst = null;
            String sql = "update CA_EXT_IMAGE_APPL set Param_def_str = ? where EXT_IMAGE_APPL_ID = ?";
			 pst = con.prepareStatement(sql);
             pst.setString(1,externalParamResult) ;
             pst.setString(2,appl_id) ;
			 int count = pst.executeUpdate();
			 if (count > 0)
			 {
                 con.commit();
				 error_value = "1" ;
				 error = getMessage(locale, "RECORD_INSERTED","CA");
			 }
			else
			{	 
				con.rollback();
				error_value = "0" ;
				error = getMessage(locale, "FAILED_TRANSACTION","CA");
			}
			if(pst!=null) pst.close();
			
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			if(con != null)ConnectionManager.returnConnection(con,request);			
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
