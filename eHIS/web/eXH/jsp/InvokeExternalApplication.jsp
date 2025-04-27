<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>External Application</title>
<script type="text/javascript" SRC="../../eXH/js/ExternalApplication.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onLoad="alert()">
<FORM ID="invokeExternalApp" name="invokeExternalApp" id="invokeExternalApp" METHOD="post">
<input type="text">
<INPUT TYPE="hidden" ID="queryString" VALUE="<%= request.getQueryString() %>">
</FORM>
</body>
</html>

