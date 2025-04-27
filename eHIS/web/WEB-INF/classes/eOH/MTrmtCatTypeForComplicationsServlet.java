/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developer   : Sridevi Joshi
	Created On  : 04/06/07
 */

package eOH;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;




public class MTrmtCatTypeForComplicationsServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";


	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		modifyData(req,res);
	
	}

	//Insert//Modify/Delete
	public void modifyData(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
	    session=req.getSession(false);
		out=res.getWriter();

		java.util.Properties prop = null;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String facility_id = (String)session.getValue( "facility_id" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");

		Connection con = null;
		PreparedStatement pstmt = null;
		int flag_1=0;
		int flag_2=0;
		String msg="";
		String err_value = "0" ;
		try{
			con = ConnectionManager.getConnection(req);
			String complication_code= req.getParameter("complication_code");
			//String row_count = req.getParameter("row_count");
			//int row_count_int = Integer.parseInt("row_count");
			int row_count_int = Integer.parseInt(req.getParameter("row_count"));
            String chk_trtmt_yn = "";
			String trmt_category_type_code = "";
			if(pstmt != null) pstmt.close();
			pstmt=con.prepareStatement("DELETE FROM OH_COMPLICATION_TRMT_CAT_TYPE WHERE COMPLICATION_CODE=?");
			pstmt.setString(1,complication_code);
			//pstmt.executeQuery();
			flag_1 = pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			pstmt=con.prepareStatement("INSERT INTO OH_COMPLICATION_TRMT_CAT_TYPE(COMPLICATION_CODE, TRMT_CATEGORY_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
			for(int i=1;i<=row_count_int;i++){
				chk_trtmt_yn = req.getParameter("chk_"+i);
				chk_trtmt_yn=chk_trtmt_yn==null?"N":chk_trtmt_yn;
				chk_trtmt_yn=chk_trtmt_yn.equals("null")?"N":chk_trtmt_yn;
				chk_trtmt_yn=chk_trtmt_yn.equals("")?"N":chk_trtmt_yn;
				if(chk_trtmt_yn.equals("Y")){
					trmt_category_type_code = req.getParameter("trmt_category_type_code_"+i);
					pstmt.setString(1,complication_code);			// COMPLICATION_CODE
					pstmt.setString(2,trmt_category_type_code);		// TRMT_CATEGORY_TYPE
					pstmt.setString(3,login_user);					// ADDED_BY_ID
					pstmt.setString(4,client_ip_address);			// ADDED_AT_WS_NO
					pstmt.setString(5,facility_id);					// ADDED_FACILITY_ID
					pstmt.setString(6,login_user);					// MODIFIED_BY_ID
					pstmt.setString(7,client_ip_address);			// MODIFIED_AT_WS_NO
					pstmt.setString(8,facility_id);					// MODIFIED_FACILITY_ID
					flag_2 = pstmt.executeUpdate();
				}
			}

			//con.commit();

			MessageManager mm=new MessageManager();
			if(flag_2!=0){
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				err_value = "1" ;
				mesg.clear();
			 }else{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
				msg = ((String) mesg.get("message"));
				err_value = "0" ;
				mesg.clear();
			 }
			  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" )+"&err_value="+err_value);
	    }catch(Exception e){
			try{
				System.err.println("Rollback performed, Err Msg in MTrmtCatTypeForComplicationsServlet"+e.getMessage());
				con.rollback();
			}catch(Exception e_1){
				System.err.println("MTrmtCatTypeForComplicationsServlet :Caught Exception during rollback"+e_1);
			}
			System.err.println("MTrmtCatTypeForComplicationsServlet:Err Msg in MTrmtCatTypeForComplicationsServlet"+e.getMessage());
			/*try{
				con.rollback();
			}catch(Exception e1){
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
			}
			msg = e.toString();
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
		}*/
			msg = e.toString();
			err_value="0";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" )+"&err_value="+err_value);
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
    }
 }
