/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.AdjustStock;  
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import java.util.*;
/**
*
* @ejb.bean
*	name="AdjustStock"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AdjustStock"
*	local-jndi-name="AdjustStock"
*	impl-class-name="eST.AdjustStock.AdjustStockManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.AdjustStock.AdjustStockLocal"
*	remote-class="eST.AdjustStock.AdjustStockRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.AdjustStock.AdjustStockLocalHome"
*	remote-class="eST.AdjustStock.AdjustStockHome"
*	generate= "local,remote"
*
*
*/

public class AdjustStockManager extends StEJBSessionAdapter {

	HashMap hmData;
	HashMap hmSQL;
	HashMap	hmReturn;
	Properties	properties	=	null;

	String finalized_yn="";

	String item_code					= "";
	String store_code					= "";
	String trn_type						= "ADJ";
	String trn_qty						= "";
	String trn_cost						= "";
	String trn_value					= "";

	String trade_id						= "";
	String bin_location_code			= "";
	String expiry_date_or_receipt_date	= "";
	String suspended_batch_allowed_yn	= "";
	String batch_id						= "";

	String mode							= "";

	String		stSQL		=	null;

	String barcode_id					= "";

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmDataValues, HashMap hmSQLValues){
		
		Connection	connection	=	null;
		mode = "INSERT";

		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;

		hmReturn	=	new HashMap();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList	languageData	=	new ArrayList();

		String stCurrentItemCodeInCaseOfError=null;

		hmReturn.put(RESULT,FALSE);

		// Variable to hold the current item description, to display along with the error message.

		String l_curr_item_desc = "";
		int      sizeOfTrn		=	1;
		int      trnRecords		=	1;
		ArrayList doc_no = new ArrayList();
		ArrayList alCommonData		=	(ArrayList)	hmData.get("CommonData");
		ArrayList	alHdrData	=	new ArrayList();
					
		String temp_doc_no="";
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList<Integer> alItemClassCount	= new ArrayList<Integer>();
		String item_class_based	= checkForNull((String)hmData.get("ITEM_CLASS_BASED"),"N");
		ArrayList<ArrayList> alTempData		= new ArrayList<ArrayList>();
		alTempData		=	(ArrayList) hmData.get("HdrInsertData");
		if(hmData.containsKey("ItemClassCount")){
			alItemClassCount=	(ArrayList) hmData.get("ItemClassCount");
		}


	
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			//Call to the insert header method, to insert the record in st_adj_hdr.

			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			ArrayList alDtlData1	=	(ArrayList)	hmData.get("DtlInsertData");
			languageData	=	(ArrayList)	hmData.get("LanguageData");
			String 	sql_st_records_per_trn_select		=	"SELECT RECORDS_PER_TRN FROM ST_TRN_TYPE WHERE TRN_TYPE=?";
			HashMap records	=	fetchRecord(connection, sql_st_records_per_trn_select,trn_type);
			int records_per_trn = 0;
			if((String)records.get("RECORDS_PER_TRN")!=null){
				records_per_trn = Integer.parseInt((String)records.get("RECORDS_PER_TRN"));
			}else{
				records_per_trn = alDtlData1.size();
			}
			if(item_class_based.equals("Y")){
				sizeOfTrn = alItemClassCount.size();
			}else{
				if(records_per_trn>alDtlData1.size()){
					sizeOfTrn = 1;
				}else if((alDtlData1.size()%records_per_trn)==0){
					sizeOfTrn = alDtlData1.size()/records_per_trn;
				}else{
					sizeOfTrn = (alDtlData1.size()/records_per_trn)+1;
				}
			}
		if (!( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue()) ) {
				sizeOfTrn=1;
			}
			for(int j=0,k=0;j<sizeOfTrn;j++){
				if(item_class_based.equals("Y")){
					alHdrData = new ArrayList();
					alHdrData = alTempData.get(j);
					//isFinalized			=	((String)alHdrData.get(8)).equals("Y");
				}
				if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
				temp_doc_no=(String)fetchRecord(connection,"SELECT next_doc_no, doc_print_flag FROM sy_acc_entity_doc_type WHERE doc_type_code = ?", (String)alHdrData.get(1)).get("NEXT_DOC_NO");
				alHdrData.set(2,temp_doc_no);
				doc_no.add(temp_doc_no);
			}else{
			doc_no.add(alHdrData.get(2));
			}

			hmData.put("HdrInsertData",alHdrData);
			insertOrUpdateHeader(connection);
			alDtlData	=	new ArrayList();
			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

				if(item_class_based.equals("Y")){
					trnRecords = k + alItemClassCount.get(j);
				}else{
					if(records_per_trn>alDtlData.size()){
						trnRecords = alDtlData.size();
					}else if((k+records_per_trn)>=alDtlData.size()){
						trnRecords = alDtlData.size();
					}else{
						trnRecords = k+records_per_trn;
					}
				}
				int temp_doc_srl_no=0;	
			//for (int i=0; i<alDtlData.size();i++ ) {
				for (int i=k;i<trnRecords ;i++ ) {	
				//Call to the insertDetail method, to insert records in to st_adj_dtl.
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				stCurrentItemCodeInCaseOfError=(String)hmRecord.get("item_code");
				//String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");
				l_curr_item_desc = (String) hmRecord.get("item_desc");

// PROBLEM HERE  

				temp_doc_srl_no=temp_doc_srl_no+1;
				insertOrUpdateDetail(connection, i, temp_doc_srl_no);
				alExpData	=	(ArrayList)		hmData.get("ExpInsertData");

				for (int p=0; p<alExpData.size();p++ ) {
					HashMap hmExpRecord	=	(HashMap) alExpData.get(p);
				/*	if (!doc_srl_no.equals(hmExpRecord.get("doc_srl_no"))&&!(((String)hmRecord.get("item_code")).equals((String)hmExpRecord.get("item_code")))) {
						continue;
					}*/
					if(!(stCurrentItemCodeInCaseOfError).equals((String)hmExpRecord.get("item_code"))) {
					continue;
					}
			
					insertDetailExp(connection, i, p, temp_doc_srl_no);						
										
				}
			}
			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
			//	generateDocNo();
					String s  = "";
					String s1 = "";
		stSQL			=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");
	
		ArrayList alNextDocNoUpdateData	=	new ArrayList();
		alNextDocNoUpdateData.add(alCommonData.get(0));
		alNextDocNoUpdateData.add(alCommonData.get(1));
		alNextDocNoUpdateData.add(alCommonData.get(2));
		alNextDocNoUpdateData.add(alHdrData.get(1));
				hmArgData	=	new HashMap();
				hmArgSQL	=	new HashMap();
		languageData		=	(ArrayList)	hmData.get("LanguageData");
		String locale=(String)languageData.get(0);
		if(doc_no.size()>1){
						java.util.Locale loc = new java.util.Locale(locale);
						java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						s = getSTMessage(locale, "DOC_NOS_GEN_FROM", "ST") ;
					
						s1=s+"  "+doc_no.get(0)+" "+common_labels.getString("Common.to.label")+" "+doc_no.get(doc_no.size()-1);
					}else{
						s = getSTMessage(locale, "DOC_NO", "ST") ;
						s1=s+":  "+doc_no.get(0);
						}
						hmArgData.put(DATA,alNextDocNoUpdateData);
						hmArgSQL.put(UPDATE_SQL,stSQL);
						hmReturn	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmReturn);

						hmReturn.put("flag","Doc No: "+s1);

			}
				if(item_class_based.equals("Y")){
					k = k + alItemClassCount.get(j);
				}else{
					k=k+records_per_trn;
				}
		}
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
			hmReturn.put("invalidCode",l_curr_item_desc);

			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmReturn.put("flag",stCurrentItemCodeInCaseOfError);
			}
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		// Added By Rams For the Al Khadira Issue 5/3/2010 (Online print Option is not working.....)
		hmReturn.put("doc_no",doc_no);
		return hmReturn;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) {
		Connection	connection	=	null;
		PreparedStatement preparedStatement	=	null;
		ResultSet resultSet = null;

		HashMap hmReturn = new HashMap();

		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;

		hmReturn	=	new HashMap();

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();

		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList   alHdrData	=	new ArrayList();
		ArrayList   alCommonData=	new ArrayList(); 	

		String stCurrentItemCodeInCaseOfError=null;

		mode = "MODIFY";

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			// Query for the header record. Update the record.

			insertOrUpdateHeader(connection);

			alHdrData	=	(ArrayList)	hmData.get("HdrInsertData");
			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			alExpData	=	(ArrayList)		hmData.get("ExpInsertData");
			alCommonData=	(ArrayList)	hmData.get("CommonData");
			String l_records_to_delete = (String) hmData.get("RecordsToDelete");
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(l_records_to_delete,",");

			String nextToken = "";
			HashMap hmRecord = new HashMap();
			ArrayList alDataToDetailDelete = new ArrayList ();

			for (int i=0; i<alDtlData.size();i++ ) {
				//Call to the insertDetail method, to insert records in to st_adj_dtl.
				hmRecord	=	(HashMap) alDtlData.get(i);
// save the item codein case of error
stCurrentItemCodeInCaseOfError=(String)hmRecord.get("item_code");
				String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");

				if (stRecordsToDelete.hasMoreTokens()) {
					nextToken = stRecordsToDelete.nextToken();
				}
				if(nextToken.equals("Y")) {

					preparedStatement = connection.prepareStatement((String)hmSQL.get("expForDelSQL"));
					preparedStatement.setString(1, (String)alHdrData.get(0)); // facility-id
					preparedStatement.setString(2, (String)alHdrData.get(1)); // doc-type-code
					preparedStatement.setString(3, (String)alHdrData.get(2)); // doc-no
					preparedStatement.setString(4, doc_srl_no);
					ArrayList alBatchesToBeReleased = new ArrayList ();
					resultSet = preparedStatement.executeQuery();	   
					while (resultSet != null && resultSet.next()) {
						/* @Name - Priya
						* @Date - 18/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - "qty_from_table", "ITEM_QTY" Integer is changed to Double.
						*/
						double qty_from_table = Double.parseDouble(resultSet.getString("ITEM_QTY"));
						if(qty_from_table < 0) {
							HashMap hmBatchRecord = new HashMap();
							hmBatchRecord.put("store_code", resultSet.getString("STORE_CODE"));
							hmBatchRecord.put("item_code", resultSet.getString("ITEM_CODE"));
							hmBatchRecord.put("batch_id", resultSet.getString("BATCH_ID").trim());//trim() added for KAUH-SCF-0344
							hmBatchRecord.put("bin_location_code", resultSet.getString("BIN_LOCATION_CODE"));
							hmBatchRecord.put("expiry_date_or_receipt_date", resultSet.getString("EXPIRY_DATE_OR_RECEIPT_DATE"));
							hmBatchRecord.put("trn_qty", ""+(-(qty_from_table)));
							hmBatchRecord.put("login_by_id", alCommonData.get(0));
							hmBatchRecord.put("login_at_ws_no", alCommonData.get(1));
							hmBatchRecord.put("login_facility_id", alCommonData.get(2));
							alBatchesToBeReleased.add(hmBatchRecord);
						}
					}
					if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();

					for(int j=0;j<alBatchesToBeReleased.size();j++)
					{
						HashMap hmBatchData = (HashMap)alBatchesToBeReleased.get(j);  	
						stCurrentItemCodeInCaseOfError=(String)hmBatchData.get("item_code");

						hmReturn = blockReleaseBatch(connection, hmBatchData,hmSQL, 'R');
						throwExceptionWhenFailed(hmReturn);
					}

					alDataToDetailDelete.clear();
					alDataToDetailDelete.add(alHdrData.get(0)); // facility-id
					alDataToDetailDelete.add(alHdrData.get(1)); // doc-type-code
					alDataToDetailDelete.add(alHdrData.get(2)); // doc-no
					alDataToDetailDelete.add(doc_srl_no);

					alDataToDetailDelete.add(hmRecord.get("item_code"));

					stSQL	=	(String)hmSQL.get ("DtlExpDeleteSQL");

					hmArgData.put(DATA,alDataToDetailDelete);
					hmArgSQL.put(DELETE_SQL,stSQL);

					hmReturn	=	delete(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);

					alDataToDetailDelete.clear();
					alDataToDetailDelete.add(alHdrData.get(0));
					alDataToDetailDelete.add(alHdrData.get(1));
					alDataToDetailDelete.add(alHdrData.get(2));
					alDataToDetailDelete.add(doc_srl_no);

					stSQL	=	(String)hmSQL.get ("DtlDeleteSQL");

					hmArgData.put(DATA,alDataToDetailDelete);
					hmArgSQL.put(DELETE_SQL,stSQL);

					hmReturn	=	delete(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}
				else {
					// Call to the insertDetail method, to insert records in to st_adj_dtl
						int dummy_doc_srl_no=9999999;
							// dummy_doc_srl_no cannote be used in modify mode
					insertOrUpdateDetail(connection, i,dummy_doc_srl_no);

					/* Code to release the batch for the records with negative qty..
					*/
					// Retrive all the records...and call block release batch...

					preparedStatement = connection.prepareStatement((String)hmSQL.get("expForDelSQL"));

					preparedStatement.setString(1, (String)alHdrData.get(0)); // facility-id
					preparedStatement.setString(2, (String)alHdrData.get(1)); // doc-type-code
					preparedStatement.setString(3, (String)alHdrData.get(2)); // doc-no
					preparedStatement.setString(4, doc_srl_no);
					ArrayList alBatchesToBeReleased = new ArrayList ();
					resultSet = preparedStatement.executeQuery();	   
					while (resultSet != null && resultSet.next()) {
						/* @Name - Priya
						* @Date - 18/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - "qty_from_table", "ITEM_QTY" Integer is changed to Double.
						*/
						double qty_from_table = Double.parseDouble(resultSet.getString("ITEM_QTY"));
						if(qty_from_table < 0) {
							HashMap hmBatchRecord = new HashMap();
							hmBatchRecord.put("store_code", resultSet.getString("STORE_CODE"));
							hmBatchRecord.put("item_code", resultSet.getString("ITEM_CODE"));
							hmBatchRecord.put("batch_id", resultSet.getString("BATCH_ID").trim()); //trim() added for KAUH-SCF-0344
							hmBatchRecord.put("bin_location_code", resultSet.getString("BIN_LOCATION_CODE"));
							hmBatchRecord.put("expiry_date_or_receipt_date", resultSet.getString("EXPIRY_DATE_OR_RECEIPT_DATE"));
							hmBatchRecord.put("trn_qty", ""+(-(qty_from_table)));
							hmBatchRecord.put("login_by_id", alCommonData.get(0));
							hmBatchRecord.put("login_at_ws_no", alCommonData.get(1));
							hmBatchRecord.put("login_facility_id", alCommonData.get(2));
							alBatchesToBeReleased.add(hmBatchRecord);
						}
					}

// problem here ....to batch available to release

					for(int j=0;j<alBatchesToBeReleased.size();j++) {
						HashMap hmBatchData = (HashMap)alBatchesToBeReleased.get(j);  	
						try {
							hmReturn = blockReleaseBatch(connection, hmBatchData,hmSQL, 'R');
						}
						catch (Exception ex) {
							ex.printStackTrace();
						}
						throwExceptionWhenFailed(hmReturn);
					}

			//added this if loop on 8/9/2004		
					if(((String)hmRecord.get("mode")).equals("2")){
					alDataToDetailDelete.clear();
					alDataToDetailDelete.add(alHdrData.get(0)); // facility-id
					alDataToDetailDelete.add(alHdrData.get(1)); // doc-type-code
					alDataToDetailDelete.add(alHdrData.get(2)); // doc-no
					alDataToDetailDelete.add(doc_srl_no);
					alDataToDetailDelete.add(hmRecord.get("item_code"));
				
					stSQL	=	(String)hmSQL.get ("DtlExpDeleteSQL");
                	hmArgData.put(DATA,alDataToDetailDelete);
					hmArgSQL.put(DELETE_SQL,stSQL);
					hmReturn	=	delete(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
					}
					

					for (int p=0; p<alExpData.size();p++ ) {
						HashMap hmExpRecord	=	(HashMap) alExpData.get(p);

						/* As all the batch details are added together, the following check will  consider only the batches related to this particular item.	*/
						// save the item codein case of error
												
						if (!doc_srl_no.equals(hmExpRecord.get("doc_srl_no"))) {
							continue;
						}
						//Call to the insertDetailExp method, to insert records in to st_adj_dtl_exp
							 dummy_doc_srl_no=9999999;
							// dummy_doc_srl_no cannote be used in modify mode
						   insertDetailExp(connection, i, p,dummy_doc_srl_no);							
						}
				}
			}

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
			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmReturn.put("flag",stCurrentItemCodeInCaseOfError);
			}
		}
		finally{
			try{
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
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

	public HashMap delete(HashMap hmDataValues, HashMap hmSQLValues) {
		Connection	connection	=	null;
		HashMap hmReturn = new HashMap();
		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;
		hmReturn	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList   alHdrData	=	new ArrayList();
		ArrayList   alCommonData=	new ArrayList(); 	
		mode = "DELETE";

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData	=	(ArrayList)	hmData.get("HdrInsertData");
			alDtlData	=	(ArrayList)	hmData.get("DtlInsertData");
			alExpData	=	(ArrayList)	hmData.get("ExpInsertData");
			alCommonData=	(ArrayList)	hmData.get("CommonData");

			HashMap hmRecord = new HashMap();
			ArrayList alDataToDetailDelete = new ArrayList ();

			for (int i=0; i<alDtlData.size();i++ ) {
				//Call to the insertDetail method, to insert records in to st_adj_dtl.
				hmRecord	=	(HashMap) alDtlData.get(i);
				String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");

				for (int j=0; j<alExpData.size();j++ ) {

					HashMap hmExpRecord	=	(HashMap) alExpData.get(j);

					/* As all the batch details are added together, the following check will
					consider only the batches related to this particular item.
					*/

					if (!doc_srl_no.equals(hmExpRecord.get("doc_srl_no"))) {
						continue;
					}

					// Logic to release the batches 

					HashMap hmBatchReleaseData = new HashMap();
					/* @Name - Priya
						* @Date - 18/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - "release_qty", "item_qty" Integer is changed to Double.
						*/
					double release_qty = Double.parseDouble((String)hmExpRecord.get("item_qty")); 

					if(release_qty < 0) {

						hmBatchReleaseData.put("store_code", alHdrData.get(5));
						hmBatchReleaseData.put("item_code", hmRecord.get("item_code"));
						hmBatchReleaseData.put("batch_id", ((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
						hmBatchReleaseData.put("bin_location_code", hmExpRecord.get("bin_location_code"));
						hmBatchReleaseData.put("expiry_date_or_receipt_date", hmExpRecord.get("expiry_date_or_receipt_date")); 
						hmBatchReleaseData.put("trn_qty", ""+(-(release_qty)));
						hmBatchReleaseData.put("login_by_id", alCommonData.get(0));
						hmBatchReleaseData.put("login_at_ws_no", alCommonData.get(1));
						hmBatchReleaseData.put("login_facility_id", alCommonData.get(2));

						hmReturn = blockReleaseBatch(connection, hmBatchReleaseData, hmSQLValues, 'R');
					}

					try {
						alDataToDetailDelete.clear();
						alDataToDetailDelete.add(alHdrData.get(0)); // facility-id
						alDataToDetailDelete.add(alHdrData.get(1)); // doc-type-code
						alDataToDetailDelete.add(alHdrData.get(2)); // doc-no
						alDataToDetailDelete.add(doc_srl_no);
						alDataToDetailDelete.add(hmRecord.get("item_code"));
						stSQL	=	(String)hmSQL.get ("DtlExpDeleteSQL");
						hmArgData.put(DATA,alDataToDetailDelete);
						hmArgSQL.put(DELETE_SQL,stSQL);
						hmReturn	=	delete(connection, hmArgData, hmArgSQL);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				alDataToDetailDelete.clear();
				alDataToDetailDelete.add(alHdrData.get(0));
				alDataToDetailDelete.add(alHdrData.get(1));
				alDataToDetailDelete.add(alHdrData.get(2));
				alDataToDetailDelete.add(doc_srl_no);

				stSQL	=	(String)hmSQL.get ("DtlDeleteSQL");

				hmArgData.put(DATA,alDataToDetailDelete);
				hmArgSQL.put(DELETE_SQL,stSQL);

				hmReturn	=	delete(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}

			// To delete the row from the header table.

			ArrayList alDataForHeader = new ArrayList();

			alDataForHeader.add(alHdrData.get(0)); // facility_id
			alDataForHeader.add(alHdrData.get(1)); // doc-type-code
			alDataForHeader.add(alHdrData.get(2)); // doc-no

			stSQL	=	(String)hmSQL.get ("HdrDeleteSQL");

			hmArgData.put(DATA,alDataForHeader);
			hmArgSQL.put(DELETE_SQL,stSQL);

			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
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
	}

	/**
	* Method to update the header details.
	*/

	public void insertOrUpdateHeader(Connection connection) throws Exception {

		HashMap		hmArgData		=	new HashMap();
		HashMap		hmArgSQL		=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	alHdrData		=	new ArrayList();
		ArrayList   alDataForHeader	=   new ArrayList();
		String		stSQL			=	null;
		//int			hdr_count		=	0;

		alHdrData					=	(ArrayList)	hmData.get("HdrInsertData");
		alCommonData				=	(ArrayList)	hmData.get("CommonData");
		
		if(mode.equals("INSERT")) {
			// It is an insert in the create mode.
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
             String disposable_yn =  checkForNull((String)alHdrData.get(13)); 
			alHdrData.remove(13);  
			//ends

			alHdrData.add(alCommonData.get(0));
			alHdrData.add(alCommonData.get(1));
			alHdrData.add(alCommonData.get(2));
			alHdrData.add(alCommonData.get(0));
			alHdrData.add(alCommonData.get(1));
			alHdrData.add(alCommonData.get(2));
			alHdrData.add(disposable_yn);//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013   

			stSQL	=	(String)	hmSQL.get ("HdrInsertSQL");

			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,stSQL);

			
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {
			// It is an update in the modify mode.
			alDataForHeader.clear();
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
			//String disposable_yn =  checkForNull((String)alHdrData.get(12)); 
			//alHdrData.remove(12);  

			alDataForHeader.add(alHdrData.get(3)); // doc-date
			alDataForHeader.add(alHdrData.get(4)); // doc-ref
			alDataForHeader.add(alHdrData.get(9)); // trn_type
			alDataForHeader.add(alHdrData.get(7)); // finalized_yn

			alDataForHeader.add(alCommonData.get(0)); // modified-by-id
			alDataForHeader.add(alCommonData.get(1)); // modified-at-ws-no
			alDataForHeader.add(alCommonData.get(2)); // modified-facility-id
			//alDataForHeader.add(disposable_yn);//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 

			alDataForHeader.add(alHdrData.get(0)); // facility_id
			alDataForHeader.add(alHdrData.get(1)); // doc-type-code
			alDataForHeader.add(alHdrData.get(2)); // doc-no

			stSQL	=	(String)	hmSQL.get ("HeaderUpdateSQL");
 
			hmArgData.put(DATA,alDataForHeader);
			hmArgSQL.put(UPDATE_SQL,stSQL);

			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
	}

	/**
	* Method to insert the item details. For one header there could be more than one
	* item details.
	* @param int, the index of the corresponding item detail.
	*/

	public void insertOrUpdateDetail(Connection connection, int i,int temp_doc_srl_no) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		//ArrayList	alDtlRecords=	new ArrayList();
	//	ArrayList	alExpData	=	new ArrayList();
		//ArrayList	alExpRecords=	new ArrayList();

		String		stSQL		=	null;

		alDtlData		=	(ArrayList)	hmData.get("DtlInsertData");
//		alExpData		=	(ArrayList)	hmData.get("ExpInsertData");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");
		alCommonData	=	(ArrayList)	hmData.get("CommonData");

		ArrayList	alDtlRecord	=	new ArrayList();
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);
		/* @Name - Priya
		* @Date - 20/05/2010
		* @Inc# - 
		* @Desc - no need to round up item_unit_cost & item_cost_value here as it has been rounded up already in the jsp
		*/
		/*hmRecord.put("item_unit_cost",setNumber((String)hmRecord.get("item_unit_cost"),6));
		hmRecord.put("item_cost_value",setNumber((String)hmRecord.get("item_cost_value"),3));
		*/
		/********* Priya Comment Ends *********/

	//	String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");
		finalized_yn = (String)alHdrData.get(7);
		String modeLine = "";
// added on 08/09/2004		
		modeLine = (String)hmRecord.get("mode");
		if(modeLine.equals("1")){
			alDtlRecord.add(alHdrData.get(0));
			alDtlRecord.add(alHdrData.get(1));
			alDtlRecord.add(alHdrData.get(2));
			if(temp_doc_srl_no!=9999999){
			alDtlRecord.add(""+temp_doc_srl_no); 
			}else{
			alDtlRecord.add((String)hmRecord.get("doc_srl_no")); //doc_srl_no	
			}
			alDtlRecord.add(hmRecord.get("item_code"));
			alDtlRecord.add(hmRecord.get("adj_item_qty"));
			alDtlRecord.add(hmRecord.get("item_unit_cost"));
			alDtlRecord.add(hmRecord.get("item_cost_value"));
			alDtlRecord.add(hmRecord.get("remarks_code"));

			alDtlRecord.add(alCommonData.get(0));
			alDtlRecord.add(alCommonData.get(1));
			alDtlRecord.add(alCommonData.get(2));
			alDtlRecord.add(alCommonData.get(0));
			alDtlRecord.add(alCommonData.get(1));
			alDtlRecord.add(alCommonData.get(2));
			alDtlRecord.add(hmRecord.get("adjustment_type"));

			stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			hmArgData.put(DATA,alDtlRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);

			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {
			alDtlRecord.add(hmRecord.get("adj_item_qty"));
			alDtlRecord.add(hmRecord.get("item_unit_cost"));
			alDtlRecord.add(hmRecord.get("item_cost_value"));
			alDtlRecord.add(hmRecord.get("remarks_code"));

			alDtlRecord.add(alCommonData.get(0)); // modified_by_id
			alDtlRecord.add(alCommonData.get(1)); // modified_at_ws_no
			alDtlRecord.add(alCommonData.get(2)); // modified_facility_id

			alDtlRecord.add(alHdrData.get(0)); // facility_id
			alDtlRecord.add(alHdrData.get(1)); // doc_type_code
			alDtlRecord.add(alHdrData.get(2)); // doc_no
			alDtlRecord.add(hmRecord.get("doc_srl_no"));
			alDtlRecord.add(hmRecord.get("item_code"));

			stSQL				=	(String)hmSQL.get ("DtlUpdateSQL");
			hmArgData.put(DATA,alDtlRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
// Problem  here 
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}

		// calculate and update unit_cost

		if(finalized_yn.equals("Y")) {

			item_code	= (String)hmRecord.get("item_code");
			store_code	= (String)alHdrData.get(5);
			trn_type	= (String)alHdrData.get(9);
			trn_qty		= (String)hmRecord.get("adj_item_qty");
			trn_cost	= (String)hmRecord.get("item_unit_cost");
			trn_value	= (String)hmRecord.get("item_cost_value");

			ArrayList alData		= new ArrayList ();
			alData.add(item_code);			
			alData.add(store_code);

			HashMap hmResult		= fetchRecord(connection, (String)hmSQL.get ("GetStockItemYNFlag"), alData);
			String stock_item_yn	= (String)hmResult.get("STOCK_ITEM_YN"); 

			HashMap hmParameters = new HashMap();
			hmParameters.put("item_code",item_code);
			hmParameters.put("store_code",store_code);
			hmParameters.put("trn_type",trn_type);
			hmParameters.put("trn_qty",trn_qty);
			hmParameters.put("trn_unit_cost",trn_cost);
			hmParameters.put("trn_value",trn_value);
			hmParameters.put("mm_trn_qty",(String)hmRecord.get("mm_trn_qty"));
			hmParameters.put("language_id",(String)hmRecord.get("language_id"));

			hmParameters.put("from_stk_item_yn",stock_item_yn);


			hmParameters.put("login_by_id",alCommonData.get(0));
			hmParameters.put("login_at_ws_no",alCommonData.get(1));
			hmParameters.put("login_facility_id",alCommonData.get(2));
			
			if(modeLine.equals("2")){
			hmParameters.put("mode","MODE_MODIFY");
			}

			calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);


			insertItemMoveSummaryForADJ (connection, i);
		}
	}

	/**
	* Method to insert data in to the batch details. For one item details there could be
	* more than one batches.
	* @param int, the item detail index
	* @param int, the batch index
	*/

	public void insertDetailExp(Connection connection, int i, int p,int temp_doc_srl_no) throws Exception {

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList	alDispo_upd	=	new ArrayList();
		String		stSQL		=	null;

		alDtlData		=	(ArrayList)	hmData.get("DtlInsertData");
		alExpData		=	(ArrayList)	hmData.get("ExpInsertData");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");
		alCommonData	=	(ArrayList)	hmData.get("CommonData");

		HashMap hmRecord	=	(HashMap) alDtlData.get(i);
		String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");

		ArrayList	alExpRecord	=	new ArrayList();
		HashMap hmExpRecord	=	(HashMap) alExpData.get(p);

		alExpRecord.add(alHdrData.get(0));
		alExpRecord.add(alHdrData.get(1));
		alExpRecord.add(alHdrData.get(2));
		if(temp_doc_srl_no==9999999){
		alExpRecord.add((String)hmRecord.get("doc_srl_no"));//doc_srl_no
		}else{
		alExpRecord.add(""+temp_doc_srl_no);//doc_srl_no
		}
		alExpRecord.add(alHdrData.get(5));//store_code

		alExpRecord.add(hmRecord.get("item_code"));//refering to dtl record
		alExpRecord.add(((String)hmExpRecord.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
		alExpRecord.add(hmExpRecord.get("bin_location_code"));
		alExpRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
		alExpRecord.add(hmExpRecord.get("trade_id"));
		alExpRecord.add(hmExpRecord.get("item_qty"));
		alExpRecord.add(alCommonData.get(0));
		alExpRecord.add(alCommonData.get(1));
		alExpRecord.add(alCommonData.get(2));
		alExpRecord.add(alCommonData.get(0));
		alExpRecord.add(alCommonData.get(1));
		alExpRecord.add(alCommonData.get(2));
		alExpRecord.add(checkForNull(hmExpRecord.get("barcode_id")));

		stSQL				=	(String)	hmSQL.get ("ExpInsertSQL");
		hmArgData.put(DATA,alExpRecord);
		hmArgSQL.put(INSERT_SQL,stSQL);

		hmReturn	=	insert(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

		batch_id					=	(String)hmExpRecord.get("batch_id");
		expiry_date_or_receipt_date	=	(String)hmExpRecord.get("expiry_date_or_receipt_date");
		trade_id					=	(String)hmExpRecord.get("trade_id");
		bin_location_code			=	(String)hmExpRecord.get("bin_location_code");
		trn_qty						=	(String)hmExpRecord.get("item_qty");
		barcode_id					=	checkForNull((String)hmExpRecord.get("barcode_id"));
		// This is hardcoded as 'y' for time being.
		suspended_batch_allowed_yn	= "Y";
		if(finalized_yn.equals("N")) {
			/* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - "i_trn_qty" Integer is changed to Double.
			*/
			double i_trn_qty = Double.parseDouble(trn_qty);
			if(i_trn_qty < 0) {
				HashMap hmParamForBlock = new HashMap();
				hmParamForBlock.put("store_code", alHdrData.get(5));
				hmParamForBlock.put("item_code", hmRecord.get("item_code"));
				hmParamForBlock.put("batch_id", batch_id.trim()); //trim() added for KAUH-SCF-0344
				hmParamForBlock.put("bin_location_code", bin_location_code);
				hmParamForBlock.put("expiry_date_or_receipt_date", expiry_date_or_receipt_date);
				hmParamForBlock.put("trn_qty",""+(-(i_trn_qty)));

				hmParamForBlock.put("login_by_id",alCommonData.get(0));
				hmParamForBlock.put("login_at_ws_no",alCommonData.get(1));
				hmParamForBlock.put("login_facility_id",alCommonData.get(2));			

				// calling the method blockReleaseBatch() to block the quantity for negative adjustment

  				hmReturn = blockReleaseBatch(connection, hmParamForBlock, hmSQL, 'B');

				throwExceptionWhenFailed(hmReturn);
			}
		}

		if (finalized_yn.equals("Y") ) {
			HashMap hmParamaters = new HashMap();
			hmParamaters.put("item_code",item_code);
			hmParamaters.put("store_code",store_code);
			hmParamaters.put("trn_type",trn_type);
			hmParamaters.put("trn_qty",trn_qty);
			hmParamaters.put("batch_id",batch_id.trim()); //trim() added for KAUH-SCF-0344
			hmParamaters.put("expiry_date_or_receipt_date",expiry_date_or_receipt_date);
			hmParamaters.put("trade_id",trade_id);
			hmParamaters.put("from_bin_location_code",bin_location_code);
			hmParamaters.put("suspended_batch_allowed_yn",suspended_batch_allowed_yn);
			hmParamaters.put("release_batch_yn","N");								  
			hmParamaters.put("login_by_id",alCommonData.get(0));
			hmParamaters.put("login_at_ws_no",alCommonData.get(1));
			hmParamaters.put("login_facility_id",alCommonData.get(2));		
			hmParamaters.put("barcode_id",barcode_id);	
			

			updateBatchOnLine (connection, hmSQL, hmParamaters);					  
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
			//hmParamaters.put("doc_type_code",alHdrData.get(1));
			//hmParamaters.put("doc_no",alHdrData.get(2));
			//hmParamaters.put("doc_date",alHdrData.get(3));
			//updateBatchHistoryOnLine (connection, hmSQL, hmParamaters); 					  
//Added ends
			/* Insert in to st_item_trn_dtl table*/	
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
	String trn_dtl_unit_cost=Double.toString(Double.parseDouble((String)hmRecord.get("item_unit_cost"))/getConvFactTemp(connection,(String)hmRecord.get("item_code"),(String)alHdrData.get(5) ));

			String l_trn_srl_no = Integer.toString(p+1);							  
			alExpRecord.clear();
			alExpRecord.add(alHdrData.get(0));
			alExpRecord.add(store_code);
			alExpRecord.add(item_code);
			alExpRecord.add(l_trn_srl_no);
			alExpRecord.add(trn_type);
			alExpRecord.add(alHdrData.get(1)); // doc_type_code
			alExpRecord.add(alHdrData.get(2)); // doc_no
			alExpRecord.add(doc_srl_no);
			alExpRecord.add(alHdrData.get(3)); // doc_date							  
			alExpRecord.add(alHdrData.get(4)); // doc_ref
			alExpRecord.add(batch_id.trim()); //trim() added for KAUH-SCF-0344
			alExpRecord.add(expiry_date_or_receipt_date);
			alExpRecord.add(trn_qty);						// item_qty_normal
			//alExpRecord.add(hmRecord.get("item_unit_cost")); //comented by sakti against inc#50616
			alExpRecord.add(setNumber(""+trn_dtl_unit_cost,noOfDecimalsForCost)); //Added by Sakti on 20-08-2014 against Inc #50616 to pass base_unit_cost to item_trn_dtl
			alExpRecord.add(hmRecord.get("stock_uom_code")); // stk_uom_code -  has to be changed
			alExpRecord.add("Y"); // stock_item_yn									  
			alExpRecord.add(alCommonData.get(0));
			alExpRecord.add(alCommonData.get(1));
			alExpRecord.add(alCommonData.get(2));
			alExpRecord.add(alCommonData.get(0));
			alExpRecord.add(alCommonData.get(1));
			alExpRecord.add(alCommonData.get(2));									  
			alExpRecord.add(bin_location_code);
			alExpRecord.add(trade_id);												  
			stSQL	=	(String)	hmSQL.get ("ItemTrnDtlInsertSQL");				  
			hmArgData.put(DATA,alExpRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		
		//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 
		    if((alCommonData.get(3)).equals("Y")){
			    int next_batch_id = Integer.parseInt((String)alCommonData.get(4));
				 next_batch_id = next_batch_id+1;
		         alDispo_upd.add((""+next_batch_id).trim()); //trim() added for KAUH-SCF-0344
		         alDispo_upd.add(alHdrData.get(5));
		        stSQL	 =	(String)hmSQL.get ("DispoBatchUpdateSQL");
		    	hmArgData.put(DATA,alDispo_upd);
			    hmArgSQL.put(UPDATE_SQL,stSQL);
			    System.out.println("hmArgData" +hmArgData+"hmArgSQL"+hmArgSQL);
			    hmReturn	=	update(connection, hmArgData, hmArgSQL);
			    throwExceptionWhenFailed(hmReturn);
			}//ENDS
	}

	/*public void generateDocNo(Connection connection) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	languageData	=	new ArrayList();
		ArrayList	alCommonData;
		String		stSQL		=	null;

		alCommonData	=	(ArrayList)	hmData.get("CommonData");
		stSQL			=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");
		languageData		=	(ArrayList)	hmData.get("LanguageData");
		ArrayList alNextDocNoUpdateData	=	new ArrayList();
		alNextDocNoUpdateData.add(alCommonData.get(0));
		alNextDocNoUpdateData.add(alCommonData.get(1));
		alNextDocNoUpdateData.add(alCommonData.get(2));
		alNextDocNoUpdateData.add(alHdrData.get(1));
		String s = getSTMessage((String)languageData.get(0), "DOC_NO", "ST") ;
			
		String s1=s+":  "+alHdrData.get(2);
		hmArgData.put(DATA,alNextDocNoUpdateData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

		hmReturn.put("flag",s1);
	}*/


	/**
	* method to insert data in to st_item_move_summ.
	*/

	public void insertItemMoveSummaryForADJ (Connection connection, int i) throws Exception {

		System.out.println("Inside item_move summary");

		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alDtlData				=	new ArrayList();
		ArrayList alItemMoveSummRecord	=	new ArrayList();
		ArrayList alCommonData			=	(ArrayList)	hmData.get("CommonData");

		ArrayList alHdrData				=	(ArrayList)	hmData.get("HdrInsertData");

		alDtlData			=	(ArrayList)	hmData.get("DtlInsertData");
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);

		String l_doc_date	= (String)alHdrData.get(3); //doc_date

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);


		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));
		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");
		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
		alItemMoveSummRecord.add(hmRecord.get("item_code"));
		alItemMoveSummRecord.add(alHdrData.get(5)); // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);
		/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(alCommonData.get(2));      // facility_id
		nafitive_value_to_zero.add(hmRecord.get("item_code"));     // Item code
		nafitive_value_to_zero.add(alHdrData.get(5));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	
		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {

			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alHdrData.get(0));
			alItemMoveSummRecord.add(hmRecord.get("item_code"));
			alItemMoveSummRecord.add(alHdrData.get(5)); // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmRecord.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));//month_closing_value = item_cost_value
			}
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			/* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - "adj_item_qty" Integer is changed to Double.
			*/
			double adj_item_qty = Double.parseDouble(((String)(hmRecord.get("adj_item_qty"))));
			//int adj_item_qty = Integer.parseInt(((String)(hmRecord.get("mm_trn_qty"))));
			
			if(adj_item_qty >= 0) {
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
			}
			else {
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			}							   				

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			System.out.println("After Insert item_move summary"+hmReturn);
		}
		else {
			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmRecord.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));//month_closing_value = item_cost_value
			}
			

			//int adj_item_qty = Integer.parseInt(((String)(hmRecord.get("adj_item_qty"))));
			/* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - "adj_item_qty", "mm_trn_qty" Integer is changed to Double.
			*/
			double adj_item_qty = Double.parseDouble(((String)(hmRecord.get("mm_trn_qty"))));

			if(adj_item_qty >= 0) {
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
			}
			else {
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			}
			alItemMoveSummRecord.add(alCommonData.get(0));  // modified_by_id
			alItemMoveSummRecord.add(alCommonData.get(1));  // modified_at_ws_no
			alItemMoveSummRecord.add(alCommonData.get(2));  // modified_facility_id
			alItemMoveSummRecord.add(alCommonData.get(2));  // facility_id
			alItemMoveSummRecord.add(hmRecord.get("item_code"));
			alItemMoveSummRecord.add(alHdrData.get(5)); // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			System.out.println("After Update item_move summary"+hmReturn);
		}
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
			hmResult = fetchRecord(connection,"select month_closing_qty,month_closing_value  from st_item_move_summ WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ?",nafitive_value_to_zero);
		

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}
}
