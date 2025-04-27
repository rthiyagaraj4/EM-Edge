<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
<%
			String facilityId=(String)request.getAttribute("facility_id");
			if(facilityId==null)facilityId="LD";
			String functionId = (String) request.getParameter("vo.functionId");
			String moduleId = (String) request.getParameter("vo.moduleId");
			String loggedInUser = (String) session.getAttribute("login_user");
			String userFlag = (String) request.getParameter("userFlag");
			String flag = (String) request.getParameter("flag");
			session.setAttribute("flag",flag);

	%>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="requestForCleaningLinenCriteria" id="requestForCleaningLinenCriteria" src=" <%=request.getContextPath()%>/RequestForCleaningLinenAction.do?method=4&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>&userFlag=<%=userFlag%>" / style="height:35%;width:100vw"></iframe><iframe name="requestForCleaningLinenResult" id="requestForCleaningLinenResult"/ style="height:100vh;width:100vw"></iframe>
</html>

