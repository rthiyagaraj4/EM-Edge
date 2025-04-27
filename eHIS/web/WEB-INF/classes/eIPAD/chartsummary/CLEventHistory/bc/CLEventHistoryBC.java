/**
 *  @author poorani
 */
package eIPAD.chartsummary.CLEventHistory.bc;

import eIPAD.chartsummary.CLEventHistory.dao.CLEventHistoryDAO;
import eIPAD.chartsummary.CLEventHistory.daoimpl.CLEventHistoryDAOImpl;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryData;
import eIPAD.chartsummary.CLEventHistory.request.CLEventHistoryRequest;
import eIPAD.chartsummary.CLEventHistory.response.CLEventHistoryResponse;

import eIPAD.chartsummary.common.healthobject.PatContext;

public class CLEventHistoryBC {

	
		public CLEventHistoryResponse getEventHisList(PatContext patientContext){
				CLEventHistoryResponse oEventHistoryResponse;
				CLEventHistoryDAO dao = new CLEventHistoryDAOImpl();
				oEventHistoryResponse = dao.getEventHisList(patientContext);
				return oEventHistoryResponse;
		}
}

