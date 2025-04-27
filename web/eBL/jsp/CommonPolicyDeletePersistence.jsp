<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
 	System.err.println("Entered");
	String params = request.getQueryString();
	
	String beanId = "PayerPolicyInsuranceMasterBean";
	String beanName = "eBL.PolicyInsuranceMasterBean";
	PolicyInsuranceMasterBean policyBean = null;

	String priorityKey = request.getParameter("key");
	
	PolicyInsuranceMasterBean policyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	
	if(policyBeanMain.getMasterMap() == null)
	{
		policyBeanMain.setMasterMap(new HashMap<String,PolicyInsuranceMasterBean>());
	}
	
	HashMap<String,PolicyInsuranceMasterBean> masterMap = policyBeanMain.getMasterMap();
	
	if(!(masterMap == null || masterMap.isEmpty())){
		policyBean = masterMap.get(priorityKey);
	}
	else{
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	if(policyBean == null){
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	if(policyBean.getPolicyMap() == null)
	{
		policyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	if(policyBean.getPopupMap() == null)
	{
		policyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	HashMap<String, List<PolicyInsuranceMasterBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > popupMap = policyBean.getPopupMap();
	Connection 	connection = null;

	//Delete Definitions
	/*String deletedBeanId = "DeletedPayerPolicyBean";
	PolicyInsuranceMasterBean deletedPolicyBean = null;
	
	PolicyInsuranceMasterBean deletedPolicyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(deletedBeanId, beanName, request);
	
	if(deletedPolicyBeanMain.getMasterMap() == null)
	{
		deletedPolicyBeanMain.setMasterMap(new HashMap<String,PolicyInsuranceMasterBean>());
	}
	
	HashMap<String,PolicyInsuranceMasterBean> deletedMasterMap = deletedPolicyBeanMain.getMasterMap();
	
	if(!(deletedMasterMap == null || deletedMasterMap.isEmpty())){
		deletedPolicyBean = deletedMasterMap.get(priorityKey);
	}
	else{
		deletedPolicyBean = new PolicyInsuranceMasterBean();
	}
	
	if(deletedPolicyBean == null){
		deletedPolicyBean = new PolicyInsuranceMasterBean();
	}
	
	if(deletedPolicyBean.getPolicyMap() == null)
	{
		deletedPolicyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	if(deletedPolicyBean.getPopupMap() == null)
	{
		deletedPolicyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	HashMap<String, List<PolicyInsuranceMasterBean> > deletedPolicyMap = deletedPolicyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > deletedPopupMap = deletedPolicyBean.getPopupMap();*/
	//Delete Definitions
	try 
	{
		connection = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		System.err.println("Tab->"+func_mode);
		
		if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			//Delete Definitions
			/*List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<PolicyInsuranceMasterBean>();
			}*/
			
			int delCnt = 0;
			//Delete Definitions
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			System.err.println("count->"+count);
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
				//Delete Definitions
				if("Y".equals((String)hash.get("delFlag" + i))){
					/*if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}*/
					popupMap.remove(Integer.toString(i-delCnt));
					//deletedPopupMap.remove(Integer.toString(i-delCnt));
					int k = i-delCnt+1;
					for(int j=k;j<=count-delCnt;j++){
						popupMap.put(Integer.toString(j-1), popupMap.get(Integer.toString(j)));
						//deletedPopupMap.put(Integer.toString(j-1), deletedPopupMap.get(Integer.toString(j)));
					}
					for(int l=count-delCnt;l<=count;l++){
						popupMap.put(Integer.toString(l), null);
						//deletedPopupMap.put(Integer.toString(l), null);
					}
					delCnt++;
				}
				else{
					covList.add(covBean);
				}
				//System.err.println("Cov List Size->"+covList.size());
				//Delete Definitions
			}
			if(covList.size() == 0){
				covList.add(new PolicyInsuranceMasterBean());
			}
			policyMap.put("inclExclCoverage", covList);
			//Delete Definitions
			//deletedPolicyMap.put("inclExclCoverage", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			//Delete Definitions
			/*List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("preApproval");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<PolicyInsuranceMasterBean>();
			}*/
			
			//Delete Definitions
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			System.err.println("count->"+count);
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
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));

				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("effectiveDate" + i));
				//Delete Definitions
				/*if("Y".equals((String)hash.get("delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
				}
				else{
					covList.add(covBean);
				}*/
				if(!("Y".equals((String)hash.get("delFlag" + i)))){
					covList.add(covBean);
				}
				//Delete Definitions
				
			}
			if(covList.size() == 0){
				covList.add(new PolicyInsuranceMasterBean());
			}
			policyMap.put("preApproval", covList);
			//Delete Definitions
			//deletedPolicyMap.put("preApproval", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{

			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			//Delete Definitions
			/*List<PolicyInsuranceMasterBean> deletedCovList = deletedPopupMap.get(rowNumber);
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<PolicyInsuranceMasterBean>();
			}*/
			
			//Delete Definitions
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();

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
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("pop_effectiveDate" + i));
				//Delete Definitions
				/*if("Y".equals((String)hash.get("pop_delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
				}
				else{
					covList.add(covBean);
				}*/
				if(!("Y".equals((String)hash.get("pop_delFlag" + i)))){
					covList.add(covBean);
				}
				//Delete Definitions
			}
			if(covList.size() == 0){
				covList.add(new PolicyInsuranceMasterBean());
			}
			popupMap.put(rowNumber, covList);
			//Delete Definitions
			//deletedPopupMap.put(rowNumber, deletedCovList);
			//Delete Definitions
		}
		
		/*else if(func_mode!= null && func_mode.equals("MergeBeans")){
			List<PolicyInsuranceMasterBean> covList = policyMap.get("inclExclCoverage");
			List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
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
			deletedPolicyBean = new PolicyInsuranceMasterBean();
		}*/
		
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.out.println("Exception from BLDischargeValidation :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}

	masterMap.put(priorityKey, policyBean);
	putObjectInBean("PayerPolicyInsuranceMasterBean",policyBeanMain,request);
	
	//Delete Definitions
	/*deletedMasterMap.put(priorityKey, deletedPolicyBean);
	putObjectInBean(deletedBeanId,deletedPolicyBeanMain,request);*/
	//Delete Definitions

%>

