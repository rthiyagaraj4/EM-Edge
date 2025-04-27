/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.OpeningStock;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.sql.CallableStatement; //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
import java.sql.Types;				//Added By Sakti Sankar on 30/11/2011 for INC# - 29770
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="OpeningStock"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OpeningStock"
*	local-jndi-name="OpeningStock"
*	impl-class-name="eST.OpeningStock.OpeningStockManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.OpeningStock.OpeningStockLocal"
*	remote-class="eST.OpeningStock.OpeningStockRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.OpeningStock.OpeningStockLocalHome"
*	remote-class="eST.OpeningStock.OpeningStockHome"
*	generate= "local,remote"
*
*
*/


public class OpeningStockManager extends StEJBSessionAdapter {

	HashMap hmData;
	HashMap hmSQL;
	HashMap	hmReturn;
	Properties	properties	=	null;

	/* Variables which are needed to call the routines to update the online-store and
	other tables.
	*/

	String finalized_yn="";

	String item_code					= "";
	String store_code					= "";
	String trn_type						= "OBS";
	String trn_qty						= "";
	String trn_cost						= "";
	String trn_value					= "";

	String trade_id						= "";
	String bin_location_code			= "";
	String expiry_date_or_receipt_date	= "";
	String suspended_batch_allowed_yn	= "";
	String batch_id						= "";
	String sale_price					= ""; //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
	String barcode_id					= ""; //Added By Sakti Sankar on 30/11/2011 for INC# - 29770

	String		stSQL		=	null;


	/** Dummy method
	*/
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException{
		return getMessageHashMap(false);
	}

	/** Dummy method
	*/
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap delete( HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException {
		return getMessageHashMap(false);
	}

	/**
	* Method, which is responsible for inserting the data in to the related tables
	* for the adjustStock transaction. This method will in turn call the other methods
	* to do the corresponding updates.
	* @param hmDataValues, the data to be inserted
	* @param hmSQLValues, the queries used for the corresponding updates
	* @return HashMap, the result and the messages
	*/
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap insert(HashMap hmDataValues, HashMap hmSQLValues) //throws RemoteException
		{

		Connection	connection	=	null;

		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;
		int      sizeOfTrn		=	1;
		int      trnRecords		=	1;
		ArrayList doc_no = new ArrayList();
		//ArrayList item_code_list = new ArrayList();
		//ArrayList<ArrayList> alTempData		= new ArrayList<ArrayList>();
		ArrayList<Integer> alItemClassCount	= new ArrayList<Integer>();
		String item_class_based	= checkForNull((String)hmData.get("ITEM_CLASS_BASED"),"N");
		ArrayList<ArrayList> alTempData		= new ArrayList<ArrayList>();
		alTempData		=	(ArrayList) hmData.get("HdrInsertData");
		String stCurrentItemCodeInCaseOfError=null;
		//alTempData		=	(ArrayList) hmData.get("HdrInsertData");
		if(hmData.containsKey("ItemClassCount")){
			alItemClassCount=	(ArrayList) hmData.get("ItemClassCount");
		}
		hmReturn	=	new HashMap();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList alCommonData		=	(ArrayList)	hmData.get("CommonData");
		hmReturn.put(RESULT,FALSE);
		ArrayList	alHdrData	=	new ArrayList();
		String temp_doc_no="";
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);
			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			ArrayList alDtlData1	=	(ArrayList)	hmData.get("DtlInsertData");
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
			//alHdrData	=	new ArrayList();
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
			insertHeader(connection);
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
				//String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");
			stCurrentItemCodeInCaseOfError=(String)hmRecord.get("item_code");
				try{
					temp_doc_srl_no=temp_doc_srl_no+1;
				insertDetail(connection,i,temp_doc_srl_no);
				}catch(Exception exception){
					try {
						connection.rollback();
						exception.printStackTrace();
					}
					catch (Exception subException) {
						subException.printStackTrace();
					}
					hmReturn.put(RESULT,FALSE);
					hmReturn.put(MSGID,exception.toString());
					hmReturn.put(MESSAGE,"NEGATIVE_STOCK");
					hmReturn.put("flag",+i+"");
					return(hmReturn);
				}

				alExpData	=	(ArrayList)		hmData.get("ExpInsertData");
				//for (int g=0;g<item_code_list.size() ;g++ ){
				for (int p=0; p<alExpData.size();p++ ) {
					HashMap hmExpRecord	=	(HashMap) alExpData.get(p);
					
					if(!(stCurrentItemCodeInCaseOfError).equals((String)hmExpRecord.get("item_code"))) {
					continue;
					}
			

					//Call to the insertDetailExp method, to insert records in to st_adj_dtl_exp

					insertDetailExp(connection, i, p,temp_doc_srl_no);
				}
				//}
			}

			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
					String s  = "";
					String s1 = "";
			
