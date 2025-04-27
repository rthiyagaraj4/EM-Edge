<!DOCTYPE html>
<!--Created by Thamizh selvi on 10th July 2017 against ML-MMOH-CRF-719-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eAE/js/AEQueryBackdatedCons.js' language='javascript'></script>
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
		String locale			= checkForNull((String)session.getValue("locale"));
		String patientId		= checkForNull(request.getParameter("patient_id"));
		String trnFromDate		= checkForNull(request.getParameter("trn_from_date"));
		String trnToDate		= checkForNull(request.getParameter("trn_to_date"));
			
		String patientName		= "";
		String treatmentZone	= "";
		String trnDate			= "";
		String consBackDate		= "";
		String consDoneBy		= "";
		String patient_id		= "";

		int currentPageNo 	= 1;
		int recordsPerPage 	= 16;

		if(request.getParameter("currentPageNo") != null)
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
			
		JSONObject backDatedConsDtls		= new JSONObject();
		JSONArray backDatedConsDtlsArray	= new JSONArray();

		backDatedConsDtls  = eAE.AECommonBean.getBackdatedConsDtls(con,locale,facilityId,trnFromDate,trnToDate,patientId,currentPageNo,recordsPerPage);

		int curPageNo		= 0;
		curPageNo		= (Integer) backDatedConsDtls.get("currentPageNo");
					
		int noOfRecords		= 0;
		noOfRecords		= (Integer) backDatedConsDtls.get("noOfRecords");
		
		int noOfPages		= 0;
		noOfPages		= (Integer) backDatedConsDtls.get("noOfPages");

		backDatedConsDtlsArray = (JSONArray) backDatedConsDtls.get("backDatedConsDtlsArr");
				
		int prevPageNo	= curPageNo - 1;		
		int nextPageNo	= curPageNo + 1;
			
	%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='AEQueryBackDatedResultForm' id='AEQueryBackDatedResultForm' method="post" target='messageFrame'>

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
			<td align ='right' id='prev'><A HREF="../../eAE/jsp/AEQueryBackdatedConsResult.jsp?trn_from_date=<%=trnFromDate%>&trn_to_date=<%=trnToDate%>&patient_id=<%=patientId%>&currentPageNo=<%=prevPageNo%>" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
		<%}
		if ( curPageNo >=1 && curPageNo != noOfPages ){%>
			<td align ='right' id='next'><A HREF="../../eAE/jsp/AEQueryBackdatedConsResult.jsp?trn_from_date=<%=trnFromDate%>&trn_to_date=<%=trnToDate%>&patient_id=<%=patientId%>&currentPageNo=<%=nextPageNo%>" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
		<%}%>
	</tr>
</table>
<br><br>
<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >
	<tr>
		<td>
	
			<tr>
				<td width='12%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='36%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='12%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='10%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.StartConsult.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='20%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='10%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;</td>
			</tr>		
			<%
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";

			for(int i=0 ; i < backDatedConsDtlsArray.size(); i++)
			{
				JSONObject json	= (JSONObject)backDatedConsDtlsArray.get(i);
				patient_id		= (String) json.get("patientId");
				patientName		= (String) json.get("patientName");
				treatmentZone	= (String) json.get("treatmentZone");
				trnDate			= (String) json.get("trnDate");
				consBackDate	= (String) json.get("consBackDate");
				consDoneBy		= (String) json.get("consDoneBy");

			%>
			<tr>
				<td width='12%' nowrap class='<%=class_val%>'><%=patient_id%></td>
				<td width='36%' nowrap class='<%=class_val%>'><%=patientName%></td>
				<td width='12%' nowrap class='<%=class_val%>'><%=treatmentZone%></td>
				<td width='10%' nowrap class='<%=class_val%>'><%=consBackDate%></td>
				<td width='20%' nowrap class='<%=class_val%>'><%=consDoneBy%></td>
				<td width='10%' nowrap class='<%=class_val%>'><%=trnDate%></td>
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

