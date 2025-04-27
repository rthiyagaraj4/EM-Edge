<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<title>Sub Section Main</title>
<script language='javascript' src='../js/GlobalArray.js'></script>
<script language='javascript' src='../js/MultiRecSubSection.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
	<iframe name="HeaderFrame" id="HeaderFrame" src="../../eCA/jsp/MultiRecSubSectionHdr.jsp" frameborder="0" scrolling ="no" noresize style="height:8vh;width:99vw"></iframe>
	<iframe name="DetailsFrame" id="DetailsFrame" src="../../eCA/jsp/MultiRecSubSectionFrameSet.jsp" frameborder="0" scrolling ="no" noresize style="height:86vh;width:99vw"></iframe>

<html>

