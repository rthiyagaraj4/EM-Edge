<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eST.SalesBean"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		SalesBean bean = (SalesBean) getBeanObject("salesBean","eST.SalesBean",request);
		bean.setLanguageId(locale);
		String index=request.getParameter("index");
%>
<%
putObjectInBean( "salesBean",bean,request);
%>
<html>
	<head>
		<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	</head>
		<iframe name='frameSalesListHeader' id='frameSalesListHeader'	src="../../eST/jsp/SalesListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style="height:43vh;width:100vw"></iframe>

		<%if (index==null){
			%>
		<iframe name='frameSalesListDetail' id='frameSalesListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style="height:27vh;width:100vw" ></iframe>
		<%
		}
		else{
		%>
		<iframe name='frameSalesListDetail' id='frameSalesListDetail' src="../../eST/jsp/SalesListDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style="height:27vh;width:100vw"></iframe>
		<%
		}
		%>
</html>

