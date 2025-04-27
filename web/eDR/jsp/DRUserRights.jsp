<!DOCTYPE html>
<!doctype html public "-W3CDTD HTML 4.0 TransitionalEN">
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eDR.DefaultSearchCriteria.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/DRUserRights.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;
%>
	<frameset rows='8%,*,5%,8%' frameborder='0'>
		<frame name='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize>
		<frame name='f_query_add_mod' src='../../eDR/jsp/dummy.jsp' frameborder='0' scrolling='no'>
		<frame name='imageframe' src='../../eDR/jsp/dummy.jsp' frameborder='0' scrolling='no'>
		<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize>
	</frameset>
</html>

