<!DOCTYPE html>
<!-- Page Added by Rajesh V. Policy Definition Service Coverage Details, OutPatients, Inpatients, External -->

<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../js/PolicyDefinition.js'></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
//Added against NMC-JD-CRF-0045 by Priya 28/08/2020 Starts
$(document).ready(function()
{
	try{
	var grpFlagInd=document.getElementById("siteSpecPolDefservcov").value;
	if(grpFlagInd=='true' || grpFlagInd==true){
		var groupPolicyChkd=parent.parent.PolicyInfoFrame.frmPolicyInfo.GroupPolicy;
		if(groupPolicyChkd.checked){        
				servTabGpPolicyChk();
		} else {
				servTabGpPolicyUnChk();
		}
	}
	}catch(e){
	
	}
});
//Added against NMC-JD-CRF-0045 by Priya 28/08/2020 Ends
</script>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
String beanId = "bl_PolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
PolicyInsuranceMasterBean policyBean = null;
String prevTab = request.getParameter("prevTab");
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";
String disabled1 = "";//Added against NMC-JD-CRF-0045 by Priya
String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String totalDisabled = "";
String MFDRMandYN = "N", MFDRDrugCatEnabledYN = "N", MFDRDiagCatEnabledYN = "N";
String auth = "";
boolean siteSpecPolDefservcov=false;//Added against NMC-JD-CRF-0045 by Priya
auth = checkForNull(request.getParameter("auth"));
try{
	con = ConnectionManager.getConnection(request);
	siteSpecPolDefservcov = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");//Added against NMC-JD-CRF-0045 by Priya
	policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getPolicyMap();
	
	
	//V221017
	String qry_MFDRMandYN = "select NVL(MULTI_FACTOR_DED_RULE_APPL_YN,'N') MULTI_FACTOR_DED_RULE_APPL_YN, NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
			
	pstmt = con.prepareStatement(qry_MFDRMandYN);
	rst = pstmt.executeQuery();
			
	if(rst != null){
		while(rst.next()) {
			MFDRMandYN 	= rst.getString("MULTI_FACTOR_DED_RULE_APPL_YN");
			MFDRDrugCatEnabledYN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
			MFDRDiagCatEnabledYN = rst.getString("MFDR_DIAG_CAT_APPL_YN");
		}
	}
	//V221017
	
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(prevTab);
	}
	if ("modify".equals(mode) ) {
		totalDisabled = "disabled";
		if("Y".equals(auth)){
			totalDisabled = "";
		}
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			String sqlCoverage = "";
			if(siteSpecPolDefservcov){//Added against NMC-JD-CRF-0045 by Priya
				if("Outpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO_GP_POLICY");
				}
				else if("Inpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO_GP_POLICY");
				}
				else if("External".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO_GP_POLICY");
				}
			}else{
				if("Outpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO");
				}
				else if("Inpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
				}
				else if("External".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
				}
			}
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					if(siteSpecPolDefservcov){//Added against NMC-JD-CRF-0045 by Priya
						fmtDtlsBean.setGroupPolicy(rst.getString("gppolicy"));
					}
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounter"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					fmtDtlsBean.setEncGrpIdSameEpsd(rst.getString("DFLT_ACR_ENC_GRP_FOR_SAME_EPIS"));
					
					//V221017
					if("Outpatient".equals(prevTab)){
					fmtDtlsBean.setMultiFactorDeductRuleYN(rst.getString("multi_factor_deductible_rule")); 
					fmtDtlsBean.setMFDRPatLimitAmt(rst.getString("item_patient_amount_limit")); 
					} //V221017
					
					//V230105
					if("Inpatient".equals(prevTab)){
						fmtDtlsBean.setMultiFactorDeductRuleYN(rst.getString("MULTI_FACTOR_DED_RULE_IP")); 
					}//V230105
					
					if(!"External".equals(prevTab)){
						fmtDtlsBean.setTimeLimitValue(rst.getString("duration_value"));
						fmtDtlsBean.setTimeLimitType(rst.getString("duration_type"));
					}
					policyList.add(fmtDtlsBean);
					rsCnt++;
				}

				if(rsCnt<1){
					policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				policyList.add(titleBean);
				policyMap.put(prevTab, policyList);
			}		
			
		}
		
	}
	else{
		if(policyList == null || policyList.isEmpty()){
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(covBean);
		}
	}
	}
	catch(Exception e){
		System.err.println("Exception "+e);
	}
	finally{
		ConnectionManager.returnConnection(con);
	}
