<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name/ID:	Check-In Loder / CHECK_IN_LODGER
/// Developer		:	SRIDHAR R
/// Created On		:	30 JULY 2004
/// This File is called on the click of Encounter ID in Result Page in InpatientLookupQueryResult.jsp ..
%>

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
	<script> 
		function reset()
		{
			frames[1].document.forms[0].reset();
			frames[1].document.forms[0].search.disabled = false;
			frames[2].location.href = '../../eCommon/html/blank.html';
		} 
	</script>  
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String call_function	= checkForNull(request.getParameter("call_function"));
	String mode				= checkForNull(request.getParameter("mode"));
	String Category			= checkForNull(request.getParameter("Category"));
	String patientId		= checkForNull(request.getParameter("patientId"));
	String EncounterId		= checkForNull(request.getParameter("EncounterId"));
	String Practitioner_Id	= checkForNull(request.getParameter("Practitioner_Id"));
	String Sex				= checkForNull(request.getParameter("Sex"));

	Connection	con = null;
	try
	{
		con		= ConnectionManager.getConnection(request);
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		String patientStatus	= patdata.CheckStatus(con,patientId);

		String openWindow ="YES";
		if(patientStatus.equals("DECEASED")) 
		{
			openWindow = "NO";
			out.println("<script>alert(getMessage('PAT_DECEASED_NOT_ALLOWED','MP'))</script>"); 
			out.println("<script>parent.window.close();</script>");
		}
		else if(patientStatus.equals("SUSPENDED")) 
		{
			openWindow = "NO";
			out.println("<script>alert(getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'))</script>");
			out.println("<script>parent.window.close();</script>");
		}
		else if(patientStatus.equals("INACTIVE")) 
		{
			openWindow = "NO";
			out.println("<script>alert(getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'))</script>");
			out.println("<script>parent.window.close();</script>");
		}
		else
		{
			openWindow = "YES";
		}	%>

		<title>&nbsp;<fmt:message key="eIP.CheckInlodger.label" bundle="${ip_labels}"/></title>
		<iframe name='LodgerFrame' id='LodgerFrame' 	src='../jsp/CheckinLodgerDetail.jsp?call_function=<%=call_function%>&openWindow=<%=openWindow%>&mode=<%=mode%>&Category=<%=Category%>&patientId=<%=patientId%>&EncounterId=<%=EncounterId%>&Practitioner_Id=<%=Practitioner_Id%>&Sex=<%=Sex%>&oper_stn_id=<%=oper_stn_id%>' frameborder=0 scrolling='no' noresize style='height:92vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
	<%	
	}catch(Exception e)
	{
		out.println("Exception in patData : "+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>


<%!
	// By Sridhar R  added on 3/15/2005 ... to handle NullPointerException...
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

