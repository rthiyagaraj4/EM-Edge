<!DOCTYPE html>
	 <%-- saved on 03/11/2005 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*" %>
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
	//

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRPhBalMednSheet.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="FormSRRPhBalMednSheet" id="FormSRRPhBalMednSheet" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload ="parent.frames[0].document.forms[0].run.disabled = true">
<%
try{
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "SRROnlineReportSet1Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet1Bean";
	SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
    ArrayList displocation  = bean.getDispLocation();
	java.util.Date date_time	 	= new java.util.Date();
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

	%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0"  >
	<tr>
		<td class="label"nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
		<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
		onfocus="callPatientLookup();" onClick="callPatientLookup();">&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">

		</td>	
<!-- Corrected date validations on 9-mar-10 -->
		<td class="label"nowrap><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
		<input type="text" name="p_disp_date_from" id="p_disp_date_from" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_from))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_from');"  onblur='p_disp_date_from.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		</td>
		<td class="label"   align="right"nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
		<input type="text" name="p_disp_date_to" id="p_disp_date_to" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_to))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_to');" onblur='p_disp_date_to.focus()' >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
		</td>		
	</tr>
	<tr>
		<td class="label"nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
		<input type="text" name="prescription_id" id="prescription_id" maxlength="15" size="20" onKeyPress="return CheckForSpecialChars(event);">

		</td>
		<td class="label"nowrap><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_token_no" id="p_token_no" SIZE="20" MAXLENGTH="4"  onkeyPress='return allowValidNumber(this,event,4,0)' class="NUMBER" >
		</td>
	</TR>
	<tr>
	<td class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="encounter_id" id="encounter_id" maxlength="20" size="20"  onKeyPress="return CheckForSpecialChars(event);">
		</td>
		<td class="label" nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td >&nbsp;
			<input type="text" name="practitioner_id" id="practitioner_id" maxlength="20" size="20" value=""  ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?"  onClick=" searchPractitionerName(FormSRRPhBalMednSheet.practitioner_id);"><input type="hidden" name="pract_code" id="pract_code">
		</td>
		<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code"><BR>
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
			<%	 if (displocation.size() > 0 )
			for (int i=0; i<displocation.size(); i+=2) {
			%>
			<OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

			<% 	} %> 
	  </SELECT>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>	
		</tr>
		<tr>
		<td class="label" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<select name="locn_type" id="locn_type" onChange="resetLocation()">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td class="label" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code">
		</td>	
		<td class="label" colspan="1" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()" >
		</td>
	</tr>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	
</table>

<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id%>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">

<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
<INPUT type="hidden" name="P_DISP_DATE" id="P_DISP_DATE" value="">
<INPUT type="hidden" name="P_disp_locn_code" id="P_disp_locn_code" value="">
<INPUT type="hidden" name="p_TOKEN_no" id="p_TOKEN_no" value="">
<INPUT TYPE="hidden" name="P_LANGUAGE_ID" id="P_LANGUAGE_ID" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
<INPUT TYPE="hidden" name="P_ORDER_ID" id="P_ORDER_ID" VALUE="">
<INPUT TYPE="hidden" name="P_PATIENT_ID" id="P_PATIENT_ID" VALUE="">
	<% putObjectInBean(bean_id,bean,request); %>


</form>

	<%}catch(Exception  e){
			out.println("alert(\"" + e + "\");") ;
			e.printStackTrace();

	    } %>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">

</body>

</html>

