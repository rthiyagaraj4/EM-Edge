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
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.GenericNameForService.*;
import javax.servlet.* ;
import javax.servlet.http.*;


//saved on 27/10/2005
public class GenericNameforServiceBean extends PhAdapter implements Serializable {

protected ArrayList DataList	= null;
protected String facilityid		= "";
protected ArrayList result		= null;
protected String ph_service_code= "";
protected String ph_generic_code= "";
protected String location_ref	= "";
protected int maxCount	= 0;


public GenericNameforServiceBean() {
		try {
			doCommon();
		}catch(Exception e) {e.printStackTrace();}
	}

private void doCommon() throws Exception {

}

public ArrayList getDataList(){
	return DataList;
}

public void setDataList(HashMap codeList){
	//System.err.println("codeList------------>"+codeList);
		DataList.add(codeList);
}

public void replaceDataList(HashMap codeList,String id){
		
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("GENERIC_ID");
				if(str_id.equals(id))
					DataList.set(j,codeList);
		 }
}

public void replaceDataListbyGeneric(HashMap codeList,String id){
		
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("SERVICE_CODE");
				if(str_id.equals(id))
					DataList.set(j,codeList);
		}
}

public boolean chkDatainDB(String id){
	boolean idavail=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("GENERIC_ID");
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
			String str_id=(String)hh.get("GENERIC_ID");
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
			String str_id=(String)hh.get("SERVICE_CODE");
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

public boolean chkDatainDBbyGeneric(String id){
	boolean idavail=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("SERVICE_CODE");
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

public boolean delDatainDBbyGeneric(String id,String process){
	boolean deldata=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("SERVICE_CODE");
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
		empty_match+="from emptyDupRecords";
		
		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String oper_mode = (String)hh.get("OPER_MODE");
		String source = (String)hh.get("SOURCE");
		empty_match+="oper_mode :"+oper_mode+"source :"+source;
			if( oper_mode.equals("DN") && source.equals("FB") ){
				removeIndex.add(""+j);
				empty_match+="deletion of row : "+j;
			}
			

	empty_match+=DataList.size();
	}
	empty_match+="DLsize: "+DataList.size();
	empty_match+="RIsize: "+removeIndex.size();
	int rsize=removeIndex.size();
	
	for(int j=0;j<rsize;j++) {
	DataList.remove(Integer.parseInt(((String)removeIndex.get(j)).trim()));
	empty_match+="DE: "+(String)removeIndex.get(j);
	j--;
	rsize--;

	}
	
	}
	catch(Exception e)
	{
	empty_match+="Exception e:"+e.toString();
	}
	return empty_match;
	
}

public String getDataSource(String id){
	for(int j=0;j<DataList.size();j++){
		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String str_id=(String)hh.get("GENERIC_ID");
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
		String str_id=(String)hh.get("SERVICE_CODE");
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
		String str=(String)nm.get("GENERIC_ID");
		if(generic_code.equals(str)){
		nm.put("EFF_STATUS",eff_status);
		nm.put("PROCESS",process);	
		}
	}
	
}

public void setGenericCodeResultPagebyGeneric(String service_code,String eff_status,String process){
	
	for(int i=0;i<result.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) result.get(i);
		String str=(String)nm.get("SERVICE_CODE");
		if(service_code.equals(str)){
		nm.put("EFF_STATUS",eff_status);
		nm.put("PROCESS",process);	
		}
	}
	
}

public ArrayList chkGenericCodeDB(String generic_code){		
	ArrayList key=new ArrayList();
	//key.add("DN");
	for(int i=0;i<DataList.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) DataList.get(i);		
		String str=(String)nm.get("GENERIC_ID");
			if(generic_code.equals(str)){
				key.add((String)nm.get("OPER_MODE"));
				key.add((String)nm.get("EFF_STATUS"));
				key.add((String)nm.get("SOURCE"));
			}
		}
	return key;
}

public ArrayList chkGenericCodeDBbyGeneric(String service_code){		
	ArrayList key=new ArrayList();
	for(int i=0;i<DataList.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) DataList.get(i);		
		String str=(String)nm.get("SERVICE_CODE");
			if(service_code.equals(str)){
				key.add((String)nm.get("OPER_MODE"));
				key.add((String)nm.get("EFF_STATUS"));
				key.add((String)nm.get("SOURCE"));
			}
	}
		
 return key;
}

public void setLoginFacilId(String facilityid){
	this.facilityid=facilityid;
}

public ArrayList getServiceCode() throws Exception {
		ArrayList codeList=new ArrayList();
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AM_SERVICE_SELECT") ) ;
			pstmt.setString( 1, facilityid ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataCode=new HashMap();
				dataCode.put( "SERVICE_CODE",resultSet.getString( "SERVICE_CODE" ) ) ;
				dataCode.put( "SHORT_DESC",resultSet.getString( "LONG_DESC" ) ) ;
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

public boolean ip_yn() throws Exception {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int count=0;
		boolean ip_yn=false;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT6") ) ;
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				count=resultSet.getInt(1);			
			}
			if(count==0)ip_yn=false;
			else ip_yn=true;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			es.printStackTrace() ;
			}

		}
		return ip_yn;

}

