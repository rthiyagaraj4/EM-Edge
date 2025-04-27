/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to revise the booking already done.
@version - V3
*/
package eIP.IPReviseBooking;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
import blbkin.*;
/**
*
* @ejb.bean
*	name="IPReviseBooking"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPReviseBooking"
*	local-jndi-name="IPReviseBooking"
*	impl-class-name="eIP.IPReviseBooking.IPReviseBookingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPReviseBooking.IPReviseBookingLocal"
*	remote-class="eIP.IPReviseBooking.IPReviseBookingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPReviseBooking.IPReviseBookingLocalHome"
*	remote-class="eIP.IPReviseBooking.IPReviseBookingHome"
*	generate= "local,remote"
*
*
*/
public class IPReviseBookingManager implements SessionBean
{
	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove(){}
	public void ejbActivate(){}
	public void ejbPassivate(){}

	public void setSessionContext(SessionContext context){this.ctx=context;}

	/**
	This method is used to update the information recorded during the booking.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap insertIPReviseBooking(java.util.Properties p,java.util.HashMap hashData){
		Connection			con			= null;
		PreparedStatement	pstmt		= null;
		ResultSet			rset 		= null;
		ResultSet			rs20		= null;
		Statement			Stmt 		= null;
		StringBuffer		sb			= null;
		StringBuffer		sb1			= null;
		StringBuffer		sqls		= null;
		String checkbookinglimitby		= "";
		String ageGrpcode				= "";
		String dlycharge				= "";
		String setup_bl_dtls_in_ip_yn	= "N";
		String frm_modifiedDate			= "";
		String to_modifiedDate			= "";
		int No_Of_Record				=0;
	
		boolean cancommit			= true;
		boolean result				= true;
		int maxdlyBk				= 0;
		int maxmtlyBk				= 0;
		int MdlyBkg					= 0;
		int FdlyBkg					= 0;
		int UdlyBkg					= 0;
		int MaxtotBk				= 0;
		int totBk					= 0;
		int chkval					= 0;
		int DatVal					= 0;
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order_code="";
		String surgery_order="";
		String surgery_order_id="";
		String surgery_order_line_no="";
		String surgery_order_date="";
		//End
		java.util.HashMap results				= null;
		java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		String facilityId		= (String)hashData.get("facilityId");		
		String expdaysofstay	= (String)hashData.get("expdaysofstay");
		String priority			= (String)hashData.get("priority");
		String medical_team		= (String)hashData.get("medical_team");
		String bkglstrefno		= (String)hashData.get("bkglstrefno");
		String medsergrpcode	= (String)hashData.get("medsergrpcode");		
		String preferreddate	= (String)hashData.get("preferreddate");
		String block_bed_based_on	= (String)hashData.get("block_bed_based_on");	
		StringTokenizer sttoks	  = new StringTokenizer(preferreddate," ");
		String preferreddate_from = sttoks.nextToken();
		String preferreddate_to   = preferreddate_from;
		//preferreddate_from        = preferreddate_from+" 00:01";
		//preferreddate_to		  = preferreddate_to+" 23:59";
		String expected_discharge_date = (String)hashData.get("expected_discharge_date");	
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
		String patientclasscode	= (String)hashData.get("patientclasscode");
		String specilitycode	= (String)hashData.get("specilitycode");
		String practitionerid	= (String)hashData.get("practitionerid");
		String chiefcomplaint	= (String)hashData.get("chiefcomplaint");
		String otdatetime		= (String)hashData.get("otdatetime");
		String overrideyn		= (String)hashData.get("overrideyn");
		String bedclasscode		= (String)hashData.get("bedclasscode");
		String bedtypecode		= (String)hashData.get("bedtypecode");
		String nursingunitcode	= (String)hashData.get("nursingunitcode");
		String roomno			= (String)hashData.get("roomno");
		String bedno			= (String)hashData.get("bedno");
		String addedAtWorkstation= (String)hashData.get("client_ip_address");
		//String oldbedno			= (String)hashData.get("oldbedno");
		String service_code		= (String)hashData.get("service_code");
		String booking_remarks  = (String)hashData.get("booking_remarks");
		String booking_Type_Code= (String)hashData.get("booking_Type_Code");
		
//		String oldnursingunit	= (String)hashData.get("oldnursingunit");
		String reason_for_revision_code= (String)hashData.get("reason_for_revision_code");
		frm_modifiedDate	= (String)hashData.get("modifiedDate");
		String locale = p.getProperty("LOCALE");
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= checkForNull((String)hashData.get("altAddrLine1"));
		String altAddrLine2		= checkForNull((String)hashData.get("altAddrLine2"));
		String altAddrLine3		= checkForNull((String)hashData.get("altAddrLine3"));
		String altAddrLine4		= checkForNull((String)hashData.get("altAddrLine4"));
		String altAreaCode		= checkForNull((String)hashData.get("altAreaCode"));
		String altTownCode		= checkForNull((String)hashData.get("altTownCode"));
		String altPostalCode	= checkForNull((String)hashData.get("altPostalCode"));
		String altRegionCode	= checkForNull((String)hashData.get("altRegionCode"));
		String altCountryCode	= checkForNull((String)hashData.get("altCountryCode"));
		/*End*/
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc =checkForNull((String)hashData.get("smartCardFunc"));
		String biometric_reason=checkForNull((String)hashData.get("biometric_reason"));
		//Ends

		StringBuffer sbSql = new StringBuffer();
		 sb = new StringBuffer();
		if (sb.toString().length()>0)
			sb.delete(0, sb.length());
		 sb1 = new StringBuffer();
		if (sb1.toString().length()>0)
			sb1.delete(0, sb1.length());
		result				= true;
		results				= new java.util.HashMap() ;

		String isBlInstalled	= (String)hashData.get("isBlInstalled");
		//String iscapture_fin_dtls_yn	= (String)hashData.get("iscapture_fin_dtls_yn");
		//String str_dailycharge			= (String)hashData.get("dailycharge");
		String billing_interfaced		= (String)hashData.get("billing_interfaced");
		String p_blng_grp_id			= (String)hashData.get("billing_group");
		//String p_package_bill_doc_type	= (String)hashData.get("pkg_bill_type");
		//String str_P_PACKAGE_BILL_DOC_NUM= (String)hashData.get("pkg_bill_no");
		String p_episode_status			= (String)hashData.get("episodestatus");

