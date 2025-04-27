<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends

	String locale			= (String)session.getAttribute("LOCALE");
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!--	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhRepExtPrescription.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmExtPrescriptionQueryCriteria" id="frmExtPrescriptionQueryCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<%
  	String bean_id		= "PrintPrescriptionReportBean" ;
	String bean_name	= "ePH.PrintPrescriptionReportBean";
	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);

	String patient_id	=	request.getParameter("patient_id");
	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
%>
<table cellpadding="2" cellspacing="0" width="100%" align="center" border="0">
    <tr><td colspan="4">&nbsp;</td></tr>
	<tr>
		<td class="label" width="20%"><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></td>
		<td width="20%" >&nbsp;
			<input type="text" name="order_id" id="order_id" maxlength="15" size="20" onKeyPress="changeToUpper()">
		</td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td> 
		<td>&nbsp;&nbsp;<input type="text" size="12" maxlength=10 name="order_date_from" id="order_date_from" OnBlur="CheckDateT(this);validateDate()"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_from');" ></td>
		<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" size="10" name="order_date_to" id="order_date_to" maxlength=10 OnBlur="CheckDateT(this);validateDate()"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_to');" ></td><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="patient_id" id="patient_id" value="<%=patient_id%>" <%=status%>  maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onblur="Duplicatecheck();" ><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
			<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"  <%=status%>>
		</td>
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;&nbsp;<select name="lstOrderBy" id="lstOrderBy"><option value="ASCEND"><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
									  <option value="DESCEND" selected><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></select></td>
		</tr>
		<tr>
		<td align="right"  colspan="4"> 
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button"  onClick="showResults('<%=patient_id%>')">
		</td>
		</tr>

</table>
    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
	

	<input type="hidden" name="p_order_id" id="p_order_id" value="">
	<input type="hidden" name="p_patclass" id="p_patclass" value="">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBOPPEX">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>

<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
</body>
</html>

