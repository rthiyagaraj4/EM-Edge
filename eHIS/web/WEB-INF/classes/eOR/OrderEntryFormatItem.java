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

import eOR.OROrderEntryFormatItem.*;

public class OrderEntryFormatItem extends OrAdapter implements java.io.Serializable {
	protected String field_mnemonic 			= "";
	protected String field_mnemonic_desc 			= "";
	protected String field_type				 	= "";
	protected String order_category				= "";
	protected String meaning_value				= "";
	protected String min_value					= "";
	protected String max_value					= "";
	protected String single_multi				= "";
	protected String presentation_type			= "";
	protected String hint						= "";
	protected String descrete_measure			= "";
	protected String eff_status 				= "";
	protected String listValues				= "";
	protected String finalString				= "";
	public LinkedHashMap format_values			= new LinkedHashMap();
	//protected ArrayList DataList=new ArrayList();
	
	/*public void setDataList(ArrayList DataList) {
		System.out.println("@@ AssemblyDetail setDataLis =" + DataList);
		 this.DataList = DataList;
	}

	public ArrayList getDataList(){
		System.out.println("@@@ AssemblyDetail getDataList =" + DataList);
		 return DataList;
	}*/

//	public String chk = "";
//	public String chk1 = "";
	StringBuffer traceVals = new StringBuffer();

	public void setFieldMnemonic(String field_mnemonic){
		this.field_mnemonic = field_mnemonic;
	}
	public void setFieldMnemonicDesc(String field_mnemonic_desc){
		this.field_mnemonic_desc = field_mnemonic_desc;
	}
	public void setFieldType(String field_type){
		this.field_type = field_type;
	}
	public void setOrderCategory(String order_category){
		this.order_category = order_category;
	}
	public void setMeaningValue(String meaning_value){
		this.meaning_value = meaning_value;
	}
	public void setMinValue(String min_value){
		this.min_value = min_value;
	}
	public void setMaxValue(String max_value){
		this.max_value = max_value;
	}
	public void setSingleMulti(String single_multi){
		this.single_multi = single_multi;
	}
	public void setPresentationType(String presentation_type){
		this.presentation_type = presentation_type;
	}

	public void setHint(String hint){
		if (hint=="")
		{
			this.hint=field_mnemonic_desc;
		}
			else
		{
		this.hint = hint;
		}
	}
	public void setDiscreteMeasure(String descrete_measure){
		this.descrete_measure = descrete_measure;
	}
	public void setEffectiveStatus(String eff_status){
		this.eff_status= eff_status;
	}
	public void setListValues(String listValues){
		this.listValues= listValues;
	}
	public void setFinalString(String finalString){
		//System.out.println("@@ AssemblyDetail setDataLis =" + finalString);
		this.finalString= finalString;
	}

	public String getFieldMnemonic(){
		return field_mnemonic;
	}
	public String getFieldMnemonicDesc(){
		return field_mnemonic_desc;
	}
	public String getFieldType(){
		return field_type;
	}
	public String getOrderCategory(){
		return order_category;
	}
	public String getMeaningValue(){
		return meaning_value;
	}
	public String getMinValue(){
		return min_value ;
	}
	public String  getMaxValue(){
		return max_value;
	}
	public String getSingleMulti(){
		return single_multi;
	}
	public String getPresentationType(){
		return presentation_type;
	}
	public String getHint(){
		return hint;
	}
	public String getDiscreteMeasure(){
		return descrete_measure;
	}
	public String getEffectiveStatus(){
		return eff_status;
	}
	public String getListValues(){
		return listValues;
	}
	public String getFinalString(){
		//System.out.println("@@@ AssemblyDetail getDataList =" + finalString);
		return finalString;
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
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
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


/**
	This will populate all the order categories with scope of each category and creates a coma separated String of code and description
	@return		:	String
*/

	public String listOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String finalValues = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			//System.out.println("language_id"+language_id);
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {

				//finalValues += resultSet.getString( "order_category" )+","+resultSet.getString( "short_desc" )+","  ;
				finalValues =finalValues+resultSet.getString( "order_category" )+","+resultSet.getString( "short_desc" )+","  ;

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

		return finalValues;
	}

/**
	This will populate all the List Values
	@return		:	array
*/

	public String[] getDiscreteData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] numData = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DISCRETE_VAL")) ;
			pstmt.setString(1,field_mnemonic.trim());
			pstmt.setString(2,order_category.trim()) ;
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				numData[0] = resultSet.getString( "discr_msr_id" )  ;
				numData[1] = resultSet.getString( "short_desc" )  ;

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

