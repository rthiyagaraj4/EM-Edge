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

import javax.servlet.http.HttpSession;
import java.sql.* ;

import eSS.Common.*;
import eSS.Dispatch.*;

public class DispatchBean extends eSS.Common.SsTransaction implements Serializable { 

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
	private String group_desc="";
	protected ArrayList result		= null;
	protected ArrayList DataList	= null;
	protected ArrayList DtlDataList	= null;
	
	
	//Added by Sakti against BRU-HIMS-CRF-371
	private   ArrayList alCheckedItems;
	private HashMap hmgroupRecords		= new HashMap();
	private ArrayList alDtlItems;
	private ArrayList alItems;
	private ArrayList alDtlnewItems;
	//Added ends

	private HttpSession session;
	
	public DispatchBean() {
		alCheckedItems = new ArrayList();
		alDtlItems = new ArrayList();
		alDtlnewItems = new ArrayList();
		DtlDataList = new ArrayList();
		
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
		
		//Comented by Sakti against BRU-HIMS-CRF-371
		/*setRecords_to_modify((String)htResult.get("records_to_modify")) ;
		setRof_doc_type_code((String)htResult.get("rof_doc_type_code"));
		setRof_doc_no((String)htResult.get("rof_doc_no"));*/

		updateSelectedValues(htResult);//Added by Sakti against BRU-HIMS-CRF-371
	}

	public HashMap validate() {
		
		HashMap hmReturn		=	new HashMap();
		//hmReturn.put("result",TRUE);
		hmReturn.put("result", new Boolean(true));
		//Added against inc#43640
		if(alCheckedItems.size() == 0 ) {
			hmReturn.put("result", new Boolean(false));
			hmReturn.put("msgid","MIN_ONE_DETAIL_REQUIRED");
			hmReturn.put("message",getMessage(getLanguageId(),(String) hmReturn.get("msgid"),"Common"));
		}
		System.out.println("hmReturn"+hmReturn);
		return hmReturn;
	}
	
//Added by Sakti Sankar against CRF-371
	public ArrayList getCheckItems(){
		return alCheckedItems;
	    }
	
	public ArrayList getAlItems() {
		return this.alItems;
	}
	
