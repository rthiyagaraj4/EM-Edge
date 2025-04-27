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
	<iframe name="CancelRequest" id="CancelRequest" src='<%=request.getContextPath()%>/LoanLinenViewAction.do?title=<%=request.getParameter("title")%>&vo.checkView=veiw&method=4&vo.loanLinenVO.givenBy=<%=request.getParameter("givenBy")%>&vo.loanLinenVO.receivedBy=<%=request.getParameter("receivedBy")%>&vo.loanLinenVO.linenItem=<%=request.getParameter("linenItem")%>&vo.loanLinenVO.reasonCode=<%=request.getParameter("reasonCode")%>&vo.loanLinenVO.requestStatus=<%=request.getParameter("requestStatus")%>&vo.loanLinenVO.loanedToSourceType=<%=request.getParameter("loanedToSourceType")%>&vo.loanLinenVO.loanedToSourceCode=<%=request.getParameter("loanedToSourceCode")%>&vo.loanLinenVO.sourceType=<%=request.getParameter("sourceType")%>&vo.loanLinenVO.sourceCode=<%=request.getParameter("sourceCode")%>&vo.loanLinenVO.remarks=<%=request.getParameter("remarks")%>&vo.loanLinenVO.addedFacilityId=<%=session.getAttribute("facility_id")%>&vo.loanLinenVO.loanRefNum=<%=request.getParameter("loanRefNum")%>' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:60%;width:100vw"></iframe>
</html>

