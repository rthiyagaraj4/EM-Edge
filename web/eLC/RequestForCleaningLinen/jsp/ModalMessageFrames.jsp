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
	<iframe name="CancelRequest" id="CancelRequest" src='<%=request.getContextPath()%>/RequestForCleaningLinenViewAction.do?title=<%=request.getParameter("title")%>&vo.checkView=veiw&method=4&vo.placeCleaningLinenRequestVO.requestNum=<%=request.getParameter("requestNum")%>&vo.placeCleaningLinenRequestVO.sourceType=<%=request.getParameter("sourceType")%>&vo.placeCleaningLinenRequestVO.sourceCode=<%=request.getParameter("sourceCode")%>&vo.placeCleaningLinenRequestVO.linenHandedOverBy=<%=request.getParameter("linenHandedOverBy")%>&vo.placeCleaningLinenRequestVO.linenCollectedBy=<%=request.getParameter("linenCollectedBy")%>&vo.placeCleaningLinenRequestVO.requestStatus=<%=request.getParameter("requestStatus")%>&vo.placeCleaningLinenRequestVO.linenItem=<%=request.getParameter("linenItem")%>&vo.placeCleaningLinenRequestVO.reasonCode=<%=request.getParameter("reasonCode")%>' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:60%;width:100vw"></iframe>
</html>

