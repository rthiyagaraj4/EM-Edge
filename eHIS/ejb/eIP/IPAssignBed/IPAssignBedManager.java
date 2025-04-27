/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to assign bed to patients.
@version - V3
*/         

package eIP.IPAssignBed;

// MOD#0A Introduced import blipin
import blipin.BLIPBedAssgn;
import java.rmi.RemoteException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eCommon.Common.*;
/**
*
* @ejb.bean
*	name="IPAssignBed"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPAssignBed"
*	local-jndi-name="IPAssignBed"
*	impl-class-name="eIP.IPAssignBed.IPAssignBedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPAssignBed.IPAssignBedLocal"
*	remote-class="eIP.IPAssignBed.IPAssignBedRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPAssignBed.IPAssignBedLocalHome"
*	remote-class="eIP.IPAssignBed.IPAssignBedHome"
*	generate= "local,remote"
*
*
*/
public class IPAssignBedManager implements SessionBean 
{


	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove(){}
	public void ejbActivate(){}
	public void ejbPassivate(){}
	public void setSessionContext(SessionContext context){this.ctx=context;}

	/**
	This method is used to assign the bed for patient
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

    public java.util.HashMap  insertAssignBed(Properties p,HashMap paramHashTab)
	{
		
		Connection connection 		 		=	null;
		PreparedStatement preStatement		=	null;
		ResultSet resultSet 				=	null;
		Statement statement					=	null;
		String modified_date_value			= "";		
		String override_yn					= "";
		String booking_type					= "";
		String booking_ref_no				= "";
		String pseudo_bed_yn				= "N";
		String file_type_code				= "";
		String volume_no					= "";
		String ext_num						= "";
		/* ADDED FOR ML-MMOH-CRF-1972 ISSUE */
		ResultSet rs2 			 = null;
		PreparedStatement pstmt2 = null;
		StringBuffer sql1				= new StringBuffer("");
		Hashtable message			= new java.util.Hashtable();
		java.util.HashMap results	= new java.util.HashMap();
		StringBuffer sb			= new StringBuffer();
		StringBuffer sb1		= new StringBuffer();
		StringBuffer sqlBuffer	= new StringBuffer();	
		boolean result			= true;
		boolean resultMess		= true;
		String locale			= "";
		int res1				= 0;
		int res2				= 0;
		int res3				= 0;
		int res4				= 0;
		int res5				= 0;
		String closeWindow				= "N";
		String facilityId				=  "";
		String bed_no					=  "";
		String orig_blocked_bed_no		=  "";
		String nursing_unit_code		=  "";
		String service					=  "";
		String patient_class			=  "";
		String room_no					=  "";
		String gender					=  "";
		String encounterId				=  "";
		String bed_type_code			=  "";
		String modified_bed_type_code	=  "";
		String bedtypecode				=  "";
		String bed_class_code			=  "";
		String daily_rate				=  "";
		String patient_id				=  "";
		String bl_operational			=  "";
		String modifiedAtWorkstation	=  "";
		String modified_date_val		=  "";
		String practid					=  "";
		String team_id					=  "";
		String nursing_unit				=  "";
		String Splcode					=  "";
		String patient_gender			=  "";
		String exp_discharge_date_time	=  "";
		String date_of_birth			=  "";
		String from_nursing_unit_code	=  "";
		String adt_status				=  "";
		String pat_check_in_allowed_yn  =  "";
		String bedallocationdatetime    =  "";
		String chk_patient_id			=  "";
		String chk_encounter_id	    	=  "";
		String chk_facility_id			=  "";
		String chg_nurs_unit_in_assign_bed_yn = "";
		String to_bed_type_code			= "";
		String to_bed_type_code_by_defn = "";
		String fm_install_yn			= "N" ;
		String online_mr_notfn_yn		= "N" ;
		String fs_locn_code				= "N" ;
		String check_same_sex_in_room_yn= "N" ;
		int		occ_male_bed_count		= 0;
		int		occ_female_bed_count	= 0;
		int		occ_unknown_bed_count	= 0;
		boolean isForAdmission=false;
		
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
		String weight_on_admission		= "";
		String weight_on_admission_unit	= "";
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		String height_on_admission		= "";
		String bmi="";
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/


