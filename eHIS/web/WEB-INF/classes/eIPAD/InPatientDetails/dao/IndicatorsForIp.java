/**
 * 
 */
package eIPAD.InPatientDetails.dao;

import java.util.HashMap;

import eIPAD.InPatientDetails.bc.Inds;
import eIPAD.chartsummary.allergies.request.AllergyRequest;
import eIPAD.chartsummary.allergies.response.AllergyResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;


public interface IndicatorsForIp {

	public Inds getIndicatorForPendingTask(PatContext patsInfo,String patId,String encod_ids,String facility_id,HashMap<String, String> detailsOfPats);
	public Inds getIndicatorForNewNotes(PatContext patsInfo,String patId,String encod_ids,String facility_id,HashMap<String, String> detailsOfPats);
	public Inds getIndicatorForNewResult(PatContext patsInfo,String patId,String encod_ids,String facility_id,HashMap<String, String> detailsOfPats);
	public Inds getIndicatorForDisChargeDue(PatContext patsInfo,String patId,String encod_ids,String facility_id);
	public Inds getIndicatorForAbnormal(PatContext patsInfo,String patId,String encod_ids,String facility_id,HashMap<String, String> detailsOfPats);
	
	public Inds getIndicatorForConsent(PatContext patsInfo,String patId,String encod_ids,String facility_id,HashMap<String, String> detailsOfPats);
}
