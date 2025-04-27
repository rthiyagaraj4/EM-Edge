<!DOCTYPE html>
<!--
	Created Date	:	11/18/2002
	Module ID		:	AE
	Function Name	:	Start Consultation
-->
<%@page  contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
   	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String encounter_id	=	request.getParameter("encounter_id");
	String facilityId 	= (String) session.getValue( "facility_id" ) ;
%>
<html>
<head>
	  <script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<iframe name='PatientLineFrame' id='PatientLineFrame' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounter_id%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='ConsultationDetailsFrame' id='ConsultationDetailsFrame' src='../../eAE/jsp/AEMPStartConsultation.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:94vh;width:100vw'></iframe>
	<iframe name='ConsultationmessageFrame' id='ConsultationmessageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</html>

