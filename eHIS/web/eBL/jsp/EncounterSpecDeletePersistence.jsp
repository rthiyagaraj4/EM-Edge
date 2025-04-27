<%// Page Added by Rajesh V. To Persist all the data visible in Polciy Definition Screen %>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, blPolicy.EncounterSpecificDefinitionBean, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String params = request.getQueryString();
	
	String beanId = "bl_EncounterSpecificDefinitionBean" ;
	String beanName = "blPolicy.EncounterSpecificDefinitionBean";
	
	EncounterSpecificDefinitionBean policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
	
	
	if(policyBean.getPolicyMap() == null)
	{
		policyBean.setPolicyMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}
	
	if(policyBean.getPopupMap() == null)
	{
		policyBean.setPopupMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}
	
	if(policyBean.getRestrictionMap() == null){
		policyBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	HashMap<String, List<EncounterSpecificDefinitionBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<EncounterSpecificDefinitionBean> > popupMap = policyBean.getPopupMap();
	HashMap<String, List<EncounterSpecificDefinitionBean> > diagPopupMap = policyBean.getDiagPopupMap();//Added for MOHE-CRF-0114
	HashMap<String,String> restrictionMap = policyBean.getRestrictionMap();
	
	//Delete Definitions
	String deletedBeanId = "DeletedEncounterBean";
	EncounterSpecificDefinitionBean deletedPolicyBean = (EncounterSpecificDefinitionBean) getBeanObject(deletedBeanId, beanName, request);
	
	if(deletedPolicyBean.getPolicyMap() == null)
	{
		deletedPolicyBean.setPolicyMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}
	
	if(deletedPolicyBean.getPopupMap() == null)
	{
		deletedPolicyBean.setPopupMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}
	
	// Added for MOHE-CRF-0114
	if(deletedPolicyBean.getDiagPopupMap() == null)
	{
		deletedPolicyBean.setDiagPopupMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}	
	
	
	HashMap<String, List<EncounterSpecificDefinitionBean> > deletedPolicyMap = deletedPolicyBean.getPolicyMap();
	HashMap<String, List<EncounterSpecificDefinitionBean> > deletedPopupMap = deletedPolicyBean.getPopupMap();
	HashMap<String, List<EncounterSpecificDefinitionBean> > deletedDiagPopupMap = deletedPolicyBean.getDiagPopupMap();//Added for MOHE-CRF-0114
	//Delete Definitions
	
	Connection 	connection = null;
	Boolean siteSpecRefPrice = false;//Added V181008-Aravindh/AAKH-CRF-0107
	try 
	{
		connection = ConnectionManager.getConnection();
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181008-Aravindh/AAKH-CRF-0107
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		
		if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{
			
			
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			int delCnt = 0;
			//Delete Definitions
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();
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
				covBean.setIncludeHomeMedication((String)hash.get("includeHomeMedication" + i));
				covBean.setBillServChk((String)hash.get("bg_chk_" + i));
				
				covBean.setInclExclInd((String)hash.get("incExInd_" + i));
				covBean.setInclExclIndChk((String)hash.get("incExChk_" + i));
				covBean.setInclusionBasis(((String)hash.get("incBasis_" + i)));
				covBean.setValue((String)hash.get("value_" + i));
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
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setRowNumber((String)hash.get("rowNumber" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				covBean.setEffectiveDate((String)hash.get("hdnEffDate_"+ i));
				if(siteSpecRefPrice) {
					covBean.setCoverRefPrice((String)hash.get("coverRefPrice_" + i));//Added V181003-Aravindh/AAKH-CRF-0107
				}
				covBean.setExlinclacrossenc((String) hash.get("Exlinclacrossenc_" + i));//Added V190326-Dhananjay/MMS-DM-CRF-0158
				//Delete Definitions
				if("Y".equals((String)hash.get("delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
					restrictionMap.remove("C~"+covBean.getEpisodeEncounter()+"~"+covBean.getPatClass()+"~"+covBean.getAgeGroup()+"~"+
							covBean.getGender()+"~"+covBean.getClinicNurs()+"~"+covBean.getClinicNursCode()+"~"+covBean.getSpecCode()+"~"+covBean.getInclExclCriteria()+"~"+covBean.getBillServCode()+"~"+covBean.getStartDate());
					
					popupMap.remove(Integer.toString(i-delCnt));
					deletedPopupMap.remove(Integer.toString(i-delCnt));
					int k = i-delCnt+1;
					for(int j=k;j<=count-delCnt;j++){
						popupMap.put(Integer.toString(j-1), popupMap.get(Integer.toString(j)));
						deletedPopupMap.put(Integer.toString(j-1), deletedPopupMap.get(Integer.toString(j)));
					}
					for(int l=count-delCnt;l<=count;l++){
						popupMap.put(Integer.toString(l), null);
						deletedPopupMap.put(Integer.toString(l), null);
					}
					delCnt++;
				}
				else{
					covList.add(covBean);
				}
				//Delete Definitions
			}
			if(covList.size() == 0){
				covList.add(new EncounterSpecificDefinitionBean());
			}
			policyMap.put("inclExclCoverage", covList);
			//Delete Definitions
			deletedPolicyMap.put("inclExclCoverage", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{
			
			
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPolicyMap.get("preApproval");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			//Delete Definitions
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();
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
				covBean.setPreApprDurCapping((String)hash.get("preAppDur_" + i)); //Added V180725-Gayathri/MMS-DM-CRF-0126
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));

				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setPreacrossenc((String) hash.get("Preacrossenc_" + i)); //Added V190326-Dhananjay/MMS-DM-CRF-0158
				//Delete Definitions
				if("Y".equals((String)hash.get("delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
					restrictionMap.remove("P~"+covBean.getEpisodeEncounter()+"~"+covBean.getPatClass()+"~"+covBean.getAgeGroup()+"~"+
							covBean.getGender()+"~"+covBean.getClinicNurs()+"~"+covBean.getClinicNursCode()+"~"+covBean.getSpecCode()+"~"+covBean.getType()+"~"+covBean.getBillServCode()+"~"+covBean.getStartDate());
				}
				else{
					covList.add(covBean);
				}
				//Delete Definitions
			}
			if(covList.size() == 0){
				covList.add(new EncounterSpecificDefinitionBean());
			}
			policyMap.put("preApproval", covList);
			//Delete Definitions
			deletedPolicyMap.put("preApproval", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{

			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			
			String encEpsd = (String)hash.get("encEpsd");
			String patClass = (String)hash.get("patClass");
			String ageGroup = (String)hash.get("ageGroup");
			String gender = (String)hash.get("gender");
			String clinicNursInd = (String)hash.get("clinicNursInd");
			String clinicNursCode = (String)hash.get("clinicNursCode");
			String spltyCode = (String)hash.get("spltyCode");
			String criteria = (String)hash.get("criteria");
			String blngCode = (String)hash.get("blngCode");
			String startDate = (String)hash.get("startDate");
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPopupMap.get(rowNumber);
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			//Delete Definitions
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();

				covBean.setInclExclCriteria(((String)hash.get("pop_incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("pop_bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("pop_bg_desc_" + i));
				
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
				covBean.setEffectiveDate((String)hash.get("hdnEffDate_"+ i));
				//Delete Definitions
				if("Y".equals((String)hash.get("pop_delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
					restrictionMap.remove("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
							covBean.getInclExclCriteria()+"~"+covBean.getBillServCode()+"~"+covBean.getStartDate());
				}
				else{
					covList.add(covBean);
				}
				//Delete Definitions
			}
			
			if(covList.size() == 0){
				covList.add(new EncounterSpecificDefinitionBean());
			}
			popupMap.put(rowNumber, covList);
			//Delete Definitions
			deletedPopupMap.put(rowNumber, deletedCovList);
			//Delete Definitions
		}
		
		/*if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{
			
			
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			//Delete Definitions
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();
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
				
				covBean.setInclExclInd((String)hash.get("incExInd_" + i));
				covBean.setInclExclIndChk((String)hash.get("incExChk_" + i));
				covBean.setInclusionBasis(((String)hash.get("incBasis_" + i)));
				covBean.setValue((String)hash.get("value_" + i));
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
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setRowNumber((String)hash.get("rowNumber" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				covBean.setDiagCopaySetup(((String)hash.get("chkDiagBasedCopayYN_" + i))); //Added for MOHE-CRF-0114
				//Delete Definitions
				if("Y".equals((String)hash.get("delFlag" + i))){
					deletedCovList.add(covBean);
					popupMap.remove(Integer.toString(i));
					deletedPopupMap.remove(Integer.toString(i));
					int k = i+1;
					for(int j=k;j<=count;j++){
						popupMap.put(Integer.toString(j-1), popupMap.get(Integer.toString(j)));
						deletedPopupMap.put(Integer.toString(j-1), deletedPopupMap.get(Integer.toString(j)));
					}
					for(int l=count;l<=popupMap.size();l++){
						popupMap.put(Integer.toString(l), null);
						deletedPopupMap.put(Integer.toString(l), null);
					}
				}
				else{
					covList.add(covBean);
				}
				//Delete Definitions
			}
			
			policyMap.put("inclExclCoverage", covList);
			//Delete Definitions
			deletedPolicyMap.put("inclExclCoverage", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{
			
			
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPolicyMap.get("preApproval");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			//Delete Definitions
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();
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
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));

				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				//Delete Definitions
				if("Y".equals((String)hash.get("delFlag" + i))){
					deletedCovList.add(covBean);
				}
				else{
					covList.add(covBean);
				}
				//Delete Definitions
				
			}
			
			policyMap.put("preApproval", covList);
			//Delete Definitions
			deletedPolicyMap.put("preApproval", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{

			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPopupMap.get(rowNumber);
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			//Delete Definitions
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();

				covBean.setInclExclCriteria(((String)hash.get("pop_incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("pop_bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("pop_bg_desc_" + i));
				
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
				//Delete Definitions
				if("Y".equals((String)hash.get("pop_delFlag" + i))){
					deletedCovList.add(covBean);
				}
				else{
					covList.add(covBean);
				}
				//Delete Definitions
				
			}
			
			popupMap.put(rowNumber, covList);
			//Delete Definitions
			deletedPopupMap.put(rowNumber, deletedCovList);
			//Delete Definitions
		}*/
		else if(func_mode!= null && func_mode.equals("MergeBeans")){
			List<EncounterSpecificDefinitionBean> covList = policyMap.get("inclExclCoverage");
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
			if(covList != null && deletedCovList != null){
				covList.addAll(deletedCovList);
			}
			
			policyMap.put("inclExclCoverage", covList);
			
			covList = null;
			deletedCovList = null;
			
			covList = policyMap.get("preApproval");
			deletedCovList = deletedPolicyMap.get("preApproval");
			if(covList != null && deletedCovList != null){
				covList.addAll(deletedCovList);
			}
			
			policyMap.put("preApproval", covList);
			
			for (Iterator iterator = popupMap.keySet().iterator(); iterator
					.hasNext();) {
				String keyVal = (String) iterator
						.next();
				if(popupMap.get(keyVal) != null && deletedPopupMap.get(keyVal) != null){
					covList = popupMap.get(keyVal);
					deletedCovList = deletedPopupMap.get(keyVal);
					covList.addAll(deletedCovList);
					popupMap.put(keyVal, covList);
				}
				
			}
			deletedPolicyBean = new EncounterSpecificDefinitionBean();
		} 
		else if(func_mode!= null && func_mode.equals("diagcopaypopup")) //Added for MOHE-CRF-0114
		{

			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			System.err.println("diagcopaypopup in remove count:"+count);
			//Delete Definitions
			List<EncounterSpecificDefinitionBean> deletedCovList = deletedPopupMap.get(rowNumber);
			System.err.println("deletedCovList:"+deletedCovList);
			if(deletedCovList == null){
				deletedCovList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			//Delete Definitions
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();

				covBean.setDiagType(((String)hash.get("popDiag_diagType_" + i)));
				covBean.setDiagPatCopay((String)hash.get("popDiag_copay_" + i));
				covBean.setDiagStartDate((String)hash.get("popDiag_effFrom_" + i));
				covBean.setDiagEndDate((String)hash.get("popDiag_effTo_" + i));
				covBean.setDiagStatus((String)hash.get("popDiag_rowStatus" + i));
				covBean.setDiagDelFlag((String)hash.get("popDiag_delFlag" + i));
				//Delete Definitions
				if("Y".equals((String)hash.get("popDiag_delFlag" + i))){System.err.println("Remove to be removed:"+i);
				System.err.println("covBean.getDiagStatus():"+covBean.getDiagStatus());
					if("U".equals(covBean.getDiagStatus())){
						deletedCovList.add(covBean);
					}
				}
				else{
					System.err.println("Remove to be retained:"+i);
					covList.add(covBean);
				}
				//Delete Definitions
				
			}
			System.err.println("Step1:"+covList.size());
			if(covList.size() == 0){
				EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
				String startDate = (String)hash.get("startDate");
				String endDate = (String)hash.get("endDate");
				titleBean.setDiagStartDate(startDate);
				titleBean.setDiagEndDate(endDate);	
				covList.add(titleBean);
			}System.err.println("Step2");
			diagPopupMap.put(rowNumber, covList);System.err.println("Step3:"+diagPopupMap);
			//Delete Definitions
			deletedDiagPopupMap.put(rowNumber, deletedCovList);System.err.println("Step4:"+deletedDiagPopupMap);
			//Delete Definitions
		}
		
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BLDischargeValidation :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}

	putObjectInBean("bl_EncounterSpecificDefinitionBean",policyBean,request);
	putObjectInBean(deletedBeanId,deletedPolicyBean,request);

%>

