<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>

<iframe SRC="../../eCA/jsp/ReviewNotes.jsp?<%=request.getQueryString()%>" NAME="workAreaFrame" style="height:100vh;width:100vw"></iframe><iframe SRC="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame" style="height:6%;width:100vw"></iframe>
</HTML>

