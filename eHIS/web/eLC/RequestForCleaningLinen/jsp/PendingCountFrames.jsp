<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->

<%
	String userFlag = (String) request.getParameter("userFlag");
	String functionId = (String) request.getParameter("vo.functionId");
	String moduleId = (String) request.getParameter("vo.moduleId");

%>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="pendingCountCriteria" id="pendingCountCriteria" src=" <%=request.getContextPath()%>/RequestForCleaningLinenAction.do?method=4&vo.checkView=pendingCount&userFlag=<%=userFlag%>&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" / style="height:35%;width:100vw"></iframe><iframe name="pendingCountResult" id="pendingCountResult"/ style="height:100vh;width:100vw"></iframe>
</html>

