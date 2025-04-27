package eIPAD.InsuranceAuthorization.bc;

import eIPAD.InsuranceAuthorization.dao.InsuranceAuthDAO;
import eIPAD.InsuranceAuthorization.daoimpl.InsuranceAuthDAOImpl;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

public class InsuranceAuthBC {
	public EncounterListResponse getEncounterListForPatient(String patientId, String facilityId, String locale) {
		EncounterListResponse resp = new EncounterListResponse();
		InsuranceAuthDAO dao = new InsuranceAuthDAOImpl();
		resp = dao.getEncounterListForPatient(patientId, facilityId, locale);
		return resp;
	}
}
