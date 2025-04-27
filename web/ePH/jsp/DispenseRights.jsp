<!DOCTYPE html>
 <%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseRights.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/UserProfile.js"></SCRIPT> -->
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/jsp/MstCodeError.jsp" style="height:9vh;width:100vw"></iframe>    
</HTML>

