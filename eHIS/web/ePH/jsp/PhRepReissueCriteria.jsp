<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhReissueReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
<%
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysDate();	
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formReissueCriteria.p_patient_id.focus()"> 
		<form name="formReissueCriteria" id="formReissueCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<br><br><br><br><br>
			<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
			<TH COLSPAN="5"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
			 <tr>
				<td class="label" colspan="4">&nbsp;</td>
			 </tr>
			<tr> 
				<td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
				<td class="label"><input type="text" size="12" maxlength=10 name="dt_from" id="dt_from" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" OnBlur='CheckDateT(this);chkDate(dt_from,dt_to);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class="label"><input type="text" size="10" name="dt_to" id="dt_to" maxlength=10 value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" OnBlur='CheckDateT(this);chkDate(dt_from,dt_to);'><IMG  SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class="label"><input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()" onblur="Duplicatecheck();" > <!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->	
				<input type="button" class="button" value="?" name="pat_search" id="pat_search"  onClick="callPatientSearch(document.formReissueCriteria.p_patient_id)"></td>
				<td class="label"><fmt:message key="ePH.DispensedFrom.label" bundle="${ph_labels}"/></td>
				<td class="label">
				  <SELECT name="p_disp_location" id="p_disp_location">
				  <OPTION VALUE="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</OPTION>
<%
					ArrayList displocn=(ArrayList)bean.getAllDispLocn();
					if(displocn.size()!= 0 ){
						for(int i=0;i<displocn.size();i+=2){ 
%>
							<OPTION VALUE="<%=(String)displocn.get(i)%>"><%=(String)displocn.get(i+1)%></OPTION>
<%
						}
					}
%>
				</SELECT>
				</td>
			</tr>
			<tr> <td class="label" colspan="4">&nbsp;</td></tr>
		</table>
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRREISSUE">
		<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
		<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

