/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to admit the patients.
@version - V3
*/ 
package eIP.IPBooking;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
import blbkin.*;
import eCommon.Common.*;
/**
*
* @ejb.bean
*	name="IPBooking"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPBooking"
*	local-jndi-name="IPBooking"
*	impl-class-name="eIP.IPBooking.IPBookingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPBooking.IPBookingLocal"
*	remote-class="eIP.IPBooking.IPBookingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPBooking.IPBookingLocalHome"
*	remote-class="eIP.IPBooking.IPBookingHome"
*	generate= "local,remote"
*
*
*/
public class IPBookingManager implements SessionBean 
{
	public void ejbCreate() {}
	public void ejbRemove(){}
	public void ejbActivate(){}
	public void ejbPassivate(){}

	public void setSessionContext(SessionContext context)
	{

	}

	/**
	This method is used to block the bed.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap insertIPBooking(java.util.Properties p,java.util.HashMap hashData)
	{
		boolean result						= true;
		StringBuffer		sb				= new StringBuffer("");
		Connection			con				= null;
		PreparedStatement	pstmt			= null;
		PreparedStatement	pstmt2			= null;
		Statement			Stmt 			= null;
		ResultSet			rset 			= null;
		ResultSet			rs20			= null;
		CallableStatement   cstmt			= null;
		java.util.HashMap		results		= new java.util.HashMap() ;
		String L_bkglstrefno				= "";
		String overRideMessage				= "";
		String ageGrpcode					= "";
		String checkbookinglimitby			= "";
		String setup_bl_dtls_in_ip_yn		= "N";
		String dlycharge					= "";
		String locale						= "";
		String facilityId					= "";
		String generatenumyn				= "";
		String bkglstrefno					= "";
		String medsergrpcode				= "";
		String block_bed_based_on			= "";
		String preferreddate				= "";
		String expected_discharge_date		= "";
		String multi_book_pat_yn			= "";
		String patientid					= "";
		String nameprefix					= "";
		String firstname					= "";
		String secondname					= "";
		String thirdname					= "";
		String familyname					= "";
		String namesuffix					= "";
		String name_prefix_oth_lang			= "";
		String first_name_oth_lang			= "";
		String second_name_oth_lang			= "";
		String third_name_oth_lang			= "";
		String family_name_oth_lang			= "";
		String name_suffix_oth_lang			= "";
		String patient_name_local_lang		= "";
		String patientname					= "";
		String gender						= "";
		String dateofbirth					= "";
		String restelno						= "";
		String othcontactno					= "";
		String emailid						= "";
		String nationalidno					= "";
		String altid1no						= "";
		String altid1expdate				= "";
		String altid1type					= "";
		String altid2no						= "";
		String altid2expdate				= "";
		String altid2type					= "";
		String altid3no						= "";
		String altid3expdate				= "";
		String altid3type					= "";
		String altid4no						= "";
		String altid4expdate				= "";
		String altid4type					= "";
		String oth_alt_id_type				= "";
		String oth_alt_id_no				= "";
		String resaddrline1					= "";
		String resaddrline2					= "";
		String resaddrline3					= "";
		String resaddrline4					= "";
		String postalcode					= "";
		String countrycode					= "";
		String res_town_code				= "";
		String res_area_code				= "";
		String res_region_code				= "";
		String mail_addr_line1				= "";
		String mail_addr_line2				= "";
		String mail_addr_line3				= "";
		String mail_addr_line4				= "";
		String mail_town_code				= "";
		String mail_area_code				= "";
		String mail_region_code				= "";
		String mail_postal_code				= "";
		String mail_country_code			= "";
		String patienttypecode				= "";
		String refsourcetype				= "";
		String referralcode					= "";
		String specilitycode				= "";
		String practitionerid				= "";
		String chiefcomplaint				= "";
		String otdatetime					= "";
		String overrideyn					= "";
		String bedclasscode					= "";
		String bedtypecode					= "";
		String nursingunitcode				= "";
		String nursingunittypecode			= "";
		String roomno						= "";
		String bedno						= "";
		String addedAtWorkstation			= "";
		String priorityind					= "";
		String ambreqddatetime				= "";
		String ambreqdyn					= "";
		String blooddonationyn				= "";
		String nationality					= "";
		String teamid						= "";
		String referral_id					= "";
		String exp_days_of_stay				= "";
		String service_code					= "";
		String eth_grp						= "";
		String eth_sub_grp					= "";
		String birth_place					= "";
		String citizen						= "";
		String legal						= "";
		String place_of_birth				= "";
		String confirm_yn					= "";
		String is_oa_yn						= "";
		String call_function				= "";
		String wait_list_ref_no				= "";
		String isBlInstalled				= "";
		String billing_interfaced			= "";
		String p_blng_grp_id				= "";
		String p_episode_status				= "";
		String chief_complaint				= "";
		String booking_remarks				= "";
		String patient_name_long				= "";
		String patient_name_loc_lang_long				= "";
		String booking_Type					= "";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order_code="";
		String surgery_order="";
		String surgery_order_id="";
		String surgery_order_line_no="";
		String surgery_order_date="";
		//End
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= "";
		String altAddrLine2		= "";
		String altAddrLine3		= "";
		String altAddrLine4		= "";
		String altAreaCode		= "";
		String altTownCode		= "";
		String altPostalCode	= "";
		String altRegionCode	= "";
		String altCountryCode	= "";
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";
		/*End*/
		TreeMap patInstructions=null; //included for the CRF RUT-CRF-013 - 23396
		boolean cancommit					= true;
		int bkgGracePeriod					= 0;
		int maxdlyBk						= 0;
		int maxmtlyBk						= 0;
		int MdlyBkg							= 0;
		int FdlyBkg							= 0;
		int UdlyBkg							= 0;
		int DatVal1							= 0;
		int DatVal2							= 0;
		int MaxtotBk						= 0;
		int chkval							= 0;
		try
		{
			
			//int dailycharge		= 0;
			//int p_package_bill_doc_num	= 0;
			//int p_visit_id		= 0;
			java.util.Hashtable		message		= new java.util.Hashtable() ;
			java.text.SimpleDateFormat dateFormat= new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			locale								= p.getProperty("LOCALE");
			facilityId							= (String)hashData.get("facilityId");
			generatenumyn						= (String)hashData.get("generatenumyn");
			bkglstrefno							= (String)hashData.get("bkglstrefno");
			medsergrpcode						= (String)hashData.get("medsergrpcode");
			block_bed_based_on					= (String)hashData.get("block_bed_based_on");
			preferreddate						= (String)hashData.get("preferreddate");
			expected_discharge_date				= (String)hashData.get("expected_discharge_date");
			StringTokenizer sttoks				= new StringTokenizer(preferreddate," ");
			String preferreddate_from			= sttoks.nextToken();
			String preferreddate_to				= preferreddate_from;
			//String block_from_date		= preferreddate;
			//String block_to_date		= expected_discharge_date;
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			smartCardFunc				= (String)hashData.get("smartCardFunc");
			biometric_reason				= checkForNull((String)hashData.get("biometric_reason"));
			//Ends
			if(block_bed_based_on.equals("P"))
			{
				preferreddate_from				= preferreddate_from+" 00:01";
				preferreddate_to				= preferreddate_to+" 23:59";
			}
			else if(block_bed_based_on.equals("E"))
			{
				preferreddate_from				= preferreddate;
				preferreddate_to				= expected_discharge_date;
			}

			multi_book_pat_yn					= (String)hashData.get("multi_book_pat_yn");
			patientid							= (String)hashData.get("patientid");
			nameprefix							= (String)hashData.get("nameprefix");
			firstname							= (String)hashData.get("firstname");
			secondname							= (String)hashData.get("secondname");
			thirdname							= (String)hashData.get("thirdname");
			familyname							= (String)hashData.get("familyname");
			namesuffix							= (String)hashData.get("namesuffix");

			name_prefix_oth_lang				= (String)hashData.get("name_prefix_oth_lang");
			first_name_oth_lang					= (String)hashData.get("first_name_oth_lang");
			second_name_oth_lang				= (String)hashData.get("second_name_oth_lang");
			third_name_oth_lang					= (String)hashData.get("third_name_oth_lang");
			family_name_oth_lang				= (String)hashData.get("family_name_oth_lang");
			name_suffix_oth_lang				= (String)hashData.get("name_suffix_oth_lang");
			patient_name_local_lang				= (String)hashData.get("patient_name_local_lang");
			patientname							= (String)hashData.get("patientname");
			patient_name_long							= (String)hashData.get("patient_name_long");
			patient_name_loc_lang_long							= (String)hashData.get("patient_name_loc_lang_long");

			gender								= (String)hashData.get("gender");
			dateofbirth							= (String)hashData.get("dateofbirth");
			restelno							= (String)hashData.get("restelno");
			othcontactno						= (String)hashData.get("othcontactno");
			emailid								= (String)hashData.get("emailid");
			nationalidno						= (String)hashData.get("nationalidno");
			altid1no							= (String)hashData.get("altid1no");
			altid1expdate						= (String)hashData.get("altid1expdate");
			altid1type							= (String)hashData.get("altid1type");
			altid2no							= (String)hashData.get("altid2no");
			altid2expdate						= (String)hashData.get("altid2expdate");
			altid2type							= (String)hashData.get("altid2type");
			altid3no							= (String)hashData.get("altid3no");
			altid3expdate						= (String)hashData.get("altid3expdate");
			altid3type							= (String)hashData.get("altid3type");
			altid4no							= (String)hashData.get("altid4no");
			altid4expdate						= (String)hashData.get("altid4expdate");
			altid4type							= (String)hashData.get("altid4type");
			oth_alt_id_type						= (String)hashData.get("oth_alt_id_type");
			oth_alt_id_no						= (String)hashData.get("oth_alt_id_no");
			resaddrline1						= (String)hashData.get("resaddrline1");
			resaddrline2						= (String)hashData.get("resaddrline2");
			resaddrline3						= (String)hashData.get("resaddrline3");
			resaddrline4						= (String)hashData.get("resaddrline4");
			postalcode							= (String)hashData.get("postalcode");
			countrycode							= (String)hashData.get("countrycode");
			res_town_code						= (String)hashData.get("res_town_code");
			res_area_code						= (String)hashData.get("res_area_code");
			res_region_code						= (String)hashData.get("res_region_code");
			mail_addr_line1						= (String)hashData.get("mail_addr_line1");
			mail_addr_line2						= (String)hashData.get("mail_addr_line2");
			mail_addr_line3						= (String)hashData.get("mail_addr_line3");
			mail_addr_line4						= (String)hashData.get("mail_addr_line4");
			mail_town_code						= (String)hashData.get("mail_town_code");
			mail_area_code						= (String)hashData.get("mail_area_code");
			mail_region_code					= (String)hashData.get("mail_region_code");
			mail_postal_code					= (String)hashData.get("mail_postal_code");
			mail_country_code					= (String)hashData.get("mail_country_code");
			patienttypecode						= (String)hashData.get("patienttypecode");
			refsourcetype						= (String)hashData.get("refsourcetype");
			referralcode						= (String)hashData.get("referralcode");
			specilitycode						= (String)hashData.get("specilitycode");
			practitionerid						= (String)hashData.get("practitionerid");
			chiefcomplaint						= (String)hashData.get("chiefcomplaint");
			otdatetime							= (String)hashData.get("otdatetime");
			overrideyn							= (String)hashData.get("overrideyn");
			bedclasscode						= (String)hashData.get("bedclasscode");
			bedtypecode							= (String)hashData.get("bedtypecode");
			nursingunitcode						= (String)hashData.get("nursingunitcode");
			nursingunittypecode					= (String)hashData.get("nursingunittypecode");
			roomno								= (String)hashData.get("roomno");
			bedno								= (String)hashData.get("bedno");
			addedAtWorkstation					= (String)hashData.get("client_ip_address");
			priorityind							= (String)hashData.get("priorityind");
			ambreqddatetime						= (String)hashData.get("ambreqddatetime");
			ambreqdyn							= (String)hashData.get("ambreqdyn");
			blooddonationyn						= (String)hashData.get("blooddonationyn");
			nationality							= (String)hashData.get("nationality");
			teamid								= (String)hashData.get("teamid");
			referral_id							= (String)hashData.get("referral_id");
			exp_days_of_stay					= (String)hashData.get("exp_days_of_stay");
			service_code						= (String)hashData.get("service_code");
			eth_grp								= (String)hashData.get("eth_grp");
			eth_sub_grp							= (String)hashData.get("eth_sub_grp");
			birth_place							= (String)hashData.get("birth_place");
			citizen								= (String)hashData.get("citizen");
			legal								= (String)hashData.get("legal");
			place_of_birth						= (String)hashData.get("place_of_birth");
			confirm_yn							= (String)hashData.get("confirm_yn");
			is_oa_yn							= (String)hashData.get("is_oa_yn");
			call_function						= (String)hashData.get("call_function");
			wait_list_ref_no					= (String)hashData.get("wait_list_ref_no");
			isBlInstalled						= (String)hashData.get("isBlInstalled");
			billing_interfaced					= (String)hashData.get("billing_interfaced");
			p_blng_grp_id						= (String)hashData.get("billing_group");
			p_episode_status					= (String)hashData.get("episodestatus");
			chief_complaint						= (String)hashData.get("chief_complaint");
			booking_remarks						= (String)hashData.get("booking_remarks");
			booking_Type						= (String)hashData.get("booking_Type");
			patInstructions=(java.util.TreeMap)hashData.get("patInstructions");//included for the CRF RUT-CRF-013 - 23396
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
			//Start
			surgery_order_code=(String)hashData.get("surgery_order_code");
			surgery_order=(String)hashData.get("surgery_order");
			surgery_order_id=(String)hashData.get("surgery_order_id");
			surgery_order_line_no=(String)hashData.get("surgery_order_line_no");
			surgery_order_date=(String)hashData.get("surgery_order_date");
			//End
			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
			altAddrLine1	= checkForNull((String)hashData.get("altAddrLine1"));
			altAddrLine2	= checkForNull((String)hashData.get("altAddrLine2"));
			altAddrLine3	= checkForNull((String)hashData.get("altAddrLine3"));
			altAddrLine4	= checkForNull((String)hashData.get("altAddrLine4"));
			altAreaCode		= checkForNull((String)hashData.get("altAreaCode"));
			altTownCode		= checkForNull((String)hashData.get("altTownCode"));
			altPostalCode	= checkForNull((String)hashData.get("altPostalCode"));
			altRegionCode	= checkForNull((String)hashData.get("altRegionCode"));
			altCountryCode	= checkForNull((String)hashData.get("altCountryCode"));
			/*End*/
			String patientclasscode	= "";
			String strBLMessage		= "";
			String strFunctionId	= "BOOKING";
			result = true;
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			String addedById			 = p.getProperty( "login_user" ) ;
			String addedDate			 = dateFormat.format( new java.util.Date() ) ;
			StringBuffer sbSql			 = new StringBuffer();
			int diff					 = 0 ;
			sb							 = new StringBuffer("");
			cancommit					 = true;

			//if(str_dailycharge.equals(""))		      dailycharge				= 0;
			//if(str_P_PACKAGE_BILL_DOC_NUM.equals("")) p_package_bill_doc_num		= 0;
			//if(str_P_VISIT_ID.equals(""))		      p_visit_id					= 0;

			java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;


			Stmt=con.createStatement();
			sbSql.append(" select setup_bl_dtls_in_ip_yn, TO_CHAR(TO_DATE('"+preferreddate+"','dd/mm/rrrr hh24:mi')+((1/(24*60))*60*bed_block_period_normal), ");
			sbSql.append(" 'dd/mm/rrrr hh24:mi') bed_block_period_normal , (TO_DATE('"+preferreddate+"','dd/mm/rrrr HH24:MI')-SYSDATE) diff, ");
			sbSql.append(" sign((sysdate+nvl(adv_bed_book_period_bkg,0)- (trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'))))) valid_flag, ");
			sbSql.append(" nvl(bkg_grace_period,0) bkg_grace_period, chk_booking_limit_by ");

			if(!otdatetime.equals(""))
				sbSql.append(" , sign(to_date('"+otdatetime+"','dd/mm/rrrr hh24:mi') - TO_DATE('"+preferreddate+"','DD/MM/rrrr hh24:mi')) L_SIGN ");

			sbSql.append(" , sign(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi') - ");
			sbSql.append(" TO_DATE('"+ambreqddatetime+"','DD/MM/rrrr hh24:mi')) R_SIGN ");
			sbSql.append(" from IP_PARAM where facility_id='"+facilityId+"' ");
			rs20 = Stmt.executeQuery(sbSql.toString());
			if(rs20!=null && rs20.next())
			{
				setup_bl_dtls_in_ip_yn  = rs20.getString("setup_bl_dtls_in_ip_yn");
				diff					= rs20.getInt("diff");
				chkval					= rs20.getInt("valid_flag");
				bkgGracePeriod			= rs20.getInt("bkg_grace_period");
				checkbookinglimitby		= rs20.getString("chk_booking_limit_by");
				DatVal2					= rs20.getInt("r_sign");
				if(!otdatetime.equals(""))
					DatVal1				= rs20.getInt("l_sign");
			
			}
			if(rs20!=null ) rs20.close();
			if(Stmt!=null ) Stmt.close();

			if(DatVal1 < 0)
			{
				cancommit = false;
				result    = false;
				message = MessageManager.getMessage(locale,"INVALID_OT_DATE","IP");

				sb.append((String ) message.get("message"));
				message.clear();
			}
			else if(DatVal2 < 0)
			{
				cancommit=false;
				result=false;
				message = MessageManager.getMessage(locale,"AMB_REQD_DATE_LT_PREF_DATE","IP");
				sb.append((String ) message.get("message"));
				message.clear();
			}
			else if(chkval < 0)	/**Check for the Nursing Unit type code under that Medical Service Group**/
			{
				cancommit	= false;
				result		= false;
				message = MessageManager.getMessage( locale, "PREFER_DATE_LT_EXCEEDED","IP");
				sb.append( (String) message.get("message")) ;
				message.clear();
			}
			else if(diff < 0)	
			{
				cancommit	= false;
				result		= false;
				message = MessageManager.getMessage( locale, "PREF_ADMDATE_NOT_LESS_SYSDATE","IP");
				sb.append( (String) message.get("message")) ;
				message.clear();
			}
			//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			
			/*if(cancommit && result && !(bedno==null || bedno.equals("")))
			{
				sbSql.append("select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+nursingunitcode+"' and req_bed_no = '"+bedno+"' AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE('"+block_from_date+"', 'DD/MM/YYYY HH24:MI')    AND TO_DATE('"+block_to_date+"', 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE('"+block_from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+block_to_date+"', 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE('"+block_from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+block_to_date+"','DD/MM/YYYY HH24:MI')))");
					
					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					int no_of_time_bed_booked = 0;
					if(rset.next())
					{
						no_of_time_bed_booked				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(Stmt != null) Stmt.close();
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());

					if(no_of_time_bed_booked > 0)
					{
						cancommit	= false;
						result		= false;
						message = MessageManager.getMessage( locale, "OVERLAP_BLOCK_TIME","IP");
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
			}*/

			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());			

