<!DOCTYPE html>
<!-- Page Added by Rajesh V. Policy Definition Header -->
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 210727			    21718			 MOHE-SCF-0125-TF	    	Mohana Priya K
2			 V210824			21883			MMS-ME-SCF-0031-TF			Mohana/MuthuN
3		V211027/V211101             18595			 MMS-DM-CRF-0185			Mohana Priya K
4			V211103			25297		PMG2021-MMS-CRF-0004-TF-US001/01-Hyper link   Mohana Priya K
5			V220324				27973			MMS-ME-SCF-0046-TF			Mohana Priya K				
----------------------------------------------------------------------------------------------
-->

<%@page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@page import="java.sql.*"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
	//V220324 Starts
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220324 ends
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String mode = checkForNull(request.getParameter("mode"));
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	//Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode")); 
	//Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String calledForm = request.getParameter("calledForm") == null ? "" : request.getParameter("calledForm");//Added V191016-Aravindh/NMC-JD-CRF-0010.2
	System.err.println("calledForm--->"+calledForm);
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String strLoggedUser = p.getProperty("login_user");
	if(strLoggedUser == null) strLoggedUser="";
	String blremarks="";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

$(document).ready(function()
{
	//Commented V182704-Subha/AAKH-SCF-0358
	// $('#tdexpdays').hide();
	//Added V182704-Subha/AAKH-SCF-0358/Starts
	if(!$('#siteSpec').val()) {
		$('#tdexpdays').hide();
	}
	//Added V182704-Subha/AAKH-SCF-0358/Ends
	var calledForm = document.forms[0].calledForm.value;
	if("policyApproval" == calledForm) {
		document.forms[0].auth.value = "Y";
		$('#copy_policy').prop('disabled', true);
		if(document.forms[0].siteSpecPolApprv.value == "true") {
			doUserAuthenticationValidationPayerApprove('<%=strLoggedUser%>');
        	document.forms[0].policyApprvdYN.disabled = false;
        }
	}
});		

function callPolicy(){
	var dialogUrl       = "../../eBL/jsp/PolicyDetailsResultFrame.jsp" ;
	var dialogFeatures  = "dialogHeight:" + "30" + "; dialogWidth:" + "75" +" ; scroll=auto; ";
	window.showModalDialog(dialogUrl,null,dialogFeatures);		
}
//Added against NMC-JD-CRF-0045 Starts 26-08-2020
function validategppolicy(payergp,payer,policy){
	var siteSpecRmrk=document.getElementById("siteSpecPolDefIncExc").value;
	if(siteSpecRmrk=="true"  || siteSpecRmrk==true){//Added against NMC-JD-CRF-0045 28/08/2020
		var payergp=payergp.value;
		var payer=payer.value;
		var policy=policy.value;
		if(payergp!='' && payer!='' && policy!=''){
			if((payergp!='**' && payer=='**' && policy=='**')||(payergp!='**' && payer!='**' && policy=='**')){
				document.getElementById('GroupPolicy').disabled=false;
			}else{
				document.getElementById('GroupPolicy').checked=false;
				document.getElementById('GroupPolicy').disabled=true;			
			}
		}else{
			document.getElementById('GroupPolicy').checked=false;
			document.getElementById('GroupPolicy').disabled=true;			
		}
	}
}

$(document).on('change', 'input[name="GroupPolicy"]', function() {
    if(this.checked){     
			document.getElementById('GroupPolicy1').value="Y";   
			groupPolicyChkd();
    } else {
			document.getElementById('GroupPolicy1').value="N";
			groupPolicyUnChkd();
    }
}); 
//Added against NMC-JD-CRF-0045 Ends 26-08-2020
/* 
* Karthik added the below Function to prevent popup from asking User Credentials Again
* The String AuthenticatedUser will be compared to prevent popup
*/
function validateUserForPolicy(){
	if(doUserAuthenticationValidationMain()==true){
		authUser("AuthenticatedUser");
	}		
}

