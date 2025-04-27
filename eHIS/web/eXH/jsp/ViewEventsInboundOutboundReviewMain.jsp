<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
</head>
<title><fmt:message key="eXH.MessageReview.Label" bundle="${xh_labels}"/></title> 
<%
	String params = request.getQueryString() ;
	String protocolMode=request.getParameter("protocolMode");		   
																				    
	
	if(protocolMode.equals("O"))
	{  
%>   
<iframe name='f_query_reviw_mod' id='f_query_reviw_mod' src='../../eXH/jsp/ViewEventsInboundOutboundReview.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>																				 
<%  
																				 	    
	}    																					 
	else 
	{																  			    
	%>
<iframe name='f_query_reviw_mod' id='f_query_reviw_mod' src='../../eXH/jsp/ViewEventsInboundReview.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe> 
	<%}%>
</html>		 	   

