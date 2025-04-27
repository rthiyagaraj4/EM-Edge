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
02/05/2014				48841			        Abdul Rabbani      02/05/2014        Abdul Rabbani           MMS-SCF-0335
--------------------------------------------------------------------------------------------------------------------------------------------
*/

package eST.CondemnExpiredBatches;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/*
 Class used to condemn the expired batches. This class is also responsible for inserting data in
 to st_adj_hdr,st_adj_dtl,st_adj_dtl_exp, and also it update the online batches. 
*/

/**
*
* @ejb.bean 
*	name="CondemnExpiredBatches"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CondemnExpiredBatches"
*	local-jndi-name="CondemnExpiredBatches"
*	impl-class-name="eST.CondemnExpiredBatches.CondemnExpiredBatchesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.CondemnExpiredBatches.CondemnExpiredBatchesLocal"
*	remote-class="eST.CondemnExpiredBatches.CondemnExpiredBatchesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.CondemnExpiredBatches.CondemnExpiredBatchesLocalHome"
*	remote-class="eST.CondemnExpiredBatches.CondemnExpiredBatchesHome"
*	generate= "local,remote"
*
*
*/

public class CondemnExpiredBatchesManager extends StEJBSessionAdapter {

	HashMap hmData;
	HashMap hmSQL;
	HashMap	hmReturn;
	Properties	properties	=	null;
	/* Variables which are needed to call the routines to update the online-store and
	other tables.
	*/
/*	String finalized_yn="";
	String item_code					= "";
	String store_code					= "";
	String trn_type						= "";
	String trn_qty						= "";
	String trn_cost						= "";
	String trn_value					= "";

	String trade_id						= "";
	String bin_location_code			= "";
	String expiry_date_or_receipt_date	= "";
	String suspended_batch_allowed_yn	= "";
	String batch_id						= "";

	String mode							= "";*/

