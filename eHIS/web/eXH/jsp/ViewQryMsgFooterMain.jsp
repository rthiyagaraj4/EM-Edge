<!DOCTYPE html>
<html>
<head> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "eXH.XHDBAdapter" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	 
		String params = request.getQueryString()+"&rule=R" ;
		//String source = url + params ;
%>  
		<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewQryMsgFooter.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:100vh;width:80vw'></iframe>
	
		<iframe name='messageFrame' id='messageFrame'	 src='../../eXH/jsp/ViewQueryTreeMain.jsp?<%=params%>' frameborder=0 noresize scrolling='auto' style='height:100vh;width:15vw'></iframe>
</html>    

