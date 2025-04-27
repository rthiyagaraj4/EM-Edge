/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.io.Serializable;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

//import eCommon.Common.CommonAdapter;
//import eCommon.Common.CommonEJBSessionInterface;
//import eST.Common.StAdapter;
import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;


public class OpeningStockBean extends StTransaction implements Serializable {

	private StHeaderBean						stHeaderBean	;
	private OpeningStockDetailBean		openingStockDetailBean	;
	private OpeningStockExpBean			openingStockExpBean		;
	//private String language;
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
	

	//Added on 6/21/2005
	public void setStHeaderBean(StHeaderBean stHeaderBean){
		this.stHeaderBean = stHeaderBean;		
	}
	public Object getStHeaderBean() {
		return stHeaderBean;
	}

	/*public void setLanguageId(String language)
	{
		this.language=language;
	}

	public String getLanguageId()
	{
		return language;
	}
	*/
	public void initialize(){
		super.initialize();
		openingStockDetailBean=new OpeningStockDetailBean();
		openingStockDetailBean.setProperties(getProperties());
		openingStockExpBean=new OpeningStockExpBean();
		openingStockExpBean.setProperties(getProperties());
		stHeaderBean=new StHeaderBean();
		stHeaderBean.setProperties(getProperties());
	}
	
	public void  clear(){
		super.clear();
		openingStockDetailBean=null;
		openingStockExpBean=null;
		stHeaderBean=null;
	}

