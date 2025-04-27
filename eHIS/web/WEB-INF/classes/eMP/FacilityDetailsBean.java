/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
10/06/2015        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eMP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FacilityDetailsBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sFacilityId;
	private String sFacilityName;
	private String sFacilityStatus; 
	
	public HttpServletRequest request;
	public HttpSession session;

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
	
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}	

	
}
