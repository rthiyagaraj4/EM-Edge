<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import ="eST.Common.StRepository, eST.ScheduleAutoRequestBean" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ScheduleAutoRequestReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		
		String facility_id				=	  (String) session.getValue( "facility_id" ) ;
		String user_name				=		(String)session.getAttribute("login_user");
	
	%>
	<body onLoad="FocusFirstElement();">
		<form name="schduleAutoReportCriteria" id="schduleAutoReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='80%' align='center' >
			<tr>
				<th align="left" colspan = 10><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td class=label ><fmt:message key="eST.ScheduleCode.label" bundle="${st_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='p_schedule_code' id='p_schedule_code' size="20" maxlength="10" value="" readonly>&nbsp;<input type="button" name="req_on_code" id="req_on_code" value="?" class="button" onClick="SchduleCodeLookup(p_schedule_code);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='text' name='p_schedule_desc' id='p_schedule_desc' size="45" value="" readonly >
			</tr>
			<tr>
			<td>&nbsp;</td>
			
			</tr>
			<tr>
			<td align="left" class="label"><fmt:message key="Common.view.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="view" id="view" onchange="changeType(this);" >
			<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="S"><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
			</select> </td>
			
			
			</tr>
			<tr>
			<td>&nbsp;</td>
			
			</tr>
			<tr>
					<td class=label ><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='req_by_store_desc' id='req_by_store_desc' value="" size="25" disabled readonly ><input type="button" name="req_code" id="req_code" value="?" class="button" onClick="requestByStoreLookup(req_by_store_desc);" disabled>
				
					<input type="hidden" name="p_requisition_by_store" id="p_requisition_by_store" value="">
				
					<fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text' name='req_on_store_desc' id='req_on_store_desc' size="25" value="" readonly><input type="button" name="req_on_code" id="req_on_code" value="?" class="button" onClick="requestOnStoreLookup(req_on_store_desc,p_requisition_by_store);"></td>
					</tr>
					<input type="hidden" name="p_requisition_on_store" id="p_requisition_on_store" value="">

					
				
		</table>
		<input type="hidden" name="p_module_id" id="p_module_id" 	value="ST">
		<input type="hidden" name="p_report_id" id="p_report_id"		value="">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_name%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
		<input type="hidden"   name="SQL_SCHDULE_AUTO_STORE_LOOKUP" id="SQL_SCHDULE_AUTO_STORE_LOOKUP" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_SCHDULE_AUTO_STORE_LOOKUP")%>">
		<input type="hidden"   name="SQL_SCHDULE_AUTO_CODE_LOOKUP" id="SQL_SCHDULE_AUTO_CODE_LOOKUP" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_SCHDULE_AUTO_CODE_LOOKUP")%>">
	
	
		</form>
	</body>
</html>	

