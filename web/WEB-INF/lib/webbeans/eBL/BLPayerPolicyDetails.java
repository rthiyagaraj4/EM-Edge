/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Sr No        Version           TFS/Incident        			SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------------
1           V211112      	    25297			PMG2021-MMS-CRF-0004-TF-US001/01-Hyper link     Mohana Priya K
--------------------------------------------------------------------------------------------------------------
*/
 
package blPolicy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import eBL.PolicyInsuranceMasterBean;

public class BLPayerPolicyDetails {


	
	/*karthik Copied and modified*/
	
	PolicyInsuranceMasterBean outPatBean = new PolicyInsuranceMasterBean();
	PolicyInsuranceMasterBean inPatBean = new PolicyInsuranceMasterBean();
	PolicyInsuranceMasterBean externalBean = new PolicyInsuranceMasterBean();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString.trim();
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
    

	
	/*karthik  ends*/
	
	
	/*Encounter Specific Policy manipulation starts*/
    
	PolicyInsuranceMasterBean outPatBeanEnc = new PolicyInsuranceMasterBean();
	PolicyInsuranceMasterBean inPatBeanEnc = new PolicyInsuranceMasterBean();
	PolicyInsuranceMasterBean externalBeanEnc = new PolicyInsuranceMasterBean();

//public HashMap insertPreApprovalDetailsEncounter(Connection con, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {

