<!DOCTYPE html>

<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------
Date      	 Edit History      Name        Description
----------------------------------------------------------------------------------------------------------------------------------           
03/10/2016    IN06040      	  Mukesh M    For MMS-DM-CRF-0517,New report â??List of Items Not Created in Drug Masterâ?? is required to 
										  identify items which have been created in ST but not created in PH Drug Setup.
										  
----------------------------------------------------------------------------------------------------------------------------------
-->



<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>                                
<head> 
	<script LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>                              
	<script language="javascript" src="../../ePH/js/PhRepListOfItemsNotCreatedInDrugMaster.js"></script>  
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>                               

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:40%;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhRepListOfItemsNotCreatedInDrugMasterCriteria.jsp" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
</html>

