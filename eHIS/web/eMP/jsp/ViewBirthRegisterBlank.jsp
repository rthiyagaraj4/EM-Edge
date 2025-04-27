<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String func_idpassed = request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");

	//String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<Script language='javascript' src='../../eMP/js/ViewBirthDetails.js'></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class="CONTENT" onLoad='aa()' onKeyDown = 'lockKey()'>
<form>
<input type='hidden' name='func_idpassed' id='func_idpassed' value="<%=func_idpassed%>"></input>
<input type='hidden' name='function_id' id='function_id' value="<%=func_idpassed%>"></input>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

