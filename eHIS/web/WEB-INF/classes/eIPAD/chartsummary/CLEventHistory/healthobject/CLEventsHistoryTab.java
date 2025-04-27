/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

import java.util.ArrayList;

/**
 * @author ACibibalan
 *
 */
public class CLEventsHistoryTab {

	String date;
	String isStart;
	ArrayList<String> allSubTabs;
	String headTitle;
	ArrayList<String> allSubTabsUniqueIds;
	ArrayList<String> allSubTabsMiddleIds;
	ArrayList<String> allStartIds;
	ArrayList<String> allIdValues;
	ArrayList<String> uniqueIdsForList;
	String mappingKey;
	String start;
	
	
	
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
	 * @return the allSubTabs
	 */
	public ArrayList<String> getAllSubTabs() {
		return allSubTabs;
	}
	/**
	 * @param allSubTabs the allSubTabs to set
	 */
	public void setAllSubTabs(ArrayList<String> allSubTabs) {
		this.allSubTabs = allSubTabs;
	}
	/**
	 * @return the headTitle
	 */
	public String getHeadTitle() {
		return headTitle;
	}
	/**
	 * @param headTitle the headTitle to set
	 */
	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}
	/**
	 * @return the allSubTabsUniqueIds
	 */
	public ArrayList<String> getAllSubTabsUniqueIds() {
		return allSubTabsUniqueIds;
	}
	public ArrayList<String> getUniqueIdsForList() {
		return uniqueIdsForList;
	}
	/**
	 * @param allSubTabsUniqueIds the allSubTabsUniqueIds to set
	 */
	public void setAllSubTabsUniqueIds(ArrayList<String> allSubTabsUniqueIds) {
		this.allSubTabsUniqueIds = allSubTabsUniqueIds;
	}
	public void setUniqueIdsForList(ArrayList<String> uniqueIdsForList) {
		this.uniqueIdsForList = uniqueIdsForList;
	}
	
	
	
	public ArrayList<String> getAllSubTabsMiddleIds() {
		return allSubTabsMiddleIds;
	}
	/**
	 * @param allSubTabsMiddleIds the allSubTabsMiddleIds to set
	 */
	public void setAllSubTabsMiddleIds(ArrayList<String> allSubTabsMiddleIds) {
		this.allSubTabsMiddleIds = allSubTabsMiddleIds;
	}
	
	/**
	 * @return the allIdValues
	 */
	public ArrayList<String> getAllIdValues() {
		return allIdValues;
	}
	/**
	 * @param allIdValues the allIdValues to set
	 */
	public void setAllIdValues(ArrayList<String> allIdValues) {
		this.allIdValues = allIdValues;
	}
	/**
	 * @return the allStartIds
	 */
	public ArrayList<String> getAllStartIds() {
		return allStartIds;
	}
	/**
	 * @param allStartIds the allStartIds to set
	 */
	public void setAllStartIds(ArrayList<String> allStartIds) {
		this.allStartIds = allStartIds;
	}
	
	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	String end;
	/**
	 * @return the mappingKey
	 */
	public String getMappingKey() {
		return mappingKey;
	}
	/**
	 * @param mappingKey the mappingKey to set
	 */
	public void setMappingKey(String mappingKey) {
		this.mappingKey = mappingKey;
	}
}
