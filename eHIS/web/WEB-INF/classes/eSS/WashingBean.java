/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;
import java.sql.* ;

import eSS.Common.SsAdapter;
import eSS.Washing.*;

public class WashingBean extends MasterCodeBean implements Serializable { 

	private String autoclave_wash_unit_code	=	"";
	private String washing_type	=	"";
	private String load_no	=	"";
	private String temperature	=	"";
	private String store_code	=	"";
	private String rof_doc_type_code	=	"";
	private String entry_completed_yn	=	"";
	private String serviceLocationDesc ="";
	private HashMap hmSsParameter=null;
	protected ArrayList result		= null;
	protected ArrayList DataList	= null;
	protected ArrayList DeleteDataList	= new ArrayList() ;


	private HttpSession session;

	public void setAutoclave_wash_unit_code(String autoclave_wash_unit_code) {
		 this.autoclave_wash_unit_code = autoclave_wash_unit_code.toUpperCase();
	}

	public String getAutoclave_wash_unit_code( ) {
		 return autoclave_wash_unit_code;
	}

	public void setWashing_type(String washing_type) {
		 this.washing_type = washing_type.toUpperCase();
	}

	public String getWashing_type( ) {
		 return washing_type;
	}

	public void setEntry_completed(String entry_completed_yn) {
		
		if (entry_completed_yn.equals(""))
		{
			entry_completed_yn="N";
		}
		 this.entry_completed_yn = entry_completed_yn;
	}

	public String getEntry_completed( ) {
		 return entry_completed_yn;
	}
	

	public void setTemperature(String temperature) {
		 this.temperature = temperature.toUpperCase();
	}

	public String getTemperature( ) {
		 return temperature;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code.toUpperCase();
	}
	//added by Pankaj

    public void setServiceLocationDesc(String serviceLocationDesc) {
		 this.serviceLocationDesc = serviceLocationDesc;
	}

    public String getServiceLocationDesc() {
		 return serviceLocationDesc ;
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}

	public void setRof_doc_type_code(String rof_doc_type_code) {
		 this.rof_doc_type_code =  rof_doc_type_code.toUpperCase();
	}

	public String getRof_doc_type_code() {
		 return rof_doc_type_code;
	}

	public void setLoad_no(String load_no) {
		 this.load_no =  load_no;
	}

	public String getLoad_no() {
		 return load_no;
	}

	public ArrayList getDataList(){
		return DataList;
	}

