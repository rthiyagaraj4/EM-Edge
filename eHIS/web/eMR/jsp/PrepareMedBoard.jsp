<!DOCTYPE html>
<%
/*
 ************************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 29 MARCH 2005
************************************************************************************************
			Function name				|		Function ID			| REQUEST_STATUS inserted...
 ************************************************************************************************
	Request For Medical Board			| MEDICAL_BOARD_REQUEST		|		1
	Status of Medical Board Request		| MEDICAL_BOARD_STATUS		|		2
	Forward Medical Board Request		| FORWARD_MEDICAL_BOARD		|		3
	Formation of Medical Board			| MEDICAL_BOARD_FORMATION	|		4
	Appointment for Med Board request	| MEDICAL_BOARD_APPT		|		5
	Intimate Appointment of Med Board	| MEDICAL_BOARD_INT_APPT	|		6
	Prepare Medical Report by Board		| PREPARE_MEDICAL_BOARD		|		7
	Receive Medical Report				| RECEIVE_MEDICAL_BOARD		|		8
	Deliver/Dispatch Medical Report		| DELIVER_MEDICAL_REPORT	|		9
 ************************************************************************************************
*/
%>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
		<script src='../../eMR/js/MedBoardRequest.js' language='javascript'></script>	
	</head>
<%
	 request.setCharacterEncoding("UTF-8");
	//String url			= "../../eCommon/jsp/commonToolbar.jsp?";
	//String params		= request.getQueryString() ;
	//String source		= url + params ;
	String call_function= checkForNull(request.getParameter("function_id"));
	String called_from= checkForNull(request.getParameter("called_from"));
	if( call_function.equals("PREPARE_MEDICAL_BOARD") )
	{	
			
			if(called_from.equals("CA"))	{%>
			<frameset rows='4,265,*,50'>
			<% }else	{%>
			<frameset rows='4,230,*,50'>
			<% }%>
			<frame scrolling="no" name='blank' src='../../eCommon/html/blank.html' noresize frameborder=0>
			<frame scrolling="no" name='criteriaFrame' src='../../eMR/jsp/ReportRequestQueryCriteria.jsp?call_function=<%=call_function%>&function_id=<%=call_function%>&called_from=<%=called_from%>' noresize frameborder=0>
			<frame scrolling="auto" name='resultFrame' src='../../eCommon/html/blank.html'  noresize frameborder=0>
			<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
		</frameset>
<%	}	%>

</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>
