/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.response;

import java.util.ArrayList;

import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventFieldItem;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR
 *
 */
public class ClinicalEventsFieldResponse extends GenericResponse{
	private ArrayList<ClinicalEventFieldItem> fieldItems = new ArrayList<ClinicalEventFieldItem>();

	/**
	 * @return the fieldItems
	 */
	public ArrayList<ClinicalEventFieldItem> getFieldItems() {
		return fieldItems;
	}

	/**
	 * @param fieldItems the fieldItems to set
	 */
	public void setFieldItems(ArrayList<ClinicalEventFieldItem> fieldItems) {
		this.fieldItems = fieldItems;
	}
	
}
