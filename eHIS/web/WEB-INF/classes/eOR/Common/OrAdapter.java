/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Description
-------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
28/06/2012    	IN033502		Menaka V		In Multi-Facility Environment,  In consent forms, Facility Name is not getting
												printed properly.
24/07/2012	  	IN034159		Menaka V	    LIS-Blood Unit Consumption
09/11/2012		IN030473		Ramesh G		Bru-HIMS-CRF-032 
08/01/2012		IN036697		Ramesh G		System is displaying 500 Internal Sever Error for the patient name with ‘$’ special character.	
16/12/2013		IN036697		Ramesh G	    Special Characters Issue
16/03/2013		IN037783		Chowminya G	    Special character in the Consent Form in OR
06/06/2013		IN038093		Chowminya G	    In the create consent function, under the patient, can we have the element of "Alternate ID"
22/07/2013    	IN041421   		Chowminya G     Special characters - While record consent "Internal Server Error" is displayed
01/08/2013      IN042027		Chowminya G     Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached
27/12/2013		IN046075		Ramesh G		Bru-HIMS-CRF-391/20
13/03/2014		IN047595		Chowminya		Records order with select Buddhist calendar format, system display admission date wrong format
17/03/2014		IN047595.1		Chowminya		Reopen
17/07/2015		IN056491		Karthikeyan L										 Personnel at site did configure multiple references range for certain result in discrete measure. However, it is not appeared accordingly in the result reporting transaction.
21/10/2015	    IN057196	   	Ramesh G		Recording Of Consent Form
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
19/10/2017	IN065324		Dinesh T		19/10/2017		Ramesh G		To display the price in OR screen and 																						the billing status in Manage Specimen 																						screen
07/02/2018	IN066581		Sharanraj						Ramesh G		PMG2018-TECH-CRF-0001
22/04/2018	IN065908		Sharanraj		03/05/2018		Ramesh G		GHL-CRF-0493
08/05/2018	IN067563		Sharanraj		08/05/2018		Ramesh G		CA-GHL-CRF-0493/01-Record Consent
08/05/2018	IN067566		Sharanraj		08/05/2018		Ramesh G		CA-GHL-CRF-0493/03-Record Consent
09/05/2018	IN067565		Sharanraj		08/05/2018      Ramesh G		CA-GHL-CRF-0493/02-Record Consent
09/05/2018	IN067581		Sharanraj		08/05/2018		Ramesh G		Regression-CA-GHL-CRF-0493/07-Record Consent
17/07/2018	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
17/07/2018	IN068294		Kamalakannan	17/07/2018		Ramesh G		CA- ML-MMOH-CRF-0776/02
25/01/2019    IN068673    DineshT           25/01/2019    Ramesh G      ML-MMOH-CRF-1263
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
17/12/2020	11330		Sivabagyam M		17/12/2020		Ramesh G	SKR-SCF-1518 
27/07/2022	26826		Ramesh G	MMS-DM-CRF-0197
31/05/2023	44884		Krishna				31/05/2023		Ramesh G     	MO-CRF-20183
-------------------------------------------------------------------------------------------------------------------------------
*/

package eOR.Common ;

import eCommon.Common.* ;

import java.io.*;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;
import java.net.*; //IN036697

public abstract class OrAdapter extends CommonAdapter implements Serializable {
	LinkedHashMap<String,LinkedHashMap<String,ArrayList>> result = null;//IN064543
	public boolean flag = false;
	public boolean isSiteSpecificYN;//IN062992

	private String isGlobalFacilityYn;//IN068370,IN068373

	public OrAdapter() {
		super(CommonRepository.getCommonKeyValue( "ID_OR" ));	
	}

	// To set the Mode for the Local EJB or Remote EJB
    public void setLocalEJB(boolean flag){
 		this.flag = flag;
	}

	// To set the Mode for the Local EJB or Remote EJB
	public boolean getLocalEJB(){
		return flag;
	}

	//IN062992, starts
	public boolean isSiteSpecificYN()
	{
		return isSiteSpecificYN ;
	}
	//IN062992, ends

	//IN065324, starts
	HashMap siteSpecificDtls = new HashMap();

	public boolean isSiteSpecific(String functionId)
	{
		if(siteSpecificDtls.containsKey(functionId))
			return (Boolean)siteSpecificDtls.get(functionId);

		return false;
	}
	//IN065324, ends
	//IN068370,IN068373, starts
	public void setGlobalFacilityYn(String isGlobalFacilityYn)
	{
		this.isGlobalFacilityYn = isGlobalFacilityYn; 
	}

	public String getGlobalFacilityYn()
	{
		return isGlobalFacilityYn;
	}
	//IN068370,IN068373, ends
	// To get the Patient Id Length	
	public  int getPatientIdLength()throws Exception{
		int pat_length 				= 0 ;
		Connection connection		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		try {
				connection = getConnection() ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_ID_LENGTH") ) ;
				resultSet			= pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ){
					pat_length		= resultSet.getInt( "patient_id_length" )  ;
				}
			} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return pat_length ;
	}

// To get the Patient Id Length	, with Properties
	 public  int getPatientIdLength(Properties properties)throws Exception{
		int pat_length 				= 0 ;
		Connection connection		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		try {
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_ID_LENGTH") ) ;
				resultSet			= pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ){
					pat_length		= resultSet.getInt( "patient_id_length" )  ;
				}
			} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return pat_length ;
	}

	// To get the Sysdate, with Properties
	public ArrayList getSysDateTime(Properties properties) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate			= new ArrayList();

		try {
				connection				= ConnectionManager.getConnection(properties) ;
				//pstmt					= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;//11330
				String sql="select to_char(sysdate,'HH12:MM') sys_time,to_char(sysdate,'dd/mm/yyyy') sys_date, to_char(sysdate+1,'dd/mm/yyyy')   next_sys_date ,to_char(sysdate,'DD/mm/yyyy') || ' 23:59' curr_date, to_char(sysdate - 7,'DD/mm/yyyy') || ' 00:00' last_week_date, to_char(sysdate - 7,'DD/mm/yyyy') last_week_without_date,  to_char(sysdate + 7,'DD/mm/yyyy') next_week_without_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate - 30 ,'DD/mm/yyyy') last_month_date, to_char( sysdate, 'HH24:MI:SS' ) sys_time_sec, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sys_date_time_sec,USERENV('SESSIONID') session_id,TO_CHAR (SYSDATE + 3, 'DD/mm/yyyy') after_three_days  from dual";//11330
				pstmt					= connection.prepareStatement(sql);//11330
				resultSet				= pstmt.executeQuery() ;

				if( resultSet != null && resultSet.next() ) {
					currentDate.add(resultSet.getString("sys_date"))  ;
					currentDate.add(resultSet.getString("last_week_without_date"))  ;
					currentDate.add(resultSet.getString("sys_date_time"))  ;
					currentDate.add(resultSet.getString("next_week_without_date"))  ;
					currentDate.add(resultSet.getString("last_month_date"))  ;
					currentDate.add(resultSet.getString("sys_time_sec"))  ;
					currentDate.add(resultSet.getString("after_three_days"));//11330
					
				}
			} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
		}

		return currentDate;
	}

	// To check whether the module has been installed or not, if installed it return as 'Y' otherwise 'N'
	public String getModuleInstallYn(String module_id) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String module_install_yn	= "N";
	try{
			connection			= getConnection();
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
			pstmt.setString(1, checkForNull(module_id.trim(),""));
			resultSet			= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					module_install_yn = checkForNull(resultSet.getString( "install_yn" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return module_install_yn;
	} // End of getModuleInstallYn

	// To check whether the module has been installed or not, sm_modules_facility.operational_yn(Difft table referred)  if installed it return as 'Y' otherwise 'N'
		public String getFacilityModuleInstallYn(String module_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String module_install_yn	= "N";
		try{
				connection			= getConnection();
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, getLoginFacilityId()); // pass the facility_id
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						module_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return module_install_yn;
	} // End of getFacilityModuleInstallYn

	// To check whether the module has been installed or not, if installed it return as 'Y' otherwise 'N'
	// here properties is passed to get the connection and return back
	public String getModuleInstallYn(String module_id, Properties properties) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String module_install_yn	= "N";
	try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
			pstmt.setString(1, checkForNull(module_id.trim(),""));
			resultSet			= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					module_install_yn = checkForNull(resultSet.getString( "install_yn" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
		}
		return module_install_yn;
	} // End of getModuleInstallYn

	// To check whether the module has been installed or not, sm_modules_facility.operational_yn(Difft table referred)  if installed it return as 'Y' otherwise 'N'
	// here properties is passed to get the connection and return back, when using as an page scope bean
		public String getFacilityModuleInstallYn(String module_id,String facility_id, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String module_install_yn	= "N";
		try{
				connection			= ConnectionManager.getConnection(properties) ;
 				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, facility_id); // pass the facility_id
 				resultSet		= pstmt.executeQuery() ;
 				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						module_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
 					}
				}	// if there is no record, then also it should return as 'N'
 
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return module_install_yn;
	} // End of getFacilityModuleInstallYn

	//	 Deriving the Logic to display the Menu Buttons or not
	// here properties is passed to get the connection and return back, when using as an page scope bean
	public String getMenu(String menu_id,String resp_id,String pract_relation_id, Properties properties) throws Exception {

	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String menu_value			= "";
	try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MENU") ) ;
			pstmt.setString(1, menu_id);
			pstmt.setString(2, resp_id);
			pstmt.setString(3, pract_relation_id);

			resultSet			= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					menu_value = checkForNull(resultSet.getString( "Menu" ),"X") ;  // If not found then X
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
		}
		
		return menu_value;
	 }	 // End of the getMenu

	 // To get the Details for the Blood Transfusion
	 // here properties is passed to get the connection and return back, when using as an page scope bean
	public ArrayList getBloodTransfusion(String patient_id, Properties properties) throws Exception 
	{
		Connection connection 		       = null;
		PreparedStatement pstmt 	       = null;
		PreparedStatement stHist 	       = null;
		ResultSet resultSet 		       = null;
		ResultSet rsHist 		       = null;
		ArrayList BloodTransfusion         = new ArrayList() ;

		String  event_desc                 = "";
		String  result_str                 = "";
		String  hist_data_type             = "";
		String  hist_rec_type              = "";
		String  contr_sys_id			   = "";
		String  accession_num              = "";
		String  contr_sys_event_code       = "";
		String  encounter_id = "";//IN034159
		String  facility_id = "";//IN034159
		String  dataexists				   = "0";

		try
		{
				connection		= ConnectionManager.getConnection(properties) ;
				//pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BLOOD_TRANSFUSION_DETAILS") ) ;//IN034159
				pstmt			= connection.prepareStatement("SELECT long_desc event_desc,result_str,HIST_DATA_TYPE,a.HIST_REC_TYPE,CONTR_SYS_ID,ACCESSION_NUM,contr_sys_event_code, A.ENCOUNTER_ID, A.FACILITY_ID FROM cr_encounter_detail a,cr_clin_event_mast b WHERE a.hist_rec_type ='BLTF' AND patient_id = ? AND a.event_code = b.event_code order by 1") ;//IN034159
				stHist			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_BLOOD_TRANSFUSION") ) ;
				pstmt.setString(1, checkForNull( patient_id,""));
				resultSet	= pstmt.executeQuery() ;
				while(resultSet!= null && resultSet.next())
				{
					ArrayList Blood = new ArrayList();
					event_desc = resultSet.getString( "event_desc" );
					result_str = resultSet.getString( "result_str" );
					hist_data_type = resultSet.getString( "hist_data_type" );
					hist_rec_type = resultSet.getString( "hist_rec_type" );
					contr_sys_id = resultSet.getString( "contr_sys_id" );
					accession_num = resultSet.getString( "accession_num" );
					contr_sys_event_code = resultSet.getString( "contr_sys_event_code" );
					encounter_id = resultSet.getString( "ENCOUNTER_ID" );//IN034159
					facility_id = resultSet.getString( "FACILITY_ID" );//IN034159

					dataexists = "0";

					stHist.setString(1,hist_rec_type);
					stHist.setString(2,contr_sys_id);
					stHist.setString(3,accession_num);
					stHist.setString(4,contr_sys_event_code);
					rsHist = stHist.executeQuery();

					if (rsHist.next()) 
					{ 
						if(rsHist.getInt(1) >0) 
						{
							dataexists = "1";
						}
					}

					closeResultSet( rsHist ) ;//Check Style Violation

					Blood.add( event_desc ) ;
					Blood.add( result_str ) ;
					Blood.add( hist_data_type ) ;
					Blood.add( hist_rec_type ) ;
					Blood.add( contr_sys_id ) ;
					Blood.add( accession_num ) ;
					Blood.add( contr_sys_event_code ) ;
					Blood.add( encounter_id ) ;//IN034159
					Blood.add( facility_id ) ;//IN034159
					Blood.add( dataexists ) ;
					
					BloodTransfusion.add(Blood);
				}					
			}
			catch ( Exception e )	
			{

				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeResultSet( rsHist ) ;
				closeStatement( pstmt ) ;
				closeStatement( stHist ) ;
				if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
			}
		return BloodTransfusion;
	}	 // End of the getBloodTransfusion
	
	// IN046075 Start.
	// To get the Details for the Blood Transfusion for Confidentiality  Bru-HIMS-CRF-391
	 // here properties is passed to get the connection and return back, when using as an page scope bean
	public ArrayList getBloodTransfusion(String patient_id, Properties properties,String clinician_id,String resp_id) throws Exception 
	{
		Connection connection 		       = null;
		PreparedStatement pstmt 	       = null;
		PreparedStatement stHist 	       = null;
		ResultSet resultSet 		       = null;
		ResultSet rsHist 		       = null;
		ArrayList BloodTransfusion         = new ArrayList() ;

		String  event_desc                 = "";
		String  result_str                 = "";
		String  hist_data_type             = "";
		String  hist_rec_type              = "";
		String  contr_sys_id			   = "";
		String  accession_num              = "";
		String  contr_sys_event_code       = "";
		String  encounter_id = "";//IN034159
		String  facility_id = "";//IN034159
		String  dataexists				   = "0";

		try
		{
				connection		= ConnectionManager.getConnection(properties) ;
				
				pstmt			= connection.prepareStatement("SELECT long_desc event_desc,result_str,HIST_DATA_TYPE,a.HIST_REC_TYPE,CONTR_SYS_ID,ACCESSION_NUM,contr_sys_event_code, A.ENCOUNTER_ID, A.FACILITY_ID FROM cr_encounter_detail a,cr_clin_event_mast b WHERE a.hist_rec_type ='BLTF' AND patient_id = ? AND a.event_code = b.event_code  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.EVENT_CODE_TYPE,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y'  order by 1") ;
				stHist			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_BLOOD_TRANSFUSION") ) ;
				pstmt.setString(1, checkForNull( patient_id,""));
				resultSet	= pstmt.executeQuery() ;
				while(resultSet!= null && resultSet.next())
				{
					ArrayList Blood = new ArrayList();
					event_desc = resultSet.getString( "event_desc" );
					result_str = resultSet.getString( "result_str" );
					hist_data_type = resultSet.getString( "hist_data_type" );
					hist_rec_type = resultSet.getString( "hist_rec_type" );
					contr_sys_id = resultSet.getString( "contr_sys_id" );
					accession_num = resultSet.getString( "accession_num" );
					contr_sys_event_code = resultSet.getString( "contr_sys_event_code" );
					encounter_id = resultSet.getString( "ENCOUNTER_ID" );//IN034159
					facility_id = resultSet.getString( "FACILITY_ID" );//IN034159

					dataexists = "0";

					stHist.setString(1,hist_rec_type);
					stHist.setString(2,contr_sys_id);
					stHist.setString(3,accession_num);
					stHist.setString(4,contr_sys_event_code);
					rsHist = stHist.executeQuery();

					if (rsHist.next()) 
					{ 
						if(rsHist.getInt(1) >0) 
						{
							dataexists = "1";
						}
					}

					closeResultSet( rsHist ) ;//Check Style Violation

					Blood.add( event_desc ) ;
					Blood.add( result_str ) ;
					Blood.add( hist_data_type ) ;
					Blood.add( hist_rec_type ) ;
					Blood.add( contr_sys_id ) ;
					Blood.add( accession_num ) ;
					Blood.add( contr_sys_event_code ) ;
					Blood.add( encounter_id ) ;//IN034159
					Blood.add( facility_id ) ;//IN034159
					Blood.add( dataexists ) ;
					
					BloodTransfusion.add(Blood);
				}					
			}
			catch ( Exception e )	
			{

				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				//Check Style issue
				closeResultSet( resultSet ) ;
				closeResultSet( rsHist ) ;
				closeStatement( pstmt ) ;
				closeStatement( stHist ) ;
				if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
			}
		return BloodTransfusion;
	}	 // End of the getBloodTransfusion
	// IN046075 End.

