<!DOCTYPE html>
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
			
	String title = request.getParameter("title");
	String readonly = "";
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=title %></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
String beanId = "bl_PolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
PolicyInsuranceMasterBean policyBean = null;
String prevTab = "preApproval";
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";

String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String totalDisabled = "";
String auth = "";
//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
Boolean SiteSpec_PreappDur=false;
String Site_PreappDur ="N";
Boolean SiteSpec_ServLevelRqd=false;
String Site_ServLevelRqd="N";
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
Boolean SiteSpec_preapp_across_enc=false;
String Site_preapp_across_enc="N";
//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
auth = checkForNull(request.getParameter("auth"));
//Delete Definitions
PolicyInsuranceMasterBean deletedPolicyBean = null;
HashMap<String,List<PolicyInsuranceMasterBean>> deletedPolicyMap = null;
List<PolicyInsuranceMasterBean> deletedPolicyList = null; 
//Delete Definitions
//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
Boolean SiteSpecGroupService = false;
String SiteSpecGroupServiceInd = "";
//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
/*

String SiteSpecGroupServiceInd = "";
SiteSpecGroupServiceInd= request.getParameter("SiteSpecGroupServiceInd");
System.out.println("BL_GROUP_SRVICE_IND ===PREE APPROVAL"+SiteSpecGroupServiceInd);*/
try{
	con = ConnectionManager.getConnection(request);
	policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	SiteSpec_ServLevelRqd = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","SERV_LEVEL_REQD");	
	if(SiteSpec_ServLevelRqd){
		Site_ServLevelRqd ="Y";
	}
	else{
		Site_ServLevelRqd ="N";
	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	SiteSpec_preapp_across_enc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_PREAPP_ACR_ENT_YN");
	if(SiteSpec_preapp_across_enc){
		Site_preapp_across_enc ="Y";
	} else{
		Site_preapp_across_enc ="N";
	}
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
	policyMap = policyBean.getPolicyMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(prevTab);
	}
	
	//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
	
	SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_GROUP_SRVICE_IND");
	if (SiteSpecGroupService) {
		SiteSpecGroupServiceInd = "Y";
	} else {
		SiteSpecGroupServiceInd = "N";
	}

	//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
	
	//Delete Definitions
			deletedPolicyBean = (PolicyInsuranceMasterBean) getBeanObject("DeletedPolicyBean", beanName, request);
			deletedPolicyMap = deletedPolicyBean.getPolicyMap();
			if(!(deletedPolicyMap == null || deletedPolicyMap.isEmpty())){
				deletedPolicyList = deletedPolicyMap.get(prevTab);
			}
		//Delete Definitions
	if ("modify".equals(mode) ) {
		totalDisabled = "disabled";
		if("Y".equals(auth)){
			totalDisabled = "";
		}
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			if(deletedPolicyList == null || deletedPolicyList.isEmpty()){
				/*String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_PREAPPROVAL_DTL");


				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,payerGroup);
				pstmt.setString(7,payer);
				pstmt.setString(8,policy);
				rst = pstmt.executeQuery();
				
				if(rst!=null){
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					int rsCnt = 0;
					while (rst.next()) {
						fmtDtlsBean = new PolicyInsuranceMasterBean();
						fmtDtlsBean.setPatClass(rst.getString("patient_class"));
						fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
						fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
						fmtDtlsBean.setGender(rst.getString("SEX"));
						fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
						fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
						fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
						fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
						fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
						fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
						fmtDtlsBean.setType(rst.getString("serv_excl_incl_crit"));
						fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
						fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
						fmtDtlsBean.setPreApprAmtCapping(rst.getString("preapproval_amt_capping"));
						fmtDtlsBean.setPreApprQtyCapping(rst.getString("preapproval_qty_capping"));
						fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
						fmtDtlsBean.setSplitReqd(rst.getString("ALLOW_SPLIT_IF_NO_APPROVAL"));
						fmtDtlsBean.setStatus("U");
						policyList.add(fmtDtlsBean);
						rsCnt++;					
					}
					if(rsCnt<1){
						policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
						PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						titleBean.setSplitReqd("Y");
						policyList = new ArrayList<PolicyInsuranceMasterBean>();
						policyList.add(titleBean);
						policyMap.put(prevTab, policyList);
					}
				}
				else{
					policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					titleBean.setStartDate(startDate);
					titleBean.setEndDate(endDate);
					titleBean.setSplitReqd("Y");
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);
				}*/
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				titleBean.setStartDate(startDate);
				titleBean.setEndDate(endDate);
			if("N".equals(Site_ServLevelRqd)){
				titleBean.setSplitReqd("Y");
			}
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				policyList.add(titleBean);
			}
			//Delete Definition
			else{
				policyList.add(new PolicyInsuranceMasterBean());
			}
			//Delete Definition			
			
		}

		
	}
	else{
		if(policyList == null || policyList.isEmpty()){
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
			covBean.setStartDate(startDate);
			covBean.setEndDate(endDate);
				if("N".equals(Site_ServLevelRqd)){
			covBean.setSplitReqd("Y");
				}
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(covBean);
			
		}
	}
		
	pstmt = null;
	rst = null;
	String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
	pstmt = con.prepareStatement(inclExclSql);
	pstmt.setString(1,locale);
	rst = pstmt.executeQuery();
	inclExclDesc = "";
	inclExclCode = "";
	if(rst!=null){
		while(rst.next()){
			criteriaMap.put(rst.getString("code"),rst.getString("description"));
			inclExclDesc = inclExclDesc+":::"+rst.getString("description");
			inclExclCode = inclExclCode+":::"+rst.getString("code");
		}	
	}
	
	inclExclDesc = inclExclDesc.substring(3);
	inclExclCode = inclExclCode.substring(3);
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	SiteSpec_PreappDur = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_PRE_APP_DUR_CAPPING");	
	if(SiteSpec_PreappDur){
		Site_PreappDur ="Y";
	}
	else{
		Site_PreappDur ="N";
	}
	System.out.println("Site_PreappDur "+Site_PreappDur);
	
	 //Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	
}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}
%>
	<form  id="frmPolicyInclExclCoverage">	
      	<table width='170%' cellpadding='3' class='grid' border='1' cellspacing=0 align="center" id="PolicyPreApproval">  
      		<tr>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>				
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNu.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNuDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.SpecDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PreAppAmtCap.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PreAppQtyCap.label" bundle="${bl_labels}"/></td>
			<%//Added V180725-Gayathri/MMS-DM-CRF-0126
			if("Y".equals(Site_PreappDur)){ %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PreAppDurCap.label" bundle="${bl_labels}"/></td>
			<%} %>	
			<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS -->
			<%if("Y".equals(SiteSpecGroupServiceInd)){ %>
			<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.GroupService.label" bundle="${bl_labels}"/></td>
					<%} %>	
			<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.servicedtls.label" bundle="${bl_labels}"/></td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<%  if ("Y".equals(Site_preapp_across_enc)) { %>
					<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Preacrossenc.label" bundle="${bl_labels}" /></td>
				<% } %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.SplitReqd.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>
			 </tr>
			 <%
				int tableIndex = 1;
					for (PolicyInsuranceMasterBean policyBean1 : policyList) {
						if("I".equals(policyBean1.getStatus())){
							readonly = "";
							disabled = "";
						}
						else if("U".equals(policyBean1.getStatus())){
							readonly = "readonly";
							disabled = "disabled";
						}
			%>	
			 <tr>
				<td class='fields' nowrap>
					<select  id='episode_<%= tableIndex%>' name='episode_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange='changeEpsdEnc(<%= tableIndex%>);'>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("E".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='E' selected><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='E'><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("N".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='N' selected><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%}
						else{%>
							<option value='N'><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%} %>	

						<%if("A".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='A' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%}
						else{%>
							<option value='A'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%} %>
					</select>
				</td>
				<td class='fields' nowrap>
					<select id='ptClass_<%= tableIndex%>' name='ptClass_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("OP".equals(policyBean1.getPatClass())){ %>
							<option value='OP' selected><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='OP'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("IP".equals(policyBean1.getPatClass())){ %>
							<option value='IP' selected><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='IP'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%} %>

						<%if("DC".equals(policyBean1.getPatClass())){ %>
							<option value='DC' selected><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='DC'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("XT".equals(policyBean1.getPatClass())){ %>
							<option value='XT' selected><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='XT'><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("EM".equals(policyBean1.getPatClass())){ %>
							<option value='EM' selected><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='EM'><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%} %>

						<%if("**".equals(policyBean1.getPatClass())){ %>
							<option value='**' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='**'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%} %>
					</select>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=totalDisabled %> name='age_group_<%= tableIndex%>' id='age_group_<%= tableIndex%>' length='15' <%=disabled %> value='<%=checkForNull(policyBean1.getAgeGroupDesc()) %>' onblur="if(this.value!=''){ callCommonValidation(5,this,hdn_age_group_<%= tableIndex%>); } else{ fnClearCode(hdn_age_group_<%= tableIndex%>); }">
					<input type='hidden' name='hdn_age_group_<%= tableIndex%>' id='hdn_age_group_<%= tableIndex%>' id='hdn_age_group_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getAgeGroup()) %>' >
					<input type='button' <%=totalDisabled %> id='age_but_<%= tableIndex%>' value='?' onclick='callCommonValidation(5,age_group_<%= tableIndex%>,hdn_age_group_<%= tableIndex%>)' <%=disabled %>>
				</td>
				<td class='fields' nowrap>
					<select id='gender_<%= tableIndex%>' name='gender_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("M".equals(policyBean1.getGender())){ %>
							<option value='M' selected><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("F".equals(policyBean1.getGender())){ %>
							<option value='F' selected><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("A".equals(policyBean1.getGender())){ %>
							<option value='A' selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<%} %>
					</select>
				</td>
				
				<td class='fields' nowrap>
					<select  id='clinic_<%= tableIndex%>' name='clinic_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange="clearClinic(<%= tableIndex%>);">
						<%if("C".equals(policyBean1.getClinicNurs())){ %>
							<option value='C' selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("N".equals(policyBean1.getClinicNurs())){ %>
							<option value='N' selected><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<%} %>

						<%if("A".equals(policyBean1.getClinicNurs())){ %>
							<option value='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%} %>
					</select>
				</td>
					<td class='fields' nowrap>
					<input type='text' id='clinic_code_<%= tableIndex%>' name='clinic_code_<%= tableIndex%>' <%=totalDisabled %> <%=readonly %>  size='4' value='<%=checkForNull(policyBean1.getClinicNursCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callBGDescCode(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(clinic_desc_<%= tableIndex%>); }" <% }%>>
					<input type='text' <%=totalDisabled %> id='clinic_desc_<%= tableIndex%>' name='clinic_desc_<%= tableIndex%>' size='20' maxlength='60' <%=disabled %> value='<%=checkForNull(policyBean1.getClinicNursDesc())%>' onblur="if(this.value!=''){ callBGDesc(1,clinic_<%= tableIndex%>,this,clinic_code_<%= tableIndex%>);}  else{ fnClearCode(clinic_code_<%= tableIndex%>); }">
					<input type='button' <%=totalDisabled %> id='clinic_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callBGDesc(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='spec_code_<%= tableIndex%>' name='spec_code_<%= tableIndex%>' <%=totalDisabled %> <%=readonly %>  size='5' value='<%=checkForNull(policyBean1.getSpecCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callCommonValidationSpecCode(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(spec_desc_<%= tableIndex%>); }" <% }%>>
					<input type='text' <%=totalDisabled %> id='spec_desc_<%= tableIndex%>' name='spec_desc_<%= tableIndex%>' size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getSpecDesc())%>' onblur="if(this.value!=''){ callCommonValidationSpec(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(spec_code_<%= tableIndex%>); }">
					<input type='button' <%=totalDisabled %> id='spec_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callCommonValidationSpec(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>
				<td class='fields' nowrap>
					<Select id='type_<%= tableIndex%>' name='type_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange="clearBill(<%= tableIndex%>);">
						<%
						for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(policyBean1.getType())){ %>
								<option value='<%=type %>' selected><%=criteriaMap.get(type) %></option>	
							<%}
							else{%>
								<option value='<%=type %>'><%=criteriaMap.get(type) %></option>	
							<%} 
							
						}
						
					%>		
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=totalDisabled %> <%=readonly %> id='bg_code_<%= tableIndex%>' name='bg_code_<%= tableIndex%>' size='12' value='<%=checkForNull(policyBean1.getBillServCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callBGDescCode(2,type_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>,<%= tableIndex%>); } else{ fnClearCode(bg_desc_<%= tableIndex%>,<%= tableIndex%>); }" <% }%>>
					<input type='text' <%=totalDisabled %> id='bg_desc_<%= tableIndex%>' name='bg_desc_<%= tableIndex%>' size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getBillServDesc())%>' onblur="if(this.value!=''){ callBGDesc(2,type_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>,<%= tableIndex%>); } else{ fnClearCode(bg_code_<%= tableIndex%>,<%= tableIndex%>); }">
					<input type='button' <%=totalDisabled %> id='bg_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callBGDesc(2,type_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>,<%= tableIndex%>)'>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='preAppAmt_<%= tableIndex%>' <%=totalDisabled %> name='preAppAmt_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='10' maxlength='10' value='<%=checkForNull(policyBean1.getPreApprAmtCapping()) %>'>&nbsp;&nbsp;
					<select name='AmtMode_<%= tableIndex%>' id='AmtMode_<%= tableIndex%>' <%=totalDisabled %>>
						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='G' selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<% if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='N' selected><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} %>						
					</select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='preAppQty_<%= tableIndex%>' <%=totalDisabled %> name='preAppQty_<%= tableIndex%>' size='10' maxlength='10' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getPreApprQtyCapping()) %>'>
				</td>
				<%//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
				if("Y".equals(Site_PreappDur)){
					String preappDurCapping="N";
					 String disabled_preapp="disabled";
					Connection connection =null;
					connection = ConnectionManager.getConnection(request);
					ResultSet rs = null;
try{
					pstmt=connection.prepareStatement("select blcommonproc.bl_preappr_ph_dur_yn(?,?,?) from dual");
					
					
					pstmt.setString(1,policyBean1.getType());
					pstmt.setString(2,checkForNull(policyBean1.getBillServCode()));
					pstmt.setString(3,locale);
					
					rs = pstmt.executeQuery();
					while (rs.next()) {
						preappDurCapping =rs.getString(1);
					}
						if("Y".equals(preappDurCapping))	disabled_preapp="";
					System.out.println("preappDurCapping" + preappDurCapping);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("preappDurCapping" + e);
				} 
finally{
	ConnectionManager.returnConnection(connection);
	pstmt = null;
	rst = null;
}
					
					%>
				<td class='fields' nowrap>
					<input type='text' id='preAppDur_<%= tableIndex%>' <%=totalDisabled %> <%=disabled_preapp%> name='preAppDur_<%= tableIndex%>' size='10' maxlength='3'  onkeypress="return checkAlpha(event)" onblur="checkForNumber(this);zeroCheck(this)" value='<%=checkForNull(policyBean1.getPreApprDurCapping()) %>'>
					
				</td>
				<%} %>
				<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS -->
					<% if("Y".equals(SiteSpecGroupServiceInd)) { %>
				<td class='fields' nowrap>
					<Select name='preGroupServiceInd_<%= tableIndex%>' id='preGroupServiceInd_<%= tableIndex%>' <%=totalDisabled %> onchange='changeInclExclInd(<%= tableIndex%>);'>
						<%if("G".equals(policyBean1.getGroupServInd())){ 
						System.err.println("612  "+policyBean1.getGroupServInd());%>
							<option value='G' selected><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='G'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("S".equals(policyBean1.getGroupServInd())){ %>
							<option value='S' selected><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='S'><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
						<%} %>						
					</Select>
				</td>
					<% } %>					
					<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS -->
				
				<td class='fields' nowrap>	
				<%
				
				if("Y".equals(Site_ServLevelRqd)){
				if("".equals(checkForNull(policyBean1.getServLimit()))){
				%>
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>' <%=totalDisabled %> checked name='serviceLmt_<%= tableIndex%>' >
				
				<%
				}
				else{

					if("Y".equals(policyBean1.getServLimit())){ %>					
						<input type="checkbox" id='serviceLmt_<%= tableIndex%>' <%=totalDisabled %> checked name='serviceLmt_<%= tableIndex%>' >
					<%}
					else{%>
						<input type="checkbox" id='serviceLmt_<%= tableIndex%>'  <%=totalDisabled %> name='serviceLmt_<%= tableIndex%>' >
					<%}			
				}
				}
				else{
				if("Y".equals(policyBean1.getServLimit())){ %>					
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>' <%=totalDisabled %> checked name='serviceLmt_<%= tableIndex%>' >
				<%}
				else{%>
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>'  <%=totalDisabled %> name='serviceLmt_<%= tableIndex%>' >
				<%}
				}%>
				</td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<% if ("Y".equals(Site_preapp_across_enc)){ %>
					<td class='fields' nowrap>	
				<% if("Y".equals(policyBean1.getPreacrossenc())){ %>					
					<input type="checkbox" id='Preacrossenc_<%= tableIndex%>' <%=totalDisabled %> checked name='Preacrossenc_<%= tableIndex%>' >
				<%} else{ %>
					<input type="checkbox" id='Preacrossenc_<%= tableIndex%>'  <%=totalDisabled %> name='Preacrossenc_<%= tableIndex%>' >
				<% } %> </td> <%} %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->				
				<td class='fields' nowrap>	
				<%
				if("Y".equals(Site_ServLevelRqd)){
					if("".equals(checkForNull(policyBean1.getSplitReqd()))){
				%>
						<input type="checkbox" id='splitReqd_<%= tableIndex%>' <%=totalDisabled %>  name='splitReqd_<%= tableIndex%>' >
				
				<%
					}
					else{
						
						if("Y".equals(policyBean1.getSplitReqd())){ %>					
						<input type="checkbox" id='splitReqd_<%= tableIndex%>' <%=totalDisabled %> checked name='splitReqd_<%= tableIndex%>' >
					<%}
					else{%>
						<input type="checkbox" id='splitReqd_<%= tableIndex%>'  <%=totalDisabled %> name='splitReqd_<%= tableIndex%>' >
					<%} 
						
						
					}
					
					
				}
				else{
				if("Y".equals(policyBean1.getSplitReqd())){ %>					
					<input type="checkbox" id='splitReqd_<%= tableIndex%>' <%=totalDisabled %> checked name='splitReqd_<%= tableIndex%>' >
				<%}
				else{%>
					<input type="checkbox" id='splitReqd_<%= tableIndex%>'  <%=totalDisabled %> name='splitReqd_<%= tableIndex%>' >
				<%}
				} 
				//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
				%>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='effFrom_<%= tableIndex%>' <%=totalDisabled %> name='effFrom_<%= tableIndex%>' size='10' <%=readonly %> value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='isValidDate(this);checkDateFrom(effFrom_<%= tableIndex%>);compareDates(effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled %> id='effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('effFrom_<%= tableIndex%>');" />
				</td>
				<td class='fields' nowrap>
					<input type='text' id='effTo_<%= tableIndex%>' <%=totalDisabled %> name='effTo_<%= tableIndex%>' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='isValidDate(this);checkDateFrom(effTo_<%= tableIndex%>);compareDates(effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled %> id='effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('effTo_<%= tableIndex%>');" />
					<input type='hidden' name='rowStatus<%= tableIndex%>' id='rowStatus<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getStatus())%>'>
				</td>
				<td class='fields' nowrap>
				<%if("Y".equals(policyBean1.getDelFlag())){ %>
					<input type='checkbox' checked name='delFlag<%= tableIndex%>' id='delFlag<%= tableIndex%>' <%=totalDisabled %>>
				<%} else{ %>
					<input type='checkbox' name='delFlag<%= tableIndex%>' id='delFlag<%= tableIndex%>' <%=totalDisabled %>>
				<%} %>
				</td>
			</tr>
			<%
			tableIndex++;
			} %>
      	</table>
      	<br/>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='mode' id='mode' value='<%= mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
	<input type='hidden' name='pageInfo' id='pageInfo' value='preApproval'>
	<input type='hidden' name='startDate' id='startDate' value='<%=startDate%>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate%>'>
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
      	<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
	<!--//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts -->
      	<input type='hidden' name='Site_PreappDur' id='Site_PreappDur' value='<%=Site_PreappDur%>'>
      	<input type='hidden' name='Site_ServLevelRqd' id='Site_ServLevelRqd' value='<%=Site_ServLevelRqd%>'>
	<!--//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends -->
	<!--//Added V190225-Dhananjay Starts -->
	<input type='hidden' name='Site_preapp_across_enc' id='Site_preapp_across_enc' value='<%=Site_preapp_across_enc%>'>
	<!--//Added V190225-Dhananjay Ends -->
	<input type='hidden' name='SiteSpecGroupServiceInd' id='SiteSpecGroupServiceInd' value='<%=SiteSpecGroupServiceInd%>'><!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS -->
    		
     </form>
     <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
     private String checkForStatus(String inputString) {
  		return (inputString == null) ? "I" : inputString;
  	}
     %>
</body>
</html>

