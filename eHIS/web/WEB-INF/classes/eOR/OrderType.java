/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR ;

import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import eCommon.SingleTableHandler.* ;

import eOR.Common.* ;
import eCommon.Common.*;


public class OrderType extends eOR.Common.OrAdapter implements Serializable {
	protected String order_type_code			= "" ;
	protected String long_desc					= "" ;
	protected String short_desc					= "" ;
	protected String order_category				= "" ;
	protected String eff_status					= "" ;
	protected String regn_reqd_yn				= "" ;
	protected String freq_applicable_yn			= "" ;
	protected String auto_report_text			= "" ;
	protected String soft_stop_yn				= "" ;
    protected String cont_order_yn				= "" ;
	
//	protected String appt_reqd_yn				= "Y" ;

	protected String freq_insert_applicable_yn		= "" ;
    protected String soft_stop_insert_applicable_yn	= "" ;
    protected String cont_order_insert_applicable_yn= "" ;

    protected String freq_update_allow_yn		= "" ;
    protected String soft_stop_update_allow_yn	= "" ;
    protected String cont_order_update_allow_yn	= "" ;

	/* Set Methods Start */
	public void setOrderTypeCode( String order_type_code ) {
		this.order_type_code = order_type_code  ;
	}
	public void setLongDesc( String long_desc ) {
		this.long_desc		= long_desc  ;
	}
	public void setShortDesc( String short_desc ) {
		this.short_desc		= short_desc  ;
	}
	public void setOrderCategoryCode( String order_category ) {
		this.order_category = order_category  ;
	}
	public void setEffStatus( String eff_status ) {
		eff_status			= (eff_status.trim().equals("")) ? "D":eff_status;
		this.eff_status		= eff_status  ;
	}
	public void setRegnReqdYn( String regn_reqd_yn ) {
		regn_reqd_yn		= (regn_reqd_yn.trim().equals("")) ? "N":regn_reqd_yn;
		this.regn_reqd_yn	= regn_reqd_yn  ;
	}
	public void setFreqApplicableYn( String freq_applicable_yn ) {
		freq_applicable_yn		= (freq_applicable_yn.trim().equals("")) ? "N":freq_applicable_yn;
		this.freq_applicable_yn = freq_applicable_yn  ;
	}
	public void setAutoReport( String auto_report_text ) {
		this.auto_report_text = auto_report_text  ;
	}

	public void setSoftStopYn( String soft_stop_yn ) {
		soft_stop_yn		= (soft_stop_yn.trim().equals("")) ? "N":soft_stop_yn;
		this.soft_stop_yn	= soft_stop_yn  ;
	}
	public void setContOrderYn( String cont_order_yn ) {
		cont_order_yn		= (cont_order_yn.trim().equals("")) ? "N":cont_order_yn;
		this.cont_order_yn	= cont_order_yn  ;
	}

	public void setFreqUpdateAllowYn( String freq_update_allow_yn ) {
		freq_update_allow_yn= (freq_update_allow_yn.trim().equals("")) ? "N":freq_update_allow_yn;
		this.freq_update_allow_yn	= freq_update_allow_yn  ;
	}

	public void setSoftStopUpdateAllowYn( String soft_stop_update_allow_yn ) {
		soft_stop_update_allow_yn= (soft_stop_update_allow_yn.trim().equals("")) ? "N":soft_stop_update_allow_yn;
		this.soft_stop_update_allow_yn	= soft_stop_update_allow_yn  ;
	}

	public void setContOrderUpdateAllowYn( String cont_order_update_allow_yn ) {
		cont_order_update_allow_yn= (cont_order_update_allow_yn.trim().equals("")) ? "N":cont_order_update_allow_yn;
		this.cont_order_update_allow_yn	= cont_order_update_allow_yn  ;
	}

