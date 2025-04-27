<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		request.setCharacterEncoding("UTF-8");
		String from = request.getParameter("from")==null?"":request.getParameter("from");
        String status=request.getParameter("status")==null?"":request.getParameter("status");
if(from.equals("A"))
{
%>
	<title><fmt:message key="Common.AlphaInfo.label" bundle="${common_labels}"/></title>
	<iframe name='result' id='result'	src="../../eAM/jsp/DiscrMsrCompListResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:40vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src="../../eAM/jsp/DiscrMsrCompListAddModify.jsp?status=<%=status%>&discr_measure=<%=request.getParameter("discr_measure")%>" frameborder=0 scrolling=auto style='height:55vh;width:100vw'></iframe>
<%
}
		
%>
</html>

