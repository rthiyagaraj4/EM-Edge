/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?                            ?           created
25/7/2011    IN27169		Dinesh T	 OrderEntryFormat dependencies are not filtered properly
5/8/2011     IN28042		Dinesh T	 Default Values in the OrderFormats are not populating
24/07/2013   IN038529       Chowminya G Field Mnemonic restriction in format item based on the level value
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
02/07/2014	IN049133		Chowminya									CRF:Disallow user to enter the future date in the LMP date field
--------------------------------------------------------------------------------------------------------
*/

package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import java.util.Set;
import java.util.LinkedHashMap;
import eOR.Common.* ;
import eCommon.Common.*;

import eOR.OROrderEntryFormat.*;

public class OrderEntryFormats extends OrAdapter implements java.io.Serializable {
	protected String format_id					= "";
	protected String level 						= "";
	protected String order_category			= "";
	protected String order_category_desc	= "";
	protected String order_type				= "";
	protected String order_type_desc		= "";
	protected String order_catalog			= "";
	protected String order_catalog_desc	= "";
	protected String meaning_value			= "";
	protected String listValues					= "";

	protected String finalString			= "";
	public LinkedHashMap format_values			= new LinkedHashMap();
	public TreeMap formatFinalValues	= new TreeMap();
	StringBuffer traceVals = new StringBuffer();
	

	public void setFormatId(String format_id){ 								this.format_id = format_id;	}
	
	public void setLevel(String level){											this.level = level;}
	public void setOrderCategory(String order_category){					this.order_category = order_category;	}
	public void setOrderCategoryDesc(String order_category_desc){	this.order_category_desc = order_category_desc;	}
	public void setOrderType(String order_type){							this.order_type = order_type;	}
	public void setOrderTypeDesc(String order_type_desc){				this.order_type_desc = order_type_desc;	}
	public void setOrderCatalog(String order_catalog){						this.order_catalog = order_catalog;	}
	public void setOrderCatalogDesc(String order_catalog_desc){		this.order_catalog_desc = order_catalog_desc;	}
	public void setMeaningValue(String meaning_value){					this.meaning_value= meaning_value;	}
	public void setListValues(String listValues){
		try{
			this.listValues=java.net.URLDecoder.decode(listValues,"UTF-8");}
			catch(Exception e){}
	  }
	

	public void setFinalString (String finalString) {this.finalString=finalString; }

	public String getFormatId(){					return format_id;	}
	public String getLevel(){						return level;	}
	public String getOrderCategory(){				return order_category;	}
	public String getOrderCategoryDesc(){			return order_category_desc;}
	public String getOrderType(){					return order_type ;}
	public String getOrderTypeDesc(){				return order_type_desc ;	}
	public String  getOrderCatalog(){				return order_catalog;	}
	public String  getOrderCatalogDesc(){			return order_catalog_desc;}
	public String getMeaningValue(){				return meaning_value;	}
	public String getListValues(){					return listValues;	}

	public String getFinalString() {return this.finalString;}
	public TreeMap getFormatFinalValues() {return this.formatFinalValues;}

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
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

	

	public TreeMap getListTypeData(String ord_cat, String mnemonic) throws Exception {//<IN27169>
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		TreeMap OrderCat = new TreeMap() ;	 //<IN27169>
		int i=0;	 //<IN27169>
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_LIST_VALS") ) ;
			pstmt.setString(1,ord_cat);
			pstmt.setString(2,mnemonic);
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "alphanum_value" )  ;

