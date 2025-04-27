/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
--------------------------------------------------------------------------------------------------
1            V210129            13523			MOHE-CRF-0060       		Shikha Seth
2            V210413			17021			Common-ICN-0009-TF			MuthukumarN
--------------------------------------------------------------------------------------------------
 */
package eBL.MultiBillSettlement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import oracle.sql.ARRAY;
import webbeans.eCommon.ConnectionManager;


/**
*
* @ejb.bean
*	name="MultiBillSettlement"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MultiBillSettlement"
*	local-jndi-name="MultiBillSettlement"
*	impl-class-name="eBL.MultiBillSettlement.MultiBillSettlementManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.MultiBillSettlement.MultiBillSettlementLocal"
*	remote-class="eBL.MultiBillSettlement.MultiBillSettlementRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.MultiBillSettlement.MultiBillSettlementLocalHome"
*	remote-class="eBL.MultiBillSettlement.MultiBillSettlementHome"
*	generate= "local,remote"
*
*
*/


public class MultiBillSettlementManager implements SessionBean {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private SessionContext context;

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext ctx) {
		context = ctx;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap<String,String> insertRecords(java.util.Properties p,HashMap<String,String> inputParameters,HashMap<String,ARRAY> arrayInputParameters) {
		
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		Connection con = ConnectionManager.getConnection(p);	
		
		try{
		String facility_id = inputParameters.get("facility_id");
		String language_id = inputParameters.get("language_id");
		String cust_code = inputParameters.get("cust_code");
		String episode_type = inputParameters.get("episode_type");
		String slmt_amt =inputParameters.get("slmt_amt");
		String outst_amt=inputParameters.get("outst_amt");
		String user_id =inputParameters.get("user_id");
		String ws_no = inputParameters.get("ws_no");
		String cash_amt_given =inputParameters.get("cash_amt_given");
		String cash_amt_returned = inputParameters.get("cash_amt_returned");
		String ecnounterFacilityId = inputParameters.get("ecnounterFacilityId"); //V210129 
		String downType = inputParameters.get("downType");
	    String downDoc = inputParameters.get("downDoc");
	    String downDate = inputParameters.get("downDate");
	    String downReason = inputParameters.get("downReason");
	    String downEntryYn = inputParameters.get("downEntryYn");
	    String blRecRefInd = inputParameters.get("blRecRefInd");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    if("Y".equals(downEntryYn)){
	    	Timestamp ts = new Timestamp(sdf.parse(downDate).getTime());
	    	System.err.println(ts);
	    }
		
		System.out.println("array assignment begins" );
		ARRAY bill_doc_numbers_parameter_array=arrayInputParameters.get("bill_doc_numbers_parameter_array");
		ARRAY slmt_mode_parameter_array=arrayInputParameters.get("slmt_mode_parameter_array");
		ARRAY slmt_by_svc_parameter_array=arrayInputParameters.get("slmt_by_svc_parameter_array");
		ARRAY deposit_parameter_array=arrayInputParameters.get("deposit_parameter_array");
		
		con.setAutoCommit(false);
		System.out.println("call proc bl_bill_settlement_proc.populate_slmt_cons_rcpt() begins" );
		CallableStatement cst = con.prepareCall("call bl_bill_settlement_proc.populate_slmt_cons_rcpt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //V210129 
		
		//cst.setString(1, facility_id); // facility_id //V210129 Commented
		cst.setString(1, ecnounterFacilityId); // facility_id //V210129 Added
		cst.setString(2, language_id); // language_id
		cst.setString(3, cust_code); // cust_code
		cst.setString(4, episode_type); // episode_type
		cst.setDouble(5, Double.parseDouble(slmt_amt)); // slmt_amt
		cst.setDouble(6, Double.parseDouble(outst_amt)); //p_bill_oustanding_amt
		cst.setArray(7, bill_doc_numbers_parameter_array); // b_cnt // bill_dtls
		cst.setArray(8, slmt_mode_parameter_array); // slmt_cnt slmt_dtls
		cst.setArray(9, slmt_by_svc_parameter_array); // sett_serv	// sett_dtls
		cst.setArray(10, deposit_parameter_array); // dedtl dep_dtls
		cst.setString(11, user_id); // user_id
		cst.setString(12, ws_no); // ws_no
		cst.setDouble(13, Double.parseDouble(cash_amt_given)); // cash_amt_given
		cst.setDouble(14, Double.parseDouble(cash_amt_returned)); // cash_amt_returned
		/*below params for downtime entry*/
		cst.setString(15, downEntryYn);
		cst.setString(16, downDoc);
		cst.setString(17, downType);
		if("Y".equals(downEntryYn)){
			cst.setTimestamp(18, new Timestamp(sdf.parse(downDate).getTime()));
		}
		else{
			cst.setString(18, null);
		}
		
		cst.setString(19, downReason);
		cst.setString(20, blRecRefInd);
		/*below params for downtime entry*/
		cst.registerOutParameter(21, Types.VARCHAR); // slmt_doc_type_code
		cst.registerOutParameter(22, Types.INTEGER); // slmt_doc_num
		cst.registerOutParameter(23, Types.VARCHAR); //multiple_slmt_doc_numbers
		cst.registerOutParameter(24, Types.VARCHAR); // print yn
		cst.registerOutParameter(25, Types.VARCHAR); // session id
		cst.registerOutParameter(26, Types.VARCHAR); // report id
		cst.registerOutParameter(27, Types.VARCHAR); // pgm date
		cst.registerOutParameter(28, Types.INTEGER); // error_level
		cst.registerOutParameter(29, Types.VARCHAR); // error_id
		cst.registerOutParameter(30, Types.VARCHAR); // error_text
		cst.registerOutParameter(31, Types.VARCHAR); // warning_id
		cst.setString(32,facility_id); //facility_id //V210129 
		System.out.println("before execution" );
		cst.execute();		
		System.out.println("after execution" );
		String error_level = cst.getString(28);
		String error_id = cst.getString(29);
		String error_text = cst.getString(30);
		String warningId = cst.getString(31);
		if(warningId == null){
			warningId = "";
		}
		
		String slmt_doc_type_code_op=cst.getString(21);
		String slmt_doc_num_op=cst.getString(22);
		String multiple_slmt_doc_numbers=cst.getString(23);
		String printYN = cst.getString(24);
		String sessionId = cst.getString(25);
		String reportId = cst.getString(26);
		String pgmDate = cst.getString(27);
		
		
		System.out.println("PROCEDURE bl_bill_settlement_proc.populate_slmt_cons_rcpt EXECUTED SUCCESSFULLY");
		System.out.println("error_level:" + error_level + "|error_id:" + error_id + "|error_text: "+error_text);
		System.out.println("printYN-"+printYN+"-sessionId"+sessionId+"-reportId"+reportId+"-pgmDate"+pgmDate);
		
		if (error_level != null || error_id != null || error_text != null) {
			con.rollback();
			returnMessage.put("status", "fail");
			returnMessage.put("error_level",error_level);
			returnMessage.put("error_id",error_id);
			returnMessage.put("error_text",error_text);
			returnMessage.put("warningId", warningId);
		}else{			
			con.commit();
			returnMessage.put("slmt_doc_type_code_op",slmt_doc_type_code_op);
			returnMessage.put("slmt_doc_num_op",slmt_doc_num_op);
			returnMessage.put("multiple_slmt_doc_numbers",multiple_slmt_doc_numbers);
			returnMessage.put("printYN", printYN);
			returnMessage.put("sessionId", sessionId);
			returnMessage.put("pgmDate", pgmDate);
			returnMessage.put("reportId", reportId);
			returnMessage.put("status", "success");
			returnMessage.put("warningId", warningId);
		}		

		}catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception rb){
				
			}
			
			System.out.println("Exception in procedure bl_bill_settlement_proc.populate_slmt_cons_rcpt " + e.getMessage()); 
			returnMessage.put("status", "fail");
			returnMessage.put("error_level","");
			returnMessage.put("error_id","");
			returnMessage.put("error_text","Fatal Exception Occured");
		}finally{
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error in EJB insertRecords()"+ e);
				}
		}
		}

		
		

		return returnMessage;
	}
}