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
import java.sql.ResultSet; 

//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpSession;
import java.sql.* ;

import eSS.Common.SsAdapter;
import eSS.Common.SsRepository;
import eSS.Dispatch.DispatchHome;
import eSS.Acknowledgement.*;
import eSS.Common.*;


public class ReceiptBean extends eSS.Common.SsTransaction implements Serializable { 

	private String rof_doc_type_code	=	""; 
	private String rof_doc_no	=	"";
	private String doc_date	=	"";
	private String washing_yn	=	"";
	private String store_code	=	"";
	private String packing_yn	=	"";
	private String sterilize_yn	=	"";
	private String doc_ref	=	"";
	private String location	=	"";
	private String records_to_modify	=	"";
	private String group_desc = "";
	protected ArrayList result		= null;
	protected ArrayList DataList	= null;
	
	//Added against BRU-HIMS-CRF-372
	private 	ArrayList DtlDataList	= null;
	//private     ArrayList alItems;
	private     ArrayList alCheckedItems;
	private 	HashMap hmgroupRecords		= new HashMap();
	private 	ArrayList alDtlnewTrays;
	private 	ArrayList alDtlTrays;

	private HttpSession session;

	public ReceiptBean() {
		alCheckedItems = new ArrayList();
		DtlDataList = new ArrayList();
		alDtlnewTrays = new ArrayList();
		alDtlTrays = new ArrayList();
	}

	public void setRof_doc_type_code(String rof_doc_type_code) {
		 this.rof_doc_type_code = rof_doc_type_code.toUpperCase();
	}

	public String getRof_doc_type_code( ) {
		 return rof_doc_type_code;
	}

	public void setRof_doc_no(String rof_doc_no) {
		 this.rof_doc_no = rof_doc_no;
	}

	public String getRof_doc_no( ) {
		 return rof_doc_no;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation( ) {
		 return location;
	}

	
	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date( ) {
		 return doc_date;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code.toUpperCase();
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

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref =  doc_ref;
	}

	public String getDoc_ref() {
		 return doc_ref;
	}
	
	public void setRecords_to_modify(String records_to_modify) {
		 this.records_to_modify =  records_to_modify;
	}

	public String getRecords_to_modify() {
		 return records_to_modify;
	}

	
	public ArrayList getDataList(){ 
		return DataList;
	}
	public ArrayList getDtlDataList(){ 
		return DtlDataList;
	}

	public void setAll(Hashtable htResult) {
		/*setRecords_to_modify((String)htResult.get("records_to_modify")) ;
		setRof_doc_type_code((String)htResult.get("rof_doc_type_code"));
		setRof_doc_no((String)htResult.get("rof_doc_no"));*/
		
		updateSelectedValues(htResult);
	}

	public HashMap validate() {
		HashMap hmReturn		=	new HashMap();
//		ArrayList alAlternateGroupList	=	new ArrayList();
		//hmReturn.put("result",TRUE);
		hmReturn.put("result", new Boolean(true));
		//Added against inc#43640
		if(alCheckedItems.size() == 0 ) {
			hmReturn.put("result", new Boolean(false));
			hmReturn.put("msgid","MIN_ONE_DETAIL_REQUIRED");
			hmReturn.put("message",getMessage(getLanguageId(),(String) hmReturn.get("msgid"),"Common"));
		}
		return hmReturn;
	}

	public void clear() {
		super.clear();
		rof_doc_type_code	=	"";
		rof_doc_no	=	"";
		doc_date	=	"";
		washing_yn	=	"";
		store_code	=	"";
		packing_yn	=	"";
		sterilize_yn	=	"";
		doc_ref	=	"";
		group_desc="";
		session				=	null;
		DtlDataList = null;
		hmgroupRecords = new HashMap();
		alCheckedItems = null;
	}
	//Added by sakti against BRU-HIMS-CRF-372
	public void initialize() {
		super.initialize();
		DtlDataList = new ArrayList();
		alCheckedItems = new ArrayList();
		alDtlTrays = new ArrayList();
		alDtlnewTrays = new ArrayList();
	}
//Added ends
	public void RofDocTypeServicelocation() throws Exception {
		String service_location="";
		String rof_doc_no="";
		try {
			HashMap hmRecord=fetchRecord(getSsRepositoryValue("SQL_SS_DISPATCH_DEFLT_PARAM"),getLoginFacilityId());
			service_location = checkForNull((String)hmRecord.get("DEF_SERVICE_LOCATION_CODE"));
			setLocation(service_location); 
			rof_doc_no = checkForNull((String)hmRecord.get("DEF_ROF_DOC_TYPE_CODE"));
			setRof_doc_type_code(rof_doc_no);  
			setStore_code(checkForNull((String)hmRecord.get("DEF_STORE_CODE_FOR_PRE")));
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
	
	public String getROFDocType_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_DISPATCH_ROF_DOC_TYPE_LIST"),alParam), getRof_doc_type_code());
	}
		
	public String getLocation_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());//added by sakti ML_BRU_SCF_0286 -SS-Sl-3 - Inc#33742
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_DISPATCH_SERVICE_LOCATION_LIST"),alParam), getLocation());
	}
	
