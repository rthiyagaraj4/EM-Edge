<!DOCTYPE html>
<html>
<%
String functionId=request.getParameter("vo.functionId");
String moduleId=request.getParameter("vo.moduleId");
%>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="receiveLoanedLinenCriteria" id="receiveLoanedLinenCriteria" src=" <%=request.getContextPath()%>/ReceiveLoanedLinenAction.do?method=1&vo.functionId=<%=functionId%>" scrolling="auto"/ style="height:60%;width:100vw"></iframe><iframe name="receiveLoanedLinenResult" id="receiveLoanedLinenResult"/ style="height:100vh;width:100vw"></iframe>
</html>

