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
1/2/2018				66368					Shazana 						  								GHL-CRF-0503 Split batch	
16/5/2018										Shazana															GHL-ICN-0023 - SPLIT BATCH
22/9/2021			TFS:22321					Shazana															GHL-SCF-1587
24/02/2022				TFS29023 				Mohamed															Common-ICN-0091  
--------------------------------------------------------------------------------------------------------------------------------------------
 */

 package eST;

import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import eST.Common.StAdapter; 
import java.io.Serializable;
import java.util.*;
import eST.SplitBatch.*;
import javax.rmi.* ;
import eST.Common.*;
import javax.servlet.* ;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import javax.naming.* ;
import java.sql.Connection;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

public class SplitBatchBean extends StTransaction implements Serializable{
	private StHeaderBean						stHeaderBean	;
	private SplitBatchDetailBean		splitBatchDetailBean	;	
	private SplitBatchExpBean			splitBatchExpBean		;	
	private String supp_code = "";
	//private String language_id;
//Modified on 23/12
	public void initialize()
	{
		super.initialize();
		splitBatchDetailBean=new SplitBatchDetailBean();
		splitBatchExpBean=new SplitBatchExpBean();
		stHeaderBean=new StHeaderBean();
		splitBatchDetailBean.setProperties(getProperties());
		splitBatchExpBean.setProperties(getProperties());
		stHeaderBean.setProperties(getProperties());

	}
//ended...

	public void  clear(){
		super.clear();
		splitBatchDetailBean=null; 
		splitBatchExpBean=null;
		stHeaderBean=null;
	}
	
	/*public void setLanguageId(String language_id) {
		 this.language_id = language_id;
	}
	public String getLanguageId() {
		 return language_id;
	}*/