	public String getStoreCode_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_DISPATCH_STORE_LIST"),alParam), getStore_code());
	}

	public void loadData() throws Exception {

		//if(doc_date.equals(null) || doc_date.equals(""))
		//	doc_date="%";
		
		String []  alParameters={getLoginFacilityId(),rof_doc_type_code ,rof_doc_no,getDoc_date(),location,store_code,doc_ref,login_by_id};
		
		ArrayList listRecord =new ArrayList();
		try {
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_RECEIPT_SEARCH_QUERY"),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	/*public void loadResultPage(String rof_doc_type_code,String doc_no)  {
		String []  alParameters={rof_doc_type_code,doc_no};
		ArrayList listRecord =new ArrayList();
		try {
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_RECEIPT_ROF_DTL"),alParameters);
			//return listRecord;
			DtlDataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			
		} 
	}*/
	//Added against BRU-HIMS-CRF-372
	public ArrayList loadListPage(String rof_doc_type_code,String doc_no,String facility_id)  {
		
		ArrayList alParameters = new ArrayList();
		ArrayList listRecord =new ArrayList();
		
		try {
			alParameters.add(facility_id);
			alParameters.add(rof_doc_type_code);
			alParameters.add(doc_no);
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_RECEIPT_ROF_DTL"),alParameters);
			
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			
		}
		return listRecord;
	} 

	public void updateSelectedValues(Hashtable selectedValues) {
		
		int total = Integer.parseInt((String)selectedValues.get("total_check_boxes"));
		
		String checkedIndices = (String)selectedValues.get("checkedIndices");
		String key = null;
		ArrayList alRemoveKey = new ArrayList (total);
		
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)selectedValues.get("checkbox"+i));
		}
		
		alCheckedItems.removeAll(alRemoveKey);
		alRemoveKey = null;
		StringTokenizer checked = new  StringTokenizer(checkedIndices,",");
		ArrayList alAddKey  = new ArrayList ();
		while (checked.hasMoreElements()) {
			key = (String)checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) selectedValues.get("checkbox"+key.trim()));
			}
		}
		alCheckedItems.addAll(alAddKey);
	}
	
	public ArrayList getCheckItems(){
		return alCheckedItems;
	    }
	
	public String getalGroupRecords(String doc_no){
		if(hmgroupRecords.containsKey(doc_no))
			return (String)this.hmgroupRecords.get(doc_no);
		else
			return new String();
	}
	public void setalGroupRecords(String doc_no,String receipt_date){
	
		hmgroupRecords.put(doc_no,receipt_date);
		alDtlTrays.add(doc_no);
		
	}
	public HashMap getalGroupRecords(){
		return hmgroupRecords;
	}
	
	public void setnewalGroupRecords(String doc_no_value){
		
		alDtlnewTrays.add(doc_no_value);
	}
	
	public ArrayList getnewalGroupRecords(){
		return alDtlTrays;
	 }
	
	public ArrayList getnewcheckedalGroupRecords(){
		return alDtlnewTrays;
	 }
	
	public void removenewalGroupRecords(String doc_no_value){
		alDtlTrays.remove(doc_no_value);
		 hmgroupRecords.remove(doc_no_value);
	 }
	//Added ends

	public HashMap modify() { 
		HashMap		hmTableData			=	new HashMap()	;
		//ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=   new ArrayList();
		//ArrayList	alDispatchList		=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		HashMap 	hmResult			=	new HashMap();
		
		String key = null; 
		String dtl_key = null;
		ArrayList dtlupd = new ArrayList();	
		
		//double rof_cost = 0;
		String receipt_date = "";
		
		//String packing_cost = "";
		//String sterile_cost = "";
		//String consumable_cost = "";
		String groupCode = "";
		String trayNo = "";
		String docTypeCode = "";
		String docNoValue = "";
		
		
		String docType = "";
		String docNo = "";
		String tray_no = "";
		String group_code = "";
		String receiptdate = "";
		StringTokenizer st;
		StringTokenizer ss;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
        ResultSet resultSet = null;
       // HashMap hmRecord	=	null;
        
		
		try {
			connection = getConnection();
			
			
			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;
			Properties properties = getProperties();
			hmTableData.put("properties",properties);
			
		//Added against BRU-HIMS-CRF-372
		
			if(alCheckedItems.size() > 0) {
				
				for (int i=0;i<alCheckedItems.size(); i++) 
				{
									
					key = (String) alCheckedItems.get(i);
					if (key == null || key.trim() == "") 
					  continue;
					
					 st = new StringTokenizer(key,"-"); 
					 docTypeCode = st.nextToken().trim();
					 docNoValue = st.nextToken();
					
					if(  alDtlnewTrays.contains(docTypeCode+"-"+docNoValue)) {
					
							for (int j=0;j<alDtlTrays.size(); j++) 	{
							dtl_key = (String) alDtlTrays.get(j);
													
							 ss = new StringTokenizer(dtl_key,"-");
							 docType = ss.nextToken().trim();
							 docNo = ss.nextToken();
							 tray_no = ss.nextToken();
							 group_code = ss.nextToken();
										
							
							if(  docType.equals(docTypeCode) && docNo.equals(docNoValue) ){ 
								
										if( ( hmgroupRecords.get(dtl_key) != null ) &&  (hmgroupRecords.get(dtl_key) != "")){
											receipt_date = (String)hmgroupRecords.get(dtl_key);
											
										}
																			
										dtlupd = new ArrayList();	
																			
										dtlupd.add(receipt_date);						
										dtlupd.add(login_by_id);
										dtlupd.add(login_by_id);
										dtlupd.add(login_at_ws_no);
										dtlupd.add(login_facility_id);
										
										dtlupd.add(docType);
										dtlupd.add(docNo);
										dtlupd.add(group_code);
										dtlupd.add(tray_no);
										
										alDtlModifyData.add(dtlupd);
						
							}
						
						}
						
					}
					else{
	                		
												 
						pstmt = connection.prepareStatement(getSsRepositoryValue("SQL_SS_RECEIPT_ROF_DTL"));
						
		                pstmt.setString(1, login_facility_id);
		                pstmt.setString(2, docTypeCode);
		                pstmt.setString(3, docNoValue);
		                
		                
						 resultSet = pstmt.executeQuery();
		                 while (resultSet != null && resultSet.next()) {
		                	 receiptdate = resultSet.getString("RECEIPTDATE");
							 groupCode = resultSet.getString("GROUP_CODE");
							 trayNo = resultSet.getString("TRAY_NO"); 
							
							 
							 dtlupd = new ArrayList();	
												
							dtlupd.add(receiptdate);						
							dtlupd.add(login_by_id);
							dtlupd.add(login_by_id);
							dtlupd.add(login_at_ws_no);
							dtlupd.add(login_facility_id);
																							
							dtlupd.add(docTypeCode);
							dtlupd.add(docNoValue);
							dtlupd.add(groupCode);
							dtlupd.add(trayNo);
							
							alDtlModifyData.add(dtlupd);
						
						}
						
					}	

				}
			
					
		}//Added ends
	
		
		/*StringTokenizer stRecordsToModify	=	new StringTokenizer(getRecords_to_modify(),",");
		System.out.println("stRecordsToModify"+stRecordsToModify);
		alHdrModifyData.add(getLoginById()		);      
		alHdrModifyData.add(getLoginAtWsNo()	);    
		alHdrModifyData.add(getLoginFacilityId());
		alHdrModifyData.add(getRof_doc_type_code()  );
		alHdrModifyData.add(getRof_doc_no());
		alDispatchList	=	(ArrayList)session.getAttribute("dispatchList");

		alDtlModifyData		=	new ArrayList()	;
		for (int i=0;i<alCheckedItems.size(); i++){
			for (int j=0;j<alDispatchList.size() ;j++ ) {
			
			HashMap hmRecord	=	(HashMap)alDispatchList.get(j);
			//if(stRecordsToModify.nextToken().equals("Y")){
				//continue;
				alDtlModifyData.add(hmRecord);		
			//}
			
		}
	}*/
			
		/*hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_RECEIPT_ROF_UPDATE_DTL")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);
		return dipatchingMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);*/
		
		
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_RECEIPT_ROF_UPDATE_DTL")		);

		hmTableData.put( "properties",			getProperties() );
		
		hmTableData.put( "alDtlModifyData",		alDtlModifyData	);
	
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_ACKNOWLEDGEMENT"),DispatchHome.class,getLocalEJB());
		
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); ;
		paramArray[1] = hmSQLMap.getClass();
		hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		hmResult.put("message",getMessage(getLanguageId(),(String) hmResult.get( "message" ),"SS") ) ;
		
        } catch (Exception e) {
			
			e.printStackTrace();
		}
        finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
        }
        
              
		return hmResult;
	}

	public HashMap dipatchingMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;
		//AcknowledgementHome   home=null;
	//	AcknowledgementRemote remote=null;
try{
		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup(getSsRepositoryValue("JNDI_SS_ACKNOWLEDGEMENT") ) ;

		home  = (AcknowledgementHome) PortableRemoteObject.narrow( object, AcknowledgementHome.class ) ;
		remote = home.create() ;
		hmResult = remote.modify( hmTableData, hmSQLMap ) ;*/


		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( getSsRepositoryValue("JNDI_SS_ACKNOWLEDGEMENT"),AcknowledgementHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
}catch(Exception e)	{}
	
		if( ((Boolean) hmResult.get("result")).booleanValue() )	
		//	hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

		else if( hmResult.get("msgid")!=null  )
		//	hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

		else
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

		return hmResult;
	}
}  
