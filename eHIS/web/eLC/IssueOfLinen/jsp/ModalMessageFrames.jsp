<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%
String title=(String)request.getParameter("title");
String sourceDesc=(String)request.getParameter("sourceDesc");
String linenDesc=(String)request.getParameter("linenDesc");
String	requestDate=(String)request.getParameter("requestDate");
String pattern="dd/MM/yyyy hh:mm";

			
%>
<script language="JavaScript" >

function reset()
{
	window.returnValue=true;
	window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=title%></title>
</head>
	<iframe name="linenIssue" id="linenIssue" src='<%=request.getContextPath()%>/IssueOfLinenViewAction.do?method=4&vo.checkView=issue&vo.issueOfLinenVO.requestNum=<%=request.getParameter("requestNum")%>&vo.issueOfLinenVO.requestDate=<%=request.getParameter("requestDate")%>&vo.issueOfLinenVO.requestDate.pattern=<%=pattern%>&vo.issueOfLinenVO.sourceType=<%=request.getParameter("sourceType")%>&vo.issueOfLinenVO.sourceCode=<%=request.getParameter("sourceCode")%>&vo.issueOfLinenVO.raisedBy=<%=request.getParameter("raisedBy")%>&vo.issueOfLinenVO.requestStatus=<%=request.getParameter("requestStatus")%>&vo.issueOfLinenVO.linenItem=<%=request.getParameter("linenItem")%>&vo.issueOfLinenVO.requestedQty=<%=request.getParameter("requestedQty")%>&vo.issueOfLinenVO.sourceDesc=<%=sourceDesc%>&vo.issueOfLinenVO.linenDesc=<%=linenDesc%>' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:65%;width:100vw"></iframe>
</html>

