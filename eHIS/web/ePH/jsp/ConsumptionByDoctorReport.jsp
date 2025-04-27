<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100               ?          		created
01/07/2014   MMS-QH-CRF-0108   SureshKumar T    Pharmacy Management->PH Reports->Consumption by Doctor ? Report Criteria
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>                                
<head>                                
	<script language="javascript" src="../../ePH/js/ConsumptionByDoctor.js"></script> 
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../js/PhMessages.js"></script> !-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/ConsumptionByDoctorSrcCriteria.jsp" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
</html>

