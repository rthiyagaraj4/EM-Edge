/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import java.io.* ;
import java.util.* ;
import java.sql.*;
//import oracle.sql.CLOB;
import javax.rmi.* ;
import javax.naming.* ;

import eOH.Common.* ;
import eCommon.Common.*;
import javax.servlet.*;
import javax.servlet.http.*;

import eOH.OHResultEntry.*;


public class ResultEntryBean extends eOH.Common.OHAdapter implements java.io.Serializable {

//	protected Hashtable allValues = new Hashtable();

	protected HashMap result_data = new HashMap();
//	protected HashMap result_html_data = new HashMap();
	protected ArrayList lineRecords = new ArrayList();	//contains line results data as HashMap in this arraylist
	protected HashMap resultRecord = new HashMap();	//contains result data in HashMap.
	protected HashMap commonRecord = new HashMap();	//contains the data which is common for both result and line result.
	protected HashMap cultureTestRecord = new HashMap();
	protected HashMap previewCultureTestRecord = new HashMap();
	Hashtable reportParameters = new Hashtable();
/*	HttpServletRequest request = null;
	HttpServletResponse response = null;*/
	protected String func_type		= "";


/*	public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
			this.request = request;
			this.response = response; 
	}*/

	public Hashtable getAllValues(){
		return this.reportParameters;
	}

/**
	This will populate all the details to be displayed in the Result Entry main top form.
	@return		:	ArrayList
*/
	public String[] viewMainDetails(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[12] ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_MAIN_DETAILS") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, language_id);
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, language_id);
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				/*record[0] = resultSet.getString( "first_detail_line" )  ;
				record[1] = resultSet.getString( "first_detail_line2" )  ;
				record[2] = resultSet.getString( "patient_detail" )  ;
				record[3] = resultSet.getString( "patient_id" )  ;
				record[4] = resultSet.getString( "location_details" )  ;
				record[5] = resultSet.getString( "encounter_id" )  ;
				record[6] = resultSet.getString( "parent_order_id" )  ;*/
				record[0] = resultSet.getString( "ord_date_time" )  ;
				record[1] = resultSet.getString( "order_categ_desc" )  ;
				record[2] = resultSet.getString( "order_type_desc" )  ;
				record[3] = resultSet.getString( "patient_name" )  ;
				record[4] = resultSet.getString( "sex" )  ;
				record[5] = resultSet.getString( "age" )  ;
				record[6] = resultSet.getString( "patient_id" )  ;
				record[7] = resultSet.getString( "ordering_pract_name" )  ;
				record[8] = resultSet.getString( "location_type" )  ;
				record[9] = resultSet.getString( "location_desc" )  ;
				record[10] = resultSet.getString( "encounter_id" )  ;
				record[11] = resultSet.getString( "parent_order_id" )  ;

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

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getSearchDetails(String order_id, String report_srl_no) throws Exception {

		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		Clob clb					= null;
		String ClobString			= "";
		ArrayList otherDetails = new ArrayList();
		int index = 0;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_SEARCH_DETAILS") ) ;
				pstmt.setString( 1, order_id.trim()) ;
				pstmt.setString( 2, language_id) ;
				pstmt.setString( 3, order_id.trim()) ;
				pstmt.setString( 4, language_id) ;
				pstmt.setString( 5, order_id.trim()) ;
				pstmt.setString( 6, language_id) ;
				pstmt.setString( 7, order_id.trim()) ;
				pstmt.setString( 8, language_id) ;
				pstmt.setString( 9, order_id.trim()) ;
				pstmt.setString( 10, language_id) ;
				pstmt.setString( 11, order_id.trim()) ;
				pstmt.setString( 12, report_srl_no.trim()) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[36] ;

				record[0] = resultSet.getString( "for_panel_atomic" )  ;
				record[1] = resultSet.getString( "discr_msr_panel_id" )  ;
				record[2] = resultSet.getString( "event_group_desc" )  ;
				record[3] = resultSet.getString( "discr_msr_id" )  ;
				record[4] = resultSet.getString( "result_type" )  ;
				record[5] = resultSet.getString( "num_digits_max" )  ;
				record[6] = resultSet.getString( "num_digits_min" )  ;
				record[7] = resultSet.getString( "num_digits_dec" )  ;
				record[8] = resultSet.getString( "event_desc" )  ;
				record[9] = resultSet.getString( "mandatory_yn");
				record[10] = resultSet.getString( "result_template_id");
				record[11] = resultSet.getString( "result_auth_reqd_yn");
				record[12] = resultSet.getString( "insert_line_srl_no" )  ;
				record[13] = resultSet.getString( "parent_srl_no" )  ;
				record[14] = resultSet.getString( "order_type_code" )  ;
				record[15] = resultSet.getString( "result_num" )  ;
				record[16] = resultSet.getString( "result_str" )  ;
				//record[17] = resultSet.getString( "result_data" )  ;
			
				record[18] = resultSet.getString( "result_status" )  ;
				record[19] = resultSet.getString( "detail_result_type" )  ;
				record[20] = resultSet.getString( "result_comments" )  ;
				record[21] = resultSet.getString( "order_catalog_code" )  ;
				record[22] = resultSet.getString( "proc_link_applicable" )  ;
				record[23] = resultSet.getString( "proc_link_resulting_option" )  ;
				record[24] = resultSet.getString( "term_set_id" )  ;
				record[25] = resultSet.getString( "term_code" )  ;
				record[26] = resultSet.getString( "reporting_date" )  ;
				record[27] = resultSet.getString( "accession_num" )  ;
				record[28] = resultSet.getString( "ext_appl_accession_num" )  ;
				record[29] = resultSet.getString( "complete_date_time" )  ;
				record[30] = resultSet.getString( "reporting_pract_id" )  ;
				record[31] = resultSet.getString( "practitioner_name" )  ;
				if(getEmptyStrIfNull(resultSet.getString( "auth_by_id" )).equals(""))
					record[32] = "N"  ;  //not authourized
				else
					record[32] = "Y"  ;  //authourized
 				record[33] = resultSet.getString( "LINE_SRL_NUM" )  ;
 				record[34] = resultSet.getString("start_date_time");
 				record[35] = resultSet.getString("order_set_id");

				ClobString = "";

/*
				java.io.InputStream datas = resultSet.getAsciiStream("result_data");
				if(datas!=null)
				{
				   int c;
				   while ((c = datas.read ()) != -1)
				   ClobString = ""+ ClobString +(char)c;
				}if(datas!=null) datas.close();
*/

				clb = resultSet.getClob("result_data") ;
				
				if(clb!=null && clb.length() > 0)
					ClobString = clb.getSubString( 1, ( (int)clb.length() ) ) ;
		
				
				if((ClobString == null) || ClobString.trim().equals(""))
					record[17] = "T";
				else
				{
					result_data.put(Integer.toString(index),ClobString);
					record[17] = "B";
				}
			
				index++;
				otherDetails.add(record) ;

				clb = null;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" +e.toString()) ;
		//	e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return otherDetails;
	}


/**
	This will populate all the numeric details for each row.
	@return		:	ArrayList
*/

