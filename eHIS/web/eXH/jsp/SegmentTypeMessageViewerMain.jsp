<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.ARRAY,webbeans.eCommon.*" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%

String SegType="";
String SegName="";
String prof_id="";
String Standard_code=""; 
prof_id=request.getParameter("Profile_id");
SegType=request.getParameter("Segment_id");
SegName=request.getParameter("Segment_name");
Standard_code=request.getParameter("stand_code");
String appl_name=request.getParameter("appl_name");
session.setAttribute("Profile_id",prof_id);
session.setAttribute("Segment_id",SegType); 
session.setAttribute("Segment_name",SegName);
session.setAttribute("stand_code",Standard_code);
session.setAttribute("appl_name",appl_name);
%>
</head>
<title><fmt:message key="eXH.SegmentViewer.Label" bundle="${xh_labels}"/></title>
<iframe name='head_frame' id='head_frame' src='../../eXH/jsp/SegmentTypeMessageViewer.jsp' frameborder=0 scrolling='auto' style='height:100vh;width:100vw'></iframe>
</html>
  

