<!DOCTYPE html>
<%@ page  import=" java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eST/js/OpeningStock.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
%>
	<iframe name='frameOpeningStockListHeader' id='frameOpeningStockListHeader'	src="../../eST/jsp/OpeningStockListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:32vh;width:100vw'></iframe>
	<iframe name='frameOpeningStockListDetail' id='frameOpeningStockListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:68vh;width:100vw'></iframe>
		

	

</html>

