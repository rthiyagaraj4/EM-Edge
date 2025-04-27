/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Created on 5 Aug 2009 =====Shyampriya====
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;

public class ProductNameBean extends PhAdapter implements Serializable {

	protected String product_code			= "";
	protected String long_desc		= "";
	protected String short_desc	= "";
	protected String admixture_type				= "";
	protected String remarks		= "";
	protected String enabled_status	= "";
	
	public ProductNameBean() {
		try {
			doCommon() ;
		 }
		catch(Exception e) {e.printStackTrace();}
	}

	private void doCommon() throws Exception {
	}

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	public void clear() {
		super.clear() ;
	}

	/* ==================Getter methods ========================*/

	public String getProduct_code()
	{
		return product_code;
	}

	public String getLong_desc()
	{
		return long_desc;
	}

	public String getShort_desc()
	{
		return short_desc;
	}

	public String getAdmixture_type()
	{
		return admixture_type;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public String getEnabled_status()
	{
		return enabled_status;
	}

	/* ==================Setter methods ========================*/

	public void setProduct_code(String product_code)
	{
		this.product_code = product_code;
	}
	
	public void setLong_desc(String long_desc)
	{
		this.long_desc = long_desc;
	}
	
	public void setShort_desc(String short_desc)
	{
		this.short_desc = short_desc;
	}

	public void setAdmixture_type(String admixture_type)
	{
		this.admixture_type = admixture_type;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public void setEnabled_status(String enabled_status)
	{
		if(enabled_status.equals("") || enabled_status == null)
			enabled_status = "D";
		
			this.enabled_status = enabled_status;
	}
	
	/* ==================SetAll method ========================*/

	public void setAll(Hashtable recordSet)
	{
		if(recordSet.containsKey("product_code"))
			setProduct_code((String)recordSet.get("product_code")) ;
		if(recordSet.containsKey("long_desc"))
			setLong_desc((String)recordSet.get("long_desc")) ;
		if(recordSet.containsKey("short_desc"))
			setShort_desc((String)recordSet.get("short_desc")) ;
		if(recordSet.containsKey("admixture_type"))
			setAdmixture_type((String)recordSet.get("admixture_type")) ;
		if(recordSet.containsKey("remarks"))
			setRemarks((String)recordSet.get("remarks")) ;
		if(recordSet.containsKey("eff_status"))
			setEnabled_status((String)recordSet.get("eff_status")) ;		
	}

	/* ==================insert method ========================*/

	public HashMap insert() 
	{
		HashMap map = new HashMap() ;
		StringBuffer debug =new StringBuffer();
		map.put( "result", new Boolean( false ) ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		try
		{	
			insertData.add( product_code ) ;
			insertData.add( long_desc ) ;
			insertData.add( short_desc ) ;
			insertData.add( admixture_type ) ;
			insertData.add( remarks ) ;
			insertData.add( enabled_status ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;

			whereData.add( product_code ) ;

			HashMap tabData = new HashMap() ;

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;

			String sql_insert = "INSERT INTO PH_ADMIXTURE_PRODUCTS(PRODUCT_CODE, LONG_DESC, SHORT_DESC, ADMIXTURE_TYPE,  REMARKS, EFF_STATUS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)";
			
			String sql_select = "SELECT COUNT(ROWID) FROM PH_ADMIXTURE_PRODUCTS WHERE PRODUCT_CODE = ?";

			sqlMap.put( "InsertSQL", sql_insert );
			sqlMap.put( "SelectSQL", sql_select );
					
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;
			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() )
				{
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				}
			 else 
				 {
                    if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						{
							map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"));
						}
                    else
						{
							 map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
						}
                } // end else
				
		}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}
	
		return map;

	}

	/* ==================modify method ========================*/

	public HashMap modify() 
	{
		HashMap map = new HashMap() ;
		StringBuffer debug =new StringBuffer();
		map.put( "result", new Boolean( false ) ) ;
		ArrayList modifyData = new ArrayList() ;
		try
		{
			modifyData.add(long_desc);
			modifyData.add(short_desc);
			modifyData.add(admixture_type);
			modifyData.add(remarks);
			modifyData.add(enabled_status);
			modifyData.add( login_by_id ) ;
			modifyData.add( login_at_ws_no ) ;
			modifyData.add( login_facility_id ) ;
			modifyData.add( product_code ) ;

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);

			HashMap sqlMap = new HashMap() ;

			String sql_modify = "UPDATE PH_ADMIXTURE_PRODUCTS SET LONG_DESC=?, SHORT_DESC=?, ADMIXTURE_TYPE=?, REMARKS=?, EFF_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE PRODUCT_CODE=?";
			sqlMap.put( "ModifySQL", sql_modify);
			
			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() )		
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put("message",map.get("msgid"));	

		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}
		return map;
	}

	/* ==================getProductnameDetails method ========================*/

	public ArrayList getProductnameDetails(String product_code){
		ArrayList productnameDetails = new ArrayList();
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query            =   "";
	    try{
			sql_query               = "Select PRODUCT_CODE, LONG_DESC, SHORT_DESC, ADMIXTURE_TYPE, REMARKS, EFF_STATUS from PH_ADMIXTURE_PRODUCTS_LANG_VW where PRODUCT_CODE = ? and LANGUAGE_ID = ?";

			connection  = getConnection() ;
			pstmt       = connection.prepareStatement(sql_query) ;
			pstmt.setString(1, product_code);
			pstmt.setString(2,getLanguageId());
			resultSet   =   pstmt.executeQuery();

			if(resultSet.next()){
				productnameDetails.add(resultSet.getString("product_code"));
				productnameDetails.add(resultSet.getString("long_desc"));
				productnameDetails.add(resultSet.getString("short_desc"));
				productnameDetails.add(resultSet.getString("admixture_type"));
				if(resultSet.getString("remarks") == null || resultSet.getString("remarks").equals(""))
					productnameDetails.add("");
				else
				productnameDetails.add(resultSet.getString("remarks"));
					productnameDetails.add(resultSet.getString("eff_status"));
			}
		}
		catch ( Exception e ) {	
			e.printStackTrace() ;	
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return productnameDetails;
	}
}
