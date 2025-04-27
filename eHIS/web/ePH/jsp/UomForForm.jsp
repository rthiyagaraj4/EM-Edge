<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
 <%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>

<!--	<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link> -->
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/UomForForm.js"></SCRIPT>
<!--	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
 <script language="Javascript" src="../../eCommon/js/messages.js"></script>
<script language="Javascript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</HEAD>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source%>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/MstCodeError.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:9vh;width:100vw"></iframe>
</HTML>

