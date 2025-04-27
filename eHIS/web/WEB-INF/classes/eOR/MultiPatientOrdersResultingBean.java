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
Date       Edit History     Name       	Description
--------------------------------------------------------------------------------------------------------
?             100           ?           created
04/05/2012	  IN032603		Menaka V	Multipatient result reporting filter is not working.
--------------------------------------------------------------------------------------------------------
*/
package eOR ;

import java.io.* ;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORMultiPatientOrdersResulting.*;

public class MultiPatientOrdersResultingBean extends eOR.Common.OrAdapter implements Serializable 
{
	StringBuffer traceVal = new StringBuffer();
	protected Hashtable hashMultiple;
	
	protected ArrayList front_page_records;
	public void  setFront_page_records(ArrayList front_page_records) 
	{
		this.front_page_records = front_page_records; 
	}
	public ArrayList getFront_page_records() 
	{ 
		return this.front_page_records ; 
	}

	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	/**
	To Retrive the Location Desc
	*/
	public ArrayList getLocations(String locn_type, String  practitioner_id, String facility_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList allLocations		= new ArrayList() ;
		String[] record				= null;
	
		try 
		{
			connection = getConnection();
			if(locn_type.equals("P"))
			{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_PROCEDURE") ) ;
				pstmt.setString( 1,language_id);
			}
			else
			{
				//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT") ) ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_RESULT") ) ;
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5, practitioner_id.trim());
				pstmt.setString( 6,locn_type.trim());
				pstmt.setString( 7,locn_type.trim());
				pstmt.setString( 8,facility_id.trim());
	     	}
		
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[2];
				record[0] = resultSet.getString( "code");
				record[1] = resultSet.getString( "short_desc");
				allLocations.add(record) ;
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return allLocations;
	}
//----------------------------------------------------------

	/**
		This will populate all the order categories
		@return		:	ArrayList
	*/
	public ArrayList getAllOrderCategory() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCategories	= new ArrayList() ;

		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_ORDER_CATEGORY_MULTI_RESULT")) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				String[] categoryRecords = new String[2];
				categoryRecords[0] = resultSet.getString("ORDER_CATEGORY");
				categoryRecords[1] = resultSet.getString("SHORT_DESC");

				OrderCategories.add(categoryRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderCategories;
	}

	/**
		This will populate all the order Types with respect to the order category selected
		@return		:	ArrayList
	*/

