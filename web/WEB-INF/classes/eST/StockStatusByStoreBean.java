/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

7/6/2021				TFS-19789				Shazana													MOHE-CRF-0084.1 
--------------------------------------------------------------------------------------------------------------------------------------------
*/

 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashtable;

public class StockStatusByStoreBean extends StTransaction implements Serializable{


	
	private String item_code;
	private String store_code;
	private String searchFunction="N";
 // private String language_id;

	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}
	/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
	public String getLanguageId() 
	{
		return this.language_id;
	}
*/
	public String getStockStatus()
	{
		return getStaticListOptionTag("A,All;S,Stock on Hand ;Z,Zero Stock;B,Below Reorder Level;");
	}

	public String getStockItem()
	{
		return getStaticListOptionTag(" ,Both;Y,Yes;N,No;");
	}

/*	public ArrayList queryResultDetails(String item_code, String store_code, String stock_level) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList expDetailsList = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_STORE") ) ;



			pstmt.setString( 1, item_code ) ;
			pstmt.setString( 2, store_code ) ;
			//pstmt.setString( 3, stock_code ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();



				dataRow.put("store_code",resultSet.getString("STORE_CODE")) ;
				dataRow.put("store_desc",resultSet.getString("STORE_DESC")) ;
				dataRow.put("item_code",resultSet.getString("ITEM_CODE")) ;
				dataRow.put("item_desc",resultSet.getString("ITEM_DESC")) ;
				dataRow.put("stock_item_yn",resultSet.getString("STOCK_ITEM_YN")) ;
				dataRow.put("qty_on_hand",resultSet.getString("QTY_ON_HAND")) ;
				dataRow.put("gen_uom_code",resultSet.getString("GEN_UOM_CODE")) ;
				dataRow.put("uom_desc",resultSet.getString("UOM_CODE")) ;
				dataRow.put("unit_cost",resultSet.getString("UNIT_COST")) ;
				dataRow.put("item_value",resultSet.getString("ITEM_VALUE")) ;
				expDetailsList.add(dataRow);
			}
			}

			catch(Exception e) {
				e.printStackTrace();
			}
			return expDetailsList;


			}
*/
	public ArrayList loadData(String item_code, String store_code, String stock_level) throws Exception{
		ArrayList listRecord =new ArrayList();
		String store_cod=store_code;
		String item_cod=item_code;
		if(!(store_code.equals("") || store_code==null))
		store_cod=store_code+"%";
		if(!(item_code.equals("") || item_code==null))
		item_cod=item_code+"%";
		String params[]={store_cod,item_cod};
		try {
			String stSQL=getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_STORE");
			listRecord = fetchRecords(stSQL.toString(),params);

			return listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	public String getSearchFunction( ) {
		 return searchFunction;
	}

	public void clear()
	{
	this.item_code="";
	this.store_code="";
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}
/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
    //added for 19789
    public String getRestrictUserAccessStore(){
    	String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT	RESTRICT_USER_ACCESS_STORE_YN FROM	st_facility_param WHERE facility_id=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("RESTRICT_USER_ACCESS_STORE_YN"); 
    	
    }

	//MOHE-ICN-0015 - brought here from jsp 
	public boolean getRestrictUserAccessStores(){
		Connection connection	 = null;  
		boolean site			 = false;
	    try {
				  
				connection = getConnection();
				site = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","ST_RESTRICT_USER_ACCESS_STORES");	
			}
			catch(Exception ex){
				ex.printStackTrace();
			} 
			finally{
				try{
					closeConnection(connection);
				} catch(Exception e) 
				{	
					e.printStackTrace();
				}
			}
		return site;
	}
}
