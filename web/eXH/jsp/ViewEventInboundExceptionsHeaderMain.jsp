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
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>  
<%																							 
	//	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;  
	//	String params = request.getQueryString()+"&rule=R" ;
		//String source = url + params ;

String params = request.getQueryString() ; 														  
/*String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo")); 
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode")); 
String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
String eventType = request.getParameter("even_type");*/

 

%>   
	<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewEventInboundExceptionsHeader.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:100vh;width:14vw'></iframe>
		<iframe name='f_query_message' id='f_query_message'	 src='../../eXH/jsp/ViewSegmentsTreeMain.jsp?<%=params%>&img=Y' frameborder=0 noresize scrolling='auto' style='height:100vh;width:5vw'></iframe> 
    
</html>               

