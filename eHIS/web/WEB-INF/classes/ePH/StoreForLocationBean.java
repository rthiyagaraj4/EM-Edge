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

public class StoreForLocationBean extends PhAdapter implements Serializable{
	
	String store_code="";
	String disp_loc_code="";
	ArrayList dispLocDetails = null;
	String location_type="";
	String facility_id="";

/*
	dispLocDetails structure
index - value
	0 - LOCN_CODE
	1 - LOCN_DESC
	2 - DB_ACTION
	3 - EffStatus
	4 - ChangedYN
*/	
	 public StoreForLocationBean(){
        try{
            doCommon();
        }
        catch(Exception e){
           System.err.println("Error in Constructor"+e.toString());
		   e.printStackTrace();
		}
    }
	
	private void doCommon() throws Exception{
	}

	//Start of Set Methods
	public void setLocationType(String location_type){
		this.location_type=location_type;
	}
	
	public void setFacilityId(String facility_id){
		this.facility_id=facility_id;
	}
	public void setStoreCode(String store_code){
		this.store_code=store_code;
	}
	public void setDispLocCode(String disp_loc_code){
		this.disp_loc_code=disp_loc_code;
	}
	public void setdispLocDetails(ArrayList dispLocDetails){
		this.dispLocDetails=dispLocDetails;
	}
	//End of Set Methods

	//Start of Get Methods

	public String getLocationType(){
		return this.location_type;
	}
public String getFacilityId(){
		return this.facility_id;
	}

	public String getStoreCode(){
		return this.store_code;
	}
	public String getDispLocCode(){
		return this.disp_loc_code;
	}