	public HashMap insertPreApprovalDetails(Connection con, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {
		
		CallableStatement cstmtIns=null;
		CallableStatement cstmtUpd=null;
		CallableStatement cstmtDel=null;
		
		String str_error_level=null,str_sysmesage_id=null,str_error_text=null;
				
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{

			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPolicyMap();
			System.err.println("@@@@@insertPreApprovalDetails->policyMap@@@@@"+policyMap);
			con.setAutoCommit(false);
			List<PolicyInsuranceMasterBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get("preApproval");
				if(preAppList == null){
					preAppList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBeanEnc = new PolicyInsuranceMasterBean();
					preAppList.add(outPatBeanEnc);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				preAppList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBeanEnc = new PolicyInsuranceMasterBean();
				preAppList.add(outPatBeanEnc);		
			}
			
			System.err.println(preAppList);
			System.err.println(outPatBeanEnc);

			
			String preAppQueryIns = "{ call   blinstransactions.insert_enc_spec_preapp_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryUpd = "{ call   blinstransactions.update_enc_spec_preapp_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryDel = "{ call   blinstransactions.delete_enc_spec_preapp_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			int i=1;
			
			cstmtIns = con.prepareCall(preAppQueryIns);
			cstmtUpd = con.prepareCall(preAppQueryUpd);
			cstmtDel = con.prepareCall(preAppQueryDel);
			
		
			for(PolicyInsuranceMasterBean outPatBeanEnc : preAppList)
			{

			//		outPatBeanEnc.setStatus("I");
				System.err.println("Inside for loop");
				System.err.println(outPatBeanEnc.getDelFlag());
				System.err.println(outPatBeanEnc.getStatus());
				System.err.println(checkForNull(outPatBeanEnc.getStatus()));
				
				if("N".equals(outPatBeanEnc.getDelFlag())||outPatBeanEnc.getDelFlag()==null){
					if("I".equals(checkForNull(outPatBeanEnc.getStatus()))){

						System.err.println("*********** "+checkForNull(outPatBeanEnc.getEpisodeEncounter())+" "+ checkForNull(outPatBeanEnc.getPatClass())
							+"**"+checkForNull(outPatBeanEnc.getAgeGroup())+"**"+checkForNull(outPatBeanEnc.getGender())+" "+checkForNull(outPatBeanEnc.getClinicNursCode())+"**"+checkForNull(outPatBeanEnc.getSpecCode())+"**"+checkForNull(outPatBeanEnc.getBillServCode())+"**"+checkForNull(outPatBeanEnc.getStartDate()));

							if(("".equals(checkForNull(outPatBeanEnc.getEpisodeEncounter())) && "".equals(checkForNull(outPatBeanEnc.getPatClass())) && "".equals(checkForNull(outPatBeanEnc.getAgeGroup())) && "".equals(checkForNull(outPatBeanEnc.getGender()))  && "".equals(checkForNull(outPatBeanEnc.getClinicNursCode())) && "".equals(checkForNull(outPatBeanEnc.getSpecCode())) && "".equals(checkForNull(outPatBeanEnc.getBillServCode())))){
							}
							else{
							if(!("".equals(checkForNull(outPatBeanEnc.getEpisodeEncounter())) || "".equals(checkForNull(outPatBeanEnc.getPatClass())) || "".equals(checkForNull(outPatBeanEnc.getAgeGroup())) || "".equals(checkForNull(outPatBeanEnc.getGender()))  || "".equals(checkForNull(outPatBeanEnc.getClinicNursCode())) || "".equals(checkForNull(outPatBeanEnc.getSpecCode())) || "".equals(checkForNull(outPatBeanEnc.getBillServCode())) || "".equals(checkForNull(outPatBeanEnc.getStartDate()))))
								{
				


						System.err.println(preAppQueryIns);
						
						
						cstmtIns.setString(1, paramMap.get("facility_id"));
						cstmtIns.setString(2, paramMap.get("patientId"));
						cstmtIns.setString(3, paramMap.get("episodeType"));
						cstmtIns.setString(4, paramMap.get("episodeId"));
						cstmtIns.setString(5, paramMap.get("visitId"));
						cstmtIns.setString(6, paramMap.get("encounterId"));
						cstmtIns.setString(7, policyBean.getAccEntityID());
						cstmtIns.setString(8, paramMap.get("Priority"));
						cstmtIns.setString(9, policyBean.getPayerGroupCode());
						cstmtIns.setString(10, policyBean.getPolicyTypeCode());
						//cstmtIns.setString(11, policyBean.getPayerCode());
						cstmtIns.setString(11, policyBean.getpayerfrom());//V211112
						cstmtIns.setString(12, outPatBeanEnc.getBillServCode());
						cstmtIns.setString(13, outPatBeanEnc.getType());
						cstmtIns.setString(14, outPatBeanEnc.getPatClass());
						cstmtIns.setString(15, outPatBeanEnc.getEpisodeEncounter());
						cstmtIns.setString(16, outPatBeanEnc.getClinicNurs());
						cstmtIns.setString(17, outPatBeanEnc.getClinicNursCode());
						cstmtIns.setString(18, outPatBeanEnc.getSpecCode());
						cstmtIns.setString(19, outPatBeanEnc.getServLimit());
						cstmtIns.setString(20, outPatBeanEnc.getPreApprAmtCapping());
						cstmtIns.setString(21, outPatBeanEnc.getPreApprQtyCapping());
						if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
							cstmtIns.setString(22, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
							cstmtIns.setDate(22, fromDt);
						}
						
						if((outPatBeanEnc.getEndDate() == null) || ("".equals(outPatBeanEnc.getEndDate())) ){
							cstmtIns.setString(23, null);
						}
						else{
							Date toDate = new Date(sdf.parse(outPatBeanEnc.getEndDate()).getTime());
							cstmtIns.setDate(23, toDate);
						}
						cstmtIns.setString(24, outPatBeanEnc.getAmtGrossNet());	
						cstmtIns.setString(25, paramMap.get("addedById"));
						cstmtIns.setString(26, paramMap.get("addedById"));
						cstmtIns.setString(27, paramMap.get("modifiedAtWorkstation"));
						cstmtIns.setString(28, paramMap.get("facility_id"));
						cstmtIns.setString(29, paramMap.get("modifiedAtWorkstation"));
						cstmtIns.setString(30, paramMap.get("facility_id"));
						cstmtIns.setString(31, outPatBeanEnc.getGender());	
						cstmtIns.setString(32, outPatBeanEnc.getAgeGroup());	
						cstmtIns.registerOutParameter(33, java.sql.Types.VARCHAR);
						cstmtIns.registerOutParameter(34, java.sql.Types.VARCHAR);
						cstmtIns.registerOutParameter(35, java.sql.Types.VARCHAR);
						cstmtIns.execute();
						str_error_level = cstmtIns.getString(33);
						str_sysmesage_id = cstmtIns.getString(34);
						str_error_text = cstmtIns.getString(35);

						}	
						else 
						{
								str_error_text = "Include/ Exclude Coverage Tab. Row Number "+i+". Please Enter all mandatory fields";
								returnMap.put("errText",str_error_text);
								break;
						}
					}
					}
					else if("U".equals(checkForNull(outPatBeanEnc.getStatus()))){

						
						cstmtUpd.setString(1, paramMap.get("facility_id"));
						cstmtUpd.setString(2, paramMap.get("patientId"));
						cstmtUpd.setString(3, paramMap.get("episodeType"));
						cstmtUpd.setString(4, paramMap.get("episodeId"));
						cstmtUpd.setString(5, paramMap.get("visitId"));
						cstmtUpd.setString(6, paramMap.get("encounterId"));
						cstmtUpd.setString(7, policyBean.getAccEntityID());
						cstmtUpd.setString(8, paramMap.get("Priority"));
						cstmtUpd.setString(9, policyBean.getPayerGroupCode());
						cstmtUpd.setString(10, policyBean.getPolicyTypeCode());
						//cstmtUpd.setString(11, policyBean.getPayerCode());
						cstmtUpd.setString(11, policyBean.getpayerfrom());//V211112
						cstmtUpd.setString(12, outPatBeanEnc.getBillServCode());
						cstmtUpd.setString(13, outPatBeanEnc.getType());
						cstmtUpd.setString(14, outPatBeanEnc.getPatClass());
						cstmtUpd.setString(15, outPatBeanEnc.getEpisodeEncounter());
						cstmtUpd.setString(16, outPatBeanEnc.getClinicNurs());
						cstmtUpd.setString(17, outPatBeanEnc.getClinicNursCode());
						cstmtUpd.setString(18, outPatBeanEnc.getSpecCode());
						cstmtUpd.setString(19, outPatBeanEnc.getServLimit());
						cstmtUpd.setString(20, outPatBeanEnc.getPreApprAmtCapping());
						cstmtUpd.setString(21, outPatBeanEnc.getPreApprQtyCapping());
						if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
							cstmtUpd.setString(22, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
							cstmtUpd.setDate(22, fromDt);
						}
						
						if((outPatBeanEnc.getEndDate() == null) || ("".equals(outPatBeanEnc.getEndDate())) ){
							cstmtUpd.setString(23, null);
						}
						else{
							Date toDate = new Date(sdf.parse(outPatBeanEnc.getEndDate()).getTime());
							cstmtUpd.setDate(23, toDate);
						}
						cstmtUpd.setString(24, outPatBeanEnc.getAmtGrossNet());	
						cstmtUpd.setString(25, paramMap.get("addedById"));
						cstmtUpd.setString(26, paramMap.get("modifiedAtWorkstation"));
						cstmtUpd.setString(27, paramMap.get("facility_id"));
						cstmtUpd.setString(28, outPatBeanEnc.getGender());	
						cstmtUpd.setString(29, outPatBeanEnc.getAgeGroup());	
						cstmtUpd.registerOutParameter(30, java.sql.Types.VARCHAR);
						cstmtUpd.registerOutParameter(31, java.sql.Types.VARCHAR);
						cstmtUpd.registerOutParameter(32, java.sql.Types.VARCHAR);
						cstmtUpd.execute();
						str_error_level = cstmtUpd.getString(30);
						str_sysmesage_id = cstmtUpd.getString(31);
						str_error_text = cstmtUpd.getString(32);
					}
				}
				else if("Y".equals(outPatBeanEnc.getDelFlag())){
					
					
					cstmtDel.setString(1, paramMap.get("facility_id"));
					cstmtDel.setString(2, paramMap.get("patientId"));
					cstmtDel.setString(3, paramMap.get("episodeType"));
					cstmtDel.setString(4, paramMap.get("episodeId"));
					cstmtDel.setString(5, paramMap.get("visitId"));
					cstmtDel.setString(6, policyBean.getAccEntityID());
					cstmtDel.setString(7, paramMap.get("Priority"));
					cstmtDel.setString(8, outPatBeanEnc.getBillServCode());
					cstmtDel.setString(9, outPatBeanEnc.getType());
					cstmtDel.setString(10, outPatBeanEnc.getPatClass());
					cstmtDel.setString(11, outPatBeanEnc.getEpisodeEncounter());
					cstmtDel.setString(12, outPatBeanEnc.getClinicNurs());
					cstmtDel.setString(13, outPatBeanEnc.getClinicNursCode());
					cstmtDel.setString(14, outPatBeanEnc.getSpecCode());
					if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
						cstmtDel.setString(15, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
						cstmtDel.setDate(15, fromDt);
					}
					cstmtDel.setString(16, outPatBeanEnc.getGender());	
					cstmtDel.setString(17, outPatBeanEnc.getAgeGroup());	
					cstmtDel.registerOutParameter(18, java.sql.Types.VARCHAR);
					cstmtDel.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmtDel.registerOutParameter(20, java.sql.Types.VARCHAR);
					cstmtDel.execute();
					str_error_level = cstmtDel.getString(18);
					str_sysmesage_id = cstmtDel.getString(19);
					str_error_text = cstmtDel.getString(20);
				}
				
				
				System.err.println(str_error_level); 
				System.err.println(str_sysmesage_id);
				System.err.println(str_error_text);
				

				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "msgAdd"+i+"-"+l;
							//msgArr[l] = rb.getString(msgArr[l]);
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						//str_sysmesage_id = rb.getString(str_sysmesage_id);
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}
				i++;
			}
			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		
			
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			insertable = false;
		}
		finally{
			try
			{
		if(cstmtIns!=null)				cstmtIns.close();
		if(cstmtUpd!=null)				cstmtUpd.close();
		if(cstmtDel!=null)				cstmtDel.close();
			}catch(Exception ee) {}

			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
		
	}

//	public HashMap insertPolicyDetailsEncounter(Connection con,PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {

	public HashMap insertPolicyDetails(Connection con,PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {

		CallableStatement cstmtIns=null;
		CallableStatement cstmtUpd=null;
		CallableStatement cstmtDel=null;

		String str_error_level=null,str_sysmesage_id=null,str_error_text=null;
		HashMap returnMap = new HashMap();
		HashMap returnPopup = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPolicyMap();
			System.err.println("insertPolicyDetails->@@@@@policyMap@@@@@"+policyMap);
			con.setAutoCommit(false);
			System.err.println("Connection successful");
			List<PolicyInsuranceMasterBean> inclList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				inclList = policyMap.get("inclExclCoverage");
				if(inclList == null){
					inclList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBeanEnc = new PolicyInsuranceMasterBean();
					inclList.add(outPatBeanEnc);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				inclList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBeanEnc = new PolicyInsuranceMasterBean();
				inclList.add(outPatBeanEnc);		
			}
			System.err.println(inclList);
			System.err.println(outPatBeanEnc);
			
			String preAppQueryIns = "{ call   blinstransactions.insert_enc_spec_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryUpd = "{ call   blinstransactions.update_enc_spec_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryDel = "{ call   blinstransactions.delete_enc_spec_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";


			cstmtIns = con.prepareCall(preAppQueryIns);
			cstmtUpd = con.prepareCall(preAppQueryUpd);
			cstmtDel = con.prepareCall(preAppQueryDel);

			int i=1;
					
			for(PolicyInsuranceMasterBean outPatBeanEnc : inclList)
			{
			//		outPatBeanEnc.setStatus("I");
								System.err.println("Inside for loop");
								System.err.println(outPatBeanEnc.getDelFlag());
								System.err.println(outPatBeanEnc.getStatus());


							System.err.println("outPatBeanEnc.getDelFlag()");	
							System.err.println(" $$$$$$$$$  1= "+ paramMap.get("facility_id"));
							System.err.println(" $$$$$$$$$  2= "+ paramMap.get("patientId"));
							System.err.println(" $$$$$$$$$  3= "+ paramMap.get("episodeType"));
							System.err.println(" $$$$$$$$$  4= "+ paramMap.get("episodeId"));
							System.err.println(" $$$$$$$$$  5= "+ paramMap.get("visitId"));
							System.err.println(" $$$$$$$$$  6= "+ paramMap.get("encounterId"));
							System.err.println(" $$$$$$$$$  7= "+ policyBean.getAccEntityID());
							System.err.println(" $$$$$$$$$  8= "+ policyBean.getPayerCode());
							System.err.println(" $$$$$$$$$  9= "+ paramMap.get("Priority"));

							
							System.err.println(" $$$$$$$$$  10= "+ outPatBeanEnc.getInclExclCriteria());
							System.err.println(" $$$$$$$$$  11= "+ outPatBeanEnc.getBillServChk());
							System.err.println(" $$$$$$$$$  12= "+ outPatBeanEnc.getValueChk1());
							System.err.println(" $$$$$$$$$  13= "+ outPatBeanEnc.getInclExclIndChk());
							System.err.println(" $$$$$$$$$  14= "+ policyBean.getPolicyTypeCode());
							System.err.println(" $$$$$$$$$  15= "+ outPatBeanEnc.getBillServCode());
							System.err.println(" $$$$$$$$$  16= "+ outPatBeanEnc.getInclExclInd());
							System.err.println(" $$$$$$$$$  17= "+ outPatBeanEnc.getInclusionBasis());
							System.err.println(" $$$$$$$$$  18= "+ outPatBeanEnc.getValue());
							System.err.println(" $$$$$$$$$  23= "+ paramMap.get("addedById"));
							System.err.println(" $$$$$$$$$  24= "+ paramMap.get("addedById"));
							System.err.println(" $$$$$$$$$  25= "+ paramMap.get("modifiedAtWorkstation"));
							System.err.println(" $$$$$$$$$  26= "+ paramMap.get("facility_id"));
							System.err.println(" $$$$$$$$$  27= "+ paramMap.get("modifiedAtWorkstation"));
							System.err.println(" $$$$$$$$$  28= "+ paramMap.get("facility_id"));

							System.err.println(" $$$$$$$$$  29= "+ policyBean.getPayerGroupCode());
							System.err.println(" $$$$$$$$$  30= "+ paramMap.get("polRefCustCode"));
							System.err.println(" $$$$$$$$$  31= "+ outPatBeanEnc.getValueChk4());
							System.err.println(" $$$$$$$$$  32= "+ outPatBeanEnc.getValueChk3());
							System.err.println(" $$$$$$$$$  33= "+ paramMap.get("blngGrpid"));
							System.err.println(" $$$$$$$$$  34= "+ paramMap.get("policyNo"));
							System.err.println(" $$$$$$$$$  36= "+ outPatBeanEnc.getPatClass());
							System.err.println(" $$$$$$$$$  37= "+ outPatBeanEnc.getAmtPerVisit());
							System.err.println(" $$$$$$$$$  38= "+ outPatBeanEnc.getServItemQty());
							System.err.println(" $$$$$$$$$  39= "+ outPatBeanEnc.getAmtPerIPDay());
							System.err.println(" $$$$$$$$$  40= "+ outPatBeanEnc.getNoOfDays());
							System.err.println(" $$$$$$$$$  41= "+ outPatBeanEnc.getEpisodeEncounter());
							System.err.println(" $$$$$$$$$  42= "+ outPatBeanEnc.getClinicNurs());
							System.err.println(" $$$$$$$$$  43= "+ outPatBeanEnc.getClinicNursCode());
							System.err.println(" $$$$$$$$$  44= "+ outPatBeanEnc.getSpecCode());
							System.err.println(" $$$$$$$$$  46= "+ outPatBeanEnc.getAmtGrossNet());	
							System.err.println(" $$$$$$$$$  47= "+ outPatBeanEnc.getGender());	
							System.err.println(" $$$$$$$$$  48= "+ outPatBeanEnc.getAgeGroup());
							System.err.println(" $$$$$$$$$  49= "+ outPatBeanEnc.getPatCopay());	
							System.err.println(" $$$$$$$$$  50= "+ outPatBeanEnc.getPatLimitAmt());

		
											 System.err.println("*********** "+checkForNull(outPatBeanEnc.getEpisodeEncounter())+" "+ checkForNull(outPatBeanEnc.getPatClass())
							+"**"+checkForNull(outPatBeanEnc.getAgeGroup())+"**"+checkForNull(outPatBeanEnc.getGender())+" "+checkForNull(outPatBeanEnc.getClinicNursCode())+"**"+checkForNull(outPatBeanEnc.getSpecCode())+"**"+checkForNull(outPatBeanEnc.getBillServCode())+"**"+checkForNull(outPatBeanEnc.getStartDate()));


											System.err.println("****!@!#"+"".equals(checkForNull(outPatBeanEnc.getEpisodeEncounter()))+"".equals(checkForNull(outPatBeanEnc.getPatClass()))+"".equals(checkForNull(outPatBeanEnc.getAgeGroup()))+"".equals(checkForNull(outPatBeanEnc.getGender())) + "".equals(checkForNull(outPatBeanEnc.getClinicNursCode()))+"".equals(checkForNull(outPatBeanEnc.getSpecCode()))+"".equals(checkForNull(outPatBeanEnc.getBillServCode()))+"".equals(checkForNull(outPatBeanEnc.getStartDate())));

				if("N".equals(outPatBeanEnc.getDelFlag())||outPatBeanEnc.getDelFlag()==null){
					



					if(("I".equals(checkForNull(outPatBeanEnc.getStatus()))) || ("U".equals(checkForNull(outPatBeanEnc.getStatus())))){
						
						System.err.println("outPatBeanEnc.getStatus()");
						
						if("I".equals(checkForNull(outPatBeanEnc.getStatus()))){

							if(("".equals(checkForNull(outPatBeanEnc.getEpisodeEncounter())) && "".equals(checkForNull(outPatBeanEnc.getPatClass())) && "".equals(checkForNull(outPatBeanEnc.getAgeGroup())) && "".equals(checkForNull(outPatBeanEnc.getGender()))  && "".equals(checkForNull(outPatBeanEnc.getClinicNursCode())) && "".equals(checkForNull(outPatBeanEnc.getSpecCode())) && "".equals(checkForNull(outPatBeanEnc.getBillServCode())))){

								System.out.println(" Otehre values");
							}
							else{
							if(!("".equals(checkForNull(outPatBeanEnc.getEpisodeEncounter())) || "".equals(checkForNull(outPatBeanEnc.getPatClass())) || "".equals(checkForNull(outPatBeanEnc.getAgeGroup())) || "".equals(checkForNull(outPatBeanEnc.getGender()))  || "".equals(checkForNull(outPatBeanEnc.getClinicNursCode())) || "".equals(checkForNull(outPatBeanEnc.getSpecCode())) || "".equals(checkForNull(outPatBeanEnc.getBillServCode())) || "".equals(checkForNull(outPatBeanEnc.getStartDate()))))						

					//		if(true)
							{
								


							System.err.println(preAppQueryIns);
							
							cstmtIns.setString(1, paramMap.get("facility_id"));
							cstmtIns.setString(2, paramMap.get("patientId"));
							cstmtIns.setString(3, paramMap.get("episodeType"));
							cstmtIns.setString(4, paramMap.get("episodeId"));
							cstmtIns.setString(5, paramMap.get("visitId"));
							cstmtIns.setString(6, paramMap.get("encounterId"));
							cstmtIns.setString(7, policyBean.getAccEntityID());
							//cstmtIns.setString(8, policyBean.getPayerCode());
							cstmtIns.setString(8, policyBean.getpayerfrom());//V211112
							cstmtIns.setString(9, paramMap.get("Priority"));

							
							cstmtIns.setString(10, outPatBeanEnc.getInclExclCriteria());
							cstmtIns.setString(11, outPatBeanEnc.getBillServChk());
							cstmtIns.setString(12, outPatBeanEnc.getValueChk1());
							cstmtIns.setString(13, outPatBeanEnc.getInclExclIndChk());
							cstmtIns.setString(14, policyBean.getPolicyTypeCode());
							cstmtIns.setString(15, outPatBeanEnc.getBillServCode());
							cstmtIns.setString(16, outPatBeanEnc.getInclExclInd());
							cstmtIns.setString(17, outPatBeanEnc.getInclusionBasis());
							cstmtIns.setString(18, outPatBeanEnc.getValue());
							cstmtIns.setString(19, null);
							cstmtIns.setString(20, null);
							cstmtIns.setString(21, null);

							if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
								cstmtIns.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
								cstmtIns.setDate(22, fromDt);
							}
							cstmtIns.setString(23, paramMap.get("addedById"));
							cstmtIns.setString(24, paramMap.get("addedById"));
							cstmtIns.setString(25, paramMap.get("modifiedAtWorkstation"));
							cstmtIns.setString(26, paramMap.get("facility_id"));
							cstmtIns.setString(27, paramMap.get("modifiedAtWorkstation"));
							cstmtIns.setString(28, paramMap.get("facility_id"));

							cstmtIns.setString(29, policyBean.getPayerGroupCode());
							cstmtIns.setString(30, paramMap.get("polRefCustCode"));
							cstmtIns.setString(31, outPatBeanEnc.getValueChk4());
							cstmtIns.setString(32, outPatBeanEnc.getValueChk3());
							cstmtIns.setString(33, paramMap.get("blngGrpid"));
							cstmtIns.setString(34, paramMap.get("policyNo"));
							
							if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
								cstmtIns.setString(35, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
								cstmtIns.setDate(35, fromDt);
							}
							cstmtIns.setString(36, outPatBeanEnc.getPatClass());
							cstmtIns.setString(37, outPatBeanEnc.getAmtPerVisit());
							cstmtIns.setString(38, outPatBeanEnc.getServItemQty());
							cstmtIns.setString(39, outPatBeanEnc.getAmtPerIPDay());
							cstmtIns.setString(40, outPatBeanEnc.getNoOfDays());
						
							
							
							cstmtIns.setString(41, outPatBeanEnc.getEpisodeEncounter());
							cstmtIns.setString(42, outPatBeanEnc.getClinicNurs());
							cstmtIns.setString(43, outPatBeanEnc.getClinicNursCode());
							cstmtIns.setString(44, outPatBeanEnc.getSpecCode());

							if((outPatBeanEnc.getEndDate() == null) || ("".equals(outPatBeanEnc.getEndDate())) ){
								cstmtIns.setString(45, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBeanEnc.getEndDate()).getTime());
								cstmtIns.setDate(45, toDate);
							}
							
							cstmtIns.setString(46, outPatBeanEnc.getAmtGrossNet());	
							cstmtIns.setString(47, outPatBeanEnc.getGender());	
							cstmtIns.setString(48, outPatBeanEnc.getAgeGroup());
							System.err.println("KKKK insert_enc_spec_policy_dtl");
							System.err.println("KKKK getPatCopay"+outPatBeanEnc.getPatCopay());
							System.err.println("KKKK getPatLimitAmt"+outPatBeanEnc.getPatLimitAmt());
							cstmtIns.setString(49, outPatBeanEnc.getPatCopay());	
							cstmtIns.setString(50, outPatBeanEnc.getPatLimitAmt());
							cstmtIns.registerOutParameter(51, java.sql.Types.VARCHAR);
							cstmtIns.registerOutParameter(52, java.sql.Types.VARCHAR);
							cstmtIns.registerOutParameter(53, java.sql.Types.VARCHAR);
							cstmtIns.execute();
							str_error_level = cstmtIns.getString(51);
							str_sysmesage_id = cstmtIns.getString(52);
							str_error_text = cstmtIns.getString(53);

							//dhana		 
							}
							else
								{
								str_error_text = "Include/ Exclude Coverage Tab. Row Number "+i+". Please Enter all mandatory fields";
								returnMap.put("errText",str_error_text);
								break;
								}
							}

						}
						else if("U".equals(checkForNull(outPatBeanEnc.getStatus()))){
							
							cstmtUpd.setString(1, paramMap.get("facility_id"));
							cstmtUpd.setString(2, paramMap.get("patientId"));
							cstmtUpd.setString(3, paramMap.get("episodeType"));
							cstmtUpd.setString(4, paramMap.get("episodeId"));
							cstmtUpd.setString(5, paramMap.get("visitId"));
							cstmtUpd.setString(6, paramMap.get("encounterId"));
							cstmtUpd.setString(7, policyBean.getAccEntityID());
							//cstmtUpd.setString(8, policyBean.getPayerCode());
							cstmtUpd.setString(8, policyBean.getpayerfrom());//V211112
							cstmtUpd.setString(9, paramMap.get("Priority"));

							
							cstmtUpd.setString(10, outPatBeanEnc.getInclExclCriteria());
							cstmtUpd.setString(11, outPatBeanEnc.getBillServChk());
							cstmtUpd.setString(12, outPatBeanEnc.getValueChk1());
							cstmtUpd.setString(13, outPatBeanEnc.getInclExclIndChk());
							cstmtUpd.setString(14, policyBean.getPolicyTypeCode());
							cstmtUpd.setString(15, outPatBeanEnc.getBillServCode());
							cstmtUpd.setString(16, outPatBeanEnc.getInclExclInd());
							cstmtUpd.setString(17, outPatBeanEnc.getInclusionBasis());
							cstmtUpd.setString(18, outPatBeanEnc.getValue());
							cstmtUpd.setString(19, null);
							cstmtUpd.setString(20, null);
							cstmtUpd.setString(21, null);

							if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
								cstmtUpd.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
								cstmtUpd.setDate(22, fromDt);
							}
							cstmtUpd.setString(23, paramMap.get("addedById"));
							cstmtUpd.setString(24, paramMap.get("modifiedAtWorkstation"));
							cstmtUpd.setString(25, paramMap.get("facility_id"));

							cstmtUpd.setString(26, policyBean.getPayerGroupCode());
							cstmtUpd.setString(27, paramMap.get("polRefCustCode"));
							cstmtUpd.setString(28, outPatBeanEnc.getValueChk4());
							cstmtUpd.setString(29, outPatBeanEnc.getValueChk3());
							cstmtUpd.setString(30, paramMap.get("blngGrpid"));
							cstmtUpd.setString(31, paramMap.get("policyNo"));
							
							if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
								cstmtUpd.setString(32, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
								cstmtUpd.setDate(32, fromDt);
							}
							cstmtUpd.setString(33, outPatBeanEnc.getPatClass());
							cstmtUpd.setString(34, outPatBeanEnc.getAmtPerVisit());
							cstmtUpd.setString(35, outPatBeanEnc.getServItemQty());
							cstmtUpd.setString(36, outPatBeanEnc.getAmtPerIPDay());
							cstmtUpd.setString(37, outPatBeanEnc.getNoOfDays());
						
							
							
							cstmtUpd.setString(38, outPatBeanEnc.getEpisodeEncounter());
							cstmtUpd.setString(39, outPatBeanEnc.getClinicNurs());
							cstmtUpd.setString(40, outPatBeanEnc.getClinicNursCode());
							cstmtUpd.setString(41, outPatBeanEnc.getSpecCode());

							if((outPatBeanEnc.getEndDate() == null) || ("".equals(outPatBeanEnc.getEndDate())) ){
								cstmtUpd.setString(42, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBeanEnc.getEndDate()).getTime());
								cstmtUpd.setDate(42, toDate);
							}
							
							cstmtUpd.setString(43, outPatBeanEnc.getAmtGrossNet());	
							cstmtUpd.setString(44, outPatBeanEnc.getGender());	
							cstmtUpd.setString(45, outPatBeanEnc.getAgeGroup());	
							System.err.println("KKKK update_enc_spec_policy_dtl");
							System.err.println("KKKK getPatCopay"+outPatBeanEnc.getPatCopay());
							System.err.println("KKKK getPatLimitAmt"+outPatBeanEnc.getPatLimitAmt());
							cstmtUpd.setString(46, outPatBeanEnc.getPatCopay());	
							cstmtUpd.setString(47, outPatBeanEnc.getPatLimitAmt());
							cstmtUpd.registerOutParameter(48, java.sql.Types.VARCHAR);
							cstmtUpd.registerOutParameter(49, java.sql.Types.VARCHAR);
							cstmtUpd.registerOutParameter(50, java.sql.Types.VARCHAR);
							cstmtUpd.execute();
							str_error_level = cstmtUpd.getString(48);
							str_sysmesage_id = cstmtUpd.getString(49);
							str_error_text = cstmtUpd.getString(50);
						}
						
					
						
						if(str_error_level==null && str_error_text==null&&str_sysmesage_id==null){
							if("Y".equals(outPatBeanEnc.getServLimit())){
								returnPopup = insertPolictDetailsPopup(con,outPatBeanEnc,policyBean,paramMap);
								if(!(((Boolean) returnPopup.get("status")).booleanValue())){
									returnMap.putAll(returnPopup);
								}	
							}
						}
					}
				}
				else if("Y".equals(outPatBeanEnc.getDelFlag())){
					System.err.println("else if outPatBeanEnc.getDelFlag()");
					
					cstmtDel.setString(1, paramMap.get("facility_id"));
					cstmtDel.setString(2, paramMap.get("patientId"));
					cstmtDel.setString(3, paramMap.get("episodeType"));
					cstmtDel.setString(4, paramMap.get("episodeId"));
					cstmtDel.setString(5, paramMap.get("visitId"));
					cstmtDel.setString(6, policyBean.getAccEntityID());
					cstmtDel.setString(7, paramMap.get("Priority"));
					cstmtDel.setString(8, outPatBeanEnc.getPatClass());
					cstmtDel.setString(9, outPatBeanEnc.getInclExclCriteria());
					cstmtDel.setString(10, outPatBeanEnc.getBillServCode());
					cstmtDel.setString(11, outPatBeanEnc.getEpisodeEncounter());
					cstmtDel.setString(12, outPatBeanEnc.getClinicNurs());
					cstmtDel.setString(13, outPatBeanEnc.getClinicNursCode());
					
					cstmtDel.setString(14, outPatBeanEnc.getSpecCode());

					if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
						cstmtDel.setString(15, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
						cstmtDel.setDate(15, fromDt);
					}
					
					cstmtDel.setString(16, outPatBeanEnc.getGender());	
					cstmtDel.setString(17, outPatBeanEnc.getAgeGroup());	
					cstmtDel.registerOutParameter(18, java.sql.Types.VARCHAR);
					cstmtDel.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmtDel.registerOutParameter(20, java.sql.Types.VARCHAR);
					cstmtDel.execute();
					str_error_level = cstmtDel.getString(18);
					str_sysmesage_id = cstmtDel.getString(19);
					str_error_text = cstmtDel.getString(20);
				}

				System.err.println(str_error_level);
				System.err.println(str_sysmesage_id);
				System.err.println(str_error_text);
				
				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "msgAdd"+i+"-"+l;
							//msgArr[l] = rb.getString(msgArr[l]);
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						//str_sysmesage_id = rb.getString(str_sysmesage_id);
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}
				i++;
			}
			System.err.println("Outside for loop");

			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			insertable = false;
		}
		finally{
			try
			{
		if(cstmtIns!=null)				cstmtIns.close();
		if(cstmtUpd!=null)				cstmtUpd.close();
		if(cstmtDel!=null)				cstmtDel.close();
			}catch(Exception ee) {}
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}

	//public HashMap insertPolictDetailsPopupEncounter(Connection con, PolicyInsuranceMasterBean outPatBeanEnc2, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {
	public HashMap insertPolictDetailsPopup(Connection con, PolicyInsuranceMasterBean outPatBeanEnc2, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {

		CallableStatement cstmtIns=null;
		CallableStatement cstmtUpd=null;
		CallableStatement cstmtDel=null;

		String str_error_level=null,str_sysmesage_id=null,str_error_text=null;
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPopupMap();
			System.err.println("@@@@@insertPolictDetailsPopup->policyMap@@@@@"+policyMap);
			con.setAutoCommit(false);
			List<PolicyInsuranceMasterBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get(outPatBeanEnc2.getRowNumber());
				if(preAppList == null){
					preAppList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBeanEnc = new PolicyInsuranceMasterBean();
					preAppList.add(outPatBeanEnc);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				preAppList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBeanEnc = new PolicyInsuranceMasterBean();
				preAppList.add(outPatBeanEnc);		
			}
			
			System.err.println(preAppList);
			System.err.println(outPatBeanEnc);
			
			String preAppQueryIns = "{ call   blinstransactions.insert_enc_spec_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryUpd = "{ call   blinstransactions.update_enc_spec_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryDel = "{ call   blinstransactions.delete_enc_spec_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			int i=1;

			cstmtIns = con.prepareCall(preAppQueryIns);
			cstmtUpd = con.prepareCall(preAppQueryUpd);
			cstmtDel = con.prepareCall(preAppQueryDel);


			for(PolicyInsuranceMasterBean outPatBeanEnc : preAppList)
			{
							outPatBeanEnc.setStatus("I");
				if("N".equals(outPatBeanEnc.getDelFlag())||outPatBeanEnc.getDelFlag()==null){
					if(("I".equals(checkForNull(outPatBeanEnc.getStatus()))) || ("U".equals(checkForNull(outPatBeanEnc.getStatus())))){
						if("I".equals(checkForNull(outPatBeanEnc.getStatus()))){
							System.err.println(preAppQueryIns);
							cstmtIns = con.prepareCall(preAppQueryIns);
							cstmtIns.setString(1, paramMap.get("facility_id"));
							cstmtIns.setString(2, paramMap.get("patientId"));
							cstmtIns.setString(3, paramMap.get("episodeType"));
							cstmtIns.setString(4, paramMap.get("episodeId"));
							cstmtIns.setString(5, paramMap.get("visitId"));
							cstmtIns.setString(6, paramMap.get("encounterId"));
							cstmtIns.setString(7, policyBean.getAccEntityID());
							//cstmtIns.setString(8, policyBean.getPayerCode());
							cstmtIns.setString(8, policyBean.getpayerfrom());//V211112
							cstmtIns.setString(9, paramMap.get("Priority"));

							
							cstmtIns.setString(10, outPatBeanEnc2.getInclExclCriteria());
							cstmtIns.setString(11, outPatBeanEnc2.getBillServChk());
							cstmtIns.setString(12, outPatBeanEnc2.getValueChk1());
							cstmtIns.setString(13, outPatBeanEnc2.getInclExclIndChk());
							cstmtIns.setString(14, policyBean.getPolicyTypeCode());
							cstmtIns.setString(15, outPatBeanEnc2.getBillServCode());
							cstmtIns.setString(16, outPatBeanEnc.getInclExclInd());
							cstmtIns.setString(17, outPatBeanEnc.getInclusionBasis());
							cstmtIns.setString(18, outPatBeanEnc.getValue());
							cstmtIns.setString(19, null);
							cstmtIns.setString(20, null);
							cstmtIns.setString(21, null);
							
							
							if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
								cstmtIns.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
								cstmtIns.setDate(22, fromDt);
							}
							cstmtIns.setString(23, paramMap.get("addedById"));
							cstmtIns.setString(24, paramMap.get("addedById"));
							cstmtIns.setString(25, paramMap.get("modifiedAtWorkstation"));
							cstmtIns.setString(26, paramMap.get("facility_id"));
							cstmtIns.setString(27, paramMap.get("modifiedAtWorkstation"));
							cstmtIns.setString(28, paramMap.get("facility_id"));

							cstmtIns.setString(29, policyBean.getPayerGroupCode());
							cstmtIns.setString(30, paramMap.get("polRefCustCode"));
							cstmtIns.setString(31, outPatBeanEnc2.getValueChk4());
							cstmtIns.setString(32, outPatBeanEnc2.getValueChk3());
							cstmtIns.setString(33, paramMap.get("blngGrpid"));
							cstmtIns.setString(34, paramMap.get("policyNo"));
							
							if((outPatBeanEnc2.getStartDate() == null) || ("".equals(outPatBeanEnc2.getStartDate()))){
								cstmtIns.setString(35, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBeanEnc2.getStartDate()).getTime());
								cstmtIns.setDate(35, fromDt);
							}
							cstmtIns.setString(36, outPatBeanEnc2.getPatClass());
							cstmtIns.setString(37, outPatBeanEnc.getAmtPerVisit());
							cstmtIns.setString(38, outPatBeanEnc.getServItemQty());
							cstmtIns.setString(39, outPatBeanEnc.getAmtPerIPDay());
							cstmtIns.setString(40, outPatBeanEnc.getNoOfDays());
						
							
							
							cstmtIns.setString(41, outPatBeanEnc2.getEpisodeEncounter());
							cstmtIns.setString(42, outPatBeanEnc2.getClinicNurs());
							cstmtIns.setString(43, outPatBeanEnc2.getClinicNursCode());
							cstmtIns.setString(44, outPatBeanEnc2.getSpecCode());

							if((outPatBeanEnc2.getEndDate() == null) || ("".equals(outPatBeanEnc2.getEndDate())) ){
								cstmtIns.setString(45, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBeanEnc2.getEndDate()).getTime());
								cstmtIns.setDate(45, toDate);
							}
							
							cstmtIns.setString(46, outPatBeanEnc.getAmtGrossNet());	
							cstmtIns.setString(47, outPatBeanEnc.getInclExclCriteria());
							cstmtIns.setString(48, outPatBeanEnc.getBillServCode());
					
							if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
								cstmtIns.setString(49, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
								cstmtIns.setDate(49, fromDt);
							}
							if((outPatBeanEnc.getEndDate() == null) || ("".equals(outPatBeanEnc.getEndDate())) ){
								cstmtIns.setString(50, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBeanEnc.getEndDate()).getTime());
								cstmtIns.setDate(50, toDate);
							}

							cstmtIns.setString(51, outPatBeanEnc2.getGender());	
							cstmtIns.setString(52, outPatBeanEnc2.getAgeGroup());	
							System.err.println("KKKK insert_enc_spec_policy_excl");
							System.err.println("KKKK getPatCopay"+outPatBeanEnc.getPatCopay());
							System.err.println("KKKK getPatLimitAmt"+outPatBeanEnc.getPatLimitAmt());
							cstmtIns.setString(53, outPatBeanEnc.getPatCopay());	
							cstmtIns.setString(54, outPatBeanEnc.getPatLimitAmt());  
							
							cstmtIns.registerOutParameter(55, java.sql.Types.VARCHAR);
							cstmtIns.registerOutParameter(56, java.sql.Types.VARCHAR);
							cstmtIns.registerOutParameter(57, java.sql.Types.VARCHAR);
							cstmtIns.execute();
							str_error_level = cstmtIns.getString(55);
							str_sysmesage_id = cstmtIns.getString(56);
							str_error_text = cstmtIns.getString(57);
						}
						else if("U".equals(checkForNull(outPatBeanEnc.getStatus()))){
							
							cstmtUpd.setString(1, paramMap.get("facility_id"));
							cstmtUpd.setString(2, paramMap.get("patientId"));
							cstmtUpd.setString(3, paramMap.get("episodeType"));
							cstmtUpd.setString(4, paramMap.get("episodeId"));
							cstmtUpd.setString(5, paramMap.get("visitId"));
							cstmtUpd.setString(6, paramMap.get("encounterId"));
							cstmtUpd.setString(7, policyBean.getAccEntityID());
							//cstmtUpd.setString(8, policyBean.getPayerCode());
							cstmtUpd.setString(8, policyBean.getpayerfrom());//V211112
							cstmtUpd.setString(9, paramMap.get("Priority"));

							
							cstmtUpd.setString(10, outPatBeanEnc2.getInclExclCriteria());
							cstmtUpd.setString(11, outPatBeanEnc2.getBillServChk());
							cstmtUpd.setString(12, outPatBeanEnc2.getValueChk1());
							cstmtUpd.setString(13, outPatBeanEnc2.getInclExclIndChk());
							cstmtUpd.setString(14, policyBean.getPolicyTypeCode());
							cstmtUpd.setString(15, outPatBeanEnc2.getBillServCode());
							cstmtUpd.setString(16, outPatBeanEnc.getInclExclInd());
							cstmtUpd.setString(17, outPatBeanEnc.getInclusionBasis());
							cstmtUpd.setString(18, outPatBeanEnc.getValue());
							cstmtUpd.setString(19, null);
							cstmtUpd.setString(20, null);
							cstmtUpd.setString(21, null);
							
							
							if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
								cstmtUpd.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
								cstmtUpd.setDate(22, fromDt);
							}
							cstmtUpd.setString(23, paramMap.get("addedById"));
							cstmtUpd.setString(24, paramMap.get("modifiedAtWorkstation"));
							cstmtUpd.setString(25, paramMap.get("facility_id"));

							cstmtUpd.setString(26, policyBean.getPayerGroupCode());
							cstmtUpd.setString(27, paramMap.get("polRefCustCode"));
							cstmtUpd.setString(28, outPatBeanEnc2.getValueChk4());
							cstmtUpd.setString(29, outPatBeanEnc2.getValueChk3());
							cstmtUpd.setString(30, paramMap.get("blngGrpid"));
							cstmtUpd.setString(31, paramMap.get("policyNo"));
							
							if((outPatBeanEnc2.getStartDate() == null) || ("".equals(outPatBeanEnc2.getStartDate()))){
								cstmtUpd.setString(32, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBeanEnc2.getStartDate()).getTime());
								cstmtUpd.setDate(32, fromDt);
							}
							cstmtUpd.setString(33, outPatBeanEnc2.getPatClass());
							cstmtUpd.setString(34, outPatBeanEnc.getAmtPerVisit());
							cstmtUpd.setString(35, outPatBeanEnc.getServItemQty());
							cstmtUpd.setString(36, outPatBeanEnc.getAmtPerIPDay());
							cstmtUpd.setString(37, outPatBeanEnc.getNoOfDays());
						
							
							
							cstmtUpd.setString(38, outPatBeanEnc2.getEpisodeEncounter());
							cstmtUpd.setString(39, outPatBeanEnc2.getClinicNurs());
							cstmtUpd.setString(40, outPatBeanEnc2.getClinicNursCode());
							cstmtUpd.setString(41, outPatBeanEnc2.getSpecCode());

							if((outPatBeanEnc2.getEndDate() == null) || ("".equals(outPatBeanEnc2.getEndDate())) ){
								cstmtUpd.setString(42, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBeanEnc2.getEndDate()).getTime());
								cstmtUpd.setDate(42, toDate);
							}
							
							cstmtUpd.setString(43, outPatBeanEnc.getAmtGrossNet());	
							cstmtUpd.setString(44, outPatBeanEnc.getInclExclCriteria());
							cstmtUpd.setString(45, outPatBeanEnc.getBillServCode());
						
							if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
								cstmtUpd.setString(46, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
								cstmtUpd.setDate(46, fromDt);
							}
							if((outPatBeanEnc.getEndDate() == null) || ("".equals(outPatBeanEnc.getEndDate())) ){
								cstmtUpd.setString(47, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBeanEnc.getEndDate()).getTime());
								cstmtUpd.setDate(47, toDate);
							}
							cstmtUpd.setString(48, outPatBeanEnc2.getGender());	
							cstmtUpd.setString(49, outPatBeanEnc2.getAgeGroup());
							System.err.println("KKKK update_enc_spec_policy_excl");
							System.err.println("KKKK getPatCopay"+outPatBeanEnc.getPatCopay());
							System.err.println("KKKK getPatLimitAmt"+outPatBeanEnc.getPatLimitAmt());							
							cstmtUpd.setString(50, outPatBeanEnc.getPatCopay());	
							cstmtUpd.setString(51, outPatBeanEnc.getPatLimitAmt());
							cstmtUpd.registerOutParameter(52, java.sql.Types.VARCHAR);
							cstmtUpd.registerOutParameter(53, java.sql.Types.VARCHAR);
							cstmtUpd.registerOutParameter(54, java.sql.Types.VARCHAR);
							cstmtUpd.execute();
							str_error_level = cstmtUpd.getString(52);
							str_sysmesage_id = cstmtUpd.getString(53);
							str_error_text = cstmtUpd.getString(54);
						}
						
						
						
					}
				}
				else if("Y".equals(outPatBeanEnc.getDelFlag())){
					
					cstmtDel.setString(1, paramMap.get("facility_id"));
					cstmtDel.setString(2, paramMap.get("patientId"));
					cstmtDel.setString(3, paramMap.get("episodeType"));
					cstmtDel.setString(4, paramMap.get("episodeId"));
					cstmtDel.setString(5, paramMap.get("visitId"));
					cstmtDel.setString(6, policyBean.getAccEntityID());
					cstmtDel.setString(7, paramMap.get("Priority"));
					
					cstmtDel.setString(8, outPatBeanEnc2.getInclExclCriteria());
					cstmtDel.setString(9, outPatBeanEnc2.getBillServCode());


					if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
						cstmtDel.setString(10, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
						cstmtDel.setDate(10, fromDt);
					}
					
					cstmtDel.setString(11, outPatBeanEnc2.getPatClass());
					cstmtDel.setString(12, outPatBeanEnc2.getEpisodeEncounter());
					cstmtDel.setString(13, outPatBeanEnc2.getClinicNurs());
					cstmtDel.setString(14, outPatBeanEnc2.getClinicNursCode());
					
					cstmtDel.setString(15, outPatBeanEnc2.getSpecCode());
					cstmtDel.setString(16, outPatBeanEnc.getInclExclCriteria());
					cstmtDel.setString(17, outPatBeanEnc.getBillServCode());

					if((outPatBeanEnc.getStartDate() == null) || ("".equals(outPatBeanEnc.getStartDate()))){
						cstmtDel.setString(18, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBeanEnc.getStartDate()).getTime());
						cstmtDel.setDate(18, fromDt);
					}
					cstmtDel.setString(19, outPatBeanEnc2.getGender());	
					cstmtDel.setString(20, outPatBeanEnc2.getAgeGroup());	
					cstmtDel.registerOutParameter(21, java.sql.Types.VARCHAR);
					cstmtDel.registerOutParameter(22, java.sql.Types.VARCHAR);
					cstmtDel.registerOutParameter(23, java.sql.Types.VARCHAR);
					cstmtDel.execute();
					str_error_level = cstmtDel.getString(21);
					str_sysmesage_id = cstmtDel.getString(22);
					str_error_text = cstmtDel.getString(23);
				}

				System.err.println(str_error_level);
				System.err.println(str_sysmesage_id);
				System.err.println(str_error_text);

				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "msgAdd"+i+"-"+l;
							//msgArr[l] = rb.getString(msgArr[l]);
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						//str_sysmesage_id = rb.getString(str_sysmesage_id);
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}
				i++;
			}

			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			insertable = false;
		}
		finally{

			try
			{
		if(cstmtIns!=null)				cstmtIns.close();
		if(cstmtUpd!=null)				cstmtUpd.close();
		if(cstmtDel!=null)				cstmtDel.close();
			}catch(Exception ee) {}

			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
			
	}

	@SuppressWarnings("finally")
	//public HashMap<String, String> insertHeaderDetailsEncounter(Connection con, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {

	public HashMap<String, String> insertHeaderDetails(Connection con, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) {
		CallableStatement cstmt=null;	
		ResultSet rst = null;
		String str_error_level=null,str_sysmesage_id=null,str_error_text=null;
		HashMap returnMap = new HashMap();
		String partSql = "";
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPolicyMap();
			System.err.println("@@@@@insertHeaderDetails->policyMap@@@@@"+policyMap);
			con.setAutoCommit(false);
			int i=1;
			
			if(("I".equals(paramMap.get("episodeType"))) || ("D".equals(paramMap.get("episodeType")))){
				partSql = " and hdr.episode_type = ? and hdr.episode_id = ?  and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			else if(("O".equals(paramMap.get("episodeType"))) || ("E".equals(paramMap.get("episodeType")))){
				partSql = " and hdr.episode_type = ? and hdr.episode_id = ? and hdr.visit_id =? and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			else if("R".equals(paramMap.get("episodeType"))){
				partSql = " and hdr.episode_type = ?  and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			
			PreparedStatement pstmt = null;
			
			List<PolicyInsuranceMasterBean> outPatList = null; 
			List<PolicyInsuranceMasterBean> inPatList = null; 
			List<PolicyInsuranceMasterBean> externalList = null; 
			
			String sqlCoverage = "";
			
			if(!(policyMap == null || policyMap.isEmpty())){
				outPatList = policyMap.get("Outpatient");
				if(outPatList == null){
					outPatList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBeanEnc = new PolicyInsuranceMasterBean();
					outPatList.add(outPatBeanEnc);
				}
				System.err.println("in outPatList completed" + outPatList);
				inPatList = policyMap.get("Inpatient");
				System.err.println("inPatList>" + inPatList);
				if(inPatList == null){
					inPatList = new ArrayList<PolicyInsuranceMasterBean>();
					inPatBeanEnc = new PolicyInsuranceMasterBean();
					if("modify".equals(paramMap.get("mode"))){
						sqlCoverage = "select ip_cred_auth_req_yn,ip_cred_auth_mand_to_capt_yn,ip_dflt_auth_ref_as_pol_no_yn,"+
						"inpatient_covered,inpatient_limit_type,ip_approved_days_limit_type,ip_approved_no_of_days,"+
						"ip_approved_amt_limit_type,ip_approved_amt_limit,mand_bill_gen_check_ind_ip,mand_inv_gen_check_ind_ip "+
						"from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? "+partSql;
						
						
						
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,paramMap.get("facility_id"));
						pstmt.setString(2,policyBean.getPayerGroupCode());
						//pstmt.setString(3,policyBean.getPayerCode());
						pstmt.setString(3, policyBean.getpayerfrom());//V211112
						pstmt.setString(4,policyBean.getPolicyTypeCode());
						pstmt.setString(5,paramMap.get("patientId"));
						if(("I".equals(paramMap.get("episodeType"))) || ("D".equals(paramMap.get("episodeType")))){
							pstmt.setString(6,paramMap.get("episodeType"));
							pstmt.setString(7,paramMap.get("episodeId"));
							pstmt.setString(8,policyBean.getAccEntityID());
							pstmt.setString(9,paramMap.get("Priority"));
							pstmt.setString(10,paramMap.get("policyNo"));
						}
						else if(("O".equals(paramMap.get("episodeType"))) || ("E".equals(paramMap.get("episodeType")))){
							pstmt.setString(6,paramMap.get("episodeType"));
							pstmt.setString(7,paramMap.get("episodeId"));
							pstmt.setString(8,paramMap.get("visitId"));
							pstmt.setString(9,policyBean.getAccEntityID());
							pstmt.setString(10,paramMap.get("Priority"));
							pstmt.setString(11,paramMap.get("policyNo"));
						}
						else if("R".equals(paramMap.get("episodeType"))){
							pstmt.setString(6,paramMap.get("episodeType"));
							pstmt.setString(7,policyBean.getAccEntityID());
							pstmt.setString(8,paramMap.get("Priority"));
							pstmt.setString(9,paramMap.get("policyNo"));
						}

						rst = pstmt.executeQuery();
						
						if(rst!=null){
							while (rst.next()) {
								inPatBeanEnc.setCreditAuthReq(rst.getString("ip_cred_auth_req_yn"));
								inPatBeanEnc.setCreditAuthMand(rst.getString("ip_cred_auth_mand_to_capt_yn"));
								inPatBeanEnc.setCreditAuthRef(rst.getString("ip_dflt_auth_ref_as_pol_no_yn"));
								inPatBeanEnc.setCovered(rst.getString("inpatient_covered"));
								inPatBeanEnc.setCoverageLimitType(rst.getString("inpatient_limit_type"));
								inPatBeanEnc.setApprovedDays(rst.getString("ip_approved_days_limit_type"));
								inPatBeanEnc.setNoOfDays(rst.getString("ip_approved_no_of_days"));
								inPatBeanEnc.setApprovedAmt(rst.getString("ip_approved_amt_limit_type"));
								inPatBeanEnc.setLimitAmt(rst.getString("ip_approved_amt_limit"));
								inPatBeanEnc.setMandChkBillGen(rst.getString("mand_bill_gen_check_ind_ip"));
								inPatBeanEnc.setMandChkInvoiceGen(rst.getString("mand_inv_gen_check_ind_ip"));
								inPatList.add(inPatBeanEnc);
								
							}
						}
						else{

							inPatList.add(inPatBeanEnc);
						}		
					}
					else{
						inPatList.add(inPatBeanEnc);
					}
					System.err.println("in Pat null completed" + inPatList);
				}
				externalList = policyMap.get("External");
				if(externalList == null){
					externalList = new ArrayList<PolicyInsuranceMasterBean>();
					externalBeanEnc = new PolicyInsuranceMasterBean();
					if("modify".equals(paramMap.get("mode"))){
						sqlCoverage = "select ex_cred_auth_req_yn,ex_cred_auth_mand_to_capt_yn,ex_dflt_auth_ref_as_pol_no_yn,"+
						"external_covered,external_limit_type,ex_approved_days_limit_type,ex_approved_no_of_days,"+
						"ex_approved_amt_limit_type,ex_approved_amt_limit,mand_bill_gen_check_ind_ex,mand_inv_gen_check_ind_ex "+
						"from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? "+partSql;
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,paramMap.get("facility_id"));
						pstmt.setString(2,policyBean.getPayerGroupCode());
						//pstmt.setString(3,policyBean.getPayerCode());
						pstmt.setString(3, policyBean.getpayerfrom());//V211112
						pstmt.setString(4,policyBean.getPolicyTypeCode());
						pstmt.setString(5,paramMap.get("patientId"));
						if(("I".equals(paramMap.get("episodeType"))) || ("D".equals(paramMap.get("episodeType")))){
							pstmt.setString(6,paramMap.get("episodeType"));
							pstmt.setString(7,paramMap.get("episodeId"));
							pstmt.setString(8,policyBean.getAccEntityID());
							pstmt.setString(9,paramMap.get("Priority"));
							pstmt.setString(10,paramMap.get("policyNo"));
						}
						else if(("O".equals(paramMap.get("episodeType"))) || ("E".equals(paramMap.get("episodeType")))){
							pstmt.setString(6,paramMap.get("episodeType"));
							pstmt.setString(7,paramMap.get("episodeId"));
							pstmt.setString(8,paramMap.get("visitId"));
							pstmt.setString(9,policyBean.getAccEntityID());
							pstmt.setString(10,paramMap.get("Priority"));
							pstmt.setString(11,paramMap.get("policyNo"));
						}
						else if("R".equals(paramMap.get("episodeType"))){
							pstmt.setString(6,paramMap.get("episodeType"));
							pstmt.setString(7,policyBean.getAccEntityID());
							pstmt.setString(8,paramMap.get("Priority"));
							pstmt.setString(9,paramMap.get("policyNo"));
						}

						rst = pstmt.executeQuery();
						
						if(rst!=null){
							while (rst.next()) {
								externalBeanEnc.setCreditAuthReq(rst.getString("ex_cred_auth_req_yn"));
								externalBeanEnc.setCreditAuthMand(rst.getString("ex_cred_auth_mand_to_capt_yn"));
								externalBeanEnc.setCreditAuthRef(rst.getString("ex_dflt_auth_ref_as_pol_no_yn"));
								externalBeanEnc.setCovered(rst.getString("external_covered"));
								externalBeanEnc.setCoverageLimitType(rst.getString("external_limit_type"));
								externalBeanEnc.setApprovedDays(rst.getString("ex_approved_days_limit_type"));
								externalBeanEnc.setNoOfDays(rst.getString("ex_approved_no_of_days"));
								externalBeanEnc.setApprovedAmt(rst.getString("ex_approved_amt_limit_type"));
								externalBeanEnc.setLimitAmt(rst.getString("ex_approved_amt_limit"));
								externalBeanEnc.setMandChkBillGen(rst.getString("mand_bill_gen_check_ind_ex"));
								externalBeanEnc.setMandChkInvoiceGen(rst.getString("mand_inv_gen_check_ind_ex"));
								externalList.add(externalBeanEnc);
								
							}
						}
						else{
							externalList.add(externalBeanEnc);
						}					
					}
					else{
						externalList.add(externalBeanEnc);
					}
					System.err.println("externalList null completed" + externalList);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				outPatList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBeanEnc = new PolicyInsuranceMasterBean();
				outPatList.add(outPatBeanEnc);
				inPatList = new ArrayList<PolicyInsuranceMasterBean>();
				inPatBeanEnc = new PolicyInsuranceMasterBean();
				inPatList.add(inPatBeanEnc);
				externalList = new ArrayList<PolicyInsuranceMasterBean>();
				externalBeanEnc = new PolicyInsuranceMasterBean();
				externalList.add(externalBeanEnc);
				System.err.println("else else completed");
			}
			System.err.println("outPatList "+ outPatList + " inPatList" + inPatList +" externalList" +externalList );
			String headerQuery = "";
			outPatBeanEnc = outPatList.get(0);
			inPatBeanEnc = inPatList.get(0);
			externalBeanEnc = externalList.get(0);
			System.err.println("outPatBeanEnc 1329"+ outPatBeanEnc + " inPatBeanEnc" + inPatBeanEnc +" externalBeanEnc" +externalBeanEnc );
			System.err.println( policyBean.getpayerfrom());//V211112
			if("insert".equals(paramMap.get("mode"))){		
				System.err.println("policyBean.getpayerfrom()"); //V211112
				System.err.println( policyBean.getpayerfrom()); //V211112
				System.err.println(paramMap.get("facility_id"));
				System.err.println(paramMap.get("patientId"));
				System.err.println(paramMap.get("episodeType"));
				System.err.println(paramMap.get("episodeId"));
				System.err.println(paramMap.get("visitId"));
				System.err.println(paramMap.get("encounterId"));
				System.err.println(policyBean.getPolicyTypeCode());				
				System.err.println(paramMap.get("addedById"));
				System.err.println(paramMap.get("addedById"));
				System.err.println( paramMap.get("modifiedAtWorkstation"));
				System.err.println( paramMap.get("facility_id"));
				System.err.println( paramMap.get("modifiedAtWorkstation"));
				System.err.println( paramMap.get("facility_id"));				
				System.err.println( policyBean.getStatus());
				System.err.println( paramMap.get("illDedAmt"));
				System.err.println( paramMap.get("vstDedAmt"));
				System.err.println( policyBean.getAccEntityID());
				System.err.println( policyBean.getPayerCode());
				System.err.println( paramMap.get("Priority"));
				System.err.println( policyBean.getPayerGroupCode());
				System.err.println( paramMap.get("polRefCustCode"));
				System.err.println( paramMap.get("blngGrpid"));
				System.err.println( paramMap.get("policyNo"));
				System.err.println( "REPLACE");
				System.err.println( policyBean.getDefInclExclCriteria());
				System.err.println( policyBean.getOverRideInclExcl());
				System.err.println( policyBean.getLastPayer());
				System.err.println( policyBean.getCovInclOthPayers());
				System.err.println( outPatBeanEnc.getCreditAuthReq());
				System.err.println( inPatBeanEnc.getCreditAuthReq());
				System.err.println( externalBeanEnc.getCreditAuthReq());
				System.err.println( outPatBeanEnc.getCreditAuthMand());
				System.err.println( inPatBeanEnc.getCreditAuthMand());
				System.err.println( externalBeanEnc.getCreditAuthMand());
				System.err.println( outPatBeanEnc.getCreditAuthRef());
				System.err.println( inPatBeanEnc.getCreditAuthRef());
				System.err.println( externalBeanEnc.getCreditAuthRef());			
				System.err.println( outPatBeanEnc.getCovered());
				System.err.println( returnVal(inPatBeanEnc.getCovered(),"N"));
				System.err.println( externalBeanEnc.getCovered());
				System.err.println( outPatBeanEnc.getCoverageLimitType());
				System.err.println( inPatBeanEnc.getCoverageLimitType());
				System.err.println( externalBeanEnc.getCoverageLimitType());
				System.err.println( outPatBeanEnc.getApprovedDays());
				System.err.println( inPatBeanEnc.getApprovedDays());
				System.err.println( externalBeanEnc.getApprovedDays());
				System.err.println( (outPatBeanEnc.getNoOfDays()));
				System.err.println( (inPatBeanEnc.getNoOfDays()));
				System.err.println( (externalBeanEnc.getNoOfDays()));
				System.err.println( (outPatBeanEnc.getLimitAmt()));
				System.err.println( (inPatBeanEnc.getLimitAmt()));
				System.err.println( (externalBeanEnc.getLimitAmt()));					
				System.err.println( (outPatBeanEnc.getApprovedAmt()));
				System.err.println( (inPatBeanEnc.getApprovedAmt()));
				System.err.println( (externalBeanEnc.getApprovedAmt()));				
				System.err.println( outPatBeanEnc.getMandChkBillGen());
				System.err.println( inPatBeanEnc.getMandChkBillGen());
				System.err.println( externalBeanEnc.getMandChkBillGen());
				System.err.println( outPatBeanEnc.getMandChkInvoiceGen());
				System.err.println( inPatBeanEnc.getMandChkInvoiceGen());
				System.err.println( externalBeanEnc.getMandChkInvoiceGen());
				System.err.println( (outPatBeanEnc.getAmtGrossNet()));
				System.err.println( (inPatBeanEnc.getAmtGrossNet()));
				System.err.println( (externalBeanEnc.getAmtGrossNet()));
				System.err.println( (policyBean.getCoveragePer()));
				System.err.println( (policyBean.getCoverageBasis()));
				System.err.println((policyBean.getCoverageRules()));
				headerQuery = "{ call  blinstransactions.insert_enc_spec_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				cstmt = con.prepareCall(headerQuery);
				cstmt.setString(1, paramMap.get("facility_id"));
				cstmt.setString(2, paramMap.get("patientId"));
				cstmt.setString(3, paramMap.get("episodeType"));
				cstmt.setString(4, paramMap.get("episodeId"));
				cstmt.setString(5, paramMap.get("visitId"));
				cstmt.setString(6, paramMap.get("encounterId"));
				cstmt.setString(7, policyBean.getPolicyTypeCode());				
				cstmt.setString(8, paramMap.get("addedById"));
				cstmt.setString(9, paramMap.get("addedById"));
				cstmt.setString(10, paramMap.get("modifiedAtWorkstation"));
				cstmt.setString(11, paramMap.get("facility_id"));
				cstmt.setString(12, paramMap.get("modifiedAtWorkstation"));
				cstmt.setString(13, paramMap.get("facility_id"));				
				cstmt.setString(14, policyBean.getStatus());
				cstmt.setString(15, paramMap.get("illDedAmt"));
				cstmt.setString(16, paramMap.get("vstDedAmt"));
				cstmt.setString(17, policyBean.getAccEntityID());
			//	cstmt.setString(18, policyBean.getPayerCode());//V211112
				cstmt.setString(18, policyBean.getpayerfrom());//V211112
				cstmt.setString(19, paramMap.get("Priority"));
				cstmt.setString(20, policyBean.getPayerGroupCode());
				cstmt.setString(21, paramMap.get("polRefCustCode"));
				cstmt.setString(22, paramMap.get("blngGrpid"));
				cstmt.setString(23, paramMap.get("policyNo"));

				if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
					cstmt.setString(24, null);
					System.err.println( "REPLACE");
				}
				else{
					Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
					cstmt.setDate(24, fromDt);
					System.err.println( "REPLACE" + fromDt);
				}
				cstmt.setString(25, policyBean.getDefInclExclCriteria());
				cstmt.setString(26, policyBean.getOverRideInclExcl());
				cstmt.setString(27, policyBean.getLastPayer());
				cstmt.setString(28, policyBean.getCovInclOthPayers());
				cstmt.setString(29, outPatBeanEnc.getCreditAuthReq());
				cstmt.setString(30, inPatBeanEnc.getCreditAuthReq());
				cstmt.setString(31, externalBeanEnc.getCreditAuthReq());
				cstmt.setString(32, outPatBeanEnc.getCreditAuthMand());
				cstmt.setString(33, inPatBeanEnc.getCreditAuthMand());
				cstmt.setString(34, externalBeanEnc.getCreditAuthMand());
				cstmt.setString(35, outPatBeanEnc.getCreditAuthRef());
				cstmt.setString(36, inPatBeanEnc.getCreditAuthRef());
				cstmt.setString(37, externalBeanEnc.getCreditAuthRef());			
				cstmt.setString(38, outPatBeanEnc.getCovered());
				cstmt.setString(39, returnVal(inPatBeanEnc.getCovered(),"N"));
				cstmt.setString(40, externalBeanEnc.getCovered());
				cstmt.setString(41, outPatBeanEnc.getCoverageLimitType());
				cstmt.setString(42, inPatBeanEnc.getCoverageLimitType());
				cstmt.setString(43, externalBeanEnc.getCoverageLimitType());
				cstmt.setString(44, outPatBeanEnc.getApprovedDays());
				cstmt.setString(45, inPatBeanEnc.getApprovedDays());
				cstmt.setString(46, externalBeanEnc.getApprovedDays());
				cstmt.setString(47, (outPatBeanEnc.getNoOfDays()));
				cstmt.setString(48, (inPatBeanEnc.getNoOfDays()));
				cstmt.setString(49, (externalBeanEnc.getNoOfDays()));
				cstmt.setString(50, (outPatBeanEnc.getLimitAmt()));
				cstmt.setString(51, (inPatBeanEnc.getLimitAmt()));
				cstmt.setString(52, (externalBeanEnc.getLimitAmt()));					
				cstmt.setString(53, (outPatBeanEnc.getApprovedAmt()));
				cstmt.setString(54, (inPatBeanEnc.getApprovedAmt()));
				cstmt.setString(55, (externalBeanEnc.getApprovedAmt()));				
				cstmt.setString(56, outPatBeanEnc.getMandChkBillGen());
				cstmt.setString(57, inPatBeanEnc.getMandChkBillGen());
				cstmt.setString(58, externalBeanEnc.getMandChkBillGen());
				cstmt.setString(59, outPatBeanEnc.getMandChkInvoiceGen());
				cstmt.setString(60, inPatBeanEnc.getMandChkInvoiceGen());
				cstmt.setString(61, externalBeanEnc.getMandChkInvoiceGen());
				cstmt.setString(62, (outPatBeanEnc.getAmtGrossNet()));
				cstmt.setString(63, (inPatBeanEnc.getAmtGrossNet()));
				cstmt.setString(64, (externalBeanEnc.getAmtGrossNet()));
				cstmt.setString(65, (policyBean.getCoveragePer()));
				cstmt.setString(66, (policyBean.getCoverageBasis()));
				cstmt.setString(67, (policyBean.getCoverageRules()));
				
				System.err.println("KKKK insert_enc_spec_policy_hdr");
				System.err.println("KKKK outPatBeanEnc getPatCopay"+outPatBeanEnc.getPatCopay());
				System.err.println("KKKK inPatBeanEnc getPatCopay"+inPatBeanEnc.getPatCopay());
				System.err.println("KKKK externalBeanEnc getPatCopay"+externalBeanEnc.getPatCopay());
				System.err.println("KKKK outPatBeanEnc getPatLimitAmt"+outPatBeanEnc.getPatLimitAmt());
				System.err.println("KKKK inPatBeanEnc getPatLimitAmt"+inPatBeanEnc.getPatLimitAmt());
				System.err.println("KKKK externalBeanEnc getPatLimitAmt"+externalBeanEnc.getPatLimitAmt());
				
				cstmt.setString(68, outPatBeanEnc.getPatCopay());	
				cstmt.setString(69, inPatBeanEnc.getPatCopay());
				cstmt.setString(70, externalBeanEnc.getPatCopay());	
				cstmt.setString(71, outPatBeanEnc.getPatLimitAmt());
				cstmt.setString(72, inPatBeanEnc.getPatLimitAmt());	
				cstmt.setString(73, externalBeanEnc.getPatLimitAmt());
				
				/* 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts*/
				System.err.println("KKKK getAcrossGroupId"+policyBean.getAcrossGroupId());
				cstmt.setString(74, policyBean.getAcrossGroupId());
				
				cstmt.registerOutParameter(75, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(76, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(77, java.sql.Types.VARCHAR);
				cstmt.execute();
				str_error_level = cstmt.getString(75);
				str_sysmesage_id = cstmt.getString(76);
				str_error_text = cstmt.getString(77);
			}
			else if("modify".equals(paramMap.get("mode"))){
				headerQuery = "{ call  blinstransactions.update_enc_spec_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				System.err.println("exec blinstransactions.update_enc_spec_policy_hdr" );
				cstmt = con.prepareCall(headerQuery);
				cstmt.setString(1, paramMap.get("facility_id"));
				cstmt.setString(2, paramMap.get("patientId"));
				cstmt.setString(3, paramMap.get("episodeType"));
				cstmt.setString(4, paramMap.get("episodeId"));
				cstmt.setString(5, paramMap.get("visitId"));
				cstmt.setString(6, paramMap.get("encounterId"));
				cstmt.setString(7, policyBean.getPolicyTypeCode());
				
				cstmt.setString(8, paramMap.get("addedById"));
				cstmt.setString(9, paramMap.get("modifiedAtWorkstation"));
				cstmt.setString(10, paramMap.get("facility_id"));
				
				cstmt.setString(11, policyBean.getStatus());
				cstmt.setString(12, paramMap.get("illDedAmt"));
				cstmt.setString(13, paramMap.get("visitId"));
				cstmt.setString(14, policyBean.getAccEntityID());
				//cstmt.setString(15, policyBean.getPayerCode());
				cstmt.setString(15, policyBean.getpayerfrom());//V211112
				cstmt.setString(16, paramMap.get("Priority"));
				cstmt.setString(17, policyBean.getPayerGroupCode());
				cstmt.setString(18, paramMap.get("polRefCustCode"));
				cstmt.setString(19, paramMap.get("blngGrpid"));
				cstmt.setString(20, paramMap.get("policyNo"));

				if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
					cstmt.setString(21, null);
				}
				else{
					Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
					cstmt.setDate(21, fromDt);
				}
				cstmt.setString(22, policyBean.getDefInclExclCriteria());
				cstmt.setString(23, policyBean.getOverRideInclExcl());
				cstmt.setString(24, policyBean.getLastPayer());
				cstmt.setString(25, policyBean.getCovInclOthPayers());
				cstmt.setString(26, outPatBeanEnc.getCreditAuthReq());
				cstmt.setString(27, inPatBeanEnc.getCreditAuthReq());
				cstmt.setString(28, externalBeanEnc.getCreditAuthReq());
				cstmt.setString(29, outPatBeanEnc.getCreditAuthMand());
				cstmt.setString(30, inPatBeanEnc.getCreditAuthMand());
				cstmt.setString(31, externalBeanEnc.getCreditAuthMand());
				cstmt.setString(32, outPatBeanEnc.getCreditAuthRef());
				cstmt.setString(33, inPatBeanEnc.getCreditAuthRef());
				cstmt.setString(34, externalBeanEnc.getCreditAuthRef());			
				cstmt.setString(35, outPatBeanEnc.getCovered());
				cstmt.setString(36, returnVal(inPatBeanEnc.getCovered(),"N"));
				cstmt.setString(37, externalBeanEnc.getCovered());
				cstmt.setString(38, outPatBeanEnc.getCoverageLimitType());
				cstmt.setString(39, inPatBeanEnc.getCoverageLimitType());
				cstmt.setString(40, externalBeanEnc.getCoverageLimitType());
				cstmt.setString(41, outPatBeanEnc.getApprovedDays());
				cstmt.setString(42, inPatBeanEnc.getApprovedDays());
				cstmt.setString(43, externalBeanEnc.getApprovedDays());
				cstmt.setString(44, (outPatBeanEnc.getNoOfDays()));
				cstmt.setString(45, (inPatBeanEnc.getNoOfDays()));
				cstmt.setString(46, (externalBeanEnc.getNoOfDays()));
				cstmt.setString(47, (outPatBeanEnc.getLimitAmt()));
				cstmt.setString(48, (inPatBeanEnc.getLimitAmt()));
				cstmt.setString(49, (externalBeanEnc.getLimitAmt()));		
				
				cstmt.setString(50, (outPatBeanEnc.getApprovedAmt()));
				cstmt.setString(51, (inPatBeanEnc.getApprovedAmt()));
				cstmt.setString(52, (externalBeanEnc.getApprovedAmt()));	
				
				cstmt.setString(53, outPatBeanEnc.getMandChkBillGen());
				cstmt.setString(54, inPatBeanEnc.getMandChkBillGen());
				cstmt.setString(55, externalBeanEnc.getMandChkBillGen());
				cstmt.setString(56, outPatBeanEnc.getMandChkInvoiceGen());
				cstmt.setString(57, inPatBeanEnc.getMandChkInvoiceGen());
				cstmt.setString(58, externalBeanEnc.getMandChkInvoiceGen());
				cstmt.setString(59, (outPatBeanEnc.getAmtGrossNet()));
				cstmt.setString(60, (inPatBeanEnc.getAmtGrossNet()));
				cstmt.setString(61, (externalBeanEnc.getAmtGrossNet()));
				cstmt.setString(62, (policyBean.getCoveragePer()));
				cstmt.setString(63, (policyBean.getCoverageBasis()));
				cstmt.setString(64, (policyBean.getCoverageRules()));
				System.err.println("KKKK update_enc_spec_policy_hdr");
				System.err.println("KKKK outPatBeanEnc getPatCopay"+outPatBeanEnc.getPatCopay());
				System.err.println("KKKK inPatBeanEnc getPatCopay"+inPatBeanEnc.getPatCopay());
				System.err.println("KKKK externalBeanEnc getPatCopay"+externalBeanEnc.getPatCopay());
				System.err.println("KKKK outPatBeanEnc getPatLimitAmt"+outPatBeanEnc.getPatLimitAmt());
				System.err.println("KKKK inPatBeanEnc getPatLimitAmt"+inPatBeanEnc.getPatLimitAmt());
				System.err.println("KKKK externalBeanEnc getPatLimitAmt"+externalBeanEnc.getPatLimitAmt());
				
				cstmt.setString(65, outPatBeanEnc.getPatCopay());	
				cstmt.setString(66, inPatBeanEnc.getPatCopay());
				cstmt.setString(67, externalBeanEnc.getPatCopay());	
				cstmt.setString(68, outPatBeanEnc.getPatLimitAmt());
				cstmt.setString(69, inPatBeanEnc.getPatLimitAmt());	
				cstmt.setString(70, externalBeanEnc.getPatLimitAmt());
				/* 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts*/
				System.err.println("KKKK getAcrossGroupId"+policyBean.getAcrossGroupId());
				cstmt.setString(71, policyBean.getAcrossGroupId());				
				cstmt.registerOutParameter(72, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(73, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(74, java.sql.Types.VARCHAR);
				cstmt.execute();
				str_error_level = cstmt.getString(72);
				str_sysmesage_id = cstmt.getString(73);
				str_error_text = cstmt.getString(74);
				/* 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 ends*/
			}
			
			System.err.println(str_error_level);
			System.err.println(str_sysmesage_id);
			System.err.println(str_error_text);
			
			String errAdd = "errAdd"+i;
			String errTextAdd = "errTextAdd"+i;
			
			if(str_error_level!=null || str_error_text!=null){
				returnMap.put(errAdd, str_error_level+"-"+str_error_text);
			}
			
			if(str_sysmesage_id!=null){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						msgAdd = "msgAdd"+i+"-"+l;
						//msgArr[l] = rb.getString(msgArr[l]);
						returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "msgAdd"+i;
					//str_sysmesage_id = rb.getString(str_sysmesage_id);
					returnMap.put(msgAdd, str_sysmesage_id);
				}
			}
			i++;
			
			if((str_error_level==null) && (str_sysmesage_id==null) && (str_error_text==null)){
				returnMap.put("status", new Boolean(true));
			}
			else{
				returnMap.put("status", new Boolean(false));
			}

			returnMap=insertPlcyEncntercvrgeAprvDtls(con,policyBean,paramMap);
			
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			returnMap.put("status", new Boolean(false));

		}
		finally{
			try{
				if(cstmt!=null){
				cstmt.close();
				}
				}catch(Exception ee) {}
			
			return returnMap;
		}
		
		
		
		
	}
	
	
	public HashMap<String, String> insertPlcyEncntercvrgeAprvDtls(Connection con, PolicyInsuranceMasterBean policyBean,HashMap<String,String> paramMap) 
	
	{
		CallableStatement cstmt=null;	
		ResultSet rst = null;
		String str_error_level=null,str_sysmesage_id=null,str_error_text=null;
		HashMap returnMap = new HashMap();
		String partSql = "";
		
		String p_base_prev_ind  = "B";
		java.util.StringTokenizer strToken ;
		
		String p_pr_patient_id; 
		String p_pr_episode_type;
		String p_pr_episode_id ;
		String p_pr_visit_id; 
		String policyOrEncounter;
		int i=1;
		String errAdd = "errAdd"+i;
		
				
		
		String preAppQueryIns = "{ call   blinstransactions.insert_enc_spec_policy_dtl_blk (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		try
		{
			
			
			
			cstmt = con.prepareCall(preAppQueryIns);
			
			
			//		outPatBeanEnc.setStatus("I");
								System.err.println("Inside for loop");
								System.err.println(outPatBeanEnc.getDelFlag());
								System.err.println(outPatBeanEnc.getStatus());


							System.err.println(preAppQueryIns);
							p_base_prev_ind  = "B";							
							p_pr_patient_id		=	""; 
							p_pr_episode_type	=	"";
							p_pr_episode_id 	=	"";
							p_pr_visit_id	=		""; 
							
							policyOrEncounter =policyBean.getPolicyOrEncounter();
							
							if(policyOrEncounter == null) policyOrEncounter = "";
							if(policyOrEncounter.length()>0)
							{
								p_base_prev_ind  = "P";
								 strToken =new java.util.StringTokenizer(policyOrEncounter,":::");
								 if(strToken.hasMoreTokens())
								 {
								strToken.nextToken();
								p_pr_patient_id = strToken.nextToken();
								if(p_pr_patient_id.equals("null"))  p_pr_patient_id="";									
								p_pr_episode_type= strToken.nextToken();
								if(p_pr_episode_type.equals("null"))  p_pr_episode_type="";
								p_pr_episode_id =strToken.nextToken();
								if(p_pr_episode_id.equals("null"))  p_pr_episode_id="";
								p_pr_visit_id = strToken.nextToken();
								if(p_pr_visit_id.equals("null"))  p_pr_visit_id="";
								 }
							}
				
					
							cstmt.setString(1, paramMap.get("facility_id"));    
							cstmt.setString(2,policyBean.getPayerGroupCode());
							//cstmt.setString(3, policyBean.getPayerCode()); 
							cstmt.setString(3, policyBean.getpayerfrom());//V211112							
							cstmt.setString(4,policyBean.getPolicyTypeCode());  
							cstmt.setString(5,paramMap.get("episodeType"));               
							cstmt.setString(6,paramMap.get("patientId"));                
							cstmt.setString(7,paramMap.get("episodeId"));            
							cstmt.setString(8,paramMap.get("visitId"));                   
							cstmt.setString(9,p_pr_episode_type);               
							cstmt.setString(10,p_pr_patient_id);                 
							cstmt.setString(11,p_pr_episode_id);                 
							cstmt.setString(12,p_pr_visit_id);                   
							cstmt.setString(13,paramMap.get("encounterId"));                 
							cstmt.setString(14,"");                   
							cstmt.setString(15,paramMap.get("Priority"));      
							
							            
							
							if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
								cstmt.setString(16, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
								cstmt.setDate(16, fromDt);
							}
							
							cstmt.setString(17,paramMap.get("policyNo"));							        
							cstmt.setString(18,paramMap.get("blngGrpid"));               
							cstmt.setString(19,paramMap.get("polRefCustCode"));
							cstmt.setString(20,paramMap.get("addedById"));                   
							cstmt.setString(21,paramMap.get("modifiedAtWorkstation"));                
							cstmt.setString(22,paramMap.get("facility_id"));             
							cstmt.setString(23,p_base_prev_ind);                 
							
							
							
							cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(25, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
							cstmt.execute();
							str_error_level = cstmt.getString(24);
							str_sysmesage_id = cstmt.getString(25);
							str_error_text = cstmt.getString(26);
						
							
						
							if(str_error_text!=null){
								returnMap.put(errAdd, str_error_level+"-"+str_error_text);
							}
							
							if(str_sysmesage_id!=null){
								String msgAdd = "";
								if(str_sysmesage_id.contains("|")){
									String msgArr[] = str_sysmesage_id.split("\\|");
									for(int l=0;l<msgArr.length;l++){
										msgAdd = "msgAdd"+i+"-"+l;
										returnMap.put(msgAdd, msgArr[l]);
									}
								}else{
									msgAdd = "msgAdd"+i;
									returnMap.put(msgAdd, str_sysmesage_id);
								}
							}
							i++;
							
							if((str_sysmesage_id==null) && (str_error_text==null)){
								returnMap.put("status", new Boolean(true));
							}
							else{
								returnMap.put("status", new Boolean(false));
							}

							if(cstmt!=null){
								cstmt.close();
							}	
			
		}
		catch(Exception ee)
		{
			System.err.println("Exception  "+ee);
			
		}
		
		return returnMap;	
	}
	
	
	
	
	public HashMap<String, String> insertAuditProcedure(Connection con,HashMap<String,String> paramMap) {
		CallableStatement cstmt=null;	
		String str_error_level=null,str_sysmesage_id=null,str_error_text=null;
		int i=1;
		HashMap returnMap = new HashMap();
		try{
			System.err.println("@@@@@insertAuditProcedure->paramMap@@@@@"+paramMap);
			con.setAutoCommit(false);

			String headerQuery = "{ call  bl_recalc.Auditenctspecpolicydtls(?,?,?,?,?,?,?,?,?,?,?) }";
			System.err.println("exec bl_recalc.Auditenctspecpolicydtls" );
			cstmt = con.prepareCall(headerQuery);
			cstmt.setString(1, paramMap.get("facility_id"));
			cstmt.setString(2, null);
			cstmt.setString(3, paramMap.get("patientId"));
			cstmt.setString(4, paramMap.get("episodeType"));
			cstmt.setString(5, paramMap.get("episodeId"));
			cstmt.setString(6, paramMap.get("visitId"));
			cstmt.setString(7, getCurrentSequence(con,paramMap.get("patientId")));
			cstmt.setString(8, paramMap.get("addedById"));
			cstmt.setString(9, paramMap.get("modifiedAtWorkstation"));
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.execute();
			str_sysmesage_id = cstmt.getString(10);
			str_error_text = cstmt.getString(11);
		
			System.err.println(str_sysmesage_id);
			System.err.println(str_error_text);
			
			String errAdd = "errAdd"+i;
			
			if(str_error_text!=null){
				returnMap.put(errAdd, str_error_level+"-"+str_error_text);
			}
			
			if(str_sysmesage_id!=null){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						msgAdd = "msgAdd"+i+"-"+l;
						returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "msgAdd"+i;
					returnMap.put(msgAdd, str_sysmesage_id);
				}
			}
			i++;
			
			if((str_sysmesage_id==null) && (str_error_text==null)){
				returnMap.put("status", new Boolean(true));
			}
			else{
				returnMap.put("status", new Boolean(false));
			}

			
			
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			returnMap.put("status", new Boolean(false));

		}
		finally{
			try
			{
			if(cstmt!=null){
				cstmt.close();
			}
			}catch(Exception ee) {}
			return returnMap;
		}		
		
	}

	
	private String getCurrentSequence(Connection con,String patientId){
		String returnValue=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT CUR_ACCT_SEQ_NO FROM BL_PATIENT_FIN_DTLS  WHERE PATIENT_ID = ?";
			System.err.println(sql);
			pst = con.prepareStatement(sql);
			pst.setString(1, patientId);
			rs = pst.executeQuery();
				if (rs.next()) {
					returnValue=rs.getString(1);
				}
			} 
		catch (Exception e) {
			e.printStackTrace();
			returnValue=null;
		} 		
		finally
		{
			
			try
			{
			if(pst!=null) pst.close();
			}catch(Exception ee) {}
		}
		return returnValue;
	}
    
	/*Encounter Specific Policy manipulation ends*/
	
}
