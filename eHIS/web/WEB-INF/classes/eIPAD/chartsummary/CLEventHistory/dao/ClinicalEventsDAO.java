/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.dao;

import eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventDatewiseCountResponse;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventHistDataResponse;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventsFieldResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * @author saraswathir
 *
 */
public interface ClinicalEventsDAO {
	public ClinicalEventDatewiseCountResponse getDatewiseEventsCount(ClinicalEventsFilterRequest filterReq);
	public ClinicalEventHistDataResponse getClinicalEventHistDataResponse(ClinicalEventsFilterRequest filterReq);
	public ClinicalEventsFieldResponse getEventHistoryTypeList(PatContext patientContext);
	public ClinicalEventsFieldResponse getEventsPatientClassList(PatContext patientContext);

}
