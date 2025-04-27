<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patID=request.getParameter("Patient_Id");
//String FacilityID=(String)session.getValue("facility_id");
%>
<!--<frameset rows='5%,*,0'>-->
<frameset rows='10%,*,0'>
<frame name='patLine' id='patLine' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no' noresize>
<frame name='blank' id='blank' src='../../eMR/jsp/vwPatFileDetailsquery.jsp?Patient_Id=<%=patID%>&function_id=CPD' frameborder='no' scrolling='no' noresize>
<frame name='blank1' id='blank1' src='' frameborder='no' scrolling='no' noresize>
<form>
<!-- <frame name='f_query_mod' id='f_query_mod' src='../../eMR/jsp/patientblank.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no' resizeable='no'>
 -->
<
<input type=hidden name=patient_id' value='<%=patID%>'>
</form>
</html>

