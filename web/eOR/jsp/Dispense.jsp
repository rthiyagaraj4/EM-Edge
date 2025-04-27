<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%%>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String mode	   	= request.getParameter( "mode" ) ;
	//String function_id 	= request.getParameter( "function_id" ) ;
	String patient_id 	= request.getParameter("patient_id");
	String encounter_id 	= request.getParameter("episode_id");
	String bean_id 	   	= "@DispenseBean"+patient_id+encounter_id ;
	String bean_name   	= "eOR.DispenseBean";
	String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	if(practitioner_id==null) practitioner_id = "";
	String resp_id 		= (String)session.getValue("responsibility_id");
	if(resp_id==null) resp_id = "";
	String practitioner_type= (String)session.getValue("practitioner_type");
	if(practitioner_type==null) practitioner_type = "";
%>
<%
	String height1;
	String height2;
	String height3;
if (patient_id != null && !patient_id.equals("")) {
    height1 = "22vh";  
    height2 = "5vh";  
    height3 = "73vh";  
} else {
    height1 = "32vh";  
    height2 = "5vh";  
    height3 = "63vh"; 
}
%>
	<iframe name="DispenseSearch" src="../../eOR/jsp/DispenseSearch.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>" frameborder="0" scrolling="no" noresize="noresize" style="height:<%=height1%>;width:100vw"></iframe> 
	<iframe name="DispenseHeader" src="../../eCommon/html/blank.html" frameborder="0" scrolling="auto" noresize="noresize" style="height:<%=height2%>;width:100vw"></iframe>
	 <iframe name="DispenseResult" src="../../eCommon/html/blank.html" frameborder="0" scrolling="auto" style="height:<%=height3%>;width:100vw"></iframe>
	
	<%-- <frame name="DispenseSearch" src="../../eOR/jsp/DispenseSearch.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>" frameborder=0 scrolling=no noresize>
	<frame name="DispenseHeader" src="../../eCommon/html/blank.html" frameborder=0 scrolling=auto noresize>
	<frame name="DispenseResult" src="../../eCommon/html/blank.html" frameborder=0 scrolling=auto>
</frameset> --%>
</html>