				//Call to generate Document Number method, to  generate the next document number
				//generateDocNo(connection);
	//	alCommonData	=	(ArrayList)	hmData.get("CommonData");
		stSQL			=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");
		String locale=(String)alCommonData.get(3);
		ArrayList alNextDocNoUpdateData	=	new ArrayList();
		alNextDocNoUpdateData.add(alCommonData.get(0));
		alNextDocNoUpdateData.add(alCommonData.get(1));
		alNextDocNoUpdateData.add(alCommonData.get(2));
		alNextDocNoUpdateData.add(alHdrData.get(1));
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
	
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
	* Method to insert the header details.
	*/

	public void insertHeader(Connection connection) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	alHdrData	=	new ArrayList();
		String		stSQL		=	null;

		alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
		alCommonData		=	(ArrayList)	hmData.get("CommonData");
		stSQL				=	(String)	hmSQL.get ("HdrInsertSQL");

		alHdrData.add(alCommonData.get(0));
		alHdrData.add(alCommonData.get(1));
		alHdrData.add(alCommonData.get(2));
		alHdrData.add(alCommonData.get(0));
		alHdrData.add(alCommonData.get(1));
		alHdrData.add(alCommonData.get(2));
		alHdrData.add("N"); //added by Rabbani #inc no:29954 ,Insert into ST_ADJ_HDR Disposable_yn value as "N" to avoid Exception on 05-MAR-2013
		hmArgData.put(DATA,alHdrData);
		hmArgSQL.put(INSERT_SQL,stSQL);

		hmReturn	=	insert(connection, hmArgData, hmArgSQL);

		throwExceptionWhenFailed(hmReturn);
	}

	/**
	* Method to insert the item details. For one header there could be more than one
	* item details.
	* @param int, the index of the corresponding item detail.
	*/

	public void insertDetail(Connection connection, int i,int temp_doc_srl_no) throws Exception {


		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alDtlRecords=	new ArrayList();
//		ArrayList	alExpData	=	new ArrayList();
//		ArrayList	alExpRecords=	new ArrayList();

		String		stSQL		=	null;

		alDtlData		=	(ArrayList)	hmData.get("DtlInsertData");
//		alExpData		=	(ArrayList)	hmData.get("ExpInsertData");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");
		alCommonData	=	(ArrayList)	hmData.get("CommonData");

		ArrayList	alDtlRecord	=	new ArrayList();
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);
	//	String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");
///// added by manish on Saturday, March 20, 2004
		/**
		 * @Name - Priya
		 * @Date - 31/05/2010
		 * @Inc# - 
		 * @Desc -  As the item_unit_cost value is coming from alDtlData the below calculation is commented
		 */
		/*double dItem_cost;
		double dItem_qty;
		double d_Item_value;
		d_Item_value=Double.parseDouble((String)hmRecord.get("item_cost_value"));
		dItem_qty=Double.parseDouble((String)hmRecord.get("adj_item_qty"));
		dItem_cost=d_Item_value/dItem_qty;
		hmRecord.put("item_unit_cost",setNumber(""+dItem_cost,6)); */
		/** Comment ends *****/
