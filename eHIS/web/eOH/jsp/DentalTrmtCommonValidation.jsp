<!DOCTYPE html>
<%@ page  import="java.text.DateFormat,java.text.SimpleDateFormat,java.text.ParseException,java.sql.*,java.util.*,eOH.*,eOR.OrderEntryBillingQueryBean,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 


<%
	Connection con = null;
	CallableStatement cstmt= null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_task = null;
	PreparedStatement pstmt_range = null;
	PreparedStatement pstmt_task1 = null;
	ResultSet rs = null;
	int flag=0;
	int flag1=0;
	int Reg_order_flag=0;
	int Reg_order_line_flag=0;
	//int flag_or_order=0;

	String oh_bean_id 		= "OHBillingBean";
	String oh_bean_name 	= "eOH.OHBillingBean";
	OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );

	String or_bean_id 		= "Or_billingQueryBean";
	String or_bean_name 	= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );

	String client_ip_address="";
	String facility_id = "";	
	String login_user=""; 
		
	java.util.Properties prop = null;
	facility_id = (String)session.getValue( "facility_id" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id") ;

	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	client_ip_address = prop.getProperty( "client_ip_address" );
	login_user = prop.getProperty( "login_user" );

	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;
	ArrayList flag_arr= new ArrayList();
	//String msg = "";
	String tooth_range = "";
	//String status_code = "";
	String patient_bill = "";
	int chart_line_num_int = 0;
	//String[] tooth_range_arr = null;
	//String[] tooth_range_chart_line_num_arr =null;
	//HashMap map = null;

	ArrayList map = null;
	HashMap bill_map = null;

	int mark_error_count = 0;
	int outstanding_count = 0;
	int sch_count = 0;
	int register_count = 0;
	int progress_count = 0;
	int partial_count = 0;
	int resulted_count = 0;
	int resulted_RS_count = 0;

	String update_error = "";
	String update_status = "";
	String update_sch = "";
	String update_register = "";
	String update_progress = "";
	String update_partial = "";
	String update_resulted = "";

	String frame_msg = "";

	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("updateTrmtTaskStatus")){

			String patient_id				= checkForNull(request.getParameter( "patient_id" ));
			String chart_num				= checkForNull(request.getParameter( "chart_num" ));
			String chart_line_num			= checkForNull(request.getParameter( "chart_line_num" ));
			String order_status_type		= checkForNull(request.getParameter( "order_status_type" ));
			String order_status_type_code	= checkForNull(request.getParameter( "order_status_type" ));
			String order_id					= checkForNull(request.getParameter( "order_id" ));
			String order_line_num			= checkForNull(request.getParameter( "order_line_num" ));
			//String sql						= "";		
			String status					= "";		
			String status_dtl				= "";		
			String task_status				= "";	
			int index_task = 1; // Added by Sridevi Joshi on 3/15/2010 for IN019995
			StringBuffer sql_buffer_task = new StringBuffer();
			
			String order_set_flag			= checkForNull(request.getParameter( "order_set_flag" ));
			String trmt_code				= checkForNull(request.getParameter( "trmt_code" ));
			String task_code				= checkForNull(request.getParameter( "task_code" ));
			String reasonforcancel			= checkForNull(request.getParameter( "reasonforcancel" ));
			String encounter_id				= checkForNull(request.getParameter( "encounter_id" ));

			String start_date_time			= checkForNull(request.getParameter( "start_date_time" ));
			if(start_date_time.equals(" ")) start_date_time="";
			String end_date_time			= checkForNull(request.getParameter( "end_date_time" ));

			String order_catalog_bill_yn			= checkForNull(request.getParameter( "order_catalog_bill_yn" ));
			String billing_appl_yn			= checkForNull(request.getParameter( "billing_appl_yn" ));
			billing_appl_yn			= checkForNull(request.getParameter( "OH_billing_appl_yn" ));
			
			//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			String task_seq_no			= checkForNull(request.getParameter( "task_seq_no" ));
			
			/*
				"&bl_episode_id="+bl_episode_id+"&bl_encounter_id="+bl_encounter_id+"&bl_visit_id="+bl_visit_id+"&bl_episode_type="+bl_episode_type+"&patient_class="+patient_class+"&surgeon_code="+surgeon_code+"&task_desc="+task_desc+"&bl_key="+bl_key+"&bl_key_line_no="+bl_key_line_no+"&bl_panel_str="+bl_panel_str+"&bl_service_date="+bl_service_date+"&billing_appl_yn="+billing_appl_yn;
			*/
			//parameters for billing function
			String cur_date_time			= "";
			String or_order_status_type		= "";
			//String call_process_yn			= "N";
			String billed_yn				= "";	
			String task_status_for_billing	= "";	
			String serv_panel_ind			= "";	
			//String processed_msg			= "";	
			
			String bl_episode_id			= checkForNull(request.getParameter( "bl_episode_id" ));
			//String bl_encounter_id			= checkForNull(request.getParameter( "bl_encounter_id" )) ;
			String bl_visit_id				= checkForNull(request.getParameter( "bl_visit_id" ));
			String bl_episode_type			= checkForNull(request.getParameter( "bl_episode_type" )) ;
			String patient_class			= checkForNull(request.getParameter( "patient_class" )) ;
			//String surgeon_code				= checkForNull(request.getParameter( "surgeon_code" ));
			String task_desc				= checkForNull(request.getParameter( "task_desc" )) ;
			//String bl_key					= checkForNull(request.getParameter( "bl_key" ));
			//String bl_key_line_no			= checkForNull(request.getParameter( "bl_key_line_no" ));
			String bl_panel_str				= checkForNull(request.getParameter( "bl_panel_str" ));
			//String bl_service_date			= checkForNull(request.getParameter( "bl_service_date" ));
			//String billing_appl_yn			= checkForNull(request.getParameter( "billing_appl_yn" ));
			String task_order_catalog_code	= checkForNull(request.getParameter( "task_order_catalog_code" ));
			String performed_In_OT	= checkForNull(request.getParameter( "performed_In_OT" ));
			String reg_date_time= checkForNull(request.getParameter( "reg_date_time" ));
			/*String[] regDateArray= reg_date_time.split(" "); 
			String regDate=regDateArray[0];
			String regTime=regDateArray[1];

			DateFormat dft = new SimpleDateFormat("MM/dd/yyyy");
		    try
	        {
			  java.util.Date today = dft.parse(regDate);            
	          regDate= dft.format(today);
			} catch (ParseException e)
	        {
	            e.printStackTrace();
	        }
			reg_date_time=regDate+" "+regTime;*/
			
			String dtl_status = "";
			
			order_set_flag=order_set_flag==null?"A":order_set_flag;
			order_set_flag=order_set_flag.equals("null")?"A":order_set_flag;
			order_set_flag=order_set_flag.equals("")?"A":order_set_flag;

			//Get the Order_line_status from OR_ORDER_LINE table for the selected task
			if(!order_status_type.equals("E") ){ // If NOT A MARK error
				//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
				//pstmt = con.prepareStatement("SELECT ORDER_LINE_STATUS,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = ORDER_LINE_STATUS) OR_ORDER_STATUS_TYPE FROM OH_RESTORATIVE_CHART_TASKS A, OR_ORDER_LINE B WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TRMT_CODE=? AND A.TASK_CODE=? AND A.ORDER_ID=B.ORDER_ID AND A.ORDER_LINE_NUM=B.ORDER_LINE_NUM");

				//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				//pstmt = con.prepareStatement("SELECT ORDER_LINE_STATUS,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = ORDER_LINE_STATUS) OR_ORDER_STATUS_TYPE FROM OH_RESTORATIVE_CHART_TASKS A, OR_ORDER_LINE B WHERE A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TRMT_CODE=? AND A.TASK_CODE=? AND A.ORDER_ID=B.ORDER_ID AND A.ORDER_LINE_NUM=B.ORDER_LINE_NUM");
				pstmt = con.prepareStatement("SELECT ORDER_LINE_STATUS,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = ORDER_LINE_STATUS) OR_ORDER_STATUS_TYPE FROM OH_RESTORATIVE_CHART_TASKS A, OR_ORDER_LINE B WHERE A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TRMT_CODE=? AND A.TASK_CODE=? AND A.TASK_SEQ = ? AND A.ORDER_ID=B.ORDER_ID AND A.ORDER_LINE_NUM=B.ORDER_LINE_NUM");
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code);
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				while(rs.next()){
					order_status_type = rs.getString("ORDER_LINE_STATUS");
					or_order_status_type = rs.getString("OR_ORDER_STATUS_TYPE");
				}				
			}

			/*
				status_code = 85 || 60  = [RS] || [CD] (Completed)
				status_code = 55 || 80  = [IR] || [PP] (Partial)
				status_code = 52 [IM] (In Progress)

			*/
			
			/*
			String current_charging_stage="";
			if(or_order_status_type.equals("85") || or_order_status_type.equals("60") || or_order_status_type.equals("55") || or_order_status_type.equals("80") || or_order_status_type.equals("52")){
				if(billing_appl_yn.equals("Y") && !bl_panel_str.equals("")){

					if(or_order_status_type.equals("85") || or_order_status_type.equals("60")){
						call_process_yn	= "Y";
						current_charging_stage="RST";
					}
					else{
						current_charging_stage="REG";
						call_process_yn	= "N";
					}

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
					bill_map.put("service_date",bl_service_date);
					bill_map.put("current_charging_stage",current_charging_stage);
					bill_map.put("login_at_ws_no",client_ip_address);
					bill_map.put("call_process_yn",call_process_yn);

					patient_bill = oh_bean.GeneratePatientBill(bill_map);
					if(patient_bill.equals("SUCCESS")){
						out.println("<script>alert(\"SUCCESS\");</script>");
					}
				}
			}
			*/
			if(order_status_type.equals("E")){

				pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') CUR_DATE_TIME FROM DUAL");
				rs=pstmt.executeQuery();
				while(rs.next()){
					cur_date_time = rs.getString("CUR_DATE_TIME");
				}	
				
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,cur_date_time ,locale,"","",patient_id,encounter_id,patient_class,practitioner_id);

				HashMap patient_dtls_hash	= oh_bean.formatBillingDetails(bill_dtls);

				//PATIENT_DTLS_HASH:===={serv_panel_ind=S, patient_payable=100.0, episode_type=O, bl_panel_str=<NR>DEN001#C# # #P#NAREN#ST21#E#N#1#100, visit_id=1, error_text=, pract_staff_ind=P, total_payable=100.0, charge_based_yn=Y, charged_yn=, service_panel_name=DENTAL REGISTRATION, preapp_yn=N, episode_id=10008442, patient_paid_amt=0.0, excl_incl_ind=E, pat_billed_yn=, serv_panel_code=DEN001}
				

				bl_panel_str =(String) patient_dtls_hash.get("bl_panel_str");
				bl_episode_id =(String) patient_dtls_hash.get("episode_id");
				//bl_encounter_id =(String) patient_dtls_hash.get("encounter_id");
				bl_visit_id =(String) patient_dtls_hash.get("visit_id");
				bl_episode_type =(String) patient_dtls_hash.get("episode_type");
				serv_panel_ind =(String) patient_dtls_hash.get("serv_panel_ind");

				bill_map = new HashMap();
				bill_map.put("facility_id",facility_id);
				bill_map.put("patient_id",patient_id);
				bill_map.put("episode_id",bl_episode_id);
				bill_map.put("encounter_id",encounter_id);
				bill_map.put("visit_id",bl_visit_id);
				bill_map.put("episode_type",bl_episode_type);
				bill_map.put("patient_class",patient_class);
				bill_map.put("surgeon_code",practitioner_id);
				bill_map.put("chart_num",chart_num);
				bill_map.put("chart_line_num",chart_line_num);
				bill_map.put("order_id",order_id);
				bill_map.put("order_line_num",order_line_num);
				bill_map.put("task_code",task_code);
				bill_map.put("task_desc",task_desc);
				bill_map.put("key",order_id);
				bill_map.put("key_line",order_line_num);
				bill_map.put("bl_panel_str",bl_panel_str);
				bill_map.put("service_date",cur_date_time);
				bill_map.put("current_charging_stage","CAN");
				bill_map.put("login_at_ws_no",client_ip_address);
				bill_map.put("call_process_yn","N");
				bill_map.put("serv_panel_ind",serv_panel_ind);

				patient_bill = oh_bean.GeneratePatientBill(bill_map);

				//processed_msg = "CHARGES_FAILED::APP-OH00068";
				//out.println(patient_bill) ;
			}
			
					
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(order_status_type.equals("E")){

				// Update the order_line_status in or_order_line table:
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_DATE_TIME=SYSDATE, CAN_LINE_REASON=?, CAN_PRACT_ID=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
				// Practitioner_id is to be updated for CAN_PRACT_ID instead of login_user
				pstmt.setString(1,reasonforcancel);
				//pstmt.setString(2,login_user); // Pass the ca_practitioner_id
				pstmt.setString(2,practitioner_id); // Pass the ca_practitioner_id
				pstmt.setString(3,login_user); 
				pstmt.setString(4,client_ip_address);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,order_id);
				pstmt.setString(7,order_line_num);
				flag = pstmt.executeUpdate();

				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}

				if(pstmt != null) pstmt.close();
				//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
				//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");

				//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
				pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");

				pstmt_task.setString(1,order_status_type);
				pstmt_task.setString(2,login_user);
				pstmt_task.setString(3,client_ip_address);
				pstmt_task.setString(4,facility_id);
				pstmt_task.setString(5,reasonforcancel); //REASON
				pstmt_task.setString(6,login_user);
				//pstmt_task.setString(7,facility_id);
				pstmt_task.setString(7,patient_id);
				pstmt_task.setString(8,chart_num);
				pstmt_task.setString(9,chart_line_num);
				pstmt_task.setString(10,trmt_code);
				pstmt_task.setString(11,task_code);
				pstmt_task.setString(12,task_seq_no);
				flag = pstmt_task.executeUpdate();
				flag_arr.add(""+flag);

			}else{
				//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
				// Practitioner_id is to be updated for CAN_PRACT_ID instead of login_user
				pstmt.setString(1,order_status_type);
				pstmt.setString(2,login_user); 
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,order_id);
				pstmt.setString(6,order_line_num);
				flag = pstmt.executeUpdate();
				
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}

				if(order_status_type_code.equals("15")){					
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS A SET (SCHEDULE_DATE_TIME,SCHEDULE_REF_NO) = (SELECT APPT_DATE,APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID=? AND ORDER_ID=? AND ORDER_LINE_NUM=?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");

					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS A SET (SCHEDULE_DATE_TIME,SCHEDULE_REF_NO) = (SELECT TO_DATE(TO_CHAR(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(APPT_TIME,' HH24:MI'),'DD/MM/YYYY HH24:MI'),APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID=? AND ORDER_ID=? AND ORDER_LINE_NUM=?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
					//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS A SET (SCHEDULE_DATE_TIME,SCHEDULE_REF_NO) = (SELECT TO_DATE(TO_CHAR(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(APPT_TIME,' HH24:MI'),'DD/MM/YYYY HH24:MI'),APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID=? AND ORDER_ID=? AND ORDER_LINE_NUM=?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");

					//Commented as requested by Dilip on 2/2/2010 by SRidevi Joshi
					/*pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS A SET (SCHEDULE_DATE_TIME,SCHEDULE_REF_NO) = (SELECT TO_DATE(TO_CHAR(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(APPT_TIME,' HH24:MI'),'DD/MM/YYYY HH24:MI'),APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID=? AND ORDER_ID=? AND ORDER_LINE_NUM=?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");

					pstmt_task.setString(1,facility_id);
					pstmt_task.setString(2,order_id);
					pstmt_task.setString(3,order_line_num);
					pstmt_task.setString(4,login_user); 
					pstmt_task.setString(5,client_ip_address);
					pstmt_task.setString(6,facility_id); //MODIFIED_FACILITY_ID
					//pstmt_task.setString(7,facility_id);
					pstmt_task.setString(7,patient_id);
					pstmt_task.setString(8,chart_num);
					pstmt_task.setString(9,chart_line_num);
					pstmt_task.setString(10,trmt_code);
					pstmt_task.setString(11,task_code);
					pstmt_task.setString(12,task_seq_no);
					flag = pstmt_task.executeUpdate();*/
					flag_arr.add(""+flag);
				}
				if(order_status_type_code.equals("25")){ // bcoz order_status_type will be 'RG' at this point ..So we are considering order_status_type_code 
					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, REGN_DATE_TIME = SYSDATE, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
					//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, REGN_DATE_TIME = SYSDATE, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, REGN_DATE_TIME = SYSDATE, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
					pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, REGN_DATE_TIME = to_date(?,'dd/mm/yyyy hh24:mi'), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
					
					pstmt_task.setString(1,order_status_type);// As Taken from OR_ORDER_LINE above.
					pstmt_task.setString(2,reg_date_time);
					pstmt_task.setString(3,login_user);
					pstmt_task.setString(4,client_ip_address);
					pstmt_task.setString(5,facility_id);
					//pstmt_task.setString(5,facility_id);
					pstmt_task.setString(6,patient_id);
					pstmt_task.setString(7,chart_num);
					pstmt_task.setString(8,chart_line_num);
					pstmt_task.setString(9,trmt_code);
					pstmt_task.setString(10,task_code);
					pstmt_task.setString(11,task_seq_no);
				
					flag = pstmt_task.executeUpdate();
					flag_arr.add(""+flag);

					/*Added by Suma for OA incident */
					pstmt_task1 =con.prepareStatement("UPDATE OA_APPT SET APPT_STATUS='A' WHERE FACILITY_ID =? AND APPT_REF_NO=(SELECT SCHEDULE_REF_NO FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?)");

					pstmt_task1.setString(1,facility_id);
					pstmt_task1.setString(2,facility_id);
					pstmt_task1.setString(3,patient_id);
					pstmt_task1.setString(4,chart_num);
					pstmt_task1.setString(5,chart_line_num);
					pstmt_task1.setString(6,trmt_code);
					pstmt_task1.setString(7,task_code);
					pstmt_task1.setString(8,task_seq_no);

					flag1 = pstmt_task1.executeUpdate();

					/*Added by Suma ends here */
				}
				else if(order_status_type_code.equals("85") || order_status_type_code.equals("60") || order_status_type_code.equals("55") || order_status_type_code.equals("80") || order_status_type_code.equals("52")){	
					if(pstmt != null) pstmt.close();
					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt=con.prepareStatement("SELECT (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = ?) STATUS, BILLED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' AND ORDER_ID = ?");
					pstmt=con.prepareStatement("SELECT (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = ?) STATUS, BILLED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' AND ORDER_ID = ?");
					pstmt.setString(1,order_status_type);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,task_code);
					pstmt.setString(7,order_id);
					rs = pstmt.executeQuery();
					while(rs.next()){
						billed_yn = checkForNull(rs.getString("BILLED_YN"));
						task_status_for_billing = checkForNull(rs.getString("STATUS"));
						
						//if(billed_yn.equals("Y") && (task_status_for_billing.equals("85") || task_status_for_billing.equals("60"))){
						//if((!billing_appl_yn.equals("Y")) || (billed_yn.equals("Y") && (task_status_for_billing.equals("85") || task_status_for_billing.equals("60"))) || (!order_catalog_bill_yn.equals("Y") && (task_status_for_billing.equals("85") || task_status_for_billing.equals("60")))){
						if((billing_appl_yn.equals("N") && (task_status_for_billing.equals("85") || task_status_for_billing.equals("60"))) || (billed_yn.equals("Y") && (task_status_for_billing.equals("85") || task_status_for_billing.equals("60"))) || (!order_catalog_bill_yn.equals("Y") && (task_status_for_billing.equals("85") || task_status_for_billing.equals("60")))){

							if(pstmt_task != null) pstmt_task.close();
							sql_buffer_task.append("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60')");

							if(!start_date_time.trim().equals("") && !start_date_time.trim().equals("undefined")){ // Added by Sridevi Joshi on 3/15/2010 for IN019995
								sql_buffer_task.append(", START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS')");
							}
							else{
								sql_buffer_task.append(", START_DATE_TIME = ?");
							}

							if(!end_date_time.trim().equals("") && !end_date_time.trim().equals("undefined")){ // Added by Sridevi Joshi on 3/15/2010 for IN019995
								sql_buffer_task.append(", END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS')");
							}
							else{
								sql_buffer_task.append(", END_DATE_TIME = ?");
							}

							sql_buffer_task.append(", COPIED_YN = 'N', PERFORMED_IN_OT = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");

							index_task = 1;
							pstmt_task=con.prepareStatement(sql_buffer_task.toString());
							pstmt_task.setString(index_task++,start_date_time.trim());
							pstmt_task.setString(index_task++,end_date_time.trim());
							pstmt_task.setString(index_task++,performed_In_OT);
							pstmt_task.setString(index_task++,login_user);
							pstmt_task.setString(index_task++,client_ip_address);
							pstmt_task.setString(index_task++,facility_id);
							pstmt_task.setString(index_task++,patient_id);
							pstmt_task.setString(index_task++,chart_num);
							pstmt_task.setString(index_task++,chart_line_num);
							pstmt_task.setString(index_task++,trmt_code);
							pstmt_task.setString(index_task++,task_code);
							pstmt_task.setString(index_task++,task_seq_no);
							flag = pstmt_task.executeUpdate();

							/*if(!start_date_time.equals("") && !end_date_time.equals("") && !end_date_time.equals("undefined")){
								pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60'), START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), COPIED_YN = 'N', PERFORMED_IN_OT = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
								
								pstmt_task.setString(1,start_date_time);
								pstmt_task.setString(2,end_date_time);
								pstmt_task.setString(3,performed_In_OT);
								pstmt_task.setString(4,login_user);
								pstmt_task.setString(5,client_ip_address);
								pstmt_task.setString(6,facility_id);
								pstmt_task.setString(7,patient_id);
								pstmt_task.setString(8,chart_num);
								pstmt_task.setString(9,chart_line_num);
								pstmt_task.setString(10,trmt_code);
								pstmt_task.setString(11,task_code);
								pstmt_task.setString(12,task_seq_no);
								flag = pstmt_task.executeUpdate();
							}
							else{
								pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60'), COPIED_YN = 'N', PERFORMED_IN_OT = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
								
								pstmt_task.setString(1,performed_In_OT);
								pstmt_task.setString(2,login_user);
								pstmt_task.setString(3,client_ip_address);
								pstmt_task.setString(4,facility_id);
								pstmt_task.setString(5,patient_id);
								pstmt_task.setString(6,chart_num);
								pstmt_task.setString(7,chart_line_num);
								pstmt_task.setString(8,trmt_code);
								pstmt_task.setString(9,task_code);
								pstmt_task.setString(10,task_seq_no);
								flag = pstmt_task.executeUpdate();
							}*/
							flag_arr.add(""+flag);
						}
						else{
							sql_buffer_task.append("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?");

							if(!start_date_time.trim().equals("") && !start_date_time.trim().equals("undefined")){ // Added by Sridevi Joshi on 3/15/2010 for IN019995
								sql_buffer_task.append(", START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS')");
							}
							else{
								sql_buffer_task.append(", START_DATE_TIME = ?");
							}

							if(!end_date_time.trim().equals("") && !end_date_time.trim().equals("undefined")){ // Added by Sridevi Joshi on 3/15/2010 for IN019995
								sql_buffer_task.append(", END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS')");
							}
							else{
								sql_buffer_task.append(", END_DATE_TIME = ?");
							}

							sql_buffer_task.append(", COPIED_YN = 'N', PERFORMED_IN_OT = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");

							index_task = 1;
							pstmt_task=con.prepareStatement(sql_buffer_task.toString());
							pstmt_task.setString(index_task++,order_status_type);// As Taken from OR_ORDER_LINE above.
							pstmt_task.setString(index_task++,start_date_time.trim());
							pstmt_task.setString(index_task++,end_date_time.trim());
							pstmt_task.setString(index_task++,performed_In_OT);
							pstmt_task.setString(index_task++,login_user);
							pstmt_task.setString(index_task++,client_ip_address);
							pstmt_task.setString(index_task++,facility_id);
							pstmt_task.setString(index_task++,patient_id);
							pstmt_task.setString(index_task++,chart_num);
							pstmt_task.setString(index_task++,chart_line_num);
							pstmt_task.setString(index_task++,trmt_code);
							pstmt_task.setString(index_task++,task_code);
							pstmt_task.setString(index_task++,task_seq_no);
							flag = pstmt_task.executeUpdate();

							/*if(!start_date_time.equals("") && !end_date_time.equals("") && !end_date_time.equals("undefined")){
								pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, START_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), COPIED_YN = 'N', PERFORMED_IN_OT = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
								
								pstmt_task.setString(1,order_status_type);// As Taken from OR_ORDER_LINE above.
								pstmt_task.setString(2,start_date_time);
								pstmt_task.setString(3,end_date_time);
								pstmt_task.setString(4,performed_In_OT);
								pstmt_task.setString(5,login_user);
								pstmt_task.setString(6,client_ip_address);
								pstmt_task.setString(7,facility_id);
								pstmt_task.setString(8,patient_id);
								pstmt_task.setString(9,chart_num);
								pstmt_task.setString(10,chart_line_num);
								pstmt_task.setString(11,trmt_code);
								pstmt_task.setString(12,task_code);
								pstmt_task.setString(13,task_seq_no);
								flag = pstmt_task.executeUpdate();
								
							}
							else{
								
								pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', PERFORMED_IN_OT = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
								
								pstmt_task.setString(1,order_status_type);// As Taken from OR_ORDER_LINE above.
								pstmt_task.setString(2,performed_In_OT);
								pstmt_task.setString(3,login_user);
								pstmt_task.setString(4,client_ip_address);
								pstmt_task.setString(5,facility_id);
								pstmt_task.setString(6,patient_id);
								pstmt_task.setString(7,chart_num);
								pstmt_task.setString(8,chart_line_num);
								pstmt_task.setString(9,trmt_code);
								pstmt_task.setString(10,task_code);
								pstmt_task.setString(11,task_seq_no);
								flag = pstmt_task.executeUpdate();
							}*/
							flag_arr.add(""+flag);
						}
					}
				}
				else{
					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
					//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
					//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=?");
					pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");

					pstmt_task.setString(1,order_status_type);// As Taken from OR_ORDER_LINE above.
					pstmt_task.setString(2,login_user);
					pstmt_task.setString(3,client_ip_address);
					pstmt_task.setString(4,facility_id);
					//pstmt_task.setString(5,facility_id);
					pstmt_task.setString(5,patient_id);
					pstmt_task.setString(6,chart_num);
					pstmt_task.setString(7,chart_line_num);
					pstmt_task.setString(8,trmt_code);
					pstmt_task.setString(9,task_code);
					pstmt_task.setString(10,task_seq_no);
					flag = pstmt_task.executeUpdate();
					flag_arr.add(""+flag);
				}
			}
		
			if(!flag_arr.contains("0")){
				frame_msg = "GET_MSG";
				con.commit();
			}else{
				frame_msg = "";
				con.rollback();
			}
			
			if(pstmt != null) pstmt.close();
			if(order_status_type.equals("E")){
				//pstmt = con.prepareStatement("SELECT A.STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND A.STATUS != 'E'");
				//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
				//pstmt = con.prepareStatement("SELECT A.STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND ORDER_ID = ?");
				pstmt = con.prepareStatement("SELECT A.STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND ORDER_ID = ?");
			}
			else{
				//pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','96','99','E') )");
				//pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','96','99')) AND NVL(STATUS,'X') != 'E'");				
				//Above code is modified by bshankar for STATUS column
				//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
				//pstmt = con.prepareStatement("SELECT STATUS, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = STATUS) STATUS_CODE FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','96','99')) AND NVL(STATUS,'X') != 'E' AND ORDER_ID = ?");				
				pstmt = con.prepareStatement("SELECT STATUS, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = STATUS) STATUS_CODE FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','96','99')) AND NVL(STATUS,'X') != 'E' AND ORDER_ID = ?");				
				//pstmt = con.prepareStatement("SELECT STATUS, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = STATUS) STATUS_CODE FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','96','99')) AND NVL(STATUS,'X') != 'E'");				
				//pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','96','99'))");				
			}
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,order_id);
			rs=pstmt.executeQuery();
			int count=0;
			int status_count=0;
			//ArrayList arr_list = new ArrayList();
			while(rs.next()){
				count++;
				status = checkForNull(rs.getString("STATUS"));
				//status_code = checkForNull(rs.getString("STATUS_CODE"));
				//arr_list.add(status_code);
				if(status.equals(order_status_type)){
					status_count++;
				}
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			
			if(count>0 && count==status_count){
				if(order_status_type.equals("E")){
					// Update the order_status in or_order table:
					if(pstmt != null) pstmt.close();
					pstmt = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_REASON=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=?");
					pstmt.setString(1,reasonforcancel);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,order_id);
					flag = pstmt.executeUpdate();
				}
				else{
					if(pstmt != null) pstmt.close();
					pstmt = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = ?, CAN_REASON=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=?");
					pstmt.setString(1,order_status_type);
					pstmt.setString(2,reasonforcancel);
					pstmt.setString(3,login_user);
					pstmt.setString(4,client_ip_address);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,order_id);
					flag = pstmt.executeUpdate();
				}
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
			}
			/*
				status_code = 85 || 60  = [RS] || [CD] (Completed)
				status_code = 55 || 80  = [IR] || [PP] (Partial)
				status_code = 52 [IM] (In Progress)
			*/
			/*
			
			for(int m=0;m<arr_list.size();m++){
				if(arr_list.get(m).equals("85") || arr_list.get(m).equals("60") || arr_list.get(m).equals("55") || arr_list.get(m).equals("80") || arr_list.get(m).equals("52")){
					if(billing_appl_yn.equals("Y") && !bl_panel_str.equals("")){

						if(arr_list.get(m).equals("85") || arr_list.get(m).equals("60")){
							call_process_yn	= "Y";
						}
						else{
							call_process_yn	= "N";
						}

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
						bill_map.put("service_date",bl_service_date);
						bill_map.put("current_charging_stage","RST");
						bill_map.put("login_at_ws_no",client_ip_address);
						bill_map.put("call_process_yn",call_process_yn);

						patient_bill = oh_bean.GeneratePatientBill(bill_map);

						
					}
					
				}
			}
			
			*/
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			//int j=0;
			//map = new HashMap();
			map = new ArrayList();
			
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
				//map.put(j,task_status);
				map.add(task_status);
				//j++;
			}
			int map_size = map.size();

			for(int k=0;k<map_size;k++){
				if(map.get(k).equals("E")){
					mark_error_count++;
				}

				else if(map.get(k).equals("10")){
					outstanding_count++;
				}
				
				else if(map.get(k).equals("15")){
					sch_count++;
				}

				else if(map.get(k).equals("25")){
					register_count++;
				}

				else if(map.get(k).equals("52")){
					progress_count++;
				}

				else if(map.get(k).equals("55")){
					partial_count++;
				}

				else if(map.get(k).equals("85")){
					resulted_RS_count++;
				}

				else if(map.get(k).equals("60")){
					resulted_count++;
				}
			}
			String insert_status_type = "";
			if(mark_error_count == map_size){
				update_error = "Y";
				insert_status_type = "E";
			}
			else if(outstanding_count > 0){
				update_status = "N";
			}
			/*else if((map_size-mark_error_count) == sch_count){
				update_sch = "Y";
				insert_status_type = "15";
			}
			else if((map_size-mark_error_count) == register_count){
				update_register = "Y";
				insert_status_type = "25";
			}
			else if((map_size-mark_error_count) == progress_count){
				update_progress = "Y";
				insert_status_type = "52";
			}
			else if((map_size-mark_error_count) == partial_count){
				update_partial = "Y";
				insert_status_type = "55";
			}
			else if((map_size-mark_error_count) == resulted_count){
				update_resulted = "Y";
				insert_status_type = "60";
				//insert_status_type = "85";
			}
			else if((map_size-mark_error_count) == resulted_RS_count){
				update_resulted = "Y";
				insert_status_type = "85";
			} */
			else if(map.contains("15")){
				update_sch = "Y";
				insert_status_type = "15";
			}
			else if(map.contains("25")){
				update_register = "Y";
				insert_status_type = "25";
			}
			else if(map.contains("52")){
				update_progress = "Y";
				insert_status_type = "52";
			}
			else if(map.contains("55")){
				update_partial = "Y";
				insert_status_type = "55";
			}
			else if(map.contains("60")){
				update_resulted = "Y";
				insert_status_type = "60";
				//insert_status_type = "85";
			}
			else if(map.contains("85")){
				update_resulted = "Y";
				insert_status_type = "85";
			}

			if(update_status != "N" && !insert_status_type.equals("")){
				if(update_error.equals("Y")){
					// Update dtl and order_set
					if(pstmt != null) pstmt.close();
					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE, OPERATING_FACILITY_ID=? WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt.setString(1,order_status_type);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,reasonforcancel);
					pstmt.setString(6,login_user);
					pstmt.setString(7,facility_id);
					pstmt.setString(8,patient_id);
					pstmt.setString(9,chart_num);
					pstmt.setString(10,chart_line_num);
					flag = pstmt.executeUpdate();

					// Update the order_status in or_order table FOR THE ORDER_SET:
					if(pstmt != null) pstmt.close();
					pstmt = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_REASON=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=(SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID=?)");
					pstmt.setString(1,reasonforcancel);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,order_id);
					flag = pstmt.executeUpdate();
					flag_arr.add(""+flag);

					if(!flag_arr.contains("0")){
						con.commit();
					}else{
						con.rollback();
					}	

				}else {
					/*
					if(pstmt != null) pstmt.close();
					pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ?");
					pstmt.setString(1,order_status_type);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,reasonforcancel);
					pstmt.setString(6,login_user);
					pstmt.setString(7,facility_id);
					pstmt.setString(8,patient_id);
					pstmt.setString(9,chart_num);
					pstmt.setString(10,chart_line_num);
					flag = pstmt.executeUpdate();
					*/
					// update only dtl
					if(pstmt != null) pstmt.close();
					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, OPERATING_FACILITY_ID=? WHERE PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt.setString(1,insert_status_type);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,chart_num);
					pstmt.setString(8,order_id);
					flag = pstmt.executeUpdate();
				}
			}

			if(flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
				
			
			/*
			// Update the order_status in or_order table:
			if(pstmt != null) pstmt.close();
			pstmt = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_REASON=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=?");
			pstmt.setString(1,reasonforcancel);
			pstmt.setString(2,login_user);
			pstmt.setString(3,client_ip_address);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,order_id);
			flag = pstmt.executeUpdate();
			flag_arr.add(""+flag);

			// Update the order_line_status in or_order_line table:
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_DATE_TIME=SYSDATE, CAN_LINE_REASON=?, CAN_PRACT_ID=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
			// Practitioner_id is to be updated for CAN_PRACT_ID instead of login_user
			pstmt.setString(1,reasonforcancel);
			pstmt.setString(2,login_user); // Pass the ca_practitioner_id
			pstmt.setString(3,login_user); 
			pstmt.setString(4,client_ip_address);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,order_id);
			pstmt.setString(7,order_line_num);
			flag = pstmt.executeUpdate();
			flag_arr.add(""+flag);

			// Update the order_status in or_order table FOR THE ORDER_SET:
			if(pstmt != null) pstmt.close();
			pstmt = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_REASON=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=(SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID=?)");
			pstmt.setString(1,reasonforcancel);
			pstmt.setString(2,login_user);
			pstmt.setString(3,client_ip_address);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,order_id);
			flag = pstmt.executeUpdate();
			flag_arr.add(""+flag);

			if(!flag_arr.contains("0")){
				con.commit();
			}else{
				con.rollback();
			}	
*/
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			/* qry changed for Mrk error cases */
			//pstmt = con.prepareStatement("SELECT A.STATUS DTL_STATUS, (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(A.STATUS,'X') != 'E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
			//pstmt = con.prepareStatement("SELECT A.STATUS DTL_STATUS, (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			pstmt = con.prepareStatement("SELECT A.STATUS DTL_STATUS, (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				status_dtl = checkForNull(rs.getString("STATUS"));
				dtl_status = checkForNull(rs.getString("DTL_STATUS"));
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			String status_task = "";
			String mark_error_task_status = "";
			/* qry changed for Mrk error cases */
			//pstmt = con.prepareStatement("SELECT A.STATUS DTL_STATUS, (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = ? AND ORDER_LINE_NUM = ? AND NVL(A.STATUS,'X') != 'E' ");
			//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
			//pstmt = con.prepareStatement("SELECT A.STATUS TASK_STATUS, (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = ? AND ORDER_LINE_NUM = ?");
			pstmt = con.prepareStatement("SELECT A.STATUS TASK_STATUS, (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = ? AND ORDER_LINE_NUM = ?");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,order_id);
			pstmt.setString(4,order_line_num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				status_task = checkForNull(rs.getString("STATUS"));
				mark_error_task_status = checkForNull(rs.getString("TASK_STATUS"));
			}
			
			if(dtl_status.equals("E")){
				out.println(dtl_status+"##"+mark_error_task_status+"##"+frame_msg);
			}
			else{
				out.println(status_dtl+"##"+status_task+"##"+frame_msg);
			}
		    
		}
		else if(func_mode.equalsIgnoreCase("updateOrderDetails")){	
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String order_id = checkForNull(request.getParameter( "order_id" )) ;
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;
			//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
			//
			
			String order_set_id = "";
			String status = "";
			String dtl_status = "";
			ArrayList order_id_list = new ArrayList();
			//Hashmap order_id_map = new Hashmap();

			pstmt=con.prepareStatement("SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?");
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				order_set_id = checkForNull(rs.getString("ORDER_SET_ID"));
			}

			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();

			//pstmt=con.prepareStatement("SELECT ORDER_ID,ORDER_CATALOG_CODE FROM OR_ORDER_LINE WHERE ORDER_SET_ID = ? ORDER BY ORDER_ID");
			//TO_CHAR(APPT_DATE_TIME,'DD/MM/YYYY HH24:MI')
			//pstmt=con.prepareStatement("SELECT A.ORDER_ID,B.ORDER_LINE_NUM, B.ORDER_CATALOG_CODE, B.APPT_REQD_YN, B.APPT_DATE_TIME, B.APPT_REF_NUM FROM OR_ORDER A, OR_ORDER_LINE B WHERE A.ORDER_SET_ID = ? AND  A.ORDER_ID = B.ORDER_ID ORDER BY B.ORDER_ID,B.ORDER_LINE_NUM");
			//pstmt=con.prepareStatement("SELECT A.ORDER_ID,B.ORDER_LINE_NUM, B.ORDER_CATALOG_CODE, B.APPT_REQD_YN, TO_DATE(TO_CHAR(B.APPT_DATE_TIME,'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI') APPT_DATE_TIME, B.APPT_REF_NUM FROM OR_ORDER A, OR_ORDER_LINE B WHERE A.ORDER_SET_ID = ? AND  A.ORDER_ID = B.ORDER_ID ORDER BY B.ORDER_ID,B.ORDER_LINE_NUM");
			pstmt=con.prepareStatement("SELECT A.ORDER_ID,B.ORDER_LINE_NUM, B.ORDER_CATALOG_CODE, B.APPT_REQD_YN, TO_CHAR(B.APPT_DATE_TIME,'YYYY/MM/DD HH24:MI') APPT_DATE_TIME, B.APPT_REF_NUM FROM OR_ORDER A, OR_ORDER_LINE B WHERE A.ORDER_SET_ID = ? AND  A.ORDER_ID = B.ORDER_ID ORDER BY B.ORDER_ID,B.ORDER_LINE_NUM");
			pstmt.setString(1,order_set_id);
			rs=pstmt.executeQuery();
			//String order_catalog_task_code = "";
			//Hashmap temp_map = null;
			String APPT_REQD_YN = "";
			String APPT_DATE_TIME = "";
			String APPT_REF_NUM = "";
			while(rs.next()){
				/*
				temp_map = new Hashmap();
				//order_set_id = checkForNull(rs.getString("ORDER_SET_ID"));
				//order_id_list.add(checkForNull(rs.getString("ORDER_ID")));
				order_catalog_task_code = rs.getString("TASK_CODE");
				temp_map.put("ORDER_ID",rs.getString("ORDER_ID"));
				temp_map.put("ORDER_LINE_NUM",rs.getString("ORDER_LINE_NUM"));
				order_id_map.put(order_catalog_code,temp_map);
				*/
				APPT_REQD_YN = rs.getString("APPT_REQD_YN");
				APPT_DATE_TIME = rs.getString("APPT_DATE_TIME");
				APPT_REF_NUM = rs.getString("APPT_REF_NUM");
				order_id_list.add(rs.getString("ORDER_ID"));
				order_id_list.add(rs.getString("ORDER_LINE_NUM"));
				order_id_list.add(rs.getString("ORDER_CATALOG_CODE"));
				order_id_list.add(rs.getString("APPT_REQD_YN"));
				order_id_list.add(rs.getString("APPT_DATE_TIME"));
				order_id_list.add(rs.getString("APPT_REF_NUM"));

				//order_id_list.add(order_catalog_task_code);
			}
			//Commented by Sharon Crasta on 3/18/2009 for CRF #0423
			//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET ORDER_ID = ?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?),COMPLETE_ON_ORDER_YN=(SELECT NVL(COMPLETE_ON_ORDER_YN,'N') FROM OR_ORDER WHERE ORDER_ID = ?), COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET ORDER_ID = ?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?),COMPLETE_ON_ORDER_YN=(SELECT NVL(COMPLETE_ON_ORDER_YN,'N') FROM OR_ORDER WHERE ORDER_ID = ?), COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'");

			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET ORDER_ID = ?, ORDER_LINE_NUM=SEQ_NO,STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?) WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=?");

			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=(SELECT B.ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_TASKS A, OR_ORDER_LINE B, OH_TASKS C WHERE B.ORDER_ID=? AND A.TASK_CODE = C.TASK_CODE AND B.ORDER_CATALOG_CODE = NVL(C.ORDER_CATALOG_CODE,B.ORDER_CATALOG_CODE) AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TRMT_CODE=? AND A.TASK_CODE = D.TASK_CODE), STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?) WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=?");
			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?) WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=(SELECT TASK_CODE FROM OH_TASKS WHERE ORDER_CATALOG_CODE = ? AND ROWNUM=1)");
			//Commented by Sharon Crasta on 3/18/2009 for CRF #0423
			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?), APPT_REQD_YN = NVL(?,'N'), COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=(SELECT TASK_CODE FROM OH_TASKS WHERE ORDER_CATALOG_CODE = ?)");
			//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?), APPT_REQD_YN = NVL(?,'N'),SCHEDULE_DATE_TIME = TO_CHAR(?,'DD/MM/YYYY'), SCHEDULE_REF_NO = ?, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=(SELECT TASK_CODE FROM OH_TASKS WHERE ORDER_CATALOG_CODE = ?)");
			pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?), APPT_REQD_YN = NVL(?,'N'),SCHEDULE_DATE_TIME = TO_DATE(?,'YYYY/MM/DD HH24:MI'), SCHEDULE_REF_NO = ?, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=(SELECT TASK_CODE FROM OH_TASKS WHERE ORDER_CATALOG_CODE = ?)");
			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?), APPT_REQD_YN = NVL(?,'N'), COPIED_YN = 'N', SCHEDULE_REF_NO = ? WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=(SELECT TASK_CODE FROM OH_TASKS WHERE ORDER_CATALOG_CODE = ?)");
			//pstmt_task=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS D SET ORDER_ID = ?, ORDER_LINE_NUM=?, STATUS=(SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID = ?), APPT_REQD_YN = NVL(?,'N'), COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=(SELECT TASK_CODE FROM OH_TASKS WHERE ORDER_CATALOG_CODE = ?) AND SEQ_NO =?");

			int count = Integer.parseInt(tooth_range_count);
			if(count==0){
				pstmt.setString(1,order_set_id);
				pstmt.setString(2,order_id);
				pstmt.setString(3,order_id);
				//pstmt.setString(4,facility_id);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_num);
				//pstmt.setString(6,chart_num);
				pstmt.setString(6,chart_line_num);
				flag = pstmt.executeUpdate();

				/*
				pstmt_task.setString(1,order_id);
				//NEWLY ADDED FOR ORDER_LINE_NUM UPDATION
				pstmt_task.setString(2,order_id);
				pstmt_task.setString(3,facility_id);
				pstmt_task.setString(4,patient_id);
				pstmt_task.setString(5,chart_num);
				pstmt_task.setString(6,chart_line_num);
				pstmt_task.setString(7,trmt_code);
				// NEW CODE TILL HERE
				pstmt_task.setString(8,order_id);
				pstmt_task.setString(9,facility_id);
				pstmt_task.setString(10,patient_id);
				pstmt_task.setString(11,chart_num);
				pstmt_task.setString(12,chart_line_num);
				pstmt_task.setString(13,trmt_code);
				flag = pstmt_task.executeUpdate();
				*/

				for(int k=0;k<order_id_list.size();k+=6){
					pstmt_task.setString(1,(String)order_id_list.get(k)); // order_id
					pstmt_task.setString(2,(String)order_id_list.get(k+1)); // order_line_num
					pstmt_task.setString(3,(String)order_id_list.get(k)); // order_id
					pstmt_task.setString(4,(String)order_id_list.get(k+3)); // APPT_REQD_YN
					pstmt_task.setString(5,(String)order_id_list.get(k+4)); // APPT_REQD_YN
					pstmt_task.setString(6,(String)order_id_list.get(k+5)); // APPT_REQD_YN
					pstmt_task.setString(7,patient_id);
					pstmt_task.setString(8,chart_num);
					pstmt_task.setString(9,chart_line_num);
					pstmt_task.setString(10,trmt_code);
					pstmt_task.setString(11,(String)order_id_list.get(k+2)); // ORDER_CATALOG_CODE
					flag = pstmt_task.executeUpdate();
				}
			}else{
				// In case of Tooth_Range pass the chart_line_num of the 1st Record.
				if(rs != null) rs.close();
				//Commented by Sharon Crasta on 3/18/2009 for CRF #0423
				//pstmt_range=con.prepareStatement("SELECT TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt_range=con.prepareStatement("SELECT TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'");
				//pstmt_range.setString(1,facility_id);
				pstmt_range.setString(1,patient_id);
				pstmt_range.setString(2,chart_num);
				pstmt_range.setString(3,chart_line_num);
				rs = pstmt_range.executeQuery();
				while(rs.next()){
					tooth_range = rs.getString("TOOTH_RANGE");
				}
				int ind = tooth_range.indexOf("$$");
				if(ind != -1){
					chart_line_num = tooth_range.substring(0,ind);
				}
				//tooth_range_arr = tooth_range.split(",");
				
				//tooth_range_chart_line_num_arr = tooth_range_arr[0].split("$$");

				//chart_line_num = tooth_range_chart_line_num_arr[0];

				chart_line_num_int = Integer.parseInt(chart_line_num);
				
				for(int i=1;i<=count;i++){
					pstmt.setString(1,order_set_id);
					pstmt.setString(2,order_id);
					pstmt.setString(3,order_id);
					pstmt.setString(4,patient_id);
					pstmt.setString(5,chart_num);
					pstmt.setInt(6,chart_line_num_int);
					flag = pstmt.executeUpdate();

					/*
					pstmt_task.setString(1,order_id);				
					//NEWLY ADDED FOR ORDER_LINE_NUM UPDATION
					pstmt_task.setString(2,order_id);
					pstmt_task.setString(3,facility_id);
					pstmt_task.setString(4,patient_id);
					pstmt_task.setString(5,chart_num);
					pstmt_task.setString(6,chart_line_num);
					pstmt_task.setString(7,trmt_code);
					// NEW CODE TILL HERE
					pstmt_task.setString(8,order_id);
					pstmt_task.setString(9,facility_id);
					pstmt_task.setString(10,patient_id);
					pstmt_task.setString(11,chart_num);
					pstmt_task.setInt(12,chart_line_num_int);
					pstmt_task.setString(13,trmt_code);
					flag = pstmt_task.executeUpdate();	
					*/
				
					for(int k=0;k<order_id_list.size();k+=6){
						pstmt_task.setString(1,(String)order_id_list.get(k)); // order_id
						pstmt_task.setString(2,(String)order_id_list.get(k+1)); // order_line_num
						pstmt_task.setString(3,(String)order_id_list.get(k)); // order_id
						pstmt_task.setString(4,(String)order_id_list.get(k+3)); // APPT_REQD_YN
						pstmt_task.setString(5,(String)order_id_list.get(k+4)); // APPT_REQD_YN
						pstmt_task.setString(6,(String)order_id_list.get(k+5)); // APPT_REQD_YN
						pstmt_task.setString(7,patient_id);
						pstmt_task.setString(8,chart_num);
						pstmt_task.setInt(9,chart_line_num_int);
						pstmt_task.setString(10,trmt_code);
						pstmt_task.setString(11,(String)order_id_list.get(k+2)); // ORDER_CATALOG_CODE
						flag = pstmt_task.executeUpdate();
					}
					/*
					for(int k=0;k<order_id_list.size();k+=4){
						pstmt_task.setString(1,(String)order_id_list.get(k)); // order_id
						pstmt_task.setString(2,(String)order_id_list.get(k+1)); // order_line_num
						pstmt_task.setString(3,(String)order_id_list.get(k)); // order_id
						pstmt_task.setString(4,(String)order_id_list.get(k+3)); // APPT_REQD_YN
						//pstmt_task.setString(5,facility_id);
						pstmt_task.setString(5,patient_id);
						pstmt_task.setString(6,chart_num);
						pstmt_task.setInt(7,chart_line_num_int);
						pstmt_task.setString(8,trmt_code);
						pstmt_task.setString(9,(String)order_id_list.get(k+2)); // ORDER_CATALOG_CODE
						flag = pstmt_task.executeUpdate();
					}*/

					chart_line_num_int++;
				}
			}
			//if -  else condition added by Sridevi joshi on 29/01/06
			if(flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
		 	//Commented by Sharon Crasta on 3/18/2009 for CRF #0423
			//pstmt=con.prepareStatement("SELECT A.STATUS DTL_STATUS, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS,TRMT_CATEGORY_TYPE,SITE_TYPE,TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM=? AND NVL(A.COND_CLOSED_YN,'N') = 'N'");

			pstmt=con.prepareStatement("SELECT A.STATUS DTL_STATUS, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS,TRMT_CATEGORY_TYPE,SITE_TYPE,TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM=? AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				status = rs.getString("STATUS");
				dtl_status = rs.getString("DTL_STATUS");
			}

			if(dtl_status.equals("E")){
				out.println(dtl_status);
			}
			else{
				out.println(status);
			}

		}
		else if(func_mode.equalsIgnoreCase("getOrderCatalogDetails")){	
			String order_catalog_code = "";
			String order_type_code = "";
			String treatment_code = request.getParameter("trmt_code");

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT A.ORDER_CATALOG_CODE, A.ORDER_TYPE_CODE FROM OR_ORDER_CATALOG A, OH_TREATMENT B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND B.TRMT_CODE=?");
			pstmt.setString(1,treatment_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				order_catalog_code = rs.getString("ORDER_CATALOG_CODE");
				order_type_code = rs.getString("ORDER_TYPE_CODE");
			}
			out.println(order_catalog_code +"##"+order_type_code);
		}
		else if(func_mode.equalsIgnoreCase("getTasks")){	
			String tasks_yn = "N";
			String trmt_code = request.getParameter("trmt_code");

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT TASK_CODE, SEQ_NO FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ? ORDER BY SEQ_NO");
			pstmt.setString(1,trmt_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				tasks_yn = "Y";
			}
			out.println(tasks_yn);
		}
		else if(func_mode.equalsIgnoreCase("populateTrmtCatTypeDesc")){	
			String trmt_category_type_desc = "";
			String trmt_category_type = request.getParameter("trmt_category_type");

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE TRMT_CATEGORY_TYPE = ?");
			pstmt.setString(1,trmt_category_type);

			rs = pstmt.executeQuery();
			while(rs.next()){
				trmt_category_type_desc = rs.getString("TRMT_CATEGORY_TYPE_DESC");
			}
			out.println(trmt_category_type_desc);
		}
		else if(func_mode.equalsIgnoreCase("insertDiagnosis")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String trmt_chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String trmt_chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String term_set_id = checkForNull(request.getParameter( "term_set_id" )) ;
			String term_code = checkForNull(request.getParameter( "term_code" )) ;
			String occur_srl_no = checkForNull(request.getParameter( "occur_srl_no" )) ;
			
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;

			trmt_chart_line_num=trmt_chart_line_num==null?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("null")?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("")?"1":trmt_chart_line_num;
		
			int diag_count = Integer.parseInt(tooth_range_count);
			int diag_chart_line_num_int = Integer.parseInt(trmt_chart_line_num);
			int diag_flag = 0;

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			//pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG (OPERATING_FACILITY_ID,PATIENT_ID,ENCOUNTER_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,TERM_SET_ID,DIAG_CODE,OCCUR_SRL_NO,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

			// Status is assigned as NULL
			//pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG (OPERATING_FACILITY_ID,PATIENT_ID,ENCOUNTER_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,TERM_SET_ID,DIAG_CODE,OCCUR_SRL_NO,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG (OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, TRMT_CHART_NUM, TRMT_CHART_LINE_NUM, TRMT_CODE, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,NULL,?,SYSDATE,?,?,?,SYSDATE,?,?)");

			if(diag_count == 0){
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,term_set_id);
				pstmt.setString(4,term_code);
				pstmt.setString(5,occur_srl_no);
				pstmt.setString(6,trmt_chart_num);
				pstmt.setString(7,trmt_chart_line_num);
				pstmt.setString(8,trmt_code);
				pstmt.setString(9,login_user);
				pstmt.setString(10,client_ip_address);
				pstmt.setString(11,facility_id);
				pstmt.setString(12,login_user);
				pstmt.setString(13,client_ip_address);
				pstmt.setString(14,facility_id);
				diag_flag = pstmt.executeUpdate();
			}
			else{
				for(int j=1;j<=diag_count;j++){
					trmt_chart_line_num = diag_chart_line_num_int+"";
					/*
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,encounter_id);
					pstmt.setString(4,chart_num);
					pstmt.setString(5,chart_line_num);
					pstmt.setString(6,trmt_code);
					pstmt.setString(7,term_set_id);
					pstmt.setString(8,term_code);
					pstmt.setString(9,occur_srl_no);
					//pstmt.setString(10,diag_status);
					pstmt.setString(10,login_user);
					pstmt.setString(11,client_ip_address);
					pstmt.setString(12,facility_id);
					pstmt.setString(13,login_user);
					pstmt.setString(14,client_ip_address);
					pstmt.setString(15,facility_id);
					*/
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,term_set_id);
					pstmt.setString(4,term_code);
					pstmt.setString(5,occur_srl_no);
					pstmt.setString(6,trmt_chart_num);
					pstmt.setString(7,trmt_chart_line_num);
					pstmt.setString(8,trmt_code);
					pstmt.setString(9,login_user);
					pstmt.setString(10,client_ip_address);
					pstmt.setString(11,facility_id);
					pstmt.setString(12,login_user);
					pstmt.setString(13,client_ip_address);
					pstmt.setString(14,facility_id);
					diag_flag = pstmt.executeUpdate();

					diag_chart_line_num_int++;
				}
			}
			
			
			if(diag_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
			out.println(diag_flag);
		}
		
		/*
		else if(func_mode.equalsIgnoreCase("insertMaterialsUsed")){	

			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
		    String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String term_set_id = checkForNull(request.getParameter( "term_set_id" )) ;
			String composition_class_code= checkForNull(request.getParameter( "composition_class" ));
			String composition_code= checkForNull(request.getParameter( "composition_code" ));
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;

			int mat_count = Integer.parseInt(tooth_range_count);
			int mat_chart_line_num_int = Integer.parseInt(chart_line_num);
			int mat_flag = 0;
		    if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			
			pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_MATRL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,COMPOSITION_CLASS_CODE,COMPOSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			if(mat_count == 0){
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
                pstmt.setString(6,composition_class_code);
                pstmt.setString(7,composition_code);
				pstmt.setString(8,login_user);
				pstmt.setString(9,client_ip_address);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,login_user);
				pstmt.setString(12,client_ip_address);
				pstmt.setString(13,facility_id);
				mat_flag = pstmt.executeUpdate();
				}
				else{
				for(int j=1;j<=mat_count;j++){
					chart_line_num = mat_chart_line_num_int+"";
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,composition_class_code);
					pstmt.setString(7,composition_code);
					pstmt.setString(8,login_user);
					pstmt.setString(9,client_ip_address);
					pstmt.setString(10,facility_id);
					pstmt.setString(11,login_user);
					pstmt.setString(12,client_ip_address);
					pstmt.setString(13,facility_id);
					mat_flag = pstmt.executeUpdate();
					mat_chart_line_num_int++;
				}
			}
            if(mat_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
		}*/
        else if(func_mode.equalsIgnoreCase("getCompositioncode")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
            String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String composition_class = checkForNull(request.getParameter( "composition_class" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code = checkForNull(request.getParameter( "task_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			String sql				= "";	
			String composition_code = "";
			String composition_desc = "";
			StringBuffer composition_code_db = new StringBuffer();
			if(oh_chart_level.equals("E")){
				sql = "SELECT A.COMPOSITION_CODE,(SELECT B.COMPOSITION_DESC FROM OH_COMPOSITION B WHERE A.COMPOSITION_CLASS_CODE= B.COMPOSITION_CLASS_CODE AND B.COMPOSITION_CODE = A.COMPOSITION_CODE) COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A WHERE A.PATIENT_ID = ?  AND A.COMPOSITION_CLASS_CODE = ? AND  A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE =? AND A.TASK_CODE = ? AND TASK_SEQ = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,composition_class);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,task_code);
				pstmt.setString(7,seq_no);
				rs = pstmt.executeQuery();
			}
			else{
				sql = "SELECT A.COMPOSITION_CODE,(SELECT B.COMPOSITION_DESC FROM OH_COMPOSITION B WHERE A.COMPOSITION_CLASS_CODE= B.COMPOSITION_CLASS_CODE AND B.COMPOSITION_CODE = A.COMPOSITION_CODE) COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.COMPOSITION_CLASS_CODE = ? AND  A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE =? AND A.TASK_CODE = ? AND TASK_SEQ = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,composition_class);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,chart_line_num);
				pstmt.setString(6,trmt_code);
				pstmt.setString(7,task_code);
				pstmt.setString(8,seq_no);
				rs = pstmt.executeQuery();
			}
			while(rs!= null && rs.next()){
				composition_code = checkForNull(rs.getString("COMPOSITION_CODE"));
				composition_desc = checkForNull(rs.getString("COMPOSITION_DESC"));
				composition_code_db.append(composition_code+"$$"+composition_desc);
				composition_code_db.append("~");
			}
			out.println(composition_code_db);
		}

		else if(func_mode.equalsIgnoreCase("populateDiagRecorded")){	
			String diag_code = "";
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
			String trmt_code = request.getParameter("trmt_code");
			String oh_chart_level = request.getParameter("oh_chart_level");
			String other_chart_facility_id = request.getParameter("other_chart_facility_id");
			StringBuffer diag_code_buff = new StringBuffer();

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			//pstmt=con.prepareStatement("SELECT DIAG_CODE FROM OH_RESTORATIVE_CHART_DIAG WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TRMT_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? ORDER BY DIAG_CODE");
			if (oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT TERM_CODE FROM OH_RESTORATIVE_CHART_DIAG WHERE  PATIENT_ID = ? AND TRMT_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? ORDER BY TERM_CODE");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,trmt_code);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			rs = pstmt.executeQuery();
			}else{
			
			pstmt=con.prepareStatement("SELECT TERM_CODE FROM OH_RESTORATIVE_CHART_DIAG WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TRMT_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? ORDER BY TERM_CODE");
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,trmt_code);
			pstmt.setString(4,chart_num);
			pstmt.setString(5,chart_line_num);
			rs = pstmt.executeQuery();
			
			}
			while(rs.next()){
				diag_code = rs.getString("TERM_CODE");
				diag_code_buff.append(diag_code);
				diag_code_buff.append("##");
			}
			out.println(diag_code_buff);
		}

		else if(func_mode.equalsIgnoreCase("populateComposition")){	
			String composition_class_code = checkForNull(request.getParameter( "composition_class_code" )) ;
			String sql				= "";
			String composition_code = "";
			String composition_desc = "";
			StringBuffer composition_desc_val = new StringBuffer();
			
			sql = "SELECT COMPOSITION_CODE, COMPOSITION_DESC FROM OH_COMPOSITION WHERE COMPOSITION_CLASS_CODE= ? AND NVL(EFF_STATUS,'E')='E'";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,composition_class_code);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				composition_code = rs.getString("COMPOSITION_CODE");
				composition_desc = rs.getString("COMPOSITION_DESC");
				composition_desc_val.append(composition_code+"##"+composition_desc);
				composition_desc_val.append("~");
			}
			out.println(composition_desc_val);
		}
		else if(func_mode.equalsIgnoreCase("deleteDiagRecorded")){	
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String trmt_code = request.getParameter("trmt_code");
			String diag_code = request.getParameter("diag_code");
			String term_set_id = request.getParameter("term_set_id");
			String chart_line_num = request.getParameter("chart_line_num");
			String tooth_count = request.getParameter("tooth_count");
			String other_chart_facility_id = request.getParameter("other_chart_facility_id");
			String oh_chart_level = request.getParameter("oh_chart_level");

			tooth_count=tooth_count==null?"0":tooth_count;
			tooth_count=tooth_count.equals("null")?"0":tooth_count;
			tooth_count=tooth_count.equals("")?"0":tooth_count;
			
			int diag_count = Integer.parseInt(tooth_count);
			int diag_chart_line_num_int = Integer.parseInt(chart_line_num);
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DIAG WHERE PATIENT_ID = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TERM_CODE = ? AND TERM_SET_ID = ?");
			if(diag_count == 0){
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,diag_code);
				pstmt.setString(6,term_set_id);
				flag = pstmt.executeUpdate();
			}
			else{
				for(int j=1;j<=diag_count;j++){
					chart_line_num = diag_chart_line_num_int+"";
					//pstmt.setString(1,facility_id);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,trmt_code);
					pstmt.setString(5,diag_code);
					pstmt.setString(6,term_set_id);
					flag = pstmt.executeUpdate();

					diag_chart_line_num_int++;
				}
			}
			}else{
			pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DIAG WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TERM_CODE = ? AND TERM_SET_ID = ?");
			if(diag_count == 0){
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,diag_code);
				pstmt.setString(7,term_set_id);
				flag = pstmt.executeUpdate();
			}
			else{
				for(int j=1;j<=diag_count;j++){
					chart_line_num = diag_chart_line_num_int+"";
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,diag_code);
					pstmt.setString(7,term_set_id);
					flag = pstmt.executeUpdate();

					diag_chart_line_num_int++;
				}
			}
			
		}
			
			if(flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			out.println(flag);
		}
		else if(func_mode.equalsIgnoreCase("deleteCompRecorded")){	
			//String composition_code = "";
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
            String trmt_code = request.getParameter("trmt_code");
            String task_code = request.getParameter("task_code_req");
			String composition_class_code = request.getParameter("composition_class_code");
			String composition_seq_no = request.getParameter("composition_seq_no");
			String composition_code = request.getParameter("composition_code");
			String oh_chart_level = request.getParameter("oh_chart_level");
			String other_chart_facility_id = request.getParameter("other_chart_facility_id");
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;
            int mat_count = Integer.parseInt(tooth_range_count);
			int mat_chart_line_num_int = Integer.parseInt(chart_line_num);
			int mat_flag = 0;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_MATRL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND COMPOSITION_CLASS_CODE = ? AND  COMPOSITION_CODE = ? AND COMPOSITION_SEQ_NO = ? AND TASK_SEQ = ?");
				if(mat_count == 0){
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,trmt_code);
					pstmt.setString(5,task_code);
					pstmt.setString(6,composition_class_code);
					pstmt.setString(7,composition_code);
					pstmt.setString(8,composition_seq_no);
					pstmt.setString(9,seq_no);
					mat_flag = pstmt.executeUpdate();
				}
				else{
					for(int j=1;j<=mat_count;j++){
						chart_line_num = mat_chart_line_num_int+"";

						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,chart_line_num);
						pstmt.setString(4,trmt_code);
						pstmt.setString(5,task_code);
						pstmt.setString(6,composition_class_code);
						pstmt.setString(7,composition_code);
						pstmt.setString(8,composition_seq_no);
						pstmt.setString(9,seq_no);
						mat_flag = pstmt.executeUpdate();
						mat_chart_line_num_int++;
					}
				}
			}
			else{
				pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_MATRL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND COMPOSITION_CLASS_CODE = ? AND  COMPOSITION_CODE = ? AND COMPOSITION_SEQ_NO = ? AND TASK_SEQ = ?");
				if(mat_count == 0){
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,task_code);
					pstmt.setString(7,composition_class_code);
					pstmt.setString(8,composition_code);
					pstmt.setString(9,composition_seq_no);
					pstmt.setString(10,seq_no);
					mat_flag = pstmt.executeUpdate();
				}
				else{
					for(int j=1;j<=mat_count;j++){
						chart_line_num = mat_chart_line_num_int+"";
						pstmt.setString(1,other_chart_facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,chart_line_num);
						pstmt.setString(5,trmt_code);
						pstmt.setString(6,task_code);
						pstmt.setString(7,composition_class_code);
						pstmt.setString(8,composition_code);
						pstmt.setString(9,composition_seq_no);
						pstmt.setString(10,seq_no);
						mat_flag = pstmt.executeUpdate();
						mat_chart_line_num_int++;
					}
				}
			}
			
			if(mat_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(flag);
		}
		else if(func_mode.equalsIgnoreCase("updateTrmtDtlEntry")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" ));
			String chart_num	= checkForNull(request.getParameter( "chart_num" ));
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" ));
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" ));
			String task_code	= checkForNull(request.getParameter( "task_code_req" ));
			String trmt_dtls_entry_cmpl_yn	= checkForNull(request.getParameter( "trmt_dtls_entry_cmpl_yn" ));
			String oh_chart_level = request.getParameter("oh_chart_level");
			String other_chart_facility_id = request.getParameter("other_chart_facility_id");
			
			//Added	by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			String seq_no =  checkForNull(request.getParameter( "seq_no" ));
			//
          	String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;
            
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			int mat_count = Integer.parseInt(tooth_range_count);
			int mat_chart_line_num_int = Integer.parseInt(chart_line_num);
			int mat_flag = 0;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			if(oh_chart_level.equals("E")){
				//Added TASK_SEQ by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET TRMT_DTLS_ENTRY_CMPL_YN = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
				
				if(mat_count == 0){
					pstmt.setString(1,trmt_dtls_entry_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,chart_num);
					pstmt.setString(7,chart_line_num);
					pstmt.setString(8,trmt_code);
					pstmt.setString(9,task_code);
					pstmt.setString(10,seq_no);
					mat_flag = pstmt.executeUpdate();
						
				}else{
					for(int j=1;j<=mat_count;j++){
					chart_line_num = mat_chart_line_num_int+"";
					pstmt.setString(1,trmt_dtls_entry_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,chart_num);
					pstmt.setString(7,chart_line_num);
					pstmt.setString(8,trmt_code);
					pstmt.setString(9,task_code);
					pstmt.setString(10,seq_no);
						mat_flag = pstmt.executeUpdate();
						mat_chart_line_num_int++;
					}
				}
			}else{
				//Added TASK_SEQ by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET TRMT_DTLS_ENTRY_CMPL_YN = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
				
				if(mat_count == 0){
					pstmt.setString(1,trmt_dtls_entry_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,other_chart_facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,chart_num);
					pstmt.setString(8,chart_line_num);
					pstmt.setString(9,trmt_code);
					pstmt.setString(10,task_code);
					pstmt.setString(11,seq_no);
					mat_flag = pstmt.executeUpdate();
						
				}else{
					for(int j=1;j<=mat_count;j++){
					chart_line_num = mat_chart_line_num_int+"";
					pstmt.setString(1,trmt_dtls_entry_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,other_chart_facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,chart_num);
					pstmt.setString(8,chart_line_num);
					pstmt.setString(9,trmt_code);
					pstmt.setString(10,task_code);
					pstmt.setString(11,seq_no);
						mat_flag = pstmt.executeUpdate();
						mat_chart_line_num_int++;
					}
				}
			}
            if(mat_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(mat_flag);
		}
		else if(func_mode.equalsIgnoreCase("getStatusOfPrevTask")){	
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
			String trmt_code = request.getParameter("trmt_code");
			String billing_appl_yn = request.getParameter("billing_appl_yn");
			String task_seq_no = request.getParameter("task_seq_no");//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
			String treatment_status_param = request.getParameter("treatment_status_param");//yadav
			String all_treatment_status="";
			String billed_yn = "N";
			String task_status = "";
			String prev_task_resulted_yn = "Y";
			String order_catalog_billable_yn = "";
					
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			

			
			pstmt=con.prepareStatement("SELECT A.BILL_YN ORDER_CATALOG_BILLABLE_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = STATUS) STATUS, NVL(B.BILLED_YN,'N') BILLED_YN FROM OH_RESTORATIVE_CHART_TASKS B, OR_ORDER_LINE A WHERE B.TASK_SEQ < ? AND B.PATIENT_ID = ? AND B.CHART_NUM = ? AND B.CHART_LINE_NUM = ? AND B.TRMT_CODE = ?  AND NVL(B.STATUS,'X') != 'E' AND A.ORDER_ID = B.ORDER_ID AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM  ORDER BY B.TASK_SEQ");

			pstmt.setString(1,task_seq_no);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			pstmt.setString(5,trmt_code);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				task_status = checkForNull(rs.getString("STATUS"));
				billed_yn = checkForNull(rs.getString("BILLED_YN"));
				order_catalog_billable_yn = checkForNull(rs.getString("ORDER_CATALOG_BILLABLE_YN"));
			}
			
			//if( billing_appl_yn.equals("N") || ((task_status.equals("") || (task_status.equals("60") && billed_yn.equals("Y")) || (task_status.equals("60") && order_catalog_billable_yn.equals("N"))) || order_catalog_billable_yn.equals("N"))){ //order_catalog_billable_yn will be 'N' for non-billable order catalog

			pstmt=con.prepareStatement("SELECT 'X' FROM OH_RESTORATIVE_CHART_TASKS B WHERE B.TASK_SEQ < ? AND B.PATIENT_ID =? AND B.CHART_NUM = ? AND B.CHART_LINE_NUM = ? AND B.TRMT_CODE = ? AND NVL(B.STATUS,'X') != 'E' and NVL(B.STATUS,'X') in ('OS','AB') ");

			
			pstmt.setString(1,task_seq_no);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			pstmt.setString(5,trmt_code);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				all_treatment_status = checkForNull(rs.getString(1));
							
			}

			//Commented and Added by Yadav for SRR20056-CRF-443 on 1/25/2010
			//if( billing_appl_yn.equals("N") || ((task_status.equals("") || (task_status.equals("60") && billed_yn.equals("Y")) || (task_status.equals("60") && order_catalog_billable_yn.equals("N"))))){ //order_catalog_billable_yn will be 'N' for non-billable order catalog
			if(!all_treatment_status.equals("X")){
			if(Integer.parseInt(treatment_status_param) == 10 || Integer.parseInt(treatment_status_param) == 15){
				//if( billing_appl_yn.equals("N") || ((task_status.equals("") || (task_status.equals("25") && billed_yn.equals("Y")) || (task_status.equals("25") && order_catalog_billable_yn.equals("N"))))){ //order_catalog_billable_yn will be 'N' for non-billable order catalog
				//Commented by Sharon Crasta on 2/5/2010 for SRR20056-CRF-443
				//billing_appl_yn.equals("N") check is removed because when Interface to Billing is unchecked, then also registration should be done sequentially.
				//	if( billing_appl_yn.equals("N") || ((task_status.equals("") || (Integer.parseInt(task_status) >= 25 && billed_yn.equals("Y")) || (Integer.parseInt(task_status) >= 25 && order_catalog_billable_yn.equals("N"))))) { //order_catalog_billable_yn will be 'N' for non-billable order catalog
				if(((task_status.equals("") || (Integer.parseInt(task_status) >= 25 && billed_yn.equals("Y")) || (Integer.parseInt(task_status) >= 25 && order_catalog_billable_yn.equals("N"))))) { //order_catalog_billable_yn will be 'N' for non-billable order catalog
					// if the 1st record is marked as an error, task_status will be "" 
					prev_task_resulted_yn = "Y";
				}else{
					prev_task_resulted_yn = "N";
				}			

			//	if(!billing_appl_yn.equals("Y") && task_status.equals("60")){
				//if(!billing_appl_yn.equals("Y") && task_status.equals("25")){
				if(!billing_appl_yn.equals("Y") && (task_status.equals("25") || task_status.equals("60"))){//added by parul on 07/06/2010 for IN021703(Make 1st and 2nd  trmt as RS,3rd  make as IR than add one more trmt after 2nd task, try to register 3rd task. getting above msg "Registration should be done sequentialy")
					prev_task_resulted_yn = "Y";
				}
				
				
			}else if(Integer.parseInt(treatment_status_param) == 25){
				//if( billing_appl_yn.equals("N") || ((task_status.equals("") || (task_status.equals("60") && billed_yn.equals("Y")) || (task_status.equals("60") && order_catalog_billable_yn.equals("N"))))){ //order_catalog_billable_yn will be 'N' for non-billable order catalog
				if( billing_appl_yn.equals("N") || ((task_status.equals("") || ((task_status.equals("60") || task_status.equals("85")) && billed_yn.equals("Y")) || ((task_status.equals("60") || task_status.equals("85")) && order_catalog_billable_yn.equals("N"))))) { //order_catalog_billable_yn will be 'N' for non-billable order catalog
					// if the 1st record is marked as an error, task_status will be "" 
					prev_task_resulted_yn = "Y";
				}else{
					prev_task_resulted_yn = "N";
				}


				if(!billing_appl_yn.equals("Y") && task_status.equals("60")){
					prev_task_resulted_yn = "Y";
				}
			}
		}
		else{
			prev_task_resulted_yn="N";
		}

			/*
			if((task_status.equals("E") || (!task_status.equals("") && (task_status.equals("60") || task_status.equals("85"))) && billed_yn.equals("Y"))){
				prev_task_resulted_yn = "Y";
			}
			else{
				prev_task_resulted_yn = "N";
			}
			*/

			out.println(prev_task_resulted_yn);
		}
		else if(func_mode.equalsIgnoreCase("checkCurrentEncounterValidity")){	
			String order_id = request.getParameter("order_id");
			String p_status = "";
			String p_msg_txt = "";
			String v_lang_err_msg_id = "";
			String p_new_order_id = "";
			String p_new_encounter_id = "";
			String p_curr_encntr_active_yn  = "";
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			cstmt=con.prepareCall("{call OH_CHK_ENCOUNTER_VALIDITY(?,?,?, NULL,NULL,?,?, ?,?,?)}");
			cstmt.setString(1,facility_id );			//P_FACILITY_ID   			VARCHAR2,
			cstmt.setString(2,order_id );				//P_ORDER_ID				VARCHAR2, -- SEND TASK LEVEL ORDER ID
			cstmt.registerOutParameter(3,Types.VARCHAR);//P_CURR_ENCNTR_ACTIVE_YN	OUT VARCHAR2, -- Y -- IF THE ORDER ENCOUNTER AND CURRENT ENCOUNTER ARE SAME
															// -- N -- IF THE ORDER ENCOUNTER AND CURRENT ENCOUNTER ARE DIFFERENT
			cstmt.setString(4,login_user);				//P_USER_ID		VARCHAR2, -- USER ID
			cstmt.setString(5,client_ip_address);					//P_WS_NO		VARCHAR2, -- WORKSTATION NO
			cstmt.registerOutParameter(6,Types.VARCHAR);	// P_STATUS OUT  VARCHAR2, -- S - SUCCESSFUL, E-ERROR
			cstmt.registerOutParameter(7,Types.VARCHAR);	// P_MSG_TXT OUT  VARCHAR2,
			cstmt.registerOutParameter(8,Types.VARCHAR);	// V_LANG_ERR_MSG_ID		   OUT	VARCHAR2) IS
			cstmt.execute();
			p_status = checkForNull(cstmt.getString(6));
			p_msg_txt = checkForNull(cstmt.getString(7));
			v_lang_err_msg_id = checkForNull(cstmt.getString(8));
			p_new_order_id = "";
			p_new_encounter_id = "";

			if(p_status.equals("E")){						  
				p_msg_txt = checkForNull(cstmt.getString(7));
				v_lang_err_msg_id = checkForNull(cstmt.getString(8));
			}else{
				p_curr_encntr_active_yn = checkForNull(cstmt.getString(3));
				
				if(p_curr_encntr_active_yn.equals("N")){
					//p_oper_request_num = order_id+"_"+chart_num;
					if(cstmt!=null) cstmt.close();
				}
			}		
			out.println(p_curr_encntr_active_yn);
		} else if(func_mode.equalsIgnoreCase("updateNewEncounter")){	
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
			String trmt_code = request.getParameter("trmt_code");
			String task_code = request.getParameter("task_code");
			//String seq_no = request.getParameter("seq_no");
			String order_id = request.getParameter("order_id");
			String order_line_num = request.getParameter("order_line_num");
			//String billed_yn = "N";
			//String task_status = "";
			//String prev_task_resulted_yn = "Y";
			String schedule_date_time = "";
			String schedule_ref_no = "";   
			String encounter_id = ""; 

			String p_status = "";
			String p_msg_txt = "";
			String v_lang_err_msg_id = "";
			String p_new_order_id = "";
			String p_new_encounter_id = "";
			//String p_curr_encntr_active_yn  = "";
			//String p_oper_request_num  = "";
			String p_oper_request_num  = order_id+"_"+chart_num;
		
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			//pstmt=con.prepareStatement("SELECT TO_CHAR(SCHEDULE_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE_TIME, SCHEDULE_REF_NO,ENCOUNTER_ID FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ?  AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' ");
			//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//pstmt=con.prepareStatement("SELECT TO_CHAR(SCHEDULE_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE_TIME, SCHEDULE_REF_NO,ENCOUNTER_ID FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ?  AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' ");
			pstmt=con.prepareStatement("SELECT TO_CHAR(SCHEDULE_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE_TIME, SCHEDULE_REF_NO,ENCOUNTER_ID FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ?  AND TASK_CODE = ? AND NVL(STATUS,'X') != 'E' AND ORDER_ID= ?");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,order_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				schedule_date_time	= checkForNull(rs.getString("SCHEDULE_DATE_TIME"));
				schedule_ref_no		= checkForNull(rs.getString("SCHEDULE_REF_NO"));
				encounter_id		= checkForNull(rs.getString("ENCOUNTER_ID"));
			}

				cstmt=con.prepareCall("{call OH_UPDATE_NEW_ENCOUNTER_DTLS(?,?,?,?,?, ?,?,to_date(?,'DD/MM/YYYY HH24:MI'),?,?, ?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1, facility_id );				// P_FACILITY_ID   	VARCHAR2,
				cstmt.setString(2, order_id );					// P_OLD_ORDER 		VARCHAR2, -- Pass the task ORDER_ID
				cstmt.setString(3, patient_id );				// P_PATIENT_ID 	VARCHAR2,
				cstmt.setString(4, chart_num );					// P_CHART_NUM		NUMBER,
				cstmt.setString(5, chart_line_num );			// P_CHART_LINE_NUM	NUMBER,
				cstmt.setString(6, trmt_code );					// P_TRMT_CODE		VARCHAR2,
				cstmt.setString(7, task_code );					// P_TASK_CODE		VARCHAR2,
				cstmt.setString(8, schedule_date_time );			// P_APPT_DATE_TIME	DATE,
				cstmt.setString(9, schedule_ref_no );				// P_APPT_REF_NUM	VARCHAR2,
				cstmt.setString(10, login_user );				// P_USER 			VARCHAR2, -- USER ID
				cstmt.setString(11, client_ip_address );		// P_WS_NO 			VARCHAR2, -- WORKSTATION NO.
				cstmt.registerOutParameter(12,Types.VARCHAR);	// P_NEW_ORDER_ID 	OUT 	VARCHAR2,
				cstmt.registerOutParameter(13,Types.VARCHAR);	// P_NEW_ENCOUNTER_ID	OUT	VARCHAR2,
				cstmt.registerOutParameter(14,Types.VARCHAR);	// P_STATUS   			OUT 	VARCHAR2, -- S - SUCCESS, E - ERROR
				cstmt.registerOutParameter(15,Types.VARCHAR);	// P_MSG_TXT  			OUT 	VARCHAR2,
				cstmt.registerOutParameter(16,Types.VARCHAR);	// V_LANG_ERR_MSG_ID	OUT	VARCHAR2
			
				cstmt.setString(17,order_line_num);	// P_OLD_ORD_LINE_NO	NUMBER DEFAULT NULL
				cstmt.setString(18,p_oper_request_num);	// P_OPER_REQUEST_NUM      VARCHAR2 DEFAULT NULL
				cstmt.setString(19,order_line_num);	// P_LINE_NUM NUMBER DEFAULT NULL
				
				cstmt.execute();
				p_status = checkForNull(cstmt.getString(14));
				p_msg_txt = checkForNull(cstmt.getString(15));
				v_lang_err_msg_id = checkForNull(cstmt.getString(16));
				
				if(p_status.equals("S")){
					p_new_order_id = checkForNull(cstmt.getString(12));
					p_new_encounter_id = checkForNull(cstmt.getString(13));
				} 
			//}
		//}

		
		if(p_status.equals("E")){
			out.println("E::"+p_msg_txt+"::"+v_lang_err_msg_id+"::");
		}
		if(!p_new_order_id.equals("")){
			out.println("NEW_ENCOUNTER_CREATED::"+p_new_order_id+"::"+encounter_id+"::"+p_new_encounter_id+"::");
		}else{
			out.println("NO_NEW_ENCOUNTER::");
		}  
		//out.println(prev_task_resulted_yn);
		//out.println(p_curr_encntr_active_yn);
		} 
		else if(func_mode.equalsIgnoreCase("registerOrder")){	
			String order_id = checkForNull(request.getParameter("order_id"));
			String order_line_num = checkForNull(request.getParameter("order_line_num"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String accession_num = "";//facility_id+"##"+chart_num+"##"+chart_line_num;
			String accession_line_num = "1";//chart_line_num;
			String order_set_id = "";

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			pstmt=con.prepareStatement("SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?");
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				order_set_id = checkForNull(rs.getString("ORDER_SET_ID"));
			}

			//accession_num = facility_id+"#"+order_set_id;//Added by Sridevi Joshi on 6/14/2010 
			accession_num = order_set_id;//Added by Sridevi Joshi on 6/14/2010 SRR20056-SCF-4662 [IN:021978]

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE  ORDER_STATUS_TYPE ='25'), ACCESSION_NUM = ?, ACCESSION_LINE_NUM = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?");
			pstmt.setString(1,accession_num);
			pstmt.setString(2,accession_line_num);
			pstmt.setString(3,login_user);				
			pstmt.setString(4,client_ip_address);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,order_id);
			pstmt.setString(7,order_line_num);
			Reg_order_flag = pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE  ORDER_STATUS_TYPE ='25'), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?)");
			pstmt.setString(1,login_user);				
			pstmt.setString(2,client_ip_address);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,order_id);
			Reg_order_line_flag = pstmt.executeUpdate();

			if(Reg_order_flag != 0 && Reg_order_line_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(Reg_order_flag+"##"+Reg_order_line_flag);
		}
		else if(func_mode.equalsIgnoreCase("updateStatusComplete")){	
			String order_id = checkForNull(request.getParameter("order_id"));
			String order_line_num = checkForNull(request.getParameter("order_line_num"));
			//String chart_num = checkForNull(request.getParameter("chart_num"));
			//String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			//String accession_num = facility_id+"##"+chart_num+"##"+chart_line_num;
			//String accession_line_num = chart_line_num;

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE  ORDER_STATUS_TYPE ='60'), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?");
			pstmt.setString(1,login_user);				
			pstmt.setString(2,client_ip_address);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,order_id);
			pstmt.setString(5,order_line_num);
			Reg_order_flag = pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE  ORDER_STATUS_TYPE ='60'), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?)");
			pstmt.setString(1,login_user);				
			pstmt.setString(2,client_ip_address);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,order_id);
			Reg_order_line_flag = pstmt.executeUpdate();

			if(Reg_order_flag != 0 && Reg_order_line_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(Reg_order_flag+"##"+Reg_order_line_flag);
		}else if(func_mode.equalsIgnoreCase("getComplicationCode")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
            String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code = checkForNull(request.getParameter( "task_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			String sql				= "";	
			String complication_code = "" ;
			String complication_desc = "";
			StringBuffer complication_code_db = new StringBuffer();
			if(oh_chart_level.equals("E")){
				sql = "SELECT A.COMPLICATION_CODE,(SELECT B.COMPLICATION_DESC FROM OH_COMPLICATION B WHERE A.COMPLICATION_CODE=B.COMPLICATION_CODE) COMPLICATION_DESC FROM OH_RESTO_CHRT_COMPLICATION A WHERE A.PATIENT_ID = ? AND  A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE =? AND A.TASK_CODE = ? AND TASK_SEQ = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code);
				pstmt.setString(6,seq_no);
				rs = pstmt.executeQuery();
			}
		else{
				sql = "SELECT A.COMPLICATION_CODE,(SELECT B.COMPLICATION_DESC FROM OH_COMPLICATION B WHERE A.COMPLICATION_CODE=B.COMPLICATION_CODE) COMPLICATION_DESC FROM OH_RESTO_CHRT_COMPLICATION A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND  A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE =? AND A.TASK_CODE = ? AND TASK_SEQ = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,task_code);
				pstmt.setString(7,seq_no);
				rs = pstmt.executeQuery();
			}
			while(rs!= null && rs.next()){
				complication_code = checkForNull(rs.getString("COMPLICATION_CODE"));
				complication_desc = checkForNull(rs.getString("COMPLICATION_DESC"));
				complication_code_db.append(complication_code+"$$"+complication_desc);
				complication_code_db.append("~");
			}
			out.println(complication_code_db);
		} else if(func_mode.equalsIgnoreCase("deleteComplicationRecorded")){	
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
            String trmt_code = request.getParameter("trmt_code");
            String task_code = request.getParameter("task_code_req");
			String complication_code = request.getParameter("complication_code");
			String complication_seq_no = request.getParameter("complication_seq_no");
			String oh_chart_level = request.getParameter("oh_chart_level");
			String other_chart_facility_id = request.getParameter("other_chart_facility_id");
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;
            int tooth_range_cnt = Integer.parseInt(tooth_range_count);
			int complication_chart_line_num_int = Integer.parseInt(chart_line_num);
			int complication_flag = 0;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			
			if(pstmt != null) pstmt.close();
			if(rs != null)    rs.close();
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("DELETE FROM OH_RESTO_CHRT_COMPLICATION WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND COMPLICATION_CODE = ? AND COMPLICATION_SEQ_NO = ? AND TASK_SEQ = ?");
				if(tooth_range_cnt == 0){
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,trmt_code);
					pstmt.setString(5,task_code);
					pstmt.setString(6,complication_code);
					pstmt.setString(7,complication_seq_no);
					pstmt.setString(8,seq_no);
					complication_flag = pstmt.executeUpdate();
				}
				else{
					for(int j=1;j<=tooth_range_cnt;j++){
					chart_line_num = complication_chart_line_num_int+"";

					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,trmt_code);
					pstmt.setString(5,task_code);
					pstmt.setString(6,complication_code);
					pstmt.setString(7,complication_seq_no);
					pstmt.setString(8,seq_no);
					complication_flag = pstmt.executeUpdate();
					complication_chart_line_num_int++;
					}
				}
			}
			else{
				pstmt=con.prepareStatement("DELETE FROM OH_RESTO_CHRT_COMPLICATION WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND COMPLICATION_CODE = ? AND COMPLICATION_SEQ_NO = ? AND TASK_SEQ = ?");
				if(tooth_range_cnt == 0){
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,task_code);
					pstmt.setString(7,complication_code);
					pstmt.setString(8,complication_seq_no);
					pstmt.setString(9,seq_no);
					complication_flag = pstmt.executeUpdate();
				}
				else{
					for(int j=1;j<=tooth_range_cnt;j++){
						chart_line_num = complication_chart_line_num_int+"";
						pstmt.setString(1,other_chart_facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,chart_line_num);
						pstmt.setString(5,trmt_code);
						pstmt.setString(6,task_code);
						pstmt.setString(7,complication_code);
						pstmt.setString(8,complication_seq_no);
						pstmt.setString(9,seq_no);
						complication_flag = pstmt.executeUpdate();
						complication_chart_line_num_int++;
					}
				}
			}
			
			if(complication_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(complication_flag);
		}else if(func_mode.equalsIgnoreCase("populateComplicationDetails")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code = checkForNull(request.getParameter( "task_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;
			int count = 1;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			if(oh_chart_level.equals("E")){
				//pstmt = con.prepareStatement("SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS, A.COMPLICATION_SEQ_NO, B.COMPLICATION_DESC COMPLICATION_DESC FROM OH_RESTO_CHRT_COMPLICATION  A, OH_COMPLICATION B, OH_TASKS_LANG C WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ?");
				pstmt = con.prepareStatement("SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS,A.COMPLICATION_SEQ_NO,DECODE(B.COMPLICATION_CODE,'$OTH',A.COMPLICATION_REMARKS,B.COMPLICATION_DESC) COMPLICATION_DESC  FROM OH_RESTO_CHRT_COMPLICATION  A,  (SELECT COMPLICATION_CODE, COMPLICATION_DESC FROM OH_COMPLICATION  UNION SELECT '$OTH','OTHERS' FROM DUAL) B, OH_TASKS_LANG C WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ? ORDER BY COMPLICATION_DESC");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code);
				pstmt.setString(6,seq_no);
				pstmt.setString(7,locale);
				rs=pstmt.executeQuery();
			}
			else{
				//pstmt = con.prepareStatement("SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS, A.COMPLICATION_SEQ_NO, B.COMPLICATION_DESC COMPLICATION_DESC FROM OH_RESTO_CHRT_COMPLICATION  A, OH_COMPLICATION B, OH_TASKS_LANG C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ?");
				pstmt = con.prepareStatement("SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS,A.COMPLICATION_SEQ_NO,DECODE(B.COMPLICATION_CODE,'$OTH',A.COMPLICATION_REMARKS,B.COMPLICATION_DESC) COMPLICATION_DESC  FROM OH_RESTO_CHRT_COMPLICATION  A,  (SELECT COMPLICATION_CODE, COMPLICATION_DESC FROM OH_COMPLICATION  UNION SELECT '$OTH','OTHERS' FROM DUAL) B, OH_TASKS_LANG C WHERE A.OPERATING_FACILITY_ID = ?  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ? ORDER BY COMPLICATION_DESC");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,task_code);
				pstmt.setString(7,seq_no);
				pstmt.setString(8,locale);
				rs=pstmt.executeQuery();
			}

			while(rs.next()){
				count++;
			}
		    out.println(count);
		}else if(func_mode.equalsIgnoreCase("updateTaskCmplicationCmplyn")){	
			String patient_id	  = checkForNull(request.getParameter( "patient_id" ));
			String chart_num	  = checkForNull(request.getParameter( "chart_num" ));
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" ));
			String trmt_code	  = checkForNull(request.getParameter( "trmt_code" ));
			String task_code	  = checkForNull(request.getParameter( "task_code_req" ));
			String task_cmplication_cmpl_yn	= checkForNull(request.getParameter( "task_cmplication_cmpl_yn" ));
			String oh_chart_level = request.getParameter("oh_chart_level");
			String other_chart_facility_id = request.getParameter("other_chart_facility_id");
			String seq_no =  checkForNull(request.getParameter( "seq_no" ));
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;
            
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			int tooth_range_cnt = Integer.parseInt(tooth_range_count);
			int complication_chart_line_num_int = Integer.parseInt(chart_line_num);
			int complication_flag = 0;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET TASK_CMPLICATION_CMPL_YN = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
				
				if(tooth_range_cnt == 0){
					pstmt.setString(1,task_cmplication_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,chart_num);
					pstmt.setString(7,chart_line_num);
					pstmt.setString(8,trmt_code);
					pstmt.setString(9,task_code);
					pstmt.setString(10,seq_no);
					complication_flag = pstmt.executeUpdate();
						
				}else{
					for(int j=1;j<=tooth_range_cnt;j++){
					chart_line_num = complication_chart_line_num_int+"";
					pstmt.setString(1,task_cmplication_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,chart_num);
					pstmt.setString(7,chart_line_num);
					pstmt.setString(8,trmt_code);
					pstmt.setString(9,task_code);
					pstmt.setString(10,seq_no);
						complication_flag = pstmt.executeUpdate();
						complication_chart_line_num_int++;
					}
				}
			}else{
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET TASK_CMPLICATION_CMPL_YN = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
				
				if(tooth_range_cnt == 0){
					pstmt.setString(1,task_cmplication_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,other_chart_facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,chart_num);
					pstmt.setString(8,chart_line_num);
					pstmt.setString(9,trmt_code);
					pstmt.setString(10,task_code);
					pstmt.setString(11,seq_no);
					complication_flag = pstmt.executeUpdate();
						
				}else{
					for(int j=1;j<=tooth_range_cnt;j++){
					chart_line_num = complication_chart_line_num_int+"";
					pstmt.setString(1,task_cmplication_cmpl_yn);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,other_chart_facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,chart_num);
					pstmt.setString(8,chart_line_num);
					pstmt.setString(9,trmt_code);
					pstmt.setString(10,task_code);
					pstmt.setString(11,seq_no);
					complication_flag = pstmt.executeUpdate();
					complication_chart_line_num_int++;
					}
				}
			}
            if(complication_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(complication_flag);
		}
    }catch(Exception e){
		con.rollback();
		System.err.println("DentalTrmtCommonValidation: Err Msg from DentalTrmtCommonValidation.jsp "+e);
		System.err.println("DentalTrmtCommonValidation: Err Msg from func_mode :"+func_mode);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt_task!=null)pstmt_task.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
