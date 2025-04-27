<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<%
	String params	= request.getQueryString();
%>
<iframe name="f_header" id="f_header" scrolling="no" noresize src="../../eOT/jsp/ExamsCheckListResultsHeader.jsp?<%=params%>" style="height:3vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:88vh;width:100vw"></iframe>
<iframe name="f_confirm" id="f_confirm" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:9vh;width:100vw"></iframe>

