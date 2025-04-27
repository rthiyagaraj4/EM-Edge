/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventDateCountItem {

	Date eventDate;
	ArrayList<ClinicalEventHistItemCount> eventItemsCount = new ArrayList<ClinicalEventHistItemCount>();
	/**
	 * @return the eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the eventItemsCount
	 */
	public ArrayList<ClinicalEventHistItemCount> getEventItemsCount() {
		return eventItemsCount;
	}
	/**
	 * @param eventItemsCount the eventItemsCount to set
	 */
	public void setEventItemsCount(
			ArrayList<ClinicalEventHistItemCount> eventItemsCount) {
		this.eventItemsCount = eventItemsCount;
	}
	

	
	
}
