<!DOCTYPE html>
  <%-- saved on 27/10/2005 --%>
<!-- 
Developed by	: Surendra Reddy
Module/Function : Generic Name for Service View Details (Master)
-->
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<title><fmt:message key="ePH.GenericNameDetails.label" bundle="${ph_labels}"/></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String generic_id = request.getParameter("generic_id") ;
	String url="../../ePH/jsp/GenericNameForServiceView.jsp?generic_id="+generic_id;
%>
<iframe name="generic_details_view" id="generic_details_view" frameborder="0" scrolling="auto"  src="<%=url%>"  style="height:91vh;width:100vw"></iframe><iframe name="closeFrame" id="closeFrame" src="../../ePH/jsp/ATCCloseLevel.jsp?called_from=generic" frameborder="0" noresize scrolling="no" style="height:5vh;width:100vw"></iframe>
</html>

