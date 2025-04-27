<!DOCTYPE html>
<!-- Page Added by Rajesh V. Policy Definition Header -->
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V210824			21883			MMS-ME-SCF-0031-TF			Mohana/MuthuN
----------------------------------------------------------------------------------------------
-->

<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String mode = checkForNull(request.getParameter("mode"));
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode"));
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function callPolicy(){ // karthik added code
	var dialogUrl       = "../../eBL/jsp/PolicyDetailsResultFrame.jsp" ;
	var dialogFeatures  = "dialogHeight:" + "30" + "; dialogWidth:" + "75" +" ; scroll=auto; ";
	window.showModalDialog(dialogUrl,null,dialogFeatures);		
//	window.close();
//	var returnVal = window.showModalDialog(dialogUrl,null,dialogFeatures);		
//callDefaultPolicy();
//setTimeout("callDefaultPolicy();",1200);
//alert(this.window.name);
//this.window.close();
}
</script>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
con = ConnectionManager.getConnection(request);
String readonly = "";
String disabled = "";
String totaldisabled = "";
String auth = "";
try{
PolicyInsuranceMasterBean policyBean = new PolicyInsuranceMasterBean();
	if ("modify".equals(mode) ) {
		try{
			readonly = "readonly";
			disabled = "disabled";
			totaldisabled = "disabled";	
			auth = "N";
			String sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEF_HDR_INFO");
			System.err.println("RcrdApprovalPolicyInfoFrame.jsp==sqlInfoPage==>"+sqlInfoPage);
			pstmt = con.prepareStatement(sqlInfoPage);
			//V210824
			pstmt.setString(1,payer);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,payerGroup);
			pstmt.setString(4,payer);
			pstmt.setString(5,policy);
			//V210824
			rst = pstmt.executeQuery();
			//System.err.println(facility_id+"::"+payerGroup+"::"+"::"+payer+"::"+policy);
			if(rst != null){
				while(rst.next()){
					policyBean.setPayerGroup(rst.getString("payer_group"));
					policyBean.setPayerGroupCode(rst.getString("CUST_GROUP_CODE"));
					policyBean.setPayer(rst.getString("payer"));
					policyBean.setPayerCode(rst.getString("CUST_CODE"));
					policyBean.setPolicyType(rst.getString("policy_type"));
					policyBean.setPolicyTypeCode(rst.getString("POLICY_TYPE_CODE"));
					policyBean.setCoverageBasis(rst.getString("policy_coverage_basis"));
					policyBean.setCoverageRules(rst.getString("payer_cov_rule"));
					policyBean.setCoveragePer(rst.getString("copay_perc"));
					policyBean.setStartDateChk(rst.getString("def_req_policy_dates"));
					policyBean.setExpiryDays(rst.getString("addl_days_policy_expdt"));
					policyBean.setFacilityId(rst.getString("operating_facility_id"));
					policyBean.setPolicySettlementApplicability(rst.getString("slmt_appl_yn"));
					policyBean.setStartDate(rst.getString("effective_from"));
					policyBean.setEndDate(rst.getString("effective_to"));
					policyBean.setScreeningPolicy(rst.getString("screening_policy_yn"));
				}
				rst.close();
			}
			pstmt.close();
		}
		catch(Exception e){
			System.err.println("Exception in Info Frame Load - "+e);
		}
		finally{
			//ConnectionManager.returnConnection(con);
		}
	}
	else{
		auth="Y";
	}


