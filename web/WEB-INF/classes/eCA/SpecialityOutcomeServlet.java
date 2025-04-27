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
import eCommon.Common.*;
import eCommon.SingleTabHandler.*;
public class  SpecialityOutcomeServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	boolean inserted		= false;
	String mode;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
		{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try	{

			session 			= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
            		
			
			mode 							=  req.getParameter("mode");
			mode 							= (mode == null)?"":mode;

			if(mode.equalsIgnoreCase("INSERT"))
			     insertSPecilaityOutcome(req,res);
            else 
			     modifySPecilaityOutcome(req,res);


		}catch(Exception e){
						out.println(e.toString());
			}
	}

 private void  insertSPecilaityOutcome(HttpServletRequest req, HttpServletResponse res){
		String module_id=req.getParameter("module_id_val");
		String outcome_code=req.getParameter("outcome_code_val");
		String outcome_desc=req.getParameter("descrptn_val");
		//String outcome_type=req.getParameter("type_val");
		String agegroupCode=req.getParameter("agegroupCode");

    	String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		int instval=0;
		Connection connection		= null;
		PreparedStatement insrt_pstmt = null;
		PreparedStatement check_pstmt = null;
		String locale = p.getProperty("LOCALE");
		MessageManager mm=new MessageManager();
		ResultSet rs1				=null;
		boolean flag=true;
		connection=ConnectionManager.getConnection(req);
		String sql_insrt="insert into CA_SPLTY_OUTCOME(module_id,outcome_code,outcome_desc,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,AGE_GROUP) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
		try{
		String sql_codechk="select outcome_code from CA_SPLTY_OUTCOME where upper(outcome_code) like upper(?)";

		try{
		
		check_pstmt=connection.prepareStatement(sql_codechk);
		check_pstmt.setString(1,outcome_code);
		rs1=check_pstmt.executeQuery();
		while(rs1!=null && rs1.next()){
			flag=false;
		}
		if(rs1!=null)
			rs1.close();
		if(check_pstmt!=null)
			check_pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		if(flag){
		try{	
			insrt_pstmt=connection.prepareStatement(sql_insrt);
			insrt_pstmt.setString(1,module_id);
			//insrt_pstmt.setString(2,outcome_type);
			insrt_pstmt.setString(3,outcome_code);
			insrt_pstmt.setString(4,outcome_desc);
			insrt_pstmt.setString(5,addedById);
			insrt_pstmt.setString(6,addedAtWorkstation);
			insrt_pstmt.setString(7,addedFacilityId);
			insrt_pstmt.setString(8,modifiedById);
			insrt_pstmt.setString(9,modifiedAtWorkstation);
			insrt_pstmt.setString(10,modifiedFacilityId);
			insrt_pstmt.setString(11,agegroupCode);
			instval=insrt_pstmt.executeUpdate();
			if(insrt_pstmt!=null)
				insrt_pstmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
			}
		}else{
				final java.util.Hashtable mesg1=mm.getMessage(locale,"CODE_ALREADY_EXISTS","Common");
				String msg1=((String) mesg1.get("message"));
				mesg1.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg1,"UTF-8") + "&err_value=0");
			
		}

		if(instval>0){
				connection.commit();
				if(connection!=null)
				connection.close();
				final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_MODIFIED","SM");
				String msg=((String) mesg.get("message"));
				mesg.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=1");
		}else{
				connection.rollback();
				if(connection!=null)
				connection.close();
		}
	}catch(Exception e){
	}
 }

  private void  modifySPecilaityOutcome(HttpServletRequest req, HttpServletResponse res){
    	String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		String outcome_code=req.getParameter("outcome_code_val");
		String outcome_desc=req.getParameter("descrptn_val");
		//String outcome_type=req.getParameter("type_val");
		String agegroupCode=req.getParameter("agegroupCode");


		MessageManager mm=new MessageManager();
		Connection connection		= null;
		PreparedStatement updt_pstmt = null;
		String locale = p.getProperty("LOCALE");
		int updtval=0;
		String updt_sql="update CA_SPLTY_OUTCOME set outcome_desc=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,AGE_GROUP=? where outcome_code=?";
		try{
		connection =ConnectionManager.getConnection(req);
		updt_pstmt=connection.prepareStatement(updt_sql);
		updt_pstmt.setString(1,outcome_desc);
		//updt_pstmt.setString(2,outcome_type);
		updt_pstmt.setString(2,modifiedById);
		updt_pstmt.setString(3,modifiedAtWorkstation);
		updt_pstmt.setString(4,modifiedFacilityId);
		updt_pstmt.setString(5,agegroupCode.trim());
		updt_pstmt.setString(6,outcome_code.trim());
		updtval=updt_pstmt.executeUpdate();
		if(updt_pstmt!=null)
			updt_pstmt.close();

		if(updtval>0){
		connection.commit();
		if(connection!=null)
		connection.close();
		final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_INSERTED","CA");
		String msg=((String) mesg.get("message"));
		mesg.clear();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=1");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
 }
}
