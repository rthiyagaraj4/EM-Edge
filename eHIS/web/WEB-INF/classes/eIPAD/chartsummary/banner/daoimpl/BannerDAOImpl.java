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
package eIPAD.chartsummary.banner.daoimpl;

/**
 * @author GaneshkumarC 
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.daoimpl.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.banner.dao.*;
import eIPAD.chartsummary.banner.healthobject.*;
import eIPAD.chartsummary.banner.request.*;
import eIPAD.chartsummary.banner.response.*;

public class BannerDAOImpl extends GenericDAOImpl implements BannerDAO {
	public BannerResponse getBannerDetails(BannerRequest oBannerReq)
	{
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strEncounterId = "";
		StringBuffer sqlStr = new StringBuffer("");
		StringBuffer sqlBanner = new StringBuffer("");
		BannerResponse oBannerRes = new BannerResponse();
		BannerContentsHO oBnrContentHO;
		BannerConfigHO oBnrConfigHO;
		ErrorInfo oErrInfo = new ErrorInfo();
		if(oBannerReq != null)
		{
			PatContext oPatContext = oBannerReq.getPatientContext();
			if(oPatContext != null)
			{
				strEncounterId = checkForNull(oPatContext.getEncounterId());
				locale =  checkForNull(oPatContext.getLocale());
				oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
				
				sqlStr.append(" SELECT a.patient_id pat_id, a.patient_name pat_name,  a.patient_name_loc_lang pat_name_loc_lang, mp_get_age_ymdh (a.date_of_birth, a.deceased_date) age,");
				sqlStr.append(" a.calculated_age_yn estd, a.alt_id1_no alt_id, a.coded_pseudo_name, mp_get_desc.mp_country (a.nationality_code, '" + locale +"', 3) nationality,");
				sqlStr.append(" a.national_id_no nat_id,  mp_get_desc.mp_pat_category (a.pat_cat_code, '" + locale+"', 1) pat_categ, a.sex gender,(CASE WHEN a.family_org_sub_id IS NOT NULL THEN (SELECT family_org_sub_name  FROM mp_family_org_sub_lang_vw WHERE family_org_id = a.family_org_id AND family_org_sub_id = a.family_org_sub_id  AND language_id = 'en') END  ) orgsubname, ");
				sqlStr.append(" (CASE WHEN a.family_org_id IS NOT NULL THEN (SELECT family_org_name FROM mp_family_org_lang_vw WHERE family_org_id = a.family_org_id AND language_id = '" + locale +"') END ) orgname, ");
				sqlStr.append("  NVL (c.ocpn_desc,  mp_get_desc.mp_occupation (c.ocpn_code, '" + locale+"', 2) ) occupation, b.encounter_id enc_id, am_get_desc.am_practitioner (b.attend_practitioner_id, '" + locale+"', 2 ) attend_pract_id, ");
				sqlStr.append(" CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit (facility_id, b.assign_care_locn_code, '" + locale +"',  1 ) ELSE op_get_desc.op_clinic (facility_id,  b.assign_care_locn_code, '" + locale + "', 1  ) END locn, ");
				sqlStr.append("  b.assign_room_num room_num, b.assign_bed_num bed_num, am_get_desc.am_speciality (b.specialty_code, '" + locale+"', 2) splty, a.patient_id,a.deceased_yn, a.suspend_yn, a.active_yn, DECODE (d.govt_or_pvt_ind, 'V', 'Y', 'N') vip_yn, b.episode_id bl_episode_id, b.op_episode_visit_num bl_op_episode_visit_num,  ");
				sqlStr.append(" (SELECT operational_yn FROM sm_modules_facility WHERE facility_id = '" + checkForNull(oPatContext.getFacilityId())+ "' AND module_id = 'CP') cp_operational_yn,");
				sqlStr.append(" TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') date_of_birth  FROM mp_patient a, pr_encounter b, mp_pat_rel_contacts c, mp_pat_category d  WHERE b.encounter_id = '" +strEncounterId + "'");
				sqlStr.append(" AND b.facility_id = '" +checkForNull(oPatContext.getFacilityId()) +"' AND a.patient_id = c.patient_id  AND b.patient_id = a.patient_id  AND a.pat_cat_code = d.pat_cat_code(+) ");
				
				sqlBanner.append("select elmt_ref from MP_PAT_BANNER_DTL where banner_categ='E'");
				
				try
				{
					connection = createConnection();
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if(stmt != null)
					{
						resultSet = stmt.executeQuery(sqlStr.toString());
					}
					if(resultSet != null)
					{
						oBnrContentHO = new BannerContentsHO();
						while(resultSet.next())
						{
							oBnrContentHO.setPatientId(checkForNull(resultSet.getString("pat_id")));
							oBnrContentHO.setPatientName(checkForNull(resultSet.getString("pat_name")));
							oBnrContentHO.setPatientNameLocal(checkForNull(resultSet.getString("pat_name_loc_lang")));
							oBnrContentHO.setGender(checkForNull(resultSet.getString("gender")));
							oBnrContentHO.setAge(checkForNull(resultSet.getString("age")));
							oBnrContentHO.setDob(checkForNull(resultSet.getString("date_of_birth")));
							oBnrContentHO.setNursingUnit(checkForNull(resultSet.getString("room_num")));
							oBnrContentHO.setBedNum(checkForNull(resultSet.getString("bed_num")));
							oBnrContentHO.setNationality(checkForNull(resultSet.getString("nationality")));
							oBnrContentHO.setAttendPractName(checkForNull(resultSet.getString("attend_pract_id")));
							oBnrContentHO.setEncounterId(strEncounterId);
						}
						oBannerRes.setBannerContent(oBnrContentHO);
					}
					if(resultSet != null)
						resultSet.close();
					if(stmt != null)
					{
						stmt.close();
					}
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if(stmt != null)
					{
						resultSet = stmt.executeQuery(sqlBanner.toString());
					}
					if(resultSet != null)
					{
						oBnrConfigHO = new BannerConfigHO();
						String strElementRef = "";
						while(resultSet.next())
						{
							strElementRef = checkForNull(resultSet.getString("elmt_ref"));
							if(strElementRef.equalsIgnoreCase("patient_id"))
							{
								oBnrConfigHO.setPatientID(true);
							}
							if(strElementRef.equalsIgnoreCase("patient_name"))
							{
								oBnrConfigHO.setPatientName(true);
							}
							if(strElementRef.equalsIgnoreCase("gender"))
							{
								oBnrConfigHO.setGender(true);
							}
							if(strElementRef.equalsIgnoreCase("encounter_id"))
							{
								oBnrConfigHO.setEncounterId(true);
							}
							if(strElementRef.equalsIgnoreCase("LOCN_BED_ROOM_NO"))
							{
								oBnrConfigHO.setNursingUnit(true);
							}
							if(strElementRef.equalsIgnoreCase("age"))
							{
								oBnrConfigHO.setAge(true);
							}
							if(strElementRef.equalsIgnoreCase("pat_name_local_lang"))
							{
								oBnrConfigHO.setLocalName(true);
							}
							if(strElementRef.equalsIgnoreCase("vip_pat"))
							{
								oBnrConfigHO.setVipPatient(true);
							}
							if(strElementRef.equalsIgnoreCase("pat_photo"))
							{
								oBnrConfigHO.setPatientPhoto(true);
							}
							if(strElementRef.equalsIgnoreCase("nationality"))
							{
								oBnrConfigHO.setNationality(true);
							}
						}
						oBannerRes.setBannerConfig(oBnrConfigHO);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					int conCloseFailure = closeConnection(connection,stmt,resultSet);
					if(conCloseFailure > 0)
					{
						System.out.println("Connection not closed in the method eIPAD.chartsummary.banner.daoimpl.BannerDAOImpl.getBannerDetails");
					}
				}
				
				
				
			}
		}
		else
		{
			 oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oBannerRes.getErrorsList().add(oErrInfo);
		return oBannerRes;
		
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
