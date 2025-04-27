<!DOCTYPE html>


<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
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
	<script language="JavaScript" src="../../ePH/js/SRRPhRefillMednSheet.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="SRRPhRefillMednSheetForm" id="SRRPhRefillMednSheetForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload ="parent.frames[0].document.forms[0].run.disabled = true">
<%
  	

	String patient_id	=	request.getParameter("patient_id");
	String sOrderType	=	request.getParameter("order_type");


	String bean_id1				= "SRROnlineReportSet2Bean" ;
	String bean_name1			= "ePH.SRROnlineReportSet2Bean";
	SRROnlineReportSet2Bean bean1		= (SRROnlineReportSet2Bean)getBeanObject( bean_id1,bean_name1,request) ;
	bean1.setLanguageId(locale);
    ArrayList displocation  = bean1.getDispLocation();


	//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	//java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
	
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable" >
		<tr>
		   <td class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="field" width="20%">&nbsp;
			<input align="center" type='text'  name='patient_id' id='patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean1.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
			onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>





			<td class="label" nowrap><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" name="p_fr_disp_date" id="p_fr_disp_date" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_fr_disp_date))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_fr_disp_date');"  onblur='p_fr_disp_date.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
		<td>&nbsp;
		<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_to_disp_date" id="p_to_disp_date" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_to_disp_date))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_to_disp_date');" onblur='p_to_disp_date.focus()' >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>   
		



		
		
	</tr>
	<tr>
	<td class="label" nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_pres_id" id="p_pres_id" maxlength="15" size="20" onKeyPress="return CheckForSpecChars(event);">

		</td>	
		
			<td class="label" nowrap><fmt:message key="ePH.TokenNo./DailySeqNo.label" bundle="${ph_labels}"/></td>

		<td>&nbsp;
			<input type="text" name="p_tok" id="p_tok" maxlength="15" size="20" onKeyPress="return CheckForSpecChars(event);">

		</td>	
		<td colspan="2">&nbsp;</td>
		
		</tr>
		<tr>
		
		<td class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_encounter" id="p_encounter" maxlength="20" size="20"  onKeyPress="return CheckForSpecChars(event);">
		</td>
			<td class="label" nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_pract_id" id="p_pract_id" maxlength="20" size="20" value="" onKeyPress="return CheckForSpecChars(event);"><input type="button" name="btnLocation" id="btnLocation" class="button" value="?"  onClick=" searchPractitionerName(SRRPhRefillMednSheetForm.p_pract_id);">
		</td>
			<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code"><BR>
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
			<%	 if (displocation.size() > 0 )
			for (int i=0; i<displocation.size(); i+=2) {
			%>
			<OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

			<% 	} %> 
	  </SELECT>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>	
  	
	</tr>
	</tr>
	<tr>
		<td class="label" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<select name="p_locn_type" id="p_locn_type" onChange="resetLocation()">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td class="label" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_locn_code" id="p_locn_code" maxlength="20" size="20"  disabled onKeyPress="return CheckForSpecChars(event);"><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(p_locn_code)" onClick="locationLookup(p_locn_code)"><input type="hidden" name="locn_code" id="locn_code" value="">
		</td>
			<td colspan="1"> &nbsp;</td>
			<td>&nbsp;
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()" >
		</td>
		</tr>
		
		

		
</table>

<input type="hidden" name="p_order_id" id="p_order_id" value="">
<input type="hidden" name="p_trn_group_ref" id="p_trn_group_ref" value="">
<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
<input type="hidden" name="p_order_id1" id="p_order_id1" value="">
<input type="hidden" name="p_fm_order_id" id="p_fm_order_id" value="">
<input type="hidden" name="p_to_order_id" id="p_to_order_id" value="">
<input type="hidden" name="p_patclass" id="p_patclass" value="">
<input type="hidden" name="p_locncode" id="p_locncode" value="">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
<input type="hidden" name="p_iv_prep_yn" id="p_iv_prep_yn" value="">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
		<INPUT TYPE="hidden" name="p_token_no" id="p_token_no" VALUE="">

</form>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
<% putObjectInBean(bean_id1,bean1,request); %>
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

