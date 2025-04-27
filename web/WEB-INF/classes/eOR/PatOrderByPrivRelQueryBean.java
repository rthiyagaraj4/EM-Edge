/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           									created
26/06/2012    IN033488       Chowminya G    								Incident No: IN033488 -  Error Marking - Result completed indicator> 
03/09/2012    IN034790       Chowminya G    								Incident No: IN034790 -  3.CA – Existing Order/Order Tracking.> 
27/09/2012    IN035441       Chowminya G    								CRF-CA- Bru-HIMS-CRF-121/06- Multi Orders displayed wrongly in order tracking 
12/12/2012    IN035317       Chowminya G    								System should also display the external prescription record at CA – Order Tracking
05/06/2013    IN029948		Nijitha  S      								Bru-HIMS-CRF-082
05/02/2014 	  IN047918		 NijithaS										KDAH-CRF-0284
04/03/2014	  IN053433		 Nijitha S										ML-BRU-SCF-1545
26/03/2015	  IN054732		Karthi L										OR-Order Tracking - System does not display the future order in Line level.
03/06/2015	  IN054720		Vijayakumar K	03/06/2015							ML-BRU-SCF-1580 [IN:054720]
08/06/2015	  IN055807		Nijitha S										MO-GN-5496
09/10/2015	  IN055910		Karthi L										From Clinician Access, modified result shall be identified by include “!” in Blue color
21/10/2015	  IN058125		Karthi L											Modified icon is showing for Registration Status.								
08/03/2016	IN059490		Karthi L										After placing orders, in Existing order – keeping the Status as active and click search takes more than 1 minute to display the ordered details.[AAKH-SCF-0252]								
15/08/2016	IN059315		Raja S										When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
24/04/2018  IN067360		Sharanraj			24/04/2018		Ramesh G	 OR-ML-MMOH-CRF-1071/01-Order Tracking
17/09/2018	IN68663			Dinesh T			17/09/2018		Ramesh G	MMS-QF-SCF-0589	
05/11/2018	IN068986		Ramya Maddena		05/11/2018		Ramesh G	MO-CRF-20137.1
28/09/2020	ord_track		Nijitha S			28/09/2020		Nijitha S	Interaction Dtls not working in order tracking	
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
----------------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;

import eOR.Common.*;
 
