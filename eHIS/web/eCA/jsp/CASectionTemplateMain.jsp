<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%  
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<title><%=request.getParameter("title")%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="RecClinicalNotesTemplateFrame" id="RecClinicalNotesTemplateFrame" frameborder="NO" scrolling="auto" noresize src="../../eCA/jsp/CASectionTemplateView.jsp?<%=request.getQueryString()%>" style="height:83vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesTemplateTBFrame" id="RecClinicalNotesTemplateTBFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/CASectionTemplatePreviewView.jsp" style="height:6vh;width:100vw"></iframe>
	<iframe name="messageframe" id="messageframe" frameborder="no" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp" style="height:8vh;width:100vw"></iframe>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCommon/jsp/error.jsp" style="height:0vh;width:100vw"></iframe>


</html>

