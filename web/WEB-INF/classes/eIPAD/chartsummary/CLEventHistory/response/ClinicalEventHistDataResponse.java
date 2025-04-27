/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.response;

import java.util.ArrayList;

import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDataFieldsItem;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventHistDataResponse  extends GenericResponse{
	private ArrayList<ClinicalEventDataFieldsItem> eventDataList = new ArrayList<ClinicalEventDataFieldsItem>();

	/**
	 * @return the eventDataList
	 */
	public ArrayList<ClinicalEventDataFieldsItem> getEventDataList() {
		return eventDataList;
	}

	/**
	 * @param eventDataList the eventDataList to set
	 */
	public void setEventDataList(ArrayList<ClinicalEventDataFieldsItem> eventDataList) {
		this.eventDataList = eventDataList;
	}
}
