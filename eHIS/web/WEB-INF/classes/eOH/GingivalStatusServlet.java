/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  GingivalStatusServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		//HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOH.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		String locale="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst			= null;
		String sqlInsert = "";
		String sqlUpdate ="";
		int flag=0;
		int flag1=0;
		String msg="";
	//	int index = 1;
		String commit_flag = "N";
		ArrayList flag_arr= new ArrayList();
		try{
			con = ConnectionManager.getConnection(req);

			String value="";
			String sextant_sno="";
			String quadrant_sno="";
			String line_num="1";
			//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			//int count_GS = 0;
			//
			String patient_id = checkForNull(req.getParameter("patient_id"));
			String chart_num= checkForNull(req.getParameter("chart_num"));
			String quadrant = checkForNull(req.getParameter("oh_area"));
			String tooth_no = checkForNull(req.getParameter("oh_tooth"));
			//String condition_type = checkForNull(req.getParameter("oh_gingival"));
			String gingival_status_code = checkForNull(req.getParameter("oh_status"));
			//String status= checkForNull(req.getParameter("status_mark"));
			String show_new_active_yn = checkForNull(req.getParameter( "show_new_active_yn" )) ;
			String chart_hdr_insert_yn = checkForNull(req.getParameter("chart_hdr_insert_yn"));
			String clinical_group_code = checkForNull(req.getParameter("clinical_group_code"));
			String clinical_group_hid = checkForNull(req.getParameter("clinical_group_hid"));
			String chart_status = "A";
			String chart_type = checkForNull(req.getParameter("chart_type"));
			String gingival_recording_by = checkForNull(req.getParameter("gingival_recording_by"));
			String oh_chart_level = checkForNull(req.getParameter("oh_chart_level"));
			//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			String status_before_after = checkForNull(req.getParameter("status_before_after"));
			
			if(gingival_recording_by.equals("Q")){
				sextant_sno = "";
				quadrant_sno = quadrant;
			}
			else{
				sextant_sno = quadrant;
				quadrant_sno = "";
			}
				
            if(rst != null) rst.close();
			pstmt=con.prepareStatement("SELECT VALUE FROM OH_GINGIVAL_STATUS_LANG_VW WHERE GINGIVAL_STATUS_CODE=? AND LANGUAGE_ID=?");
			pstmt.setString(1,gingival_status_code);
			pstmt.setString(2,locale);
			rst = pstmt.executeQuery();
			while(rst.next()){
				value=rst.getString("VALUE");
			}
			if((show_new_active_yn.equals("Y") || chart_num.equals("1")) && chart_hdr_insert_yn.equals("Y")){
				
			//	if(show_new_active_yn.equals("Y")){ 
				if(show_new_active_yn.equals("Y") && oh_chart_level.equals("F")){ // Case 2
                  if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_STATUS='A'";
					pstmt=con.prepareStatement(sqlUpdate);
					pstmt.setString(1,login_user);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,patient_id);
					flag = pstmt.executeUpdate();
				}
                if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,CHART_STATUS,CHART_CLOSED_BY,CHART_CLOSE_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				pstmt=con.prepareStatement(sqlInsert);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_type);
				pstmt.setString(5,clinical_group_code);
				pstmt.setString(6,chart_status);
				pstmt.setString(7,login_user);
				pstmt.setString(8,login_user);
				pstmt.setString(9,client_ip_address);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,login_user);
				pstmt.setString(12,client_ip_address); 
				pstmt.setString(13,facility_id);

                flag1 = pstmt.executeUpdate();
			}
 
			if((show_new_active_yn.equals("Y") || !chart_num.equals("1")) && chart_hdr_insert_yn.equals("Y")){
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
			//	if(show_new_active_yn.equals("Y")){ 
				if(show_new_active_yn.equals("Y") && oh_chart_level.equals("F")){ // Case 2

					sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_STATUS='A'";
					pstmt=con.prepareStatement(sqlUpdate);
					pstmt.setString(1,login_user);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,patient_id);
					flag = pstmt.executeUpdate();
				}
               if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,CHART_STATUS,CHART_CLOSED_BY,CHART_CLOSE_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				pstmt=con.prepareStatement(sqlInsert);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_type);
				pstmt.setString(5,clinical_group_code);
				pstmt.setString(6,chart_status);
				pstmt.setString(7,login_user);
				pstmt.setString(8,login_user);
				pstmt.setString(9,client_ip_address);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,login_user);
				pstmt.setString(12,client_ip_address); 
				pstmt.setString(13,facility_id);

                flag1 = pstmt.executeUpdate();
			}

			// get the LINE_NUM
			
			/*pstmt=con.prepareStatement("SELECT MAX(LINE_NUM)+1 LINE_NUM FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			rst = pstmt.executeQuery();
			while(rst.next()){
				line_num=checkForNull(rst.getString("LINE_NUM"),"1");
			}*/
			if(oh_chart_level.equals("E")){
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				pstmt=con.prepareStatement("SELECT MAX(LINE_NUM)+1 LINE_NUM FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				rst = pstmt.executeQuery();
			}else{
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				pstmt=con.prepareStatement("SELECT MAX(LINE_NUM)+1 LINE_NUM FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				rst = pstmt.executeQuery();
			}

			while(rst.next()){
				line_num=checkForNull(rst.getString("LINE_NUM"),"1");
			}
			//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			/*if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT COUNT(*) COUNT_GS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				rst = pstmt.executeQuery();
			}else{
				pstmt=con.prepareStatement("SELECT COUNT(*) COUNT_GS FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
			}

			while(rst.next()){
				count_GS = rst.getInt("COUNT_GS");
			}  */


			//	
			sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_GING_STS (OPERATING_FACILITY_ID,PATIENT_ID, CHART_NUM, LINE_NUM, QUADRANT_SNO, SEXTENT_SNO, TOOTH_NO,  GINGIVAL_STATUS_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,  MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,STATUS,VALUE) VALUES(?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";
			if(pstmt!=null) pstmt.close();           
			pstmt=con.prepareStatement(sqlInsert);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,line_num);
			pstmt.setString(5,quadrant_sno);
			pstmt.setString(6,sextant_sno);
			pstmt.setString(7,tooth_no);
			//pstmt.setString(6,condition_type);
			pstmt.setString(8,gingival_status_code);
			pstmt.setString(9,login_user);
			pstmt.setString(10,client_ip_address);
			pstmt.setString(11,facility_id);
			pstmt.setString(12,login_user);
			pstmt.setString(13,client_ip_address); 
			pstmt.setString(14,facility_id);
			//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			/*if(count_GS == 1){
				pstmt.setString(15,"R");
			}else{//
				pstmt.setString(15,"O"); // The Alphabet 'O' for the status field. Because status is a pat of PKEY and hence it cannot be null.
			} */
			if(status_before_after.equals("A")){
				pstmt.setString(15,"A");
			}
			else if(status_before_after.equals("P")) //Deciduous tooth after Exfoliation and Eruption
			{
				pstmt.setString(15,"P");
			}
			else if(status_before_after.equals("D")) //Deciduous tooth before Exfoliation and Eruption
			{
				pstmt.setString(15,"D");
			}
			else if(status_before_after.equals("S"))  //Supernumerary tooth
			{
				pstmt.setString(15,"S");
			}
			else if(status_before_after.equals("R")) //Retained Deciduous tooth
			{
				pstmt.setString(15,"R");
			}
			else{
				pstmt.setString(15,"B");			
			}
			//
			pstmt.setString(16,value);
			flag = pstmt.executeUpdate();                  
			//ArrayList flag_arr= new ArrayList();
			if(!flag_arr.contains("0")){
				commit_flag="Y";
			}else{
				commit_flag="N";
			}


			// For Updating the Clinical Group
			int clinical_group_flag = 1;
			
			if(pstmt != null) pstmt.close();
			if((clinical_group_hid==null || clinical_group_hid.equals("")) && !clinical_group_code.equals("")){
				if(oh_chart_level.equals("E")){
					sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CLINICAL_GROUP_CODE = ? WHERE PATIENT_ID = ? AND CHART_NUM = ?";
					pstmt=con.prepareStatement(sqlUpdate);
					pstmt.setString(1,clinical_group_code);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					clinical_group_flag = pstmt.executeUpdate();
				}
				else{
					sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CLINICAL_GROUP_CODE = ? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ?";
					pstmt=con.prepareStatement(sqlUpdate);
					pstmt.setString(1,clinical_group_code);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_num);
					clinical_group_flag = pstmt.executeUpdate();
				}
			}

			MessageManager mm=new MessageManager();
			if(commit_flag.equals("Y") && flag!=0 && clinical_group_flag != 0){
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				  mesg.clear();
			 }else{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
				msg = ((String) mesg.get("message"));
				 mesg.clear();
			 }
			 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
			
        }catch(Exception e){
			try{
				System.err.println("Rollback performed, Err Msg in GingivalStatusServlet"+e.getMessage());
				con.rollback();
			}catch(Exception e_1){
				System.err.println("GingivalStatusServlet :Caught Exception during rollback"+e_1);
			}
			System.err.println("GingivalStatusServlet:Err Msg in GingivalStatusServlet"+e.getMessage());
			msg = e.toString();
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
		}finally{
			try{
				CommonData.clear();flag_arr.clear();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
    }
 }




 
