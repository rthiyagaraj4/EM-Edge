/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class StorageLocationForDispLocnBean extends PhAdapter implements Serializable {

	protected Hashtable hashMultiple;
	protected String disp_locn_code		="";
	protected String disp_locn_desc		="";
	protected String storage_bin_code	="";
	protected String storage_locn_desc	="";
	protected String eff_status			="";
	protected String allow_to_change	="";
	protected String locale		="";
	protected String debug		    = "";

	public StorageLocationForDispLocnBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success..." ) ;
		return map;
	}

	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

    public String getDispLocnCode(){
			
		return this.disp_locn_code;
	
	}
	public String getDispLocnDesc(){
		return this.disp_locn_desc;
	}
	public String getStorageBinCode(){
		return this.storage_bin_code;	
	}

	public String allowToChange(){
		return this.allow_to_change;
	}

	
   public String getStorageLocnDesc(){
		return this.storage_locn_desc;
	}

	public String getEffStatus(){
		return this.eff_status;
	}
	public String getLoggedInFacility() {
		return login_facility_id;
	}

	public void setLanguageId(String locale){
		this.locale=locale;
	}

    public String getLanguageId(){
		return this.locale;
	}

	public void setAll(Hashtable recordSetMultiple){
		this.mode =(String)recordSetMultiple.get("mode");		
		if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){ 	
			hashMultiple = recordSetMultiple ;
		}
		else if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
			if(recordSetMultiple.containsKey("disp_locn_code"))
				disp_locn_code = (String)recordSetMultiple.get("disp_locn_code") ;
			if(recordSetMultiple.containsKey("storage_bin_code"))
				storage_bin_code = (String)recordSetMultiple.get("storage_bin_code") ;
			if(recordSetMultiple.containsKey("storage_locn_desc"))
				storage_locn_desc = (String)recordSetMultiple.get("storage_locn_desc") ;
			if(recordSetMultiple.containsKey("eff_status")){
				eff_status = (String)recordSetMultiple.get("eff_status") ;
				if (eff_status == null || eff_status.equals("")){
					eff_status = "D";
				}
				else{
					eff_status = "E";
				}
			}            
		}
	} 

	public HashMap insert() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		HashMap sqlMap = new HashMap() ; 
		HashMap tabData = new HashMap() ;
		try{

			for(int i=0; i<10;i++){
				//String select			= "select"+i; //Commented for common-icn-0048
				String storage_bin_code	= "storage_bin_code"  + i ;
				String description		= "description"  + i ;
            
				ArrayList insertRow = new ArrayList() ;
				ArrayList whereRow = new ArrayList() ;
				//if (((String)hashMultiple.get(eff_status)).trim().equals("E")){
					if(!((((String)hashMultiple.get(storage_bin_code))).trim().equals("") || (((String)hashMultiple.get(description))).trim().equals("") )){
						insertRow.add( login_facility_id     ) ;
						insertRow.add( (String)hashMultiple.get(   "disp_locn_code"     )  ) ;
						insertRow.add( (String)hashMultiple.get(  ("storage_bin_code" + i)    )  ) ;
						insertRow.add( (String)hashMultiple.get(  ("description" + i)         ) ) ;
					
						if( ((String)hashMultiple.get(("eff_status" + i))).equals("") )
							insertRow.add(  "D"  ) ;
						else
							insertRow.add( (String)hashMultiple.get(  ("eff_status" + i)        ) ) ;
                        //insertRow.add(  "D"  ) ;
						insertRow.add( login_by_id ) ;
						insertRow.add( login_at_ws_no ) ;
						insertRow.add( login_facility_id ) ;
						insertRow.add( login_by_id ) ;
						insertRow.add( login_at_ws_no ) ;
						insertRow.add( login_facility_id ) ;
						
                        //whereRow.add( login_facility_id );
						whereRow.add( (String)hashMultiple.get(   "disp_locn_code"     )  ) ;
						whereRow.add( (String)hashMultiple.get(  "storage_bin_code" + i )  ) ;
						/* note:-
						The insertData and whereData should be arraylist of arraylist
						in case of insertMultiple() of SingleTableHandler
						*/
						insertData.add( insertRow ) ;
						whereData.add( whereRow ) ;
					}
				//}
			}//for
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);
			sqlMap.put( "SelectSQL",PhRepository.getPhKeyValue( "SQL_PH_STORAGE_LOCN_DUPLICATE" ));
			sqlMap.put( "InsertSQL",PhRepository.getPhKeyValue( "SQL_PH_STORAGE_LOCN_INSERT" ));
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			 
               
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();
			
			map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			}
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else{
					map.put( "message", (map.get("msgid"))) ;
				}
			}
		}
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
		map.put("flag","0");
		return map ;
	}//insert ends

	public HashMap modify() {
		
		StringBuffer debug = new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList modifyData = new ArrayList() ;

		modifyData.add( storage_locn_desc.trim() ) ;
		modifyData.add( eff_status.trim() ) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( disp_locn_code.trim() ) ;
		modifyData.add( storage_bin_code.trim() ) ;
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "ModifySQL",PhRepository.getPhKeyValue("SQL_PH_STORAGE_LOCN_UPDATE" ));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag","0");
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
				map.put( "flag","0");
			}
		}
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			map.put( "flag","0");
			e.printStackTrace() ;
		} 
		map.put("flag",debug.toString());
		return map ;	
	}

	public ArrayList getDispLocForList() throws Exception {  
		
		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_STORAGE_LOCN_DISP_LOCN") );
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null ){
				while ( resultSet.next() ) {
					arrList.add(resultSet.getString("DISP_LOCN_CODE"));
					arrList.add(resultSet.getString("SHORT_DESC"));
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return arrList;
	}

	public ArrayList getStorageQueryData(String displocn,String shortdesc,String dispstrge,String desc,String effst,String facilityid,String from,String to) throws Exception {  
		
		if(displocn.equals(""))  
			displocn="%";
		if(shortdesc.equals(""))  
			shortdesc="%";
		if(dispstrge.equals(""))  
			dispstrge="%";
		if(desc.equals(""))  
			desc="%";
		if(effst.equals(""))  
			effst="%";
		if(facilityid.equals("")) 
			facilityid="%";

		ArrayList records = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		
		long count=0;
		long i = 0;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_STORAGE_LOCN_EXECUTE"));
			pstmt.setString(1,displocn+ "%");
			pstmt.setString(2,shortdesc+ "%");
            pstmt.setString(3,dispstrge+ "%");
            pstmt.setString(4,desc+ "%");
            pstmt.setString(5,effst+ "%");
            pstmt.setString(6,facilityid);
			resultSet = pstmt.executeQuery() ;
			records.add("link");
			if (resultSet != null ){
				
				while ( resultSet.next() && i <= end+1 ){
					if( start != 1 && (i+1) < start ) {
						i++;
						continue;
					}
					else i++;
					count++ ;
					if(i <= end ) {
						records.add(resultSet.getString("DISP_LOCN_CODE"));
						records.add(resultSet.getString("SHORT_DESC"));
						records.add(resultSet.getString("STORAGE_BIN_CODE"));
						records.add(resultSet.getString("STORAGE_NAME"));
						records.add(resultSet.getString("EFF_STATUS"));
					}
				}
			}
			if( start != 1 )
				prevnextlink = prevnextlink +"<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
				prevnextlink = prevnextlink + "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;
	}

	public void loadData(String disp_locn_code,String storage_bin_code) throws Exception {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_STORAGE_LOCN_RESULT") );
			pstmt.setString( 1, login_facility_id.trim() ) ;
			pstmt.setString( 2, disp_locn_code.trim() ) ;
			pstmt.setString( 3, storage_bin_code.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				disp_locn_code		=	resultSet.getString("DISP_LOCN_CODE" );
				disp_locn_desc		=	resultSet.getString("SHORT_DESC" );
				storage_bin_code	=	resultSet.getString("STORAGE_BIN_CODE" );
				storage_locn_desc	=	resultSet.getString("STORAGE_NAME" );
				eff_status			=	resultSet.getString("EFF_STATUS" );
			}			          
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}
}