%>
<% //policyList = policyMap.get(prevTab);
policyBean = policyList.get(0);

//Added by Priya for NMC-JD-CRF-0045
	if(siteSpecPolDefservcov){
		if("Y".equals(checkForNull(policyBean.getGroupPolicy()))){
			disabled1="disabled";
		}else{
			disabled1="";
	}
}
%>
	<form  id="frmServiceTabDetails">	
      	<table width='100%' cellpadding='3'  cellspacing=0 align="center">  
      		<tr>
      			<td width='30%' class='label' >
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthReq()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      			
      				<input type="checkbox" <%=totalDisabled %> <%=disabled1 %> name='creditAuthReq' <%=checked %>><fmt:message key="eBL.CreditAuthReq.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='25%' class='label'>
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthMand()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      				<input type="checkbox" <%=totalDisabled %> <%=disabled1 %> name='creditAuthMand' <%=checked %>><fmt:message key="eBL.CreditAuthMand.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='30%' class='label' >
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthRef()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      				<input type="checkbox" <%=totalDisabled %> <%=disabled1 %> name='defaultCreditAuth' <%=checked %>>&nbsp;<fmt:message key="eBL.CreditAuthrefNo.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='9%' class='label'><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/>&nbsp;
      			</td width='6%' class='fields'>
      			<td>
					<input type='text' name='patCopay' id='patCopay' <%=totalDisabled %>   <%=disabled1 %>  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getPatCopay())%>' size='5' maxlength='5'>
				</td>
      			
      		</tr>
		</table>
		<table width='100%' cellpadding='3'  cellspacing=0 align="center">  
      		<tr>
      			<td width='15%' class='label'>
      			<%if("Y".equals(checkForNull(policyBean.getCovered()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
				//Added against NMC-JD-CRF-0045 by Priya 
				if(siteSpecPolDefservcov){
					if("Y".equals(checkForNull(policyBean.getGroupPolicy()))){%>
						<input type="checkbox" <%=totalDisabled %> name="covered" <%=checked %>><fmt:message 	key="eBL.Covered.label" bundle="${bl_labels}"/>
				<%}else{%>
					<input type="checkbox" <%=totalDisabled %> name="covered" onclick="fnEnableDisableLimit('chk','covered','limitType');" <%=checked %>><fmt:message key="eBL.Covered.label" bundle="${bl_labels}"/>
				<%}
				}
				else{%>
					<input type="checkbox" <%=totalDisabled %> name="covered" onclick="fnEnableDisableLimit('chk','covered','limitType');" <%=checked %>><fmt:message key="eBL.Covered.label" bundle="${bl_labels}"/>
				<%}				
      			%>
      				
      			</td>
				<td width='15%'>
				</td>
      			<td width='15%' class='label' >
      				<fmt:message key="eBL.CoverageType.label" bundle="${bl_labels}"/>
				</td>
      				<%if("Y".equals(checkForNull(policyBean.getCovered()))){
      					disabled = "";
    				}
    				else{
    					disabled = "disabled";
    				}
    				%>
				<td width='10%' class='fields'>
      					<Select name='limitType' id='limitType' <%=totalDisabled %> onchange="fnEnableDisableDays('limitType','approvedDays','approvedAmt');" <%=disabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if(("R").equals(policyBean.getCoverageLimitType())){ %>
							<option value='R' selected><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='R' ><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<%} %>
						<%if(("U").equals(policyBean.getCoverageLimitType())){ %>
							<option value='U' selected><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='U'><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
						<%} %>
					</Select>
      			</td>
				<td width='17%' colspan='2' class='label' >
				<%if("Y".equals(policyBean.getPolicyApplicability())){ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled1 %> checked name='applicability'  />&nbsp;<fmt:message key="eBL.PolicyApplicability.label" bundle="${bl_labels}"/>
				<%}
				else{%>
					<input type="checkbox" <%=totalDisabled %>  <%=disabled1 %> name='applicability'  />&nbsp;<fmt:message key="eBL.PolicyApplicability.label" bundle="${bl_labels}"/>
				<%} %>
				
				<fmt:message key="eBL.AcrossEncounters.label" bundle="${bl_labels}"/></td>
				<!-- <td width='13%' class='fields' >

				</td> -->
				<td width='9%' class='label'><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='patLimitAmt' id='patLimitAmt' <%=totalDisabled %>   <%=disabled1 %>  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getPatLimitAmt())%>' size='7' maxlength='10'>
				</td>
      		</tr>
      	      			
      		<tr>
      			<td width='15%' class='label' ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/>
      			<%if(("R").equals(policyBean.getCoverageLimitType())){ 
      				disabled = "";
				}
				else{
					disabled = "disabled";
				}
				%>
				</td>
				<td class='fields' width='15%'>
					<Select name='approvedDays' id='approvedDays' <%=totalDisabled %> <%=disabled %>  align='left' onchange="fnEnableDisableLimit('sel','approvedDays','noOfDays');">
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<% if(("R").equals(policyBean.getApprovedDays())){ %>
							<option value='R' selected><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='R' ><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<%} %>
						<% if(("U").equals(policyBean.getApprovedDays())){ %>
							<option value='U' selected><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='U'><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
						<%} %>
					</Select>
				</td>   
				<% if(("R").equals(policyBean.getApprovedDays())){ 
					disabled = "";
				}
				else{
					disabled = "disabled";
				}
				%>
				<td width='15%' class='label' ><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td width='10%'>
					<input type='text' name='noOfDays' id='noOfDays' <%=totalDisabled %> <%=disabled %> onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean.getNoOfDays()) %>' size='5' maxlength='5'>
				</td> 
				
				<td width='17%' class='label' ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></td>
				<%if(("R").equals(policyBean.getCoverageLimitType())){ 
					disabled = "";
				}
				else{
					disabled = "disabled";
				}
				%>
				
				<td width='13%'>
					<Select name='approvedAmt' id='approvedAmt' <%=totalDisabled %> <%=disabled %> onchange="fnEnableDisableLimit('sel','approvedAmt','limitAmt');">
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<% if(("R").equals(policyBean.getApprovedAmt())){ %>
							<option value='R' selected><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='R' ><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<%} %>
						<% if(("U").equals(policyBean.getApprovedAmt())){ %>
							<option value='U' selected><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='U'><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
						<%} %>
					</Select>
				</td>   
				<% if(("R").equals(policyBean.getApprovedAmt())){ 
					disabled = "";
				}
				else{
					disabled = "disabled";
				}
				%>
				<td width='15%' class='label'><fmt:message key="eBL.LimitAmt.label" bundle="${bl_labels}"/>
				<input type='text' name='limitAmt' id='limitAmt' <%=totalDisabled %> <%=disabled %> onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getLimitAmt()) %>' size='5' maxlength='10'>&nbsp;&nbsp;
				<select name='AmtMode' id='AmtMode' <%=totalDisabled %> <%=disabled1 %> >
					<% if(("G").equals(policyBean.getAmtGrossNet())){ %>
						<option value='G' selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
					<%} else{ %>
						<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
					<%} %>
					
					<% if(("N").equals(policyBean.getAmtGrossNet())){ %>
						<option value='N' selected><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
					<%} else{ %>
						<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
					<%} %>
					
				</select>
				</td>
      		</tr>
			<tr>
				<td class='label' width='15%'><fmt:message key="eBL.MandChkBillGen.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='15%'>
					<Select name='chkBillGen' id='chkBillGen' <%=totalDisabled %> <%=disabled1 %> >
						<% if(("N").equals(policyBean.getMandChkBillGen())){ %>
							<option value='N' selected><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='N'><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
						<%} %>
						<% if(("I").equals(policyBean.getMandChkBillGen())){ %>
							<option value='I' selected><fmt:message key="eBL.DiagnosisMR.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='I'><fmt:message key="eBL.DiagnosisMR.label" bundle="${bl_labels}"/></option>
						<%} %>
						<% if(("P").equals(policyBean.getMandChkBillGen())){ %>
							<option value='P' selected><fmt:message key="eBL.DiagnosisPractioner.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='P'><fmt:message key="eBL.DiagnosisPractioner.label" bundle="${bl_labels}"/></option>
						<%} %>
						
					</Select>
				</td>    
				<% if("Outpatient".equals(prevTab)){ %>		
				<td colspan='2' class='label' width='25%'>
					<input type="checkbox" <%=totalDisabled %> <%=disabled1 %> name='encGrpIdSameEpsd' id='encGrpIdSameEpsd' <%= "Y".equals(policyBean.getEncGrpIdSameEpsd()) ? "checked":"" %>>
					&nbsp;<fmt:message key="eBL.DefGrpIdSameEpisode.label" bundle="${bl_labels}"/>
				</td>
				<td class='label' width='17%'>
					<fmt:message key="eBL.TimeLimitDefaultGrp.label" bundle="${bl_labels}"/>
				</td>
				<td class='fields' width='13%'>
					<input type='text' <%=totalDisabled %> <%=disabled1 %> name='timeLimitValue' id='timeLimitValue' size="4" maxlength="4" value='<%=checkForNull(policyBean.getTimeLimitValue())%>' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)">
					&nbsp;
					<select name='timeLimitType' id='timeLimitType' id='timeLimitType' <%=totalDisabled %> <%=disabled1 %> >
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='D' <%="D".equals(policyBean.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
						<option value='M' <%="M".equals(policyBean.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				</tr>
				<tr>
					<td class='label' width='30%' colspan = '2'><fmt:message key="eBL.MandChkInvoiceGen.label" bundle="${bl_labels}"/>
					&nbsp;&nbsp;
					<Select name='chkInvoiceGen' id='chkInvoiceGen' <%=totalDisabled %> <%=disabled1 %> >
						<% if(("N").equals(policyBean.getMandChkInvoiceGen())){ %>
							<option value='N' selected><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='N'><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
						<%} %>
						<% if(("I").equals(policyBean.getMandChkInvoiceGen())){ %>
							<option value='I' selected><fmt:message key="eBL.DiagnosisMR.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='I'><fmt:message key="eBL.DiagnosisMR.label" bundle="${bl_labels}"/></option>
						<%} %>
						<% if(("P").equals(policyBean.getMandChkInvoiceGen())){ %>
							<option value='P' selected><fmt:message key="eBL.DiagnosisPractioner.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='P'><fmt:message key="eBL.DiagnosisPractioner.label" bundle="${bl_labels}"/></option>
						<%} %>
						
					</Select>
					</td>  
					
					<!-- V221017 -->
					<%if("Y".equals(MFDRMandYN) && ("Y".equals(MFDRDrugCatEnabledYN) || "Y".equals(MFDRDiagCatEnabledYN))){%>
					<td class='label' width='30%' colspan = '2'>
					<input type="checkbox" name='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' <%=totalDisabled %> 
					 <%= "Y".equals(policyBean.getMultiFactorDeductRuleYN()) ? "checked":"" %> onclick="fnCheckMFDREnableDisable('chk','multiFactorDeductRuleYN','pat_Limit_Amt');" >&nbsp;<fmt:message key="eBL.MultiFactorDeductibleRule.label" bundle="${bl_labels}"/>
					&nbsp;
					</td>
					<%if("Y".equals(MFDRDrugCatEnabledYN)){%>
					<td class='label' width='30%' colspan = '2'><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='pat_Limit_Amt' id='pat_Limit_Amt' <%= "Y".equals(policyBean.getMultiFactorDeductRuleYN()) ? "":"disabled" %> <%=totalDisabled %> onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getMFDRPatLimitAmt())%>' size='7' maxlength='10'>
					</td>
					<%}else{%>
					<input type='hidden' name='pat_Limit_Amt' id='pat_Limit_Amt' value = "0">
					<%}%>


					<%}else{%>
					<td class='label' width='30%' colspan = '2'>
					<input type="checkbox" disabled name='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' ><fmt:message key="eBL.MultiFactorDeductibleRule.label" bundle="${bl_labels}"/>
					</td>
					<td class='label' width='30%' colspan = '2'><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='pat_Limit_Amt' id='pat_Limit_Amt' disabled size='7' maxlength='10'>
					</td>
					
					<%}%>

					<!-- V221017 -->
					
					
				</tr>
				<%}
				else if("Inpatient".equals(prevTab) || "External".equals(prevTab)){%>
					<input type="hidden" name='encGrpIdSameEpsd' id='encGrpIdSameEpsd' id='encGrpIdSameEpsd'>
					<td class='label' width='25%' colspan='2'>
					<%if("Inpatient".equals(prevTab)){ %>
					<fmt:message key="eBL.TimeLimitDefaultGrp.label" bundle="${bl_labels}"/>
					&nbsp;&nbsp;
					<input type='text' <%=totalDisabled %> <%=disabled1 %> <%=disabled1 %> name='timeLimitValue' id='timeLimitValue' size="4" maxlength="4" value='<%=checkForNull(policyBean.getTimeLimitValue())%>' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)">
					&nbsp;
					<select name='timeLimitType' id='timeLimitType' id='timeLimitType' <%=totalDisabled %> <%=disabled1 %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='D' <%="D".equals(policyBean.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
						<option value='M' <%="M".equals(policyBean.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>
					<%}else{ %>
					<input type="hidden" name='timeLimitType' id='timeLimitType' id='timeLimitType'>
					<input type="hidden" name='timeLimitValue' id='timeLimitValue' id='timeLimitValue'>
					<%} %>
				</td>
					<td class='label' width='17%' ><fmt:message key="eBL.MandChkInvoiceGen.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='13%'>
					<Select name='chkInvoiceGen' id='chkInvoiceGen' <%=totalDisabled %> <%=disabled1 %> >
						<% if(("N").equals(policyBean.getMandChkInvoiceGen())){ %>
							<option value='N' selected><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='N'><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
						<%} %>
						<% if(("I").equals(policyBean.getMandChkInvoiceGen())){ %>
							<option value='I' selected><fmt:message key="eBL.DiagnosisMR.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='I'><fmt:message key="eBL.DiagnosisMR.label" bundle="${bl_labels}"/></option>
						<%} %>
						<% if(("P").equals(policyBean.getMandChkInvoiceGen())){ %>
							<option value='P' selected><fmt:message key="eBL.DiagnosisPractioner.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='P'><fmt:message key="eBL.DiagnosisPractioner.label" bundle="${bl_labels}"/></option>
						<%} %>
						
					</Select>
				</td>   	
				</tr>
				<tr>
					<!-- V230105 -->
					<%if("Inpatient".equals(prevTab)){%>
					<%if("Y".equals(MFDRMandYN) && "Y".equals(MFDRDiagCatEnabledYN)){%>
					<td class='label' width='30%' colspan = '2'>
					<input type="checkbox" name='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' <%=totalDisabled %> 
					 <%= "Y".equals(policyBean.getMultiFactorDeductRuleYN()) ? "checked":"" %> >&nbsp;<fmt:message key="eBL.MultiFactorDeductibleRule.label" bundle="${bl_labels}"/>
					&nbsp;
					</td>
					<input type='hidden' name='pat_Limit_Amt' id='pat_Limit_Amt' value = "0">
					</td>


					<%}else{%>
					<td class='label' width='30%' colspan = '2'>
					<input type="checkbox" disabled name='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' id='multiFactorDeductRuleYN' ><fmt:message key="eBL.MultiFactorDeductibleRule.label" bundle="${bl_labels}"/>
					</td>
					<td class='label' width='30%' colspan = '2'>
					<input type='hidden' name='pat_Limit_Amt' id='pat_Limit_Amt' value = "0">
					</td>
					
					<%}%>
					<%}%>

					<!-- V230105 -->				
				</tr>
				<%}
				else{%>
				<%} %>
			
      	</table>
      	<input type='hidden' name='prevTab' id='prevTab' value='<%= prevTab%>'>
      	<input type='hidden' name='mode' id='mode' value='<%= mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id%>'>
	<!-- Added against NMC-JD-CRF-0045 by Priya -->
	<input type='hidden' name='siteSpecPolDefservcov' id='siteSpecPolDefservcov' id='siteSpecPolDefservcov' value="<%=siteSpecPolDefservcov %>">
	<input type='hidden' name='pageInfo' id='pageInfo' id='pageInfo' value='servtabdet'>
	<!-- Added against NMC-JD-CRF-0045 by Priya 28-08-2020 -->
     </form>
     <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
     %>
</body>
</html>

