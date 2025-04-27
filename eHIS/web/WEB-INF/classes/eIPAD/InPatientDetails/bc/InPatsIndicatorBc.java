/**
 * 
 */
package eIPAD.InPatientDetails.bc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import webbeans.eCommon.ConnectionManager;
import eIPAD.HealthObjects.InPatients;
import eIPAD.InPatientDetails.dao.IndicatorsForIp;
import eIPAD.InPatientDetails.daoimps.InpatientsImpls;
import eIPAD.chartsummary.common.healthobject.PatContext;

public class InPatsIndicatorBc {

	public ArrayList<PatsIndicators> allIndicators;

	// public ArrayList<PatsIndicators> getAllIndicators(){
	//
	// return this.allIndicators;
	//
	// }

	/**
	 * @param allIndicators
	 *            the allIndicators to set
	 */
	// public void setAllIndicators(PatsIndicators allIndicators) {
	//
	//
	// this.allIndicators.add(allIndicators);
	//
	// }

	public ArrayList<PatsIndicators> getAllIndicatiorsForallPatient(
			PatContext patsAllDeatils, String[] pathsIdsList,
			String[] allEncounterIdsList, String facility_id,
			HashMap<String, String> detailsOfPats) {

		// getIndicatorForPendingTask

		allIndicators = new ArrayList<PatsIndicators>();

		for (int i = 0; i < pathsIdsList.length; i++) {

			PatsIndicators patInd = new PatsIndicators();

			boolean statusOfResultFilter = false;

			String EncodsIds = allEncounterIdsList[i];

			patInd.setPatId(pathsIdsList[i]);

			Inds resPend;
			Inds resNewNOtes;
			Inds resNewResult;
			Inds resDisDue;
			Inds resAbnoraml;			
			Inds resConsent;

			
			
			IndicatorsForIp indInterface =new InpatientsImpls();

			// pending task

			resPend = indInterface.getIndicatorForPendingTask(patsAllDeatils,
					pathsIdsList[i], EncodsIds, facility_id, detailsOfPats);

			if (resPend.getShowIndicator()) {
				patInd.setTypesOfIndicator(resPend);

				// allIndicators.add(patInd);

			}

			// New Notes

			resNewNOtes = indInterface.getIndicatorForNewNotes(patsAllDeatils,
					pathsIdsList[i], EncodsIds, facility_id, detailsOfPats);

			if (resNewNOtes.getShowIndicator()) {
				patInd.setTypesOfIndicator(resNewNOtes);

				// allIndicators.add(patInd);

			}

			
			// disChargeDue
			resDisDue = indInterface.getIndicatorForDisChargeDue(
					patsAllDeatils, pathsIdsList[i], EncodsIds, facility_id);

			if (resDisDue.getShowIndicator()) {
				patInd.setTypesOfIndicator(resDisDue);
				// allIndicators.add(patInd);
			}
			
			
			// consent
						resConsent = indInterface.getIndicatorForConsent(patsAllDeatils,
								pathsIdsList[i], EncodsIds, facility_id, detailsOfPats);

						if (resConsent.getShowIndicator()) {
							patInd.setTypesOfIndicator(resConsent);
							// allIndicators.add(patInd);
						}


			// abnormal

			resAbnoraml = indInterface.getIndicatorForAbnormal(patsAllDeatils,
					pathsIdsList[i], EncodsIds, facility_id, detailsOfPats);

			if (resAbnoraml.getShowIndicator()) {

				statusOfResultFilter = true;

				// allIndicators.add(patInd);
			}

			if (statusOfResultFilter) {

				patInd.setTypesOfIndicator(resAbnoraml);

			} else {

				resNewResult = indInterface.getIndicatorForNewResult(
						patsAllDeatils, pathsIdsList[i], EncodsIds,
						facility_id, detailsOfPats);

				if (resNewResult.getShowIndicator()) {

					patInd.setTypesOfIndicator(resNewResult);

					// allIndicators.add(patInd);

				}

			}

			allIndicators.add(patInd);

			// setAllIndicators(patInd);

		}

		// ArrayList<String> patsId=valuesOfList.get("patIdList");

		return allIndicators;

	}

}
