<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<% //@page contentType="text/html;charset=" import="java.util.*, eOT.*,eOT.Common.* , eCommon.Common.*" %>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	<script language="javascript" src="../../eOT/js/Booking.js"></script>
	<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function callload()
		{
			var cmf=parent.frames[0].document.forms[0];
			var calledFrom = document.forms[0].calledFrom.value; //IN052054
			if(calledFrom != 'CA') //IN052054
			{
			  if(cmf.apply.disabled==false)
				  cmf.apply.disabled=true;
			}
		}
		</script>
</head>
<%
	String params = request.getQueryString() ;
	//IN052054 start
	String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
	if(calledFrom != null && calledFrom.equalsIgnoreCase("CA"))
	{
%>
	<iframe name="f_tab_frames" id="f_tab_frames"  scrolling="no" noresize src="../../eOT/jsp/SlateTabFrames.jsp?<%=params%>" style="height:94vh;width:100vw" frameborder='0'></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="auto" style="height:6vh;width:100vw" frameborder='0'></iframe>
<%
	}
	else
	{
	//IN052054 end
%>
<iframe name="f_slate_tab_frame" id="f_slate_tab_frame"  scrolling="no" noresize src="../../eOT/jsp/SlateTab.jsp?<%=params%>" style="height:5vh;width:100vw" frameborder='0'></iframe>
<iframe name="f_tab_frames" id="f_tab_frames" scrolling="no" noresize src="../../eOT/jsp/SlateTabFrames.jsp?<%=params%>" style="height:89vh;width:100vw" frameborder='0'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="auto" style="height:6vh;width:100vw" frameborder='0'></iframe>
<%
	}
	//IN052054
%>

<body onload='callload();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OTSlateForm" id="OTSlateForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
	<input type="hidden" name="calledFrom" id="calledFrom" value="<%=calledFrom%>">  <%-- IN052054 --%>

</form>
</body>
</html>

