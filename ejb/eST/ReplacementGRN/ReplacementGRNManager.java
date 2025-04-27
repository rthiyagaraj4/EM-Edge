/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/ 
package eST.ReplacementGRN; 

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.sql.Types;
import java.sql.CallableStatement;
//import java.util.ArrayList;
//import java.util.Properties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Properties;

/**
*
* @ejb.bean
*	name="ReplacementGRN"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReplacementGRN"
*	local-jndi-name="ReplacementGRN"
*	impl-class-name="eST.ReplacementGRN.ReplacementGRNManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ReplacementGRN.ReplacementGRNLocal"
*	remote-class="eST.ReplacementGRN.ReplacementGRNRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ReplacementGRN.ReplacementGRNLocalHome"
*	remote-class="eST.ReplacementGRN.ReplacementGRNHome"
*	generate= "local,remote"
*
*
*/

public class ReplacementGRNManager extends StEJBSessionAdapter {

	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL) //throws RemoteException 
		{
        Connection connection = null;
		Properties properties=null;

		HashMap		hmResult	=	new HashMap();

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();

		//HashMap		hmCommon	=	new HashMap();
		HashMap		hmPKData	=	new HashMap();

		ArrayList	alData		=	new ArrayList();

		try{
			properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmPKData		=	(HashMap)	hmData.get("DATA");
//			hmCommon		=	(HashMap)	hmData.get("COMMON_DATA");

			alData.add(hmPKData.get("facility_id"));	//facility_id
			alData.add(hmPKData.get("doc_type_code"));	//doc_type_code
			alData.add(hmPKData.get("doc_no"));	//doc_no

			hmArgData.put(DATA, alData);

			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_DELETE_ALL"));
			hmResult	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_GRN_DTL_DELETE_ALL"));
			hmResult	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_GRN_HDR_DELETE"));
			hmResult	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			connection.commit();
		
		if (connection!=null) {
					closeConnection(connection,properties);	
				}
		
		}
		catch (Exception exception) {
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());

			exception.printStackTrace();
		}
		finally {
			 try{
				if (connection!=null) {
					closeConnection(connection,(Properties)hmData.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}

		return hmResult;
	}
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap modify(HashMap hmData, HashMap hmSQL) //throws RemoteException
		{

        Connection connection = null;
		Properties properties=null;

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		HashMap		hmHeader	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		HashMap		hmCommon	=	new HashMap();
		HashMap		hmItemInfo	=	new HashMap();
		ArrayList doc_no	=	new ArrayList();
		ArrayList	alDetail	=	new ArrayList();
		ArrayList	alExp		=	new ArrayList();
		ArrayList	alHdrData	=	new ArrayList();
		//ArrayList	alDtlData	=	new ArrayList();
		//ArrayList	alDtlRecords=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		//ArrayList	alExpRecords=	new ArrayList();
		ArrayList	alItemTrnDtl=	new ArrayList();
		ArrayList	allanguageData=	new ArrayList();
		boolean isFinalized		=	false;
        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmCommon			=	(HashMap)	hmData.get("COMMON_DATA");
			hmHeader			=	(HashMap)	hmData.get("HDR_DATA");
			allanguageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			isFinalized			=	((String)	hmHeader.get("finalized_yn")).equals("Y");

			alHdrData.add(hmHeader.get("doc_date"));
			alHdrData.add(hmHeader.get("doc_ref"));
			alHdrData.add(hmHeader.get("store_code"));
			alHdrData.add(hmHeader.get("item_class_code"));
			alHdrData.add(hmHeader.get("finalized_yn"));
			alHdrData.add(hmHeader.get("gl_interfaced_yn"));
			alHdrData.add(hmHeader.get("trn_type"));
			alHdrData.add(hmHeader.get("supp_code"));
			alHdrData.add(hmHeader.get("currency_code"));
			alHdrData.add(hmHeader.get("entry_completed_yn"));
			alHdrData.add(hmHeader.get("receipt_date"));
			alHdrData.add(hmHeader.get("po_no"));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));

			alHdrData.add(hmHeader.get("facility_id"));
			alHdrData.add(hmHeader.get("doc_type_code"));
			alHdrData.add(hmHeader.get("doc_no"));
			doc_no.add((String)hmHeader.get("doc_no"));
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_GRN_HDR_UPDATE"));
			hmResult	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

//dtl logic
			alDetail	=	(ArrayList)	hmData.get("DTL_DATA");
			/**
				 * @Name - Priya
				 * @Date - 31/05/2010
				 * @Inc# - 
				 * @Desc -  To get no of decimals for cost
				 */
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			for (int i=0;i<alDetail.size() ;i++ ) {
				HashMap hmDetail		=	(HashMap)alDetail.get(i);

				ArrayList alDtlRecord	=	new ArrayList();
				int iMode	=	Integer.parseInt((String)hmDetail.get("mode"));
				
				double grn_qty	=	getNumber(hmDetail.get("item_qty_normal"))+getNumber(hmDetail.get("item_qty_bonus"));//+getNumber(hmDetail.get("item_qty_sample"))
				hmDetail.put("grn_qty",""+(double)grn_qty);

				double grn_unit_cost_in_pur_uom	=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/grn_qty;
				hmDetail.put("grn_unit_cost_in_pur_uom",setNumber(""+grn_unit_cost_in_pur_uom,noOfDecimalsForCost));

				double stk_qty	=	grn_qty*getNumber(hmDetail.get("pur_uom_conv"));
				hmDetail.put("stk_qty",""+(double)stk_qty);

				double grn_unit_cost_in_stk_uom	=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/stk_qty;;
				hmDetail.put("grn_unit_cost_in_stk_uom",setNumber(""+grn_unit_cost_in_stk_uom,noOfDecimalsForCost));
				
				double stk_qty_str	=stk_qty/Double.parseDouble((String)hmDetail.get("to_conv_fact"));
				hmDetail.put("stk_qty_str",""+(double)stk_qty_str);

				switch (iMode){
					case 0:{//delete
						ArrayList alDeleteRecord	=	new ArrayList();

						alDeleteRecord.add(hmHeader.get("facility_id"));	//facility_id
						alDeleteRecord.add(hmHeader.get("doc_type_code"));	//doc_type_code
						alDeleteRecord.add(hmHeader.get("doc_no"));	//doc_no
						alDeleteRecord.add(hmDetail.get("doc_srl_no"));//put doc_srl_no at last..
///
						hmArgData.put(DATA,alDeleteRecord);
						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_DELETE"));
						hmResult	=	delete(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);

						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_GRN_DTL_DELETE"));
						hmResult	=	delete(connection, hmArgData, hmArgSQL);

						break;
					}
					case 1:{//insert
						alDtlRecord.add(hmHeader.get("facility_id"));
						alDtlRecord.add(hmHeader.get("doc_type_code"));
						alDtlRecord.add(hmHeader.get("doc_no"));

						alDtlRecord.add(hmDetail.get("doc_srl_no"));
						alDtlRecord.add(hmDetail.get("item_code"));
						alDtlRecord.add(hmDetail.get("item_qty_normal"));
						alDtlRecord.add(hmDetail.get("item_qty_bonus"));
						alDtlRecord.add(hmDetail.get("item_qty_sample"));
						alDtlRecord.add(hmDetail.get("item_cost_value"));
						alDtlRecord.add("Y");
						alDtlRecord.add(hmDetail.get("label_reqd_yn"));

						alDtlRecord.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
						alDtlRecord.add(hmDetail.get("pur_uom_code"));
						alDtlRecord.add(hmDetail.get("pur_uom_conv"));
						alDtlRecord.add(hmDetail.get("replace_on_expiry_yn"));

						alDtlRecord.add(hmDetail.get("grn_unit_cost_in_stk_uom"));
						alDtlRecord.add(hmDetail.get("no_of_labels"));
						alDtlRecord.add(hmCommon.get("login_by_id"));
						alDtlRecord.add(hmCommon.get("login_at_ws_no"));
						alDtlRecord.add(hmCommon.get("login_facility_id"));
						alDtlRecord.add(hmCommon.get("login_by_id"));
						alDtlRecord.add(hmCommon.get("login_at_ws_no"));
						alDtlRecord.add(hmCommon.get("login_facility_id"));
						alDtlRecord.add(hmDetail.get("po_cost"));
						alDtlRecord.add(hmDetail.get("po_discount"));
						alDtlRecord.add(hmDetail.get("po_tax"));

						hmArgData.put(DATA,alDtlRecord);
						hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_GRN_DTL_INSERT"));
						hmResult	=	insert(connection, hmArgData, hmArgSQL);
						break;
					}
					case 2:{//update
						ArrayList alDeleteRecord	=	new ArrayList();

						alDeleteRecord.add(hmHeader.get("facility_id"));	//facility_id
						alDeleteRecord.add(hmHeader.get("doc_type_code"));	//doc_type_code
						alDeleteRecord.add(hmHeader.get("doc_no"));	//doc_no
						alDeleteRecord.add(hmDetail.get("doc_srl_no"));//put doc_srl_no at last..
///
						hmArgData.put(DATA,alDeleteRecord);
						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_DELETE"));
						hmResult	=	delete(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);

						alDtlRecord.add(hmDetail.get("item_code"));
						alDtlRecord.add(hmDetail.get("item_qty_normal"));
						alDtlRecord.add(hmDetail.get("item_qty_bonus"));
						alDtlRecord.add(hmDetail.get("item_qty_sample"));
						alDtlRecord.add(hmDetail.get("item_cost_value"));

						hmDetail.put("stock_item_yn","Y");
						alDtlRecord.add(hmDetail.get("stock_item_yn"));
						alDtlRecord.add(hmDetail.get("label_reqd_yn"));

						
						alDtlRecord.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
						alDtlRecord.add(hmDetail.get("pur_uom_code"));
						alDtlRecord.add(hmDetail.get("pur_uom_conv"));
						alDtlRecord.add(hmDetail.get("replace_on_expiry_yn"));

						alDtlRecord.add(hmDetail.get("grn_unit_cost_in_stk_uom"));
						alDtlRecord.add(hmDetail.get("no_of_labels"));

						alDtlRecord.add(hmCommon.get("login_by_id"));
						alDtlRecord.add(hmCommon.get("login_at_ws_no"));
						alDtlRecord.add(hmCommon.get("login_facility_id"));

						alDtlRecord.add(hmHeader.get("facility_id"));
						alDtlRecord.add(hmHeader.get("doc_type_code"));
						alDtlRecord.add(hmHeader.get("doc_no"));
						alDtlRecord.add(hmDetail.get("doc_srl_no"));

						hmArgData.put(DATA,alDtlRecord);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE"));

						hmResult	=	update(connection, hmArgData, hmArgSQL);
						break;
					}
				}
				throwExceptionWhenFailed(hmResult);
				if(isFinalized && iMode!=0) {// mode not equals delete

					ArrayList alPaForSupp	=	new ArrayList();
					alPaForSupp.add(hmHeader.get("supp_code"));
					alPaForSupp.add(hmCommon.get("login_by_id"));     
					alPaForSupp.add(hmCommon.get("login_at_ws_no"));  
					alPaForSupp.add(hmCommon.get("login_facility_id"));
					alPaForSupp.add(hmDetail.get("item_code"));

					hmArgData.put(DATA,alPaForSupp);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_MM_ITEM_UPDATE_FOR_GRN"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

//itm info logic
					HashMap hmTemp	=	new HashMap();
					hmTemp.put("grn_unit_cost_in_stk_uom", hmDetail.get("grn_unit_cost_in_stk_uom"));
					hmTemp.put("item_qty_normal", hmDetail.get("item_qty_normal"));
					hmTemp.put("item_qty_bonus", hmDetail.get("item_qty_bonus"));
					hmTemp.put("item_qty_sample", hmDetail.get("item_qty_sample"));
					hmTemp.put("uom_code", hmDetail.get("uom_code"));
					hmTemp.put("pur_uom_code", hmDetail.get("pur_uom_code"));
					hmTemp.put("pur_uom_conv", hmDetail.get("pur_uom_conv"));
					hmTemp.put("replace_on_expiry_yn", hmDetail.get("replace_on_expiry_yn"));
					hmItemInfo.put((String)hmDetail.get("item_code"),hmTemp);
//
//					HashMap hmSQL = new HashMap();
					hmSQL.put("ItemCostValueSelectSQL", hmSQL.get("SQL_ST_ITEM_VALUE_SELECT"));
					hmSQL.put("ItemMasterUpdateSQL", hmSQL.get("SQL_ST_ITEM_MASTER_UPDATE"));
					hmSQL.put("ItemStoreStkPosSelectSQL", hmSQL.get("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
					hmSQL.put("ItemStoreQtyUpdateSQL", hmSQL.get("SQL_ST_ITEM_STORE_QTY_UPDATE"));

					HashMap hmParameters = new HashMap();
					hmParameters.put("item_code",hmDetail.get("item_code"));
					hmParameters.put("store_code",hmHeader.get("store_code"));
					hmParameters.put("trn_type","GRN");

					hmParameters.put("trn_qty",hmDetail.get("stk_qty_str"));
					hmParameters.put("mm_trn_qty",hmDetail.get("stk_qty"));
					hmParameters.put("language_id",(String)allanguageData.get(0));
					hmParameters.put("trn_unit_cost",hmDetail.get("grn_unit_cost_in_stk_uom"));
					hmParameters.put("trn_value",""+hmDetail.get("item_cost_value"));
					hmParameters.put("from_stk_item_yn","Y");

					hmParameters.put("last_receipt_date",hmHeader.get("receipt_date"));
					hmParameters.put("doc_date",hmHeader.get("doc_date"));
 
					hmParameters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParameters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParameters.put("login_facility_id",	hmCommon.get("login_facility_id"));

					calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
					hmParameters.put("trn_qty",hmDetail.get("stk_qty"));
					hmResult	=	insertOrUpdateItemMoveSummary(connection, hmParameters, hmSQL);
					throwExceptionWhenFailed(hmResult);
				}
			}

//exp logic
			alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");

			for (int i=0;i<alExp.size() ;i++ ) {
				HashMap hmExpRecord		= (HashMap)alExp.get(i);
				ArrayList alExpRecord	= new ArrayList();

				alExpRecord.add(hmHeader.get("facility_id"));
				alExpRecord.add(hmHeader.get("doc_type_code"));
				alExpRecord.add(hmHeader.get("doc_no"));

				alExpRecord.add(hmExpRecord.get("doc_srl_no"));
				alExpRecord.add(hmExpRecord.get("store_code"));
				alExpRecord.add(hmExpRecord.get("item_code"));
				alExpRecord.add(hmExpRecord.get("batch_id"));
				alExpRecord.add(hmExpRecord.get("bin_location_code"));
				alExpRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
				alExpRecord.add(hmExpRecord.get("trade_id"));
				alExpRecord.add(hmExpRecord.get("grn_item_qty"));
				alExpRecord.add("0");

				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));
				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));
				alExpRecord.add(checkForNull(hmExpRecord.get("sale_price")));
				alExpRecord.add(checkForNull(hmExpRecord.get("barcode_id"))); 

				alExpData.add(alExpRecord);

				if (isFinalized) {
					HashMap hmParamaters = new HashMap();
//					HashMap hmSQL		 = new HashMap();

					hmSQL.put("BatchExistsCheckSQL",hmSQL.get("SQL_ST_CHECK_BATCH_EXISTS"));
					hmSQL.put("BatchControlInsertSQL",hmSQL.get("SQL_ST_BATCH_CONTROL_INSERT"));
					hmSQL.put("ItemBatchExistsCheckSQL",hmSQL.get("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
					hmSQL.put("ItemBatchInsertSQL",hmSQL.get("SQL_ST_ITEM_BATCH_INSERT"));
					hmSQL.put("ItemBatchStcPosSelectSQL",hmSQL.get("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
					hmSQL.put("ItemBatchDeleteSQL",hmSQL.get("SQL_ST_ITEM_BATCH_DELETE"));
					hmSQL.put("ItemBatchUpdateSQL",hmSQL.get("SQL_ST_ITEM_BATCH_UPDATE"));

					hmParamaters.put("item_code",hmExpRecord.get("item_code"));
					hmParamaters.put("store_code",hmExpRecord.get("store_code"));
					hmParamaters.put("trn_type","GRN");
					hmParamaters.put("batch_id",hmExpRecord.get("batch_id"));
					hmParamaters.put("expiry_date_or_receipt_date",hmExpRecord.get("expiry_date_or_receipt_date"));
					hmParamaters.put("trade_id",hmExpRecord.get("trade_id"));
					hmParamaters.put("from_bin_location_code",hmExpRecord.get("bin_location_code"));
					hmParamaters.put("suspended_batch_allowed_yn","Y");
					hmParamaters.put("release_batch_yn","N");

					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("item_code"));
//added for GRN field updation on Thursday, September 04, 2003					
					hmParamaters.put("trn_qty",""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));
					hmParamaters.put("grn_doc_type_code",hmHeader.get("doc_type_code"));
					hmParamaters.put("grn_doc_no",hmHeader.get("doc_no"));
					hmParamaters.put("grn_doc_srl_no",hmExpRecord.get("doc_srl_no"));
					hmParamaters.put("grn_unit_cost_in_stk_uom",hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));
					hmParamaters.put("replace_on_expiry_yn",hmTempItemInfo.get("replace_on_expiry_yn"));

					hmParamaters.put("last_receipt_date",hmHeader.get("receipt_date")); // doc_date

					hmParamaters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParamaters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParamaters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					hmParamaters.put("po_no",	hmHeader.get("po_no"));
					hmParamaters.put("pur_uom_code",	checkForNull(hmTempItemInfo.get("pur_uom_code")));//added by Rabbani #INC no:36532	on 03/12/2012
					hmParamaters.put("pur_uom_conv",	checkForNull(hmTempItemInfo.get("pur_uom_conv")));//added by Rabbani #INC no:36532 on 03/12/2012
					updateBatchOnLine(connection, hmSQL, hmParamaters);
///
					ArrayList ItemTrnDtlRecord	=	new ArrayList();
					ItemTrnDtlRecord.add(hmHeader.get("facility_id"));
					ItemTrnDtlRecord.add(hmExpRecord.get("store_code"));
					ItemTrnDtlRecord.add(hmExpRecord.get("item_code"));
					ItemTrnDtlRecord.add(""+(i+1));//trn_srl_no
					ItemTrnDtlRecord.add("GRN");
					ItemTrnDtlRecord.add(hmHeader.get("doc_type_code"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_no"));
					ItemTrnDtlRecord.add(hmExpRecord.get("doc_srl_no"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_date"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_ref"));
					ItemTrnDtlRecord.add(hmExpRecord.get("batch_id"));
					ItemTrnDtlRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
					ItemTrnDtlRecord.add(""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))/Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("grn_item_qty"));//hmTempItemInfo.get("item_qty_normal")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_bonus")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_sample")
					ItemTrnDtlRecord.add(hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));//item_unit_cost
					ItemTrnDtlRecord.add(hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));//item_unit_price
					ItemTrnDtlRecord.add(hmTempItemInfo.get("uom_code"));
					ItemTrnDtlRecord.add(hmHeader.get("supp_code"));
					ItemTrnDtlRecord.add("Y");
					ItemTrnDtlRecord.add(hmExpRecord.get("bin_location_code"));
					ItemTrnDtlRecord.add(hmExpRecord.get("trade_id"));
					ItemTrnDtlRecord.add(hmHeader.get("po_no"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_code"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_conv"));
 
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));

					alItemTrnDtl.add(ItemTrnDtlRecord);
