/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
 
public class IPAdvBedMgmtBean implements Serializable{	
	
	public static ArrayList getNursingUnitRoomBedTrnsData(Connection con,Statement stmt,ResultSet rs,String nursingUnit,String facility_id,String language_id,String user_id,String bl_operational)throws Exception{
		//System.out.println("IPRoomBedMgmtBean getNursingUnitRoomData:");
		String ipNursingUnitRoomSql = "SELECT a.room_no, am_get_desc.am_facility_room (a.facility_id,a.room_no,?,'1') room_name, a.room_left_position, a.room_top_position, a.room_height,   a.room_width FROM ip_nursing_unit_room a WHERE a.facility_id = ? AND a.nursing_unit_code = ? and ROOM_WIDTH is not null and ROOM_HEIGHT is not null and a.room_no not in (select room_no from ip_nursing_unit_bed b where b.FACILITY_ID=a.facility_id and b.NURSING_UNIT_CODE =a.NURSING_UNIT_CODE and b.ROOM_NO=a.room_no and b.BED_HEIGHT is not null and b.BED_WIDTH is not null)";
		//String ipNursingUnitRoomSql = "select ROOM_NO,ROOM_LEFT_POSITION,ROOM_TOP_POSITION,ROOM_HEIGHT,ROOM_WIDTH from ip_nursing_unit_room where nursing_unit_code='"+nursingUnit+"' and ROOM_WIDTH is not null";
		//String ipRoomBedSql = "select BED_NO,BED_LEFT_POSITION,BED_TOP_POSITION,BED_HEIGHT,BED_WIDTH from ip_nursing_unit_bed where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=? and BED_LEFT_POSITION is not null";
		/**
		 * Change done to include an extra clause "and order_category = 'PH'" in addition to 
		 * the existing clause "order_line_status in ('CN','DC','HC','HT')"
		 * This change is done to increase performance of the SQL query execution
		 */
		/**
		 * The below line was the used to get the bed information
		 * this has been commented as there is a change in code done and saved in dev server
		 * and not in the SVN server
		 */
		//String bedChartSQL="select (select (case    when booking_status = '1' and override_yn = 'Y' then 'BOC' when booking_status = '0' and override_yn = 'Y' then 'BOU' when booking_status = '1' and override_yn = 'N' then 'BNC' when booking_status = '0' and override_yn = 'N' then 'BNU' else	'N' end)from ip_bed_booking where  req_bed_no = a.bed_no and  req_room_no = a.room_no and req_bed_class_code = a.bed_class_code and req_bed_type_code = a.bed_type_code and req_nursing_unit_code = a.nursing_unit_code and ( trunc(blocked_from_date_time) >= sysdate and ((trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_boc and booking_status = '1' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bou and booking_status = '0' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnc and booking_status = '1' and override_yn = 'N')	or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnu and booking_status = '0' and override_yn = 'N')))	and rownum=1) days_before_status,   am_get_desc.AM_FACILITY_ROOM(a.facility_id, a.room_no,'"+language_id+"','2')group1,  bkg_patient_id, booking_type,CASE WHEN c.admission_type IS NOT NULL THEN ip_get_desc.ip_admission_type (c.admission_type,'"+language_id+"', '2'  ) WHEN c.admission_type IS NULL THEN (SELECT ip_get_desc.ip_admission_type (i.admission_type, '"+language_id+"',  '2' ) admission_type FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END ADMISSION_TYPE, b.referral_id, pseudo_bed_yn, a.nursing_unit_code, c.pat_curr_locn_code,  a.bed_no, a.main_bed_no, a.bed_no || decode( a.sex_spec_ind, null, '' ) bed_no_label, a.bed_type_code, a.bed_class_code,(select ALLOW_BED_SWAP_YN from ip_bed_class where BED_CLASS_CODE=a.bed_class_code)ALLOW_BED_SWAP_YN, ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+language_id+"','2') nursing_unit_short_desc, a.room_no,  ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,'"+language_id+"','2') Bed_Class_Short_desc, b.override_yn, ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+language_id+"','2')bed_type_short_desc,  (CASE WHEN a.Specialty_Code IS NOT NULL  THEN (Am_Get_desc.Am_speciality(a.Specialty_Code,'"+language_id+"','2')) ELSE '*All SPLTY*' END) specialty_short_desc,  a.specialty_code, a.occupying_patient_id patient_id,  nvl(c.encounter_id, b.encounter_id) encounter_id,  d.patient_name patient_name , nvl(d.patient_name_loc_lang,d.patient_name) patient_name_loc_lang , nvl(b.bkg_patient_name, b.patient_name) bg_patient_name , nvl(b.patient_name_loc_lang,d.patient_name_loc_lang) bg_patient_name_loc_lang ,  d.sex gender,b.bkg_gender bkg_gender, d.nationality_code, e.appl_patient_class,  mp_Get_desc.Mp_country(d.Nationality_Code,'"+language_id+"','1') nationality_long_desc,  get_age(d.date_of_birth) age,get_age(b.bgk_date_of_birth)bkg_age,  CASE WHEN c.admission_date_time IS NOT NULL THEN TO_CHAR (c.admission_date_time,'dd/mm/rrrr hh24:mi') WHEN c.admission_date_time IS NULL THEN (SELECT TO_CHAR (i.admission_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_date_time,  CASE WHEN c.exp_discharge_date_time IS NOT NULL THEN TO_CHAR (c.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') WHEN c.exp_discharge_date_time IS NULL THEN (SELECT TO_CHAR (i.exp_discharge_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END exp_discharge_date_time,  to_char(b.expected_discharge_date,'dd/mm/rrrr hh24:mi') bkg_exp_discharge_date_time,  (case when a.occupied_until_date_time > sysdate then ROUND (TO_CHAR (a.occupied_until_date_time - SYSDATE)) end) exp_no_of_days,  b.blocking_type_short_desc,  b.exp_days_of_stay,  ( CASE   WHEN a.occupying_patient_id IS NOT NULL THEN 'O'  WHEN b.booking_type IS NULL THEN 'A'  WHEN b.booking_type in ('N','B','L','T','D') THEN 'B'  END ) bed_status,  to_char(b.blocked_from, 'dd/mm/rrrr hh24:mi') blocked_from, to_char(b.blocked_until,'dd/mm/rrrr hh24:mi') blocked_until, b.Practitioner_Name bkg_Practitioner_Name,  Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,'"+language_id+"','1') practitioner_name, b.bed_booking_ref_no, b.booking_date_time, b.blocking_type_code, b.blocking_remarks, c.service_code service_code,  Am_Get_desc.Am_service(c.Service_Code,'"+language_id+"','2') service_desc,  (CASE WHEN c.Service_Code IS NOT NULL  THEN (SELECT Ancillary_yn FROM Am_Service WHERE  Service_Code = c.Service_Code) END) Ancillary_yn,  null dly_charge, (CASE WHEN d.Pat_Cat_Code IS NOT NULL  THEN (mp_Get_desc.Mp_pat_category(d.Pat_Cat_Code,'"+language_id+"','2')) END) Pat_Cat_Short_desc,  oth_adt_status, a.psuedo_bed_status, a.main_bed_no,  b.booking_status, b.booking_remarks,  CASE WHEN c.CHIEF_COMPLAINT IS NOT NULL THEN am_get_desc.AM_COMPLAINT (c.CHIEF_COMPLAINT,'"+language_id+"', '1'  ) WHEN c.CHIEF_COMPLAINT IS NULL THEN (SELECT am_get_desc.AM_COMPLAINT (i.CHIEF_COMPLAINT, '"+language_id+"',  '1' ) admission_reason FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_reason  , am_get_desc.AM_COMPLAINT(b.CHIEF_COMPLAINT,'"+language_id+"','1')booking_reason ,(SELECT bl.short_desc financial_classification FROM bl_episode_fin_dtls a, bl_blng_grp_lang_vw bl WHERE bl.language_id = '"+language_id+"' and a.blng_grp_id = bl.blng_grp_id  AND a.operating_facility_id = c.facility_id AND a.episode_id = c.encounter_id AND a.patient_id = c.patient_id) financial_classification ,(SELECT bl.short_desc financial_classification FROM bl_booking_fin_dtls a,  bl_blng_grp bl WHERE a.blng_grp_id = bl.blng_grp_id AND a.operating_facility_id = b.facility_id AND a.appt_book_ref_num = b.bed_booking_ref_no and b.booking_type = 'L')bkg_financial_classification,r.ROOM_LEFT_POSITION,r.room_top_position,r.room_width,r.room_height,a.BED_LEFT_POSITION,a.bed_top_position,a.BED_WIDTH,a.BED_HEIGHT,d.KNOWN_ALLERGY_YN,(CASE WHEN c.encounter_id IS NOT NULL THEN (SELECT COUNT(*) overdue_count FROM ph_medn_admin WHERE facility_id = c.FACILITY_ID AND encounter_id = c.encounter_id and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) AND sch_date_time BETWEEN TO_DATE (TO_CHAR(SYSDATE - (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND TO_DATE (TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND administered_yn = 'N') END)overdue_count,(CASE WHEN c.encounter_id IS NOT NULL THEN (SELECT COUNT(*) due_count     from ph_medn_admin where   facility_id=c.FACILITY_ID and encounter_id = c.encounter_id and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) and SCH_DATE_TIME between to_date (to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') and to_date(to_char(sysdate + (30/1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') and ADMINISTERED_YN='N') END)due_count,c.encounter_id open_encounter  FROM  IP_NURSING_UNIT_BED a  ,IP_OPEN_ENCOUNTER c  ,MP_PATIENT d  ,IP_NURSING_UNIT e  , ip_param f  ,(select  bkglst.exp_days_of_stay, bkg.override_yn, Nvl(bkglst.Patient_Name,Pat.Patient_Name) Patient_Name, Nvl(bkglst.patient_name_loc_lang,Pat.patient_name_loc_lang) patient_name_loc_lang,bkg.encounter_id, bkg.facility_id, bkg.booking_type, bkg.bed_booking_ref_no, bkg.req_nursing_unit_code, bkg.req_bed_no, bkg.blocking_type_code, ip_Get_desc.Ip_blocking_type(bkg.BlockIng_Type_Code,'"+language_id+"','2') BlockIng_Type_Short_desc, bkg.blocking_remarks, bkg.blocked_from_date_time blocked_from, bkg.blocked_until_date_time blocked_until, nvl(bkglst.patient_id , bkg.patient_id) bkg_patient_id, decode(bkglst.patient_id, null , pat.patient_name, bkglst.patient_name) bkg_patient_name, NVL (bkglst.gender, pat.sex) bkg_gender, bkglst.referral_id, Nvl(bkglst.Date_Of_Birth,Pat.Date_Of_Birth) bgk_Date_Of_Birth, NVL(bkglst.expected_discharge_date,bkg.blocked_until_date_time) expected_discharge_date,  (CASE WHEN bkglst.Practitioner_Id IS NULL  THEN (Am_Get_desc.Am_practitioner(bkg.req_Practitioner_Id,'"+language_id+"','1')) ELSE (Am_Get_desc.Am_practitioner(bkglst.Practitioner_Id,'"+language_id+"','1')) END) Practitioner_Name,  to_char(bkglst.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, nvl(bkglst.booking_status,bkg.booking_status)booking_status, bkglst.booking_remarks,bkg.patient_id,bkglst.chief_complaint  FROM  IP_BED_BOOKING bkg, IP_BOOKING_LIST bkglst, MP_PATIENT pat  WHERE  bkg.booking_status in ('0','1')  and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy'))  and bkg.booking_date_time=(select max (booking_date_time)  from IP_BED_BOOKING where facility_id = bkg.facility_id  and req_nursing_unit_code = bkg.req_nursing_unit_code  and req_bed_no = bkg.req_bed_no  and booking_status in ('0','1')  and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')))  and bkglst.facility_id(+) = bkg.facility_id  and bkglst.bkg_lst_ref_no(+) = bkg.bed_booking_ref_no  and pat.patient_id(+) = bkg.patient_id ) b ,ip_nursing_unit_room r WHERE  a.nursing_unit_code = e.nursing_unit_code  and a.nursing_unit_code='"+nursingUnit+"'   AND a.bed_no LIKE '%%'  and a.facility_id = '"+facility_id+"'  and a.eff_status = 'E'  and e.eff_status = 'E'  AND b.facility_id(+) = a.facility_id  AND b.req_nursing_unit_code (+) = a.nursing_unit_code  AND b.req_bed_no(+) = a.bed_no   AND a.Facility_Id = e.Facility_Id  AND a.Facility_Id = c.Facility_Id (+)  AND a.OccupyIng_Patient_Id = c.Patient_Id (+)  AND a.OccupyIng_Patient_Id = d.Patient_Id (+)   /*and a.psuedo_bed_status != 'C'*/ and a.facility_id = f.facility_id and r.facility_id=a.facility_id and r.room_no=a.room_no and r.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE /*and a.bed_width is not null and r.room_width is not null*/  order by  room_no,bed_no";
		
		String bedChartSQL = getABMLayoutDataHugeQuery(nursingUnit,facility_id);
		//System.out.println("ipNursingUnitRoomSql @ getNursingUnitRoomBedTrnsData:"+ipNursingUnitRoomSql);
		//System.out.println("bedChartSQL @ getNursingUnitRoomBedTrnsData:"+bedChartSQL);
		
		/**
		 * This is the line of code saved in dev server and not present in svn server
		 * this code is retained as there is extra information retrieved by this query
		 * also the performance optimization done has been integrated into this query
		 */
		//String bedChartSQL="select (select (case    when booking_status = '1' and override_yn = 'Y' then 'BOC' when booking_status = '0' and override_yn = 'Y' then 'BOU' when booking_status = '1' and override_yn = 'N' then 'BNC' when booking_status = '0' and override_yn = 'N' then 'BNU' else	'N' end)from ip_bed_booking where  req_bed_no = a.bed_no and  req_room_no = a.room_no and req_bed_class_code = a.bed_class_code and req_bed_type_code = a.bed_type_code and req_nursing_unit_code = a.nursing_unit_code and ( trunc(blocked_from_date_time) >= sysdate and ((trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_boc and booking_status = '1' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bou and booking_status = '0' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnc and booking_status = '1' and override_yn = 'N')	or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnu and booking_status = '0' and override_yn = 'N')))	and rownum=1) days_before_status,   am_get_desc.AM_FACILITY_ROOM(a.facility_id, a.room_no,?,'2')group1,  bkg_patient_id, booking_type,CASE WHEN c.admission_type IS NOT NULL THEN ip_get_desc.ip_admission_type (c.admission_type,?, '2'  ) WHEN c.admission_type IS NULL THEN (SELECT ip_get_desc.ip_admission_type (i.admission_type,?,  '2' ) admission_type FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END ADMISSION_TYPE, b.referral_id, pseudo_bed_yn, a.nursing_unit_code, c.pat_curr_locn_code,  a.bed_no, a.main_bed_no, a.bed_no || decode( a.sex_spec_ind, null, '' ) bed_no_label, a.bed_type_code, a.bed_class_code,(select ALLOW_BED_SWAP_YN from ip_bed_class where BED_CLASS_CODE=a.bed_class_code)ALLOW_BED_SWAP_YN, ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,?,'2') nursing_unit_short_desc, a.room_no,  ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,?,'2') Bed_Class_Short_desc, b.override_yn, ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,?,'2')bed_type_short_desc,  (CASE WHEN a.Specialty_Code IS NOT NULL  THEN (Am_Get_desc.Am_speciality(a.Specialty_Code,?,'2')) ELSE '*All SPLTY*' END) specialty_short_desc,  a.specialty_code, a.occupying_patient_id patient_id,  nvl(c.encounter_id, b.encounter_id) encounter_id,  d.patient_name patient_name , nvl(d.patient_name_loc_lang,d.patient_name) patient_name_loc_lang , nvl(b.bkg_patient_name, b.patient_name) bg_patient_name , nvl(b.patient_name_loc_lang,d.patient_name_loc_lang) bg_patient_name_loc_lang ,  d.sex gender,b.bkg_gender bkg_gender, d.nationality_code, e.appl_patient_class,  mp_Get_desc.Mp_country(d.Nationality_Code,?,'1') nationality_long_desc,  get_age(d.date_of_birth) age,get_age(b.bgk_date_of_birth)bkg_age,  CASE WHEN c.admission_date_time IS NOT NULL THEN TO_CHAR (c.admission_date_time,'dd/mm/rrrr hh24:mi') WHEN c.admission_date_time IS NULL THEN (SELECT TO_CHAR (i.admission_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_date_time,  CASE WHEN c.exp_discharge_date_time IS NOT NULL THEN TO_CHAR (c.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') WHEN c.exp_discharge_date_time IS NULL THEN (SELECT TO_CHAR (i.exp_discharge_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END exp_discharge_date_time,  to_char(b.expected_discharge_date,'dd/mm/rrrr hh24:mi') bkg_exp_discharge_date_time,  (case when a.occupied_until_date_time > sysdate then ROUND (TO_CHAR (a.occupied_until_date_time - SYSDATE)) end) exp_no_of_days,  b.blocking_type_short_desc,  b.exp_days_of_stay,  ( CASE   WHEN a.occupying_patient_id IS NOT NULL THEN 'O'  WHEN b.booking_type IS NULL THEN 'A'  WHEN b.booking_type in ('N','B','L','T','D') THEN 'B'  END ) bed_status,  to_char(b.blocked_from, 'dd/mm/rrrr hh24:mi') blocked_from, to_char(b.blocked_until,'dd/mm/rrrr hh24:mi') blocked_until, b.Practitioner_Name bkg_Practitioner_Name,  Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,?,'1') practitioner_name, b.bed_booking_ref_no, b.booking_date_time, b.blocking_type_code, b.blocking_remarks, c.service_code service_code,  Am_Get_desc.Am_service(c.Service_Code,?,'2') service_desc,  (CASE WHEN c.Service_Code IS NOT NULL  THEN (SELECT Ancillary_yn FROM Am_Service WHERE  Service_Code = c.Service_Code) END) Ancillary_yn,  null dly_charge, (CASE WHEN d.Pat_Cat_Code IS NOT NULL  THEN (mp_Get_desc.Mp_pat_category(d.Pat_Cat_Code,?,'2')) END) Pat_Cat_Short_desc,  oth_adt_status, a.psuedo_bed_status, a.main_bed_no,  b.booking_status, b.booking_remarks,  CASE WHEN c.CHIEF_COMPLAINT IS NOT NULL THEN am_get_desc.AM_COMPLAINT (c.CHIEF_COMPLAINT,?, '1'  ) WHEN c.CHIEF_COMPLAINT IS NULL THEN (SELECT am_get_desc.AM_COMPLAINT (i.CHIEF_COMPLAINT,?,  '1' ) admission_reason FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_reason  , am_get_desc.AM_COMPLAINT(b.CHIEF_COMPLAINT,?,'1')booking_reason ,(SELECT bl.short_desc financial_classification FROM bl_episode_fin_dtls a, bl_blng_grp_lang_vw bl WHERE bl.language_id = ? and a.blng_grp_id = bl.blng_grp_id  AND a.operating_facility_id = c.facility_id AND a.episode_id = c.encounter_id AND a.patient_id = c.patient_id) financial_classification ,(SELECT bl.short_desc financial_classification FROM bl_booking_fin_dtls a,  bl_blng_grp bl WHERE a.blng_grp_id = bl.blng_grp_id AND a.operating_facility_id = b.facility_id AND a.appt_book_ref_num = b.bed_booking_ref_no and b.booking_type = 'L')bkg_financial_classification,r.ROOM_LEFT_POSITION,r.room_top_position,r.room_width,r.room_height,a.BED_LEFT_POSITION,a.bed_top_position,a.BED_WIDTH,a.BED_HEIGHT,d.KNOWN_ALLERGY_YN,(CASE WHEN c.encounter_id IS NOT NULL THEN (SELECT COUNT(*) overdue_count FROM ph_medn_admin WHERE facility_id = c.FACILITY_ID AND encounter_id = c.encounter_id and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) AND sch_date_time BETWEEN TO_DATE (TO_CHAR(SYSDATE - (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND TO_DATE (TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND administered_yn = 'N') END)overdue_count,(CASE WHEN c.encounter_id IS NOT NULL THEN (SELECT COUNT(*) due_count     from ph_medn_admin where   facility_id=c.FACILITY_ID and encounter_id = c.encounter_id and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) and SCH_DATE_TIME between to_date (to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') and to_date(to_char(sysdate + (30/1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') and ADMINISTERED_YN='N') END)due_count,c.encounter_id open_encounter,(select count(*) from or_order_line where ordeR_id in (select order_id from or_order where patient_id = c.patient_id and encounteR_id = c.ENCOUNTER_ID and ordering_facility_id = c.FACILITY_ID and order_line_Status = 'OS' and order_category !='PH' ))ost_orders_count  FROM  IP_NURSING_UNIT_BED a  ,IP_OPEN_ENCOUNTER c  ,MP_PATIENT d  ,IP_NURSING_UNIT e  , ip_param f  ,(select  bkglst.exp_days_of_stay, bkg.override_yn, Nvl(bkglst.Patient_Name,Pat.Patient_Name) Patient_Name, Nvl(bkglst.patient_name_loc_lang,Pat.patient_name_loc_lang) patient_name_loc_lang,bkg.encounter_id, bkg.facility_id, bkg.booking_type, bkg.bed_booking_ref_no, bkg.req_nursing_unit_code, bkg.req_bed_no, bkg.blocking_type_code, ip_Get_desc.Ip_blocking_type(bkg.BlockIng_Type_Code,?,'2') BlockIng_Type_Short_desc, bkg.blocking_remarks, bkg.blocked_from_date_time blocked_from, bkg.blocked_until_date_time blocked_until, nvl(bkglst.patient_id , bkg.patient_id) bkg_patient_id, decode(bkglst.patient_id, null , pat.patient_name, bkglst.patient_name) bkg_patient_name, NVL (bkglst.gender, pat.sex) bkg_gender, bkglst.referral_id, Nvl(bkglst.Date_Of_Birth,Pat.Date_Of_Birth) bgk_Date_Of_Birth, NVL(bkglst.expected_discharge_date,bkg.blocked_until_date_time) expected_discharge_date,  (CASE WHEN bkglst.Practitioner_Id IS NULL  THEN (Am_Get_desc.Am_practitioner(bkg.req_Practitioner_Id,?,'1')) ELSE (Am_Get_desc.Am_practitioner(bkglst.Practitioner_Id,?,'1')) END) Practitioner_Name,  to_char(bkglst.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, nvl(bkglst.booking_status,bkg.booking_status)booking_status, bkglst.booking_remarks,bkg.patient_id,bkglst.chief_complaint  FROM  IP_BED_BOOKING bkg, IP_BOOKING_LIST bkglst, MP_PATIENT pat  WHERE  bkg.booking_status in ('0','1')  and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy'))  and bkg.booking_date_time=(select max (booking_date_time)  from IP_BED_BOOKING where facility_id = bkg.facility_id  and req_nursing_unit_code = bkg.req_nursing_unit_code  and req_bed_no = bkg.req_bed_no  and booking_status in ('0','1')  and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')))  and bkglst.facility_id(+) = bkg.facility_id  and bkglst.bkg_lst_ref_no(+) = bkg.bed_booking_ref_no  and pat.patient_id(+) = bkg.patient_id ) b ,ip_nursing_unit_room r WHERE  a.nursing_unit_code = e.nursing_unit_code  and a.nursing_unit_code=?   AND a.bed_no LIKE '%%'  and a.facility_id = ?  and a.eff_status = 'E'  and e.eff_status = 'E'  AND b.facility_id(+) = a.facility_id  AND b.req_nursing_unit_code (+) = a.nursing_unit_code  AND b.req_bed_no(+) = a.bed_no   AND a.Facility_Id = e.Facility_Id  AND a.Facility_Id = c.Facility_Id (+)  AND a.OccupyIng_Patient_Id = c.Patient_Id (+)  AND a.OccupyIng_Patient_Id = d.Patient_Id (+)   /*and a.psuedo_bed_status != 'C'*/ and a.facility_id = f.facility_id and r.facility_id=a.facility_id and r.room_no=a.room_no and r.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE /*and a.bed_width is not null and r.room_width is not null*/  order by  room_no,bed_no";
		
		
		ResultSet 			bedRs		= null;
		ResultSet 			abs_rslt_set= null;
		PreparedStatement	bedPstmt	= null;
		PreparedStatement	ipAdvPstmt	= null;
		PreparedStatement 	pstmt		= null;
		PreparedStatement 	pstmt2		= null;
		ArrayList floorRoomBedList 	= new ArrayList();
		ArrayList roomList			= new ArrayList();
		int count=0;
		ArrayList roomBedsList = new ArrayList();
		HashMap roomsMap = new HashMap();
		HashMap colorCodingmap=IPAdvBedMgmtConfigBean.getBedConfSetupData(con);
		HashMap bedCountMap= new HashMap();
		int vacantNormalBeds=0;
		int vacantPseudoBeds=0;
		int occupiedNormalBeds=0;
		int occupiedPseudoBeds=0;
		int occupiedDepartedBeds=0;
		int reservedBeds=0;
		int blkdOverrideBeds=0;
		int blkdNonOverrideBeds=0;
		//System.out.println("colorCodingmap @getNursingUnitRoomBedTrnsData:"+colorCodingmap.toString());
		try{
			HashMap paramMap=getParamOprStnData(con,bedPstmt,rs,facility_id,user_id);
			String future_booking_for_boc_yn=(String)paramMap.get("future_booking_for_boc_yn");
			String future_booking_for_bou_yn=(String)paramMap.get("future_booking_for_bou_yn");
			String future_booking_for_bnc_yn=(String)paramMap.get("future_booking_for_bnc_yn");
			String future_booking_for_bnu_yn=(String)paramMap.get("future_booking_for_bnu_yn");
			
			/**
			 * Below code is commented as the same has been set in below section
			 */
			//rs=stmt.executeQuery(ipNursingUnitRoomSql);	
			//ResultSet abs_rslt_set=null;
			//PreparedStatement pstmt=con.prepareStatement("SELECT   count(*)rslt_count FROM cr_encounter_detail a,cr_his_rectyp_lng_vw b,cr_event_class_lang_vw c,        cr_cln_evt_mst_lang_vw d,cr_cln_evt_grp_lang_vw e  WHERE b.language_id = ? AND b.hist_rec_type = a.hist_rec_type AND c.hist_rec_type = a.hist_rec_type AND c.event_class = a.event_class AND c.language_id = ? AND d.language_id = ? AND d.hist_rec_type = a.hist_rec_type AND d.event_code = a.event_code AND d.event_code_type = a.event_code_type  AND e.language_id(+) = ? AND e.hist_rec_type(+) = a.hist_rec_type AND e.event_group(+) = a.event_group AND e.event_group_type(+) = a.event_group_type AND patient_id = ? and Not exists (select 'Y' from ca_result_review_done_log where ACCESSION_NUM = a.ACCESSION_NUM and HIST_REC_TYPE = a.HIST_REC_TYPE and  CONTR_SYS_ID=a.CONTR_SYS_ID) AND (   a.event_date BETWEEN (SYSDATE - 1) AND (SYSDATE)  OR a.event_auth_date_time BETWEEN (SYSDATE - 1) AND (SYSDATE)) AND (   (    a.hist_rec_type != 'LBIN' AND a.event_date IN(SELECT event_date FROM (SELECT event_date,DENSE_RANK () OVER (ORDER BY event_date DESC)drank,RANK () OVER (ORDER BY event_date DESC)RANK FROM cr_encounter_detail WHERE patient_id = ? AND event_date BETWEEN SYSDATE - 1 AND SYSDATE) WHERE RANK < 10 OR drank < 2))OR(a.hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' AND a.event_auth_date_time IN(SELECT event_auth_date_time FROM (SELECT event_auth_date_time,DENSE_RANK () OVER (ORDER BY event_auth_date_time DESC)drank,RANK () OVER (ORDER BY event_auth_date_time DESC)RANK FROM cr_encounter_detail WHERE patient_id = ? AND event_auth_date_time BETWEEN SYSDATE - 1 AND SYSDATE) WHERE RANK < 10 OR drank < 2))) AND (NVL (a.protection_ind, 'N') != 'Z') AND NVL (a.status, '`') NOT IN ('S', 'E') /*ORDER BY CASE  WHEN a.hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' THEN a.event_auth_date_time  ELSE a.event_date END DESC, hist_rec_type, event_class_desc,a.event_class,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code*/");
			/**
			 * Change done to include an extra clause "and order_category = 'PH'" in addition to 
			 * the existing clause "order_line_status in ('CN','DC','HC','HT')"
			 * This change is done to increase performance of the SQL query execution
			 */
			//PreparedStatement pstmt2=con.prepareStatement("select (SELECT TO_CHAR (sch_date_time, 'hh24:mi') over_due_time FROM (SELECT   sch_date_time FROM ph_medn_admin  WHERE facility_id = ? AND encounter_id =?  and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT')  and order_category = 'PH' )) AND sch_date_time BETWEEN TO_DATE(TO_CHAR(SYSDATE- (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss')AND TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss')AND administered_yn = 'N' ORDER BY 1 DESC) where rownum<2)overdue_time,(SELECT TO_CHAR (sch_date_time, 'hh24:mi') due_time FROM (SELECT sch_date_time FROM ph_medn_admin WHERE facility_id =? AND encounter_id =?  and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) AND sch_date_time BETWEEN TO_DATE(TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND TO_DATE(TO_CHAR (SYSDATE + (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss')AND administered_yn = 'N'  ORDER BY 1 ASC) where rownum<2)due_time from dual");

			/**
			 * below code executes the SQL query using preparedstatement
			 * done for optimization
			 */
			if(bedPstmt!=null)bedPstmt.close();
			bedPstmt=con.prepareStatement(ipNursingUnitRoomSql);
			bedPstmt.setString(1,language_id);
			bedPstmt.setString(2,facility_id);
			bedPstmt.setString(3,nursingUnit);
			rs=bedPstmt.executeQuery();
			
			
			if(rs!=null){				
				while(rs.next()){
					String roomNo=rs.getString("ROOM_NO");
					String roomName=rs.getString("room_name");
					String roomTopPos=rs.getString("ROOM_TOP_POSITION")==null?"0":rs.getString("ROOM_TOP_POSITION");
					String roomLeftPos=rs.getString("ROOM_LEFT_POSITION")==null?"0":rs.getString("ROOM_LEFT_POSITION");
					String roomWidth=rs.getString("ROOM_WIDTH")==null?"0":rs.getString("ROOM_WIDTH");
					String roomHeight=rs.getString("ROOM_HEIGHT")==null?"0":rs.getString("ROOM_HEIGHT");
					roomsMap = new HashMap();
					roomsMap.put("roomNo",roomNo);
					roomsMap.put("roomName",roomName);
					roomsMap.put("roomTopPos",roomTopPos);
					roomsMap.put("roomLeftPos",roomLeftPos);
					roomsMap.put("roomWidth",roomWidth);
					roomsMap.put("roomHeight",roomHeight);
					roomsMap.put("room_clr",(String)colorCodingmap.get("room_clr"));
					floorRoomBedList.add(roomsMap);
				}
			}
			if(rs!=null)rs.close();
			
			ipAdvPstmt=con.prepareStatement(bedChartSQL);
			
			// new code
			ipAdvPstmt.setString(1,language_id);
			ipAdvPstmt.setString(2,language_id);
			ipAdvPstmt.setString(3,language_id);
			ipAdvPstmt.setString(4,language_id);
			ipAdvPstmt.setString(5,language_id);
			ipAdvPstmt.setString(6,language_id);
			ipAdvPstmt.setString(7,language_id);
			
			
			// setting data to the main prepared statement
			// this is commented as this code segment is for
			// the huge query
			/*ipAdvPstmt.setString(1,language_id);
			ipAdvPstmt.setString(2,language_id);
			ipAdvPstmt.setString(3,language_id);
			ipAdvPstmt.setString(4,facility_id);
			ipAdvPstmt.setString(5,language_id);
			ipAdvPstmt.setString(6,language_id);
			ipAdvPstmt.setString(7,language_id);
			ipAdvPstmt.setString(8,language_id);
			ipAdvPstmt.setString(9,language_id);
			ipAdvPstmt.setString(10,facility_id);
			ipAdvPstmt.setString(11,facility_id);
			ipAdvPstmt.setString(12,language_id);
			ipAdvPstmt.setString(13,language_id);
			ipAdvPstmt.setString(14,language_id);
			ipAdvPstmt.setString(15,language_id);
			ipAdvPstmt.setString(16,language_id);
			ipAdvPstmt.setString(17,facility_id);
			ipAdvPstmt.setString(18,language_id);
			ipAdvPstmt.setString(19,language_id);
			ipAdvPstmt.setString(20,language_id);
			ipAdvPstmt.setString(21,language_id);
			ipAdvPstmt.setString(22,language_id);
			ipAdvPstmt.setString(23,nursingUnit);
			ipAdvPstmt.setString(24,facility_id);*/
			
			
			
			// execute the main SQL
			rs=ipAdvPstmt.executeQuery();
			if(rs!=null){
				if(bedPstmt!=null)bedPstmt.close();
								
				String billCheck = "SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST(?,?) disc_bill_exists FROM dual";
				bedPstmt=con.prepareStatement(billCheck);
				
				pstmt=con.prepareStatement("SELECT   count(*)rslt_count FROM cr_encounter_detail a,cr_his_rectyp_lng_vw b,cr_event_class_lang_vw c,        cr_cln_evt_mst_lang_vw d,cr_cln_evt_grp_lang_vw e  WHERE b.language_id = ? AND b.hist_rec_type = a.hist_rec_type AND c.hist_rec_type = a.hist_rec_type AND c.event_class = a.event_class AND c.language_id = ? AND d.language_id = ? AND d.hist_rec_type = a.hist_rec_type AND d.event_code = a.event_code AND d.event_code_type = a.event_code_type  AND e.language_id(+) = ? AND e.hist_rec_type(+) = a.hist_rec_type AND e.event_group(+) = a.event_group AND e.event_group_type(+) = a.event_group_type AND patient_id = ? and Not exists (select 'Y' from ca_result_review_done_log where ACCESSION_NUM = a.ACCESSION_NUM and HIST_REC_TYPE = a.HIST_REC_TYPE and  CONTR_SYS_ID=a.CONTR_SYS_ID) AND (   a.event_date BETWEEN (SYSDATE - 1) AND (SYSDATE)  OR a.event_auth_date_time BETWEEN (SYSDATE - 1) AND (SYSDATE)) AND (   (    a.hist_rec_type != 'LBIN' AND a.event_date IN(SELECT event_date FROM (SELECT event_date,DENSE_RANK () OVER (ORDER BY event_date DESC)drank,RANK () OVER (ORDER BY event_date DESC)RANK FROM cr_encounter_detail WHERE patient_id = ? AND event_date BETWEEN SYSDATE - 1 AND SYSDATE) WHERE RANK < 10 OR drank < 2))OR(a.hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' AND a.event_auth_date_time IN(SELECT event_auth_date_time FROM (SELECT event_auth_date_time,DENSE_RANK () OVER (ORDER BY event_auth_date_time DESC)drank,RANK () OVER (ORDER BY event_auth_date_time DESC)RANK FROM cr_encounter_detail WHERE patient_id = ? AND event_auth_date_time BETWEEN SYSDATE - 1 AND SYSDATE) WHERE RANK < 10 OR drank < 2))) AND (NVL (a.protection_ind, 'N') != 'Z') AND NVL (a.status, '`') NOT IN ('S', 'E') /*ORDER BY CASE  WHEN a.hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' THEN a.event_auth_date_time  ELSE a.event_date END DESC, hist_rec_type, event_class_desc,a.event_class,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code*/");
				
				/**
				 * performance optimization clause has been added to the below query as well
				 */
				pstmt2=con.prepareStatement("select (SELECT TO_CHAR (sch_date_time, 'hh24:mi') over_due_time FROM (SELECT   sch_date_time FROM ph_medn_admin  WHERE facility_id = ? AND encounter_id =?  and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) AND sch_date_time BETWEEN TO_DATE(TO_CHAR(SYSDATE- (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss')AND TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss')AND administered_yn = 'N' ORDER BY 1 DESC) where rownum<2)overdue_time,(SELECT TO_CHAR (sch_date_time, 'hh24:mi') due_time FROM (SELECT sch_date_time FROM ph_medn_admin WHERE facility_id =? AND encounter_id =?  and ((order_id,order_line_num) not in (select order_id,ordeR_line_num from or_order_line  where order_line_status in ('CN','DC','HC','HT') and order_category = 'PH' )) AND sch_date_time BETWEEN TO_DATE(TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND TO_DATE(TO_CHAR (SYSDATE + (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss')AND administered_yn = 'N'  ORDER BY 1 ASC) where rownum<2)due_time from dual");
				while(rs.next()){
					count++;
					String roomNo=rs.getString("ROOM_NO");
					String bedNo=rs.getString("BED_NO");
					String bedTopPos=rs.getString("BED_TOP_POSITION")==null?"0":rs.getString("BED_TOP_POSITION");
					String bedLeftPos=rs.getString("BED_LEFT_POSITION")==null?"0":rs.getString("BED_LEFT_POSITION");
					String bedWidth=rs.getString("BED_WIDTH")==null?"0":rs.getString("BED_WIDTH");
					String bedHeight=rs.getString("BED_HEIGHT")==null?"0":rs.getString("BED_HEIGHT");					
					String pseudoBedYN=rs.getString("PSEUDO_BED_YN");
					String bedStatus=rs.getString("BED_STATUS");
					String booking_status = checkForNull(rs.getString("booking_status"));
					String bedColor=(String)colorCodingmap.get("vacantBed_clr");
					String bedColorExt="";
					String bedTextColor=(String)colorCodingmap.get("vacantbed_text_clr");
					//System.out.println("bedNo @bean:"+bedNo);
					//System.out.println("bedColor @bean11:"+bedColor);
					//System.out.println("bedTextColor @bean11:"+bedTextColor);
					String bedClock="";
					String disc_bill_exists="N";
					String nursingunitcode = rs.getString("nursing_unit_code")==null?"":rs.getString("nursing_unit_code");
					String pat_curr_locn_code = rs.getString("pat_curr_locn_code");
					String bookingType = rs.getString("booking_type")==null?"":rs.getString("booking_type");
					String override = checkForNull(rs.getString("override_yn"),"N");
					String patient_id = checkForNull(rs.getString("patient_id"));
					String pat_age=checkForNull(rs.getString("AGE"));
					String gender=checkForNull(rs.getString("gender"));
					String encounter_id=checkForNull(rs.getString("encounter_id"));
					String admission_date_time=checkForNull(rs.getString("admission_date_time"));
					String exp_discharge_date_time=checkForNull(rs.getString("exp_discharge_date_time"));
					String bed_class_short_desc=checkForNull(rs.getString("bed_class_short_desc"));
					String bed_type_short_desc=checkForNull(rs.getString("bed_type_short_desc"));
					String patient_name=checkForNull(rs.getString("patient_name"));
					String KNOWN_ALLERGY_YN=checkForNull(rs.getString("KNOWN_ALLERGY_YN"));
					String overdue_count=checkForNull(rs.getString("overdue_count"),"0");
					String due_count=checkForNull(rs.getString("due_count"),"0");
					String open_encounter=checkForNull(rs.getString("open_encounter"));
					String ost_orders_count=checkForNull(rs.getString("ost_orders_count"));
					//System.out.println("overdue_count @bean:"+overdue_count);
					//System.out.println("due_count @bean:"+due_count);
					/*String disp_medcation_icon="N";
					if(Integer.parseInt(overdue_count) > 0){
						disp_medcation_icon="over_due";
					}else if(Integer.parseInt(due_count)>0){
						disp_medcation_icon="due";
					}*/
					
					if(patient_name.length()>20){
						patient_name=patient_name.substring(0,20);
					}
					//System.out.println("patient_name 2 @bean:"+patient_name);
					String practitioner_name=checkForNull(rs.getString("practitioner_name"));
					String days_before_status = checkForNull(rs.getString("DAYS_BEFORE_STATUS"));
					String bed_class_code = checkForNull(rs.getString("bed_class_code"));
					String allow_bed_swap_yn = checkForNull(rs.getString("allow_bed_swap_yn"));
					//System.out.println("room_no @bean:"+roomNo);
					//System.out.println("bed_no @bean:"+bedNo);
					//System.out.println("booking_type @bean:"+bookingType);
					//System.out.println("bed_status @bean:"+bedStatus);
					//System.out.println("pseudo_bed_yn @bean:"+pseudoBedYN);
					//System.out.println("booking_status @bean:"+booking_status);
					//System.out.println("override @bean:"+override);
					//System.out.println("days_before_status @bean:"+days_before_status);
					/*starts*/
					if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
						bedClock		= "Y";
						//bedColor 		= "IP_GreenButton_B";// need to display clock
					}
					
					if(bedStatus.equals("A")){
						if(override.equals("N") && booking_status.equals("1") && bookingType.equals("L")){
							//bedColorExt = "IP_PurpleButton";
							bedColorExt = (String)colorCodingmap.get("bkdNonOverrideConfirmBed_clr");
						}else if(override.equals("N") && booking_status.equals("0") && bookingType.equals("L")){
							//bedColorExt = "IP_LpurpleButton";
							bedColorExt = (String)colorCodingmap.get("bkdNonOverrideUnConfirmBed_clr");
						}else if(override.equals("Y") && booking_status.equals("1") && bookingType.equals("L")){
							//bedColorExt = "IP_WoodButton";
							bedColorExt = (String)colorCodingmap.get("bkdOverrideConfirmBed_clr");
						}else if(override.equals("Y") && booking_status.equals("0") && bookingType.equals("L")){
							//bedColorExt = "IP_LWoodButton";
							bedColorExt = (String)colorCodingmap.get("bkdOverrideUnConfirmBed_clr");
						}
					}
					
					if( ( bedStatus.equals("O") || bedStatus.equals("L") || bedStatus.equals("T")) && !pseudoBedYN.equals("Y")  ){
						//bedColor=(String)colorCodingmap.get("occupiedBed_clr");
						bedColor=(String)colorCodingmap.get("occupiedBed_clr");
						bedTextColor=(String)colorCodingmap.get("occupiedbed_text_clr");
						//System.out.println("bedColor @bean22:"+bedColor);
						//System.out.println("bedTextColor @bean22:"+bedTextColor);
						if(days_before_status.equals("BOC") || days_before_status.equals("BOU") || days_before_status.equals("BNC") || days_before_status.equals("BNU")){
							if (future_booking_for_bnc_yn.equals("Y")){ 
								//bedColor 		= "IP_RedButton_B";
								bedClock		= "Y";
							}else if (future_booking_for_bnu_yn.equals("Y")){ 
								//bedColor 		= "IP_RedButton_B";
								bedClock		= "Y";
							}else if (future_booking_for_boc_yn.equals("Y")){
								//bedColor 		= "IP_RedButton_B";
								bedClock		= "Y";
							}else if (future_booking_for_bou_yn.equals("Y")){
								//bedColor 		= "IP_RedButton_B";
								bedClock		= "Y";
							}
						}
						if(override.equals("N") && booking_status.equals("1") && bookingType.equals("L")){
							//bedColorExt = "IP_PurpleButton";
							bedColorExt = (String)colorCodingmap.get("bkdNonOverrideConfirmBed_clr");
						}else if(override.equals("N") && booking_status.equals("0") && bookingType.equals("L")){
							//bedColorExt = "IP_LpurpleButton";
							bedColorExt = (String)colorCodingmap.get("bkdNonOverrideUnConfirmBed_clr");
						}else if(override.equals("Y") && booking_status.equals("1") && bookingType.equals("L")){
							//bedColorExt = "IP_WoodButton";
							bedColorExt = (String)colorCodingmap.get("bkdOverrideConfirmBed_clr");
						}else if(override.equals("Y") && booking_status.equals("0") && bookingType.equals("L")){
							//bedColorExt = "IP_LWoodButton";
							bedColorExt = (String)colorCodingmap.get("bkdOverrideUnConfirmBed_clr");
						}
					}
					
					if(pseudoBedYN.equals("Y")){
						if(bedStatus.equals("O")){
							//bedColor="IP_LPinkButton";
							bedColor=(String)colorCodingmap.get("occupiedPseudoBed_clr");
							bedTextColor=(String)colorCodingmap.get("occupiedpseudobed_text_clr");
							//System.out.println("bedColor @bean33:"+bedColor);
							//System.out.println("bedTextColor @bean33:"+bedTextColor);
						}else{
							//bedColor="IP_LGreenButton";
							bedColor=(String)colorCodingmap.get("vacantPseudoBed_clr");
							bedTextColor=(String)colorCodingmap.get("vacantpseudobed_text_clr");
							//System.out.println("bedColor @bean44:"+bedColor);
							//System.out.println("bedTextColor @bean44:"+bedTextColor);
						}
					}
					
					if(override.equals("Y") && pseudoBedYN.equals("N")){
						if(bedStatus.equals("T") || bedStatus.equals("B") || bedStatus.equals("L") || bedStatus.equals("D") || bookingType.equals("B")){
							//bedColor	= "IP_YellowButton";
							bedColor	= (String)colorCodingmap.get("blkdOverrideBed_clr");
							bedTextColor=(String)colorCodingmap.get("blkdovrdbed_text_clr");
							//System.out.println("bedColor @bean55:"+bedColor);
							//System.out.println("bedTextColor @bean55:"+bedTextColor);
						}
					}else if(override.equals("N") && pseudoBedYN.equals("N")){
						if(bedStatus.equals("T") || bedStatus.equals("B") || bedStatus.equals("L") || bedStatus.equals("D") || bookingType.equals("B")){
							//bedColor	= "IP_BrownButton";
							//System.out.println("colorCodingmap @bean 66:"+colorCodingmap.toString());
							bedColor	= (String)colorCodingmap.get("blkdNonOverrideBed_clr");
							bedTextColor=(String)colorCodingmap.get("blkdnonovrdbed_text_clr");
							//System.out.println("bedColor @bean66-->:"+(String)colorCodingmap.get("blkdNonOverrideBed_clr"));
							//System.out.println("bedTextColor @bean66-->:"+(String)colorCodingmap.get("blkdnonovrdbed_text_clr"));
							//System.out.println("bedColor @bean66:"+bedColor);
							//System.out.println("bedTextColor @bean66:"+bedTextColor);
						}
					}
											
					if(bedStatus.equals("O")){

						if(pat_curr_locn_code != null)
						{
							if(!nursingunitcode.equals(pat_curr_locn_code))
							{
								//bedColor	="IP_newButton";
								bedColor	=(String)colorCodingmap.get("occDepartedBed_clr");
								bedTextColor=(String)colorCodingmap.get("occdepartedbed_text_clr");
								//System.out.println("bedColor @bean77:"+bedColor);
								//System.out.println("bedTextColor @bean77:"+bedTextColor);
							}
						}
					}
					
					if(bedStatus.equals("B") && override.equals("Y") && booking_status.equals("1") && bookingType.equals("L")){
						//bedColor="IP_GreenButton";
						bedColor=(String)colorCodingmap.get("vacantBed_clr");
						bedTextColor=(String)colorCodingmap.get("vacantbed_text_clr");
						//System.out.println("bedColor @bean88:"+bedColor);
						//System.out.println("bedTextColor @bean88:"+bedTextColor);
						if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
							//bedColor 		= "IP_GreenButton_B";
							bedClock		= "Y";
						}
						//bedColorExt	= "IP_WoodButton";
						bedColorExt	= (String)colorCodingmap.get("bkdOverrideConfirmBed_clr");
					}
					
					if(bedStatus.equals("B") && override.equals("Y") && booking_status.equals("0") && bookingType.equals("L")){
						//bedColor="IP_GreenButton";
						bedColor=(String)colorCodingmap.get("vacantBed_clr");
						bedTextColor=(String)colorCodingmap.get("vacantbed_text_clr");
						//System.out.println("bedColor @bean99:"+bedColor);
						//System.out.println("bedTextColor @bean99:"+bedTextColor);
						if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
							//bedColor 		= "IP_GreenButton_B";
							bedClock		= "Y";
						}
						//bedColorExt	= "IP_LWoodButton";
						bedColorExt	= (String)colorCodingmap.get("bkdOverrideUnConfirmBed_clr");
					}
					if(bedStatus.equals("B") && override.equals("N") && booking_status.equals("1") && bookingType.equals("L")){
						//bedColor="IP_GreenButton";
						bedColor=(String)colorCodingmap.get("vacantBed_clr");
						bedTextColor=(String)colorCodingmap.get("vacantbed_text_clr");
						//System.out.println("bedColor @beanAA:"+bedColor);
						//System.out.println("bedTextColor @beanAA:"+bedTextColor);
						if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
							//bedColor 		= "IP_GreenButton_B";
							bedClock		= "Y";
						}
						//bedColorExt	= "IP_PurpleButton";
						bedColorExt	= (String)colorCodingmap.get("bkdNonOverrideConfirmBed_clr");
					}
					if(bedStatus.equals("B") && override.equals("N") && booking_status.equals("0") && bookingType.equals("L")){
						//bedColor="IP_GreenButton";
						bedColor=(String)colorCodingmap.get("vacantBed_clr");
						bedTextColor=(String)colorCodingmap.get("vacantbed_text_clr");
						//System.out.println("bedColor @beanBB:"+bedColor);
						//System.out.println("bedTextColor @beanBB:"+bedTextColor);
						if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
							//bedColor 		= "IP_GreenButton_B";
							bedClock		= "Y";
						}
						//bedColorExt	= "IP_LpurpleButton";
						bedColorExt	= (String)colorCodingmap.get("bkdNonOverrideUnConfirmBed_clr");
					}
					String trnsAllowed="Y";
					if(bookingType.equals("N") && bedStatus.equals("B")){
							//bedColor	= "IP_violetButton";					
							bedColor	= (String)colorCodingmap.get("reservedBed_clr");
							bedTextColor=(String)colorCodingmap.get("reservedbed_text_clr");
							trnsAllowed="N";
							//System.out.println("bedColor @beanCC:"+bedColor);
							//System.out.println("bedTextColor @beanCC:"+bedTextColor);
					}
					//System.out.println("bl_operational @bean:"+bl_operational);
					//System.out.println("encounter_id @bean:"+encounter_id);
					if((bl_operational.equals("Y") && !bedWidth.equals("0")) && (!encounter_id.equals("") && bedStatus.equals("O"))){
						bedPstmt.setString(1,facility_id);
						bedPstmt.setString(2,encounter_id);
						if(bedRs!=null)bedRs.close();
						bedRs	= bedPstmt.executeQuery();
						if(bedRs != null && bedRs.next()){							
							disc_bill_exists = bedRs.getString("disc_bill_exists")==null?"N":bedRs.getString("disc_bill_exists");					
						}
					}		
					//checkstyle correction added by Munisekhar
                    if(bedRs!=null)bedRs.close();					
					//System.out.println("bedColor final@bean:"+bedColor);
					//System.out.println("bedTextColor final@bean:"+bedTextColor);
					//System.out.println("disc_bill_exists @bean:"+disc_bill_exists);
					/*ends*/	
					int abnormal_rslt_count=0;
					//System.out.println("open_encounter :"+open_encounter);
					//System.out.println("bedHeight :"+bedHeight);
					//System.out.println("bedNo A:"+bedNo);
					String due_time="";
					String overdue_time="";
					//System.out.println("open_encounter :"+open_encounter);
					if(!open_encounter.equals("")/*&& !bedHeight.equals("")*/){
						//System.out.println("open encounter exists:");
						pstmt.setString(1,language_id);
						pstmt.setString(2,language_id);
						pstmt.setString(3,language_id);
						pstmt.setString(4,language_id);
						pstmt.setString(5,patient_id);
						pstmt.setString(6,patient_id);
						pstmt.setString(7,patient_id);
						//System.out.println("patient_id :"+patient_id);
						//System.out.println("roomNo :"+roomNo);
						//System.out.println("bedNo B:"+bedNo);
						abs_rslt_set=pstmt.executeQuery();
						if(abs_rslt_set!=null && abs_rslt_set.next()){
							if(abs_rslt_set.getInt("rslt_count")>0){
								abnormal_rslt_count++;
								//System.out.println("bedNo C:"+bedNo);
								//System.out.println("abnormal results exists:");
							}
						}
						if(abs_rslt_set!=null){
							abs_rslt_set.close();
						}
						pstmt2.setString(1,facility_id);
						pstmt2.setString(2,open_encounter);
						pstmt2.setString(3,facility_id);
						pstmt2.setString(4,open_encounter);
						abs_rslt_set=pstmt2.executeQuery();
						if(abs_rslt_set!=null && abs_rslt_set.next()){
							//System.out.println("data exists");
							overdue_time=checkForNull(abs_rslt_set.getString(1));
							due_time=checkForNull(abs_rslt_set.getString(2));
						}
						if(abs_rslt_set!=null){
							abs_rslt_set.close();
						}
					}
					
					//System.out.println("overdue_time :"+overdue_time);
					//System.out.println("due_time :"+due_time);
					
					if(!roomList.contains(roomNo) && !bedWidth.equals("0")){
						roomBedsList = new ArrayList();
						roomList.add(roomNo);
						String roomName=rs.getString("group1");
						String roomTopPos=rs.getString("ROOM_TOP_POSITION")==null?"0":rs.getString("ROOM_TOP_POSITION");
						String roomLeftPos=rs.getString("ROOM_LEFT_POSITION")==null?"0":rs.getString("ROOM_LEFT_POSITION");
						String roomWidth=rs.getString("ROOM_WIDTH")==null?"0":rs.getString("ROOM_WIDTH");
						String roomHeight=rs.getString("ROOM_HEIGHT")==null?"0":rs.getString("ROOM_HEIGHT");
						roomsMap = new HashMap();
						roomsMap.put("roomNo",roomNo);
						roomsMap.put("roomName",roomName);
						roomsMap.put("room_clr",(String)colorCodingmap.get("room_clr"));
						roomsMap.put("roomTopPos",roomTopPos);
						roomsMap.put("roomLeftPos",roomLeftPos);
						roomsMap.put("roomWidth",roomWidth);
						roomsMap.put("roomHeight",roomHeight);						
						HashMap roomBedsMap = new HashMap();
						roomBedsMap.put("bedNo",bedNo);
						roomBedsMap.put("bedTopPos",bedTopPos);
						roomBedsMap.put("bedLeftPos",bedLeftPos);
						roomBedsMap.put("bedWidth",bedWidth);
						roomBedsMap.put("bedHeight",bedHeight);
						roomBedsMap.put("bookingType",bookingType);
						roomBedsMap.put("bedStatus",bedStatus);
						roomBedsMap.put("bedColor",bedColor);
						roomBedsMap.put("bedTextColor",bedTextColor);
						roomBedsMap.put("bedClock",bedClock);
						roomBedsMap.put("bedColorExt",bedColorExt);
						roomBedsMap.put("bed_class_code",bed_class_code);
						roomBedsMap.put("allow_bed_swap_yn",allow_bed_swap_yn);
						roomBedsMap.put("trnsAllowed",trnsAllowed);
						roomBedsMap.put("disc_bill_exists",disc_bill_exists);
						roomBedsMap.put("patient_id",patient_id);
						roomBedsMap.put("pat_age",pat_age);
						roomBedsMap.put("gender",gender);
						roomBedsMap.put("encounter_id",encounter_id);
						roomBedsMap.put("admission_date_time",admission_date_time);
						roomBedsMap.put("exp_discharge_date_time",exp_discharge_date_time);
						roomBedsMap.put("bed_class_short_desc",bed_class_short_desc);
						roomBedsMap.put("bed_type_short_desc",bed_type_short_desc);						
						roomBedsList.add(roomBedsMap);
						roomBedsMap.put("patient_name",patient_name);
						roomBedsMap.put("practitioner_name",practitioner_name);
						roomBedsMap.put("KNOWN_ALLERGY_YN",KNOWN_ALLERGY_YN);
						roomBedsMap.put("overdue_count",overdue_count);
						roomBedsMap.put("due_count",due_count);
						roomBedsMap.put("overdue_time",overdue_time);
						roomBedsMap.put("due_time",due_time);
						roomBedsMap.put("abnormal_rslt_count",abnormal_rslt_count);
						roomsMap.put("roomBedsList",roomBedsList);
						floorRoomBedList.add(roomsMap);
					}else if(!bedWidth.equals("0")){					
						HashMap roomBedsMap = new HashMap();
						roomBedsMap.put("bedNo",bedNo);
						roomBedsMap.put("bedTopPos",bedTopPos);
						roomBedsMap.put("bedLeftPos",bedLeftPos);
						roomBedsMap.put("bedWidth",bedWidth);
						roomBedsMap.put("bedHeight",bedHeight);
						roomBedsMap.put("bookingType",bookingType);
						roomBedsMap.put("bedStatus",bedStatus);
						roomBedsMap.put("bedColor",bedColor);
						roomBedsMap.put("bedTextColor",bedTextColor);
						roomBedsMap.put("bedClock",bedClock);
						roomBedsMap.put("bedColorExt",bedColorExt);
						roomBedsMap.put("bed_class_code",bed_class_code);
						roomBedsMap.put("allow_bed_swap_yn",allow_bed_swap_yn);
						roomBedsMap.put("trnsAllowed",trnsAllowed);
						roomBedsMap.put("disc_bill_exists",disc_bill_exists);
						roomBedsMap.put("patient_id",patient_id);
						roomBedsMap.put("pat_age",pat_age);
						roomBedsMap.put("gender",gender);
						roomBedsMap.put("encounter_id",encounter_id);
						roomBedsMap.put("admission_date_time",admission_date_time);
						roomBedsMap.put("exp_discharge_date_time",exp_discharge_date_time);
						roomBedsMap.put("bed_class_short_desc",bed_class_short_desc);
						roomBedsMap.put("bed_type_short_desc",bed_type_short_desc);
						roomBedsMap.put("patient_name",patient_name);
						roomBedsMap.put("practitioner_name",practitioner_name);
						roomBedsMap.put("KNOWN_ALLERGY_YN",KNOWN_ALLERGY_YN);
						roomBedsMap.put("overdue_count",overdue_count);
						roomBedsMap.put("due_count",due_count);
						roomBedsMap.put("overdue_time",overdue_time);
						roomBedsMap.put("due_time",due_time);
						roomBedsMap.put("abnormal_rslt_count",abnormal_rslt_count);
						roomBedsMap.put("ost_orders_count",ost_orders_count);
						roomBedsList.add(roomBedsMap);
						roomsMap.put("roomBedsList",roomBedsList);
					}					
				}
			}
			bedCountMap.put("vacantNormalBeds",vacantNormalBeds);
			bedCountMap.put("vacantPseudoBeds",vacantPseudoBeds);
			bedCountMap.put("occupiedNormalBeds",occupiedNormalBeds);
			bedCountMap.put("occupiedPseudoBeds",occupiedPseudoBeds);
			bedCountMap.put("reservedBeds",reservedBeds);
			bedCountMap.put("occupiedDepartedBeds",occupiedDepartedBeds);
			bedCountMap.put("blkdOverrideBeds",blkdOverrideBeds);
			bedCountMap.put("blkdNonOverrideBeds",blkdNonOverrideBeds);
					/*int vacantNormalBeds=0;
		int vacantPseudoBeds=0;
		int occupiedNormalBeds=0;
		int occupiedPseudoBeds=0;
		int occupiedDepartedBeds=0;
		int reservedBeds=0;
		int blkdOverrideBeds=0;
		int blkdNonOverrideBeds=0;*/
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(bedRs!=null)bedRs.close();
				if(bedPstmt!=null)bedPstmt.close();
				if(ipAdvPstmt!=null)ipAdvPstmt.close();
				if(pstmt!=null)pstmt.close();
				if(pstmt2!=null)pstmt2.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return floorRoomBedList;
	}
	
	public static HashMap getPatEncounterData(Connection con,Statement stmt,ResultSet rs,String encounter_id,String facility_id,String language_id,String bed_no)throws Exception{
		//System.out.println("IPRoomBedMgmtBean getNursingUnitRoomData:");
		HashMap ipPatEncData = new HashMap();
		PreparedStatement 	pstmt		= null;
		// SQL query updated to get "bed allocation date time" column from
		// the ip_open_encounter table
		String bedChartSQL="select (select (case    when booking_status = '1' and override_yn = 'Y' then 'BOC' when booking_status = '0' and override_yn = 'Y' then 'BOU' when booking_status = '1' and override_yn = 'N' then 'BNC' when booking_status = '0' and override_yn = 'N' then 'BNU' else	'N' end)from ip_bed_booking where  req_bed_no = a.bed_no and  req_room_no = a.room_no and req_bed_class_code = a.bed_class_code and req_bed_type_code = a.bed_type_code and req_nursing_unit_code = a.nursing_unit_code and ( trunc(blocked_from_date_time) >= sysdate and ((trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_boc and booking_status = '1' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bou and booking_status = '0' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnc and booking_status = '1' and override_yn = 'N')	or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnu and booking_status = '0' and override_yn = 'N')))	and rownum=1) days_before_status,   am_get_desc.AM_FACILITY_ROOM(a.facility_id, a.room_no,?,'1')group1,  bkg_patient_id, booking_type,ATTEND_PRACTITIONER_ID,CASE WHEN c.admission_type IS NOT NULL THEN ip_get_desc.ip_admission_type (c.admission_type,?, '2'  ) WHEN c.admission_type IS NULL THEN (SELECT ip_get_desc.ip_admission_type (i.admission_type, ?,  '2' ) admission_type FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END ADMISSION_TYPE, b.referral_id, pseudo_bed_yn, a.nursing_unit_code, c.pat_curr_locn_code,  a.bed_no, a.main_bed_no, a.bed_no || decode( a.sex_spec_ind, null, '' ) bed_no_label, a.bed_type_code, a.bed_class_code, ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,?,'2') nursing_unit_short_desc, a.room_no,  ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,?,'2') Bed_Class_Short_desc, b.override_yn, ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,?,'2')bed_type_short_desc,  (CASE WHEN a.Specialty_Code IS NOT NULL  THEN (Am_Get_desc.Am_speciality(a.Specialty_Code,?,'2')) ELSE '*All SPLTY*' END) specialty_short_desc,  a.specialty_code, a.occupying_patient_id patient_id,  nvl(c.encounter_id, b.encounter_id) encounter_id,  d.patient_name patient_name , nvl(d.patient_name_loc_lang,d.patient_name) patient_name_loc_lang , nvl(b.bkg_patient_name, b.patient_name) bg_patient_name , nvl(b.patient_name_loc_lang,d.patient_name_loc_lang) bg_patient_name_loc_lang ,  d.sex gender,b.bkg_gender bkg_gender, d.nationality_code, e.appl_patient_class,  mp_Get_desc.Mp_country(d.Nationality_Code,?,'1') nationality_long_desc,  get_age(d.date_of_birth) age,get_age(b.bgk_date_of_birth)bkg_age,  CASE WHEN c.admission_date_time IS NOT NULL THEN TO_CHAR (c.admission_date_time,'dd/mm/rrrr hh24:mi') WHEN c.admission_date_time IS NULL THEN (SELECT TO_CHAR (i.admission_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_date_time,  CASE WHEN c.exp_discharge_date_time IS NOT NULL THEN TO_CHAR (c.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') WHEN c.exp_discharge_date_time IS NULL THEN (SELECT TO_CHAR (i.exp_discharge_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END exp_discharge_date_time,  to_char(b.expected_discharge_date,'dd/mm/rrrr hh24:mi') bkg_exp_discharge_date_time,  (case when a.occupied_until_date_time > sysdate then ROUND (TO_CHAR (a.occupied_until_date_time - SYSDATE)) end) exp_no_of_days,  b.blocking_type_short_desc,  b.exp_days_of_stay,  ( CASE   WHEN a.occupying_patient_id IS NOT NULL THEN 'O'  WHEN b.booking_type IS NULL THEN 'A'  WHEN b.booking_type in ('N','B','L','T','D') THEN 'B'  END ) bed_status,  to_char(b.blocked_from, 'dd/mm/rrrr hh24:mi') blocked_from, to_char(b.blocked_until,'dd/mm/rrrr hh24:mi') blocked_until, b.Practitioner_Name bkg_Practitioner_Name,  Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,?,'1') practitioner_name, b.bed_booking_ref_no, b.booking_date_time, b.blocking_type_code, b.blocking_remarks, c.service_code service_code,  Am_Get_desc.Am_service(c.Service_Code,?,'2') service_desc,  (CASE WHEN c.Service_Code IS NOT NULL  THEN (SELECT Ancillary_yn FROM Am_Service WHERE  Service_Code = c.Service_Code) END) Ancillary_yn,  null dly_charge, (CASE WHEN d.Pat_Cat_Code IS NOT NULL  THEN (mp_Get_desc.Mp_pat_category(d.Pat_Cat_Code,?,'2')) END) Pat_Cat_Short_desc,  oth_adt_status, a.psuedo_bed_status, a.main_bed_no,  b.booking_status, b.booking_remarks,  CASE WHEN c.CHIEF_COMPLAINT IS NOT NULL THEN am_get_desc.AM_COMPLAINT (c.CHIEF_COMPLAINT,?, '1'  ) WHEN c.CHIEF_COMPLAINT IS NULL THEN (SELECT am_get_desc.AM_COMPLAINT (i.CHIEF_COMPLAINT, ?,  '1' ) admission_reason FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = ? AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_reason  , am_get_desc.AM_COMPLAINT(b.CHIEF_COMPLAINT,?,'1')booking_reason ,(SELECT bl.short_desc financial_classification FROM bl_episode_fin_dtls a, bl_blng_grp_lang_vw bl WHERE bl.language_id = ? and a.blng_grp_id = bl.blng_grp_id  AND a.operating_facility_id = c.facility_id AND a.episode_id = c.encounter_id AND a.patient_id = c.patient_id) financial_classification ,(SELECT bl.short_desc financial_classification FROM bl_booking_fin_dtls a,  bl_blng_grp bl WHERE a.blng_grp_id = bl.blng_grp_id AND a.operating_facility_id = b.facility_id AND a.appt_book_ref_num = b.bed_booking_ref_no and b.booking_type = 'L')bkg_financial_classification,r.ROOM_LEFT_POSITION,r.room_top_position,r.room_width,r.room_height,a.BED_LEFT_POSITION,a.bed_top_position,a.BED_WIDTH,a.BED_HEIGHT,(select Or_patient_Order_Pend(c.patient_id,c.facility_id,c.encounter_id,'A') from dual)pend_ord_stats,d.PAT_DTLS_UNKNOWN_YN,(select finalize_yn from mr_death_register_hdr where facility_id = c.facility_id and encounter_id = c.encounter_id)finalize_yn, to_char(c.bed_allocation_date_time,'dd/MM/yyyy hh24:mi') bed_alloc_date_time FROM  IP_NURSING_UNIT_BED a  ,IP_OPEN_ENCOUNTER c  ,MP_PATIENT d  ,IP_NURSING_UNIT e  , ip_param f  ,(select  bkglst.exp_days_of_stay, bkg.override_yn, Nvl(bkglst.Patient_Name,Pat.Patient_Name) Patient_Name, Nvl(bkglst.patient_name_loc_lang,Pat.patient_name_loc_lang) patient_name_loc_lang,bkg.encounter_id, bkg.facility_id, bkg.booking_type, bkg.bed_booking_ref_no, bkg.req_nursing_unit_code, bkg.req_bed_no, bkg.blocking_type_code, ip_Get_desc.Ip_blocking_type(bkg.BlockIng_Type_Code,?,'2') BlockIng_Type_Short_desc, bkg.blocking_remarks, bkg.blocked_from_date_time blocked_from, bkg.blocked_until_date_time blocked_until, nvl(bkglst.patient_id , bkg.patient_id) bkg_patient_id, decode(bkglst.patient_id, null , pat.patient_name, bkglst.patient_name) bkg_patient_name, NVL (bkglst.gender, pat.sex) bkg_gender, bkglst.referral_id, Nvl(bkglst.Date_Of_Birth,Pat.Date_Of_Birth) bgk_Date_Of_Birth, NVL(bkglst.expected_discharge_date,bkg.blocked_until_date_time) expected_discharge_date,  (CASE WHEN bkglst.Practitioner_Id IS NULL  THEN (Am_Get_desc.Am_practitioner(bkg.req_Practitioner_Id,?,'1')) ELSE (Am_Get_desc.Am_practitioner(bkglst.Practitioner_Id,?,'1')) END) Practitioner_Name,  to_char(bkglst.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, nvl(bkglst.booking_status,bkg.booking_status)booking_status, bkglst.booking_remarks,bkg.patient_id,bkglst.chief_complaint  FROM  IP_BED_BOOKING bkg, IP_BOOKING_LIST bkglst, MP_PATIENT pat  WHERE  bkg.booking_status in ('0','1')  and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy'))  and bkg.booking_date_time=(select max (booking_date_time)  from IP_BED_BOOKING where facility_id = bkg.facility_id  and req_nursing_unit_code = bkg.req_nursing_unit_code  and req_bed_no = bkg.req_bed_no  and booking_status in ('0','1')  and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')))  and bkglst.facility_id(+) = bkg.facility_id  and bkglst.bkg_lst_ref_no(+) = bkg.bed_booking_ref_no  and pat.patient_id(+) = bkg.patient_id ) b ,ip_nursing_unit_room r WHERE  a.nursing_unit_code = e.nursing_unit_code  and a.bed_no=? and a.facility_id = ?  and a.eff_status = 'E'  and e.eff_status = 'E'  AND b.facility_id(+) = a.facility_id  AND b.req_nursing_unit_code (+) = a.nursing_unit_code  AND b.req_bed_no(+) = a.bed_no   AND a.Facility_Id = e.Facility_Id  AND a.Facility_Id = c.Facility_Id (+)  AND a.OccupyIng_Patient_Id = c.Patient_Id (+)  AND a.OccupyIng_Patient_Id = d.Patient_Id (+)   /*and a.psuedo_bed_status != 'C'*/ and a.facility_id = f.facility_id and r.facility_id=a.facility_id and r.room_no=a.room_no and r.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and a.bed_width is not null and r.room_width is not null  order by  nursing_unit_short_desc,   group1,  bed_no";
		
		//System.out.println("bedChartSQL @getPatEncounterData:"+bedChartSQL);
		//System.out.println("colorCodingmap @getNursingUnitRoomBedTrnsData:"+colorCodingmap.toString());
		try{
			pstmt=con.prepareStatement(bedChartSQL);
			pstmt.setString(1,language_id);
			pstmt.setString(2,language_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,language_id);
			pstmt.setString(6,language_id);
			pstmt.setString(7,language_id);
			pstmt.setString(8,language_id);
			pstmt.setString(9,language_id);
			pstmt.setString(10,facility_id);
			pstmt.setString(11,facility_id);
			pstmt.setString(12,language_id);
			pstmt.setString(13,language_id);
			pstmt.setString(14,language_id);
			pstmt.setString(15,language_id);
			pstmt.setString(16,language_id);
			pstmt.setString(17,facility_id);
			pstmt.setString(18,language_id);
			pstmt.setString(19,language_id);
			pstmt.setString(20,language_id);
			pstmt.setString(21,language_id);
			pstmt.setString(22,language_id);
			pstmt.setString(23,bed_no);
			pstmt.setString(24,facility_id);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()){
				String admission_date_time=checkForNull(rs.getString("admission_date_time"));
				String exp_discharge_date_time=checkForNull(rs.getString("exp_discharge_date_time"));
				String bed_class_short_desc=checkForNull(rs.getString("bed_class_short_desc"));
				String bed_type_short_desc=checkForNull(rs.getString("bed_type_short_desc"));
				String patient_id = checkForNull(rs.getString("patient_id"));
				String patient_name=checkForNull(rs.getString("patient_name"));
				String pat_age=checkForNull(rs.getString("AGE"));
				String gender=checkForNull(rs.getString("gender"));
				String practitioner_id=checkForNull(rs.getString("ATTEND_PRACTITIONER_ID"));
				String practitioner_name=checkForNull(rs.getString("practitioner_name"));
				String bedNo=rs.getString("BED_NO");
				String pend_ord_stats=rs.getString("pend_ord_stats");
				String pat_dtls_unknown=rs.getString("PAT_DTLS_UNKNOWN_YN");
				String finalize_yn=rs.getString("finalize_yn");
				// code added to get the bed allocation date time value 
				// from result set
				String bedAllocDateTime=rs.getString("bed_alloc_date_time");
				// code added to get the specialty code and specialty desc
				String specialtyDesc = checkForNull(rs.getString("specialty_short_desc"));
				String specialtyCode = checkForNull(rs.getString("specialty_code"));
				
				ipPatEncData.put("patient_id",patient_id);
				ipPatEncData.put("patient_name",patient_name);
				ipPatEncData.put("pat_age",pat_age);
				ipPatEncData.put("gender",gender);
				ipPatEncData.put("practitioner_id",practitioner_id);
				ipPatEncData.put("practitioner_name",practitioner_name);
				ipPatEncData.put("bedNo",bedNo);
				ipPatEncData.put("bed_class_short_desc",bed_class_short_desc);
				ipPatEncData.put("bed_type_short_desc",bed_type_short_desc);
				ipPatEncData.put("admission_date_time",admission_date_time);
				ipPatEncData.put("exp_discharge_date_time",exp_discharge_date_time);
				ipPatEncData.put("pend_ord_stats",pend_ord_stats);
				ipPatEncData.put("pat_dtls_unknown",pat_dtls_unknown);
				ipPatEncData.put("finalize_yn",finalize_yn);
				// code added to set the bed allocation date time
				// to the map
				ipPatEncData.put("bed_alloc_date_time",bedAllocDateTime);
				// code added to set specialty code and specialty desc to map
				ipPatEncData.put("specialtyDesc", specialtyDesc);
				ipPatEncData.put("specialtyCode", specialtyCode);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(pstmt!=null)pstmt.close();
		}
		//System.out.println("IPRoomBedMgmtBean getPatEncounterData ipPatEncData:"+ipPatEncData.toString());
		return ipPatEncData;
	}
	
	public static String getIPEncAllowedOperations(Connection con,PreparedStatement pstmt,ResultSet rset,String facilityId,String encounterId,String nursingUnit,String bedNo,String patientId,String userId,String oprStnId){
		//System.out.println("getIPEncAllowedOperations begins:");
		String retValue="";
		try{
			pstmt=con.prepareStatement("select IP_GET_BED_OPERN(?,?,?,?,?,?,?) from dual");
			pstmt.setString(1,facilityId);
			pstmt.setString(2,encounterId);
			pstmt.setString(3,patientId);
			pstmt.setString(4,oprStnId);
			pstmt.setString(5,userId);
			pstmt.setString(6,nursingUnit);
			pstmt.setString(7,bedNo);
			//System.out.println("Before calling function");
			rset=pstmt.executeQuery();			
			if(rset != null && rset.next()){
				//System.out.println("Before retrieving data");
				String data=rset.getString(1);
				//System.out.println("after retrieving data:"+data);
				retValue=data;
				if(data.contains("PRE_DIS_ADVICE")){
					//retValue="PRE_DIS_ADVICE";
				}else{
					//retValue="CAN_DIS_ADVICE~DISCHARGE_PATIENT";
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return retValue;
	}
	public static HashMap getParamOprStnData(Connection con,PreparedStatement pstmt,ResultSet rset,String facility_id,String user_id){
		//System.out.println("getIPEncAllowedOperations begins:");
		HashMap paramOprStnMap= new HashMap();
		try{
			
			String paramOprStnSQL="SELECT bl_interfaced_yn, capture_fin_dtls_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN, max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date ,B.NB_MOTHER_CUTOFF_AGE MOTHER_CUT_OFF_AGE,B.NB_MOTHER_UPPER_AGE MOTHER_MAX_AGE,(select oper_stn_id from am_user_for_oper_stn where facility_id=? and appl_user_id=?)oper_stn_id,future_booking_for_boc_yn, future_booking_for_bou_yn,future_booking_for_bnc_yn, future_booking_for_bnu_yn,refresh_interval  FROM IP_PARAM  ,MP_PARAM B WHERE facility_id=?  AND B.MODULE_ID='MP' ";
			pstmt=con.prepareStatement(paramOprStnSQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,user_id);
			pstmt.setString(3,facility_id);
			//System.out.println("Before calling function");
			rset=pstmt.executeQuery();			
			if(rset != null && rset.next()){
				paramOprStnMap.put("oper_stn_id",rset.getString("oper_stn_id")==null?"":rset.getString("oper_stn_id"));
				paramOprStnMap.put("setup_bl_dtls_in_ip_yn",rset.getString("setup_bl_dtls_in_ip_yn")==null?"":rset.getString("setup_bl_dtls_in_ip_yn"));
				paramOprStnMap.put("bl_interfaced_yn",rset.getString("bl_interfaced_yn")==null?"":rset.getString("bl_interfaced_yn"));
				paramOprStnMap.put("allow_discharge_date",rset.getString("allow_discharge_date")==null?"":rset.getString("allow_discharge_date"));
				paramOprStnMap.put("chk_for_pen_orders_bfr_dis_adv",rset.getString("chk_for_pen_orders_bfr_dis_adv")==null?"N":rset.getString("chk_for_pen_orders_bfr_dis_adv"));
				paramOprStnMap.put("dis_adv_allow_yn",rset.getString("dis_adv_allow_yn")==null?"N":rset.getString("dis_adv_allow_yn"));
				paramOprStnMap.put("chk_for_pen_orders_bfr_dis",rset.getString("CHK_FOR_PEN_ORDERS_BFR_DIS")==null?"N":rset.getString("CHK_FOR_PEN_ORDERS_BFR_DIS"));
				paramOprStnMap.put("dis_allow_yn",rset.getString("DIS_ALLOW_YN")==null?"N":rset.getString("DIS_ALLOW_YN"));
				paramOprStnMap.put("max_disch_period_for_dc",rset.getString("max_disch_period_for_dc")==null?"":rset.getString("max_disch_period_for_dc"));
				paramOprStnMap.put("mother_cut_off_age",rset.getString("mother_cut_off_age")==null?"":rset.getString("mother_cut_off_age"));
				paramOprStnMap.put("mother_max_age",rset.getString("mother_max_age")==null?"":rset.getString("mother_max_age"));
				
				paramOprStnMap.put("disch_reason_mand_yn",rset.getString("DISCH_REASON_MAND_YN")==null?"N":rset.getString("DISCH_REASON_MAND_YN"));
				paramOprStnMap.put("allow_late_discharge_reason",rset.getString("ALLOW_LATE_DISCHARGE_REASON")==null?"N":rset.getString("ALLOW_LATE_DISCHARGE_REASON"));
				paramOprStnMap.put("deactivate_pseudo_bed_yn",rset.getString("deactivate_pseudo_bed_yn")==null?"N":rset.getString("deactivate_pseudo_bed_yn"));
				paramOprStnMap.put("diag_update_period_max_unit",rset.getString("diag_update_period_max_unit")==null?"":rset.getString("diag_update_period_max_unit"));
				paramOprStnMap.put("dis_date_chk_days_unit",rset.getString("dis_date_chk_days_unit")==null?"N":rset.getString("dis_date_chk_days_unit"));
				paramOprStnMap.put("dis_date_chk_days",rset.getString("dis_date_chk_days")==null?"N":rset.getString("dis_date_chk_days"));
				paramOprStnMap.put("bed_block_period_dis",rset.getString("bed_block_period_dis")==null?"N":rset.getString("bed_block_period_dis"));
				paramOprStnMap.put("discharge_checklist_app_yn",rset.getString("discharge_checklist_app_yn")==null?"N":rset.getString("discharge_checklist_app_yn"));
				paramOprStnMap.put("future_booking_for_boc_yn",rset.getString("future_booking_for_boc_yn")==null?"N":rset.getString("future_booking_for_boc_yn"));
				paramOprStnMap.put("future_booking_for_bou_yn",rset.getString("future_booking_for_bou_yn")==null?"N":rset.getString("future_booking_for_bou_yn"));
				paramOprStnMap.put("future_booking_for_bnc_yn",rset.getString("future_booking_for_bnc_yn")==null?"N":rset.getString("future_booking_for_bnc_yn"));
				paramOprStnMap.put("future_booking_for_bnu_yn",rset.getString("future_booking_for_bnu_yn")==null?"N":rset.getString("future_booking_for_bnu_yn"));
				paramOprStnMap.put("refresh_interval",rset.getString("refresh_interval")==null?"1":rset.getString("refresh_interval"));
				paramOprStnMap.put("pat_check_in_allowed_yn",rset.getString("pat_check_in_allowed_yn")==null?"N":rset.getString("pat_check_in_allowed_yn"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return paramOprStnMap;
	}
	
	public static String canDisAdviceFinDtlsValidations(String facility_id,String nursingUnit,String function_id,String encounter_Id,Connection con,PreparedStatement pstmt,ResultSet rSet){
		//System.out.println("IPAdvBedMgmtConfBean canDisAdviceFinDtlsValidation");
		String blFinDtlSQL="SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST(?,?) disc_bill_exists FROM dual";
		String disc_bill_exists="";
		String err_mesg="";
		try{
			pstmt = con.prepareStatement(blFinDtlSQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_Id);
			rSet=pstmt.executeQuery();
			if(rSet!=null && rSet.next()){
				disc_bill_exists = checkForNull(rSet.getString("disc_bill_exists"));
			}
			if(rSet!=null) rSet.close();
			if(pstmt!=null) pstmt.close();
			if(disc_bill_exists.equals("Y"))
					err_mesg = "BL9311";
			//System.out.println("err_mesg 11==>"+err_mesg+"<==");
			if(err_mesg.equals("")){
				blFinDtlSQL="SELECT BL_IP_DETAILS.GET_EPISODE_DISCHARGE_FLAG(?,?) disch_yn FROM dual";
				pstmt = con.prepareStatement(blFinDtlSQL);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_Id);
				rSet=pstmt.executeQuery();
				if(rSet!=null && rSet.next()){
					String disch_yn = checkForNull(rSet.getString("disch_yn"));
					if(disch_yn.equals("Y"))
						err_mesg = "CANC_DISC_ADV_NOT_ALLOWED";
				}
				if(rSet!=null) rSet.close();
				if(pstmt!=null) pstmt.close();
			}
			//System.out.println("err_mesg 22==>"+err_mesg+"<==");
			if(err_mesg.equals("")){
				String billinSql =  "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX(?,?,?,?)}";
				CallableStatement cstmt = con.prepareCall(billinSql);
				cstmt.setString(1, function_id);
				cstmt.setString(2, facility_id);
				cstmt.setString(3, encounter_Id);
				cstmt.registerOutParameter( 4,java.sql.Types.VARCHAR);
				cstmt.execute();
				err_mesg = cstmt.getString(4);
				if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
				if(cstmt!=null) cstmt.close();
			}
			//System.out.println("err_mesg 33==>"+err_mesg+"<==");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return err_mesg;
	}
	
	public static String dischargePatientValidations(String facility_id,String nursingUnit,String function_id,String encounter_Id,String bl_operational,String bl_dtls_in_ip,Connection con,PreparedStatement pstmt,ResultSet rSet){
		//System.out.println("IPAdvBedMgmtConfBean dischargePatientValidations");
		String dischrgPatSQL="SELECT oth_adt_status from IP_OPEN_ENCOUNTER where facility_id=? and encounter_id=?";
		String enc_status="";
		String err_mesg="";
		try{
			pstmt = con.prepareStatement(dischrgPatSQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_Id);
			rSet=pstmt.executeQuery();
			if(rSet!=null && rSet.next()){
				enc_status = checkForNull(rSet.getString("oth_adt_status"));
			}
			if(rSet!=null) rSet.close();
			if(pstmt!=null) pstmt.close();
			if(!enc_status.equals("7"))
					err_mesg = "NO_ACTV_DISC_ADV_NO_DISC";
			//System.out.println("err_mesg 11==>"+err_mesg+"<==");
			//System.out.println("bl_operational 11==>"+bl_operational+"<==");
			//System.out.println("bl_dtls_in_ip 11==>"+bl_dtls_in_ip+"<==");
			if(bl_operational.equals("Y") && err_mesg.equals("") && bl_dtls_in_ip.equals("Y")){
				String disc_blg_stage="";
				if(err_mesg.equals("")){
					dischrgPatSQL="SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE(?) disc_blg_stage FROM dual";
					pstmt = con.prepareStatement(dischrgPatSQL);
					pstmt.setString(1,facility_id);
					rSet=pstmt.executeQuery();
					if(rSet!=null && rSet.next()){
						disc_blg_stage = checkForNull(rSet.getString("disc_blg_stage"));						
					}
					if(rSet!=null) rSet.close();
					if(pstmt!=null) pstmt.close();
				}
				//System.out.println("disc_blg_stage 22==>"+disc_blg_stage+"<==");
				if(disc_blg_stage.equals("1")){
					if(rSet!=null) rSet.close();
					if(pstmt!=null) pstmt.close();
					dischrgPatSQL="SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST(?,?) disc_bill_exists FROM dual";
					pstmt = con.prepareStatement(dischrgPatSQL);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,encounter_Id);
					rSet=pstmt.executeQuery();
					if(rSet!=null && rSet.next()){
						String disc_bill_exists = checkForNull(rSet.getString("disc_bill_exists"));	
						if(disc_bill_exists.equals("N")){
							err_mesg = "BL9312";
						}						
					}
					//System.out.println("err_mesg 33==>"+err_mesg+"<==");
				}else if(disc_blg_stage.equals("2")){
					if(rSet!=null) rSet.close();
					if(pstmt!=null) pstmt.close();
					dischrgPatSQL="select dis_adv_status from ip_discharge_advice where encounter_id = ? and  dis_adv_srl_no = (select max(dis_adv_srl_no) from ip_discharge_advice where encounter_id =? and FACILITY_ID =?)";
					pstmt = con.prepareStatement(dischrgPatSQL);
					pstmt.setString(1,encounter_Id);
					pstmt.setString(2,encounter_Id);
					pstmt.setString(3,facility_id);
					if(rSet!=null && rSet.next()){
						String dis_adv_status = checkForNull(rSet.getString("dis_adv_status"));	
						if(dis_adv_status.equals("9")){
							err_mesg = "NO_ACTV_DISC_ADV_NO_DISC";
						}
					}
					//System.out.println("err_mesg 44==>"+err_mesg+"<==");
				}
				if(rSet!=null) rSet.close();
				if(pstmt!=null) pstmt.close();
				if(err_mesg.equals("")){
					String billinSql =  "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX(?,?,?,?)}";
					CallableStatement cstmt = con.prepareCall(billinSql);
					cstmt.setString(1, function_id);
					cstmt.setString(2, facility_id);
					cstmt.setString(3, encounter_Id);
					cstmt.registerOutParameter( 4,java.sql.Types.VARCHAR);
					cstmt.execute();
					err_mesg = cstmt.getString(4);
					if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
					if(cstmt!=null) cstmt.close();
				}
				//System.out.println("err_mesg 55==>"+err_mesg+"<==");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return err_mesg;
	}
	public static HashMap getAssignedBedForAdmission(Connection con,PreparedStatement pstmt,ResultSet rset,String facilityId,String nursingUnit,String bedNo,String userId,String oprStnId){
		HashMap retMap=null;
		try{
			pstmt=con.prepareStatement("select encounter_id,patient_id from ip_bed_booking bkg where facility_id=? and booking_type='B' and booking_status in ('0','1') and sysdate between blocked_from_date_time and blocked_until_date_time and BED_BOOKING_REF_NO=(select max(BED_BOOKING_REF_NO) from IP_BED_BOOKING where facility_id=? and REQ_BED_NO=? and booking_status in ('0','1') and sysdate between blocked_from_date_time and blocked_until_date_time and booking_type='B' and encounter_id is not null)");
			pstmt.setString(1,facilityId);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,bedNo);
			rset=pstmt.executeQuery();			
			if(rset != null && rset.next()){
				retMap=new HashMap();
				retMap.put("encounter_id",rset.getString("encounter_id"));
				retMap.put("patient_id",rset.getString("patient_id"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return retMap;
	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	
	/**
	 * 
	 * @return
	 */
	private static String getABMLayoutDataHugeQuery(String nursingUnit,String facilityId){
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select 	");
		queryBuilder.append("(select"); 
		queryBuilder.append("(case    ");
		queryBuilder.append("		when booking_status = '1' and override_yn = 'Y' then 'BOC' ");
		queryBuilder.append("		when booking_status = '0' and override_yn = 'Y' then 'BOU' ");
		queryBuilder.append("		when booking_status = '1' and override_yn = 'N' then 'BNC' ");
		queryBuilder.append("		when booking_status = '0' and override_yn = 'N' then 'BNU' ");
		queryBuilder.append("		else	'N' ");
		queryBuilder.append("	end)");
		queryBuilder.append("	from ip_bed_booking ");
		queryBuilder.append("	where  req_bed_no = a.bed_no and  ");
		queryBuilder.append("	req_room_no = a.room_no and ");
		queryBuilder.append("	req_bed_class_code = a.bed_class_code and ");
		queryBuilder.append("	req_bed_type_code = a.bed_type_code and ");
		queryBuilder.append("	req_nursing_unit_code = a.nursing_unit_code and ");
		queryBuilder.append("	( ");
		queryBuilder.append("		trunc(blocked_from_date_time) >= sysdate and ");
		queryBuilder.append("		(");
		queryBuilder.append("			(");
		queryBuilder.append("			trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_boc and ");
		queryBuilder.append("			booking_status = '1' and ");
		queryBuilder.append("			override_yn = 'Y') or ");
		queryBuilder.append("			(trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bou and ");
		queryBuilder.append("			booking_status = '0' and ");
		queryBuilder.append("			override_yn = 'Y') or ");
		queryBuilder.append("			(trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnc and ");
		queryBuilder.append("			booking_status = '1' and override_yn = 'N')	or ");
		queryBuilder.append("			(trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnu and ");
		queryBuilder.append("			booking_status = '0' and override_yn = 'N')");
		queryBuilder.append("			)");
		queryBuilder.append("		) and ");
		queryBuilder.append("	rownum=1");
		queryBuilder.append(") days_before_status,   ");
		queryBuilder.append("am_get_desc.AM_FACILITY_ROOM(a.facility_id, a.room_no,?,'2')group1,  ");
		queryBuilder.append("booking_type,		");
		queryBuilder.append("pseudo_bed_yn, ");
		queryBuilder.append("a.nursing_unit_code, c.pat_curr_locn_code,  ");
		queryBuilder.append("a.bed_no, ");
		queryBuilder.append("a.bed_class_code,");
		queryBuilder.append("(select ALLOW_BED_SWAP_YN ");
		queryBuilder.append("from ip_bed_class ");
		queryBuilder.append("where BED_CLASS_CODE=a.bed_class_code)ALLOW_BED_SWAP_YN, 		");
		queryBuilder.append("a.room_no,  ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,?,'2') Bed_Class_Short_desc, ");
		queryBuilder.append("b.override_yn, ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,?,'2')bed_type_short_desc,		 ");
		queryBuilder.append("a.occupying_patient_id patient_id,  ");
		queryBuilder.append("nvl(c.encounter_id, b.encounter_id) encounter_id,  d.patient_name patient_name , 		 				");
		queryBuilder.append("d.sex gender, 		  ");
		queryBuilder.append("get_age(d.date_of_birth) age,");
		queryBuilder.append("CASE ");
		queryBuilder.append("	WHEN c.admission_date_time IS NOT NULL THEN TO_CHAR (c.admission_date_time,'dd/mm/rrrr hh24:mi') ");
		queryBuilder.append("	WHEN c.admission_date_time IS NULL THEN ");
		queryBuilder.append("	(");
		queryBuilder.append("		SELECT TO_CHAR (i.admission_date_time,'dd/mm/rrrr hh24:mi' ) ");
		queryBuilder.append("		FROM ip_open_encounter i  ");
		queryBuilder.append("		WHERE (i.facility_id, i.encounter_id) IN ");
		queryBuilder.append("			( SELECT max(o.facility_id), max(o.encounter_id)  ");
		queryBuilder.append("				FROM ip_reserved_bed_dtl o  ");
		queryBuilder.append("				WHERE o.facility_id = '"+facilityId+"' AND ");
		queryBuilder.append("				o.encounter_id = NVL (c.encounter_id, b.encounter_id)");
		queryBuilder.append("			)");
		queryBuilder.append("	) END admission_date_time,  ");
		queryBuilder.append("CASE ");
		queryBuilder.append("	WHEN c.exp_discharge_date_time IS NOT NULL THEN TO_CHAR (c.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') ");
		queryBuilder.append("	WHEN c.exp_discharge_date_time IS NULL THEN ");
		queryBuilder.append("	(");
		queryBuilder.append("		SELECT TO_CHAR (i.exp_discharge_date_time,'dd/mm/rrrr hh24:mi' ) ");
		queryBuilder.append("		FROM ip_open_encounter i  ");
		queryBuilder.append("		WHERE (i.facility_id, i.encounter_id) IN ");
		queryBuilder.append("		( ");
		queryBuilder.append("			SELECT max(o.facility_id), max(o.encounter_id)  ");
		queryBuilder.append("			FROM ip_reserved_bed_dtl o  ");
		queryBuilder.append("			WHERE o.facility_id = '"+facilityId+"' AND ");
		queryBuilder.append("			o.encounter_id = NVL (c.encounter_id, b.encounter_id)");
		queryBuilder.append("		)");
		queryBuilder.append("	) END exp_discharge_date_time,  		  		  		    ");
		queryBuilder.append("(");
		queryBuilder.append("	CASE   ");
		queryBuilder.append("		WHEN a.occupying_patient_id IS NOT NULL THEN 'O'  ");
		queryBuilder.append("		WHEN b.booking_type IS NULL THEN 'A'  ");
		queryBuilder.append("		WHEN b.booking_type in ('N','B','L','T','D') THEN 'B'  ");
		queryBuilder.append("	END ");
		queryBuilder.append(") bed_status,  		");
		queryBuilder.append("Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,?,'1') practitioner_name, 		 						");
		queryBuilder.append("b.booking_status, 		");
		queryBuilder.append("r.ROOM_LEFT_POSITION,r.room_top_position,");
		queryBuilder.append("	r.room_width,r.room_height,a.BED_LEFT_POSITION,a.bed_top_position,a.BED_WIDTH,");
		queryBuilder.append("	a.BED_HEIGHT,d.KNOWN_ALLERGY_YN,");
		queryBuilder.append("(");
		queryBuilder.append("	CASE ");
		queryBuilder.append("		WHEN c.encounter_id IS NOT NULL THEN ");
		queryBuilder.append("		(");
		queryBuilder.append("			SELECT COUNT(*) overdue_count ");
		// code modified to use a faster query
		queryBuilder.append("			FROM ph_medn_admin ph, or_order_line oro ");
		queryBuilder.append("			WHERE ph.facility_id = c.encounter_id and ");
		queryBuilder.append("			ph.encounter_id = c.encounter_id and ");
		queryBuilder.append("			ph.order_id = oro.order_id and ");
		queryBuilder.append("			ph.order_line_num = oro.ordeR_line_num and ");
		queryBuilder.append("			oro.order_line_status not in ('CN','DC','HC','HT') and ");
		queryBuilder.append("			oro.order_category = 'PH' and ");
		
		
		/*queryBuilder.append("			FROM ph_medn_admin ");
		queryBuilder.append("			WHERE facility_id = c.FACILITY_ID AND ");
		queryBuilder.append("			encounter_id = c.encounter_id and ");
		queryBuilder.append("			(");
		queryBuilder.append("				(order_id,order_line_num) not in ");
		queryBuilder.append("				(");
		queryBuilder.append("					select order_id,ordeR_line_num from or_order_line  ");
		queryBuilder.append("					where order_line_status in ('CN','DC','HC','HT')  and order_category = 'PH'");
		queryBuilder.append("				)");
		queryBuilder.append("			) AND ");*/
		
		queryBuilder.append("			ph.sch_date_time BETWEEN TO_DATE (TO_CHAR(SYSDATE - (30 / 1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND ");
		queryBuilder.append("			TO_DATE (TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') AND ");
		queryBuilder.append("			ph.administered_yn = 'N'");
		queryBuilder.append("		)");
		queryBuilder.append("	END");
		queryBuilder.append(")overdue_count,");
		queryBuilder.append("(");
		queryBuilder.append("	CASE ");
		queryBuilder.append("		WHEN c.encounter_id IS NOT NULL THEN ");
		queryBuilder.append("		(");
		queryBuilder.append("			SELECT COUNT(*) due_count ");
		queryBuilder.append("			from ph_medn_admin ");
		queryBuilder.append("			where   facility_id=c.FACILITY_ID and ");
		queryBuilder.append("			encounter_id = c.encounter_id and ");
		queryBuilder.append("			(");
		queryBuilder.append("				(order_id,order_line_num) not in ");
		queryBuilder.append("				(select order_id,ordeR_line_num ");
		queryBuilder.append("					from or_order_line  ");
		queryBuilder.append("					where order_line_status in ('CN','DC','HC','HT')  and order_category = 'PH'");
		queryBuilder.append("				)");
		queryBuilder.append("			) and ");
		queryBuilder.append("			SCH_DATE_TIME between to_date (to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') and ");
		queryBuilder.append("			to_date(to_char(sysdate + (30/1440),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') and ");
		queryBuilder.append("			ADMINISTERED_YN='N'");
		queryBuilder.append("		)");
		queryBuilder.append("	END");
		queryBuilder.append(")due_count,c.encounter_id open_encounter,  ");
		queryBuilder.append("(select count(*) from or_order_line where ordeR_id in ");
		queryBuilder.append("		(select order_id from or_order where patient_id = c.patient_id and ");
		queryBuilder.append("		encounteR_id = c.ENCOUNTER_ID and ordering_facility_id = c.FACILITY_ID and ");
		queryBuilder.append("		order_line_Status = 'OS' and order_category !='PH' )");
		queryBuilder.append(") ost_orders_count ");
		queryBuilder.append("FROM  IP_NURSING_UNIT_BED a  ,IP_OPEN_ENCOUNTER c  ,MP_PATIENT d  ,IP_NURSING_UNIT e  , ip_param f  ,");
		queryBuilder.append("(");
		queryBuilder.append("select  bkglst.exp_days_of_stay, bkg.override_yn, Nvl(bkglst.Patient_Name,Pat.Patient_Name) Patient_Name, ");
		queryBuilder.append("Nvl(bkglst.patient_name_loc_lang,Pat.patient_name_loc_lang) patient_name_loc_lang,bkg.encounter_id, ");
		queryBuilder.append("bkg.facility_id, bkg.booking_type, bkg.bed_booking_ref_no, bkg.req_nursing_unit_code, ");
		queryBuilder.append("bkg.req_bed_no, bkg.blocking_type_code, ip_Get_desc.Ip_blocking_type(bkg.BlockIng_Type_Code,?,'2') BlockIng_Type_Short_desc, ");
		queryBuilder.append("bkg.blocking_remarks, bkg.blocked_from_date_time blocked_from, bkg.blocked_until_date_time blocked_until, ");
		queryBuilder.append("nvl(bkglst.patient_id , bkg.patient_id) bkg_patient_id, ");
		queryBuilder.append("decode(bkglst.patient_id, null , pat.patient_name, bkglst.patient_name) bkg_patient_name, ");
		queryBuilder.append("NVL (bkglst.gender, pat.sex) bkg_gender, bkglst.referral_id, ");
		queryBuilder.append("Nvl(bkglst.Date_Of_Birth,Pat.Date_Of_Birth) bgk_Date_Of_Birth, ");
		queryBuilder.append("NVL(bkglst.expected_discharge_date,bkg.blocked_until_date_time) expected_discharge_date,  ");
		queryBuilder.append("(");
		queryBuilder.append("	CASE ");
		queryBuilder.append("		WHEN bkglst.Practitioner_Id IS NULL  THEN (Am_Get_desc.Am_practitioner(bkg.req_Practitioner_Id,?,'1'))");
		queryBuilder.append("	ELSE (Am_Get_desc.Am_practitioner(bkglst.Practitioner_Id,?,'1'))");
		queryBuilder.append("	END");
		queryBuilder.append(") Practitioner_Name,  ");
		queryBuilder.append("to_char(bkglst.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, ");
		queryBuilder.append("nvl(bkglst.booking_status,bkg.booking_status)booking_status, bkglst.booking_remarks,");
		queryBuilder.append("bkg.patient_id,bkglst.chief_complaint  ");
		queryBuilder.append("FROM  IP_BED_BOOKING bkg, IP_BOOKING_LIST bkglst, MP_PATIENT pat  ");
		queryBuilder.append("WHERE  bkg.booking_status in ('0','1')  and ");
		queryBuilder.append("sysdate between blocked_from_date_time and ");
		queryBuilder.append("nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy'))  and ");
		queryBuilder.append("bkg.booking_date_time=");
		queryBuilder.append("	(");
		queryBuilder.append("		select max (booking_date_time)  ");
		queryBuilder.append("		from IP_BED_BOOKING ");
		queryBuilder.append("		where facility_id = bkg.facility_id  and ");
		queryBuilder.append("		req_nursing_unit_code = bkg.req_nursing_unit_code  and ");
		queryBuilder.append("		req_bed_no = bkg.req_bed_no  and ");
		queryBuilder.append("		booking_status in ('0','1')  and ");
		queryBuilder.append("		sysdate between blocked_from_date_time and ");
		queryBuilder.append("		nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy'))");
		queryBuilder.append("	)  and ");
		queryBuilder.append("bkglst.facility_id(+) = bkg.facility_id  and ");
		queryBuilder.append("bkglst.bkg_lst_ref_no(+) = bkg.bed_booking_ref_no  and ");
		queryBuilder.append("pat.patient_id(+) = bkg.patient_id ) b ,ip_nursing_unit_room r ");
		queryBuilder.append("WHERE  a.nursing_unit_code = e.nursing_unit_code  and ");
		queryBuilder.append("a.nursing_unit_code='"+nursingUnit+"'   AND ");
		queryBuilder.append("a.bed_no LIKE '%%'  and ");
		queryBuilder.append("a.facility_id = '"+facilityId+"'  and ");
		queryBuilder.append("a.eff_status = 'E'  and ");
		queryBuilder.append("e.eff_status = 'E'  AND ");
		queryBuilder.append("b.facility_id(+) = a.facility_id  AND ");
		queryBuilder.append("b.req_nursing_unit_code (+) = a.nursing_unit_code  AND ");
		queryBuilder.append("b.req_bed_no(+) = a.bed_no   AND ");
		queryBuilder.append("a.Facility_Id = e.Facility_Id  AND ");
		queryBuilder.append("a.Facility_Id = c.Facility_Id (+)  AND ");
		queryBuilder.append("a.OccupyIng_Patient_Id = c.Patient_Id (+)  AND ");
		queryBuilder.append("a.OccupyIng_Patient_Id = d.Patient_Id (+)   /*and a.psuedo_bed_status != 'C'*/ and ");
		queryBuilder.append("a.facility_id = f.facility_id and ");
		queryBuilder.append("r.facility_id=a.facility_id and ");
		queryBuilder.append("r.room_no=a.room_no and ");
		queryBuilder.append("r.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE /*and a.bed_width is not null and r.room_width is not null*/  ");
		queryBuilder.append("and a.BED_LEFT_POSITION is not null ");
		queryBuilder.append("order by  room_no,bed_no");

		
		return queryBuilder.toString();
	}
	
	
}
