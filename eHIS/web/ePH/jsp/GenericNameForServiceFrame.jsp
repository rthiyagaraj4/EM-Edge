<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!-- 
Developed by	: Surendra Reddy
Module/Function : Generic Name for Service (Master)
-->
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
         request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/GenericNameForService.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="genericnameforservice_tab" id="genericnameforservice_tab" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/GenericNameForServiceTab.jsp" style="height:5vh;width:100vw"></iframe>
<iframe name="genericnameforservice_header" id="genericnameforservice_header" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/GenericNameForServiceHeader.jsp?from_source=bygeneric" style="height:5vh;width:100vw"></iframe>
<iframe name="genericnameforservice_button" id="genericnameforservice_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:9vh;width:100vw"></iframe>
<iframe name="genericnameforservice_label" id="genericnameforservice_label" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:13vh;width:100vw"></iframe>
<iframe name="genericnameforservice_dtls" id="genericnameforservice_dtls" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:87vh;width:100vw"></iframe>

</html>


