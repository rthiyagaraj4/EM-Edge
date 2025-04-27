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
package eIPAD.chartsummary.allergies.dao;
import eIPAD.chartsummary.allergies.request.*;
import eIPAD.chartsummary.allergies.response.*;
/**
 * @author GaneshkumarC 
 *
 */
public interface AllergyDAO {
	public AllergyResponse getAllergyDetails(AllergyRequest oAllergyReq);
	public EventTypeResponse getEventTypeDetails(EventTypeRequest oEvntTypReq);
	public int getMaxAllergyEventSerialNo(String patientId,String eventInd, String eventCode, String allergenCode);
	public int getMaxAllergyEventDtlSerialNo(String patientId, String eventInd, String eventCode, String allergenCode);	
	public int markReactionAsError(String modified_by_id, String modified_at_ws_no, String patient_id, String allergen_code, String event_type_ind, String event_type_code, String reac_code, String rxn_srl_no , String reac_desc);
}
