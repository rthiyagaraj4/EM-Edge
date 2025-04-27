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
Date			Edit History	Name			Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
26/09/2011	  	27156			Menaka			?				?     			Incident No: 27156 - <Pharmacy order When amend 																				drug 
																				from authorization function for discharge medication have massage "APP-BL9022 Visit Financial Details could not be selected".>
08/06/2012	  	IN032329		Menaka V		?				?				Not able to record the authorization functions once 																			a patient is picked up from the "Referral List" in 																				CA . 	
17/01/2014		IN041996		Karthi L		21/01/2014		Dinesh			In CA-Summary Menu -Speciality- Pending Auth(9) - 																				Currently the count in this link is based on 																				patient's speciality only. 
14/03/2014      IN041644		Nijitha S											Prescription – Authorization of Drugs – Based on Rules.											
28/03/2014	    IN048202		Nijitha S										Bru-Hims-CRF-385
01/04/2014	   	IN048252		Nijitha S										Bru-Hims-CRF-385
02/04/2014		IN048317 		Nijitha S										Bru-Hims-CRF-385
02/06/2014		IN049228		Karthi L		03/06/2014		Dinesh			Based on Authorization Rights, Authorization can be done by either a senior doctor from same speciality of ordering practitioner’s speciality OR    a senior doctors from patients’ speciality.						
20/06/2014		IN049228		Karthi L		20/06/2014		Akbar			Based on Authorization Rights, Authorization can be done by either a senior doctor from same speciality of ordering practitioner’s speciality OR    a senior doctors from patients’ speciality.	
18/03/2015		IN053846		Karthi L										The prescription printing automatically without system prompting to give option to print or not when user Authorize an order using Order Authorization function.
20/06/2016		IN059086		Karthi L										ML-MMOH-CRF-0493 [IN059086]
18/04/2018		IN064980		RamyaMaddena	18/04/2018		Ramesh G					    ML-MMOH-CRF-0596 [IN064980]
25/01/2019    IN068673    DineshT           25/01/2019    Ramesh G      ML-MMOH-CRF-1263
-------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;



import eOR.ORAuthoriseOrder.*;

public class AuthoriseOrders extends eOR.Common.OrAdapter implements java.io.Serializable {


	protected String order_type_code = "";
	protected String ord_consent_reqd_yn = "";
	protected String total_records = "";
	protected String pract_id = "";
	protected String security_level = "";
	//private String priv_appl_yn = null;
	//protected  String speciality_qry = "AND SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ? UNION ALL SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ?)"; //IN041996 - Commented for IN049228
//protected  String speciality_qry = "AND SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ? UNION ALL SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? UNION ALL select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id= ord_practitioner_id)"; // IN049228
	protected  String speciality_qry = "AND (speciality_code IN (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? UNION ALL SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?) OR ((SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ord_practitioner_id) = (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ?))) "; // modified for IN049228 - Reopen
	protected  String speciality_spec_qry = "AND ((select catalog_splty_code from or_order where order_id = a.order_id) IN (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? UNION ALL SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?) OR ((SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ord_practitioner_id) = (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ?))) ";//IN068673
	protected HashMap all_final_values = new HashMap();


	protected Hashtable allValues = new Hashtable();
	//protected ArrayList persistence_details		= new ArrayList();

	//HttpServletRequest request 				= null;
	//HttpServletResponse response 			= null;


	StringBuffer traceVals = new StringBuffer();




	public void setMode(String mode){					this.mode = mode;	}
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public void setPractId(String pract_id){			this.pract_id = pract_id;	}
	public void setSecurityLevel(String security_level){this.security_level = security_level;	}

	public void setFinalValues(HashMap all_final_values){this.all_final_values = all_final_values;	}

/*	public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}
*/
	/*public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
			this.request = request;
			this.response = response;
	}*/

	/* public void setPrivAuthoriseYn(String value)
	{
		this.priv_appl_yn = checkForNull(value,"N");
	}
	 public String getPrivAuthoriseYn()
	 {
		return this.priv_appl_yn;
	 }*/

	public String getMode(){				return mode;	}
	public String getTotalRecs(){			return total_records;	}
	public String getSecurityLevel(){		return security_level;	}

	public HashMap getFinalValues(){		return all_final_values;	}
	public Hashtable getAllValues() {
        return allValues;
    }
/*	public ArrayList getDetails(){
			return persistence_details;
	}
*/
	public void clear() {
		order_type_code 			    = "";
		ord_consent_reqd_yn 			= "";
		total_records					= "";
		pract_id						= "";
		security_level					= "";
 	//	persistence_details				= null;

		super.clear();
		
 }


/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getLocation(Properties properties, String location_type, String practitioner_id, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, practitioner_id.trim() ) ;
			pstmt.setString( 4, location_type.trim() ) ;
			pstmt.setString( 5, facility_id.trim() ) ;
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "locn_short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will value of Authorise required field ("Yes / No")
	@return		:	String
*/

	public String getAuthYN(Properties properties, String practitioner_id, String resp_id,String priv_appl_yn) throws Exception {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String  auth_yn= "";

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_AUTH_YN") ) ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_PRACT_CAN_AUTH_YN") ) ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id) ;
			pstmt.setString( 3, priv_appl_yn) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				auth_yn = resultSet.getString( "auth_yn" )  ;
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return auth_yn;
	}


/**

	@return		:	String
*/

	public String getVisitAdmnDate(String facility_id, String encntr_id) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String  vist_adm_Date= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_VISIT_ADMN_DT") ) ;
			pstmt.setString( 1, facility_id.trim() ) ;
			pstmt.setString( 2, encntr_id) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				vist_adm_Date = resultSet.getString( "vist_adm_Date" )  ;
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return vist_adm_Date;
	}



