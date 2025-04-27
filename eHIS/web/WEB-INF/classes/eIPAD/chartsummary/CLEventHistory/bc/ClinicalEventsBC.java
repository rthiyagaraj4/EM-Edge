/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.bc;

import eIPAD.chartsummary.CLEventHistory.dao.ClinicalEventsDAO;
import eIPAD.chartsummary.CLEventHistory.daoimpl.ClinicalEventsDAOImpl;
import eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventDatewiseCountResponse;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventHistDataResponse;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventsFieldResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventsBC {
	public ClinicalEventDatewiseCountResponse getDatewiseEventsCount(ClinicalEventsFilterRequest filterReq){
		ClinicalEventsDAO dao = new ClinicalEventsDAOImpl();
		ClinicalEventDatewiseCountResponse resp = dao.getDatewiseEventsCount(filterReq);
		return resp;
	}
	
	public ClinicalEventHistDataResponse getDatewiseSelectedEventsHistory(ClinicalEventsFilterRequest filterReq){
		ClinicalEventsDAO dao = new ClinicalEventsDAOImpl();
		ClinicalEventHistDataResponse resp = dao.getClinicalEventHistDataResponse(filterReq);
		return resp;
	}
	public ClinicalEventsFieldResponse getEventHistoryTypeList(PatContext patientContext){
		ClinicalEventsDAO dao = new ClinicalEventsDAOImpl();
		ClinicalEventsFieldResponse resp = dao.getEventHistoryTypeList(patientContext);
		return resp;
	}
	public ClinicalEventsFieldResponse getEventsPatientClassList(PatContext patientContext){
		ClinicalEventsDAO dao = new ClinicalEventsDAOImpl();
		ClinicalEventsFieldResponse resp = dao.getEventsPatientClassList(patientContext);
		return resp;
	}
	

}
