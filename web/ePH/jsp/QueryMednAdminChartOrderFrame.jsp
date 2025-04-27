<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
 <%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String  patientid		=	request.getParameter("patientid");
	String  encounterid		=	request.getParameter("encounterid");
	String called_from		=	request.getParameter("called_from");
	String patient_class=request.getParameter("patient_class");
	if(called_from==null) called_from="";
	
	String url1= "../../ePH/jsp/QueryMednAdminPatientSummary.jsp?patientid="+patientid+"&encounterid="+encounterid+"&called_from="+called_from+"&patient_class="+patient_class;
%>

<iframe name="f_subframe" id="f_subframe"  src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height:0vh;width:100vw"></iframe>
<iframe name="f_summaryframe" id="f_summaryframe"  src="<%=url1%>" frameborder="0" noresize scrolling="auto" style="height:100vh;width:98vw"></iframe>
<iframe name="f_drugdetailsframe" id="f_drugdetailsframe"  src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no"style="height:0vh;width:98vw"></iframe>
<iframe name="f_colorframe" id="f_colorframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height:0vh;width:100vw"></iframe>
<iframe name="f_admindetailsframe" id="f_admindetailsframe" src="../../eCommon/html/blank.html" noresize scrolling="auto" frameborder="0"  style="height:0vh;width:98vw"></iframe>

</html>

