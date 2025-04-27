<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page contentType="text/html;charset=UTF-8"  %>

  <html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border='0' cellspacing='0' cellpadding='0' width='100%' >
<tr ><td class=white></td></tr>
<tr><td class=white align='right'><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='parent.window.close()'></td></tr>	
</table>
</body>
</html>											   

