<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.*,webbeans.eCommon.*,java.util.*,java.text.*,java.net.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String locale = (String)session.getAttribute("LOCALE");	
String call_function= checkForNull(request.getParameter("call_function"));
String called_from	= checkForNull(request.getParameter("called_from"));
String request_type	= checkForNull(request.getParameter("request_type"));
String result_def_frm_ca = checkForNull(request.getParameter("result_def_frm_ca")); //ML-MMOH-CRF-0388 - IN057153
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
Connection conn = null; // try-catach block by mujafar for ML-MMOH-CRF-0713
Statement stmt=null;

//Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
String sum_comp_id	= checkForNull(request.getParameter("sum_comp_id"));

//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
String nav_menu_id = checkForNull(request.getParameter("nav_menu_id"));

//Added by Ashwini on 25-Feb-2019 for MO-CRF-20149
String Facility_Id = (String)session.getValue("facility_id");

try
{

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
Boolean isRejectRequestAppl = false; // added by mujafar for ML-MMOH-CRF-713
isRejectRequestAppl=eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REQUEST_MRP");
Boolean isRejectReportApplicable = false; // added by mujafar for ML-MMOH-CRF-714
isRejectReportApplicable=eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REPORT_MRP"); // added by mujafar for ML-MMOH-CRF-714
Boolean isDuedateAppl = false; // added by mujafar for ML-MMOH-CRF-706
isDuedateAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DUE_DATE_APPL"); // added by mujafar for ML-MMOH-CRF-706

Boolean isAcceptRequestByPractAppl = false; // added by mujafar for ML-MMOH-CRF-1315
isAcceptRequestByPractAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ACCEPT_REJECT_BY_PRACT_APPL"); // added by mujafar for ML-MMOH-CRF-1315

Boolean isMRConfigurationAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MR_REPORT_COLUMN_CONFIG_APPL"); // added by mujafar for ML-MMOH-CRF-1280



%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src="../../eMR/js/ReportRequestQuery.js"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> <!-- added by mujafar for ML-MMOH-CRF-706 -->
	<!--Added by Ashwini on 25-Feb-2019 for MO-CRF-20149-->
	<script src="../../eMR/js/MRPractitionerComponent.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function checkDecimal(obj)
{  
	if (obj.value != '')
	{ 
		if (isNaN(obj.value) == false && obj.value >= 0)
		{
			if (obj.value.indexOf('.') != -1)
			{ 
				alert(getMessage("INVALID_INTEGER","MR"));
				obj.select();
				obj.focus();
			}		
		}
		
	}
}


function CompareDates(from, to)
{
	if(from.value !='' && to.value !='')// DateUtils.js
	{
		var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
		var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
		if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			document.forms[0].to_date.select();
		}
	}
}

async function configFieldOrder(object) // added by mujafar for ML-MMOH-CRF-1280
	{
		
		var ret =await window.showModalDialog("../../eMR/jsp/MRReportSearchResultOrder.jsp","","title=Display;dialogHeight=24;dialogWidth=22;dialogTop=30;status:no");
		
	
		if (ret=='0') {
			
			document.ReportRequestQuery_Form.search.click();
		
			
		}
		else{
			
						return false;

		}
		
		
	}





</script>

</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='ReportRequestQuery_Form' id='ReportRequestQuery_Form' action='../jsp/ReportRequestQueryResult.jsp' target='result' >
<table cellspacing=0 cellpadding=1 align='center' width='100%' border='0'>
<%	if(called_from.equals("CA"))
	{	%>
	<tr>
		<td class='button' colspan="4"><input type=button class=button name='Reset' id='Reset' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' onClick='document.forms[0].reset();document.forms[0].clear.onclick();'></td>
	</tr>
<%	}	%>

<%	if(request_type.equals("MB"))
	{	%>
	<tr align="left">	
		<th class="columnheader" colspan="4" ><fmt:message key="eMR.RequestorDetails.label" bundle="${mr_labels}"/></th>
	</tr>
<%	}	%>

	<tr>
		<td width="24%" class='label' ><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
		<td width="30%" class='fields'><input type=text name="requestor_desc" id="requestor_desc" size=15 onblur='if(this.value==""){document.forms[0].requestor_code.value="";};chkGetRequestor();'><input type=hidden  name="requestor_code" id="requestor_code" size=15 ><input type=button class=button name='requestor_lookup' id='requestor_lookup' value='?' onClick='getRequestor(requestor_lookup,requestor_desc);'></td>
		<td width="21%" class='label' ><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/></td>
		<td  class='fields' ><select name='requestor_type' id='requestor_type' style='width:170'><option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
		<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
			<%
				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(conn);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
			%>
		</select>
		</td>
	</tr>
	<tr>
