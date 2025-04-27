<!DOCTYPE html>
<%@ page import= "java.text.*,java.sql.Types,java.sql.Statement,java.sql.CallableStatement,java.sql.Connection,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page language="java"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script src="../../eCommon/js/dchk.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" ></script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_id = request.getParameter("function_id");
	String source = url + params ;
	String url_name = "";

	if(function_id.equals("DSR_MEAL_DISTR_LIST")){
		url_name = "Rep_MealDistributionList.jsp";%>
		<script src="../../eDS/js/Rep_MealDistributionList.js" ></script>
	<%}

	else if(function_id.equals("DSR_MASTER_REPORT")){
		url_name = "Rep_MasterCodeList.jsp";%>
		<script src="../../eDS/js/Rep_MasterCodeList.js" ></script>
	<%}


	else if(function_id.equals("DSR_COMM_FORMULA_LIST")){
		url_name = "CommercialFormulaReportCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/CommercialFormula.js"></Script>
	<%}
	else if(function_id.equals("DSR_ATTND_MEAL_LIST")){
		url_name = "AttendMealListCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/AttendMealList.js"></Script>
	<%}
	else if(function_id.equals("DSR_STAFFORD_LIST")){
		url_name = "StaffMealOrderList.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/StaffMealOrderList.js"></Script>
	<%} //PMG2013-CRF-0009.1-US003 Start
	else if(function_id.equals("DSR_CAN_ORD_LIST")){
		url_name = "CancelledOrderList.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/CancelledOrderList.js"></Script>
	<%} //PMG2013-CRF-0009.1-US003 End
	else if(function_id.equals("DSR_NEW_ADD_LIST")){
		url_name = "RepNewAdmissionListCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/NewAdmissionList.js"></Script>
	<%}

	else if(function_id.equals("DSR_COMM_FORMULA_DIST_LIST")){
		url_name = "DSCommercialFormulaDistribution.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DSCommercialFormulaDistribution.js"></Script>
	<%}
	else if(function_id.equals("DSR_MEAL_LIST")){
		url_name = "DSMeallistReport.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DsMealList.js"></Script>
	<%}
	else if(function_id.equals("DSR_SP_FOOD_REQD")){
		url_name = "SpecialFoodRequire.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/SpecialFoodRequire.js"></Script>
	<%}
	else if(function_id.equals("DSR_WORKLIST")){
		url_name = "DSWorklistReport.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DsWorkList.js"></Script>
	<%}
	else if(function_id.equals("DSR_MENU_FOR_DIET_TYPE")){
		url_name = "MenuforDietType.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MenuforDietType.js"></Script>
	<%}
	 else if(function_id.equals("DSR_BIRTHDAY_LIST")){
		url_name = "BirthdayList.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/BirthdayList.js"></Script>
	<%}
    else if(function_id.equals("DSR_MEAL_ITEM_REJECTIONS")){
		url_name = "MealItemRejection.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealItemRejection.js"></Script>
	<%}
	 else if(function_id.equals("DSR_DIET_TYPE_MOVEMENT")){
		url_name = "DietTypeMovement.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DietTypeMovement.js"></Script>
	<%}
	 else if(function_id.equals("DSR_MEAL_ORDER_LIST")){
		url_name = "MealOrderList.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealOrderList.js"></Script>
	<%}
	 else if(function_id.equals("DSR_DAILY_STATISTICS")){
		url_name = "DailyStatisticsCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DailyStatistics.js"></Script>
	<%}
	 else if(function_id.equals("DSR_MONTHLY_STATISTICS")){
		url_name = "RepMonthlyStatisticsCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/RepMonthlyStatistics.js"></Script>
	<%}
	 else if(function_id.equals("DSR_YEARLY_STATISTICS")){
		url_name = "YearlyStatisticsCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/YearlyStatistics.js"></Script>
	<%}
	 else if(function_id.equals("DSR_MEAL_TICKETS")){
		url_name = "MealTicketsCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealTickets.js"></Script>
	<%}//MMS-DM-CRF-0044
	 else if(function_id.equals("DSR_MEAL_TICKETS_FR_ATTENDANT")){
		url_name = "MealTicketsAttendantsCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealTickets.js"></Script>
	<%}//MMS-DM-CRF-0044
	 else if(function_id.equals("DSR_SPL_FOOD_TICKET")){
		url_name = "SpecialFoodTicketsCud.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/SpecialFoodTickets.js"></Script>
	<%}
	 else if(function_id.equals("DSR_MEAL_ORDER_LIST_OP")){
		url_name = "OPMealOrderList.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/OPMealOrderList.js"></Script>
	<%}	//MMOH-CRF-0407
	 else if(function_id.equals("DSR_MEAL_TICKET_OP_EM_PATIENT")){
		url_name = "MealTicketForOPAndEMPatient.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealTicket_OP_EM.js"></Script>
	<%}	//MMOH-CRF-0407
	//ML-MMOH-CRF-0413_US1
	 else if(function_id.equals("DSR_MEAL_ACKNOWLEDGE_REPORT")){
		url_name = "MealAcknowledgeReport.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealAcknowledgeReport.js"></Script>
	<%}	//ML-MMOH-CRF-0413_US1
	//ML-MMOH-CRF-0413_US8
	 else if(function_id.equals("DSR_MEAL_ACK_REP_FOR_OP_EM_PAT")){
		url_name = "MealAcknowledgeReportOPAndEM.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealAcknowledgeReportOPAndEM.js"></Script>
	<%}//ML-MMOH-CRF-0413_US8
	//MMS-QH-CRF- 0079_US11
	 else if(function_id.equals("DSR_SUPPLEMENTARY_MEAL_TICKET")){
		url_name = "DSSupplementaryMealtickets.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DSSupplementaryMealtickets.js"></Script>
	<%}//MMS-QH-CRF- 0079_US11
	//ML-MMOH-CRF-0730_US02
	 else if(function_id.equals("DSR_DOC_ACK_REP_FOR_STAFF")){
		url_name = "DocAcknowledgeReportForStaff.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/DocAcknowledgeReportForStaff.js"></Script>
	<%}//ML-MMOH-CRF-0730_US02
	//ML-MMOH-CRF-0599_US01
	 else if(function_id.equals("DS_REJECTED_MEALS")){
		url_name = "MealRejection.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealRejection.js"></Script>
	<%}//ML-MMOH-CRF-0599_US01
	
	//ML-MMOH-CRF-0675_US01
	else if(function_id.equals("DSR_MEAL_TICKET_STAFF")){
		url_name = "MealTicketForStaff.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealTicketsForStaff.js"></Script>
	<%}//ML-MMOH-CRF-0675_US01
	
	//ML-MMOH-CRF-0680
	else if(function_id.equals("DSR_MEAL_PROD_SUMM")){
		url_name = "MealProductionSummary.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MealProductionSummary.js"></Script>
	<%}//ML-MMOH-CRF-0680	
	 //KDAH-CRF-0351
	 else if(function_id.equals("DSR_FLR_FEED_TYPE")){
		url_name = "FloorFeedType.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/FloorFeedType.js"></Script>
	<%}//KDAH-CRF-0351
	//ML-MMOH-CRF-0598
	 else if(function_id.equals("DSR_MED_FOOD_ORD_LST")){
		url_name = "MedicalFoodOrder.jsp"; %>
		<Script Language="JavaScript" src="../../eDS/js/MedicalFoodOrder.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}//ML-MMOH-CRF-0598
	url_name="../../eDS/jsp/"+url_name+"?"+params;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_rep' id='f_query_rep' src=<%=url_name%>  frameborder=0 style='height:84vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
	<iframe name='dummy_rep_frame' id='dummy_rep_frame' src="../../eCommon/html/blank.html" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
</html>

