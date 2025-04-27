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

public class OHDentalChartAmendServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}


	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		//HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOH.MasterXMLParse();
		
		java.util.Properties prop = null;
		String facility_id			= (String)session.getValue( "facility_id" ) ;
		prop				= (java.util.Properties)session.getValue( "jdbc" ) ;
		String client_ip_address	= prop.getProperty( "client_ip_address" );
		String login_user			= prop.getProperty( "login_user" );
		String locale				= prop.getProperty("LOCALE");
		String msg="";

		String[] tooth_range_arr = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst			= null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rst1			= null;
		int flag=0;
		int flag1=0;
		int flag2=0;
		int flag_delete=0;

		String deciduous_yn = "";
		String supernumerary_yn = "";
		String tooth_no = "";
		String tooth_no_or_chart_line_num = "";
		try{
				con = ConnectionManager.getConnection(req);
				String patient_id=checkForNull(req.getParameter("patient_id"));
				String chart_num = checkForNull(req.getParameter("chart_num"));
				String chart_line_num = checkForNull(req.getParameter("chart_line_num"));
				String mixed_dentition_YN = checkForNull(req.getParameter("mixed_dentition_YN"));
				String permanent_deciduous_flag = checkForNull(req.getParameter("permanent_deciduous_flag"));
				
				String site_type = checkForNull(req.getParameter("site"));
				String thrng_nos_ref = checkForNull(req.getParameter("thrng_nos_ref"));
				String mark_error_status = checkForNull(req.getParameter("oh_status"));
				String outcome = checkForNull(req.getParameter("oh_outcome"));
				String remarks = checkForNull(req.getParameter("remarks"));
				String condition_type = checkForNull(req.getParameter("condition_type")); 
				String condition_code = checkForNull(req.getParameter("dental_condition")); 
				String reasonforcancel = checkForNull(req.getParameter("reasonforcancel"));
				String oh_chart_level = checkForNull(req.getParameter("oh_chart_level"));
				//String retained_tooth_no = checkForNull(req.getParameter("retained_tooth_no"));	//Commented Against Common-ICN-0031
				String super_key_num = checkForNull(req.getParameter("super_key_num")); //Added by Sridevi Joshi on 1/20/2010 for CRF-481(IN010894)
				String failure_remarks = checkForNull(req.getParameter( "oh_failure" )) ;//added by parul on 01/03/2010 for CRF-477

				String intraoral_extraoral = "";
				String organ_code = "";
				String sub_organ_code = "";
				String surface_code = "";
				if (outcome.equals("") || outcome.equals("null") || outcome.equals(null)){//added by parul on 09/03/2010 for CRF-477
					outcome=checkForNull(req.getParameter("outcome"));
				}

				if(site_type.equals("MAXFS")){
					 organ_code=checkForNull(req.getParameter("oh_surface"));
					 //sub_organ_code=checkForNull(req.getParameter("oh_sub_parts"));
					 sub_organ_code=checkForNull(req.getParameter("sub_parts"));
				 }else{
		             surface_code = checkForNull(req.getParameter("oh_surface"));
				 }	
				if(site_type.equals("THRNG")){
					tooth_no = checkForNull(req.getParameter("thrng_nos_ref"));
				}else if(site_type.equals("MAXFS")){
					intraoral_extraoral = checkForNull(req.getParameter("area"));//added by parul for CRF 701 on 23/09/2009
					
					if(sub_organ_code.equals("THAB") || sub_organ_code.equals("THGM")  || sub_organ_code.equals("THAG") ||sub_organ_code.equals("THGAM") ||sub_organ_code.equals("THMF")){//THAB,THGM,THAG,THGAM,THMF
						tooth_no = checkForNull(req.getParameter("oh_selected_sub_parts"));//added by parul for CRF 701 on 23/09/2009
					}
					else if (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") || sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF")){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
						tooth_no = checkForNull(req.getParameter("thrng_nos_ref"));
					}
				}
				else{
					tooth_no = checkForNull(req.getParameter("area"));
				}

				// different logic should be written for Tooth_Range, For all the tooth_range list, individual updates or IN should be written
				if(site_type.equals("TOOTH") && tooth_no.indexOf(",") == -1){

					if(mark_error_status.equals("E")){
						if(pstmt != null) pstmt.close();
						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,chart_line_num);
							rst = pstmt.executeQuery();
						}
						else{
							pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND OPERATING_FACILITY_ID =? AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,facility_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,chart_line_num);
							rst = pstmt.executeQuery();
						}
						while(rst!= null && rst.next()){
							deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
							supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
							if(deciduous_yn.equals("R") || deciduous_yn.equals("D") || supernumerary_yn.equals("Y")){
								break;
							}
						}

					
						if(rst!=null) rst.close();
						if(pstmt != null) pstmt.close();

						if((deciduous_yn.equals("R") || deciduous_yn.equals("D"))&& (condition_type.equals("DECITH") || condition_type.equals("RTDESTH"))){
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND (MIXED_DENT_DECIDUOUS_YN = 'R' OR MIXED_DENT_DECIDUOUS_YN = 'D') AND TOOTH_NO = ?");
								pstmt.setString(1,mark_error_status);
								pstmt.setString(2,remarks);
								pstmt.setString(3,outcome);
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);
								pstmt.setString(6,client_ip_address);
								pstmt.setString(7,facility_id);
								pstmt.setString(8,reasonforcancel);
								pstmt.setString(9,login_user);
								pstmt.setString(10,patient_id);
								pstmt.setString(11,chart_num);
								pstmt.setString(12,tooth_no);

								flag = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?, FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND (MIXED_DENT_DECIDUOUS_YN = 'R' OR MIXED_DENT_DECIDUOUS_YN = 'D') AND TOOTH_NO = ?");
								pstmt.setString(1,mark_error_status);
								pstmt.setString(2,remarks);
								pstmt.setString(3,outcome);
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);
								pstmt.setString(6,client_ip_address);
								pstmt.setString(7,facility_id);
								pstmt.setString(8,reasonforcancel);
								pstmt.setString(9,login_user);
								pstmt.setString(10,facility_id);
								pstmt.setString(11,patient_id);
								pstmt.setString(12,chart_num);
								pstmt.setString(13,tooth_no);
								
								flag = pstmt.executeUpdate();
							}

						}
						else if(deciduous_yn.equals("R")){
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?, FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ? ,CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?  AND MIXED_DENT_DECIDUOUS_YN = 'R'");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,chart_line_num);
								
								flag = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ? ,CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND MIXED_DENT_DECIDUOUS_YN = 'R'");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
								pstmt.setString(11,patient_id);//PATIENT_ID
								pstmt.setString(12,chart_num);//CHART_NUM
								
								pstmt.setString(13,chart_line_num);
								flag = pstmt.executeUpdate();
							}
						}
						//else if(supernumerary_yn.equals("Y") && condition_type.equals("SUPRTH")){
						else if(condition_type.equals("SUPRTH")){
							if(oh_chart_level.equals("E")){
                                 //added by parul for super changes,if u mark super num as error,conditions recorded  on super tooth should be deleted. 
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_TYPE='SUPRTH' AND TOOTH_NO = ? AND SUPER_KEY_NUM = ?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,tooth_no);//CHART_LINE_NUM
								pstmt.setString(13,super_key_num);//Added by Sridevi Joshi on 1/20/2010 for CRF-481(IN010894)
								flag = pstmt.executeUpdate();//end

								/*if(flag != 0){
									con.commit();
								}else{
									con.rollback();
								}*/

								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = 'N'");
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,tooth_no);
								flag1=pstmt.executeUpdate();

								/*if(flag != 0 && flag1 != 0){
									con.commit();
								}else{
									con.rollback();
								}*/


								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND SUPERNUMERARY_YN = 'Y' AND TOOTH_NO = ? AND SUPER_KEY_NUM = ?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,tooth_no);//CHART_LINE_NUM
								pstmt.setString(13,super_key_num);//Added by Sridevi Joshi on 2/9/2010 for IN019062
								flag2 = pstmt.executeUpdate();

								/*if(flag != 0 && flag2 != 0){
									con.commit();
								}else{
									con.rollback();
								}*/
							}
							else{
                                //added by parul for super changes,if u mark super num as error,conditions recorded  on super tooth should be deleted. 
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_TYPE='SUPRTH' AND TOOTH_NO = ? AND SUPER_KEY_NUM = ?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,tooth_no);//CHART_LINE_NUM
								pstmt.setString(13,super_key_num);//Added by Sridevi Joshi on 1/20/2010 for CRF-481(IN010894)
								flag = pstmt.executeUpdate();
								/*if(flag != 0){
									con.commit();
								}else{
									con.rollback();
								}*/

								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = 'N'");
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,tooth_no);
								flag1 = pstmt.executeUpdate();

								/*if(flag != 0 && flag1 != 0){
									con.commit();
								}else{
									con.rollback();
								}*/

								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND SUPERNUMERARY_YN = 'Y' AND TOOTH_NO = ? AND SUPER_KEY_NUM = ?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
								pstmt.setString(11,patient_id);//PATIENT_ID
								pstmt.setString(12,chart_num);//CHART_NUM
								pstmt.setString(13,tooth_no);//CHART_LINE_NUM
								pstmt.setString(14,super_key_num);//Added by Sridevi Joshi on 1/21/2010 for CRF-481(IN010894)
								flag2 = pstmt.executeUpdate();

								/*if(flag != 0 && flag2 != 0){
									con.commit();
								}else{
									con.rollback();
								}*/
							}
						}
						else if(supernumerary_yn.equals("Y")){
							if(oh_chart_level.equals("E")){
								if(condition_type.equals("EXFOLTH")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND NVL(SUPERNUMERARY_YN,'X') != 'Y'"); //For Null values and also for the value N
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND SUPERNUMERARY_YN = 'Y' AND SUPER_KEY_NUM = ?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,chart_line_num);//CHART_LINE_NUM
								pstmt.setString(13,super_key_num);//Added by Sridevi Joshi on 2/9/2010 for IN019062
								flag = pstmt.executeUpdate();
							}
							else{
								if(condition_type.equals("EXFOLTH")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND NVL(SUPERNUMERARY_YN,'X') != 'Y'"); //For Null values and also for the value N
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();
								}
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND SUPERNUMERARY_YN = 'Y' AND SUPER_KEY_NUM = ?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
								pstmt.setString(11,patient_id);//PATIENT_ID
								pstmt.setString(12,chart_num);//CHART_NUM
								pstmt.setString(13,chart_line_num);//CHART_LINE_NUM
								pstmt.setString(14,super_key_num);//Added by Sridevi Joshi on 2/9/2010 for IN019062
								flag = pstmt.executeUpdate();
							}
							
						}
						else if(deciduous_yn.equals("D")){
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=? ,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?AND MIXED_DENT_DECIDUOUS_YN = 'D'");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);//CHART_LINE_NUM
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,chart_line_num);//CHART_LINE_NUM
								
								flag = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND MIXED_DENT_DECIDUOUS_YN = 'D'");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);//CHART_LINE_NUM
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
								pstmt.setString(11,patient_id);//PATIENT_ID
								pstmt.setString(12,chart_num);//CHART_NUM
								pstmt.setString(13,chart_line_num);//CHART_LINE_NUM
								
								flag = pstmt.executeUpdate();
							}
						}
						else{
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?, CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE  WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);//CHART_LINE_NUM
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,patient_id);//PATIENT_ID
								pstmt.setString(11,chart_num);//CHART_NUM
								pstmt.setString(12,chart_line_num);//CHART_LINE_NUM
								
								flag = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?, CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE  WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
								pstmt.setString(1,mark_error_status);//status
								pstmt.setString(2,remarks);//remarks
								pstmt.setString(3,outcome);//TREATMENTS_OUTCOME
								pstmt.setString(4,failure_remarks);//CHART_LINE_NUM
								pstmt.setString(5,login_user);//MODIFIED_BY_ID
								pstmt.setString(6,client_ip_address);//MODIFIED_AT_WS_NO
								pstmt.setString(7,facility_id);//MODIFIED_FACILITY_ID
								pstmt.setString(8,reasonforcancel);//CANCEL_REASON
								pstmt.setString(9,login_user);//CANCELLED_BY
								pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
								pstmt.setString(11,patient_id);//PATIENT_ID
								pstmt.setString(12,chart_num);//CHART_NUM
								pstmt.setString(13,chart_line_num);//CHART_LINE_NUM
								
								flag = pstmt.executeUpdate();
							}
						}
						
						/*pstmt.setString(1,mark_error_status);
						pstmt.setString(2,remarks);
						pstmt.setString(3,outcome);
						pstmt.setString(4,login_user);
						pstmt.setString(5,client_ip_address);
						pstmt.setString(6,facility_id);
						pstmt.setString(7,reasonforcancel);
						pstmt.setString(8,login_user);
						pstmt.setString(9,facility_id);
						pstmt.setString(10,patient_id);
						pstmt.setString(11,chart_num);
						//pstmt.setString(8,chart_line_num);
						if((deciduous_yn.equals("R") || deciduous_yn.equals("D"))&& (condition_type.equals("DECITH") || condition_type.equals("RTDESTH")) || ( !deciduous_yn.equals("D") && !deciduous_yn.equals("R") && supernumerary_yn.equals("Y")  && condition_type.equals("SUPRTH"))){
							pstmt.setString(12,tooth_no);
						}
						else{
							pstmt.setString(12,chart_line_num);
						}*/
						//flag = pstmt.executeUpdate();

						//To delete the record for UNERTH/PARERTH which is inserted forcibaly when RTDESTH is recorded
						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && condition_type.equals("RTDESTH")){
							//pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'F' AND CHART_LINE_NUM > ?");
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,condition_code);
								pstmt.setString(4,tooth_no);
								pstmt.setString(5,chart_line_num);
								flag_delete = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,condition_code);
								pstmt.setString(5,tooth_no);
								pstmt.setString(6,chart_line_num);
								flag_delete = pstmt.executeUpdate();
							}
						}
						else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P") && condition_type.equals("RTDESTH")){
							//pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'F' AND CHART_LINE_NUM > ?");
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,condition_code);
								pstmt.setString(4,tooth_no);
								pstmt.setString(5,chart_line_num);
								flag_delete = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,condition_code);
								pstmt.setString(5,tooth_no);
								pstmt.setString(6,chart_line_num);
								flag_delete = pstmt.executeUpdate();
							}
						}
						else if(mixed_dentition_YN.equals("N") && permanent_deciduous_flag.equals("P") && condition_type.equals("RTDESTH")){
							//pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'UNERTH' AND TOOTH_NO = ?  AND STATUS = 'F' AND CHART_LINE_NUM > ?");
							if(oh_chart_level.equals("E")){
								pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'UNERTH' AND TOOTH_NO = ?  AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,condition_code);
								pstmt.setString(4,tooth_no);
								pstmt.setString(5,chart_line_num);
								flag_delete = pstmt.executeUpdate();
							}
							else{
								pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'UNERTH' AND TOOTH_NO = ?  AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,condition_code);
								pstmt.setString(5,tooth_no);
								pstmt.setString(6,chart_line_num);
								flag_delete = pstmt.executeUpdate();
							}
						}
										
						if(pstmt != null) pstmt.close();
						if(condition_type.equals("IMPACTN")){
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'UNERTH' ");
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'UNERTH'");
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'PARERTH' ),'PARERTH','','UNERTH')");
							/*
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'ERUPTH' ),'ERUPTH','ERUPTH',(SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'PARERTH' ),'PARERTH','PARERTH','UNERTH')");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							pstmt.setString(5,facility_id);
							pstmt.setString(6,patient_id);
							pstmt.setString(7,chart_num);
							pstmt.setString(8,tooth_no);
							pstmt.setString(9,facility_id);
							pstmt.setString(10,patient_id);
							pstmt.setString(11,chart_num);
							pstmt.setString(12,tooth_no);
							pstmt.executeUpdate();
							*/
							if(oh_chart_level.equals("E")){
								pstmt = con.prepareStatement("SELECT CONDITION_TYPE,CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' ORDER BY CHART_LINE_NUM DESC");
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,tooth_no);
								rst = pstmt.executeQuery();
								if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
								while(rst.next()){
									if(checkForNull(rst.getString("CONDITION_TYPE")).equals("PARERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'PARERTH'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("UNERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'UNERTH'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("ERUPTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'ERUPTH'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("IMPACTN")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'IMPACTN'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									if(pstmt != null) pstmt.close(); //Common-ICN-0044
								}
							}
							else{
								pstmt = con.prepareStatement("SELECT CONDITION_TYPE,CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' ORDER BY CHART_LINE_NUM DESC");
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,tooth_no);
								rst = pstmt.executeQuery();
								if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
								while(rst.next()){
									if(checkForNull(rst.getString("CONDITION_TYPE")).equals("PARERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'PARERTH'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("UNERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'UNERTH'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("ERUPTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'ERUPTH'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("IMPACTN")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'IMPACTN'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									if(pstmt != null) pstmt.close();//Added Against Common-ICN-0031
								}
							}
						}
						else if(condition_type.equals("PARERTH")){
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'UNERTH' ");
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','IMPACTN') ");
							/*
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'ERUPTH' ),'ERUPTH','ERUPTH',(SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'IMPACTN' ),'IMPACTN','IMPACTN','UNERTH')");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							pstmt.setString(5,facility_id);
							pstmt.setString(6,patient_id);
							pstmt.setString(7,chart_num);
							pstmt.setString(8,tooth_no);
							pstmt.setString(9,facility_id);
							pstmt.setString(10,patient_id);
							pstmt.setString(11,chart_num);
							pstmt.setString(12,tooth_no);
							pstmt.executeUpdate();
							*/
							if(oh_chart_level.equals("E")){
								pstmt = con.prepareStatement("SELECT CONDITION_TYPE,CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' ORDER BY CHART_LINE_NUM DESC");
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,tooth_no);
								rst = pstmt.executeQuery();
								if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
								while(rst.next()){
									if(checkForNull(rst.getString("CONDITION_TYPE")).equals("ERUPTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'ERUPTH'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("UNERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'UNERTH'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("IMPACTN")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'IMPACTN'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("PARERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'PARERTH'");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,tooth_no);
										pstmt.setString(4,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
								}	
							}
							else{
								pstmt = con.prepareStatement("SELECT CONDITION_TYPE,CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' ORDER BY CHART_LINE_NUM DESC");
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,tooth_no);
								rst = pstmt.executeQuery();
								while(rst.next()){
									if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
									if(checkForNull(rst.getString("CONDITION_TYPE")).equals("ERUPTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'ERUPTH'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("UNERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'UNERTH'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("IMPACTN")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'IMPACTN'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									else if(checkForNull(rst.getString("CONDITION_TYPE")).equals("PARERTH")){
										pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'PARERTH'");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,tooth_no);
										pstmt.setString(5,checkForNull(rst.getString("CHART_LINE_NUM")));
										pstmt.executeUpdate();
										break;
									}
									if(pstmt != null) pstmt.close(); //Added Against Common-ICN-0031
								}
							}
						}
						else if(condition_type.equals("ERUPTH")){
							String update_parer_yn = "N";
							String update_uner_yn = "N";
							String update_impact_yn = "N";
							String update_parer_chart_line_num = "";
							String update_uner_chart_line_num = "";
							String update_impact_chart_line_num = "";
							if(oh_chart_level.equals("E")){
								pstmt1 = con.prepareStatement("SELECT CONDITION_TYPE,CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' ORDER BY CHART_LINE_NUM DESC");
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_no);
								rst1 = pstmt1.executeQuery();

								while(rst1.next()){
									if(checkForNull(rst1.getString("CONDITION_TYPE")).equals("PARERTH")){
										update_parer_yn = "Y";
										update_parer_chart_line_num = checkForNull(rst1.getString("CHART_LINE_NUM"));
										break;
									}
									else if(checkForNull(rst1.getString("CONDITION_TYPE")).equals("UNERTH")){
										update_uner_yn = "Y";
										update_uner_chart_line_num = checkForNull(rst1.getString("CHART_LINE_NUM"));
										break;
									}
									else if(checkForNull(rst1.getString("CONDITION_TYPE")).equals("IMPACTN")){
										update_impact_yn = "Y";
										update_impact_chart_line_num = checkForNull(rst1.getString("CHART_LINE_NUM"));
										break;
									}
								}
								
								if(update_parer_yn.equals("Y")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE ='PARERTH'");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.setString(4,update_parer_chart_line_num);
									pstmt.executeUpdate();

									//This is to set HIDE_IMAGE_YN = 'N' Mark error ERUPTH after RETDESTH----->ERUPTH where status for forcibaly inserted PARERTH record will be 'Z' 
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') = 'Z' AND CONDITION_TYPE ='PARERTH'");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}
								else if(update_impact_yn.equals("Y")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'IMPACTN'");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.setString(4,update_impact_chart_line_num);
									pstmt.executeUpdate();
								}
								else if(update_uner_yn.equals("Y")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'UNERTH'");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.setString(4,update_uner_chart_line_num);
									pstmt.executeUpdate();

									//This is to set HIDE_IMAGE_YN = 'N' Mark error ERUPTH after RETDESTH----->ERUPTH where status for forcibaly inserted UNERTH record will be 'Z' 
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') = 'Z' AND CONDITION_TYPE ='UNERTH'");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}
							}
							else{
								pstmt1 = con.prepareStatement("SELECT CONDITION_TYPE,CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' ORDER BY CHART_LINE_NUM DESC");
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_no);
								rst1 = pstmt1.executeQuery();

								while(rst1.next()){
									if(checkForNull(rst1.getString("CONDITION_TYPE")).equals("PARERTH")){
										update_parer_yn = "Y";
										update_parer_chart_line_num = checkForNull(rst1.getString("CHART_LINE_NUM"));
										break;
									}
									else if(checkForNull(rst1.getString("CONDITION_TYPE")).equals("UNERTH")){
										update_uner_yn = "Y";
										update_uner_chart_line_num = checkForNull(rst1.getString("CHART_LINE_NUM"));
										break;
									}
									else if(checkForNull(rst1.getString("CONDITION_TYPE")).equals("IMPACTN")){
										update_impact_yn = "Y";
										update_impact_chart_line_num = checkForNull(rst1.getString("CHART_LINE_NUM"));
										break;
									}
								}
						
								if(update_parer_yn.equals("Y")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE ='PARERTH'");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.setString(5,update_parer_chart_line_num);
									pstmt.executeUpdate();

									//This is to set HIDE_IMAGE_YN = 'N' Mark error ERUPTH after RETDESTH----->ERUPTH where status for forcibaly inserted PARERTH record will be 'Z' 
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') = 'Z' AND CONDITION_TYPE ='PARERTH'");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();
								}
								else if(update_impact_yn.equals("Y")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'IMPACTN'");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.setString(5,update_impact_chart_line_num);
									pstmt.executeUpdate();
								}
								else if(update_uner_yn.equals("Y")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', STATUS = NULL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CHART_LINE_NUM = ? AND CONDITION_TYPE = 'UNERTH'");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.setString(5,update_uner_chart_line_num);
									pstmt.executeUpdate();

									//This is to set HIDE_IMAGE_YN = 'N' Mark error ERUPTH after RETDESTH----->ERUPTH where status for forcibaly inserted UNERTH record will be 'Z' 
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') = 'Z' AND CONDITION_TYPE ='UNERTH'");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();
								}
							}
						}
						else if(condition_type.equals("EXFOLTH")){
							String condition_type_update = "";
							String mixed_dent_deciduous_yn_update = "";
							String supernumerary_yn_update = "";

							if(pstmt1 != null) pstmt1.close();						
							if(rst1 != null) rst1.close();		
							
							if(oh_chart_level.equals("E")){
								pstmt1 = con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND CHART_LINE_NUM = ?");
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_no);
								pstmt1.setString(4,chart_line_num);
								rst1 = pstmt1.executeQuery();

								while(rst1.next()){
									mixed_dent_deciduous_yn_update = checkForNull(rst1.getString("MIXED_DENT_DECIDUOUS_YN"));
									supernumerary_yn_update = checkForNull(rst1.getString("SUPERNUMERARY_YN"));
									if(mixed_dent_deciduous_yn_update.equals("R")){
										condition_type_update = "RTDESTH";
										
									}
									else if(mixed_dent_deciduous_yn_update.equals("D")){
										condition_type_update = "DECITH";
										
									}
									else if(supernumerary_yn_update.equals("Y")){
										condition_type_update = "SUPRTH";
										
									}
								}

								if(condition_type_update != "" && condition_type_update != null){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ?");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.setString(4,condition_type_update);
									pstmt.executeUpdate();
								}
								
								if(rst != null) rst.close();
								if(pstmt != null) pstmt.close();
								if(supernumerary_yn_update.equals("Y")){
									//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND SUPERNUMERARY_YN = 'Y'"); //commented By Sridevi Joshi on 30/01/2010 for IN010894
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH') AND SUPERNUMERARY_YN = 'Y' and super_key_num = ?"); 
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.setString(4,super_key_num);//Added super_key_num for IN019062 by SRidevi Joshi
									pstmt.executeUpdate();
								}
								else if(mixed_dent_deciduous_yn_update.equals("R")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}
								else{
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND NVL(STATUS, 'X') != 'Z' AND NVL(STATUS, 'X') != 'H'"); 
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}
								/*
								if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', MIXED_DENT_DECIDUOUS_YN = 'M' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND NVL(STATUS, 'X') != 'Z' AND NVL(STATUS, 'X') != 'H'"); 
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();//added by Sridevi Joshi on 15/12/2008
								}*/
							}
							else{
								pstmt1 = con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND CHART_LINE_NUM = ?");
								
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_no);
								pstmt1.setString(5,chart_line_num);
								rst1 = pstmt1.executeQuery();

								while(rst1.next()){
									mixed_dent_deciduous_yn_update = checkForNull(rst1.getString("MIXED_DENT_DECIDUOUS_YN"));
									supernumerary_yn_update = checkForNull(rst1.getString("SUPERNUMERARY_YN"));

									if(mixed_dent_deciduous_yn_update.equals("R")){
										condition_type_update = "RTDESTH";
										
									}
									else if(mixed_dent_deciduous_yn_update.equals("D")){
										condition_type_update = "DECITH";
										
									}
									else if(supernumerary_yn_update.equals("Y")){
										condition_type_update = "SUPRTH";
										
									}
								}

								if(condition_type_update != "" && condition_type_update != null){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ?");

									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.setString(5,condition_type_update);
									pstmt.executeUpdate();
								}
								
								if(rst != null) rst.close();
								if(pstmt != null) pstmt.close();
								if(supernumerary_yn_update.equals("Y")){
									//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND SUPERNUMERARY_YN = 'Y'"); 
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH') AND SUPERNUMERARY_YN = 'Y' and super_key_num = ?"); 
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.setString(5,super_key_num);//Added super_key_num for IN019062 by SRidevi Joshi
									//pstmt.executeUpdate();
									pstmt.executeUpdate();
								}
								else if(mixed_dent_deciduous_yn_update.equals("R")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									//pstmt.executeUpdate();
									pstmt.executeUpdate();
								}
								else{
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND NVL(STATUS, 'X') != 'Z' AND NVL(STATUS, 'X') != 'H'"); 
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									//pstmt.executeUpdate();
									pstmt.executeUpdate();
								}
								/*
								if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N', MIXED_DENT_DECIDUOUS_YN = 'M' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND NVL(STATUS, 'X') != 'Z' AND NVL(STATUS, 'X') != 'H'"); 
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();//added by Sridevi Joshi on 15/12/2008
								}*/
							}
						}
					}
					else{
						if(pstmt != null) pstmt.close();
						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?, REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?, CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE  WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
							//Cmmented by sridevi Joshi for CRF-377
							//remarks = java.net.URLDecoder.decode(checkForNull(req.getParameter("remarks")),"UTF-8");
							pstmt.setString(1,mark_error_status);
							pstmt.setString(2,outcome);
							pstmt.setString(3,failure_remarks);
							pstmt.setString(4,remarks);
							pstmt.setString(5,login_user);
							pstmt.setString(6,client_ip_address);
							pstmt.setString(7,facility_id);
							pstmt.setString(8,reasonforcancel);
							pstmt.setString(9,login_user);
							pstmt.setString(10,patient_id);
							pstmt.setString(11,chart_num);
							pstmt.setString(12,chart_line_num);
							flag = pstmt.executeUpdate();
						}
						else{
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?, REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?, CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE  WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
							//Cmmented by sridevi Joshi for CRF-377
							//remarks = java.net.URLDecoder.decode(checkForNull(req.getParameter("remarks")),"UTF-8");
							pstmt.setString(1,mark_error_status);
							pstmt.setString(2,outcome);
							pstmt.setString(3,failure_remarks);
							pstmt.setString(4,remarks);
							pstmt.setString(5,login_user);
							pstmt.setString(6,client_ip_address);
							pstmt.setString(7,facility_id);
							pstmt.setString(8,reasonforcancel);
							pstmt.setString(9,login_user);
							pstmt.setString(10,facility_id);
							pstmt.setString(11,patient_id);
							pstmt.setString(12,chart_num);
							pstmt.setString(13,chart_line_num);
							flag = pstmt.executeUpdate();

						}
					}
				
					MessageManager mm=new MessageManager();
					if(flag!=0){
						con.commit();
						final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
						msg = ((String) mesg.get("message"));
						mesg.clear(); //Common-ICN-0044
					 }else{
						con.rollback();
						final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
						msg = ((String) mesg.get("message"));
						mesg.clear(); //Common-ICN-0044
					 }
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
				}
				else if((site_type.equals("THRNG") || (site_type.equals("TOOTH") && tooth_no.indexOf(",") != -1)) ||(site_type.equals("MAXFS") && (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") || sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF")))){
					if(oh_chart_level.equals("E")){
						//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TOOTH_NO = ? ");
						if(mark_error_status.equals("E")){
							if(pstmt != null) pstmt.close();
							//pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND OPERATING_FACILITY_ID =? AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND TOOTH_NO = ?");
							//Added CHART_LINE_NUM by sridevi joshi on 24/12/08 
							pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND CHART_LINE_NUM =  ? AND TOOTH_NO = ?");
							if(thrng_nos_ref.indexOf(",") != -1){
								tooth_range_arr = thrng_nos_ref.split(",");
								for(int m=0;m<tooth_range_arr.length;m++){
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,chart_line_num);
									pstmt.setString(4,tooth_range_arr[m]);
									if(rst != null) rst.close();
									rst = pstmt.executeQuery();
									while(rst!= null && rst.next()){
										deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
										supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
										if(deciduous_yn.equals("R") || deciduous_yn.equals("D") || supernumerary_yn.equals("Y")){
											break;
										}
									}
									if(rst != null) rst.close();
								}
								if(rst != null) rst.close();
								if(pstmt != null) pstmt.close();
							}
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();

							if((deciduous_yn.equals("R") || deciduous_yn.equals("D"))&& (condition_type.equals("DECITH") || condition_type.equals("RTDESTH"))){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?, TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND (MIXED_DENT_DECIDUOUS_YN = 'R' OR MIXED_DENT_DECIDUOUS_YN = 'D') AND TOOTH_NO = ?");
								tooth_no_or_chart_line_num = "TOOTH_NO";
							}
							else if(deciduous_yn.equals("R")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,'FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ? ,CANCELLED_BY = ?,CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND MIXED_DENT_DECIDUOUS_YN = 'R");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							else if(deciduous_yn.equals("D")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?,CANCELLED_BY = ? ,CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND MIXED_DENT_DECIDUOUS_YN = 'D'  ");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							else if(supernumerary_yn.equals("Y")){
								
								if(condition_type.equals("SUPRTH")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = 'N'");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}
								else if(condition_type.equals("EXFOLTH")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = NULL");
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,tooth_no);
									pstmt.executeUpdate();
								}

								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND SUPERNUMERARY_YN = 'Y' AND TOOTH_NO = ?");
								tooth_no_or_chart_line_num = "TOOTH_NO";
							}
							else if(supernumerary_yn.equals("Y")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? , CANCEL_REASON = ? , CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?  AND SUPERNUMERARY_YN = 'Y'");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							else{
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?, FAILURE_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? , CANCEL_REASON = ? , CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? ");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							if(thrng_nos_ref.indexOf(",") != -1){
								tooth_range_arr = thrng_nos_ref.split(",");
								for(int m=0;m<tooth_range_arr.length;m++){

									if(supernumerary_yn.equals("Y") && condition_type.equals("SUPRTH")){
										pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = 'N'");
										pstmt2.setString(1,patient_id);
										pstmt2.setString(2,chart_num);
										pstmt2.setString(3,tooth_range_arr[m]);
										pstmt2.executeUpdate();
									}

									pstmt.setString(1,mark_error_status);
									pstmt.setString(2,remarks);
									pstmt.setString(3,outcome);
									pstmt.setString(4,failure_remarks);
									pstmt.setString(5,login_user);
									pstmt.setString(6,client_ip_address);
									pstmt.setString(7,facility_id);
									pstmt.setString(8,reasonforcancel);
									pstmt.setString(9,login_user);
									pstmt.setString(10,patient_id);
									pstmt.setString(11,chart_num);
									if(tooth_no_or_chart_line_num.equals("TOOTH_NO")){
										pstmt.setString(12,tooth_range_arr[m]);
									}
									else{
										pstmt.setString(12,chart_line_num);
										
									}
									
									/*
									if((deciduous_yn.equals("R") || deciduous_yn.equals("D"))&& (condition_type.equals("DECITH") || condition_type.equals("RTDESTH")) || (supernumerary_yn.equals("Y") && condition_type.equals("SUPRTH"))){
										pstmt.setString(12,tooth_range_arr[m]);
									}
									else{
										pstmt.setString(12,chart_line_num);
									}
									*/
									
									//pstmt.setString(9,tooth_range_arr[m]);
									//pstmt.setString(10,thrng_nos_ref);
									flag = pstmt.executeUpdate();
									//To delete the record for UNERTH/PARERTH which is inserted forcibaly when RTDESTH is recorded
									if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && condition_type.equals("RTDESTH")){
										pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,condition_code);
										pstmt.setString(4,tooth_range_arr[m]);
										pstmt.setString(5,chart_line_num);
										flag_delete = pstmt.executeUpdate();
									}
									else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && condition_type.equals("RTDESTH")){
										pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,condition_code);
										pstmt.setString(4,tooth_range_arr[m]);
										pstmt.setString(5,chart_line_num);
										flag_delete = pstmt.executeUpdate();
									}
									else if(mixed_dentition_YN.equals("N") && permanent_deciduous_flag.equals("P") && condition_type.equals("RTDESTH")){
										pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'UNERTH' AND TOOTH_NO = ?  AND STATUS = 'Z' AND CHART_LINE_NUM > ?");
										pstmt.setString(1,patient_id);
										pstmt.setString(2,chart_num);
										pstmt.setString(3,condition_code);
										pstmt.setString(4,tooth_range_arr[m]);
										pstmt.setString(5,chart_line_num);
										flag_delete = pstmt.executeUpdate();
									}
									
									if(pstmt2 != null) pstmt2.close();

									if(condition_type.equals("IMPACTN")){
										//pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='UNERTH' ");
										pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'PARERTH' ),'PARERTH','','UNERTH')");
										pstmt2.setString(1,patient_id);
										pstmt2.setString(2,chart_num);
										pstmt2.setString(3,tooth_range_arr[m]);
										pstmt2.executeUpdate();
									}
									else if(condition_type.equals("PARERTH")){
										//pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','IMPACTN') ");
										pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'IMPACTN' ),'IMPACTN','IMPACTN','UNERTH')");
										pstmt2.setString(1,patient_id);
										pstmt2.setString(2,chart_num);
										pstmt2.setString(3,tooth_range_arr[m]);
										pstmt2.executeUpdate();
									}
									else if(condition_type.equals("ERUPTH")){
										String update_parer_yn = "N";
										String update_uner_yn = "N";
										String update_impact_yn = "N";
										pstmt1 = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'");
										pstmt1.setString(1,patient_id);
										pstmt1.setString(2,chart_num);
										pstmt1.setString(3,tooth_range_arr[m]);
										rst1 = pstmt1.executeQuery();

										while(rst1.next()){
											if(rst1.getString("CONDITION_TYPE").equals("PARERTH")){
												update_parer_yn = "Y";
											}
											else if(rst1.getString("CONDITION_TYPE").equals("UNERTH")){
												update_uner_yn = "Y";
											}
											else if(rst1.getString("CONDITION_TYPE").equals("IMPACTN")){
												update_impact_yn = "Y";
											}
										}

										if(update_parer_yn.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE ='PARERTH'");
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											pstmt2.executeUpdate();
										}
										if(update_uner_yn.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'UNERTH'");
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											pstmt2.executeUpdate();
										}
										if(update_impact_yn.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'IMPACTN'");
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											pstmt2.executeUpdate();
										}
									}
									else if(condition_type.equals("EXFOLTH")){
										String condition_type_update = "";
										String mixed_dent_deciduous_yn_update = "";
										String supernumerary_yn_update = "";

										if(pstmt1 != null) pstmt1.close();						
										if(rst1 != null) rst1.close();						

										pstmt1 = con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND CHART_LINE_NUM = ?");
										pstmt1.setString(1,patient_id);
										pstmt1.setString(2,chart_num);
										pstmt1.setString(3,tooth_range_arr[m]);
										pstmt1.setString(4,chart_line_num);
										rst1 = pstmt1.executeQuery();

										while(rst1.next()){
											mixed_dent_deciduous_yn_update = checkForNull(rst1.getString("MIXED_DENT_DECIDUOUS_YN"));
											supernumerary_yn_update = checkForNull(rst1.getString("SUPERNUMERARY_YN"));

											if(mixed_dent_deciduous_yn_update.equals("R")){
												condition_type_update = "RTDESTH";
												
											}
											else if(mixed_dent_deciduous_yn_update.equals("D")){
												condition_type_update = "DECITH";
												
											}
											else if(supernumerary_yn_update.equals("Y")){
												condition_type_update = "SUPRTH";
												
											}
											
										}

										if(condition_type_update != "" && condition_type_update != null){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ?");
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											pstmt2.setString(4,condition_type_update);
											pstmt2.executeUpdate();
										}

										if(pstmt != null) pstmt.close();
										if(supernumerary_yn_update.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND SUPERNUMERARY_YN = 'Y'"); 
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											//pstmt.executeUpdate();
											pstmt2.executeUpdate();//added by Sridevi Joshi on 19/11/2008*/
										}
										else if(mixed_dent_deciduous_yn_update.equals("R")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											//pstmt.executeUpdate();
											pstmt2.executeUpdate();//added by Sridevi Joshi on 19/11/2008*/
										}
										else{
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND NVL(STATUS, 'X') != 'Z'"); 
											pstmt2.setString(1,patient_id);
											pstmt2.setString(2,chart_num);
											pstmt2.setString(3,tooth_range_arr[m]);
											//pstmt.executeUpdate();
											pstmt2.executeUpdate();//added by Sridevi Joshi on 19/11/2008*/
										}
									}
									int chart_line_num_int = Integer.parseInt(chart_line_num);
									chart_line_num_int ++;
									chart_line_num = ""+chart_line_num_int;
								}
								
								MessageManager mm=new MessageManager();
								if(flag!=0){
									con.commit();
									final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }else{
									con.rollback();
									final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }
								 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
							}
						}
						else{
							ArrayList flag_arr= new ArrayList();
							if(thrng_nos_ref.indexOf(",") != -1){
								tooth_range_arr = thrng_nos_ref.split(",");
								for(int m=0;m<tooth_range_arr.length;m++){
									if(pstmt != null) pstmt.close();
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?, REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?, CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE  WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?  ");
									
									pstmt.setString(1,mark_error_status);
									pstmt.setString(2,outcome);
									pstmt.setString(3,failure_remarks);
									pstmt.setString(4,remarks);
									pstmt.setString(5,login_user);
									pstmt.setString(6,client_ip_address);
									pstmt.setString(7,facility_id);
									pstmt.setString(8,reasonforcancel);
									pstmt.setString(9,login_user);
									pstmt.setString(10,facility_id);
									pstmt.setString(11,patient_id);
									pstmt.setString(12,chart_num);
									pstmt.setString(13,chart_line_num);
									
									flag = pstmt.executeUpdate();
									flag_arr.add(""+flag);

									int chart_line_num_int = Integer.parseInt(chart_line_num);
									chart_line_num_int ++;
									chart_line_num = ""+chart_line_num_int;
									if(pstmt != null) pstmt.close(); //Common-ICN-0044
									
								}

								MessageManager mm=new MessageManager();
								if(!flag_arr.contains("0")){
									con.commit();
									final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }else{
									con.rollback();
									final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }
								 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
							}
							flag_arr.clear();	//Common-ICN-0044
						}
					}
					else{
						//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TOOTH_NO = ? ");
						if(mark_error_status.equals("E")){
						if(pstmt != null) pstmt.close();
						//pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND OPERATING_FACILITY_ID =? AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND TOOTH_NO = ?");
						//Added CHART_LINE_NUM by sridevi joshi on 24/12/08 
						pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND OPERATING_FACILITY_ID =? AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND CHART_LINE_NUM =  ? AND TOOTH_NO = ?");
							if(thrng_nos_ref.indexOf(",") != -1){
								tooth_range_arr = thrng_nos_ref.split(",");
								for(int m=0;m<tooth_range_arr.length;m++){
									pstmt.setString(1,patient_id);
									pstmt.setString(2,facility_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,chart_line_num);
									pstmt.setString(5,tooth_range_arr[m]);
									if(rst != null) rst.close();
									rst = pstmt.executeQuery();
									while(rst!= null && rst.next()){
										deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
										supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
										if(deciduous_yn.equals("R") || deciduous_yn.equals("D") || supernumerary_yn.equals("Y")){
											break;
										}
									}
									if(rst != null) rst.close();
								}
								if(rst != null) rst.close();
								if(pstmt != null) pstmt.close();
							}
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();

							if((deciduous_yn.equals("R") || deciduous_yn.equals("D"))&& (condition_type.equals("DECITH") || condition_type.equals("RTDESTH"))){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?, TREATMENTS_OUTCOME = ?,failure_remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND (MIXED_DENT_DECIDUOUS_YN = 'R' OR MIXED_DENT_DECIDUOUS_YN = 'D') AND TOOTH_NO = ?  ");
								tooth_no_or_chart_line_num = "TOOTH_NO";
							}
							else if(deciduous_yn.equals("R")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,failure_remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ? ,CANCELLED_BY = ?,CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?  AND MIXED_DENT_DECIDUOUS_YN = 'R'");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							else if(deciduous_yn.equals("D")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,failure_remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?,CANCELLED_BY = ? ,CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND MIXED_DENT_DECIDUOUS_YN = 'D'");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							else if(supernumerary_yn.equals("Y")){
								
								if(condition_type.equals("SUPRTH")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = 'N'");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();
								}
								else if(condition_type.equals("EXFOLTH")){
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = NULL");
									pstmt.setString(1,facility_id);
									pstmt.setString(2,patient_id);
									pstmt.setString(3,chart_num);
									pstmt.setString(4,tooth_no);
									pstmt.executeUpdate();
								}

								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?, failure_remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND SUPERNUMERARY_YN = 'Y' AND TOOTH_NO = ?");
								tooth_no_or_chart_line_num = "TOOTH_NO";
							}
							else if(supernumerary_yn.equals("Y")){
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,failure_remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? , CANCEL_REASON = ? , CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?  AND SUPERNUMERARY_YN = 'Y'");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							else{
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', REMARKS = ?,TREATMENTS_OUTCOME = ?,failure_remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? , CANCEL_REASON = ? , CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
								tooth_no_or_chart_line_num = "CHART_LINE_NUM";
							}
							if(thrng_nos_ref.indexOf(",") != -1){
								tooth_range_arr = thrng_nos_ref.split(",");
								for(int m=0;m<tooth_range_arr.length;m++){

									if(supernumerary_yn.equals("Y") && condition_type.equals("SUPRTH")){
										pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='EXFOLTH' AND SUPERNUMERARY_YN = 'N'");
										pstmt2.setString(1,facility_id);
										pstmt2.setString(2,patient_id);
										pstmt2.setString(3,chart_num);
										pstmt2.setString(4,tooth_range_arr[m]);
										pstmt2.executeUpdate();
									}

									pstmt.setString(1,mark_error_status);
									pstmt.setString(2,remarks);
									pstmt.setString(3,outcome);
									pstmt.setString(4,failure_remarks);
									pstmt.setString(5,login_user);
									pstmt.setString(6,client_ip_address);
									pstmt.setString(7,facility_id);
									pstmt.setString(8,reasonforcancel);
									pstmt.setString(9,login_user);
									pstmt.setString(10,facility_id);
									pstmt.setString(11,patient_id);
									pstmt.setString(12,chart_num);
									if(tooth_no_or_chart_line_num.equals("TOOTH_NO")){
										pstmt.setString(13,tooth_range_arr[m]);
									}
									else{
										pstmt.setString(14,chart_line_num);
										
									}
								
									/*
									if((deciduous_yn.equals("R") || deciduous_yn.equals("D"))&& (condition_type.equals("DECITH") || condition_type.equals("RTDESTH")) || (supernumerary_yn.equals("Y") && condition_type.equals("SUPRTH"))){
										pstmt.setString(12,tooth_range_arr[m]);
									}
									else{
										pstmt.setString(12,chart_line_num);
									}
									*/
									
									//pstmt.setString(9,tooth_range_arr[m]);
									//pstmt.setString(10,thrng_nos_ref);
									flag = pstmt.executeUpdate();
									//To delete the record for UNERTH/PARERTH which is inserted forcibaly when RTDESTH is recorded
									if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && condition_type.equals("RTDESTH")){
										pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");

										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,condition_code);
										pstmt.setString(5,tooth_range_arr[m]);
										pstmt.setString(6,chart_line_num);
										flag_delete = pstmt.executeUpdate();
									}
									else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && condition_type.equals("RTDESTH")){
										pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'PARERTH' AND TOOTH_NO = ? AND STATUS = 'Z' AND CHART_LINE_NUM > ?");

										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,condition_code);
										pstmt.setString(5,tooth_range_arr[m]);
										pstmt.setString(6,chart_line_num);
										flag_delete = pstmt.executeUpdate();
									}
									else if(mixed_dentition_YN.equals("N") && permanent_deciduous_flag.equals("P") && condition_type.equals("RTDESTH")){
										pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CONDITION_CODE = ? AND CONDITION_TYPE = 'UNERTH' AND TOOTH_NO = ?  AND STATUS = 'Z' AND CHART_LINE_NUM > ?");

										pstmt.setString(1,facility_id);
										pstmt.setString(2,patient_id);
										pstmt.setString(3,chart_num);
										pstmt.setString(4,condition_code);
										pstmt.setString(5,tooth_range_arr[m]);
										pstmt.setString(6,chart_line_num);
										flag_delete = pstmt.executeUpdate();
									}
									
									if(pstmt2 != null) pstmt2.close();

									if(condition_type.equals("IMPACTN")){
										//pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE='UNERTH' ");
										pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'PARERTH' ),'PARERTH','','UNERTH')");
										pstmt2.setString(1,facility_id);
										pstmt2.setString(2,patient_id);
										pstmt2.setString(3,chart_num);
										pstmt2.setString(4,tooth_range_arr[m]);
										pstmt2.executeUpdate();
									}
									else if(condition_type.equals("PARERTH")){
										//pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','IMPACTN') ");
										pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = DECODE((SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'IMPACTN' ),'IMPACTN','IMPACTN','UNERTH')");
										pstmt2.setString(1,facility_id);
										pstmt2.setString(2,patient_id);
										pstmt2.setString(3,chart_num);
										pstmt2.setString(4,tooth_range_arr[m]);
										pstmt2.executeUpdate();
									}
									else if(condition_type.equals("ERUPTH")){
										String update_parer_yn = "N";
										String update_uner_yn = "N";
										String update_impact_yn = "N";
										pstmt1 = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'");
										pstmt1.setString(1,facility_id);
										pstmt1.setString(2,patient_id);
										pstmt1.setString(3,chart_num);
										pstmt1.setString(4,tooth_range_arr[m]);
										rst1 = pstmt1.executeQuery();

										while(rst1.next()){
											if(rst1.getString("CONDITION_TYPE").equals("PARERTH")){
												update_parer_yn = "Y";
											}
											else if(rst1.getString("CONDITION_TYPE").equals("UNERTH")){
												update_uner_yn = "Y";
											}
											else if(rst1.getString("CONDITION_TYPE").equals("IMPACTN")){
												update_impact_yn = "Y";
											}
										}

										if(update_parer_yn.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE ='PARERTH'");
											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											pstmt2.executeUpdate();
										}
										if(update_uner_yn.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'UNERTH'");
											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											pstmt2.executeUpdate();
										}
										if(update_impact_yn.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'IMPACTN'");
											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											pstmt2.executeUpdate();
										}
									}
									else if(condition_type.equals("EXFOLTH")){
										String condition_type_update = "";
										String mixed_dent_deciduous_yn_update = "";
										String supernumerary_yn_update = "";

										if(pstmt1 != null) pstmt1.close();						
										if(rst1 != null) rst1.close();						

										pstmt1 = con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND CHART_LINE_NUM = ?");
										
										pstmt1.setString(1,facility_id);
										pstmt1.setString(2,patient_id);
										pstmt1.setString(3,chart_num);
										pstmt1.setString(4,tooth_range_arr[m]);
										pstmt1.setString(5,chart_line_num);
										rst1 = pstmt1.executeQuery();

										while(rst1.next()){
											mixed_dent_deciduous_yn_update = checkForNull(rst1.getString("MIXED_DENT_DECIDUOUS_YN"));
											supernumerary_yn_update = checkForNull(rst1.getString("SUPERNUMERARY_YN"));

											if(mixed_dent_deciduous_yn_update.equals("R")){
												condition_type_update = "RTDESTH";
												
											}
											else if(mixed_dent_deciduous_yn_update.equals("D")){
												condition_type_update = "DECITH";
												
											}
											else if(supernumerary_yn_update.equals("Y")){
												condition_type_update = "SUPRTH";
												
											}
											
										}

										if(condition_type_update != "" && condition_type_update != null){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ?");

											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											pstmt2.setString(5,condition_type_update);
											pstmt2.executeUpdate();
										}

										if(pstmt != null) pstmt.close();
										if(supernumerary_yn_update.equals("Y")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND SUPERNUMERARY_YN = 'Y'"); 
											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											//pstmt.executeUpdate();
											pstmt2.executeUpdate();//added by Sridevi Joshi on 19/11/2008*/
										}
										else if(mixed_dent_deciduous_yn_update.equals("R")){
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											//pstmt.executeUpdate();
											pstmt2.executeUpdate();//added by Sridevi Joshi on 19/11/2008*/
										}
										else{
											pstmt2=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'N', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','SUPRTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND NVL(STATUS, 'X') != 'Z'"); 
											pstmt2.setString(1,facility_id);
											pstmt2.setString(2,patient_id);
											pstmt2.setString(3,chart_num);
											pstmt2.setString(4,tooth_range_arr[m]);
											//pstmt.executeUpdate();
											pstmt2.executeUpdate();//added by Sridevi Joshi on 19/11/2008*/
										}
									}
									if(pstmt1 != null) pstmt1.close(); //Common-ICN-0044
									if(pstmt2 != null) pstmt2.close(); //Common-ICN-0044
									int chart_line_num_int = Integer.parseInt(chart_line_num);
									chart_line_num_int ++;
									chart_line_num = ""+chart_line_num_int;
								}
								
								MessageManager mm=new MessageManager();
								if(flag!=0){
									con.commit();
									final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }else{
									con.rollback();
									final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }
								 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
							}
						}
						else{
							ArrayList flag_arr= new ArrayList();
							if(thrng_nos_ref.indexOf(",") != -1){
								tooth_range_arr = thrng_nos_ref.split(",");
								for(int m=0;m<tooth_range_arr.length;m++){
									if(pstmt != null) pstmt.close();
									pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', TREATMENTS_OUTCOME = ?,failure_remarks=?, REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?, CANCELLED_BY = ? , CANCELLED_DATE = SYSDATE  WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?  ");
									
									pstmt.setString(1,mark_error_status);
									pstmt.setString(2,outcome);
									pstmt.setString(3,failure_remarks);
									pstmt.setString(4,remarks);
									pstmt.setString(5,login_user);
									pstmt.setString(6,client_ip_address);
									pstmt.setString(7,facility_id);
									pstmt.setString(8,reasonforcancel);
									pstmt.setString(9,login_user);
									pstmt.setString(10,facility_id);
									pstmt.setString(11,patient_id);
									pstmt.setString(12,chart_num);
									pstmt.setString(13,chart_line_num);
									
									flag = pstmt.executeUpdate();
									flag_arr.add(""+flag);

									int chart_line_num_int = Integer.parseInt(chart_line_num);
									chart_line_num_int ++;
									chart_line_num = ""+chart_line_num_int;

									if(pstmt != null) pstmt.close(); //Common-ICN-0044
								}

								MessageManager mm=new MessageManager();
								if(!flag_arr.contains("0")){
									con.commit();
									final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }else{
									con.rollback();
									final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
									msg = ((String) mesg.get("message"));
									mesg.clear();	//Common-ICN-0044
								 }
								 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
							}
							flag_arr.clear();	//Common-ICN-0044
						}
					}
				}
				//else if(site_type.equals("ARCH") || site_type.equals("QUAD")|| site_type.equals("MAXFS")|| site_type.equals("CROWN")|| site_type.equals("ROOT") || site_type.equals("MOUTH")){
				else{
					//commented by parul
					//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE  WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
					
					if(oh_chart_level.equals("E")){
						if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
						pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', TREATMENTS_OUTCOME = ?, failure_remarks=?,REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE  WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");
						pstmt.setString(1,mark_error_status);
						pstmt.setString(2,outcome);
						pstmt.setString(3,failure_remarks);
						pstmt.setString(4,remarks);
						pstmt.setString(5,login_user);
						pstmt.setString(6,client_ip_address);
						pstmt.setString(7,facility_id);
						pstmt.setString(8,reasonforcancel);
						pstmt.setString(9,login_user);
						pstmt.setString(10,patient_id);
						pstmt.setString(11,chart_num);
						pstmt.setString(12,chart_line_num);	
						flag = pstmt.executeUpdate();
					}
					else{
						pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', TREATMENTS_OUTCOME = ?,failure_remarks=?,REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE  WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=?");

						pstmt.setString(1,mark_error_status);
						pstmt.setString(2,outcome);
						pstmt.setString(3,failure_remarks);
						pstmt.setString(4,remarks);
						pstmt.setString(5,login_user);
						pstmt.setString(6,client_ip_address);
						pstmt.setString(7,facility_id);
						pstmt.setString(8,reasonforcancel);
						pstmt.setString(9,login_user);
						pstmt.setString(10,facility_id);
						pstmt.setString(11,patient_id);
						pstmt.setString(12,chart_num);
						pstmt.setString(13,chart_line_num);
	
						flag = pstmt.executeUpdate();
					}
					MessageManager mm=new MessageManager();
					if(flag!=0){
						con.commit();
						final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
						msg = ((String) mesg.get("message"));
						mesg.clear();	//Common-ICN-0044
					 }else{
						con.rollback();
						final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
						msg = ((String) mesg.get("message"));
						mesg.clear();	//Common-ICN-0044
					 }
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
				}
	}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in OHDentalChartAmendServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("OHDentalChartAmendServlet :Caught Exception during rollback"+e_1);
				}
			    System.err.println("Err Msg in OHDentalChartAmendServlet"+e.getMessage());
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}finally{
		try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(rst1!=null) rst1.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();	//Added Against Common-ICN-0031
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }


