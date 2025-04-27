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
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class  SpecialityEpisodeCycleServlet extends HttpServlet {

	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	boolean inserted		= false;
	String mode;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
	public  void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		out = res.getWriter();
		res.setContentType("text/html; charset=UTF-8");
		String mode = req.getParameter("mode") == null ? "" :  req.getParameter("mode");

		session 			= req.getSession(true);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");

		if(mode.equalsIgnoreCase("insert"))
				insertSpecialityEpisodeCycle(req,res, out);
		if(mode.equalsIgnoreCase("modify"))
				modifySpecialityEpisodeCycle(req,res,out);
		if(mode.equalsIgnoreCase("DELETE"))
				deleteSpecialityEpisodeCycle(req,res,out);


}

  void insertSpecialityEpisodeCycle(HttpServletRequest req,HttpServletResponse res, PrintWriter out){

		String module_id=req.getParameter("mod_id_val") == null ? "" :  req.getParameter("mod_id_val");
		String spepisode_desc_val=req.getParameter("spepisode_desc_val") == null ? "" :  req.getParameter("spepisode_desc_val");
		String spevnt_desc_val=req.getParameter("spevnt_desc_val") == null ? "" :  req.getParameter("spevnt_desc_val");
    	String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		int instval=0;
		Connection connection		= null;
		Connection connection1		= null;
		PreparedStatement insrt_pstmt = null;
		PreparedStatement check_pstmt = null;
		String locale = p.getProperty("LOCALE");
		MessageManager mm=new MessageManager();
		ResultSet rs1				=null;
		boolean flag=true;
		String sql_insrt="insert into CA_SPLTY_EPISODE_CYCLE(SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC,MODULE_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		try{
		String sql_codechk="select MODULE_ID from CA_SPLTY_EPISODE_CYCLE where upper(MODULE_ID) like upper(?)";

		try{
		connection=ConnectionManager.getConnection(req);
		check_pstmt=connection.prepareStatement(sql_codechk);
		check_pstmt.setString(1,module_id);
		rs1=check_pstmt.executeQuery();
		while(rs1!=null && rs1.next()){
			flag=false;
		}
		if(rs1!=null)
			rs1.close();
		if(check_pstmt!=null)
			check_pstmt.close();
		if(connection1!=null)
			connection1.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		if(flag){
		try{
			insrt_pstmt=connection.prepareStatement(sql_insrt);
			insrt_pstmt.setString(1,spepisode_desc_val);
			insrt_pstmt.setString(2,spevnt_desc_val);
			insrt_pstmt.setString(3,module_id);
			insrt_pstmt.setString(4,addedById);
			insrt_pstmt.setString(5,addedAtWorkstation);
			insrt_pstmt.setString(6,addedFacilityId);
			insrt_pstmt.setString(7,modifiedById);
			insrt_pstmt.setString(8,modifiedAtWorkstation);
			insrt_pstmt.setString(9,modifiedFacilityId);
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
				final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_INSERTED","CA");
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

	void modifySpecialityEpisodeCycle(HttpServletRequest req,HttpServletResponse res,PrintWriter out){
    	String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		String module_id=req.getParameter("mod_id_val") == null ? "" :  req.getParameter("mod_id_val");
		String spepisode_desc_val=req.getParameter("spepisode_desc_val") == null ? "" :  req.getParameter("spepisode_desc_val");
		String spevnt_desc_val=req.getParameter("spevnt_desc_val") == null ? "" :  req.getParameter("spevnt_desc_val");
		MessageManager mm=new MessageManager();
		Connection connection		= null;
		PreparedStatement updt_pstmt = null;
		String locale = p.getProperty("LOCALE");
		int updtval=0;
		String updt_sql="update CA_SPLTY_EPISODE_CYCLE set SPLTY_EPISODE_DESC=?,SPLTY_TITLE_EVENT_DESC=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where MODULE_ID=?";
		try{
		connection =ConnectionManager.getConnection(req);
		updt_pstmt=connection.prepareStatement(updt_sql);
		updt_pstmt.setString(1,spepisode_desc_val);
		updt_pstmt.setString(2,spevnt_desc_val);
		updt_pstmt.setString(3,modifiedById);
		updt_pstmt.setString(4,modifiedAtWorkstation);
		updt_pstmt.setString(5,modifiedFacilityId);
		updt_pstmt.setString(6,module_id);
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

	void deleteSpecialityEpisodeCycle(HttpServletRequest req,HttpServletResponse res,PrintWriter out){
		String module_id=req.getParameter("mod_id_val") == null ? "" :  req.getParameter("mod_id_val");
		MessageManager mm=new MessageManager();
		Connection connection		= null;
		PreparedStatement updt_pstmt = null;
		String locale = p.getProperty("LOCALE");
		int updtval=0;
		String updt_sql="DELETE FROM  CA_SPLTY_EPISODE_CYCLE  where MODULE_ID=?";
		try{
		connection =ConnectionManager.getConnection(req);
		updt_pstmt=connection.prepareStatement(updt_sql);
		updt_pstmt.setString(1,module_id);
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
