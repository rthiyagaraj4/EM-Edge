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

public class DrugDrugTypeBean extends PhAdapter implements Serializable{
	String drug_code="";
	
	ArrayList drugTypeDetails = null;
/*
	drugTypeDetails structure
index - value
	0 - DrugTYpeCode
	1 - DrugTypeDesc
	2 - DBAction
	3 - EffStatus
	4 - ChangedYN
*/

	 public DrugDrugTypeBean(){
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
	public void setDrugCode(String drug_code){
		this.drug_code=drug_code;
	}
	public void setdrugTypeDetails(ArrayList drugTypeDetails){
		this.drugTypeDetails=drugTypeDetails;
	}
	//End of Set Methods

	//Start of Get Methods
	public String getDrugCode(){
		return this.drug_code;
	}
	public ArrayList getdrugTypeDetails()	{
		return this.drugTypeDetails;
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
	}

	//Modify Method
/*	public HashMap modify() {

		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0");
        return map ;
   }
*/
	public ArrayList getDrugTypeList(String drug_code){
		//System.err.println("getDrugTypeList----------->");
		Connection connection	 =	null ;
		PreparedStatement pstmt_select_drugtype =	null ;
		ResultSet rset_drug_type = null;
		drugTypeDetails = new ArrayList();
		setDrugCode(drug_code);
		try{
			String sql_select_drug_type = PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_SELECT" );
			connection = getConnection();
			pstmt_select_drugtype = connection.prepareStatement(sql_select_drug_type);
			pstmt_select_drugtype.setString(1, drug_code);
			pstmt_select_drugtype.setString(2, drug_code);
			rset_drug_type = pstmt_select_drugtype.executeQuery();
			while((rset_drug_type!= null)&& (rset_drug_type.next())){
				drugTypeDetails.add(rset_drug_type.getString("DRUG_TYPE"));
				drugTypeDetails.add(rset_drug_type.getString("DRUG_TYPE_DESC"));
				drugTypeDetails.add(rset_drug_type.getString("DB_ACTION"));
				drugTypeDetails.add(rset_drug_type.getString("EFF_STATUS"));
				drugTypeDetails.add("N");
			}

			try{
				closeResultSet(rset_drug_type);
				closeStatement(pstmt_select_drugtype);
				closeConnection(connection);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rset_drug_type);
				closeStatement(pstmt_select_drugtype);
				closeConnection(connection);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return drugTypeDetails;
	}

	public void clear() {
		this.drug_code="";
		this.drugTypeDetails= null;
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
		String drug_type_code="";
		String db_action="";
		String changed="";
		String eff_status="";
		String msgId="";
		try{
			String sql_insert =PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_INSERT" );
			String sql_update = PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_UPDATE" );
			while((drugTypeDetails != null) && (count < drugTypeDetails.size())){
				drug_type_code=(String)drugTypeDetails.get(index++);
				index++;//drug_type desc
				db_action=(String)drugTypeDetails.get(index++);;        
				eff_status=(String)drugTypeDetails.get(index++);;        
				changed=(String)drugTypeDetails.get(index++);;          

				if(changed.equals("Y")){
					if(db_action.equals("I")){
						insertRow = new ArrayList();
						insertRow.add(drug_code);
						insertRow.add(drug_type_code);
						insertRow.add("E");
						insertRow.add(login_by_id);     
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);     
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertData.add(insertRow);
					}
					else{
						modifyRow = new ArrayList();
						modifyRow.add(eff_status);
						modifyRow.add(login_by_id);     
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add(drug_code);
						modifyRow.add(drug_type_code);
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
			paramArray[0] = tabData.getClass(); ;
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
}