	public void setAll(Hashtable hashtable) {
        openingStockDetailBean.setAll(hashtable);
    }

	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean*/
		/*not required to process exp records..*/
		HashMap hmReturn	= getMessageHashMap(true);
		try { 
			if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			/*	if (isDocNoAutoGenYN(stHeaderBean.getDoc_type_code())) {
					
				}*/
			}
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return hmReturn	;
	}

	public HashMap insert(){
		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		ArrayList alCommonData=new ArrayList();

		alCommonData.add(getLoginById()        );
		alCommonData.add(getLoginAtWsNo() );
		alCommonData.add(getLoginFacilityId() );
		alCommonData.add(getLanguageId() );

		try {
			hmSQLMap.put("HdrInsertSQL", getStRepositoryValue("SQL_ST_ADJ_HDR_INSERT"));
			hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_INSERT"));
			hmSQLMap.put("ExpInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_EXP_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			// The Queries for the new Logic.


		    hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT1"));


			hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));
           

			ArrayList alDtlList	=	openingStockDetailBean.toArrayList();
			ArrayList alTempDtlList	=	new ArrayList();

			StringTokenizer stRecordsToDelete	=	new StringTokenizer(openingStockDetailBean.getRecords_to_delete(),",");

			for (int i=0;i<alDtlList.size();i++) {
				if (stRecordsToDelete.hasMoreTokens()) {
					String nextToken = stRecordsToDelete.nextToken();
					if(nextToken.equals("N")) {
						alTempDtlList.add(alDtlList.get(i));
					}
				}
			}

			ArrayList alHeaderList	=	 stHeaderBean.toArrayListOBS();
			
			boolean isDocNoAutoGenYN = isDocNoAutoGenYN((String)alHeaderList.get(1));

		//	if(isDocNoAutoGenYN) {
			//	alHeaderList.set(2,fetchNextDocNo((String)alHeaderList.get(1)));
			//}

			hmTableData.put("properties",		getProperties());
			hmTableData.put("HdrInsertData",	alHeaderList);
			
			hmTableData.put("DtlInsertData",	alTempDtlList);
			hmTableData.put("ExpInsertData",	openingStockExpBean.toArrayList());
			hmTableData.put("CommonData",		alCommonData);
			
			hmTableData.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
		if((getItemClassBased("OBS").equals("Y")) && (getAutoDocGen(stHeaderBean.getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"OBS");
		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		/*must be del after ejb deployment*/

		HashMap		hmResult	=	new HashMap()	;

		try {
			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_OPENING_STOCK"),eST.OpeningStock.OpeningStockHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
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
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
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
				if(openingStockDetailBean.toArrayList()== null || openingStockDetailBean.getRecords_to_delete().indexOf("N") == -1)
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
		return openingStockDetailBean.getItemDetail(item_code);
	}

	// to call Detail Bean method to load the data

	public ArrayList getDetailValues() {
		return openingStockDetailBean.toArrayList();
	}

	public HashMap getDetailList(String doc_srl_no) {
		return openingStockDetailBean.getValues(doc_srl_no);
	}

	public ArrayList getExpValues() {
		return openingStockExpBean.toArrayList();
	}


	public ArrayList getExpList(String doc_srl_no) {
		return openingStockExpBean.getDtlExpList(Integer.parseInt(doc_srl_no));
	}

	public String getDoc_srl_no() {
		return openingStockDetailBean.getDoc_srl_no();
	}

	public String getItem_code() {
		return openingStockDetailBean.getItem_code();
	}

	public String getAdj_item_qty() {
		return openingStockDetailBean.getAdj_item_qty();
	}

	public String getItem_unit_cost() {
		return openingStockDetailBean.getItem_unit_cost();
	}

	public String getItem_cost_value() {
		return openingStockDetailBean.getItem_cost_value();
	}

	public String getRemarks() {
		return openingStockDetailBean.getRemarks();
	}

	public void setDetailValues(HashMap hashmapDtl) {

		openingStockDetailBean.setValues(hashmapDtl);
	}

	public void setExpValues( Hashtable htFormValues) {
		openingStockExpBean.setValues(htFormValues);
	}
	public String getTradeList(String item_code, String trade_id,String language) {
		return openingStockExpBean.getTradeList(item_code,trade_id,language);
	}

	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167
	
	
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
	//	return openingStockExpBean.getTradeListDflt(trade_id,getLanguageId());
	}

	public String getBinLocationList(String store_code,String bin_location_code) {
		return openingStockExpBean.getBinLocationList(store_code,bin_location_code);
	}

	public String getTradeList(String item_code) {
		return openingStockExpBean.getTradeList(item_code);
	}

	public String getBinLocationList(String store_code) {
		return openingStockExpBean.getBinLocationList(store_code);
	}

	public int getNextDocSerialNo() {
		return openingStockDetailBean.getNextDocSerialNo();
	}

	/**
	* Method to retrive the default batch_id from MM_parameter table.
	* @return String, The default_batch_id for a particular item.
	*/

	public String getDefault_batch_id() {
		return openingStockExpBean.getDefault_batch_id ();
	}

	public String getDefault_trade_id() {
		return openingStockExpBean.getDefault_trade_id ();
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
	* This is just for the replacement of '/' with ''.
	* @param String, the expiry date entered
	* @param String, the batch id.
	*/

	public String getBatchIDFromExpiryDate (String expiry_date) {
		return openingStockExpBean.getBatchIDFromExpiryDate(expiry_date);
	}

	public void setOpeningStockHeaderBean( StHeaderBean HdrData) {
		stHeaderBean=HdrData;
	}
	public String ValidItemCodeOrDesc(String search_code) {
		HashMap hm=new HashMap();
		String returnValue="";
		try {
			hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SEARCH_SELECT"),search_code);
			returnValue=(String)hm.get("ITEM_DESC");

			if(returnValue.equals("")) {
				hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DESC_SEARCH_SELECT"),search_code);
				returnValue=(String)hm.get("ITEM_DESC");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public String getDefaultBinLocationCode (String item_code) {
		return openingStockExpBean.getDefaultBinLocationCode ( item_code, stHeaderBean.getStore_code(),getLanguageId()) ;
	}

	public String getSysDate () {
		return stHeaderBean.getSysDate () ;
	}

	public String toString() {
		return	""+	openingStockExpBean.toArrayList();
	}

	public boolean isDuplicateInExpList (Hashtable htFormValues) {
		return openingStockExpBean.isDuplicateInExpList(htFormValues,getLanguageId());//Added getLanguageId() for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015
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

	public boolean isEntryAlreadyExists (String p_item_code, String p_store_code) {
		HashMap hmResult=new HashMap();
		boolean result = false;
		try {
			ArrayList alParameters = new ArrayList();
			alParameters.add(p_item_code);
			alParameters.add(p_store_code);
			alParameters.add(getLoginFacilityId());
			hmResult=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_ALREADY_EXISTS"),alParameters);
			int count = Integer.parseInt((String)hmResult.get("COUNT"));


			if (count > 0) {
				result = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getOBSItemClassBased(String trntype)
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
	public double getConvFactTemp(String item_code,String store_code){
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
	}
	/*public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");

		return gen_uom_code;

	}*/
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

public String getItemByGTIN(String barcode_id)throws Exception{//Addign start for MOHE-CRF-0167

    
	 HashMap itemDetails =new HashMap();
	 LinkedList batchData=new LinkedList();	 
	 HashMap barcodeData = getBarcodeData();
	 String gtin_item="";
	 String temp_expiry_date ="";
	 String temp_batch_id ="";
	 String temp_trade_id ="";
	 boolean rec_found = false;
	 HashMap BarcodeDetails = new HashMap();

    
	   try{
		   
		 
       String gtin = null;
       String trade_id=null;  
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
            trade_id =	checkForNull((String)fetchRecord("SELECT B.TRADE_ID FROM AM_TRADE_NAME A, MM_TRADE_NAME_FOR_ITEM B WHERE MANUFACTURER_ID = ? AND A.TRADE_ID = B.TRADE_ID",alParameters).get("TRADE_ID"));
		if(barcodeData.containsKey(gtin_item)){
				   batchData = (LinkedList)barcodeData.get(gtin_item);
				   for(int i=0;i<batchData.size();i+=3){
				      temp_expiry_date = (String)batchData.get(i+1);
					  temp_batch_id    = (String)batchData.get(i);
					  temp_trade_id    = (String)batchData.get(i+2);
					  if(batchNumber.equals(temp_batch_id) && temp_exp_date.equals(temp_expiry_date) && trade_id.equals(temp_trade_id)){
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
		   batchData.add(trade_id);
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
