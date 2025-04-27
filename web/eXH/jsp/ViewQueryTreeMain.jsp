<!DOCTYPE html>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
</head>
<%
		
		String params = request.getQueryString()+"&rule=R&rule2=H" ;
		//String source = url + params ;
%> 
	
		<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewQueryTree.jsp?<%=params%>' frameborder=0 noresize scrolling='auto'style='height:100vh;width:11.5vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	 src='../../eXH/jsp/ViewQueryTreeRight.jsp?<%=params%>' frameborder=0 noresize scrolling='auto'style='height:100vh;width:10vw'></iframe>

</html>   

