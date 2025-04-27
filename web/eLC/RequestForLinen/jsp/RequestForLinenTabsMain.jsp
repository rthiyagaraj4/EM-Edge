<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ditchnet.org/jsp-tabs-taglib" prefix="ibaTabs" %>
<%@ page  import="com.iba.framework.core.pojo.web.MessageReader"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<%@taglib uri="/WEB-INF/tld/ditchnet-tabs-taglib.tld" prefix="tab"%>
<html>
	<head>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script  type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<ibaTabs:tabConfig />
		<%
		String facilityId=(String)session.getAttribute("facility_id");	
		pageContext.setAttribute("values", request.getQueryString());
		Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}

			MessageReader mr=new MessageReader();

			pageContext.setAttribute("RequestList",mr.getMessage(request,"com.iba.ehis.lc.requestForLinen.requestList"));
			pageContext.setAttribute("PlaceLinenRequest",mr.getMessage(request,"com.iba.ehis.lc.requestForLinen.placeLinenRequest"));
			pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);

		%>
	</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table border=0 width='100%'align="center"><tr height='500'><td>
		<tab:tabContainer id="RequestForLinenTabs" 
			selectedTabPaneId="requestForLinenTab">
				<tab:tabPane id="PlaceLinenRequestTab"
				tabTitle="${PlaceLinenRequest}">
				<iframe frameborder=0 scrolling=auto	src="${rootDir}/RequestForLinenAction.do?vo.viewCode=placeLinenRequestFrame&method=1&vo.functionId=LC_REQ_FOR_LINEN" 
				width="100%" height="100%" name="placeLinenRequestFrame"></iframe>
			</tab:tabPane>

			<tab:tabPane id="RequestsListTab"
				tabTitle="${RequestList}">
			<iframe frameborder=0 scrolling=auto	src="${rootDir}/eLC/RequestForLinen/jsp/RequestForLinenFrames.jsp?vo.viewCode=requestsListFrame&method=1&vo.functionId=LC_REQ_FOR_LINEN"
			 name="requestsListFrame" width="100%" height="100%"></iframe>
			</tab:tabPane>
		</tab:tabContainer>
		</td></tr>
	</table>	
	</body>
</html>

