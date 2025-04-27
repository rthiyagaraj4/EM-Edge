<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.EncounterSummary.label" bundle="${ca_labels}"/></title>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
         <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
</head>

<iframe name="ViewClinicalNoteResultTreeFrame" id="ViewClinicalNoteResultTreeFrame" style='height:0vh;width:30vw' frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/ViewClinicalNoteResultTree.jsp?<%=request.getQueryString()%>"></iframe>
<iframe name="ViewClinicalNoteNoteContentMainDetailFrame" id="ViewClinicalNoteNoteContentMainDetailFrame" style='height:100vh;width:70vw' frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></iframe>


</html>

