<!DOCTYPE html>
<!--

	Created By		:	Nanda Kumar R.
	Created Date	:	11/14/2002
	Module ID		:	AE
	Function Name	:	Patient Movement History

-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String encounter_id	=	request.getParameter("encounter_id");
if (encounter_id==null) encounter_id ="";
String patient_id   = request.getParameter("patient_id");
String facilityId 	= (String) session.getValue( "facility_id" ) ;
String p_called_from=	request.getParameter("called_from");
if (p_called_from==null) p_called_from ="";
String called_from_ca=	request.getParameter("CA");
if (called_from_ca==null) called_from_ca ="";
%>
<html>
<title><fmt:message key="eAE.MovementHistory.label" bundle="${ae_labels}"/></title>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    if (called_from_ca.equals("Y"))
	{
	%>
			<frameset rows='100%' framespacing='0'>
			<frame name='PatientMovementDetails' id='PatientMovementDetails' src='../../eAE/jsp/AEMovementHistoryDtl.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize>
    <%	
	}
	else if (!p_called_from.equals("") && !p_called_from.equals("Main"))
	{

%>
   <!--  <frameset rows='9%,81%,10%' framespacing='0'> -->
			<%if(!encounter_id.equals(""))
				{
				%>
				<frameset rows='9%,81%,10%' framespacing='0'>
				<frame name='PatientLineFrame' id='PatientLineFrame' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounter_id%>' frameborder=0 scrolling='no' noresize>
			 <%}else{%>
			    <frameset rows='0%,81%,10%' framespacing='0'>
				<frame name='PatientLineFrame' id='PatientLineFrame' src='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>&Facility_Id=<%=facilityId%>&EncounterId=<%=encounter_id%>' frameborder=0 scrolling='no' noresize>
			<%}%>
	<frame name='PatientMovementDetails' id='PatientMovementDetails' src='../../eAE/jsp/AEMovementHistoryDtl.jsp?<%=request.getQueryString()%>&called_from=<%=p_called_from%>' frameborder=0 scrolling='auto' noresize>
	<frame name='buttonFrame' id='buttonFrame' src='../../eAE/jsp/AEMovementHistoryButton.jsp?called_from_ca=<%=called_from_ca%>' frameborder=0 scrolling='auto' noresize>
<%
	}
	else  
	{
%>
	<frameset rows='100%' framespacing='0'>
	<frame name='PatientMovementDetails' id='PatientMovementDetails' src='../../eAE/jsp/AEMovementHistoryDtl.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize>
<%	}
%>
</frameset>
</html>

