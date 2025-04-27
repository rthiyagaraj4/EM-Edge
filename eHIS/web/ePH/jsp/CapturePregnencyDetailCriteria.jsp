<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/CapturePregnencyDetail.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<body onMouseDown="" onKeyDown="lockKey()" >
<%
		String bean_id		= "CapturePregnencyDetailBean";
		String bean_name	= "ePH.CapturePregnencyDetailBean";
		String pract_name =""; 
		String admin_date =""; 
		String mode         	=   request.getParameter("mode");
		String patient_id		= (String)request.getParameter("patient_id")==null?"":(String)request.getParameter("patient_id");//added for CRF-PH- RUT-CRF-0063/01 Null [IN:040486]-start
		String disableval="";
		if(!patient_id.equals(""))
		disableval = "disabled";
		else
		disableval = "";//added  for CRF-PH- RUT-CRF-0063/01 Null [IN:040486]-end
		CapturePregnencyDetailBean bean = (CapturePregnencyDetailBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="populateEncounter('<%=patient_id%>')"><!-- added for CRF-PH- RUT-CRF-0063/01 Null [IN:040486] -->
	<form name="FormCapturePregnenyQueryCriteria" id="FormCapturePregnenyQueryCriteria" >
		<table cellpadding=0 cellspacing=0 width="99%"  align="center" border="0" >
			<tr>	
				<td align="right" class="label" width='8%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width='20%'>&nbsp;<input type="text" name="Patient_Id" id="Patient_Id" size="20"  <%=disableval%>
				 maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="return CheckForSpecChars(event)" value="<%=patient_id%>" onChange="populateEncounter(document.FormCapturePregnenyQueryCriteria.Patient_Id.value);" ><INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button" <%=disableval%> onClick="callPatientSearch(document.FormCapturePregnenyQueryCriteria.Patient_Id)" >
					&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
				</td>
				<td class="label" width='8%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align="left" width="20%">
					<select name="encounterId" id="encounterId" onchange="getlocation(document.FormCapturePregnenyQueryCriteria.encounterId.value)">
							<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					</select>
				 </td>
				<td class="label" width='10%'> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/>/<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;:</td>
				<td width="*"><label id="locn_desc" name='locn_desc' value=""><b></b></label></td>
			 <tr>
				 <td class='button' colspan="6" align="right">
					<input type="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="callResultPage()" >&nbsp;
					<input type="button" name="btnClear" id="btnClear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button" onClick="Clear()">&nbsp;&nbsp;&nbsp;
				 </td>
			</tr>
			</table>
			<input type="hidden" name="locn_code" id="locn_code" value="">
			<input type="hidden" name="pract_name" id="pract_name" value="">
			<input type="hidden" name="admin_date" id="admin_date" value="">
			<input type="hidden" name="bean_id" id="bean_id"	   value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="patient_id" id="patient_id" value="">
		</form>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

