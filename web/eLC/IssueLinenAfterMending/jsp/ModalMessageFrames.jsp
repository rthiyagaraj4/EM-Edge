<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime" pageEncoding="ISO-8859-1"%>
<html>
<head>
<%
String title=(String)request.getParameter("title");
String linenDesc=(String)request.getParameter("linenDesc");
String raisedBy=(String)request.getParameter("raisedBy");
String requestStatus=(String)request.getParameter("requestStatus");

UserPreferences userPrefs =new UserPreferences();
//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
				/* Cache cache = CacheManager.getCache();
				userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
				String datepattrn=userPrefs.getDateFormat();
				String sb=userPrefs.getDateFormat();
				String tf=userPrefs.getTimeFormat();
				String pattern=sb+" "+tf;

%>
<script language="JavaScript" >
//dialogArguments[8]
function receiveMending()
		{
		
			var moduleId="LC";
			var functionId="LC_RECEIVE_MEND_LINEN";
			parent.content.location.href = contextPath + "/eLC/IssueLinenAfterMending/jsp/IssueOfLinenAfterMendingFrames.jsp?vo.viewCode=requestsListFrame&method="+loadMethod+"&vo.functionId="+functionId+"&vo.moduleId="+moduleId;

		}

function reset()
{
	window.returnValue=true;
	window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=title%></title>
</head>
	<iframe name="linenIssue" id="linenIssue" src='<%=request.getContextPath()%>/IssueLinenAfterMendingViewAction.do?method=4&vo.checkView=issue&vo.issueOfLinenVO.requestNum=<%=request.getParameter("requestNum")%>&vo.issueOfLinenVO.requestDate=<%=request.getParameter("requestDate")%>&vo.issueOfLinenVO.requestDate.pattern=<%=pattern%>&vo.issueOfLinenVO.sentBy=<%=request.getParameter("raisedBy")%>&vo.issueOfLinenVO.requestStatus=<%=request.getParameter("requestStatus")%>&vo.issueOfLinenVO.linenItem=<%=request.getParameter("linenItem")%>&vo.issueOfLinenVO.requestedQty=<%=request.getParameter("requestedQty")%>&vo.issueOfLinenVO.linenDesc=<%=linenDesc%>' / style='height:100vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:65%;width:100vw"></iframe>
</html>