				OrderCat.put(i,record) ;   //<IN27169>
				i++;//<IN27169>
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

public TreeMap getListTypeData(String ord_cat, String mnemonic,String seq_num,String format_id) throws Exception {				 //<IN27169>
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		TreeMap OrderCat = new TreeMap() ;	//<IN27169>

		try {
			connection = getConnection() ;
			int i = 0;
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DFLT_VALUES") ) ;//<IN27169>
			pstmt = connection.prepareStatement("SELECT   a.field_mnemonic_value alphanum_value FROM or_order_format_dtl1 a, or_order_format_hdr b WHERE a.format_id = b.format_id AND b.order_category IN (?, 'AL') AND a.field_mnemonic = ? AND seq_num = ? AND a.format_id = ? ORDER BY value_seq_num") ;	//<IN27169>
			pstmt.setString(1,ord_cat);
			pstmt.setString(2,mnemonic);
			pstmt.setString(3,seq_num);
			pstmt.setString(4,format_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "alphanum_value" )  ;
					OrderCat.put(i,record) ;//<IN27169>				
					i++;//<IN27169>
			}
			if(i == 0)
			{	int k=0;  //<IN27169>
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_LIST_VALS") ) ;
				pstmt.setString(1,ord_cat);
				pstmt.setString(2,mnemonic);
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "alphanum_value" )  ;
					OrderCat.put(k,record) ; //<IN27169>
					k++;			 //<IN27169>
				}
			}
		} catch ( Exception e )	{

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
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getMnemonic (String ord_cat, String level) throws Exception {  //<IN27169> //IN038529 included level
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String fld_mnemonic = null;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_MNEMONIC") ) ;//<IN27169>
			//pstmt = connection.prepareStatement("SELECT field_mnemonic,field_mnemonic_desc,  field_type,min_num_value,max_num_value,single_or_multi,presentation_type FROM or_order_field WHERE  order_category in (?,'AL') AND field_mnemonic_desc=NVL(?,field_mnemonic_desc) and field_mnemonic !='REQUEST_COMMENT_DESC' and EFF_STATUS='E' ORDER BY 1") ;	//<IN27169>
			pstmt = connection.prepareStatement("SELECT field_mnemonic,field_mnemonic_desc,  field_type,min_num_value,max_num_value,single_or_multi,presentation_type FROM or_order_field WHERE  order_category in (?,'AL') AND field_mnemonic_desc=NVL(?,field_mnemonic_desc) and field_mnemonic !='REQUEST_COMMENT_DESC' AND APPL_TYPE in (?,'B') and EFF_STATUS='E' ORDER BY 1") ;//IN038529
			pstmt.setString(1, ord_cat);
			pstmt.setString(2, fld_mnemonic);
			pstmt.setString(3, level);//IN038529

			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[7];
				record[0] = resultSet.getString( "field_mnemonic" )  ;
				record[1] = resultSet.getString( "field_type" )  ;
				record[2] = resultSet.getString( "min_num_value" )  ;
				record[3] = resultSet.getString( "max_num_value" )  ;
				record[4] = resultSet.getString( "single_or_multi" )  ;
				record[5] = resultSet.getString( "presentation_type" )  ;
				record[6] = resultSet.getString( "field_mnemonic_desc" )  ;
				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

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
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getAgeGroup () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_SETTINGS_AGE_GROUP") ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "AGE_GROUP_DESC" )  ;
				record[1] = resultSet.getString( "AGE_GROUP_CODE" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

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
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getOrderTypeData(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_SELECT_ORDER_TYPE") ) ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_ORDER_TYPE") ) ;
			pstmt.setString( 1, order_category ) ;
			pstmt.setString( 2, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}
	public ArrayList getDefaultData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList DefalutVal = new ArrayList() ;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( "select long_desc description,view_Code from rd_view where status is null ") ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT_DFLT_VALUE") ) ;
			//pstmt.setString( 1, order_category ) ;
			resultSet = pstmt.executeQuery() ;
			String[] record = null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "view_Code" )  ;
				record[1] = resultSet.getString( "description" )  ;

				DefalutVal.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return DefalutVal;
	}


	public ArrayList getMnemonics(String lvl, String order_cat, String order_typ, String order_catlg) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record =				null;
		ArrayList mnemonics = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT_FOR_MODAL_WIN") ) ;
			pstmt.setString( 1, lvl) ;
			pstmt.setString( 2, order_cat ) ;
			pstmt.setString( 3, order_typ) ;
			pstmt.setString( 4, order_catlg) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null &&  resultSet.next() ){
				record =	new String[12];
				record[0] = resultSet.getString( "seq_num" )  ;
				record[1] = resultSet.getString( "field_mnemonic" )  ;
				record[2] = resultSet.getString( "label_text" )  ;
				record[3] = resultSet.getString( "accept_option" )  ;
				record[4] = resultSet.getString( "dflt_value" )  ;
				record[5] = resultSet.getString( "age_group_code" ) ;
				record[6] = resultSet.getString( "dependency_yn" ) ;

				record[7] = resultSet.getString( "field_type" )  ;
				record[8] = resultSet.getString( "min_num_value" )  ;
				record[9] = resultSet.getString( "max_num_value" )  ;
				record[10] = resultSet.getString( "field_mnemonic_desc" )  ;
				record[11] = resultSet.getString( "occ_no" )  ;

				mnemonics.add(record) ;

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return mnemonics ;

	}
	/*******to populate values for Dependency********************/
	public ArrayList getDependency(String lvl, String order_cat, String order_typ, String order_catlg, String seq_num, String field_mnemonic) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet			= null;
		String[] record				= null;
		ArrayList dependency = new ArrayList() ;

		try {
			connection = getConnection() ;
	//		String dependency_yn= "Y" ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT_FOR_DEPEND_WIN") ) ;
			pstmt.setString( 1, lvl) ;
			pstmt.setString( 2, order_cat ) ;
			pstmt.setString( 3, order_cat ) ;
			pstmt.setString( 4, order_typ) ;
			pstmt.setString( 5, order_catlg) ;
			pstmt.setString( 6, seq_num) ;
			pstmt.setString( 7, field_mnemonic ) ;
			//pstmt.setString( 3, dependency_yn ) ;
			
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null &&  resultSet.next() ){
				record =	new String[8];
				record[0] = resultSet.getString( "field_mnemonic_value" )  ;
				record[1] = resultSet.getString( "value_seq_num" )  ;
				record[2] = resultSet.getString( "field_mnemonic_value1" )  ;
				record[3] = resultSet.getString( "field_value_type" )  ;
				record[4] = resultSet.getString( "field_mnemonic_action" )  ;
				record[5] = resultSet.getString( "field_action_msg" ) ;
				record[6] = resultSet.getString( "notify_yn" )  ;
				record[7] = resultSet.getString( "oth_mnemonic_yn" )  ;
				
				dependency.add(record) ;

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return dependency ;

	}
	/*******to populate values for Other Mnemonic function********************/
	public ArrayList getOthMnemonic(String lvl, String order_cat, String order_typ, String order_catlg, String seq_num, String field_mnemonic, String value_seq_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet			= null;
		String[] record				= null;
		ArrayList oth_mnemonic = new ArrayList() ;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT_FOR_OTH_MNEM") ) ;	 //<IN27169>
			//pstmt = connection.prepareStatement("SELECT   a.oth_seq_num seq_num, a.oth_field_mnemonic field_mnemonic, a.oth_label_text label_text,a.oth_accept_option accept_option, a.oth_dflt_value dflt_value, c.field_type field_type, c.min_num_value,         c.max_num_value, a.oth_age_group_code age_group_code, c.field_mnemonic_desc FROM or_order_format_dtl2 a, or_order_format_hdr b, or_order_field c WHERE b.format_id = a.format_id	AND c.field_mnemonic = a.field_mnemonic AND b.format_level = (?)AND b.order_category = (?) AND b.order_type_code = NVL ((?), b.order_type_code) AND b.order_catalog_code = NVL ((?), b.order_catalog_code)AND a.seq_num = (?) AND a.field_mnemonic = (?) AND a.value_seq_num = (?) ORDER BY seq_num"); //<IN27169>
			pstmt = connection.prepareStatement("SELECT   a.oth_seq_num seq_num, a.oth_field_mnemonic field_mnemonic, a.oth_label_text label_text,a.oth_accept_option accept_option, a.oth_dflt_value dflt_value, c.field_type field_type, c.min_num_value,         c.max_num_value, a.oth_age_group_code age_group_code, c.field_mnemonic_desc, A.DEPENDENCY_YN dependency_yn FROM or_order_format_dtl2 a, or_order_format_hdr b, or_order_field c WHERE b.format_id = a.format_id	AND c.field_mnemonic = a.field_mnemonic AND b.format_level = (?)AND b.order_category = (?) AND b.order_type_code = NVL ((?), b.order_type_code) AND b.order_catalog_code = NVL ((?), b.order_catalog_code)AND a.seq_num = (?) AND a.field_mnemonic = (?) AND a.value_seq_num = (?) ORDER BY seq_num"); //IN049133
			pstmt.setString( 1, lvl) ;
			pstmt.setString( 2, order_cat ) ;
			pstmt.setString( 3, order_typ) ;
			pstmt.setString( 4, order_catlg) ;
			pstmt.setString( 5, seq_num) ;
			pstmt.setString( 6, field_mnemonic ) ;
			pstmt.setString( 7, value_seq_num) ;
						
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null &&  resultSet.next() ){
				record =	new String[10];
				record[0] = resultSet.getString( "seq_num" )  ;
				record[1] = resultSet.getString( "field_mnemonic" )  ;
				record[2] = resultSet.getString( "label_text" )  ;
				record[3] = resultSet.getString( "accept_option" )  ;
				record[4] = resultSet.getString( "dflt_value" )  ;
				record[5] = resultSet.getString( "age_group_code" ) ;
				record[6] = resultSet.getString( "field_type" )  ;
				record[7] = resultSet.getString( "min_num_value" )  ;
				record[8] = resultSet.getString( "max_num_value" )  ;
				record[9] = resultSet.getString( "dependency_yn" ) ;//IN049133
				
				
				oth_mnemonic.add(record) ;

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return oth_mnemonic ;

	}
	//IN049133 - Start
	/*******to populate values for Other Mnemonic Dependent function********************/
	public ArrayList getOthDependMnemonic(String lvl, String order_cat, String order_typ, String order_catlg, String seq_num, String oth_field_mnemonic) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet			= null;
		String[] record				= null;
		ArrayList oth_mnemonic = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT   a.OTH_FLD_MNEMO_VAL field_mnemonic_value,a.OTH_VALUE_SEQ_NO value_seq_num,a.OTH_FLD_MNEMO_VAL1 value1, a.field_value_type field_value_type, a.field_mnemonic_action field_mnemonic_action,a.field_action_msg field_action_msg FROM or_order_format_dtl3 a, or_order_format_hdr b, or_order_field c WHERE b.format_id = a.format_id AND c.field_mnemonic = a.field_mnemonic AND b.format_level = (?) AND b.order_category = (?) AND c.order_category IN ('AL', ?) AND b.order_type_code = NVL ((?), b.order_type_code) AND b.order_catalog_code = NVL ((?), b.order_catalog_code) AND a.OTH_SEQ_NUM = (?) AND a.OTH_FIELD_MNEMONIC = (?) ORDER BY a.OTH_VALUE_SEQ_NO"); 
			pstmt.setString( 1, lvl) ;
			pstmt.setString( 2, order_cat ) ;
			pstmt.setString( 3, order_cat ) ;
			pstmt.setString( 4, order_typ) ;
			pstmt.setString( 5, order_catlg) ;
			pstmt.setString( 6, seq_num) ;
			pstmt.setString( 7, oth_field_mnemonic) ;	
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null &&  resultSet.next() ){
				record =	new String[6];
				record[0] = resultSet.getString( "field_mnemonic_value" )  ;
				record[1] = resultSet.getString( "value_seq_num" )  ;
				record[2] = resultSet.getString( "field_value_type" )  ;
				record[3] = resultSet.getString( "field_mnemonic_action" )  ;
				record[4] = resultSet.getString( "field_action_msg" )  ;
				record[5] = resultSet.getString( "value1" )  ;
				
				oth_mnemonic.add(record) ;

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return oth_mnemonic ;

	}
	//IN049133 - End
	public ArrayList get1thMnemonic(String lvl, String order_cat, String order_typ, String order_catlg, String seq_num, String field_mnemonic, String value_seq_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet			= null;
		String[] record				= null;
		ArrayList oth_mnemonic = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT_FOR_1TH_MNEM") ) ;
			pstmt.setString( 1, lvl) ;
			pstmt.setString( 2, order_cat ) ;
			pstmt.setString( 3, order_typ) ;
			pstmt.setString( 4, order_catlg) ;
			pstmt.setString( 5, seq_num) ;
			pstmt.setString( 6, field_mnemonic ) ;
			pstmt.setString( 7, value_seq_num) ;
						
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null &&  resultSet.next() ){
				record =	new String[11];
				record[0] = resultSet.getString( "seq_num" )  ;
				record[1] = resultSet.getString( "field_mnemonic" )  ;
				record[2] = resultSet.getString( "label_text" )  ;
				record[3] = resultSet.getString( "accept_option" )  ;
				record[4] = resultSet.getString( "dflt_value" )  ;
				record[5] = resultSet.getString( "age_group_code" ) ;
				record[6] = resultSet.getString( "field_type" )  ;
				record[7] = resultSet.getString( "min_num_value" )  ;
				record[8] = resultSet.getString( "max_num_value" )  ;
				record[9] = resultSet.getString( "field_mnemonic_desc" )  ;
				record[10] = resultSet.getString( "dependency_yn" ) ;//IN049133
				
				
				oth_mnemonic.add(record) ;

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return oth_mnemonic ;

	}
