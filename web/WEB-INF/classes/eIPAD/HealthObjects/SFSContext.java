/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.* ;
import javax.servlet.*;
import javax.servlet.http.*;
public class SFSContext implements java.io.Serializable 
{
	
	public static final int PRACTITIONER=1;
	
	public static final int SPECIALITY=2;
	
	public static final int NURSINGUNIT=3;
	
	private HttpServletRequest request;
	private HttpSession session;	
	private String sSearchBy = "" ;
	private String sSearchCriteria = "" ;
	private String sSearchText = "";
	private String sfacility_id = "";
	private String sclinicianId = "";
	private String sPracId = "";
	private String sPractionerId = "";
	private int type = 0;
	
	
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
	/**
	 * @return the sSearchBy
	 */
	public String getsSearchBy() {
		return sSearchBy;
	}
	/**
	 * @param sSearchBy the sSearchBy to set
	 */
	public void setsSearchBy(String sSearchBy) {
		this.sSearchBy = sSearchBy;
	}
	/**
	 * @return the sSearchCriteria
	 */
	public String getsSearchCriteria() {
		return sSearchCriteria;
	}
	/**
	 * @param sSearchCriteria the sSearchCriteria to set
	 */
	public void setsSearchCriteria(String sSearchCriteria) {
		this.sSearchCriteria = sSearchCriteria;
	}
	/**
	 * @return the sSearchText
	 */
	public String getsSearchText() {
		return sSearchText;
	}
	/**
	 * @param sSearchText the sSearchText to set
	 */
	public void setsSearchText(String sSearchText) {
		this.sSearchText = sSearchText;
	}
	/**
	 * @return the sfacility_id
	 */
	public String getSfacility_id() {
		return sfacility_id;
	}
	/**
	 * @param sfacility_id the sfacility_id to set
	 */
	public void setSfacility_id(String sfacility_id) {
		this.sfacility_id = sfacility_id;
	}
	/**
	 * @return the sclinicianId
	 */
	public String getSclinicianId() {
		return sclinicianId;
	}
	/**
	 * @param sclinicianId the sclinicianId to set
	 */
	public void setSclinicianId(String sclinicianId) {
		this.sclinicianId = sclinicianId;
	}
	/**
	 * @return the sPracId
	 */
	public String getsPracId() {
		return sPracId;
	}
	/**
	 * @param sPracId the sPracId to set
	 */
	public void setsPracId(String sPracId) {
		this.sPracId = sPracId;
	}
	/**
	 * @return the sPractionerId
	 */
	public String getsPractionerId() {
		return sPractionerId;
	}
	/**
	 * @param sPractionerId the sPractionerId to set
	 */
	public void setsPractionerId(String sPractionerId) {
		this.sPractionerId = sPractionerId;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	

}