	public void  setAlItems(ArrayList alItems ) {
		 this.alItems = alItems;
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
	
	
	
	public String getalGroupRecords(String doc_no){
		if(hmgroupRecords.containsKey(doc_no))
			return (String)this.hmgroupRecords.get(doc_no);
		else
			return new String();
	}
	public void setalGroupRecords(String doc_no,String dispatch_daate){
	
		hmgroupRecords.put(doc_no,dispatch_daate);
		alDtlItems.add(doc_no);
		
	}
	public HashMap getalGroupRecords(){
		return hmgroupRecords;
	}
	
	public void setnewalGroupRecords(String doc_no_value){
		
		alDtlnewItems.add(doc_no_value);
	}
	
	public ArrayList getnewalGroupRecords(){
		return alDtlItems;
	 }
	
	public ArrayList getnewcheckedalGroupRecords(){
		return alDtlnewItems;
	 }
	
	public void removenewalGroupRecords(String doc_no_value){
		 alDtlItems.remove(doc_no_value);
		 hmgroupRecords.remove(doc_no_value);
	 }
	
//Added ends
	
	
	
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
		alCheckedItems = null;
		alItems = null;
		hmgroupRecords = new HashMap();//Added by Sakti against BRU-HIMS-CRF-371
		DtlDataList = null;
	}
	//Added by Sakti against BRU-HIMS-CRF-371
	public void initialize() {
		super.initialize();
		
		doc_ref = "";
		doc_date = "";
		alItems = new ArrayList();
		alCheckedItems = new ArrayList();
		alDtlItems = new ArrayList();
		alDtlnewItems = new ArrayList();
		DtlDataList = new ArrayList();;
		
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
		
		String []  alParameters={getLoginFacilityId(),rof_doc_type_code ,rof_doc_no,doc_date,location,store_code,doc_ref,getLoginById()};
		
		ArrayList listRecord =new ArrayList();
		try {
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_DISPATCH_SEARCH_QUERY"),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	
	public ArrayList loadResultPage(String rof_doc_type_code,String doc_no) throws Exception {
		String []  alParameters={rof_doc_type_code,doc_no};
		
		ArrayList listRecord =new ArrayList();
		try {
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_DISPATCH_ROF_DTL"),alParameters);
			
			return listRecord;
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} 
	}
	
	
	//Added by Sakti against BRU-HIMS-CRF-371
	
	/*public void loadListPage(String rof_doc_type_code,String doc_no,String facility_id) {
		
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		DispatchListBean listBean; 
		alItems = new ArrayList ();
		try {
            connection = getConnection();
             
		   pstmt = connection.prepareStatement(getSsRepositoryValue("SQL_SS_DISPATCH_ROF_DTL"));

		   	pstmt.setString(1, facility_id); 
            pstmt.setString(2, rof_doc_type_code);
            pstmt.setString(3, doc_no);
			resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
	        	listBean = new DispatchListBean(resultSet);  
				alItems.add(listBean); 
				
				hmgroupRecords.put(rof_doc_type_code+"~"+doc_no,alItems);
			}	   
        } 
		catch (Exception e) {
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
	}*/
	
	

	public ArrayList loadListPage(String rof_doc_type_code,String doc_no,String facility_id)  {
		
		ArrayList alParameters = new ArrayList();
		ArrayList listRecord =new ArrayList();
		
		try {
			alParameters.add(facility_id);
			alParameters.add(rof_doc_type_code);
			alParameters.add(doc_no);
			listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_DISPATCH_ROF_DTL"),alParameters);
			
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			
		}
		return listRecord;
	} 
	
	//Added ends

	public HashMap modify() {
		
		
		HashMap hmResult	=	new HashMap();
		HashMap	hmTableData			=	new HashMap()	;
		//ArrayList alHdrModifyData	=	new ArrayList()	; //Comented by sakti as this is unused against inc#48061
		ArrayList dtlupd			= new ArrayList();	 
		HashMap	hmSQLMap			=	new HashMap()	;
		String key					= null;
		String dtl_key				= null;
		ArrayList  alDtlModifyData  = new ArrayList();
		
		double rof_cost				= 0;
		String dispatch_date		= "";
		
		String packing_cost			= "";
		String sterile_cost			= "";
		String consumable_cost		= "";
		String groupCode			= "";
		String trayNo				= "";
		String docTypeCode			= "";
		String docNoValue			= "";
		
		
		String docType				= "";
		String docNo				= "";
		String tray_no				= "";
		String group_code			= "";
		String disp_date			= "";
		StringTokenizer st;
		StringTokenizer ss;
		
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet		    = null;
        HashMap hmRecord			=	null;
        try {
			connection = getConnection();
			
			
			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;
			Properties properties = getProperties();
			hmTableData.put("properties",properties);
		
       
			//Added by Sakti Sankar against CRF-371	
			
		
if(alCheckedItems.size() > 0){
			
			for (int i=0;i<alCheckedItems.size(); i++) 
			{
								
				key = (String) alCheckedItems.get(i);
				
				if (key == null || key.trim() == "") 
				  continue;
				
				 st = new StringTokenizer(key,"-"); 
				 docTypeCode = st.nextToken().trim();
				 docNoValue = st.nextToken();
				
							
				if(  alDtlnewItems.contains(docTypeCode+"-"+docNoValue)) {
				
						for (int j=0;j<alDtlItems.size(); j++) 	{
						dtl_key = (String) alDtlItems.get(j);
												
						 ss = new StringTokenizer(dtl_key,"-");
						 docType = ss.nextToken().trim();
						 docNo = ss.nextToken();
						 tray_no = ss.nextToken();
						 group_code = ss.nextToken();
						
						String []parameters = {login_facility_id,docType,docNo,tray_no,group_code};
						
						hmRecord = 	(HashMap)fetchRecord("SELECT ss_get_sterile_cost(b.group_code, sterile_type) sterile_cost, ss_get_group_unit_cost( b.group_code, 4) packing_cost, ss_get_group_unit_cost( b.group_code, 4) consumable_cost FROM  ss_rof_hdr a,ss_rof_dtl b where a.facility_id= ? and a.doc_type_code= ? and a.doc_no= ? and b.tray_no = ? and b.group_code = ? and a.facility_id=b.facility_id AND a.doc_type_code=b.doc_type_code AND a.doc_no=b.doc_no",parameters);
						packing_cost = (String)hmRecord.get("PACKING_COST");
						sterile_cost = (String)hmRecord.get("STERILE_COST");
						consumable_cost  = (String)hmRecord.get("CONSUMABLE_COST");
						
						rof_cost = Double.parseDouble(packing_cost)+Double.parseDouble(sterile_cost)+Double.parseDouble(consumable_cost);
						
											
						if(  docType.equals(docTypeCode) && docNo.equals(docNoValue) ){ 
							
									if( ( hmgroupRecords.get(dtl_key) != null ) &&  (hmgroupRecords.get(dtl_key) != "")){
										dispatch_date = ((Object)hmgroupRecords.get(dtl_key)).toString();
															
									}
																		
									dtlupd = new ArrayList();	
									
									
									dtlupd.add(dispatch_date);						
									dtlupd.add(login_by_id);
									dtlupd.add(login_at_ws_no);
									dtlupd.add(login_facility_id);
									
									dtlupd.add(Double.parseDouble(packing_cost));
									dtlupd.add(Double.parseDouble(sterile_cost));
									dtlupd.add(Double.parseDouble(consumable_cost));
									dtlupd.add(rof_cost);
									dtlupd.add(login_by_id);
									
									dtlupd.add(docType);
									dtlupd.add(docNo);
									dtlupd.add(group_code);
									dtlupd.add(tray_no);
									
									alDtlModifyData.add(dtlupd);
					
						}
					
					}
					
				}
				else{
                		
					pstmt = connection.prepareStatement(getSsRepositoryValue("SQL_SS_DISPATCH_ROF_DTL"));
					
	                pstmt.setString(1, login_facility_id);
	                pstmt.setString(2, docTypeCode);
	                pstmt.setString(3, docNoValue);
	               
	                
					 resultSet = pstmt.executeQuery();
	                 while (resultSet != null && resultSet.next()) {
					     disp_date = resultSet.getString("DISPATCH_DATE");
						 packing_cost = resultSet.getString("PACKING_COST");
						 sterile_cost = resultSet.getString("STERILE_COST"); 
						 consumable_cost = resultSet.getString("CONSUMABLE_COST");
						 groupCode = resultSet.getString("GROUP_CODE");
						 trayNo = resultSet.getString("TRAY_NO"); 
						
						 rof_cost = Double.parseDouble(packing_cost)+Double.parseDouble(sterile_cost)+Double.parseDouble(consumable_cost);
					 
					dtlupd = new ArrayList();	
					
					
						dtlupd.add(disp_date);						
						dtlupd.add(login_by_id);
						dtlupd.add(login_at_ws_no);
						dtlupd.add(login_facility_id);
						
						dtlupd.add(Double.parseDouble(packing_cost));
						dtlupd.add(Double.parseDouble(sterile_cost));
						dtlupd.add(Double.parseDouble(consumable_cost));
						dtlupd.add(rof_cost);
						dtlupd.add(login_by_id);
						
						dtlupd.add(docTypeCode);
						dtlupd.add(docNoValue);
						dtlupd.add(groupCode);
						dtlupd.add(trayNo);
					
						alDtlModifyData.add(dtlupd);
					
				}	

			}
		
				
	}//Added ends
}
		
		//StringTokenizer stRecordsToModify	=	new StringTokenizer(getRecords_to_modify(),",");


		/*alHdrModifyData.add(getLoginById()		);      
		alHdrModifyData.add(getLoginAtWsNo()	);    
		alHdrModifyData.add(getLoginFacilityId());

		
		alHdrModifyData.add(getRof_doc_type_code()  );
		alHdrModifyData.add(getRof_doc_no());

		alDispatchList	=	(ArrayList)session.getAttribute("dispatchList");

		alDtlModifyData		=	new ArrayList()	;
		for (int i=0;i<alDispatchList.size() ;i++ ) {
			
			HashMap hmRecord	=	(HashMap)alDispatchList.get(i);
			//if(stRecordsToModify.nextToken().equals("Y")){
				
				alDtlModifyData.add(hmRecord);		
			//}
			
		}*/
		
		
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_DISPATCH_ROF_UPDATE_DTL")		);

		hmTableData.put( "properties",			getProperties() );
		//hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		//hmTableData.put( "DtlModifyData",		alDtlModifyData	);
		
		hmTableData.put( "alDtlModifyData",		alDtlModifyData	);
		
		
		//return dipatchingMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_DISPATCH"),DispatchHome.class,getLocalEJB());
		
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

		try{
		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_DISPATCH"),DispatchHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		}
		catch (Exception e){}

		if( ((Boolean) hmResult.get("result")).booleanValue() )	
					hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

		else if( hmResult.get("msgid")!=null  )
		hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
		else
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

		return hmResult;
	}
} 
