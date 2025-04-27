/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.OPPractitioner ;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import java.util.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="OPPractitioner"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPPractitioner"
*	local-jndi-name="OPPractitioner"
*	impl-class-name="eAM.OPPractitioner.PractitionerManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.OPPractitioner.PractitionerLocal"
*	remote-class="eAM.OPPractitioner.PractitionerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.OPPractitioner.PractitionerLocalHome"
*	remote-class="eAM.OPPractitioner.PractitionerHome"
*	generate= "local,remote"
*
*
*/




public class PractitionerManager implements SessionBean {
	Connection con ;
	PreparedStatement pstmt,pstmt1,pstmt2 ;
	String facilityid[];
	int ct=0;
	int ct1=0;
	String facilityid1[];
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	
	public final String MIGRATION_PRACTITIONER_ID = "MIGRATION_PRACTITIONER_ID";  //Added for this CRF ML-MMOH-CRF-0862

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertOPPractitioner(HashMap hashmap)//throws RemoteException
	{
		java.util.Properties p =(Properties) hashmap.get("p");
		String practtype  = (String) hashmap.get("practtype");
		String practitionerid= (String) hashmap.get("practitionerid");
		String practitionername= (String) hashmap.get("practitionername");
		String shortname= (String) hashmap.get("shortname"); 
		String sex= (String) hashmap.get("sex");
		String birthdate= (String) hashmap.get("birthdate");
		String birthplace= (String) hashmap.get("birthplace");
		String maritalstatus= (String) hashmap.get("maritalstatus");
		String aliasname= (String) hashmap.get("aliasname");
		String citizen= (String) hashmap.get("citizen");
		String nationalidno= (String) hashmap.get("nationalidno");
		//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
		String credential1= (String) hashmap.get("credential1");
		String credential2= (String) hashmap.get("credential2");
		String credential3= (String) hashmap.get("credential3");
		//End of addition on 22/04/2003 by Mallikarjuna Reddy for credential 1,2,3
		String jobtitle= (String) hashmap.get("jobtitle");
		String emplstatus= (String) hashmap.get("emplstatus");
		String degree= (String) hashmap.get("degree");
		String primaryspecialitycode= (String) hashmap.get("primaryspecialitycode");
		String allfacilities= (String) hashmap.get("allfacilities");
		String repfacility= (String) hashmap.get("repfacility");
		String restelno= (String) hashmap.get("restelno");
		String pagerno= (String) hashmap.get("pagerno");
		String mobileno= (String) hashmap.get("mobileno");
		String offtelno= (String) hashmap.get("offtelno");
		String offtelext= (String) hashmap.get("offtelext");
		String faxno= (String) hashmap.get("faxno");
		String emailid= (String) hashmap.get("emailid");
		String prefmode= (String) hashmap.get("prefmode");
		String resaddln1= (String) hashmap.get("resaddln1");
		String resaddln2= (String) hashmap.get("resaddln2");
		String resaddln3= (String) hashmap.get("resaddln3");
		String resaddln4= (String) hashmap.get("resaddln4");
		String respostalcode= (String) hashmap.get("respostalcode");
		String rescountrycode= (String) hashmap.get("rescountrycode");
		String offaddln1= (String) hashmap.get("offaddln1");
		String offaddln2= (String) hashmap.get("offaddln2");
		String offaddln3= (String) hashmap.get("offaddln3");
		String offaddln4= (String) hashmap.get("offaddln4");
		String offpostalcode= (String) hashmap.get("offpostalcode");
		String offcountrycode= (String) hashmap.get("offcountrycode");
		String mailaddln1= (String) hashmap.get("mailaddln1");
		String mailaddln2= (String) hashmap.get("mailaddln2");
		String mailaddln3= (String) hashmap.get("mailaddln3");
		String mailaddln4= (String) hashmap.get("mailaddln4");
		String mailpostalcode= (String) hashmap.get("mailpostalcode");
		String mailcountrycode= (String) hashmap.get("mailcountrycode");
		String	effectiveDateFrom= (String) hashmap.get("effectiveDateFrom");
		String	effectiveDateTo= (String) hashmap.get("effectiveDateTo");
		String	effectiveStatus= (String) hashmap.get("effectiveStatus");
		String	addedFacilityId= (String) hashmap.get("addedFacilityId");
		String	addedAtWorkstation= (String) hashmap.get("addedAtWorkstation");
		String employeeid= (String) hashmap.get("employeeid");
		String degree1= (String) hashmap.get("degree1");
		String degree2= (String) hashmap.get("degree2");
		String degree3= (String) hashmap.get("degree3");
		String degree4= (String) hashmap.get("degree4");
		String year1= (String) hashmap.get("year1");
		String year2= (String) hashmap.get("year2");
		String year3= (String) hashmap.get("year3");
		String year4= (String) hashmap.get("year4");
		String univ1= (String) hashmap.get("univ1");
		String univ2= (String) hashmap.get("univ2");
		String univ3= (String) hashmap.get("univ3");
		String univ4= (String) hashmap.get("univ4");
		String con1= (String) hashmap.get("con1");
		String con2= (String) hashmap.get("con2");
		String con3= (String) hashmap.get("con3");
		String con4= (String) hashmap.get("con4");
		String det1= (String) hashmap.get("det1");
		String det2= (String) hashmap.get("det2");
		String det3= (String) hashmap.get("det3");
		String det4= (String) hashmap.get("det4");							
		String apc_no= (String) hashmap.get("apc_no");
		String function_id= (String) hashmap.get("function_id");
		String longname=(String) hashmap.get("longname");
		/*Below line added for this CRF HAS-CRF-160*/
		String other_alt_type=(String) hashmap.get("other_alt_type");
		String other_alt_no=(String) hashmap.get("other_alt_no");
		
		String	enable_virtual_consultation= (String) hashmap.get("enable_virtual_consultation"); //<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
		String employee_service_number=(String) hashmap.get("employee_service_number"); // added by Lakshmanan for MO-CRF-20183.2 
		//Below line added for this CRF ML-MMOH-CRF-0862
		String cerner_practitioner_id =(String) hashmap.get("cerner_practitioner_id");		
		if (cerner_practitioner_id==null || cerner_practitioner_id=="null" || cerner_practitioner_id.equals("null")) cerner_practitioner_id="";
		
		String fppPractYn = checkForNull((String) hashmap.get("fppPractYn"), "N");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
		String supervisor_yn = checkForNull((String) hashmap.get("supervisor_yn"), "N");//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 
		
		String locale="";
		locale= p.getProperty("LOCALE"); 
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;
		boolean insertable = true ;		StringBuffer sb = new StringBuffer( "" ) ;
		boolean insertable1=false;		StringBuffer sb1=new StringBuffer ("");
		String sql ="";
		int res=0;

		hashmap.clear();

		if(function_id.equals("PRACTITIONER"))	{
			sql = "insert into 	am_practitioner(	"	+
					" pract_type,DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3, TRAINING_DTLS_4," 	+
					" practitioner_id, practitioner_name, " +
					" short_name, gender, " +
					" date_of_birth, place_of_birth, " +
					" mar_status_code, alias_name, " +
					" citizenship_code, national_id_num, " +
					" credential_id1,credential_id2,credential_id3, POSITION_CODE, " +
					" empl_status, degree, " +
					" primary_speciality_code, " +
					" all_facilities_yn, reporting_facility_id, " +
					" res_tel_num, pager_num, " +
					" mobile_num, off_tel_num, " +
					" off_tel_ext, fax_num, " +
					" email_id, pref_contact_mode, " +
					" res_add_ln1, res_add_ln2, " +
					" res_add_ln3, res_add_ln4, " +
					" res_add_postal_code, res_add_country_code, " +
					" off_add_ln1, off_add_ln2, " +
					" off_add_ln3, off_add_ln4, " +
					" off_add_postal_code, off_add_country_code, " +
					" mail_add_ln1, mail_add_ln2, " +
					" mail_add_ln3, mail_add_ln4, " +
					" mail_add_postal_code, mail_add_country_code, " +
					" eff_date_from, 	eff_date_to,	" 	+
					" eff_status, " 						+
					" added_by_id,		added_date, " 		+
					" added_facility_id, added_at_ws_no, " 	+
					" modified_by_id,	 modified_date, " 		+
					" modified_facility_id,	modified_at_ws_no,employee_id,APC_NO,LONG_NAME,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,practitioner_long_id,fpp_pract_yn,supervisor_yn,Enable_virtual_cons,EMPLOYEE_SERVICE_NO " +
					" ) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?,?,?,?,?,?,?,?,?,?,?,?)" ;
					//Above Query Modified for this CRF ML-MMOH-CRF-0862
					//Above query modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184
		}else	{
			if(function_id.equals("EXT_PRACT")){
					sql = "insert into 	am_ext_practitioner(	"	+
					" pract_type,DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3, TRAINING_DTLS_4," 	+
					" practitioner_id, practitioner_name, " +
					" short_name, gender, " +
					" date_of_birth, place_of_birth, " +
					" mar_status_code, alias_name, " +
					" citizenship_code, national_id_num, " +
					" credential_id1,credential_id2,credential_id3, POSITION_CODE, " +
					" empl_status, degree, " +
					" primary_speciality_code, " +
					" res_tel_num, pager_num, " +
					" mobile_num, off_tel_num, " +
					" off_tel_ext, fax_num, " +
					" email_id, pref_contact_mode, " +
					" res_add_ln1, res_add_ln2, " +
					" res_add_ln3, res_add_ln4, " +
					" res_add_postal_code, res_add_country_code, " +
					" off_add_ln1, off_add_ln2, " +
					" off_add_ln3, off_add_ln4, " +
					" off_add_postal_code, off_add_country_code, " +
					" mail_add_ln1, mail_add_ln2, " +
					" mail_add_ln3, mail_add_ln4, " +
					" mail_add_postal_code, mail_add_country_code, " +
					" eff_date_from, 	eff_date_to,	" 	+
					" eff_status, " 						+
					" added_by_id,		added_date, " 		+
					" added_facility_id, added_at_ws_no, " 	+
					" modified_by_id,	 modified_date, " 		+
					" modified_facility_id,	modified_at_ws_no,employee_id,APC_NO,LONG_NAME,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,practitioner_long_id,fpp_pract_yn,supervisor_yn,Enable_virtual_cons,EMPLOYEE_SERVICE_NO  " +
					" ) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)" ;
					//Above Query Modified for this CRF ML-MMOH-CRF-0862
					//Above query modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184
		}
	}

		String addedById = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date effective_date_from = null ;

		java.sql.Date effective_date_to = null ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs1 = null;

		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from =  java.sql.Date.valueOf( effectiveDateFrom ) ;

		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
			effective_date_to =  java.sql.Date.valueOf( effectiveDateTo ) ;


		try {
			
			  con=ConnectionManager.getConnection(p);

			final String ctsql="select count(*) as total from sm_facility_param";
			pstmt2=con.prepareStatement(ctsql);
			rs2=pstmt2.executeQuery();
			rs2.next();
			ct=rs2.getInt("total");
          	facilityid=new String[ct];
            if(pstmt2!=null)pstmt2.close();
			
			//Added for this CRF ML-MMOH-CRF-0862
			boolean cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","CERNER_PRACTITIONER_ID");

			
			if(function_id.equals("PRACTITIONER"))	{
			final String duplicateSql = "select 1 from  am_practitioner where practitioner_id = ?" ;
			pstmt = con.prepareStatement( duplicateSql ) ;

			pstmt.setString( 1, practitionerid) ;

			rs = pstmt.executeQuery() ;

			if ( rs.next() ) {
				insertable = false ;				
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();				
			
			/*Below line added for this CRF ML-MMOH-CRF-0862*/
			if(cernerIdSiteSpecific){
				final String cernerpractid = "select 1 from  am_practitioner where practitioner_long_id = ?" ;
				pstmt = con.prepareStatement( cernerpractid ) ;
				pstmt.setString( 1, cerner_practitioner_id) ;
				rs = pstmt.executeQuery() ;
				if (rs!=null && rs.next() ) {
					insertable = false ;				
					java.util.Hashtable message = MessageManager.getMessage( locale, MIGRATION_PRACTITIONER_ID ,"Common") ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				if(rs!=null) rs.close();		
				if(pstmt!=null)pstmt.close();  
            }			
			//End this CRF ML-MMOH-CRF-0862
			
			}
			else
			{
				if(function_id.equals("EXT_PRACT")){

					final String duplicateSql = "select 1 from  AM_EXT_PRACTITIONER  where practitioner_id = ?" ;
					pstmt = con.prepareStatement( duplicateSql ) ;
					pstmt.setString( 1, practitionerid) ;
					rs = pstmt.executeQuery() ;
				if ( rs.next() ) {
					insertable = false ;				
					java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"Common" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
			    }
				
			/*Below line added for this CRF ML-MMOH-CRF-0862*/
			if(rs!=null) rs.close();		
			if(pstmt!=null)pstmt.close();
			
			if(cernerIdSiteSpecific){
				final String cernerpractid = "select 1 from  am_practitioner where practitioner_long_id = ?" ;
				pstmt = con.prepareStatement( cernerpractid ) ;
				pstmt.setString( 1, cerner_practitioner_id) ;
				rs = pstmt.executeQuery() ;
				if (rs!=null && rs.next() ) {
					insertable = false ;				
					java.util.Hashtable message = MessageManager.getMessage( locale, MIGRATION_PRACTITIONER_ID ,"Common") ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				if(rs!=null) rs.close();		
				if(pstmt!=null)pstmt.close(); 
            }			
			//End this CRF ML-MMOH-CRF-0862
				

				}
			}

            if(pstmt!=null)pstmt.close();
			final String facsql="select facility_id from sm_facility_param";
			pstmt1=con.prepareStatement( facsql ) ;

			rs1=pstmt1.executeQuery();
			int i=0;
				while(rs1.next())
				{
				facilityid[i]=rs1.getString("facility_id");
				insertable1=true;
				
				i++;
			}

		if(rs1!=null)rs1.close();   // Corrected aginst this CRF ML-MMOH-CRF-0862 Changed from rs to rs1	
		if(pstmt1!=null)pstmt1.close();
		

		} catch ( Exception e )
			{
				insertable = false ;
				insertable1=false;
				sb.append( e.getMessage() + "<br>" ) ;
				sb1.append(e.getMessage() + "<br" );
				e.printStackTrace() ;
			}
			finally
			{
				try
				{
					if(rs!=null) rs.close();	
					if(rs1!=null) rs1.close();	
					if(rs2!=null) rs2.close();	
				}catch(Exception e){
					e.printStackTrace();
				}
			}

		if ( insertable ) {
						 
			try {				
				if(function_id.equals("PRACTITIONER"))
				{
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, practtype ) ;
				pstmt.setString	( 2, degree1 ) ;
				pstmt.setString	( 3, univ1 ) ;
				pstmt.setString	( 4, year1 ) ;
				pstmt.setString	( 5, degree2 ) ;
				pstmt.setString	( 6, univ2 ) ;
				pstmt.setString	( 7, year2 ) ;
				pstmt.setString	( 8, degree3 ) ;
				pstmt.setString	( 9, univ3 ) ;
				pstmt.setString	( 10, year3 ) ;
				pstmt.setString	( 11, degree4 ) ;
				pstmt.setString	( 12, univ4 ) ;
				pstmt.setString	( 13, year4 ) ;
				pstmt.setString	( 14, con1 ) ;
				pstmt.setString	( 15, con2 ) ;
				pstmt.setString	( 16, con3 ) ;
				pstmt.setString	( 17, con4 ) ;
				pstmt.setString	( 18, det1 ) ;
				pstmt.setString	( 19, det2 ) ;
				pstmt.setString	( 20, det3 ) ;
				pstmt.setString	( 21, det4 ) ;
				pstmt.setString	( 22, practitionerid ) ;
				pstmt.setString	( 23, practitionername ) ;
				pstmt.setString	( 24, shortname ) ;
				pstmt.setString	( 25, sex ) ;
				pstmt.setString	( 26, birthdate ) ;
				pstmt.setString	( 27, birthplace ) ;
				pstmt.setString	( 28, maritalstatus ) ;
				pstmt.setString	( 29, aliasname ) ;
				pstmt.setString	( 30, citizen ) ;
				pstmt.setString	( 31, nationalidno ) ;
				//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 32, credential1 ) ;
				pstmt.setString	( 33, credential2 ) ;
				pstmt.setString	( 34, credential3 ) ;
				//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 35, jobtitle ) ;
				pstmt.setString	( 36, emplstatus ) ;
				pstmt.setString	( 37, degree ) ;
				pstmt.setString ( 38, primaryspecialitycode ) ;
				pstmt.setString	( 39, allfacilities ) ;
				if (repfacility=="" || repfacility=="null" ||repfacility==" ")
												pstmt.setString ( 40, null );
								else
				pstmt.setString ( 40, repfacility );
				pstmt.setString	( 41, restelno ) ;
				pstmt.setString	( 42, pagerno ) ;
				pstmt.setString	( 43, mobileno ) ;
				pstmt.setString	( 44, offtelno ) ;
				pstmt.setString	( 45, offtelext ) ;
				pstmt.setString	( 46, faxno ) ;
				pstmt.setString	( 47, emailid ) ;
				if (prefmode=="" || prefmode=="null" ||prefmode==" ")
								pstmt.setString ( 48, null );
				else
				pstmt.setString ( 48, prefmode );
				pstmt.setString	( 49, resaddln1 ) ;
				pstmt.setString	( 50, resaddln2 ) ;
				pstmt.setString	( 51, resaddln3  ) ;
				pstmt.setString	( 52, resaddln4 ) ;
				if (respostalcode=="" || respostalcode=="null" ||respostalcode==" ")
							pstmt.setString ( 53, null );
				else
				pstmt.setString ( 53, respostalcode );
				if (rescountrycode=="" || rescountrycode=="null" ||rescountrycode==" ")
							pstmt.setString ( 53, null );
				else
				pstmt.setString ( 54, rescountrycode );
				pstmt.setString	( 55, offaddln1 ) ;
				pstmt.setString	( 56, offaddln2 ) ;
				pstmt.setString	( 57, offaddln3  ) ;
				pstmt.setString	( 58, offaddln4 ) ;
				if (offpostalcode=="" || offpostalcode=="null" ||offpostalcode==" ")
							pstmt.setString ( 59, null );
				else
				pstmt.setString ( 59, offpostalcode );
				if (offcountrycode=="" || offcountrycode=="null" ||offcountrycode==" ")
											pstmt.setString ( 60, null );
								else
				pstmt.setString ( 60, offcountrycode );
				pstmt.setString	( 61, mailaddln1 ) ;
				pstmt.setString	( 62, mailaddln2 ) ;
				pstmt.setString	( 63, mailaddln3  ) ;
				pstmt.setString	( 64, mailaddln4 ) ;
				if (mailpostalcode=="" || mailpostalcode=="null" ||mailpostalcode==" ")
															pstmt.setString ( 65, null );
												else
				pstmt.setString ( 65, mailpostalcode );
				if (mailcountrycode=="" || mailcountrycode=="null" ||mailcountrycode==" ")
															pstmt.setString ( 66, null );
												else
				pstmt.setString ( 66, mailcountrycode );
				pstmt.setDate	( 67, effective_date_from ) ;
				pstmt.setDate	( 68, effective_date_to ) ;
				pstmt.setString	( 69, effectiveStatus ) ;
				pstmt.setString	( 70, addedById ) ;
				pstmt.setDate	( 71, added_date ) ;
				pstmt.setString	( 72, addedFacilityId ) ;
				pstmt.setString	( 73, addedAtWorkstation ) ;
				pstmt.setString	( 74, modifiedById ) ;
				//pstmt.setDate	( 75, modified_date ) ;
				pstmt.setString	( 75, modifiedFacilityId ) ;
				pstmt.setString	( 76, modifiedAtWorkstation ) ;
				pstmt.setString	( 77, employeeid ) ;
				pstmt.setString	( 78, apc_no) ;
				pstmt.setString	( 79, longname) ;
				
				pstmt.setString	( 80, other_alt_type) ;
				pstmt.setString	( 81, other_alt_no) ;	
                //Added for this CRF ML-MMOH-CRF-0862
                pstmt.setString	( 82, cerner_practitioner_id) ; 
                pstmt.setString	( 83, fppPractYn);//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
                pstmt.setString	( 84, supervisor_yn);//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4
				
				pstmt.setString	( 85, enable_virtual_consultation ) ;//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
				pstmt.setString (86,employee_service_number); // added by Lakshmanan for MO-CRF-20183.2 
				
				 res = pstmt.executeUpdate() ;
				}else
				{
					if(function_id.equals("EXT_PRACT"))
					{
						
						if(pstmt!=null)pstmt.close();
						pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, practtype ) ;
				pstmt.setString	( 2, degree1 ) ;
				pstmt.setString	( 3, univ1 ) ;
				pstmt.setString	( 4, year1 ) ;
				pstmt.setString	( 5, degree2 ) ;
				pstmt.setString	( 6, univ2 ) ;
				pstmt.setString	( 7, year2 ) ;
				pstmt.setString	( 8, degree3 ) ;
				pstmt.setString	( 9, univ3 ) ;
				pstmt.setString	( 10, year3 ) ;
				pstmt.setString	( 11, degree4 ) ;
				pstmt.setString	( 12, univ4 ) ;
				pstmt.setString	( 13, year4 ) ;
				pstmt.setString	( 14, con1 ) ;
				pstmt.setString	( 15, con2 ) ;
				pstmt.setString	( 16, con3 ) ;
				pstmt.setString	( 17, con4 ) ;
				pstmt.setString	( 18, det1 ) ;
				pstmt.setString	( 19, det2 ) ;
				pstmt.setString	( 20, det3 ) ;
				pstmt.setString	( 21, det4 ) ;
				pstmt.setString	( 22, practitionerid ) ;
				pstmt.setString	( 23, practitionername ) ;
				pstmt.setString	( 24, shortname ) ;
				pstmt.setString	( 25, sex ) ;
				pstmt.setString	( 26, birthdate ) ;
				pstmt.setString	( 27, birthplace ) ;
				pstmt.setString	( 28, maritalstatus ) ;
				pstmt.setString	( 29, aliasname ) ;
				pstmt.setString	( 30, citizen ) ;
				pstmt.setString	( 31, nationalidno ) ;
				//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 32, credential1 ) ;
				pstmt.setString	( 33, credential2 ) ;
				pstmt.setString	( 34, credential3 ) ;
				//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 35, jobtitle ) ;
				pstmt.setString	( 36, emplstatus ) ;
				pstmt.setString	( 37, degree ) ;
				pstmt.setString ( 38, primaryspecialitycode ) ;
				pstmt.setString	( 39, restelno ) ;
				pstmt.setString	( 40, pagerno ) ;
				pstmt.setString	( 41, mobileno ) ;
				pstmt.setString	( 42, offtelno ) ;
				pstmt.setString	( 43, offtelext ) ;
				pstmt.setString	( 44, faxno ) ;
				pstmt.setString	( 45, emailid ) ;
				if (prefmode=="" || prefmode=="null" ||prefmode==" ")
								pstmt.setString ( 46, null );
				else
				pstmt.setString ( 46, prefmode );
				pstmt.setString	( 47, resaddln1 ) ;
				pstmt.setString	( 48, resaddln2 ) ;
				pstmt.setString	( 49, resaddln3  ) ;
				pstmt.setString	( 50, resaddln4 ) ;
				if (respostalcode=="" || respostalcode=="null" ||respostalcode==" ")
							pstmt.setString ( 51, null );
				else
				pstmt.setString ( 51, respostalcode );
				if (rescountrycode=="" || rescountrycode=="null" ||rescountrycode==" ")
							pstmt.setString ( 52, null );
				else
				pstmt.setString ( 52, rescountrycode );
				pstmt.setString	( 53, offaddln1 ) ;
				pstmt.setString	( 54, offaddln2 ) ;
				pstmt.setString	( 55, offaddln3  ) ;
				pstmt.setString	( 56, offaddln4 ) ;
				if (offpostalcode=="" || offpostalcode=="null" ||offpostalcode==" ")
							pstmt.setString ( 57, null );
				else
				pstmt.setString ( 57, offpostalcode );
				if (offcountrycode=="" || offcountrycode=="null" ||offcountrycode==" ")
											pstmt.setString ( 58, null );
								else
				pstmt.setString ( 58, offcountrycode );
				pstmt.setString	( 59, mailaddln1 ) ;
				pstmt.setString	( 60, mailaddln2 ) ;
				pstmt.setString	( 61, mailaddln3  ) ;
				pstmt.setString	( 62, mailaddln4 ) ;
				if (mailpostalcode=="" || mailpostalcode=="null" ||mailpostalcode==" ")
															pstmt.setString ( 63, null );
												else
				pstmt.setString ( 63, mailpostalcode );
				if (mailcountrycode=="" || mailcountrycode=="null" ||mailcountrycode==" ")
															pstmt.setString ( 64, null );
												else
				pstmt.setString ( 64, mailcountrycode );
				pstmt.setDate	( 65, effective_date_from ) ;
				pstmt.setDate	( 66, effective_date_to ) ;
				pstmt.setString	( 67, effectiveStatus ) ;
				pstmt.setString	( 68, addedById ) ;
				pstmt.setDate	( 69, added_date ) ;
				pstmt.setString	( 70, addedFacilityId ) ;
				pstmt.setString	( 71, addedAtWorkstation ) ;
				pstmt.setString	( 72, modifiedById ) ;
				pstmt.setDate	( 73, modified_date ) ;
				pstmt.setString	( 74, modifiedFacilityId ) ;
				pstmt.setString	( 75, modifiedAtWorkstation ) ;
				pstmt.setString	( 76, employeeid ) ;
				pstmt.setString	( 77, apc_no) ;
				pstmt.setString	( 78, longname) ;
				//Added HSA-CRF-160
				pstmt.setString	( 79, other_alt_type) ;
				pstmt.setString	( 80, other_alt_no) ; 
                //Added for this CRF ML-MMOH-CRF-0862
                pstmt.setString	( 81, cerner_practitioner_id) ;  
				pstmt.setString	( 82, fppPractYn);//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
				pstmt.setString	( 83, supervisor_yn);//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4
				
				
				pstmt.setString	( 84, enable_virtual_consultation ) ;//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
				pstmt.setString (85, employee_service_number); // added by lakshmanan for MO-CRF-20183.2 
				 res = pstmt.executeUpdate() ;
					}
				}

				if ( res != 0 ) 
				{
					result = true ;
                    con.commit();
				}
				pstmt.close();


if(function_id.equals("PRACTITIONER"))
				{
				 		
                
				if(allfacilities.equals("Y")) {
					for(int i=0;i<facilityid.length;i++) {
				String sql1="insert into am_pract_for_facility(facility_id, practitioner_id,eff_date_from,eff_date_to,eff_status, added_by_id,added_date,added_facility_id, added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,practitioner_long_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				
				/*Above Query Modifed for this CRF ML-MMOH-CRF-0862*/

				String effectiveStatus1="E";

				if( insertable1 ) {
				try {
					pstmt1 = con.prepareStatement( sql1 );
					pstmt1.setString	( 1, facilityid[i] ) ;
					pstmt1.setString	( 2, practitionerid ) ;
					pstmt1.setDate	( 3, effective_date_from ) ;
					pstmt1.setDate	( 4, effective_date_to ) ;
					pstmt1.setString	( 5, effectiveStatus1 ) ;
					pstmt1.setString	( 6, addedById ) ;
					pstmt1.setDate	( 7, added_date ) ;
					pstmt1.setString	( 8, addedFacilityId ) ;
					pstmt1.setString	( 9, addedAtWorkstation ) ;
					pstmt1.setString	( 10, modifiedById ) ;
					pstmt1.setDate	( 11, modified_date ) ;
					pstmt1.setString	( 12, modifiedFacilityId ) ;
					pstmt1.setString	( 13, modifiedAtWorkstation ) ;
					pstmt1.setString	( 14, cerner_practitioner_id ) ; //Added for this CRF ML-MMOH-CRF-0862
					int res1 = pstmt1.executeUpdate() ;
					if(pstmt1!=null)pstmt1.close();

					if ( res1 != 0 ) {
					result = true ;
					con.commit();
					
				}
				else
				result=false;

				//if(pstmt1!=null)pstmt1.close();
			} catch ( Exception e ) {
				try{
						con.rollback();
			       }catch(Exception ce){}
				sb1.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}

		}
	}


	}
			}
	if(result)
	{
		java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
		sb.append( (String) message.get("message") ) ;
		message.clear();
	}

		
}catch (Exception e)
	{
	try{
			con.rollback();
	   }
	   catch(Exception ce){}
		sb.append(e.getMessage() + "<br>" );
		e.printStackTrace();
	}

			finally
			{
			  if (con != null)
			  {
			   try {
						
						 ConnectionManager.returnConnection(con,p);
		       		} catch (Exception ee) {}
		      }
			}
	}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error",sb.toString() ) ;
		return results ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap updateOPPractitioner(HashMap hashmap) //throws RemoteException
	{
		java.util.Properties p =(Properties) hashmap.get("p");
		String practtype  = (String) hashmap.get("practtype");
		String practitionerid= (String) hashmap.get("practitionerid"); 
		String practitionername= (String) hashmap.get("practitionername");
		String shortname= (String) hashmap.get("shortname"); 
		String sex= (String) hashmap.get("sex");
		String birthdate= (String) hashmap.get("birthdate");
		String birthplace= (String) hashmap.get("birthplace");
		String maritalstatus= (String) hashmap.get("maritalstatus");
		String aliasname= (String) hashmap.get("aliasname");
		String citizen= (String) hashmap.get("citizen");
		String nationalidno= (String) hashmap.get("nationalidno");
		//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
		String credential1= (String) hashmap.get("credential1");
		String credential2= (String) hashmap.get("credential2");
		String credential3= (String) hashmap.get("credential3");
		//End of addition on 22/04/2003 by Mallikarjuna Reddy for credential 1,2,3
		String jobtitle= (String) hashmap.get("jobtitle");
		String emplstatus= (String) hashmap.get("emplstatus");
		String degree= (String) hashmap.get("degree");
		String primaryspecialitycode= (String) hashmap.get("primaryspecialitycode");
		String allfacilities= (String) hashmap.get("allfacilities");
		String repfacility= (String) hashmap.get("repfacility");
		String restelno= (String) hashmap.get("restelno");
		String pagerno= (String) hashmap.get("pagerno");
		String mobileno= (String) hashmap.get("mobileno");
		String offtelno= (String) hashmap.get("offtelno");
		String offtelext= (String) hashmap.get("offtelext");
		String faxno= (String) hashmap.get("faxno");
		String emailid= (String) hashmap.get("emailid");
		String prefmode= (String) hashmap.get("prefmode");
		String resaddln1= (String) hashmap.get("resaddln1");
		String resaddln2= (String) hashmap.get("resaddln2");
		String resaddln3= (String) hashmap.get("resaddln3");
		String resaddln4= (String) hashmap.get("resaddln4");
		String respostalcode= (String) hashmap.get("respostalcode");
		String rescountrycode= (String) hashmap.get("rescountrycode");
		String offaddln1= (String) hashmap.get("offaddln1");
		String offaddln2= (String) hashmap.get("offaddln2");
		String offaddln3= (String) hashmap.get("offaddln3");
		String offaddln4= (String) hashmap.get("offaddln4");
		String offpostalcode= (String) hashmap.get("offpostalcode");
		String offcountrycode= (String) hashmap.get("offcountrycode");
		String mailaddln1= (String) hashmap.get("mailaddln1");
		String mailaddln2= (String) hashmap.get("mailaddln2");
		String mailaddln3= (String) hashmap.get("mailaddln3");
		String mailaddln4= (String) hashmap.get("mailaddln4");
		String mailpostalcode= (String) hashmap.get("mailpostalcode");
		String mailcountrycode= (String) hashmap.get("mailcountrycode");
		String	effectiveDateFrom= (String) hashmap.get("effectiveDateFrom");
		String	effectiveDateTo= (String) hashmap.get("effectiveDateTo");
		String	effectiveStatus= (String) hashmap.get("effectiveStatus");
		String	addedFacilityId= (String) hashmap.get("addedFacilityId");
		String	addedAtWorkstation= (String) hashmap.get("addedAtWorkstation");
		String employeeid= (String) hashmap.get("employeeid");
		String degree1= (String) hashmap.get("degree1");
		String degree2= (String) hashmap.get("degree2");
		String degree3= (String) hashmap.get("degree3");
		String degree4= (String) hashmap.get("degree4");
		String year1= (String) hashmap.get("year1");
		String year2= (String) hashmap.get("year2");
		String year3= (String) hashmap.get("year3");
		String year4= (String) hashmap.get("year4");
		String univ1= (String) hashmap.get("univ1");
		String univ2= (String) hashmap.get("univ2");
		String univ3= (String) hashmap.get("univ3");
		String univ4= (String) hashmap.get("univ4");
		String con1= (String) hashmap.get("con1");
		String con2= (String) hashmap.get("con2");
		String con3= (String) hashmap.get("con3");
		String con4= (String) hashmap.get("con4");
		String det1= (String) hashmap.get("det1");
		String det2= (String) hashmap.get("det2");
		String det3= (String) hashmap.get("det3");
		String det4= (String) hashmap.get("det4");							
		String apc_no= (String) hashmap.get("apc_no");
		String function_id= (String) hashmap.get("function_id");
		String longname= (String) hashmap.get("longname");
		String	enable_virtual_consultation= (String) hashmap.get("enable_virtual_consultation"); //<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
		String employee_service_number=(String) hashmap.get("employee_service_number"); // Added by lakshmanan for MO-CRF-20183.2 
		/*Below line added for this CRF HAS-CRF-160*/
		String other_alt_type=(String) hashmap.get("other_alt_type");
		String other_alt_no=(String) hashmap.get("other_alt_no");
		
		//Below line added for this CRF ML-MMOH-CRF-0862
		String cerner_practitioner_id =(String) hashmap.get("cerner_practitioner_id");
        if (cerner_practitioner_id==null || cerner_practitioner_id=="null" || cerner_practitioner_id.equals("null")) cerner_practitioner_id=""; 
		
		String fppPractYn = checkForNull((String) hashmap.get("fppPractYn"), "N");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
		String supervisor_yn = checkForNull((String) hashmap.get("supervisor_yn"), "N");//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4

		String locale="";
		locale= p.getProperty("LOCALE"); 
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean result1=false;
		boolean insertable1=false;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		ResultSet rs4=null;
		ResultSet rs2=null;
		
		//Below line added for this CRF ML-MMOH-CRF-0862
		ResultSet cernerRs=null;
		PreparedStatement cernerPstmt=null;
		//End this CRF ML-MMOH-CRF-0862
		
		//String sql="";
		int res =0;
		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date effective_date_from = null ;
		java.sql.Date effective_date_to = null ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		String addedById = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		String modifiedFacilityId= addedFacilityId ;
		String modifiedAtWorkstation=addedAtWorkstation;
		StringBuffer sbQuery = new StringBuffer();
         hashmap.clear();

         if(function_id.equals("PRACTITIONER"))
								{
				sbQuery.append("update am_practitioner set ");
				sbQuery.append("pract_type		= ?,  ");
				sbQuery.append("practitioner_name	= ?,  ");
				sbQuery.append("short_name = ?, ");
				sbQuery.append(" gender = ?, ");
					sbQuery.append("date_of_birth = to_date(?,'DD/MM/YYYY'), ");
					sbQuery.append("place_of_birth = ?, ");
					sbQuery.append(" mar_status_code = ?, " );
					sbQuery.append(" alias_name = ?, ");
					sbQuery.append(" citizenship_code = ?, " );
					sbQuery.append("national_id_num = ?, ");
					sbQuery.append(" credential_id1 = ?, ");
					sbQuery.append(" credential_id2 = ?, ");
					sbQuery.append("credential_id3 = ?, ");
					sbQuery.append(" POSITION_CODE = ?, " );
					sbQuery.append("empl_status = ?, ");
					sbQuery.append(" degree = ?, "); 
							sbQuery.append(" primary_speciality_code = ?, ");
							sbQuery.append(" all_facilities_yn = ?, ");
							sbQuery.append(" reporting_facility_id = ?, ");
							sbQuery.append(" res_tel_num = ?, ");
							sbQuery.append(" pager_num = ?, ");
							sbQuery.append(" mobile_num = ?, ");
							sbQuery.append(" off_tel_num = ?, ");
							sbQuery.append(" off_tel_ext = ?, ");
							sbQuery.append(" fax_num = ?, ");
							sbQuery.append(" email_id = ?, ");
							sbQuery.append(" pref_contact_mode = ?, ");
							sbQuery.append(" res_add_ln1 = ?, ");
							sbQuery.append(" res_add_ln2 = ?, ");
							sbQuery.append(" res_add_ln3 = ?, ");
							sbQuery.append(" res_add_ln4 = ?, ");
							sbQuery.append(" res_add_postal_code = ?, ");
							sbQuery.append(" res_add_country_code = ?, ");
							sbQuery.append(" off_add_ln1 = ?, ");
							sbQuery.append(" off_add_ln2 = ?, ");
							sbQuery.append(" off_add_ln3 = ?, ");
							sbQuery.append(" off_add_ln4 = ?, ");
							sbQuery.append(" off_add_postal_code = ?, ");
							sbQuery.append(" off_add_country_code = ?, ");
							sbQuery.append(" mail_add_ln1 = ?, ");
							sbQuery.append(" mail_add_ln2 = ?, " );
							sbQuery.append(" mail_add_ln3 = ?, " );
							sbQuery.append(" mail_add_ln4 = ?, ");
							sbQuery.append(" mail_add_postal_code = ?, ");
							sbQuery.append(" mail_add_country_code = ?, ");
							sbQuery.append(" eff_date_from		= ?,  	 ");
							sbQuery.append(" eff_date_to		= ?,  	 ");
							sbQuery.append(" eff_status		= ?,  	 ");
							sbQuery.append(" modified_by_id	= ?,  	 ");
							sbQuery.append(" modified_date		= sysdate,  	 ");
							sbQuery.append(" modified_facility_id	= ?, ");
							sbQuery.append(" modified_at_ws_no = ?,  	 ");
							sbQuery.append(" employee_id	=?,			 "); 
							sbQuery.append(" DEGREE_1	=?,			 " );
							sbQuery.append(" DEGREE_1_UNIV	=?,			 " );
							sbQuery.append(" DEGREE_1_YEAR	=?,			 ");
							sbQuery.append(" DEGREE_2	=?,			 ");
							sbQuery.append(" DEGREE_2_UNIV	=?,			 ");
							sbQuery.append(" DEGREE_2_YEAR	=?,			 ");
							sbQuery.append(" DEGREE_3	=?,			 " );
							sbQuery.append(" DEGREE_3_UNIV	=?,			 ");
							sbQuery.append(" DEGREE_3_YEAR	=?,			 ");
							sbQuery.append(" DEGREE_4	=?	,		 " );
							sbQuery.append(" DEGREE_4_UNIV	=?,			 ");
							sbQuery.append(" DEGREE_4_YEAR	=?,			 ");
							sbQuery.append(" TRAINING_COND_BY_1	=?,			 ");
							sbQuery.append(" TRAINING_COND_BY_2	=?,			 ");
							sbQuery.append(" TRAINING_COND_BY_3	=?,			 ");
							sbQuery.append(" TRAINING_COND_BY_4	=?,			 " );
							sbQuery.append(" TRAINING_DTLS_1	=?		,	 " );
							sbQuery.append(" TRAINING_DTLS_2	=?		,	 " );
							sbQuery.append(" TRAINING_DTLS_3	=?		,	 " );
							sbQuery.append(" TRAINING_DTLS_4	=?		,	 " );
							sbQuery.append(" APC_NO	=?,			 "); 
							sbQuery.append("LONG_NAME =?,OTH_ALT_ID_TYPE=?, OTH_ALT_ID_NO=?, practitioner_long_id=?, fpp_pract_yn=?,supervisor_yn=?,Enable_virtual_cons=? , EMPLOYEE_SERVICE_NO=? "); //Modified for this CRF ML-MMOH-CRF-0862
							//Modified above line by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184 --added fpp_pract_yn
							sbQuery.append(" where	practitioner_id = ?");
						
}else
{
	if(function_id.equals("EXT_PRACT"))
	{
		sbQuery.append("update am_ext_practitioner set ");
		sbQuery.append("pract_type		= ?,  ");
		sbQuery.append("practitioner_name	= ?,  ");
		sbQuery.append("short_name = ?, ");
		sbQuery.append(" gender = ?, ");
		sbQuery.append("date_of_birth = to_date(?,'DD/MM/YYYY'), ");
		sbQuery.append("place_of_birth = ?, ");
		sbQuery.append("mar_status_code = ?, " );
		sbQuery.append("alias_name = ?, ");
		sbQuery.append("citizenship_code = ?, " );
		sbQuery.append("national_id_num = ?, ");
		sbQuery.append("credential_id1 = ?, ");
		sbQuery.append("credential_id2 = ?, ");
		sbQuery.append("credential_id3 = ?, ");
		sbQuery.append("position_code = ?, " );
		sbQuery.append("empl_status = ?,");
		sbQuery.append("degree = ?,"); 
		sbQuery.append("primary_speciality_code = ?,");
//		sbQuery.append("all_facilities_yn = ?,");
//		sbQuery.append("reporting_facility_id = ?,");
		sbQuery.append("res_tel_num = ?,");
		sbQuery.append("pager_num = ?,");
		sbQuery.append("mobile_num = ?,");
		sbQuery.append("off_tel_num = ?,");
		sbQuery.append("off_tel_ext = ?,");
		sbQuery.append("fax_num = ?,");
		sbQuery.append("email_id = ?,");
		sbQuery.append("pref_contact_mode = ?,");
		sbQuery.append("res_add_ln1 = ?,");
		sbQuery.append("res_add_ln2 = ?,");
		sbQuery.append("res_add_ln3 = ?,");
		sbQuery.append("res_add_ln4 = ?,");
		sbQuery.append("res_add_postal_code = ?,");
		sbQuery.append("res_add_country_code = ?,");
		sbQuery.append("off_add_ln1 = ?,");
		sbQuery.append("off_add_ln2 = ?,");
		sbQuery.append("off_add_ln3 = ?,");
		sbQuery.append("off_add_ln4 = ?,");
		sbQuery.append("off_add_postal_code = ?,");
		sbQuery.append("off_add_country_code = ?,");
		sbQuery.append("mail_add_ln1 = ?, ");
		sbQuery.append("mail_add_ln2 = ?," );
		sbQuery.append("mail_add_ln3 = ?," );
		sbQuery.append("mail_add_ln4 = ?,");
		sbQuery.append("mail_add_postal_code = ?,");
		sbQuery.append("mail_add_country_code = ?,");
		sbQuery.append("eff_date_from		= ?,");
		sbQuery.append("eff_date_to		= ?,");
		sbQuery.append("eff_status		= ?,");
		sbQuery.append("modified_by_id	= ?,");
		sbQuery.append("modified_date		= ?,");
		sbQuery.append("modified_facility_id	= ?,");
		sbQuery.append("modified_at_ws_no = ?,");
		sbQuery.append("employee_id	=?,"); 
		sbQuery.append("DEGREE_1	=?," );
		sbQuery.append("DEGREE_1_UNIV	=?," );
		sbQuery.append("DEGREE_1_YEAR	=?,");
		sbQuery.append("DEGREE_2	=?,");
		sbQuery.append("DEGREE_2_UNIV	=?,");
		sbQuery.append("DEGREE_2_YEAR	=?,");
		sbQuery.append("DEGREE_3	=?," );
		sbQuery.append("DEGREE_3_UNIV	=?,");
		sbQuery.append("DEGREE_3_YEAR	=?,");
		sbQuery.append("DEGREE_4 =?	," );
		sbQuery.append("DEGREE_4_UNIV	=?,");
		sbQuery.append("DEGREE_4_YEAR	=?,");
		sbQuery.append("TRAINING_COND_BY_1	=?,");
		sbQuery.append("TRAINING_COND_BY_2	=?,");
		sbQuery.append("TRAINING_COND_BY_3	=?,");
		sbQuery.append("TRAINING_COND_BY_4	=?," );
		sbQuery.append("TRAINING_DTLS_1	=?	," );
		sbQuery.append("TRAINING_DTLS_2	=?," );
		sbQuery.append("TRAINING_DTLS_3	=?," );
		sbQuery.append("TRAINING_DTLS_4	=?, " );
		sbQuery.append("APC_NO	= ?, "); 
		sbQuery.append("LONG_NAME	= ? ,OTH_ALT_ID_TYPE=?, OTH_ALT_ID_NO=?, practitioner_long_id=?, fpp_pract_yn=?,supervisor_yn=?,Enable_virtual_cons=?, EMPLOYEE_SERVICE_NO=?  "); //Modified for this CRF ML-MMOH-CRF-0862
		//Modified above line by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184 --added fpp_pract_yn
		sbQuery.append("where	practitioner_id = ?");								
	}
}

		

		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;

		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
			effective_date_to =  java.sql.Date.valueOf( effectiveDateTo ) ;
			
		//Below line added for this CRF ML-MMOH-CRF-0862
	try{
			 con=ConnectionManager.getConnection(p);			 
			 boolean cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","CERNER_PRACTITIONER_ID");
				if(cernerIdSiteSpecific){
				String pract_id_exists="";
				final String cernerpractid = "select practitioner_id from  am_practitioner where practitioner_long_id = ?" ;
				
				
				cernerPstmt = con.prepareStatement( cernerpractid ) ;
				cernerPstmt.setString( 1, cerner_practitioner_id) ;
				cernerRs = cernerPstmt.executeQuery() ;
				if(cernerRs!=null && cernerRs.next() ) {				 
				      pract_id_exists = cernerRs.getString(1);	
					  
					  if (pract_id_exists==null || pract_id_exists=="null" || pract_id_exists.equals("null")) pract_id_exists="";
					  
					   if(!pract_id_exists.equals("") && !pract_id_exists.equals(practitionerid)){				   
						updatable = false ;				
						java.util.Hashtable message = MessageManager.getMessage( locale, MIGRATION_PRACTITIONER_ID ,"Common") ;
						sb.append( (String) message.get("message") ) ;
						message.clear();						
					 }
				 }
			if(updatable){
				if(cernerRs!=null) cernerRs.close();		
				if(cernerPstmt!=null)cernerPstmt.close(); 
				String am_pract_id_exists="";
				final String amext_cernerpractid = "select practitioner_id from  am_ext_practitioner where practitioner_long_id = ?" ;				
				cernerPstmt = con.prepareStatement( amext_cernerpractid ) ;
				cernerPstmt.setString( 1, cerner_practitioner_id) ;
				cernerRs = cernerPstmt.executeQuery() ;
				if(cernerRs!=null && cernerRs.next() ) {				 
				    am_pract_id_exists = cernerRs.getString(1);					  
					if (am_pract_id_exists==null || am_pract_id_exists=="null" || am_pract_id_exists.equals("null")) am_pract_id_exists="";
					  
					if(!am_pract_id_exists.equals("") && !am_pract_id_exists.equals(practitionerid)){				   
						updatable = false ;				
						java.util.Hashtable message = MessageManager.getMessage( locale, MIGRATION_PRACTITIONER_ID ,"Common") ;
						sb.append( (String) message.get("message") ) ;
						message.clear();						
					}
				 }					
			}				 
			//if(cernerRs!=null) cernerRs.close(); //Moved for Checkstyle		
			//if(cernerPstmt!=null)cernerPstmt.close(); //Moved for Checkstyle
         }		
			
		}catch(Exception st){
			st.printStackTrace();
		}
		finally 
			  {
			  	//if (con != null)Commented for checkstyle
			  //	{Commented for checkstyle
			  		 try {
					   if(cernerRs!=null) cernerRs.close();	//Added for checkstyle	
					   if(cernerPstmt!=null)cernerPstmt.close(); //Added for checkstyle
						// ConnectionManager.returnConnection(con,p);	Commented for checkstyle	
		      			 }  
						 catch (Exception ee1) {
							 ee1.printStackTrace();
						 }
		      	   	 
		      //	} //Commented for checkstyle
			}			
		//End this CRF ML-MMOH-CRF-0862
			

		if ( updatable ) {
			try {
				  
				  //Below line commented for this CRF ML-MMOH-CRF-0862
			    //con=ConnectionManager.getConnection(p); Commented for checkstyle

				final String ctsql1="select count(*) as total from sm_facility_param where facility_id not in (select facility_id from am_pract_for_facility where  practitioner_id ='"+practitionerid+"')";
                
				pstmt2=con.prepareStatement(ctsql1);
				rs4=pstmt2.executeQuery();
                rs4.next();
                
				ct1=rs4.getInt("total");

				if(rs4 !=null) rs4.close();
				
				facilityid1=new String[ct1];
				
				String facsql1="select facility_id from sm_facility_param where facility_id not in (select facility_id from am_pract_for_facility where  practitioner_id ='"+practitionerid+"')";
				pstmt1=con.prepareStatement( facsql1 ) ;

				rs2=pstmt1.executeQuery();
                
				int j=0;
				while(rs2.next()) {
				facilityid1[j]=rs2.getString(1);
				insertable1=true;
				
				j++;
			} 
                if(rs2!=null)rs2.close();
				 if(pstmt2!=null)pstmt2.close();
				 if(pstmt1!=null)pstmt1.close();
				 
				 if(function_id.equals("PRACTITIONER"))
				{					 
				pstmt = con.prepareStatement( sbQuery.toString() );
				pstmt.setString	( 1, practtype ) ;
				pstmt.setString	( 2, practitionername ) ;
				pstmt.setString	( 3, shortname ) ;
				pstmt.setString	( 4, sex ) ;

				pstmt.setString	( 5, birthdate ) ;
				pstmt.setString	( 6, birthplace ) ;
				pstmt.setString	( 7, maritalstatus ) ;
				pstmt.setString	( 8, aliasname ) ;
				pstmt.setString	( 9, citizen ) ;
				pstmt.setString	( 10, nationalidno ) ;
				//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 11, credential1 ) ;
				pstmt.setString	( 12, credential2 ) ;
				pstmt.setString	( 13, credential3 ) ;
				//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 14, jobtitle ) ;
				pstmt.setString	( 15, emplstatus ) ;
				pstmt.setString	( 16, degree ) ;
				pstmt.setString ( 17, primaryspecialitycode ) ;
				pstmt.setString	( 18, allfacilities ) ;
				pstmt.setString	( 19, repfacility) ;
				pstmt.setString	( 20, restelno ) ;
				pstmt.setString	( 21, pagerno ) ;
				pstmt.setString	( 22, mobileno ) ;
				pstmt.setString	( 23, offtelno ) ;
				pstmt.setString	( 24, offtelext ) ;
				pstmt.setString	( 25, faxno ) ;
				pstmt.setString	( 26, emailid ) ;
				pstmt.setString	( 27, prefmode ) ;
				pstmt.setString	( 28, resaddln1 ) ;
				pstmt.setString	( 29, resaddln2 ) ;
				pstmt.setString	( 30, resaddln3  ) ;
				pstmt.setString	( 31, resaddln4 ) ;
				pstmt.setString	( 32, respostalcode ) ;
				pstmt.setString	( 33, rescountrycode ) ;
				pstmt.setString	( 34, offaddln1 ) ;
				pstmt.setString	( 35, offaddln2 ) ;
				pstmt.setString	( 36, offaddln3  ) ;
				pstmt.setString	( 37, offaddln4 ) ;
				pstmt.setString	( 38, offpostalcode ) ;
				pstmt.setString	( 39, offcountrycode ) ;
				pstmt.setString	( 40, mailaddln1 ) ;
				pstmt.setString	( 41, mailaddln2 ) ;
				pstmt.setString	( 42, mailaddln3  ) ;
				pstmt.setString	( 43, mailaddln4 ) ;
				pstmt.setString	( 44, mailpostalcode ) ;
				pstmt.setString	( 45, mailcountrycode ) ;
				pstmt.setDate	( 46, effective_date_from  ) ;
				pstmt.setDate	( 47, effective_date_to  ) ;
				pstmt.setString	( 48, effectiveStatus ) ;
				pstmt.setString	( 49, modifiedById ) ;
				//pstmt.setDate	( 50, modified_date ) ;
				pstmt.setString	( 50, modifiedFacilityId ) ;
				pstmt.setString	( 51, modifiedAtWorkstation ) ;
				pstmt.setString	( 52, employeeid ) ;
				pstmt.setString	( 53, degree1 ) ;
				pstmt.setString	( 54, univ1 ) ;
				pstmt.setString	( 55, year1 ) ;
				pstmt.setString	( 56, degree2 ) ;
				pstmt.setString	( 57, univ2 ) ;
				pstmt.setString	( 58, year2 ) ;
				pstmt.setString	( 59, degree3 ) ;
				pstmt.setString	( 60, univ3 ) ;
				pstmt.setString	( 61, year3 ) ;
				pstmt.setString	( 62, degree4 ) ;
				pstmt.setString	( 63, univ4 ) ;
				pstmt.setString	( 64, year4 ) ;
				pstmt.setString	( 65, con1 ) ;
				pstmt.setString	( 66, con2 ) ;
				pstmt.setString	( 67, con3 ) ;
				pstmt.setString	( 68, con4 ) ;
				pstmt.setString	( 69, det1 ) ;
				pstmt.setString	( 70, det2 ) ;
				pstmt.setString	( 71, det3 ) ;
				pstmt.setString	( 72, det4 ) ;
				pstmt.setString	( 73, apc_no ) ;
				pstmt.setString	( 74, longname ) ;				
				//Added HSA-CRF-160
				pstmt.setString	( 75, other_alt_type ) ;
				pstmt.setString	( 76, other_alt_no ) ;
				
				//Below line added for this CRF ML-MMOH-CRF-0862
				pstmt.setString	( 77, cerner_practitioner_id) ;

				pstmt.setString	( 78, fppPractYn);//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
				pstmt.setString	( 79, supervisor_yn);
				pstmt.setString	( 80, enable_virtual_consultation ) ;//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
				pstmt.setString ( 81, employee_service_number); //added by Lakshmanan for MO-CRF-20183
				pstmt.setString	( 82, practitionerid ) ;


				 res = pstmt.executeUpdate() ;
				}else
				{
					if(function_id.equals("EXT_PRACT"))
					{
					if(pstmt!=null)pstmt.close();
					pstmt = con.prepareStatement( sbQuery.toString() );
				pstmt.setString	( 1, practtype ) ;
				pstmt.setString	( 2, practitionername ) ;
				pstmt.setString	( 3, shortname ) ;
				pstmt.setString	( 4, sex ) ;

				pstmt.setString	( 5, birthdate ) ;
				pstmt.setString	( 6, birthplace ) ;
				pstmt.setString	( 7, maritalstatus ) ;
				pstmt.setString	( 8, aliasname ) ;
				pstmt.setString	( 9, citizen ) ;
				pstmt.setString	( 10, nationalidno ) ;
				//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 11, credential1 ) ;
				pstmt.setString	( 12, credential2 ) ;
				pstmt.setString	( 13, credential3 ) ;
				//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
				pstmt.setString	( 14, jobtitle ) ;
				pstmt.setString	( 15, emplstatus ) ;
				pstmt.setString	( 16, degree ) ;
				pstmt.setString ( 17, primaryspecialitycode ) ;
//				pstmt.setString	( 18, allfacilities ) ;
//				pstmt.setString	( 19, repfacility) ;
				pstmt.setString	(18, restelno ) ;
				pstmt.setString	( 19, pagerno ) ;
				pstmt.setString	( 20, mobileno ) ;
				pstmt.setString	( 21, offtelno ) ;
				pstmt.setString	( 22, offtelext ) ;
				pstmt.setString	( 23, faxno ) ;
				pstmt.setString	( 24, emailid ) ;
				pstmt.setString	( 25, prefmode ) ;
				pstmt.setString	( 26, resaddln1 ) ;
				pstmt.setString	( 27, resaddln2 ) ;
				pstmt.setString	( 28, resaddln3  ) ;
				pstmt.setString	( 29, resaddln4 ) ;
				pstmt.setString	( 30, respostalcode ) ;
				pstmt.setString	( 31, rescountrycode ) ;
				pstmt.setString	( 32, offaddln1 ) ;
				pstmt.setString	( 33, offaddln2 ) ;
				pstmt.setString	( 34, offaddln3  ) ;
				pstmt.setString	( 35, offaddln4 ) ;
				pstmt.setString	( 36, offpostalcode ) ;
				pstmt.setString	( 37, offcountrycode ) ;
				pstmt.setString	( 38, mailaddln1 ) ;
				pstmt.setString	( 39, mailaddln2 ) ;
				pstmt.setString	( 40, mailaddln3  ) ;
				pstmt.setString	( 41, mailaddln4 ) ;
				pstmt.setString	( 42, mailpostalcode ) ;
				pstmt.setString	( 43, mailcountrycode ) ;
				pstmt.setDate	( 44, effective_date_from  ) ;
				pstmt.setDate	( 45, effective_date_to  ) ;
				pstmt.setString	( 46, effectiveStatus ) ;
				pstmt.setString	( 47, modifiedById ) ;
				pstmt.setDate	( 48, modified_date ) ;
				pstmt.setString	( 49, modifiedFacilityId ) ;
				pstmt.setString	( 50, modifiedAtWorkstation ) ;
				pstmt.setString	( 51, employeeid ) ;
				pstmt.setString	( 52, degree1 ) ;
				pstmt.setString	( 53, univ1 ) ;
				pstmt.setString	( 54, year1 ) ;
				pstmt.setString	( 55, degree2 ) ;
				pstmt.setString	( 56, univ2 ) ;
				pstmt.setString	( 57, year2 ) ;
				pstmt.setString	( 58, degree3 ) ;
				pstmt.setString	( 59, univ3 ) ;
				pstmt.setString	( 60, year3 ) ;
				pstmt.setString	( 61, degree4 ) ;
				pstmt.setString	( 62, univ4 ) ;
				pstmt.setString	( 63, year4 ) ;
				pstmt.setString	( 64, con1 ) ;
				pstmt.setString	( 65, con2 ) ;
				pstmt.setString	( 66, con3 ) ;
				pstmt.setString	( 67, con4 ) ;
				pstmt.setString	( 68, det1 ) ;
				pstmt.setString	( 69, det2 ) ;
				pstmt.setString	( 70, det3 ) ;
				pstmt.setString	( 71, det4 ) ;
				pstmt.setString	( 72, apc_no ) ;
				pstmt.setString	( 73, longname ) ;
				//Added HSA-CRF-160
				pstmt.setString	( 74, other_alt_type ) ;
				pstmt.setString	( 75, other_alt_no ) ;				
				//Below line added for this CRF ML-MMOH-CRF-0862
				pstmt.setString	( 76, cerner_practitioner_id);

				pstmt.setString	( 77, fppPractYn);//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
				pstmt.setString	( 78, supervisor_yn);//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4
				pstmt.setString	( 79, enable_virtual_consultation ) ;//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
				pstmt.setString ( 80, employee_service_number); //added by Lakshmanan for MO-CRF-20183
				pstmt.setString	( 81, practitionerid) ;

				res= pstmt.executeUpdate();
					}
				}
                
				if ( res != 0 ) {
					result = true ;
					con.commit();
					

				}
pstmt.close();
if(function_id.equals("PRACTITIONER"))
				{
				if(allfacilities.equals("Y")) {
					for(j=0;j<facilityid1.length;j++) {
					 
					    //Below Query Modified for this CRF ML-MMOH-CRF-0862					
						String sql1="insert into am_pract_for_facility(facility_id, practitioner_id,eff_date_from, eff_date_to,eff_status,added_by_id,added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id,modified_at_ws_no,practitioner_long_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						String effectiveStatus1="E";

						if( insertable1 ) {
								try {
									pstmt1 = con.prepareStatement( sql1 );
									pstmt1.setString	( 1, facilityid1[j] ) ;
									pstmt1.setString	( 2, practitionerid ) ;
									pstmt1.setDate	( 3, effective_date_from ) ;
									pstmt1.setDate	( 4, effective_date_to ) ;
									pstmt1.setString	( 5, effectiveStatus1 ) ;
									pstmt1.setString	( 6, addedById ) ;
									pstmt1.setDate	( 7, added_date ) ;
									pstmt1.setString	( 8, addedFacilityId ) ;
									pstmt1.setString	( 9, addedAtWorkstation ) ;
									pstmt1.setString	( 10, modifiedById ) ;
									pstmt1.setDate	( 11, modified_date ) ;
									pstmt1.setString	( 12, modifiedFacilityId ) ;
									pstmt1.setString	( 13, modifiedAtWorkstation ) ;
									pstmt1.setString	( 14, cerner_practitioner_id ) ; //Added for this CRF ML-MMOH-CRF-0862
									int res1 = pstmt1.executeUpdate() ;

									if ( res1 != 0 ) {
									result = true ;
									con.commit();
									
				}
				else
				result=false;

				
				if(rs2 !=null) rs2.close();
				pstmt1.close();
							} 
							catch ( Exception e )
								{
								try{
										con.rollback();
			                       }catch(Exception ce){
									   ce.printStackTrace();
								   }
								sb.append( e.getMessage() + "<br>" ) ;
								e.printStackTrace() ;
							}

							

						}
					}
				}
			}
		if(result)
		{
			java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();

		}

				pstmt.close() ;
			} 
			catch ( Exception e ) 
				{
				try{
						con.rollback();
			       }
				   catch(Exception ce){
					   ce.printStackTrace();
				   }
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			  finally
			  {
			  	if (con != null)
			  	{
			  		 try {
					    //		con.close();
						 ConnectionManager.returnConnection(con,p);		
		      			 } catch (Exception ee) {
							 ee.printStackTrace();
						 }
		      	   	 //ConnectionManager.returnConnection(con,p);
		      	}
			}

	}

	results.put( "status", new Boolean(result) ) ;
	results.put("status", new Boolean(result1));
	results.put( "error", sb.toString() ) ;
	return results ;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return ( ((inputString == null) || (("").equals(inputString)) || (("null").equals(inputString)) ) ? defaultValue : inputString );
	}
}
