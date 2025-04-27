<!DOCTYPE html>
 <%@page  contentType="text/html;charset=UTF-8" %>  
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		    request.setCharacterEncoding("UTF-8");
			String sStyle		 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>	</link> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<!-- <script language='javascript' src='../../eST/js/StMessages.js'></script>-->
	<script language='javascript' src='../../eST/js/BatchSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
	</script>
</head>

<%
	String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params		= request.getQueryString() ;
	String source		= url + params ;
%>
<title><fmt:message key="eST.ItemSearch.label" bundle="${st_labels}"/></title>
<frameset rows="42,*,50" >
	<frame name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize>
	<%if(((String)request.getParameter("function_id")).equals("ST_BATCH_SEARCH")){%>
		<frame name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/BatchSearchFrame.jsp?searchFunction=N&batch_status_yn=Y" frameborder=0 scrolling='no'>
	<%}else{%>
		<frame name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/BatchSearchFrame.jsp?searchFunction=N" frameborder=0 scrolling='no'>
	<%}%>
	<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>