	public void setAll(Hashtable htResult) {
		setAutoclave_wash_unit_code((String)htResult.get("autoclave_wash_unit_code")) ;
		setWashing_type((String)htResult.get("washing_type")) ;
		setTemperature((String)htResult.get("temperature")) ;
		setEntry_completed((String)htResult.get("entry_completed_yn")) ;
		try{			
			this.loadDisplayResultPage();
		} catch(Exception e){
			e.printStackTrace() ;
		}
		
		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		try {
			getLoadNo();
		} catch ( Exception e )	{
			e.printStackTrace() ;
		} 
		}
	}

	public HashMap validate() {
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,TRUE);
		if (getMode().equals(getCommonRepositoryValue("MODE_DELETE"))) 
		{
			return hmReturn;
		}
		else
		{
		//try {  
		String selectedVal="";
			
				ArrayList validList=new ArrayList();
				 if (getMode().equals(getCommonRepositoryValue("MODE_INSERT"))) {
					validList= DataList ;
					selectedVal="N";
				 }
				 else {
		
					 validList= DeleteDataList;
					 selectedVal="N";
					 System.err.println("validList"+validList);
				 }

				HashMap hmRecord=new HashMap();

				int noOfRecordsToDelete=0;
				for(int i=0;i<validList.size();i++)
				{
					hmRecord	=	(HashMap)validList.get(i);
					
					if(checkForNull((String)hmRecord.get("SELECTED")).equals(selectedVal))
					{
						noOfRecordsToDelete++; 
					}
				}

				if((validList.size()==0)|| (noOfRecordsToDelete==validList.size()))
				{
					//throw new Exception("MIN_ONE_DETAIL_REQUIRED");
					hmReturn.put("result", new Boolean(false));
					hmReturn.put("msgid","MIN_ONE_DETAIL_REQUIRED");
					hmReturn.put("message",getMessage(getLanguageId(),(String) hmReturn.get("msgid"),"Common"));
				}
			//}
			/*catch (Exception exception) 
			{
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MSGID,exception.getMessage());
				hmReturn.put(MESSAGE,exception.toString());
				exception.printStackTrace();
			}*/
		}
		return hmReturn;
	}

	public void clear() {
		super.clear();
		autoclave_wash_unit_code	=	"";
		washing_type				=	"";
		load_no						=	"";
		temperature					=	"";
		store_code					=	"";
		rof_doc_type_code			=	"";
		session						=	null;
		hmSsParameter				=	null;
		serviceLocationDesc			=	"";
	}
	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}

	public void initStore_code() {
		setStore_code(checkForNull((String)hmSsParameter.get("DEF_STORE_CODE_FOR_PRE")) );
	}

	public void initDoc_type_code() {
		setRof_doc_type_code(checkForNull((String)hmSsParameter.get("DEF_ROF_DOC_TYPE_CODE")) );
	}

	public String getWashingUnit_List(){
	 //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	  ArrayList alParam = new  ArrayList ();
		alParam.add(getLanguageId());
		alParam.add(getLoginFacilityId()); 
		//return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_UNIT_CODE"),getLanguageId()), getAutoclave_wash_unit_code());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_UNIT_CODE"),alParam), getAutoclave_wash_unit_code());
	}
	
	public String getWashingType_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_TYPE_CODE"),getLanguageId()), getWashing_type());
	}

	public String getROFDocType_List(){
		java.util.ArrayList alParam = new java.util.ArrayList ();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());

		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_ROF_DOC_TYPE_QUERY"),alParam), getRof_doc_type_code());
	}
	
	public String getStoreCode_List(){
		java.util.ArrayList alParam = new java.util.ArrayList ();
		alParam.add(getLoginFacilityId());
		alParam.add(getLoginById());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_STORE"), alParam), getStore_code());
	}

	public void loadData() throws Exception {
		String []  alParameters={getLoginFacilityId(),rof_doc_type_code,store_code,washing_type};
		ArrayList listRecord =new ArrayList();
		try {
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_WASHING_ROF_DTLS"),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	public ArrayList loadResultPage() throws Exception {
		String []  alParameters={getLoginFacilityId(),autoclave_wash_unit_code,load_no,washing_type,getLanguageId()};
		ArrayList listRecord =new ArrayList();
		try {
		listRecord = fetchRecords("SELECT DISTINCT a.autoclave_wash_unit_code, b.short_desc washing_unit_desc, a.washing_type,                c.short_desc washing_type_desc, a.load_no, a.temperature, a.entry_completed_yn, b.service_location_code service_loc_code,                d.short_desc service_location_desc, rofhdr.store_code, mmvw.short_desc store_desc  FROM SS_WASHING_HDR a,                SS_AUTOCLAVE_WASH_UNIT b, SS_WASHING_TYPE c,SS_SERVICE_LOCATION d, SS_WASHING_DTL washdtl, SS_ROF_HDR rofhdr,                mm_store_lang_vw mmvw  WHERE a.autoclave_wash_unit_code = b.autoclave_wash_unit_code   AND a.entry_completed_yn = 'N'            AND a.washing_type = c.washing_type AND b.service_location_code = d.service_location_code AND a.added_facility_id = ?            AND NVL (a.autoclave_wash_unit_code, '%') LIKE NVL (?, '%')  AND a.load_no LIKE NVL (?, '%')  AND NVL (a.washing_type, '%') LIKE NVL (?, '%')  AND a.autoclave_wash_unit_code = washdtl.autoclave_wash_unit_code  AND a.load_no = washdtl.load_no            AND washdtl.rof_doc_type_code = rofhdr.doc_type_code  AND washdtl.rof_doc_no = rofhdr.doc_no  AND mmvw.store_code = rofhdr.store_code  AND mmvw.language_id = ?",alParameters);
			return listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	public ArrayList loadDisplayResultPage() throws Exception {
		String []  alParameters={getLoginFacilityId(),autoclave_wash_unit_code,washing_type,load_no};
		ArrayList listRecord =new ArrayList();
		try {
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_WASHING_DTL_RESULT"),alParameters);
			DeleteDataList=listRecord;
			return listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}


	public void getLoadNo()  {
		String   LoadNo ="";
		try {
			 LoadNo= fetchRecord(getSsRepositoryValue("SQL_SS_WASHING_LOAD_NO"),autoclave_wash_unit_code).get("NEXT_LOAD_NO").toString();
			 this.load_no= LoadNo;
		} catch ( Exception e )	{
			e.printStackTrace() ;
		} 
	}

	public String getWashUnitTemperature(String autoclave_wash_unit_code) throws Exception {
		String   Temperature ="";
		try {
			 Temperature= fetchRecord(getSsRepositoryValue("SQL_SS_WASHING_UNIT_TEMPERATURE"),autoclave_wash_unit_code).get("WASH_TEMPERATURE").toString();
			 if(Temperature.equals("0") )
				 Temperature="";
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		 return Temperature;
	}

	public void updateSelectedTrays(Hashtable htTrays, int start, int end, int totalRecords) {
	HashMap hmRecord=null;
	if(end>totalRecords)
		end=totalRecords;
			for (int idx = start; idx<end;idx++ ) {
				hmRecord	=	(HashMap)DataList.get(idx);
				hmRecord.put("SELECTED",(String) htTrays.get("SELECTED"+idx));
			}
	}

	public void updateUnselectedTrays(Hashtable htTrays, int start, int end, int totalRecords) {
	HashMap hmRecord=null;
	if(end>totalRecords)
		end=totalRecords;
			for (int idx = start; idx<end;idx++ ) {
				hmRecord	=	(HashMap)DeleteDataList.get(idx);
				hmRecord.put("SELECTED",(String) htTrays.get("SELECTED"+idx));
				DeleteDataList.set(idx,hmRecord);
			}
	}

	public HashMap insert() {
	    HashMap map = new HashMap() ;
		boolean data_change=false;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		
		try {
			map.put( "result", new Boolean( true ) ) ;
			
			ArrayList insertDataDtl = new ArrayList() ;
			ArrayList insertRowHeader = null ;
			ArrayList insertRowDtl = null ;
			ArrayList updateData = null ;
				
			insertRowHeader = new ArrayList() ;
			insertRowHeader.add(autoclave_wash_unit_code);
			insertRowHeader.add(washing_type);
			insertRowHeader.add(load_no);
			insertRowHeader.add(temperature);
			insertRowHeader.add(entry_completed_yn);
			insertRowHeader.add(login_by_id);
			insertRowHeader.add(login_at_ws_no);
			insertRowHeader.add(login_facility_id);
			insertRowHeader.add(login_by_id);
			insertRowHeader.add(login_at_ws_no);
			insertRowHeader.add(login_facility_id);
			
			updateData = new ArrayList() ;
				updateData.add(autoclave_wash_unit_code);

			for(int j=0;j<DataList.size();j++) {
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
		
				if(((String)hh.get("SELECTED")).equals("Y")){
					data_change=true;
					insertRowDtl = new ArrayList() ;
					
					insertRowDtl.add(autoclave_wash_unit_code);
					insertRowDtl.add(washing_type);
					insertRowDtl.add(load_no);
					insertRowDtl.add(login_facility_id);
					insertRowDtl.add((String)hh.get("DOC_TYPE_CODE"));
					insertRowDtl.add((String)hh.get("DOC_NO"));
					insertRowDtl.add((String)hh.get("GROUP_CODE"));
					insertRowDtl.add((String)hh.get("TRAY_NO"));
					insertRowDtl.add(login_by_id);
					insertRowDtl.add(login_at_ws_no);
					insertRowDtl.add(login_facility_id);
					insertRowDtl.add(login_by_id);
					insertRowDtl.add(login_at_ws_no);
					insertRowDtl.add(login_facility_id);
					insertDataDtl.add(insertRowDtl);
				}
			}
	
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertDataDtl",insertDataDtl);
			tabData.put( "InsertDataHdr",insertRowHeader);
			tabData.put( "UpdateData",updateData);
	
			sqlMap.put( "SQL_SS_WASHING_INSERT_HDR", getSsRepositoryValue("SQL_SS_WASHING_INSERT_HDR") );
			sqlMap.put( "SQL_SS_WASHING_INSERT_DTL", getSsRepositoryValue("SQL_SS_WASHING_INSERT_DTL") );
			sqlMap.put( "SQL_SS_WASHING_LOADNO_UPDATE", getSsRepositoryValue("SQL_SS_WASHING_LOADNO_UPDATE") );
			sqlMap.put( "SQL_SS_WASHING_ROF_UPDATE", getSsRepositoryValue("SQL_SS_WASHING_ROF_UPDATE") );
			

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_WASHING"),WashingHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();

			 HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			
			
				if( ((Boolean) result.get( "result" )).booleanValue() )
				{
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( true ) ) ;
					map.put("message", getMessage(getLanguageId(),(String) result.get("msgid"),"SS")) ;
				}
				else
				{
					
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", result.get("msgid") ) ;
				
				}
		
		}
		catch(Exception e) {
			map.put("flag",e.toString());
			e.printStackTrace() ;
		}
		finally {
				try {} 
				catch( Exception ee ){
					map.put( "message",ee.getMessage() ) ;
				}
		}
	  return map ;
   }

   public HashMap modify() {
		HashMap map = new HashMap() ;
		boolean data_change=false;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;

		
	try {
		ArrayList deleteDataDtl = new ArrayList() ;
		ArrayList updateDataHdrDtl = new ArrayList() ;
		ArrayList deleteDataRows= null ;

		updateDataHdrDtl.add(entry_completed_yn);
		updateDataHdrDtl.add(autoclave_wash_unit_code);
		updateDataHdrDtl.add(load_no);
		updateDataHdrDtl.add(login_by_id);
		updateDataHdrDtl.add(login_at_ws_no);
		updateDataHdrDtl.add(login_facility_id);
		for(int j=0;j<DeleteDataList.size();j++) {
			HashMap hh=new HashMap();
			hh=(HashMap) DeleteDataList.get(j);
					if(((String)hh.get("SELECTED")).equals("N")){
					data_change=true;
					deleteDataRows = new ArrayList() ;
					
					deleteDataRows.add(autoclave_wash_unit_code);
					deleteDataRows.add(load_no);
					deleteDataRows.add(login_facility_id);
					deleteDataRows.add((String)hh.get("DOC_TYPE_CODE"));
					deleteDataRows.add((String)hh.get("DOC_NO"));
					deleteDataRows.add((String)hh.get("GROUP_CODE"));
					deleteDataRows.add((String)hh.get("TRAY_NO"));
					deleteDataDtl.add(deleteDataRows);
				}
		}

		ArrayList updateData = new ArrayList() ;
				updateData.add(autoclave_wash_unit_code);


		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteDataDtl",deleteDataDtl);
		tabData.put( "UpdateDataHdrDtl",updateDataHdrDtl);
		tabData.put( "UpdateData",updateData);


		sqlMap.put( "SQL_SS_WASHING_DELETE_DTL", getSsRepositoryValue("SQL_SS_WASHING_DELETE_DTL") );
		sqlMap.put( "SQL_SS_WASHING_UPDATE_HDR", getSsRepositoryValue("SQL_SS_WASHING_UPDATE_HDR") );
		sqlMap.put( "SQL_SS_WASHING_UPDATE_DTL", getSsRepositoryValue("SQL_SS_WASHING_UPDATE_DTL") );
		sqlMap.put( "SQL_SS_WASHING_ROF_UPDATE", getSsRepositoryValue("SQL_SS_WASHING_ROF_UPDATE") );

		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_WASHING"),WashingHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();
			 HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


					
				if( ((Boolean) result.get( "result" )).booleanValue() )
				{
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( true ) ) ;
					map.put( "msgid",  result.get( "msgid" ) ) ;

					map.put("message", getMessage(getLanguageId(),(String) result.get("msgid"),"SS")) ;
				}
				else
				{
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", result.get("msgid") ) ;
				}
		}
		catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} 
	  return map ;
	}
	
	public HashMap delete(){
		HashMap map = new HashMap() ;
		boolean data_change=false;
		//String debug = "From EJB : ";
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;
	
	try {
		ArrayList deleteDataDtl = new ArrayList() ;
		ArrayList deleteDataHdr = new ArrayList() ;
		ArrayList deleteDataRows= null ;

		deleteDataHdr.add(autoclave_wash_unit_code);
		deleteDataHdr.add(load_no);
		for(int j=0;j<DeleteDataList.size();j++) {
			HashMap hh=new HashMap();
			hh=(HashMap) DeleteDataList.get(j);
					
					data_change=true;
					deleteDataRows = new ArrayList() ;
					deleteDataRows.add((String)hh.get("AUTOCLAVE_WASH_UNIT_CODE"));
					deleteDataRows.add((String)hh.get("LOAD_NO"));
					deleteDataRows.add(login_facility_id);
					deleteDataRows.add((String)hh.get("DOC_TYPE_CODE"));
					deleteDataRows.add((String)hh.get("DOC_NO"));
					deleteDataRows.add((String)hh.get("GROUP_CODE"));
					deleteDataRows.add((String)hh.get("TRAY_NO"));
					deleteDataDtl.add(deleteDataRows);
		}
		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteDataDtl",deleteDataDtl);
		tabData.put( "DeleteDataHdr",deleteDataHdr);

		sqlMap.put( "SQL_SS_WASHING_DELETE_DTL", getSsRepositoryValue("SQL_SS_WASHING_DELETE_DTL") );
		sqlMap.put( "SQL_SS_WASHING_DELETE_HDR", getSsRepositoryValue("SQL_SS_WASHING_DELETE_HDR") );

	
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_WASHING"),WashingHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();

			 HashMap result = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		
				if( ((Boolean) result.get( "result" )).booleanValue() )
				{
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( true ) ) ;
					map.put("message", getMessage(getLanguageId(),(String) result.get("msgid"),"SS")) ;
				}
				else
				{
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", result.get("msgid") ) ;
				}

		}
		catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} 
			
		return map ;
	 }
  }
