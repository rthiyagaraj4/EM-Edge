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
	PolicyInsuranceMasterBean fmtDtlsBean = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String priorityKey = request.getParameter("key");
	String partSql = "";
	String partExclSql = "";
	String sqlCoverage = "";
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
	
	if(policyBean.getRestrictionMap() == null){
		policyBean.setRestrictionMap(new HashMap<String,String>());
	}
	System.err.println("Coming");
	HashMap<String, List<PolicyInsuranceMasterBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > popupMap = policyBean.getPopupMap();
	HashMap<String,String> restrictionMap = policyBean.getRestrictionMap();
	Connection 	connection = null;
	Boolean siteSpecRefPrice = false;//Added V181013-Aravindh/AAKH-CRF-0107
	System.err.println("Entered2");
	try 
	{
		con = ConnectionManager.getConnection();
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
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
		
		List<PolicyInsuranceMasterBean> covList = policyMap.get(func_mode);
		List<PolicyInsuranceMasterBean> policyList = new ArrayList<PolicyInsuranceMasterBean>();
		if(covList == null){
			covList = new ArrayList<PolicyInsuranceMasterBean>();	
		}
		
		if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{
			String payerGroup = request.getParameter("payergroupCode");
			String payer = request.getParameter("payerCode");
			String policy = request.getParameter("policyCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String policyNo = request.getParameter("policyNo");
			String patientId = request.getParameter("patientId");
			String visitId = request.getParameter("visitId");
			String acctSeq = request.getParameter("acctSeq");
			String priority = request.getParameter("priority");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String policyEncounter = request.getParameter("policyEncounter");
			String epsdEnc = request.getParameter("epsdEnc");
			String patClass = request.getParameter("patClass");
			String ageGrp = request.getParameter("ageGrp");
			String gender = request.getParameter("gender");
			String clinicNurs = request.getParameter("clinicNurs");
			String clinicNursCode = request.getParameter("clinicNursCode");
			String specCode = request.getParameter("specCode");
			String criteria = request.getParameter("criteria");
			String billServCode = request.getParameter("billServCode");
			
			if(restrictionMap.containsKey("C~"+payerGroup+"~"+payer+"~"+policy+"~"+
					patientId+"~"+visitId+"~"+acctSeq+"~"+priority+"~"+patientId+"~"+episodeType+"~"+episodeId+"~"+
					epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate)) {
								
				out.println("No");
			}
			else{
				if("policy".equals(policyEncounter)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_DTL") +
							"and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
							" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";
		
		
					pstmt = con.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,payerGroup);
					pstmt.setString(7,payer);
					pstmt.setString(8,policy);
					pstmt.setString(9,facilityId);
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
				}
				else if("encounter".equals(policyEncounter)){
					if(("I".equals(episodeType)) || ("D".equals(episodeType))){
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
					
					
					sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_FIRST_PART")+partExclSql+BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART")+partSql +
							"and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
							" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";
	
					pstmt = con.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,payerGroup);
					pstmt.setString(7,payer);
					pstmt.setString(8,policy);
					pstmt.setString(9,patientId);
					
					if(("I".equals(episodeType)) || ("D".equals(episodeType))){
						pstmt.setString(10,episodeType);
						pstmt.setString(11,episodeId);
						pstmt.setString(12,acctSeq);
						pstmt.setString(13,priority);
						
						pstmt.setString(14,facilityId);
						pstmt.setString(15,payerGroup);
						pstmt.setString(16,payer);
						pstmt.setString(17,policy);
						pstmt.setString(18,patientId);
						
						pstmt.setString(19,episodeType);
						pstmt.setString(20,episodeId);
						pstmt.setString(21,acctSeq);
						pstmt.setString(22,priority);
						
						pstmt.setString(23,criteria);
						pstmt.setString(24,billServCode);
						pstmt.setString(25,patClass);
						pstmt.setString(26,epsdEnc);
						pstmt.setString(27,gender);
						pstmt.setString(28,ageGrp);
						pstmt.setString(29,clinicNurs);
						pstmt.setString(30,clinicNursCode);
						pstmt.setString(31,specCode);
						pstmt.setString(32,startDate);
	
					}
					else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
						pstmt.setString(10,episodeType);
						pstmt.setString(11,episodeId);
						pstmt.setString(12,visitId);
						pstmt.setString(13,acctSeq);
						pstmt.setString(14,priority);
						
						pstmt.setString(15,facilityId);
						pstmt.setString(16,payerGroup);
						pstmt.setString(17,payer);
						pstmt.setString(18,policy);
						pstmt.setString(19,patientId);
						
						pstmt.setString(20,episodeType);
						pstmt.setString(21,episodeId);
						pstmt.setString(22,visitId);
						pstmt.setString(23,acctSeq);
						pstmt.setString(24,priority);
						
						pstmt.setString(25,criteria);
						pstmt.setString(26,billServCode);
						pstmt.setString(27,patClass);
						pstmt.setString(28,epsdEnc);
						pstmt.setString(29,gender);
						pstmt.setString(30,ageGrp);
						pstmt.setString(31,clinicNurs);
						pstmt.setString(32,clinicNursCode);
						pstmt.setString(33,specCode);
						pstmt.setString(34,startDate);
					}
					else if("R".equals(episodeType)){
						
						pstmt.setString(10,episodeType);
						pstmt.setString(11,acctSeq);
						pstmt.setString(12,priority);
						
						pstmt.setString(13,facilityId);
						pstmt.setString(14,payerGroup);
						pstmt.setString(15,payer);
						pstmt.setString(16,policy);
						pstmt.setString(17,patientId);
						
						pstmt.setString(18,episodeType);
						pstmt.setString(19,acctSeq);
						pstmt.setString(20,priority);
						
						pstmt.setString(21,criteria);
						pstmt.setString(22,billServCode);
						pstmt.setString(23,patClass);
						pstmt.setString(24,epsdEnc);
						pstmt.setString(25,gender);
						pstmt.setString(26,ageGrp);
						pstmt.setString(27,clinicNurs);
						pstmt.setString(28,clinicNursCode);
						pstmt.setString(29,specCode);
						pstmt.setString(30,startDate);
					}
					
	
					rst = pstmt.executeQuery();
				}
				
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
						fmtDtlsBean.setStatus("U");
						//Added for AAKH SCF - 0172
						if("encounter".equals(policyEncounter)){
							fmtDtlsBean.setEffectiveDate(rst.getString("effective_date"));
						}
						if(siteSpecRefPrice) {
							fmtDtlsBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181003-Aravindh/AAKH-CRF-0107
						}
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}
					
					if(rsCnt<1){
	
						PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
						policyList = new ArrayList<PolicyInsuranceMasterBean>();
						policyList.add(titleBean);
					}
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
				}
				
				if(rsCnt>0){
					covList.addAll(policyList);
				}
				
				policyMap.put("inclExclCoverage", covList);
				restrictionMap.put("C~"+payerGroup+"~"+payer+"~"+policy+"~"+
						patientId+"~"+visitId+"~"+acctSeq+"~"+priority+"~"+patientId+"~"+episodeType+"~"+episodeId+"~"+
						epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate,"Y");
			}
		}
		else if(func_mode!= null && func_mode.equals("preApproval")){
			String payerGroup = request.getParameter("payergroupCode");
			String payer = request.getParameter("payerCode");
			String policy = request.getParameter("policyCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String policyNo = request.getParameter("policyNo");
			String patientId = request.getParameter("patientId");
			String visitId = request.getParameter("visitId");
			String acctSeq = request.getParameter("acctSeq");
			String priority = request.getParameter("priority");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String policyEncounter = request.getParameter("policyEncounter");
			String epsdEnc = request.getParameter("epsdEnc");
			String patClass = request.getParameter("patClass");
			String ageGrp = request.getParameter("ageGrp");
			String gender = request.getParameter("gender");
			String clinicNurs = request.getParameter("clinicNurs");
			String clinicNursCode = request.getParameter("clinicNursCode");
			String specCode = request.getParameter("specCode");
			String criteria = request.getParameter("criteria");
			String billServCode = request.getParameter("billServCode");
			if(restrictionMap.containsKey("P~"+payerGroup+"~"+payer+"~"+policy+"~"+
					patientId+"~"+visitId+"~"+acctSeq+"~"+priority+"~"+patientId+"~"+episodeType+"~"+episodeId+"~"+
					epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate)) {
								
				out.println("No");
			}
			else{
				if("policy".equals(policyEncounter)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_PREAPPROVAL_DTL") +
							" and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
							" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";
	
	
					pstmt = con.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
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
					
				}
				else if("encounter".equals(policyEncounter)){
					if(("I".equals(episodeType)) || ("D".equals(episodeType))){
						partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
					}
					else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
						partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
					}
					else if("R".equals(episodeType)){
						partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
					}
					
					sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL")+partSql+
							" and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
							" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";
	
	
					pstmt = con.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,payerGroup);
					pstmt.setString(7,payer);
					pstmt.setString(8,policy);
					pstmt.setString(9,patientId);
					
					if(("I".equals(episodeType)) || ("D".equals(episodeType))){
						pstmt.setString(10,episodeType);
						pstmt.setString(11,episodeId);
						pstmt.setString(12,acctSeq);
						pstmt.setString(13,priority);
						
						pstmt.setString(14,criteria);
						pstmt.setString(15,billServCode);
						pstmt.setString(16,patClass);
						pstmt.setString(17,epsdEnc);
						pstmt.setString(18,gender);
						pstmt.setString(19,ageGrp);
						pstmt.setString(20,clinicNurs);
						pstmt.setString(21,clinicNursCode);
						pstmt.setString(22,specCode);
						pstmt.setString(23,startDate);
	
					}
					else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
						pstmt.setString(10,episodeType);
						pstmt.setString(11,episodeId);
						pstmt.setString(12,visitId);
						pstmt.setString(13,acctSeq);
						pstmt.setString(14,priority);
						
						pstmt.setString(15,criteria);
						pstmt.setString(16,billServCode);
						pstmt.setString(17,patClass);
						pstmt.setString(18,epsdEnc);
						pstmt.setString(19,gender);
						pstmt.setString(20,ageGrp);
						pstmt.setString(21,clinicNurs);
						pstmt.setString(22,clinicNursCode);
						pstmt.setString(23,specCode);
						pstmt.setString(24,startDate);
						
					}
					else if("R".equals(episodeType)){
						
						pstmt.setString(10,episodeType);
						pstmt.setString(11,acctSeq);
						pstmt.setString(12,priority);
						
						pstmt.setString(13,criteria);
						pstmt.setString(14,billServCode);
						pstmt.setString(15,patClass);
						pstmt.setString(16,epsdEnc);
						pstmt.setString(17,gender);
						pstmt.setString(18,ageGrp);
						pstmt.setString(19,clinicNurs);
						//Modified while Testing AAKH SCF - 0172
						pstmt.setString(20,clinicNursCode);
						pstmt.setString(21,specCode);
						pstmt.setString(22,startDate);
						
					}
					rst = pstmt.executeQuery();
					
				}
	
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
						fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
						fmtDtlsBean.setStatus("U");
						policyList.add(fmtDtlsBean);
						rsCnt++;					
					}
					if(rsCnt<1){
						PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						policyList = new ArrayList<PolicyInsuranceMasterBean>();
						policyList.add(titleBean);
					}
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					titleBean.setStartDate(startDate);
					titleBean.setEndDate(endDate);
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
				}
				
				if(rsCnt>0){
					covList.addAll(policyList);
				}
				
				policyMap.put("preApproval", covList);
				restrictionMap.put("P~"+payerGroup+"~"+payer+"~"+policy+"~"+
						patientId+"~"+visitId+"~"+acctSeq+"~"+priority+"~"+patientId+"~"+episodeType+"~"+episodeId+"~"+
						epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate,"Y");
			}
		}
		
		else if(func_mode!= null && func_mode.equals("preApprovalPopup")){
			String payerGroup = request.getParameter("payergroupCode");
			String payer = request.getParameter("payerCode");
			String policy = request.getParameter("policyCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String policyNo = request.getParameter("policyNo");
			String patientId = request.getParameter("patientId");
			String visitId = request.getParameter("visitId");
			String acctSeq = request.getParameter("acctSeq");
			String priority = request.getParameter("priority");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
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
			if(restrictionMap.containsKey("E~"+payerGroup+"~"+payer+"~"+policy+"~"+
					patientId+"~"+visitId+"~"+acctSeq+"~"+priority+"~"+patientId+"~"+episodeType+"~"+episodeId+"~"+
					encEpsd+"~"+patClass+"~"+ageGroup+"~"+gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+
					criteria+"~"+blngCode+"~"+startDate+"~"+criteriaPop+"~"+billServCodePop+"~"+startDatePop)) {
								
				out.println("No");
			}
			else{
				List<PolicyInsuranceMasterBean> popupList = popupMap.get(rowNumber);
	
				if(popupList == null){
					popupList = new ArrayList<PolicyInsuranceMasterBean>();	
				}
				
				if("policy".equals(policyEncounter)){
					sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP") +
									" and hdr.EXCL_SERV_EXCL_INCL_CRIT = ? and hdr.EXCL_BLNG_SERV_CODE = ? and TO_CHAR (hdr.EXCL_EFFECTIVE_FROM, 'dd/mm/yyyy') = ?";
		
		
					pstmt = con.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
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
				}
				else if("encounter".equals(policyEncounter)){
					if(("I".equals(episodeType)) || ("D".equals(episodeType))){
						partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
					}
					else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
						partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
					}
					else if("R".equals(episodeType)){
						partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
					}
					
					sqlCoverage =  BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL_POPUP")+partSql+
							" and hdr.EXCL_SERV_EXCL_INCL_CRIT = ? and hdr.EXCL_BLNG_SERV_CODE = ? and TO_CHAR (hdr.EXCL_EFFECTIVE_FROM, 'dd/mm/yyyy') = ?";
	
	
					pstmt = con.prepareStatement(sqlCoverage);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,payerGroup);
					pstmt.setString(4,payer);
					pstmt.setString(5,policy);
					pstmt.setString(6,criteria);
					pstmt.setString(7,blngCode);
					pstmt.setString(8,patClass);
					pstmt.setString(9,patientId);
					
					pstmt.setString(10,encEpsd);
					pstmt.setString(11,gender);
					pstmt.setString(12,ageGroup);
					pstmt.setString(13,clinicNursInd);
					pstmt.setString(14,clinicNursCode);
					pstmt.setString(15,spltyCode);
					pstmt.setString(16,startDate);
					
					if(("I".equals(episodeType)) || ("D".equals(episodeType))){
						pstmt.setString(17,episodeType);
						pstmt.setString(18,episodeId);
						pstmt.setString(19,acctSeq);
						pstmt.setString(20,priority);
						
						pstmt.setString(21,criteriaPop);
						pstmt.setString(22,billServCodePop);
						pstmt.setString(23,startDatePop);
	
					}
					else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
						pstmt.setString(17,episodeType);
						pstmt.setString(18,episodeId);
						pstmt.setString(19,visitId);
						pstmt.setString(20,acctSeq);
						pstmt.setString(21,priority);
						
						pstmt.setString(22,criteriaPop);
						pstmt.setString(23,billServCodePop);
						pstmt.setString(24,startDatePop);
						
					}
					else if("R".equals(episodeType)){
						
						pstmt.setString(17,episodeType);
						pstmt.setString(18,acctSeq);
						pstmt.setString(19,priority);
						
						pstmt.setString(20,criteriaPop);
						pstmt.setString(21,billServCodePop);
						pstmt.setString(22,startDatePop);
						
					}
					
					rst = pstmt.executeQuery();
				}
				
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
						fmtDtlsBean.setStatus("U");
						//Added for AAKH SCF - 0172
						if("encounter".equals(policyEncounter)){
							fmtDtlsBean.setEffectiveDate(rst.getString("effective_date"));
						}
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}
					
					if(rsCnt<1){
						PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						policyList = new ArrayList<PolicyInsuranceMasterBean>();
						policyList.add(titleBean);
					}
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					titleBean.setStartDate(startDate);
					titleBean.setEndDate(endDate);
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
				}		
				
				if(rsCnt>0){
					popupList.addAll(policyList);
				}
				
				popupMap.put(rowNumber, popupList);
				restrictionMap.put("E~"+payerGroup+"~"+payer+"~"+policy+"~"+
						patientId+"~"+visitId+"~"+acctSeq+"~"+priority+"~"+patientId+"~"+episodeType+"~"+episodeId+"~"+
						encEpsd+"~"+patClass+"~"+ageGroup+"~"+gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+
						criteria+"~"+blngCode+"~"+startDate+"~"+criteriaPop+"~"+billServCodePop+"~"+startDatePop, "Y");
			}
		}
		
		
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.out.println("Exception from BLDischargeValidation :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(con);
	}

	masterMap.put(priorityKey, policyBean);
	putObjectInBean("PayerPolicyInsuranceMasterBean",policyBeanMain,request);

%>

