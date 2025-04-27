<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "eXH.XHDBAdapter" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<%
String params = request.getQueryString() ;													      
%>    
	<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewEventsExceptionHeaderReviewPage.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:100vh;width:70vw'></iframe>
	<iframe name='f_query_message' id='f_query_message'	 src='../../eXH/jsp/ViewSegmentsTreeMain.jsp?<%=params%>&img=Y' frameborder=0 noresize scrolling='auto' style='height:100vh;width:25vw'></iframe>
    
</html>                    			  															       