/* To populate the Order CAtegorys ,except CS */

	public ArrayList  getOrderCategoryWithoutCareSet(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCategory		= new ArrayList();   
		try {

				connection		= ConnectionManager.getConnection(properties) ;														 
 				pstmt			= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
				pstmt.setString( 1, language_id);

				resultSet		= pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCategory.add(record) ;
				}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCategory;
	}



	// Method is used in for the template, to get the values depending upon the field_mnemonic_type
	public ArrayList getTemplateValues(String field_mnemonic_type) throws Exception {
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ArrayList TemplateValues			= new ArrayList() ;

		try {
				connection	= getConnection() ;
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORMAT_TEMPLATE_SELECT") ) ;
				pstmt.setString(1, field_mnemonic_type);
 				resultSet = pstmt.executeQuery() ;
				String[] record =	null;
				while ( resultSet != null && resultSet.next() ) {
					record = new String[5];
	
 					record[0] = resultSet.getString( "field_mnemonic_desc" )  ;
					record[1] = resultSet.getString( "field_mnemonic" )  ;
					record[2] = resultSet.getString( "field_mnemonic_type" )  ;
					record[3] = resultSet.getString( "field_mnemonic_data_type" )  ;
					record[4] = resultSet.getString( "field_mnemonic_query" )  ;
 					TemplateValues.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return TemplateValues;
	}

	// IN030473 Start.
	// Method is used in Consent/REfusal Orders(TRansaction) to replace the mnenominc details
	//public String getMnemonicDetails(String pat_id, String facility_id, String encntr_id, String ord_id,String editor_type, String editor_template) throws Exception {
	// Method is used in Consent/REfusal/Patient Intervertion Orders(TRansaction) to replace the mnenominc details
	//included cat_code IN042027
	//public String getMnemonicDetails(String pat_id, String facility_id, String encntr_id, String ord_id,String editor_type, String editor_template,String intervention_id) throws Exception {
	//IN030473 End.
	public String getMnemonicDetails(String pat_id, String facility_id, String encntr_id, String ord_id,String editor_type, String editor_template,String intervention_id, String cat_code) throws Exception {
		Connection connection 				= null;
		PreparedStatement pstmt_template	= null;
		ResultSet resultSet_template 		= null;
		/*IN065908 starts*/
		PreparedStatement pstmt_template1	= null;
		ResultSet resultSet_template1 		= null;
		/*IN065908 ends*/
 		String admission_date				= "", anaesthesia 		= "", anaesthetist_code		= "";
		String attending_practitioner		= "", bed_num			= "", blood_grp				= "";
		//String cmn_service				= "", cmn_speciality	= "", current_date_time	= "";
		String current_location				= "", date_of_birth		= "", encounter_id			= "";
		String facility_name				= "", gender			= "", mar_status_code		= "";
		String name_prefix					= "", nationality_code	= "", ordering_location		= "";
		String ordering_practitioner		= "", order_category	= "", order_date			= "";
		String order_id						= "", order_type		= "", patient_class			= "";
		String patient_id					= "", patient_name		= "", perform_surgeon		= "";
		String pref_surg_date				= "", priority			= "", reason_refusal		= "";
		String region_code					= "", regn_date			= "", relgn_code			= "";
		String res_area_code				= "", res_town_code		= "", rh_factor				= "";
		String room_num						= "", service_code		= "", speciality			= "";
		//String sys_date_time				= "";
		String  residentail_address			= "", catalog_description="", age					= "";
		String  sex							= "";
		String  catalog_long_desc			= "", catalog_short_desc = "", catalog_explantory_text= "";
		String SOURCE_TYPE="", location_description="";
		String national_id_no="";
		char  variance_identity;
		String variance_code				= "", variance_desc		= "";
		int			start_val				= 0;
		int			first_end_val			= 0,  end_val			= 0, var_count				= 0;
		String 	intervention			="";  // IN030473
		String 	intervention_type	="";  // IN030473
		String oth_alt_id_no=""; //IN038093
		String nkin_contact_name="";//IN065908
		String nkin_contact_relation="";//IN065908
		String system_date="";//IN065908
		String system_time="";//IN065908
		
		StringTokenizer stCatalog			= null;
		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		
		//StringBuffer pat_name = new StringBuffer();//IN037783//Check Style Violation
 
		if(editor_type==null) editor_type	= ""; // E --> For editor or P --> For Plain

		try {
				// if consent_format is for editor, then fire the queries to take the patient_details, order details, and encounter details
				if(editor_template!=null && !editor_template.equals("") && editor_type.equals("E")) {
					connection	= getConnection() ;
					pstmt_template = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_PATIENT_TEMPLATE_SELECT") ) ;
					pstmt_template.setString( 1, language_id);
					pstmt_template.setString( 2, language_id);
					pstmt_template.setString( 3, language_id);
					pstmt_template.setString( 4, language_id);
					pstmt_template.setString( 5, language_id);//SRR20056-SCF-8249-RF [IN:056491]
					pstmt_template.setString( 6, language_id);//IN067565
					pstmt_template.setString( 7, language_id);//IN067565
					pstmt_template.setString( 8, pat_id);//IN067565
					resultSet_template = pstmt_template.executeQuery() ;
					if(resultSet_template!=null && resultSet_template.next()){ //one record
							patient_id			= checkForNull(resultSet_template.getString( "patient_id" ))  ;
							regn_date			= checkForNull(resultSet_template.getString( "regn_date"))  ;
							patient_name		= checkForNull(resultSet_template.getString( "patient_name" ))  ;
							gender				= checkForNull(resultSet_template.getString( "gender" ))  ;
							sex					= checkForNull(resultSet_template.getString( "sex" ))  ;							
							date_of_birth		= checkForNull(resultSet_template.getString( "date_of_birth" ))  ;
							mar_status_code		= checkForNull(resultSet_template.getString( "mar_status_code" ))  ;
							nationality_code	= checkForNull(resultSet_template.getString( "nationality_code" ))  ;
							//facility_name		= checkForNull(resultSet_template.getString( "facility_name" )) ;//IN033502
							res_area_code		= checkForNull(resultSet_template.getString( "res_area_code" ))  ;
							res_town_code		= checkForNull(resultSet_template.getString( "res_town_code" ))  ;
							relgn_code			= checkForNull(resultSet_template.getString( "relgn_code" ))  ;
							name_prefix			= checkForNull(resultSet_template.getString( "name_prefix" ))  ;
							region_code			= checkForNull(resultSet_template.getString( "region_code" ))  ;
							blood_grp			= checkForNull(resultSet_template.getString( "blood_grp" ))  ;
							rh_factor			= checkForNull(resultSet_template.getString( "rh_factor" ))  ;
							//sys_date_time		= checkForNull(resultSet_template.getString( "sys_date_time" ))  ;
							residentail_address	= checkForNull(resultSet_template.getString( "residentail_address" ))  ;
							age					= checkForNull(resultSet_template.getString( "age" ))  ;
							national_id_no		= checkForNull(resultSet_template.getString( "national_id_no" ))  ;
							nkin_contact_name		= checkForNull(resultSet_template.getString( "nkin_contact_name" ))  ;//IN065908
							/*IN067581 STARTS*/
							//nkin_contact_relation		= checkForNull(resultSet_template.getString( "nkin_contact_relation" ))  ;//IN065908
							nkin_contact_relation		= checkForNull(resultSet_template.getString( "nkin_contact_relation_desc" ))  ;
							/*IN067581 ENDS*/
							system_date=checkForNull(resultSet_template.getString( "system_date" ))  ;//IN065908
							system_time=checkForNull(resultSet_template.getString( "system_time" ))  ;//IN065908
							
					}
					// close the statements
					closeResultSet( resultSet_template ) ;
					closeStatement( pstmt_template ) ;
					/*IN065908 starts*/
					ArrayList Diag_code=new ArrayList();
					ArrayList Diag_desc=new ArrayList();
					
					/*IN067566 Starts*/
					//pstmt_template1 = connection.prepareStatement("SELECT  a.term_code diag_code, d.short_desc diag_desc FROM pr_diagnosis a, mr_term_code d, mr_term_set c WHERE c.term_set_id = a.term_set_id AND d.term_set_id = a.term_set_id AND d.term_code = a.term_code AND a.patient_id = ?  AND NVL (a.curr_status, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE ('N','N', 'N', NVL (sensitive_yn, 'N'))ORDER BY a.onset_date DESC");
					pstmt_template1 = connection.prepareStatement("SELECT  a.term_code diag_code, d.short_desc diag_desc FROM pr_diagnosis a, mr_term_code d, mr_term_set c WHERE c.term_set_id = a.term_set_id AND d.term_set_id = a.term_set_id AND d.term_code = a.term_code AND a.patient_id = ? AND c.term_set_id LIKE 'ICD%' AND d.term_set_id LIKE 'ICD%' AND NVL (a.curr_status, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE ('N','N', 'N', NVL (sensitive_yn, 'N'))ORDER BY a.onset_date DESC");
					/*IN067566 Ends*/
					pstmt_template1.setString( 1, pat_id);
					
					resultSet_template1 = pstmt_template1.executeQuery() ;
					
					if(resultSet_template1!=null)
					{
						while(resultSet_template1.next())
						{
							Diag_code.add(resultSet_template1.getString( "diag_code" ));
							Diag_desc.add(resultSet_template1.getString( "diag_desc" ));
						}
					}
					closeResultSet( resultSet_template1 ) ;
					closeStatement( pstmt_template1 ) ;
					/*IN065908 ends*/
					//IN038093 Start
					pstmt_template = connection.prepareStatement( "select b.SHORT_DESC || ' ' || NVL(OTH_ALT_ID_NO,'') oth_alt_id_no from MP_PATIENT a, MP_ALTERNATE_ID_TYPE b where a.OTH_ALT_ID_TYPE=b.ALT_ID_TYPE and a.PATIENT_ID=?") ;
					pstmt_template.setString( 1, pat_id);
					resultSet_template = pstmt_template.executeQuery() ;
					if(resultSet_template!=null && resultSet_template.next())
					{ 
							oth_alt_id_no		= checkForNull(resultSet_template.getString( "oth_alt_id_no" ))  ;							
					}
					closeResultSet( resultSet_template ) ;
					closeStatement( pstmt_template ) ;
					//IN038093 End

					// For the Encounter Info Details
					pstmt_template = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_ENCOUNTER_TEMPLATE_SELECT") ) ;
					
					pstmt_template.setString( 1, language_id);
					pstmt_template.setString( 2, facility_id);
					pstmt_template.setString( 3, language_id);
					pstmt_template.setString( 4, facility_id);
					pstmt_template.setString( 5, language_id);
					pstmt_template.setString( 6, language_id);
					pstmt_template.setString( 7, language_id);
					pstmt_template.setString( 8, language_id);
					pstmt_template.setString( 9, language_id);
					pstmt_template.setString( 10, facility_id);
					pstmt_template.setString( 11, encntr_id);
 					resultSet_template = pstmt_template.executeQuery() ;
 					if(resultSet_template!=null && resultSet_template.next()){ //one record
							encounter_id		= checkForNull(resultSet_template.getString( "encounter_id" )) ;
 							current_location	= checkForNull(resultSet_template.getString( "current_location" ))  ;
							attending_practitioner= checkForNull(resultSet_template.getString( "attending_practitioner" ))  ;
							speciality			= checkForNull(resultSet_template.getString( "speciality" ))  ;
							admission_date		= checkForNull(resultSet_template.getString( "admission_date" ))  ;
							patient_class		= checkForNull(resultSet_template.getString( "patient_class" ))  ;
							room_num			= checkForNull(resultSet_template.getString( "room_num") )  ;
							bed_num				= checkForNull(resultSet_template.getString( "bed_num" ))  ;
							service_code		= checkForNull(resultSet_template.getString( "service_code" ))  ;
					}
					// close the statements
					closeResultSet( resultSet_template ) ;
					closeStatement( pstmt_template ) ;

					// For the Order Info Details
					if(!"".equals(ord_id)){   //IN030473
					pstmt_template = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_ORDER_TEMPLATE_SELECT") ) ;
					pstmt_template.setString( 1, language_id);
					pstmt_template.setString( 2, language_id);
					pstmt_template.setString( 3, language_id);
					pstmt_template.setString( 4, language_id);
					pstmt_template.setString( 5, language_id);
					pstmt_template.setString( 6, language_id);
					pstmt_template.setString( 7, ord_id);
					resultSet_template = pstmt_template.executeQuery() ;
					if(resultSet_template!=null && resultSet_template.next()){ //one record
							order_id				= checkForNull(resultSet_template.getString( "order_id" ))  ;
							order_date				= checkForNull(resultSet_template.getString( "order_date" ))  ;
							priority				= checkForNull(resultSet_template.getString( "priority" ))  ;
							
							if(priority.equals("R") || priority.equals(""))
							{
								priority=common_labels.getString("Common.routine.label");
							}
							else if(priority.equals("U"))
							{
								priority=common_labels.getString("Common.urgent.label");
							}
							else if(priority.equals("S"))
							{
								//priority=or_labels.getString("eOR.Stat.label");
								priority=common_labels.getString("Common.Stat.label");
							}
							
							SOURCE_TYPE				= checkForNull(resultSet_template.getString( "SOURCE_TYPE" ))  ;
							location_description				= checkForNull(resultSet_template.getString( "location_description" ))  ;
							//ordering_location		= checkForNull(resultSet_template.getString( "ordering_location" ))  ;
							ordering_location=SOURCE_TYPE+"/"+location_description;
							//priority="$$"+priority;
							ordering_practitioner	= checkForNull(resultSet_template.getString( "ordering_practitioner" ))  ;
							order_type				= checkForNull(resultSet_template.getString( "order_type" ))  ;
							order_category			= checkForNull(resultSet_template.getString( "order_category" ))  ;
							anaesthesia				= checkForNull(resultSet_template.getString( "anaesthesia" ))  ;
							pref_surg_date			= checkForNull(resultSet_template.getString( "pref_surg_date" ))  ;
							perform_surgeon			= checkForNull(resultSet_template.getString( "perform_surgeon" ))  ;
							anaesthetist_code		= checkForNull(resultSet_template.getString( "anaesthetist_code" ))  ;
							reason_refusal			= checkForNull(resultSet_template.getString( "reason_refusal" ))  ;
							catalog_description		= checkForNull(resultSet_template.getString( "orderable" ))  ; // Function will return short_desc|long_desc|explanatory_text
 							// split it to take the values
							if(!catalog_description.equals("")) {
								stCatalog			= new StringTokenizer(catalog_description,"||");
 								while(stCatalog.hasMoreTokens()){
									 catalog_short_desc			= checkForNull(stCatalog.nextToken(),"");   // Get the short_desc 
 							         catalog_long_desc			= checkForNull(stCatalog.nextToken(),"");   // Get the long_desc
									 catalog_explantory_text	= checkForNull(stCatalog.nextToken(),"");   // Get the explantory_text
  								} // End of While
								if(catalog_short_desc!=null && catalog_short_desc.equals("NULL"))
									catalog_short_desc		= "";
								if(catalog_long_desc!=null && catalog_long_desc.equals("NULL"))
									catalog_long_desc		= "";
								if(catalog_explantory_text!=null && catalog_explantory_text.equals("NULL"))
									catalog_explantory_text = "";
							} // End of !catalog_description
							stCatalog	 = null;
 					} // End of resultSet_template
					// close the statements
					closeResultSet( resultSet_template ) ;
					closeStatement( pstmt_template ) ;
					}  //IN042027 - Start
					else
					{   
						pstmt_template = connection.prepareStatement( "select short_Desc,nvl(long_desc,short_Desc) long_desc,nvl(explanatory_text,long_Desc) explanatory_text from or_order_catalog where order_Catalog_code = ?" ) ;
						pstmt_template.setString( 1, cat_code);
						resultSet_template = pstmt_template.executeQuery() ;
						if(resultSet_template!=null && resultSet_template.next())
						{
							catalog_short_desc				= checkForNull(resultSet_template.getString( "short_Desc" ))  ;
							catalog_long_desc				= checkForNull(resultSet_template.getString( "long_desc" ))  ;
							catalog_explantory_text				= checkForNull(resultSet_template.getString( "explanatory_text" ))  ;
								
							if(catalog_short_desc!=null && catalog_short_desc.equals("NULL"))
								catalog_short_desc		= "";
							if(catalog_long_desc!=null && catalog_long_desc.equals("NULL"))
								catalog_long_desc		= "";
							if(catalog_explantory_text!=null && catalog_explantory_text.equals("NULL"))
								catalog_explantory_text = "";
						} 
	 					
						closeResultSet( resultSet_template ) ;
						closeStatement( pstmt_template ) ;
					} 
					//IN042027 - End
					// IN030473 Start.
					if(!"".equals(intervention_id)){
						pstmt_template = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_INTERVENTION_TEMPLATE_SELECT") ) ;
						pstmt_template.setString( 1, intervention_id);
						resultSet_template = pstmt_template.executeQuery() ;
						if(resultSet_template!=null && resultSet_template.next()){ //one record
								intervention				= checkForNull(resultSet_template.getString( "INTERVENTION" ))  ;
								intervention_type				= checkForNull(resultSet_template.getString( "INTERVENTIONTYPE" ))  ;
								
						} // End of resultSet_template
						// close the statements
						closeResultSet( resultSet_template ) ;
						closeStatement( pstmt_template ) ;
					} // IN030473 End.
					/** checking for the template **/
					//IN033502 Starts
					String sql = "SELECT facility_name FROM sm_facility_param where facility_id=?";
					pstmt_template = connection.prepareStatement(sql) ;
					pstmt_template.setString( 1, facility_id);
					resultSet_template = pstmt_template.executeQuery() ;
 					if(resultSet_template!=null && resultSet_template.next())
					{
						facility_name		= checkForNull(resultSet_template.getString( "facility_name" )) ;
					}
					closeResultSet( resultSet_template ) ;
					closeStatement( pstmt_template ) ;
					//IN033502 Ends 

				// Check if any Dynamic Variance are there, Now the max set is 20 dyanmic Lookups
				for(int i=0;i<=20;i++) { // For Loop will be for 20 times, to check any dynamic Lookup is there
						//~START`VCode|AnyDescriptionEntered~END`
 						if(editor_template.indexOf("~START`")!=-1 && editor_template.indexOf("~END`")!=-1){

							start_val			= editor_template.indexOf("~START`");   // Will give the starting 

							variance_identity   = editor_template.charAt(start_val+7);  // Will give the Variance(V)/... 

							first_end_val		= editor_template.indexOf("|");

  						    variance_code		= editor_template.substring(start_val+8, first_end_val); //After variance till | 

							end_val				= editor_template.indexOf("~END`");

						    variance_desc		= editor_template.substring(first_end_val+1, end_val); //~END is 4

							var_count				= 0;
							if(variance_identity=='V') // variance 
							{
 

								 // Call a Function, returns true or false
								pstmt_template = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_AGE_GROUP_SELECT") ) ;
								pstmt_template.setString( 1, variance_code);  //age_group_code
								pstmt_template.setString( 2, sex);			  //gender
								pstmt_template.setString( 3, sex);			  //gender
								pstmt_template.setString( 4, date_of_birth);
 								resultSet_template = pstmt_template.executeQuery() ;
								if(resultSet_template!=null && resultSet_template.next()){ //one record
								  var_count		   = resultSet_template.getInt(1);
								}
								 if(var_count>0)
									editor_template	= editor_template.substring(0,start_val)+variance_desc+editor_template.substring(end_val+5);	
								 else
									editor_template	= editor_template.substring(0,start_val)+editor_template.substring(end_val+5);	
 	 						} // End of variance_identity=="V"
							// close the statements
							closeResultSet( resultSet_template ) ;
							closeStatement( pstmt_template ) ;
						} // End of if
					}  // End of for 
 						// First check with the Personal Info
						editor_template = editor_template.replaceAll("%", "^");//IN041421
						//Included 	encode to many template components for IN041421
						
						if(editor_template.indexOf("~PATIENT_ID`")!=-1){
							editor_template	= editor_template.replaceAll("~PATIENT_ID`",patient_id);				
						} 
						if(editor_template.indexOf("~REGN_DATE`")!=-1){
							editor_template	= editor_template.replaceAll("~REGN_DATE`",regn_date);				
						} 
						if(editor_template.indexOf("~PATIENT_NAME`")!=-1)
						{
						//editor_template	= editor_template.replaceAll("~PATIENT_NAME`",patient_name);	//IN036697 
						editor_template	= editor_template.replaceAll("~PATIENT_NAME`",URLEncoder.encode(patient_name,"UTF-8"));	//IN036697
						} 
						//condition Added - IN037783 - Start //IN041421
						/*if(patient_name.indexOf("$")==-1)
						{
							if(editor_template.indexOf("~PATIENT_NAME`")!=-1)
							{
							editor_template	= editor_template.replaceAll("~PATIENT_NAME`",patient_name);	//IN036697 //uncommented
							//editor_template	= editor_template.replaceAll("~PATIENT_NAME`",URLEncoder.encode(patient_name,"UTF-8"));	//IN036697//IN037783 - commentted
							} 
						}else
						{
							if(patient_name.indexOf("$")!=-1)
							{
								StringTokenizer stoken = new StringTokenizer(patient_name,"$");
								String update_value = "";
								while(stoken.hasMoreTokens()) 
								{
									if(!update_value.equals(""))
									{
										pat_name.append("||");
									}
									update_value		=	 stoken.nextToken();
									pat_name.append(update_value);
									patient_name = pat_name.toString();
								}
							}
							editor_template	= editor_template.replaceAll("~PATIENT_NAME`",patient_name);	
						}*///IN037783 - End
						if(editor_template.indexOf("~GENDER`")!=-1){
							editor_template	= editor_template.replaceAll("~GENDER`",gender);			
						}
						if(editor_template.indexOf("~DATE_OF_BIRTH`")!=-1){
							editor_template	= editor_template.replaceAll("~DATE_OF_BIRTH`",date_of_birth);		
						}
						if(editor_template.indexOf("~MAR_STATUS_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~MAR_STATUS_CODE`",mar_status_code);	
						} 
						if(editor_template.indexOf("~NATIONALITY_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~NATIONALITY_CODE`",nationality_code);	
						} 
						if(editor_template.indexOf("~FACILITY_NAME`")!=-1){
							editor_template	= editor_template.replaceAll("~FACILITY_NAME`",facility_name);	
						}
						if(editor_template.indexOf("~RES_AREA_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~RES_AREA_CODE`",res_area_code);	
						} 
						if(editor_template.indexOf("~RES_TOWN_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~RES_TOWN_CODE`",res_town_code);	
						}
						if(editor_template.indexOf("~RELGN_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~RELGN_CODE`",relgn_code);	
						}
						if(editor_template.indexOf("~RESIDENTAIL_ADDRESS`")!=-1){
							editor_template	= editor_template.replaceAll("~RESIDENTAIL_ADDRESS`",URLEncoder.encode(residentail_address,"UTF-8"));	  
						}
						if(editor_template.indexOf("~NAME_PREFIX`")!=-1){
							editor_template	= editor_template.replaceAll("~NAME_PREFIX`",name_prefix);	
						}
						if(editor_template.indexOf("~REGION_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~REGION_CODE`",region_code);	
						}
						if(editor_template.indexOf("~BLOOD_GRP`")!=-1){
							editor_template	= editor_template.replaceAll("~BLOOD_GRP`",blood_grp);	
						}
						if(editor_template.indexOf("~RH_FACTOR`")!=-1){
							editor_template	= editor_template.replaceAll("~RH_FACTOR`",rh_factor);	 
						}
						if(editor_template.indexOf("~AGE`")!=-1){
							editor_template	= editor_template.replaceAll("~AGE`",age);	 
						}
						if(editor_template.indexOf("~PATIENT_NRIC`")!=-1){
							editor_template	= editor_template.replaceAll("~PATIENT_NRIC`",national_id_no);	 
						}
						/*IN065908 starts*/
						if(editor_template.indexOf("~NEXT_OF_KIN_NAME`")!=-1){
							editor_template	= editor_template.replaceAll("~NEXT_OF_KIN_NAME`",nkin_contact_name);	 
						}
						if(editor_template.indexOf("~NEXT_OF_KIN_RELATION`")!=-1){
							editor_template	= editor_template.replaceAll("~NEXT_OF_KIN_RELATION`",nkin_contact_relation);	 
						}
						if(editor_template.indexOf("~SYSTEM_DATE`")!=-1){
							editor_template	= editor_template.replaceAll("~SYSTEM_DATE`",system_date);	 
						}
						if(editor_template.indexOf("~SYSTEM_TIME`")!=-1){
							editor_template	= editor_template.replaceAll("~SYSTEM_TIME`",system_time);	 
						}
						
						if(editor_template.indexOf("~DIAGNOSIS`")!=-1){
						if(Diag_code.size()==0)
						{
							editor_template=editor_template.replaceAll("~DIAGNOSIS`","");
						}
						/*IN067563 starts*/
						else
						{
							StringBuffer code=new StringBuffer();
							for(int i=0;i<Diag_code.size();i++)
							{	
								
								code=code.append(Diag_code.get(i)+"-"+Diag_desc.get(i)+"<br>");
							}	
							editor_template	= editor_template.replaceAll("~DIAGNOSIS`",code.toString());
							}
						}
						/*IN067563 ends*/
						/*IN065908 ends*/
						//IN038093 Start
						if(editor_template.indexOf("~OTH_ALT_ID_NO`")!=-1){
							editor_template	= editor_template.replaceAll("~OTH_ALT_ID_NO`",oth_alt_id_no);	 
						}
						//IN038093 End
						
						// Personal Info Ends

						// Encounter Info Starts
						if(editor_template.indexOf("~ENCOUNTER_ID`")!=-1){  
							editor_template	= editor_template.replaceAll("~ENCOUNTER_ID`",encounter_id);	 
						}
						if(editor_template.indexOf("~CURRENT_LOCATION`")!=-1){
							editor_template	= editor_template.replaceAll("~CURRENT_LOCATION`",URLEncoder.encode(current_location,"UTF-8"));	
						//} if(editor_template.indexOf("~PRACTITIONER(L)`")!=-1){
						//	editor_template	= editor_template.replaceAll("~PRACTITIONER(L)`","PRACTITIONER(L)");	
						}
						if(editor_template.indexOf("~SPECIALITY`")!=-1){
							editor_template	= editor_template.replaceAll("~SPECIALITY`",speciality);	
						}
						if(editor_template.indexOf("~ADMISSION_DATE`")!=-1){
							editor_template	= editor_template.replaceAll("~ADMISSION_DATE`",admission_date);	
						} 
						if(editor_template.indexOf("~PATIENT_CLASS`")!=-1){
							editor_template	= editor_template.replaceAll("~PATIENT_CLASS`",patient_class);	
						} 
						if(editor_template.indexOf("~ROOM_NUM`")!=-1){
							editor_template	= editor_template.replaceAll("~ROOM_NUM`",room_num);	
						}
						if(editor_template.indexOf("~BED_NUM`")!=-1){
							editor_template	= editor_template.replaceAll("~BED_NUM`",bed_num);	
						}
						if(editor_template.indexOf("~ATTENDING_PRACTITIONER`")!=-1){
							editor_template	= editor_template.replaceAll("~ATTENDING_PRACTITIONER`",URLEncoder.encode(attending_practitioner,"UTF-8"));	
						}
						if(editor_template.indexOf("~SERVICE_CODE`")!=-1){
							editor_template	= editor_template.replaceAll("~SERVICE_CODE`",service_code);	
						}
						//End of Encounter Info

						// Order Informations
						if(editor_template.indexOf("~ORDER_ID`")!=-1){				
							editor_template	= editor_template.replaceAll("~ORDER_ID`",order_id);	  
						}
						if(editor_template.indexOf("~ORDER_DATE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDER_DATE`",order_date);	  
						}
						if(editor_template.indexOf("~PRIORITY`")!=-1){
							
								editor_template	= editor_template.replaceAll("~PRIORITY`",priority);	  
						} 
						if(editor_template.indexOf("~ORDERING_LOCATION`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERING_LOCATION`",URLEncoder.encode(ordering_location,"UTF-8"));
						}
						if(editor_template.indexOf("~ORDERING_PRACTITIONER`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERING_PRACTITIONER`",URLEncoder.encode(ordering_practitioner,"UTF-8"));
						}
						if(editor_template.indexOf("~ORDER_TYPE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDER_TYPE`",order_type);
						}
						if(editor_template.indexOf("~ORDER_CATEGORY`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDER_CATEGORY`",order_category);
						}
						if(editor_template.indexOf("~ANAESTHESIA`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ANAESTHESIA`",URLEncoder.encode(anaesthesia,"UTF-8"));
						}
						if(editor_template.indexOf("~PREF_SURG_DATE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~PREF_SURG_DATE`",pref_surg_date);
						}
						if(editor_template.indexOf("~PERFORM_SURGEON`")!=-1){				 
							editor_template	= editor_template.replaceAll("~PERFORM_SURGEON`",URLEncoder.encode(perform_surgeon,"UTF-8"));
						}
						if(editor_template.indexOf("~ANAESTHETIST_CODE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ANAESTHETIST_CODE`",anaesthetist_code);
						}
						if(editor_template.indexOf("~REASON_REFUSAL`")!=-1){				 
							editor_template	= editor_template.replaceAll("~REASON_REFUSAL`",URLEncoder.encode(reason_refusal,"UTF-8"));
						}
						if(editor_template.indexOf("~ORDERABLE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERABLE`",URLEncoder.encode(catalog_short_desc,"UTF-8"));
						}
						if(editor_template.indexOf("~ORDERABLE_LONG`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERABLE_LONG`",URLEncoder.encode(catalog_long_desc,"UTF-8"));
						}
						if(editor_template.indexOf("~EXPLANTORY_TEXT`")!=-1){				 
							editor_template	= editor_template.replaceAll("~EXPLANTORY_TEXT`",URLEncoder.encode(catalog_explantory_text,"UTF-8"));
						}
 						// End of Order Info
						//IN030473 Start.
						//Intervention Info
						if(editor_template.indexOf("~INTERVENTION`")!=-1){	
							editor_template	= editor_template.replaceAll("~INTERVENTION`",URLEncoder.encode(intervention,"UTF-8"));
						}
						if(editor_template.indexOf("~INTERVENTION_TYPE`")!=-1){	
							editor_template	= editor_template.replaceAll("~INTERVENTION_TYPE`",URLEncoder.encode(intervention_type,"UTF-8"));
						}
						//IN030473 End.						
						
						editor_template  = URLEncoder.encode(editor_template,"UTF-8");//IN037783
						
						if(editor_template.indexOf("~")!=-1 && editor_template.indexOf("`")!=-1){	
							editor_template	= editor_template.substring(0,editor_template.indexOf("~")) + "N/A"+editor_template.substring(editor_template.indexOf("`")+1);
						}
			}	// End of editor_type E
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet_template ) ;
			closeStatement( pstmt_template ) ;
			closeConnection(connection) ;
		}
		//return editor_template;  //[IN036697]
		return URLDecoder.decode(editor_template,"UTF-8"); //[IN036697]
	}


	public ArrayList getSysDateTime() throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate			= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

	public String getOperationalStatus(String perform_oper, String order_id,String order_line_num)throws Exception{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String  valid_operation_yn		= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_OPERTIONAL_STATUS") ) ;
			pstmt.setString(1, checkForNull(perform_oper.trim(),""));
			pstmt.setString(2, checkForNull(order_id.trim(),""));
			pstmt.setString(3, checkForNull(order_line_num.trim(),""));

			resultSet			= pstmt.executeQuery() ;

			while(resultSet != null && resultSet.next())
			{
				valid_operation_yn = checkForNull(resultSet.getString( "operation_yn" ),"N")  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return valid_operation_yn;


	}

	public String getBillInterfaceYn() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String billing_interface_yn= "N";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_LOCATION"));
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					billing_interface_yn = checkForNull(resultSet.getString( "bl_module_yn" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
	 	} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return billing_interface_yn;
 } // End of getBillingInterfaceYn

/* 
	Added by Uma on 8/22/2009 for PMG20089 CRF 641
	To Check if the Enterprise level ordering or authorisation privileges are applicable 
*/
 public String getAuthorisationOrOrderingYn(String called_from) throws Exception 
{
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String allow_priv_yn = "N";
	 String sql = "";
	 try 
	{
			connection	= getConnection();
			if(called_from.equalsIgnoreCase("AUT"))
			{
				sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PARAM_PRIV_TO_AUTHORISE");
			}
			else if(called_from.equalsIgnoreCase("ORD"))
			{
				sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PARAM_PRIV_TO_ORDER");
			}
			pstmt		= connection.prepareStatement(sql);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					allow_priv_yn = checkForNull(resultSet.getString( "allow_priv_yn" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
	 	} 
		finally 
		{
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return allow_priv_yn;
 } // End of getOrderAuthorisationYn
 /* End here*/


	public HashMap getScheduleDates(HashMap hash ,ArrayList arrList,ArrayList timeList)
	{	
		
		//Modified by Ambiga.M on 2/4/2010	for 18855 occurrences of "en" (in this method) are replaced with locale to handle thai language --in plusDate(),getDayOfWeekAsShortText(),isBefore()
		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;	
		String durationType = hash.get("durationType")==null?"":(String)hash.get("durationType");
		String start_day_param = hash.get("start_day_param")==null?"":(String)hash.get("start_day_param");
		String pr_duration_type = hash.get("duration_type")==null?"":(String)hash.get("duration_type");
		int duration = Integer.parseInt((hash.get("duration")==null?"0":(String)hash.get("duration")));
		int repeat = Integer.parseInt((hash.get("repeat")==null?"0":(String)hash.get("repeat")));
		int Interval_value = Integer.parseInt((hash.get("Interval_value")==null?"1":(String)hash.get("Interval_value")));
		String start_time_param = hash.get("start_time_param")==null?"":(String)hash.get("start_time_param");
		int totalDuration = 0;
		String start_day_time_param = start_day_param+" "+start_time_param;
		String currentDate = "";
		String endDate = "";
		String dayName = "";
		//int tot_sched_days=0;
		
		ArrayList dateList = null;
		ArrayList dayList = null;
		HashMap schdMap = new HashMap();
		HashMap repeatMap = null;		

		if ((durationType.toUpperCase()).equals("L"))
		{ 
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (365*duration), "d");
				totalDuration =(duration * 12)/Interval_value;
				//tot_sched_days = 365*duration;
			}else{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (30*duration), "d");
				totalDuration =(duration)/Interval_value;	
				//tot_sched_days = 30*duration;
			}
		}else if ((durationType.toUpperCase()).equals("W"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (365*duration), "d");
				totalDuration =(duration * 52)/Interval_value;
				//tot_sched_days = 365*duration;
			}else if((pr_duration_type.toUpperCase()).equals("L"))
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (30*duration), "d");
				totalDuration =(duration * 4)/Interval_value;
				//tot_sched_days = 30*duration;
			}else 
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM",locale, (7*duration), "d");
				totalDuration =(duration)/Interval_value;
				//tot_sched_days = 7*duration;
			}
		}else if ((durationType.toUpperCase()).equals("D"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (duration*365), "d");
				totalDuration =(duration * 365)/Interval_value;
				//tot_sched_days = 365*duration;
			}else if((pr_duration_type.toUpperCase()).equals("L"))
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (duration*30), "d");
				totalDuration =(duration * 30)/Interval_value;	
				//tot_sched_days = 30*duration;
			}else if((pr_duration_type.toUpperCase()).equals("W"))
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, (duration*7), "d");
				totalDuration =(duration * 7)/Interval_value;	
				//tot_sched_days = 7*duration;
			}else 
			{
				endDate = DateUtils.plusDate(start_day_time_param, "DMYHM", locale, duration, "d");
				totalDuration =(duration)/Interval_value;	
				//tot_sched_days = 1*duration;
			}
		}
		endDate = DateUtils.minusDate(endDate, "DMYHM", locale, 1, "m");
		for (int j = 0;j < repeat ; j++)
		{		
			int val = 0;
			dateList = new ArrayList();
			dayList = new ArrayList();
			repeatMap = new HashMap();
			String str = arrList.get(j)==null?"":(String)arrList.get(j);
			if (!str.equals(""))
			{
				val = Integer.parseInt(str);
			}			

			if ((durationType.toUpperCase()).equals("D")){
				if (val >= 1)
					currentDate = DateUtils.plusDate(start_day_param, "DMY", locale, val-1, "d");
				else
					currentDate = DateUtils.plusDate(start_day_param, "DMY", locale, val, "d");
				
			}else{
				currentDate = DateUtils.plusDate(start_day_param, "DMY", locale, val-1, "d");
			}

			String temp_time = timeList.get(j)==null?"":(String)timeList.get(j);
			String current_date_time = currentDate+" "+temp_time;

			if (DateUtils.isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
			{
				dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);
				dateList.add(currentDate);
				dayList.add(dayName);			
			}else{
				if ((durationType.toUpperCase()).equals("D"))
				{
					currentDate = DateUtils.plusDate(start_day_param, "DMY", locale, 1, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);
					dateList.add(currentDate);
					dayList.add(dayName);			
				}				
			}

			/*dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);			

			dateList.add(currentDate);
			dayList.add(dayName);			*/
			for (int i = 0;i<totalDuration;i++ )
			{
				if ((durationType.toUpperCase()).equals("L"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", locale, 30*Interval_value, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);
					
				}else if ((durationType.toUpperCase()).equals("W"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY",locale, 7*Interval_value, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);				
				}else if ((durationType.toUpperCase()).equals("D"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", locale, 1*Interval_value, "d");		
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);				
				}
				current_date_time = currentDate+" "+temp_time;
				//int daysDiff = DateUtils.daysBetween(start_day_time_param, current_date_time, "DMYHM", locale);//Check Style Violation
				if (DateUtils.isAfter(current_date_time,start_day_time_param, "DMYHM", locale) && DateUtils.isBefore(current_date_time, endDate, "DMYHM", locale) )
				{
					dateList.add(currentDate);
					dayList.add(dayName);
				}				
			}
			repeatMap.put("DATES",dateList);
			repeatMap.put("DAYS",dayList);
			schdMap.put(j+1,repeatMap);
		}
		return schdMap;
	}

	public String getmoduleRL(String catalogcode,String categorycode,String ordertypecode,String facility_id) throws Exception
	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String modname="";
		try
		 {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			pstmt.setString(1,(String)catalogcode);
			pstmt.setString(2,(String)categorycode);
			pstmt.setString(3,(String)ordertypecode);
			pstmt.setString(4,(String)facility_id);
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				modname = rs.getString("modname");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}finally
		{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return modname;
	}
	public String getMedAdminStatus(String patientId, String encounterId,String facility_id,String Order_Id,String Order_line_num) throws Exception
	{
			Connection connection 		= null;
			PreparedStatement pstmt = null;			
			ResultSet rset=null;
			String admin_status="";
			
			try
			{
			
				connection		= ConnectionManager.getConnection(properties);
				String sql = (String)OrRepository.getOrKeyValue("SQL_OR_GET_MEDN_ADMIN_STATUS");
				pstmt = connection.prepareStatement(sql);			
				pstmt.setString(1, checkForNull(patientId,""));	
				pstmt.setString(2, checkForNull(encounterId,""));  
				pstmt.setString(3, checkForNull(facility_id,"")); 
				pstmt.setString( 4,checkForNull(Order_Id,""));	
				pstmt.setString( 5,checkForNull(Order_line_num,"")); 				
				rset = pstmt.executeQuery();
				while(rset.next()&&rset != null)
				{
					admin_status= rset.getString("admin_status");	
				}
				
			}
				
			catch( Exception e )
			{

				e.printStackTrace() ;
				
			}
			finally
			{				
				closeResultSet(rset) ;
				closeStatement(pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
				
			}			
		
		return admin_status;
	}

public String getCompRemarksManForCategory(String order_category)
{
		Connection connection 		= null;
		PreparedStatement pstmt = null;			
		ResultSet rset=null;
		String complete_remarks_mand_yn="";
		
		try
		{
		
			connection		= ConnectionManager.getConnection(properties);
			String sql = (String)OrRepository.getOrKeyValue("SQL_OR_GET_COMPLETE_REMARKS_MAND_STATUS");
			pstmt = connection.prepareStatement(sql);			
			pstmt.setString(1, checkForNull(order_category,""));					
			rset = pstmt.executeQuery();
			if(rset.next()&&rset != null)
			{
				complete_remarks_mand_yn= rset.getString("complete_remarks_mand_yn")==null?"N": rset.getString("complete_remarks_mand_yn");	
			}
			closeResultSet(rset) ;
			closeStatement(pstmt ) ;			
		}
			
		catch( Exception e )
		{
			e.printStackTrace() ;			
		}
		finally
		{				
			try
			{
				closeResultSet(rset) ;
				closeStatement(pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);		
			}
			catch (Exception ex)
			{
				ex.printStackTrace() ;			
			}
				
		}			
	
	return complete_remarks_mand_yn;

}

public String getOrderFormatTxt(String	order_id,String order_line_num,String order_category) throws Exception 
{
	Connection connection 		= null;
	ResultSet resultSet 	= null;
	PreparedStatement pstmt 	= null;
	String ORDER_LINE_LABEL_TEXT = "";
	String FIELD_VALUE = "";
	String FIELD_TYPE="";//IN047595
	String ORDER_LINE_DISCR_MSR_UNIT = "";
	if(order_id==null)order_id="";
	if(order_line_num==null)order_line_num="";
	if(order_category==null)order_category="";
	StringBuffer order_format_values = new StringBuffer();
	String format_desc = "";

	try 
	{
		connection	= getConnection();
		String sql = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_VIEW_LINE_FORMAT_TXT");
		pstmt		= connection.prepareStatement(sql);
		pstmt.setString(1, language_id); // pass the language_id
		pstmt.setString(2, order_id); // pass the order_id
		pstmt.setString(3, order_line_num); // pass the order_line_num
		pstmt.setString(4, order_category); // pass the order_category
		resultSet	= pstmt.executeQuery() ;
		if ( resultSet != null )    // Only one record for the formats text
		{
			while(resultSet.next())
			{
				ORDER_LINE_LABEL_TEXT = checkForNull(resultSet.getString( "ORDER_LINE_LABEL_TEXT" ),"")  ;
				FIELD_VALUE = checkForNull(resultSet.getString( "FIELD_VALUE" ),"")  ;
				//IN047595 - Start
				FIELD_TYPE = checkForNull(resultSet.getString( "ORDER_LINE_FIELD_TYPE" ),"")  ;
				if(FIELD_TYPE.equals("D"))
				{
					if (!language_id.equals("en")){
					FIELD_VALUE = com.ehis.util.DateUtils.convertDate(FIELD_VALUE,"DMY","en",language_id);
					}
				}
				else if (FIELD_TYPE.equals("E")) //IN047595.1 - included condition for E
				{
					if (!language_id.equals("en")){
					FIELD_VALUE = com.ehis.util.DateUtils.convertDate(FIELD_VALUE,"DMYHM","en",language_id);
					}				
				}
				//IN047595 - End
				ORDER_LINE_DISCR_MSR_UNIT = checkForNull(resultSet.getString( "ORDER_LINE_DISCR_MSR_UNIT" ),"")  ;
				order_format_values.append (ORDER_LINE_LABEL_TEXT+" : "+FIELD_VALUE+" "+ORDER_LINE_DISCR_MSR_UNIT+", ");
			}
		}	// if there is no record, then also it should return as ''
		if(order_format_values.length()>40)
		{
			format_desc = (order_format_values.substring(0,40));
		}
		else
		{
			format_desc = order_format_values.toString();
		}
	} 
	 catch ( Exception e )	
	{

		e.printStackTrace() ;
		throw e ;
	 } 
	 finally 
	{
		closeResultSet( resultSet);
		closeStatement( pstmt);
		closeConnection(connection);
	}
	if(format_desc == null || format_desc.equals("")) {//added for skr-scf-1723
		format_desc=getMFRfluidRemarks(order_id,order_line_num);
	}
	return format_desc;
 }
public String getMFRfluidRemarks(String orderId,String orderLineNum){//added for skr-scf-1723
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	String fluidRemark="";
	try{
		connection=getConnection();
		pstmt=connection.prepareStatement("SELECT MFR_REMARKS FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
		pstmt.setString(1,orderId);
		pstmt.setString(2,orderLineNum);
		resultSet=pstmt.executeQuery();
		if(resultSet.next()){
			fluidRemark=resultSet.getString("MFR_REMARKS")==null?"":resultSet.getString("MFR_REMARKS");
		}			
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			closeResultSet( resultSet) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		catch(Exception es){
			es.printStackTrace();
		}
	}
	return fluidRemark;
}
 public String getOrderHeaderFormatTxt(String order_id,String order_category) throws Exception 
{
	Connection connection 		= null;
	ResultSet resultSet 	= null;
	PreparedStatement pstmt 	= null;
	String ORDER_LABEL_TEXT = "";
	String FIELD_VALUE = "";
	String ORDER_DISCR_MSR_UNIT = "";
	if(order_id==null)order_id="";
	if(order_category==null)order_category="";
	StringBuffer order_format_values = new StringBuffer();
	String format_desc = "";

	try 
	{
		connection	= getConnection();
		String sql = "SELECT order_label_text,or_get_format_value_desc (performing_appl_id,order_field_mnemonic,order_field_value,?) field_value,order_discr_msr_unit FROM or_order_field_values a, or_order_field b, or_order c WHERE a.order_field_mnemonic = b.field_mnemonic AND a.order_id = c.order_id AND a.order_id = ? AND b.order_category IN (?, 'AL') ORDER BY a.order_seq_num";
		pstmt		= connection.prepareStatement(sql);
		pstmt.setString(1, language_id); // pass the language_id
		pstmt.setString(2, order_id); // pass the order_id
		pstmt.setString(3, order_category); // pass the order_category
		resultSet	= pstmt.executeQuery();
		if ( resultSet != null )    // Only one record for the formats text
		{
			while(resultSet.next())
			{
				ORDER_LABEL_TEXT = checkForNull(resultSet.getString( "ORDER_LABEL_TEXT" ),"")  ;
				FIELD_VALUE = checkForNull(resultSet.getString( "FIELD_VALUE" ),"")  ;
				ORDER_DISCR_MSR_UNIT = checkForNull(resultSet.getString( "ORDER_DISCR_MSR_UNIT" ),"")  ;
				order_format_values.append (ORDER_LABEL_TEXT+" : "+FIELD_VALUE+" "+ORDER_DISCR_MSR_UNIT+", ");
			}
		}	// if there is no record, then also it should return as ''
		if(order_format_values.length()>40)
		{
			format_desc = (order_format_values.substring(0,40));
		}
		else
		{
			format_desc = order_format_values.toString();
		}
	} 
	 catch ( Exception e )	
	{

		e.printStackTrace() ;
		throw e ;
	 } 
	 finally 
	{
		closeResultSet( resultSet);
		closeStatement( pstmt);
		closeConnection(connection);
	}
	return format_desc;
 }

// IN049419 Start.
	public String getOrderFormatAuditTrailYN() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String auditTrailYN = "N" ;

		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_FORMAT_AUDIT_TRAIL") ) ;				

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				auditTrailYN = (String)resultSet.getString("ORD_AUDIT_REQ_YN");
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return auditTrailYN;
	}
// IN049419 End.
	//IN057196 - Start 
		public String getRecordConsetFormWithOrderYN() throws Exception {
			String recordConsentWithOrder = "";
			Connection connection = null;
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
			String selectQuery = "SELECT CNSNT_WITH_ORDER_YN FROM OR_PARAM ";
			try {
				connection = getConnection();
				pStatement = connection.prepareStatement(selectQuery);
					
				resultSet = pStatement.executeQuery();
				while(resultSet.next()){
					recordConsentWithOrder = resultSet.getString( "CNSNT_WITH_ORDER_YN" )  ;
				}
			}
			catch(Exception ex){
				System.err.println("4987. OrAdapter.java ===> " + ex.getMessage());
				ex.printStackTrace();
			} finally {
				if(resultSet != null) resultSet.close();
				if(pStatement != null) pStatement.close();
				if(connection != null) connection.close();
			}
			return recordConsentWithOrder;
		}
	//IN057196 - End
	
	//IN062992, starts
	public void setSiteSpecificYN(String functionId)
	{
		Connection connection	= null ;

		try
		{
			connection = getConnection();
			isSiteSpecificYN = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR", functionId);			
			siteSpecificDtls.put(functionId,isSiteSpecificYN);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeConnection(connection);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
	}
	//IN062992, ends
	
	//IN065324, starts
	public void setSiteSpecific(String functionId)
	{
		Connection connection	= null ;

		try
		{
			connection = getConnection();
			siteSpecificDtls.put(functionId,(eCommon.Common.CommonBean.isSiteSpecific(connection, "OR", functionId)));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeConnection(connection);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
	}

	//IN065324, starts
	public void setSiteSpecificDtls(String functionId)
	{
		siteSpecificDtls.put(functionId,true);
	}
	//IN065324, ends
	//IN066581 Starts
	public String ReportDbDet(String FacilityId) throws Exception {
		String RepDb="";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			String selectQuery1 = "select report_db from sm_facility_param where facility_id = ?  ";
			pStatement = connection.prepareStatement(selectQuery1);
			pStatement.setString(1, FacilityId);
			resultSet = pStatement.executeQuery();
			
			if ( resultSet != null )    // Only one record for the formats text
			{
				if(resultSet.next())
				{
					RepDb=checkForNull(resultSet.getString("report_db"),"");
				}
			}
			if(!RepDb.equals(""))
			{
				RepDb="@"+RepDb;
			}
		}
		catch(Exception ex){
			System.err.println("5864. OrAdapter.java ===> " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pStatement ) ;
			closeConnection(connection);
		}
		return RepDb;
	}
	//IN066581 ends
	//IN064543 Starts
		public ArrayList<String> getCatalogCodeForOrderset(String measure_id) throws Exception{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList collectCatalogCode = new ArrayList<String>();
			try{
				connection			= ConnectionManager.getConnection(properties) ;
					pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_GET_OR_CATALOG_CODE_BY_ORDERSET"));
					pstmt.setString(1, checkForNull(measure_id,""));
					resultSet			= pstmt.executeQuery() ;
					 
					if ( resultSet != null )
					{
						while(resultSet.next()){
							collectCatalogCode.add((String)checkForNull(resultSet.getString( "ORDER_CATALOG_CODE" ),""));
						}
					}
				}catch ( Exception e )	{
						e.printStackTrace() ;
					} finally {
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						if(connection!=null) ConnectionManager.returnConnection(connection, properties);
					}
			return collectCatalogCode;
		}
		
		public ArrayList<String> getCatalogCodeForPanel(String contr_msr_panel_id) throws Exception{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList collectCatalogCode = new ArrayList<String>();
			try{
				connection			= ConnectionManager.getConnection(properties) ;
					pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_GET_OR_CATALOG_CODE_BY_PANEL"));
					pstmt.setString(1, checkForNull(contr_msr_panel_id,""));
					resultSet			= pstmt.executeQuery() ;
					
					if ( resultSet != null )
					{
						while(resultSet.next()){
							collectCatalogCode.add((String)checkForNull(resultSet.getString( "ORDER_CATALOG_CODE" ),""));
						}
					}
				}catch ( Exception e )	{
						e.printStackTrace() ;
					}finally {
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						if(connection!=null) ConnectionManager.returnConnection(connection, properties);
					}
			return collectCatalogCode;
		}
	public LinkedHashMap<String,ArrayList<String>> getCatalogCodeForMsrpanelid(String contr_msr_panel_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		LinkedHashMap<String,ArrayList<String>> catalogCodeCollector = null;
		ArrayList<String> values = null;
		try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_GET_OR_CATALOG_CODE_BY_MSR_PANEL_ID"));
			pstmt.setString(1, checkForNull(contr_msr_panel_id,""));
			resultSet			= pstmt.executeQuery() ;
			
			if ( resultSet != null )
			{
				catalogCodeCollector = new LinkedHashMap<String, ArrayList<String>>();
				while(resultSet.next()){
					values = new ArrayList();
					String DISCR_MSR_ID = (String)checkForNull(resultSet.getString( "discr_msr_id" ),"");
					String SHORT_DESC = (String)checkForNull(resultSet.getString( "SHORT_DESC" ),"");
					String ORDER_CATALOG_CODE = (String)checkForNull(resultSet.getString( "ORDER_CATALOG_CODE" ),"");
					values.add(ORDER_CATALOG_CODE);
					values.add(SHORT_DESC);
					catalogCodeCollector.put(DISCR_MSR_ID,values);
				}
			}
			
		}catch ( Exception e )	{
			e.printStackTrace() ;
		}finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		} 
		return catalogCodeCollector;
	}

	public LinkedHashMap<String,ArrayList<String>> getCatalogCodeForMsrId(String measure_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		LinkedHashMap<String,ArrayList<String>> catalogCodeCollector = null;
		ArrayList<String> values = null;
		try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_GET_OR_CATALOG_CODE_BY_MSR_ID"));
			pstmt.setString(1, checkForNull(measure_id,""));
			resultSet			= pstmt.executeQuery() ;
			
			if ( resultSet != null )
			{
				catalogCodeCollector = new LinkedHashMap<String, ArrayList<String>>();
				while(resultSet.next()){
					values = new ArrayList();
					String DISCR_MSR_ID = (String)checkForNull(resultSet.getString( "DISCR_MSR_ID" ),"");
					String SHORT_DESC = (String)checkForNull(resultSet.getString( "SHORT_DESC" ),"");
					values.add(SHORT_DESC);
					catalogCodeCollector.put(DISCR_MSR_ID,values);
				}
			}
			
		}catch ( Exception e )	{
			e.printStackTrace() ;
		}finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		} 
		return catalogCodeCollector;
	}
	public int getCatalogCodeForPanelCount(String contr_msr_panel_id) throws Exception{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String catalogCount = "";
			int PanelCount = 0;
			try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_GET_COUNT_OR_CATALOG_CODE_BY_PANEL"));
			pstmt.setString(1, checkForNull(contr_msr_panel_id,""));
			resultSet			= pstmt.executeQuery() ;
				while(resultSet.next())
				{
					catalogCount = (String)checkForNull(resultSet.getString( "count" ),"");
					PanelCount = Integer.parseInt(catalogCount);
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
			}finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			} 
			return PanelCount;
		}
	public int getCatalogCodeForOrderSetCount(String measure_id) throws Exception{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String catalogCount = "";
			int OrderSetCount = 0;
			try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_GET_COUNT_OR_CATALOG_CODE_BY_ORDERSET"));
			pstmt.setString(1, checkForNull(measure_id,""));
			resultSet			= pstmt.executeQuery() ;
				while(resultSet.next())
				{
					catalogCount = (String)checkForNull(resultSet.getString( "count" ),"");
					OrderSetCount = Integer.parseInt(catalogCount);
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
			}finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			} 
			return OrderSetCount;
		}

	public LinkedHashMap<String, LinkedHashMap<String,ArrayList>> getInstructions(ArrayList<String> catalogCodes,String catalogNature) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList instrnValues 		= null;
		int catalogCount = catalogCodes.size();
		result = new LinkedHashMap<String, LinkedHashMap<String,ArrayList>>();
		
		try{
			connection			= ConnectionManager.getConnection(properties) ;
					for(int i=0;i<catalogCount;i++){
						LinkedHashMap<String,ArrayList> instructionList = new LinkedHashMap<String,ArrayList>() ;
						instructionList.put("PR",new ArrayList());
						instructionList.put("DR",new ArrayList());
						instrnValues = new ArrayList ();
						pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_INSTRUCTION_TYPE"));
						pstmt.setString(1, checkForNull(catalogCodes.get(i),""));
						resultSet			= pstmt.executeQuery() ;
						String InsType = null;
						while(resultSet.next()){
							InsType = (String)checkForNull(resultSet.getString( "INSTRN_CONTENT_TYPE" ),"")  ;
						}
						if("T".equals(InsType))	
						{	
							pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INSTRUCTION_TXT"));
							pstmt.setString(1, checkForNull(catalogCodes.get(i),""));
							resultSet			= pstmt.executeQuery() ;
							if ( resultSet != null )
							{
								String insName = null;
								String insTxt = null;
								String sex	   = null;
								String minYears= null;
								String minMonths= null;
								String minDays= null;
								String maxYears= null;
								String maxMonths= null;
								String maxDays= null;
								String calcMinAgeInDays= null;
								String calcMaxAgeInDays= null;
								String instrnMultiple[]=null;
								int multCount = 0;
								String instrnId = null;
								while(resultSet.next())
								{
									instrnValues = new ArrayList ();
									insName 	  = new String();
									insTxt 	  = new String();
									insName = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_IND" ),"")  ;
									if("IM".equals(insName)){
										multCount++;
										instrnId = "IM"+multCount;
										instrnMultiple = new String[9];
										sex			 = (String)checkForNull(resultSet.getString( "SEX_SPEC_IND" ),"")  ;
										//IN068294 start
										if("M".equals(sex)){
											sex = "Male";
										}else if("F".equals(sex)){
											sex = "Female";
										}else if("N".equals(sex)){
											sex = "Both";
										}
										//IN068294 end
										minYears	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_YRS" ),"")  ;
										minMonths	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_MTHS" ),"")  ;//IN068294
										minDays		 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_DAYS" ),"")  ;
										maxYears	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_YRS" ),"")  ;
										maxMonths	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_MTHS" ),"")  ;
										maxDays	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_DAYS" ),"")  ;
										calcMinAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MIN_AGE_IN_DAYS" ),"")  ;
										calcMaxAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MAX_AGE_IN_DAYS" ),"")  ;
										insTxt = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_TXT" ),"")  ;
										instrnMultiple[0] = instrnId;
										instrnMultiple[1] = sex;
										instrnMultiple[2] = minYears;
										instrnMultiple[3] = minMonths;//IN068294
										instrnMultiple[4] = minDays;
										instrnMultiple[5] = maxYears;
										instrnMultiple[6] = maxMonths;
										instrnMultiple[7] = maxDays;
										instrnMultiple[8] = insTxt;
										if(instructionList.containsKey(insName))
										{
											instructionList.get(insName).add(instrnMultiple);										
										}
										else
										{
											instrnValues.add(instrnMultiple);
											instructionList.put(insName,instrnValues) ;
										}
										
									}else{
										insTxt = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_TXT" ),"")  ;
										instrnValues = new ArrayList ();
										instrnValues.add(insTxt);
										instructionList.put(insName,instrnValues) ;
									}
								}
									instrnValues = new ArrayList ();
									instrnValues.add(InsType);
									instructionList.put("InsType",instrnValues);
									result.put(catalogCodes.get(i), instructionList);
							}
						}else if("E".equals(InsType)){
							pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INSTRUCTION_EDITOR"));
							pstmt.setString(1, checkForNull(catalogCodes.get(i),""));
							resultSet			= pstmt.executeQuery() ;
							if ( resultSet != null )
							{
								String insName = null;
								String insTxt  = null;
								String sex	   = null;
								String minYears= null;
								String minMonths= null;
								String minDays= null;
								String maxYears= null;
								String maxMonths= null;
								String maxDays= null;
								String calcMinAgeInDays= null;
								String calcMaxAgeInDays= null;
								String instrnMultiple[]=null;
								int multCount = 0;
								String instrnId = null;
								
								while(resultSet.next())
								{	
									instrnValues = new ArrayList ();
									StringBuffer xmlContent = new StringBuffer();
									insName 	  = new String();
									insTxt 	  = new String();
									insName = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_IND" ),"")  ;
									if("IM".equals(insName)){
										multCount++;
										instrnId = "IM"+multCount;
										instrnMultiple = new String[9];
										sex			 = (String)checkForNull(resultSet.getString( "SEX_SPEC_IND" ),"")  ;
										//IN068294 start
										if("M".equals(sex)){
											sex = "Male";
										}else if("F".equals(sex)){
											sex = "Female";
										}else if("N".equals(sex)){
											sex = "Both";
										}
										//IN068294 end
										minYears	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_YRS" ),"")  ;
										minMonths	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_MTHS" ),"")  ;//IN068294
										minDays		 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_DAYS" ),"")  ;
										maxYears	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_YRS" ),"")  ;
										maxMonths	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_MTHS" ),"")  ;
										maxDays	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_DAYS" ),"")  ;
										calcMinAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MIN_AGE_IN_DAYS" ),"")  ;
										calcMaxAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MAX_AGE_IN_DAYS" ),"")  ;
										Clob tmplFormat = (Clob) resultSet.getClob("PAT_PREPS_OR_INSTRNS_FREE_FMT");  ;
										if(tmplFormat !=null)
										{
											java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
											String line = null;

											while((line=r.readLine()) != null) 
											{
												xmlContent.append(line);
											}
										}
										insTxt = xmlContent.toString();
										instrnMultiple[0] = instrnId;
										instrnMultiple[1] = sex;
										instrnMultiple[2] = minYears;
										instrnMultiple[3] = minMonths;//IN068294
										instrnMultiple[4] = minDays;
										instrnMultiple[5] = maxYears;
										instrnMultiple[6] = maxMonths;
										instrnMultiple[7] = maxDays;
										instrnMultiple[8] = insTxt;
										if(instructionList.containsKey(insName))
										{
											instructionList.get(insName).add(instrnMultiple);										
										}
										else
										{
											instrnValues.add(instrnMultiple);
											instructionList.put(insName,instrnValues) ;
										}
										
									}else{
										Clob tmplFormat = (Clob) resultSet.getClob("PAT_PREPS_OR_INSTRNS_FREE_FMT");  ;
										if(tmplFormat !=null)
										{
											java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
											String line = null;

											while((line=r.readLine()) != null) 
											{
												xmlContent.append(line);
											}
										}
										
										insTxt = xmlContent.toString();
										instrnValues = new ArrayList ();
										instrnValues.add(insTxt);
										instructionList.put(insName,instrnValues) ;
									}
								}
								instrnValues = new ArrayList ();
								instrnValues.add(InsType);
								instructionList.put("InsType",instrnValues);
								result.put(catalogCodes.get(i), instructionList);
								}
							}
						}
					}
					catch ( Exception e )	{
							e.printStackTrace() ;
						} finally {
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
							if(connection!=null) ConnectionManager.returnConnection(connection, properties);
						}
					return result;
					}
	public LinkedHashMap<String, LinkedHashMap<String,ArrayList>> getInstructions(String catalogCode,String catalogNature,String InsType) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		LinkedHashMap<String,ArrayList> instructionList = new LinkedHashMap<String,ArrayList>() ;
		instructionList.put("PR",new ArrayList());
		instructionList.put("DR",new ArrayList());
		result = new LinkedHashMap<String, LinkedHashMap<String,ArrayList>>();
		ArrayList instrnValues 		= null;
		try{
			connection			= ConnectionManager.getConnection(properties) ;
				if("T".equalsIgnoreCase(InsType)){
					pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INSTRUCTION_TXT"));
					pstmt.setString(1, checkForNull(catalogCode,""));
					resultSet			= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String insName = null;
						String insTxt = null;
						String sex	   = null;
						String minYears= null;
						String minMonths= null;
						String minDays= null;
						String maxYears= null;
						String maxMonths= null;
						String maxDays= null;
						String calcMinAgeInDays= null;
						String calcMaxAgeInDays= null;
						String instrnMultiple[]=null;
						int multCount = 0;
						String instrnId = null;
						while(resultSet.next())
						{
							instrnValues = new ArrayList ();
							insName 	  = new String();
							insTxt 	  = new String();
							insName = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_IND" ),"")  ;
							if("IM".equals(insName)){
								multCount++;
								instrnId = "IM"+multCount;
								instrnMultiple = new String[9];
								sex			 = (String)checkForNull(resultSet.getString( "SEX_SPEC_IND" ),"")  ;
								//IN068294 start
								if("M".equals(sex)){
									sex = "Male";
								}else if("F".equals(sex)){
									sex = "Female";
								}else if("N".equals(sex)){
									sex = "Both";
								}
								//IN068294 end
								minYears	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_YRS" ),"")  ;
								minMonths	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_MTHS" ),"")  ;//IN068294
								minDays		 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_DAYS" ),"")  ;
								maxYears	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_YRS" ),"")  ;
								maxMonths	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_MTHS" ),"")  ;
								maxDays	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_DAYS" ),"")  ;
								calcMinAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MIN_AGE_IN_DAYS" ),"")  ;
								calcMaxAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MAX_AGE_IN_DAYS" ),"")  ;
								insTxt = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_TXT" ),"")  ;
								instrnMultiple[0] = instrnId;
								instrnMultiple[1] = sex;
								instrnMultiple[2] = minYears;
								instrnMultiple[3] = minMonths;//IN068294
								instrnMultiple[4] = minDays;
								instrnMultiple[5] = maxYears;
								instrnMultiple[6] = maxMonths;
								instrnMultiple[7] = maxDays;
								instrnMultiple[8] = insTxt;
								if(instructionList.containsKey(insName))
								{
									instructionList.get(insName).add(instrnMultiple);										
								}
								else
								{
									instrnValues.add(instrnMultiple);
									instructionList.put(insName,instrnValues) ;
								}
								
							}else{
								insTxt = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_TXT" ),"")  ;
								instrnValues = new ArrayList ();
								instrnValues.add(insTxt);
								instructionList.put(insName,instrnValues) ;
							}
						}
							instrnValues = new ArrayList ();
							instrnValues.add(InsType);
							instructionList.put("InsType",instrnValues);
							result.put(catalogCode, instructionList);
					}
				}else if("E".equalsIgnoreCase(InsType)){

					pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INSTRUCTION_EDITOR"));
					pstmt.setString(1, checkForNull(catalogCode,""));
					resultSet			= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String insName = null;
						String insTxt  = null;
						String sex	   = null;
						String minYears= null;
						String minMonths= null;
						String minDays= null;
						String maxYears= null;
						String maxMonths= null;
						String maxDays= null;
						String calcMinAgeInDays= null;
						String calcMaxAgeInDays= null;
						String instrnMultiple[]=null;
						int multCount = 0;
						String instrnId = null;
						
						while(resultSet.next())
						{	
							instrnValues = new ArrayList ();
							StringBuffer xmlContent = new StringBuffer();
							insName 	  = new String();
							insTxt 	  = new String();
							insName = (String)checkForNull(resultSet.getString( "PAT_PREPS_OR_INSTRNS_IND" ),"")  ;
							if("IM".equals(insName)){
								multCount++;
								instrnId = "IM"+multCount;
								instrnMultiple = new String[9];
								sex			 = (String)checkForNull(resultSet.getString( "SEX_SPEC_IND" ),"")  ;
								//IN068294 start
								if("M".equals(sex)){
									sex = "Male";
								}else if("F".equals(sex)){
									sex = "Female";
								}else if("N".equals(sex)){
									sex = "Both";
								}
								//IN068294 end
								minYears	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_YRS" ),"")  ;
								minMonths	 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_MTHS" ),"")  ;//IN068294
								minDays		 = (String)checkForNull(resultSet.getString( "MIN_AGE_IN_DAYS" ),"")  ;
								maxYears	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_YRS" ),"")  ;
								maxMonths	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_MTHS" ),"")  ;
								maxDays	 = (String)checkForNull(resultSet.getString( "MAX_AGE_IN_DAYS" ),"")  ;
								calcMinAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MIN_AGE_IN_DAYS" ),"")  ;
								calcMaxAgeInDays	 = (String)checkForNull(resultSet.getString( "CALC_MAX_AGE_IN_DAYS" ),"")  ;
								Clob tmplFormat = (Clob) resultSet.getClob("PAT_PREPS_OR_INSTRNS_FREE_FMT");  ;
								if(tmplFormat !=null)
								{
									java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
									String line = null;

									while((line=r.readLine()) != null) 
									{
										xmlContent.append(line);
									}
								}
								insTxt = xmlContent.toString();
								instrnMultiple[0] = instrnId;
								instrnMultiple[1] = sex;
								instrnMultiple[2] = minYears;
								instrnMultiple[3] = minMonths;//IN068294
								instrnMultiple[4] = minDays;
								instrnMultiple[5] = maxYears;
								instrnMultiple[6] = maxMonths;
								instrnMultiple[7] = maxDays;
								instrnMultiple[8] = insTxt;
								if(instructionList.containsKey(insName))
								{
									instructionList.get(insName).add(instrnMultiple);										
								}
								else
								{
									instrnValues.add(instrnMultiple);
									instructionList.put(insName,instrnValues) ;
								}
								
							}else{
								Clob tmplFormat = (Clob) resultSet.getClob("PAT_PREPS_OR_INSTRNS_FREE_FMT");  ;
								if(tmplFormat !=null)
								{
									java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
									String line = null;

									while((line=r.readLine()) != null) 
									{
										xmlContent.append(line);
									}
								}
								
								insTxt = xmlContent.toString();
								instrnValues = new ArrayList ();
								instrnValues.add(insTxt);
								instructionList.put(insName,instrnValues) ;
							}
						}
						instrnValues = new ArrayList ();
						instrnValues.add(InsType);
						instructionList.put("InsType",instrnValues);
						result.put(catalogCode, instructionList);
						}
					
				}
				
		}catch ( Exception e )	{
			e.printStackTrace() ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		System.out.println("result---->"+result);
		return result;
	}
	public LinkedHashMap<String, LinkedHashMap<String,ArrayList>> getTextInstruction(){
					return result;
		} 
	//IN064543 Ends

	//IN068673, starts
	public String getOrParamByColumnName(String columnName) throws Exception {
		String columnValue = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "SELECT " + columnName + " FROM OR_PARAM ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(selectQuery);
				
			rs = pstmt.executeQuery();
			while(rs.next()){
				columnValue = rs.getString(columnName)  ;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		return columnValue;
	}
	//IN068673, ends
		//IN068370,IN068373, starts
		public ArrayList<String[]> getFacilitiesForMapping()
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList<String[]> facilities = new ArrayList();
			String sql = "select facility_name, facility_id  from sm_facility_param order by 1";

	        try {
				connection = getConnection() ;	
				
				pstmt = connection.prepareStatement(sql);

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String records[] = new String[2];
					records[0]=resultSet.getString( "facility_name" );
					records[1]=resultSet.getString( "facility_id" );
					facilities.add(records);
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;			
			} finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection) ;
				} catch (Exception e) {
					e.printStackTrace() ;
				}
			}

			return facilities;		
		}	

		public void setMappedFacilities(String fac_ids)
		{
				
		}
		
		public ArrayList<String> getMappedFacilities()
		{
			return null;
		}
		
		public String getSiteSpecificParams(String functionId, String loginfacId)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList<String[]> facilities = new ArrayList();
			String global_fac_yn = "N";
			String sql = "select 'Y' global_fac_yn from sm_function_control where FUNCTIONALITY_ID = ? and key_1 = 'GLOBAL_FAC_ID' and value_1 = ?";
			
	        try {
				connection = getConnection() ;	
				
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, functionId);
				pstmt.setString(2, loginfacId);

				resultSet = pstmt.executeQuery() ;
				while(resultSet.next())
					global_fac_yn = resultSet.getString("global_fac_yn");
				
			} catch ( Exception e )	{
				e.printStackTrace() ;			
			} finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection) ;
				} catch (Exception e) {
					e.printStackTrace() ;
				}
			}

			return global_fac_yn;
		}
		//IN068370,IN068373, ends
		
		//IN069027 Start.
	public String allowedNewOrdersYN(String patient_id,String encounter_id,String patient_class,String factility_id,String OrderCatagory){
		Connection connection 		= null;
		String allowedOrdersYN = "Y";	
		try 
		{
			boolean siteSpecific =isSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");
			if(siteSpecific){
				connection	= getConnection();
				allowedOrdersYN=(String)allowedNewOrders(connection,patient_id,encounter_id,patient_class,factility_id);
				if("Y".equals(allowedOrdersYN))
				allowedOrdersYN=(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,OrderCatagory);
			}
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
        		if ( connection != null ) 
        			connection.close();
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return allowedOrdersYN;
	}	
	public HashMap allowedNewOrders(String patient_id,String encounter_id,String patient_class,String factility_id,String function_from){
		Connection connection 		= null;
		HashMap allowedNewOrderMap = new HashMap();		
		try 
		{
			boolean siteSpecific =isSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");
			if(siteSpecific && !function_from.equals("MULTI_PATIENT_ORDERS") && !function_from.equals("EXTERNAL_ORDER") && !function_from.equals("AMEND_ORDER")){
				connection	= getConnection();
				allowedNewOrderMap.put("dxChkBfrPlaceOrderSpec",(String)allowedNewOrders(connection,patient_id,encounter_id,patient_class,factility_id));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderMI",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"MI"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderOT",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"OT"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderCN",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"CN"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderLB",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"LB"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderTR",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"TR"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderPC",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"PC"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderPH",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"PH"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderNC",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"NC"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderDS",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"DX"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderRX",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"RX"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderRD",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"RD"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderCS",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"CS"));
				allowedNewOrderMap.put("dxChkBfrPlaceOrderOH",(String)allowedNewOrdersWithModule(connection,patient_id,encounter_id,factility_id,"OH"));//IN072036
			
			}else{
				allowedNewOrderMap.put("dxChkBfrPlaceOrderSpec","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderMI","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderOT","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderCN","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderLB","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderTR","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderPC","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderPH","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderNC","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderDS","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderRX","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderRD","Y");
				allowedNewOrderMap.put("dxChkBfrPlaceOrderCS","Y");			
				allowedNewOrderMap.put("dxChkBfrPlaceOrderOH","Y");//IN072036
			}
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
        		if ( connection != null ) 
        			connection.close();
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return allowedNewOrderMap;
	}	
	
	public String allowedNewOrders(Connection connection,String patient_id,String encounter_id,String patient_class,String factility_id){
		
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String allowedOrdersYN = "Y";		
		String  primaryDiagnosisYN="N"; //6868
		String primaryDiagnosisCondition=""; //6868
		try 
		{					
			pstmt		= connection.prepareStatement("SELECT DISTINCT TERM_SET_ID FROM ( SELECT TERM_SET_ID FROM OR_MDS_DIAGNOSIS_MAND WHERE MINUMUM_DATA_TYPE=? AND APPLIED_CODE=? UNION SELECT TERM_SET_ID FROM OR_MDS_DIAGNOSIS_MAND WHERE MINUMUM_DATA_TYPE=? AND APPLIED_CODE=(SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE ENCOUNTER_ID=? AND FACILITY_ID=?) )"); 
			pstmt.setString(1,"P");
			pstmt.setString(2,patient_class);
			pstmt.setString(3,"S");
			pstmt.setString(4,encounter_id);
			pstmt.setString(5,factility_id);
			resultSet	= pstmt.executeQuery() ;
			ArrayList resultArray = new ArrayList();
			if ( resultSet != null ) 
			{
				while(resultSet.next())
				{
					resultArray.add((String)resultSet.getString( "TERM_SET_ID" ));
				}
			}
			if ( pstmt != null ) 
				pstmt.close();
			if ( resultSet != null ) 
				resultSet.close();
			
			if(resultArray.size()>0){
				for(int i=0;i<resultArray.size();i++){
					//6868 Start
					pstmt		= connection.prepareStatement("SELECT DISTINCT 'Y' PRIMARY_DIAGNOSIS FROM OR_MDS_DIAGNOSIS_MAND_HDR WHERE TERM_SET_ID=? AND PRIMARY_DIAGNOSIS_YN='Y'");
					pstmt.setString(1,(String)resultArray.get(i));
					resultSet	= pstmt.executeQuery(); 
					if ( resultSet != null ) 
					{
						while(resultSet.next())
						{
							primaryDiagnosisYN=(String)resultSet.getString( "PRIMARY_DIAGNOSIS" );
						}
					}
					if ( pstmt != null ) 
						pstmt.close();
					if ( resultSet != null ) 
						resultSet.close();
					
					if("Y".equals(primaryDiagnosisYN))
						primaryDiagnosisCondition="AND DIAG_CLASS_CODE IN (SELECT DIAG_CLASS_CODE FROM MR_DIAG_CLASS WHERE DIAG_CLASS_TYPE='PD')";
					
					pstmt		= connection.prepareStatement("SELECT COUNT(*) TOTALCOUNT FROM PR_DIAGNOSIS_ENC_DTL WHERE STATUS!='E' "+primaryDiagnosisCondition+" AND PATIENT_ID=? AND ENCOUNTER_ID=? AND TERM_SET_ID=? AND FACILITY_ID=?");
					//pstmt		= connection.prepareStatement("SELECT COUNT(*) TOTALCOUNT FROM PR_DIAGNOSIS_ENC_DTL WHERE STATUS!='E'  AND PATIENT_ID=? AND ENCOUNTER_ID=? AND TERM_SET_ID=? AND FACILITY_ID=?");
					//6868 end.
					pstmt.setString(1,patient_id);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,(String)resultArray.get(i));
					pstmt.setString(4,factility_id);
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null && resultSet.next()) 
					{
						int totalCount = resultSet.getInt("TOTALCOUNT");							
						if(totalCount==0){
							allowedOrdersYN = "N";
							break;
						}
					}
				}
			}
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
				if ( pstmt != null ) 
					pstmt.close();
        		if ( resultSet != null ) 
        			resultSet.close();        		
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return allowedOrdersYN;
	}
	public String allowedNewOrdersWithModule(Connection connection,String patient_id,String encounter_id,String factility_id,String orderCatagory){
		
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String allowedOrdersYN = "Y";
		String  primaryDiagnosisYN="N"; //6868
		String primaryDiagnosisCondition=""; //6868
		try 
		{						
			pstmt		= connection.prepareStatement("SELECT DISTINCT TERM_SET_ID FROM OR_MDS_DIAGNOSIS_MAND WHERE MINUMUM_DATA_TYPE=? AND APPLIED_CODE=?"); 
			pstmt.setString(1,"O");
			pstmt.setString(2,orderCatagory);
			
			resultSet	= pstmt.executeQuery() ;
			ArrayList resultArray = new ArrayList();
			if ( resultSet != null ) 
			{
				while(resultSet.next())
				{
					resultArray.add((String)resultSet.getString( "TERM_SET_ID" ));
				}
			}
			if ( pstmt != null ) 
				pstmt.close();
			if ( resultSet != null ) 
				resultSet.close();
			
			if(resultArray.size()>0){
				for(int i=0;i<resultArray.size();i++){
					
					//6868 Start
					pstmt		= connection.prepareStatement("SELECT DISTINCT 'Y' PRIMARY_DIAGNOSIS FROM OR_MDS_DIAGNOSIS_MAND_HDR WHERE TERM_SET_ID=? AND PRIMARY_DIAGNOSIS_YN='Y'");
					pstmt.setString(1,(String)resultArray.get(i));
					resultSet	= pstmt.executeQuery(); 
					if ( resultSet != null ) 
					{
						while(resultSet.next())
						{
							primaryDiagnosisYN=(String)resultSet.getString( "PRIMARY_DIAGNOSIS" );
						}
					}
					if ( pstmt != null ) 
						pstmt.close();
					if ( resultSet != null ) 
						resultSet.close();
					if("Y".equals(primaryDiagnosisYN))
						primaryDiagnosisCondition="AND DIAG_CLASS_CODE IN (SELECT DIAG_CLASS_CODE FROM MR_DIAG_CLASS WHERE DIAG_CLASS_TYPE='PD')";
					
					pstmt		= connection.prepareStatement("SELECT COUNT(*) TOTALCOUNT FROM PR_DIAGNOSIS_ENC_DTL WHERE STATUS!='E' "+primaryDiagnosisCondition+" AND PATIENT_ID=? AND ENCOUNTER_ID=? AND TERM_SET_ID=? AND FACILITY_ID=?");
					//pstmt		= connection.prepareStatement("SELECT COUNT(*) TOTALCOUNT FROM PR_DIAGNOSIS_ENC_DTL WHERE STATUS!='E' AND PATIENT_ID=? AND ENCOUNTER_ID=? AND TERM_SET_ID=? AND FACILITY_ID=?");
					//6868 end.
										
					pstmt.setString(1,patient_id);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,(String)resultArray.get(i));
					pstmt.setString(4,factility_id);
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null && resultSet.next()) 
					{
						int totalCount = resultSet.getInt("TOTALCOUNT");							
						if(totalCount==0){
							allowedOrdersYN = "N";
							break;
						}
					}
				}
			}
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
				if ( pstmt != null ) 
					pstmt.close();
        		if ( resultSet != null ) 
        			resultSet.close();
        		
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return allowedOrdersYN;
	}
	//IN069027 End.
	//44884 Start.
	public String getPractitionerRelation(String practitioner_id,String  patient_id)
    {  
        Connection connection         = null;
        CallableStatement callStatus = null;
        String practitionerRelation ="N";
		
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
				
        try
        {
            connection = ConnectionManager.getConnection();
			/*
            callStatus=connection.prepareCall("{call  mp_validate_emp_service_no(?,?,?) }"); 
            callStatus.setString(1, practitioner_id );
            callStatus.setString(2, patient_id); 
            callStatus.registerOutParameter(3,java.sql.Types.VARCHAR);
            callStatus.executeUpdate();
            practitionerRelation=(String)callStatus.getString(3);
            if(callStatus != null) 
                    callStatus.close();
			*/
			pstmt		= connection.prepareStatement("SELECT mp_validate_emp_service_no(?,?) PRACTITIONER_RELATION FROM DUAL"); 		
			pstmt.setString(1, practitioner_id );
			pstmt.setString(2, patient_id); 
			resultSet	= pstmt.executeQuery() ;
			
			if ( resultSet != null ) 
			{
				while(resultSet.next())
				{
					practitionerRelation=resultSet.getString( "PRACTITIONER_RELATION" )==null?"N":(String)resultSet.getString( "PRACTITIONER_RELATION" );
					System.out.println("-------2921--------practitionerRelation------>"+practitionerRelation);
				}
			}
			if ( pstmt != null ) 
				pstmt.close();
			if ( resultSet != null ) 
				resultSet.close();	
				
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                ConnectionManager.returnConnection(connection);        
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return practitionerRelation;
    }
	public HashMap restrictedNewOrdersSF(String practitionerId,String practitionerRelation,String function_from){
		Connection connection 		= null;
		HashMap restrictedNewOrdersSF = new HashMap();		
		try 
		{
			
			if(!"N".equals(practitionerRelation) && !function_from.equals("MULTI_PATIENT_ORDERS")  && !function_from.equals("AMEND_ORDER")){
				connection	= getConnection();
				
				String sql ="SELECT   B.ORDER_CATEGORY,NVL (A.REST_ORDER_SELF_YN, 'N') REST_ORDER_SELF_YN,NVL (A.REST_ORDER_FAMILY_YN, 'N') REST_ORDER_FAMILY_YN  FROM OR_ORDER_REST_SLF_FAMI_MEMB A RIGHT OUTER JOIN OR_ORDER_CATEGORY B ON A.ORDER_CATEGORY = B.ORDER_CATEGORY";
				
				ResultSet resultSet 	= null;
				PreparedStatement pstmt 	= null;				
				try 
				{						
					pstmt		= connection.prepareStatement(sql); 
					
					resultSet	= pstmt.executeQuery() ;
					ArrayList resultArray = new ArrayList();
					if ( resultSet != null ) 
					{
						while(resultSet.next())
						{
							restrictedNewOrdersSF.put("restBfrPlaceOrderS"+(String)resultSet.getString( "ORDER_CATEGORY" ),(String)resultSet.getString( "REST_ORDER_SELF_YN" ));
							restrictedNewOrdersSF.put("restBfrPlaceOrderF"+(String)resultSet.getString( "ORDER_CATEGORY" ),(String)resultSet.getString( "REST_ORDER_FAMILY_YN" ));
						}
					}
					if ( pstmt != null ) 
						pstmt.close();
					if ( resultSet != null ) 
						resultSet.close();					
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try{
						if ( pstmt != null ) 
							pstmt.close();
						if ( resultSet != null ) 
							resultSet.close();
						
					}catch(Exception es){
						es.printStackTrace();
					}
				}				
			
			}else{
				
				restrictedNewOrdersSF.put("restBfrPlaceOrderSMI","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSOT","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSCN","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSLB","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSTR","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSPC","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSPH","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSNC","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSDS","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSRX","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSRD","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderSCS","N");			
				restrictedNewOrdersSF.put("restBfrPlaceOrderSOH","N");
				
				restrictedNewOrdersSF.put("restBfrPlaceOrderFMI","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFOT","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFCN","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFLB","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFTR","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFPC","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFPH","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFNC","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFDS","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFRX","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFRD","N");
				restrictedNewOrdersSF.put("restBfrPlaceOrderFCS","N");			
				restrictedNewOrdersSF.put("restBfrPlaceOrderFOH","N");
			}
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
        		if ( connection != null ) 
        			connection.close();
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return restrictedNewOrdersSF;
	}
	//44884 End.
}
