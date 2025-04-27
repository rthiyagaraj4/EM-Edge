<!DOCTYPE html>
<%@ page import = "eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>External applications</title>
<style type="text/css">
#centerTable {
    position:fixed;
    top: 10%;
    left: 15%;
    margin-top: 2em; /*set to a negative number 1/2 of your height*/
    margin-left: 3em; /*set to a negative number 1/2 of your width*/
}
</style>
<SCRIPT TYPE="text/javascript" SRC="${pageContext.request.contextPath}/eXH/js/ExternalApplication.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC="${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js"></SCRIPT>
<script src='${pageContext.request.contextPath}/eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<FORM ID="showExternalApps" name="showExternalApps" id="showExternalApps" METHOD="post">
<BODY leftmargin=0 topmargin=0 >
<c:set var="reqParams" value="<%= XHUtil.getRequestParams(request) %>" />
<TABLE CELLSPACING="1" CELLPADDING="3" ALIGN="center" ID="centerTable">
<TR>
	<TD CLASS="LABEL">Applications</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="applicationID" name="applicationID" id="applicationID" onChange="invokeEMExternalApp('${pageContext.request.contextPath}')" STYLE="width:150px">
		<c:forEach var="application" items="${applications}">
			<OPTION VALUE="${application.key}">${application.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
</TABLE>
<INPUT TYPE='hidden' name='P_USE_ID' id='P_USE_ID' ID='P_USE_ID' VALUE="${reqParams.P_USE_ID}">
<INPUT TYPE='hidden' name='P_INV_ORG_ID' id='P_INV_ORG_ID' ID='P_INV_ORG_ID' VALUE="${reqParams.P_INV_ORG_ID}">
<INPUT TYPE='hidden' name='P_ENCNTR_DATE' id='P_ENCNTR_DATE' ID='P_ENCNTR_DATE' VALUE="${reqParams.P_ENCNTR_DATE}">
<INPUT TYPE='hidden' name='P_EPISODE_ID' id='P_EPISODE_ID' ID='P_EPISODE_ID' VALUE="${reqParams.P_EPISODE_ID}">
<INPUT TYPE='hidden' name='callType' id='callType' ID='callType' VALUE="${reqParams.callType}">
<INPUT TYPE='hidden' name='P_ACCESSION_NUM' id='P_ACCESSION_NUM' ID='P_ACCESSION_NUM' VALUE="${reqParams.P_ACCESSION_NUM}">
<INPUT TYPE='hidden' name='P_MULTI_LANG_YN' id='P_MULTI_LANG_YN' ID='P_MULTI_LANG_YN' VALUE="${reqParams.P_MULTI_LANG_YN}">
<INPUT TYPE='hidden' name='P_CUST_CODE' id='P_CUST_CODE' ID='P_CUST_CODE' VALUE="${reqParams.P_CUST_CODE}">
<INPUT TYPE='hidden' name='P_RESP_ID' id='P_RESP_ID' ID='P_RESP_ID' VALUE="${reqParams.P_RESP_ID}">
<INPUT TYPE='hidden' name='P_Ext_Input_Key' id='P_Ext_Input_Key' ID='P_Ext_Input_Key' VALUE="${reqParams.P_Ext_Input_Key}">
<INPUT TYPE='hidden' name='P_ACCESS_RIGHTS' id='P_ACCESS_RIGHTS' ID='P_ACCESS_RIGHTS' VALUE="${reqParams.P_ACCESS_RIGHTS}">
<INPUT TYPE='hidden' name='P_PHYSICIAN_ID' id='P_PHYSICIAN_ID' ID='P_PHYSICIAN_ID' VALUE="${reqParams.P_PHYSICIAN_ID}">
<INPUT TYPE='hidden' name='P_PATIENT_ID' id='P_PATIENT_ID' ID='P_PATIENT_ID' VALUE="${reqParams.P_PATIENT_ID}">
<INPUT TYPE='hidden' name='P_ORDER_TYPE_CODE' id='P_ORDER_TYPE_CODE' ID='P_ORDER_TYPE_CODE' VALUE="${reqParams.P_ORDER_TYPE_CODE}">
<INPUT TYPE='hidden' name='P_FUNCTION_ID' id='P_FUNCTION_ID' ID='P_FUNCTION_ID' VALUE="${reqParams.P_FUNCTION_ID}">
<INPUT TYPE='hidden' name='P_Ext_Application_ID' id='P_Ext_Application_ID' ID='P_Ext_Application_ID' VALUE="${reqParams.P_Ext_Application_ID}">
<INPUT TYPE='hidden' name='P_MODULE_ID' id='P_MODULE_ID' ID='P_MODULE_ID' VALUE="${reqParams.P_MODULE_ID}">
<INPUT TYPE='hidden' name='P_Connect_string' id='P_Connect_string' ID='P_Connect_string' VALUE="${reqParams.P_Connect_string}">
<INPUT TYPE='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' ID='P_FACILITY_ID' VALUE="${reqParams.P_FACILITY_ID}">
<INPUT TYPE='hidden' name='P_LOCN_CODE' id='P_LOCN_CODE' ID='P_LOCN_CODE' VALUE="${reqParams.P_LOCN_CODE}">
<INPUT TYPE='hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' ID='P_LANGUAGE_ID' VALUE="${reqParams.P_LANGUAGE_ID}">
<INPUT TYPE='hidden' name='P_ITEM_CODE' id='P_ITEM_CODE' ID='P_ITEM_CODE' VALUE="${reqParams.P_ITEM_CODE}">
<INPUT TYPE='hidden' name='P_pwd' id='P_pwd' ID='P_pwd' VALUE="${reqParams.P_pwd}">
<INPUT TYPE='hidden' name='P_MULTI_SITE_YN' id='P_MULTI_SITE_YN' ID='P_MULTI_SITE_YN' VALUE="${reqParams.P_MULTI_SITE_YN}">
<INPUT TYPE='hidden' name='P_EPISODE_TYPE' id='P_EPISODE_TYPE' ID='P_EPISODE_TYPE' VALUE="${reqParams.P_EPISODE_TYPE}">
<INPUT TYPE='hidden' name='P_LOCN_TYPE' id='P_LOCN_TYPE' ID='P_LOCN_TYPE' VALUE="${reqParams.P_LOCN_TYPE}">
<INPUT TYPE='hidden' name='P_WS_NO' id='P_WS_NO' ID='P_WS_NO' VALUE="${reqParams.P_WS_NO}">
<INPUT TYPE='hidden' name='P_Ext_Function' id='P_Ext_Function' ID='P_Ext_Function' VALUE="${reqParams.P_Ext_Function}">
<INPUT TYPE='hidden' name='P_ORDER_ID' id='P_ORDER_ID' ID='P_ORDER_ID' VALUE="${reqParams.P_ORDER_ID}">
<INPUT TYPE='hidden' name='P_VISIT_ID' id='P_VISIT_ID' ID='P_VISIT_ID' VALUE="${reqParams.P_VISIT_ID}">
<INPUT TYPE='hidden' name='P_ENC_STATUS' id='P_ENC_STATUS' ID='P_ENC_STATUS' VALUE="${reqParams.P_ENC_STATUS}">
<INPUT TYPE='hidden' name='P_LOCN_DESC' id='P_LOCN_DESC' ID='P_LOCN_DESC' VALUE="${reqParams.P_LOCN_DESC}">
</BODY>
</FORM>
</html>

