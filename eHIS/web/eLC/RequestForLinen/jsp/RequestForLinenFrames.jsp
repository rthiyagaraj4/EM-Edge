<!DOCTYPE html>
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="requestForLinenCriteria" id="requestForLinenCriteria" src=" <%=request.getContextPath()%>/RequestForLinenAction.do?method=4&vo.functionId=LC_REQ_FOR_LINEN" / style="height:35%;width:100vw"></iframe><iframe name="requestForLinenResult" id="requestForLinenResult"/ style="height:100vh;width:100vw"></iframe>
	
</html>

