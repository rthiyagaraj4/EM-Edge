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
4/1/2022				TFS-21670				Shazana					 									AMRI-SCF-0673
4/1/2022				TFS-27193				Shazana 													NMC-JD-SCF-0261
11/1/2022				TFS-21670						Shazana														AMRI-SCF-0673
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.* ;

import eST.Common.* ;

public class ChangeExpiryFlagBean extends StTransaction implements Serializable {

	protected String item_code		="";
	//protected String language_id;
	protected String expiry_flag		="N";
	
	protected String grn_count	="";
	protected String sal_count	="";
	protected String rtv_count	="";
	protected String srt_count	="";
	protected String iss_count	="";
	protected String adj_count	="";
	protected String urg_count	="";
	protected String tfr_count	="";
	protected String ret_count	="";
	protected String prt_count	="";
	protected String mfg_count	 ="";
	protected String batch_reload	 ="";
	protected Hashtable ALBatchChangedData=new Hashtable();
	protected int batchCount=0;
	ArrayList	ALData=new ArrayList();
	ArrayList	ALBatchData=new ArrayList();
	Hashtable check;
//	HashMap hm=new HashMap();

//	protected boolean totalOpenRecords=false;

	public String getExpiry_yn() throws Exception 
	{
			return expiry_flag;
	}

	public String getGRNCount() throws Exception 
	{
			return grn_count;
	}
/*	public void setLanguageId(String language_id) throws Exception 
	{
			this.language_id=language_id;
	}
	public String getLanguageId() throws Exception 
	{
			return language_id;
	}*/
	public String getSALCount() throws Exception 
	{
			return sal_count;
	}
		public String getRTVCount() throws Exception 
	{
			return rtv_count;
	}
	public String getSRTCount() throws Exception 
	{
			return srt_count;
	}
	public String getISSCount() throws Exception 
	{
			return iss_count;
	}
	public String getADJCount() throws Exception 
	{
			return adj_count;
	}
	public String getURGCount() throws Exception 
	{
			return urg_count;
	}
		public String getTFRCount() throws Exception 
	{
			return tfr_count;
	}
	public String getRETCount() throws Exception 
	{
			return ret_count;
	}
	public String getPRTCount() throws Exception 
	{
			return prt_count;
	}
	public String getMFGCount() throws Exception 
	{
			return mfg_count;
	}
	
	public String getBatchReload() throws Exception 
	{
			return batch_reload;
	}

