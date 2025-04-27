<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
</head>


<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='batsearchcri' id='batsearchcri'	src="../../eCA/jsp/ClinicalRepMastBatchEventSearchCriteria.jsp" frameborder=no scrolling='no' noresize style='height:25vh;width:98vw'></iframe>
	<iframe name='batsearchres' id='batsearchres' 	src='../../eCommon/html/blank.html' frameborder=no scrolling='yes' noresize style='height:73vh;width:98vw'></iframe>

</html>

