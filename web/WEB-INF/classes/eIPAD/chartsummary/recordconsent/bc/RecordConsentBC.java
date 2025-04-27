/**
 * 
 */
package eIPAD.chartsummary.recordconsent.bc;


import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.recordconsent.dao.RecordConsentDAO;
import eIPAD.chartsummary.recordconsent.daoimpl.RecordConsentDAOImpl;
import eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse;
import eIPAD.chartsummary.recordconsent.response.RecordConsentResponse;

/**
 * @author psenthil
 *
 */
public class RecordConsentBC {
	public RecordConsentFieldResponse getConsentFormList(PatContext patientContext){
		RecordConsentDAO dao = new RecordConsentDAOImpl();
		RecordConsentFieldResponse resp;
		resp = dao.getConsentFormList(patientContext);
		return resp;
	}
}

