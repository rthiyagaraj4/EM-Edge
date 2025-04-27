/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.GoodsReturnToVendor;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="GoodsReturnToVendor"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="GoodsReturnToVendor"
*	local-jndi-name="GoodsReturnToVendor"
*	impl-class-name="eST.GoodsReturnToVendor.GoodsReturnToVendorManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.GoodsReturnToVendor.GoodsReturnToVendorLocal"
*	remote-class="eST.GoodsReturnToVendor.GoodsReturnToVendorRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.GoodsReturnToVendor.GoodsReturnToVendorLocalHome"
*	remote-class="eST.GoodsReturnToVendor.GoodsReturnToVendorHome"
*	generate= "local,remote"
*
*
*/

public class GoodsReturnToVendorManager extends StEJBSessionAdapter {
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL) { //throws RemoteException
        Connection connection = null;
		Properties properties=null;

		HashMap		hmResult	=	new HashMap();

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();

		HashMap		hmCommon	=	new HashMap();
		HashMap		hmPKData	=	new HashMap();

		ArrayList	alData		=	new ArrayList();
		String stLastItem		=	"";
		try{
			properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmPKData		=	(HashMap)	hmData.get("DATA");
			hmCommon		=	(HashMap)	hmData.get("COMMON_DATA");

			alData.add(hmPKData.get("facility_id"));	//facility_id
			alData.add(hmPKData.get("doc_type_code"));	//doc_type_code
			alData.add(hmPKData.get("doc_no"));	//doc_no
			alData.add("%");//put doc_srl_no at last..

			ArrayList alRecords	=	fetchRecords(connection, (String)hmSQL.get("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL"), alData);
			

			for (int j=0; j<alRecords.size(); j++) {
				HashMap hmRecord	=	(HashMap)alRecords.get(j);
				HashMap hmParameter	=	new HashMap();
				hmParameter.put("store_code",hmRecord.get("STORE_CODE"));
				hmParameter.put("item_code",hmRecord.get("ITEM_CODE"));
				hmParameter.put("batch_id",hmRecord.get("BATCH_ID"));
				hmParameter.put("bin_location_code",hmRecord.get("BIN_LOCATION_CODE"));
				hmParameter.put("expiry_date_or_receipt_date",hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				hmParameter.put("trn_qty",hmRecord.get("ITEM_QTY"));
				hmParameter.put("login_by_id",hmCommon.get("login_by_id"));
				hmParameter.put("login_at_ws_no",hmCommon.get("login_at_ws_no"));
				hmParameter.put("login_facility_id",hmCommon.get("login_facility_id"));

				hmResult	=	blockReleaseBatch(connection, hmParameter, 'R');
				throwExceptionWhenFailed(hmResult);

/////
				if (!stLastItem.equals((String)hmRecord.get("ITEM_CODE"))) {
					String []stParameters	=	{(String)hmPKData.get("facility_id"),(String)hmPKData.get("doc_type_code"),(String)hmPKData.get("doc_no"),(String)hmRecord.get("ITEM_CODE")};
					HashMap hmRTVDtlQty	=	fetchRecord(connection,  (String)hmSQL.get("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE"), stParameters);
					ArrayList alDtlUpdate	=	new ArrayList();
					alDtlUpdate.add("-"+hmRTVDtlQty.get("ITEM_QTY_NORMAL"));
					alDtlUpdate.add("-"+getNumber(hmRTVDtlQty.get("ITEM_QTY_BONUS")));
					alDtlUpdate.add("");//hmDetail.get("item_qty_sample"));
					alDtlUpdate.add(hmCommon.get("login_by_id"));      
					alDtlUpdate.add(hmCommon.get("login_at_ws_no"));   
					alDtlUpdate.add(hmCommon.get("login_facility_id"));
					alDtlUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alDtlUpdate.add(hmRecord.get("GRN_DOC_TYPE_CODE"));
					alDtlUpdate.add(hmRecord.get("GRN_DOC_NO"));
					alDtlUpdate.add(hmRecord.get("ITEM_CODE"));

					hmArgData.put(DATA,alDtlUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				}

				stLastItem	=	(String)hmRecord.get("ITEM_CODE");

                    //substract qty in exp table
					ArrayList alExpUpdate	=	new ArrayList();

					alExpUpdate.add("-"+hmRecord.get("ITEM_QTY"));
					alExpUpdate.add(hmCommon.get("login_by_id"));      
					alExpUpdate.add(hmCommon.get("login_at_ws_no"));   
					alExpUpdate.add(hmCommon.get("login_facility_id"));

					alExpUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alExpUpdate.add(hmRecord.get("GRN_DOC_TYPE_CODE"));
					alExpUpdate.add(hmRecord.get("GRN_DOC_NO"));

					alExpUpdate.add(hmRecord.get("STORE_CODE"));
					alExpUpdate.add(hmRecord.get("ITEM_CODE"));
					alExpUpdate.add(hmRecord.get("BATCH_ID"));
					alExpUpdate.add(hmRecord.get("PREV_BIN_LOCATION_CODE"));
					alExpUpdate.add(hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					alExpUpdate.add(hmRecord.get("TRADE_ID"));

					hmArgData.put(DATA,alExpUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

			
			}

			alData.remove(3);//remove doc_srl_no

/*
			//////////////
				if (iMode!=1) {
					String []stParameters	=	{(String)hmHeader.get("facility_id"),(String)hmHeader.get("doc_type_code"),(String)hmHeader.get("doc_no"),(String)hmDetail.get("item_code")};
					HashMap hmRTVDtlQty	=	fetchRecord(connection,  (String)hmSQL.get("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE"), stParameters);
					ArrayList alDtlUpdate	=	new ArrayList();
					alDtlUpdate.add("-"+hmRTVDtlQty.get("ITEM_QTY_NORMAL"));
					alDtlUpdate.add("-"+getNumber(hmRTVDtlQty.get("ITEM_QTY_BONUS")));
					alDtlUpdate.add("");//hmDetail.get("item_qty_sample"));
					alDtlUpdate.add(hmCommon.get("login_by_id"));      
					alDtlUpdate.add(hmCommon.get("login_at_ws_no"));   
					alDtlUpdate.add(hmCommon.get("login_facility_id"));
					alDtlUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alDtlUpdate.add(grn_doc_type);
					alDtlUpdate.add(grn_doc_no);
					alDtlUpdate.add(hmDetail.get("item_code"));

					hmArgData.put(DATA,alDtlUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				}				
				//////////////
	


*/


			hmArgData.put(DATA, alData);

			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_RTV_DTL_EXP_DELETE_ALL"));
			hmResult	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_RTV_DTL_DELETE_ALL"));
			hmResult	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_RTV_HDR_DELETE"));
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


	public HashMap modify(HashMap hmData, HashMap hmSQL) { //throws RemoteException

        Connection connection = null;
		Properties properties=null;

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
//		ArrayList	alDtlData	=	new ArrayList();
//		ArrayList	alDtlRecords=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
//		ArrayList	alExpRecords=	new ArrayList();
		ArrayList	alItemTrnDtl=	new ArrayList();
		ArrayList	languageData=	new ArrayList();
		String stCurrentItemCodeInCaseOfError=null;
		ArrayList doc_no	=	new ArrayList();

		boolean isFinalized		=	false;
        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmCommon			=	(HashMap)	hmData.get("COMMON_DATA");
			hmHeader			=	(HashMap)	hmData.get("HDR_DATA");
			languageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			isFinalized			=	((String)	hmHeader.get("finalized_yn")).equals("Y");

			alHdrData.add(hmHeader.get("doc_date"));
			alHdrData.add(hmHeader.get("doc_ref"));
			alHdrData.add(hmHeader.get("store_code"));
			alHdrData.add(hmHeader.get("supp_code"));
			alHdrData.add(hmHeader.get("finalized_yn"));
			alHdrData.add(hmHeader.get("gl_interfaced_yn"));
			alHdrData.add(hmHeader.get("trn_type"));
			alHdrData.add(hmHeader.get("entry_completed_yn"));
	
			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));

//added on 19_07_2004
            alHdrData.add(hmHeader.get("replacement_grn_yn"));

			alHdrData.add(hmHeader.get("facility_id"));
			alHdrData.add(hmHeader.get("doc_type_code"));
			alHdrData.add(hmHeader.get("doc_no"));
			doc_no.add((String)hmHeader.get("doc_no"));



			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_RTV_HDR_UPDATE"));
			hmResult	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

//dtl logic
			alDetail	=	(ArrayList)	hmData.get("DTL_DATA");


			for (int i=0;i<alDetail.size() ;i++ ) {
				HashMap hmDetail		=	(HashMap)alDetail.get(i);
				stCurrentItemCodeInCaseOfError=(String)hmDetail.get("item_code");
				ArrayList alDtlRecord	=	new ArrayList();
				int iMode	=	Integer.parseInt((String)hmDetail.get("mode"));

				alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");
				double averageUnitCost	=	0.0;
				String grn_doc_type	="";
				String grn_doc_no	="";
				String pur_uom_conv	=	"";
				String pur_uom_code	=	"";
				int totalRecords	=	0;
				double unit_cost	=	0.0;
				double totalValue	=	0.0;
				double totalQty		=	0;
				for (int j=0;j<alExp.size() ;j++ ) {
					HashMap hmExpRecord		= (HashMap)alExp.get(j);
					if((((String)hmExpRecord.get("doc_srl_no")).equals((String)hmDetail.get("doc_srl_no")))&& (((String)hmExpRecord.get("ITEM_CODE")).equals((String)hmDetail.get("item_code")))){
						grn_doc_type	=(String)hmExpRecord.get("GRN_DOC_TYPE_CODE");
						grn_doc_no	=(String)hmExpRecord.get("GRN_DOC_NO");
						pur_uom_conv=(String)hmExpRecord.get("PUR_UOM_CONV");
						pur_uom_code=(String)hmExpRecord.get("PUR_UOM_CODE");
						unit_cost	=unit_cost+Double.parseDouble((String)hmExpRecord.get("GRN_UNIT_COST_IN_PUR_UOM"));//RTV_ITEM_QTY;
						totalValue	=totalValue+Double.parseDouble((String)hmExpRecord.get("GRN_UNIT_COST_IN_PUR_UOM"))*Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"));
						totalRecords=totalRecords+1;
						totalQty=totalQty+Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"));
					}
				}
				//averageUnitCost	=	unit_cost/totalRecords;
				averageUnitCost	=	totalValue/totalQty;
				if (iMode!=1 &&!(grn_doc_type.equals(""))) {
					String []stParameters	=	{(String)hmHeader.get("facility_id"),(String)hmHeader.get("doc_type_code"),(String)hmHeader.get("doc_no"),(String)hmDetail.get("item_code")};
					HashMap hmRTVDtlQty	=	fetchRecord(connection,  (String)hmSQL.get("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE"), stParameters);

					ArrayList alDtlUpdate	=	new ArrayList();
					alDtlUpdate.add("-"+hmRTVDtlQty.get("ITEM_QTY_NORMAL"));
					alDtlUpdate.add("-"+getNumber(hmRTVDtlQty.get("ITEM_QTY_BONUS")));
					alDtlUpdate.add("");//hmDetail.get("item_qty_sample"));
					alDtlUpdate.add(hmCommon.get("login_by_id"));      
					alDtlUpdate.add(hmCommon.get("login_at_ws_no"));   
					alDtlUpdate.add(hmCommon.get("login_facility_id"));
					alDtlUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alDtlUpdate.add(grn_doc_type);
					alDtlUpdate.add(grn_doc_no);
					alDtlUpdate.add(hmDetail.get("item_code"));

					hmArgData.put(DATA,alDtlUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				}				

				if(!(pur_uom_conv.equals(""))){
					double rtv_qty	=	getNumber(hmDetail.get("item_qty_normal"))+getNumber(hmDetail.get("item_qty_bonus"));
					hmDetail.put("rtv_qty",""+(double)rtv_qty);
					hmDetail.put("pur_uom_conv",pur_uom_conv);
					hmDetail.put("pur_uom_code",pur_uom_code);
					double rtv_qty_in_stk_uom	=	rtv_qty*Double.parseDouble(pur_uom_conv);
					hmDetail.put("rtv_qty_in_stk_uom",""+(double)rtv_qty_in_stk_uom);
					double rtv_unit_cost=	averageUnitCost;
	//				double rtv_unit_cost_in_stk_uom=	rtv_unit_cost/Long.parseLong(pur_uom_conv);
	//				double rtv_unit_cost=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/rtv_qty;;
					/**
					 * @Name - Priya
					 * @Date - 28/05/2010
					 * @Inc# - 
					 * @Desc -  To get no of decimals for cost  
					 */
					int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
					hmDetail.put("rtv_unit_cost",setNumber(""+rtv_unit_cost,noOfDecimalsForCost));
					hmDetail.put("rtv_qty_in_stk_uom",""+(double)rtv_qty_in_stk_uom);
					hmDetail.put("rtv_unit_cost_in_stk_uom",setNumber(""+(rtv_unit_cost/Double.parseDouble(pur_uom_conv)),noOfDecimalsForCost));

					hmDetail.put("item_cost_value",setNumber(""+Double.parseDouble((String)hmDetail.get("rtv_unit_cost"))*rtv_qty,noOfDecimalsForCost));
					double stk_qty_str	=rtv_qty_in_stk_uom/Double.parseDouble((String)hmDetail.get("to_conv_fact"));
					hmDetail.put("stk_qty_str",""+(double)stk_qty_str);
				}
/*				
				double rtv_qty	=	getNumber(hmDetail.get("item_qty_normal"))+getNumber(hmDetail.get("item_qty_bonus"));
				hmDetail.put("rtv_qty",""+(long)rtv_qty);

				double rtv_unit_cost	=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/rtv_qty;
				hmDetail.put("rtv_unit_cost",""+rtv_unit_cost);
*/				
				switch (iMode){
					case 0:{//delete
						ArrayList alDeleteRecord	=	new ArrayList();

						alDeleteRecord.add(hmHeader.get("facility_id"));	//facility_id
						alDeleteRecord.add(hmHeader.get("doc_type_code"));	//doc_type_code
						alDeleteRecord.add(hmHeader.get("doc_no"));	//doc_no
						alDeleteRecord.add(hmDetail.get("doc_srl_no"));//put doc_srl_no at last..

///release batch
						ArrayList alRecords	=	fetchRecords(connection, (String)hmSQL.get("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL"), alDeleteRecord);

						for (int j=0; j<alRecords.size(); j++) {
							HashMap hmRecord	=	(HashMap)alRecords.get(j);
							HashMap hmParameter	=	new HashMap();
							hmParameter.put("store_code",hmRecord.get("STORE_CODE"));
							hmParameter.put("item_code",hmRecord.get("ITEM_CODE"));
							hmParameter.put("batch_id",hmRecord.get("BATCH_ID"));
							hmParameter.put("bin_location_code",hmRecord.get("BIN_LOCATION_CODE"));
							hmParameter.put("expiry_date_or_receipt_date",hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
							hmParameter.put("trn_qty",hmRecord.get("ITEM_QTY"));
							hmParameter.put("login_by_id",hmCommon.get("login_by_id"));
							hmParameter.put("login_at_ws_no",hmCommon.get("login_at_ws_no"));
							hmParameter.put("login_facility_id",hmCommon.get("login_facility_id"));

							hmResult	=	blockReleaseBatch(connection, hmParameter, 'R');//false to release the batch..
							throwExceptionWhenFailed(hmResult);

						//////////////substract qty in exp table
							ArrayList alExpUpdate	=	new ArrayList();
							alExpUpdate.add("-"+hmRecord.get("ITEM_QTY"));
							alExpUpdate.add(hmCommon.get("login_by_id"));      
							alExpUpdate.add(hmCommon.get("login_at_ws_no"));   
							alExpUpdate.add(hmCommon.get("login_facility_id"));

							alExpUpdate.add(hmCommon.get("login_facility_id"));//facility_id
							alExpUpdate.add(hmRecord.get("GRN_DOC_TYPE_CODE"));
							alExpUpdate.add(hmRecord.get("GRN_DOC_NO"));

							alExpUpdate.add(hmHeader.get("store_code"));
							alExpUpdate.add(hmRecord.get("ITEM_CODE"));
							alExpUpdate.add(hmRecord.get("BATCH_ID"));
							alExpUpdate.add(hmRecord.get("PREV_BIN_LOCATION_CODE"));
							alExpUpdate.add(hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
							alExpUpdate.add(hmRecord.get("TRADE_ID"));

							hmArgData.put(DATA,alExpUpdate);
							hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
							hmResult	=	update(connection, hmArgData, hmArgSQL);
							throwExceptionWhenFailed(hmResult);

						}
						
						hmArgData.put(DATA,alDeleteRecord);
						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_RTV_DTL_EXP_DELETE"));
						hmResult	=	delete(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);

						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_RTV_DTL_DELETE"));
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
                        alDtlRecord.add(""); //item_qty_sample
						alDtlRecord.add(hmDetail.get("item_cost_value"));
						alDtlRecord.add("Y");
						alDtlRecord.add(hmDetail.get("rtv_unit_cost"));
						alDtlRecord.add(hmDetail.get("remarks"));

						alDtlRecord.add(hmCommon.get("login_by_id"));
						alDtlRecord.add(hmCommon.get("login_at_ws_no"));
						alDtlRecord.add(hmCommon.get("login_facility_id"));
						alDtlRecord.add(hmCommon.get("login_by_id"));
						alDtlRecord.add(hmCommon.get("login_at_ws_no"));
						alDtlRecord.add(hmCommon.get("login_facility_id"));
//added on 17_07_2004
                        if(((String)hmHeader.get("replacement_grn_yn")).equals("Y")){
							alDtlRecord.add(hmHeader.get("doc_no"));
							alDtlRecord.add(hmHeader.get("doc_no"));
						}else{
							alDtlRecord.add("0");
							alDtlRecord.add("0");
						}
						
						hmArgData.put(DATA,alDtlRecord);
						hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_RTV_DTL_INSERT"));
						hmResult	=	insert(connection, hmArgData, hmArgSQL);
						break;
					}
					case 2:{//update

						
						ArrayList alDeleteRecord	=	new ArrayList();

						alDeleteRecord.add(hmHeader.get("facility_id"));	//facility_id
						alDeleteRecord.add(hmHeader.get("doc_type_code"));	//doc_type_code
						alDeleteRecord.add(hmHeader.get("doc_no"));	        //doc_no
						alDeleteRecord.add(hmDetail.get("doc_srl_no"));     //put doc_srl_no at last..

                       	ArrayList alRecords	=	fetchRecords(connection, (String)hmSQL.get("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL"), alDeleteRecord);

						for (int j=0; j<alRecords.size(); j++) {
							HashMap hmRecord	=	(HashMap)alRecords.get(j);
							HashMap hmParameter	=	new HashMap();
							hmParameter.put("store_code",hmRecord.get("STORE_CODE"));
							hmParameter.put("item_code",hmRecord.get("ITEM_CODE"));
							hmParameter.put("batch_id",hmRecord.get("BATCH_ID"));
							hmParameter.put("bin_location_code",hmRecord.get("BIN_LOCATION_CODE"));
							hmParameter.put("expiry_date_or_receipt_date",hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
							hmParameter.put("trn_qty",hmRecord.get("ITEM_QTY"));
							hmParameter.put("login_by_id",hmCommon.get("login_by_id"));
							hmParameter.put("login_at_ws_no",hmCommon.get("login_at_ws_no"));
							hmParameter.put("login_facility_id",hmCommon.get("login_facility_id"));

							hmResult	=	blockReleaseBatch(connection, hmParameter, 'R');//false to release the batch..
							throwExceptionWhenFailed(hmResult);

						//////////////substract qty in exp table
							ArrayList alExpUpdate	=	new ArrayList();
							alExpUpdate.add("-"+hmRecord.get("ITEM_QTY"));
							alExpUpdate.add(hmCommon.get("login_by_id"));      
							alExpUpdate.add(hmCommon.get("login_at_ws_no"));   
							alExpUpdate.add(hmCommon.get("login_facility_id"));

							alExpUpdate.add(hmCommon.get("login_facility_id"));//facility_id
							alExpUpdate.add(hmRecord.get("GRN_DOC_TYPE_CODE"));
							alExpUpdate.add(hmRecord.get("GRN_DOC_NO"));

							alExpUpdate.add(hmHeader.get("store_code"));
							alExpUpdate.add(hmRecord.get("ITEM_CODE"));
							alExpUpdate.add(hmRecord.get("BATCH_ID"));
							alExpUpdate.add(hmRecord.get("PREV_BIN_LOCATION_CODE"));
							alExpUpdate.add(hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
							alExpUpdate.add(hmRecord.get("TRADE_ID"));

							hmArgData.put(DATA,alExpUpdate);
							hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
							hmResult	=	update(connection, hmArgData, hmArgSQL);
							throwExceptionWhenFailed(hmResult);

						}

						hmArgData.put(DATA,alDeleteRecord);
						hmArgSQL.put(DELETE_SQL,hmSQL.get("SQL_ST_RTV_DTL_EXP_DELETE"));
						hmResult	=	delete(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);

						alDtlRecord.add(hmDetail.get("item_code"));
						alDtlRecord.add(hmDetail.get("item_qty_normal"));
						alDtlRecord.add(hmDetail.get("item_qty_bonus"));
						alDtlRecord.add("");//hmDetail.get("item_qty_sample"));
						alDtlRecord.add(hmDetail.get("item_cost_value"));

						hmDetail.put("stock_item_yn","Y");

						alDtlRecord.add(hmDetail.get("stock_item_yn"));
						alDtlRecord.add(hmDetail.get("rtv_unit_cost"));
						alDtlRecord.add(hmDetail.get("remarks"));

						alDtlRecord.add(hmCommon.get("login_by_id"));
						alDtlRecord.add(hmCommon.get("login_at_ws_no"));
						alDtlRecord.add(hmCommon.get("login_facility_id"));

//added on 19_07_2004
						alDtlRecord.add(hmDetail.get("item_qty_normal"));
						alDtlRecord.add(hmDetail.get("item_qty_normal"));

						alDtlRecord.add(hmHeader.get("facility_id"));
						alDtlRecord.add(hmHeader.get("doc_type_code"));
						alDtlRecord.add(hmHeader.get("doc_no"));
						alDtlRecord.add(hmDetail.get("doc_srl_no"));

						hmArgData.put(DATA,alDtlRecord);
						hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_RTV_DTL_UPDATE"));

						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);

						break;
					}
				}


				if(iMode!=0) {
					ArrayList alDtlUpdate	=	new ArrayList();
					alDtlUpdate.add(hmDetail.get("item_qty_normal"));
					alDtlUpdate.add(""+getNumber(hmDetail.get("item_qty_bonus")));
					alDtlUpdate.add("");//hmDetail.get("item_qty_sample"));
					alDtlUpdate.add(hmCommon.get("login_by_id"));      
					alDtlUpdate.add(hmCommon.get("login_at_ws_no"));   
					alDtlUpdate.add(hmCommon.get("login_facility_id"));
					alDtlUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alDtlUpdate.add(grn_doc_type);
					alDtlUpdate.add(grn_doc_no);
					alDtlUpdate.add(hmDetail.get("item_code"));

					hmArgData.put(DATA,alDtlUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				}

				HashMap hmTemp	=	new HashMap();
				hmTemp.put("rtv_unit_cost_in_stk_uom", hmDetail.get("rtv_unit_cost_in_stk_uom"));
				hmTemp.put("rtv_unit_cost", hmDetail.get("rtv_unit_cost"));
				hmTemp.put("item_qty_normal", hmDetail.get("item_qty_normal"));
				hmTemp.put("item_qty_bonus", hmDetail.get("item_qty_bonus"));
				hmTemp.put("item_qty_sample", hmDetail.get(""));//item_qty_sample"));
				hmTemp.put("uom_code", hmDetail.get("uom_code"));
				hmTemp.put("pur_uom_conv", hmDetail.get("pur_uom_conv"));
				hmTemp.put("pur_uom_code", hmDetail.get("pur_uom_code"));
				hmItemInfo.put((String)hmDetail.get("item_code"),hmTemp);
				if(isFinalized && iMode!=0) {// mode not equals delete

//itm info logic
//
//					HashMap hmSQL = new HashMap();
					hmSQL.put("ItemCostValueSelectSQL", hmSQL.get("SQL_ST_ITEM_VALUE_SELECT"));
					hmSQL.put("ItemMasterUpdateSQL", hmSQL.get("SQL_ST_ITEM_MASTER_UPDATE"));
					hmSQL.put("ItemStoreStkPosSelectSQL", hmSQL.get("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
					hmSQL.put("ItemStoreQtyUpdateSQL", hmSQL.get("SQL_ST_ITEM_STORE_QTY_UPDATE"));

					HashMap hmParameters = new HashMap();
					hmParameters.put("item_code",hmDetail.get("item_code"));
					hmParameters.put("store_code",hmHeader.get("store_code"));
					hmParameters.put("trn_type","RTV");

					hmParameters.put("trn_qty","-"+hmDetail.get("stk_qty_str"));
					hmParameters.put("mm_trn_qty","-"+hmDetail.get("rtv_qty_in_stk_uom"));
					hmParameters.put("language_id",(String)languageData.get(0));
					hmParameters.put("trn_unit_cost","-"+hmDetail.get("rtv_unit_cost_in_stk_uom"));
					hmParameters.put("trn_value","-"+hmDetail.get("item_cost_value"));
					hmParameters.put("from_stk_item_yn","Y");

					hmParameters.put("last_issue_date",hmHeader.get("doc_date"));
					hmParameters.put("doc_date",hmHeader.get("doc_date"));
 
					hmParameters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParameters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParameters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					/** @ for nagitive stovk issue begain **/
					ArrayList cost=new ArrayList();
					cost.add(hmDetail.get("item_code"));
					cost.add(hmHeader.get("store_code"));
				HashMap	costResult = fetchRecord(connection, "SELECT nvl(qty_on_hand,0) qty_on_hand, nvl(item_value,0) item_value, stock_item_yn FROM st_item_store WHERE item_code=? AND store_code=?", cost);
				double l_qty_on_hand		= 0;
				if(costResult.get("QTY_ON_HAND") != null) {
				l_qty_on_hand = Double.parseDouble((String)(costResult.get("QTY_ON_HAND")));
				}

				double l_stk_value		= 0.0;
				if(costResult.get("ITEM_VALUE") != null) {					
				l_stk_value	= Double.parseDouble((String)(costResult.get("ITEM_VALUE")));	
				}
				double l_unit_cost		= 0.0;

				if(l_stk_value != 0.0 && l_qty_on_hand != 0.0) {
					l_unit_cost = l_stk_value / l_qty_on_hand;
				}
				l_unit_cost=l_unit_cost+0.0000005;
				l_unit_cost*=1000000;
				l_unit_cost=(long)l_unit_cost;
				l_unit_cost/=1000000;
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
				l_unit_cost=Double.parseDouble(setNumber(""+l_unit_cost,noOfDecimalsForCost));
				double p_trn_value			= Double.parseDouble((String)hmParameters.get("trn_value"));
				double p_trn_qty				= Double.parseDouble((String)hmParameters.get("trn_qty"));
				if( l_stk_value+p_trn_value < 0) {
				hmParameters.put("trn_value",""+(p_trn_qty*l_unit_cost));

				}
				/** @ for nagitive stock issue end **/
					calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
					hmParameters.put("trn_qty","-"+hmDetail.get("rtv_qty_in_stk_uom"));
					/** @ for nagitive stovk this line is adding  **/
					hmParameters.put("trn_value","-"+hmDetail.get("item_cost_value"));
					hmResult	=	insertOrUpdateItemMoveSummary(connection, hmParameters, hmSQL);
					throwExceptionWhenFailed(hmResult);
				}
			}



//exp logic
			alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");

			

			
			for (int i=0;i<alExp.size() ;i++ ) {
				HashMap hmExpRecord		= (HashMap)alExp.get(i);
//save item code in case of error
				stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				ArrayList alExpRecord	= new ArrayList();

				alExpRecord.add(hmHeader.get("facility_id"));
				alExpRecord.add(hmHeader.get("doc_type_code"));
				alExpRecord.add(hmHeader.get("doc_no"));

				alExpRecord.add(hmExpRecord.get("doc_srl_no"));
				alExpRecord.add(hmHeader.get("store_code"));
				alExpRecord.add(hmExpRecord.get("ITEM_CODE"));                 
				alExpRecord.add(hmExpRecord.get("BATCH_ID"));                  
				alExpRecord.add(hmExpRecord.get("BIN_LOCATION_CODE"));         
				alExpRecord.add(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				alExpRecord.add(hmExpRecord.get("TRADE_ID"));                  
				alExpRecord.add(hmExpRecord.get("RTV_ITEM_QTY"));                  
				alExpRecord.add(hmExpRecord.get("GRN_DOC_TYPE_CODE"));  
				alExpRecord.add(hmExpRecord.get("GRN_DOC_NO"));         

				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));
				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));

				alExpData.add(alExpRecord);

					ArrayList alExpUpdate	=	new ArrayList();
					alExpUpdate.add(hmExpRecord.get("RTV_ITEM_QTY"));
					alExpUpdate.add(hmCommon.get("login_by_id"));      
					alExpUpdate.add(hmCommon.get("login_at_ws_no"));   
					alExpUpdate.add(hmCommon.get("login_facility_id"));

					alExpUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alExpUpdate.add(hmExpRecord.get("GRN_DOC_TYPE_CODE"));
					alExpUpdate.add(hmExpRecord.get("GRN_DOC_NO"));

					alExpUpdate.add(hmHeader.get("store_code"));
					alExpUpdate.add(hmExpRecord.get("ITEM_CODE"));
					alExpUpdate.add(hmExpRecord.get("BATCH_ID"));
					alExpUpdate.add(hmExpRecord.get("PREV_BIN_LOCATION_CODE"));
					alExpUpdate.add(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					alExpUpdate.add(hmExpRecord.get("TRADE_ID"));

					hmArgData.put(DATA,alExpUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);


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

					hmParamaters.put("item_code",hmExpRecord.get("ITEM_CODE"));
					hmParamaters.put("store_code",hmHeader.get("store_code"));
					hmParamaters.put("trn_type","RTV");
					hmParamaters.put("batch_id",hmExpRecord.get("BATCH_ID"));
					hmParamaters.put("expiry_date_or_receipt_date",hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					hmParamaters.put("trade_id",hmExpRecord.get("TRADE_ID"));
					hmParamaters.put("from_bin_location_code",hmExpRecord.get("BIN_LOCATION_CODE"));
					hmParamaters.put("suspended_batch_allowed_yn","Y");
					hmParamaters.put("release_batch_yn","N");

					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("ITEM_CODE"));
//added for GRN field updation on Thursday, September 04, 2003					
/*					hmParamaters.put("grn_doc_type_code",hmHeader.get("doc_type_code"));
					hmParamaters.put("grn_doc_no",hmHeader.get("doc_no"));
					hmParamaters.put("grn_doc_srl_no",hmExpRecord.get("doc_srl_no"));
					hmParamaters.put("grn_unit_cost_in_stk_uom",hmTempItemInfo.get("grn_unit_cost_in_stk_uom"));
*/
					hmParamaters.put("trn_qty","-"+(Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));
					hmParamaters.put("last_receipt_date",hmHeader.get("doc_date")); // doc_date

					hmParamaters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParamaters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParamaters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					updateBatchOnLine(connection, hmSQL, hmParamaters);
///
					ArrayList ItemTrnDtlRecord	=	new ArrayList();
					ItemTrnDtlRecord.add(hmHeader.get("facility_id"));
					ItemTrnDtlRecord.add(hmHeader.get("store_code"));
					ItemTrnDtlRecord.add(hmExpRecord.get("ITEM_CODE"));
					ItemTrnDtlRecord.add(""+(i+1));//trn_srl_no
					ItemTrnDtlRecord.add("RTV");
					ItemTrnDtlRecord.add(hmHeader.get("doc_type_code"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_no"));
					ItemTrnDtlRecord.add(hmExpRecord.get("doc_srl_no"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_date"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_ref"));
					ItemTrnDtlRecord.add(hmExpRecord.get("BATCH_ID"));
					ItemTrnDtlRecord.add(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					ItemTrnDtlRecord.add("-"+(Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmTempItemInfo.get("item_qty_normal")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_bonus")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_sample")
					ItemTrnDtlRecord.add(""+hmTempItemInfo.get("rtv_unit_cost_in_stk_uom"));//item_unit_cost
					ItemTrnDtlRecord.add(""+hmTempItemInfo.get("rtv_unit_cost_in_stk_uom"));//item_unit_price
					ItemTrnDtlRecord.add(hmTempItemInfo.get("uom_code"));
					ItemTrnDtlRecord.add(hmHeader.get("supp_code"));
					ItemTrnDtlRecord.add("Y");
					ItemTrnDtlRecord.add(hmExpRecord.get("BIN_LOCATION_CODE"));
					ItemTrnDtlRecord.add(hmExpRecord.get("TRADE_ID"));
 
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_code"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_conv"));

					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_TYPE_CODE"));
					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_NO"));
					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_SRL_NO"));
					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_DATE"));

					alItemTrnDtl.add(ItemTrnDtlRecord);
///                   
				}
				else{//Batch blocking logic follows:
					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("ITEM_CODE"));
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",hmHeader.get("store_code"));
					hmParameter.put("item_code",hmExpRecord.get("ITEM_CODE"));
					hmParameter.put("batch_id",hmExpRecord.get("BATCH_ID"));
					hmParameter.put("bin_location_code",hmExpRecord.get("BIN_LOCATION_CODE"));
					hmParameter.put("expiry_date_or_receipt_date",hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					hmParameter.put("trn_qty",""+(Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("RTV_ITEM_QTY"));

					hmParameter.put("login_by_id",hmCommon.get("login_by_id"));
					hmParameter.put("login_at_ws_no",hmCommon.get("login_at_ws_no"));
					hmParameter.put("login_facility_id",hmCommon.get("login_facility_id"));

					hmResult	=	blockReleaseBatch(connection, hmParameter, 'B');
					throwExceptionWhenFailed(hmResult);
				}

			}


			hmArgData.put(DATA,alExpData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_RTV_DTL_EXP_INSERT"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			if (isFinalized) {
                
				hmArgData.put(DATA,alItemTrnDtl);
				hmArgSQL.put(BATCH_SQL, hmSQL.get("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_RTV"));
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
			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmResult.put("flag",stCurrentItemCodeInCaseOfError);
			}
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


	public HashMap insert(HashMap hmData, HashMap hmSQL) { //throws RemoteException

        Connection connection = null;
		Properties properties=null;

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		HashMap		hmHeader	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		HashMap		hmCommon	=	new HashMap();
		HashMap		hmItemInfo	=	new HashMap();

		ArrayList	alDetail	=	new ArrayList();
		ArrayList	alExp		=	new ArrayList();
		ArrayList	languageData=	new ArrayList();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
//		ArrayList	alDtlRecords=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
//		ArrayList	alExpRecords=	new ArrayList();
		ArrayList	alItemTrnDtl=	new ArrayList();
		String stCurrentItemCodeInCaseOfError=null;
	//	boolean isDocNoAutoGenerated	=	false;
		boolean isFinalized		=	false;
		String      trn_type		=	"RTV";
		int      sizeOfTrn		=	1;
		int      trnRecords		=	1;
		ArrayList doc_no = new ArrayList();
		ArrayList item_code_list = new ArrayList();
		//ArrayList<ArrayList> alTempData		= new ArrayList<ArrayList>();
		ArrayList<Integer> alItemClassCount	= new ArrayList<Integer>();
		ArrayList<String> alItemClass		= new ArrayList<String>();
		String item_class_based	= checkForNull((String)hmData.get("ITEM_CLASS_BASED"),"N");
		if(hmData.containsKey("ItemClassCount")){
			alItemClassCount=	(ArrayList) hmData.get("ItemClassCount");
			alItemClass=	(ArrayList) hmData.get("ItemClass");
		}


	
        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmCommon				=	(HashMap)	hmData.get("COMMON_DATA");
			hmHeader				=	(HashMap)	hmData.get("HDR_DATA");
			languageData			=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			isFinalized				=	((String)	hmHeader.get("finalized_yn")).equals("Y");
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
		//	HashMap hmRecord	=	fetchRecord(connection, (String)hmSQL.get("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"), 
		//		(String)hmHeader.get("doc_type_code"));
		//	isDocNoAutoGenerated=	hmRecord.get("DOC_NUM_GEN_FLAG").toString().equals("Y");

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
			alHdrData.add(hmHeader.get("supp_code"));
			alHdrData.add(hmHeader.get("finalized_yn"));
			alHdrData.add(hmHeader.get("gl_interfaced_yn"));
			alHdrData.add(hmHeader.get("trn_type"));
			alHdrData.add(hmHeader.get("entry_completed_yn"));
			if(item_class_based.equals("Y")){
				alHdrData.add(alItemClass.get(j));
			}else{
				alHdrData.add(hmHeader.get("item_class_code"));
			}

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));

			alHdrData.add(hmCommon.get("login_by_id"));
			alHdrData.add(hmCommon.get("login_at_ws_no"));
			alHdrData.add(hmCommon.get("login_facility_id"));
//added on 19_07_2004
            alHdrData.add(hmHeader.get("replacement_grn_yn"));

			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,hmSQL.get("SQL_ST_RTV_HDR_INSERT"));
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
			item_code_list = new ArrayList();
			for (int i=k;i<trnRecords ;i++ ) {	
			//for (int i=0;i<alDetail.size() ;i++ ) {
				HashMap hmDetail	= (HashMap)alDetail.get(i);
                // save the item code in case of error
                stCurrentItemCodeInCaseOfError=(String)hmDetail.get("item_code");
				ArrayList alDtlRecord	=	new ArrayList();
			
				item_code_list.add((String)hmDetail.get("item_code"));

				alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");

				double averageUnitCost	=	0.0;
				String grn_doc_type	="";
				String grn_doc_no	="";
				String pur_uom_conv	=	"";
				String pur_uom_code	=	"";
				double unit_cost	=	0.0;
				int totalRecords	=	0;
				double totalValue	=	0.0;
				double totalQty		=	0;
				for (int p=0;p<alExp.size() ;p++ ) {
	HashMap hmExpRecord		= (HashMap)alExp.get(p);

					if((((String)hmExpRecord.get("doc_srl_no")).equals((String)hmDetail.get("doc_srl_no")))&& (((String)hmExpRecord.get("ITEM_CODE")).equals((String)hmDetail.get("item_code")))){
						grn_doc_type	=(String)hmExpRecord.get("GRN_DOC_TYPE_CODE");
						grn_doc_no	=(String)hmExpRecord.get("GRN_DOC_NO");
						pur_uom_conv=(String)hmExpRecord.get("PUR_UOM_CONV");
						pur_uom_code=(String)hmExpRecord.get("PUR_UOM_CODE");
						unit_cost	=unit_cost+Double.parseDouble((String)hmExpRecord.get("GRN_UNIT_COST_IN_PUR_UOM"));//RTV_ITEM_QTY;
						totalValue	=totalValue+Double.parseDouble((String)hmExpRecord.get("GRN_UNIT_COST_IN_PUR_UOM"))*Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"));
						totalRecords	=totalRecords+1;
						totalQty=totalQty+Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"));
					}
				}
				//averageUnitCost	=	unit_cost/totalRecords;
				averageUnitCost	=	totalValue/totalQty;
/*
				for (int j=0;j<alExp.size() ;j++ ) {
					HashMap hmExpRecord		= (HashMap)alExp.get(j);
					
					if(((String)hmExpRecord.get("doc_srl_no")).equals((String)hmDetail.get("doc_srl_no"))){
						grn_doc_type	=(String)hmExpRecord.get("GRN_DOC_TYPE_CODE");
						grn_doc_no	=(String)hmExpRecord.get("GRN_DOC_NO");
						pur_uom_conv=(String)hmExpRecord.get("PUR_UOM_CONV");
						pur_uom_code=(String)hmExpRecord.get("PUR_UOM_CODE");
						unit_cost	+=	Double.parseDouble((String)hmExpRecord.get("GRN_UNIT_COST_IN_PUR_UOM"));
						totalRecords	+=	1;
					}
				}
				averageUnitCost	=	unit_cost/totalRecords;
*/
					ArrayList alDtlUpdate	=	new ArrayList();
					alDtlUpdate.add(hmDetail.get("item_qty_normal"));
					alDtlUpdate.add(hmDetail.get("item_qty_bonus"));
					alDtlUpdate.add("0");//hmDetail.get("item_qty_sample"));
					alDtlUpdate.add(hmCommon.get("login_by_id"));      
					alDtlUpdate.add(hmCommon.get("login_at_ws_no"));   
					alDtlUpdate.add(hmCommon.get("login_facility_id"));
					alDtlUpdate.add(hmCommon.get("login_facility_id"));//facility_id
					alDtlUpdate.add(grn_doc_type);
					alDtlUpdate.add(grn_doc_no);
					alDtlUpdate.add(hmDetail.get("item_code"));

					hmArgData.put(DATA,alDtlUpdate);
					hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				//////////////

				double rtv_qty	=	getNumber(hmDetail.get("item_qty_normal"))+getNumber(hmDetail.get("item_qty_bonus"));
				hmDetail.put("rtv_qty",""+(double)rtv_qty);
				double rtv_qty_in_stk_uom	=	rtv_qty*Double.parseDouble(pur_uom_conv);
				hmDetail.put("rtv_qty_in_stk_uom",""+(double)rtv_qty_in_stk_uom);
				hmDetail.put("pur_uom_conv",pur_uom_conv);
				hmDetail.put("pur_uom_code",pur_uom_code);
				/**
				 * @Name - Priya
				 * @Date - 28/05/2010
				 * @Inc# - 
				 * @Desc -  To get no of decimals for cost  
				 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
				double rtv_unit_cost=	averageUnitCost;
//				double rtv_unit_cost=	Double.parseDouble((String)hmDetail.get("item_cost_value"))/rtv_qty;;
				hmDetail.put("rtv_unit_cost",setNumber(""+rtv_unit_cost,noOfDecimalsForCost));
				double rtv_unit_cost_in_stk_uom=	rtv_unit_cost/Double.parseDouble(pur_uom_conv);
				hmDetail.put("rtv_unit_cost_in_stk_uom",setNumber(""+rtv_unit_cost_in_stk_uom,noOfDecimalsForCost));
				hmDetail.put("item_cost_value",setNumber(""+Double.parseDouble((String)hmDetail.get("rtv_unit_cost"))*rtv_qty,noOfDecimalsForCost));
				double stk_qty_str	=rtv_qty_in_stk_uom/Double.parseDouble((String)hmDetail.get("to_conv_fact"));
				hmDetail.put("stk_qty_str",""+(double)stk_qty_str);

				
				alDtlRecord.add(hmHeader.get("facility_id"));
				alDtlRecord.add(hmHeader.get("doc_type_code"));
				alDtlRecord.add(hmHeader.get("doc_no"));

				alDtlRecord.add(hmDetail.get("doc_srl_no"));
				alDtlRecord.add(hmDetail.get("item_code"));
				alDtlRecord.add(hmDetail.get("item_qty_normal"));
				alDtlRecord.add(hmDetail.get("item_qty_bonus"));
				alDtlRecord.add("0");//hmDetail.get("item_qty_sample"));
				alDtlRecord.add(hmDetail.get("item_cost_value"));
				alDtlRecord.add("Y");
				alDtlRecord.add(hmDetail.get("rtv_unit_cost"));
				alDtlRecord.add(hmDetail.get("remarks"));

				alDtlRecord.add(hmCommon.get("login_by_id"));
				alDtlRecord.add(hmCommon.get("login_at_ws_no"));
				alDtlRecord.add(hmCommon.get("login_facility_id"));
				alDtlRecord.add(hmCommon.get("login_by_id"));
				alDtlRecord.add(hmCommon.get("login_at_ws_no"));
				alDtlRecord.add(hmCommon.get("login_facility_id"));

				if(((String)hmHeader.get("replacement_grn_yn")).equals("Y"))
				{
					alDtlRecord.add(hmDetail.get("item_qty_normal"));
					alDtlRecord.add(hmDetail.get("item_qty_normal"));

				}else{
					alDtlRecord.add("0");
					alDtlRecord.add("0");
				}

				alDtlData.add(alDtlRecord);

				HashMap hmTemp	=	new HashMap();
				hmTemp.put("rtv_unit_cost", hmDetail.get("rtv_unit_cost"));
				hmTemp.put("item_qty_normal", hmDetail.get("item_qty_normal"));
				hmTemp.put("item_qty_bonus", hmDetail.get("item_qty_bonus"));
				hmTemp.put("item_qty_sample", hmDetail.get("item_qty_sample"));
				hmTemp.put("uom_code", hmDetail.get("uom_code"));
				hmTemp.put("rtv_unit_cost_in_stk_uom", hmDetail.get("rtv_unit_cost_in_stk_uom"));
				hmTemp.put("pur_uom_conv", hmDetail.get("pur_uom_conv"));
				hmTemp.put("pur_uom_code", hmDetail.get("pur_uom_code"));
				hmItemInfo.put((String)hmDetail.get("item_code"),hmTemp);
				if(isFinalized) {
//itm info logic
//
//					HashMap hmSQL = new HashMap();
					hmSQL.put("ItemCostValueSelectSQL", hmSQL.get("SQL_ST_ITEM_VALUE_SELECT"));
					hmSQL.put("ItemMasterUpdateSQL", hmSQL.get("SQL_ST_ITEM_MASTER_UPDATE"));
					hmSQL.put("ItemStoreStkPosSelectSQL", hmSQL.get("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
					hmSQL.put("ItemStoreQtyUpdateSQL", hmSQL.get("SQL_ST_ITEM_STORE_QTY_UPDATE"));

					HashMap hmParameters = new HashMap();
					hmParameters.put("item_code",hmDetail.get("item_code"));
					hmParameters.put("store_code",hmHeader.get("store_code"));
					hmParameters.put("trn_type","RTV");
					hmParameters.put("trn_qty","-"+hmDetail.get("stk_qty_str"));
					hmParameters.put("mm_trn_qty","-"+hmDetail.get("rtv_qty_in_stk_uom"));
					hmParameters.put("language_id",(String)languageData.get(0));
					hmParameters.put("trn_unit_cost","-"+hmDetail.get("rtv_unit_cost_in_stk_uom"));
					hmParameters.put("trn_value","-"+hmDetail.get("item_cost_value"));
					hmParameters.put("from_stk_item_yn","Y");

					hmParameters.put("last_issue_date",hmHeader.get("doc_date"));
					hmParameters.put("doc_date",hmHeader.get("doc_date"));
 
					hmParameters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParameters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParameters.put("login_facility_id",	hmCommon.get("login_facility_id"));
							/** @ for nagitive stovk issue begain **/
					ArrayList cost=new ArrayList();
					cost.add(hmDetail.get("item_code"));
					cost.add(hmHeader.get("store_code"));
				HashMap	costResult = fetchRecord(connection, "SELECT nvl(qty_on_hand,0) qty_on_hand, nvl(item_value,0) item_value, stock_item_yn FROM st_item_store WHERE item_code=? AND store_code=?", cost);
				double l_qty_on_hand		= 0;
				if(costResult.get("QTY_ON_HAND") != null) {
				l_qty_on_hand = Double.parseDouble((String)(costResult.get("QTY_ON_HAND")));
				}

				double l_stk_value		= 0.0;
				if(costResult.get("ITEM_VALUE") != null) {					
				l_stk_value	= Double.parseDouble((String)(costResult.get("ITEM_VALUE")));	
				}
				double l_unit_cost		= 0.0;

				if(l_stk_value != 0.0 && l_qty_on_hand != 0.0) {
					l_unit_cost = l_stk_value / l_qty_on_hand;
				}
				l_unit_cost=l_unit_cost+0.0000005;
				l_unit_cost*=1000000;
				l_unit_cost=(long)l_unit_cost;
				l_unit_cost/=1000000;
				l_unit_cost=Double.parseDouble(setNumber(""+l_unit_cost,noOfDecimalsForCost));
				double p_trn_value			= Double.parseDouble((String)hmParameters.get("trn_value"));
				double p_trn_qty				= Double.parseDouble((String)hmParameters.get("trn_qty"));
				if( l_stk_value+p_trn_value < 0) {
				hmParameters.put("trn_value",""+(p_trn_qty*l_unit_cost));

				}
				/** @ for nagitive stovk issue begain **/
					calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
					hmParameters.put("trn_qty","-"+hmDetail.get("rtv_qty_in_stk_uom"));
				/** @ for nagitive stock issue adding this line **/
					hmParameters.put("trn_value","-"+hmDetail.get("item_cost_value"));
				
					hmResult	=	insertOrUpdateItemMoveSummary(connection, hmParameters, hmSQL);
					throwExceptionWhenFailed(hmResult);
				
				}
			}

			hmArgData.put(DATA,alDtlData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_RTV_DTL_INSERT"));

			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

//exp logic
			alExp		=	(ArrayList)	hmData.get("DTL_EXP_DATA");
		alExpData	=	new ArrayList();
	for (int g=0;g<item_code_list.size() ;g++ ){

	for(int i=0;i<alExp.size() ;i++ )
			{
				HashMap hmExpRecord		= (HashMap)alExp.get(i);

               if(((String)item_code_list.get(g)).equals((String)hmExpRecord.get("ITEM_CODE"))){ 

                // save the item code in case of error

                stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				ArrayList alExpRecord	= new ArrayList();

				alExpRecord.add(hmHeader.get("facility_id"));
				alExpRecord.add(hmHeader.get("doc_type_code"));
				alExpRecord.add(hmHeader.get("doc_no"));

				alExpRecord.add(hmExpRecord.get("doc_srl_no"));
				alExpRecord.add(hmHeader.get("store_code"));
				alExpRecord.add(hmExpRecord.get("ITEM_CODE"));
				alExpRecord.add(hmExpRecord.get("BATCH_ID"));
				alExpRecord.add(hmExpRecord.get("BIN_LOCATION_CODE"));
				alExpRecord.add(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				alExpRecord.add(hmExpRecord.get("TRADE_ID"));
				alExpRecord.add(hmExpRecord.get("RTV_ITEM_QTY"));
				alExpRecord.add(hmExpRecord.get("GRN_DOC_TYPE_CODE"));
				alExpRecord.add(hmExpRecord.get("GRN_DOC_NO"));

				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));
				alExpRecord.add(hmCommon.get("login_by_id"));
				alExpRecord.add(hmCommon.get("login_at_ws_no"));
				alExpRecord.add(hmCommon.get("login_facility_id"));

				alExpData.add(alExpRecord);


				ArrayList alExpUpdate	=	new ArrayList();
				alExpUpdate.add(hmExpRecord.get("RTV_ITEM_QTY"));
				alExpUpdate.add(hmCommon.get("login_by_id"));      
				alExpUpdate.add(hmCommon.get("login_at_ws_no"));   
				alExpUpdate.add(hmCommon.get("login_facility_id"));

				alExpUpdate.add(hmCommon.get("login_facility_id"));//facility_id
				alExpUpdate.add(hmExpRecord.get("GRN_DOC_TYPE_CODE"));
				alExpUpdate.add(hmExpRecord.get("GRN_DOC_NO"));

				alExpUpdate.add(hmHeader.get("store_code"));
				alExpUpdate.add(hmExpRecord.get("ITEM_CODE"));
				alExpUpdate.add(hmExpRecord.get("BATCH_ID"));
                //alExpUpdate.add(hmExpRecord.get("BIN_LOCATION_CODE"));
				alExpUpdate.add(hmExpRecord.get("PREV_BIN_LOCATION_CODE"));
				alExpUpdate.add(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				alExpUpdate.add(hmExpRecord.get("TRADE_ID"));

				hmArgData.put(DATA,alExpUpdate);
				hmArgSQL.put(UPDATE_SQL,hmSQL.get("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);


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

					hmParamaters.put("item_code",hmExpRecord.get("ITEM_CODE"));
					hmParamaters.put("store_code",hmHeader.get("store_code"));
					hmParamaters.put("trn_type","RTV");
					hmParamaters.put("batch_id",hmExpRecord.get("BATCH_ID"));
					hmParamaters.put("expiry_date_or_receipt_date",hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					hmParamaters.put("trade_id",hmExpRecord.get("TRADE_ID"));
					hmParamaters.put("from_bin_location_code",hmExpRecord.get("BIN_LOCATION_CODE"));
					hmParamaters.put("suspended_batch_allowed_yn","Y");
					hmParamaters.put("release_batch_yn","N");

					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("ITEM_CODE"));
//added for GRN field updation on Thursday, September 04, 2003					
/*					hmParamaters.put("grn_doc_type_code",hmHeader.get("doc_type_code"));
					hmParamaters.put("grn_doc_no",hmHeader.get("doc_no"));
					hmParamaters.put("grn_doc_srl_no",hmExpRecord.get("doc_srl_no"));
					hmParamaters.put("grn_unit_cost_in_stk_uom",hmTempItemInfo.get("rtv_unit_cost"));
*/
					hmParamaters.put("trn_qty","-"+(Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));
					hmParamaters.put("last_receipt_date",hmHeader.get("receipt_date")); // doc_date

					hmParamaters.put("login_by_id",			hmCommon.get("login_by_id"));
					hmParamaters.put("login_at_ws_no",		hmCommon.get("login_at_ws_no"));
					hmParamaters.put("login_facility_id",	hmCommon.get("login_facility_id"));
					updateBatchOnLine(connection, hmSQL, hmParamaters);
///
					ArrayList ItemTrnDtlRecord	=	new ArrayList();

					ItemTrnDtlRecord.add(hmHeader.get("facility_id"));
					ItemTrnDtlRecord.add(hmHeader.get("store_code"));
					ItemTrnDtlRecord.add(hmExpRecord.get("ITEM_CODE"));
					ItemTrnDtlRecord.add(""+(i+1));//trn_srl_no
					ItemTrnDtlRecord.add("RTV");
					ItemTrnDtlRecord.add(hmHeader.get("doc_type_code"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_no"));
					ItemTrnDtlRecord.add(hmExpRecord.get("doc_srl_no"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_date"));
					ItemTrnDtlRecord.add(hmHeader.get("doc_ref"));
					ItemTrnDtlRecord.add(hmExpRecord.get("BATCH_ID"));
					ItemTrnDtlRecord.add(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					ItemTrnDtlRecord.add("-"+(Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("RTV_ITEM_QTY"));//hmTempItemInfo.get("item_qty_normal")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_bonus")
					ItemTrnDtlRecord.add("");//hmTempItemInfo.get("item_qty_sample")
					ItemTrnDtlRecord.add(hmTempItemInfo.get("rtv_unit_cost_in_stk_uom"));//item_unit_cost
					ItemTrnDtlRecord.add(hmTempItemInfo.get("rtv_unit_cost_in_stk_uom"));//item_unit_price
					ItemTrnDtlRecord.add(hmTempItemInfo.get("uom_code"));
					ItemTrnDtlRecord.add(hmHeader.get("supp_code"));
					ItemTrnDtlRecord.add("Y");
					ItemTrnDtlRecord.add(hmExpRecord.get("BIN_LOCATION_CODE"));
					ItemTrnDtlRecord.add(hmExpRecord.get("TRADE_ID"));
 
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_by_id"));
					ItemTrnDtlRecord.add(hmCommon.get("login_at_ws_no"));
					ItemTrnDtlRecord.add(hmCommon.get("login_facility_id"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_code"));
					ItemTrnDtlRecord.add(hmTempItemInfo.get("pur_uom_conv"));

					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_TYPE_CODE"));
					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_NO"));
					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_SRL_NO"));
					ItemTrnDtlRecord.add(hmExpRecord.get("GRN_DOC_DATE"));

		
					alItemTrnDtl.add(ItemTrnDtlRecord);

					
				}
				else
				{   
					//Batch blocking logic follows:
					HashMap	hmTempItemInfo		=	(HashMap)hmItemInfo.get((String)hmExpRecord.get("ITEM_CODE"));
				//	if(hmTempItemInfo==null)
				//	continue;
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",hmHeader.get("store_code"));
					hmParameter.put("item_code",hmExpRecord.get("ITEM_CODE"));
					hmParameter.put("batch_id",hmExpRecord.get("BATCH_ID"));
					hmParameter.put("bin_location_code",hmExpRecord.get("BIN_LOCATION_CODE"));
					hmParameter.put("expiry_date_or_receipt_date",hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					hmParameter.put("trn_qty",""+(Double.parseDouble((String)hmExpRecord.get("RTV_ITEM_QTY"))*Double.parseDouble((String)hmTempItemInfo.get("pur_uom_conv"))));//hmExpRecord.get("RTV_ITEM_QTY"));

					hmParameter.put("login_by_id",hmCommon.get("login_by_id"));
					hmParameter.put("login_at_ws_no",hmCommon.get("login_at_ws_no"));
					hmParameter.put("login_facility_id",hmCommon.get("login_facility_id"));

					hmResult	=	blockReleaseBatch(connection, hmParameter, 'B');
					throwExceptionWhenFailed(hmResult);
					}
				}
			}
			}


			hmArgData.put(DATA,alExpData);
			hmArgSQL.put(BATCH_SQL,hmSQL.get("SQL_ST_RTV_DTL_EXP_INSERT"));
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			if (isFinalized) {
				hmArgData.put(DATA,alItemTrnDtl);

                hmArgSQL.put(BATCH_SQL, hmSQL.get("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_RTV"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
			}
			alItemTrnDtl = new ArrayList();
			String locale=(String)languageData.get(0);

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
			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmResult.put("flag",stCurrentItemCodeInCaseOfError);
			}

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

//		String	facility_id         	=	(String)hmColumns.get("facility_id");
		String	item_code           	=	(String)hmColumns.get("item_code");
		String	store_code          	=	(String)hmColumns.get("store_code");
		String	month_closing_qty   	=	(String)hmColumns.get("trn_qty");

//		String	month_closing_value 	=	(String)hmColumns.get("trn_unit_cost");

		String	grn_qty             	=	(String)hmColumns.get("trn_qty");
//		String	grn_cost            	=	(String)hmColumns.get("trn_unit_cost");
//		String	trn_unit_cost          	=	(String)hmColumns.get("trn_unit_cost");

		String	month_closing_value 	=	(String)hmColumns.get("trn_value");//"-"+(getNumber(trn_unit_cost)*getNumber(grn_qty));
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

			stSQL	=	(String)hmSQL.get("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_RTV");

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

			stSQL = (String)hmSQL.get("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_RTV");

			hmArgData.put(DATA,alData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmResult	=	update(connection, hmArgData, hmArgSQL);
		}

		throwExceptionWhenFailed(hmResult);
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		//stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";

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


}