	public String[] getNumericResultTypeDetails(String msr_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[6] ;
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_NUMERIC_DETAILS") ) ;
				pstmt.setString( 1, msr_id.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				record[0] = resultSet.getString( "num_uom" )  ;
				record[1] = resultSet.getString( "num_ref_low_with_points" )  ;
				record[2] = resultSet.getString( "num_ref_highwith_points" )  ;
				record[3] = resultSet.getString( "num_crit_low" )  ;
				record[4] = resultSet.getString( "num_crit_high" )  ;
				record[5] = resultSet.getString( "num_dflt_result" )  ;
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

/**
	This will populate all the numeric details for each row.
	@return		:	ArrayList
*/

	public String[] getHeaderLineDetails(String order_id, String report_srl_no) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = {"In Progress", "1", "Not Applicable", "", "","N"} ;
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_HEADER_DETAIL") ) ;
				pstmt.setString( 1, language_id ) ;
				pstmt.setString( 2, order_id.trim() ) ;
				pstmt.setString( 3, report_srl_no.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				record[1] = resultSet.getString( "result_status" )  ;
				if(record[1].trim().equals("2"))	record[0] = "Partial";
				else if(record[1].trim().equals("3"))record[0] = "Completed";
				record[3] = resultSet.getString( "result_type" )  ;
				if(record[3]!=null && record[3].trim().equalsIgnoreCase("A"))	record[2] = "Abnormal";
				else if(record[3]!=null && record[3].trim().equalsIgnoreCase("N"))	record[2] = "Normal";
				record[4] = resultSet.getString( "reporting_pract_id" )  ;
				
				if(getEmptyStrIfNull(resultSet.getString( "auth_reqd_yn" )).equals("Y") && !getEmptyStrIfNull(resultSet.getString( "auth_by_id" )).equals("") )
					record[5] = "Y"  ;
				else
					record[5] = "N"  ;
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


/**
	This will populate all the numeric details for each row.
	@return		:	ArrayList
*/

	public String[] getHeaderLinePractId(String order_id, String report_srl_no) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[2];
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_HEADER_DETAIL") ) ;
				pstmt.setString( 1, language_id ) ;
				pstmt.setString( 2, order_id.trim() ) ;
				pstmt.setString( 3, report_srl_no.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				record[0] = resultSet.getString( "reporting_pract_id" )  ;
				record[1] = resultSet.getString("practitioner_name");

				if(record[0]==null)	{
					record[0]="";
				}
				if (record[1]==null) {
					record[1]="";
				}
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


	public ArrayList getListResultTypeDetails(String discr_msr_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList listValues = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_LIST_DETAILS") ) ;
				pstmt.setString( 1, discr_msr_id.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[6] ;
				record[0] = resultSet.getString( "ref_rng_desc" )  ;
				record[1] = resultSet.getString( "dflt_yn" )  ;
				record[2] = resultSet.getString( "result_value" )  ;
				record[3] = resultSet.getString( "norm_abnorm_ind" )  ;
				listValues.add(record);
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
		
		return listValues;
	}

	public ArrayList getTemplateBlocks(String panel_msr_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList listValues = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_TEMPLATE_BLOCK") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, panel_msr_id.trim() ) ;
				pstmt.setString( 3, panel_msr_id.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[2] ;
				record[0] = resultSet.getString( "text_block_id" )  ;
				record[1] = resultSet.getString( "text_block" )  ;
				listValues.add(record);
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

		return listValues;
	}


/**
	This will get the result template text from the database.
	@return		:	ArrayList
*/
	public String getResultTemplate(String template_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String template = "";
		Clob clb = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_TEMPLATE") ) ;
			pstmt.setString( 1, template_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				/*java.io.InputStream datas = resultSet.getAsciiStream("result_template");
				if(datas!=null)
				{
				   int c;
				   while ((c = datas.read ()) != -1)
				   template = ""+ template +(char)c;
				}if(datas!=null) datas.close();*/

				template ="";
				
				clb = resultSet.getClob("result_template");
				if( (clb!=null) && (clb.length()>0) ){
					template= clb.getSubString( 1, ((int)clb.length()) ) ;
				}
				clb = null;

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
		return template;
	}

/**
	This will get the result template text from the database.
	This is for the Template
 **/ 	
/*	public String[] getTemplate(String template_id) throws Exception {
		String[] templateArray		= new String[2];
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//String template = "";
		templateArray[0]			= "";
		templateArray[1]			= "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_TEMPLATE_SELECT") ) ;
 			pstmt.setString( 1, template_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				Clob clb = resultSet.getClob("html_text") ;
				Clob clb1 = resultSet.getClob("edit_text") ;
 				if(clb!=null && clb.length() > 0)
					templateArray[0] = clb.getSubString( 1, ( (int)clb.length() ) ) ;

				if(clb1!=null && clb1.length() > 0)
					templateArray[1] = clb1.getSubString( 1, ( (int)clb1.length() ) ) ;


				clb = null; clb1 = null;
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

		return templateArray;
	}
*/
/**
	This will Check for the authorization link.
	@return		:	ArrayList
*/

	public String getAuthorization(String pract_id, String resp_id, String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String authorize = "1";
		String auth = "";
		String auth_reqd_yn = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_REPORT_OR_ORDER_LINE_AUTHORIZATION") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				auth = resultSet.getString("result_auth_reqd_yn");
				if(auth!=null && auth.trim().equals("Y"))
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_CHK_VALID_USER") ) ;
					pstmt1.setString( 1, pract_id.trim() ) ;
					pstmt1.setString( 2, resp_id.trim() ) ;
					//pstmt1.setString(3,order_category.trim());
					rs = pstmt1.executeQuery() ;
					while( rs != null && rs.next() )
					{
						auth_reqd_yn = rs.getString("authorize");
						if(auth_reqd_yn!=null && auth_reqd_yn.trim().equals("Y"))
							authorize = "3"  ;
						else authorize = "2"  ;
					}
					closeResultSet( rs ) ;
					closeStatement( pstmt1 ) ;
				}
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeResultSet( rs ) ;
			closeStatement( pstmt1 ) ;
			closeConnection(connection) ;
		}
		return authorize;
	}

	public String getAuthorization1(String pract_id, String resp_id, String order_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String authorize = "1";
		String auth = "";
		String auth_reqd_yn = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_REPORT_OR_ORDER_LINE_AUTHORIZATION") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				auth = resultSet.getString("result_auth_reqd_yn");
				if(auth!=null && auth.trim().equals("Y"))
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_CHK_VALID_USER1") ) ;
					pstmt1.setString( 1, pract_id.trim() ) ;
					pstmt1.setString( 2, resp_id.trim() ) ;
					pstmt1.setString(3,order_category.trim());
					rs = pstmt1.executeQuery() ;
					while( rs != null && rs.next() )
					{
						auth_reqd_yn = rs.getString("authorize");
						if(auth_reqd_yn!=null && auth_reqd_yn.trim().equals("Y"))
							authorize = "3"  ;
						else authorize = "2"  ;
					}
					closeResultSet( rs ) ;
					closeStatement( pstmt1 ) ;
					if (authorize.equals("1")) authorize = "2";
				}
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeResultSet( rs ) ;
			closeStatement( pstmt1 ) ;
			closeConnection(connection) ;
		}
		return authorize;
	}

/**
	This will Check where there is any frequency code in the database or not, if yes than returns true else false.
	@return		:	boolean
*/

	public boolean frequencyCodeExists(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		boolean authorize = false;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQ_CODE") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				if(resultSet.getString("freq_code")==null || resultSet.getString("freq_code").equals(""))
					authorize = false  ;
				else return true ;
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
		return authorize;
	}


/**
	This will fetch the report serial number for the given order id..
	@return		:	ArrayList
*/

	public String[] getReportSrlNo(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] reportSrlNo = {"1","1"};
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_REPORT_SRL_NO") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				reportSrlNo[0] = resultSet.getString("report_srl_no");
				reportSrlNo[1] = resultSet.getString("result_status");
				if(reportSrlNo[0]==null || reportSrlNo[0].trim().equals(""))	reportSrlNo[0]="1";
				if(reportSrlNo[1]==null || reportSrlNo[1].trim().equals(""))	reportSrlNo[1]="1";
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
		return reportSrlNo;
	}


/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/
	public ArrayList getOrderStatus() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderStatus = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORDER_STATUS_SELECT") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "order_status_code" )  ;

				OrderStatus.add(record) ;
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

		return OrderStatus;
	}


/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/
	public ArrayList getFreqExplOrders(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Orders = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQ_EXPL_ORDERS") ) ;
			pstmt.setString(1, order_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = {"","","","","",""};
				record[0] = resultSet.getString( "order_id" )  ;
				record[1] = resultSet.getString( "order_date" )  ;
				record[2] = resultSet.getString( "link_yn" )  ;
				record[3] = resultSet.getString( "color_status" )  ;
				record[4] = resultSet.getString( "allow_recording" )  ;
				record[5] = resultSet.getString( "order_end_date" )  ;

				Orders.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database for frequency explosion orders" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return Orders;
	}

/**
	This will return true of false on the basis of the
	cont_order_ind in or_order table for the perticular order
	@return		:	String
*/
	public boolean checkFreqExplosion(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		boolean freqExplApplies = false ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQ_EXPL_CHECK") ) ;
			pstmt.setString(1, order_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record = "";
				record = resultSet.getString( "cont_order_ind" )  ;
				if (record != null && (record.equalsIgnoreCase("CR") || record.equalsIgnoreCase("DR")))
					freqExplApplies = true;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database for frequency explosion orders" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return freqExplApplies;
	}


/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet )
	{
		commonRecord.clear();
		resultRecord.clear();
		lineRecords.clear();

		//allValues = recordSet;
		this.mode = (String)recordSet.get( "mode" );
		//this.request = (HttpServletRequest)recordSet.get("HttpRequest");
		//this.response = (HttpServletResponse)recordSet.get("HttpResponse");

		commonRecord.put("order_type_code"	,getEmptyStrIfNull(recordSet.get("order_type_code")));
		commonRecord.put("order_id"			,getEmptyStrIfNull(recordSet.get("order_id")));
		commonRecord.put("order_set_id"			,getEmptyStrIfNull(recordSet.get("order_set_id")));
		commonRecord.put("order_set_bill_yn"			,getEmptyStrIfNull(recordSet.get("order_set_bill_yn")));
		commonRecord.put("child_order_index",getEmptyStrIfNull(recordSet.get("child_order_index")));
		commonRecord.put("child_reporting_date",getEmptyStrIfNull(recordSet.get("child_reporting_date")));
		commonRecord.put("report_srl_no"	,getEmptyStrIfNull(recordSet.get("report_srl_no")));
		commonRecord.put("practitioner_id"	,getEmptyStrIfNull(recordSet.get("practitioner_id")));
		commonRecord.put("facility_id"		,getEmptyStrIfNull(recordSet.get("facility_id")));
		commonRecord.put("patient_id"		,getEmptyStrIfNull(recordSet.get("patient_id")));

		commonRecord.put("login_by_id"		,login_by_id);
		commonRecord.put("login_at_ws_no"	,login_at_ws_no);
		commonRecord.put("login_facility_id",login_facility_id);

		commonRecord.put("requestFrom",getEmptyStrIfNull(recordSet.get("requestFrom")));

		commonRecord.put("proc_scheme_code",getEmptyStrIfNull(recordSet.get("proc_scheme_code")));
		commonRecord.put("proc_link_resulting_option_result",getEmptyStrIfNull(recordSet.get("proc_link_resulting_option_result")));
		commonRecord.put("parent_order_id",getEmptyStrIfNull(recordSet.get("parent_order_id")));
		//commonRecord.put("accession_num",getEmptyStrIfNull(recordSet.get("accession_num")));

		
		resultRecord.put("rpt_pract_id"		,getEmptyStrIfNull(recordSet.get("rpt_pract_id")));
		resultRecord.put("auth_reqd_yn"		,getEmptyStrIfNull(recordSet.get("rpt_authreq_yn")));
		resultRecord.put("auth_reqd_yn_db"	,getEmptyStrIfNull(recordSet.get("rpt_authreq_yn_db")));
		resultRecord.put("auth_by_id"		,getEmptyStrIfNull(recordSet.get("auth_by_id")));
		resultRecord.put("result_status"	,getEmptyStrIfNull(recordSet.get("rpt_result_status")));
		resultRecord.put("result_type"		,getEmptyStrIfNull(recordSet.get("rpt_result_type")));
		resultRecord.put("order_status"		,getEmptyStrIfNull(recordSet.get("rpt_Order_Status")));

		int totalLineRecords = 0;

		if(recordSet.containsKey("total_recs"))
		totalLineRecords = Integer.parseInt((String)recordSet.get("total_recs"));
		for(int i=0; i<totalLineRecords; i++)
		{
			HashMap lineRecord = new HashMap();	// Creating a new lineRecord HashMap.

			if(i < lineRecords.size())	// To check if that lineRecord already exists.
				lineRecord = (HashMap)lineRecords.get(i);
			if(lineRecord==null) lineRecord = new HashMap();

			String line = Integer.toString(i);	// Converting the rownumber to string.
			String rslt_type = (String)getEmptyStrIfNull(recordSet.get("rslt_type_"+line));

			lineRecord.put("rslt_type",getEmptyStrIfNull(recordSet.get("rslt_type_"+line)));
			lineRecord.put("line_srl_num",getEmptyStrIfNull(recordSet.get("line_srl_num_"+line)));
			lineRecord.put("srl_num", getEmptyStrIfNull(recordSet.get("parent_srl_no_"+line)));
			lineRecord.put("msr_panel_id", getEmptyStrIfNull(recordSet.get("msr_panel_id_"+line)));
			lineRecord.put("msr_id", getEmptyStrIfNull(recordSet.get("msr_id_"+line)));
			if(getEmptyStrIfNull(recordSet.get("hidden_auth_reqd_yn"+line)).equals("Y"))
				lineRecord.put("auth_reqd_yn", getEmptyStrIfNull(recordSet.get("hidden_auth_reqd_yn"+line)));
			else
				lineRecord.put("auth_reqd_yn", getEmptyStrIfNull(recordSet.get("auth_reqd_"+line)));
			lineRecord.put("auth_reqd_yn_db", getEmptyStrIfNull(recordSet.get("auth_reqd_db_"+line)));
			lineRecord.put("result_type", getEmptyStrIfNull(recordSet.get("srv_stat_"+line)));
			lineRecord.put("result_num_uom", getEmptyStrIfNull(recordSet.get("result_num_uom_"+line)));
			lineRecord.put("result_status", getEmptyStrIfNull(recordSet.get("result_status"+line)));

			lineRecord.put("normal_low", getEmptyStrIfNull(recordSet.get("num_crit_low_points_"+line)));
			lineRecord.put("normal_high", getEmptyStrIfNull(recordSet.get("num_crit_high_points_"+line)));
			lineRecord.put("critical_low", getEmptyStrIfNull(recordSet.get("num_crit_low_"+line)));
			lineRecord.put("critical_high", getEmptyStrIfNull(recordSet.get("num_crit_high_"+line)));
			lineRecord.put("order_catalog_code", getEmptyStrIfNull(recordSet.get("order_catalog_code_"+line)));
			lineRecord.put("proc_link_applicable", getEmptyStrIfNull(recordSet.get("proc_link_applicable"+line)));
			lineRecord.put("term_set_id", getEmptyStrIfNull(recordSet.get("term_set_id"+line)));
			lineRecord.put("term_code", getEmptyStrIfNull(recordSet.get("term_code"+line)));
			
			lineRecord.put("accession_num",getEmptyStrIfNull(recordSet.get("accession_num"+line)));
			lineRecord.put("practitioner_id",getEmptyStrIfNull(recordSet.get("practitioner_id"+line)));
		
			String strResultComments = (String)getEmptyStrIfNull(recordSet.get("result_comments_"+line));
			strResultComments = strResultComments.replace('\"','\n');
			lineRecord.put("result_comments", strResultComments);
			lineRecord.put("result_num", "");
			lineRecord.put("norm_abnorm_ind", "");
			if(rslt_type.equalsIgnoreCase("N") || rslt_type.equalsIgnoreCase("I"))
			{
				lineRecord.put("result_num", getEmptyStrIfNull(recordSet.get("result_"+line)));
				lineRecord.put("norm_abnorm_ind", getEmptyStrIfNull(recordSet.get("result_status"+line)));
			}

			if(rslt_type.equalsIgnoreCase("L"))
				lineRecord.put("norm_abnorm_ind", getEmptyStrIfNull(recordSet.get("result_status"+line)));
			lineRecord.put("result_str","");
			if (!((rslt_type.equalsIgnoreCase("N")) || (rslt_type.equalsIgnoreCase("F")) || (rslt_type.equalsIgnoreCase("I"))))
			{
				lineRecord.put("result_str", getEmptyStrIfNull(recordSet.get("result_"+line)));
			}
			if(rslt_type.equalsIgnoreCase("C"))
				if(recordSet.get("result_"+line)==null || ((String)recordSet.get("result_"+line)).trim().equals(""))
					lineRecord.put("result_str", "N");
			
			lineRecord.put("result_data","");
			/*if(rslt_type.equalsIgnoreCase("Q")){
				lineRecord.put("result_data", getEmptyStrIfNull(recordSet.get("result_"+line)));
				lineRecord.put("result_str", "");
				if (cultureTestRecord.containsKey(Integer.toString(i))) {
					lineRecord.put("organism_data",cultureTestRecord.get(Integer.toString(i)));
				}
			}*/
			if(rslt_type.equalsIgnoreCase("X")){
				lineRecord.put("result_data", "");
				lineRecord.put("result_str", "");
			}

			if((rslt_type.equalsIgnoreCase("F")) || (rslt_type.equalsIgnoreCase("Q")) || (func_type.equals("EXTERNAL"))) {
				String strResultData = (String)getEmptyStrIfNull(result_data.get(Integer.toString(i)));
				//strResultData = strResultData.replace('\"','\n');
				String referralData	= "";
				try{
					if(rslt_type.equalsIgnoreCase("Q")){
						lineRecord.put("result_str", "");
					}
					if (func_type.equals("EXTERNAL")) {
						lineRecord.put("func_type",func_type);
						referralData = getReferralDetails((String)getEmptyStrIfNull(recordSet.get("order_id")));
					}
				}catch(Exception e) {
					System.err.println("External errror"+e.toString());
				}
 

				strResultData = referralData +"\n"+ strResultData;

				lineRecord.put("result_data",strResultData);
				if (cultureTestRecord.containsKey(Integer.toString(i))) {
					lineRecord.put("organism_data",cultureTestRecord.get(Integer.toString(i)));
				}
			}

			lineRecords.add(i, lineRecord);	// putting this line record in the lineRecords ArrayList.
		}
	}

	public boolean setResultData(String index, String data)
	{
		try
		{
			result_data.put(index,data);
			//result_data.put(index,data);
			return true;
		}catch(Exception exp)
		{
			return false;
		}
	}

	public String getResultData(String index)
	{
		try
		{
			String temp_data = null;
			
			if(result_data.get(index)!=null)
				temp_data = (String)result_data.get(index);
				//temp_data = (String)result_data.get(index);
				temp_data=temp_data.trim();
			return temp_data;
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}

/*	public boolean setResultHtmlData(String index, String data)
	{
		try
		{
			result_html_data.put(index, data);
			//System.out.println("in setResultData:true");
			return true;
		}catch(Exception exp)
		{
			//System.out.println("in setResultData:false");
			return false;
		}
	}

	public String getResultHtmlData(String index)
	{
		try
		{
			String temp_data = null;
			if(result_html_data.get(index)!=null)
				temp_data = (String)result_html_data.get(index);
			
			return temp_data;
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
*/	

/**
	This will return the "insert/update/no operation" mode.
	@return		:	String (0=no operation,1=insert,2=update)
*/

	public String returnMode(String order_id, String report_srl_no) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String result_status = "";
		String mode = "0";
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHECK_UPDATE_OR_INSERT") ) ;
				pstmt.setString( 1, order_id.trim() ) ;
				pstmt.setString( 2, report_srl_no.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				result_status = resultSet.getString( "result_status" )  ;
			}

			if(result_status==null || result_status.equals(""))
				mode = "1";
			else if(result_status.equals("1") || result_status.equals("2"))
				mode = "2";
			else if(result_status.equals("3"))
				mode = "0";

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return mode;
	}

/**
	To get the user (Name) for the login_user
	@return		:	ArrayList
*/
	public String[] getUser(String appl_user_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_DFLT_PRACTITIONER") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, appl_user_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) { // one record
				record[0] = resultSet.getString( "func_role_id" )  ;
				record[1] = resultSet.getString("practitioner_name");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ) ;
		}
		if(record[0]==null) record[0] = "";
		if(record[1]==null) record[1] = "";
		return record;
	}


/*********************METHOD TO Insert it is called when mode = 1*************************/

public HashMap insert()	{
		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
	try{
		map.put( "result", new Boolean( false ) ) ;
		//HashMap tabData = new HashMap() ;
		map.put("message",map.get("msgid"));

		map.put("lineRecords",lineRecords);
		map.put("resultRecord",resultRecord);
		map.put("CommonRecords",commonRecord);
		String bill_message=OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
		if(bill_message.indexOf("?")!=-1)
		{
				bill_message   = bill_message.substring(0,bill_message.indexOf("?"))+"'"+language_id+"'"+bill_message.substring(bill_message.indexOf("?")+1)  ;
		}


		sqlMap.put("SQL_OR_RESULT_REPORTING_INSERT_DETAIL",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_INSERT_DETAIL"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_INSERT_HEADER",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_INSERT_HEADER"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_UPDATE_CLOB",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_CLOB"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE",OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_MESSAGE",bill_message);
		sqlMap.put("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION",OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED",OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED"));
        //sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE", OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE") );
        sqlMap.put("SQL_OR_RESULT_ENTRY_ORGANISM_INSERT",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_INSERT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_ORGANISM_DELETE",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_DELETE"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT"));
		sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OHRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
		sqlMap.put("SQL_OR_ORDER_GET_CHART_RESULT",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_CHART_RESULT") );
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE") ) ;
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT") ) ;
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO") ) ;
			
		//return map ;
		return getResult(map,sqlMap );

		}catch(Exception e){
//		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
		}
		finally {	//Common-ICN-0044
			map.clear();	
			sqlMap.clear();	
		}
}

/*********************METHOD TO UPDATE it is called when mode = 2*************************/

public HashMap modify()	{
		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
	try{
		map.put( "result", new Boolean( false ) ) ;
		//HashMap tabData = new HashMap() ;
		map.put("message",map.get("msgid"));

		map.put("lineRecords",lineRecords);
		map.put("resultRecord",resultRecord);
		map.put("CommonRecords",commonRecord);
		String bill_message=OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
		if(bill_message.indexOf("?")!=-1)
		{
				bill_message   = bill_message.substring(0,bill_message.indexOf("?"))+"'"+language_id+"'"+bill_message.substring(bill_message.indexOf("?")+1)  ;
		}


		sqlMap.put("SQL_OR_RESULT_REPORTING_UPDATE_HEADER",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_HEADER"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_UPDATE_DETAIL",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_DETAIL"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_UPDATE_CLOB",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_CLOB"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT",OHRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE",OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_MESSAGE",bill_message);
		sqlMap.put("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION",OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED",OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED"));
        //sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE", OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE") );
        sqlMap.put("SQL_OR_RESULT_ENTRY_ORGANISM_INSERT",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_INSERT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_ORGANISM_DELETE",OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_DELETE"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_DELETE",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_DELETE"));
		sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OHRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
		sqlMap.put("SQL_OR_ORDER_GET_CHART_RESULT",OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_CHART_RESULT") );
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE") ) ;
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT") ) ;
		sqlMap.put("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO",OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO") ) ;
		

		//return map ;
		return getResult(map,sqlMap );

		}catch(Exception e){
//		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
		}
		finally {	//Common-ICN-0044
			map.clear();	
			sqlMap.clear();		
		}
}

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) {
	HashMap map  = new HashMap() ;
	HashMap tabDataParam =  new HashMap() ;
	try
		{
			StringBuffer tmpBuff	= new StringBuffer();
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );

			/*InitialContext context = new InitialContext();
			Object object		   = context.lookup(OHRepository.getOrKeyValue("OR_RESULT_ENTRY_JNDI"));
			ORResultEntryHome home  = (ORResultEntryHome) PortableRemoteObject.narrow( object,ORResultEntryHome.class );
			ORResultEntryRemote remote = home.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OHRepository.getOrKeyValue("OR_RESULT_ENTRY_JNDI"), OHResultEntryHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabDataParam;
				argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
				paramArray[0]	= tabDataParam.getClass();
				paramArray[1]	= sqlMap.getClass();
													
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE")))
			{
				return null ;
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
			{
				//map = remote.insert(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
// String str_err = ((String)map.get("traceVal"));
				//map = insert(tabDataParam, sqlMap ) ;
				// Temporarily the below two lines are commented for testing so that the report printing should not work.
				if(((Boolean)map.get("result")).booleanValue()) {
					map.put("printReport",doReportPrinting());
					result_data = new HashMap();
				}
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			{
				//map = remote.modify(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				//map = modify(tabDataParam, sqlMap )    ;
				// Temporarily the below two lines are commented for testing so that the report printing should not work.
				if(((Boolean)map.get("result")).booleanValue()) { 
					map.put("printReport",doReportPrinting());
					result_data = new HashMap();
				}
			}
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			argArray	= null;
			paramArray	= null;
			if( ((Boolean) map.get( "result" )).booleanValue() ){
					if(map.get( "message" ).equals("RECORD_MODIFIED") || map.get( "message" ).equals("RECORD_INSERTED")){//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					}
					
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
		  return map;

	 }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}
	finally {	//Common-ICN-0044
			map.clear();	
			sqlMap.clear();		
			tabDataParam.clear();		
		}

 }//End of Method

/**
 * Report Printing method which calls the OnLinePrinting bean to print the report.
 */
	private String doReportPrinting()
	{
		StringBuffer printingReport = new StringBuffer();
		String order_id = (String)commonRecord.get("order_id");
		String report_srl_no = (String)commonRecord.get("report_srl_no");
		String result_status = (String)resultRecord.get("result_status");
		String auth_reqd_yn = (String)resultRecord.get("auth_reqd_yn");
		String auth_reqd_yn_db = (String)resultRecord.get("auth_reqd_yn_db");
 
		boolean shouldPrint = false;

		printingReport.append(result_status + ", " + auth_reqd_yn_db + ", " + auth_reqd_yn + ", ");
 		if(result_status.trim().equals("3"))
			if (auth_reqd_yn_db.trim().equalsIgnoreCase("N"))
				shouldPrint = true;
			else if (auth_reqd_yn_db.trim().equalsIgnoreCase("Y") && auth_reqd_yn.trim().equalsIgnoreCase("Y"))
				shouldPrint = true;
 		printingReport.append(" || -1 || ");
	
		if(shouldPrint)
		{
			try
			{
				reportParameters = getReportDetails(order_id);
				reportParameters.put("facility_id", commonRecord.get("facility_id"));
				reportParameters.put("ord_id", order_id);
				reportParameters.put("report_srl_no", report_srl_no);
 				//printingReport += " || reportParameters >  "+reportParameters;

				/*OnLinePrinting online_print = new OnLinePrinting(request,response);
				HashMap tmp_map = (HashMap)online_print.printResultEntryReport(reportParameters);
				String tmp_vals = (String)tmp_map.get("traceVal");
				printingReport += " || " + tmp_vals + " || ";
				*/

			}catch(Exception ex)
			{
				printingReport.append(" -- Error while printing - " + ex);
			}
		}
		else printingReport.append("Print Not Required.");
		return printingReport.toString();
	}

/**
	This will return a hashtable with all the report details required to call a report printing
	@return		:	Hashtable
*/

	public Hashtable getReportDetails(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		Hashtable reportDetails		= new Hashtable();
		String colVal				= null;		
		//int index = 0;
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_REPORT_DETAILS") ) ;
				pstmt.setString( 1, order_id.trim() ) ;
				try{
				resultSet = pstmt.executeQuery() ;
				}
				catch(Exception ex)
			{
					ex.printStackTrace();
					connection.rollback();
					System.err.println("SQL_OR_RESULT_ENTRY_REPORT_DETAILS loading Failed" ) ;
					
			}

			while ( resultSet != null && resultSet.next() )
			{
				colVal = resultSet.getString( "order_type_code" )  ;
				if (colVal == null)	colVal = "";
				reportDetails.put("ord_typ_code", colVal);
				colVal = resultSet.getString( "patient_class" )  ;
				if (colVal == null)	colVal = "";
				reportDetails.put("patient_class", colVal);
				colVal = resultSet.getString( "encounter_id" )  ;
				if (colVal == null)	colVal = "";
				reportDetails.put("encounter_id", colVal);
				colVal = resultSet.getString( "priority" )  ;
				if (colVal == null)	colVal = "";
				reportDetails.put("priority", colVal);
				colVal = resultSet.getString( "source_type" )  ;
				if (colVal == null)	colVal = "";
				reportDetails.put("source_type", colVal);
				colVal = resultSet.getString( "source_code" )  ;
				if (colVal == null)	colVal = "";
				reportDetails.put("location_code", colVal);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" +e.toString()) ;
		//	e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return reportDetails;
	}


	public int getFormatCount(String order_id, String called_from) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int total					= 0;
		try{
				connection	= getConnection();
				if(called_from.equals("LINE"))
				{
					pstmt		= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FORMAT_LINE_DETAILS"));
					pstmt.setString(1, order_id.trim());
				}
				else  // Then For the Header
				{
					pstmt		= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_COUNT"));
					pstmt.setString(1, order_id.trim());
				}
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						total = resultSet.getInt( "total" );
					}
				}

				}catch ( Exception e )	{
					System.err.println( "Error loading values from database") ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
				return total;
	}



	private Object getEmptyStrIfNull(Object obj)
	{
		if(obj==null)
			return "";
		else return obj;
	}

	
/*****************************************************************************/

    public String getReferralDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String referral_dtls = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_REFERRAL_DETAILS") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				referral_dtls = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return referral_dtls;
	}











/********************************** EJB *****************************************/
/*	public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  {
	StringBuffer messages =  null ;
	StringBuffer traceVal =  null ;
	HashMap map =null;

	Properties  pt = null;
	Connection connection = null ;
	StringBuffer traceVals = new StringBuffer();

	 PreparedStatement pstmt_header	    	= null ;
	 PreparedStatement pstmt_detail		    = null ;
	 PreparedStatement pstmt_status		    = null ;
	 PreparedStatement pstmt_order			= null ;
	 PreparedStatement pstmt_line 			= null ;
	 PreparedStatement pstmt_clob			= null ;
	 PreparedStatement pstmt_parent			= null ;
	 PreparedStatement pstmt_parent1		= null ;
	 ResultSet rs1 	=	null;
	 PreparedStatement pstmt_freq_expl		= null ;
	 PreparedStatement pstmt_abn_child_chk	= null ;
	 CallableStatement cstmt 				= null;
	 ResultSet rs  = null;
	 ResultSet rs5 = null;
	 ResultSet rs2 = null;

	try {
			messages = new StringBuffer() ;
			traceVal = new StringBuffer() ;
			map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "flag" ) ;

			HashMap tabData	=(HashMap)tabDataParam.get("tabData");
//			pt			    =(Properties)tabDataParam.get("properties");
//			connection		= getConnection(pt) ;
			connection		= getConnection() ;

			ArrayList lineRecords		=(ArrayList)tabData.get("lineRecords");
			HashMap resultRecord		=(HashMap)tabData.get("resultRecord");
			HashMap commonRecord		=(HashMap)tabData.get("CommonRecords");

			int insert_header = 0;
			int insert_detail[] = {};
			int update_l_status[] = {};
			int update_order = 0;
			int update_line = 1;
			int update_p_order = 0;
			int update_p_line = 0;

			boolean   insert_dl = false ;
			boolean   update_l_st = false;

			String err_message	= "";
			String bill_yn		= "N";
			String err_bill_yn  = "N";
			String old_srl_no	= "";

			String login_by_id			=(String)commonRecord.get("login_by_id" ) ;
			String login_at_ws_no		=(String)commonRecord.get("login_at_ws_no" ) ;
			String login_facility_id	=(String)commonRecord.get("login_facility_id" ) ;
			String order_type_code		=(String)commonRecord.get("order_type_code" ) ;
			String order_id			    =(String)commonRecord.get("order_id" ) ;
			String child_order_index	=(String)commonRecord.get("child_order_index" ) ;
			String child_reporting_date	=(String)commonRecord.get("child_reporting_date" ) ;
			String parent_order_id		= "";
			boolean any_abnormal_child	= false;;
			String report_srl_no	    =(String)commonRecord.get("report_srl_no" );
			String patient_id		    =(String)commonRecord.get("patient_id" );
			String encounter_id		    = "";
			String patient_class	    = "";

			traceVal.append("1");

			 String SQL_OR_RESULT_REPORTING_INSERT_HEADER	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_HEADER");
			 String SQL_OR_RESULT_REPORTING_INSERT_DETAIL	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_DETAIL");
			 String SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER		= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE");
			 String SQL_OR_RESULT_REPORTING_UPDATE_CLOB		= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_CLOB");
			 String SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT");
			 String SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT");
			 String SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION");
			 String SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK");
			 String SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG  = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG");
			 String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE  = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE");
			 String SQL_OR_ORDER_ENTRY_BILL_MESSAGE			= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
			 String SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS");

			 traceVal.append("2");

			 java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy H:m");
			 java.util.Date today = new java.util.Date();
			 String dateString = dt.format(today);


			 traceVal.append("3");

			pstmt_header = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_HEADER);
			pstmt_detail = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_DETAIL);
			pstmt_status = connection.prepareStatement(SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC);
			pstmt_order = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER);
			pstmt_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);
			pstmt_clob = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_CLOB);
			pstmt_parent = connection.prepareStatement(SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT);
			pstmt_parent1 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT);
			pstmt_freq_expl = connection.prepareCall(SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION);
			pstmt_abn_child_chk = connection.prepareCall(SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK);

			pstmt_header.setString(1 ,order_type_code);
			pstmt_header.setString(2 ,order_id);
			pstmt_header.setString(3 ,report_srl_no);
			pstmt_header.setString(4 ,(String)resultRecord.get("rpt_pract_id"));

			//traceVal.append("order_type_code="+order_type_code);
			//traceVal.append("order_id="+order_id);
			//traceVal.append("report_srl_no="+report_srl_no);
			//traceVal.append("rpt_pract_id="+(String)resultRecord.get("rpt_pract_id"));

			if(child_order_index.trim().equals(""))
				pstmt_header.setString(5 ,dateString);	// Enter system date in case of a normal order.
			else
				pstmt_header.setString(5 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

			String auth_reqd_yn1		= (String)resultRecord.get("auth_reqd_yn") ;
			String auth_reqd_id1		= "";
			String auth_reqd_time1		= null;
			if(auth_reqd_yn1.trim().equalsIgnoreCase("Y")){
					auth_reqd_id1	= (String)commonRecord.get("practitioner_id");
					auth_reqd_time1  = dateString;
			}

			pstmt_header.setString(6 ,(String)resultRecord.get("auth_reqd_yn_db"));
			pstmt_header.setString(7 ,auth_reqd_id1);
			pstmt_header.setString(8 ,auth_reqd_time1);
			pstmt_header.setString(9 ,(String)resultRecord.get("result_status"));
			pstmt_header.setString(10 ,(String)resultRecord.get("result_type"));
			pstmt_header.setString(11,login_by_id);
			pstmt_header.setString(12,login_at_ws_no);
			pstmt_header.setString(13,login_facility_id);
			pstmt_header.setString(14,login_by_id);
			pstmt_header.setString(15,login_at_ws_no);
			pstmt_header.setString(16,login_facility_id);

			 traceVal.append("4");

			insert_header	 = pstmt_header.executeUpdate();
			 traceVal.append("5");

			int sizeDetail	= lineRecords.size()  ;
			 traceVal.append("6*"+sizeDetail+"*");
			 //traceVal.append("lineRecords="+lineRecords.toString());


			String episode_id 			=  "";
			String episode_visit_num 	=  "";
			patient_class 				=  "";

			pstmt_header = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS);
			pstmt_header.clearParameters();
			pstmt_header.setString(1, order_id);
traceVal.append("rs order_id"+order_id);
			rs = pstmt_header.executeQuery();
			if(rs!=null && rs.next())
			{
traceVal.append("Inside");
					encounter_id		= rs.getString( "encounter_id" );
					patient_class 	= rs.getString( "patient_class" );
					episode_id			= rs.getString( "episode_id" );
					episode_visit_num 	= rs.getString( "episode_visit_num" );
			}
traceVal.append("rs encounter_id"+encounter_id);
traceVal.append("rs patient_class"+patient_class);
traceVal.append("rs episode_id"+episode_id);
traceVal.append("rs episode_visit_num"+episode_visit_num);




			for (int i=0;i<sizeDetail;i++){
				HashMap lineRecord = (HashMap)lineRecords.get(i);
			//traceVal.append("~~~~~"+lineRecord.toString());
				pstmt_detail.setString(1 ,order_type_code);
				pstmt_detail.setString(2 ,order_id);
				pstmt_detail.setString(3 ,report_srl_no);
				pstmt_detail.setString(4 ,(String)lineRecord.get("line_srl_num"));
				pstmt_detail.setString(5 ,(String)lineRecord.get("srl_num"));

				if(child_order_index.trim().equals(""))
					pstmt_detail.setString(6 ,dateString);	// Enter system date in case of a normal order.
				else
					pstmt_detail.setString(6 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

				pstmt_detail.setString(7 ,(String)lineRecord.get("msr_panel_id"));
				pstmt_detail.setString(8 ,(String)lineRecord.get("msr_id"));
			 traceVal.append("7");
				String auth_reqd_yn		= (String)lineRecord.get("auth_reqd_yn") ;
				String auth_reqd_id		= "";
				String auth_reqd_time	= null;
				if(auth_reqd_yn.trim().equalsIgnoreCase("Y")){
					auth_reqd_id	= (String)commonRecord.get("practitioner_id");
					auth_reqd_time  = dateString;
				}
			 traceVal.append("8");
				pstmt_detail.setString(9 ,(String)lineRecord.get("auth_reqd_yn_db"));
				pstmt_detail.setString(10 ,auth_reqd_id);
				pstmt_detail.setString(11 ,auth_reqd_time);
				pstmt_detail.setString(12 ,(String)lineRecord.get("result_type"));
				pstmt_detail.setString(13 ,(String)lineRecord.get("result_num"));
				pstmt_detail.setString(14 ,(String)lineRecord.get("result_num_uom"));
				pstmt_detail.setString(15 ,(String)lineRecord.get("result_str"));
				pstmt_detail.setString(16 ,(String)lineRecord.get("result_status"));
				pstmt_detail.setString(17 ,(String)lineRecord.get("normal_low"));
				pstmt_detail.setString(18 ,(String)lineRecord.get("normal_high"));
				pstmt_detail.setString(19 ,(String)lineRecord.get("critical_low"));
				pstmt_detail.setString(20 ,(String)lineRecord.get("critical_high"));
				pstmt_detail.setString(21 ,(String)lineRecord.get("norm_abnorm_ind"));
				pstmt_detail.setString(22 ,(String)lineRecord.get("result_comments"));
				pstmt_detail.setString(23 ,login_by_id);
				pstmt_detail.setString(24 ,login_at_ws_no);
				pstmt_detail.setString(25 ,login_facility_id);
				pstmt_detail.setString(26 ,login_by_id);
				pstmt_detail.setString(27 ,login_at_ws_no);
				pstmt_detail.setString(28 ,login_facility_id);

				pstmt_detail.addBatch();
			}

			 insert_detail = pstmt_detail.executeBatch();
			 if((insert_detail.length > 0)){ //check updation in SYN
						insert_dl= true ;
			 }else if((insert_detail.length == (-3))){
						insert_dl= false ;
			 }
			traceVal.append("9");

			// Inserting the clob data.
			if(insert_dl)
			for (int i=0;i<sizeDetail;i++)
			{
				HashMap lineRecord = (HashMap)lineRecords.get(i);
				String rslt_type = (String)lineRecord.get("rslt_type");
				String msg = "";
				if(rslt_type.equalsIgnoreCase("F"))
					msg = insertResultDataClob(pstmt_clob, (String)lineRecord.get("result_data"), order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
				traceVal.append(msg);
			}
			// Inserted the clob data.

			String rec_result_type = (String)resultRecord.get("result_type");
			if(rec_result_type==null) rec_result_type="";
			if(!rec_result_type.trim().equals(""))
				if(!rec_result_type.trim().equals("N"))
					rec_result_type = "A";

			traceVal.append((String)resultRecord.get("result_status"));
			traceVal.append((String)resultRecord.get("order_status"));
			traceVal.append(rec_result_type);
			traceVal.append(","+(String)resultRecord.get("auth_reqd_yn_db")+",");
			traceVal.append((String)resultRecord.get("auth_reqd_yn"));


			String status = "";
			String orderStatus = (String)resultRecord.get("order_status");

			pstmt_status.clearParameters();
			pstmt_status.setString(1,(String)resultRecord.get("result_status"));
			pstmt_status.setString(2,(String)resultRecord.get("order_status"));
			pstmt_status.setString(3,rec_result_type);
			pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
			pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
			rs = pstmt_status.executeQuery();
			status = "";
			if(rs!=null && rs.next())
				status = (String)rs.getString("or_status");

			traceVal.append("-10-'"+status+"'");

			 pstmt_order.setString(1, status);
			 if(orderStatus.equalsIgnoreCase("C"))
				 pstmt_order.setString(2, status);
			 else pstmt_order.setString(2, "");
			 pstmt_order.setString(3, order_id);
			 update_order = pstmt_order.executeUpdate();

			traceVal.append("11");

			// Handling the frequency explosion concept, for or_order. -- Start.
			if(!child_order_index.trim().equals(""))
			{
				traceVal.append(" **FE--");
				traceVal.append(" childIndex = "+child_order_index);

				pstmt_parent.clearParameters();
				pstmt_parent.setString(1,order_id);
				rs1 = pstmt_parent.executeQuery();
				if(rs1!=null && rs1.next())
					parent_order_id = (String)rs1.getString("parent_order_id");
				traceVal.append(" POrderId = "+parent_order_id);

				if(parent_order_id != null && !parent_order_id.trim().equals(""))
				{
					traceVal.append(" Parent Found ");
					String p_result_status = "P";
					if(child_order_index.trim().equals("L"))
					{
						p_result_status = (String)resultRecord.get("result_status");
						pstmt_abn_child_chk.setString(1, parent_order_id);
						rs5 = pstmt_abn_child_chk.executeQuery();
						if(rs5!=null && rs5.next())
						{
							String abnormal_child = rs5.getString("abnormal_child");
							if(abnormal_child != null && abnormal_child.trim().equalsIgnoreCase("X"))
								any_abnormal_child = true;
						}
					}
					pstmt_status.clearParameters();
					pstmt_status.setString(1,p_result_status);
					pstmt_status.setString(2,"C");
					if(any_abnormal_child)
						pstmt_status.setString(3,"A");
					else
						pstmt_status.setString(3,rec_result_type);
					pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
					pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
					rs = pstmt_status.executeQuery();
					status = "";
					if(rs!=null && rs.next())
						status = (String)rs.getString("or_status");

					traceVal.append(p_result_status+"C"+rec_result_type);
					traceVal.append((String)resultRecord.get("auth_reqd_yn_db"));
					traceVal.append((String)resultRecord.get("auth_reqd_yn"));

					 pstmt_order.setString(1, status);
					 pstmt_order.setString(2, status);
					 pstmt_order.setString(3, parent_order_id);
					 update_p_order = pstmt_order.executeUpdate();

					// Exploding frequency immediately after the last child.
					String temp_result_status = (String)resultRecord.get("result_status");
					traceVal.append("#"+temp_result_status+"#");
					if(child_order_index.trim().equals("F") && temp_result_status.trim().equals("3"))
					{
						traceVal.append(" Exploding Frequency");

						String p_freq_code = "";
						String p_start_date_time = "";
						String order_category = "";
						//String patient_class = "";
						String v_discrete_cont_order_yn = "";

						pstmt_parent1.setString(1,parent_order_id);
						rs2 = pstmt_parent1.executeQuery();
						if(rs2!=null && rs2.next())
						{
							p_freq_code = (String)rs2.getString("p_freq_code");
							p_start_date_time = (String)rs2.getString("p_start_date_time");
							order_category = (String)rs2.getString("order_category");
							patient_class = (String)rs2.getString("patient_class");
							v_discrete_cont_order_yn = (String)rs2.getString("v_discrete_cont_order_yn");
						}
						traceVal.append("-"+p_freq_code+"-"+p_start_date_time+"-"+order_category+"-"+patient_class+"-"+v_discrete_cont_order_yn+"-");

						pstmt_freq_expl.setString(1,parent_order_id);
						pstmt_freq_expl.setString(2,p_freq_code);
						pstmt_freq_expl.setString(3,p_start_date_time);
						pstmt_freq_expl.setString(4,order_category);
						pstmt_freq_expl.setString(5,patient_class);
						pstmt_freq_expl.setString(6,v_discrete_cont_order_yn);

						boolean explosion = pstmt_freq_expl.execute();
						traceVal.append("Frequency Explosion="+explosion);
					}
					 // Exploding frequency immediately after the last child.
				}
				traceVal.append("--FE** ");
			}
			// Handling the frequency explosion concept, for or_order. -- End.

			String msr_panel_id = "";
			String common_result_type = "";
			String first_result_type = "";
			int rti = 0;
			for (int i=0;i<sizeDetail;i++)
			{
				traceVal.append("12a");
				HashMap lineRecord = (HashMap)lineRecords.get(i);

				String line_result_type = (String)lineRecord.get("result_type");
				traceVal.append("^"+line_result_type+"^");
				if(line_result_type==null) line_result_type="";
				if(!line_result_type.trim().equals(""))
					if(!line_result_type.trim().equals("N"))
					{
						line_result_type = "A";
						common_result_type = "A";
					}

				if(!msr_panel_id.equalsIgnoreCase((String)lineRecord.get("msr_panel_id")))
				{
					msr_panel_id = (String)lineRecord.get("msr_panel_id");
					first_result_type = line_result_type;
					rti = 1;
				}
				else
				{
					if(rti==1)	common_result_type = first_result_type;
					rti++;
					if(common_result_type.equals("A"))	line_result_type = "A";
					else if(common_result_type.equals("N"))	line_result_type = "N";
					common_result_type = line_result_type;
				}

				traceVal.append((String)lineRecord.get("result_status"));
				traceVal.append((String)resultRecord.get("order_status"));
				traceVal.append(line_result_type);
				traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
				traceVal.append((String)lineRecord.get("auth_reqd_yn"));

				status = "";
				orderStatus = (String)resultRecord.get("order_status");
				pstmt_status.clearParameters();
				pstmt_status.setString(1,(String)lineRecord.get("result_status"));
				pstmt_status.setString(2,(String)resultRecord.get("order_status"));
				pstmt_status.setString(3,line_result_type);
				pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
				pstmt_status.setString(5,(String)lineRecord.get("auth_reqd_yn"));
				rs = pstmt_status.executeQuery();
				if(rs!=null && rs.next())
					status = (String)rs.getString("or_status");

				 pstmt_line.setString(1, status);
				if(orderStatus.equalsIgnoreCase("C"))
					pstmt_line.setString(2, status);
				else pstmt_line.setString(2, "");
				 pstmt_line.setString(3, order_id);
				 pstmt_line.setString(4, (String)lineRecord.get("line_srl_num"));
				 pstmt_line.addBatch();
			traceVal.append(status+"12b-");

			// For Billing Related
			try{
traceVal.append("Order Status Result _ type"+(String)lineRecord.get("result_type"));
traceVal.append("Order Status result_status"+(String)lineRecord.get("result_status"));
traceVal.append("patient_id Ins"+patient_id);
				if(((String)lineRecord.get("result_status")).equalsIgnoreCase("3"))
				{
					if(!old_srl_no.equals((String)lineRecord.get("line_srl_num")))
					{
						cstmt = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG+" }");
						cstmt.setString(1,  patient_id);
						cstmt.setString(2,  encounter_id);
						cstmt.setString(3,  patient_class);
						cstmt.setString(4,  order_id);
						cstmt.setString(5,  (String)lineRecord.get("line_srl_num"));
						cstmt.setString(6, login_by_id);
						cstmt.setString(7, login_at_ws_no);
						cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;
						cstmt.execute();
						bill_yn	 		= cstmt.getString(8);
						if(bill_yn!=null && bill_yn.equals("Y"))
							err_bill_yn			= "Y";
						err_message 	= cstmt.getString(9);
						if(err_message!=null && ! err_message.equals(""))
						{
							update_line		= 0;
							messages		= new StringBuffer();
							messages.append(err_message);
				    	}
				    	old_srl_no = (String)lineRecord.get("line_srl_num");
					}
		  	  	}
    		}catch(Exception ex)
    		{
				update_line		= 0;
				traceVal.append("Exception Billing");
    		}


				// Handling the frequency explosion concept, for or_order. -- Start.
				if(!child_order_index.trim().equals(""))
				{
					traceVal.append(" **FE--");
//					traceVal.append(" childIndex = "+child_order_index);
//					ResultSet rs1 ;
//					pstmt_parent.clearParameters();
//					pstmt_parent.setString(1,order_id);
//					rs1 = pstmt_parent.executeQuery();
//					if(rs1!=null && rs1.next())
//						parent_order_id = (String)rs1.getString("parent_order_id");
//					traceVal.append(" POrderId = "+parent_order_id);
//
					if(parent_order_id != null && !parent_order_id.trim().equals(""))
					{
						traceVal.append(" Parent Found ");
						String p_result_status = "P";
						if(child_order_index.trim().equals("L"))
							p_result_status = (String)resultRecord.get("result_status");
						pstmt_status.clearParameters();
						pstmt_status.setString(1,p_result_status);
						pstmt_status.setString(2,"C");
						if(any_abnormal_child)
							pstmt_status.setString(3,"A");
						else
							pstmt_status.setString(3,line_result_type);
						pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
						pstmt_status.setString(5,(String)lineRecord.get("auth_reqd_yn"));
						rs = pstmt_status.executeQuery();
						status = "";
						if(rs!=null && rs.next())
							status = (String)rs.getString("or_status");

						traceVal.append(p_result_status+"C"+line_result_type);
						traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
						traceVal.append((String)lineRecord.get("auth_reqd_yn"));

						pstmt_line.setString(1, status);
						pstmt_line.setString(2, status);
						pstmt_line.setString(3, parent_order_id);
						pstmt_line.setString(4, (String)lineRecord.get("line_srl_num"));
						pstmt_line.addBatch();
					}
					traceVal.append("--FE** ");
				}
				// Handling the frequency explosion concept, for or_order. -- End.
			}
				update_l_status = pstmt_line.executeBatch();
			traceVal.append("13");

			 if((update_l_status.length > 0)){ //check updation in SYN
				 update_l_st = true;
			 }else if((update_l_status.length == (-3))){
				 update_l_st = false;
			 }


			// Billing Consolidated Procedure
			if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0){
				if(err_bill_yn.equals("Y"))
				{

					cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");
					cstmt.setString(1,  login_facility_id);
					cstmt.setString(2,  patient_id);
					if( patient_class!=null && (patient_class.equals("IP") || patient_class.equals("EA")) )
						cstmt.setString(3, "I");
					else
						cstmt.setString(3, "O");			// EPISODE_TYPE
					cstmt.setString(4,  episode_id);		// EPISODE_ID
					cstmt.setString(5,  episode_visit_num); // VISIT_NUM
					cstmt.setString(6,  order_id); 			// ORDER_ID
					cstmt.setString(7,  "OR");
					cstmt.setString(8,  null);
					cstmt.setString(9,  login_by_id);
					cstmt.setString(10, login_at_ws_no);
					cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
					cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
					cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
					cstmt.execute();
					String err_code 	= cstmt.getString(11);  // ERR_CODE
					String message_id 	= cstmt.getString(12);  // SYS_MESSAGE_ID
					err_message			= cstmt.getString(13);  // ERROR_TEXT
					if(err_code!=null && !err_code.equals("") && !err_code.equals("10") && err_message!=null && !err_message.equals(""))
					{
						update_line		= 0;			// Come out
						messages		= new StringBuffer();
						messages.append( err_message ) ;
					} else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
					{
						update_line		= 0;				// Come out
						messages		= new StringBuffer();

						// Query from the database for the message id and display the Message
						pstmt_header		= connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
						pstmt_header.clearParameters();
						pstmt_header.setString(1, message_id);
						rs=pstmt_header.executeQuery();
						if(rs!=null)
						{
							while(rs.next())
							{
								messages.append(rs.getString(1));
							}
						}
					}
				} //err
	  		}



			traceVal.append("#"+insert_header+","+insert_dl+","+update_order+","+update_l_st+",");
			if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0 ){
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append("RECORD_INSERTED") ;
			}else{
					connection.rollback();
					if(update_line!=0)
						messages.append( "Insert Failed" ) ;
			}

	 }catch( Exception e ){
						traceVal.append("In Exception==");
						e.printStackTrace();
						traceVal.append(e);
						traceVal.append("#"+e.getMessage());
						map.put( "traceVal", traceVal.toString() ) ;

				try {
							connection.rollback();
							//closeConnection( connection,pt );
							closeConnection(connection);
					} catch ( Exception ee ) {
							messages.append(ee.getMessage() ) ;
					}
					messages.append( e.getMessage() ) ;
					e.printStackTrace() ;
				  } finally{
						try {
	  						closeResultSet( rs ) ;
	 						closeStatement( pstmt_detail ) ;
	 						closeStatement( pstmt_status ) ;
	 						closeResultSet( rs1 ) ;
	 						closeStatement( pstmt_order ) ;
	 						closeStatement( pstmt_line ) ;
	 						closeStatement( pstmt_clob ) ;
	 						closeResultSet( rs5 ) ;
	 						closeResultSet( rs2 ) ;
	 						closeStatement( pstmt_parent ) ;
	 						closeStatement( pstmt_parent1 ) ;
	 						closeStatement( pstmt_freq_expl ) ;
	 						closeStatement( pstmt_abn_child_chk ) ;

							closeStatement( cstmt);
							closeStatement( pstmt_header);
							//closeConnection( connection,pt);
							closeConnection(connection);
						} catch ( Exception fe ) {
							System.err.println( fe.getMessage() ) ;
							fe.printStackTrace() ;
						}
					}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
				return map ;


	}//End of Insert Method


	public HashMap modify(HashMap tabDataParam , HashMap sqlMap )
	{
		StringBuffer messages = null ;
		StringBuffer traceVal = null ;
		HashMap map = null;

		Properties  pt = null;
		Connection connection = null ;
		PreparedStatement pstmt_header	    	= null ;
			 PreparedStatement pstmt_detail		    = null ;
			 PreparedStatement pstmt_status		    = null ;
			 PreparedStatement pstmt_order			= null ;
			 PreparedStatement pstmt_line 			= null ;
			 PreparedStatement pstmt_clob			= null ;
			 PreparedStatement pstmt_parent			= null ;
			 ResultSet rs2 = null;
			 PreparedStatement pstmt_parent1		= null ;
			 PreparedStatement pstmt_freq_expl		= null ;
			 PreparedStatement pstmt_abn_child_chk	= null ;
			 CallableStatement cstmt 				= null;
	 		 ResultSet rs 	= null;
	 		 ResultSet rs1  = null;
	 		 ResultSet rs5 = null;


		try
		{
			messages = new StringBuffer() ;
			traceVal = new StringBuffer() ;
			map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "flag" ) ;

			traceVal.append("----- UPDATE CALLED -----");

			HashMap tabData			=(HashMap)tabDataParam.get("tabData");
//			pt			   			=(Properties)tabDataParam.get("properties");
//			connection				= getConnection(pt) ;
			connection				= getConnection() ;

			ArrayList lineRecords		=(ArrayList)tabData.get("lineRecords");
			HashMap resultRecord		=(HashMap)tabData.get("resultRecord");
			HashMap commonRecord		=(HashMap)tabData.get("CommonRecords");

			int update_header = 0;
			int update_detail[] = {};
			int update_l_status[] = {};
			int update_order = 0;
			int update_p_order = 0;
			int update_p_line = 0;
			int update_line   = 1;

			boolean   update_dl = false ;
			boolean   update_l_st = false;

			String err_message	= "";
			String bill_yn		= "N";
			String err_bill_yn  = "N";
			String old_srl_no	= "";

			String login_by_id			=(String)commonRecord.get("login_by_id" ) ;
			String login_at_ws_no		=(String)commonRecord.get("login_at_ws_no" ) ;
			String login_facility_id	=(String)commonRecord.get("login_facility_id" ) ;
			String order_type_code		=(String)commonRecord.get("order_type_code" ) ;
			String order_id			    =(String)commonRecord.get("order_id" ) ;
			String child_order_index	=(String)commonRecord.get("child_order_index" ) ;
			String child_reporting_date	=(String)commonRecord.get("child_reporting_date" ) ;
			String parent_order_id		= "";
			boolean any_abnormal_child	= false;;
			String report_srl_no	    =(String)commonRecord.get("report_srl_no" );
			String patient_id		    =(String)commonRecord.get("patient_id" );
			String encounter_id		    = "";
			String patient_class	    = "";

			traceVal.append("1");

			  String SQL_OR_RESULT_REPORTING_UPDATE_HEADER	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_HEADER");
			 String SQL_OR_RESULT_REPORTING_UPDATE_DETAIL	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_DETAIL");
			 String SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER		= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE");
			 String SQL_OR_RESULT_REPORTING_UPDATE_CLOB		= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_CLOB");
			 String SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT");
			 String SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT");
			 String SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION");
			 String SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK");
			 String SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG  = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG");
			 String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE  = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE");
			 String SQL_OR_ORDER_ENTRY_BILL_MESSAGE			= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
			 String SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS");

			 traceVal.append("2");

			 java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy H:m");
			 java.util.Date today = new java.util.Date();
			 String dateString = dt.format(today);

			 traceVal.append("3");

			pstmt_header = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_HEADER);
			pstmt_detail = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_DETAIL);
			pstmt_status = connection.prepareStatement(SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC);
			pstmt_order = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER);
			pstmt_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);
			pstmt_clob = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_CLOB);
			pstmt_parent = connection.prepareStatement(SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT);
			pstmt_parent1 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT);
			pstmt_freq_expl = connection.prepareCall(SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION);
			pstmt_abn_child_chk = connection.prepareCall(SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK);

			//traceVal.append("order_type_code="+order_type_code);
			//traceVal.append("order_id="+order_id);
			//traceVal.append("report_srl_no="+report_srl_no);
			//traceVal.append("rpt_pract_id="+(String)resultRecord.get("rpt_pract_id"));

			String auth_reqd_yn1		= (String)resultRecord.get("auth_reqd_yn") ;
			String auth_reqd_id1		= "";
			String auth_reqd_time1		= null;
			if(auth_reqd_yn1.trim().equalsIgnoreCase("Y")){
					auth_reqd_id1	= (String)commonRecord.get("practitioner_id");
					auth_reqd_time1  = dateString;
			}

			pstmt_header.setString(1 ,(String)resultRecord.get("rpt_pract_id"));

			if(child_order_index.trim().equals(""))
				pstmt_header.setString(2 ,dateString);	// Enter system date in case of a normal order.
			else
				pstmt_header.setString(2 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

			pstmt_header.setString(3 ,(String)resultRecord.get("auth_reqd_yn_db"));
			pstmt_header.setString(4 ,auth_reqd_id1);
			pstmt_header.setString(5 ,auth_reqd_time1);
			pstmt_header.setString(6 ,(String)resultRecord.get("result_status"));
			String tmp_result_type = (String)resultRecord.get("result_type");
			if(tmp_result_type==null || tmp_result_type.equals("null"))	tmp_result_type="";
			pstmt_header.setString(7 ,tmp_result_type);
			pstmt_header.setString(8, login_by_id);
			pstmt_header.setString(9, login_at_ws_no);
			pstmt_header.setString(10, login_facility_id);
			pstmt_header.setString(11 ,order_type_code);
			pstmt_header.setString(12 ,order_id);
			pstmt_header.setString(13 ,report_srl_no);

			 traceVal.append("4");

			update_header	 = pstmt_header.executeUpdate();
			 traceVal.append("5");



			String episode_id 			=  "";
			String episode_visit_num 	=  "";
			patient_class 				=  "";

			pstmt_header = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS);
			pstmt_header.clearParameters();
			pstmt_header.setString(1, order_id);
			rs = pstmt_header.executeQuery();
			if(rs!=null && rs.next())
			{
					encounter_id		= rs.getString( "encounter_id" );
					patient_class 		= rs.getString( "patient_class" );
					episode_id			= rs.getString( "episode_id" );
					episode_visit_num 	= rs.getString( "episode_visit_num" );
			}
			int sizeDetail	= lineRecords.size()  ;

			for (int i=0;i<sizeDetail;i++){
				HashMap lineRecord = (HashMap)lineRecords.get(i);
			 traceVal.append("7");

				if(child_order_index.trim().equals(""))
					pstmt_detail.setString(1 ,dateString);	// Enter system date in case of a normal order.
				else
					pstmt_detail.setString(1 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

				String auth_reqd_yn		= (String)lineRecord.get("auth_reqd_yn") ;
				String auth_reqd_id		= "";
				String auth_reqd_time	= null;
				if(auth_reqd_yn.trim().equalsIgnoreCase("Y")){
					auth_reqd_id	= (String)commonRecord.get("practitioner_id");
					auth_reqd_time  = dateString;
				}
			 traceVal.append("8");
				pstmt_detail.setString(2 ,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_detail.setString(3 ,auth_reqd_id);
				pstmt_detail.setString(4 ,auth_reqd_time);
			tmp_result_type = (String)lineRecord.get("result_type");
			if(tmp_result_type==null || tmp_result_type.equals("null"))	tmp_result_type="";
				pstmt_detail.setString(5 ,tmp_result_type);
				pstmt_detail.setString(6 ,(String)lineRecord.get("result_num"));
				pstmt_detail.setString(7 ,(String)lineRecord.get("result_str"));
				pstmt_detail.setString(8 ,(String)lineRecord.get("result_status"));
				pstmt_detail.setString(9 ,(String)lineRecord.get("norm_abnorm_ind"));
				pstmt_detail.setString(10 ,(String)lineRecord.get("result_comments"));
				pstmt_detail.setString(11 ,login_by_id);
				pstmt_detail.setString(12 ,login_at_ws_no);
				pstmt_detail.setString(13 ,login_facility_id);
				pstmt_detail.setString(14 ,order_type_code);
				pstmt_detail.setString(15 ,order_id);
				pstmt_detail.setString(16 ,report_srl_no);
				pstmt_detail.setString(17 ,(String)lineRecord.get("line_srl_num"));
				pstmt_detail.setString(18 ,(String)lineRecord.get("srl_num"));

				pstmt_detail.addBatch();
			}

			 update_detail = pstmt_detail.executeBatch();
			 if((update_detail.length > 0)){ //check updation in SYN
						update_dl= true ;
			 }else if((update_detail.length == (-3))){
						update_dl= false ;
			 }

			 traceVal.append("9");

			// Inserting the clob data.
			for (int i=0;i<sizeDetail;i++)
			{
				HashMap lineRecord = (HashMap)lineRecords.get(i);
				String rslt_type = (String)lineRecord.get("rslt_type");
				String msg = "";
			traceVal.append("#"+rslt_type);
				if(rslt_type.equalsIgnoreCase("F"))
				{
					msg = insertResultDataClob(pstmt_clob, (String)lineRecord.get("result_data"), order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
					traceVal.append(msg);
					traceVal.append("@");
				}
			}
			// Inserted the clob data.

			String rec_result_type = (String)resultRecord.get("result_type");
			if(rec_result_type==null) rec_result_type="";
			if(!rec_result_type.trim().equals(""))
				if (!rec_result_type.trim().equals("N"))
					rec_result_type = "A";

			traceVal.append((String)resultRecord.get("result_status"));
			traceVal.append((String)resultRecord.get("order_status"));
			traceVal.append(rec_result_type);
			traceVal.append(","+(String)resultRecord.get("auth_reqd_yn_db")+",");
			traceVal.append((String)resultRecord.get("auth_reqd_yn"));

			String status = "";
			String orderStatus = (String)resultRecord.get("order_status");
			//ResultSet rs ;
			pstmt_status.clearParameters();
			pstmt_status.setString(1,(String)resultRecord.get("result_status"));
			pstmt_status.setString(2,(String)resultRecord.get("order_status"));
			pstmt_status.setString(3,rec_result_type);
			pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
			pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
			rs = pstmt_status.executeQuery();
			if(rs!=null && rs.next())
				status = (String)rs.getString("or_status");

			traceVal.append("-10-'"+status+"'");
			 pstmt_order.setString(1, status);
			if(orderStatus.equalsIgnoreCase("C"))
				pstmt_order.setString(2, status);
			else	pstmt_order.setString(2, "");
			 pstmt_order.setString(3, order_id);
			 update_order = pstmt_order.executeUpdate();
			 traceVal.append("11");

			// Handling the frequency explosion concept, for or_order. -- Start.
			if(!child_order_index.trim().equals(""))
			{
				traceVal.append(" **FE--");
				traceVal.append(" childIndex = "+child_order_index);

				pstmt_parent.clearParameters();
				pstmt_parent.setString(1,order_id);
				rs1 = pstmt_parent.executeQuery();
				if(rs1!=null && rs1.next())
					parent_order_id = (String)rs1.getString("parent_order_id");
				traceVal.append(" POrderId = "+parent_order_id);

				if(parent_order_id != null && !parent_order_id.trim().equals(""))
				{
					traceVal.append(" Parent Found ");
					String p_result_status = "P";
					if(child_order_index.trim().equals("L"))
					{
						p_result_status = (String)resultRecord.get("result_status");
						pstmt_abn_child_chk.setString(1, parent_order_id);
						rs5 = pstmt_abn_child_chk.executeQuery();
						if(rs5!=null && rs5.next())
						{
							traceVal.append("checking abn child");
							String abnormal_child = (String)rs5.getString("abnormal_child");
							if(abnormal_child != null && abnormal_child.trim().equalsIgnoreCase("X"))
								any_abnormal_child = true;
						}
					}
					pstmt_status.clearParameters();
					pstmt_status.setString(1,p_result_status);
					pstmt_status.setString(2,"C");
					if(any_abnormal_child)
						pstmt_status.setString(3,"A");
					else
						pstmt_status.setString(3,rec_result_type);
					pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
					pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
					rs = pstmt_status.executeQuery();
					status = "";
					if(rs!=null && rs.next())
						status = (String)rs.getString("or_status");

					traceVal.append(p_result_status+"C"+rec_result_type);
					traceVal.append((String)resultRecord.get("auth_reqd_yn_db"));
					traceVal.append((String)resultRecord.get("auth_reqd_yn"));

					 pstmt_order.setString(1, status);
					 pstmt_order.setString(2, status);
					 pstmt_order.setString(3, parent_order_id);
					 update_p_order = pstmt_order.executeUpdate();

					 // Exploding frequency immediately after the last child.
					String temp_result_status = (String)resultRecord.get("result_status");
					traceVal.append("#"+temp_result_status+"#");
					if(child_order_index.trim().equals("F") && temp_result_status.trim().equals("3"))
					{
						traceVal.append("Exploding Frequency");

						String p_freq_code = "";
						String p_start_date_time = "";
						String order_category = "";
						//String patient_class = "";
						String v_discrete_cont_order_yn = "";

						pstmt_parent1.setString(1,parent_order_id);
						rs2 = pstmt_parent1.executeQuery();
						if(rs2!=null && rs2.next())
						{
							p_freq_code = (String)rs2.getString("p_freq_code");
							p_start_date_time = (String)rs2.getString("p_start_date_time");
							order_category = (String)rs2.getString("order_category");
							patient_class = (String)rs2.getString("patient_class");
							v_discrete_cont_order_yn = (String)rs2.getString("v_discrete_cont_order_yn");
						}
						traceVal.append("-"+p_freq_code+"-"+p_start_date_time+"-"+order_category+"-"+patient_class+"-"+v_discrete_cont_order_yn+"-");

						pstmt_freq_expl.setString(1,parent_order_id);
						pstmt_freq_expl.setString(2,p_freq_code);
						pstmt_freq_expl.setString(3,p_start_date_time);
						pstmt_freq_expl.setString(4,order_category);
						pstmt_freq_expl.setString(5,patient_class);
						pstmt_freq_expl.setString(6,v_discrete_cont_order_yn);

						boolean explosion = pstmt_freq_expl.execute();
						traceVal.append("Frequency Explosion="+explosion);
					}
					 // Exploding frequency immediately after the last child.
				}
				traceVal.append("--FE** ");
			}
			// Handling the frequency explosion concept, for or_order. -- End.

			String msr_panel_id = "";
			String common_result_type = "";
			String first_result_type = "";

			int rti = 0;
			for (int i=0;i<sizeDetail;i++)
			{
				traceVal.append("12a");
				HashMap lineRecord = (HashMap)lineRecords.get(i);

				String line_result_type = (String)lineRecord.get("result_type");
				traceVal.append("^"+line_result_type+"^");
				if(line_result_type==null) line_result_type="";
				if(!line_result_type.trim().equals(""))
					if (!line_result_type.trim().equals("N"))
					{
						line_result_type = "A";
						common_result_type = "A";
						//traceVal.append("$");
					}
				//traceVal.append("!^"+line_result_type+"^"+common_result_type+"!");

				if(!msr_panel_id.equalsIgnoreCase((String)lineRecord.get("msr_panel_id")))
				{
					msr_panel_id = (String)lineRecord.get("msr_panel_id");
					first_result_type = line_result_type;
					rti = 1;
				}
				else
				{
					if(rti==1)	common_result_type = first_result_type;
					rti++;
					if(common_result_type.equals("A"))	line_result_type = "A";
					else if(common_result_type.equals("N"))	line_result_type = "N";
					common_result_type = line_result_type;
					//traceVal.append("~"+common_result_type+"~"+msr_panel_id+"~");
				}
				//traceVal.append("!!^"+line_result_type+"^"+common_result_type+"!!");

				traceVal.append((String)lineRecord.get("result_status"));
				traceVal.append((String)resultRecord.get("order_status"));
				traceVal.append("'"+line_result_type+"'");
				traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
				traceVal.append((String)lineRecord.get("auth_reqd_yn"));

				status = "";
				orderStatus = (String)resultRecord.get("order_status");
				pstmt_status.clearParameters();
				pstmt_status.setString(1,(String)lineRecord.get("result_status"));
				pstmt_status.setString(2,(String)resultRecord.get("order_status"));
				pstmt_status.setString(3,line_result_type);
				pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
				pstmt_status.setString(5,(String)lineRecord.get("auth_reqd_yn"));
				rs = pstmt_status.executeQuery();
				if(rs!=null && rs.next())
					status = (String)rs.getString("or_status");

				 pstmt_line.setString(1, status);
				if(orderStatus.equalsIgnoreCase("C"))
					pstmt_line.setString(2, status);
				else	pstmt_line.setString(2, "");
				 pstmt_line.setString(3, order_id);
				 pstmt_line.setString(4, (String)lineRecord.get("line_srl_num"));
				 pstmt_line.addBatch();
			traceVal.append("'"+status+"'-12b");

			// For Billing Related
			try{
			traceVal.append("Order Status Result"+orderStatus);

traceVal.append("Order Status Result _ type"+(String)lineRecord.get("result_type"));
traceVal.append("Order Status result_status"+(String)lineRecord.get("result_status"));
traceVal.append("patient_id Ins"+patient_id);

				if(((String)lineRecord.get("result_status")).equalsIgnoreCase("3"))
				{
					if(!old_srl_no.equals((String)lineRecord.get("line_srl_num")))
					{
						cstmt = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG+" }");
						cstmt.setString(1,  patient_id);
						cstmt.setString(2,  encounter_id);
						cstmt.setString(3,  patient_class);
						cstmt.setString(4,  order_id);
						cstmt.setString(5,  (String)lineRecord.get("line_srl_num"));
						cstmt.setString(6, login_by_id);
						cstmt.setString(7, login_at_ws_no);
						cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;
						cstmt.execute();
						bill_yn	 		= cstmt.getString(8);
						if(bill_yn!=null && bill_yn.equals("Y"))
						err_bill_yn			= "Y";
						err_message 	= cstmt.getString(9);
						if(err_message!=null && ! err_message.equals(""))
						{
							update_line		= 0;
							messages		= new StringBuffer();
							messages.append(err_message);
						}
						old_srl_no = (String)lineRecord.get("line_srl_num");
					}
				}
			}catch(Exception ex)
			{
				update_line		= 0;
				traceVal.append("Exception Billing");
			}



				// Handling the frequency explosion concept, for or_order. -- Start.
				if(!child_order_index.trim().equals(""))
				{
					traceVal.append(" **FE--");
//					traceVal.append(" childIndex = "+child_order_index);
//					ResultSet rs1 ;
//					pstmt_parent.clearParameters();
//					pstmt_parent.setString(1,order_id);
//					rs1 = pstmt_parent.executeQuery();
//					if(rs1!=null && rs1.next())
//						parent_order_id = (String)rs1.getString("parent_order_id");
//					traceVal.append(" POrderId = "+parent_order_id);
//
					if(parent_order_id != null && !parent_order_id.trim().equals(""))
					{
						traceVal.append(" Parent Found ");
						String p_result_status = "P";
						if(child_order_index.trim().equals("L"))
							p_result_status = (String)resultRecord.get("result_status");
						pstmt_status.clearParameters();
						pstmt_status.setString(1,p_result_status);
						pstmt_status.setString(2,"C");
						if(any_abnormal_child)
							pstmt_status.setString(3,"A");
						else
							pstmt_status.setString(3,line_result_type);
						pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
						pstmt_status.setString(5,(String)lineRecord.get("auth_reqd_yn"));
						rs = pstmt_status.executeQuery();
						status = "";
						if(rs!=null && rs.next())
							status = (String)rs.getString("or_status");

						traceVal.append(p_result_status+"C"+line_result_type);
						traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
						traceVal.append((String)lineRecord.get("auth_reqd_yn"));

						pstmt_line.setString(1, status);
						pstmt_line.setString(2, status);
						pstmt_line.setString(3, parent_order_id);
						pstmt_line.setString(4, (String)lineRecord.get("line_srl_num"));
						pstmt_line.addBatch();
					}
					traceVal.append("--FE** ");
				}
				// Handling the frequency explosion concept, for or_order. -- End.
			}
				update_l_status = pstmt_line.executeBatch();
			 traceVal.append("13");

			 if((update_l_status.length > 0)){ //check updation in SYN
				 update_l_st = true;
			 }else if((update_l_status.length == (-3))){
				 update_l_st = false;
			 }

		// Billing Consolidated Procedure
			if (update_header > 0 && update_dl && update_order > 0 && update_l_st && update_line > 0 ){
				if(err_bill_yn.equals("Y"))
				{

					cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");
					cstmt.setString(1,  login_facility_id);
					cstmt.setString(2,  patient_id);
					if( patient_class!=null && (patient_class.equals("IP") || patient_class.equals("EA")) )
						cstmt.setString(3, "I");
					else
						cstmt.setString(3, "O");			// EPISODE_TYPE
					cstmt.setString(4,  episode_id);		// EPISODE_ID
					cstmt.setString(5,  episode_visit_num); // VISIT_NUM
					cstmt.setString(6,  order_id); 			// ORDER_ID
					cstmt.setString(7,  "OR");
					cstmt.setString(8,  null);
					cstmt.setString(9,  login_by_id);
					cstmt.setString(10, login_at_ws_no);
					cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
					cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
					cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
					cstmt.execute();
					String err_code 	= cstmt.getString(11);  // ERR_CODE
					String message_id 	= cstmt.getString(12);  // SYS_MESSAGE_ID
					err_message			= cstmt.getString(13);  // ERROR_TEXT
					if(err_code!=null && !err_code.equals("") && !err_code.equals("10") && err_message!=null && !err_message.equals(""))
					{
						update_line		= 0;			// Come out
						messages		= new StringBuffer();
						messages.append( err_message ) ;
					} else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
					{
						update_line		= 0;				// Come out
						messages		= new StringBuffer();

						// Query from the database for the message id and display the Message
						pstmt_header		= connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
						pstmt_header.clearParameters();
						pstmt_header.setString(1, message_id);
						rs=pstmt_header.executeQuery();
						if(rs!=null)
						{
							while(rs.next())
							{
								messages.append(rs.getString(1));
							}
						}
					}
				} //err
	  		}

			traceVal.append("#"+update_header+","+update_dl+","+update_order+","+update_l_st+",");
			if (update_header > 0 && update_dl && update_order > 0 && update_l_st && update_line > 0 ){
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append("RECORD_MODIFIED") ;
			}else{
					connection.rollback();
					if(update_line!=0)
						messages.append( "Insert Failed" ) ;
					messages.append( "Update Failed" ) ;
			}

	 }catch( Exception e ){
						traceVal.append("In Exception==");
						e.printStackTrace();
						traceVal.append(e);
						traceVal.append("#"+e.getMessage());
						map.put( "traceVal", traceVal.toString() ) ;

				try {
							connection.rollback();
							//closeConnection( connection,pt );
							closeConnection(connection);
					} catch ( Exception ee ) {
							messages.append(ee.getMessage() ) ;
					}
					messages.append( e.getMessage() ) ;
					System.err.println(e.getMessage());
					e.printStackTrace() ;
				  } finally{
						try {
							//closeConnection( connection,pt);

							    closeResultSet( rs ) ;
	 	 						closeStatement( pstmt_detail ) ;
	 	 						closeStatement( pstmt_status ) ;
	 	 						closeResultSet( rs1 ) ;
	 	 						closeStatement( pstmt_order ) ;
	 	 						closeStatement( pstmt_line ) ;
	 	 						closeStatement( pstmt_clob ) ;
	 	 						closeResultSet( rs5 ) ;
	 	 						closeResultSet( rs2 ) ;
	 	 						closeStatement( pstmt_parent ) ;
	 	 						closeStatement( pstmt_parent1 ) ;
	 	 						closeStatement( pstmt_freq_expl ) ;
	 	 						closeStatement( pstmt_abn_child_chk ) ;

	 							closeStatement( cstmt);
							closeStatement( pstmt_header);



							closeConnection(connection);
						} catch ( Exception fe ) {
							System.err.println( fe.getMessage() ) ;
							fe.printStackTrace() ;
						}
					}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
				return map ;


	}//End of modify Method


	public String insertResultDataClob(PreparedStatement pstmt_clob, String result_data,
										String order_type_code, String order_id,
										String report_srl_no, String line_srl_no, String srl_no)
	{
		StringBuffer messages = new StringBuffer("");
		ResultSet rset_clob = null;
		try
		{

			messages.append("*insertClob called*");
			pstmt_clob.setString(1,order_type_code);
			pstmt_clob.setString(2,order_id);
			pstmt_clob.setString(3,report_srl_no);
			pstmt_clob.setString(4,line_srl_no);
			pstmt_clob.setString(5,srl_no);
			rset_clob=pstmt_clob.executeQuery();
			if(rset_clob!=null)
			{
				while(rset_clob.next())
				{
					messages.append("z");
					CLOB clb = (CLOB) rset_clob.getClob("result_data");
					messages.append("a");
					BufferedWriter bw   = new BufferedWriter(clb.getCharacterOutputStream());
					messages.append("b");
					bw.write(result_data,0,result_data.length());
					messages.append("c");
					bw.flush();
					messages.append("d");
					bw.close();
					messages.append("**clob**");
				}
			}
			rset_clob.close();
		} catch ( Exception ee ) {
			messages.append("Error "+ee.getMessage() ) ;
			System.err.println(ee.getMessage());
			ee.printStackTrace() ;
		}
		return messages.toString();
	}
*/
/*	public HashMap delete( HashMap tabData, HashMap sqlMap ) {

	 	StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;

		return map ;
		 
		return null;
	} 
*/
/*****************************************************************************/
	public String[] getProcedureCode(String order_id,String order_line_num) {

		String record[] = new String[3];

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHART_DESC_SELECT") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, order_id.trim());
			pstmt.setString(3, order_line_num.trim());
			try{
			resultSet = pstmt.executeQuery() ;
			}
			catch(Exception ex)
			{
					ex.printStackTrace();
					connection.rollback();
					System.err.println("SQL_OR_RESULT_ENTRY_CHART_DESC_SELECT Failed" +ex) ;
					
			}

			if ( resultSet != null && resultSet.next() ) {
				record[0] = resultSet.getString(1)  ;
				record[0] = (record[0] == null) ? "" : record[0].trim().toUpperCase();
				record[1] = resultSet.getString(2)  ;
				record[1] = (record[1] == null) ? "" : record[1].trim();
				record[2] = resultSet.getString(3)  ;
				record[2] = (record[2] == null) ? "" : record[2].trim().toUpperCase();
				}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database"+e ) ;
			e.printStackTrace() ;
		} finally {
			try{
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return record;
	}

	public ArrayList getOrganismDetails(String chart_result_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList organismValues = new ArrayList();
		try {
			connection = getConnection() ;
			//if (organism_string.equals(""))
			{
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_ALL_SELECT") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString(2,chart_result_type);
			} /*else {
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_SELECT") ) ;
				pstmt.setString(1,organism_string);
			}*/
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[3] ;
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "chart_horiz_code" )  ;
				record[2] = resultSet.getString( "seq_no" )  ;
				
				organismValues.add(record);
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

		return organismValues;
	}

	public ArrayList getAntibioticDetails(String chart_result_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList antibioticValues = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ANTIBIOTIC_SELECT") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString(2, chart_result_type);
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[9] ;
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "chart_verti_code" )  ;
				record[2] = resultSet.getString( "seq_no" )  ;
				record[3] = resultSet.getString( "discr_msr_id" )  ;
				record[4] = resultSet.getString( "result_type" )  ;
				record[5] = resultSet.getString( "copy_prev_vert_yn" )  ;
				record[6] = resultSet.getString( "num_digits_max" )  ;
				record[7] = resultSet.getString( "num_digits_min" )  ;
				record[8] = resultSet.getString( "num_digits_dec" )  ;
				antibioticValues.add(record);
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

		return antibioticValues;
	}

