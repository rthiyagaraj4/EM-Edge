<!--<!DOCTYPE html>-->
<%@ page contentType="text/html;charset=UTF-8" import=" java.text.*, java.util.*" %>
<html> 
<head>
<title> </title>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script language="JavaScript" src="../../eST/js/ManufacturingReceipts.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eST/js/StMessages.js"></script>
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
%>
	<iframe name='frameListHeader' id='frameListHeader'	src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:34%;width:100vw'></iframe>
		<iframe name='frameListDetail' id='frameListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:100vh;width:100vw'></iframe>
</html>

