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

package eIP.IPAdmitPatient; 

import java.rmi.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.sql.* ;
import javax.ejb.* ;
import blipin.*;
import webbeans.eCommon.*;
import java.util.*;// changed for Package Billing
import eCommon.Common.*;
/** 
*
* @ejb.bean
*	name="IPAdmitPatient"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPAdmitPatient"
*	local-jndi-name="IPAdmitPatient"
*	impl-class-name="eIP.IPAdmitPatient.IPAdmitPatientManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPAdmitPatient.IPAdmitPatientLocal"
*	remote-class="eIP.IPAdmitPatient.IPAdmitPatientRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPAdmitPatient.IPAdmitPatientLocalHome"
*	remote-class="eIP.IPAdmitPatient.IPAdmitPatientHome"
*	generate= "local,remote"
*
*
*/
public class IPAdmitPatientManager implements SessionBean
{

	java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "yyyy-MM-dd" );
	SessionContext ctx;
	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}
	
	/**
		This method is used to insert a record (info abt admitted patient)
		@version - V3
		@param1 - java.util.Properties
		@param2 - java.util.HashMap
		@return - java.util.HashMap
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap insertIPAdmitPatient(java.util.Properties p,java.util.HashMap hashData) 
	{
			Connection		  con		= null;
			PreparedStatement pstmt		= null;
			PreparedStatement pstmt1	= null;
			PreparedStatement pst		= null;
			ResultSet		  rset		= null;
			ResultSet		  rset1		= null;
			ResultSet		  srs		= null;
			CallableStatement cstmt		= null;
			
        /*Below line added for this SCF ML-MMOH-SCF-0827*/     
		//String bookingdatetime="";  //Commented for checkstyle
		ResultSet rs1 = null;
        int bookingCount=0;	
        int recCount =0; 
        String updateyn="N";	
        String newbookingdatetime=""; 		
		//End this SCF ML-MMOH-SCF-0827
		
        //Below added by Suji Keerthi for ML-MMOH-SCF-1580
		String get_date = "";
		String[] newstr1;
		String time="";
		String admdate="";
        //Ended by Suji Keerthi for ML-MMOH-SCF-1580

		String roomtype					= "";
		String ext_num					= "";
		String nursingunittype			= "";
		String patientgender			= "";
		String blocked_until_date_time  = "";
		int P_TOT_DEP_AMT				= 0;
		int dailycharge					= 0;
		int P_PACKAGE_BILL_DOC_NUM		= 0;
		//int P_APPROVED_AMT				= 0;
		//int P_APPROVED_DAYS				= 0;
		int P_VISIT_ID					= 0;
		int bed_srlno					= 0;
		Hashtable message				= new java.util.Hashtable();
		String facilityId				= (String)hashData.get("facilityId");
		String locale					= (String)hashData.get("locale");
		String p_hosp_main				= (String)hashData.get("p_hosp_main");
		String p_hosp_sub				= (String)hashData.get("p_hosp_sub");
		String p_card_id				= (String)hashData.get("p_card_id");
		String p_expiry_date			= (String)hashData.get("p_expiry_date");
		String p_privl_type_code		= (String)hashData.get("p_privl_type_code");
		String bookingrefno				= (String)hashData.get("bookingrefno");
		String patientid				= "";
		patientid						= (String)hashData.get("patientid");
		String eid						= (String)hashData.get("encounterid");
		String sourcetype				= (String)hashData.get("sourcetype");
		String source					= (String)hashData.get("source");
		String refpractitioner			= (String)hashData.get("refpractitioner");
		String admissiondate			= (String)hashData.get("admissiondate");
		String admissiontype			= (String)hashData.get("admissiontype");
		String circumstanceofinjury		= (String)hashData.get("circumstanceofinjury");
		String chiefcomplaint			= (String)hashData.get("chiefcomplaint");
		String otdatetime				= (String)hashData.get("otdatetime");
		String admt_practitioner		= (String)hashData.get("practitioner");
		String speciality				= (String)hashData.get("speciality");
		String medicalteam				= (String)hashData.get("team_id");
		String patienttype				= (String)hashData.get("patienttype");
		String bedclass					= (String)hashData.get("bedclass");
		String bedtype					= (String)hashData.get("bedtype");
		String modified_bed_type		= (String)hashData.get("modified_bed_type");
		String nursingunit				= (String)hashData.get("nursingunit");
		String service					= (String)hashData.get("service");
		String sub_service				= (String)hashData.get("sub_service");
		String bedno					= (String)hashData.get("bedno");
		String roomno					= (String)hashData.get("roomno");

		String booking_bed_no					= (String)hashData.get("booking_bed_no");/*Added for PMG2016-CRF-0002 IN061508 on 29-Aug-16*/

		/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start*/
		String bl_adm_remarks		= (String)hashData.get("bl_adm_remarks");
		String bl_bed_request		= (String)hashData.get("bl_bed_request");
		String bl_bed_type_code		= (String)hashData.get("bl_bed_type_code");
		/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End*/

		if(roomno.equals("") || roomno == null) 
			roomno = "";
		String str_dailycharge			= (String)hashData.get("dailycharge");
		String ambulatorystatus			= (String)hashData.get("ambulatorystatus");
		String modeofarrival			= (String)hashData.get("modeofarrival");
		String name						= (String)hashData.get("name");
		String address1					= (String)hashData.get("address1");
		String address2					= (String)hashData.get("address2");
		String address3					= (String)hashData.get("address3");
		String address4					= (String)hashData.get("address4");
		String postalcode				= (String)hashData.get("postalcode");
		String telno					= (String)hashData.get("telno");
		String mvregnno					= (String)hashData.get("mvregnno");
		String emergencydetail			= (String)hashData.get("emergencydetail");
		String admtypeind				= (String)hashData.get("admtypeind");
		String ancillaryyn				= (String)hashData.get("ancillaryyn");
		String patientclass				= (String)hashData.get("patientclass");
		String refpractitionername		= (String)hashData.get("refpractitionername");
		String addedAtWorkstation		= (String)hashData.get("client_ip_address");
		String billing_interfaced		= (String)hashData.get("billing_interfaced");
		String continue_as_mlc_yn		= (String)hashData.get("continue_as_mlc_yn");
		String isBlInstalled			= (String)hashData.get("isBlInstalled");
		String P_MODE					= "I"; 
		String P_PATIENT_ID				= (String)hashData.get("patientid");
		String P_BLNG_GRP_ID			= (String)hashData.get("billing_group");
		
		//Below line added for this CRF GDOH-CRF-0129
		String referral_toid="";
		Boolean isReferral =false;
		String assigncare_loctype_ind = (String)hashData.get("assigncare_loctype_ind");
		String assigncare_locacode = (String)hashData.get("assigncare_locacode");
		//End GDOH-CRF-0129

		String form60_YN= (String) hashData.get("form60_YN"); //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
		
/*
		String P_BLNG_CLASS_CODE		= (String)hashData.get("billing_class");
		String P_EMPLOYER_CODE			= (String)hashData.get("employer_code");
		String P_SETTLEMENT_IND			= (String)hashData.get("setlmt_ind");
		String credit_doc_date			= (String)hashData.get("credit_doc_date");
		String P_CUST_CODE				= (String)hashData.get("cust_code");
		String P_SLMT_TYPE_CODE			= (String)hashData.get("slmt_type_code");
		String P_SLMT_DOC_REF_DESC		= (String)hashData.get("slmt_doc_ref_desc");
		String slmt_doc_ref_date		= (String)hashData.get("slmt_doc_ref_date");
		String P_SLMT_DOC_REMARKS		= (String)hashData.get("slmt_doc_remarks");
		String P_REMARKS				= (String)hashData.get("remarks");
		String user_id					= (String)hashData.get("user_id");// MOD#	Added new variable
		String P_POLICY_TYPE_CODE		= (String)hashData.get("policy_type");
		String P_POLICY_NUMBER			= (String)hashData.get("policy_no");
		String policy_expiry_date		= (String)hashData.get("policy_expiry_date");
		String P_NON_INS_BLNG_GRP_ID	= (String)hashData.get("non_insur_blng_grp");
		String P_NON_INS_CUST_CODE		= (String)hashData.get("cust_4");
*/
		String P_EPISODE_TYPE			= (String)hashData.get("episodetype");
		String P_PACKAGE_BILL_DOC_TYPE	= (String)hashData.get("pkg_bill_type");
		String str_P_PACKAGE_BILL_DOC_NUM= (String)hashData.get("pkg_bill_no");
/*
		String P_CREDIT_AUTH_REF		= (String)hashData.get("credit_auth_ref");
		String credit_auth_date			= (String)hashData.get("credit_auth_date");
		String eff_frm_date				= (String)hashData.get("eff_frm_date");
		String str_P_APPROVED_AMT		= (String)hashData.get("app_amount");
		String str_P_APPROVED_DAYS		= (String)hashData.get("app_days");
*/
		String P_EPISODE_STATUS			= (String)hashData.get("episodestatus");
		String str_P_VISIT_ID			= (String)hashData.get("visitid");
		String P_ADM_DOCTOR				= (String)hashData.get("practitioner");
		String insTrackDtlsExists		= (String)hashData.get("insTrackDtlsExists");
		String expecteddischargedate	= (String)hashData.get("expecteddischargedate");
		String referralid				= (String)hashData.get("referralid");
/*
		String upd_fin_dtls				= (String)hashData.get("upd_fin_dtls");
		String annual_income			= (String)hashData.get("annual_income");
		String family_asset				= (String)hashData.get("family_asset");
		String no_of_dependants			= (String)hashData.get("no_of_dependants");
		String resp_for_payment			= (String)hashData.get("resp_for_payment");
*/
		String contact_details			= (String)hashData.get("contact_details");
		String res_tel_no				= (String)hashData.get("res_tel_no");
		String oth_contact_no			= (String)hashData.get("oth_contact_no");
		String email_id					= (String)hashData.get("email_id");
		String postal_code				= (String)hashData.get("postal_code");
		String country_code				= (String)hashData.get("country_code");
		String res_addr_line1			= (String)hashData.get("res_addr_line1");
		String res_addr_line2			= (String)hashData.get("res_addr_line2");
		String res_addr_line3			= (String)hashData.get("res_addr_line3");
		String res_addr_line4			= (String)hashData.get("res_addr_line4");
		String res_town_code			= (String)hashData.get("res_town_code");
		String res_area_code			= (String)hashData.get("res_area_code");
		String res_region_code			= (String)hashData.get("res_region_code");
		String mail_addr_line1			= (String)hashData.get("mail_addr_line1");
		String mail_addr_line2			= (String)hashData.get("mail_addr_line2");
		String mail_addr_line3			= (String)hashData.get("mail_addr_line3");
		String mail_addr_line4			= (String)hashData.get("mail_addr_line4");
		String mail_town_code			= (String)hashData.get("mail_town_code");
		String mail_area_code			= (String)hashData.get("mail_area_code");
		String mail_region_code			= (String)hashData.get("mail_region_code");
		String mail_postal_code			= (String)hashData.get("mail_postal_code");
		String mail_country_code		= (String)hashData.get("mail_country_code");
		String upt_contact_dtls_oa_yn   =(String)hashData.get("upt_contact_dtls_oa_yn");
		
		//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
		String admission_form_codes		= checkForNull((String)hashData.get("admission_form_codes"));

		String admission_approval_details		= checkForNull((String)hashData.get("admission_approval_details")); //Added by Suji Keerthi for MMS-DM-CRF-0191 US001