	public ArrayList getOrderTypes(String orderCategory) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderTypes		= new ArrayList();
		String[] orderTypeRecords	= null;
		String code					= null;
		String desc					= null;
		try
		{
			connection = getConnection();

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ORDER_TYPE")) ;
			pstmt.setString(1,orderCategory);
			resultSet = pstmt.executeQuery();
			
			while(resultSet !=null && resultSet.next())
			{
				orderTypeRecords = new String[2];
				code = resultSet.getString("ORDER_TYPE_CODE");
				desc = resultSet.getString("SHORT_DESC");
				orderTypeRecords[0] = code.trim();
				orderTypeRecords[1] = desc.trim();
				OrderTypes.add(orderTypeRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderTypes;
	}
	
	/**
		This method returns the Current date, last week date and the system date & time
		@return		:	ArrayList
	*/
	public ArrayList getSysDateTime() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();
		int start_date				= 1;
		int end_date				= 0;
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_GET_DATE_RANGE") ) ;
			pstmt.setInt(1,start_date);
			pstmt.setInt(2,end_date);
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) 
			{
				currentDate.add(resultSet.getString("start_date"))  ;
				currentDate.add(resultSet.getString("end_date"))  ;
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return currentDate;
	}

	/**
		This will populate all the result formatting values 
		@return		:	ArrayList
	*/	
	public ArrayList getResultFormatting(String period_from,String period_to,String order_category, String order_type,String order_catalog, String facility_id, String location_type, String locn) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList resultFormats		= new ArrayList() ;

		/* Thai date validations start*/
			if (!language_id.equals("en")){
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMYHM",language_id,"en");			
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMYHM",language_id,"en");
			}
		/* Thai date validations end*/
		try
		{
			if(order_type!=null)
				order_type=order_type.trim();
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_FORMAT_ITEM_VALUES"));
			pstmt.setString(1,period_from.trim());
			pstmt.setString(2,period_to.trim());
			pstmt.setString(3,order_category.trim());
			pstmt.setString(4,order_type);
			pstmt.setString(5,order_catalog);
			pstmt.setString(6,location_type);
			pstmt.setString(7,facility_id);
			//pstmt.setString(8,facility_id);
			//pstmt.setString(9,locn);
			resultSet = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
				String[] resultFormatRecords = new String[3];
				resultFormatRecords[0] = resultSet.getString("CODE");
				resultFormatRecords[1] = resultSet.getString("DESCRIPTION");
				resultFormatRecords[2] = resultSet.getString("RESULT_TYPE");

				resultFormats.add(resultFormatRecords);
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return resultFormats;
	}
	
	/**
		This method returns the result type for the selected result format item
		@return		:	String
	*/
	public String getResultType(String result_format) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String result_type			= "";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_FORMAT_TYPE"));
			pstmt.setString(1,result_format);
			resultSet = pstmt.executeQuery();
			while(resultSet != null && resultSet.next())
			{
				result_type = resultSet.getString("RESULT_TYPE");
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return result_type;
	}
	
	/**
		This will populate all the result values for the selected result format, order category etc
		for the main screen data
		@return		:	ArrayList
	*/
	public int getOrdersResulting(ArrayList allValues) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap	htMapRecord			= null;
		int total_rec				= 0;
		String order_catalog		= "";
		String order_category		= "";
		String order_type			= "";
		String result_format		= "";
		String period_from			= "";
		String period_to			= "";
		String location_type		= "";
		String location				= "";
		String group_by				= "";
		String facility_id			= "";
		String sql					= "";
		try
		{
			//sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_ORDER_VALUES");//IN032603
			sql = "SELECT A.ORDER_ID ORDER_ID,A.ORDER_LINE_NUM ORDER_LINE_NUM, A.ORDER_CATALOG_CODE CATALOG_CODE, or_get_desc.or_order_catalog(a.order_catalog_code,?,2) catalog_desc, TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATETIME,b.ENCOUNTER_ID ENCOUNTER_ID, b.PATIENT_CLASS PATIENT_CLASS,B.PATIENT_ID PATIENT_ID,decode(?,'en',d.patient_name,nvl(d.patient_name_loc_lang,d.patient_name)) patient_name,B.PERFORMING_DEPTLOC_TYPE LOCATION_TYPE,B.PERFORMING_DEPTLOC_CODE LOCATION_CODE,NVL((CASE WHEN b.PATIENT_CLASS IN ('IP','DC') THEN ip_get_desc.ip_nursing_unit(?, b.source_code,?,'2') WHEN b.patient_class IN ('AE', 'OP')                        THEN op_get_desc.op_clinic (?,b.source_code,?,'2') END),'External') LOCATION_NAME, A.ORDER_TYPE_CODE ORDER_TYPE_CODE,d.SEX SEX FROM OR_ORDER_LINE A, OR_ORDER B, OR_ORDER_CATALOG C,mp_patient d,ip_open_encounter e  WHERE a.order_line_status IN ('RG', 'VF', 'RV', 'RC', 'IP') AND  A.ORDER_ID=B.ORDER_ID AND e.facility_id=b.ordering_facility_id and e.encounter_id=b.encounter_id AND A.ORDER_CATALOG_CODE = NVL (?, A.ORDER_CATALOG_CODE) AND A.ORDER_CATEGORY = ? AND A.ORDER_TYPE_CODE = Nvl(?,A.ORDER_TYPE_CODE) AND C.ORDER_CATALOG_CODE = A.ORDER_CATALOG_CODE and b.patient_id=d.patient_id AND C.DISCR_MSR_PANEL_ID = ? AND A.START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI') and A.START_DATE_TIME<=SYSDATE  AND NVL(A.CONT_ORDER_IND,'CO') IN ('CO','DO','DS') AND b.patient_class like decode(?, 'N', 'IP', 'D' ,'DC', '%')  and b.ORDERING_FACILITY_ID=?";//IN032603
			clearDBRec();
			int checkRec = multiRecBean.getSize("DB");
			if(checkRec==0)
			{
				connection = getConnection();

				order_catalog		= (String) allValues.get(0);
				order_category		= (String) allValues.get(1);
				order_type			= (String) allValues.get(2);
				result_format		= (String) allValues.get(3);
				period_from			= (String) allValues.get(4);
				period_to			= (String) allValues.get(5);
				location_type		= (String) allValues.get(6);
				location			= (String) allValues.get(7);
				group_by			= (String) allValues.get(8);
				facility_id			= (String) allValues.get(9);

				/* Thai date validations start*/
				if (!language_id.equals("en")){
					period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMYHM",language_id,"en");			
					period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMYHM",language_id,"en");
				}
				/* Thai date validations end*/
				//IN032603 Starts
				if(location==null || location.equals(""))
				{
					location = null;
				}
				else
				{
					location = location.trim();
				}
				if(location!=null && !location.equals(""))
				{
					sql = sql + " AND B.SOURCE_CODE=?";
				}
				//IN032603 Ends
				if(group_by.equals("P"))
				{
					sql = sql + " ORDER BY PATIENT_ID, START_DATE_TIME";
				}
				else if (group_by.equals("O"))
				{
					sql = sql + " ORDER BY START_DATE_TIME";
				}
				else if (group_by.equals("C"))
				{
					sql = sql + " ORDER BY CATALOG_CODE,START_DATE_TIME";
				}
				else if (group_by.equals("L"))
				{
					sql = sql + " ORDER BY LOCATION_NAME, START_DATE_TIME";
				}
				if(order_catalog==null || order_catalog.equals(""))
				{
					order_catalog = null;
				}
				else
				{
					order_catalog = order_catalog.trim();
				}
				if(location_type==null || location_type.equals(""))
				{
					location_type = null;
				}
				else
				{
					location_type = location_type.trim();
				}
				/*if(location==null || location.equals(""))
				{
					location = null;
				}
				else
				{
					location = location.trim();
				}*/
				if(order_type==null || order_type.equals(""))
				{
					order_type = null;
				}
				else
				{
					order_type = order_type.trim();
				}
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1,language_id);
				pstmt.setString(2,language_id);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,language_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,language_id);
				pstmt.setString(7,order_catalog);
				pstmt.setString(8,order_category.trim());
				pstmt.setString(9,order_type);
				pstmt.setString(10,result_format.trim());
				pstmt.setString(11,period_from.trim());
				pstmt.setString(12,period_to.trim());
				pstmt.setString(13,location_type);
				pstmt.setString(14,facility_id);	
				//IN032603 Starts
				if(location!=null && !location.equals(""))
				{
					pstmt.setString(15,location);
				}
				//IN032603 Ends
				//pstmt.setString(15,facility_id);
				//pstmt.setString(16,location);
				//pstmt.setString(7,location_type);
				//pstmt.setString(8,location);
				resultSet = pstmt.executeQuery();
				while(resultSet != null && resultSet.next())
				{
					htMapRecord				=	new HashMap();
					htMapRecord.put("code"				,	resultSet.getString("ORDER_ID"));
					htMapRecord.put("order_line_num"	,	resultSet.getString("ORDER_LINE_NUM"));
					htMapRecord.put("catalog_code"		,	resultSet.getString("CATALOG_CODE"));
					htMapRecord.put("catalog_desc"		,	resultSet.getString("CATALOG_DESC"));
					htMapRecord.put("start_datetime"	,	resultSet.getString("START_DATETIME"));
					htMapRecord.put("patient_id"		,	resultSet.getString("PATIENT_ID"));
					htMapRecord.put("patient_name"		,	resultSet.getString("PATIENT_NAME"));
					htMapRecord.put("location_type"		,	resultSet.getString("LOCATION_TYPE"));
					htMapRecord.put("location_code"		,	resultSet.getString("LOCATION_CODE"));
					htMapRecord.put("location_name"		,	resultSet.getString("LOCATION_NAME"));
					htMapRecord.put("sex"		,	resultSet.getString("SEX"));
					htMapRecord.put("patient_class"		,	resultSet.getString("PATIENT_CLASS"));
					htMapRecord.put("encounter_id"		,	resultSet.getString("ENCOUNTER_ID"));
					multiRecBean.putObject(htMapRecord);
				}
			}
			total_rec = multiRecBean.getSize("DB");
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return total_rec;
	}
	
	/**
		This will populate all the discrete measures for the selected result_format items
		@return		:	ArrayList
	*/
	public ArrayList getDiscreteMeasures(String disc_measure_id,String result_type) throws Exception
	{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet rs 					= null;
		ArrayList discreteMeasuresList	= new ArrayList();
		String sql						= "";
		String result					= "";
		String records[]				= null;
		String result_num_records[]		= null;
//		String mandatory				= "";
//		String discr_msr_id				= "";
		try
		{
			connection = getConnection();
			if(result_type.equals("V") || result_type.equals("Z") || result_type.equals("P"))
			{
				sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_DISCRETE_PANEL_VALUES");
			}
			else
			{
				sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_DISCRETE_MSR_VALUES");
			}


			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,disc_measure_id);
			rs = pstmt.executeQuery();

			while(rs!=null && rs.next())
			{
				
				result = rs.getString("RESULT_TYPE");
				if(result!=null && (result.equalsIgnoreCase("N") || result.equalsIgnoreCase("I")))
				{
					records = new String[13];
				}
				else
				{
					records = new String[8];
				}
				records[0] = rs.getString("DISCR_MSR_ID");
				records[1] = rs.getString("DESCRIPTION");
				records[2] = rs.getString("RESULT_TYPE");
				records[3] = rs.getString("MAX_DIGITS");
				records[4] = rs.getString("MIN_DIGITS");
				records[5] = rs.getString("DEC_DIGITS");

				// If the result is of Number/Decimal Type
				if(result!=null && (result.equalsIgnoreCase("N") || result.equalsIgnoreCase("I")))
				{
					result_num_records = getNumericResultTypeDetails(records[0],connection);
					records[6] = result_num_records[0];
					records[8] = result_num_records[1];
					records[9] = result_num_records[2];
					records[10] = result_num_records[3];
					records[11] = result_num_records[4];
					records[12] = result_num_records[5];
				}
				else
				{
					records[6] = "";
				}
				if(result_type.equals("V") || result_type.equals("Z") || result_type.equals("P"))
				{
					//records[6] = rs.getString("UOM");
					records[7] = rs.getString("MANDATORY");
				}
				else
				{
					records[7] = "";
				}
				discreteMeasuresList.add(records);
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(rs) ;
			closeConnection(connection) ;
		}
		return discreteMeasuresList;
	}
	
	/**
		This method returns the Numeric Result Type Details for the selected Discrete Measures
		@return		:	String[]
	*/
	private String[] getNumericResultTypeDetails(String msr_id, Connection conn) throws Exception
	{
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		String[] record						= new String[8] ;
		try
		{
			//pstmt = conn.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_NUMERIC_DETAILS") ) ;
			pstmt = conn.prepareStatement("select num_dflt_result,num_uom, num_ref_low,TO_CHAR(num_ref_low,DECODE(b.NUM_DIGITS_DEC,1,'999999999.0',2,'999999999.90',3,'999999999.900',4,'999999999.9000',5,'999999999.90000',6,'999999999.900000',7,'999999999.9000000',8,'999999999.90000000',9,'9',0,'999999999','999999999')) num_ref_low_with_points,TO_CHAR(num_ref_high,DECODE(b.NUM_DIGITS_DEC,1,'999999999.0',2,'999999999.90',3,'999999999.900',4,'999999999.9000',5,'999999999.90000',6,'999999999.900000',7,'999999999.9000000',8,'999999999.90000000',9,'999999999.90000000',0,'999999999','999999999'))  num_ref_highwith_points ,num_crit_low,num_crit_high,ref_range_seq,b.min_value min_value,b.max_value max_value from am_discr_msr_ref_rng_num  a,am_discr_msr b where a.discr_msr_id = ? and a.discr_msr_id = b.discr_msr_id") ;
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
				record[6] = resultSet.getString( "min_value" )  ;
				record[7] = resultSet.getString( "max_value" )  ;
			}
		}
		catch (Exception e )
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		return record;
	}

	/**
		This will populate all the result values for the selected result format, order category etc
		for the Second screen data by passing the selected order ids
		@return		:	ArrayList
	*/
	
	public int getOrdersResultingValues(ArrayList allValues) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap	htMapRecord			= null;
		ArrayList selectedRecords	= null;
		int total_rec				= 0;
		String order_catalog		= (String) allValues.get(0);
		String order_category		= (String) allValues.get(1);
		String order_type			= (String) allValues.get(2);
		String result_format		= (String) allValues.get(3);
		String period_from			= (String) allValues.get(4);
		String period_to			= (String) allValues.get(5);
		String location_type		= (String) allValues.get(6);
		String location				= (String) allValues.get(7);
		String group_by				= (String) allValues.get(8);
		//String order_values			= (String) allValues.get(9);
		String facility_id			= (String) allValues.get(10);
		String	sql					= "";
		String record				= "";
		int len						= 0;
		/* Thai date validations start*/
			if (!language_id.equals("en")){
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMYHM",language_id,"en");	
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMYHM",language_id,"en");
			}
		/* Thai date validations end*/


		try
		{
			clearDBRec();
			connection = getConnection();
			selectedRecords = new ArrayList();
			for(int j=0;j<front_page_records.size();j++)
			{
				record = (String)front_page_records.get(j);
				if(!record.equals("N"))
				{
					selectedRecords.add(record);
				}
			}
			len = selectedRecords.size();
			if(len>0)
			{
				sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_ORDER_VALUES");

			//sql = sql + "AND (A.ORDER_ID,A.ORDER_LINE_NUM ) IN ("+order_values+")";
			
				sql = sql + "AND (A.ORDER_ID,A.ORDER_LINE_NUM ) IN (";
			
				for (int i=0;i<selectedRecords.size() ;i++ )
				{
					record = (String)selectedRecords.get(i);
					if(i!=len-1)
					{
						sql = sql + record + ",";
					}
					else
					{
						sql = sql + record ;
					}
				}
				
				sql = sql + ")" ; 
				if(group_by.equals("P"))
				{
					sql = sql + " ORDER BY PATIENT_ID, START_DATE_TIME";
				}
				else if (group_by.equals("O"))
				{
					sql = sql + " ORDER BY START_DATE_TIME";
				}
				else if (group_by.equals("C"))
				{
					sql = sql + " ORDER BY CATALOG_CODE,START_DATE_TIME";
				}
				else if (group_by.equals("L"))
				{
					sql = sql + " ORDER BY LOCATION_NAME, START_DATE_TIME";
				}
			
				if(order_catalog==null || order_catalog.equals(""))
					order_catalog = null;
				if(result_format==null || result_format.equals(""))
					result_format = null;
				if(location_type==null || location_type.equals(""))
					location_type = null;
				if(location==null || location.equals(""))
					location = null;
				if(order_type==null || order_type.equals(""))
					order_type = null;
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1,language_id);
				pstmt.setString(2,language_id);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,language_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,language_id);
				pstmt.setString(7,order_catalog);
				pstmt.setString(8,order_category.trim());
				pstmt.setString(9,order_type);
				pstmt.setString(10,result_format.trim());
				pstmt.setString(11,period_from.trim());
				pstmt.setString(12,period_to.trim());
				pstmt.setString(13,location_type);
				pstmt.setString(14,facility_id);
				//pstmt.setString(15,facility_id);
				//pstmt.setString(16,location);
				//pstmt.setString(7,location_type);
				//pstmt.setString(8,location);
			
				resultSet = pstmt.executeQuery();
				while(resultSet != null && resultSet.next())
				{
					String[] resultFormatRecords = new String[14];
					htMapRecord				=	new HashMap();
					resultFormatRecords [0] = resultSet.getString("ORDER_ID");
					resultFormatRecords [1] = resultSet.getString("ORDER_LINE_NUM");
					resultFormatRecords [2] = resultSet.getString("CATALOG_CODE");
					resultFormatRecords [3] = resultSet.getString("CATALOG_DESC");
					resultFormatRecords [4] = resultSet.getString("START_DATETIME");
					resultFormatRecords [5] = resultSet.getString("PATIENT_ID");
					resultFormatRecords [6] = resultSet.getString("PATIENT_NAME");
					resultFormatRecords [7] = resultSet.getString("LOCATION_TYPE");
					resultFormatRecords [8] = resultSet.getString("LOCATION_CODE");
					resultFormatRecords [9] = resultSet.getString("LOCATION_NAME");
					resultFormatRecords [10] = resultSet.getString("ORDER_TYPE_CODE");
					resultFormatRecords [11] = resultSet.getString("ENCOUNTER_ID");
					resultFormatRecords [12] = resultSet.getString("PATIENT_CLASS");
					resultFormatRecords [13] = resultSet.getString("SEX");
					htMapRecord.put("result", resultFormatRecords);
					multiRecBean.putObject(htMapRecord);
				}
			}
			total_rec = multiRecBean.getSize("DB");
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return total_rec;
	}

	

	/**
		This will populate all the List Type Values
		@return		:	ArrayList
	*/
	public ArrayList getListTypeValues(String discrete_measure_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList listResults		= new ArrayList();
		String sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_LIST_TYPE_VALUES");
		String[] records = null;
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,discrete_measure_id.trim());
			resultSet = pstmt.executeQuery();
			while(resultSet != null && resultSet.next())
			{
				records = new String[2];
				records[0] = resultSet.getString("DESCRIPTION");
				records[1] = resultSet.getString("SEQ");
				listResults.add(records);
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return listResults;
	}

	public Object getBean(){
	return this.multiRecBean;
 }