///
				}
			}
			hmArgData.put(DATA,alExpData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_INSERT"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			if (isFinalized) {
				hmArgData.put(DATA,alItemTrnDtl);
				hmArgSQL.put(BATCH_SQL, hmSQL.get("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

			}
			hmResult.put("doc_no",doc_no);
			connection.commit();
		if (connection!=null) {
					closeConnection(connection,properties);	
				}
		
		
		}
		catch (Exception exception) {
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());

			exception.printStackTrace();
		}
	finally {
			 try{
				if (connection!=null) {
					closeConnection(connection,(Properties)hmData.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmResult;
	}
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap insert(HashMap hmData, HashMap hmSQL) //throws RemoteException
		{

        Connection connection = null;
		Properties properties=null;
		CallableStatement callableStatement = null;
		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		HashMap		hmHeader	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		HashMap		hmCommon	=	new HashMap();
		HashMap		hmItemInfo	=	new HashMap();

		ArrayList	alDetail	=	new ArrayList();
		ArrayList	alExp		=	new ArrayList();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	allanguageData	=	new ArrayList();
		ArrayList insert_grn_rtv_dtl	=	new ArrayList();
		//ArrayList	alDtlRecords=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		//ArrayList	alExpRecords=	new ArrayList();
		ArrayList	alItemTrnDtl=	new ArrayList();
		//boolean isDocNoAutoGenerated	=	false;
		boolean isFinalized		=	false;
	//	ArrayList<ArrayList> alTempData		= new ArrayList<ArrayList>();
		ArrayList<Integer> alItemClassCount	= new ArrayList<Integer>();
		ArrayList<String> alItemClass		= new ArrayList<String>();
		String item_class_based	= checkForNull((String)hmData.get("ITEM_CLASS_BASED"),"N");
		String   trn_type		=	"GRN";
		int      sizeOfTrn		=	1;
		int      trnRecords		=	1;
		ArrayList doc_no = new ArrayList();
		ArrayList item_code_list = new ArrayList();
		if(hmData.containsKey("ItemClassCount")){
			alItemClassCount=	(ArrayList) hmData.get("ItemClassCount");
			alItemClass=	(ArrayList) hmData.get("ItemClass");
		}

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmCommon			=	(HashMap)	hmData.get("COMMON_DATA");
			hmHeader			=	(HashMap)	hmData.get("HDR_DATA");
			allanguageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			isFinalized			=	((String)	hmHeader.get("finalized_yn")).equals("Y");
			ArrayList alDtlData1	=	(ArrayList)	hmData.get("DTL_DATA");
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
			alDetail	=	(ArrayList)	hmData.get("DTL_DATA");
			for(int j=0,k=0;j<sizeOfTrn;j++){
			alHdrData	=	new ArrayList();
			//HashMap hmRecord	=	fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"), (String)hmHeader.get("doc_type_code"));
			//isDocNoAutoGenerated=	hmRecord.get("DOC_NUM_GEN_FLAG").toString().equals("Y");

			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
				hmHeader.put("doc_no", (String)fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), (String)hmHeader.get("doc_type_code")).get("NEXT_DOC_NO"));
			}
			doc_no.add((String)hmHeader.get("doc_no"));
			alHdrData.add(hmHeader.get("facility_id"));
			alHdrData.add(hmHeader.get("doc_type_code"));
			alHdrData.add(hmHeader.get("doc_no"));
			alHdrData.add(hmHeader.get("doc_date"));
			alHdrData.add(hmHeader.get("doc_ref"));
			alHdrData.add(hmHeader.get("store_code"));
			if(item_class_based.equals("Y")){
				alHdrData.add(alItemClass.get(j));
			}else{
				alHdrData.add(hmHeader.get("item_class_code"));
			}
			alHdrData.add(hmHeader.get("finalized_yn"));
			alHdrData.add(hmHeader.get("gl_interfaced_yn"));
			alHdrData.add(hmHeader.get("trn_type"));
			alHdrData.add(hmHeader.get("supp_code"));
			alHdrData.add(hmHeader.get("currency_code"));
			alHdrData.add(hmHeader.get("entry_completed_yn"));
			alHdrData.add(hmHeader.get("receipt_date"));
			alHdrData.add(hmHeader.get("remarks_code"));
			alHdrData.add(hmHeader.get("po_no"));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));
			alHdrData.add("");
			//Added by Rabbani #Inc no :38443 on 08-MAR-2013
			alHdrData.add("");
			alHdrData.add("");
			alHdrData.add("");
			alHdrData.add("");
			alHdrData.add("");
            //ends
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_GRN_HDR_INSERT"));
			hmResult	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

