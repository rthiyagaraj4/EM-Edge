/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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


public class MFailureRemarks extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	//HttpSession session;
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
	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		String mode = req.getParameter("mode");
		modifyData(req,res,mode);
	}

	//Insert//Modify/Delete
	public void modifyData(HttpServletRequest req, HttpServletResponse res, String mode) throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();

		java.util.Properties prop = null;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String facility_id = (String)session.getValue( "facility_id" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		 login_user = prop.getProperty( "login_user" );
		 locale = prop.getProperty("LOCALE");

		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_update = null;
		PreparedStatement pstmt_select = null;
		PreparedStatement pstmt_select1 = null;
		ResultSet rs = null;
		int flag_2=0;
		String msg="";
		String sqlInsert="";
		String err_value = "0" ;

		String chk_trtmt_yn = "";
		String trmt_category_type_code = "";
		String chk_eff_status = "";
		int record_cnt = 0;

		try{
			con = ConnectionManager.getConnection(req);
			if(mode.equals("modify")){//Added by Sridevi Joshi on 5/12/2010 for IN021292
				String reason_code= checkForNull(req.getParameter("reason_code"),req.getParameter("reason_code1"));
				String reason_desc= checkForNull(req.getParameter("reason_desc"),req.getParameter("reason_desc1"));
				String eff_status= checkForNull(req.getParameter("eff_status"),"D");
				int row_count_int = Integer.parseInt(req.getParameter("row_count"));
				if(pstmt_select != null) pstmt_select.close();
				if(rs != null) rs.close();

				pstmt_select=con.prepareStatement("SELECT COUNT(*) RECORD_CNT FROM OH_REASONS_DTLS WHERE REASON_CODE = ? AND TRMT_CATEGORY_TYPE = ? ");

				if(pstmt_select1 != null) pstmt_select1.close();
				if(rs != null) rs.close();
				pstmt_select1=con.prepareStatement("SELECT EFF_STATUS FROM OH_REASONS WHERE REASON_CODE = ?");
				pstmt_select1.setString(1,reason_code);	
				rs = pstmt_select1.executeQuery();
				while (rs != null && rs.next()){
					chk_eff_status = checkForNull(rs.getString("EFF_STATUS"));
				}
               if(pstmt_update != null) pstmt_update.close();
				if(rs != null) rs.close();
				pstmt_update=con.prepareStatement("UPDATE OH_REASONS SET REASON_DESC = ? ,EFF_STATUS = ?, MODIFIED_BY_ID = ?,  MODIFIED_DATE = SYSDATE, MODIFIED_FACILITY_ID =?, MODIFIED_AT_WS_NO = ? WHERE REASON_CODE = ?");
				pstmt_update.setString(1,reason_desc);			
				pstmt_update.setString(2,eff_status);		
				pstmt_update.setString(3,login_user);					// MODIFIED_BY_ID
				pstmt_update.setString(4,facility_id);					// MODIFIED_FACILITY_ID
				pstmt_update.setString(5,client_ip_address);			// MODIFIED_AT_WS_NO
				pstmt_update.setString(6,reason_code);	
				flag_2 = pstmt_update.executeUpdate();

				if(pstmt_update != null) pstmt_update.close();
				pstmt_update=con.prepareStatement("UPDATE OH_REASONS_DTLS SET APPLICABLE_YN = ? , MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_FACILITY_ID =?, MODIFIED_AT_WS_NO = ? WHERE REASON_CODE = ? AND TRMT_CATEGORY_TYPE = ?");

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				pstmt=con.prepareStatement("INSERT INTO OH_REASONS_DTLS(REASON_CODE, TRMT_CATEGORY_TYPE, APPLICABLE_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?, ?, ?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");

				for(int i=1;i<=row_count_int;i++){
					chk_trtmt_yn = checkForNull(req.getParameter("chk_"+i),"N");
					trmt_category_type_code = req.getParameter("trmt_category_type_code_"+i);

					if(chk_eff_status.equals("D") && eff_status.equals("E")){
						chk_trtmt_yn = checkForNull(req.getParameter("chk1_"+i));
					}

					pstmt_select.setString(1,reason_code);		
					pstmt_select.setString(2,trmt_category_type_code);					
					rs = pstmt_select.executeQuery();
					while (rs != null && rs.next()){
						record_cnt = Integer.parseInt(checkForNull(rs.getString("RECORD_CNT")));
					}
				if(rs != null) rs.close();	//Common-ICN-0044
					if(record_cnt != 0){
						pstmt_update.setString(1,chk_trtmt_yn);					// APPLICABLE_YN
						pstmt_update.setString(2,login_user);					// MODIFIED_BY_ID
						pstmt_update.setString(3,facility_id);					// MODIFIED_FACILITY_ID
						pstmt_update.setString(4,client_ip_address);			// MODIFIED_AT_WS_NO
						pstmt_update.setString(5,reason_code);					// REASON_CODE
						pstmt_update.setString(6,trmt_category_type_code);		// TRMT_CATEGORY_TYPE

						flag_2 = pstmt_update.executeUpdate();
					}
					else{
						if(chk_trtmt_yn.equals("Y")){
							pstmt.setString(1,reason_code);					// REASON_CODE
							pstmt.setString(2,trmt_category_type_code);		// TRMT_CATEGORY_TYPE
							pstmt.setString(3,chk_trtmt_yn);				// APPLICABLE_YN
							pstmt.setString(4,login_user);					// ADDED_BY_ID
							pstmt.setString(5,facility_id);					// ADDED_FACILITY_ID
							pstmt.setString(6,client_ip_address);			// ADDED_AT_WS_NO
							pstmt.setString(7,login_user);					// MODIFIED_BY_ID
							pstmt.setString(8,facility_id);					// MODIFIED_FACILITY_ID
							pstmt.setString(9,client_ip_address);			// MODIFIED_AT_WS_NO

							flag_2 = pstmt.executeUpdate();
						}
					}
				}
			}
			else{
				String reason_code= checkForNull(req.getParameter("reason_code"));
				String reason_desc= checkForNull(req.getParameter("reason_desc"));
				String eff_status= checkForNull(req.getParameter("eff_status"));
				int row_count_int = Integer.parseInt(req.getParameter("row_count"));
			
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				sqlInsert="INSERT INTO OH_REASONS(REASON_CODE, REASON_DESC, EFF_STATUS, ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?, ?, ?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)";
				pstmt=con.prepareStatement(sqlInsert);
				pstmt.setString(1,reason_code);			
				pstmt.setString(2,reason_desc);		
				pstmt.setString(3,eff_status);		
				pstmt.setString(4,login_user);					// ADDED_BY_ID
				pstmt.setString(5,facility_id);					// ADDED_FACILITY_ID
				pstmt.setString(6,client_ip_address);			// ADDED_AT_WS_NO
				pstmt.setString(7,login_user);					// MODIFIED_BY_ID
				pstmt.setString(8,facility_id);					// MODIFIED_FACILITY_ID
				pstmt.setString(9,client_ip_address);			// MODIFIED_AT_WS_NO
				flag_2 = pstmt.executeUpdate();

				if(pstmt != null) pstmt.close();
				pstmt=con.prepareStatement("INSERT INTO OH_REASONS_DTLS(REASON_CODE, TRMT_CATEGORY_TYPE, APPLICABLE_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?, ?, ?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");

				for(int i=1;i<=row_count_int;i++){
					chk_trtmt_yn = req.getParameter("chk_"+i);
					chk_trtmt_yn=chk_trtmt_yn==null?"N":chk_trtmt_yn;
					chk_trtmt_yn=chk_trtmt_yn.equals("null")?"N":chk_trtmt_yn;
					chk_trtmt_yn=chk_trtmt_yn.equals("")?"N":chk_trtmt_yn;
					if(chk_trtmt_yn.equals("Y")){
						trmt_category_type_code = req.getParameter("trmt_category_type_code_"+i);
						pstmt.setString(1,reason_code);					// REASON_CODE
						pstmt.setString(2,trmt_category_type_code);		// TRMT_CATEGORY_TYPE
						pstmt.setString(3,chk_trtmt_yn);				// APPLICABLE_YN
						pstmt.setString(4,login_user);					// ADDED_BY_ID
						pstmt.setString(5,facility_id);					// ADDED_FACILITY_ID
						pstmt.setString(6,client_ip_address);			// ADDED_AT_WS_NO
						pstmt.setString(7,login_user);					// MODIFIED_BY_ID
						pstmt.setString(8,facility_id);					// MODIFIED_FACILITY_ID
						pstmt.setString(9,client_ip_address);			// MODIFIED_AT_WS_NO
						flag_2 = pstmt.executeUpdate();
					}
				}
			}

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
				System.err.println("Rollback performed, Err Msg in MFailureRemarks"+e.getMessage());
				con.rollback();
			}catch(Exception e_1){
				System.err.println("MFailureRemarks :Caught Exception during rollback"+e_1);
			}
			System.err.println("MFailureRemarks:Err Msg in MFailureRemarks"+e.getMessage());
		
			msg = e.toString();
			err_value="0";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" )+"&err_value="+err_value);
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				if(pstmt_update!=null) pstmt_update.close();
				if(pstmt_select!=null) pstmt_select.close();
				if(pstmt_select1!=null) pstmt_select1.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
    }
 }
