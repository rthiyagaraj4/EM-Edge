/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
09/12/2015  IN058544     	Karthi L     								unbilled services for discharge patient D- 1 - GHL-SCF-989
31/05/2023		44884		Krishna			31/05/2023	Ramesh G 		MO-CRF-20183
-------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR ;

import java.io.* ;
import java.util.* ;
import java.sql.*;

import eOR.Common.* ;
import eCommon.Common.*;

public class MultiPatientOrdersBean extends eOR.Common.OrAdapter implements Serializable {
	private ArrayList arr_patient_id		= null ;
	private String qryString 				= "";
	private String patString 				= "";
	private String encString 				= "";
	private String epiString 				= "";
	private String visitString 				= "";
	private String patClassString 				= "";
	private ArrayList multiPatientDetails	= null;

	/* Set Methods Start */
	public void setPatientIDBatch( ArrayList arr_patient_id ) {
		this.arr_patient_id = arr_patient_id  ;
	}
	public void setQryString(String qryString) {
		this.qryString = qryString;
	}
	public void setPatString(String patString) {
		this.patString = patString;
	}
	public void setEncString(String encString) {
		this.encString = encString;
	}
	public void setEpiString(String epiString) {
		this.epiString = epiString;
	}
	public void setVisitString(String visitString) {
		this.visitString = visitString;
	}
	public void setPatClassString(String patClassString) {
		this.patClassString = patClassString;
	}
	public void setMultiPatientDetails(ArrayList multiPatientDetails) {
		this.multiPatientDetails = multiPatientDetails;
	}

	/* Set Methods End */

	/* Get Methods Start */
	public ArrayList getPatientIDBatch() {
		return this.arr_patient_id;
	}
	public String getQryString() {
		return this.qryString;
	}
	public String getPatString() {
		return this.patString;
	}
	public String getEncString() {
		return this.encString;
	}
	public String getEpiString() {
		return this.epiString;
	}
	public String getVisitString() {
		return this.visitString;
	}
	public String getPatClassString() {
		return this.patClassString;
	}
	public ArrayList getMultiPatientDetails() {
		return this.multiPatientDetails;
	}
	/* Get Methods End */

    /* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

	public HashMap insert() {
	      HashMap map			= new HashMap() ;
	      map.put( "result", new Boolean( false ) ) ;
   	      return map ;
	} // end of insert



	public HashMap modify() {

      HashMap map = new HashMap() ;
      map.put( "result", new Boolean( false ) ) ;

		return map ;
	} // end of modify

	public void clear() {
		if(arr_patient_id!=null)
			arr_patient_id.clear();
		arr_patient_id = null;
		qryString	   = null;
		if(multiPatientDetails!=null)
			multiPatientDetails.clear();
			multiPatientDetails = null;
		patString 				= "";
		encString 				= "";
		epiString 				= "";
		visitString 				= "";
		patClassString 		= "";
		super.clear() ;
	}

	//public void setAll( Hashtable recordSet ) {

	//			}
	/* Over-ridden Adapter methods end here */


/* Function specific methods start */
	public void loadData() throws Exception {
		}


	/* Function specific methods end */


