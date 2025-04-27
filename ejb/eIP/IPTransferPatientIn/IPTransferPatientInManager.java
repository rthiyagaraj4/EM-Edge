/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to transfer the patients out.
@version - V3
*/
package eIP.IPTransferPatientIn;
import blipin.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.Common.*;
/**
*
* @ejb.bean
*	name="IPTransferPatientIn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPTransferPatientIn"
*	local-jndi-name="IPTransferPatientIn"
*	impl-class-name="eIP.IPTransferPatientIn.IPTransferPatientInManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eIP.IPTransferPatientIn.IPTransferPatientInLocal"
*	remote-class="eIP.IPTransferPatientIn.IPTransferPatientInRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPTransferPatientIn.IPTransferPatientInLocalHome"
*	remote-class="eIP.IPTransferPatientIn.IPTransferPatientInHome"
*	generate= "local,remote"
*
*
*/
public class IPTransferPatientInManager implements SessionBean
{

	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used to insert information about patient transfer.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap insertIPTransferPatientIn(java.util.Properties p,java.util.HashMap hashData)
	{
		Connection con				= null;
		//Connection bookingCon		= null;//modified on 10-07-2008 for SCR 3440
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt2	= null;
		PreparedStatement pstmt1	= null;
		ResultSet rset				= null;
		Statement stmt				= null;
		ResultSet srs				= null;
		CallableStatement cstmt		= null;
		int todailycharge			= 0;
		long encounterid			= 0;
		int frdailycharge			= 0;
		String locale				= "";
		String facilityId			= "";
		String patientid			= "";
		String enid					= "";
		String transferdate			= "";
		String transfertype			= "";
		String tfr_req_type			= "";
		String tfr_type				= "";
		String modified_date_val	= "";
		String DOB					= "";
		String topractitionerid		= "";
		String tospecialitycode		= "";
		String tobedclass			= "";
		String fm_fs_locn_code_to="";
		StringBuffer strBuffer		= new StringBuffer();
		StringBuffer sbSql			= new StringBuffer();
		facilityId					= (String)hashData.get("facilityId");
		patientid					= (String)hashData.get("patientid");
		enid						= (String)hashData.get("encounterid");
		transferdate				= (String)hashData.get("transferdate");
		transfertype				= (String)hashData.get("transfertype");
		tfr_req_type				= (String)hashData.get("tfr_req_type");
		if(tfr_req_type.equals("RT"))
			tfr_type = "R";
		else
			tfr_type = "O";
        locale						= p.getProperty("LOCALE");
		modified_date_val			= (String)hashData.get("modified_date_val");
		DOB							= (String)hashData.get("DOB");
		topractitionerid			= (String)hashData.get("topractitionerid");
		tospecialitycode			= (String)hashData.get("tospecialitycode");
		tobedclass					= (String)hashData.get("tobedclass");
		String tonursingunitcode = (String)hashData.get("tonursingunitcode");
		String tonursingunittype = (String)hashData.get("tonursingunittype");
		String tobedno			 = (String)hashData.get("tobedno");
		String tobedtype		 = (String)hashData.get("tobedtype");
		String toroomno			 = (String)hashData.get("toroomno");
		String to_dailycharge	 = (String)hashData.get("todailycharge");
		String frbedclass		 = (String)hashData.get("frbedclass");
		String frnursingunitcode = (String)hashData.get("frnursingunitcode");
		String frbedno			 = (String)hashData.get("frbedno");
		String frroomno			 = (String)hashData.get("frroomno");
		String fr_dailycharge	 = (String)hashData.get("frdailycharge");
		String frbedtype		 = (String)hashData.get("frbedtype");
		String modified_bed_type_code = (String)hashData.get("modified_bed_type_code");
		String bookingrefno		 = (String)hashData.get("bookingrefno");
		String patientgender	 = (String)hashData.get("patientgender");
		String addedAtWorkstation= (String)hashData.get("addedAtWorkstation");
		String bl_interface_yn	 = (String)hashData.get("bl_interface_yn");
		String bl_operational	 = (String)hashData.get("bl_operational");
		String encounter_id		 = (String)hashData.get("encounter_id");
		String transfer_in_status = (String)hashData.get("transfer_in_status");
		String service			 = (String)hashData.get("service");
		String sub_service		 = (String)hashData.get("sub_service");
		String Bedcode			 = (String)hashData.get("Bedcode");
		String team_id			 = (String)hashData.get("team_id");
		String info_pat_relatives= (String)hashData.get("info_pat_relatives");
		String block_date_time	 = (String)hashData.get("block_date_time");
		String inform_to		 = (String)hashData.get("inform_to");
		String info_date_time	 = (String)hashData.get("info_date_time");
		String informed_name	 = (String)hashData.get("informed_name");
		String auth_date_time	 = (String)hashData.get("auth_date_time");
		String block_type_code	 = (String)hashData.get("block_type_code");
		String bed_block_remark	 = (String)hashData.get("bed_block_remark");
		String deactivate_pseudo_bed_yn = (String)hashData.get("deactivate_pseudo_bed_yn");
		String mother_bed_status = (String)hashData.get("mother_bed_status");
		String cancel_reason	 = (String)hashData.get("cancel_reason");
		String porterage_hid	 = (String)hashData.get("porterage_hid");
		String frservicecode	 = (String)hashData.get("frservicecode");
		String fr_sub_service_code				= (String)hashData.get("fr_sub_service_code");
		String fr_speciality_code				= (String)hashData.get("fr_speciality_code");
		String fr_practitioner_id				= (String)hashData.get("fr_practitioner_id");
		String fr_team_id						= (String)hashData.get("fr_team_id");
		String patient_class					= (String)hashData.get("patient_class");
		String admission_date					= (String)hashData.get("admission_date");
		String is_reserved_bed_checked			= (String)hashData.get("is_reserved_bed_checked");
		String reason_for_reserved_bed			= (String)hashData.get("reason_for_reserved_bed");
		String confirm_yn						= (String)hashData.get("confirm_yn");
		String is_to_bed_equals_reserve_bed		= (String)hashData.get("is_to_bed_equals_reserve_bed");
		String reserve_bed_no					= (String)hashData.get("reserve_bed_no");
		String reserve_nurs_unit_code			= (String)hashData.get("reserve_nurs_unit_code");
		String reserve_room_no					= (String)hashData.get("reserve_room_no");
		String system_date						= (String)hashData.get("sdate");
		String reserve_specialty_code			= (String)hashData.get("reserve_specialty_code");
		String reserve_practitioner_id			= (String)hashData.get("reserve_practitioner_id");
		String reserve_bed_type_code			= (String)hashData.get("reserve_bed_type_code");
		String reserve_service_code				= (String)hashData.get("reserve_service_code");
		String reserve_bed_class_code			= (String)hashData.get("reserve_bed_class_code");
		String reserve_bed_on_tfr_yn			= (String)hashData.get("reserve_bed_on_tfr_yn");
		//String blocking_period			        = (String)hashData.get("blocking_period");
		String allow_multiple_bed_for_resv_yn	= (String)hashData.get("allow_multiple_bed_for_resv_yn");
		String exp_discharge_date_time	        = (String)hashData.get("exp_discharge_date_time");
		String transfer_wo_delink_yn	= (String)hashData.get("transfer_wo_delink_yn");//Added for the CRF - HSA-CRF-0035
		
		String arrival_date_time = (String)hashData.get("arrival_date_time"); // added by mujafar for ML-MMOH-CRF-1136
		String isArrivalDateAppl = (String)hashData.get("isArrivalDateAppl");
		

		String new_reserved_bed_no = "";
		ArrayList reserveNuArray				= new ArrayList();	
		ArrayList reserveBedArray				= new ArrayList();	
		ArrayList<String> babyBedNo=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		ArrayList<String> babyPatientId=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		hashData.clear();
		java.util.HashMap results = new java.util.HashMap() ;
		if(!enid.equals(""))
			encounterid	= Long.parseLong(enid);

		if(!to_dailycharge.equals(""))
			todailycharge = Integer.parseInt(to_dailycharge);
		else
			todailycharge = 0;

		if(!fr_dailycharge.equals(""))
			frdailycharge = Integer.parseInt(fr_dailycharge);
		else
			frdailycharge = 0;

		boolean result				= true;

		StringBuffer sb				= new StringBuffer("");
		StringBuffer sql			= new StringBuffer("");
		results.put( "error", "no error" ) ;
		String addedById		    = p.getProperty("login_user");
		int rs						= 0;

		String blng_class_code		= "";
		String blng_serv_code		= "";
		String bill_type_code		= "";
		String episode_id			= encounter_id;
		String strBLMessage			= "";
		String strBLSpecialMessage  = "";
		boolean boolBLInstall		= false;
		String Mode_of_Tran_desc	= "";
		String acc_per1_desc		= "";
		String acc_per2_desc		= "";
		String acc_per3_desc		= "";
		String acc_per4_desc		= "";
		String acc_per5_desc		= "";
		String acc_per6_desc		= "";
		String acc_per7_desc		= "";
		String equip1_desc			= "";
		String equip2_desc			= "";
		String equip3_desc			= "";
		String equip4_desc			= "";
		String equip5_desc			= "";
		String equip6_desc			= "";
		String equip7_desc			= "";
		String bld_med1_desc		= "";
		String bld_med2_desc		= "";
		String bld_med3_desc		= "";
		String bld_med4_desc		= "";
		String bld_med5_desc		= "";
		String bld_med6_desc		= "";
		String bld_med7_desc		= "";
		String bld_med8_desc		= "";
		String bld_med9_desc		= "";
		String bld_med10_desc		= "";
		String rec_doc1_desc		= "";
		String rec_doc2_desc		= "";
		String rec_doc3_desc		= "";
		String rec_doc4_desc		= "";
		String rec_doc5_desc		= "";
		String pat_bel1_desc		= "";
		String pat_bel2_desc		= "";
		String pat_bel3_desc		= "";
		String pat_bel4_desc		= "";
		String pat_bel5_desc		= "";
		String pat_bel6_desc		= "";
		String pat_bel7_desc		= "";
		String pat_bel8_desc		= "";
		String pat_bel9_desc		= "";
		String pat_bel10_desc		= "";
		String port_recv_yn			= "";
		String received_pf			= "";
		String port_remarks			= "";
		String pseudo_bed_yn	    = "";
		String L_current_gender		= "*";
		String ext_num				= "";
		String fr_bed_type_code     = "";
		String fr_bed_type_code_by_defn = "";
		String check_same_sex_in_room_yn = "";
		String fm_install_yn		= "";
		String blocked_until_date   = "";
		String psedo_bed_staus		= "";
		String overrideyn			= "N";
		String BOOKING_TYPE			= "";
		String OVERRIDE_YN			= "";
		int malebedcount			= 0;
		int femalebedcount			= 0;
		int unknownbedcount			= 0;
		int bed_srlno				= 0;
		int babyCount=0;//Added for the CRF - HSA-CRF-0035
		
		int transferBabyCount=0;//Added for this SCF ML-MMOH-SCF-0663
		
		if(sb.length()>0)
		 sb.setLength(0);
		 
		 //Added for this SCF GDOH-SCF-0205
		Boolean checkTrnasferDate = false; 
		CallableStatement cstmt1  = null;
		String episode_type_ipdc  ="";
		//End GDOH-SCF-0205
		 
	try
	{
		con = ConnectionManager.getConnection(p);
		//Below line added for this SCF GDOH-SCF-0205	
		checkTrnasferDate=CommonBean.isSiteSpecific(con, "IP","UPDATE_TRANSFER_DATE"); 		
		if(patient_class.equals("IP")){
		  episode_type_ipdc="I";
		}else if(patient_class.equals("DC")){
		  episode_type_ipdc="D";  
		}  
		//End GDOH-SCF-205
		 
		con.setAutoCommit(false);

		strBuffer.delete(0, strBuffer.length());
		strBuffer.append(" select TFR_REQ_STATUS, TO_CHAR(modified_date, 'dd/mm/rrrr hh24:mi') modified_date,(select install_yn from sm_module where module_id = 'FM')fm_install_yn FROM IP_TRANSFER_REQUEST where facility_id = '");
		strBuffer.append(facilityId);
		strBuffer.append("' and encounter_id = '");
		strBuffer.append(encounterid);
		strBuffer.append("' ");
		strBuffer.append("and tfr_req_status = '3' ");

		if (srs != null)  srs.close();
		if (stmt != null)  stmt.close();
		stmt = con.createStatement();
		srs = stmt.executeQuery(strBuffer.toString());
		String modifiedDate_value = "";
		String status = "";

		if ((srs != null) && (srs.next()))
		{
			modifiedDate_value = checkForNull(srs.getString("modified_date"));
			status = checkForNull(srs.getString("TFR_REQ_STATUS"));
			fm_install_yn = srs.getString("fm_install_yn")==null ? "N" : srs.getString("fm_install_yn");
		}
	    if(status.equals("9"))
		{
			result = false;
			Hashtable message = MessageManager.getMessage(locale,"REQUEST_CANCELLED","IP" ) ;
			sb.append((String) message.get("message"));
			message.clear();
		}



		if(modifiedDate_value.equals(modified_date_val) && result)
		{
			if(porterage_hid.equals(""))
			{
				StringTokenizer strToken = new StringTokenizer(porterage_hid,"^^");
				while(strToken.hasMoreTokens())
				{
					Mode_of_Tran_desc	= checkForNull(strToken.nextToken());
					acc_per1_desc		= checkForNull(strToken.nextToken());
					acc_per2_desc		= checkForNull(strToken.nextToken());
					acc_per3_desc		= checkForNull(strToken.nextToken());
					acc_per4_desc		= checkForNull(strToken.nextToken());
					acc_per5_desc		= checkForNull(strToken.nextToken());
					acc_per6_desc		= checkForNull(strToken.nextToken());
					acc_per7_desc		= checkForNull(strToken.nextToken());
					equip1_desc			= checkForNull(strToken.nextToken());
					equip2_desc			= checkForNull(strToken.nextToken());
					equip3_desc			= checkForNull(strToken.nextToken());
					equip4_desc			= checkForNull(strToken.nextToken());
					equip5_desc			= checkForNull(strToken.nextToken());
					equip6_desc			= checkForNull(strToken.nextToken());
					equip7_desc			= checkForNull(strToken.nextToken());
					bld_med1_desc		= checkForNull(strToken.nextToken());
					bld_med2_desc		= checkForNull(strToken.nextToken());
					bld_med3_desc		= checkForNull(strToken.nextToken());
					bld_med4_desc		= checkForNull(strToken.nextToken());
					bld_med5_desc		= checkForNull(strToken.nextToken());
					bld_med6_desc		= checkForNull(strToken.nextToken());
					bld_med7_desc		= checkForNull(strToken.nextToken());
					bld_med8_desc		= checkForNull(strToken.nextToken());
					bld_med9_desc		= checkForNull(strToken.nextToken());
					bld_med10_desc		= checkForNull(strToken.nextToken());
					rec_doc1_desc		= checkForNull(strToken.nextToken());
					rec_doc2_desc		= checkForNull(strToken.nextToken());
					rec_doc3_desc		= checkForNull(strToken.nextToken());
					rec_doc4_desc		= checkForNull(strToken.nextToken());
					rec_doc5_desc		= checkForNull(strToken.nextToken());
					pat_bel1_desc		= checkForNull(strToken.nextToken());
					pat_bel2_desc		= checkForNull(strToken.nextToken());
					pat_bel3_desc		= checkForNull(strToken.nextToken());
					pat_bel4_desc		= checkForNull(strToken.nextToken());
					pat_bel5_desc		= checkForNull(strToken.nextToken());
					pat_bel6_desc		= checkForNull(strToken.nextToken());
					pat_bel7_desc		= checkForNull(strToken.nextToken());
					pat_bel8_desc		= checkForNull(strToken.nextToken());
					pat_bel9_desc		= checkForNull(strToken.nextToken());
					pat_bel10_desc		= checkForNull(strToken.nextToken());
					port_recv_yn		= checkForNull(strToken.nextToken());
					received_pf			= checkForNull(strToken.nextToken());
					port_remarks		= checkForNull(strToken.nextToken());
				}
			}

			int res		= 0;
			int srlno   = 0;

			try
			{
				if(toroomno == null || toroomno.equals(""))
				{
					strBuffer.delete(0, strBuffer.length());
					strBuffer.append("Select ROOM_NO from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"'");
					stmt = con.createStatement();
					srs = stmt.executeQuery(strBuffer.toString());
					while(srs.next())
					{
						toroomno = checkForNull(srs.getString("ROOM_NO"));
					}
					if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
				}
				strBuffer.delete(0, strBuffer.length());
				//strBuffer.append(" select age_group_code from IP_NURSING_UNIT where facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' ");
				/*Wednesday, May 05, 2010 , modified for PE*/
				strBuffer.append(" select a.occ_male_bed_count, a.occ_female_bed_count,a.occ_unknown_bed_count,b.age_group_code,b.check_same_sex_in_room_yn,b.allow_emerg_trf_yn,(select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+toroomno+"')ext_num,(select override_yn from ip_transfer_type_vw where transfer_type_code='"+transfertype+"')override_yn,(Select  PSUEDO_BED_STATUS from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+frnursingunitcode+"' And bed_no='"+frbedno+"')PSUEDO_BED_STATUS FROM IP_NURSING_UNIT_ROOM a, IP_NURSING_UNIT b WHERE a.facility_id ='"+facilityId+"' AND b.nursing_unit_code = '"+tonursingunitcode+"' AND  b.facility_id=a.facility_id AND  b.nursing_unit_code = a.nursing_unit_code AND  a.room_no = '"+toroomno+"' ");

				stmt = con.createStatement();
				srs  = stmt.executeQuery(strBuffer.toString());

				if(srs.next())
				{
					String agegrpcode   = srs.getString("age_group_code") == null ? "" : srs.getString("age_group_code");
					check_same_sex_in_room_yn	= srs.getString("check_same_sex_in_room_yn")==null ? "N" : srs.getString("check_same_sex_in_room_yn");
					malebedcount		= srs.getInt("occ_male_bed_count");
					femalebedcount		= srs.getInt("occ_female_bed_count");
					unknownbedcount		= srs.getInt("occ_unknown_bed_count");
					ext_num				= srs.getString("ext_num") == null ? "" : srs.getString("ext_num");
					overrideyn			= srs.getString("override_yn") == null ? "N" : srs.getString("override_yn");
					psedo_bed_staus		= srs.getString("PSUEDO_BED_STATUS") == null ? "" : srs.getString("PSUEDO_BED_STATUS") ;
					if(!agegrpcode.equals(""))
					{
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"' And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND trunc(SYSDATE)- to_date('"+DOB+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");

						if(srs!=null) srs.close();
						if(stmt!=null) stmt.close();
						stmt = con.createStatement();
						srs  = stmt.executeQuery(strBuffer.toString());

						if(!srs.next())
						{
							result = false;
							sb     = new StringBuffer("");
							sb.delete(0, sb.length());
							Hashtable message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
				}
				if(srs!=null) srs.close();
				if(stmt!=null) stmt.close();
			}
				catch(Exception e)
				{
					result  = false;
					sb.append( e.getMessage() +" Error in ValidateIPBedBookingTransfer " ) ;
					e.printStackTrace();
				}


				if(result)
				{
					try
					{
						/*Wednesday, May 05, 2010 , modified for PE query moved to line no 339 */
						/*
						if(toroomno == null || toroomno.equals(""))
						{
							strBuffer.delete(0, strBuffer.length());
							strBuffer.append("Select ROOM_NO from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"'");
							stmt = con.createStatement();
							srs = stmt.executeQuery(strBuffer.toString());
							while(srs.next())
							{
								toroomno = srs.getString("ROOM_NO");
							}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						}
						// Check the target room status
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append(" select a.occ_male_bed_count, a.occ_female_bed_count, a.occ_unknown_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and a.nursing_unit_code='"+tonursingunitcode+"' and  a.room_no='"+toroomno+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
						stmt = con.createStatement();
						srs = stmt.executeQuery(strBuffer.toString());
						if(srs.next())
						{
							int malebedcount    = srs.getInt(1);
							int femalebedcount  = srs.getInt(2);
							int unknownbedcount = srs.getInt(3);
							if(malebedcount > 0) 	L_current_gender      = "M";
							else if(femalebedcount > 0) L_current_gender  = "F";
							else if(unknownbedcount > 0) L_current_gender = "U";
							if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
							{
								result = false;
								Hashtable message = MessageManager.getMessage(locale,"IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						*/
						if(check_same_sex_in_room_yn.equals("Y"))
						{
							if(malebedcount > 0) 	L_current_gender      = "M";
							else if(femalebedcount > 0) L_current_gender  = "F";
							else if(unknownbedcount > 0) L_current_gender = "U";
							if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
					}
					catch(Exception e)
					{
						result = false;
						sb.append("Exception in checking for same gender in a room "+e.toString());
						e.printStackTrace();
					}
				}

				try
					{
						/*Wednesday, May 05, 2010 , commnted for PE , query moved to 354*/
						/*
						if(!(toroomno == null || toroomno.equals("") || toroomno.equals("null")))
						{
							if(strBuffer.length() > 0) strBuffer.delete(0, strBuffer.length());
							strBuffer.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+toroomno+"'");
							stmt = con.createStatement();
							srs = stmt.executeQuery(strBuffer.toString());
							while(srs.next())
							{
								ext_num = srs.getString("EXT_NUM") == null ? "" : srs.getString("ext_num");
							}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						}*/
					}
					catch(Exception e)
					{

						sb.append("Exception in getting EXT_NUM in a room "+e.toString());
						e.printStackTrace();
					}

			if (transfer_in_status.equals("01") && result)
			{
				try
				{
					if (!(tobedno.equals("") || tobedno == null ) && result)
					{


						result = true;
						StringBuffer bed_chk = new StringBuffer();
						bed_chk.append(" Select  sex_spec_ind,Occupying_Patient_Id, bed_type_code, specialty_code,PSEUDO_BED_YN from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"' ");
						stmt=con.createStatement();
						srs = stmt.executeQuery(bed_chk.toString());

						if(!srs.next())
						{
							result = false;
							Hashtable message = MessageManager.getMessage(locale,"INVALID_BED","Common" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else
						{
							String occupyingpatientid = srs.getString("Occupying_Patient_Id") == null ? "" : srs.getString("Occupying_Patient_Id") ;
							String sex_spec_ind = srs.getString("sex_spec_ind") == null ? "" : srs.getString("sex_spec_ind") ;
							tobedtype = srs.getString("bed_type_code")  == null ? "" : srs.getString("bed_type_code");
							String splty_code = srs.getString("specialty_code")==null ? "" : srs.getString("specialty_code");
							pseudo_bed_yn= srs.getString("PSEUDO_BED_YN")==null ? "" : srs.getString("PSEUDO_BED_YN");
							if (!(occupyingpatientid.equals("") || occupyingpatientid.equals(patientid)))
							{

								result = false;

								Hashtable message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else if (!splty_code.equals("") && !splty_code.equals(tospecialitycode)) //Added 		for specialty to bed validation
							{
								result = false;
								Hashtable message = MessageManager.getMessage(locale,"BED_SPLTY_INVALID","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else if (!sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) //Added for gender to bed validation
							{
								result = false;
								transfer_in_status ="0";
								Hashtable message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else
							{
								StringBuffer sql_bed_chk = new StringBuffer();
								String PATIENT_ID ="";

								sql_bed_chk.append("select PATIENT_ID,BOOKING_TYPE,OVERRIDE_YN from ip_bed_booking where FACILITY_ID = '"+facilityId+"' AND REQ_NURSING_UNIT_CODE = '"+tonursingunitcode+"' AND REQ_BED_NO  = '"+tobedno+"' AND booking_status='0' AND sysdate between blocked_from_date_time and blocked_until_date_time ");
								if(srs != null) srs.close();
								if(stmt != null) stmt.close();
								stmt=con.createStatement();
								srs = stmt.executeQuery(sql_bed_chk.toString());

								if(srs.next())
								{
									PATIENT_ID	 = checkForNull(srs.getString("PATIENT_ID"));
									BOOKING_TYPE = checkForNull(srs.getString("BOOKING_TYPE"));
									OVERRIDE_YN = checkForNull(srs.getString("OVERRIDE_YN"));
								}
								if(srs != null) srs.close();
								if(stmt != null) stmt.close();
								if(OVERRIDE_YN.equals("N"))
								{
									if(PATIENT_ID != null)
									{
										//if( PATIENT_ID.equals(patientid) && BOOKING_TYPE.equals("T") )
										/*Monday, February 15, 2010 IN019348 */
										if( PATIENT_ID.equals(patientid) && (BOOKING_TYPE.equals("T") || BOOKING_TYPE.equals("L") ))
										{
											result = true;
										}
										else
										{
											result = false;
											Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP" ) ;
											sb.append( (String) message.get("message") ) ;
											message.clear();
										}
									}
									else
									{
										result = false;
										Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP" ) ;
										sb.append( (String) message.get("message") ) ;
										message.clear();
									}
								}
							}
						}
					}
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking valid bed "+e.toString());
					e.printStackTrace();
				}
				
			/*Below line Added for this SCF GDOH-SCF-0205*/				
				 if(checkTrnasferDate){
                     				 
					   try
						{
							cstmt1=con.prepareCall("{call BL_CHK_TRFR_DATE_ADMN(?,?,?,?,?,?,?)}");
							cstmt1.setString(1,facilityId);
							cstmt1.setString(2,patientid);
							cstmt1.setString(3,episode_type_ipdc);
							cstmt1.setLong(4,encounterid);							
							cstmt1.setString(5,transferdate);
							cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
							cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
							boolean udateTransferdate=cstmt1.execute();	
							String p_err_id=cstmt1.getString(6);
							String p_err_text=cstmt1.getString(7);  
												        	
							
							if(cstmt1 != null) cstmt1.close();
						}
						catch (Exception tre1)
						{
						    result = false;
							tre1.printStackTrace();
						}
				  } 				   
				   //End GDOH-SCF-0205
				
				

			/*Friday, May 14, 2010, update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through following procedure*/
				//if(result && !block_date_time.equals(""))

				if(result && (!block_date_time.equals("") || is_reserved_bed_checked.equals("Y")))
				{
					try
					{
						cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
						cstmt.setString(1,facilityId);
						cstmt.setString(2,"T");
						cstmt.setString(3,"Y");
						cstmt.setString(4,addedAtWorkstation);
						cstmt.setString(5,addedById);
						cstmt.registerOutParameter(6,java.sql.Types.NUMERIC);
						cstmt.execute();
						bed_srlno=cstmt.getInt(6);
						if(cstmt != null) cstmt.close();
					}
					catch (Exception e1)
					{
						result = false;
						e1.printStackTrace();
					}
				}
					/**/

			if(result)
			{
				strBuffer.delete(0, strBuffer.length());
				/*strBuffer.append(" update pr_encounter set ");
				strBuffer.append(" attend_practitioner_id = ? , specialty_code=?, assign_care_locn_type=?, ");
				strBuffer.append(" assign_care_locn_code=?, assign_room_num=? , assign_bed_num = ?, SUBSERVICE_CODE = ?, SERVICE_CODE = ?, INFORMED_TO = ?, INFORMED_NAME = ?, INFORMED_DATE_TIME= to_date(?, 'dd/mm/rrrr hh24:mi'), assign_bed_class_code = ?,ASSIGN_BED_TYPE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate, ROOM_TEL_EXT_NUM = ?  ");
				strBuffer.append(" where facility_id=? and encounter_id = ? ");*/

				strBuffer.append(" update pr_encounter set ");
				strBuffer.append(" attend_practitioner_id = ? , specialty_code=?, assign_care_locn_type=?, ");
				strBuffer.append(" assign_care_locn_code=?, assign_room_num=? , assign_bed_num = ?, SUBSERVICE_CODE = ?, SERVICE_CODE = ?, INFORMED_TO = ?, INFORMED_NAME = ?, INFORMED_DATE_TIME= to_date(?, 'dd/mm/rrrr hh24:mi'), assign_bed_class_code = ?,ASSIGN_BED_TYPE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate, ROOM_TEL_EXT_NUM = ?  ");

				if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("Y"))
					strBuffer.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
				else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("N"))
					strBuffer.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
				else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals(""))

					strBuffer.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
				strBuffer.append(" , modified_by_id = ? , modified_date = sysdate, modified_at_ws_no=? ,modified_facility_id = ? ");
				strBuffer.append(" where facility_id=? and encounter_id = ? ");

				pstmt = con.prepareStatement( strBuffer.toString());
				pstmt.setString	( 1, topractitionerid ) ;
				pstmt.setString	( 2, tospecialitycode ) ;
				pstmt.setString	( 3, tonursingunittype ) ;
				pstmt.setString	( 4, tonursingunitcode ) ;
				pstmt.setString	( 5, toroomno ) ;
				pstmt.setString	( 6, tobedno ) ;
				pstmt.setString	( 7, sub_service ) ;
				pstmt.setString	( 8, service ) ;
				pstmt.setString	( 9, inform_to ) ;
				pstmt.setString	( 10, informed_name ) ;
				pstmt.setString	( 11, info_date_time ) ;
				pstmt.setString	( 12, Bedcode ) ;
				pstmt.setString	( 13, tobedtype ) ;
				pstmt.setString	( 14, tonursingunittype ) ;
				pstmt.setString	( 15, tonursingunitcode ) ;
				pstmt.setString	( 16, ext_num ) ;

				if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("Y"))
				{

						if(is_to_bed_equals_reserve_bed.equals("Y"))
						{

							pstmt.setString	(17, frnursingunitcode ) ;
							pstmt.setString	(18, frroomno ) ;
							pstmt.setString	(19, frbedno ) ;
							new_reserved_bed_no = frbedno;
						}
						else
						{

							pstmt.setString	(17, reserve_nurs_unit_code ) ;
							pstmt.setString	(18, reserve_room_no ) ;
							pstmt.setString	(19, reserve_bed_no ) ;
							new_reserved_bed_no = reserve_bed_no;
						}
						pstmt.setString	(20, addedById ) ;
						pstmt.setString	(21, addedAtWorkstation ) ;
						pstmt.setString	(22, facilityId ) ;
						pstmt.setString	(23, facilityId ) ;
						pstmt.setLong	(24, encounterid ) ;

				}
				else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("N"))
				{

						pstmt.setString	(17, frnursingunitcode ) ;
						pstmt.setString	(18, frroomno ) ;
						pstmt.setString	(19, frbedno ) ;
						pstmt.setString	(20, addedById ) ;
						pstmt.setString	(21, addedAtWorkstation ) ;
						pstmt.setString	(22, facilityId ) ;
						pstmt.setString	(23, facilityId ) ;
						pstmt.setLong	(24, encounterid ) ;
						new_reserved_bed_no = frbedno;

				}
				else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals(""))
				{
					if(!reserve_nurs_unit_code.equals(tonursingunitcode) || reserve_bed_no.equals(tobedno)){
						pstmt.setString	(17, "" ) ;
						pstmt.setString	(18, "" ) ;
						pstmt.setString	(19, "" ) ;
						new_reserved_bed_no = "";
					}
					else{
						pstmt.setString	(17, reserve_nurs_unit_code ) ;
						pstmt.setString	(18, reserve_room_no ) ;
						pstmt.setString	(19, reserve_bed_no ) ;
					}
					pstmt.setString	(20, addedById ) ;
					pstmt.setString	(21, addedAtWorkstation ) ;
					pstmt.setString	(22, facilityId ) ;
					pstmt.setString	(23, facilityId ) ;
					pstmt.setLong	(24, encounterid ) ;	
					
				}
				else
				{

					/*pstmt.setString	(17, reserve_nurs_unit_code ) ;
					pstmt.setString	(18, reserve_room_no ) ;
					pstmt.setString	(19, reserve_bed_no ) ;*/
					pstmt.setString	(17, addedById ) ;
					pstmt.setString	(18, addedAtWorkstation ) ;
					pstmt.setString	(19, facilityId ) ;
					pstmt.setString	(20, facilityId ) ;
					pstmt.setLong	(21, encounterid ) ;
				}



				try
				{
					rs = pstmt.executeUpdate() ;
					if(rs>0 )  result = true; else result = false;
					if(pstmt!=null)pstmt.close();

				}catch(Exception ex)
				{
					result = false;
					ex.printStackTrace();
				}

				String L_practitioner_transfer = "";

				if(result)
				{
					strBuffer.delete(0, strBuffer.length());
					strBuffer.append("select MAX(srl_no)+1 srl_no,to_char((sysdate+'"+block_date_time+"'/24),'dd/mm/rrrr hh24:mi') blocked_until_date from ip_adt_trn where facility_id = ");
					strBuffer.append(" '"+facilityId+"' and encounter_id = "+encounterid+" ");
					stmt   = con.createStatement();
					srs = stmt.executeQuery(strBuffer.toString());

					if(srs.next())
					{
					   srlno = srs.getInt("srl_no");
					   blocked_until_date = srs.getString("blocked_until_date");
					}
					if(srs!=null)srs.close();
					if(stmt!=null)stmt.close();
					L_practitioner_transfer = "N";
					int ress = 0;
					strBuffer.delete(0, strBuffer.length());

					try
					{
						if(srlno > 0 )
						{
							if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								//modified for IN012693 Monday, October 05, 2009
								if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
								{
									strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
								}else
								{
								//modified for 12/15/2008 6021  MF-SCF-0051
									strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = to_date('"+transferdate+"','dd/mm/rrrr hh24:MI') ");
								}
							if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn!=null && confirm_yn.equals("N"))
								strBuffer.append("  , RESERVED_YN = 'Y' ");
							//updating audit columns
							strBuffer.append(", modified_by_id = '" + addedById  + "', modified_date = sysdate, modified_facility_id = '");
							strBuffer.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
							strBuffer.append("  where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");



							if(pstmt !=null) pstmt.close();
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.executeUpdate();
							if(pstmt !=null) pstmt.close();
						}
					}catch(Exception ex)
					{
						result = false;
						sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
						ex.printStackTrace();
					}
					// added for billing on 28/08/08
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

						sbSql.append("select to_bed_type_code,to_bed_type_code_by_defn from IP_ADT_TRN where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
						stmt   = con.createStatement();
						srs	   = stmt.executeQuery(sbSql.toString());
						 if(srs.next())
						{
						   fr_bed_type_code = checkForNull(srs.getString("to_bed_type_code"));
						   fr_bed_type_code_by_defn = checkForNull(srs.getString("to_bed_type_code_by_defn"));
						   if(fr_bed_type_code_by_defn == null || fr_bed_type_code_by_defn.equals(""))
							   fr_bed_type_code_by_defn = fr_bed_type_code;
						}
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();

						//
						if(modified_bed_type_code == null || modified_bed_type_code.equals(""))
						{

							modified_bed_type_code  = tobedtype;
						}

// newly added 09.09.09
					if(fr_bed_type_code == null || fr_bed_type_code.equals(""))
						{
						fr_bed_type_code  = tobedtype;
						}


						strBuffer.delete(0, strBuffer.length());

						strBuffer.append("  insert into IP_ADT_TRN ");
						strBuffer.append(" (facility_id, encounter_id, srl_no, patient_id, trn_type ");
						strBuffer.append(" , trn_code, trn_date_time, to_nursing_unit ");
						strBuffer.append(" , to_room_no, to_bed_no ");
						strBuffer.append(" , to_bed_class_code, to_bed_type_code, to_pract_team_id "); strBuffer.append(" , to_practitioner_id, to_specialty_code ");
						strBuffer.append(" , fr_nursing_unit_code, fr_room_no, fr_bed_no ");
						strBuffer.append(" , fr_bed_class_code, fr_bed_type_code, tfr_type ");
						strBuffer.append(" , emergency_trn_yn, practitioner_tfr_yn ");
						strBuffer.append(" , fr_service_code, fr_subservice_code ");//
						strBuffer.append(" , added_by_id, added_date ");
						strBuffer.append(" , added_facility_id, added_at_ws_no ");
						strBuffer.append(" , modified_by_id, modified_date ");
						strBuffer.append(" , modified_facility_id, modified_at_ws_no ");
						strBuffer.append(" , fr_specialty_code, fr_practitioner_id, from_pract_team_id ");
						strBuffer.append(" , to_service_code, to_subservice_code ");
						strBuffer.append(" , informed_yn, informed_to, informed_name ");
						strBuffer.append(" , informed_date_time, auth_trf_date_time,tfr_req_ref_no ");

						if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
						{
							strBuffer.append(" , transfer_chargeable_yn, trn_charge ");
							strBuffer.append(" , blng_class_code, blng_serv_code, bill_type_code ");
							strBuffer.append(" , fr_bed_type_code_by_defn, to_bed_type_code_by_defn ");
							strBuffer.append(" , to_daily_rate, fr_daily_rate ");
						}
						strBuffer.append(" , patient_class, admission_date_time ");
						strBuffer.append(" ) values ( ");
						//modified for IN012693 Monday, October 05, 2009
						if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
						{
						   //Below line added for GDOH-SCF-0205
						   if(checkTrnasferDate){
							strBuffer.append(" ?, ?, ?, ?, ?, ?, to_date('"+transferdate+"','dd/mm/rrrr hh24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/rrrr hh24:mi'), to_date(?,'dd/mm/rrrr hh24:mi'),?");
						   
						   }else{						  
							strBuffer.append(" ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/rrrr hh24:mi'), to_date(?,'dd/mm/rrrr hh24:mi'),?");
							}
							//End GDOH-SCF-0205
						}else
						{
							//modified for 12/15/2008 6021  MF-SCF-0051
							strBuffer.append(" ?, ?, ?, ?, ?, ?, to_date('"+transferdate+"','dd/mm/rrrr hh24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/rrrr hh24:mi'), to_date(?,'dd/mm/rrrr hh24:mi'),?");
						}

					if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
						strBuffer.append(", ?, ?, ?, ?, ?, ?, ?, ?, ? ");

						strBuffer.append(",'"+patient_class+"',to_date('"+admission_date+"','dd/mm/rrrr hh24:mi') ");
						strBuffer.append(" ) ");
                                             
						pstmt = con.prepareStatement(strBuffer.toString() );
						pstmt.setString	( 1, facilityId );
						pstmt.setLong	( 2, encounterid );
						pstmt.setInt	( 3, srlno );
						pstmt.setString	( 4, patientid);
						pstmt.setString	( 5, "T" );
						pstmt.setString	( 6, transfertype );
						pstmt.setString	( 7, tonursingunitcode );
						pstmt.setString	( 8, toroomno );
						pstmt.setString	( 9, tobedno );
						pstmt.setString	( 10, Bedcode );
						pstmt.setString	( 11, modified_bed_type_code );
						pstmt.setString	( 12, team_id);
						pstmt.setString	( 13, topractitionerid );
						pstmt.setString	( 14, tospecialitycode );
						pstmt.setString	( 15, frnursingunitcode );
						pstmt.setString	( 16, frroomno );
						pstmt.setString	( 17, frbedno );
						pstmt.setString	( 18, frbedclass );
						//pstmt.setString	( 19, frbedtype );
						pstmt.setString	( 19, fr_bed_type_code ) ;
						pstmt.setString	( 20, tfr_type);
						pstmt.setString	( 21, "Y" );
						pstmt.setString	( 22, L_practitioner_transfer );
						pstmt.setString	( 23, frservicecode);
						pstmt.setString	( 24, fr_sub_service_code);
						pstmt.setString	( 25, addedById);
						pstmt.setString	( 26, facilityId );
						pstmt.setString	( 27, addedAtWorkstation );
						pstmt.setString	( 28, addedById );
						pstmt.setString	( 29, facilityId );
						pstmt.setString	( 30, addedAtWorkstation );
						pstmt.setString	( 31, fr_speciality_code);
						pstmt.setString	( 32, fr_practitioner_id);
						pstmt.setString	( 33, fr_team_id);
						pstmt.setString	( 34, service);
						pstmt.setString	( 35, sub_service);
						pstmt.setString	( 36, info_pat_relatives);
						pstmt.setString	( 37, inform_to);
						pstmt.setString	( 38, informed_name);
						pstmt.setString	( 39, info_date_time);
						pstmt.setString	( 40, auth_date_time);
						//modified for 12/15/2008 6021  MF-SCF-0051
						pstmt.setString	( 41, bookingrefno);

					if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
					{
						pstmt.setString	( 42, "N");
						pstmt.setString	( 43, "0");
						pstmt.setString	( 44, blng_class_code );
						pstmt.setString	( 45, blng_serv_code );
						pstmt.setString	( 46, bill_type_code );
						//pstmt.setString	( 46, frbedtype );
						pstmt.setString	( 47, fr_bed_type_code_by_defn ) ;
						//pstmt.setString	( 47, modified_bed_type_code);
						pstmt.setString	( 48, tobedtype);
						pstmt.setInt	( 49, todailycharge );
						pstmt.setInt	( 50, frdailycharge );
					}


						ress = pstmt.executeUpdate() ;
											
						
						if(rs >0 && ress > 0)
							result = true;
						else
						{
							result = false;
							sb.append("Exception in inserting into IP_ADT_TRN");
						}


						if(pstmt !=null)pstmt.close();

				}

				try
					{
						if(result && is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn!=null && confirm_yn.equals("N"))
						{

								int isRecordFound = 0;
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" select count(*) no_of_record from IP_RESERVED_BED_DTL where FACILITY_ID ='"+facilityId+"' and ENCOUNTER_ID = '"+encounterid+"' /* and RESERVED_NURSING_UNIT_CODE = '"+frnursingunitcode+"' and RESERVED_ROOM_NO = '"+frroomno+"' and RESERVED_BED_NO = '"+frbedno+"' */ and RESERVED_TO_TIME is null ");

								if(pstmt!=null)
									pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );

								try
								{
									rset  = pstmt.executeQuery();
								}
								catch(SQLException sqle)
								{
									result = false;
									sb.append("Exception in counter query of  IP_RESERVED_BED_DTL table");
									sqle.printStackTrace();
								}

								if(rset!=null)
								{
									while(rset.next())
									{
										isRecordFound = rset.getInt("no_of_record");
									}
								}

								if(rset!=null)
									rset.close();
								if(pstmt!=null)
									pstmt.close();



							if(isRecordFound>0 && result && allow_multiple_bed_for_resv_yn.equals("N"))
							{
								try
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append(" Update IP_RESERVED_BED_DTL set RESERVED_TO_TIME=sysdate , MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where FACILITY_ID ='"+facilityId+"' and ENCOUNTER_ID = '"+encounterid+"' /* and RESERVED_NURSING_UNIT_CODE = '"+frnursingunitcode+"' and RESERVED_ROOM_NO = '"+frroomno+"' and RESERVED_BED_NO = '"+frbedno+"' */ and RESERVED_TO_TIME is null ");

									pstmt = con.prepareStatement( sbSql.toString() );
									int reset = pstmt.executeUpdate() ;
									if(pstmt!=null)
										pstmt.close();
									if(reset > 0)
									{
										result = true;
									}
									else
									{
										result = false;
										sb.append("Exception in updation IP_RESERVED_BED_DTL table");
									}
								}
								catch (Exception ex)
								{
									ex.printStackTrace();
								}
								
							}
							if(result)
							{
								try
								{
									if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									strBuffer.append(" insert into IP_RESERVED_BED_DTL ");
									strBuffer.append(" ( FACILITY_ID , ENCOUNTER_ID , SRL_NO , RESERVED_NURSING_UNIT_CODE , RESERVED_ROOM_NO , RESERVED_BED_NO , RESERVED_BED_CLASS_CODE , RESERVED_BED_TYPE_CODE , RESERVED_BED_TYPE_CODE_DEFN , RESERVED_FROM_TIME , RESERVED_TO_TIME , ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID ");
									strBuffer.append(" ) values ( '"+facilityId+"', '"+encounterid+"', "+(srlno-1)+",");

									/*if(confirm_yn.equals("Y"))
									{
										strBuffer.append(" '"+reserve_nurs_unit_code+"', '"+reserve_room_no+"', '"+reserve_bed_no+"', '"+reserve_bed_class_code+"', '"+reserve_bed_type_code+"', '"+tobedtype+"' ,");
									}
									else
									{*/
										strBuffer.append(" '"+frnursingunitcode+"', '"+frroomno+"', '"+frbedno+"', '"+frbedclass+"', '"+frbedtype+"', '"+frbedtype+"' ,");
									//}

									strBuffer.append(" sysdate, '', '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+facilityId+"','"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+facilityId+"' ) ");





									int ress = 0;
									if(pstmt!=null)
										pstmt.close();
									pstmt = con.prepareStatement( strBuffer.toString() );
									ress = pstmt.executeUpdate() ;
									if(pstmt!=null)
										pstmt.close();
									if(ress > 0)
									{
										result = true;
									}
									else
									{
										result = false;
										sb.append("Exception in insertion IP_RESERVED_BED_DTL table");
									}
								}
								catch (Exception ex)
								{
									ex.printStackTrace();
								}
							}
						}


					}
					catch (Exception e)
					{
						result = false;
						sb.append("Exception in insertion IP_RESERVED_BED_DTL table "+e.toString());
						e.printStackTrace();
					}

				// By Annadurai 3/10/2004 starts - to insert Porterage Details.
				if(result)
				{
					try
					{
						int  port_srlno = 0;
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select MAX(srl_no)+1 srl_no from pr_porterage_details where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
						stmt   = con.createStatement();
						srs = stmt.executeQuery(sql.toString());
						if(srs.next())
						{
						   port_srlno = srs.getInt("srl_no");
						}
						if(srs !=null)srs.close();
						if(stmt !=null)stmt.close();
						StringBuffer strrBuffer = new StringBuffer();
						strrBuffer.append("INSERT INTO pr_porterage_details (");
						strrBuffer.append("facility_id, encounter_id, srl_no, ");
						strrBuffer.append("adt_srl_no, patient_id, mode_of_transport, ");
						strrBuffer.append("accomp_person1, accomp_person2, accomp_person3, ");
						strrBuffer.append("accomp_person4, accomp_person5, accomp_person6, ");
						strrBuffer.append("accomp_person7, equipment1, equipment2, ");
						strrBuffer.append("equipment3, equipment4, equipment5, ");
						strrBuffer.append("equipment6, equipment7, blood_and_medication1, ");
						strrBuffer.append("blood_and_medication2, blood_and_medication3, blood_and_medication4, ");
						strrBuffer.append("blood_and_medication5, blood_and_medication6, blood_and_medication7, ");
						strrBuffer.append("blood_and_medication8, blood_and_medication9, blood_and_medication10, ");
						strrBuffer.append("records_and_documents1,records_and_documents2,records_and_documents3, ");
						strrBuffer.append("records_and_documents4, records_and_documents5, patient_belongings1, ");
						strrBuffer.append("patient_belongings2, patient_belongings3, patient_belongings4, ");
						strrBuffer.append("patient_belongings5, patient_belongings6, patient_belongings7, ");
						strrBuffer.append("patient_belongings8, patient_belongings9, patient_belongings10, ");
						strrBuffer.append("port_received_yn, port_recd_status, port_recd_remarks, ");
						strrBuffer.append("added_by_id, added_date, added_at_ws_no, ");
						strrBuffer.append("added_at_facility_id, modified_by_id, modified_date, ");
						strrBuffer.append("modified_at_ws_no, modified_at_facility_id) values ( ");
						strrBuffer.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
						strrBuffer.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
						strrBuffer.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
						strrBuffer.append("sysdate,?, ?, ?, ");
						strrBuffer.append("sysdate, ?, ? ) ");
						pstmt = con.prepareStatement( strrBuffer.toString() );

						pstmt.setString	( 1, facilityId ) ;
						pstmt.setLong	( 2, encounterid ) ;
						pstmt.setInt	( 3, port_srlno );
						pstmt.setInt	( 4, srlno );
						pstmt.setString	( 5, patientid );
						pstmt.setString	( 6, Mode_of_Tran_desc );
						pstmt.setString	( 7, acc_per1_desc );
						pstmt.setString	( 8, acc_per2_desc );
						pstmt.setString	( 9, acc_per3_desc );
						pstmt.setString	( 10, acc_per4_desc );
						pstmt.setString	( 11, acc_per5_desc );
						pstmt.setString	( 12, acc_per6_desc );
						pstmt.setString	( 13, acc_per7_desc );
						pstmt.setString	( 14, equip1_desc );
						pstmt.setString	( 15, equip2_desc );
						pstmt.setString	( 16, equip3_desc );
						pstmt.setString	( 17, equip4_desc );
						pstmt.setString	( 18, equip5_desc );
						pstmt.setString	( 19, equip6_desc );
						pstmt.setString	( 20, equip7_desc );
						pstmt.setString	( 21, bld_med1_desc );
						pstmt.setString	( 22, bld_med2_desc );
						pstmt.setString	( 23, bld_med3_desc );
						pstmt.setString	( 24, bld_med4_desc );
						pstmt.setString	( 25, bld_med5_desc );
						pstmt.setString	( 26, bld_med6_desc );
						pstmt.setString	( 27, bld_med7_desc );
						pstmt.setString	( 28, bld_med8_desc );
						pstmt.setString	( 29, bld_med9_desc );
						pstmt.setString	( 30, bld_med10_desc );
						pstmt.setString	( 31, rec_doc1_desc );
						pstmt.setString	( 32, rec_doc2_desc );
						pstmt.setString	( 33, rec_doc3_desc );
						pstmt.setString	( 34, rec_doc4_desc );
						pstmt.setString	( 35, rec_doc5_desc );
						pstmt.setString	( 36, pat_bel1_desc );
						pstmt.setString	( 37, pat_bel2_desc );
						pstmt.setString	( 38, pat_bel3_desc );
						pstmt.setString	( 39, pat_bel4_desc );
						pstmt.setString	( 40, pat_bel5_desc );
						pstmt.setString	( 41, pat_bel6_desc );
						pstmt.setString	( 42, pat_bel7_desc );
						pstmt.setString	( 43, pat_bel8_desc );
						pstmt.setString	( 44, pat_bel9_desc );
						pstmt.setString	( 45, pat_bel10_desc );
						pstmt.setString	( 46, port_recv_yn );
						pstmt.setString	( 47, received_pf );
						pstmt.setString	( 48, port_remarks );
						pstmt.setString	( 49, addedById);
						pstmt.setString	( 50, addedAtWorkstation ) ;
						pstmt.setString	( 51, facilityId ) ;
						pstmt.setString	( 52, addedById ) ;
						pstmt.setString	( 53, addedAtWorkstation ) ;
						pstmt.setString	( 54, facilityId ) ;

						res = 0;
						res = pstmt.executeUpdate() ;
						result = (res >0) ? true : false;
						if(pstmt !=null)pstmt.close();
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}

		if(result)
		{
			try
			{
				int bookRes = 0;
				if (transfer_in_status.equals("01"))
				{
					// By Annadurai 3/11/2004 starts.
					try{
					StringBuffer strBuf	= new StringBuffer();
					strBuf.append("UPDATE ip_transfer_request set TFR_REQ_STATUS = '4', ");
					strBuf.append("modified_by_id = ? , modified_date = sysdate , ");
					strBuf.append("modified_at_ws_no = ? , modified_facility_id = ? ");
					
					if(isArrivalDateAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1136
					strBuf.append(", ARRIVAL_DATE = to_date('"+arrival_date_time+"','dd/mm/rrrr hh24:mi')  ");
				
					strBuf.append("where encounter_id = ? and facility_id = ? and TFR_REQ_REF_NO= ?");
					pstmt = con.prepareStatement( strBuf.toString() );

					pstmt.setString	( 1, addedById ) ;
					pstmt.setString	( 2, addedAtWorkstation ) ;
					pstmt.setString	( 3, facilityId ) ;
					pstmt.setLong	( 4, encounterid ) ;
					pstmt.setString	( 5, facilityId ) ;
					pstmt.setString	( 6, bookingrefno ) ;
					try
					{
						bookRes = pstmt.executeUpdate() ;
					}
					catch(SQLException ex)
					{
						ex.printStackTrace();
					}
					result = (bookRes > 0) ? true : false;
					if(pstmt !=null)pstmt.close();
					}catch(SQLException a10){a10.printStackTrace();}
				}
			}
			catch(Exception ees)
			{
				sb.append("Exception in updating ip_transfer_request :"+ees.toString());
				ees.printStackTrace();
			}
		}
			if(result)
			{
				/*Wednesday, May 05, 2010 , commented for PE , query merged at Line no 713*/
				/*
				String blocked_until_date = "";
				StringBuffer str_block_period = new StringBuffer();
				str_block_period.append("select to_char((sysdate+'"+block_date_time+"'/24),'dd/mm/rrrr hh24:mi') a from dual");

				pstmt = con.prepareStatement(str_block_period.toString());

				try{rset  = pstmt.executeQuery();}
				catch(SQLException sqle){}
				if(rset!=null)
				{
					while(rset.next())
					{
						blocked_until_date = rset.getString("a");
					}
				}


				if(rset !=null)rset.close();
				if(pstmt !=null)pstmt.close();
				*/

				//if(blocked_until_date != null)
				if(blocked_until_date != null || is_reserved_bed_checked.equals("Y"))
				{


					if(is_reserved_bed_checked.equals("Y"))
					{
						blocked_until_date = exp_discharge_date_time; //8698-SRR20056-SCF-2841
						/*Monday, September 06, 2010 , SRR20056-SCF-5122 [IN:023593] ,since EDD is less than sysdate then reserved beds not displaying in Release reserved bed function and in BAC*/
						if((DateUtils.isBefore(exp_discharge_date_time, system_date, "DMYHM", "en")))
							blocked_until_date = "";
					}
					try
					{
						//Removed the condiion below and GEN_BOOKING_SRL_YN = 'Y' on 9/27/2004
						/*Wednesday, May 05, 2010 , commented for PE , merged at line no 356*/
						/*
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append("select NEXT_BOOKING_SRL_NO srl_no from "); strBuffer.append("IP_BED_BOOKING_SRL_CTRL where facility_id = '"+facilityId+"' and BOOKING_TYPE = 'T' ");
						stmt   = con.createStatement();
						srs = stmt.executeQuery(strBuffer.toString());

						if(srs.next())
						{
							bed_srlno = srs.getInt("srl_no");
						}

						if(srs !=null)srs.close();
						if(stmt !=null)stmt.close();
						*/
						/*Friday, May 14, 2010 ,update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO*/
						/*
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append(" Update IP_BED_BOOKING_SRL_CTRL set "); strBuffer.append("NEXT_BOOKING_SRL_NO = NEXT_BOOKING_SRL_NO + 1 ");
						strBuffer.append(" WHERE  facility_id= '"+facilityId+"' and BOOKING_TYPE = 'T' ");
						pstmt = con.prepareStatement( strBuffer.toString());

						int u = pstmt.executeUpdate();

						if(u > 0) {}
						if(pstmt !=null)pstmt.close();
						*/
					}
					catch(Exception sc)
					{
						result = false;
						sb.append("Exception in updating ip_bed_booking_srl_ctrl :"+sc.toString());
					}

				StringBuffer sqlBuffer	= new StringBuffer();

				if(result)
				{
					try
					{
					/*Wednesday, May 05, 2010 ,commented for PE,moved to line no 357*/
					/*
					String overrideyn	="N";
					StringBuffer blocking_date = new StringBuffer();
					blocking_date.append("select OVERRIDE_YN from ip_transfer_type_vw where TRANSFER_TYPE_CODE='"+transfertype+"' ");
					if(rset != null) rset.close(); if(stmt != null) stmt.close();
					stmt=con.createStatement();
					rset = stmt.executeQuery(blocking_date.toString());
					while(rset.next())
					{
						overrideyn=rset.getString("OVERRIDE_YN");
						if(overrideyn == null) overrideyn="N";
					}
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
					*/
					/*sqlBuffer.append("INSERT INTO ip_bed_booking (");
					sqlBuffer.append("FACILITY_ID, BOOKING_TYPE, BED_BOOKING_REF_NO,  BLOCKED_FROM_DATE_TIME, BLOCKED_UNTIL_DATE_TIME,");
					sqlBuffer.append("ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
					sqlBuffer.append("MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
					sqlBuffer.append("REQ_NURSING_UNIT_CODE, REQ_SERVICE_CODE, REQ_BED_NO, REQ_ROOM_NO,");
					sqlBuffer.append("REQ_BED_CLASS_CODE, REQ_BED_TYPE_CODE, REQ_PRACTITIONER_ID, ");
					sqlBuffer.append("REQ_SPECIALTY_CODE,BOOKED_BY_ID, BOOKING_DATE_TIME, BOOKING_STATUS,BLOCKING_TYPE_CODE,BLOCKING_REMARKS,OVERRIDE_YN) values (");
					sqlBuffer.append("?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?)");*/

					if(reserve_bed_on_tfr_yn.equals("Y"))
					{
						int No_Of_Record = 0;

						String counterReserveBed="";
						String counterReserveNursingUnit="";

						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N"))
						{
							counterReserveBed= reserve_bed_no;
							counterReserveNursingUnit = reserve_nurs_unit_code;
						}
						else if(confirm_yn.equals("Y"))
						{
							counterReserveBed= reserve_bed_no;
							counterReserveNursingUnit = reserve_nurs_unit_code;
						}
						else if(confirm_yn.equals("N"))
						{
							counterReserveBed = frbedno;
							counterReserveNursingUnit = frnursingunitcode;
						}

						sqlBuffer.delete(0, sqlBuffer.length());

						//sqlBuffer.append(" select count(1) No_Of_Record FROM IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' and  blocked_until_date_time is null ");
						/* Modified for IP-ICN-6903_Reopen */
						sqlBuffer.append(" select count(1) No_Of_Record FROM IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' and ( blocked_until_date_time is null OR blocked_until_date_time > SYSDATE )");


						try
						{
							if(pstmt != null)	pstmt.close();
							pstmt = con.prepareStatement( sqlBuffer.toString() );
							rset = pstmt.executeQuery() ;
							if(rset!=null && rset.next())
							{
								No_Of_Record = rset.getInt("No_Of_Record");
							}


							if(rset !=null) rset.close();
							if(pstmt !=null) pstmt.close();
						}
						catch(SQLException ex)
						{
							result = false;
							sb.append("Exception in while counter query of ip_bed_booking  :"+ex.toString());
							ex.printStackTrace();
						}

						if(result && No_Of_Record > 0)
						{
							String updateReserveBed="";
							String updateNursingUnitCode = "";

							if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N"))
							{
								updateReserveBed= reserve_bed_no  ;
								updateNursingUnitCode = reserve_nurs_unit_code  ;
							}
							else if(confirm_yn.equals("Y"))
							{
								updateReserveBed = reserve_bed_no ;
								updateNursingUnitCode = reserve_nurs_unit_code;
							}
							else if(confirm_yn.equals("N"))
							{
								updateReserveBed = frbedno  ;
								updateNursingUnitCode = frnursingunitcode;
							}
							if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());

							try
							{
								//sqlBuffer.append("update IP_BED_BOOKING SET blocked_until_date_time = to_date('"+system_date+"','dd/mm/yyyy hh24:mi') WHERE facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' and  blocked_until_date_time is null");

								/* Modified for IP-ICN-6903_Reopen */
								if(allow_multiple_bed_for_resv_yn.equals("N")){
								   //Added Audit column
									sqlBuffer.append("update IP_BED_BOOKING SET blocked_until_date_time = to_date('"+system_date+"','dd/mm/yyyy hh24:mi'), MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' and ( blocked_until_date_time is null OR blocked_until_date_time > SYSDATE )");

									//bookingCon = ConnectionManager.getConnection(p);
									//modified on 10-07-2008 for SCR 3440
									//bookingCon.setAutoCommit(false);
									res = 0;
									//pstmt1 = bookingCon.prepareStatement(sqlBuffer.toString());
									//modified on 10-07-2008 for SCR 3440
									pstmt1 = con.prepareStatement(sqlBuffer.toString());
									res = pstmt1.executeUpdate();
									if(pstmt1 !=null) pstmt1.close();
								}
							}
							catch(SQLException ex)
							{
								result = false;
								sb.append("Exception in while updation of ip_bed_booking  :"+ex.toString());
								ex.printStackTrace();
							}
							result = (res >0) ? true : false;
						}
					}
				if(result)
				{
					try
					{


						if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append("INSERT INTO ip_bed_booking (");
						sqlBuffer.append("FACILITY_ID, BOOKING_TYPE, BED_BOOKING_REF_NO,  BLOCKED_FROM_DATE_TIME, BLOCKED_UNTIL_DATE_TIME,");
						sqlBuffer.append("ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
						sqlBuffer.append("MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
						sqlBuffer.append("REQ_NURSING_UNIT_CODE, REQ_SERVICE_CODE, REQ_BED_NO, REQ_ROOM_NO,");
						sqlBuffer.append("REQ_BED_CLASS_CODE, REQ_BED_TYPE_CODE, REQ_PRACTITIONER_ID, ");
						sqlBuffer.append("REQ_SPECIALTY_CODE,BOOKED_BY_ID, BOOKING_DATE_TIME, BOOKING_STATUS,BLOCKING_TYPE_CODE,BLOCKING_REMARKS,OVERRIDE_YN ");

						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
							sqlBuffer.append(", PATIENT_ID,ENCOUNTER_ID ");
						sqlBuffer.append(" ) values (");
						sqlBuffer.append("?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?");
						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
							sqlBuffer.append(",?,? ");
						sqlBuffer.append(")");

						pstmt2 = con.prepareStatement( sqlBuffer.toString() );

						pstmt2.setString	( 1, facilityId ) ;
						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
							pstmt2.setString	( 2, "N" ) ;
						else
							pstmt2.setString	( 2, "T" ) ;
						pstmt2.setInt	( 3, bed_srlno);
						pstmt2.setString	( 4, blocked_until_date);
						pstmt2.setString	( 5, addedById);
						pstmt2.setString	( 6, addedAtWorkstation);
						pstmt2.setString	( 7, facilityId);
						pstmt2.setString	( 8, addedById);
						pstmt2.setString	( 9, addedAtWorkstation);
						pstmt2.setString	( 10, facilityId);

						if(confirm_yn.equals("Y"))
						{
							pstmt2.setString	( 11, reserve_nurs_unit_code);
							pstmt2.setString	( 12, reserve_service_code);
							pstmt2.setString	( 13, reserve_bed_no);
							pstmt2.setString	( 14, reserve_room_no);
							pstmt2.setString	( 15, reserve_bed_class_code);
							pstmt2.setString	( 16, reserve_bed_type_code);
							pstmt2.setString	( 17, reserve_practitioner_id);
							pstmt2.setString	( 18, reserve_specialty_code);
						}
						else
						{
							pstmt2.setString	( 11, frnursingunitcode);
							pstmt2.setString	( 12, frservicecode);
							pstmt2.setString	( 13, frbedno);
							pstmt2.setString	( 14, frroomno);
							pstmt2.setString	( 15, frbedclass);
							pstmt2.setString	( 16, frbedtype);
							pstmt2.setString	( 17, fr_practitioner_id);
							pstmt2.setString	( 18, fr_speciality_code);
						}

						pstmt2.setString	( 19, addedById);
						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
							pstmt2.setString	( 20, "1");
						else
							pstmt2.setString	( 20, "0");
						//pstmt2.setString	( 21, block_type_code);

						if((reason_for_reserved_bed==null || reason_for_reserved_bed.equals("")))
							pstmt2.setString	( 21, block_type_code);
						else
							pstmt2.setString	( 21, reason_for_reserved_bed);
						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
							pstmt2.setString	( 22, "");
						else
							pstmt2.setString	( 22, bed_block_remark);
						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
							pstmt2.setString	( 23, "N");
						else
							pstmt2.setString	( 23, overrideyn);

						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
						{
							pstmt2.setString	( 24, patientid);
							pstmt2.setString	( 25, encounter_id);
						}
					try
					{
						res = 0;
						res = pstmt2.executeUpdate() ;
						result = (res >0) ? true : false;
						if(pstmt2 != null)	pstmt2.close();
					}
					catch(SQLException exx)
					{
						result=false;
						exx.printStackTrace();
					}

					}
					catch(SQLException ex)
					{
						result=false;
						ex.printStackTrace();
					}

				}

				}catch(Exception se)
				{
					result = false;
					sb.append("Exception in updating ip_bed_booking :"+se.toString());
					se.printStackTrace();
				}
			   }
			 }

		if((blocked_until_date == null || blocked_until_date.equals("")) && is_reserved_bed_checked.equals("N") && allow_multiple_bed_for_resv_yn.equals("N"))
				{
					StringBuffer sqlBuffer	= new StringBuffer();
					if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());

					//sqlBuffer.append("select Count(*) Total_Record FROM ip_bed_booking WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND booking_type='N'  AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' AND BLOCKED_UNTIL_DATE_TIME IS NULL ");

					/* Modified for IP-ICN-6903_Reopen */
					sqlBuffer.append("select Count(*) Total_Record FROM ip_bed_booking WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND booking_type='N'  AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' AND ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");

					int No_Of_Record = 0;
					try
					{
						if(pstmt != null)	pstmt.close();
						pstmt = con.prepareStatement( sqlBuffer.toString() );
						srs = pstmt.executeQuery() ;
						if(srs!=null && srs.next())
						{
							No_Of_Record = srs.getInt("Total_Record");
						}

						if(srs !=null) srs.close();
						if(pstmt !=null) pstmt.close();
					}
					catch(SQLException ex)
					{
						result = false;
						sb.append("Exception in while counter query of second ip_bed_booking  :"+ex.toString());
						ex.printStackTrace();
					}
					if(!reserve_nurs_unit_code.equals(tonursingunitcode)){///* Modified for IP-ICN-6903_Reopen */
					if(result && No_Of_Record>0)
					{
						if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());

						//sqlBuffer.append("update ip_bed_booking SET booking_type='T' ,BLOCKED_UNTIL_DATE_TIME = sysdate WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' and BLOCKED_UNTIL_DATE_TIME IS NULL ");

						/* Modified for IP-ICN-6903_Reopen */ //Added Audit column
						sqlBuffer.append("update ip_bed_booking SET booking_type='T' ,BLOCKED_UNTIL_DATE_TIME = sysdate, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' and ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");

						try
						{
							if(pstmt != null)	pstmt.close();
							pstmt = con.prepareStatement( sqlBuffer.toString() );
							int updated = pstmt.executeUpdate();

							result = (updated > 0) ? true : false;
							if(pstmt !=null) pstmt.close();
						}
						catch (SQLException ex)
						{
							result = false;
							sb.append("Exception in while updating  ip_bed_booking query :"+ex.toString());
							ex.printStackTrace();
						}
						if(result)
						{
							if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
							sqlBuffer.append("select Count(*) Total_Record FROM IP_RESERVED_BED_DTL WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and RESERVED_NURSING_UNIT_CODE = '"+reserve_nurs_unit_code+"' AND RESERVED_BED_NO = '"+reserve_bed_no+"' AND  RESERVED_TO_TIME  IS null");

							int Reserve_Bed_No_Of_Record = 0;
							
							
							
							try
							{
								if(pstmt != null)	pstmt.close();
								pstmt = con.prepareStatement( sqlBuffer.toString() );
								srs = pstmt.executeQuery() ;
								if(srs!=null && srs.next())
								{
									Reserve_Bed_No_Of_Record = srs.getInt("Total_Record");
								}
								if(srs !=null) srs.close();
								if(pstmt !=null) pstmt.close();
							}
							catch(SQLException ex)
							{
								result = false;
								sb.append("Exception in while counter query of second IP_RESERVED_BED_DTL  :"+ex.toString());
								ex.printStackTrace();
							}
							if(result && Reserve_Bed_No_Of_Record>0)
							{
								if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
								//Added Audit column
								sqlBuffer.append("UPDATE IP_RESERVED_BED_DTL SET   RESERVED_TO_TIME  = SYSDATE, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and  RESERVED_NURSING_UNIT_CODE = '"+reserve_nurs_unit_code+"' AND RESERVED_BED_NO = '"+reserve_bed_no+"' AND  RESERVED_TO_TIME  IS null");

								try
								{
									if(pstmt != null)	pstmt.close();
									pstmt = con.prepareStatement( sqlBuffer.toString() );
									int updated = pstmt.executeUpdate();
									result = (updated > 0) ? true : false;
									if(pstmt !=null) pstmt.close();
								}
								catch (SQLException ex)
								{
									result = false;
									sb.append("Exception in while updating  IP_RESERVED_BED_DTL query :"+ex.toString());
									ex.printStackTrace();
								}
							}
						}
					}
					}/*Modified for IP-ICN-6903_Reopen close for line 1449*/
						else if(reserve_bed_no.equals(tobedno)){
							if(result && No_Of_Record>0)
							{
								if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());

								//sqlBuffer.append("update ip_bed_booking SET booking_type='T' ,BLOCKED_UNTIL_DATE_TIME = sysdate WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' and BLOCKED_UNTIL_DATE_TIME IS NULL ");

								/* Modified for IP-ICN-6903_Reopen */
								//Added Audit column
								sqlBuffer.append("update ip_bed_booking SET booking_type='T' ,BLOCKED_UNTIL_DATE_TIME = sysdate, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' and ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");



							try
								{
									if(pstmt != null)	pstmt.close();
									pstmt = con.prepareStatement( sqlBuffer.toString() );
									int updated = pstmt.executeUpdate();
									result = (updated > 0) ? true : false;
									if(pstmt !=null) pstmt.close();
								}
								catch (SQLException ex)
								{
									result = false;
									sb.append("Exception in while updating  ip_bed_booking query :"+ex.toString());
									ex.printStackTrace();
								}
								if(result)
								{
									if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
									sqlBuffer.append("select Count(*) Total_Record FROM IP_RESERVED_BED_DTL WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and RESERVED_NURSING_UNIT_CODE = '"+reserve_nurs_unit_code+"' AND RESERVED_BED_NO = '"+reserve_bed_no+"' AND  RESERVED_TO_TIME  IS null");

									int Reserve_Bed_No_Of_Record = 0;
									try
									{
										if(pstmt != null)	pstmt.close();
										pstmt = con.prepareStatement( sqlBuffer.toString() );
										srs = pstmt.executeQuery() ;
										if(srs!=null && srs.next())
										{
											Reserve_Bed_No_Of_Record = srs.getInt("Total_Record");
										}

										if(srs !=null) srs.close();
										if(pstmt !=null) pstmt.close();
									}
									catch(SQLException ex)
									{
										result = false;
										sb.append("Exception in while counter query of second IP_RESERVED_BED_DTL  :"+ex.toString());
										ex.printStackTrace();
									}
									if(result && Reserve_Bed_No_Of_Record>0)
									{
										if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
										//Added audit column
										sqlBuffer.append("UPDATE IP_RESERVED_BED_DTL SET   RESERVED_TO_TIME  = SYSDATE, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and  RESERVED_NURSING_UNIT_CODE = '"+reserve_nurs_unit_code+"' AND RESERVED_BED_NO = '"+reserve_bed_no+"' AND  RESERVED_TO_TIME  IS null");

										try
										{
											if(pstmt != null)	pstmt.close();
											pstmt = con.prepareStatement( sqlBuffer.toString() );
											int updated = pstmt.executeUpdate();

											result = (updated > 0) ? true : false;
											if(pstmt !=null) pstmt.close();
										}
										catch (SQLException ex)
										{
											result = false;
											sb.append("Exception in while updating  IP_RESERVED_BED_DTL query :"+ex.toString());
											ex.printStackTrace();
										}
									}
								}
							}
					}/*Modified for IP-ICN-6903_Reopen close for line 1519*/
				}
			}
				if(result)
				{
					if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
						//strBuffer.append("select Count(*) Total_Record FROM ip_bed_booking WHERE FACILITY_ID = '"+facilityId+"' AND  patient_id = '"+patientid+"'  and booking_status='0' and  REQ_NURSING_UNIT_CODE= '"+tonursingunitcode+"'  AND REQ_BED_NO= '"+tobedno+"' AND  BLOCKED_UNTIL_DATE_TIME IS NOT null ");

						/* Modified for IP-ICN-6903_Reopen */
						strBuffer.append("select Count(*) Total_Record FROM ip_bed_booking WHERE FACILITY_ID = '"+facilityId+"' AND  patient_id = '"+patientid+"'  and booking_status in ('0','1') and  REQ_NURSING_UNIT_CODE= '"+tonursingunitcode+"'  AND REQ_BED_NO= '"+tobedno+"' AND  ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");

						int blocked_bed_record = 0;

						try
							{
								if(pstmt != null)	pstmt.close();
								pstmt = con.prepareStatement( strBuffer.toString() );
								srs = pstmt.executeQuery() ;
								if(srs!=null && srs.next())
								{
									blocked_bed_record = srs.getInt("Total_Record");
								}
								if(srs !=null) srs.close();
								if(pstmt !=null) pstmt.close();
							}
							catch(SQLException ex)
							{
								result = false;
								sb.append("Exception in while counter query of ip_bed_booking for no of block bed record  :"+ex.toString());
								ex.printStackTrace();
							}

							if(result && blocked_bed_record>0)
							{

								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									//strBuffer.append("update ip_bed_booking SET booking_status='2' WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+tonursingunitcode+"' AND REQ_BED_NO= '"+tobedno+"' and BLOCKED_UNTIL_DATE_TIME IS NOT null  ");

									/* Modified for IP-ICN-6903_Reopen */ //Added Audit column
									strBuffer.append("update ip_bed_booking SET booking_status='2', MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+tonursingunitcode+"' AND REQ_BED_NO= '"+tobedno+"' and ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE)  ");

									try
									{
										if(pstmt != null)	pstmt.close();
										pstmt = con.prepareStatement( strBuffer.toString() );
										int updated = pstmt.executeUpdate();

										result = (updated > 0) ? true : false;
										if(pstmt !=null) pstmt.close();

										if(!result)
											sb.append("record is not updated because no record found in table ip_bed_booking for update query");

									}
									catch (SQLException ex)
									{
										result = false;
										sb.append("Exception in while updating  ip_bed_booking query for final status :"+ex.toString());
										ex.printStackTrace();
									}
							}
/*Monday, August 16, 2010 , modified for SRR20056-SCF-4961 [IN:023143] , to close blocked status(if any) of selected to_bed.*/
							if(result && blocked_bed_record == 0)
							{
								if(OVERRIDE_YN.equals("Y") && !(BOOKING_TYPE.equals("L")|| BOOKING_TYPE.equals("N")))
								{
									try
									{
										if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
										strBuffer.append("update ip_bed_booking set booking_status = ? , cancelled_by_id = ?,  cancellation_date_time = sysdate, modified_by_id=?, modified_date = sysdate,  modified_at_ws_no= ?,  modified_facility_id =?   where facility_id = ? and booking_type = ? and req_nursing_unit_code = ? and req_bed_no = ? and req_room_no = ? and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ");
										pstmt = con.prepareStatement(strBuffer.toString());
										pstmt.setString	( 1, "9");
										pstmt.setString	( 2, addedById);
										pstmt.setString	( 3, addedById);
										pstmt.setString	( 4, addedAtWorkstation);
										pstmt.setString	( 5, facilityId);
										pstmt.setString	( 6, facilityId);
										pstmt.setString	( 7, BOOKING_TYPE);
										pstmt.setString	( 8, tonursingunitcode);
										pstmt.setString	( 9, tobedno);
										pstmt.setString	( 10, toroomno);
										int count = pstmt.executeUpdate() ;
										result = (count > 0) ? true : false;
									
										if(pstmt !=null) pstmt.close();
									}
									catch (Exception e)
									{
										e.printStackTrace();
									}
								}
								
							}
							/*Tuesday, December 22, 2009 IN017411 to update RESERVED_TO_TIME in IP_RESERVED_BED_DTL when to bed no is reserved bed no.*/
							if(result)
								{
									if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									strBuffer.append("select RESERVED_NURSING_UNIT_CODE,RESERVED_BED_NO FROM IP_RESERVED_BED_DTL WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and  RESERVED_TO_TIME  IS null");

									//int Reserve_Bed_No_Of_Record = 0;

									try
									{
										if(pstmt != null)	pstmt.close();
										pstmt = con.prepareStatement( strBuffer.toString() );
										srs = pstmt.executeQuery() ;
										if(srs!=null)
										{
											while(srs.next())
											{
												reserveBedArray.add(srs.getString("RESERVED_BED_NO"));
												reserveNuArray.add(srs.getString("RESERVED_NURSING_UNIT_CODE")); 
											}
										}

										if(srs !=null) srs.close();
										if(pstmt !=null) pstmt.close();
									}
									catch(SQLException ex)
									{
										result = false;
										sb.append("Exception in while counter query of second IP_RESERVED_BED_DTL  :"+ex.toString());
										ex.printStackTrace();
									}
									if(result && reserveNuArray.contains(tonursingunitcode) && reserveBedArray.contains(tobedno))
									{
										if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
										//Added Audit column
										strBuffer.append("UPDATE IP_RESERVED_BED_DTL SET   RESERVED_TO_TIME  = SYSDATE, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and  RESERVED_NURSING_UNIT_CODE = '"+tonursingunitcode+"' AND RESERVED_BED_NO = '"+tobedno+"' AND  RESERVED_TO_TIME  IS null");

										try
										{
											if(pstmt != null)	pstmt.close();
											pstmt = con.prepareStatement( strBuffer.toString() );
											int updated = pstmt.executeUpdate();

											result = (updated > 0) ? true : false;
											if(pstmt !=null) pstmt.close();

										}
										catch (SQLException ex)
										{
											result = false;
											sb.append("Exception in while updating  IP_RESERVED_BED_DTL query :"+ex.toString());
											ex.printStackTrace();
										}
									}
								}
							/**/
				}

				if(result)
				{
					if(!frnursingunitcode.equals(tonursingunitcode))
					{
						StringBuffer sql2 = new StringBuffer();
						int res2		  = 0;
						try
						{  //Added Audit column
							sql2.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied +1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = ? and nursing_unit_code = ? ");
							pstmt = con.prepareStatement(sql2.toString());

							pstmt.setString	( 1, facilityId);
							pstmt.setString	( 2, tonursingunitcode ) ;

							res2 = pstmt.executeUpdate() ;
							if(pstmt != null)pstmt.close();
							
						}
						catch (Exception es)
						{
							es.printStackTrace();
						}
						
						try
						{
							if(sql2.length() > 0) sql2.delete(0,sql2.length());
							//Added Audit column
							sql2.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied -1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = ? and nursing_unit_code = ? ");
							pstmt = con.prepareStatement(sql2.toString());

							pstmt.setString	( 1, facilityId);
							pstmt.setString	( 2, frnursingunitcode ) ;
							res2 = pstmt.executeUpdate() ;
							if(res2>0 )  result = true; else result = false;
							if(pstmt != null)	pstmt.close();
						}
						catch (Exception es1)
						{
							es1.printStackTrace();
						}

					}
				}

					int L_male_count = 0;
					int L_female_count = 0;
					int L_unknown_count = 0;

					if(patientgender.equals("M")) L_male_count = 1;
					if(patientgender.equals("F")) L_female_count = 1;
					if(patientgender.equals("U")) L_unknown_count = 1;
					if(!frroomno.equals(toroomno))
					{
						  StringBuffer sql3 = new StringBuffer();

						if(result)
						{
							try
							{
								if(sql3.length() > 0) sql3.delete(0,sql3.length());
								//Added audit column
								sql3.append(" update ip_nursing_unit_room set occ_male_bed_count=occ_male_bed_count+?,occ_female_bed_count=occ_female_bed_count+?,occ_unknown_bed_count=occ_unknown_bed_count+?,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ? where facility_id=? and nursing_unit_code = ? and room_no = ? ");

								pstmt = con.prepareStatement(sql3.toString());

								pstmt.setInt	( 1, L_male_count ) ;
								pstmt.setInt	( 2, L_female_count);
								pstmt.setInt	( 3, L_unknown_count);
								//Added Audit column
								pstmt.setString	( 4, addedById);
								pstmt.setString	( 5, addedAtWorkstation);
								pstmt.setString	( 6, facilityId);
								
								pstmt.setString	( 7, facilityId);
								pstmt.setString	( 8, tonursingunitcode ) ;
								pstmt.setString	( 9, toroomno ) ;
								int res3 = pstmt.executeUpdate() ;
								if(res3>0 )  result = true; else result = false;
							}
							catch (Exception ep)
							{
								ep.printStackTrace();
							}
						}
						if(pstmt != null)pstmt.close();

						if(result)
						{
							try
							{
								if(sql3.length() > 0) sql3.delete(0,sql3.length());

							   //Added Audit column
								sql3.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count-?, occ_female_bed_count = occ_female_bed_count-?, occ_unknown_bed_count = occ_unknown_bed_count-?,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where facility_id=? and nursing_unit_code = ? and room_no = ? ");
								pstmt = con.prepareStatement(sql3.toString());

								pstmt.setInt	( 1, L_male_count ) ;
								pstmt.setInt	( 2, L_female_count);
								pstmt.setInt	( 3, L_unknown_count);
								//Added Audit column
								pstmt.setString	( 4, addedById);
								pstmt.setString	( 5, addedAtWorkstation);
								pstmt.setString	( 6, facilityId);								
								
								pstmt.setString	( 7, facilityId);
								pstmt.setString	( 8, frnursingunitcode ) ;
								pstmt.setString	( 9, frroomno ) ;
								int ress3=0;

								ress3 = pstmt.executeUpdate();
								if(ress3>0 )  result = true; else result = false;
								if(pstmt != null)pstmt.close();
							}catch(Exception e)
							{
								e.printStackTrace();
							}

						}
					}
					if((!frnursingunitcode.equals(tonursingunitcode)) || (!frbedno.equals(tobedno)))
					{
						//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035 -- start
						
						if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
							//Logic to retrieve number of babies linked with the mother as part of HSA-CRF-0035
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							
							sbSql.append("SELECT OCCUPYING_PATIENT_ID FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND mothers_patient_id = ?");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, frnursingunitcode);
							pstmt.setString	( 3, patientid) ;
							srs = pstmt.executeQuery();
							while(srs.next())
							{
								babyPatientId.add(srs.getString("OCCUPYING_PATIENT_ID"));
								babyCount++;
							}
							if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
							
							//for the babies linked with the mother, bed should be assigned. 
							//Step 1 - Retrieve Bed no from ip_nursing_unit_bed table
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							/*sbSql.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' and rownum <= ?");*/							
							/*Above line commented and below line added for this SCF ML-MMOH-SCF-0663*/
							sbSql.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' order by bed_no asc");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, tonursingunitcode);
							pstmt.setString	( 3, tobedno) ;
							//pstmt.setInt	( 4, babyCount) ; //Commented for this SCF ML-MMOH-SCF-0663
							srs = pstmt.executeQuery();
							//Below line modified for this SCF ML-MMOH-SCF-0663
							while(srs.next() && transferBabyCount<babyCount)
							{   
							    //Below line added for this SCF ML-MMOH-SCF-0663								
							    babyBedNo.add(srs.getString("bed_no")) ;							 								
								transferBabyCount++;
								//End this ML-MMOH-SCF-0663
							}
							
							if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
																							
							//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035 -- End
						}
						
					   if(result)
						{
							try
							{
								//Added by kishore on 9/28/2004 for new born regist
								sbSql.delete(0,sbSql.length());
								sbSql.append(" update ip_nursing_unit_bed set ");
								sbSql.append("occupying_patient_id = ? ");
								sbSql.append(", occupied_until_date_time = ? ");
								sbSql.append(", current_status = 'A', modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ?");
								if(psedo_bed_staus.equals("U"))
								sbSql.append(", psuedo_bed_status = 'C'");
								sbSql.append(" where facility_id = ? and nursing_unit_code = ? and");
								sbSql.append(" bed_no = ? ");
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString	( 1, null ) ;
								pstmt.setString	( 2, null ) ;
								pstmt.setString	( 3, facilityId);
								pstmt.setString	( 4, addedById) ;
								pstmt.setString	( 5, addedAtWorkstation) ;
								pstmt.setString	( 6, facilityId);
								pstmt.setString	( 7, frnursingunitcode ) ;
								pstmt.setString	( 8, frbedno ) ;
								int rres4 = pstmt.executeUpdate() ;
								if(rres4>0 )  result = true; else result = false;
								if(pstmt!=null)pstmt.close();
								if(mother_bed_status.equals("Y") && result)
								{
									rres4=0;
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append(" update ip_nursing_unit_bed set ");
									sbSql.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_patient_id = ?, mothers_encounter_id = ?, current_status = 'A', modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
									if(psedo_bed_staus.equals("U"))
									sbSql.append(", psuedo_bed_status = 'C'");
									sbSql.append(" where facility_id=? and nursing_unit_code = ? and main_bed_no = ?");
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, null ) ;
									pstmt.setString	( 2, null ) ;
									pstmt.setString	( 3, null ) ;
									pstmt.setString	( 4, null ) ;
									pstmt.setString	( 5, facilityId);
									pstmt.setString	( 6, addedById) ;
									pstmt.setString	( 7, addedAtWorkstation) ;
									pstmt.setString	( 8, facilityId);
									pstmt.setString	( 9, frnursingunitcode ) ;
									pstmt.setString	( 10, frbedno ) ;
									rres4 = pstmt.executeUpdate() ;
									if(rres4>0 )  result = true; else result = false;
									if(pstmt!=null)pstmt.close();

								}	
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
					if(result)
						{
							try
							{
								/*Wednesday, May 05, 2010 , commented for PE moved to 357 */
								/*
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append(" Select  PSUEDO_BED_STATUS from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+frnursingunitcode+"' And bed_no='"+frbedno+"' ");
									stmt=con.createStatement();
									srs = stmt.executeQuery(sbSql.toString());

									if(srs.next())
									{
										psedo_bed_staus = srs.getString("PSUEDO_BED_STATUS") == null ? "" : srs.getString("PSUEDO_BED_STATUS") ;
									}
								if(srs != null)srs.close();
								*/
								sbSql.delete(0,sbSql.length());
								sbSql.append(" update ip_nursing_unit_bed set ");
								sbSql.append(" occupying_patient_id = ?, current_status='O' ");
								//Updating audit columns:
								sbSql.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
								
								if(deactivate_pseudo_bed_yn.equals("Y") && pseudo_bed_yn.equals("Y"))
								sbSql.append(", psuedo_bed_status = 'U'");
								sbSql.append(" where  facility_id = ? and nursing_unit_code = ? and");
								sbSql.append(" bed_no = ? and occupying_patient_id is null and current_status='A'");

								pstmt = con.prepareStatement(sbSql.toString());

								pstmt.setString	( 1, patientid ) ;
								pstmt.setString	( 2, facilityId);
								pstmt.setString	( 3, addedById) ;
								pstmt.setString	( 4, addedAtWorkstation) ;
								
								pstmt.setString	( 5, facilityId);
								pstmt.setString	( 6, tonursingunitcode ) ;
								pstmt.setString	( 7, tobedno ) ;
								int res4 = pstmt.executeUpdate() ;
								//if(res4>0 )  result = true; else result = false;	
                               								
								if(res4>0 ){ 
									result = true;
								}else{ 
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
								
								//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- start
								if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								try {
									for(int bcount=0;bcount<babyPatientId.size();bcount++){
										
										if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
										
										sbSql.append(" update ip_nursing_unit_bed set ");
									    sbSql.append(" mothers_patient_id=?,mothers_encounter_id=?,current_status='O',occupying_patient_id = ?,modified_date=sysdate,modified_facility_id=?,modified_by_id=?,modified_at_ws_no=? ");
										sbSql.append(" where facility_id=? and nursing_unit_code =?  and main_bed_no=? and bed_no=?");
										
										pstmt=con.prepareStatement(sbSql.toString());
										
										pstmt.setString	( 1, patientid); //Mother Patient id
										pstmt.setString	( 2, enid); // Mother Encounter id
										pstmt.setString	( 3, babyPatientId.get(bcount)); // Baby Patient Id
										pstmt.setString	( 4, facilityId);
										pstmt.setString	( 5, addedById) ;
										pstmt.setString	( 6, addedAtWorkstation);
										pstmt.setString	( 7, facilityId);
										pstmt.setString	( 8, tonursingunitcode);//Mother Nursing nuit
										pstmt.setString	( 9, tobedno);  //Mother bed no
										pstmt.setString	( 10, babyBedNo.get(bcount));  //Baby bed no
										res4 = pstmt.executeUpdate() ;
										if(pstmt !=null) pstmt.close();
										if(res4 > 0) result = true; else result = false;
									}
								} catch (Exception ex) {
									sb.append("Exception in updating ip_nursing_unit_bed while updating the destination baby beds : "+ex.toString());
									ex.printStackTrace();
								}
								}
								//Logic to relink the mother and the baby bed for the crf HSA-CRF-0035
								if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								
								
								try {
									sbSql.append(" update ip_open_encounter set ");
									sbSql.append("BABY_DELINKED_YN='N' ");
									sbSql.append(", modified_by_id = ? ,modified_at_ws_no = ?, modified_date = sysdate,modified_facility_id = ? ");
									sbSql.append(" where facility_id=? and ENCOUNTER_ID = ?");
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, addedById) ;
									pstmt.setString	( 2, addedAtWorkstation);
									pstmt.setString	( 3, facilityId);
									pstmt.setString	( 4, facilityId);
									pstmt.setString	( 5, enid); //mother encounter id
									res4 = pstmt.executeUpdate() ;
									if(pstmt !=null) pstmt.close();
									if(res4 > 0) result = true; else result = false;
								} catch (Exception ex) {
									
									sb.append("Exception in updating ip_open_encounter while relinking the mother and baby bed : "+ex.toString());
									ex.printStackTrace();
								}
								}
								//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- End
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}

						}
						if(pstmt != null)pstmt.close();
					}
				 }

				if(result)
				{
					int count = 0;
					try
					{
						if(strBuffer.length() > 0) strBuffer.delete(0, strBuffer.length());
						if(pstmt != null) pstmt.close();
						strBuffer.append(" update IP_OPEN_ENCOUNTER set ");
						strBuffer.append(" TFR_REQ_STATUS = '', ");
						/*
						11/15/2008 CRF 3698 SRR20056-CRF-0228 test append code
						*/
						/*Wednesday, May 12, 2010 , update in ip_open_encounter will done through trigger IP_PR_ENCNTR_UPD_OPEN_ENC_TRG in Pr_encounter
						if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y")){
						strBuffer.append(" RESERVED_BED_NO= '"+frbedno+"', ");
						strBuffer.append(" RESERVED_ROOM_NO= '"+frroomno+"', ");
						strBuffer.append(" RESERVED_NURS_UNIT_CODE= '"+frnursingunitcode+"', ");
						}else {
							if(!reserve_nurs_unit_code.equals(tonursingunitcode) || reserve_bed_no.equals(tobedno)){
							strBuffer.append(" RESERVED_BED_NO= '', ");
							strBuffer.append(" RESERVED_ROOM_NO= '', ");
							strBuffer.append(" RESERVED_NURS_UNIT_CODE= '', ");
						}
							else{
								strBuffer.append(" RESERVED_BED_NO= '"+reserve_bed_no+"', ");
								strBuffer.append(" RESERVED_ROOM_NO= '"+reserve_room_no+"', ");
								strBuffer.append(" RESERVED_NURS_UNIT_CODE= '"+reserve_nurs_unit_code+"', ");
							}
						}*/
						// end
						strBuffer.append(" modified_by_id = ?, ");
						strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate, ROOM_TEL_EXT_NUM = ?,modified_facility_id = ? ");
						strBuffer.append(" where ");
						strBuffer.append(" facility_id = ? and encounter_id = ?");

						pstmt = con.prepareStatement(strBuffer.toString());
						pstmt.setString(1, addedById);
						pstmt.setString(2, addedAtWorkstation);
						pstmt.setString(3, ext_num);
						pstmt.setString(4, facilityId); //Added audit column
						pstmt.setString(5, facilityId);
						pstmt.setLong(6, encounterid);
						count = pstmt.executeUpdate();
						if(count > 0)
							result = true;
						else
							result = false;
						if(pstmt != null)
							pstmt.close();


					}catch(Exception ex)
					{
						result = false;
						sb.append("error while updating into ip_open_encounter " + ex.getMessage());
						ex.printStackTrace(System.out);
					}
				}
			}
			else if(result)
			{
					int bookResult = 0;
					if (transfer_in_status.equals("02"))
					{   
					 boolean isSkipCancelTransOutAppl=CommonBean.isSiteSpecific(con,"IP","SKIP_CAN_TRANS_PAT_OUT_APPL_YN");
						
						StringBuffer sqlBuf	= new StringBuffer();
						sqlBuf.append("UPDATE ip_transfer_request set CANCELLATION_DATE_TIME = sysdate, ");
						if(isSkipCancelTransOutAppl) // added by mujafar for ML-MMOH-CRF-1045
						sqlBuf.append(" TFR_REQ_STATUS = '9', ");
						sqlBuf.append("CANCEL_REASON_CODE = ? , ");
						sqlBuf.append("cancelled_by_id = ? , ");
						sqlBuf.append("modified_by_id = ? , modified_date = sysdate , ");
						sqlBuf.append("modified_at_ws_no = ? , modified_facility_id = ? ,TFR_REQ_ACCEPTED_YN='R' ");
						sqlBuf.append("where encounter_id = ? and facility_id = ? and TFR_REQ_REF_NO = ?  ");

						pstmt = con.prepareStatement( sqlBuf.toString() );

						pstmt.setString	( 1, cancel_reason ) ;
						pstmt.setString	( 2, addedById ) ;
						pstmt.setString	( 3, addedById ) ;
						pstmt.setString	( 4, addedAtWorkstation ) ;
						pstmt.setString	( 5, facilityId ) ;
						pstmt.setLong	( 6, encounterid ) ;
						pstmt.setString	( 7, facilityId ) ;
						pstmt.setString	( 8, bookingrefno );
						bookResult = pstmt.executeUpdate() ;
						result = (bookResult > 0) ? true : false;
						if(pstmt!=null)pstmt.close();
						
						// added by mujafar for ML-MMOH-CRF-1045 START
											
						if(isSkipCancelTransOutAppl) 
						{	
								
							if(result)
							{
						
								try
								{
									 if(sqlBuf.length() > 0) sqlBuf.delete(0,sqlBuf.length());	
									sqlBuf.append(" update IP_BED_CLASS_REQUEST set ");
									sqlBuf.append(" request_status = '9', ");
									sqlBuf.append(" modified_by_id = ?, ");
									sqlBuf.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");
									sqlBuf.append(" where ");
									sqlBuf.append(" REQUEST_STATUS = '0' and facility_id = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? ");
									
								
									
									
									pstmt = con.prepareStatement(sqlBuf.toString());
										
									pstmt.setString	( 1, addedById ) ;
									pstmt.setString	( 2, addedAtWorkstation ) ;
									pstmt.setString	( 3, facilityId ) ; 
									pstmt.setString	( 4, facilityId ) ;
									pstmt.setLong	( 5, encounterid);
									pstmt.setString	( 6, patientid);	
									pstmt.executeUpdate() ;	
									if(pstmt != null)  pstmt.close() ;
								}
								catch(SQLException e1)
								{
									e1.printStackTrace();
									sb.append("Exception in IP_BED_CLASS_REQUEST : " + e1);
								}
								
							
								int count = 0;
								try
								{   
									if(sqlBuf.length() > 0)	sqlBuf.delete(0, sqlBuf.length());
									sqlBuf.append("  update IP_OPEN_ENCOUNTER set ");
									sqlBuf.append("  TFR_REQ_STATUS = '', ");
									sqlBuf.append(" modified_by_id = ?, ");
									sqlBuf.append(" modified_at_ws_no = ?, modified_date = sysdate , MODIFIED_FACILITY_ID=?");
									sqlBuf.append(" where ");
									sqlBuf.append(" facility_id = ? and encounter_id = ?");
									
									
									
									
									pstmt = con.prepareStatement(sqlBuf.toString());
									pstmt.setString(1, addedById);
									pstmt.setString(2, addedAtWorkstation);
									pstmt.setString(3, facilityId); 
									pstmt.setString(4, facilityId);
									pstmt.setLong(5, encounterid);
									count = pstmt.executeUpdate();
									
								
									if(count > 0)
										result = true;
									else
										result = false;

									if(pstmt != null) pstmt.close();

								}catch(Exception ex)
								{
									result = false;
									sb.append("error while updating into ip_open_encounter : " + ex.getMessage());
								}
								
								
								
								
								
							}
								
								
							
							
						}
						
						// added by mujafar for ML-MMOH-CRF-1045 END
						

					}
				}
					if (result && (!(frnursingunitcode.equals(tonursingunitcode)))&& transfer_in_status.equals("01"))
					{
						StringBuffer sql16 = new StringBuffer();

						//sql16.append(" select install_yn from sm_module where module_id = 'FM' ");
						String transfter_file_yn="";
						String auto_file_transfer_yn="";
						String fm_fs_locn_code="";
						String fm_fs_locn_code1="";
						String fm_locn_identity1="";
						String to_fs_locn_code="";
						String fm_locn_identity="";
						String to_locn_identity="";
						String file_no="";
						String narration="";
						String narration_desc="";
						String recd_userid="";
						String ret_date="";
						String auto_rec_ward_yn="";
						String curr_file_status="";
						String volume_no="";
						String file_type_code="";
						String duration_type="";
						String return_criteria="";
						int no_of_dh_to_return_ip=0;
						int parameter_hours		= 0;
							/*
							pstmt = con.prepareStatement(sql16.toString());
							srs   = pstmt.executeQuery();
							if (srs!=null && srs.next())
								fm_install_yn = srs.getString(1);
							if(srs != null) srs.close();
							if(pstmt != null) pstmt.close();*/
							if (fm_install_yn.equals("Y"))
								{
								if(sql16.length() > 0) sql16.delete(0,sql16.length());
								sql16.append("Select auto_rec_ward_yn, transfer_file_yn from fm_parameter  where facility_id =?");
								pstmt = con.prepareStatement(sql16.toString());
								pstmt.setString	( 1, facilityId ) ;
								srs = pstmt.executeQuery() ;
								if (srs!=null && srs.next()){
									auto_rec_ward_yn  = checkForNull(srs.getString(1));
									transfter_file_yn = checkForNull(srs.getString(2));
								}
								if(srs != null) srs.close();
								if(pstmt != null) pstmt.close();
							
								if (auto_rec_ward_yn.equals("Y"))
									curr_file_status="O";
								else
									curr_file_status="T";
								if (transfter_file_yn.equals("Y")){

									if(sql16.length() > 0) sql16.delete(0,sql16.length());
									sql16.append("Select a.auto_file_transfer_yn,a.fs_locn_code,b.locn_identity ,b.duration_type,b.return_criteria,b.no_of_dh_to_return_ip , b.holder_name from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
									
									try
									{
									pstmt = con.prepareStatement(sql16.toString());
									pstmt.setString	( 1, facilityId ) ;
//								  	pstmt.setString	( 2, frnursingunitcode ) ;
								  	pstmt.setString	( 2, tonursingunitcode ) ;
									
									

									srs = pstmt.executeQuery();

									}
									catch(Exception exc)
									{
										exc.printStackTrace();
									}
									if (srs!=null && srs.next()){
										auto_file_transfer_yn = checkForNull(srs.getString(1));
										fm_fs_locn_code		  = checkForNull(srs.getString(2));
										fm_locn_identity	  = checkForNull(srs.getString(3));
										
										/*Tuesday, March 02, 2010 ,IN019707*/
										duration_type		  = checkForNull(srs.getString(4));
										return_criteria		  = checkForNull(srs.getString(5));
										no_of_dh_to_return_ip = Integer.parseInt(srs.getString(6)==null?"0":srs.getString(6));
										recd_userid		 = checkForNull(srs.getString(7));
										if(duration_type.equals("D"))
										{
											parameter_hours = no_of_dh_to_return_ip * 24;
										}
										else
										{
											parameter_hours = no_of_dh_to_return_ip;	
										}	
										
										/**/
										if (fm_fs_locn_code==null) fm_fs_locn_code="";
									}
									if(srs!=null)srs.close();
									if(pstmt!=null)pstmt.close();
														
									if(sql16.length() > 0) sql16.delete(0,sql16.length());
									sql16.append("Select a.fs_locn_code from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
									
									try
									{
									pstmt = con.prepareStatement(sql16.toString());
									pstmt.setString	( 1, facilityId ) ;
								  	pstmt.setString	( 2, frnursingunitcode ) ;
									srs = pstmt.executeQuery();
									}
									catch(Exception exc)
									{
										exc.printStackTrace();
									}
									if (srs!=null && srs.next()){
									fm_fs_locn_code_to		  = checkForNull(srs.getString(1));
									}
									if(srs!=null)srs.close();
									if(pstmt!=null)pstmt.close();
									
									
									
									if (auto_file_transfer_yn.equals("Y")&&fm_fs_locn_code!=""){
										if(sql16.length() > 0) sql16.delete(0,sql16.length());
										
										sql16.append("Select a.fs_locn_code,b.locn_identity,b.holder_name,to_char(sysdate+"+(parameter_hours)+"/24,'dd/mm/rrrr hh24:mi')   from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
										pstmt = con.prepareStatement(sql16.toString());
										pstmt.setString	( 1, facilityId ) ;
//										pstmt.setString	( 2, tonursingunitcode ) ;
										pstmt.setString	( 2, frnursingunitcode) ;
										try
										{
										srs = pstmt.executeQuery() ;
										}
										catch(Exception exc)
										{
											exc.printStackTrace();
										}
									
										if (srs!=null && srs.next()){
											fm_fs_locn_code1  = checkForNull(srs.getString(1));
											fm_locn_identity1 = checkForNull(srs.getString(2));
											//recd_userid		 = checkForNull(srs.getString(3));
											ret_date		 = checkForNull(srs.getString(4));
										to_fs_locn_code=fm_fs_locn_code;
										to_locn_identity=fm_locn_identity;

										


										}
										if(srs!=null)srs.close();
										if(pstmt!=null)pstmt.close();
										if(recd_userid==null) recd_userid="";
										if(ret_date==null)	  ret_date="";

										if (to_fs_locn_code!="")
										{
											/*if(sql16.length() > 0) sql16.delete(0,sql16.length());
											sql16.append("select file_no from mr_pat_file_index where facility_id =? and patient_id =? and fs_locn_code=?");
											pstmt = con.prepareStatement(sql16.toString());
											pstmt.setString	( 1, facilityId ) ;
											pstmt.setString	( 2, patientid) ;
											pstmt.setString	( 3, to_fs_locn_code) ;

											srs = pstmt.executeQuery() ;
											if (srs!=null && srs.next())
												file_no  = srs.getString(1);
											if(srs!=null)srs.close();
											if(pstmt!=null)pstmt.close();
											if (file_no==null) file_no="";
											*/
											//if (file_no!=""){
												if(sql16.length() > 0) sql16.delete(0,sql16.length());
												//sql16.append("select a.narration_code,b.short_desc from fm_storage_locn a, fm_narration b where a.narration_code = b.narration_code and a.facility_id = ? and a.fs_locn_code = ? ");

												sql16.append("select  a.file_no, a.volume_no,a.file_type_code, b.narration_code, c.short_desc from  fm_curr_locn a, fm_storage_locn b, fm_narration c where a.facility_id = ? and a.patient_id = ? and a.volume_status IN ('A' ,'I') and a.curr_file_status ='O' and a.curr_fs_locn_code = ?  and a.facility_id = b.facility_id and a.curr_fs_locn_code = b.fs_locn_code and b.narration_code = c.narration_code (+) and a.curr_locn_id = ? ");

												pstmt = con.prepareStatement(sql16.toString());
												pstmt.setString	( 1, facilityId ) ;
												pstmt.setString	( 2, patientid) ;
												pstmt.setString	( 3, fm_fs_locn_code1 ) ;
												pstmt.setString	( 4, frnursingunitcode) ;

                          						

												srs = pstmt.executeQuery() ;
												if (srs!=null && srs.next()){
													file_no			= checkForNull(srs.getString(1));
													volume_no		= checkForNull(srs.getString(2));
													file_type_code	= checkForNull(srs.getString(3));
													narration		= checkForNull(srs.getString(4));
													narration_desc	= checkForNull(srs.getString(5));
													if (file_no==null) file_no="";
													if (narration==null) narration="";
													if (narration_desc==null) narration_desc="";
													if (file_type_code==null) file_type_code="";

												}
												if(srs!=null)srs.close();
												if(pstmt!=null)pstmt.close();

											if(!file_no.equals(""))
											{

												if (volume_no==null)
													volume_no="1";
												if(volume_no.equals(""))
													volume_no="1";

												String p_system_date = "";

												if(to_locn_identity.equals("N") && auto_rec_ward_yn.equals("Y"))
												{
													p_system_date = system_date;
												}


												if(sql16.length() > 0) sql16.delete(0,sql16.length());
												sql16.append("insert into fm_movement_log(facility_id, file_no,volume_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity, dest_user_id, narration_code, movement_narration, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,sysdate,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,'F','N','N',?,sysdate,?,?,?,sysdate,?,?)");


												res = 0;
												pstmt = con.prepareStatement(sql16.toString());
												pstmt.setString	( 1, facilityId) ;
												pstmt.setString	( 2, file_no);
												pstmt.setString	( 3, volume_no);
												pstmt.setString	( 4, patientid) ;
												pstmt.setString	( 5, facilityId) ;
												pstmt.setString	( 6, fm_fs_locn_code) ;
												pstmt.setString	( 7, fm_locn_identity) ;
												pstmt.setString	( 8, addedById) ;
												pstmt.setString	( 9, facilityId) ;
												pstmt.setString	( 10, p_system_date) ;
												pstmt.setString	( 11, to_fs_locn_code) ;
												pstmt.setString	( 12, to_locn_identity) ;
												pstmt.setString	( 13, addedById) ;
												pstmt.setString	( 14, narration) ;
												pstmt.setString	( 15, narration_desc) ;
												pstmt.setString	( 16, addedById) ;
												pstmt.setString	( 17, addedAtWorkstation) ;
												pstmt.setString	( 18, facilityId) ;
												pstmt.setString	( 19, addedById) ;
												pstmt.setString	( 20, addedAtWorkstation) ;
												pstmt.setString	( 21, facilityId) ;
												try{
												res = pstmt.executeUpdate() ;

												if(pstmt!=null)pstmt.close();

												}
												catch(Exception exc)
												{
													sb.append(exc.getMessage());
													exc.printStackTrace();
												}
												if(res>0 )  result = true; else result = false;
												
									/*Below line added for this  HSA-CRF-0306.1*/
			                       boolean siteSpecific=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");
								  

												if (result && !siteSpecific){
												if(sql16.length() > 0) sql16.delete(0,sql16.length());
										
												sql16.append("update fm_curr_locn set iss_date_time=sysdate,curr_facility_id =?,curr_file_status=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,last_movement_date_time=sysdate,return_date_time=to_date(?,'dd/mm/rrrr hh24:mi'),");
												if (!(curr_file_status.equals("T")))
													sql16.append("prev_facility_id=?,prev_fs_locn_code=?,");

												sql16.append("mr_locn_yn='Y', modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id = ? , curr_locn_id = ? where facility_id = ? and file_no =? and volume_no=?");


												pstmt = con.prepareStatement(sql16.toString());

												


												int inc=1;
												res = 0;
												pstmt.setString	( inc++,  facilityId) ;

												pstmt.setString	( inc++,  curr_file_status);
												if (curr_file_status.equals("T"))
													pstmt.setString	( inc++,  fm_fs_locn_code1) ;
												else
													pstmt.setString	( inc++,  to_fs_locn_code) ;

												pstmt.setString	( inc++,  to_locn_identity) ;
												pstmt.setString	( inc++,  recd_userid) ;
												/*Tuesday, March 02, 2010 , IN019707*/

												

												if(return_criteria.equals("I") && parameter_hours > 0)
													pstmt.setString	( inc++,  ret_date) ;
												else
													pstmt.setString	( inc++,  "") ;

												if (!(curr_file_status.equals("T"))){
													pstmt.setString	( inc++,  facilityId) ;
													pstmt.setString	( inc++,  fm_fs_locn_code) ;
												}

												pstmt.setString	( inc++, addedById) ;
												pstmt.setString	( inc++, addedAtWorkstation) ;
												pstmt.setString	( inc++, facilityId) ;
												pstmt.setString	( inc++, tonursingunitcode) ;
												pstmt.setString	( inc++, facilityId) ;
												pstmt.setString	( inc++, file_no) ;

												pstmt.setString	( inc++, volume_no) ;
												try
												{
												res = pstmt.executeUpdate() ;
												}
												catch(Exception exc)
												{
												sb.append(exc.getMessage());
												exc.printStackTrace();
												}

												if(res>0 )
													result = true;
												else
													result = false;

													if(pstmt!=null)pstmt.close();
												}
												if (result && curr_file_status.equals("T")){
												try {
												if(sql16.length() > 0) sql16.delete(0,sql16.length());
												//sql16.append("insert into fm_transit_file(facility_id, file_no, patient_id, sent_date_time, src_facility_id, src_fs_locn_code, src_locn_identity, dest_facility_id, dest_fs_locn_code, dest_locn_identity, added_by_id, added_date, added_at_ws_no, added_facility_id) values(?,?,?,sysdate,?,?,?,?,?,?,?,sysdate,?,?)");
												
												sql16.append("insert into fm_transit_file(facility_id, file_no,volume_no,file_type_code, patient_id, sent_date_time, src_facility_id, src_fs_locn_code, src_locn_identity, dest_facility_id, dest_fs_locn_code, dest_locn_identity, added_by_id, added_date, added_at_ws_no, added_facility_id) values(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,sysdate,?,?)");
												pstmt = con.prepareStatement(sql16.toString());
												int inc = 1;
												res = 0;
												pstmt.setString	( inc++,  facilityId) ;
												pstmt.setString	( inc++,  file_no);
												pstmt.setString	( inc++,  volume_no);
												pstmt.setString	( inc++,  file_type_code);
												pstmt.setString	( inc++,  patientid) ;
												pstmt.setString	( inc++,  facilityId) ;
											//	pstmt.setString	( inc++,  fm_fs_locn_code) ;
												pstmt.setString	( inc++,  fm_fs_locn_code_to) ;
												pstmt.setString	( inc++,  fm_locn_identity) ;
												pstmt.setString	( inc++,  facilityId) ;
												pstmt.setString	( inc++,  to_fs_locn_code) ;
												pstmt.setString	( inc++,  to_locn_identity) ;
												pstmt.setString	( inc++,  addedById) ;
												pstmt.setString	( inc++,  addedAtWorkstation) ;
												pstmt.setString	( inc++,  facilityId) ;
												try{
												res = pstmt.executeUpdate() ;


												}
												catch(Exception exc)
												{
													sb.append(exc.getMessage());
													exc.printStackTrace();
												}
												if(res>0 )  result = true; else result = false;
													if(pstmt!=null)pstmt.close();
											}catch(Exception e2)
											{
												sb.append(e2.getMessage());
												e2.printStackTrace();
											}

											}
											}
										}


								}
							}
						}
					}


					if(transfer_in_status.equals("01") && result)
					{
						//Billing Related part starts here
						// MOD#04 Commented out the billing portions
						// MOD#06 Introduced billing logic
						try
						{
							if (bl_operational.equals("Y"))
							{
								boolBLInstall = true;
							}
							else
							{
								boolBLInstall = false;
							}
						}
						catch(Exception exceptionBL)
						{
							exceptionBL.printStackTrace();
						}

						if (boolBLInstall)
						{
						try
						{
						

							Hashtable hashtableBill = new Hashtable();
							hashtableBill.put("facilityId",facilityId);
							hashtableBill.put("patientid",patientid);
							hashtableBill.put("transferdate",transferdate);
							hashtableBill.put("transfertype",transfertype);
							hashtableBill.put("topractitionerid",topractitionerid);
							hashtableBill.put("tospecialitycode",tospecialitycode);
							hashtableBill.put("tobedclass",tobedclass);
							hashtableBill.put("tobedtype",modified_bed_type_code);
							hashtableBill.put("tonursingunitcode",tonursingunitcode);
							hashtableBill.put("tobedno",tobedno);
							hashtableBill.put("toroomno",toroomno);
							hashtableBill.put("frbedclass",frbedclass);
							hashtableBill.put("frnursingunitcode",frnursingunitcode);
							hashtableBill.put("frbedno",frbedno);
							hashtableBill.put("frroomno",frroomno);
							//hashtableBill.put("frbedtype",frbedtype);
							hashtableBill.put("frbedtype",fr_bed_type_code);
							hashtableBill.put("frbedtypedefn",fr_bed_type_code_by_defn);
							hashtableBill.put("addedAtWorkstation",addedAtWorkstation);
							hashtableBill.put("bl_interface_yn",bl_interface_yn);
							hashtableBill.put("encounter_id",encounter_id);
							hashtableBill.put("addedById",addedById);
							hashtableBill.put("episode_id",episode_id);
							hashtableBill.put("srlno",srlno+"");
							hashtableBill.put("episode_type",patient_class);
							hashtableBill.put("module_id",patient_class);
							hashtableBill.put("locale",locale);
							BLIPTransfer blipTransfer = new BLIPTransfer();
							Hashtable resultsBL = blipTransfer.billPatientService(p, con,hashtableBill);
							boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
							result = boolRes;
							strBLMessage = "";
							hashtableBill.clear();
							if (boolRes == false)
							{
								result  = false;
							sb.append((String)resultsBL.get("error"));

							}
							if (boolRes == true)
							{
								result = true;
								sb.append((String)resultsBL.get("error"));
							   strBLMessage = (String) resultsBL.get("message");
								strBLSpecialMessage = (String) resultsBL.get("bl_special_message");
								resultsBL.clear();
								if (strBLSpecialMessage == null)
								{
										strBLSpecialMessage = " ";
								}
								if (strBLMessage != null )
								{
									if (!strBLMessage.equalsIgnoreCase("null"))
									{
										//sb.append(strBLMessage);
									}
								}
							}
						}
						catch(Exception exceptionBL)
						{
								result  = false;
								sb.append("Error:eBL "+exceptionBL);
								exceptionBL.printStackTrace();
						}
					}
					}

						if ( result )
						{
							result = true ;

							if(!new_reserved_bed_no.equals(""))
							{
//								sb.append( "BedNO " +new_reserved_bed_no+" Reserved . \\n ");

								java.util.Hashtable msg = MessageManager.getMessage( locale,"BED_RESERVED","IP");

								String message  = "";
								String message1 = "";
								String message2 = "";

								message = (String) msg.get("message");
								message1 = message.substring(0,message.indexOf("$"));
								message2  = message.substring(message.indexOf("$")+1, message.length());
								message = message1 + new_reserved_bed_no + message2;
								sb.append(message);
								msg.clear();

							}
							Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM" ) ;
							sb.append( (String) message.get("message") ) ;


							message.clear();
							/*if(bookingCon!=null)
								bookingCon.commit();*///modified on 10-07-2008 for SCR 3440
							con.commit();

						}

						else
						{
							// MOD#08 Intrdoduced error message
							/*
							Hashtable message = MessageManager.getMessage(locale,"ERROR_IN_UPDATING","SM" ) ;
							sb.append((String) message.get("message") ) ;

							message.clear();
							*/
							con.rollback();
						}

					}
					else
					{
						result = false;
						Hashtable message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP" ) ;
						sb.append((String) message.get("message"));
						message.clear();
					}
					reserveNuArray.clear();
					reserveBedArray.clear();
				}
				catch ( SQLException e )
				{
					sb.append( e.getMessage()  ) ;
					e.printStackTrace() ;

					try
					{
						con.rollback();
						/*if(bookingCon!=null)
							bookingCon.rollback();
							*///modified on 10-07-2008 for SCR 3440
					}catch(SQLException e1)
					{
						e.printStackTrace();
					}
				}
				finally
				{
					try
					{
						if(pstmt != null)		pstmt.close() ;
						if(rset != null)		rset.close();
						if(stmt != null)		stmt.close();
						if(srs != null)		srs.close();

					}catch(Exception ce)
					{
						ce.printStackTrace();
					}
					if(con != null)      ConnectionManager.returnConnection(con,p);
					//if(bookingCon!=null) ConnectionManager.returnConnection(bookingCon,p);
					//modified on 10-07-2008 for SCR 3440
				}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;

			// MOD#09 Added new parameter BL Message
			if ( (strBLMessage == null) || (strBLMessage.equals("")))
			{
				strBLMessage = " ";
			}

			if ( (strBLSpecialMessage == null) || (strBLSpecialMessage.equals("")))
			{
				strBLSpecialMessage = " ";
			}

			results.put( "bl_message",strBLMessage);
			results.put( "bl_special_message",strBLSpecialMessage);
			// End of MOD#09
			return results ;
	}//end insert


	/**
	This method is used check if the fields have null values.
	@version - V3
	@param1 - String
	@return - String
	*/

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
} // end session bean
