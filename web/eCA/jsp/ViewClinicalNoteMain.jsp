<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
26/8/2013	IN042640		Karthi L	Alingment problem 
---------------------------------------------------------------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>ViewClinicalNote</title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String accession_number = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");	
	String rows = "27%,70%";

	if(accession_number.equals(""))
		rows = "30%,70%"; // modified 27% to 30% for IN042640 
	else
		rows = "0%,70%";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<!-- Modified by kishore kumar N on 15/12/2008 for CRF 0387 , altered frameset size -->
<frameset name='ViewClinical' id='ViewClinical' rows='<%=rows%>' framespacing='0' frameborder='0'>
<!-- ends here -->
	<frame name="ViewClinicalNoteCriteriaFrame"   noresize scrolling='no' src="../../eCA/jsp/ViewClinicalNoteCriteria.jsp?<%=request.getQueryString()%>"></frame>
	<frameset  name="ViewClinicalNoteResult" id="ViewClinicalNoteResult" cols='200px,77%' framespacing='0' frameborder='0'>
		<frame name="ViewClinicalNoteResultTreeFrame"   noresize src="../../eCommon/html/blank.html">
	</frame>

	<frame name="ViewClinicalNoteNoteContentMainDetailFrame"   noresize src="../../eCommon/html/blank.html">
</frame>

</frameset>

</frameset>

</html>
