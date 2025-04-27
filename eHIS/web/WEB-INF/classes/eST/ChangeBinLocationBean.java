/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.HashMap;
//import java.util.Properties;

import eST.Common.StHeaderBean;
//import eST.Common.StAdapter;
import eST.Common.StTransaction;
//import eST.Common.StEJBSessionAdapter;

import eCommon.Common.*;
//import eCommon.Common.CommonAdapter;
//import eCommon.Common.CommonEJBSessionInterface;
//import eCommon.SingleTableHandler.*;

//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;


public class ChangeBinLocationBean extends StTransaction implements Serializable
{
    private StHeaderBean				    stHeaderBean	;
	private ChangeBinLocationDetailBean		changeBinLocationDetailBean	;	
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
//	private String store_code="" ;
    //private String language;
public Object getStHeaderBean() {
		return stHeaderBean;
	}
	

	//Added on 6/16/2005
	public void setStHeaderBean(StHeaderBean stHeaderBean){
		this.stHeaderBean = stHeaderBean;		
	}
     public void initialize(){
        super.initialize();
		changeBinLocationDetailBean=new ChangeBinLocationDetailBean();
		changeBinLocationDetailBean.setProperties(getProperties());
		stHeaderBean=new StHeaderBean();
		stHeaderBean.setProperties(getProperties());
		//store_code="";
	 }

     public void  clear(){
        super.clear();
		changeBinLocationDetailBean=null;
		stHeaderBean=null;
		//store_code=null;
	 }

/* public void setLanguageId(String language) {
			this.language = language;

		}
public String getLanguageId() {
			return this.language;
		}*/

    public void setAll(Hashtable hashtable) {
        changeBinLocationDetailBean.setAll(hashtable);
		//setMode((String)hashtable.get("mode"));
    }

    public String getStore_code_List(String defaultBinLocation){
		ArrayList arr_language=new ArrayList();
		arr_language.add(stHeaderBean.getStore_code());
		arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),defaultBinLocation);
	}

    public ArrayList getDetailValues() {
		return changeBinLocationDetailBean.toArrayList();
	}

   public void setDetailValues(HashMap hashmapDtl) {
		changeBinLocationDetailBean.setValues(hashmapDtl);
	}

   public void setChangeBinLocationHeaderBean(StHeaderBean HdrData) {
		stHeaderBean=HdrData; 
	}

   public HashMap getDetailList(String doc_srl_no) {
		return changeBinLocationDetailBean.getValues(doc_srl_no);
	}

	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167
	
	public java.util.ArrayList getBinLocationList(String store_code) {

        ArrayList BinLocationList = new ArrayList();
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
            pstmt.setString(1, store_code);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                BinLocationList.add(record);
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
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return BinLocationList;
	}



   public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