		HashMap	fin_dtls                = (HashMap)hashData.get("fin_dtls");
		ArrayList patInstructionsList=(ArrayList)hashData.get("patInstructions");
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		surgery_order_code=(String)hashData.get("surgery_order_code");
		surgery_order=(String)hashData.get("surgery_order");
		surgery_order_id=(String)hashData.get("surgery_order_id");
		surgery_order_line_no=(String)hashData.get("surgery_order_line_no");
		surgery_order_date=(String)hashData.get("surgery_order_date");
		//End
		//String str_P_VISIT_ID			= (String)hashData.get("visitid");
		//String insTrackDtlsExists		= (String)hashData.get("insTrackDtlsExists");
		String strFunctionId		= "REVISEBOOKING";

		hashData.clear();

		boolean	isReviseBkgAftrConfrmAppl = false;//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
		
		sbSql.append("Select modified_date, booking_status from IP_BOOKING_LIST where facility_id = '"+facilityId+"' and  bkg_lst_ref_no = '"+bkglstrefno+"' " );
		String booking_status = "";
		
		con = ConnectionManager.getConnection(p);
		
		try
		{
			isReviseBkgAftrConfrmAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","REVISE_BKG_AFTR_CONFIRM");//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
			
			smartCardFunc	= eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 

			pstmt = con.prepareStatement(sbSql.toString());
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				to_modifiedDate = rset.getString("modified_date");
				booking_status = rset.getString("booking_status");
			}
			if(booking_status.equals("9"))
			{
				result = false;
				
				java.util.Hashtable message = MessageManager.getMessage(locale,"BKNG_CANCELLED_CANT_REV","IP");
				sb.append((String) message.get("message"));
				message.clear();
				
			}
			else if (!isReviseBkgAftrConfrmAppl && booking_status.equals("1"))//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
			{
				to_modifiedDate = "";
				result = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"BKNG_CONF_CANT_REV","IP");
				sb.append((String) message.get("message"));
				message.clear();
			}
			else if (!frm_modifiedDate.equals(to_modifiedDate))
			{
				to_modifiedDate = "";
				result = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"BKNG_ALREADY_MODIFIED","IP");
				sb.append((String) message.get("message"));
				message.clear();
			}
             
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			
		}
		catch(Exception exception1)
		{
			sb.append("Error in selecting modified date " + exception1.toString());
			//exception1.printStackTrace();
			
			exception1.printStackTrace();
		}
		finally
		{
			//if(con != null)      ConnectionManager.returnConnection(con,p);
		}
         
		if(result)
		{
			 
			try
			{
				//sb							= new StringBuffer("");
				sqls						= new StringBuffer("");
				cancommit					= true;
				//con 						= ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				String addedById 			= p.getProperty( "login_user" ) ;
				String addedDate 			= dateFormat.format( new java.util.Date() ) ;
				java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;

				/** check whether the billing is installed or not   **/
				Stmt=con.createStatement();
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select setup_bl_dtls_in_ip_yn, sign((sysdate+nvl(ADV_BED_BOOK_PERIOD_BKG,0)-(trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'))))) valid_flag,chk_booking_limit_by from ip_param where facility_id='"+facilityId+"' ");
				rs20 = Stmt.executeQuery(sbSql.toString());
				if(rs20!=null )
				{
					while(rs20.next())
					 {
						setup_bl_dtls_in_ip_yn=rs20.getString("setup_bl_dtls_in_ip_yn");
						chkval = rs20.getInt("valid_flag");
						checkbookinglimitby = rs20.getString("chk_booking_limit_by");
					 }
				}
				if(rs20!=null)rs20.close(); if(Stmt!=null)Stmt.close();
				
				if(chkval < 0)	
				{
					cancommit=false;
					java.util.Hashtable message = MessageManager.getMessage( locale, "PREFER_DATE_LT_EXCEEDED" ,"IP");
					sb.append( (String) message.get("message")) ;
					message.clear();
				}

				/**Check for the Nursing Unit type code under that Medical Service Group**/
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				if(!nursingunitcode.equals(""))
				{
					sbSql.append(" SELECT 1 FROM ip_nursing_unit a, ip_med_ser_grp_nurs_ut_type b ");
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
							cancommit=false;
							java.util.Hashtable message = 	MessageManager.getMessage(locale,"INVALID_MSG_NUT_RIGHTS","IP");
							sb.append((String) message.get("message"));
							message.clear();	
						}

					}
					if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
				}
				
	 			if(cancommit && !otdatetime.equals(""))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select sign(to_date('"+otdatetime+"','dd/mm/rrrr hh24:mi') - (TO_DATE('"+preferreddate+"','DD/MM/rrrr hh24:mi'))) L_SIGN FROM DUAL ");
					Stmt=con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());
					if (rset.next())
					{
						DatVal = rset.getInt(1);
						if (DatVal < 0)
						{
							cancommit = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_OT_DATE","IP");
							sb.append((String) message.get("message"));
							message.clear();
						}
					}
					if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
				}
				if(cancommit)
				{
					/***	Check for the valid Nursing Unit  ***/
					if (!nursingunitcode.equals(""))
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select '1' from ip_nursing_unit_for_pract where ");
						sbSql.append(" facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
						sbSql.append(" and practitioner_id='"+practitionerid+"' ");
		
						Stmt=con.createStatement();
						rset = Stmt.executeQuery(sbSql.toString());

						if (!rset.next())
						{
							cancommit = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP");
							sb.append((String) message.get("message"));
							message.clear();
						}
						if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
						if(cancommit)
						{
							// Check for the speciality of the nursing unit
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append( " Select '1' from ip_nurs_unit_for_specialty a, am_speciality b where ");
							sbSql.append(" a.facility_id='"+facilityId+"' and a.nursing_unit_code='"+nursingunitcode+"' ");
							sbSql.append(" and a.specialty_code = b.speciality_code and b.eff_status = 'E' and a.specialty_code='"+specilitycode+"' ");
			
							Stmt = con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());
							if(!rset.next())
							{
							   cancommit = false;
							   java.util.Hashtable message = MessageManager.getMessage(locale,"SPLTY_ADMN_RIGHTS_DENIED","IP");
							   sb.append((String) message.get("message"));
							   message.clear();
							}
							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
						}
						if(cancommit)
						{
							/** valid Age group and gender for the nursing unit **/
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" SELECT age_group_code FROM ip_nursing_unit ");
							sbSql.append(" WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
			
							Stmt=con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());

							if (rset.next())
							{
								String  agegroupcode = rset.getString("age_group_code");
								if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
								if (agegroupcode != null)
								{
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append(" Select '1' from am_age_group Where age_group_code='"+agegroupcode+"'  And NVL(GENDER,'"+gender+"')= '"+gender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
									Stmt=con.createStatement();
									rset = Stmt.executeQuery(sbSql.toString());

									if(rset == null)
									{
										cancommit=false;
										java.util.Hashtable message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
										sb.append((String) message.get("message"));
										message.clear();
									}
								}
								if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
							 }
						}
					}
				}
				if(cancommit)
				{
					/*** Check for valid Bed ***/
					if (!bedno.equals(""))
					{
						String comp = nursingunitcode+bedclasscode;
						if (comp.equals(" ") ||  comp.equals(""))
						{
							cancommit=false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"NU_AND_BC_NOTNULL","IP");
							sb.append((String) message.get("message"));
							message.clear();
						}
						else
						{
							/** Check for valid Bed  **/
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select Occupying_Patient_Id, bed_type_code, specialty_code from ip_nursing_unit_bed ");
							sbSql.append( " WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
							sbSql.append(" And bed_no='"+bedno+"' ");
		
							Stmt=con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());

							if(rset.next())
							{	
								bedtypecode = rset.getString(2);
								//String OPatId = rset.getString(1);
								String splty_code = rset.getString(3);
								if (splty_code==null) splty_code = "";
								/*
								if (OPatId != null)
								{
									cancommit=false;
									java.util.Hashtable message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP");
									sb.append((String) message.get("message"));
									message.clear();
								}
								*/
								if (!splty_code.equals("") && !splty_code.equals(specilitycode))
								{
										cancommit=false;
										java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID" ,"IP") ;
										sb.append( (String) message.get("message") ) ;
										message.clear();
								}

							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
							}
							else
							{
								cancommit=false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_BED","Common");
								sb.append((String) message.get("message"));
								message.clear();
							}
						  /** Check for Blocked/Booked beds **/
						  if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						  /*
						  sbSql.append(" Select BOOKING_TYPE, override_yn from ip_bed_booking ");
						  sbSql.append("WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunitcode+"' ");
						  sbSql.append(" and req_bed_no='"+bedno+"' and booking_status='0' and sysdate between blocked_from_date_time ");
						  sbSql.append(" and blocked_until_date_time ");
							*/
						/*Wednesday, November 24, 2010 , SRR20056-SCF-6065-IN025197*/
						sbSql.append(" Select booking_type, override_yn,bed_booking_ref_no from ip_bed_booking ");
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

							   String bed_booking_ref_no = rset.getString(3);
							   if(bed_booking_ref_no == null) bed_booking_ref_no = "";
								
							/*Tuesday, January 11, 2011 , condition added  if(!(bed_booking_ref_no.equals(bkglstrefno))) for SRR20056-SCF-6376 [IN:025836]*/
							  if(!(bed_booking_ref_no.equals(bkglstrefno)))
							  {
								   if (orVal.equals("N"))
								   {
									if (bkType.equals("L"))
									 {
										cancommit=false;
										java.util.Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP");
										sb.append((String) message.get("message"));
										message.clear();
									 }
									else
									 {
										cancommit=false;
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
											  sb1.append((String) message.get("message"));
											  message.clear();
										  }
										else
										  {
											  java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BLOCKING","IP");
											  sb1.append((String) message.get("message"));
											  message.clear();
										  }
									}
								}
							}
							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
							//E.O.IF
						 }
					}//E.O.IF for (!bed_no.equals(""))
				}
				if(cancommit)
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append( " Select MAX_NO_OF_DLY_BOOKING,MAX_NO_OF_MTHLY_BOOKING from ip_medical_service_group ");
					sbSql.append(" where facility_id='"+facilityId+"' and	med_ser_grp_code='"+medsergrpcode+"' ");
		
					Stmt=con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());

					if(rset.next())
					{
						maxdlyBk  = rset.getInt(1);
						maxmtlyBk = rset.getInt(2);
						if (maxdlyBk != 0)
						{
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
							sbSql.append(" Select tot_bkngs_confirmed+tot_bkngs_pending  as tot_booked ");
							sbSql.append(" from ip_dly_med_ser_grp_bkg_stat where facility_id='"+facilityId+"' ");
							sbSql.append(" and  med_ser_grp_code='"+medsergrpcode+"' and  preferred_date=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
							sbSql.append(" and  trunc(preferred_date) !=(select trunc(to_date(preferred_date,'dd/mm/rrrr'))dt from ip_booking_list where BKG_LST_REF_NO='"+bkglstrefno+"') ");
							Stmt=con.createStatement();
							rset = Stmt.executeQuery(sbSql.toString());

							if(rset.next())
							{
								totBk = rset.getInt("tot_booked") ;
								if (maxdlyBk <= totBk)
								{
									java.util.Hashtable message = MessageManager.getMessage(locale,"MSG_DLY_LT_EXCEEDS","IP");
									sb.append((String) message.get("message"));
									message.clear();
									cancommit = false;
								}
							}
							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
						 }

						if(maxmtlyBk != 0)
						{
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
							sbSql.append(" Select tot_bkngs_confirmed+tot_bkngs_pending  as tot_booked ");
							sbSql.append(" FROM ip_mly_med_ser_grp_bkg_stat where facility_id='"+facilityId+"' ");
							sbSql.append(" AND  med_ser_grp_code='"+medsergrpcode+"' AND  TO_CHAR(preferred_month, 'MM/YYYY')=TO_CHAR (TO_DATE ('"+preferreddate+"','dd/mm/rrrr hh24:mi'),'MM/YYYY')");
							sbSql.append(" AND TO_CHAR(preferred_month, 'MM/YYYY') != TO_CHAR((select to_date(preferred_date,'dd/mm/rrrr hh24:mi')from ip_booking_list where BKG_LST_REF_NO='"+bkglstrefno+"'),'MM/YYYY')");
	 
							Stmt=con.createStatement();

							rset = Stmt.executeQuery(sbSql.toString());
							if(rset.next())
							{
								 totBk = rset.getInt("tot_booked") ;

								 if (maxmtlyBk <= totBk)
								 {
									 java.util.Hashtable message = MessageManager.getMessage(locale,"MSG_DLY_LT_EXCEEDS","IP");
									 sb.append((String)message.get("message"));
									 message.clear();
									 cancommit = false;
								 }
							}
							if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
						}
					}
					if (!nursingunitcode.equals(""))
					{
						if (checkbookinglimitby.equals("1"))
						{
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking,max_total_dly_booking from ip_book_limit_by_nurs_ut ");
							sbSql.append(" where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' ");
							sbSql.append(" and bed_class_code='"+bedclasscode+"'");
	
							Stmt=con.createStatement();

							rset = Stmt.executeQuery(sbSql.toString());
							if(rset.next())
							{
								MdlyBkg  = rset.getInt(1);
								FdlyBkg  = rset.getInt(2);
								UdlyBkg  = rset.getInt(3);
								MaxtotBk = rset.getInt(4);

								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" Select  male_bkngs_confirmed+male_bkngs_pending male_booked, ");
								sbSql.append(" female_bkngs_confirmed+female_bkngs_pending female_booked , ");
								sbSql.append(" unknown_bkngs_confirmed+unknown_bkngs_pending unknown_booked,tot_bkngs_confirmed+tot_bkngs_pending  tot_booked from ");
								sbSql.append(" ip_dly_nurs_ut_bkg_stat where facility_id='"+ facilityId+"' and nursing_unit_code='"+nursingunitcode+"' and bed_class_code='"+bedclasscode+"' ");
								sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
								sbSql.append("AND ('"+bedclasscode+"' != (select bed_class_code from ip_booking_list where BKG_LST_REF_NO='"+bkglstrefno+"') OR trunc(preferred_date) != (select trunc(to_date(preferred_date,'dd/mm/rrrr'))dt from ip_booking_list where BKG_LST_REF_NO='"+bkglstrefno+"'))");
								if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();		  
								Stmt=con.createStatement();

								rset = Stmt.executeQuery(sbSql.toString());
								int Mbooked = 0;
								int Fbooked = 0;
								int Ubooked =	0;
								int TotBook = 	   0;
								if(rset.next())
								{
								 Mbooked = rset.getInt(1);
								 Fbooked = rset.getInt(2);
								 Ubooked = rset.getInt(3);
								 TotBook = rset.getInt(4);
								}
								if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
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
									java.util.Hashtable message = MessageManager.getMessage(locale,"NUR_UT_LT_EXCEEDS","IP");
									 sb.append((String)message.get("message"));
									 message.clear();
									 cancommit = false;
								}
							}
						}
						else
						{
							if (checkbookinglimitby.equals("2"))
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" Select age_group_code,max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking, max_total_dly_booking from ip_book_limit_by_age_grp where facility_id='"+facilityId+"' and bed_class_code='"+bedclasscode+"' ");
								sbSql.append(" and age_group_code in(select age_group_code from am_age_group where NVL(GENDER,'"+gender+"')= '"+gender+"' AND trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') ");
								sbSql.append(" BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE) ");
		  
								Stmt=con.createStatement();
								rset = Stmt.executeQuery(sbSql.toString());
								if(rset.next())
								{
									ageGrpcode 		= rset.getString(1);
									MdlyBkg		= rset.getInt(2);
									FdlyBkg		= rset.getInt(3);
									UdlyBkg		= rset.getInt(4);
									MaxtotBk 	= rset.getInt(5);

									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
									sbSql.append(" Select gender from am_age_group b, ip_nursing_unit a where a.facility_id='"+facilityId+"' ");
									sbSql.append( " and a.nursing_unit_code='"+nursingunitcode+"' and b.age_group_code(+)=a.age_group_code ");
					
									Stmt=con.createStatement();

									rset = Stmt.executeQuery(sbSql.toString());
									
									String genVal="";
									if(rset.next())
										genVal = rset.getString(1);
									if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									/*sbSql.append(" Select decode('"+genVal+"','M', male_bkngs_confirmed+male_bkngs_pending,'F', female_bkngs_confirmed+female_bkngs_pending, 'U', unknown_bkngs_confirmed+unknown_bkngs_pending, ");
									sbSql.append(" tot_bkngs_confirmed+tot_bkngs_pending ) tot_booked from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' and age_group_code ='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
									sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
									*/
									sbSql.append("Select  (male_bkngs_confirmed+male_bkngs_pending) male_booked, (female_bkngs_confirmed+female_bkngs_pending) female_booked, (unknown_bkngs_confirmed+unknown_bkngs_pending) unknown_booked, ");
									sbSql.append(" (tot_bkngs_confirmed+tot_bkngs_pending)  tot_booked from ip_dly_age_grp_bkg_stat where facility_id='"+facilityId+"' and age_group_code ='"+ageGrpcode+"' and bed_class_code='"+bedclasscode+"' ");
									sbSql.append(" and  trunc(preferred_date)=trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi')) ");
									sbSql.append("AND ('"+bedclasscode+"' != (select bed_class_code from ip_booking_list where BKG_LST_REF_NO='"+bkglstrefno+"') OR trunc(preferred_date) != (select trunc(to_date(preferred_date,'dd/mm/rrrr'))dt from ip_booking_list where BKG_LST_REF_NO='"+bkglstrefno+"'))");
									 Stmt=con.createStatement();
									 rset = Stmt.executeQuery(sbSql.toString());
									if(rset.next())
									{
										int Mbooked = rset.getInt(1);
										int Fbooked = rset.getInt(2);
										int Ubooked = rset.getInt(3);
										int TotBook = rset.getInt(4);
										int l_limit_exceed = 0;
										 /*if (maxmtlyBk != 0 && maxmtlyBk <= totBk)
										 {
											 java.util.Hashtable message = MessageManager.getMessage(locale,"AGE_GRP_LT_EXCEEDS","IP");
											 sb.append((String)message.get("message"));
											 message.clear();
											 cancommit = false;
										 }*/
										 if(gender.equals("M")){
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
										 }else if(gender.equals("F")){
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
										 }else if(gender.equals("U")){
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
											 java.util.Hashtable message = MessageManager.getMessage(locale,"AGE_GRP_LT_EXCEEDS","IP");
											 sb.append((String)message.get("message"));
											 message.clear();
											 cancommit = false;
										}
									}
									if(rset!=null)rset.close(); if(Stmt!=null)Stmt.close();
								 }
							}
						}
					}
				}//cancommit IF ends
		
				//Updating the ip_booking_list table
				if(cancommit)
				{
					try
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" UPDATE ip_booking_list SET ");
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
						sbSql.append(" chief_complaint = ? ,");
						sbSql.append(" ot_date_time    = to_date(?,'dd/mm/rrrr hh24:mi'),");
						sbSql.append(" booking_date_time  =	sysdate,");
						sbSql.append(" booked_by_id   =?, ");
						sbSql.append(" booking_status ='"+booking_status+"',  ");//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
						sbSql.append(" exp_days_of_stay= ?,");
						sbSql.append(" priority_ind	= ?,");
						sbSql.append(" team_id	=	?,");
						sbSql.append(" modified_by_id = ?,");
						sbSql.append(" modified_date  =sysdate,");
						sbSql.append(" modified_facility_id  = ?, ");
						sbSql.append(" modified_at_ws_no 	= ?, ");
						sbSql.append(" patient_id	= ? , ");     
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
						sbSql.append(" MAIL_COUNTRY_CODE = ?, ");
						sbSql.append(" SPECIALTY_CODE  = ?, ");
						sbSql.append(" PRACTITIONER_ID = ?, " );
						sbSql.append(" EXPECTED_DISCHARGE_DATE    = to_date(?,'dd/mm/rrrr hh24:mi'),");

						//Additional parameter

						sbSql.append(" BED_CLASS_CODE = ? ,");
						sbSql.append(" BED_TYPE_CODE = ? ,");
						sbSql.append(" NURSING_UNIT_CODE = ? ,");
						sbSql.append(" SERVICE_CODE = ? ,");
						sbSql.append(" ROOM_NO = ? ,");
						sbSql.append(" BED_NO = ? ,");						
						sbSql.append(" OVERRIDE_YN = ? ,");
						sbSql.append(" DIAGNOSIS_REMARKS = ? , ");
						sbSql.append(" BOOKING_TYPE_CODE = ?  ,");
						//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
						//Start
						sbSql.append(" ORDER_ID = ? ,");
						sbSql.append(" ORDER_LINE_NO = ? ,");
						sbSql.append(" OPER_CODE = ? ,");
						sbSql.append(" OPER_SHORT_DESC = ? ,");
						sbSql.append(" PREF_SURG_DATE    = to_date(?,'dd/mm/rrrr'), ");
						//End
						/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
						sbSql.append(" ALT_ADDR_LINE1 = ?,");
						sbSql.append(" ALT_ADDR_LINE2 = ?,");
						sbSql.append(" ALT_ADDR_LINE3 = ?,");
						sbSql.append(" ALT_ADDR_LINE4 = ?,");
						sbSql.append(" ALT_TOWN_CODE = ?,");
						sbSql.append(" ALT_AREA_CODE = ?,");
						sbSql.append(" ALT_REGION_CODE = ?,");
						sbSql.append(" ALT_POSTAL_CODE = ?,");
						sbSql.append(" ALT_COUNTRY_CODE = ?");
						/*End*/
						//End Addition
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
						pstmt.setString	( 12, chiefcomplaint ) ;
						pstmt.setString	( 13, otdatetime ) ;
						pstmt.setString	( 14, addedById ) ;
						pstmt.setString	( 15, expdaysofstay );
						pstmt.setString	( 16, priority );
						pstmt.setString	( 17, medical_team );
						pstmt.setString	( 18, addedById ) ;
						pstmt.setString	( 19, facilityId ) ;
						pstmt.setString	( 20, addedAtWorkstation ) ;
						pstmt.setString	( 21, patientid ) ;
						pstmt.setString	( 22, reason_for_revision_code) ;
						pstmt.setString	( 23, res_town_code ) ;
						pstmt.setString	( 24, res_area_code ) ;
						pstmt.setString	( 25, res_region_code ) ;
						pstmt.setString	( 26, mail_addr_line1 ) ;
						pstmt.setString	( 27, mail_addr_line2 ) ;
						pstmt.setString	( 28, mail_addr_line3 ) ;
						pstmt.setString	( 29, mail_addr_line4 ) ;
						pstmt.setString	( 30, mail_town_code ) ;
						pstmt.setString	( 31, mail_area_code ) ;
						pstmt.setString	( 32, mail_region_code ) ;
						pstmt.setString	( 33, mail_postal_code ) ;
						pstmt.setString	( 34, mail_country_code ) ;
						pstmt.setString	( 35, specilitycode ) ;
						pstmt.setString	( 36, practitionerid ) ;
						pstmt.setString	( 37, expected_discharge_date ) ;

						//Additional parameter
						pstmt.setString	( 38, bedclasscode ) ;
						pstmt.setString	( 39, bedtypecode ) ;
						pstmt.setString	( 40, nursingunitcode ) ;
						pstmt.setString	( 41, service_code ) ;
						pstmt.setString	( 42, roomno ) ;
						pstmt.setString	( 43, bedno ) ;
						pstmt.setString	( 44, overrideyn ) ;
						pstmt.setString ( 45, booking_remarks);
						pstmt.setString ( 46, booking_Type_Code);
						//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
						//Start
						pstmt.setString (47, surgery_order_id);
						pstmt.setString (48, surgery_order_line_no);
						pstmt.setString (49, surgery_order_code);
						pstmt.setString (50, surgery_order);
						pstmt.setString (51, surgery_order_date);
						/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
						pstmt.setString (52, altAddrLine1);
						pstmt.setString (53, altAddrLine2);
						pstmt.setString (54, altAddrLine3);
						pstmt.setString (55, altAddrLine4);
						pstmt.setString (56, altTownCode);
						pstmt.setString (57, altAreaCode);
						pstmt.setString (58, altRegionCode);
						pstmt.setString (59, altPostalCode);
						pstmt.setString (60, altCountryCode);
						/*End*/
						pstmt.setString	( 61, facilityId ) ;
						pstmt.setString	( 62, bkglstrefno ) ;
						pstmt.setString	( 63, medsergrpcode ) ;
						

						int res6 = pstmt.executeUpdate();
						if(res6 > 0) cancommit = true; 
						else{
							cancommit = false;
						}
						if(cancommit){
							if (patInstructionsList!=null ){
							String deleteSql="delete from ip_bkg_pat_instructions where facility_id='"+facilityId+"' and bkg_ref_no='"+bkglstrefno+"'";
							pstmt=con.prepareStatement(deleteSql);
							pstmt.executeUpdate();
							if( !(patInstructionsList.isEmpty())){
							String patInsSql ="insert into ip_bkg_pat_instructions(facility_id, bkg_ref_no, instruction_id, instruction_desc, display_order, added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
							
							pstmt=con.prepareStatement(patInsSql);
							
							int recCount=patInstructionsList.size();
							
							int executableCount=0;
							
							for(int cnt=0;cnt<recCount;cnt++){
							
								String instId="";
								
								String instDesc="";
								String checkYN="";
								String mapValue=(String)patInstructionsList.get(cnt);
								
							
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
								pstmt.executeBatch();
								//int resPT=resultArr.length;
								}
							}
							}
						}						
						else 
						{
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal = ((String) message.get("message"));
							message.clear();
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_BOOKING_LIST");
							cancommit = false;
						}
						if(pstmt!=null)pstmt.close();
						
						
					}
					catch ( Exception e )
					{
						sb.append(" Update IP_booking_list1"+e.toString()); 
						
						e.printStackTrace();
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


		
				if(cancommit)
				{
					try 
					{
						/*Monday, January 24, 2011 , issue 1 SRR20056-SCF-6436 [IN:025877]*/
						String bed_bkg_ref_no = "";
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

						sbSql.append("SELECT bed_booking_ref_no ");
						sbSql.append("FROM IP_BED_BOOKING ");
						sbSql.append("WHERE FACILITY_ID = '"+facilityId+"'" );
						sbSql.append("AND REQ_NURSING_UNIT_CODE = '"+nursingunitcode+"' AND REQ_BED_NO = '"+bedno+"' ");
						sbSql.append("AND BOOKING_STATUS='0' AND SYSDATE BETWEEN BLOCKED_FROM_DATE_TIME AND BLOCKED_UNTIL_DATE_TIME ");
						sbSql.append("AND Booking_type = 'B' ");
						sbSql.append("AND ENCOUNTER_ID IS NULL ");
						pstmt = con.prepareStatement(sbSql.toString());
						rset = pstmt.executeQuery();
						if(rset.next())
						{
							bed_bkg_ref_no = rset.getString("bed_booking_ref_no");
							if(bed_bkg_ref_no == null) bed_bkg_ref_no = "";
						}
						if(pstmt!=null)pstmt.close();
						if(rset!=null)rset.close();
						if(!bed_bkg_ref_no.equals(""))
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("UPDATE IP_BED_BOOKING ");
							sbSql.append("SET BOOKING_STATUS='4', MODIFIED_BY_ID = ?, ");
							sbSql.append("MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, ");
							sbSql.append("MODIFIED_FACILITY_ID = ? ");
							sbSql.append("WHERE FACILITY_ID= ? AND BED_BOOKING_REF_NO = ? ");
							sbSql.append("and Booking_type = 'B' ");
							sbSql.append("AND ENCOUNTER_ID IS NULL ");
							pstmt= con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, addedById ) ;
							pstmt.setString	( 2, addedAtWorkstation ) ;
							pstmt.setString	( 3, facilityId ) ;
							pstmt.setString	( 4, facilityId ) ;
							pstmt.setString	( 5, bed_bkg_ref_no ) ;

							int res71 = pstmt.executeUpdate();
							if(res71>0)  
								cancommit = true; 
							if(pstmt!=null)pstmt.close();
						}
						/**/
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

						sbSql.append("SELECT Count(*) No_Of_Record FROM IP_BED_BOOKING ");
						sbSql.append(" WHERE facility_id = '"+facilityId+"'" );
						sbSql.append(" AND   bed_booking_ref_no ='"+bkglstrefno+"'");
						sbSql.append(" AND booking_type = 'L'");

						pstmt = con.prepareStatement(sbSql.toString());
						rset = pstmt.executeQuery();
						if(rset.next())
						{
							No_Of_Record = rset.getInt("No_Of_Record");
						}

						
						if(pstmt!=null)pstmt.close();
						if(rset!=null)rset.close();
 
						if(No_Of_Record>0)
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

							sbSql.append(" UPDATE IP_BED_BOOKING  SET  ");
							sbSql.append(" patient_id 	= ? ,");
							sbSql.append(" booked_by_id  = ? , ");
							sbSql.append(" booking_status      =	'"+booking_status+"' ,  ");//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
							sbSql.append(" added_by_id = ? ,");
							sbSql.append(" added_date =sysdate,");
							sbSql.append(" added_facility_id = ?,	 ");
							sbSql.append(" added_at_ws_no = ?, " );
							sbSql.append(" modified_by_id =? ,");
							sbSql.append(" modified_date =sysdate,");
							sbSql.append(" modified_facility_id =?,");
							sbSql.append(" modified_at_ws_no = ?," );
							sbSql.append(" blocked_from_date_time = to_date('"+preferreddate_from+"','dd/mm/rrrr hh24:mi'),	 ");
							sbSql.append(" booking_date_time   = sysdate,	 ");
							sbSql.append(" blocked_until_date_time  = to_date('"+preferreddate_to+"','dd/mm/rrrr hh24:mi') ");
							sbSql.append(" WHERE facility_id = ? " );
							sbSql.append(" AND   bed_booking_ref_no =? ");
							sbSql.append(" AND booking_type = 'L'");

							
							pstmt= con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, patientid ) ;
							pstmt.setString	( 2, addedById ) ;
							pstmt.setString	( 3, addedById ) ;
							pstmt.setString	( 4, facilityId ) ;
							pstmt.setString	( 5, addedAtWorkstation ) ;
							pstmt.setString	( 6, addedById ) ;
							pstmt.setString	( 7, facilityId ) ;
							pstmt.setString	( 8, addedAtWorkstation ) ;
							pstmt.setString	( 9, facilityId ) ;
							pstmt.setString	( 10, bkglstrefno ) ;

					
							int res7 = pstmt.executeUpdate();
						

							if(res7>0)  
								cancommit = true; 
							else 
							{
								java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
								String msgVal = ((String) message.get("message"));
								message.clear();
								msgVal = msgVal.substring(0,msgVal.length()-4);
								sb.append(msgVal+" IP_BED_BOOKING");
								cancommit = false;
							}
							if(pstmt!=null)pstmt.close();
						}

						
					}catch ( Exception e )
					{	
						sb.append("Update	IP_bed_booking1"+e.toString()); 
						
						e.printStackTrace();
						
					}
				}

					
					/** Modified from here */
					/*
					if(((!oldbedno.equals("")) && (!oldnursingunit.equals(""))) && cancommit)
					{
						try
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append(" UPDATE IP_BED_BOOKING  SET  ");
							sbSql.append(" patient_id 	= ? ,");
							sbSql.append(" booked_by_id  = ? , ");
							sbSql.append(" req_nursing_unit_code = ?,");
							sbSql.append(" req_bed_no   	= ? ,");
							sbSql.append(" req_room_no  	= ? ,");
							sbSql.append(" req_bed_class_code  = ? ,");
							sbSql.append(" req_bed_type_code   = ? ,");
							sbSql.append(" daily_rate          = ? ,");
							sbSql.append(" req_practitioner_id = ? ,");
							sbSql.append(" req_specialty_code  = ? ,");
							sbSql.append(" override_yn         = ? ,");
							sbSql.append(" booking_status      =	'0' ,  ");
							sbSql.append(" added_by_id = ? ,");
							sbSql.append(" added_date =sysdate,");
							sbSql.append(" added_facility_id = ?,	 ");
							sbSql.append(" added_at_ws_no = ?, " );
							sbSql.append(" modified_by_id =? ,");
							sbSql.append(" modified_date =sysdate,");
							sbSql.append(" modified_facility_id =?,");
							sbSql.append(" modified_at_ws_no = ?," );
							sbSql.append(" blocked_from_date_time = to_date('"+preferreddate_from+"','dd/mm/rrrr hh24:mi'),	 ");
							sbSql.append(" booking_date_time   = sysdate,	 ");
							sbSql.append(" blocked_until_date_time  = to_date('"+preferreddate_to+"','dd/mm/rrrr hh24:mi') ");
							sbSql.append(" WHERE facility_id = ? " );
							sbSql.append(" AND   bed_booking_ref_no =? ");
							sbSql.append(" AND booking_type = 'L'");
							pstmt= con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, patientid ) ;
							pstmt.setString	( 2, addedById ) ;
							pstmt.setString	( 3, nursingunitcode ) ;
							pstmt.setString	( 4, bedno ) ;
							pstmt.setString	( 5, roomno ) ;
							pstmt.setString	( 6, bedclasscode ) ;
							pstmt.setString	( 7, bedtypecode ) ;
							pstmt.setString	( 8, dlycharge ) ;
							pstmt.setString	( 9, practitionerid ) ;
							pstmt.setString	( 10, specilitycode ) ;
							pstmt.setString	( 11, overrideyn ) ;
							pstmt.setString	( 12, addedById ) ;
							pstmt.setString	( 13, facilityId ) ;
							pstmt.setString	( 14, addedAtWorkstation ) ;
							pstmt.setString	( 15, addedById ) ;
							pstmt.setString	( 16, facilityId ) ;
							pstmt.setString	( 17, addedAtWorkstation ) ;
							pstmt.setString	( 18, facilityId ) ;
							pstmt.setString	( 19, bkglstrefno ) ;

							int res7 = pstmt.executeUpdate();
							if(res7>0)  
								cancommit = true; 
							else 
							{
								java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
								String msgVal = ((String) message.get("message"));
								message.clear();
								msgVal = msgVal.substring(0,msgVal.length()-4);
								sb.append(msgVal+" IP_BED_BOOKING");
								cancommit = false;
							}
							if(pstmt!=null)pstmt.close();
						}catch ( Exception e )
						{	
							sb.append("Update	IP_bed_booking1"+e.toString()); 
						}
					}
					else if (oldbedno.equals("")  && !nursingunitcode.equals("") && !bedno.equals("") && cancommit)
					{
						try
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append( " Insert into IP_BED_BOOKING (  ");
							sbSql.append(" facility_id			,");
							sbSql.append(" booking_type			,");
							sbSql.append(" bed_booking_ref_no	,");
							sbSql.append(" patient_id			,");
							sbSql.append(" booked_by_id			,");
							sbSql.append(" req_nursing_unit_code,");
							sbSql.append(" req_bed_no			,");
							sbSql.append(" req_room_no			,");
							sbSql.append(" req_bed_class_code	,");
							sbSql.append(" req_bed_type_code    ,");
							sbSql.append(" daily_rate           ,");
							sbSql.append(" req_practitioner_id  ,");
							sbSql.append(" req_specialty_code   ,");
							sbSql.append(" override_yn			,");
							sbSql.append(" booking_status		,");
							sbSql.append(" added_by_id			,");
							sbSql.append(" added_date			,");
							sbSql.append(" added_at_ws_no		,");
							sbSql.append(" added_facility_id	,");
							sbSql.append(" modified_by_id		,");
							sbSql.append(" modified_date		,");
							sbSql.append(" modified_at_ws_no	,");
							sbSql.append(" modified_facility_id	,");
							sbSql.append(" blocked_from_date_time	,");
							sbSql.append(" booking_date_time		,");
							sbSql.append(" blocked_until_date_time	,");
							sbSql.append(" ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,to_date('"+preferreddate_from+"','dd/mm/rrrr hh24:mi'), sysdate , to_date(?,'dd/mm/rrrr hh24:mi'), ? ) ");

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
							pstmt.setString	( 15, "0" ) ;	
							pstmt.setString	( 16, addedById);
							pstmt.setDate	( 17, added_date ) ;
							pstmt.setString	( 18, addedAtWorkstation ) ;
							pstmt.setString	( 19, facilityId ) ;
							pstmt.setString	( 20, addedById ) ;
							pstmt.setDate	( 21, added_date ) ;
							pstmt.setString	( 22, addedAtWorkstation ) ;
							pstmt.setString	( 23, facilityId ) ;
							pstmt.setString	( 24, preferreddate_to ) ;

							int res1 = pstmt.executeUpdate() ;
							if(res1 >0) 
								cancommit = true; 
							else 
							{
								java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
								String msgVal = ((String) message.get("message"));
								message.clear();
								msgVal = msgVal.substring(0,msgVal.length()-4);
								sb.append(msgVal+" IP_BED_BOOKING_table");
								cancommit = false;
							}
							if(pstmt!=null)pstmt.close();
						}catch ( Exception e )
						{	
							sb.append("Inserting IP_bed_booking11"+e.toString()); 
						}
					}
					*/
