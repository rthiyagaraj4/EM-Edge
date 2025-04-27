/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */ 
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;
import eSS.Common.*;

import java.sql.* ;


import eSS.AlternateGroup.*;
import java.sql.*;

public class AlternateGroupBean extends MasterCodeBean implements Serializable { 

	private String group_code	=	"";
	private String group_desc	=	"";
	private String group_type	=	"";
	private String usage_code	=	"";
	private String surgery_code	=	"";
	protected ArrayList result		= null;
	protected ArrayList  alternateGroupDetails = null;
	private String linenApplicableYN ="";//mmoh-crf-1661 
	
	public String getLinenApplicableYN() {
		return linenApplicableYN;
	}
  
	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//END


	private String records_to_delete;
	private HttpSession session;
	
	public void setalternateGroupDetails(ArrayList alternateGroupDetails){
		this.alternateGroupDetails=alternateGroupDetails;
	}

	public ArrayList getalternateGroupDetails()	{
		return this.alternateGroupDetails;
	}
	public void setGroup_code(String group_code) { 
		 this.group_code = group_code.toUpperCase();
	}

	public String getGroup_code( ) {
		 return group_code;
	}

	public void setUsage_code(String usage_code) {
		 this.usage_code = usage_code.toUpperCase();
	}

	public String getUsage_code( ) {
		 return usage_code;
	}

	public void setSurgery_code(String surgery_code) {
		 this.surgery_code = surgery_code.toUpperCase();
	}

	public String getSurgery_code( ) {
		 return surgery_code;
	}
	

	public void setGroup_type(String group_type) {
		 this.group_type = group_type.toUpperCase();
	}

	public String getGroup_type( ) {
		 return group_type;
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc = group_desc;
	}

	public String getGroup_desc( ) {
		 return group_desc;
	}

	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete =  records_to_delete;
	}

	public String getRecords_to_delete() {
		 return records_to_delete;
	}

	public String getGroup_type_List(){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		 java.util.ResourceBundle com_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		 if(getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y")){   
				return getStaticListOptionTag( "E,"+ss_labels.getString("eSS.Set.label")+";T,"+ss_labels.getString("eSS.Tray.label")+";P,"+ss_labels.getString("eSS.SoftPack.label")+";S,"+com_labels.getString("Common.single.label")+";L,"+ss_labels.getString("eSS.Linen.label"), getGroup_type());

		 }else{
				return getStaticListOptionTag( "E,"+ss_labels.getString("eSS.Set.label")+";T,"+ss_labels.getString("eSS.Tray.label")+";P,"+ss_labels.getString("eSS.SoftPack.label")+";S,"+com_labels.getString("Common.single.label"), getGroup_type());

		 }
	}