/* Over-ridden Adapter methods start here */
	public int checkForDuplicate(String lvl, String ord_categry, String ord_typ, String ord_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		int count = 0;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
        {
		try {
        			connection =  getConnection() ;
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DUPLICATE") ) ;
					pstmt.setString( 1, ord_categry ) ;
					pstmt.setString( 2, ord_typ) ;
					pstmt.setString( 3, ord_cat) ;
					pstmt.setString( 4, lvl) ;
					pstmt.setString( 5, "F") ;

					resultSet = pstmt.executeQuery() ;

					if ( resultSet != null && resultSet.next() ) {
						count = resultSet.getInt( 1 ) ;
						if ( count > 0 ) {
							map.put( "result", new Boolean( false ) ) ;
							/*	if( ((String)map.get( "message" )).equals( "CODE_ALREADY_EXISTS" ) )
				{
						
						map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}*/
							map.put( "message", getMessage(language_id ,"CODE_ALREADY_EXISTS","Common" ) );
							//map.put( "message", "Code Already Exists.." ) ;
						}
						else {
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message", "success.." ) ;
						}
					}

			  } catch ( Exception e ) {

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
					catch(Exception es){

						es.printStackTrace() ;
					}
				}
		}
		return count ;
	}

	public String getInstallyn (String ord_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String install_yn = "N";

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( "select install_yn from Sm_Module where module_id = 'RD' " ) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1,ord_cat.trim());

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				install_yn = resultSet.getString( "install_yn" )  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return install_yn;
	}

