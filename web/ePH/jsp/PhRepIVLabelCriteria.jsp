<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
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
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PhIVDispLabel.js"></script>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	
	String bean_id				= "PHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean	= (PHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysdate();
	
%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhIVDispLabelCriteria.p_patient_id.focus()"> 
						
<form name="formPhIVDispLabelCriteria" id="formPhIVDispLabelCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<TH COLSPAN="7"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>

<tr>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" onBlur="Duplicatecheck();populateDispNo()" onKeyPress="changeToUpper()"><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]--><input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhIVDispLabelCriteria.p_patient_id)">&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>
  		<td class="label"><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
		<td colspan="2">&nbsp;&nbsp;<input type="text" name="p_disp_date1" id="p_disp_date1" size="8" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" maxlength="10" onBlur="if(CheckDateT(this)) populateDispNo();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_disp_date1');document.formPhIVDispLabelCriteria.p_disp_date1.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>    	
		<td >&nbsp;&nbsp;&nbsp;</td>
		<td ></td>
		<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
</tr>
<tr>
	<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<td >&nbsp;&nbsp;<select name="p_patient_class" id="p_patient_class" onChange="populateDispNo();setStage(this)">
	<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
	<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
	</select>&nbsp;&nbsp;&nbsp;
	<label class='label'><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
	<select name="stage" id="stage" onChange="populateDispNo()">
	<option value="F"><fmt:message key="ePH.Filling.label" bundle="${ph_labels}"/></option>
	<option value="D"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/></option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;<label class='label'><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;<select name="disp_no" id="disp_no" onChange="setType(this)" >
	<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
	</select>
	</td>
	<td class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td >&nbsp;&nbsp;
	<label class="label" style="font:bold" id="iv_type"></label>
	</td>
	<td class="button">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="button"  value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' name="print_report" onClick="printReports()">&nbsp;&nbsp;</td>
	<td class="button"><input type="button" class="button" value='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' name="view_report" onClick="viewLabels()">&nbsp;&nbsp;</td>
</tr>
</tr>
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_disp_fm_no" id="p_disp_fm_no" value="">
	<input type="hidden" name="p_disp_to_no" id="p_disp_to_no" value="">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="p_report_id1" id="p_report_id1" value="">
	<input type="hidden" name="p_disp_no" id="p_disp_no" value="">
	<input type="hidden" name="p_pat_class" id="p_pat_class" value="">
	<input type="hidden" name="p_mode" id="p_mode" value="VIEW">
	<input type="hidden" name="dsdl" id="dsdl" value="DispLabel">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

<% putObjectInBean(bean_id,bean,request); %>	
</body>
<script>
parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
</script>
</html>

