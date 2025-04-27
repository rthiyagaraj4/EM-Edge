/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063921				Badmavathi B					        					 Pick List not working in OT - ST exception 
-------------------------------------------------------------------------------------------------------------------------------
*/
 package eST;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DecimalFormat ;
import eST.Request.*;

import eST.Common.StRepository;


public class OTTransactionBean extends eST.Common.StTransaction implements Serializable{
	public void initialize() {
		super.initialize();
		/*try{
			OTTransactionBean reqBean = new OTTransactionBean();
			HashMap hm = reqBean.requestForOT(new HashMap(),getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	public HashMap requestForOT(HashMap hmData, Connection conn){
	//public HashMap requestForOT(Connection conn){
		//HashMap hmData = new HashMap();//Remove this declaration when openining up the function
		String stock_item_yn		= "Y";
		ArrayList alDtlRecords		= new ArrayList();
		ArrayList alParam			= new ArrayList();
		ArrayList alDtlInsertRecord = new ArrayList();
		ArrayList alUpdRecord		= new ArrayList();
		ArrayList alDtlRecord		= new ArrayList();
		ArrayList alUpdateItemData	= new ArrayList();
		ArrayList alHdrInsertRecord = new ArrayList();
		ArrayList alDtlData			= new ArrayList();
		ArrayList alExpRecords		= new ArrayList();
		ArrayList alExpData			= new ArrayList();
		ArrayList alHdrInsertData	= new ArrayList();
		ArrayList reqHdrData		= new ArrayList();
		ArrayList allanguageData	= new ArrayList();
		ArrayList alTemp			= new ArrayList();
		//ArrayList alReqHdrData		= new ArrayList();
		HashMap hmResult			= new HashMap();
		HashMap hmHdrData			= new HashMap();
		HashMap hmHeader			= new HashMap();
		HashMap hmParameters		= new HashMap();
		//HashMap hmTempDtlRecord		= new HashMap();
		HashMap hmTableData			= new HashMap();
		HashMap hmDtlRecord			= new HashMap();
		HashMap hmSQLMap			= new HashMap();
		HashMap hmCommonData		= new HashMap();
		HashMap hmTemp				= new HashMap();
		HashMap hmInsDtlRecord		= new HashMap();
		HashMap hmChargeDtls		= new HashMap();
		String req_doc_type			= "";	
		String req_doc_no			= "";	
System.out.println("@@OTTransaction Bean@@"+hmData);
		/*hmTempDtlRecord.put("ITEM_CODE","PARA250");
		hmTempDtlRecord.put("REQUEST_QTY","10");
		hmTempDtlRecord.put("RESERVE_QTY","10");
		hmTempDtlRecord.put("ITEM_UNIT_COST","10.10");
		hmTempDtlRecord.put("UOM_CODE","TAB");
		alDtlRecords.add(hmTempDtlRecord);
		
		hmHdrData.put("REQUEST_BY_STORE","PHSPCS");
		hmHdrData.put("REQUEST_ON_STORE","PHINPS");
		hmHdrData.put("DOC_CREATION_FOR","B");
		hmHdrData.put("MODE","I");
		hmHdrData.put("PATIENT_ID","ES00000272");
		hmHdrData.put("ENCOUNTER_ID","10009170");
		hmHdrData.put("SAL_TRN_TYPE","I");
		hmHdrData.put("SAL_DOC_TYPE_CODE","HSSAL");
		hmHdrData.put("REQ_DOC_TYPE_CODE","HSRQIS");
		alReqHdrData.add(hmHdrData);
		hmData.put("REQ_HDR_DATA",alReqHdrData);
		hmData.put("SAL_HDR_DATA",hmHdrData);
		hmData.put("DTL_DATA",alDtlRecords);*/

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		allanguageData.add(getLanguageId());

		reqHdrData	= (ArrayList)hmData.get("REQ_HDR_DATA");
		hmHdrData	= (HashMap)hmData.get("SAL_HDR_DATA");
		alDtlRecords	= (ArrayList)hmData.get("DTL_DATA");
		hmCommonData.put("p_ord_practitioner_id",checkForNull((String)hmHdrData.get("P_ORD_PRACTITIONER_ID")));
		hmResult.put("result", new Boolean(false));
		try {
			if(((String)hmHdrData.get("DOC_CREATION_FOR")).equals("B")||((String)hmHdrData.get("DOC_CREATION_FOR")).equals("R")){
				for(int i=0;i<reqHdrData.size();i++){
					hmTemp = (HashMap)reqHdrData.get(i);
					req_doc_type = (String)hmTemp.get("REQ_DOC_TYPE_CODE");
					alHdrInsertRecord.add(getLoginFacilityId());			  
					alHdrInsertRecord.add(hmTemp.get("REQ_DOC_TYPE_CODE"));//Doc Type code
					alHdrInsertRecord.add("");//Doc Number
					alHdrInsertRecord.add(com.ehis.util.DateUtils.getCurrentDate("DMY","en"));//Doc Date
					alHdrInsertRecord.add("");//Doc ref
					alHdrInsertRecord.add("");//Item Class Code
					alHdrInsertRecord.add("W");//Request stauts
					alHdrInsertRecord.add(hmTemp.get("REQUEST_BY_STORE"));//Request By store
					alHdrInsertRecord.add(hmTemp.get("REQUEST_ON_STORE"));//Request On store
					alHdrInsertRecord.add(getLoginById());
					alHdrInsertRecord.add(login_by_id);//Authorized By
					alHdrInsertRecord.add("ISS");
					alHdrInsertRecord.add(getLoginById());
					alHdrInsertRecord.add(getLoginAtWsNo());
					alHdrInsertRecord.add(getLoginFacilityId());			  
					alHdrInsertRecord.add(getLoginById());
					alHdrInsertRecord.add(getLoginAtWsNo());
					alHdrInsertRecord.add(getLoginFacilityId());			  
					alHdrInsertRecord.add("N");//Request Type
					alHdrInsertRecord.add("");//Pick List not working in OT 28/3/2017

					alHdrInsertData.add(alHdrInsertRecord);
				}
			
				for (int index=0;index<alDtlRecords.size();index++) {
					stock_item_yn = "";
					hmDtlRecord =  (HashMap)alDtlRecords.get(index);
					if(Integer.parseInt((String)hmDtlRecord.get("REQUEST_QTY"))>0){
						alDtlRecord = new ArrayList();
						alDtlRecord.add(getLoginFacilityId());
						alDtlRecord.add(req_doc_type);
						alDtlRecord.add("");
						alDtlRecord.add(""+(index+1));
						alDtlRecord.add(hmDtlRecord.get("ITEM_CODE"));
						alDtlRecord.add(hmDtlRecord.get("REQUEST_QTY"));//requestDetailBean.getRequired_qty());
						alParam = new ArrayList();
						alParam.add(hmHdrData.get("REQUEST_BY_STORE"));
						alParam.add(hmDtlRecord.get("ITEM_CODE"));
						stock_item_yn = (String)((HashMap)fetchRecord("SELECT STOCK_ITEM_YN FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = ?",alParam)).get("STOCK_ITEM_YN");
						alDtlRecord.add(stock_item_yn);
						alDtlRecord.add("0"); // committed_qty
						int pending_qty = Integer.parseInt((String)hmDtlRecord.get("REQUEST_QTY"))/getConvFactTempLocal((String)hmDtlRecord.get("ITEM_CODE"),(String)hmHdrData.get("REQUEST_BY_STORE"));
						alDtlRecord.add(""+pending_qty);
						alDtlRecord.add(getLoginById());
						alDtlRecord.add(getLoginAtWsNo());
						alDtlRecord.add(getLoginFacilityId());			  
						alDtlRecord.add(getLoginById());
						alDtlRecord.add(getLoginAtWsNo());
						alDtlRecord.add(getLoginFacilityId());			  
							
						alDtlRecord.add(getGenItemUOM((String)hmDtlRecord.get("ITEM_CODE")));//requestDetailBean.getPurUomCode());
						alDtlRecord.add("1");//requestDetailBean.getConvFact());
						alDtlRecord.add((String)hmDtlRecord.get("REQUEST_QTY"));//requestDetailBean.getReqUomQty());
						alDtlRecord.add("");
						alDtlRecord.add("");//Pick List not working in OT 28/3/2017
						alDtlInsertRecord = new ArrayList();
						alDtlInsertRecord.add(alDtlRecord);				  
						if(hmInsDtlRecord.containsKey((String)hmDtlRecord.get("REQUEST_ON_STORE"))){
							alTemp = (ArrayList)hmInsDtlRecord.get((String)hmDtlRecord.get("REQUEST_ON_STORE"));
							alTemp.add(alDtlRecord);
							hmInsDtlRecord.put((String)hmDtlRecord.get("REQUEST_ON_STORE"),alTemp);
						}else{
							hmInsDtlRecord.put((String)hmDtlRecord.get("REQUEST_ON_STORE"),alDtlInsertRecord);
						}
						alUpdRecord = new ArrayList();
						alUpdRecord.add(""+pending_qty);
						alUpdRecord.add(getLoginById());
						alUpdRecord.add(getLoginAtWsNo());
						alUpdRecord.add(getLoginFacilityId());			  
						alUpdRecord.add((String)hmHdrData.get("REQUEST_BY_STORE"));
						alUpdRecord.add((String)hmDtlRecord.get("ITEM_CODE"));
						alUpdateItemData.add(alUpdRecord);
					}
				}
				ArrayList alUpdateData = new ArrayList ();
				alUpdateData.add(getLoginById());
				alUpdateData.add(getLoginAtWsNo());
				alUpdateData.add(getLoginFacilityId());
				alUpdateData.add(req_doc_type);	
				
				hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_INSERT")); 
				hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_INSERT")); 
				hmSQLMap.put("UpdateSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
				hmSQLMap.put("sql_st_records_per_trn_select", StRepository.getStKeyValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
				hmSQLMap.put("sql_sy_acc_entity_doc_type_select", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
				hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
				hmSQLMap.put("UpdateITMSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE")); 


				hmTableData.put("properties",getProperties());
				hmTableData.put("InsertHDRData",alHdrInsertData);
				hmTableData.put("InsertDTLData",hmInsDtlRecord);
				hmTableData.put("UpdateData",alUpdateData);
				hmTableData.put("UpdateITMData",alUpdateItemData);
			}
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			hmTableData.put("CONNECTION",conn);
			hmTableData.put("COMMON_DATA",hmCommonData);
			if(((String)hmHdrData.get("DOC_CREATION_FOR")).equals("B")||((String)hmHdrData.get("DOC_CREATION_FOR")).equals("S")){
				hmHeader.put("facility_id",getLoginFacilityId());
				hmHeader.put("doc_type_code",hmHdrData.get("SAL_DOC_TYPE_CODE"));
				hmHeader.put("doc_no",checkForNull((String)hmHdrData.get("SAL_DOC_NO")));
				hmHeader.put("doc_date",com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
				hmHeader.put("doc_ref","");
				hmHeader.put("store_code",hmHdrData.get("REQUEST_BY_STORE"));
				hmHeader.put("cancelled_by_id","");
				hmHeader.put("cancelled_remarks","");
				if(((String)hmHdrData.get("MODE")).equals("I")){
					hmHeader.put("finalized_yn","N");
					hmHeader.put("authorized_by_id","");
				}else if(((String)hmHdrData.get("MODE")).equals("D")||((String)hmHdrData.get("MODE")).equals("U")){
					hmHeader.put("authorized_by_id",getLoginById());
					hmHeader.put("finalized_yn","Y");
				}
				hmHeader.put("gl_interfaced_yn","N");
				hmHeader.put("trn_type","SAL");
				hmHeader.put("add_qty_sal_yn","N");
				hmHeader.put("patient_id",hmHdrData.get("PATIENT_ID"));
				hmHeader.put("encounter_id",hmHdrData.get("ENCOUNTER_ID"));
				hmHeader.put("sal_trn_type",hmHdrData.get("SAL_TRN_TYPE"));
				hmHeader.put("remarks","");
				hmHeader.put("item_class_code","");
				hmHeader.put("module_id","OT");
				hmHeader.put("billable_trn_yn","Y");
				hmHeader.put("take_home_yn","N");
				hmHeader.put("token_series_code","");
				hmHeader.put("token_serial_no","");
				hmHeader.put("patient_name","");//To be discussed
			/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up item_cost_value with noOfDecimalsForCost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
				for (int i=0; i<alDtlRecords.size(); i++) {
					hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
					if(Integer.parseInt((String)hmDtlRecord.get("RESERVE_QTY"))>0){
						HashMap hmDtlTemp	=	new HashMap();
						String[] stParam = {(String)hmDtlRecord.get("ITEM_CODE"),(String)hmHdrData.get("REQUEST_BY_STORE")};
						String item_unit_cost = (String)((HashMap)fetchRecord("SELECT (ITEM_VALUE / DECODE (QTY_ON_HAND, 0, 1, QTY_ON_HAND)) ITEM_UNIT_COST FROM ST_ITEM_STORE WHERE ITEM_CODE = ? AND STORE_CODE = ?",stParam)).get("ITEM_UNIT_COST");
						double	item_cost_value	=	Double.parseDouble(item_unit_cost)*Double.parseDouble((String)hmDtlRecord.get("RESERVE_QTY"));
						String stitem_cost_value	=	setNumber(""+item_cost_value,noOfDecimalsForCost);

						hmDtlTemp.put("doc_srl_no", ""+(i+1));
						hmDtlTemp.put("item_code", hmDtlRecord.get("ITEM_CODE"));
						hmDtlTemp.put("sal_category", "");
						hmDtlTemp.put("hcp_issue_factor", "");
						int item_qty = Integer.parseInt((String)hmDtlRecord.get("RESERVE_QTY"))/getConvFactTempLocal((String)hmDtlRecord.get("ITEM_CODE"),(String)hmHdrData.get("REQUEST_BY_STORE"));
						hmDtlTemp.put("item_qty", ""+item_qty);
						hmDtlTemp.put("item_sal_value", stitem_cost_value);//hmDtlRecord.get("item_cost_value"));
						hmDtlTemp.put("next_due_date", "");
						alParam = new ArrayList();
						alParam.add(hmHdrData.get("REQUEST_BY_STORE"));
						alParam.add(hmDtlRecord.get("ITEM_CODE"));
						stock_item_yn = (String)((HashMap)fetchRecord("select stock_item_yn from st_item_store where store_code = ? and item_code = ?",alParam)).get("STOCK_ITEM_YN");

						hmDtlTemp.put("stock_item_yn", stock_item_yn);
						hmDtlTemp.put("remarks", "");
						hmDtlTemp.put("item_unit_cost", item_unit_cost);
						hmDtlTemp.put("item_cost_value",stitem_cost_value);// hmDtlRecord.get("item_unit_cost"));
						hmDtlTemp.put("item_unit_price", item_unit_cost);
						hmDtlTemp.put("uom_code", hmDtlRecord.get("UOM_CODE"));
						hmDtlTemp.put("p_overridden_excl_incl_ind", hmDtlRecord.get("INCLUDE_EXCLUDE_YN"));
						hmDtlTemp.put("p_overridden_action_reason", hmDtlRecord.get("OVERRIDE_REASON_CODE"));
						hmChargeDtls = new HashMap();
						if(((String)getBLModuleInstalled()).equals("Y")){
							hmChargeDtls	= getBillingDetail((String)hmHdrData.get("PATIENT_ID"),checkForNull((String)hmHdrData.get("ENCOUNTER_ID")),checkForNull((String)hmHdrData.get("SAL_TRN_TYPE"),"I"),(String)hmDtlRecord.get("INCLUDE_EXCLUDE_YN"),(String)hmDtlRecord.get("OVERRIDE_REASON_CODE"),(String)hmDtlRecord.get("ITEM_CODE"),(String)hmDtlRecord.get("RESERVE_QTY"));
							if(!(checkForNull((String)hmChargeDtls.get("BL_ERROR_TEXT"))).equals("")||!(checkForNull((String)hmChargeDtls.get("BL_SYS_MESSAGE_ID"))).equals("")){
								alDtlData = new ArrayList();
								alUpdateItemData = new ArrayList();
								//String msg = (String)hmChargeDtls.get("BL_SYS_MESSAGE_ID") + " " +(String)hmChargeDtls.get("BL_ERROR_TEXT");
								//hmResult.put("msgid",msg);
								//hmResult.put("msgid",msg);
								hmResult.put("msgid",(String)hmChargeDtls.get("BL_SYS_MESSAGE_ID"));
								if(!(checkForNull((String)hmChargeDtls.get("BL_SYS_MESSAGE_ID"))).equals("")){
									hmResult.put("message",(String)getBLMessage((String)hmChargeDtls.get("BL_SYS_MESSAGE_ID")));
								}else{
									hmResult.put("message",(String)hmChargeDtls.get("BL_ERROR_TEXT"));
								}
								break;
							}
							hmDtlTemp.put("pat_net_amt",checkForNull((String)hmChargeDtls.get("BL_PATIENT_PAYABLE_AMT"),"0"));
							hmDtlTemp.put("gross_charge_amt",checkForNull((String)hmChargeDtls.get("BL_TOTAL_CHARGE_AMT"),"0"));
						}else{
							hmDtlTemp.put("pat_net_amt","0");
							hmDtlTemp.put("gross_charge_amt","0");
						}

						hmDtlTemp.put("mm_trn_qty", hmDtlRecord.get("RESERVE_QTY"));
						hmDtlTemp.put("mode", eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
						alDtlData.add(hmDtlTemp);

						hmParameters = new HashMap();
						hmParameters.put("TRN_QTY",hmDtlRecord.get("RESERVE_QTY"));
						hmParameters.put("ITEM_CODE",hmDtlRecord.get("ITEM_CODE"));
						hmParameters.put("STORE_CODE",hmHdrData.get("REQUEST_BY_STORE"));
						hmParameters.put("INCLUDE_SUSPENDED","FALSE");
						hmParameters.put("INCLUDE_EXPIRED","FALSE");
						hmParameters.put("VERIFY_INSUFFICIENT_QTY","TRUE");
						hmParameters.put("CUT_OFF_DATE","");
						hmParameters.put("ALREADY_USED_QTY","0");
						hmParameters.put("MIN_EXP_DATE","");
						eST.Common.StUtilities	stUtil		=	new eST.Common.StUtilities();
						stUtil.setLanguageId(getLanguageId());
						stUtil.setLoginById(getLoginById());//Pick List not working in OT 28/3/2017
						alExpRecords=(ArrayList)((HashMap)stUtil.getBatches(hmParameters)).get("BATCH_DATA");
			
						for (int j=0; j<alExpRecords.size(); j++) {
							HashMap hmExpRecord		=	(HashMap)alExpRecords.get(j);
							HashMap hmExpTemp	=	new HashMap();
							hmExpTemp.put("doc_srl_no", ""+(i+1));
							hmExpTemp.put("store_code", hmExpRecord.get("STORE_CODE"));
							hmExpTemp.put("item_code", hmExpRecord.get("ITEM_CODE"));
							hmExpTemp.put("batch_id", hmExpRecord.get("BATCH_ID"));
							hmExpTemp.put("bin_location_code", hmExpRecord.get("BIN_LOCATION_CODE"));
							hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_DATE"));
							hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));
							hmExpTemp.put("sal_item_qty", hmExpRecord.get("QTY"));
							hmExpTemp.put("ret_item_qty","");
							String stQty	=	(String)hmExpRecord.get("QTY");
							if (stQty==null||stQty.equals("")) {
								continue;
							}
							alExpData.add(hmExpTemp);
						}
					}
				}
			}
		hmTableData.put("HDR_DATA",hmHeader);
		hmTableData.put("COMMON_DATA",hmCommonData);
		hmTableData.put("DTL_DATA",alDtlData);
		hmTableData.put("DTL_EXP_DATA",alExpData);

System.out.println("hmTableData@@@===>"+hmTableData);
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_REQUEST"), RequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass();
			paramArray[1] = hmSQLMap.getClass();

			eST.Common.StSales	stSales	 =	 new eST.Common.StSales();
			
			if(alUpdateItemData.size()>0){
				hmResult = (HashMap)(busObj.getClass().getMethod("insertOT",paramArray)).invoke(busObj,argArray);
				if(((Boolean) hmResult.get("result")).booleanValue()){
					req_doc_no = (String)hmResult.get("req_doc_no");
					if(alDtlData.size()>0){
						hmResult					=	stSales.insertSales(conn,hmTableData);
					}
				}
			}else{
				if((alDtlData.size()>0)&&!(((String)hmHdrData.get("MODE")).equals("U"))){
					hmResult					 =	 stSales.insertSales(conn,hmTableData);
				}else if(alDtlData.size()>0){
					hmResult					 =	 stSales.updateSales(conn,hmTableData);
				}
			}
			hmResult.put("req_doc_no",req_doc_no);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(((Boolean) hmResult.get("result")).booleanValue()){
				hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}else{
				hmResult.put("message",(String) hmResult.get("message")) ;
			}
		
		}
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 

		return hmResult;
	}

	public String getBLModuleInstalled() throws Exception{
		HashMap result = fetchRecord(getStRepositoryValue( "SQL_ST_SAL_CHARGEABLE_YN"));
		String result_yn = (String)result.get("BL_INTERFACE_YN");
		return result_yn;
	}
public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,String item_qty,String store_code)throws Exception{
		DecimalFormat dfTest = new DecimalFormat("##.00");
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap();
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "ST");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, store_code);
			callableStatement.setInt(9, Integer.parseInt(item_qty));
			callableStatement.setString(10, "");
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.FLOAT);
			callableStatement.registerOutParameter(16, Types.FLOAT);
			callableStatement.registerOutParameter(17, Types.FLOAT);
			callableStatement.registerOutParameter(18, Types.FLOAT);
			callableStatement.registerOutParameter(19, Types.FLOAT);
			callableStatement.registerOutParameter(20, Types.FLOAT);
			callableStatement.registerOutParameter(21, Types.FLOAT);
			callableStatement.registerOutParameter(22, Types.FLOAT);
			callableStatement.registerOutParameter(23, Types.FLOAT);
			callableStatement.registerOutParameter(24, Types.FLOAT);
			callableStatement.registerOutParameter(25, Types.FLOAT);
			callableStatement.registerOutParameter(26, Types.FLOAT);
			callableStatement.registerOutParameter(27, Types.FLOAT);
			callableStatement.registerOutParameter(28, Types.FLOAT);
			callableStatement.registerOutParameter(29, Types.VARCHAR);
			callableStatement.registerOutParameter(30, Types.FLOAT);
			callableStatement.registerOutParameter(31, Types.VARCHAR);
			callableStatement.registerOutParameter(32, Types.VARCHAR);
			callableStatement.registerOutParameter(33, Types.VARCHAR);
			callableStatement.registerOutParameter(34, Types.VARCHAR);
			callableStatement.registerOutParameter(35, Types.VARCHAR);
			callableStatement.registerOutParameter(36, Types.VARCHAR);
			callableStatement.registerOutParameter(37, Types.VARCHAR);
			callableStatement.registerOutParameter(38, Types.VARCHAR);
			callableStatement.setString(39, "");
			callableStatement.setString(40, "");

			callableStatement.setString(41, "N");
			callableStatement.setString(42, "");
			callableStatement.setString(43, "");
			callableStatement.setString(44, "");
			callableStatement.setString(45, "N"); //p_discharge_ind
			callableStatement.registerOutParameter(46, Types.VARCHAR); //p_drug_penalty_str Changes done for JD-CRF-0170


			callableStatement.execute();
			
			message.put("daytypecode" , checkForNull((String)callableStatement.getString(11)));
			message.put("daytypedesc" , checkForNull((String)callableStatement.getString(12)));
			message.put("timetypecode" , checkForNull((String)callableStatement.getString(13)));
			message.put("timetypedesc" , checkForNull((String)callableStatement.getString(14)));
			message.put("baseqty" , callableStatement.getFloat(15)+"");
			
			message.put("baserate" , callableStatement.getString(16)+"");
			message.put("addlfactor" ,callableStatement.getString(17)+"");
			message.put("p_base_charge_amt" , callableStatement.getString(18)+"");
			message.put("grosschargeamt" , dfTest.format(Double.parseDouble(callableStatement.getString(19)+"")));
			
			message.put("discountamt" , callableStatement.getString(20)+"");
			message.put("netchargeamt" , dfTest.format(Double.parseDouble(callableStatement.getString(21)+"")));
			message.put("discountper" , callableStatement.getString(22)+"");
			message.put("patgrosschargeamt" , callableStatement.getString(23)+"");
			message.put("patdiscamt" , callableStatement.getString(24)+"");
			message.put("patnetamt" , callableStatement.getString(25)+"");
			message.put("custgrosschargeamt" , callableStatement.getString(26)+"");
			message.put("custdiscamt" , callableStatement.getString(27)+"");
			message.put("custnewamt" , callableStatement.getString(28)+"");
			message.put("insind" , checkForNull((String)callableStatement.getString(29)));
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		
		return message;
	}
	/*Include exclude for OT*/
	public HashMap getBillingDetail(String patient_id, String encounter_id, String sal_trn_type,String override_excl_incl_ind, String overriden_action_reason,String item_code,String item_qty){
		HashMap hmBlDetail = new HashMap();
		String episode_id = "";
		String visit_id = "";
		String total_charge_amt ="";
		String patient_payable_amt = "";
		String approval_reqd_yn = "";
		String override_allowed_yn = "";
		String error_code ="";		 
		String sys_message_id ="";	
		String error_text = "";		
		Connection connection       = null ;
		CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet rsDecimalPlace= null;
		int decimal_place = 0;
		String decimalFormatString = "#0";
		//order_Date = order_Date+":00";
		if(sal_trn_type !=null && sal_trn_type.equals("X"))
			sal_trn_type = "R";



			//callin billing procedure
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(sal_trn_type.equals("O")||sal_trn_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
			cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
			cstmt.setString( 1, login_facility_id);
			cstmt.setString( 2, "ST");	//module id
			cstmt.setString( 3, "");	//
			cstmt.setString( 4, "");	//
			cstmt.setString( 5, sal_trn_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
			cstmt.setString( 6, patient_id); //patient_id
			cstmt.setString( 7, episode_id);  //episode_id
			cstmt.setString( 8, visit_id);  //p_visit_id  
			cstmt.setString( 9, null); //p_dummy1 - null
			cstmt.setString( 10, null); //p_dummy12 - null
			cstmt.setString( 11, "SAL"); //p_transaction_type
			cstmt.setString( 12, com.ehis.util.DateUtils.getCurrentDate("DMYHM","en")+":00"); //p_charge_date_time	--Service Data and time

			cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
			cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
			cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
			cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

			cstmt.setString( 17, item_code);  //p_item_code

			cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
			cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

			cstmt.setString( 20, "S");  //p_serv_panel_ind

			cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

			cstmt.setString( 22,item_qty );  //qty served
			cstmt.setString( 23, null);  //p_charge_amt  

			cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

			cstmt.setString( 25,null );  //p_store_code -- Store Code from where issued
			cstmt.setString( 26, null);  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
			cstmt.setString( 27,null );  //p_oth_disc_perc if any other manual discount is given from transaction
			cstmt.setString( 28, null);  //p_source_doc_ref		null for Sale
			cstmt.setString( 29,null );  //p_source_doc_ref_line	null for Sale

			cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
			cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
			cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
			cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
			cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
			cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
			cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
			cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
			cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
			cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
			cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
			cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
			cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
			cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
			cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
			cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
			cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
			cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

			cstmt.setString( 48,null );  //p_dummy4 (IN OUT )
			cstmt.setString( 49, null);  //p_batch_prices  (IN OUT )
			
			cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
			cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
			cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
			cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

			cstmt.setString( 54,override_excl_incl_ind );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
			cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason		 --- Pass null or any value entered 

			cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
			cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
			cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

			cstmt.execute() ;
			total_charge_amt		=cstmt.getString(36);
			patient_payable_amt		= cstmt.getString(40);
			override_excl_incl_ind	= cstmt.getString(51)==null?"":cstmt.getString(51);             
			approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
			override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 

			error_code		= cstmt.getString(56);
			sys_message_id	= cstmt.getString(57);
			error_text		= cstmt.getString(58);
			closeStatement( cstmt ) ;

			pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet( rsDecimalPlace ) ;

			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
			}
		}
		catch(Exception e){
			error_text = "Error in Proc";
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				closeResultSet( rsDecimalPlace ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

		hmBlDetail.put("BL_TOTAL_CHARGE_AMT",total_charge_amt);
		hmBlDetail.put("BL_PATIENT_PAYABLE_AMT",patient_payable_amt);
		hmBlDetail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",override_excl_incl_ind);
		hmBlDetail.put("BL_APPROVAL_REQD_YN",approval_reqd_yn);
		hmBlDetail.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
		hmBlDetail.put("BL_ERROR_CODE",error_code);
		hmBlDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
		hmBlDetail.put("BL_ERROR_TEXT",error_text);
		hmBlDetail.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
		return hmBlDetail;
	}
	public String getBLMessage(String msg_id){
		try{
			return (String)((HashMap)fetchRecord("SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) MESSAGE FROM SM_MESSAGE WHERE MESSAGE_ID = ?",msg_id)).get("MESSAGE");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	public int getConvFactTempLocal(String item_code,String store_code){
		int conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();
		try {
			alParameters.add(item_code);
			alParameters.add(store_code);
			conv_fac_temp=Integer.parseInt(checkForNull((String)fetchRecord("SELECT St_Get_Uom_Conv_Fac_Sing_Str(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conv_fac_temp==0?1:conv_fac_temp;
	}

}