<% 	if(!request_type.equals("MR")&& !request_type.equals("MB"))
	{	//onBlur="ComparePeriodFromToTime(this,to_date);" onBlur="ComparePeriodFromToTime(from_date,this);" %>
		<td class='label' ><fmt:message key="Common.RequestDateFrom.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" id="req_date_from" maxlength="10" size="10" name="from_date" id="from_date"  value="" onBlur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,to_date);' onkeypress="return Valid_DT(event)"><img src='../../eCommon/images/CommonCalendar.gif'onClick="document.forms[0].req_date_from.focus();return showCalendar('req_date_from');"> - <input type="text" id="req_date_to" value="" maxlength="10" size="10" name="to_date" id="to_date" onBlur='validDateObj(this,"DMY","<%=locale%>");CompareDates(from_date,this);'  onkeypress="return Valid_DT(event)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].req_date_to.focus();return showCalendar('req_date_to');"></td> 
		
	<% if(!request_type.equals("MR")&& !request_type.equals("MB")&& called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl)
	{ // added by mujafar for ML-MMOH-CRF-706 %>
		<td class='label' ><fmt:message key="eMR.DueDays.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="eMR.LessThanOrEqual.label" bundle="${mr_labels}"/></td>
		<td  class='fields' >
		<input type='text' id='due_date_sel' name='due_date_sel' id='due_date_sel'  size="3" maxlength="3" onKeyPress='return(ChkNumberInput(this,event,0));' onBlur="CheckNum(this);checkDecimal(this);" />
		
			
		
		
		
		
		</td>
		
		
	<%}
	else
	{
	%>
		<td class='label' >&nbsp;</td> 
		<td class='label' >&nbsp;</td>
		
	<%	}}%>
	</tr>
