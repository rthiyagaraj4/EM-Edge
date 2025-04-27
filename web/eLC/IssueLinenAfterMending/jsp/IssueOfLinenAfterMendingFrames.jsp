<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String functionId=request.getParameter("vo.functionId");
String moduleId=request.getParameter("vo.moduleId");
%>
	<iframe name="issueOfMendingCriteria" id="issueOfMendingCriteria" noresize="noresize" src=" <%=request.getContextPath()%>/IssueLinenAfterMendingAction.do?method=4&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" / style="height:25%;width:100vw"></iframe><iframe name="issueOfMendingResult" id="issueOfMendingResult" noresize="noresize" / style="height:100vh;width:100vw"></iframe>
	<frame name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMain.jsp" />
	</frameset>
</html>

