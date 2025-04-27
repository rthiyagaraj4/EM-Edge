<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection, java.util.*, java.text.*, java.sql.*, java.sql.Statement,java.sql.ResultSet,java.util.HashMap" contentType="text/html;charset=UTF-8"%> 
<%@ page import ="eXH.XHUtil,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,eXB.*,com.ehis.util.DateUtils,com.ehis.util.FormatterFactory" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script language="javascript" src="../../eXB/js/ssMonDPReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<html>
<TITLE></TITLE>

<%
	String resultMessage = XHDBAdapter.checkNull(request.getParameter("message"));
	String statusCode = XHDBAdapter.checkNull(request.getParameter("statuscode"));
	String funcSelected = XHDBAdapter.checkNull(request.getParameter("funcselected"));
	String noExPrivExtended = "";
	String noExPrivRemoved = "";
	String noPrivilegeAdded = "";
	String noPrivilegeInvalid = "";
	String dataBypassed = "";
	String p_facility_id = (String) session.getValue("facility_id");
	String p_user_name = (String) session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE");
	String dateFormat = "dd/MM/yyyy hh:mm:ss";
	String processDate = "";
	String tempProcessDate = "";
	String confirmDate = "";
	String tempConfirmDate = "";
	String dataUploadDate = "";
	String tempUploadDate = "";
	String jobWhat = "";
	String jobLastProcDate = "";
	String jobNextProcDate = "";
	String jobID = "";
	String jobPreviousStatus = "";
	String socSecDataErrMsg = "";
	String processJobNo = "0";
	String confirmJobNo = "0";
	String ssPrivUploadCount = "0";
	List<HashMap> errData = null;
	ArrayList<HashMap> jobData = new ArrayList<HashMap>();
	int jobDataSize = 0;
	String sqlQuery = "SELECT def_ss_blng_grp_id,def_ss_cust_group_code,def_ss_cust_code,def_ss_policy_type_code,def_ss_policy_number,to_char(last_process_date,'dd/mm/yyyy HH24:MI:SS') last_process_date, to_char(last_process_confirm_date,'dd/mm/yyyy HH24:MI:SS') last_process_confirm_date, to_char(last_data_uploaded_date,'dd/mm/yyyy HH24:MI:SS') last_data_uploaded_date,no_ex_priv_extended,no_ex_priv_removed,no_privilege_added,no_privilege_invalid,no_ss_data_bypassed FROM xf_ss_priv_default_values";
	String jobSearchQry = "SELECT job, to_char(last_date,'dd/mm/yyyy HH24:MI:SS') last_date, to_char(next_date,'dd/mm/yyyy HH24:MI:SS') next_date, what, DECODE(NVL(failures,0),0,'Submitted','Failed') prev_status, this_date FROM dba_jobs WHERE what IN ('XBSSINT.PROCESSMAIN(''"+p_facility_id+"'');','xbssint.process_delete_ss();','xbssint.ssupload_data;')";
	String ssPrivUploadQry = "SELECT COUNT(*) FROM xf_ss_inbound_tab WHERE processed_date IS NULL";

	boolean isProcessEligible = false;
	boolean isUploadEligible = false;
	boolean isProcessJobExists = false;
	boolean isConfirmEligible = false;
	boolean isConfirmJobExists = false;
	boolean isJobExists = false;

	SSMonDPHelper ssMonDPHelper = new SSMonDPHelper();

	Connection connection	= null;
	Statement statement		= null;	
	ResultSet resultSet		= null;
	ResultSet jobRS		= null;
	try
	{
		try
		{
			if(connection == null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp)
		{
			System.out.println("Error in calling getconnection method of ssMonDPReportCriteria : "+exp.toString());
			exp.printStackTrace(System.err);		       
		}
		
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sqlQuery);		
		
		if(resultSet.next())
		{			
			processDate = XHDBAdapter.checkNull(resultSet.getString("last_process_date"));			
			confirmDate = XHDBAdapter.checkNull(resultSet.getString("last_process_confirm_date"));
			dataUploadDate = XHDBAdapter.checkNull(resultSet.getString("last_data_uploaded_date"));
			noExPrivExtended = XHDBAdapter.checkNull(resultSet.getString("NO_EX_PRIV_EXTENDED"));
			noExPrivRemoved = XHDBAdapter.checkNull(resultSet.getString("NO_EX_PRIV_REMOVED"));
			noPrivilegeAdded = XHDBAdapter.checkNull(resultSet.getString("NO_PRIVILEGE_ADDED"));
			noPrivilegeInvalid = XHDBAdapter.checkNull(resultSet.getString("NO_PRIVILEGE_INVALID"));
			dataBypassed = XHDBAdapter.checkNull(resultSet.getString("NO_SS_DATA_BYPASSED"));

			String ssBlngGrpID = resultSet.getString("def_ss_blng_grp_id");
			String ssCustGrpID = resultSet.getString("def_ss_cust_group_code");
			String ssCustCode = resultSet.getString("def_ss_cust_code");
			String ssPolicyTypeCode = resultSet.getString("def_ss_policy_type_code");
			String ssPolicyNo = resultSet.getString("def_ss_policy_number");

			if(ssBlngGrpID == null || ssBlngGrpID.trim().equals("")) socSecDataErrMsg = "BGID";
			else if(ssCustGrpID == null || ssCustGrpID.trim().equals("")) socSecDataErrMsg = "CGID";
			else if(ssCustCode == null || ssCustCode.trim().equals("")) socSecDataErrMsg = "CC";
			else if(ssPolicyTypeCode == null || ssPolicyTypeCode.trim().equals("")) socSecDataErrMsg = "PTC";
			else if(ssPolicyNo == null || ssPolicyNo.trim().equals("")) socSecDataErrMsg = "PNO";

			if(resultSet.next()) socSecDataErrMsg = "1";
		}
		else
		{
			socSecDataErrMsg = "0";
		}
		
		if(dataUploadDate == null || dataUploadDate.equals("")) dataUploadDate = "-";
		if(processDate == null || processDate.equals("")) processDate = "-";
		if(confirmDate == null || confirmDate.equals("")) confirmDate = "-";
		
		tempUploadDate = dataUploadDate;
		tempProcessDate = processDate;
		tempConfirmDate = confirmDate;

		jobRS = statement.executeQuery(jobSearchQry);

		while(jobRS.next())
		{			
			isJobExists = true;

			HashMap<String,String> tempJobMap = new HashMap<String,String>();
			tempJobMap.put("jobWhat", jobRS.getString("what"));
			tempJobMap.put("jobLastProcDate", XHDBAdapter.checkNull(jobRS.getString("last_date")));
			tempJobMap.put("jobNextProcDate", XHDBAdapter.checkNull(jobRS.getString("next_date")));
			tempJobMap.put("jobID", jobRS.getString("job"));
			tempJobMap.put("jobPreviousStatus", jobRS.getString("prev_status"));
			tempJobMap.put("thisDate", jobRS.getString("this_date"));

			if(!jobRS.getString("what").equals("xbssint.process_delete_ss();")) 
			{
				jobLastProcDate = jobRS.getString("last_date");
				isProcessJobExists = true;
				processJobNo = jobRS.getString("job");
			}
			else 
			{
				isConfirmJobExists = true;
				confirmJobNo = jobRS.getString("job");
			}

			if(jobRS.getString("what").equals("xbssint.process_delete_ss();"))
			{
				jobWhat = "C";
			}
			else if(jobRS.getString("what").equals("xbssint.ssupload_data;"))
			{
				jobWhat = "D";
			}
			else if(jobRS.getString("what").equals("XBSSINT.PROCESSMAIN('"+p_facility_id+"');"))
			{
				jobWhat = "P";
			}			

			jobData.add(tempJobMap);
		}

		jobDataSize = jobData.size();		
		errData = ssMonDPHelper.checkErrors(processDate);		

		if(!processDate.equals("-")) 
		{			
			processDate = XHUtil.xhLocaleDateDisplay(processDate, dateFormat, "DMYHMS", locale, true);
		}
		if(!dataUploadDate.equals("-")) dataUploadDate = XHUtil.xhLocaleDateDisplay(dataUploadDate, dateFormat, "DMYHMS", locale, true);
		if(!confirmDate.equals("-")) confirmDate = XHUtil.xhLocaleDateDisplay(confirmDate, dateFormat, "DMYHMS", locale, true);
		if(jobLastProcDate != null && !jobLastProcDate.equals("")) jobLastProcDate = XHUtil.xhLocaleDateDisplay(jobLastProcDate, dateFormat, "DMYHMS", locale, true);
		if(jobNextProcDate != null && !jobNextProcDate.equals("")) jobNextProcDate = XHUtil.xhLocaleDateDisplay(jobNextProcDate, dateFormat, "DMYHMS", locale, true);

		XHUtil xhUtil = new XHUtil();
		ssPrivUploadCount = xhUtil.singleParamExeQry(ssPrivUploadQry);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(resultSet != null) resultSet.close();
			if(statement != null) statement.close();
			if(jobRS != null) jobRS.close();
			if(connection != null) ConnectionManager.returnConnection(connection);
		}
		catch(Exception es)
		{
			es.printStackTrace(System.err) ;
		}
	}
	if(isJobExists)
	{
%>
	<META HTTP-EQUIV="REFRESH" CONTENT="10">
<%
	}
