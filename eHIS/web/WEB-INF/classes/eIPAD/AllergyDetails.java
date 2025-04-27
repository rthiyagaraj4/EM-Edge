/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 
 */
package eIPAD;
import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import eIPAD.HealthObjects.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;

public class AllergyDetails implements java.io.Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public List<Allergy> getAllergy(PatientContext oPatientContext) throws Exception {
		List<Allergy> AllergyList = new ArrayList<Allergy>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			/*
			sqlStr.append("SELECT adv_event_type_desc,reac_desc,Severity,allergendesc,COUNT(*) OVER() TOTL_ROW_CNT FROM ( SELECT d.long_desc adv_event_type_desc, g.long_desc reac_desc,  DECODE(f.severity ,'U','UNKNOWN','M','Mild','S','Severe','O','Moderate') Severity,   ROW_NUMBER() OVER(PARTITION BY d.long_desc ORDER BY TO_CHAR(f.reaction_date, 'dd/mm/yyyy hh24:mi') DESC) RNUM");
			sqlStr.append(" FROM pr_allergy_sensitivity a, mr_adv_event_type_ind_lang_vw c, mr_adv_event_type_lang_vw d, pr_adverse_event e, pr_adverse_event_reaction f,am_reaction_lang_vw g ");
			sqlStr.append(" WHERE a.patient_id = '" + strPatientId + "' AND a.status  ='A' AND a.patient_id  = e.patient_id AND a.adv_event_type_ind   = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type");
			sqlStr.append(" AND a.allergen_code        = e.allergen_code AND a.adv_event_srl_no     = e.adv_event_srl_no AND a.patient_id = f.patient_id  AND a.adv_event_type_ind = f.adv_event_type_ind");
			sqlStr.append(" AND a.adv_event_type       = f.adv_event_type AND a.allergen_code  = f.allergen_code AND e.adv_event_srl_no  = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND A.ADV_EVENT_TYPE_IND   = C.ADV_EVENT_TYPE_IND AND C.LANGUAGE_ID  = '" + locale + "'");
			sqlStr.append(" AND A.ADV_EVENT_TYPE       = D.ADV_EVENT_TYPE_CODE AND D.LANGUAGE_ID = '" + locale + "' AND f.adv_reac_code  = g.reaction_code (+) AND g.language_id(+) = '" + locale+ "' ) WHERE RNUM=1");
			*/
			//sqlStr.append("SELECT adv_event_type_desc,reac_desc,Severity,allergendesc,COUNT(*) OVER() TOTL_ROW_CNT FROM ( SELECT d.long_desc adv_event_type_desc, g.long_desc reac_desc,  CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '" + locale + "'),   DECODE(f.severity ,'U','UNKNOWN','M','Mild','S','Severe','O','Moderate') Severity,   ROW_NUMBER() OVER(PARTITION BY d.long_desc ORDER BY TO_CHAR(f.reaction_date, 'dd/mm/yyyy hh24:mi') DESC) RNUM");
			
			/*
			sqlStr.append("SELECT adv_event_type_desc,reac_desc,Severity,allergendesc,COUNT(*) OVER() TOTL_ROW_CNT FROM ( SELECT d.long_desc adv_event_type_desc, g.long_desc reac_desc, ");
			sqlStr.append(" CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '" + locale + "'),(SELECT long_desc  FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '" + locale + "') ) ) END allergendesc, ");
			sqlStr.append("DECODE(f.severity ,'U','UNKNOWN','M','Mild','S','Severe','O','Moderate') Severity,   ROW_NUMBER() OVER(PARTITION BY d.long_desc ORDER BY TO_CHAR(f.reaction_date, 'dd/mm/yyyy hh24:mi') DESC) RNUM");
			sqlStr.append(" FROM pr_allergy_sensitivity a, mr_adv_event_type_ind_lang_vw c, mr_adv_event_type_lang_vw d, pr_adverse_event e, pr_adverse_event_reaction f,am_reaction_lang_vw g ");
			sqlStr.append(" WHERE a.patient_id = '" + strPatientId + "' AND a.status  ='A' AND a.patient_id  = e.patient_id AND a.adv_event_type_ind   = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type");
			sqlStr.append(" AND a.allergen_code        = e.allergen_code AND a.adv_event_srl_no     = e.adv_event_srl_no AND a.patient_id = f.patient_id  AND a.adv_event_type_ind = f.adv_event_type_ind");
			sqlStr.append(" AND a.adv_event_type       = f.adv_event_type AND a.allergen_code  = f.allergen_code AND e.adv_event_srl_no  = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND A.ADV_EVENT_TYPE_IND   = C.ADV_EVENT_TYPE_IND AND C.LANGUAGE_ID  = '" + locale + "'");
			sqlStr.append(" AND A.ADV_EVENT_TYPE       = D.ADV_EVENT_TYPE_CODE AND D.LANGUAGE_ID = '" + locale + "' AND f.adv_reac_code  = g.reaction_code (+) AND g.language_id(+) = '" + locale+ "' ) ");
			*/
			sqlStr.append("SELECT adv_event_type_desc,allergendesc ,onset_date FROM ( SELECT d.long_desc adv_event_type_desc, g.long_desc reac_desc, ");
			sqlStr.append(" CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '" + locale + "'),(SELECT long_desc  FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '" + locale + "') ) ) END allergendesc, ");
			sqlStr.append(" onset_date ");
			sqlStr.append(" FROM pr_allergy_sensitivity a, mr_adv_event_type_ind_lang_vw c, mr_adv_event_type_lang_vw d, pr_adverse_event e, pr_adverse_event_reaction f,am_reaction_lang_vw g ");
			sqlStr.append(" WHERE a.patient_id = '" + strPatientId + "' AND a.status  ='A' AND a.patient_id  = e.patient_id AND a.adv_event_type_ind   = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type");
			sqlStr.append(" AND a.allergen_code        = e.allergen_code AND a.adv_event_srl_no     = e.adv_event_srl_no AND a.patient_id = f.patient_id  AND a.adv_event_type_ind = f.adv_event_type_ind");
			sqlStr.append(" AND a.adv_event_type       = f.adv_event_type AND a.allergen_code  = f.allergen_code AND e.adv_event_srl_no  = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND A.ADV_EVENT_TYPE_IND   = C.ADV_EVENT_TYPE_IND AND C.LANGUAGE_ID  = '" + locale + "'");
			sqlStr.append(" AND A.ADV_EVENT_TYPE       = D.ADV_EVENT_TYPE_CODE AND D.LANGUAGE_ID = '" + locale + "' AND f.adv_reac_code  = g.reaction_code (+) AND g.language_id(+) = '" + locale+ "' ORDER BY a.onset_date DESC ) group by adv_event_type_desc, allergendesc,onset_date ORDER BY onset_date DESC ");
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						Allergy oAllergy = new Allergy();
						
