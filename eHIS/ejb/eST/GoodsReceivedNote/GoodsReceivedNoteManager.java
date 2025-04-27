/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
package eST.GoodsReceivedNote; 

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import eXH.XHUtil;
import webbeans.eCommon.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.CallableStatement; 
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;

import eMP.DocumentConfigOption;
import eMP.DocumentConfigBean;
import java.util.HashMap;
import java.util.List; 

/**
*
* @ejb.bean
*	name="GoodsReceivedNote"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="GoodsReceivedNote"
*	local-jndi-name="GoodsReceivedNote"
*	impl-class-name="eST.GoodsReceivedNote.GoodsReceivedNoteManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.GoodsReceivedNote.GoodsReceivedNoteLocal"
*	remote-class="eST.GoodsReceivedNote.GoodsReceivedNoteRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.GoodsReceivedNote.GoodsReceivedNoteLocalHome"
*	remote-class="eST.GoodsReceivedNote.GoodsReceivedNoteHome"
*	generate= "local,remote"
*
*
*/

public class GoodsReceivedNoteManager extends StEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL)  { 
        Connection connection = null;
		Properties properties=null;
		
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();	
		HashMap		hmPKData	=	new HashMap();
		ArrayList	alData		=	new ArrayList();
		ArrayList	DOData		=	new ArrayList();

		boolean isPOApplicable		=	false;
		int count; //Added for ML-BRU-SCF-1924

		try{
			properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmPKData		=	(HashMap)	hmData.get("DATA");
			isPOApplicable  = (Boolean)hmData.get("isPOApplicable");
			count = (Integer)hmData.get("count"); //Added for ML-BRU-SCF-1924
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

			//if(isPOApplicable){
			//Modified by suresh.r on 12-05-2015 against ML-BRU-SCF-1573
			if(isPOApplicable && !((String)hmData.get("po_no")).equals("")){
				if(count > 0){ //Added for ML-BRU-SCF-1924
			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS2"));
			hmResult	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

				if(hmData.containsKey("DO_DATA")){
					DOData  =	(ArrayList)	hmData.get("DO_DATA");

					if(DOData.size()>0){
					hmArgData.put(DATA,DOData);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_UNF_GRN_DO_QTY_IN_DO_BAT1"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}				
				}


				}}//Added for ML-BRU-SCF-1924


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


	public HashMap modify(HashMap hmData, HashMap hmSQL)  { 

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
		ArrayList	allanguageData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList	alItemTrnDtl=	new ArrayList();
		boolean isFinalized		=	false;
		int rec_high_no = 0;
		ArrayList doc_no	=	new ArrayList();


		ArrayList	alPoDtl		=	new ArrayList();
		ArrayList	alPoHdr		=	new ArrayList();
		HashMap		alTemp		=	null;
		ArrayList	alPoRecord  =	null;
		ArrayList	alPoRecord1 =	null;
		ArrayList	alPoRecord2 =	null;
		ArrayList	alPoRecord3 =	null;
		ArrayList	alCount		=	null;
		ArrayList	alPoRecords =	new ArrayList();
		ArrayList	alPoRecords1 =	new ArrayList();
		ArrayList	alPoRecords2 =	new ArrayList();
		ArrayList	alPoRecords3 =	new ArrayList();
		ArrayList	alPoRecords4 =	new ArrayList();
		ArrayList	alParameters = null;
		ArrayList	blockPoRecord  =	null;
		ArrayList	blockPoRecord1 =	null;
		ArrayList	alExpForPOCheck		=	new ArrayList();
		//HashMap		hmDoHdr			 =	new HashMap();
		HashMap		hmDoDtl			 =	new HashMap();
		ArrayList	alDoRecords		 =  new ArrayList();
		ArrayList	alDoRecords1		 =  new ArrayList();
		ArrayList	alDoRecord		 =  null;
		ArrayList	alDoRecord1		 =  null;
		ArrayList	blockDoRecord  =	null;

		boolean isPOApplicable		=	false;

		double cItQty = 0.0;
		double expItQty = 0.0;

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
				/**
				 * @Name - Priya
				 * @Date - 25/05/2010
				 * @Inc# - 
				 * @Desc -  To get no of decimals for cost 
				 */
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			hmCommon			=	(HashMap)	hmData.get("COMMON_DATA");
			hmHeader			=	(HashMap)	hmData.get("HDR_DATA");
			isFinalized			=	((String)	hmHeader.get("finalized_yn")).equals("Y");
			allanguageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			String logginFacility = (String) hmCommon.get("login_facility_id"); //23925
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
			alHdrData.add(hmHeader.get("remarks_code"));
			alHdrData.add(checkForNull(hmHeader.get("po_no")));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));

			alHdrData.add(hmHeader.get("conversion_rate"));
			alHdrData.add(checkForNull(hmHeader.get("do_no")));
			alHdrData.add(checkForNull(hmHeader.get("invoice_no")));
			alHdrData.add(checkForNull(hmHeader.get("invoice_recd_by")));

			alHdrData.add(checkForNull(hmHeader.get("grn_remarks_desc")));//ADDED for MO-CRF-20165 
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

			alPoDtl  = (ArrayList)	hmData.get("PO_DETAILS");
			hmDoDtl  = (HashMap)	hmData.get("DO_DETAILS");
			isPOApplicable = (Boolean)hmData.get("isPOApplicable");

			for (int i=0;i<alDetail.size() ;i++ ) {
				HashMap hmDetail		=	(HashMap)alDetail.get(i);
				ArrayList alDtlRecord	=	new ArrayList();
				int iMode	=	Integer.parseInt((String)hmDetail.get("mode"));
				cItQty = 0.0;
				expItQty = 0.0;

				cItQty	=	Double.parseDouble((String)hmDetail.get("item_qty_normal")) + Double.parseDouble((String)hmDetail.get("item_qty_bonus"));

 
					if (cItQty==0) {
						throw new Exception ("QTY_SHOULD_BE_GR_ZERO");						
					}
					 if(isPOApplicable){
						 alExpForPOCheck		=	(ArrayList)	hmData.get("DTL_EXP_DATA");

						 if(alExpForPOCheck.size()==0){
							 throw new Exception ("UPDATE_EXP_RECORDS");	
						 }
						if(iMode!=0){
						 for(int chk=0; chk<alExpForPOCheck.size(); chk++){
						 HashMap hmExpRecord		= (HashMap)alExpForPOCheck.get(chk);
							if(((String)hmDetail.get("item_code")).equals((String)hmExpRecord.get("item_code"))){
								expItQty = expItQty + Double.parseDouble(checkForNull((String)hmExpRecord.get("grn_item_qty"),"0"));
							}
						 }
						 if(cItQty!=expItQty)
							throw new Exception ("DTL_AND_EXP_QTY_SHOULD_BE_EQUAL");
						}
					 }



				
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
						alDtlRecord.add(checkForNull(hmDetail.get("manufacturer_id"), ""));//ADDED for MO-CRF-20165   
						alDtlRecord.add(checkForNull(hmDetail.get("remarks_desc"), ""));
						alDtlRecord.add(checkForNull(hmDetail.get("catalog_code"), ""));//END 
						alDtlRecord.add(checkForNull(hmDetail.get("manufac_remarks"), ""));//MO-CRF-20178  
						
						
						hmArgData.put(DATA,alDtlRecord);
						hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_GRN_DTL_INSERT"));
						hmResult	=	insert(connection, hmArgData, hmArgSQL);
						break;
					}
					case 2:{//update
						ArrayList alDeleteRecord	=	new ArrayList();
						ArrayList alDtlPOrequestRecord	=	new ArrayList();
		
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
						alDtlRecord.add(hmDetail.get("po_cost"));
						alDtlRecord.add(hmDetail.get("po_discount"));
						alDtlRecord.add(hmDetail.get("po_tax")); 
						alDtlRecord.add(checkForNull(hmDetail.get("manufacturer_id"),""));//added for MO-CRF-20165      
						alDtlRecord.add(checkForNull(hmDetail.get("remarks_desc"), ""));
						alDtlRecord.add(checkForNull(hmDetail.get("catalog_code"), ""));//END 
						alDtlRecord.add(checkForNull(hmDetail.get("manufac_remarks"), ""));//MO-CRF-20178 

						alDtlRecord.add(hmHeader.get("facility_id"));
						alDtlRecord.add(hmHeader.get("doc_type_code"));
						alDtlRecord.add(hmHeader.get("doc_no"));
						alDtlRecord.add(hmDetail.get("doc_srl_no"));
						
						hmArgData.put(DATA,alDtlRecord);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE"));

						hmResult	=	update(connection, hmArgData, hmArgSQL);
System.err.println("===Goods received note EJB =Before Update hmResult===="+hmResult+"isFinalized=="+isFinalized);
						if(isFinalized){
							alDtlPOrequestRecord.add(grn_qty);
							alDtlPOrequestRecord.add(hmDetail.get("pur_uom_code"));
							alDtlPOrequestRecord.add(hmDetail.get("item_qty_normal"));
							alDtlPOrequestRecord.add(hmCommon.get("login_by_id"));
							alDtlPOrequestRecord.add(hmCommon.get("login_at_ws_no"));
							alDtlPOrequestRecord.add(hmCommon.get("login_facility_id"));
							alDtlPOrequestRecord.add(hmCommon.get("login_facility_id"));
							alDtlPOrequestRecord.add(hmHeader.get("po_no"));
							alDtlPOrequestRecord.add(hmDetail.get("item_code"));
							alDtlPOrequestRecord.add(hmHeader.get("PO_doc_type_code"));
							hmArgData.put(DATA,alDtlPOrequestRecord);
							hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY"));
							if(!((String)hmHeader.get("PO_doc_type_code")).equals("")){
							hmResult	=	update(connection, hmArgData, hmArgSQL);
							}
						}
						break;
					}
				}
				throwExceptionWhenFailed(hmResult);
System.err.println("===Goods received note EJB = 469===="+hmResult+"==isFinalized"+isFinalized+"==iMode"+iMode);				
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
// Added on 4/20/2005 by Ram to update the last purchase cost...
					ArrayList alPaForPcost	=	new ArrayList();
					alPaForPcost.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
					alPaForPcost.add(hmDetail.get("item_code"));
					hmArgData.put(DATA,alPaForPcost);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_MM_ITEM_UPDATE_FOR_GRN_LAST_PUR_COST"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

