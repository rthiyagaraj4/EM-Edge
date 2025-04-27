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
import javax.servlet.http.HttpSession;
import eSS.Common.SsAdapter;
import eSS.SterilizationCost.*;
import java.sql.* ;

public class SterilizationCostBean extends SsAdapter implements Serializable { 

	public String group_code			=	"";
	private String group_desc			=	"";
	private String sterile_type       	=	"";
	private String sterile_cost			=	"";
	protected ArrayList result		= null;
	protected ArrayList DataList	= null;
	protected  HttpSession session = null;

	public void setGroup_code(String group_code) {
		 this.group_code = group_code.toUpperCase();
	}

	public HttpSession getSession( ) {
		 return session;
	}

	public void setSession(HttpSession session) {
		 this.session= session;
	}

	public String getGroup_code( ) {
		 return group_code;
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc= group_desc;
	}

	public String getGroup_desc( ) {
		 return group_desc;
	}

	public void setSterile_type(String sterile_type) {
		 this.sterile_type = sterile_type.toUpperCase();
	}

	public String getSterile_type( ) {
		 return sterile_type;
	}

	public void setSterile_cost(String sterile_cost) {
		 this.sterile_cost = sterile_cost;
	}

	public String getSterile_cost( ) {
		 return sterile_cost;
	}

