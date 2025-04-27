/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import eSS.Common.* ;
import eCommon.Common.* ;
import eSS.GroupForStore.*;
import javax.servlet.* ;
import javax.servlet.http.*;
import eSS.Common.SsAdapter;


public class GroupForStoreBean extends SsAdapter implements Serializable {

protected ArrayList DataList	= null;
protected String facilityid		= "";
protected ArrayList result		= null;
protected String ss_group_code= "";
protected String ss_store_code= "";
protected String location_ref	= "";
protected int maxCount	= 0;


public GroupForStoreBean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}

private void doCommon() throws Exception {

}

public ArrayList getDataList(){
	return DataList;
}

public void setDataList(HashMap codeList){
		DataList.add(codeList);
}

public void replaceDataList(HashMap codeList,String id){

		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("GROUP_CODE");
				if(str_id.equals(id))
					DataList.set(j,codeList);
		 }
}

public void replaceDataListbyGroup(HashMap codeList,String id){

		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STORE_CODE");
				if(str_id.equals(id))
					DataList.set(j,codeList);
		}
}

public boolean chkDatainDB(String id,String eff_status){
	boolean idavail=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("GROUP_CODE");
				if( (str_id.equals(id)) ){
					idavail=true;
					break;
				}
				else{
				idavail=false;
				}
		 }
 return idavail;
}
public boolean chkUpdateYN(String id,String eff_status){
	boolean modifyyn=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("GROUP_CODE");
			String db_eff_status=(String)hh.get("EFF_STATUS");
				if( (str_id.equals(id)) ){
				if( (!(eff_status.equals(db_eff_status))) ){
					modifyyn=true;
					break;
				}
				else{
				modifyyn=false;
				}
			  }
		 }
 return modifyyn;
}
public boolean chkUpdateYNByGeneric(String id,String eff_status){
	boolean modifyyn=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STORE_CODE");
			String db_eff_status=(String)hh.get("EFF_STATUS");
				if( (str_id.equals(id)) ){
				if( (!(eff_status.equals(db_eff_status))) ){
					modifyyn=true;
					break;
				}
				else{
				modifyyn=false;
				}
			  }
		 }
 return modifyyn;
}

public boolean chkDatainDBbyGroup(String id,String eff_status){
	boolean idavail=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STORE_CODE");
				if( (str_id.equals(id)) ){
					idavail=true;
					break;
				}
				else{
					idavail=false;
				}
		 }
 return idavail;
}

public boolean delDatainDBbyGroup(String id,String process){
	boolean deldata=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STORE_CODE");
			String str_process=(String)hh.get("OPER_MODE");
				if( (str_id.equals(id)) ){
					if( (str_process.equals("FB")) && (process.equals("N"))){
						DataList.remove(j);
						deldata=true;
						break;
					}else{
						deldata=false;
					}
				}
				else{
					deldata=false;
				}
		 }
	return deldata;
}

public String emptyDupRecords( ) {
	String empty_match = "";
	ArrayList removeIndex=new ArrayList();
	try{
	for(int j=0;j<DataList.size();j++) {
		empty_match=empty_match + "from emptyDupRecords";

		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String oper_mode = (String)hh.get("OPER_MODE");
		String source = (String)hh.get("SOURCE");
		empty_match= empty_match + "oper_mode :"+oper_mode+"source :"+source;
			if( oper_mode.equals("DN") && source.equals("FB") ){
				removeIndex.add(""+j);
				empty_match=empty_match + "deletion of row : "+j;
			}
			else{
			}
	empty_match+=DataList.size();
	}
	empty_match=empty_match + "DLsize: "+DataList.size();
	empty_match=empty_match + "RIsize: "+removeIndex.size();
	int rsize=removeIndex.size();

	for(int j=0;j<rsize;j++) {
	DataList.remove(Integer.parseInt(((String)removeIndex.get(j)).trim()));
	empty_match=empty_match + "DE: "+(String)removeIndex.get(j);
	j--;
	rsize--;

	}

	}
	catch(Exception e)
	{
	empty_match=empty_match + "Exception e:"+e.toString();
	}
	return empty_match;

}

public String getDataSource(String id){
	for(int j=0;j<DataList.size();j++){
		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String str_id=(String)hh.get("GROUP_CODE");
		String str_source =(String)hh.get("SOURCE");
			if( (str_id.equals(id)) ){
				return str_source;
			}
	 }
 return "";
}

public String getDataSourcebyGeneric(String id){
	for(int j=0;j<DataList.size();j++){
		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String str_id=(String)hh.get("STORE_CODE");
		String str_source =(String)hh.get("SOURCE");
		if( (str_id.equals(id)) ){
			return str_source;
		}
	 }
	 return "";
}


