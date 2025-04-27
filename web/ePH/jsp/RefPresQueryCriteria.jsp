<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/RefPres.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmReferralPrescriptionQueryCriteria" id="frmReferralPrescriptionQueryCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<%
	String bean_id		= "ADRReportBean" ;
	String bean_name	= "ePH.ADRReportBean";

	ADRReportBean bean = (ADRReportBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	String patient_id	=	request.getParameter("patient_id");
	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable">
	<tr>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_patient_id" id="p_patient_id" size="20" value="" <%=status%> maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" onblur="Duplicatecheck();getPatientValues()"><!--  Duplicatecheck(); added for ML-BRU-SCF-0621[IN036565]-->
			<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"  <%=status%>><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
		<td class="label">
			<label  style='font-size:9;display:none' id="patient_name"></label>&nbsp;&nbsp;
		</td>
		<td class="label">
			<label  style='font-size:9;display:none' id="patient_sex"></label>
		</td>
		<td class="label">
			<label  style='font-size:9;display:none' id="patient_age"></label>
		</td>
		<td>&nbsp;
			
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="order_date_from" id="order_date_from"  size="10" maxlength="10" onBlur="CheckDateT(this);"><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
			<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar1 onclick="showCalendar('order_date_from'); document.frmReferralPrescriptionQueryCriteria.order_date_from.focus();return false;" >
		</td>
		<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="order_date_to" id="order_date_to" size="10" onBlur="CheckDateT(this);"><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
			<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar2 onclick="showCalendar('order_date_to'); document.frmReferralPrescriptionQueryCriteria.order_date_to.focus();return false;" >
		</td>
		<td class="label"></td>
		<td>&nbsp;
			
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="lstOrderBy" id="lstOrderBy"><option value="ASCEND"><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
									  <option value="DESCEND" selected><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></select>
			
		</td>
		<td  class="label"></td>
		<td>&nbsp;
			
		</td>
		<td class="label"></td>
		<td>
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()">
		</td>
	</tr>
</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="p_order_id" id="p_order_id" value="">
	<input type="hidden" name="p_disp_no" id="p_disp_no" value="">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="PHREFLTR">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_called_from" id="p_called_from" VALUE="COPY">
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