	public void setFreqInsertApplicableYn( String freq_insert_applicable_yn ) {
		freq_insert_applicable_yn= (freq_insert_applicable_yn.trim().equals("")) ? "N":freq_insert_applicable_yn;
		this.freq_insert_applicable_yn	= freq_insert_applicable_yn  ;
	}
	public void setSoftStopInsertApplicableYn( String soft_stop_insert_applicable_yn ) {
		soft_stop_insert_applicable_yn= (soft_stop_insert_applicable_yn.trim().equals("")) ? "N":soft_stop_insert_applicable_yn;
		this.soft_stop_insert_applicable_yn	= soft_stop_insert_applicable_yn  ;
	}
	public void setContOrderInsertApplicableYn( String cont_order_insert_applicable_yn ) {
		cont_order_insert_applicable_yn= (cont_order_insert_applicable_yn.trim().equals("")) ? "N":cont_order_insert_applicable_yn;
		this.cont_order_insert_applicable_yn	= cont_order_insert_applicable_yn  ;
	}

	/* Set Methods End */

	/* Get Methods Start */
	public String getOrderTypeCode() {
		return this.order_type_code  ;
	}
	public String getLongDesc() {
		return this.long_desc  ;
	}
	public String getShortDesc() {
		return this.short_desc  ;
	}
	public String getOrderCategoryCode() {
		return this.order_category;
	}
	public String getEffStatus() {
		return this.eff_status;
	}
	public String getRegnReqdYn() {
		return this.regn_reqd_yn;
	}
	public String getFreqApplicableYn() {
		return this.freq_applicable_yn;
	}
	public String getAutoReport() {
		return this.auto_report_text;
	}

	public String getSoftStopYnYn() {
		return this.soft_stop_yn;
	}
	public String getContOrderYn() {
		return this.cont_order_yn;
	}

	public String getFreqUpdateAllowYn() {
		return this.freq_update_allow_yn;
	}
	public String getSoftStopUpdateAllowYn() {
		return this.soft_stop_update_allow_yn;
	}
	public String getContOrderUpdateAllowYn() {
		return this.cont_order_update_allow_yn;
	}
	public String getFreqInsertApplicableYn() {
		return this.freq_insert_applicable_yn;
	}
	public String getSoftStopInsertApplicableYn() {
		return this.soft_stop_insert_applicable_yn;
	}
	public String getContOrderInsertApplicableYn() {
		return this.cont_order_insert_applicable_yn;
	}

	/* Get Methods End */
	/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		//Connection connection 		= null;
		//PreparedStatement pstmt 	= null;
		//ResultSet resultSet 		= null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