///// added ends.
		//index may not be correct for finalized_yn in alHdrData
		finalized_yn = (String)alHdrData.get(7);
		alDtlRecord.add(alHdrData.get(0));
		alDtlRecord.add(alHdrData.get(1));
		alDtlRecord.add(alHdrData.get(2));
		//alDtlRecord.add(""+(i+1));         //doc_srl_no
		alDtlRecord.add(""+temp_doc_srl_no);         //doc_srl_no
		alDtlRecord.add(hmRecord.get("item_code"));
		alDtlRecord.add(hmRecord.get("adj_item_qty"));
		alDtlRecord.add(hmRecord.get("item_unit_cost"));
		alDtlRecord.add(hmRecord.get("item_cost_value"));
		alDtlRecord.add(hmRecord.get("remarks"));

		alDtlRecord.add(alCommonData.get(0));
		alDtlRecord.add(alCommonData.get(1));
		alDtlRecord.add(alCommonData.get(2));
		alDtlRecord.add(alCommonData.get(0));
		alDtlRecord.add(alCommonData.get(1));
		alDtlRecord.add(alCommonData.get(2));

		alDtlRecords.add(alDtlRecord);

		stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
		hmArgData.put(DATA,alDtlRecords);
		hmArgSQL.put(BATCH_SQL,stSQL);

		hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

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
			hmParameters.put("mm_trn_qty",(String)hmRecord.get("mm_trn_qty"));
			hmParameters.put("trn_unit_cost",trn_cost);
			hmParameters.put("trn_value",trn_value);

			hmParameters.put("from_stk_item_yn",stock_item_yn);

			hmParameters.put("login_by_id",alCommonData.get(0));
			hmParameters.put("login_at_ws_no",alCommonData.get(1));
			hmParameters.put("login_facility_id",alCommonData.get(2));


			//hmParameters.put("last_receipt_date",alHdrData.get(3)); // doc_date

		
			calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);

			insertItemMoveSummaryForOBS (connection, i);
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
		ArrayList	alExpRecords=	new ArrayList();
		String		stSQL		=	null;
		CallableStatement callableStatement = null; //Added By Sakti Sankar on 30/11/2011 for INC# - 29770 

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
		//alExpRecord.add(""+(i+1));//doc_srl_no
		alExpRecord.add(""+temp_doc_srl_no);//doc_srl_no
		alExpRecord.add(alHdrData.get(5));//store_code

		alExpRecord.add(hmRecord.get("item_code"));//refering to dtl record
		alExpRecord.add(hmExpRecord.get("batch_id"));
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
		alExpRecord.add(checkForNull((String)hmExpRecord.get("barcode_id")));
		alExpRecords.add(alExpRecord);
		stSQL				=	(String)	hmSQL.get ("ExpInsertSQL");
		hmArgData.put(DATA,alExpRecords);
		hmArgSQL.put(BATCH_SQL,stSQL);

		hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

		batch_id					=	(String)hmExpRecord.get("batch_id");
		expiry_date_or_receipt_date	=	(String)hmExpRecord.get("expiry_date_or_receipt_date");
		trade_id					=	(String)hmExpRecord.get("trade_id");
		bin_location_code			=	(String)hmExpRecord.get("bin_location_code");
		trn_qty						=	(String)hmExpRecord.get("item_qty");
		sale_price					=	(String)hmExpRecord.get("sale_price"); //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
		barcode_id					=	(String)hmExpRecord.get("barcode_id"); 
		if (sale_price == null ){
				sale_price = "";
			}

		// This is hardcoded as 'y' for time being.

		suspended_batch_allowed_yn	= "Y";
		
		if (finalized_yn.equals("Y") ) {
			//Added By Sakti Sankar on 30/11/2011 for INC# - 29770 starts
				if(!(sale_price.equals(""))){
						//CallableStatement callableStatement = null;
						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?) }");
						callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?,?) }");//Added for AMS-SCF-0277.1 
						callableStatement.setString(1, (String)hmExpRecord.get("item_code"));
						callableStatement.setString(2, (String)hmExpRecord.get("trade_id"));
						callableStatement.setString(3, (String)hmExpRecord.get("batch_id"));
						callableStatement.setString(4, sale_price);
						callableStatement.setString(5, (String)alCommonData.get(0));
						callableStatement.setString(6, (String)alCommonData.get(1));
						callableStatement.registerOutParameter(7, Types.VARCHAR);//Error Code
						callableStatement.registerOutParameter(8, Types.VARCHAR);//sys message id
						callableStatement.registerOutParameter(9, Types.VARCHAR);//error text
						callableStatement.setString(10, "-1");//Added for AMS-SCF-0277.1 
						System.err.println("login_facility_id in opening stockfor SCF-0277.1@@@==="+(String)alCommonData.get(2));
						callableStatement.setString(11,(String)alCommonData.get(2));//Added for AMS-SCF-0277.1 
						callableStatement.execute();
						
						if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null && !callableStatement.getString(9).equals("UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated") &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));
					}
					closeStatement(callableStatement);
			//Added By Sakti Sankar on 30/11/2011 for INC# - 29770 ends
			HashMap hmParamaters = new HashMap();
			hmParamaters.put("item_code",item_code);
			hmParamaters.put("store_code",store_code);
			hmParamaters.put("trn_type",trn_type);
			hmParamaters.put("trn_qty",trn_qty);
			hmParamaters.put("batch_id",batch_id);
			hmParamaters.put("expiry_date_or_receipt_date",expiry_date_or_receipt_date);
			hmParamaters.put("trade_id",trade_id);
			hmParamaters.put("from_bin_location_code",bin_location_code);
			hmParamaters.put("suspended_batch_allowed_yn",suspended_batch_allowed_yn);

			hmParamaters.put("release_batch_yn","N");
			hmParamaters.put("sale_price",checkForNull(sale_price)); //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
			hmParamaters.put("barcode_id",checkForNull(barcode_id)); 

			//hmParamaters.put("last_receipt_date",alHdrData.get(3)); // doc_date

			hmParamaters.put("login_by_id",alCommonData.get(0));
			hmParamaters.put("login_at_ws_no",alCommonData.get(1));
			hmParamaters.put("login_facility_id",alCommonData.get(2));
