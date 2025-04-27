<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <script src="../../ePH/js/PHRepMedicationListOPDBCP.js" language="javascript"></script>
	  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	  <script src="../../eCommon/js/common.js" language="javascript"></script>
	  <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	  <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	  <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	  <script language="Javascript" src="../../eCommon/js/dchk.js"></script>
	   <script src="../../ePH/js/PHReports.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%  
	String p_module_id      = "PH" ;
	String p_report_id      = "PHRBCPMLO" ;
	String p_facility_id    = (String) session.getValue( "facility_id" ) ;
	String p_user_name      = (String) session.getValue( "login_user" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String current_week_date = bean.getWeekRangeOfSysdate();
	String[] currentandweek = current_week_date.split(":");
	String StrVal = currentandweek[0];
	String date_range_week = currentandweek[1];
%>
	<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()'>
		<br>
		<br>
		 <form name="PHRepMedicationListOPDBCP_Form" id="PHRepMedicationListOPDBCP_Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<table width='80%' align='center' valign='top' border='0'>
				<th align='left' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td class="label" width="20%">&nbsp;</td>
					<td class="label" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align='right' class="label"><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="label">
						<input type='text' id='admin_from_date' name='p_fr_date' id='p_fr_date' size="10" maxlength="10" align="center" value='<%=StrVal%>' onBlur="CheckDateT(this);"><img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_fr_date.select();return showCalendar('admin_from_date');">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					<td class="label"> 
						<input type='text' id='admin_to_date' name='p_to_date' id='p_to_date' size="10" maxlength="10" align="center"  value='<%=com.ehis.util.DateUtils.convertDate(date_range_week,"DMY","en",locale)%>'  onBlur="CheckDateT(this);"><img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_to_date.select(); return showCalendar('admin_to_date');">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					
				</tr>
				<tr>
					<td colspan='3'>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="label">
						<input type=text name='p_fr_locn_code' id='p_fr_locn_code' size="6" maxlength="4" align="center" onchange='searchCoderepCurrentMedicationList( p_fr_locn_code, frmLocnDesc)'><input type='button'  name='nursing' id='nursing' value='?' class='button'  onclick='searchCoderepCurrentMedicationList( p_fr_locn_code, frmLocnDesc);'>&nbsp;&nbsp;<b><label id='frmLocnDesc'></label></b>
					</td>
					<td class="label"> 
						<input type=text   name='p_to_locn_code' id='p_to_locn_code' size="6" maxlength="4" align="center" onchange='searchCoderepCurrentMedicationList( p_to_locn_code, toLocnDesc );'><input type='button' name='nursing' id='nursing' value='?' class='button'   onclick='searchCoderepCurrentMedicationList( p_to_locn_code, toLocnDesc );'>&nbsp;&nbsp;<b><label id='toLocnDesc'></label></b>
					</td>
				</tr>
			</table>
			<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
			<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
			<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
			<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
			<input type="hidden" name="sys_date" id="sys_date"         value="<%= StrVal %>">
			<input type="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<input type="hidden" name="p_fr_adm_date" id="p_fr_adm_date" value="">
			<input type="hidden" name="p_to_adm_date" id="p_to_adm_date" value="">
		</form>
		<INPUT TYPE="hidden" name="SQL_PH_REPORTS_BCP_LOCATION_LOOKUP" id="SQL_PH_REPORTS_BCP_LOCATION_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_BCP_LOCATION_LOOKUP" ) %>">
	</BODY>
</html>