						oAllergy.setsAllergyDesc(((resultSet.getString("adv_event_type_desc") != null) ?resultSet.getString("adv_event_type_desc") : "")) ;
						//oAllergy.setsReactionDesc(((resultSet.getString("reac_desc") != null) ?resultSet.getString("reac_desc") : "")) ;
						//oAllergy.setsSevereityDesc(((resultSet.getString("Severity") != null) ?resultSet.getString("Severity") : "")) ;
						oAllergy.setsAllergenDesc(((resultSet.getString("allergendesc") != null) ?resultSet.getString("allergendesc") : "")) ;
						//oAllergy.setsCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0")) ;
					
					
						AllergyList.add(oAllergy);
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}

		return AllergyList;
	}
	public List<Allergy> getAllergyDetails(PatientContext oPatientContext) throws Exception {
		List<Allergy> oAllergyList = new ArrayList<Allergy>() ;
		if(oPatientContext != null && oPatientContext.request != null )
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			//HttpSession session = oPatientContext.session;
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			/*
			sqlStr.append(" SELECT mr_get_desc.mr_adv_event_type (d.adv_event_type_code,'" + locale + "', '1') adv_event_type_desc, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name ");
			sqlStr.append(" FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '" + locale + "'),(SELECT long_desc  FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '" + locale + "') ");
			sqlStr.append("  )) END allergen, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE(a.status,'A','Active','E','Error','R','Resolved') Status, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,");
			sqlStr.append(" am_get_desc.am_reaction (g.reaction_code, '" + locale + "','1' ) reac_desc,DECODE(f.severity ,'U','UNKNOWN','M','Mild','S','Severe','O','Moderate') Severity, f.reaction_site ");
			sqlStr.append(" FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e, pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '" + strPatientId + "' AND a.status = 'A' ");
			sqlStr.append(" AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no ");
			sqlStr.append(" AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no ");
			sqlStr.append(" AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code(+) ");
			sqlStr.append(" ORDER BY a.onset_date DESC");
		    */
			sqlStr.append("select adv_event_type_desc, allergen,TO_CHAR (onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, status,reaction_date,reac_desc,severity,reaction_site from ( ");
			sqlStr.append(" SELECT mr_get_desc.mr_adv_event_type (d.adv_event_type_code,'" + locale + "', '1') adv_event_type_desc, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name ");
			sqlStr.append(" FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '" + locale + "'),(SELECT long_desc  FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '" + locale + "') ");
			sqlStr.append("  )) END allergen, onset_date,  DECODE(a.status,'A','Active','E','Error','R','Resolved') Status, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,");
			sqlStr.append(" am_get_desc.am_reaction (g.reaction_code, '" + locale + "','1' ) reac_desc,DECODE(f.severity ,'U','UNKNOWN','M','Mild','S','Severe','O','Moderate') Severity, f.reaction_site ");
			sqlStr.append(" FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e, pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '" + strPatientId + "' AND a.status = 'A' ");
			sqlStr.append(" AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no ");
			sqlStr.append(" AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no ");
			sqlStr.append(" AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code(+) ");
			sqlStr.append(" ORDER BY a.onset_date DESC");
			sqlStr.append(" ) " );
			
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						Allergy oAllergy = new Allergy();
						oAllergy.setsAllergyDesc(((resultSet.getString("adv_event_type_desc") != null) ?resultSet.getString("adv_event_type_desc") : "")) ;
						oAllergy.setsAllergenDesc(((resultSet.getString("allergen") != null) ?resultSet.getString("allergen") : "")) ;
						oAllergy.setsOnsetDate(((resultSet.getString("onset_date") != null) ?resultSet.getString("onset_date") : "")) ;
						oAllergy.setsStatus(((resultSet.getString("Status") != null) ?resultSet.getString("Status") : "")) ;
						oAllergy.setsReactiondate(((resultSet.getString("reaction_date") != null) ?resultSet.getString("reaction_date") : "") );
						oAllergy.setsReactionDesc(((resultSet.getString("reac_desc") != null) ?resultSet.getString("reac_desc") : "")) ;		
						oAllergy.setsSevereityDesc(((resultSet.getString("Severity") != null) ?resultSet.getString("Severity") : "")) ;
						oAllergy.setsReactionSite(((resultSet.getString("reaction_site") != null) ?resultSet.getString("reaction_site") : "")) ;
						oAllergyList.add(oAllergy);
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		
		}
		return oAllergyList;
	}
}
