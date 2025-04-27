<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<!--<SCRIPT LANGUAGE="JavaScript" SRC="../js/ReconstituentFluidForDrug.js"></SCRIPT>-->
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<!-- <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
 	String params = request.getQueryString() ;
	String weight=request.getParameter("weight");
	if ((weight==null)||(weight.equals("")))
	{
	%>
<script>	alert(getMessage("PH_WEIGHT_REQUIRED","PH")); </script>
	<%
	}
%>
<iframe name="LeftFrame" id="LeftFrame" frameborder="0" scrolling="auto" noresize src= '<%="../../ePH/jsp/TPNRegNonStdRegShowDetails.jsp?"+params%>' style="height:50vh;width:100vw"></iframe><iframe name="RightFrame" id="RightFrame" id="RightFrame"  frameborder="0" scrolling="auto" noresize src= '<%="../../ePH/jsp/TPNRegNonStdRegAdminDetails.jsp?"+params%>' style="height:50vh;width:100vw"></iframe>
</html>

