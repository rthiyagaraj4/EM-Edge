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

import eOR.OROrderingRule.*;


public class OrderingRulebyPatientClass extends OrAdapter implements java.io.Serializable {

	//StringBuffer traceVals = new StringBuffer();

	protected String order_category = "";
	protected String patient_class = "";
	protected String preselect_ord_type = "";
	protected String time_based_rule = "";
	protected String expiry_rule = "";
	protected String future_order = "";
	protected String futureorderduration = "";
	protected String floor_to_start_day_yn = "";

	//public String chk = "";

	public void setOrderCategory(String order_category){
		this.order_category = order_category;
	}
	public void setPatientClass(String patient_class){
		this.patient_class = patient_class;
	}
	public void setPreselectOrdType(String preselect_ord_type){
		this.preselect_ord_type = preselect_ord_type;
	}
	public void setTimeBasedRule(String time_based_rule){
		this.time_based_rule = time_based_rule;
	}
	public void setExpiryRule(String expiry_rule){
		this.expiry_rule = expiry_rule;
	}
	public void setfutureorder(String future_order){
		this.future_order = future_order;
	}
	public void setfutureorderduration(String futureorderduration){
		this.futureorderduration = futureorderduration;
	}
	public void setFloorToStartDay(String floor_to_start_day_yn){
		this.floor_to_start_day_yn = floor_to_start_day_yn;
	}



	public String getOrderCategory(){
		return order_category;
	}
	public String getPatientClass(){
		return patient_class;
	}
	public String getPreselectOrdType(){
		return preselect_ord_type;
	}
	public String getTimeBasedRule(){
		return time_based_rule;
	}
	public String getExpiryRule(){
		return expiry_rule;
	}
	public String getfutureorder(){
		return future_order;
	}
	public String getfutureorderduration(){
		return futureorderduration;
	}
	public String getFloorToStartDay(){
		return floor_to_start_day_yn;
	}

/**
	This will check the preselect_ord_type for the module from OR_PARAM table
	@return		:	String
*/

	public String getPreselectOrderType () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String preselect_ord_type	= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_PRE_SELECT") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				preselect_ord_type = resultSet.getString( "presel_order_type_code_yn" )  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return preselect_ord_type;
	}



