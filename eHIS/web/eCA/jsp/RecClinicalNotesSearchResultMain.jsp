<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title>Recording Clinical Notes Search</title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="RecClinicalNotesSrchCriteriaFrame" id="RecClinicalNotesSrchCriteriaFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSearchCriteria.jsp?<%=request.getQueryString()%>" style="height:30vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesSrchResultFrame" id="RecClinicalNotesSrchResultFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:65vh;width:100vw"></iframe>


</html>

