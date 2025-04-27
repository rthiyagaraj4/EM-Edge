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
	<iframe name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/LoanLinen/jsp/LoanLinenTabsMain.jsp?vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" /></iframe><iframe name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMainWards.jsp" /></iframe>
	
</html>

