<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String params			= request.getQueryString();
		String DrugIndicationRemarks	= request.getParameter("DrugIndicationRemarks")==null?"":request.getParameter("DrugIndicationRemarks");
		if(!DrugIndicationRemarks.equals(""))
			DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); 
		String iv_prep_yn	= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String mode	= request.getParameter("mode")==null?"":request.getParameter("mode");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<%
		if(iv_prep_yn == null || iv_prep_yn.equals("")){
			if(mode.equals("Amend")){
%>
				<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>	
<%
			}
			else if(mode.equals("DD")){
%>
				<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>	
<%
			}
			else{
%>
				<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>	
<%
			}
		}
		else if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2")){
%>
			<script language="JavaScript" src="../../ePH/js/IVPrescriptionWithAdditives.js"></script>	
<%
		}
		else if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
%>
			<script language="JavaScript" src="../../ePH/js/IVPiggyBack.js"></script>	
<%
		}
		else if(iv_prep_yn.equals("5")){
%>
			<script language="JavaScript" src="../../ePH/js/IVPrescription.js"></script>	
<%
		}
		else if(iv_prep_yn.equals("6")){
%>
			<script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>	
<%
		}
		else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){
%>
			<script language="JavaScript" src="../js/OncologyRegimen.js"></script>	
<%
		}
%>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
	<style>
textarea {
  resize: none;
}
</style>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="DrugIndicationRemarks" id="DrugIndicationRemarks" >
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr>
					<th align="left" colspan='2'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
				</tr> 
				<tr>	
					<td olspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td  colspan='2' align="center">
						<textarea name="drug_indicate" value=""  maxlength="500"  rows='9' cols='75' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"><%=DrugIndicationRemarks%></textarea>
					</td>
				</tr>
				<tr>	
					<td olspan='2'>&nbsp;</td>
				</tr>
				<tr>						
					<td class="white" align='right'colspan='2'> 
						<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savedrugIndicationRemarks(document.DrugIndicationRemarks.drug_indicate);">&nbsp;&nbsp;
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="window.close();">
					</td>
				</tr>
				<input type='hidden' name='drug_indication' id='drug_indication' value='<%=DrugIndicationRemarks%>'>
			</table>
		</form>
	</body>
</html>

