/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH.Common ;

import eCommon.Common.* ;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;

public abstract class OHAdapter extends CommonAdapter implements Serializable {
	public boolean flag=true;
	public OHAdapter() {
		super( CommonRepository.getCommonKeyValue( "ID_OH" )  ) ;
	}
	// To set the Mode for the Local EJB or Remote EJB
	public void setLocalEJB(boolean flag){
		this.flag=flag;
	}

	// To get the Mode for the Local EJB or Remote EJB
	public boolean getLocalEJB(){
		return flag;
	}

	 // To get the Patient Id Length	
	 public  int getPatientIdLength()throws Exception{
		int pat_length 				= 0 ;
		Connection connection		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		try {
				connection = getConnection() ;
				pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_PATIENT_ID_LENGTH") ) ;
				resultSet			= pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ){
					pat_length		= resultSet.getInt( "patient_id_length" )  ;
				}
			} catch ( Exception e )	{
			System.err.println( "Error loading values from database PatientId Length"+e ) ;
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
				pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_PATIENT_ID_LENGTH") ) ;
				resultSet			= pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ){
					pat_length		= resultSet.getInt( "patient_id_length" )  ;
				}
			} catch ( Exception e )	{
			System.err.println( "Error loading values from database PatientId Length -- properties"+e ) ;
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
				pstmt					= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
				resultSet				= pstmt.executeQuery() ;

				if( resultSet != null && resultSet.next() ) {
					currentDate.add(resultSet.getString("sys_date"))  ;
					currentDate.add(resultSet.getString("last_week_without_date"))  ;
					currentDate.add(resultSet.getString("sys_date_time"))  ;
					currentDate.add(resultSet.getString("next_week_without_date"))  ;
					currentDate.add(resultSet.getString("last_month_date"))  ;
					currentDate.add(resultSet.getString("sys_time_sec"))  ;
				}
			} catch ( Exception e )	{
			System.err.println( "Error loading values from database getSysDateTime-- properties" ) ;
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
			pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
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
			System.err.println( "Getting Module ID"+e ) ;
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
				pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
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
				System.err.println( "Getting Module ID SM_MODULES_FACILITY"+e ) ;
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
			pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
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
			System.err.println( "Getting Module ID -- properties"+e ) ;
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
 				pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
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
				System.err.println( "Getting Module ID SM_MODULES_FACILITY -- properties"+e ) ;
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
			pstmt				= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MENU") ) ;
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
			System.err.println( "Error loading values Menu"+e) ;
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
	public ArrayList getBloodTransfusion(String patient_id, Properties properties) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
         	ArrayList BloodTransfusion  = new ArrayList() ;
			try{
					connection		= ConnectionManager.getConnection(properties) ;
					pstmt			= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BLOOD_TRANSFUSION_DETAILS") ) ;
					pstmt.setString(1, checkForNull( patient_id,""));
					resultSet	= pstmt.executeQuery() ;
					ArrayList Blood = new ArrayList();	//Common-ICN-0044
					while(resultSet!= null && resultSet.next())
					{
						//ArrayList Blood = new ArrayList();
						Blood.add( resultSet.getString( "event_desc" )) ;
						Blood.add( resultSet.getString( "result_str" )) ;
						BloodTransfusion.add(Blood);
					}
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating Blood Transfusion" +e) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
				}
				return BloodTransfusion;
	}	 // End of the getBloodTransfusion


