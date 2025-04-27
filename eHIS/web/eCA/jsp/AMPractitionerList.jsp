<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCA/js/LocationforPract.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="callPractSearch()">
<form name="callPractLookupFromCA" id="callPractLookupFromCA"  method="post" >
<!-- <br><br> -->
</form>
</body>
</html>