public void setGenericCodeResultPage(String generic_code,String eff_status,String process){

	for(int i=0;i<result.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) result.get(i);
		String str=(String)nm.get("GROUP_CODE");
		if(generic_code.equals(str)){
		nm.put("EFF_STATUS",eff_status);
		nm.put("PROCESS",process);
		}
	}

}

public void setGenericCodeResultPagebyGeneric(String store_code,String eff_status,String process){

	for(int i=0;i<result.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) result.get(i);
		String str=(String)nm.get("STORE_CODE");
		if(store_code.equals(str)){
		nm.put("EFF_STATUS",eff_status);
		nm.put("PROCESS",process);
		}
	}

}

public ArrayList chkGenericCodeDB(String generic_code){
	ArrayList key=new ArrayList();
	for(int i=0;i<DataList.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) DataList.get(i);
		String str=(String)nm.get("GROUP_CODE");
			if(generic_code.equals(str)){
				key.add((String)nm.get("OPER_MODE"));
				key.add((String)nm.get("EFF_STATUS"));
				key.add((String)nm.get("SOURCE"));
			}
		}
	return key;
}

public ArrayList chkGroupCodeDBbyGroup(String store_code){
	ArrayList key=new ArrayList();
	for(int i=0;i<DataList.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) DataList.get(i);
		String str=(String)nm.get("STORE_CODE");
			if(store_code.equals(str)){
				key.add((String)nm.get("OPER_MODE"));
				key.add((String)nm.get("EFF_STATUS"));
				key.add((String)nm.get("SOURCE"));
				key.add((String)nm.get("MIN_QTY"));
				key.add((String)nm.get("REORDER_QTY"));
			}
	}

 return key;
}

public void setLoginFacilId(String facilityid){
	this.facilityid=facilityid;
}

public ArrayList getStCode() throws Exception {
		ArrayList codeList=new ArrayList();

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_SELECT_STORE") ) ;//SQL_SS_STORE_SELECT_LIST
			pstmt.setString( 1, facilityid ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataCode=new HashMap();
				dataCode.put( "STORE_CODE",resultSet.getString( "STORE_CODE" ) ) ;
				dataCode.put( "SHORT_DESC",resultSet.getString( "SHORT_DESC" ) ) ;
				codeList.add(dataCode);
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}

		}
		return codeList;

}

public ArrayList getGenericName() throws Exception {
		ArrayList nameList=new ArrayList();

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_PH_GENERIC_NAME_SELECT2") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataCode=new HashMap();
				dataCode.put( "GENERIC_ID",resultSet.getString( "GENERIC_ID" ) ) ;
				dataCode.put( "GENERIC_NAME",resultSet.getString( "GENERIC_NAME" ) ) ;
				nameList.add(dataCode);
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}

		}
		return nameList;

}

public void loadData(String code, String from_source, String facility_id) throws Exception {
		ss_group_code=code;
		ss_store_code=code;
		DataList=new ArrayList();

	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;

			if( from_source.equals("bygroup") ){
			pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_SELECT_STORE") ) ;
			pstmt.setString( 1, code );
			pstmt.setString( 2, facility_id );
			}
			else{
			pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_SELECT_GROUP") ) ;
			pstmt.setString( 1, code );
			}


		resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
				if( from_source.equals("bystore") ){
				dataRow.put( "GROUP_CODE",resultSet.getString( "GROUP_CODE" ) ) ;
				dataRow.put( "SHORT_DESC",resultSet.getString( "SHORT_DESC" ) ) ;
				}
				else{
				dataRow.put( "STORE_CODE",resultSet.getString( "STORE_CODE" ) ) ;
				dataRow.put( "SHORT_DESC",resultSet.getString( "SHORT_DESC" ) ) ;
				}

				dataRow.put( "EFF_STATUS",resultSet.getString( "EFF_STATUS" ) ) ;
				dataRow.put( "OPER_MODE","DN" ) ;
				dataRow.put( "SOURCE", "DB" ) ;
				dataRow.put( "MIN_QTY_CHK", "Q" ) ;
				//Added By Sakti Sankar
				dataRow.put( "MIN_QTY",resultSet.getString( "MIN_QTY" ) ) ;
				dataRow.put( "REORDER_QTY",resultSet.getString( "REORDER_QTY" ) ) ;
				DataList.add(dataRow);
				}
	} catch ( Exception e )	{
			DataList.add(e.toString());
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}

		}

}

public ArrayList getBeanRecords () {
	return this.result=result;
}

public ArrayList getDBResult () {
	return this.DataList=DataList;
}

