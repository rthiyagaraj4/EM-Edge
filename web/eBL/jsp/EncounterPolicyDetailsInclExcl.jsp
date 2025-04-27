<!DOCTYPE html>
<%
/* 
---------------------------------------------------------------------------------------
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1            V220413            30399       MMS-ME-SCF-0064-TF      Mohanapriya K
2            V220629            32944       MMS-ICN-00131-TF      Mohanapriya K
---------------------------------------------------------------------------------------
*/
%>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@page import="webbeans.eCommon.ConnectionManager,org.apache.commons.codec.binary.Base64"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getAttribute("facility_id");
	String readonly = "";
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String, String> criteriaMap = new LinkedHashMap<String, String>();
	String siteId = "";
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecAddTable.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
$(document).ready(function(event){
	$("input[type='text']").keydown(function(e){
		if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
			e.preventDefault();
	    }
	});
	
	var episodeTyp=parent.frames[0].frmEncounterHeader.episode_type.value;
//	alert("episodeTyp "+episodeTyp);
// 	var rowCount=$('#inclRowCount').val();
// 	var incExCriteria=$('#incExCriteria_'+rowCount).val();
// 	if((episodeTyp=='I'|| episodeTyp=='D') && incExCriteria=='P'){
// 		alert("enabled");
// 	$('#includeHomeMedication'+rowCount).prop('disabled',false);
// 	}
// 	else{
// 		alert("disabled");
// 		$('#includeHomeMedication'+rowCount).prop('disabled',true);
// 	}
	

})


