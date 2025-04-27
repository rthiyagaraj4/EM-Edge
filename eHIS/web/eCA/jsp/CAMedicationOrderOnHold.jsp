<!DOCTYPE html>
<!--
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
07/02/2013	  IN029949	    Chowminya G  Created 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<!-- CAMedicationOrderOnHold.jsp -->
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/MedicationHoldOrder.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<Title><fmt:message key="eOR.MedicationOnHold.label" bundle="${or_labels}"/></Title>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<iframe name='MediHoldOrderTop' id='MediHoldOrderTop' src='../../eOR/jsp/MedicationHoldOrdersTop.jsp' frameborder=0 scrolling='no' noresize style='height:15%;width:100vw'></iframe>
	<iframe name='MediHoldOrderBottom' id='MediHoldOrderBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:*%;width:100vw'></iframe>							   
</html>