	public HashMap insert() {

      HashMap map			= new HashMap() ;
	  StringBuffer tmpBuff	= new StringBuffer();
	   map.put( "result", new Boolean( false ) ) ;

	   ArrayList insertData = new ArrayList() ;
		 insertData.add( order_type_code ) ;
		 insertData.add( long_desc ) ;
		 insertData.add( short_desc ) ;
		 insertData.add( order_category ) ;
		 insertData.add( freq_applicable_yn ) ;
		 insertData.add( soft_stop_yn ) ;
		 insertData.add( cont_order_yn) ;

		 insertData.add( "X") ;
		 insertData.add( "X") ; //"pin_applicable_on_result_yn"

		 insertData.add( regn_reqd_yn) ;
		 insertData.add( eff_status ) ;
		 insertData.add( login_by_id ) ;
		 insertData.add( login_at_ws_no ) ;
		 insertData.add( login_facility_id ) ;
		 insertData.add( login_by_id ) ;
		 insertData.add( login_at_ws_no ) ;
		 insertData.add( login_facility_id ) ;
		 insertData.add( auto_report_text ) ;
	
//System.out.println("=========auto_report_text======"+auto_report_text+"====");
	   ArrayList whereData = new ArrayList() ;
		 whereData.add( order_type_code ) ;

	   HashMap tabData = new HashMap() ;
		tabData.put( "InsertData", insertData);
		tabData.put( "WhereData", whereData);
		tabData.put( "properties",	getProperties() ) ;

		insertData=null;
		whereData=null;

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", OrRepository.getOrKeyValue("SQL_OR_ORDER_TYPE_DUPLICATE_SELECT") );
			sqlMap.put( "InsertSQL", OrRepository.getOrKeyValue("SQL_OR_ORDER_TYPE_INSERT") );
		}catch(Exception e){
			e.printStackTrace() ;
		}
		//SingleTableHandlerHome home		= null;
		//SingleTableHandlerRemote remote = null;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote		  = home.create() ;
				map			  = remote.insert( tabData, sqlMap ) ;*/
				
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
				argArray=null;
				paramArray=null;

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} 
			finally {
				 clear();
			/*try {
					if( remote != null ) remote.remove() ;
				} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}*/
			}
			return map ;
	} // end of insert



	public HashMap modify() {

      HashMap map = new HashMap() ;
	  StringBuffer tmpBuff = new StringBuffer();

	  ArrayList formData = new ArrayList() ;

		formData.add( login_by_id ) ;
		formData.add( login_at_ws_no ) ;
		formData.add( login_facility_id ) ;

		formData.add( long_desc ) ;
		formData.add( short_desc ) ;
		formData.add( order_category ) ;
		formData.add( freq_applicable_yn ) ;
		formData.add( soft_stop_yn ) ;
		formData.add( cont_order_yn) ;

		formData.add( regn_reqd_yn) ;
		formData.add( eff_status ) ;
		formData.add( auto_report_text ) ;
		formData.add( order_type_code ) ;
		

	  HashMap tabData = new HashMap() ;
		 tabData.put( "properties", getProperties() );
		 tabData.put( "ModifyData",formData);
			
		formData=null;

	  HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "ModifySQL",  OrRepository.getOrKeyValue("SQL_OR_ORDER_TYPE_UPDATE") );
		}catch(Exception e){
			e.printStackTrace() ;
		}

		//SingleTableHandlerHome home		= null;
		//SingleTableHandlerRemote remote = null;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote		  = home.create() ;
				map			  = remote.modify( tabData, sqlMap ) ;*/


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
				argArray=null;
				paramArray=null;
				
				map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				map.put("traceVal", (String)tmpBuff.toString());
			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
						if( remote != null ) remote.remove() ;
					} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
			}*/
		}
		map.put("traceVal", (String)tmpBuff.toString());
		tmpBuff.setLength(0);
		return map ;
	} // end of update

	public void clear() {
		order_type_code		= "" ;
		long_desc			= "" ;
		short_desc			= "" ;
		order_category		= "" ;
		eff_status			= "" ;
		regn_reqd_yn		= "" ;
		freq_applicable_yn  = "" ;
		auto_report_text	= "" ;
		soft_stop_yn		= "" ;
		cont_order_yn		= "" ;

		freq_update_allow_yn			= "" ;
	    soft_stop_update_allow_yn		= "" ;
		cont_order_update_allow_yn		= "" ;
		freq_insert_applicable_yn		= "" ;
		soft_stop_insert_applicable_yn	= "" ;
		cont_order_insert_applicable_yn	= "" ;

		super.clear() ;
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("order_type_code"))
			setOrderTypeCode((String)recordSet.get("order_type_code")) ;
		if(recordSet.containsKey("long_desc"))
			setLongDesc((String)recordSet.get("long_desc")) ;
		if(recordSet.containsKey("short_desc"))
			setShortDesc((String)recordSet.get("short_desc")) ;
		if(recordSet.containsKey("order_category"))
			setOrderCategoryCode((String)recordSet.get("order_category")) ;
		if(recordSet.containsKey("eff_status_yn"))
			setEffStatus((String)recordSet.get("eff_status_yn")) ;
		if(recordSet.containsKey("regn_reqd_yn"))
			setRegnReqdYn((String)recordSet.get("regn_reqd_yn")) ;
		if(recordSet.containsKey("frequency"))	// Hidden Field
			setFreqApplicableYn((String)recordSet.get("frequency")) ;
		if(recordSet.containsKey("softStop"))
			setSoftStopYn((String)recordSet.get("softStop")) ;
		if(recordSet.containsKey("contOrder"))
			setContOrderYn((String)recordSet.get("contOrder")) ;
		if(recordSet.containsKey("auto_report_text"))
			setAutoReport((String)recordSet.get("auto_report_text")) ;
		
		
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		try {
			
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_TYPE_SELECT") ) ;
			pstmt.setString( 1, order_type_code ) ;
			resultSet	= pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				setOrderTypeCode( resultSet.getString(	"order_type_code" ) ) ;
				setLongDesc( resultSet.getString(	"long_desc" ) ) ;
				setShortDesc( resultSet.getString(	"short_desc" ) ) ;
				setOrderCategoryCode( resultSet.getString(	"order_category" ) ) ;
				setEffStatus( resultSet.getString(	"eff_status" ) ) ;
				setRegnReqdYn(resultSet.getString("regn_reqd_yn") ) ;
				setFreqApplicableYn( resultSet.getString("freq_applicable_yn") ) ;
				setSoftStopYn( resultSet.getString("soft_stop_yn") ) ;
				setContOrderYn( resultSet.getString("cont_order_yn") ) ;

				// Set the additional information, to allow for update or not
				setFreqUpdateAllowYn( resultSet.getString("freq_update_allow_yn") ) ;
				setSoftStopUpdateAllowYn( resultSet.getString("soft_stop_update_allow_yn") ) ;
				setContOrderUpdateAllowYn( resultSet.getString("cont_order_update_allow_yn") ) ;
				setFreqInsertApplicableYn( resultSet.getString("freq_insert_applicable_yn") ) ;
				setSoftStopInsertApplicableYn( resultSet.getString("soft_stop_insert_applicable_yn") ) ;
				setContOrderInsertApplicableYn( resultSet.getString("cont_order_applicable_yn") ) ;
				setAutoReport( resultSet.getString("dflt_auto_report_text") ) ;
			
			
			}	

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
	}
	// Function to Get the values for the Order Category Desc(List Box)

