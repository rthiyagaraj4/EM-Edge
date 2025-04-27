<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SetUpParameterForFacilityHiddenForm" id="SetUpParameterForFacilityHiddenForm"  action="../../servlet/eOT.SetUpParameterForFacilityServlet" method="post" target="messageFrame"> 

	<input type='hidden' name="OPERATING_FACILITY_ID" id="OPERATING_FACILITY_ID"          value="">
	<input type='hidden' name="BOOKING_NUM_YEAR" id="BOOKING_NUM_YEAR"               value="">
	<input type='hidden' name="NEXT_BOOKING_NUM" id="NEXT_BOOKING_NUM"               value="">
	<input type='hidden' name="MAX_BOOKING_NUM" id="MAX_BOOKING_NUM"                value="">
	<input type='hidden' name="UNIT_OT_TIME" id="UNIT_OT_TIME"                   value="">
	<input type='hidden' name="START_OT_BOOKING_TIME" id="START_OT_BOOKING_TIME"          value="">
	<input type='hidden' name="END_OT_BOOKING_TIME" id="END_OT_BOOKING_TIME"            value="">
	<input type='hidden' name="START_HOL_BOOK_TIME" id="START_HOL_BOOK_TIME"            value="">
	<input type='hidden' name="END_HOL_BOOK_TIME" id="END_HOL_BOOK_TIME"              value="">
	<input type='hidden' name="OPER_NUM_DATE_IP" id="OPER_NUM_DATE_IP"               value="">
	<input type='hidden' name="OPER_NUM_DATE_OP" id="OPER_NUM_DATE_OP"               value="">
	<input type='hidden' name="NEXT_OPER_NUM_IP" id="NEXT_OPER_NUM_IP"               value="">
	<input type='hidden' name="MAX_OPER_NUM_IP" id="MAX_OPER_NUM_IP"                value="">
	<input type='hidden' name="NEXT_OPER_NUM_OP" id="NEXT_OPER_NUM_OP"               value="">
	<input type='hidden' name="MAX_OPER_NUM_OP" id="MAX_OPER_NUM_OP"                value="">
	<input type='hidden' name="OT_SEC1_NOTICE_FM_TIME" id="OT_SEC1_NOTICE_FM_TIME"         value="">
	<input type='hidden' name="OT_SEC1_NOTICE_TO_TIME" id="OT_SEC1_NOTICE_TO_TIME"         value="">
	<input type='hidden' name="OT_SEC2_NOTICE_FM_TIME" id="OT_SEC2_NOTICE_FM_TIME"         value="">
	<input type='hidden' name="OT_SEC2_NOTICE_TO_TIME" id="OT_SEC2_NOTICE_TO_TIME"         value="">
	<input type='hidden' name="OT_SEC3_NOTICE_FM_TIME" id="OT_SEC3_NOTICE_FM_TIME"         value="">
	<input type='hidden' name="OT_SEC3_NOTICE_TO_TIME" id="OT_SEC3_NOTICE_TO_TIME"         value="">
	<input type='hidden' name="LAST_STK_UPDATED_DATE" id="LAST_STK_UPDATED_DATE"          value="">
	<input type='hidden' name="BL_INTERFACE_FLAG" id="BL_INTERFACE_FLAG"              value="">
	<input type='hidden' name="DEF_ST_STORE" id="DEF_ST_STORE"                   value="">
	<input type='hidden' name="ST_DOC_TYPE_SLI" id="ST_DOC_TYPE_SLI"                value="">
	<input type='hidden' name="ST_DOC_TYPE_SLO" id="ST_DOC_TYPE_SLO"                value="">
	<input type='hidden' name="ST_DOC_TYPE_SLR" id="ST_DOC_TYPE_SLR"                value="">
	<input type='hidden' name="ST_DOC_TYPE_RTI" id="ST_DOC_TYPE_RTI"                value="">
	<input type='hidden' name="ST_DOC_TYPE_RTO" id="ST_DOC_TYPE_RTO"                value="">
	<input type='hidden' name="ST_DOC_TYPE_RTR" id="ST_DOC_TYPE_RTR"                value="">
	<input type='hidden' name="ST_INTERFACE_FLAG" id="ST_INTERFACE_FLAG"              value="">
	<input type='hidden' name="WAIT_LIST_NUM_YEAR" id="WAIT_LIST_NUM_YEAR"             value="">
	<input type='hidden' name="NEXT_WAITLIST_NUM" id="NEXT_WAITLIST_NUM"              value="">
	<input type='hidden' name="MAX_WAITLIST_NUM" id="MAX_WAITLIST_NUM"               value="">
	<input type='hidden' name="PRINT_BOOKING_SLIP" id="PRINT_BOOKING_SLIP"             value="">
	<input type='hidden' name="CSSD_INTERFACE_YN" id="CSSD_INTERFACE_YN"              value="">
	<input type='hidden' name="SS_DCO_TYPE_CODE" id="SS_DCO_TYPE_CODE"               value="">
	<input type='hidden' name="INV_DOC_TYPE" id="INV_DOC_TYPE"                   value="">
	<input type='hidden' name="MED_SER_GRP_CODE" id="MED_SER_GRP_CODE"               value="">
	<input type='hidden' name="CSSD_STORE_CODE" id="CSSD_STORE_CODE"                value="">
	<input type='hidden' name="SEC_TASKS_PORTER_TRFR_IN" id="SEC_TASKS_PORTER_TRFR_IN"       value="">
	<input type='hidden' name="SEC_TASKS_PORTER_TRFR_OUT" id="SEC_TASKS_PORTER_TRFR_OUT"      value="">
	<input type='hidden' name="CHECKLIST_ALERT_TYPE" id="CHECKLIST_ALERT_TYPE"           value="">
	<input type='hidden' name="PAC_REVIEW_ORDERABLE" id="PAC_REVIEW_ORDERABLE"           value="">
	<input type='hidden' name="WARN_LIMIT_WAITLIST_DAYS" id="WARN_LIMIT_WAITLIST_DAYS"       value="">
	<input type='hidden' name="WARN_UNSCHEDULED_CASES_ONLY" id="WARN_UNSCHEDULED_CASES_ONLY"    value="">
	<input type='hidden' name="BIOMET_CHK_ON_PAT_CHK_IN_TO_OT" id="BIOMET_CHK_ON_PAT_CHK_IN_TO_OT" value="">
	<input type='hidden' name="IPBOOKING_WITH_THEATRE_YN" id="IPBOOKING_WITH_THEATRE_YN"      value="">
	<input type='hidden' name="BKG_FIN_ALERT_FOR_OP" id="BKG_FIN_ALERT_FOR_OP"           value="">
	<input type='hidden' name="BKG_FIN_ALERT_FOR_EM" id="BKG_FIN_ALERT_FOR_EM"           value="">
	<input type='hidden' name="CHK_SURGEON_DOC_CMPL_FOR_STS" id="CHK_SURGEON_DOC_CMPL_FOR_STS"   value="">
	<input type='hidden' name="CHK_NURSING_DOC_CMPL_FOR_STS" id="CHK_NURSING_DOC_CMPL_FOR_STS"   value="">
	<input type='hidden' name="CHK_INTRA_DOC_CMPL_FOR_STS" id="CHK_INTRA_DOC_CMPL_FOR_STS"     value="">
	<input type='hidden' name="DISP_LAST_ANTIB_PREOP_YN" id="DISP_LAST_ANTIB_PREOP_YN"       value="">
	<input type='hidden' name="NO_OF_SWAB_COUNT_REQD" id="NO_OF_SWAB_COUNT_REQD"          value="">
 </form>
</body>
 </html>



