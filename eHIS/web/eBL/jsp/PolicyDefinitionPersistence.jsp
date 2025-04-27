
<%// Page Added by Rajesh V. To Persist all the data visible in Polciy Definition Screen 
/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			V211101             18595			 MMS-DM-CRF-0185			Mohana Priya K
2			V221017								 MMS-DM-CRF-0209 			Namrata Charate
----------------------------------------------------------------------------------------------
*/
%>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String params = request.getQueryString();
	String sqlCoverage = "";
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
	Boolean SiteSpecGroupService = false;
	String SiteSpecGroupServiceInd = "";
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "bl_PolicyInsuranceMasterBean" ;
	String beanName = "eBL.PolicyInsuranceMasterBean";
	PolicyInsuranceMasterBean fmtDtlsBean = null;
	List<PolicyInsuranceMasterBean> policyList = null;
	PolicyInsuranceMasterBean policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	String facility_id = (String)session.getAttribute("facility_id");
	System.err.println("policydefinitionpersistence.jsp");
	if(policyBean.getPolicyMap() == null)
	{
		policyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	if(policyBean.getPopupMap() == null)
	{
		policyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	System.err.println("check for diag popup");
	if(policyBean.getDiagPopupMap() == null)
	{
		System.err.println("diag popup is null");
		policyBean.setDiagPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}	
	
	if(policyBean.getRestrictionMap() == null){
		policyBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	HashMap<String, List<PolicyInsuranceMasterBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > popupMap = policyBean.getPopupMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > diagPopupMap = policyBean.getDiagPopupMap();//Added for MOHE-CRF-0114
	HashMap<String,String> restrictionMap = policyBean.getRestrictionMap();
	Connection 	connection = null;
	Boolean siteSpecRefPrice = false;//Added V181003-Aravindh/AAKH-CRF-0107
	try 
	{
		connection = ConnectionManager.getConnection();
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
		//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
		SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_GROUP_SRVICE_IND");
		if (SiteSpecGroupService) {
			SiteSpecGroupServiceInd = "Y";
		} else {
			SiteSpecGroupServiceInd = "N";
		}
		//MMS-QH-CRF-0170-US-4   Ram kumar S 28/08/2020 ENDS-->
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		System.err.println("check for diag popup:"+func_mode);
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash = (Hashtable)hash.get( "SEARCH" ) ;	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		
		if(func_mode!= null && func_mode.equals("Outpatient"))
		{			
			List<PolicyInsuranceMasterBean> outPatList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean outPatBean = new PolicyInsuranceMasterBean();
			outPatBean.setCreditAuthReq((String)hash.get("creditAuthReq"));
			outPatBean.setCreditAuthMand((String)hash.get("creditAuthMand"));
			outPatBean.setCreditAuthRef((String)hash.get("defaultCreditAuth"));
			outPatBean.setCovered((String)hash.get("covered"));
			outPatBean.setApprovedDays((String)hash.get("approvedDays"));
			outPatBean.setNoOfDays(((String)hash.get("noOfDays")));
			outPatBean.setApprovedAmt((String)hash.get("approvedAmt"));
			outPatBean.setLimitAmt(((String)hash.get("limitAmt")));
			outPatBean.setCoverageLimitType((String)hash.get("limitType"));
			outPatBean.setMandChkBillGen((String)hash.get("chkBillGen"));
			outPatBean.setMandChkInvoiceGen((String)hash.get("chkInvoiceGen"));
			outPatBean.setAmtGrossNet((String)hash.get("AmtMode"));
			outPatBean.setPolicyApplicability((String)hash.get("applicability"));
			outPatBean.setPatCopay((String)hash.get("patCopay"));
			outPatBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			outPatBean.setEncGrpIdSameEpsd((String)hash.get("encGrpIdSameEpsd"));
			outPatBean.setTimeLimitType((String)hash.get("timeLimitType"));
			outPatBean.setTimeLimitValue((String)hash.get("timeLimitValue"));
			outPatBean.setMultiFactorDeductRuleYN((String)hash.get("multiFactorDeductRuleYN")); //V221017
			outPatBean.setMFDRPatLimitAmt((String)hash.get("pat_Limit_Amt"));  //V221017
			outPatList.add(outPatBean);
			
			policyMap.put("Outpatient", outPatList);
		}
		
		else if(func_mode!= null && func_mode.equals("Inpatient"))
		{						
			List<PolicyInsuranceMasterBean> inPatList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean inPatBean = new PolicyInsuranceMasterBean();
			inPatBean.setCreditAuthReq((String)hash.get("creditAuthReq"));
			inPatBean.setCreditAuthMand((String)hash.get("creditAuthMand"));
			inPatBean.setCreditAuthRef((String)hash.get("defaultCreditAuth"));
			inPatBean.setCovered((String)hash.get("covered"));
			inPatBean.setApprovedDays((String)hash.get("approvedDays"));
			inPatBean.setNoOfDays(((String)hash.get("noOfDays")));
			inPatBean.setApprovedAmt((String)hash.get("approvedAmt"));
			inPatBean.setLimitAmt(((String)hash.get("limitAmt")));
			inPatBean.setCoverageLimitType((String)hash.get("limitType"));
			inPatBean.setMandChkBillGen((String)hash.get("chkBillGen"));
			inPatBean.setMandChkInvoiceGen((String)hash.get("chkInvoiceGen"));
			inPatBean.setAmtGrossNet((String)hash.get("AmtMode"));
			inPatBean.setPolicyApplicability((String)hash.get("applicability"));
			inPatBean.setPatCopay((String)hash.get("patCopay"));
			inPatBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			inPatBean.setTimeLimitType((String)hash.get("timeLimitType"));
			inPatBean.setTimeLimitValue((String)hash.get("timeLimitValue"));
			inPatBean.setMultiFactorDeductRuleYN((String)hash.get("multiFactorDeductRuleYN")); //V221017
			inPatList.add(inPatBean);
				
			policyMap.put("Inpatient", inPatList);
		}
		
		else if(func_mode!= null && func_mode.equals("External"))
		{			
			List<PolicyInsuranceMasterBean> extList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean extBean = new PolicyInsuranceMasterBean();
			extBean.setCreditAuthReq((String)hash.get("creditAuthReq"));
			extBean.setCreditAuthMand((String)hash.get("creditAuthMand"));
			extBean.setCreditAuthRef((String)hash.get("defaultCreditAuth"));
			extBean.setCovered((String)hash.get("covered"));
			extBean.setApprovedDays((String)hash.get("approvedDays"));
			extBean.setNoOfDays(((String)hash.get("noOfDays")));
			extBean.setApprovedAmt((String)hash.get("approvedAmt"));
			extBean.setLimitAmt(((String)hash.get("limitAmt")));
			extBean.setCoverageLimitType((String)hash.get("limitType"));
			extBean.setMandChkBillGen((String)hash.get("chkBillGen"));
			extBean.setMandChkInvoiceGen((String)hash.get("chkInvoiceGen"));
			extBean.setAmtGrossNet((String)hash.get("AmtMode"));
			extBean.setPolicyApplicability((String)hash.get("applicability"));
			extBean.setPatCopay((String)hash.get("patCopay"));
			extBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			extBean.setTimeLimitType((String)hash.get("timeLimitType"));
			extBean.setTimeLimitValue((String)hash.get("timeLimitValue"));
			extList.add(extBean);				
			policyMap.put("External", extList);
		}
		
		else if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setAgeGroupDesc((String)hash.get("age_group_" + i));
				covBean.setAgeGroup((String)hash.get("hdn_age_group_" + i));
				covBean.setGender((String)hash.get("gender_" + i));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setClinicNurs((String)hash.get("clinic_" + i));
				covBean.setClinicNursCode((String)hash.get("clinic_code_" + i));
				covBean.setClinicNursDesc((String)hash.get("clinic_desc_" + i));
				covBean.setSpecCode(((String)hash.get("spec_code_" + i)));
				covBean.setSpecDesc((String)hash.get("spec_desc_" + i));
				covBean.setInclExclCriteria(((String)hash.get("incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("bg_desc_" + i));
				covBean.setBillServChk((String)hash.get("bg_chk_" + i));
				//New Fields Added
				covBean.setPolicyApplicability((String)hash.get("acrossEncounter_" + i));
				covBean.setEncGrpIdSameEpsd((String)hash.get("encGrpIdSameEpsd_" + i));
				covBean.setTimeLimitType((String)hash.get("timeLimitTypeOP_" + i));
				covBean.setTimeLimitValue((String)hash.get("timeLimitValOP_" + i));
				//New Fields Added
				covBean.setInclExclInd((String)hash.get("incExInd_" + i));
				covBean.setInclExclIndChk((String)hash.get("incExChk_" + i));
				covBean.setInclusionBasis(((String)hash.get("incBasis_" + i)));
				covBean.setValue((String)hash.get("value_" + i));
				covBean.setInclhomeMedi((String)hash.get("inclhomeMedi_" + i));
				covBean.setValueChk1((String)hash.get("valueChk1_" + i));
				covBean.setValueChk2(((String)hash.get("valueChk2_" + i)));
				covBean.setValueChk3((String)hash.get("valueChk3_" + i));
				covBean.setValueChk4((String)hash.get("valueChk4_" + i));
				covBean.setServItemQty((String)hash.get("servItemQty_" + i));
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				covBean.setAmtPerVisit((String)hash.get("amtPerVisit_" + i));
				covBean.setAmtPerIPDay((String)hash.get("amtPerIPDay_" + i));
				covBean.setNoOfDays(((String)hash.get("noOfDays_" + i)));
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setOldEndDate((String)hash.get("oldEndDate" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setRowNumber((String)hash.get("rowNumber" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 -->
				if("Y".equals(SiteSpecGroupServiceInd)){
					 covBean.setGroupRservice((String)hash.get("GroupServiceInd_" + i));
				}
				if(siteSpecRefPrice) {
				covBean.setCoverRefPrice((String)hash.get("coverRefPrice_" + i));//Added V181003-Aravindh/AAKH-CRF-0107
				}
				covBean.setExlinclacrossenc((String) hash.get("Exlinclacrossenc_" + i)); //Added V190326-Dhananjay/MMS-DM-CRF-0158
				System.err.println("Diag Flag Value = "+(String)hash.get("chkDiagBasedCopayYN_" + i));
				System.err.println("Coverage Bean: "+covBean);
				covBean.setDiagCopaySetup(((String)hash.get("chkDiagBasedCopayYN_" + i)));//Added for MOHE-CRF-0114
				
				if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPatClass()) && "".equals(covBean.getAgeGroup()) && "".equals(covBean.getGender()) && "".equals(covBean.getClinicNursCode()) && "".equals(covBean.getSpecCode()) && "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
					
				
			}			
			policyMap.put("inclExclCoverage", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setAgeGroupDesc((String)hash.get("age_group_" + i));
				covBean.setAgeGroup((String)hash.get("hdn_age_group_" + i));
				covBean.setGender((String)hash.get("gender_" + i));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setClinicNurs((String)hash.get("clinic_" + i));
				covBean.setClinicNursCode((String)hash.get("clinic_code_" + i));
				covBean.setClinicNursDesc((String)hash.get("clinic_desc_" + i));
				covBean.setSpecCode(((String)hash.get("spec_code_" + i)));
				covBean.setSpecDesc((String)hash.get("spec_desc_" + i));
				covBean.setType(((String)hash.get("type_" + i)));
				covBean.setBillServCode((String)hash.get("bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("bg_desc_" + i));
				covBean.setPreApprAmtCapping((String)hash.get("preAppAmt_" + i));
				
				covBean.setPreApprQtyCapping((String)hash.get("preAppQty_" + i));
				covBean.setPreApprDurCapping((String)hash.get("preAppDur_" + i));//Added V180725-Gayathri/MMS-DM-CRF-0126
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				covBean.setSplitReqd(((String)hash.get("splitReqd_" + i)));
				covBean.setInclhomeMedi((String)hash.get("inclhomeMedi_" + i));

				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 -->
				if("Y".equals(SiteSpecGroupServiceInd)){
				covBean.setGroupRservice((String)hash.get("preGroupServiceInd_" + i));
				}
				covBean.setPreacrossenc((String) hash.get("Preacrossenc_" + i)); //Added V190326-Dhananjay/MMS-DM-CRF-0158
				if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPatClass()) && "".equals(covBean.getAgeGroup()) && "".equals(covBean.getGender()) && "".equals(covBean.getClinicNursCode()) && "".equals(covBean.getSpecCode()) && "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}			
			policyMap.put("preApproval", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();

				covBean.setInclExclCriteria(((String)hash.get("pop_incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("pop_bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("pop_bg_desc_" + i));
				//New Fields Added
				covBean.setPolicyApplicability((String)hash.get("pop_acrossEncounter_" + i));
				covBean.setEncGrpIdSameEpsd((String)hash.get("pop_encGrpIdSameEpsd_" + i));
				covBean.setTimeLimitType((String)hash.get("pop_timeLimitTypeOP_" + i));
				covBean.setTimeLimitValue((String)hash.get("pop_timeLimitValOP_" + i));
				//New Fields Added
				covBean.setInclExclInd((String)hash.get("pop_incExInd_" + i));
				covBean.setInclusionBasis(((String)hash.get("pop_incBasis_" + i)));
				covBean.setValue((String)hash.get("pop_value_" + i));
				covBean.setServItemQty((String)hash.get("pop_servItemQty_" + i));
				
				covBean.setAmtPerVisit((String)hash.get("pop_amtPerVisit_" + i));
				covBean.setAmtPerIPDay((String)hash.get("pop_amtPerIPDay_" + i));
				covBean.setNoOfDays(((String)hash.get("pop_noOfDays_" + i)));
				covBean.setStartDate((String)hash.get("pop_effFrom_" + i));
				covBean.setEndDate((String)hash.get("pop_effTo_" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setStatus((String)hash.get("pop_rowStatus" + i));
				covBean.setDelFlag((String)hash.get("pop_delFlag" + i));
				covBean.setPatCopay((String)hash.get("pop_patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("pop_patLimitAmt_" + i));
				if(!("".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}			
			popupMap.put(rowNumber, covList);
		}
		else if(func_mode!= null && func_mode.equals("diagpopup"))//Added for MOHE-CRF-0114
		{
			System.err.println("Inside diagpopup1:"+(String)hash.get("rowNumber"));
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			for(int i=1; i<=count;i++){
				System.err.println("Inside diagpopup1.1:");
				covBean = new PolicyInsuranceMasterBean();
System.err.println("Inside diagpopup1.2:");
				covBean.setDiagType(((String)hash.get("popDiag_diagType_" + i)));
				covBean.setDiagPatCopay((String)hash.get("popDiag_copay_" + i));
				covBean.setDiagStartDate((String)hash.get("popDiag_effFrom_" + i));
				covBean.setDiagEndDate((String)hash.get("popDiag_effTo_" + i));
				covBean.setDiagStatus((String)hash.get("popDiag_rowStatus" + i));
				covBean.setDiagDelFlag((String)hash.get("popDiag_delFlag" + i));
System.err.println("Inside diagpopup1.3:");

				if(!("".equals(covBean.getDiagType()))){
					covList.add(covBean);
				}
System.err.println("Inside diagpopup1.4:");				
			}			
			System.err.println("Inside diagpopup2:");
			diagPopupMap.put(rowNumber, covList);
			System.err.println("Inside diagpopup3:");
		}
		
		else if(func_mode!= null && func_mode.equals("infoFrame"))
		{			
			policyBean.setFacilityId((String)hash.get("facility"));
			policyBean.setPayer((String)hash.get("payerGroup1"));
			policyBean.setPayerCode((String)hash.get("payerCode"));
			policyBean.setPolicySettlementApplicability((String)hash.get("settlementApplicability"));
			policyBean.setScreeningPolicy((String)hash.get("screeningPolicy"));
			policyBean.setGroupPolicy((String)hash.get("GroupPolicy"));//Added against NMC-JD-CRF-0045
			policyBean.setPayerGroup(((String)hash.get("payerGroup2")));
			policyBean.setPayerGroupCode((String)hash.get("payerCode2"));
			policyBean.setStartDate(((String)hash.get("startDate")));
			policyBean.setPolicyType((String)hash.get("policyType"));
			policyBean.setPolicyTypeCode((String)hash.get("policyTypeCode"));
			
			policyBean.setEndDate((String)hash.get("endDate"));
			policyBean.setCoverageBasis(((String)hash.get("coverageBasis")));

			policyBean.setCoverageRules((String)hash.get("coverageRules"));
			policyBean.setCoveragePer((String)hash.get("percent"));
			policyBean.setStartDateChk((String)hash.get("startDateChk"));
			policyBean.setExpiryDays((String)hash.get("expDays"));
			if(siteSpecRefPrice) {
				policyBean.setCoverRefPrice((String)hash.get("coverRefPriceHdr"));//Added V181003-Aravindh/AAKH-CRF-0107			
			}
			//Added V190517-Aravindh/NMC-JD-CRF-0010/Starts
			String siteSpecPolApprv = (String)hash.get("siteSpecPolApprv");
			if("true".equals(siteSpecPolApprv) && "true".equals((String) hash.get("validUserApprvUnApprv"))) {
				policyBean.setPolicyApproved((String)hash.get("policyApprvdYN"));
			}
			String successfulUser = (String)hash.get("successfulUser");
			if(!"null".equals(successfulUser) && !"undefined".equals(successfulUser)) {
				policyBean.setAuthenticatedUser(successfulUser);
			}
			//Added V190517-Aravindh/NMC-JD-CRF-0010/Ends
			//Added V190701 MuthuN/NMC-JD-CRF-0002.1
			if("true".equals((String)hash.get("siteSpecClaimExist"))) {		
				policyBean.setclaimsAgrmtExts((String)hash.get("ClaimsAgrmtExts"));
			}
			//Added V190701 MuthuN/NMC-JD-CRF-0002.1
			
			// Added NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts -->		
			policyBean.setRemarks((String)hash.get("blremarks"));
			// Added NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends -->	

			policyBean.setPayerReferenceCode((String)hash.get("ref_code"));			//V211101

		}
		
		else if(func_mode!= null && func_mode.equals("serviceCoverage"))
		{			
			policyBean.setDefInclExclCriteria((String)hash.get("defaultCriteria"));
			policyBean.setOverRideInclExcl((String)hash.get("overrideInclExcl"));
			policyBean.setCovInclOthPayers((String)hash.get("coverageIclu"));
			policyBean.setLastPayer((String)hash.get("lastPayer"));
		}
		//Persisting values to bean when user clicks on any row from lookup window
		else if(func_mode!= null && func_mode.equals("inclExclCoverageLookup"))
		{
				List<PolicyInsuranceMasterBean> covList = policyMap.get("inclExclCoverage");
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				if(covList == null){
					covList = new ArrayList<PolicyInsuranceMasterBean>();
				}
				String payerGroup = request.getParameter("payergroupCode");
				String payer = request.getParameter("payerCode");
				String policy = request.getParameter("policyCode");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				
				String epsdEnc = request.getParameter("epsdEnc");
				String patClass = request.getParameter("patClass");
				String ageGrp = request.getParameter("ageGrp");
				String gender = request.getParameter("gender");
				String clinicNurs = request.getParameter("clinicNurs");
				String clinicNursCode = request.getParameter("clinicNursCode");
				String specCode = request.getParameter("specCode");
				String criteria = request.getParameter("criteria");
				String billServCode = request.getParameter("billServCode");
				
				if(restrictionMap.containsKey("C~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+
						gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate)) {
									
					out.println("No");
				}
				else{
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_DTL") +
					"and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
					" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";
					System.err.println("sqlCoverage in lkup:"+sqlCoverage);
					pstmt = connection.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,payerGroup);
					pstmt.setString(7,payer);
					pstmt.setString(8,policy);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,payerGroup);
					pstmt.setString(11,payer);
					pstmt.setString(12,policy);
					
					pstmt.setString(13,criteria);
					pstmt.setString(14,billServCode);
					pstmt.setString(15,patClass);
					pstmt.setString(16,epsdEnc);
					pstmt.setString(17,gender);
					pstmt.setString(18,ageGrp);
					pstmt.setString(19,clinicNurs);
					pstmt.setString(20,clinicNursCode);
					pstmt.setString(21,specCode);
					pstmt.setString(22,startDate);

					rst = pstmt.executeQuery();
				
				int rsCnt = 0;
				if(rst!=null){
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
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
						//New Fields Added
						fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounters_yn"));
						fmtDtlsBean.setEncGrpIdSameEpsd(rst.getString("dflt_acr_enc_grp_for_same_epis"));
						fmtDtlsBean.setTimeLimitType(rst.getString("dflt_acr_enc_grp_durn_type"));
						fmtDtlsBean.setTimeLimitValue(rst.getString("dflt_acr_enc_grp_durn"));
						//New Fields Added
						//Group Service INdicator Added
						if("Y".equals(SiteSpecGroupServiceInd)){
						fmtDtlsBean.setGroupServInd(rst.getString("group_service_ind"));
						}
						fmtDtlsBean.setInclhomeMedi(rst.getString("incl_home_medication_yn"));
						fmtDtlsBean.setStatus("U");
						if(siteSpecRefPrice) {
						fmtDtlsBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181003-Aravindh/AAKH-CRF-0107
						}
						fmtDtlsBean.setExlinclacrossenc(rst.getString("across_enc_exlincl_yn"));//Added V190326-Dhananjay/MMS-DM-CRF-0158
						
						fmtDtlsBean.setDiagCopaySetup(rst.getString("DIAG_BASED_COPAY_DEFN"));//Added for MOHE-CRF-0114
						
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}						
				}
				
				if(rsCnt>0){
					covList.addAll(policyList);
				}
				
				policyMap.put("inclExclCoverage", covList);
				restrictionMap.put("C~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+
						gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate, "Y");
				}
			}
			
			else if(func_mode!= null && func_mode.equals("preApprovalLookup"))
			{
				
				List<PolicyInsuranceMasterBean> covList = policyMap.get("preApproval");
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				if(covList == null){
					covList = new ArrayList<PolicyInsuranceMasterBean>();
				}
				
				String payerGroup = request.getParameter("payergroupCode");
				String payer = request.getParameter("payerCode");
				String policy = request.getParameter("policyCode");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				
				String epsdEnc = request.getParameter("epsdEnc");
				String patClass = request.getParameter("patClass");
				String ageGrp = request.getParameter("ageGrp");
				String gender = request.getParameter("gender");
				String clinicNurs = request.getParameter("clinicNurs");
				String clinicNursCode = request.getParameter("clinicNursCode");
				String specCode = request.getParameter("specCode");
				String criteria = request.getParameter("criteria");
				String billServCode = request.getParameter("billServCode");
				
				if(restrictionMap.containsKey("P~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+
					gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate)) {
									
					out.println("No");
				}
				else{						
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_PREAPPROVAL_DTL")+
					" and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
					" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";

					pstmt = connection.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,payerGroup);
					pstmt.setString(7,payer);
					pstmt.setString(8,policy);
					
					pstmt.setString(9,criteria);
					pstmt.setString(10,billServCode);
					pstmt.setString(11,patClass);
					pstmt.setString(12,epsdEnc);
					pstmt.setString(13,gender);
					pstmt.setString(14,ageGrp);
					pstmt.setString(15,clinicNurs);
					pstmt.setString(16,clinicNursCode);
					pstmt.setString(17,specCode);
					pstmt.setString(18,startDate);
					
					rst = pstmt.executeQuery();						

				int rsCnt = 0;
				if(rst!=null){
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
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
						fmtDtlsBean.setPreApprDurCapping(rst.getString("preapproval_dur_capping")); //Added V180725-Gayathri/MMS-DM-CRF-0126
						fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
						fmtDtlsBean.setSplitReqd(rst.getString("ALLOW_SPLIT_IF_NO_APPROVAL"));
						fmtDtlsBean.setStatus("U");
						if("Y".equals(SiteSpecGroupServiceInd)){
						fmtDtlsBean.setGroupServInd(rst.getString("group_service_ind"));
						}
						fmtDtlsBean.setPreacrossenc(rst.getString("ACROSS_ENC_PREAPP_YN"));//Added V190326-Dhananjay/MMS-DM-CRF-0158
						policyList.add(fmtDtlsBean);
						rsCnt++;					
					}						
				}					
				
				if(rsCnt>0){
					covList.addAll(policyList);
				}
				
				policyMap.put("preApproval", covList);
				restrictionMap.put("P~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+
				gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate, "Y");
				}
			}			
			else if(func_mode!= null && func_mode.equals("preApprovalPopupLookup"))
			{

				String payerGroup = request.getParameter("payergroupCode");
				String payer = request.getParameter("payerCode");
				String policy = request.getParameter("policyCode");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				String policyNo = request.getParameter("policyNo");
				
				String policyEncounter = request.getParameter("policyEncounter");
				String encEpsd = request.getParameter("epsdEnc");
				String patClass = request.getParameter("patClass");
				String ageGroup = request.getParameter("ageGrp");
				String gender = request.getParameter("gender");
				String clinicNursInd = request.getParameter("clinicNurs");
				String clinicNursCode = request.getParameter("clinicNursCode");
				String spltyCode = request.getParameter("specCode");
				String criteria = request.getParameter("criteria");
				String blngCode = request.getParameter("billServCode");
				
				String rowNumber = request.getParameter("rowNumber");
				String criteriaPop = request.getParameter("criteriaPop");
				String billServCodePop = request.getParameter("billServCodePop");
				String startDatePop = request.getParameter("startDatePop");
				if(restrictionMap.containsKey("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+
						gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
						criteriaPop+"~"+billServCodePop+"~"+startDatePop)) {
									
					out.println("No");
				}
				else{
				List<PolicyInsuranceMasterBean> popupList = popupMap.get(rowNumber);

				if(popupList == null){
					popupList = new ArrayList<PolicyInsuranceMasterBean>();	
				}										
					
				sqlCoverage =  BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP")+
				" and hdr.EXCL_SERV_EXCL_INCL_CRIT = ? and hdr.EXCL_BLNG_SERV_CODE = ? and TO_CHAR (hdr.EXCL_EFFECTIVE_FROM, 'dd/mm/yyyy') = ?";

				pstmt = connection.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,payerGroup);
				pstmt.setString(4,payer);
				pstmt.setString(5,policy);
				pstmt.setString(6,criteria);
				pstmt.setString(7,blngCode);
				pstmt.setString(8,patClass);
				
				pstmt.setString(9,encEpsd);
				pstmt.setString(10,gender);
				pstmt.setString(11,ageGroup);
				pstmt.setString(12,clinicNursInd);
				pstmt.setString(13,clinicNursCode);
				pstmt.setString(14,spltyCode);
				pstmt.setString(15,startDate);
				
				pstmt.setString(16,criteriaPop);
				pstmt.setString(17,billServCodePop);
				pstmt.setString(18,startDatePop);
				
				rst = pstmt.executeQuery();
				
				int rsCnt = 0;
				if(rst!=null){
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					while (rst.next()) {
						fmtDtlsBean = new PolicyInsuranceMasterBean();

						fmtDtlsBean.setInclExclCriteria(rst.getString("excl_serv_excl_incl_crit"));
						fmtDtlsBean.setBillServCode(rst.getString("excl_blng_serv_code"));
						fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
						fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
						fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
						fmtDtlsBean.setValue(rst.getString("copay_val"));
						fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
						fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
						fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
						fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
						fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
						fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
						//New Fields Added
						fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounters_yn"));
						fmtDtlsBean.setEncGrpIdSameEpsd(rst.getString("dflt_acr_enc_grp_for_same_epis"));
						fmtDtlsBean.setTimeLimitType(rst.getString("dflt_acr_enc_grp_durn_type"));
						fmtDtlsBean.setTimeLimitValue(rst.getString("dflt_acr_enc_grp_durn"));
						//New Fields Added
						fmtDtlsBean.setStatus("U");
						fmtDtlsBean.setExlinclacrossenc(rst.getString("across_enc_exlincl_yn")); //Added V190326-Dhananjay/MMS-DM-CRF-0158
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}												
				}
				
				if(rsCnt>0){
					popupList.addAll(policyList);
				}
				
				popupMap.put(rowNumber, popupList);
				restrictionMap.put("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+
						gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
						criteriaPop+"~"+billServCodePop+"~"+startDatePop, "Y");
				}
			}//Ends	
			else if(func_mode!= null && func_mode.equals("diagCopayPopupLoad"))
			{//Added for MOHE-CRF-0114
				try{
					String payerGroup = request.getParameter("payergroupCode");
					String payer = request.getParameter("payerCode");
					String policy = request.getParameter("policyCode");
					String startDate = request.getParameter("startDate");
					String endDate = request.getParameter("endDate");
					String policyNo = request.getParameter("policyNo");
					
					String policyEncounter = request.getParameter("policyEncounter");
					String encEpsd = request.getParameter("epsdEnc");
					String patClass = request.getParameter("patClass");
					String ageGroup = request.getParameter("ageGrp");
					String gender = request.getParameter("gender");
					String clinicNursInd = request.getParameter("clinicNurs");
					String clinicNursCode = request.getParameter("clinicNursCode");
					String spltyCode = request.getParameter("specCode");
					String criteria = request.getParameter("criteria");
					String blngCode = request.getParameter("billServCode");
					
					String rowNumber = request.getParameter("rowNumber");
					String criteriaPop = request.getParameter("criteriaPop");
					String billServCodePop = request.getParameter("billServCodePop");
					String startDatePop = request.getParameter("startDatePop");
					/*if(restrictionMap.containsKey("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+
							gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
							criteriaPop+"~"+billServCodePop+"~"+startDatePop)) {
										
						out.println("No");
					}
					else{*/
					List<PolicyInsuranceMasterBean> popupList = diagPopupMap.get(rowNumber);
					System.err.println("popupList in diagCopayPopupLoad:"+popupList);
					System.err.println("rowNumber in diagCopayPopupLoad:"+rowNumber);
					if(popupList == null){
						popupList = new ArrayList<PolicyInsuranceMasterBean>();	
															
						
					String sqlForDiagCopay =  "SELECT DIAGNOSIS_TYPE, COPAY, to_char(DIAG_EFFECTIVE_FROM,'dd/mm/yyyy') DIAG_EFFECTIVE_FROM, to_char(DIAG_EFFECTIVE_TO,'dd/mm/yyyy') DIAG_EFFECTIVE_TO FROM bl_insu_policy_diagnosis "+
								   " WHERE OPERATING_FACILITY_ID = '"+ facility_id +"'"+
								   " AND CUST_GROUP_CODE = '"+ payerGroup +"'"+
								   " AND CUST_CODE = '"+ payer +"'"+
								   " AND POLICY_TYPE_CODE = '"+ policy +"'"+
								   " AND SERV_EXCL_INCL_CRIT = '"+ criteria +"'"+
								   " AND PATIENT_CLASS = '"+ patClass +"'"+
								   " AND SEX = '"+ gender +"'"+
								   " AND AGE_GROUP_CODE = '"+ ageGroup +"'"+
								   " AND BLNG_SERV_CODE = '"+ blngCode +"'"+
								   " AND EPISODE_OR_ENCOUNTER_FLAG = '"+ encEpsd +"'"+
								   " AND CLINIC_NURSING_IND = '" + clinicNursInd +"'"+
								   " AND CLINIC_NURSING_CODE = '" + clinicNursCode +"'"+
								   " AND SPLTY_CODE = '" + spltyCode +"'"+
								   " AND TO_CHAR (EFFECTIVE_FROM, 'dd/mm/yyyy') = '" + startDate +"'"+
								   " ORDER BY DIAG_EFFECTIVE_FROM";
					System.err.println("sql in diag popup load data:"+sqlForDiagCopay);
					pstmt = connection.prepareStatement(sqlForDiagCopay);
					rst = pstmt.executeQuery();
					
					int rsCnt = 0;
					if(rst!=null){
						System.err.println("Inside Resultset loop");
						
						policyList = new ArrayList<PolicyInsuranceMasterBean>();
						System.err.println("Inside Resultset loop1");
						while (rst.next()) {
							System.err.println("Inside Resultset loop2");
							fmtDtlsBean = new PolicyInsuranceMasterBean();
							System.err.println("Inside Resultset loop3");
							System.err.println("sql data:"+rst.getString("DIAGNOSIS_TYPE")+"/"+rst.getString("COPAY")+"/"+rst.getString("DIAG_EFFECTIVE_FROM")+"/"+rst.getString("DIAG_EFFECTIVE_TO"));
							fmtDtlsBean.setDiagType(rst.getString("DIAGNOSIS_TYPE"));
							fmtDtlsBean.setDiagPatCopay(rst.getString("COPAY"));
							fmtDtlsBean.setDiagStartDate(rst.getString("DIAG_EFFECTIVE_FROM"));
							fmtDtlsBean.setDiagEndDate(rst.getString("DIAG_EFFECTIVE_TO"));
							fmtDtlsBean.setDiagStatus("U");
							fmtDtlsBean.setDiagDelFlag("");
							
							policyList.add(fmtDtlsBean);
							rsCnt++;
						}												
					}
					
					if(rsCnt>0){
						popupList.addAll(policyList);
					}
					
					diagPopupMap.put(rowNumber, popupList);
					restrictionMap.put("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+
							gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
							criteriaPop+"~"+billServCodePop+"~"+startDatePop, "Y");
					}			//}
				}
				catch(Exception e){
					System.err.println("Exception inside diagCopayPopupLoad:"+e);
				}
			}
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception from BLDischargeValidation :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}
	putObjectInBean("bl_PolicyInsuranceMasterBean",policyBean,request);
%>

<%!
public String checkForNull(String inp){
	return (inp==null) ? "":inp;
}
%>