		try
		{
			String addedById =	p.getProperty("login_user");
			facilityId				=	(String) paramHashTab.get("facilityId");
			bed_no					=	(String) paramHashTab.get("bed_no");
			orig_blocked_bed_no		=	(String) paramHashTab.get("orig_blocked_bed_no");
			nursing_unit_code		=	(String) paramHashTab.get("nursing_unit_code");
			service					=	(String) paramHashTab.get("service");	
			patient_class			=	(String) paramHashTab.get("patient_class");
			room_no					=	(String) paramHashTab.get("room_no");
			gender					=	(String) paramHashTab.get("gender");
			encounterId				=	(String) paramHashTab.get("encounterId");
			bed_type_code			=	(String) paramHashTab.get("bed_type_code");
			modified_bed_type_code	=	(String) paramHashTab.get("modified_bed_type_code");
			bedtypecode				=	(String) paramHashTab.get("bedtypecode");
			bed_class_code			=	(String) paramHashTab.get("bed_class_code");
			daily_rate				=	checkForNull((String) paramHashTab.get("daily_rate"));
			patient_id				=	(String) paramHashTab.get("patient_id");
			bl_operational			=	(String) paramHashTab.get("bl_operational");
			modifiedAtWorkstation	=	(String) paramHashTab.get("client_ip_address");
			modified_date_val		=	(String) paramHashTab.get("modified_date_val");
			practid					=	(String) paramHashTab.get("practid");
			team_id					=	(String) paramHashTab.get("team_id");
			nursing_unit			=	(String) paramHashTab.get("nursing_unit");
			Splcode					=	(String) paramHashTab.get("Splcode");
			patient_gender			=	(String) paramHashTab.get("patient_gender");
			date_of_birth			=	(String) paramHashTab.get("date_of_birth");
			from_nursing_unit_code	=	(String) paramHashTab.get("from_nursing_unit_code");
			bedallocationdatetime	=	(String) paramHashTab.get("bed_allocation_date_time");
			exp_discharge_date_time	=	(String) paramHashTab.get("exp_discharge_date_time");
			pat_check_in_allowed_yn	=	(String) paramHashTab.get("pat_check_in_allowed_yn");
			pseudo_bed_yn			=	(String) paramHashTab.get("pseudo_bed_yn");
			chg_nurs_unit_in_assign_bed_yn	=(String) paramHashTab.get("chg_nurs_unit_in_assign_bed_yn");
			fm_install_yn			=(String) paramHashTab.get("fm_install_yn");
			
			/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
			weight_on_admission			= (String) paramHashTab.get("weight_on_admission");
			weight_on_admission_unit	= (String) paramHashTab.get("weight_on_admission_unit");
			/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
			
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			
			height_on_admission			= (String) paramHashTab.get("height_on_admission");
			bmi			= (String) paramHashTab.get("bmi");
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			

			if(pat_check_in_allowed_yn.equals("Y"))
				adt_status				=  "01";
			
			connection	= ConnectionManager.getConnection(p);
			connection.setAutoCommit(false);
			locale = p.getProperty("LOCALE");
			sqlBuffer.append(" select TO_CHAR(modified_date, 'dd/mm/rrrr hh24:mi') modified_date FROM IP_OPEN_ENCOUNTER where facility_id = '");
			sqlBuffer.append(facilityId);
			sqlBuffer.append("' and encounter_id = '");
			sqlBuffer.append(encounterId);
			sqlBuffer.append("' ");
			if (statement != null)  statement = null;
			if (resultSet != null)  resultSet = null;
			 isForAdmission=CommonBean.isSiteSpecific(connection, "AE", "AE_FOR_ADMISSION_TAB");//ADDED BY KAMATCHI S FOR ML-MMOH-CRF-1972
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlBuffer.toString());

			if ((resultSet != null) && (resultSet.next()))
				modified_date_value = checkForNull(resultSet.getString("modified_date"));

