<!DOCTYPE html>
<html>
<%
		String facilityId=(String)session.getAttribute("facility_id");	
		String functionId=request.getParameter("vo.functionId");
		String moduleId=request.getParameter("vo.moduleId");
%>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		String function_id = (String)request.getParameter("function_id");
	//	out.println("function_id="+function_id);
	%>
	<iframe name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/ReturnofLinentoLaundryAction.do?method=1&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" /></iframe><iframe name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMainWards.jsp" /></iframe>
	
</html>

