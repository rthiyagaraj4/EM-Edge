/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.util.*;
import javax.servlet.* ;
import javax.servlet.http.*;

public class AdjustStockBean extends StTransaction implements Serializable {

	private StHeaderBean				stHeaderBean	;
	private AdjustStockDetailBean		adjustStockDetailBean	;
	private AdjustStockExpBean			adjustStockExpBean		;
	private ArrayList PDocNo ;
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String adj_type="";
	public String reportserver = "";
	public String report_connect_string = "";
	private String disposable_yn ="";  //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013   
	private String dflt_batch_id ="";  //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013  
	private String manufacturerId="";//added for MO-CRF-20165 START
	private String grnRemarks = ""; 
	private String itemRemarks = "";
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167

	public Object getStHeaderBean() {
		return stHeaderBean;
	}
	

	//Added on 6/16/2005
	public void setStHeaderBean(StHeaderBean stHeaderBean){
		this.stHeaderBean = stHeaderBean;		
	}// EOM 6/16/2005

	public Object getAdjustStockDetailBean() {
		return adjustStockDetailBean;
	}

	public Object getAdjustStockExpBean() {
		return adjustStockExpBean;
	}

	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	
	/*public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id);
	}

	public String getLanguageId() {
		 return language_id;
	}*/
	public void setAdj_type (String adjType) {
		this.adj_type = adjType;
	}
	public String getAdj_type () {
		return this.adj_type;
	}
	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}

	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts 
	public void setDisposable_yn(String disposable_yn) {
		this.disposable_yn = disposable_yn;
	}
	public String getDisposable_yn() {
		return this.disposable_yn;
	}
	public void setDflt_batch_id(String dflt_batch_id) {
		this.dflt_batch_id = dflt_batch_id;
	}
	public String getDflt_batch_id() {
		return this.dflt_batch_id;
	}
	//ends
	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167

	public void  clear() {
		super.clear();
		adjustStockDetailBean=null;
		adjustStockExpBean=null;
		stHeaderBean=null;
		adj_type=null;
		disposable_yn =null;//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013   
		dflt_batch_id =null;//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013   
//		PDocNo = "";
	}

	public void  initialize() {
		super.initialize(); 
		adj_type="";
		adjustStockDetailBean=new AdjustStockDetailBean();
		adjustStockDetailBean.setProperties(getProperties());
		adjustStockExpBean=new AdjustStockExpBean();
		adjustStockExpBean.setProperties(getProperties());
		stHeaderBean=new StHeaderBean();
		stHeaderBean.setProperties(getProperties());
		adj_type="";
		disposable_yn =""; //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013   
		dflt_batch_id =""; //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013   
//		PDocNo = "";
	}

	public void setAll(Hashtable hashtable) {
        adjustStockDetailBean.setAll(hashtable);
    }

	public HashMap validate() {
		/*processs detail records as required based on Records to be deleted var of dtl bean*/
		/*not required to process exp records..*/
		return getMessageHashMap(true);
	}

	public HashMap insert() {

		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		HashMap		hmResult	=	new HashMap()	;
		ArrayList alCommonData=new ArrayList();
		ArrayList allanguageData=new ArrayList();
		alCommonData.add(getLoginById());
		alCommonData.add(getLoginAtWsNo());
		alCommonData.add(getLoginFacilityId());
		alCommonData.add(checkForNull(getDisposable_yn(),"N"));//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013   
		alCommonData.add(getDflt_batch_id());//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013   

		allanguageData.add(getLanguageId());
		try {
			hmSQLMap.put("HdrInsertSQL", getStRepositoryValue("SQL_ST_ADJ_HDR_INSERT"));
			//hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_INSERT"));
			hmSQLMap.put("DtlInsertSQL","INSERT	INTO st_adj_dtl( facility_id,  doc_type_code,  doc_no,	doc_srl_no,	 item_code,	 adj_item_qty,	item_unit_cost,	 item_cost_value,  remarks,	 added_by_id,  added_date,	added_at_ws_no,	 added_facility_id,	 modified_by_id,  modified_date,  modified_at_ws_no,  modified_facility_id,item_adj_type)	VALUES ( ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, SYSDATE,	?, ?, ?, SYSDATE, ?, ?,?)");
			
			hmSQLMap.put("ExpInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_EXP_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			// The Queries for the new Logic.
			hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));

			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));

			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_ADJ"));

			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));

			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));

			hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE"));

			hmSQLMap.put("HeaderCheckSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_SELECT"));
			hmSQLMap.put("HeaderUpdateSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_UPDATE"));

			hmSQLMap.put("DtlUpdateSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_UPDATE"));

			hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));
			hmSQLMap.put("DtlDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_DETAIL_DELETE"));
			hmSQLMap.put("DtlExpDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_DETAIL_EXP_DELETE"));

			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));

			hmSQLMap.put("SQLBatchBlockRelease", getStRepositoryValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));
			hmSQLMap.put("expForDelSQL", getStRepositoryValue("SQL_ST_SELECT_BATCH_FOR_DELETE"));
			hmSQLMap.put("DispoBatchUpdateSQL", getStRepositoryValue("SQL_ST_ADJUSTMENT_DISPOSABLE_BATCH_UPDATE")); //29954


			ArrayList alDtlList	=	adjustStockDetailBean.toArrayList();
			ArrayList alTempDtlList	=	new ArrayList();

			StringTokenizer stRecordsToDelete	=	new StringTokenizer(adjustStockDetailBean.getRecords_to_delete(),",");
			for (int i=0;i<alDtlList.size();i++) {
				if (stRecordsToDelete.hasMoreTokens()) {
					String nextToken = stRecordsToDelete.nextToken();
					if(nextToken.equals("N")) {

						HashMap		hm	=(HashMap)alDtlList.get(i);
						if(((String)hm.get("adjustment_type")).equals("N")){
						hm.put("adj_item_qty","-"+hm.get("adj_item_qty"));
						hm.put("mm_trn_qty","-"+hm.get("mm_trn_qty"));
						hm.put("item_cost_value","-"+hm.get("item_cost_value"));
						
						}
						alTempDtlList.add(hm);
					}
				}
			} 

			ArrayList alHeaderList	=	 stHeaderBean.toArrayListOBS();
			
			boolean isDocNoAutoGenYN = isDocNoAutoGenYN((String)alHeaderList.get(1));
			//if(isDocNoAutoGenYN) {
			//	alHeaderList.set(2,fetchNextDocNo((String)alHeaderList.get(1)));
			//}
			alHeaderList.set(7, adjustStockDetailBean.getFinalized_yn());
			alHeaderList.add(checkForNull(getDisposable_yn(),"N"));//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 

			hmTableData.put("properties",		getProperties());
			hmTableData.put("HdrInsertData",	alHeaderList);
			hmTableData.put("DtlInsertData",	alTempDtlList);
			hmTableData.put("ExpInsertData",	adjustStockExpBean.toArrayList());
			hmTableData.put("CommonData",		alCommonData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
			hmTableData.put("RecordsToDelete",	adjustStockDetailBean.getRecords_to_delete());
			hmTableData.put("LanguageData",	allanguageData);
			if((getItemClassBased("ADJ").equals("Y")) && (getAutoDocGen(stHeaderBean.getDoc_type_code()).equals("Y"))){
				hmTableData = modifiedTableData(hmTableData,"ADJ");
			}
	

			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ADJUST_STOCK"),eST.AdjustStock.AdjustStockHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get("result")).booleanValue() )	{
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else if( hmResult.get("msgid")!=null  ) {
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else {
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message"))) ;
			}

/* SEND TO PRINT ONLINE REPORT STARTS*/		

		//	String doc_no	=	(String)alHeaderList.get(2);
		     ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = stHeaderBean.getDoc_type_code();
			PgetStore_codest = stHeaderBean.getStore_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			if (((String)alHeaderList.get(7)).equals("Y") && (hmResult.get("result") != null) && (((Boolean)hmResult.get("result")).booleanValue())) {
				if (isInternalRequest("ST","STBADJDC") && isDocTypePrintAllowed(PgetDoc_type_code) ) {
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}else{
						//Comented By Sakti Sankar on 06/03/2013 agains Inc#
						/*String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}*/
						hmResult.put("flag",hmResult.get("flag") + "~PS"); //Added By Sakti Sankar on 06/03/2013 agains Inc#
						//doOnlineReportPrinting(doc_no);				
					} 
				}
			}		



/* SEND TO PRINT ONLINE REPORT ENDS*/	

	  	}
		catch(Exception e) {
			e.printStackTrace();




		}
		return hmResult;

	}
	
	public HashMap modify() {


		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		HashMap		hmResult	=	new HashMap()	;
		ArrayList alCommonData=new ArrayList();

		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(stHeaderBean.getDoc_type_code());
			alParam.add(stHeaderBean.getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_ADJ_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND FINALIZED_YN='Y'",alParam)).get("COUNT"));
		}catch(Exception e){
			e.printStackTrace();
		}
		if(doc_count>0){
			hmResult.put("result",false);
			hmResult.put("msgid","ST_DOC_NO_FINALIZED_USER");
			hmResult.put("message",getSTMessage(getLanguageId(),"ST_DOC_NO_FINALIZED_USER","ST"));
			return hmResult;
		}
		alCommonData.add(getLoginById());
		alCommonData.add(getLoginAtWsNo());
		alCommonData.add(getLoginFacilityId());
		alCommonData.add(checkForNull(getDisposable_yn(),"N"));//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013  
		alCommonData.add(getDflt_batch_id());//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013  

		try {
			
			hmSQLMap.put("HdrInsertSQL", getStRepositoryValue("SQL_ST_ADJ_HDR_INSERT"));
			//hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_INSERT"));
			hmSQLMap.put("DtlInsertSQL", "INSERT	INTO st_adj_dtl( facility_id,  doc_type_code,  doc_no,	doc_srl_no,	 item_code,	 adj_item_qty,	item_unit_cost,	 item_cost_value,  remarks,	 added_by_id,  added_date,	added_at_ws_no,	 added_facility_id,	 modified_by_id,  modified_date,  modified_at_ws_no,  modified_facility_id,item_adj_type)	VALUES ( ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, SYSDATE,	?, ?, ?, SYSDATE, ?, ?,?)");
			
			hmSQLMap.put("ExpInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_EXP_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			// The Queries for the new Logic.
			hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));

			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));

			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_ADJ"));

			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));

			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));

			hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE"));

			hmSQLMap.put("HeaderCheckSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_SELECT"));
			hmSQLMap.put("HeaderUpdateSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_UPDATE"));

			hmSQLMap.put("DtlUpdateSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_UPDATE"));

			hmSQLMap.put("DtlDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_DETAIL_DELETE"));
			hmSQLMap.put("DtlExpDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_DETAIL_EXP_DELETE"));

			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));

			hmSQLMap.put("SQLBatchBlockRelease", getStRepositoryValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));
			hmSQLMap.put("expForDelSQL", getStRepositoryValue("SQL_ST_SELECT_BATCH_FOR_DELETE"));
			hmSQLMap.put("DispoBatchUpdateSQL", getStRepositoryValue("SQL_ST_ADJUSTMENT_DISPOSABLE_BATCH_UPDATE")); //29954

			ArrayList alDtlList		=	new ArrayList();
			ArrayList alDtlList1	=(ArrayList)adjustStockDetailBean.toArrayList();