	String		stSQL		=	null;


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException{
		//return getMessageHashMap(false);
		//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
		Connection connection = null;
		hmData			= hmDataValues;
		hmSQL			= hmSQLValues;
		hmReturn		= new HashMap();
		String doc_no	= "";
		boolean isFinalized	=	false;
		//boolean chk_store	=	true; //commented by Rabbani on 24-Mar-2014 for chkstyles
		try {
			properties					=	(Properties)	hmData.get("properties");
			connection					=	getConnection(properties);
			connection.setAutoCommit(false);

			ArrayList alDataList 		= (ArrayList) hmDataValues.get("InsertData");
			ArrayList alCommonData		= (ArrayList) hmDataValues.get("CommonData");
			ArrayList alHeaderData		= (ArrayList) hmDataValues.get("HeaderData");
			ArrayList alDetailData		= (ArrayList) hmDataValues.get("DetailData");
			ArrayList alExpData			= (ArrayList) hmDataValues.get("ExpData");
			ArrayList alItemStoreData	= (ArrayList) hmDataValues.get("ItemStoreData");
			ArrayList alTrnDtlData		= (ArrayList) hmDataValues.get("alTrnDetail");
			ArrayList alStockOnlineData	= (ArrayList) hmDataValues.get("alStockOnlineData");	
			ArrayList alItmMoveSummData = (ArrayList) hmDataValues.get("ItemMoveSummData");
			ArrayList alExpiredBatchesData = new ArrayList();
		    ArrayList hmitm_unit_cost_data = new ArrayList();
			HashMap hmResult = new HashMap();
			HashMap	hmArgData	=	new HashMap();
			HashMap	hmArgSQL	=	new HashMap();
		    
		  

		   isFinalized			=	((String)alCommonData.get(3)).equals("Y");
			String curr_condemn_id =  checkForNull((String)alCommonData.get(4));
			
			
			ArrayList alExpbatches = new ArrayList();
			alExpbatches.add((String)alCommonData.get(2)); //facility_id
			alExpbatches.add((String)alCommonData.get(5)); //doc_type_code
			alExpbatches.add(curr_condemn_id); //doc_no
			//Added by Rabbani # Inc no:45705 and 45727 on 19/12/2013
			 // hmitm_unit_cost_data	=	fetchRecords(connection, "SELECT item_code , store_code,item_unit_cost,TO_CHAR(LAST_RECEIPT_DATE,'DD/MM/YYYY')LAST_RECEIPT_DATE	from st_expired_item WHERE  facility_id= ? and	doc_type_code = ? AND CONDEMN_ID = ?" , alExpbatches);
			  hmitm_unit_cost_data	=	fetchRecords(connection, "SELECT store_code,item_code , BATCH_ID,BIN_LOCATION_CODE,TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE ,'DD/MM/YYYY') Expiry_date,item_unit_cost,TO_CHAR(LAST_RECEIPT_DATE,'DD/MM/YYYY')LAST_RECEIPT_DATE	from st_expired_item WHERE  facility_id= ? and	doc_type_code = ? AND CONDEMN_ID = ?" , alExpbatches);
			
			 //ends
			
			 
			stSQL = (String)hmSQL.get("STEXPBATCHSQL");
			ArrayList alExpBatchData	=	fetchRecords(connection, stSQL , alExpbatches);
				for(int i=0;i<alExpBatchData.size();i++) {
		        ArrayList alReleaseBatch	=	new ArrayList();
		        HashMap hmreleasebatch = (HashMap)alExpBatchData.get(i);
		        alReleaseBatch.add("N");
				alReleaseBatch.add((String)alCommonData.get(0)); // modified id
				alReleaseBatch.add((String)alCommonData.get(1)); // ws no
				alReleaseBatch.add((String)alCommonData.get(2)); // facility_id
				//alReleaseBatch.add(curr_condemn_id); // condemn_id 
				alReleaseBatch.add((String)hmreleasebatch.get("STORE_CODE")); //store_code
				alReleaseBatch.add((String)hmreleasebatch.get("ITEM_CODE")); //item_code
				alReleaseBatch.add((String)hmreleasebatch.get("BATCH_ID")); //batch_id
				alReleaseBatch.add((String)hmreleasebatch.get("BIN_LOCATION_CODE")); //bin_loc
				alReleaseBatch.add((String)hmreleasebatch.get("EXPIRY_DATE")); //exp_date
				 
				 
				ArrayList  alBatchCount =new ArrayList();
				alBatchCount.add((String)hmreleasebatch.get("STORE_CODE")); //store_code
				alBatchCount.add((String)hmreleasebatch.get("ITEM_CODE")); //item_code
				alBatchCount.add((String)hmreleasebatch.get("BATCH_ID")); //batch_id
				alBatchCount.add((String)hmreleasebatch.get("BIN_LOCATION_CODE")); //bin_loc
				alBatchCount.add((String)hmreleasebatch.get("EXPIRY_DATE")); //exp_date
				 
				hmResult = fetchRecord(connection,(String)hmSQL.get ("ItemBatchExistsCheckSQL"),alBatchCount);
				int count= Integer.parseInt((String)(hmResult.get("COUNT")));
				if(count > 0){
                     hmArgData.put("DATA",alReleaseBatch);
                     hmArgSQL.put(UPDATE_SQL,hmSQL.get("BatchCondemnUpdateSQL"));
         			 hmReturn =  update(connection, hmArgData, hmArgSQL);
         			 throwExceptionWhenFailed(hmReturn);
				}
			
			}
					
					  
				     stSQL	=	(String)hmSQL.get ("ExpItmDelSQL");
				     hmArgData.put(DATA,alExpbatches);
				     hmArgSQL.put(DELETE_SQL,stSQL);
				     hmReturn	=	delete(connection, hmArgData, hmArgSQL);
				     throwExceptionWhenFailed(hmReturn);
			     
				 //Insert ST_EXPIRED_ITEM
				 int size = alDataList.size();
				 
			     for(int i=0;i<size;i++) {
				HashMap hmRecord = (HashMap) alDataList.get(i);
				ArrayList alExpiredBatch = new ArrayList ();
				alExpiredBatch.add(curr_condemn_id);
				alExpiredBatch.add(hmRecord.get("item_code"));
				alExpiredBatch.add(hmRecord.get("store_code"));
				alExpiredBatch.add(hmRecord.get("batch_id"));
				alExpiredBatch.add(hmRecord.get("bin_location_code"));
				alExpiredBatch.add(hmRecord.get("expiry_date_or_receipt_date"));
				alExpiredBatch.add(hmRecord.get("trade_id"));
				alExpiredBatch.add(hmRecord.get("replace_on_expiry_yn"));
				alExpiredBatch.add(hmRecord.get("qty_on_hand"));
				alExpiredBatch.add(hmRecord.get("trn_remarks_code"));

				alExpiredBatch.add(alCommonData.get(0));
				alExpiredBatch.add(alCommonData.get(1));
				alExpiredBatch.add(alCommonData.get(2));
				alExpiredBatch.add(alCommonData.get(0));
				alExpiredBatch.add(alCommonData.get(1));
				alExpiredBatch.add(alCommonData.get(2));
				
				alExpiredBatch.add(alCommonData.get(2));
				alExpiredBatch.add(hmRecord.get("doc_type_code"));
				alExpiredBatch.add(alCommonData.get(3));
				alExpiredBatch.add(hmRecord.get("condemn_hdr_remarks"));
				alExpiredBatch.add(hmRecord.get("doc_ref"));
				//Added by Rabbani # Inc no:45705 and 45727 on 19/12/2013
				//chk_store = true;
				 for (int m=0; m<hmitm_unit_cost_data.size();m++){
				   HashMap temp = (HashMap)hmitm_unit_cost_data.get(m);
					//if (temp.get("ITEM_CODE").equals((String)hmRecord.get("item_code")) &&  temp.get("STORE_CODE").equals((String)hmRecord.get("store_code")) && chk_store){
			 if (temp.get("ITEM_CODE").equals((String)hmRecord.get("item_code")) &&  temp.get("STORE_CODE").equals((String)hmRecord.get("store_code")) && temp.get("BATCH_ID").equals((String)hmRecord.get("batch_id")) && temp.get("BIN_LOCATION_CODE").equals((String)hmRecord.get("bin_location_code")) && temp.get("EXPIRY_DATE").equals((String)hmRecord.get("expiry_date_or_receipt_date"))){	
						
							alExpiredBatch.add(checkForNull(temp.get("ITEM_UNIT_COST")));
							alExpiredBatch.add(checkForNull(temp.get("LAST_RECEIPT_DATE")));
							// chk_store = false;
						}
				 }
				 //ends
				System.out.println("alExpiredBatch==modify=>" +alExpiredBatch);
		
				alExpiredBatchesData.add(alExpiredBatch);
			}

			// Batch Upadate
			stSQL = (String)hmSQL.get ("ExpiredItemInsertSQL");
			HashMap hmInsertData	=	new HashMap();
			HashMap hmSql			=	new HashMap();

			hmInsertData.put(DATA,alExpiredBatchesData);
			hmSql.put(BATCH_SQL,stSQL);

			try {
				hmResult =  operateBatch(connection, hmInsertData, hmSql);
			}
			catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throwExceptionWhenFailed(hmResult);

			if(isFinalized){
			for(int i=0;i<alHeaderData.size();i++) {
				ArrayList alHeaderRow = (ArrayList)alHeaderData.get(i);
				alHeaderRow.add(""+curr_condemn_id);
			}

           // Insert ST_ADJ_HDR
			stSQL	= (String)hmSQL.get("HeaderInsertSQL");
			hmInsertData.put("DATA", alHeaderData);
			hmSql.put(BATCH_SQL,stSQL);
			hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			throwExceptionWhenFailed(hmReturn);
			

			doc_no = (String)((ArrayList)(alHeaderData.get(alHeaderData.size()-1))).get(2);


           //Insert ST_ADJ_DTL
			stSQL	= (String)hmSQL.get("DetailInsertSQL");
			for(int i=0;i<alDetailData.size();i++) {
				ArrayList alDetailRow = (ArrayList)alDetailData.get(i);
				alDetailRow.set(8,alDetailRow.get(8)+" Condemn ID:"+curr_condemn_id);
			}
			hmInsertData.put("DATA", alDetailData);
			hmSql.put(BATCH_SQL,stSQL);
			try {
				hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			 }
			 catch (Exception ex2) {
				ex2.printStackTrace();
			 }
			throwExceptionWhenFailed(hmReturn);
           //Insert ST_DTL_EXP
			stSQL	= (String)hmSQL.get("ExpInsertSQL");
			hmInsertData.put("DATA",alExpData);
			hmSql.put(BATCH_SQL,stSQL);
			try {
				hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			}
			catch (Exception ex3) { 
				ex3.printStackTrace();
			}
			throwExceptionWhenFailed(hmReturn);

 	        //Update ST_ITEM_STORE
			//Added by Rabbani Incident no 48841(MMS-SCF-0335 ) on 30-APR-2014 Starts
			ArrayList alItemInsertData = new ArrayList();
			ArrayList alData		=	new ArrayList();
			String item_code        = "";
			String condemn_store    =  "";
			
			for(int i = 0; i<alItemStoreData.size(); i++){
			
				ArrayList alDtlRecords = new ArrayList();
				HashMap hmInsertStoreData = new HashMap();
				ArrayList updData = new ArrayList();
				alItemInsertData       =    (ArrayList) alItemStoreData.get(i);
				   item_code           =    (String) alItemInsertData.get(5);
				    condemn_store      =    (String)alItemInsertData.get(6);
				double p_trn_qty	    =    Double.parseDouble((String)(String)alItemInsertData.get(0));
				double p_trn_value	    =    Double.parseDouble((String)alItemInsertData.get(1)==null?"0.00":(String)alItemInsertData.get(1));
				
				stSQL	= "SELECT SUM (NVL (a.qty_on_hand, 0) - NVL (committed_qty, 0))/ST_GET_UOM_CONV_FAC_SING_STR(b.item_code,b.store_code) qty_on_hand,NVL (b.item_value, 0) item_value FROM st_item_batch a, st_item_store b WHERE a.store_code(+) = b.store_code AND a.item_code(+)= b.item_code AND b.item_code = ? AND b.store_code = ? GROUP BY b.item_code, b.store_code, item_value";
				alData.clear();
				alData.add(item_code);
				alData.add(condemn_store);
				hmInsertStoreData = fetchRecord(connection, stSQL, alData);
				
				double l_qty_on_hand		= 0;
				if(hmInsertStoreData.get("QTY_ON_HAND") != null) {
					l_qty_on_hand = Double.parseDouble((String)(hmInsertStoreData.get("QTY_ON_HAND")));
				}
				double l_stk_value		= 0.0;
				if(hmInsertStoreData.get("ITEM_VALUE") != null) {					
					l_stk_value	= Double.parseDouble((String)(hmInsertStoreData.get("ITEM_VALUE")));	
				}

				System.err.println(item_code+" l_qty_on_hand = > "+l_qty_on_hand+" p_trn_qty = > "+p_trn_qty+" l_stk_value = > "+l_stk_value+" p_trn_value = > "+p_trn_value);
				if(((l_qty_on_hand-p_trn_qty)==0)||((l_stk_value-p_trn_value)<0)){
					p_trn_value=l_stk_value;
				}
				//if( ( l_qty_on_hand<p_trn_qty) || (l_stk_value < p_trn_value)) {//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214
				if( ( l_qty_on_hand<p_trn_qty)) {
					throw new Exception("NEGATIVE_STOCK");
				}
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
				updData.add(p_trn_qty);
				updData.add(p_trn_value);
				updData.add(alItemInsertData.get(2));
				updData.add(alItemInsertData.get(3));
				updData.add(alItemInsertData.get(4));
				updData.add(alItemInsertData.get(5));
				updData.add(alItemInsertData.get(6));
				//alDtlRecords.add(alItemInsertData);
				alDtlRecords.add(updData);
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
			
			stSQL	= (String)hmSQL.get("SQL_ST_ITEM_STORE_QTY_ON_HAND_UPDATE");
			hmInsertData.put("DATA",alDtlRecords);
			hmSql.put(BATCH_SQL,stSQL);
			System.err.println("hmInsertData==>" +hmInsertData);
			System.err.println("hmSql==>" +stSQL);
			hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			throwExceptionWhenFailed(hmReturn);
		
			} //ends
			 
            //Generate Doc NO			 
			if(((Boolean)hmDataValues.get("isDocNoAutoGenYN")).booleanValue()) {
				ArrayList languageData		= (ArrayList) hmDataValues.get("LanguageData");
				String locale=(String)languageData.get(0);
				stSQL = (String)hmSQL.get("DocNoUpdate");
				ArrayList alDataValues = new ArrayList();
				alDataValues.add(alCommonData.get(0));
				alDataValues.add(alCommonData.get(1));
				alDataValues.add(alCommonData.get(2));
				alDataValues.add(((ArrayList)(alHeaderData.get(0))).get(1));
				generateDocNo(connection, alDataValues, stSQL, alHeaderData.size(), doc_no,locale) ;
			}

			//Insert or Update ItemMovementSummary
			for(int i=0;i<alItmMoveSummData.size();i++) {
				HashMap hmItemMoveSummRow = (HashMap)alItmMoveSummData.get(i); 
				insertItemMoveSummary (connection, hmSQL, hmItemMoveSummRow);
			}
	        //Update ST_ITEM_BATCH
			for(int i=0;i<alStockOnlineData.size();i++) {
				updateBatchOnLine (connection, hmSQL, (HashMap)alStockOnlineData.get(i));
			}
			//Insert ST_ITEM_TRN_DTL
			for(int i=0;i<alTrnDtlData.size();i++) {
				stSQL = (String)hmSQL.get("ItemTrnDtlInsertSQL");
				insertTrnDtl(connection, (ArrayList)(alTrnDtlData.get(i)), stSQL);
			}
			for(int i=0;i<alDetailData.size();i++) {
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(((ArrayList)alDetailData.get(i)).get(4));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(9));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(10));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(11));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(4));
				hmInsertData.put(DATA,alParameters);
				hmSql.put(UPDATE_SQL,hmSQL.get("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE"));
				hmReturn =  update(connection, hmInsertData, hmSql);
				throwExceptionWhenFailed(hmReturn);
			}
		}else{ //ends finalize here
		       for(int i=0;i<alExpiredBatchesData.size();i++) {
		        ArrayList alParam	=	new ArrayList();
			    //alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(0)); //condemn_id
		        alParam.add("Y"); //suspenden_yn
				alParam.add((String)alCommonData.get(0)); // modified id
				alParam.add((String)alCommonData.get(1)); // ws no
				alParam.add((String)alCommonData.get(2)); // facility_id
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(2)); //store_code
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(1)); //item_code
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(3)); // batch_id
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(4)); // bin_location
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(5)); // exp date
				 
                  ArrayList  alBatchCount =new ArrayList();
                  alBatchCount.add(((ArrayList)alExpiredBatchesData.get(i)).get(2)); //store_code
                  alBatchCount.add(((ArrayList)alExpiredBatchesData.get(i)).get(1)); //item_code
                  alBatchCount.add(((ArrayList)alExpiredBatchesData.get(i)).get(3)); // batch_id
                  alBatchCount.add(((ArrayList)alExpiredBatchesData.get(i)).get(4)); // bin_location
                  alBatchCount.add(((ArrayList)alExpiredBatchesData.get(i)).get(5)); // exp date
				
                 
                hmResult = fetchRecord(connection,(String)hmSQL.get ("ItemBatchExistsCheckSQL"),alBatchCount);
				int count= Integer.parseInt((String)(hmResult.get("COUNT")));
				if(count > 0){
				hmInsertData.put("DATA",alParam);
			   hmSql.put(UPDATE_SQL,hmSQL.get("BatchCondemnUpdateSQL"));
			   hmReturn =  update(connection, hmInsertData, hmSql);
			   throwExceptionWhenFailed(hmReturn);
			 }    
			}
		 }  
			connection.commit();
			hmReturn.put("flag","");
			hmReturn.put("doc_no", curr_condemn_id);
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
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
//ends
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException {
		//return getMessageHashMap(false);
		//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
		Connection connection = null;
		hmData			= hmDataValues;
		hmSQL			= hmSQLValues;
		hmReturn		= new HashMap();
		 
		ArrayList alCommonData	 =  (ArrayList) hmDataValues.get("CommonData");
		HashMap hmResult        =   new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		 ArrayList  alBatchCount = new ArrayList();
		//mode = "DELETE";
		hmReturn.put(RESULT,FALSE);
 
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);
			
			ArrayList alExpbatches = new ArrayList();
			alExpbatches.add((String)alCommonData.get(2)); //facility_id
			alExpbatches.add((String)alCommonData.get(5)); //doc_type_code
			alExpbatches.add((String)alCommonData.get(4)); //doc_no
			
			 
			
			        stSQL = (String)hmSQL.get("STEXPBATCHSQL");
					ArrayList alExpBatchData	=	fetchRecords(connection, stSQL , alExpbatches);
				 for(int i=0;i<alExpBatchData.size();i++) {
		        ArrayList alReleaseBatch	=	new ArrayList();
		        HashMap hmreleasebatch = (HashMap)alExpBatchData.get(i);
		        alReleaseBatch.add("N");
				alReleaseBatch.add((String)alCommonData.get(0)); // modified id
				alReleaseBatch.add((String)alCommonData.get(1)); // ws no
				alReleaseBatch.add((String)alCommonData.get(2)); // facility_id
				//alReleaseBatch.add((String)alCommonData.get(4)); // condemn_id 
				alReleaseBatch.add((String)hmreleasebatch.get("STORE_CODE")); //store_code
				alReleaseBatch.add((String)hmreleasebatch.get("ITEM_CODE")); //item_code
				alReleaseBatch.add((String)hmreleasebatch.get("BATCH_ID")); //batch_id
				alReleaseBatch.add((String)hmreleasebatch.get("BIN_LOCATION_CODE")); //bin_loc
				alReleaseBatch.add((String)hmreleasebatch.get("EXPIRY_DATE")); //exp_date
				 
				
				 alBatchCount.add((String)hmreleasebatch.get("STORE_CODE")); //store_code
                 alBatchCount.add((String)hmreleasebatch.get("ITEM_CODE")); //item_code
                alBatchCount.add((String)hmreleasebatch.get("BATCH_ID")); // batch_id
                alBatchCount.add((String)hmreleasebatch.get("BIN_LOCATION_CODE")); // bin_location
                alBatchCount.add((String)hmreleasebatch.get("EXPIRY_DATE")); // exp date
				
				hmResult = fetchRecord(connection,(String)hmSQL.get ("ItemBatchExistsCheckSQL"),alBatchCount);
				int count= Integer.parseInt((String)(hmResult.get("COUNT")));
				
				
				 
                     if(count> 0){
                     hmArgData.put("DATA",alReleaseBatch);
                     hmArgSQL.put(UPDATE_SQL,hmSQL.get("BatchCondemnUpdateSQL"));
         			hmReturn =  update(connection, hmArgData, hmArgSQL);
         			throwExceptionWhenFailed(hmReturn);
                     }
			
			}
					
					  
				     stSQL	=	(String)hmSQL.get ("ExpItmUpdateSQL");
				     hmArgData.put(DATA,alExpbatches);
				     hmArgSQL.put(UPDATE_SQL,stSQL);
				     hmReturn	=	update(connection, hmArgData, hmArgSQL);
				     throwExceptionWhenFailed(hmReturn);
			

			connection.commit();
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
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
		//ends
	}

	/*
	 Method responsible for inserting the expired batch details, and update the
	 related details as well.
	 @param hmDataValues, the data to be inserted
	 @param hmSQLValues, the queries used for the corresponding updates
	 @return the result and the messages
	*/
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmDataValues, HashMap hmSQLValues) {
		Connection connection = null;
		hmData			= hmDataValues;
		hmSQL			= hmSQLValues;
		hmReturn		= new HashMap();
		String doc_no	= "";
		boolean isFinalized	=	false;
		try {
			properties					=	(Properties)	hmData.get("properties");
			connection					=	getConnection(properties);
			connection.setAutoCommit(false);

			ArrayList alDataList 		= (ArrayList) hmDataValues.get("InsertData");
			ArrayList alCommonData		= (ArrayList) hmDataValues.get("CommonData");
			
			ArrayList alHeaderData		= (ArrayList) hmDataValues.get("HeaderData");
			ArrayList alDetailData		= (ArrayList) hmDataValues.get("DetailData");
			ArrayList alExpData			= (ArrayList) hmDataValues.get("ExpData");
			ArrayList alItemStoreData	= (ArrayList) hmDataValues.get("ItemStoreData");

			ArrayList alTrnDtlData		= (ArrayList) hmDataValues.get("alTrnDetail");
			ArrayList alStockOnlineData	= (ArrayList) hmDataValues.get("alStockOnlineData");	

			ArrayList alItmMoveSummData = (ArrayList) hmDataValues.get("ItemMoveSummData");
			ArrayList alExpiredBatchesData = new ArrayList();
			isFinalized			=	((String)alCommonData.get(3)).equals("Y"); //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts

		
			/*Code to fetch the curr_condemn_id from st_acc_entity_id and to update that
			as well */

			stSQL = (String)hmSQL.get ("CondemnIDSelectSQL");


			//"SELECT curr_condemn_id+1 FROM st_acc_entity_param";

			HashMap hmResult = fetchRecord(connection,stSQL);
			String curr_condemn_id = (String)(hmResult.get("CURR_CONDEMN_ID"));
			int size = alDataList.size();

			for(int i=0;i<size;i++) {
				HashMap hmRecord = (HashMap) alDataList.get(i);
				ArrayList alExpiredBatch = new ArrayList ();
				ArrayList alparam = new ArrayList ();
				HashMap hmitem_unit_cost = new HashMap();
				
				alExpiredBatch.add(curr_condemn_id);
				alExpiredBatch.add(hmRecord.get("item_code"));
				alExpiredBatch.add(hmRecord.get("store_code"));
				alExpiredBatch.add(hmRecord.get("batch_id"));
				alExpiredBatch.add(hmRecord.get("bin_location_code"));
				alExpiredBatch.add(hmRecord.get("expiry_date_or_receipt_date"));
				alExpiredBatch.add(hmRecord.get("trade_id"));
				alExpiredBatch.add(hmRecord.get("replace_on_expiry_yn"));
				alExpiredBatch.add(hmRecord.get("qty_on_hand"));
				alExpiredBatch.add(hmRecord.get("trn_remarks_code"));

				alExpiredBatch.add(alCommonData.get(0));
				alExpiredBatch.add(alCommonData.get(1));
				alExpiredBatch.add(alCommonData.get(2));
				alExpiredBatch.add(alCommonData.get(0));
				alExpiredBatch.add(alCommonData.get(1));
				alExpiredBatch.add(alCommonData.get(2));
				
				alExpiredBatch.add(alCommonData.get(2));
				alExpiredBatch.add(hmRecord.get("doc_type_code"));
				alExpiredBatch.add(alCommonData.get(3));
				alExpiredBatch.add(hmRecord.get("condemn_hdr_remarks"));
				alExpiredBatch.add(hmRecord.get("doc_ref"));
				//Added by Rabbani # Inc no:45705 and 45727 on 19/12/2013
				 alparam.add(checkForNull(hmRecord.get("store_code")));
				alparam.add(checkForNull(hmRecord.get("item_code")));
				alparam.add(checkForNull(hmRecord.get("batch_id")));
				alparam.add(checkForNull(hmRecord.get("bin_location_code")));
				alparam.add(checkForNull(hmRecord.get("expiry_date_or_receipt_date")));
				 
				// hmitem_unit_cost = fetchRecord(connection,"SELECT ROUND(NVL(st.item_value,0)/DECODE(NVL(st.qty_on_hand,0),0,1,NVL(st.qty_on_hand,0)),3) unit_cost ,  TO_CHAR(st.LAST_RECEIPT_DATE,'DD/MM/YYYY')LAST_RECEIPT_DATE FROM ST_ITEM_STORE st WHERE st.STORE_CODE = ? AND st.ITEM_CODE = ?",alparam);
				 
				  //hmitem_unit_cost = fetchRecord(connection,"SELECT ROUND(NVL(st.item_value,0)/DECODE(NVL(st.qty_on_hand,0),0,1,NVL(st.qty_on_hand,0)),3) unit_cost ,  TO_CHAR(A.LAST_RECEIPT_DATE,'DD/MM/YYYY')LAST_RECEIPT_DATE FROM ST_ITEM_STORE st,ST_ITEM_BATCH A WHERE  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND A.BATCH_ID = ? AND A.BIN_LOCATION_CODE = ? AND A.EXPIRY_DATE_OR_RECEIPT_DATE = to_date(?,'dd/mm/yyyy') and A.STORE_CODE = ST.STORE_CODE AND A.ITEM_CODE = ST.ITEM_CODE",alparam);
				//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214
				hmitem_unit_cost = fetchRecord(connection,"SELECT st_display_unit_cost(a.item_code,sysdate,'CURRENT_STOCK') unit_cost ,  TO_CHAR(A.LAST_RECEIPT_DATE,'DD/MM/YYYY')LAST_RECEIPT_DATE FROM ST_ITEM_BATCH A WHERE  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND A.BATCH_ID = ? AND A.BIN_LOCATION_CODE = ? AND A.EXPIRY_DATE_OR_RECEIPT_DATE = to_date(?,'dd/mm/yyyy') ",alparam);
				
				alExpiredBatch.add(checkForNull((String)hmitem_unit_cost.get("UNIT_COST")));
				alExpiredBatch.add(checkForNull((String)hmitem_unit_cost.get("LAST_RECEIPT_DATE")));
				//ends
				System.out.println("alExpiredBatch==insert==>" +alExpiredBatch);

				alExpiredBatchesData.add(alExpiredBatch);
			}

			// Batch Upadate

			stSQL = (String)hmSQL.get ("ExpiredItemInsertSQL");

			//"INSERT into st_expired_item (condemn_id,item_code,store_code,batch_id,bin_location_code,expiry_date_or_receipt_date,trade_id,replace_on_expiry_yn,item_qty,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

			HashMap hmInsertData	=	new HashMap();
			HashMap hmSql			=	new HashMap();

			hmInsertData.put(DATA,alExpiredBatchesData);
			hmSql.put(BATCH_SQL,stSQL);

			try {
				hmResult =  operateBatch(connection, hmInsertData, hmSql);
			}
			catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throwExceptionWhenFailed(hmResult);

			// Update the curr_condemn_id in st_acc_entity_param.

			stSQL = (String)hmSQL.get ("CondemnIDUpdateSQL");


			//"Update st_acc_entity_param SET curr_condemn_id = curr_condemn_id+1, MODIFIED_BY_ID = ?, MODIFIED_DATE = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?";

			ArrayList alCurrCondemnIdUpdateData	= new ArrayList();
			alCurrCondemnIdUpdateData.add(alCommonData.get(0));
			alCurrCondemnIdUpdateData.add(alCommonData.get(1));
			alCurrCondemnIdUpdateData.add(alCommonData.get(2));

			hmInsertData.put(DATA,alCurrCondemnIdUpdateData);
			hmSql.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmInsertData, hmSql);
			throwExceptionWhenFailed(hmReturn);

			/**
			* Code to update the st_adj_hdr table starts here - batch update
			*/
               if(isFinalized) {	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
			for(int i=0;i<alHeaderData.size();i++) {
				ArrayList alHeaderRow = (ArrayList)alHeaderData.get(i);
				alHeaderRow.add(""+curr_condemn_id);
			}


			stSQL	= (String)hmSQL.get("HeaderInsertSQL");
			hmInsertData.put("DATA", alHeaderData);
			hmSql.put(BATCH_SQL,stSQL);
			hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			throwExceptionWhenFailed(hmReturn);
			

			doc_no = (String)((ArrayList)(alHeaderData.get(alHeaderData.size()-1))).get(2);


			/**
			* Code to update the st_adj_hdr ends here
			*/

			/**
			* Code to update the st_adj_dtl table starts here
			*/

			stSQL	= (String)hmSQL.get("DetailInsertSQL");

			for(int i=0;i<alDetailData.size();i++) {
				ArrayList alDetailRow = (ArrayList)alDetailData.get(i);
				alDetailRow.set(8,alDetailRow.get(8)+" Condemn ID:"+curr_condemn_id);
			}

			hmInsertData.put("DATA", alDetailData);
			hmSql.put(BATCH_SQL,stSQL);
			try {
				hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			}
			catch (Exception ex2) {
				ex2.printStackTrace();
			}

			throwExceptionWhenFailed(hmReturn);

			/**
			* Code to update the st_adj_dtl ends here
			*/


			/**
			* Code to update the st_adj_dtl_exp table starts here
			*/

			stSQL	= (String)hmSQL.get("ExpInsertSQL");
			hmInsertData.put("DATA",alExpData);
			hmSql.put(BATCH_SQL,stSQL);
			try {
				hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			}
			catch (Exception ex3) {
				ex3.printStackTrace();
			}
			throwExceptionWhenFailed(hmReturn);

//added by manish on Wednesday, October 22, 2003			 
             //Added by Rabbani Incident no 48841(MMS-SCF-0335 ) on 30-APR-2014 Starts
			ArrayList alItemInsertData = new ArrayList();
			ArrayList alData		=	new ArrayList();
			
			for(int i = 0; i<alItemStoreData.size(); i++){
				ArrayList alDtlRecords = new ArrayList();
				HashMap hmInsertStoreData = new HashMap();
				ArrayList updData = new ArrayList();

				alItemInsertData =    (ArrayList) alItemStoreData.get(i);
				
				String item_code        = (String)alItemInsertData.get(5);
				String condemn_store    = (String)alItemInsertData.get(6);
				double p_trn_qty		= Double.parseDouble((String)(String)alItemInsertData.get(0));
				double p_trn_value	    = Double.parseDouble((String)alItemInsertData.get(1)==null?"0.00":(String)alItemInsertData.get(1));
				
				stSQL	= "SELECT SUM (NVL (a.qty_on_hand, 0) - NVL (committed_qty, 0))/ST_GET_UOM_CONV_FAC_SING_STR(b.item_code,b.store_code) qty_on_hand,NVL (b.item_value, 0) item_value FROM st_item_batch a, st_item_store b WHERE a.store_code(+) = b.store_code AND a.item_code(+)= b.item_code AND b.item_code = ? AND b.store_code = ? GROUP BY b.item_code, b.store_code, item_value";
				alData.clear();

				alData.add(item_code);
				alData.add(condemn_store);
				
				hmInsertStoreData = fetchRecord(connection, stSQL, alData);
				double l_qty_on_hand		= 0;
				if(hmInsertStoreData.get("QTY_ON_HAND") != null) {
					l_qty_on_hand = Double.parseDouble((String)(hmInsertStoreData.get("QTY_ON_HAND")));
				}
				double l_stk_value		= 0.0;
				if(hmInsertStoreData.get("ITEM_VALUE") != null) {					
					l_stk_value	= Double.parseDouble((String)(hmInsertStoreData.get("ITEM_VALUE")));	
				}

				System.err.println(item_code+" l_qty_on_hand = > "+l_qty_on_hand+" p_trn_qty = > "+p_trn_qty+" l_stk_value = > "+l_stk_value+" p_trn_value = > "+p_trn_value);
				if(((l_qty_on_hand-p_trn_qty)==0)||((l_stk_value-p_trn_value)<0)){
					p_trn_value=l_stk_value;
				}
				//if( ( l_qty_on_hand<p_trn_qty) || (l_stk_value < p_trn_value)) {//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214
				if( ( l_qty_on_hand<p_trn_qty)) {
					throw new Exception("NEGATIVE_STOCK");
				}
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
				updData.add(p_trn_qty);
				updData.add(p_trn_value);
				updData.add(alItemInsertData.get(2));
				updData.add(alItemInsertData.get(3));
				updData.add(alItemInsertData.get(4));
				updData.add(alItemInsertData.get(5));
				updData.add(alItemInsertData.get(6));
				//alDtlRecords.add(alItemInsertData);
				alDtlRecords.add(updData);
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
			
			stSQL	= (String)hmSQL.get("SQL_ST_ITEM_STORE_QTY_ON_HAND_UPDATE");
			hmInsertData.put("DATA",alDtlRecords);
			hmSql.put(BATCH_SQL,stSQL);
			//System.out.println("hmInsertData==>" +hmInsertData);
			//System.out.println("hmSql==>" +stSQL);
			hmReturn =  operateBatch(connection, hmInsertData, hmSql);
			throwExceptionWhenFailed(hmReturn);
			
			}
			//ends
//
			/**
			* Code to update the st_adj_dtl_exp ends here
			*/
		
			if(((Boolean)hmDataValues.get("isDocNoAutoGenYN")).booleanValue()) {
				ArrayList languageData		= (ArrayList) hmDataValues.get("LanguageData");
				String locale=(String)languageData.get(0);
				stSQL = (String)hmSQL.get("DocNoUpdate");
				ArrayList alDataValues = new ArrayList();
				alDataValues.add(alCommonData.get(0));
				alDataValues.add(alCommonData.get(1));
				alDataValues.add(alCommonData.get(2));
				alDataValues.add(((ArrayList)(alHeaderData.get(0))).get(1));
				generateDocNo(connection, alDataValues, stSQL, alHeaderData.size(), doc_no,locale) ;
			}

			/**
			* Code to insert data in to ItemMovementSummary starts here
			*/
			

			for(int i=0;i<alItmMoveSummData.size();i++) {
				HashMap hmItemMoveSummRow = (HashMap)alItmMoveSummData.get(i); 
				insertItemMoveSummary (connection, hmSQL, hmItemMoveSummRow);
			}


			/**
			* Code to insert data in to ItemMovementSummary ends here
			*/


			/**
			* Code to update the on-line stock starts here
			*/

			for(int i=0;i<alStockOnlineData.size();i++) {
				updateBatchOnLine (connection, hmSQL, (HashMap)alStockOnlineData.get(i));
			}

			for(int i=0;i<alTrnDtlData.size();i++) {
				stSQL = (String)hmSQL.get("ItemTrnDtlInsertSQL");
				insertTrnDtl(connection, (ArrayList)(alTrnDtlData.get(i)), stSQL);
			}
			for(int i=0;i<alDetailData.size();i++) {
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(((ArrayList)alDetailData.get(i)).get(4));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(9));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(10));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(11));
				alParameters.add(((ArrayList)alDetailData.get(i)).get(4));
				hmInsertData.put(DATA,alParameters);
				hmSql.put(UPDATE_SQL,hmSQL.get("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE"));
				hmReturn =  update(connection, hmInsertData, hmSql);
				throwExceptionWhenFailed(hmReturn);
			}
            }else{ //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
		       
		       for(int i=0;i<alExpiredBatchesData.size();i++) {
		        ArrayList alParam	=	new ArrayList();
			    //alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(0)); //condemn_id
		        alParam.add("Y"); 
				alParam.add((String)alCommonData.get(0)); // modified id
				alParam.add((String)alCommonData.get(1)); // ws no
				alParam.add((String)alCommonData.get(2)); // facility_id
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(2)); //store_code
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(1)); //item_code
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(3)); // batch_id
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(4)); // bin_location
				alParam.add(((ArrayList)alExpiredBatchesData.get(i)).get(5)); // exp date
				 
			 hmInsertData.put("DATA",alParam);
			hmSql.put(UPDATE_SQL,hmSQL.get("BatchCondemnUpdateSQL"));
			hmReturn =  update(connection, hmInsertData, hmSql);
			throwExceptionWhenFailed(hmReturn);
			
			}
		}//ends
			connection.commit();
			hmReturn.put("flag","Condemn Id: "+curr_condemn_id);
			hmReturn.put("doc_no", curr_condemn_id);
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
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}

	/*
	 Method used to insert data in to st_item_trn_dtl table. 
	@param connection, the connection object.
	@param alData, the data to be inserted.
	@param stSQL, the query responsible for inserting the data.
	*/

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public void insertTrnDtl( Connection connection,ArrayList alData,String  stSQL) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();

		HashMap	hmReturn =	new HashMap();	
		hmArgData.put(DATA,alData);
		hmArgSQL.put(INSERT_SQL,stSQL);

		hmReturn	=	insert(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}

	/**
	* Methos to generate the next doc_no and update the st_acc_entity_param table.
	*@param connection, The connection object.
	*@param alData, Contains the values for the Audit columns to be updated along with doc_no.
	*@param stSQL, The query responsible for updating the doc_no.
	*@param size, Number of times this has to be updated, as this transaction may contain more than 
	*             one header.
	*/

	public void generateDocNo(Connection connection, ArrayList alData, String stSQL, int size, String doc_no,String locale) throws Exception {
		HashMap hmArgData	= new HashMap();
		HashMap hmArgSQL	= new HashMap();
		hmArgData.put(DATA,alData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		for(int i=0;i<size;i++) {
			HashMap hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		String s = getSTMessage(locale, "DOC_NO", "ST") ;
		String s1=s+":  "+doc_no;
		hmReturn.put("flag",s1);
	}


	public void insertItemMoveSummary (Connection connection, HashMap hmSQL, HashMap hmData) throws Exception {
		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();
	//	ArrayList alDtlData				=	new ArrayList();
		ArrayList alItemMoveSummRecord	=	new ArrayList();

		String l_doc_date   = (String) hmData.get("doc_date");	  

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);					  

		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));
		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");


		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(hmData.get("facility_id")); // facility_id
		alItemMoveSummRecord.add(hmData.get("item_code"));
		alItemMoveSummRecord.add(hmData.get("store_code")); // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);
		/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(hmData.get("facility_id"));      // facility_id
		nafitive_value_to_zero.add(hmData.get("item_code"));     // Item code
		nafitive_value_to_zero.add(hmData.get("store_code"));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {

			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(hmData.get("facility_id"));
			alItemMoveSummRecord.add(hmData.get("item_code"));
			alItemMoveSummRecord.add(hmData.get("store_code")); // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(hmData.get("adj_qty"));
			
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmData.get("adj_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmData.get("adj_cost")); //month_closing_value = item_cost_value
			}
			alItemMoveSummRecord.add(hmData.get("adj_qty"));
			alItemMoveSummRecord.add(hmData.get("adj_cost"));

			/* Condemn expired batches is considered as negative adjustment*/
				
			alItemMoveSummRecord.add("0");
			alItemMoveSummRecord.add("0");
			alItemMoveSummRecord.add(hmData.get("adj_qty"));
			alItemMoveSummRecord.add(hmData.get("adj_cost"));

			alItemMoveSummRecord.add(hmData.get("login_by_id"));
			alItemMoveSummRecord.add(hmData.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmData.get("login_facility_id"));
			alItemMoveSummRecord.add(hmData.get("login_by_id"));
			alItemMoveSummRecord.add(hmData.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmData.get("login_facility_id"));

			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {

			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(hmData.get("adj_qty"));
			alItemMoveSummRecord.add(hmData.get("adj_cost"));
			alItemMoveSummRecord.add(hmData.get("adj_qty"));
				/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmData.get("adj_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmData.get("adj_cost")); //month_closing_value = item_cost_value
			}
			
			alItemMoveSummRecord.add("0");
			alItemMoveSummRecord.add("0");
			alItemMoveSummRecord.add(hmData.get("adj_qty"));
			alItemMoveSummRecord.add(hmData.get("adj_cost"));
			alItemMoveSummRecord.add(hmData.get("login_by_id"));
			alItemMoveSummRecord.add(hmData.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmData.get("login_facility_id"));
			alItemMoveSummRecord.add(hmData.get("facility_id")); // facility_id
			alItemMoveSummRecord.add(hmData.get("item_code"));
			alItemMoveSummRecord.add(hmData.get("store_code")); // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

		}
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}

}
