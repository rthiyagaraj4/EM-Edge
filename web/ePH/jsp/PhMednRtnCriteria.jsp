<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PhMednRtn.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
 <%
    String bean_id = "ReturnMedicationBean" ;
	String bean_name = "ePH.ReturnMedicationBean";
	ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
    String pat_id_length=bean.getPatientIDLength();

 %>

 <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednRtnCriteria.p_dispense_no.focus();">

<form name="formPhMednRtnCriteria" id="formPhMednRtnCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
<tr>	
			<td class="label" ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
			<td >&nbsp;&nbsp;<input type="text" name="p_dispense_no" id="p_dispense_no" size="15"  maxlength=15 >
			</td>
			<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" size="20" 
			maxlength=<%=pat_id_length%> onblur="Duplicatecheck();" > <!-- remove 'readonly' property for ML-BRU-SCF-0037[030949] and  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]--><INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.formPhMednRtnCriteria.p_patient_id)" >
			</td>
</tr>
<tr>
		<td colspan="4" align="Right">  
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()">
		</td>
</tr>
</table>
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRMDRT">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="disp_no" id="disp_no" VALUE="">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_rtn_medn_no" id="p_rtn_medn_no" value="">
	<input type="hidden" name="p_rtn_date" id="p_rtn_date" value="">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