/**
	This will populate all the List Values
	@return		:	ArrayList
*/

	public String[] getMainData (String format_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[8];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_POPULATE") ) ;
			pstmt.setString(1,format_id.trim());

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				record[0] = resultSet.getString( "format_level" )  ;
				record[1] = resultSet.getString( "order_category_id" )  ;
				record[2] = resultSet.getString( "order_category" )  ;
				record[3] = resultSet.getString( "order_type" )  ;
				record[4] = resultSet.getString( "order_type_desc" )  ;
				record[5] = resultSet.getString( "order_catalog" )  ;
				record[6] = resultSet.getString( "order_catalog_desc" )  ;
				record[7] = resultSet.getString( "sys_user_def_ind" )  ;

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}

	public String getMnemonicDesc (String order_category,String field_mnemonic) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String mnemonic_desc		= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_MNEMONIC_DESC") ) ;
			pstmt.setString(1,order_category.trim());
			pstmt.setString(2,field_mnemonic.trim());

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				mnemonic_desc = resultSet.getString( 1 )  ;   // FIELD_MNEMONIC_DESC
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return mnemonic_desc;
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");
		HashMap tabdata = new HashMap() ;

		int ordTypeLength = order_type.length();
		String tmpOrderType = order_type;
		if(ordTypeLength < 4){
			String fill = "";
			for (int i=(ordTypeLength+1); i<=4; i++){
				//fill += "^";
				fill=fill+"^";
			}
			//tmpOrderType +=  fill;
			tmpOrderType=tmpOrderType+fill;
		}

		traceVals.append("tmpOrderType -- "+tmpOrderType);

		String formatId = "F"+level+order_category+tmpOrderType+order_catalog;
		traceVals.append("formatId -- "+formatId);
		tabdata.put( "formatId",	formatId) ;
		tabdata.put( "format_id",	formatId) ;
		tabdata.put( "level",	level) ;
		tabdata.put( "element_type",	"F") ;
		tabdata.put( "order_category",	order_category) ;
		tabdata.put( "order_type",	order_type) ;
		tabdata.put( "order_catalog",	order_catalog) ;
		tabdata.put( "meaning",	meaning_value) ;
		tabdata.put( "listValues",	listValues) ;
		tabdata.put( "formatFinalValues",	formatFinalValues) ;
		tabdata.put( "dflt_dependency_values",	format_values) ;
		tabdata.put( "added_by_id",			login_by_id ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "properties",	getProperties()) ;

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_HDR", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_HDR") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC") );	//IN049133
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC") );	//IN049133
			
			
		
		}catch(Exception e){

			e.printStackTrace() ;
		}

		//OROrderEntryFormatHome home = null ;
		//OROrderEntryFormatRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_JNDI") ) ;
				home  = (OROrderEntryFormatHome) PortableRemoteObject.narrow( object, OROrderEntryFormatHome.class ) ;
				remote = home.create() ;
