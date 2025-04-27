<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
<%
String functionId=request.getParameter("vo.functionId");
String moduleId=request.getParameter("vo.moduleId");
%>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="requestForLinenCriteria" id="requestForLinenCriteria" src=" <%=request.getContextPath()%>/SendLinenForMendingAction.do?method=4&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" / style="height:35%;width:100vw"></iframe><iframe name="requestForMendingResult" id="requestForMendingResult"/ style="height:100vh;width:100vw"></iframe>
	
</html>

