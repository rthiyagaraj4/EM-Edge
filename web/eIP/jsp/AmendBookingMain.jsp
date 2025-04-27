<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String call_function	= checkForNull(request.getParameter("call_function")) ;
%>	
<html>
<title>
<%
if(call_function.equals("AB"))
{
	%><fmt:message key="eIP.ActiveBooking.label" bundle="${ip_labels}"/><%
}
else if(call_function.equals("CB"))
{	
	%><fmt:message key="eIP.NoShowsCancelledBooking.label" bundle="${ip_labels}"/><%
}
else if(call_function.equals("AT"))
{
	%><fmt:message key="eIP.BookingDetails.label" bundle="${ip_labels}"/><%
}
else
{
	%><fmt:message key="eIP.ConfirmCancelReviseBooking.label" bundle="${ip_labels}"/><%
}
%>
</title>
</head>
<iframe name='amend_booking' id='amend_booking' src='../jsp/AmendBooking.jsp?<%=request.getQueryString()%>' frameborder=0  noresize style='height:90vh;width:99vw'></iframe><iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize  style='height:10vh;width:100vw'></iframe>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

