<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import=" java.text.*, java.util.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.StockStatusByItem.label" bundle="${st_labels}"/></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StockStatusByItem.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<!-- @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display increased the Frame Size
 -->
<!--<frameset rows='50%,*'>  -->
		<!--<frame name='frameStockStatusSearchQueryCriteria' id='frameStockStatusSearchQueryCriteria'				src="../../eST/jsp/StockStatusByItemQueryCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>-->
		<iframe name='frameStockStatusSearchQueryCriteria' id='frameStockStatusSearchQueryCriteria'				src="../../eST/jsp/StockStatusByItemQueryCriteria.jsp" frameborder=0 scrolling='no'   noresize style='height:66vh;width:100vw'></iframe>
		<iframe name='frameStockStatusQueryResult' id='frameStockStatusQueryResult'		src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:34vh;width:100vw'></iframe>

</html>

