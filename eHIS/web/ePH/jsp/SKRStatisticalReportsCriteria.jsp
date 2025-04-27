<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script> 
	<script language="javascript" src="../js/SKRStatisticalReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
           String p_facility_id		= (String) session.getValue( "facility_id" ) ;
%>
    <BODY onMouseDown="CodeArrest()" onKeyDown=""> 
	<form name="SKRStatisticalReportsCriteria" id="SKRStatisticalReportsCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding=0 cellspacing=0 width="105%"  align="center" border="0" >
	      <TH COLSPAN="6" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
			<tr><td class='label' colspan='4' height='6'></td></tr>
			<tr>
				<td colspan='2' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td>&nbsp;<SELECT name="p_report_type" id="p_report_type"  onChange="" style="width:280px">
				<option value =""> ---------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------------- </option>
		   		<option value ="H"> <fmt:message key="ePH.HIV'sdrugusagebymonth.label" bundle="${ph_labels}"/></option>
				<option value ="NP"> <fmt:message key="ePH.Narcoticdrugdetailbypatient.label" bundle="${ph_labels}"/></option>	
				<option value ="NM"> <fmt:message key="ePH.Narcoticdrugsummarybymonth.label" bundle="${ph_labels}"/></option>
				<option value ="PP"> <fmt:message key="ePH.Psychoticdrugdetailbypatient.label" bundle="${ph_labels}"/></option>
				<option value ="PM"> <fmt:message key="ePH.Psychoticdrugsummarybymonth.label" bundle="${ph_labels}"/></option>
    			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
				</td>
             </tr>
			 <tr><td class='label' colspan='4' height='6'></td></tr>
			 
			 <tr>	
					<td colspan='2' class="label"><fmt:message key="ePH.DispensePeriodMonth/Year.label" bundle="${ph_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_month" id="p_month" value='' onKeyPress='return allowPositiveNumber()' onblur='checkMonth(this);ChkSplChars(this);' class="NUMBER"> 
					<class=text> / 	<class=text> <input type='text' name='p_disp_year' id='p_disp_year' size='4' maxlength='4' value='' onBlur='checkYear(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()'/>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>   <!-- p_year renamed p_disp_year as for SKR-SCF-0855 [IN:044362]-->

					<input type="hidden" name="monthyear" id="monthyear" value="">
                 </tr>
	   <input type="hidden" name="monthyear" id="monthyear" value="">

    <input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="p_disp_month" id="p_disp_month" value="">
	<input type="hidden" name="p_year" id="p_year" value=""><!--p_disp_year renamed as p_year for SKR-SCF-0855 [IN:044362]-->
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	
	</form>
	</body>
	</html>

