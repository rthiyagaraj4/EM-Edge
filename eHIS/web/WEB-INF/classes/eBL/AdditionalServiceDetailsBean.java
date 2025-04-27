/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;

@SuppressWarnings("serial")
public class AdditionalServiceDetailsBean extends  BlAdapter implements Serializable{
	
	
	protected String 		serviceInd											= 	"";
	protected String 		serviceCode											= 	"";
	protected String 		serviceDesc											=	"";
	protected String 		priceInd											=	"";
	protected String 		priceCode											=	"";
	protected String 		priceDesc											=	"";
	protected String 		billingClass										=	"";
	protected String 		effectiveFrom										=	"";
	protected String 		chargeType											=	"";
	protected String 		Desc												=	"";
	protected String 		descApplicability									=	"";
	protected String 		effectiveTo											=	"";
	protected String 		facilityId											=	"";
	protected String 		policyCode											=	"";
	protected String 		policyDesc											=	"";
	protected String 		custCode											=	"";
	protected String 		custDesc											=	"";
	protected String 		ipRate												=	"";
	protected String 		opRate												=	"";
	protected String 		emerRate											=	"";
	protected String 		daycareRate											=	"";
	protected String 		refRate												=	"";
	protected String 		minCharge											=	"";
	protected String 		maxCharge											=	"";
	protected String 		baseQty												=	"";
	protected String 		policyNumber										=	"";
	protected String 		policyEffectiveFrom									=	"";
	protected String 		priority											=	"";
	protected String 		accountSequenceNO									=	"";
	protected String 		st_item_public_price_chk												=	"";
	protected String 		st_item_rate_basis_ind												=	"";

	
	public String getSt_item_rate_basis_ind() {
		return st_item_rate_basis_ind;
	}
	public void setSt_item_rate_basis_ind(String st_item_rate_basis_ind) {
		this.st_item_rate_basis_ind = st_item_rate_basis_ind;
	}
	
		public String getSt_item_public_price_chk() {
		return st_item_public_price_chk;
	}
	public void setSt_item_public_price_chk(String st_item_public_price_chk) {
		this.st_item_public_price_chk = st_item_public_price_chk;
	}
//Added V181005-Gayathri/MMS-DM-SCF-0243.1
	
