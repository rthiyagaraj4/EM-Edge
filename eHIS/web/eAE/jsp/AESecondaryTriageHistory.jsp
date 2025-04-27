<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "eCommon.XSSRequestWrapper"%>
<html>
<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eAE/js/AESecondaryTriageQuery.js'></script>
    <script language='javascript' src='../../eAE/js/AESecondaryTriageHistory.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String function_id	= request.getParameter("function_id");
		String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='f_SecondaryTriageCriteria' id='f_SecondaryTriageCriteria' src='../../eAE/jsp/AEQuerySecondaryTriageHistory.jsp?function_id=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	<iframe name='f_SecondaryTriageResult' id='f_SecondaryTriageResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:69vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html> 

