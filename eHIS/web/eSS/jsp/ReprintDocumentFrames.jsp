<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
</link> -->
<%
request.setCharacterEncoding("UTF-8");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
<!-- <script language='javascript' src='../../eST/js/StMessages.js'></script> -->
<script language='javascript' src='../../eSS/js/ReprintDocument.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	//pmd 29/01/05
//	String facilityid=(String)session.getValue("facility_id");
%>
<title><fmt:message key="eST.ItemSearch.label" bundle="${st_labels}"/></title>
<iframe name='f_criteria' id='f_criteria' src="../../eSS/jsp/ReprintDocumentCriteria.jsp" frameborder=0 scrolling='no' style='height:140%;width:100vw'></iframe><iframe name='f_result' id='f_result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:100vh;width:100vw'></iframe>
</html>

