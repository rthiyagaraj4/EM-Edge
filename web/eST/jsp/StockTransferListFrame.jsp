<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import=" eST.StockTransferBean,java.util.ArrayList,java.util.HashMap"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%		
request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
		StockTransferBean bean = (StockTransferBean) getBeanObject("stockTransferBean","eST.StockTransferBean",request);
		bean.setLanguageId(locale);
		String index=request.getParameter("index");
%>
<%
putObjectInBean("stockTransferBean",bean,request);
%>
<html>
	<head>
		<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<!-- 	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	</head>
	
		<iframe name='frameStockTransferListHeader' id='frameStockTransferListHeader'	src="../../eST/jsp/StockTransferListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 style="height:42vh;width:100vw" scrolling='no'   noresize></iframe>

		<%if (index==null){
			%>
		<iframe name='frameStockTransferListDetail' id='frameStockTransferListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style="height:58vh;width:100vw"  noresize></iframe>
		<%
		}
		else{
		%>
		<iframe name='frameStockTransferListDetail' id='frameStockTransferListDetail' src="../../eST/jsp/StockTransferListDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'  style="height:58vh;width:100vw" noresize></iframe>
		<%
		}
		%>
	
</html>