	public ArrayList getChartHeadingDetails(String chart_result_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList headingDetails = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHART_HDG_SELECT") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, chart_result_type);

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[3] ;
				record[0] = resultSet.getString( "chart_vert_desc" )  ;
				record[1] = resultSet.getString( "chart_horzi_desc" )  ;
				record[2] = resultSet.getString( "chart_no_columns" )  ;
				
				headingDetails.add(record);
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

		return headingDetails;
	}

	public ArrayList getOrganismDiscreteDetails(String organism_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList organismDiscreteDetails = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_DISCR_SELECT") ) ;
				pstmt.setString(1, organism_id);
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[3] ;
				record[0] = resultSet.getString( "chart_result_type" )  ;
				record[1] = resultSet.getString( "discr_msr_id" )  ;
				record[2] = resultSet.getString( "result_type" )  ;
				organismDiscreteDetails.add(record);
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

		return organismDiscreteDetails;
	}

	public String getOrganismDesc(String organism_id,String chart_result_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String organismDesc = "";
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_DESC") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString(2,organism_id);
				pstmt.setString(3,chart_result_type);
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				organismDesc = resultSet.getString( "short_desc" )  ;
				if (organismDesc == null) organismDesc = "";
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

		return organismDesc;
	}

	public ArrayList getPreviewListResultTypeDetails(String discr_msr_id,String result_value) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList listValues = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_PREVIEW_LIST_VALUES") ) ;
				pstmt.setString( 1, discr_msr_id.trim() ) ;
				pstmt.setString( 2, result_value.trim() ) ;
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				String[] record = new String[4] ;
				record[0] = resultSet.getString( "ref_rng_desc" )  ;
				record[1] = resultSet.getString( "dflt_yn" )  ;
				record[2] = resultSet.getString( "result_value" )  ;
				record[3] = resultSet.getString( "norm_abnorm_ind" )  ;
				listValues.add(record);
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

