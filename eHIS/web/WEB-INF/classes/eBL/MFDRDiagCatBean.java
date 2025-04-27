package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

public class MFDRDiagCatBean extends BlAdapter implements Serializable {

	private String facilityId;
	private String payer;
	private String payerCode;
	private String payerGroup;
	private String payerGroupCode;
	private String startDate;
	private String endDate;
	private String policyType;
	private String policyTypeCode;
	private String limitAmt;
	private String oldEndDate;
	private String patClass;

	private String episodeEncounter;
	private String Calledfrom; //004 changes
	private String status;
	
	private String amtGrossNet;
	private String rowNumber;
	private String patCopay;
	private String patLimitAmt;
	private String diagCat = "";

	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public String getOldEndDate() {
		return oldEndDate;
	}
	public void setOldEndDate(String oldEndDate) {
		this.oldEndDate = oldEndDate;
	}
	
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	
	public String getAmtGrossNet() {
		return amtGrossNet;
	}
	public void setAmtGrossNet(String amtGrossNet) {
		this.amtGrossNet = amtGrossNet;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPatCopay() {
		return patCopay;
	}
	public void setPatCopay(String patCopay) {
		this.patCopay = patCopay;
	}
	public String getPatLimitAmt() {
		return patLimitAmt;
	}
	public void setPatLimitAmt(String patLimitAmt) {
		this.patLimitAmt = patLimitAmt;
	}
	public String getDiagCat() {
		return diagCat;
	}
	public void setDiagCat(String diagCat) {
		this.diagCat = diagCat;
	}

	HashMap<String, List<MFDRDiagCatBean>> policyMap = null;
	List<MFDRDiagCatBean> policyList = null;
	
	List<MFDRDiagCatBean> popupList = null;
	HashMap<String, List<MFDRDiagCatBean>> popupMap = null;
	
	List<MFDRDiagCatBean> diagPopupList = null;//Added for MOHE-CRF-0114
	HashMap<String, List<MFDRDiagCatBean>> diagPopupMap = null;//Added for MOHE-CRF-0114	
	
	HashMap<String,MFDRDiagCatBean> masterMap = null;
	
	HashMap<String,String> restrictionMap = null;
	
	public HashMap<String, String> getRestrictionMap() {
		return restrictionMap;
	}
	public void setRestrictionMap(HashMap<String, String> restrictionMap) {
		this.restrictionMap = restrictionMap;
	}
	public HashMap<String, MFDRDiagCatBean> getMasterMap() {
		return masterMap;
	}
	public void setMasterMap(HashMap<String, MFDRDiagCatBean> masterMap) {
		this.masterMap = masterMap;
	}
	
	
	
	public List<MFDRDiagCatBean> getPopupList() {
		return popupList;
	}
	public void setPopupList(List<MFDRDiagCatBean> popupList) {
		this.popupList = popupList;
	}
	
	public HashMap<String, List<MFDRDiagCatBean>> getPopupMap() {
		return popupMap;
	}
	public void setPopupMap(
			HashMap<String, List<MFDRDiagCatBean>> popupMap) {
		this.popupMap = popupMap;
	}
	
	public String getPayerGroup() {
		return payerGroup;
	}
	public void setPayerGroup(String payerGroup) {
		this.payerGroup = payerGroup;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	
	public String getLimitAmt() {
		return limitAmt;
	}
	public void setLimitAmt(String limitAmt) {
		this.limitAmt = limitAmt;
	}
	
	public String getPatClass() {
		return patClass;
	}
	public void setPatClass(String patClass) {
		this.patClass = patClass;
	}
	
	public String getEpisodeEncounter() {
		return episodeEncounter;
	}
	public void setEpisodeEncounter(String episodeEncounter) {
		this.episodeEncounter = episodeEncounter;
	}
	
	public String getPolicyTypeCode() {
		return policyTypeCode;
	}
	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	public String getPayerGroupCode() {
		return payerGroupCode;
	}
	public void setPayerGroupCode(String payerGroupCode) {
		this.payerGroupCode = payerGroupCode;
	}

	public HashMap<String, List<MFDRDiagCatBean>> getPolicyMap() {
		return policyMap;
	}
	public void setPolicyMap(HashMap<String, List<MFDRDiagCatBean>> policyMap) {
		this.policyMap = policyMap;
	}
	public List<MFDRDiagCatBean> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(List<MFDRDiagCatBean> policyList) {
		this.policyList = policyList;
	}

	public String getCalledfrom() {
		return Calledfrom;
	}
	public void setCalledfrom(String Calledfrom) {
		this.Calledfrom = Calledfrom;
	}
		
	public List<MFDRDiagCatBean> getDiagPopupList() {
		return diagPopupList;
	}
	public void setDiagPopupList(List<MFDRDiagCatBean> diagPopupList) {
		this.diagPopupList = diagPopupList;
	}
	
	public HashMap<String, List<MFDRDiagCatBean>> getDiagPopupMap() {
		return diagPopupMap;
	}
	public void setDiagPopupMap(
			HashMap<String, List<MFDRDiagCatBean>> diagPopupMap) {
		this.diagPopupMap = diagPopupMap;
	}
	// Added for MOHE-CRF-0114 Ends
	public void clearAll(){
		policyMap = null;
		popupMap = null;
		policyList = null;
		popupList = null;
		masterMap = null;
		restrictionMap = null;
		facilityId = null; //V
		payer = null;
		payerCode = null;
		payerGroup = null;
		payerGroupCode = null;
		
		startDate = null;
		endDate = null;
		policyType = null;
		policyTypeCode= null;
		limitAmt = null;
		
		patClass = null;
		episodeEncounter = null;

		status = null;
		amtGrossNet = null;
		rowNumber = null;
		patCopay = null;
		patLimitAmt = null;
		oldEndDate = null;
		
		
		diagPopupList = null;
		diagPopupMap = null;
		
		
	}
	
	public  MFDRDiagCatBean getPolicyDefinitionDetials(String facility_id,String payerGroup,String payer, String policy,String locale){
		//System.err.println("Getting the Bean from PolicyDefinitionMasterBean - PDMB");
		MFDRDiagCatBean bean = new MFDRDiagCatBean();
		MFDRDiagCatBean fmtDtlsBean = new MFDRDiagCatBean();
		//MFDRDiagCatBean fmtDtlsBean1 = new MFDRDiagCatBean(); -->commented against checkstyle
		HashMap<String, List<MFDRDiagCatBean>> polMap = null;
		List<MFDRDiagCatBean> polList = null;	
		//List<MFDRDiagCatBean> popList = null; -->commented against checkstyle
		HashMap<String, List<MFDRDiagCatBean>> popMap = null;
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		PreparedStatement pstmt2 = null;
		ResultSet rst2 = null;
		
		
		try{
			String sqlInfoPage = "";
			System.err.println("Getting Header " +bean.getCalledfrom());
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("Getting infoframe Header ");
				sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEF_HDR_INFO");
			}
			else{
				System.err.println("Getting else Header ");
				sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEFN_HDR_INFO");
			}//V211103
			//String sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEF_HDR_INFO"); //V211103
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlInfoPage);
			//V210824
			pstmt.setString(1,payer);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,payerGroup);
			pstmt.setString(4,payer);
			pstmt.setString(5,policy);
			//V210824
			rst = pstmt.executeQuery();
			System.err.println(" Getting Header POLICY_DEF_HDR_INFO aftr,913");
			//System.err.println("PolicyInsuranceMaseterBean#########1"+facility_id+"   "+payerGroup+"  "+payer+"  "+policy);
			
			//Header
			System.err.println("PDMB - Getting Header " +bean.getCalledfrom());
			//System.err.println("PDMB - HDR sql->"+sqlInfoPage);
			//System.err.println("PDMB - params->"+facility_id+"-"+payerGroup+"-"+payer+"-"+policy);
			if(rst != null){
				while(rst.next()){
					bean.setPayerGroup(rst.getString("payer_group"));
					bean.setPayerGroupCode(rst.getString("CUST_GROUP_CODE"));
					bean.setPayer(rst.getString("payer"));
					bean.setPayerCode(rst.getString("CUST_CODE"));
					bean.setPolicyType(rst.getString("policy_type"));
					bean.setPolicyTypeCode(rst.getString("POLICY_TYPE_CODE"));
					bean.setFacilityId(rst.getString("operating_facility_id")); //V
					bean.setStartDate(rst.getString("effective_from"));
					bean.setEndDate(rst.getString("effective_to"));
					bean.setFacilityId(facility_id); //V
				}
			}

			pstmt = null;
			rst = null;
			//Header
			//Service Coverage		
		//	System.err.println("PDMB - Getting Service Coverage"+bean.getCalledfrom());
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframess");
				sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO");
			}else{
				System.err.println("POLICY_DEFN_SERVICE_INFO");
				sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEFN_SERVICE_INFO");
			}
		//	sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO");
			pstmt = con.prepareStatement(sqlInfoPage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			System.err.println(" POLICY_DEF_SERVICE_INFO,965");
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					
				}
			}
			pstmt = null;
			rst = null;
			//Service Coverage	
			polList = new ArrayList<MFDRDiagCatBean>();
			polMap = new HashMap<String,List<MFDRDiagCatBean>>();
			//Service Coverage	Tab - Outpatient
			String sqlCoverage ="";
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframes 1005");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO");
			}else{
				System.err.println("POLICY_DEFN_OUTPAT_INFO 1005");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_OUTPAT_INFO");
			}
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();

			cnt = 0;
			if(rst!=null){
				while (rst.next()) {
					fmtDtlsBean = new MFDRDiagCatBean();	
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					cnt++;
				}
				if(cnt>0){
					polMap.put("Outpatient", polList);
				}
				else{
					MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
					polList.add(titleBean);
					polMap.put("Outpatient", polList); 
				}
			}
			else{
				MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
				polList.add(titleBean);
				polMap.put("Outpatient", polList);
			}	
			//Service Coverage	Tab	- Outpatient	
			pstmt = null;
			rst = null;			
			polList = new ArrayList<MFDRDiagCatBean>();
			//Service Coverage	Tab	- Inpatient	
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframess ip");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
			}else{
				System.err.println("bean ip");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_INPAT_INFO");
			}
			//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
			cnt = 0;
			if(rst!=null){
				while (rst.next()) {
					fmtDtlsBean = new MFDRDiagCatBean();
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					cnt++;
				}
				if(cnt>0){
					polMap.put("Inpatient", polList);
				}
				else{
					MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
					polList.add(titleBean);
					polMap.put("Inpatient", polList); 
				}
			}
			else{
				MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
				polList.add(titleBean);
				polMap.put("Inpatient", polList);
			}	
			//Service Coverage	Tab	- Inpatient	
			pstmt = null;
			rst = null;			
			polList = new ArrayList<MFDRDiagCatBean>();
			//Service Coverage	Tab	- External	
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframess ex");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
			}else{
				System.err.println("info ex");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_EXTERNAL_INFO");
			}
			//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
			cnt = 0;
			if(rst!=null){
				while (rst.next()) {
					//System.err.println("PDMB - Going in RST");
					fmtDtlsBean = new MFDRDiagCatBean();
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					cnt++;
				}
				if(cnt>0){
					polMap.put("External", polList);
				}
				else{
					MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
					polList.add(titleBean);
					polMap.put("External", polList); 
				}
			}
			else{
				MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
				polList.add(titleBean);
				polMap.put("External", polList);
			}	
			pstmt = null;
			rst = null;			
		
			bean.setPolicyMap(polMap);
			bean.setPopupMap(popMap);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception In get Policy Bean Details 1365 :::"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			rst = null;
			rst2 = null;
			pstmt = null;
			pstmt2 = null;
		}
		return bean;
	}
	
	public  MFDRDiagCatBean getEncounterSpecificDetials(String facility_id,String payerGroup,
			String payer, String policy,String patientId,String episodeType,String episodeId,String visitId,
			String acctSeq,String priority,String policyNo,String locale){
		
		MFDRDiagCatBean bean = new MFDRDiagCatBean();
		MFDRDiagCatBean fmtDtlsBean = new MFDRDiagCatBean();
		MFDRDiagCatBean fmtDtlsBean1 = new MFDRDiagCatBean();
		HashMap<String, List<MFDRDiagCatBean>> polMap = null;
		List<MFDRDiagCatBean> polList = null;	
		List<MFDRDiagCatBean> popList = null;
		HashMap<String, List<MFDRDiagCatBean>> popMap = null;
		//int cnt = 0; --> commented against checkstyle
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		PreparedStatement pstmt2 = null;
		ResultSet rst2 = null;
		
		try{
			String sqlInfoPage =  "";
			String partSql = "";
			//String partExclSql = ""; --> commented against checkstyle. 
			String sqlCoverage = "";
			con = ConnectionManager.getConnection();
			
			//Service Coverage			
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			sqlInfoPage = BlRepository.getBlKeyValue("COMMON_ENCOUNTER_SERVICE_COVERAGE")+
									partSql;
							
			pstmt = con.prepareStatement(sqlInfoPage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}

			rst = pstmt.executeQuery();
			
			if(rst != null){
				while(rst.next()){
					bean.setStartDate(rst.getString("POLICY_EFF_FROM"));
					bean.setPayerCode(payer);
					bean.setPayerGroupCode(payerGroup);
					bean.setPolicyTypeCode(policy);
					bean.setFacilityId(facility_id); 
				}
			}
			
			pstmt = null;
			rst = null;
			//Service Coverage	
			partSql = "";
			sqlCoverage = "";
			polList = new ArrayList<MFDRDiagCatBean>();
			polMap = new HashMap<String,List<MFDRDiagCatBean>>();
			//Service Coverage	Tab - Outpatient
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_OUTPAT_INFO")+partSql;
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new MFDRDiagCatBean();
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					indCnt++;
					
				}
				
				if(indCnt>0){
						polMap.put("Outpatient", polList);
				}
				else{
					MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
					polList.add(titleBean);
					polMap.put("Outpatient", polList); 
				}
			}
			else{
				MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
				polList.add(titleBean);
				polMap.put("Outpatient", polList); 
			}	
			//Service Coverage	Tab	- Outpatient	
			pstmt = null;
			rst = null;			
			partSql = "";
			sqlCoverage = "";
			polList = new ArrayList<MFDRDiagCatBean>();
			//Service Coverage	Tab	- Inpatient	
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INPAT_INFO")+partSql;
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new MFDRDiagCatBean();
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					indCnt++;
					
				}
				
				if(indCnt>0){
					polMap.put("Inpatient", polList);
				}
				else{
					MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
					polList.add(titleBean);
					polMap.put("Inpatient", polList); 
				}
			}
			else{
				MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
				polList.add(titleBean);
				polMap.put("Inpatient", polList); 
			}	
			//Service Coverage	Tab	- Inpatient	
			pstmt = null;
			rst = null;			
			polList = new ArrayList<MFDRDiagCatBean>();
			//Service Coverage	Tab	- External	
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_EXTERNAL_INFO")+partSql;
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new MFDRDiagCatBean();
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					indCnt++;
					
				}
				
				if(indCnt>0){
					polMap.put("External", polList);
				}
				else{
					MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
					polList.add(titleBean);
					polMap.put("External", polList); 
				}
			}
			else{
				MFDRDiagCatBean titleBean = new MFDRDiagCatBean();
				polList.add(titleBean);
				polMap.put("External", polList); 
			}	
			pstmt = null;
			rst = null;			
			
			bean.setPolicyMap(polMap);
			bean.setPopupMap(popMap);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception In get Policy Bean Details 2084:::"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			rst = null;
			rst2 = null;
			pstmt = null;
			pstmt2 = null;
		}
		return bean;
	}

	public  MFDRDiagCatBean getPreviousEncounterDetials(String facility_id,String patientId,String episodeType,String episodeId,String visitId,
																 String locale,String encounterDate){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		MFDRDiagCatBean bean = new MFDRDiagCatBean();
		MFDRDiagCatBean fmtDtlsBean = new MFDRDiagCatBean();
		HashMap<String,MFDRDiagCatBean> masterMap = new HashMap<String, MFDRDiagCatBean>();
		try{
			
			con = ConnectionManager.getConnection();
			
			String strDeflPolicyDefn = "Select DFLT_POLICY_DEF_IN_VIS_REG_YN from bl_parameters";
			String deflPolicyDefYn = "";
			pstmt = con.prepareCall(strDeflPolicyDefn);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					deflPolicyDefYn = rst.getString("DFLT_POLICY_DEF_IN_VIS_REG_YN");
				}
			}
			rst = null;
			pstmt = null;
			
			String patientList =  "";
			
			if(("O".equals(episodeType)) ||  ("E".equals(episodeType))){
				patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_OE");
			}
			else if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_ID");
			}
			else if(("R".equals(episodeType))){
				patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_R_PREV");
			}

			if(!("R").equals(episodeType)){
				if(!(("".equals(patientId)) || ("".equals(episodeType)) || ("".equals(episodeId)))){
					pstmt = con.prepareStatement(patientList);
					pstmt.setString(1, patientId);
					pstmt.setString(2, episodeType);
					pstmt.setString(3, facility_id);
					pstmt.setString(4, patientId);
					pstmt.setInt(5, Integer.parseInt(episodeId));
					pstmt.setInt(6, Integer.parseInt(episodeId));
					pstmt.setString(7, facility_id);			
					pstmt.setInt(8, Integer.parseInt(episodeId));
					pstmt.setString(9, patientId);
					pstmt.setString(10, encounterDate);
					
					rst = pstmt.executeQuery();
				}
			}
			else{
				if(!(("".equals(patientId)) || ("".equals(episodeType)))){
					pstmt = con.prepareStatement(patientList);
					pstmt.setString(1, patientId);
					pstmt.setString(2, episodeType);
					pstmt.setString(3, facility_id);
					pstmt.setString(4, patientId);
					rst = pstmt.executeQuery();
					}
			}
			
			if(rst != null){
				while(rst.next()){
					fmtDtlsBean = new MFDRDiagCatBean();
					if("Y".equals(deflPolicyDefYn)){
						fmtDtlsBean = getPolicyDefinitionDetials(facility_id, rst.getString("CUST_GROUP_CODE"), rst.getString("CUST_CODE"), rst.getString("POLICY_TYPE_CODE"), locale);
					}
					else{
						fmtDtlsBean = getEncounterSpecificDetials(facility_id, rst.getString("CUST_GROUP_CODE"), rst.getString("CUST_CODE"), 
								rst.getString("POLICY_TYPE_CODE"), patientId, episodeType, episodeId, rst.getString("VISIT_ID"), 
								rst.getString("ACCT_SEQ_NO"), rst.getString("PRIORITY"), rst.getString("POLICY_NUMBER"), locale);
						
						
					}
					
					masterMap.put(rst.getString("PRIORITY")+"~"+rst.getString("CUST_GROUP_CODE")+"~"+rst.getString("CUST_CODE")+"~"+rst.getString("POLICY_TYPE_CODE")+"~"+rst.getString("POLICY_NUMBER"), fmtDtlsBean);
					
				}
			}
			
			bean.setMasterMap(masterMap);
		}
		
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception In get Policy Bean Details 2194:::"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			rst = null;
			pstmt = null;
		}
		return bean;
	}

}
