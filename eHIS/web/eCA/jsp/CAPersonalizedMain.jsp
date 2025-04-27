<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
		<script language="javascript" src="../js/CAPersonalizedHomePage.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<% 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
			String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = request.getQueryString();
			String source = url + params ;
%>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame"	src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name="frame3" id="frame3" SRC="../../eCommon/html/blank.html" frameborder=0 style="height:80vh;width:100vw"></iframe><iframe SRC="../../eCommon/html/blank.html" name="resultFrame" id="resultFrame" frameborder = 0 noresize  style="height:0vh;width:100vw"></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</HTML>

