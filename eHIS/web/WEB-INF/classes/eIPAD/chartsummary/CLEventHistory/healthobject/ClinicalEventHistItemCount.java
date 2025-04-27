/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventHistItemCount {
	private String histType;
	private String histDesc;
	private int count;
	ArrayList<ClinicalEventHistItemCountDets> eventDetailsList = new ArrayList<ClinicalEventHistItemCountDets>();
	
	
	/**
	 * @return the eventDetailsList
	 */
	public ArrayList<ClinicalEventHistItemCountDets> getEventDetailsList() {
		return eventDetailsList;
	}
	/**
	 * @param eventDetailsList the eventDetailsList to set
	 */
	public void setEventDetailsList(
			ArrayList<ClinicalEventHistItemCountDets> eventDetailsList) {
		this.eventDetailsList = eventDetailsList;
	}
	/**
	 * @return the histType
	 */
	public String getHistType() {
		return histType;
	}
	/**
	 * @param histType the histType to set
	 */
	public void setHistType(String histType) {
		this.histType = histType;
	}
	/**
	 * @return the histDesc
	 */
	public String getHistDesc() {
		return histDesc;
	}
	/**
	 * @param histDesc the histDesc to set
	 */
	public void setHistDesc(String histDesc) {
		this.histDesc = histDesc;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
		if(!(o instanceof ClinicalEventHistItemCount)) {
            return false;
        }else{
        	ClinicalEventHistItemCount toCompare = (ClinicalEventHistItemCount)o;
        	if(toCompare.getHistType().equals(this.histType)){
        		return true;
        	}else{
        		return false;
        	}
        }
	}
	 
}
