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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<ibaTabs:tabConfig />
		<%
		String facilityId=(String)session.getAttribute("facility_id");	
		String functionId=request.getParameter("vo.functionId");
		String moduleId=request.getParameter("vo.moduleId");
		pageContext.setAttribute("queryString", request.getQueryString());
		Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}

			MessageReader mr=new MessageReader();
			pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);
			pageContext.setAttribute("loanLinen",mr.getMessage(request,"com.iba.ehis.lc.loanLinen"));
			pageContext.setAttribute("loanedLinenlist",mr.getMessage(request,"com.iba.ehis.lc.loanLinen.loanedLinenlist"));
		

		%>
	</head>
<body topmargin='0'>
<table border=0 width='95%'align="center" cellspacing='0' cellpadding='0'><tr height='500'><td>
		<tab:tabContainer id="loanLinenTabs"
			selectedTabPaneId="LoanLinenTab">
			<tab:tabPane id="loanLinenTab" 
				tabTitle="${loanLinen}">
				<iframe frameborder=0 scrolling=auto	src="${rootDir}/LoanLinenAction.do?vo.viewCode=loanLinenFrame&method=1&${queryString}" 
				width="100%" height="90%" name="loanLinenFrame"></iframe>
			</tab:tabPane>
			<tab:tabPane id="loanListTab"
				tabTitle="${loanedLinenlist}">
			<iframe frameborder=0 scrolling=auto	src="${rootDir}/eLC/LoanLinen/jsp/LoanLinenFrames.jsp?vo.viewCode=loanLinenListFrame&method=1&${queryString}" name="loanLinenListFrame" width="100%" height="90%"></iframe>
			</tab:tabPane>
		</tab:tabContainer>
		</td></tr>
	</table>	
	</body>
</html>

