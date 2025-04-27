<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <!--ChargeType.jsp -->

<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<script language='javascript' src='../../eOR/js/OROrderEntryRepGrp.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->

<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>

<%	
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;


%>

<frameset rows='10%,27%,*,12%' name='OrderEntryReport' id='OrderEntryReport'>
	<frame name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize>
	<frame name='OROrderentryreportGrpdtl' id='OROrderentryreportGrpdtl' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" >
	<frame name="paneldetails1" id="paneldetails1" src = '../../eCommon/html/blank.html'
	 marginheight='0' marginwidth='0' scrolling=auto  BORDERCOLOR='green' frameborder=no noresize>
	 
	<frame name="messageFrame" id="messageFrame"	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling=auto>
</frameset>

</html>