public void setAll(Hashtable htRecordSet){
		
	}

	public HashMap validate() {
		HashMap hmReturn		=	new HashMap();
		hmReturn.put("result",TRUE);
		return hmReturn;
	}

	public void clear() {
		super.clear();
		group_code					=	""; 
		group_type					=	"";	
		group_desc					=	"";	
		records_to_delete			=	"";
		session						=	null;
		alternateGroupDetails		=	null;
		usage_code					=	"";
		surgery_code				=	"";
		linenApplicableYN           = "";//mmoh-crf-1661
	}


	public ArrayList loadData(String group_code,String group_type,String usage_desc,String surgery_type) throws Exception {
        
		alternateGroupDetails=new ArrayList();
		setGroup_code(group_code) ;
		setGroup_type(group_type) ;
		setUsage_code(usage_desc) ;
		setSurgery_code(surgery_type) ;
	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT   a.alternate_group_code   group_code ,b.short_desc, 'U' dbaction FROM ss_alternate_group a, ss_group b WHERE a.GROUP_CODE=?   AND  a.ALTERNATE_GROUP_CODE=b.group_code AND eff_status='E' UNION SELECT  group_code group_code ,short_desc,'I' dbaction FROM ss_group WHERE NOT EXISTS ( SELECT ALTERNATE_GROUP_CODE FROM ss_alternate_group WHERE ss_group.group_code = alternate_group_code) AND eff_status='E' AND group_type=? AND group_code NOT IN(?) AND NVL(USAGE_TYPE,'%')  LIKE UPPER(NVL(?,'%')) AND  	NVL(SURGERY_TYPE,'%')  LIKE UPPER(NVL(?,'%'))" ) ;
			

			pstmt.setString( 1, group_code ) ;
			pstmt.setString( 2, group_type ) ;
			pstmt.setString( 3, group_code ) ;
			pstmt.setString( 4, usage_desc ) ;
			pstmt.setString( 5, surgery_type ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 alternateGroupDetails.add(resultSet.getString( "group_code" ));
				 alternateGroupDetails.add(resultSet.getString( "short_desc" ));
				 alternateGroupDetails.add("E");
				 alternateGroupDetails.add(resultSet.getString( "dbaction" ));
				 alternateGroupDetails.add("N");
								
				
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
		return alternateGroupDetails;
	}


	public ArrayList getAlternateGroupResultPage (String group_code,String group_type,String usage_desc,String surgery_type) {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		result = new ArrayList();	
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT") ) ;
			pstmt.setString( 1, group_code ) ;
			pstmt.setString( 2, group_code ) ;
			pstmt.setString( 3, group_type ) ;
			pstmt.setString( 4, group_code ) ;
			pstmt.setString( 5, usage_desc ) ;
			pstmt.setString( 6, surgery_type ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				HashMap rowSet=new HashMap();
				  
				rowSet.put( "ALTERNATE_GROUP_CODE",resultSet.getString( "group_code" ) ) ;
				rowSet.put( "SHORT_DESC",resultSet.getString( "short_desc" ) ) ;
				rowSet.put( "EFF_STATUS","E" ) ;
				rowSet.put( "PROCESS",resultSet.getString("selected") ) ;
				result.add(rowSet);
			}
		} catch ( Exception e )	{
			result.add("Exception:"+e+"sql"+getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT"));
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


	public String getUsage_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_USAGE")), getUsage_code());
	}

	public String getSurgery_List () {
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_SURGERY")), getSurgery_code());
	}

	
public HashMap insert() {
		
       HashMap map = new HashMap() ;
		boolean data_change=false;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;
		String db_action="";
		String changed="";

		try {
			map.put( "result", new Boolean( true ) ) ;
			ArrayList insertData = new ArrayList() ;
	
			ArrayList deleteData = new ArrayList() ;
			ArrayList insertRow = new ArrayList();
			ArrayList deleteRow = null ;
			int count=0;
			//int index=0;
				while(count < alternateGroupDetails.size()){
				db_action=(String)alternateGroupDetails.get(count+3);        
				changed=(String)alternateGroupDetails.get(count+4);   
					if(changed.equals("Y")){
					if(db_action.equals("I")){
						data_change=true;
						insertRow = new ArrayList();
						insertRow.add(getGroup_code( ));
						insertRow.add((String)alternateGroupDetails.get(count));
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertData.add(insertRow);
					  }else{
						  data_change=true;
						deleteRow= new ArrayList() ;
						deleteRow.add(getGroup_code( ));
						deleteRow.add((String)alternateGroupDetails.get(count));
						deleteData.add(deleteRow);
					  }
					}
				count+=5;
			}
				
				messages.append(deleteData);
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);
				tabData.put( "DeleteData",deleteData);

	
				sqlMap.put( "SQL_SS_ALTERNATE_GROUP_INSERT", getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_INSERT") );
				sqlMap.put( "SQL_SS_ALTERNATE_GROUP_DELETE", getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_DELETE") );
				
				if(data_change){
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_ALTERNATE_GROUP"),AlternateGroupHome.class,getLocalEJB());
			
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
					map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"SS") ) ;
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
				System.out.println(e);
			}
			finally {
					try {} 
					catch( Exception ee ){
					System.err.println( ee.getMessage() ) ;
						map.put( "message",ee.getMessage() ) ;
					}
			}
		
	return map ;
 }
}


