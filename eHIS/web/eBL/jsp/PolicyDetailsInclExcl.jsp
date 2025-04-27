<!DOCTYPE html>
<!-- Page Added by Rajesh V. Policy Definition Coverage Details-->

<%@page import="eBL.BLReportIdMapper"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String readonly = "";
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String siteId = "";
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
<script language="javascript" src="../../eBL/js/PolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
	String beanId = "bl_PolicyInsuranceMasterBean";
	String beanName = "eBL.PolicyInsuranceMasterBean";
	PolicyInsuranceMasterBean policyBean = null;
	String prevTab = "inclExclCoverage";
	String mode = checkForNull(request.getParameter("mode"));
	HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
	List<PolicyInsuranceMasterBean> policyList = null; 
	String checked = "";
	String includeHomeMedicationAllYN="";
	String disabled = "";
	String exclDisabled = "";
	String typeVal="";
	//String facility_id = (String)session.getAttribute("facility_id");
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
	Boolean SiteSpec=false;
	String SiteSpecific ="";
	auth = checkForNull(request.getParameter("auth"));
	int tableIndex = 1;
	Boolean siteSpecRefPrice = false; //Added V181003-Aravindh/AAKH-CRF-0107
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	Boolean SiteSpec_across_enc = false;
	String Site_across_enc = "N";
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends

	//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
	Boolean SiteSpecGroupService = false;
	String SiteSpecGroupServiceInd = "";
	//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
	
	Boolean isDiagBasedCopayAppl = false;// Added for MOHE-CRF-0114

