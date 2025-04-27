<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String index=request.getParameter("index");
%>
<html>
	<head>
		<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	</head>

	<iframe name='frameSalesReturnListHeader' id='frameSalesReturnListHeader'	src="../../eST/jsp/SalesReturnListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:180%;width:100vw'></iframe>

		<iframe name='frameSalesReturnListDetail' id='frameSalesReturnListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:100vh;width:100vw'></iframe>
		
</html>