/**
	This will populate all the Status list by priority
	@return		:	ArrayList
*/

    public ArrayList getStatusByPriority(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to, String functionID,String filter,String priv_appl_yn,String Inc_Force_Auth,String auth_filter) throws Exception {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		String auth_ord_priv_rule_only_yn = "N"; //ML-MMOH-CRF-0493 [IN059086] 
		//String priv_appl_yn = "N";
		//priv_appl_yn = (String)getPrivAuthoriseYn();
		String l_include_sec_splty = "";//IN068673

		int srlno =1;
		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			//if(patientId==null || patientId.equals(" ")) patientId = "";//IN032329
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(period_from==null || period_from.equals(" ")) period_from = "";
			if(period_to==null || period_to.equals(" ")) period_to = "";
			if(filter==null || filter.equals(" ")) filter = "";
			/* Thai date validations start 14/02/2007*/
			if (!language_id.equals("en")){
			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
			period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 14/02/2007*/
			/*07/02/19 09:23:26 ##########facility_id::HS, source_type::, source_code::, practitioner_id::CER2, resp_id=CA,  patientId::, period_from::12/02/2007, period_to::19/02/2007, PriorityData.size()::0*/
			auth_ord_priv_rule_only_yn = getAuthOrdPrivRuleOnlyYN();  //ML-MMOH-CRF-0493 [IN059086]
			l_include_sec_splty = getOrParamByColumnName("PEND_AUTH_INCL_SEC_SPLTY_YN");//IN068673
			connection			= ConnectionManager.getConnection(properties) ;
			//IN032329 Starts
			//sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_PRIORITY_AUTH");//IN032329
			//sql="SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and  nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)), nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?), nvl(a.source_CODE,'XX')) and a.patient_id = nvl(?,a.patient_id) and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999   ##FILTER4$$ ##FILTER$$  ##FILTER2$$ Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3') ";//IN068673
			sql="SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and  nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)), nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?), nvl(a.source_CODE,'XX')) and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999   ##FILTER4$$ ##FILTER$$  ##FILTER2$$ Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3') ";//IN068673
			if(patientId==null)
			{
				if("Y".equals(auth_ord_priv_rule_only_yn)) { //ML-MMOH-CRF-0493 [IN059086] - Start 
					sql=sql.replace("##FILTER4$$"," ");
				}	 
				else { //ML-MMOH-CRF-0493 [IN059086] - End
					//sql=sql.replace("##FILTER4$$"," and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");//IN068673
					sql=sql.replace("##FILTER4$$"," and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");//IN068673
				} //ML-MMOH-CRF-0493 [IN059086]
			}
			else 
			{
				//IN068673, starts
				//sql=sql.replace("##FILTER4$$"," and a.patient_id = ?  ");//IN068673
				if("Y".equals(auth_ord_priv_rule_only_yn)) {
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? ");
				}
				else
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");
				//IN068673, ends
			}
			//IN032329 ends
			//if("Y".equals(auth_ord_priv_rule_only_yn)) { //ML-MMOH-CRF-0493 [IN059086] - Start//IN068673
				//sql=sql.replace("##FILTER$$"," ");//IN068673
			//}else { //condition added for ML-MMOH-CRF-0493 [IN059086] - End//IN068673
				if (filter.equals("S"))//Self
				{
					sql=sql.replace("##FILTER$$"," and ord_practitioner_id=? ");
				}
				else if(filter.equals("MS"))//My speciality
				{
					//IN068673, starts
					//sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=?)");
					if("Y".equals(l_include_sec_splty))
						sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=? UNION ALL SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?)");
					else
						sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=?)");
					//IN068673, ends
				}
				else if (filter.equals("P"))//Speciality specific
				{
					 //sql=sql.replace("##FILTER$$"," and speciality_code IS NOT NULL "); //IN049228
					  //sql=sql.replace("##FILTER$$",speciality_qry); //IN049228//IN068673
					  sql=sql.replace("##FILTER$$",speciality_spec_qry); //IN049228//IN068673
				}
				else//All
				{
					//sql=sql.replace("##FILTER$$","");//IN041996 
					sql=sql.replace("##FILTER$$", speciality_qry);//IN041996 
				}
			//}  // condition added for ML-MMOH-CRF-0493 [IN059086]//IN068673
			if (priv_appl_yn.equals("N"))
			{
				sql=sql.replace("##FILTER2$$"," AND a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND AUTH_YN = 'Y') ##FILTER3$$ ");
			}
			else
			{
				sql=sql.replace("##FILTER2$$"," AND OR_GET_PRIV_APPL_YN(?,?,'AU',A.ORDER_CATALOG_CODE,?,A.ORDER_TYPE,A.ORDER_CATEGORY )='Y'  ##FILTER3$$ ");
			}
			if (Inc_Force_Auth.equals("N"))
			{
				sql=sql.replace("##FILTER3$$", " AND FORCE_AUTH_YN='N' " );
			}
			else
			{
				if (auth_filter.equals("M"))
				{
					sql=sql.replace("##FILTER3$$", " AND (A.FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y' AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID= ? ) AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );
				}
				else if (auth_filter.equals("R"))
				{
					sql=sql.replace("##FILTER3$$", " AND ( A.FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y' AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01'  ) AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );

				}
				else
				{
					sql=sql.replace("##FILTER3$$", " AND (A. FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y'  AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );
				}

			}
			/*
				commented by Deepa on 2/5/2010 at 11:11 AM for log file corrections for emergency release
			*/

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString( srlno++, functionID );
			
			pstmt.setString( srlno++, ord_facility.trim() );
			
			pstmt.setString( srlno++, source_type );
			
			pstmt.setString( srlno++, source_type );
			
			pstmt.setString( srlno++, source_code );
			
			//pstmt.setString( srlno++, patientId );//IN068673
			
			pstmt.setString( srlno++, period_from) ;
			
			pstmt.setString( srlno++, period_to) ;
			//IN032329 Starts
			//pstmt.setString( srlno++, ord_facility.trim()) ;
			//System.out.println("308 AuthoriseOrders.java ord_facility.trim()==>"+ord_facility.trim());
			//pstmt.setString( srlno++, practitioner_id.trim() ) ;
			//System.out.println("308 AuthoriseOrders.java practitioner_id.trim()==>"+practitioner_id.trim());
			if(patientId==null)
			{
				if("N".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] 
					pstmt.setString( srlno++, ord_facility.trim()) ;
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
				}		//condition added for ML-MMOH-CRF-0493 [IN059086]
			}
			else
			{			
				pstmt.setString( srlno++, patientId) ;
				//IN068673, starts
				if("N".equals(auth_ord_priv_rule_only_yn)) {
					pstmt.setString( srlno++, ord_facility.trim()) ;
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
				}
				//IN068673, ends
			}
			//IN032329 Ends
			//pstmt.setString( srlno++, practitioner_id.trim() ) ;
			//pstmt.setString( srlno++, resp_id.trim() ) ;
			//pstmt.setString( srlno++, functionID );
			//if("N".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] //IN068673
				//if (filter.equals("S") || filter.equals("MS"))//IN068673
				if (filter.equals("S"))//IN068673
				{
					pstmt.setString( srlno++, practitioner_id.trim() );
				}
				
				//if (filter.equals("")|| filter.equals("P") )//IN068673
				if(filter.equals("MS"))//IN068673
				{
					pstmt.setString( srlno++, practitioner_id.trim() );
					if("Y".equals(l_include_sec_splty))//IN068673
					{
						pstmt.setString( srlno++, ord_facility.trim() );
						pstmt.setString( srlno++, practitioner_id.trim() );
					}
				}
				//IN041996 - Start
				if (filter.equals("")|| filter.equals("P") )  // filter.equals("P") added for IN049228
				{
					pstmt.setString( srlno++, practitioner_id.trim() );
					pstmt.setString( srlno++, ord_facility.trim() );
					pstmt.setString( srlno++, practitioner_id.trim() );
					pstmt.setString( srlno++, practitioner_id.trim() ); // added for IN049228 - Reopen
				} 
				//IN041996 -  End
			//}		//condition added for ML-MMOH-CRF-0493 [IN059086]//IN068673
			if (priv_appl_yn.equals("N"))
			{
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
					
					pstmt.setString( srlno++, resp_id.trim() ) ;
					
			}
			else
			{
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
					
					pstmt.setString( srlno++, resp_id.trim() ) ;
					
					pstmt.setString( srlno++, priv_appl_yn);
				
			}
			if (!Inc_Force_Auth.equals("N") )
			{
				pstmt.setString( srlno++, practitioner_id.trim() ) ;
				
				if( auth_filter.equals("M") ||  auth_filter.equals("R") )
				{
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
					
				}
			}

			resultSet = pstmt.executeQuery() ;
			int abc=0;
			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "PRIORITY" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;
				record[2] = resultSet.getString( "PRIORITY" )  ;
				abc++;	
				OrderCat.add(record) ;
			}


		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public ArrayList getStatusByCategory(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to,String functionID,String filter,String priv_appl_yn,String Inc_Force_Auth,String auth_filter) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		//String priv_appl_yn = "N";
		//priv_appl_yn = (String)getPrivAuthoriseYn();
		String auth_ord_priv_rule_only_yn = "N"; //ML-MMOH-CRF-0493 [IN059086] 
		String sql="";
		int srlno =1;
		String l_include_sec_splty = "";
		try {
			auth_ord_priv_rule_only_yn = getAuthOrdPrivRuleOnlyYN();  //ML-MMOH-CRF-0493 [IN059086] 
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			//if(patientId==null || patientId.equals("")) patientId = "";//IN032329
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(period_from==null || period_from.equals(" ")) period_from = "";
			if(period_to==null || period_to.equals(" ")) period_to = "";
			if(filter==null || filter.equals(" ")) filter = "";
	/* Thai date validations start 14/02/2007*/
	if (!language_id.equals("en")){
			period_from =  com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
			period_to =  com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
	}
/* Thai date validations end 14/02/2007*/
	
			l_include_sec_splty = getOrParamByColumnName("PEND_AUTH_INCL_SEC_SPLTY_YN");//IN068673
			connection			= ConnectionManager.getConnection(properties) ;
			//IN032329 Starts
			//sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_CATEGORY_AUTH");
			//sql="SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')   short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=?  and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)),nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?),nvl(a.source_CODE,'XX')) AND  a.patient_id = nvl(?, a.patient_id) and  a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+0.99999 ##FILTER4$$ ##FILTER$$  ##FILTER2$$ Group by  a.order_category Order by 1";//IN049228
			sql="SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')   short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=?  and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)),nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?),nvl(a.source_CODE,'XX')) AND a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+0.99999 ##FILTER4$$ ##FILTER$$  ##FILTER2$$ Group by  a.order_category Order by 1";//IN049228
			
			if(patientId==null)
			{
				if("Y".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] - Start
					sql=sql.replace("##FILTER4$$", " ");
				} else { //condition added for ML-MMOH-CRF-0493 [IN059086] - End	
					//sql=sql.replace("##FILTER4$$"," and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");//IN049228
					sql=sql.replace("##FILTER4$$"," and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");//IN049228
				}	//condition added for ML-MMOH-CRF-0493 [IN059086]
			}
			else 
			{
				//IN049228, starts
				//sql=sql.replace("##FILTER4$$"," and a.patient_id = ?  ");
				if("Y".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] - Start
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? ");
				} else { //condition added for ML-MMOH-CRF-0493 [IN059086] - End	
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");
				}
				//IN049228, ends
			}
			//IN032329 Ends
			//if("Y".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] - Start
				//sql=sql.replace("##FILTER$$"," ");
			//} else {	//condition added for ML-MMOH-CRF-0493 [IN059086] - End
				if (filter.equals("S"))
				{
					sql=sql.replace("##FILTER$$"," and ord_practitioner_id=?");
				}
				else if(filter.equals("MS"))
				{
					//sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=?)");
					if("Y".equals(l_include_sec_splty))
					sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=? UNION ALL SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?)");
					else
					sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=?)");
				}
				else if (filter.equals("P"))
				{
					 //sql=sql.replace("##FILTER$$"," and speciality_code IS NOT NULL "); //IN049228
					  sql=sql.replace("##FILTER$$",speciality_spec_qry); //IN049228
				}
				else
				{
					//sql=sql.replace("##FILTER$$",""); //IN041996 
	                sql=sql.replace("##FILTER$$",speciality_qry); //IN041996           
				}
			//}		//condition added for ML-MMOH-CRF-0493 [IN059086]
			if (priv_appl_yn.equals("N"))
			{
				sql=sql.replace("##FILTER2$$"," AND a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND AUTH_YN = 'Y') ##FILTER3$$ ");
			}
			else
			{
				sql=sql.replace("##FILTER2$$"," AND OR_GET_PRIV_APPL_YN(?,?,'AU',A.ORDER_CATALOG_CODE,?,A.ORDER_TYPE,A.ORDER_CATEGORY )='Y' ##FILTER3$$ ");
			}
			// shaiju starts
			if (Inc_Force_Auth.equals("N"))
			{
				sql=sql.replace("##FILTER3$$", " AND FORCE_AUTH_YN='N' " );
			}
			else
			{
				if (auth_filter.equals("M"))
				{
					sql=sql.replace("##FILTER3$$", " AND (A.FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y' AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID= ? ) AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );
				}
				else if (auth_filter.equals("R"))
				{
					sql=sql.replace("##FILTER3$$", " AND ( A.FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y' AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01'  ) AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );

				}
				else
				{
					sql=sql.replace("##FILTER3$$", " AND (A. FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y'  AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );
				}

			}

			
			//shaiju ends


			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString( srlno++, language_id );
			pstmt.setString( srlno++, functionID );
			pstmt.setString( srlno++, ord_facility.trim() );
			pstmt.setString( srlno++, source_type );
			pstmt.setString( srlno++, source_type );
			pstmt.setString( srlno++, source_code );
			//pstmt.setString( srlno++, patientId );//IN032329
			pstmt.setString( srlno++, period_from) ;
			pstmt.setString( srlno++, period_to) ;
			//IN032329 Starts
			//pstmt.setString( srlno++, ord_facility.trim()) ;
			//pstmt.setString( srlno++, practitioner_id.trim() ) ;
			if(patientId==null)
			{
				if("N".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] 
					pstmt.setString( srlno++, ord_facility.trim()) ;
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
				}		//condition added for ML-MMOH-CRF-0493 [IN059086]	
			}
			else
			{			
				pstmt.setString( srlno++, patientId) ;
				if("N".equals(auth_ord_priv_rule_only_yn)) {
					pstmt.setString( srlno++, ord_facility.trim()) ;
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
				}
			}
			//IN032329 Ends
		/*	pstmt.setString( srlno++, practitioner_id.trim() ) ;
			pstmt.setString( srlno++, resp_id.trim() ) ;
			pstmt.setString( srlno++, functionID );*/
			//if("N".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086]
				//if (filter.equals("S") || filter.equals("MS"))
				if (filter.equals("S"))
				{
					pstmt.setString( srlno++, practitioner_id.trim() );
				}
				
				if(filter.equals("MS"))
				{
					pstmt.setString( srlno++, practitioner_id.trim() );
					if("Y".equals(l_include_sec_splty))
					{
						 pstmt.setString( srlno++, ord_facility.trim() );
			             pstmt.setString( srlno++, practitioner_id.trim() );
					}
				}
				
				//IN041996 - Start
	            if (filter.equals("")|| filter.equals("P"))  // filter.equals("P") added for IN049228
	            {
	                pstmt.setString( srlno++, practitioner_id.trim() );
	                pstmt.setString( srlno++, ord_facility.trim() );
	                pstmt.setString( srlno++, practitioner_id.trim() );
					pstmt.setString( srlno++, practitioner_id.trim() ); // added for IN049228 - Reopen
	            } 
	            //IN041996 -  End
			//}	//condition added for ML-MMOH-CRF-0493 [IN059086]//IN068673
			if (priv_appl_yn.equals("N"))
			{
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
					pstmt.setString( srlno++, resp_id.trim() ) ;
			}
			else
			{
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
					pstmt.setString( srlno++, resp_id.trim() ) ;
					pstmt.setString( srlno++,priv_appl_yn);
			}

			if (!Inc_Force_Auth.equals("N") )
			{
				pstmt.setString( srlno++, practitioner_id.trim() ) ;
				if( auth_filter.equals("M") ||  auth_filter.equals("R") )
				{
					pstmt.setString( srlno++, practitioner_id.trim() ) ;
				}
			}


			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "short_description" )  ;
				record[1] = resultSet.getString( "ord_cat" )  ;
				record[2] = resultSet.getString( "no_of_rec" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public ArrayList	getStatusByDetail( String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String functionID,String filter,String priv_appl_yn,String Inc_Force_Auth,String auth_filter) throws Exception {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		//String priv_appl_yn = "N";
		//priv_appl_yn = (String)getPrivAuthoriseYn();
		int reccount = 0;
		String auth_ord_priv_rule_only_yn = "N"; //ML-MMOH-CRF-0493 [IN059086] 
 		//int total_records			= 0;
		String l_include_sec_splty = "";//IN068673

		try {
			auth_ord_priv_rule_only_yn = getAuthOrdPrivRuleOnlyYN();  //ML-MMOH-CRF-0493 [IN059086] 
			l_include_sec_splty = getOrParamByColumnName("PEND_AUTH_INCL_SEC_SPLTY_YN");//IN068673
			
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(priority.equals(" ")) priority = null;
			if(ord_cat.equals(" ")) ord_cat = null;
			if(order_by.equals(" ")) order_by = null;
			//if(patientId==null || patientId.equals(" ")) patientId = "";//IN032329
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(period_from==null || period_from.equals(" ")) period_from = "";
			if(period_to==null || period_to.equals(" ")) period_to = "";
			if(filter==null || filter.equals(" ")) filter = "";
			/* Thai date validations start 14/02/2007*/
			if (!language_id.equals("en")){
			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
			period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 14/02/2007*/
			connection			= getConnection() ;
			//sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_DTL_AUTH");
			//sql = "SELECT   a.order_category order_category,         or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR ( ORDER_DATE,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type, ?) order_detail,DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name, a.source_type source_type, a.source_code source_code, a.priority priority, a.order_type order_type,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,sex, date_of_birth,get_age (date_of_birth) age,NVL (a.cont_order_ind, 'DO') cont_order_ind,c.ord_appr_reqd_yn ord_appr_reqd_yn, c.ord_appr_by_user_id ord_appr_by_user_id,c.ord_consent_reqd_yn ord_consent_reqd_yn, c.ord_consent_by_id ord_consent_by_id,c.ORDER_STATUS ORDER_STATUS,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,AM_GET_DESC.AM_speciality(speciality_code,?,'2') speciality_desc,speciality_code  speciality_code,c.order_set_id order_set_id,or_get_appl_task_access_rights ('AMEND_ORDER' ,?,?,     ?,?,c.order_id) AMEND_ORDER_YN,or_get_appl_task_access_rights ('CANCEL_ORDER' ,?,?,?,?,c.order_id) CANCEL_ORDER_YN FROM OR_ORDER_PEND_STATUS_LOG a, mp_patient b, or_order c WHERE a.order_id=c.order_id and a.patient_id=c.patient_id and a.PEND_STATUS_IND=?  and a.patient_id=b.patient_id and a.patient_id = NVL (?, a.patient_id) AND a.ordering_facility_id = (?)  AND NVL (a.source_type, 'XX') = NVL (DECODE ((?), 'W', 'N', (?)), NVL (a.source_type, 'XX'))  AND NVL (a.source_code, 'XX') = NVL ((?), NVL (a.source_code, 'XX')) AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) and a.order_category =nvl((?),a.order_category) AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL )  and substr(a.order_id,1,2)!='CS' AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND  ORDER_DATE  BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 ##FILTER$$  ##FILTER2$$ ORDER BY DECODE ((?),'P', DECODE (priority, 'S', '1','U', '2', 'R', '3'),'O', order_category),DECODE ((?),'O', DECODE (priority,'S', '1', 'U', '2','R', '3',ORDER_DATE))";
			//IN032329 Starts
			//sql = "SELECT   a.order_category order_category,         or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR ( ORDER_DATE,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type, ?) order_detail,DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name, a.source_type source_type, a.source_code source_code, a.priority priority, a.order_type order_type,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,sex, date_of_birth,get_age (date_of_birth) age,NVL (a.cont_order_ind, 'DO') cont_order_ind,c.ord_appr_reqd_yn ord_appr_reqd_yn, c.ord_appr_by_user_id ord_appr_by_user_id,c.ord_consent_reqd_yn ord_consent_reqd_yn, c.ord_consent_by_id ord_consent_by_id,c.ORDER_STATUS ORDER_STATUS,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,AM_GET_DESC.AM_speciality(speciality_code,?,'2') speciality_desc,speciality_code  speciality_code,c.order_set_id order_set_id,or_get_appl_task_access_rights ('AMEND_ORDER' ,?,?,     ?,?,c.order_id) AMEND_ORDER_YN,or_get_appl_task_access_rights ('CANCEL_ORDER' ,?,?,?,?,c.order_id) CANCEL_ORDER_YN,C.DISCHARGE_IND FROM OR_ORDER_PEND_STATUS_LOG a, mp_patient b, or_order c WHERE a.order_id=c.order_id and a.patient_id=c.patient_id and a.PEND_STATUS_IND=?  and a.patient_id=b.patient_id and a.patient_id = NVL (?, a.patient_id) AND a.ordering_facility_id = (?)  AND NVL (a.source_type, 'XX') = NVL (DECODE ((?), 'W', 'N', (?)), NVL (a.source_type, 'XX'))  AND NVL (a.source_code, 'XX') = NVL ((?), NVL (a.source_code, 'XX')) AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) and a.order_category =nvl((?),a.order_category) AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL )  and substr(a.order_id,1,2)!='CS' AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND  ORDER_DATE  BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 ##FILTER$$  ##FILTER2$$ ORDER BY DECODE ((?),'P', DECODE (priority, 'S', '1','U', '2', 'R', '3'),'O', order_category),DECODE ((?),'O', DECODE (priority,'S', '1', 'U', '2','R', '3',ORDER_DATE))"; 	 //27156
			//sql = "SELECT   a.order_category order_category,         or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR ( ORDER_DATE,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type, ?) order_detail,DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name, a.source_type source_type, a.source_code source_code, a.priority priority, a.order_type order_type,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,sex, date_of_birth,get_age (date_of_birth) age,NVL (a.cont_order_ind, 'DO') cont_order_ind,c.ord_appr_reqd_yn ord_appr_reqd_yn, c.ord_appr_by_user_id ord_appr_by_user_id,c.ord_consent_reqd_yn ord_consent_reqd_yn, c.ord_consent_by_id ord_consent_by_id,c.ORDER_STATUS ORDER_STATUS,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,AM_GET_DESC.AM_speciality(speciality_code,?,'2') speciality_desc,speciality_code  speciality_code,c.order_set_id order_set_id,or_get_appl_task_access_rights ('AMEND_ORDER' ,?,?,     ?,?,c.order_id) AMEND_ORDER_YN,or_get_appl_task_access_rights ('CANCEL_ORDER' ,?,?,?,?,c.order_id) CANCEL_ORDER_YN,C.DISCHARGE_IND FROM OR_ORDER_PEND_STATUS_LOG a, mp_patient b, or_order c WHERE a.order_id=c.order_id and a.patient_id=c.patient_id and a.PEND_STATUS_IND=?  and a.patient_id=b.patient_id and a.patient_id = NVL (?, a.patient_id) AND a.ordering_facility_id = (?)  AND NVL (a.source_type, 'XX') = NVL (DECODE ((?), 'W', 'N', (?)), NVL (a.source_type, 'XX'))  AND NVL (a.source_code, 'XX') = NVL ((?), NVL (a.source_code, 'XX')) AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) and a.order_category =nvl((?),a.order_category) ##FILTER4$$  and substr(a.order_id,1,2)!='CS' AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND  ORDER_DATE  BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 ##FILTER$$  ##FILTER2$$ ORDER BY DECODE ((?),'P', DECODE (priority, 'S', '1','U', '2', 'R', '3'),'O', order_category),DECODE ((?),'O', DECODE (priority,'S', '1', 'U', '2','R', '3',ORDER_DATE))";//Commented for IN041644
			sql = "SELECT   a.order_category order_category,         or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR ( ORDER_DATE,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type, ?) order_detail,DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name, a.source_type source_type, a.source_code source_code, a.priority priority, a.order_type order_type,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,sex, date_of_birth,get_age (date_of_birth) age,NVL (a.cont_order_ind, 'DO') cont_order_ind,c.ord_appr_reqd_yn ord_appr_reqd_yn, c.ord_appr_by_user_id ord_appr_by_user_id,c.ord_consent_reqd_yn ord_consent_reqd_yn, c.ord_consent_by_id ord_consent_by_id,c.ORDER_STATUS ORDER_STATUS,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,AM_GET_DESC.AM_speciality(speciality_code,?,'2') speciality_desc,speciality_code  speciality_code,c.order_set_id order_set_id,or_get_appl_task_access_rights ('AMEND_ORDER' ,?,?,     ?,?,c.order_id) AMEND_ORDER_YN,or_get_appl_task_access_rights ('CANCEL_ORDER' ,?,?,?,?,c.order_id) CANCEL_ORDER_YN,C.DISCHARGE_IND,C.ORDERING_FACILITY_ID,c.ORD_PRACT_ID,c.ORD_AUTH_REQD_YN FROM OR_ORDER_PEND_STATUS_LOG a, mp_patient b, or_order c WHERE a.order_id=c.order_id and a.patient_id=c.patient_id and a.PEND_STATUS_IND=?  and a.patient_id=b.patient_id and a.patient_id = NVL (?, a.patient_id) AND a.ordering_facility_id = (?)  AND NVL (a.source_type, 'XX') = NVL (DECODE ((?), 'W', 'N', (?)), NVL (a.source_type, 'XX'))  AND NVL (a.source_code, 'XX') = NVL ((?), NVL (a.source_code, 'XX')) AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) and a.order_category =nvl((?),a.order_category) ##FILTER4$$  and substr(a.order_id,1,2)!='CS' AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND  ORDER_DATE  BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 ##FILTER$$  ##FILTER2$$ ORDER BY DECODE ((?),'P', DECODE (priority, 'S', '1','U', '2', 'R', '3'),'O', order_category),DECODE ((?),'O', DECODE (priority,'S', '1', 'U', '2','R', '3',ORDER_DATE))";//IN041644
			
			if(patientId==null)
			{
				if("Y".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] - Start 
					sql=sql.replace("##FILTER4$$"," ");
				} else { //condition added for ML-MMOH-CRF-0493 [IN059086] - End	
					//sql=sql.replace("##FILTER4$$"," AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL ) ");//IN068673
					sql=sql.replace("##FILTER4$$"," AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE facility_id = ? and practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL ) ");//IN068673
				}		//condition added for ML-MMOH-CRF-0493 [IN059086]
			}
			else 
			{
				//IN068673, starts
				//sql=sql.replace("##FILTER4$$"," and a.patient_id = ?  ");
				if("Y".equals(auth_ord_priv_rule_only_yn)) {
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? ");
				}
				else
				{
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE facility_id = ? and practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL ) ");
				}
				//IN068673, ends
			}
			//IN032329 Ends
			/*if("Y".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] - Start//IN068673
				sql=sql.replace("##FILTER$$"," ");//IN068673
			} else  {*/	//condition added for ML-MMOH-CRF-0493 [IN059086] - End//IN068673
				if (filter.equals("S"))
				{
					sql=sql.replace("##FILTER$$"," and ord_practitioner_id=?");
				}
				else if(filter.equals("MS"))
				{
					//IN068673, starts
					//sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=?)");
					if("Y".equals(l_include_sec_splty))
						sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=? UNION ALL SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?)");
					else
						sql=sql.replace("##FILTER$$"," and speciality_code in (select primary_speciality_code from am_practitioner where practitioner_id=?)");
					//IN068673, ends
				}
				else if (filter.equals("P"))
				{
					 //sql=sql.replace("##FILTER$$"," and speciality_code IS NOT NULL "); //IN041996 //IN068673
					 // sql=sql.replace("##FILTER$$",speciality_qry); //IN049228//IN068673
					 sql=sql.replace("##FILTER$$",speciality_spec_qry); //IN049228//IN068673
				}
				else
				{
					//sql=sql.replace("##FILTER$$",""); //IN041996 
	                sql=sql.replace("##FILTER$$",speciality_qry); //IN041996   
				}
			//}		//condition added for ML-MMOH-CRF-0493 [IN059086]//IN068673
			if (priv_appl_yn.equals("N"))
			{
				sql=sql.replace("##FILTER2$$"," AND a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND AUTH_YN = 'Y') ##FILTER3$$ ");
			}
			else
			{
				sql=sql.replace("##FILTER2$$"," AND OR_GET_PRIV_APPL_YN(?,?,'AU',A.ORDER_CATALOG_CODE,?,A.ORDER_TYPE,A.ORDER_CATEGORY )='Y' ##FILTER3$$ ");
			}

			// shaiju starts
			if (Inc_Force_Auth.equals("N"))
			{
				sql=sql.replace("##FILTER3$$", " AND FORCE_AUTH_YN='N' " );
			}
			else
			{
				if (auth_filter.equals("M"))
				{
					sql=sql.replace("##FILTER3$$", " AND (A.FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y' AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID= ? ) AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );
				}
				else if (auth_filter.equals("R"))
				{
					sql=sql.replace("##FILTER3$$", " AND ( A.FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y' AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01'  ) AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );

				}
				else
				{
					sql=sql.replace("##FILTER3$$", " AND (A. FORCE_AUTH_YN='N'  OR (A.FORCE_AUTH_YN='Y'  AND EXISTS (SELECT 1 FROM AM_PRACTITIONER IIA ,OR_ORD_RULE_BY_PRACT IIB WHERE IIA.PRACTITIONER_ID=?  AND IIB.PRACT_TYPE=IIA.PRACT_TYPE AND  IIB.ORDER_CATEGORY_CODE=A.ORDER_CATEGORY  AND IIB.FORCE_AUTH_YN='AF' ) )) " );
				}
			}			
			//shaiju ends			

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);
			/*pstmt.setString(++reccount, login_facility_id);
			pstmt.setString(++reccount, login_by_id);
			pstmt.setString(++reccount, resp_id.trim());
			pstmt.setString(++reccount, practitioner_id.trim());*/
			pstmt.setString(++reccount, language_id);

			pstmt.setString(++reccount, resp_id.trim());
			pstmt.setString(++reccount, "");
			pstmt.setString(++reccount, ord_facility);
			pstmt.setString(++reccount, practitioner_id.trim());

			pstmt.setString(++reccount, resp_id.trim());
			pstmt.setString(++reccount, "");
			pstmt.setString(++reccount, ord_facility);
			pstmt.setString(++reccount, practitioner_id.trim());
			
			pstmt.setString(++reccount, functionID);
			pstmt.setString(++reccount, patientId);
			pstmt.setString(++reccount, ord_facility ) ;
			pstmt.setString(++reccount, source_type ) ;
			pstmt.setString(++reccount, source_type ) ;
			pstmt.setString(++reccount, source_code) ;
			pstmt.setString(++reccount, priority) ;
			pstmt.setString(++reccount, ord_cat) ;
			//IN032329 Starts
			//pstmt.setString(++reccount, practitioner_id.trim() ) ;
			if(patientId==null)
			{
				//if("N".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086] 
				if("N".equals(auth_ord_priv_rule_only_yn)) {
					pstmt.setString( ++reccount, ord_facility);//IN068673
					pstmt.setString( ++reccount, practitioner_id.trim() ) ;
				}		//condition added for ML-MMOH-CRF-0493 [IN059086]	
			}
			else
			{
				//IN068673, starts
				pstmt.setString( ++reccount, patientId);
				if("N".equals(auth_ord_priv_rule_only_yn)) {
					pstmt.setString( ++reccount, ord_facility);//IN068673
					pstmt.setString( ++reccount, practitioner_id.trim() ) ;
				}
				//IN068673, ends
			}
			//IN032329 Ends
			pstmt.setString(++reccount, period_from);
			pstmt.setString(++reccount, period_to);
			//if("N".equals(auth_ord_priv_rule_only_yn)) { //condition added for ML-MMOH-CRF-0493 [IN059086]//IN068673
				///if (filter.equals("S") || filter.equals("MS"))//IN068673
				if (filter.equals("S"))//IN068673
				{
					pstmt.setString(++reccount, practitioner_id.trim() );
				}
				
				//if (filter.equals("") || filter.equals("P") ) //IN068673
				if(filter.equals("MS"))//IN068673
				{
					pstmt.setString(++reccount, practitioner_id.trim() );
					//IN068673, starts
					if("Y".equals(l_include_sec_splty))
					{
						pstmt.setString( ++reccount, ord_facility );
						pstmt.setString( ++reccount, practitioner_id.trim() );
					}
					//IN068673, ends
				}
				  
	            //IN041996 - Start
		        if (filter.equals("") || filter.equals("P") )  // filter.equals("P") added for IN049228
		        {
		            pstmt.setString( ++reccount, practitioner_id.trim() );
		            pstmt.setString( ++reccount, ord_facility );
					pstmt.setString( ++reccount, practitioner_id.trim() );
					pstmt.setString( ++reccount, practitioner_id.trim() ); // added for IN049228 - Reopen
		        } 
		        //IN041996 -  End
			//}		//condition added for ML-MMOH-CRF-0493 [IN059086]//IN068673
			if (priv_appl_yn.equals("N"))
			{
				pstmt.setString( ++reccount, practitioner_id.trim() ) ;
				pstmt.setString( ++reccount, resp_id.trim() ) ;
			}
			else
			{
				pstmt.setString( ++reccount, practitioner_id.trim() ) ;
				pstmt.setString( ++reccount, resp_id.trim() ) ;
				pstmt.setString( ++reccount,priv_appl_yn);
			}
			
			if (!Inc_Force_Auth.equals("N") )
			{
				pstmt.setString(++reccount , practitioner_id.trim() ) ;
				if( auth_filter.equals("M") ||  auth_filter.equals("R") )
				{
					pstmt.setString(++reccount , practitioner_id.trim() ) ;
				}
			}
			
			pstmt.setString(++reccount, order_by) ;
			pstmt.setString(++reccount, order_by) ;
			
			resultSet = pstmt.executeQuery() ;

			//if(resultSet!=null) {
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
 			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				while ( start <= end && resultSet!=null && resultSet.next()) {
  				 		//String[] record = new String[37]; //27156 //IN041644
					String[] record = new String[40]; //IN041644
						record[0] = checkForNull(resultSet.getString( "order_category" ),"")   ;
						record[1] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "location_description" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "PATIENT_NAME" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "ORDERING_PRACT_NAME" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "Priority" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "source_code" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "order_type" ),"")  ;
						record[17] = checkForNull(resultSet.getString( "order_status" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[19] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[20] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[21] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "sex" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "age" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
						record[25] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
						record[26] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
						record[27] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[28] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
						//record[29] = checkForNull(resultSet.getString( "privilege_yn" ),"");
						record[29] = checkForNull(resultSet.getString( "speciality_desc" ),"");
						record[30] = checkForNull(resultSet.getString( "speciality_code" ),"");
						record[31] = checkForNull(resultSet.getString( "order_set_id" ),"");
						record[34] = checkForNull(resultSet.getString( "AMEND_ORDER_YN" ),"X");
						record[35] = checkForNull(resultSet.getString( "CANCEL_ORDER_YN" ),"X");
						record[36] = checkForNull(resultSet.getString( "DISCHARGE_IND" ),""); //27156
						//IN041644 Starts
						record[37] = checkForNull(resultSet.getString( "ORDERING_FACILITY_ID" ),""); 
						record[38] = checkForNull(resultSet.getString( "ORD_PRACT_ID" ),""); 
						record[39] = checkForNull(resultSet.getString( "ORD_AUTH_REQD_YN" ),""); 
						//IN041644 Ends
						//record[30] = String.valueOf(total_records);

						OrderCat.add(record) ;
						start++;
 				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					templist[33] = ""+(end+7);
					OrderCat.set(0,templist);
				}
			//}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCat;
	}

public HashMap insert(){


		HashMap map = new HashMap() ;

        map.put( "result", new Boolean( false ) ) ;
		try{
			map = authoriseOrder();
		}catch(Exception e){
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}

		return map;
}

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public HashMap authoriseOrder() throws Exception {


		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet1 			= null;

		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;

		String regn_reqd_yn			= "";
		String order_status_code 	= "";
		String order_id = "";
		String cont_order_ind = "";
		String which_page = "";

		String ord_appr_by_user_id = "";
		String ord_appr_reqd_yn = "";
		String order_category = "";
		//String lab_install_yn	= "";changed on 7/18/2007 for lab_install_yn by uma
		String rd_install_yn    = "";
		String labchk="";
		String[] record1 = null;
		String order_set_id="";
		String order_set_bill_yn="";

		//IN041644 Starts
		String patient_id = "";
		String encounter_id = "";
		String order_date_time = "";
		String ordering_pract_id = "";
		String ordering_facility_id = "";
		String ord_catalog = "";
		String ord_auth_reqd_yn = "";
		String or_order_line = "";
		String order_type="";//IN048317
		//IN041644 Ends
		int count = 0;
		int cnt=0;



		int int_total_records = Integer.parseInt(total_records);
		try {
			// to check lab install or not. and rd install or not
			//lab_install_yn = getFacilityModuleInstallYn("RL");changed on 7/18/2007 for lab_install_yn by uma
			rd_install_yn  = getFacilityModuleInstallYn("RD");

			connection = getConnection() ;
			for(int i=0; i<int_total_records; i++){

				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
					which_page = (String)allValues.get("which_page"); //  used in the modal window file AuthorizeOrderVwSplOrder.jsp
					order_type_code = (String)allValues.get("ord_typ_code"+i);
					cont_order_ind = (String)allValues.get("cont_order_ind"+i);
					//cont_order_ind = "DO";
					ord_consent_reqd_yn= (String)allValues.get("ord_consent_yn"+i);
					order_id= (String)allValues.get("ord_id"+i);

					ord_appr_by_user_id = (String)allValues.get("ord_appr_by_user_id"+i);
					ord_appr_reqd_yn = (String)allValues.get("ord_appr_reqd_yn"+i);
					order_category	= (String)allValues.get("order_category"+i);
					order_set_id	= (((String)allValues.get("order_set_id"+i))==null?"":((String)allValues.get("order_set_id"+i)));
					order_set_bill_yn=(((String)getOrderSetDetails(order_set_id))==null?"N":((String)getOrderSetDetails(order_set_id)));
					//IN041644 Starts
					patient_id = (String)allValues.get("patient_id"+i);
					encounter_id = (String)allValues.get("encounter_id"+i);
					ordering_pract_id = (String)allValues.get("ordering_pract_id"+i);
					ordering_facility_id = (String)allValues.get("ordering_facility_id"+i);
					//IN041644 Ends
				
					if((ord_appr_by_user_id.equals("null") || ord_appr_by_user_id == null || ord_appr_by_user_id.equals("")) && ord_appr_reqd_yn.equals("Y")){
			 			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_GET_ORDER_STATUS_CODE") ) ;
						pstmt.setString(1,"05");
					}else{
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_REGN_REQD_YN_CHK") ) ;
						pstmt.setString( 1, order_type_code ) ;
						resultSet = pstmt.executeQuery() ;
						if ( resultSet != null && resultSet.next() ) {
							regn_reqd_yn= resultSet.getString( "regn_reqd_yn" )  ;

						}
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						traceVals.append("regn_reqd_yn >"+regn_reqd_yn);
						//=============================

				pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_SELECT_OTH_DTLS") ) ;
				pstmt1.setString( 1, checkForNull(order_id) );

				resultSet1 = pstmt1.executeQuery() ;
				if( resultSet1 != null && resultSet1.next() ) {
						 record1 = new String[1];// Only One record
						record1[0]=resultSet1.getString( "ORDER_CATALOG_CODE" )  ;
				}

						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt1 ) ;	
						labchk=checkForNull(getmoduleRL(record1[0],(String)allValues.get("order_category"+i),(String)allValues.get("ord_typ_code"+i),login_facility_id),"");

						if(regn_reqd_yn.equals("Y")) {
							//if ( (lab_install_yn.equals("Y") && order_category.equals("LB") ) || (rd_install_yn.equals("Y") && order_category.equals("RD")) )  {changed on 7/18/2007 for lab_install_yn logic change by uma
							if ( (labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") ) || (rd_install_yn.equals("Y") && order_category.equals("RD")) )  {
								pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_GET_ORDER_STATUS_CODE") ) ;
								pstmt.setString(1,"10");
							} else {
								pstmt = connection.prepareStatement(   OrRepository.getOrKeyValue("SQL_OR_GET_ORDER_STATUS_CODE") ) ;
								pstmt.setString(1,"25");
							}

						}else {		// if(regn_reqd_yn.equals("N")){
							pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_GET_ORDER_STATUS_CODE") ) ;
							pstmt.setString(1,"10");
						}
					}

					resultSet = pstmt.executeQuery() ;

					while ( resultSet != null && resultSet.next() ) {
						order_status_code= resultSet.getString( "order_status_code" )  ;
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;



					//traceVals.append("ord_consent_reqd_yn >"+ord_consent_reqd_yn);
					//traceVals.append("security_level >"+security_level);
					//=============================
					try{
						sqlMap.put("SQL_OR_AUTHORISE_ORDER_CANCEL_WITH_CONSENT_REQD",OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_CANCEL_WITH_CONSENT_REQD") );
						sqlMap.put("SQL_OR_AUTHORISE_ORDER_CANCEL_WITHOUT_CONSENT_REQD",OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_CANCEL_WITHOUT_CONSENT_REQD") );
						sqlMap.put("SQL_OR_AUTHORISE_ORDER_UPDATE_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_UPDATE_ORDER_LINE") );

						sqlMap.put("SQL_OR_AUTHORISE_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_AUTHORISE_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_AUTHORISE_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") );

						sqlMap.put("SQL_OR_ORDER_COMPLETE_STATUS",OrRepository.getOrKeyValue("SQL_OR_ORDER_COMPLETE_STATUS") );
						sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
						//IN041644 Starts
						sqlMap.put("SQL_OR_ORDER_ENTRY_AUTHORISATION_HISTORY",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_AUTHORISATION_HISTORY") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_AUTHORISATION_RULE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_AUTHORISATION_RULE") );
						sqlMap.put("ORDER_ENTRY_AUTHORISATION_OVERRULE_CHECK",OrRepositoryExt.getOrKeyValue("ORDER_ENTRY_AUTHORISATION_OVERRULE_CHECK") );
						sqlMap.put("ORDER_ENTRY_AUTHORISATION_OVERRULE_DELETE",OrRepositoryExt.getOrKeyValue("ORDER_ENTRY_AUTHORISATION_OVERRULE_DELETE") );
						//IN041644 Ends

					}catch(Exception e){
							e.printStackTrace() ;
							map.put( "message", e.getMessage() ) ;
					}

					if(ord_consent_reqd_yn.equals("Y")){
						String[] updt_data = new String[5];

						updt_data[0] = (String)order_status_code;
						updt_data[1] = (String)pract_id;
						updt_data[2] = (String)security_level;
						updt_data[3] = (String)pract_id;
						updt_data[4] = (String)order_id;

					//	traceVals.append("updt_data length in YES Loop >"+updt_data.length);
 						updt_map1.put("data"+count ,updt_data);

					}else if(ord_consent_reqd_yn.equals("N")){
						String[] updt_data = new String[4];

						updt_data[0] = (String)order_status_code;
						updt_data[1] = (String)security_level;
						updt_data[2] = (String)pract_id;
						updt_data[3] = (String)order_id;

 						updt_map1.put("data"+count ,updt_data);

					}
					count++;

					String[] updt_data1 = new String[5];

					updt_data1[0] = (String)order_status_code;
					updt_data1[1] = (String)order_id;
					updt_data1[2] = (String)ord_appr_reqd_yn;
					updt_data1[3] = (String)order_set_id;
					updt_data1[4] = (String)order_set_bill_yn;
					
					//IN041644 Starts
					order_date_time = (String)allValues.get("order_date_time"+i);
					ord_auth_reqd_yn = (String)allValues.get("ord_auth_reqd_yn"+i);
					pstmt = connection.prepareStatement( "select order_line_num,order_catalog_code,ORDER_TYPE_CODE from or_order_line where order_id = ?") ;//IN048317
					pstmt.setString(1,order_id);
					resultSet = pstmt.executeQuery();
					int lineIndex = 0;
					while(resultSet.next())
					
					{
						lineIndex++;
						or_order_line= resultSet.getString("order_line_num");
						ord_catalog  =  resultSet.getString("order_catalog_code");
						order_type = resultSet.getString("ORDER_TYPE_CODE");//IN048317

						String[] order_author_data = new String[11];
						
						order_author_data[0] = (String)patient_id;
						order_author_data[1] = (String)encounter_id;
						order_author_data[2] = (String)order_date_time;
						order_author_data[3] = (String)ordering_pract_id;
						order_author_data[4] = (String)ordering_facility_id;
						order_author_data[5] =(String) ord_catalog;
						order_author_data[6] =(String) order_id;
						order_author_data[7] =(String) ord_auth_reqd_yn;
						order_author_data[8] =  order_type;//IN048317
						order_author_data[9] =  order_category;
						order_author_data[10] = or_order_line;

						updt_map1.put("authorisationData"+lineIndex+i,order_author_data);//IN048202
					}	
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					updt_map1.put("lineIndex"+i,lineIndex);//IN048202
					//IN041644 Ends
					updt_map1.put("lineData"+cnt,updt_data1);
					updt_map1.put("cont_order_ind"+cnt,cont_order_ind);

					//traceVals.append("====updt_map1 >"+updt_map1.toString());
					cnt++;

				}//end of if condition

			}//end of for loop

			updt_map1.put("totalCount",""+count);
			updt_map1.put("lineCount",""+cnt);
			updt_map1.put("which_page",which_page);
			updt_map1.put( "login_by_id",login_by_id ) ;
			updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
        	updt_map1.put( "login_facility_id",login_facility_id ) ;
			updt_map1.put( "int_total_records",""+int_total_records ) ;//IN048252

			//ORAuthoriseOrderHome home = null ;
			//ORAuthoriseOrderRemote remote = null ;

			try {
				updt_map1.put( "properties", getProperties() );



				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_AUTHORISE_ORDER_JNDI") ) ;
				home  = (ORAuthoriseOrderHome) PortableRemoteObject.narrow( object, ORAuthoriseOrderHome.class ) ;
				remote = home.create() ;
				map = remote.insert( updt_map1, sqlMap ) ;
				//traceVals.append("====map>"+map.get("result"));*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_AUTHORISE_ORDER_JNDI"), ORAuthoriseOrderHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= updt_map1;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= updt_map1.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				argArray	= null;
				paramArray	= null;
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);



				////////////boolean map_result = ((Boolean)map.get( "result" )).booleanValue();

				////////////if(map_result){
					/////////traceVals.append("<><>map result is true<><>");
					//traceVals.append("requset"+(request == null));

				/*	OnLinePrinting online_print = new OnLinePrinting(request,response);
					online_print.callOnlinePrint(allValues);    */
					//traceVals.append("==== online_print obj ?>?>?>" + online_print);
					//OnLinePrinting online_print = new OnLinePrinting();
					//HashMap tmp_map = (HashMap)online_print.callOnlinePrint(allValues);



				//}

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


		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		map.put("traceVal", traceVals.toString());
		return map;
	}




/**
	This will value of Special Approval required field ("Yes / No")
	@return		:	String
*/

	public String getSplApprvlYN(String practitioner_id, String resp_id, String ord_category) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  spl_appr_yn			= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_SPL_APPRVL_YN") ) ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id) ;
			pstmt.setString( 3, ord_category) ;
			pstmt.setString( 4, "Y" ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				spl_appr_yn = resultSet.getString( "spl_appr_yn" )  ;
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return spl_appr_yn;
	}


/**
*/
	public Hashtable getHashTableForPrinting( Hashtable allValues ) {


			return allValues;
	}



/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
		allValues = recordSet;

		allValues.put("order_entry","AuthoriseOrder");
		/* Thai date validations start 14/02/2007*/
		if (!language_id.equals("en")){
		String period_from = (String)allValues.get("period_from");
		String period_to = (String)allValues.get("period_to");

		if (period_from.equals(" ") || period_from.equals("null")) period_from="";
		if (period_to.equals(" ") || period_to.equals("null")) period_to="";

		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		allValues.put("period_from",period_from);
		allValues.put("period_to",period_to);
		}
		/* Thai date validations end 14/02/2007*/



		if(recordSet.containsKey("security_level")){
			setSecurityLevel((String)recordSet.get("security_level"));
		}
		if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
		}
		if(recordSet.containsKey("practitioner_id")){
			setPractId((String)recordSet.get("practitioner_id"));
		}
		this.mode = (String)recordSet.get( "mode" );
	//	this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
	//	this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
	}

	 // To check whether the module has been installed or not, sm_modules_facility.operational_yn(Difft table referred)  if installed it return as 'Y' otherwise 'N'
		public String getFacilityModuleInstallYn(String module_id) throws Exception {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String module_install_yn	= "N";
		try{

				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, login_facility_id); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
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

	 public String fingurePrintYN()throws Exception{
	   String fingurePrnYN 				= "" ;
    	Connection connection		= null;
    	PreparedStatement pstmt 	= null;
    	ResultSet resultSet 		= null;

    	try {
    		connection = getConnection() ;
    		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORIZE_FINGURE_PRN_SELECT") ) ;
    		resultSet = pstmt.executeQuery() ;

    		while ( resultSet != null && resultSet.next() ){
    			fingurePrnYN = resultSet.getString( "fing_prn_auth_order" )  ;
    		}
    	} catch ( Exception e )	{
    		e.printStackTrace() ;
    		throw e ;
    	} finally {
    			closeResultSet( resultSet ) ;
    			closeStatement( pstmt ) ;
    			closeConnection(connection);

    	}
    	return fingurePrnYN ;
	}
		/*Removed while Thai date validations 14/02/2007 end*/
	/*public ArrayList getSysDateTime() throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME1") ) ;
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
	}*/
	/*Removed while Thai date validations 14/02/2007 end*/


/***
 *Method called before trasaction where validations should take place.
 * @return      HashMap containing the error information.
 * @throws Exception
*/
    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;

		String order_id = "";
		String valid_operational_yn = "";

		int int_total_records = Integer.parseInt(total_records);
		for(int i=0; i<int_total_records; i++){

			if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
				order_id			 = (String)allValues.get("ord_id"+i);
				valid_operational_yn = getOperationalStatus("AUTHORIZE_ORDER", order_id , "");

			}else
				valid_operational_yn = "Y";

			if(valid_operational_yn.equals("N")){
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(language_id, "OR_STATUS_CHANGED","OR") ) ;
				map.put( "invalidCode", ""+i ) ;

				break;
			}

		}
        return map ;
    }

