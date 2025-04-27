<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params = request.getQueryString()+"&rule=R&rule2=H"; 
String reYN = XHDBAdapter.checkNull(request.getParameter("reYN"));
String protocol_mode = request.getParameter("protocolMode");  
String url2= "../../eXH/jsp/ViewQueryHearderTree.jsp?"+params;
String url1 = "../../eXH/jsp/ViewTreeMain.jsp?"+params; 
																				   
%> 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>																						   
<title><fmt:message key="eXH.MessageViewer.Label" bundle="${xh_labels}"/></title> 
 <div>   
<iframe name='f_query' id='f_query' src='<%=url2%>' frameborder=2  noresize scrolling='no'style='height:3.5vh;width:98vw'></iframe> 
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src="<%=url1%>" frameborder=2 noresize scrolling='auto'style='height:85vh;width:98vw'></iframe>
<% 																										  

if(reYN.equals("Y"))  																 		    
{  
	if(protocol_mode.equals("I"))										    
	{
	%>
	<iframe name='messageFrame' id='messageFrame'	 src='../../eXH/jsp/ViewSegmentInboundClose.jsp?<%=params%>' frameborder=0 noresize scrolling='no'style='height:5vh;width:98vw'></iframe>
	<%} 
	else																				    
	{%>
<iframe name='messageFrame' id='messageFrame'	 src='../../eXH/jsp/ViewQueryMessageViewerClose.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:5vh;width:98vw'></iframe>
<%}
		}
else
{%>

<iframe name='messageFrame' id='messageFrame'	 src='../../eXH/jsp/ViewQueryMessageViewerClose.jsp?' frameborder=2 noresize scrolling='no' style='height:5vh;width:98vw'></iframe>
<%}%> 
 </div>   
</html>						 			 	        

