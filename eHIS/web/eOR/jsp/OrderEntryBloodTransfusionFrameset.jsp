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
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HTML>
<HEAD>
	<!--Modified by Ashwini on 08-May-2018 for ML-MMOH-CRF-0589-->
    <TITLE><fmt:message key="eBT.Blood.label" bundle="${bt_labels}"/>&nbsp;<fmt:message key="eBT.TransfusionTransferHistory.label" bundle="${bt_labels}"/></TITLE>	 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
	<iframe src="../../eOR/jsp/OrderEntryBloodTransfusion.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="blood_transfusion" NORESIZE style="height:95vh;width:100vw"></iframe>
      		<iframe src="../../eOR/jsp/ViewOrderBtn.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no"  NORESIZE style="height:5vh;width:100vw"></iframe>
	
</HTML>

