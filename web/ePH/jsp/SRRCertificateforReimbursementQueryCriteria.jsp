<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRCertificateforReimbursement.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	

	String bean_id				= "SRROnlineReportSet1Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet1Bean";
	SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
    ArrayList displocation  = bean.getDispLocation();

	java.util.Date date_time	 	= new java.util.Date();
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

	%>


<BODY onload="document.formSRRCertificateforReimbursement.p_patient_id.focus();" onMouseDown="" onKeyDown="lockKey()">
<form name="formSRRCertificateforReimbursement" id="formSRRCertificateforReimbursement" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class="field" width="15%"><input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button' onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
		<td class="label" >&nbsp;</td>
		<td colspan="2" nowrap>&nbsp;&nbsp;</td> 

		<td class="label" nowrap><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
		<td colspan="2" nowrap><input type="text" name="p_disp_date_from" id="p_disp_date_from" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_from))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_from');"  >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
		<td class="label" nowrap><label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<input type="text" name="p_disp_date_to" id="p_disp_date_to" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_to))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_to');"  >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>   
		<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
</tr>
<tr>
		<td  class="label" nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></td>
		<td class="field" width="15%"><input type="text" maxLength="10" size="20"  name="p_fr_pre" id="p_fr_pre" value="" onKeyPress="return CheckForSpecialChars(event);"></td>

		<td class="label" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td colspan="2" nowrap><input type="text" maxLength="10" size="20" name="p_to_pre" id="p_to_pre" value="" onKeyPress="return CheckForSpecialChars(event);"></td>

		<td class="label"  nowrap ><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
		<td colspan="2" nowrap><input type="text" name="token_no_from" id="token_no_from" SIZE="10" MAXLENGTH="4"  onkeyPress='return allowValidNumber(this,event,4,0)' class="NUMBER" ></td>
		<td class="label" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<INPUT TYPE="text" name="token_no_to" id="token_no_to" SIZE="10" MAXLENGTH="4"  onkeyPress='return allowValidNumber(this,event,4,0)' class="NUMBER" ></td>
				

		
</tr>
<tr>
		<td  class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class="field" width="15%"><input type="text" maxLength="12" size="20" name="p_encounter" id="p_encounter"" onKeyPress="return CheckForSpecialChars(event);"> </td>
		<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td colspan="2" nowrap><SELECT name="p_disp_locn_code" id="p_disp_locn_code">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
			<%	 if (displocation.size() > 0 )
			for (int i=0; i<displocation.size(); i+=2) {
			%>
			<OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

			<% 	} %> 
	  </SELECT></td>
		<td class="label" nowrap>&nbsp;</td> 
		<td colspan="2" class="label" nowrap>&nbsp;</td> 
		<td class="label" nowrap>&nbsp;</td> 

</tr>
<tr>
			<td class="label" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class="field" width="15%"><select name="locn_type" id="locn_type" onChange="resetLocation()">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			<td class="label" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td colspan="2" nowrap><input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code"></td>

			<td  class="button"><input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()">&nbsp;&nbsp;</td> 
			
			<td  class="button"  align="center"><input type="button" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="showPrint('<%=p_facility_id%>');" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label" nowrap>&nbsp;</td> 


		</tr>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">

</table>
</form>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

