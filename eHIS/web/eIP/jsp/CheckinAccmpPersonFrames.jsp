<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name/ID:	Check-In Loder / CHECK_IN_ACCMP_PERSON
/// Developer		:	SRIDHAR R
/// Created On		:	31 JULY 2004
/// This File is called on the click of Encounter ID in Result Page from InpatientLookupQueryResult.jsp...
%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
 %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    
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
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String call_function	= checkForNull(request.getParameter("call_function"));
	String mode				= checkForNull(request.getParameter("mode"));
	String Category			= checkForNull(request.getParameter("Category"));
	String patientId		= checkForNull(request.getParameter("patientId"));
	String EncounterId		= checkForNull(request.getParameter("EncounterId"));
	String Practitioner_Id	= checkForNull(request.getParameter("Practitioner_Id"));
	String Sex				= checkForNull(request.getParameter("Sex"));
	String Lodger_Max_RefNo	= checkForNull(request.getParameter("Lodger_Max_RefNo"));
	String Lodger_Next_RefNo= checkForNull(request.getParameter("Lodger_Next_RefNo"));
	String Lodger_Period	= checkForNull(request.getParameter("Lodger_Period"));
	String Acc_Period		= checkForNull(request.getParameter("Acc_Period"));
	String Acc_Period_unit	= checkForNull(request.getParameter("Acc_Period_unit"));
	String IP_param_No_Acc_Persons_str	= checkForNull(request.getParameter("IP_param_No_Acc_Persons"));
	String location_code	= checkForNull(request.getParameter("location_code"));

%>
<title>&nbsp;<fmt:message key="eIP.CheckInAccompanyingPerson.label" bundle="${ip_labels}"/></title>
	<iframe name="PatientLine_frame" id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?EncounterId=<%=EncounterId%>&<%=request.getQueryString()%>" scrolling='no' noresize border='0' style='height:9vh;width:99vw'></iframe>
	<iframe name='AccPersonFrame' id='AccPersonFrame' 	src='../jsp/CheckinAccmpPersonDetail.jsp?call_function=<%=call_function%>&mode=<%=mode%>&Category=<%=Category%>&patientId=<%=patientId%>&EncounterId=<%=EncounterId%>&Practitioner_Id=<%=Practitioner_Id%>&Sex=<%=Sex%>&oper_stn_id=<%=oper_stn_id%>&Lodger_Max_RefNo=<%=Lodger_Max_RefNo%>&Lodger_Next_RefNo=<%=Lodger_Next_RefNo%>&Lodger_Period=<%=Lodger_Period%>&Acc_Period=<%=Acc_Period%>&Acc_Period_unit=<%=Acc_Period_unit%>&IP_param_No_Acc_Persons=<%=IP_param_No_Acc_Persons_str%>&location_code=<%=location_code%>' frameborder=0 scrolling='no' noresize style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:4vh;width:100vw'></iframe>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

