<!DOCTYPE html>
<!-- 

This  file was developed by Shaik Mujafar on Feb/2019 against AAKH-CRF-0079.4

-->

<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%request.setCharacterEncoding("UTF-8");
String sign_stamp = request.getParameter("sign_stamp");
	  
	   String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String practitionerid = request.getParameter("practitionerid");
		String function_id = request.getParameter("function_id");

%>
<title><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;
<%if(sign_stamp.equals("Sign")){%>
<fmt:message key="Common.Signature.label" bundle="${common_labels}"/>
<% }
if(sign_stamp.equals("Stamp")){%>
<fmt:message key="Common.Stamp.label" bundle="${common_labels}"/>
<%}%>
</title>
<head>
  <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
 </script>

</head>	
	 <iframe name='' id='' src='../../eAM/jsp/ViewPractSignature.jsp?practitionerid=<%=practitionerid%>&function_id=<%=function_id%>&sign_stamp=<%=sign_stamp%>' frameborder='0' scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	
</html>