//				OROrderEntryFormatManager remote1 = new OROrderEntryFormatManager();
				map = remote.insert( tabdata, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_JNDI"), OROrderEntryFormatHome.class, getLocalEJB());
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


				//String ejbMap = "here comes ejb values of insert ------ "+(String)map.get("traceVal")+"====here ends";
				//traceVals.append("ejbMap :  -- "+ejbMap );
				//map = insert( tabdata, sqlMap ) ;

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "COMMON")) ;
		
				}

		map.put( "traceVal", traceVals.toString() ) ;



		} catch(Exception e) {
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace();
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {

				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		map.put( "traceVal", traceVals.toString() ) ;
		return map ;

	}

	public HashMap modify(){
		HashMap map = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;
		HashMap tabdata = new HashMap() ;
		tabdata.put( "formatId",	format_id) ;
		tabdata.put( "listValues",	listValues) ;
		tabdata.put( "formatFinalValues",	formatFinalValues) ;

		traceVals.append("** listValues:"+listValues);
		traceVals.append("** format_id :"+format_id);

		tabdata.put( "added_by_id",			login_by_id ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;

		tabdata.put( "modified_by_id",		login_by_id ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "dflt_dependency_values",	format_values) ;
		tabdata.put( "properties",	getProperties()) ;

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_ORDER_ENTRY_DELETE_DTL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DELETE_DTL") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY") );
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC") );	
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC") );	//IN049133
			sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC") );	//IN049133
			

		}catch(Exception e){

			e.printStackTrace() ;
		}

				//OROrderEntryFormatHome home = null ;
				//OROrderEntryFormatRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_JNDI") ) ;
				home  = (OROrderEntryFormatHome) PortableRemoteObject.narrow( object, OROrderEntryFormatHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabdata, sqlMap ) ;*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_JNDI"), OROrderEntryFormatHome.class, getLocalEJB());
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
				//String ejbMap = "here comes ejb values of modify ------"+(String)map.get("traceVal")+"====here ends";
				//traceVals.append("ejbMap :  -- "+ejbMap );

				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				map.put("traceVal", (String)traceVals.toString());

	//			map = modify( tabdata, sqlMap ) ;
	//			traceVals.append("ejbMap :  -- "+map.toString());

		} catch(Exception e) {

			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {

				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		map.put( "traceVal", traceVals.toString() ) ;
		return map ;

	}


/**
	This will set all the values to the HashMap, which further passsed as an delete method of the EJB
	@return		:	HashMap
*/

	public HashMap delete(){
		HashMap map = new HashMap() ;
				map.put( "result", new Boolean( false ) ) ;
				traceVals.append("just entered to delete method-- ");
				HashMap tabdata = new HashMap() ;

				tabdata.put("format_id",format_id);
				tabdata.put( "level",	level) ;
				tabdata.put( "properties",	getProperties()) ;

				HashMap sqlMap = new HashMap() ;
				try{
					sqlMap.put( "SQL_OR_ORDER_ENTRY_DELETE_DTL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DELETE_DTL") );
					sqlMap.put( "SQL_OR_ORDER_ENTRY_DELETE_HDR", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DELETE_HDR") );
					sqlMap.put( "SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_DEL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_DEL") );
					sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY") );
					sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC") );
					sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC") );	//IN049133

				}catch(Exception e){

					e.printStackTrace() ;
				}

				traceVals.append(" --format_id : "+format_id);

				//OROrderEntryFormatHome home = null ;
				//OROrderEntryFormatRemote remote = null ;

				try {
						/*InitialContext context = new InitialContext() ;
						Object object = context.lookup( OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_JNDI")) ;
						home  = (OROrderEntryFormatHome) PortableRemoteObject.narrow( object, OROrderEntryFormatHome.class ) ;
						remote = home.create() ;
						map = remote.delete( tabdata, sqlMap ) ;*/
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDER_ENTRY_FORMAT_JNDI"), OROrderEntryFormatHome.class, getLocalEJB());
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[]	= new Object[2];
							argArray[0]		= tabdata;
							argArray[1]		= sqlMap;
						Class [] paramArray = new Class[2];
							paramArray[0]	= tabdata.getClass();
							paramArray[1]	= sqlMap.getClass();
						map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
								
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
							
						argArray	= null;
						paramArray	= null;
						//traceVals.append(" --EJB Vals : "+map.toString());
						//traceVals.append(" --format ID Vals : "+tabdata.get("format_id"));

						map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				        map.put("traceVal", (String)traceVals.toString());


						/*traceVals.append(" before calling ejb method in LOCAL METHOD: ");
						map = delete( tabdata, sqlMap ) ;
						traceVals.append(" after calling ejb method: ");*/

				} catch(Exception e) {

					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} finally {
					clear();
					/*try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee ) {

						map.put( "message", ee.getMessage() ) ;
					}*/
				}
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}



	public void setAll( Hashtable recordSet ) 
	{
		//if(recordSet.containsKey("format_id")){ 			setFormatId((String)recordSet.get("format_id")) ;		}
		if(recordSet.containsKey("level")){					setLevel((String)recordSet.get("level")) ;		}
		if(recordSet.containsKey("order_category")){	setOrderCategory((String)recordSet.get( "order_category" ));	}
		if(recordSet.containsKey("order_type")){			setOrderType((String)recordSet.get( "order_type" ));	}
		if(recordSet.containsKey("order_catalog")){		setOrderCatalog((String)recordSet.get( "order_catalog" ));	}
		if(recordSet.containsKey("meaning_value")){		setMeaningValue((String)recordSet.get( "meaning_value" )); }
		if(recordSet.containsKey("listValues")){			setListValues((String)recordSet.get( "listValues" ));	}
		if(recordSet.containsKey("mode")){					setMode((String)recordSet.get( "mode" ));	}

	}

	public void clear() 
	{
		format_id					= "";
		level 						= "";
		order_category				= "";
		order_category_desc			= "";
		order_type					= "";
		order_type_desc				= "";
		order_catalog				= "";
		order_catalog_desc			= "";
		meaning_value				= "";
		listValues					= "";
		traceVals					= new StringBuffer();
	  	super.clear() ;
		format_values			= new LinkedHashMap();
		formatFinalValues			= new TreeMap();
	}
	

	public String getListTypeConstruct(String ord_cat, String mnemonic) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt_field 	= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet_field 			= null;
		ArrayList OrderCat = new ArrayList() ;
		StringBuffer comboBoxString=new StringBuffer();
		String field_type           = "";

		try 
		{
			connection = getConnection() ;
			pstmt_field = connection.prepareStatement( "select field_type from or_order_field where field_mnemonic=?" ) ;
			pstmt_field.setString(1,mnemonic); //<IN28042>
			resultSet_field = pstmt_field.executeQuery();

			while (resultSet_field!=null && resultSet_field.next())
			{
				field_type = resultSet_field.getString("field_type")==null?"":resultSet_field.getString("field_type");
			}

			if((field_type.equalsIgnoreCase("L")) || field_type.equalsIgnoreCase("R"))
			{
			
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_LIST_VALS") ) ;
				pstmt.setString(1,ord_cat);
				pstmt.setString(2,mnemonic);
				resultSet = pstmt.executeQuery() ;
				
				//comboBoxString=comboBoxString.append("<option>---Select---</option>");//<IN28042>

				while ( resultSet != null && resultSet.next() ) 
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "alphanum_value" )  ;
					
					comboBoxString=comboBoxString.append("<option>"+record[0]+"</option>");
					OrderCat.add(record) ;
				}		
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet_field ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt_field ) ;
			closeConnection(connection) ;
		}

		return comboBoxString.toString();
	}


	public String getListTypeConstruct(String ord_cat, String mnemonic,String seq_num,String format_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt_field 	= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet_field 			= null;
		ArrayList OrderCat = new ArrayList() ;
		StringBuffer comboBoxString=new StringBuffer();
		String field_type = "";

		try 
		{
			connection = getConnection() ;
			int i=0;
			pstmt_field = connection.prepareStatement( "select field_type from or_order_field where field_mnemonic=?" ) ;
			pstmt_field.setString(1,mnemonic);
			resultSet_field = pstmt_field.executeQuery();

			while (resultSet_field!=null && resultSet_field.next())
			{
				field_type = resultSet_field.getString("field_type")==null?"":resultSet_field.getString("field_type");
			}

			if((field_type.equalsIgnoreCase("L")) || field_type.equalsIgnoreCase("R"))
			{
				//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DFLT_VALUES") ) ;//<IN27169>
				pstmt = connection.prepareStatement("select a.field_mnemonic_value alphanum_value from or_order_format_dtl1 a,or_order_format_hdr b where a.format_id=b.format_id and b.order_category in(?,'AL') and a.FIELD_MNEMONIC =? and seq_num=? and a.format_id=? order by value_seq_num") ;	//<IN27169>
				pstmt.setString(1,ord_cat);
				pstmt.setString(2,mnemonic);
				pstmt.setString(3,seq_num);
				pstmt.setString(4,format_id);			
				resultSet = pstmt.executeQuery() ;			
			
				while ( resultSet != null && resultSet.next() ) 
				{
					i++;
					String[] record = new String[2];
					record[0] = resultSet.getString( "alphanum_value" )  ;
					comboBoxString = comboBoxString.append("<option>"+record[0]+"</option>");
					OrderCat.add(record) ;
				}
				closeResultSet(resultSet);
				closeStatement(pstmt);

				if(i==0)
				{
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_LIST_VALS") ) ;
					pstmt.setString(1,ord_cat);
					pstmt.setString(2,mnemonic);		
					resultSet = pstmt.executeQuery() ;			
					
					while ( resultSet != null && resultSet.next() ) 
					{			
						String[] record = new String[2];
						record[0] = resultSet.getString( "alphanum_value" )  ;				
						comboBoxString=comboBoxString.append("<option>"+record[0]+"</option>");
						OrderCat.add(record) ;
					}
				}
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet_field ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt_field ) ;
			closeConnection(connection) ;
		}

		return comboBoxString.toString();
	}

	public void  setFormatListValues(String key,String value)
	{
			format_values.put(key,value);
			//Set keys = format_values.keySet();			
	}
	public String getFormatListValues(String key)
	{
	
		if(format_values.containsKey(key)){
		return (String)format_values.get(key);}
		else{
		return null;}
	}

	public void  setFormatFinalValues(int key,String value)
	{
			formatFinalValues.put(key,value);
			//Set keys = formatFinalValues.keySet();				
	}
	public String getFormatFinalValues(int key)
	{
		if(formatFinalValues.containsKey(key)){
		return (String)formatFinalValues.get(key);}
		else{
		return null;}
	}
	public void removeFormatFinalValues(int key)
	{
		TreeMap removeFinalValues=new TreeMap();
		int i=0;String mainStr="";
		if(formatFinalValues.containsKey(key)){
			formatFinalValues.remove(key);
		}

		Collection c = formatFinalValues.values();     //obtain an Iterator for Collection 
		Iterator itr = c.iterator();     //iterate through TreeMap values iterator 
		while(itr.hasNext())   {			
			mainStr=(String)itr.next();
			if(mainStr != null && !mainStr.equals(""))
				removeFinalValues.put(i,mainStr);
			i++;			
		}
		formatFinalValues=removeFinalValues;

	}
	public String getFormatListVal(String key)
	{		
		StringBuffer keyValue = new StringBuffer();
		if(format_values.containsKey(key)){			
			keyValue.append("<option>");
			keyValue.append((String)format_values.get(key));
			keyValue.append("</option>");
			return keyValue.toString();
			}
		else{
		return null;}
	}
	




}


