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
package eIPAD.chartsummary.allergies.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import eIPAD.chartsummary.allergies.dao.*;
import eIPAD.chartsummary.allergies.healthobject.*;
import eIPAD.chartsummary.allergies.request.*;
import eIPAD.chartsummary.allergies.response.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.daoimpl.*;
import eIPAD.chartsummary.common.response.*;
/**
 * @author GaneshkumarC
 *
 */
public class AllergyDAOImpl extends GenericDAOImpl implements AllergyDAO {
	public AllergyResponse getAllergyDetails(AllergyRequest oAllergyReq)
	{
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strPatientId = "";
		StringBuffer sqlStr = new StringBuffer("");
		AllergyResponse oAllergyRes = new AllergyResponse();
		List<Allergy> AllergyList = new ArrayList<Allergy>();
		ErrorInfo oErrInfo = new ErrorInfo();

		
		if(oAllergyReq != null)
		{
			PatContext oPatContext = oAllergyReq.getPatientContext();
			if(oPatContext != null)
			{
				strPatientId = checkForNull(oPatContext.getPatientId());
				locale =  checkForNull(oPatContext.getLocale());
				oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
				String oAllergenCode = checkForNull(oAllergyReq.getAllergenCode());
				String eventTypeCode = checkForNull(oAllergyReq.getEventTypeCode());
				String eventTypeInd = checkForNull(oAllergyReq.getEventTypeInd());
				String allergenCode;
				String allergyEventDesc;
				String allergenDesc;
				String allergyEventCode;
				String allergyEventTypeInd;
				String onsetDate;
				String activeDate;
				String status;
				String causativeSubstance;
				String diagnosisCode;
				String certainity;
				String remarks;
				String routeOfExposure;
				String allergyTestResult;
				String treatmentAdvice;
				String informationSource;
				String reactionDate;
				String reactionDesc;
				String severeityDesc;
				String reactionSite;
				String error_status;
				String adv_reac_code;
				String others_reaction;
				String reactionSerNo;
				boolean estimatedDuration;
			
				//Query taken from eMR RecordPatientAdverseEvent4.jsp
				
				sqlStr.append("select allergen_code, adv_event_type_desc, allergen,TO_CHAR (onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, active_date, status, causative_substance, ");
				sqlStr.append(" diagnosis_code, adv_event_type, adv_event_type_ind, certainty, remarks, route_of_exposure, allergy_test_result, treatment_advice, information_source, ");
				sqlStr.append(" reaction_date,reac_desc,severity,reaction_site, error_status, adv_reac_code, reaction_serialno, others_reaction, estimated_duration from ( ");
				sqlStr.append(" SELECT mr_get_desc.mr_adv_event_type (d.adv_event_type_code,'" + locale + "', '1') adv_event_type_desc, CASE WHEN a.allergen_code IS NOT NULL THEN ");
				sqlStr.append(" (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '" + locale + "'), ");
				sqlStr.append(" (SELECT long_desc  FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '" + locale + "') )) END allergen, ");
				sqlStr.append("   onset_date, DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = i.drug_code AND language_id='" + locale + "'),");
				sqlStr.append(" e.causative_substance) causative_substance, a.adv_event_type adv_event_type,a.adv_event_type_ind adv_event_type_ind, a.certainty certainty,");
				sqlStr.append(" a.status status, h.remarks remarks, h.route_of_exposure route_of_exposure, h.allergy_test_result allergy_test_result, h.treatment_advice treatment_advice, ");
				sqlStr.append(" h.information_source information_source, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,");
				sqlStr.append(" am_get_desc.am_reaction (g.reaction_code, '" + locale + "','1' ) reac_desc, f.severity severity, f.reaction_site, f.status error_status, ");
				sqlStr.append(" f.adv_reac_code adv_reac_code, f.others_reaction others_reaction, f.adv_event_rxn_srl_no reaction_serialno, a.calculated_onset_date_yn estimated_duration, ");
				sqlStr.append(" a.allergen_code allergen_code , TO_CHAR (a.active_date, 'dd/mm/yyyy') active_date, a.diagnosis_code diagnosis_code ");
				sqlStr.append(" FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e, pr_adverse_event_reaction f,am_reaction g, ");
				sqlStr.append("  pr_adverse_event h, pr_adverse_event i WHERE a.patient_id = '" + strPatientId + "' AND a.status = 'A' ");
				if(!oAllergenCode.equals("")){
					sqlStr.append(" AND a.allergen_code = '" + oAllergenCode + "' ");
				}
				if(!eventTypeCode.equals("")){
					sqlStr.append(" AND a.adv_event_type = '" + eventTypeCode + "' ");
				}
				if(!eventTypeInd.equals("")){
					sqlStr.append(" AND a.adv_event_type_ind = '" + eventTypeInd + "' ");
				}
				sqlStr.append(" AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND "); 
				sqlStr.append(" a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND ");
				sqlStr.append(" a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND ");
				sqlStr.append(" e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND ");
				sqlStr.append(" a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code(+) AND h.allergen_code = e.allergen_code AND ");
				sqlStr.append(" h.adv_event_type_ind = e.adv_event_type_ind AND h.adv_event_type = e.adv_event_type AND h.patient_id = e.patient_id AND h.adv_event_dtl_srl_no = ");
				sqlStr.append(" (select nvl(max(adv_event_dtl_srl_no),0) adv_event_dtl_srl_no from pr_adverse_event where  patient_id= a.patient_id AND ");
				sqlStr.append(" adv_event_type = a.adv_event_type AND allergen_code=a.allergen_code AND adv_event_type_ind=a.adv_event_type_ind) AND ");
				sqlStr.append(" i.allergen_code = e.allergen_code AND i.adv_event_type_ind = e.adv_event_type_ind AND i.adv_event_type = e.adv_event_type AND ");
				sqlStr.append(" i.patient_id = e.patient_id AND i.adv_event_dtl_srl_no= (select nvl(min(adv_event_dtl_srl_no),0) adv_event_dtl_srl_no from ");
				sqlStr.append(" pr_adverse_event where  patient_id=a.patient_id AND adv_event_type = a.adv_event_type AND allergen_code=a.allergen_code AND ");
				sqlStr.append(" adv_event_type_ind=a.adv_event_type_ind) ");
				sqlStr.append(" ORDER BY a.onset_date DESC, f.reaction_date DESC");
				sqlStr.append(" ) " );
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
						ArrayList<Reaction> reactionList;
						Map<Allergy,ArrayList<Reaction>> allergyMap= new LinkedHashMap<Allergy, ArrayList<Reaction>>();
						while(resultSet.next())
						{
							allergenCode = checkForNull(resultSet.getString("allergen_code"));
							allergyEventDesc = checkForNull(resultSet.getString("adv_event_type_desc"));
							allergenDesc = checkForNull(resultSet.getString("allergen"));
							allergyEventCode = checkForNull(resultSet.getString("adv_event_type"));
							allergyEventTypeInd = checkForNull(resultSet.getString("adv_event_type_ind"));
							onsetDate = checkForNull(resultSet.getString("onset_date"));
							activeDate = checkForNull(resultSet.getString("active_date"));
							status = checkForNull(resultSet.getString("status"));
							causativeSubstance = checkForNull(resultSet.getString("causative_substance"));
							diagnosisCode = checkForNull(resultSet.getString("diagnosis_code"));
							certainity = checkForNull(resultSet.getString("certainty"));
							remarks = checkForNull(resultSet.getString("remarks"));
							routeOfExposure = checkForNull(resultSet.getString("route_of_exposure"));
							allergyTestResult = checkForNull(resultSet.getString("allergy_test_result"));
							treatmentAdvice = checkForNull(resultSet.getString("treatment_advice"));
							informationSource = checkForNull(resultSet.getString("information_source"));
							reactionDate = checkForNull(resultSet.getString("reaction_date"));
							reactionDesc = checkForNull(resultSet.getString("reac_desc"));
							severeityDesc = checkForNull(resultSet.getString("Severity"));
							reactionSite = checkForNull(resultSet.getString("reaction_site"));
							error_status = checkForNull(resultSet.getString("error_status"));
							adv_reac_code = checkForNull(resultSet.getString("adv_reac_code"));
							others_reaction = checkForNull(resultSet.getString("others_reaction"));
							reactionSerNo = checkForNull(resultSet.getString("reaction_serialno"));
							estimatedDuration = checkForNull(resultSet.getString("estimated_duration")).trim().equals("Y")?true:false;
							if(!error_status.equals("E")){
								Allergy oAllergy = new Allergy();
								Reaction oReaction = new Reaction();
								
								oAllergy.setAllergenCode(allergenCode);
								oAllergy.setAllergyEventDesc(allergyEventDesc);
								oAllergy.setAllergenDesc(allergenDesc);
								oAllergy.setAllergyEventCode(allergyEventCode);
								oAllergy.setAllergyEventTypeInd(allergyEventTypeInd);
								oAllergy.setAllergyStatus(status);
								oAllergy.setOnsetDate(onsetDate);
								oAllergy.setActiveDate(activeDate);
								oAllergy.setEstimatedDuration(estimatedDuration);
								oAllergy.setCausativeSubstance(causativeSubstance);
								oAllergy.setDiagnosisCode(diagnosisCode);
								oAllergy.setCertainity(certainity);
								oAllergy.setRemarks(remarks);
								oAllergy.setRouteOfExposure(routeOfExposure);
								oAllergy.setAllergyTestResult(allergyTestResult);
								oAllergy.setTreatmentAdvice(treatmentAdvice);
								oAllergy.setInformationSource(informationSource);
								
								if(adv_reac_code.equals("Oth")) {
									oReaction.setReactionDesc(others_reaction);
								}
								else {
									oReaction.setReactionDesc(reactionDesc);
								}
								oReaction.setReactionSite(reactionSite);
								oReaction.setReactionDate(reactionDate);
								oReaction.setSevereityDesc(severeityDesc);
								oReaction.setStatus(status);
								oReaction.setReactionSerNo(reactionSerNo);
								oReaction.setReactionCode(adv_reac_code);
								
								if(allergyMap.containsKey(oAllergy)){
									allergyMap.get(oAllergy).add(oReaction);					
								}
								else{
									reactionList = new ArrayList<Reaction>();
									reactionList.add(oReaction);
									allergyMap.put(oAllergy,reactionList);
								}
							}
						}
						
						Iterator<Entry<Allergy, ArrayList<Reaction>>> iter = allergyMap.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry<Allergy, ArrayList<Reaction>> mEntry = (Map.Entry<Allergy, ArrayList<Reaction>>) iter.next();
							Allergy allergyEntry = (Allergy)mEntry.getKey();
							ArrayList<Reaction> reactionListEntry = (ArrayList<Reaction>)mEntry.getValue();
							allergyEntry.setCount(reactionListEntry.size());
							allergyEntry.setReactions(reactionListEntry);
							AllergyList.add(allergyEntry);
						}
					}
					if(AllergyList != null && AllergyList.size() == 0)
					{
						oErrInfo.setErrorType(Errors.ALLERGYLIST_EMPTY_DATA, locale);
					}
					oAllergyRes.setAllergyDetails(AllergyList);
					//oErrInfo.setErrorCode(0);
				}
				catch(Exception e)
				{
					//oErrInfo.setErrorCode(1);
					//oErrInfo.setErrorType(Errors.Custom_Message.setMessage(e.toString()));
					e.printStackTrace();
					
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
					
					
				}
				finally
				{
					
					int conCloseFailure = closeConnection(connection,stmt,resultSet);
					if(conCloseFailure > 0)
					{
						System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getAllergyDetails");
					}
				}
				
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			 oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oAllergyRes.getErrorsList().add(oErrInfo);
		return oAllergyRes;
	}

	
	/**
	 * @author GaneshkumarC
	 * This method returns the event type details for the respective EventType indicator
	 */
	public EventTypeResponse getEventTypeDetails(EventTypeRequest oEvntTypReq)
	{
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");
		EventTypeResponse oEvtTypRes = new EventTypeResponse();
		ErrorInfo oErrInfo = new ErrorInfo();
		List<EventType> oLstEventType = new ArrayList<EventType>();
		
		if(oEvntTypReq != null)
		{
			if(oEvntTypReq.getLocale() != null && !oEvntTypReq.getLocale().equals(""))
			{
				locale = oEvntTypReq.getLocale();
			}
			oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
			if(oEvntTypReq.getEventTypeIndicator() != null && !oEvntTypReq.getEventTypeIndicator().equals("") )
			{
				if(oEvntTypReq.getEventTypeIndicator() != "01")
				{
					sqlStr.append(" SELECT   a.long_desc long_desc, a.adv_event_type_code, b.adv_event_type_ind ");
					sqlStr.append(" FROM mr_adv_event_type_lang_vw a, mr_adv_event_type_detail b WHERE a.adv_event_type_code = b.adv_event_type_code ");
					sqlStr.append("  AND b.adv_event_type_ind = '" +oEvntTypReq.getEventTypeIndicator() +"' ");
					sqlStr.append("  AND a.language_id = '" + locale+"'  AND a.eff_status = 'E' ORDER BY long_desc desc ");
				}
				else
				{
					sqlStr.append(" SELECT long_desc, adv_event_type_code,null as adv_event_type_ind  FROM mr_adv_event_type_lang_vw WHERE language_id = '"+ locale+"' AND eff_status = 'E'");
				}
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
						while(resultSet.next())
						{
							EventType oEvtType = new EventType();
							oEvtType.setEventTypeDescription(checkForNull(resultSet.getString("long_desc")));
							oEvtType.setEventTypeCode(checkForNull(resultSet.getString("adv_event_type_code")));
							oEvtType.setEventTypeIndicator(checkForNull(resultSet.getString("adv_event_type_ind")));
							oLstEventType.add(oEvtType);
						}
					}
					if(oLstEventType != null && oLstEventType.size() == 0)
					{
						oErrInfo.setErrorType(Errors.COMMON_EMPTY_DATA, locale);
					}
					oEvtTypRes.setLstEventTypeDetails(oLstEventType);
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
						System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getEventTypeDetails");
					}
				}
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		 oEvtTypRes.getErrorsList().add(oErrInfo);
		return oEvtTypRes;
	}
	
	//Query taken from eMR RecordAdverseEventServlet
	public int getMaxAllergyEventSerialNo(String patientId, String eventInd, String eventCode, String allergenCode){
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		int eventAllergenSerialNum = -1;
		String sql_adv_srl_num = "select nvl(max(ADV_EVENT_SRL_NO),0) ADV_EVENT_SRL_NO from PR_ALLERGY_SENSITIVITY where  PATIENT_ID='"+patientId+"' and ADV_EVENT_TYPE_IND='"+eventInd+"' and ADV_EVENT_TYPE ='"+eventCode+"' and ALLERGEN_CODE='"+allergenCode+"'";
		try{
			connection = createConnection();
			if(connection != null)
			{
				stmt = connection.createStatement();
			}
			if(stmt != null)
			{
				resultSet = stmt.executeQuery(sql_adv_srl_num);
			}
			if(resultSet != null && resultSet.next())
			{
				eventAllergenSerialNum = resultSet.getInt("ADV_EVENT_SRL_NO");
			}
		}
		catch(Exception e){
			eventAllergenSerialNum = -1;
			e.printStackTrace();
		}
		finally{
			//closing connections
			int conCloseFailure = closeConnection(connection,stmt,resultSet);
			if(conCloseFailure > 0)
			{
				System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getEventAllergenSerialNum");
			}
		}
		return eventAllergenSerialNum;
	
		
	}
	
	//Query taken from eMR RecordAdverseEventServlet
	public int getMaxAllergyEventDtlSerialNo(String patientId, String eventInd, String eventCode, String allergenCode){

		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		int eventAllergenSerialNum = -1;
		String sql_adv_dtl_srl_num = "select nvl(max(ADV_EVENT_DTL_SRL_NO),0) ADV_EVENT_DTL_SRL_NO from PR_ADVERSE_EVENT where  PATIENT_ID='"+patientId+"' and ADV_EVENT_TYPE_IND='"+eventInd+"' and ADV_EVENT_TYPE ='"+eventCode+"' and ALLERGEN_CODE='"+allergenCode+"'";
		try{
			connection = createConnection();
			if(connection != null)
			{
				stmt = connection.createStatement();
			}
			if(stmt != null)
			{
				resultSet = stmt.executeQuery(sql_adv_dtl_srl_num);
			}
			if(resultSet != null && resultSet.next())
			{
				eventAllergenSerialNum = resultSet.getInt("ADV_EVENT_DTL_SRL_NO");
			}
		}
		catch(Exception e){
			eventAllergenSerialNum = -1;
			e.printStackTrace();
		}
		finally{
			//closing connections
			int conCloseFailure = closeConnection(connection,stmt,resultSet);
			if(conCloseFailure > 0)
			{
				System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getEventAllergenSerialNum");
			}
		}
		return eventAllergenSerialNum;
	
	}
	
	public int markReactionAsError(String modified_by_id, String modified_at_ws_no, String patient_id, String allergen_code, String event_type_ind, String event_type_code, String reac_code, String rxn_srl_no , String reac_desc){
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int result = 0;
		StringBuffer sql_mark_error = new StringBuffer("update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = '"+modified_by_id+"' ,modified_at_ws_no = '"+modified_at_ws_no+"' , modified_date = sysdate  where  patient_id = '"+patient_id+"' and allergen_code = '"+allergen_code+"' and adv_event_type_ind = '"+event_type_ind+"' and adv_event_type = '"+event_type_code+"' and adv_reac_code = '"+reac_code+"' and adv_event_rxn_srl_no = '"+rxn_srl_no+"' ");
		if(reac_code.equals("Oth"))
			sql_mark_error.append(" and others_reaction = '"+reac_desc+"' ");
		
		try{
			connection = createConnection();
			if(connection != null)
			{
				pstmt=connection.prepareStatement(sql_mark_error.toString());
			}
			if(pstmt != null)
			{
				result = pstmt.executeUpdate();
			}
			if(result!=0){
				connection.commit();
			}
		}
		catch(Exception e){
			result = 0;
			e.printStackTrace();
		}
		finally{
			//closing connections
			int conCloseFailure = closeConnection(connection,pstmt,resultSet);
			if(conCloseFailure > 0)
			{
				System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.markReactionAsError");
			}
		}
		return result;
	}
	
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
