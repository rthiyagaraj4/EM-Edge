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
package eIPAD.chartsummary.encounterlist.bc;

import eIPAD.chartsummary.encounterlist.dao.EncounterListDAO;
import eIPAD.chartsummary.encounterlist.daoimpl.EncounterListDAOImpl;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;

/**
 * @author SaraswathiR
 *
 */
public class EncounterListBC {
	
	public EncounterListResponse getEncounterList(EncounterListRequest request){
		EncounterListResponse response;
		EncounterListDAO encounterDAO = new EncounterListDAOImpl();
		response = encounterDAO.getEncounterList(request);
		return response;
		
	}
	public EncounterListResponse getEncounterDetailsById(String encounterId, String facilityId){
		EncounterListResponse response;
		EncounterListDAO encounterDAO = new EncounterListDAOImpl();
		response = encounterDAO.getEncounterDetailsById(encounterId, facilityId);
		return response;
	}

}
