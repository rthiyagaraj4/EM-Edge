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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!--	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/SRRPhIssueToken.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formSRRPhIssueTokenCriteria" id="formSRRPhIssueTokenCriteria" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload ="parent.frames[0].document.forms[0].run.disabled = true">
<%

   	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhIssueTokenBean" ;
	String bean_name			= "ePH.PhIssueTokenBean";
	PhIssueTokenBean bean		= (PhIssueTokenBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
    ArrayList displocationlist  = bean.getDispLocationList();
	String pat_id_length=bean.getPatientIDLength();
	java.util.Date date_time	 	= new java.util.Date();
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);



  

	String patient_id	=	request.getParameter("patient_id");
	String sOrderType	=	request.getParameter("order_type");

	//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	//java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
	
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable" >
	<tr>
        <td class="label"><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<SELECT name="p_token_series_code" id="p_token_series_code">
		<OPTION VAlUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
	   	</SELECT>

		</td>	
			
		<td class="label"><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_tokfr" id="p_tokfr" maxlength="15" size="20" onKeyPress="changeToUpper()">
		</td>
		<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<SELECT name="p_disp_locn_code" id="p_disp_locn_code" onChange="populateTokenSeries(p_facility_id.value,this.value)">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
	 <%	 if (displocationlist.size() > 0 )
				for (int i=0; i<displocationlist.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= displocationlist.get(i) %>"><%= displocationlist.get(i+1) %></OPTION>

	<% 	} %> 
	  </SELECT>
		</td>		
	</tr>
	<tr>
	<td class="label"><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<input type="text" maxLength="10" size="20"  name="prescription_id" id="prescription_id" value="" onKeyPress="return CheckForSpecialChars(event);">

		</td>	
		<td class="label"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_disp_date_from" id="p_disp_date_from" value="<%=currentdate%>" maxlength="10" size="10" onBlur="CheckDate(this);DateCheck(currentdate,p_disp_date_from);validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_from');"  onblur='p_disp_date_from.focus()'>
		</td>
		<td class="label"><label class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
		<td>&nbsp;
			<input type="text" name="p_disp_date_to" id="p_disp_date_to" value="<%=currentdate%>" maxlength="10" size="10" onBlur="CheckDate(this);DateCheck(currentdate,p_disp_date_to);validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_to');" onblur='p_disp_date_to.focus()' ><INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
		</td>
		</tr>



		<tr>

		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=pat_id_length%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
		onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
		

		<td class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="encounter_id" id="encounter_id" maxlength="20" size="20" onKeyPress="return CheckForSpecialChars(event);" >
		</td>
		<td class="label">&nbsp;<fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td colspan="3">&nbsp;
			<input type="text" name="practitioner_id" id="practitioner_id" maxlength="20" size="20" value=""  ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?"  onClick=" searchPractitionerName(formSRRPhIssueTokenCriteria.practitioner_id);"><input type="hidden" name="pract_code" id="pract_code">
		</td>		
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<select name="locn_type" id="locn_type" onChange="resetLocation()">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code">
		</td>
		
		<td class="label">&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<select name="p_langue" id="p_langue" onChange="resetLocation()">		 <BR>
				<option value=""><fmt:message key="ePH.Thai.label" bundle="${ph_labels}"/></option>
				<option value="C"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
				
			</select>

		</td>

		<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults('<%=patient_id%>')" >
		</td>
	</tr>
		

		
	<tr>
	</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="p_order_id" id="p_order_id" value="">
<input type="hidden" name="p_order_id1" id="p_order_id1" value="">
<input type="hidden" name="p_fm_order_id" id="p_fm_order_id" value="">
<input type="hidden" name="p_to_order_id" id="p_to_order_id" value="">
<input type="hidden" name="p_patclass" id="p_patclass" value="">
<input type="hidden" name="p_locncode" id="p_locncode" value="">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
<input type="hidden" name="p_iv_prep_yn" id="p_iv_prep_yn" value="">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">

</form>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">


<% putObjectInBean(bean_id,bean,request); %>
</body>
<%
	if(sOrderType != null && !sOrderType.equals(""))
	{
		if(sOrderType.equals("ALL"))
			sOrderType = "All";
%>
	<script>
		document.PhRepPrescriptionCriteriaForm.order_type.value = '<%=sOrderType%>';
	</script>
<%
	}

%>

<script>

 <% if(!patient_id.equals("")){ %>
 showResults()
 <%	}	%>
 </script>
</html>

