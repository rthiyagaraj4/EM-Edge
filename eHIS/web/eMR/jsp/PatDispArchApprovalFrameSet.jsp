<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); 
	String function_id	= checkForNull(request.getParameter("function_id"),"");
%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<iframe name='criteriaFrame' id='criteriaFrame' 	src='../../eMR/jsp/PatDispArchApprovalCriteria.jsp?function_id=<%=function_id%>' frameborder=0 style='height:15%;width:100vw'></iframe><iframe name='resultsFrame' id='resultsFrame' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:100vh;width:100vw'></iframe>
</head>
<body onKeyDown = 'lockKey()'>
</body>
</html>
<%!	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