try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();
	policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getPolicyMap();
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
			PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
			titleBean.setStartDate(checkForNull(startDate));
			titleBean.setEndDate(checkForNull(endDate));
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(titleBean);
		}		
	}
	else{
		if(policyList == null || policyList.isEmpty()){
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
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
	
	SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","INCL/EXCL_HOME_MEDICATION");		
	siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
	
	//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
	SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_GROUP_SRVICE_IND");
	if (SiteSpecGroupService) {
		SiteSpecGroupServiceInd = "Y";
	} else {
		SiteSpecGroupServiceInd = "N";
	}
	//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
	if(SiteSpec){
		SiteSpecific="Y";
	}
	else{
		SiteSpecific="N";
	}
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	SiteSpec_across_enc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_PREAPP_ACR_ENT_YN");			
	if (SiteSpec_across_enc) {
		Site_across_enc = "Y";
	} else {
		Site_across_enc = "N";
	}
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends	
	
	// MOHE-CRF-0114 Changes by Manivel N Starts
	
	isDiagBasedCopayAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "DIAG_BASED_COPAY_DEFN");
	
	// MOHE-CRF-0114 Changes by Manivel N Ends
%>
	<form  id="frmPolicyInclExclCoverage">	
      	<table class='grid' border='1' width='270%' cellpadding='3'  cellspacing=0 align="center" id='PolicyInclExcl'>  
      		<tr>
      			<td class='COLUMNHEADER' nowrap colspan="21" align="center"></td><!-- Modified V181003-Aravindh/AAKH-CRF-0107/colspan='20' as colspan='21' -->
      			<%
      			if("Y".equals(SiteSpecific)){ System.err.println("SiteSpecific==>>one");
      			%>
      				<td class='COLUMNHEADER' nowrap colspan="12" align="center"><fmt:message key="eBL.CoverageDetails.label" bundle="${bl_labels}"/></td>
      			<%}
      			else{System.err.println("SiteSpecific==>>two");
      			%>
      			<td class='COLUMNHEADER' nowrap colspan="10" align="center"><fmt:message key="eBL.CoverageDetails.label" bundle="${bl_labels}"/></td>
      			<%} %>
      		</tr>
      		<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNu.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNuDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.SpecDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcCriteria.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.BGServiceDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>				
				<%
      			if("Y".equals(SiteSpecific)){
      				%>
      				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.InclHomeMedication.label" bundle="${bl_labels}"/></td>
      				<%
      			}
      			%>			
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Special Service");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<!-- New Fields Added -->
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Across Encounters");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Same Group ID for Followup");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.TimeLimitGrpOP.label" bundle="${bl_labels}"></fmt:message> </td>				
				<!-- New Fields Added -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcInd.label" bundle="${bl_labels}"/></td>
				<% if(siteSpecRefPrice) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.CoverRefPrice.label" bundle="${bl_labels}"/></td><!-- Added V181003-Aravindh/AAKH-CRF-0107 -->
				<% } %>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Override Incl/Excl");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.InclusionBasis.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
				
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Include Policy Level Coverage");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<!-- <td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Pre Approval Required");' onMouseOut='hideToolTip();' class = 'img' ></td>  -->
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Coverage includes Other Payers");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Last Payer");' onMouseOut='hideToolTip();' class = 'img' ></td>
				
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ServItemQty.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtVisit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtIPDay.label" bundle="${bl_labels}"/></td>
				
				<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS -->
				<% if("Y".equals(SiteSpecGroupServiceInd)) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.GroupService.label" bundle="${bl_labels}"/></td>
				<% } %>
				<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
				
				<!-- MOHE-CRF-0114 Changes by Manivel N Begins -->
				<% if(isDiagBasedCopayAppl){ %>				
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
				<% } %>
				<!-- MOHE-CRF-0114 Changes by Manivel N Ends -->
				
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<%  if ("Y".equals(Site_across_enc)) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Preacrossenc.label" bundle="${bl_labels}" /></td>
				<% } %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>
			 </tr>
			<%				
					for (PolicyInsuranceMasterBean policyBean1 : policyList) {
						System.err.println("Status in inclexcl:"+policyBean1.getStatus());
						if("I".equals(policyBean1.getStatus())){
							readonly = "";
							disabled = "";
						}
						else if("U".equals(policyBean1.getStatus())){
							readonly = "readonly";
							disabled = "disabled";
						}
						
						if("E".equals(policyBean1.getInclExclInd())){
							exclDisabled = "disabled";
						}
						else{
							exclDisabled = "";
						}
						if("Y".equals(SiteSpecific)){
							includeHomeMedicationAllYN="N";
							if((("N".equals(policyBean1.getEpisodeEncounter())) || ("A".equals(policyBean1.getEpisodeEncounter())) )&& ("P".equals(policyBean1.getInclExclCriteria())))
								
							{
								typeVal="PKG";
								try {
									pstmt=con.prepareStatement("select blcommonproc.bl_pharm_service_yn(?,?,?)  from dual");
									
									pstmt.setString(1,locale);
									pstmt.setString(2,typeVal);
									pstmt.setString(3,policyBean1.getBillServCode());
									
									rst = pstmt.executeQuery();
									while (rst.next()) {
										includeHomeMedicationAllYN =rst.getString(1);
									}
								} catch (Exception e) {
									e.printStackTrace();
								} 
								
							}
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
					<input type='text' <%=totalDisabled %> name='age_group_<%= tableIndex%>' id='age_group_<%= tableIndex%>'   length='15' <%=disabled %> value='<%=checkForNull(policyBean1.getAgeGroupDesc()) %>' onblur="if(this.value!=''){ callCommonValidation(5,this,hdn_age_group_<%= tableIndex%>); } else{ fnClearCode(hdn_age_group_<%= tableIndex%>); }">
					<input type='hidden' id='hdn_age_group_<%= tableIndex%>' name='hdn_age_group_<%= tableIndex%>' id='hdn_age_group_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getAgeGroup()) %>' >
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
					<input type='text' id='clinic_code_<%= tableIndex%>' name='clinic_code_<%= tableIndex%>' size='4' <%=totalDisabled %> <%=readonly %>  value='<%=checkForNull(policyBean1.getClinicNursCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callBGDescCode(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(clinic_desc_<%= tableIndex%>); }" <% }%>>
					<input type='text' id='clinic_desc_<%= tableIndex%>' <%=totalDisabled %> name='clinic_desc_<%= tableIndex%>' size='20' maxlength='60' <%=disabled %> value='<%=checkForNull(policyBean1.getClinicNursDesc())%>' onblur="if(this.value!=''){ callBGDesc(1,clinic_<%= tableIndex%>,this,clinic_code_<%= tableIndex%>); } else{ fnClearCode(clinic_code_<%= tableIndex%>); }">
					<input type='button' id='clinic_but_<%= tableIndex%>' value='?' <%=totalDisabled %> <%=disabled %> onclick='callBGDesc(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='spec_code_<%= tableIndex%>' name='spec_code_<%= tableIndex%>' size='5' <%=totalDisabled %> <%=readonly %>  value='<%=checkForNull(policyBean1.getSpecCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callCommonValidationSpecCode(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(spec_desc_<%= tableIndex%>); }" <% }%>>
					<input type='text' id='spec_desc_<%= tableIndex%>' name='spec_desc_<%= tableIndex%>' <%=totalDisabled %> size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getSpecDesc())%>' onblur="if(this.value!=''){ callCommonValidationSpec(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(spec_code_<%= tableIndex%>); }">
					<input type='button' id='spec_but_<%= tableIndex%>' value='?' <%=disabled %> <%=totalDisabled %> onclick='callCommonValidationSpec(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>
				<td class='fields' nowrap>
					<Select name='incExCriteria_<%= tableIndex%>' id='incExCriteria_<%= tableIndex%>' id='incExCriteria_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange="clearBill(<%= tableIndex%>);">
					<%
						for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(policyBean1.getInclExclCriteria())){ %>
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
					<input type='text' id='bg_code_<%= tableIndex%>' name='bg_code_<%= tableIndex%>' size='12' <%=totalDisabled %> <%=readonly %>  value='<%=checkForNull(policyBean1.getBillServCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callBGDescCode(2,incExCriteria_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>,<%= tableIndex%>); } else{ fnClearCode(bg_desc_<%= tableIndex%>,<%= tableIndex%>) } " <% }%>>
					<input type='text' id='bg_desc_<%= tableIndex%>' name='bg_desc_<%= tableIndex%>' <%=totalDisabled %> size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getBillServDesc())%>' onblur="if(this.value!=''){ callBGDesc(2,incExCriteria_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>,<%= tableIndex%>); } else{ fnClearCode(bg_code_<%= tableIndex%>,<%= tableIndex%>)  }">
					<input type='button' id='bg_but_<%= tableIndex%>' value='?' <%=totalDisabled %> onclick='callBGDesc(2,incExCriteria_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>,<%= tableIndex%>)' <%=disabled %>>
				</td>
						<%
      			if("Y".equals(SiteSpecific)){
      				System.out.println("includeHomeMedicationAllYN)    "+includeHomeMedicationAllYN);
      				if("Y".equals(includeHomeMedicationAllYN) && "I".equals(policyBean1.getInclExclInd())){
      					if("Y".equals(policyBean1.getInclhomeMedi())){
      				%>
      				<td class='fields' nowrap>	
						<input type="checkbox" checked  id='inclhomeMedi_<%= tableIndex%>' <%=totalDisabled %> name='inclhomeMedi_<%= tableIndex%>'>
				</td>
				<%}
					else{
					%>	
					<td class='fields' nowrap>	
					<input type="checkbox"   id='inclhomeMedi_<%= tableIndex%>'<%=totalDisabled %> name='inclhomeMedi_<%= tableIndex%>'>
				</td>	
      				<%		
      					}	
      				}
      				else{
				%>
      				<td class='fields' nowrap>	
						<input type="checkbox" disabled id='inclhomeMedi_<%= tableIndex%>' <%=totalDisabled %> name='inclhomeMedi_<%= tableIndex%>'>
				</td>
      				<%
      				}
      			}
      			%>
				<td class='fields' nowrap>	
					<%if("Y".equals(policyBean1.getBillServChk())){ %>
						<input type="checkbox" checked id='bg_chk_<%= tableIndex%>' <%=totalDisabled %> name='bg_chk_<%= tableIndex%>'>
					<%} else{ %>
						<input type="checkbox" id='bg_chk_<%= tableIndex%>' <%=totalDisabled %> name='bg_chk_<%= tableIndex%>'>
					<%} %>
				</td>
				<!-- New Fields Added -->
				<td class='fields' nowrap>	
					<select name='acrossEncounter_<%= tableIndex%>' id='acrossEncounter_<%= tableIndex%>' id='acrossEncounter_<%= tableIndex%>' <%=totalDisabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean1.getPolicyApplicability())?"selected":"" %>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value='N' <%="N".equals(policyBean1.getPolicyApplicability())?"selected":"" %>><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class='fields' nowrap>	
					<select name='encGrpIdSameEpsd_<%= tableIndex%>' id='encGrpIdSameEpsd_<%= tableIndex%>' id='encGrpIdSameEpsd_<%= tableIndex%>' <%=totalDisabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean1.getEncGrpIdSameEpsd())?"selected":"" %>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value='N' <%="N".equals(policyBean1.getEncGrpIdSameEpsd())?"selected":"" %>><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class='fields' nowrap>	
					<input type='text' size="4"  name='timeLimitValOP_<%= tableIndex%>' id='timeLimitValOP_<%= tableIndex%>' id='timeLimitValOP_<%= tableIndex%>' <%=totalDisabled %> maxlength="4" value="<%=checkForNull(policyBean1.getTimeLimitValue())%>" onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)"> &nbsp;&nbsp;
					<select name='timeLimitTypeOP_<%= tableIndex%>' id='timeLimitTypeOP_<%= tableIndex%>' id='timeLimitTypeOP_<%= tableIndex%>' <%=totalDisabled %>>						
						<!-- <option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>  -->
						<option value='D' <%="D".equals(policyBean1.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
						<option value='M' <%="M".equals(policyBean1.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean1.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>
				</td>				
				<!-- New Fields Added -->
				<td class='fields' nowrap>
					<Select name='incExInd_<%= tableIndex%>' id='incExInd_<%= tableIndex%>' <%=totalDisabled %> onchange='changeInclExclInd(<%= tableIndex%>);'>
						<%if("I".equals(policyBean1.getInclExclInd())){ %>
							<option value='I' selected><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='I'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("E".equals(policyBean1.getInclExclInd())){ %>
							<option value='E' selected><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='E'><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
						<%} %>
						
					</Select>
				</td>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Starts -->
				<% if(siteSpecRefPrice) { %>
				<td class='fields' nowrap>
					<% if("Y".equals(policyBean1.getCoverRefPrice())) { %>
						<input type='checkbox' name='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' onclick='unCheckAllLineLvlRefChkBox()' checked>
					<% } else { %>
						<input type='checkbox' name='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' onclick='unCheckAllLineLvlRefChkBox()'>
					<% } %>
				</td>
				<% } %>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Ends -->
				<td class='fields' nowrap>
					<%if("Y".equals(policyBean1.getInclExclIndChk())){ %>
						<input type="checkbox" checked id='incExChk_<%= tableIndex%>' name='incExChk_<%= tableIndex%>' <%=exclDisabled %> <%=totalDisabled %>>
					<%} else{ %>
						<input type="checkbox" id='incExChk_<%= tableIndex%>' name='incExChk_<%= tableIndex%>' <%=exclDisabled %> <%=totalDisabled %>>
					<%} %>
				</td>
				<td class='fields' nowrap>
					<Select name='incBasis_<%= tableIndex%>' id='incBasis_<%= tableIndex%>' <%=exclDisabled %> <%=totalDisabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("P".equals(policyBean1.getInclusionBasis())){ %>
							<option value='P' selected><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='P'><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/></option>
						<%} %>

						<%if("R".equals(policyBean1.getInclusionBasis())){ %>
							<option value='R' selected><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='R'><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if(!("ALKA".equals(siteId))){
							if("F".equals(policyBean1.getInclusionBasis())){ %>
							<option value='F' selected><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='F'><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
						<%	}
						}%>						
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='value_<%= tableIndex%>' <%=totalDisabled %> name='value_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getValue()) %>' size='10' maxlength='10' <%=exclDisabled %>>
				</td>		
				
				<td class='fields' nowrap>
					<%if("Y".equals(policyBean1.getValueChk1())){ %>
						<input type="checkbox" <%=exclDisabled %> <%=totalDisabled %> checked id='valueChk1_<%= tableIndex%>' name='valueChk1_<%= tableIndex%>'>
					<%} else{ %>
						<input type="checkbox" <%=exclDisabled %> <%=totalDisabled %> id='valueChk1_<%= tableIndex%>' name='valueChk1_<%= tableIndex%>'>
					<%} %>
				</td>
				<%-- <td class='fields' nowrap>	
					<%if("Y".equals(policyBean1.getValueChk2())){ %>
						<input type="checkbox" checked id='valueChk2_<%= tableIndex%>' name='valueChk2_<%= tableIndex%>'>
					<%} else{ %>
						<input type="checkbox" id='valueChk2_<%= tableIndex%>' name='valueChk2_<%= tableIndex%>'>
					<%} %>
				</td>  --%>
				<td class='fields' nowrap>		
					<%if("Y".equals(policyBean1.getValueChk3())){ %>
						<input type="checkbox" <%=exclDisabled %> <%=totalDisabled %> checked id='valueChk3_<%= tableIndex%>' name='valueChk3_<%= tableIndex%>'>
					<%} else{ %>
						<input type="checkbox" <%=exclDisabled %> <%=totalDisabled %> id='valueChk3_<%= tableIndex%>' name='valueChk3_<%= tableIndex%>'>
					<%} %>
				</td>
				<td class='fields' nowrap>	
					<%if("Y".equals(policyBean1.getValueChk4())){ %>
						<input type="checkbox" <%=exclDisabled %> <%=totalDisabled %> checked id='valueChk4_<%= tableIndex%>' name='valueChk4_<%= tableIndex%>'>
					<%} else{ %>
						<input type="checkbox" <%=exclDisabled %> <%=totalDisabled %> id='valueChk4_<%= tableIndex%>' name='valueChk4_<%= tableIndex%>'>
					<%} %>

				</td>
				
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> <%=totalDisabled %> id='servItemQty_<%= tableIndex%>' name='servItemQty_<%= tableIndex%>' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getServItemQty())%>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> <%=totalDisabled %> id='amtPerVisit_<%= tableIndex%>' name='amtPerVisit_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)"  onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getAmtPerVisit())%>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> <%=totalDisabled %> id='amtPerIPDay_<%= tableIndex%>' name='amtPerIPDay_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)"  onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getAmtPerIPDay())%>' size='10' maxlength='10'>&nbsp;&nbsp;
					<select name='AmtMode_<%= tableIndex%>' id='AmtMode_<%= tableIndex%>' <%=totalDisabled %> <%=exclDisabled %>>
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
					<!-- MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS   26/8/2020 -->
					<% if("Y".equals(SiteSpecGroupServiceInd)) { %>
				<td class='fields' nowrap>
					<Select name='GroupServiceInd_<%= tableIndex%>' id='GroupServiceInd_<%= tableIndex%>' <%=totalDisabled %> onchange='changeInclExclInd(<%= tableIndex%>);'>
						<%if("G".equals(policyBean1.getGroupServInd())){ 
						System.err.println("612  "+policyBean1.getGroupServInd());
						%>
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
					
				<!-- MOHE-CRF-0114 Changes by Manivel N Begins -->
				<% if(isDiagBasedCopayAppl){ %>
				<td class='fields' nowrap>
					<input type="checkbox" id='chkDiagBasedCopayYN_<%= tableIndex%>' name='chkDiagBasedCopayYN_<%= tableIndex%>' onclick="chkDiagBasedCopayYN(<%= tableIndex%>);" value = "<%=checkForNull(policyBean1.getDiagCopaySetup())%>" <%="Y".equals(checkForNull(policyBean1.getDiagCopaySetup())) ? "checked" : ""%> <%=totalDisabled %>>
						<a href='javascript:openDiagBasedCopay(<%= tableIndex%>)' name="diagBasedCopayLink_<%= tableIndex%>" id='diagBasedCopayLink_<%= tableIndex%>' <%="Y".equals(checkForNull(policyBean1.getDiagCopaySetup())) ? "style='visibility: visible;'" : "style='visibility: hidden;'"%>>Dtls</a>
				</td>
				<% } else {%>
					<input type='hidden' id='chkDiagBasedCopayYN_<%= tableIndex%>' name='chkDiagBasedCopayYN_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getDiagCopaySetup())%>'>
				<% }%>
				<!-- MOHE-CRF-0114 Changes by Manivel N Ends -->					
					
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> <%=totalDisabled %> id='patCopay_<%= tableIndex%>' name='patCopay_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatCopay())%>' maxlength='5'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> <%=totalDisabled %> id='patLimitAmt_<%= tableIndex%>' name='patLimitAmt_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatLimitAmt())%>' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> <%=totalDisabled %> id='noOfDays_<%= tableIndex%>' name='noOfDays_<%= tableIndex%>' size='10' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getNoOfDays())%>' maxlength='5'>
				</td>
				<td class='fields' nowrap>	
				<%if("Y".equals(policyBean1.getServLimit())){ %>					
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>' <%=totalDisabled %> checked name='serviceLmt_<%= tableIndex%>' onclick="enableDisableLink(<%= tableIndex%>);">
					<%if("disabled".equals(totalDisabled)){ %>
						<a href='javascript:showService(<%= tableIndex%>)' name="serviceLink_<%= tableIndex%>" id='serviceLink_<%= tableIndex%>' style='visibility: hidden;'>Dtls</a>
					<%}
					else{%>
						<a href='javascript:showService(<%= tableIndex%>)' name="serviceLink_<%= tableIndex%>" id='serviceLink_<%= tableIndex%>' style='visibility: visible;'>Dtls</a>
					<%} %>
				<%}
				else{%>
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>'  <%=totalDisabled %> name='serviceLmt_<%= tableIndex%>' onclick="enableDisableLink(<%= tableIndex%>);">
					<a href='javascript:showService(<%= tableIndex%>)' name="serviceLink_<%= tableIndex%>" id='serviceLink_<%= tableIndex%>' style='visibility: hidden;'>Dtls</a>
				<%} %>
				</td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<% if ("Y".equals(Site_across_enc)) { %>
				<td class='fields' nowrap>
				<% if ("Y".equals(policyBean1.getExlinclacrossenc())) { %> 	
				<input type="checkbox" id='Exlinclacrossenc_<%= tableIndex%>' <%=totalDisabled %> checked name='Exlinclacrossenc_<%= tableIndex%>' >
				<% } else { %> 
				<input type="checkbox" id='Exlinclacrossenc_<%= tableIndex%>'  <%=totalDisabled %> name='Exlinclacrossenc_<%= tableIndex%>' >
				<% } %> </td> <% }%>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='fields' nowrap>
					<input type='text' id='effFrom_<%= tableIndex%>' <%=totalDisabled %> name='effFrom_<%= tableIndex%>' size='10' <%=readonly %> value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='isValidDate(this);checkDateFrom(effFrom_<%= tableIndex%>);compareDates(effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);' >
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled %> id='effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('effFrom_<%= tableIndex%>');" />
				</td>
				<td class='fields' nowrap>
					<input type='text' id='effTo_<%= tableIndex%>' <%=totalDisabled %> name='effTo_<%= tableIndex%>' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='isValidDate(this);checkDateFrom(effTo_<%= tableIndex%>);compareDates(effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>
					<input type='hidden' id='oldEndDate<%= tableIndex%>' name='oldEndDate<%= tableIndex%>' value='<%=checkForNull(policyBean1.getEndDate())%>'>
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled %> id='effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('effTo_<%= tableIndex%>');" />
					<input type='hidden' name='rowStatus<%= tableIndex%>' id='rowStatus<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getStatus())%>'>
					<input type='hidden' name='rowNumber<%= tableIndex%>' id='rowNumber<%= tableIndex%>' value='<%= tableIndex%>'>
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
			} 
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
      	</table>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='mode' id='mode' value='<%= mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
		<input type='hidden' name='pageInfo' id='pageInfo' value='inclExclCoverage'>
		<input type='hidden' name='startDate' id='startDate' value='<%=startDate%>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate%>'>
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
      	<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
      	<input type='hidden' name='siteId' id='siteId' value='<%=siteId %>'>
      	<input type='hidden' name='SiteSpecific' id='SiteSpecific' value='<%=SiteSpecific %>'>
    	<input type='hidden' name='validCheck' id='validCheck' value='<%=includeHomeMedicationAllYN %>'>
    	<input type='hidden' name='siteSpecRefPrice' id='siteSpecRefPrice' value='<%=siteSpecRefPrice %>'><!-- Added V181003-Aravindh/AAKH-CRF-0107 -->
	<input type='hidden' name='Site_across_enc' id='Site_across_enc' value='<%=Site_across_enc%>'> <!-- Added V190326-Dhananjay/MMS-DM-CRF-0158 -->
	<input type='hidden' name='SiteSpecGroupServiceInd' id='SiteSpecGroupServiceInd' value='<%=SiteSpecGroupServiceInd%>'> <!-- Added MMS-QH-CRF-0170 US-4-PALANINARAYANAN -->
	<input type='hidden' name='isDiagBasedCopayAppl' id='isDiagBasedCopayAppl' value='<%=isDiagBasedCopayAppl?"Y":"N"%>'> <!-- MOHE-CRF-0114 Changes by Manivel N -->	
	
		
     </form>
    <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
     %>
	 <div class='COLUMNHEADER' name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden; background-color:blue;'>
	 	<table id='tooltiptable' cellpadding="0" cellspacing=0 border-collapse=collapse  style='position:absolute;' width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

