<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head> 
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086		
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eST/js/UserAccessForStore.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>";
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params =request.getQueryString() ;
	String source = url + params ;
%>
<iframe name = "commontoolbarFrame" frameborder = "0" scrolling = "no" noresize src="<%= source %>" style='height:8vh;width:100vw'></iframe>
<iframe name = "f_query_add_mod" frameborder = "0" scrolling = "auto" noresize src="../../eCommon/html/blank.html" style='height:82vh;width:100vw' ></iframe>
<iframe name = "messageFrame" src="../../eCommon/jsp/error.jsp" frameborder = "0" noresize scrolling = "auto"  style='height:10vh;width:100vw' ></iframe>
</html>




