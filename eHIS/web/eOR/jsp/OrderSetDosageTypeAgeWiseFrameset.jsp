<!DOCTYPE html>
<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
12/02/2018	IN065713		Dinesh T		12/02/2018		ML-MMOH-CRF-0987																			Created this file for this CRF
------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../js/OrCommon.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../js/OrderSet.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/OrCommonFunction.js"></script>
</head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<!--<title>Order Set - Age Wise Definition</title>--><!--IN065713-->
<title>Order Set Additional/Age Wise Definition</title><!--IN065713-->
<!--<frameset rows='*%,8%'>--><!--IN065713-->
<frameset rows='8%,*%,8%'><!--IN065713-->	
	<frame name='orderset_dosage_age_hdr' id='orderset_dosage_age_hdr'	src='../../eOR/jsp/OrderSetDosageTypeAgeWiseHeader.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto'><!--IN065713-->
	<frame name='orderset_dosage_age_dtl' id='orderset_dosage_age_dtl'	src='../../eOR/jsp/OrderSetDosageTypeAgeWiseDetails.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto'>
	<frame name='orderset_dosage_age_btn' id='orderset_dosage_age_btn'	src='../../eOR/jsp/OrderSetDosageTypeAgeWiseButtons.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no'>
</frameset>
</html>
<%}
catch(Exception e)
{e.printStackTrace();}
%>