</script>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
	String beanId = "bl_EncounterSpecificDefinitionBean";
	String beanName = "blPolicy.EncounterSpecificDefinitionBean";
	EncounterSpecificDefinitionBean policyBean = null;
	String prevTab = "inclExclCoverage";
	String mode = checkForNull(request.getParameter("mode"));
	HashMap<String, List<EncounterSpecificDefinitionBean>> policyMap = null;
	List<EncounterSpecificDefinitionBean> policyList = null;
	String checked = "";
	String disabled = "";
	String exclDisabled = "";
	//String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request
			.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode"));
	String compressed = checkForNull(request.getParameter("compressed"));
	String patientId = checkForNull(request.getParameter("patinetId"));
	System.err.println("patientId encinclexcl-"+patientId);
	if("Y".equals(request.getParameter("compressed")==null?"":request.getParameter("compressed"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patinetId")).getBytes()));
	}//V220629
	System.err.println("decPatID encinclexcl-"+patientId);
	String encPatID=new String(Base64.encodeBase64(patientId.getBytes())); //V220413
	System.err.println("encPatID encinclexcl-"+encPatID);
	String startDate = checkForNull(request.getParameter("startDate"));
	String endDate = checkForNull(request.getParameter("endDate"));

	String visitId = checkForNull(request.getParameter("visitId"));
	String acctSeq = checkForNull(request.getParameter("acctSeq"));
	String priority = checkForNull(request.getParameter("priority"));
	String episodeType = checkForNull(request
			.getParameter("episodeType"));
	String episodeId = checkForNull(request.getParameter("episodeId"));
	String auth = checkForNull(request.getParameter("auth"));
	String totalDisabled = "disabled";

	// auth="Y";
	System.out.println("auth " + auth);

	if ("Y".equals(auth)) {
		totalDisabled = "";
	}
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	Boolean siteSpec = false;
	Boolean siteSpecRefPrice = false;//Added V181008-Aravindh/AAKH-CRF-0107
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	Boolean SiteSpec_across_enc = false;
	String Site_across_enc = "N";
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
	Boolean SiteSpecGroupService = false;
	String SiteSpecGroupServiceInd = "";
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
	
	Boolean isDiagBasedCopayAppl = false;// Added for MOHE-CRF-0114
	
	try {
		con = ConnectionManager.getConnection(request);
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
		siteId = BLReportIdMapper.getCustomerId();
		
		//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
		SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_GROUP_SRVICE_IND");
		if (SiteSpecGroupService) {
			SiteSpecGroupServiceInd = "Y";
		} else {
			SiteSpecGroupServiceInd = "N";
		}
		//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
		//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
		SiteSpec_across_enc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_PREAPP_ACR_ENT_YN");
		if (SiteSpec_across_enc) {
			Site_across_enc = "Y";
		} else {
			Site_across_enc = "N";
		}
		// MOHE-CRF-0114 Changes by Manivel N Starts
	
		isDiagBasedCopayAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "DIAG_BASED_COPAY_DEFN");
	
		// MOHE-CRF-0114 Changes by Manivel N Ends
		//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends	 	
		policyBean = (EncounterSpecificDefinitionBean) getBeanObject(
				beanId, beanName, request);
		policyMap = policyBean.getPolicyMap();
		if (!(policyMap == null || policyMap.isEmpty())) {
			policyList = policyMap.get(prevTab);
		}

		try {
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,
					"BL", "INCL/EXCL_HOME_MEDICATION");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in site specific " + e);
		}
		// 	siteSpec=false;
		HashMap<String, List<EncounterSpecificDefinitionBean>> fmtDetailsMap = new HashMap<String, List<EncounterSpecificDefinitionBean>>();
		EncounterSpecificDefinitionBean fmtDtlsBean = null;
		if (policyList == null || policyList.isEmpty()) {
			//String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_DTL");
			String partSql = "";
			String partExclSql = "";

			/*if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
				partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
				partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
				partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_R");
			}
			
			
			String sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_FIRST_PART")+partExclSql+BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART")+partSql;
			System.err.println("sqlCoverage in EncounterPolicyDetailsInclExcl.jsp:"+sqlCoverage);
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,payerGroup);
			pstmt.setString(7,payer);
			pstmt.setString(8,policy);
			pstmt.setString(9,patientId);
			
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(10,episodeType);
				pstmt.setString(11,episodeId);
				pstmt.setString(12,acctSeq);
				pstmt.setString(13,priority);
				
				pstmt.setString(14,facility_id);
				pstmt.setString(15,payerGroup);
				pstmt.setString(16,payer);
				pstmt.setString(17,policy);
				pstmt.setString(18,patientId);
				
				pstmt.setString(19,episodeType);
				pstmt.setString(20,episodeId);
				pstmt.setString(21,acctSeq);
				pstmt.setString(22,priority);

			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(10,episodeType);
				pstmt.setString(11,episodeId);
				pstmt.setString(12,visitId);
				pstmt.setString(13,acctSeq);
				pstmt.setString(14,priority);
				
				pstmt.setString(15,facility_id);
				pstmt.setString(16,payerGroup);
				pstmt.setString(17,payer);
				pstmt.setString(18,policy);
				pstmt.setString(19,patientId);
				
				pstmt.setString(20,episodeType);
				pstmt.setString(21,episodeId);
				pstmt.setString(22,visitId);
				pstmt.setString(23,acctSeq);
				pstmt.setString(24,priority);
			}
			else if("R".equals(episodeType)){
				
				pstmt.setString(10,episodeType);
				pstmt.setString(11,acctSeq);
				pstmt.setString(12,priority);
				
				pstmt.setString(13,facility_id);
				pstmt.setString(14,payerGroup);
				pstmt.setString(15,payer);
				pstmt.setString(16,policy);
				pstmt.setString(17,patientId);
				
				pstmt.setString(18,episodeType);
				pstmt.setString(19,acctSeq);
				pstmt.setString(20,priority);
			}
			

			rst = pstmt.executeQuery();
			
			if(rst!=null){
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new EncounterSpecificDefinitionBean();
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
					fmtDtlsBean.setInclExclCriteria(rst.getString("serv_excl_incl_crit"));
					fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
					fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
					fmtDtlsBean.setBillServChk(rst.getString("special_service_yn"));
					fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
					fmtDtlsBean.setInclExclIndChk(rst.getString("ovride_incl_excl_yn"));
					fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
					if(Integer.parseInt(rst.getString("total"))>0){
						fmtDtlsBean.setServLimit("Y");
					}
					else{
						fmtDtlsBean.setServLimit("N");
					}
					fmtDtlsBean.setValue(rst.getString("copay_val"));
					fmtDtlsBean.setValueChk1(rst.getString("include_policy_level_copay_yn"));
					fmtDtlsBean.setValueChk2(rst.getString("pre_approval_yn"));
					fmtDtlsBean.setValueChk3(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					fmtDtlsBean.setValueChk4(rst.getString("last_payer_coverage_yn"));
					fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
					fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
					fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
					fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
					fmtDtlsBean.setDiagCopaySetup(rst.getString("DIAG_BASED_COPAY_DEFN"));//Added for MOHE-CRF-0114
					fmtDtlsBean.setStatus("U");
					policyList.add(fmtDtlsBean);
					rsCnt++;
				}
				
				if(rsCnt<1){
					policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					titleBean.setStartDate(checkForNull(startDate));
					titleBean.setEndDate(checkForNull(endDate));
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);
				}
			}
			else{
				policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
				EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
				titleBean.setStartDate(checkForNull(startDate));
				titleBean.setEndDate(checkForNull(endDate));
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				policyList.add(titleBean);
				policyMap.put(prevTab, policyList);
			}	*/
			EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
			titleBean.setStartDate(checkForNull(startDate));
			titleBean.setEndDate(checkForNull(endDate));
			policyList = new ArrayList<EncounterSpecificDefinitionBean>();
			policyList.add(titleBean);
		}

		pstmt = null;
		rst = null;
		String inclExclSql = BlRepository
				.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1, locale);
		rst = pstmt.executeQuery();
		inclExclDesc = "";
		inclExclCode = "";
		if (rst != null) {
			while (rst.next()) {
				criteriaMap.put(rst.getString("code"),
						rst.getString("description"));
				inclExclDesc = inclExclDesc + ":::"
						+ rst.getString("description");
				inclExclCode = inclExclCode + ":::"
						+ rst.getString("code");
			}
		}

		inclExclDesc = inclExclDesc.substring(3);
		inclExclCode = inclExclCode.substring(3);

	} catch (Exception e) {
		System.err.println("Exception " + e);
	} finally {
		ConnectionManager.returnConnection(con);
		pstmt = null;
		rst = null;
	}
