<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"  import=" eST.*,eST.Common.*,java.util.*,java.lang.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		StockItemConsumptionBean bean = (StockItemConsumptionBean) getBeanObject("stockItemConsumptionBean","eST.StockItemConsumptionBean",request);
		String index=request.getParameter("index");
		bean.setLanguageId(locale);
%>

<html>
	<head>
		<%
				
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	</head>
	
		<iframe name='frameStockItemConsumptionListHeader' id='frameStockItemConsumptionListHeader'	src="../../eST/jsp/StockItemConsumptionListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:52vh;width:100vw'></iframe>

		<%if (index==null){
			%>
		<iframe name='frameStockItemConsumptionListDetail' id='frameStockItemConsumptionListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:64vh;width:100vw'></iframe>
		<%
		}
		else{
			
		%>
		<iframe name='frameStockItemConsumptionListDetail' id='frameStockItemConsumptionListDetail' src="../../eST/jsp/StockItemConsumptionListDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:64vh;width:100vw'></iframe>
		<%
		}
		%>
	
	
	 <%
putObjectInBean("stockItemConsumptionBean",bean,request);
%>
</html>

