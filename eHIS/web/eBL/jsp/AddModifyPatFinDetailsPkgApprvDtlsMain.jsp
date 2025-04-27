<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.net.*,java.lang.*" contentType="text/html;charset=UTF-8"  %>
<html>
<head>
<title> <%= request.getParameter("title")%></title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String rows="70%,20%,10%";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<!--<iframe SRC="../../eBL/jsp/AddModifyPatFinDetailsPkgApprvDtls.jsp?<%=request.getQueryString()%>" frameborder=0 name='PkgDtlsFrame' scrolling='auto' noresize style='height:100%;width:100vw'></iframe>
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='PkgDiscDtlsFrame' id='PkgDiscDtlsFrame' scrolling='auto' noresize style='height:0%;width:100vw'></iframe>
		<iframe SRC="../../eBL/jsp/AddModifyPatFinDetailsPkgDiscBtn.jsp" frameborder=0 name='PkgDiscBtnFrame' id='PkgDiscBtnFrame' scrolling='auto' noresize style='height:0%;width:100vw'></iframe>

</head>

</html>

