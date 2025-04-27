<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.ARRAY" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String eventType="";
String eventName="";
String appl_id="";
String appl_name="";
String Standard_code="";
appl_id=request.getParameter("appl_id");
eventType=request.getParameter("event_id");
eventName=request.getParameter("event_name");
Standard_code=request.getParameter("stand_code");
appl_name=request.getParameter("appli_name");
session.setAttribute("appl_id",appl_id);
session.setAttribute("Event_id",eventType);
session.setAttribute("event_name",eventName);
session.setAttribute("stand_code",Standard_code); 
session.setAttribute("appl_name",appl_name);
%>
</head>
<title><fmt:message key="eXH.EventViewer.Label" bundle="${xh_labels}"/></title>
<iframe name='head_frame' id='head_frame' src='../../eXH/jsp/EventTypeMessageViewer.jsp' frameborder=0 scrolling='auto' style='height:100vh;width:100vw'></iframe>
</html>
 

