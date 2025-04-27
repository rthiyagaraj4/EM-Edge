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


	<iframe name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/jsp/ReceiveLoanedLinenFrames.jsp?&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" /></iframe><iframe name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMainWards.jsp" /></iframe>
	
</html>

