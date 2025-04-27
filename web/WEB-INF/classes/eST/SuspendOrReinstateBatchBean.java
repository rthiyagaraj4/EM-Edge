/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
import java.util.*;
import java.io.*;
//import javax.servlet.http.*;
import javax.rmi.* ; 
import javax.naming.* ;
import eST.Common.* ;
import eST.SuspendOrReinstate.* ;
import eCommon.Common.*; 

public class SuspendOrReinstateBatchBean extends StTransaction implements Serializable{

	private String item_code ;
	private String manufacturer ;
	private String batch ;
	private String batch_status ;
	private String batch_id ;
	private String remarks ;
	private String initiated_by ;
	private String profile ;
	private String batchstatusnotify ;
//	private String language_id ;
    private String store_code ;
    private String facility ;

	private java.util.HashMap hmRemarks;
    private ArrayList DataList ;

	private String stExternal_yn  ;

	//private ArrayList DataList=new ArrayList() ;


    public SuspendOrReinstateBatchBean() {
		
		hmRemarks = new java.util.HashMap();
	}

/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
/*	public void setAll(Hashtable hashtable) {
        //splitBatchDetailBean.setAll(hashtable);
    }*/

	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean*/
		/*not required to process exp records..*/
		return getMessageHashMap(true);	
	}
	
	public HashMap insert(){
		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		HashMap hmScreenData= new HashMap();
		
		try {
			hmSQLMap.put("ItemBatchSQL", getStRepositoryValue("SQL_ST_SUSPEND_UPDATE_ITEM_BATCH"));
			hmSQLMap.put("BatchControlSQL", getStRepositoryValue("SQL_ST_SUSPEND_UPDATE_CONTROL"));
			hmSQLMap.put("InsertBatchStatusSQL", getStRepositoryValue("SQL_ST_SUSPEND_INSERT_BATCH_STATUS"));
	
			ArrayList alDtlListS	=	null ;
			ArrayList alScreenRows	=new ArrayList();
			ArrayList alBatchDtlRows	=	new ArrayList();
			ArrayList alBatchDtl	=	null;
			//ArrayList arrTrnfacility	=	null; //commented by Rabbani on 24-Mar-2014 for chkstyles
            ArrayList  alSusupd = null;
			ArrayList  alInsertBatch = new ArrayList();
		
			String suspend="";
			String suspend_status = "";
			String suspend_status_inc = "";
			if(getBatch_status().equals("S"))
				suspend="Y";
			else
				suspend="N";
				
			if((getBatch_status().trim()).equals("C"))
				 suspend = "C";

            String stTempBatchStatus = getBatch_status().trim() ; 
            if(getBatch_status().equals("R"))
			  stTempBatchStatus = "A" ;  

			 //arrTrnfacility   =	 getFacility_names();
			 //Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  01-AUG-2013 Starts
			/*  if(checkForNull(getStore_code()).equals("") && (checkForNull(getFacility()).equals("") || arrTrnfacility.size() == 1))
			  stTempBatchStatus = stTempBatchStatus;  
			  else
			  stTempBatchStatus = "A" ; */
			  //ends
			  //Added by Rabbani #CRF-ST- Bru-HIMS-CRF-111/01 (Inc no:42634) on 22-AUG-2013 Starts
			  //Select Batch for notify and include notify batches check box checked then update notify and reinstate batches
			  if(getBatch_status().equals("C") && getBatchStatusNotify().equals("C")){
			   suspend_status     = "N";
			   suspend_status_inc = "C";
			   }
			   else if(getBatch_status().equals("C") && getBatchStatusNotify().equals("A")){
			   //Select Batch for notify and include notify batches check box unchecked then update only reinstate  batches
			    suspend_status     = "N";
			    suspend_status_inc = "N";
			   }else if(getBatch_status().equals("S") && getBatch().equals("C")){
			   //Select Batch for Suspend and only notify batches check box checked then update only notify  batches
			    suspend_status     = "C";
			    suspend_status_inc = "C";
			   }else if(getBatch_status().equals("S") && getBatch().equals("A")){
			   //Select Batch for Suspend and only notify batches check box unchecked then update both reinstate and notify batches
			     suspend_status     = "N";
			     suspend_status_inc = "C";
			   }else if(getBatch_status().equals("R") && getBatchStatusNotify().equals("C")){
			    //Select Batch for Reinstate and include notify batches check box checked then update both Suspend and notify batches
			    suspend_status     = "C";
			    suspend_status_inc = "Y";
			   }else if(getBatch_status().equals("R") && getBatchStatusNotify().equals("S")){
			   //Select Batch for Reinstate and include notify batches check box unchecked then update only Suspend  batches
			    suspend_status     = "Y";
			    suspend_status_inc = "Y";
			   }
			   //ends
			  
			for (int i=0;i<DataList.size();i++){

			    hmScreenData =(HashMap)DataList.get(i);
					
					if(((String)hmScreenData.get("SELECTED")).equals("Y")){

						String st_item_code   = (String)hmScreenData.get("ITEM_CODE") ;
						String st_batch_id    = (String)hmScreenData.get("BATCH_ID") ;
						String st_expiry_date = (String)hmScreenData.get("EXPIRY_DATE") ;


						String stKey=st_item_code+"-"+st_batch_id+"-"+st_expiry_date ;
						String tempRemarks = "" ;
						if((getBatch_status().trim()).equals("C"))
							tempRemarks  = "Notified";

						if((getBatch_status().trim()).equals("S"))
							tempRemarks  = "Suspended";

						if((getBatch_status().trim()).equals("R"))
							tempRemarks  = "Reinstated";
					
						

						String st_initiated_by ="";
						st_initiated_by = (String)getLoginById() ;
						String st_profile = "";
						st_profile = checkForNull(getJobProfile());
						String product_recall = "N";
						
						if (hmRemarks.size() > 0){
						String stallString = ((Object)hmRemarks.get(stKey)).toString();
							StringTokenizer stallRemarks;
							try
							{
							 stallRemarks	=	new StringTokenizer(stallString,"=");

							String tempVAlue ="" ;
							for (int k=0 ; k<7 ; k++ )
							{		
								tempVAlue ="" ;					
								tempVAlue = stallRemarks.nextToken() ;
								tempVAlue=tempVAlue.trim();
								if(k==3)
								{
									if (!(tempVAlue.trim().equals("")))
									{
										 tempRemarks = tempVAlue.trim();
									}
								}
								if(k==4)
								{

									if (!(tempVAlue.trim().equals("")))
									{
									  st_initiated_by = tempVAlue.trim() ;
									}
								}							
								if(k==5)
								{

									if (!(tempVAlue.trim().equals("")))
									{
									  st_profile = tempVAlue.trim() ;
									}
								}							
								if(k==6)
								{

									if (!(tempVAlue.trim().equals("")))
									{
									  product_recall = tempVAlue.trim() ;

									}
								}							
								 
							}			
							}catch(Exception e)
							{
								e.printStackTrace();
							}
					   }
						alDtlListS=new ArrayList();
						// alDtlListS.add(getBatch_status());
                      if(checkForNull(getStore_code()).equals("") && (checkForNull(getFacility()).equals(""))){
						alDtlListS.add(stTempBatchStatus);
						alDtlListS.add(tempRemarks.trim());
						alDtlListS.add(st_initiated_by.trim());
						alDtlListS.add(st_profile.trim());
						alDtlListS.add(product_recall.trim());

                      /*  if(getExternal_YN().equals("Y"))
						  alDtlListS.add("Y");
						else
   						  alDtlListS.add("N");*/

						alDtlListS.add(getLoginById());
						alDtlListS.add(getLoginAtWsNo() );
						alDtlListS.add(getLoginFacilityId() );

						alDtlListS.add((String)hmScreenData.get("ITEM_CODE"));
						alDtlListS.add((String)hmScreenData.get("BATCH_ID"));
						alDtlListS.add((String)hmScreenData.get("EXPIRY_DATE"));
						alScreenRows.add(alDtlListS);
                        }
						if(!(getStore_code().equals("")) ||  !(getFacility().equals(""))){
						
						alSusupd=new ArrayList();
 						alSusupd.add(checkForNull((String)hmScreenData.get("ITEM_CODE")));
						alSusupd.add(checkForNull((String)hmScreenData.get("BATCH_ID")));
						alSusupd.add(checkForNull((String)hmScreenData.get("EXPIRY_DATE")));
						alSusupd.add(checkForNull((String)hmScreenData.get("TRADE_ID")));
						alSusupd.add(checkForNull((String)hmScreenData.get("BATCH_STATUS")));
						//alSusupd.add(getBatch_status());
					    alSusupd.add(stTempBatchStatus);
						alSusupd.add(tempRemarks.trim());
						alSusupd.add(st_initiated_by.trim());
						alSusupd.add(st_profile.trim());
						alSusupd.add(product_recall.trim()); //EXTERNAL
						alSusupd.add(getLoginById());
						alSusupd.add(getLoginAtWsNo() );
						alSusupd.add(getLoginFacilityId() );
						alSusupd.add(getLoginById());
						alSusupd.add(getLoginAtWsNo() );
						alSusupd.add(getLoginFacilityId() );
						alSusupd.add(checkForNull((String)hmScreenData.get("FACILITY_ID"))); //02/08/2013
						alSusupd.add(checkForNull((String)hmScreenData.get("STORE_CODE"))); //02/08/2013

						alInsertBatch.add(alSusupd);
 						}
						alBatchDtl=new ArrayList();
						alBatchDtl.add(suspend);
						alBatchDtl.add(getLoginById());
						alBatchDtl.add(getLoginAtWsNo() );
						alBatchDtl.add(getLoginFacilityId() );
						alBatchDtl.add((String)hmScreenData.get("ITEM_CODE"));
						alBatchDtl.add((String)hmScreenData.get("BATCH_ID"));
						alBatchDtl.add((String)hmScreenData.get("EXPIRY_DATE"));
						//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts
						alBatchDtl.add(checkForNull((String)hmScreenData.get("FACILITY_ID"),"%"));  
						alBatchDtl.add(checkForNull((String)hmScreenData.get("STORE_CODE"),"%"));  
						//ends
						 //Added by Rabbani #CRF-ST- Bru-HIMS-CRF-111/01 (Inc no:42634) on 22-AUG-2013
						alBatchDtl.add(suspend_status); 
						alBatchDtl.add(suspend_status_inc); 
						//ends
						alBatchDtlRows.add(alBatchDtl);
					}
			}

			hmTableData.put("properties",	getProperties());
			hmTableData.put("ControlData",	alScreenRows);
			hmTableData.put("BatchData",	alBatchDtlRows);
			hmTableData.put("AlInsertBatchStatus",alInsertBatch);
			 

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		/*must be del after ejb deployment*/
		
			HashMap		hmResult	=	new HashMap()	;
			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;
		try{
		//uspendOrReinstateHome suspendOrReinstateHome = null;
		//uspendOrReinstateRemote suspendOrReinstateRemote = null;
		  /* InitialContext initialcontext = new InitialContext();
			Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_ST_SUSPEND_OR_REINSTATE"));
			suspendOrReinstateHome = (SuspendOrReinstateHome)PortableRemoteObject.narrow(obj, SuspendOrReinstateHome.class);
			suspendOrReinstateRemote = suspendOrReinstateHome.create();

			hmResult = suspendOrReinstateRemote.insert( hmTableData, hmSQLMap ) ;*/                                                                                                                   
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_SUSPEND_OR_REINSTATE"),eST.SuspendOrReinstate.SuspendOrReinstateHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		}
		catch(Exception exception) {
		exception.printStackTrace();
		}
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

	public void setItem_code(String item_code) {
		this.item_code=item_code;
	}

	public String getItem_code() {
		return this.item_code;
	}

	public void setExternal_YN(String stExternal_yn) {
		this.stExternal_yn=stExternal_yn;
	}

	public String getExternal_YN() {
		return this.stExternal_yn;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer=manufacturer;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setBatch(String batch) {
		this.batch=batch;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch_status(String batch_status) {
		this.batch_status=batch_status;
	}

	public String getBatch_status() {
		return this.batch_status;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id=batch_id;
	}

	public String getBatch_id() {
		return this.batch_id;
	}

    public void setRemarks(String remarks) {
		 this.remarks = remarks;

	}

	public String getRemarks() {
		 return this.remarks;
	}

   public void setInitiated_by(String initiated_by) {
		 this.initiated_by = initiated_by;
	}

	public String getInitiated_by() {
		 return this.initiated_by;
	}

	public void setProfile(String profile) {
		 this.profile = profile;

	}

	public String getProfile() {

		 return this.profile;
	}

	public String getBatchStatus()
	{
		return getStaticListOptionTag("C,Notify;S,Suspend;R,Reinstate");
	}


    public void setBatchStatusNotify(String batchstatusnotify) {
		this.batchstatusnotify = batchstatusnotify;
 
	}

    public String getBatchStatusNotify()
	{
		return batchstatusnotify ;
	}

	 //Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts
	public void setStore_code(String store_code) {
		this.store_code=store_code;
	}

	public String getStore_code() {
		return this.store_code;
	}
	public void setFacility(String facility) {
		this.facility=facility;
	}

	public String getFacility() {
		return this.facility;
	}

  //ends
	public String getManufacturerList(){
			ArrayList arr_lang = new ArrayList();
			arr_lang.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_SEARCH_MANUFACTURER"),arr_lang));
	}

// Added on 11/19/2005 by RAM for populating the manufacturer based upon the Item Code
		public ArrayList getManufacturerList_item(String Item_code) throws Exception
		{
			String chkParameters[] = {Item_code,getLanguageId(),Item_code,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_SEARCH_MANUFACTURER_CMPLNT"),chkParameters);
			return result;
		}


	public ArrayList getDataList(){

		return DataList;
	}
	
	//public void loadResultPage() throws Exception {
	public void loadResultPage(String item_batch,String st_batch) throws Exception {

		//String alParameters[] ={getItem_code(),getBatch(),getBatchStatusNotify(),getManufacturer(),getBatch_id(),getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),getLoginFacilityId()};
		
		 String alParameters[] ={getItem_code(),item_batch,st_batch,getManufacturer(),getBatch_id(),getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId()};
		 
		 String facilityid = checkForNull((String)getFacility());
		 String storecode  = checkForNull((String)getStore_code());
		
      	ArrayList listRecord =new ArrayList();
		try {
			//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts
	    	String sql = "SELECT   b.batch_status, a.batch_id, TO_CHAR (a.expiry_date, 'dd/mm/yyyy') expiry_date, trade_name, manufacturer_name, SUM (qty_on_hand) qtyonhand,SUM (AVAIL_QTY) availqty, 'N' selected, a.item_code, b.remarks, status_updated_by,status_remarks_oth,a.trade_id";
		
          if(!(storecode.equals(""))){
			sql = sql + " , a.store_code, A.STORE_DESC,a.SUSPENDED_YN ";
			}
			if(!(facilityid.equals(""))){
			sql = sql + " , facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = c.facility_id AND language_id = " + "'"+getLanguageId()+"') facility_name ";
			}
			
			sql = sql + " FROM st_batch_search_lang_view a, ST_BATCH_CONTROL b , mm_store_lang_vw c, ST_ACC_ENTITY_PARAM d WHERE  a.item_code = b.item_code AND a.batch_id = b.batch_id AND a.expiry_date = b.expiry_date_or_receipt_date AND a.item_code = ?  AND  a.SUSPENDED_YN IN (?, ?) AND a.manufacturer_id LIKE (? || '%') AND a.batch_id LIKE (? || '%') AND a.language_id = c.language_id AND c.store_code = a.store_code AND a.language_id = ? AND DECODE (a.lang1, NULL, ?, a.lang1) = ? AND DECODE (a.lang2, NULL, ?, a.lang2) = ? ";
			
			if(!(storecode.equals(""))){
			sql = sql + " and C.STORE_CODE = " + "'"+storecode+"'"  ;
			}
			if(!(facilityid.equals(""))){
			sql = sql + " AND c.facility_id = " + "'"+facilityid+"'"  ;
             }

			
			sql = sql + "GROUP BY a.batch_id, a.expiry_date, trade_name, manufacturer_name, b.batch_status, a.item_code, b.remarks, status_updated_by, status_remarks_oth,a.trade_id  " ;
			
			if(!(storecode.equals(""))){
			sql = sql + ",a.store_code,A.STORE_DESC,a.SUSPENDED_YN ";
			}
			
			if(!(facilityid.equals(""))){
			sql = sql + ",facility_id ";
			}
			
			sql = sql + "ORDER BY 1, 2" ; 
			
			String stSQL = sql;
		
			
			//String stSQL=getStRepositoryValue("SQL_ST_SUSPEND_BATCH_QUERY");
			if(stSQL != null )  // Added for INC # 39809
				listRecord = fetchRecords(stSQL.toString(),alParameters);

			DataList=listRecord;
			HashMap hmTempRecord = new HashMap();
			String tempKey = "" ;
			for(int i=0 ; i<DataList.size();i++){
                hmTempRecord = (HashMap)DataList.get(i);
                tempKey = (String)hmTempRecord.get("ITEM_CODE");
				tempKey = tempKey + "-" ;
				tempKey = tempKey + (String)hmTempRecord.get("BATCH_ID");
                tempKey = tempKey + "-" ;
				tempKey = tempKey + (String)hmTempRecord.get("EXPIRY_DATE");
				
//                hmRemarks.put(tempKey.toString(),new SuspendOrReinstateRemarksBean( (String)hmTempRecord.get("ITEM_CODE"), (String)hmTempRecord.get("BATCH_ID"),(String)hmTempRecord.get("EXPIRY_DATE"), checkForNull( (String)hmTempRecord.get("REMARKS"),""), checkForNull( (String)hmTempRecord.get("STATUS_UPDATED_BY"),"") , checkForNull( (String)hmTempRecord.get("STATUS_REMARKS_OTH"),"")  ));
//                hmRemarks.put(tempKey.toString(),new SuspendOrReinstateRemarksBean( (String)hmTempRecord.get("ITEM_CODE"), (String)hmTempRecord.get("BATCH_ID"),(String)hmTempRecord.get("EXPIRY_DATE"),"", checkForNull( (String)hmTempRecord.get("STATUS_UPDATED_BY"),""),checkForNull( (String)hmTempRecord.get("STATUS_REMARKS_OTH"),"") );
//               hmRemarks.put(tempKey.toString(),new SuspendOrReinstateRemarksBean( (String)hmTempRecord.get("ITEM_CODE"), (String)hmTempRecord.get("BATCH_ID"),(String)hmTempRecord.get("EXPIRY_DATE"),"", checkForNull((String)hmTempRecord.get("STATUS_UPDATED_BY"),""),checkForNull((String)hmTempRecord.get("STATUS_REMARKS_OTH"),"")));
               hmRemarks.put(tempKey.toString(),new SuspendOrReinstateRemarksBean( (String)hmTempRecord.get("ITEM_CODE"), (String)hmTempRecord.get("BATCH_ID"),(String)hmTempRecord.get("EXPIRY_DATE"),"", checkForNull((String)getLoginById() ,""),checkForNull((String)getJobProfile(),""),"N"));
		}

	} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	
public ArrayList getBatchHistoryRecords(String stItem,String stBatchId,String stExpiryDate) throws Exception {
		//String alParameters[] = {stItem,stBatchId,stExpiryDate};
		String stfacility = checkForNull(getFacility(),"%");
		String ststore    = checkForNull(getStore_code(),"%");
		//String alParameters[] = {getLanguageId(),stItem,stBatchId,stExpiryDate,stfacility,ststore};
		//added by Rabbani #Bru-HIMS-CRF-111[Inc no : 30070] on 26-AUG-13
		String alParameters[] = {getLanguageId(),getLanguageId(),stItem,stBatchId,stExpiryDate,stfacility,ststore};
		ArrayList tempArrayList = new ArrayList() ; 

      	try {
			
			String stSQL=getStRepositoryValue("SQL_ST_SUSPEND_BATCH_HISTORY_QUERY");
			if(stSQL != null)  // Added for INC # 39809
				tempArrayList = fetchRecords(stSQL.toString(),alParameters);
			return tempArrayList ;
			
			

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}



	public void setCheckbox (Hashtable hash,int start,int end){
		if(DataList.size()>0){
			for(int i=start;i<end;i++){
				try
				{
				HashMap hmRecord =new HashMap();
				hmRecord=(HashMap) DataList.get(i);
				hmRecord.put("SELECTED",(String)hash.get("checkbox"+i));
				DataList.set(i,hmRecord); 
          		}catch(Exception e)
				{
				e.printStackTrace();
				}
			}
		}
	}

	public String getRemarks(String key) throws Exception {

		String tempRemarks ="" ;
		//String initiated_by ="" ;
		//String profile ="" ;

		if (hmRemarks.containsKey(key)) {

			SuspendOrReinstateRemarksBean suspendOrReinstateRemarksBean = (SuspendOrReinstateRemarksBean) hmRemarks.get(key);

            tempRemarks = (suspendOrReinstateRemarksBean.getRemarks()).trim() ;
/*			String stTempBatchStatus = getBatch_status().trim() ;
			if(stTempBatchStatus.equals("C"))
			{
		        if(tempRemarks.equals(""))
					{  	
					tempRemarks = "Notified on " + com.ehis.util.DateUtils.convertDate(getSystemDate(),"DMY","en",getLanguageId());	}
				
	         }else if(stTempBatchStatus.equals("R"))
					{
	  					   if(tempRemarks.equals(""))
								{  	tempRemarks = "Reinstated on " +com.ehis.util.DateUtils.convertDate(getSystemDate(),"DMY","en",getLanguageId());}
				
					}else 
						{
						   if(tempRemarks.equals(""))
							{  
							   if(stTempBatchStatus.equals("S"))
								{
							   tempRemarks =  "Suspended on " +  com.ehis.util.DateUtils.convertDate(getSystemDate(),"DMY","en",getLanguageId());}
							}
						}
		
	*/	}
         return tempRemarks ;

	}



	public String getInitiated_by(String key) throws Exception {

		String stInitiated_by ="" ;


		if (hmRemarks.containsKey(key)) {

			SuspendOrReinstateRemarksBean suspendOrReinstateRemarksBean = (SuspendOrReinstateRemarksBean) hmRemarks.get(key);

   			stInitiated_by = suspendOrReinstateRemarksBean.getInitiated_by() ;

		}
         return stInitiated_by ;

	}

	public String getProduct_Recall(String key) throws Exception {

		String productrecall ="" ;


		if (hmRemarks.containsKey(key)) {

			SuspendOrReinstateRemarksBean suspendOrReinstateRemarksBean = (SuspendOrReinstateRemarksBean) hmRemarks.get(key);

   			productrecall = suspendOrReinstateRemarksBean.getProduct_Recall() ;

		}
         return productrecall ;

	}
	public String getProfile(String key) throws Exception {

		String stProfile ="" ;


		if (hmRemarks.containsKey(key)) {
			SuspendOrReinstateRemarksBean suspendOrReinstateRemarksBean = (SuspendOrReinstateRemarksBean) hmRemarks.get(key);

   			stProfile = suspendOrReinstateRemarksBean.getProfile() ;
		}
         return stProfile ;

	}
public String getJobProfile() throws Exception{
	HashMap hmRecord	= new HashMap();
	HashMap hmRecord11=new HashMap();
	String function_role="";
	String position_description="";
	try{
		 hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_SUSPEND_REINSTATE_PROFILE"),getLoginById());
			if(hmRecord!=null)
			{
			//function_role= checkForNull(hmRecord.get("FUNC_ROLE").toString());Commented for the Inc#39809
			function_role= checkForNull((String)hmRecord.get("FUNC_ROLE"));
			ArrayList arr_lang=new ArrayList();
			arr_lang.add(getLoginById());
			arr_lang.add(getLanguageId());
			if(function_role.equals("P"))
		{
				 hmRecord11		=	fetchRecord(getStRepositoryValue("SQL_ST_SUSPEND_REINSTATE_PROFILE11"),arr_lang);
				 //position_description=checkForNull(hmRecord11.get("POSITION_DESC").toString()); Commented for the Inc#39809
				 position_description=checkForNull((String)hmRecord11.get("POSITION_DESC"));
				 
		}
		else
		{
				 hmRecord11		=	fetchRecord(getStRepositoryValue("SQL_ST_SUSPEND_REINSTATE_PROFILE22"),arr_lang);
				 //position_description=checkForNull(hmRecord11.get("POSITION_DESC").toString()); Commented for the Inc#39809
				 position_description=checkForNull((String)hmRecord11.get("POSITION_DESC"));

		}
		}

		}catch (Exception e)
			{
			e.printStackTrace();
			   return "";
			}
			return position_description;
}

public void updateRemarks(java.util.Hashtable remarksData) {

		StringBuffer key = new StringBuffer();
		String item_code = (String) remarksData.get("item_code");
		item_code.trim();
        key.append(item_code);
		key.append('-');

		String batch_id = (String) remarksData.get("batch_id");
        batch_id.trim();
        key.append(batch_id);
		key.append('-');

        String expiry_date = (String) remarksData.get("expiry_date");
        expiry_date.trim();
        key.append(expiry_date);
		
		hmRemarks.put(key.toString(),new SuspendOrReinstateRemarksBean(item_code, batch_id,expiry_date, (String)remarksData.get("remarks"), (String)remarksData.get("initiated_by"), (String)remarksData.get("profile"),  (String)remarksData.get("product_recall")  ));

		//setCancelled_remarks( (String)remarksData.get("remarks") );
        //setRemarks( (String)remarksData.get("remarks") );
		//setInitiated_by( (String)remarksData.get("initiated_by") );
		//setProfile( (String)remarksData.get("profile") );

}
	
    public void initialize() {
		super.initialize();

		 item_code = "" ;
		 manufacturer = "" ;
		 batch = "" ;
		 batch_status ="" ;
		 batch_id  = "" ;
		 remarks = "";
		 initiated_by ="" ;
		 profile ="";
         stExternal_yn ="" ;
		 batchstatusnotify = "";
		 store_code = "";
		 facility = "";

		 hmRemarks = new HashMap() ;
		 DataList = new ArrayList() ;

	}

	public void clear() {
		
	}
//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  01-AUG-2013 Starts
public ArrayList getFacility_names(){
	
	 ArrayList array = new ArrayList();
	 ArrayList alFacilitydata = new ArrayList();
		try{
		array.add(getLanguageId());
		array.add(getLoginById());
	    alFacilitydata = fetchRecords(getStRepositoryValue("SQL_ST_FACILITY_NAME_QUERY"),array);
		}catch(Exception e) {
		  e.printStackTrace();
		}
		return alFacilitydata;
	}  
	
	public String getFacilitynames(){
			String optionValues = null;
			ArrayList alOptionValues = new ArrayList();
			ArrayList arr_language=new ArrayList();
			arr_language.add(getLanguageId());
		    arr_language.add(getLoginById());
			alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_FACILITY_NAME_QUERY"), arr_language);
			alOptionValues.remove(0);
			optionValues = getListOptionTag(alOptionValues,getLoginFacilityId());
			return optionValues;
	
	}
	public ArrayList getBatchSuspendStatus(String stItem,String stBatchId,String stExpiryDate) throws Exception {
	
	   String stfacility  = checkForNull(getFacility(),"%");
		String ststore    = checkForNull(getStore_code(),"%");
		String batch_item = "N";
		String st_batch   = "N";
		
		/*if(getBatch().equals("C")){
			 batch_item = "C";
		  }
		   else if(getBatch().equals("S")){
			 batch_item = "Y";
			}else{
			 batch_item = "N";
			}
			
			 if(getBatchStatusNotify().equals("C")){
			 st_batch = "C";
			}
			else if(getBatchStatusNotify().equals("S")){
			 st_batch = "Y";
			}else{
			 st_batch = "N";
			}
			*/
			if(getBatch_status().equals("C") && getBatchStatusNotify().equals("C")){
			   batch_item     = "N";
			   st_batch       = "C";
			   }
			   else if(getBatch_status().equals("C") && getBatchStatusNotify().equals("A")){
			    batch_item     = "N";
			    st_batch       = "N";
			   }else if(getBatch_status().equals("S") && getBatch().equals("C")){
			    batch_item     = "C";
			    st_batch       = "C";
			   }else if(getBatch_status().equals("S") && getBatch().equals("A")){
			     batch_item     = "N";
			     st_batch       = "C";
			   }else if(getBatch_status().equals("R") && getBatchStatusNotify().equals("C")){
			    batch_item     = "C";
			    st_batch       = "Y";
			   }else if(getBatch_status().equals("R") && getBatchStatusNotify().equals("S")){
			    batch_item     = "Y";
			    st_batch       = "Y";
			   }
		String alParameters[] = {stItem,batch_item,st_batch,stBatchId,stExpiryDate,getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),ststore,stfacility};
		ArrayList tempArrayList = new ArrayList() ; 

      	try {
			String stSQL=getStRepositoryValue("SQL_ST_SUSPEND_SHOW_BATCH_STATUS");
			tempArrayList = fetchRecords(stSQL.toString(),alParameters);
			return tempArrayList ;
		 }catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

}
