<!DOCTYPE html>
<html>
<head> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../eCommon/js/common.js" ></script>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/NotificationConsent.js"></SCRIPT>
<script language="javascript" src="../eCommon/js/jquery-3.6.3.js"></script>

</head>

<%
	String url = "../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>  
<iframe name='transactionFrame' id='transactionFrame' src="../servlet/eXH.NotificationConsentServlet?requestType=QUERY" frameborder=0  scrolling='no' style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>