	/**
	To Retrive the Location Desc
	*/
	public ArrayList getLocation(String locn_type, String  practitioner_id, String facility_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList() ;
		String[] record				= null;

		try {
			connection = getConnection();

			//if(locn_type.equals("C") || locn_type.equals("D") || locn_type.equals("E") ){

			//	pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT") ) ;

			//} else if (locn_type.equals("N")  ){

			//	pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_NURSING") ) ;

			//}

			if(locn_type.equals("P")){
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_PROCEDURE") ) ;
				pstmt.setString( 1,language_id);
			}
			else{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT") ) ;

				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5,practitioner_id.trim());
				pstmt.setString( 6,locn_type.trim());
				pstmt.setString( 7,locn_type.trim());
				pstmt.setString( 8,facility_id.trim());
	     	}

			//pstmt.setString( 3,facility_id.trim());

			resultSet = pstmt.executeQuery() ;
			//System.out.println("#####resultSet="+resultSet);

			while ( resultSet != null && resultSet.next() ) {
				//System.out.println("@@@@@@@@@@@@@@@@@@");
				record = new String[2];
				//if(locn_type.equals("C") || locn_type.equals("D")){
				//record[0] = resultSet.getString( "assign_care_locn_code");
				//}else if (locn_type.equals("N") || locn_type.equals("E") ){
				//record[0] = resultSet.getString( "nursing_unit_code");
				//}

				record[0] = resultSet.getString( "code");
				record[1] = resultSet.getString( "short_desc");
				//System.out.println("record[0]="+record[0]);
				//System.out.println("record[1]="+record[1]);

				OrderCat.add(record) ;
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

		return OrderCat;
	}


//----------------------------------------------------------
//this function will populate the result frame on clik of search.

public ArrayList getResultData( String facility_id,String source_code, String source_type,String patientId,String speciality_code,String include_checkout_patients,String practitioner_id) throws Exception 
{
	/* added  String practitioner_id against 44884 */

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String patient_class = "";
		try 
		{
			if(source_type.equals(" ")) source_type = "";
			if(source_code.equals(" ")) source_code = "";
			if(patientId.equals(" ")) patientId	= "";

			connection = getConnection() ;
			if(source_type.equals("C") || source_type.equals("D") || source_type.equals("E") || source_type.equals("P") )
			{
				if(source_type.equals("C"))
					patient_class = "OP";
				else if(source_type.equals("D"))
					patient_class = "DC";
				else if(source_type.equals("E"))
					patient_class = "EM";
				else if(source_type.equals("P"))
					patient_class = "OP";
			}

			if(source_type.equals("C") || source_type.equals("E") || source_type.equals("P")) 
			{
				//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PAT_ORDER_OP_PAT_LIST") ) ;
				String sql = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PAT_ORDER_OP_PAT_LIST") ;
				
				if(include_checkout_patients.equalsIgnoreCase("Y"))
				{
					sql = sql.replace("##FILTER$$" , " and queue_status in ('00','01','02','03','04','05','06','07','09') ");
				}
				else
				{
					sql = sql.replace("##FILTER$$" , " and queue_status in ('00','01','02','03','04','05','06') ");
				}
				pstmt = connection.prepareStatement(sql);
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				//44884 Start.
				/*
				pstmt.setString( 3, facility_id ) ;
				pstmt.setString( 4, source_code);
				pstmt.setString( 5, patientId) ;
				pstmt.setString( 6, language_id) ;
				pstmt.setString( 7, speciality_code) ;
				*/
				pstmt.setString( 3, practitioner_id ) ;
				pstmt.setString( 4, facility_id ) ;
				pstmt.setString( 5, source_code);
				pstmt.setString( 6, patientId) ;
				pstmt.setString( 7, language_id) ;
				pstmt.setString( 8, speciality_code) ;
				//44884 End.

			} 
			else if (source_type.equals("D") ||source_type.equals("N"))
			{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PAT_ORDER_IP_PAT_LIST") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				//44884 Start.
				/*
				pstmt.setString( 3, facility_id ) ;
				pstmt.setString( 4, source_code) ;
				pstmt.setString( 5, patientId) ;
				pstmt.setString( 6, language_id) ;
				pstmt.setString( 7, speciality_code) ;
				pstmt.setString( 8, facility_id ) ; // GHL-SCF-989 - IN058544
				*/
				pstmt.setString( 3, practitioner_id ) ;
				pstmt.setString( 4, facility_id ) ;
				pstmt.setString( 5, source_code);
				pstmt.setString( 6, patientId) ;
				pstmt.setString( 7, language_id) ;
				pstmt.setString( 8, speciality_code) ;
				pstmt.setString( 9, facility_id ) ;
				//44884 End.
			}
			else if(source_type.equals(""))
			{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PAT_ORDER_PAT_LIST") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				//44884 Start.
				/*
				pstmt.setString( 3, facility_id ) ;
				pstmt.setString( 4, source_code) ;
				pstmt.setString( 5, patientId) ;
				pstmt.setString( 6, language_id) ;
				pstmt.setString( 7, speciality_code) ;
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, facility_id ) ;
				pstmt.setString( 11, source_code) ;
				pstmt.setString( 12, patientId) ;
				pstmt.setString( 13, language_id) ;
				pstmt.setString( 14, speciality_code) ;
				*/
				pstmt.setString( 3, practitioner_id ) ;
				pstmt.setString( 4, facility_id ) ;
				pstmt.setString( 5, source_code) ;
				pstmt.setString( 6, patientId) ;
				pstmt.setString( 7, language_id) ;
				pstmt.setString( 8, speciality_code) ;
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, practitioner_id ) ;
				pstmt.setString( 12, facility_id ) ;
				pstmt.setString( 13, source_code) ;
				pstmt.setString( 14, patientId) ;
				pstmt.setString( 15, language_id) ;
				pstmt.setString( 16, speciality_code) ;
				//44884 End.
			}



			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				//44884 Start.
				//String[] record = new String[12];
				String[] record = new String[13];
				//44884 End.
				record[0] = resultSet.getString( "patient_name" );
				record[1] = resultSet.getString( "patient_details" );
				record[2] = resultSet.getString( "patient_id" );
				record[3] = resultSet.getString( "encounter_id" );
				record[4] = resultSet.getString( "visit_adm_date_time" );
				record[5] = resultSet.getString( "practitioner_name" );
				record[6] = resultSet.getString( "patient_class" );
				record[7] = resultSet.getString( "age" );
				record[8] = resultSet.getString( "sex_details" );
				record[9] = resultSet.getString( "date_of_birth" );
				record[10] = resultSet.getString( "episode_id" );
				record[11] = resultSet.getString( "op_episode_visit_num" );
				record[12] = resultSet.getString( "practitionerRel" ); //44884

				OrderCat.add(record) ;
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

		return OrderCat;
	}

	public String getLocationDesc(String locn_code,String locn_type,String practitioner_id,String patient_class,String facility_id) throws Exception
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String LocationDesc			= "" ;

			try
			{
				connection = getConnection();
				if(locn_type.equals("P"))
				{
					pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_PROCEDURE_LOOKUP") ) ;
					pstmt.setString(1,language_id);
					pstmt.setString(2,locn_code);
					pstmt.setString(3,"%");
				}
				else
				{
					String sql = (String)OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP"); 

					if(locn_type!=null && locn_type=="D")
					{
						sql = sql.replace("##FILTER##"," and CLINIC_TYPE='Y' ");
					}
					else if(locn_type!=null && locn_type=="E")
					{
						sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='E' ");
					}
					else if(locn_type!=null && locn_type=="C")
					{
						sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='A' ");
					}
					else
					{
						sql = sql.replace("##FILTER##"," ");
					}

					pstmt = connection.prepareStatement(sql) ;
				
					pstmt.setString( 1,language_id);
					pstmt.setString( 2,language_id);
					pstmt.setString( 3,language_id);
					pstmt.setString( 4,language_id);
					pstmt.setString( 5,language_id);
					pstmt.setString( 6,practitioner_id.trim());
					pstmt.setString( 7,patient_class.trim());
					pstmt.setString( 8,facility_id.trim());
					pstmt.setString( 9,facility_id.trim());
					pstmt.setString( 10,locn_code.trim());
					pstmt.setString( 11,"%");
				}
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() )
				{
						LocationDesc=resultSet.getString("description");
				}
			} catch ( Exception e )
			{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return LocationDesc;
		}

		public String getSpecialityDesc(String speciality_code) throws Exception
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String SpecialityDesc			= "" ;

			try
			{
				connection = getConnection();

				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY") ) ;
				pstmt.setString(1,speciality_code);
				pstmt.setString(2,"%");
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() )
				{
						SpecialityDesc=resultSet.getString("description");
				}
			} catch ( Exception e )
			{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return SpecialityDesc;
		}
}//end of class

