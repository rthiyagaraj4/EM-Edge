<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/ecis.css'></link>
	</head>
	<%
		String patID=request.getParameter("Patient_Id");
		String function_id	= request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String FacilityId	= request.getParameter("FacilityId")==null?"":request.getParameter("FacilityId");


	%>
	<title><fmt:message key="Common.FileDetails.label" bundle="${common_labels}"/></title>
	
		<iframe name='patLine' id='patLine' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patID%>&FacilityId=<%=FacilityId %>' frameborder='no' scrolling='no' style='height:9vh;width:90vw'> </iframe>
		<iframe name='vwpatfile' id='vwpatfile' src='../../eMR/jsp/vwPatFileDetailsquery.jsp?function_id=PAT_FILE_DTL&Patient_Id=<%=patID%>&FacilityId=<%=FacilityId %>' frameborder='no' scrolling='auto' style='height:80vh;width:95vw'>  </iframe>
</html>

