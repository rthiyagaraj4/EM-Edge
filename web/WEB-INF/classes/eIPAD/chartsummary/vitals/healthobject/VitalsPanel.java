/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;
import java.util.*;
public class VitalsPanel implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sectionId;
	private String sectionDesc;
	private List<VitalsConfig> vitalsConfigList;
	
	/**
	 * @return the sectionId 
	 */
	public String getSectionId() {
		return sectionId;
	}
	/**
	 * @param sectionId the sectionId to set
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	/**
	 * @return the sectionDesc
	 */
	public String getSectionDesc() {
		return sectionDesc;
	}
	/**
	 * @param sectionDesc the sectionDesc to set
	 */
	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof VitalsPanel)
		{
			VitalsPanel oVitalsPanel = (VitalsPanel)obj;
			if(oVitalsPanel.getSectionId() != null && oVitalsPanel.getSectionId().equals(this.sectionId))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	public int hashCode() {
		return this.sectionId.hashCode();
	}
	/**
	 * @return the vitalsConfigList
	 */
	public List<VitalsConfig> getVitalsConfigList() {
		return vitalsConfigList;
	}
	/**
	 * @param vitalsConfigList the vitalsConfigList to set
	 */
	public void setVitalsConfigList(List<VitalsConfig> vitalsConfigList) {
		this.vitalsConfigList = vitalsConfigList;
	}
}
