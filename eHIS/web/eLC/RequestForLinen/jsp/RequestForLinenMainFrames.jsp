<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String functionId=request.getParameter("functionId");
String moduleId=request.getParameter("moduleId");

%>
	<iframe name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/RequestForLinen/jsp/RequestForLinenTabsMain.jsp?moduleId=<%=moduleId%>&vo.functionId=<%=functionId%>" /></iframe><iframe border='0' name="RHSFrame" id="RHSFrame" noresize="noresize"  src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMainWards.jsp"  /></iframe>
	
</html>

