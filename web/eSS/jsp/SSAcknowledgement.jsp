<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
	<head> 
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eSS/js/SSAcknowledgment.js'></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"  
			menu_id		= "<%= request.getParameter( "menu_id" ) %>"
			module_id	= "<%= request.getParameter( "module_id" ) %>"
		</script>
	</head>

	<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	 System.out.println("source"+source);
		eSS.SSAcknowledgementBean bean = (eSS.SSAcknowledgementBean)getBeanObject( "SSAcknowledgementBean","eSS.SSAcknowledgementBean",request );
		if(!(bean.getAckReqd())) {
			out.println("<script>alert(getMessage('ACK_NOT_APPLICABLE','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
		}	
		
		bean.setLanguageId(locale);
		
	%>
	<script>
	   toolBarString = "<%=params%>"
	</script>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:85vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
	<%
		putObjectInBean("SSAcknowledgementBean",bean,request);
	%>
</html>

