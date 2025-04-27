<!DOCTYPE html>
 <html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/CancelAuthorization.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	String params = request.getQueryString();
%>
<iframe name="CancelAuthQueryHeaderFrame" id="CancelAuthQueryHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/CancelAuthorizationQueryCriteria.jsp?<%=params%>" style="height:23vh;width:100vw"></iframe><iframe name="CancelAuthQueryResultFrame" id="CancelAuthQueryResultFrame" frameborder="0" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:76vh;width:100vw"></iframe>
</html>