			if(multi_book_pat_yn.equals("N"))
			{
				if(cancommit)
				{
					/** Check for the duplicate booking **/
					sbSql.append("Select * from ip_booking_list where patient_id = '"+patientid+"' ");
					sbSql.append(" and (booking_status = '0'  or booking_status = '1') and facility_id = '"+facilityId+"' and (trunc(PREFERRED_DATE) >= trunc(sysdate -"+bkgGracePeriod+")) ");
					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					if(rset.next())
					{
						cancommit = false;
						result    = false;
						message = MessageManager.getMessage( locale, "ONLY_ONE_OPEN_BKG","IP" ) ;
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
				}
				if(rset!=null ) rset.close();
				if(Stmt!=null ) Stmt.close();
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			}

			if(cancommit)
			{
				if((!nursingunitcode.equals("")))
				{
					/** check for the nursing unit rights for the medical service group **/
					sbSql.append(" SELECT med_ser_grp_code FROM ip_nursing_unit a, ip_med_ser_grp_nurs_ut_type b ");
					sbSql.append(" WHERE  b.facility_id = a.facility_id ");
					sbSql.append(" AND b.nursing_unit_type_Code = a.nursing_unit_type_code ");
					sbSql.append(" AND a.facility_id = '"+ facilityId +"'  ");
					sbSql.append(" AND nursing_unit_code = '"+nursingunitcode+"' ");
					sbSql.append(" AND b.med_ser_grp_code = '"+medsergrpcode+"' ");
					Stmt = con.createStatement();
					rset = Stmt.executeQuery( sbSql.toString() );
					if(rset!=null)
					{
						if(!rset.next())
						{
							cancommit	= false;
							result		= false;
							message = MessageManager.getMessage( locale, "INVALID_MSG_NUT_RIGHTS","IP" ) ;
							sb.append( (String) message.get("message")) ;
							message.clear();
						}
					}
				}
			}
			if(rset!=null ) rset.close();
			if(Stmt!=null ) Stmt.close();
/*
			if(cancommit && !otdatetime.equals(""))
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select sign(to_date('"+otdatetime+"','dd/mm/rrrr hh24:mi') - TO_DATE('"+preferreddate+"','DD/MM/rrrr hh24:mi')) L_SIGN FROM DUAL ");

				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());
				if (rset.next())
				{
					DatVal1 = rset.getInt(1);
					if (DatVal1 < 0)
					{
						cancommit = false;
						result    = false;
						message = MessageManager.getMessage(con,"INVALID_OT_DATE");
						sb.append((String ) message.get("message"));
						message.clear();
					}
				}
			}
			if(rset!=null ) rset.close();
			if(Stmt!=null ) Stmt.close();
*/
			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			/** check the booking reference no is duplicate or not **/

			if(generatenumyn.equals("N") && cancommit)
			{
				sbSql.append("SELECT '1' from IP_BOOKING_LIST where ");
				sbSql.append(" facility_id = '"+facilityId +"' and ");
				sbSql.append(" BKG_LST_REF_NO='"+bkglstrefno+"' ");
				Stmt=con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());
				if (rset.next())
				{
					cancommit = false;
					result	  = false;
					message = MessageManager.getMessage(locale,"DUPLICATE_REF_NO","IP");
					sb.append((String) message.get("message"));
					message.clear();
				}
			}
			if(rset!=null ) rset.close();
			if(Stmt!=null ) Stmt.close();

			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			if(cancommit)
			{
				/***	Check for the valid Nursing Unit  ***/
				if (!nursingunitcode.equals("") && !practitionerid.equals(""))
				{	
					/*** Check for the practioner have rights for this nursing unit or not **/
					sbSql.append(" Select count(*) from IP_NURSING_UNIT_FOR_PRACT where ");
					sbSql.append(" facility_id='"+facilityId +"' and nursing_unit_code='"+nursingunitcode+"' ");
					sbSql.append(" and practitioner_id='"+practitionerid+"' ");

					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					int pract_count = 0;
					if(rset.next())
					pract_count = rset.getInt(1);

					if(pract_count == 0)
					{
						cancommit = false;
						result    = false;
						message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP");
						sb.append((String) message.get("message"));
						message.clear();
					}
					if(rset!=null ) rset.close();
					if(Stmt!=null ) Stmt.close();

					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					/** Check for the speciality of the nursing unit **/
					sbSql.append(" Select count(*) from ip_nurs_unit_for_specialty a, am_speciality b where ");
					sbSql.append(" a.facility_id='"+facilityId +"' and a.nursing_unit_code='"+nursingunitcode+"' ");
					sbSql.append(" and a.specialty_code = b.speciality_code and b.eff_status = 'E' and a.specialty_code='"+specilitycode+"' ");
					Stmt=con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					int spl_count = 0;
					if(rset.next())
					spl_count = rset.getInt(1);
					if(rset != null) rset.close();
					if(Stmt != null) Stmt.close();
					if(spl_count == 0)
					{
						cancommit = false;
						result    = false;
						message = MessageManager.getMessage(locale,"SPLTY_ADMN_RIGHTS_DENIED","IP");
						sb.append((String) message.get("message"));
						message.clear();
					}

					/** valid Age group and gender for the nursing unit **/
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" SELECT age_group_code , appl_patient_class from IP_NURSING_UNIT ");
					sbSql.append(" WHERE facility_id='"+facilityId +"' and nursing_unit_code='"+nursingunitcode+"' ");

					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());

