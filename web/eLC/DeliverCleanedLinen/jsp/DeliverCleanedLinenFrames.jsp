<!DOCTYPE html>
<html>
<%
	String functionId=request.getParameter("functionId");
	String moduleId=request.getParameter("moduleId");
%>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
	<frameset cols="70%,*" border="4" border="2">
	<frameset rows="35%,*" border="0" >
		<frame name="deliverCleanedLinenCriteria" src=" <%=request.getContextPath()%>/DeliverCleanedLinenAction.do?method=4&vo.functionId=<%= functionId%>&vo.moduleId=<%=moduleId%>"/>
		<frame name="deliverCleanedLinenResult" noresize="noresize"/>
	</frameset>
	<frame name="RHSFrame" noresize="noresize" src="<%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMain.jsp" />
	</frameset>
</html>
