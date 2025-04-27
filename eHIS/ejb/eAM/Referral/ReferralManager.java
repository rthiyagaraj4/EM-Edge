/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.Referral ;


import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="Referral"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Referral"
*	local-jndi-name="Referral"
*	impl-class-name="eAM.Referral.ReferralManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.Referral.ReferralManagerLocal"
*	remote-class="eAM.Referral.ReferralManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.Referral.ReferralManagerLocalHome"
*	remote-class="eAM.Referral.ReferralManagerHome"
*	generate= "local,remote"
*
*
*/




public class ReferralManager implements SessionBean {
	Connection con ;
	PreparedStatement pstmt ;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

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
	public java.util.HashMap insertReferral(HashMap hashmap) {
							java.util.Properties p =(Properties) hashmap.get("p");
							String 	referralCode = (String) hashmap.get("referralCode"); 
							String  longDesc=(String)hashmap.get("longDesc");
							String  longName=(String)hashmap.get("longName");
							String  shortDesc=(String)hashmap.get("shortDesc");
							String  healthcareSettingType=(String)hashmap.get("healthCareSettingType");
							String  orgType=(String)hashmap.get("orgType");
							String  sourceUseAtRegnYn=(String)hashmap.get("sourceUseAtRegnYn");
							String  sourceUseAtVisitYn=(String)hashmap.get("sourceUseAtVisitYn");
							String  sourceUseAtAdmYn=(String)hashmap.get("sourceUseAtAdmYn");
							String  destUseAtConclYn=(String)hashmap.get("destUseAtConclYn");
							String  destUseAtDischYn=(String)hashmap.get("destUseAtDischYn");
							String  addLn1=(String)hashmap.get("addLn1");
							String  addLn2=(String)hashmap.get("addLn2");
							String  addLn3=(String)hashmap.get("addLn3");
							String  addLn4=(String)hashmap.get("addLn4");

							String  addtown=(String)hashmap.get("addtown");
							String  addarea=(String)hashmap.get("addarea");
							String  addregion=(String)hashmap.get("addregion");

							String  addPostalCode=(String)hashmap.get("addPostalCode");
							String  addCountryCode=(String)hashmap.get("addCountryCode");
							String  telNo=(String)hashmap.get("telNo");
							String  faxNo=(String)hashmap.get("faxNo");
							String  emailId=(String)hashmap.get("emailId");
							String effectiveDateFrom=(String)hashmap.get("effectiveDateFrom");
							String	 effectiveDateTo=(String)hashmap.get("effectiveDateTo");
							String	 effectiveStatus=(String)hashmap.get("effectiveStatus");
							String	 addedFacilityId=(String)hashmap.get("addedFacilityId");
							String	 addedAtWorkstation=(String)hashmap.get("addedAtWorkstation");
							String  applicability_for_direct_ord=(String)hashmap.get("applicability_for_direct_ord");
							String  linked_facility_id =(String)hashmap.get("linked_facility_id");
							String  source_use_at_lb_ord_yn=(String)hashmap.get("source_use_at_lb_ord_yn");
							String  source_use_at_rd_ord_yn=(String)hashmap.get("source_use_at_rd_ord_yn");
							String  source_use_at_ph_ord_yn=(String)hashmap.get("source_use_at_ph_ord_yn");
							String  source_pat_prefix=(String)hashmap.get("source_pat_prefix");
							String  ext_pat_ser_grp_code=(String)hashmap.get("ext_pat_ser_grp_code");
							String  contact_name=(String)hashmap.get("contact_name");
							String  contact_name_title=(String)hashmap.get("contact_name_title");
							String  applicability_for_tissue_coll=(String)hashmap.get("applicability_for_tissue_coll");
							String  source_donor_prefix=(String)hashmap.get("source_donor_prefix");
							String  donor_ser_grp_code=(String)hashmap.get("donor_ser_grp_code");  
							String locale="";
						 locale= p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String modifiedFacilityId = addedFacilityId ;

		String modifiedAtWorkstation = addedAtWorkstation ;

		hashmap.clear();

		try
		{
		
		String sql = "insert into am_referral (	" 		+
					" referral_code, "	+
					" long_desc,	short_desc, " 		+
					" healthcare_setting_type, org_type,	source_use_at_regn_yn, " 	+
					" source_use_at_visit_yn, 	source_use_at_adm_yn,  "	+
					" dest_use_at_concl_yn,		dest_use_at_disch_yn,  "	+
					" add_ln1,					add_ln2,"					+
					" add_ln3,					add_ln4,"					+
					" add_postal_code,			add_country_code,"			+
					" tel_no,					fax_no,"					+
					" email_id,					eff_date_from,	"			+
					" eff_date_to,				eff_status, 	"			+
					" added_by_id, 				added_date,		"			+
					" added_facility_id,		added_at_ws_no,	"			+
					" modified_by_id, 			modified_date,  "			+
					" modified_facility_id,		modified_at_ws_no, " 		+
					" applicability_for_direct_ord   , "+
					" linked_facility_id   , "+
					" source_use_at_lb_ord_yn   ,"+
					" source_use_at_rd_ord_yn   ,"+
					" source_use_at_ph_ord_yn   ,"+
					" SOURCE_EXT_PAT_PREFIX   ,"+
					" ext_pat_ser_grp_code   ,"+
					" contact_name    ,"+
					" contact_name_title   ,"+
					" applicability_for_tissue_coll  ,"+
					" source_donor_prefix   ,"+
					" donor_ser_grp_code ,"+
					" RES_TOWN_CODE   ,"+
					" RES_AREA_CODE   ,"+
					" REGION_CODE  , "+
					" long_name   "+
					" ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?,	   "		+
					" ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;

		String addedById = p.getProperty( "login_user" ) ;

		String modifiedById = addedById ;

		

		java.sql.Date effective_date_from = null ;
		java.sql.Date effective_date_to = null ;

		
		ResultSet rs = null;

		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from =java.sql.Date.valueOf( effectiveDateFrom ) ;

		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
			effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;

		try {
	
			con=ConnectionManager.getConnection(p);
            String duplicateSql="";
           // if(applicability_for_direct_ord.equals("E") || applicability_for_direct_ord.equals("N"))
			//{
				 duplicateSql = "select referral_code from am_referral where referral_code= ? " ;
				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt.setString( 1, referralCode ) ;

			//}
		/*	else{
				duplicateSql = "select referral_code from am_referral where ((APPLICABILITY_FOR_DIRECT_ORD = 'R' or APPLICABILITY_FOR_DIRECT_ORD = 'B') and LINKED_FACILITY_ID=?) or referral_code= ?";

			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, linked_facility_id ) ;
			pstmt.setString( 2, referralCode ) ;
			}*/
			rs = pstmt.executeQuery() ;

			if ( rs.next() ) {
				insertable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				sb.append( (String) message.get("message") ) ;

				message.clear();

			}
			if(rs!=null) rs.close();	
                       if(pstmt!=null)pstmt.close();
		} catch ( Exception e ) 
		{
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;

				
		}
				

		if ( insertable ) {
			try {
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1,  referralCode  ) ;
				pstmt.setString	( 2,  longDesc  ) ;
				pstmt.setString	( 3,  shortDesc  ) ;
				pstmt.setString	( 4,  healthcareSettingType  ) ;
				pstmt.setString	( 5,  orgType  ) ;
				pstmt.setString	( 6,  sourceUseAtRegnYn  ) ;
				pstmt.setString	( 7,  sourceUseAtVisitYn  ) ;
				pstmt.setString	( 8,  sourceUseAtAdmYn  ) ;
				pstmt.setString	( 9,  destUseAtConclYn  ) ;
				pstmt.setString	( 10, destUseAtDischYn  ) ;
				pstmt.setString	( 11, addLn1  ) ;
				pstmt.setString	( 12, addLn2  ) ;
				pstmt.setString	( 13, addLn3  ) ;
				pstmt.setString	( 14, addLn4  ) ;
				pstmt.setString	( 15, addPostalCode  ) ;
				pstmt.setString	( 16, addCountryCode  ) ;
				pstmt.setString	( 17, telNo ) ;
				pstmt.setString	( 18, faxNo  ) ;
				pstmt.setString	( 19, emailId  ) ;
				pstmt.setDate	( 20, effective_date_from ) ;
				pstmt.setDate	( 21, effective_date_to ) ;
				pstmt.setString	( 22, effectiveStatus ) ;
				pstmt.setString	( 23, addedById ) ;
				pstmt.setString	( 24, addedFacilityId ) ;
				pstmt.setString	( 25, addedAtWorkstation ) ;
				pstmt.setString	( 26, modifiedById ) ;
				pstmt.setString	( 27, modifiedFacilityId ) ;
				pstmt.setString	( 28, modifiedAtWorkstation ) ;

				pstmt.setString	( 29, applicability_for_direct_ord ) ;
				pstmt.setString	( 30, linked_facility_id ) ;
				pstmt.setString	( 31, source_use_at_lb_ord_yn ) ;
				pstmt.setString	( 32, source_use_at_rd_ord_yn ) ;
				pstmt.setString	( 33, source_use_at_ph_ord_yn ) ;
				pstmt.setString	( 34, source_pat_prefix ) ;
				pstmt.setString	( 35, ext_pat_ser_grp_code ) ;
				pstmt.setString	( 36, contact_name ) ;
				pstmt.setString	( 37, contact_name_title ) ;
				pstmt.setString	( 38, applicability_for_tissue_coll ) ;
				pstmt.setString	( 39, source_donor_prefix ) ;
				pstmt.setString	( 40, donor_ser_grp_code ) ;
				pstmt.setString	( 41, addtown ) ;
				pstmt.setString	( 42, addarea ) ;
				pstmt.setString	( 43, addregion ) ;
				pstmt.setString	( 44, longName ) ;

				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) 
				{
					result = true ;
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				pstmt.close() ;
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
	catch(Exception ee){
		ee.printStackTrace();
	}
	finally
	{
		if(con != null)      ConnectionManager.returnConnection(con,p);
	}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap updateReferral(HashMap hashmap){			
						java.util.Properties p = (Properties) hashmap.get("p");
							String 	referralCode = (String) hashmap.get("referralCode"); 
							String  longDesc=(String)hashmap.get("longDesc");
							String  longName=(String)hashmap.get("longName");
							String  shortDesc=(String)hashmap.get("shortDesc");
							String  healthcareSettingType=(String)hashmap.get("healthCareSettingType");
							String  orgType=(String)hashmap.get("orgType");
							String  sourceUseAtRegnYn=(String)hashmap.get("sourceUseAtRegnYn");
							String  sourceUseAtVisitYn=(String)hashmap.get("sourceUseAtVisitYn");
							String  sourceUseAtAdmYn=(String)hashmap.get("sourceUseAtAdmYn");
							String  destUseAtConclYn=(String)hashmap.get("destUseAtConclYn");
							String  destUseAtDischYn=(String)hashmap.get("destUseAtDischYn");
							String  addLn1=(String)hashmap.get("addLn1");
							String  addLn2=(String)hashmap.get("addLn2");
							String  addLn3=(String)hashmap.get("addLn3");
							String  addLn4=(String)hashmap.get("addLn4");

							String  addtown=(String)hashmap.get("addtown");
							String  addarea=(String)hashmap.get("addarea");
							String  addregion=(String)hashmap.get("addregion");

							String  addPostalCode=(String)hashmap.get("addPostalCode");
							String  addCountryCode=(String)hashmap.get("addCountryCode");
							String  telNo=(String)hashmap.get("telNo");
							String  faxNo=(String)hashmap.get("faxNo");
							String  emailId=(String)hashmap.get("emailId");
							String	effectiveDateFrom=(String)hashmap.get("effectiveDateFrom");
							String	effectiveDateTo=(String)hashmap.get("effectiveDateTo");
							String	effectiveStatus=(String)hashmap.get("effectiveStatus");
							String	addedFacilityId=(String)hashmap.get("addedFacilityId");
							String	addedAtWorkstation=(String)hashmap.get("addedAtWorkstation");
							String  applicability_for_direct_ord=(String)hashmap.get("applicability_for_direct_ord");
							String  linked_facility_id =(String)hashmap.get("linked_facility_id");
							String  source_use_at_lb_ord_yn=(String)hashmap.get("source_use_at_lb_ord_yn");
							String  source_use_at_rd_ord_yn=(String)hashmap.get("source_use_at_rd_ord_yn");
							String  source_use_at_ph_ord_yn=(String)hashmap.get("source_use_at_ph_ord_yn");
							String  source_pat_prefix=(String)hashmap.get("source_pat_prefix");
							String  ext_pat_ser_grp_code=(String)hashmap.get("ext_pat_ser_grp_code");
							String  contact_name=(String)hashmap.get("contact_name");
							String  contact_name_title=(String)hashmap.get("contact_name_title");
							String  applicability_for_tissue_coll=(String)hashmap.get("applicability_for_tissue_coll");
							String  source_donor_prefix=(String)hashmap.get("source_donor_prefix");
							String  donor_ser_grp_code=(String)hashmap.get("donor_ser_grp_code");
							String locale="";
							locale= p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sbQuery =  new StringBuffer() ;

		hashmap.clear();

		try
		{

			sbQuery.append("update am_referral set ");
			sbQuery.append(" long_desc 				= ?, ");
				sbQuery.append(" short_desc 				= ?, ");
				
				sbQuery.append(" healthcare_setting_type 	= ?, " );
				sbQuery.append(" org_type 					= ?, ");
				sbQuery.append(" source_use_at_regn_yn 	= ?, ");
				sbQuery.append(" source_use_at_visit_yn 	= ?, ");
				sbQuery.append(" source_use_at_adm_yn 		= ?, ");
				sbQuery.append(" dest_use_at_concl_yn 		= ?, ");
				sbQuery.append(" dest_use_at_disch_yn 		= ?, " );
				sbQuery.append(" add_ln1 					= ?, ");
				sbQuery.append(" add_ln2 					= ?, ");
				sbQuery.append(" add_ln3 					= ?, ");
				sbQuery.append(" add_ln4					= ?, ");
				sbQuery.append(" add_postal_code 			= ?, ");
				sbQuery.append(" add_country_code 			= ?, " );
				sbQuery.append(" tel_no 					= ?, ");
				sbQuery.append(" fax_no					= ?, ");
				sbQuery.append(" email_id 					= ?, " );
				sbQuery.append(" eff_date_from				= ?, " );
				sbQuery.append(" eff_date_to				= ?, ");
				sbQuery.append(" eff_status				= ?, ");
				sbQuery.append(" modified_by_id			= ?, ");
				sbQuery.append(" modified_date				= sysdate, ");
					sbQuery.append(" modified_facility_id		= ?, ");
					sbQuery.append("modified_at_ws_no 		= ?, ");
					sbQuery.append("applicability_for_direct_ord 		= ?, ");
					sbQuery.append(" linked_facility_id 		= ?, ");
					sbQuery.append(" source_use_at_lb_ord_yn 		= ?, " );
					sbQuery.append("source_use_at_rd_ord_yn 		= ?, " );
					sbQuery.append("source_use_at_ph_ord_yn 		= ?, " );
					sbQuery.append("SOURCE_EXT_PAT_PREFIX 		= ?, ");
					sbQuery.append("ext_pat_ser_grp_code 		= ?, ");
					sbQuery.append("contact_name 		= ?, ");
						sbQuery.append("contact_name_title 		= ?, ");
						sbQuery.append("applicability_for_tissue_coll 		= ?, ");
						sbQuery.append("source_donor_prefix 		= ?, ");
						sbQuery.append("donor_ser_grp_code 		= ?, ");
                       sbQuery.append("RES_TOWN_CODE 		= ?, ");
						sbQuery.append("RES_AREA_CODE 		= ?, ");
						sbQuery.append("REGION_CODE 		= ?, ");
						sbQuery.append("long_name 		= ? ");

sbQuery.append("where referral_code				= ? ");


					

		/*String sql = "update am_referral set " +
							" long_desc 				= ?, " +
							" short_desc 				= ?, " +
							" healthcare_setting_type 	= ?, " +
							" org_type 					= ?, " +
							" source_use_at_regn_yn 	= ?, " +
							" source_use_at_visit_yn 	= ?, " +
							" source_use_at_adm_yn 		= ?, " +
							" dest_use_at_concl_yn 		= ?, " +
							" dest_use_at_disch_yn 		= ?, " +
							" add_ln1 					= ?, " +
							" add_ln2 					= ?, " +
							" add_ln3 					= ?, " +
							" add_ln4 					= ?, " +
							" add_postal_code 			= ?, " +
							" add_country_code 			= ?, " +
							" tel_no 					= ?, " +
							" fax_no					= ?, " +
							" email_id 					= ?, " +
							" eff_date_from				= ?, " +
							" eff_date_to				= ?, " +
							" eff_status				= ?, " +
							" modified_by_id			= ?, " +
							" modified_date				= sysdate, " +
							" modified_facility_id		= ?, " +
							" modified_at_ws_no 		= ?, "  +
							" applicability_for_direct_ord 		= ?, "  +
							" linked_facility_id 		= ?, "  +
							" source_use_at_lb_ord_yn 		= ?, "  +
							" source_use_at_rd_ord_yn 		= ?, "  +
							" source_use_at_ph_ord_yn 		= ?, "  +
							" SOURCE_EXT_PAT_PREFIX 		= ?, "  +
							" ext_pat_ser_grp_code 		= ?, "  +
							" contact_name 		= ?, "  +
							" contact_name_title 		= ?, "  +
							" applicability_for_tissue_coll 		= ?, "  +
							" source_donor_prefix 		= ?, "  +
							" donor_ser_grp_code 		= ? "  +
						" where referral_code				= ? ";*/

						

		String modifiedById = p.getProperty( "login_user" ) ;

		java.sql.Date effective_date_from = null ;
		java.sql.Date effective_date_to = null ;
			String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
        // added on 06/01/2006
		// con=ConnectionManager.getConnection(p);
		/* if (change_val.equals("Y"))
		 {
		        try{
				String duplicateSql = "select referral_code from am_referral where ((APPLICABILITY_FOR_DIRECT_ORD = 'R' or APPLICABILITY_FOR_DIRECT_ORD = 'B') and LINKED_FACILITY_ID=?) ";
 				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt.setString( 1, linked_facility_id ) ;
				
				
				rs = pstmt.executeQuery() ;

				if ( rs.next() ) {
					updatable = false ;
					java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"SM" ) ;
					sb.append( (String) message.get("message") ) ;

					message.clear();

				}
				if(rs!=null) rs.close();	
						   if(pstmt!=null)pstmt.close();
				
		     }catch ( Exception e ) 
				{
				updatable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;

					
				}
				finally
				{
					if(con != null)      ConnectionManager.returnConnection(con,p);

				}
	        }*/
		//

		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;

		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
			effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;

		if ( updatable ) {
			try {			
				con=ConnectionManager.getConnection(p);
				pstmt = con.prepareStatement( sbQuery.toString() );
				pstmt.setString	( 1,  longDesc  ) ;
				pstmt.setString	( 2,  shortDesc  ) ;
				pstmt.setString	( 3,  healthcareSettingType  ) ;
				pstmt.setString	( 4,  orgType  ) ;
				pstmt.setString	( 5,  sourceUseAtRegnYn  ) ;
				pstmt.setString	( 6,  sourceUseAtVisitYn  ) ;
				pstmt.setString	( 7,  sourceUseAtAdmYn  ) ;
				pstmt.setString	( 8,  destUseAtConclYn  ) ;
				pstmt.setString	( 9,  destUseAtDischYn  ) ;
				pstmt.setString	( 10,  addLn1  ) ;
				pstmt.setString	( 11, addLn2  ) ;
				pstmt.setString	( 12, addLn3  ) ;
				pstmt.setString	( 13, addLn4  ) ;
				pstmt.setString	( 14, addPostalCode  ) ;
				pstmt.setString	( 15, addCountryCode  ) ;
				pstmt.setString	( 16, telNo ) ;
				pstmt.setString	( 17, faxNo  ) ;
				pstmt.setString	( 18, emailId  ) ;
				pstmt.setDate	( 19, effective_date_from  ) ;
				pstmt.setDate	( 20, effective_date_to  ) ;
				pstmt.setString	( 21, effectiveStatus ) ;
				pstmt.setString	( 22, modifiedById ) ;
				pstmt.setString	( 23, modifiedFacilityId ) ;
				pstmt.setString	( 24, modifiedAtWorkstation ) ;
				pstmt.setString	( 25, applicability_for_direct_ord ) ;
				pstmt.setString	( 26, linked_facility_id ) ;
				pstmt.setString	( 27, source_use_at_lb_ord_yn ) ;
				pstmt.setString	( 28, source_use_at_rd_ord_yn ) ;
				pstmt.setString	( 29, source_use_at_ph_ord_yn ) ;
				pstmt.setString	( 30, source_pat_prefix ) ;
				pstmt.setString	( 31, ext_pat_ser_grp_code ) ;
				pstmt.setString	( 32, contact_name ) ;
				pstmt.setString	( 33, contact_name_title ) ;
				pstmt.setString	( 34, applicability_for_tissue_coll ) ;
				pstmt.setString	( 35, source_donor_prefix ) ;
				pstmt.setString	( 36, donor_ser_grp_code ) ;
				pstmt.setString	( 37, addtown ) ;
				pstmt.setString	( 38, addarea ) ;
				pstmt.setString	( 39, addregion ) ;
				pstmt.setString	( 40, longName  ) ;
				pstmt.setString	( 41, referralCode  ) ;
				
				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) 
				{
					result = true ;
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}


				pstmt.close() ;
			}
			catch ( Exception e ) {
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
		catch (Exception ea){
			ea.printStackTrace();
		}
		finally
		{
			if(con != null)      ConnectionManager.returnConnection(con,p);

		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}

