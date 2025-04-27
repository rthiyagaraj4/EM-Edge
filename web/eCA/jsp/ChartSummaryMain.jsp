<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<TITLE></TITLE>

<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<iframe SRC="../../eCA/jsp/GeneticMarkersDisplay.jsp?<%=request.getQueryString()%>" NAME="frmTest" scrolling='no' MARGINWIDTH='0px' MARGINHEIGHT='0px' frameborder='0' noresize style='height:7vh;width:100vw'></iframe>
<iframe SRC="../../eCA/jsp/ChartSummaryPatient.jsp?<%=request.getQueryString()%>" NAME="frmTest" scrolling='no' MARGINWIDTH='0px' MARGINHEIGHT='0px' frameborder='0' noresize style='height:100vh;width:100vw'></iframe>

</HTML>

