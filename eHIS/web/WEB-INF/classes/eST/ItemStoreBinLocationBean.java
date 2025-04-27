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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Enumeration;
import java.sql.*;
import java.text.SimpleDateFormat;

//import eCommon.SingleTableHandler.*;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import eST.KitTemplate.*;
import eST.Common.StRepository;
import eST.Common.* ;
import eCommon.Common.*;
import eST.Common.StAdapter;


public class ItemStoreBinLocationBean extends StAdapter implements Serializable{


	String item_code;
	String store_code;
	//String language_id;
	String[] bin_location_code;
	int total_records;
	String select_all;
	ArrayList alBin_location_code;
	HashSet hsSelectedBin_location_code;
	HashMap hmCommonData;
	java.util.HashMap selectedData ;

	private String manufacturerId="";//added for MO-CRF-20165 START
	private String grnRemarks = ""; 
	private String itemRemarks = "";
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
	
	public ItemStoreBinLocationBean() {
		hsSelectedBin_location_code =	new HashSet();
		alBin_location_code			=	new java.util.ArrayList();
		hmCommonData				=	new HashMap();
		selectedData				=	new java.util.HashMap();
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	public String getStore_code() {
		return this.store_code;
	}
/*public void setLanguageId(String language_id) {
		this.language_id = language_id;
	}

	public String getLanguageId() {
		return this.language_id;
	}*/
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_code() {
		return this.item_code;
	}
	public void setTotalRecords(int total_records) {
		this.total_records = total_records;
	}

	public int getTotalRecords() {
		return this.total_records;
	}
	public String getStore_code_List() {
		//String chkParameters[] ={getLoginFacilityId(),getLanguageId()};
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		//alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST_WT_LANG"), alParameters));
	}	

	public ArrayList getBin_location_code() {
		return this.alBin_location_code;
	}

	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167
	public void initExistingBin_location_code() {
		try {
			alBin_location_code = new java.util.ArrayList();
			ArrayList alRecords=fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_ALL"), new String[]{getStore_code(), getItem_code()});

			for (int i=0; i<alRecords.size(); i++) {
				HashMap hmRecord=	(HashMap) alRecords.get(i);
				alBin_location_code.add(hmRecord.get("BIN_LOCATION_CODE"));
			}
		} 
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
public int hasRecords() {
		if (hsSelectedBin_location_code != null) {
			return hsSelectedBin_location_code.size();
		}
		return -1;
	}
	public void updateSelected_Bin_location_code(java.util.Hashtable htBin_location_code) {
		try{
		String keyName							=		"";
		//HashMap hmData	;					
		Enumeration enumKeyBin_location_code	=		htBin_location_code.keys();
		ArrayList  removeList					=		new java.util.ArrayList(12);
			
		int index								=		0;
		while (enumKeyBin_location_code.hasMoreElements()) {
			keyName = (String)enumKeyBin_location_code.nextElement();
			if (keyName.startsWith("remarks_code_") ||keyName.startsWith("db_action_")||keyName.startsWith("eff_status_")||keyName.startsWith("PreviousListValueExit") ||keyName.startsWith("highlight_") ||keyName.startsWith("select_all")) {
				removeList.add(htBin_location_code.get(keyName));
				htBin_location_code.remove(keyName);
			}
		}
		hsSelectedBin_location_code.removeAll(removeList);
		java.util.Enumeration enumKeyData			=		htBin_location_code.keys();
		java.util.Enumeration enumBinData		=		htBin_location_code.elements();
	
		String data_value							=		"";
		

		while (enumKeyData.hasMoreElements()) {
				keyName								=		(String)enumKeyData.nextElement();
				data_value							=		(String) enumBinData.nextElement();
			if(keyName.startsWith("BIN_LOCATION_CODE_"))index++;
			if ((keyName.startsWith("BIN_LOCATION_CODE_"))||(keyName.startsWith("EFF_STATUS_"))||(keyName.startsWith("DB_ACTION_"))){
		
	
			if (data_value != null || data_value.trim().length()>0) 
				selectedData.put(keyName,checkForNull(data_value,""));
			}
		
			hmCommonData.put(getItem_code()+getStore_code(),selectedData);
			
		}
		
			enumKeyBin_location_code			=		htBin_location_code.keys();

		while (enumKeyBin_location_code.hasMoreElements())
			{
			keyName								=		(String)enumKeyBin_location_code.nextElement();
			
			if (keyName.startsWith("add_bin_location_")) {
				String stValue					=		(String)htBin_location_code.get(keyName);
				if (!stValue.equals("")) {
					hsSelectedBin_location_code.add(stValue);
					
				}
				
			}
			
			
				
			}
			setTotalRecords(getTotalCntRecords(getStore_code()));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public java.util.ArrayList getSelectedBin_location_code() {
		return new ArrayList(hsSelectedBin_location_code);
	}

	public void clear() {
		hsSelectedBin_location_code=new HashSet();
		hmCommonData=	new HashMap();
	}

	public void initialize() {
		if (hsSelectedBin_location_code!= null) {
			hsSelectedBin_location_code.clear();
		}
		if (hmCommonData!= null) {
			hmCommonData.clear();
		}
		if (selectedData!= null) {
			selectedData.clear();
		}
		
	}
/*
	public java.util.HashMap insert() {
		HashMap hmTableData = new HashMap()	;
		HashMap hmSQLMap = new HashMap()	;
		ArrayList alInsertData = new ArrayList()	;
		ArrayList LanguageData = new ArrayList()	;
		
		LanguageData.add(getLanguageId());

		for (Iterator iterator	=	hsSelectedBin_location_code.iterator();
				iterator.hasNext();) {
			ArrayList alInsertRecord = new ArrayList();
			alInsertRecord.add(getStore_code());
			alInsertRecord.add(getItem_code());
			alInsertRecord.add(iterator.next());
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertData.add(alInsertRecord);
		}
		
		hmSQLMap.put("InsertSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT")); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertData",alInsertData);
		hmTableData.put("LanguageData",LanguageData);
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH);
	}
	*/
//Code Added by Mahesh to simplify the Insert code....
	public java.util.HashMap insert() {
		HashMap	hmData	= new HashMap();
		HashMap	hmSQLMap	= new HashMap();
		HashMap	hmTableData	= new HashMap();
		ArrayList alTmpInsData = new ArrayList();
		ArrayList alInsData = new ArrayList();
		ArrayList alTmpUpdateData = new ArrayList();
		ArrayList alUpdateData = new ArrayList();
		hmData	=	(HashMap)hmCommonData.get(getItem_code()+getStore_code());
		for (int index=0;index<getTotalRecords();index++) {
			if(hmData.get("DB_ACTION_"+index)==null)break;
			if((hmData.get("DB_ACTION_"+index)).equals("I")&&(hmData.get("EFF_STATUS_"+index)).equals("Y")){
				alTmpInsData = new ArrayList();
				alTmpInsData.add(getStore_code());
				alTmpInsData.add(getItem_code());
				alTmpInsData.add((String)hmData.get("BIN_LOCATION_CODE_"+index));    
				alTmpInsData.add(login_by_id);
				alTmpInsData.add(login_at_ws_no);
				alTmpInsData.add(login_facility_id);
				alTmpInsData.add(login_by_id);
				alTmpInsData.add(login_at_ws_no);
				alTmpInsData.add(login_facility_id);
				alTmpInsData.add((String)hmData.get("EFF_STATUS_"+index));
				alInsData.add(alTmpInsData);
			}else if((hmData.get("DB_ACTION_"+index).equals("U"))){
			  alTmpUpdateData = new ArrayList();
			  alTmpUpdateData.add((String)hmData.get("EFF_STATUS_"+index));
					alTmpUpdateData.add(login_by_id);   		  
					alTmpUpdateData.add(login_at_ws_no);		
					alTmpUpdateData.add(login_facility_id);		
					alTmpUpdateData.add((String)hmData.get("BIN_LOCATION_CODE_"+index));
					alTmpUpdateData.add(getItem_code());
					alTmpUpdateData.add(getStore_code());
					alUpdateData.add(alTmpUpdateData);
			}
		}
        hmSQLMap.put("hdrInsertSQL",getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT"));
        hmSQLMap.put("dtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_UPDATE"));
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrInsertData", alInsData);
        hmTableData.put("DtlInsertData", alUpdateData);
        return ItemStoreBinMethodCall(hmTableData, hmSQLMap);
	}
    public HashMap ItemStoreBinMethodCall(HashMap hashmap, HashMap hashmapQuery)
    {
        HashMap hashmapResult = new HashMap();
			
        try
        {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_KIT_TEMPLATE"),KitTemplateLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
        catch(Exception exception) {
			exception.printStackTrace() ;
			}
			
			
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
        return hashmapResult;
    }
//Code added by Mahesh ends here...no more extra changes done by Mahesh as on 6/13/2008
/*public java.util.HashMap insert() {
	    HashMap map								=		new HashMap()	;
		Connection				 connection		=		null;
		PreparedStatement		 pstmt1			=		null;
		PreparedStatement		 pstmt2			=		null;

		boolean					insert_rec_1	=		true;
		boolean					update_rec_1	=		true;
		boolean					no_records		=		false;
		int						count_i			=		 0;
		HashMap		hmData			=		new HashMap();
		try{
			 connection					=		getConnection();
			 pstmt1						=		connection.prepareStatement(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT"));
			 pstmt2						=		connection.prepareStatement(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_UPDATE"));
			 map.put("result", new Boolean(false));
			 hmData						=		(HashMap)hmCommonData.get(getItem_code()+getStore_code());
			 for (int index=0;index<getTotalRecords();index++) {
			     if(hmData.get("DB_ACTION_"+index)==null)break;
		if((hmData.get("DB_ACTION_"+index)).equals("I")&&(hmData.get("EFF_STATUS_"+index)).equals("Y"))
			 {
					pstmt1.setString(1,getStore_code());
					pstmt1.setString(2,getItem_code());
					pstmt1.setString(3,(String)hmData.get("BIN_LOCATION_CODE_"+index));    
					pstmt1.setString(4,login_by_id);
					pstmt1.setString(5,login_at_ws_no);
					pstmt1.setString(6,login_facility_id);
					pstmt1.setString(7,login_by_id);
					pstmt1.setString(8,login_at_ws_no);
					pstmt1.setString(9,login_facility_id);
					pstmt1.setString(10,(String)hmData.get("EFF_STATUS_"+index));
					pstmt1.addBatch();
			  }
			  else if((hmData.get("DB_ACTION_"+index).equals("U")))
				{
					if((hmData.get("EFF_STATUS_"+index)).equals("Y"))
				    {
						pstmt2.setString(1,"Y");
					}
					else if((hmData.get("EFF_STATUS_"+index)).equals("N"))
					{
					    pstmt2.setString(1,"N");
					}
					 	pstmt2.setString(2,login_by_id);   		  
						pstmt2.setString(3,login_at_ws_no);		
						pstmt2.setString(4,login_facility_id);		
						pstmt2.setString(5,(String)hmData.get("BIN_LOCATION_CODE_"+index));
						pstmt2.setString(6,getItem_code());
						pstmt2.setString(7,getStore_code());
					    pstmt2.addBatch();
				}
else if(((hmData.get("DB_ACTION_"+index).equals("I"))&&((hmData.get("EFF_STATUS_"+index)).equals("N"))))
  					{	
						count_i		=		count_i+1;
						if(count_i==getTotalRecords())
						no_records	=		true;
						else
						no_records	=		false;
					}
				}
						int [] numInserts	=		pstmt1.executeBatch();  
						int [] numUpdates	=		pstmt2.executeBatch();
						for (int i=0;i<numInserts.length ;i++ )
							{
								if(numInserts[i]<0  && numInserts[i] != -2 )
								{
								       insert_rec_1	=		false;
								       break;
								}
								else{
								       insert_rec_1	=		true;
									}
									
							}
						  	for (int i=0;i<numUpdates.length ;i++ )
							{
								if(numUpdates[i]<0  && numUpdates[i] != -2 )
								{
								      update_rec_1	=		false;
								      break;
								}
								else
								{
								      update_rec_1	=		true;
								}
									
							}

					
				if(insert_rec_1 || update_rec_1 )
					{
						if(no_records==false)
						{
							connection.commit();
							map.put( "result", new Boolean( true ) ) ;
							map.put( "LanguageData",getLanguageId());
							map.put( "properties", getProperties());
							if( ((Boolean) map.get( "result" )).booleanValue() ){
								 map.put( "message", getSTMessage(getLanguageId(), "RECORD_INSERTED" ,"ST") ) ;
							 }
						else{
							 map.put( "message", (map.get("message"))) ;
						}
						
							map.put("flag","");
						}
						else if(no_records)
						{							
									map.put( "result", new Boolean( true ) ) ;
									map.put( "LanguageData",getLanguageId());
									map.put( "properties", getProperties());
									
									if( ((Boolean) map.get( "result" )).booleanValue() ){
										 map.put( "message", getMessage(getLanguageId(),"ATLEAST_ONE_SELECTED","Common") ) ;
										 }
									else{
									 map.put( "message", (map.get("message"))) ;}
								
						}
					}else{
							try{
								connection.rollback();
								map.put("flag","true");
							}
							catch(Exception es){
								es.printStackTrace() ;
								map.put("flag","");
							}

												
						}
		}
			catch (Exception e)
			{
				map.put("message", map.get("message") + e.toString()) ;
				e.printStackTrace();
			}
			  finally
		{
		try
		{
			closeStatement(pstmt1);
			closeStatement(pstmt2);
			closeConnection(connection);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		}
	
		return map;
	}
*/
	public HashMap validate() {

		boolean result=false;
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		
		try{
			HashMap hmData				=		(HashMap)hmCommonData.get(getItem_code()+getStore_code());
			
			for(int i=0;i<getTotalRecords();i++)
		{
				if((String)hmData.get("EFF_STATUS_"+i)==null)break;
			// if no checkbox is not  checked or no data is entered..
			if(((String)hmData.get("EFF_STATUS_"+i)).equals("Y")){
					result=true;
					
				}
				
		}
	
		if(result==false){
				resultMap.put("result", super.FALSE);
				resultMap.put("message", getMessage(getLanguageId(),"MIN_ONE_DETAIL_REQUIRED","Common") );
		}
		}
			catch(Exception exception)
			{
				
				exception.printStackTrace();

			}
		return resultMap;
	}

	public void setAll(java.util.Hashtable hashValues) {
		
		
		updateSelected_Bin_location_code(hashValues);
	}

	public int getStockStatus(String store_code,String item_code,String bin_location_code)
	{
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			int result	=0;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_STOCK_STATUS")) ;
			

			pstmt.setString( 1, item_code ) ;
			pstmt.setString( 2, store_code ) ;
			pstmt.setString( 3, bin_location_code ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				result	=	resultSet.getInt(4);
			}
			if(resultSet==null) result=0;
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		
			return result;
	}
	public String getEffStatus(String store_code,String item_code,String bin_location_code)
	{
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			String result="";
			
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_EFF_STATUS")) ;
			

			pstmt.setString( 1, item_code ) ;
			pstmt.setString( 2, store_code ) ;
			pstmt.setString( 3, bin_location_code ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				result	=	resultSet.getString(1);
			}
			
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		
			return result;
	}
	public HashMap getData()
	{
		return hmCommonData;
	}
	public ArrayList getResultPage(String store_code,String bin_location_search_string){
			ArrayList alParams		=		new ArrayList();
			HashMap hmTemp			=		new HashMap();

			alParams.add(store_code);
			alParams.add(bin_location_search_string);
			alParams.add(getLanguageId());
			
			ArrayList result1		=		 new ArrayList();
			ArrayList result		=		new ArrayList();
			try{
				result1				=		fetchRecords(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_ALL"),alParams);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			if(result1.size()>0){
				for(int i=0;i<result1.size();i++){
					hmTemp			=		(HashMap)result1.get(i);
					
					result.add((String)hmTemp.get("BIN_LOCATION_CODE"));
					result.add((String)hmTemp.get("SHORT_DESC"));
				}
				
				return result;
			}
			else
					
				return result;
			

	}
	public int getTotalCntRecords(String store_code)
	{
		Connection				 connection		=		null;
		PreparedStatement		 pstmt1			=		null;
		ResultSet				 resultSet		=		null;
		int						 result			=		0;
		try{
					connection					=		getConnection();

				
					pstmt1						=		connection.prepareStatement(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_COUNT1"));
					pstmt1.setString(1,store_code);
					pstmt1.setString(2,getLanguageId());
					resultSet=pstmt1.executeQuery();
				 while (resultSet != null && resultSet.next()) {
					result						=		resultSet.getInt("TOTAL");
				 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
					return result;
					
		}	 

public void setSelect_All(String select_all) {
		 this.select_all = checkForNull(select_all);
	}

	public String getSelect_All() {
		 return select_all;
	}


public int getBinlocationStatus(String store_code,String item_code,String bin_location_code)
	{
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			int result	=0;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT_SELECT")) ;
			//pstmt = connection.prepareStatement("SELECT COUNT(*) count FROM st_item_store WHERE item_code = ?  AND store_code = ? AND bin_location_code =? AND eff_status = 'E'") ;
			

			pstmt.setString( 1, item_code ) ;
			pstmt.setString( 2, store_code ) ;
			pstmt.setString( 3, bin_location_code ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				result	=	resultSet.getInt("count");
			}
			if(resultSet==null) result=0;
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
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
