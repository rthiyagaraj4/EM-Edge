/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

11/3/2021              TFS:15756               Shazana                           								check Style Audit report 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eSS.LoanIssueGroup;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
*
* @ejb.bean  
*	name="LoanIssueGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="LoanIssueGroup"
*	local-jndi-name="LoanIssueGroup"
*	impl-class-name="eSS.LoanIssueGroup.LoanIssueGroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.LoanIssueGroup.LoanIssueGroupLocal"
*	remote-class="eSS.LoanIssueGroup.LoanIssueGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.LoanIssueGroup.LoanIssueGroupLocalHome"
*	remote-class="eSS.LoanIssueGroup.LoanIssueGroupHome"
*	generate= "local,remote"
*
*
*/

public class  LoanIssueGroupManager extends SsEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL )  {
		HashMap		hmReturn	=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		return hmReturn;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL)  {
		Connection	connection					=	null;
		HashMap		hmReturn					=	new HashMap();
		HashMap		hmResult					=	new HashMap();
		HashMap		hmArgData					=	new HashMap();
		HashMap		hmArgSQL					=	new HashMap();
		ArrayList	alHdrData					=	new ArrayList();
		ArrayList	alDtlData					=	new ArrayList();
		ArrayList	alDtlRecords				=	new ArrayList();
		ArrayList	alPendingQty				=	null;
		ArrayList   alParameters				=	null;
		 
		Properties	properties					=	null;
		String		stSQL						=	null;
		PreparedStatement preparedStatement		=	null;
		//PreparedStatement preparedStatement1	=	null; // Comented by Sakti as this is unused against inc#48061
		//ResultSet resultSet						=	null;
		int iResult								=	0;
		boolean isUpdateSuccessful				=	true;
		//int result_count						=	0;
		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			stSQL				=	(String)	hmSQL.get ("HdrInsertSQL");

			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,stSQL);			
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlQtyLeftSQL");			

			String stNotIssuedTraySQL	=	(String)		hmSQL.get ("DtlTrayNotIssuedSQL");
			String req_group_code		=	"";

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);

				alParameters	=	new ArrayList(4);
				
				alParameters.add(alHdrData.get(0));
				alParameters.add(alHdrData.get(7));
				alParameters.add(alHdrData.get(8));
				alParameters.add( hmRecord.get("req_group_code"));
				
				req_group_code=(String)hmRecord.get("req_group_code");
				
				if(fetchRecord(connection, stSQL, alParameters).get("LEFT").toString().equals("0")){
					throw new Exception("REQUEST_FULFILLED");
				}
				
				alParameters.clear();
				
				alParameters.add(hmRecord.get("issue_group_code"));
				alParameters.add(hmRecord.get("tray_no"));
				alParameters.add(alHdrData.get(4));

				if(fetchRecord(connection, stNotIssuedTraySQL, alParameters).get("TOTAL").toString().equals("0")){
					throw new Exception("TRAY_ALREADY_ISSUED");
				}
				
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(hmRecord.get("req_group_code"));
				alDtlRecord.add(hmRecord.get("issue_group_code"));
				alDtlRecord.add(hmRecord.get("auth_group_code"));
				alDtlRecord.add(hmRecord.get("tray_no"));
				alDtlRecord.add(hmRecord.get("patient_id"));
				alDtlRecord.add(hmRecord.get("expiry_date"));
				alDtlRecord.add(hmRecord.get("issue_cost"));
				alDtlRecord.add(hmRecord.get("sterile_cost"));
				alDtlRecord.add(hmRecord.get("packing_cost"));
				alDtlRecord.add(hmRecord.get("consumables_cost"));
				alDtlRecord.add(hmRecord.get("non_consumables_cost"));
				alDtlRecord.add(alHdrData.get(9));
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(9));
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(11));
				
				alDtlRecords.add(alDtlRecord);
				
			}
			stSQL	=	(String)	hmSQL.get ("DtlInsertSQL");
			int count=0;
			hmArgData.put(DATA,alDtlRecords);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);			

			//Request Detail blocked qty update starts
			boolean Acknowledge_flag = fetchRecord(connection,"SELECT ISL_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", (String)alHdrData.get(0)).get("ISL_ACK_REQ_YN").toString().equals("Y");
			stSQL  = (String)hmSQL.get ("GroupForStoreUpdForPendingAckSQL");

			if(Acknowledge_flag){
				String req_group_chk="";
				for (int i=0; i<alDtlData.size();i++ ) {
					
						//ArrayList	alDtlRecord	=	new ArrayList();
						HashMap hmRecord	=	(HashMap) alDtlData.get(i);
						String req_doc_no =(String)alHdrData.get(8); 
						boolean group_chk = true;

						if(((String)hmRecord.get("req_group_code")).equals(req_group_chk)){
							group_chk = false;
						}
						req_group_chk =  (String)hmRecord.get("req_group_code");

						if(group_chk){
							String sql = (String)hmSQL.get("DtlTrayIssuedCountSQL");
							ArrayList alblockqty	=	new ArrayList();
							alblockqty.add(alHdrData.get(8)); //req_doc_no
							alblockqty.add(alHdrData.get(7)); //req_doctype_code
							alblockqty.add((String)hmRecord.get("req_group_code")); //req_group_code
							alblockqty.add(alHdrData.get(0)); //facility_id
							alblockqty.add(alHdrData.get(1)); //doc_type_code
							alblockqty.add(alHdrData.get(2)); //iss_doc_no

							HashMap hmblockqty		=  fetchRecord(connection, sql, alblockqty); 
							String blocked_qty	= (String)hmblockqty.get("ISSUE_QTY");
							
							count=Integer.parseInt(blocked_qty);
							preparedStatement = connection.prepareStatement((String)hmSQL.get ("DtlTrayBlockedQtyUpdateSQL"));
							preparedStatement.setInt(1,count);//Blocked_qty
							preparedStatement.setString(2,(String)alHdrData.get(9));//MODIFIED_BY_ID
							preparedStatement.setString(3,(String)alHdrData.get(10));//MODIFIED_AT_WS_NO
							preparedStatement.setString(4,(String)alHdrData.get(0));//MODIFIED_FACILITY_ID
							preparedStatement.setString(5,(String)alHdrData.get(0));//MODIFIED_FACILITY_ID
							preparedStatement.setString(6,(String)alHdrData.get(7));//DOC_TYPE_CODE
							preparedStatement.setInt(7,Integer.parseInt(req_doc_no));//DOC_NO
							preparedStatement.setString(8,(String)hmRecord.get("req_group_code"));//REQ_GROUP_CODE

							iResult	 =	preparedStatement.executeUpdate();
							closeStatement(preparedStatement);//COMMON-ICN-0119
						}
					// This is for Update of Pending Ack Qty in Group for Store table
						alPendingQty		=	new ArrayList();

						alPendingQty.add(alHdrData.get(9));
						alPendingQty.add(alHdrData.get(10));
						alPendingQty.add(alHdrData.get(11));
						alPendingQty.add(alHdrData.get(5));		
						alPendingQty.add(hmRecord.get("req_group_code"));

						hmArgData.put(DATA,alPendingQty);				
						hmArgSQL.put(UPDATE_SQL,stSQL);
						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
				}
			}

			 //This will update the pending request qty in group for store table
				stSQL  = (String)hmSQL.get ("GroupForStoreUpdForPendingReqSQL");

				int pend_req_qty = 1;

			for (int i=0; i<alDtlData.size();i++ ) {				
				
					HashMap hmRecord	=	(HashMap) alDtlData.get(i);

					alPendingQty		=	new ArrayList();
					
					alPendingQty.add(""+pend_req_qty);
					alPendingQty.add(""+pend_req_qty);
					alPendingQty.add(alHdrData.get(9));
					alPendingQty.add(alHdrData.get(10));
					alPendingQty.add(alHdrData.get(11));
					alPendingQty.add(alHdrData.get(5));		
					alPendingQty.add(hmRecord.get("req_group_code"));

					hmArgData.put(DATA,alPendingQty);				
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);		
			}


			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
				stSQL				=	(String)	hmSQL.get ("NextDocNoUpdateSQL");

				ArrayList alNextDocNoUpdateData	=	new ArrayList();
				alNextDocNoUpdateData.add(alHdrData.get(9));
				alNextDocNoUpdateData.add(alHdrData.get(10));
				alNextDocNoUpdateData.add(alHdrData.get(11));
				alNextDocNoUpdateData.add(alHdrData.get(1));

				hmArgData.put(DATA,alNextDocNoUpdateData);
				
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
				hmReturn.put("flag","Doc No: "+alHdrData.get(2));
			}
			
		
		
				if (isUpdateSuccessful) {
					closeStatement(preparedStatement);//COMMON-ICN-0119
					connection.commit();
					
				}
        }
		catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeStatement(preparedStatement);//added for 15756 
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	
	public HashMap modify(HashMap hmData, HashMap hmSQL)  {
		HashMap		hmReturn					=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		/*Connection	connection					=	null;
		HashMap		hmReturn					=	new HashMap();
		HashMap		hmResult					=	new HashMap();
		HashMap		hmArgData					=	new HashMap();
		HashMap		hmArgSQL					=	new HashMap();
		ArrayList	alHdrData					=	new ArrayList();
		ArrayList	alDtlData					=	new ArrayList();
		ArrayList	alDtlRecords				=	new ArrayList();
		Properties	properties					=	null;
		String		stSQL						=	null;
		PreparedStatement preparedStatement		=	null;
		ResultSet resultSet						=	null;
		int iResult								=	0;
		boolean isUpdateSuccessful				=	true;
		int row_num								=	0;
		String req_group_chk					= "";
		ArrayList	alDtlModifyData				=	new ArrayList()	;
		ArrayList alPendingQty					= null;

		ArrayList alCommonData					=	(ArrayList)hmData.get("COMMON_DATA");

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrModifyData");
			stSQL				=	(String)	hmSQL.get ("HdrUpdateSQL");
				
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlModifyInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlQtyLeftSQL");

			String stNotIssuedTraySQL	=	(String)		hmSQL.get ("DtlTrayNotIssuedSQL");
			String req_group_code		=	"";

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				row_num++;

				ArrayList alParameters	=	new ArrayList(2);
		
				alParameters.add(hmRecord.get("issue_group_code"));
				alParameters.add(hmRecord.get("tray_no"));

				if(fetchRecord(connection, stNotIssuedTraySQL, alParameters).get("TOTAL").toString().equals("0")){
					throw new Exception("TRAY_ALREADY_ISSUED");
				}
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(alHdrData.get(5));
				alDtlRecord.add(alHdrData.get(6));
				alDtlRecord.add(hmRecord.get("req_group_code"));
				alDtlRecord.add(hmRecord.get("issue_group_code"));
				alDtlRecord.add(hmRecord.get("auth_group_code"));
				alDtlRecord.add(hmRecord.get("tray_no"));
				alDtlRecord.add(hmRecord.get("patient_id"));
				alDtlRecord.add(hmRecord.get("expiry_date"));
				alDtlRecord.add(hmRecord.get("issue_cost"));
				alDtlRecord.add(hmRecord.get("sterile_cost"));
				alDtlRecord.add(hmRecord.get("packing_cost"));
				alDtlRecord.add(hmRecord.get("consumables_cost"));
				alDtlRecord.add(hmRecord.get("non_consumables_cost"));
				alDtlRecord.add("RI");
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));

				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));
				
				alDtlRecords.add(alDtlRecord);
				
			}
			stSQL	=	(String)	hmSQL.get ("DtlInsertSQL");
			int count=0;
			hmArgData.put(DATA,alDtlRecords);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);		
			throwExceptionWhenFailed(hmResult);

//ACK_STATUS=CL UPDATE STARTS
			ArrayList alParam	=	new ArrayList();
			alParam.add(alHdrData.get(4));
			alParam.add(alHdrData.get(5));
			alParam.add(alHdrData.get(6));
			alParam.add("RJ");
			alParam.add(""+row_num);
			
			//System.out.println("alParam in manager 373"+alParam);

			
			ArrayList alList = fetchRecords(connection,"SELECT FACILITY_ID,DOC_TYPE_CODE,DOC_NO,ISSUE_GROUP_CODE,TRAY_NO FROM SS_ISSUE_DTL WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? AND ACK_STATUS= ? AND ROWNUM <= ?  ORDER BY ISSUE_GROUP_CODE,TRAY_NO ",alParam);

			for(int j=0;j<alList.size();j++){
					ArrayList	alDtlRecordModify	=	new ArrayList();
					HashMap hMap = (HashMap)alList.get(j);

					alDtlRecordModify.add("CL");

					alDtlRecordModify.add(alHdrData.get(0));
					alDtlRecordModify.add(alHdrData.get(1));
					alDtlRecordModify.add(alHdrData.get(2));
					alDtlRecordModify.add((String)hMap.get("FACILITY_ID"));
					alDtlRecordModify.add((String)hMap.get("DOC_TYPE_CODE"));
					alDtlRecordModify.add((String)hMap.get("DOC_NO"));
					alDtlRecordModify.add((String)hMap.get("TRAY_NO"));
					alDtlRecordModify.add((String)hMap.get("ISSUE_GROUP_CODE"));
					
					alDtlModifyData.add(alDtlRecordModify);

			}

				String DtlUpdateSQL	=	(String)	hmSQL.get ("DtlUpdateSQL");
				
				hmArgData.put(DATA,alDtlModifyData);
				hmArgSQL.put("BATCH_SQL",DtlUpdateSQL);
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);		
				throwExceptionWhenFailed(hmResult);

				boolean Acknowledge_flag = fetchRecord(connection,"SELECT ISS_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", (String)alHdrData.get(4)).get("ISS_ACK_REQ_YN").toString().equals("Y");
				
				stSQL  = (String)hmSQL.get ("GroupForStoreUpdForPendingAckSQL");
			if(Acknowledge_flag){
		
					for (int i=0; i<alDtlData.size();i++ ) {
						
							ArrayList	alDtlRecord	=	new ArrayList();
							HashMap hmRecord	=	(HashMap) alDtlData.get(i);
							String req_doc_no =(String)alCommonData.get(0);

							boolean group_chk = true;
							if(((String)hmRecord.get("req_group_code")).equals(req_group_chk)){
							 group_chk = false;
							}

							req_group_chk =  (String)hmRecord.get("req_group_code");
							if(group_chk){
								String  sql = (String)hmSQL.get("DtlTrayIssuedCountSQL");
								ArrayList alblockedqty	=	new ArrayList();
								alblockedqty.add(alCommonData.get(0)); //req_doc_no
								alblockedqty.add(alCommonData.get(1)); //req_doctype_code
								alblockedqty.add((String)hmRecord.get("req_group_code")); //req_group_code
								alblockedqty.add(alHdrData.get(4)); //facility_id
								alblockedqty.add(alHdrData.get(5)); //doc_type_code
								alblockedqty.add(alHdrData.get(6)); //iss_doc_no
								HashMap hmblockqty					= fetchRecord(connection, sql, alblockedqty);
								String blocked_qty	= (String)hmblockqty.get("ISSUE_QTY");				

								count=Integer.parseInt(blocked_qty);
								preparedStatement = connection.prepareStatement((String)hmSQL.get ("DtlTrayBlockedQtyUpdateSQL"));
								preparedStatement.setInt(1,count);//blocked_qty
								preparedStatement.setString(2,(String)alHdrData.get(0));//MODIFIED_BY_ID
								preparedStatement.setString(3,(String)alHdrData.get(1));//MODIFIED_AT_WS_NO
								preparedStatement.setString(4,(String)alHdrData.get(2));//MODIFIED_FACILITY_ID
								preparedStatement.setString(5,(String)alHdrData.get(2));//MODIFIED_FACILITY_ID
								preparedStatement.setString(6,(String)alCommonData.get(1));//DOC_TYPE_CODE
								preparedStatement.setInt(7,Integer.parseInt(req_doc_no));//DOC_NO
								preparedStatement.setString(8,(String)hmRecord.get("req_group_code"));//REQ_GROUP_CODE

								iResult	 =	preparedStatement.executeUpdate();						
							}

						// This is for Update of Pending Ack Qty in Group for Store table
							alPendingQty		=	new ArrayList();

							alPendingQty.add(alHdrData.get(0));
							alPendingQty.add(alHdrData.get(1));
							alPendingQty.add(alHdrData.get(2));
							alPendingQty.add((String)alCommonData.get(2));	//to store code	
							alPendingQty.add(hmRecord.get("req_group_code"));

							hmArgData.put(DATA,alPendingQty);				
							hmArgSQL.put(UPDATE_SQL,stSQL);
							hmResult	=	update(connection, hmArgData, hmArgSQL);
							throwExceptionWhenFailed(hmResult);

						}
				}

				//This will update the pending request qty in group for store table
				stSQL  = (String)hmSQL.get ("GroupForStoreUpdForPendingReqSQL");

				int pend_req_qty = 1;

				for (int i=0; i<alDtlData.size();i++ ) {				
				
					HashMap hmRecord	=	(HashMap) alDtlData.get(i);

					alPendingQty		=	new ArrayList();
					
					alPendingQty.add(""+pend_req_qty);
					alPendingQty.add(""+pend_req_qty);
					alPendingQty.add(alHdrData.get(0));
					alPendingQty.add(alHdrData.get(1));
					alPendingQty.add(alHdrData.get(2));
					alPendingQty.add((String)alCommonData.get(2));		
					alPendingQty.add(hmRecord.get("req_group_code"));

					hmArgData.put(DATA,alPendingQty);				
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);		
				}




			
		/*if (iResult<=0) {
						
						isUpdateSuccessful = false;
					}
					if(!isUpdateSuccessful){
						//System.out.println(":(((((((((((((");
						//System.out.println("Third roll back");
						hmResult.put(RESULT,FALSE);
						hmResult.put(MESSAGE,"FAILED");
						connection.rollback();
						throw new Exception("Update failed in Request header record");
					}
				
				if (isUpdateSuccessful) {
					System.out.println("First commit");
					connection.commit();
					if(preparedStatement!=null) {
						preparedStatement.close();
					}
				}*/

			/*connection.commit();
			
        }
		catch(Exception exception) {
			try {
				System.err.println("catch==Reissue====hmData======="+hmData);
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		System.out.println("hmReturn in issue modify"+hmReturn);*/
		return hmReturn;
	}
} 