	public ArrayList getStoreLevelCount(String item_code) throws Exception 
	{
			String [] alParameters={getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getItem_code(),getLanguageId(),getItem_code(),getLoginFacilityId(),getLanguageId()};
			ALData=fetchRecords(getStRepositoryValue("SQL_ST_STORE_LEVEL_COUNT"),alParameters);
			
			return ALData;
	}
	public void loadData() throws Exception
	{
			HashMap	hmRecord=new HashMap();
			ArrayList alParameters =new ArrayList();
			alParameters.add(getItem_code());
			alParameters.add(getLoginFacilityId());
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_GRN_COUNT"),alParameters);
			setGRNCount(checkForNull((String)hmRecord.get("GRN_COUNT"),"0"));
			
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_SAL_COUNT"),alParameters);
			setSALCount(checkForNull((String)hmRecord.get("SAL_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_RTV_COUNT"),alParameters);
			setRTVCount(checkForNull((String)hmRecord.get("RTV_COUNT"),"0"));
			
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_SRT_COUNT"),alParameters);
			setSRTCount(checkForNull((String)hmRecord.get("SRT_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_ISS_COUNT"),alParameters);
			setISSCount(checkForNull((String)hmRecord.get("ISS_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_ADJ_COUNT"),alParameters);
			setADJCount(checkForNull((String)hmRecord.get("ADJ_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_URG_COUNT"),alParameters);
			setURGCount(checkForNull((String)hmRecord.get("URG_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_TFR_COUNT"),alParameters);
			setTFRCount(checkForNull((String)hmRecord.get("TFR_COUNT"),"0"));
			
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_RET_COUNT"),alParameters);
			setRETCount(checkForNull((String)hmRecord.get("RET_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_PRT_COUNT"),alParameters);
			setPRTCount(checkForNull((String)hmRecord.get("PRT_COUNT"),"0"));

			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_MFG_COUNT"),alParameters);
			setMFGCount(checkForNull((String)hmRecord.get("MFG_COUNT"),"0"));
	}

	public boolean getUnfinalisedRecords() 
	{
		//returns true if any transaction is present
			boolean totalOpenRecords=false;


			if(!grn_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!sal_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!rtv_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!srt_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!iss_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!adj_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!urg_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!tfr_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!ret_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!prt_count.equals("0")){
				totalOpenRecords=true;	}
			else if(!mfg_count.equals("0")){
				totalOpenRecords=true;	}

			return totalOpenRecords;
	}

	public void setExpiry_yn(String expiry_flag)
	{
		this.expiry_flag=expiry_flag;
	}

	public void setGRNCount(String grn_count)
	{
		this.grn_count=grn_count;
	}

	public void setSALCount(String sal_count)
	{
		this.sal_count=sal_count;
	}
	public void setRTVCount(String rtv_count)
	{
		this.rtv_count=rtv_count;
	}
	public void setSRTCount(String srt_count)
	{
		this.srt_count=srt_count;
	}
	public void setISSCount(String iss_count)
	{
		this.iss_count=iss_count;
	}
	public void setADJCount(String adj_count)
	{
		this.adj_count=adj_count;
	}
	public void setURGCount(String urg_count)
	{
		this.urg_count=urg_count;
	}
	public void setTFRCount(String tfr_count)
	{
		this.tfr_count=tfr_count;
	}
	public void setRETCount(String ret_count)
	{
		this.ret_count=ret_count;
	}
	public void setPRTCount(String prt_count)
	{
		this.prt_count=prt_count;
	}
	public void setMFGCount(String mfg_count)
	{
		this.mfg_count=mfg_count;
	}
	public void setBatchReload(String batch_reload)
	{
		this.batch_reload=batch_reload;
	}
		 
	public void setItem_code(String item_code) {
		 this.item_code = item_code.toUpperCase	();
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setALBatchChangedData(Hashtable ALBatchChangedData) {
		 this.ALBatchChangedData = ALBatchChangedData;
	}
	
	public Hashtable getALBatchChangedData( ) {
		 return ALBatchChangedData;
	}
	/* Over-ridden Adapter methods start here */
	public HashMap validate() {

			
			
			boolean flag=true;
			int datediff=0;
			try{
			String sysDate = getSystemDate();



			for(int i=0;i<batchCount;i++)
			{
				//	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					datediff =( new SimpleDateFormat("dd/MM/yyyy").parse((String)check.get("expiry_date_or_receipt_date"+i))).compareTo( new SimpleDateFormat("dd/MM/yyyy").parse(sysDate));
						if(datediff < 0)
						{
							flag = false;
							 break;
						}
				
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( flag ) ) ;

		if(datediff > 0)
		hmReturn.put("message", "success mode="+getMode() ) ;
		else
		hmReturn.put("message", getSTMessage(getLanguageId(),"NOT_LESS_THAN_SYSDATE","ST")) ;

		return hmReturn ;
	}

	public void initialize(){
		super.initialize();
		item_code		="";
		expiry_flag		="N";
		grn_count	="";
		sal_count	="";
		rtv_count	="";
		srt_count	="";
		iss_count	="";
		adj_count	="";
		urg_count	="";
		tfr_count	="";
		ret_count	="";
		prt_count	="";
		mfg_count	 ="";
		batch_reload	="";
		ALBatchChangedData.clear();
		ALData.clear();
		ALBatchData.clear();
	}

	public void clear() {
		super.clear() ;
		item_code		=null;
		expiry_flag		=null;
		grn_count	=null;
		sal_count	=null;
		rtv_count	=null;
		srt_count	=null;
		iss_count	=null;
		adj_count	=null;
		urg_count	=null;
		tfr_count	=null;
		ret_count	=null;
		prt_count	=null;
		mfg_count	 =null;
		batch_reload=null;
		ALBatchChangedData.clear();
		ALData.clear();
		ALBatchData.clear();
}

	public ArrayList loadBatchData() throws Exception
	{
		String [] alParameters={getItem_code(),getLanguageId(),getLanguageId(),getLanguageId(),getLoginFacilityId()};
		ALBatchData=fetchRecords(getStRepositoryValue("SQL_ST_ITEM_BATCH_SELECT_MULTIPLE_FOR_CHANGE_EXPIRY"),alParameters);
		return ALBatchData;
	}
	
	public void updateBatchDetails(int i, String date)
	{
		HashMap	hmRecord	=(HashMap)	ALBatchData.get(i);
		hmRecord.put("NEW_EXP_REC_DT",date);
		ALBatchData.set(i,hmRecord	);
	}
	public void setAll( Hashtable recordSet)
	{
		check = new Hashtable(recordSet);
		setItem_code((String)recordSet.get("item_code"));
		setExpiry_yn((String)recordSet.get("expiry_yn"));
		batchCount = Integer.parseInt( (String)recordSet.get("batchCount") );
	}

	public HashMap modify() 
	{
		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
		HashMap	hmResult	=	new HashMap()	;
		ArrayList StItemUpdateData=new ArrayList();
		
		ArrayList alBatchInsertData=new ArrayList();
//		ArrayList alBatchInsertDataRows=new ArrayList();

		ArrayList alBatchUpdateData=new ArrayList();
//		ArrayList alBatchUpdateDataRows=new ArrayList();
		ArrayList alBatchDeleteData=new ArrayList();
//		ArrayList alBatchDeleteDataRows=new ArrayList();

		ArrayList alBatchControlUpdateData=new ArrayList();
		ArrayList alBatchControlInsertData=new ArrayList();//added for NMC-JD-SCF-0261
//		ArrayList alBatchControlUpdateDataRows=new ArrayList();

	//	ArrayList DuplicateRowExists=new ArrayList();
		HashMap hmRecord=new HashMap();
		ArrayList batchIdList = new ArrayList(); //NMC-JD-SCF-0261,AMRI-SCF-0673 start
		HashMap storeItemBatchMap = new HashMap(); 
		
		try {
			//st_item Update
			StItemUpdateData.add(getExpiry_yn());
			StItemUpdateData.add(getLoginById());
			StItemUpdateData.add(getLoginAtWsNo());
			StItemUpdateData.add(getLoginFacilityId());
			StItemUpdateData.add(getItem_code());
			// FROM HERE
			for(int i=0;i<ALBatchData.size();i++) 
			{
				double iQOH=0;
				hmRecord=(HashMap)ALBatchData.get(i);

				String [] value={(String)hmRecord.get("STORE_CODE"),(String)hmRecord.get("BATCH_ID"),(String)hmRecord.get("BIN_LOCATION_CODE"),(String)hmRecord.get("OLD_EXP_REC_DT")};
				String [] key={"STORE_CODE","BATCH_ID","BIN_LOCATION_CODE","NEW_EXP_REC_DT"} ;
				ArrayList alDuplicateList	=	DuplicateInArrayList(ALBatchData,key,value,i);

				iQOH=iQOH+Double.parseDouble((String)hmRecord.get("QTY_ON_HAND"));

				if(alDuplicateList.size()>0)
				{
					for (int j=0; j<alDuplicateList.size(); j++) {
						HashMap hmDeleteRecord=(HashMap)ALBatchData.get(Integer.parseInt((String)alDuplicateList.get(j)));
						iQOH=iQOH+Double.parseDouble((String)hmDeleteRecord.get("QTY_ON_HAND"));
						ArrayList alTemp=new ArrayList();
						alTemp.add((String)hmDeleteRecord.get("STORE_CODE"));
						alTemp.add(getItem_code());
						alTemp.add((String)hmDeleteRecord.get("BATCH_ID"));
						alTemp.add((String)hmDeleteRecord.get("BIN_LOCATION_CODE"));
						alTemp.add((String)hmDeleteRecord.get("OLD_EXP_REC_DT"));
						alBatchDeleteData.add(alTemp);
					}
					{//for delete for currect record
						ArrayList alTemp=new ArrayList();
						alTemp.add((String)hmRecord.get("STORE_CODE"));
						alTemp.add(getItem_code());
						alTemp.add((String)hmRecord.get("BATCH_ID"));
						alTemp.add((String)hmRecord.get("BIN_LOCATION_CODE"));
						alTemp.add((String)hmRecord.get("OLD_EXP_REC_DT"));
						alBatchDeleteData.add(alTemp);
					}
					ArrayList alTemp=new ArrayList();
					alTemp.add((String)hmRecord.get("STORE_CODE"));//store_code
					alTemp.add(getItem_code());//item_code
					alTemp.add((String)hmRecord.get("BATCH_ID"));//batch_id
					alTemp.add((String)hmRecord.get("BIN_LOCATION_CODE"));//batch_id
					alTemp.add((String)hmRecord.get("NEW_EXP_REC_DT"));//batch_id
					alTemp.add((String)hmRecord.get("TRADE_ID"));//batch_id
					alTemp.add(""+iQOH);//batch_id
					alTemp.add((String)hmRecord.get("REPLACE_ON_EXPIRY_YN"));//batch_id
					alTemp.add(getLoginById());
					alTemp.add(getLoginAtWsNo());
					alTemp.add(getLoginFacilityId());
					alTemp.add(getLoginById());
					alTemp.add(getLoginAtWsNo());
					alTemp.add(getLoginFacilityId());
					alBatchInsertData.add(alTemp);
					
					for (int k=alDuplicateList.size(); k>=0 ; k++) {
						ALBatchData.remove(k);
					}
					ALBatchData.remove(i);
				}
				else{
					{
					ArrayList alTemp=new ArrayList();
					alTemp.add((String)hmRecord.get("STORE_CODE"));
					alTemp.add(getItem_code());
					alTemp.add((String)hmRecord.get("BATCH_ID"));
					alTemp.add((String)hmRecord.get("BIN_LOCATION_CODE"));
					alTemp.add((String)hmRecord.get("OLD_EXP_REC_DT"));
					alBatchDeleteData.add(alTemp);
					}
					{				
					ArrayList alTemp=new ArrayList();
					//added for MNC-JD-SCF-0261 START
					
					ArrayList alBatchDetails = null;//NMC-JD-SCF-0261 
					ArrayList alBatchDetails2 = null;
					double val = 0; 
					//double dVal = 0; //COMMON-ICN-0118
					double tempVal = 0;
					System.out.println("storeItemBatchMap: "+storeItemBatchMap);  
					String key1=(String)hmRecord.get("STORE_CODE")+getItem_code()+(String)hmRecord.get("BATCH_ID")+(String)hmRecord.get("BIN_LOCATION_CODE")+(String)hmRecord.get("NEW_EXP_REC_DT")+(String)hmRecord.get("TRADE_ID"); 
					String value1=String.valueOf(iQOH);   
					if(storeItemBatchMap.containsKey(key1)){
						alBatchDetails =(ArrayList) storeItemBatchMap.get(key1);
						 System.out.println("alBatchDetails: "+alBatchDetails);  
						/* val = (String)alBatchDetails.get(6);
						 System.out.println("val: "+val);  
						 tempVal = Double.parseDouble(value1)+ Double.parseDouble(val); 
						 value1= String.valueOf(tempVal); 
						 iQOH = Double.parseDouble(value1);  */   
						 for(int m=0;m<alBatchDetails.size();m++){
							 alBatchDetails2 = (ArrayList)alBatchDetails.get(m);
							 System.out.println("alBatchDetails2: "+alBatchDetails2);  
							 if(alBatchDetails2.get(0).equals((String)hmRecord.get("STORE_CODE")) && alBatchDetails2.get(1).equals(getItem_code()) && alBatchDetails2.get(2).equals((String)hmRecord.get("BATCH_ID")) && alBatchDetails2.get(3).equals((String)hmRecord.get("BIN_LOCATION_CODE")) && alBatchDetails2.get(4).equals((String)hmRecord.get("NEW_EXP_REC_DT")) && alBatchDetails2.get(5).equals((String)hmRecord.get("TRADE_ID"))){
								 val = Double.parseDouble((String.valueOf(alBatchDetails2.get(6))));    
								 tempVal = Double.parseDouble(value1)+ (val); 
								 value1= String.valueOf(tempVal); 
								 iQOH = Double.parseDouble(value1);
								 alBatchDetails2.set(6,+iQOH); 
								 System.out.println("alBatchDetails2: "+alBatchDetails2);  
							 } 
						 }  
						// alBatchInsertData.set(6, +iQOH); 
						 System.out.println("alBatchDetails: "+alBatchDetails); 
						 System.out.println("alBatchInsertData: "+alBatchInsertData); 
						 
					}else{
						alTemp.add((String)hmRecord.get("STORE_CODE"));//store_code 
						alTemp.add(getItem_code());//item_code
						alTemp.add((String)hmRecord.get("BATCH_ID"));//batch_id
						alTemp.add((String)hmRecord.get("BIN_LOCATION_CODE"));//batch_id
						alTemp.add((String)hmRecord.get("NEW_EXP_REC_DT"));//batch_id
						alTemp.add((String)hmRecord.get("TRADE_ID"));//batch_id
						alTemp.add(""+iQOH);//batch_id
						alTemp.add((String)hmRecord.get("REPLACE_ON_EXPIRY_YN"));//batch_id
						alTemp.add(getLoginById());
						alTemp.add(getLoginAtWsNo()); 
						alTemp.add(getLoginFacilityId());
						alTemp.add(getLoginById());
						alTemp.add(getLoginAtWsNo());
						alTemp.add(getLoginFacilityId());
						alBatchInsertData.add(alTemp);
						System.out.println("alBatchInsertData: "+alBatchInsertData);  
					}
					storeItemBatchMap.put(key1, alBatchInsertData);     
					System.out.println("storeItemBatchMap: "+storeItemBatchMap);
					}
					{
					ArrayList alTemp=new ArrayList();
					ArrayList alTemp1=new ArrayList();//NMC-JD-SCF-0261
					alTemp.add((String)hmRecord.get("NEW_EXP_REC_DT"));
					alTemp.add(getLoginById());
					alTemp.add(getLoginAtWsNo() );
					alTemp.add(getLoginFacilityId() );
					alTemp.add(getItem_code());//item_code
					alTemp.add((String)hmRecord.get("BATCH_ID"));//batch_id
					alTemp.add((String)hmRecord.get("OLD_EXP_REC_DT"));//exp_date
					System.out.println("batchIdList: "+batchIdList); //NMC-JD-SCF-0261 START
					if(!batchIdList.contains((String)hmRecord.get("BATCH_ID"))){
						int count = getItemBatchCount(getItem_code(),(String)hmRecord.get("BATCH_ID"),(String)hmRecord.get("NEW_EXP_REC_DT"),getLoginFacilityId());  //NMC-JD-SCF-0261
						if(count==0){
							alTemp1.add(getItem_code()); 
							alTemp1.add((String)hmRecord.get("BATCH_ID")); 
							alTemp1.add((String)hmRecord.get("NEW_EXP_REC_DT")); 
							alTemp1.add((String)hmRecord.get("TRADE_ID")); 
							alTemp1.add("A"); //batch status.hardcoded as A - active
							alTemp1.add("0");   // discount percentage
							alTemp1.add(getLoginById());
							alTemp1.add(getLoginAtWsNo());
							alTemp1.add(getLoginFacilityId());
							alTemp1.add(getLoginById());
							alTemp1.add(getLoginAtWsNo());
							alTemp1.add(getLoginFacilityId());	  
							alTemp1.add("");//SALE PRICE
							alTemp1.add(""); //BARCODE ID
							alTemp1.add(""); //supp_code
							alTemp1.add(""); //pur_uom_code			
							alTemp1.add(""); //pur_uom_conv
							alTemp1.add("");//batch_cost  
							alBatchControlInsertData.add(alTemp1); 
						}else{
							//alBatchControlUpdateData.add(alTemp);
						}
						
						batchIdList.add((String)hmRecord.get("BATCH_ID")); 
					}//end  
					} 
				}//end else
			}//end for
// till here
			hmSQLMap.put("StItemUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_UPDATE_FOR_CHANGE_EXPIRY"));
			hmSQLMap.put("StBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE_FOR_CHANGE_EXPIRY"));
			hmSQLMap.put("StBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT_FOR_CHANGE_EXPIRY"));
			hmSQLMap.put("StBatchControlUpdateSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_UPDATE_FOR_CHANGE_EXPIRY"));
			hmSQLMap.put("SQL_ST_ITEM_UPDATE_BATCH_ID_FOR_CHANGE_EXPIRY", getStRepositoryValue("SQL_ST_ITEM_UPDATE_BATCH_ID_FOR_CHANGE_EXPIRY"));
			hmSQLMap.put("StBatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));//added for NMC-JD-SCF-0261
 
			hmTableData.put("properties",		getProperties());
			hmTableData.put("StItemUpdateData",	StItemUpdateData);
			hmTableData.put("alBatchInsertData",	alBatchInsertData);
			hmTableData.put("alBatchUpdateData",	alBatchUpdateData);
			hmTableData.put("alBatchDeleteData",	alBatchDeleteData);
			hmTableData.put("alBatchControlUpdateData",	alBatchControlUpdateData);					
			hmTableData.put("alBatchControlInsertData",	alBatchControlInsertData);	//NMC-JD-SCF-0261
			
			
			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, "Initial Message" ) ;

//				eST.ChangeExpiryFlag.ChangeExpiryFlagRemote changeExpiryFlagremote = null;

			/*	InitialContext initialcontext = new InitialContext();
				Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_CHANGE_EXPIRY_FLAG"));
				eST.ChangeExpiryFlag.ChangeExpiryFlagHome changeExpiryFlaghome = (eST.ChangeExpiryFlag.ChangeExpiryFlagHome)PortableRemoteObject.narrow(obj1, eST.ChangeExpiryFlag.ChangeExpiryFlagHome.class);
				changeExpiryFlagremote = changeExpiryFlaghome.create();
				hmResult = changeExpiryFlagremote.modify(hmTableData, hmSQLMap); */

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_CHANGE_EXPIRY_FLAG"),eST.ChangeExpiryFlag.ChangeExpiryFlagHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = hmTableData;
				argArray[1] = hmSQLMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = hmTableData.getClass(); ;
				paramArray[1] = hmSQLMap.getClass();

				 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	
				/*hmResult = new eST.ChangeExpiryFlag12.ChangeExpiryFlagManager().modify( hmTableData, hmSQLMap ) ;*/

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

	public ArrayList DuplicateInArrayList(ArrayList arrayList, String []stKeyFields, String []stValues, int exceptionalIndex){
		boolean result=false;
		ArrayList alDuplicateRecordIndex= new ArrayList();
		int j=0;
		for (int i=0;i<arrayList.size()&& (!result);i++) {
			if (exceptionalIndex == i) continue;
			result=true;
			for (j=0; j<stKeyFields.length ; j++ ) {
				if (! ((HashMap)arrayList.get(i)).get(stKeyFields[j]).toString().equals(stValues[j])) {
					result=false;
					break;
				}
			}
			if (result) {
				alDuplicateRecordIndex.add(""+i);
			}
		}
		return alDuplicateRecordIndex;
	}


	//code added on 3/12/2003
	public String getItemExpDetails()
	{
		String expiry_chk="";
		HashMap ExpDetail = new HashMap();	
		String [] alParameters={getItem_code()};
		try{
			//ExpDetail=fetchRecords(getStRepositoryValue("SQL_ST_ITEM_EXPIRY_DETAILS"),alParameters);
			ExpDetail = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_EXPIRY_DETAILS"),alParameters);
			
			expiry_chk=(String)ExpDetail.get("EXPIRY_YN" );
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return expiry_chk;
	}
	//NMC-JD-SCF-0261
	public int getItemBatchCount(String item_code, String batch_id, String exp_date, String facility_id)
	{
		int am_count= 0;
		String []stParameters1=	{item_code,batch_id,exp_date};
		try{
			am_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_BATCH_CONTROL WHERE ITEM_CODE = ? AND BATCH_ID = ? AND EXPIRY_DATE_OR_RECEIPT_DATE= TO_DATE(?,'dd/mm/yyyy')",stParameters1)).get("COUNT"));
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
			return am_count; 
	}
}