/*
		String cred_st_dt				= (String)hashData.get("cred_st_dt");
		String gl_holder_name			= (String)hashData.get("gl_holder_name");
		String gl_holder_reln			= (String)hashData.get("gl_holder_reln");
*/
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
		String attd_practitioner		= (String)hashData.get("attd_practitioner");
		String bkg_type					= (String)hashData.get("bkg_type");
		String pat_check_in_allowed_yn  = (String)hashData.get("pat_check_in_allowed_yn");
		String confirm_flag			    = (String)hashData.get("confirm_flag");
		String baby_flag				= (String)hashData.get("baby_flag");	
		String pseudo_bed_yn			= (String)hashData.get("pseudo_bed_yn");	
		String dcliniccode				= "";
		String new_bedno				= "";
		if(bkg_type.equals("D"))
		dcliniccode=(String)hashData.get("d_clinic_code");
		String adt_status = "";
		String admission_type			= (String)hashData.get("admissiontype");
		String nursing_unit_code		= (String)hashData.get("nursingunit");
		String apptcaseyn				= "N";
		String bookingcaseyn			= "N";
		String appt_ref_no				= "";
		String blocked_bed_no			= "";
		String blocked_yn				= (String)hashData.get("blocked_yn");
		patientgender					= (String)hashData.get("patientgender");
		nursingunittype					= (String)hashData.get("nursingunittype");
		String patient_class			= (String)hashData.get("appl_patient_class");
		if(patient_class.equals("DC"))
		P_EPISODE_TYPE					= "D";
		
		if(pat_check_in_allowed_yn.equals("Y"))
		{
			adt_status					= "00";
			new_bedno					= bedno;
			blocked_bed_no				= bedno;
			bedno						= "";
		}
		else
			adt_status					= "01";

		String admission_remarks		= (String)hashData.get("admission_remarks");
		if(str_dailycharge.equals(""))		      dailycharge					= 0;
		if(str_P_PACKAGE_BILL_DOC_NUM.equals("")) P_PACKAGE_BILL_DOC_NUM		= 0;
//		if( str_P_APPROVED_AMT.equals(""))	      P_APPROVED_AMT				= 0;
//		if(str_P_APPROVED_DAYS.equals(""))		  P_APPROVED_DAYS				= 0;
		if(str_P_VISIT_ID.equals(""))		      P_VISIT_ID					= 0;

/*
		java.sql.Date   P_CREDIT_DOC_REF_DATE	= null;
		java.sql.Date   P_SLMT_DOC_REF_DATE		= null;
		java.sql.Date   P_POLICY_EXPIRY_DATE	= null;
		java.sql.Date   P_CREDIT_AUTH_DATE		= null;
		java.sql.Date   P_EFFECTIVE_DATE		= null;
		try
		{
			if(!(credit_doc_date.equals("")))
				P_CREDIT_DOC_REF_DATE	 = java.sql.Date.valueOf(credit_doc_date) ;

			if(!(slmt_doc_ref_date.equals("")))
				P_SLMT_DOC_REF_DATE		 = java.sql.Date.valueOf(slmt_doc_ref_date) ;

			if(!(policy_expiry_date.equals("")))
				P_POLICY_EXPIRY_DATE	= java.sql.Date.valueOf(policy_expiry_date) ;
			if(!(credit_auth_date.equals("")))
				P_CREDIT_AUTH_DATE		= java.sql.Date.valueOf(credit_auth_date) ;
	
			if(!(eff_frm_date.equals("")))
				P_EFFECTIVE_DATE		= java.sql.Date.valueOf(eff_frm_date) ;
		}
		catch(Exception ee)
		{
			
		}
*/		
		long encounterid=0;
		if(!eid.equals(""))
			encounterid			    = Long.parseLong(eid);

		HashMap		    results		= new HashMap() ;
		boolean			result		= true;
		boolean			firemsg		= false;
		boolean			isroom_no_found		= false;
		boolean			retval		= true;
		StringBuffer	messageBuffer= new StringBuffer("");
		results.put( "error", "no error" ) ;
		String addedById		 	= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String Encounter_Id			= "";
		String expected_days_of_stay= "0";
		String P_BLNG_CLASS_CODE1	= "";
		String P_BILL_TYPE_CODE		= "";
		String P_BLNG_SERV_CODE		= "";
		String strFunctionId		= "ADMISSION";
		String strBLMessage			= "";
		String strBLdeposit			= "";
		String strBLadmn_dep_coll_reqd_yn			= "";
		String str_package_amt			= "";
		String str_package_code			= "";
		String str_package_seq_num		= "";
		String package_enabled_yn		= "";	

		java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;
		int		P_DLY_CHARGE		= 0;
		int		rs					= 0;
		String ord_exist_yn			= "";

		if(retval)
		{
			try
			{
				StringBuffer sbSql = new StringBuffer();
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				
			 /*Below line added for this CRF GDOH-CRF-0129*/
			isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");
		    if(isReferral && !assigncare_loctype_ind.equals("")){
		        referral_toid = assigncare_loctype_ind+"$"+assigncare_locacode;
		    }
			//End this CRF GDOH-CRF-0129
		
				if(patientclass == null || patientclass.equals("") || admtypeind == null || admtypeind.equals(""))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("select adm_type_ind from IP_ADMISSION_TYPE where admission_type_code = '"+admissiontype+"' ");
					if(pst!=null) pst.close();
					if(srs!=null) srs.close();
					pst = con.prepareStatement(sbSql.toString());
					srs = pst.executeQuery();
					if(srs!=null && srs.next())
					{
						admtypeind = srs.getString("adm_type_ind");
					}
				}

				if (result)
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append(" select ");
					if(expecteddischargedate != null && !(expecteddischargedate.equals("")))
						sbSql.append("	ceil(to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:mi') - sysdate) exp_days_of_stay, ");
					sbSql.append(" room_type, ext_num from AM_FACILITY_ROOM where operating_facility_id = '"+facilityId+"' and room_num = '"+roomno+"' ");

					if(pst!=null) pst.close();
					if(srs!=null) srs.close();
					pst = con.prepareStatement(sbSql.toString());
					srs = pst.executeQuery();
					if(srs.next())
					{
						roomtype = srs.getString("room_type") == null ? "" : srs.getString("room_type");
						if(expecteddischargedate != null && !(expecteddischargedate.equals("")))
						{
							expected_days_of_stay	=	srs.getString("exp_days_of_stay");
								if(expected_days_of_stay == null) expected_days_of_stay ="0";
						}

						ext_num = srs.getString("ext_num") == null ? "" : srs.getString("ext_num");
					}
					/*Thursday, May 13, 2010 , update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through following procedure*/
					if(pat_check_in_allowed_yn.equals("Y") && (!new_bedno.equals("")) && result)
					{
						try
						{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append("select bed_block_period_normal, to_char((sysdate + bed_block_period_normal/24),'dd/mm/rrrr hh24:mi')  blocked_until_date_time from IP_PARAM where facility_id = '"+facilityId+"'");
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );
								rset = pstmt.executeQuery();
								if(rset.next())
								{
									blocked_until_date_time = rset.getString("blocked_until_date_time");
								}

								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
								cstmt.setString(1,facilityId);
								cstmt.setString(2,"B");
								cstmt.setString(3,"Y");
								cstmt.setString(4,addedAtWorkstation);
								cstmt.setString(5,addedById);
								cstmt.registerOutParameter(6,java.sql.Types.NUMERIC); 
								cstmt.execute();
								bed_srlno	= cstmt.getInt(6);
								/*Added by Thamizh selvi on 1st Dec 2017 against AYH-SCF-0007 Start*/
								if(bed_srlno < 1){
									message = MessageManager.getMessage( locale, "BED_BKG_SRL_CTRL_NOT_DEFINED","IP" ) ;
									messageBuffer.append( (String) message.get("message") ) ;
									result = false;
								}/*End*/
								if(cstmt != null) cstmt.close();
						}
						catch (Exception e1)
						{
							messageBuffer.append("Exception in ip_bed_booking_srl_ctrl_table" + e1.toString());
							
							result = false;
							e1.printStackTrace();
						}
					}/**/
