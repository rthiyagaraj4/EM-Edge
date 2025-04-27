<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>
<html>
<head>
<%
String diagdesc= request.getParameter("diagdesc")==null?"":request.getParameter("diagdesc");
String diagset= request.getParameter("diagset")==null?"":request.getParameter("diagset");
String diagcode= request.getParameter("diagcode")==null?"":request.getParameter("diagcode");
String patient_id= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String Encounter_Id= request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
%>
<title><fmt:message key="eMR.DrugInteractions.label" bundle="${mr_labels}"/></title>
<!-- <iframe name = 'drugIndication' src = '../../eMR/jsp/RecDiagDrugIndication.jsp?diagdesc=<%=diagdesc%>&diagset=<%=diagset%>&diagcode=<%=diagcode%>&patient_id=<%=patient_id%>&Encounter_Id=<%=Encounter_Id%>' scrolling='auto' noresize frameborder='0'  style='height:100vh;width:100vw'></iframe> 
</head></html>


