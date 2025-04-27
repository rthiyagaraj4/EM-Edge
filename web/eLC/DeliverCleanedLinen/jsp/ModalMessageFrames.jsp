<!DOCTYPE html>
<html>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/DeliverLinen.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=request.getParameter("title")%></title>
<script>

function reset()
{
	window.returnValue=true;
	window.close();
}
</script>
	<iframe name="linenDeliver" id="linenDeliver" src='<%=request.getContextPath()%>/DeliverCleanedLinenViewAction.do?method=4&vo.checkView=view&vo.deliverCleanedLinenVO.requestNum=<%=request.getParameter("requestNum")%>&vo.deliverCleanedLinenVO.linenItem=<%=request.getParameter("linenItem")%>&vo.deliverCleanedLinenVO.requestStatus=<%=request.getParameter("vo.deliverCleanedLinenVO.requestStatus")%>' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:60%;width:100vw"></iframe>
</html>