/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			//acess rule changes start
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt = connection.prepareStatement( "SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? and order_category <> 'CS' ORDER BY short_desc");
			//end
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;
				String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

	public ArrayList getPatientClass(String ord_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList arlPatientClass = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_SELECT") ) ;
			pstmt.setString(1, (String)ord_cat);
			pstmt.setString(2, (String)ord_cat);
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[8];
				record[0] = resultSet.getString( "patient_class" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;
				record[2] = resultSet.getString( "preselect_order_type_code_yn" )  ;
				record[3] = resultSet.getString( "place_order_expiry_rule" )  ;
				record[4] = resultSet.getString( "place_order_expiry_period" )  ;
				record[5] = resultSet.getString( "future_order_period" )  ;
				record[6] = resultSet.getString( "future_order_period_unit" )  ;
				record[7] = resultSet.getString( "floor_to_start_day_yn" )  ;

				arlPatientClass.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return arlPatientClass;
	}


	public int checkExists(String ord_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		int totalCount = 0;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_EXISTS") ) ;
			pstmt.setString(1, (String)ord_cat);

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				totalCount = resultSet.getInt("total")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return totalCount;
	}


	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

//public static final String ORDERING_RULE_BY_PATIENT_CLASS_INSERT = "Insert Into  or_param_by_category_ptcl (ORDER_CATEGORY,PATIENT_CLASS,PRESELECT_ORDER_TYPE_CODE_YN,PLACE_ORDER_EXPIRY_RULE,PLACE_ORDER_EXPIRY_PERIOD,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)"

		HashMap tabdata = new HashMap() ;
		tabdata.put("order_category",order_category ) ;
		tabdata.put("patient_class",	patient_class ) ;
		tabdata.put("preselect_ord_type",preselect_ord_type);
		tabdata.put("time_based_rule",time_based_rule);
		tabdata.put("expiry_rule",expiry_rule);
		tabdata.put("future_order",future_order);
		tabdata.put("futureorderduration",futureorderduration);
		tabdata.put("floor_to_start_day_yn",floor_to_start_day_yn);

		tabdata.put( "added_by_id",			login_by_id ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;

		tabdata.put( "modified_by_id",		login_by_id ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;

//System.out.println("tabdata"+tabdata);
		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "ORDERING_RULE_BY_PATIENT_CLASS_INSERT", OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_INSERT") );
		}catch(Exception e){e.printStackTrace();
		}

		//OROrderingRuleHome home = null ;
		//OROrderingRuleRemote remote = null ;

		try {
				tabdata.put( "properties", getProperties() );
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("ORDERING_RULE_PATIENT_CLASS")) ;
				home  = (OROrderingRuleHome) PortableRemoteObject.narrow( object, OROrderingRuleHome.class ) ;
				
				remote = home.create() ;
				map = remote.insert( tabdata, sqlMap ) ;*/
				//map = insert( tabdata, sqlMap ) ;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDERING_RULE_PATIENT_CLASS"), OROrderingRuleHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;
				
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}

		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		return map ;

	}



	public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabdata = new HashMap() ;
		tabdata.put("order_category",order_category ) ;
		tabdata.put("patient_class",	patient_class ) ;
		tabdata.put("preselect_ord_type",preselect_ord_type);
		tabdata.put("time_based_rule",time_based_rule);
		tabdata.put("expiry_rule",expiry_rule);
		tabdata.put("future_order",future_order);
		tabdata.put("futureorderduration",futureorderduration);
		tabdata.put("floor_to_start_day_yn",floor_to_start_day_yn);
		


		tabdata.put( "added_by_id",			login_by_id ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;

		tabdata.put( "modified_by_id",		login_by_id ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;

		//chk = preselect_ord_type;
		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "ORDERING_RULE_BY_PATIENT_CLASS_INSERT", OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_INSERT"));
			sqlMap.put( "ORDERING_RULE_BY_PATIENT_CLASS_DELETE", OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_DELETE"));
		}catch(Exception e){e.printStackTrace();
		}

		//OROrderingRuleHome home = null ;
		//OROrderingRuleRemote remote = null ;

		try {
				tabdata.put( "properties", getProperties() );
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("ORDERING_RULE_PATIENT_CLASS") ) ;
				home  = (OROrderingRuleHome) PortableRemoteObject.narrow( object, OROrderingRuleHome.class ) ;
				
				remote = home.create() ;
				map = remote.modify( tabdata, sqlMap ) ;*/
			//	map = modify( tabdata, sqlMap ) ;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDERING_RULE_PATIENT_CLASS"), OROrderingRuleHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;
				
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;

		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		return map ;

	}

//ejb method of modify - begin

/*
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {
		Connection connection = null ;
		PreparedStatement pstmt_ordering_rule = null ;

		StringBuffer traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String ORDERING_RULE_BY_PATIENT_CLASS_INSERT = (String) sqlMap.get( "ORDERING_RULE_BY_PATIENT_CLASS_INSERT" ) ;
		final String ORDERING_RULE_BY_PATIENT_CLASS_DELETE = (String) sqlMap.get( "ORDERING_RULE_BY_PATIENT_CLASS_DELETE" ) ;
		traceVals.append("modify ethod --------- before try -- ");

		int result[];
		try {
			connection = getConnection() ;
//			connection = getConnection((Properties)tabData.get( "properties" ) ) ;


			String order_category = (String) tabData.get( "order_category" );
			String patient_class = (String) tabData.get( "patient_class" ) ;
			String preselect_ord_type = (String) tabData.get( "preselect_ord_type" ) ;
			String time_based_rule = (String) tabData.get( "time_based_rule" ) ;
			String expiry_rule = (String) tabData.get( "expiry_rule" ) ;


			pstmt_ordering_rule		= connection.prepareStatement( ORDERING_RULE_BY_PATIENT_CLASS_DELETE) ;
			pstmt_ordering_rule.setString(1, (String)order_category);

			int deleted  = pstmt_ordering_rule.executeUpdate() ;
			traceVals.append("**** deleted records "+deleted);

			if(deleted > 0){
				pstmt_ordering_rule		= connection.prepareStatement( ORDERING_RULE_BY_PATIENT_CLASS_INSERT ) ;

				StringTokenizer stPatient_class = new StringTokenizer(patient_class,"~");
				StringTokenizer stTime_based_rule = new StringTokenizer(time_based_rule,"~");
				StringTokenizer stExpiry_rule = new StringTokenizer(expiry_rule,"~");
				StringTokenizer stPreselect_ord_type = new StringTokenizer(preselect_ord_type,"~");

				traceVals.append("**** preselect_ord_type : "+preselect_ord_type);

				String patient_classValue = "";
				String time_based_ruleValue = "";
				String expiry_ruleValue = "";
				String preselect_ord_typeValue = "";
				int count = 0;

				while(stPatient_class.hasMoreTokens()){


						patient_classValue = stPatient_class.nextToken();
						pstmt_ordering_rule.setString( 2, (String) patient_classValue ) ;

						preselect_ord_typeValue = stPreselect_ord_type.nextToken();
						pstmt_ordering_rule.setString( 3, (String) preselect_ord_typeValue ) ;

						traceVals.append("**** preselect_ord_typeValue : "+preselect_ord_typeValue);


						time_based_ruleValue = stTime_based_rule.nextToken();
					    if(time_based_ruleValue.equals(" ") || time_based_ruleValue == " "){
					    	time_based_ruleValue = null;
						}
						pstmt_ordering_rule.setString( 4, (String) time_based_ruleValue ) ;

						expiry_ruleValue = stExpiry_rule.nextToken();
					    if(expiry_ruleValue.equals(" ") || expiry_ruleValue == " "){
					    	expiry_ruleValue = null;
						}
						pstmt_ordering_rule.setString( 5, (String) expiry_ruleValue ) ;


						pstmt_ordering_rule.setString( 1, (String) order_category ) ;

						pstmt_ordering_rule.setString( 6, (String) tabData.get( "added_by_id" ) ) ;
						pstmt_ordering_rule.setString( 7, (String) tabData.get( "added_at_ws_no" ) ) ;
						pstmt_ordering_rule.setString( 8, (String) tabData.get( "added_facility_id" ) ) ;
						pstmt_ordering_rule.setString( 9, (String) tabData.get( "modified_by_id" ) ) ;
						pstmt_ordering_rule.setString( 10, (String) tabData.get( "modified_at_ws_no" ) ) ;
						pstmt_ordering_rule.setString( 11, (String) tabData.get( "modified_facility_id" ) ) ;

						traceVals.append("-- before execute bottom frame--");
						pstmt_ordering_rule.addBatch() ;
						count++;
						traceVals.append("-- after execute bottom frame--");
				}
						traceVals.append("***** Before batch update*** count --"+count);
						result = pstmt_ordering_rule.executeBatch() ;
						traceVals.append("******** result length --"+result.length);


					if ( result.length < 1 ) {
						//context.setRollbackOnly();
						messages.append( "Insert Failed" ) ;
					}
					if(result.length >= 1){
							connection.commit() ;
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message", "Operation Completed Successfully..." ) ;
							//messages.append( "Operation Completed Successfully..." ) ;
							messages.append( "RECORD_INSERTED" ) ;
					}
			}
		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

			try {
				//context.setRollbackOnly();
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_ordering_rule != null ) {
					pstmt_ordering_rule.close() ;
				}
				if(connection != null) {
					closeConnection(connection);
//					closeConnection(connection,(Properties)tabData.get( "properties" ));
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}


//ejb method of modify - end
*/



/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {

//System.out.println("recordSet"+recordSet);
		if(recordSet.containsKey("order_category")){
			setOrderCategory((String)recordSet.get( "order_category" ));
		}
		if(recordSet.containsKey("patientClass")){
			setPatientClass((String)recordSet.get( "patientClass" ));
		}
		if(recordSet.containsKey("preselect_ord_type")){
			setPreselectOrdType((String)recordSet.get("preselect_ord_type"));
		}
		if(recordSet.containsKey("time_based_rule")){
			setTimeBasedRule((String)recordSet.get( "time_based_rule" ));
		}

		if(recordSet.containsKey("expiry_rule")){
			setExpiryRule((String)recordSet.get( "expiry_rule" ));
		}
		if(recordSet.containsKey("future_order")){
			setfutureorder((String)recordSet.get( "future_order" ));
		}
		if(recordSet.containsKey("futureorderduration")){
			setfutureorderduration((String)recordSet.get( "futureorderduration" ));
		}
		if(recordSet.containsKey("floor_to_start_day_yn")){
			setFloorToStartDay((String)recordSet.get( "floor_to_start_day_yn" ));
		}
		this.mode = (String)recordSet.get( "mode" );
	}

	public void clear() {
		super.clear() ;
	}



}