</script>
</head>
<% if("policyApproval".equals(calledForm)) { %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<% } else { %>
	<body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<% } %>
<%
	con = ConnectionManager.getConnection(request);
	String readonly = "";
	String disabled = "";
	String totaldisabled = "";
	String disable = "";	//Added against NMC-JD-CRF-0045 by Priya
	String auth = "";
	Boolean siteSpec=false;  //Added By Vijay For MMS-QF-SCF-567
	Boolean siteSpecPolEndDate = false; //Added By Subha For AAKH-SCF-0358
	Boolean siteSpecRefPrice = false; //Added V181003-Aravindh/AAKH-CRF-0107
	Boolean siteSpecPolApprv = false; //Added V190517-Aravindh/NMC-JD-CRF-0010
	Boolean siteSpecClaimExist = false;//Added V190701 MuthuN/NMC-JD-CRF-0002.1
	Boolean siteSpecPolDefRemarks=false;//Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1
	Boolean siteSpecPayrRefcode=false;//V211027
	try{
 
	//Added By Vijay For MMS-QF-SCF-567
	try
	{		
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DONT_DFLT_POL_EXP_DAYS_CONFIG");
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in site specific "+e);
	}
	//---------- ends -------

	//Added V180529-Subha/AAKH-SCF-0358/Starts
	try{
		siteSpecPolEndDate = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","SET_DFLT_POL_END_DATE");
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
		siteSpecClaimExist = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POL_CLAIM_AGRRED_EXIST_YN");//Added V190701 MuthuN/NMC-JD-CRF-0002.1
		siteSpecPolDefRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");//Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1
		siteSpecPayrRefcode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","TO_ENABLE_PAYER_REF_CODE_IN_PD"); //V211027
		siteSpecPayrRefcode=true;
		System.err.println("siteSpecPayrRefcode "+siteSpecPayrRefcode);
		//Added V190517-Aravindh/NMC-JD-CRF-0010/Starts
		String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facility_id+"'";
		pstmt = con.prepareStatement(polApprvSql);
		rst = pstmt.executeQuery();
		while(rst.next()) {
			String enablePolicyApprvl = rst.getString("enable_policy_approval_yn");
			if("Y".equals(enablePolicyApprvl)) {
				siteSpecPolApprv = true;
			}
		}
		rst.close();
		pstmt.close();
		//Added V190517-Aravindh/NMC-JD-CRF-0010/Ends
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in site specific PolEndDate: "+e);
		}
		//Added V180529-Subha/AAKH-SCF-0358/Ends

	PolicyInsuranceMasterBean policyBean = new PolicyInsuranceMasterBean();
	//Added against V211103
	String called=(calledForm.equals(""))?"infoframe":calledForm;
	policyBean.setCalledfrom(called);
	//Added against V211103 Ends
	if ("modify".equals(mode)){
	try{
			readonly = "readonly";
			disabled = "disabled";
			totaldisabled = "disabled";	
			auth = "N";
			String sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEF_HDR_INFO");
			pstmt = con.prepareStatement(sqlInfoPage);
			//V210824
			pstmt.setString(1,payer);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,payerGroup);
			pstmt.setString(4,payer);
			pstmt.setString(5,policy);
			//V210824
			rst = pstmt.executeQuery();
			System.err.println(facility_id+"::"+payerGroup+"::"+"::"+payer+"::"+policy);
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
					policyBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181003-Aravindh/AAKH-CRF-0107
					policyBean.setPolicyApproved(rst.getString("policy_approved_yn"));//Added V190517-Aravindh/NMC-JD-CRF-0010
					policyBean.setclaimsAgrmtExts(rst.getString("clms_agrmt_exts"));//Added V190701 MuthuN/NMC-JD-CRF-0002.1
					//Added against NMC-JD-CRF-0045 by Priya
					if(siteSpecPolDefRemarks){
						policyBean.setGroupPolicy(rst.getString("group_policy_yn"));
					}
					//Added against NMC-JD-CRF-0045 by Priya
					System.err.println(rst.getString("payer_ref_code"));
					policyBean.setPayerReferenceCode(rst.getString("payer_ref_code"));
					//V211027
				}
				rst.close();
			}
			pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in Info Frame Load - "+e);	
		}
		finally{
			//ConnectionManager.returnConnection(con);
		}
	}
	else{
		disable = "disabled";	//Added against NMC-JD-CRF-0045 by Priya 26-08-2020
		auth="Y";
	}
