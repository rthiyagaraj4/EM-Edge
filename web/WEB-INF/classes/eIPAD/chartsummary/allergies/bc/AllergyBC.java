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
package eIPAD.chartsummary.allergies.bc;

import eIPAD.chartsummary.allergies.dao.*;
import eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl;
import eIPAD.chartsummary.allergies.request.*;
import eIPAD.chartsummary.allergies.response.*;
/**
 * @author GaneshkumarC 
 *
 */

public class AllergyBC {
	public AllergyResponse getAllergyDetails(AllergyRequest oAllergyReq)
	{
		AllergyResponse oAllergyRes;
		AllergyDAO oAllergyDAO = new AllergyDAOImpl();
		oAllergyRes = oAllergyDAO.getAllergyDetails(oAllergyReq);
		return oAllergyRes;
	}
	public EventTypeResponse getEventTypeDetails(EventTypeRequest oEvntTypReq)
	{
		EventTypeResponse oEvntTypRes;
		AllergyDAO oAllergyDAO = new AllergyDAOImpl();
		oEvntTypRes = oAllergyDAO.getEventTypeDetails(oEvntTypReq);
		return oEvntTypRes;
	}
	public int getMaxAllergyEventSerialNo(String patientId, String eventInd, String eventCode, String allergenCode){
		AllergyDAO oAllergyDAO = new AllergyDAOImpl();
		int maxAllergyEventSerialNo = oAllergyDAO.getMaxAllergyEventSerialNo(patientId, eventInd, eventCode, allergenCode);
		return maxAllergyEventSerialNo;
	}
	public int getMaxAllergyEventDtlSerialNo(String patientId, String eventInd, String eventCode, String allergenCode){
		AllergyDAO oAllergyDAO = new AllergyDAOImpl();
		int maxAllergyEventDtlSerialNo = oAllergyDAO.getMaxAllergyEventDtlSerialNo(patientId, eventInd, eventCode, allergenCode);
		return maxAllergyEventDtlSerialNo;
	}
	public int markReactionAsError(String modified_by_id, String modified_at_ws_no, String patient_id, String allergen_code, String event_type_ind, String event_type_code, String reac_code, String rxn_srl_no , String reac_desc){
		AllergyDAO oAllergyDAO = new AllergyDAOImpl();
		return oAllergyDAO.markReactionAsError(modified_by_id,modified_at_ws_no,patient_id,allergen_code,event_type_ind,event_type_code,reac_code,rxn_srl_no,reac_desc);
	}
}