		return numData;

	}

	public String[] getClinicalEventsData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] numData = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DISCRETE_VAL1")) ;
			pstmt.setString(1,field_mnemonic.trim());
			pstmt.setString(2,order_category.trim()) ;
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				numData[0] = resultSet.getString( "discr_msr_id" )  ;
				numData[1] = resultSet.getString( "short_desc" )  ;

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

		return numData;

	}

/**
	This will populate all the List Values
	@return		:	array
*/

	public String[] getNumericData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] numData = new String[2];

		try {
			connection = getConnection() ;
			//SELECT  min_num_value, max_num_value FROM or_order_field WHERE field_mnemonic=? AND order_category=?
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_NUMERIC_VALS") ) ;
			pstmt.setString(1,field_mnemonic.trim());
			pstmt.setString(2,order_category.trim()) ;
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				numData[0] = ""+resultSet.getFloat( "min_num_value" )  ;
				numData[1] = ""+resultSet.getFloat( "max_num_value" )  ;

//			chk = numData[0] +" == "+numData[1];


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

		return numData;

	}

/**
	This will populate all the List Values
	@return		:	ArrayList
*/

	public ArrayList getAllListData (String mnemonic, String order_category_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_LIST_VALS") ) ;
			pstmt.setString(1,mnemonic.trim());
			pstmt.setString(2,order_category_id.trim()) ;
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[3];
				record[0] = resultSet.getString( "alphanum_value" )  ;
				record[1] = resultSet.getString( "seq_num" )  ;
				record[2] = resultSet.getString( "KEY_REF" )  ;
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


/**
	This will populate all the List Values
	@return		:	ArrayList
*/

	public String[] getMainData (String mnemonic, String field_type, String order_category_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[6];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_POPULATE") ) ;
			pstmt.setString(1,mnemonic.trim());
			pstmt.setString(2,field_type.trim());
			pstmt.setString(3,order_category_id.trim()) ;
			pstmt.setString(4,mnemonic.trim());
			pstmt.setString(5,field_type.trim());
			resultSet = pstmt.executeQuery() ;

		//	chk1 = "parameter  here ???? :"+mnemonic+" == "+field_type+" == "+order_category_id+" .... "+ resultSet;


			while ( resultSet != null && resultSet.next() ) {
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "single_or_multi" )  ;
				record[2] = resultSet.getString( "presentation_type" )  ;
				record[3] = resultSet.getString( "sys_user_def_ind" )  ;
				record[4] = resultSet.getString( "help_text" )  ;
				record[5] = resultSet.getString( "eff_status" )  ;
			//	chk = "vals here ???? :"+record[0]+" == "+record[1]+" == "+record[2]+" == "+record[3]+" == "+record[4];
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
		return record;
	}

	/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
        {
			connection =  getConnection() ;
			try {
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DUPLICATE") ) ;
				pstmt.setString( 1, field_mnemonic ) ;
				//pstmt.setString( 2, order_category) ;

				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					int count = resultSet.getInt( 1 ) ;
					if ( count > 0 ) {
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", getMessage(language_id,"CODE_ALREADY_EXISTS","Common") );
					}else {
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}
				}
			  } catch ( Exception e ) {
				System.err.println( "Order Type - validate() method error" ) ;
				e.printStackTrace() ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", e ) ;
				throw e ;
			} finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
					}
					catch(Exception e){
						System.err.println( "Error closing Connection  : "+e ) ;
						map.put( "message", e.getMessage() ) ;
						e.printStackTrace() ;
					}
				}
		}
		return map ;
	}


	public HashMap insert(){
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");
		HashMap tabdata = new HashMap() ;
		tabdata.put( "field_mnemonic",	field_mnemonic) ;
		tabdata.put( "field_mnemonic_desc",	field_mnemonic_desc) ;
		tabdata.put( "field_type",		field_type ) ;
		tabdata.put( "order_category",	order_category) ;
		tabdata.put( "meaning",	meaning_value) ;
		tabdata.put( "min_value",	min_value) ;
		tabdata.put( "max_value",		max_value ) ;
		tabdata.put( "single_multi",	single_multi) ;
		tabdata.put( "presentation_type",	presentation_type) ;
		tabdata.put( "hint",	hint) ;
		tabdata.put( "descrete_measure",	descrete_measure) ;
		tabdata.put( "eff_status",	eff_status) ;
		//tabdata.put( "listValues",	listValues) ;
		tabdata.put( "listValues",	format_values) ;
		

		tabdata.put( "added_by_id",			login_by_id ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "properties",	getProperties()) ;

		if(min_value.equals("") || min_value == null)
			min_value = " ";
		if(max_value.equals("") || max_value == null)
			max_value = " ";

		traceVals.append("min -->"+min_value+"<" );
		traceVals.append("**max -- >"+max_value+"<" );


		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_INSERT") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE") );
		}catch(Exception e){
			System.err.println( "Error in loading the query  : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;

		}


		//OROrderEntryFormatItemHome home = null ;
		//OROrderEntryFormatItemRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_ITEM_JNDI") ) ;
				home  = (OROrderEntryFormatItemHome) PortableRemoteObject.narrow( object, OROrderEntryFormatItemHome.class ) ;
				remote = home.create() ;
			//	OROrderEntryFormatItemManager  remote1 =  new 	OROrderEntryFormatItemManager();
				map = remote.insert( tabdata, sqlMap ) ;*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_ITEM_JNDI"), OROrderEntryFormatItemHome.class, getLocalEJB());
    			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
				argArray[0]		= tabdata;
				argArray[1]		= sqlMap;
 				Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabdata.getClass();
				paramArray[1]	= sqlMap.getClass();
 				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray=null;
				paramArray=null;

				//String ejbMap = "here comes ejb values ------"+(String)map.get("traceVal")+"====here ends";
				//traceVals.append("ejbMap :  -- "+ejbMap );
		//		map = insert( tabdata, sqlMap ) ;

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

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

		//map.put( "traceVal", traceVals.toString() ) ;
		return map ;

	}


	public HashMap modify(){
		HashMap map = new HashMap() ;
		//System.out.println("********descrete_measure )))))******** " +descrete_measure);
		map.put( "result", new Boolean( false ) ) ;
		//System.out.println("just entered -- ");
		HashMap tabdata = new HashMap() ;
		tabdata.put( "field_mnemonic",	field_mnemonic) ;
		tabdata.put( "field_mnemonic_desc",	field_mnemonic_desc) ;
		tabdata.put( "field_type",		field_type ) ;
		tabdata.put( "order_category",	order_category) ;
		tabdata.put( "min_value",	min_value) ;
		tabdata.put( "max_value",		max_value ) ;
		tabdata.put( "descrete_measure",descrete_measure ) ;
		tabdata.put( "single_multi",	single_multi) ;
		tabdata.put( "presentation_type",	presentation_type) ;
		tabdata.put( "hint",	hint) ;
		tabdata.put( "eff_status",	eff_status) ;
	//	tabdata.put( "listValues",	listValues) ;
		tabdata.put( "listValues",	format_values) ;
		


		tabdata.put( "added_by_id",			login_by_id ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "properties",	getProperties()) ;



		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_UPDATE_LIST_VALUE", OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_UPDATE_LIST_VALUE") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_DELETE_LIST_VALUE", OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DELETE_LIST_VALUE") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_GET_SEQUENCE_NUM", OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_GET_SEQUENCE_NUM") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_GET_SPECIMENT_KEY_REF", OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_GET_SPECIMENT_KEY_REF") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_UPDATE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_UPDATE") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_DELETE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DELETE") );
			sqlMap.put( "SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE") );

		//	System.out.println("Qry contacting EJB -- "+ OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_UPDATE"));
		}catch(Exception e){
			System.err.println( "Error Loading the query from OrRepository  : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}

		traceVals.append("max_value -- "+max_value);
		//traceVals.append("updt qry -- "+OrInterface.SQL_ORDER_ENTRY_ITEM_UPDATE );
		//traceVals.append("delete qry1 -- "+OrInterface.SQL_ORDER_ENTRY_ITEM_DELETE );


		//OROrderEntryFormatItemHome home = null ;
		//OROrderEntryFormatItemRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_ITEM_JNDI") ) ;
				home  = (OROrderEntryFormatItemHome) PortableRemoteObject.narrow( object, OROrderEntryFormatItemHome.class ) ;
				remote = home.create() ;
//				OROrderEntryFormatItemManager  remote1 =  new 	OROrderEntryFormatItemManager();
				map = remote.modify( tabdata, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_ITEM_JNDI"), OROrderEntryFormatItemHome.class, getLocalEJB());
    			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
				argArray[0]		= tabdata;
				argArray[1]		= sqlMap;
 				Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabdata.getClass();
				paramArray[1]	= sqlMap.getClass();
 				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					argArray=null;
					paramArray=null;

				//String ejbMap = "here comes ejb values ------"+(String)map.get("traceVal")+"====here ends";
				//traceVals.append("ejbMap :  -- "+ejbMap );


				//map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "OR")) ;
				}
				map.put("traceVal", (String)traceVals.toString());

		//		map = modify( tabdata, sqlMap ) ;

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
		map.put( "traceVal", traceVals.toString() ) ;
		return map ;

	}




	public void setAll( Hashtable recordSet ) {


		if(recordSet.containsKey("field_mnemonic")){
			setFieldMnemonic((String)recordSet.get("field_mnemonic")) ;
		}
		if(recordSet.containsKey("field_mnemonic_desc")){
			setFieldMnemonicDesc((String)recordSet.get("field_mnemonic_desc")) ;
		}
		if(recordSet.containsKey("field_type")){
			setFieldType((String)recordSet.get("field_type")) ;
		}
		if(recordSet.containsKey("min_value")){
			setMinValue((String)recordSet.get( "min_value" ));
		}
		if(recordSet.containsKey("max_value")){
			setMaxValue((String)recordSet.get( "max_value" ));
		}
		if(recordSet.containsKey("order_category")){
			setOrderCategory((String)recordSet.get( "order_category" ));
		}
		if(recordSet.containsKey("meaning_value")){
			setMeaningValue((String)recordSet.get( "meaning_value" ));
		}
		if(recordSet.containsKey("single_multi")){
			setSingleMulti((String)recordSet.get( "single_multi" ));
		}
		if(recordSet.containsKey("presentation_type")){
			setPresentationType((String)recordSet.get( "presentation_type" ));
		}

		if(recordSet.containsKey("hint")){
			setHint((String)recordSet.get( "hint" ));
		}
		if(recordSet.containsKey("discrete_value")){
			setDiscreteMeasure((String)recordSet.get( "discrete_value" ));
		}
		if(recordSet.containsKey("eff_status")){
			String eff_st = (String)recordSet.get( "eff_status" );
			if( !(eff_st.equals("")))
				setEffectiveStatus("E") ;
			else
				setEffectiveStatus("D") ;
		}
		//if(recordSet.containsKey("listValues")){
			//setListValues((String)recordSet.get( "listValues" ));

			//System.out.println("list values"+(String)recordSet.get( "listValues" ));
			//traceVals.append("**** listValues-- "+listValues+" **");
		//}

	}

	public void clear() {

		field_mnemonic	 			= "";
		field_mnemonic_desc	 			= "";
		field_type			 		= "";
		order_category				= "";
		meaning_value				= "";
		min_value					= "";
		max_value					= "";
		single_multi				= "";
		presentation_type			= "";
		hint						= "";
		descrete_measure			= "";
		eff_status					= "";
		listValues					= "";
		finalString                  ="";
		format_values.clear();
		
		super.clear() ;
	}

public synchronized boolean formatListValues(Hashtable request)
{

	String finalStrings="";

	finalStrings =  (String)request.get("finalString");
		
	if(finalStrings.trim().length()>0)
	{
		setFinalString(finalStrings);
		return true;
	}

	return false;
}

public void  setFormatListValues(String key,String value)
{
		format_values.put(key,value);
}
public String getFormatListValues(String key)
{
	
	if(format_values.containsKey(key))
	return (String)format_values.get(key);
	else
	return null;
}


}
