package eIPAD.InsuranceAuthorization.dao;

import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

public interface InsuranceAuthDAO {
	public EncounterListResponse getEncounterListForPatient(String patientId, String facilityId, String locale);
}