public class  PatOrderByPrivRelQueryBean extends eOR.Common.OrAdapter implements Serializable
{
  public PatOrderByPrivRelQueryBean(){
  }

/**
	This will populate  the locations based upon the location type
	@return		:	ArrayList
*/
	public ArrayList getLocation(Properties properties, String location_type, String pract_id,String facility_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList Location			= new ArrayList() ;
 			try {
					connection			= ConnectionManager.getConnection(properties) ;
					//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION") ) ;
					pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TRACKING_SELECT_LOCATION") ) ;
					//pstmt.setString( 1, pract_id.trim() ) ;
					//pstmt.setString( 2, location_type.trim() ) ;
					pstmt.setString( 1, facility_id.trim() ) ;
					pstmt.setString( 2, location_type.trim() ) ;
					pstmt.setString( 3, facility_id.trim() ) ;
					pstmt.setString( 4, location_type.trim() ) ;
					pstmt.setString( 5, location_type.trim() ) ;

					resultSet = pstmt.executeQuery() ;

					while ( resultSet != null && resultSet.next() ) {
						String[] record = new String[2];
						record[0] = resultSet.getString( "locn_code" )  ;
						record[1] = resultSet.getString( "locn_short_desc" )  ;
					   Location.add(record) ;
					}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database getLocation" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}

			return Location;
		}
  
  /* To populate the order type  for the specimen */

  public ArrayList  getOrderTypeSpecimen( Properties properties, String order_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList();  //SQL_OR_SPECIMEN_ORDER_TYPE_SELECT

		try {

				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
				pstmt.setString(1, language_id);
			    pstmt.setString(2,order_cat);
				resultSet = pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
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
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}
/* To load the Activity Type */
public ArrayList  getActivityType(Properties properties, String order_category, String order_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		ArrayList ActivityType = new ArrayList();

		try {
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString( 2, order_category.trim() ) ;
				pstmt.setString( 3, order_type.trim() ) ;
				//pstmt.setString( 4, language_id);
				//pstmt.setString( 5, order_category.trim() ) ;
				

				resultSet = pstmt.executeQuery() ;
				while(resultSet.next())
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "activity_type" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					ActivityType.add(record) ;
					
				}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return ActivityType;
	}

// Populate the Practitioner
public ArrayList  getPractitionerID(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Pract				= new ArrayList();

		try {

				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_AM_PRACT") ) ;

				resultSet = pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "code" )  ;
					record[1] = resultSet.getString( "long_desc" )  ;

					Pract.add(record) ;
				}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return Pract;
	}

	/*public ArrayList getSearchResultDetails(Properties properties, String order_status,String pat_id1,String encounterId,String period_from,String period_to ,String location_type,String locn,String order_cat,String order_type,String catalog_synonym_dc  , String priority ,String search_crt,String order_by,String practitioner_id,String ordering_pract,String activity_type , int start, int end) throws Exception {
		Connection connection 		= null;
		PreparedStatement pdmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;
		//int total_records			= 0;

	try {
			 connection			= ConnectionManager.getConnection(properties) ;
			 if (period_from.equals(" ") || period_from.equals("null")) period_from="";
			if (period_to.equals(" ") || period_to.equals("null")) period_to="";
if ( !language_id.equals("en") )
{ 

			 thai date change
			 period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
			 period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
}
thai date change
			 chk += "pat_id1=::"+pat_id1+"@";
 			 chk += "encounterId=::"+encounterId+"@";
 			 chk += "order_status=::"+order_status+"@";
 			 chk += "order_cat=::"+order_cat+"@";
 			 chk += "order_type=::"+order_type+"@";
 			 chk += "search_crt=::"+search_crt+"@";
			 chk += "priority=::"+priority+"@";
 			 chk += "period from=::"+period_from+"@";
 			 chk += "period to=::"+period_to+"@";
			 chk += "order_by=::"+order_by+"@";
		
            if ((checkForNull(order_status)).equals("B")) {
                pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL1_APPT") ) ;
             } else {
				pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL1") ) ;
			}


//pdmt =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SELECT_SEARCH_PAT_BY_PP") ) ;

			pdmt.setString( 1, language_id);
			pdmt.setString( 2, language_id);
			pdmt.setString( 3, checkForNull(pat_id1) ) ;
		   	pdmt.setString( 4, checkForNull(encounterId)) ;
		   	if ((checkForNull(order_status)).equals("B")) {
		   	  pdmt.setString( 5, "") ;
			  pdmt.setString( 6, "") ;
		   	} else {
		   	  pdmt.setString( 5, checkForNull(period_from)) ;
			  pdmt.setString( 6, checkForNull(period_to)) ;
		   	}


  			pdmt.setString( 7, checkForNull(order_status) ) ;
			pdmt.setString( 8, checkForNull(order_status) ) ;
			pdmt.setString( 9, checkForNull(order_status) ) ;
			pdmt.setString( 10, checkForNull(order_status) ) ;
			pdmt.setString( 11,checkForNull( order_status) ) ;
			pdmt.setString( 12,checkForNull( order_status) ) ;
			pdmt.setString( 13,checkForNull( order_status) ) ;
			pdmt.setString( 14,checkForNull( order_status));

			if ((checkForNull(order_status)).equals("B")) {

			    pdmt.setString( 15,checkForNull( period_from ));
			    pdmt.setString( 16,checkForNull(period_to));
			    pdmt.setString( 17,checkForNull( order_cat) ) ;
    			pdmt.setString( 18,checkForNull( order_type) ) ;

    			pdmt.setString( 19,checkForNull(priority) ) ;
    			pdmt.setString( 20,checkForNull(search_crt) );
    			pdmt.setString( 21,checkForNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 22,checkForNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 23,checkForNull(catalog_synonym_dc) ) ;

    			//pdmt.setString( 22,checkForNull(practitioner_id) ) ;
    			pdmt.setString( 24,checkForNull(location_type) );
    			pdmt.setString( 25,checkForNull(locn) );
    			pdmt.setString( 26,checkForNull(ordering_pract) );
				pdmt.setString( 27,checkForNull( period_from ));
			    pdmt.setString( 28,checkForNull(period_to));
				pdmt.setString( 29,checkForNull(activity_type));
    			pdmt.setString( 30,checkForNull( order_by) ) ;
			} else {

    			pdmt.setString( 15,checkForNull( order_cat) ) ;
    			pdmt.setString( 16,checkForNull( order_type) ) ;

    			pdmt.setString( 17,checkForNull(priority) ) ;
    			pdmt.setString( 18,checkForNull(search_crt) );
    			pdmt.setString( 19,checkForNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 20,checkForNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 21,checkForNull(catalog_synonym_dc) ) ;

    			//pdmt.setString( 20,checkForNull(practitioner_id) ) ;
    			pdmt.setString( 22,checkForNull(location_type) );
    			pdmt.setString( 23,checkForNull(locn) );
    			pdmt.setString( 24,checkForNull(ordering_pract) );
				pdmt.setString( 25,checkForNull( period_from ));
			    pdmt.setString( 26,checkForNull(period_to));
				pdmt.setString( 27,checkForNull(activity_type));
    			pdmt.setString( 28,checkForNull( order_by) ) ;
			}

			resultSet = pdmt.executeQuery() ;

	
	//while(resultSet.next() ) {
		if(resultSet!=null) {
				resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1);
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				
				while ( start <= end && resultSet!=null && resultSet.next()) {
 					ArrayList ResultOrderCat	= new ArrayList() ;
					ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
					ResultOrderCat.add(resultSet.getString( "PRIORITY_DESC" ))  ;
					ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
					ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
					ResultOrderCat.add(resultSet.getString( "LOCATION_DETAILS" ))  ;
					ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
					ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS_SHORT_DESC" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
					ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME"));
					ResultOrderCat.add(resultSet.getString( "ORDER_DETAIL"));
					ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC"));
					ResultOrderCat.add(resultSet.getString( "PATIENT_DETAILS"));
					ResultOrderCat.add((resultSet.getString("start_date_time")== null)? "" : resultSet.getString( "start_date_time"));
					ResultOrderCat.add((resultSet.getString( "end_date_time") == null)? "" : resultSet.getString( "end_date_time"));
					ResultOrderCat.add(resultSet.getString( "SEX"));
					ResultOrderCat.add((resultSet.getString( "result_hyperlink_yn")== null)? "" : resultSet.getString( "result_hyperlink_yn"));
					ResultOrderCat.add(resultSet.getString( "cont_order_ind"));
					ResultOrderCat.add(resultSet.getString( "order_line_num"));
					ResultOrderCat.add(resultSet.getString( "patient_class"));
					ResultOrderCat.add(resultSet.getString( "priority"));
					ResultOrderCat.add(resultSet.getString( "ph_colors"));
					ResultOrderCat.add(resultSet.getString( "appt_date_time"));
					ResultOrderCat.add(resultSet.getString( "appt_ref_num"));
					
					ResultOrderCat.add(resultSet.getString( "appt_locn"));
					ResultOrderCat.add(resultSet.getString( "appt_resched_yn"));
					ResultOrderCat.add(resultSet.getString( "appt_resched_reason"));
					ResultOrderCat.add(resultSet.getString( "no_of_reschedules"));

					ResultOrderCat.add(resultSet.getString( "last_action_type"));
					ResultOrderCat.add(resultSet.getString( "accession_num"));
					// Pass the total Number of Records
					//ResultOrderCat.add(String.valueOf(total_records));
					
			ResultOrderCatFinal.add(ResultOrderCat);   
				start++;
			}
			if (resultSet.next())
			{
				ArrayList templist = (ArrayList)ResultOrderCatFinal.get(0);
				templist.add(""+(end+7));
				ResultOrderCatFinal.set(0,templist);
			}
		}
 }catch( Exception e )	{

			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pdmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return ResultOrderCatFinal;
}*/


	//public ArrayList getSearchResultDetails(Properties properties, String order_status, String pat_id1, String encounterId, String period_from, String period_to, String location_type, String locn, String order_cat, String order_type, String catalog_synonym_dc, String priority, String search_crt, String order_by, String practitioner_id, String ordering_pract, String activity_type, String view_by, String practitioner_type,String elapsed_orders,String sys_cancelled_orders, int start, int end) throws Exception //IN047918
	public ArrayList getSearchResultDetails(Properties properties, String order_status, String pat_id1, String encounterId, String period_from, String period_to, String location_type, String locn, String order_cat, String order_type, String catalog_synonym_dc, String priority, String search_crt, String order_by, String practitioner_id, String ordering_pract, String activity_type, String view_by, String practitioner_type,String elapsed_orders,String sys_cancelled_orders, int start, int end,String current_ip_list_check) throws Exception//IN047918
	{
		Connection connection 		= null;
		PreparedStatement pdmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;
		//int total_records			= 0;
		String sql="";
		String catalog_column_name = "";
		String is_bt_installed_yn	= ""; //IN065091
		setSiteSpecificYN("BLOOD_ORDERS_ACK"); //IN065091
		//HSA-CRF-0257.1 - IN055910 - Start
		if(order_cat == null) {
			order_cat = "";
		}
		//HSA-CRF-0257.1 - IN055910 - End
		if(catalog_synonym_dc==null)
		{
			catalog_synonym_dc = "";
		}
		int setcount = 0;

		try 
		{

			connection = ConnectionManager.getConnection(properties) ;
			if (period_from.equals(" ") || period_from.equals("null")) period_from="";
			if (period_to.equals(" ") || period_to.equals("null")) period_to="";
			if (pat_id1.equals(" ") || pat_id1.equals("null")) pat_id1="";
			if (catalog_synonym_dc.equals(" ") || catalog_synonym_dc.equals("null")) catalog_synonym_dc="";
			if ( !language_id.equals("en") )
			{ 
				/*thai date change*/
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/*thai date change*/
			/*	 chk += "pat_id1=::"+pat_id1+"@";
 			 chk += "encounterId=::"+encounterId+"@";
 			 chk += "order_status=::"+order_status+"@";
 			 chk += "order_cat=::"+order_cat+"@";
 			 chk += "order_type=::"+order_type+"@";
 			 chk += "search_crt=::"+search_crt+"@";
			 chk += "priority=::"+priority+"@";
 			 chk += "period from=::"+period_from+"@";
 			 chk += "period to=::"+period_to+"@";
			 chk += "order_by=::"+order_by+"@";
			*/
			is_bt_installed_yn 	= getBTInstalledYN();//IN065091
			if(view_by.equals("L"))
			{
				//sql = (String)OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL1") ;	//Commented and Modified --[IN034790]	
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time,or_get_order_catalog(a.order_id, a.order_type_code,?,?)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## /*AND UPPER (b.catalog_synonym_dc) LIKE DECODE ((?),'S', UPPER (?) || '%','C', '%' || UPPER (?) || '%','E', '%' || UPPER (?))*/ AND source_type = NVL (?, source_type) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ;
				//Commented n Modified --[IN035441]	
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## /*AND UPPER (b.catalog_synonym_dc) LIKE DECODE ((?),'S', UPPER (?) || '%','C', '%' || UPPER (?) || '%','E', '%' || UPPER (?))*/ AND source_type = NVL (?, source_type) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ; //commentted -[IN035317]
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ;//--[IN035317]
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ;//IN029948
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## AND a.ordering_facility_id = ? ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ;//IN047918 IN053433 added ordering facility -- Commented for IN054732
				  //sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) /*AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999 */ &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ; // Modified for IN054732//removed ordering facility for IN055807 -- commented for HSA-CRF-0257.1_001 IN058125
				//IN065091 start
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates, b.ORDER_CATALOG_CODE FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) /*AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999 */ &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ; // Modified for HSA-CRF-0257.1_001 IN058125
				//IN068986 Start.
				//sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates, b.ORDER_CATALOG_CODE, ##BTACKYN## bt_ack_YN FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) /*AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999 */ &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ; // IN065091 ends
				sql = "SELECT   DECODE (?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,d.sex, get_age (d.date_of_birth) age, a.patient_id,a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc,patient_class,or_get_desc.or_order_status_code(order_line_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date_time, DECODE (a.order_category, 'PH',or_get_order_catalog (a.order_id,a.order_type_code, ?,?,b.order_line_num),decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||e.catalog_synonym)  order_detail,    a.source_type, a.source_code, a.priority priority, b.order_type_code order_type_code,OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_line_status order_status,b.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.order_line_num order_line_num, b.item_narration item_narration,b.can_line_reason can_line_reason,NVL (b.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,         TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_order_line_ph_color (a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,TO_CHAR (b.appt_date_time, 'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num appt_ref_num, b.appt_locn appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,        b.no_of_reschedules no_of_reschedules,b.last_action_type last_action_type, b.accession_num accession_num,nvl((select 'Y'  from or_order_line  where order_id = a.order_id 	and order_line_num = b.order_line_num and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e 	where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' 	and c.order_status_type=e.order_status_type) and rownum=1),'N') result_hyper_link_yn,case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,OR_ORDER_TRACKING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time) display_popupmenu,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates, b.ORDER_CATALOG_CODE, ##BTACKYN## bt_ack_YN, b.STATUS_HIPERLINK_YN, b.billing_status FROM or_order a, mp_patient d, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw e   WHERE d.patient_id = a.patient_id  and b.durn_type = c.durn_type(+) AND b.order_catalog_code = e.order_catalog_code AND a.order_id = b.order_id  AND e.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?,b.order_catalog_code) AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  &&PAT_ID## AND NVL (a.encounter_id, 0) = NVL ((?), NVL (a.encounter_id, 0)) /*AND b.start_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+ .999 */ &&ORDERRESULT## AND a.order_category = NVL ((?), a.order_category)     AND b.order_type_code = NVL ((?), b.order_type_code) AND b.priority = NVL ((?), b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN## AND NVL(source_type,'!') = NVl((?),NVl(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999    AND NVL (b.activity_type, '!') = NVL (?, NVL (b.activity_type, '!')) &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D', TO_CHAR (TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'),'yyyymmddhh24mi'),'C',order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', b.priority),TO_DATE (start_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id, b.order_line_num" ; 
				//IN068986 End.
				if(order_status.equalsIgnoreCase("EXT_ACTIVE"))
				{
					if(elapsed_orders.equalsIgnoreCase("Y"))
					{
						sql = sql.replace("&&FILTER##"," ");
					}
					else
					{
						sql = sql.replace("&&FILTER##"," AND (b.end_date_time >SYSDATE OR b.end_date_time IS NULL)");
					}
					sql = sql.replace("&&ORDERRESULT##"," AND order_line_status IN ( SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b  WHERE b.oper_or_group_ref = ? AND a.order_status_type = b.order_status_type)");
					sql = sql.replace("&&FUTURE_ORD##"," ");
					sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
				}
				else if(order_status.equalsIgnoreCase("EXT_APPT"))
				{
						sql = sql.replace("&&ORDERRESULT##"," AND b.appt_date_time between TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999");
						sql = sql.replace("&&FUTURE_ORD##"," ");
						sql = sql.replace("&&FILTER##"," ");
						sql = sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
				}
				else if(order_status.equalsIgnoreCase("EXT_FUTURE_ORD"))
				{
					sql = sql.replace("&&FUTURE_ORD##", " and b.future_order_yn='Y'");
					sql = sql.replace("&&FILTER##"," ");
					sql = sql.replace("&&ORDERRESULT##"," AND order_line_status IN ( SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b  WHERE b.oper_or_group_ref = ? AND a.order_status_type = b.order_status_type)");
					sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
				}
				else
				{
					sql = sql.replace("&&FUTURE_ORD##"," ");
					sql = sql.replace("&&ORDERRESULT##"," AND order_line_status IN ( SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b  WHERE b.oper_or_group_ref = ? AND a.order_status_type = b.order_status_type)");
					sql = sql.replace("&&FILTER##"," ");
					if((order_status.equalsIgnoreCase("EXT_ALL"))||(order_status.equalsIgnoreCase("EXT_DISC_CAN")))
					{
						if(sys_cancelled_orders.equalsIgnoreCase("Y"))
						{
							sql =  sql.replace("&&FILTER1##"," ");
						}
						else
						{
							sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
						}
					}
					else
					{
						sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
					}
				}
				if(!pat_id1.equals(""))
				{
					sql = sql.replace("&&PAT_ID##"," AND a.patient_id = ?");
				}
				else
				{
					sql = sql.replace("&&PAT_ID##"," ");
					
				}
				if(!catalog_synonym_dc.equals(""))
				{
					sql = sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##"," AND exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)))");
				}
				else
				{
					sql = sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##" , " ");
				}

				if(!locn.equals(""))
				{
					sql = sql.replace("&&SOURCECODE##" , " and source_code = nvl(?,source_code) AND a.ordering_facility_id = ? ");//IN055807
				}
				else
				{
					sql = sql.replace("&&SOURCECODE##" , " ");
				}
				//IN047918
				if("Y".equals(current_ip_list_check))
				{
					sql = sql.replace("&&CURRENT_IPLIST_FILTER##" , " AND EXISTS (SELECT 1 FROM ip_open_encounter WHERE a.patient_id = patient_id AND a.encounter_id=encounter_id) ");
				}
				else
				{
					sql = sql.replace("&&CURRENT_IPLIST_FILTER##" , " ");
				}
				//IN047918
				//IN065091 start
				if("Y".equals(is_bt_installed_yn) && isSiteSpecificYN() && ("".equals(order_cat.trim())||("LB".equals(order_cat.trim()))))
				{
					sql=sql.replace("##BTACKYN##","GET_BT_ORDERS_ACKNOW_INDICATOR(b.order_id, a.PATIENT_ID, a.SOURCE_CODE, b.ORDER_CATALOG_CODE, b.ORD_DATE_TIME, ?, a.ordering_facility_id)");
				}
				else
				{
					sql=sql.replace("##BTACKYN##","'N'");
				}
				//IN065091 ends
				pdmt=connection.prepareStatement(sql) ;
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , practitioner_type );//--[IN034790] - Start
				//pdmt.setString( ++setcount , language_id );
				//pdmt.setString( ++setcount , language_id );
				//pdmt.setString( ++setcount , language_id );//--[IN034790] - End
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , language_id );
				//IN065091 start
				if("Y".equals(is_bt_installed_yn) && isSiteSpecificYN() && ("".equals(order_cat.trim())||("LB".equals(order_cat.trim()))))
				{
					pdmt.setString( ++setcount , language_id );
				}
				//IN065091 ends
				pdmt.setString( ++setcount , language_id );
				pdmt.setString( ++setcount , practitioner_type );
				if(!pat_id1.equals(""))
				{
					pdmt.setString( ++setcount , checkForNull( pat_id1 ) ) ;
				}
				pdmt.setString( ++setcount , checkForNull( encounterId )) ;
				// IN054732 Start.
				//pdmt.setString( ++setcount , checkForNull( period_from )) ;
				//pdmt.setString( ++setcount , checkForNull( period_to )) ;
				// IN054732 End.
				if(order_status.equalsIgnoreCase("EXT_APPT"))
				{
					pdmt.setString( ++setcount , checkForNull( period_from )) ;
					pdmt.setString( ++setcount , checkForNull( period_to )) ;
				}
				else
				{
					pdmt.setString( ++setcount , checkForNull( order_status )) ; 
				}

				pdmt.setString( ++setcount , checkForNull( order_cat ) ) ;
				pdmt.setString( ++setcount , checkForNull( order_type ) ) ;
				pdmt.setString( ++setcount , checkForNull(	priority ) ) ;

				if(!catalog_synonym_dc.equals(""))
				{
					pdmt.setString( ++setcount , language_id );
					pdmt.setString( ++setcount , checkForNull(	search_crt ) ) ;
					pdmt.setString( ++setcount , checkForNull( catalog_synonym_dc ) ) ;
					pdmt.setString( ++setcount , checkForNull( catalog_synonym_dc ) ) ;
					pdmt.setString( ++setcount , checkForNull( catalog_synonym_dc ) ) ;
				}

				pdmt.setString( ++setcount , checkForNull( location_type ) );
		
				if(!locn.equals(""))
				{
					pdmt.setString( ++setcount , checkForNull( locn ) );
					pdmt.setString( ++setcount , getLoginFacilityId() ) ;//IN053433 //IN055807
				}

				pdmt.setString( ++setcount , checkForNull( ordering_pract ) );
				pdmt.setString( ++setcount , checkForNull( period_from ));
				pdmt.setString( ++setcount , checkForNull( period_to ));
				pdmt.setString( ++setcount , checkForNull( activity_type ));
				//pdmt.setString( ++setcount , getLoginFacilityId() ) ;//IN053433 //IN055807
				pdmt.setString( ++setcount , checkForNull( order_by ) ) ;
			
			}
			else
			{	
				//sql = (String)OrRepository.getOrKeyValue("SQL_OR_ORDER_TRACKING_SEARCH_RSLT_HEADER_LEVEL");//Commentted -[IN035317]
				//sql = "SELECT DECODE(?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name, d.sex,      get_age(d.date_of_birth) age, a.patient_id, a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc, patient_class, or_get_desc.or_order_status_code(order_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id, TO_CHAR(a.ord_date_time, 'DD/MM/YYYY hh24:mi') order_date_time, or_get_order_catalog(a.order_id, a.order_type_code,?,?) order_detail,    a.source_type, a.source_code, a.priority priority, a.order_type_code order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner(a.ord_pract_id,?,'1')) ordering_pract_name, ORDER_STATUS order_status, a.ORD_COSIGN_REQD_YN ord_cosign_reqd_yn, NVL(a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, or_order_line_ph_color(a.ordering_facility_id,a.order_id,'',1) ph_colors, nvl((select 'Y' from or_order_line where order_id = a.order_id and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' and c.order_status_type = e.order_status_type) and rownum=1),'N') result_hyper_link_yn, case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,or_order_tracking_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),order_status,NULL,NULL,NULL,NULL) display_popupmenu FROM or_order a, mp_patient d &&SYNONYM## d.patient_id = a.patient_id AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') &&PAT_ID## AND NVL(a.encounter_id, 0) = NVL((?), NVL(a.encounter_id, 0)) AND a.ord_date_time BETWEEN TO_DATE (NVL((?), '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL((?), a.order_category) AND a.order_type_code = NVL((?),a.order_type_code) AND a.priority = NVL((?),a.priority) AND NVL(source_type,'!') = NVL((?),NVL(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL(?,a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999  &&FILTER## &&FUTURE_ORD## &&FILTER1## ORDER BY DECODE ((?), 'D',TO_CHAR (a.ord_date_time,'yyyymmddhh24mi'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', a.priority),TO_DATE (a.ord_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id"; //--[IN035317]//IN047918
				//IN054720 starts
				//sql = "SELECT DECODE(?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name, d.sex,      get_age(d.date_of_birth) age, a.patient_id, a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc, patient_class, or_get_desc.or_order_status_code(order_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id, TO_CHAR(a.ord_date_time, 'DD/MM/YYYY hh24:mi') order_date_time, or_get_order_catalog(a.order_id, a.order_type_code,?,?) order_detail,    a.source_type, a.source_code, a.priority priority, a.order_type_code order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner(a.ord_pract_id,?,'1')) ordering_pract_name, ORDER_STATUS order_status, a.ORD_COSIGN_REQD_YN ord_cosign_reqd_yn, NVL(a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, or_order_line_ph_color(a.ordering_facility_id,a.order_id,'',1) ph_colors, nvl((select 'Y' from or_order_line where order_id = a.order_id and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' and c.order_status_type = e.order_status_type) and rownum=1),'N') result_hyper_link_yn, case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,or_order_tracking_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),order_status,NULL,NULL,NULL,NULL) display_popupmenu FROM or_order a, mp_patient d &&SYNONYM## d.patient_id = a.patient_id AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') &&PAT_ID## AND NVL(a.encounter_id, 0) = NVL((?), NVL(a.encounter_id, 0)) AND a.ord_date_time BETWEEN TO_DATE (NVL((?), '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL((?), a.order_category) AND a.order_type_code = NVL((?),a.order_type_code) AND a.priority = NVL((?),a.priority) AND NVL(source_type,'!') = NVL((?),NVL(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL(?,a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999  &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## AND a.ordering_facility_id = ? ORDER BY DECODE ((?), 'D',TO_CHAR (a.ord_date_time,'yyyymmddhh24mi'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', a.priority),TO_DATE (a.ord_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id";//IN047918 IN053433 added ordering facility
				//sql = "SELECT DECODE(?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name, d.sex,      get_age(d.date_of_birth) age, a.patient_id, a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc, patient_class, or_get_desc.or_order_status_code(order_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id, TO_CHAR(a.ord_date_time, 'DD/MM/YYYY hh24:mi') order_date_time, or_get_order_catalog(a.order_id, a.order_type_code,?,?) order_detail,    a.source_type, a.source_code, a.priority priority, a.order_type_code order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner(a.ord_pract_id,?,'1')) ordering_pract_name, ORDER_STATUS order_status, a.ORD_COSIGN_REQD_YN ord_cosign_reqd_yn, NVL(a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, or_order_line_ph_color(a.ordering_facility_id,a.order_id,'',1) ph_colors, nvl((select 'Y' from or_order_line where order_id = a.order_id and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' and c.order_status_type = e.order_status_type) and rownum=1),'N') result_hyper_link_yn, case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,or_order_tracking_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),order_status,NULL,NULL,NULL,NULL) display_popupmenu,a.performing_facility_id performing_facility_id FROM or_order a, mp_patient d &&SYNONYM## d.patient_id = a.patient_id AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') &&PAT_ID## AND NVL(a.encounter_id, 0) = NVL((?), NVL(a.encounter_id, 0)) AND a.ord_date_time BETWEEN TO_DATE (NVL((?), '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL((?), a.order_category) AND a.order_type_code = NVL((?),a.order_type_code) AND a.priority = NVL((?),a.priority) AND NVL(source_type,'!') = NVL((?),NVL(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL(?,a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999  &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D',TO_CHAR (a.ord_date_time,'yyyymmddhh24mi'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', a.priority),TO_DATE (a.ord_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id";//IN047918 IN053433 added ordering facility - commented for  HSA-CRF-0257.1 - IN055910
				//IN054720 ends // removed ordering facility for IN055807
				//sql = "SELECT DECODE(?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name, d.sex,      get_age(d.date_of_birth) age, a.patient_id, a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc, patient_class, or_get_desc.or_order_status_code(order_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id, TO_CHAR(a.ord_date_time, 'DD/MM/YYYY hh24:mi') order_date_time, or_get_order_catalog(a.order_id, a.order_type_code,?,?) order_detail,    a.source_type, a.source_code, a.priority priority, a.order_type_code order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner(a.ord_pract_id,?,'1')) ordering_pract_name, ORDER_STATUS order_status, a.ORD_COSIGN_REQD_YN ord_cosign_reqd_yn, NVL(a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, or_order_line_ph_color(a.ordering_facility_id,a.order_id,'',1) ph_colors, nvl((select 'Y' from or_order_line where order_id = a.order_id and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' and c.order_status_type = e.order_status_type) and rownum=1),'N') result_hyper_link_yn, case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,or_order_tracking_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),order_status,NULL,NULL,NULL,NULL) display_popupmenu,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a, mp_patient d &&SYNONYM## d.patient_id = a.patient_id AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') &&PAT_ID## AND NVL(a.encounter_id, 0) = NVL((?), NVL(a.encounter_id, 0)) AND a.ord_date_time BETWEEN TO_DATE (NVL((?), '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL((?), a.order_category) AND a.order_type_code = NVL((?),a.order_type_code) AND a.priority = NVL((?),a.priority) AND NVL(source_type,'!') = NVL((?),NVL(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL(?,a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999  &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D',TO_CHAR (a.ord_date_time,'yyyymmddhh24mi'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', a.priority),TO_DATE (a.ord_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id";// HSA-CRF-0257.1 - IN055910,commented for IN067360
				//sql = "SELECT (select appt_ref_num from or_order_line where order_id=a.order_id and rownum=1)appt_ref_num,(select appt_locn from or_order_line where order_id=a.order_id and rownum=1)appt_locn,(select TO_CHAR(appt_date_time,'DD/MM/YYYY HH24:MI') from or_order_line where order_id=a.order_id and rownum=1)appt_date_time,DECODE(?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name, d.sex,      get_age(d.date_of_birth) age, a.patient_id, a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc, patient_class, or_get_desc.or_order_status_code(order_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id, TO_CHAR(a.ord_date_time, 'DD/MM/YYYY hh24:mi') order_date_time, or_get_order_catalog(a.order_id, a.order_type_code,?,?) order_detail,    a.source_type, a.source_code, a.priority priority, a.order_type_code order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner(a.ord_pract_id,?,'1')) ordering_pract_name, ORDER_STATUS order_status, a.ORD_COSIGN_REQD_YN ord_cosign_reqd_yn, NVL(a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, or_order_line_ph_color(a.ordering_facility_id,a.order_id,'',1) ph_colors, nvl((select 'Y' from or_order_line where order_id = a.order_id and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' and c.order_status_type = e.order_status_type) and rownum=1),'N') result_hyper_link_yn, case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,or_order_tracking_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),order_status,NULL,NULL,NULL,NULL) display_popupmenu,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a, mp_patient d &&SYNONYM## d.patient_id = a.patient_id AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') &&PAT_ID## AND NVL(a.encounter_id, 0) = NVL((?), NVL(a.encounter_id, 0)) AND a.ord_date_time BETWEEN TO_DATE (NVL((?), '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL((?), a.order_category) AND a.order_type_code = NVL((?),a.order_type_code) AND a.priority = NVL((?),a.priority) AND NVL(source_type,'!') = NVL((?),NVL(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL(?,a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999  &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D',TO_CHAR (a.ord_date_time,'yyyymmddhh24mi'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', a.priority),TO_DATE (a.ord_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id";//IN067360//IN68663
				sql = "SELECT DECODE(?,'en',d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name, d.sex,      get_age(d.date_of_birth) age, a.patient_id, a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, am_get_desc.am_patient_class(patient_class,?,'2') patient_class_short_desc, patient_class, or_get_desc.or_order_status_code(order_status,?,'2') order_status_short_desc, a.order_id order_id, a.encounter_id, TO_CHAR(a.ord_date_time, 'DD/MM/YYYY hh24:mi') order_date_time, or_get_order_catalog(a.order_id, a.order_type_code,?,?) order_detail,    a.source_type, a.source_code, a.priority priority, a.order_type_code order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner(a.ord_pract_id,?,'1')) ordering_pract_name, ORDER_STATUS order_status, a.ORD_COSIGN_REQD_YN ord_cosign_reqd_yn, NVL(a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn, or_order_line_ph_color(a.ordering_facility_id,a.order_id,'',1) ph_colors, nvl((select 'Y' from or_order_line where order_id = a.order_id and order_line_status in (select order_status_code from or_order_status_code c, or_status_applicability e where e.oper_or_group_ref='OPER_RESULT_HYPER_LINK' and c.order_status_type = e.order_status_type) and rownum=1),'N') result_hyper_link_yn, case when patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,or_order_tracking_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),order_status,NULL,NULL,NULL,NULL) display_popupmenu,a.performing_facility_id performing_facility_id &&ACCESSION_NO##,(select appt_ref_num from or_order_line where order_id=a.order_id and rownum=1)appt_ref_num,(select appt_locn from or_order_line where order_id=a.order_id and rownum=1)appt_locn,(select TO_CHAR(appt_date_time,'DD/MM/YYYY HH24:MI') from or_order_line where order_id=a.order_id and rownum=1)appt_date_time FROM or_order a, mp_patient d &&SYNONYM## d.patient_id = a.patient_id AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') &&PAT_ID## AND NVL(a.encounter_id, 0) = NVL((?), NVL(a.encounter_id, 0)) AND a.ord_date_time BETWEEN TO_DATE (NVL((?), '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL((?),'31/12/9999'),'dd/mm/yyyy')+ .999  &&ORDERRESULT## AND a.order_category = NVL((?), a.order_category) AND a.order_type_code = NVL((?),a.order_type_code) AND a.priority = NVL((?),a.priority) AND NVL(source_type,'!') = NVL((?),NVL(source_type,'!')) &&SOURCECODE## AND a.ord_pract_id = NVL(?,a.ord_pract_id) AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .999  &&FILTER## &&FUTURE_ORD## &&FILTER1## &&CURRENT_IPLIST_FILTER## ORDER BY DECODE ((?), 'D',TO_CHAR (a.ord_date_time,'yyyymmddhh24mi'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.source_type||location_description,'P', a.patient_id,'U', a.priority),TO_DATE (a.ord_date_time, 'dd/mm/yyyy hh24:mi'), a.order_id";//IN067360//IN68663

				if(practitioner_type!=null && (practitioner_type.equals("PS") || practitioner_type.equals("DN") || practitioner_type.equals("MD") || practitioner_type.equals("SG") || practitioner_type.equals("NS")) ) 
				{
					catalog_column_name            = " nvl(b.catalog_synonym_dc,b.catalog_desc)";
				}  
				else if(practitioner_type!=null && (practitioner_type.equals("RD") || practitioner_type.equals("PT")) )
				{
					catalog_column_name            = " nvl(b.catalog_synonym_ad,b.catalog_desc)";
				}
				else
					catalog_column_name            = "nvl(b.catalog_synonym,b.catalog_desc)";

				if(catalog_synonym_dc.equals(""))
				{
					sql = sql.replace("&&SYNONYM##", " WHERE ");
				}
				else
				{
					sql = sql.replace("&&SYNONYM##", " ,OR_ORDER_LINE B WHERE A.ORDER_ID=B.ORDER_ID AND B.ORDER_LINE_NUM=1 AND exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and ");
				}

				if(order_status.equalsIgnoreCase("EXT_ACTIVE"))
				{
					if(elapsed_orders.equalsIgnoreCase("Y"))
					{
						sql = sql.replace("&&FILTER##"," ");
					}
					else
					{
						sql = sql.replace("&&FILTER##"," and exists(select 1 from or_order_line  where order_id=a.order_id AND (end_date_time >SYSDATE OR end_date_time IS NULL))");
					}
					sql = sql.replace("&&ORDERRESULT##"," AND order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b  WHERE b.oper_or_group_ref = ? AND a.order_status_type = b.order_status_type)");
					sql = sql.replace("&&FUTURE_ORD##"," ");
					sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y') ");
				}
				else if(order_status.equalsIgnoreCase("EXT_APPT"))
				{
						sql = sql.replace("&&ORDERRESULT##"," and exists (select 1 from or_order_line where order_id=a.order_id and appt_date_time between TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999)");
						sql = sql.replace("&&FUTURE_ORD##"," ");
						sql = sql.replace("&&FILTER##"," ");
						sql = sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y')");
				}
				else if(order_status.equalsIgnoreCase("EXT_FUTURE_ORD"))
				{
					sql = sql.replace ("&&FUTURE_ORD##", " and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y')");
					sql = sql.replace("&&FILTER##"," ");
					sql = sql.replace("&&ORDERRESULT##"," AND order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b  WHERE b.oper_or_group_ref = ? AND a.order_status_type = b.order_status_type)");					
					sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y')");
				}
				else
				{
					sql = sql.replace("&&FUTURE_ORD##"," ");
					sql = sql.replace("&&FILTER##"," ");
					sql = sql.replace("&&ORDERRESULT##"," AND order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b  WHERE b.oper_or_group_ref = ? AND a.order_status_type = b.order_status_type)");	
					if((order_status.equalsIgnoreCase("EXT_ALL"))||(order_status.equalsIgnoreCase("EXT_DISC_CAN")))
					{
						if(sys_cancelled_orders.equalsIgnoreCase("Y"))
						{
							sql =  sql.replace("&&FILTER1##"," ");
						}
						else
						{
							sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y') ");
						}
					}
					else
					{
						sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y') ");
					}
				}
				if(!pat_id1.equals(""))
				{
					sql = sql.replace("&&PAT_ID##"," AND a.patient_id = ?");
				}
				else
				{
					sql = sql.replace("&&PAT_ID##"," ");
				}

				if(!locn.equals(""))
				{
					sql = sql.replace("&&SOURCECODE##" , " and source_code = nvl(?,source_code) AND a.ordering_facility_id = ? ");//IN055807
				}
				else
				{
					sql = sql.replace("&&SOURCECODE##" , " ");
				}
				//IN047918
				if("Y".equals(current_ip_list_check))
				{
					sql = sql.replace("&&CURRENT_IPLIST_FILTER##" , " AND EXISTS (SELECT 1 FROM ip_open_encounter WHERE a.patient_id = patient_id) ");
				}
				else
				{
					sql = sql.replace("&&CURRENT_IPLIST_FILTER##" , " ");
				}
				//IN047918
				// HSA-CRF-0257.1 - IN055910 - Start
				if("".equals(order_cat) || order_cat.equals("LB")){
					sql = sql.replace("&&ACCESSION_NO##", ",( select accession_num from or_order_line where  order_id = a.order_id and rownum =1) specimen_no ");
				} else {
					sql = sql.replace("&&ACCESSION_NO##", "");
				}
				// HSA-CRF-0257.1 - IN055910 - End
				pdmt=connection.prepareStatement(sql) ;
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , practitioner_type);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);
				pdmt.setString( ++setcount , language_id);