%>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();" onLoad='initFunc()'>
<br>
<form name="ssMonDPReportForm" id="ssMonDPReportForm" id="ssMonDPReportForm" method='post'>
<%
	if(isJobExists)
	{
%>
<table width='100%'>
<tr>
	<td colspan="4" align="right">
		<a href="#" onClick="reloadPage()"><FONT class="HYPERLINK"><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></FONT></a>
	</td>
</tr>
<tr>
	<td class='COLUMNHEADER'><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.LastExecution.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.NextExecution.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>
<% 
	for(int i = 0; i < jobDataSize; i++)
	{ 
		HashMap<String,String> jobMap = jobData.get(i);
%>
<tr>
	<td><%= jobMap.get("jobID") %>-<%= jobMap.get("jobWhat") %></td>
	<td><%= jobMap.get("jobLastProcDate") %></td>
	<td><%= jobMap.get("jobNextProcDate") %></td>
	<td><%= (jobMap.get("thisDate") == null || jobMap.get("thisDate").equals(""))?jobMap.get("jobPreviousStatus"):"Running" %></td>
</tr>
<%}%>
</table>
<br><br>
<%
	}
String colSpan = "3";
if(errData != null && errData.size() > 0) colSpan = "4";
%>
<table width='80%' align='center' valign='top'>

	<td  class='columnheader' colspan='<%= colSpan %>' align='left'> 
		SS Monthly Data Process
	</td>
	<tr>
	<td class='label'>
		<fmt:message key="eXH.LAST_UPLOAD_DATE.Label" bundle="${xh_labels}"/> [ <B><%= dataUploadDate %></B> ]
	</td>
	<td class='label'>
	<%	if(!processDate.equals("-")) 
		{
	%>
		<a href="#" onClick="showProcResWindow()">
	<%	}	%>
		<fmt:message key="Common.LastProcessedDate.label" bundle="${common_labels}"/>
	<%	if(!processDate.equals("-")) 
		{
	%>
		</a>
	<%	}	%>
		[ <B><%= processDate %></B> ] 
	</td>
	<td class='label'>
		<fmt:message key="eXH.LAST_CFM_DATE.Label" bundle="${xh_labels}"/>  [ <B><%= confirmDate %></B> ] 
	<%	if(errData != null && errData.size() > 0) { %>
	</td>
	<td class='label'>
			<a href="javascript:dispError();">
				<fmt:message key="eXH.ProcessingError.Label" bundle="${xh_labels}"/>
			</a>
		<% }%>
	</td>
	</tr>

	<tr>
		<td width="100%" class="Border" align='center' colspan='<%= colSpan %>'>

			<table width='80%' cellPadding="3" cellSpacing="3"  align='center'>				
			<tr></tr>
			<tr>
				<td align='right' width='30%' class="label"><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
				<td width='50%'>
					<SELECT name="ssDPFunc" id="ssDPFunc" ID="ssDPFunc" onChange='showDateCriteria()'>
						<OPTION VALUE="" SELECTED><fmt:message key="Common.Select.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="D"><fmt:message key="eXH.DATA_UPLOAD.Label" bundle="${xh_labels}"/></OPTION>
						<OPTION VALUE="P"><fmt:message key="eXH.PROC_SOC_SEC_DATA.Label" bundle="${xh_labels}"/></OPTION>
						<OPTION VALUE="C"><fmt:message key="eXH.CNF_ARC_SOC_SEC_DATA_PROC.Label" bundle="${xh_labels}"/></OPTION>
						<OPTION VALUE="S"><fmt:message key="eXH.RP_OPEN_ENC_PRIV_UPDATE.Label" bundle="${xh_labels}"/></OPTION>
						<OPTION VALUE="E"><fmt:message key="eXH.RP_UNREG_SS_PAT_PRIV_UPDATE.Label" bundle="${xh_labels}"/></OPTION>
					</SELECT>
				</td>
			</tr>			

			<tr id='dateLTR' style='display:none;'>
				<td  width="30%">&nbsp;</td>
				<td class="fields" width="30%">
					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
			</tr>

			<tr id='dateTR' style='display:none;'>
				<td align='right' width='30%' class="label"><fmt:message key="eXH.ProcessDate.Label" bundle="${xh_labels}"/></td>
				<td width='30%' >
					<input type="text" size='16' maxlength="16" value='' align="center" id='p_from_date' label="From Date" name='p_from_date' id='p_from_date' onBlur="fromToDateVal(p_from_date, p_to_date, 'DMYHM', this);"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_date','dd/mm/y hh:mm');"  >
					<input type="text" size='16' maxlength="16" value='' name='p_to_date' id='p_to_date' align="center" label="To Date" onBlur="fromToDateVal(p_from_date, p_to_date, 'DMYHM', this);"> <input type='image' name='showcalndr' id='showcalndr' id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_date','dd/mm/y hh:mm');"  >
				</td>
			</tr>
		</table>
	</td>
