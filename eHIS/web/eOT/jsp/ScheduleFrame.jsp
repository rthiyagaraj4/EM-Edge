<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@ page import ="eCommon.XSSRequestWrapper,eCommon.Common.CommonBean" %><%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8"); 
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
%>

<%
	String chkSize = CommonBean.checkForNull(request.getParameter("chkSize"));
	if(chkSize != null && chkSize.trim().equals("1"))
	{
%>
		<iframe name='schdule_dtl' id='schdule_dtl' src="../../eOT/jsp/Schedule.jsp?<%=request.getQueryString()%>" noresize style='height:90vh;width:98vw'></iframe>
		
<%
	}
	else if(chkSize != null && chkSize.trim().equals("2"))
	{
		String param = request.getQueryString();
		String param0 = "";
		String param1 = "";
		if(param.indexOf("~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));
			param1 = param.substring(param.indexOf("~")+1, param.length());
		}
%>
<div style="display: grid; grid-template-columns: 1fr 1fr; height: 100vh;width:100vw;">
			<iframe name='result0' id='result0' src="../../eOT/jsp/Schedule.jsp?<%=param0%>" noresize style='height:100vh;width:50vw;display: inline-block;'></iframe>
			<iframe name='result1' id='result1' src="../../eOT/jsp/Schedule.jsp?<%=param1%>"  noresize style='height:100vh;width:50vw;display: inline-block;'></iframe>
			</div>
<%
	}
	else if(chkSize != null && chkSize.trim().equals("3"))
	{
		String param = request.getQueryString();
		String param0 = "";
		String param1 = "";
		String param2 = "";

		if(param.indexOf("~") != -1 && param.indexOf("~~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));

			param1 = param.substring(param.indexOf("~")+1, param.indexOf("~~"));

			param2 = param.substring(param.indexOf("~~")+2, param.length());
		}
%>
<div style="display: grid; grid-template-columns: 1fr 1fr; height: 100vh;width:100vw;">
		<iframe name='result0' id='result0' src="../../eOT/jsp/Schedule.jsp?<%=param0%>" frameborder=0 noresize style='height:94vh;width:32.5vw'></iframe>
		<iframe name='result1' id='result1' src="../../eOT/jsp/Schedule.jsp?<%=param1%>" frameborder=0 noresize style='height:94vh;width:32.5vw'></iframe>
		<iframe name='result2' id='result2' src="../../eOT/jsp/Schedule.jsp?<%=param2%>" frameborder=0 noresize style='height:94vh;width:32vw'></iframe>
		</div>
<%
	}
%>

