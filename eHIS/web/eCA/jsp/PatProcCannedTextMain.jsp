<!DOCTYPE html>
<%@page  language="java" contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.CannedText.label" bundle="${ca_labels}"/></title>
<% 	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<iframe name="RecClinicalNotesCTFrame" id="RecClinicalNotesCTFrame" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/PatProcCannedText.jsp?Encounter_Id=<%=request.getParameter("Encounter_Id")%>" style="height:90vh;width:100vw"></iframe>
<iframe name="RecClinicalNotesCTSelectFrame" id="RecClinicalNotesCTSelectFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/PatProcCannedTextSelect.jsp" style="height:8vh;width:100vw"></iframe>

</html>

