<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<% 
		request.setCharacterEncoding("UTF-8");
		String  p_mode=request.getParameter("p_mode");
%>

<title><fmt:message key="Common.SearchVisit.label" bundle="${common_labels}"/></title>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize src='../../eOP/jsp/SearchVisitToolbar.jsp' style='height:5vh;width:100vw'></iframe>
	<iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/SearchVisitQueryCriteria.jsp?p_mode=<%=p_mode%>' style='height:14vh;width:100vw'></iframe>
	<iframe name='code_desc' id='code_desc'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:81vh;width:100vw'></iframe>
</html>

