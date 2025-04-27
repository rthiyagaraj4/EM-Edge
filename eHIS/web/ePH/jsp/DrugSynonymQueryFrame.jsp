<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu 
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/DrugSynonym.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String url = "../../ePH/jsp/DrugSynonymQueryCriteria.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
	<iframe name="drugSynonymQueryCriteria" id="drugSynonymQueryCriteria" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:15%;width:100vw"></iframe><iframe name="drugSynonymQueryResult" id="drugSynonymQueryResult" frameborder="0" noresize scrolling="auto" src="../../eCommon/html/blank.html" style="height:100vh;width:100vw"></iframe>
</html>

