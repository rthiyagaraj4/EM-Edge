<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<title>Supportive Drugs Details</title>
	</head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params = request.getQueryString() ; 
%>
	<iframe name="supp_detail" id="supp_detail" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionSupportiveDrugDetails.jsp?<%=params%>" style="height:82vh;width:100vw"></iframe><iframe name="supp_close" id="supp_close" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionSupportiveDrugButton.jsp?" style="height:18vh;width:100vw"></iframe>
</html>

