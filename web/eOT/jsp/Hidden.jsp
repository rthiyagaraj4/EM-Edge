<!DOCTYPE html>
<!--
Developed by    : Bhavani Shankar.
Module/Function : Verify CheckList (called from Check-in, Check-Out From Ward function)
start date		: 02/04/2005
-->
<%-- JSP Page specific attributes start --%>
<%@page  contentType="text/html;charset=UTF-8" import="eOT.*,eOT.Common.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<%
//	session.setAttribute("function_id","OT_CHECKOUT_FROM_RECOVERY");
//	session.setAttribute("function_name","Hello World");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
</html>
<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:19vh;width:100vw"></iframe>

<script>
window.returnValue="";
window.close();
</script>