	public String getSterile_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_SELECT_LIST")), getSterile_type());
	}


	public HashMap validate() {
		HashMap hmReturn = new HashMap();

		hmReturn.put("result",new Boolean(true));
		hmReturn.put("message","success");
	
		return hmReturn;
	}

	public ArrayList getDataList(){
		return DataList;
	}

	public HashMap insert() {
		HashMap map = new HashMap() ;
		boolean data_change=false;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;
		try {
				map.put( "result", new Boolean( true ) ) ;
				ArrayList insertData = new ArrayList() ;
				ArrayList modifyData = new ArrayList() ;
				ArrayList deleteData = new ArrayList() ;
				ArrayList insertRow = null ;
				ArrayList modifyRow = null ;
				ArrayList deleteRow = null ;
				
				for(int j=0;j<DataList.size();j++) {
				HashMap hh=new HashMap();
				hh=(HashMap) DataList.get(j);
				String oper_mode = (String)hh.get("OPER_MODE");
					if( oper_mode.equals("I") ){
						if(((String)hh.get("PROCESS")).equals("Y")){
							data_change=true;
							insertRow = new ArrayList() ;
							
							insertRow.add(group_code);
							insertRow.add((String)hh.get("STERILE_TYPE"));
							insertRow.add((String)hh.get("STERILE_COST"));
							insertRow.add(login_by_id);
							insertRow.add(login_at_ws_no);
							insertRow.add(login_facility_id);
							insertRow.add(login_by_id);
							insertRow.add(login_at_ws_no);
							insertRow.add(login_facility_id);
							insertData.add(insertRow);
						}
					}
					else if(oper_mode.equals("U")){
						data_change=true;
						modifyRow = new ArrayList() ;
						modifyRow.add((String)hh.get("STERILE_COST"));
						modifyRow.add(login_by_id);
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add(group_code);
						modifyRow.add((String)hh.get("STERILE_TYPE"));
						
						modifyData.add(modifyRow);
					}
					else if(oper_mode.equals("D")){
						data_change=true;
						deleteRow= new ArrayList() ;

						deleteRow.add(group_code);
						deleteRow.add((String)hh.get("STERILE_TYPE"));
						deleteData.add(deleteRow);
						
					}
				}
				messages.append(deleteData);
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);
				tabData.put( "ModifyData",modifyData);
				tabData.put( "DeleteData",deleteData);
				

				sqlMap.put( "SQL_SS_STERILIZATION_COST_INSERT", getSsRepositoryValue("SQL_SS_STERILIZATION_COST_INSERT") );
				sqlMap.put( "SQL_SS_STERILIZATION_COST_UPDATE", getSsRepositoryValue("SQL_SS_STERILIZATION_COST_UPDATE") );
				sqlMap.put( "SQL_SS_STERILIZATION_COST_DELETE", getSsRepositoryValue("SQL_SS_STERILIZATION_COST_DELETE") );
				
				if(data_change){
					
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_STERILIZATION_COST"),SterilizationCostHome.class,getLocalEJB());

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
						map.put( "msgid",  result.get( "msgid" ) ) ;
						map.put( "message",  getMessage(getLanguageId(),(String) result.get( "msgid" ),"SS") ) ;
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
		finally {
				try {} 
				catch( Exception ee ){
					map.put( "message",ee.getMessage() ) ;
				}
			}
		return map ;
	}

	public void clear() {
		super.clear();
		group_code			=	"";
		group_desc			=	"";
		sterile_type       	=	"";
		sterile_cost		=	"";
	}

	public void setAll(Hashtable htRecordSet){
		
	}

	public void loadData(String group_code) throws Exception {
		
		DataList=new ArrayList();

	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getSsRepositoryValue("SQL_SS_STERILIZATION_COST_SELECT") ) ;
				
			pstmt.setString( 1, group_code ) ;
			pstmt.setString( 2, group_code ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
				dataRow.put( "STERILE_TYPE",resultSet.getString( "sterile_type" ) ) ;
				dataRow.put( "SHORT_DESC",resultSet.getString( "short_desc" ) ) ;
				dataRow.put( "STERILE_COST",resultSet.getString( "Cost" ) ) ;
				dataRow.put( "EFF_STATUS","E" ) ;
				dataRow.put( "PROCESS",resultSet.getString( "selected" ) ) ;
				dataRow.put( "DBVAL",resultSet.getString( "selected" ) ) ;
				dataRow.put( "OPER_MODE","DN" ) ;
				dataRow.put( "SOURCE", "DB" ) ;
				
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


	public ArrayList getSterileTypeCodeResultPagebyGeneric (String group_code) {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		result = new ArrayList();	
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( getSsRepositoryValue("SQL_SS_STERILIZATION_COST_SELECT") ) ;
			pstmt.setString( 1, group_code ) ;
			pstmt.setString( 2, group_code ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				HashMap rowSet=new HashMap();
				  
				rowSet.put( "STERILE_TYPE",resultSet.getString( "sterile_type" ) ) ;
				rowSet.put( "SHORT_DESC",resultSet.getString( "short_desc" ) ) ;
				rowSet.put( "STERILE_COST",resultSet.getString( "Cost" ) ) ;
				rowSet.put( "EFF_STATUS","E" ) ;
				rowSet.put( "PROCESS",resultSet.getString("selected") ) ;
				result.add(rowSet);
			}
		} catch ( Exception e )	{
			result.add("Exception:"+e+"sql"+getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_SELECT_LIST"));
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

	public String getSterileName(String sterile_type){
	String sterilename="";
		for(int i=0;i<DataList.size();i++){
		HashMap nm=new HashMap();
		nm=(HashMap) DataList.get(i);
			String str_id=(String)nm.get("STERILE_TYPE");
			String str_name=(String)nm.get("SHORT_DESC");

			if(str_id.equals(sterile_type)){
				sterilename=str_name;
				break;
			}
		}
	return sterilename;
	}

	public void setSterileTypeResultPage(String sterile_type,String sterile_cost,String process){
		for(int i=0;i<DataList.size();i++){
		HashMap nm=new HashMap();
		nm=(HashMap) DataList.get(i);
			String str=(String)nm.get("STERILE_TYPE");
			if(sterile_type.equals(str)){
			nm.put("STERILE_COST",sterile_cost);
			nm.put("PROCESS",process);	
			}
		}
	}

	public boolean chkDatainDB(String id,String sterile_cost){
	boolean idavail=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STERILE_TYPE");
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

public String getDataSource(String id){
	for(int j=0;j<DataList.size();j++){
		HashMap hh=new HashMap();
		hh=(HashMap) DataList.get(j);
		String str_id=(String)hh.get("STERILE_TYPE");
		String str_source =(String)hh.get("SOURCE");
			if( (str_id.equals(id)) ){
				return str_source;
			}
	 }
 return "";
}

public boolean chkUpdateYN(String id,String process,String delete_row,String dbval){
	boolean modifyyn=false;
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STERILE_TYPE");
				if(process.equals("Y") && dbval.equals("Y")){
					if(delete_row.equals("N")){
						if( (str_id.equals(id)) ){
								modifyyn=true;
								break;
						}
						else{
								modifyyn=false;
					    }
					}
					else{
					modifyyn=false;
					}
				}
		}
 return modifyyn;
}

public void replaceDataList(HashMap codeList,String id){
		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("STERILE_TYPE");
				if(str_id.equals(id))
					DataList.set(j,codeList);
		 }
}

public void setDataList(HashMap codeList){
		DataList.add(codeList);
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
		empty_match= empty_match + "RIsize: "+removeIndex.size();
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

	public ArrayList chkSterileCodeDBbySterile(String service_code){		
	ArrayList key=new ArrayList();
		for(int i=0;i<DataList.size();i++){
		HashMap nm=new HashMap();
		nm=(HashMap) DataList.get(i);		
			String str=(String)nm.get("STERILE_TYPE");
				if(service_code.equals(str)){
					key.add((String)nm.get("OPER_MODE"));
					key.add((String)nm.get("STERILE_COST"));
					key.add((String)nm.get("SOURCE"));
				}
		}
		
 return key;
}
	public String paramsInBean()
	{
		return (group_code	+ "; " + group_desc	+ "; " + sterile_type   + "; " + sterile_cost	+ "; " + result	+ "; " + DataList);
	}
} 
