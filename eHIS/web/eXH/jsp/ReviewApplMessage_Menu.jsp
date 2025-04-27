<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
String protocol_mode = request.getParameter("protocol_mode"); 
String sub_module=request.getParameter("sub_module");
String application_id="";
String application_name="";
String facility_id="";
String facility_name="";
String Event_type="";
String msgid="";
String protocol_link_id = "";
String eventName = "";
String srlNo = request.getParameter("srlNo");
String queueType = request.getParameter("queueType");

if(queueType != null) queueType = queueType.toUpperCase();

try
{
	eventName = request.getParameter("eventName");
	if(protocol_mode.equals("O"))
	{
		 application_id=request.getParameter("application_id");
		 application_name=request.getParameter("application_name");
		 facility_id=request.getParameter("facility_id");
		 facility_name=request.getParameter("facility_name");
		 Event_type=request.getParameter("event_type");
		 msgid=request.getParameter("msgid");
		 protocol_link_id = request.getParameter("protocol_link_id");
		 if(application_name!=null)
		 {
			 if(application_name.equalsIgnoreCase("*A")) 
			 {
				application_name="All";
			 }
			 else 
			 {
			 }
		 }
		 else 
		 {
			 application_name="All";
		 }
		 if(facility_name!=null)
		 {
			 if(facility_name.equalsIgnoreCase("*A")) 
			 {
				facility_name="All";
			 }
			 else
			 {
			 }
		 }
	}
	else
	{     
		 application_id=request.getParameter("application_id");
		 application_name=request.getParameter("application_name");
		 facility_id=request.getParameter("facility_id");
		 facility_name=request.getParameter("facility_name");
		 Event_type=request.getParameter("event_type");
		 msgid=request.getParameter("msgid");
		 protocol_link_id = request.getParameter("protocol_link_id");
    	 if(application_name!=null)
		 {
			 if(application_name.equalsIgnoreCase("*A")) 
			 {
				application_name="All";
			 }
			 else 
			 {
			 }
		 }
		 else 
		 {
			 application_name="All";
		 }
		 if(facility_name!=null)
		 {
			 if(facility_name.equalsIgnoreCase("*A")) 
			 {
				facility_name="All";
			 }
			 else
			 {
			 }
		 }
	  }

}
catch(Exception e)
{
	System.out.println("Error is in ReviewApplMessage_Menu :"+e);
}
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title>View</title>

<iframe src='../../eXH/jsp/ReviewApplMessageMenuTree.jsp?applicationId=<%=application_id%>&facilityId=<%=facility_id%>&msgid=<%=msgid%>&eventType=<%=Event_type%>&protocol_link_id=<%=protocol_link_id%>&sub_module=<%=sub_module%>&applicationName=<%=application_name%>&facilityName=<%=facility_name%>&protocol_mode=<%=protocol_mode%>&sub_module=<%=sub_module%>&eventName=<%=eventName%>&srlNo=<%=srlNo%>&queueType=<%=queueType%>'  name="master_menu" noresize scrolling='auto' style='height:100vh;width:38.5vw'></iframe>
<iframe src='../../eXH/jsp/ReviewApplMessageMenuTreeText.jsp?applicationId=<%=application_id%>&facilityId=<%=facility_id%>&msgid=<%=msgid%>&eventType=<%=Event_type%>&protocol_link_id=<%=protocol_link_id%>&sub_module=<%=sub_module%>&applicationName=<%=application_name%>&facilityName=<%=facility_name%>&protocol_mode=<%=protocol_mode%>&sub_module=<%=sub_module%>&queueType=<%=queueType%>&eventName=<%=eventName%>&srlNo=<%=srlNo%>'  name="master_pages"  marginwidth="0" marginheight="0" scrolling='no' noresize style='height:100vh;width:61.5vw'></iframe>

</html> 

