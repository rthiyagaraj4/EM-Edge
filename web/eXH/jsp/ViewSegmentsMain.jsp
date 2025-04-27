<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% 
String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String protocol_link_id=request.getParameter("protocollinkid");
String applicationId = request.getParameter("application_id");
String facilityId = request.getParameter("Facility_Id");
String msgId = request.getParameter("msg_id");
String qryid = request.getParameter("qryid");
String eventType = request.getParameter("eventype");
String sub_module = request.getParameter("sub_module"); 
String qapplname=request.getParameter("qapplname"); 
String faciname=request.getParameter("faciname"); 
String purge_status=request.getParameter("purge_status");
String url = "../../eXH/jsp/viewQueryeventTreeHeader.jsp?";  
String url2="../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id="+applicationId+"&Facility_Id="+facilityId+"&msg_id="+msgId+"&eventype="+eventType+"&protocollinkid="+protocol_link_id+"&sub_module="+sub_module+"&qapplname="+qapplname+"&faciname="+faciname+"&qryid="+qryid+"&purge_status="+purge_status;
//String url = "../../eXH/jsp/ViewQueryTree.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&sub_module="+sub_module+"&qapplname="+qapplname+"&faciname="+faciname+"&rule=J";
//String url2 = "";//"../../eXH/jsp/ViewQueryTreeRight.jsp?application_Id="+applicationId+"&Facility_Id="+facilityId+"&Msg_Id="+msgId+"&Even_type="+eventType+"&protocol_link_id="+protocol_link_id+"&sub_module="+sub_module+"&protocol_mode=Q";
 
//System.out.println("this url:"+url); 

  

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title>View Message</title>
<iframe name='f_query_main' id='f_query_main' src='<%= url %>'   scrolling='no' style='height:6vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_detail_main' id='f_query_add_mod_detail_main' src='<%= url2%>'   scrolling='no' style='height:84vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	 src='../../eXH/jsp/ViewQueryMessageViewerClose.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
</html>							 		 	     

