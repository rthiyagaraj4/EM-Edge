<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PfReports.js"></script> 
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formPfReportsCriteria" id="formPfReportsCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
<table cellpadding="0" cellspacing="0"  border="0" width="100%" align="center">
<TH  colspan='4' height='4' ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
<tr>
	<td colspan='4' class='label' height='4'>&nbsp;&nbsp;</td>
</tr>
<tr>
    <td align="right" class="label">&nbsp;<fmt:message key="Common.PFReports.label" bundle="${common_labels}"/>&nbsp; </td>
	<td align="left"	colspan='3' ><SELECT name="pf_report_id" id="pf_report_id"  >
	<OPTION VALUE="">-------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</OPTION>
	<OPTION VALUE="PHPHACTOUTHP"><fmt:message key="ePH.PharmacyActivityOutputHospitalOnly.label" bundle="${ph_labels}"/></OPTION>
	<OPTION VALUE="PHOPPRESINTV"> <fmt:message key="ePH.DetailedInformationAboutOutPatient.label" bundle="${ph_labels}"/></OPTION>
	<OPTION VALUE="PHCLPHACT"><fmt:message key="ePH.ClinicalPharmacyActivity.label" bundle="${ph_labels}"/></OPTION>
	<OPTION VALUE="PHPHKINACT"><fmt:message key="ePH.ClinicalPharmacokineticActivity.label" bundle="${ph_labels}"/></OPTION>
	<OPTION VALUE="PHBPFINDSOP"><fmt:message key="ePH.PerformanceIndicatorDispensingOutpatient.label" bundle="${ph_labels}"/></OPTION>
	</SELECT>&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
</tr>
<tr>
	<td class='label' colspan='4' height='4'></td>
</tr>
<tr>
	<td align="right"  class="label"  nowrap colspan='1'>&nbsp;<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;</td>  
	<td class="label" align="left" colspan='3' > <input type='text'  name='enq_date_from' id='enq_date_from' size='8' value="" maxlength="10" Onblur="CheckDateT(this);DateCheck('<%=Sysdate%>',this);validate_date(this)" >&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate" onclick="return showCalendar('enq_date_from');" onblur="document.forms[0].enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='enq_date_to' id='enq_date_to' size='8' value="" maxlength="10" Onblur="CheckDateT(this);DateCheck('<%=Sysdate%>',this);validate_date(this)"   >&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate1" onclick="return showCalendar('enq_date_to');"  onblur="document.forms[0].enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img><!--p_enq_date_from  to enq_date_from  p_enq_date_to to enq_date_to Added for DateConversion-->
	</td>
 </tr>
 <tr>
	<td colspan='4' height='4' class='label'>&nbsp;&nbsp;</td>
</tr>
</table>
 	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_from_date" id="p_from_date" VALUE="">
	<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_enq_date_from" id="p_enq_date_from" VALUE=""><!--Added for DateConversion identification -->
	<INPUT TYPE="hidden" name="p_enq_date_to" id="p_enq_date_to" VALUE=""><!--Added for DateConversion identification -->
</form>
</body>
</html>

