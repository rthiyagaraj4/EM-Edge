<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String patientdetails= request.getParameter("patient_id");
	if (patientdetails==null||patientdetails.equals("null")){
		 patientdetails="";
	 }
/*	 patientdetails = patientdetails.trim();
	if (patientdetails.indexOf(",")!=-1){
		StringTokenizer fieldTokenizer = new StringTokenizer(patientdetails,",");
		patientdetails="";
		
		while (fieldTokenizer.hasMoreTokens()) {
			String tempToken = fieldTokenizer.nextToken();
		 
			if ((tempToken.indexOf('/'))==1){
				String tempstr=tempToken.substring(1);
				if (tempToken.charAt(0)=='M')
					tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
				else if(tempToken.charAt(0)=='F')
					tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			patientdetails=patientdetails.concat(tempToken).concat(",");
		}
	}*/
%>
	<head>
		<title><fmt:message key="ePH.NPBRequestForm.label" bundle="${ph_labels}"/> -- <%=patientdetails%></title>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name="editor" id="editor" src="../../eCommon/jsp/RTEditor.jsp" frameborder="none" border="none" scrolling="no" noresize  style="height:90vh;width:100vw"></iframe><iframe name="editor_button" id="editor_button"   src="../../ePH/jsp/NPBRequestFormButton.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize style="height:10vh;width:100vw"></iframe> 
	
</html>

