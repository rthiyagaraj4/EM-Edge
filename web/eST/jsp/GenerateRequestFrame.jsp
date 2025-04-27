<!DOCTYPE html>
 <%@ page import ="eST.GenerateRequestBean, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/GenerateRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



    <script>
        function_id				=		"<%= request.getParameter("function_id")%>";
		menu_id					=		"<%= request.getParameter( "menu_id" ) %>"
		module_id				=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<% 
	String params = request.getQueryString();
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

%>
 <!--
 * @Name - Priya
 * @Date - 13/07/2010
 * @Inc# - 22634
 * @Desc - To freeze the header row & to adjust the column width, the header row is moved under detail page 
*/-->

	<iframe name="GenerateRequestHeaderFrame" id="GenerateRequestHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/GenerateRequestHeader.jsp?mode=1&<%=params%>" style="height:40vh;width:100vw"></iframe>
	<!--<frame name="GenerateRequestHtml" id="GenerateRequestHtml" src="../../eST/jsp/GenerateRequestHtml.jsp?<%=params%>" frameborder="0" noresize scrolling="no">-->
	<iframe name="GenerateRequestDetailFrame" id="GenerateRequestDetailFrame" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="Auto" style="height:60vh;width:85vw"></iframe>
</html>