				if(!catalog_synonym_dc.equals(""))
				{
					pdmt.setString( ++setcount , language_id);
					pdmt.setString( ++setcount , checkForNull(search_crt) ) ;
					pdmt.setString( ++setcount , checkForNull(catalog_synonym_dc) ) ;
					pdmt.setString( ++setcount , checkForNull(catalog_synonym_dc) ) ;
					pdmt.setString( ++setcount , checkForNull(catalog_synonym_dc) ) ;
				}
				if(!pat_id1.equals(""))
				{
					pdmt.setString( ++setcount , checkForNull(pat_id1) ) ;
				}
				pdmt.setString( ++setcount , checkForNull(encounterId)) ;
				pdmt.setString( ++setcount , checkForNull(period_from)) ;
				pdmt.setString( ++setcount , checkForNull(period_to)) ;
				if(order_status.equalsIgnoreCase("EXT_APPT"))
				{
					pdmt.setString( ++setcount , checkForNull(period_from)) ;
					pdmt.setString( ++setcount , checkForNull(period_to)) ;
				}
				else
				{
					pdmt.setString( ++setcount, checkForNull(order_status)) ; 
				}
				pdmt.setString( ++setcount , checkForNull( order_cat ) ) ;
				pdmt.setString( ++setcount , checkForNull( order_type ) ) ;
				pdmt.setString( ++setcount , checkForNull( priority ) ) ;
				pdmt.setString( ++setcount , checkForNull( location_type ) );
			