public int getmaxCount () {
	return maxCount;
}
public String getGenericName(String generic_id){
	String genericname="";
	for(int i=0;i<result.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) result.get(i);
		String str_id=(String)nm.get("GENERIC_ID");
		String str_name=(String)nm.get("GENERIC_NAME");

		if(str_id.equals(generic_id)){
			genericname=str_name;
			break;
		}
	}
return genericname;
}
public String getStoreName(String store_code){
	String short_desc="";
	for(int i=0;i<result.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) result.get(i);
		String str_id=(String)nm.get("STORE_CODE");
		String str_name=(String)nm.get("SHORT_DESC");

		if(str_id.equals(store_code)){
			short_desc=str_name;
			break;
		}
	}
return short_desc;
}
public ArrayList getGenericCodeResultPage (String generic_id,int start,int end) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmtMaxCount = null ;
		ResultSet resultSet = null ;
		ResultSet rsMaxCount = null ;
		String gen_id="";
		int i=1;
		result=new ArrayList();
		gen_id=generic_id+"%";
		maxCount=0;
		try {
			connection = getConnection() ;
			if(!generic_id.equals("OTH")){
			pstmtMaxCount = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_PH_GENERIC_NAME_COUNT_SELECT1") ) ;
			pstmt = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_PH_GENERIC_NAME_SELECT1") ) ;
			pstmtMaxCount.setString( 1, gen_id ) ;
			pstmt.setString( 1, gen_id ) ;

			}
			else{
			pstmtMaxCount = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_PH_GENERIC_NAME_COUNT_SELECT3") ) ;
			pstmt = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_PH_GENERIC_NAME_SELECT3") ) ;
			}

			rsMaxCount = pstmtMaxCount.executeQuery() ;


			if ( rsMaxCount != null && rsMaxCount.next() ) {
						maxCount=rsMaxCount.getInt(1);
				}


			resultSet = pstmt.executeQuery() ;
			if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){
					resultSet.next() ;
				}

			while ( resultSet.next() && i<=end )
			{
				HashMap rowSet=new HashMap();
				rowSet.put( "GENERIC_ID",resultSet.getString( "GENERIC_ID" ) ) ;
				rowSet.put( "GENERIC_NAME",resultSet.getString( "GENERIC_NAME" ) ) ;
				rowSet.put( "EFF_STATUS",resultSet.getString( "EFF_STATUS" ) ) ;
				rowSet.put( "PROCESS","N" ) ;
				result.add(rowSet);
				i++;
			}
		}
		catch ( Exception e )	{
			result.add("Exception:"+e);
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement(pstmtMaxCount);
				closeResultSet(rsMaxCount);
				closeConnection( connection );
			}catch(Exception es){
			}

		}

 return result;
}
public ArrayList getGroupCodeResultPagebyGroup() {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		result = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( SsRepository.getSsKeyValue("SQL_SS_STORE_SELECT_LIST") ) ;
			pstmt.setString( 1, getLanguageId()) ;
			pstmt.setString( 2, facilityid ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				HashMap rowSet=new HashMap();
				rowSet.put( "STORE_CODE",resultSet.getString( "STORE_CODE" ) ) ;
				rowSet.put( "SHORT_DESC",resultSet.getString( "SHORT_DESC" ) ) ;
				rowSet.put( "EFF_STATUS","E" ) ;
				rowSet.put( "PROCESS","N" ) ;
				//rowSet.put( "MIN_QTY",resultSet.getString( "MIN_QTY" ) ) ;
				result.add(rowSet);
				}

		} catch ( Exception e )	{
			result.add("Exception:"+e);
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}

		}


		return result;
}

public ArrayList sortList( ArrayList recordList, String key ) {
	String keyVal[] = new String[recordList.size()];
	// Take all the keys values and put it in the array
	for(int i=0; i<recordList.size() ; i++) {
		HashMap hashMap = (HashMap) recordList.get(i) ;
		String keydata = (String) hashMap.get(key) ;
		keyVal[i] = keydata ;
	}

	// sort the key value array
	for(int i=0 ; i< keyVal.length-1 ; i++ ) {
		for(int j=0 ; j< keyVal.length-i-1 ; j++) {
			if( keyVal[j].compareTo(keyVal[j+1]) > 0 ) {
				String temp = keyVal[j] ;
				keyVal[j] = keyVal[j+1] ;
				keyVal[j+1] = temp ;
			}
		}
	}

	// create a sorted ArrayList by picking with the sorted index
	ArrayList sortedList = new ArrayList();
	for(int i=0 ; i< keyVal.length ; i++ ) {
		sortedList.add( recordList.get(findPosition(recordList, key, keyVal[i])));
	}
	return sortedList ;
}
private int findPosition(ArrayList recordList, String key, String keyVal) {

	for(int i=0 ; i<recordList.size() ; i++ ) {
		HashMap dataMap = (HashMap) recordList.get(i) ;
		if( ((String)dataMap.get(key)).equals(keyVal) )
			return i;
	}
	return -1;
}
public void setAll( Hashtable recordSet ) {
	if(recordSet.containsKey("location_ref"))
	this.location_ref=(String)recordSet.get("location_ref");

}
public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;

        return map ;
    }

