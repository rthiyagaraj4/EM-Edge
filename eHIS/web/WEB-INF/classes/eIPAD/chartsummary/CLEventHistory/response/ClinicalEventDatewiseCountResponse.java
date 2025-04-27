/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.response;

import java.util.ArrayList;

import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDateCountItem;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventDatewiseCountResponse extends GenericResponse {
	ArrayList<ClinicalEventDateCountItem> datewiseEventList = new ArrayList<ClinicalEventDateCountItem>();

	/**
	 * @return the datewiseEventList
	 */
	public ArrayList<ClinicalEventDateCountItem> getDatewiseEventList() {
		return datewiseEventList;
	}

	/**
	 * @param datewiseEventList the datewiseEventList to set
	 */
	public void setDatewiseEventList(
			ArrayList<ClinicalEventDateCountItem> datewiseEventList) {
		this.datewiseEventList = datewiseEventList;
	}
}
