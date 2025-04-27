<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%  
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String protocol_link_id=request.getParameter("protocollinkid");
String applicationId = request.getParameter("application_id");
String facilityId = request.getParameter("Facility_Id");
String msgId = request.getParameter("msg_id");
String eventType = request.getParameter("eventype"); 
String sub_module = request.getParameter("sub_module"); 
String qapplname=request.getParameter("qapplname");
String faciname=request.getParameter("faciname");  
String qryid = request.getParameter("qryid"); 
String purge_status=request.getParameter("purge_status");
//String url = "../../eXH/jsp/default.html?";
String url = "../../eXH/jsp/ViewQueryTree.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&purge_status="+purge_status+"&qryid="+qryid+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&sub_module="+sub_module+"&qapplname="+qapplname+"&faciname="+faciname+"&rule=J&rule2=C";
String url2="../../eXH/jsp/ViewQueryTreeRight.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&qryid="+qryid+"&purge_status="+purge_status+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&sub_module="+sub_module+"&qapplname="+qapplname+"&faciname="+faciname+"&rule=J&rule2=C";





%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title><fmt:message key="eXH.MessageViewer.Label" bundle="${xh_labels}"/></title>
<iframe name='f_query' id='f_query' src='<%= url %>'   scrolling='auto' style='height:100vh;width:51vw' ></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%= url2%>'   scrolling='auto' style='height:100vh;width:49vw'></iframe>
</html>							 		 	   