		return listValues;
	}

	public String getFunc_type() {		return func_type;	}

	public void setFunc_type(String value) {		func_type = value;	}

	public java.util.HashMap getCultureTestRecord() {
		return this.cultureTestRecord;
	}

	public void setCultureTestRecord(java.util.HashMap value) {
		this.cultureTestRecord = value;
	}

	public void clearForRecord(){
		cultureTestRecord		= new HashMap();
	}
	public void clear() {
	   super.clear() ;
		//result_data = new HashMap();
		//allValues = new Hashtable();
//		result_html_data		= new HashMap();
	   //cultureTestRecord		= new HashMap();
		//cultureTestRecord.clear();
	    previewCultureTestRecord	= new HashMap();
	    reportParameters			= new Hashtable();
	}

	public java.util.HashMap getPreviewCultureTestRecord() {
		return previewCultureTestRecord;
	}

	public void setPreviewCultureTestRecord(java.util.HashMap value) {
		previewCultureTestRecord = value;
	}

	public void CultureTestRecordSync(String order_id,String report_srl_no) {		
		StringBuffer traceVal		= new StringBuffer();
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String srl_num 				= "";
		String seq_num				= "";
		String antibiotic_code		= "",	discr_msr_id	= "";
		String copy_prev_vert_yn	= "",	chart_result_type="";
		String copyAntibiotic_code	= "",	copyDiscr_msr_id = "";
		//String copyCopy_prev_vert_yn="";


		HashMap	map					= new HashMap();
		//Common-ICN-0044
		ArrayList tempAntibioticValues	= new ArrayList();
		HashMap	tempHashMap				= new HashMap();
		ArrayList headingDetails = null;
		ArrayList antibioticValues = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ORGANISM_MODIFY_SELECT") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,report_srl_no);
			traceVal.append("order_id="+order_id+",report_srl_no="+report_srl_no);
			resultSet = pstmt.executeQuery() ;

			//int columnCount	= 0;
			int prevIndx	= 0;
			int currIndx	= 0;
			int resultCounter	= 0;
			String tempSeq_num	= "0";

			while ( resultSet != null && resultSet.next() )	{
				if (!srl_num.equals(resultSet.getString( "srl_num" ))) {
					map	= new HashMap();
				}

				srl_num = resultSet.getString( "srl_num" )  ;
				if (srl_num == null) srl_num = "";

				seq_num	= resultSet.getString( "seq_num" );
				if (seq_num == null) seq_num = "";
				if (!tempSeq_num.equals(seq_num)) {
					//columnCount = 0;
					tempSeq_num = seq_num;
				}
				map.put("antibiotic_organism_reqd_yn","Y");
				map.put("remarks","");

                String [] chartRecord		= getProcedureCode(order_id,srl_num);
				//chart_result_type	= checkForNull(chartRecord[0],"");
				chart_result_type	= checkForNull(chartRecord[2],"");

                 headingDetails	= getChartHeadingDetails(chart_result_type);
                int chart_no_columns		= 0;

                if (headingDetails != null &&headingDetails.size() > 0) {
					String [] headingRecord = (String[])headingDetails.get(0);
					chart_no_columns		= Integer.parseInt(checkForNull(headingRecord[2],"0"));
				}
                if (resultCounter == 0) {
					 antibioticValues	= getAntibioticDetails(chart_result_type);
					if (antibioticValues == null) antibioticValues = new ArrayList();

					for(int i = 0; i < antibioticValues.size(); i++) {

						String record [] 			= (String[])antibioticValues.get(i);
						antibiotic_code 		= checkForNull(record[1]);
						discr_msr_id			= checkForNull(record[3]);
						copy_prev_vert_yn	= checkForNull(record[5]);
						if (discr_msr_id.equals("")) {
							prevIndx	= currIndx;
							currIndx	= i;
							tempAntibioticValues.add(antibiotic_code);
							if (copy_prev_vert_yn.equals("Y")) {
								for (int j = prevIndx; j < currIndx; j++) {
									String copyRecord [] = (String[])antibioticValues.get(j);
									copyAntibiotic_code		= checkForNull(copyRecord[1]);
									copyDiscr_msr_id			= checkForNull(copyRecord[3]);
									//copyCopy_prev_vert_yn	= checkForNull(copyRecord[5]);
									if (copyDiscr_msr_id.equals("")) {
										System.err.println("copyDiscr_msr_id is null");
									} else {
										tempAntibioticValues.add(copyAntibiotic_code);
									}
								}
							}
						} else {
							tempAntibioticValues.add(antibiotic_code);
						}
					}
					for (int i = 0; i < tempAntibioticValues.size(); i++) {
						for (int j = 0; j < chart_no_columns; j++) {
							tempHashMap.put(Integer.toString(i) + Integer.toString(j),"");
						}
					}
				}

                for(int i = 0; i < tempAntibioticValues.size(); i++) {
					antibiotic_code 		= resultSet.getString("chart_vert_code");
					String record  				= (String)tempAntibioticValues.get(i);
					if (antibiotic_code.equals(record) && ((String)tempHashMap.get(Integer.toString(i)+Integer.toString(Integer.parseInt(seq_num) -1))).equals("")) {
						map.put("antibiotic"+i,resultSet.getString("chart_vert_code"));

						for (int j = 0; j < chart_no_columns; j++) {
							if ((Integer.parseInt(seq_num) -1) == j) {
								map.put(i+""+(Integer.parseInt(seq_num) - 1),resultSet.getString("sensitivity_ind"));
							}
						}
						tempHashMap.put(Integer.toString(i)+Integer.toString(Integer.parseInt(seq_num) -1),"Y");
						break;
					}
				}


				for(int i = 0; i < chart_no_columns; i++) {
					if ((Integer.parseInt(seq_num) - 1) == i)
						map.put("organism"+(Integer.parseInt(seq_num) - 1),resultSet.getString("chart_horz_code"));
				}

				resultCounter++;

				traceVal.append(",map="+map);
				//cultureTestRecord		= new HashMap();
				cultureTestRecord.put("" + (Integer.parseInt(srl_num) -1) , map);
				traceVal.append(",cultureTestRecord="+cultureTestRecord);

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		} finally {
			try {
				//Common-ICN-0044
				map.clear();	
				tempAntibioticValues.clear();	
				tempHashMap.clear();	
				headingDetails.clear();	
				antibioticValues.clear();	
				//Common-ICN-0044
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				System.err.println("Error"+e.toString());
			}
		}
		
		//return organismDesc;
	}
	public String getParentOrderId(String parent_order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String order_id = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_PARENT_ORDER_ID") ) ;
			pstmt.setString( 1, parent_order_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				order_id = resultSet.getString("order_id")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database Parentorderid" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return order_id;
	}
	public String getCatalogDesc(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String catalog_synonym_dc = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_PH_CATALOG_DESC") ) ;
			pstmt.setString( 1, order_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) { // one row
				catalog_synonym_dc = resultSet.getString("catalog_synonym_dc")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database getcatalogdesc" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return catalog_synonym_dc;
	}
	public ArrayList getProcedureDetails(String order_id,int count) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList procDetails = new ArrayList();
//		int index = 0;
		try {
			connection = getConnection() ;
			if(count==0)
			{
				pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_CATALOG"));
			}
			else
			{
				pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURES_LINK"));
			}
			//pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK"));
			pstmt.setString( 1, order_id.trim() ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, order_id.trim() ) ;
			pstmt.setString( 4, order_id.trim() ) ;
			//pstmt.setString( 5, order_id.trim() ) ;
			//pstmt.setString( 6, order_id.trim() ) ;
			//pstmt.setString( 7, order_id.trim() ) ;
			//pstmt.setString( 8, order_id.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;
			String[] record = null;
				
			while ( resultSet != null && resultSet.next() ) {
				record = new String[15] ;

				record[0] = resultSet.getString( "discr_msr_id" )  ;
				record[1] = resultSet.getString( "line_srl_num" )  ;
				record[2] = resultSet.getString( "parent_srl_no" )  ;
				record[3] = resultSet.getString( "event_group_desc" )  ;
				record[4] = resultSet.getString( "event_desc" )  ;
				record[5] = resultSet.getString( "order_catalog_code" )  ;
				record[6] = resultSet.getString( "proc_link_applicable" )  ;
				record[7] = resultSet.getString( "proc_link_resulting_option" )  ;
				record[8] = resultSet.getString( "Procedure_Desc" )  ;
				record[9] = resultSet.getString( "default_yn");
				record[10] = resultSet.getString( "proc_code");
				record[11] = resultSet.getString( "long_desc");
				record[12] = resultSet.getString( "proc_coding_scheme");
				record[13] = resultSet.getString( "term_set_desc");
				record[14] = resultSet.getString( "enable_yn");

								
 				procDetails.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" +e.toString()) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return procDetails;
	}
	public String[] getProcScheme() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] procScheme = new String[3];
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_SCHEME_SELECT") ) ;

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				procScheme[0] = resultSet.getString("scheme");
				procScheme[1] = resultSet.getString("scheme_code");
				procScheme[2] = resultSet.getString("scheme_desc");
				if(procScheme[0]==null || procScheme[0].trim().equals(""))	procScheme[0]="1";
				
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
		return procScheme;
	}
	public String getTDMReason(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String TDMReason = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_TDMREASON") ) ;
			pstmt.setString(1,order_id);
			
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				TDMReason = resultSet.getString("TDMREASON");
				if(TDMReason ==null) TDMReason="";
				
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading TDMReason values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return TDMReason;
	}
	public String getNoteStatus(String facility_id,String accession_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String event_status = "";
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_TDMREASON") ) ;
			pstmt = connection.prepareStatement( "select event_Status from ca_encntr_note where facility_id = ? and accession_num = ?" ) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,accession_num);
			
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				event_status = resultSet.getString("event_Status")==null?"":resultSet.getString("event_Status");
						
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading TDMReason values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return event_status;
	}

	public String getValueForImg(String login_facility_id,String order_id,String order_line_num) throws Exception{
			String value	= null;
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_VALUE_FOR_IMG") ) ;
			pstmt.setString(1, login_facility_id); 					
			pstmt.setString(2, order_id);			
			pstmt.setString(3, order_line_num);			

			resultSet = pstmt.executeQuery() ;
			
			while ( resultSet != null && resultSet.next() ) {				
				value = resultSet.getString( "Value" )  ;			
			}
			if (value==null)
				value="null";
			
		}catch(Exception e){
			System.err.println( "Error in getValueForImg() of Result Entry Bean" ) ;
			e.printStackTrace() ;
			throw e ;
		}finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return value;	
	}
	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		
		String order_id				 = "";
		String parent_order_id		 = "";
		String order_type_code		 = "";
		String valid_operational_yn  = "";
		
		order_id				= (String)commonRecord.get("order_id");
		order_type_code 		= (String)commonRecord.get("order_type_code");
		parent_order_id 		= (String)commonRecord.get("parent_order_id");
		
		if(parent_order_id.equals(""))
			parent_order_id= order_id;
		//valid_operational_yn	= getStatus(order_id ,order_type_code ,"RESULT_ENTRY");
		//valid_operational_yn	= getOperationalStatus("RESULT_ENTRY", parent_order_id , "");
		valid_operational_yn	= getOperationalStatus("RESULT_ENTRY",order_id , "");
		if(valid_operational_yn.equals("N")){
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", getMessage(language_id, "OR_STATUS_CHANGED","OR") ) ;
		}
				
        return map ;
    }