/*     public String getApptReqValue() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String appt_reqd_value      = "";
		try {
			
			connection	= getConnection();
			pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_APPT_REQD_YN_SELECT") ) ;
            pstmt.setString( 1, order_category ) ; 
			pstmt.setString( 2, order_type_code ) ;
			resultSet	= pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {

			    appt_reqd_value = resultSet.getString("appt_reqd_yn");
            //	System.err.println( " appt req val : "+appt_reqd_yn) ;
			}	
    		return appt_reqd_value;
		} 
		
		catch(Exception e){
			System.err.println(e.getMessage());
			//	System.err.println( "Error loading values from database" ) ;
			return null;
		}
		
		finally {

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
	}    */

    public String getInstallYN(String locType) throws Exception {
       
		String installed_yn = "";
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
			
		try {
			connection = getConnection() ;
			if (locType.equalsIgnoreCase("LB")) {
      				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN")) ;
	    			pstmt.setString(1,"RL");
           	}
			else if (locType.equalsIgnoreCase("RD")) {
					pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN")) ;
                    pstmt.setString(1,locType);
		   	}
			else if (locType.equalsIgnoreCase("OT")) {
					pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN")) ;
					pstmt.setString(1,locType);
		   	}			
            resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {				
				installed_yn = resultSet.getString("install_yn");			              
			}
			return installed_yn;
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;			
		}
	}


	public ArrayList getOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record			 =		null;

		ArrayList OrderCategory = new ArrayList() ;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_ORD_CATEGORY_SELECT") ) ;
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
					record = new String[10];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					record[2] = resultSet.getString( "long_desc" )  ;
					record[3] = resultSet.getString( "result_applicable_yn" )  ;
					record[4] = resultSet.getString( "freq_applicable_yn" )  ;
					record[5] = resultSet.getString( "freq_update_allow_yn" )  ;
					record[6] = resultSet.getString( "soft_stop_applicable_yn" )  ;
					record[7] = resultSet.getString( "soft_stop_update_allow_yn" )  ;
					record[8] = resultSet.getString( "cont_order_applicable_yn" )  ;
					record[9] = resultSet.getString( "cont_order_update_allow_yn" )  ;
					OrderCategory.add(record) ;
			}
			record=null;
			
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database OrderCategory" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCategory;
	}
	// get the values in the query screen to display all the descr. and value
public String getOrderCategoryValues() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
	try
		{
			connection		= getConnection();
			pstmt			= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_ORD_CATEGORY_SELECT"));
			pstmt.setString(1,language_id);
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				  description		= resultSet.getString(1);
				  value			= resultSet.getString(2);
				  sb.append(value+ "," + description + ",");
			}
			 String str =   sb.toString() ;
			 sb.setLength(0);
			 return str.substring(0, str.length()-1);			 
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		finally
		{
			try
			 {	
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			 }catch(Exception e){
				 e.printStackTrace() ;
			 }
		}
}
	/* Function specific methods end */
}
