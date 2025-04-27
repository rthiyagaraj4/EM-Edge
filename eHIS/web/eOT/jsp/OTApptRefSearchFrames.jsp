<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<%
	String queryString=request.getQueryString();
	String func_id=request.getParameter("func_id");
%>
<title>
<%
if(func_id.equals("Chk_InTo_OR")){
%>
	<fmt:message key="eOT.OperNum.Label" bundle="${ot_labels}"/>
<%}else if(func_id.equals("Chk_In")){%>
	<fmt:message key="eOT.ApptRefnum.Label" bundle="${ot_labels}"/>
<%}%>
</title>
<iframe name='group_head' id='group_head' src='../../eOT/jsp/OTApptSearchCriteria.jsp?<%=queryString%>' noresize   marginheight=0 marginwidth=0 style='height:10vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eOT/jsp/OTApptRefSearchResults.jsp?<%=queryString%>'  noresize  scrolling="yes"  marginheight=0 marginwidth=0 style='height:80vh;width:100vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize   marginheight=0 marginwidth=0 style='height:10vh;width:100vw'></iframe>
</html>