%>
	<form name="frmPolicyInclExclCoverage" id="frmPolicyInclExclCoverage">	
      	<table class='grid' border='1' width='220%' cellpadding='3'  cellspacing=0 align="center" id='PolicyInclExcl'>  
      		<tr>
      		<%
      			if (siteSpec) {
      		%> 
      			<td class='COLUMNHEADER' nowrap colspan="15" align="center"></td>
      			<%
      				} else {
      			%>
      			<td class='COLUMNHEADER' nowrap colspan="12" align="center"></td>
      			<%
      				}
      			%>
      			<td class='COLUMNHEADER' nowrap colspan="16" align="center"><fmt:message key="eBL.CoverageDetails.label" bundle="${bl_labels}"/></td>
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
					if (siteSpec) {
				%>              
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.InclHomeMedication.label" bundle="${bl_labels}"/></td>
				<%
					}
				%>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Special Service");' onMouseOut='hideToolTip();' class = 'img' ></td>
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
				
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/8/2020 STARTS -->
				<% if("Y".equals(SiteSpecGroupServiceInd)) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.GroupService.label" bundle="${bl_labels}"/></td>
				<% } %>
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/8/2020 ENDS-->
				
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
				<% if ("Y".equals(Site_across_enc)) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Preacrossenc.label" bundle="${bl_labels}" /></td>
				<% } %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>
			 </tr>
			<%
				int tableIndex = 1;
				String epiEnc = "";
				String incExcCrit = "";				
				String servCode = "";
				String incHomMedDisabled = "";
				String incHomMedChecked = "checked";
				String includeHomeMedicationYN = "N";
				String incExcInd="";
				
				
				for (EncounterSpecificDefinitionBean policyBean1 : policyList) {

					epiEnc = policyBean1.getEpisodeEncounter();
					incExcCrit = policyBean1.getInclExclCriteria();
					servCode = policyBean1.getBillServCode();
					incExcInd = policyBean1.getInclExclInd();

					
					System.out.println("epiEnc/incExcCrit/servCode/incExcInd:::  "+ epiEnc + "/" + incExcCrit+"/"+servCode+"/"+incExcInd);

					if ((("A").equals(epiEnc) || ("N").equals(epiEnc)) &&  ("P").equals(incExcCrit)) {
						try {
							System.out.println("in ::::::::::::::::::::: "+incHomMedDisabled);
							//incExcCrit="PKG";
							con = ConnectionManager.getConnection(request);
							pstmt = con.prepareStatement("select blcommonproc.bl_pharm_service_yn(?,?,?)  from dual");
							pstmt.setString(1, locale);
							pstmt.setString(2, "PKG");
							pstmt.setString(3, servCode);
							
// 							String includeHomeMedicationYN = "N";
							rst = pstmt.executeQuery();
							System.out.println("rst "+rst);
							while (rst.next()) {
								System.out.println("rst in "+rst);
								includeHomeMedicationYN = rst.getString(1);
// 								includeHomeMedicationYN = "Y";//test
							}
							
							System.out.println("before epiEnc/incExcCrit/includeHomeMedicationYN/incHomMedDisabled  "+ epiEnc + "/" + incExcCrit+"/"+includeHomeMedicationYN+"/"+incHomMedDisabled);

							
// 							if ((("A").equals(epiEnc) || ("N").equals(epiEnc)) &&  ("P").equals(incExcCrit) && ("N").equals(includeHomeMedicationYN) ) {
// 								System.out.println("IN DISABLED::::::: ");
// 								incHomMedDisabled = "disabled";
// 								incHomMedChecked="";
// 							}
							
							if(("Y").equals(includeHomeMedicationYN)){
								incHomMedDisabled = "";
								incHomMedChecked="checked";
							}
							else if(("N").equals(includeHomeMedicationYN)){
								incHomMedDisabled = "disabled";
								incHomMedChecked="";

							}
							
							System.out.println("after epiEnc/incExcCrit/includeHomeMedicationYN/incHomMedDisabled  "+ epiEnc + "/" + incExcCrit+"/"+includeHomeMedicationYN+"/"+incHomMedDisabled);

						} catch (Exception e) {

							e.printStackTrace();
							System.err.println("PkgDefIncludeHomeMedicationAjax : "+ e);
						} finally {
							ConnectionManager.returnConnection(con);
							pstmt = null;
							rst = null;
						}
					}
					else{
					//	System.out.println("In else disabled");
						incHomMedDisabled = "disabled";
						incHomMedChecked="";
					}
					System.out.println("incHomMedDisabled "+incHomMedDisabled);

					if ("I".equals(policyBean1.getStatus())) {
						readonly = "";
						disabled = "";
					} else if ("U".equals(policyBean1.getStatus())) {
						readonly = "readonly";
						disabled = "disabled";
					}

					if ("E".equals(policyBean1.getInclExclInd())) {
						exclDisabled = "disabled";
					} else {
						exclDisabled = "";
					}
			%>	
			 <tr>
				<td class='fields' nowrap>
					<select  id='episode_<%=tableIndex%>' name='episode_<%=tableIndex%>' <%=disabled%> <%=totalDisabled%> onchange='changeEpsdEnc(<%=tableIndex%>);'>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%
							if ("E".equals(policyBean1.getEpisodeEncounter())) {
						%>
							<option value='E' selected><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='E'><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("N".equals(policyBean1.getEpisodeEncounter())) {
												%>
							<option value='N' selected><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%
								} else {
							%>
							<option value='N'><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%
								}
							%>
						
						<%
													if ("A".equals(policyBean1.getEpisodeEncounter())) {
												%>
							<option value='A' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%
								} else {
							%>
							<option value='A'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%
								}
							%>

					</select>
				</td>
				<td class='fields' nowrap>
					<select id='ptClass_<%=tableIndex%>' name='ptClass_<%=tableIndex%>' <%=disabled%> <%=totalDisabled%>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%
							if ("OP".equals(policyBean1.getPatClass())) {
						%>
							<option value='OP' selected><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='OP'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("IP".equals(policyBean1.getPatClass())) {
												%>
							<option value='IP' selected><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='IP'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%
							}
						%>

						<%
							if ("DC".equals(policyBean1.getPatClass())) {
						%>
							<option value='DC' selected><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='DC'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("XT".equals(policyBean1.getPatClass())) {
												%>
							<option value='XT' selected><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='XT'><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("EM".equals(policyBean1.getPatClass())) {
												%>
							<option value='EM' selected><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='EM'><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>

						<%
							if ("**".equals(policyBean1.getPatClass())) {
						%>
							<option value='**' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='**'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>
						
					</select>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=totalDisabled%> name='age_group_<%=tableIndex%>' id='age_group_<%=tableIndex%>' length='15' <%=disabled%> value='<%=checkForNull(policyBean1.getAgeGroupDesc())%>' onblur="if(this.value!=''){ callCommonValidation(5,this,hdn_age_group_<%=tableIndex%>); } else{ fnClearCode(hdn_age_group_<%=tableIndex%>); }">
					<input type='hidden' name='hdn_age_group_<%=tableIndex%>' id='hdn_age_group_<%=tableIndex%>' id='hdn_age_group_<%=tableIndex%>' value='<%=checkForNull(policyBean1.getAgeGroup())%>' >
					<input type='button' id='age_but_<%=tableIndex%>' value='?' onclick='callCommonValidation(5,age_group_<%=tableIndex%>,hdn_age_group_<%=tableIndex%>)' <%=disabled%> <%=totalDisabled%>>
				</td>
				<td class='fields' nowrap>
					<select id='gender_<%=tableIndex%>' name='gender_<%=tableIndex%>' <%=disabled%> <%=totalDisabled%>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%
							if ("M".equals(policyBean1.getGender())) {
						%>
							<option value='M' selected><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("F".equals(policyBean1.getGender())) {
												%>
							<option value='F' selected><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("A".equals(policyBean1.getGender())) {
												%>
							<option value='A' selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
					</select>
				</td>
				
				<td class='fields' nowrap>
					<select  id='clinic_<%=tableIndex%>' name='clinic_<%=tableIndex%>' <%=disabled%> <%=totalDisabled%> onchange="clearClinic(<%=tableIndex%>);">
						<%
							if ("C".equals(policyBean1.getClinicNurs())) {
						%>
							<option value='C' selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("N".equals(policyBean1.getClinicNurs())) {
												%>
							<option value='N' selected><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("A".equals(policyBean1.getClinicNurs())) {
												%>
							<option value='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
					</select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='clinic_code_<%=tableIndex%>' name='clinic_code_<%=tableIndex%>' size='4' <%=totalDisabled%> <%=readonly%>  value='<%=checkForNull(policyBean1.getClinicNursCode())%>' <%if (!("readonly".equals(readonly))) {%> onblur="if(this.value!=''){ callBGDescCode(1,clinic_<%=tableIndex%>,clinic_desc_<%=tableIndex%>,clinic_code_<%=tableIndex%>); } else{ fnClearCode(clinic_desc_<%=tableIndex%>); }" <%}%>>
					<input type='text' id='clinic_desc_<%= tableIndex%>' <%=totalDisabled %> name='clinic_desc_<%= tableIndex%>' size='20' maxlength='60' <%=disabled %> value='<%=checkForNull(policyBean1.getClinicNursDesc())%>' onblur="if(this.value!=''){ callBGDesc(1,clinic_<%= tableIndex%>,this,clinic_code_<%= tableIndex%>); } else{ fnClearCode(clinic_code_<%= tableIndex%>); }">
					<input type='button' id='clinic_but_<%=tableIndex%>' value='?' <%=disabled%> <%=totalDisabled%> onclick='callBGDesc(1,clinic_<%=tableIndex%>,clinic_desc_<%=tableIndex%>,clinic_code_<%=tableIndex%>)'>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='spec_code_<%=tableIndex%>' name='spec_code_<%=tableIndex%>' size='5' <%=totalDisabled%> <%=readonly%>  value='<%=checkForNull(policyBean1.getSpecCode())%>' <%if (!("readonly".equals(readonly))) {%> onblur="if(this.value!=''){ callCommonValidationSpecCode(spec_desc_<%=tableIndex%>,spec_code_<%=tableIndex%>,clinic_<%=tableIndex%>,clinic_code_<%=tableIndex%>); } else{ fnClearCode(spec_desc_<%=tableIndex%>); }" <%}%>>
					<input type='text' id='spec_desc_<%=tableIndex%>' name='spec_desc_<%=tableIndex%>' <%=totalDisabled%> size='20' <%=disabled%> value='<%=checkForNull(policyBean1.getSpecDesc())%>' onblur="if(this.value!=''){ callCommonValidationSpec(spec_desc_<%=tableIndex%>,spec_code_<%=tableIndex%>,clinic_<%=tableIndex%>,clinic_code_<%=tableIndex%>); } else{ fnClearCode(spec_code_<%=tableIndex%>); }">
					<input type='button' id='spec_but_<%=tableIndex%>' value='?' <%=disabled%> <%=totalDisabled%> onclick='callCommonValidationSpec(spec_desc_<%=tableIndex%>,spec_code_<%=tableIndex%>,clinic_<%=tableIndex%>,clinic_code_<%=tableIndex%>)'>
				</td>
				<td class='fields' nowrap>
					<Select name='incExCriteria_<%=tableIndex%>' id='incExCriteria_<%=tableIndex%>' id='incExCriteria_<%=tableIndex%>' <%=disabled%> <%=totalDisabled%> onchange="clearBill(<%=tableIndex%>);">
					<%
						for (Iterator iterator = criteriaMap.keySet().iterator(); iterator
									.hasNext();) {
								String type = (String) iterator.next();
								if (type.equals(policyBean1.getInclExclCriteria())) {
					%>
								<option value='<%=type%>' selected><%=criteriaMap.get(type)%></option>	
							<%
									} else {
								%>
								<option value='<%=type%>'><%=criteriaMap.get(type)%></option>	
							<%
									}

										}
								%>																	
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='bg_code_<%=tableIndex%>' name='bg_code_<%=tableIndex%>' size='12' <%=totalDisabled%> <%=readonly%>  value='<%=checkForNull(policyBean1.getBillServCode())%>' <%if (!("readonly".equals(readonly))) {%> onblur="if(this.value!=''){ callBGDescCode(2,incExCriteria_<%=tableIndex%>,bg_desc_<%=tableIndex%>,bg_code_<%=tableIndex%>); } else{ fnClearCode(bg_desc_<%=tableIndex%>); } " <%}%>>
					<input type='text' id='bg_desc_<%=tableIndex%>' name='bg_desc_<%=tableIndex%>' <%=totalDisabled%> size='20' <%=disabled%> value='<%=checkForNull(policyBean1.getBillServDesc())%>' onblur="if(this.value!=''){ callBGDesc(2,incExCriteria_<%=tableIndex%>,bg_desc_<%=tableIndex%>,bg_code_<%=tableIndex%>); } else{ fnClearCode(bg_code_<%=tableIndex%>); }">
					<input type='button' id='bg_but_<%=tableIndex%>' value='?' onclick='callBGDesc(2,incExCriteria_<%=tableIndex%>,bg_desc_<%=tableIndex%>,bg_code_<%=tableIndex%>)' <%=disabled%> <%=totalDisabled%>>
				</td>

               <%
               	if (siteSpec) {
               %>
				<td class='fields' nowrap>
				<%
					if ("Y".equals(policyBean1.getIncludeHomeMedication())) {
				%>
					<input type='checkbox'  <%=incHomMedChecked%> name='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' <%=incHomMedDisabled%>>
				<%
					} else {
				%>
					<input type='checkbox'   name='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' <%=incHomMedDisabled%>>
				<%
					}
				%>
				</td>
				<%
					} else {
				%>
<!-- 					<td class='fields' nowrap> -->
				<%
					if ("Y".equals(policyBean1.getIncludeHomeMedication())) {
				%>
					<input type='hidden'    name='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' <%=incHomMedDisabled%>>
				<%
					} else {
				%>
					<input type='hidden'   name='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' id='includeHomeMedication<%=tableIndex%>' <%=incHomMedDisabled%>>
				<%
					}
				%>
<!-- 				</td> -->
				<%
					}
				%>

				<td class='fields' nowrap>	
					<%
							if ("Y".equals(policyBean1.getBillServChk())) {
						%>
						<input type="checkbox" checked id='bg_chk_<%=tableIndex%>' name='bg_chk_<%=tableIndex%>' <%=totalDisabled%>>
					<%
						} else {
					%>
						<input type="checkbox" id='bg_chk_<%=tableIndex%>' name='bg_chk_<%=tableIndex%>' <%=totalDisabled%>>
					<%
						}
					%>
				</td>
				

				
				<td class='fields' nowrap>
					<Select name='incExInd_<%=tableIndex%>' id='incExInd_<%=tableIndex%>' <%=totalDisabled%> onchange='changeInclExclInd(<%=tableIndex%>);'> 
						<%
 							if ("I".equals(policyBean1.getInclExclInd())) {
 						%>
							<option value='I' selected><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='I'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
						<%
													if ("E".equals(policyBean1.getInclExclInd())) {
												%>
							<option value='E' selected><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='E'><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						
					</Select>
				</td>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Starts -->
				<% if(siteSpecRefPrice) { %>
				<td class='fields' nowrap>
					<% if("Y".equals(policyBean1.getCoverRefPrice())) { %>
						<input type='checkbox' name='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' onclick='unCheckAllLineLvlRefChkBox("line")' checked>
					<% } else { %>
						<input type='checkbox' name='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' id='coverRefPrice_<%= tableIndex%>' onclick='unCheckAllLineLvlRefChkBox("line")'>
					<% } %>
				</td>
				<% } %>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Ends -->
				<td class='fields' nowrap>
					<%
						if ("Y".equals(policyBean1.getInclExclIndChk())) {
					%>
						<input type="checkbox" checked id='incExChk_<%=tableIndex%>' name='incExChk_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						} else {
					%>
						<input type="checkbox" id='incExChk_<%=tableIndex%>' name='incExChk_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						}
					%>
				</td>
				<td class='fields' nowrap>
					<Select name='incBasis_<%=tableIndex%>' id='incBasis_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%
							if ("P".equals(policyBean1.getInclusionBasis())) {
						%>
							<option value='P' selected><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='P'><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>

						<%
							if ("R".equals(policyBean1.getInclusionBasis())) {
						%>
							<option value='R' selected><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='R'><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>
						
						<%
													if (!("ALKA".equals(siteId))) {
															if ("F".equals(policyBean1.getInclusionBasis())) {
												%>
							<option value='F' selected><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
						<%
							} else {
						%>
							<option value='F'><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
						<%
							}
								}
						%>
						
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='value_<%=tableIndex%>' name='value_<%=tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getValue())%>' size='10' maxlength='10' <%=exclDisabled%> <%=totalDisabled%>>
				</td>
				<td class='fields' nowrap>
					<%
						if ("Y".equals(policyBean1.getValueChk1())) {
					%>
						<input type="checkbox" checked id='valueChk1_<%=tableIndex%>' name='valueChk1_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						} else {
					%>
						<input type="checkbox" id='valueChk1_<%=tableIndex%>' name='valueChk1_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						}
					%>
				</td>
				<!-- <td class='fields' nowrap>	
					<%if ("Y".equals(policyBean1.getValueChk2())) {%>
						<input type="checkbox" checked id='valueChk2_<%=tableIndex%>' name='valueChk2_<%=tableIndex%>'>
					<%} else {%>
						<input type="checkbox" id='valueChk2_<%=tableIndex%>' name='valueChk2_<%=tableIndex%>'>
					<%}%>
				</td>  -->
				<td class='fields' nowrap>		
					<%
								if ("Y".equals(policyBean1.getValueChk3())) {
							%>
						<input type="checkbox" checked id='valueChk3_<%=tableIndex%>' name='valueChk3_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						} else {
					%>
						<input type="checkbox" id='valueChk3_<%=tableIndex%>' name='valueChk3_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						}
					%>
				</td>
				<td class='fields' nowrap>	
					<%
							if ("Y".equals(policyBean1.getValueChk4())) {
						%>
						<input type="checkbox" checked id='valueChk4_<%=tableIndex%>' name='valueChk4_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						} else {
					%>
						<input type="checkbox" id='valueChk4_<%=tableIndex%>' name='valueChk4_<%=tableIndex%>' <%=exclDisabled%> <%=totalDisabled%>>
					<%
						}
					%>

				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled%> <%=totalDisabled%> id='servItemQty_<%=tableIndex%>' name='servItemQty_<%=tableIndex%>' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getServItemQty())%>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled%> <%=totalDisabled%> id='amtPerVisit_<%=tableIndex%>' name='amtPerVisit_<%=tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getAmtPerVisit())%>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled%> <%=totalDisabled%> id='amtPerIPDay_<%=tableIndex%>' name='amtPerIPDay_<%=tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getAmtPerIPDay())%>' size='10' maxlength='10'>&nbsp;&nbsp;
					<select name='AmtMode_<%=tableIndex%>' id='AmtMode_<%=tableIndex%>' <%=totalDisabled%> <%=exclDisabled%>>
						<%
							if (("G").equals(policyBean1.getAmtGrossNet())) {
						%>
							<option value='G' selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>
						
						<%
													if (("N").equals(policyBean1.getAmtGrossNet())) {
												%>
							<option value='N' selected><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%
							} else {
						%>
							<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%
							}
						%>					
					</select>
				</td>
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS  -->
					<%if("Y".equals(SiteSpecGroupServiceInd)) {
						%>
					<td class='fields' nowrap>
					<Select name='GroupServiceInd_<%= tableIndex%>' id='GroupServiceInd_<%= tableIndex%>' <%=disabled%> <%=totalDisabled %> onchange='changeInclExclInd(<%= tableIndex%>);' >
						<%if("G".equals(policyBean1.getGroupServInd())){ 
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
					<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS -->
					
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
					<input type='text' <%=exclDisabled%> <%=totalDisabled%> id='patCopay_<%=tableIndex%>' name='patCopay_<%=tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatCopay())%>' maxlength='5'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled%> <%=totalDisabled%> id='patLimitAmt_<%=tableIndex%>' name='patLimitAmt_<%=tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatLimitAmt())%>' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled%> <%=totalDisabled%> id='noOfDays_<%=tableIndex%>' name='noOfDays_<%=tableIndex%>' size='10' maxlength='5' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getNoOfDays())%>'>
				</td>
				<td class='fields' nowrap>	
				<%
						if ("Y".equals(policyBean1.getServLimit())) {
					%>					
					<input type="checkbox" id='serviceLmt_<%=tableIndex%>' checked <%=totalDisabled%> name='serviceLmt_<%=tableIndex%>' onclick="enableDisableLink(<%=tableIndex%>);">
					<%
						if ("disabled".equals(totalDisabled)) {
					%>
						<a href='javascript:showService(<%=tableIndex%>)' name="serviceLink_<%=tableIndex%>" id='serviceLink_<%=tableIndex%>' style='visibility: hidden;'>Dtls</a>
					<%
						} else {
					%>
						<a href='javascript:showService(<%=tableIndex%>)' name="serviceLink_<%=tableIndex%>" id='serviceLink_<%=tableIndex%>' style='visibility: visible;'>Dtls</a>
					<%
						}
					%>				
					
				<%
														} else {
													%>
					<input type="checkbox" id='serviceLmt_<%=tableIndex%>'  <%=totalDisabled%> name='serviceLmt_<%=tableIndex%>' onclick="enableDisableLink(<%=tableIndex%>);">
					<a href='javascript:showService(<%=tableIndex%>)' name="serviceLink_<%=tableIndex%>" id='serviceLink_<%=tableIndex%>' style='visibility: hidden;'>Dtls</a>
				<%
					}
				%>
				</td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<% if ("Y".equals(Site_across_enc)) { %>
				<td class='fields' nowrap>
					<% if ("Y".equals(policyBean1.getExlinclacrossenc())) { %> 	
					<input type="checkbox" id='Exlinclacrossenc_<%= tableIndex%>' <%=totalDisabled %> checked name='Exlinclacrossenc_<%= tableIndex%>' >
					<% } else { %> 
					<input type="checkbox" id='Exlinclacrossenc_<%= tableIndex%>'  <%=totalDisabled %> name='Exlinclacrossenc_<%= tableIndex%>' >
					<% } %> </td> <% } %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='fields' nowrap>
					<input type='text' id='effFrom_<%=tableIndex%>' <%=totalDisabled%> name='effFrom_<%=tableIndex%>' size='10' <%=readonly%> value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='isValidDate(this);checkDateFrom(effFrom_<%=tableIndex%>);compareDates(effFrom_<%=tableIndex%>,effTo_<%=tableIndex%>);' >
					<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_<%=tableIndex%>' <%=totalDisabled%> <%=disabled%> onClick="return showCalendar('effFrom_<%=tableIndex%>');" />
				</td>
				<td class='fields' nowrap>
					<input type='text' id='effTo_<%=tableIndex%>' <%=totalDisabled%> name='effTo_<%=tableIndex%>' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='isValidDate(this);checkDateFrom(effTo_<%=tableIndex%>);compareDates(effFrom_<%=tableIndex%>,effTo_<%=tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled%> id='effTo_ctrl_<%=tableIndex%>' onClick="return showCalendar('effTo_<%=tableIndex%>');" />
					<input type='hidden' name='rowStatus<%=tableIndex%>' id='rowStatus<%=tableIndex%>' value='<%=checkForStatus(policyBean1.getStatus())%>'>
					<input type='hidden' name='rowNumber<%=tableIndex%>' id='rowNumber<%=tableIndex%>' value='<%=tableIndex%>'>
					<input type='hidden' name='hdnEffDate_<%=tableIndex%>' id='hdnEffDate_<%=tableIndex%>' value='<%=checkForNull(policyBean1.getEffectiveDate())%>'>
				</td>
				<td class='fields' nowrap>
				<%
					if ("Y".equals(policyBean1.getDelFlag())) {
				%>
					<input type='checkbox' checked name='delFlag<%=tableIndex%>' id='delFlag<%=tableIndex%>' <%=totalDisabled%>>
				<%
					} else {
				%>
					<input type='checkbox' name='delFlag<%=tableIndex%>' id='delFlag<%=tableIndex%>' <%=totalDisabled%>>
				<%
					}
				%>
				</td>
			</tr>
			<%
				tableIndex++;
				}
			%>
      	</table>
      	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' id='inclRowCount' value='<%=tableIndex - 1%>'>
      	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
      	<input type='hidden' name='encPatientId' id='encPatientId' id='encPatientId' value='<%=encPatID%>'><!--V220413-->
	<input type='hidden' name='compressed' id='compressed' id='compressed' value='Y'><!--V220413-->
      	<input type='hidden' name='startDate' id='startDate' value='<%=startDate%>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate%>'>
		<input type='hidden' name='pageInfo' id='pageInfo' value='inclExclCoverage'>
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
      	
      	<input type='hidden' name='visitId' id='visitId' value='<%=visitId%>'>
      	<input type='hidden' name='acctSeq' id='acctSeq' value='<%=acctSeq%>'>
      	<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
      	<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
      	<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
      	<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
      	<input type='hidden' name='siteId' id='siteId' value='<%=siteId%>'>
      	<input type='hidden' name ='siteSpec' id='siteSpec' value='<%=siteSpec%>'>
      	<input type='hidden' name ='includeHomeMedicationYN' id='includeHomeMedicationYN' value='<%=includeHomeMedicationYN%>'>
      	<input type='hidden' name='siteSpecRefPrice' id='siteSpecRefPrice' value='<%=siteSpecRefPrice %>'><!-- Added V181003-Aravindh/AAKH-CRF-0107 -->
      	<input type='hidden' name='Site_across_enc' id='Site_across_enc' value='<%=Site_across_enc%>'> <!-- Added V190326-Dhananjay/MMS-DM-CRF-0158 -->
		<input type='hidden' name='SiteSpecGroupServiceInd' id='SiteSpecGroupServiceInd' value='<%=SiteSpecGroupServiceInd%>'> <!-- Added MMS-QH-CRF-0170 US-4-Ram kumar S 28/08/2020 -->
		<input type='hidden' name='isDiagBasedCopayAppl' id='isDiagBasedCopayAppl' value='<%=isDiagBasedCopayAppl?"Y":"N"%>'> <!-- MOHE-CRF-0114 Changes by Manivel N -->	
     </form>
    <%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	private String checkForStatus(String inputString) {
		return (inputString == null) ? "I" : inputString;
	}%>
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

