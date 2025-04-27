<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/ADRReporting.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
<%
		request.setCharacterEncoding("UTF-8");
		String visible = "";
		String type = request.getParameter("type")==null?"":request.getParameter("type");
		String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage");
		if(!type.equals("report")) {
			visible = "visibility:hidden";
		}
		else{
			visible = "visibility:visible";
		}
		String	bean_id			=	"ADRReportBean" ;
		String	bean_name		=	"ePH.ADRReportBean";

   		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);
		String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
		String current_date				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale); //code added for ADR Admin Date Time is not validating[32828] 

	%>
		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
			<form name="formAdrReportingQueryCriteria" id="formAdrReportingQueryCriteria" TARGET="messageFrame">
				<table cellpadding="0" cellspacing="0"  border="0" width="99%" align="center">
					<tr>
						<th colspan="5" align="left"><fmt:message key="ePH.ADRReportingCriteria.label" bundle="${ph_labels}"/> </th>
					</tr>
					<tr>
						<td class="label" width="18%" nowrap><fmt:message key="ePH.ADRReportedDateFrom.label" bundle="${ph_labels}"/>&nbsp;</td>
						<td class="field" width="30%"><input type='text'  name='adr_reported_date' id='adr_reported_date' size='8' value="" maxlength="10"  onBlur="DateCheck(this,'<%=current_date%>','<%=locale%>')" >  &nbsp;<img  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate" onclick="return showCalendar('adr_reported_date');">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;<label class='label'><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/></label>&nbsp;<input type='text'  name='adr_reported_date1' id='adr_reported_date1' size='8' value="" maxlength="10" >&nbsp;<img  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate1" onclick="return showCalendar('adr_reported_date1');">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
						</td><!--DateCheck() function added for ADR Admin Date Time is not validating[32828]  -->			
						<td class="label" width="19%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<td class="field" width="26%">
							<select name="status" id="status" onchange="disableSign(this)">
								<option value="U" selected><fmt:message key="ePH.Un-Verified.label" bundle="${ph_labels}"/></option>
								<option value="S"><fmt:message key="ePH.Verified.label" bundle="${ph_labels}"/></option>
								<option value="C"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option><!-- code added for HSA-CRF-0005[40601]  -->
								<option value="E"><fmt:message key="ePH.InError.label" bundle="${ph_labels}"/></option><!-- code added for HSA-CRF-0005[40601]  -->
								<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							</select>
					 </td>					 
				  </tr> 
				  <tr>
					 <td class="label"><fmt:message key="ePH.ADRNo.label" bundle="${ph_labels}"/></td>
					 <td class="field" ><input type='text'  name='adr_no' id='adr_no' size=8 value="" maxlength="10"  >
					  </td>
					 <td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					 <td class="field" >
						<input align="center" type='text'  name='patient_id' id='patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>"  onblur="Duplicatecheck()" ><!-- onblur="Duplicatecheck()" added for ML-BRU-SCF-0621[IN036565]-->
						<input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'   onClick="callPatientLookup();">
					  </td>
				  </tr>
				  <tr>
					 <td class="label"><fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/></td>
					 <td class="field" >
						   <input type=text name="ReportedBy" id="ReportedBy" value=""  size='15' onchange="checkTxtValue(ReportedBy,1);"><input valign="top" type=button name="rprtby_search" id="rprtby_search" class="button" value="?" onClick="searchUserNames2(ReportedBy,1);"></input> <!--code 'onfocus="searchUserNames2(SignedBy_1,2)" and "' removed and  onchange="checkTxtValue(ReportedBy,1);" added for HSA-CRF-0005[40601] -->  
						   <INPUT TYPE="hidden" name="ReportedBy_id" id="ReportedBy_id" VALUE=""><!--added for HSA-CRF-0005[40601] --> 
					  </td> 
					 <td class="label"><fmt:message key="ePH.SignedBy.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td> 
					 <td class="field">
						   <input type=text name="SignedBy_1" id="SignedBy_1" value=""  size='15' disabled onchange="checkTxtValue(SignedBy_1,2);" ><input valign="top" type=button name="sgndby_search" id="sgndby_search" class="button" value="?"  onClick="searchUserNames2(SignedBy_1,2)"  disabled></input><!--code  'onfocus="searchUserNames2(SignedBy_1,2)" and onBlur="checkUser2(this.value,2)"' removed  and onchange="checkTxtValue(SignedBy_1,2);" added for HSA-CRF-0005[40601] -->
						   <INPUT TYPE="hidden" name="SignedBy" id="SignedBy" VALUE="">
					  </td>
				  </tr>
				  <tr>
						<td class='label'><fmt:message key="ePH.SuspectedDrug.label" bundle="${ph_labels}"/></td>
						<td class='field'>
							<input type='text'  name='suspected_drug' id='suspected_drug' size='40' value="" maxlength="40"  onKeyPress="return CheckForSpecChars(event)" onchange='checkTxtValue(suspected_drug,3);'>&nbsp;<!-- code  'onfocus="DrugLookupQuery()' removed and  onchange="checkTxtValue(suspected_drug,3);" added for HSA-CRF-0005[40601] -->
							<input valign='top' type='button' name='drug_search' id='drug_search' value='?' class='button'  onClick="DrugLookupQuery()"  >
						</td>  
						<td class="label" colspan='2' >&nbsp;&nbsp;</td>
						</td>
				  </tr>
				  <tr>
						<td class="label"  colspan="3">&nbsp;</td> <td class="label" align='right'> <label style="<%=visible%>" ><fmt:message key="ePH.SummaryReport.label" bundle="${ph_labels}"/></label>&nbsp;<input type="checkbox" name="summaryRprt" id="summaryRprt" value="N" style="<%=visible%>" onclick="summaryReport(this)">&nbsp<input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()"></td>

				   </tr>
				</table>
				<input type="hidden" name="type" id="type" value="<%=type%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
				<input type="hidden" name="order_id" id="order_id" value="">
				<input type="hidden" name="order_line_no" id="order_line_no"	value="">
				<input type="hidden" name="drug_code" id="drug_code"	value="">
				<input type="hidden" name="p_drug_code" id="p_drug_code"	value="">
				<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
				<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
				<input type="hidden" name="current_dat" id="current_dat"	value="<%=current_date%>"><!--added for ADR Admin Date Time is not validating[32828] -->
<%
				if(!type.equals("report")){
%>
					<script>
						parent.parent.frames[0].document.forms[0].apply.disabled = false;	
					</script>	
<%
				}
				else{
%>
					<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_report_id" id="p_report_id" value="PHRADRREP">
					<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
					<INPUT TYPE="hidden" name="p_patient_id" id="p_patient_id" VALUE="">
					<INPUT TYPE="hidden" name="p_adr_no" id="p_adr_no" VALUE="">
					<INPUT TYPE="hidden" name="p_date_fm" id="p_date_fm" VALUE="">
					<INPUT TYPE="hidden" name="p_date_to" id="p_date_to" VALUE="">
					<script>
						parent.parent.frames[0].document.forms[0].run.disabled = true;
					</script>
<%
					}
					putObjectInBean(bean_id,bean,request);
%>
				<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>">
				<INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT2" id="SQL_PH_DISP_RIGHTS_SELECT2" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
				<INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
				<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
		</form>
	</body>
</html>

