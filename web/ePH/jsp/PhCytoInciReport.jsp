<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<%
		request.setCharacterEncoding("UTF-8");
		//String locale			= (String)session.getAttribute("LOCALE");
		
String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
String params		= request.getQueryString() ;
String source		= url + params ;	

%>
<head>
<title></title>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>

<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link> -->

<!--     <link rel="stylesheet" type="text/css" ref="../../eCommon/html/IeStyle.css"></link> -->	
	<script language="JavaScript" src="../../ePH/js/PhCytoInciReport.js"></script> 
	  <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize border='2' 
	SRC="../../ePH/jsp/PhCytoInciReportFrames.jsp?"  style='height:85vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:6vh;width:100vw"></iframe>

</html>

