/**
 * 
 */
package eIPAD.chartsummary.common.response;

import java.util.ArrayList;

import eIPAD.chartsummary.common.constants.WidgetItems;

/**
 * @author SaraswathiR
 *
 */
public class WidgetOrderResponse extends GenericResponse{
	ArrayList<WidgetItems> activeWidgets = new ArrayList<WidgetItems>();
	ArrayList<WidgetItems> inactiveWidgets = new ArrayList<WidgetItems>();
	/**
	 * @return the activeWidgets
	 */
	public ArrayList<WidgetItems> getActiveWidgets() {
		return activeWidgets;
	}
	/**
	 * @param activeWidgets the activeWidgets to set
	 */
	public void setActiveWidgets(ArrayList<WidgetItems> activeWidgets) {
		this.activeWidgets = activeWidgets;
	}
	/**
	 * @return the inactiveWidgets
	 */
	public ArrayList<WidgetItems> getInactiveWidgets() {
		return inactiveWidgets;
	}
	/**
	 * @param inactiveWidgets the inactiveWidgets to set
	 */
	public void setInactiveWidgets(ArrayList<WidgetItems> inactiveWidgets) {
		this.inactiveWidgets = inactiveWidgets;
	}
	
}
