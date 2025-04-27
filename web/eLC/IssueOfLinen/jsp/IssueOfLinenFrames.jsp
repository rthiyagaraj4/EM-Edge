<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String function_id = (String)request.getParameter("vo.functionId");
		String moduleId = (String)request.getParameter("vo.moduleId");
%>
	<iframe name="issueOfLinenCriteria" id="issueOfLinenCriteria" noresize="noresize" src=" <%=request.getContextPath()%>/IssueOfLinenAction.do?method=4&vo.functionId=<%=function_id%>"  / style="height:34%;width:100vw"></iframe><iframe name="issueOfLinenResult" id="issueOfLinenResult" noresize="noresize" / style="height:100vh;width:100vw"></iframe>
	<frame name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMain.jsp" />
	</frameset>
</html>

