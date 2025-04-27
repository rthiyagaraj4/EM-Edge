<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="JavaScript" src="../js/OROrderCatalogMultiConsent.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe name='OROrderCatalogMultiConsentCriteriaFrame' id='OROrderCatalogMultiConsentCriteriaFrame' src='../../eOR/jsp/OROrderCatalogMultiConsentCriteria.jsp' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:17vh;width:100vw'></iframe>
<iframe name='OROrderCatalogMultiConsentResultHeaderFrame' id='OROrderCatalogMultiConsentResultHeaderFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=NO framespacing=NO border=0 style='height:10vh;width:100vw'></iframe>
<iframe name='OROrderCatalogMultiConsentResultFrame' id='OROrderCatalogMultiConsentResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=YES framespacing=NO border=0 style='height:11vh;width:100vw'></iframe>
<iframe name='OROrderCatalogMultiConsentAddEditHeaderFrame' id='OROrderCatalogMultiConsentAddEditHeaderFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=NO framespacing=NO border=0 style='height:9vh;width:100vw'></iframe>
<iframe name='OROrderCatalogMultiConsentAddEditFrame' id='OROrderCatalogMultiConsentAddEditFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=YES framespacing=NO border=0 style='height:41vh;width:100vw'></iframe>
<iframe name='OROrderCatalogMultiConsentButtonFrame' id='OROrderCatalogMultiConsentButtonFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:6vh;width:100vw'></iframe>
<iframe name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' frameborder=1 noresize framespacing=NO border=0 style='height:0vh;width:100vw'></iframe>
</head>
</html>




