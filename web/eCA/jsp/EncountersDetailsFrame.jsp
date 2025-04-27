<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe src="../../eCommon/html/blank.html" name="DisplayResult" id="DisplayResult"  scrolling="auto" frameborder="1" style="height:85vh;width:98vw; border: none;"></iframe>
<iframe src="../../eCA/jsp/EncountersControls.jsp?<%=request.getQueryString()%>" name="encountercontrol" id="encountercontrol" scrolling="no" frameborder="0" style="height:8vh;width:98vw; border: none;"></iframe>
</html>