System.out.println("alDtlList1"+alDtlList1);

			for(int i=0 ;i<alDtlList1.size();i++){
				HashMap		hm	=(HashMap)alDtlList1.get(i);
				if(((String)hm.get("adjustment_type")).equals("N")){
				hm.put("adj_item_qty","-"+hm.get("adj_item_qty"));
				hm.put("mm_trn_qty","-"+hm.get("mm_trn_qty"));
				hm.put("item_cost_value","-"+hm.get("item_cost_value"));
				}
			alDtlList.add(hm);
			}
			ArrayList expDtlList=new ArrayList();
			ArrayList expDetailsList=(ArrayList)adjustStockExpBean.toArrayList();

				/* Commented by Ganga for AMS-SCF-0223 [IN:036935]
				int iExpDetailsListSize = expDetailsList.size();

				for(int i=0;i<iExpDetailsListSize;i++) {

					int iList_serial_no = Integer.parseInt(((String)(((HashMap)expDetailsList.get(i)).get("doc_srl_no"))).trim());
					String batch_id = ((String)(((HashMap)expDetailsList.get(i)).get("batch_id"))).trim();

					System.out.println("expDetailsList"+expDetailsList);

							for(int j=0;j<expDetailsList.size();j++){
								
										HashMap		hm	=(HashMap)expDetailsList.get(j);

										int iList_serial_no1 = Integer.parseInt(((String)(hm.get("doc_srl_no"))).trim());
										String batch_id1 = ((String)(hm.get("batch_id"))).trim();
										String first = ((String)(hm.get("first"))).trim();

											if( iList_serial_no == iList_serial_no1 && batch_id1.equals(batch_id)) {
												if(((String)hm.get("adjustment_type")).equals("N") && first.equals("Y")){
												hm.put("item_qty", "-"+hm.get("item_qty"));
												}
												expDtlList.add(hm);
												System.out.println("hm"+hm);
											}
							}
				}*/

				for(int i=0;i<expDetailsList.size();i++){
								
					HashMap		hm	=(HashMap)expDetailsList.get(i);

					if(((String)hm.get("adjustment_type")).equals("N") && ((String)(hm.get("first"))).trim().equals("Y")){
						hm.put("item_qty", "-"+hm.get("item_qty"));
					}
					expDtlList.add(hm);
				}


				System.out.println("expDtlList"+expDtlList);


			ArrayList alHeaderList	=	 stHeaderBean.toArrayListADJ();
			alHeaderList.set(7, adjustStockDetailBean.getFinalized_yn());
			alHeaderList.add(checkForNull(getDisposable_yn(),"N"));//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
			boolean isDocNoAutoGenYN = isDocNoAutoGenYN((String)alHeaderList.get(1));
			hmTableData.put("properties",		getProperties());
			hmTableData.put("HdrInsertData",	alHeaderList);
			hmTableData.put("DtlInsertData",	alDtlList);
		//	hmTableData.put("ExpInsertData",	adjustStockExpBean.toArrayList());
			hmTableData.put("ExpInsertData",	expDtlList);
			hmTableData.put("CommonData",		alCommonData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
			hmTableData.put("RecordsToDelete",	adjustStockDetailBean.getRecords_to_delete());
			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;
		//	eST.AdjustStock.AdjustStockRemote adjustStockremote = null;
			/*InitialContext initialcontext = new InitialContext();
			Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_ADJUST_STOCK"));
			eST.AdjustStock.AdjustStockHome adjustStockhome = (eST.AdjustStock.AdjustStockHome)PortableRemoteObject.narrow(obj1, eST.AdjustStock.AdjustStockHome.class);
			adjustStockremote = adjustStockhome.create();
			hmResult = adjustStockremote.modify(hmTableData, hmSQLMap);*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ADJUST_STOCK"),eST.AdjustStock.AdjustStockHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



			if( ((Boolean) hmResult.get("result")).booleanValue() )	{
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else if( hmResult.get("msgid")!=null  ) {
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else {
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message"))) ;
			}
		      ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = stHeaderBean.getDoc_type_code();
			PgetStore_codest = stHeaderBean.getStore_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			//alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ADJUST_STOCK_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));

			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			

			if (((String)alHeaderList.get(7)).equals("Y") && (hmResult.get("result") != null) && (((Boolean)hmResult.get("result")).booleanValue())) {
				if (isInternalRequest("ST","STBADJDC") && isDocTypePrintAllowed(PgetDoc_type_code)) {
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}else{
						//Comented By Sakti Sankar on 06/03/2013 agains Inc#
						/*String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}	*/
							hmResult.put("flag",hmResult.get("flag") + "~PS"); //Added By Sakti Sankar on 06/03/2013 agains Inc#
					}
				}
				else
					hmResult.put("flag",hmResult.get("flag") + "~PN");
			}
			else
				hmResult.put("flag",hmResult.get("flag") + "~PN");
		}


		catch(Exception e) {
			e.printStackTrace();
		}
		return hmResult;
	}
	/*public void doOnlineReportPrinting(String doc_no) {
		try{
			String reportid = "STBADJDC";
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);

//			if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

      //      javax.servlet.http.HttpSession session = request.getSession(false);
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			//hmParameters.put("jdbc",session.getAttribute("jdbc"));
			//hmParameters.put("report_server",session.getAttribute("report_server"));
		    //hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();   
		}							   
	}*/