	//protected ArrayList		ServiceIndList										=	null;
	    
	
	/**
	 * @return the patientId
	 */
	public String getFacilityId() {
		return facilityId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	/**
	 * @return the patientName
	 */
	public String getServiceInd() {
		return serviceInd;
	}
	/**
	 * @param patientName the patientName to set
	 */
	public void setServiceInd(String serviceInd) {
		this.serviceInd = serviceInd;
	}
	/**
	 * @return the episodeId
	 */
	public String getserviceCode() {
		return serviceCode;
	}
	/**
	 * @param episodeId the episodeId to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * @return the episodeType
	 */
	public String getServiceDesc() {
		return serviceDesc;
	}
	/**
	 * @param episodeType the episodeType to set
	 */
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	/**
	 * @return the encounterId
	 */
	public String getPriceInd() {
		return priceInd;
	}
	/**
	 * @param encounterId the encounterId to set
	 */
	public void setPriceInd(String priceInd) {
		this.priceInd = priceInd;
	}
	/**
	 * @return the age
	 */
	public String getPriceCode() {
		return priceCode;
	}
	/**
	 * @param age the age to set
	 */
	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getPriceDesc() {
		return priceDesc;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}
	/**
	 * @return the payerGroup
	 */
	public String getBillingClass() {
		return billingClass;
	}
	/**
	 * @param payerGroup the payerGroup to set
	 */
	public void setBillingClass(String billingClass) {
		this.billingClass = billingClass;
	}
	/**
	 * @return the payer
	 */
	public String getEffectiveFrom() {
		return effectiveFrom;
	}
	/**
	 * @param payer the payer to set
	 */
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	/**
	 * @return the policy
	 */
	public String getChargeType() {
		return chargeType;
	}
	/**
	 * @param policy the policy to set
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	/**
	 * @return the policyEffectiveTo
	 */
	public String getDesc() {
		return Desc;
	}
	/**
	 * @param policyEffectiveTo the policyEffectiveTo to set
	 */
	public void setDesc(String Desc) {
		this.Desc = Desc;
	}
	/**
	 * @return the effectiveTo
	 */
	public String getEffectiveTo() {
		return effectiveTo;
	}
	/**
	 * @param effectiveTo the effectiveTo to set
	 */
	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	/**
	 * @return the approvedAmount
	 */
	public String getDescApplicability() {
		return descApplicability;
	}
	/**
	 * @param approvedAmount the approvedAmount to set
	 */
	public void setDescApplicability(String descApplicability) {
		this.descApplicability = descApplicability;
	}
	/**
	 * @return the visitId
	 */
	public String getPolicyCode() {
		return policyCode;
	}
	/**
	 * @param visitId the visitId to set
	 */
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	/**
	 * @return the accountSeqNo
	 */
	public String getPolicyDesc() {
		return policyDesc;
	}
	/**
	 * @param accountSeqNo the accountSeqNo to set
	 */
	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}
	/**
	 * @return the payerGroupShortName
	 */
	public String getCustCode() {
		return custCode;
	}
	/**
	 * @param payerGroupShortName the payerGroupShortName to set
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	/**
	 * @return the payerShortName
	 */
	public String getCustDesc() {
		return custDesc;
	}
	/**
	 * @param payerShortName the payerShortName to set
	 */
	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}
	/**
	 * @return the serviceIndList
	 */
