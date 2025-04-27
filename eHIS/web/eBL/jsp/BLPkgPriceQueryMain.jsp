<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
-----------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K          created
-----------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page    contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<script language='javascript' src='../../eBL/js/BLPkgPriceQuery.js'></script>
<html>
<head>
<%
	  String sStyle	=
	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='BLPkgPriceQueryFrame' id='BLPkgPriceQueryFrame' 	src='../../eBL/jsp/BLPkgPriceQueryFrame.jsp'  frameborder=0 style='height:83vhvh;width:100vw'></iframe> <!-- ../../eCommon/html/blank.html -->
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