System.out.println("hmParamaters in 542 manager" +hmParamaters);
			updateBatchOnLine (connection, hmSQL, hmParamaters);
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
			//hmParamaters.put("doc_type_code",alHdrData.get(1));
			//hmParamaters.put("doc_no",alHdrData.get(2));
			//hmParamaters.put("doc_date",alHdrData.get(3));
			//updateBatchHistoryOnLine (connection, hmSQL, hmParamaters); 
//Added ends

			/* Insert in to st_item_trn_dtl table*/

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
			alExpRecord.add(batch_id);
			alExpRecord.add(expiry_date_or_receipt_date);
			alExpRecord.add(trn_qty);						// item_qty_normal
			
			/**
			 * @Name - Priya
			 * @Date - 31/05/2010
			 * @Inc# - 
			 * @Desc -  As the item_unit_cost value is coming from alDtlData the below calculation is commented
			 */
			/*double dItem_cost;
			double dItem_qty;
			double d_Item_value;
			d_Item_value=Double.parseDouble((String)hmRecord.get("item_cost_value"));
			dItem_qty=Double.parseDouble((String)hmRecord.get("mm_trn_qty"));
			dItem_cost=d_Item_value/dItem_qty;	
			alExpRecord.add(""+dItem_cost);*/
			/****** Comment Ends *****/
			alExpRecord.add(hmRecord.get("item_unit_cost"));
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
	}

	public void generateDocNo(Connection connection) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alCommonData;
		String		stSQL		=	null;

		alCommonData	=	(ArrayList)	hmData.get("CommonData");
		stSQL			=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
		alHdrData		=	(ArrayList)	hmData.get("HdrInsertData");

		ArrayList alNextDocNoUpdateData	=	new ArrayList();
		alNextDocNoUpdateData.add(alCommonData.get(0));
		alNextDocNoUpdateData.add(alCommonData.get(1));
		alNextDocNoUpdateData.add(alCommonData.get(2));
		alNextDocNoUpdateData.add(alHdrData.get(1));
	
		hmArgData.put(DATA,alNextDocNoUpdateData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

		hmReturn.put("flag","Doc No: "+alHdrData.get(2));
	}


	/**
	* method to insert data in to st_item_move_summ.
	*/

	public void insertItemMoveSummaryForOBS (Connection connection, int i) throws Exception {
		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alDtlData				=	new ArrayList();
		ArrayList alItemMoveSummRecord	=	new ArrayList();
		ArrayList alCommonData			=	(ArrayList)	hmData.get("CommonData");

		ArrayList alHdrData				=	(ArrayList)	hmData.get("HdrInsertData");

		alDtlData			=	(ArrayList)	hmData.get("DtlInsertData");
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);

		String l_doc_date	= (String)alHdrData.get(3); //doc_date

		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);
		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));

		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alHdrData.get(0));
		alItemMoveSummRecord.add(hmRecord.get("item_code"));
		alItemMoveSummRecord.add(alHdrData.get(5));
		alItemMoveSummRecord.add(l_move_year);
		alItemMoveSummRecord.add(l_move_month);
		/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(alHdrData.get(0));      // facility_id
		nafitive_value_to_zero.add(hmRecord.get("item_code"));     // Item code
		nafitive_value_to_zero.add(alHdrData.get(5));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	

		alItemMoveSummRecord.add("0");//hmRecord.get("adj_item_qty"));
		alItemMoveSummRecord.add("0");//hmRecord.get("item_cost_value"));
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
		
		//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
		alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
		alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));

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
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}
}
