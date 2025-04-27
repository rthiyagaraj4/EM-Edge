<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
</head>
<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	
	%>

<html>
<head>
<title>ClinicalEventGroup</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
</head>

<frameset id='eventgroup' rows='12%,4%,4%,34%,39%,7%'  >
	<frame name='commontoolbarFrame'	src="<%=source%>" frameborder=0 scrolling='no' noresize>
	<frame name='maintabs' 	src='../../eCA/jsp/ClinicalEventGroupMainTabs.jsp' frameborder=no scrolling='no'>
	<frame name='subtabs' 	src='../../eCommon/html/blank.html' frameborder=no scrolling='no'>
	<frame name="criteria" src = "../../eCommon/html/blank.html "
	 marginheight='0' marginwidth='0' scrolling=no  BORDERCOLOR='green' frameborder=no noresize>
    <frameset name='res' id='res' cols="50%,50%" border="0" framespacing=2 onunLoad="<%=EventBean.clearAll()%>">
	     <frame name="result" src = "../../eCommon/html/blank.html" marginheight='0' marginwidth='0'  frameborder=no  scrolling=no noresize>
	     <frame name="add" src = "../../eCommon/html/blank.html" marginheight='0' marginwidth='0'  frameborder=no  scrolling=no noresize >
    </frameset> 
    <frame name='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no'>
</frameset>
</html>
