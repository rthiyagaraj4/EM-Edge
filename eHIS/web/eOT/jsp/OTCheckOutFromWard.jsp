<!DOCTYPE html>
<!--
Developed by    : Bhavani Shankar.
Module/Function : Check Out From Ward
start date		: 06/03/2005
-->
<%-- JSP Page specific attributes start --%>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%	%>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/WardChkOut.js"></script>
</head>
<%
	 request.setCharacterEncoding("UTF-8");
	 //Added Against MMS Vulnerability Issue - Starts
     request= new XSSRequestWrapper(request);
     response.addHeader("X-XSS-Protection", "1; mode=block");
     response.addHeader("X-Content-Type-Options", "nosniff");
	 //Added Against MMS Vulnerability Issue - Ends 

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String called_from = checkForNull(request.getParameter("called_from"),"OT");
	/*called_from=called_from==null?"OT":called_from;
	called_from=called_from.equalsIgnoreCase("null")?"OT":called_from;
	called_from=called_from.equals("")?"OT":called_from;*/
	
	if(called_from.equals("OT"))
		params=params+"&called_from=OT";
	String source = url + params ;
%>
<script>
</script>
<%
	if(called_from.equals("OT")){
%>
	<frameset rows="42,180,*,30">
	<frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>">
<%
	}else{
%>
	<frameset rows="180,*,30">
<%
	}
%>

	<frame name="f_search" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/WardChkOutSearch.jsp?<%=params%>"> 
	<frame name="f_query_add_mod" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
	<frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>
<form name="WardChkOutForm">
	<input type='hidden' name='params' value='<%=params%>'>
</form>
</html>