public boolean clearDBRec()throws Exception
{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }

public void setAll( Hashtable recordSetMultiple ) 
{
	try
	{
		hashMultiple = recordSetMultiple ;
		setMode((String)recordSetMultiple.get("mode"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public HashMap validate() throws Exception
{
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "" ) ;

	String order_id				= "";
	String order_line_num		= "";
	String valid_operational_yn	= "";

	int totalRecords = Integer.parseInt(((String)hashMultiple.get("total_records_count")).trim());
	for(int i=0;i<totalRecords;i++)
	{
		order_id		= ((String)hashMultiple.get("order_id"+i)).trim();
		order_line_num	= ((String)hashMultiple.get("order_line_num"+i)).trim();
		valid_operational_yn	= getOperationalStatus("MULTI_RESULTING",order_id , order_line_num);
		if(valid_operational_yn.equals("N"))
		{
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "OR_STATUS_CHANGED" ) ;
		}
	}
	return map ;
}

/**
	This method is to update the records in the DB for the selected orders
	@return		:	HashMap
*/
public HashMap modify()
{
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean(false));
	map.put( "flag", "true");
	ArrayList recordStore = new ArrayList() ;
	HashMap sqlMap = new HashMap();
	

	String order_id				= "";
	String order_line_num		= "";
	String order_type_code		= "";
	String catalog_code			= "";
	String srl_num				= "";
	String discrete_msr_id		= "";
	String result_num			= "";
	String result_num_uom		= "";
	String result_str			= "";
	String result_type			= "";
	String patient_id			= "";
	String encounter_id			= "";
	String patient_class		= "";

	ArrayList tabData			= null;
	ArrayList discrete_list_data= null;
	ArrayList discreteData		= null;


	String num_crit_low_points	= "";
	String num_crit_high_points	= "";
	String num_crit_low			= "";
	String num_crit_high		= "";
	String result_type_val		= "";
	String result_type_line_val	= "";
	String result_data			= "";
	String locale = properties.getProperty("LOCALE");
	locale = (locale == null || locale.equals(""))?"en":locale;
	

	try
	{
		sqlMap.put("SQL_OR_MULTI_PATIENT_RESULTING_AUTH_REQD_YN",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_AUTH_REQD_YN"));	
		sqlMap.put("SQL_OR_MULTI_PATIENT_RESULTING_LINE_VALUE",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_LINE_VALUE"));	
		sqlMap.put("SQL_OR_RESULT_REPORTING_INSERT_HEADER",(String)OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_INSERT_HEADER"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_INSERT_DETAIL",(String)OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_INSERT_DETAIL"));
		//sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS"));
		//sqlMap.put("SQL_OR_ORDER_GET_STATUS_CODE",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE"));
		//sqlMap.put("SQL_OR_REPORT_AUTH_ORD_UPDATE",(String)OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORD_UPDATE"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG",(String)OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG"));
		//sqlMap.put("SQL_OR_MULTI_PATIENT_RESULTING_LINE_COUNT",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_LINE_COUNT"));
		//sqlMap.put("SQL_OR_MULTI_PATIENT_RESULTING_HDR_UPDATE",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_HDR_UPDATE"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC",(String)OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_HEADER_DETAIL",(String)OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_HEADER_DETAIL"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT",OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER",OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK",OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK"));
		sqlMap.put("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_MESSAGE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE"));
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED"));
		sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG"));
        //sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE") );
		sqlMap.put("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION"));
		sqlMap.put("SQL_OR_MULTI_PATIENT_RESULTING_GET_PARENT_LAST_CHILD",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_GET_PARENT_LAST_CHILD"));
		sqlMap.put("SQL_OR_MULTI_PATIENT_RESULTING_GET_LINE_EXISTS_COUNT",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_GET_LINE_EXISTS_COUNT"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_UPDATE_HEADER",OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_HEADER"));
		sqlMap.put("SQL_OR_RESULT_REPORTING_UPDATE_CLOB",OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_CLOB"));
	

		int totalRecords		= Integer.parseInt(((String)hashMultiple.get("total_records_count")).trim());
		int discrete_count		= Integer.parseInt(((String)hashMultiple.get("total_values")).trim());
		String msr_panel_id		= ((String)hashMultiple.get("result_format")).trim();
		String clinician_id		= ((String)hashMultiple.get("clinician_id")).trim();
		String main_result_type	= ((String)hashMultiple.get("main_result_type")).trim();

		for(int i=0;i<totalRecords;i++)
		{
			tabData = new ArrayList();
			discrete_list_data = new ArrayList();
			order_id		= ((String)hashMultiple.get("order_id"+i)).trim();
			order_line_num	= ((String)hashMultiple.get("order_line_num"+i)).trim();
			order_type_code = ((String)hashMultiple.get("order_type_code"+i)).trim();

			catalog_code	= ((String)hashMultiple.get("catalog_code"+i)).trim();
			patient_id		= ((String)hashMultiple.get("patient_id"+i)).trim();
			encounter_id	= ((String)hashMultiple.get("encounter_id"+i)).trim();
			patient_class	= ((String)hashMultiple.get("patient_class"+i)).trim();
			result_type_val	= ((String)hashMultiple.get("rslt_type"+i)).trim();

			for(int j=0;j<discrete_count;j++)
			{
				discreteData = new ArrayList();
				discrete_msr_id = ((String)hashMultiple.get("discrete_measure_id"+j)).trim();
				result_type = ((String)hashMultiple.get("result_type"+j)).trim();
				srl_num = String.valueOf(j+1);

				result_type_line_val = ((String)hashMultiple.get("header_srv_stat"+i+j)).trim();

				if(result_type.equals("N") || result_type.equals("I"))
				{
					
					result_num				= ((String)hashMultiple.get("number_type"+i+j)).trim();
					result_num_uom			= ((String)hashMultiple.get("unit_of_measure"+j)).trim();
					num_crit_low_points		= ((String)hashMultiple.get("num_crit_low_points"+j)).trim();
					num_crit_high_points	= ((String)hashMultiple.get("num_crit_high_points"+j)).trim();
					num_crit_low			= ((String)hashMultiple.get("num_crit_low"+j)).trim();
					num_crit_high			= ((String)hashMultiple.get("num_crit_high"+j)).trim();
					result_str = null;
					result_data = null;
				}
				else
				{
					result_num				= null;
					result_num_uom			= null;
					num_crit_low_points		= null;
					num_crit_high_points	= null;
					num_crit_low			= null;
					num_crit_high			= null;
					if(result_type.equals("E"))
					{
						result_str = ((String)hashMultiple.get("date_hour_type"+i+j)).trim();
					}
					else if (result_type.equals("D"))
					{
						result_str = ((String)hashMultiple.get("date_type"+i+j)).trim();
					}
					else if (result_type.equals("C"))
					{
						result_str = ((String)hashMultiple.get("check_type"+i+j)).trim();
					}
					else if (result_type.equals("F"))
					{
						//result_str = ((String)hashMultiple.get("long_text_type"+i+j)).trim();
						result_str = "";
						result_data = ((String)hashMultiple.get("long_text_type"+i+j)).trim();
					}
					else if (result_type.equals("L"))
					{
						result_str = ((String)hashMultiple.get("list_type"+i+j)).trim();
					}
					else if (result_type.equals("T"))
					{
						result_str = ((String)hashMultiple.get("time_type"+i+j)).trim();
					}
					else if (result_type.equals("H"))
					{
						result_str = ((String)hashMultiple.get("short_text_type"+i+j)).trim();
					}
				}
				discreteData.add(discrete_msr_id.trim());
				discreteData.add(result_type.trim());
				discreteData.add(result_num);
				discreteData.add(result_num_uom);
				discreteData.add(result_str);
				discreteData.add(String.valueOf(srl_num));
				discreteData.add(((String)login_by_id).trim()) ;
				discreteData.add(((String)login_at_ws_no).trim()) ;
				discreteData.add(((String)login_facility_id).trim()) ;
				discreteData.add(num_crit_low_points);
				discreteData.add(num_crit_high_points);
				discreteData.add(num_crit_low);
				discreteData.add(num_crit_high);
				discreteData.add(result_type_line_val);
				discreteData.add(result_data);
				discrete_list_data.add(discreteData);
			}
			tabData.add(order_id.trim());
			tabData.add(order_line_num.trim());
			tabData.add(order_type_code.trim());
			tabData.add(catalog_code.trim());
			tabData.add(clinician_id.trim());
			tabData.add(msr_panel_id.trim());
			tabData.add(main_result_type.trim());
			tabData.add((ArrayList)discrete_list_data);
			tabData.add(((String)login_by_id).trim());
			tabData.add(((String)login_at_ws_no).trim());
			tabData.add(((String)login_facility_id).trim());
			tabData.add(patient_id.trim());
			tabData.add(encounter_id.trim());
			tabData.add(patient_class.trim());
			tabData.add(result_type_val.trim());
			recordStore.add((ArrayList)tabData);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	HashMap tabDataParam =  new HashMap();
 	tabDataParam.put( "UpdateData", recordStore);
 	tabDataParam.put( "login_by_id", login_by_id);
 	tabDataParam.put( "login_at_ws_no", login_at_ws_no);
 	tabDataParam.put( "locale", locale);
	tabDataParam.put( "properties", getProperties());

	try
	{
		Object home = com.ehis.eslp.ServiceLocator.getInstance ().getHome(OrRepositoryExt.getOrKeyValue("OR_MULTI_PATIENT_ORDERS_RESULTING_JNDI"), ORMultiPatientOrdersResultingHome.class, getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[]	= new Object[2];
		argArray[0]		= tabDataParam;
		argArray[1]		= sqlMap;

		Class [] paramArray = new Class[2];
		paramArray[0]	= tabDataParam.getClass();
		paramArray[1]	= sqlMap.getClass();

		map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		argArray	= null;
		paramArray	= null;
	}
	catch(Exception e)
	{
		System.err.println( "Error Calling EJB : "+e );
		map.put( "message", e.getMessage());
		e.printStackTrace();
	}
	map.put("traceVal",traceVal);
	traceVal.setLength(0);
	return map;
}

//////////////////////////////////////////////////

	public MultiPatientOrdersResultingBean()
    {
        recordSet = null;
        recordSet = new ArrayList();
    }

    public MultiPatientOrdersResultingBean(MultiPatientOrdersResultingBean recordset)
    {
        recordSet = null;
        recordSet = new ArrayList(recordset.recordSet);
    }

    public ArrayList getRecordSetHandle()
    {
        return new ArrayList(recordSet);
    }

    public int getSize()
    {
        int i = 0;
        if(recordSet != null)
            i = recordSet.size();
        return i;
    }

    public boolean clearAll()
        throws Exception
    {
        recordSet.clear();
        return true;
    }

    public boolean putObject(Object obj)
        throws Exception
    {
        try
        {
            recordSet.add(obj);
        }
        catch(Exception exception)
        {
            throw new Exception("Exception@putObject: " + exception);
        }
        return true;
    }

    public boolean setObject(int i, Object obj)
        throws Exception
    {
        try
        {
            if(i < getSize())
                recordSet.set(i, obj);
        }
        catch(Exception exception)
        {
            throw new Exception("Exception@setObject: " + exception);
        }
        return true;
    }

    public boolean addObject(int i, Object obj)
        throws Exception
    {
        try
        {
            if(i < getSize())
                recordSet.add(i, obj);
        }
        catch(Exception exception)
        {
            throw new Exception("Exception@setObject: " + exception);
        }
        return true;
    }

    public Object getObject(int i)
        throws Exception
    {
        Object obj = null;
        if(recordSet != null && i < getSize())
            obj = recordSet.get(i);
        return obj;
    }

    public boolean removeObject(int i)
        throws Exception
    {
        if(i < getSize())
        {
            recordSet.remove(i);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean containsObject(Object obj)
        throws Exception
    {
        boolean flag = false;
        if(recordSet != null)
            flag = recordSet.contains(obj);
        return flag;
    }

    public int indexOfObject(Object obj)
        throws Exception
    {
        int i = -1;
        if(recordSet != null)
            i = recordSet.indexOf(obj);
        return i;
    }

    ArrayList recordSet;
}//end of class

