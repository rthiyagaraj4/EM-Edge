/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
2                                               TH-KW-CRF-0143                  Kamatchi S
 */
package eBL;
import java.io.*;
import java.util.*;

import javax.servlet.http.HttpSession;
import eCommon.Common.CommonAdapter;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.Common.BlAdapter;

@SuppressWarnings({"rawtypes","unchecked"})
public class BLCoderPatServiceBean extends BlAdapter implements Serializable {	
	public	HttpSession session ;
	static String  changeBlgName="";
	public LinkedHashMap hasBLCoderPatSearchValues		= new LinkedHashMap();
	HashSet unionKeys;
	public BLCoderPatServiceBean()
	{	
		System.err.println("BLCoderPatServiceBean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map  = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}

	public void clearBean()
	{
		if( hasBLCoderPatSearchValues != null )
	 	{
			hasBLCoderPatSearchValues.clear();
	 	}
		else
		{
			hasBLCoderPatSearchValues	= new java.util.LinkedHashMap();
		}	
	}	

	public LinkedHashMap getBLCoderPatSearchValues()
	{
		System.err.println("Values Temp Table to Hash  "+hasBLCoderPatSearchValues);
		return hasBLCoderPatSearchValues;		
	}

	public void setBLCoderPatSearchValues(LinkedHashMap hasBLCoderPatSearchValues) {
		this.hasBLCoderPatSearchValues = hasBLCoderPatSearchValues;
	}	
	
	public int getSize()
	{
		return  hasBLCoderPatSearchValues.size();
	}
	
	boolean compareServObject(BLCoderPatService  obj)
	{		
		int index;
		BLCoderPatService patServ;
		for(index=0;index<hasBLCoderPatSearchValues.size();index++)
		{
			patServ = (BLCoderPatService)hasBLCoderPatSearchValues.get(""+index);
			if(patServ.getApprovalNo().equals(obj.getApprovalNo()))    
			return true;
				}
		return false;
	}		
	
	public void getDBValues(String sessionId,String facilityId, String encounterId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BLCoderPatService  patServ;
		conn = ConnectionManager.getConnection();//Added by Kamatchi S for TH-KW-CRF-0143
		Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
		Boolean siteSpecPatPayable=false;//V230222/AAKH-CRF-0172
		siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
		siteSpecPatPayable =  eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_ALLOW_CASH_PAT_IN_CODER_FN");//V230222
		System.err.println("siteSpecPatPayable in BLCoderPatServiceBean.java "+siteSpecPatPayable);
		String sqlStr = "";
	try{
			//Condition Added by Kamatchi S for TH-KW-CRF-0143
			if(siteSpecServiceCode || siteSpecPatPayable)
			{
			/*	sqlStr = "SELECT session_id, operating_facility_id, bill_doc_type_code, bill_doc_num, cust_group_code, cust_code, trx_doc_ref, trx_doc_ref_line_num, trx_doc_ref_seq_num, to_char(trx_date,'DD/MM/YYYY hh24:mi:ss') as trx_date,episode_type, patient_id, episode_id, visit_id,encounter_id,settlement_ind,serv_type_ind,serv_type_desc,cpt_serv_item_code, blng_serv_code, serv_item_desc,serv_qty,to_char(service_date,'DD/MM/YYYY hh24:mi:ss') as servicedate ,physician_id,BASE_CHARGE_AMT service_amount,NVL (upd_gross_charge_amt, 0) - NVL (upd_net_charge_amt, 0) patient_amount,upd_net_charge_amt insurance_amount,modifier_adjuster_id,zero_price_yn,approval_no,billable_yn,add_row_yn,cancel_row_yn,cdr_approval_no,to_char(cdr_approval_given_date,'DD/MM/YYYY hh24:mi:ss') as cdr_approval_given_date,billed_yn,PERFORMING_PHYSICIAN_ID,PERFORMING_PRACT_NAME,ORDERING_PRACT_NAME,pre_approval_yn,primary_key_module_id FROM bl_cdr_pat_charges_folio_temp a WHERE session_id =? AND operating_facility_id = ? AND encounter_id = ? and (NVL (a.settlement_ind, 'N') = ( case when a.episode_type in ('I','D') THEN (Select settlement_ind from bl_episode_fin_dtls Where operating_facility_id = a.operating_facility_id and patient_id = a.patient_id And episode_type = a.episode_type And episode_id = a.episode_id) when a.episode_type in ('O','E') THEN (Select settlement_ind from bl_visit_fin_dtls Where operating_facility_id = a.operating_facility_id and patient_id = a.patient_id And episode_type = a.episode_type And episode_id = a.episode_id and visit_id = a.visit_id) else a.settlement_ind END ) ) and billable_yn <>'C' ORDER BY trx_status NULLS LAST,DECODE (SUBSTR (blng_serv_code, 1, 2), 'PH', 999, 1) DESC,service_date ASC,blng_serv_code ";*/
			sqlStr = "SELECT session_id, operating_facility_id, bill_doc_type_code, bill_doc_num, cust_group_code, cust_code, trx_doc_ref, trx_doc_ref_line_num, trx_doc_ref_seq_num, to_char(trx_date,'DD/MM/YYYY hh24:mi:ss') as trx_date,episode_type, patient_id, episode_id, visit_id,encounter_id,settlement_ind,serv_type_ind,serv_type_desc,cpt_serv_item_code, blng_serv_code, serv_item_desc,serv_qty,to_char(service_date,'DD/MM/YYYY hh24:mi:ss') as servicedate ,physician_id,BASE_CHARGE_AMT service_amount,bl_coders.get_ins_amt (operating_facility_id, trx_doc_ref, trx_doc_ref_line_num, cust_group_code, cust_code) insurance_amount,bl_coders.get_patient_amt (operating_facility_id, trx_doc_ref, trx_doc_ref_line_num) patient_amount,modifier_adjuster_id,zero_price_yn,approval_no,billable_yn,add_row_yn,cancel_row_yn,cdr_approval_no,to_char(cdr_approval_given_date,'DD/MM/YYYY hh24:mi:ss') as cdr_approval_given_date,billed_yn,PERFORMING_PHYSICIAN_ID,PERFORMING_PRACT_NAME,ORDERING_PRACT_NAME,pre_approval_yn,primary_key_module_id FROM bl_cdr_pat_charges_folio_temp a WHERE session_id =? AND operating_facility_id = ? AND encounter_id = ? and (NVL (a.settlement_ind, 'N') = ( case when a.episode_type in ('I','D') THEN (Select settlement_ind from bl_episode_fin_dtls Where operating_facility_id = a.operating_facility_id and patient_id = a.patient_id And episode_type = a.episode_type And episode_id = a.episode_id) when a.episode_type in ('O','E') THEN (Select settlement_ind from bl_visit_fin_dtls Where operating_facility_id = a.operating_facility_id and patient_id = a.patient_id And episode_type = a.episode_type And episode_id = a.episode_id and visit_id = a.visit_id) else a.settlement_ind END ) ) and billable_yn <>'C' ORDER BY trx_status NULLS LAST,DECODE (SUBSTR (blng_serv_code, 1, 2), 'PH', 999, 1) DESC,service_date ASC,blng_serv_code ";
			}
			else
			{
			sqlStr = "SELECT session_id, operating_facility_id, bill_doc_type_code, bill_doc_num, cust_group_code, cust_code, trx_doc_ref, trx_doc_ref_line_num, trx_doc_ref_seq_num, to_char(trx_date,'DD/MM/YYYY hh24:mi:ss') as trx_date,episode_type, patient_id, episode_id, visit_id,encounter_id,settlement_ind,serv_type_ind,serv_type_desc,cpt_serv_item_code, blng_serv_code, serv_item_desc,serv_qty,to_char(service_date,'DD/MM/YYYY hh24:mi:ss') as servicedate ,physician_id,BASE_CHARGE_AMT service_amount,NVL (upd_gross_charge_amt, 0) - NVL (upd_net_charge_amt, 0) patient_amount,upd_net_charge_amt insurance_amount,modifier_adjuster_id,zero_price_yn,approval_no,billable_yn,add_row_yn,cancel_row_yn,cdr_approval_no,to_char(cdr_approval_given_date,'DD/MM/YYYY hh24:mi:ss') as cdr_approval_given_date,billed_yn,PERFORMING_PHYSICIAN_ID,PERFORMING_PRACT_NAME,ORDERING_PRACT_NAME,pre_approval_yn,primary_key_module_id FROM bl_cdr_pat_charges_folio_temp a WHERE session_id =? AND operating_facility_id = ? AND encounter_id = ? AND NVL (settlement_ind, 'N') = 'X' and billable_yn <>'C' ORDER BY trx_status NULLS LAST,DECODE (SUBSTR (blng_serv_code, 1, 2), 'PH', 999, 1) DESC,service_date ASC,blng_serv_code ";	
			}
			System.err.println("Query to Fetch frm DB BLCoderPatServiceBean.java->  "+sqlStr);
			conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sqlStr);
			pstmt.setString(1,sessionId);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,encounterId);	
			System.err.println("SessionId inside Java  "+sessionId);
			System.err.println("facilityId Inside Java  "+facilityId);
			System.err.println("encounter_id inside Java  "+encounterId);			
			rs= pstmt.executeQuery();
			System.err.println("After Execute Query  ");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			 while(rs.next()) { 
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.err.print(",  ");
					String columnValue = rs.getString(i);
					System.err.print(columnValue + " " + rsmd.getColumnName(i));
				}
			 
				/*System.err.println("Inside  While  Result Set at line 88");
				System.err.println("bill_doc_type_code   "+rs.getString("bill_doc_type_code"));			
                System.err.println(" bill_doc_num  "+rs.getString("bill_doc_num"));			
                System.err.println("cust_group_code   "+rs.getString("cust_group_code"));
                System.err.println("cust_code   "+rs.getString("cust_code"));
                System.err.println(" trx_doc_ref  "+rs.getString("trx_doc_ref"));
                System.err.println("trx_doc_ref_line_num   "+rs.getString("trx_doc_ref_line_num"));		
                System.err.println("trx_doc_ref_seq_num   "+rs.getString("trx_doc_ref_seq_num"));		
                System.err.println("trx_date   "+rs.getString("trx_date"));
                System.err.println("episode_type   "+rs.getString("episode_type"));			
                System.err.println("patient_id   "+rs.getString("patient_id"));	
                System.err.println("episode_id   "+rs.getString("episode_id"));			
                System.err.println("visit_id   "+rs.getString("visit_id"));			
                System.err.println("encounter_id   "+rs.getString("encounter_id"));			
                System.err.println("settlement_ind   "+rs.getString("settlement_ind"));
                System.err.println("serv_type_ind   "+rs.getString("serv_type_ind"));			
                System.err.println("serv_type_desc   "+rs.getString("serv_type_desc"));			
                System.err.println("serv_item_code   "+rs.getString("serv_item_code"));			
                System.err.println("serv_item_desc   "+rs.getString("serv_item_desc"));			
                System.err.println(" serv_qty  "+rs.getString("serv_qty"));			
                System.err.println("service_date   "+rs.getString("service_date"));			
                System.err.println("physician_id   "+rs.getString("physician_id"));			
                System.err.println("service_amount   "+rs.getString("service_amount"));			
                System.err.println(" patient_amount  "+rs.getString("patient_amount"));			
                System.err.println(" insurance_amount  "+rs.getString("insurance_amount"));			
                System.err.println("modifier_adjuster_id   "+rs.getString("modifier_adjuster_id"));
                System.err.println(" zero_price_yn  "+rs.getString("zero_price_yn"));
                System.err.println("approval_no  "+rs.getString("approval_no"));			
                System.err.println("billable_yn   "+rs.getString("billable_yn"));			
                System.err.println(" add_row_yn  "+rs.getString("add_row_yn"));
                System.err.println(" cancel_row_yn  "+rs.getString("cancel_row_yn"));		
                System.err.println(" cdr_approval_no  "+rs.getString("cdr_approval_no"));
                System.err.println(" cdr_approval_given_date  "+rs.getString("cdr_approval_given_date"));
                System.err.println(" billed_yn  "+rs.getString("billed_yn"));*/

				patServ = new BLCoderPatService();
				patServ.setSessionId(sessionId);
				patServ.setOperatingFacilityId(facilityId);
				patServ.setBillDocTypeCode(checkForNull(rs.getString("bill_doc_type_code")));			
				patServ.setBillDocNum(checkForNull(rs.getString("bill_doc_num")));			
				patServ.setCustGroupCode(checkForNull(rs.getString("cust_group_code")));
				patServ.setCustCode(checkForNull(rs.getString("cust_code")));
				patServ.setTrxDocRef(checkForNull(rs.getString("trx_doc_ref")));
				patServ.setTrxDocRefLineNum(checkForNull(rs.getString("trx_doc_ref_line_num")));		
				patServ.setTrxDocRefSeqNum(checkForNull(rs.getString("trx_doc_ref_seq_num")));		
				patServ.setTrxDate(checkForNull(rs.getString("trx_date")));
				patServ.setEpisodeType(checkForNull(rs.getString("episode_type")));			
				patServ.setPatientId(checkForNull(rs.getString("patient_id")));	
				patServ.setEpisodeId(checkForNull(rs.getString("episode_id")));			
				patServ.setVisitId(checkForNull(rs.getString("visit_id")));			
				patServ.setEncounterId(checkForNull(rs.getString("encounter_id")));			
				patServ.setSettlementInd(checkForNull(rs.getString("settlement_ind")));
				patServ.setServTypeInd(checkForNull(rs.getString("serv_type_ind")));			
				patServ.setServTypeDesc(checkForNull(rs.getString("serv_type_desc")));		
				patServ.setcptCode(checkForNull(rs.getString("cpt_serv_item_code")));			
				patServ.setServItemCode(checkForNull(rs.getString("blng_serv_code")));			
				patServ.setServItemDesc(checkForNull(rs.getString("serv_item_desc")));			
				patServ.setServQty(checkForNull(rs.getString("serv_qty")));			
				patServ.setServiceDate(checkForNull(rs.getString("servicedate")));			
				patServ.setPhysicianId(checkForNull(rs.getString("physician_id")));			
				patServ.setServiceAmount(checkForNull(rs.getString("service_amount")));			
				patServ.setPatientAmount(checkForNull(rs.getString("patient_amount")));			
				patServ.setInsuranceAmount(checkForNull(rs.getString("insurance_amount")));			
				
				patServ.setPatientPayable(checkForNull(rs.getString("patient_amount")));//V230222
				
				patServ.setModifierAdjusterId(checkForNull(rs.getString("modifier_adjuster_id")));
				patServ.setZeroPriceYN(checkForNull(rs.getString("zero_price_yn")));
				patServ.setApprovalNo(checkForNull(rs.getString("approval_no")));			
				patServ.setBillableYN(checkForNull(rs.getString("billable_yn")));			
				patServ.setAddRowYN(checkForNull(rs.getString("add_row_yn")));
				patServ.setCancelRowYN(checkForNull(rs.getString("cancel_row_yn")));		
				patServ.setCDRApprovalNo(checkForNull(rs.getString("cdr_approval_no")));
				patServ.setCDRApprovalDate(checkForNull(rs.getString("cdr_approval_given_date")));
				patServ.setBillYN(checkForNull(rs.getString("billed_yn")));	
				patServ.setPerformPhysicianId(checkForNull(rs.getString("PERFORMING_PHYSICIAN_ID")));
				patServ.setPerformPhysicianName(checkForNull(rs.getString("PERFORMING_PRACT_NAME")));
				patServ.setOrderingPhysicianName(checkForNull(rs.getString("ORDERING_PRACT_NAME")));
				patServ.setlogInID(login_by_id);
				patServ.setlogInWSNo(login_at_ws_no);
				patServ.setPreAppFlag(checkForNull(rs.getString("pre_approval_yn")));
				patServ.setprimaryKeyModID(checkForNull(rs.getString("primary_key_module_id")));
				System.err.println("login_by_id getDBValues "+patServ.getlogInID());
				System.err.println("login_at_ws_no  getDBValues "+patServ.getlogInWSNo());			
				hasBLCoderPatSearchValues.put(""+patServ.getIndex(),patServ);
			}				
		}catch(Exception e){
			System.err.println("Exception e="+e);
			e.printStackTrace();
		}finally{
			System.err.println("Inside Finally");
			if(rs==null) {
				System.err.println("Result Set Empty");
			}
			if(rs!=null) {
				 System.err.println("Result Set Not Empty");
				rs.close();
			}
			if(pstmt!=null) 
				pstmt.close();			
			ConnectionManager.returnConnection(conn);
		}
	}

	
	public String addModifyService(HashMap patServ) {
		String transactionStatus = "";
		String messageId = "";
		String messageText = "";
		String functionID = "";
		String sesId = "";
		String pgmDate = "";
		boolean reCalApprRec=false;
		boolean reverseRecAppr=false;
		Connection con = null;
		con=ConnectionManager.getConnection();
		CallableStatement cstmt = null;		
		CallableStatement cstmt1 = null;	
		CallableStatement cstmt2 = null;	
		CallableStatement cstmt3 = null;	
		CallableStatement cstmt4 = null;	
		//CallableStatement cstmt5 = null; //commented V210416
		BLCoderPatService  patServ1;
		BLCoderPatService  patServ2;
		BLCoderPatService  patServ3;
		//BLCoderPatService  patServ4;//commented V210416
		BLCoderPatService  patServZ;//AAKH-SCF-0445
		int index;
        ArrayList<Integer> arrIndexList = new ArrayList<Integer>();
		String insertSql = "{ call bl_coders.add_row (?,?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?)}";
		String cancelSql = "{ call bl_coders.cancel_row  (?,?,?,?,?,?,?,?,?,?,?)}";
		String updateSql = "{ call bl_coders.update_appr_dtls(?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,?)}";
		String reverseUpdateSql = "{ call bl_coders.reverse_record_appr_dtls(?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?)}";
		String zeroPriceSql = "{ call bl_coders.zero_price_row  (?,?,?,?,?,?,?,?,?,?,?)}";
		String trxSql =  "{ call blcore.generate_sequence_common_proc (?,?,?,?,? )}";
		String recordApprDtlsSql = "{ call bl_coders.process_record_appr_dtls(?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd-mm-rrrr hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?)}";
		String reCalApprRecSql =  "{ call bl_coders.process_recalc_appr_rec(?,?,?,?,?,?,?,?,?,?,?,?)}";
		int trxLineNo = 0;
		String trxDocRefNo="";
		Object ob[] =(patServ.keySet()).toArray();
		Arrays.sort(ob);
		System.err.println("OB Length at 226 "+ob.length); 
		for (Object number : ob) {
			System.err.println("Number = " + number);
		}

		try {	
			//process Record Approval Value
			
			for(index=0;index<ob.length;index++)
			{
				System.err.println("Number ="+index+"  " + ob[index]);
				patServ1 	= (BLCoderPatService)patServ.get(""+ob[index]);
						
						if(patServ1!=null)
						{
							if(index==0){
								
									  System.err.println("Serv Indicator at 262 "+patServ1.getServTypeInd());
									  System.err.println("Operating Facility at 263 "+patServ1.getOperatingFacilityId());
									  System.err.println("getEpisodeType  at 264 "+patServ1.getEpisodeType());
								if(patServ1.getEpisodeType().equals("O")  || patServ1.getEpisodeType().equals("E")){//  && patServ1.getServTypeInd().equals("")){
										cstmt1=con.prepareCall(trxSql);
										cstmt1.setString(1, patServ1.getOperatingFacilityId());
										cstmt1.setString(2,"DIRECT_OP");
										cstmt1.setString(3, "BL-OPDE");
										cstmt1.registerOutParameter(4,java.sql.Types.VARCHAR);										
										cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);
									} else   if (patServ1.getEpisodeType().equals("R")   && patServ1.getServTypeInd().equals("")){
										cstmt1=con.prepareCall(trxSql);
										cstmt1.setString(1, patServ1.getOperatingFacilityId());
										cstmt1.setString(2,"DIRECT_RF");
										cstmt1.setString(3, "BL-RFDE");
										cstmt1.registerOutParameter(4,java.sql.Types.VARCHAR);										
										cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);										
									} else if  (patServ1.getEpisodeType().equals("I") || patServ1.getEpisodeType().equals("D")){
										cstmt1=con.prepareCall(trxSql);
										cstmt1.setString(1, patServ1.getOperatingFacilityId());
										cstmt1.setString(2,"DIRECT_IP");
										cstmt1.setString(3, "BL-IPDE");
										cstmt1.registerOutParameter(4,java.sql.Types.VARCHAR);										
										cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);														
									}
								      cstmt1.execute();
								      trxDocRefNo =cstmt1.getString(4);
									  System.err.println("trxDocRefNo at 259 "+trxDocRefNo);
								      if (!checkForNull(cstmt1.getString(5)).equals("")){
								    	  return cstmt1.getString(5);
								}
							}
							System.err.println("patServ1.getAddRowYN() at 264 "+patServ1.getAddRowYN());
							System.err.println("patServ1.getCancelRowYN() at 265 "+patServ1.getCancelRowYN());
							System.err.println("logInID "+patServ1.getlogInID());
							System.err.println("logInWSNo "+patServ1.getlogInWSNo());
								if (patServ1.getAddRowYN().equals("Y")) {	
									int proRecAppVal=Integer.parseInt((String) ob[index]);								
									cstmt=con.prepareCall(insertSql);
									System.err.println("Faci Id  "+patServ1.getOperatingFacilityId());
									System.err.println("Session Id  "+patServ1.getSessionId());
									System.err.println("Lang Id  en");
									System.err.println("Encounter Id  "+patServ1.getEncounterId());
									System.err.println("Doc Ref Id  "+trxDocRefNo);
									System.err.println("trxLineNo+1  "+trxLineNo+1);
									System.err.println("ServType Ind  "+patServ1.getServTypeInd());
									System.err.println("Serv Date Id  "+patServ1.getServiceDate());
									System.err.println("ServItem Code  "+patServ1.getServItemCode());
									System.err.println("Serv Quantity  "+Double.parseDouble(patServ1.getServQty()));
									System.err.println("Serv Amount  "+Double.parseDouble(patServ1.getServiceAmount()));
									System.err.println("Ordering Physician Id  "+patServ1.getPhysicianId());
									System.err.println("Perform PhysicianId  "+patServ1.getPerformPhysicianId());
									System.err.println("logInID "+patServ1.getlogInID());
									System.err.println("logInWSNo  "+patServ1.getlogInWSNo());
									System.err.println("CDRApprovalNo "+patServ1.getCDRApprovalNo());
									System.err.println("CDRApprovalDate "+patServ1.getCDRApprovalDate());
									cstmt.setString(1,patServ1.getOperatingFacilityId());
									cstmt.setString(2,patServ1.getSessionId());
									cstmt.setString(3,"en");
									cstmt.setString(4,patServ1.getEncounterId());
									cstmt.setString(5,trxDocRefNo);
									cstmt.setInt(6,trxLineNo+1);
									patServ1.setTrxDocRef(trxDocRefNo);
									patServ1.setTrxDocRefLineNum(Integer.toString(trxLineNo+1));									
									cstmt.setString(7,patServ1.getServTypeInd());
									cstmt.setString(8,patServ1.getServiceDate());
									cstmt.setString(9,patServ1.getServItemCode());
									cstmt.setDouble(10,Double.parseDouble(patServ1.getServQty()));
									cstmt.setDouble(11,Double.parseDouble(patServ1.getServiceAmount()));
									cstmt.setString(12,patServ1.getcptCode());
									cstmt.setString(13,patServ1.getPhysicianId());
									cstmt.setString(14,patServ1.getPerformPhysicianId());
									cstmt.setString(15,patServ1.getlogInID());
									cstmt.setString(16,patServ1.getlogInWSNo());
									cstmt.setString(17,patServ1.getCDRApprovalNo());
									cstmt.setString(18,patServ1.getCDRApprovalDate());
									if(patServ1.getServTypeInd().equals("I")){
										cstmt.setString(19,patServ1.getcptCode());
										System.err.println("Drug Item code "+patServ1.getcptCode());
									}else if(patServ1.getServTypeInd().equals("S")){
										cstmt.setString(19,"");
										System.err.println("Service Item Code ");
									}
									cstmt.setString(20,patServ1.getZeroPriceYN());
									cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
									cstmt.execute();
									transactionStatus=cstmt.getString(21);
									messageText=cstmt.getString(22);
									messageId=cstmt.getString(23);
									System.err.println("After Add Procedure Execution transactionStatus  "+transactionStatus);
									System.err.println("After Add Procedure Execution messageId  "+messageId);
									System.err.println("After Add Procedure Execution messageText  "+messageText);
									if(transactionStatus==null) transactionStatus="";
									if(messageId==null) messageId="";
									if(messageText==null) messageText="";
									if(transactionStatus.equals("S") && !patServ1.getCDRApprovalNo().equals("") && !patServ1.getCDRApprovalDate().equals("")){
										arrIndexList.add(proRecAppVal);
									}
									if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
										return messageText;
									}
									trxLineNo++;// Incrementing Doc Ref Line Num
								} else if (patServ1.getCancelRowYN().equals("Y")){
									System.err.println("Faci Id  "+patServ1.getOperatingFacilityId());
									System.err.println("Session Id  "+patServ1.getSessionId());
									System.err.println("Doc Ref Id  "+patServ1.getTrxDocRef());
									System.err.println("Ref Num Id  "+patServ1.getTrxDocRefLineNum());
									System.err.println("Seq No Id  "+patServ1.getTrxDocRefSeqNum());
									System.err.println("User Id  "+patServ1.getlogInID());
									System.err.println("WS No  "+patServ1.getlogInWSNo());
									cstmt=con.prepareCall(cancelSql);
									cstmt.setString(1,patServ1.getOperatingFacilityId());
									cstmt.setString(2,patServ1.getSessionId());
									cstmt.setString(3,patServ1.getTrxDocRef());
									cstmt.setInt(4,Integer.parseInt(patServ1.getTrxDocRefLineNum()));
									cstmt.setInt(5,Integer.parseInt(patServ1.getTrxDocRefSeqNum()));
									cstmt.setString(6,patServ1.getlogInID());
									cstmt.setString(7,patServ1.getlogInWSNo());
									cstmt.setString(8,patServ1.getcptCode());
									cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
									System.err.println("Before Cancel Procedure Execution  ");
									cstmt.execute();
									System.err.println("After Cancel Procedure Execution  ");
									transactionStatus=cstmt.getString(9);
									messageText=cstmt.getString(10);
									messageId=cstmt.getString(11);
									System.err.println("After Cancel Procedure Execution transactionStatus  "+transactionStatus);
									System.err.println("After Cancel Procedure Execution messageId  "+messageId);
									System.err.println("After Cancel Procedure Execution messageText  "+messageText);
									if(transactionStatus==null) transactionStatus="";
									if(messageId==null) messageId="";
									if(messageText==null) messageText="";
									if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
										return messageText;
									}
								}								
						}
			}
					
			for(index=0;index<ob.length;index++)
			{
				patServ1 	= (BLCoderPatService)patServ.get(""+ob[index]);		
				if(patServ1!=null)
				{
					System.err.println("Before patServ1.getModifyYN Execution  "+patServ1.getModifyYN());
					if(patServ1.getModifyYN().equals("Y")){
						cstmt=con.prepareCall(updateSql);
						cstmt.setString(1,patServ1.getOperatingFacilityId());
						cstmt.setString(2,patServ1.getSessionId());
						cstmt.setString(3,patServ1.getTrxDocRef());
						cstmt.setString(4,patServ1.getTrxDocRefLineNum());
						cstmt.setString(5,patServ1.getTrxDocRefSeqNum());
						cstmt.setString(6,patServ1.getCDRApprovalNo());
						cstmt.setString(7,patServ1.getCDRApprovalDate());
						cstmt.setString(8,patServ1.getBillableYN());
						cstmt.setString(9,patServ1.getPerformPhysicianId());
						cstmt.setString(10,"en");
						cstmt.setString(11,patServ1.getlogInID());
						cstmt.setString(12,patServ1.getlogInWSNo());
						cstmt.setString(13,patServ1.getEncounterId());						
						cstmt.setString(14,patServ1.getServTypeInd());
						cstmt.setString(15,patServ1.getServiceDate());
						cstmt.setString(16,patServ1.getServItemCode());
						cstmt.setDouble(17,Double.parseDouble(patServ1.getServQty()));
						cstmt.setDouble(18,Double.parseDouble(patServ1.getServiceAmount()));
						cstmt.setString(19,patServ1.getcptCode());
						cstmt.setString(20,patServ1.getPhysicianId());					
						cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
						cstmt.execute();
						transactionStatus=cstmt.getString(21);
						messageText=cstmt.getString(22);
						messageId=cstmt.getString(23);
							System.err.println("After Update Procedure Execution transactionStatus  "+transactionStatus);
							System.err.println("After Update Procedure Execution messageId  "+messageId);
							System.err.println("After Update Procedure Execution messageText  "+messageText);
						if(transactionStatus==null) transactionStatus="";
						if(messageId==null) messageId="";
						if(messageText==null) messageText="";
						if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
							return messageText;
						}	
					}
					System.err.println("Before patServ1.getCdrApprovalNoModifyYN Execution  "+patServ1.getCdrApprovalNoModifyYN());
					if (patServ1.getCdrApprovalNoModifyYN().equals("Y")){
						cstmt=con.prepareCall(updateSql);
						System.err.println("updateSql "+updateSql);
						System.err.println("patServ1.getOperatingFacilityId "+patServ1.getOperatingFacilityId());
						System.err.println("patServ1.getSessionId() "+patServ1.getSessionId());
						System.err.println("patServ1.getTrxDocRef() "+patServ1.getTrxDocRef());
						System.err.println("patServ1.getTrxDocRefLineNum() "+patServ1.getTrxDocRefLineNum());
						System.err.println("patServ1.getTrxDocRefSeqNum() "+patServ1.getTrxDocRefSeqNum());
						System.err.println("patServ1.getCDRApprovalNo() "+patServ1.getCDRApprovalNo());
						System.err.println("patServ1.getCDRApprovalDate()  "+patServ1.getCDRApprovalDate());
						System.err.println("patServ1.getBillableYN() "+patServ1.getBillableYN());
						System.err.println("patServ1.getPerformPhysicianId() "+patServ1.getPerformPhysicianId());
						System.err.println("patServ1.getlogInID()  "+patServ1.getlogInID());
						System.err.println("patServ1.getlogInWSNo()  "+patServ1.getlogInWSNo());
						System.err.println("patServ1.getEncounterId()  "+patServ1.getEncounterId());
						System.err.println("patServ1.getServTypeInd() "+patServ1.getServTypeInd());
						System.err.println("patServ1.getServiceDate()  "+patServ1.getServiceDate());
						System.err.println("patServ1.getServItemCode()  "+patServ1.getServItemCode());
						System.err.println("patServ1.getServQty() "+Double.parseDouble(patServ1.getServQty()));
						System.err.println("patServ1.getServiceAmount() "+Double.parseDouble(patServ1.getServiceAmount()));
						System.err.println("patServ1.getcptCode()  "+patServ1.getcptCode());
						System.err.println("patServ1.getPhysicianId()  "+patServ1.getPhysicianId());
						cstmt.setString(1,patServ1.getOperatingFacilityId());
						cstmt.setString(2,patServ1.getSessionId());
						cstmt.setString(3,patServ1.getTrxDocRef());
						cstmt.setString(4,patServ1.getTrxDocRefLineNum());
						cstmt.setString(5,patServ1.getTrxDocRefSeqNum());
						cstmt.setString(6,patServ1.getCDRApprovalNo());
						cstmt.setString(7,patServ1.getCDRApprovalDate());
						cstmt.setString(8,patServ1.getBillableYN());
						cstmt.setString(9,patServ1.getPerformPhysicianId());
						cstmt.setString(10,"en");
						cstmt.setString(11,patServ1.getlogInID());
						cstmt.setString(12,patServ1.getlogInWSNo());
						cstmt.setString(13,patServ1.getEncounterId());						
						cstmt.setString(14,patServ1.getServTypeInd());
						cstmt.setString(15,patServ1.getServiceDate());
						cstmt.setString(16,patServ1.getServItemCode());
						cstmt.setDouble(17,Double.parseDouble(patServ1.getServQty()));
						cstmt.setDouble(18,Double.parseDouble(patServ1.getServiceAmount()));
						cstmt.setString(19,patServ1.getcptCode());
						cstmt.setString(20,patServ1.getPhysicianId());					
						cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
						System.err.println("Before Update procedure execution  ");
						cstmt.execute();
						System.err.println("After  Update procedure execution  ");
						transactionStatus=cstmt.getString(21);
						messageText=cstmt.getString(22);
						messageId=cstmt.getString(23);
							System.err.println("After Update Procedure Execution transactionStatus  "+transactionStatus);
							System.err.println("After Update Procedure Execution messageId  "+messageId);
							System.err.println("After Update Procedure Execution messageText  "+messageText);
						if(transactionStatus==null) transactionStatus="";
						if(messageId==null) messageId="";
						if(messageText==null) messageText="";
						if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
							return messageText;
						}	
						//Reverse Record Approver
							System.err.println("patServ1.getCDRApprovalNo()  "+patServ1.getCDRApprovalNo());
							System.err.println("patServ1.getTrxDocRef()  "+patServ1.getTrxDocRef());
							System.err.println("patServ1.getTrxDocRefLineNum()  "+patServ1.getTrxDocRefLineNum());
							System.err.println("patServ1.getTrxDocRefSeqNum()  "+patServ1.getTrxDocRefSeqNum());
							System.err.println("patServ1.getCDRApprovalDate()  "+patServ1.getCDRApprovalDate());
						if(!patServ1.getCDRApprovalNo().equals("")){
							cstmt4=con.prepareCall(reverseUpdateSql);
							cstmt4.setString(1,patServ1.getOperatingFacilityId());
							cstmt4.setString(2,patServ1.getSessionId());
							cstmt4.setString(3,patServ1.getTrxDocRef());
							cstmt4.setString(4,patServ1.getTrxDocRefLineNum());
							cstmt4.setString(5,patServ1.getTrxDocRefSeqNum());
							cstmt4.setString(6,patServ1.getCDRApprovalNo());
							cstmt4.setString(7,patServ1.getCDRApprovalDate());
							cstmt4.setString(8,patServ1.getBillableYN());
							cstmt4.setString(9,patServ1.getPerformPhysicianId());
							cstmt4.setString(10,"en");
							cstmt4.setString(11,patServ1.getlogInID());
							cstmt4.setString(12,patServ1.getlogInWSNo());
							cstmt4.setString(13,patServ1.getEncounterId());						
							cstmt4.setString(14,patServ1.getServTypeInd());
							cstmt4.setString(15,patServ1.getServiceDate());
							cstmt4.setString(16,patServ1.getServItemCode());
							cstmt4.setDouble(17,Double.parseDouble(patServ1.getServQty()));
							cstmt4.setDouble(18,Double.parseDouble(patServ1.getServiceAmount()));
							cstmt4.setString(19,patServ1.getcptCode());
							cstmt4.setString(20,patServ1.getPhysicianId());					
							cstmt4.registerOutParameter(21,java.sql.Types.VARCHAR);
							cstmt4.registerOutParameter(22,java.sql.Types.VARCHAR);
							cstmt4.registerOutParameter(23,java.sql.Types.VARCHAR);			
							cstmt4.registerOutParameter(24,java.sql.Types.VARCHAR);
							cstmt4.registerOutParameter(25,java.sql.Types.VARCHAR);
							cstmt4.registerOutParameter(26,java.sql.Types.VARCHAR);
							cstmt4.execute();
							transactionStatus=cstmt4.getString(21);
							messageText=cstmt4.getString(22);
							messageId=cstmt4.getString(23);
							functionID=cstmt4.getString(24);
							sesId=cstmt4.getString(25);
							pgmDate=cstmt4.getString(26);
								System.err.println("After Reverse Record Procedure Execution transactionStatus  "+transactionStatus);
								System.err.println("After Reverse Record Procedure Execution messageId  "+messageId);
								System.err.println("After Reverse Record Procedure Execution messageText  "+messageText);
								System.err.println("After Reverse Record Approval Procedure Execution functionID  "+functionID);
								System.err.println("After Reverse Record Approval Procedure Execution sesId  "+sesId);
								System.err.println("After Reverse Record Approval Procedure Execution pgmDate  "+pgmDate);
							if(transactionStatus==null) transactionStatus="";
							if(messageId==null) messageId="";
							if(messageText==null) messageText="";
							if(transactionStatus.equals("S")){
								reverseRecAppr=true;
							}
							if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
								return messageText;
							}	
						}
					}	
				}
			}
			/*//Recalculation for updated Approval Number	
			if(reverseRecAppr){
				patServ4 	= (BLCoderPatService)patServ.get(""+ob[0]);		
					if(patServ4!=null)
					{
						cstmt5=con.prepareCall(reCalApprRecSql);
						cstmt5.setString(1,patServ4.getOperatingFacilityId());
						cstmt5.setString(2,patServ4.getSessionId());
						cstmt5.setString(3,"en");
						cstmt5.setString(4,patServ4.getlogInID());
						cstmt5.setString(5,patServ4.getlogInWSNo());
						cstmt5.setString(6,patServ4.getEncounterId());
						cstmt5.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt5.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt5.registerOutParameter(9,java.sql.Types.VARCHAR);	
						cstmt5.setString(10,functionID);
						cstmt5.setString(11,sesId);
						cstmt5.setString(12,pgmDate);
						cstmt5.execute();
						transactionStatus=cstmt5.getString(7);
						messageText=cstmt5.getString(8);
						messageId=cstmt5.getString(9);
						System.err.println("After Reverse Record ReCalculation Procedure Execution transactionStatus  "+transactionStatus);
						System.err.println("After Reverse Record ReCalculation Procedure Execution messageId  "+messageId);
						System.err.println("After Reverse Record ReCalculation Procedure Execution messageText  "+messageText);
						if(transactionStatus==null) transactionStatus="";
							if(messageId==null) messageId="";
							if(messageText==null) messageText="";
							if (transactionStatus.equals("E")){
								return "~"+messageId+"~"+messageText;
							}	
					}
			}*/
			//Calling Procedure for Update Approval Number and Date
			System.err.println("arrIndexList Size  "+arrIndexList.size());
			if(arrIndexList.size()!=0){
				for(index=0;index<arrIndexList.size();index++)
				{
					System.err.println("arrIndexList Values at "+index+"  "+arrIndexList.get(index));
					patServ2 	= (BLCoderPatService)patServ.get(""+arrIndexList.get(index));		
					if(patServ2!=null)
					{	
						System.err.println("patServ2.getAddRowYN() at 448 "+patServ2.getAddRowYN());
						System.err.println("patServ2.getCDRApprovalNo() at 448 "+patServ2.getCDRApprovalNo());
						System.err.println("patServ2.getCDRApprovalDate() at 448 "+patServ2.getCDRApprovalDate());
						if (patServ2.getAddRowYN().equals("Y") && !patServ2.getCDRApprovalNo().equals("") && !patServ2.getCDRApprovalDate().equals("")){
							cstmt2=con.prepareCall(recordApprDtlsSql);
							System.err.println("getTrxDocRef "+patServ2.getTrxDocRef());
							System.err.println("getTrxDocRefLineNum "+patServ2.getTrxDocRefLineNum());
							cstmt2.setString(1,patServ2.getOperatingFacilityId());
							cstmt2.setString(2,patServ2.getSessionId());
							cstmt2.setString(3,patServ2.getTrxDocRef());
							cstmt2.setString(4,patServ2.getTrxDocRefLineNum());
							cstmt2.setString(5,patServ2.getTrxDocRefSeqNum());
							cstmt2.setString(6,patServ2.getCDRApprovalNo());
							cstmt2.setString(7,patServ2.getCDRApprovalDate());
							cstmt2.setString(8,patServ2.getBillableYN());
							cstmt2.setString(9,patServ2.getPerformPhysicianId());
							cstmt2.setString(10,"en");
							cstmt2.setString(11,patServ2.getlogInID());
							cstmt2.setString(12,patServ2.getlogInWSNo());
							cstmt2.setString(13,patServ2.getEncounterId());						
							cstmt2.setString(14,patServ2.getServTypeInd());
							cstmt2.setString(15,patServ2.getServiceDate());
							cstmt2.setString(16,patServ2.getServItemCode());
							cstmt2.setDouble(17,Double.parseDouble(patServ2.getServQty()));
							cstmt2.setDouble(18,Double.parseDouble(patServ2.getServiceAmount()));
							cstmt2.setString(19,patServ2.getcptCode());
							cstmt2.setString(20,patServ2.getPhysicianId());					
							cstmt2.registerOutParameter(21,java.sql.Types.VARCHAR);
							cstmt2.registerOutParameter(22,java.sql.Types.VARCHAR);
							cstmt2.registerOutParameter(23,java.sql.Types.VARCHAR);			
							cstmt2.registerOutParameter(24,java.sql.Types.VARCHAR);
							cstmt2.registerOutParameter(25,java.sql.Types.VARCHAR);
							cstmt2.registerOutParameter(26,java.sql.Types.VARCHAR);
							cstmt2.execute();
							transactionStatus=cstmt2.getString(21);
							messageText=cstmt2.getString(22);
							messageId=cstmt2.getString(23);
							functionID=cstmt2.getString(24);
							sesId=cstmt2.getString(25);
							pgmDate=cstmt2.getString(26);
								System.err.println("After Record Approval Procedure Execution transactionStatus  "+transactionStatus);
								System.err.println("After Record Approval Procedure Execution messageId  "+messageId);
								System.err.println("After Record Approval Procedure Execution messageText  "+messageText);
								System.err.println("After Record Approval Procedure Execution functionID  "+functionID);
								System.err.println("After Record Approval Procedure Execution sesId  "+sesId);
								System.err.println("After Record Approval Procedure Execution pgmDate  "+pgmDate);
							if(transactionStatus==null) transactionStatus="";
							if(transactionStatus.equals("S"))
								reCalApprRec=true;
							System.err.println("After Record Approval Procedure Execution reCalApprRec  "+reCalApprRec);
							if(messageId==null) messageId="";
							if(messageText==null) messageText="";
							if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
								return messageText;
							}	
						}	
					}
				}	
			}
			
			//Final Recalculation Procedure Call
			if((reCalApprRec) || (reverseRecAppr)){				
					patServ3 	= (BLCoderPatService)patServ.get(""+ob[0]);		
					if(patServ3!=null)
					{
						cstmt3=con.prepareCall(reCalApprRecSql);
						cstmt3.setString(1,patServ3.getOperatingFacilityId());
						cstmt3.setString(2,patServ3.getSessionId());
						cstmt3.setString(3,"en");
						cstmt3.setString(4,patServ3.getlogInID());
						cstmt3.setString(5,patServ3.getlogInWSNo());
						cstmt3.setString(6,patServ3.getEncounterId());
						cstmt3.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt3.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt3.registerOutParameter(9,java.sql.Types.VARCHAR);	
						cstmt3.setString(10,functionID);
						cstmt3.setString(11,sesId);
						cstmt3.setString(12,pgmDate);
						cstmt3.execute();
						transactionStatus=cstmt3.getString(7);
						messageText=cstmt3.getString(8);
						messageId=cstmt3.getString(9);
						System.err.println("After ReCalculation Procedure Execution transactionStatus  "+transactionStatus);
						System.err.println("After ReCalculation Procedure Execution messageId  "+messageId);
						System.err.println("After ReCalculation Procedure Execution messageText  "+messageText);
						if(transactionStatus==null) transactionStatus="";
							if(messageId==null) messageId="";
							if(messageText==null) messageText="";
							if (transactionStatus.equals("E")){
								return "~"+messageId+"~"+messageText;
							}	
					}
				}
				//AAKH-SCF-0445
			String seqNoZeroPrice="";
			for(index=0;index<ob.length;index++)
			{
				patServZ 	= (BLCoderPatService)patServ.get(""+ob[index]);		
				if(patServZ!=null)
				{
					System.err.println("Zero Price  "+patServZ.getZeroPriceYN());
					 if (patServZ.getZeroPriceYN().equals("Y")){
						seqNoZeroPrice=patServZ.getTrxDocRefSeqNum();
						if(seqNoZeroPrice.trim().equals("") || seqNoZeroPrice==null){
							seqNoZeroPrice="0";
						}
						System.err.println("Faci Id  "+patServZ.getOperatingFacilityId());
						System.err.println("Session Id  "+patServZ.getSessionId());
						System.err.println("Doc Ref Id  "+patServZ.getTrxDocRef());
						System.err.println("Ref Num Id  "+patServZ.getTrxDocRefLineNum());
						System.err.println("Seq No Id  "+seqNoZeroPrice);
						System.err.println("User Id  "+patServZ.getlogInID());
						System.err.println("WS No  "+patServZ.getlogInWSNo());
						System.err.println("Add Row Flag  "+patServZ.getAddRowYN());
						cstmt=con.prepareCall(zeroPriceSql);
						cstmt.setString(1,patServZ.getOperatingFacilityId());
						cstmt.setString(2,patServZ.getSessionId());
						cstmt.setString(3,patServZ.getTrxDocRef());
						cstmt.setInt(4,Integer.parseInt(patServZ.getTrxDocRefLineNum()));
						cstmt.setInt(5,Integer.parseInt(seqNoZeroPrice));
						cstmt.setString(6,patServZ.getlogInID());
						cstmt.setString(7,patServZ.getlogInWSNo());
						cstmt.setString(8,patServZ.getAddRowYN());
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
						System.err.println("Before Zero Price Procedure Execution  ");
						cstmt.execute();
						System.err.println("After Zero Price Procedure Execution  ");
						transactionStatus=cstmt.getString(9);
						messageText=cstmt.getString(10);
						messageId=cstmt.getString(11);
						System.err.println("After Zero Price Procedure Execution transactionStatus  "+transactionStatus);
						System.err.println("After Zero Price Procedure Execution messageId  "+messageId);
						System.err.println("After Zero Price Procedure Execution messageText  "+messageText);
						if(transactionStatus==null) transactionStatus="";
						if(messageId==null) messageId="";
						if(messageText==null) messageText="";
						if (transactionStatus.equals("E") || !messageId.equals("") || !messageText.equals("")){
							return messageText;
						}
					}
				}
			}
			//AAKH-SCF-0445
			
			return "";
		}catch (Exception e){			
			e.printStackTrace();
			return "";
		}finally {
			try {				
				if(cstmt!=null) cstmt.close();
				if(cstmt1!=null) cstmt1.close();
				if(cstmt3!=null) cstmt3.close(); //Added for V210416
				if(cstmt4!=null) cstmt4.close(); //Added for V210416		
				ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
				return "";
			}
		}
	}
	
	public String generateBill() {
		String transactionStatus = "";
		String messageId = "";
		String messageText = "";
		Connection con = null;
		con=ConnectionManager.getConnection();
		CallableStatement cstmt = null;		
		BLCoderPatService  patServ1;
		int index;
		String generateBillSql = "bl_coders.generate_bill (?,?,?,?,?,?,?,?,?,?)";		
		
		Object ob[] =(hasBLCoderPatSearchValues.keySet()).toArray();
		Arrays.sort(ob);

		try {	
			for(index=0;index<ob.length;index++)
			{
				patServ1 	= (BLCoderPatService)hasBLCoderPatSearchValues.get(""+ob[index]);	
						if(patServ1!=null)
						{	if(index==0){
							}									
									cstmt=con.prepareCall(generateBillSql);
									cstmt.setString(1,patServ1.getOperatingFacilityId());
									cstmt.setString(2,patServ1.getSessionId());
									cstmt.setString(3,patServ1.getEncounterId());
									cstmt.setString(4,patServ1.getlogInID());
									cstmt.setString(5,patServ1.getlogInWSNo());
									cstmt.setString(6,"en");
									cstmt.setString(7,"");
									cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
									cstmt.execute();
									transactionStatus=cstmt.getString(8);
									messageId=cstmt.getString(9);
									messageText=cstmt.getString(10);
									System.err.println("After Gen Bill Procedure Execution transactionStatus  "+transactionStatus);
									System.err.println("After Gen Bill Procedure Execution messageId  "+messageId);
									System.err.println("After Gen Bill Procedure Execution messageText  "+messageText);
									if(transactionStatus==null) transactionStatus="";
									if(messageId==null) messageId="";
									if(messageText==null) messageText="";
									if (transactionStatus.equals("E")){
										return "~"+messageId+"~"+messageText;
									}
						}
			}
			return "";
		}catch (Exception e){
			e.printStackTrace();
			return "";
		}finally {
			try {
				if (cstmt!=null) cstmt.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception ee) {
				ee.printStackTrace();
				return "";
			}
		}
	}
	

	public String getSysDate() throws Exception
	{
		Connection connection 		= ConnectionManager.getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String sysDate = "";
		try
		{
			String sql = "select to_char(sysdate,'dd/mm/yyyy') syDate from dual";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				sysDate = rs.getString("syDate");
		}
		catch(Exception e)
		{
			System.err.println("Exception from getSysDate :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();			
			ConnectionManager.returnConnection(connection);
		}
		return sysDate;
	}
		
	public String getNoOfDecimal() throws Exception
	{
		Connection connection 		= ConnectionManager.getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String noofdecimal = "";
		try
		{
			String sql = "select nvl(no_of_decimal,2) noofdecimal from  sm_acc_entity_param";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				noofdecimal = rs.getString("noofdecimal");
		}
		catch(Exception e)
		{
			System.err.println("Exception from getNoOfDecimal :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}
//			System.err.println("noofdecimal:"+noofdecimal);
		return noofdecimal ;
	}		
}