<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ditchnet.org/jsp-tabs-taglib" prefix="ibaTabs" %>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.pojo.web.MessageReader"%>

<html>
	<head>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script  type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<ibaTabs:tabConfig />
		
		<%
			String facilityId=(String)session.getAttribute("facility_id");
			String loggedInUser = (String) session.getAttribute("login_user");
			String flag=(String) request.getParameter("flag");
			String dirtyFlag=(String) request.getParameter("dirtyFlag");
			String userFlag=(String) request.getParameter("userFlag");
			String cutoffTime=(String)request.getParameter("cutoffTime");
			String delParamDate=(String)request.getParameter("delParamDate");
			String scheduleDate=(String)request.getParameter("scheduleDate");
			String reqDate=(String)request.getParameter("requestDate");
			String functionId = (String) request.getParameter("vo.functionId");
			String moduleId = (String) request.getParameter("vo.moduleId");
			//out.println(functionId+" "+moduleId);
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}

		MessageReader mr=new MessageReader();
		pageContext.setAttribute("placeCleanLinenRequest",mr.getMessage(request,"com.iba.ehis.lc.placeCleanLinenRequest"));
		pageContext.setAttribute("cleaningRequestsList",mr.getMessage(request,"com.iba.ehis.lc.cleaningRequestsList"));
		pageContext.setAttribute("pendingCountConfirmation",mr.getMessage(request,"com.iba.ehis.lc.pendingCountConfirmation"));
		pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);
		
		pageContext.setAttribute("queryString", request.getQueryString());
	%>
<script>
if('<%=dirtyFlag%>'=='N')
	{
		
		if('<%=userFlag%>'=='Y')
			{
				
			   alert("You are not authorised to use the function")
			   parent.parent.parent.frames[1].expand(this);
			   parent.parent.parent.frames[2].location.href = contextPath +"/eCommon/jsp/maindisplay.jsp";
			
			}
			
			
		
	}
	</script>
	</head>
<body onload="checkUser()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<table border=0 width='100%'cellspacing=0 cellpadding=0>
<tr height='500'>
<td> 
<tab:tabContainer id="RequestForCleaningLinenTabs" selectedTabPaneId="requestForCleaningLinenTab">
<tab:tabPane id="placeCleaningLinenRequestTab" tabTitle="${placeCleanLinenRequest}" > 
<iframe frameborder=0 scrolling=auto src="${rootDir}/RequestForCleaningLinenAction.do?vo.viewCode=placeCleanLinenRequestFrame&method=1&${queryString}" name="placeCleanLinenRequestFrame" width="100%" height="100%" >
</iframe> 
</tab:tabPane> 

<tab:tabPane id="cleaningRequestsListTab" tabTitle="${cleaningRequestsList}"> 
<iframe frameborder=0 scrolling=auto src="${rootDir}/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenFrames.jsp?vo.viewCode=cleaningRequestsListTab&method=1&${queryString}" name="requestsListFrame" width="100%" height="100%">
</iframe> 
</tab:tabPane>

<ibaLogic:equal value="Y" scope="request" parameter="flag">  
<ibaLogic:equal value="N" scope="request" parameter="userFlag">  
<tab:tabPane id="pendingCountTab" tabTitle="${pendingCountConfirmation}"> 
<iframe frameborder=0 scrolling=no	src="${rootDir}/eLC/RequestForCleaningLinen/jsp/PendingCountFrames.jsp?vo.viewCode=pendingCountTab&method=1&${queryString}" name="pendingCountFrame" width="100%" height="100%">
</iframe> 
</tab:tabPane>
</ibaLogic:equal> 
</ibaLogic:equal> 
<ibaLogic:equal value="Y" scope="request" parameter="userFlag">  
<ibaLogic:equal value="Y" scope="request" parameter="flag">  
<tab:tabPane id="pendingCountTab" tabTitle="${pendingCountConfirmation}"> 
<iframe frameborder=0 scrolling=no	src="${rootDir}/eLC/RequestForCleaningLinen/jsp/PendingCountFrames.jsp?vo.viewCode=pendingCountTab&method=1&${queryString}" name="pendingCountFrame" width="100%" height="100%">
</iframe> 
</tab:tabPane>
</ibaLogic:equal> 
</ibaLogic:equal> 
</tab:tabContainer> 
</td>

</tr> 
</table>
<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>"/>
<input type="hidden" name="loggedInUser" id="loggedInUser" value="<%=loggedInUser%>"/>
</body>

</html>

