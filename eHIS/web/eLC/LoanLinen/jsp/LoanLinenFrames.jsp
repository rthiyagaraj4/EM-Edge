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

	<iframe name="loanLinenCriteria" id="loanLinenCriteria" src="<%=request.getContextPath()%>/LoanLinenAction.do?method=4&vo.functionId=<%=functionId%>" / style="height:65%;width:100vw"></iframe><iframe name="loanLinenResult" id="loanLinenResult"/ style="height:100vh;width:100vw"></iframe>
</html>