// INSERT INTO or_order_format_hdr (format_id, format_level, element_type, order_category, order_type_code, order_catelog_code, sys_user_def_ind,added_by_id ,added_date ,added_at_ws_no ,added_facility_id ,modified_by_id,modified_date ,modified_at_ws_no,modified_facility_id ) VALUES (?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,)
//INSERT INTO or_order_format_dtl (format_id, seq_num, field_or_template_mnemonic, label_text, accept_option,dflt_value,added_by_id ,added_date ,added_at_ws_no ,added_facility_id ,modified_by_id,modified_date ,modified_at_ws_no,modified_facility_id ) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,)

// select a.seq_num, c.field_mnemonic, a.label_text, decode(a.accept_option, 'O','Optional','R','Required','D','Display Only'), a.dflt_value, a.format_id from or_order_format_dtl a, or_orderformat_hdr b, or_order_field c where b.format_id = a.format_id and c.field_mnemonic = a.field_or_template_mnemonic and b.format_level = (?) and b.order_category =(?) and b.order_type_code=nvl((?), b.order_type_code) and b.order_catalog_code = nvl((?), b.order_catalog_code) order by a.seq_num

//--- not done so far .....
/*
  SELECT format_level, order_category_id, order_category, order_type, order_type_desc, order_catalog,                   order_catalog_desc, DECODE(sys_user_def_ind,'U','User Defined','S','System Defined')  FROM or_order_format_hdr_vw WHERE order_category_id LIKE UPPER(?) AND format_level LIKE UPPER(?) AND                  order_type LIKE UPPER(?) AND order_catalog LIKE UPPER(?) AND order_category LIKE (?) AND                   order_type_desc LIKE (?) AND order_catalog_desc LIKE (?)
*/
// update of order catalog
/*
If Format level is Line and Delete of entire Format funciton then

    UPDATE or_order_catalog SET comment_format_id =	NULL 	WHERE comment_format_id = (?)
===========================
If Format Level is Line  and Mode is Insert  then

If the Non Specific
	UPDATE or_order_catalog SET comment_format_id  = (?) WHERE order_cataogry = DECODE((?),'*A',Order_catalog,(?)) AND order_type_code = DECODE((?),'*ALL',order_type_code,(?)) AND order_catalog_code =	DECODE((?),'*ALL',order_catalog_code,(?)) 	AND comment_format_id IS NULL
else
	UPDATE or_order_catalog 	SET comment_format_id =	(?) WHERE order_cataogry = (?) AND order_type_code =	DECODE((?),'*ALL',order_type_code,(?)) AND order_catalog_code 	=	DECODE((?),'*ALL',order_catalog_code,(?))
end if;







*/