					ArrayList arrforlastcost	=	new ArrayList();
					arrforlastcost.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
					arrforlastcost.add(hmHeader.get("store_code"));
					arrforlastcost.add(hmDetail.get("item_code"));
					hmArgData.put(DATA,arrforlastcost);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_ST_ITEM_STORE_UPDATE_FOR_GRN_LAST_PUR_COST"));
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
 
					
					if(!((String)hmHeader.get("PO_doc_type_code")).equals(""))
					{
					arrforlastcost	=	new ArrayList();
					arrforlastcost.add(hmHeader.get("po_no"));
					arrforlastcost.add(hmHeader.get("PO_doc_type_code"));
					arrforlastcost.add(hmCommon.get("login_facility_id"));
					arrforlastcost.add(hmDetail.get("item_code"));
					 HashMap records=fetchRecord(connection, "SELECT  DTL.REQ_QTY FROM  PO_REQUEST_DTL DTL WHERE  dtl.DOC_NO = ? AND dtl.DOC_TYPE_CODE = ? AND dtl.FACILITY_ID = ? AND dtl.item_code= ?",arrforlastcost);
					 double req_qty= Double.parseDouble(checkForNull((String)records.get("REQ_QTY"),"0"));
					arrforlastcost	=	new ArrayList();
					arrforlastcost.add(hmHeader.get("store_code"));
					arrforlastcost.add(hmDetail.get("item_code"));
					records=fetchRecord(connection, "SELECT  PENDING_PO_REQ_QTY FROM  st_item_store  WHERE store_code=? and item_code= ?",arrforlastcost);
					double pending_qty=Double.parseDouble(checkForNull((String)records.get("PENDING_PO_REQ_QTY"),"0"));
					double stk=Double.parseDouble((String)hmDetail.get("stk_qty_str"));
					if(req_qty < stk){
						stk=req_qty;
					}else if(pending_qty==0){
					stk=0;
					}
					arrforlastcost	=	new ArrayList();
					arrforlastcost.add(""+stk);
					arrforlastcost.add(""+stk);
					arrforlastcost.add(hmDetail.get("item_code"));
					arrforlastcost.add(hmHeader.get("store_code"));
					hmArgData.put(DATA,arrforlastcost);
					hmArgSQL.put(UPDATE_SQL,"UPDATE st_item_store SET  PENDING_PO_REQ_QTY = decode(?,0,PENDING_PO_REQ_QTY,(PENDING_PO_REQ_QTY-?)) WHERE item_code = ? AND store_code = ?");
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}
					hmParameters.put("trn_qty",hmDetail.get("stk_qty"));
					hmResult	=	insertOrUpdateItemMoveSummary(connection, hmParameters, hmSQL);
					throwExceptionWhenFailed(hmResult);
					rec_high_no = rec_high_no + 1;
					
					//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012 Starts
					ArrayList alPurUom	=	new ArrayList();
					alPurUom.add(hmDetail.get("pur_uom_code"));
					alPurUom.add(hmDetail.get("item_code"));
					
					hmArgData.put(DATA,alPurUom);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_MM_ITEM_UPDATE_PUR_UOM"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);

 

