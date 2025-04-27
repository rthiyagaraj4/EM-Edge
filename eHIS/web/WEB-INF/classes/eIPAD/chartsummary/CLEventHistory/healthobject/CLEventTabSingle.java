/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

import java.util.ArrayList;

/**
 * @author saraswathir
 *
 */
public class CLEventTabSingle {
	
	String date;
	String isStart;
	ArrayList<String> tabValues;
	ArrayList<ArrayList<String>> tabSelectionValues;
	ArrayList<String> tabAllvalues;
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the isStart
	 */
	public String getIsStart() {
		return isStart;
	}
	/**
	 * @param isStart the isStart to set
	 */
	public void setIsStart(String isStart) {
		this.isStart = isStart;
	}
	/**
	 * @return the tabValues
	 */
	public ArrayList<String> getTabValues() {
		return tabValues;
	}
	/**
	 * @param tabValues the tabValues to set
	 */
	public void setTabValues(ArrayList<String> tabValues) {
		this.tabValues = tabValues;
	}
	/**
	 * @return the tabSelectionValues
	 */
	public ArrayList<ArrayList<String>> getTabSelectionValues() {
		return tabSelectionValues;
	}
	/**
	 * @param tabSelectionValues the tabSelectionValues to set
	 */
	public void setTabSelectionValues(
			ArrayList<ArrayList<String>> tabSelectionValues) {
		this.tabSelectionValues = tabSelectionValues;
	}
	/**
	 * @return the tabAllvalues
	 */
	public ArrayList<String> getTabAllvalues() {
		return tabAllvalues;
	}
	/**
	 * @param tabAllvalues the tabAllvalues to set
	 */
	public void setTabAllvalues(ArrayList<String> tabAllvalues) {
		this.tabAllvalues = tabAllvalues;
	}
	
}
