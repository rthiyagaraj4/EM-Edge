<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewMessagesAuditLog.js'></script>
</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<title><fmt:message key="eXH.ViewMessagesAuditLog.Label" bundle="${xh_labels}"/></title>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:7vh;width:100vw'></iframe>
<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewMsgInteractiveAuditLogHeader.jsp' frameborder=0 noresize scrolling='no' style='height:25vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:16vh;width:100vw'></iframe>
<iframe name='f_query_detail' id='f_query_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:46vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:6vh;width:100vw'></iframe>
</html>       