</tr>
</table>

<input type='hidden' id='tempProcessDate' value='<%= tempProcessDate %>'>
<input type='hidden' id='tempConfirmDate' value='<%= tempConfirmDate %>'>
<input type='hidden' id='tempUploadDate' value='<%= tempUploadDate %>'>
<input type='hidden' id='isProcessEligible' value='<%= isProcessEligible %>'>
<input type='hidden' id='isConfirmEligible' value='<%= isConfirmEligible %>'>
<input type='hidden' id='isConfirmJobExists' value='<%= isConfirmJobExists %>'>
<input type='hidden' id='isProcessJobExists' value='<%= isProcessJobExists %>'>
<input type='hidden' id='ssFieldValidation' value='<%= socSecDataErrMsg %>'>
<input type='hidden' id='actionParam' name='actionParam' id='actionParam' value='S'>
<input type='hidden' id='processJobNo' name='processJobNo' id='processJobNo' value='<%= processJobNo %>'>
<input type='hidden' id='confirmJobNo' name='confirmJobNo' id='confirmJobNo' value='<%= confirmJobNo %>'>
<input type="hidden" name="opdDate" id="opdDate" id="opdDate">
<input type='hidden' name='custCode' id='custCode' id='custCode' value=''>
<input type='hidden' name='jobWhat' id='jobWhat' id='jobWhat' value='<%= jobWhat %>'>
<input type='hidden' name='ssPrivUploadCount' id='ssPrivUploadCount' id='ssPrivUploadCount' value='<%= ssPrivUploadCount %>'>

