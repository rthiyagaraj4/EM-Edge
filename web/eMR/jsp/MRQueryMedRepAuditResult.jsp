<!DOCTYPE html>
<!--Created by Thamizh selvi on 10th July 2017 against ML-MMOH-CRF-719-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMR/js/MRQueryModifiedMedRepAudit.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	Connection con = null;
	try
	{	
		con		= ConnectionManager.getConnection(request);	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String class_val		= "QRYEVENSMALL";		
		String facilityId		= checkForNull((String)session.getValue("facility_id"));
		String locale			= checkForNull((String)session.getValue("LOCALE"));
		String patientId		= checkForNull(request.getParameter("patient_id"));
		String modFromDate		= checkForNull(request.getParameter("mod_from_date"));
		String modToDate		= checkForNull(request.getParameter("mod_to_date"));
			
		String patientName		= "";
		String gender			= "";
		String preparePractName	= "";
		String preparedDate		= "";
		String deliveredDate	= "";
		String collectionMode	= "";
		String modifiedBy		= "";
		String modifiedDate		= "";
		String modRemarks		= "";
		String patient_id		= "";
		String requestId		= "";
		String collectDate		= "";
		String reviseCollectDt	= "";

		int currentPageNo 	= 1;
		int recordsPerPage 	= 16;

		if(request.getParameter("currentPageNo") != null)
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
			
		JSONObject modifiedRepAuditDtlsObj	= new JSONObject();
		JSONArray modifiedRepAuditDtlsArr	= new JSONArray();

		modifiedRepAuditDtlsObj  = eMR.MRCommonBean.getModifiedRepAuditDtls(con,locale,facilityId,modFromDate,modToDate,patientId,currentPageNo,recordsPerPage);

		int curPageNo		= 0;
		curPageNo		= (Integer) modifiedRepAuditDtlsObj.get("currentPageNo");
					
		int noOfRecords		= 0;
		noOfRecords		= (Integer) modifiedRepAuditDtlsObj.get("noOfRecords");
		
		int noOfPages		= 0;
		noOfPages		= (Integer) modifiedRepAuditDtlsObj.get("noOfPages");

		modifiedRepAuditDtlsArr = (JSONArray) modifiedRepAuditDtlsObj.get("modifiedRepAuditDtlsArr");
				
		int prevPageNo	= curPageNo - 1;		
		int nextPageNo	= curPageNo + 1;
			
	%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='MedRepAuditResultForm' id='MedRepAuditResultForm' method="post" target='messageFrame'>

<% if(noOfRecords == 0){ %>
	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		parent.frames[3].location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	</script>
<% }else{ %>

<table align='right'>
	<tr>
		<% if ( curPageNo > 1 ){ %>
			<td align ='right' id='prev'><A HREF="../../eMR/jsp/MRQueryMedRepAuditResult.jsp?mod_from_date=<%=modFromDate%>&mod_to_date=<%=modToDate%>&patient_id=<%=patientId%>&currentPageNo=<%=prevPageNo%>" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
		<%}
		if ( curPageNo >=1 && curPageNo != noOfPages ){%>
			<td align ='right' id='next'><A HREF="../../eMR/jsp/MRQueryMedRepAuditResult.jsp?mod_from_date=<%=modFromDate%>&mod_to_date=<%=modToDate%>&patient_id=<%=patientId%>&currentPageNo=<%=nextPageNo%>" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
		<%}%>
	</tr>
</table>
<br><br>
<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >
	<tr>
		<td>
	
			<tr>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.RequestID.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='36%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.ReportPreparedDate.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.DeliveredDate.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.RevisedCollectDate.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.CollectionMode.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='12%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='10%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eMR.Modification.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.requesteddate.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='10%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Modification.label" bundle="${mr_labels}"/></td>
			</tr>		
			<%
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";

			for(int i=0 ; i < modifiedRepAuditDtlsArr.size(); i++)
			{
				JSONObject json	= (JSONObject)modifiedRepAuditDtlsArr.get(i);
				patient_id		= (String) json.get("patientId");
				requestId		= (String) json.get("requestId");
				patientName		= (String) json.get("patientName");
				gender			= (String) json.get("gender");
				preparePractName= (String) json.get("preparePractName");
				preparedDate	= (String) json.get("preparedDate");
				deliveredDate	= (String) json.get("deliveredDate");
				collectDate		= (String) json.get("collectDate");
				reviseCollectDt	= (String) json.get("reviseCollectDt");
				collectionMode	= (String) json.get("collectionMode");
				modifiedBy		= (String) json.get("modifiedBy");
				modifiedDate	= (String) json.get("modifiedDate");
				modRemarks		= (String) json.get("modRemarks");

			%>
			<tr>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=requestId%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=patient_id%></td>
				<td width='36%' nowrap class='<%=class_val%>'>&nbsp;<%=patientName%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=gender%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=preparePractName%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=preparedDate%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=deliveredDate%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=collectDate%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=reviseCollectDt%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=collectionMode%></td>
				<td width='12%' nowrap class='<%=class_val%>'>&nbsp;<%=modifiedBy%></td>
				<td width='10%' nowrap class='<%=class_val%>'>&nbsp;<%=modifiedDate%></td>
				<td width='10%' nowrap class='<%=class_val%>'>&nbsp;<%=modRemarks%></td>
			</tr>
			<% } %>
		</td>
	</tr>
</table>
<% } %>
</form>
</body>
		
<%				
}catch(Exception e)
{
	//out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}	
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