//		int isValidDocDate = -1;
		try {

			// To call the procedure st_stock_availability_status

			String[] strParameters = new String[7];

			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";//include suspended
			strParameters[6] = "";

    
			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);

			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn"));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("item_unit_cost"));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("store_item_unit_cost")));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("available_stock")));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("expired_stock")));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));

		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw new Exception("ITEM_STORE_NOT_FOUND");
		}
		return BatchDetails;
	}


 	public HashMap insert() {

        boolean autoGenerateYN=false;
		String doc_no="";

		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
        HashMap hmScreenData= new HashMap();
		
		ArrayList alCommonData=new ArrayList();
		ArrayList alTrnDtlToAdd=new ArrayList();
		ArrayList allanguageData	=	new ArrayList();

		alCommonData.add(getLoginById() );
		alCommonData.add(getLoginAtWsNo() );
		alCommonData.add(getLoginFacilityId() );
		alCommonData.add(stHeaderBean.getDoc_type_code());
allanguageData.add(getLanguageId());

		try {

			hmSQLMap.put("HdrInsertSQL", "INSERT INTO ST_CHANGE_BIN_LOC_HDR(facility_id,doc_type_code,doc_no,doc_date,doc_ref,store_code,item_class_code,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?	, ?	,? ,to_date(?,'dd/mm/yyyy')	,? , ? ,? ,?,SYSDATE ,? ,? ,?	,SYSDATE ,?	,?)");
			hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_CHANGE_BIN_LOCATION_DTL_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("ItemTrnDtlInsert", getStRepositoryValue("SQL_ST_CHANGE_BIN_LOCATION_ITEM_TRN_DTL_INSERT"));

			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));

			//ArrayList alTrnDtlList	=	new ArrayList();

			ArrayList alDtlListRows	=	new ArrayList();

			ArrayList alHdrListS	=null;
            ArrayList alDtlListS	=null;

    		autoGenerateYN=isDocNoAutoGenYN(stHeaderBean.getDoc_type_code());

			if(autoGenerateYN)
				doc_no=fetchNextDocNo(stHeaderBean.getDoc_type_code());
			else
				doc_no=stHeaderBean.getDoc_no();


  	            /* seting for header Starts here */ 
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

	            /* seting for header End here */ 


               /* seting for detail records starts here */ 
              
      			ArrayList alDtlList	    =	changeBinLocationDetailBean.toArrayList();
				System.out.println("alDtlList===238bean=>" +alDtlList);

               /*
			    alDtlData is a ArrayList of HashMap ....DO ned to take care properly .. 
			    comming from ChangeBinLocationDetailBean
			   */

                  HashMap itemtoItemClass = new HashMap();
				  ArrayList itemsList ;

				 for (int i=0;i<alDtlList.size();i++)
				  {
						    hmScreenData =(HashMap)alDtlList.get(i);
							System.out.println("hmScreenData===250bean=>" +hmScreenData);
						    alDtlListS=new ArrayList();
							itemsList = new ArrayList();
                           
							alDtlListS.add(getLoginFacilityId() );
							alDtlListS.add(stHeaderBean.getDoc_type_code());
							alDtlListS.add(doc_no);
							alDtlListS.add((String)hmScreenData.get("doc_srl_no"));
							alDtlListS.add(stHeaderBean.getStore_code());
							alDtlListS.add((String)hmScreenData.get("item_code"));
							alDtlListS.add((String)hmScreenData.get("batch_id"));
                            alDtlListS.add((String)hmScreenData.get("old_bin_loc_code"));
							alDtlListS.add((String)hmScreenData.get("new_bin_loc_code"));
							alDtlListS.add((String)hmScreenData.get("exp_date"));
							alDtlListS.add((String)hmScreenData.get("adj_item_qty"));

							alDtlListS.add(getLoginById());
							alDtlListS.add(getLoginAtWsNo() );
							alDtlListS.add(getLoginFacilityId() );
							alDtlListS.add(getLoginById());
							alDtlListS.add(getLoginAtWsNo() );
							alDtlListS.add(getLoginFacilityId() );

                            alDtlListS.add((String)hmScreenData.get("trn_type"));
							alDtlListS.add((String)hmScreenData.get("trade_id"));
                            alDtlListS.add((String)hmScreenData.get("suspended_batch_allowed_yn"));
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
					

                           
///////////
							ArrayList alBatchDtls	=	getBatchDetails((String)hmScreenData.get("item_code"), stHeaderBean.getStore_code());

///////////
					     	alDtlListS.add(""+alBatchDtls.get(2));
							alDtlListS.add((String)hmScreenData.get("new_barcode_id"));//07/05/12
							alDtlListS.add((String)hmScreenData.get("old_barcode_id"));//07/05/12
							
							alDtlListRows.add(alDtlListS);
							System.out.println("alDtlListRows===301 bean==>" +alDtlListRows);

                            alTrnDtlToAdd.add(commonDataTrnDtl(hmScreenData,doc_no,i));  


					}


            /* seting for detail records ends here */   

			hmTableData.put("properties",	 getProperties());
			hmTableData.put("HdrInsertData", alHdrListS);
			hmTableData.put("DtlInsertData", alDtlListRows);
			hmTableData.put("CommonData",	 alCommonData);
			System.out.println("alTrnDtlToAdd====="+alTrnDtlToAdd);
            hmTableData.put("TrnDtlData",	 alTrnDtlToAdd);
           
			/* It is used to catch the items according to the Item Classes Ramana C*/
			hmTableData.put("itemtoItemClass",	 itemtoItemClass);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			//hmTableData.put("RecordsToDelete",	changeBinLocationDetailBean.getRecords_to_delete());
		}
		catch(Exception e) {
			e.printStackTrace();
		}  

       HashMap		hmResult	=	new HashMap()	;

       try{
	    
        hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;


	//    eST.ChangeBinLocation.ChangeBinLocationRemote changebinlocationremote = null;

	/*	InitialContext initialcontext = new InitialContext();
		Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_CHANGE_BIN_LOCATION"));
		eST.ChangeBinLocation.ChangeBinLocationHome changebinlocationhome = (eST.ChangeBinLocation.ChangeBinLocationHome)PortableRemoteObject.narrow(obj1, eST.ChangeBinLocation.ChangeBinLocationHome.class);
		changebinlocationremote = changebinlocationhome.create();

		hmResult = changebinlocationremote.insert(hmTableData, hmSQLMap);*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_CHANGE_BIN_LOCATION"),eST.ChangeBinLocation.ChangeBinLocationHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); ;
		paramArray[1] = hmSQLMap.getClass();

		hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



		//hmResult = new eST.ChangeBinLocation12.ChangeBinLocationManager().insert( hmTableData, hmSQLMap ) ;

		if( ((Boolean) hmResult.get("result")).booleanValue() )	{
//			hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
		hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			
		}
		else if( hmResult.get("msgid")!=null  ) {
		//	hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
		hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		else {
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		}

	   }catch(Exception e){
		   e.printStackTrace();
		   }
           
		return hmResult;    
	}  

/**
   
**/
public ArrayList commonDataTrnDtl(HashMap hmScreenData, String doc_no, int j){

               
  		    ArrayList alDtlListTrnDtl=new ArrayList();
		
			alDtlListTrnDtl.add(getLoginFacilityId() );
			alDtlListTrnDtl.add(stHeaderBean.getStore_code());
			alDtlListTrnDtl.add((String)hmScreenData.get("item_code"));
			alDtlListTrnDtl.add(""+(1));
			alDtlListTrnDtl.add((String)hmScreenData.get("trn_type"));
			alDtlListTrnDtl.add(stHeaderBean.getDoc_type_code());
			alDtlListTrnDtl.add(doc_no);
			alDtlListTrnDtl.add((String)hmScreenData.get("doc_srl_no"));
			alDtlListTrnDtl.add(stHeaderBean.getDoc_date());
			alDtlListTrnDtl.add(stHeaderBean.getDoc_ref());
			alDtlListTrnDtl.add((String)hmScreenData.get("batch_id"));
			alDtlListTrnDtl.add((String)hmScreenData.get("exp_date"));
			alDtlListTrnDtl.add((String)hmScreenData.get("adj_item_qty"));
			alDtlListTrnDtl.add((String)hmScreenData.get("uom_code"));
			alDtlListTrnDtl.add("Y");
			alDtlListTrnDtl.add(getLoginById());
			alDtlListTrnDtl.add(getLoginAtWsNo() );
			alDtlListTrnDtl.add(getLoginFacilityId() );
			alDtlListTrnDtl.add(getLoginById());
			alDtlListTrnDtl.add(getLoginAtWsNo() );
			alDtlListTrnDtl.add(getLoginFacilityId() );
			alDtlListTrnDtl.add((String)hmScreenData.get("new_bin_loc_code"));
			alDtlListTrnDtl.add((String)hmScreenData.get("trade_id"));
			/* @Name - Priya
			* @Date - 24/05/2010
			* @Inc# - 
			* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS'  function and  assign it to the item_unit_cost field
			*/
			/* Commented by priya
			ArrayList alBatchDtls	=null;
			try { 
				alBatchDtls=getBatchDetails((String)hmScreenData.get("item_code"), stHeaderBean.getStore_code());
 			}
			catch (Exception exception) {
				exception.printStackTrace();
			}  
	     	alDtlListTrnDtl.add(""+alBatchDtls.get(2));
			Commented by priya*/
			try{
			String storeItemUnitCost=getUnitCost((String)hmScreenData.get("item_code"),stHeaderBean.getStore_code());				
			alDtlListTrnDtl.add(storeItemUnitCost);
			}
			catch (Exception e){
			   e.printStackTrace();
			}
		return alDtlListTrnDtl;
	}  
	public String getADJItemClassBased(String trntype)
	{
		String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				//records = fetchRecord("SELECT     ITEM_CLASS_BASED_YN   FROM     st_trn_type_lang_vw   WHERE   TRN_TYPE= ? AND LANGUAGE_ID=?",chkdefaultParameters);
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

public String getItemByGTIN(String barcode_id)throws Exception{//Addign start for MOHE-CRF-0167
    
	 HashMap itemDetails =new HashMap();
	 LinkedList batchData=new LinkedList();	 
	 HashMap barcodeData = getBarcodeData();
	 String gtin_item="";
	 String temp_expiry_date ="";
	 String temp_batch_id ="";
	 boolean rec_found = false;
	 HashMap BarcodeDetails = new HashMap();
	 HashMap BarcodeDetails1 = new HashMap();

   
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
