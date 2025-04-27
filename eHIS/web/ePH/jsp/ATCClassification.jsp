<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<html>
<head>
	<script language="JavaScript" src="../../ePH/js/ATCClassification.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%	String called_from	=	request.getParameter("called_from");
%>
<!-- <body onLoad="callATC('<%=called_from%>')"> -->
<body onMouseDown="" onKeyDown="lockKey()" onLoad="callATC('<%=called_from%>')">
</body>
</html>

