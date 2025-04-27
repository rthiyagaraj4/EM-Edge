<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<script language="Javascript" src="../../eOT/js/Schedule.js"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8"); 
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>

<%
	String param = request.getQueryString();
	String param0 = "";
	String param1 = "";
	String param2 = "";
	boolean singleChk = false;

	if(param.indexOf("~~") == -1)
	{
		if(param.indexOf("~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));
			param1 = param.substring(param.indexOf("~")+1, param.length());
		}
		else
			singleChk = true;
	}
	else if(param.indexOf("~~") != -1)
	{
		param0 = param.substring(0, param.indexOf("~"));
		param1 = param.substring(param.indexOf("~")+1, param.indexOf("~~"));
		param2 = param.substring(param.indexOf("~~")+2, param.length());
	}
%>

<%
	if(singleChk)
	{
%>
		<frameset>
			<frame name='dateFilter0' id='dateFilter0' src="../../eOT/jsp/ScheduleHdr.jsp?<%=param%>" frameborder=0 noresize>
		</frameset>
<%
	}
	else if(param2 == null || param2.trim().length() == 0)
	{
%>
		<frameset cols='50%,*'>
			<frame name='dateFilter0' id='dateFilter0' src="../../eOT/jsp/ScheduleHdr.jsp?<%=param0%>" frameborder=0 noresize>
			<frame name='dateFilter1' id='dateFilter1' src="../../eOT/jsp/ScheduleHdr.jsp?<%=param1%>" frameborder=0 noresize>
		</frameset>
<%
	}
	else
	{
%>
		<frameset cols='33%,*,*'>
			<frame name='dateFilter0' id='dateFilter0' src="../../eOT/jsp/ScheduleHdr.jsp?<%=param0%>" frameborder=0 noresize>
			<frame name='dateFilter1' id='dateFilter1' src="../../eOT/jsp/ScheduleHdr.jsp?<%=param1%>" frameborder=0 noresize>
			<frame name='dateFilter2' id='dateFilter2' src="../../eOT/jsp/ScheduleHdr.jsp?<%=param2%>" frameborder=0 noresize>
		</frameset>
<%
	}
%>

