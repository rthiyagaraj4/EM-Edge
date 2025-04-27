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
import eOH.*;


public class OHDentalChartTrmtServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

	public ArrayList getOrderCatalogDetails(HttpServletRequest request, HttpServletResponse response, String treatment_code) throws ServletException, java.io.IOException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst			= null;
		ArrayList catalog_details = new ArrayList();
		try{
			con = ConnectionManager.getConnection(request);
			pstmt=con.prepareStatement("SELECT A.ORDER_CATALOG_CODE, A.ORDER_TYPE_CODE FROM OR_ORDER_CATALOG A, OH_TREATMENT B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND B.TRMT_CODE=?");
			pstmt.setString(1,treatment_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				catalog_details.add(rst.getString("ORDER_CATALOG_CODE"));
				catalog_details.add(rst.getString("ORDER_TYPE_CODE"));
			}

		}catch(Exception e){
			System.err.println("OHDentalChartTrmtServlet: Err Msg in OHDentalChartTrmtServlet in getOrderCatalogDetails "+e.getMessage());
			String msg = e.toString();
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
		}finally{
			try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		  }
		return catalog_details;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		eOH.MasterXMLParse masterXMLParse;
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
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_task_insert = null;
		PreparedStatement pstmt_task_select = null;
		//Added by Sharon Crasta on 3/24/2010 for IN019999
		PreparedStatement pstmt_order_catalog_select = null;
		ResultSet rst_order_catalog			= null;
		//End
		ResultSet rst			= null;
		String sqlInsert = "";
		String sqlUpdate ="";
		int flag=0;
		int flag1=0;
		int flag_insert=0;
		String msg="";
		int index = 1;
		int index_insert = 1;
		String commit_flag = "N";
		String commit_flag1 = "N";
		String trace="0";
		String cusp_arr[] = null;//parul 20/08/2009 for 0483
		String cusp_no = "";///parul 20/08/2009 for 0483

		try{
				con = ConnectionManager.getConnection(req);
				
				String first_chart_line_num = "";
				String tooth_range_nos = "";
				String tooth_no = "";
				String arch = "";
				String quadrant = "";
				String surface_code = "";
				String treatment_condition = "";
				String treatment_int_ext = "";
				String tooth_range_nos_arr[] = null;
				String tooth_range_count = "";
				String task_episode_id = "";
				
               //added by parul on 19/09/2009 for CRf 701
				String intraoral_extraoral = "";
				String organ_code = "";
				String sub_organ_code = "";
				String deciduous_yn = "";
				String supernuerary_yn = "";
				String tooth_string = "";
				/* String supernumerary_yn ="";//Added by Sridevi Joshi on 12/14/2009 for SUPRTH chnages
				int super_key_val = 0;//Added by Sridevi Joshi on 1/24/2010 for SUPRTH chnages(IN010894) */	//Commented Against Common-ICN-0031
				
				String super_tooth_ref = "";//Added by Sridevi Joshi on 12/14/2009 for SUPRTH chnages
				String super_tooth_count = "";//Added by Sridevi Joshi on 12/14/2009 for SUPRTH chnages
				String super_tooth_no = "";//Added by Sridevi Joshi on 12/14/2009 for SUPRTH chnages
				String retained_tooth_no = "";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
				String mapped_tooth_no = "";//Added by Sridevi Joshi on 12/21/2009 for SUPRTH chnages(IN010894)
				String ns_tooth_no = "";//Added by Sridevi Joshi on 12/21/2009 for SUPRTH chnages(IN010894)
				String DB_condition_type = "";//Added by Sridevi Joshi on 1/18/2010 for SUPRTH chnages(IN010894)
				String exfolth_count = "";//Added by Sridevi Joshi on 1/18/2010 for SUPRTH chnages(IN010894)
				String super_key_num = "";//Added by Sridevi Joshi on 1/21/2010 for SUPRTH chnages(IN010894)
				
				//int suprth_count = 0;//Added by Sridevi Joshi on 1/24/2010 for SUPRTH chnages(IN010894)

				String task_code = ""; //Added by Sharon Crasta on 3/24/2010 for IN019999

				// Variables used for Billing Function
				/* String bl_episode_id = checkForNull(req.getParameter("bl_episode_id"));
				String bl_visit_id = checkForNull(req.getParameter("bl_visit_id"));
				String bl_encounter_id = checkForNull(req.getParameter("bl_encounter_id"));
				String bl_service_date = checkForNull(req.getParameter("bl_service_date"));
				String bl_pract_staff_id = checkForNull(req.getParameter("bl_pract_staff_id"));
				String bl_serv_panel_ind = checkForNull(req.getParameter("bl_serv_panel_ind"));
				String bl_serv_panel_code = checkForNull(req.getParameter("bl_serv_panel_code"));
				String bl_panel_str = checkForNull(req.getParameter("bl_panel_str"));
				String bl_total_payable = checkForNull(req.getParameter("bl_total_payable"));
				String bl_patient_payable = checkForNull(req.getParameter("bl_patient_payable"));
				String bl_preapp_yn = checkForNull(req.getParameter("bl_preapp_yn"));
				String bl_patient_paid_amt = checkForNull(req.getParameter("bl_patient_paid_amt"));
				String bl_charged_yn = checkForNull(req.getParameter("bl_charged_yn"));
				String bl_quantity = checkForNull(req.getParameter("bl_quantity"));
				String bl_total_payable_for_trmt = checkForNull(req.getParameter("bl_total_payable_for_trmt")); */	//Commented Against Common-ICN-0031
				String mixed_dentition_YN = checkForNull(req.getParameter("mixed_dentition_YN"));
				String permanent_deciduous_flag = checkForNull(req.getParameter("permanent_deciduous_flag"));
				String tooth_numbering_system = checkForNull(req.getParameter("tooth_numbering_system"));
				
				String patient_id=checkForNull(req.getParameter("patient_id"));
				String practitioner_id=checkForNull(req.getParameter("ca_practitioner_id"));
				String episode_id=checkForNull(req.getParameter("episode_id"));
				String visit_id=checkForNull(req.getParameter("visit_id"));
				String episode_type=checkForNull(req.getParameter("episode_type"));
				String source_code=checkForNull(req.getParameter("location_code"));
				String source_type=checkForNull(req.getParameter("location_type"));
				String encounter_id=checkForNull(req.getParameter("encounter_id"));
				String patient_class = checkForNull(req.getParameter("patient_class"));

				String chart_num = checkForNull(req.getParameter("chart_num"));
				String chart_line_num="1";
				String tab_name = checkForNull(req.getParameter("tab_name"));
				String show_new_active_yn = checkForNull(req.getParameter( "show_new_active_yn" )) ;
				String header_tab = checkForNull(req.getParameter( "header_tab" )) ;
				//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
				//String dentist_comments = checkForNull(req.getParameter( "dentist_comments" )) ;	//Commented Against Common-ICN-0031
				String ref_tooth_no = checkForNull(req.getParameter( "ref_tooth_no" )) ;

				//Added by sharon Crasta on 3/14/2009 for Facility/Enterprise Charts
				String oh_chart_level = checkForNull(req.getParameter( "oh_chart_level" )) ;
				if(oh_chart_level.equals("")){
					oh_chart_level = "F";
				}

				if(header_tab.equals("C")){
					treatment_condition = "C";
				}
				else{
					treatment_condition = "T";
				}

				if(tab_name.equals("ET")){
					treatment_int_ext = "E";
					treatment_condition = "T";
				}
				else{
					treatment_int_ext = "I";
				}

				String trmt_category_type=checkForNull(req.getParameter("category"));
				String trmt_category_code = checkForNull(req.getParameter("cat_code"));
				String trmt_code = checkForNull(req.getParameter("treatment"));
				String condition_type = checkForNull(req.getParameter("condition_type"));
				String condition_code = checkForNull(req.getParameter("dental_condition"));
				String treatment_condition_date = checkForNull(req.getParameter("oh_performed_date"));
			//	String surface_code = checkForNull(req.getParameter("oh_surface"));
				String cusp_tip = checkForNull(req.getParameter("oh_cusp_tip"));
				String location = checkForNull(req.getParameter("oh_location"));
				String order_id = checkForNull(req.getParameter("order_id"));
				String status = checkForNull(req.getParameter("oh_status"));
				String chart_hdr_insert_yn = checkForNull(req.getParameter("chart_hdr_insert_yn"));
				String clinical_group_code = checkForNull(req.getParameter("clinical_group_code"));
				//String remarks = java.net.URLDecoder.decode(checkForNull(req.getParameter("remarks")),"UTF-8");
				String remarks = checkForNull(req.getParameter("remarks"));
				String outcome = checkForNull(req.getParameter("oh_outcome"));
				String complication = checkForNull(req.getParameter("oh_complication"));
				String site_type = checkForNull(req.getParameter("site"));
				String RD_Normal_yn = checkForNull(req.getParameter("RD_Normal_yn")); //Added on 19/12/2008 for MD-D case by Sridevi Joshi
				String status_code = status;
				String hide_image_yn = "N";
				String failure_remarks = checkForNull(req.getParameter( "oh_failure" )) ;

				if (outcome.equals("") || outcome.equals("null") || outcome.equals(null)){//added by parul on 09/03/2010 for CRF-477
					outcome=checkForNull(req.getParameter("outcome_new"));
				}

				//added by parul on 21/01/2010 for CRF-442
				String surface_arr[] = null;
				String surface_no = "";
				String multiple_surfaces_applicable ="N";//end
				//String cusp_tip_code_ref ="";//end	//Commented Against Common-ICN-0031
				String sub_parts = "";

				
				String performed_In_Ot=checkForNull(req.getParameter("performed_In_OT"));  //Added on 10/9/2009 for CRF-707 by Yadav

				if(site_type.equals("MAXFS")){
					organ_code=checkForNull(req.getParameter("oh_surface"));
					sub_organ_code=checkForNull(req.getParameter("oh_sub_parts"));
					// sub_organ_code=checkForNull(req.getParameter("sub_parts"));
					if(sub_organ_code.equals("")){ //Added by Sridevi Joshi on 4/6/2010 for IN020499..sub_organ_code was coming as null for tooth range in case of maxilla bcoz of which it was not entering in to THRNG block
						sub_organ_code=checkForNull(req.getParameter("sub_parts"));
					}
				}else{
		            surface_code = checkForNull(req.getParameter("oh_surface"));
					if(surface_code.equals("")){
						surface_code = checkForNull(req.getParameter("oh_surface_hid"));//Added this by Sridevi Joshi on 8/20/2010 for IN023363...surface is disabled if it is for AllSurfaces in case of Crown. as disabled parameters wont be parsed by form take some hidden variable and assign the value
					 }
				}
				
				if(site_type.equals("ARCH")){
					arch =checkForNull(req.getParameter("area"));
				}
				else if(site_type.equals("QUAD")){
					quadrant = checkForNull(req.getParameter("area"));
				}
				else if(site_type.equals("THRNG")){
					tooth_range_nos = checkForNull(req.getParameter("thrng_nos_ref"));
					tooth_range_nos_arr = tooth_range_nos.split(",");
				}else if(site_type.equals("MAXFS")){

					 intraoral_extraoral = checkForNull(req.getParameter("area"));//added by parul for CRF 701 on 23/09/2009
					
					if(sub_organ_code.equals("THAB") || sub_organ_code.equals("THGM")  || sub_organ_code.equals("THAG") ||sub_organ_code.equals("THGAM") ||sub_organ_code.equals("THMF")){//THAB,THGM,THAG,THGAM,THMF

							sub_parts = checkForNull(req.getParameter("oh_selected_sub_parts"));//added by Sridevi Joshi on 2/8/2010 for  IN010894
							if(sub_parts.indexOf("s") != -1){
								super_tooth_ref = sub_parts.substring(sub_parts.indexOf("s"));//added by Sridevi Joshi on 2/8/2010 for  IN010894
							}
							tooth_no = checkForNull(req.getParameter("oh_selected_sub_parts"));//added by parul for CRF 701 on 23/09/2009
							if((permanent_deciduous_flag.equals("P")|| permanent_deciduous_flag.equals("D")) && mixed_dentition_YN.equals("N")){
								if(tooth_no.indexOf("s") != -1){
									//tooth_no=tooth_no.replace("s","");
									tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
									supernuerary_yn="Y";
								}else if (tooth_no.indexOf("r") != -1){
									tooth_no=tooth_no.replace("r","");
									deciduous_yn = "R";
								}
						}else if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("Y")){
							if(tooth_no.indexOf("s") != -1){
									//tooth_no=tooth_no.replace("s","");
									tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
									supernuerary_yn="Y";
								}else if (tooth_no.indexOf("r") != -1){
									tooth_no=tooth_no.replace("r","");
									deciduous_yn = "R";
								}else if (tooth_no.indexOf("d") != -1)
								{
									tooth_no=tooth_no.replace("d","");
									deciduous_yn = "D";
								}
						}else if (permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
							if(tooth_no.indexOf("s") != -1){
									//tooth_no=tooth_no.replace("s","");
									tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
									supernuerary_yn="Y";
									//deciduous_yn = "M";
								}else if (tooth_no.indexOf("r") !=1){
									tooth_no=tooth_no.replace("r","");
									deciduous_yn = "R";
								}else if (tooth_no.indexOf("s") == -1){
										deciduous_yn = "";
										supernuerary_yn="";
								}
						
						}

					}else if (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") || sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF")){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
							tooth_range_nos = checkForNull(req.getParameter("thrng_nos_ref"));
							tooth_range_nos_arr = tooth_range_nos.split(",");
							for(int i=0;i<tooth_range_nos_arr.length;i++){
								tooth_string=tooth_range_nos_arr[i];
								if(tooth_string.indexOf("d") != -1){
									tooth_string=tooth_string.replace("d","");
									deciduous_yn="D";
									tooth_range_nos_arr[i] = tooth_string;
								}
							}

					 }
				}
				else{
					tooth_no = checkForNull(req.getParameter("area"));
				}				

				if(RD_Normal_yn.equals("D")){
					deciduous_yn = "D";
				}
				else if(RD_Normal_yn.equals("RD")){
					deciduous_yn = "R";
				}
				else if(RD_Normal_yn.equals("MR")){
					deciduous_yn = "M";
				}
				else if(RD_Normal_yn.equals("MRP")){
					deciduous_yn = "M";
				}
				else if(RD_Normal_yn.equals("S")){
					supernuerary_yn = "Y";
				}
				else if(RD_Normal_yn.equals("MRS")){
					supernuerary_yn = "Y";
					deciduous_yn = "M";
				}else if(RD_Normal_yn.equals("DR")){//added DR','DRS' by parul for IN016816 on 02/12/2009
					deciduous_yn = "D";
				}
				else if(RD_Normal_yn.equals("DRS")){
					deciduous_yn = "D";
					supernuerary_yn = "Y";
				}
				else{
					if(!site_type.equals("MAXFS")){
						deciduous_yn = "";
						supernuerary_yn = "";
					}
				}

				/* Block Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages*/
				if(super_tooth_ref == ""){
					super_tooth_ref = checkForNull(req.getParameter("super_tooth_ref"));//this is to check which super tooth is selected(1st or 2nd) 
				}
				if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){
					super_tooth_count = super_tooth_ref.substring(1);
				}
				/*if(super_tooth_ref.equals("s1")){
					super_tooth_count = "1";
				}else if(super_tooth_ref.equals("s2")){
					super_tooth_count = "2";
				}*/
				if(!super_tooth_count.equals("")){
					supernuerary_yn = "Y"; 
					super_tooth_no = tooth_no+super_tooth_count;//This is to get the value for new column super_tooth_no(Ex:131 for tooth 13 and super tooth 1)
				}
				/*if(oh_chart_level.equals("E")){
					pstmt=con.prepareStatement("SELECT COUNT(*) RESULT_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH'");
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,tooth_no);
					rst = pstmt.executeQuery();
				}
				else{
					pstmt=con.prepareStatement("SELECT COUNT(*) RESULT_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no);
					rst = pstmt.executeQuery();
				}

				while(rst!= null && rst.next()){
					suprth_count = Integer.parseInt(checkForNull(rst.getString("RESULT_COUNT")));
				}

				if(suprth_count == 0 && condition_type.equals("SUPRTH")){
					super_key_val = 1;
				}
				else if(suprth_count >= 1 && condition_type.equals("SUPRTH")){
					super_key_val = ++suprth_count;
				}

				if(super_key_val != 0){
					super_key_num = "s"+super_key_val;
				}*/

				if(!super_tooth_no.equals("")){
					super_key_num = super_tooth_ref;
				}

				if(oh_chart_level.equals("E")){
					pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND NVL(STATUS,'X') != 'E'");
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,tooth_no);
					rst = pstmt.executeQuery();
				}
				else{
					pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND NVL(STATUS,'X') != 'E'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no);
					rst = pstmt.executeQuery();
				}

				while(rst!= null && rst.next()){
					exfolth_count = checkForNull(rst.getString("RECORD_COUNT"));
				}

			
				if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
					if (ref_tooth_no.equals("") || ref_tooth_no.equals(null) || ref_tooth_no.equals("null")){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
					   deciduous_yn = "M";
					}
				}

				/* Ends Here Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages*/

				/* Block Added by Sridevi Joshi on 12/4/2009 for RTDESTH chnages*/
				
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					pstmt=con.prepareStatement("SELECT MAPPED_TOOTH_NO FROM OH_TOOTH_LANG_VW WHERE TOOTH_NO = ?");
					pstmt.setString(1,tooth_no);
					rst = pstmt.executeQuery();
				
					while(rst!= null && rst.next()){
						mapped_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
					}

					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					pstmt=con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,mapped_tooth_no);
					rst = pstmt.executeQuery();
				
					while(rst!= null && rst.next()){
						ns_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
					}

					if(super_tooth_ref.equals("RD") && !(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D"))){
						retained_tooth_no = mapped_tooth_no;
					}

					if(rst != null) rst.close(); //Added Against Common-ICN-0031
					pstmt=con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE ='RTDESTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no);
					rst = pstmt.executeQuery();
				
					while(rst!= null && rst.next()){
						DB_condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					}
					
					//if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && !super_tooth_ref.equals("s1") && !super_tooth_ref.equals("s2") && RD_Normal_yn.equals("NR")){
					//if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && !super_tooth_ref.equals("s1") && !super_tooth_ref.equals("s2") && DB_condition_type.equals("RTDESTH")){
					if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && (super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")) && DB_condition_type.equals("RTDESTH")){
						//retained_tooth_no = ns_tooth_no;
						retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/8/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
					}
						
				
				/* Ends Here Added by Sridevi Joshi on 12/4/2009 for RTDESTH chnages*/

				if(rst != null) rst.close(); //Added Against Common-ICN-0031
				if(!status.equals("E")){ // For other than MarkError Cases
					// Get the Order Status Code for the oh_status if its not 'E'
					pstmt=con.prepareStatement("SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?");
					pstmt.setString(1,status);
					rst = pstmt.executeQuery();
					while(rst.next()){
						status_code=rst.getString("ORDER_STATUS_CODE");
					}
				}

				 //added by parul on 21/01/2010 for CRF-442
				if (!surface_code.equals(null)){  
					surface_no = checkForNull(req.getParameter("surface_ref"));
					surface_arr=surface_no.split(",");
					
				 }

				if (!cusp_tip.equals(null)){  //parul 130908
					cusp_no = checkForNull(req.getParameter("cusptip_ref"));
					cusp_arr=cusp_no.split(",");					
				 }
				 if (surface_arr.length>1){
					 multiple_surfaces_applicable="Y";
				 }
				 
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
			
				if((show_new_active_yn.equals("Y") || chart_num.equals("1")) && chart_hdr_insert_yn.equals("Y")){
					// for a New Chart.
					/*
					Case 1. New chart getting inserted for the 1st time
					Case 2. New chart getting inserted for a Mixed-Dentition Case. Update the old with chart_status as 'C' and insert a new chart.
					*/

					if(pstmt != null) pstmt.close();
					if(show_new_active_yn.equals("Y")){ // Case 2
						sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE PATIENT_ID = ? AND CHART_STATUS='A'";
						pstmt=con.prepareStatement(sqlUpdate);
						pstmt.setString(1,login_user);
						pstmt.setString(2,patient_id);
						flag = pstmt.executeUpdate();
					}
				
					String chart_status = "A";
					String chart_type = checkForNull(req.getParameter("chart_type"));

					sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,CHART_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_type);
					pstmt.setString(5,clinical_group_code);
					pstmt.setString(6,chart_status);

					pstmt.setString(7,login_user);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user);
					pstmt.setString(11,client_ip_address); 
					pstmt.setString(12,facility_id);
					
					flag1 = pstmt.executeUpdate();
				}

			
				//Added by Sharon Crasta on 3/14/2009 for Facility/Enterprise Charts
				else if((show_new_active_yn.equals("Y") || (!chart_num.equals("1"))) && chart_hdr_insert_yn.equals("Y")){
					// for a New Chart.
					/*
					Case 1. New chart getting inserted for the 1st time
					Case 2. New chart getting inserted for a Mixed-Dentition Case. Update the old with chart_status as 'C' and insert a new chart.
					*/
					if(pstmt != null) pstmt.close();
					if(show_new_active_yn.equals("Y")){ // Case 2
						sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE PATIENT_ID = ? AND CHART_STATUS='A'";
						pstmt=con.prepareStatement(sqlUpdate);
						pstmt.setString(1,login_user);
						pstmt.setString(2,patient_id);
						flag = pstmt.executeUpdate();
					}
				
					String chart_status = "A";
					String chart_type = checkForNull(req.getParameter("chart_type"));
					
					sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,CHART_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_type);
					pstmt.setString(5,clinical_group_code);
					pstmt.setString(6,chart_status);

					pstmt.setString(7,login_user);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user);
					pstmt.setString(11,client_ip_address); 
					pstmt.setString(12,facility_id);
					flag1 = pstmt.executeUpdate();
				}

				if(pstmt != null) pstmt.close();

				/* 
				1. chart_num.equals("1") && chart_hdr_insert_yn.equals("N") for new chart and without refresh case
				2. !chart_num.equals("1") for existing chart
				3. show_new_active_yn.equals("N"): For Mixed Dentition Copy case
				*/
	
			if(site_type.equals("THRNG") || (site_type.equals("MAXFS") && (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") ||  sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF")))){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
					// Get the maximum chart_line_num for that chart_num
					pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=?");
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					rst = pstmt.executeQuery();
					while(rst.next()){
						chart_line_num=checkForNull(rst.getString("CHART_LINE_NUM"),"1");
					}

					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();
					ArrayList flag_arr= new ArrayList();
					chart_line_num=chart_line_num==null?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("null")?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("0")?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("")?"1":chart_line_num;
					int chart_line_num_int = Integer.parseInt(chart_line_num);

					//initial chart_line_num
					first_chart_line_num = chart_line_num_int+"";
					int chart_line_num_int_for_range_update = Integer.parseInt(chart_line_num);
					StringBuffer tooth_range_chart_line_nums = new StringBuffer();
					StringBuffer tooth_range_col_str = new StringBuffer();
					tooth_range_count = tooth_range_nos_arr.length+"";

					if(status.equals("60") || status.equals("85")){
						chart_line_num_int = Integer.parseInt(checkForNull(req.getParameter("chart_line_num")));
					}

						/* StringBuffer cusp_chart_line_nums= new StringBuffer ();
						StringBuffer surface_chart_line_nums= new StringBuffer (); */	//Commented Against Common-ICN-0031
						
						StringBuffer cusp_range= new StringBuffer ();
						 for (int k=0;k<cusp_arr.length;k++){
								 if (k>0){
									 cusp_range.append(",");
								}
							cusp_range.append(cusp_arr[k]);
						 }
						
						StringBuffer surface_range= new StringBuffer ();
						 for (int k=0;k<surface_arr.length;k++){
								 if (k>0){
									 surface_range.append(",");
								}
								surface_range.append(surface_arr[k]);
						 }

						

					for(int i=0;i<tooth_range_nos_arr.length;i++){
						if(status.equals("60") || status.equals("85")){
							if(rst!=null) rst.close();
							if(pstmt!=null) pstmt.close();
							chart_line_num =  chart_line_num_int+"";
							

							if(rst != null) rst.close();
							if(pstmt!=null)pstmt.close();

							sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_DTL SET TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?, COMPLICATION_CODE=?, MODIFIED_BY_ID = ?, COPIED_YN = 'N', MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ?";
							pstmt=con.prepareStatement(sqlUpdate);
							pstmt.setString(1,outcome);
							pstmt.setString(2,failure_remarks);
							pstmt.setString(3,complication);
							pstmt.setString(4,login_user);
							pstmt.setString(5,client_ip_address);
							pstmt.setString(6,facility_id);
							pstmt.setString(7,patient_id);
							pstmt.setString(8,chart_num);
							pstmt.setString(9,chart_line_num);
							flag = pstmt.executeUpdate();
							if(flag != 0){
								commit_flag="Y";
							}else{
								commit_flag="N";
							}
						}
						else{
							chart_line_num=chart_line_num_int+"";
							if(i>0){
								tooth_range_col_str.append(",");
								tooth_range_chart_line_nums.append(",");
							}
							tooth_range_col_str.append(chart_line_num);
							tooth_range_col_str.append("$$");
							tooth_range_col_str.append(tooth_range_nos_arr[i]);
							tooth_range_chart_line_nums.append(chart_line_num);
							
							if(trmt_category_type.equals("BRIDGE") && (i>0 && i<tooth_range_nos_arr.length-1)){
								hide_image_yn = "Y";
							}
							else{
								hide_image_yn = "N";
							}
							
						 //for (int k=0;k<surface_arr.length;k++){//parul on 070109 for multiple surface
							sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,HIDE_IMAGE_YN,SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

							pstmt=con.prepareStatement(sqlInsert);
							chart_line_num=chart_line_num_int+"";//parul on 070109 for multiple surface
							index = 1;
							pstmt.setString(index++,facility_id);			//1
							pstmt.setString(index++,patient_id);			//2
							pstmt.setString(index++,chart_num);				//3
							pstmt.setString(index++,chart_line_num);		//4
							pstmt.setString(index++,encounter_id);			//5
							pstmt.setString(index++,patient_class);			//6
							pstmt.setString(index++,treatment_condition);	//7
							pstmt.setString(index++,trmt_category_type);	//8
							pstmt.setString(index++,trmt_category_code);	//9
							pstmt.setString(index++,trmt_code);				//10
							pstmt.setString(index++,condition_type);		//11
							pstmt.setString(index++,condition_code);		//12
							pstmt.setString(index++,treatment_int_ext);		//13
							pstmt.setString(index++,tab_name);				//14
							pstmt.setString(index++,treatment_condition_date);	//15
							pstmt.setString(index++,site_type);				//16
							pstmt.setString(index++,tooth_range_nos_arr[i]);//17
							pstmt.setString(index++,tooth_range_nos); //18 Insert null, the below UPDATE pstmt will update the entire tooth_range for all the chart_line_num's
							pstmt.setString(index++,arch);					//19
							pstmt.setString(index++,quadrant);				//20
							pstmt.setString(index++,surface_range.toString());	//21 SURFACE_CODE//commented by parul on 070109 for multiple surface
							pstmt.setString(index++,cusp_range.toString());					//23 LOCATION
							pstmt.setString(index++,location);				//23
							pstmt.setString(index++,order_id);				//24
							pstmt.setString(index++,outcome);				//26
							pstmt.setString(index++,failure_remarks);				//26
							pstmt.setString(index++,remarks);				//27
							pstmt.setString(index++,practitioner_id);				//27
							pstmt.setString(index++,episode_id);					//27
							pstmt.setString(index++,episode_type);					//27
							pstmt.setString(index++,visit_id);					//27
							pstmt.setString(index++,source_code);					//27
							pstmt.setString(index++,source_type);					//27
							pstmt.setString(index++,hide_image_yn);					//27
							pstmt.setString(index++,supernuerary_yn);					//27
							pstmt.setString(index++,deciduous_yn);					//27
							pstmt.setString(index++,intraoral_extraoral);					//,
							pstmt.setString(index++,organ_code);					//27
							pstmt.setString(index++,sub_organ_code);					//27
							pstmt.setString(index++,login_user);			//28
							pstmt.setString(index++,client_ip_address);		//29
							pstmt.setString(index++,facility_id);			//30
							pstmt.setString(index++,login_user);			//31
							pstmt.setString(index++,client_ip_address);		//32
							pstmt.setString(index++,facility_id);			//33
							flag = pstmt.executeUpdate();
							//chart_line_num_int++;//added by parul for multiple surface
							flag_arr.add(""+flag);

							/*
								PATIENT_CLASS (ALWAYS COME FROM CA PARAMS)

								EPISODE_ID, (1ST 8 CHARACTERS OF ENCOUNTER_ID)

								ENCOUNTER_ID (FROM CA PARAMS)

								VISIT_ID (COMES FROM CA PARAMS. IF AVAILABLE, OTHERWISE SHOULD BE INSERTED AS NULL)

							*/
							
							task_episode_id = encounter_id.substring(0,8);
							
							//Inserting tasks in to OH_RESTORATIVE_CHART_TASKS table for a perticular Treatment
							//pstmt_task_select	= con.prepareStatement("SELECT TASK_CODE, SEQ_NO FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ? ORDER BY SEQ_NO");
							pstmt_task_select	= con.prepareStatement("SELECT B.TASK_CODE ,B.SEQ_NO FROM OH_TASKS A,OH_TREATMENT_TASKS B WHERE A.EFF_STATUS =B.EFF_STATUS AND A.TASK_CODE =B.TASK_CODE AND B.TRMT_CODE = ? ORDER BY B.SEQ_NO");
							pstmt_task_select.setString(1,trmt_code);
							rst = pstmt_task_select.executeQuery();
							while(rst.next()){
								//Added by Sharon Crasta on 3/24/2010 for IN019999
								//Added to insert only those tasks for which the Order Catalogs(EFF_STATUS) are Enabled and the task status also should be enabled.
								task_code =  rst.getString("TASK_CODE")	;
								/*pstmt_order_catalog_select = con.prepareStatement("SELECT A.EFF_STATUS ORDER_CATALOG_STATUS, B.EFF_STATUS OH_TASK_STATUS FROM OR_ORDER_CATALOG A, OH_TASKS B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND A.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE = ?) AND A.EFF_STATUS = 'E' AND B.EFF_STATUS = 'E'");
								pstmt_order_catalog_select.setString(1,task_code);
								rst_order_catalog = pstmt_order_catalog_select.executeQuery();
								if(rst_order_catalog.next()){//End*/
									pstmt_task_insert	= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_TASKS (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,TASK_CODE,SEQ_NO,ORDER_ID,ORDER_LINE_NUM,DURATION,SCHEDULE_DATE_TIME,SCHEDULE_REF_NO,PERFORMED_DATE,OUTCOME_CODE,STATUS,ADDITIONAL_TASK_YN,COMPLICATION_CODE, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, PRACTITIONER_ID, TASK_SEQ, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,PERFORMED_IN_OT) VALUES (?,?,?,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
									index_insert = 1;
									pstmt_task_insert.setString(index_insert++,facility_id);				//1
									pstmt_task_insert.setString(index_insert++,patient_id);				//2
									pstmt_task_insert.setString(index_insert++,chart_num);					//3
									pstmt_task_insert.setString(index_insert++,chart_line_num);			//4
									pstmt_task_insert.setString(index_insert++,trmt_code);					//5
									//pstmt_task_insert.setString(index_insert++,rst.getString("TASK_CODE"));			//6
									pstmt_task_insert.setString(index_insert++,task_code);			//6
									pstmt_task_insert.setString(index_insert++,rst.getString("SEQ_NO"));		//7
									pstmt_task_insert.setString(index_insert++,patient_class);	//16 PATIENT_CLASS
									pstmt_task_insert.setString(index_insert++,task_episode_id);	//17 EPISODE_ID
									pstmt_task_insert.setString(index_insert++,encounter_id);	//18 ENCOUNTER_ID
									pstmt_task_insert.setString(index_insert++,visit_id);	//19 VISIT_ID
									pstmt_task_insert.setString(index_insert++,practitioner_id);	//20 PRACTITIONER_ID
									pstmt_task_insert.setString(index_insert++,rst.getString("SEQ_NO"));							
									pstmt_task_insert.setString(index_insert++,login_user);			//16
									pstmt_task_insert.setString(index_insert++,client_ip_address);		//17
									pstmt_task_insert.setString(index_insert++,facility_id);			//18
									pstmt_task_insert.setString(index_insert++,login_user);			//19
									pstmt_task_insert.setString(index_insert++,client_ip_address);		//20
									pstmt_task_insert.setString(index_insert++,facility_id);			//21
									pstmt_task_insert.setString(index_insert++,performed_In_Ot); //22
									flag_insert = pstmt_task_insert.executeUpdate();
								}
							//}
							if(rst!=null) rst.close();
							if(rst_order_catalog!=null) rst_order_catalog.close();
							if(pstmt_task_select!=null) pstmt_task_select.close();
							if(pstmt_task_insert!=null) pstmt_task_insert.close();
							if(pstmt_order_catalog_select!=null) pstmt_order_catalog_select.close();
						//}
					}//parul on 070109 for multiple surface

					chart_line_num_int++;//added by parul for multiple surface
							
				}
					// Update the Tooth_range
					if(!status.equals("60") && !status.equals("85")){
						if(pstmt!=null) pstmt.close();
						//Commented by Sharon Crasta on 3/14/2009 for Facility/Enterprise Charts
						int flag2 = 1;
						pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET TOOTH_RANGE = ?, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
						pstmt.setString(1,tooth_range_col_str.toString());
						for(int i=0;i<tooth_range_nos_arr.length;i++){
							chart_line_num=chart_line_num_int_for_range_update+""; 
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,chart_line_num);
							flag2 = pstmt.executeUpdate();
							chart_line_num_int_for_range_update++;
							}
									
						if(!flag_arr.contains("0") && flag2!=0 && flag_insert != 0){
							commit_flag="Y";
						 }else{
							commit_flag="N";
						 }
					}
					flag_arr.clear();	//Common-ICN-0044	
				}
				else{ // FOR SITE_TYE OTHER THAN THRNG
					
						if((!chart_num.equals("1") && show_new_active_yn.equals("N")) || chart_hdr_insert_yn.equals("N"))
						{
						// In case of existing chart_num, get the max chart_line_num
						// Get the maximum chart_line_num for that chart_num
					
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=?");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							rst = pstmt.executeQuery();
							while(rst.next()){
								chart_line_num=checkForNull(rst.getString("CHART_LINE_NUM"),"1");
							}
							
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
						}

						 
					
						if(status.equals("60") || status.equals("85")){
							if(rst!=null) rst.close();
							if(pstmt!=null) pstmt.close();
							chart_line_num = checkForNull(req.getParameter("chart_line_num"));

							if(rst != null) rst.close();
							if(pstmt!=null)pstmt.close();

							sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_DTL SET TREATMENTS_OUTCOME = ?,FAILURE_REMARKS=?, COMPLICATION_CODE=?, COPIED_YN = 'N', MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ?";
							pstmt=con.prepareStatement(sqlUpdate);
							pstmt.setString(1,outcome);
							pstmt.setString(2,failure_remarks);
							pstmt.setString(3,complication);
							pstmt.setString(4,login_user);
							pstmt.setString(5,client_ip_address);
							pstmt.setString(6,facility_id);
							pstmt.setString(7,patient_id);
							pstmt.setString(8,chart_num);
							pstmt.setString(9,chart_line_num);
							flag = pstmt.executeUpdate();

							if(flag != 0){
								commit_flag="Y";
							}else{
								commit_flag="N";
							}
						}
						else{
						//initial_chart_line_num
						first_chart_line_num = chart_line_num;

						/*
							Inserting STATUS as null when the we record trmt for the first time
						*/
						/* StringBuffer cusp_chart_line_nums= new StringBuffer ();
						StringBuffer surface_chart_line_nums= new StringBuffer (); */	//Commented Against Common-ICN-0031
						StringBuffer cusp_range= new StringBuffer ();
						 for (int k=0;k<cusp_arr.length;k++){
								 if (k>0){
									 cusp_range.append(",");
								}
							cusp_range.append(cusp_arr[k]);
						 }

						
						StringBuffer surface_range= new StringBuffer ();
						 for (int k=0;k<surface_arr.length;k++){
								 if (k>0){
									 surface_range.append(",");
								}
								surface_range.append(surface_arr[k]);
						 }
						//int chart_line_num_int = Integer.parseInt(chart_line_num);//parul for multiple surface	//Common-ICN-0044

						System.err.println("surface_range:=="+surface_range.toString());
						System.err.println("surface_code:=="+surface_code);
						System.err.println("surface_no:=="+surface_no);

						if(rst != null) rst.close();
						if(pstmt!=null)pstmt.close();
						//	for (int k=0;k<surface_arr.length;k++){//parul on 070109 for multiple surface
						chart_line_num=chart_line_num==null?"1":chart_line_num;
						chart_line_num=chart_line_num.equals("null")?"1":chart_line_num;
						chart_line_num=chart_line_num.equals("0")?"1":chart_line_num;
						chart_line_num=chart_line_num.equals("")?"1":chart_line_num;
						
						sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,chart_num,chart_line_num,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,SUPER_TOOTH_NO,RETAINED_TOOTH_NO,SUPER_KEY_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

						pstmt=con.prepareStatement(sqlInsert);
						ArrayList flag_arr= new ArrayList();
						//chart_line_num=chart_line_num_int+"";//parul on 070109 for multiple surface
						index = 1;
						pstmt.setString(index++,facility_id);				//1   OPERATING_FACILITY_ID
						pstmt.setString(index++,patient_id);				//2   PATIENT_ID
						pstmt.setString(index++,chart_num);					//3  chart_num
						pstmt.setString(index++,chart_line_num);			//4  chart_line_num
						pstmt.setString(index++,encounter_id);				//5  ENCOUNTER_ID
						pstmt.setString(index++,patient_class);				//6  PATIENT_CLASS
						pstmt.setString(index++,treatment_condition);		//7  TREATMENT_CONDITION
						pstmt.setString(index++,trmt_category_type);		//8  TRMT_CATEGORY_TYPE
						pstmt.setString(index++,trmt_category_code);		//9  TRMT_CATEGORY_CODE
						pstmt.setString(index++,trmt_code);					//10  TRMT_CODE
						pstmt.setString(index++,condition_type);			//11  CONDITION_TYPE
						pstmt.setString(index++,condition_code);			//12  CONDITION_CODE
						pstmt.setString(index++,treatment_int_ext);			//13  TREATMENT_INT_EXT
						pstmt.setString(index++,tab_name);					//14
						pstmt.setString(index++,treatment_condition_date); //15 TREATMENT_CONDITION_DATE
						pstmt.setString(index++,site_type);					//16 SITE_TYPE
						pstmt.setString(index++,tooth_no);					//17 TOOTH_NO
						pstmt.setString(index++,tooth_range_nos);			//18 TOOTH_RANGE
						pstmt.setString(index++,arch);						//19 ARCH_SNO
						pstmt.setString(index++,quadrant);					//20 QUADRANT_SNO
						pstmt.setString(index++,surface_range.toString());	//21 SURFACE_CODE//commented by parul on 070109 for multiple surface
						pstmt.setString(index++,cusp_range.toString());					//23 LOCATION
						pstmt.setString(index++,location);					//23 LOCATION
						pstmt.setString(index++,order_id);					//24 ORDER_ID
						pstmt.setString(index++,outcome);					//26  TREATMENTS_OUTCOME
						pstmt.setString(index++,failure_remarks);					//26  TREATMENTS_OUTCOME
						pstmt.setString(index++,remarks);					//27 REMARKS
						pstmt.setString(index++,practitioner_id);					//27 PRACTITIONER_ID
						pstmt.setString(index++,episode_id);					//27 EPISODE_ID
						pstmt.setString(index++,episode_type);					//27 EPISODE_TYPE
						pstmt.setString(index++,visit_id);					//27  VISIT_ID
						pstmt.setString(index++,source_code);					//27 SOURCE_CODE
						pstmt.setString(index++,source_type);					//27  SOURCE_TYPE
						pstmt.setString(index++,supernuerary_yn);					//27 SUPERNUMERARY_YN
						pstmt.setString(index++,deciduous_yn);					//27 MIXED_DENT_DECIDUOUS_YN
						pstmt.setString(index++,intraoral_extraoral);					//,
						pstmt.setString(index++,organ_code);					//27
						pstmt.setString(index++,sub_organ_code);	
						pstmt.setString(index++,super_tooth_no);	
						pstmt.setString(index++,retained_tooth_no);	
						pstmt.setString(index++,super_key_num);	
						pstmt.setString(index++,login_user);				//28  ADDED_BY_ID
						pstmt.setString(index++,client_ip_address);			//29  ADDED_DATE
						pstmt.setString(index++,facility_id);				//30 ADDED_FACILITY_ID
						pstmt.setString(index++,login_user);				//31  MODIFIED_BY_ID
						pstmt.setString(index++,client_ip_address); 		//32  MODIFIED_AT_WS_NO
						pstmt.setString(index++,facility_id);				//33  MODIFIED_FACILITY_ID
						flag = pstmt.executeUpdate();
					//	chart_line_num_int++;//parul on 070109 for multiple surface
						flag_arr.add(""+flag);
					 //String aString = Integer.toString(aInt);
						/*
							PATIENT_CLASS (ALWAYS COME FROM CA PARAMS)

							EPISODE_ID, (1ST 8 CHARACTERS OF ENCOUNTER_ID)

							ENCOUNTER_ID (FROM CA PARAMS)

							VISIT_ID (COMES FROM CA PARAM. IF AVAILABLE, OTHERWISE SHOULD BE INSERTED AS NULL)

							//PRACTITIONER_ID

						*/

						task_episode_id = encounter_id.substring(0,8);
					
						//Inserting tasks in to OH_RESTORATIVE_CHART_TASKS table for a perticular Treatment
						//pstmt_task_select	= con.prepareStatement("SELECT TASK_CODE, SEQ_NO FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ? ORDER BY SEQ_NO");
						pstmt_task_select	= con.prepareStatement("SELECT B.TASK_CODE ,B.SEQ_NO FROM OH_TASKS A,OH_TREATMENT_TASKS B WHERE A.EFF_STATUS =B.EFF_STATUS AND A.TASK_CODE =B.TASK_CODE AND B.TRMT_CODE = ? ORDER BY B.SEQ_NO");
						pstmt_task_select.setString(1,trmt_code);
						rst = pstmt_task_select.executeQuery();
						//Added by Sharon Crasta on 3/24/2010 for IN019999
						//Added to insert only those tasks for which the Order Catalogs(EFF_STATUS) are Enabled and the task status also should be enabled.

						while(rst.next()) {
							task_code =  rst.getString("TASK_CODE")	;
							/*pstmt_order_catalog_select = con.prepareStatement("SELECT A.EFF_STATUS ORDER_CATALOG_STATUS, B.EFF_STATUS OH_TASK_STATUS FROM OR_ORDER_CATALOG A, OH_TASKS B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND A.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE = ?) AND A.EFF_STATUS = 'E' AND B.EFF_STATUS = 'E'");
							pstmt_order_catalog_select.setString(1,task_code);
							rst_order_catalog = pstmt_order_catalog_select.executeQuery();
							if(rst_order_catalog.next()){//End*/
								pstmt_task_insert	= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_TASKS (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,TASK_CODE,SEQ_NO,ORDER_ID,ORDER_LINE_NUM,DURATION,SCHEDULE_DATE_TIME,SCHEDULE_REF_NO,PERFORMED_DATE,OUTCOME_CODE,STATUS,ADDITIONAL_TASK_YN,COMPLICATION_CODE, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, PRACTITIONER_ID, TASK_SEQ, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,PERFORMED_IN_OT) VALUES (?,?,?,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
								index_insert = 1;
								pstmt_task_insert.setString(index_insert++,facility_id);				//1
								pstmt_task_insert.setString(index_insert++,patient_id);				//2
								pstmt_task_insert.setString(index_insert++,chart_num);					//3
								pstmt_task_insert.setString(index_insert++,chart_line_num);			//4
								pstmt_task_insert.setString(index_insert++,trmt_code);					//5
								//pstmt_task_insert.setString(index_insert++,rst.getString("TASK_CODE"));			//6
								pstmt_task_insert.setString(index_insert++,task_code);			//6
								pstmt_task_insert.setString(index_insert++,rst.getString("SEQ_NO"));		//7
								pstmt_task_insert.setString(index_insert++,patient_class);	//16 PATIENT_CLASS
								pstmt_task_insert.setString(index_insert++,task_episode_id);	//17 EPISODE_ID
								pstmt_task_insert.setString(index_insert++,encounter_id);	//18 ENCOUNTER_ID
								pstmt_task_insert.setString(index_insert++,visit_id);	//19 VISIT_ID
								pstmt_task_insert.setString(index_insert++,practitioner_id);	//20 VISIT_ID
								pstmt_task_insert.setString(index_insert++,rst.getString("SEQ_NO"));						
								pstmt_task_insert.setString(index_insert++,login_user);			//16
								pstmt_task_insert.setString(index_insert++,client_ip_address);		//17
								pstmt_task_insert.setString(index_insert++,facility_id);			//18
								pstmt_task_insert.setString(index_insert++,login_user);			//19
								pstmt_task_insert.setString(index_insert++,client_ip_address);		//20
								pstmt_task_insert.setString(index_insert++,facility_id);			//21
								pstmt_task_insert.setString(index_insert++,performed_In_Ot);			//22 added by Yadav
								flag_insert = pstmt_task_insert.executeUpdate();

							//}
							if(pstmt_task_insert!=null) pstmt_task_insert.close();
                        }
						if(rst!=null) rst.close();
						if(rst_order_catalog!=null) rst_order_catalog.close();
						if(pstmt_task_select!=null) pstmt_task_select.close();						
						if(pstmt_order_catalog_select!=null) pstmt_order_catalog_select.close();

						if(!flag_arr.contains("0") && flag_insert != 0){
							commit_flag="Y";
						 }else{
							commit_flag="N";
						 }
							flag_arr.clear();	//Common-ICN-0044				

					//  }//parul on 21/01/2010 for multiple surface
					}
				}	
				
				String p_lang_err_msg_id		= "";
				ArrayList catalog_details = getOrderCatalogDetails(req,res,trmt_code);
				String order_catalog_code = "";
				String order_type_code = "";
				if(catalog_details.size()==0){
					p_lang_err_msg_id = "PRC-OH0001";
					commit_flag1="N";
				}else{
					order_catalog_code = (String)catalog_details.get(0);
					order_type_code = (String)catalog_details.get(1);
					p_lang_err_msg_id = "RECORD_INSERTED";
					commit_flag1="Y";
				}
				catalog_details.clear();	//Common-ICN-0044
				MessageManager mm=new MessageManager();
				trace="482";
				int tooth_range_count_for_order = 0;

				if(site_type.equals("THRNG") || (site_type.equals("MAXFS") && (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") ||  sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF")))){
						tooth_range_count_for_order = tooth_range_nos_arr.length;
				}

				if(commit_flag.equals("Y") && commit_flag1.equals("Y") && !status.equals("60") && !status.equals("85")){ 
						//added by parul for CRF-442 on 27/01/2010
							/* StringBuffer cusp_chart_line_nums= new StringBuffer ();
							StringBuffer surface_chart_line_nums= new StringBuffer (); */	//Commented Against Common-ICN-0031
							
							StringBuffer cusp_range= new StringBuffer ();
							 for (int k=0;k<cusp_arr.length;k++){
									 if (k>0){
										 cusp_range.append(",");
									}
								cusp_range.append(cusp_arr[k]);
							 }

							
							StringBuffer surface_range= new StringBuffer ();
							 for (int k=0;k<surface_arr.length;k++){
									 if (k>0){
										 surface_range.append(",");
									}
									surface_range.append(surface_arr[k]);
							 }
							//end of added part
							con.commit();
							final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
							msg = ((String) mesg.get("message"));
							StringBuffer stringbuffer = new StringBuffer();
							stringbuffer.append("<html><head>");
							stringbuffer.append("<title></title>");
							stringbuffer.append("<script src='../eOH/js/DentalTreatmentStages.js' language='JavaScript'></script>");
							stringbuffer.append("<script language='javascript' src='../eCommon/js/DateUtils.js'></script>");
							stringbuffer.append("<script language='javascript' src='../eCommon/js/common.js'></script>");
							stringbuffer.append("<script language='javascript' src='../eOH/js/DentalTreatment.js'></script>");
							stringbuffer.append("<script language='javascript' src='../eOH/js/OHCommon.js'></script>");
							stringbuffer.append("<script language='javascript' src='../eOH/js/GetImages.js'></script>");
							stringbuffer.append("<script language='javascript' src='../eOH/js/FillImages.js'></script><script language='javascript' src='../eOH/js/DrawShapes.js'></script>");
							stringbuffer.append("</head>");
							stringbuffer.append("<body>");
						
								//stringbuffer.append("<script>placeOrder('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+tooth_range_count_for_order+"','"+practitioner_id+"','"+encounter_id+"','"+source_type+"','"+source_code+"','"+patient_class+"','"+order_catalog_code+"','"+order_type_code+"','"+facility_id+"','"+trmt_code+"','','"+trmt_category_type+"','"+site_type+"','"+surface_code+"','"+tooth_no+"','"+tooth_range_nos+"','"+arch+"','"+quadrant+"','"+cusp_range.toString()+"','"+RD_Normal_yn+"','"+super_tooth_ref+"','"+exfolth_count+"','"+retained_tooth_no+"');");
								stringbuffer.append("<script>placeOrder('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+tooth_range_count_for_order+"','"+practitioner_id+"','"+encounter_id+"','"+source_type+"','"+source_code+"','"+patient_class+"','"+order_catalog_code+"','"+order_type_code+"','"+facility_id+"','"+trmt_code+"','','"+trmt_category_type+"','"+site_type+"','"+surface_code+"','"+tooth_no+"','"+tooth_range_nos+"','"+arch+"','"+quadrant+"','"+cusp_range.toString()+"','"+RD_Normal_yn+"','"+super_tooth_ref+"','"+exfolth_count.toString()+"','"+retained_tooth_no.toString()+"','"+surface_range.toString()+"','"+multiple_surfaces_applicable+"');");
								stringbuffer.append("</script>");
							    stringbuffer.append("<script>if(top.content!=null){");							
								stringbuffer.append("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+msg+"'"); 
								stringbuffer.append("}else {parent.parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+msg+"'"); 
								stringbuffer.append("}</script>");
								stringbuffer.append("</body></html>");
								out.println(stringbuffer.toString());
								mesg.clear();	//Common-ICN-0044

					 }
				 else if(commit_flag.equals("Y") && (status.equals("60") || status.equals("85"))){ 
					 con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
					mesg.clear();	//Common-ICN-0044
				 }
				 else{//Transaction Failed
					con.rollback();
					final java.util.Hashtable mesg;
					if(commit_flag1.equals("N")){// If there is no Catalog Code associated
						mesg = mm.getMessage(locale, p_lang_err_msg_id, "OH") ;
						msg = ((String) mesg.get("message"));
					}else{
						mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
						msg = ((String) mesg.get("message"));
					}
					mesg.clear();	//Common-ICN-0044
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
				 }

				 trace="501";

	}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in OHDentalChartTrmtServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("OHDentalChartTrmtServlet :Caught Exception during rollback"+e_1);
				}
			    System.err.println("OHDentalChartTrmtServlet: Err Msg in OHDentalChartTrmtServlet"+e.getMessage());
			    System.err.println("OHDentalChartTrmtServlet: Err Msg in OHDentalChartTrmtServlet:trace="+trace);
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}finally{
		try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt_task_insert!=null) pstmt_task_insert.close();
				if(pstmt_task_select!=null) pstmt_task_select.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