					throwExceptionWhenFailed(hmResult);
					//ends
				}
			
			}



			/*added for Po details update in PR and Po related tables*/
		if(isPOApplicable){

			double grn_qty_minus_bonus		=	0;
			String pur_req_no				=	"";
			String pur_req_doc_srl_no		=	"";
			String po_no					=	"";
			String do_no					=	"";
			String pur_req_store_code		=	"";

			for (int i=0;i<alDetail.size() ;i++ ) {

				HashMap hmDetail		=	(HashMap)alDetail.get(i);
				
				int iMode	=	Integer.parseInt((String)hmDetail.get("mode"));

System.err.println("After iMode"+iMode);	
				if (iMode==0){
						ArrayList alUnfgrnRecord	=	new ArrayList();

						alUnfgrnRecord.add(hmHeader.get("facility_id"));	
						alUnfgrnRecord.add(hmHeader.get("doc_type_code"));	
						alUnfgrnRecord.add(hmHeader.get("doc_no"));	
						alUnfgrnRecord.add(hmDetail.get("item_code"));

						if(!((String)hmHeader.get("po_no")).equals("")){//Added by suresh.r on 12-05-2015 against ML-BRU-SCF-1573
						hmArgData.put(DATA,alUnfgrnRecord);
						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS1"));
						hmResult	=	delete(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}

						
						if(!((String)hmHeader.get("do_no")).equals("")){

							ArrayList alblockedDoRecord	=	new ArrayList();
							
							alblockedDoRecord.add(hmCommon.get("login_by_id"));
							alblockedDoRecord.add(hmCommon.get("login_at_ws_no"));
							alblockedDoRecord.add(hmCommon.get("login_facility_id"));
							alblockedDoRecord.add(hmHeader.get("do_no"));
							alblockedDoRecord.add(hmDetail.get("item_code"));							
							alblockedDoRecord.add(hmHeader.get("facility_id"));
							alblockedDoRecord.add(hmHeader.get("store_code"));
							

							hmArgData.put(DATA,alblockedDoRecord);
							hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_UNF_GRN_DO_QTY_IN_DO_BAT1"));
							hmResult	=	update(connection, hmArgData, hmArgSQL);
							throwExceptionWhenFailed(hmResult);
						}
						continue;
					}

					int podtlsize = 0;
					podtlsize = alPoDtl.size();
					
					for (int p=0;p<podtlsize ;p++ ) {
						 alTemp		= (HashMap)alPoDtl.get(p);

						if(((String)hmDetail.get("item_code")).equals((String)alTemp.get("item_code"))  &&  iMode!=0) {
							
							alPoRecord = new ArrayList();
							
							pur_req_no = checkForNull((String)alTemp.get("pur_req_no"));
							pur_req_doc_srl_no = checkForNull((String)alTemp.get("pur_req_doc_srl_no"));
							po_no = checkForNull((String)alTemp.get("po_number"));
							do_no = checkForNull((String)alTemp.get("do_no"));//added for CRF 113 
							pur_req_store_code = checkForNull((String)alTemp.get("store_code"));

							if(pur_req_no.equals(""))
								pur_req_store_code = "*A";

							if(!(pur_req_no).equals("")  && !(pur_req_doc_srl_no).equals("")){
							alPoRecord.add((String)alTemp.get("grn_item_qty"));
							alPoRecord.add((String)hmDetail.get("pur_uom_code")); 
							alPoRecord.add((String)alTemp.get("grn_item_qty"));
							alPoRecord.add(hmCommon.get("login_by_id"));
							alPoRecord.add(hmCommon.get("login_at_ws_no"));
							alPoRecord.add(hmCommon.get("login_facility_id"));
							alPoRecord.add((String)alTemp.get("pur_req_facility_id"));
							alPoRecord.add((String)alTemp.get("pur_req_no"));
							alPoRecord.add((String)alTemp.get("pur_req_doc_srl_no"));						

							alPoRecords.add(alPoRecord);
							}

							alPoRecord1 = new ArrayList();
							
							if(!(po_no).equals("") && !(po_no).equals("*A")){
							alPoRecord1.add((String)alTemp.get("grn_item_qty"));
							alPoRecord1.add((String)hmDetail.get("pur_uom_code")); 
							alPoRecord1.add((String)hmDetail.get("pur_uom_conv"));
							alPoRecord1.add((String)alTemp.get("poitemStatus"));
							alPoRecord1.add(hmCommon.get("login_by_id"));
							alPoRecord1.add(hmCommon.get("login_at_ws_no"));
							alPoRecord1.add(hmCommon.get("login_facility_id"));
							alPoRecord1.add((String)alTemp.get("pur_unit_code"));
							alPoRecord1.add((String)alTemp.get("po_number")); 
							alPoRecord1.add((String)alTemp.get("pur_req_facility_id"));
							//alPoRecord1.add((String)alTemp.get("store_code"));
							alPoRecord1.add(pur_req_store_code);
							alPoRecord1.add((String)alTemp.get("item_code"));
							alPoRecord1.add((String)alTemp.get("po_doc_srl_no"));

							alPoRecords1.add(alPoRecord1);
							}

						
							alPoRecord2 = new ArrayList();
							alPoRecord3 = new ArrayList();
							alCount		= new ArrayList();

							if(pur_req_no.equals(""))
									pur_req_no = "*A";

							if(po_no.equals(""))
									po_no = "*A";

							if(do_no.equals(""))
									do_no = "*A";
							

							
							alCount.add(hmHeader.get("facility_id"));
							alCount.add(hmHeader.get("doc_type_code"));
							alCount.add(hmHeader.get("doc_no"));
							alCount.add(po_no);
							alCount.add(pur_req_no);
							alCount.add(hmDetail.get("item_code"));
							alCount.add(do_no);//added for BRU-CRF 113 

							
							String countsql = (String)hmSQL.get("SQL_COUNT_PO_ORDER_UNF_GRN_RECORDS");
							int Count	=	Integer.parseInt((String)fetchRecord(connection,countsql,alCount).get("COUNT"));
		
							if(Count > 0){
							
							alPoRecord3.add((String)alTemp.get("grn_item_qty"));
							alPoRecord3.add(hmHeader.get("facility_id"));
							alPoRecord3.add(hmHeader.get("doc_type_code"));
							alPoRecord3.add(hmHeader.get("doc_no"));
							alPoRecord3.add(po_no);
							alPoRecord3.add(pur_req_no);
							alPoRecord3.add(hmDetail.get("item_code"));
							alPoRecord3.add(do_no);//added for CRF 113 

							alPoRecords3.add(alPoRecord3);

							}else{
							alPoRecord2.add(hmHeader.get("facility_id"));
							alPoRecord2.add(hmHeader.get("doc_type_code")); 
							alPoRecord2.add(hmHeader.get("doc_no"));
							alPoRecord2.add(po_no);
							alPoRecord2.add(pur_req_no);
							alPoRecord2.add(hmDetail.get("item_code"));
							alPoRecord2.add((String)alTemp.get("grn_item_qty"));
							alPoRecord2.add(do_no);//added for CRF 113 
							alPoRecord2.add((String)hmCommon.get("login_by_id"));
							alPoRecord2.add((String)hmCommon.get("login_at_ws_no"));
							alPoRecord2.add((String)hmCommon.get("login_facility_id"));
							alPoRecord2.add((String)hmCommon.get("login_by_id"));
							alPoRecord2.add((String)hmCommon.get("login_at_ws_no"));
							alPoRecord2.add((String)hmCommon.get("login_facility_id"));

							alPoRecords2.add(alPoRecord2);

							}

							alPoRecords4.add(alCount);//this is for delete the unf records

						}
					}

				//added for do table update

						ArrayList hmDoDtlRecords	=	(ArrayList)hmDoDtl.get(((String)hmDetail.get("item_code")));

					if(hmDoDtlRecords != null && hmDoDtlRecords.size()>0){
						for(int d=0;d<hmDoDtlRecords.size();d++){
							HashMap hmDoRecord = (HashMap)hmDoDtlRecords.get(d);
							
							alDoRecord = new ArrayList();
							alDoRecord1 = new ArrayList();
							
							if(((String)hmDoRecord.get("do_no")).equals(""))
								continue;

								grn_qty_minus_bonus = Double.parseDouble((String)hmDoRecord.get("grn_item_qty")) - Double.parseDouble(checkForNull((String)hmDoRecord.get("do_qty_bonus"),"0"));

								//alDoRecord.add((String)hmDoRecord.get("grn_item_qty"));
								alDoRecord.add(""+grn_qty_minus_bonus);
								alDoRecord.add((String)hmDetail.get("pur_uom_code"));
								alDoRecord.add((String)hmDetail.get("pur_uom_conv"));
								alDoRecord.add((String)hmCommon.get("login_by_id"));								
								alDoRecord.add((String)hmCommon.get("login_at_ws_no"));
								alDoRecord.add((String)hmCommon.get("login_facility_id"));
								alDoRecord.add((String)hmDoRecord.get("do_no"));
								alDoRecord.add((String)hmDoRecord.get("item_code"));
								alDoRecord.add((String)hmDoRecord.get("do_srl_no"));
								alDoRecord.add((String)hmDoRecord.get("sch_delv_date"));
								alDoRecord.add((String)hmDoRecord.get("po_no"));
								alDoRecord.add((String)hmDoRecord.get("po_srl_no"));
								alDoRecord.add(((String)hmDoRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
								alDoRecord.add((String)hmDoRecord.get("expiry_date_or_receipt_date"));
								alDoRecord.add((String)hmDoRecord.get("dist_facility_id"));
								alDoRecord.add((String)hmDoRecord.get("dist_store_code"));								

								alDoRecords.add(alDoRecord);

								//this is for unfinalized - updating the block qty in do dtl batch table
								//alDoRecord1.add((String)hmDoRecord.get("grn_item_qty"));
								alDoRecord1.add(""+grn_qty_minus_bonus);
								alDoRecord1.add((String)hmCommon.get("login_by_id"));								
								alDoRecord1.add((String)hmCommon.get("login_at_ws_no"));
								alDoRecord1.add((String)hmCommon.get("login_facility_id"));
								alDoRecord1.add((String)hmDoRecord.get("do_no"));
								alDoRecord1.add((String)hmDoRecord.get("item_code"));
								alDoRecord1.add((String)hmDoRecord.get("do_srl_no"));
								alDoRecord1.add((String)hmDoRecord.get("sch_delv_date"));
								alDoRecord1.add((String)hmDoRecord.get("po_no"));
								alDoRecord1.add((String)hmDoRecord.get("po_srl_no"));
								alDoRecord1.add(((String)hmDoRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
								alDoRecord1.add((String)hmDoRecord.get("expiry_date_or_receipt_date"));
								alDoRecord1.add((String)hmDoRecord.get("dist_facility_id"));
								alDoRecord1.add((String)hmDoRecord.get("dist_store_code"));								

								alDoRecords1.add(alDoRecord1);

						}
					}
					
					if(podtlsize==0){
							if(iMode!=0 && isFinalized){
							alParameters = new ArrayList();

							alParameters.add(hmHeader.get("facility_id"));
							alParameters.add(hmHeader.get("doc_type_code"));
							alParameters.add(hmHeader.get("doc_no"));
							alParameters.add(hmDetail.get("item_code"));
							
							ArrayList getPoDetails	=	fetchRecords(connection,"SELECT PO_NO,REQ_NO,BLOCKED_QTY,DO_NO FROM PO_ORDER_UNF_GRN WHERE FACILITY_ID=? AND GRN_DOC_TYPE_CODE=? AND GRN_NO=? AND ITEM_CODE=?", alParameters);
							
							//if(getPoDetails.size()>0){

								for(int g=0;g<getPoDetails.size();g++){

								HashMap temp = (HashMap)getPoDetails.get(g);

								blockPoRecord = new ArrayList();
								
								pur_req_no = checkForNull((String)temp.get("REQ_NO"));
								po_no = checkForNull((String)temp.get("PO_NO"));
								do_no = checkForNull((String)temp.get("DO_NO"));

								if(!(pur_req_no).equals("*A")){
									blockPoRecord.add((String)temp.get("BLOCKED_QTY"));
									blockPoRecord.add((String)hmDetail.get("pur_uom_code")); 
									blockPoRecord.add((String)temp.get("BLOCKED_QTY"));
									blockPoRecord.add(hmCommon.get("login_by_id"));
									blockPoRecord.add(hmCommon.get("login_at_ws_no"));
									blockPoRecord.add(hmCommon.get("login_facility_id"));
									blockPoRecord.add(pur_req_no);
									blockPoRecord.add((String)hmDetail.get("item_code"));
							
									hmArgData.put(DATA,blockPoRecord);
									hmArgSQL.put(UPDATE_SQL,"UPDATE PO_REQUEST_DETAIL SET GRN_QTY = NVL(GRN_QTY,0)+? , GRN_UOM = ? ,GRN_GEN_UOM_QTY = NVL(GRN_GEN_UOM_QTY,0)+? , MODIFIED_BY_ID = ? ,MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ? ,MODIFIED_FACILITY_ID = ? WHERE  REQ_NO = ? AND ITEM_CODE = ?" );
									hmResult	=	update(connection, hmArgData, hmArgSQL);
									throwExceptionWhenFailed(hmResult);
								}
								
								blockPoRecord1 = new ArrayList();
								
								if(!(pur_req_no).equals("*A")){
									if(!(po_no).equals("*A")){
											blockPoRecord1.add((String)temp.get("BLOCKED_QTY"));
											blockPoRecord1.add((String)hmDetail.get("pur_uom_code")); 
											blockPoRecord1.add((String)hmDetail.get("pur_uom_conv"));
											blockPoRecord1.add(hmCommon.get("login_by_id"));
											blockPoRecord1.add(hmCommon.get("login_at_ws_no"));
											blockPoRecord1.add(hmCommon.get("login_facility_id"));
											blockPoRecord1.add((String)temp.get("PO_NO")); 
											blockPoRecord1.add(pur_req_no); 
											blockPoRecord1.add((String)hmDetail.get("item_code"));

											hmArgData.put(DATA,blockPoRecord1);
											hmArgSQL.put(UPDATE_SQL,"UPDATE PO_ORDER_FCY_DTL SET  GRN_QTY = NVL(GRN_QTY,0)+? , GRN_UOM = ? ,GRN_UOM_CONV_FACTOR = ? ,MODIFIED_BY_ID = ? ,MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ? ,MODIFIED_FACILITY_ID = ? WHERE  PO_NO = ? AND REQ_NO = ?  AND ITEM_CODE = ? " );
											hmResult	=	update(connection, hmArgData, hmArgSQL);
											throwExceptionWhenFailed(hmResult);
									}
								}else{
									if(!(po_no).equals("*A")){
											blockPoRecord1.add((String)temp.get("BLOCKED_QTY"));
											blockPoRecord1.add((String)hmDetail.get("pur_uom_code")); 
											blockPoRecord1.add((String)hmDetail.get("pur_uom_conv"));
											blockPoRecord1.add(hmCommon.get("login_by_id"));
											blockPoRecord1.add(hmCommon.get("login_at_ws_no"));
											blockPoRecord1.add(hmCommon.get("login_facility_id"));
											blockPoRecord1.add((String)temp.get("PO_NO")); 
											blockPoRecord1.add((String)hmDetail.get("item_code"));
											
											hmArgData.put(DATA,blockPoRecord1);
											hmArgSQL.put(UPDATE_SQL,"UPDATE PO_ORDER_FCY_DTL SET  GRN_QTY = NVL(GRN_QTY,0)+? , GRN_UOM = ? ,GRN_UOM_CONV_FACTOR = ? ,MODIFIED_BY_ID = ? ,MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ? ,MODIFIED_FACILITY_ID = ? WHERE  PO_NO = ?  AND ITEM_CODE = ? " );
											hmResult	=	update(connection, hmArgData, hmArgSQL);
											throwExceptionWhenFailed(hmResult);
									}
								}

								blockDoRecord = new ArrayList();

								if(!(do_no).equals("*A")){
								blockDoRecord.add((String)hmDetail.get("pur_uom_code")); 
								blockDoRecord.add((String)hmDetail.get("pur_uom_conv")); 
								blockDoRecord.add(hmCommon.get("login_by_id"));
								blockDoRecord.add(hmCommon.get("login_at_ws_no"));
								blockDoRecord.add(hmCommon.get("login_facility_id"));
								blockDoRecord.add(do_no);
								blockDoRecord.add((String)hmDetail.get("item_code"));
								blockDoRecord.add(hmCommon.get("login_facility_id"));
								blockDoRecord.add(hmHeader.get("store_code"));
						
								hmArgData.put(DATA,blockDoRecord);
								hmArgSQL.put(UPDATE_SQL,"UPDATE PO_DELV_ORD_DTL_BAT  SET GRN_QTY = DO_QTY_NORMAL,  GRN_UOM = ?,  GRN_UOM_CONV_FACTOR = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE,  MODIFIED_AT_WS_NO = ?,  MODIFIED_FACILITY_ID = ? ,GRN_BLOCKED_QTY = 0  WHERE DO_NO = ?  AND ITEM_CODE = ? AND  DIST_FACILITY_ID= ?   AND DIST_STORE_CODE= ?" );
								hmResult	=	update(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);
								}



								alCount		= new ArrayList();

								alCount.add(hmHeader.get("facility_id"));
								alCount.add(hmHeader.get("doc_type_code"));
								alCount.add(hmHeader.get("doc_no"));
								//alCount.add((String)temp.get("PO_NO"));
								alCount.add(po_no);
								alCount.add(pur_req_no);
								alCount.add((String)hmDetail.get("item_code"));
								alCount.add(do_no);

								alPoRecords4.add(alCount);

								}
							//}
	  					  }
					   }
			   }
			}
System.err.println("After isPOApplicable"+isPOApplicable);		
				/*ended*/
				if(isPOApplicable){
					if(isFinalized){
						if(alPoRecords.size()>0){
						hmArgData.put(DATA,alPoRecords);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_REQUEST_DETAIL_GRN_QTY"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}

						if(alPoRecords1.size()>0){
						hmArgData.put(DATA,alPoRecords1);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_FCY_DTL_GRN_QTY"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
						
						if(hmData.containsKey("NextDelDateData")){
						alPoHdr = (ArrayList)	hmData.get("NextDelDateData");

						ArrayList NextDeldateUpdate  = new ArrayList();
						
						NextDeldateUpdate.add((String)alPoHdr.get(0));
						NextDeldateUpdate.add((String)hmCommon.get("login_by_id"));
						NextDeldateUpdate.add((String)hmCommon.get("login_at_ws_no"));
						NextDeldateUpdate.add((String)hmCommon.get("login_facility_id"));
						NextDeldateUpdate.add((String)alPoHdr.get(1));			

						hmArgData.put(DATA,NextDeldateUpdate);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_HDR_FOR_NEXT_DEL_DATE"));
						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}

						if(alPoRecords4.size()>0){
						hmArgData.put(DATA,alPoRecords4);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}

						if(alDoRecords.size()>0){
						hmArgData.put(DATA,alDoRecords);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_QTY"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}

					}else{
						
						if(alPoRecords2.size()>0){
						hmArgData.put(DATA,alPoRecords2);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
						if(alPoRecords3.size()>0){
						hmArgData.put(DATA,alPoRecords3);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_UNF_GRN_RECORDS"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
						if(alDoRecords1.size()>0){
						hmArgData.put(DATA,alDoRecords1);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_BLOCK_QTY"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
					}

					//For Status update of Po dtl and Po hdr 											
					if(!((String)hmHeader.get("po_no")).equals("") && isFinalized){
						ArrayList PoItemStatusUpdate = new ArrayList();						
						ArrayList PoHdrStatusUpdate = new ArrayList();						
						
						ArrayList getPoDetails	=	fetchRecords(connection,"SELECT PUR_UNIT_CODE,REQ_FACILITY_ID,REQ_STORE_CODE,ITEM_CODE,PO_SRL_NO,PO_QTY,NVL(GRN_QTY,0) GRN_QTY FROM PO_ORDER_FCY_DTL WHERE PO_NO=?", (String)hmHeader.get("po_no"));
						
						boolean hdrstatuscheck =  true;

						for(int k=0 ; k <getPoDetails.size() ;k++){
						HashMap itemdetail = (HashMap)getPoDetails.get(k);
						alParameters = new ArrayList();	
						
						double po_qty = Double.parseDouble((String)itemdetail.get("PO_QTY"));
						double grn_qty = Double.parseDouble((String)itemdetail.get("GRN_QTY"));

							if(po_qty<=grn_qty){
								alParameters.add("FR");
							}else{
								alParameters.add("PR");
								hdrstatuscheck = false;
							}

							alParameters.add(itemdetail.get("PUR_UNIT_CODE"));
							alParameters.add(hmHeader.get("po_no"));
							alParameters.add(itemdetail.get("REQ_FACILITY_ID"));
							alParameters.add(itemdetail.get("REQ_STORE_CODE"));
							alParameters.add(itemdetail.get("ITEM_CODE"));
							alParameters.add(itemdetail.get("PO_SRL_NO"));

							PoItemStatusUpdate.add(alParameters);
				
						}
						if(getPoDetails.size()>0){
							if(hdrstatuscheck)
								PoHdrStatusUpdate.add("FR");
							else
								PoHdrStatusUpdate.add("PR");
							PoHdrStatusUpdate.add(hmHeader.get("po_no"));
						}

						if(PoItemStatusUpdate.size()>0){
						hmArgData.put(DATA,PoItemStatusUpdate);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_FCY_DTL_STATUS"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
						if(PoItemStatusUpdate.size()>0){
						hmArgData.put(DATA,PoHdrStatusUpdate);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_HDR_STATUS"));
						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
					}

					//For Status update of Do dtl and Do hdr 											
						if(!((String)hmHeader.get("do_no")).equals("") && isFinalized){

							ArrayList DoItemStatusUpdate = new ArrayList();						
							ArrayList DoHdrStatusUpdate = new ArrayList();		
							ArrayList Parameters = null;				
							
							ArrayList getDoDetails	=	fetchRecords(connection,"SELECT DO_NO,ITEM_CODE,DO_SRL_NO,TO_CHAR(SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE, PO_NO,PO_SRL_NO,SUM(DO_QTY_NORMAL)DO_QTY,SUM(NVL(GRN_QTY,0)) GRN_QTY FROM PO_DELV_ORD_DTL_BAT WHERE DO_NO=? GROUP BY DO_NO,ITEM_CODE,DO_SRL_NO,DO_SRL_NO,SCH_DELV_DATE,PO_NO,PO_SRL_NO", (String)hmHeader.get("do_no"));
							
							boolean hdrstatuscheck =  true;

							for(int k1=0 ; k1 <getDoDetails.size() ;k1++){
							HashMap itemdetail = (HashMap)getDoDetails.get(k1);
							Parameters = new ArrayList();	
							
							double do_qty = Double.parseDouble((String)itemdetail.get("DO_QTY"));
							double grn_qty = Double.parseDouble((String)itemdetail.get("GRN_QTY"));

								if(do_qty<=grn_qty){
									Parameters.add("FR");
								}else{
									Parameters.add("PR");
									hdrstatuscheck = false;
								}

								Parameters.add(itemdetail.get("DO_NO"));
								Parameters.add(itemdetail.get("ITEM_CODE"));
								Parameters.add(itemdetail.get("DO_SRL_NO"));
								Parameters.add(itemdetail.get("SCH_DELV_DATE"));
								Parameters.add(itemdetail.get("PO_NO"));
								Parameters.add(itemdetail.get("PO_SRL_NO"));

								DoItemStatusUpdate.add(Parameters);
					
							}

							if(getDoDetails.size()>0){
								if(hdrstatuscheck)
									DoHdrStatusUpdate.add("FR");
								else
									DoHdrStatusUpdate.add("PR");

									DoHdrStatusUpdate.add(hmHeader.get("do_no"));
							}
							
								if(DoItemStatusUpdate.size()>0){	
								hmArgData.put(DATA,DoItemStatusUpdate);
								hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_DTL_STATUS"));
								hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);
								}
								if(DoHdrStatusUpdate.size()>0){
								hmArgData.put(DATA,DoHdrStatusUpdate);
								hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_HDR_STATUS"));
								hmResult	=	update(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);
								}
						}
				}
			
System.err.println("After hmResult"+hmResult);

//exp logic
			alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");
			ArrayList imageRefRecord	= new ArrayList();//23925
			for (int i=0;i<alExp.size() ;i++ ) {
				HashMap hmExpRecord		= (HashMap)alExp.get(i);
				ArrayList alExpRecord	= new ArrayList();

				alExpRecord.add(hmHeader.get("facility_id"));
				alExpRecord.add(hmHeader.get("doc_type_code"));
				alExpRecord.add(hmHeader.get("doc_no"));

				alExpRecord.add(hmExpRecord.get("doc_srl_no"));
				alExpRecord.add(hmExpRecord.get("store_code"));
				alExpRecord.add(hmExpRecord.get("item_code"));
				alExpRecord.add(((String)hmExpRecord.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
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
				alExpRecord.add(checkForNull((String)hmExpRecord.get("sale_price")));
				alExpRecord.add(checkForNull((String)hmExpRecord.get("barcode_id")));
				alExpRecord.add(checkForNull((String)hmExpRecord.get("manufactured_date")));//Added for MO-CRF-20165 
				//23925 Start
				alExpRecord.add(checkForNull((String)hmExpRecord.get("fileRef")));//Added for MO-CRF-20171 
				if(!"".equals(checkForNull((String)hmExpRecord.get("fileRef"))))
					imageRefRecord.add(checkForNull((String)hmExpRecord.get("fileRef")));
				//23925 End.
				alExpData.add(alExpRecord);
				
				if (isFinalized) {
					//Added by suresh.r on 30-01-2014 against #46420 beg
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
					hmParamaters.put("batch_id",((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
					hmParamaters.put("expiry_date_or_receipt_date",hmExpRecord.get("expiry_date_or_receipt_date"));
					hmParamaters.put("trade_id",hmExpRecord.get("trade_id"));
					hmParamaters.put("from_bin_location_code",hmExpRecord.get("bin_location_code"));
					hmParamaters.put("suspended_batch_allowed_yn","Y");
					hmParamaters.put("release_batch_yn","N");
					hmParamaters.put("sale_price",checkForNull((String)hmExpRecord.get("sale_price")));
					hmParamaters.put("barcode_id",checkForNull((String)hmExpRecord.get("barcode_id")));

System.out.println("hmParamaters" +hmParamaters);
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
					hmParamaters.put("supp_code",	checkForNull(hmHeader.get("supp_code")));

					hmParamaters.put("pur_uom_code",	checkForNull(hmTempItemInfo.get("pur_uom_code")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
					hmParamaters.put("pur_uom_conv",	checkForNull(hmTempItemInfo.get("pur_uom_conv")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012

					

					updateBatchOnLine(connection, hmSQL, hmParamaters);
System.err.println("After updateBatchOnLine");							
					//Added by suresh.r on 30-01-2014 against #46420 end
					if(!(((String)hmExpRecord.get("sale_price")).equals(""))){
						//Added by suresh.r on 30-01-2014 against #46420 beg
						String stSQL = eST.Common.StEJBRepository.getStKeyValue("SQL_ST_BATCH_CONTROL_SELECT_BATCH_COST");
						ArrayList Parameters = new ArrayList();
						Parameters.add(hmExpRecord.get("item_code"));
						Parameters.add(((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
						Parameters.add(hmExpRecord.get("expiry_date_or_receipt_date"));
						hmResult		= fetchRecord(connection, stSQL, Parameters);
						String batch_cost=setNumber(""+checkForNull(hmResult.get("BATCH_COST"),"0"),noOfDecimalsForCost);
						//CallableStatement callableStatement = null;
						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?) }");
						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?) }");
						//Added by suresh.r on 30-01-2014 against #46420 end
						callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?,?) }");//Added for AMS-SCF-0277.1
						callableStatement.setString(1, (String)hmExpRecord.get("item_code"));
						callableStatement.setString(2, (String)hmExpRecord.get("trade_id"));
						callableStatement.setString(3, ((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
						callableStatement.setString(4, (String)hmExpRecord.get("sale_price"));
						callableStatement.setString(5, (String)hmCommon.get("login_by_id"));
						callableStatement.setString(6, (String)hmCommon.get("login_at_ws_no"));
						callableStatement.registerOutParameter(7, Types.VARCHAR);//Error Code
						callableStatement.registerOutParameter(8, Types.VARCHAR);//sys message id
						callableStatement.registerOutParameter(9, Types.VARCHAR);//error text
						callableStatement.setString(10, batch_cost);//Added by suresh.r on 30-01-2014 against #46420
						callableStatement.setString(11, (String)hmCommon.get("login_facility_id"));//Added for AMS-SCF-0277.1
						callableStatement.execute();
						/** @ to handle the "UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated " comitted
						if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));**/

						/** @@	To solve the "UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated "  exception  **/
						if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null && !callableStatement.getString(9).equals("UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated") &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));
					}
					closeStatement(callableStatement);
 	
					/*Commented by suresh.r on 30-01-2014 against #46420 end
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
					hmParamaters.put("sale_price",checkForNull((String)hmExpRecord.get("sale_price")));
					hmParamaters.put("barcode_id",checkForNull((String)hmExpRecord.get("barcode_id")));

System.out.println("hmParamaters" +hmParamaters);
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
					hmParamaters.put("supp_code",	checkForNull(hmHeader.get("supp_code")));

					hmParamaters.put("pur_uom_code",	checkForNull(hmTempItemInfo.get("pur_uom_code")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
					hmParamaters.put("pur_uom_conv",	checkForNull(hmTempItemInfo.get("pur_uom_conv")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012

					

					updateBatchOnLine(connection, hmSQL, hmParamaters);
					Commented by suresh.r on 30-01-2014 against #46420 end*/
					//updateBatchHistoryOnLine(connection, hmSQL, hmParamaters); //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
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
					ItemTrnDtlRecord.add(((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
					ItemTrnDtlRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
					//ItemTrnDtlRecord.add(""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))/Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("grn_item_qty"));//hmTempItemInfo.get("item_qty_normal")
					ItemTrnDtlRecord.add(""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//modified by Ganga for ML-BRU-SCF-0914 [IN:041338] on 7th July 2013
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
System.err.println("====Before imageRefRecord===========EJB====imageRefRecord"+imageRefRecord);			
System.err.println("====Before imageRefRecord===========EJB====size"+imageRefRecord.size());
			//23925 Start.
			if(imageRefRecord.size()>0){				 
				hmResult	=uploadDocuments(connection,logginFacility,imageRefRecord);
				throwExceptionWhenFailed(hmResult);
			}
			//23925 End.
System.err.println("====After imageRefRecord===========EJB====hmResult"+hmResult+"isFinalized=="+isFinalized);				
			if (isFinalized) {
				hmArgData.put(DATA,alItemTrnDtl);
				hmArgSQL.put(BATCH_SQL, hmSQL.get("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

			}
System.err.println("====Before Commit===========EJB====hmResult"+hmResult);			
			//hmResult.put("doc_no",hmHeader.get("doc_no"));
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
				System.out.println("hmData==GRN Modify"+hmData);
				System.err.println("hmData==GRN Modify"+hmData);
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());
			hmResult.put("flag",rec_high_no+"");

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


	public HashMap insert(HashMap hmData, HashMap hmSQL)  { //throws RemoteException

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
		ArrayList	alExpData	=	new ArrayList();
		ArrayList	alItemTrnDtl=	new ArrayList();
		ArrayList	alPoDtl			 =	new ArrayList();
		ArrayList	alPoHdr			 =	new ArrayList();
		HashMap		alTemp			 =   null;
		ArrayList	alPoRecord		 =	null;
		ArrayList	alPoRecord1		 =	null;
		ArrayList	alPoRecord2		 =	null;
		ArrayList	alPoRecords		 =	new ArrayList();
		ArrayList	alPoRecords1	 =	new ArrayList();
		ArrayList	alPoRecords2	 =	new ArrayList();
		ArrayList	alExpForPOCheck	 =	new ArrayList();
		//HashMap		hmDoHdr			 =	new HashMap(); //commented by Rabbani on 24-Mar-2014 for chkstyles
		HashMap		hmDoDtl			 =	new HashMap();
		ArrayList	alDoRecords		 =  new ArrayList();
		ArrayList	alDoRecords1		 =  new ArrayList();
		ArrayList	alDoRecord		 =  null;
		ArrayList	alDoRecord1		 =  null;


		double cItQty	= 0.0;
		double expItQty	= 0.0;


	//	ArrayList<ArrayList> alTempData		= new ArrayList<ArrayList>();
		ArrayList<Integer> alItemClassCount	= new ArrayList<Integer>();
		ArrayList<String> alItemClass		= new ArrayList<String>();
		String item_class_based	= checkForNull((String)hmData.get("ITEM_CLASS_BASED"),"N");

	//	boolean isDocNoAutoGenerated	=	false;
		boolean isFinalized		=	false;
		boolean isPOApplicable	=	false;
		int rec_high_no = 0;
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
			/**
		 * @Name - Priya
		 * @Date - 25/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			hmCommon			=	(HashMap)	hmData.get("COMMON_DATA");
			hmHeader			=	(HashMap)	hmData.get("HDR_DATA");
			allanguageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			isFinalized			=	((String)	hmHeader.get("finalized_yn")).equals("Y");
			String logginFacility = (String) hmCommon.get("login_facility_id");//23925
			ArrayList alDtlData1	=	(ArrayList)	hmData.get("DTL_DATA");


			alPoDtl  = (ArrayList)	hmData.get("PO_DETAILS");
			hmDoDtl  = (HashMap)	hmData.get("DO_DETAILS");
			isPOApplicable = (Boolean)hmData.get("isPOApplicable");

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
		//	HashMap hmRecord	=	fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"), (String)hmHeader.get("doc_type_code"));
			//isDocNoAutoGenerated=	hmRecord.get("DOC_NUM_GEN_FLAG").toString().equals("Y");

		//	if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
		//		hmHeader.put("doc_no", (String)fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), (String)hmHeader.get("doc_type_code")).get("NEXT_DOC_NO"));
		//	}
			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
				int count =1;
				while(count>0){
					String doc_no_dup = (String)fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), (String)hmHeader.get("doc_type_code")).get("NEXT_DOC_NO");
					ArrayList param = new ArrayList();
					param.add((String)hmHeader.get("doc_type_code"));
					param.add(doc_no_dup);
					String count_sal = (String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_GRN_HDR WHERE DOC_TYPE_CODE= ?  AND DOC_NO = ?", param).get("COUNT");
					if(Integer.parseInt(count_sal)>0){
						ArrayList alParameters = new ArrayList();
						alParameters.add(hmCommon.get("login_by_id"));
						alParameters.add(hmCommon.get("login_at_ws_no"));
						alParameters.add(hmCommon.get("login_facility_id"));
						alParameters.add(hmHeader.get("doc_type_code"));
						
						hmArgData.put(DATA,alParameters);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

						hmResult	=	update(connection, hmArgData, hmArgSQL);
						count =1;
					}else{
						hmHeader.put("doc_no", (String)fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), (String)hmHeader.get("doc_type_code")).get("NEXT_DOC_NO"));
						count=0;
					}
				}
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

			alHdrData.add(checkForNull(hmHeader.get("po_no")));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));
			alHdrData.add(hmHeader.get("conversion_rate"));
			alHdrData.add(checkForNull(hmHeader.get("do_no")));
			alHdrData.add(checkForNull(hmHeader.get("invoice_no")));
			alHdrData.add(checkForNull(hmHeader.get("invoice_recd_by")));
			alHdrData.add(checkForNull(hmHeader.get("grn_mode")));
			alHdrData.add(checkForNull(hmHeader.get("grn_remarks_desc")));//added for MO-CRF-20165 

			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_GRN_HDR_INSERT"));
			hmResult	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

//dtl logic
		//	alDetail	=	(ArrayList)	hmData.get("DTL_DATA");
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
			for (int i=k;i<trnRecords ;i++ ) {	
				HashMap hmDetail	= (HashMap)alDetail.get(i);
				alDtlRecord	=	new ArrayList();

				expItQty	=	0.0;
				cItQty	=	0.0;
			
				item_code_list.add((String)hmDetail.get("item_code"));

					cItQty	=	Double.parseDouble((String)hmDetail.get("item_qty_normal")) + Double.parseDouble((String)hmDetail.get("item_qty_bonus"));
					
					if (cItQty==0) {
						//throw new Exception ("ITEM_QTY_ZERO_AT_DETAIL#"+(i+1));
						throw new Exception ("QTY_SHOULD_BE_GR_ZERO");						
					}
					 if(isPOApplicable){
						 alExpForPOCheck		=	(ArrayList)	hmData.get("DTL_EXP_DATA");

						 if(alExpForPOCheck.size()==0){
							 throw new Exception ("UPDATE_EXP_RECORDS");	
						 }

						 for(int chk=0; chk<alExpForPOCheck.size(); chk++){
						 HashMap hmExpRecord		= (HashMap)alExpForPOCheck.get(chk);
							if(((String)hmDetail.get("item_code")).equals((String)hmExpRecord.get("item_code"))){
								expItQty = expItQty + Double.parseDouble(checkForNull((String)hmExpRecord.get("grn_item_qty"),"0"));
							}
						 }
						 if(cItQty!=expItQty)
							throw new Exception ("DTL_AND_EXP_QTY_SHOULD_BE_EQUAL");
					 }


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
				alDtlRecord.add(hmDetail.get("manufacturer_id")); //added for MO-CRF-20165 
				alDtlRecord.add(hmDetail.get("remarks_desc")); 
				alDtlRecord.add(hmDetail.get("catalog_code")); //end 
				alDtlRecord.add(hmDetail.get("manufac_remarks"));//MO-CRF-20178 
				alDtlData.add(alDtlRecord);

				/*alDtlPOrequestRecord.add(grn_qty);
				alDtlPOrequestRecord.add(hmDetail.get("pur_uom_code"));
				alDtlPOrequestRecord.add(hmDetail.get("item_qty_normal"));
				alDtlPOrequestRecord.add(hmCommon.get("login_by_id"));
				alDtlPOrequestRecord.add(hmCommon.get("login_at_ws_no"));
				alDtlPOrequestRecord.add(hmCommon.get("login_facility_id"));
				alDtlPOrequestRecord.add(hmCommon.get("login_facility_id"));
				alDtlPOrequestRecord.add(hmHeader.get("po_no"));
				alDtlPOrequestRecord.add(hmDetail.get("doc_srl_no"));
				alDtlPOrequestRecord.add(hmHeader.get("PO_doc_type_code"));
				alDtlPOrequestData.add(alDtlPOrequestRecord);*/



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
// Added on 4/20/2005 by Ram to update the last purchase cost...
					ArrayList alPaForPcost	=	new ArrayList();
					alPaForPcost.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
					alPaForPcost.add(hmDetail.get("item_code"));
					hmArgData.put(DATA,alPaForPcost);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_MM_ITEM_UPDATE_FOR_GRN_LAST_PUR_COST"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					
					throwExceptionWhenFailed(hmResult);

					ArrayList arrforlastcost	=	new ArrayList();
					arrforlastcost.add(hmDetail.get("grn_unit_cost_in_pur_uom"));
					arrforlastcost.add(hmHeader.get("store_code"));
					arrforlastcost.add(hmDetail.get("item_code"));
					hmArgData.put(DATA,arrforlastcost);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_ST_ITEM_STORE_UPDATE_FOR_GRN_LAST_PUR_COST"));
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
					rec_high_no = rec_high_no + 1;
					
					//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
					ArrayList alPaForPurUom	=	new ArrayList();
					alPaForPurUom.add(hmDetail.get("pur_uom_code"));
					alPaForPurUom.add(hmDetail.get("item_code"));
					hmArgData.put(DATA,alPaForPurUom);
					hmArgSQL.put(UPDATE_SQL, hmSQL.get("SQL_MM_ITEM_UPDATE_PUR_UOM"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					//ends
				}

		
				/*added for Po details update in PR and Po related tables*/

				if(isPOApplicable){
						double grn_qty_minus_bonus = 0;
						String pur_req_no ="";
						String pur_req_doc_srl_no="";
						String po_no="";
						String do_no="";
						String pur_req_store_code="";
						for (int p=0;p<alPoDtl.size() ;p++ ) {
							 alTemp		= (HashMap)alPoDtl.get(p);
							 
							if(((String)hmDetail.get("item_code")).equals((String)alTemp.get("item_code"))) {
								
								alPoRecord = new ArrayList();
								
								 pur_req_no			= checkForNull((String)alTemp.get("pur_req_no"));
								 pur_req_doc_srl_no = checkForNull((String)alTemp.get("pur_req_doc_srl_no"));
								 po_no				= checkForNull((String)alTemp.get("po_number"));
								 do_no				= checkForNull((String)alTemp.get("do_no"));//added for CRF 113 
								 pur_req_store_code = checkForNull((String)alTemp.get("store_code"));

								 if(pur_req_no.equals(""))
									pur_req_store_code = "*A";

								if(!(pur_req_no).equals("")  && !(pur_req_doc_srl_no).equals("")){
								alPoRecord.add((String)alTemp.get("grn_item_qty"));
								alPoRecord.add((String)hmDetail.get("pur_uom_code")); 
								alPoRecord.add((String)alTemp.get("grn_item_qty"));
								alPoRecord.add((String)hmCommon.get("login_by_id"));
								alPoRecord.add((String)hmCommon.get("login_at_ws_no"));
								alPoRecord.add((String)hmCommon.get("login_facility_id"));
								alPoRecord.add((String)alTemp.get("pur_req_facility_id"));
								alPoRecord.add((String)alTemp.get("pur_req_no"));
								alPoRecord.add((String)alTemp.get("pur_req_doc_srl_no"));						

								alPoRecords.add(alPoRecord);
								}

								alPoRecord1 = new ArrayList();
								
								if(!(po_no).equals("") && !(po_no).equals("*A")){
								alPoRecord1.add((String)alTemp.get("grn_item_qty"));
								alPoRecord1.add((String)hmDetail.get("pur_uom_code")); 
								alPoRecord1.add((String)hmDetail.get("pur_uom_conv"));
								alPoRecord1.add((String)alTemp.get("poitemStatus"));
								alPoRecord1.add((String)hmCommon.get("login_by_id"));
								alPoRecord1.add((String)hmCommon.get("login_at_ws_no"));
								alPoRecord1.add((String)hmCommon.get("login_facility_id"));
								alPoRecord1.add((String)alTemp.get("pur_unit_code"));
								alPoRecord1.add((String)alTemp.get("po_number")); 
								alPoRecord1.add((String)alTemp.get("pur_req_facility_id"));
								//alPoRecord1.add((String)alTemp.get("store_code"));
								alPoRecord1.add(pur_req_store_code);
								alPoRecord1.add((String)alTemp.get("item_code"));
								alPoRecord1.add((String)alTemp.get("po_doc_srl_no"));

								alPoRecords1.add(alPoRecord1);
								}

								alPoRecord2 = new ArrayList();//this is for unfinalized transaction
								
									if(pur_req_no.equals(""))
										pur_req_no = "*A";

									if(po_no.equals(""))
										po_no = "*A";

									if(do_no.equals(""))
										do_no = "*A";

								alPoRecord2.add(hmHeader.get("facility_id"));
								alPoRecord2.add(hmHeader.get("doc_type_code")); 
								alPoRecord2.add(hmHeader.get("doc_no"));
								alPoRecord2.add((String)alTemp.get("po_number"));
								alPoRecord2.add(pur_req_no);
								alPoRecord2.add(hmDetail.get("item_code"));
								alPoRecord2.add((String)alTemp.get("grn_item_qty"));
								alPoRecord2.add(do_no);//added for CRF 113 
								alPoRecord2.add((String)hmCommon.get("login_by_id"));
								alPoRecord2.add((String)hmCommon.get("login_at_ws_no"));
								alPoRecord2.add((String)hmCommon.get("login_facility_id"));
								alPoRecord2.add((String)hmCommon.get("login_by_id"));
								alPoRecord2.add((String)hmCommon.get("login_at_ws_no"));
								alPoRecord2.add((String)hmCommon.get("login_facility_id"));

								alPoRecords2.add(alPoRecord2);

							}

						}
						//added for do table update

						ArrayList hmDoDtlRecords	=	(ArrayList)hmDoDtl.get(((String)hmDetail.get("item_code")));

					if(hmDoDtlRecords != null && hmDoDtlRecords.size()>0){
						for(int d=0;d<hmDoDtlRecords.size();d++){
							HashMap hmDoRecord = (HashMap)hmDoDtlRecords.get(d);
							
							alDoRecord = new ArrayList();
							alDoRecord1 = new ArrayList();
							
							if(((String)hmDoRecord.get("do_no")).equals(""))
								continue;

								grn_qty_minus_bonus = Double.parseDouble((String)hmDoRecord.get("grn_item_qty")) - Double.parseDouble(checkForNull((String)hmDoRecord.get("do_qty_bonus"),"0"));

								//alDoRecord.add((String)hmDoRecord.get("grn_item_qty"));
								alDoRecord.add(""+grn_qty_minus_bonus);
								alDoRecord.add((String)hmDetail.get("pur_uom_code"));
								alDoRecord.add((String)hmDetail.get("pur_uom_conv"));
								alDoRecord.add((String)hmCommon.get("login_by_id"));								
								alDoRecord.add((String)hmCommon.get("login_at_ws_no"));
								alDoRecord.add((String)hmCommon.get("login_facility_id"));
								alDoRecord.add((String)hmDoRecord.get("do_no"));
								alDoRecord.add((String)hmDoRecord.get("item_code"));
								alDoRecord.add((String)hmDoRecord.get("do_srl_no"));
								alDoRecord.add((String)hmDoRecord.get("sch_delv_date"));
								alDoRecord.add((String)hmDoRecord.get("po_no"));
								alDoRecord.add((String)hmDoRecord.get("po_srl_no"));
								alDoRecord.add(((String)hmDoRecord.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
								alDoRecord.add((String)hmDoRecord.get("expiry_date_or_receipt_date"));
								alDoRecord.add((String)hmDoRecord.get("dist_facility_id"));
								alDoRecord.add((String)hmDoRecord.get("dist_store_code"));								

								alDoRecords.add(alDoRecord);

								//this is for unfinalized - updating the block qty in do dtl batch table
								//alDoRecord1.add((String)hmDoRecord.get("grn_item_qty"));
								alDoRecord1.add(""+grn_qty_minus_bonus);
								alDoRecord1.add((String)hmCommon.get("login_by_id"));								
								alDoRecord1.add((String)hmCommon.get("login_at_ws_no"));
								alDoRecord1.add((String)hmCommon.get("login_facility_id"));
								alDoRecord1.add((String)hmDoRecord.get("do_no"));
								alDoRecord1.add((String)hmDoRecord.get("item_code"));
								alDoRecord1.add((String)hmDoRecord.get("do_srl_no"));
								alDoRecord1.add((String)hmDoRecord.get("sch_delv_date"));
								alDoRecord1.add((String)hmDoRecord.get("po_no"));
								alDoRecord1.add((String)hmDoRecord.get("po_srl_no"));
								alDoRecord1.add(((String)hmDoRecord.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
								alDoRecord1.add((String)hmDoRecord.get("expiry_date_or_receipt_date"));
								alDoRecord1.add((String)hmDoRecord.get("dist_facility_id"));
								alDoRecord1.add((String)hmDoRecord.get("dist_store_code"));								

								alDoRecords1.add(alDoRecord1);


						}
					}
			}			
					/*ended*/

			}
			if(isPOApplicable){
				if(isFinalized){
					if(alPoRecords.size()>0){
					hmArgData.put(DATA,alPoRecords);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_REQUEST_DETAIL_GRN_QTY"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}
					if(alPoRecords1.size()>0){
					hmArgData.put(DATA,alPoRecords1);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_FCY_DTL_GRN_QTY"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}
					
					if(hmData.containsKey("NextDelDateData")){
					alPoHdr = (ArrayList)	hmData.get("NextDelDateData");

					ArrayList NextDeldateUpdate  = new ArrayList();
					
					NextDeldateUpdate.add((String)alPoHdr.get(0));
					NextDeldateUpdate.add((String)hmCommon.get("login_by_id"));
					NextDeldateUpdate.add((String)hmCommon.get("login_at_ws_no"));
					NextDeldateUpdate.add((String)hmCommon.get("login_facility_id"));
					NextDeldateUpdate.add((String)alPoHdr.get(1));			

					hmArgData.put(DATA,NextDeldateUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_HDR_FOR_NEXT_DEL_DATE"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}

					if(alDoRecords.size()>0){
					hmArgData.put(DATA,alDoRecords);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_QTY"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}


				}else{
					if(alPoRecords2.size()>0){
						ArrayList alCount = null;
						ArrayList alUpdate = null;
						for(int u=0;u<alPoRecords2.size();u++){
							ArrayList temp = (ArrayList)alPoRecords2.get(u);
							alCount = new ArrayList();
							alUpdate = new ArrayList();
							
							alCount.add(temp.get(0));
							alCount.add(temp.get(1));
							alCount.add(temp.get(2));
							alCount.add(temp.get(3));
							alCount.add(temp.get(4));
							alCount.add(temp.get(5));
							alCount.add(temp.get(7));
							
							int Count	=	Integer.parseInt((String)fetchRecord(connection,(String)hmSQL.get("SQL_COUNT_PO_ORDER_UNF_GRN_RECORDS"),alCount).get("COUNT"));

							if(Count>0){
								alUpdate.add(temp.get(6));	
								alUpdate.add(temp.get(0));
								alUpdate.add(temp.get(1));
								alUpdate.add(temp.get(2));
								alUpdate.add(temp.get(3));
								alUpdate.add(temp.get(4));
								alUpdate.add(temp.get(5));
								alUpdate.add(temp.get(7));
								hmArgData.put(DATA,alUpdate);
								hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_UNF_GRN_RECORDS"));
								hmResult	=	update(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);

							}else{
								hmArgData.put(DATA,temp);
								hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS"));
								hmResult	=	insert(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);
							}
						}
					/*
					hmArgData.put(DATA,alPoRecords2);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);*/
					}
					if(alDoRecords1.size()>0){
					hmArgData.put(DATA,alDoRecords1);
					hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_BLOCK_QTY"));
					hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
					}
				}

				//For Status update of Po dtl and Po hdr 											
						//if(!((String)hmHeader.get("po_no")).equals("")){ // Commented to update status only during finalized
						if(!((String)hmHeader.get("po_no")).equals("") && isFinalized){
						ArrayList PoItemStatusUpdate = new ArrayList();						
						ArrayList PoHdrStatusUpdate = new ArrayList();		
						ArrayList alParameters = null;				
						
						ArrayList getPoDetails	=	fetchRecords(connection,"SELECT PUR_UNIT_CODE,REQ_FACILITY_ID,REQ_STORE_CODE,ITEM_CODE,PO_SRL_NO,PO_QTY,NVL(GRN_QTY,0) GRN_QTY FROM PO_ORDER_FCY_DTL WHERE PO_NO=?", (String)hmHeader.get("po_no"));
						
						boolean hdrstatuscheck =  true;

						for(int k1=0 ; k1 <getPoDetails.size() ;k1++){
						HashMap itemdetail = (HashMap)getPoDetails.get(k1);
						alParameters = new ArrayList();	
						
						double po_qty = Double.parseDouble((String)itemdetail.get("PO_QTY"));
						double grn_qty = Double.parseDouble((String)itemdetail.get("GRN_QTY"));

							if(po_qty<=grn_qty){
								alParameters.add("FR");
							}else{
								alParameters.add("PR");
								hdrstatuscheck = false;
							}

							alParameters.add(itemdetail.get("PUR_UNIT_CODE"));
							alParameters.add(hmHeader.get("po_no"));
							alParameters.add(itemdetail.get("REQ_FACILITY_ID"));
							alParameters.add(itemdetail.get("REQ_STORE_CODE"));
							alParameters.add(itemdetail.get("ITEM_CODE"));
							alParameters.add(itemdetail.get("PO_SRL_NO"));

							PoItemStatusUpdate.add(alParameters);
				
						}
						if(getPoDetails.size()>0){
							if(hdrstatuscheck)
								PoHdrStatusUpdate.add("FR");
							else
								PoHdrStatusUpdate.add("PR");

							PoHdrStatusUpdate.add(hmHeader.get("po_no"));
						}
						
						if(PoItemStatusUpdate.size()>0){	
						hmArgData.put(DATA,PoItemStatusUpdate);
						hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_FCY_DTL_STATUS"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
						if(PoHdrStatusUpdate.size()>0){
						hmArgData.put(DATA,PoHdrStatusUpdate);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_ORDER_HDR_STATUS"));
						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
						}
					}

					//For Status update of Do dtl and Do hdr 											
						//if(!((String)hmHeader.get("do_no")).equals("")){
						if(!((String)hmHeader.get("do_no")).equals("") && isFinalized){

							ArrayList DoItemStatusUpdate = new ArrayList();						
							ArrayList DoHdrStatusUpdate = new ArrayList();		
							ArrayList alParameters = null;				
							
							ArrayList getDoDetails	=	fetchRecords(connection,"SELECT DO_NO,ITEM_CODE,DO_SRL_NO,TO_CHAR(SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE, PO_NO,PO_SRL_NO,SUM(DO_QTY_NORMAL)DO_QTY,SUM(NVL(GRN_QTY,0)) GRN_QTY FROM PO_DELV_ORD_DTL_BAT WHERE DO_NO=? GROUP BY DO_NO,ITEM_CODE,DO_SRL_NO,DO_SRL_NO,SCH_DELV_DATE,PO_NO,PO_SRL_NO", (String)hmHeader.get("do_no"));
							
							boolean hdrstatuscheck =  true;

							for(int k1=0 ; k1 <getDoDetails.size() ;k1++){
							HashMap itemdetail = (HashMap)getDoDetails.get(k1);
							alParameters = new ArrayList();	
							
							double do_qty = Double.parseDouble((String)itemdetail.get("DO_QTY"));
							double grn_qty = Double.parseDouble((String)itemdetail.get("GRN_QTY"));
							

								if(do_qty<=grn_qty){
									alParameters.add("FR");
								}else{
									alParameters.add("PR");
									hdrstatuscheck = false;
								}

								alParameters.add(itemdetail.get("DO_NO"));
								alParameters.add(itemdetail.get("ITEM_CODE"));
								alParameters.add(itemdetail.get("DO_SRL_NO"));
								alParameters.add(itemdetail.get("SCH_DELV_DATE"));
								alParameters.add(itemdetail.get("PO_NO"));
								alParameters.add(itemdetail.get("PO_SRL_NO"));

								DoItemStatusUpdate.add(alParameters);
					
							}

							if(getDoDetails.size()>0){

								if(hdrstatuscheck)
									DoHdrStatusUpdate.add("FR");
								else
									DoHdrStatusUpdate.add("PR");

									DoHdrStatusUpdate.add(hmHeader.get("do_no"));
							}
								if(DoItemStatusUpdate.size()>0){	
								hmArgData.put(DATA,DoItemStatusUpdate);
								hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_DTL_STATUS"));
								hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);
								}
								if(DoHdrStatusUpdate.size()>0){
								hmArgData.put(DATA,DoHdrStatusUpdate);
								hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_UPDATE_PO_DELV_ORD_HDR_STATUS"));
								hmResult	=	update(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmResult);
								}


						}
			}




			hmArgData.put(DATA,alDtlData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_GRN_DTL_INSERT"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			//handle porequest

			/*hmArgData.put(DATA,alDtlPOrequestData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);*/

//exp logic
			alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");
			alExpData	=	new ArrayList();
			ArrayList imageRefRecord	= new ArrayList();//23925
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
				alExpRecord.add(((String)hmExpRecord.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
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
				alExpRecord.add(checkForNull((String)hmExpRecord.get("sale_price")));
				alExpRecord.add(checkForNull((String)hmExpRecord.get("barcode_id")));
				alExpRecord.add(checkForNull((String)hmExpRecord.get("manufactured_date")));//Added for MO-CRF-20165
				//23925 Start.
				alExpRecord.add(checkForNull((String)hmExpRecord.get("fileRef")));//Added for MO-CRF-20171 
				if(!"".equals(checkForNull((String)hmExpRecord.get("fileRef"))))
					imageRefRecord.add(checkForNull((String)hmExpRecord.get("fileRef")));
				//23925 End.
				alExpData.add(alExpRecord);

				if (isFinalized) {
					//Added by suresh.r on 30-01-2014 against #46420 beg
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
					hmParamaters.put("batch_id",((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
					hmParamaters.put("expiry_date_or_receipt_date",hmExpRecord.get("expiry_date_or_receipt_date"));
					hmParamaters.put("trade_id",hmExpRecord.get("trade_id"));
					hmParamaters.put("from_bin_location_code",hmExpRecord.get("bin_location_code"));
					hmParamaters.put("suspended_batch_allowed_yn","Y");
					hmParamaters.put("release_batch_yn","N");
					hmParamaters.put("sale_price",checkForNull((String)hmExpRecord.get("sale_price")));
					hmParamaters.put("barcode_id",checkForNull((String)hmExpRecord.get("barcode_id")));
					

					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("item_code"));
//added for GRN field updation on Thursday, September 04, 2003					
					hmParamaters.put("trn_qty",""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("grn_item_qty"));
					hmParamaters.put("grn_doc_type_code",	hmHeader.get("doc_type_code"));
					hmParamaters.put("grn_doc_no",			hmHeader.get("doc_no"));
					hmParamaters.put("grn_doc_srl_no",		hmExpRecord.get("doc_srl_no"));
					hmParamaters.put("grn_unit_cost_in_stk_uom",hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));
					hmParamaters.put("replace_on_expiry_yn",hmTempItemInfo.get("replace_on_expiry_yn"));

					hmParamaters.put("last_receipt_date",	hmHeader.get("receipt_date")); // doc_date
					hmParamaters.put("po_no",				hmHeader.get("po_no")); // doc_date

					hmParamaters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParamaters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParamaters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					hmParamaters.put("supp_code",	checkForNull(hmHeader.get("supp_code")));

					hmParamaters.put("pur_uom_code",	checkForNull(hmTempItemInfo.get("pur_uom_code")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
					hmParamaters.put("pur_uom_conv",	checkForNull(hmTempItemInfo.get("pur_uom_conv")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012



					updateBatchOnLine(connection, hmSQL, hmParamaters);
					//Added by suresh.r on 30-01-2014 against #46420 end
	//Calling Billing Procedure to update the sale price in billing tables.8/11/2008
					if(!(((String)hmExpRecord.get("sale_price")).equals(""))){
						//CallableStatement callableStatement = null;
						//Added by suresh.r on 30-01-2014 against #46420 beg
						String stSQL = eST.Common.StEJBRepository.getStKeyValue("SQL_ST_BATCH_CONTROL_SELECT_BATCH_COST");
						ArrayList Parameters = new ArrayList();
						Parameters.add(hmExpRecord.get("item_code"));
						Parameters.add(((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
						Parameters.add(hmExpRecord.get("expiry_date_or_receipt_date"));
						hmResult		= fetchRecord(connection, stSQL, Parameters);
						String batch_cost=setNumber(""+checkForNull(hmResult.get("BATCH_COST"),"0"),noOfDecimalsForCost);
						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?) }");
						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?) }");
						//Added by suresh.r on 30-01-2014 against #46420 end
						callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?,?) }");//AMS-SCF-0277.1
						callableStatement.setString(1, (String)hmExpRecord.get("item_code"));
						callableStatement.setString(2, (String)hmExpRecord.get("trade_id"));
						callableStatement.setString(3, ((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
						callableStatement.setString(4, (String)hmExpRecord.get("sale_price"));
						callableStatement.setString(5, (String)hmCommon.get("login_by_id"));
						callableStatement.setString(6, (String)hmCommon.get("login_at_ws_no"));
						callableStatement.registerOutParameter(7, Types.VARCHAR);//Error Code
						callableStatement.registerOutParameter(8, Types.VARCHAR);//sys message id
						callableStatement.registerOutParameter(9, Types.VARCHAR);//error text
						callableStatement.setString(10, batch_cost);//Added by suresh.r on 30-01-2014 against #46420
						callableStatement.setString(11, (String)hmCommon.get("login_facility_id"));//Added for AMS-SCF-0277.1 
						callableStatement.execute();
					/** @ to handle the "UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated " comitted
					if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));*/
						/** @@	To solve the "UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated "  exception  **/
						if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null && !callableStatement.getString(9).equals("UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated") &&callableStatement.getString(7).equals("10")))
							throw new Exception (callableStatement.getString(9));
					}
					closeStatement(callableStatement);
					/*Commented by suresh.r on 30-01-2014 against #46420 beg
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
					hmParamaters.put("sale_price",checkForNull((String)hmExpRecord.get("sale_price")));
					hmParamaters.put("barcode_id",checkForNull((String)hmExpRecord.get("barcode_id")));
					

					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("item_code"));
//added for GRN field updation on Thursday, September 04, 2003					
					hmParamaters.put("trn_qty",""+(Double.parseDouble((String)hmExpRecord.get("grn_item_qty"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("grn_item_qty"));
					hmParamaters.put("grn_doc_type_code",	hmHeader.get("doc_type_code"));
					hmParamaters.put("grn_doc_no",			hmHeader.get("doc_no"));
					hmParamaters.put("grn_doc_srl_no",		hmExpRecord.get("doc_srl_no"));
					hmParamaters.put("grn_unit_cost_in_stk_uom",hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));
					hmParamaters.put("replace_on_expiry_yn",hmTempItemInfo.get("replace_on_expiry_yn"));

					hmParamaters.put("last_receipt_date",	hmHeader.get("receipt_date")); // doc_date
					hmParamaters.put("po_no",				hmHeader.get("po_no")); // doc_date

					hmParamaters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParamaters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParamaters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					hmParamaters.put("supp_code",	checkForNull(hmHeader.get("supp_code")));

					hmParamaters.put("pur_uom_code",	checkForNull(hmTempItemInfo.get("pur_uom_code")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
					hmParamaters.put("pur_uom_conv",	checkForNull(hmTempItemInfo.get("pur_uom_conv")));//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012



					updateBatchOnLine(connection, hmSQL, hmParamaters);
					Commented by suresh.r on 30-01-2014 against #46420 end
					//updateBatchHistoryOnLine(connection, hmSQL, hmParamaters); //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
*////
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
					ItemTrnDtlRecord.add(((String)hmExpRecord.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
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
		//	}
			}
			}
			hmArgData.put(DATA,alExpData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_INSERT"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			//23925 Start.
			if(imageRefRecord.size()>0){				 
				hmResult	=uploadDocuments(connection,logginFacility,imageRefRecord);
				throwExceptionWhenFailed(hmResult);
			}
			//23925 End.
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
			//hmResult.put("doc_no",hmHeader.get("doc_no"));
			if(item_class_based.equals("Y")){
				k = k + alItemClassCount.get(j);
			}else{
				k=k+records_per_trn;
			}

		}
			connection.commit();
			//connection.rollback();
		if (connection!=null) {
					closeConnection(connection,properties);	
		}
		
		
		}
		catch (Exception exception) {
			try{
				System.out.println("hmData==GRN Insert"+hmData);
				System.err.println("hmData==GRN Insert"+hmData);
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());
			hmResult.put("flag",rec_high_no+"");
			

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
	hmResult.put("doc_no",doc_no);
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

	//	String	facility_id         	=	(String)hmColumns.get("facility_id");
		String	item_code           	=	(String)hmColumns.get("item_code");
		String	store_code          	=	(String)hmColumns.get("store_code");
		String	month_closing_qty   	=	(String)hmColumns.get("trn_qty");
//		String	month_closing_value 	=	(String)hmColumns.get("trn_unit_cost");

		String	grn_qty             	=	(String)hmColumns.get("trn_qty");

		String	trn_unit_cost 			=	(String)hmColumns.get("trn_unit_cost");
		/**
		 * @Name - Priya
		 * @Date - 25/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
		String	month_closing_value 	=	setNumber(""+(getNumber(trn_unit_cost)*getNumber(grn_qty)),noOfDecimalsForCost);
		System.out.println("************ Month_closing_value **************: " +month_closing_value);
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

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
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
	//23925 Start.
	public HashMap  uploadDocuments(Connection connection,String sFacilityId,ArrayList imageRefRecord) throws Exception{
		HashMap				hmReturn			=	new HashMap();
		StringBuffer sb = new StringBuffer();		
		int iDocFolderOption = 0; 
		String sDocSharedPath = "";
		String sWebServiceUrl = ""; 
		String sDocType=""; 
		int nDocConfigListsize = 0;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
System.err.println("====uploadDocuments"+imageRefRecord.size());
		try {
			for(int i=0;i<imageRefRecord.size();i++){
				if(i!=0)
					sb.append(",");
				sb.append("'"+imageRefRecord.get(i)+"'");				
			}
			
			List<DocumentConfigBean> oDocConfigList = null;
			DocumentConfigBean oDocumentConfigBean = null;	
			oDocConfigList = new ArrayList<DocumentConfigBean>();
System.err.println("====uploadDocuments-Before oDocConfigList"+oDocConfigList);				
			oDocConfigList = getDocumentConfigDetails(sFacilityId,"IN","D");
System.err.println("====uploadDocuments-After oDocConfigList"+oDocConfigList);	
			nDocConfigListsize = oDocConfigList.size();
			if (nDocConfigListsize>0)
			{	
				
				oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);					
				sFacilityId 	= oDocumentConfigBean.getsFacilityId();				
				iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();  
				sDocSharedPath = oDocumentConfigBean.getsDocSharedPath();  
				sWebServiceUrl = oDocumentConfigBean.getsDocWebserviceUrl();  
				
				sDocType=oDocumentConfigBean.getsDocType();
System.err.println("====uploadDocuments-After iDocFolderOption"+iDocFolderOption+"sDocSharedPath"+sDocSharedPath+"==sWebServiceUrl"+sWebServiceUrl);				
	
			}    
			else{
				System.out.println("List size is null...document section was not configured..documents will be stored in db"); 						
			}
System.err.println("====2679 uploadDocuments-After iDocFolderOption"+iDocFolderOption);			
			/* O -- Database, 1 -- shared path */
			if(iDocFolderOption==0){
				String insertQuery ="INSERT  INTO ST_GRN_DTL_EXP_DOC SELECT FACILITY_ID,  SEQ_NO, IMAGE_REF, IMAGE_TYPE, IMAGE_NAME, IMAGE_CONTENT,'Y','', ADDED_BY_ID, SYSDATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, SYSDATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID  FROM ST_GRN_DTL_EXP_DOC_TMP WHERE IMAGE_REF IN ("+sb.toString()+")";
				pstmt=connection.prepareStatement(insertQuery);
				int result=pstmt.executeUpdate(); 
				//if(pstmt!=null) pstmt.close();
				closeStatement(pstmt);
				
System.err.println("====2686 uploadDocuments-After result"+result);
				if(result>0){
					String delQuery="DELETE FROM  ST_GRN_DTL_EXP_DOC_TMP WHERE IMAGE_REF IN ("+sb.toString()+")";
					pstmt=connection.prepareStatement(delQuery);
					//pstmt.setString(1, sb.toString());	
					pstmt.executeUpdate(); 
					//if(pstmt!=null) pstmt.close();
					closeStatement(pstmt);
 
				}
			}else{
				String insertQuery ="INSERT  INTO ST_GRN_DTL_EXP_DOC SELECT FACILITY_ID,  SEQ_NO, IMAGE_REF, IMAGE_TYPE, IMAGE_NAME, empty_blob(),'N','"+sDocSharedPath+"', ADDED_BY_ID, SYSDATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, SYSDATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID FROM ST_GRN_DTL_EXP_DOC_TMP WHERE IMAGE_REF IN ("+sb.toString()+")";
				pstmt=connection.prepareStatement(insertQuery);
				int result=pstmt.executeUpdate(); 
				//if(pstmt!=null) pstmt.close();
				closeStatement(pstmt);
System.err.println("====2700 uploadDocuments-After result"+result);				
				String selectQuery = "SELECT IMAGE_NAME,IMAGE_CONTENT FROM  ST_GRN_DTL_EXP_DOC_TMP WHERE IMAGE_REF IN ("+sb.toString()+")";
				pstmt=connection.prepareStatement(selectQuery);
				rs=pstmt.executeQuery();
				if(rs!=null){
					while(rs.next()){
						Blob b=rs.getBlob(2);
						byte barr[]=b.getBytes(1,(int)b.length());
						FileOutputStream fout=new FileOutputStream(sDocSharedPath+"/"+(String)rs.getString(1));  
						fout.write(barr);  
						              
						fout.close();  
					}
					
				}
				closeResultSet(rs);
				closeStatement(pstmt);
               
				

				if(result>0){
					String delQuery="DELETE FROM  ST_GRN_DTL_EXP_DOC_TMP WHERE IMAGE_REF IN ("+sb.toString()+")";
					pstmt=connection.prepareStatement(delQuery);
					pstmt.executeUpdate(); 
					//if(pstmt!=null) pstmt.close();
					closeStatement(pstmt);
System.err.println("====2721"+result);	
				}
				
			}
			//hmReturn.put(RESULT,TRUE);	
			
System.err.println("====2737 - FAiling due to not return");			
			//if(iResult!=0){
			hmReturn.put(RESULT,TRUE);
			hmReturn.put(MSGID,RECORD_INSERTED);
			hmReturn.put(MESSAGE,RECORD_INSERTED);
System.err.println("====Now it should be fine");				
			//}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
System.err.println("====2730 Exception");
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,e.getMessage());
			hmReturn.put(MESSAGE,e.toString());
			e.printStackTrace();
			
		} finally{
			
				try {
						//if(pstmt!=null)
							//pstmt.close();
					closeResultSet(rs);
					closeStatement(pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return hmReturn;
		
	}
	/*
	 * This method is used to get the patient photo stored in the shared folder.(PatientPhotoServlet.java)
	 * 
	 */
	public List<DocumentConfigBean> getDocumentConfigDetails(String facilityID, String docType ,String filecategory) throws Exception {
		List<DocumentConfigBean> sDocConfigList = new ArrayList<DocumentConfigBean>() ;

		String sFacilityID = "";
		sFacilityID = facilityID;
		boolean isDebugYN =false;
System.err.println("===getDocumentConfigDetails-facilityID"+facilityID+"==docType==="+docType);	
		if(sFacilityID != null && docType!=null)
		{
			Connection connection 		= null;
			PreparedStatement pStmt		= null;
			ResultSet resultSet 		= null;
		
        	StringBuffer smSqlQuery = new StringBuffer("");
		    smSqlQuery.append(" select p.facility_id, p.doc_scan_enabled, p.scan_ui_enabled, p.doc_save_as, d.doc_folder_option, d.doc_type, d.doc_shared_path, d.doc_webservice_url, d.file_category, p.PHOTO_FOLDER_OPTION ");
		    smSqlQuery.append(" from SM_PATIENT_DOC_PARAM p, SM_PATIENT_DOC_DTL d ");
			smSqlQuery.append(" where p.FACILITY_ID=? AND d.DOC_TYPE=? AND p.FACILITY_ID=d.FACILITY_ID  ");
			smSqlQuery.append(" and  d.file_category  = ? ");
				
			try {
					isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
System.err.println("===getDocumentConfigDetails-isDebugYN"+isDebugYN);	
				    connection	= ConnectionManager.getConnection() ;
System.err.println("===getDocumentConfigDetails-connection"+connection);
					if(connection != null)
					{
						pStmt = connection.prepareStatement(smSqlQuery.toString());
					}	
					pStmt.setString(1,sFacilityID);
					pStmt.setString(2,docType);
					pStmt.setString(3,filecategory);
					resultSet=pStmt.executeQuery();
					DocumentConfigBean sDocConfig =null;
					
					if(isDebugYN) System.out.println("Get Document Config Details...facility id...."+sFacilityID+" Doc Type ...."+docType+" filecategory....."+filecategory);
System.err.println("===Before resuletset - 2786");					
					if(resultSet != null && resultSet.next())
					{
						if(isDebugYN) System.out.println("prithivi...facility id...."+sFacilityID+" Doc Type ...."+docType+" filecategory....."+filecategory);
						if(isDebugYN) System.out.println("Resultset is not empty");
						sDocConfig = new DocumentConfigBean();
						sDocConfig.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
						sDocConfig.setiDocScanEnabled(resultSet.getInt("doc_scan_enabled")) ; // Scan function enabled/disabled.
						sDocConfig.setiDocScanUIEnabled(resultSet.getInt("scan_ui_enabled")) ; // Scanner UI enabled/disabled.
						sDocConfig.setiDocSaveAs(resultSet.getInt("doc_save_as")) ; //Document save as image/pdf.
						 if(isDebugYN) System.out.println("prithivi...doc save as...."+resultSet.getInt("doc_save_as"));
						sDocConfig.setiDocFolderOption(resultSet.getInt("doc_folder_option")) ; // document to be saved in DB/Shared Path.
						sDocConfig.setsDocType(((resultSet.getString("doc_type") != null) ? resultSet.getString("doc_type") : "")); // document to be saved in DB/Shared Path.
						sDocConfig.setsDocSharedPath(((resultSet.getString("doc_shared_path") != null) ? resultSet.getString("doc_shared_path") : ""));  // Document shared Path.						
						sDocConfig.setsInvSharedpath(((resultSet.getString("doc_shared_path") != null) ? resultSet.getString("doc_shared_path") : ""));//Doc Inventory shared Path. Added by Kamatchi S for MO-CRF-20171.1						
						sDocConfig.setsDocWebserviceUrl(((resultSet.getString("doc_webservice_url") != null) ? resultSet.getString("doc_webservice_url") : ""));
						sDocConfig.setsPhotoDocOption(resultSet.getInt("PHOTO_FOLDER_OPTION")); //Added by bhuvana on 27/05/2019
						sDocConfig.setsFileCategory(resultSet.getString("FILE_CATEGORY")); //Added by bhuvana on 27/05/2019
System.err.println("===ResultSet - 2804");							
						sDocConfigList.add(sDocConfig);
					}
					
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					// if ( resultSet != null ) resultSet.close() ;	
					// if ( pStmt != null ) pStmt.close() ;
					 closeResultSet(resultSet);
					 closeStatement(pStmt);
						
					 ConnectionManager.returnConnection(connection);
			}
		}
		return sDocConfigList;
	}
	//23925 End.
}