//dtl logic
			//alDetail	=	(ArrayList)	hmData.get("DTL_DATA");
			alDtlData	=	new ArrayList();
			if(item_class_based.equals("Y")){
				trnRecords = k + alItemClassCount.get(j);
			}else{
				if(records_per_trn>alDetail.size()){
					trnRecords = alDetail.size();
				}else if((k+records_per_trn)>=alDetail.size()){
					trnRecords = alDetail.size();
				}else{
					trnRecords = k+records_per_trn;
				}
			}
			ArrayList alDtlRecord	=	new ArrayList();
			item_code_list = new ArrayList();
			//for (int i=0;i<alDetail.size() ;i++ ) {
				insert_grn_rtv_dtl=new ArrayList();
				/**
				 * @Name - Priya
				 * @Date - 31/05/2010
				 * @Inc# - 
				 * @Desc -  To get no of decimals for cost
				 */
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			for (int i=k;i<trnRecords ;i++ ) {	
				HashMap hmDetail	= (HashMap)alDetail.get(i);
				 alDtlRecord	=	new ArrayList();
					item_code_list.add((String)hmDetail.get("item_code"));
				double grn_qty	=	getNumber(hmDetail.get("item_qty_normal"))+getNumber(hmDetail.get("item_qty_bonus"));//+getNumber(hmDetail.get("item_qty_sample"))
				hmDetail.put("grn_qty",""+(double)grn_qty);

				double grn_unit_cost_in_pur_uom	=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/grn_qty;
				hmDetail.put("grn_unit_cost_in_pur_uom",setNumber(""+grn_unit_cost_in_pur_uom,noOfDecimalsForCost));

				double stk_qty	=	grn_qty*getNumber(hmDetail.get("pur_uom_conv"));
				hmDetail.put("stk_qty",""+(double)stk_qty);

				double grn_unit_cost_in_stk_uom	=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/stk_qty;;
				hmDetail.put("grn_unit_cost_in_stk_uom",setNumber(""+grn_unit_cost_in_stk_uom,noOfDecimalsForCost));

				double stk_qty_str	=stk_qty/Double.parseDouble((String)hmDetail.get("to_conv_fact"));
				hmDetail.put("stk_qty_str",""+(double)stk_qty_str);
				
				alDtlRecord.add(hmHeader.get("facility_id"));
				alDtlRecord.add(hmHeader.get("doc_type_code"));
				alDtlRecord.add(hmHeader.get("doc_no"));

				alDtlRecord.add(hmDetail.get("doc_srl_no"));
				alDtlRecord.add(hmDetail.get("item_code"));
				alDtlRecord.add(hmDetail.get("item_qty_normal"));
				alDtlRecord.add(hmDetail.get("item_qty_bonus"));
				alDtlRecord.add(hmDetail.get("item_qty_sample"));
				alDtlRecord.add(hmDetail.get("item_cost_value"));
				alDtlRecord.add("Y");
				alDtlRecord.add(hmDetail.get("label_reqd_yn"));

				alDtlRecord.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
				alDtlRecord.add(hmDetail.get("pur_uom_code"));
				alDtlRecord.add(hmDetail.get("pur_uom_conv"));
				alDtlRecord.add(hmDetail.get("replace_on_expiry_yn"));

				alDtlRecord.add(hmDetail.get("grn_unit_cost_in_stk_uom"));
				alDtlRecord.add(hmDetail.get("no_of_labels"));
				alDtlRecord.add(hmCommon.get("login_by_id"));
				alDtlRecord.add(hmCommon.get("login_at_ws_no"));
				alDtlRecord.add(hmCommon.get("login_facility_id"));
				alDtlRecord.add(hmCommon.get("login_by_id"));
				alDtlRecord.add(hmCommon.get("login_at_ws_no"));
				alDtlRecord.add(hmCommon.get("login_facility_id"));
				alDtlRecord.add(hmDetail.get("po_cost"));
				alDtlRecord.add(hmDetail.get("po_discount"));
				alDtlRecord.add(hmDetail.get("po_tax"));
				alDtlRecord.add("");//added for MO-CRF-20165 [TFS:23593]
				alDtlRecord.add("");
				alDtlRecord.add("");//END  
				alDtlRecord.add("");//added for MO-CRF-20178

				alDtlData.add(alDtlRecord);
				// logic added for inserting into ST_REPL_GRN_RTV_DTL....only arraylist is formed ..on insert statement is written in this block... include after exp insert logic..
				
				{
			
				 records 				=	(HashMap)	hmData.get("DTL_REPLACEMENTGRN_DATA");
				Set values	= records.keySet();
				Iterator it	= values.iterator();
				while(it.hasNext())
				{
					ArrayList insert_data	=	new ArrayList();
					
					String key = (String)it.next();
					if(key.equals((String)hmDetail.get("item_code")) )
					{
						insert_data = (ArrayList)records.get(key);
						for(int p=0;p<insert_data.size();p++)
						{
							HashMap grnRecords = (HashMap)insert_data.get(p);
							ArrayList data = new ArrayList();
							data.add(hmCommon.get("login_facility_id"));
							data.add(hmHeader.get("doc_type_code"));
							data.add(hmHeader.get("doc_no"));
							data.add(hmDetail.get("doc_srl_no"));
							data.add((String)grnRecords.get("item_code"));
							data.add((String)grnRecords.get("doc_type_code"));
							data.add((String)grnRecords.get("doc_no"));
							data.add((String)grnRecords.get("doc_srl_no"));		
							data.add((String)grnRecords.get("received_qty"));		
							data.add(hmCommon.get("login_by_id"));
							data.add(hmCommon.get("login_at_ws_no"));
							data.add(hmCommon.get("login_facility_id"));
							data.add(hmCommon.get("login_by_id"));
							data.add(hmCommon.get("login_at_ws_no"));
							data.add(hmCommon.get("login_facility_id"));
						
							insert_grn_rtv_dtl.add(data);
						}
					}
					}
						
					}
				


				//ended...

				if(isFinalized) {
					ArrayList alPaForSupp	=	new ArrayList();
					alPaForSupp.add(hmHeader.get("supp_code"));
					alPaForSupp.add(hmCommon.get("login_by_id"));     
					alPaForSupp.add(hmCommon.get("login_at_ws_no"));  
					alPaForSupp.add(hmCommon.get("login_facility_id"));
					alPaForSupp.add(hmDetail.get("item_code"));

					hmArgData.put(DATA,alPaForSupp);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_MM_ITEM_UPDATE_FOR_GRN"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

//itm info logic
					HashMap hmTemp	=	new HashMap();
					hmTemp.put("grn_unit_cost_in_stk_uom", hmDetail.get("grn_unit_cost_in_stk_uom"));
					hmTemp.put("item_qty_normal", hmDetail.get("item_qty_normal"));
					hmTemp.put("item_qty_bonus", hmDetail.get("item_qty_bonus"));
					hmTemp.put("item_qty_sample", hmDetail.get("item_qty_sample"));
					hmTemp.put("uom_code", hmDetail.get("uom_code"));
					hmTemp.put("pur_uom_code", hmDetail.get("pur_uom_code"));
					hmTemp.put("pur_uom_conv", hmDetail.get("pur_uom_conv"));
					hmTemp.put("replace_on_expiry_yn", hmDetail.get("replace_on_expiry_yn"));
					hmItemInfo.put((String)hmDetail.get("item_code"),hmTemp);
//
//					HashMap hmSQL = new HashMap();
					hmSQL.put("ItemCostValueSelectSQL", hmSQL.get("SQL_ST_ITEM_VALUE_SELECT"));
					hmSQL.put("ItemMasterUpdateSQL", hmSQL.get("SQL_ST_ITEM_MASTER_UPDATE"));
					hmSQL.put("ItemStoreStkPosSelectSQL", hmSQL.get("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
					hmSQL.put("ItemStoreQtyUpdateSQL", hmSQL.get("SQL_ST_ITEM_STORE_QTY_UPDATE"));

					HashMap hmParameters = new HashMap();
					hmParameters.put("item_code",hmDetail.get("item_code"));
					hmParameters.put("store_code",hmHeader.get("store_code"));
					hmParameters.put("trn_type","GRN");
					hmParameters.put("trn_qty",hmDetail.get("stk_qty_str"));
					hmParameters.put("mm_trn_qty",hmDetail.get("stk_qty"));
					hmParameters.put("language_id",(String)allanguageData.get(0));
					hmParameters.put("trn_unit_cost",hmDetail.get("grn_unit_cost_in_stk_uom"));
					hmParameters.put("trn_value",""+hmDetail.get("item_cost_value"));
					hmParameters.put("from_stk_item_yn","Y");

					hmParameters.put("last_receipt_date",hmHeader.get("receipt_date"));
					hmParameters.put("doc_date",hmHeader.get("doc_date"));
 
					hmParameters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParameters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParameters.put("login_facility_id",	hmCommon.get("login_facility_id"));

					calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
					hmParameters.put("trn_qty",hmDetail.get("stk_qty"));
					hmResult	=	insertOrUpdateItemMoveSummary(connection, hmParameters, hmSQL);
					throwExceptionWhenFailed(hmResult);
				}
			}

			hmArgData.put(DATA,alDtlData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_GRN_DTL_INSERT"));

			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			//	inserting into ST_REPL_GRN_RTV_DTL
					hmArgData.put(DATA,insert_grn_rtv_dtl);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("ST_SQL_REPLACE_GRN_RTV_INSERT"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				
					throwExceptionWhenFailed(hmResult);
			//

//exp logic
			alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");
			alExpData	=	new ArrayList();
			for (int g=0;g<item_code_list.size() ;g++ ){
			for (int i=0;i<alExp.size() ;i++ ) {

				HashMap hmExpRecord		= (HashMap)alExp.get(i);
				if(!((String)item_code_list.get(g)).equals((String)hmExpRecord.get("item_code"))) {
					continue;
			}
		
				ArrayList alExpRecord	= new ArrayList();

				alExpRecord.add(hmHeader.get("facility_id"));
				alExpRecord.add(hmHeader.get("doc_type_code"));
				alExpRecord.add(hmHeader.get("doc_no"));

				alExpRecord.add(hmExpRecord.get("doc_srl_no"));
				alExpRecord.add(hmExpRecord.get("store_code"));
				alExpRecord.add(hmExpRecord.get("item_code"));
				alExpRecord.add(hmExpRecord.get("batch_id"));
				alExpRecord.add(hmExpRecord.get("bin_location_code"));
				alExpRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
				alExpRecord.add(hmExpRecord.get("trade_id"));
				alExpRecord.add(hmExpRecord.get("grn_item_qty"));
				alExpRecord.add("0");

				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));
				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));
				alExpRecord.add(checkForNull(hmExpRecord.get("sale_price")));
				alExpRecord.add(checkForNull(hmExpRecord.get("barcode_id")));
				alExpRecord.add("");  //MO-CRF-20165  [TFS:23593]
				alExpRecord.add("");  //MO-CRF-20171  
				alExpData.add(alExpRecord);

				if (isFinalized) {
	//Calling Billing Procedure to update the sale price in billing tables.8/11/2008
					if(!(((String)hmExpRecord.get("sale_price")).equals(""))){
						//CallableStatement callableStatement = null;
						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?) }");Modified for AMS-SCF-0277.1 
						callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?,?) }");
						callableStatement.setString(1, (String)hmExpRecord.get("item_code"));
						callableStatement.setString(2, (String)hmExpRecord.get("trade_id"));
						callableStatement.setString(3, (String)hmExpRecord.get("batch_id"));
						callableStatement.setString(4, (String)hmExpRecord.get("sale_price"));
						callableStatement.setString(5, (String)hmCommon.get("login_by_id"));
						callableStatement.setString(6, (String)hmCommon.get("login_at_ws_no"));
						callableStatement.registerOutParameter(7, Types.VARCHAR);//Error Code
						callableStatement.registerOutParameter(8, Types.VARCHAR);//sys message id
						callableStatement.registerOutParameter(9, Types.VARCHAR);//error text
						callableStatement.setString(10, "-1");//Added for AMS-SCF-0277.1 
						System.out.println("login_facility_id-----------------------939"+(String)hmCommon.get("login_facility_id"));
						callableStatement.setString(11, (String)hmCommon.get("login_facility_id"));//Added for AMS-SCF-0277.1 
						callableStatement.execute();
						/** @ to handle the "UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated " comitted
						if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));**/

						/** @@	To solve the "UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated "  exception  **/
						if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null && !callableStatement.getString(9).equals("UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated") &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));
					}
					HashMap hmParamaters = new HashMap();
