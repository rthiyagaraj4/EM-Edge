<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String applicationId = request.getParameter("application_Id");
String facilityId = request.getParameter("Facility_Id");
String msgId = request.getParameter("Msg_Id");
String eventType = request.getParameter("Even_type");
String protocol_link_id = request.getParameter("protocol_link_id");
String protocol_mode = request.getParameter("protocol_mode");
String sub_module = request.getParameter("sub_module");
String srlNo = request.getParameter("srlNo");
String purge_status = request.getParameter("purge_status");

String url = "../../eXH/jsp/ViewTree.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&protocol_mode="+protocol_mode+"&sub_module="+sub_module+"&srlNo="+srlNo+"&purge_status="+purge_status;
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title>View Message</title>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%= url %>' noresize scrolling='auto'style='height:100vh;width:0vw'></iframe>
<iframe name='f_query' id='f_query' src='../../eCommon/html/blank.html'   noresize scrolling='auto'style='height:100vh;width:100vw'></iframe>
</html>									 	  

