/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class LocationStoreItemsBean extends PhAdapter implements Serializable{
	
	String store_code="";
	String disp_loc_code="";
	ArrayList locForDetails = null;
	String item_type="";
	String item_search_code="";
	
/*
	locForDetails structure
index - value
	0 - item_code
	1 - item_desc
	2 - DB_ACTION
	3 - EffStatus
	4 - ChangedYN
*/	
	 public LocationStoreItemsBean(){
        try{
            doCommon();
        }
        catch(Exception e){
		   e.printStackTrace();
		}
    }
	
	private void doCommon() throws Exception{
	}

	//Start of Set Methods
		public void setItemType(String item_type){
		this.item_type=item_type;
	}
	
	public void setItemSearchCode(String item_search_code){
		this.item_search_code=item_search_code;
	}

	public void setStoreCode(String store_code){
		this.store_code=store_code;
	}
	public void setDispLocCode(String disp_loc_code){
		this.disp_loc_code=disp_loc_code;
	}
	public void setlocForDetails(ArrayList locForDetails){
		this.locForDetails=locForDetails;
	}
	//End of Set Methods

	//Start of Get Methods

	public String getItemType(){
		return this.item_type;
	}

	public String getStoreCode(){
		return this.store_code;
	}
	public String getDispLocCode(){
		return this.disp_loc_code;
	}

	public String getItemSearchCode(){
		return this.item_search_code;
	}

	public ArrayList getlocForDetails()	{
		return this.locForDetails;
	}
	

	//End of Get Methods

	//Validate Method
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	//SetAll method
	public void setAll( Hashtable recordSet ) {
		this.mode=(String)recordSet.get("mode");

if(recordSet.containsKey("store_code"))
			setStoreCode((String)recordSet.get("store_code")) ;
if(recordSet.containsKey("item_search_code"))
			setStoreCode((String)recordSet.get("item_search_code")) ;

		if(recordSet.containsKey("disp_loc_code"))
			setDispLocCode((String)recordSet.get("disp_loc_code")) ;
if(recordSet.containsKey("item_type"))
			setStoreCode((String)recordSet.get("item_type")) ;
if(recordSet.containsKey("item_search_code"))
			setStoreCode((String)recordSet.get("item_search_code")) ;
	}
public ArrayList getLocationForList(String store_code,String item_type,String item_search_code,String item_search){
	//	System.err.println("getDispLocationList----------->");
		Connection connection	 =	null ;
		PreparedStatement pstmt_select_disptype =	null ;
		ResultSet rset_disp_type = null;
		locForDetails = new ArrayList();
		setDispLocCode(store_code);
		setItemType(item_type);
		String sql_select_disp_type="";
		try{
setItemSearchCode(item_search_code);
			if(item_type.equals("M"))
			{
			       sql_select_disp_type ="SELECT a.item_code item_code, c.short_desc item_desc, 'M' item_type, 'D' eff_status, 'I' db_action FROM st_item_store a, st_item b, mm_item_lang_vw c WHERE a.store_code = ? AND b.item_code = a.item_code AND c.item_code = a.item_code AND b.medical_item_yn = 'Y' AND b.DRUG_ITEM_YN = 'N' AND c.language_id = ? AND c.EFF_STATUS = 'E' AND UPPER(c.short_desc) LIKE UPPER('%'||?||'%') AND (a.store_code, a.item_code) NOT IN (SELECT store_code, item_code FROM PH_LOCN_STORE_DISP_ITEM WHERE store_code =?) UNION ALL SELECT a.item_code item_code, B.SHORT_DESC ITEM_DESC, A.ITEM_TYPE, A.EFF_STATUS EFF_STATUS, 'U' DB_ACTION FROM PH_LOCN_STORE_DISP_ITEM A, MM_ITEM_LANG_VW B WHERE A.STORE_CODE = ? AND A.ITEM_CODE = NVL(?,A.ITEM_CODE) AND A.ITEM_TYPE = 'M' AND B.ITEM_CODE = A.ITEM_CODE AND UPPER(B.short_desc) LIKE UPPER('%'||?||'%') AND B.LANGUAGE_ID = ? ORDER BY ITEM_DESC";
 			}else if(item_type.equals("D")){
		          sql_select_disp_type="SELECT a.item_code item_code, c.drug_desc item_desc, 'D' item_type, 'D' eff_status, 'I' db_action FROM st_item_store a, ph_drug_lang_vw c WHERE a.store_code = ? AND c.item_code = a.item_code AND c.language_id =? AND c.discontinued_yn = 'N' AND UPPER(c.drug_desc) LIKE UPPER('%'||?||'%') AND (a.store_code, a.item_code) NOT IN (SELECT store_code, item_code FROM PH_LOCN_STORE_DISP_ITEM WHERE store_code =?) UNION ALL SELECT a.item_code item_code, B.DRUG_DESC ITEM_DESC, A.ITEM_TYPE, A.EFF_STATUS EFF_STATUS, 'U' DB_ACTION FROM PH_LOCN_STORE_DISP_ITEM A, PH_DRUG_LANG_VW B WHERE A.STORE_CODE = ? AND A.ITEM_CODE = NVL(?,A.ITEM_CODE) AND A.ITEM_TYPE = 'D' AND B.ITEM_CODE = A.ITEM_CODE AND UPPER(B.drug_desc) LIKE UPPER('%'||?||'%') AND B.LANGUAGE_ID = ? ORDER BY ITEM_DESC";
 			}
//PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_SELECT" );
			connection = getConnection();
			pstmt_select_disptype = connection.prepareStatement(sql_select_disp_type);
			pstmt_select_disptype.setString(1, store_code);
			pstmt_select_disptype.setString(2, getLanguageId());
			pstmt_select_disptype.setString(3, item_search);
			pstmt_select_disptype.setString(4, store_code);
			pstmt_select_disptype.setString(5, store_code);
			pstmt_select_disptype.setString(6, item_search_code);
			pstmt_select_disptype.setString(7, item_search);
			pstmt_select_disptype.setString(8, getLanguageId());
			rset_disp_type = pstmt_select_disptype.executeQuery();
			while((rset_disp_type!= null)&& (rset_disp_type.next())){
				locForDetails.add(rset_disp_type.getString("item_code"));
				locForDetails.add(rset_disp_type.getString("item_desc"));
				locForDetails.add(rset_disp_type.getString("DB_ACTION"));
				locForDetails.add(rset_disp_type.getString("EFF_STATUS"));
				locForDetails.add("N");
			}
		}
		catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rset_disp_type);
				closeStatement(pstmt_select_disptype);
				closeConnection(connection);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return locForDetails;
	}

	public void clear() {
		this.disp_loc_code="";
		this.locForDetails= null;
		this.item_type="";
		this.store_code="";
		this.item_search_code="";
	}

	public HashMap insert() {
		HashMap map = new HashMap() ;
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
		ArrayList insertData = new ArrayList() ;
		ArrayList modifyData = new ArrayList() ;
		ArrayList insertRow = new ArrayList() ;
		ArrayList modifyRow = new ArrayList() ;
		map.put("result", new Boolean(false));
		int count=0;
		int index=0;
		String disp_type_code="";
		String db_action="";
		String changed="";
		String eff_status="";
		String msgId="";
		try{
		tabData.put("store_code",store_code);
		tabData.put("disp_loc_code",disp_loc_code);
		tabData.put("item_type",item_type);
		tabData.put("item_search_code",item_search_code);
		//	String sql_insert =PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_INSERT" );
		//	String sql_update = PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_UPDATE" );






		//="INSERT INTO PH_LOCN_FOR_STORE (STORE_CODE, FACILITY_ID,LOCN_CODE,LOCN_TYPE, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		String sql_insert="INSERT INTO PH_LOCN_STORE_DISP_ITEM(STORE_CODE, ITEM_CODE, EFF_STATUS,ITEM_TYPE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID )VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";	
		
		String sql_update="DELETE FROM PH_LOCN_STORE_DISP_ITEM WHERE STORE_CODE = ? AND ITEM_CODE = ?";
			//"delete from PH_LOCN_FOR_STORE Where facility_id = ? and locn_type = ? and locn_code = ? "; 
  		while((locForDetails != null) && (count < locForDetails.size())){
				disp_type_code=(String)locForDetails.get(index++);
				index++;//disp_type desc
				db_action=(String)locForDetails.get(index++);;        
				eff_status=(String)locForDetails.get(index++);;        
				changed=(String)locForDetails.get(index++);;   

		if(changed.equals("Y")){
					if(db_action.equals("I")){
						insertRow = new ArrayList();
						insertRow.add(disp_loc_code);
						insertRow.add(disp_type_code);
						insertRow.add("E");
						insertRow.add(item_type);
						insertRow.add(login_by_id);     
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);     
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertData.add(insertRow);
					  }else  if(eff_status.equals("D")) {
						 
						modifyRow = new ArrayList();
						modifyRow.add(disp_loc_code);     
						modifyRow.add(disp_type_code);
						modifyData.add(modifyRow);
					}
					map.put("result", new Boolean(true));
				}
				count+=5;
			}
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass();
			paramArray[1] = sqlMap.getClass();
			if(insertData.size() > 0){
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData", insertData);
				sqlMap.put( "InsertSQL", sql_insert);
				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				if(modifyData.size() > 0){
					tabData.clear();
					sqlMap.clear();
					tabData.put( "properties", getProperties() );
					tabData.put( "InsertData", modifyData);
					sqlMap.put( "InsertSQL", sql_update);
					map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				}
			}
			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				msgId = (String)map.get( "msgid" )==null?"":(String)map.get( "msgid" );
				if( (msgId).equals( "CODE_ALREADY_EXISTS" ) ) {
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					String msgID = getMessage((String) map.get( "msgid" ),false) ;
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else if (msgId.equals("")){
					map.put( "message",getMessage(getLanguageId(),"PH_NO_CHANGE","PH") ) ;
				}
				else
					map.put( "message", (map.get("msgid"))) ;
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put("result", new Boolean(false));
		return map ;
	}
	public ArrayList getStoreDetails( String disp_loc_code)
	{
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();
		setDispLocCode(disp_loc_code);
		try
		{
		String sql="SELECT a.store_code, b.long_desc store_desc FROM ph_disp_locn_lang_vw a, mm_store_lang_vw b WHERE a.facility_id =?  AND a.language_id = ? AND b.language_id = ? and a.DISP_LOCN_CODE=? AND a.store_code = b.store_code";	
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql ) ;
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,disp_loc_code);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					records.add(resultSet.getString("store_code"));
					records.add(resultSet.getString("store_desc"));
					setStoreCode(resultSet.getString("store_code"));
				//	setFacilityId(getLoginFacilityId());
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}catch(Exception e){
			records.add(e.toString()); e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){System.err.println("Error while closing the statements,resultsets and connection"+es.toString()); es.printStackTrace();}		
		}
		return records;	
	}
}
