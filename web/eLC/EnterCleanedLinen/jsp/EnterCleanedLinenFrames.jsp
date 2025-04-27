<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
<%
		String function_id = (String)request.getParameter("vo.functionId");
		String moduleId = (String)request.getParameter("vo.moduleId");
%>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="EnterCleanedLinenCud" id="EnterCleanedLinenCud" noresize="noresize" src=" <%=request.getContextPath()%>/EnterCleanedLinenAction.do?method=1&vo.functionId=<%=function_id%>" /></iframe><iframe name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMain.jsp" /></iframe>
	
</html>

