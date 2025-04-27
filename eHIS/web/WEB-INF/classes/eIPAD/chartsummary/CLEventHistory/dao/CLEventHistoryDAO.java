/**
 *  @author poorani
 */
package eIPAD.chartsummary.CLEventHistory.dao;


import eIPAD.chartsummary.CLEventHistory.response.CLEventHistoryResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;


public interface CLEventHistoryDAO {
	public CLEventHistoryResponse getEventHisList(PatContext patientContext);
}
