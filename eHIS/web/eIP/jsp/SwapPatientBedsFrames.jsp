<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<title><fmt:message key="eIP.SwapPatientBeds.label" bundle="${ip_labels}"/></title>
</head>

<%
	String where_criteria	= checkForNull(request.getParameter("where_criteria"));
	String encounter_id1	= checkForNull(request.getParameter("encounter_id1"));
	String encounter_id2	= checkForNull(request.getParameter("encounter_id2"));
%>	
	
	<iframe name="Transfer_frame" id="Transfer_frame" src="../../eIP/jsp/SwapPatientBedDetails.jsp?where_criteria=<%=where_criteria%>&encounter_id1=<%=encounter_id1%>&encounter_id2=<%=encounter_id2%>" scrolling='no' style='height:80vh;width:100vw'></iframe><iframe src="../../eCommon/jsp/error.jsp?" name="Dummy_frame" id="Dummy_frame" scrolling='yes' noresize style='height:0%;width:100vw'></iframe>
	
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