%>
<form name="frmPolicyInfo" id="frmPolicyInfo" id='frmPolicyInfo' >	
    <table width='95%' cellpadding='3'  cellspacing=0 align="center">  
	  <!--Added against  NMC-JD-CRF-0045  by Priya Starts-->
	<%if(siteSpecPolDefRemarks){%>
	<tr>
	<td colspan="2"></td>
	<td width='20%' nowrap class='label' ><fmt:message key="eBL.grouppolicy.label" bundle="${bl_labels}"/></td>
		<td width='25%' nowrap class='fields' >
		<% 
		if("Y".equals(policyBean.getGroupPolicy())){
		%>
			<input type="checkbox" name="GroupPolicy" id="GroupPolicy"  onclick="$(this).attr('value', this.checked ? 'Y' : 'N')" value="Y"  <%=disable %> <%=totaldisabled %> checked /><input type="hidden" name="GroupPolicy1" id="GroupPolicy1" id="GroupPolicy1" value="Y">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%}
		else{
		%>
			<input type="checkbox" name="GroupPolicy" id="GroupPolicy"   onclick="$(this).attr('value', this.checked ? 'Y' : 'N')" value="N" <%=disable %> <%=totaldisabled %> 
			/><input type="hidden" name="GroupPolicy1" id="GroupPolicy1"  value="N"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%}%>
			<fmt:message key="Common.YesNo.label" bundle="${common_labels}"/>   
			</td>
		</tr>	
		<%}%>
	<!--Added against  NMC-JD-CRF-0045 by Priya Ends-->
    <tr>
		<td width='20%' nowrap class='label' ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td width='30%' nowrap class='fields' >
			<Select name='facility' id='facility'  <%=disabled %>>
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
					e.printStackTrace();
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
			<input type="checkbox" <%=totaldisabled %> checked name='screeningPolicy' id='screeningPolicy'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%}
		else{%>
			<input type="checkbox" <%=totaldisabled %> name='screeningPolicy' id='screeningPolicy'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%} %>
			<fmt:message key="Common.YesNo.label" bundle="${common_labels}"/>
			<!-- Added V181003-Aravindh/AAKH-CRF-0107/Starts -->
			<%if(siteSpecRefPrice) { %>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eBL.CoverReferencePrice.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<% if("Y".equals(policyBean.getCoverRefPrice())) { %>
					<input type="checkbox" name='coverRefPriceHdr'  id='coverRefPriceHdr' onclick='unCheckAllLineLvlRefChkBox()' checked/>
				<% }
				else { %>
					<input type="checkbox" name='coverRefPriceHdr' id='coverRefPriceHdr'  onclick='unCheckAllLineLvlRefChkBox()'/>
				<% }
			} %>
			<!-- Added V181003-Aravindh/AAKH-CRF-0107/Ends -->
		</td>
	</tr>
	<tr>
		<td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
		<td width='30%' nowrap class='fields' >
			<input type='text' name='payerGroup2'  id='payerGroup2' size='40' maxlength='40' <%=disabled %> value='<%=checkForNull(policyBean.getPayerGroup()) %>'  onblur='if(this.value!=""){ callCommonValidation(3,payerGroup2,payerCode2); validatePolicy(payerCode2,payerCode,policyTypeCode);validategppolicy(payerCode2,payerCode,policyTypeCode);}else{fnClearCode(payerCode2);validategppolicy(payerCode2,payerCode,policyTypeCode);}'/>
			<input type='hidden' name='payerCode2'  id='payerCode2' value='<%=checkForNull(policyBean.getPayerGroupCode()) %>''>
			<input type='button' class='button' name="payerGroup2_btn"  id="payerGroup2_btn" value='?' <%=disabled %> onClick="callCommonValidation(3,payerGroup2,payerCode2);validatePolicy(payerCode2,payerCode,policyTypeCode);
			validategppolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
			<img src='../../eCommon/images/mandatory.gif'>
		</td>   
									   
		<td width='25%' nowrap class='label' ><fmt:message key="eBL.PolicySettlementApplicability.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
			<%if("Y".equals(policyBean.getPolicySettlementApplicability())){ %>
				<input type="checkbox"  <%=totaldisabled %> checked name='settlementApplicability' id='settlementApplicability'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%}
			else{%>
				<input type="checkbox"  <%=totaldisabled %> name='settlementApplicability' id='settlementApplicability'  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%} %>
				<fmt:message key="Common.YesNo.label" bundle="${common_labels}"/>
		</td>		
	</tr>
	<tr>
		<td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
		<td width='30%' nowrap class='fields' >
			<input type='text' name='payerGroup1' id='payerGroup1' size='40' maxlength='40' <%=disabled %> value='<%=checkForNull(policyBean.getPayer()) %>'  onblur='if(this.value!=""){ callCommonValidation(2,payerGroup1,payerCode);validatePolicy(payerCode2,payerCode,policyTypeCode);validategppolicy(payerCode2,payerCode,policyTypeCode);}else{fnClearCode(payerCode);validategppolicy(payerCode2,payerCode,policyTypeCode);}'/>
			<input type='hidden' name='payerCode' id='payerCode'  value='<%=checkForNull(policyBean.getPayerCode()) %>'>
			<input type='button' class='button' name="payerGroup1_btn"  id="payerGroup1_btn" value='?' <%=disabled %> onClick="callCommonValidation(2,payerGroup1,payerCode);validatePolicy(payerCode2,payerCode,policyTypeCode);
			validategppolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
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
			<input type='text' name='policyType'  id='policyType' size='40' maxlength='40' <%=disabled %> value='<%=checkForNull(policyBean.getPolicyType()) %>'  onblur='if(this.value!=""){ callCommonValidation(4,policyType,policyTypeCode);validatePolicy(payerCode2,payerCode,policyTypeCode);
			validategppolicy(payerCode2,payerCode,policyTypeCode);}else{fnClearCode(policyTypeCode); validategppolicy(payerCode2,payerCode,policyTypeCode); }'/>
			<input type='hidden' name='policyTypeCode'  id='policyTypeCode' value='<%=checkForNull(policyBean.getPolicyTypeCode())%>'>
			<input type='button' class='button' name="policyType_btn"  id="policyType_btn" value='?' <%=disabled %> onClick="callCommonValidation(4,policyType,policyTypeCode);validatePolicy(payerCode2,payerCode,policyTypeCode);validategppolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
			<img src='../../eCommon/images/mandatory.gif'>
		</td>                                  
		<td width='25%' nowrap class='label' ><fmt:message key="eBL.PolicyEndDate.label" bundle="${bl_labels}"/></td>
		<td width='25%' nowrap class='fields' >
			<input type='text' name='endDate' id='endDate'  <%=totaldisabled %> size='10' maxlength='10' onBlur='isValidDate(this);compareDates(startDate,endDate);defaultDate("endDate",endDate);' value='<%=checkForNull(policyBean.getEndDate()) %>' />
			<input type='hidden' name='oldEndDate'  id='oldEndDate' value='<%=checkForNull(policyBean.getEndDate()) %>'>
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
			&nbsp;&nbsp;&nbsp;&nbsp;
			<%if("modify".equals(mode) && !"policyApproval".equals(calledForm)){					
				/* 
				 * Karthik added the below Function to prevent popup from asking User Credentials Again
				 * The String AuthenticatedUser will be compared to prevent popup
				 */
										
				out.println("<script>setTimeout('validateUserForPolicy();',500)</script>");	//Karthik added the code to validate			
			%>
			<input type="button" class='button' name="add_mod" 	id="add_mod"   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eBL.modify.label", "bl_labels")%>" onclick="authUser();"  /> <!--210727-->
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class='button' name="copy_policy" 	id="copy_policy" disabled  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eBL.copypolicy.label", "bl_labels")%>"   /> <!--210727-->
			<%}
			else{ 
			System.err.println("434");		%>
			<input type="button" class='button' name="add_mod" 	id="add_mod"  disabled value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eBL.modify.label", "bl_labels")%>" onclick="authUser();"  />
			&nbsp;&nbsp;&nbsp;&nbsp; <!--210727-->
			<input type="button" class='button' name="copy_policy" 	id="copy_policy"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eBL.copypolicy.label", "bl_labels")%>" onclick="fnCopyPolicy(payerCode2,payerCode,policyTypeCode,startDate,endDate);"  /> <!--210727-->
			<%} %>
		</td>                                  
		<td width='25%' nowrap class='label' ><fmt:message key="eBL.DefPolicyStartDate.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;
		<%if("Y".equals(policyBean.getStartDateChk())){ %>
			<input type="checkbox"  <%=totaldisabled %> checked name='startDateChk' id='startDateChk' /></td>
		<%} else{ %>
			<input type="checkbox"  <%=totaldisabled %> name='startDateChk'  id='startDateChk'/></td>
		<%} %>

		<!-- Added By Vijay For MMS-QF-SCF-567 -->
		<%if(!siteSpec){%>
		<td id='tdexpdays' width='25%' nowrap class='fields' >
			<fmt:message key="eBL.PolicyExpDays.label" bundle="${bl_labels}"/>
			&nbsp;&nbsp;&nbsp;<input type='text'  <%=disabled %> name='expDays' id='expDays' size='5' maxlength='4' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%= checkForNull(policyBean.getExpiryDays())%>'/>
		 </td>
		<%} %>
		<!-- ends  -->

		<!-- Added V190517-Aravindh/NMC-JD-CRF-0010/Starts -->
		<%if(siteSpecPolApprv) { %>
			<td width='25%' nowrap class='fields' >
				<fmt:message key="Common.Approved.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
				<input type='checkbox' name='policyApprvdYN'  id='policyApprvdYN' <%="Y".equals(policyBean.getPolicyApproved())?"checked":"" %>
					onclick = "changePolicyApprovalStatus(this)" <%=totaldisabled %> />
		</td>	
		<% } %>
		<!-- Added V190517-Aravindh/NMC-JD-CRF-0010/Ends -->

		<!-- Added for NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts -->
		<%if(siteSpecPolDefRemarks){%>
			<td>	
			<div id="remarks" style='visibility:visible'>&nbsp;<a href="#" onclick="return Remarks();"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><img id="remarksImg" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>	
			</div>
		</td>
		<% } %>
		<!-- NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends -->
		<td>
		</td>
		<td>
		</td>
		<!-- Added V190701 MuthuN/NMC-JD-CRF-0002.1 -->
		<%if(siteSpecClaimExist){%>
		<td width='25%' nowrap class='fields' >
			<fmt:message key="eBL.ClaimsAgrmtExts.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;
			<%if("Y".equals(policyBean.getclaimsAgrmtExts())){ %>
				<input type="checkbox" <%=totaldisabled %> name='ClaimsAgrmtExts' id='ClaimsAgrmtExts' checked />
			<%} else{ %>
				<input type="checkbox" <%=totaldisabled %> name='ClaimsAgrmtExts' id='ClaimsAgrmtExts' />
			<%} 
			} %>
		</td>		
		<!-- Added V190701 MuthuN/NMC-JD-CRF-0002.1 --> 
		<!--V211027-->
	</tr>
	
		<%if(siteSpecPayrRefcode){%>
		<tr>
		<td width='25%' nowrap class='fields'><fmt:message key="eBL.payer_ref_code.label" bundle="${bl_labels}"/></td>
		<td width='30%' nowrap class='fields'>	
			<input type='text' name='ref_code'  id='ref_code' size="40"  maxlength="60"  onKeyPress='return CheckForSpecChars_loc(event,this);' value ="<%= checkForNull(policyBean.getPayerReferenceCode())%>"  onBlur="ChangeUpperCase( this );return CheckForSpecChar(event,this);"  />
		</td>
		</tr>
		<% } %>

		<!--V211027-->
    </table>
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
	<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
	<input type='hidden' name='auth' id='auth' value='<%=auth %>'>
	<input type='hidden' name="siteSpec"  id="siteSpec" value="<%=siteSpec %>"> <!-- Added By Vijay For MMS-QF-SCF-567 -->
	<input type='hidden' name="siteSpecPolEndDate" id="siteSpecPolEndDate" value="<%=siteSpecPolEndDate %>"> <!-- Added By Subha For AAKH-SCF-0358 -->
	<input type='hidden' name="siteSpecPolApprv"  id="siteSpecPolApprv" value="<%=siteSpecPolApprv %>" /> <!-- Added V190517-Aravindh/NMC-JD-CRF-0010 -->
	<input type='hidden' name="successfulUser"  id="successfulUser" value="" /> <!-- Added V190517-Aravindh/NMC-JD-CRF-0010 -->
	<input type='hidden' name="validUserApprvUnApprv"  id="validUserApprvUnApprv" value="false" /> <!-- Added V190517-Aravindh/NMC-JD-CRF-0010 -->
	<input type='hidden' name="siteSpecClaimExist"  id="siteSpecClaimExist" value="<%=siteSpecClaimExist %>"> <!-- Added V190701 MuthuN/NMC-JD-CRF-0002.1 -->
	<input type='hidden' name="calledForm" id="calledForm" value="<%=calledForm%>" /> <!-- Added V191016-Aravindh/NMC-JD-CRF-0010.2 -->
	<!-- Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1 -->
	<input type="hidden" name="blremarks" id="blremarks"  value=''>
	<input type="hidden" name='payerGroup'  id='payerGroup' value='<%=payerGroup%>'>
    	<input type="hidden" name='payer' id='payer' value='<%=payer%>'> 
   	<input type="hidden" name='policy' id='policy'  value='<%=policy%>'> 
	<!-- Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1 -->
	<input type='hidden' name='pageInfo' id='pageInfo'  value='PolicyInfo'>
	<input type='hidden' name='siteSpecPolDefIncExc'  id='siteSpecPolDefIncExc' value="<%=siteSpecPolDefRemarks %>"><!--Added against NMC-JD-CRF-0045 by Priya-->
    <input type='hidden' name="siteSpecPolDefRemarks"  id="siteSpecPolDefRemarks" value="<%=siteSpecPolDefRemarks %>"><!-- Added V210517-PalaniNarayanan/NMC-JD-CRF-0010.1 -->
	<input type='hidden' name="siteSpecPayrRefcode"  id="siteSpecPayrRefcode" value="<%=siteSpecPayrRefcode %>"><!-- Added V211027 -->
    </form>
<%}
	catch(Exception e){
		System.err.println("Exception in Info Frame Load - "+e);
		e.printStackTrace();
		}
	finally{
		ConnectionManager.returnConnection(con);
	}
%>
</body>
</html>

