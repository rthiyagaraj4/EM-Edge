<!DOCTYPE html>
<%@ page import ="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException,java.sql.Connection,java.sql.Timestamp,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOR.OrderEntryBillingQueryBean,eOR.*" contentType=" text/html;charset=UTF-8" %>

<% 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!-- <script>
	var contextPath="<%=request.getContextPath()%>"
	var retieveSesion='<%=session.getAttribute("PREFERRED_STYLE")%>'
</script> -->

<%
	String or_bean_id 							= "Or_billingQueryBean";
	String or_bean_name 						= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );
	or_bean.clearBean();

	Connection con=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;			
	int treatment_status_param_int = 0;
	String sql = "";
	String disabled = ""; 
	String checked="";
	String val="";											    
	String disable_param="";
	//String ot_status_disable="";
	String disabled_bill_complete = "";
	String complication_code_selected = "";
	String trmt_order_catalog_code = "";
	String task_order_catalog_code = "";
	String record_charges_butn_disabled = "";
	String record_button_disabled = "";
	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	String record_trmt_button_disabled = "";
	//
	String oh_status_disabled = "";
	String result_completed = "N";
	String start_date = "";
	String start_time = "";
	String end_date = "";
	String end_time = "";
	String charging_stage = "";
	String no_of_surface = "2";//added by parul on 070109 ,taken for multiple surface 
	String dc_bl_episode_type = "";
	String trmt_ot_disable = "";


	//Added by Sharon Crasta on 10/3/2008 for the Registration Date and Time.
	String regn_date_time = "";

	//Added by Sharon Crasta on 10/20/2008--- Flag to disable the Treatment Start Date/ Time and Treatment End Date/Time
	String treatment_start_end_date_disabled_flag = "";

	int completed_count = 0;

	String[] startFields = null;
	String[] endFields = null;
			
	String otFlag=checkForNull(request.getParameter("called_from"));
	String params = request.getQueryString();
	
	String facility_id = (String)session.getValue("facility_id") ;
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String patient_id = request.getParameter( "patient_id" ) ;
	String encounter_id = request.getParameter( "encounter_id" ) ;
	String patient_class = request.getParameter( "patient_class" ) ;
	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	String seq_no = request.getParameter( "seq_no" ) ;
	String trmt_done_yn = request.getParameter( "trmt_done_yn" ) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String mixed_dentition_YN = checkForNull(request.getParameter("mixed_dentition_YN"));
	String ref_tooth_no = checkForNull(request.getParameter("ref_tooth_no"));
	String tooth_range = checkForNull(request.getParameter("thrng_ref"));
	String trmt_level_flag = checkForNull(request.getParameter("trmt_level_flag"));//Added by Sridevi Joshi on 3/19/2010 for IN018200

	String code = checkForNull(request.getParameter("code"));
	String site = checkForNull(request.getParameter("site"));
	String type = checkForNull(request.getParameter("type"));
	String cat_code = checkForNull(request.getParameter("cat_code"));
	String arch_quad = checkForNull(request.getParameter("arch_quad"));
	String thrng_nos = checkForNull(request.getParameter("thrng_nos"));
	String outcome = checkForNull(request.getParameter("outcome"));
	String surface = checkForNull(request.getParameter("surface"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String task_code = checkForNull(request.getParameter("task_code"));
	
	String task_desc = checkForNull(request.getParameter("task_desc"));
	String ext_perm_loc_param = checkForNull(request.getParameter("ext_perm_loc_param"));

	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String appt_reqd_yn = checkForNull(request.getParameter( "appt_reqd_yn" )) ;
	String display_tooth_no = checkForNull(request.getParameter( "display_tooth_no" )) ; // This value will be a range saperated by , or a single tooth no depending on the site type.This value is populated from RHS menu

	//billing params
	String bl_total_payable_for_trmt = checkForNull(request.getParameter("total_payable_for_trmt"));
	String bl_data_exists_yn = checkForNull(request.getParameter("bl_data_exists_yn"));
	String bl_key = checkForNull(request.getParameter("bl_key"));
	String billing_appl_yn = checkForNull(request.getParameter("billing_appl_yn"));
	String billed_yn = checkForNull(request.getParameter( "billed_yn" )) ;

	// Added for Billing. These columns have to be queried like other columns, before coming to this jsp.
	String bill_sub_regn_num		= checkForNull(request.getParameter( "bill_sub_regn_num" ));
	String bill_sub_regn_line_num	= checkForNull(request.getParameter( "bill_sub_regn_line_num" ));

	//Order Catalog Billable yn flag
	String order_catalog_bill_yn	= checkForNull(request.getParameter( "order_catalog_bill_yn" ));

	//newly added from dentalcondition.jsp
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String header_tab = request.getParameter( "header_tab" ) ;
	String show_new_active_yn = checkForNull(request.getParameter( "show_new_active_yn" )) ;
	String thrng_nos_ref = checkForNull(request.getParameter( "thrng_nos_ref" )) ;
	String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;

	String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
	String flag = checkForNull(request.getParameter( "flag" )) ;

	String ind_chart_line_num = checkForNull(request.getParameter( "ind_chart_line_num" )) ; //Indivisual chart_line_num of a tooth in case of Tooth Range
	String complication_code = checkForNull(request.getParameter( "complication_code" )) ;
	String treatment_status_param = checkForNull(request.getParameter("treatment_status"));
	
	String start_date_time = checkForNull(request.getParameter("start_date_time"));//Added by Sharon Crasta on 10/9/2008 ---- Splits the date and time based on " " (space as delimiter)
	String end_date_time = checkForNull(request.getParameter("end_date_time"));//Added by Sharon Crasta on 10/9/2008 ---- Splits the date and time based on " " (space as delimiter)
	
	String status_disabled =  "";
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ; 
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
   	String add_new_yn =checkForNull(request.getParameter("add_new_yn")) ;
   	String add_new_done_flag =checkForNull(request.getParameter("add_new_done_flag")) ;
	
	
	String treatment_flag =checkForNull(request.getParameter("treatment_flag")) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	String task_seq_no =checkForNull(request.getParameter("task_seq_no")) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480),
	
	String cusp_tip_code = checkForNull(request.getParameter( "cusp_tip_code" )) ;
	String maxila_area = checkForNull(request.getParameter( "maxila_area" )) ;
	String maxila_parts = checkForNull(request.getParameter( "maxila_parts" )) ;
	String maxila_sub_parts = checkForNull(request.getParameter( "maxila_sub_parts" )) ;

	String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700

	String flag1 = checkForNull(request.getParameter( "flag1" )) ;//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
	String super_key_num = checkForNull(request.getParameter( "super_key_num" )) ;//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894

	//Added by Sharon Crasta on 12/11/2009 for IN016953
	//Added because if after placing an extraction order the tooth is exfoliated or missing or unerupted or p[artially erupted, then the placed order should be cancelled.
	String treatment_status_param_for_extraction =  checkForNull(request.getParameter("trmt_status_for_extraction"));
	String failure_reason =  checkForNull(request.getParameter("failure_reason"));//added by parul on 28/02/2010 for CRF-477

	//End
	//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0485(IN010920)
	String task_status_orig =  checkForNull(request.getParameter("task_status_orig"));

	//treatment_status_param = task_status_orig;
	//End
	//Added by Sharon Crasta on 2/15/2010 for IN019319
	String order_id_for_add = checkForNull(request.getParameter("order_id"));
	//End
	String selected_first_thno = checkForNull(request.getParameter( "selected_first_thno" )) ;//added by parul on 311008
	//Added by Sharon Crasta on 2/24/2010 for SRR20056-CRF-0475(IN010868)
	String pontic_tooth_values = checkForNull(request.getParameter( "pontic_tooth_values" )) ;
	//End
	String progress_note_group = "";
	String progression_ref = "";
	
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "";
	   date_diff_flag = "enable";
	   called_from_viewchart_yn = "N";
	}
			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	
	//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	//if((!other_chart_facility_id.equals(facility_id)) &&  (treatment_status_param.equals("25") || treatment_status_param.equals("52") || treatment_status_param.equals("55") || treatment_status_param.equals("80") || treatment_status_param.equals("60") || treatment_status_param.equals("85") || treatment_status_param.equals("75") || treatment_status_param.equals("90"))) { 
	if((!other_chart_facility_id.equals(facility_id)) &&  (treatment_status_param.equals("25") || treatment_status_param.equals("52") || treatment_status_param.equals("55") || treatment_status_param.equals("80") || treatment_status_param.equals("85") || treatment_status_param.equals("75") || treatment_status_param.equals("90"))) { 
		status_disabled = "disabled";
	} 

	if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable") || other_facilitychart_yn.equals("N")) { 
		status_disabled = "disabled";
	}

	if(baseline_chart_yn.equals("N") && other_facilitychart_yn.equals("Y")) {
		status_disabled = "disabled";
	} 
	 
	//
	//Legends
	String record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	String remarks_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	String cancel_reason_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CancelReason.label","or_labels");
	//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	//String dentist_comments_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DentistComments.label","oh_labels");
	//
	if(start_date_time.indexOf(" ") != -1){
		startFields = start_date_time.split(" ");
		start_date = checkForNull(com.ehis.util.DateUtils.convertDate(startFields[0],"DMY","en",locale));
		start_time = startFields[1];
	}

	if(end_date_time.indexOf(" ") != -1){
		endFields = end_date_time.split(" ");
		end_date = checkForNull(com.ehis.util.DateUtils.convertDate(endFields[0],"DMY","en",locale));
		end_time = endFields[1];
	}

	if(treatment_status_param.equals("60") || treatment_status_param.equals("85") || treatment_status_param.equals("75") || treatment_status_param.equals("90")){
		result_completed = "Y";
	}

	
	/* Starts Block to disable the fields */

	if(treatment_status_param.equals("PLAN") || result_completed.equals("Y")){ // Initially the or_order_status would be null
		oh_status_disabled = "disabled";
	}

	if(result_completed.equals("Y") && !task_code.equals("")){
		disabled = "disabled";
	}

	if(billed_yn .equals("Y")  || (!result_completed.equals("Y"))){
		disabled_bill_complete = "disabled";
	}

	if(billed_yn.equals("Y")){
		record_charges_butn_disabled = "disabled";
	}

	if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){
		disabled = "disabled";
		oh_status_disabled = "disabled";
		status_disabled = "disabled";
	}	

	//Added by Sharon Crasta on 10/20/2008 -- Start Date/Time and End Date/Time is disabled once the treatment is done.
	if(treatment_status_param.equals("60") && result_completed.equals("Y") && !task_code.equals("") && trmt_done_yn.equals("Y")){
		 treatment_start_end_date_disabled_flag = "disabled";
	}

	//Added for IN015620 by Sridevi Joshi on 23/20/09
	if(ext_perm_loc_param.equals("Y") && treatment_status_param.equals("60")){
		treatment_start_end_date_disabled_flag = "disabled";
	}

	
	
	//Shifted from top to bottom of the block
	if(result_completed.equals("Y") && !task_code.equals("") && !trmt_done_yn.equals("Y") && billing_appl_yn.equals("Y")){
		record_button_disabled = disabled;
	} else {
		record_button_disabled = disabled;
	}
	/* Ends Block to disable the fields */

	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	if(treatment_flag.equals("Y") && !treatment_status_param.equals("E")){
			record_trmt_button_disabled = "disabled";
			record_charges_butn_disabled = "disabled";
	}
	//

	/* Starts Block for Record button legend */
	//charging_stage = "RST";
	if(treatment_status_param.equals("10") && appt_reqd_yn.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Schedule.label","common_labels");
	}
	else if(treatment_status_param.equals("10") && appt_reqd_yn.equals("N")){ // this condition is added by bshankar on 09FEB2008. If appt_reqd_yn is NO, there is no scheduling and directly registration has to be done
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels");
		charging_stage = "REG";
	}

	//if(treatment_status_param.equals("15")){
	if(treatment_status_param.equals("15") && !treatment_flag.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels");
		charging_stage = "REG";
	}
	
	if(treatment_status_param.equals("15") && treatment_flag.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
		
	}
	
	if(treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80")) {
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultEntry.label","or_labels");
		charging_stage = "RST";
	}

	if(result_completed.equals("Y") && !task_code.equals("") && billing_appl_yn.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultEntry.label","or_labels");
		charging_stage = "RST";
	}

	if(result_completed.equals("Y") && task_code.equals("")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	}

	if(treatment_status_param.equals("") || treatment_status_param.equals(null) || treatment_status_param.equals("null")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	}

	if(!treatment_status_param.equals("") && !treatment_status_param.equals("PLAN")){
		treatment_status_param_int = Integer.parseInt(treatment_status_param);
	}

	if(baseline_chart_yn.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	} 

	if(otFlag.equals("OT") && treatment_status_param_int<25){
		//trmt_ot_disable = "disabled";
	}

	/* Ends Block for Record button legend */

	try{
		con = ConnectionManager.getConnection(request);	
		if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT A.ORDER_CATALOG_CODE TRMT_ORDER_CATALOG_CODE, B.ORDER_CATALOG_CODE TASK_ORDER_CATALOG_CODE FROM OH_TREATMENT A, OH_TASKS B WHERE  A.TRMT_CODE = ? AND B.TASK_CODE = ?");
			pstmt.setString(1,trmt_code);
			pstmt.setString(2,task_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				trmt_order_catalog_code = checkForNull(rs.getString("TRMT_ORDER_CATALOG_CODE"));
				task_order_catalog_code = checkForNull(rs.getString("TASK_ORDER_CATALOG_CODE"));
			}
		}
        /* Below Code is added by sathish against CRF-0487 on 24-02-2010*/
		if(called_from_viewchart_yn.equals("Y")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT PROGRESS_NOTE_GROUP FROM OH_TREATMENT  WHERE  TRMT_CODE = ?");
				pstmt.setString(1,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){	
					progress_note_group = checkForNull(rs.getString("PROGRESS_NOTE_GROUP"));
				}
			}
			else{
//				pstmt=con.prepareStatement("SELECT PROGRESS_NOTE_GROUP FROM OH_TREATMENT  WHERE OPERATING_FACILITY_ID=? AND TRMT_CODE = ?");
				pstmt=con.prepareStatement("SELECT PROGRESS_NOTE_GROUP FROM OH_TREATMENT  WHERE  TRMT_CODE = ?");
				// Modified by DhanasekarV  on may/07/2012
//				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){	
					progress_note_group = checkForNull(rs.getString("PROGRESS_NOTE_GROUP"));
				}
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

            if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					progression_ref = checkForNull(rs.getString("PROGRESSION_REF"));
				}
			}else{
				pstmt=con.prepareStatement("SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					progression_ref = checkForNull(rs.getString("PROGRESSION_REF"));
				}
			}
		}
		/* Added code by sathish ends here*/

		//Added for IN014255 by Sridevi Joshi

		if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT COUNT(*) COMPLETED_COUNT FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (25,53,52,55,75,90,70,60,85))");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				completed_count = Integer.parseInt(checkForNull(rs.getString("COMPLETED_COUNT"),"0"));
			}
		}


		if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ? AND EPISODE_TYPE =?");
			pstmt.setString(1,patient_class);
			pstmt.setString(2,episode_type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dc_bl_episode_type = checkForNull(rs.getString("BL_EPISODE_TYPE"));
			}
	