public String getPractSpecCode(String pract_id) throws Exception
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String pract_spec_code="";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_PRACT_SPEC_CODE"));
			pstmt.setString(1,(String)pract_id);
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				pract_spec_code = rs.getString("pract_spec_code");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return pract_spec_code;

}

public String getOrderSetDetails(String order_id) throws Exception
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				record = resultSet.getString("bill_yn")  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}
	//IN053846 - Start
	public String getOrderSheetRule(String order_type_code, String patient_class, String perf_loc_code) throws Exception {
		String print_ord_sht_rule = "";
		StringBuilder ruleBuilder = new StringBuilder();
		String orderRuleSql = "SELECT  PRINT_ORD_SHT_RULE_IND FROM or_order_type_routing WHERE order_type_code in (" + order_type_code +" ) AND patient_class IN ("+ patient_class +" , '*A') AND NVL (performing_deptloc_code, '!') IN ('!', " + perf_loc_code +")";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(orderRuleSql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				ruleBuilder.append(resultSet.getString("PRINT_ORD_SHT_RULE_IND"));
				ruleBuilder.append(",");
			}
			print_ord_sht_rule = ruleBuilder.toString();
			print_ord_sht_rule = print_ord_sht_rule.substring(0, print_ord_sht_rule.length()-1);
		}
		catch(Exception ex){
			System.err.println("1546. Error while accessing getOrderSheetRule() from AuthoriseORders.java  ===> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return print_ord_sht_rule;
	}
	//IN053846 - End
	//ML-MMOH-CRF-0493 [IN059086] - Start
	public String getAuthOrdPrivRuleOnlyYN() throws Exception{
		String auth_ord_priv_rule_only_yn = "";
		String selectSql = "SELECT AUTH_ORD_PRIV_RULE_ONLY_YN FROM OR_PARAM WHERE MODULE_ID = 'OR'";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(selectSql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				auth_ord_priv_rule_only_yn = resultSet.getString("AUTH_ORD_PRIV_RULE_ONLY_YN");
			}
		} 
		catch(Exception ex){
			System.err.println("1574. Error while accessing getAuthOrdRuleOnlyYN() from AuthoriseOrders.java  ===> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}		
		return auth_ord_priv_rule_only_yn;
	}
	//ML-MMOH-CRF-0493 [IN059086] - End

// [IN064980] - Start
	public String getDisSelectAllOptionYN()throws Exception{
		
		String Dis_Select_All_Option_yn = "";
		String Sql = "SELECT DIS_SELECT_ALL_OPTION_YN FROM OR_PARAM";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(Sql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				Dis_Select_All_Option_yn = resultSet.getString("DIS_SELECT_ALL_OPTION_YN");
			}
		} 
		catch(Exception ex){
			System.err.println("1574. Error while accessing getDisSelectAllOptionyn() from AuthoriseOrders.java  ===> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}		
		return Dis_Select_All_Option_yn;
	}
	// [IN064980] - End
}
