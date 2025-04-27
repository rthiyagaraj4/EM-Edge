/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/

package eCA;

public class FacilityDetailsBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sFacilityId;
	private String sFacilityName;
	private String sFacilityStatus; 
	
	/**
	 * @return the Facility ID 
	 */
	public String getsFacilityId() {
		return sFacilityId;
	}
	/**
	 * @param sFacilityId the sFacilityId to set
	 */
	public void setsFacilityId(String sFacilityId) {
		this.sFacilityId = sFacilityId;
	}
	
	/**
	 * @return the Facility Name 
	 */
	public String getsFacilityName() {
		return sFacilityName;
	}
	/**
	 * @param sFacilityName the sFacilityName to set
	 */
	public void setsFacilityName(String sFacilityName) {
		this.sFacilityName = sFacilityName;
	}

	/**
	 * @return the Facility Status 
	 */
	public String getsFacilityStatus() {
		return sFacilityStatus;
	}
	/**
	 * @param sFacilityStatus the sFacilityStatus to set
	 */
	public void setsFacilityStatus(String sFacilityStatus) {
		this.sFacilityStatus = sFacilityStatus;
	}
		
}
