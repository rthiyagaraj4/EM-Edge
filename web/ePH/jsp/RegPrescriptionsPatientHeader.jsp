<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/rowcolor.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
 -->	<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
<%
	
	String	bean_id			=	"RegPrescriptionsBean" ;
	String	bean_name		=	"ePH.RegPrescriptionsBean";
%>
<form name="RegPrescriptionsPatientHeader" id="RegPrescriptionsPatientHeader" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1"  id="regprescriptionspatientheadertable" name="regprescriptionspatientheadertable" style="visibility:hidden"> 
	<th style="font-size:xx-small"><fmt:message key="ePH.TotalNoofPatients.label" bundle="${ph_labels}"/><label style="font-size:xx-small" id="no_of_patients" id="no_of_patients"></label></th>
</table>

<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:100%; visibility:hidden;bgcolor:yellow;" >
	<table id="tooltiptable" name="tooltiptable" cellpadding=0 cellspacing=0 style="border:1px solid black;" width="auto" height="100%" align="center">
		<tr><td id="t" name="t"></td></tr>
	</table>
</div>	
<input type="hidden" name="patientID" id="patientID" value="">
<input type="hidden" name="patientName" id="patientName" value="">
<input type="hidden" name="patientGender" id="patientGender" value="">
<input type="hidden" name="patientSex" id="patientSex" value="">
<input type="hidden" name="patientNationality" id="patientNationality" value="">
<input type="hidden" name="patientNationalityDesc" id="patientNationalityDesc" value="">
<input type="hidden" name="Logout" id="Logout" value="">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
<SCRIPT LANGUAGE="JavaScript">

	 loadOrderDetailsForThePatient(); 

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