				if(!locn.equals(""))
				{
					pdmt.setString( ++setcount , checkForNull( locn ) );
					pdmt.setString( ++setcount , getLoginFacilityId() ) ;//IN055807
				}

				pdmt.setString( ++setcount , checkForNull( ordering_pract ) );
				pdmt.setString( ++setcount , checkForNull( period_from ));
				pdmt.setString( ++setcount , checkForNull( period_to ));
				//pdmt.setString( ++setcount , getLoginFacilityId() ) ;//IN053433 //IN055807
				pdmt.setString( ++setcount , checkForNull( order_by ) ) ;
			}
			
			//pdmt =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SELECT_SEARCH_PAT_BY_PP") ) ;
				resultSet = pdmt.executeQuery() ;

			//while(resultSet.next() ) {
			if(resultSet!=null)
			{
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
				}
				if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
			
				while ( start <= end && resultSet!=null && resultSet.next())
				{
					ArrayList ResultOrderCat	= new ArrayList() ;
					if(view_by.equals("L"))
					{
						ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
						ResultOrderCat.add(resultSet.getString( "priority" ))  ;
						ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
						ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
						ResultOrderCat.add(resultSet.getString( "location_description" ))  ;
						ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
						ResultOrderCat.add(resultSet.getString( "patient_class_short_desc" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME" ));
						ResultOrderCat.add(resultSet.getString( "ORDER_DETAIL" ));
						ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC" ));
						ResultOrderCat.add(resultSet.getString( "patient_name" ));
						ResultOrderCat.add((resultSet.getString("start_date_time" ) == null)? "" : resultSet.getString( "start_date_time" ));
						ResultOrderCat.add((resultSet.getString( "end_date_time" ) == null)? "" : resultSet.getString( "end_date_time"));
						ResultOrderCat.add(resultSet.getString( "SEX"));
						ResultOrderCat.add((resultSet.getString( "result_hyper_link_yn" ) == null)? "" : resultSet.getString( "result_hyper_link_yn" ));
						//ResultOrderCat.add("N");
						ResultOrderCat.add(resultSet.getString( "cont_order_ind" ));
						ResultOrderCat.add(resultSet.getString( "order_line_num" ));
						ResultOrderCat.add(resultSet.getString( "patient_class" ));
						ResultOrderCat.add(resultSet.getString( "priority" ));
						ResultOrderCat.add(resultSet.getString( "ph_colors" ));
						ResultOrderCat.add(resultSet.getString( "appt_date_time" ));
						ResultOrderCat.add(resultSet.getString( "appt_ref_num" ));
						ResultOrderCat.add(resultSet.getString( "appt_locn" ));
						ResultOrderCat.add(resultSet.getString( "appt_resched_yn" ));
						ResultOrderCat.add(resultSet.getString( "appt_resched_reason" ));
						ResultOrderCat.add(resultSet.getString( "no_of_reschedules" ));
						ResultOrderCat.add(resultSet.getString( "last_action_type" ));
						ResultOrderCat.add(resultSet.getString( "accession_num" ));
						ResultOrderCat.add(resultSet.getString( "age" ));
						ResultOrderCat.add(resultSet.getString( "performing_facility_id" ));
						ResultOrderCat.add(resultSet.getString( "ext_appl_accession_num" ));
						ResultOrderCat.add(resultSet.getString( "display_popupmenu" ));
						ResultOrderCat.add("");//VIEW_REPLACED_ORDER
						ResultOrderCat.add("");//VIEW_ORIGINAL_ORDER
						ResultOrderCat.add( resultSet.getString( "alternates" ) );//IN029948
						ResultOrderCat.add( resultSet.getString( "ORDER_CATALOG_CODE" ) );//IN058125
						ResultOrderCat.add( resultSet.getString("item_narration")); //IN059315
						ResultOrderCat.add( resultSet.getString("bt_ack_YN")); //IN065091
						ResultOrderCat.add( resultSet.getString("STATUS_HIPERLINK_YN")); //IN068986
						ResultOrderCat.add((resultSet.getString( "encounter_id" )== null)? "" : resultSet.getString( "encounter_id" ));//ord_track
						ResultOrderCat.add( resultSet.getString("billing_status")); //19112
					}
					else
					{
						ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
						ResultOrderCat.add(resultSet.getString( "priority" ))  ;
						ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
						ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
						ResultOrderCat.add(resultSet.getString( "location_description" ))  ;
						ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
						ResultOrderCat.add(resultSet.getString( "patient_class_short_desc" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
						ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME" ));
						ResultOrderCat.add(resultSet.getString( "ORDER_DETAIL" ));
						ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC" ));
						ResultOrderCat.add(resultSet.getString( "patient_name" ));
						ResultOrderCat.add(resultSet.getString( "SEX" ));
						ResultOrderCat.add((resultSet.getString( "result_hyper_link_yn" )== null)? "" : resultSet.getString( "result_hyper_link_yn" ));
						ResultOrderCat.add(resultSet.getString( "cont_order_ind" ));
						ResultOrderCat.add(resultSet.getString( "patient_class" ));
						ResultOrderCat.add(resultSet.getString( "priority" ));
						ResultOrderCat.add(resultSet.getString( "ph_colors" ));
						ResultOrderCat.add(resultSet.getString( "age" ));
						ResultOrderCat.add(resultSet.getString( "display_popupmenu" ));
						ResultOrderCat.add("");//VIEW_REPLACED_ORDER
						ResultOrderCat.add("");//VIEW_ORIGINAL_ORDER
						ResultOrderCat.add(resultSet.getString( "performing_facility_id" )); //IN054720
						// HSA-CRF-0257.1 - IN055910 - Start
						if(order_cat.equals("LB") || resultSet.getString( "ORDER_CATEGORY" ).equals("LB")) {
							ResultOrderCat.add(resultSet.getString( "specimen_no" ));
						} else {
							ResultOrderCat.add("");
						}
						/*IN067360 Starts*/
						ResultOrderCat.add((resultSet.getString( "appt_date_time" )== null)? "" : resultSet.getString( "appt_date_time" ));
						ResultOrderCat.add((resultSet.getString( "appt_ref_num" )== null)? "" : resultSet.getString( "appt_ref_num" ));
						ResultOrderCat.add((resultSet.getString( "appt_locn" )== null)? "" : resultSet.getString( "appt_locn" ));
						ResultOrderCat.add((resultSet.getString( "encounter_id" )== null)? "" : resultSet.getString( "encounter_id" ));//ord_track
						/*IN067360 ends*/
						// HSA-CRF-0257.1 - IN055910 - End
					}
					// Pass the total Number of Records
					//ResultOrderCat.add(String.valueOf(total_records));
					ResultOrderCatFinal.add(ResultOrderCat);   
					start++;
				}
				if (resultSet.next())
				{
					ArrayList templist = (ArrayList)ResultOrderCatFinal.get(0);
					templist.add(""+(end+7));
					ResultOrderCatFinal.set(0,templist);
				}
			}
		}
		catch( Exception e )
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pdmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return ResultOrderCatFinal;
	}

	public String getOrderID(String order_id,String func_mode) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String orderID = "";
		
		try 
		{
			connection = getConnection();
			if(func_mode.equalsIgnoreCase("ViewReplacedOrder"))
			{
				pstmt = connection.prepareStatement((String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_REPLACED_ORDER"));
			}
			else if(func_mode.equalsIgnoreCase("ViewOriginalOrder"))
			{
				pstmt = connection.prepareStatement((String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORIGINAL_ORDER"));
			}
			pstmt.setString(1,order_id);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				orderID = resultSet.getString("order_id") == null ? "" : resultSet.getString("order_id");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in method getOrderID ---"+e.toString());
			e.printStackTrace(System.err);
			return null;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return orderID;
	}//end of getOrderID
//--[IN033488]
public ArrayList getRltNoteSts(String order_id,String langId)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		ArrayList NoteStatus = new ArrayList() ;
		try
		{
			connection = getConnection() ;
			sql = "select am_get_desc.am_practitioner (action_by_id,?, '1') action_by_id,ACTION_DATE_TIME,ACTION_TYPE from (SELECT action_by_id,ACCESSION_NUM,ACTION_DATE_TIME,ACTION_TYPE FROM ca_encntr_note_audit_log a,or_result_detail b WHERE a.accession_num = b.linked_note_accession_num AND b.order_id = ? order by action_date_time desc) where rownum= 1";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString( 1, langId.trim() ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;		
			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[3];
				record[0] = resultSet.getString( "action_by_id" )  ;
				record[1] = resultSet.getString( "ACTION_DATE_TIME" )  ;
				record[2] = resultSet.getString( "ACTION_TYPE" )  ;

				NoteStatus.add(record) ;
			}	
		}	
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet(resultSet) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}	
		return NoteStatus;
	}
//--[IN033488]
//HSA-CRF-0257.1 - IN055910 - Start 
public String getLabOrderStatusBySpecNo(String specimen_no, String view_by, String catalog_code, String patient_id) throws Exception {
	String order_status = "";
	String test_code = "";
	if(catalog_code == null) catalog_code = "";
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet resultSet = null;
	// modified below codes for HSA-CRF-0257.1-02 - IN058125
	String selectQuery = "";
	String tstCodQuery = "SELECT TEST_CODE FROM RL_TEST_CODE WHERE ORDER_CATALOG_CODE = ?";
	if(view_by.equalsIgnoreCase("L")){
		//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) and CONTR_SYS_EVENT_CODE = ? "; //AAKH-SCF-0252
		selectQuery = "SELECT  STATUS FROM CR_ENCOUNTER_DETAIL where HIST_REC_TYPE='LBIN' AND  ACCESSION_NUM = 'F'||FACILITY_ID||'#'||?||'@'||CONTR_SYS_EVENT_CODE and CONTR_SYS_EVENT_CODE = ? and PATIENT_ID = ?"; //AAKH-SCF-0252 // HIST_REC_TYPE, PATIENT_ID added for PERF ISSUE - Karthi
	} else {
		//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) and STATUS = 'C'";
		selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE='LBIN' AND ACCESSION_NUM = 'F'||FACILITY_ID||'#'||?||'@'||CONTR_SYS_EVENT_CODE and PATIENT_ID = ? and STATUS = 'C'"; //AAKH-SCF-0252 // HIST_REC_TYPE, PATIENT_ID added for PERF ISSUE - Karthi
	}
	//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) AND ROWNUM=1";
	try {
		connection = getConnection();
		pStatement = connection.prepareStatement(tstCodQuery);
		pStatement.setString(1, catalog_code);
		resultSet = pStatement.executeQuery();
		
		while(resultSet.next()){
			test_code = resultSet.getString("TEST_CODE");
		}
		if(resultSet != null) resultSet.close();
		if(pStatement != null) pStatement.close();
		
		pStatement = connection.prepareStatement(selectQuery);
		pStatement.setString(1, specimen_no);
		
		if(view_by.equalsIgnoreCase("L")) {
			pStatement.setString(2, test_code);
			pStatement.setString(3, patient_id);// PATIENT_ID added for PERF ISSUE - Karthi
		} else {
			pStatement.setString(2, patient_id);// PATIENT_ID added for PERF ISSUE - Karthi
		}
		resultSet = pStatement.executeQuery();
		if(resultSet.next()){
			order_status = resultSet.getString( "STATUS" )  ;
		}
	}
	catch(Exception ex){
		System.err.println("1049. PatOrderByPrivRelQueryBean.java ===> " + ex.getMessage());
		ex.printStackTrace();
	} finally {
		if(resultSet != null) resultSet.close();
		if(pStatement != null) pStatement.close();
		if(connection != null) connection.close();
	}
	return order_status;
}
//HSA-CRF-0257.1 - IN055910 - End
//HSA-CRF-0257.1-02 IN058125 - Start 
	public String getResultStatFromStatusAppl(String view_by, String order_id, String order_line, String patient_id) throws Exception {
		String isModified = "";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		String selectQuery = "";
		int order_line_int = 0;
		if(view_by.equalsIgnoreCase("L")) {
			selectQuery = "Select 'Y' isModified from or_order_line where order_id = ? and order_line_status IN ( SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type) and ORDER_LINE_NUM =?";
		} else {
			selectQuery = "Select 'Y' isModified from or_order where order_id = ? and patient_id =? and order_status IN ( SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type)"; //added patient_id for PERF ISSUE - Karthi
		}
		try {
			if(order_line != null && order_line != "") {
				order_line_int = Integer.parseInt(order_line);
			}
			connection = getConnection();
			pStatement = connection.prepareStatement(selectQuery);
			pStatement.setString(1, order_id);
			if(view_by.equalsIgnoreCase("L")) {
				pStatement.setInt(2, order_line_int);
			}else { // added for PERF ISSUE - Start - Karthi
				pStatement.setString(2, patient_id);  
			} // added for PERF ISSUE - End - Karthi
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				isModified = resultSet.getString( "isModified" )  ;
			}
		}
		catch(Exception ex){
			System.err.println("4999. PatOrderByPrivRelQueryBean.java ===> " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return isModified;
	}
	public ArrayList getIntervalTestSpecNos(String orderId, String patient_id) throws Exception {
		ArrayList specList = new ArrayList();
		String selectQuery = "SELECT distinct(SPECIMEN_NO) FROM RL_REQUEST_HEADER WHERE ORDER_ID = ? and PATIENT_ID = ?"; // PATIENT_ID added for PERF ISSUE - Karthi
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(selectQuery);
			pStatement.setString(1, orderId);
			pStatement.setString(2, patient_id); // PATIENT_ID added for PERF ISSUE - Karthi
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				specList.add(resultSet.getString("SPECIMEN_NO"));
			}
		} catch(Exception ex){
			ex.getMessage();
			ex.printStackTrace();
		} finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return specList;
	}
	public String getLBModStatForIntTest(ArrayList specList, String patient_id) throws Exception {
		String resultModStatus = "";
		//String selectSql = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) and STATUS = 'C'"; //AAKH-SCF-0252
		String selectSql = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE='LBIN' AND   ACCESSION_NUM = 'F'||FACILITY_ID||'#'||?||'@'||CONTR_SYS_EVENT_CODE and PATIENT_ID = ? and STATUS = 'C'"; //AAKH-SCF-0252 // HIST_REC_TYPE, PATIENT_ID added for PERF ISSUE - Karthi
		String accession_no = "";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			if(specList != null){
				connection = getConnection();
				for(int i=0;i<specList.size();i++){
					accession_no = (String)specList.get(i);
					pStatement = connection.prepareStatement(selectSql);
					pStatement.setString(1, accession_no);
					pStatement.setString(2, patient_id); // PATIENT_ID added for PERF ISSUE - Karthi
					resultSet = pStatement.executeQuery();
					while(resultSet.next()){
						resultModStatus = resultSet.getString( "STATUS" )  ;
					}
					if(resultModStatus.equalsIgnoreCase("C")){
						break;
					}
					if(resultSet != null) resultSet.close();
					if(pStatement != null) pStatement.close();
				}
			}
		} catch(Exception ex){
			ex.getMessage();
			ex.printStackTrace();
		} 
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return resultModStatus;
	}
	//HSA-CRF-0257.1-02 IN058125 - End
	// added for IN065091 Start
	public String getBTInstalledYN() throws Exception {
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String isBTInstalledYN = "N";
		 String sqlQry = "SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = 'BT'";
		 try {
				connection	= getConnection();
				pstmt		= connection.prepareStatement( sqlQry);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					if(resultSet.next())
					{
						isBTInstalledYN = checkForNull(resultSet.getString( "INSTALL_YN" ),"N")  ;
					}
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return isBTInstalledYN;
	}
	//added for IN065091 - End
} // End of the class