//Added By Sakti Sankar on 06/03/2013 against Inc#

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{

			String reportid = "STBADJDC";
			//String copies = getNoOfCopies(reportid);
	
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", "STBADJDC") ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", "STBADJDC", "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}


	public boolean DocTypePrintAllowed (String PgetDoc_type_code){
		if (isDocTypePrintAllowed(PgetDoc_type_code)) 
			return true;
		else
			return false;
	}


/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "STBADJDC";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", stHeaderBean.getStore_code());

			reportParam.addParameter("p_module_id","ST");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());
			reportParam.addParameter("p_doc_type_code",stHeaderBean.getDoc_type_code());
	//			reportParam.addParameter("p_fr_st_code",getStore_code());
			reportParam.addParameter("p_doc_no",doc_no);
			reportParam.addParameter("p_fr_date",stHeaderBean.getDoc_date());
			reportParam.addParameter("p_to_date",stHeaderBean.getDoc_date());


			onlineReports.add(reportParam) ;
			String ReportOutput = onlineReports.execute( request, response);
		
		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	}
*/	
	public HashMap delete() {

		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		HashMap		hmResult	=	new HashMap()	;
		ArrayList alCommonData=new ArrayList();

		alCommonData.add(getLoginById());
		alCommonData.add(getLoginAtWsNo());
		alCommonData.add(getLoginFacilityId());

		try {
			hmSQLMap.put("HdrInsertSQL", getStRepositoryValue("SQL_ST_ADJ_HDR_INSERT"));
			hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_INSERT"));
				
			
			hmSQLMap.put("ExpInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_EXP_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			// The Queries for the new Logic.
			hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_ADJ"));

			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));

			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));

			hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE"));

			hmSQLMap.put("HeaderCheckSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_SELECT"));
			hmSQLMap.put("HeaderUpdateSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_UPDATE"));

			hmSQLMap.put("DtlUpdateSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_UPDATE"));

			hmSQLMap.put("DtlDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_DETAIL_DELETE"));
			hmSQLMap.put("DtlExpDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_DETAIL_EXP_DELETE"));

			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));

			hmSQLMap.put("HdrDeleteSQL", getStRepositoryValue("SQL_ST_ADJ_HEADER_DELETE"));

			hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));

			hmSQLMap.put("SQLBatchBlockRelease", getStRepositoryValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));


		
			ArrayList alDtlList		=	new ArrayList();
			ArrayList alDtlList1	=	(ArrayList)adjustStockDetailBean.toArrayList();
			for(int i=0 ;i<alDtlList1.size();i++){
				HashMap		hm	=(HashMap)alDtlList1.get(i);
				if(((String)hm.get("adjustment_type")).equals("N")){
				hm.put("adj_item_qty","-"+hm.get("adj_item_qty"));
				hm.put("mm_trn_qty","-"+hm.get("mm_trn_qty"));
				hm.put("item_cost_value","-"+hm.get("item_cost_value"));
				}
			alDtlList.add(hm);
			}
			


			ArrayList alHeaderList	=	 stHeaderBean.toArrayListADJ();
			alHeaderList.add(checkForNull(getDisposable_yn(),"N"));//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013   


			boolean isDocNoAutoGenYN = isDocNoAutoGenYN((String)alHeaderList.get(1));



			hmTableData.put("properties",		getProperties());


			ArrayList expDtlList=new ArrayList();
			ArrayList expDetailsList=(ArrayList)adjustStockExpBean.toArrayList();
			
			/*Commented by Ganga for AMS-SCF-0223 [IN:036935]
			int iExpDetailsListSize = expDetailsList.size();
				for(int i=0;i<iExpDetailsListSize;i++) {
					int iList_serial_no = Integer.parseInt(((String)(((HashMap)expDetailsList.get(i)).get("doc_srl_no"))).trim());
					String batch_id = ((String)(((HashMap)expDetailsList.get(i)).get("batch_id"))).trim();
                for(int j=0;j<expDetailsList.size();j++)
					{
						HashMap		hm	=(HashMap)expDetailsList.get(j);
						int iList_serial_no1 = Integer.parseInt(((String)(hm.get("doc_srl_no"))).trim());
						String batch_id1 = ((String)(hm.get("batch_id"))).trim();
						String first = ((String)(hm.get("first"))).trim();
					if( iList_serial_no == iList_serial_no1 && batch_id1.equals(batch_id)) {
					if(((String)hm.get("adjustment_type")).equals("N") && first.equals("Y")){
					hm.put("item_qty", "-"+hm.get("item_qty"));
					}
				expDtlList.add(hm);
					}
				}
				}
				*/

				for(int i=0;i<expDetailsList.size();i++){
								
					HashMap		hm	=(HashMap)expDetailsList.get(i);

					if(((String)hm.get("adjustment_type")).equals("N") && ((String)(hm.get("first"))).trim().equals("Y")){
						hm.put("item_qty", "-"+hm.get("item_qty"));
					}
					expDtlList.add(hm);
				}


				System.out.println("expDtlList delete"+expDtlList);





			hmTableData.put("HdrInsertData",	alHeaderList);
			hmTableData.put("DtlInsertData",	alDtlList);
		//	hmTableData.put("ExpInsertData",	adjustStockExpBean.toArrayList());
			hmTableData.put("ExpInsertData",	expDtlList);
			hmTableData.put("CommonData",		alCommonData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
			hmTableData.put("RecordsToDelete",	adjustStockDetailBean.getRecords_to_delete());

			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;	  

			/*hmResult = new eST.AdjustTemp.AdjustStockManager().delete( hmTableData, hmSQLMap ) ; */

//			eST.AdjustStock.AdjustStockRemote adjustStockremote = null;
			/*InitialContext initialcontext = new InitialContext();
			Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_ADJUST_STOCK"));
			eST.AdjustStock.AdjustStockHome adjustStockhome = (eST.AdjustStock.AdjustStockHome)PortableRemoteObject.narrow(obj1, eST.AdjustStock.AdjustStockHome.class);
			adjustStockremote = adjustStockhome.create();
			hmResult = adjustStockremote.delete(hmTableData, hmSQLMap);*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ADJUST_STOCK"),eST.AdjustStock.AdjustStockHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



			if( ((Boolean) hmResult.get("result")).booleanValue() )	{
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else if( hmResult.get("msgid")!=null  ) {
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else {
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message"))) ;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}


		return hmResult;
	}




	/*	public HashMap validate(){
			//Remove records with Del check box checked
			HashMap hashmap = new HashMap();
			hashmap.put("result", super.TRUE);

		try{
			// if all checkboxes are checked or no data is entered..
				if(adjustStockDetailBean.toArrayList()== null || adjustStockDetailBean.getRecords_to_delete().indexOf("N") == -1)
					throw new Exception("MIN_ONE_DETAIL_REQUIRED");
				}
			catch(Exception exception)
			{
				hashmap.put("result", super.FALSE);
				hashmap.put("msgid", exception.getMessage());
				hashmap.put("message", exception.toString());
			}
			return hashmap;
		}
	*/

	public HashMap getItemDetail(String item_code) {
		return adjustStockDetailBean.getItemDetail(item_code);
	}

	// to call Detail Bean method to load the data

	public ArrayList getDetailValues() {
		return adjustStockDetailBean.toArrayList();
	}

	public HashMap getDetailList(String doc_srl_no) {
		return adjustStockDetailBean.getValues(doc_srl_no);
	}

	public ArrayList getExpList(String doc_srl_no) {
		
		return  adjustStockExpBean.getDtlExpList(Integer.parseInt(doc_srl_no));
	}

	public String getDoc_srl_no() {
		return adjustStockDetailBean.getDoc_srl_no();
	}

	public String getItem_code() {
		return adjustStockDetailBean.getItem_code();
	}

	public String getAdj_item_qty() {
		return adjustStockDetailBean.getAdj_item_qty();
	}

	public String getItem_unit_cost() {
		return adjustStockDetailBean.getItem_unit_cost();
	}

	public String getItem_cost_value() {
		return adjustStockDetailBean.getItem_cost_value();
	}

	public String getRemarks() {
		return adjustStockDetailBean.getRemarks();
	}

	public void setDetailValues(HashMap hashmapDtl) {
		adjustStockDetailBean.setValues(hashmapDtl);
	}

	public void setExpValues( Hashtable htFormValues) {
		adjustStockExpBean.setValues(htFormValues);
	adjustStockExpBean.setLanguage_id(getLanguageId());
	}
	public String getTradeList(String item_code, String trade_id) {
		return adjustStockExpBean.getTradeList(item_code,trade_id,getLanguageId());
	}

 public ArrayList getDefltTrdId() {
        
        ArrayList alDfltTrdId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
		
			String select_option=getSTMessage(getLanguageId(),"SELECT_OPTION","ST") ;
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alDfltTrdId.add(select_option_legend);
//*			String stDfltTradeId="";
            connection = getConnection();
				
				
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_DEFAULT_TRADE_ID"));
 		    resultSet = pstmt.executeQuery();
			
            while (resultSet != null && resultSet.next()) {
				
alDfltTrdId.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
				
			   }
		    }
			catch (Exception e) {
                      e.printStackTrace();
             } 
		    finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
                   }
				   
          return alDfltTrdId;
	  }
	public String getTradeListDflt(String trade_id) {
		return getListOptionTag(getDefltTrdId(),trade_id);
	//	return adjustStockExpBean.getTradeListDflt(trade_id,getLanguageId());
	}

	public String getBinLocationList(String store_code,String bin_location_code) {
		return adjustStockExpBean.getBinLocationList(store_code,bin_location_code,getLanguageId());
	}

	public String getTradeList(String item_code) {
		return adjustStockExpBean.getTradeList(item_code,getLanguageId());
	}

	public String getBinLocationList(String store_code) {
		return adjustStockExpBean.getBinLocationList(store_code,getLanguageId());
	}

	public int getNextDocSerialNo() {
		return adjustStockDetailBean.getNextDocSerialNo();
	}

	/**
	* Method to retrive the default batch_id from MM_parameter table.
	* @return String, The default_batch_id for a particular item.
	*/

	public String getDefault_batch_id() {
		return adjustStockExpBean.getDefault_batch_id ();
	}

	public String getDefault_trade_id() {
		return adjustStockExpBean.getDefault_trade_id ();
	}

	/**
	* Method to retrive the Document date from the hearder bean. This is used to substitute
	* for expiry date when it expiry date is not there for a batch. Usually, the Documant
	* date will be the current date.
	*/

	public String getDoc_date() {
		return stHeaderBean.getDoc_date();
	}

	/**
	* Method to create batch id by using the given expiry date.
	* This is just a replacement of '/' with ''.
	* @param String, the expiry date entered
	* @param String, the batch id.
	*/

	public String getBatchIDFromExpiryDate (String expiry_date) {
		return adjustStockExpBean.getBatchIDFromExpiryDate(expiry_date);
	}

	public void setAdjustStockHeaderBean( StHeaderBean HdrData) {
		stHeaderBean=HdrData;
	}


	public String ValidItemCodeOrDesc(String search_code) {
		HashMap hm=new HashMap();
		ArrayList arr_language=new ArrayList();
		arr_language.add(search_code);
		arr_language.add(getLanguageId());
		String returnValue="";
		try {
			hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SEARCH_SELECT"),arr_language);
			returnValue=(String)hm.get("ITEM_DESC");

			if(returnValue.equals("")) {
				hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DESC_SEARCH_SELECT"),arr_language);
				returnValue=(String)hm.get("ITEM_DESC");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}


	public HashMap getDefault_remarks() {
		HashMap hm=new HashMap();
        ArrayList al_parameters = new ArrayList();
		al_parameters.add(getLoginFacilityId());
		al_parameters.add("ALL");
		al_parameters.add(getLanguageId());
        
		try {
			hm=fetchRecord(getStRepositoryValue("SQL_ST_ADJUST_STOCK_DEFAULT_REMARKS_SELECT"),al_parameters);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return hm ;
	}


	public String getDefaultBinLocationCode (String item_code) {
		return adjustStockExpBean.getDefaultBinLocationCode ( item_code, stHeaderBean.getStore_code(),getLanguageId()) ;
	}

	public String getSysDate () {
		return stHeaderBean.getSysDate () ;
	}

	public String toString() {
		return	""+	adjustStockExpBean.toArrayList();
	}

	public String fetchItemUnitCost(String item_code) {

		// dataMap.put("SQL_ST_ADJ_DTL_SELECT"," SELECT item_unit_cost from st_adj_dtl WHERE facility_id=? and doc_type_code=? AND doc_no=? AND doc_srl_no=? AND item_code=?");
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(stHeaderBean.getDoc_type_code());
		alParameters.add(stHeaderBean.getDoc_no());
		alParameters.add(adjustStockDetailBean.getDoc_srl_no());
		alParameters.add(item_code);

		HashMap hmRecord=new HashMap();
		int noOfDecimalsForCost=0;
		try {
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_ADJ_DTL_SELECT"),alParameters);
			/**
		 * @Name - Priya
		 * @Date - 20/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
		 */
		noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		
		return setNumber((String)hmRecord.get("ITEM_UNIT_COST"), noOfDecimalsForCost);
	}

	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};

		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		
		/*if (getadj_type().equals("Y")) {
			return hmRecord.get("ADJ_FINALIZE_ALLOWED_YN").toString();
		}
		else{
			return hmRecord.get("ISS_FINALIZE_ALLOWED_YN").toString();
		}*/
		String finalize=(String)hmRecord.get("ADJ_FINALIZE_ALLOWED_YN");
		
		return finalize;
	}


	/* Commented on june 21
	public String getAdj_List() {
		//return getStaticListOptionTag( "P,+ve;N,-ve;", getStore_type_flag());
		return getStaticListOptionTag( "P,+ve;N,-ve;");
	}
	*/

	public ArrayList getBatchDetails(String item_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		
		//int isValidDocDate = -1;
		try {
			// To call the procedure st_stock_availability_status
			String[] strParameters = new String[7];
			strParameters[0] = item_code;
//			strParameters[0] = "003";
			strParameters[1] = stHeaderBean.getStore_code();
//			strParameters[1] = "MAIN";
			strParameters[2] = "0"; 
			strParameters[3] = "N";
			strParameters[4] = (String)getStParameter().get("SYS_DATE");
			strParameters[5] = "N";
			strParameters[6] = "";
			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn"));			
			/* @Name - Priya
				* @Date - 20/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS'   and  assign it to the storeItemUnitCost field. And round up 'item_unit_cost' usint noOfDecimalsForCost 
				*/
				String storeItemUnitCost=getUnitCost(item_code,stHeaderBean.getStore_code());
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());

			BatchDetails.add(setNumber((String)hmStockAvailabilityStatus.get("item_unit_cost"),noOfDecimalsForCost));
			BatchDetails.add(storeItemUnitCost);
			//BatchDetails.add(setNumber(((String)hmStockAvailabilityStatus.get("store_item_unit_cost")),3));
			/* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - "available_stock" & "expired_stock" Integer is changed to Double.
			*/
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("available_stock")));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("expired_stock")));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));
		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw new Exception("ITEM_STORE_NOT_FOUND");//exception;
		}
		finally { 
	
		}
		return BatchDetails;
	}

	// Methods added for Query page

	public String getDocTypeCodes(){
		String defaultDocType = "";
		return getDefaultDocumentTypeList("ADJ",defaultDocType);
	}

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}

	public String getStore_code_List() {
		ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLoginById());
        arraylist.add(getLanguageId());

        return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_ADJ_STORE_SELECT"), arraylist), stHeaderBean.getStore_code());
    }

	public String getQRYStore_code_List(String store_code) {
		ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLoginById());
        arraylist.add(getLanguageId());
        return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_QRY_ST_ADJ_STORE_SELECT"), arraylist), checkForNull(stHeaderBean.getStore_code(),store_code));
	}

	public void loadAllItemData(String doc_type_code, String doc_no) {

		try {
			adjustStockDetailBean.setLanguageId(getLanguageId());
			adjustStockDetailBean.loadAllItemData(doc_type_code, doc_no,getLanguageId(),getLoginFacilityId());
			ArrayList detailList = adjustStockDetailBean.toArrayList();

			// 2 lines added 07/09/04
			ArrayList alParam = new ArrayList();
			alParam.add(doc_type_code);
			alParam.add(doc_no);
			alParam.add(getLoginFacilityId());
			String max_doc_srl_no = (String)((HashMap)fetchRecord("SELECT MAX(DOC_SRL_NO) MAX_DOC_SRL_NO FROM ST_ADJ_DTL WHERE DOC_TYPE_CODE = ? AND DOC_NO = ? AND FACILITY_ID = ?",alParam)).get("MAX_DOC_SRL_NO");

			adjustStockDetailBean.setNextDocSerialNo(Integer.parseInt(checkForNull(max_doc_srl_no,"0")));
			adjustStockExpBean.SetNextDocSerialNo(Integer.parseInt(checkForNull(max_doc_srl_no,"0")));
//			adjustStockDetailBean.setNextDocSerialNo(detailList.size());
//			adjustStockExpBean.SetNextDocSerialNo(detailList.size());

           //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013   
			String disposable_yn_hdr = checkForNull((String)((HashMap)fetchRecord("SELECT DISPOSABLE_YN FROM	st_adj_hdr WHERE  doc_type_code = ? and  doc_no = ? and facility_id=?",alParam)).get("DISPOSABLE_YN"),"N");
			setDisposable_yn(disposable_yn_hdr);  
			System.out.println("disposable_yn_hdr" +disposable_yn_hdr);

			for(int i=0;i<detailList.size();i++) {
				HashMap detailRow = (HashMap)detailList.get(i);
				String l_doc_type_code = (String)detailRow.get("doc_type_code");
				String l_doc_no = (String)detailRow.get("doc_no");
				String l_doc_srl_no = (String)detailRow.get("doc_srl_no");
				String l_item_code = (String)detailRow.get("item_code");
				loadAllBatchDetails(l_doc_type_code,l_doc_no,l_doc_srl_no,l_item_code);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadAllBatchDetails(String doc_type_code, String doc_no, String doc_srl_no, String item_code) {

		try {
			adjustStockExpBean.loadAllBatchDetails(doc_type_code, doc_no, doc_srl_no, item_code);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		Connection connection = null;
		//int isValidDocDate = -1;
		try {
			connection = getConnection();

			// To call the procedure st_stock_availability_status

			String[] strParameters = new String[7];

			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";
			strParameters[6] = "";

			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);
		
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));
		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw new Exception("ITEM_STORE_NOT_FOUND");//exception;
		}
		finally {
			closeConnection(connection);
		}
		return BatchDetails;
	}

	public boolean isDuplicateInExpList (Hashtable htFormValues) {
		return adjustStockExpBean.isDuplicateInExpList(htFormValues,getLanguageId());//getLanguageId() added by Badmavathi for SRR20056-SCF-14071
	}


				// code added for negative stock on 1/12/2003
	public boolean isNegativeAllowed (Hashtable htFormValues , String store_code , String item_code) {
		
		boolean results = false;
		try{
		results = adjustStockExpBean.isNegativeAdjustmentAllowed(htFormValues , store_code , item_code,getLanguageId());//getLanguageId() added by Badmavathi for SRR20056-SCF-14071

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}

public  String getLastCost  (String item_code){
		
		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_LAST_COST_SELECT_FOR_ADJ"),item_code);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("LAST_COST");
	} 

public String isBatchIdExits (Hashtable htFormValues,String store_code , String item_code) {
		return adjustStockExpBean.isBatchIdExits(htFormValues,store_code ,item_code,getLanguageId());
	}
	public boolean get_unfinalized_trn_status(String [] stParameters)throws Exception
{
		Connection connection = null;
		CallableStatement callableStatement = null;
//		HashMap hmReturn	=	new HashMap();
		boolean result = false;
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ CALL ST_CHK_UNFINALIZED_TRN (?,?,?) }");
			callableStatement.setString(1, stParameters[0]);//item_code
			callableStatement.setString(2, stParameters[1]);//store_code
			callableStatement.registerOutParameter(3, Types.INTEGER);	// count 
			callableStatement.execute();
			if (callableStatement.getLong(3) == 0)
			{
				result = true;
			}
			else
				result = false;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return result;
	}
	public String getAdjustStockItemClassBased(String trntype)
	{
		String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				
				records = fetchRecord(getStRepositoryValue("SQL_ST_GRN_ITEM_CLASS_BASED_YN"),chkdefaultParameters);
				result=(String)records.get("ITEM_CLASS_BASED_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
public HashMap modifiedTableData(HashMap hmTableData,String trn_type){
		String item_class_code = "";
		int records_per_trn = getRecordsPerTrn(trn_type);
		ArrayList<Integer> alCount =  new ArrayList<Integer>();
		HashMap<String,String> hmTempData = new HashMap<String,String>();
		HashMap<String,String> hmTempExpData = new HashMap<String,String>();
		ArrayList<HashMap> alNewTempDtlData = new ArrayList<HashMap>();
		ArrayList<HashMap> alNewTempDtlExpData = new ArrayList<HashMap>();
		ArrayList<String> alItemClassData = new ArrayList<String>();
		ArrayList<String> alNewItemClassData = new ArrayList<String>();
		ArrayList<HashMap> alItemDtlData = (ArrayList<HashMap>)hmTableData.get("DtlInsertData");
		ArrayList<HashMap> alItemDtlExpData = (ArrayList<HashMap>)hmTableData.get("ExpInsertData");
		ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		ArrayList<String> alItemHdrData = (ArrayList<String>)hmTableData.get("HdrInsertData");
		for(int i=0;i<alItemDtlData.size();i++){
			hmTempData = (HashMap<String,String>)alItemDtlData.get(i);
			try{
				item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
				if(!alItemClassData.contains(item_class_code)){
					alItemClassData.add(item_class_code);
				}
				//alItemClassData.add((String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(4)).get("ITEM_CLASS_CODE"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Collections.sort(alItemClassData);
		for(int i=0;i<alItemClassData.size();i++){
			alNewItemClassData.add(alItemClassData.get(i));
		}
		item_class_code = "";
		for(int i=0;i<alItemClassData.size();i++){
			int k = 0;
			//int count = 0;
			for(int j=0;j<alItemDtlData.size();j++){
				hmTempData = new HashMap<String,String>();
				hmTempData = alItemDtlData.get(j);
				//hmTempExpData = (HashMap<String,String>)alItemDtlExpData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
						//++count;
						if(k>=records_per_trn){
							alCount.add(k);
							k = 0;
							alNewItemClassData.add(item_class_code);
						}
						hmTempData.put("doc_srl_no",""+ (++k));
						alNewTempDtlData.add(alItemDtlData.get(j));
						for(int m=0;m<alItemDtlExpData.size();m++){
							hmTempExpData = new HashMap<String,String>();
							hmTempExpData = alItemDtlExpData.get(m);
							if((hmTempExpData.get("item_code")).equals(hmTempData.get("item_code"))){
								hmTempExpData.put("doc_srl_no",""+k);
								alNewTempDtlExpData.add(alItemDtlExpData.get(m));
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			alCount.add(k);
		}
		Collections.sort(alNewItemClassData);
		for(int i=0;i<alNewItemClassData.size();i++){
			ArrayList<String> alTemp = new ArrayList<String>();
			for(int j=0;j<alItemHdrData.size();j++){
				alTemp.add(alItemHdrData.get(j));
			}
			alTemp.set(12,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
		//hmTableData.put("InsertDTLData",alNewTempDtlData);
		hmTableData.put("HdrInsertData",alNewItemHdrData);
		hmTableData.put("DtlInsertData",alNewTempDtlData);
		hmTableData.put("ExpInsertData",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}

/*public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1.0;
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		ArrayList alParameters = new ArrayList();
		try {
			
			
			alParameters.add(item_code);
			alParameters.add(store_code);

			 conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT St_Get_Uom_Conv_Fac_Sing_Str(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return conv_fac_temp;
	}*/
	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts
	public HashMap getDisp_batch(String stStore_code) throws Exception{
	HashMap hmRecord	=	null;
		try {
			  hmRecord = fetchRecord("SELECT NEXT_BATCH_ID,BATCH_ID_SERIES FROM ST_STORE_DISPOSE_BATCH WHERE STORE_CODE =? and eff_status = 'E' and  AUTO_GEN_BATCH_YN = 'Y' ",stStore_code);
			//System.out.println("hmRecordhmRecord=1378=>"+hmRecord);
		}
		catch(Exception e) {
			e.printStackTrace();
			//return "";
		}
		return hmRecord;
	}
	
	public String getDisp_Expdate() throws Exception{
		HashMap hmRecord	=	null;
		try{
		hmRecord =    fetchRecord("SELECT  NVL(DFLT_DURN_FOR_EXPDATE,0)DFLT_DURN_FOR_EXPDATE, TO_CHAR(SYSDATE,'DD/MM/YYYY')SYSTEMDATE ,TO_CHAR(SYSDATE+NVL(DFLT_DURN_FOR_EXPDATE,0), 'DD/MM/YYYY') DFLT_EXP_DATE  FROM  ST_FACILITY_PARAM   WHERE FACILITY_ID = ? ",getLoginFacilityId());	
		
			//System.out.println("hmRecordhmRecord==1388===>"+hmRecord);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("DFLT_EXP_DATE");
	}
	//ends
	
	public String getItemByGTIN(String barcode_id)throws Exception{//Adding start for MOHE-CRF-0167
	    
		 HashMap itemDetails =new HashMap();
		 LinkedList batchData=new LinkedList();	 
		 HashMap barcodeData = getBarcodeData();
		 String gtin_item="";
		 String temp_expiry_date ="";
		 String temp_batch_id ="";
		 boolean rec_found = false;
		 HashMap BarcodeDetails = new HashMap();

	    
		   try{
	    
	       String gtin = null;
	       String batchNumber = null;
	       String expiryDate = null;
			String srlNo      =null;

			BarcodeDetails =getBarcodedetails(barcode_id);
			gtin =(String)BarcodeDetails.get("GTIN");
			expiryDate =(String)BarcodeDetails.get("EXPIRY_DATE");
			batchNumber =(String)BarcodeDetails.get("BATCH_ID");
			srlNo =(String)BarcodeDetails.get("SRLNO");

	       
			SimpleDateFormat inputFormat = new SimpleDateFormat("yymmdd");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
			java.util.Date inputDate = inputFormat.parse(expiryDate); 

			String temp_exp_date = outputFormat.format(inputDate);

	           System.out.println("new GTIN: " + gtin);
	           System.out.println("new Expiry Date: " + expiryDate+"temp_exp_date==="+temp_exp_date);
	           System.out.println("new Batch ID: " + batchNumber);

	           System.out.println("new GTIN get2DBarcodeItem: " + gtin);
	           
			
				ArrayList alParameters	=	new ArrayList(4);
				
				alParameters.add(checkForNull(gtin));
				
	            gtin_item =	checkForNull((String)fetchRecord("SELECT B.ITEM_CODE FROM AM_TRADE_NAME A, MM_TRADE_NAME_FOR_ITEM B WHERE MANUFACTURER_ID = ? AND A.TRADE_ID = B.TRADE_ID",alParameters).get("ITEM_CODE"));

			if(barcodeData.containsKey(gtin_item)){
					   batchData = (LinkedList)barcodeData.get(gtin_item);
					   for(int i=0;i<batchData.size();i+=2){
					      temp_expiry_date = (String)batchData.get(i+1);
						  temp_batch_id    = (String)batchData.get(i);
						  if(batchNumber.equals(temp_batch_id) && temp_exp_date.equals(temp_expiry_date)){
							  rec_found =true;
							  break;
						  }
					   }

			}else {
					  batchData  =new LinkedList();
			}
			if(!rec_found){
			   batchData.add(batchNumber);
			   batchData.add(temp_exp_date);
			   itemDetails.put(gtin_item,batchData);
			   setBarcodeData(itemDetails);
			}
		   }
			catch (Exception exception) {
				System.out.println("Exception thrown from get2DBarcodeItem = >"+exception.getMessage());
				exception.printStackTrace();
				throw exception;
			 }

			 return gtin_item;
	}//Adding end for MOHE-CRF-0167
}
