<!DOCTYPE html>
 <%@ page  import=" java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="JavaScript" src="../../eST/js/AdjustStock.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
%>
	<iframe name='frameAdjustStockListHeader' id='frameAdjustStockListHeader' src="../../eST/jsp/AdjustStockListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   style='height:52vh;width:100vw'></iframe> 
		<iframe name='frameAdjustStockListDetail' id='frameAdjustStockListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'    style='height:45vh;width:100vw'></iframe>
						   					   
</html>

