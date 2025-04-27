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
	<iframe name="CancelRequest" id="CancelRequest" src='<%=request.getContextPath()%>/SendLinenForMendingViewAction.do?title=<%=request.getParameter("title")%>&vo.checkView=veiw&method=4&vo.placeLinenRequestVO.requestNum=<%=request.getParameter("requestNum")%>&vo.placeLinenRequestVO.sentBy=<%=request.getParameter("sentBy")%>&status=<%=request.getParameter("status")%>&vo.placeLinenRequestVO.linenItem=<%=request.getParameter("linenItem")%>&vo.placeLinenRequestVO.cancelledBy=<%=request.getParameter("cancelledBy")%>&vo.placeLinenRequestVO.reasonCode=<%=request.getParameter("reasonCode")%>&vo.placeLinenRequestVO.requestStatus=<%=request.getParameter("requestStatus")%>&vo.addedFacilityId=<%=request.getParameter("addedFacilityId")%>' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:60%;width:100vw"></iframe>
</html>

