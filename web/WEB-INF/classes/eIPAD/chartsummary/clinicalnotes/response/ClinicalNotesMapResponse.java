/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.response;

import java.util.ArrayList;
import java.util.HashMap;

import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author saraswathir
 *
 */
public class ClinicalNotesMapResponse extends GenericResponse {
	private HashMap map;

	/**
	 * @return the map
	 */
	public HashMap getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(HashMap map) {
		this.map = map;
	}

	
}