/*end here */	
	
/*****************************************
					if (  (!oldbedno.equals("")  && bedno.equals(""))  )
					{
						if(cancommit)
						{
							try
							{
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" UPDATE ip_bed_booking SET booking_status = '9' ");
								sbSql.append("	WHERE  bed_booking_ref_no 	= ?    ");  
								sbSql.append(" AND facility_id = ? " );
								sbSql.append(" AND booking_type = 'L' ");
								
								
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString	( 1, bkglstrefno ) ;
								pstmt.setString	( 2, facilityId ) ;
						
								int res9 = pstmt.executeUpdate();
								
								if(res9>0) cancommit = true; 
								else 			
								{
									java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
									String msgVal = ((String) message.get("message"));
									message.clear();
									msgVal = msgVal.substring(0,msgVal.length()-4);
									sb.append(msgVal+" IP_BED_BOOKING");
									cancommit = false;
								}
								if(pstmt!=null)pstmt.close();
								sqls.append("VAl6"+res9);
								
					
							}
							catch ( Exception e ){	sb.append("Update IP_bed_booking6"+e.toString());
							 
								
							}
						}
					}
*****************************************/
				}
				//if(!bedno.equals("") && cancommit){
				if(cancommit){
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("select 1 from IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' AND   bed_booking_ref_no ='"+bkglstrefno+"' AND booking_type = 'L'");
					
					Stmt = con.createStatement();
					rset = Stmt.executeQuery(sbSql.toString());

					String strBedExist = "";
					if (rset.next())
						strBedExist = "1";

					rset.close();
					Stmt.close();

					if(!bedno.equals("") && !strBedExist.equals("1")){ // if no record then, insert
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Insert into IP_BED_BOOKING (  ");
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
						pstmt.setString	( 15, booking_status ) ;//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
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
						int insertRes = pstmt.executeUpdate() ;
						pstmt.close();

						if(insertRes > 0) 
						{
							cancommit = true; 
							result		= true;
						}
						else
						{
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
							String msgVal				= ((String) message.get("message"));
							msgVal						= msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_BED_BOOKING");
							cancommit	= false;
							result		= false;
							message.clear();
						}
						if(pstmt != null) pstmt.close();
					}else if(!bedno.equals("") && strBedExist.equals("1")){// if record exists, then update
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" UPDATE IP_BED_BOOKING  SET  ");
						sbSql.append(" patient_id 	= '"+patientid+"' ,");
						sbSql.append(" req_nursing_unit_code 	= '"+nursingunitcode+"' ,");
						sbSql.append(" req_service_code 	= '"+service_code+"' ,");
						sbSql.append(" req_bed_no 	= '"+bedno+"' ,");
						sbSql.append(" req_room_no 	= '"+roomno+"' ,");
						sbSql.append(" req_bed_class_code 	= '"+bedclasscode+"' ,");
						sbSql.append(" req_bed_type_code 	= '"+bedtypecode+"' ,");
				//		sbSql.append(" req_practitioner_id 	= '"+patientid+"' ,");
				//		sbSql.append(" req_specialty_code 	= '"+patientid+"' ,");
						sbSql.append(" override_yn 	= '"+overrideyn+"' ,");
						sbSql.append(" booked_by_id  = '"+addedById+"' , ");
						sbSql.append(" booking_status = '"+booking_status+"', ");//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
						sbSql.append(" modified_by_id = '"+addedById+"', ");
						sbSql.append(" modified_date = sysdate, ");
						sbSql.append(" modified_facility_id = '"+facilityId+"' , ");
						sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"' " );
						sbSql.append(" WHERE ");
						sbSql.append(" facility_id = '"+facilityId+"' " );
						sbSql.append(" AND bed_booking_ref_no = '"+bkglstrefno+"' ");
						sbSql.append(" AND booking_type = 'L' ");

						pstmt = con.prepareStatement(sbSql.toString());
						int updateRes = pstmt.executeUpdate();

						if(updateRes > 0)  
							cancommit = true; 
						else 
						{
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal = ((String) message.get("message"));
							message.clear();
							msgVal = msgVal.substring(0,msgVal.length()-4);
							sb.append(msgVal+" IP_BED_BOOKING");
							cancommit = false;
						}
						if(pstmt!=null)pstmt.close();
					}else if(bedno.equals("") && strBedExist.equals("1")){//bed no is blank from booking in revise booking.
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append("delete from IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' AND   bed_booking_ref_no ='"+bkglstrefno+"' AND booking_type = 'L'");
						pstmt = con.prepareStatement(sbSql.toString());
						int updateRes = pstmt.executeUpdate();
						if(updateRes > 0){  
							cancommit = true;
						}else{
							sb.append("Delet failed");
							cancommit = false;
						}
						if(pstmt!=null)pstmt.close();
					}
				}
				//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
				//Starts
				try 
					{
					if(cancommit && smartCardFunc.equals("01") && !biometric_reason.equals(""))
						{
						String status=eCommon.Common.CommonBean.insertReasonforBiometric(con,facilityId,"IP_REVISE_BOOKING",patientid,bkglstrefno,nursingunitcode,biometric_reason,addedAtWorkstation,addedById);
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

				if (cancommit)
				{
					con.commit();
					result=true;
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				else
				{
					con.rollback();
					result=false;
					/*Wednesday, December 09, 2009 17023*/
					//sb.append("Transaction Failed");
				}
			}
			catch(Exception e)
			{
				sb.append(e.toString());
				e.printStackTrace();
				try{
					result=false;
					con.rollback();
					e.printStackTrace();
					sb.append(e.toString() +sqls.toString());
				   }
				catch ( Exception e1 ){	sb.append(e.toString());	}
			}
			finally
			{
				try
				{
					if(rs20!=null)  rs20.close();
					if(rset!=null)  rset.close();
					if(pstmt!=null) pstmt.close();
					if(Stmt!=null)  Stmt.close();
				}
				catch(Exception ex) {}
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}
		}
		try{
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "overrideMessage", sb1.toString() ) ;
		results.put( "sqlstmts", sqls.toString() ) ;
		
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(con != null)      ConnectionManager.returnConnection(con,p);
		}
	  	return results;
	}//E.O.Method

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}// E.O.Class
