<!DOCTYPE html>
<%
/**
MODULE			:	Medical Records..(MR)
Function Name	:	WEHU - A1 / A2 && WEHU - D1 / D2
Developer		:	SRIDHAR R
Created On		:	10 JAN 2005
**/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		
	</head>
	<%
		request.setCharacterEncoding("UTF-8");
		String FacilityId=request.getParameter("FacilityId");
			if(FacilityId == null) FacilityId = "";

		String call_function=request.getParameter("call_function");
			if(call_function == null) call_function = "";

		String PatientId=request.getParameter("PatientId");
			if(PatientId == null) PatientId = "";

		String Encounter_Id=request.getParameter("Encounter_Id");
			if(Encounter_Id == null) Encounter_Id = "";

			if(call_function.equals("MRBWEHUA"))
			{	%>
				<title>WEHU - A1 / A2</title>
		<%	}
			if(call_function.equals("MRBWEHUD"))
			{	%>
				<title>WEHU - D1 / D2</title>
		<%	}	

			if(call_function.equals("MRBCANNT"))
			{	%>
				<title><fmt:message key="eMR.CancerNotificationRegistryForm.label" bundle="${mr_labels}"/></title>
		<%	}	%>

		<iframe scrolling="auto" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repWEHUADDiagnosisQueryResult.jsp?call_function=<%=call_function%>&PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>' noresize frameborder=0 style='height:100%;width:100vw'></iframe><iframe scrolling="no" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:0%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
</html>
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

