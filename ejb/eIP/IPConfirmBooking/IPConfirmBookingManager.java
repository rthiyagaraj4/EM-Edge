/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to confirm the booking.
@version - V3
*/

package eIP.IPConfirmBooking;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
import blbkin.*;
/**
*
* @ejb.bean
*	name="IPConfirmBooking"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPConfirmBooking"
*	local-jndi-name="IPConfirmBooking"
*	impl-class-name="eIP.IPConfirmBooking.IPConfirmBookingManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eIP.IPConfirmBooking.IPConfirmBookingLocal"
*	remote-class="eIP.IPConfirmBooking.IPConfirmBookingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPConfirmBooking.IPConfirmBookingLocalHome"
*	remote-class="eIP.IPConfirmBooking.IPConfirmBookingHome"
*	generate= "local,remote"
*
*
*/
public class IPConfirmBookingManager implements SessionBean
{
	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove(){}
	public void ejbActivate(){}
	public void ejbPassivate(){}

	public void setSessionContext(SessionContext context){this.ctx=context;}

	/*
	This method is used to confirm the booking.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertIPConfirmBooking(java.util.Properties p,java.util.HashMap hashData){
		StringBuffer sb			= new StringBuffer("");
		Connection con			= null;
		PreparedStatement pstmt = null ;
		Statement Stmt 			= null;
		ResultSet rset 			= null;
		ResultSet rs20			= null;
		String checkbookinglimitby		= "";
		String dlycharge				= "";
		String ambreqddatetime			= "";
		String agegroupcode				= "";
		String ageGrpcode				= "";

		boolean cancommit	= true;
		boolean result		= true;

		int bkgGracePeriod	= 0;
		int maxdlyBk		= 0;
		int maxmtlyBk		= 0;
		int MdlyBkg			= 0;
		int FdlyBkg			= 0;
		int UdlyBkg			= 0;
		int DatVal			= 0;
		int DatVal2			= 0;
		int MaxtotBk		= 0;
		int totBk			= 0;
		int l_male_bkngs	= 0;
		int l_female_bkngs	= 0;
		int l_unknown_bkngs = 0;
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order_code="";
		String surgery_order="";
		String surgery_order_id="";
		String surgery_order_line_no="";
		String surgery_order_date="";
		//End
		java.util.HashMap results				= new java.util.HashMap() ;
		java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		String facilityId		= (String)hashData.get("facilityId");
		String generatenumyn	= (String)hashData.get("generatenumyn");
		String expdaysofstay	= (String)hashData.get("expdaysofstay");
		String priority			= (String)hashData.get("priority");
		String medical_team		= (String)hashData.get("medical_team");
		String bkglstrefno		= (String)hashData.get("bkglstrefno");
		String medsergrpcode	= (String)hashData.get("medsergrpcode");
		String preferreddate	= (String)hashData.get("preferreddate");
		String block_bed_based_on	= (String)hashData.get("block_bed_based_on");
		String expected_discharge_date = (String)hashData.get("expected_discharge_date");
		StringTokenizer sttoks  = new StringTokenizer(preferreddate," ");
		String preferreddate_from = sttoks.nextToken();
		String preferreddate_to = preferreddate_from;
		//preferreddate_from = preferreddate_from+" 00:01";
		//preferreddate_to   = preferreddate_to+" 23:59";
		if(block_bed_based_on.equals("P"))
		{
			preferreddate_from			= preferreddate_from+" 00:01";
			preferreddate_to			= preferreddate_to+" 23:59";
		}
		else if(block_bed_based_on.equals("E"))
		{
			preferreddate_from			= preferreddate;
			preferreddate_to			= expected_discharge_date;
		}

		String patientid		= (String)hashData.get("patientid");
		String multi_book_pat_yn= (String)hashData.get("multi_book_pat_yn");
		String gender			= (String)hashData.get("gender");
		String dateofbirth		= (String)hashData.get("dateofbirth");
		String restelno			= (String)hashData.get("restelno");
		String othcontactno		= (String)hashData.get("othcontactno");
		String emailid			= (String)hashData.get("emailid");
		String resaddrline1		= (String)hashData.get("resaddrline1");
		String resaddrline2		= (String)hashData.get("resaddrline2");
		String resaddrline3		= (String)hashData.get("resaddrline3");
		String resaddrline4		= (String)hashData.get("resaddrline4");
		String postalcode		= (String)hashData.get("postalcode");
		String countrycode		= (String)hashData.get("countrycode");
		String res_town_code	= (String)hashData.get("res_town_code");
		String res_area_code	= (String)hashData.get("res_area_code");
		String res_region_code	= (String)hashData.get("res_region_code");
		String mail_addr_line1	= (String)hashData.get("mail_addr_line1");
		String mail_addr_line2	= (String)hashData.get("mail_addr_line2");
		String mail_addr_line3	= (String)hashData.get("mail_addr_line3");
		String mail_addr_line4	= (String)hashData.get("mail_addr_line4");
		String mail_town_code	= (String)hashData.get("mail_town_code");
		String mail_area_code	= (String)hashData.get("mail_area_code");
		String mail_region_code	= (String)hashData.get("mail_region_code");
		String mail_postal_code	= (String)hashData.get("mail_postal_code");
		String mail_country_code= (String)hashData.get("mail_country_code");
		String specilitycode	= (String)hashData.get("specilitycode");
		String practitionerid	= (String)hashData.get("practitionerid");
		String otdatetime		= (String)hashData.get("otdatetime");
		String overrideyn		= (String)hashData.get("overrideyn");
		String bedclasscode		= (String)hashData.get("bedclasscode");
		String bedtypecode		= (String)hashData.get("bedtypecode");
		String nursingunitcode	= (String)hashData.get("nursingunitcode");
		String nursingunittypecode= (String)hashData.get("nursingunittypecode");
		String roomno			= (String)hashData.get("roomno");
		String bedno			= (String)hashData.get("bedno");
		String addedAtWorkstation= (String)hashData.get("client_ip_address");
		String service_code		= (String)hashData.get("service_code");
		String reason_for_revision_code= (String)hashData.get("reason_for_revision_code");
		String booking_remarks  = (String)hashData.get("booking_remarks");
		String booking_Type_Code= (String)hashData.get("booking_Type_Code");
		checkbookinglimitby		= (String)hashData.get("chk_booking_limit_by");
		
		String patientclasscode	 = "";

		//Billing interface parameter
		String isBlInstalled			= (String)hashData.get("isBlInstalled");
		//String iscapture_fin_dtls_yn	= (String)hashData.get("iscapture_fin_dtls_yn");
		//String str_dailycharge			= (String)hashData.get("dailycharge");
		String billing_interfaced		= (String)hashData.get("billing_interfaced");
		String p_blng_grp_id			= (String)hashData.get("billing_group");
		//String p_package_bill_doc_type	= (String)hashData.get("pkg_bill_type");
		//String str_P_PACKAGE_BILL_DOC_NUM= (String)hashData.get("pkg_bill_no");
		String p_episode_status			= (String)hashData.get("episodestatus");

		HashMap	fin_dtls                = (HashMap)hashData.get("fin_dtls");

		//String str_P_VISIT_ID			= (String)hashData.get("visitid");
		//String insTrackDtlsExists		= (String)hashData.get("insTrackDtlsExists");
		String strFunctionId		= "CONFIRMBOOKING";
		TreeMap patInstructions=(java.util.TreeMap)hashData.get("patInstructions");//included for the CRF - RUT-CRF-013 23396
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		surgery_order_code=(String)hashData.get("surgery_order_code");
		surgery_order=(String)hashData.get("surgery_order");
		surgery_order_id=(String)hashData.get("surgery_order_id");
		surgery_order_line_no=(String)hashData.get("surgery_order_line_no");
		surgery_order_date=(String)hashData.get("surgery_order_date");
		//End
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";//(String)hashData.get("smartCardFunc");
		String biometric_reason=(String)hashData.get("biometric_reason");
	
		//Ends
		try
		{

			StringBuffer sbSql = new StringBuffer();
			result			   = true;
			con 	= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			smartCardFunc	= eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 

			String addedById 		 = p.getProperty( "login_user" ) ;
			String locale = p.getProperty("LOCALE");

			String addedDate 			= dateFormat.format( new java.util.Date() ) ;
			java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;


			//int diff  = 0;
			sb		  = new StringBuffer("");
			cancommit = true;
			result		= true;

			/** Check for duplicate booking ref no **/
			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			sbSql.append(" SELECT booking_status from ip_booking_list where ");
			sbSql.append(" facility_id = '"+facilityId+"' and ");
			sbSql.append(" BKG_LST_REF_NO='"+bkglstrefno+"' ");
			Stmt = con.createStatement();
			rset = Stmt.executeQuery(sbSql.toString());
			if (rset.next())
			{
				String bookingStatus	 = rset.getString("booking_status");
				if(bookingStatus.equals("9"))
				{
					cancommit	= false;
					result		= false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"BKNG_CANCELLED_CANT_CONF","IP");
					sb.append((String) message.get("message"));
					message.clear();
				}
				else if(cancommit && generatenumyn.equals("N"))
				{
					cancommit	= false;
					result		= false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"DUPLICATE_REF_NO","IP");
					sb.append((String) message.get("message"));
					message.clear();
				}
				rset.close();
				Stmt.close();
			}
		/**
			if(cancommit)
			{
				/** check whether the billing is installed or not   **/
		/**		Stmt = con.createStatement();
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select setup_bl_dtls_in_ip_yn, TO_CHAR(TO_DATE('"+preferreddate+"','dd/mm/rrrr hh24:mi')+((1/(24*60))*60*bed_block_period_normal),'dd/mm/rrrr hh24:mi') bed_block_period_normal , (TO_DATE('"+preferreddate+"','dd/mm/rrrr HH24:MI')-SYSDATE) diff, sign((sysdate+nvl(ADV_BED_BOOK_PERIOD_BKG,0)-(trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'))))) valid_flag, nvl(bkg_grace_period,0) bkg_grace_period, chk_booking_limit_by from ip_param where facility_id='"+facilityId+"' ");
				rs20 = Stmt.executeQuery(sbSql.toString());
				if(rs20!=null )
				{
					while(rs20.next())
					{
						setup_bl_dtls_in_ip_yn	 = rs20.getString("setup_bl_dtls_in_ip_yn");
						checkbookinglimitby	     = rs20.getString("chk_booking_limit_by");
							if(checkbookinglimitby == null ) checkbookinglimitby ="";
						diff						= rs20.getInt("diff");
						chkval						= rs20.getInt("valid_flag");
						bkgGracePeriod				= rs20.getInt("bkg_grace_period");
					}
					rs20.close();
					Stmt.close();
				}

				if(chkval < 0)
				{
					cancommit	= false;
					result		= false;
					java.util.Hashtable message = MessageManager.getMessage( locale, "PREFER_DATE_LT_EXCEEDED" ,"IP");
					sb.append( (String) message.get("message")) ;
					message.clear();
				}

				if(diff < 0)
				{
					cancommit	= false;
					result		= false;
					java.util.Hashtable message = MessageManager.getMessage( locale, "PREF_ADMDATE_NOT_LESS_SYSDATE","IP" );
					sb.append( (String) message.get("message")) ;
					message.clear();
				}
			}
*/

			if(cancommit)
			{
				if(!nursingunitcode.equals(""))
				{
					/** Check for the medical services nursing unit rights  **/

					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" SELECT med_ser_grp_code , appl_patient_class FROM ip_nursing_unit a, ip_med_ser_grp_nurs_ut_type b ");
					sbSql.append(" WHERE  b.facility_id = a.facility_id ");
					sbSql.append(" AND b.nursing_unit_type_Code = a.nursing_unit_type_code ");
					sbSql.append(" AND a.facility_id = '"+ facilityId +"'  ");
					sbSql.append(" AND nursing_unit_code = '"+nursingunitcode+"' ");
					sbSql.append(" AND b.med_ser_grp_code = '"+medsergrpcode+"' ");
				   	Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					if(rset!=null)
					{
						if(rset.next())
							patientclasscode	 = rset.getString("appl_patient_class");
						else
						{
							cancommit	= false;
							result		= false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_MSG_NUT_RIGHTS" ,"IP") ;
							sb.append( (String) message.get("message")) ;
							message.clear();
						}
						rset.close();
						Stmt.close();
					}
				}
			}

			if(multi_book_pat_yn.equals("N"))
			{
				/**Check for duplicate patient Booking**/
				if(cancommit)
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("Select '1' from ip_booking_list where patient_id ='"+patientid+"' and booking_status ='1' and facility_id = '"+facilityId+"'  and PATIENT_CLASS_CODE = 'IP' and (trunc(PREFERRED_DATE) >= trunc(sysdate -"+bkgGracePeriod+")) ");
					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					if(rset.next())
					{
						cancommit	= false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage( locale, "ONLY_ONE_OPEN_BKG" ,"IP") ;
						sb.append( (String) message.get("message")) ;
						rset.close();
						Stmt.close();
						message.clear();
					}
				}
			}

			if(cancommit && !otdatetime.equals(""))
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select sign(to_date('"+otdatetime+"','dd/mm/rrrr hh24:mi') - TO_DATE('"+preferreddate+"','DD/MM/rrrr hh24:mi')) L_SIGN,sign(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi') - TO_DATE('"+ambreqddatetime+"','DD/MM/rrrr hh24:mi')) L_SIGN2  FROM DUAL ");

				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());
				if (rset.next())
				{
					DatVal = rset.getInt(1);
					DatVal2 = rset.getInt(2);

					if (DatVal < 0)
					{
						cancommit	= false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_OT_DATE","IP");
						sb.append((String ) message.get("message"));
						message.clear();
					}
					/** check for the ambulance date time validation **/
					if (DatVal2 < 0)
					{
						cancommit	= false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"AMB_REQD_DATE_LT_PREF_DATE","IP");
						sb.append((String ) message.get("message"));
						message.clear();
					}
					 rset.close();
					 Stmt.close();
				}
			 }

		if(cancommit && !nursingunitcode.equals("") && !practitionerid.equals(""))
		{
		/***	Check for the valid Nursing Unit  ***/
				/** Check for the practitioner of the nursing unit **/
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select count(*) from   ip_nursing_unit_for_pract where ");
				sbSql.append(" facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
				sbSql.append(" and practitioner_id='"+practitionerid+"' ");

				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());

				int pract_count = 0;
				if(rset.next())
					pract_count = rset.getInt(1);

				if(pract_count == 0)
				{
					cancommit	= false;
					result		= false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP");
					sb.append((String) message.get("message"));
					message.clear();
				}
			 rset.close();
			 Stmt.close();
			if(cancommit)
			{
				/** Check for the specaility of the nursing unit **/
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select count(*) from ip_nurs_unit_for_specialty a, am_speciality b where ");
				sbSql.append(" a.facility_id='"+facilityId+"' and a.nursing_unit_code='"+nursingunitcode+"' ");
				sbSql.append(" and a.specialty_code = b.speciality_code and b.eff_status = 'E' and a.specialty_code='"+specilitycode+"' ");
				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());

				int spl_count = 0;
				if(rset.next())
					spl_count = rset.getInt(1);

				if(spl_count == 0)
				{
					cancommit	= false;
					result		= false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"SPLTY_ADMN_RIGHTS_DENIED","IP");
					sb.append((String) message.get("message"));
					message.clear();
				}
				 rset.close();
				 Stmt.close();
			}
			if(cancommit)
			{
				/** valid Age group and gender for the nursing unit **/
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" SELECT age_group_code FROM ip_nursing_unit ");
				sbSql.append(" WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");

				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());

				if (rset.next())
				{

					agegroupcode = rset.getString("age_group_code");
					if (agegroupcode != null)
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select '1' from am_age_group Where age_group_code='"+agegroupcode+"'  And NVL(GENDER,'"+gender+"')= '"+gender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
						rset.close();
						Stmt.close();
						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());
						if(!rset.next())
						{
							cancommit	= false;
							result		= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
							sb.append((String) message.get("message"));
							message.clear();
						}
					 rset.close();
					 Stmt.close();
					}
				}
					rset.close();
			}
		}

			if(cancommit)
			{
				/*** Check for valid Bed ***/
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select 1 from ip_bed_booking WHERE facility_id = '"+facilityId+"' AND   bed_booking_ref_no ='"+bkglstrefno+"' AND booking_type = 'L'");
				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());
				String strBedExist = "";
				if (rset.next())
				{
					strBedExist = "1";
					rset.close();
					Stmt.close();
				}
				if(!strBedExist.equals("1"))
				{
					if (!bedno.equals(""))
					{
						if (nursingunitcode.equals("") ||  bedclasscode.equals(""))
						{
							cancommit	= false;
							result		= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"NU_AND_BC_NOTNULL","IP");
							sb.append((String) message.get("message"));
							message.clear();
			  			}
						else
						{
							/** Check for valid Bed  **/
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select  Occupying_Patient_Id,bed_type_code,sex_spec_ind,bed_class_code, specialty_code from ip_nursing_unit_bed ");
							sbSql.append(" WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
							sbSql.append(" And bed_no='"+bedno+"' ");

							Stmt = con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());
							if(rset.next())
							{
								bedtypecode       = rset.getString(2);
								//String OPatId	  = rset.getString(1);
								String splty_code = rset.getString(5);

								if (splty_code==null) splty_code = "";

								/*if (OPatId != null)
								{
									cancommit	= false;
									result		= false;
									java.util.Hashtable message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP");
									sb.append((String) message.get("message"));
									message.clear();
								}*/

								if (!rset.getString("bed_class_code").equalsIgnoreCase(bedclasscode))
								{
									cancommit	= false;
									result		= false;
									java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_BED_CLASS","IP");
									sb.append((String) message.get("message"));
									message.clear();
								}

								if ((rset.getString("sex_spec_ind") != null) &&(!rset.getString("sex_spec_ind").equalsIgnoreCase(gender)))
								{
									cancommit	= false;
									result		= false;
									java.util.Hashtable message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
									sb.append((String) message.get("message"));
									message.clear();
								}

								if (result)
								{
									if (!splty_code.equals("") && !splty_code.equals(specilitycode))
									{
										cancommit	= false;
										result		= false;
										java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP" ) ;
										sb.append( (String) message.get("message") ) ;
										message.clear();
									}
							   }
							 rset.close();
							}
							else
							{
								cancommit	= false;
								result		= false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_BED","Common");
								sb.append((String) message.get("message"));
								message.clear();
							}

							/** Check for Blocked/Booked beds **/

							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							/*
							sbSql.append(" Select BOOKING_TYPE,override_yn from ip_bed_booking ");
							sbSql.append(" WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunitcode+"' ");
							sbSql.append(" and req_bed_no='"+bedno+"' and booking_status='0' and sysdate between blocked_from_date_time ");
							sbSql.append(" and blocked_until_date_time ");
							*/
							/*Wednesday, November 24, 2010 , SRR20056-SCF-6065-IN025197*/
							sbSql.append(" Select booking_type, override_yn from ip_bed_booking ");
							sbSql.append("WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunitcode+"' ");
							sbSql.append(" and req_bed_no='"+bedno+"' and booking_status='0' and ( to_date('"+preferreddate_from+"','dd/mm/rrrr hh24:mi') between blocked_from_date_time ");
							sbSql.append(" and blocked_until_date_time or to_date('"+preferreddate_to+"','dd/mm/rrrr hh24:mi') between blocked_from_date_time and blocked_until_date_time) ");
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
										cancommit	= false;
										result		= false;
										java.util.Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP");
										sb.append((String) message.get("message"));
										message.clear();
									}
									else
									{
										cancommit	= false;
										result		= false;
										java.util.Hashtable message = MessageManager.getMessage(locale,"BLOCKED_BED","IP");
										sb.append((String) message.get("message"));
										message.clear();
									}
								}
								else
								{
									if (bkType.equals("L"))
									{
										java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP");

										sb.append((String) message.get("message"));
										message.clear();
									}
									else
									{
										java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BLOCKING","IP");

										sb.append((String) message.get("message"));
										message.clear();
									}
								}
								 rset.close();
								 Stmt.close();
							}
						}
					}//E.O.IF for (!bed_no.equals(""))
				}
			}
			if(cancommit)
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				/** Check for daily booking limits **/
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select MAX_NO_OF_DLY_BOOKING,MAX_NO_OF_MTHLY_BOOKING from ip_medical_service_group ");
				sbSql.append(" where facility_id='"+facilityId+"' and	med_ser_grp_code='"+medsergrpcode+"' ");
				Stmt = con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());
				if(rset.next())
				{
					maxdlyBk  = rset.getInt(1);
					maxmtlyBk = rset.getInt(2);
					 rset.close();
					 Stmt.close();

					if (maxdlyBk != 0)
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select tot_bkngs_confirmed+tot_bkngs_pending  as tot_booked ");
						sbSql.append(" from ip_dly_med_ser_grp_bkg_stat where facility_id='"+facilityId+"' ");
						sbSql.append(" and  med_ser_grp_code='"+medsergrpcode+"' and  trunc(preferred_date) = trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());
						if(rset.next())
						{
					 		totBk = rset.getInt("tot_booked") ;
							if (maxdlyBk <= totBk)
							{
								 cancommit	= false;
								 result		= false;
								 java.util.Hashtable message = MessageManager.getMessage(locale,"MSG_DLY_LT_EXCEEDS","IP");
								 sb.append((String) message.get("message"));
								 message.clear();
							}
						}
					}
					if(rset!=null) rset.close();
					if(maxmtlyBk != 0)
					{
						/** Check for monthly booking limits **/
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select tot_bkngs_confirmed+tot_bkngs_pending  as tot_booked ");
						sbSql.append(" from ip_mly_med_ser_grp_bkg_stat where facility_id='"+facilityId+"' ");
						sbSql.append(" and  med_ser_grp_code='"+medsergrpcode+"' and  to_char(preferred_month,'mm/rrrr') = to_char(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'mm/rrrr') ");
						Stmt = con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());
						if(rset.next())
						{
							 totBk = rset.getInt("tot_booked") ;

							 if (maxmtlyBk <= totBk)
							 {
								cancommit	= false;
								result		= false;
							    java.util.Hashtable message = MessageManager.getMessage(locale,"MSG_MLY_LT_EXCEEDS","IP");
							    sb.append((String) message.get("message"));
								message.clear();
							 }
						}
						 rset.close();
						 Stmt.close();
					}
				}
				if (checkbookinglimitby.equals("1"))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking,max_total_dly_booking from ip_book_limit_by_nurs_ut ");
					sbSql.append(" where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
					sbSql.append(" and bed_class_code='"+bedclasscode+"'	");
					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					if(rset.next())
					{
						MdlyBkg  = rset.getInt(1);
						FdlyBkg  = rset.getInt(2);
						UdlyBkg  = rset.getInt(3);
						MaxtotBk = rset.getInt(4);
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						//sbSql.append(" Select  male_bkngs_confirmed+male_bkngs_pending male_booked, female_bkngs_confirmed+female_bkngs_pending female_booked ,unknown_bkngs_confirmed+unknown_bkngs_pending unknown_booked,tot_bkngs_confirmed+tot_bkngs_pending  tot_booked from ip_dly_nurs_ut_bkg_stat where facility_id='"+ facilityId+"' and nursing_unit_code='"+nursingunitcode+"' and bed_class_code='"+bedclasscode+"' and trunc(preferred_date) = trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
						sbSql.append(" Select  male_bkngs_confirmed male_booked, female_bkngs_confirmed female_booked ,unknown_bkngs_confirmed unknown_booked,tot_bkngs_confirmed  tot_booked from ip_dly_nurs_ut_bkg_stat where facility_id='"+ facilityId+"' and nursing_unit_code='"+nursingunitcode+"' and bed_class_code='"+bedclasscode+"' and trunc(preferred_date) = trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");

						rset.close();
						Stmt.close();

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
								cancommit	= false;
								result		= false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"NUR_UT_LT_EXCEEDS","IP");
						 		sb.append((String) message.get("message"));
								message.clear();
							}
						  rset.close();
						  Stmt.close();
						}
					}
				}
				else
				{
					if (checkbookinglimitby.equals("2"))
					{
						MdlyBkg  = 0;
						FdlyBkg  = 0;
						UdlyBkg  = 0;
						MaxtotBk = 0;
						/** check for the booking limits for the nursing unit by age group **/
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
							rset.close();
							Stmt.close();
							Stmt = con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());
							if(rset.next())
							{
								MdlyBkg  = rset.getInt(1);
								FdlyBkg  = rset.getInt(2);
								UdlyBkg  = rset.getInt(3);
								MaxtotBk = rset.getInt(4);
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								//sbSql.append("Select  (male_bkngs_confirmed+male_bkngs_pending) male_booked, (female_bkngs_confirmed+female_bkngs_pending) female_booked, (unknown_bkngs_confirmed+unknown_bkngs_pending) unknown_booked, ");
								//sbSql.append(" (tot_bkngs_confirmed+tot_bkngs_pending)  tot_booked from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' and age_group_code ='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
								//sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
								sbSql.append("Select  male_bkngs_confirmed male_booked, female_bkngs_confirmed female_booked,unknown_bkngs_confirmed unknown_booked, ");
								sbSql.append(" tot_bkngs_confirmed  tot_booked from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' and age_group_code ='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
								sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");

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
										cancommit	= false;
										result		= false;
										java.util.Hashtable message = 	MessageManager.getMessage(locale,"AGE_GRP_LT_EXCEEDS","IP");
										sb.append((String) message.get("message"));
										message.clear();
									}
								}
						rset.close();
						Stmt.close();
							}
						}
					}
				}
				//Updating the ip_booking_list table
				if(cancommit)
				{
					try
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" UPDATE ip_booking_list  SET  ");
						sbSql.append(" preferred_date =to_date(?,'dd/mm/rrrr hh24:mi'),");
						sbSql.append(" res_tel_no     = ? , ");
						sbSql.append(" oth_contact_no = ? ,");
						sbSql.append(" email_id = ? ,");
						sbSql.append(" res_addr_line1 = ?, ");
						sbSql.append(" res_addr_line2 = ? ,");
						sbSql.append(" res_addr_line3 = ?, ");
						sbSql.append(" res_addr_line4 = ?, ");
						sbSql.append(" postal_code    = ?,");
						sbSql.append(" country_code   = ?,");
						sbSql.append(" patient_class_code = ?,");
						sbSql.append(" ot_date_time    = to_date(?,'dd/mm/rrrr hh24:mi'),");
						sbSql.append(" override_yn     = ?, ");
						sbSql.append(" bed_class_code  = ?,");
						sbSql.append(" bed_type_code   = ?, ");
						sbSql.append(" nursing_unit_code = ?,");
						sbSql.append(" service_code = ?,");
						sbSql.append(" nursing_unit_type_code =?, ");
						sbSql.append(" room_no 	= ?,");
						sbSql.append(" bed_no 	= ?  ,");
						sbSql.append(" booking_date_time  =	sysdate,");
						sbSql.append(" booked_by_id   =?, ");
						sbSql.append(" booking_status ='1',  ");
						sbSql.append(" exp_days_of_stay= ?,");
						sbSql.append(" priority_ind	= ?,");
						sbSql.append(" team_id	=	?,");
						sbSql.append(" modified_by_id = ?,");
						sbSql.append(" modified_date  =sysdate,");
						sbSql.append(" modified_facility_id  = ?, ");
						sbSql.append(" modified_at_ws_no 	= ?, ");
						sbSql.append(" reason_for_revision_code = ? , ");
						sbSql.append(" RES_TOWN_CODE = ? ,");
						sbSql.append(" RES_AREA_CODE = ? ,");
						sbSql.append(" RES_REGION_CODE = ? ,");
						sbSql.append(" MAIL_ADDR_LINE1 = ? ,");
						sbSql.append(" MAIL_ADDR_LINE2 = ? ,");
						sbSql.append(" MAIL_ADDR_LINE3 = ? ,");
						sbSql.append(" MAIL_ADDR_LINE4 = ? ,");
						sbSql.append(" MAIL_TOWN_CODE = ? ,");
						sbSql.append(" MAIL_AREA_CODE = ? ,");
						sbSql.append(" MAIL_REGION_CODE = ? ,");
						sbSql.append(" MAIL_POSTAL_CODE = ? ,");
						sbSql.append(" MAIL_COUNTRY_CODE = ? ,");
						sbSql.append(" PRACTITIONER_ID = ? ,");
						sbSql.append(" EXPECTED_DISCHARGE_DATE    = to_date(?,'dd/mm/rrrr hh24:mi'),");
						sbSql.append(" DIAGNOSIS_REMARKS = ? ,");
						sbSql.append(" BOOKING_TYPE_CODE = ? ,");
						//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
						//Start
						sbSql.append(" ORDER_ID = ? ,");
						sbSql.append(" ORDER_LINE_NO = ? ,");
						sbSql.append(" OPER_CODE = ? ,");
						sbSql.append(" OPER_SHORT_DESC = ? ,");
						sbSql.append(" PREF_SURG_DATE    = to_date(?,'dd/mm/rrrr') ");
						//End
						sbSql.append(" WHERE facility_id 	= ? " );
						sbSql.append(" AND   bkg_lst_ref_no 	= ? ");
						sbSql.append(" AND   med_ser_grp_code= ? ");

						pstmt= con.prepareStatement(sbSql.toString());

						pstmt.setString	( 1, preferreddate ) ;
						pstmt.setString	( 2, restelno ) ;
						pstmt.setString	( 3, othcontactno ) ;
						pstmt.setString	( 4, emailid ) ;
						pstmt.setString	( 5, resaddrline1 ) ;
						pstmt.setString	( 6, resaddrline2 ) ;
						pstmt.setString	( 7, resaddrline3 ) ;
						pstmt.setString	( 8, resaddrline4 ) ;
						pstmt.setString	( 9, postalcode ) ;
						pstmt.setString	( 10, countrycode ) ;
						pstmt.setString	( 11, patientclasscode ) ;
						pstmt.setString	( 12, otdatetime ) ;
						pstmt.setString	( 13, overrideyn ) ;
						pstmt.setString	( 14, bedclasscode ) ;
						pstmt.setString	( 15, bedtypecode ) ;
						pstmt.setString	( 16, nursingunitcode ) ;
						pstmt.setString	( 17, service_code ) ;
						pstmt.setString	( 18, nursingunittypecode ) ;
						pstmt.setString	( 19, roomno ) ;
						pstmt.setString	( 20, bedno ) ;
						pstmt.setString	( 21, addedById ) ;
						pstmt.setString	( 22, expdaysofstay );
						pstmt.setString	( 23, priority );
						pstmt.setString	( 24, medical_team );
						pstmt.setString	( 25, addedById ) ;
						pstmt.setString	( 26, facilityId ) ;
						pstmt.setString	( 27, addedAtWorkstation ) ;
						pstmt.setString	( 28, reason_for_revision_code) ;
						pstmt.setString	( 29, res_town_code ) ;
						pstmt.setString	( 30, res_area_code ) ;
						pstmt.setString	( 31, res_region_code ) ;
						pstmt.setString	( 32, mail_addr_line1 ) ;
						pstmt.setString	( 33, mail_addr_line2 ) ;
						pstmt.setString	( 34, mail_addr_line3 ) ;
						pstmt.setString	( 35, mail_addr_line4 ) ;
						pstmt.setString	( 36, mail_town_code ) ;
						pstmt.setString	( 37, mail_area_code ) ;
						pstmt.setString	( 38, mail_region_code ) ;
						pstmt.setString	( 39, mail_postal_code ) ;
						pstmt.setString	( 40, mail_country_code ) ;
						pstmt.setString ( 41, practitionerid ) ;
						pstmt.setString ( 42, expected_discharge_date ) ;
						pstmt.setString ( 43, booking_remarks );
						pstmt.setString ( 44, booking_Type_Code);
						//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
						//Start
						pstmt.setString (45, surgery_order_id);
						pstmt.setString (46, surgery_order_line_no);
						pstmt.setString (47, surgery_order_code);
						pstmt.setString (48, surgery_order);
						pstmt.setString (49, surgery_order_date);
						pstmt.setString	(50, facilityId ) ;
						pstmt.setString	(51, bkglstrefno ) ;
						pstmt.setString	(52, medsergrpcode ) ;
						//End
						int res6 = pstmt.executeUpdate();
						pstmt.close();
						if(res6 > 0)
						{
							cancommit = true;
							result		= true;
						}
						if (cancommit)
						{//included for the CRF - RUT-CRF-013 23396
						if (patInstructions!=null ){
							String deleteSql="delete from ip_bkg_pat_instructions where facility_id='"+facilityId+"' and bkg_ref_no='"+bkglstrefno+"'";
							pstmt=con.prepareStatement(deleteSql);
							pstmt.executeUpdate();
							if(!(patInstructions.isEmpty())){
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
									pstmt.setString	( 2, bkglstrefno ) ;
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
								res6=resultArr.length;
							}
						}
						}

					}
					if (res6 != 0)
					{
						cancommit=true;
					}
						else
						{
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal = ((String) message.get("message"));
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_BOOKING_LIST");
							cancommit = false;
							result		= false;
							message.clear();
						}
						if(pstmt != null) pstmt.close();
					}
					catch ( Exception e )
					{
						cancommit	= false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
						String msgVal				= ((String) message.get("message"));
						msgVal						= msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_BOOKING_LIST .. Exception:"+e);
						message.clear();
						e.printStackTrace();
					}
					finally
					{
						if(pstmt != null) pstmt.close();
					}
				}
				// MOD#04 The new hashtable is introduced to pass the variable to the billing bean

					if(isBlInstalled.equals("Y") && cancommit &&  !(p_blng_grp_id == null || p_blng_grp_id.equals("")))
						{
							try
							{
										

										Hashtable hashtableBill = new Hashtable();

										hashtableBill.put("facilityId",facilityId+"");
										hashtableBill.put("bookingrefno",bkglstrefno+"");
										hashtableBill.put("admissiondate",preferreddate+"");
										hashtableBill.put("patientclass","IP");
										hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
										hashtableBill.put("billing_interfaced",billing_interfaced+"");
										hashtableBill.put("isBlInstalled",isBlInstalled+"");
										hashtableBill.put("P_MODE","I");
										hashtableBill.put("P_PATIENT_ID",patientid+"");
										hashtableBill.put("P_BLNG_GRP_ID",p_blng_grp_id+"");
										hashtableBill.put("fin_dtls",fin_dtls);
										hashtableBill.put("P_EPISODE_TYPE","I");
										hashtableBill.put("P_EPISODE_STATUS",p_episode_status+"");
										hashtableBill.put("addedById",addedById+"");
										hashtableBill.put("modifiedAtWorkstation",addedAtWorkstation+"");
										hashtableBill.put("added_date",added_date);
										hashtableBill.put("function_id",strFunctionId+"");
										hashtableBill.put("module_id","IP");
										hashtableBill.put("locale",locale);


										
										BLBooking blbkBookPat = new BLBooking();
										Hashtable resultsBL = blbkBookPat.billPatientService(p, con,hashtableBill);
										boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
										

										result = boolRes;
										String strBLMessage = "";
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
										fin_dtls.clear();

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




				/** If bed no exists insert the ip_bed_booking table **/
				//if(!bedno.equals(""))
				if(cancommit){
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("select req_bed_no from ip_bed_booking WHERE facility_id = '"+facilityId+"' AND   bed_booking_ref_no ='"+bkglstrefno+"' AND booking_type = 'L' ");

					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());

					String strBedExist = "";
					String req_bed_no  = "";
					if (rset.next())
					{
						strBedExist	   = "1";
						req_bed_no     = rset.getString("req_bed_no");
						if (req_bed_no==null)
						{
							req_bed_no = "";
						}
						rset.close();
						Stmt.close();
					}
					//if(!strBedExist.equals("1") && cancommit && req_bed_no.equals(""))
					if(!bedno.equals("") && req_bed_no.equals("")){
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Insert into ip_bed_booking (  ");
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
						sbSql.append(" blocked_until_date_time , ");
						sbSql.append(" REQ_SERVICE_CODE, ");
						sbSql.append(" REQ_TEAM_ID ");
						sbSql.append(" ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,to_date(?,'dd/mm/rrrr hh24:mi'), to_date(?,'dd/mm/rrrr hh24:mi') , to_date(?,'dd/mm/rrrr hh24:mi'),?,? ) ");
						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, "L" ) ;
						pstmt.setString	( 3,  bkglstrefno ) ;
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
						pstmt.setString	( 15, "1" ) ;
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
						pstmt.setString	( 26, medical_team ) ;
						int res1 = pstmt.executeUpdate() ;
						pstmt.close();
						if(res1>0)
						{
							cancommit = true;
							result		= true;
						}
						else
						{
							java.util.Hashtable message  = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
							String msgVal				 = ((String) message.get("message"));
							msgVal						 = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_BED_BOOKING");
							cancommit = false;
							result		= false;
							message.clear();
						}
						if(pstmt != null) pstmt.close();
					}
					/*Wednesday, August 11, 2010,added since booking_status is not getting updated yo '1' when we confirm an unconfirmed booking which is booked with bed_no.*/
					else if((!bedno.equals("") && !req_bed_no.equals("")) || (bedno.equals("") && !req_bed_no.equals(""))){
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" update ip_bed_booking set  ");
						sbSql.append(" req_nursing_unit_code = ?,");
						sbSql.append(" req_bed_no    = ?,");
						sbSql.append(" req_room_no   = ?,");
						sbSql.append(" req_bed_class_code   = ?  ,");
						sbSql.append(" req_bed_type_code    = ?  ,");
						sbSql.append(" daily_rate         = ?   ,");
						sbSql.append(" req_practitioner_id  = ?  ,");
						sbSql.append(" req_specialty_code   = ?  ,");
						sbSql.append(" override_yn    = ?,");
						sbSql.append(" booking_status      = ?,");
						sbSql.append(" modified_by_id      = ?,");
						sbSql.append(" modified_date       = sysdate,");
						sbSql.append(" modified_at_ws_no   = ?,");
						sbSql.append(" modified_facility_id= ?,");
						sbSql.append(" blocked_from_date_time = to_date(?,'dd/mm/rrrr hh24:mi'),");
						sbSql.append(" booking_date_time  = to_date(?,'dd/mm/rrrr hh24:mi'),");
						sbSql.append(" blocked_until_date_time = to_date(?,'dd/mm/rrrr hh24:mi'), ");
						sbSql.append(" REQ_SERVICE_CODE = ?, ");
						sbSql.append(" REQ_TEAM_ID = ?");
						sbSql.append(" where ");
						sbSql.append(" facility_id 	= ?  ");
						sbSql.append(" and   bed_booking_ref_no 	= ? ");
						sbSql.append(" and   booking_type 	= 'L' ");
						sbSql.append(" and   booking_status = '0' ");
						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString	( 1,  nursingunitcode ) ;
						pstmt.setString	( 2,  bedno ) ;
						pstmt.setString	( 3,  roomno ) ;
						pstmt.setString	( 4,  bedclasscode ) ;
						pstmt.setString	( 5, bedtypecode ) ;
						pstmt.setString	( 6, dlycharge) ;
						pstmt.setString	( 7, practitionerid ) ;
						pstmt.setString	( 8, specilitycode ) ;
						pstmt.setString	( 9, overrideyn ) ;
						pstmt.setString	( 10, "1" ) ;
						pstmt.setString	( 11, addedById);
						pstmt.setString	( 12, addedAtWorkstation ) ;
						pstmt.setString	( 13, facilityId ) ;
						pstmt.setString	( 14, preferreddate_from ) ;
						pstmt.setString	( 15, preferreddate ) ;
						pstmt.setString	( 16, preferreddate_to ) ;
						pstmt.setString	( 17, service_code ) ;
						pstmt.setString	( 18, medical_team ) ;
						pstmt.setString	( 19, facilityId ) ;
						pstmt.setString	( 20, bkglstrefno ) ;
			
						int res1 = pstmt.executeUpdate();
						pstmt.close();
						if(res1>0)
						{
							cancommit = true;
							result		= true;
						}
						else
						{
							java.util.Hashtable message  = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal				 = ((String) message.get("message"));
							msgVal						 = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_BED_BOOKING");
							cancommit = false;
							result		= false;
							message.clear();
						}
						if(pstmt != null) pstmt.close();
					}
				}

				//3.insert/update into ip_dly_med_ser_grp_bkg_stat

				l_male_bkngs    = 0 ;
				l_female_bkngs  = 0 ;
				l_unknown_bkngs = 0 ;

				if   (gender.equals("M"))
					 l_male_bkngs    = 1;

				else if (gender.equals("F"))
					 l_female_bkngs  = 1;

				else l_unknown_bkngs = 1;

				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select '1' from ip_dly_med_ser_grp_bkg_stat where ");
				sbSql.append(" facility_id='"+facilityId+"' and med_ser_grp_code='"+medsergrpcode+"' ");
				sbSql.append(" and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) " );

				pstmt = con.prepareStatement( sbSql.toString() );
				rset=pstmt.executeQuery();

				if(!rset.next() && cancommit)
				{
					// Insertion of ip_dly_med_ser_grp_bkg_stat
				/*	if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
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
					sbSql.append( " values ( ?, ?,to_date(?,'dd/mm/rrrr hh24:mi') , ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?) ");
					pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
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
					pstmt.close();
					if(r10>0)
					{
						cancommit = true;
						result		= true;
					}
					else
					{
						java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
						String msgVal = ((String) message.get("message"));
						msgVal = msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_DLY_MED_SER_GRP_BKG_STAT");
						cancommit = false;
						result		= false;
						message.clear();
					}
					rset.close();
					Stmt.close();
				}
				else if(cancommit)
				{
					// updation of ip_dly_med_ser_grp_bkg_stat
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Update ip_dly_med_ser_grp_bkg_stat set ");
					sbSql.append(" Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + "+l_male_bkngs+",");
					sbSql.append(" Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+"+l_female_bkngs+", ");
					sbSql.append(" unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+ "+ l_unknown_bkngs +", ");
					sbSql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 where facility_id= ? ");
					sbSql.append(" and med_ser_grp_code= ?  and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");

					pstmt = con.prepareStatement( sbSql.toString() );
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					int res2 = pstmt.executeUpdate();
					pstmt.close();
					if(res2>0)
					{
						cancommit = true;
						result		= true;
					}
					else
					{
						cancommit = false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
						String msgVal				= ((String) message.get("message"));
						msgVal						= msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_DLY_MED_SER_GRP_BKG_STAT");
						message.clear();
					}*/
				}
				if(pstmt != null) pstmt.close();
				//4.insert/update into ip_mly_med_ser_grp_bkg_stat
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" Select '1' from ip_mly_med_ser_grp_bkg_stat where facility_id='"+facilityId+"' ");
				sbSql.append(" and med_ser_grp_code='"+medsergrpcode+"' and trunc(preferred_month,'mm')=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'mm') ");

				pstmt = con.prepareStatement( sbSql.toString() );
				rset  = pstmt.executeQuery();

				if(!rset.next() && cancommit)
				{
					//4.insertion of ip_mly_med_ser_grp_bkg_stat
					/*if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Insert into ip_mly_med_ser_grp_bkg_stat ( Facility_ID, Med_ser_grp_code, Preferred_month,  ");
					sbSql.append(" Male_Bkngs_Confirmed,Female_Bkngs_Confirmed,unknown_bkngs_confirmed,Tot_Bkngs_Confirmed,    ");
					sbSql.append(" added_by_id,added_date,added_facility_id, added_at_ws_no,modified_by_id,	" );
					sbSql.append(" modified_date, modified_facility_id,modified_at_ws_no) ");
					sbSql.append(" values( ?, ?,trunc(to_date(?,'dd/mm/rrrr hh24:mi'),'mm'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
					 pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString());
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
					pstmt.close();
					if(P>0)
					{
						cancommit = true;
						result		= true;
					}
					else
					{
						cancommit = false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
						String msgVal				= ((String) message.get("message"));
						msgVal						= msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_MLY_MED_SER_GRP_BKG_STAT");
						message.clear();
					}
					rset.close();*/
				}
				else
				{
					//4.updation of ip_mly_med_ser_grp_bkg_stat
					/*if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Update ip_mly_med_ser_grp_bkg_stat set ");
					sbSql.append(" Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + "+l_male_bkngs+",");
					sbSql.append(" Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+"+l_female_bkngs+", ");
					sbSql.append(" unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+ "+ l_unknown_bkngs +", ");
					sbSql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 where facility_id= ? ");
					sbSql.append(" and med_ser_grp_code= ?  and trunc(preferred_month,'mm') = trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'mm') ");

					pstmt = con.prepareStatement( sbSql.toString() );
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, medsergrpcode ) ;
					int res3 = pstmt.executeUpdate();
					pstmt.close();
					if(res3>0)
					{
						cancommit = true;
						result		= true;
					}
					else
					{
						cancommit = false;
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
						String msgVal				= ((String) message.get("message"));
						msgVal						= msgVal.substring(0,msgVal.length()-4);
						sb.append(msgVal+" IP_MLY_MED_SER_GRP_BKG_STAT");
						message.clear();
					}*/
				}
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				//5.insert/update into ip_dly_nurs_ut_bkg_stat
				if ((!nursingunitcode.equals("")) && (!bedclasscode.equals("")))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select '1' from ip_dly_nurs_ut_bkg_stat where facility_id='"+ facilityId +"' and nursing_unit_code='"+nursingunitcode+"' and bed_class_code='"+bedclasscode+"' and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
					pstmt = con.prepareStatement( sbSql.toString() );
					rset=pstmt.executeQuery();
					if(!rset.next() && cancommit)
					{
						//5.insertion of ip_dly_nurs_ut_bkg_stat
						/*if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Insert into ip_dly_nurs_ut_bkg_stat ( ");
						sbSql.append(" Facility_ID,");
						sbSql.append(" nursing_unit_code,");
						sbSql.append(" bed_class_code ,");
						sbSql.append(" Preferred_date,");
						sbSql.append(" Male_Bkngs_Confirmed,");
						sbSql.append(" Female_Bkngs_Confirmed,");
						sbSql.append(" unknown_bkngs_confirmed,");
						sbSql.append(" Tot_Bkngs_Confirmed , " );
						sbSql.append(" added_by_id,");
						sbSql.append(" added_date,");
						sbSql.append(" added_facility_id,");
						sbSql.append(" added_at_ws_no,");
						sbSql.append(" modified_by_id,	");
						sbSql.append(" modified_date,");
						sbSql.append(" modified_facility_id,");
						sbSql.append(" modified_at_ws_no) " );
						sbSql.append(" values( ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
						 pstmt.close();
						pstmt = con.prepareStatement( sbSql.toString() );
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
						pstmt.close();
						if(P1 > 0)
						{
							cancommit = true;
							result		= true;
						}
						else
						{
							cancommit = false;
							result		= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
							String msgVal				= ((String) message.get("message"));
							msgVal						= msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_NURS_UT_BKG_STAT");
							message.clear();
						}
						rset.close();*/
					}
					else if(cancommit)
					{
						//5.updation of ip_dly_nurs_ut_bkg_stat
					/*	if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Update ip_dly_nurs_ut_bkg_stat set " );
						sbSql.append(" Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + "+l_male_bkngs+"," );
						sbSql.append(" Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+ "+l_female_bkngs+", ");
						sbSql.append(" unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+"+ l_unknown_bkngs+", ");
						sbSql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 ");
						sbSql.append(" where facility_id= ? and nursing_unit_code= ? ");
						sbSql.append(" and bed_class_code= ? and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");

						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, nursingunitcode ) ;
						pstmt.setString	( 3, bedclasscode ) ;
						int res4 = pstmt.executeUpdate();
						pstmt.close();
						if(res4 > 0)
						{
							cancommit = true;
							result		= true;
						}
						else
						{
							cancommit = false;
							result		= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal				= ((String) message.get("message"));
							msgVal						= msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_NURS_UT_BKG_STAT");
							message.clear();
						}*/
					}
					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
				}//E.O.IF
				// Based on parameter setup check the booking limits of  nursing unit age group
				if (!bedclasscode.equals("") && checkbookinglimitby.equals("2") && (!(ageGrpcode.equals("") || ageGrpcode == null)))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append( " Select '1' from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' ");
					sbSql.append(" and age_group_code='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
					sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'))");

					pstmt = con.prepareStatement( sbSql.toString() );
					rset=pstmt.executeQuery();

					if(!rset.next() && cancommit)
					{
						// agegroup insertion
						/*if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Insert into ip_dly_age_grp_bkg_stat ( Facility_ID, age_group_code,bed_class_code ,Preferred_date, ");
						sbSql.append(" Male_Bkngs_Confirmed,   Female_Bkngs_Confirmed ,unknown_bkngs_confirmed, Tot_Bkngs_Confirmed , ");
						sbSql.append(" added_by_id,added_date,added_facility_id, added_at_ws_no,modified_by_id,	" );
						sbSql.append(" modified_date, modified_facility_id,	modified_at_ws_no) ");
						sbSql.append(" values( ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

						pstmt = con.prepareStatement(sbSql.toString());
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
						{
							cancommit = true;
							result		= true;
						}
						else
						{
							cancommit	= false;
							result		= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
							String msgVal				= ((String) message.get("message"));
							msgVal						= msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_AGE_GRP_BKG_STAT");
							message.clear();
						}
						rset.close();
						pstmt.close();		*/
		  			}
		   			else if(cancommit)
					{
						// agegroup updation
					/*	if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Update ip_dly_age_grp_bkg_stat set ");
						sbSql.append(" Male_Bkngs_Confirmed = Male_Bkngs_Confirmed + '"+l_male_bkngs+"',");
						sbSql.append(" Female_Bkngs_Confirmed = Female_Bkngs_Confirmed+ '"+l_female_bkngs+"', ");
						sbSql.append(" unknown_Bkngs_Confirmed = unknown_Bkngs_Confirmed+ '"+l_unknown_bkngs+"', ");
						sbSql.append(" Tot_Bkngs_Confirmed = Tot_Bkngs_Confirmed+1 where facility_id= ? ");
						sbSql.append(" and age_group_code= ? and bed_class_code= ?  and trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");

						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, ageGrpcode ) ;
						pstmt.setString	( 3, bedclasscode ) ;
						int res5 = pstmt.executeUpdate();
						pstmt.close();
						if(res5>0)
						{
							cancommit = true;
							result	= true;
						}
						else
						{
							cancommit					= false;
							result						= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal				= ((String) message.get("message"));
							msgVal						= msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_DLY_AGE_GRP_BKG_STAT");
							message.clear();
						}*/
					}
					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
				}
			}
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
				//Starts
				try 
					{						
					if(cancommit && smartCardFunc.equals("01") && !biometric_reason.equals(""))
						{
						String status=eCommon.Common.CommonBean.insertReasonforBiometric(con,facilityId,"IP_CONFIRM_BOOKING",patientid,bkglstrefno,nursingunitcode,biometric_reason,addedAtWorkstation,addedById);
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
			if(cancommit)
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				String msgVal	= ((String) message.get("message"));
				msgVal			= msgVal.substring(0,msgVal.length()-4);
				sb.append(msgVal+"<B><FONT SIZE=4>"+bkglstrefno+"</B></FONT>");
				message.clear();
				con.commit();
			}
			else
			{
				con.rollback();
			}
		}
		catch(Exception e)
		{
			sb.append("Exception " + e);

			try
			{
				con.rollback();
				e.printStackTrace();

			}
			catch ( Exception e1 ){	}
		}
		finally
		{
			try
			{
				if(rs20 !=null) rs20.close();
				if(rset !=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(Stmt !=null) Stmt.close();
			}
			catch(Exception ex)
			{
			}
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		hashData.clear();
		return results;
	}//E.O.Method
} // E.O.Class