public ArrayList getGenericName() throws Exception {
		ArrayList nameList=new ArrayList();
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT2") ) ;
           
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
			es.printStackTrace() ;}

		}
		return nameList;

}

public void loadData(String code, String from_source,String locale) throws Exception {
		ph_service_code=code;
		ph_generic_code=code;
		DataList=new ArrayList();

	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			
			if( from_source.equals("byservice") ){
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_SERVICE_SELECT1") ) ;
			}
			else{
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_SERVICE_SELECT2") ) ;
			}
			
			pstmt.setString( 1, code ) ;
			pstmt.setString( 2,locale) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
				if( from_source.equals("byservice") ){
				dataRow.put( "GENERIC_ID",resultSet.getString( "GENERIC_ID" ) ) ;
				dataRow.put( "GENERIC_NAME",resultSet.getString( "GENERIC_NAME" ) ) ;
				}
				else{
				dataRow.put( "SERVICE_CODE",resultSet.getString( "SERVICE_CODE" ) ) ;
				dataRow.put( "SHORT_DESC",resultSet.getString( "LONG_DESC" ) ) ;
				}
				
				dataRow.put( "EFF_STATUS",resultSet.getString( "EFF_STATUS" ) ) ;
				dataRow.put( "OPER_MODE","DN" ) ;
				dataRow.put( "SOURCE", "DB" ) ;
				DataList.add(dataRow);
				//System.err.println("DataList---bean-------->"+DataList);
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
			es.printStackTrace() ;
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
public String getServiceName(String service_code){
	String short_desc="";
	for(int i=0;i<result.size();i++){
	HashMap nm=new HashMap();
	nm=(HashMap) result.get(i);
		String str_id=(String)nm.get("SERVICE_CODE");
		String str_name=(String)nm.get("SHORT_DESC");

		if(str_id.equals(service_code)){
			short_desc=str_name;
			break;
		}
	}
return short_desc;
}
public ArrayList getGenericCodeResultPage (String generic_id,int start,int end,String locale) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmtMaxCount = null ;
		ResultSet resultSet = null ;
		ResultSet rsMaxCount = null ;
		String gen_id="";
		//System.err.println("generic_id---------->"+generic_id);
		int i=1;
		result=new ArrayList();		
		gen_id=generic_id+"%";
		maxCount=0;
		try {
			connection = getConnection() ;
			if(!generic_id.equals("OTH")){
			
			//System.err.println("oth condition");

			pstmtMaxCount = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_COUNT_SELECT1") ) ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT1") ) ;
			//System.err.println("query----------"+PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT1"));
			pstmtMaxCount.setString( 1, gen_id ) ;
			pstmt.setString( 1,gen_id ) ;
			pstmt.setString(2,locale) ;
			
			}
			else{
			
			//System.err.println("other condition");
			pstmtMaxCount = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_COUNT_SELECT3") ) ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT3") ) ;
			pstmt.setString(1,locale) ;
			}

			rsMaxCount = pstmtMaxCount.executeQuery() ;
			
			
			if ( rsMaxCount != null && rsMaxCount.next() ) {
						maxCount=rsMaxCount.getInt(1);
				}

			
			resultSet = pstmt.executeQuery() ;
			if ( start != 0 )
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
				//System.err.println("result----while loop"+result);
				i++;
			}
		}
		catch ( Exception e )	{
			result.add("Exception:"+e);
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( rsMaxCount ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmtMaxCount );
				closeConnection( connection );
			}catch(Exception es){
			es.printStackTrace() ;
			}

		}
          //System.err.println("result------bean-----result--------->"+result);
 return result;
}
public ArrayList getGenericCodeResultPagebyGeneric (String locale) {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		result = new ArrayList();	
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AM_SERVICE_SELECT") ) ;
			pstmt.setString( 1, facilityid ) ;
			pstmt.setString(2,locale) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				HashMap rowSet=new HashMap();
				rowSet.put( "SERVICE_CODE",resultSet.getString( "SERVICE_CODE" ) ) ;
				rowSet.put( "SHORT_DESC",resultSet.getString( "LONG_DESC" ) ) ;
				rowSet.put( "EFF_STATUS","E" ) ;
				rowSet.put( "PROCESS","N" ) ;
				result.add(rowSet);
				}
			
		} catch ( Exception e )	{
			result.add("Exception:"+e);
			//System.err.println("result-------from bean 593------>"+result);
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			es.printStackTrace() ;
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
//	String position[] = new String[recordList.size()];  Removed for IN063877
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
	//System.err.println("insert---------->");
		
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
			if( oper_mode.equals("I") && source.equals("FB") ){
					data_change=true;
					insertRow = new ArrayList() ;
					if(location_ref.equals("byservice")){
					insertRow.add(ph_service_code);
					insertRow.add((String)hh.get("GENERIC_ID"));
					}
					else if(location_ref.equals("bygeneric")){
					insertRow.add((String)hh.get("SERVICE_CODE"));
					insertRow.add(ph_generic_code);
					}
					insertRow.add((String)hh.get("EFF_STATUS"));
					insertRow.add(login_by_id);
					insertRow.add(login_at_ws_no);
					insertRow.add(login_facility_id);
					insertRow.add(login_by_id);
					insertRow.add(login_at_ws_no);
					insertRow.add(login_facility_id);
					insertData.add(insertRow);
				}
				else if(oper_mode.equals("U") && source.equals("DB")){
					data_change=true;
					modifyRow = new ArrayList() ;
					modifyRow.add((String)hh.get("EFF_STATUS"));
					modifyRow.add(login_by_id);
					modifyRow.add(login_at_ws_no);
					modifyRow.add(login_facility_id);
					if(location_ref.equals("byservice")){
					modifyRow.add(ph_service_code);
					modifyRow.add((String)hh.get("GENERIC_ID"));
					}
					else if(location_ref.equals("bygeneric")){
					modifyRow.add((String)hh.get("SERVICE_CODE"));
					modifyRow.add(ph_generic_code);
					}
					modifyData.add(modifyRow);
				}
				


	}
	HashMap tabData = new HashMap() ;
	tabData.put( "properties", getProperties() );
	tabData.put( "InsertData",insertData);
	tabData.put( "ModifyData",modifyData);

	HashMap sqlMap = new HashMap() ;
	
	
	//GenericNameForServiceHome   home=null;
	//GenericNameForServiceRemote remote=null;
	try {
				
				
				sqlMap.put( "SQL_PH_GENERIC_NAME_FOR_SERVICE_INSERT", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_SERVICE_INSERT") );
				sqlMap.put( "SQL_PH_GENERIC_NAME_FOR_SERVICE_UPDATE", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_SERVICE_UPDATE") );
	
              
	     
				if(data_change){
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_GENERIC_NAME_FOR_SERVICE") ) ;
			
				home  = (GenericNameForServiceHome) PortableRemoteObject.narrow( object, GenericNameForServiceHome.class ) ;
				remote = home.create() ;
				HashMap result = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_GENERIC_NAME_FOR_SERVICE" ),GenericNameForServiceHome.class,getLocalEJB());
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
					//map.put( "message", getMessage((String) result.get( "msgid" )) ) ;
					map.put("message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") );
				}
				else
			    {
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", result.get("msgid") ) ;
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
		
	return map ;
}

public ArrayList lookUpResult(String generic_id,String locale){

	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	ArrayList lookupResultArray = new ArrayList();	
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT5") ) ;
			//System.err.println("query------>"+ PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT5"));
			pstmt.setString( 1, generic_id ) ;
			pstmt.setString( 2,locale) ;
			pstmt.setString( 3,locale) ;
			//System.err.println("locale 3--------->"+locale);
			pstmt.setString( 4,locale) ;
			//System.err.println("locale 4--------->"+locale);
			pstmt.setString( 5,locale) ;
			//System.err.println("locale 5 --------->"+locale);
			pstmt.setString( 6,locale) ;
			//System.err.println("locale  6--------->"+locale);
			pstmt.setString( 7,locale) ;
			//System.err.println("locale 7 --------->"+locale);
			resultSet = pstmt.executeQuery() ;
			//System.err.println("resultSet---------->"+resultSet);
			while ( resultSet != null && resultSet.next() ) {
				HashMap rowSet=new HashMap();
				rowSet.put( "GENERIC_NAME",resultSet.getString( "GENERIC_NAME" ) ) ;
				String drug_class = resultSet.getString( "DRUG_CLASS" );
				if(drug_class.equals("N")){
					rowSet.put( "DRUG_CLASS","NARCOTIC" ) ;	
				}else if (drug_class.equals("G")){
					rowSet.put( "DRUG_CLASS","GENERAL" ) ;	
				}else if (drug_class.equals("C")){
					rowSet.put( "DRUG_CLASS","CONTROLLED" ) ;	
				}
				rowSet.put( "ATC_CLASS_LEV1_DESC",resultSet.getString( "ATC_CLASS_LEV1_DESC" ) ) ;
				rowSet.put( "ATC_CLASS_LEV2_DESC",resultSet.getString( "ATC_CLASS_LEV2_DESC" ) ) ;
				rowSet.put( "ATC_CLASS_LEV3_DESC",resultSet.getString( "ATC_CLASS_LEV3_DESC" ) ) ;
				rowSet.put( "ATC_CLASS_LEV4_DESC",resultSet.getString( "ATC_CLASS_LEV4_DESC" ) ) ;
				rowSet.put( "ATC_CLASS_LEV5_DESC",resultSet.getString( "ATC_CLASS_LEV5_DESC" ) ) ;
				lookupResultArray.add(rowSet);
				}
			
		} catch ( Exception e )	{
			lookupResultArray.add("Exception:"+e);
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			es.printStackTrace() ;
			}

		}
		
     //System.err.println("lookupResultArray---------->"+lookupResultArray);
		return lookupResultArray;



}

public void clear() {
        DataList=null;
		facilityid="";
		result=null;
		ph_service_code="";
		ph_generic_code="";
		location_ref="";
	      super.clear() ;
   }

	/* Function specific methods end */
}
