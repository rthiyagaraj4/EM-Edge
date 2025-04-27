<!DOCTYPE html>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
       request.setCharacterEncoding("UTF-8");
	   request= new XSSRequestWrapper(request);
	   response.addHeader("X-XSS-Protection", "1; mode=block");
	   response.addHeader("X-Content-Type-Options", "nosniff");
	   
       String sStyle	=         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	   String nursing_unit_desc=request.getParameter("nursing_unit_desc");
	   String nursing_unit=request.getParameter("nursing_unit");

   %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<title><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></title>
</head>
	<iframe name='proc' id='proc'	src='../../eAE/jsp/AETreatmentAreaCriteria.jsp?nursing_unit_desc=<%=nursing_unit_desc%>&nursing_unit=<%=nursing_unit%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
		<iframe name='result_frame' id='result_frame'	src='../../eAE/jsp/AETreatmentAreaResult.jsp?nursing_unit_desc=<%=nursing_unit_desc%>&nursing_unit=<%=nursing_unit%>' frameborder=0 scrolling='no' noresize style='height:75vh;width:100vw'></iframe>
		<iframe name='proc1' id='proc1'	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
</html>


