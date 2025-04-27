/**
 * 
 */
package eIPAD.chartsummary.recordconsent.dao;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse;
import eIPAD.chartsummary.recordconsent.response.RecordConsentResponse;

/**
 * @author psenthil
 *
 */
public interface RecordConsentDAO {
	public RecordConsentFieldResponse getConsentFormList(PatContext patientContext);
}
