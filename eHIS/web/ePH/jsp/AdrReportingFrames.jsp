<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>
<HTML>
	<HEAD>
<% 
		String locale			= (String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//end.
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String params = request.getQueryString()==null?"":request.getQueryString();
	String type = request.getParameter("type")==null?"":request.getParameter("type");
	if(type.equals("create")){
%>
	<iframe name="f_adrreport_criteria" id="f_adrreport_criteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/AdrReportingCriteria.jsp?<%=params%>" style="height:14vh;width:100vw"></iframe>
	<iframe name="f_adrreport_tabdetail" id="f_adrreport_tabdetail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:100vh;width:100vw"></iframe>
<%
	}
	else if(type.equals("query") || type.equals("report")){
%>
	<iframe name="f_adrreport_criteria" id="f_adrreport_criteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/AdrReportingQueryCriteria.jsp?<%=params%>"  style="height:30vh;width:100vw"></iframe>
	<iframe name="f_adrreport_tabdetail" id="f_adrreport_tabdetail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:70vh;width:100vw"></iframe>
<%
		}
%>
</HTML>

