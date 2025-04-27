/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29412     Dinesh T    AMS CRF
08/10/2013		IN041927	Karthi L	Patients in the practitioner’s homepage under Emergency patients remain only up to 12 midnight
02/04/2015		IN048704		Nijitha S		HSA-CRF-175
-----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
-------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.util.*;

public class PatSearch implements java.io.Serializable
{
	ArrayList arrlist = new ArrayList ();
	HashSet patClassSet = new HashSet();
	public PatSearch(){}

	public synchronized String setLevelHeader(Connection con,String practId, String facilityId, HashMap qryStrHash, String search_type,String locale)
	{
		PreparedStatement stmt  = null ;
		//String isError = "";
		StringBuffer isError = new StringBuffer();
		StringBuffer sqlQuery	= new StringBuffer();
		StringBuffer sqlQuery_new	= new StringBuffer();
		String field1 = "";
		String field2 = "";
		String field3 = "";
		if(search_type.equals("ByLocation"))
		{
			field1 = "PATIENT_CLASS";
			field2 = "LOCN_CODE";
			field3 = "LOCN_SHORT_DESC";

			StringBuffer IPsqlQuery = new StringBuffer();
			StringBuffer OPsqlQuery = new StringBuffer();
			StringBuffer RPsqlQuery = new StringBuffer();
			String LoctionType="";
			int count_bound_vars = 0;
			try
			{

				
				LoctionType		= (String)qryStrHash.get("LoctionType");
				String LoctionCode 		= (String)qryStrHash.get("LoctionCode");
				String ViewList   			= (String)qryStrHash.get("ViewList");
				String adm_fromdate = (String)qryStrHash.get("adm_fromdate");
				String adm_todate		= (String)qryStrHash.get("adm_todate");
				String PatientId   			= (String)qryStrHash.get("PatientId");
				String QueueId   			= (String)qryStrHash.get("QueueId");
				String nationID				= (String)qryStrHash.get("nationID");
				String QueueStatus   	= (String)qryStrHash.get("QueueStatus");
				if (QueueStatus.equals("~~"))
				{
					QueueStatus = "";
				}
				QueueStatus=QueueStatus.replace('~','\'');
				String UnSheduled   	= (String)qryStrHash.get("UnSheduled");
				String PastVisit   			= (String)qryStrHash.get("PastVisit");
				String OPFromDate	   	= (String)qryStrHash.get("FromDate1");
				String OPToDate	   		= (String)qryStrHash.get("ToDate1");
				String Discharge			= (String)qryStrHash.get("Discharge");
				String IPFromDate		= (String)qryStrHash.get("FromDate2");
				String IPToDate			= (String)qryStrHash.get("ToDate2");
				String CheckedOut		= (String)qryStrHash.get("checked_out");
				String attend_practId		= (String)qryStrHash.get("attend_practId") == null ? "" : (String)qryStrHash.get("attend_practId");
				String speciality		= (String)qryStrHash.get("speciality") == null ? "" : (String)qryStrHash.get("speciality");
				String visitType		= (String)qryStrHash.get("visitType") == null ? "" : (String)qryStrHash.get("visitType");
				String bedNo = (String)qryStrHash.get("bedNo") == null ? "%" : (String)qryStrHash.get("bedNo")+"%";//IN29412
				String assign_confirm_referral_yn = (String)qryStrHash.get("assign_confirm_referral_yn") == null ? "" : (String)qryStrHash.get("assign_confirm_referral_yn");//IN048704
				String virtualConsultation_yn =(String)qryStrHash.get("virtualConsultation_yn") == null ? "N" : (String)qryStrHash.get("virtualConsultation_yn");

//				String relnreqyn		= (String)qryStrHash.get("relnreqyn") == null ? "" : (String)qryStrHash.get("relnreqyn");

				//Below Date Conversion done by Archana Dhal related to IN18707.
				OPFromDate = com.ehis.util.DateUtils.convertDate(OPFromDate,"DMY",locale,"en");
				OPToDate = com.ehis.util.DateUtils.convertDate(OPToDate,"DMY",locale,"en");
				IPFromDate = com.ehis.util.DateUtils.convertDate(IPFromDate,"DMY",locale,"en");
				IPToDate = com.ehis.util.DateUtils.convertDate(IPToDate,"DMY",locale,"en");

				if(arrlist.size()>0)
					arrlist.clear();
				if(patClassSet.size()>0)
					patClassSet.clear();

				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
				IPsqlQuery.append("select patient_class ,LOCN_CODE,IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1')  LOCN_SHORT_DESC from ca_pract_by_locn_detail o where facility_id=? and practitioner_id=? and Locn_type='W' ");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/


				if (LoctionType.equals("IP") || LoctionType.equals("DC"))
				{
					IPsqlQuery.append(" AND PATIENT_CLASS=? ");
					if (!LoctionCode.equals("*ALL"))
						IPsqlQuery.append(" AND LOCN_CODE=? ");

				}


				/****MODIFIED BY Deepa on 2/25/2010 at 1:29 PM for 19477******************/
				/**
					joined mp_patient table to filter the suspended patients in the patient list
				**/
				//IPsqlQuery.append(" AND EXISTS  ( SELECT 1 FROM PR_ENCOUNTER A where  A.ASSIGN_CARE_LOCN_CODE=O.LOCN_CODE  AND A.FACILITY_ID =O.FACILITY_ID AND A.PATIENT_CLASS =O.PATIENT_CLASS ");

				IPsqlQuery.append(" AND ( EXISTS (SELECT 1 FROM ip_open_encounter a, mp_patient mp_p WHERE NVL (mp_p.suspend_yn, '*') != 'Y'  AND mp_p.patient_id = a.patient_id AND a.NURSING_UNIT_CODE = o.locn_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class ");

				if(!attend_practId.equals(""))
				{
					IPsqlQuery.append(" and A.ATTEND_PRACTITIONER_ID = ? ");
				}
				if(!speciality.equals(""))
				{
					IPsqlQuery.append(" and A.SPECIALTY_CODE = ? ");
				}
				if (!nationID.equals(""))
					IPsqlQuery.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? ) ");

				if (ViewList.equals("S"))
					IPsqlQuery.append(" AND A.ATTEND_PRACTITIONER_ID=? ");
				if (!PatientId.equals(""))
				{
					IPsqlQuery.append(" AND A.PATIENT_ID=? ");
				}

				if (!QueueId.equals(""))
				{
					IPsqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
				}
				/*
					modified by Kishore kumar N, on 18-05-2010 for incident:-21494
				*/
				if (!adm_fromdate.equals(""))
				{
					IPsqlQuery.append(" AND A.ADMISSION_DATE_TIME  >= TO_DATE(?,'DD/MM/YYYY') ");
				}
				if (!adm_todate.equals(""))
				{
					IPsqlQuery.append(" AND A.ADMISSION_DATE_TIME  <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
				}
				/*
					ends here.
				*/

				IPsqlQuery.append(" AND A.ADT_STATUS IN ('01','02') ");

				IPsqlQuery.append("AND UPPER(BED_NUM) LIKE UPPER(?) ");//IN29412
				IPsqlQuery.append(" )");

				if (Discharge.equals("Y"))
				{
					IPsqlQuery.append(" OR EXISTS  ( SELECT 1 FROM PR_ENCOUNTER A, mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = A.patient_id and  A.ASSIGN_CARE_LOCN_CODE=O.LOCN_CODE  AND A.FACILITY_ID =O.FACILITY_ID AND A.PATIENT_CLASS =O.PATIENT_CLASS  AND A.ADT_STATUS ='08' ");

					if(!attend_practId.equals(""))
					{
						IPsqlQuery.append(" and A.ATTEND_PRACTITIONER_ID = ? ");
					}
					if(!speciality.equals(""))
					{
						IPsqlQuery.append(" and A.SPECIALTY_CODE = ? ");
					}
					if (!nationID.equals(""))
						IPsqlQuery.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? ) ");

					if (ViewList.equals("S"))
						IPsqlQuery.append(" AND A.ATTEND_PRACTITIONER_ID=? ");
					if (!PatientId.equals(""))
					{
						IPsqlQuery.append(" AND A.PATIENT_ID=? ");
					}
					if (!QueueId.equals(""))
					 {
						 IPsqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
					 }

					if (!adm_fromdate.equals(""))
					IPsqlQuery.append(" AND A.VISIT_ADM_DATE_TIME  >= TO_DATE(?,'DD/MM/YYYY') ");
					if (!adm_todate.equals(""))
					IPsqlQuery.append(" AND A.VISIT_ADM_DATE_TIME  <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");


					if (!IPFromDate.equals(""))
						IPsqlQuery.append(" AND  A.DISCHARGE_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");
					if (!IPToDate.equals(""))
						IPsqlQuery.append(" AND A.DISCHARGE_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
						IPsqlQuery.append(" )");

				}

				IPsqlQuery.append("  ) ");

				if(LoctionType.equals("Z"))
				{

					RPsqlQuery.append(" select 'RP' patient_class, RI.assign_care_locn_code locn_code,CASE WHEN RI.patient_class IN ('IP', 'DC')                       THEN ip_get_desc.ip_nursing_unit (RI.facility_id, RI.assign_care_locn_code, ?, '1' )  ELSE op_get_desc.op_clinic (RI.facility_id,  RI.assign_care_locn_code, ?, '1'   ) END locn_short_desc FROM (SELECT DISTINCT c.patient_class, c.assign_care_locn_code,c.facility_id FROM pr_referral_register a, pr_encounter c    WHERE c.facility_id = a.from_facility_id  AND c.encounter_id =     NVL (a.close_encounter_id, a.from_encounter_id)   AND a.to_facility_id = ? ");

				if(!PatientId.equals(""))
				{
				RPsqlQuery.append(" AND a.patient_id = ? " );
				}
				//IN048704 Starts
				//RPsqlQuery.append("   AND A.REFERRAL_DATE BETWEEN SYSDATE-7 AND SYSDATE+7  AND a.bedside_referral_yn = 'Y'   AND a.to_pract_id = ? ");
				RPsqlQuery.append("   AND A.REFERRAL_DATE BETWEEN SYSDATE-7 AND SYSDATE+7  AND a.bedside_referral_yn = 'Y'  ");
				if (assign_confirm_referral_yn.equals("Y"))
				{
					if(UnSheduled.equals("N"))
					{
						RPsqlQuery.append("AND a.to_pract_id = ?");
					}
					else if(UnSheduled.equals("Y"))
					{	
						RPsqlQuery.append("AND (a.to_pract_id = ?  OR TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? )) ");
					}
				}
				else
				{
					RPsqlQuery.append("AND a.to_pract_id = ? ");
				}
				//IN048704 Ends
				RPsqlQuery.append(" AND a.status in ('C','O') " );
				RPsqlQuery.append(" ) RI ");
				}


	//OutPatient Query
//					OPsqlQuery.append(" select patient_class , LOCN_CODE,OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1') LOCN_SHORT_DESC from ca_pract_by_locn_view o  where facility_id=? and practitioner_id=?  and Locn_type='C' ");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
					OPsqlQuery.append(" select patient_class , LOCN_CODE,OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1') LOCN_SHORT_DESC from ca_pract_by_locn_detail o  where facility_id=? and practitioner_id=?  and Locn_type='C' ");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
				if (LoctionType.equals("OP")||LoctionType.equals("EM"))
				{
					OPsqlQuery.append(" AND PATIENT_CLASS=? " );
					if (!LoctionCode.equals("*ALL"))
						OPsqlQuery.append(" AND LOCN_CODE=? ");
				}
				OPsqlQuery.append(" AND EXISTS  (	SELECT 1 FROM CA_OP_EPISODE_VW A  WHERE A.LOCN_CODE=O.LOCN_CODE  AND A.FACILITY_ID =O.FACILITY_ID  AND A.PATIENT_CLASS =O.PATIENT_CLASS ");
				if(!attend_practId.equals(""))
				{
					OPsqlQuery.append(" and A.PHYSICIAN_ID = ? ");
				}
				if(!speciality.equals(""))
				{
					OPsqlQuery.append(" and A.SPECIALTY_CODE = ? ");
				}
				if (LoctionType.equals("OP")){
					if(!visitType.equals(""))
					{
						OPsqlQuery.append(" and A.VIS_ADM_TYPE_CODE = ? ");
					}
				}
				if (!nationID.equals(""))
					OPsqlQuery.append("  and a.NATIONAL_ID_NO   =? ");
				if (ViewList.equals("S"))
					OPsqlQuery.append("  and a.PHYSICIAN_ID   =? ");

				if (!PatientId.equals(""))
				{
					OPsqlQuery.append(" AND A.PATIENT_ID=? ");
				}

				if (!QueueId.equals(""))
				 {
					 OPsqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
				 }
				OPsqlQuery.append(" AND A.QUEUE_STATUS >= NVL(DISP_IN_CA_QUEUE_AFTER, QUEUE_STATUS) ");
				if (QueueStatus.equals(""))
					OPsqlQuery.append(" AND A.QUEUE_STATUS IN (NULL)  ") ;
				else
					OPsqlQuery.append(" AND A.QUEUE_STATUS IN (" + QueueStatus + ")  " );
				if(!(UnSheduled.equals("Y")))
					OPsqlQuery.append(" AND A.ACTUAL_PHYSICIAN_ID != '*ALL'  ");
				else if(UnSheduled.equals("Y"))
					OPsqlQuery.append(" AND 'Y' = DECODE(NVL(A.ACTUAL_PHYSICIAN_ID, '*ALL'), '*ALL', CA_GET_UNASSIGN_LOCN_APPL(A.FACILITY_ID, A.UNASSIGN_PATIENT_YN,?, A.LOCN_TYPE, A.LOCN_CODE,A.PATIENT_CLASS),'Y')  ");

				if(CheckedOut.equals("Y"))
					//OPsqlQuery.append(" AND VISIT_EPISODE_STATUS IN ('00','01','02','03','04','05','06','07') ");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
					OPsqlQuery.append(" AND VISIT_EPISODE_STATUS IN ('00','01','02','03','04','05','06','07','09') ");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
				else
					OPsqlQuery.append(" AND VISIT_EPISODE_STATUS IN ('00','01','02','03','04','05','06') ");

				if (PastVisit.equals("N")||PastVisit.equals("")) {
					//OPsqlQuery.append("	AND ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE)+1 ") ;
					// added for IN041927 - Start 
					if (LoctionType.equals("EM")) {
						OPsqlQuery.append("	AND ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE-1) AND TRUNC(SYSDATE)+1 ") ; 
					}
					else {
						OPsqlQuery.append("	AND ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE)+1 ") ; 
					}
					// End
				}	
				else
				{
					if (!OPFromDate.equals(""))
						OPsqlQuery.append(" AND ADM_VISIT_DATE >= TO_DATE(?,'DD/MM/YYYY') ");
					else if (OPFromDate.equals("") && PatientId.equals(""))
						OPsqlQuery.append(" AND ADM_VISIT_DATE >= TRUNC(SYSDATE) ");
					if (!OPToDate.equals(""))
						OPsqlQuery.append( " AND ADM_VISIT_DATE <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
				}
				OPsqlQuery.append("  )  ");

				if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.toString() + " UNION ALL " + OPsqlQuery.toString()+ " UNION ALL " + RPsqlQuery.toString()+" ORDER BY 3 ");
				else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery.toString()+" ORDER BY 3 ");
				else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery.toString()+" ORDER BY 3 ");

				if( stmt != null) stmt.close();

				stmt = con.prepareStatement(sqlQuery.toString());
				

				if ( LoctionType.equals("IP")||LoctionType.equals("DC")||LoctionType.equals("Z")  )
				{
					//stmt.setString(++count_bound_vars, facilityId);
					//stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, practId);

					if (LoctionType.equals("IP") || LoctionType.equals("DC"))
					{
						stmt.setString(++count_bound_vars, LoctionType);
						if (!LoctionCode.equals("*ALL"))
						{
							stmt.setString(++count_bound_vars, LoctionCode);
						}
					}
					if(!attend_practId.equals(""))
					{
						stmt.setString(++count_bound_vars, attend_practId);
					}
					if(!speciality.equals(""))
					{
						stmt.setString(++count_bound_vars, speciality);
					}
					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
					}

					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}
					if (!QueueId.equals(""))
		    		 {
						stmt.setString(++count_bound_vars, QueueId);
					 }
					if (!adm_fromdate.equals(""))
					{
						
						stmt.setString(++count_bound_vars, adm_fromdate);
					}
					if (!adm_todate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_todate);
					}
					if(bedNo.equals(""))//IN29412
						bedNo= "%";//IN29412
					stmt.setString(++count_bound_vars, bedNo);//IN29412
					if (Discharge.equals("Y"))
					{

						if(!attend_practId.equals(""))
						{
							stmt.setString(++count_bound_vars, attend_practId);
						}
						if(!speciality.equals(""))
						{
							stmt.setString(++count_bound_vars, speciality);
						}
						if (!nationID.equals(""))
						{
							stmt.setString(++count_bound_vars, nationID);
						}

						if (ViewList.equals("S"))
						{
							stmt.setString(++count_bound_vars, practId);
						}
						if (!PatientId.equals(""))
						{
							stmt.setString(++count_bound_vars, PatientId);
						}
						if (!QueueId.equals(""))
						 {
							stmt.setString(++count_bound_vars, QueueId);
						 }
						if (!adm_fromdate.equals(""))
						{
							
							stmt.setString(++count_bound_vars, adm_fromdate);
						}
						if (!adm_todate.equals(""))
						{
							stmt.setString(++count_bound_vars, adm_todate);
						}
						if (!IPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPFromDate);
						}
						if (!IPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPToDate);
						}
					}


				}
				//OutPatient Query

				if ( LoctionType.equals("OP")||LoctionType.equals("EM")||LoctionType.equals("Z"))
				{

					//stmt.setString(++count_bound_vars, facilityId);
					//stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, practId);

					if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					{
						stmt.setString(++count_bound_vars, LoctionType);
						if (!LoctionCode.equals("*ALL"))
						{
							stmt.setString(++count_bound_vars, LoctionCode);
						}
					}
					if(!attend_practId.equals(""))
					{
						stmt.setString(++count_bound_vars, attend_practId);
					}
					if(!speciality.equals(""))
					{
						stmt.setString(++count_bound_vars, speciality);
					}
					if ( LoctionType.equals("OP")){
						if(!visitType.equals(""))
						{
							stmt.setString(++count_bound_vars, visitType);
						}
					}
					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
					}
					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}
					if (!QueueId.equals(""))
	  			    {
						stmt.setString(++count_bound_vars, QueueId);
					}

					if(UnSheduled.equals("Y"))
						stmt.setString(++count_bound_vars, practId);

					if (PastVisit.equals("Y"))
					{
						if (!OPFromDate.equals(""))
							stmt.setString(++count_bound_vars, OPFromDate);
						if (!OPToDate.equals(""))
							stmt.setString(++count_bound_vars, OPToDate);

					}
				}
				if(LoctionType.equals("Z"))
					{

							stmt.setString(++count_bound_vars, locale);
							stmt.setString(++count_bound_vars, locale);
							stmt.setString(++count_bound_vars, facilityId);
							if(!PatientId.equals(""))
							{
							 stmt.setString(++count_bound_vars, PatientId);
							}
							//IN048704
							//stmt.setString(++count_bound_vars, practId);
							if (assign_confirm_referral_yn.equals("Y"))
							{
								if(UnSheduled.equals("N"))
								{
									stmt.setString(++count_bound_vars, practId);
								}
								else if(UnSheduled.equals("Y"))
								{
									stmt.setString(++count_bound_vars, practId);
									stmt.setString(++count_bound_vars, practId);
									stmt.setString(++count_bound_vars, facilityId);
									stmt.setString(++count_bound_vars, practId);
								}
							}
							else
							{
								stmt.setString(++count_bound_vars, practId);
							}
							//IN048704	
					}
			}
			catch( Exception e )
			{
				isError.append(e.toString() +"<br>"+ sqlQuery.toString());
				e.printStackTrace();
			}
		}
		else if(search_type.equals("ByPPRelation"))
		{
			field1 = "PATIENT_CLASS";
			field2 = "PRACT_RELN_ID";
			field3 = "PRACT_RELN_NAME";


			int count_bound_vars = 0;
			String patient_class ="";
			try
			{
				String LoctionType  	= (String)qryStrHash.get("LoctionType");
				String RelationshipCode	= (String)qryStrHash.get("RelationshipCode");
				String PatientId   		= (String)qryStrHash.get("PatientId");
				String QueueId   		= (String)qryStrHash.get("QueueId");
				String FromDate	    	= (String)qryStrHash.get("FromDate");
				String ToDate		    = (String)qryStrHash.get("ToDate");
				String checkedOut		= (String)qryStrHash.get("checkedOut");
				String discharged		= (String)qryStrHash.get("discharged");
				String nonencspec		= (String)qryStrHash.get("nonencspec");
				String attend_practId		= (String)qryStrHash.get("attend_practId") == null ? "" : (String)qryStrHash.get("attend_practId");
				String speciality		= (String)qryStrHash.get("speciality") == null ? "" : (String)qryStrHash.get("speciality");
				String visitType		= (String)qryStrHash.get("visitType") == null ? "" : (String)qryStrHash.get("visitType");

				FromDate = com.ehis.util.DateUtils.convertDate(FromDate,"DMY",locale,"en");
				ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

				if(arrlist.size()>0)
					arrlist.clear();
				if(patClassSet.size()>0)
					patClassSet.clear();

				if(LoctionType.equals("Z")	)
				{
					patient_class ="";
				}
				else
					patient_class = LoctionType;


				// reln new query

				sqlQuery_new.append(" SELECT b.patient_class, O.pract_reln_id,  O.pract_reln_name FROM ca_pract_reln_lang_vw o, am_patient_class b WHERE  o.language_id= ? ");

				if (!patient_class.equals(""))
				{
					sqlQuery_new.append(" and patient_class = ? ");
				}

				if (!RelationshipCode.equals("ALL"))
				{
					sqlQuery_new.append(" AND  PRACT_RELN_ID=? ");
				}

				// sqlQuery_new.append("  AND EXISTS (SELECT 1 FROM  ca_encntr_pract_reln i WHERE FACILITY_ID = ? AND PRACTITIONER_ID= ? AND PATIENT_CLASS=B.PATIENT_CLASS AND PRACT_RELN_ID=O.PRACT_RELN_ID AND STATUS ='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE  ");

				/*In below query 'AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7' is commented by Archana on 6/4/2010  for IN021572*/

				sqlQuery_new.append("  AND EXISTS (SELECT 1 FROM  ca_encntr_pract_reln i WHERE FACILITY_ID = ? AND PRACTITIONER_ID= ? AND PATIENT_CLASS=B.PATIENT_CLASS AND PRACT_RELN_ID=O.PRACT_RELN_ID AND STATUS ='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7 */ ");

				if(!LoctionType.equals("")&& !LoctionType.equals("Z"))
				{
					if(LoctionType.equals("XT"))
					{
						if(nonencspec.equals("N"))
						{
							sqlQuery_new.append("and a.ENCOUNTER_ID is not null ");
						}
					}
					else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					{

						if(checkedOut.equals("N"))
						{
							sqlQuery_new.append("and exists (select 1 from pr_encounter a , mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and facility_id=i.facility_id and encounter_id=i.encounter_id AND visit_status between '00' and '06'  ");
							if (LoctionType.equals("OP")){
								if(!visitType.equals(""))
								{
									sqlQuery_new.append(" and VISIT_ADM_TYPE = ?");
								}
							}

							sqlQuery_new.append(" ) ");
						}
						else

						{
							//sqlQuery_new.append("and exists (select 1 from pr_encounter where facility_id=i.facility_id and encounter_id=i.encounter_id AND visit_status between  '00' and '07' )");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
							sqlQuery_new.append("and exists (select 1 from pr_encounter a , mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and facility_id=i.facility_id and encounter_id=i.encounter_id AND visit_status between  '00' and '09' ");
							if (LoctionType.equals("OP")){
								if(!visitType.equals(""))
								{
									sqlQuery_new.append(" and VISIT_ADM_TYPE = ?");
								}
							}

							sqlQuery_new.append(" ) ");
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
						}

					}
					else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					{
						if(discharged.equals("N"))
						{
							sqlQuery_new.append("and exists (select 1 from pr_encounter a , mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and facility_id=i.facility_id and encounter_id=i.encounter_id AND adt_status between '01' and '02' )");
						}
						else
						{
							sqlQuery_new.append(" and exists (select 1 from pr_encounter a , mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and facility_id=i.facility_id and encounter_id=i.encounter_id AND adt_status between  '01' and '08' )");
						}
					}



				}
				else
				{
//						sqlQuery_new.append(" and ((patient_class in ('OP','EM') and  exists (select 1 from pr_encounter where facility_id=i.facility_id and encounter_id=i.encounter_id AND visit_status between '00' and DECODE (?,'N','06','07' ))) or (patient_class in ('IP','DC') and exists (select 1 from pr_encounter where facility_id=i.facility_id and encounter_id=i.encounter_id AND adt_status between  '01' and DECODE(?,'N','02','08') ) ))");
			/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
			      /*Commented by Archana on 2/18/2010 at 4:01 PM for IN019460*/
						//sqlQuery_new.append(" and ((patient_class in ('OP','EM') and  exists (select 1 from pr_encounter where facility_id=i.facility_id and encounter_id=i.encounter_id AND visit_status between '00' and '09')) or (patient_class in ('IP','DC') and exists (select 1 from pr_encounter where facility_id=i.facility_id and encounter_id=i.encounter_id AND adt_status between  '01' and DECODE(?,'N','02','08') ) ))");


		            /*Modified by Archana on 2/18/2010 at 4:01 PM for IN019460*/

						sqlQuery_new.append(" and ((patient_class in ('OP','EM') and  exists (select 1 from pr_encounter a , mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and facility_id=i.facility_id and encounter_id=i.encounter_id AND visit_status between '00' and DECODE (?,'N','06','09' ))) or (patient_class in ('IP','DC') and exists (select 1 from pr_encounter a , mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and facility_id=i.facility_id and encounter_id=i.encounter_id AND adt_status between  '01' and DECODE(?,'N','02','08') ) ))");


				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
				}


				if(!PatientId.equals(""))
					sqlQuery_new.append(" AND PATIENT_ID=? ");
				if(!QueueId.equals(""))
					sqlQuery_new.append(" aND PATIENT_ID=(SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO=?)");

				if(!speciality.equals("") || !attend_practId.equals(""))
				{
					sqlQuery_new.append(" and  exists (select 1 from pr_encounter where FACILITY_ID  = i.facility_id and ENCOUNTER_ID =  I.encounter_id and  ATTEND_PRACTITIONER_ID=nvl(?,ATTEND_PRACTITIONER_ID)   and SPECIALTY_CODE=nvl(?,SPECIALTY_CODE ) )");
				}
               /*added by Archana on 2/18/2010 at 4:01 PM for IN019460*/
		         /*
			        added the FromDate and ToDate condition in the query.

		         */

				if(!FromDate.equals("")&&(!ToDate.equals("")))
	             {
		            sqlQuery_new.append( "and ((TO_DATE(?,'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and nvl(END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))) or (TO_DATE(?,'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and nvl(END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))) or (trunc(BEGIN_DATE_TIME) between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY')))");

	             }
				 /*Below null condition check for from and to date is commented by Archana on 6/4/2010  for IN021572 as now it is made mandatory in criteria page*/
				/*else if(!FromDate.equals("") && (ToDate.equals("")))
	             {
		             sqlQuery_new.append(" and ( BEGIN_DATE_TIME >= to_date( ?, 'DD/MM/YYYY' ) or TO_DATE(?,'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and nvl(END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))  )");
	             }
	            else if(FromDate.equals("") && !ToDate.equals(""))
	             {
		            sqlQuery_new.append(" and ( nvl(END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))<= to_date( ?,'DD/MM/YYYY' ) OR to_date( ?,'DD/MM/YYYY' ) BETWEEN TRUNC(BEGIN_DATE_TIME)  AND nvl(END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy')))  ");
	             }*/

				sqlQuery_new.append(" )");
				stmt = con.prepareStatement (sqlQuery_new.toString())  ;

					stmt.setString( ++count_bound_vars, locale);

					if (!patient_class.equals(""))
				    {
						stmt.setString( ++count_bound_vars, patient_class);

				    }
					if (!RelationshipCode.equals("ALL"))
				    {
						stmt.setString( ++count_bound_vars, RelationshipCode);
				    }

					stmt.setString( ++count_bound_vars, facilityId);
					stmt.setString( ++count_bound_vars, practId);


					if(!LoctionType.equals("")&& !LoctionType.equals("Z"))
					{
						if (LoctionType.equals("OP"))
						{
							if(!visitType.equals(""))
							{
								stmt.setString( ++count_bound_vars, visitType);
							}

						}

					}

					if(!(!LoctionType.equals("")&& !LoctionType.equals("Z")))
					{
							stmt.setString( ++count_bound_vars, checkedOut);
							stmt.setString( ++count_bound_vars, discharged);
					}

					if(!PatientId.equals(""))
				    {
						stmt.setString( ++count_bound_vars, PatientId);
				   }

					if(!QueueId.equals(""))
				   {
						stmt.setString( ++count_bound_vars, QueueId);
				   }

					if(!speciality.equals("") || !attend_practId.equals(""))
					{
						stmt.setString( ++count_bound_vars, attend_practId);
						stmt.setString( ++count_bound_vars, speciality);
					}
					/*added by Archana on 2/18/2010 at 4:01 PM for IN019460*/
		         /*
			        added the FromDate and ToDate condition in the query.

		         */

					if(!FromDate.equals("")&&(!ToDate.equals("")))
	                {
			            stmt.setString(++count_bound_vars,FromDate);
			            stmt.setString(++count_bound_vars,ToDate);
			            stmt.setString(++count_bound_vars,FromDate);
			            stmt.setString(++count_bound_vars,ToDate);

	                }
				 /*Below null condition check for from and to date is commented by Archana on 6/4/2010  for IN021572 as now it is made mandatory in criteria page*/

				  /*else if(!FromDate.equals("") && (ToDate.equals("")))
	               {
			           stmt.setString(++count_bound_vars,FromDate);
			           stmt.setString(++count_bound_vars,FromDate);
	               }
                  else if(FromDate.equals("") && (!ToDate.equals("")))
	              {
		               stmt.setString(++count_bound_vars,ToDate);
		               stmt.setString(++count_bound_vars,ToDate);
		          }*/

			}
			catch( Exception e )
			{
				
				isError.append(e.toString() +"<br>"+ sqlQuery.toString());
				e.printStackTrace();
			}

		}
		else if(search_type.equals("ByService"))
		{
			field1 = "PATIENT_CLASS";
			field2 = "SERVICE_CODE";
			field3 = "SHORT_DESC";

			//StringBuffer IPsqlQuery	= new StringBuffer();
			//StringBuffer OPsqlQuery	= new StringBuffer();

			String patient_class ="";
			int count_bound_vars = 0;

			try
			{
				String LoctionType		  = (String)qryStrHash.get("LoctionType");
				String LoctionCode		  = (String)qryStrHash.get("LoctionCode");
				String ViewList				  = (String)qryStrHash.get("ViewList");
				String nationID				  = (String)qryStrHash.get("nationID");
				String adm_fromdate	  = (String)qryStrHash.get("adm_fromdate");
				String adm_todate		  = (String)qryStrHash.get("adm_todate");
				String PatientId				  = (String)qryStrHash.get("PatientId");
				String QueueId			      = (String)qryStrHash.get("QueueId");
				String QueueStatus		  = (String)qryStrHash.get("QueueStatus");
				if (QueueStatus.equals("~~"))
					QueueStatus = "";
				QueueStatus=QueueStatus.replace('~','\'');
				String UnSheduled		  = (String)qryStrHash.get("UnSheduled");
				String PastVisit		  = (String)qryStrHash.get("PastVisit");
				String OPFromDate		  = (String)qryStrHash.get("FromDate1");
				String OPToDate	   		= (String)qryStrHash.get("ToDate1");
				String Discharge		  = (String)qryStrHash.get("Discharge");
				String IPFromDate		  = (String)qryStrHash.get("FromDate2");
				String IPToDate	   		= (String)qryStrHash.get("ToDate2");
				String CheckedOut		  = (String)qryStrHash.get("checked_out");
				String attend_practId		= (String)qryStrHash.get("attend_practId") == null ? "" : (String)qryStrHash.get("attend_practId");
				String speciality		= (String)qryStrHash.get("speciality") == null ? "" : (String)qryStrHash.get("speciality");
				String visitType		= (String)qryStrHash.get("visitType") == null ? "" : (String)qryStrHash.get("visitType");
				//Below Date Conversion done by Archana Dhal related to IN18714.
				OPFromDate = com.ehis.util.DateUtils.convertDate(OPFromDate,"DMY",locale,"en");
				OPToDate = com.ehis.util.DateUtils.convertDate(OPToDate,"DMY",locale,"en");
				IPFromDate = com.ehis.util.DateUtils.convertDate(IPFromDate,"DMY",locale,"en");
				IPToDate = com.ehis.util.DateUtils.convertDate(IPToDate,"DMY",locale,"en");

				if(arrlist.size()>0)
					arrlist.clear();
				if(patClassSet.size()>0)
					patClassSet.clear();


				//IP SQL Query
			 //new query for tuning

				if(LoctionType.equals("Z")	)
				{
					patient_class ="";
				}
				else
					patient_class = LoctionType;


				sqlQuery_new.append("SELECT distinct patient_class, service_code, am_get_desc.am_service (o.service_code, ?, '2') short_desc FROM ca_pract_by_splty_locn_view o WHERE facility_id = ? AND practitioner_id = ? and patient_class = nvl(?,patient_class) AND ( ");

				if (LoctionType.equals("IP") || LoctionType.equals("DC")||LoctionType.equals("Z"))
				{
					/**** MODIFIED BY Jyothi on 09/03/2010 for 19477 ******************/
					/**	joined mp_patient table to filter the suspended patients in the patient list **/

					//sqlQuery_new.append("( PATIENT_CLASS IN ('IP','DC') AND EXISTS ( SELECT 1 FROM pr_encounter a WHERE a.service_code = o.service_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class ");

					sqlQuery_new.append("( PATIENT_CLASS IN ('IP','DC') ");

					sqlQuery_new.append(" AND ( EXISTS ( SELECT 1 FROM ip_open_encounter a, mp_patient mp_p WHERE NVL (mp_p.suspend_yn, '*') != 'Y' and mp_p.patient_id = a.patient_id and a.service_code = o.service_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class ");

					if(!attend_practId.equals(""))
					{
						sqlQuery_new.append(" and A.ATTEND_PRACTITIONER_ID = ? ");
					}
					if(!speciality.equals(""))
					{
						sqlQuery_new.append(" and A.SPECIALTY_CODE = ? ");
					}

					if (!nationID.equals(""))
						sqlQuery_new.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? )");

					if (ViewList.equals("S"))
						sqlQuery_new.append(" AND A.ATTEND_PRACTITIONER_ID=? ");

					if (!PatientId.equals(""))
					{
						sqlQuery_new.append(" AND A.PATIENT_ID=? ");
					}

					 if (!QueueId.equals(""))
					 {
						 sqlQuery_new.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
					 }

					if (!adm_fromdate.equals(""))
						sqlQuery_new.append(" AND A.ADMISSION_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");

					if (!adm_todate.equals(""))
						sqlQuery_new.append(" AND A.ADMISSION_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");

					if (!Discharge.equals("Y"))
						sqlQuery_new.append(" AND  ADT_STATUS  IN ('01','07','09')");

					sqlQuery_new.append(" )");

					if (Discharge.equals("Y"))
					{
						sqlQuery_new.append(" OR EXISTS ( SELECT 1 FROM pr_encounter a, mp_patient mp_p  WHERE nvl(mp_p.suspend_yn,'*') != 'Y' and mp_p.patient_id = a.patient_id and a.service_code = o.service_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class ");
						sqlQuery_new.append(" AND ( ADT_STATUS  IN ('01','07','08') )  ");

					if(!attend_practId.equals(""))
					{
						sqlQuery_new.append(" and A.ATTEND_PRACTITIONER_ID = ? ");
					}
					if(!speciality.equals(""))
					{
						sqlQuery_new.append(" and A.SPECIALTY_CODE = ? ");
					}

					if (!nationID.equals(""))
						sqlQuery_new.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? )");

					if (ViewList.equals("S"))
						sqlQuery_new.append(" AND A.ATTEND_PRACTITIONER_ID=? ");

					if (!PatientId.equals(""))
					{
						sqlQuery_new.append(" AND A.PATIENT_ID=? ");
					}

					 if (!QueueId.equals(""))
					 {
						 sqlQuery_new.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
					 }

					if (!adm_fromdate.equals(""))
						sqlQuery_new.append(" AND A.VISIT_ADM_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");

					if (!adm_todate.equals(""))
						sqlQuery_new.append(" AND A.VISIT_ADM_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");

						if (!IPFromDate.equals(""))
							sqlQuery_new.append(" AND  NVL(DISCHARGE_DATE_TIME,TO_DATE(?,'DD/MM/YYYY')) >= TO_DATE(?,'DD/MM/YYYY') ");
						if (!IPToDate.equals(""))
							sqlQuery_new.append(" AND NVL(DISCHARGE_DATE_TIME,TO_DATE(?,'DD/MM/YYYY')) <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");

							sqlQuery_new.append("  ) ");


					}

					//else
						//sqlQuery_new.append(" AND  ADT_STATUS  IN ('01','07') 	 ") ;
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
						//sqlQuery_new.append(" AND  ADT_STATUS  IN ('01','07','09') 	 ") ;
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/

					sqlQuery_new.append(" )  )");



				}


				if(LoctionType.equals("Z"))
				{
					sqlQuery_new.append(" OR ");
				}

				if(LoctionType.equals("OP")||LoctionType.equals("EM")|| LoctionType.equals("Z"))
				{

					sqlQuery_new.append("(PATIENT_CLASS IN ('OP','EM') AND  EXISTS ( SELECT 1 FROM ca_op_episode_vw a WHERE a.service_code = o.service_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class " );

					if(!attend_practId.equals(""))
					{
						sqlQuery_new.append(" and A.PHYSICIAN_ID = ? ");
					}
					if(!speciality.equals(""))
					{
						sqlQuery_new.append(" and A.SPECIALTY_CODE = ? ");
					}
					if(LoctionType.equals("OP"))
					{
						if(!visitType.equals(""))
						{
							sqlQuery_new.append(" and A.VIS_ADM_TYPE_CODE = ? ");
						}
					}

					if (!nationID.equals(""))
						sqlQuery_new.append("  AND A.NATIONAL_ID_NO   =? ");

					if (ViewList.equals("S"))
						sqlQuery_new.append("  AND A.PHYSICIAN_ID   =? ");
					if (!PatientId.equals(""))
					{
						sqlQuery_new.append(" AND A.PATIENT_ID = ? ");
					}

					if (!QueueId.equals(""))
					{
						sqlQuery_new.append(" AND A.ALT_ID1_NO = ? ");
					}

					if (QueueStatus.equals(""))
						sqlQuery_new.append(" AND A.QUEUE_STATUS IN ( NULL )  " );
					else
						sqlQuery_new.append(" AND A.QUEUE_STATUS IN (" + QueueStatus + ")  ") ;


					if(!(UnSheduled.equals("Y")))
						sqlQuery_new.append(" and a.ACTUAL_PHYSICIAN_ID != '*ALL'  ");
					else
						sqlQuery_new.append(" AND 'Y' = DECODE(A.ACTUAL_PHYSICIAN_ID, '*ALL', CA_GET_UNASSIGN_LOCN_APPL(A.FACILITY_ID, A.UNASSIGN_PATIENT_YN, ?, A.LOCN_TYPE, A.LOCN_CODE, A.PATIENT_CLASS),'Y')  ");

					if(CheckedOut.equals("Y"))
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
						//sqlQuery_new.append(" AND A.VISIT_EPISODE_STATUS BETWEEN '00' AND '07' " );
						sqlQuery_new.append(" AND A.VISIT_EPISODE_STATUS BETWEEN '00' AND '09' " );
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
					else
						sqlQuery_new.append(" AND  A.VISIT_EPISODE_STATUS BETWEEN '00' AND '06' " );

					if (PastVisit.equals("N")||PastVisit.equals(""))
						sqlQuery_new.append("	AND A.ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE)+1 " );
					else
					{
						if (!OPFromDate.equals(""))
							sqlQuery_new.append( " AND ADM_VISIT_DATE >= TO_DATE(?,'DD/MM/YYYY') ");
						if (!OPToDate.equals(""))
							sqlQuery_new.append(" AND ADM_VISIT_DATE <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
					}

					sqlQuery_new.append(" )) ");

				}
				sqlQuery_new.append(" ) ");

				if (!LoctionCode.equals("ALL"))
				{
					sqlQuery_new.append(" AND O.SERVICE_CODE=? ");
				}
				 sqlQuery_new.append(" ORDER BY 3 ");


				if(stmt != null) stmt.close();

				stmt = con.prepareStatement (sqlQuery_new.toString())  ;






					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, practId);

					stmt.setString(++count_bound_vars, patient_class);

					if ( (LoctionType.equals("IP")||LoctionType.equals("DC")||(LoctionType.equals("Z"))))
					{

					if(!attend_practId.equals(""))
					{
						stmt.setString(++count_bound_vars, attend_practId);
					}
					if(!speciality.equals(""))
					{
						stmt.setString(++count_bound_vars, speciality);
					}

					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
					}


					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					 if (!QueueId.equals(""))
					{
						stmt.setString(++count_bound_vars, QueueId);
					}


					if (!adm_fromdate.equals(""))
					{
						
						stmt.setString(++count_bound_vars, adm_fromdate);
					}

					if (!adm_todate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_todate);
					}

					if (Discharge.equals("Y"))
					{

						if(!attend_practId.equals(""))
					{
						stmt.setString(++count_bound_vars, attend_practId);
					}
					if(!speciality.equals(""))
					{
						stmt.setString(++count_bound_vars, speciality);
					}

					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
					}


					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					 if (!QueueId.equals(""))
					{
						stmt.setString(++count_bound_vars, QueueId);
					}


					if (!adm_fromdate.equals(""))
					{
						
						stmt.setString(++count_bound_vars, adm_fromdate);
					}

					if (!adm_todate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_todate);
					}

						if (!IPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPFromDate);
							stmt.setString(++count_bound_vars, IPFromDate);
						}
						if (!IPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPToDate);
							stmt.setString(++count_bound_vars, IPToDate);
						}
					}
				}

				if ( LoctionType.equals("OP")||LoctionType.equals("EM")|| LoctionType.equals("Z"))
				{

					if(!attend_practId.equals(""))
					{
						stmt.setString(++count_bound_vars, attend_practId);
					}
					if(!speciality.equals(""))
					{
						stmt.setString(++count_bound_vars, speciality);
					}
					if ( LoctionType.equals("OP")){
						if(!visitType.equals(""))
						{
							stmt.setString(++count_bound_vars, visitType);

						}
					}

					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
					}

					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					if (!QueueId.equals(""))
					{
						stmt.setString(++count_bound_vars, QueueId);
					}


					if(UnSheduled.equals("Y"))
					{
						stmt.setString(++count_bound_vars, practId);
					}

					if (PastVisit.equals("Y"))
					{
						if (!OPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, OPFromDate);
						}
						if (!OPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, OPToDate);
						}
					}

				}
				if (!LoctionCode.equals("ALL"))
					{
							stmt.setString(++count_bound_vars, LoctionCode);
					}

			}
			catch( Exception e )
			{
				
				isError.append(e.toString() +"<br>"+ sqlQuery.toString());
				e.printStackTrace();
			}
		}
		else if(search_type.equals("ReferralList"))
		{
			field1 = "PATIENT_CLASS";
			field2 = "LOCN_CODE";
			field3 = "LOCN_SHORT_DESC";

			int count_bound_vars = 0;

			try
			{
				String LoctionType		= (String)qryStrHash.get("LoctionType");
				//String LoctionCode 		= (String)qryStrHash.get("LoctionCode");
				String FromDate			= (String)qryStrHash.get("FromDate");
				String ToDate			= (String)qryStrHash.get("ToDate");
				String PatientId   		= (String)qryStrHash.get("PatientId");
				//String GroByEpisode		= (String)qryStrHash.get("GroByEpisode");
				//String GrpByLocn		= (String)qryStrHash.get("GrpByLocn");
				String unAssigned   	= (String)qryStrHash.get("unAssigned");
				String pendingRef   	= (String)qryStrHash.get("pendingRef");
				//IN064836 start
				/*String closed	   		= (String)qryStrHash.get("closed");
				String open	   			= (String)qryStrHash.get("open");*/
				String refStatus		= (String)qryStrHash.get("refStatus");
				String refRegSiteYN		= (String)qryStrHash.get("refRegSiteYN");
				//IN064836 ends
				//Below Date Conversion done by Archana Dhal related to IN18772.
				FromDate = com.ehis.util.DateUtils.convertDate(FromDate,"DMY",locale,"en");
				ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

				StringBuffer IPsqlQuery = new StringBuffer();
				StringBuffer OPsqlQuery = new StringBuffer();

				if(arrlist.size()>0)
					arrlist.clear();
				if(patClassSet.size()>0)
					patClassSet.clear();

				OPsqlQuery.append("SELECT A.CLINIC_CODE LOCN_CODE, A.SHORT_DESC LOCN_SHORT_DESC, DECODE(A.LEVEL_OF_CARE_IND,'A','OP','E','EM') PATIENT_CLASS FROM  OP_CLINIC_LANG_VW A WHERE A.EFF_STATUS='E' ");

				if(LoctionType.equals("OP") || LoctionType.equals("EM"))
					OPsqlQuery.append(" AND DECODE(A.LEVEL_OF_CARE_IND,'A','OP','E','EM')  = ? ");

				OPsqlQuery.append(" AND A.FACILITY_ID = ? AND A.LANGUAGE_ID = ? AND ");

				if (unAssigned.equals("Self") || unAssigned.equals("Both") )
				{
				OPsqlQuery.append(" 	EXISTS(SELECT 1 FROM  PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?, 'dd/mm/yyyy')  AND TO_DATE(?, 'dd/mm/yyyy') +.9999  AND   NVL(to_pract_id,'*') = ? ");
				if(!PatientId.equals(""))
				OPsqlQuery.append(" AND PATIENT_ID = ? ");
				//IN064836 start
				/*if(closed.equals("Y") && open.equals("Y"))
					OPsqlQuery.append(" AND STATUS IN ('C','O') ");
				else if(closed.equals("Y"))
					OPsqlQuery.append(" AND STATUS IN ('C') ");
				else if(open.equals("Y"))
					OPsqlQuery.append(" AND STATUS IN ('O') ");*/
				if("Y".equals(refRegSiteYN))
				{
					if("O".equals(refStatus))
						OPsqlQuery.append(" AND STATUS = 'O' ");
					else if("C".equals(refStatus))
						OPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'C' ");
					else if("N".equals(refStatus))
						OPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'N' ");
					/*else if("P".equals(refStatus))
						OPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'P' ");*/
					else if("S".equals(refStatus))
						OPsqlQuery.append(" AND STATUS = 'C' AND BEDSIDE_REF_REVIEW_STATUS = 'S' ");
					else if("X".equals(refStatus))
						OPsqlQuery.append(" AND STATUS = 'X' AND BEDSIDE_REF_REVIEW_STATUS = 'X' ");
				}
				else
				{
					if("A".equals(refStatus))
						OPsqlQuery.append(" AND STATUS IN ('C','O') ");
					else if("Z".equals(refStatus))
						OPsqlQuery.append(" AND STATUS IN ('C') ");
					else if("O".equals(refStatus))
						OPsqlQuery.append(" AND STATUS IN ('O') ");
				}
				//IN064836 ends

				OPsqlQuery.append(" AND ( ( FROM_LOCN_CODE = A.CLINIC_CODE AND FROM_LOCN_TYPE =A.CLINIC_TYPE) ");

				if(pendingRef.equals("N"))
					OPsqlQuery.append(" OR ( NVL2(CLOSE_ENCOUNTER_ID,1,0) = 1 AND TO_LOCN_CODE = A.CLINIC_CODE AND TO_LOCN_TYPE =A.CLINIC_TYPE )");

				OPsqlQuery.append("  ) ) ");


				}
				if ( unAssigned.equals("Both") )
				{
				OPsqlQuery.append("  OR ");
				}
				if (unAssigned.equals("Unassigned") || unAssigned.equals("Both") )
				{


				OPsqlQuery.append("	EXISTS(SELECT 1 FROM  PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?, 'dd/mm/yyyy')  AND TO_DATE(?, 'dd/mm/yyyy') +.9999 ");

				OPsqlQuery.append(" AND  TO_PRACT_ID = ? ");

				if(!PatientId.equals(""))
					OPsqlQuery.append(" AND PATIENT_ID = ? ");


				//IN064836 start
				/*if(closed.equals("Y") && open.equals("Y"))
					OPsqlQuery.append(" AND STATUS IN ('C','O') ");
				else if(closed.equals("Y"))
					OPsqlQuery.append(" AND STATUS IN ('C') ");
				else if(open.equals("Y"))
					OPsqlQuery.append(" AND STATUS IN ('O') ");*/
				if("Y".equals(refRegSiteYN))
				{
					if("O".equals(refStatus))
						OPsqlQuery.append(" AND STATUS = 'O' ");
					else if("C".equals(refStatus))
						OPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'C' ");
					else if("N".equals(refStatus))
						OPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'N' ");
					/*else if("P".equals(refStatus))
						OPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'P' ");*/
					else if("S".equals(refStatus))
						OPsqlQuery.append(" AND STATUS = 'C' AND BEDSIDE_REF_REVIEW_STATUS = 'S' ");
					else if("X".equals(refStatus))
						OPsqlQuery.append(" AND STATUS = 'X' AND BEDSIDE_REF_REVIEW_STATUS = 'X' ");
				}
				else
				{
					if("A".equals(refStatus))
						OPsqlQuery.append(" AND STATUS IN ('C','O') ");
					else if("Z".equals(refStatus))
						OPsqlQuery.append(" AND STATUS IN ('C') ");
					else if("O".equals(refStatus))
						OPsqlQuery.append(" AND STATUS IN ('O') ");
				}
				//IN064836 ends

				OPsqlQuery.append(" AND FROM_LOCN_CODE = A.CLINIC_CODE AND FROM_LOCN_TYPE =A.CLINIC_TYPE AND TO_SPECIALITY_CODE in (SELECT PRIMARY_SPECIALITY_CODE from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? ) )");
				}
				IPsqlQuery.append("SELECT A.NURSING_UNIT_CODE LOCN_CODE, a.long_desc LOCN_SHORT_DESC, A.PATIENT_CLASS PATIENT_CLASS FROM IP_NURSING_UNIT_LANG_VW A WHERE A.EFF_STATUS='E' ");

				if(LoctionType.equals("IP") || LoctionType.equals("DC"))
					IPsqlQuery.append(" AND A.PATIENT_CLASS = ? ");

				IPsqlQuery.append(" AND A.FACILITY_ID = ? AND A.LANGUAGE_ID = ? AND ");


				if (unAssigned.equals("Self") || unAssigned.equals("Both") )
				{

					IPsqlQuery.append(" EXISTS( SELECT 1 FROM  PR_REFERRAL_REGISTER 	WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?, 'dd/mm/yyyy')  AND TO_DATE(?, 'dd/mm/yyyy') +.9999 ");

					if(!PatientId.equals(""))
					IPsqlQuery.append(" AND PATIENT_ID = ? ");
					IPsqlQuery.append(" AND TO_PRACT_ID = ? ");
					
					//IN064836 start
					/*if(closed.equals("Y") && open.equals("Y"))
					IPsqlQuery.append(" AND STATUS IN ('C','O') ");
					else if(closed.equals("Y"))
						IPsqlQuery.append(" AND STATUS IN ('C') ");
					else if(open.equals("Y"))
						IPsqlQuery.append(" AND STATUS IN ('O') ");*/
					if("Y".equals(refRegSiteYN))
					{
						if("O".equals(refStatus))
							IPsqlQuery.append(" AND STATUS = 'O' ");
						else if("C".equals(refStatus))
							IPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'C' ");
						else if("N".equals(refStatus))
							IPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'N' ");
						/*else if("P".equals(refStatus))
							IPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'P' ");*/
						else if("S".equals(refStatus))
							IPsqlQuery.append(" AND STATUS = 'C' AND BEDSIDE_REF_REVIEW_STATUS = 'S' ");
						else if("X".equals(refStatus))
							IPsqlQuery.append(" AND STATUS = 'X' AND BEDSIDE_REF_REVIEW_STATUS = 'X' ");
					}
					else
					{
						if("A".equals(refStatus))
							IPsqlQuery.append(" AND STATUS IN ('C','O') ");
						else if("Z".equals(refStatus))
							IPsqlQuery.append(" AND STATUS IN ('C') ");
						else if("O".equals(refStatus))
							IPsqlQuery.append(" AND STATUS IN ('O') ");
					}
					//IN064836 end
					IPsqlQuery.append(" AND FROM_LOCN_CODE = A.NURSING_UNIT_CODE AND FROM_LOCN_TYPE =A.LOCN_TYPE ) ");
				}
				if ( unAssigned.equals("Both") )
				{
				IPsqlQuery.append("  OR ");
				}
				if (unAssigned.equals("Unassigned") || unAssigned.equals("Both") )
				{

				IPsqlQuery.append(" EXISTS(SELECT 1 FROM  PR_REFERRAL_REGISTER 	WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?, 'dd/mm/yyyy')  AND TO_DATE(?, 'dd/mm/yyyy') +.9999 ");

				if(!PatientId.equals(""))
				IPsqlQuery.append(" AND PATIENT_ID = ? ");
				IPsqlQuery.append(" AND TO_PRACT_ID = ? ");
				//IN064836 start
				/*if(closed.equals("Y") && open.equals("Y"))
					IPsqlQuery.append(" AND STATUS IN ('C','O') ");
				else if(closed.equals("Y"))
					IPsqlQuery.append(" AND STATUS IN ('C') ");
				else if(open.equals("Y"))
					IPsqlQuery.append(" AND STATUS IN ('O') ");*/
				if("Y".equals(refRegSiteYN))
				{
					if("O".equals(refStatus))
						IPsqlQuery.append(" AND STATUS = 'O' ");
					else if("C".equals(refStatus))
						IPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'C' ");
					else if("N".equals(refStatus))
						IPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'N' ");
					/*else if("P".equals(refStatus))
						IPsqlQuery.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'P' ");*/
					else if("S".equals(refStatus))
						IPsqlQuery.append(" AND STATUS = 'C' AND BEDSIDE_REF_REVIEW_STATUS = 'S' ");
					else if("X".equals(refStatus))
						IPsqlQuery.append(" AND STATUS = 'X' AND BEDSIDE_REF_REVIEW_STATUS = 'X' ");
				}
				else
				{
					if("A".equals(refStatus))
						IPsqlQuery.append(" AND STATUS IN ('C','O') ");
					else if("Z".equals(refStatus))
						IPsqlQuery.append(" AND STATUS IN ('C') ");
					else if("O".equals(refStatus))
						IPsqlQuery.append(" AND STATUS IN ('O') ");
				}
				//IN064836 ends

				IPsqlQuery.append(" AND FROM_LOCN_CODE = A.NURSING_UNIT_CODE AND FROM_LOCN_TYPE =A.LOCN_TYPE AND TO_SPECIALITY_CODE in (SELECT PRIMARY_SPECIALITY_CODE from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? ))");


				}
				if(	LoctionType.equals("Z"))
					sqlQuery.append(OPsqlQuery.toString() + " UNION ALL " + IPsqlQuery.toString());
				else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery.toString());
				else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery.toString());

				if(stmt != null) stmt.close();
				stmt = con.prepareStatement (sqlQuery.toString()) ;



				if(LoctionType.equals("OP")||LoctionType.equals("EM") || LoctionType.equals("Z"))
				{
					if(LoctionType.equals("OP")||LoctionType.equals("EM"))
						stmt.setString(++count_bound_vars,LoctionType);

					stmt.setString(++count_bound_vars,facilityId);
					stmt.setString(++count_bound_vars,locale);

					if (unAssigned.equals("Self") || unAssigned.equals("Both") )
					{
					stmt.setString(++count_bound_vars,facilityId);
					stmt.setString(++count_bound_vars,FromDate);
					stmt.setString(++count_bound_vars,ToDate);

					stmt.setString(++count_bound_vars,practId);
					if(!PatientId.equals(""))
						stmt.setString(++count_bound_vars,PatientId);
					}
					if (unAssigned.equals("Unassigned") || unAssigned.equals("Both") )
					{
						stmt.setString(++count_bound_vars,facilityId);
						stmt.setString(++count_bound_vars,FromDate);
						stmt.setString(++count_bound_vars,ToDate);

						stmt.setString(++count_bound_vars,practId);
					if(!PatientId.equals(""))
						stmt.setString(++count_bound_vars,PatientId);
						stmt.setString(++count_bound_vars,practId);
						stmt.setString(++count_bound_vars,facilityId);
						stmt.setString(++count_bound_vars,practId);

					}
				}

				if(LoctionType.equals("IP")||LoctionType.equals("DC") || LoctionType.equals("Z"))
				{
					if(LoctionType.equals("IP") || LoctionType.equals("DC"))
						stmt.setString(++count_bound_vars,LoctionType);

					stmt.setString(++count_bound_vars,facilityId);
					stmt.setString(++count_bound_vars,locale);

					if (unAssigned.equals("Self") || unAssigned.equals("Both") )
					{
					stmt.setString(++count_bound_vars,facilityId);
					stmt.setString(++count_bound_vars,FromDate);
					stmt.setString(++count_bound_vars,ToDate);

					if(!PatientId.equals(""))
						stmt.setString(++count_bound_vars,PatientId);

					stmt.setString(++count_bound_vars,practId);
					}
					if (unAssigned.equals("Unassigned") || unAssigned.equals("Both") )
					{

						stmt.setString(++count_bound_vars,facilityId);
						stmt.setString(++count_bound_vars,FromDate);
						stmt.setString(++count_bound_vars,ToDate);

					if(!PatientId.equals(""))
						stmt.setString(++count_bound_vars,PatientId);

						stmt.setString(++count_bound_vars,practId);

						stmt.setString(++count_bound_vars,practId);
						stmt.setString(++count_bound_vars,facilityId);
						stmt.setString(++count_bound_vars,practId);
					}
				}

			}
			catch (Exception e)
			{
				
				isError.append(e.toString() +"<br>"+ sqlQuery.toString());
				e.printStackTrace();
			}
		}
		HashMap hash = null;
		try
		{
			ResultSet rset  = null ;
			//HashMap hash = null;
			rset = stmt.executeQuery();
			while( rset.next())
			{
				hash = new HashMap();
				hash.put ( "PATIENT_CLASS",( rset.getString ( field1 )==null?"" :rset.getString ( field1 )));
				hash.put ( "LOCN_CODE",( rset.getString ( field2 )		==null ?"" :rset.getString ( field2 )));
				hash.put ( "LOCN_SHORT_DESC",( rset.getString ( field3 ) ==null ?"" :rset.getString ( field3 )));
				patClassSet.add(rset.getString("PATIENT_CLASS"));
				arrlist.add( hash );
			}

			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			isError.append(e.toString() +"<br>"+ sqlQuery.toString());
			e.printStackTrace();
		}
		//if(hash != null) hash.clear();
		//if(qryStrHash != null) qryStrHash.clear();
		return isError.toString();
    }
	public boolean isFirstLevel()
	{
		boolean isData = false;
		if(patClassSet.size()>0)
			isData = true;
		return 	isData;
	}

	public HashSet getFirstLevel()
	{
		return patClassSet;
	}

	public ArrayList getSecondLevel(String patientType)
	{
		ArrayList returnArray = new ArrayList();
		HashMap dat = null;
		HashMap opHash = null;
		if(arrlist.size()>0)
		{
			for (int i=0; i<arrlist.size(); i++)
			{
				dat = (HashMap) arrlist.get(i) ;
				if(dat.get( "PATIENT_CLASS" ).equals(patientType))
				{
					opHash	 = new HashMap();
					opHash.put("LOCN_SHORT_DESC",dat.get( "LOCN_SHORT_DESC" ) );
					opHash.put("LOCN_CODE",dat.get( "LOCN_CODE" ) );
					returnArray.add(opHash);
				}
			}
			//if(dat != null) dat.clear();
			//if(opHash != null) opHash.clear();
		}
		//if(dat != null) dat.clear();
	return returnArray;
	}
}