<%
if(request_type.equals("MR"))
{	%>
	<tr>
		<td class='label'  ><fmt:message key="eMR.MedicalReportStatus.label" bundle="${mr_labels}"/></td>
		<td class='fields'><select name='status_to_show' id='status_to_show' >
			<option value="1" ><fmt:message key="Common.Requested.label" bundle="${common_labels}"/></option>
			<%if(isMRConfigurationAppl){ // added by mujafar for ML-MMOH-CRF-1280 %>
			<option value="8" >
			<!--<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Application.label" bundle="${common_labels}"/>-->
			 <fmt:message key="eMR.CancelledApplication.label" bundle="${mr_labels}"/> 
			</option>
			
			<%}else{%>
			<option value="8" ><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			<%}%>
			<!--<option value="7" ><fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>-->
			<option value="7" ><fmt:message key="Common.statusincomplete.label" bundle="${common_labels}"/></option>
			<%
			if(isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1279
			%>
			<option value="2" >
			<!--<fmt:message key="Common.completed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Application.label" bundle="${common_labels}"/>-->
			 <fmt:message key="eMR.CompletedApplication.label" bundle="${mr_labels}"/> 
			</option>
			<%
			}else{
			%>
			<option value="2" ><fmt:message key="eMR.StatusCompleted.label" bundle="${mr_labels}"/></option>
			<%
			}
			if(isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			%>
			<option value="9" ><fmt:message key="eMR.ForwardedtoHOD_Coordinator.label" bundle="${mr_labels}"/></option>
			<%
			}else{
			%>
			<option value="9" ><fmt:message key="eMR.ForwardedtoHOD.label" bundle="${mr_labels}"/></option>
			<%
			}
			if(isRejectRequestAppl) // added by mujafar for ML-MMOH-CRF-713
			{%>
			<!--<option value="10" ><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/></option> <!-- added by mujafar for ML-MMOH-CRF-0713 -->
			<option value="10" ><fmt:message key="Common.RejectedRequest.label" bundle="${common_labels}"/>
			<%}
			else
			{%>
		<option value="10" ><fmt:message key="Common.returned.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/></option>
			<%}%>
			<!--<option value="11" ><fmt:message key="Common.Accepted.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/></option>-->
			<option value="11" ><fmt:message key="Common.AcceptedRequest.label" bundle="${common_labels}"/></option>
			<option value="3" ><fmt:message key="eMR.ForwardedtoPractitioner.label" bundle="${mr_labels}"/></option>
			
			<%if(isAcceptRequestByPractAppl){
			// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			%>
			<option value="13" ><fmt:message key="eMR.AcceptedbyPractitioner.label" bundle="${mr_labels}"/></option>
			<option value="14" ><fmt:message key="eMR.RejectedbyPractitionertoMRD.label" bundle="${mr_labels}"/></option>
			<option value="15" ><fmt:message key="eMR.RejectedbyPractitionertoHOD.label" bundle="${mr_labels}"/></option>
			<%}%>
			
			
			
			<option value="4" ><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></option>
			<%
			if(isRejectReportApplicable) // added by mujafar for ML-MMOH-CRF-714
			{%>
			<!--<option value="98" ><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>-->
			<option value="98" ><fmt:message key="Common.Rejectedreport.label" bundle="${common_labels}"/></option>
			
			<%}%>
			<option value="5" ><fmt:message key="eMR.ReceivedbyMedicalRecord.label" bundle="${mr_labels}"/></option>
			<option value="6" ><%if(isAcceptRequestByPractAppl){%><fmt:message key="eMR.ReportDeliveredByMR.label" bundle="${mr_labels}"/><%}else{ %><fmt:message key="eMR.ReportDelivered.label" bundle="${mr_labels}"/><%} %></option>
			<option value="0" ><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
			<option value="0-4" selected ><fmt:message key="Common.NotDelivered.label" bundle="${common_labels}"/></option>
			<option value= "" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='label'  ><fmt:message key="Common.RequestDateFrom.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' onblur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,to_date);' id="req_date_from" maxlength='10' size='10' name='from_date'  value=""  onkeypress="return Valid_DT(event)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].req_date_from.focus();return showCalendar('req_date_from');"> - <input type='text' onblur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,from_date);' id="req_date_to" value="" maxlength='10' size='10' name='to_date'  onkeypress="return Valid_DT(event)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].req_date_to.focus();return showCalendar('req_date_to');"></td>
	</tr>
	<!--Added by Ashwini on 25-Feb-2019 for MO-CRF-20149-->
	<tr>
		<td width='20%' class=label><fmt:message key="eMR.DepartmentSpecialty.label" bundle="${mr_labels}"/></td>
		<td width='20%' class='fields'>
			<select name='speciality' id='speciality'> 
			<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
			<%
			JSONArray SpecJsonArr = new JSONArray();
			SpecJsonArr = eMR.MRCommonBean.getSpeciality(conn,locale);
			String speciality_code = "";
			
			for(int i = 0 ; i < SpecJsonArr.size() ; i++) 
			{
					JSONObject json	= (JSONObject)SpecJsonArr.get(i);
					String spec_long_desc = (String) json.get("long_desc");
					speciality_code = (String) json.get("speciality_code");
					
					out.println("<option value='"+speciality_code+ "'>"+spec_long_desc+"</option>");	
			}
			%>
			</select>
		</td>

		<td class='label' width="25%"><fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/></td>
		<td class="fields">
			<input type='text' name='fwd_pract_desc' id='fwd_pract_desc' size='30' maxlength='30' onblur='getForwPractLookupVal();' value=""><input type='hidden' name='fwd_practitioner_id' id='fwd_practitioner_id' value=""><input type='button' name='fwd_pract_id_search' id='fwd_pract_id_search' value='?' class='button' onClick='getPractLookupID(this);'>
		</td>
	</tr>
	<tr>
		<td class='label' width="25%"><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></td>
		<td class="fields">
			<input type='text' name='prep_pract_desc' id='prep_pract_desc' size='30' maxlength='30' onblur='getPrepPractLookupVal();' value=""><input type='hidden' name='prep_practitioner_id' id='prep_practitioner_id' value=""><input type='button' name='prep_pract_id_search' id='prep_pract_id_search' value='?' class='button' onClick='getPractLookupID(this);'>
		</td>

		<td class="label"><fmt:message key="eMR.ReportPreparedDate.label" bundle="${mr_labels}"/></td>
		<td class='fields'>
			<input type='text'  name='rep_prep_date' id='rep_prep_date' size='10' onBlur="validDateObj(this,'DMY','<%=locale%>')" onkeypress="return Valid_DT(event)" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('rep_prep_date');"/>
			
	
			
			
		</td>
	</tr>
	<!--End MO-CRF-20149-->
