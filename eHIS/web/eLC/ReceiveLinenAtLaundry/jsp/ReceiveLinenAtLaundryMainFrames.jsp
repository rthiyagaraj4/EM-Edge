<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String functionId=(String)request.getParameter("functionId");
String moduleId=(String)request.getParameter("moduleId");

%>
	<iframe name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/ReceiveLinenAtLaundry/jsp/ReceiveLinenAtLaundryCud.jsp?&functionId='<%=functionId%>'&moduleId='<%=moduleId%>'" /></iframe><iframe name="RHSFrame" id="RHSFrame" noresize="noresize" src="<%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMain.jsp" /></iframe>
	
</html>