//System.out.println("before addedAtWorkstation==>"+addedAtWorkstation+"<==patientid==>"+patientid);
					try
					{
						String errmsg="";
						String msgEncounter="N";
						if(result){
						try
						{
							cstmt=con.prepareCall("{call PR_GENERATE_ENCOUNTER_ID(?,?,?,?,?,?,?,?,?,?)}");
							cstmt.setString(1,"");
							cstmt.setString(2,"");
							cstmt.setString(3,facilityId);
							cstmt.setString(4,addedById);
							cstmt.setString(5,addedAtWorkstation);
							cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt.execute();
							errmsg=cstmt.getString(7);
							if(errmsg == null) errmsg="";
							msgEncounter=cstmt.getString(8);
							if(msgEncounter == null) msgEncounter="N";

							if(errmsg.equals(""))
							{
								if(msgEncounter.equals("Y"))
								{
									message = MessageManager.getMessage( locale, "ENC_ID_REACHED_MAX","Common" ) ;
									messageBuffer.append( (String) message.get("message") ) ;
									result = false;
								}
								else
								{
									Encounter_Id="";
									Encounter_Id=cstmt.getString(6);
									if(Encounter_Id == null) Encounter_Id="";
									result=true;
								}
							}
							else
							{
								result=false;
								messageBuffer.append(errmsg);
							}

							if(cstmt != null) cstmt.close();
						}catch(Exception e)
						{
							result=false;
							
							e.printStackTrace();
						}
						}
						
//out.println("after addedAtWorkstation==>"+addedAtWorkstation+"<==patientid==>"+patientid+"<=Encounter_Id=>"+Encounter_Id);
						if(result && !Encounter_Id.equals(""))
						{
							try
							{
								
								int isLoggedIn = 0;
								
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());

								sbSql.append(" select count(*) cnt from sm_modules_facility where MODULE_ID='OR' and FACILITY_ID='"+facilityId+"' AND OPERATIONAL_YN='Y' ");

								pstmt		=	con.prepareStatement(sbSql.toString());
								if(rset!=null) rset.close();
								rset		=	pstmt.executeQuery();

								if (rset != null && rset.next())
								{
									isLoggedIn = rset.getInt("cnt");
								}

								
								if (rset != null)
									rset.close();
								if (pstmt != null)
									pstmt.close();
								
						

								if(isLoggedIn>0)
								{
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append(" select OR_CHECK_UNBILL_ORD_EXISTS_YN(?,?,?,?) status from dual ");
									pstmt		=	con.prepareStatement(sbSql.toString());
									pstmt.setString	(1, patientid);
									pstmt.setString	(2, facilityId);
									pstmt.setString	(3, "");
									pstmt.setString	(4, "");

									if(rset!=null) rset.close();
									rset		=	pstmt.executeQuery();

									if (rset != null && rset.next())
									{
										ord_exist_yn = rset.getString("status");
									}
																		
									

									if(ord_exist_yn==null)
										ord_exist_yn = "N";

								
									if (rset != null)
										rset.close();
									if (pstmt != null)
										pstmt.close();
								}
							}
							catch (Exception e)
							{
								result = false;
								messageBuffer.append("Excepiton in checking Order Exist Function : " + e.toString());
								
								e.printStackTrace();
							}
						}

						

						
						if(!Encounter_Id.equals("")){
							encounterid = 0;
							encounterid = Long.parseLong(Encounter_Id);
						}
						if(pstmt!=null)	pstmt.close();

						// Get the booking reference no for patient id
						/*Wednesday, January 13, 2010 . IN017765 commented since booking reference number we are getting from jsp . result of this query & booking reference number from jsp are different for multiple booking case .
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						if(bkg_type.equals("I"))
						{
							sbSql.append(" select bkg_lst_ref_no from IP_BOOKING_LIST ");
							sbSql.append(" where facility_id = ? and patient_id = ? and booking_status='1' ");
							pstmt		=	con.prepareStatement(sbSql.toString());
							pstmt.setString	(1, facilityId);
							pstmt.setString	(2, patientid);
							if(rset!=null) rset.close();
							rset		=	pstmt.executeQuery();
							if(rset.next())
							{
								bookingrefno =	rset.getString("bkg_lst_ref_no");
							}
						}
		
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
						*/

						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();

						if(bkg_type.equals("D"))
						{
							apptcaseyn = "Y";
							appt_ref_no = bookingrefno;
							bookingrefno ="";
						}
						else if(bkg_type.equals("I"))
						{
							bookingcaseyn = "Y";
						}

						//Below added by Suji Keerthi for ML-MMOH-SCF-1580								
								get_date = admissiondate;
								newstr1 = get_date.split(" ");
								time = newstr1[1];
								if(time.equals("00:00"))
									time="00:01";
								admdate=newstr1[0]+" "+time;
                        //Ended by Suji Keerthi for ML-MMOH-SCF-1580
						try
						{

							if(result)
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								
								//Below line modified for this CRF GDOH-CRF-0129
								//Modified by Sangeetha for KDAH-CRF-0347 on 14/apr/17	
								//Modified by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
								//Below Modified by Suji Keerthi for MMS-DM-CRF-0191 US001
								sbSql.append(" insert into PR_ENCOUNTER ");
								sbSql.append(" ( facility_id, encounter_id, patient_id, visit_adm_date_time, visit_adm_type, visit_adm_type_ind, assign_care_locn_type, assign_care_locn_code, assign_room_type, assign_room_num, assign_bed_num, attend_practitioner_id, booking_ref_no, ancillary_yn, specialty_code, patient_type, ambulatory_status, chief_complaint, adt_status, adt_status_set_on_date, adt_status_set_by_user, adt_status_set_reason, added_by_id,added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, visit_adm_type_facility_id, circumstance_of_injury_code, admit_practitioner_id, referral_id, service_code, subservice_code, episode_id, assign_bed_class_code, team_id, patient_class, pat_curr_locn_type, pat_curr_locn_code, pat_trn_time, assign_bed_type_code, booking_case_yn, appt_case_yn, appt_id, dc_unit_code, mlc_yn, EXP_DISCHARGE_DATE_TIME, HOSP_MAIN, HOSP_SUB, CARD_ID, EXPIRY_DATE, PRIVL_TYPE_CODE, ROOM_TEL_EXT_NUM,admission_remarks,referred_locn_code,form60_YN,admission_form_codes,admission_approval_details");
								if(pat_check_in_allowed_yn.equals("N") && !bedno.equals("") )
									sbSql.append(" ,mark_arrival_date_time,bed_allocation_date_time ");
								/*else
									sbSql.append(" mark_arrival_date_time )");*/
									sbSql.append(" )");
								//Modified By Dharma on 27th Feb 2018 against GHL-SCF-1308 [IN:066818]	
								
                                  								
									
								sbSql.append(" VALUES ( '"+facilityId+"', '"+encounterid+"', '"+patientid+"', to_date('"+admdate+"','dd/mm/rrrr hh24:MI'), '"+admissiontype+"', '"+admtypeind+"', '"+nursingunittype+"', '"+nursingunit+"', '"+roomtype+"', '"+roomno+"', '"+bedno+"', '"+attd_practitioner+"', '"+bookingrefno+"', '"+ancillaryyn+"', '"+speciality+"', '"+patienttype+"', '"+ambulatorystatus+"', '"+chiefcomplaint+"', '"+adt_status+"', sysdate, '"+addedById+"', '', '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+facilityId+"', '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+facilityId+"', '"+facilityId+"', '"+circumstanceofinjury+"', '"+admt_practitioner+"', '"+referralid+"', '"+service+"', '"+sub_service+"', '"+encounterid+"', '"+bedclass+"', '"+medicalteam+"', '"+patient_class+"', '"+nursingunittype+"', '"+nursingunit+"', sysdate, '"+bedtype+"', '"+bookingcaseyn+"', '"+apptcaseyn+"', '"+appt_ref_no+"', '"+dcliniccode+"', '"+continue_as_mlc_yn+"', to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:MI'), '"+p_hosp_main+"', '"+p_hosp_sub+"', '"+p_card_id+"', to_date('"+p_expiry_date+"','dd/mm/rrrr'), '"+p_privl_type_code+"', '"+ext_num+"','"+admission_remarks+"','"+referral_toid+"','"+form60_YN+"','"+admission_form_codes+"','"+admission_approval_details+"'");
								//Above line modified and added "referral_toid" for this CRF GDOH-CRF-0129
								//Modified form60_YN by Sangeetha for KDAH-CRF-0347 on 14/apr/17	
								if(pat_check_in_allowed_yn.equals("N") && !bedno.equals("") )
									sbSql.append(" , sysdate, to_date('"+admissiondate+"','dd/mm/rrrr hh24:MI') ");
									//sbSql.append(" , sysdate, to_date('"+admissiondate+"','dd/mm/rrrr hh24:MI') )");
								/*else
									sbSql.append(" , sysdate )");*/
								sbSql.append(" )");
								//Modified By Dharma on 27th Feb 2018 against GHL-SCF-1308 [IN:066818]	
								
							

								if(pst!=null) pst.close();
								pst   =	con.prepareStatement(sbSql.toString());
								rs     =	pst.executeUpdate();
								
								if(rs>0)
									result = true; 
								else
								{
									result = false;
									messageBuffer.append("Eror in inserting into pr_encounter");
								}
							}
						}catch(Exception e1)
						{
							String errMsg = "";
							String flag="";
							String msg ="";
							errMsg = e1.getMessage();
							if(errMsg != "")
							{
								if(errMsg.contains("PR_ENCOUNTER_PK"))
								{
									MessageManager mm = new MessageManager();
									java.util.Hashtable mesg = new Hashtable();

									mesg = mm.getMessage(locale, "CURRENTLY_IN_PATIENT", "IP") ;
									msg = ((String) mesg.get("message"));
									flag="N";
								}else
								{
									flag = "Y";
								}
							}
							if(flag.equals("N"))
							{
								messageBuffer.append(msg);
								result	= false;
							}else{
								e1.printStackTrace();
								messageBuffer.append("Exception in inserting into pr_encounter==>"+e1.toString());
								result	= false;
							 }
							
						}

						try
						{


							if(result)
							{
								//Insert into other details  into pr_encounter_other_detail
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" insert into PR_ENCOUNTER_OTHER_DETAIL ");
								sbSql.append(" (operating_facility_id,encounter_id,res_area_code,res_town_code,visit_adm_desc ");
								sbSql.append(" ,arrival_code,escort_name,escort_add_ln1,escort_add_ln2,escort_add_ln3 ");
								sbSql.append(" ,escort_add_ln4,escort_add_postal_code,escort_tel_num,escort_mv_reg_no ");
								sbSql.append(" ,emergency_detail,added_by_id,added_date,added_at_ws_no,added_facility_id ");
								sbSql.append(" ,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,exp_discharge_date_time) ");
								sbSql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/rrrr hh24:MI') ) ");
								pstmt = con.prepareStatement( sbSql.toString() );
								pstmt.setString ( 1, facilityId ) ;
								pstmt.setLong   ( 2, encounterid ) ;
								pstmt.setString ( 3, res_area_code);
								pstmt.setString ( 4, res_town_code);
								pstmt.setString ( 5, "");
								pstmt.setString ( 6, modeofarrival);
								pstmt.setString ( 7, name);
								pstmt.setString ( 8, address1);
								pstmt.setString ( 9, address2);
								pstmt.setString ( 10, address3);
								pstmt.setString ( 11, address4);
								pstmt.setString ( 12, postalcode);
								pstmt.setString ( 13, telno);
								pstmt.setString ( 14, mvregnno);
								pstmt.setString ( 15, emergencydetail);
								pstmt.setString ( 16, addedById);
								pstmt.setString ( 17, addedAtWorkstation ) ;
								pstmt.setString ( 18, facilityId ) ;
								pstmt.setString ( 19, addedById ) ;
								pstmt.setString ( 20, addedAtWorkstation ) ;
								pstmt.setString ( 21, facilityId ) ;
								pstmt.setString ( 22, expecteddischargedate ) ;
								rs = pstmt.executeUpdate();
								if(rs>0)
									result = true; 
								else
								{
									result = false;
									messageBuffer.append("Eror in inserting into pr_encounter_other_detail");
								}
							}
						}catch(Exception e1)
						{
							messageBuffer.append("Exception in inserting into pr_encounter_other_detail" + e1.toString());
							result = false;
							e1.printStackTrace();
						}

						int srlno = 1;
						String trntype = "A";
						int res = 0;
						try
						{

							if(result)
							{
								//MOD#03 Insertion into the column SURGERY_REQD_YN was removed
								//Insert admission details into ip adt trn table with daily charges
								if(billing_interfaced.equals("true"))
								{
									if(modified_bed_type.equals("") || modified_bed_type == null)
									{	
										modified_bed_type = bedtype;
									}
								}

								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());								
								int no_of_room_found = 0;

								if(!(roomno==null || roomno.equals("")))
								{
									sbSql.append("  select count(*) no_of_record from ip_nursing_unit_room where facility_id = ? and nursing_unit_code = ? and room_no = ? ");
									try
									{
										pstmt		=	con.prepareStatement(sbSql.toString());
										pstmt.setString	(1, facilityId);
										pstmt.setString	(2, nursingunit);
										pstmt.setString	(3, roomno);
										if(rset!=null) rset.close();
										rset		=	pstmt.executeQuery();
										if(rset.next())
										{
											no_of_room_found =	rset.getInt("no_of_record");
										}
										if(rset!=null) rset.close();
										if(pstmt!=null) pstmt.close();
									}
									catch (Exception e)
									{
										messageBuffer.append("Exception in getting no_of_room_found into nursing unit" + e);
										
										e.printStackTrace();
										if(rset!=null) rset.close();
										if(pstmt!=null) pstmt.close();
									}
								}

								if((no_of_room_found>0 && !(roomno==null || roomno.equals("") )) || (roomno==null || roomno.equals("")))
								{
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("  insert into IP_ADT_TRN ");
									sbSql.append(" ( facility_id, encounter_id, srl_no, patient_id, trn_type ");
									sbSql.append(" , trn_code, trn_date_time, to_nursing_unit, to_room_no, to_bed_no ");
									sbSql.append(" , to_bed_class_code, to_bed_type_code, to_daily_rate ");
									sbSql.append(" , to_practitioner_id, to_specialty_code, to_pract_team_id ");
									sbSql.append(" ,added_by_id, added_date ");
									sbSql.append(" ,added_facility_id, added_at_ws_no ");
									sbSql.append(" ,modified_by_id, modified_date ");
									sbSql.append(" ,modified_facility_id, modified_at_ws_no ");
									if(billing_interfaced.equals("true"))
										sbSql.append(" ,bill_type_code, blng_class_code, blng_serv_code ");

									sbSql.append(" ,trn_dep, expected_discharge_date, ot_date_time, to_service_code ");
									sbSql.append(" ,to_subservice_code, to_bed_type_code_by_defn, tfr_type ");
									sbSql.append(" ,patient_class, admission_date_time,PAT_HOSP_REQUEST,BED_TYPE_CODE_CHRG,REASON_REMARKS ");
									sbSql.append(" ) values ( ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? ");
									if(billing_interfaced.equals("true"))
										sbSql.append(" ,'"+P_BILL_TYPE_CODE+"', '"+P_BLNG_CLASS_CODE1+"', '"+P_BLNG_SERV_CODE+"' ");
									sbSql.append(" , ?,to_date(?,'dd/mm/rrrr hh24:MI'),to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?,?,'"+patient_class+"', to_date('"+admissiondate+"','dd/mm/rrrr hh24:MI'),'"+bl_bed_request+"','"+bl_bed_type_code+"','"+bl_adm_remarks+"' )" );

									if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement( sbSql.toString() );




								pstmt.setString ( 1, facilityId ) ;
								pstmt.setLong   ( 2, encounterid ) ;
								pstmt.setInt    ( 3, srlno ) ;

								pstmt.setString ( 4, patientid);
								pstmt.setString ( 5, trntype ) ;
								pstmt.setString ( 6, admissiontype ) ;
								pstmt.setString ( 7, admdate ) ;
								pstmt.setString ( 8, nursingunit ) ;
								pstmt.setString ( 9, roomno ) ;
								pstmt.setString ( 10, bedno ) ;
								pstmt.setString ( 11, bedclass ) ;
								pstmt.setString ( 12, modified_bed_type ) ;
								pstmt.setInt    ( 13, P_DLY_CHARGE ) ;
								pstmt.setString ( 14, admt_practitioner ) ;
								pstmt.setString ( 15, speciality ) ;
								pstmt.setString ( 16, medicalteam ) ;
								pstmt.setString ( 17, addedById);
								pstmt.setString ( 18, facilityId ) ;
								pstmt.setString ( 19, addedAtWorkstation ) ;
								pstmt.setString ( 20, addedById ) ;
								pstmt.setString ( 21, facilityId ) ;
								pstmt.setString ( 22, addedAtWorkstation ) ;
								pstmt.setInt    ( 23, P_TOT_DEP_AMT ) ;
								pstmt.setString ( 24, expecteddischargedate ) ;
								pstmt.setString ( 25, otdatetime ) ;
								pstmt.setString ( 26, service ) ;
								pstmt.setString ( 27, sub_service ) ;
								//pstmt.setString ( 28, modified_bed_type ) ;
								pstmt.setString ( 28, bedtype ) ;
								pstmt.setString ( 29, "A" );
								res = pstmt.executeUpdate();
								if(res>0) 
								{
									result = true; 
								}
								else
								{
									messageBuffer.append("Eror in inserting into ip adt trn");
									result = false;
								}


								}
								else
								{
									result = false;
									isroom_no_found = true;
								}

							}
						}catch(Exception j)
						{
							
							messageBuffer.append("Exception in inserting into ip adt trn" + j);
							result = false;
							j.printStackTrace();
						}

						try
						{
							//Modified by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779 
							//Below Modified by Suji Keerthi for MMS-DM-CRF-0191 US001
							if(result)
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" insert into IP_OPEN_ENCOUNTER ");
								sbSql.append(" ( facility_id, encounter_id, patient_id, admission_date_time, ");
								sbSql.append(" patient_class, admission_type, admission_type_ind, nursing_unit_code, ");
								sbSql.append(" added_by_id, added_date, added_facility_id, added_at_ws_no, ");
								sbSql.append(" modified_by_id, modified_date, modified_facility_id,modified_at_ws_no, ");
								sbSql.append(" referral_id, booking_case_yn, booking_ref_no, chief_complaint, admit_practitioner_id, team_id, attend_practitioner_id, ");
								sbSql.append(" specialty_code, service_code,subservice_code, room_num, bed_num, bed_class_code, bed_type_code, pat_curr_locn_type, ");
								sbSql.append(" pat_curr_locn_code, pat_trn_time, adt_status, appt_case_yn, appt_id, dc_unit_code, blocked_bed_no, exp_discharge_date_time, room_tel_ext_num,admission_remarks,admission_form_codes,admission_approval_details ");
								if(pat_check_in_allowed_yn.equals("N") && !bedno.equals("") )
									sbSql.append(", bed_allocation_date_time )");								
								else
									sbSql.append(")");
								sbSql.append(" values(?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?, ?, to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:MI'), ? , ?,?,? ");
								if(pat_check_in_allowed_yn.equals("N") && !bedno.equals("") )
									sbSql.append(" , to_date('"+admissiondate+"','dd/mm/rrrr hh24:MI') )");
								else
									sbSql.append(")");


								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );
								pstmt.setString ( 1, facilityId ) ;
								pstmt.setLong   ( 2, encounterid) ;
								pstmt.setString ( 3, patientid ) ;
								pstmt.setString ( 4, admissiondate ) ;
								pstmt.setString ( 5, patient_class ) ;
								pstmt.setString ( 6, admission_type ) ;
								pstmt.setString ( 7, admtypeind ) ;
								pstmt.setString ( 8, nursing_unit_code ) ;
								pstmt.setString ( 9, addedById);
								pstmt.setString ( 10, facilityId ) ;
								pstmt.setString ( 11, addedAtWorkstation ) ;
								pstmt.setString ( 12, addedById ) ;
								pstmt.setString ( 13, facilityId ) ;
								pstmt.setString ( 14, addedAtWorkstation ) ;
								pstmt.setString ( 15, referralid ) ;
								pstmt.setString ( 16, bookingcaseyn ) ;
								pstmt.setString ( 17, bookingrefno ) ;
								pstmt.setString ( 18, chiefcomplaint ) ;
								pstmt.setString ( 19, admt_practitioner ) ;
								pstmt.setString ( 20, medicalteam ) ;
								pstmt.setString ( 21, attd_practitioner ) ;
								pstmt.setString ( 22, speciality ) ;
								pstmt.setString ( 23, service ) ;
								pstmt.setString ( 24, sub_service ) ;
								pstmt.setString ( 25, roomno ) ;
								pstmt.setString ( 26, bedno ) ;
								pstmt.setString ( 27, bedclass ) ;
								pstmt.setString ( 28, bedtype ) ;
								pstmt.setString ( 29, nursingunittype ) ;
								pstmt.setString ( 30, nursingunit ) ;
								pstmt.setString ( 31, adt_status ) ;
								pstmt.setString ( 32, apptcaseyn );
								pstmt.setString ( 33, appt_ref_no );
								pstmt.setString ( 34, dcliniccode );
								pstmt.setString ( 35, blocked_bed_no );
								pstmt.setString ( 36, ext_num );
								pstmt.setString ( 37, admission_remarks );
								//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
								pstmt.setString ( 38, admission_form_codes );
								pstmt.setString ( 39, admission_approval_details ); //Added by Suji Keerthi for MMS-DM-CRF-0191 US001
								int res1		= 0 ;
								res1			= pstmt.executeUpdate() ;
								if(res1>0) 
									result = true; 
								else
								{
									result = false;
								}
							}
						}catch(Exception e1)
						{
							
							/*
							e1.printStackTrace();
							messageBuffer.append("Eror in inserting into ip_open_encounter==>"+e1.toString());
							result = false;
							*/
							/*Wednesday, October 20, 2010 , modified for SRR20056-SCF-5672 [IN:024552] */
							String errMsg = "";
							String flag="";
							String msg ="";
							errMsg = e1.getMessage();
							if(errMsg != "")
							{
								if(errMsg.contains("IP_OPEN_ENCOUNTER_U1"))
								{
									MessageManager mm = new MessageManager();
									java.util.Hashtable mesg = new Hashtable();

									mesg = mm.getMessage(locale, "CURRENTLY_IN_PATIENT", "IP") ;
									msg = ((String) mesg.get("message"));
									flag="N";
								}else
								{
									flag = "Y";
								}
							}
							if(flag.equals("N"))
							{
								messageBuffer.append(msg);
								result	= false;
							}else{
								e1.printStackTrace();
								messageBuffer.append("Eror in inserting into ip_open_encounter==>"+e1.toString());
								result	= false;
							 }
						}

						/*
						* Patient address details are updating into mp table through procedure
						* added by ranjani on 22-03-2004
						*/
						if(result)
						{
							try
							{
								cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('ADMISSION')}");
								cstmt.execute();
								if(cstmt!=null) cstmt.close();
							}catch(Exception exception)
							{
								result = false;
								messageBuffer.append("Exception in Procedure-MP_AUDIT_FUNCTION.ASSIGN_VALUE:"+exception.toString());
								
								exception.printStackTrace();
							}
						}


						if((result))
						{
							String cs = "0";
							try
							{

							// Update patient contact details into mp_patient and mp_pat_addresses
								//cstmt = con.prepareCall("{call MP_PAT_ADD_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								/*Monday, April 26, 2010  Patient address details are updating into mp table through new procedure*/
								cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1,  checkForNull(facilityId));
								cstmt.setLong(2, encounterid);
								cstmt.setString(3,  checkForNull(patient_class));
								cstmt.setString(4,  checkForNull(patientid));
								cstmt.setString(5,  checkForNull(res_tel_no ));
								cstmt.setString(6,  checkForNull(oth_contact_no   ));
								cstmt.setString(7,  checkForNull(res_area_code ));
								cstmt.setString(8,  checkForNull(res_town_code ));
								cstmt.setString(9,  checkForNull(res_region_code ));
								cstmt.setString(10,  checkForNull(email_id ));
								cstmt.setString(11, checkForNull(res_addr_line1 ));
								cstmt.setString(12, checkForNull(res_addr_line2 ));
								cstmt.setString(13, checkForNull(res_addr_line3 ));
								cstmt.setString(14, checkForNull(res_addr_line4 ));
								cstmt.setString(15, checkForNull(postal_code ));
								cstmt.setString(16, checkForNull(country_code ));
								cstmt.setString(17, checkForNull(mail_addr_line1 ));
								cstmt.setString(18, checkForNull(mail_addr_line2 ));
								cstmt.setString(19, checkForNull(mail_addr_line3 ));
								cstmt.setString(20, checkForNull(mail_addr_line4 ));
								cstmt.setString(21, checkForNull(mail_area_code ));
								cstmt.setString(22, checkForNull(mail_town_code ));
								cstmt.setString(23, checkForNull(mail_postal_code ));
								cstmt.setString(24, checkForNull(mail_region_code ));
								cstmt.setString(25, checkForNull(mail_country_code ));
								/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
								cstmt.setString(26, altAddrLine1 );
								cstmt.setString(27, altAddrLine2 );
								cstmt.setString(28, altAddrLine3 );
								cstmt.setString(29, altAddrLine4 );
								cstmt.setString(30, altAreaCode );
								cstmt.setString(31, altTownCode );
								cstmt.setString(32, altPostalCode );
								cstmt.setString(33, altRegionCode );
								cstmt.setString(34, altCountryCode );
								/*End*/
								cstmt.setString(35, checkForNull(addedById ));
								cstmt.setString(36, checkForNull(addedAtWorkstation ));
								cstmt.registerOutParameter(37,java.sql.Types.VARCHAR);

								cstmt.execute();
								cs = cstmt.getString(37);
		
								if(cs.equals("1"))
								{
									result = true;
							       //added changes for HSA-CRF-0226 [IN:050599]
									if(upt_contact_dtls_oa_yn.equals("Y")){
									String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+checkForNull(patientid)+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
									if(rset!=null) rset.close();
		                            if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement(appt_count);
									rset=pstmt.executeQuery();
									int apt_cnt=0;
									if(rset != null && rset.next()){
									apt_cnt=rset.getInt("apt_cnt");
									   }
									if(apt_cnt > 0){
									/*String update_app_contact_dtl=" update oa_appt set res_tel_no='"+checkForNull(res_tel_no )+"', oth_contact_no='"+checkForNull(oth_contact_no)+"',email_id='"+checkForNull(email_id )+"', res_addr_line1='"+checkForNull(res_addr_line1)+"', res_addr_line2='"+checkForNull(res_addr_line2)+"',res_addr_line3='"+checkForNull(res_addr_line3)+"', res_addr_line4='"+checkForNull(res_addr_line4)+"',postal_code='"+checkForNull(postal_code)+"',modified_date=sysdate,modified_facility_id='"+checkForNull(facilityId)+"',modified_by_id='"+checkForNull(addedById )+"', modified_at_ws_no='"+checkForNull(addedAtWorkstation )+"',RES_AREA_CODE='"+checkForNull(res_area_code )+"',RES_TOWN_CODE='"+checkForNull(res_town_code )+"',RES_REGION_CODE='"+checkForNull(res_region_code )+"',MAIL_ADDR_LINE1='"+checkForNull(mail_addr_line1)+"',MAIL_ADDR_LINE2='"+checkForNull(mail_addr_line2)+"',MAIL_ADDR_LINE3='"+checkForNull(mail_addr_line3)+"',MAIL_ADDR_LINE4='"+checkForNull(mail_addr_line4)+"',MAIL_AREA_CODE='"+checkForNull(mail_area_code )+"',MAIL_TOWN_CODE='"+checkForNull(mail_town_code )+"',MAIL_REGION_CODE='"+checkForNull(mail_region_code )+"',MAIL_POSTAL_CODE='"+checkForNull(mail_postal_code )+"',MAIL_COUNTRY_CODE='"+checkForNull(mail_country_code )+"',RES_COUNTRY_CODE='"+checkForNull(country_code )+"' where patient_id='"+checkForNull(patientid)+"' and APPT_DATE>= to_date(sysdate,'DD MM YY') ";*/
									
									String update_app_contact_dtl=" update oa_appt set res_tel_no='"+checkForNull(res_tel_no )+"', oth_contact_no='"+checkForNull(oth_contact_no)+"',email_id='"+checkForNull(email_id )+"', res_addr_line1='"+checkForNull(res_addr_line1).replaceAll("'","''")+"', res_addr_line2='"+checkForNull(res_addr_line2).replaceAll("'","''")+"',res_addr_line3='"+checkForNull(res_addr_line3).replaceAll("'","''")+"', res_addr_line4='"+checkForNull(res_addr_line4).replaceAll("'","''")+"',postal_code='"+checkForNull(postal_code)+"',modified_date=sysdate,modified_facility_id='"+checkForNull(facilityId)+"',modified_by_id='"+checkForNull(addedById )+"', modified_at_ws_no='"+checkForNull(addedAtWorkstation )+"',RES_AREA_CODE='"+checkForNull(res_area_code )+"',RES_TOWN_CODE='"+checkForNull(res_town_code )+"',RES_REGION_CODE='"+checkForNull(res_region_code )+"',MAIL_ADDR_LINE1='"+checkForNull(mail_addr_line1).replaceAll("'","''")+"',MAIL_ADDR_LINE2='"+checkForNull(mail_addr_line2).replaceAll("'","''")+"',MAIL_ADDR_LINE3='"+checkForNull(mail_addr_line3).replaceAll("'","''")+"',MAIL_ADDR_LINE4='"+checkForNull(mail_addr_line4).replaceAll("'","''")+"',MAIL_AREA_CODE='"+checkForNull(mail_area_code )+"',MAIL_TOWN_CODE='"+checkForNull(mail_town_code )+"',MAIL_REGION_CODE='"+checkForNull(mail_region_code )+"',MAIL_POSTAL_CODE='"+checkForNull(mail_postal_code )+"',MAIL_COUNTRY_CODE='"+checkForNull(mail_country_code )+"',RES_COUNTRY_CODE='"+checkForNull(country_code )+"', ALT_ADDR_LINE1='"+altAddrLine1.replaceAll("'","''")+"', ALT_ADDR_LINE2='"+altAddrLine2.replaceAll("'","''")+"',ALT_ADDR_LINE3='"+altAddrLine3.replaceAll("'","''")+"',ALT_ADDR_LINE4='"+altAddrLine4.replaceAll("'","''")+"',ALT_AREA_CODE='"+altAreaCode.replaceAll("'","''")+"',ALT_TOWN_CODE='"+altTownCode.replaceAll("'","''")+"',ALT_REGION_CODE='"+altRegionCode.replaceAll("'","''")+"', ALT_POSTAL_CODE='"+altPostalCode.replaceAll("'","''")+"', ALT_COUNTRY_CODE='"+altCountryCode.replaceAll("'","''")+"' where patient_id='"+checkForNull(patientid)+"' and APPT_DATE>= to_date(sysdate,'DD MM YY') ";//Modified by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601
									
									if(pstmt!=null)pstmt.close();
									if(rset!=null)rset.close(); //Added for checkstyle
									pstmt=con.prepareStatement(update_app_contact_dtl);
									pstmt.executeUpdate();
									} 
									}
							     //end  of HSA-CRF-0226 [IN:050599]
								}
								else
								{
									messageBuffer.append("Procedure-MP_PAT_ADD_UPDATE FAILED");
									result = false;
								}
							}catch(Exception z)
							{
								result = false;
								messageBuffer.append("Procedure-MP_PAT_ADD_UPDATE:"+z.toString());
								
								z.printStackTrace(System.out);
							}
						}


					//For delinking baby
					if(baby_flag.equals("Y") && result)
					{	
						try
						{
							//Update bed status as occupied upto expected discharge date
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" update IP_NURSING_UNIT_BED set ");
							sbSql.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_encounter_id=?, mothers_patient_id = ?, current_status='A', ");
							sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' where facility_id=? and occupying_patient_id = ? ");
							if(pstmt!=null) pstmt.close();
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString ( 1, "");
							pstmt.setString ( 2, "");
							pstmt.setString ( 3, "");
							pstmt.setString ( 4, "");
							pstmt.setString ( 5, facilityId);
							pstmt.setString ( 6, patientid);
							int bres = pstmt.executeUpdate();
							if(bres>0) 
								result = true; 
							else
							{
								messageBuffer.append("Eror in updating into ip_nursing_unit_bed");
								result = false;
							}
						}catch(Exception e1)
						{
							messageBuffer.append("Exception in updating ip_nursing_unit_bed for baby delink" + e1);
							e1.printStackTrace();
							result = false;
						}
					}
					// Patient address details updation ends here

					if(result && !(bedno == null || bedno.equals("")) && !(roomno==null || roomno.equals("")))
					{
						/*Thursday, May 13, 2010 , commnted for PE
						//Check the nursing unit code for the facility id
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append("select 1 from ip_nursing_unit where facility_id = ? and nursing_unit_code = ? for update nowait  ");
						pstmt1 = con.prepareStatement( sbSql.toString() );
						pstmt1.setString ( 1, facilityId);
						pstmt1.setString ( 2, nursingunit ) ;
						rset1 = pstmt1.executeQuery();
						if (rset1.next() )
						{
							if(result)
							{
								//Update nursing unit occupied beds status
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" update IP_NURSING_UNIT set num_of_beds_occupied = num_of_beds_occupied +1, ");
								sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
								sbSql.append(" where facility_id = ? and nursing_unit_code = ? ");

								if(rset1!=null) rset1.close();
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString ( 1, facilityId);
								pstmt.setString ( 2, nursingunit ) ;
								try
								{
									int res2 = pstmt.executeUpdate() ;
									if(res2>0) 
										result = true; 
									else
									{
										messageBuffer.append("Error in updating into ip_nursing_unit_table");
										result = false;
									}
								}catch(Exception ex)
								{
									messageBuffer.append("Exception in updating ip_nursing_unit_table ::" + 	ex);
									result = false;
								}
							}
						}
						*/

						if(result)
						{
							//Check the room no for selected nursing unit and facility id
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append("select 1 from IP_NURSING_UNIT_ROOM where facility_id = ? and nursing_unit_code = ? and room_no = ? for update nowait ");
							if(rset1!=null) rset1.close();
							if(pstmt1!=null) pstmt1.close();
							pstmt1 = con.prepareStatement( sbSql.toString() );
							pstmt1.setString ( 1, facilityId);
							pstmt1.setString ( 2, nursingunit ) ;
							pstmt1.setString ( 3, roomno ) ;
							rset1 = pstmt1.executeQuery() ;

							int L_male_count = 0;
							int L_female_count = 0;
							int L_unknown_count = 0;
							if (rset1.next() )
							{
								if(result)
								{
									if(patientgender.equals("M")) L_male_count = 1;
									if(patientgender.equals("F")) L_female_count = 1;
									if(patientgender.equals("U")) L_unknown_count = 1;
									//Update the room details gender wise
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append(" update IP_NURSING_UNIT_ROOM set ");
									sbSql.append(" occ_male_bed_count = occ_male_bed_count+?, occ_female_bed_count = occ_female_bed_count+?, ");
									sbSql.append(" occ_unknown_bed_count = occ_unknown_bed_count+? , ");
									sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
									sbSql.append(" where facility_id=? and nursing_unit_code = ? and room_no = ? ");
									if(pstmt1!=null) pstmt1.close();
									if(rset1!=null) rset1.close();
									if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setInt    ( 1, L_male_count ) ;
									pstmt.setInt    ( 2, L_female_count);
									pstmt.setInt    ( 3, L_unknown_count);
									pstmt.setString ( 4, facilityId);
									pstmt.setString ( 5, nursingunit ) ;
									pstmt.setString ( 6, roomno ) ;
									int res3 = pstmt.executeUpdate() ;
									if(res3>0) 
										result = true; 
									else 
									{
										messageBuffer.append("Eror in updating into IP_NURSING_UNIT_ROOM_TAB");
										result = false;
									}
								}
							}
						}



						try
						{
							if(result)
							{
								//Update bed status as occupied upto expected discharge date
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" update IP_NURSING_UNIT_BED set ");
								sbSql.append(" occupying_patient_id = ?, current_status='O', ");
								if(pseudo_bed_yn.equals("Y"))
								sbSql.append("PSUEDO_BED_STATUS = 'U', ");
								sbSql.append("OCCUPIED_UNTIL_DATE_TIME =to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:MI'), ");
								sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
								sbSql.append(" where facility_id=? and nursing_unit_code = ? and bed_no = ? ");
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString ( 1, patientid ) ;
								pstmt.setString ( 2, facilityId);
								pstmt.setString ( 3, nursingunit ) ;
								pstmt.setString ( 4, bedno ) ;
								int res4 = pstmt.executeUpdate() ;
								if(res4>0) 
									result = true; 
								else 
								{
									messageBuffer.append("Eror in updating into ip_nursing_unit_bed");
									result = false;
								}
							}
						}catch(SQLException e1)
						{
							messageBuffer.append("Exception in updating ip_nursing_unit_bed : "+e1);
							
							e1.printStackTrace();
							result = false;
						}
					}

					if (bkg_type.equals("D"))
					{
						bookingrefno = appt_ref_no;
					}

					if(!(bookingrefno == null || bookingrefno.equals("") ))
					{
						String L_status = "";
						if(bkg_type.equals("D"))
						L_status = "A";
						else if (bkg_type.equals("I"))
						{
							if(!(bedno == null || bedno.equals("")))
								L_status = "3";
							else
								L_status = "2";
						}
						// While updating the bed booking in ip_bed_booking_table check the booking was done with bed or without bed
						int count = 0;
						try
						{
							if (!bkg_type.equals("D"))
							{
								// Check whether this bed is booked prior or not with booking ref no
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append("select count(*) from IP_BED_BOOKING where BED_BOOKING_REF_NO = ? and facility_id = ? and req_bed_no = ? and booking_type='L' ");
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString ( 1, bookingrefno ) ;
								pstmt.setString ( 2, facilityId);
								pstmt.setString ( 3, bedno);
								rset1 = pstmt.executeQuery();
								while(rset1.next())
								{
									count = rset1.getInt(1);
								}
							}
						}
						catch(Exception e1)
						{
							messageBuffer.append("Exception when selecting data from ip_bed_booking_table "+e1.toString());
							
							e1.printStackTrace();
							result = false;
						}


						try
						{
							if(result && count==1)
							{
								//update the booking status 3 if bed exists otherwise update with 2
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append( " update IP_BED_BOOKING ");
								sbSql.append(" set booking_status = ?, ");
								sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
								sbSql.append(" where facility_id = ? and booking_type='L' and bed_booking_ref_no=? ");
								if(pstmt!=null) pstmt.close();
								
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString ( 1, L_status ) ;
								pstmt.setString ( 2, facilityId);
								pstmt.setString ( 3, bookingrefno ) ;
								int res5 = pstmt.executeUpdate() ;



								if(res5>0) 
									result = true; 
								else
								{
									result = false;
									messageBuffer.append("Error in updating into ip_bed_booking_table [1] ");
								}
							}
						}
						catch(Exception e1)
						{
							messageBuffer.append("Exception in updating ip_bed_booking_table [1] "+e1);
							
							e1.printStackTrace();
							result = false;
						}



						try
						{
							if(result)
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								if(bkg_type.equals("D"))
								{
									//Update OA_APPT for the selected Daycare Appointment with the status as used
									sbSql.append( " update OA_APPT ");
									sbSql.append(" set appt_status = ?, res_tel_no = ?, oth_contact_no = ?, email_id = ?, ");
									sbSql.append(" res_addr_line1 = ?, res_addr_line2 = ?, res_addr_line3 = ?, ");
									sbSql.append(" res_addr_line4 = ?, postal_code = ?, country_code = ?,RES_TOWN_CODE = ?, RES_AREA_CODE = ?, RES_REGION_CODE = ?, MAIL_ADDR_LINE1 = ?, MAIL_ADDR_LINE2 = ?, MAIL_ADDR_LINE3 = ?, MAIL_ADDR_LINE4 = ?, MAIL_TOWN_CODE = ?, MAIL_AREA_CODE = ?, MAIL_REGION_CODE = ?, MAIL_POSTAL_CODE = ?, MAIL_COUNTRY_CODE = ?, alt_addr_line1 = ?, alt_addr_line2 = ?, alt_addr_line3 = ?, alt_addr_line4 = ?, alt_town_code = ?, alt_area_code = ?, alt_region_code = ?, alt_postal_code = ?, alt_country_code = ?, encounter_id = ?, ");
									sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
									sbSql.append(" where facility_id = ? and APPT_REF_NO=? ");//Modified by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601
								}
								else
								{
									sbSql.append( " update IP_BOOKING_LIST ");
									sbSql.append(" set booking_status = ?, res_tel_no = ?, oth_contact_no = ?, email_id = ?, ");
									sbSql.append(" res_addr_line1 = ?, res_addr_line2 = ?, res_addr_line3 = ?, ");
									sbSql.append(" res_addr_line4 = ?, postal_code = ?, country_code = ?,res_town_code = ?, res_area_code = ?, res_region_code = ?, mail_addr_line1 = ?, mail_addr_line2 = ?, mail_addr_line3 = ?, mail_addr_line4 = ?, mail_town_code = ?, mail_area_code = ?, mail_region_code = ?, mail_postal_code = ?, mail_country_code = ?, alt_addr_line1 = ?, alt_addr_line2 = ?, alt_addr_line3 = ?, alt_addr_line4 = ?, alt_town_code = ?, alt_area_code = ?, alt_region_code = ?, alt_postal_code = ?, alt_country_code = ?, ");
									sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
									sbSql.append(" where facility_id = ? and bkg_lst_ref_no=? ");//Modified by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601
								}
								PreparedStatement pstmt00 = con.prepareStatement(sbSql.toString());
								pstmt00.setString   ( 1,	L_status		);
								pstmt00.setString   ( 2,	res_tel_no		);
								pstmt00.setString   ( 3,	oth_contact_no	);
								pstmt00.setString   ( 4,	email_id		);
								pstmt00.setString   ( 5,	res_addr_line1	);
								pstmt00.setString   ( 6,	res_addr_line2	);
								pstmt00.setString   ( 7,	res_addr_line3	);
								pstmt00.setString   ( 8,	res_addr_line4	);
								pstmt00.setString   ( 9,	postal_code		);
								pstmt00.setString   ( 10,	country_code	);
								pstmt00.setString   ( 11,	res_town_code	);
								pstmt00.setString   ( 12,	res_area_code	);
								pstmt00.setString   ( 13,	res_region_code	);
								pstmt00.setString   ( 14,	mail_addr_line1	);
								pstmt00.setString   ( 15,	mail_addr_line2	);
								pstmt00.setString   ( 16,	mail_addr_line3	);
								pstmt00.setString   ( 17,	mail_addr_line4	);
								pstmt00.setString   ( 18,	mail_town_code	);
								pstmt00.setString   ( 19,	mail_area_code	);
								pstmt00.setString   ( 20,	mail_region_code);
								pstmt00.setString   ( 21,	mail_postal_code);
								pstmt00.setString   ( 22,	mail_country_code);
								/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
								pstmt00.setString   ( 23,	altAddrLine1);
								pstmt00.setString   ( 24,	altAddrLine2);
								pstmt00.setString   ( 25,	altAddrLine3);
								pstmt00.setString   ( 26,	altAddrLine4);
								pstmt00.setString   ( 27,	altTownCode);
								pstmt00.setString   ( 28,	altAreaCode);
								pstmt00.setString   ( 29,	altRegionCode);
								pstmt00.setString   ( 30,	altPostalCode);
								pstmt00.setString   ( 31,	altCountryCode);
								/*End*/

								if(bkg_type.equals("D"))
								{
									pstmt00.setLong   ( 32,	encounterid);
									pstmt00.setString ( 33,	facilityId);
									pstmt00.setString ( 34,	appt_ref_no);
								}
								else
								{
									pstmt00.setString ( 32,	facilityId);
									pstmt00.setString ( 33,	bookingrefno);
								}
								int res51 = pstmt00.executeUpdate() ;
								if(res51>0) 
									result = true; 
								else
								{
									result = false;
									messageBuffer.append("Eror in updating into ip_bed_booking_list");
								}
								if(pstmt00!=null) pstmt00.close();
							}
						}
						catch(Exception e1)
						{
							messageBuffer.append("Exception in updating ip_bed_booking_list" + e1);
							
							e1.printStackTrace();
							result = false;
						}
					}


			
					/*Monday, April 26, 2010, commented for PE by Manoj , updating into mp table through new procedure MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER
					try
					{
						if(result)
						{
							//Update mp_patient last contact date as systemdate
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" update MP_PATIENT set last_contact_date = sysdate, modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' where patient_id = ? ");

							if(pstmt!=null) pstmt.close();
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString ( 1, patientid ) ;
							int res6 = pstmt.executeUpdate() ;
							if(res6>0) 
								result = true; 
							else
							{
								result = false;
								messageBuffer.append("Error in updating into mp_patient");
							}
						}
					}
					catch(Exception e1)
					{
						messageBuffer.append("Exception in updating mp_patient" + e1);
						result = false;
						e1.printStackTrace();
					}
					*/
					if(!(referralid.equals("")))
					{
						try
						{
							if(result)
							{
								//Update pr_referral_register if referral id exists(means from referral)
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" Update PR_REFERRAL_REGISTER set ");
								sbSql.append(" STATUS = 'C', referred_in_func = 5,");
								sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
								sbSql.append("  where REFERRAL_ID='"+referralid+"' ");
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );
								int res33= pstmt.executeUpdate();
								if(res33>0) 
									result = true; 
								else 
								{
									result = false;
									messageBuffer.append("Eror in updating into pr_referral_register");
								}
							}
						}
						catch(Exception e1)
						{
							messageBuffer.append("Exception in updating pr_referral_register" + e1);
							
							e1.printStackTrace();
							result = false;
						}
					}
		
		
					//Checking for pat_check_in_allowed_yn
					if(result)
					{
						if(blocked_yn.equals("Y") && bookingrefno.equals(""))
						{
							try
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								String bNo = "";
								if(pat_check_in_allowed_yn.equals("Y"))
									bNo = new_bedno;
								else
									bNo = bedno;

								sbSql.append(" update IP_BED_BOOKING set booking_status = 4, modified_at_ws_no='"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' where req_nursing_unit_code='"+nursingunit+"' and facility_id='"+facilityId+"' and req_bed_no='"+bNo+"' and sysdate between blocked_from_date_time and blocked_until_date_time ");
								
								int updateCount = 0;
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								updateCount = pstmt.executeUpdate();
								if (updateCount > 0)
									result = true;
								else 
								{
									result = false;
									messageBuffer.append("Eror in updating into ip_bed_booking_table [2] ");
								}
							}catch(Exception e)
							{
								
								 e.printStackTrace();
								result = false;
							}
						}

						if(confirm_flag.equals("Y") && result)
						{
							String bed = "";
							if(pat_check_in_allowed_yn.equals("Y"))
								bed = new_bedno;
							else
							bed = bedno;

							try
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append("update IP_BED_BOOKING set booking_status = 4, ");
								sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
								sbSql.append(" where req_nursing_unit_code='");
								sbSql.append(nursingunit);
								sbSql.append("'and facility_id='");
								sbSql.append(facilityId);
								sbSql.append("'and req_bed_no='");	
								sbSql.append(bed);
								//sbSql.append("'and booking_status=0");
								sbSql.append("' and blocked_from_date_time > sysdate");
								
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								int rCounts = pstmt.executeUpdate();

								if (rCounts > 0)
									result = true;
								else 
								{
									result = false;
									messageBuffer.append("Eror in updating into ip_bed_booking_table [3] ");
								}
							}catch(Exception e)
							{
								e.printStackTrace();
								result = false;
							}
						}//for confirm flag
						/*Added for PMG2016-CRF-0002 IN061508 on 29-Aug-16*/
						if(!bookingrefno.equals("") && !booking_bed_no.equals(""))
						{
							try
							{
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								String rel_booked_bed_yn ="N";
								sbSql.append("select rel_booked_bed_yn from IP_PARAM where facility_id = '"+facilityId+"'");
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );
								rset = pstmt.executeQuery();
								if(rset.next())
								{
									rel_booked_bed_yn = rset.getString("rel_booked_bed_yn");
								}
							
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
                                                          		
								
								if(!booking_bed_no.equals(bedno) && rel_booked_bed_yn.equals("Y")){								
								sbSql.append(" update IP_BED_BOOKING set blocked_until_date_time = sysdate, modified_at_ws_no='"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' where facility_id='"+facilityId+"' and req_bed_no='"+booking_bed_no+"' and bed_booking_ref_no='"+bookingrefno+"' ");
								
								
								
								int updateCount1 = 0;
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								updateCount1 = pstmt.executeUpdate();								
								if (updateCount1 > 0)
									result = true;
								else 
								{
									result = false;
									messageBuffer.append("Eror in updating into ip_bed_booking_table [4] ");
								}								
								//Below line added for this CRF ML-MMOH-SCF-0828
							    
							 }else if(booking_bed_no.equals(new_bedno) && rel_booked_bed_yn.equals("N")){
                                
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								
								sbSql.append(" update IP_BED_BOOKING set blocked_until_date_time = sysdate where facility_id='"+facilityId+"' and req_bed_no='"+booking_bed_no+"' and bed_booking_ref_no='"+bookingrefno+"'");
													
								
								int updateCount2 = 0;
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(sbSql.toString());
								updateCount2 = pstmt.executeUpdate();
								
								if (updateCount2 > 0) result = true;								
								
							}
							 //End this SCF  ML-MMOH-SCF-0828
							}catch(Exception e)
							{
								
								 e.printStackTrace();
								result = false;
							}
						}/*Added for PMG2016-CRF-0002 IN061508 on 29-Aug-16*/
						if(pat_check_in_allowed_yn.equals("Y") && (!new_bedno.equals("")) && result)
						{
							try
							{
								/*Thursday, May 13, 2010 , update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through following procedure and moved to line no 357*/

								//Update pr_referral_register if referral id exists(means from referral)
								/*
								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" select NEXT_BOOKING_SRL_NO srl_no from IP_BED_BOOKING_SRL_CTRL where facility_id = '"+facilityId+"' and BOOKING_TYPE = 'B' and GEN_BOOKING_SRL_YN = 'Y' ");
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );
								rset = pstmt.executeQuery();
								if(rset.next())
								{
									bed_srlno = rset.getInt("srl_no");
								}

								if(bed_srlno < 1 )
								{
									result = false;
									firemsg = true;
								}

								if(result)
								{
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("select bed_block_period_normal, to_char((sysdate + bed_block_period_normal/24),'dd/mm/rrrr hh24:mi')  blocked_until_date_time from IP_PARAM where facility_id = '"+facilityId+"'");
									if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement( sbSql.toString() );
									rset = pstmt.executeQuery();
									if(rset.next())
									{
										blocked_until_date_time = rset.getString("blocked_until_date_time");
									}

									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("Update IP_BED_BOOKING_SRL_CTRL set NEXT_BOOKING_SRL_NO=NEXT_BOOKING_SRL_NO+1 , ");
									sbSql.append(" modified_at_ws_no = '"+addedAtWorkstation+"', modified_by_id = '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"' ");
									sbSql.append(" WHERE  facility_id= '"+facilityId+"' and BOOKING_TYPE = 'B' and GEN_BOOKING_SRL_YN = 'Y'");
									if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement( sbSql.toString() );
									int srs = pstmt.executeUpdate();
									if(srs>0)
									result = true;
									else
									{
										result = false;
										messageBuffer.append("Error in ip_bed_booking_srl_ctrl_table");
									}
								}*/
								
							}
							catch(Exception e1)
							{
								messageBuffer.append("Exception in ip_bed_booking_srl_ctrl_table" + e1.toString());
								e1.printStackTrace();
								result = false;
							}

							//For cancelling the future blockings
							if(result)
							{
								try
								{
								  // add for this SCF ML-MMOH-SCF-0827
								  						
                            String SQLQuery="SELECT DECODE (CEIL (SYSDATE - booking_date_time), 0, 'Y', 'N') update_yn,TO_CHAR(SYSDATE- 0.0001,'DD/MM/YYYY HH24:MI:SS') new_book_date  FROM ip_bed_booking where facility_id='"+facilityId+"' and bed_booking_ref_no='"+bookingrefno+"'and req_bed_no='"+booking_bed_no+"' and req_nursing_unit_code='"+nursingunit+"' and patient_id='"+patientid+"'";
								   
								   pstmt = con.prepareStatement(SQLQuery);
								   rs1=pstmt.executeQuery();
								   if(rs1!=null && rs1.next()){
                                     newbookingdatetime = checkForNull(rs1.getString("new_book_date"));
									 updateyn = checkForNull(rs1.getString("update_yn"));  
                                   }
								   if(rs1!=null) rs1.close();
								   if(pstmt!=null) pstmt.close();
								   
								 if(updateyn.equals("Y")){						 
								
                                  if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());                                   
								  sbSql.append("update IP_BED_BOOKING set booking_date_time=TO_DATE('"+newbookingdatetime+"', 'dd/mm/rrrr hh24:mi:ss') where facility_id='"+facilityId+"' and bed_booking_ref_no='"+bookingrefno+"' and req_bed_no='"+booking_bed_no+"' and patient_id='"+patientid+"' and req_nursing_unit_code='"+nursingunit+"'");
								   
								   
								   					   
								   pstmt = con.prepareStatement(sbSql.toString());
								   bookingCount =	pstmt.executeUpdate();
								   
								   if (bookingCount > 0) result = true;								   
								
                              }
							       //End this CRF ML-MMOH-SCF-0827
								
								
									String booking_type = "B";
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("insert into IP_BED_BOOKING (facility_id, booking_type,bed_booking_ref_no,encounter_id, patient_id, booking_date_time,booked_by_id,req_nursing_unit_code,req_service_code,req_bed_no,req_room_no,req_bed_class_code,req_bed_type_code,req_practitioner_id,req_specialty_code,blocked_from_date_time,blocked_until_date_time,booking_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,override_yn) VALUES");
									sbSql.append("(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,sysdate,?,?,?,sysdate,?,?,?) ");
									if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString(1,  facilityId);
									pstmt.setString(2,  booking_type);
									pstmt.setInt(3,  bed_srlno);
									pstmt.setLong(4,  encounterid);
									pstmt.setString(5,  patientid);
									pstmt.setString(6,  addedById);
									pstmt.setString(7,  nursingunit);
									pstmt.setString(8,  service);
									pstmt.setString(9, new_bedno);
									pstmt.setString(10, roomno);
									pstmt.setString(11, bedclass);
									pstmt.setString(12, bedtype);
									pstmt.setString(13, admt_practitioner);
									pstmt.setString(14, speciality);
									pstmt.setString(15, blocked_until_date_time);
									pstmt.setString(16, "0");
									pstmt.setString(17, addedById);
									pstmt.setString(18, addedAtWorkstation);
									pstmt.setString(19, facilityId);
									pstmt.setString(20, addedById);
									pstmt.setString(21, addedAtWorkstation);
									pstmt.setString(22, facilityId);
									pstmt.setString(23,"Y");

									recCount = pstmt.executeUpdate(); // Modified for this SCF ML-MMOH-SCF-0827 (variable declared on top)
									if (recCount > 0)
									{
										result = true;

									}
									else 
									{
										result = false;
										messageBuffer.append("Error in inserting into ip_bed_booking_table ");
									}
								}
								catch(Exception ee)
								{
									ee.printStackTrace();
									result = false;
								}
							}
						}//For pat_check_in_allowed_yn == "Y"
					}


					// MOD#04 The new hashtable is introduced to pass the variable to the bean

					if(isBlInstalled.equals("Y") && result)
					{
						try
						{
							Hashtable hashtableBill = new Hashtable();
							hashtableBill.put("facilityId",facilityId+"");
							hashtableBill.put("bookingrefno",bookingrefno+"");
							hashtableBill.put("patientid",patientid+"");
							hashtableBill.put("encounterid",encounterid+""); 
							hashtableBill.put("sourcetype",sourcetype+"");
							hashtableBill.put("source",source+"");
							hashtableBill.put("refpractitioner",refpractitioner+"");
							hashtableBill.put("admissiondate",admissiondate);
							hashtableBill.put("admissiontype",admissiontype+"");
							hashtableBill.put("circumstanceofinjury",circumstanceofinjury+"");
							hashtableBill.put("chiefcomplaint",chiefcomplaint+"");
							hashtableBill.put("otdatetime",otdatetime+"");
							hashtableBill.put("practitioner",admt_practitioner+"");
							hashtableBill.put("speciality",speciality+"");
							hashtableBill.put("medicalteam",medicalteam+"");
							hashtableBill.put("patienttype",patienttype+"");
							hashtableBill.put("bedclass",bedclass+"");
							hashtableBill.put("nursingunit",nursingunit+"");
							hashtableBill.put("service",service+"");
							hashtableBill.put("subservice",sub_service+"");
							hashtableBill.put("bedno",bedno+"");
							hashtableBill.put("roomno",roomno+"");
							hashtableBill.put("dailycharge",dailycharge+"");        
							hashtableBill.put("ambulatorystatus",ambulatorystatus+"");
							hashtableBill.put("modeofarrival",modeofarrival+"");
							hashtableBill.put("name",name+"");
							hashtableBill.put("address1",address1+"");
							hashtableBill.put("address2",address2+"");
							hashtableBill.put("address3",address3+"");
							hashtableBill.put("address4",address4+"");
							hashtableBill.put("postalcode",postalcode+"");
							hashtableBill.put("telno",telno+"");
							hashtableBill.put("mvregnno",mvregnno+"");
							hashtableBill.put("emergencydetail",emergencydetail+"");
							hashtableBill.put("admtypeind",admtypeind+"");
							hashtableBill.put("ancillaryyn",ancillaryyn+"");
							hashtableBill.put("patientclass",patientclass+"");
							hashtableBill.put("refpractitionername",refpractitionername+"");
							hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
							hashtableBill.put("billing_interfaced",billing_interfaced+"");
							hashtableBill.put("isBlInstalled",isBlInstalled+"");
							hashtableBill.put("P_MODE",P_MODE+"");
							hashtableBill.put("P_PATIENT_ID",P_PATIENT_ID+"");
							hashtableBill.put("P_BLNG_GRP_ID",P_BLNG_GRP_ID+"");
							hashtableBill.put("fin_dtls",(HashMap)hashData.get("fin_dtls"));
							/***********Added for Package Billing******start****/
							hashtableBill.put("PACKAGE_DET",(HashMap)hashData.get("PACKAGE_DET"));
							hashtableBill.put("PACKAGE_ASSOCIATED",(ArrayList)hashData.get("PACKAGE_ASSOCIATED"));
							hashtableBill.put("PACKAGE_APPROVALS",(HashMap)hashData.get("PACKAGE_APPROVALS"));
							hashtableBill.put("PACKAGE_DISCOUNT",(ArrayList)hashData.get("PACKAGE_DISCOUNT"));
							/***********Added for Package Billing******end****/
							
/*
							hashtableBill.put("P_BLNG_CLASS_CODE",P_BLNG_CLASS_CODE+"");
							hashtableBill.put("P_EMPLOYER_CODE",P_EMPLOYER_CODE+"");
							hashtableBill.put("P_SETTLEMENT_IND",P_SETTLEMENT_IND+"");
							hashtableBill.put("P_CREDIT_DOC_REF_DATE",P_CREDIT_DOC_REF_DATE+"");    
							hashtableBill.put("P_CUST_CODE",P_CUST_CODE+"");
							hashtableBill.put("P_SLMT_TYPE_CODE",P_SLMT_TYPE_CODE+"");
							hashtableBill.put("P_SLMT_DOC_REF_DESC",P_SLMT_DOC_REF_DESC +"");
							hashtableBill.put("P_SLMT_DOC_REF_DATE",P_SLMT_DOC_REF_DATE+""); 
							hashtableBill.put("P_SLMT_DOC_REMARKS",P_SLMT_DOC_REMARKS+"");
							hashtableBill.put("P_REMARKS",P_REMARKS+"");
							hashtableBill.put("user_id",user_id+"");
							hashtableBill.put("P_POLICY_TYPE_CODE",P_POLICY_TYPE_CODE +"");
							hashtableBill.put("P_POLICY_NUMBER",P_POLICY_NUMBER +"");
							hashtableBill.put("P_POLICY_EXPIRY_DATE",P_POLICY_EXPIRY_DATE+""); 
							hashtableBill.put("P_NON_INS_BLNG_GRP_ID",P_NON_INS_BLNG_GRP_ID+"");
							hashtableBill.put("P_NON_INS_CUST_CODE",P_NON_INS_CUST_CODE+"");
*/
							hashtableBill.put("P_EPISODE_TYPE",P_EPISODE_TYPE+"");
							hashtableBill.put("P_PACKAGE_BILL_DOC_TYPE",P_PACKAGE_BILL_DOC_TYPE+"");
							hashtableBill.put("P_PACKAGE_BILL_DOC_NUM",P_PACKAGE_BILL_DOC_NUM+"" ); 
/*
							hashtableBill.put("P_CREDIT_AUTH_REF",P_CREDIT_AUTH_REF+"");
							hashtableBill.put("P_CREDIT_AUTH_DATE",P_CREDIT_AUTH_DATE+"");  
							hashtableBill.put("P_EFFECTIVE_DATE",P_EFFECTIVE_DATE+"");      
							hashtableBill.put("P_APPROVED_AMT",P_APPROVED_AMT+""+""); //int
							hashtableBill.put("P_APPROVED_DAYS",P_APPROVED_DAYS +""+""); //int
*/
							hashtableBill.put("P_EPISODE_STATUS",P_EPISODE_STATUS+"");
							hashtableBill.put("P_VISIT_ID",P_VISIT_ID+""); //int
							hashtableBill.put("P_ADM_DOCTOR",P_ADM_DOCTOR+"");
							hashtableBill.put("insTrackDtlsExists",insTrackDtlsExists+"");
							hashtableBill.put("expecteddischargedate",expecteddischargedate);
							hashtableBill.put("referralid",referralid+"");
/*
							hashtableBill.put("upd_fin_dtls",upd_fin_dtls+"");
							hashtableBill.put("annual_income",annual_income+"");
							hashtableBill.put("family_asset",family_asset+"");
							hashtableBill.put("no_of_dependants",no_of_dependants+"");
							hashtableBill.put("resp_for_payment",resp_for_payment+"");
*/
							hashtableBill.put("contact_details",contact_details+"");
							hashtableBill.put("res_tel_no",res_tel_no+"");
							hashtableBill.put("oth_contact_no",oth_contact_no+"");
							hashtableBill.put("email_id",email_id+"");
							hashtableBill.put("postal_code",postal_code+"");
							hashtableBill.put("country_code",country_code+"");
							hashtableBill.put("res_addr_line1",res_addr_line1+"");
							hashtableBill.put("res_addr_line2",res_addr_line2+"");
							hashtableBill.put("res_addr_line3",res_addr_line3+"");
							hashtableBill.put("res_addr_line4",res_addr_line4+"");
							hashtableBill.put("addedById",addedById+"");
							hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
							hashtableBill.put("modifiedAtWorkstation",addedAtWorkstation+"");
							hashtableBill.put("added_date",added_date);     //java.sql.Date
							hashtableBill.put("function_id",strFunctionId+"");
							hashtableBill.put("nursingunittype",nursingunittype+"");
							//hashtableBill.put("bedtype",bedtype+"");
							hashtableBill.put("bedtype",modified_bed_type+"");

							hashtableBill.put("srlno",srlno+"");
/*
							hashtableBill.put("gl_holder_name",gl_holder_name+"");
							hashtableBill.put("gl_holder_rel",gl_holder_reln+"");
							hashtableBill.put("cred_start_date",cred_st_dt+"");
*/
							hashtableBill.put("module_id",patientclass+"");
							hashtableBill.put("locale",locale);
							if(expecteddischargedate != null && !(expecteddischargedate.equals("")))
							{
								hashtableBill.put("exp_no_of_day_stay",expected_days_of_stay+"");
							}
							BLIPAdmitPat blipAdmitPat = new BLIPAdmitPat();
							Hashtable resultsBL = blipAdmitPat.billPatientService(p, con,hashtableBill);
							boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
							result = boolRes;
							strBLMessage = "";
							if (boolRes == false)
							{
								result  = false;
								messageBuffer.append((String)resultsBL.get("error"));
							}

							/*if (boolRes == true)
							{
								result = true;
								strBLMessage = (String) resultsBL.get("message");
								if (strBLMessage != null )
								{
									if (!strBLMessage.equalsIgnoreCase("null"))
									{
										messageBuffer.append("<u>"+strBLMessage+"</u><br>");
									}
								}
							}*/


                              if (boolRes == true)
							   {
								result = true;
								strBLMessage = (String) resultsBL.get("message");
								strBLdeposit = (String) resultsBL.get("deposit_amount");
								strBLadmn_dep_coll_reqd_yn= (String) resultsBL.get("admn_dep_coll_reqd_yn");
								str_package_amt	=(String) resultsBL.get("str_package_amt");	
								if (str_package_amt==null) str_package_amt = "";
								str_package_code	=(String) resultsBL.get("str_package_code");	
								if (str_package_code==null) str_package_code = "";
								str_package_seq_num	=(String) resultsBL.get("str_package_seq_num");
								if (str_package_seq_num==null) str_package_seq_num = "";
								package_enabled_yn	=(String) resultsBL.get("package_enabled_yn");
								if (package_enabled_yn==null) package_enabled_yn = "";
								if (strBLMessage != null )
								{
									if (!strBLMessage.equalsIgnoreCase("null"))
									{
										messageBuffer.append("<u>"+strBLMessage+"</u><br>");
									}
								}
							}

						}
						catch(Exception exceptionBL)
						{
							result = false;
							messageBuffer.append("BILLING UPDATION :"+exceptionBL.toString());
							exceptionBL.printStackTrace();
						}
					}// E.O Billing related
				}catch(Exception exception1)
				{
					try
					{
						Thread.sleep(2000L);
					}
					catch(InterruptedException interruptedexception)
					{

					}
					result = false;
					if(pst != null)	pst.close();
					messageBuffer.append(exception1.toString());
					exception1.printStackTrace();
				}
			}
			// MOD#07 (From MOD#06) the following new code is introduced.

			

			
				if (result)
				{
					message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					messageBuffer.append( (String) message.get("message"));
					con.commit();
				}
				else
				{
					//java.util.Hashtable message = MessageManager.getMessage(locale, "ERROR_WHILE_UPDATING","IP");
					//messageBuffer.append( (String) message.get("message"));
					con.rollback();
				}

				if(firemsg)
				{
					if(messageBuffer.length() > 0) messageBuffer.delete(0,messageBuffer.length());
//					messageBuffer.append("IP_BED_BOOKING_SRL_CTRL not defined, cannot proceed");
					message = MessageManager.getMessage(locale, "BED_BKG_SRL_CTRL_NOT_DEFINED","IP");
					messageBuffer.append( (String) message.get("message"));
					con.rollback();
				}
				if(isroom_no_found)
				{
					if(messageBuffer.length() > 0) messageBuffer.delete(0,messageBuffer.length());
//					messageBuffer.append("IP_BED_BOOKING_SRL_CTRL not defined, cannot proceed");
					message = MessageManager.getMessage(locale, "ROOM_NOT_IN_NU","IP");
					messageBuffer.append( (String) message.get("message"));
					con.rollback();
				}
			}catch ( Exception e )
			{
				messageBuffer.append(e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(rset != null)   rset.close();
					if(rset1 != null)  rset1.close();
					if(srs != null)    srs.close();
					if(pstmt1 != null) pstmt1.close();
					if(pst != null)    pst.close();
					if(pstmt != null)  pstmt.close();
					if(cstmt != null)  cstmt.close();
				}
				catch(Exception ce)
				{	
				}
				if(con != null)	ConnectionManager.returnConnection(con,p);
			}
		}

		Long encounter = new Long(encounterid);
		results.put("status", new Boolean(result));
		results.put("error", messageBuffer.toString());
		results.put("encounter", encounter);
		results.put("or_check_unbill_ord_exists_yn", ord_exist_yn);
		results.put("deposit_amount", strBLdeposit);
		results.put("admn_dep_coll_reqd_yn", strBLadmn_dep_coll_reqd_yn);
		results.put("str_package_amt", str_package_amt);
		results.put("str_package_code", str_package_code);
		results.put("str_package_seq_num", str_package_seq_num);
		results.put("package_enabled_yn", package_enabled_yn);
		
		return results ;
	}//end insert

	/**
	This method is used check if the fields have null values.
	@version - V3
	@param1 - String
	@return - String
	*/

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}// end session bean