					if (rset.next())
					{
						String  agegroupcode = rset.getString("age_group_code");
						patientclasscode	 = rset.getString("appl_patient_class");

						if (agegroupcode != null)
						{
							if(rset != null) rset.close();
							if(Stmt != null) Stmt.close();
							/** Check for the nursing unit of age or gender validation **/
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select '1' from AM_AGE_GROUP Where age_group_code='"+agegroupcode+"'  And NVL(GENDER,'"+gender+"')= '"+gender+"' AND  trunc(SYSDATE)- "); 
							sbSql.append(" to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
							Stmt = con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());

							if(!rset.next())
							{
								cancommit = false;
								result    = false;
								message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}
						}
					}
				}	
			}
			if(rset!=null ) rset.close();
			if(Stmt!=null ) Stmt.close();
			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());


			if(cancommit)
			{
				/*** Check for valid Bed ***/
				if (!bedno.equals(""))
				{
					if (nursingunitcode.equals("") ||  bedclasscode.equals(""))
					{
						cancommit=false;
						result=false;
						message = MessageManager.getMessage(locale,"NU_AND_BC_NOTNULL","IP");
						sb.append((String) message.get("message"));
						message.clear();
					}
					else
					{
						/** Check for valid Bed  **/
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select occupying_patient_id, bed_type_code, sex_spec_ind, bed_class_code, specialty_code from IP_NURSING_UNIT_BED ");
						sbSql.append(" WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
						sbSql.append(" And bed_no='"+bedno+"' ");

						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());
						if(rset.next())
						{	
							bedtypecode       = rset.getString(2);
							//String OPatId     = rset.getString(1);
							String splty_code = rset.getString(5);
							if (splty_code==null)	splty_code	  = "";
							/*if (OPatId != null)
							{
								cancommit = false;
								result	  = false;
								message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}*/

							if (!rset.getString("bed_class_code").equalsIgnoreCase(bedclasscode))
							{
								cancommit = false;
								result	  = false;
								message = MessageManager.getMessage(locale,"INVALID_BED_CLASS","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}

							if ((rset.getString("sex_spec_ind") != null) &&(!rset.getString("sex_spec_ind").equalsIgnoreCase(gender)))
							{
								cancommit = false;
								result    = false;
								message=MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}

							if(result)
							{
								if (!splty_code.equals("") && !splty_code.equals(specilitycode))
								{
									cancommit = false;
									result    = false;
									message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
							}
						}
						else
						{
							cancommit = false;
							result    = false;
							message = MessageManager.getMessage(locale,"INVALID_BED","Common");
							sb.append((String) message.get("message"));
							message.clear();
						}
						if(rset!=null ) rset.close();
						if(Stmt!=null ) Stmt.close();

						/** Check for Blocked/Booked beds **/
						overRideMessage = "";
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						/*
						sbSql.append(" Select booking_type, override_yn from ip_bed_booking ");
						sbSql.append("WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunitcode+"' ");
						sbSql.append(" and req_bed_no='"+bedno+"' and booking_status='0' and sysdate between blocked_from_date_time ");
						sbSql.append(" and blocked_until_date_time ");
						*/
						/*Wednesday, November 24, 2010 , SRR20056-SCF-6065-IN025197*/
						sbSql.append(" Select booking_type, override_yn from ip_bed_booking ");
						sbSql.append("WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunitcode+"' ");
						sbSql.append(" and req_bed_no='"+bedno+"' and booking_status='0' and ( to_date('"+preferreddate_from+"','dd/mm/rrrr hh24:mi') between blocked_from_date_time ");
						sbSql.append(" and blocked_until_date_time or to_date('"+preferreddate_to+"','dd/mm/rrrr hh24:mi') between blocked_from_date_time and blocked_until_date_time) ");

						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());

						if (rset.next())
						{
							String bkType = rset.getString(1);
							if(bkType == null) bkType = "";
							String orVal  = rset.getString(2);
							if(orVal == null) orVal = "";

							if (orVal.equals("N"))
							{
								if (bkType.equals("L"))
								{
									cancommit = false;
									result    = false;
									message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP");
									sb.append((String) message.get("message"));
									message.clear();
								}
								else
								{
									cancommit = false;
									result    = false;
									message = MessageManager.getMessage(locale,"BLOCKED_BED","IP");
									sb.append((String) message.get("message"));
									message.clear();
								}
							}
							else
							{
								if (bkType.equals("L"))
								{
									message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP");
									overRideMessage = ((String) message.get("message"));
									message.clear();
								}
								else
								{
									message = MessageManager.getMessage(locale,"OVERRIDEABLE_BLOCKING","IP");
									overRideMessage = ((String) message.get("message"));
									message.clear();
								}
							}
						}//E.O.IF
					}
				}//E.O.IF for (!bed_no.equals(""))
			}
			if(rset != null) rset.close();
			if(Stmt!=null ) Stmt.close();
			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			//if(cancommit & (confirm_yn.equals("Y")))by Sudhakar as validations of booking limit should fire irrespective of confirm booking or create booking.
			if(cancommit){
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				/** Checking for the daily booking limits **/
				sbSql.append(" Select MAX_NO_OF_DLY_BOOKING,MAX_NO_OF_MTHLY_BOOKING from ip_medical_service_group ");
				sbSql.append(" where facility_id='"+facilityId+"' and	med_ser_grp_code='"+medsergrpcode+"' ");

				Stmt=con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());

				if(rset.next())
				{
					maxdlyBk  = rset.getInt(1);
					maxmtlyBk = rset.getInt(2);
					if (maxdlyBk != 0)
					{
						if(rset != null) rset.close();
						if(Stmt != null) Stmt.close();

						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select tot_bkngs_confirmed+tot_bkngs_pending  as tot_booked ");
						sbSql.append(" from ip_dly_med_ser_grp_bkg_stat where facility_id='"+facilityId+"' ");
						sbSql.append(" and  med_ser_grp_code='"+medsergrpcode+"' and  trunc(preferred_date) = trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");

						Stmt=con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());

						if(rset.next())
						{
							int totBk = rset.getInt("tot_booked") ;
							if (maxdlyBk <= totBk)
							{
								cancommit = false;	
								result    = false;
								message = MessageManager.getMessage(locale,"MSG_DLY_LT_EXCEEDS","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}
						}
					}
					if(rset != null) rset.close();
					if(Stmt != null) Stmt.close();

					/** Checking for monthly booking limits **/
					if(maxmtlyBk != 0)
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				
/*1*/					sbSql.append(" Select tot_bkngs_confirmed+tot_bkngs_pending as tot_booked ");
						sbSql.append(" from IP_MLY_MED_SER_GRP_BKG_STAT where facility_id='"+facilityId+"' ");
						sbSql.append(" and  med_ser_grp_code='"+medsergrpcode+"' and  to_char(preferred_month,'mm/rrrr') = to_char(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'mm/rrrr') ");
						Stmt=con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());

						if(rset.next())
						{
							int totBk = rset.getInt("tot_booked") ;
							if (maxmtlyBk <= totBk)
							{
								cancommit = false;	
								result    = false;
								message = MessageManager.getMessage(locale,"MSG_MLY_LT_EXCEEDS","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}
						}
					}
				}
				if(rset != null) rset.close();
				if(Stmt!=null ) Stmt.close();
				/** Check the booking limit for nursing unit code **/
				if (checkbookinglimitby.equals("1"))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking,max_total_dly_booking from ip_book_limit_by_nurs_ut ");
					sbSql.append(" where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
					sbSql.append(" and bed_class_code='"+bedclasscode+"'	");
					Stmt=con.createStatement();

					rset = Stmt.executeQuery(sbSql.toString());
					if(rset.next())
					{
						MdlyBkg  = rset.getInt(1);
						FdlyBkg  = rset.getInt(2);
						UdlyBkg  = rset.getInt(3);
						MaxtotBk = rset.getInt(4);
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						if(rset != null) rset.close();
						if(Stmt != null) Stmt.close();
						sbSql.append(" Select  male_bkngs_confirmed+male_bkngs_pending male_booked, female_bkngs_confirmed+female_bkngs_pending female_booked ,");
						sbSql.append(" unknown_bkngs_confirmed+unknown_bkngs_pending unknown_booked,tot_bkngs_confirmed+tot_bkngs_pending  tot_booked ");
						sbSql.append(" from ip_dly_nurs_ut_bkg_stat where facility_id='"+ facilityId+"' and nursing_unit_code='"+nursingunitcode+"' and ");
						sbSql.append(" bed_class_code='"+bedclasscode+"' and trunc(preferred_date) = ");
						sbSql.append(" trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());
						/* proceed only if result set not null changed by Nanda 28/09/2002 */
						if (rset.next())
						{
							int Mbooked = rset.getInt(1);
							int Fbooked = rset.getInt(2);
							int Ubooked = rset.getInt(3);
							int TotBook = rset.getInt(4);
							int l_limit_exceed = 0;
							if(gender.equals("M"))//gender is male
							{
								if(MdlyBkg!= 0)
								{
									if (MdlyBkg <= Mbooked)
										l_limit_exceed = 1;
								}
								else
								{
									if (MaxtotBk < TotBook)
										l_limit_exceed = 1;
								}
							}
							else if(gender.equals("F"))//Gender is Female
							{
								if(FdlyBkg!= 0)
								{
									if (FdlyBkg <= Fbooked)
										l_limit_exceed = 1;
								}
								else
								{
									if (MaxtotBk < TotBook)
										l_limit_exceed = 1;
								}
							}
							else if(gender.equals("U"))//Gender is Unknown
							{
								if(UdlyBkg!=0)
								{
									if (UdlyBkg <= Ubooked)
										l_limit_exceed = 1;
								}
								else
								{
									if (MaxtotBk < TotBook)
										l_limit_exceed = 1;
								}
							}
							if (l_limit_exceed == 1)
							{
								cancommit=false;	
								result=false;
								message = MessageManager.getMessage(locale,"NUR_UT_LT_EXCEEDS","IP");
								sb.append((String) message.get("message"));
								message.clear();
							}
						}
					}
					if(rset != null) rset.close();
					if(Stmt!=null ) Stmt.close();
				}
				else
				{
					if (checkbookinglimitby.equals("2"))
					{
						MdlyBkg  = 0;
						FdlyBkg  = 0;
						UdlyBkg  = 0;
						MaxtotBk = 0;
						/** Check the booking limit for age group **/
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select age_group_code from ip_book_limit_by_age_grp where facility_id='"+facilityId+"' and bed_class_code='"+bedclasscode+"' ");
						sbSql.append(" and age_group_code in(select age_group_code from am_age_group where NVL(GENDER,'"+gender+"')= '"+gender+"' AND trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') ");
						sbSql.append(" BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE) ");
						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());
						if(rset.next())
						{
							ageGrpcode = rset.getString(1);
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking, max_total_dly_booking from ip_book_limit_by_age_grp ");
							sbSql.append(" where facility_id='"+facilityId+"' and age_group_code='"+ageGrpcode+"' ");
							sbSql.append(" and bed_class_code='"+bedclasscode+"' ");
							if(rset != null) rset.close();
							if(Stmt!=null ) Stmt.close();
							Stmt = con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());
							if(rset.next())
							{
								MdlyBkg  = rset.getInt(1);
								FdlyBkg  = rset.getInt(2);
								UdlyBkg  = rset.getInt(3);
								MaxtotBk = rset.getInt(4);
								if(rset != null) rset.close();
								if(Stmt != null) Stmt.close();

								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append("Select  (male_bkngs_confirmed+male_bkngs_pending) male_booked, (female_bkngs_confirmed+female_bkngs_pending) female_booked, (unknown_bkngs_confirmed+unknown_bkngs_pending) unknown_booked, ");
								sbSql.append(" (tot_bkngs_confirmed+tot_bkngs_pending)  tot_booked from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' and age_group_code ='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
								sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
								if(rset != null) rset.close();
								if(Stmt!=null ) Stmt.close();
								Stmt = con.createStatement();
								rset = Stmt.executeQuery(sbSql.toString());
								if (rset.next())
								{
									int Mbooked = rset.getInt(1);
									int Fbooked = rset.getInt(2);
									int Ubooked = rset.getInt(3);
									int TotBook = rset.getInt(4);
									int l_limit_exceed = 0;

									if(gender.equals("M"))//gender is male
									{
										if(MdlyBkg!= 0)
										{
											if (MdlyBkg <= Mbooked)
												l_limit_exceed = 1;
										}
										else
										{
											if (MaxtotBk < TotBook)
												l_limit_exceed = 1;
										}
									}
									else if(gender.equals("F"))//Gender is Female
									{
										if(FdlyBkg!= 0)
										{
											if (FdlyBkg <= Fbooked)
												l_limit_exceed = 1;
										}
										else
										{
											if (MaxtotBk < TotBook)
												l_limit_exceed = 1;
										}
									}
									else if(gender.equals("U"))//Gender is Unknown
									{
										if(UdlyBkg!=0)
										{
											if (UdlyBkg <= Ubooked)
												l_limit_exceed = 1;
										}
										else
										{
											if (MaxtotBk < TotBook)
												l_limit_exceed = 1;
										}
									}
									if (l_limit_exceed == 1)
									{	
										cancommit = false;	
										result    = false;
										message = 	MessageManager.getMessage(locale,"AGE_GRP_LT_EXCEEDS","IP");
										sb.append((String) message.get("message"));
										message.clear();
									}
								}
							}
						}
						if(rset != null) rset.close();
						if(Stmt!=null ) Stmt.close();
					}
				}
			}


			// Generating ref no if generatenumyn = y
			if(cancommit)
			{
				if(generatenumyn.equals("Y"))
				{
					/*
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("select decode(prefix_required_yn,'Y',med_ser_grp_code,'00')|| ");
					sbSql.append(" ltrim(to_char(next_seq_no,'0000000009')) ref_no from ip_medical_service_group where facility_id=? and med_ser_grp_code = ? ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					rset=pstmt.executeQuery();
					rset.next();
					//String lockTable = "LOCK TABLE ip_medical_service_group IN SHARE ROW EXCLUSIVE MODE";

					L_bkglstrefno = rset.getString("ref_no");
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					// check the booking reference no is duplicate or not 
					sbSql.append("SELECT '1' from IP_BOOKING_LIST where ");
					sbSql.append(" facility_id = '"+facilityId +"' and ");
					sbSql.append(" BKG_LST_REF_NO='"+L_bkglstrefno+"' ");
					Stmt=con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					if (rset.next())
					{
						cancommit = false;
						result	  = false;
						message = MessageManager.getMessage(locale,"DUPLICATE_REF_NO","IP");
						sb.append((String) message.get("message"));
						message.clear();
					}
					if(rset!=null ) rset.close();
					if(Stmt!=null ) Stmt.close();
					if(cancommit)
					{
						StringBuffer updsql = new StringBuffer();
						updsql.append(" Update ip_medical_service_group set next_seq_no=next_seq_no+1 ");
						updsql.append(" WHERE  facility_id= ? and  med_ser_grp_code= ? ");
						if(pstmt!=null) pstmt.close();
						if(rset!= null) rset.close();
						pstmt = con.prepareStatement( updsql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, medsergrpcode ) ;

						pstmt.executeUpdate();
					}*/

					/*Thursday, May 13, 2010 ,update for next_seq_no on ip_medical_service_group will be done through below procedure*/
					try
					{
						cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BKG_LST_REF_NO(?,?,?,?,?)}");
						cstmt.setString(1,facilityId);
						cstmt.setString(2,medsergrpcode);
						cstmt.setString(3,addedAtWorkstation);
						cstmt.setString(4,addedById);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
						cstmt.execute();
						L_bkglstrefno=cstmt.getString(5);
						if(L_bkglstrefno == null) L_bkglstrefno="";
						if(cstmt != null) cstmt.close();
					}
					catch (Exception ex)
					{
						cancommit = false;
						result=false;
						ex.printStackTrace();
					}
					
				}
				else
					L_bkglstrefno = bkglstrefno;
			
				try
				{
					/** Inserting the booking details into ip_booking list table **/
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" INSERT into IP_BOOKING_LIST   ");
					sbSql.append(" (facility_id ,  " );
					sbSql.append(" bkg_lst_ref_no ,");
					sbSql.append(" med_ser_grp_code ,");
					sbSql.append(" preferred_date , ");
					sbSql.append(" patient_id,");
					sbSql.append(" name_prefix,");
					sbSql.append(" first_name,");
					sbSql.append(" second_name, ");
					sbSql.append(" third_name,");
					sbSql.append(" family_name,");
					sbSql.append(" name_suffix,");
					sbSql.append(" patient_name,");
					sbSql.append(" gender,");
					sbSql.append(" date_of_birth, ");
					sbSql.append(" res_tel_no,");
					sbSql.append(" oth_contact_no,");
					sbSql.append(" email_id,");
					sbSql.append(" national_id_no, ");
					sbSql.append(" alt_id1_no,");
					sbSql.append(" ALT_ID1_EXP_DATE,");
					sbSql.append(" ALT_ID1_TYPE,");
					sbSql.append(" ALT_ID2_NO,");
					sbSql.append(" ALT_ID2_EXP_DATE,");
					sbSql.append(" ALT_ID2_TYPE,");
					sbSql.append(" ALT_ID3_NO,");
					sbSql.append(" ALT_ID3_EXP_DATE,");
					sbSql.append(" ALT_ID3_TYPE,");
					sbSql.append(" ALT_ID4_NO,");
					sbSql.append(" ALT_ID4_EXP_DATE,");
					sbSql.append(" ALT_ID4_TYPE,");
					sbSql.append(" OTH_ALT_ID_TYPE,");
					sbSql.append(" OTH_ALT_ID_NO,");
					sbSql.append(" res_addr_line1,");
					sbSql.append(" res_addr_line2,");
					sbSql.append(" res_addr_line3,");
					sbSql.append(" res_addr_line4, ");
					sbSql.append(" postal_code,");
					sbSql.append(" country_code,");
					sbSql.append(" RES_TOWN_CODE,");
					sbSql.append(" RES_AREA_CODE,");
					sbSql.append(" RES_REGION_CODE,");
					sbSql.append(" MAIL_ADDR_LINE1,");
					sbSql.append(" MAIL_ADDR_LINE2,");
					sbSql.append(" MAIL_ADDR_LINE3,");
					sbSql.append(" MAIL_ADDR_LINE4,");
					sbSql.append(" MAIL_TOWN_CODE,");
					sbSql.append(" MAIL_AREA_CODE,");
					sbSql.append(" MAIL_REGION_CODE,");
					sbSql.append(" MAIL_POSTAL_CODE,");
					sbSql.append(" MAIL_COUNTRY_CODE,");
					sbSql.append(" patient_type_code,");
					sbSql.append(" patient_class_code, ");
					sbSql.append(" ref_source_type,");
					sbSql.append(" referral_code,");
					sbSql.append(" specialty_code,");
					sbSql.append(" practitioner_id,");
					sbSql.append(" chief_complaint, ");
					sbSql.append(" ot_date_time,");
					sbSql.append(" override_yn,");
					sbSql.append(" bed_class_code,");
					sbSql.append(" bed_type_code, ");
					sbSql.append(" nursing_unit_code,");
					sbSql.append(" nursing_unit_type_code, ");
					sbSql.append(" room_no,");
					sbSql.append(" bed_no, ");
					sbSql.append(" booking_date_time,");
					sbSql.append(" booked_by_id, ");
					sbSql.append(" booking_status , ");
					sbSql.append(" added_by_id,");
					sbSql.append(" added_date,");
					sbSql.append(" added_facility_id,");
					sbSql.append(" added_at_ws_no, " );
					sbSql.append(" modified_by_id,");
					sbSql.append(" modified_date,");
					sbSql.append(" modified_facility_id,");
					sbSql.append(" modified_at_ws_no, ");
					sbSql.append(" priority_ind, ");
					sbSql.append(" amb_reqd_date_time, ");
					sbSql.append(" amb_reqd_yn, ");
					sbSql.append(" blood_donation_yn, ");
					sbSql.append(" nationality_code,   ");
					sbSql.append(" team_id,   ");
					sbSql.append(" referral_id,   ");
					sbSql.append(" exp_days_of_stay, ");
					sbSql.append(" service_code, ");
					sbSql.append(" ETHNIC_GRP_CODE, ");
					sbSql.append(" RACE_CODE, ");
					sbSql.append(" BIRTH_PLACE_CODE,");
					sbSql.append(" CITIZEN_YN, ");
					sbSql.append(" LEGAL_ILLEGAL_YN,");
					sbSql.append(" BIRTH_PLACE_DESC, ");

					sbSql.append(" NAME_PREFIX_LOC_LANG, ");
					sbSql.append(" FIRST_NAME_LOC_LANG, ");
					sbSql.append(" SECOND_NAME_LOC_LANG, ");
					sbSql.append(" THIRD_NAME_LOC_LANG, ");
					sbSql.append(" FAMILY_NAME_LOC_LANG, ");
					sbSql.append(" NAME_SUFFIX_LOC_LANG, ");
					sbSql.append(" PATIENT_NAME_LOC_LANG, ");
					sbSql.append(" EXPECTED_DISCHARGE_DATE, ");
					sbSql.append(" BOOKING_REMARKS, ");
					sbSql.append(" DIAGNOSIS_REMARKS,");
					sbSql.append(" BOOKING_TYPE_CODE,");
					sbSql.append(" PATIENT_LONG_NAME,");
					sbSql.append(" PATIENT_LONG_NAME_LOC_LANG,");
					//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
					//Start
					sbSql.append(" ORDER_ID,");
					sbSql.append(" ORDER_LINE_NO,");
					sbSql.append(" OPER_CODE,");
					sbSql.append(" OPER_SHORT_DESC,");
					sbSql.append(" PREF_SURG_DATE,");
					//End
					/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
					sbSql.append(" ALT_ADDR_LINE1,");
					sbSql.append(" ALT_ADDR_LINE2,");
					sbSql.append(" ALT_ADDR_LINE3,");
					sbSql.append(" ALT_ADDR_LINE4,");
					sbSql.append(" ALT_TOWN_CODE,");
					sbSql.append(" ALT_AREA_CODE,");
					sbSql.append(" ALT_REGION_CODE,");
					sbSql.append(" ALT_POSTAL_CODE,");
					sbSql.append(" ALT_COUNTRY_CODE");
					/*End*/
					sbSql.append(" ) values ( ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?,?,?,?, ?, ?, ?,to_date(?,'dd/mm/rrrr'), ?, ?,?,?,?,to_date(?,'dd/mm/rrrr'), ?, ?,to_date(?,'dd/mm/rrrr'), ?, ?,to_date(?,'dd/mm/rrrr'), ?, ?,to_date(?,'dd/mm/rrrr'),?,?,?,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?,?,?,?,?,sysdate, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,? ,to_date(?,'dd/mm/rrrr hh24:mi') ,? ,?, ?, ? , ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr'),?,?,?,?,?,?,?,?,?)");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString());
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, L_bkglstrefno ) ;
					pstmt.setString	( 3, medsergrpcode ) ;
					pstmt.setString	( 4, preferreddate);
					pstmt.setString	( 5, patientid ) ;
					pstmt.setString	( 6, nameprefix ) ;
					pstmt.setString	( 7, firstname ) ;
					pstmt.setString	( 8, secondname ) ;
					pstmt.setString	( 9, thirdname ) ;
					pstmt.setString	( 10, familyname ) ;
					pstmt.setString	( 11, namesuffix ) ;
					pstmt.setString	( 12, patientname ) ;
					pstmt.setString	( 13, gender ) ;
					pstmt.setString	( 14, dateofbirth) ;
					pstmt.setString	( 15, restelno ) ;
					pstmt.setString	( 16, othcontactno ) ;
					pstmt.setString	( 17, emailid ) ;
					pstmt.setString	( 18, nationalidno ) ;
					pstmt.setString	( 19, altid1no ) ;
					pstmt.setString	( 20, altid1expdate) ;
					pstmt.setString	( 21, altid1type ) ;
					pstmt.setString	( 22, altid2no ) ;
					pstmt.setString	( 23, altid2expdate) ;
					pstmt.setString	( 24, altid2type ) ;
					pstmt.setString	( 25, altid3no ) ;
					pstmt.setString	( 26, altid3expdate) ;
					pstmt.setString	( 27, altid3type ) ;
					pstmt.setString	( 28, altid4no ) ;
					pstmt.setString	( 29, altid4expdate) ;
					pstmt.setString	( 30, altid4type ) ;
					pstmt.setString	( 31, oth_alt_id_type) ;
					pstmt.setString	( 32, oth_alt_id_no) ;
					pstmt.setString	( 33, resaddrline1 ) ;
					pstmt.setString	( 34, resaddrline2 ) ;
					pstmt.setString	( 35, resaddrline3 ) ;
					pstmt.setString	( 36, resaddrline4 ) ;
					pstmt.setString	( 37, postalcode ) ;
					pstmt.setString	( 38, countrycode ) ;
					pstmt.setString	( 39, res_town_code ) ;
					pstmt.setString	( 40, res_area_code ) ;
					pstmt.setString	( 41, res_region_code ) ;
					pstmt.setString	( 42, mail_addr_line1 ) ;
					pstmt.setString	( 43, mail_addr_line2 ) ;
					pstmt.setString	( 44, mail_addr_line3 ) ;
					pstmt.setString	( 45, mail_addr_line4 ) ;
					pstmt.setString	( 46, mail_town_code ) ;
					pstmt.setString	( 47, mail_area_code ) ;
					pstmt.setString	( 48, mail_region_code ) ;
					pstmt.setString	( 49, mail_postal_code ) ;
					pstmt.setString	( 50, mail_country_code ) ;
					pstmt.setString	( 51, patienttypecode ) ;
					pstmt.setString	( 52, patientclasscode ) ;
					pstmt.setString	( 53, refsourcetype ) ;
					pstmt.setString	( 54, referralcode ) ;
					pstmt.setString	( 55, specilitycode ) ;
					pstmt.setString	( 56, practitionerid ) ;
					pstmt.setString	( 57, chiefcomplaint ) ;
					pstmt.setString	( 58, otdatetime ) ;
					pstmt.setString	( 59, overrideyn ) ;
					pstmt.setString	( 60, bedclasscode ) ;
					pstmt.setString	( 61, bedtypecode ) ;
					pstmt.setString	( 62, nursingunitcode ) ;
					pstmt.setString	( 63, nursingunittypecode ) ;
					pstmt.setString	( 64, roomno ) ;
					pstmt.setString	( 65, bedno ) ;
					pstmt.setString	( 66, addedById ) ;
					if(confirm_yn.equals("Y"))	
						pstmt.setString	( 67, "1" ) ;
					else
						pstmt.setString	( 67, "0" ) ;
					pstmt.setString	( 68, addedById);
					pstmt.setString	( 69, facilityId ) ;
					pstmt.setString	( 70, addedAtWorkstation ) ;
					pstmt.setString	( 71, addedById ) ;
					pstmt.setString	( 72, facilityId ) ;
					pstmt.setString	( 73, addedAtWorkstation ) ;
					pstmt.setString	( 74, priorityind ) ;
					pstmt.setString	( 75, ambreqddatetime ) ;
					pstmt.setString	( 76, ambreqdyn ) ;
					pstmt.setString	( 77, blooddonationyn ) ;
					pstmt.setString	( 78, nationality ) ;
					pstmt.setString	( 79, teamid ) ;
					pstmt.setString	( 80, referral_id ) ;
					pstmt.setString	( 81, exp_days_of_stay ) ;
					pstmt.setString	( 82, service_code ) ;
					pstmt.setString	( 83, eth_grp);
					pstmt.setString	( 84, eth_sub_grp ) ;
					pstmt.setString	( 85, birth_place ) ;
					pstmt.setString	( 86, citizen ) ;
					pstmt.setString	( 87, legal ) ;
					pstmt.setString ( 88, place_of_birth);
					pstmt.setString ( 89, name_prefix_oth_lang);
					pstmt.setString ( 90, first_name_oth_lang);
					pstmt.setString ( 91, second_name_oth_lang);
					pstmt.setString ( 92, third_name_oth_lang);
					pstmt.setString ( 93, family_name_oth_lang);
					pstmt.setString ( 94, name_suffix_oth_lang);
					pstmt.setString ( 95, patient_name_local_lang);
					pstmt.setString ( 96, expected_discharge_date);
					pstmt.setString ( 97, chief_complaint);
					pstmt.setString (98, booking_remarks);
					pstmt.setString (99, booking_Type);
					pstmt.setString (100, patient_name_long);
					pstmt.setString (101, patient_name_loc_lang_long);
					//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
					//Start
					pstmt.setString (102, surgery_order_id);
					pstmt.setString (103, surgery_order_line_no);
					pstmt.setString (104, surgery_order_code);
					pstmt.setString (105, surgery_order);
					pstmt.setString (106, surgery_order_date);
					//End
					/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
					pstmt.setString (107, altAddrLine1);
					pstmt.setString (108, altAddrLine2);
					pstmt.setString (109, altAddrLine3);
					pstmt.setString (110, altAddrLine4);
					pstmt.setString (111, altTownCode);
					pstmt.setString (112, altAreaCode);
					pstmt.setString (113, altRegionCode);
					pstmt.setString (114, altPostalCode);
					pstmt.setString (115, altCountryCode);
					/*End*/
					int r = pstmt.executeUpdate() ;

					if(pstmt!=null) pstmt.close();
					if(r > 0)
						cancommit = true;
					/*included for the CRF RUT-CRF-013 - 23396*/
					if (cancommit)
					{
						if (patInstructions!=null && !(patInstructions.isEmpty())){
							String patInsSql ="insert into ip_bkg_pat_instructions(facility_id, bkg_ref_no, instruction_id, instruction_desc, display_order, added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
							pstmt=con.prepareStatement(patInsSql);
							//int recCount=patInstructions.size();
							int executableCount=0;
							Iterator it=patInstructions.keySet().iterator();
							while(it.hasNext()){
								Integer key=(Integer)it.next();
								String instId="";
								String instDesc="";
								String checkYN="";
								String mapValue=(String)patInstructions.get(key);
								
								StringTokenizer token1=new StringTokenizer(mapValue, "||");
								
								while (token1.hasMoreTokens()){
									instId=token1.nextToken();
									instDesc=token1.nextToken();
									if(instDesc.equals("*!*")){
										instDesc="";
									}
									checkYN=token1.nextToken();
								}
								if(checkYN.equals("Y")){
									executableCount=executableCount+1;
									pstmt.setString	( 1, facilityId ) ;
									pstmt.setString	( 2, L_bkglstrefno ) ;
									pstmt.setString	( 3, instId ) ;
									pstmt.setString	( 4, instDesc ) ;
									pstmt.setInt	( 5, executableCount ) ;
									pstmt.setString ( 6, addedById );
									pstmt.setString	( 7, facilityId ) ;
									pstmt.setString	( 8, addedAtWorkstation  ) ;
									pstmt.setString	( 9, addedById  ) ;
									pstmt.setString	( 10, facilityId  ) ;
									pstmt.setString	( 11, addedAtWorkstation  ) ;
									pstmt.addBatch();
								}
								
							}
							
							if(executableCount >0){
								int resultArr[]=pstmt.executeBatch();
								r=resultArr.length;							
							}
						}

					}
					if (r != 0)
					{
						cancommit=true;
					}
					else
					{
						message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
						String msgVal = ((String) message.get("message"));
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_BOOKING_LIST");
						message.clear();
						cancommit = false;
					}
				}catch(Exception e)
				{
					cancommit = false;	
					result = false;
					message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
					String msgVal = ((String) message.get("message"));
					message.clear();
					msgVal = msgVal.substring(0,msgVal.length()-4);
					sb.append(msgVal+" IP_BOOKING_LIST .. Exception:"+e);
					e.printStackTrace();
				}

				//Added by kishore on 8/12/2004
				if(is_oa_yn.equals("Y"))
				{
					try
					{
						if(cancommit)
						{						
							sbSql.delete(0,sbSql.length());
							sbSql.append(" Update pr_wait_list set ");
							sbSql.append(" BOOKING_REF_NO = ? , WAIT_LIST_STATUS ='L', ");
							sbSql.append("  MODIFIED_BY_ID=? , MODIFIED_DATE=sysdate , MODIFIED_AT_WS_NO=? , MODIFIED_FACILITY_ID =?  where FACILITY_ID=? and wait_list_no= ? ");
							if(pstmt!=null) pstmt.close();
							pstmt = con.prepareStatement( sbSql.toString() );
							pstmt.setString	( 1, L_bkglstrefno ) ;
							pstmt.setString	( 2, addedById ) ;
							pstmt.setString	( 3, addedAtWorkstation ) ;
							pstmt.setString	( 4, facilityId ) ;
							pstmt.setString	( 5, facilityId ) ;
							pstmt.setString	( 6, wait_list_ref_no ) ;
							int r1 = pstmt.executeUpdate() ;

							if(pstmt!=null) pstmt.close();
							if(r1 > 0)
								cancommit = true;
							else
							{
								message = MessageManager.getMessage(locale,"ERROR_WHILE_Updating","IP");
								String msgVal = ((String) message.get("message"));
								message.clear();
								msgVal = msgVal.substring(0,msgVal.length()-4);
								sb.append(msgVal+" pr_wait_list");
								cancommit = false;
							}
						}
					}catch(SQLException ex)					
					{
			
						cancommit=false;	
						result=false;
						message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
						String msgVal = ((String) message.get("message"));
						message.clear();
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" pr_wait_list .. Exception:"+ex);
						ex.printStackTrace();
					}
				}
			}
			// inserting record into ip_bed_booking if bedno is not null

			if(!bedno.equals("") && cancommit)
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append( " Insert into IP_BED_BOOKING (  ");
				sbSql.append(" facility_id, ");
				sbSql.append(" booking_type,");
				sbSql.append(" bed_booking_ref_no,  ");
				sbSql.append(" patient_id ,");
				sbSql.append(" booked_by_id    ,");
				sbSql.append(" req_nursing_unit_code ,");
				sbSql.append(" req_bed_no    ,");
				sbSql.append(" req_room_no   ,");
				sbSql.append(" req_bed_class_code     ,");
				sbSql.append(" req_bed_type_code      ,");
				sbSql.append(" daily_rate             ,");
				sbSql.append(" req_practitioner_id    ,");
				sbSql.append(" req_specialty_code     ,");
				sbSql.append(" override_yn         ,");
				sbSql.append(" booking_status      ,");
				sbSql.append(" added_by_id         ,");
				sbSql.append(" added_date          ,");
				sbSql.append(" added_at_ws_no      ,");
				sbSql.append(" added_facility_id   ,");
				sbSql.append(" modified_by_id      ,");
				sbSql.append(" modified_date       ,");
				sbSql.append(" modified_at_ws_no   ,");
				sbSql.append(" modified_facility_id, ");
				sbSql.append(" blocked_from_date_time,");
				sbSql.append(" booking_date_time  ,");
				sbSql.append(" blocked_until_date_time,  ");
				sbSql.append(" REQ_SERVICE_CODE, ");
				sbSql.append(" REQ_TEAM_ID ");
				sbSql.append(" ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,to_date(?,'dd/mm/rrrr hh24:mi'), to_date(?,'dd/mm/rrrr hh24:mi') , to_date(?,'dd/mm/rrrr hh24:mi'),?,? ) ");

				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sbSql.toString() );
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, "L" ) ;
				pstmt.setString	( 3,  L_bkglstrefno ) ;
				pstmt.setString	( 4,  patientid ) ;
				pstmt.setString	( 5,  addedById ) ;
				pstmt.setString	( 6,  nursingunitcode ) ;
				pstmt.setString	( 7,  bedno ) ;
				pstmt.setString	( 8,  roomno ) ;
				pstmt.setString	( 9,  bedclasscode ) ;
				pstmt.setString	( 10, bedtypecode ) ;
				pstmt.setString	( 11, dlycharge) ;
				pstmt.setString	( 12, practitionerid ) ;
				pstmt.setString	( 13, specilitycode ) ;
				pstmt.setString	( 14, overrideyn ) ;
				if(confirm_yn.equals("Y"))	
					pstmt.setString	( 15, "1" ) ;
				else
					pstmt.setString	( 15, "0" ) ;
				pstmt.setString	( 16, addedById);
				pstmt.setString	( 17, addedAtWorkstation ) ;
				pstmt.setString	( 18, facilityId ) ;
				pstmt.setString	( 19, addedById ) ;
				pstmt.setString	( 20, addedAtWorkstation ) ;
				pstmt.setString	( 21, facilityId ) ;
				pstmt.setString	( 22, preferreddate_from ) ;
				pstmt.setString	( 23, preferreddate ) ;
				pstmt.setString	( 24, preferreddate_to ) ;
				pstmt.setString	( 25, service_code ) ;
				pstmt.setString	( 26, teamid ) ;

				int res1 = pstmt.executeUpdate() ;
				if(pstmt!=null) pstmt.close();

				if(res1>0)
				cancommit = true;
				else
				{
					MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
					String msgVal = ((String) message.get("message"));
					message.clear();
					msgVal = msgVal.substring(0,msgVal.length()-4);
					sb.append(msgVal+" IP_BED_BOOKING");
					cancommit = false;
				}
			}

			if(pstmt!=null) pstmt.close();
			//3.insert/update into ip_dly_med_ser_grp_bkg_stat
			/*
			if(confirm_yn.equals("Y"))
			{
				l_male_bkngs   =0 ;
				l_female_bkngs =0 ;
				l_unknown_bkngs =0 ;
				
				if(gender.equals("M"))
					l_male_bkngs  = 1;
				else if (gender.equals("F"))
					l_female_bkngs =1;
				else 
					l_unknown_bkngs =1 ;
			
				StringBuffer dlyBksql = new StringBuffer();
				dlyBksql.append(" Select '1' from ip_dly_med_ser_grp_bkg_stat where ");
				dlyBksql.append(" facility_id='"+facilityId+"' and med_ser_grp_code='"+medsergrpcode+"' ");
				dlyBksql.append(" and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) " );
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( dlyBksql.toString());
				rset=pstmt.executeQuery();
				
				if(!rset.next() && cancommit)
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Insert into ip_dly_med_ser_grp_bkg_stat ( " );
					sbSql.append(" Facility_ID,");
					sbSql.append(" Med_ser_grp_code,");
					sbSql.append(" Preferred_Date, ");
					sbSql.append(" Male_Bkngs_Confirmed, ");
					sbSql.append(" Female_Bkngs_Confirmed ,");
					sbSql.append(" unknown_bkngs_confirmed,");
					sbSql.append(" Tot_Bkngs_Confirmed , ");
					sbSql.append(" added_by_id,");
					sbSql.append(" added_date,");
					sbSql.append(" added_facility_id,");
					sbSql.append(" added_at_ws_no,");
					sbSql.append(" modified_by_id,	");
					sbSql.append(" modified_date,");
					sbSql.append(" modified_facility_id,");
					sbSql.append("	modified_at_ws_no) " );
					sbSql.append(" values ( ?, ?,to_date(?,'dd/mm/rrrr hh24:mi') , ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?) ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString());
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					pstmt.setString	( 3, preferreddate ) ;
					pstmt.setInt    ( 4, l_male_bkngs ) ;
					pstmt.setInt 	( 5, l_female_bkngs ) ;
					pstmt.setInt	( 6, l_unknown_bkngs ) ;
					pstmt.setString	( 7, "1" ) ;
					pstmt.setString	( 8, addedById);
					pstmt.setString	( 9,facilityId ) ;
					pstmt.setString	( 10,addedAtWorkstation ) ;
					pstmt.setString	( 11,addedById ) ;
					pstmt.setString	( 12,facilityId ) ;
					pstmt.setString	( 13,addedAtWorkstation ) ;
					int r10 = pstmt.executeUpdate();
					if(rset!=null)  rset.close();
					if(pstmt!=null) pstmt.close();

					if(r10>0)
						cancommit = true;
					else
					{
						message = MessageManager.getMessage(con,"ERROR_WHILE_INSERTING");
						String msgVal = ((String) message.get("message"));
						message.clear();
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_DLY_MED_SER_GRP_BKG_STAT");
						cancommit = false;
					}
				}
				else if(cancommit)
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Update ip_dly_med_ser_grp_bkg_stat set ");
					sbSql.append(" Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + "+l_male_bkngs+",");
					sbSql.append(" Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+"+l_female_bkngs+", ");
					sbSql.append(" unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+ "+ l_unknown_bkngs +", ");
					sbSql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 where facility_id= ? ");
					sbSql.append(" and med_ser_grp_code= ? and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString());
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					int res2 = pstmt.executeUpdate();
					if (pstmt!=null)	
						pstmt.close();
					if(res2>0)
					cancommit = true;
					else
					{
						cancommit = false;
						message = MessageManager.getMessage(con,"ERROR_WHILE_UPDATING");
						String msgVal = ((String) message.get("message"));
						message.clear();
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_DLY_MED_SER_GRP_BKG_STAT");
					}
				}


				//4.insert/update into ip_mly_med_ser_grp_bkg_stat_table
			
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			sbSql.append(" Select '1' from IP_MLY_MED_SER_GRP_BKG_STAT where facility_id='"+facilityId+"' ");
				sbSql.append(" and med_ser_grp_code='"+medsergrpcode+"' and trunc(preferred_month,'mm')=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'mm') ");
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sbSql.toString() );
				rset=pstmt.executeQuery();
				
//				StringBuffer dlyInssql = new StringBuffer();
				if(!rset.next() && cancommit)
				{
					dlyInssql.append(" Insert into ip_mly_med_ser_grp_bkg_stat ( Facility_ID, Med_ser_grp_code, Preferred_month,  ");
					dlyInssql.append(" Male_Bkngs_Confirmed,Female_Bkngs_Confirmed,unknown_bkngs_confirmed,Tot_Bkngs_Confirmed,    ");
					dlyInssql.append(" added_by_id,added_date,added_facility_id, added_at_ws_no,modified_by_id,	" );
					dlyInssql.append(" modified_date, modified_facility_id,modified_at_ws_no) ");
					dlyInssql.append(" values( ?, ?,trunc(to_date(?,'dd/mm/rrrr hh24:mi'),'mm'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( dlyInssql.toString() );
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					pstmt.setString	( 3, preferreddate ) ;
					pstmt.setInt	( 4, l_male_bkngs ) ;
					pstmt.setInt	( 5, l_female_bkngs ) ;
					pstmt.setInt	( 6, l_unknown_bkngs ) ;
					pstmt.setString	( 7, "1" ) ;
					pstmt.setString	( 8, addedById);
					pstmt.setDate	( 9, added_date ) ;
					pstmt.setString	( 10,facilityId ) ;
					pstmt.setString	( 11,addedAtWorkstation ) ;
					pstmt.setString	( 12,addedById ) ;
					pstmt.setDate	( 13,added_date ) ;
					pstmt.setString	( 14,facilityId ) ;
					pstmt.setString	( 15,addedAtWorkstation ) ;

					int P = pstmt.executeUpdate();
					if(P>0)
						cancommit = true;
					else
					{
						cancommit = false;
						message = MessageManager.getMessage(con,"ERROR_WHILE_INSERTING");
						String msgVal = ((String) message.get("message"));
						message.clear();
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_MLY_MED_SER_GRP_BKG_STAT");
					}
					if (pstmt!=null) pstmt.close();
				}
				else if(cancommit)
				{
					dlyInssql.append( " Update ip_mly_med_ser_grp_bkg_stat set ");
					dlyInssql.append( " Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + "+l_male_bkngs+",");
					dlyInssql.append(" Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+"+l_female_bkngs+", ");
					dlyInssql.append(" unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+ "+ l_unknown_bkngs +", ");
					dlyInssql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 where facility_id= ? ");
					dlyInssql.append( " and med_ser_grp_code= ?  and trunc(preferred_month,'mm') = trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'mm') ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( dlyInssql.toString());
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					int res3= pstmt.executeUpdate();
					if(res3>0)
						cancommit = true;
					else
					{
						cancommit = false;
						message = MessageManager.getMessage(con,"ERROR_WHILE_UPDATING");
						String msgVal = ((String) message.get("message"));
						message.clear();
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_MLY_MED_SER_GRP_BKG_STAT");
					}
					if (pstmt!=null) pstmt.close();
				//}
				//5.insert/update into ip_dly_nurs_ut_bkg_stat
				if ((!nursingunitcode.equals("")) && (!bedclasscode.equals("")))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select '1' from ip_dly_nurs_ut_bkg_stat where facility_id='"+ facilityId +"' and "); 
					sbSql.append(" nursing_unit_code='"+nursingunitcode+"' and bed_class_code='"+bedclasscode+"' and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					rset=pstmt.executeQuery();
					StringBuffer	dlyNurs1sql = new StringBuffer();
					if(!rset.next() && cancommit)
					{
						dlyNurs1sql.append(" Insert into ip_dly_nurs_ut_bkg_stat ( ");
						dlyNurs1sql.append(" Facility_ID,");
						dlyNurs1sql.append(" nursing_unit_code,");
						dlyNurs1sql.append(" bed_class_code ,");
						dlyNurs1sql.append(" Preferred_date,");
						dlyNurs1sql.append(" Male_Bkngs_Confirmed,");
						dlyNurs1sql.append(" Female_Bkngs_Confirmed,");
						dlyNurs1sql.append(" unknown_bkngs_confirmed,");
						dlyNurs1sql.append(" Tot_Bkngs_Confirmed , " );
						dlyNurs1sql.append(" added_by_id,");
						dlyNurs1sql.append(" added_date,");
						dlyNurs1sql.append(" added_facility_id,");
						dlyNurs1sql.append(" added_at_ws_no,");
						dlyNurs1sql.append(" modified_by_id,	");
						dlyNurs1sql.append(" modified_date,");
						dlyNurs1sql.append( " modified_facility_id,");
						dlyNurs1sql.append( " modified_at_ws_no) " );
						dlyNurs1sql.append(" values( ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( dlyNurs1sql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, nursingunitcode ) ;
						pstmt.setString	( 3, bedclasscode ) ;
						pstmt.setString	( 4, preferreddate ) ;
						pstmt.setInt	( 5, l_male_bkngs ) ;
						pstmt.setInt	( 6, l_female_bkngs ) ;
						pstmt.setInt	( 7, l_unknown_bkngs ) ;
						pstmt.setString	( 8, "1" ) ;
						pstmt.setString	( 9, addedById);
						pstmt.setDate	( 10,added_date ) ;
						pstmt.setString	( 11,facilityId ) ;
						pstmt.setString	( 12,addedAtWorkstation ) ;
						pstmt.setString	( 13,addedById ) ;
						pstmt.setDate	( 14,added_date ) ;
						pstmt.setString	( 15,facilityId ) ;
						pstmt.setString	( 16,addedAtWorkstation ) ;

						int P1 = pstmt.executeUpdate();
						if(P1 > 0)
							cancommit = true;
						else
						{
							cancommit = false;
							message = MessageManager.getMessage(con,"ERROR_WHILE_INSERTING");
							String msgVal = ((String) message.get("message"));
							message.clear();
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_NURS_UT_BKG_STAT");
						}
					}
					else if(cancommit)
					{
						dlyNurs1sql.append( " Update ip_dly_nurs_ut_bkg_stat set " );
						dlyNurs1sql.append(" Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + "+l_male_bkngs+"," );
						dlyNurs1sql.append( " Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+ "+l_female_bkngs+", ");
						dlyNurs1sql.append( " unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+"+ l_unknown_bkngs+", ");
						dlyNurs1sql.append( " Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 ");
						dlyNurs1sql.append( " where facility_id= ? and nursing_unit_code= ? ");
						dlyNurs1sql.append( " and bed_class_code= ? and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( dlyNurs1sql.toString());
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, nursingunitcode ) ;
						pstmt.setString	( 3, bedclasscode ) ;
						int res4 = pstmt.executeUpdate();

						if(res4 > 0)
							cancommit = true;
						else
						{
							cancommit = false;
							message = MessageManager.getMessage(con,"ERROR_WHILE_UPDATING");
							String msgVal = ((String) message.get("message"));
							message.clear();								
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_NURS_UT_BKG_STAT");
						}
					}
					
				}

				if (rset!=null)  rset.close();
				if (pstmt!=null) pstmt.close();
				//age group variable changed from "agegroupcode" to "ageGrpcode"
				if (!bedclasscode.equals("") && checkbookinglimitby.equals("2") && (!(ageGrpcode.equals("") || ageGrpcode == null)))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select '1' from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' ");
					sbSql.append( " and age_group_code='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
					sbSql.append( " and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'))");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					rset=pstmt.executeQuery();
//					StringBuffer	dlyNurUt1sql = new StringBuffer();
					if(!rset.next() && cancommit)
					{
						/*dlyNurUt1sql.append( " Insert into ip_dly_age_grp_bkg_stat ( Facility_ID, age_group_code,bed_class_code ,Preferred_date, ");
						dlyNurUt1sql.append(" Male_Bkngs_Confirmed,   Female_Bkngs_Confirmed ,unknown_bkngs_confirmed, Tot_Bkngs_Confirmed , ");
						dlyNurUt1sql.append(" added_by_id,added_date,added_facility_id, added_at_ws_no,modified_by_id,	" );
						dlyNurUt1sql.append(" modified_date, modified_facility_id,	modified_at_ws_no) ");
						dlyNurUt1sql.append(" values( ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( dlyNurUt1sql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, ageGrpcode ) ;
						pstmt.setString	( 3, bedclasscode ) ;
						pstmt.setString	( 4, preferreddate ) ;
						pstmt.setInt	( 5, l_male_bkngs ) ;
						pstmt.setInt	( 6, l_female_bkngs ) ;
						pstmt.setInt	( 7, l_unknown_bkngs ) ;
						pstmt.setString	( 8, "1" ) ;
						pstmt.setString	( 9, addedById);
						pstmt.setDate	( 10, added_date ) ;
						pstmt.setString	( 11,facilityId ) ;
						pstmt.setString	( 12,addedAtWorkstation ) ;
						pstmt.setString	( 13,addedById ) ;
						pstmt.setDate	( 14,added_date ) ;
						pstmt.setString	( 15,facilityId ) ;
						pstmt.setString	( 16,addedAtWorkstation ) ;
						int v1 = pstmt.executeUpdate();
						if(v1 > 0)
							cancommit = true;
						else
						{
							cancommit = false;
							message = MessageManager.getMessage(con,"ERROR_WHILE_INSERTING");
							String msgVal = ((String) message.get("message"));
							message.clear();
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_AGE_GRP_BKG_STAT");
						}
					}
					else if(cancommit)
					{
						dlyNurUt1sql.append( " Update ip_dly_age_grp_bkg_stat set ");
						dlyNurUt1sql.append( " Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + '"+l_male_bkngs+"',");
						dlyNurUt1sql.append( " Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+ '"+l_female_bkngs+"', ");
						dlyNurUt1sql.append( " unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+ '"+l_unknown_bkngs+"', ");
						dlyNurUt1sql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 where facility_id= ? ");
						dlyNurUt1sql.append(" and age_group_code= ? and bed_class_code= ? and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
						if(pstmt2!=null) pstmt2.close();
						pstmt2 = con.prepareStatement(dlyNurUt1sql.toString());
						pstmt2.setString	( 1, facilityId ) ;
						pstmt2.setString	( 2, ageGrpcode ) ;
						pstmt2.setString	( 3, bedclasscode ) ;
						int res5 = pstmt2.executeUpdate();
						if(res5>0)
							cancommit = true;
						else 
						{
							cancommit = false;
							result = false;
							message = MessageManager.getMessage(con,"ERROR_WHILE_UPDATING");
							String msgVal = ((String) message.get("message"));
							message.clear();
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_AGE_GRP_BKG_STAT");
						}
					}
				}//E.O.IF for cond. 6
			}
			if (rset!=null)  rset.close();  
			if (pstmt!=null) pstmt.close();
			*/
			if(cancommit)
			{
				if(!(referral_id.equals("")))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Update pr_referral_register set ");
					sbSql.append(" STATUS = 'C' , referred_in_func = 4,");
					sbSql.append(" MODIFIED_BY_ID=? , MODIFIED_DATE=sysdate , MODIFIED_AT_WS_NO=? , MODIFIED_FACILITY_ID =?"); //Added Audit column
					sbSql.append("  where REFERRAL_ID= ? ");
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					
					pstmt.setString	( 1, addedById ) ;
					pstmt.setString	( 2, addedAtWorkstation ) ;
					pstmt.setString	( 3, facilityId ) ;					
					pstmt.setString	( 4, referral_id ) ;
					int res33= pstmt.executeUpdate();
					if(res33!=0) 
						cancommit=true;
					else
					{
						cancommit=false;
						message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
						String msgVal = ((String) message.get("message"));
						message.clear();
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" PR_REFERRAL_REGISTER");
					}
				}
			}

			// MOD#04 The new hashtable is introduced to pass the variable to the billing bean

		 
				//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
				//Starts
				try 
					{
					if(cancommit && smartCardFunc.equals("01") && !biometric_reason.equals(""))
						{
						String status=CommonBean.insertReasonforBiometric(con,facilityId,"IP_CREATE_BOOKING",patientid,L_bkglstrefno,nursingunitcode,biometric_reason,addedAtWorkstation,addedById);
						if(status.equals("S"))
							{
							cancommit	= true;	
							}
						else {
							cancommit	= false;
							}	
						} 
					}
				catch(Exception e)
					{
					cancommit	= false;
					e.printStackTrace();
					}
				//Ends	

			//if(isBlInstalled.equals("Y") && cancommit && iscapture_fin_dtls_yn.equals("Y"))
			if(isBlInstalled.equals("Y") && cancommit &&  !(p_blng_grp_id == null || p_blng_grp_id.equals("")))
			{
				try
				{
					
							Hashtable hashtableBill = new Hashtable();

							hashtableBill.put("facilityId",facilityId+"");
							hashtableBill.put("bookingrefno",L_bkglstrefno+"");
							//hashtableBill.put("patientid",patientid+"");
							/*hashtableBill.put("encounterid",""); 
							hashtableBill.put("sourcetype","");
							hashtableBill.put("source","");
							hashtableBill.put("refpractitioner","");*/
							hashtableBill.put("admissiondate",preferreddate+"");
							//hashtableBill.put("admissiontype","");
							//hashtableBill.put("circumstanceofinjury","");
							//hashtableBill.put("chiefcomplaint",chiefcomplaint+"");
							//hashtableBill.put("otdatetime",otdatetime+"");
							//hashtableBill.put("practitioner",practitionerid+"");
							//hashtableBill.put("speciality",specilitycode+"");
							//hashtableBill.put("medicalteam",teamid+"");
							//hashtableBill.put("patienttype",patienttypecode+"");
							//hashtableBill.put("bedclass",bedclasscode+"");
							//hashtableBill.put("nursingunit",nursingunitcode+"");
							//hashtableBill.put("service",service_code+"");
							//hashtableBill.put("subservice","");
							//hashtableBill.put("bedno",bedno+"");
							//hashtableBill.put("roomno",roomno+"");
							//hashtableBill.put("dailycharge",dailycharge+"");        
							//hashtableBill.put("ambulatorystatus","");
							//hashtableBill.put("modeofarrival","");
							//hashtableBill.put("name","");
							//hashtableBill.put("address1","");
							//hashtableBill.put("address2","");
							//hashtableBill.put("address3","");
							//hashtableBill.put("address4","");
							//hashtableBill.put("postalcode","");
							//hashtableBill.put("telno","");
							//hashtableBill.put("mvregnno","");
							//hashtableBill.put("emergencydetail","");
							//hashtableBill.put("admtypeind","");
							//hashtableBill.put("ancillaryyn","");
							hashtableBill.put("patientclass","IP");
							//hashtableBill.put("refpractitionername","");
							hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
							hashtableBill.put("billing_interfaced",billing_interfaced+"");
							hashtableBill.put("isBlInstalled",isBlInstalled+"");
							hashtableBill.put("P_MODE","I");
							hashtableBill.put("P_PATIENT_ID",patientid+"");
							hashtableBill.put("P_BLNG_GRP_ID",p_blng_grp_id+"");
							hashtableBill.put("fin_dtls",(HashMap)hashData.get("fin_dtls"));
							hashtableBill.put("P_EPISODE_TYPE","I");
							//hashtableBill.put("P_PACKAGE_BILL_DOC_TYPE",p_package_bill_doc_type+"");
							//hashtableBill.put("P_PACKAGE_BILL_DOC_NUM",p_package_bill_doc_num+"" ); 
							hashtableBill.put("P_EPISODE_STATUS",p_episode_status+"");
							//hashtableBill.put("P_VISIT_ID",p_visit_id+""); //int
							//hashtableBill.put("P_ADM_DOCTOR",practitionerid+"");
							//hashtableBill.put("insTrackDtlsExists",insTrackDtlsExists);
							//hashtableBill.put("expecteddischargedate",expected_discharge_date);
							//hashtableBill.put("referralid",referral_id+"");
							//hashtableBill.put("contact_details","");
							//hashtableBill.put("res_tel_no",restelno+"");
							//hashtableBill.put("oth_contact_no",othcontactno+"");
							//hashtableBill.put("email_id",emailid+"");
							//hashtableBill.put("postal_code",postalcode+"");
							//hashtableBill.put("country_code",countrycode+"");
							//hashtableBill.put("res_addr_line1",resaddrline1+"");
							//hashtableBill.put("res_addr_line2",resaddrline2+"");
							//hashtableBill.put("res_addr_line3",resaddrline3+"");
							//hashtableBill.put("res_addr_line4",resaddrline4+"");
							hashtableBill.put("addedById",addedById+"");
							hashtableBill.put("modifiedAtWorkstation",addedAtWorkstation+"");
							hashtableBill.put("added_date",added_date);     
							hashtableBill.put("function_id",strFunctionId+"");
							//hashtableBill.put("nursingunittype",nursingunittypecode+"");
							//hashtableBill.put("bedtype",bedtypecode+"");
							//hashtableBill.put("srlno",srlno+"");
							hashtableBill.put("module_id","IP");
							hashtableBill.put("locale",locale);
							/*if(expected_discharge_date != null && !(expected_discharge_date.equals("")))
							{
								hashtableBill.put("exp_no_of_day_stay",exp_days_of_stay+"");
							}*/

							//BLIPAdmitPat blipAdmitPat = new BLIPAdmitPat();
							//Hashtable resultsBL = blipAdmitPat.billPatientService(p, con,hashtableBill);
							
							BLBooking blbkBookPat = new BLBooking();
							Hashtable resultsBL = blbkBookPat.billPatientService(p, con,hashtableBill);
							boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();


							result = boolRes;
							strBLMessage = "";
							if (boolRes == false)
							{
								result  = false;
								cancommit = false;

								strBLMessage = (String) resultsBL.get("error");
								if (strBLMessage != null )
								{
									if (!strBLMessage.equalsIgnoreCase("null"))
									{
										if(strBLMessage.indexOf("<br>")!=-1)
										{
											strBLMessage = strBLMessage.substring(strBLMessage.indexOf("<br>")+4);
											sb.append(strBLMessage);
										}
										else
											sb.append("<u>"+strBLMessage+"</u><br>");
									}
								}								
							}

							resultsBL.clear();
							hashtableBill.clear();

							if (boolRes == true)
							{
								/*strBLMessage = (String) resultsBL.get("message");
								if (strBLMessage != null )
								{
									if (!strBLMessage.equalsIgnoreCase("null"))
									{
										sb.append("<u>"+strBLMessage+"</u><br>");
									}
								}*/
							}

			}
				catch (Exception exceptionBL)
				{
					cancommit = false;	
					result	  = false;
					sb.append("BILLING UPDATION :"+exceptionBL.toString());
					exceptionBL.printStackTrace();
				}
			}// End of Billing Interface

			if(cancommit)
			{

				message = MessageManager.getMessage( locale, "IP_BOOKING_SUCCESS","IP" ) ;
				String msgVal = ((String) message.get("message"));
				message.clear();

				msgVal = msgVal.substring(0,msgVal.length()-4);

				//if(call_function.equals("CA_Task_IP_Booking") ||call_function.equals("OA_IP_Booking")||call_function.equals("CA_Clinician_IP_Booking"))
				
				if(call_function.equals("CA_Task_IP_Booking") ||call_function.equals("OA_IP_Booking")||call_function.equals("CA_Clinician_IP_Booking") || call_function.equals("OT"))
				{
					sb.append(msgVal);
					sb.append(" ");
					sb.append(L_bkglstrefno);
						
				}
				else
				{
					// code modified for this incident :18284

					sb.append(msgVal+"<B><FONT SIZE=4>"+" "+L_bkglstrefno+"</B></FONT>");
				}
				con.commit();
			}
			else
			{
				con.rollback();
			}

		}catch(Exception insertIPBookingExp)
		{
			insertIPBookingExp.printStackTrace(System.out);
			result=false;
			sb.append("Exception in insertIPBooking Method "+insertIPBookingExp);
			try{
				con.rollback();
			}catch ( Exception e1 ){	}
		}
		finally
		{
			try
			{
				if(rset!=null)		rset.close();
				if(pstmt!=null)	    pstmt.close();
				if(pstmt2!=null)	pstmt2.close();
				if(Stmt!=null)		Stmt.close();
			}catch(Exception e) {}
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;				
		results.put( "error", sb.toString() ) ;
		results.put( "booking_reference_no", L_bkglstrefno ) ;
		results.put( "overrideMessage", overRideMessage ) ;
		hashData.clear();
		return results;
	}//e.o.insert ipbooking method

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}// E.O.Session Bean