/*
	public String getStatus(String order_id,String order_type_code,String perfm_func) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		String perform_yn			= "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_STATUS_CHK")) ;
			pstmt.setString(1, perfm_func);
			pstmt.setString(2, order_id);
			pstmt.setString(3, order_type_code);
			
			resultSet	= pstmt.executeQuery() ;
			
			while(resultSet != null && resultSet.next()) {
				perform_yn = checkForNull(resultSet.getString( "perform_yn" ),"N") ;  
			}
				
		}catch ( Exception e )	{
			System.err.println( "Error in getStatus "+e.getMessage()) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}System.out.println("====perform_yn="+perform_yn+"=======");	
			return perform_yn;
	}
	*/
	public String getChartStatus(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String chart_status			= "N";
		try {
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHART_STATUS") ) ;
			
			pstmt.setString(1, "OR" );							//CONTR_MODULE_ID
			pstmt.setString(2, order_id+"!"+order_line_num );  //CONTR_MOD_ACCESSION_NUM
			
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				//chart_status = resultSet.getString(1)==null?"":resultSet.getString(1);
				chart_status = "Y";		
			}
			

		} catch ( Exception e )	{
			System.err.println( "Error in getting the Chart Status"+e.toString() ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
	
		return chart_status;
	}

public int getRecordedProcedureCount(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int recorded_count			= 0;
		try {
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_COUNT_RESULT_DETAIL_PROC") ) ;
			
			pstmt.setString(1, order_id);	
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				 recorded_count = resultSet.getInt("total");		
			}
			

		} catch ( Exception e )	{
			System.err.println( "Error in getting the Chart Status"+e.toString() ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
	
		return recorded_count;
	}

	public String getOrderSetId(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "";
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_ID") ) ;
				pstmt.setString(1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString("order_set_id" )  ;
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
		return record;
	}

	public String getOrderSetDetails(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					record = resultSet.getString("bill_yn")  ;
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

		return record;
	}
}

