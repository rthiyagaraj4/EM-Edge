<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head> 
		<title><fmt:message key="Common.PatientValuables.label" bundle="${common_labels}"/></title>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	
	</head>
	<% request.setCharacterEncoding("UTF-8");
		//added on 4/8/8 for  SCR 5008
		String encounterId				= checkForNull(request.getParameter("encounterId"));
		String patientId				= checkForNull(request.getParameter("patientId"));
	%>
	<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?<%=request.getQueryString()%>&EncounterId=<%=encounterId%>' noresize  frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
	<iframe name='PatientValuablesDetails' id='PatientValuablesDetails' src='../../eMR/jsp/PatientValuablesDtls.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:76vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
</html>  

<%!
	//added on 4/8/8 
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

