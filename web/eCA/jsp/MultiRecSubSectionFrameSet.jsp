<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<script language='javascript' src='../js/MultiRecSubSection.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
		<iframe name="DetailsFrameTop" id="DetailsFrameTop"src="../../eCommon/html/blank.html" frameborder=0  noresize style="height:30vh;width:98vw"></iframe>
		<iframe name="DetailsFrameMiddle" id="DetailsFrameMiddle" src="../../eCommon/html/blank.html" frameborder=0  noresize scrolling="no" style="height:15vh;width:98vw"></iframe>
		<iframe name="DetailsFrameBottom" id="DetailsFrameBottom" src="../../eCommon/html/blank.html" frameborder=0  noresize style="height:50vh;width:98vw"></iframe>

<html>

