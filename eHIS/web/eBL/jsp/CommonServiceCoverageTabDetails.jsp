<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script language="javascript" src='../js/CommonPolicyDefinition.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
String beanId = "PayerPolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
PolicyInsuranceMasterBean policyBean = null;
PolicyInsuranceMasterBean policyBeanMain = null;
String prevTab = request.getParameter("prevTab");
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
HashMap<String,PolicyInsuranceMasterBean> masterMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";
String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));

String patientId = checkForNull(request.getParameter("patientId"));
String visitId = checkForNull(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForNull(request.getParameter("priority"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));
String policyNo = checkForNull(request.getParameter("policyNo"));
String policyEncounter = checkForNull(request.getParameter("policyEncounter"));
String priorityKey = checkForNull(request.getParameter("priorityKey"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String sqlCoverage = "";
String partSql = "";

try{
	con = ConnectionManager.getConnection(request);

	policyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	masterMap = policyBeanMain.getMasterMap();
	if(!(masterMap == null || masterMap.isEmpty())){
		policyBean = masterMap.get(priorityKey);
	}
	else{
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	if(policyBean == null){
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	policyMap = policyBean.getPolicyMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(prevTab);
	}
	if ("modify".equals(mode) ) {
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			if("policy".equals(policyEncounter)){
				sqlCoverage = "";
				if("Outpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO");
				}
				else if("Inpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
				}
				else if("External".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
				}

				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,payerGroup);
				pstmt.setString(3,payer);
				pstmt.setString(4,policy);
				rst = pstmt.executeQuery();
			}
			else if("encounter".equals(policyEncounter)){
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
				}
				else if("R".equals(episodeType)){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
				}
				
				sqlCoverage = "";

				if("Outpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_OUTPAT_INFO")+partSql;
					//BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO");
				}
				else if("Inpatient".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INPAT_INFO")+partSql;
					//BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
				}
				else if("External".equals(prevTab)){
					sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_EXTERNAL_INFO")+partSql;
					//BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
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
			}
			
			
			if(rst!=null){
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
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
					if("policy".equals(policyEncounter)){
						fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounter"));
					}
					else if("encounter".equals(policyEncounter)){
						fmtDtlsBean.setPolicyApplicability("");
					}
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
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
      			
      				<input type="checkbox" disabled name='creditAuthReq' id='creditAuthReq' <%=checked %>><fmt:message key="eBL.CreditAuthReq.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='25%' class='label'>
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthMand()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      				<input type="checkbox" disabled name='creditAuthMand' id='creditAuthMand' <%=checked %>><fmt:message key="eBL.CreditAuthMand.label" bundle="${bl_labels}"/>
      			</td>
      			<td width='30%' class='label' >
      			<%if("Y".equals(checkForNull(policyBean.getCreditAuthRef()))){
      				checked = "checked";
      			}
      			else{
      				checked = "";
      			}
      			%>
      				<input type="checkbox" disabled name='defaultCreditAuth' id='defaultCreditAuth' <%=checked %>><fmt:message key="eBL.CreditAuthrefNo.label" bundle="${bl_labels}"/>
      			</td>

				<td width='9%' class='label'><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/>&nbsp;
      			</td width='6%' class='fields'>
      			<td>
					<input type='text' name='patCopay' id='patCopay' readonly  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getPatCopay())%>' size='5' maxlength='5'>
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
      				<input type="checkbox" name='covered' id='covered' disabled onclick="fnEnableDisableLimit('chk','covered','limitType');" <%=checked %>><fmt:message key="eBL.Covered.label" bundle="${bl_labels}"/>
      			</td>
				<td width='15%'>
				</td>
      			<td width='15%' class='label' >
      				<fmt:message key="eBL.CoverageType.label" bundle="${bl_labels}"/>
				</td>
      				<%/*if("Y".equals(checkForNull(policyBean.getCovered()))){
      					disabled = "";
    				}
    				else{
    					disabled = "disabled";
    				}*/

					disabled = "disabled";
					//As we are not allowing the user to Change the Coverage Limit Type
    				%>
				<td width='10%' class='fields'>
      					<Select name='limitType' id='limitType' onchange="fnEnableDisableDays('limitType','approvedDays','approvedAmt');" <%=disabled %>>
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
				<td width='15%' class='label'><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;
      			
					<input type='text' name='patLimitAmt' id='patLimitAmt' readonly  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean.getPatLimitAmt())%>' size='7' maxlength='10'>
				</td>
      		</tr>
      	      			
      		<tr>
      			<td width='15%' class='label' ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/>
      			<%/*if(("R").equals(policyBean.getCoverageLimitType())){ 
      				disabled = "";
				}
				else{
					disabled = "disabled";
				}*/
				disabled = "disabled";
				//As we are not allowing the user to Change the Approved Days Limit Type
				%>
				</td>
				<td class='fields' width='15%'>
					<Select name='approvedDays' id='approvedDays' <%=disabled %>  align='left' onchange="fnEnableDisableLimit('sel','approvedDays','noOfDays');">
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
					//disabled = "";
					disabled = "readonly";
					//As we are not allowing the user to Edit the Approved Days
				}
				else{
					disabled = "disabled";
				}
				%>
				<td width='15%' class='label' ><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td width='10%'>
					<input type='text' name='noOfDays' id='noOfDays' <%=disabled %> onkeypress="return checkAlpha(event)" value='<%=checkForNull(policyBean.getNoOfDays()) %>' size='5' maxlength='5' onblur="checkForNumber(this)" >
				</td> 
				
				<td width='17%' class='label' ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></td>
				<%/*if(("R").equals(policyBean.getCoverageLimitType())){ 
					disabled = "";
				}
				else{
					disabled = "disabled";
				}*/
				disabled = "disabled";
				//As we are not allowing the user to Change the Approved Amount Limit Type
				%>
				
				<td width='13%'>
					<Select name='approvedAmt' id='approvedAmt' <%=disabled %> onchange="fnEnableDisableLimit('sel','approvedAmt','limitAmt');">
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
					//disabled = "";
					disabled = "readonly";
					//As we are not allowing the user to Edit the Approved Amount
				}
				else{
					disabled = "disabled";
				}
				%>
				<td width='15%' class='label'><fmt:message key="eBL.LimitAmt.label" bundle="${bl_labels}"/>
				<input type='text' name='limitAmt' id='limitAmt' <%=disabled %> onkeypress="return checkForSpecChars(event)" value='<%=checkForNull(policyBean.getLimitAmt()) %>' size='5' maxlength='10' onblur="checkForNumberDecimal(this)" >&nbsp;&nbsp;
				<select name='AmtMode' id='AmtMode' disabled>
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
					<Select name='chkBillGen' id='chkBillGen' disabled>
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
					<Select name='chkInvoiceGen' id='chkInvoiceGen' disabled>
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
      	<input type='hidden' name='priorityKey' id='priorityKey' value='<%=priorityKey%>'>
      	<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
		<input type='hidden' name='visitId' id='visitId' value='<%=visitId%>'>
		<input type='hidden' name='acctSeq' id='acctSeq' value='<%=acctSeq%>'>
		<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
		<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
		<input type='hidden' name='policyNo' id='policyNo' value='<%=policyNo%>'>
		<input type='hidden' name='policyEncounter' id='policyEncounter' value='<%=policyEncounter%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
     </form>
     <%!
     private String checkForNull(String inputString) {
    	 if(inputString==null || inputString.equals("null"))
    			  return "";    	 
 		return  inputString;
 	}
     %>
</body>
</html>

