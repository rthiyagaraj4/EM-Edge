/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  
 */
package eIPAD.DiaryView.daoimpl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Timestamp;


import eIPAD.DiaryView.dao.DiaryViewDAO;
import eIPAD.DiaryView.healthobject.AppointmentBlockItem;
import eIPAD.DiaryView.healthobject.AppointmentDetailItem;
import eIPAD.DiaryView.healthobject.OPApptDetailItem;
import eIPAD.DiaryView.healthobject.OTApptDetailItem;
import eIPAD.DiaryView.healthobject.OTProcDetail;
import eIPAD.DiaryView.request.DiaryViewRequest;
import eIPAD.DiaryView.response.DiaryViewResponse;
import eIPAD.DiaryView.response.OTProcDetailResponse;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.pendingorders.dao.PendingOrderDAO;

/**
 * @author vchoughule
 *
 */
public class DiaryViewDAOImpl extends  GenericDAOImpl implements DiaryViewDAO {
	
	
	public DiaryViewResponse getDiaryViewDetails (DiaryViewRequest diaryViewRequest){
		DiaryViewResponse diaryViewResponse = new DiaryViewResponse();
		String key = "";
		String prevKey = "";
		StringBuffer sqlStr = new StringBuffer("");
		Connection connection 		= null;
		PreparedStatement pStmt		= null;
		ResultSet resultSet 		= null;
		String practitionerId = diaryViewRequest.getPractitionerId();
		String startDate = diaryViewRequest.getStartDate(); //TODO null checks for request params
		String endDate = diaryViewRequest.getEndDate();
		String locale = diaryViewRequest.getLocale()==null?"en":diaryViewRequest.getLocale();
		String patCategoryFilter = diaryViewRequest.getPatCategoryFilter();
		List<AppointmentBlockItem> apptBlockItemList = new ArrayList<AppointmentBlockItem>();
		if(practitionerId != null)
		{
			//TODO errors are to be added and passed to the response object
			if(patCategoryFilter.equals("null")) //TODO remove string comparison, can have null string or empty string instead
			{
				sqlStr.append("select p.patient_id,p.patient_name,p.date_of_birth,p.sex gender, mp_get_age_ymdh (p.date_of_birth, p.deceased_date) age, a.speciality_desc speciality, a.booking_date booking_date, a.booking_start_time start_time, TO_CHAR(a.booking_start_time, 'HH24:mm:ss') dbstarttime, a.booking_end_time  end_time, c.booking_duration appt_duration,null type_code,null visit_desc, ");
				sqlStr.append(" a.theatre_code locn_code,a.operating_facility_id facility_id, b.long_desc venue_desc, SM_GET_DESC.SM_FACILITY_PARAM(a.operating_facility_id,'"+locale+"','1') facility_desc, 'ot' op_ot , ");
				sqlStr.append(" d.short_desc procedure_detail, null time_table_type , a.nature_code, ");
				sqlStr.append(" (CASE WHEN a.surgeon_code='ALLEN' THEN 'MS' WHEN c.asst_surgeon_code='ALLEN' THEN 'AS1' WHEN c.asst_surgeon_code_2='ALLEN' THEN 'AS2' WHEN c.anaesthetist1_code='ALLEN' THEN 'AN'  END) pract_role, null patient_type, a.booking_num booking_num,  ");
				sqlStr.append(" subquery1.status_desc,subquery1.order_id, subquery1.booking_stage ,(case when (select source_order_id from AT_ANAESTHESIA_RECORD_HDR where patient_id= a.patient_id and subquery1.order_id = source_order_id) =  subquery1.order_id then 'PACDONE'  when ( select source_order_id from at_pending_orders where patient_id=a.patient_id and subquery1.order_id = source_order_id) =  subquery1.order_id then 'PACORDERED' else 'NOTORDERED'   END) PACStatus  ");
				sqlStr.append(" from OT_BOOKINGS_VW a, OT_OPER_ROOM b, OT_BOOKING_HDR c, mp_patient p, OT_OPER_MAST_LANG_VW d ,(select patient_id,oper_code,appt_date, status_desc, order_id,booking_stage from OT_SCHD_OPERS_VW where language_id='"+locale+"' ) subquery1  where (a.surgeon_code='"+ practitionerId +"' or c.asst_surgeon_code='"+ practitionerId +"' or c.asst_surgeon_code_2='"+ practitionerId +"' or c.anaesthetist1_code='"+ practitionerId +"') ");
				sqlStr.append(" and a.booking_status in ('0','1') and a.booking_start_time is not null and a.booking_end_time is not null ");
				sqlStr.append(" and a.theatre_code = b.oper_room_code and c.operating_facility_id = a.operating_facility_id and c.booking_num=a.booking_num and a.patient_id= p.patient_id and a.language_id='"+locale+"' and a.booking_date >= TO_CHAR(SYSDATE, 'DD-MON-YYYY') and a.booking_date between to_date('"+ startDate +"','dd/mm/yyyy') and to_date('"+ endDate+"','dd/mm/yyyy') ");
				sqlStr.append(" and a.oper_code = d.oper_code and d.language_id='"+locale+"' and subquery1.patient_id=a.patient_id and subquery1.oper_code=a.oper_code and subquery1.appt_date=a.booking_date ");
				sqlStr.append(" union ");
				sqlStr.append(" select p.patient_id,a.patient_name, a.date_of_birth,a.gender gender, mp_get_age_ymdh (a.date_of_birth, sysdate) age, d.long_desc speciality, a.appt_date booking_date, a.appt_slab_from_time start_time, TO_CHAR(a.appt_slab_from_time, 'HH24:mm:ss') dbstarttime, a.appt_slab_to_time  end_time, a.appt_duration appt_duration,  ");
				sqlStr.append(" a.appt_type_code type_code,c.short_desc visit_desc,a.clinic_code locn_code,a.facility_id facility_id, b.long_desc venue_desc, SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,'"+locale+"','1') facility_desc, 'op' op_ot , ");
				sqlStr.append(" null procedure_detail, a.time_table_type, null nature_code, null pract_role, a.inpatient_yn patient_type, a.appt_ref_no booking_num, null status_desc, null order_id, null booking_stage, null PACStatus  ");
				sqlStr.append(" from oa_appt a left outer join  mp_patient p on a.patient_id= p.patient_id  , op_clinic_lang_vw b, op_visit_type_lang_vw c  ,am_speciality_lang_vw d   where a.practitioner_id='"+ practitionerId +"' and a.appt_slab_from_time is not null and a.appt_slab_to_time is not null ");
				sqlStr.append(" and  b.language_id='"+locale+"' and a.clinic_code= b.clinic_code and a.facility_id=b.facility_id and a.appt_type_code= c.visit_type_code and c.language_id = b.language_id and c.facility_id=a.facility_id and a.appt_date >= TO_CHAR(SYSDATE, 'DD-MON-YYYY') and a.appt_date between to_date('"+ startDate +"','dd/mm/yyyy') and to_date('"+ endDate+"','dd/mm/yyyy') ");
				sqlStr.append("  and d.speciality_code = a.speciality_code and d.language_id = '"+locale+"' ");
				sqlStr.append(" order by booking_date, dbstarttime  ");
			}
			else
			{
				if(patCategoryFilter.equals("OP"))
				{
					sqlStr.append(" select p.patient_id,a.patient_name, a.date_of_birth,a.gender gender, mp_get_age_ymdh (a.date_of_birth, sysdate) age, d.long_desc speciality, a.appt_date booking_date, a.appt_slab_from_time start_time, TO_CHAR(a.appt_slab_from_time, 'HH24:mm:ss') dbstarttime, a.appt_slab_to_time  end_time, a.appt_duration appt_duration,  ");
					sqlStr.append(" a.appt_type_code type_code,c.short_desc visit_desc,a.clinic_code locn_code,a.facility_id facility_id, b.long_desc venue_desc, SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,'"+locale+"','1') facility_desc, 'op' op_ot , ");
					sqlStr.append(" null procedure_detail, a.time_table_type, null nature_code, null pract_role, a.inpatient_yn patient_type, a.appt_ref_no booking_num, null status_desc, null order_id, null booking_stage, null PACStatus  ");
					sqlStr.append(" from oa_appt a left outer join  mp_patient p on a.patient_id= p.patient_id  , op_clinic_lang_vw b, op_visit_type_lang_vw c  ,am_speciality_lang_vw d   where a.practitioner_id='"+ practitionerId +"' and a.appt_slab_from_time is not null and a.appt_slab_to_time is not null ");
					sqlStr.append(" and  b.language_id='"+locale+"' and a.clinic_code= b.clinic_code and a.facility_id=b.facility_id  and a.appt_type_code= c.visit_type_code and c.language_id = b.language_id and c.facility_id=a.facility_id and a.appt_date >= TO_CHAR(SYSDATE, 'DD-MON-YYYY') and a.appt_date between to_date('"+ startDate +"','dd/mm/yyyy') and to_date('"+ endDate+"','dd/mm/yyyy') ");
					sqlStr.append("  and d.speciality_code = a.speciality_code and d.language_id = '"+locale+"' ");
					sqlStr.append(" order by booking_date, dbstarttime  ");
				}
				else //TODO condition for OT needs to be added -Done
				{	if(patCategoryFilter.equals("OT"))	
					{
					sqlStr.append("select p.patient_id,p.patient_name,p.date_of_birth,p.sex gender, mp_get_age_ymdh (p.date_of_birth, p.deceased_date) age, a.speciality_desc speciality, a.booking_date booking_date, a.booking_start_time start_time, TO_CHAR(a.booking_start_time, 'HH24:mm:ss') dbstarttime, a.booking_end_time  end_time, c.booking_duration appt_duration,null type_code,null visit_desc, ");
					sqlStr.append(" a.theatre_code locn_code,a.operating_facility_id facility_id, b.long_desc venue_desc, SM_GET_DESC.SM_FACILITY_PARAM(a.operating_facility_id,'"+locale+"','1') facility_desc, 'ot' op_ot , ");
					sqlStr.append(" d.short_desc procedure_detail, null time_table_type , a.nature_code, ");
					sqlStr.append(" (CASE WHEN a.surgeon_code='ALLEN' THEN 'MS' WHEN c.asst_surgeon_code='ALLEN' THEN 'AS1' WHEN c.asst_surgeon_code_2='ALLEN' THEN 'AS 2' WHEN c.anaesthetist1_code='ALLEN' THEN 'AN'  END) pract_role, null patient_type, a.booking_num booking_num,  ");
					sqlStr.append(" subquery1.status_desc,subquery1.order_id, subquery1.booking_stage ,(case when (select source_order_id from AT_ANAESTHESIA_RECORD_HDR where patient_id= a.patient_id and subquery1.order_id = source_order_id) =  subquery1.order_id then 'PACDONE'  when ( select source_order_id from at_pending_orders where patient_id=a.patient_id and subquery1.order_id = source_order_id) =  subquery1.order_id then 'PACORDERED' else 'NOTORDERED'   END) PACStatus  ");
					sqlStr.append(" from OT_BOOKINGS_VW a, OT_OPER_ROOM b, OT_BOOKING_HDR c, mp_patient p, OT_OPER_MAST_LANG_VW d ,(select patient_id,oper_code,appt_date, status_desc, order_id,booking_stage from OT_SCHD_OPERS_VW where language_id='"+locale+"' ) subquery1 where (a.surgeon_code='"+ practitionerId +"' or c.asst_surgeon_code='"+ practitionerId +"' or c.asst_surgeon_code_2='"+ practitionerId +"' or c.anaesthetist1_code='"+ practitionerId +"') ");
					sqlStr.append(" and a.booking_status in ('0','1') and a.booking_start_time is not null and a.booking_end_time is not null ");
					sqlStr.append(" and a.theatre_code = b.oper_room_code and c.operating_facility_id = a.operating_facility_id and c.booking_num=a.booking_num and a.patient_id= p.patient_id and a.language_id='"+locale+"' and a.booking_date >= TO_CHAR(SYSDATE, 'DD-MON-YYYY') and a.booking_date between to_date('"+ startDate +"','dd/mm/yyyy') and to_date('"+ endDate+"','dd/mm/yyyy') ");
					sqlStr.append(" and a.oper_code = d.oper_code and d.language_id='"+locale+"' and subquery1.patient_id=a.patient_id and subquery1.oper_code=a.oper_code and subquery1.appt_date=a.booking_date ");
					sqlStr.append(" order by booking_date, dbstarttime  ");
					}
				}	
			}
			try
			{	
            	connection = createConnection();
				if(connection != null)
				{
					pStmt = connection.prepareStatement(sqlStr.toString());
				}
				if(pStmt != null){
					resultSet = pStmt.executeQuery();
				}
				if(resultSet != null) //TODO add else part
				{
					while(resultSet.next())
					{
						// MAKE THE KEY BY TAKING VALUES 
						Date bookingDt = resultSet.getDate("booking_date");
						SimpleDateFormat keydf = new SimpleDateFormat("dd-MM-yyyy");
						String bookingDate = keydf.format(bookingDt); 
						String locationId = resultSet.getString("locn_code");
						String facilityId = resultSet.getString("facility_id");
						String apptType = resultSet.getString("op_ot");
						String opApptType= resultSet.getString("time_table_type");
						
						key = bookingDate.concat("_").concat(facilityId).concat("_").concat(locationId).concat("_").concat(apptType);
						if(!key.equals(prevKey))
						{
							AppointmentBlockItem oApptBlockItems = new AppointmentBlockItem();
							
							oApptBlockItems.setApptDetailCount(1);
							Date apptDuration= resultSet.getTimestamp("appt_duration");
							Calendar c = Calendar.getInstance();
							c.setTime(apptDuration);
							int minCount = c.get(Calendar.MINUTE);
							int hourCount = c.get(Calendar.HOUR_OF_DAY);
							oApptBlockItems.setMinCount(minCount);
							oApptBlockItems.setHourCount(hourCount);
							
							oApptBlockItems.setFacilityId(checkForNull(resultSet.getString("facility_id")));
							oApptBlockItems.setFaciltityDesc(checkForNull(resultSet.getString("facility_desc")));
							oApptBlockItems.setLocationId(checkForNull(resultSet.getString("locn_code")));
							oApptBlockItems.setLocationDesc(checkForNull(resultSet.getString("venue_desc")));// it is location desc
							oApptBlockItems.setAppointmentType(checkForNull(resultSet.getString("op_ot")));
							oApptBlockItems.setBookingDate(resultSet.getDate("booking_date"));
							oApptBlockItems.setStartTime(resultSet.getTimestamp("start_time"));
							oApptBlockItems.setEndTime(resultSet.getTimestamp("end_time"));
							oApptBlockItems.setAppointmentDuration(resultSet.getTimestamp("appt_duration"));
							oApptBlockItems.setSpecialityDesc(checkForNull(resultSet.getString("speciality")));
							oApptBlockItems.setTimeTableType(checkForNull(resultSet.getString("time_table_type")));
							
							/*AppointmentDetailItem oApptDetaiItem = new AppointmentDetailItem() ;
							ArrayList<AppointmentDetailItem> apptDetailItemList = new ArrayList<AppointmentDetailItem>();*/
							
							if(apptType.equals("op"))
							{
								
							//create OPApptDetailItem object &  close this if condition
								OPApptDetailItem oOPApptDetaiItem = new OPApptDetailItem();
								/*ArrayList<AppointmentDetailItem> opapptDetailItemList = new ArrayList<AppointmentDetailItem>();*/
								ArrayList<OPApptDetailItem> opapptDetailItemList =new ArrayList<OPApptDetailItem>();
				
								oOPApptDetaiItem.setPatientId(checkForNull(resultSet.getString("patient_id")));
								oOPApptDetaiItem.setPatientName(checkForNull(resultSet.getString("patient_name")));
								oOPApptDetaiItem.setPatientAge(checkForNull(resultSet.getString("age")));
								oOPApptDetaiItem.setPatientSex(checkForNull(resultSet.getString("gender")));
								oOPApptDetaiItem.setStartTime(resultSet.getTimestamp("start_time"));
								oOPApptDetaiItem.setEndTime(resultSet.getTimestamp("end_time"));
								oOPApptDetaiItem.setAppointmentDuration(resultSet.getTimestamp("appt_duration"));
								oOPApptDetaiItem.setSpecialityDesc(checkForNull(resultSet.getString("speciality")));
								oOPApptDetaiItem.setLocationDesc(checkForNull(resultSet.getString("venue_desc")));
								oOPApptDetaiItem.setBookingDate(resultSet.getDate("booking_date"));
							
								oOPApptDetaiItem.setPatientType(checkForNull(resultSet.getString("patient_type")));// gives o/p as Y or N
							
								oOPApptDetaiItem.setBookingNo(checkForNull(resultSet.getString("booking_num")));
								
								oOPApptDetaiItem.setFacilityId(checkForNull(resultSet.getString("facility_id")));
								
								oOPApptDetaiItem.setVisitDesc(checkForNull(resultSet.getString("visit_desc")));
								oOPApptDetaiItem.setTimeTableType(checkForNull(resultSet.getString("time_table_type")));
								opapptDetailItemList.add(oOPApptDetaiItem);
							
								/*oOTApptDetailItem.setPractRole(checkForNull(resultSet.getString("pract_role")));
								oOTApptDetailItem.setProcedureDetail(checkForNull(resultSet.getString("procedure_detail")));
								oOTApptDetailItem.setOperationType(checkForNull(resultSet.getString("nature_code")));
								otapptDetailItemList.add(oOTApptDetailItem);*/
								
								/*apptDetailItemList.add(oOPApptDetailItem);
								apptDetailItemList.add(oOTApptDetailItem);*/
								//apptDetailItemList.add(opapptDetailItemList);
								
								/*oApptBlockItems.setAppointmentDetail(opapptDetailItemList);*/
							
							oApptBlockItems.setOpapptDetailList(opapptDetailItemList);
							apptBlockItemList.add(oApptBlockItems);
							}
							
							else 
							{
								OTApptDetailItem oOTApptDetaiItem = new OTApptDetailItem();
								/*ArrayList<AppointmentDetailItem> otapptDetailItemList = new ArrayList<AppointmentDetailItem>();*/
								ArrayList<OTApptDetailItem> otapptDetailItemList =new ArrayList<OTApptDetailItem>();
								
								oOTApptDetaiItem.setPatientId(checkForNull(resultSet.getString("patient_id")));
								oOTApptDetaiItem.setPatientName(checkForNull(resultSet.getString("patient_name")));
								oOTApptDetaiItem.setPatientAge(checkForNull(resultSet.getString("age")));
								oOTApptDetaiItem.setPatientSex(checkForNull(resultSet.getString("gender")));
								oOTApptDetaiItem.setStartTime(resultSet.getTimestamp("start_time"));
								oOTApptDetaiItem.setEndTime(resultSet.getTimestamp("end_time"));
								oOTApptDetaiItem.setAppointmentDuration(resultSet.getTimestamp("appt_duration"));
								oOTApptDetaiItem.setSpecialityDesc(checkForNull(resultSet.getString("speciality")));
								oOTApptDetaiItem.setLocationDesc(checkForNull(resultSet.getString("venue_desc")));
								oOTApptDetaiItem.setBookingDate(resultSet.getDate("booking_date"));
								oOTApptDetaiItem.setStatusDesc(checkForNull(resultSet.getString("status_desc")));
								oOTApptDetaiItem.setPACStatus(checkForNull(resultSet.getString("PACSTATUS")));
								oOTApptDetaiItem.setBookingStage(checkForNull(resultSet.getString("Booking_stage")));
								oOTApptDetaiItem.setOrderId(checkForNull(resultSet.getString("Order_id")));
								
								oOTApptDetaiItem.setPatientType(checkForNull(resultSet.getString("patient_type")));// gives o/p as Y or N
							
								oOTApptDetaiItem.setBookingNo(checkForNull(resultSet.getString("booking_num")));
								String bookingNo= resultSet.getString("booking_num");
								oOTApptDetaiItem.setFacilityId(checkForNull(resultSet.getString("facility_id")));
							
								/*oOPApptDetaiItem.setVisitDesc(checkForNull(resultSet.getString("visit_desc")));
								oOPApptDetaiItem.setTimeTableType(checkForNull(resultSet.getString("time_table_type")));*/
								
							
								oOTApptDetaiItem.setPractRole(checkForNull(resultSet.getString("pract_role")));
								/*oOTApptDetaiItem.setProcedureDetail(checkForNull(resultSet.getString("procedure_detail")));*/
								oOTApptDetaiItem.setOperationType(checkForNull(resultSet.getString("nature_code")));
								
								ArrayList<String> procDetail =  getProcDetails(bookingNo,facilityId,locale);
								
								oOTApptDetaiItem.setProcDetail(procDetail);
								otapptDetailItemList.add(oOTApptDetaiItem);
								//otapptDetailItemList.add(oOTApptDetailItem);
								
								/*apptDetailItemList.add(oOPApptDetailItem);
								apptDetailItemList.add(oOTApptDetailItem);*/
								//apptDetailItemList.add(opapptDetailItemList);
								
								/*oApptBlockItems.setAppointmentDetail(otapptDetailItemList);*/
								oApptBlockItems.setOtapptDetailList(otapptDetailItemList);
								apptBlockItemList.add(oApptBlockItems);
							
							}
							prevKey=key;
							key="";
						}
						
						else
						{
							int blockCount = apptBlockItemList.size();
							AppointmentBlockItem oApptBlockItems = apptBlockItemList.get(blockCount-1);
							if(apptType.equals("op"))
							{
								OPApptDetailItem oOPApptDetaiItem = new OPApptDetailItem();
								/*ArrayList<AppointmentDetailItem> opapptDetailItemList = new ArrayList<AppointmentDetailItem>();*/
								ArrayList<OPApptDetailItem> opapptDetailItemList = oApptBlockItems.getOpapptDetailList();
								
								oOPApptDetaiItem.setPatientId(checkForNull(resultSet.getString("patient_id")));
								oOPApptDetaiItem.setPatientName(checkForNull(resultSet.getString("patient_name")));
								oOPApptDetaiItem.setPatientAge(checkForNull(resultSet.getString("age")));
								oOPApptDetaiItem.setPatientSex(checkForNull(resultSet.getString("gender")));
								oOPApptDetaiItem.setStartTime(resultSet.getTimestamp("start_time"));
								oOPApptDetaiItem.setEndTime(resultSet.getTimestamp("end_time"));
								oOPApptDetaiItem.setAppointmentDuration(resultSet.getTimestamp("appt_duration"));
								oOPApptDetaiItem.setSpecialityDesc(checkForNull(resultSet.getString("speciality")));
								oOPApptDetaiItem.setLocationDesc(checkForNull(resultSet.getString("venue_desc")));
								oOPApptDetaiItem.setBookingDate(resultSet.getDate("booking_date"));
								oOPApptDetaiItem.setPatientType(checkForNull(resultSet.getString("patient_type")));// gives o/p as Y or N
								oOPApptDetaiItem.setBookingNo(checkForNull(resultSet.getString("booking_num")));
								oOPApptDetaiItem.setFacilityId(checkForNull(resultSet.getString("facility_id")));
								oOPApptDetaiItem.setVisitDesc(checkForNull(resultSet.getString("visit_desc")));
								oOPApptDetaiItem.setTimeTableType(checkForNull(resultSet.getString("time_table_type")));
								
								if(apptType.equals("op") && opApptType.equals("2")) // if appt type is slab then do nothing jst add the details to the block item. 
								{   
									opapptDetailItemList.add(oOPApptDetaiItem);
									/*oApptBlockItems.setAppointmentDetail(opapptDetailItemList);*/
									oApptBlockItems.setOpapptDetailList(opapptDetailItemList);
									
									 
								}
								else // else increment the count of patients and duration
								{
									int noOfdetails = oApptBlockItems.getApptDetailCount();
									noOfdetails++;
									oApptBlockItems.setApptDetailCount(noOfdetails);
									
									Date apptDuration= resultSet.getTimestamp("appt_duration");
									Calendar c = Calendar.getInstance();
									c.setTime(apptDuration);
									int minCount = c.get(Calendar.MINUTE);
									int hourCount = c.get(Calendar.HOUR_OF_DAY);
									int prevMinCount = oApptBlockItems.getMinCount();
									int prevHourCount = oApptBlockItems.getHourCount();
									int totMinCount = minCount + prevMinCount;
									int totHourcount = prevHourCount + hourCount; 
									if(totMinCount >= 60  )
									{
										totHourcount = totHourcount + 1;
										totMinCount = totMinCount - 60;
									}
									
									oApptBlockItems.setHourCount(totHourcount);
									oApptBlockItems.setMinCount(totMinCount);
									
									opapptDetailItemList.add(oOPApptDetaiItem);
									/*oApptBlockItems.setAppointmentDetail(opapptDetailItemList);*/
									oApptBlockItems.setOpapptDetailList(opapptDetailItemList);
								}
							}
							else
							{
								OTApptDetailItem oOTApptDetaiItem = new OTApptDetailItem();
								/*ArrayList<AppointmentDetailItem> otapptDetailItemList = new ArrayList<AppointmentDetailItem>();*/
								ArrayList<OTApptDetailItem> otapptDetailItemList =oApptBlockItems.getOtapptDetailList();
								
								oOTApptDetaiItem.setPatientId(checkForNull(resultSet.getString("patient_id")));
								oOTApptDetaiItem.setPatientName(checkForNull(resultSet.getString("patient_name")));
								oOTApptDetaiItem.setPatientAge(checkForNull(resultSet.getString("age")));
								oOTApptDetaiItem.setPatientSex(checkForNull(resultSet.getString("gender")));
								oOTApptDetaiItem.setStartTime(resultSet.getTimestamp("start_time"));
								oOTApptDetaiItem.setEndTime(resultSet.getTimestamp("end_time"));
								oOTApptDetaiItem.setAppointmentDuration(resultSet.getTimestamp("appt_duration"));
								oOTApptDetaiItem.setSpecialityDesc(checkForNull(resultSet.getString("speciality")));
								oOTApptDetaiItem.setLocationDesc(checkForNull(resultSet.getString("venue_desc")));
								oOTApptDetaiItem.setBookingDate(resultSet.getDate("booking_date"));
								oOTApptDetaiItem.setStatusDesc(checkForNull(resultSet.getString("status_desc")));
								oOTApptDetaiItem.setPACStatus(checkForNull(resultSet.getString("PACSTATUS")));
								oOTApptDetaiItem.setBookingStage(checkForNull(resultSet.getString("Booking_stage")));
								oOTApptDetaiItem.setOrderId(checkForNull(resultSet.getString("Order_id")));
								oOTApptDetaiItem.setPatientType(checkForNull(resultSet.getString("patient_type")));// gives o/p as Y or N
								oOTApptDetaiItem.setBookingNo(checkForNull(resultSet.getString("booking_num")));
								String bookingNo= resultSet.getString("booking_num");
								oOTApptDetaiItem.setFacilityId(checkForNull(resultSet.getString("facility_id")));
							
								/*oOPApptDetaiItem.setVisitDesc(checkForNull(resultSet.getString("visit_desc")));
								oOPApptDetaiItem.setTimeTableType(checkForNull(resultSet.getString("time_table_type")));*/
								
							
								oOTApptDetaiItem.setPractRole(checkForNull(resultSet.getString("pract_role")));
								oOTApptDetaiItem.setProcedureDetail(checkForNull(resultSet.getString("procedure_detail")));
								oOTApptDetaiItem.setOperationType(checkForNull(resultSet.getString("nature_code")));
								
								ArrayList<String> procDetail =  getProcDetails(bookingNo,facilityId,locale);
								
								oOTApptDetaiItem.setProcDetail(procDetail);
								
								otapptDetailItemList.add(oOTApptDetaiItem);
							//otapptDetailItemList.add(oOTApptDetailItem);
							
							/*apptDetailItemList.add(oOPApptDetailItem);
							apptDetailItemList.add(oOTApptDetailItem);*/
							//apptDetailItemList.add(opapptDetailItemList);
							
								int noOfdetails = oApptBlockItems.getApptDetailCount();
								noOfdetails++;
								oApptBlockItems.setApptDetailCount(noOfdetails);
								
								Date apptDuration= resultSet.getTimestamp("appt_duration");
								Calendar c = Calendar.getInstance();
								c.setTime(apptDuration);
								int minCount = c.get(Calendar.MINUTE);
								int hourCount = c.get(Calendar.HOUR_OF_DAY);
								int prevMinCount = oApptBlockItems.getMinCount();
								int prevHourCount = oApptBlockItems.getHourCount();
								int totMinCount = minCount + prevMinCount;
								int totHourcount = prevHourCount + hourCount; 
								if(totMinCount >= 60  )
								{
									totHourcount = totHourcount + 1;
									totMinCount = totMinCount - 60;
								}
								
								oApptBlockItems.setHourCount(totHourcount);
								oApptBlockItems.setMinCount(totMinCount);
								
								
							/*oApptBlockItems.setAppointmentDetail(otapptDetailItemList);*/
							oApptBlockItems.setOtapptDetailList(otapptDetailItemList);
							/*apptBlockItemList.add(oApptBlockItems);*/

							}
							
							/*AppointmentDetailItem oApptDetaiItem = new AppointmentDetailItem();
							ArrayList<AppointmentDetailItem> apptDetailItemList = oApptBlockItems.getAppointmentDetail();
						
							
							if(apptType.equals("op") && opApptType.equals("2")) // if appt type is slab then do nothing jst add the details to the block item. 
							{   
								apptDetailItemList.add(oApptDetaiItem);
								oApptBlockItems.setAppointmentDetail(apptDetailItemList);
								 
							}
							else // else increment the count of patients and duration
							{
								int noOfdetails = oApptBlockItems.getApptDetailCount();
								noOfdetails++;
								oApptBlockItems.setApptDetailCount(noOfdetails);
								
								Date apptDuration= resultSet.getTimestamp("appt_duration");
								Calendar c = Calendar.getInstance();
								c.setTime(apptDuration);
								int minCount = c.get(Calendar.MINUTE);
								int hourCount = c.get(Calendar.HOUR_OF_DAY);
								int prevMinCount = oApptBlockItems.getMinCount();
								int prevHourCount = oApptBlockItems.getHourCount();
								int totMinCount = minCount + prevMinCount;
								int totHourcount = prevHourCount + hourCount; 
								if(totMinCount >= 60  )
								{
									totHourcount = totHourcount + 1;
									totMinCount = totMinCount - 60;
								}
								
								oApptBlockItems.setHourCount(totHourcount);
								oApptBlockItems.setMinCount(totMinCount);
								opapptDetailItemList.add(oOPApptDetailItem);
								otapptDetailItemList.add(oOTApptDetailItem);
								
								apptDetailItemList.add(oOPApptDetailItem);
								apptDetailItemList.add(oOTApptDetailItem);
								apptDetailItemList.add(oApptDetaiItem);
								oApptBlockItems.setAppointmentDetail(apptDetailItemList);
							}*/
							key="";
						}
					}
					diaryViewResponse.setApptBlockItemList(apptBlockItemList);
				}
            }
		 	catch(Exception e)
            {
            	e.printStackTrace();
            }
            finally
            {
            	int conCloseFailure = closeConnection(connection,pStmt,resultSet);
				if(conCloseFailure > 0)
				{
					System.out.println("Connection not closed in the method ");
				}
            }
		}
		return diaryViewResponse;
	}
	// method added to send the multiple procedure details 
	//TODO have to apply the logic for Multiple procedure details in new datastructure 
	