//This method is for both insert and modify operations.
public HashMap insert() {

        HashMap map = new HashMap() ;
		boolean data_change=false;

		map.put( "result", new Boolean( true ) ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList modifyData = new ArrayList() ;
		ArrayList insertRow = null ;
		ArrayList modifyRow = null ;
		for(int j=0;j<DataList.size();j++) {
		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String oper_mode = (String)hh.get("OPER_MODE");
		String source = (String)hh.get("SOURCE");
		//String qty_chk = (String)hh.get("MIN_QTY_CHK"); //Comented by sakti as this is unused against inc#48061 
			if( oper_mode.equals("I") && source.equals("FB") ){
					data_change=true;
					insertRow = new ArrayList() ;

					if(location_ref.equals("bystore"))
					{
					insertRow.add(ss_store_code);
					insertRow.add((String)hh.get("GROUP_CODE"));
					}
					else
					{
					insertRow.add((String)hh.get("STORE_CODE"));
					insertRow.add(ss_group_code);
					}
					insertRow.add((String)hh.get("EFF_STATUS"));
					insertRow.add(login_by_id);
					insertRow.add(login_at_ws_no);
					insertRow.add(login_facility_id);
					insertRow.add(login_by_id);
					insertRow.add(login_at_ws_no);
					insertRow.add(login_facility_id);
					insertRow.add((String)hh.get("MIN_QTY"));
					insertRow.add((String)hh.get("REORDER_QTY"));
					insertData.add(insertRow);
				}
				else if(((oper_mode.equals("U") && source.equals("DB")) )) {
					data_change=true;
					modifyRow = new ArrayList() ;
					modifyRow.add((String)hh.get("EFF_STATUS"));
					modifyRow.add(login_by_id);
					modifyRow.add(login_at_ws_no);
					modifyRow.add(login_facility_id);
					modifyRow.add((String)hh.get("MIN_QTY"));
					modifyRow.add((String)hh.get("REORDER_QTY"));
					if(location_ref.equals("bystore"))
					{
					modifyRow.add(ss_store_code);
					modifyRow.add((String)hh.get("GROUP_CODE"));
					}
					else
					{
					modifyRow.add((String)hh.get("STORE_CODE"));
					modifyRow.add(ss_group_code);
					}
					modifyData.add(modifyRow);
				}



	}
	HashMap tabData = new HashMap() ;
	tabData.put( "properties", getProperties() );
	tabData.put( "InsertData",insertData);
	tabData.put( "ModifyData",modifyData);

	HashMap sqlMap = new HashMap() ;

	try {


				sqlMap.put( "SQL_SS_GROUP_FOR_STORE_INSERT", SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_INSERT") );
				sqlMap.put( "SQL_SS_GROUP_FOR_STORE_UPDATE", SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_UPDATE") );

				if(data_change){

				 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GROUP_FOR_STORE"),GroupForStoreHome.class,getLocalEJB());
			
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();
			   

				HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					if( ((Boolean) result.get( "result" )).booleanValue() )
					{
						map.put("flag",result.get("flag"));
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"SS") ) ;
					}
					else
					{	
						if(((String)result.get("msgid")).contains("REQ_ON_STORE_CODE")){
							map.put("flag",result.get("flag"));
							map.put( "result", new Boolean( false ) ) ;
							map.put( "message",  "APP-SS0001 Auto Request On Store Cannot be Null") ;
						}else{
							map.put("flag",result.get("flag"));
							map.put( "result", new Boolean( false ) ) ;
							map.put( "message", result.get("msgid") ) ;
						}
					}
				}
				else{
					map.put("flag","nochange");
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", "" ) ;
				}

	}
	catch(Exception e) {
		map.put("flag",e.toString());
		e.printStackTrace() ;
	}
	finally {
			try {}
			catch( Exception ee ){
				map.put( "message", ee.getMessage() ) ;
				map.put( "sb", ee.getMessage() ) ;
			}
	}

	return map ;
}
public void clear() {
        DataList=null;
		facilityid="";
		result=null;
		ss_group_code="";
		ss_store_code="";
		location_ref="";
	      super.clear() ;
   }

	/* Function specific methods end */
}