<%	
}else if(request_type.equals("MB"))
{	%>
	<tr>
		<td class='label'  ><fmt:message key="eMR.MedicalBoardStatus.label" bundle="${mr_labels}"/></td>
		<td class='fields'><select name='status_to_show' id='status_to_show' >
			<option value="1" ><fmt:message key="Common.Requested.label" bundle="${common_labels}"/></option>
			<option value="2" ><fmt:message key="eMR.StatusCompleted.label" bundle="${mr_labels}"/></option>
			<option value="3" ><fmt:message key="eMR.MedicalBoardFormed.label" bundle="${mr_labels}"/></option>
			<option value="4" ><fmt:message key="eMR.ForwardedtoPractitioner.label" bundle="${mr_labels}"/></option>
			<option value="5" ><fmt:message key="eMR.AppointmentGiven.label" bundle="${mr_labels}"/></option>
			<option value="6" ><fmt:message key="eMR.AppointmentIntimated.label" bundle="${mr_labels}"/></option>
			<option value="7" ><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></option>
			<option value="8" ><fmt:message key="eMR.ReceivedbyMedicalBoard.label" bundle="${mr_labels}"/></option>
			<option value="9" ><fmt:message key="eMR.ReportDelivered.label" bundle="${mr_labels}"/></option>
			<option value="0" ><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
			<option value="0-9" selected ><fmt:message key="Common.NotDelivered.label" bundle="${common_labels}"/></option>
			<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='label' ><fmt:message key="Common.RequestDateFrom.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' id="req_date_from" maxlength='10' size='10' name='from_date' id='from_date' onblur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,to_date);' value=""  onkeypress="return Valid_DT(event)"><img src='../../eCommon/images/CommonCalendar.gif'onClick="document.forms[0].req_date_from.focus();return showCalendar('req_date_from');"> - <input type='text' onblur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,from_date);' id="req_date_to" value="" maxlength='10' size='10' name='to_date'  onkeypress="return Valid_DT(event)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].req_date_to.focus();return showCalendar('req_date_to');"/></td>
	</tr>
<%	}	%>
	<tr>	
		<th class="columnheader" colspan="4"  color: "white" align="left" ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
		<jsp:include page="MRPatientDetailsComponent.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="request_type"  value= "<%=request_type%>" />
		</jsp:include>
		<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id"  value= "" /><jsp:param name ="alert_reqd_yn" value= ""  /><jsp:param name ="mr_transaction" value= "Y"  /></jsp:include>
	</tr>
</table>

<table cellspacing=0 cellpadding=1 align='center' width='100%' border='0'>
	<tr>
		<td  colspan="4"  class='button' >
		<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' style="float:right;" class='button' onclick='clear_All()'>
	<input type='button' style="float:right;" name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'></td>
		
	</tr>				
</table>
	<input type='hidden' name=call_function value="<%=call_function%>" > 
	<input type='hidden' name="called_from" id="called_from" value="<%=called_from%>" > 
	<input type='hidden' name="queryStr" id="queryStr" value="<%=request.getQueryString()%>" > 
	<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
	<!--Added by Ashwini on 25-Feb-2019 for MO-CRF-20149-->
	<input type='hidden' name='facility_id' id='facility_id' value="<%=Facility_Id%>"> 

	<!--Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701-->
	<input type="hidden" name="sum_comp_id" id="sum_comp_id" value="<%=sum_comp_id%>" >

	<!--Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331-->
	<input type="hidden" name="nav_menu_id" id="nav_menu_id" value="<%=nav_menu_id%>" >
	
	<!--Added by Mujafar on 23-Apr-2019 for ML-MMOH-CRF-1315-->
	<input type="hidden" name="isAcceptRequestByPractAppl" id="isAcceptRequestByPractAppl" value="<%=isAcceptRequestByPractAppl%>" >
	<input type="hidden" name="isMRConfigurationAppl" id="isMRConfigurationAppl" value="<%=isMRConfigurationAppl%>" > <!-- added by mujafar for ML-MMOH-CRF-1280 -->
	

	<% //ML-MMOH-CRF-0388 - IN057153 - Start
	if(result_def_frm_ca.equals("Y")) {
	%>	
		<script> submitPage(); 	</script>
	<%
	} //ML-MMOH-CRF-0388 - IN057153 - End
	%>	
</form>
<%if(isMRConfigurationAppl && request_type.equals("MR")){ // added by mujafar for ML-MMOH-CRF-1280 %>
<input  type='image'  value='Config Display Order' src='../../eAE/images/config.jpeg' onClick="configFieldOrder(this);"  alt="Column Configuration option" height="20" width="20" align="right" style="margin-right:120px;margin-top:-45px;">
<%}%>
<% if(!request_type.equals("MR")&& !request_type.equals("MB")&& called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isMRConfigurationAppl)
{
%>
<input  type='image'  value='Config Display Order' src='../../eAE/images/config.jpeg' onClick="configFieldOrder(this);"  alt="Column Configuration option" height="20" width="20" align="right" style="margin-right:120px;margin-top:-45px;">

<%}%>

</body>
</html>
<%
}
catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	
	if(stmt!=null)	stmt.close();
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

