<!DOCTYPE html>

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
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/AcknowledgmentTransactions.js"></script>
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
	 
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		if(!(bean.getAckReqd())) {
			out.println("<script>alert(getMessage('ACK_NOT_APPLICABLE','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
		}	
		bean.setLanguageId(locale);
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/AcknowledgmentTransactionsFrame.jsp" frameborder=0 scrolling='no' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<%
		putObjectInBean("acknowledgmentBean",bean,request);
	%>
</html>

