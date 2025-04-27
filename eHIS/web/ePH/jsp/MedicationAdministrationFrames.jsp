<!DOCTYPE html>
<!--
Developed by    : P.Sudhakaran.
Module/Function : MedicationAdministration
start date		: 17/06/2003
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*, eCommon.Common.*" %>
<html>
<head>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/MedicationAdministration.js"></script>
	<script language="javascript" src="../js/MedicationAdministrationFixedTime.js"></script>
	<!-- <script language="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<iframe name="f_search" id="f_search" frameborder="0" scrolling="no"  src="../../ePH/jsp/MedicationAdministrationSearch.jsp" style="height:17vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe>
</html>