//					HashMap hmSQL		 = new HashMap();

					hmSQL.put("BatchExistsCheckSQL",hmSQL.get("SQL_ST_CHECK_BATCH_EXISTS"));
					hmSQL.put("BatchControlInsertSQL",hmSQL.get("SQL_ST_BATCH_CONTROL_INSERT"));
					hmSQL.put("ItemBatchExistsCheckSQL",hmSQL.get("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
					hmSQL.put("ItemBatchInsertSQL",hmSQL.get("SQL_ST_ITEM_BATCH_INSERT"));
					hmSQL.put("ItemBatchStcPosSelectSQL",hmSQL.get("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
					hmSQL.put("ItemBatchDeleteSQL",hmSQL.get("SQL_ST_ITEM_BATCH_DELETE"));
					hmSQL.put("ItemBatchUpdateSQL",hmSQL.get("SQL_ST_ITEM_BATCH_UPDATE"));

					hmParamaters.put("item_code",hmExpRecord.get("item_code"));
					hmParamaters.put("store_code",hmExpRecord.get("store_code"));
					hmParamaters.put("trn_type","GRN");
					hmParamaters.put("batch_id",hmExpRecord.get("batch_id"));
					hmParamaters.put("expiry_date_or_receipt_date",hmExpRecord.get("expiry_date_or_receipt_date"));
					hmParamaters.put("trade_id",hmExpRecord.get("trade_id"));
					hmParamaters.put("from_bin_location_code",hmExpRecord.get("bin_location_code"));
					hmParamaters.put("suspended_batch_allowed_yn","Y");
					hmParamaters.put("release_batch_yn","N");

					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("item_code"));
//added for GRN field updation on Thursday, September 04, 2003					
					hmParamaters.put("trn_qty",""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("grn_item_qty"));
					hmParamaters.put("grn_doc_type_code",hmHeader.get("doc_type_code"));
					hmParamaters.put("grn_doc_no",hmHeader.get("doc_no"));
					hmParamaters.put("grn_doc_srl_no",hmExpRecord.get("doc_srl_no"));
					hmParamaters.put("grn_unit_cost_in_stk_uom",hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));
					hmParamaters.put("replace_on_expiry_yn",hmTempItemInfo.get("replace_on_expiry_yn"));

					hmParamaters.put("last_receipt_date",hmHeader.get("receipt_date")); // doc_date
					hmParamaters.put("po_no",hmHeader.get("po_no")); // doc_date

					hmParamaters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParamaters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParamaters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					hmParamaters.put("pur_uom_code",	checkForNull(hmTempItemInfo.get("pur_uom_code")));//added by Rabbani #INC no:36532	on 03/12/2012
					hmParamaters.put("pur_uom_conv",	checkForNull(hmTempItemInfo.get("pur_uom_conv")));//added by Rabbani #INC no:36532 on 03/12/2012
					
					updateBatchOnLine(connection, hmSQL, hmParamaters);
///
					ArrayList ItemTrnDtlRecord	=	new ArrayList();
					ItemTrnDtlRecord.add(hmHeader.get("facility_id"));
					ItemTrnDtlRecord.add(hmExpRecord.get("store_code"));
					ItemTrnDtlRecord.add(hmExpRecord.get("item_code"));
					ItemTrnDtlRecord.add(""+(i+1));//trn_srl_no
					ItemTrnDtlRecord.add("GRN");
					ItemTrnDtlRecord.add(hmHeader.get("doc_type_code"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_no"));
					ItemTrnDtlRecord.add(hmExpRecord.get("doc_srl_no"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_date"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_ref"));
					ItemTrnDtlRecord.add(hmExpRecord.get("batch_id"));
					ItemTrnDtlRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
					ItemTrnDtlRecord.add(""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("grn_item_qty"));//hmTempItemInfo.get("item_qty_normal")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_bonus")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_sample")
					ItemTrnDtlRecord.add(hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));//item_unit_cost
					ItemTrnDtlRecord.add(hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));//item_unit_price
					ItemTrnDtlRecord.add(hmTempItemInfo.get("uom_code"));
					ItemTrnDtlRecord.add(hmHeader.get("supp_code"));
					ItemTrnDtlRecord.add("Y");
					ItemTrnDtlRecord.add(hmExpRecord.get("bin_location_code"));
					ItemTrnDtlRecord.add(hmExpRecord.get("trade_id"));
					ItemTrnDtlRecord.add(hmHeader.get("po_no"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_code"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_conv"));
 
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));

					alItemTrnDtl.add(ItemTrnDtlRecord);