/*	public ArrayList getServiceIndList() {
		return ServiceIndList;
	}
	*//**
	 * @param serviceIndList the serviceIndList to set
	 *//*
	public void setServiceIndList(ArrayList serviceIndList) {
		ServiceIndList = serviceIndList;
	}*/
	
	
	/**
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}
	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	/**
	 * @return the policyEffectiveFrom
	 */
	public String getPolicyEffectiveFrom() {
		return policyEffectiveFrom;
	}
	/**
	 * @param policyEffectiveFrom the policyEffectiveFrom to set
	 */
	public void setPolicyEffectiveFrom(String policyEffectiveFrom) {
		this.policyEffectiveFrom = policyEffectiveFrom;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the accountSequenceNO
	 */
	public String getAccountSequenceNO() {
		return accountSequenceNO;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setAccountSequenceNO(String accountSequenceNO) {
		this.accountSequenceNO = accountSequenceNO;
	}
	public String getIpRate() {
		return ipRate;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setOpRate(String opRate) {
		this.opRate = opRate;
	}
	public String getOpRate() {
		return opRate;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setIpRate(String ipRate) {
		this.ipRate = ipRate;
	}
	public String getEmerRate() {
		return emerRate;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setEmerRate(String emerRate) {
		this.emerRate = emerRate;
	}
	public String getRefRate() {
		return refRate;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setRefRate(String refRate) {
		this.refRate = refRate;
	}
	public String getDaycareRate() {
		return daycareRate;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setDaycareRate(String daycareRate) {
		this.daycareRate = daycareRate;
	}
	public String getMinCharge() {
		return minCharge;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setMinCharge(String minCharge) {
		this.minCharge = minCharge;
	}
	public String getMaxCharge() {
		return maxCharge;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setMaxCharge(String maxCharge) {
		this.maxCharge = maxCharge;
	}
	public String getBaseQty() {
		return baseQty;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	public void setBaseQty(String baseQty) {
		this.baseQty = baseQty;
	}


	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedHashMap getPriceDetailsData(String serviceInd,String serviceCode,String priceInd,String priceCode,String billingClass,String effectiveFrom,String effectiveTo,String chargeType,String Desc,String  descApplicability, String  facilityId,String  locale,int startRcrd, int endRcrd)throws Exception 
	{
		Connection 						connection 									= 	null;		
		CallableStatement   			callableStatement							= 	null;
		String		 					sql											=	null;
		//ArrayList						recordApprovalPatientdataList				=   null;
		//String[]						arr											= 	null;
		Array							listArray									=	null;
		//String[]						patinetNameAndMobile						=	null;		
		LinkedHashMap					recordPriceDetailsDataMap					=	null;
		AdditionalServiceDetailsBean 	AdditionalServiceDetailsBean				=	null; 
		
		
		try
		{
			//System.out.println("In getPriceDetailsData:::: ");
			connection 					=	getConnection();
			recordPriceDetailsDataMap	=	new LinkedHashMap();
			sql							=	"{ call   IBAEHIS.blmultipricedtls.get_bl_price_serv_cust_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement 			= connection.prepareCall(sql);
			//System.out.println("facilityId======="+facilityId);
			callableStatement.setString(1,facilityId);
			//System.out.println("serviceInd======="+serviceInd);
			callableStatement.setString(2,serviceInd);
			//System.out.println("serviceCode======="+serviceCode);
			callableStatement.setString(3,serviceCode);
			//System.out.println("priceInd======="+priceInd);
			callableStatement.setString(4,priceInd);
			//System.out.println("priceCode======="+priceCode);
			callableStatement.setString(5,priceCode);       
			//System.out.println("billingClass======="+billingClass);
			callableStatement.setString(6,billingClass); 
			//System.out.println("effectiveFrom======="+effectiveFrom);

			if(effectiveFrom.length()==0 || effectiveFrom.equals("null"))			  callableStatement.setString(7,null);
			else			callableStatement.setDate(7,new Date(getDateInLong(effectiveFrom)));

			//System.out.println("effectiveTo======="+effectiveTo);

			if(effectiveTo.length()==0 || effectiveTo.equals("null") )				callableStatement.setString(8,null);
			else			callableStatement.setDate(8,new Date(getDateInLong(effectiveTo)));
			
			//System.out.println("chargeType======="+chargeType);
			callableStatement.setString(9,chargeType);
			//System.out.println("Desc======="+Desc);
			callableStatement.setString(10,Desc);	      
			//System.out.println("descApplicability======="+descApplicability);
			callableStatement.setString(11,descApplicability);
			callableStatement.setInt(12, startRcrd);
			callableStatement.setInt(13, endRcrd);
			callableStatement.registerOutParameter(14,java.sql.Types.INTEGER);
		//		callableStatement.setString(2,dummy);
		//		callableStatement.setString(3,dummy);
		//		callableStatement.setString(4,dummy);
		//		callableStatement.setString(5,dummy);       
		//		callableStatement.setString(6,dummy); 
			//	callableStatement.setDate(7,dummydate);   
			//	callableStatement.setDate(8,dummydate); 
			//	callableStatement.setString(9,dummy);
			//	callableStatement.setString(10,dummy);	      
			//	callableStatement.setString(11,dummy);
			callableStatement.registerOutParameter(15, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  
			callableStatement.registerOutParameter(16, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(18, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1"); 
			callableStatement.registerOutParameter(20, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(23, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT 
			callableStatement.registerOutParameter(24, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(25, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 

			callableStatement.execute(); 
			
			recordPriceDetailsDataMap.put("totalRecords",callableStatement.getInt(14));
			for(int k=15;k<26;k++)
			{
				listArray = callableStatement.getArray (k); 
				//System.out.println("listArray in getPriceDetailsData listArray :::<<<<<<<<,BEANNN>>>>>>>>"+listArray); 
	            Object[] values = (Object[]) listArray.getArray(); 
	            //System.out.println("Values[] in getPriceDetailsData values Length:::::<<<<<<<<,BEANNN>>>>>>>>"+values.length+" ::: "+values); 
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {
		            	//System.out.println("Values in getPriceDetailsData for :::<<<<<<<<,BEANNN>>>>>>>>"+k+" :::: <<<<<<<<,BEANNN>>>>>>>>"+values[i]); 
		           
			            if(recordPriceDetailsDataMap.containsKey(i))
		            	{
			            	AdditionalServiceDetailsBean = (AdditionalServiceDetailsBean) recordPriceDetailsDataMap.get(i);
		            		switch(k)
		            		{
			            		case 15: 	AdditionalServiceDetailsBean.setFacilityId(((String)values[i]));
	    									break;
				    			case 16: 	AdditionalServiceDetailsBean.setServiceInd((String)values[i]);
											break;
				    			case 17: 	AdditionalServiceDetailsBean.setServiceCode((String)(values[i]));
											break;
				    			case 18: 	AdditionalServiceDetailsBean.setServiceDesc((String)(values[i]));
											break;
				    			case 19: 	AdditionalServiceDetailsBean.setPriceInd((String)(values[i]));
											break;
				    			case 20: 	AdditionalServiceDetailsBean.setPriceCode(((String)values[i]));
											break;
				    			case 21: 	AdditionalServiceDetailsBean.setPriceDesc(((String)values[i]));
											break;
				    			case 22: 	AdditionalServiceDetailsBean.setPolicyCode(((String)values[i]));
											break;
				    			case 23: 	AdditionalServiceDetailsBean.setPolicyDesc(((String)values[i]));
											break;
				    			case 24: 	AdditionalServiceDetailsBean.setCustCode(((String)values[i]));
											break;
				    			case 25: 	AdditionalServiceDetailsBean.setCustDesc((String)(values[i]));
											break;
								default:	
		    				}
		            	}
		            	else
		            	{	
		            		AdditionalServiceDetailsBean = new AdditionalServiceDetailsBean();
		            		switch(k)
		            		{
			            		case 15: 	AdditionalServiceDetailsBean.setFacilityId(((String)values[i]));
	    									break;
				    			case 16: 	AdditionalServiceDetailsBean.setServiceInd((String)values[i]);
											break;
				    			case 17: 	AdditionalServiceDetailsBean.setServiceCode((String)(values[i]));
											break;
				    			case 18: 	AdditionalServiceDetailsBean.setServiceDesc((String)(values[i]));
											break;
				    			case 19: 	AdditionalServiceDetailsBean.setPriceInd((String)(values[i]));
											break;
				    			case 20: 	AdditionalServiceDetailsBean.setPriceCode(((String)values[i]));
											break;
				    			case 21: 	AdditionalServiceDetailsBean.setPriceDesc(((String)values[i]));
											break;
				    			case 22: 	AdditionalServiceDetailsBean.setPolicyCode(((String)values[i]));
											break;
				    			case 23: 	AdditionalServiceDetailsBean.setPolicyDesc(((String)values[i]));
											break;
				    			case 24: 	AdditionalServiceDetailsBean.setCustCode(((String)values[i]));
											break;
				    			case 25: 	AdditionalServiceDetailsBean.setCustDesc(String.valueOf(values[i]));
											break;
								default:	
		    				}
		            		recordPriceDetailsDataMap.put(i, AdditionalServiceDetailsBean);
		            	}
		            }    
				}     
	        }
	            
			   
			//System.out.println("IN getScreenServiceCriteria screenServiceCriteriaListMap::::::::<<<<<<<<,BEANNN>>>>>>>>"+recordPriceDetailsDataMap);
			//System.out.println("IN getScreenServiceCriteria screenServiceCriteriaListMap:size:::::::<<<<<<<<,BEANNN>>>>>>>>"+recordPriceDetailsDataMap.size());
			/*Iterator iterator= recordPriceDetailsDataMap.keySet().iterator();
			while(iterator.hasNext())
			{
				
				int key =    (Integer)iterator.next();
				System.out.println("IN getScreenServiceCriteria key:::::::"+key);
				AdditionalServiceDetailsBean = (AdditionalServiceDetailsBean) recordPriceDetailsDataMap.get(key);  
					System.out.println("INDEX::: "+key+" ::::PatientId::::::::::::::::: "+AdditionalServiceDetailsBean.getPatientId());
					System.out.println("INDEX::: "+key+" ::::bl_patient_name::::::::::: "+AdditionalServiceDetailsBean.getPatientName());
					System.out.println("INDEX::: "+key+" ::::bl_episode_id::::::::::::: "+AdditionalServiceDetailsBean.getEpisodeId());
					System.out.println("INDEX::: "+key+" ::::bl_visit_id::::::::::::::: "+AdditionalServiceDetailsBean.getVisitId());
					System.out.println("INDEX::: "+key+" ::::bl_encounter_id::::::::::: "+AdditionalServiceDetailsBean.getEncounterId());
					System.out.println("INDEX::: "+key+" ::::bl_patient_age_in_words::: "+AdditionalServiceDetailsBean.getAge());
					System.out.println("INDEX::: "+key+" ::::bl_mobile_num::::::::::::: "+AdditionalServiceDetailsBean.getMobileNumber());
					System.out.println("INDEX::: "+key+" ::::bl_cust_grp_code:::::::::: "+AdditionalServiceDetailsBean.getPayerGroup());
					System.out.println("INDEX::: "+key+" ::::bl_cust_grp_sname::::::::: "+AdditionalServiceDetailsBean.getPayerGroupShortName());
					System.out.println("INDEX::: "+key+" ::::bl_cust_code:::::::::::::: "+AdditionalServiceDetailsBean.getPayer());
					System.out.println("INDEX::: "+key+" ::::bl_cust_sname::::::::::::: "+AdditionalServiceDetailsBean.getPayerShortName());
					System.out.println("INDEX::: "+key+" ::::bl_policy_type_code::::::: "+AdditionalServiceDetailsBean.getPolicy());
					System.out.println("INDEX::: "+key+" ::::bl_policy_number:::::::::: "+AdditionalServiceDetailsBean.getPolicyNumber());
					System.out.println("INDEX::: "+key+" ::::bl_policy_eff_from:::::::: "+AdditionalServiceDetailsBean.getPolicyEffectiveFrom());
					System.out.println("INDEX::: "+key+" ::::bl_policy_eff_to:::::::::: "+AdditionalServiceDetailsBean.getPolicyEffectiveTo());
					System.out.println("INDEX::: "+key+" ::::bl_approved_amount:::::::: "+AdditionalServiceDetailsBean.getApprovedAmount());
					System.out.println("INDEX::: "+key+" ::::bl_priority::::::::::::::: "+AdditionalServiceDetailsBean.getPriority());
					System.out.println("INDEX::: "+key+" ::::bl_latest_acct_seq_no::::: "+AdditionalServiceDetailsBean.getAccountSequenceNO());
				
				
			}*/
			
		}catch(Exception e){
			System.out.println("Exception in getPriceDetailsData in AdditionalServiceDetailsBean=>>>>>>>><<<<<<<<,BEANNN>>>>>>>> "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(callableStatement!=null) callableStatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}

			return recordPriceDetailsDataMap;
		

		
	}
	
	/*
	* This method takes input in DD/MM/YYYY format and provides appropriate 
	* long value
	*/ 
	private long getDateInLong(String dateString){ 
		
		//System.out.println("dateString in getDateInLong ::: "+dateString);
	if(dateString==null){
	return 0; 
	}
	else{
	try {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Timestamp inputTimestamp = new Timestamp(sdf.parse(dateString).getTime());
	return inputTimestamp.getTime();
	} catch (ParseException e) {
	System.out.println("Error in Input Date Format");
	e.printStackTrace();
	}
	}
	return 0;
	} 
}
