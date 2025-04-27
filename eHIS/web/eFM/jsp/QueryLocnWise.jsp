<!DOCTYPE html>
<%@ page import=" java.sql.*,java.text.*,java.util.*,java.net.*,webbeans.eCommon.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
	<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language="javascript" src="../../eFM/js/QueryDocTypeWise.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;
%>
	<iframe name="commontoolbar" id="commontoolbar" src="<%=source%>" frameborder='0' scrolling="no" noresize style='height:8%;width:100vw'></iframe>
		<iframe name="QueryDocTypeCriteria" id="QueryDocTypeCriteria" src="../../eFM/jsp/QueryLocnWiseCriteria.jsp"  frameborder='0' scrolling='auto' noresize style='height:19%;width:100vw'></iframe>
		<iframe name="QueryDocTypeResult" id="QueryDocTypeResult" src="../../eCommon/html/blank.html " frameborder='0' scrolling="auto" noresize style='height:100vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder='0' scrolling="no" noresize style='height:9%;width:100vw'></iframe>
	
</HTML>