	public ArrayList getdispLocDetails()	{
		return this.dispLocDetails;
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
if(recordSet.containsKey("facility_id"))
			setStoreCode((String)recordSet.get("facility_id")) ;

		if(recordSet.containsKey("disp_loc_code"))
			setDispLocCode((String)recordSet.get("disp_loc_code")) ;
if(recordSet.containsKey("location_type"))
			setStoreCode((String)recordSet.get("location_type")) ;
	}
public ArrayList getDispLocationList(String disp_loc_code,String location_type){
	//	System.err.println("getDispLocationList----------->");
		Connection connection	 =	null ;
		PreparedStatement pstmt_select_disptype =	null ;
		ResultSet rset_disp_type = null;
		dispLocDetails = new ArrayList();
		setDispLocCode(disp_loc_code);
		setLocationType(location_type);
		String sql_select_disp_type="";
		try{
			if(location_type.equals("C"))
			{
				 sql_select_disp_type ="SELECT CLINIC_CODE LOCN_CODE, SHORT_DESC LOCN_DESC, 'C' LOCN_TYPE,'D' EFF_STATUS,'I' DB_ACTION FROM OP_CLINIC_LANG_VW WHERE FACILITY_ID =? AND LANGUAGE_ID = ? AND EFF_STATUS = 'E' AND (FACILITY_ID, CLINIC_CODE) NOT IN (SELECT FACILITY_ID,LOCN_CODE FROM PH_LOCN_FOR_STORE WHERE FACILITY_ID =? ) UNION ALL SELECT A.LOCN_CODE LOCN_CODE,B.SHORT_DESC LOCN_DESC,A.LOCN_TYPE, A.EFF_STATUS EFF_STATUS, 'U' DB_ACTION FROM PH_LOCN_FOR_STORE A, OP_CLINIC_LANG_VW B WHERE A.FACILITY_ID = ? AND A.STORE_CODE = ? AND B.FACILITY_ID =A.FACILITY_ID AND B.CLINIC_CODE = A.LOCN_CODE AND B.LANGUAGE_ID = ?  AND a.LOCN_TYPE = 'C' ORDER BY LOCN_DESC"; 
			}else{
				sql_select_disp_type="SELECT NURSING_UNIT_CODE LOCN_CODE, SHORT_DESC LOCN_DESC, 'N' LOCN_TYPE, 'D' EFF_STATUS, 'I' DB_ACTION FROM IP_NURSING_UNIT_LANG_VW WHERE FACILITY_ID = ? AND LANGUAGE_ID = ? AND EFF_STATUS = 'E' AND (FACILITY_ID, NURSING_UNIT_CODE) NOT IN (SELECT FACILITY_ID,LOCN_CODE FROM PH_LOCN_FOR_STORE WHERE FACILITY_ID = ? ) UNION ALL SELECT A.LOCN_CODE LOCN_CODE, B.SHORT_DESC LOCN_DESC, A.LOCN_TYPE, A.EFF_STATUS EFF_STATUS, 'U' DB_ACTION FROM PH_LOCN_FOR_STORE A, IP_NURSING_UNIT_LANG_VW B WHERE A.FACILITY_ID = ? AND A.STORE_CODE = ? AND B.FACILITY_ID = A.FACILITY_ID AND B.NURSING_UNIT_CODE = A.LOCN_CODE AND B.LANGUAGE_ID = ?  AND a.LOCN_TYPE = 'N' ORDER BY LOCN_DESC"; 
 			}
//PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_SELECT" );
			connection = getConnection();
			pstmt_select_disptype = connection.prepareStatement(sql_select_disp_type);
			pstmt_select_disptype.setString(1, getLoginFacilityId());
			pstmt_select_disptype.setString(2, getLanguageId());
			pstmt_select_disptype.setString(3, getLoginFacilityId());
			pstmt_select_disptype.setString(4, getLoginFacilityId());
			pstmt_select_disptype.setString(5, disp_loc_code);
			pstmt_select_disptype.setString(6, getLanguageId());
			rset_disp_type = pstmt_select_disptype.executeQuery();
			while((rset_disp_type!= null)&& (rset_disp_type.next())){
				dispLocDetails.add(rset_disp_type.getString("LOCN_CODE"));
				dispLocDetails.add(rset_disp_type.getString("LOCN_DESC"));
				dispLocDetails.add(rset_disp_type.getString("DB_ACTION"));
				dispLocDetails.add(rset_disp_type.getString("EFF_STATUS"));
				dispLocDetails.add("N");
				//dispLocDetails.add(rset_disp_type.getString("LOCN_TYPE"));
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
		return dispLocDetails;
	}

	public void clear() {
		this.disp_loc_code="";
		this.dispLocDetails= null;
		this.location_type="";
		this.store_code="";
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
			tabData.put("location_type",location_type);
			tabData.put("facility_id",facility_id);
			//	String sql_insert =PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_INSERT" );
			//	String sql_update = PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_UPDATE" );
			String sql_insert="INSERT INTO PH_LOCN_FOR_STORE (STORE_CODE, FACILITY_ID,LOCN_CODE,LOCN_TYPE, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String sql_update="delete from PH_LOCN_FOR_STORE Where facility_id = ? and locn_type = ? and locn_code = ? "; 
			while((dispLocDetails != null) && (count < dispLocDetails.size())){
				disp_type_code=(String)dispLocDetails.get(index++);
				index++;//disp_type desc
				db_action=(String)dispLocDetails.get(index++);;        
				eff_status=(String)dispLocDetails.get(index++);;        
				changed=(String)dispLocDetails.get(index++);;          
				if(changed.equals("Y")){
					if(db_action.equals("I")){
						insertRow = new ArrayList();
						insertRow.add(disp_loc_code);
						insertRow.add(facility_id);
						insertRow.add(disp_type_code);
						insertRow.add(location_type);
						insertRow.add("E");
						insertRow.add(login_by_id);     
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);     
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertData.add(insertRow);
					}
					else if(eff_status.equals("D")) {
						modifyRow = new ArrayList();
						modifyRow.add(facility_id);     
						modifyRow.add(location_type);
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
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put("result", new Boolean(false));
		return map ;
	}

	public ArrayList getStoreDetails( String disp_loc_code){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();
		setDispLocCode(disp_loc_code);
		try{
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
				setFacilityId(getLoginFacilityId());
			}
		}
		catch(Exception e){
			records.add(e.toString()); e.printStackTrace();
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
}
