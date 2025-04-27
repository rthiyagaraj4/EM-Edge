<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
		<form name="RegPrescriptionsPatientIDLocator" id="RegPrescriptionsPatientIDLocator" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="regprescriptionspatientidlocatorID" style="visibility:hidden"> 
				<tr>
					<td ><input style="color:red;"  type="text" name="patient_id_locator" id="patient_id_locator" size="18" value='<fmt:message key="ePH.EnterPatientIDTo.label" bundle="${ph_labels}"/>' onFocus="this.value=''"  onBlur="clearTextFromPatientIdLocator()" ><input type="button" value='<fmt:message key="ePH.Locate.label" bundle="${ph_labels}"/>'  class="button" name="btnLocate" id="btnLocate" style="font-size:9" onClick="locatePatientID()"></td>
				</tr> 
			</table>
		</form>
	</body>
	<SCRIPT LANGUAGE="JavaScript">
		loadPatientIdFrame(); 
	</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

