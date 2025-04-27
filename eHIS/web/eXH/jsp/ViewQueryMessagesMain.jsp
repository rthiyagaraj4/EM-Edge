<!DOCTYPE html>
<html> 
<head> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>			      
	  
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewQryMsgHeader.jsp' frameborder=0 noresize scrolling='no'style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no'style='height:8vh;width:100vw'></iframe>

</html> 

