<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HEAD>   
<!--<TITLE>Patient Antibodies</TITLE>-->
<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PatientAntibody.label","ca_labels")%></title>
</HEAD>
 <%	request.setCharacterEncoding("UTF-8");	%>
  
<iframe src="../../eCA/jsp/TaskListBTAntiBodyDtls.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="blood_transfusion" NORESIZE style="height:100vh;width:100vw"></iframe>	
<iframe src="../../eCA/jsp/TaskListBTcloseButton.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no"  NORESIZE style="height:5%;width:100vw"></iframe>

</HTML>

