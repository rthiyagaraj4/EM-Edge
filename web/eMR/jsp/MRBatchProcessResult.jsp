<!DOCTYPE html>
<!--Created by Thamizh selvi on 10th July 2017 against ML-MMOH-CRF-719-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMR/js/MRBatchProcess.js' language='javascript'></script>
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
		String cutOffDate		= checkForNull(request.getParameter("cutOffDate"));
			
		String patientId		= "";
		String patientName		= "";
		long requestId			= 0;
		String requestDate		= "";
		String gender			= "";

		int currentPageNo 	= 1;
		if(request.getParameter("currentPageNo") != null)
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
			
		JSONObject incompleteReqDtls = new JSONObject();
		JSONArray incompleteReqDtlsArray = new JSONArray();

		incompleteReqDtls  = eMR.MRCommonBean.getIncompleteReqDtls(con,locale,facilityId,cutOffDate,currentPageNo);

		int curPageNo		= 0;
		curPageNo		= (Integer) incompleteReqDtls.get("currentPageNo");
					
		int noOfRecords		= 0;
		noOfRecords		= (Integer) incompleteReqDtls.get("noOfRecords");
		
		int noOfPages		= 0;
		noOfPages		= (Integer) incompleteReqDtls.get("noOfPages");

		incompleteReqDtlsArray = (JSONArray) incompleteReqDtls.get("IncompReqArray");
				
		int prevPageNo	= curPageNo - 1;		
		int nextPageNo	= curPageNo + 1;
			
	%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='MRBatchProcessResultForm' id='MRBatchProcessResultForm' method="post" target='messageFrame'>
<table align='right'>
	<tr>
		<% if ( curPageNo > 1 ){ %>
			<td align ='right' id='prev'><A HREF="../../eMR/jsp/MRBatchProcessResult.jsp?cutOffDate=<%=cutOffDate%>&currentPageNo=<%=prevPageNo%>" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
		<%}
		if ( curPageNo >=1 && curPageNo != noOfPages ){%>
			<td align ='right' id='next'><A HREF="../../eMR/jsp/MRBatchProcessResult.jsp?cutOffDate=<%=cutOffDate%>&currentPageNo=<%=nextPageNo%>" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
		<%}%>
	</tr>
</table>
<br><br>
<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >
	<tr>
		<td>
	
			<tr>
				<td width='4%' class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="eMR.RequestID.label" bundle="${mr_labels}"/>&nbsp;</td>
				<td width='7%' class="columnheadercenter" style="background-color: black; color: white;"align='center' nowrap><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='7%' class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='20%' class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='7%' class="columnheadercenter"  style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
			</tr>		
			<%
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";

			for(int i=0 ; i < incompleteReqDtlsArray.size(); i++)
			{
				JSONObject json	= (JSONObject)incompleteReqDtlsArray.get(i);
				patientId		= (String) json.get("patientId");
				patientName		= (String) json.get("patientName");
				requestId		= (Long) json.get("requestId");
				requestDate		= (String) json.get("requestDate");
				gender			= (String) json.get("gender");

			%>
			<tr>
				<td width='4%' nowrap class='<%=class_val%>'><%=requestId%></td>
				<td width='7%' nowrap class='<%=class_val%>'><%=requestDate%></td>
				<td width='7%' nowrap class='<%=class_val%>'><%=patientId%></td>
				<td width='20%' nowrap class='<%=class_val%>'><%=patientName%></td>
				<td width='7%' nowrap class='<%=class_val%>'><%=gender%></td>
			</tr>
			<% } %>
		</td>
	</tr>
</table>		
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