%>
	<form   id='frmPolicyInfo' >	
      	<table width='95%' cellpadding='3'  cellspacing=0 align="center">  
      		<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<Select name='facility' id='facility' <%=disabled %>>
						<!--<option value='HS'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>-->
						<%
						
						try{
							String sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E' and facility_id = ? ";
						
							pstmt = con.prepareStatement(sqlFacility);
							pstmt.setString(1,facility_id);
							rst = pstmt.executeQuery();
							
							if(rst != null){
								while(rst.next()){ 
									if(rst.getString("facility_id").equals(policyBean.getFacilityId())){
							%>
								<option selected value='<%=rst.getString("facility_id") %>'><%=rst.getString("facility_name") %></option>
								<%}
									else{%>
										<option value='<%=rst.getString("facility_id") %>'><%=rst.getString("facility_name") %></option>
									<%}
								}
								rst.close();
							}
							pstmt.close();
						}
						catch(Exception e){
							System.err.println("Exception in Info Frame Load - "+e);
						}
						finally{
							//ConnectionManager.returnConnection(con);
						}
						%>
					</Select>
				</td>                                  
				<td width='25%' nowrap class='label' ><fmt:message key="eBL.ScreeningPolicy.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
				<%if("Y".equals(policyBean.getScreeningPolicy())){ %>
					<input type="checkbox" <%=totaldisabled %> checked name='screeningPolicy'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%}
				else{%>
					<input type="checkbox" <%=totaldisabled %> name='screeningPolicy'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%} %>
					<fmt:message key="Common.YesNo.label" bundle="${common_labels}"/>
				</td>
			</tr>
			<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<input type='text' name='payerGroup2' id='payerGroup2' size='40' maxlength='40' <%=disabled %> value='<%=checkForNull(policyBean.getPayerGroup()) %>'' onblur='if(this.value!=""){ callCommonValidation(3,payerGroup2,payerCode2); validatePolicy(payerCode2,payerCode,policyTypeCode)}'/>
					<input type='hidden' name='payerCode2' id='payerCode2' value='<%=checkForNull(policyBean.getPayerGroupCode()) %>''>
					<input type='button' class='button' name="payerGroup2_btn" id="payerGroup2_btn" value='?' <%=disabled %> onClick="callCommonValidation(3,payerGroup2,payerCode2);validatePolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>   
				                               
				<td width='25%' nowrap class='label' ><fmt:message key="eBL.PolicySettlementApplicability.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
				<%if("Y".equals(policyBean.getPolicySettlementApplicability())){ %>
					<input type="checkbox"  <%=totaldisabled %> checked name='settlementApplicability'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%}
				else{%>
					<input type="checkbox"  <%=totaldisabled %> name='settlementApplicability'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%} %>
					<fmt:message key="Common.YesNo.label" bundle="${common_labels}"/>
				</td>
			</tr>
			 <tr>
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<input type='text' name='payerGroup1' id='payerGroup1' size='40' maxlength='40' <%=disabled %> value='<%=checkForNull(policyBean.getPayer()) %>' onblur='if(this.value!=""){ callCommonValidation(2,payerGroup1,payerCode);validatePolicy(payerCode2,payerCode,policyTypeCode);}'/>
					<input type='hidden' name='payerCode' id='payerCode' value='<%=checkForNull(policyBean.getPayerCode()) %>'>
					<input type='button' class='button' name="payerGroup1_btn" id="payerGroup1_btn" value='?' <%=disabled %> onClick="callCommonValidation(2,payerGroup1,payerCode);validatePolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>                                  
				<td width='25%' nowrap class='label' ><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='startDate' id='startDate'  <%=totaldisabled %> size='10' maxlength='10' onBlur='isValidDate(this);compareDates(startDate,endDate);defaultDate("startDate",startDate);' value='<%=checkForNull(policyBean.getStartDate()) %>' />
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totaldisabled %> id='startDate_ctrl' onClick="return showCalendar('startDate');" />
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<input type='text' name='policyType' id='policyType' size='40' maxlength='40' <%=disabled %> value='<%=checkForNull(policyBean.getPolicyType()) %>' onblur='if(this.value!=""){ callCommonValidation(4,policyType,policyTypeCode);validatePolicy(payerCode2,payerCode,policyTypeCode);}'/>
					<input type='hidden' name='policyTypeCode' id='policyTypeCode' value='<%=checkForNull(policyBean.getPolicyTypeCode())%>'>
					<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' <%=disabled %> onClick="callCommonValidation(4,policyType,policyTypeCode);validatePolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>                                  
				<td width='25%' nowrap class='label' ><fmt:message key="eBL.PolicyEndDate.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='endDate' id='endDate'  <%=totaldisabled %> size='10' maxlength='10' onBlur='isValidDate(this);compareDates(startDate,endDate);defaultDate("endDate",endDate);' value='<%=checkForNull(policyBean.getEndDate()) %>' />
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totaldisabled %> id='endDate_ctrl' onClick="return showCalendar('endDate');" />
				</td>
			</tr>
			<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.PolicycoverageBasis.label" bundle="${bl_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<Select name='coverageBasis' id='coverageBasis' <%=totaldisabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("I".equals(policyBean.getCoverageBasis())){ %>
							<option value='I' selected><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>
						<%} else{%>
							<option value='I'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("P".equals(policyBean.getCoverageBasis())){ %>
							<option value='P' selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<%} else{%>
							<option value='P'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<%} %>
						
						
					</Select>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>                                  
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.PolicycoverageRules.label" bundle="${bl_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<Select name='coverageRules' id='coverageRules' <%=totaldisabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("S".equals(policyBean.getCoverageRules())){ %>
							<option value='S' selected><fmt:message key="eBL.SoleCoverage.label" bundle="${bl_labels}"/></option>
						<%} else{%>
							<option value='S'><fmt:message key="eBL.SoleCoverage.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("O".equals(policyBean.getCoverageRules())){ %>
							<option value='O' selected><fmt:message key="eBL.SharedCoverage.label" bundle="${bl_labels}"/></option>
						<%} else{%>
							<option value='O'><fmt:message key="eBL.SharedCoverage.label" bundle="${bl_labels}"/></option>
						<%} %>
						
					</Select>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.CoveragePercent.label" bundle="${bl_labels}"/></td>
				<td width='30%' nowrap class='fields' >
					<input type='text' name='percent' id='percent'  <%=totaldisabled %> size='5' maxlength='3' onkeypress="return checkAlpha(event)" onblur="checkForPer(this)" value='<%=checkForNull(policyBean.getCoveragePer())%>'/>
				</td>                                  
				<td width='25%' nowrap class='label' ><fmt:message key="eBL.DefPolicyStartDate.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<%if("Y".equals(policyBean.getStartDateChk())){ %>
					<input type="checkbox"  <%=totaldisabled %> checked name='startDateChk' /></td>
				<%} else{ %>
					<input type="checkbox"  <%=totaldisabled %> name='startDateChk' /></td>
				<%} %>
				
				<td width='25%' nowrap class='fields' >
					<fmt:message key="eBL.PolicyExpDays.label" bundle="${bl_labels}"/>
					&nbsp;&nbsp;&nbsp;<input type='text'  <%=totaldisabled %> name='expDays' size='5' maxlength='4' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%= checkForNull(policyBean.getExpiryDays())%>'/>
				</td>
			</tr>
      	</table>
      	      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      			<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
      			<input type='hidden' name='auth' id='auth' value='<%=auth %>'>
     </form>
<%}
catch(Exception e){
	System.err.println("Exception in Info Frame Load - "+e);
}
finally{
	ConnectionManager.returnConnection(con);
}
%>
</body>
</html>