	public void setAll(Hashtable hashtable) {
        splitBatchDetailBean.setAll(hashtable);
    }

	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean*/
		/*not required to process exp records..*/
		return getMessageHashMap(true);	
	}
	
	public HashMap insert(){
		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		HashMap hmScreenData= new HashMap();
		HashMap hmDtlScreenData= null;//new HashMap();

	//	ArrayList arrDtlData=new ArrayList();
		boolean autoGenerateYN=false;
//		arrDtlData=splitBatchExpBean.toArrayList();
		
		String doc_no="";
		String supp_code_loc ="";
		ArrayList params = new ArrayList ();
		
		//params.add(item_code);

		//supp_code =(String)(fetchRecord(" select SUPP_CODE from ST_GRN_HDR A,ST_GRN_DTL_EXP B where A.FACILITY_ID = B.FACILITY_ID AND   A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.B.FACILITY_ID = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_NO = ? AND B.DOC_SRL_NO = ? AND B.ITEM_CODE = ? AND B.STORE_CODE = ? AND B.BATCH_ID = ? AND B.BIN_LOCATION_CODE = ? AND B.EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'dd/mm/yyyy') ",params).get("SUPP_CODE"));

		try {
			hmSQLMap.put("HdrInsertSQL", "INSERT	INTO st_split_batch_hdr(facility_id, doc_type_code,	doc_no,	doc_date, doc_ref, store_code, added_by_id,	added_date,	added_at_ws_no,	added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,ITEM_CLASS_CODE) VALUES(?, ?,	?, to_date(?,'dd/mm/yyyy'),	?, ?, ?, SYSDATE, ?, ?,	?, SYSDATE,	?, ?,?)");
			hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_SPLIT_BATCH_DTL_INSERT"));
			hmSQLMap.put("ExpInsertSQL", getStRepositoryValue("SQL_ST_SPLIT_BATCH_DTL_EXP_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemTrnDtlInsert", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_COM_INSERT"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));

			

			ArrayList alDtlList	=	splitBatchDetailBean.toArrayList();
			ArrayList alHdrListS	=null;
			ArrayList alHdrListRows	=	new ArrayList();
			ArrayList alHDtlScreenRows	=	null;
			ArrayList alDtlListS	=	null;
			ArrayList alDtlListRows	=	new ArrayList();
			ArrayList alDtlListExpS	=	null;
			ArrayList alDtlListExpRows	=	new ArrayList();

			ArrayList alDtlListTrnDtl	=	null;
			ArrayList alDtlListTrnDtlRows	=	new ArrayList();

			ArrayList alDtlListTrnRows	=	new ArrayList();
			ArrayList alDtlListTrnBatchDtl	=	null;
			ArrayList alDtlListTrnBatchDtlRows	=	new ArrayList();
			ArrayList alCommon	=	new ArrayList();
			ArrayList languageData	=	new ArrayList();
			ArrayList alBatchDtl	=	new ArrayList();

			alCommon.add(getLoginById());
			alCommon.add(getLoginAtWsNo() );
			alCommon.add(getLoginFacilityId() );
			alCommon.add(stHeaderBean.getDoc_type_code());
			
			languageData.add(getLanguageId());

			StringTokenizer stRecordsToDelete	=	new StringTokenizer(splitBatchDetailBean.getRecords_to_delete(),",");
			autoGenerateYN=isDocNoAutoGenYN(stHeaderBean.getDoc_type_code());

			if(autoGenerateYN)
				doc_no=fetchNextDocNo(stHeaderBean.getDoc_type_code());
			else
				doc_no=stHeaderBean.getDoc_no();

				alHdrListS=new ArrayList();
				alHdrListS.add(getLoginFacilityId() );
				alHdrListS.add(stHeaderBean.getDoc_type_code());
				alHdrListS.add(doc_no);
				alHdrListS.add(stHeaderBean.getDoc_date());
				alHdrListS.add(stHeaderBean.getDoc_ref());
				alHdrListS.add(stHeaderBean.getStore_code());
				alHdrListS.add(getLoginById());
				alHdrListS.add(getLoginAtWsNo() );
				alHdrListS.add(getLoginFacilityId() );
				alHdrListS.add(getLoginById());
				alHdrListS.add(getLoginAtWsNo() );
				alHdrListS.add(getLoginFacilityId() );
				alHdrListRows.add(alHdrListS);

				int srl_no=1;
				HashMap itemtoItemClass = new HashMap();
				 ArrayList itemsList ;
				for (int i=0;i<alDtlList.size();i++) {
					if (stRecordsToDelete.hasMoreTokens()) {
						String nextToken = stRecordsToDelete.nextToken();
						if(nextToken.equals("N")) {
					
						hmScreenData =(HashMap)alDtlList.get(i);
							itemsList = new ArrayList();
							alDtlListS=new ArrayList();
							alDtlListS.add(getLoginFacilityId() );
							alDtlListS.add(stHeaderBean.getDoc_type_code());
							alDtlListS.add(doc_no);
							alDtlListS.add((String)hmScreenData.get("doc_srl_no"));
							alDtlListS.add(stHeaderBean.getStore_code());
							alDtlListS.add((String)hmScreenData.get("item_code"));
							alDtlListS.add((String)hmScreenData.get("batch_id"));
							alDtlListS.add((String)hmScreenData.get("bin_loc_code"));
							alDtlListS.add((String)hmScreenData.get("expiry_date"));
							alDtlListS.add((String)hmScreenData.get("adj_item_qty"));
							alDtlListS.add((String)hmScreenData.get("remarks_code"));
							alDtlListS.add(getLoginById());
							alDtlListS.add(getLoginAtWsNo() );
							alDtlListS.add(getLoginFacilityId() );
							alDtlListS.add(getLoginById());
							alDtlListS.add(getLoginAtWsNo() );
							alDtlListS.add(getLoginFacilityId() );
							alDtlListS.add((String)hmScreenData.get("trade_id") );
							
							params = new ArrayList ();
							params.add(getLoginFacilityId());
							//params.add(stHeaderBean.getDoc_type_code());
							//params.add(doc_no);
							//params.add((String)hmScreenData.get("doc_srl_no"));
							params.add((String)hmScreenData.get("item_code"));
							params.add(stHeaderBean.getStore_code());
							params.add((String)hmScreenData.get("batch_id"));
							params.add((String)hmScreenData.get("bin_loc_code"));
							params.add((String)hmScreenData.get("expiry_date"));
							params.add(getLoginFacilityId());
							params.add((String)hmScreenData.get("item_code"));
							params.add(stHeaderBean.getStore_code());
							params.add((String)hmScreenData.get("batch_id"));
							params.add((String)hmScreenData.get("bin_loc_code"));
							params.add((String)hmScreenData.get("expiry_date"));

							supp_code_loc =(String)(fetchRecord(" select SUPP_CODE from ST_GRN_HDR A,ST_GRN_DTL_EXP B where A.FACILITY_ID = B.FACILITY_ID AND   A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FACILITY_ID = ? /* AND A.DOC_TYPE_CODE = ? AND A.DOC_NO = ? AND B.DOC_SRL_NO = ? */ AND B.ITEM_CODE = ? AND B.STORE_CODE = ? AND B.BATCH_ID = ? AND B.BIN_LOCATION_CODE = ? AND B.EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'dd/mm/yyyy') UNION SELECT supp_code FROM st_split_batch_dtl a, st_split_batch_dtl_exp b WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.facility_id = ? AND b.item_code = ? AND b.store_code = ? AND b.batch_id = ? AND b.bin_location_code = ? AND trunc(b.expiry_date_or_receipt_date) = TO_DATE (?, 'dd/mm/yyyy') ",params).get("SUPP_CODE"));
														
														
							if(supp_code_loc == null || supp_code_loc.equals(""))
							{
								supp_code_loc = " ";
							}
							
							set_supp_code(supp_code_loc);

							alDtlListS.add(supp_code);
							 if(itemtoItemClass.size()>0)
						  {
							if(itemtoItemClass.containsKey(getItemClass((String)hmScreenData.get("item_code"))))
							  {
							  
							  itemsList=(ArrayList)itemtoItemClass.get(getItemClass((String)hmScreenData.get("item_code")));
							  itemsList.add((String)hmScreenData.get("item_code"));
								}else
							  {
							 itemsList.add((String)hmScreenData.get("item_code")); 
							 itemtoItemClass.put(getItemClass((String)hmScreenData.get("item_code")),itemsList); 
							  }
								
						    }                    
						if(itemtoItemClass.size()==0)
					        {
						    itemsList.add((String)hmScreenData.get("item_code")); 
							 itemtoItemClass.put(getItemClass((String)hmScreenData.get("item_code")),itemsList);
                            }
							alDtlListRows.add(alDtlListS);
							

							alDtlListTrnBatchDtl=new ArrayList();
							alDtlListTrnBatchDtl.add((String)hmScreenData.get("item_code"));
							alDtlListTrnBatchDtl.add(stHeaderBean.getStore_code());
							alDtlListTrnBatchDtl.add(stHeaderBean.getTrn_type());
							alDtlListTrnBatchDtl.add("-"+((String)hmScreenData.get("adj_item_qty")));
							alDtlListTrnBatchDtl.add((String)hmScreenData.get("batch_id"));
							alDtlListTrnBatchDtl.add((String)hmScreenData.get("expiry_date"));
							alDtlListTrnBatchDtl.add((String)hmScreenData.get("trade_id"));
							alDtlListTrnBatchDtl.add((String)hmScreenData.get("bin_loc_code"));
							alDtlListTrnBatchDtl.add("N");
							alDtlListTrnBatchDtl.add(getLoginById());
							alDtlListTrnBatchDtl.add(getLoginAtWsNo() );
							alDtlListTrnBatchDtl.add(getLoginFacilityId() );
							alDtlListTrnBatchDtl.add(""); //11/05/12 
					
					//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
							//alDtlListTrnBatchDtl.add(stHeaderBean.getDoc_type_code());
							//alDtlListTrnBatchDtl.add(doc_no);
							//alDtlListTrnBatchDtl.add(stHeaderBean.getDoc_date());
					//Added ends
							alDtlListTrnBatchDtlRows.add(alDtlListTrnBatchDtl);
							//srl_no++;
								
							alDtlListTrnRows.add(commonDataTrnDtl(hmScreenData,hmScreenData,srl_no,doc_no,(String)hmScreenData.get("expiry_date"),"-"+((String )hmScreenData.get("adj_item_qty")),(String)hmScreenData.get("bin_loc_code")));

							alHDtlScreenRows=new ArrayList();
							alHDtlScreenRows=getExpList((String)hmScreenData.get("doc_srl_no"));
							for (int j=0;j<alHDtlScreenRows.size();j++) {	
								srl_no++;
								hmDtlScreenData=new HashMap();
								hmDtlScreenData =(HashMap)alHDtlScreenRows.get(j);
								alDtlListExpS=new ArrayList();
								alDtlListExpS.add(getLoginFacilityId() );
								alDtlListExpS.add(stHeaderBean.getDoc_type_code());
								alDtlListExpS.add(doc_no);
								alDtlListExpS.add((String)hmScreenData.get("doc_srl_no"));
								alDtlListExpS.add(stHeaderBean.getStore_code());
								alDtlListExpS.add((String)hmScreenData.get("item_code"));//5
								alDtlListExpS.add((String)hmDtlScreenData.get("batch_id"));
								alDtlListExpS.add((String)hmDtlScreenData.get("bin_location_code"));
								alDtlListExpS.add((String)hmDtlScreenData.get("expiry_date_or_receipt_date"));
								alDtlListExpS.add((String)hmDtlScreenData.get("trade_id"));
								alDtlListExpS.add((String)hmDtlScreenData.get("item_qty"));
								alDtlListExpS.add(getLoginById());//11
								alDtlListExpS.add(getLoginAtWsNo() );
								alDtlListExpS.add(getLoginFacilityId() );
								alDtlListExpS.add(getLoginById());
								alDtlListExpS.add(getLoginAtWsNo() );
								alDtlListExpS.add(getLoginFacilityId() );
								alDtlListExpS.add(checkForNull((String)hmDtlScreenData.get("barcode_id"))); //11/05/12
								alDtlListExpRows.add(alDtlListExpS);
				
								alDtlListTrnDtlRows.add(commonDataTrnDtl(hmScreenData,hmDtlScreenData,srl_no,doc_no,(String)hmDtlScreenData.get("expiry_date_or_receipt_date"),(String)hmDtlScreenData.get("item_qty"),(String)hmDtlScreenData.get("bin_location_code")));
								
								alDtlListTrnDtl=new ArrayList();
								alDtlListTrnDtl.add((String)hmScreenData.get("item_code"));
								alDtlListTrnDtl.add(stHeaderBean.getStore_code());
								alDtlListTrnDtl.add(stHeaderBean.getTrn_type());
								alDtlListTrnDtl.add((String)hmDtlScreenData.get("item_qty"));
								alDtlListTrnDtl.add((String)hmDtlScreenData.get("batch_id"));
								alDtlListTrnDtl.add((String)hmDtlScreenData.get("expiry_date_or_receipt_date"));
								alDtlListTrnDtl.add((String)hmDtlScreenData.get("trade_id"));
								alDtlListTrnDtl.add((String)hmDtlScreenData.get("bin_location_code"));
								alDtlListTrnDtl.add("N");
								alDtlListTrnDtl.add(getLoginById());
								alDtlListTrnDtl.add(getLoginAtWsNo() );
								alDtlListTrnDtl.add(getLoginFacilityId() );
								alDtlListTrnDtl.add(checkForNull((String)hmDtlScreenData.get("barcode_id"))); //11/05/12

						//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
								//alDtlListTrnDtl.add(stHeaderBean.getDoc_type_code());
								//alDtlListTrnDtl.add(doc_no);
								//alDtlListTrnDtl.add(stHeaderBean.getDoc_date());
						//Added ends
								alBatchDtl.add(alDtlListTrnDtl);
								System.out.println("alBatchDtl====286===>" +alBatchDtl);
							}
						}
					}
				}
			hmTableData.put("properties",		getProperties());
			hmTableData.put("HdrInsertData",	alHdrListRows);
			hmTableData.put("DtlInsertData",	alDtlListRows);
			hmTableData.put("ExpInsertData",	alDtlListExpRows);
			hmTableData.put("TrnDtlData",	alDtlListTrnRows);
			hmTableData.put("TrnDtlExpData",	alDtlListTrnDtlRows);
			hmTableData.put("BatchUpdateDtl",	alBatchDtl);
			hmTableData.put("BatchUpdateDtlRows",	alDtlListTrnBatchDtlRows);
			hmTableData.put("itemtoItemClass",	 itemtoItemClass);
			hmTableData.put("CommonData",	alCommon);
			hmTableData.put("LanguageData",	languageData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
			hmTableData.put("doc_no", doc_no);

		}
		catch(Exception e) {
			e.printStackTrace();
		}


		/*must be del after ejb deployment*/
		
			HashMap		hmResult	=	new HashMap()	;
			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;
		try{
			//SplitBatchHome splitBatchHome = null;
			//SplitBatchRemote splitBatchRemote = null;
			/*InitialContext initialcontext = new InitialContext();
			Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_ST_SPLIT_BATCH"));
			splitBatchHome = (SplitBatchHome)PortableRemoteObject.narrow(obj, SplitBatchHome.class);
			splitBatchRemote = splitBatchHome.create();
			hmResult =splitBatchRemote.insert( hmTableData, hmSQLMap ) ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_SPLIT_BATCH"),SplitBatchHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			//hmResult = new eST.SplitBatch12.SplitBatchManager().insert( hmTableData, hmSQLMap ) ;
		}
		catch(Exception exception) { }
		
			if( ((Boolean) hmResult.get("result")).booleanValue() )	{
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else if( hmResult.get("msgid")!=null  ) {
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else {
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			}

			return hmResult;
	}


/*	public HashMap validate(){
		//Remove records with Del check box checked
        HashMap hashmap = new HashMap();
        hashmap.put("result", super.TRUE);

	try{
		// if all checkboxes are checked or no data is entered..
            if(splitBatchDetailBean.toArrayList()== null || splitBatchDetailBean.getRecords_to_delete().indexOf("N") == -1)
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
	public void set_supp_code(String supp_code)
	{
		this.supp_code = supp_code;
	}
	public String get_supp_code()
	{
		return this.supp_code;

	}

	public HashMap getItemDetail(String item_code) {
		return splitBatchDetailBean.getItemDetail(item_code);
	}

	// to call Detail Bean method to load the data

	public ArrayList getDetailValues() {
		return splitBatchDetailBean.toArrayList();
	}

	public HashMap getDetailList(String doc_srl_no) {
		return splitBatchDetailBean.getValues(doc_srl_no);
	}

	public ArrayList getExpList(String doc_srl_no) {
		return splitBatchExpBean.getDtlExpList(Integer.parseInt(doc_srl_no));
	}

	public String getDoc_srl_no() {
		return splitBatchDetailBean.getDoc_srl_no();
	}

	public String getItem_code() {
		return splitBatchDetailBean.getItem_code();
	}

	/*public String getAdj_item_qty() {
		return splitBatchDetailBean.getAdj_item_qty();
	}

	public String getItem_unit_cost() {
		return splitBatchDetailBean.getItem_unit_cost();
	}*/
	
	public String getItem_cost_value() {
		return splitBatchDetailBean.getItem_cost_value();
	}

	public String getRemarks() {
		return splitBatchDetailBean.getRemarks();
	}
	
	public void setDetailValues(HashMap hashmapDtl) {

		splitBatchDetailBean.setValues(hashmapDtl);
	}

	public boolean setExpValues( Hashtable htFormValues) {
		return splitBatchExpBean.setValues(htFormValues);
	}
	public String getTradeList(String item_code, String trade_id) {
		return splitBatchExpBean.getTradeList(item_code,trade_id,getLanguageId());
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
	//	return splitBatchExpBean.getTradeListDflt(trade_id,getLanguageId());
	}

	public String getBinLocationList(String store_code,String bin_location_code) {
		return splitBatchExpBean.getBinLocationList(store_code,bin_location_code,getLanguageId());
	}

	public String getTradeList(String item_code) {
		return splitBatchExpBean.getTradeList(item_code,getLanguageId());
	}

	public String getBinLocationList(String store_code) {
		return splitBatchExpBean.getBinLocationList(store_code,getLanguageId());
	}

	public int getNextDocSerialNo() {
		return splitBatchDetailBean.getNextDocSerialNo();
	}

	/**
	* Method to retrive the default batch_id from MM_parameter table.
	* @return String, The default_batch_id for a particular item.
	*/

	public String getDefault_batch_id() {
		return splitBatchExpBean.getDefault_batch_id ();
	}

	public String getDefault_trade_id() {
		return splitBatchExpBean.getDefault_trade_id ();
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
		return splitBatchExpBean.getBatchIDFromExpiryDate(expiry_date);
	}

	public void setOpeningStockHeaderBean( StHeaderBean HdrData) {
		stHeaderBean=HdrData; 
	}
	public String ValidItemCodeOrDesc(String search_code)
	{
		HashMap hm=new HashMap();
		String returnValue="";
		try{

			ArrayList arr_lang=new ArrayList();
			arr_lang.add(search_code);
			arr_lang.add(getLanguageId());
			hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SEARCH_SELECT"),arr_lang);
			returnValue=(String)hm.get("ITEM_DESC");
			if(returnValue.equals(""))
				hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DESC_SEARCH_SELECT"),arr_lang);
				returnValue=(String)hm.get("ITEM_DESC");
			}catch(Exception e)
		{
			e.printStackTrace();
		}
		return returnValue;
	}
	  
	/*Added for GHL-ICN-0023 against GHL-CRF-0503 START*/
	public String getStoreBinLocation(String binlocationCode)
	{
		String store_code=stHeaderBean.getStore_code(); 

	String chkdefaultParameters[] = {store_code , binlocationCode};
			HashMap records			  = new HashMap();
			String result				="";
		try{
				records = fetchRecord("SELECT  COUNT(*) COUNT FROM MM_BIN_LOCATION WHERE store_code =? and bin_location_code=?",chkdefaultParameters);

				result=(String)records.get("COUNT");
				 
		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
	
	}		
	/*Added for GHL-ICN-0023 against GHL-CRF-0503 END*/
	
	public String getDefaultBinLocationCode (String item_code) 
	{
		return splitBatchExpBean.getDefaultBinLocationCode ( item_code, stHeaderBean.getStore_code(),getLanguageId()) ;
	}
	
	public String getSysDate () 
	{
		return stHeaderBean.getSysDate () ;
	}

	public String toString(){
	return	""+	splitBatchExpBean.toArrayList();
	}

	public ArrayList commonDataTrnDtl(HashMap hmScreenData,HashMap hmDtlScreenData,int j,String doc_no,String expiry_date,String qty,String bin_location_code){
	
		//int srl_no=j+1;
		ArrayList alDtlListTrnDtl=new ArrayList();
		alDtlListTrnDtl.add(getLoginFacilityId() );
		alDtlListTrnDtl.add(stHeaderBean.getStore_code());
		alDtlListTrnDtl.add((String)hmScreenData.get("item_code"));
		alDtlListTrnDtl.add(""+j);
		alDtlListTrnDtl.add(stHeaderBean.getTrn_type());
		alDtlListTrnDtl.add(stHeaderBean.getDoc_type_code());
		alDtlListTrnDtl.add(doc_no);
		alDtlListTrnDtl.add((String)hmScreenData.get("doc_srl_no"));
		alDtlListTrnDtl.add(stHeaderBean.getDoc_date());
		alDtlListTrnDtl.add(stHeaderBean.getDoc_ref());
		alDtlListTrnDtl.add((String)hmDtlScreenData.get("batch_id"));
		alDtlListTrnDtl.add(expiry_date);
		alDtlListTrnDtl.add(qty);
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add((String)hmScreenData.get("item_unit_cost"));
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add((String)hmScreenData.get("stock_uom_code"));
		alDtlListTrnDtl.add(get_supp_code());//Supp_code
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("");
		//alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("Y");
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add("");
		alDtlListTrnDtl.add(getLoginById());
		alDtlListTrnDtl.add(getLoginAtWsNo() );
		alDtlListTrnDtl.add(getLoginFacilityId() );
		alDtlListTrnDtl.add(getLoginById());
		alDtlListTrnDtl.add(getLoginAtWsNo() );
		alDtlListTrnDtl.add(getLoginFacilityId() );
		alDtlListTrnDtl.add(bin_location_code);
		alDtlListTrnDtl.add((String)hmScreenData.get("trade_id"));

		return alDtlListTrnDtl;
	}
/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
	public String getADJItemClassBased(String trntype)
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
public String getItemClass(String item_code)
	{



	String chkdefaultParameters[] = {item_code};
			HashMap records			  = new HashMap();
			String result				="";
		try{
				records = fetchRecord("SELECT  ITEM_CLASS_CODE ITEM_CLASS_CODE FROM MM_ITEM WHERE item_code =?",chkdefaultParameters);

				result=(String)records.get("ITEM_CLASS_CODE");
		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
	
	
	
	
	}
	//Added against IN:062247 starts
	public ArrayList getBarCodeDetail(String bar_code , String store_code) throws Exception{ 
			ArrayList BarCodeDetail = new ArrayList();
			try {
				System.out.println("Split Batch bar_code==>"+bar_code);
				String stParameter[] = { bar_code, store_code };
				BarCodeDetail = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_BATCH_SELECT_FOR_BAR_CODE"),stParameter);
				} 
			catch (Exception e) {
				e.printStackTrace();
			} 
			return BarCodeDetail ; 
	}
	//Added against IN:062247 ends
		//Added against GHL-CRF-0446 starts
	public Boolean getRestrictSplitGRN(){
		String restrict_GRN_batch = "N";
		try{
			restrict_GRN_batch = (String)fetchRecord("SELECT RESTRICT_SPLIT_GRN_BATCHES FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RESTRICT_SPLIT_GRN_BATCHES");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(restrict_GRN_batch,"N").equals("Y");
	}
	//Added against GHL-CRF-0446 ends
	
	/*Added against GHL-CRF-0503 START*/
	public String getAllowZeroBatchGRN(){
		String allow_zero_batches = "N";
		try{
			allow_zero_batches = (String)fetchRecord("SELECT INCLUDE_ZERO_STOCK_QOH FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("INCLUDE_ZERO_STOCK_QOH");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(allow_zero_batches,"N");
	}
	/*Added against GHL-CRF-0503 END*/
	
//GHL-SCF-1587 
	public ArrayList getBarCodeDetailArrayList1(String bar_code , String store_code) throws Exception{ 
		System.out.println("SplitBatchBean.java - getBarCodeDetailArrayList1"); 
 		ArrayList barcodeDetail = new ArrayList(); 
 		ArrayList arrMatGrpList = new ArrayList();
 		HashMap alTemp	=	new HashMap();
 		 String itemCode	=	"";  
 		 String materialGrpCode = ""; 
 		HashMap records			  = new HashMap();
// 		HashMap records1		  = new HashMap();  //Common-ICN-0091
		
		try {
//			String stParameter[] = { bar_code, store_code };   //Common-ICN-0091
			barcodeDetail =getBarCodeBatchDetails(bar_code,store_code);   	
			if(barcodeDetail.size()>0){
				alTemp = (HashMap)barcodeDetail.get(0);
				itemCode = (String)alTemp.get("ITEM_CODE");  
				//String stParameter1[] = { itemCode }; 
			//	materialGrpCode = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_SELECT_FOR_BAR_CODE"),stParameter1);
				records = getMatGrpCode (itemCode);    
				materialGrpCode=(String)records.get("MATERIAL_GROUP_CODE"); 
				if(materialGrpCode!=null && !materialGrpCode.equals("")){
			//		String stParameter1[] = { itemCode, materialGrpCode,getLoginById() };    //Common-ICN-0091
					arrMatGrpList = getBatchForMatGrpAccess(itemCode,materialGrpCode,getLoginById());   				
					if(arrMatGrpList==null || arrMatGrpList.size()==0){
						barcodeDetail = new ArrayList();   
					}
					
				}
			}  
			
     
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return barcodeDetail ;   
}

public ArrayList getBarCodeBatchDetails(String bar_code , String store_code) throws Exception{ 
		ArrayList barcodeDetail = new ArrayList(); 
		HashMap hmRecord					=	new HashMap();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		String sql = "";
		 
		sql   = "SELECT BARCODE_ID,ITEM_CODE,STORE_CODE,BATCH_ID,BIN_LOCATION_CODE, to_char(EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy') EXPIRY_DATE,TRADE_ID,NVL(QTY_ON_HAND,0) QTY_ON_HAND,NVL(COMMITTED_QTY,0) COMMITTED_QTY,NVL(QTY_ON_HAND,0)-NVL(COMMITTED_QTY,0)AVAIL_QTY,SUSPENDED_YN FROM ST_ITEM_BATCH WHERE BARCODE_ID = ?  AND STORE_CODE = ? ";
	
	
	try {
		conn = getConnection();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, bar_code);
		pstm.setString(2, store_code);
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
			hmRecord.put("BARCODE_ID",resultSet.getString("BARCODE_ID")==null?"":resultSet.getString("BARCODE_ID"));
			hmRecord.put("ITEM_CODE", resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE")); 
			hmRecord.put("STORE_CODE", resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE")); 
			hmRecord.put("BATCH_ID", resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID")); 
			hmRecord.put("BIN_LOCATION_CODE", resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE")); 
			hmRecord.put("EXPIRY_DATE", resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE")); 
			hmRecord.put("TRADE_ID", resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID")); 
			hmRecord.put("QTY_ON_HAND", resultSet.getString("QTY_ON_HAND")==null?"":resultSet.getString("QTY_ON_HAND")); 
			hmRecord.put("COMMITTED_QTY", resultSet.getString("COMMITTED_QTY")==null?"":resultSet.getString("COMMITTED_QTY")); 
			hmRecord.put("AVAIL_QTY", resultSet.getString("AVAIL_QTY")==null?"":resultSet.getString("AVAIL_QTY")); 
			hmRecord.put("SUSPENDED_YN", resultSet.getString("SUSPENDED_YN")==null?"":resultSet.getString("SUSPENDED_YN")); 
			barcodeDetail.add(hmRecord);  

		}
	 } catch (Exception e) {
        e.printStackTrace();
    } 
	finally { //Common-ICN-0091
			closeResultSet(resultSet);
			closeStatement(pstm);
			closeConnection(conn);
		}	
	
return barcodeDetail ;   
}

public ArrayList getBatchForMatGrpAccess(String itemCode , String materialGrpCode, String loginId) throws Exception{ 

		String matGrpCode = ""; 
		ArrayList arrMatGrpList = new ArrayList(); 
		//HashMap hmRecord					=	new HashMap();  //Common-ICN-0091
		Connection conn = null;
		PreparedStatement pstm = null;  
		ResultSet resultSet = null;
		String sql = "";
		sql = "SELECT material_group_code  FROM mm_item WHERE item_code = ? AND material_group_code IN (SELECT material_group_code  FROM MM_USER_MATERIAL_GROUP    WHERE material_group_code = ? and user_id= ? AND EFF_STATUS ='E') ";
		
	try {
		conn = getConnection(); 
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, itemCode);
		pstm.setString(2, materialGrpCode);
		pstm.setString(3, loginId);
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
			matGrpCode = resultSet.getString("material_group_code")==null?"":resultSet.getString("material_group_code");   
			arrMatGrpList.add(matGrpCode); 

		}
 
    } catch (Exception e) {
        e.printStackTrace();
    } 
	finally { //Common-ICN-0091
		closeResultSet(resultSet);
		closeStatement(pstm);
		closeConnection(conn);
	}
	
return arrMatGrpList ;   
}

public HashMap getMatGrpCode(String itemCode) throws Exception{ 

		//String matGrpCode = "";   //Common-ICN-0091
		ArrayList arrMatCodeList = new ArrayList(); 
		HashMap hmRecord					=	new HashMap();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		String sql = "";
		sql   = "SELECT MATERIAL_GROUP_CODE  FROM mm_item WHERE item_code = ? ";
		
	try {
		conn = getConnection();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, itemCode);
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
			hmRecord.put("MATERIAL_GROUP_CODE",resultSet.getString("MATERIAL_GROUP_CODE")==null?"":resultSet.getString("MATERIAL_GROUP_CODE")); 
			

		}
 
    } catch (Exception e) {
        e.printStackTrace();
    } 
	finally { //Common-ICN-0091
		closeResultSet(resultSet);
		closeStatement(pstm);
		closeConnection(conn);
	}
return hmRecord ;    
}
}//GHL-SCF-1587 END
