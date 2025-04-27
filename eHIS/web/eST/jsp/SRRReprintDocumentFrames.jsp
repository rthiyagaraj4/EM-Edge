<!DOCTYPE html>
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
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!-- <script language='javascript' src='../../eST/js/StMessages.js'></script> -->
<script language='javascript' src='../../eST/js/SSRReprintDocument.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	//pmd 29/01/05
//	String facilityid=(String)session.getValue("facility_id");
%>
<title><fmt:message key="eST.ItemSearch.label" bundle="${st_labels}"/></title>
<iframe name='f_criteria' id='f_criteria' src="../../eST/jsp/SRRReprintDocumentCriteria.jsp" frameborder=0 scrolling='no' style='height:140%;width:100vw'></iframe><iframe name='f_result' id='f_result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:100vh;width:100vw'></iframe>
</html>

