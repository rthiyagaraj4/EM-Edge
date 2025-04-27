<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%
String facilityId = (String) session.getAttribute("facility_id");
String title=(String)request.getParameter("title");
String sourceDesc=(String)request.getParameter("sourceDesc");
String linenDesc=(String)request.getParameter("linenDesc");
String	requestDate=(String)request.getParameter("requestDate");
String pattern="dd/MM/yyyy hh:mm";

		
%>
<script language="JavaScript" >
//dialogArguments[8]
function reset()
{
	window.returnValue=true;
	window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=title%></title>
</head>
	<iframe name="receiveLoanLinen" id="receiveLoanLinen" src='<%=request.getContextPath()%>/ReceiveLoanedLinenViewAction.do?title=<%=title%>&vo.checkView=receive&method=4&vo.receiveLoanedLinenVO.reasonforLoan=<%=request.getParameter("vo.receiveLoanedLinenVO.reasonforLoan")%>&vo.receiveLoanedLinenVO.loanedToSourceType=<%=request.getParameter("vo.receiveLoanedLinenVO.loanedToSourceType")%>&vo.receiveLoanedLinenVO.loanedToSourceCode=<%=request.getParameter("vo.receiveLoanedLinenVO.loanedToSourceCode")%>&vo.receiveLoanedLinenVO.sourceType=<%=request.getParameter("vo.receiveLoanedLinenVO.sourceType")%>&vo.receiveLoanedLinenVO.sourceCode<%=request.getParameter("vo.receiveLoanedLinenVO.sourceCode")%>&vo.receiveLoanedLinenVO.loanRefNum=<%=request.getParameter("vo.receiveLoanedLinenVO.loanRefNum")%>&vo.receiveLoanedLinenVO.loanDate=<%=request.getParameter("vo.receiveLoanedLinenVO.loanDate")%>&vo.receiveLoanedLinenVO.loanDate.pattern=<%=pattern%>&vo.receiveLoanedLinenVO.givenBy=<%=request.getParameter("vo.receiveLoanedLinenVO.givenBy")%>&vo.receiveLoanedLinenVO.receivedBy<%=request.getParameter("vo.receiveLoanedLinenVO.receivedBy")%>&vo.receiveLoanedLinenVO.linenItem=<%=request.getParameter("vo.receiveLoanedLinenVO.linenItem")%>&vo.receiveLoanedLinenVO.loanStatus=<%=request.getParameter("vo.receiveLoanedLinenVO.loanStatus")%>&vo.receiveLoanedLinenVO.reasonForLoan=<%=request.getParameter("vo.receiveLoanedLinenVO.reasonForLoan")%>&vo.receiveLoanedLinenVO.receivedBackBy=<%=request.getParameter("vo.receiveLoanedLinenVO.receivedBackBy")%>&vo.receiveLoanedLinenVO.receivedWriteOff=<%=request.getParameter("vo.receiveLoanedLinenVO.receivedWriteOff")%>&vo.receiveLoanedLinenVO.remarks=<%=request.getParameter("vo.receiveLoanedLinenVO.remarks")%>&vo.receiveLoanedLinenVO.loanQty=<%=request.getParameter("vo.receiveLoanedLinenVO.loanQty")%>&vo.receiveLoanedLinenVO.receivedQty=<%=request.getParameter("vo.receiveLoanedLinenVO.receivedQty")%>&vo.addedFacilityId=<%=facilityId%>"' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:65%;width:100vw"></iframe>
</html>

