<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ditchnet.org/jsp-tabs-taglib" prefix="ibaTabs" %>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.pojo.web.MessageReader"%>


<html>
	<head>
	
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>	
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script  type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/eLC/core/js/LcExpand.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<ibaTabs:tabConfig />
	
		
			
	<%
		String functionId=request.getParameter("vo.functionId");
		String moduleId=request.getParameter("vo.moduleId");
		String facilityId=(String)session.getAttribute("facility_id");	
		pageContext.setAttribute("queryString", request.getQueryString());
		//pageContext.setAttribute("values", request.getQueryString());
		Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}
		MessageReader mr=new MessageReader();

		pageContext.setAttribute("mendingList",mr.getMessage(request,"com.iba.ehis.lc.sendLinenForMending.mendingRequestsList"));
		pageContext.setAttribute("placeLinenMendingRequest",mr.getMessage(request,"com.iba.ehis.lc.sendLinenForMending.placeLinenMendingRequest"));
		pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);
	%>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="IBAFORM" id="IBAFORM">
<table border=0 width='100%'align="center"><tr height='500' ><td>
		<tab:tabContainer id="RequestForMendingTabs" 
			selectedTabPaneId="requestForLinenTab">
			<tab:tabPane id="placeLinenRequestTab" tabTitle="${placeLinenMendingRequest}">
				<iframe frameborder=0 scrolling=auto	src="${rootDir}/SendLinenForMendingAction.do?vo.viewCode=placeLinenRequestFrame&method=1&${queryString}" 
				width="100%" height="80%" name="placeLinenRequestForMendingFrame"></iframe>
			</tab:tabPane>

			<tab:tabPane id="mendingListTab" tabTitle="${mendingList}">
			<iframe frameborder=0 scrolling=auto	src="${rootDir}/eLC/SendLinenForMending/jsp/RequestForMendingFrames.jsp?vo.viewCode=mendingListFrame&method=1&${queryString}"
			 name="mendingListFrame" width="100%" height="80%"></iframe>
			</tab:tabPane>
		</tab:tabContainer>
		</td>
		
		</tr>
	</table>	
	</form>
	</body>
</html>

