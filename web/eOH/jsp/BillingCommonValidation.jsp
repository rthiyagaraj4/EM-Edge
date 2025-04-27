<!DOCTYPE html>
<%@ page  import="java.sql.*,java.util.*,eOH.*,eOR.OrderEntryBillingQueryBean,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_task = null;
	CallableStatement cstmt= null ;
	ResultSet rs = null;

	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String)session.getAttribute("facility_id"); 
	String practitioner_id = (String)session.getValue("ca_practitioner_id") ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty( "client_ip_address" );
	String login_user = prop.getProperty( "login_user" );

	String func_mode = request.getParameter( "func_mode" ) ;

	String oh_bean_id 		= "OHBillingBean";
	String oh_bean_name 	= "eOH.OHBillingBean";
	OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );

	//String oh_history_bean_id 		= "OHRestorativeHistoryBean";
	//String oh_history_bean_name 	= "eOH.OHRestorativeHistoryBean";
	//OHRestorativeHistoryBean oh_history_bean	= (OHRestorativeHistoryBean)getBeanObject( oh_history_bean_id, oh_history_bean_name, request );

	String or_bean_id 		= "Or_billingQueryBean";
	String or_bean_name 	= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );

	int flag_update_task = 0;

	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("getTotalBillAmount")){	

			/*

			OH_BILLING_PACKAGE.OH_BL_GET_TOTAL_CHARGED_TASKS(
				P_FACILITY_ID	IN VARCHAR2,
				P_PATIENT_ID		IN VARCHAR2,
				P_PRACT_STAFF_ID	IN VARCHAR2,
				P_CHART_NUM		IN VARCHAR2,
				P_CHART_LINE_NUM	IN VARCHAR2,
				P_TRMT_CODE		IN VARCHAR2,
				P_CUR_TASK_SEQ_NO	IN VARCHAR2,
				P_LANGUAGE_ID		IN  VARCHAR2,
				P_STR			OUT VARCHAR2,
				P_CHARGE_BASED_YN	OUT VARCHAR2,
				P_TOT_AMT		OUT VARCHAR2,
				P_PAT_PAYABLE_AMT	OUT VARCHAR2,
				P_EXCL_INCL_IND		OUT VARCHAR2,
				P_PREAPP_YN		OUT VARCHAR2,
				P_PAT_PAID_AMT		OUT VARCHAR2,
				P_CHARGED_YN		OUT VARCHAR2,
				P_PAT_BILLED_YN		OUT VARCHAR2,
				P_TOTAL_TASK_AMOUNT	OUT VARCHAR2,
				V_ERROR_CODE		OUT VARCHAR2,
				V_SYS_MESSAGE_ID	OUT VARCHAR2,
				V_ERROR_TEXT		OUT VARCHAR2);
			*/
			String patient_id	= request.getParameter( "patient_id" ) ;
			practitioner_id	= request.getParameter( "practitioner_id" ) ;
			String chart_num	= request.getParameter( "chart_num" ) ;
			String chart_line_num	= request.getParameter( "chart_line_num" ) ;
			String task_seq_no	= request.getParameter( "task_seq_no" ) ;
			String trmt_code	= request.getParameter( "trmt_code" ) ;
			String total_amount = "";

			
			cstmt=con.prepareCall("{call OH_BILLING_PACKAGE.OH_BL_GET_TOTAL_CHARGED_TASKS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 
			cstmt.setString(1,facility_id );			//p_facility_id		VARCHAR2,
			cstmt.setString(2,patient_id );				//p_patient_id		VARCHAR2,
			cstmt.setString(3,practitioner_id);			//p_pract_staff_id		VARCHAR2,
			cstmt.setString(4,chart_num );				//p_chart_num	VARCHAR2,
			cstmt.setString(5,chart_line_num );			//p_chart_line_num           VARCHAR2,
			cstmt.setString(6,trmt_code);				//p_trmt_code        VARCHAR2,
			cstmt.setString(7,task_seq_no);				//p_cur_task_seq_no		VARCHAR2,
			cstmt.setString(8,locale);					//p_language_id	VARCHAR2,
			
			cstmt.registerOutParameter(9,Types.VARCHAR);		//	P_STR			OUT VARCHAR2,                  
			cstmt.registerOutParameter(10,Types.VARCHAR);		//	P_CHARGE_BASED_YN	OUT VARCHAR2,              
			cstmt.registerOutParameter(11,Types.VARCHAR);		//	P_TOT_AMT		OUT VARCHAR2,                  
			cstmt.registerOutParameter(12,Types.VARCHAR);		//	P_PAT_PAYABLE_AMT	OUT VARCHAR2,              
			cstmt.registerOutParameter(13,Types.VARCHAR);		//	P_EXCL_INCL_IND		OUT VARCHAR2,              
			cstmt.registerOutParameter(14,Types.VARCHAR);		//	P_PREAPP_YN		OUT VARCHAR2,                  
			cstmt.registerOutParameter(15,Types.VARCHAR);		//	P_PAT_PAID_AMT		OUT VARCHAR2,              
			cstmt.registerOutParameter(16,Types.VARCHAR);		//	P_CHARGED_YN		OUT VARCHAR2,              
			cstmt.registerOutParameter(17,Types.VARCHAR);		//	P_PAT_BILLED_YN		OUT VARCHAR2,              
			cstmt.registerOutParameter(18,Types.VARCHAR);		//	P_TOTAL_TASK_AMOUNT	OUT VARCHAR2,              
			cstmt.registerOutParameter(19,Types.VARCHAR);		//	V_ERROR_CODE		OUT VARCHAR2,              
			cstmt.registerOutParameter(20,Types.VARCHAR);		//	V_SYS_MESSAGE_ID	OUT VARCHAR2,              
			cstmt.registerOutParameter(21,Types.VARCHAR);		//	V_ERROR_TEXT		OUT VARCHAR2);             
			cstmt.execute();
			total_amount = cstmt.getString(18);


			out.println(total_amount);
		}
		else if(func_mode.equalsIgnoreCase("recordCharges")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" ));
			String chart_num	= checkForNull(request.getParameter( "chart_num" ));
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" ));
			String order_id = checkForNull(request.getParameter( "order_id" ));
			String order_line_num = checkForNull(request.getParameter( "order_line_num" ));
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" ));
			String task_code	= checkForNull(request.getParameter( "task_code" ));
			String encounter_id	= checkForNull(request.getParameter( "encounter_id" ));
			String build_history_yn	= checkForNull(request.getParameter( "build_history_yn" ));
			String cur_date_time = "";
			String call_process_yn = "N";
			String current_charging_stage = checkForNull(request.getParameter( "charging_stage" ));
			String total_payable_for_task="";
			String prev_task_total_amount="";
			String total_grater_yn = "Y";
			String call_history_yn = "N";
			String billed_yn = "";
			String bl_episode_id		= checkForNull(request.getParameter( "bl_episode_id" ));
			String bl_encounter_id		= checkForNull(request.getParameter( "bl_encounter_id" )) ;
			String bl_visit_id			= checkForNull(request.getParameter( "bl_visit_id" ));
			String bl_episode_type		= checkForNull(request.getParameter( "bl_episode_type" )) ;
			String patient_class	= checkForNull(request.getParameter( "patient_class" )) ;
			String surgeon_code		= checkForNull(request.getParameter( "surgeon_code" ));
			String task_desc		= checkForNull(request.getParameter( "task_desc" )) ;
			String bl_key				= checkForNull(request.getParameter( "bl_key" ));
			String bl_key_line_no			= checkForNull(request.getParameter( "bl_key_line_no" ));
			String bl_panel_str		= checkForNull(request.getParameter( "bl_panel_str" ));
			//Commented by Sharon Crasta for Checkstyle.
			//String bl_service_date		= checkForNull(request.getParameter( "bl_service_date" ));
			//
			String billing_appl_yn		= checkForNull(request.getParameter( "billing_appl_yn" ));// Billing - OH interface flag from Parameter for Facility Master
			String task_order_catalog_code		= checkForNull(request.getParameter( "task_order_catalog_code" ));
		    //Commented by Sharon Crasta for Checkstyle.
			//String complete_charges_yn		= checkForNull(request.getParameter( "complete_charges_yn" ));
			String bl_total_payable_for_trmt		= checkForNull(request.getParameter( "bl_total_payable_for_trmt" ));
			//String seq_no		= checkForNull(request.getParameter( "seq_no" ));
			String bl_serv_panel_ind		= checkForNull(request.getParameter( "bl_serv_panel_ind" ));
			//String bl_serv_panel_code		= checkForNull(request.getParameter( "bl_serv_panel_code" ));
			String task_status_for_billing		= checkForNull(request.getParameter( "task_status_for_billing" ));
			//String charging_stage		= checkForNull(request.getParameter( "charging_stage" ));

			//Start_date and End_date
			String start_date_time		= checkForNull(request.getParameter( "start_date_time" ));
			String end_date_time		= checkForNull(request.getParameter( "end_date_time" ));
																										  
			//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
			String task_seq_no		= checkForNull(request.getParameter( "task_seq_no" ));
			//

			String override_inc_exl		= checkForNull(request.getParameter( "override_inc_exl" ));
			String reason_override_inc_exl		= checkForNull(request.getParameter( "reason_override_inc_exl" ));

			int flag = 0;
			int flag_task = 0;
			int build_history_count = 0;
			String patient_bill = "";
			HashMap bill_map = null;
			ArrayList flag_arr= new ArrayList();
			String charge_message_id="";

			

			if(start_date_time.equals("") || end_date_time.equals("")){
				//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
				//pstmt_task = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
				
				//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				//pstmt_task = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
				pstmt_task = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
				pstmt_task.setString(1,start_date_time);
				pstmt_task.setString(2,end_date_time);
				pstmt_task.setString(3,login_user);
				pstmt_task.setString(4,client_ip_address);
				pstmt_task.setString(5,facility_id);
				//pstmt_task.setString(6,facility_id);
				pstmt_task.setString(6,patient_id);
				pstmt_task.setString(7,chart_num);
				pstmt_task.setString(8,chart_line_num);
				pstmt_task.setString(9,trmt_code);
				pstmt_task.setString(10,task_code);
				pstmt_task.setString(11,task_seq_no);
				flag_update_task = pstmt_task.executeUpdate();
			}

			if(flag_update_task != 0 ){
				con.commit();
			}
			else{
				con.rollback();
			}

			//if(bl_panel_str.equals("") && complete_charges_yn.equals("Y")){
			if(bl_panel_str.equals("") && billing_appl_yn.equals("Y")){// Condition for billing_appl_yn is added by Sridevi Joshi on 5/28/2010 for IN021675

				pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') CUR_DATE_TIME FROM DUAL");
				rs=pstmt.executeQuery();
				while(rs.next()){
					cur_date_time = rs.getString("CUR_DATE_TIME");
				}	

				/*commented and modified as below by bshankar on 15th March. order_id and order_line_num should be passed in this case ArrayList bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,cur_date_time ,locale,"","",patient_id,encounter_id,patient_class,practitioner_id); 
				*/

				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,cur_date_time ,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,practitioner_id);

				HashMap patient_dtls_hash	= oh_bean.formatBillingDetails(bill_dtls);
				
				bl_panel_str =(String) patient_dtls_hash.get("bl_panel_str");
				bl_episode_id =(String) patient_dtls_hash.get("episode_id");
				bl_visit_id =(String) patient_dtls_hash.get("visit_id");
				bl_episode_type =(String) patient_dtls_hash.get("episode_type");
				total_payable_for_task =(String) patient_dtls_hash.get("total_payable");
				bl_serv_panel_ind =(String) patient_dtls_hash.get("serv_panel_ind");

				/*
				if(bl_total_payable_for_trmt.equals("") || bl_total_payable_for_trmt.equals("null") || bl_total_payable_for_trmt.equals(null)){
					bl_total_payable_for_trmt = "0";
				}
				*/

				
				if(!bl_total_payable_for_trmt.equals("")){//Added by Sridevi Joshi n 8/25/2010 for IN023131(SRR20056-SCF-4951)

					float total_payable_for_task_float = Float.parseFloat(total_payable_for_task); 
					//int total_payable_for_task_int = (int)total_payable_for_task_float;
					
					float bl_total_payable_for_trmt_float = 0.0f;
					//if(!bl_total_payable_for_trmt.equals("")){
						bl_total_payable_for_trmt_float = Float.parseFloat(bl_total_payable_for_trmt); 
					//}

					//int bl_total_payable_for_trmt_int = (int)bl_total_payable_for_trmt_float;

					float total_for_all_tasks = 0.0f;
					if(Integer.parseInt(task_seq_no) >1){
						//To get the Total Bill amount of previous tasks
						cstmt=con.prepareCall("{call OH_BILLING_PACKAGE.OH_BL_GET_TOTAL_CHARGED_TASKS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					 
						cstmt.setString(1,facility_id );			//p_facility_id		VARCHAR2,
						cstmt.setString(2,patient_id );				//p_patient_id		VARCHAR2,
						cstmt.setString(3,practitioner_id);			//p_pract_staff_id		VARCHAR2,
						cstmt.setString(4,chart_num );				//p_chart_num	VARCHAR2,
						cstmt.setString(5,chart_line_num );			//p_chart_line_num           VARCHAR2,
						cstmt.setString(6,trmt_code);				//p_trmt_code        VARCHAR2,
						cstmt.setString(7,task_seq_no);				//p_cur_task_seq_no		VARCHAR2,
						cstmt.setString(8,locale);					//p_language_id	VARCHAR2,
						
						cstmt.registerOutParameter(9,Types.VARCHAR);		//	P_STR			OUT VARCHAR2,                 
						cstmt.registerOutParameter(10,Types.VARCHAR);		//	P_CHARGE_BASED_YN	OUT VARCHAR2,             
						cstmt.registerOutParameter(11,Types.VARCHAR);		//	P_TOT_AMT		OUT VARCHAR2,                 
						cstmt.registerOutParameter(12,Types.VARCHAR);		//	P_PAT_PAYABLE_AMT	OUT VARCHAR2,             
						cstmt.registerOutParameter(13,Types.VARCHAR);		//	P_EXCL_INCL_IND		OUT VARCHAR2,             
						cstmt.registerOutParameter(14,Types.VARCHAR);		//	P_PREAPP_YN		OUT VARCHAR2,                 
						cstmt.registerOutParameter(15,Types.VARCHAR);		//	P_PAT_PAID_AMT		OUT VARCHAR2,             
						cstmt.registerOutParameter(16,Types.VARCHAR);		//	P_CHARGED_YN		OUT VARCHAR2,             
						cstmt.registerOutParameter(17,Types.VARCHAR);		//	P_PAT_BILLED_YN		OUT VARCHAR2,             
						cstmt.registerOutParameter(18,Types.VARCHAR);		//	P_TOTAL_TASK_AMOUNT	OUT VARCHAR2,             
						cstmt.registerOutParameter(19,Types.VARCHAR);		//	V_ERROR_CODE		OUT VARCHAR2,             
						cstmt.registerOutParameter(20,Types.VARCHAR);		//	V_SYS_MESSAGE_ID	OUT VARCHAR2,             
						cstmt.registerOutParameter(21,Types.VARCHAR);		//	V_ERROR_TEXT		OUT VARCHAR2);            
						cstmt.execute();
						prev_task_total_amount = checkForNull(cstmt.getString(18));
						//String pat_billed_yn = checkForNull(cstmt.getString(17));

						//total_for_all_tasks = total_payable_for_task_int+ Integer.parseInt(prev_task_total_amount);
						total_for_all_tasks = total_payable_for_task_float+ Float.parseFloat(prev_task_total_amount);
						//total_for_all_tasks = 2000.00F;
					}
					
					
					///if(total_payable_for_task_int > bl_total_payable_for_trmt_int){
					if(total_payable_for_task_float > bl_total_payable_for_trmt_float){
						/*
						//out.println("<script>alert(\"Value is more\")</script>");
						//out.println("<script>alert(\"test\")</script>");
						String msg = "Value is more";
						response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+msg);
						*/
						//charge_message_id = "CHARGES_FAILED::APP-OH00069::"+total_payable_for_task_int+"::"+bl_total_payable_for_trmt_int+"::";
						charge_message_id = "CHARGES_FAILED::APP-OH00069::"+total_payable_for_task_float+"::"+bl_total_payable_for_trmt_float+"::";
						out.println(charge_message_id) ;
						total_grater_yn = "N";
						//return;
					}
					//else if(total_for_all_tasks > bl_total_payable_for_trmt_int){
					else if(total_for_all_tasks > bl_total_payable_for_trmt_float){
						/*
						//out.println("<script>alert(\"Value is more for all tasks\")</script>");
						//out.println("<script>alert(\"test\")</script>");
						String msg = "Value is more for all tasks";
						response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+msg);
						*/
						//charge_message_id = "CHARGES_FAILED::APP-OH00071::"+total_payable_for_task_int+"::"+bl_total_payable_for_trmt_int+"::"+Integer.parseInt(prev_task_total_amount)+"::";
						charge_message_id = "CHARGES_FAILED::APP-OH00071::"+total_payable_for_task_float+"::"+bl_total_payable_for_trmt_float+"::"+prev_task_total_amount+"::";
						out.println(charge_message_id) ;
						total_grater_yn = "N";
						//return;
					}
					else{
						charge_message_id = "";
						total_grater_yn = "Y";
					}
				}
				else{
					charge_message_id = "";
					total_grater_yn = "Y";
				}
		
			}
			//added by parul on 29/06/2010 for 22318
	       pstmt = con.prepareStatement("SELECT A.ENCOUNTER_ID,A.EPISODE_ID,A.VISIT_ID,B.EPISODE_TYPE  FROM  OH_RESTORATIVE_CHART_TASKS A, OH_RESTORATIVE_CHART_DTL B WHERE A.PATIENT_ID =? AND A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TASK_CODE=? AND A.ORDER_ID=? AND A.CHART_LINE_NUM=B.CHART_LINE_NUM AND A.CHART_NUM=B.CHART_NUM AND A.PATIENT_ID =B.PATIENT_ID");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,task_code);
				pstmt.setString(5,order_id);
				rs = pstmt.executeQuery();
				while(rs!= null && rs.next()){
                   bl_encounter_id=checkForNull(rs.getString("ENCOUNTER_ID"));	
                   bl_episode_id=checkForNull(rs.getString("EPISODE_ID"));	
                   bl_visit_id=checkForNull(rs.getString("VISIT_ID"));	
                   bl_episode_type=checkForNull(rs.getString("EPISODE_TYPE"));	
				}

			  if (bl_visit_id.equals("")){
				 pstmt = con.prepareStatement("SELECT OP_EPISODE_VISIT_NUM FROM PR_ENCOUNTER WHERE ENCOUNTER_ID =?");
				pstmt.setString(1,bl_encounter_id);
				rs = pstmt.executeQuery();
				while(rs!= null && rs.next()){
				   bl_visit_id=checkForNull(rs.getString("OP_EPISODE_VISIT_NUM"));	
				}
			  
			  }//end 
			
			if(charge_message_id.equals("")){
				if((billing_appl_yn.equals("Y") && !bl_panel_str.equals("") && total_grater_yn.equals("Y") )|| !billing_appl_yn.equals("Y")){//!billing_appl_yn.equals("Y") Condition is added to build history when billing interface is disabled for OH on 6/15/2010 by Sridevi Joshi

					pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') CUR_DATE_TIME FROM DUAL");
					rs=pstmt.executeQuery();
					while(rs.next()){
						cur_date_time = rs.getString("CUR_DATE_TIME");
					}

					//if(complete_charges_yn.equals("Y")){
						call_process_yn	= "Y";
						//current_charging_stage="RST";
					//}
					//else{
						//current_charging_stage="REG";
						//call_process_yn	= "N";
					//}
					

					bill_map = new HashMap();
					bill_map.put("facility_id",facility_id);
					bill_map.put("patient_id",patient_id);
					bill_map.put("episode_id",bl_episode_id);
					bill_map.put("encounter_id",bl_encounter_id);
					bill_map.put("visit_id",bl_visit_id);
					bill_map.put("episode_type",bl_episode_type);
					bill_map.put("patient_class",patient_class);
					bill_map.put("surgeon_code",surgeon_code);
					bill_map.put("chart_num",chart_num);
					bill_map.put("chart_line_num",chart_line_num);
					bill_map.put("order_id",order_id);
					bill_map.put("order_line_num",order_line_num);
					bill_map.put("task_code",task_code);
					bill_map.put("task_desc",task_desc);
					bill_map.put("key",bl_key);
					bill_map.put("key_line",bl_key_line_no);
					bill_map.put("bl_panel_str",bl_panel_str);
					//bill_map.put("service_date",bl_service_date);
					bill_map.put("service_date",cur_date_time);
					bill_map.put("current_charging_stage",current_charging_stage);
					bill_map.put("login_at_ws_no",client_ip_address);
					bill_map.put("call_process_yn",call_process_yn);
					bill_map.put("serv_panel_ind",bl_serv_panel_ind);
					bill_map.put("task_order_catalog_code",task_order_catalog_code);
					bill_map.put("override_inc_exl",override_inc_exl);
					bill_map.put("reason_override_inc_exl",reason_override_inc_exl);
					
					patient_bill = oh_bean.GeneratePatientBill(bill_map);
				
					//if(complete_charges_yn.equals("Y") && patient_bill.equals("SUCCESS")){
					if(patient_bill.equals("SUCCESS")){
						//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
						//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET BILLED_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND ORDER_ID = ? AND ORDER_LINE_NUM = ?");
						
						//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
						//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET BILLED_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND ORDER_ID = ? AND ORDER_LINE_NUM = ?");
						pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET BILLED_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND ORDER_ID = ? AND ORDER_LINE_NUM = ? AND TASK_SEQ=?");
						//pstmt.setString(1,facility_id);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,trmt_code);
						pstmt.setString(4,task_code);
						pstmt.setString(5,order_id);
						pstmt.setString(6,order_line_num);
						pstmt.setString(7,task_seq_no);
						flag_task=pstmt.executeUpdate();
						if(flag_task != 0){
							con.commit();
						}else{
							con.rollback();
						}
					}

					if(!billing_appl_yn.equals("Y")){//Condition is added to build history when billing interface is disabled for OH on 6/15/2010 by Sridevi Joshi
						patient_bill = "SUCCESS";
					}

					if(patient_bill.equals("SUCCESS")){
						
						if(pstmt != null) pstmt.close();
						//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
						//pstmt=con.prepareStatement("SELECT (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = STATUS) STATUS, BILLED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' AND ORDER_ID = ?");
						pstmt=con.prepareStatement("SELECT (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = STATUS) STATUS, BILLED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' AND ORDER_ID = ?");
						//pstmt.setString(1,facility_id);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,chart_line_num);
						pstmt.setString(4,trmt_code);
						pstmt.setString(5,task_code);
						pstmt.setString(6,order_id);
						rs = pstmt.executeQuery();
						String update_cd_yn = "N";
						String result_complete_yn = "N";
						while(rs.next()){
							billed_yn = checkForNull(rs.getString("BILLED_YN"));
							task_status_for_billing = checkForNull(rs.getString("STATUS"));

							if(task_status_for_billing.equals("85") || task_status_for_billing.equals("60") || task_status_for_billing.equals("75") || task_status_for_billing.equals("90")){
								result_complete_yn  = "Y";
							}
							else{
								result_complete_yn = "N";
							}

							update_cd_yn = "N";
							if(billed_yn.equals("Y") && result_complete_yn.equals("Y")){
								update_cd_yn = "Y";
							}
							if(pstmt_task != null) pstmt_task.close();
							//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
							//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = DECODE(?,'Y',(SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60'),STATUS), BILL_SUB_REGN_NUM = ?, BILL_SUB_REGN_LINE_NUM = ?, PERFORMED_DATE = SYSDATE, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND ORDER_ID = ? AND ORDER_LINE_NUM = ?");
							
							//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
							//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = DECODE(?,'Y',(SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60'),STATUS), BILL_SUB_REGN_NUM = ?, BILL_SUB_REGN_LINE_NUM = ?, PERFORMED_DATE = SYSDATE, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND ORDER_ID = ? AND ORDER_LINE_NUM = ?");
							pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = DECODE(?,'Y',(SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60'),STATUS), BILL_SUB_REGN_NUM = ?, BILL_SUB_REGN_LINE_NUM = ?, PERFORMED_DATE = SYSDATE, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND ORDER_ID = ? AND ORDER_LINE_NUM = ? AND TASK_SEQ = ?");

							pstmt_task.setString(1,update_cd_yn);
							pstmt_task.setString(2,order_id+"_"+chart_num);
							pstmt_task.setString(3,order_line_num);
							pstmt_task.setString(4,login_user);
							pstmt_task.setString(5,client_ip_address);
							pstmt_task.setString(6,facility_id);
							//pstmt_task.setString(7,facility_id);
							pstmt_task.setString(7,patient_id);
							pstmt_task.setString(8,chart_num);
							pstmt_task.setString(9,trmt_code);
							pstmt_task.setString(10,task_code);
							pstmt_task.setString(11,order_id);
							pstmt_task.setString(12,order_line_num);
							pstmt_task.setString(13,task_seq_no);
							flag = pstmt_task.executeUpdate();
							flag_arr.add(""+flag);					
						}
						if(!flag_arr.contains("0")){
							con.commit();
						}else{
							con.rollback();
						}

						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
						int j=0;
						HashMap map = new HashMap();

						int mark_error_count = 0;
						int resulted_count = 0;

						String update_error = "";
						String update_resulted = "";
						String task_status = "";
						String insert_status_type = "";

						//pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");	
						
						//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart		
						//pstmt = con.prepareStatement("SELECT DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");				
						pstmt = con.prepareStatement("SELECT DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");				
						//pstmt.setString(1,facility_id);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,chart_line_num);
						rs=pstmt.executeQuery();
						while(rs.next()){
							task_status = checkForNull(rs.getString("STATUS"));
							map.put(j,task_status);
							j++;
						}

						int map_size = map.size();

						for(int k=0;k<map_size;k++){
							if(map.get(k).equals("E")){
								mark_error_count++;
							}
							else if(map.get(k).equals("60")){
								resulted_count++;
							}
						}
						
						if(mark_error_count == map_size){
							update_error = "Y";
							insert_status_type = "E";
						}
						else if((map_size-mark_error_count) == resulted_count){
							update_resulted = "Y";
							insert_status_type = "60";
							//insert_status_type = "85";
						}

						if(insert_status_type.equals("60") && update_resulted == "Y"){
							// update only dtl
							if(pstmt != null) pstmt.close();
							/* previously TRMT_COMPLETED_YN is updated with 'R'.. Now Chanegd to 'Y'*/
							//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', TRMT_COMPLETED_YN = 'R', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
							//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
							//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', TRMT_COMPLETED_YN = 'Y', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");

							pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', TRMT_COMPLETED_YN = 'Y', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
							pstmt.setString(1,insert_status_type);
							pstmt.setString(2,login_user);
							pstmt.setString(3,client_ip_address);
							pstmt.setString(4,facility_id);
							pstmt.setString(5,patient_id);
							pstmt.setString(6,chart_num);
							pstmt.setString(7,order_id);
							flag = pstmt.executeUpdate();
	
							if(flag != 0){
								pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET BUILD_HISTORY_YN = 'Y', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
								pstmt.setString(1,login_user);
								pstmt.setString(2,client_ip_address);
								pstmt.setString(3,facility_id);
								pstmt.setString(4,patient_id);
								pstmt.setString(5,chart_num);
								pstmt.setString(6,chart_line_num);
								pstmt.setString(7,order_id);
								flag = pstmt.executeUpdate();
							}

							call_history_yn = "Y"; 
						}

						if(flag != 0){
							con.commit();
							if(call_history_yn.equals("Y")){ //Call History while updating Chart_Dtl table with 'CD'(60).
								charge_message_id = "CALL_HISTORY::";
								out.println(charge_message_id) ;
								/*
								HashMap history_params = new HashMap();
								history_params.put("facility_id",facility_id);
								history_params.put("patient_id",patient_id);
								history_params.put("encounter_id",bl_encounter_id);
								history_params.put("header_tab",header_tab);
								history_params.put("chart_num",chart_num);
								history_params.put("chart_line_num",chart_line_num);
								history_params.put("tooth_numbering_system",tooth_numbering_system);
								history_params.put("permanent_deciduous_flag",permanent_deciduous_flag);
								history_params.put("mixed_dentition_YN",mixed_dentition_YN);
								history_params.put("upper_arch_desc",upper_arch_desc);
								history_params.put("lower_arch_desc",lower_arch_desc);
								history_params.put("Q1_id",Q1_id);
								history_params.put("Q2_id",Q2_id);
								history_params.put("Q3_id",Q3_id);
								history_params.put("Q4_id",Q4_id);
								history_params.put("Q1_desc",Q1_desc);
								history_params.put("Q2_desc",Q2_desc);
								history_params.put("Q3_desc",Q3_desc);
								history_params.put("Q4_desc",Q4_desc);

								oh_history_bean.insertHistoryClob(history_params);
								*/
							}
						}
						else{
							con.rollback();
						}
					}
					/*
					if(patient_bill.equals("SUCCESS")){
						//out.println("<script>alert(\"SUCCESS\");</script>");
					}
					*/
				}
			}// end of if for charge_message_id				
		}
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from BillingCommonValidation.jsp "+e);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(cstmt!=null)cstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>

	
