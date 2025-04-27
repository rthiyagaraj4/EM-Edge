<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1		    V211026	    		25297		PMG2021-MMS-CRF-0004-TF-US001/01-Hyper link   Mohana Priya K
--------------------------------------------------------------------------------------------------------
*/
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
<script language="javascript" src='../js/EncounterSpecPolicyDefnSrch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
EncounterSpecificDefinitionBean policyBean = null;
String prevTab = request.getParameter("prevTab");
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = null;
List<EncounterSpecificDefinitionBean> policyList = null; 
String checked = "";
String disabled = "";
String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));
String patientId = checkForNull(request.getParameter("patinetId"));

String visitId = checkForAlt(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForAlt(request.getParameter("priority"));
String policyNo = checkForAlt(request.getParameter("policyNo"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForAlt(request.getParameter("episodeId"));
String auth = checkForNull(request.getParameter("auth"));
String totalDisabled = "";

if("N".equals(auth)){
	totalDisabled = "disabled";
}
else if("Y".equals(auth)){
	totalDisabled = "";
}
String partSql = "";
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;

try{
	con = ConnectionManager.getConnection(request);
	policyBean = new EncounterSpecificDefinitionBean();
	policyMap = policyBean.getPolicyMap();
	
	if ("modify".equals(mode) ) {
		HashMap<String,List<EncounterSpecificDefinitionBean>> fmtDetailsMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
		EncounterSpecificDefinitionBean fmtDtlsBean = null;
		if(patientId == null || "".equals(patientId)){
			String sqlCoverage = "";
			System.err.println("73, RcrdApprovalCoverageTabDetails.jsp");
			if("Outpatient".equals(prevTab)){
				//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO"); //V211026
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_OUTPAT_INFO"); //V211026
			}
			else if("Inpatient".equals(prevTab)){
				//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO"); //V211026
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_INPAT_INFO"); //V211026
			}
			else if("External".equals(prevTab)){
				//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO"); //V211026
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_EXTERNAL_INFO"); //V211026
			}

			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
				
			if(rst!=null){
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new EncounterSpecificDefinitionBean();
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
					//fmtDtlsBean.setEncGrpIdSameEpsd(rst.getString("DFLT_ACR_ENC_GRP_FOR_SAME_EPIS"));
					policyList.add(fmtDtlsBean);
					rsCnt++;
				}

				if(rsCnt<1){
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
				}
			}
			else{
				EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				policyList.add(titleBean);
			}
		}
		else{
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
				
			String sqlCoverage = "";

			if("Outpatient".equals(prevTab)){
				sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_OUTPAT_INFO")+partSql;
			}
			else if("Inpatient".equals(prevTab)){
				sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INPAT_INFO")+partSql;
			}
			else if("External".equals(prevTab)){
				sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_EXTERNAL_INFO")+partSql;
			}

			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
				
			if(rst!=null){
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new EncounterSpecificDefinitionBean();
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
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					policyList.add(fmtDtlsBean);
					indCnt++;
						
				}
					
				if(indCnt<1){
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
				}
			}
			else{
				EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				policyList.add(titleBean);
			}	
		}		
	}
	else{
		if(policyList == null || policyList.isEmpty()){
			EncounterSpecificDefinitionBean covBean = new EncounterSpecificDefinitionBean();
			policyList = new ArrayList<EncounterSpecificDefinitionBean>();
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
%>
	<form  id="frmServiceTabDetails">	
      	<table width='100%' cellpadding='3'  cellspacing=0 align="center">  
      		<tr>
      			<td width='25%' class='label' >
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthReq()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      			
      			<input type="checkbox" <%=totalDisabled %> name='creditAuthReq' <%=checked %>><fmt:message key="eBL.CreditAuthReq.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='25%' class='label'>
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthMand()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      			<input type="checkbox" <%=totalDisabled %> name='creditAuthMand' <%=checked %>><fmt:message key="eBL.CreditAuthMand.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='25%' class='label' >
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthRef()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      			<input type="checkbox" <%=totalDisabled %> name='defaultCreditAuth' <%=checked %>><fmt:message key="eBL.CreditAuthrefNo.label" bundle="${bl_labels}"/>
      			</td>

				<td width='10%' class='label'><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/>&nbsp;</td>
      			<td width='15%' class='fields'>
					<input type='text' name='patCopay' id='patCopay' <%=totalDisabled %>  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getPatCopay())%>' size='5' maxlength='5'>
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
      			%>
      			<input type="checkbox" name='covered' id='covered' <%=totalDisabled %> disabled onclick="fnEnableDisableLimit('chk','covered','limitType');" <%=checked %>><fmt:message key="eBL.Covered.label" bundle="${bl_labels}"/>
      			</td>
				<td width='15%'>
				</td>
      			<td width='15%' class='label' >
      				<fmt:message key="eBL.CoverageType.label" bundle="${bl_labels}"/>
				</td>
      				<%if("Y".equals(checkForNull(policyBean.getCovered()))){
      					disabled = "disabled";	//Condition Altered Since it has to be always disabled
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
				<td width='17%'></td>
				<td width='13%'></td>
				<td width='15%' class='label'><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      			
					<input type='text' name='patLimitAmt' id='patLimitAmt' <%=totalDisabled %>  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getPatLimitAmt())%>' size='7' maxlength='10'>
				</td>
      		</tr>
      	      			
      		<tr>
      			<td width='15%' class='label' ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/>
      			<%if(("R").equals(policyBean.getCoverageLimitType())){ 
      				disabled = "disabled";	//Condition Altered Since it has to be always disabled
				}
				else{
					disabled = "disabled";
				}
				%>
				</td>
				<td class='fields' width='15%'>
					<Select name='approvedDays' id='approvedDays' <%=disabled %>  <%=totalDisabled %> align='left' onchange="fnEnableDisableLimit('sel','approvedDays','noOfDays');">
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
					disabled = "readonly";	//Condition Altered Since it has to be always readonly / disabled
				}
				else{
					disabled = "disabled";
				}
				%>
				<td width='15%' class='label' ><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td width='10%'>
					<input type='text' name='noOfDays' id='noOfDays' <%=disabled %> <%=totalDisabled %> onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean.getNoOfDays()) %>' size='5' maxlength='5'>
				</td> 
				
				<td width='17%' class='label' ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></td>
				<%if(("R").equals(policyBean.getCoverageLimitType())){ 
					disabled = "disabled";	//Condition Altered Since it has to be always disabled
				}
				else{
					disabled = "disabled";
				}
				%>
				
				<td width='13%'>
					<Select name='approvedAmt' id='approvedAmt' <%=disabled %> <%=totalDisabled %> onchange="fnEnableDisableLimit('sel','approvedAmt','limitAmt');">
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
					disabled = "readonly";	//Condition Altered Since it has to be always readonly / disabled
				}
				else{
					disabled = "disabled";
				}
				%>
				<td width='15%' class='label'><fmt:message key="eBL.LimitAmt.label" bundle="${bl_labels}"/>
				<input type='text' name='limitAmt' id='limitAmt' <%=disabled %> <%=totalDisabled %> onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getLimitAmt()) %>' size='5' maxlength='10'>&nbsp;&nbsp;
				<select name='AmtMode' id='AmtMode' <%=totalDisabled %>>
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
					<Select name='chkBillGen' id='chkBillGen' <%=totalDisabled %>>
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
				<td width='15%'></td>
				<td width='10%'></td>
				<td class='label' width='17%' ><fmt:message key="eBL.MandChkInvoiceGen.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='13%'>
					<Select name='chkInvoiceGen' id='chkInvoiceGen' <%=totalDisabled %>>
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
      	</table>
      	<input type='hidden' name='prevTab' id='prevTab' value='<%= prevTab%>'>
      	<input type='hidden' name='mode' id='mode' value='<%= mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>

      	<input type='hidden' name='visitId' id='visitId' value='<%= visitId%>'>
      	<input type='hidden' name='acctSeq' id='acctSeq' value='<%= acctSeq%>'>
      	<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
      	<input type='hidden' name='policyNo' id='policyNo' value='<%=policyNo%>'>
      	<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
      	<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
      	<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
     </form>
     <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
     
     private String checkForAlt(String inputString) {
  		return (inputString == null) ? "1" : inputString;
  	}
     %>
</body>
</html>