/* To populate the Order CAtegorys ,except CS */

	public ArrayList  getOrderCategoryWithoutCareSet(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCategory		= new ArrayList();   
		try {

				connection		= ConnectionManager.getConnection(properties) ;														 
 				pstmt			= connection.prepareStatement(OHRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
				pstmt.setString( 1, language_id);

				resultSet		= pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCategory.add(record) ;
				}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
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
				pstmt		= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CONSENT_FORMAT_TEMPLATE_SELECT") ) ;
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
			System.err.println( "Error loading values from database getTemplateValues"+e.toString() ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return TemplateValues;
	}


	// Method is used in Consent/REfusal Orders(TRansaction) to replace the mnenominc details
	public String getMnemonicDetails(String pat_id, String facility_id, String encntr_id, String ord_id,String editor_type, String editor_template) throws Exception {
		Connection connection 				= null;
		PreparedStatement pstmt_template	= null;
		ResultSet resultSet_template 		= null;
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

		StringTokenizer stCatalog			= null;
		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
 
		if(editor_type==null) editor_type	= ""; // E --> For editor or P --> For Plain

		try {
				// if consent_format is for editor, then fire the queries to take the patient_details, order details, and encounter details
				if(editor_template!=null && !editor_template.equals("") && editor_type.equals("E")) {
					connection	= getConnection() ;
					pstmt_template = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_PATIENT_TEMPLATE_SELECT") ) ;
					pstmt_template.setString( 1, pat_id);
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
							facility_name		= checkForNull(resultSet_template.getString( "facility_name" )) ;
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
							national_id_no					= checkForNull(resultSet_template.getString( "national_id_no" ))  ;
					}
					// close the statements
					closeResultSet( resultSet_template ) ;
					closeStatement( pstmt_template ) ;

					// For the Encounter Info Details
					pstmt_template = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_ENCOUNTER_TEMPLATE_SELECT") ) ;
					pstmt_template.setString( 1, facility_id);
					pstmt_template.setString( 2, encntr_id);
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
					pstmt_template = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_ORDER_TEMPLATE_SELECT") ) ;
					pstmt_template.setString( 1, language_id);
					pstmt_template.setString( 2, language_id);
					pstmt_template.setString( 3, language_id);
					pstmt_template.setString( 4, language_id);
					pstmt_template.setString( 5, language_id);
					pstmt_template.setString( 6, ord_id);
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
					/** checking for the template **/

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
								pstmt_template = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_AGE_GROUP_SELECT") ) ;
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
					
						if(editor_template.indexOf("~PATIENT_ID`")!=-1){
							editor_template	= editor_template.replaceAll("~PATIENT_ID`",patient_id);				
						} 
						if(editor_template.indexOf("~REGN_DATE`")!=-1){
							editor_template	= editor_template.replaceAll("~REGN_DATE`",regn_date);				
						} 
						if(editor_template.indexOf("~PATIENT_NAME`")!=-1){
							editor_template	= editor_template.replaceAll("~PATIENT_NAME`",patient_name);			
						} 
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
							editor_template	= editor_template.replaceAll("~RESIDENTAIL_ADDRESS`",residentail_address);	  
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

						// Personal Info Ends

						// Encounter Info Starts
						if(editor_template.indexOf("~ENCOUNTER_ID`")!=-1){  
							editor_template	= editor_template.replaceAll("~ENCOUNTER_ID`",encounter_id);	 
						}
						if(editor_template.indexOf("~CURRENT_LOCATION`")!=-1){
							editor_template	= editor_template.replaceAll("~CURRENT_LOCATION`",current_location);	
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
							editor_template	= editor_template.replaceAll("~ATTENDING_PRACTITIONER`",attending_practitioner);	
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
							editor_template	= editor_template.replaceAll("~ORDERING_LOCATION`",ordering_location);
						}
						if(editor_template.indexOf("~ORDERING_PRACTITIONER`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERING_PRACTITIONER`",ordering_practitioner);
						}
						if(editor_template.indexOf("~ORDER_TYPE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDER_TYPE`",order_type);
						}
						if(editor_template.indexOf("~ORDER_CATEGORY`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDER_CATEGORY`",order_category);
						}
						if(editor_template.indexOf("~ANAESTHESIA`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ANAESTHESIA`",anaesthesia);
						}
						if(editor_template.indexOf("~PREF_SURG_DATE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~PREF_SURG_DATE`",pref_surg_date);
						}
						if(editor_template.indexOf("~PERFORM_SURGEON`")!=-1){				 
							editor_template	= editor_template.replaceAll("~PERFORM_SURGEON`",perform_surgeon);
						}
						if(editor_template.indexOf("~ANAESTHETIST_CODE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ANAESTHETIST_CODE`",anaesthetist_code);
						}
						if(editor_template.indexOf("~REASON_REFUSAL`")!=-1){				 
							editor_template	= editor_template.replaceAll("~REASON_REFUSAL`",reason_refusal);
						}
						if(editor_template.indexOf("~ORDERABLE`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERABLE`",catalog_short_desc);
						}
						if(editor_template.indexOf("~ORDERABLE_LONG`")!=-1){				 
							editor_template	= editor_template.replaceAll("~ORDERABLE_LONG`",catalog_long_desc);
						}
						if(editor_template.indexOf("~EXPLANTORY_TEXT`")!=-1){				 
							editor_template	= editor_template.replaceAll("~EXPLANTORY_TEXT`",catalog_explantory_text);
						}
 						// End of Order Info
						if(editor_template.indexOf("~")!=-1 && editor_template.indexOf("`")!=-1){
							editor_template	= editor_template.substring(0,editor_template.indexOf("~")) + "N/A"+editor_template.substring(editor_template.indexOf("`")+1);
						}
			}	// End of editor_type E
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database getMnemonicDetails"+e.toString() ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet_template ) ;
			closeStatement( pstmt_template ) ;
			closeConnection(connection) ;
		}

		return editor_template;
	}


	public ArrayList getSysDateTime() throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate			= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
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
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_OPERTIONAL_STATUS") ) ;
			pstmt.setString(1, checkForNull(perform_oper.trim(),""));
			pstmt.setString(2, checkForNull(order_id.trim(),""));
			pstmt.setString(3, checkForNull(order_line_num.trim(),""));

			resultSet			= pstmt.executeQuery() ;

			while(resultSet != null && resultSet.next())
			{
				valid_operation_yn = checkForNull(resultSet.getString( "operation_yn" ),"N")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error in getOperationalStatus method in adapter"+e.getMessage() ) ;
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
			pstmt		= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_PRINT_LOCATION"));
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
			System.err.println( "When getting Billing Interface" +e) ;
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
				sql = OHRepositoryExt.getOrKeyValue("SQL_OR_PARAM_PRIV_TO_AUTHORISE");
			}
			else if(called_from.equalsIgnoreCase("ORD"))
			{
				sql = OHRepositoryExt.getOrKeyValue("SQL_OR_PARAM_PRIV_TO_ORDER");
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
			System.err.println( "When getting Privilege to Authorise" +e) ;
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

}
