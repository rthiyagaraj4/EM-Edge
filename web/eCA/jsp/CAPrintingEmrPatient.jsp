<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
07/05/2019		ML-MMOH-CRF-1064	Kamalakannan G		07/05/2019		Ramesh Goli		IN066304
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<%
	
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
%>
	<iframe name='CAPrintingEmrPatientCriteria' id='CAPrintingEmrPatientCriteria' src='../../eCA/jsp/CAPrintingEmrPatientCriteria.jsp?<%=request.getQueryString()%>&callfrom=callfrommanage' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='CAPrintingEmrPatientResult' id='CAPrintingEmrPatientResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:60vh;width:100vw'></iframe>
	<iframe name='CAPrintingEmrPatientSubRes' id='CAPrintingEmrPatientSubRes' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:25vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>
</html>