//  Added by yadav on 1/13/2010 ,to get current Date in dd/MM/yyyy format  for CRF-443
		SimpleDateFormat df = null;
        String cDate = "";
		String cTime="";
		String timeStatus="";
		String dateStatus="";
		String orderDate="";
        Date aDate=new Date();
        if (aDate != null) {
            df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            cDate = df.format(aDate);
		String rDateTime=cDate.toString();
		String rDateTimerr[]=rDateTime.split(" ");
			cDate=checkForNull(com.ehis.util.DateUtils.convertDate(rDateTimerr[0],"DMY","en",locale));			
			//cTime=rDateTimerr[1];
        }
		

%>
		<html>
			<head>
				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
				<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
				<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
				<script language="javascript" src="../../eCommon/js/common.js"></script>
				<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
				<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
				<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
				<script language="javascript" src="../../eOH/js/DentalTreatment.js"></script>
				<script language="javascript" src="../../eOH/js/OHBilling.js"></script>
				<script language="javascript" src="../../eOH/js/GetImages.js"></script>
				<script language="javascript" src="../../eOH/js/FillImages.js"></script>
				<script language="javascript" src="../../eOH/js/DrawShapes.js"></script>
				<script language="javascript" src="../../eOH/js/DentalTreatmentStages.js"></script>
				<script language="javascript" src="../../eOH/js/RecordDiagForTrmt.js"></script>
				<script language="javascript" src="../../eOH/js/TrmtMatDetails.js"></script>
				<script language="javascript" src="../../eOH/js/TrmtComplicationDetails.js"></script>
				<script language='javascript' src='../../eCommon/js/dchk.js'></script>
				<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
				<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


				<script>
                     function countSurface(){//added by parul ...selected surface should not be more than no_of_surface
	                 var count=0;
					 var no_of_surface=document.forms[0].no_of_surface.value;
					 var oh_surface=document.forms[0].oh_surface.value;
						 for(var m=0;m<document.forms[0].oh_surface.options.length;m++){
							if(document.forms[0].oh_surface.options[m].selected==true){
								surface_ref=document.forms[0].oh_surface.options[m].value;
								count++;
							}
						}
						 if  (count>no_of_surface){
							alert("selected surface should not be more than no_of_surface")
						}
					}
				</script>
				<style>
					TD.Menu{
							BACKGROUND-COLOR:white;
							border-color:#999999
					}
				</style>
			</head>
			<body topmargin='0' leftmargin='0' class='CONTENT' onload="setValuesFromMenu('<%=type%>','<%=site%>','<%=code%>','<%=arch_quad%>','<%=thrng_nos%>','<%=ref_tooth_no%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>','<%=treatment_status_param%>','<%=outcome%>','<%=surface%>','<%=billed_yn%>','<%=billing_appl_yn%>','<%=flag%>','<%=oh_chart_level%>','<%=cusp_tip_code%>','<%=maxila_area%>','<%=maxila_parts%>','<%=maxila_sub_parts%>','<%=failure_reason%>');CurrTime(); " OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
				<form name='OHTreatmentForm' id='OHTreatmentForm' method='post' action='../../servlet/eOH.OHDentalChartTrmtServlet' target='messageFrame'>
					<table align='center' cellpadding='4' cellspacing='' border='0' width='100%'>
						<!-- <tr>
							<td></td><td></td>
							<td width="25%" class="field" nowrap>
								  <font color="blue"><a id="dentistComments" onclick="showDentistComments('<%=locale%>')" style="cursor:pointer"><fmt:message key="eOH.DentistComments.Label" bundle="${oh_labels}"/></a></font>

															
							</td>
						</tr> -->
	<!-- Comments @DentalTreatment.jsp By Muthukumar on 20-09-2011  - Treatment Forms Starts here -->
						<tr>
							<td width="25%" class='LABEL' nowrap><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
							<td width="25%" class="field" nowrap>
								<!-- <select <%=disabled%> <%=status_disabled%> name='oh_category'  onChange='populateSiteOptions(this,"onSelectCategory");populateTreatments(this);populateConditionCode(this);checkForMaxilla(this);populateStatus(this);'> -->
								<!-- commented by parul on 7/21/2009 for IN012683,When u select trmt cataegory for range and before record if u change trmt cataegory area leaged and value should be refresh-->
								 <select <%=disabled%> <%=status_disabled%> name='oh_category'  onChange="populateSiteOptions(this,'onSelectCategory');populateTreatments(this);checkForMaxilla(this);populateStatus(this);getAreaLegendFromPage(this);populateAreaFromPage(this,'<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');getSurfaceLegend(this);getSurfaceLegendFromPage(this);populateSurfaces(this);enableDisableSurfaceFromPage(this);">   
							
									<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
										sql="SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE LANGUAGE_ID = ? AND SPLTY_MODULE_ID = ? ORDER BY 2";
										pstmt=con.prepareStatement(sql);
										pstmt.setString(1,locale);
										pstmt.setString(2,"OH");
										rs=pstmt.executeQuery();
										while(rs.next()){
									%>
											<option value='<%=rs.getString("TRMT_CATEGORY_TYPE")%>'><%=rs.getString("TRMT_CATEGORY_TYPE_DESC")%></option>
									<%
										}
									%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'>
							</td>
							<td width="25%" nowrap class='LABEL'><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></td>
							<td width="25%" class="field" nowrap>
								<select name='oh_treatment' id='oh_treatment' <%=status_disabled%> onChange='chkTreatment(this);populateConditionCode(document.forms[0].oh_category,this);' nowrap>
									<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								</select>
								<img src='../../eCommon/images/mandatory.gif'>
							</td>
						</tr>
						<tr>
							<td width="25%" class='LABEL' nowrap><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
							<td width="25%" class="field">
								   <select name="oh_site" id="oh_site" onChange="getAreaLegendFromPage(this);populateAreaFromPage(this,'<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');enableDisableSurface(this);enableDisableCuspTip(this);getSurfaceLegendFromPage(this);populateSurfacesFromPage(this);" <%=disabled%>  <%=status_disabled%>>  
								  <!-- <select name="oh_site" id="oh_site" onChange="getAreaLegendFromPage(this);populateAreaFromPage(this,'<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');enableDisableSurface(this);enableDisableCuspTip(this)" <%=disabled%>   <%=status_disabled%>>  -->
									<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								</select>
								<img id='SiteMandatory' src='../../eCommon/images/mandatory.gif'>
							</td>
							<td width="25%" class='LABEL' nowrap id="change_area" ></td>
							<td width="25%" id="area_field" <%=disabled%> <%=status_disabled%>></td>
						</tr>
						<tr>
						<%

							 if (called_from_viewchart_yn.equals("Y")){
						%>
								<td width="25%" class='LABEL' nowrap id="change_surface"> <fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/> </td>
									<td width="25%" class="field" id="surface_field">
									<select name="oh_surface" id="oh_surface"  onchange="countSurface();"<%=disabled%> <%=status_disabled%>>
										<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									</select>
									<IMG id='MandatorySurface' style='visibility:hidden' name='MandatorySurface' border="0" src='../../eCommon/images/mandatory.gif'>
								</td>   
                          <%
							   }else{
						  %>
						  <!--  size=3 multiple,  added  by SRR-CRF20056-0442 on 20/01/2010-->
								<td width="25%" class='LABEL' nowrap id="change_surface"><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/></td>
								<td width="25%" class="field" id="surface_field">
									<select name="oh_surface" id="oh_surface" size=3 multiple  onchange="countSurface();populateCuspTip(this);"<%=disabled%> <%=status_disabled%>> 
										<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									</select>
									<IMG id='MandatorySurface' style='visibility:hidden' name='MandatorySurface' border="0" src='../../eCommon/images/mandatory.gif'>
								</td> 
							<%
								}
							%>

						 	<td width="20%" class='LABEL' nowrap id="cusp_area" style=style="visibility:hidden;position:absolute" ><fmt:message key="eOH.CuspTip.Label" bundle="${oh_labels}"/></td>
							<td width="25%" class="field" id='cusp_field' style=style="visibility:hidden;position:absolute" >
								<select name="oh_cusp_tip" id="oh_cusp_tip"  size=3 multiple <%=disabled%> <%=status_disabled%>>
									<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								</select>
							</td> 
						</tr>
						<tr> 
							<%
								if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && task_code != ""){
							%>
									<td width="25%" class='LABEL' nowrap id="task_legend"><fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/></td>
									<td width="25%" class="field" id="task_code_display">
										<select name="oh_task" id="oh_task" <%=disabled%> <%=status_disabled%>>
											<option value = "<%=task_code%>"><%=task_desc%></option>
										</select>
									</td>
							<%
								}
								else if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && task_code == "" &&  !treatment_flag.equals("Y")){
							%>
									<td width="25%"></td>
									<td width="25%"></td>
							<%
								}
							%> 
						
							<tr >
							<td width="25%" class='LABEL' nowrap> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
							<td width="25%" class="field" nowrap>
								<select name="treatment_status" id="treatment_status" <%=oh_status_disabled%> <%=disabled%> <%=status_disabled%> onChange="changeStatus(this);">
								<%
									if((treatment_status_param.equals("") && (!called_from_viewchart_yn.equals("Y") || baseline_chart_yn.equals("Y")))){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668
								%>
										<option value="" selected><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("03") || treatment_status_param.equals("10") || treatment_status_param.equals("PLAN") || task_status_orig.equals("10")){
								%>
										<option value="10" selected><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("15")){
								%>
										<option value="15" selected><fmt:message key="eOH.Planned.Label" bundle="${oh_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("25")){
								%>
										<option value="25" selected><fmt:message key="Common.Registered.label" bundle="${common_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("53")){
								%>
										<option value="53" selected><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></option>
								<%
									}
									else if(treatment_status_param.equals("52") ){
								%>
											<option value="52" selected><fmt:message key="Common.InProgress.label" bundle="${common_labels}"/></option>
								<%
									}
									else if(treatment_status_param.equals("55") || treatment_status_param.equals("80")){
								%>
										<option value="55" selected><fmt:message key="eOR.PartiallyResulted.label" bundle="${or_labels}"/></option>
								<%
									}
									else if(treatment_status_param.equals("75")){ //Result Completed
								%>
										<option value="75" selected><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("90")){ //Result Completed
								%>
										<option value="90" selected><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("70")){ //Result Completed
								%>
										<option value="70" selected>Pending Authorozation<!-- <fmt:message key="Common.Performed.label" bundle="${common_labels}"/> --></option>
								<%
									}else if(treatment_status_param.equals("60") || treatment_status_param.equals("85")){ //Result Completed
								%>
										<option value="60" selected><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></option>
								<%
									}else if(treatment_status_param.equals("") && called_from_viewchart_yn.equals("Y")){
								%>
										<option value="PO" selected><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></option>
								<%
									}else if(baseline_chart_yn.equals("Y") && called_from_viewchart_yn.equals("Y")){
								%>
										<option value="" selected><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								<%
									}
									//Added order_id_for_add.equals("") by Sharon Crasta on 2/15/2010 for IN019319
									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") &&  !treatment_flag.equals("Y") && !trmt_done_yn.equals("Y") && !order_id_for_add.equals("") && !date_diff_flag.equals("disable")){
								%>	
										<!--Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)-->
										<option value="A"><fmt:message key="Common.Add.label" 	bundle="${common_labels}"/></option>
								<%
									}

									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !result_completed.equals("Y") && treatment_flag.equals("Y") && completed_count == 0 && !date_diff_flag.equals("disable")) {
								%>
									  <option value="E"><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option>
								<%
									}
									else if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !result_completed.equals("Y") && treatment_status_param_int < 25 && !task_code.equals("")  && !date_diff_flag.equals("disable")){
								%>
										<!--Commented and Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480) -->
										<!-- <option value="E"><fmt:message key="Common.MarkError.label" bundle="${common_labels}"/></option> -->
										<!-- <option value="A"><fmt:message key="Common.Add.label" bundle="${common_labels}"/></option> -->
										<option value="E"><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option>
								<%
									}
								%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'>
								
								<%
									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								%>
									 	<font color="blue"><a id="showCancelForReason" onclick="showReasonForCancel('<%=cancel_reason_title%>')" style="cursor:pointer;visibility:hidden;position:absolute"><%=cancel_reason_title%><img id="mandatoryReason" src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></a>
										</font>
								<%
									}%>
							    <%
									//if((treatment_status_param.equals("") && !called_from_viewchart_yn.equals("Y")) || (treatment_status_param.equals("10") || treatment_status_param.equals("PLAN")) && task_code == "" &&  !treatment_flag.equals("Y")) {
									//if((treatment_status_param.equals("") && task_code == "")  || (treatment_status_param.equals("10") || treatment_status_param.equals("PLAN"))) {
									//if(treatment_status_param.equals("") && task_code == "" &&  !treatment_flag.equals("Y")) {
									//if(!called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
									if(!called_from_viewchart_yn.equals("Y")){//removed condition for baseline_chart_yn by SRidevi Joshi on 5/31/2010 for IN021668--To show Remarks link for baseline closed chart
								%>
							
					
								   <td id ="maxillaTrmt" width="25%">
										<font color="blue"><a onclick="showOperRemarks('<%=remarks_title%>','<%=locale%>')" style="cursor:pointer"><%=remarks_title%></a></font>
										<IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border="0" src='../../eCommon/images/mandatory.gif'>
									</td>
									<td width="25%" class='LABEL' nowrap></td>
								<%
									}
								 %>

							</td>
							
							</tr>
							
								<%
									
									//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !result_completed.equals("Y") && treatment_status_param_int < 25){
									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								
								%>
								<!-- <div id = "Add/Cancel" style='visibility:hidden;display:none'> -->
								<!-- 	<table id='Add' cellpadding="3" cellspacing=0 border='0' width='100%' 	align='center' >  -->
								
								 	<tr id='add_data' style="visibility:hidden"> 
										<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.TasksApplicable.Label" bundle="${oh_labels}"/></td>
										<td width="25%" class="field" nowrap>
											<select name="tasks_applicable" id="tasks_applicable">
											<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								<%
												if(rs != null) rs.close();
												if(pstmt != null) pstmt.close();
												//commented by parul on 01/06/2010 for IN021288 (only enabled tasks should populate on list)
												//sql="SELECT A.TASK_CODE,(SELECT B.TASK_DESC FROM OH_TASKS B WHERE A.TASK_CODE = B.TASK_CODE) TASK_DESC FROM OH_TREATMENT_TASKS A WHERE A.TRMT_CODE = ?";

												sql="SELECT A.TASK_CODE,(SELECT B.TASK_DESC FROM OH_TASKS B WHERE A.TASK_CODE = B.TASK_CODE) TASK_DESC FROM OH_TREATMENT_TASKS A,OH_TASKS B  WHERE A.TRMT_CODE = ?  AND B.EFF_STATUS = 'E' AND A.TASK_CODE=B.TASK_CODE";
												pstmt=con.prepareStatement(sql);
												pstmt.setString(1,trmt_code);
												rs=pstmt.executeQuery();
												while(rs.next()){	
									
								%>
												<option value='<%=rs.getString("TASK_CODE")%>'><%=rs.getString("TASK_DESC")%></option>
								<%	  
										}
								 %>
											</select>
										<img src='../../eCommon/images/mandatory.gif'>
										</td>
										<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.Sequence.Label" bundle="${oh_labels}"/></td>
										<td width="25%" class="field" nowrap>
											<select name="row_seq" id="row_seq">
												<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
												<option value="RA"><fmt:message key="eOH.RowAbove.Label" bundle="${oh_labels}"/></option>
												<option value="RB"><fmt:message key="eOH.RowBelow.Label" bundle="${oh_labels}"/></option>
											</select>
										<img src='../../eCommon/images/mandatory.gif'>
										</td>
								 </tr> 
							
							  <%
								
									}
									//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								%>
									 <!-- 	<font color="blue"><a id="showCancelForReason" onclick="showReasonForCancel('<%=cancel_reason_title%>')" style="cursor:pointer;visibility:hidden"><%=cancel_reason_title%></a><img id="mandatoryReason" src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></font> -->
								<%
								//	}
								%>
							<!-- </td> -->
						<!-- 	 <td width="25%"></td>
							<td width="25%"></td> 
						</tr> -->
						
						<tr>
						<!----Added by yadav on 1/14/2010 for registration Date and time for CRF-443-->
						<%if(treatment_status_param_int>=15 && !treatment_flag.equals("Y")) {
							//The below code gets the order date and time from oh_restorative_chart_dtl table
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT TO_CHAR(TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:mi') FROM oh_restorative_chart_dtl WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,chart_line_num);
								rs=pstmt.executeQuery();
								while(rs.next()){
									orderDate = com.ehis.util.DateUtils.convertDate(rs.getString(1),"DMY","en",locale);
								}
								String regDateTime="";
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,chart_line_num);
								pstmt.setString(4,trmt_code);
								pstmt.setString(5,task_code);
								pstmt.setString(6,task_seq_no);
								//pstmt.setString(6,facility_id);
								rs=pstmt.executeQuery();
								while(rs.next()){
									regDateTime = checkForNull(rs.getString(1));
									//Modified by rajesh for thai date conversion
									//regDateTime = checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString(1),"DMYHM","en",locale));
									//regDateTime = checkForNull(rs.getString(1));
								}
								if(regDateTime!=""){
									String regn_date_timeArr[]=regDateTime.split(" ");
									cDate=com.ehis.util.DateUtils.convertDate(regn_date_timeArr[0],"DMY","en",locale);
									cTime=regn_date_timeArr[1];
									}
							if(treatment_status_param_int>=25)
							{
								timeStatus="disabled";
								dateStatus="disabled";
							}
								%>
							 <td width="25%" class='label'><fmt:message key="eOH.RegDateTime.Label" bundle="${oh_labels}"/></td>
							<td width="25%"><input type="text"  size="10" readonly id="regDate" name="regDate" id="regDate" VALUE="<%=cDate%>" <%=dateStatus%>/> <input type="Text" onblur="verify(this)" id="regTime" name="regTime" id="regTime" size='3' maxlength="5"  VALUE="<%=cTime%>" <%=timeStatus%> /><img src='../../eCommon/images/mandatory.gif'></td> 
						<% }%>
							<!------------------------------end------------------------------->
						<!-- Added By Yadav on 10/9/2009 for CRF 707 -->
							<%
									// The below code gets the Performed in OT flag from the OH_RESTORATIVE_CHART_TASKS table
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
									sql="SELECT PERFORMED_IN_OT FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
									pstmt=con.prepareStatement(sql);
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,chart_line_num);
									pstmt.setString(4,trmt_code);
									pstmt.setString(5,task_code);
									pstmt.setString(6,task_seq_no);
									//pstmt.setString(6,facility_id);
									rs=pstmt.executeQuery();
									while(rs.next()){
									String	returnOtFlag = checkForNull(rs.getString(1));
									if(treatment_status_param.equals("60"))
									{
									//ot_status_disable= "disabled";
										if(returnOtFlag.equals("Y"))
										{
										 disable_param = "disabled";
										 checked="checked";
										 val="Y";
										}
										//Added by Sharon Crasta on 3/31/2010 for IN018302
										else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
											disable_param = "disabled";
											checked="";
											val="N";
										}//End
										else 
										{
											disable_param = "disabled";
											checked="";
											val="N";
										}
									}
									else if(!treatment_status_param.equals("60"))
									{
										if(otFlag.equals("OT"))
										{
										 disable_param = "disabled";
										 checked="checked";
										 val="Y";
										}
										else if(returnOtFlag.equals("Y"))
										{
										 disable_param = "";
										 checked="checked";
										 val="Y";
										}
										//Added by Sharon Crasta on 3/31/2010 for IN018302
										else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
											disable_param = "disabled";
											checked="";
											val="N";
										}//End
										else 
										{ disable_param = "";
										 checked="";
										 val="";
										}
									}
							}	
							if(treatment_status_param_int>=25 && !treatment_flag.equals("Y") && !trmt_level_flag.equals("Y")) {//trmt_level_flag is added by Sridevi Joshi on 3/19/2010 for IN018200
								%>
							<!-- td id,style added by parul on 08/06/2010 for IN021923 -->
							<td id ='performed_ot' style="visibility:visible" width="25%" class='label'><fmt:message key="eOH.PerformedinOT.Label" bundle="${oh_labels}"/></td>
							<td id ='performed_ot_chk' style="visibility:visible" width="25%"><input type="checkbox" id="otParam" name="check" id="check"  onClick="setValue(this)" <%=checked%> <%=disable_param%> /></td> 
 
							
							<!------------------------------end------------------------------->
							<% }%>
						</tr>
						<!-- Written by Sharon Crasta on 9/29/2008 to display the Start Date and End Date depending on the Tasks(RG,IM,IR,RS)-->
						<tr id='start_end_add_data' style="visibility:visible" >
							<% 	
								//To display the Treatment Start Date/Time and Treatment End Date/Time only on click of tasks.
								if(task_code != "")	{
									if(treatment_status_param.equals("25") || treatment_status_param.equals("52") || treatment_status_param.equals("55") || treatment_status_param.equals("60") || treatment_status_param.equals("80") || treatment_status_param.equals("85") || treatment_status_param.equals("70")){
							%>
										<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.StartDate.Label" bundle="${oh_labels}"/></td>
										<td width="25%" class="field" nowrap>
										<%
											// The below code gets the Registration date and time from the OH_RESTORATIVE_CHART_TASKS table
											if(rs != null) rs.close();
											if(pstmt != null) pstmt.close();
											//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
											//sql="SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? ";
											sql="SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
											pstmt=con.prepareStatement(sql);
											pstmt.setString(1,patient_id);
											pstmt.setString(2,chart_num);
											pstmt.setString(3,chart_line_num);
											pstmt.setString(4,trmt_code);
											pstmt.setString(5,task_code);
											pstmt.setString(6,task_seq_no);
											//pstmt.setString(6,facility_id);
											rs=pstmt.executeQuery();
											while(rs.next()){
												regn_date_time = checkForNull(rs.getString(1));
											}

											
										%>
																	
											 <input type="text" name="strtDate" id="strtDate" VALUE="<%=start_date%>" size="10" maxlength="10" onKeyPress="NumberCheck(this); " onBlur="checkDateValidity(this);" <%=treatment_start_end_date_disabled_flag%> <%=status_disabled%>/> 
											<input type='image' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('strtDate');" <%=treatment_start_end_date_disabled_flag%> <%=status_disabled%>>
											<input type="text" name="strtTime" id="strtTime" VALUE="<%=start_time%>" size="5" maxlength="5" onKeyPress="NumberTimeCheck(this);" onBlur=" checkTimeValidity(this);" <%=treatment_start_end_date_disabled_flag%> <%=status_disabled%>/> 	
											<%if(!ext_perm_loc_param.equals("Y")){%>
												<img src='../../eCommon/images/mandatory.gif'>	
											<%}%>
										</td>
										<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.EndDate.Label" bundle="${oh_labels}"/></td>
										<td width="25%" class="field" nowrap>
											<input type="text" name="endDate" id="endDate" VALUE="<%=end_date%>" size="10" maxlength = "10" onKeyPress="NumberCheck(this); " onBlur="checkDateValidity(this);" <%=treatment_start_end_date_disabled_flag%> <%=status_disabled%>/>
											<input type='image' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('endDate');" <%=treatment_start_end_date_disabled_flag%> <%=status_disabled%>>
											<input type="text" name="endTime" id="endTime" VALUE="<%=end_time%>" size="5" maxlength="5" onKeyPress="NumberTimeCheck(this);" onBlur="checkTimeValidity(this);" <%=treatment_start_end_date_disabled_flag%> <%=status_disabled%>/> 
											<%if(!ext_perm_loc_param.equals("Y")){%>
												<img src='../../eCommon/images/mandatory.gif'>	
											<%}%>
										</td>
							<%
									}
								}	
							%>
						</tr>
							<%
							if(result_completed.equals("Y") && task_code == ""){
						%>
								 <tr> 
									<td width="25%" class='LABEL' nowrap id='outcome_label' style="visibility:visible"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
									<td width="25%" class="field" id='outcome_select' style="visibility:visible">
										<!--<select name="oh_outcome" id="oh_outcome" <%//=oh_status_disabled%> <%//=disabled%> >-->
										<select name="oh_outcome" id="oh_outcome"  onChange="chkForFailureReason(this);" <%=status_disabled%><%//=oh_status_disabled%> <%//=disabled%> >
											<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option> 
											<option value="S"><fmt:message key="Common.Success.label" bundle="${common_labels}"/></option>			
											<option value="F"><fmt:message key="Common.Failure.label" bundle="${common_labels}"/></option>
										</select>
									</td>
								
								<!-- 	<td width="25%" class='LABEL' nowrap id='complication_label' style="visibility:visible"><fmt:message key="Common.Complications.label" bundle="${common_labels}"/></td>
									<td width="25%" class="field" id='complication_select' style="visibility:visible">
										<select name="oh_complication" id="oh_complication" <%=status_disabled%>>
											<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
											<%
												if(rs != null) rs.close();
												if(pstmt != null) pstmt.close();
												sql="SELECT A.COMPLICATION_CODE COMPLICATION_CODE, A.COMPLICATION_DESC COMPLICATION_DESC FROM OH_COMPLICATION_LANG_VW A, OH_COMPLICATION_TRMT_CAT_TYPE B WHERE A.COMPLICATION_CODE = B.COMPLICATION_CODE AND LANGUAGE_ID = ? AND B.TRMT_CATEGORY_TYPE = ? ORDER BY 2";
												pstmt=con.prepareStatement(sql);
												pstmt.setString(1,locale);
												pstmt.setString(2,type);
												rs=pstmt.executeQuery();
												while(rs.next()){
													if(complication_code.equals(rs.getString("COMPLICATION_CODE"))){
														complication_code_selected = "selected";
													}
													else{
														complication_code_selected = "";
													}
											%>
													<option value='<%=rs.getString("COMPLICATION_CODE")%>' <%=complication_code_selected%>><%=rs.getString("COMPLICATION_DESC")%></option>
											<%
												}
											%>
										</select>
									</td> -->
									<td width="20%" class='LABEL' nowrap  id="change_reason" style='visibility:hidden' ><fmt:message key="eOH.FailureReason.Label" bundle="${oh_labels}"/></td>
									<td width="25%" class="field" id='reason_field' style='visibility:hidden' >
					 			
								</tr>
						<%
							}

						%>
						<tr>
						<td id ="maxillaTrmt" width="25%" colspan="3" nowrap>
						<%
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !treatment_flag.equals("Y")){
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								if(called_from_viewchart_yn.equals("Y")){//removed condition for baseline_chart_yn by SRidevi Joshi on 5/31/2010 for IN021668--To show diagnosis/Remarks link for baseline closed chart
							%>
									
										<font color="blue"><a onclick="showOperRemarks('<%=remarks_title%>','<%=locale%>')" style="cursor:pointer"><%=remarks_title%></a></font><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border="0" src='../../eCommon/images/mandatory.gif'>
									
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<%
											if(!treatment_status_param.equals("") && result_completed.equals("Y") && task_code.equals("")){ 
										%>
												<font color="blue"><a onclick="recordDiagForTrmt('<%=cat_code%>');" style="cursor:pointer"><fmt:message key="eOH.LinkDiagCondition.Label" bundle="${oh_labels}"/></a></font>
										<%
											}	
										%>
							<%
								}
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && treatment_status_param_int > 25){
									
								if(called_from_viewchart_yn.equals("Y")  && treatment_status_param_int > 15){
							%>
										&nbsp;&nbsp;&nbsp;
										
										<font color="blue"><a onclick="recordMatUsed('<%=type%>');" style="cursor:pointer"><fmt:message key="eOH.TreatmentDetails.Label" bundle="${oh_labels}"/></a></font> 
                                        &nbsp;&nbsp;&nbsp;
									
										<font color="blue"><a onclick="recordComplicationUsed('<%=type%>');" style="cursor:pointer"><fmt:message key="eOH.ComplicationDetails.Label" bundle="${oh_labels}"/></a></font> 

                                      <!-- added by parul on 12/02/2010 for CRF-496 & 477 -->
										<!-- <font color="blue"><a id="cancelReason" onclick="showReasonForCancel('<%=cancel_reason_title%>')" style="cursor:pointer;visibility:hidden"><%=cancel_reason_title%></a><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryCancelReason'  src='../../eCommon/images/mandatory.gif'></font> -->
									
							<%
								}
								if(called_from_viewchart_yn.equals("Y")  && treatment_status_param_int > 15){%>
								    &nbsp;&nbsp;&nbsp;
									<font color="blue"><a style="cursor:pointer" onClick="openNotes('<%=patient_id%>','<%=chart_num%>','<%=chart_line_num%>','<%=trmt_code%>','<%=task_code%>','<%=progress_note_group%>');"><fmt:message key="eOH.ProgressNotes.Label" bundle="${oh_labels}"/></a> &nbsp;&nbsp;</font>
							<%	}
							%>
							</td>
							<%
								
								String temp_disable = "N"; // Can be used for temporarily disabling the Billing flag
								
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !treatment_flag.equals("Y")){
									if(billing_appl_yn.equals("Y") && temp_disable.equals("N") && !task_code.equals("") && order_catalog_bill_yn.equals("Y")){
										if((treatment_status_param.equals("10") && appt_reqd_yn.equals("N")) || treatment_status_param.equals("15")|| treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80") || result_completed.equals("Y")) {
										//if(treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80") || result_completed.equals("Y")) {
							%>	
											<!-- <td class="label"><fmt:message key="eOH.ChargesCompletedYN.Label" bundle="${oh_labels}"/></a></td>
											<td class="label">
												<input type="checkbox" id="confirm_complete_charges" name="complete_charges" id="complete_charges" value = "" <%//=disabled_bill_complete%>/>
											</td> -->
											
											
											
											
											<td id='edit_charges' class="button"  align="right" nowrap>
											<%
												//if(!billed_yn.equals("Y")){
												
												if(!treatment_status_param.equals("60")){ 
													if(!status_disabled.equals("disabled")){

											%>     
											        
												
													<font color="blue"><a style="cursor:pointer" onClick="callBillingWindow('<%=patient_id%>','<%=chart_num%>','<%=chart_line_num%>','<%=trmt_code%>','<%=task_code%>','<%=bill_sub_regn_num%>','<%=bill_sub_regn_line_num%>','<%=ca_practitioner_id%>');"><fmt:message key="eOH.EditCharges.Label" bundle="${oh_labels}"/></a> &nbsp;&nbsp;</font>
												
													<!-- <input type="button" class="button" name="record_charges" id="record_charges" value='<fmt:message key="eOH.RecordCharges.Label" bundle="${oh_labels}"/>' onclick ="recordCharges();"  <%=record_charges_butn_disabled%>> -->
											<%
												}else{
											%>
												<font color="blue"><a style="cursor:pointer"><fmt:message key="eOH.EditCharges.Label" bundle="${oh_labels}"/></a> &nbsp;&nbsp;</font>
											<%
												}
											}
											%>
											</td>
							<%
										}
									}
								}
								
								if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
									if(billing_appl_yn.equals("Y") && temp_disable.equals("N") && !task_code.equals("") && order_catalog_bill_yn.equals("Y")){
										if(treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80") || result_completed.equals("Y")) {
							%>
											<td class="button" align="right" id="save_reset_button">
							<%
										}
										else{
							%>
											<td class="button"  colspan = "4" align="right" id="save_reset_button">
							<%
										}
									}
									else{
							%>
										<td class="button" colspan = "4" align="right" id="save_reset_button">
							<%
									}
								}
								else{
							%>
									<td class="button" colspan = "4" align="right" id="save_reset_button">
							<%
								}
							%>
								<!--Commented and Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480) -->
								<!-- <input type="button" class="button" id = "record_button" name="save" id="save" value='<%=record_button_legend%>' onclick ="actionToServlet('<%=treatment_status_param%>');" <%=record_button_disabled%> <%=status_disabled%> <%=record_trmt_button_disabled%>>&nbsp; -->
								<!--Commented by Sharon Crasta on 7/27/2009 for Print Preview-->
								<!-- <input type="button" class="button" name="Print Chart" id="Print Chart" value='Print Preview' onclick="printOverview();">  -->
								
							 <%
								 
							   if(treatment_flag.equals("Y")){
							 %>
									<input type="button" class="button" id = "record_button" name="save" id="save" value='<%=record_button_legend%>' onclick ="actionToServlet('<%=treatment_status_param%>');" disabled>&nbsp;
							<%	
							
							}else{
							 %>
									<input type="button" class="button" id = "record_button" name="save" id="save" value='<%=record_button_legend%>' onclick ="actionToServlet('<%=treatment_status_param%>');" <%=record_button_disabled%> <%=status_disabled%> <%=record_trmt_button_disabled%> <%=trmt_ot_disable%>>&nbsp;
							<%
							}
							%>
								
								<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="Treatment_Reset_Button(document.forms[0])" <%=disabled%> <%=status_disabled%>>
							</td>
						</tr>	
					</table>
	<!-- Comments @DentalTreatment.jsp By Muthukumar on 20-09-2011  - Treatment Forms Ends here -->
					<input type = "hidden" name= "locale" value = "<%=locale%>">
					<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
					<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
					<input type = "hidden" name= "ca_practitioner_id" value = "<%=ca_practitioner_id%>">
					<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
					<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
					<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
					<input type = "hidden" name= "location_code" value = "<%=location_code%>">
					<input type = "hidden" name= "location_type" value = "<%=location_type%>">

					<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
					<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
					<input type = "hidden" name= "mixed_dentition_YN" value = "<%=mixed_dentition_YN%>">
					<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
					<input type = "hidden" name= "chart_type" value = "<%=chart_type%>">
					<input type = "hidden" name='header_tab' id='header_tab' value=<%=header_tab%> >
					<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
					<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
					<input type = "hidden" name= "tab_name" value = "">

					<input type="hidden" name='show_new_active_yn' id='show_new_active_yn' value=<%=show_new_active_yn%> >
					<input type="hidden" name='chart_hdr_insert_yn' id='chart_hdr_insert_yn' value="" >
					<input type="hidden" name='thrng_nos_ref' id='thrng_nos_ref' value="<%=thrng_nos_ref%>" >
					<input type="hidden" name='thrng_nos' id='thrng_nos' value="<%=thrng_nos%>" >
					<input type="hidden" name='called_from_viewchart_yn' id='called_from_viewchart_yn' value="<%=called_from_viewchart_yn%>" >
					<input type="hidden" name='baseline_chart_yn' id='baseline_chart_yn' value="<%=baseline_chart_yn%>" >
					<input type="hidden" name='chart_line_num' id='chart_line_num' value="<%=chart_line_num%>" >
					<input type="hidden" name='ind_chart_line_num' id='ind_chart_line_num' value="<%=ind_chart_line_num%>" >
					<input type="hidden" name='cat_code' id='cat_code' value="<%=cat_code%>" >
					<input type="hidden" name='clinical_group_code' id='clinical_group_code' value="" >
					<input type = "hidden" name= "clinical_group_hid" value = ""> 
					<input type = "hidden" name= "remarks" value = "<%=remarks%>"> 
					<input type = "hidden" name= "display_tooth_no" value = "<%=display_tooth_no%>"> 
					<!-- <input type = "hidden" name= "reasonforcancel" value = "">  -->
					<input type = "hidden" name= "reasonforcancel" value = ""> 
					<input type = "hidden" name= "params" value = "<%=params%>"> 
					<input type = "hidden" name= "status_for_filling" value = "<%=treatment_status_param%>"> 
					<input type = "hidden" name= "RD_Normal_yn" value = "<%=flag%>"> 

					<!-- These are for the disabled fields. Take the values from these fields in the servlet to insert into database -->
					<input type = "hidden" name= "category" value = "">
					<input type = "hidden" name= "site" value = "">
					<input type = "hidden" name= "area" value = "">
					<input type = "hidden" name= "treatment" value = "">
					<input type = "hidden" name= "oh_status" value = "">
					<input type = "hidden" name= "outcome" value = "">
					<input type = "hidden" name= "outcome_new" value = "<%=outcome%>">
					<input type = "hidden" name= "treatment_status_param" value = "<%=treatment_status_param%>">
					<input type = "hidden" name= "order_id" value = '<%=checkForNull(request.getParameter( "order_id" ))%>'>
					<input type = "hidden" name= "order_line_num" value = '<%=checkForNull(request.getParameter( "order_line_num" ))%>'>
					<input type = "hidden" name= "trmt_code" value = '<%=trmt_code%>'>
					<input type = "hidden" name= "task_code" value = '<%=checkForNull(request.getParameter( "task_code" ))%>'> 
					<input type = "hidden" name= "task_desc" value = "<%=java.net.URLEncoder.encode(task_desc,"UTF-8")%>"> 
					<!--Added single quotes for task_desc IN023245 by AnithaJ   -->
					<input type = "hidden" name= "date_diff_flag" value = "<%=date_diff_flag%>"> 
					<input type = "hidden" name= "seq_no" value = "<%=seq_no%>"> 
					<input type = "hidden" name= "diagcodeselected" value = ""> 
					<input type = "hidden" name= "comp_code_selected" value = ""> 
					<input type = "hidden" name= "arch_quad" value = "<%=arch_quad%>"> 
					<input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="N" >

					<input type='hidden' name='bean_id' id='bean_id' value= 'Or_RegisterOrder'>
					<input type='hidden' name='bean_name' id='bean_name' value= 'eOR.RegisterOrder'>
					<input type='hidden' name='total_recs' id='total_recs' value= '1'>
					<input type='hidden' name='chk0' id='chk0' value= 'on'>
					<input type="hidden" name="ord_id0" id="ord_id0" value = '<%=checkForNull(request.getParameter( "order_id" ))%>'>
					<input type='hidden' name='cont_order_ind0' id='cont_order_ind0' value= ''>
					<input type='hidden' name='appt_ref_num0' id='appt_ref_num0' value= '<%=checkForNull(request.getParameter( "appt_ref_no" ))%>'>
					<input type='hidden' name='appt_reqd_yn' id='appt_reqd_yn' value= '<%=appt_reqd_yn%>'>
					<input type='hidden' name='encounter_id0' id='encounter_id0' value = "<%=encounter_id%>">
					<input type='hidden' name='view_by0' id='view_by0' value= 'H'>
					<input type="hidden" name= "practitioner_id" value = "<%=ca_practitioner_id%>">
					<input type='hidden' name='mode' id='mode' value= '1'>
					<input type='hidden' name='line_id0' id='line_id0' value= '<%=checkForNull(request.getParameter( "order_line_num" ))%>'>
					<input type='hidden' name='bl_total_charge' id='bl_total_charge' value= '<%=checkForNull(request.getParameter("bl_total_charge"))%>'>
					<input type='hidden' name='bl_task_charge' id='bl_task_charge'  value= '<%=checkForNull(request.getParameter("bl_task_charge"))%>'>
					<input type='hidden' name='trmt_order_catalog_code' id='trmt_order_catalog_code'  value= '<%=trmt_order_catalog_code%>'>
					<input type='hidden' name='task_order_catalog_code' id='task_order_catalog_code'  value= '<%=task_order_catalog_code%>'>

					<!-- Variables for Billing Function -->
					<input type='hidden' name='billing_appl_yn' id='billing_appl_yn'  value= '<%=billing_appl_yn%>'>
					<input type='hidden' name='bl_key' id='bl_key'  value= '<%=bl_key%>'>
					<input type='hidden' name='bl_key_line_no' id='bl_key_line_no'  value= ''>
					<input type='hidden' name='bl_task_code' id='bl_task_code'  value= ''>
					<input type='hidden' name='bl_patient_id' id='bl_patient_id'  value= ''>
					<input type='hidden' name='bl_episode_type' id='bl_episode_type'  value= ''>
					<input type='hidden' name='bl_episode_id' id='bl_episode_id'  value= ''>
					<input type='hidden' name='bl_visit_id' id='bl_visit_id'  value= ''>
					<input type='hidden' name='bl_encounter_id' id='bl_encounter_id'  value= ''>
					<input type='hidden' name='bl_service_date' id='bl_service_date'  value= ''>
					<!-- <input type='hidden' name='bl_P' id='bl_P'  value= ''> -->
					<input type='hidden' name='bl_pract_staff_id' id='bl_pract_staff_id'  value= ''>
					<input type='hidden' name='bl_serv_panel_ind' id='bl_serv_panel_ind'  value= ''>
					<input type='hidden' name='bl_serv_panel_code' id='bl_serv_panel_code'  value= ''>
					<input type='hidden' name='bl_panel_str' id='bl_panel_str'  value= ''>
					<input type='hidden' name='bl_total_payable' id='bl_total_payable'  value= ''>
					<input type='hidden' name='bl_patient_payable' id='bl_patient_payable'  value= ''>
					<input type='hidden' name='bl_preapp_yn' id='bl_preapp_yn'  value= ''>
					<input type='hidden' name='bl_patient_paid_amt' id='bl_patient_paid_amt'  value= ''>
					<input type='hidden' name='bl_charged_yn' id='bl_charged_yn'  value= ''>
					<input type='hidden' name='bl_quantity' id='bl_quantity'  value= ''>
					<input type='hidden' name='bl_total_payable_for_trmt' id='bl_total_payable_for_trmt'  value= '<%=bl_total_payable_for_trmt%>'>
					<input type='hidden' name='total_existing_task_amount' id='total_existing_task_amount'  value= ''>
					<input type='hidden' name='charging_stage' id='charging_stage'  value= '<%=charging_stage%>'>
					<!-- Added by Sharon Crasta on 2/3/2009 --- Variable for callingBillingWindow-->
					<input type='hidden' name='bill_sub_regn_num' id='bill_sub_regn_num'  value= '<%=bill_sub_regn_num%>'>
					<input type='hidden' name='bill_sub_regn_line_num' id='bill_sub_regn_line_num'  value= '<%=bill_sub_regn_line_num%>'>

					<input type='hidden' name='bl_data_exists_yn' id='bl_data_exists_yn'  value= '<%=bl_data_exists_yn%>'>
					<input type='hidden' name='billed_yn' id='billed_yn'  value= '<%=billed_yn%>'>
					<input type='hidden' name='order_catalog_bill_yn' id='order_catalog_bill_yn'  value= '<%=order_catalog_bill_yn%>'>
					<!-- Added by Sharon Crasta on 10/13/2008 --- Variable for Registered Date/Time-->
					<input type='hidden' name='regn_date_time1' id='regn_date_time1'  value= '<%=regn_date_time%>'>
					
					<!-- Added by Sharon Crasta on 3/14/2009 for CRF #0423 Facility/Enterprise -->
					<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
					<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
					<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
				
				    <!--Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)-->
					<input type = "hidden" name= "treatment_flag" value = "<%=treatment_flag%>">
					<input type = "hidden" name= "task_seq_no" value = "<%=task_seq_no%>">
					<input type = "hidden" name= "record_trmt_button_disabled" value = "<%=record_trmt_button_disabled%>">
					<input type = "hidden" name= "trmt_done_yn" value = "<%=trmt_done_yn%>">
					<!-- -->
					<!--  written by parul on 151008 for multiple surface -->
					<input type="hidden" name='no_of_surface' id='no_of_surface' value="<%=no_of_surface%>" > 

					<!-- These variables are used in the developing Menu -->
					<input type="hidden" name="function_id_list" id="function_id_list" value="">		
					<input type="hidden" name="function_name_list" id="function_name_list" value="">		
					<input type="hidden" name="function_type_list" id="function_type_list" value="">
					<input type="hidden" name="function_type_desc_list" id="function_type_desc_list" value="">
					<input type="hidden" name="function_cat_code_list" id="function_cat_code_list" value="">

					<!--  written by parul on 24/08/2009 for CRF#0483 -->
					<input type="hidden" name='cusptip_ref' id='cusptip_ref' value="" >
					<input type = "hidden" name= "surface_hid" value = "<%=surface%>"> 
					<input type = "hidden" name= "cusp_tip_code_hid" value = "<%=cusp_tip_code%>"> 

					<input type="hidden" name='override_inc_exl' id='override_inc_exl' value="" >
					<input type="hidden" name='reason_override_inc_exl' id='reason_override_inc_exl' value="" >
					<input type="hidden" name='ext_perm_loc_param' id='ext_perm_loc_param' value="<%=ext_perm_loc_param%>" >
					<!-- Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700-->
					<input type="hidden" name='dentist_comments' id='dentist_comments' value="<%=dentist_comments%>" >
					<input type="hidden" name="performed_In_OT" id="performed_In_OT" value="<%=val%>">
					<input type="hidden" name="dc_bl_episode_type" id="dc_bl_episode_type" value="<%=dc_bl_episode_type%>">
					<!-- Added by yadav on 10/24/2009-->
					<input type="hidden" name="ohContext" id="ohContext" value="<%=request.getContextPath()%>">
					<!-- Added by yadav on 1/19/2010-->
					<input type="hidden" name="orderDate" id="orderDate" value="<%=orderDate%>">

					<!-- Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages -->
					<input type="hidden" name='super_tooth_ref' id='super_tooth_ref' value="<%=flag1%>" >

					<!-- Added by Sharon Crasta on 12/11/2009 for IN016953-->
					<input type="hidden" name="trmt_status_param_extraction" id="trmt_status_param_extraction" value="<%=treatment_status_param_for_extraction%>">

					<!-- added by parul for SRR-CRF20056-0442 on 12/01/2010-->
					<input type="hidden" name='surface_ref' id='surface_ref' value="" >

					<!-- //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894 -->
					<input type="hidden" name='super_key_num' id='super_key_num' value="<%=super_key_num%>" >
					<input type="hidden" name='ref_tooth_no' id='ref_tooth_no' value="<%=ref_tooth_no%>" >
					<!-- Added by Sharon Crasta on 2/5/2010 for SRR20056-CRF-0485(IN010920) -->
					<input type="hidden" name='task_status_orig' id='task_status_orig' value="<%=task_status_orig%>" >
					<!-- -->
					<!-- Added by Sharon Crasta on 2/15/2010 for IN019319 -->
					<input type="hidden" name='order_id_for_add' id='order_id_for_add' value="<%=order_id_for_add%>" >
					<!-- -->
					<input type = "hidden" name= "selected_first_thno" value = "<%=selected_first_thno%>"> 
					<input type = "hidden" name= "progression_ref" value = "<%=progression_ref%>">
					<!-- Added by Sharon Crasta on 2/16/2010 for SRR20056-CRF-0475(IN010868)-->
					<input type = "hidden" name= "pontic_tooth_values" value = "<%=pontic_tooth_values%>"> 
					<input type = "hidden" name= "tooth_range" value = "<%=tooth_range%>"> 

					<input type="hidden" name='sub_parts' id='sub_parts' value="<%=maxila_sub_parts%>" >

					<!-- Added by Sridevi Joshi on 8/20/2010 for IN023363 -->
					<input type="hidden" name='oh_surface_hid' id='oh_surface_hid' value="" >

					</form>
				<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
					<table id='tooltiptable' cellpadding="3" cellspacing=0 border='0' width='100%' align='center'>
						<tr>
							<td width='100%' id='menu_table' class="Menu"></td>
							<!-- </td> -->
						</tr>
					</table>
				</div> 
			</body>
		</html>
	<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
	}
	%>




