<!DOCTYPE html>
<!-- /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/07/2017	  	IN064425	     	Mukesh M 											GHL-CRF-0470 [IN064425]
																						New jsp page added. 
--------------------------------------------------------------------------------------------------------------
*/
 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String params			= request.getQueryString();
		String MedicationRemarks	= request.getParameter("MedicationRemarks")==null?"":request.getParameter("MedicationRemarks");
		if(!MedicationRemarks.equals(""))
			MedicationRemarks = java.net.URLDecoder.decode(MedicationRemarks,"UTF-8"); 
		//String iv_prep_yn	= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String mode	= request.getParameter("mode")==null?"":request.getParameter("mode");
		System.err.println("MedicationRemarks===>"+MedicationRemarks);
		System.err.println("mode===>"+mode);
		System.err.println("params===>"+params);
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/ConsumableOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			<style>
textarea {
  resize: none;
}
</style>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="FormMedicationRemarks" id="FormMedicationRemarks" >
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr>
					<th align="left" colspan='2'><fmt:message key="ePH.MedicationRemarks.label" bundle="${ph_labels}"/></td>
				</tr> 
				<tr>	
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td  colspan='2' align="center">
						<textarea name="medication_indicate" value=""  maxlength="150"  rows='5' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,150);"><%=MedicationRemarks%></textarea>
					</td>
				</tr>
				<tr>	
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>						
					<td class="white" align='right'colspan='2'> 
						<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savedrugIndicationRemarks(document.FormMedicationRemarks.medication_indicate);">&nbsp;&nbsp;
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.document.getElementById('dialog_tag').close();">
					</td>
				</tr>
				<input type='hidden' name='medication_indication' id='medication_indication' value='<%=MedicationRemarks%>'>
			</table>
		</form>
	</body>
</html>

