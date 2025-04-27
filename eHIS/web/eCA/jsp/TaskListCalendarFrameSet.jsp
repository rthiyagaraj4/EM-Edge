<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<title><fmt:message key="Common.Calendar.label" bundle="${common_labels}"/></title>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<frameset rows='20%,*,0%' id ='TaskListFrameSet' frameborder=1 >
<frame name="TaskListCalendarFrameTop" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/TaskListCalenderTop.jsp?<%=request.getQueryString()%>"></frame>
<frame name="TaskListCalendarFrameBottom" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/blank.jsp"></frame>
<frame name="blankFrame" frameborder="0" scrolling="yes" noresize src="../../eCA/jsp/blank.jsp"></frame>
</frameset>