	public ArrayList<String> getProcDetails (String bookingNo, String facilityID, String locale){ //TODO appt word 
		/*OTProcDetailResponse procDetailResponse = new OTProcDetailResponse();*/
/*		String booking_No= bookingNo; // TODO null checks for all
		String facility_Id= facilityID;//TODO Remove duplicate references for method params
		String locale_L = locale ;
*/		
		//OTApptDetailItem oOTApptDetaiItem = new OTApptDetailItem();
		
		ArrayList<String> procDetailList = new ArrayList<String>();
		StringBuffer sqlStr = new StringBuffer("");
		Connection connection 		= null;
		PreparedStatement pStmt		= null;
		ResultSet resultSet 		= null;
		if(bookingNo != null && facilityID != null && locale != null){ // TODO null check to be performed for other params as well
			sqlStr.append(" SELECT B.oper_code, B.long_desc	FROM  OT_BOOKING_DTLS A, OT_OPER_MAST_LANG_VW B ");
			sqlStr.append(" WHERE B.LANGUAGE_ID = '"+locale+"' AND A.OPERATING_FACILITY_ID = '"+facilityID+"' AND A.BOOKING_NUM = '"+bookingNo+"' AND  A.OPER_CODE= B.OPER_CODE ");
			try
			{	
            	connection = createConnection();
				if(connection != null)
				{
					pStmt = connection.prepareStatement(sqlStr.toString());
				}
				if(pStmt != null){
					resultSet = pStmt.executeQuery();
				}
				if(resultSet != null) //TODO add else part
				{
					while(resultSet.next())
					{
						//OTProcDetail oProcDetail = new OTProcDetail();
						/*oProcDetail.setOperCode(checkForNull(resultSet.getString("oper_code")));*/
						//oOTApptDetaiItem.setProcedureDetail(checkForNull(resultSet.getString("long_desc")));
						//oOTApptDetaiItem.setProcDetail(checkForNull(resultSet.getString("long_desc")));
						/*oProcDetail.setProcDesc(checkForNull(resultSet.getString("long_desc")));*/
						/*procDetailList.add(oProcDetail);*/
						String procDetail = resultSet.getString("long_desc");
						
						procDetailList.add(procDetail);
						
					}
				}
			}
			catch(Exception e)
            {
            	e.printStackTrace();
            }
            finally
            {
            	int conCloseFailure = closeConnection(connection,pStmt,resultSet);
				if(conCloseFailure > 0)
				{
					System.out.println("Connection not closed in the method ");
				}
            }
		
		}
		//procDetailResponse.setOtProcDetailList(procDetailList);
		//return procDetailResponse;
		return procDetailList;
	}
	
	
	
		private String checkForNull(String strParam)
	    {
	            String str ="";
	            if(strParam!=null && strParam.length() > 0)
	            str = strParam;
	            return str;
	    }
}
