<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
 2			V230801		   48394	   			MMS-DM-SCF-0898-TF			Namrata Charate
*/ %>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	System.err.println("Persitence file called.deff.");
	String params = request.getQueryString();
	String beanId = "bl_MultiFactorDeductRuleBean";
	String beanName = "eBL.MultiFactorDeductRuleBean";
	System.err.println("Drug category Persitence file called..");
	
	String beanID1 = "bl_MFDRDiagCatBean";
	String beanName1 = "eBL.MFDRDiagCatBean";
	System.err.println("Diagnosis category Persitence file called..");
	
	String beanID2 = "bl_MFDRServicesAndItemsBean";
	String beanName2 = "eBL.MFDRServicesAndItemsBean";
	System.err.println("Services and Items category Persitence file called..");
	 
	
	MultiFactorDeductRuleBean policyBean = (MultiFactorDeductRuleBean) getBeanObject(beanId, beanName, request);
	MFDRDiagCatBean policyBean1 = (MFDRDiagCatBean) getBeanObject(beanID1, beanName1, request);
	MFDRServicesAndItemsBean policyBean2 = (MFDRServicesAndItemsBean) getBeanObject(beanID2, beanName2, request);;
	
	if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<MultiFactorDeductRuleBean>>());
	}
	if(policyBean1.getPolicyMap() == null){
		policyBean1.setPolicyMap(new HashMap<String, List<MFDRDiagCatBean>>());
	}
	if(policyBean2.getPolicyMap() == null){
		policyBean2.setPolicyMap(new HashMap<String, List<MFDRServicesAndItemsBean>>());
	}
	System.err.println("Persitence file called..123");
	HashMap<String, List<MultiFactorDeductRuleBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<MFDRDiagCatBean> > policyMap1 = policyBean1.getPolicyMap();
	HashMap<String, List<MFDRServicesAndItemsBean> > policyMap2 = policyBean2.getPolicyMap();
	
	try 
	{
	
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
	
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash = (Hashtable)hash.get( "SEARCH" ) ;	
			
			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");	
			String mode = (String)hash.get("mode");		
			
			if(func_mode!= null && func_mode.equals("DrugCategoryDetails"))
			{			
			System.err.println("Function Mode:"+func_mode);
			List<MultiFactorDeductRuleBean> covList = new ArrayList<MultiFactorDeductRuleBean>();
			MultiFactorDeductRuleBean covBean = null;
			int cnt = Integer.parseInt((String)hash.get("rowCount"));
			
			System.err.println("Rowcount is:"+cnt);
			
			for(int i=1; i<=cnt; i++){
				covBean = new MultiFactorDeductRuleBean();
				System.err.println("covList is:"); 
				System.err.println("Status is:"+hash.get("rowStatus_"+i));
				covBean.setFacilityId((String)hash.get("facility_id"));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
				covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
				covBean.setPayer((String)hash.get("payer_desc_"+i));
				covBean.setPayerCode((String)hash.get("payer_code_"+i));
				covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
				covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
				covBean.setDrugCategory((String)hash.get("drug_category_"+i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				covBean.setAcrossEncYN((String)hash.get("across_enc_YN_" + i));  //V230801
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
				covBean.setStatus((String)hash.get("rowStatus_" + i));
				covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
				
				if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getDrugCategory()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
					covList.add(covBean); 
				}  
			//	covList.add(covBean);
				System.err.println("covList .."+covList.isEmpty());
			}  
			if(!(covList.isEmpty()))
				policyMap.put("DrugCategoryDetailsPageInfo", covList);
			} 
			else if(func_mode!= null && func_mode.equals("DiagnosisCategoryDetails")){
				System.err.println("Function Mode:"+func_mode);
				List<MFDRDiagCatBean> covList = new ArrayList<MFDRDiagCatBean>();
				MFDRDiagCatBean covBean = null;
				int cnt = Integer.parseInt((String)hash.get("rowCount"));
				System.err.println("Rowcount is:"+cnt);
				
				for(int i=1; i<=cnt; i++){
					covBean = new MFDRDiagCatBean();
					System.err.println("covList is:"); 
					System.err.println("Status is:"+hash.get("rowStatus_"+i));
					covBean.setFacilityId((String)hash.get("facility_id"));
					covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
					covBean.setPatClass((String)hash.get("ptClass_" + i));
					covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
					covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
					covBean.setPayer((String)hash.get("payer_desc_"+i));
					covBean.setPayerCode((String)hash.get("payer_code_"+i));
					covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
					covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
					covBean.setDiagCat((String)hash.get("diag_category_"+i));
					covBean.setPatCopay((String)hash.get("patCopay_" + i));
					covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
					covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
					covBean.setStartDate((String)hash.get("effFrom_" + i));
					covBean.setEndDate((String)hash.get("effTo_" + i));
					covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
					covBean.setStatus((String)hash.get("rowStatus_" + i));
					System.err.println(hash.get("rowStatus_" + i));
					covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
					
					if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getDiagCat()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
						covList.add(covBean); 
					}  
				//	covList.add(covBean); 
					System.err.println("covList .."+covList.isEmpty());
				}  
				if(!(covList.isEmpty()))
					policyMap1.put("DiagCatDtlsPageInfo", covList);
				
			} /* V230210 starts */
			else if(func_mode!= null && func_mode.equals("ServicesAndItemsCategoryDetails")){
				System.err.println("Function Mode in ServicesAndItemsCategoryDetails:"+func_mode);
				List<MFDRServicesAndItemsBean> covList = new ArrayList<MFDRServicesAndItemsBean>();
				MFDRServicesAndItemsBean covBean = null;
				int cnt = Integer.parseInt((String)hash.get("rowCount"));
				System.err.println("Rowcount is:"+cnt);
				
				for(int i=1; i<=cnt; i++){
					covBean = new MFDRServicesAndItemsBean();
					System.err.println("covList is:"); 
					System.err.println("Status is:"+hash.get("rowStatus_"+i));
					covBean.setFacilityId((String)hash.get("facility_id"));
					covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
					covBean.setPatClass((String)hash.get("ptClass_" + i));
					covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
					covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
					covBean.setPayer((String)hash.get("payer_desc_"+i));
					covBean.setPayerCode((String)hash.get("payer_code_"+i));
					covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
					covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
					covBean.setInclExclCriteria((String)hash.get("incl_excl_criteria_"+i));
					covBean.setServiceDetailsDesc((String)hash.get("service_dtls_desc_"+i));
					covBean.setServiceDetailsCode((String)hash.get("service_dtls_code_"+i));
					covBean.setClinicProc((String)hash.get("clinic_"+i));
					covBean.setClinicProcCode((String)hash.get("clinic_code_"+i));
					covBean.setClinicProcDesc((String)hash.get("clinic_desc_"+i));
					covBean.setReferral((String)hash.get("referral_"+i));
					covBean.setClinicCat((String)hash.get("clinic_category_"+i));				
					covBean.setPatCopay((String)hash.get("patCopay_" + i));
					covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
					covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
					covBean.setAcrossEncYN((String)hash.get("across_enc_YN_" + i));  //V230801
					covBean.setStartDate((String)hash.get("effFrom_" + i));
					covBean.setEndDate((String)hash.get("effTo_" + i));
					covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
					covBean.setStatus((String)hash.get("rowStatus_" + i));
					System.err.println(hash.get("rowStatus_" + i));
					covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
					
					if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getInclExclCriteria()) && "".equals(covBean.getServiceDetailsDesc()) && "".equals(covBean.getServiceDetailsCode()) && "".equals(covBean.getReferral()) && "".equals(covBean.getClinicCat()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
						covList.add(covBean); 
					}  
					System.err.println("covList .."+covList.isEmpty());
				}  
				if(!(covList.isEmpty()))
					policyMap2.put("ServicesAndItemsCatDtlsPageInfo", covList); 
				
			}  /* V230210 ends */
		System.err.println("Data is in Policy Map..");
		
	
		
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception from BLDischargeValidation :" + e);
	} 
	putObjectInBean("bl_MultiFactorDeductRuleBean",policyBean,request);   
	putObjectInBean("bl_MFDRDiagCatBean",policyBean1,request); 
	putObjectInBean("bl_MFDRServicesAndItemsBean",policyBean2,request); 
	
	
	
%>