</form>

<form name="dummyForm" id="dummyForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='<%= p_facility_id %>'>
<input type='hidden' name='p_module_id' id='p_module_id' value='XB'>
<input type='hidden' name='p_report_id' id='p_report_id' value='XBPRVUPD'>
<input type='hidden' name='P_USER_NAME' id='P_USER_NAME'	value='<%= p_user_name %>'>
<input type='hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' id='locale' value='<%= locale %>'>
<input type='hidden' name='P_PROCESS_DATE_FROM' id='P_PROCESS_DATE_FROM' id='P_PROCESS_DATE_FROM ' value=''>
<input type='hidden' name='P_PROCESS_DATE_TO' id='P_PROCESS_DATE_TO' id='P_PROCESS_DATE_TO' value=''>

</form>
<input type="hidden" name="resultMessage" id="resultMessage" id="resultMessage" value="<%= resultMessage %>">
<input type="hidden" name="noExPrivExtended" id="noExPrivExtended" id="noExPrivExtended" value="<%= noExPrivExtended %>">
<input type="hidden" name="noExPrivRemoved" id="noExPrivRemoved" id="noExPrivRemoved" value="<%= noExPrivRemoved %>">
<input type="hidden" name="noPrivilegeAdded" id="noPrivilegeAdded" id="noPrivilegeAdded" value="<%= noPrivilegeAdded %>">
<input type="hidden" name="noPrivilegeInvalid" id="noPrivilegeInvalid" id="noPrivilegeInvalid" value="<%= noPrivilegeInvalid %>">
<input type="hidden" name="dataBypassed" id="dataBypassed" id="dataBypassed" value="<%= dataBypassed %>">
<input type="hidden" name="statusCode" id="statusCode" id="statusCode" value="<%= statusCode %>">
<input type="hidden" name="funcSelected" id="funcSelected" id="funcSelected" value="<%= funcSelected %>">
<input type="hidden" name="errorRecordSize" id="errorRecordSize" id="errorRecordSize" value="<%= (errData == null)?"0":errData.size() %>">
<input type="hidden" name="dataUploadDate" id="dataUploadDate" id="dataUploadDate" value="<%= dataUploadDate %>">

</BODY>
</HTML>

