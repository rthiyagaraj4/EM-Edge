/**
 * 
 */
package eIP.advbedmgmt.transaction.floorlayout.request;

import eIP.advbedmgmt.common.request.BaseRequest;

/**
 * This is the base request class for getting bed details
 * This class should be extended to get bed status and bed icon information
 * for individual beds
 * @author GRamamoorthy
 *
 */
public class BasicBedRequest extends BaseRequest {

	/**
	 * Data members
	 */
	protected String facilityId = null;
	
	protected String nursingUnitCode = null;
	
	protected String bedNumber = null;
	
	protected String langId = null;
	
	protected String loginUser = null;
	/**
	 * @return the loginUser
	 */
	public String getLoginUser() {
		return loginUser;
	}

	/**
	 * @param loginUser the loginUser to set
	 */
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the nursingUnitCode
	 */
	public String getNursingUnitCode() {
		return nursingUnitCode;
	}

	/**
	 * @param nursingUnitCode the nursingUnitCode to set
	 */
	public void setNursingUnitCode(String nursingUnitCode) {
		this.nursingUnitCode = nursingUnitCode;
	}

	/**
	 * @return the bedNumber
	 */
	public String getBedNumber() {
		return bedNumber;
	}

	/**
	 * @param bedNumber the bedNumber to set
	 */
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	/**
	 * @return the langId
	 */
	public String getLangId() {
		return langId;
	}

	/**
	 * @param langId the langId to set
	 */
	public void setLangId(String langId) {
		this.langId = langId;
	}
	
	
	
}