///
				}
			}
			}
			hmArgData.put(DATA,alExpData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_INSERT"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

				//code added for Replacement GRN function to update ST_RTV_DTL..
			{
				ArrayList update_final_data	=	new ArrayList();
				 records 	=	(HashMap)	hmData.get("DTL_REPLACEMENTGRN_DATA");
				Set values	= records.keySet();
				Iterator it	= values.iterator();
				while(it.hasNext())
				{
					ArrayList update_data	=	new ArrayList();
					String key = (String)it.next();
					update_data = (ArrayList)records.get(key);
					for(int i=0;i<update_data.size();i++)
					{
						HashMap grnRecords = (HashMap)update_data.get(i);
						ArrayList data = new ArrayList();
						data.add((String)grnRecords.get("pend_repl_qty"));
						data.add((String)grnRecords.get("close_yn"));
						data.add((String)hmCommon.get("login_by_id"));
						data.add((String)hmCommon.get("login_at_ws_no"));
						data.add((String)hmCommon.get("login_facility_id"));
						data.add((String)grnRecords.get("item_code"));
						data.add((String)grnRecords.get("doc_type_code"));
						data.add((String)grnRecords.get("doc_no"));
						data.add((String)grnRecords.get("doc_srl_no"));						
						data.add(hmCommon.get("login_facility_id"));
						update_final_data.add(data);
					}
				}
						hmArgData.put(DATA,update_final_data);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("ST_SQL_REPLACE_GRN_UPDATE_RTV"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				
					throwExceptionWhenFailed(hmResult);
			}


			if (isFinalized) {
				hmArgData.put(DATA,alItemTrnDtl);
				hmArgSQL.put(BATCH_SQL, hmSQL.get("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
			}
			alItemTrnDtl = new ArrayList();
			String locale=(String)allanguageData.get(0);

			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
					String s  = "";
					String s1 = "";
			
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(hmCommon.get("login_by_id"));
				alParameters.add(hmCommon.get("login_at_ws_no"));
				alParameters.add(hmCommon.get("login_facility_id"));
				alParameters.add(hmHeader.get("doc_type_code"));
				if(doc_no.size()>1){
						java.util.Locale loc = new java.util.Locale(locale);
						java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						s = getSTMessage(locale, "DOC_NOS_GEN_FROM", "ST") ;
					
						s1=s+"  "+doc_no.get(0)+" "+common_labels.getString("Common.to.label")+" "+doc_no.get(doc_no.size()-1);
					}else{
						s = getSTMessage(locale, "DOC_NO", "ST") ;
						s1=s+":  "+doc_no.get(0);
					}
				hmArgData.put(DATA,alParameters);
				hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				hmResult.put("flag",s1);

				throwExceptionWhenFailed(hmResult);
			}
				if(item_class_based.equals("Y")){
				k = k + alItemClassCount.get(j);
			}else{
				k=k+records_per_trn;
			}
		}
		
		hmResult.put("doc_no",doc_no);

		
				
			

			connection.commit();
		if (connection!=null) {
					closeConnection(connection,properties);	
				}
		
		
		
		}
		catch (Exception exception) {
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());

			exception.printStackTrace();
		}
		finally {
			 try{
				 closeStatement(callableStatement);
				if (connection!=null) {
					closeConnection(connection,(Properties)hmData.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}

		return hmResult;
	}

	public HashMap insertOrUpdateItemMoveSummary(Connection connection, HashMap hmColumns, HashMap hmSQL) throws Exception {

		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alParameters	=	new ArrayList();
		ArrayList alData		=	new ArrayList();

		String doc_date	= (String)hmColumns.get("doc_date"); //doc_date
		String stSQL;

		alParameters.add(doc_date);
		alParameters.add(doc_date);
		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get("SQL_ST_GET_MONTH_AND_YEAR"));

		String move_month	= (String)hmResult.get("MM");
		String move_year	= (String)hmResult.get("YYYY");

//		String	facility_id         	=	(String)hmColumns.get("facility_id");
		String	item_code           	=	(String)hmColumns.get("item_code");
		String	store_code          	=	(String)hmColumns.get("store_code");
		String	month_closing_qty   	=	(String)hmColumns.get("trn_qty");
//		String	month_closing_value 	=	(String)hmColumns.get("trn_unit_cost");

		String	grn_qty             	=	(String)hmColumns.get("trn_qty");

		String	trn_unit_cost 			=	(String)hmColumns.get("trn_unit_cost");
		/**
		 * @Name - Priya
		 * @Date - 31/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost
		 */
		int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
		String	month_closing_value 	=	setNumber(""+(getNumber(trn_unit_cost)*getNumber(grn_qty)),noOfDecimalsForCost);
		/**
		 * @Name - Priya
		 * @Date - 10/06/2010
		 * @Inc# - 
		 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
		 */
		
		if(Double.valueOf(month_closing_qty) == 0){
			month_closing_value = "0";
		}

		String	grn_cost            	=	month_closing_value;//(String)hmColumns.get("trn_unit_cost");

		String	login_by_id 			=	(String)hmColumns.get("login_by_id");
		String	login_at_ws_no 			=	(String)hmColumns.get("login_at_ws_no");
		String	login_facility_id 		=	(String)hmColumns.get("login_facility_id");

		alParameters.clear();
		alParameters.add(login_facility_id);
		alParameters.add(item_code);
		alParameters.add(store_code);
		alParameters.add(move_year);
		alParameters.add(move_month);
/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(login_facility_id);      // facility_id
		nafitive_value_to_zero.add(item_code);     // Item code
		nafitive_value_to_zero.add(store_code);    // store_code
		nafitive_value_to_zero.add(move_month);
		nafitive_value_to_zero.add(move_year);
	
		hmResult = fetchRecord(connection,(String)hmSQL.get("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT"),alParameters);

		if(((String)hmResult.get("TOTAL")).equals("0")) {//no record found
			alData.add(login_facility_id        );
			alData.add(item_code          );
			alData.add(store_code         );
			alData.add(move_year          );
			alData.add(move_month         );
			alData.add(grn_qty            );
			alData.add(grn_cost           );
			alData.add(month_closing_qty  );
			alData.add(month_closing_value);

			alData.add(login_by_id 		  );
			alData.add(login_at_ws_no 	  );
			alData.add(login_facility_id  );
			alData.add(login_by_id 		  );
			alData.add(login_at_ws_no 	  );
			alData.add(login_facility_id  );

			stSQL	=	(String)hmSQL.get("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_GRN");

			hmArgData.put(DATA,alData);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmResult	=	insert(connection, hmArgData, hmArgSQL);
		}
		else {

			alData.add(grn_qty            );
			alData.add(grn_cost           );
			alData.add(month_closing_qty  );
			alData.add(month_closing_value);

			alData.add(login_by_id 		  );
			alData.add(login_at_ws_no 	  );
			alData.add(login_facility_id  );

			alData.add(login_facility_id  );
			alData.add(item_code          );
			alData.add(store_code         );
			alData.add(move_year          );
			alData.add(move_month         );

			stSQL = (String)hmSQL.get("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_GRN");

			hmArgData.put(DATA,alData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmResult	=	update(connection, hmArgData, hmArgSQL);
		}
		throwExceptionWhenFailed(hmResult);
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmResult	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmResult);
		return hmResult;
	}

	public double getNumber(String stNumber){
		double dNumber	=	0.0;
		try { 
			dNumber	=	Double.parseDouble(stNumber);
		}
		catch (Exception exception) {
		exception.printStackTrace();
		}
		return dNumber;		
	}

	public double getNumber(Object objNumber){
		return getNumber((String)objNumber);
	}


}