			if (modified_date_value.equals(modified_date_val))
			{

				if (result)
				{
					String age_group_code	=	"";

					if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append("select a.occ_male_bed_count, a.occ_female_bed_count,a.occ_unknown_bed_count,b.age_group_code, b.fs_locn_code, b.online_mr_notfn_yn,b.check_same_sex_in_room_yn FROM IP_NURSING_UNIT_ROOM a, IP_NURSING_UNIT b WHERE a.facility_id ='");
					sqlBuffer.append(facilityId);
					sqlBuffer.append("' AND b.nursing_unit_code = '");
					sqlBuffer.append(nursing_unit_code);
					sqlBuffer.append("' AND  b.facility_id=a.facility_id AND  b.nursing_unit_code = a.nursing_unit_code AND  a.room_no = '");
					sqlBuffer.append(room_no);
					sqlBuffer.append("'");
					if (resultSet != null)  resultSet.close();
					if (statement != null)  statement.close();
					
					statement	=	connection.createStatement();
					resultSet	=	statement.executeQuery(sqlBuffer.toString());
					if((resultSet != null) && (resultSet.next()))
					{
						age_group_code				= checkForNull(resultSet.getString("age_group_code"));
						fs_locn_code				= checkForNull(resultSet.getString("fs_locn_code"),"N");
						online_mr_notfn_yn			= checkForNull(resultSet.getString("online_mr_notfn_yn"),"N");
						check_same_sex_in_room_yn	= checkForNull(resultSet.getString("check_same_sex_in_room_yn"),"N");
						occ_male_bed_count			= resultSet.getInt("occ_male_bed_count");
						occ_female_bed_count		= resultSet.getInt("occ_female_bed_count");
						occ_unknown_bed_count		= resultSet.getInt("occ_unknown_bed_count");
						if(!age_group_code.equals(""))
						{
							// Check for the nursing unit have any criteria of age group or sex
							if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
							sqlBuffer.append(" Select '1' from am_age_group Where age_group_code = '");
							sqlBuffer.append(age_group_code);
							sqlBuffer.append("' and NVL(GENDER,'");
							sqlBuffer.append(patient_gender);
							sqlBuffer.append("') = '");
							sqlBuffer.append(patient_gender);
							sqlBuffer.append("' AND  trunc(SYSDATE)- to_date('");
							sqlBuffer.append(date_of_birth);
							sqlBuffer.append("','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
							if (resultSet != null)  resultSet.close();
							if (statement != null)  statement.close();
							
							statement	=	connection.createStatement();
							resultSet	=	statement.executeQuery(sqlBuffer.toString());
							if((resultSet != null) && (!resultSet.next()))
							 {
								result = false;
								message.clear();
								message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
								sb.append( (String) message.get("message") ) ;
								message.clear();
							 }
						}
					}
				}
				

				
				if(bed_no.equals(orig_blocked_bed_no))
				{
					if(result)
					{
						if (sqlBuffer.length() > 0)
							 sqlBuffer.delete(0, sqlBuffer.length());
						sqlBuffer.append("select patient_id, encounter_id, facility_id, booking_type, bed_booking_ref_no, override_yn from IP_BED_BOOKING BKG where facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("' and req_nursing_unit_code = '");
						sqlBuffer.append(from_nursing_unit_code);
						sqlBuffer.append("' and req_bed_no = '");
						sqlBuffer.append(orig_blocked_bed_no);
						sqlBuffer.append("' and booking_status in ('0','1') ");
						sqlBuffer.append(" and sysdate between blocked_from_date_time and blocked_until_date_time and booking_date_time = ");
						sqlBuffer.append(" (select max (booking_date_time) from ip_bed_booking where facility_id=bkg.facility_id");
						sqlBuffer.append(" and req_nursing_unit_code=bkg.req_nursing_unit_code and req_bed_no=bkg.req_bed_no ");
						sqlBuffer.append("and booking_status in ('0','1')  and sysdate between blocked_from_date_time and blocked_until_date_time ) ");
						if (resultSet != null)  resultSet.close();
						if (statement != null)  statement.close();
						statement=connection.createStatement();
						resultSet = statement.executeQuery(sqlBuffer.toString());
						if(resultSet != null)
						{
							while(resultSet.next())
							{
								override_yn		 = checkForNull(resultSet.getString("override_yn"));
								booking_type	 = checkForNull(resultSet.getString("booking_type"));

								booking_ref_no	 = checkForNull(resultSet.getString("BED_BOOKING_REF_NO"));
								chk_patient_id	 = checkForNull(resultSet.getString("PATIENT_ID")); 
								chk_encounter_id = checkForNull(resultSet.getString("ENCOUNTER_ID"));
								chk_facility_id  = checkForNull(resultSet.getString("FACILITY_ID"));
								
								if(!(patient_id.equals(chk_patient_id) && encounterId.equals(chk_encounter_id) && facilityId.equals(chk_facility_id)))
								{
									if(override_yn.equals("N"))
									{
										result=false;
										if(booking_type.equals("L"))
										{
											message.clear();	
											message = 	MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP");
											sb.append((String) message.get("message"));
											message.clear();
										}
										else
										{
											message.clear();
											message = MessageManager.getMessage(locale,"BLOCKED_BED","IP");
											sb.append((String) message.get("message"));
											message.clear();
										}
									}
									else
									{
										result		=	false;
										resultMess	=	false;
										if(booking_type.equals("L"))
										{
											message.clear();
											message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP");
											sb.append((String) message.get("message"));
											message.clear();
										}
										else
										{
											message.clear();
											message = MessageManager.getMessage(locale,"OVERRIDEABLE_BLOCKING","IP");
											sb.append((String) message.get("message"));
											message.clear();
										}
									}
								}//e.o patientid ,encounter id, facility id check
							}
						}
					} //e.o.2nd if
				}
				if(result)
				{
					// Commenetd as part of PE By Sudhakar
					/*if (sqlBuffer.length() > 0)
						sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append("	select a.occ_male_bed_count, a.occ_female_bed_count, a.occ_unknown_bed_count from IP_NURSING_UNIT_ROOM a, IP_NURSING_UNIT b where a.facility_id = '");
					sqlBuffer.append(facilityId);
					sqlBuffer.append("' and a. nursing_unit_code = '");
					sqlBuffer.append(nursing_unit_code);
					sqlBuffer.append("' and  a.room_no = '");
					sqlBuffer.append(room_no);
					sqlBuffer.append("' and  b.facility_id=a.facility_id and  b.nursing_unit_code = a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
					if (resultSet != null)  resultSet.close();
					if (statement != null)  statement.close();
					
					statement=connection.createStatement();
					resultSet = statement.executeQuery(sqlBuffer.toString());*/
					String current_gender	=	"";
					// Changed as part of PE By Sudhakar
					if(check_same_sex_in_room_yn.equals("Y")){
						if(occ_male_bed_count >0)
							current_gender="M";
						else if(occ_female_bed_count >0)
							current_gender="F";
						else if(occ_unknown_bed_count >0)
							current_gender="U";						
						if(!current_gender.equals("") && !gender.equals(current_gender)){
							result=false;
							message.clear();
							message = MessageManager.getMessage(locale,"IN_ROOM_ONLY_SAME_GENDER","IP");
							sb.append((String) message.get("message"));
							message.clear();
						}
					}
				}

				if(result)
				{
					try
					{
						if(!room_no.equals(""))
						{
							if(resultSet!=null) resultSet.close();
							if(statement!=null) statement.close();
							statement = connection.createStatement();
							resultSet = statement.executeQuery(" select ext_num from AM_FACILITY_ROOM where operating_facility_id = '"+facilityId+"' and room_num = '"+room_no+"' ");
							if(resultSet.next())
							{
								ext_num = resultSet.getString("ext_num") == null ? "" : resultSet.getString("ext_num");
							}
						}
						if (statement != null)  statement .close();
						if (resultSet != null)  resultSet.close();

						if (sqlBuffer.length()>0)
							sqlBuffer.delete(0, sqlBuffer.length());
						sqlBuffer.append("Update PR_ENCOUNTER set assign_room_num = '");
						sqlBuffer.append(room_no);
						sqlBuffer.append("', assign_bed_num = '");
						sqlBuffer.append(bed_no);
						sqlBuffer.append("', SERVICE_CODE = '");
						sqlBuffer.append(service);
						sqlBuffer.append("', assign_care_locn_code = '");
						sqlBuffer.append(nursing_unit_code);
						sqlBuffer.append("', specialty_code = '");
						sqlBuffer.append(Splcode);
						sqlBuffer.append("', modified_by_id = '");
						sqlBuffer.append(addedById);
						sqlBuffer.append("', modified_date = sysdate, modified_facility_id	= '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("', modified_at_ws_no = '");
						sqlBuffer.append(modifiedAtWorkstation);
						sqlBuffer.append("', assign_bed_class_code = '");
						sqlBuffer.append(bed_class_code);
						sqlBuffer.append("', attend_practitioner_id = '");
						sqlBuffer.append(practid);
						sqlBuffer.append("', team_id = '");
						sqlBuffer.append(team_id);
						sqlBuffer.append("', PAT_CURR_LOCN_CODE = '");
						sqlBuffer.append(nursing_unit_code);
						if(pat_check_in_allowed_yn.equals("Y"))
						{
							sqlBuffer.append("', adt_status = '");
							sqlBuffer.append(adt_status);
						}
						sqlBuffer.append("', assign_bed_type_code = '");
						sqlBuffer.append(bedtypecode);
						/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
						sqlBuffer.append("',weight_on_admission='"+weight_on_admission+"',weight_on_admission_unit='"+weight_on_admission_unit+"");
						/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
						
						/*Added  by KAMATCHI s  ON 23-JUN-2020 FOR ML-MMOH-CRF-1527*/
						sqlBuffer.append("',height_on_admission='"+height_on_admission+"");
						sqlBuffer.append("',bmi='"+bmi+"");
						/*Added  by KAMATCHI s  ON 23-JUN-2020 FOR ML-MMOH-CRF-1527*/
						
						sqlBuffer.append("', bed_allocation_date_time =to_date('"+bedallocationdatetime+"','dd/mm/rrrr hh24:mi') , ROOM_TEL_EXT_NUM = '"+ext_num+"' ,mark_arrival_date_time = sysdate where facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("' and encounter_id = '");
						sqlBuffer.append(encounterId);
						sqlBuffer.append("' ");	
						if (preStatement != null)preStatement.close();

						preStatement = connection.prepareStatement(sqlBuffer.toString());
						res1 = preStatement.executeUpdate() ;
						if(res1 > 0) result = true; else result = false;
					}
					catch(Exception e1)
					{
						sb.append("Exception in updating pr_encounter  : ");
						e1.printStackTrace() ;
						sb.append(e1.toString());
						sb.append("<br>...");
						result = false;
					}
				}

				if(result)
				{
					try
					{
						//add  on 28/08/08 for billing 
						statement = connection.createStatement();
						resultSet = statement.executeQuery(" select to_bed_type_code,to_bed_type_code_by_defn from IP_ADT_TRN where facility_id = '"+facilityId+"' and encounter_id = '"+encounterId+"' and srl_no = 1 and trn_type = 'A'");
						if(resultSet.next())
							{
								to_bed_type_code = resultSet.getString("to_bed_type_code") == null ? "" : resultSet.getString("to_bed_type_code");
								if(to_bed_type_code == null || to_bed_type_code.equals(""))	
									to_bed_type_code = bed_type_code;
								to_bed_type_code_by_defn=resultSet.getString("to_bed_type_code_by_defn") == null ? "" : resultSet.getString("to_bed_type_code_by_defn");
							}
						//

						if(bl_operational.equals("Y"))
						{
							if(modified_bed_type_code == null || modified_bed_type_code.equals(""))
							{  
								modified_bed_type_code = bedtypecode;
								bedtypecode = "";
							}
						}

						if (sqlBuffer.length() > 0)
							sqlBuffer.delete(0, sqlBuffer.length());

						sqlBuffer.append("UPDATE IP_ADT_TRN SET to_room_no = '");
						sqlBuffer.append(room_no);
						sqlBuffer.append("' ,to_bed_no = '");
						sqlBuffer.append(bed_no);
						sqlBuffer.append("' ,TO_SERVICE_CODE = '");
						sqlBuffer.append(service);
						sqlBuffer.append("' , to_bed_class_code	= '");
						sqlBuffer.append(bed_class_code);
						sqlBuffer.append("', to_bed_type_code = '");

						if(bl_operational.equals("Y"))
							//sqlBuffer.append(modified_bed_type_code);
							  sqlBuffer.append(to_bed_type_code);
						else
							sqlBuffer.append(bed_type_code);

						if(bl_operational.equals("Y"))
						{
							sqlBuffer.append("', to_bed_type_code_by_defn = '");
							//sqlBuffer.append(bedtypecode);
							sqlBuffer.append(to_bed_type_code_by_defn);
							sqlBuffer.append("' ,to_daily_rate = '");
							sqlBuffer.append(daily_rate);
						}
						sqlBuffer.append("' ,to_practitioner_id = '");
						sqlBuffer.append(practid);
						sqlBuffer.append("', modified_by_id = '");
						sqlBuffer.append(addedById);
						sqlBuffer.append("', modified_date = sysdate, modified_facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("', modified_at_ws_no = '");
						sqlBuffer.append(modifiedAtWorkstation);
						sqlBuffer.append("', to_nursing_unit = '");
						sqlBuffer.append(nursing_unit);
						sqlBuffer.append("', to_pract_team_id  = '");
						sqlBuffer.append(team_id);
						sqlBuffer.append("', to_specialty_code = '");
						sqlBuffer.append(Splcode);
						sqlBuffer.append("' WHERE facility_id  = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("' and encounter_id  =	");
						sqlBuffer.append(encounterId);
						sqlBuffer.append(" and srl_no = 1 and trn_type = 'A' ");
						
						if (preStatement != null) preStatement.close();
						preStatement = connection.prepareStatement(sqlBuffer.toString());
						res2 = preStatement.executeUpdate() ;
						if(res2 > 0) 
							result = true; 
						else 
						{
							result = false;
							sb.append("Exception in updating ip_adt_trn");
						}
					
					}catch(Exception e1)
					{
						sb.append("Exception in updating ip_adt_trn");
						e1.printStackTrace() ;
						sb.append(e1.toString());
						sb.append("<br>...");
						result = false;
					}
				}

				if(result)
				{
					if(patient_id.equals(chk_patient_id))
					{
						try
						{
						    String rel_bed_sql = " update ip_bed_booking set booking_status = ? , cancelled_by_id = ?,  cancellation_date_time = sysdate, modified_by_id=?, modified_date = sysdate,  modified_at_ws_no= ?,  modified_facility_id =?   where facility_id = ? and booking_type =? and bed_booking_ref_no = ?";
							if (preStatement != null)	preStatement.close();
							preStatement = connection.prepareStatement(rel_bed_sql);
							preStatement.setString(1, "2");
							preStatement.setString(2, addedById);
							preStatement.setString(3, addedById);
							preStatement.setString(4, modifiedAtWorkstation);
							preStatement.setString(5, facilityId);
							preStatement.setString(6, facilityId);
							preStatement.setString(7, booking_type);
							preStatement.setString(8, booking_ref_no);

							int res21 = preStatement.executeUpdate();
							if(res21 > 0) 
								result = true; 
							else 
							{
								result = false;
								sb.append("Exception in updating ip_bed_booking_table");
							}
						}
						catch(Exception e1)
						{
							e1.printStackTrace() ;
							sb.append("Exception in updating ip_bed_booking_table");
							sb.append(e1.toString());
							sb.append("<br>...");
							result = false;
						}
					} //e.o.if for patientid not equals chkpatientid
/*Monday, August 16, 2010 , modified for SRR20056-SCF-4961 [IN:023143] , to close blocked status(if any) of selected bed.*/
					else
					{
						try
							{
								if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
								sqlBuffer.append("update ip_bed_booking set booking_status = ? , cancelled_by_id = ?,  cancellation_date_time = sysdate, modified_by_id=?, modified_date = sysdate,  modified_at_ws_no= ?,  modified_facility_id =?   where facility_id = ? and req_nursing_unit_code = ? and req_bed_no = ? and req_room_no = ? and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time and override_yn = 'Y' and booking_type not in ('L','N')");
								preStatement = connection.prepareStatement(sqlBuffer.toString());
								preStatement.setString	( 1, "9");
								preStatement.setString	( 2, addedById);
								preStatement.setString	( 3, addedById);
								preStatement.setString	( 4, modifiedAtWorkstation);
								preStatement.setString	( 5, facilityId);
								preStatement.setString	( 6, facilityId);
								preStatement.setString	( 7, nursing_unit_code);
								preStatement.setString	( 8, bed_no);
								preStatement.setString	( 9, room_no);
								preStatement.executeUpdate() ;
								if(preStatement !=null) preStatement.close();
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						
					}
				}
				
				if(result)
				{
					try
					{
						if (sqlBuffer.length() > 0)
							sqlBuffer.delete(0, sqlBuffer.length());
						sqlBuffer.append("UPDATE ip_nursing_unit SET  num_of_beds_occupied= num_of_beds_occupied+1, modified_by_id = '");
						sqlBuffer.append(addedById);
						sqlBuffer.append("', modified_date = sysdate, modified_facility_id	 = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("', modified_at_ws_no = '");
						sqlBuffer.append(modifiedAtWorkstation);
						sqlBuffer.append("' WHERE facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("' and nursing_unit_code = '");
						sqlBuffer.append(nursing_unit_code);
						sqlBuffer.append("' ");
						if (preStatement != null)	preStatement.close();

						preStatement = connection.prepareStatement(sqlBuffer.toString());
						res3 = preStatement.executeUpdate() ;
						if(res3 > 0) 
							result = true; 
						else
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit_table");
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace() ;
						sb.append("Exception in updating ip_nursing_unit_table");
						sb.append(e1.toString());
						sb.append("<br>...");
						result = false;
					}
				}
				int l_male_count =0;
				int l_female_count =0;
				int l_unknown_count =0;

				if(result)
				{
					try
					{
						if (gender.equals("M"))  l_male_count		=	1;
						if (gender.equals("F"))  l_female_count		=	1;
						if (gender.equals("U"))  l_unknown_count	=	1;
						if (sqlBuffer.length() > 0)
							sqlBuffer.delete(0, sqlBuffer.length());
						sqlBuffer.append("UPDATE IP_NURSING_UNIT_ROOM SET occ_male_bed_count = occ_male_bed_count+");
						sqlBuffer.append(l_male_count);
						sqlBuffer.append(", occ_female_bed_count  = occ_female_bed_count+");
						sqlBuffer.append(l_female_count);
						sqlBuffer.append(", occ_unknown_bed_count = occ_unknown_bed_count+");
						sqlBuffer.append(l_unknown_count);
						sqlBuffer.append(", modified_by_id = '");
						sqlBuffer.append(addedById);
						sqlBuffer.append("', modified_date = sysdate, modified_facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("', modified_at_ws_no = '");
						sqlBuffer.append(modifiedAtWorkstation);
						sqlBuffer.append("' WHERE facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("' and  nursing_unit_code = '");
						sqlBuffer.append(nursing_unit_code);
						sqlBuffer.append("' and  room_no = '");
						sqlBuffer.append(room_no);
						sqlBuffer.append("' ");

						if (preStatement != null)	preStatement.close();
						preStatement = connection.prepareStatement(sqlBuffer.toString());
						res4 = preStatement.executeUpdate();

						if(res4 > 0) 
							result = true; 
						else
						{	
							result = false;
							sb.append("Exception in updating ip_nursing_unit_room_table");
						}
					}catch(Exception e1)
					{
						e1.printStackTrace() ;
						sb.append("Exception in updating ip_nursing_unit_room_table");
						sb.append(e1.toString());
						sb.append("<br>...");
						result = false;
					}
				}

				if(result)
				{
					try
					{
						if (sqlBuffer.length() > 0)
							sqlBuffer.delete(0, sqlBuffer.length());
						sqlBuffer.append(" UPDATE ip_nursing_unit_bed ");
						sqlBuffer.append("SET occupying_patient_id = '");
						sqlBuffer.append(patient_id);
						sqlBuffer.append("', current_status='O', modified_by_id = '");
						sqlBuffer.append(addedById);
						sqlBuffer.append("' ,");
						if(pseudo_bed_yn.equals("Y"))
							sqlBuffer.append("PSUEDO_BED_STATUS = 'U' ,");
						sqlBuffer.append("modified_date = sysdate, modified_facility_id	 = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("', modified_at_ws_no = '");
						sqlBuffer.append(modifiedAtWorkstation);
						sqlBuffer.append("' ");
						if(!exp_discharge_date_time.equals(""))
						{
							sqlBuffer.append(", OCCUPIED_UNTIL_DATE_TIME = to_date('"+exp_discharge_date_time+"','dd/mm/rrrr hh24:mi') ");
						}
						sqlBuffer.append(" WHERE facility_id = '");
						sqlBuffer.append(facilityId);
						sqlBuffer.append("' AND  nursing_unit_code = '");
						sqlBuffer.append(nursing_unit_code);
						sqlBuffer.append("' AND bed_no = '");
						sqlBuffer.append(bed_no);
						sqlBuffer.append("' ");
						sqlBuffer.append("  and occupying_patient_id is null and current_status='A' ");
						if (preStatement != null)	preStatement.close();
						preStatement = connection.prepareStatement(sqlBuffer.toString());
						res5 = preStatement.executeUpdate();
						if(res5>0 ){ 
							result = true;
						}else{ 
							result = false;
							message.clear();
							message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
					catch(Exception e1)
					{       String errMsg = "";
							String flag="";
							String msg ="";
							errMsg = e1.getMessage();
							if(errMsg != "")
							{
								if(errMsg.contains("IP_NURSING_UNIT_BED_I5"))
								{
									MessageManager mm = new MessageManager();
									java.util.Hashtable mesg = new Hashtable();
									mesg = mm.getMessage(locale, "BED_ALREADY_ALLOCATED", "IP") ;
									msg = ((String) mesg.get("message"));
									flag="N";
								}else
								{
									flag = "Y";
								}
							}
							if(flag.equals("N"))
							{
								sb.append(msg);
								result	= false;
							}else{
								e1.printStackTrace() ;
						        sb.append("Exception in updating ip_nursing_unit_bed_table");
						        sb.append("<br>...");
						        result = false;
							 }
						}
						
					
				}
				/* Added by kamatchi S ML-MMOH-CRF-1972 IP history patient list issue */
		if(result && isForAdmission)
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							sql1.append(" select encounter_id,pendng_admission_date_time from  ae_current_patient where  patient_id='"+patient_id+"' and FACILITY_ID = '"+facilityId+"' and ROWNUM = 1 order by queue_date desc");
							pstmt2   = connection.prepareStatement( sql1.toString() );
							rs2 = pstmt2.executeQuery() ;
							long ae_encounter_id=0;
							String pendng_admission_date_time="";
							if(rs2!=null){
							if(rs2.next())
								{
									ae_encounter_id=rs2.getLong("encounter_id");
									pendng_admission_date_time=checkForNull(rs2.getString("pendng_admission_date_time"));
									System.err.println("ae_encounter_id================="+ae_encounter_id);
									System.err.println("pendng_admission_date_time================="+pendng_admission_date_time);
								}
							}
								if(pstmt2!=null) pstmt2.close();
								if(rs2!=null) rs2.close();
								if(!pendng_admission_date_time.equals(""))
								{
								if(sql1.length() > 0) sql1.delete(0,sql1.length());
	
							sql1.append(" UPDATE ae_current_patient SET  pendng_admission_date_time= NULL, modified_by_id= '"+addedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+ae_encounter_id+"' ");
							pstmt2   = connection.prepareStatement( sql1.toString() );
							res1 = pstmt2.executeUpdate() ;
							System.err.println("hi 844 res1 ===>"+res1);
							if(res1 > 0 ) 
								result = true; 
							else
							{
								result = false;
								sb.append("Exception in updating ae_current_patient");
							}	
									
								}
							if(pstmt2!=null) pstmt2.close();
							
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating ae_current_patient");
							e1.printStackTrace();
						}
					}

				String strBLMessage =	"";

				//MOD#01 Introduced new billing logic
				if(bl_operational.equals("Y") && result)
				{
					try
					{
						String function_id		= "ASSIGN_BED";
						Hashtable hashtableBL	= new Hashtable();
						String episode_id		= encounterId;
						hashtableBL.put("patient_id",patient_id+"");
						hashtableBL.put("patient_class",patient_class+"");
						hashtableBL.put("room_no",room_no+"");
						hashtableBL.put("encounterId",encounterId+"");
						hashtableBL.put("episode_id",episode_id+"");
						//hashtableBL.put("bed_type_code",bed_type_code+"");
						hashtableBL.put("bed_type_code",to_bed_type_code+"");
						hashtableBL.put("bed_class_code",bed_class_code+"");
						hashtableBL.put("bed_no",bed_no+"");
						hashtableBL.put("facilityId",facilityId+"");
						hashtableBL.put("client_ip_address",modifiedAtWorkstation+"");
						hashtableBL.put("function_id",function_id);
						hashtableBL.put("nursing_unit_code",nursing_unit_code);
						hashtableBL.put("locale",locale);
						if (patient_class.equals("DC"))
						{
							hashtableBL.put("episode_type","D");
						}
						else
							hashtableBL.put("episode_type","I");

						BLIPBedAssgn blipBedAssgn	= new BLIPBedAssgn();
						Hashtable resultsBL			= blipBedAssgn.billPatientService(p,connection,hashtableBL);
						boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
						result			= boolRes;	
						if (result == false)
						{
							sb.append((String)(resultsBL.get("error")) );
							closeWindow = "Y";
						}
						strBLMessage = (String) resultsBL.get("message");
						message.put("bl_message",strBLMessage);
						strBLMessage = "";
						hashtableBL.clear();
						resultsBL.clear();
					}
					catch(Exception exceptionBL)
					{
						result = false;
						sb.append("Exception in Billing "+exceptionBL.toString());
						sb.append("<br>...");
					}
				}  // End of BL Operational
				else
				{
					 message.put("bl_message","");
				}

				if (result)
				{
					String pat_file_no		= "" ;
					StringBuffer fileBuffer = new StringBuffer();
					try
					{
						/*String installSql = "select install_yn from SM_MODULE where module_id = 'FM'";
						if (resultSet != null) resultSet.close();
						if (preStatement != null)	preStatement.close();
						preStatement = connection.prepareStatement(installSql);
						resultSet = preStatement.executeQuery();
						String fm_install_yn = "N" ;
						if (resultSet.next())
							fm_install_yn = checkForNull(resultSet.getString("install_yn"));*/

						if(fm_install_yn.equals("Y"))
						{
							fileBuffer.append("select file_no, file_type_code, volume_no from FM_CURR_LOCN where VOLUME_STATUS='A' and facility_id='");
							fileBuffer.append(facilityId);
							fileBuffer.append("' and patient_id ='");
							fileBuffer.append(patient_id);
							fileBuffer.append("' ");
							if (resultSet != null) resultSet.close();
							if (preStatement != null)	preStatement.close();
							preStatement = connection.prepareStatement(fileBuffer.toString());
							resultSet = preStatement.executeQuery();
							if ( (resultSet != null) && (resultSet.next()) )
							{
								file_type_code	= checkForNull(resultSet.getString("file_type_code"));
								volume_no		= checkForNull(resultSet.getString("volume_no"));
								pat_file_no		= checkForNull(resultSet.getString("FILE_NO"));
							}

							// Commenetd as part of PE By Sudhakar
							/*StringBuffer locationBuffer = new StringBuffer();
							locationBuffer.append("select fs_locn_code, online_mr_notfn_yn from IP_NURSING_UNIT ");
							locationBuffer.append("where facility_id = '");
							locationBuffer.append(facilityId);
							locationBuffer.append("' and  nursing_unit_code = '");
							locationBuffer.append(nursing_unit_code);
							locationBuffer.append("' ");

							if (resultSet != null) resultSet.close();
							if (preStatement != null)	preStatement.close();
							preStatement = connection.prepareStatement(locationBuffer.toString());
							resultSet = preStatement.executeQuery();
							String online_mr_notfn_yn = "N" ;
							String fs_locn_code		= "N" ;
							if ( (resultSet != null) && (resultSet.next()) )
							{
								fs_locn_code	   = checkForNull(resultSet.getString("fs_locn_code"));
								online_mr_notfn_yn = checkForNull(resultSet.getString("online_mr_notfn_yn"),"N");
							}*/
							
						
							if( fm_install_yn.equals("Y") && online_mr_notfn_yn.equals("Y") && fs_locn_code != "" && pat_file_no != "" && !nursing_unit_code.equals(from_nursing_unit_code) )
							{
								StringBuffer strBuffer = new StringBuffer();
								String P_narration_code = "";
								String req_no           = "";
								String perm_fs_locn     = "";
								//strBuffer.append("{ call FM_REQUEST_FILE ('"+facilityId+"', '"+fs_locn_code+"', '"+addedById+"', '"+pat_file_no+"', '"+file_type_code+"', '"+volume_no+"', '"+nursing_unit_code+"', '"+P_narration_code+"', '"+modifiedAtWorkstation+"', '"+practid+"', '"+encounterId+"') } ");
								/*Monday, December 28, 2009 IN017639*/
								strBuffer.append("{ call FM_REQUEST_FILE (?,?,?,?,?,?,?,?,?,?,?,?,?) } ");

								CallableStatement cs1 = connection.prepareCall( strBuffer.toString() ) ;
								cs1.setString(1,facilityId);
								cs1.setString(2,fs_locn_code);
								cs1.setString(3,addedById);
								cs1.setString(4,pat_file_no);
								cs1.setString(5,file_type_code);
								cs1.setString(6,volume_no);
								cs1.setString(7,nursing_unit_code);
								cs1.setString(8,P_narration_code);
								cs1.setString(9,modifiedAtWorkstation);
								cs1.setString(10,practid);
								cs1.setString(11,encounterId);
								/*Monday, December 28, 2009 IN017639*/
								cs1.registerOutParameter(12,java.sql.Types.VARCHAR);
								cs1.registerOutParameter(13,java.sql.Types.VARCHAR);
								cs1.execute() ;
								
								req_no = cs1.getString(12);						
								perm_fs_locn = cs1.getString(13);	 

								if(cs1 != null)cs1.close();
							}
							result = true;
						}
					}
					catch(Exception exception)
					{
						result = false;
						exception.printStackTrace();
						//sb.append("Exception in File Request in AssignBEd eJB : "+exception.toString());
						//sb.append("<br>...");

					}
				}

				if (result && (res1 >0) && (res2 >0) && (res3 >0) && (res4 >0) && (res5 >0))
				{
					connection.commit();
					result = true;
					sb1.append("Comm"+resultMess);
					if(result && resultMess)
					{
						message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
						sb.append((String) message.get("message"));
						message.clear();
					}
				}
				else
				{
					connection.rollback();
					result = false;
				}
			}//End of modified dates check.
			else
			{
				result = false;
				closeWindow = "Y";
				message.clear();
				message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
				sb.append((String) message.get("message"));
				message.clear();
			}
		}
		catch(Exception e)
		{
			sb.append("Connection rolling back.. Record not modified : "+e.toString());
			sb.append("<br>...");
			result = false;
			try
			{
				connection.rollback();
				connection.setAutoCommit(true);
				e.printStackTrace();
			}
			catch ( Exception e1 )
			{
			}
		}
	 finally
	 {
		try
		{
			 if(preStatement!=null) preStatement.close();
			 if(resultSet!=null) resultSet.close();
			 if(statement!=null) statement.close();
		}catch(Exception exc)
		{
			exc.printStackTrace();
		}
		if(connection!=null) ConnectionManager.returnConnection(connection,p);
	 }

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "errors", sb1.toString() ) ;
		results.put( "closeWindow", closeWindow) ;
		results.put( "bl_message", (String)message.get("bl_message")) ;
		message.clear();
		paramHashTab.clear();
		return results;
	}//e.o. insertAssignBed method
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

}// E.O.Session Bean
