/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

import  eCommon.SingleTableHandler.*;

public class ChartResultType extends OrAdapter implements java.io.Serializable {
	protected String chart_result_type="";
	protected String chart_result_type_desc="";
	protected String chart_horzi_desc="";
	protected String chart_no_columns="";
	protected String chart_vert_desc="";
	protected String service_code="";
	protected String eff_status="";

	
/* Set Methods Start */

	public void setChartResult( String chart_result ) {
		this.chart_result_type = chart_result  ;
	}

	public void setChartResultDesc( String chart_result_desc ) {
		this.chart_result_type_desc = chart_result_desc  ;
	}

	public void setChartHorizontalDesc( String chart_horizontal_desc ) {
		this.chart_horzi_desc = chart_horizontal_desc  ;
	}

	public void setChartNoCols( String chart_no_cols ) {
		this.chart_no_columns = chart_no_cols  ;
	}

	public void setChartVerticalDesc( String chart_vetical_desc ) {
		this.chart_vert_desc = chart_vetical_desc  ;
	}

	public void setServiceCode( String service_code ) {
		this.service_code = service_code  ;
	}


	public void setEnable( String enable ) {
		 if(enable.trim().equals("") )
			this.eff_status = "D";
			else
			this.eff_status=  enable;
	}

/* Set Methods End */


/* Get Methods Start */
	public String getChartResult() {
		return this.chart_result_type ;
	}

	public String getChartResultDesc() {
		return this.chart_result_type_desc ;
	}

	public String getChartHorizontalDesc() {
		return this.chart_horzi_desc ;
	}

	public String getChartNoCols() {
		return this.chart_no_columns ;
	}

	public String getChartVerticalDesc() {
		return this.chart_vert_desc ;
	}

	public String getServiceCode( ) {
		return this.service_code ;
	}


	public String getEnable() {
		return this.eff_status;
	}
	
/* Get Methods End */

	



/* Over-ridden Adapter methods start here */
/*
public HashMap validate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

*/

public HashMap insert(){
	

	HashMap map			= new HashMap() ;
   map.put( "result", new Boolean( false ) ) ;
   
	   ArrayList insertData = new ArrayList() ;
		  insertData.add( chart_result_type ) ;
		  insertData.add( chart_result_type_desc ) ;
		  insertData.add( chart_horzi_desc ) ;
		  insertData.add( chart_no_columns ) ;
		  insertData.add( chart_vert_desc ) ;
		  insertData.add( service_code ) ;
		  insertData.add( eff_status ) ;
		  insertData.add( login_by_id ) ;
		  insertData.add( login_at_ws_no ) ;
		  insertData.add( login_facility_id ) ;
		  insertData.add( login_by_id ) ;
		  insertData.add( login_at_ws_no ) ;
		  insertData.add( login_facility_id ) ;
 
		ArrayList whereData = new ArrayList() ;
		 whereData.add( chart_result_type ) ;
	
		HashMap tabData = new HashMap() ;
		tabData.put( "InsertData", insertData);
		tabData.put( "WhereData", whereData);
		tabData.put( "properties",	getProperties() ) ;

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE_DUPLICATE_CHK") );
			sqlMap.put( "InsertSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE_INSERT") );
					 
		}catch(Exception e){
			e.printStackTrace();
		}

		

		//SingleTableHandlerHome home		= null;
		//SingleTableHandlerRemote remote = null;
		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabData;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);	

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
		
				}

				return map ;

			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
			/*try {
					if( remote != null ) remote.remove() ;
				} catch( Exception ee ) {

					map.put( "message", ee.getMessage() ) ;
				}*/
			}
			return map ;
	} // end of insert



public HashMap modify() {

      HashMap map = new HashMap() ;
	 ArrayList modifyData = new ArrayList() ;
		
		modifyData.add( chart_result_type_desc ) ;
		modifyData.add( chart_horzi_desc ) ;
		modifyData.add( chart_no_columns ) ;
		modifyData.add( chart_vert_desc ) ;
		modifyData.add( service_code ) ;
		modifyData.add( eff_status ) ;
        modifyData.add( login_by_id ) ;
		modifyData.add( login_at_ws_no ) ;
		modifyData.add( login_facility_id ) ;

		modifyData.add( chart_result_type ) ;
		
	  	HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
	  	HashMap sqlMap = new HashMap() ;

	  	try{
			sqlMap.put( "ModifySQL", OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}
		//SingleTableHandlerHome home		= null;
		//SingleTableHandlerRemote remote = null;
		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabData;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);	

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;


				//String strErr = ((String)map.get( "traceVal"));
				 // map.put( "message", (String) map.get( "msgid" )) ;

                  map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				       // map.put("traceVal", (String)traceVals.toString());







			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
						if( remote != null ) remote.remove() ;
					} catch( Exception ee ) {
					map.put( "message", ee.getMessage() ) ;
			}*/
		}
		//map.put("traceVal", (String)traceVals.toString());
		return map ;
	} // end of update




public void setAll( Hashtable recordSet ) {
	if(recordSet.containsKey("chart_result"))
		setChartResult((String)recordSet.get("chart_result")) ;
	if(recordSet.containsKey("chart_result_desc"))
		setChartResultDesc((String)recordSet.get("chart_result_desc")) ;
	if(recordSet.containsKey("chart_horizontal_desc"))
		setChartHorizontalDesc((String)recordSet.get("chart_horizontal_desc")) ;
	if(recordSet.containsKey("chart_no_cols"))
		setChartNoCols((String)recordSet.get("chart_no_cols")) ;
	if(recordSet.containsKey("chart_vetical_desc"))
		setChartVerticalDesc((String)recordSet.get("chart_vetical_desc")) ;
	if(recordSet.containsKey("service_code"))
		setServiceCode((String)recordSet.get("service_code")) ;
	if(recordSet.containsKey("enable"))
		setEnable((String)recordSet.get("enable")) ;

	
}

public void clear() {

	
		 chart_result_type="";
		 chart_result_type_desc="";
		 chart_horzi_desc="";
		 chart_no_columns="";
		 chart_vert_desc="";
		 service_code="";
		 eff_status="";
		
		super.clear() ;
	}

public String getServiceDesc(String code) throws Exception{
	
	if(code.equals(""))return null;
	String service_desc ="";
	Connection connection	=null;
	ResultSet resultSet	  	= null;
	java.sql.PreparedStatement pstmt		= null;
	try {
		connection=getConnection() ;

		pstmt	= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE_SERVICE_DESC"));
		pstmt.setString(1,code.trim());
		
			resultSet		= pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			service_desc=resultSet.getString("long_desc") ;
		
		}
		return service_desc;

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection) ;	

	}
	}





/* Over-ridden Adapter methods ends here */

}//end of main class
