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


public class TPNStockItemBean extends PhAdapter implements Serializable {

	protected String item_code                = "" ;
	protected String item_desc                = "" ;
	protected String tpn_item_yn        	  = "N" ;
	protected String gen_uom_code       	  = "" ;


	public TPNStockItemBean() throws Exception
	{
		try {
			doCommon();
		}catch(Exception e) {
		e.printStackTrace();}
	}


	private void doCommon() throws Exception 
	{
	}

public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	/* Set Methods Start */
	public void setItemCode( String item_code ) {
		this.item_code = item_code  ;
	}

	public void setItemDesc( String short_desc ) {
		this.item_desc = short_desc  ;
	}

	public void setUomCode( String gen_uom_code ) {
		this.gen_uom_code = gen_uom_code  ;
	}

	public void setTPNItemYn(String tpn_item_yn){
		this.tpn_item_yn=tpn_item_yn;
	}
	/* Set Methods End */

	/* Get Methods Start */

	public String getItemCode() {
		return this.item_code;
	}

	public String getItemDesc() {
		return this.item_desc;
	}

	public String getUomCode() {
		return this.gen_uom_code;
	}

	public String getTPNItemYn(){
		return this.tpn_item_yn;
	}
	/* Get Methods End */

/*	public void loadData() throws Exception {
		HashMap	hmRecord=null;
		hmRecord=fetchRecord(PhRepository.getPhKeyValue("SQL_PH_ITEM_UOM_VALUE"),item_code);*/
		

	/* Over-ridden Adapter methods start here */
		public HashMap modify()
		{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;

		ArrayList ModifyData = new ArrayList();
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(tpn_item_yn);
		ModifyData.add(item_code);
  	HashMap tabData = new HashMap() ;


		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;

		////System.out.println("ModifyData " + ModifyData);

		HashMap sqlMap = new HashMap() ;

		//SingleTableHandlerRemote remote = null ;
try
		{
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ITEM_UPDATE_QUERY") );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
			{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		//	debug.append((Boolean) map.get( "result" ));

				if( ((Boolean) map.get( "result" )).booleanValue() )
				{
				map.put( "result", new Boolean( true ) ) ;
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					//map.put( "flag",(Boolean) map.get( "result" ));
								map.put("flag","0");

				}
				else
				{
				//map.put( "result", new Boolean( false ) ) ;
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					//map.put( "flag",(Boolean) map.get( "result" ));
												map.put("flag","0");

							
				}

			}
			catch(Exception e)
			{
				//System.err.println( "Error Calling EJB : "+e ) ;
				//map.put( "message", e.getMessage() ) ;
				//map.put( "flag",(Boolean) map.get( "result" ));
				e.printStackTrace() ;
			}
	/*	finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				}
				catch( Exception ee )
				{
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}
			}*/

//System.out.println("MAPMAPMAP"+map);
		return map ;
	}

	public void clear()
	{
	//	item_code              ="";
	//	tpn_item_yn	   = "N";
//gen_uom_code="";
		super.clear() ;
	}

public HashMap insert()
		{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;

		ArrayList InsertData = new ArrayList();
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(tpn_item_yn);
		InsertData.add(item_code);
  	HashMap tabData = new HashMap() ;


		tabData.put( "InsertData",	InsertData ) ;
		tabData.put( "properties",	getProperties() ) ;

		////System.out.println("ModifyData " + ModifyData);

		HashMap sqlMap = new HashMap() ;

		//SingleTableHandlerRemote remote = null ;
try
		{
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ITEM_UPDATE_QUERY") );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
			{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		//	debug.append((Boolean) map.get( "result" ));

				if( ((Boolean) map.get( "result" )).booleanValue() )
				{
				map.put( "result", new Boolean( true ) ) ;
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					//map.put( "flag",(Boolean) map.get( "result" ));
								map.put("flag","0");

				}
				else
				{
				//map.put( "result", new Boolean( false ) ) ;
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					//map.put( "flag",(Boolean) map.get( "result" ));
												map.put("flag","0");

							
				}

			}
			catch(Exception e)
			{
				//System.err.println( "Error Calling EJB : "+e ) ;
				//map.put( "message", e.getMessage() ) ;
				//map.put( "flag",(Boolean) map.get( "result" ));
				e.printStackTrace() ;
			}
	/*	finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				}
				catch( Exception ee )
				{
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}
			}*/

//System.out.println("MAPMAPMAP"+map);
		return map ;
	}

	public void setAll( Hashtable recordSet ) {
//This function also is called by the controller when apply is pressed.recordSet is nothing but a hashtable containing all form values

	setMode((String)recordSet.get("mode")) ;
if(recordSet.containsKey("item_code"))
			setItemCode((String)recordSet.get("item_code")) ;
		if(recordSet.containsKey("tpn_item_yn")&& (!((String)recordSet.get("tpn_item_yn")).equals(""))){
			setTPNItemYn((String)recordSet.get("tpn_item_yn")) ;
		}
		else{
			setTPNItemYn("N") ;}
		//	modify();

		
		
	}

/* Over-ridden Adapter methods end here */
/* Function specific methods start */



public ArrayList getItemDetails(String item_code)
	{
//System.out.println("inside the new method inte_Code= "+item_code);
        ArrayList  result			= new ArrayList();
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
	pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ITEM_UOM_VALUE")) ;		
	pstmt.setString(1,item_code.trim());
	pstmt.setString(2, getLanguageId());

				resultSet	= pstmt.executeQuery();

           while( resultSet.next() ) {
			   //System.out.println("&&&&&&&&&The Result Set"+resultSet);
		/*setItemDesc((String)resultSet.getString("SHORT_DESC") );
		setUomCode((String)resultSet.getString("GEN_UOM_CODE" ) ) ;
		setTPNItemYn((String)resultSet.getString("TPN_ITEM_YN" ) ) ;*/
	
				result.add(checkForNull(resultSet.getString("ITEM_CODE")));
				result.add(checkForNull(resultSet.getString("SHORT_DESC")));
				result.add(checkForNull(resultSet.getString("GEN_UOM_CODE")));
				result.add(checkForNull(resultSet.getString("TPN_ITEM_YN")));
				//setTPNItemYn(checkForNull(resultSet.getString("TPN_ITEM_YN")));
			  
			}

				//System.out.println("result==============="+result);
			} 

 
        catch ( Exception e ) {
           // System.err.println( "Error loading values from database" ) ;
            e.printStackTrace() ;
              }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		//System.out.println("@@ result= "+result);
		return(result);
	}


}
