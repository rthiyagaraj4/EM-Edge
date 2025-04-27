<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
  <%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
  String patientdetails= request.getParameter("patientdetails");
//if(patient_details == null || patient_details.equals("null")) patient_details =" "; else
if (patientdetails==null||patientdetails.equals("null")||patientdetails=="")
	 {
		 patientdetails="";
	 }
	 patientdetails = patientdetails.trim();
	 //out.println("<script>alert('==="+patientdetails+"=')</script>");
	 if (patientdetails.indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(patientdetails,",");
			patientdetails="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			patientdetails=patientdetails.concat(tempToken).concat(",");
			      
		}
					 }
//commented by uma 5/11/2007
	 //patient_details = java.net.URLDecoder.decode(patient_details,"UTF-8");
	
%>
<head>
	<title><fmt:message key="Common.ConsentDetails.label" bundle="${common_labels}"/> --<%=patientdetails%></title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</head>
<!--<script>alert("in Consent DetailsFrameset.jsp...."+"<%=request.getQueryString()%>");</script>-->
	<iframe src="../../eOR/jsp/ConsentDetails.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 scrolling="auto" name="consent_details" id="consent_details" noresize style="height:28vh;width:100vw"></iframe>
		<iframe src="../../eOR/jsp/ConsentDetailsOrderable.jsp?<%=request.getQueryString()%>" frameborder=0  scrolling="yes" name="consent_orderable" id="consent_orderable" noresize style="height:8vh;width:100vw"></iframe>
		<iframe name="editor_template" id="editor_template" src="../../eCommon/html/blank.html" 	frameborder="none" border="none" scrolling="auto" noresize style="height:10vh;width:100vw"></iframe> 
		<iframe name="editor" id="editor" src="../../eCommon/html/blank.html" 	frameborder="none" border="none" scrolling="no" noresize style="height:48vh;width:100vw"></iframe> 
		<iframe name="editor_button" id="editor_button"   src="../../eCommon/html/blank.html" 	frameborder="none" border="none" scrolling="no" noresize style="height:9vh;width:100vw"></iframe> 

</html>

