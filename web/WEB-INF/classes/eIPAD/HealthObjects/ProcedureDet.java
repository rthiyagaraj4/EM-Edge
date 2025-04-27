/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class ProcedureDet implements java.io.Serializable {
     
	private String sProcedureCount;
	private String sProcNarration;
	private String sProcDesc;
	private String sProcDate;
	private String sPracName;
	private String sProcCode;
	private String sEndDate;
	private String sStatus;
	private String sAnaesthetist;
	private String sAnaesthesia;
	/**
	 * @return the sProcedureCount
	 */
	public String getsProcedureCount() {
		return sProcedureCount;
	}
	/**
	 * @param sProcedureCount the sProcedureCount to set
	 */
	public void setsProcedureCount(String sProcedureCount) {
		this.sProcedureCount = sProcedureCount;
	}
	/**
	 * @return the sProcNarration
	 */
	public String getsProcNarration() {
		return sProcNarration;
	}
	/**
	 * @param sProcNarration the sProcNarration to set
	 */
	public void setsProcNarration(String sProcNarration) {
		this.sProcNarration = sProcNarration;
	}
	/**
	 * @return the sProcDate
	 */
	public String getsProcDate() {
		return sProcDate;
	}
	/**
	 * @param sProcDate the sProcDate to set
	 */
	public void setsProcDate(String sProcDate) {
		this.sProcDate = sProcDate;
	}
	/**
	 * @return the sPracName
	 */
	public String getsPracName() {
		return sPracName;
	}
	/**
	 * @param sPracName the sPracName to set
	 */
	public void setsPracName(String sPracName) {
		this.sPracName = sPracName;
	}
	/**
	 * @return the sProcCode
	 */
	public String getsProcCode() {
		return sProcCode;
	}
	/**
	 * @param sProcCode the sProcCode to set
	 */
	public void setsProcCode(String sProcCode) {
		this.sProcCode = sProcCode;
	}
	/**
	 * @return the sEndDate
	 */
	public String getsEndDate() {
		return sEndDate;
	}
	/**
	 * @param sEndDate the sEndDate to set
	 */
	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}
	/**
	 * @return the sStatus
	 */
	public String getsStatus() {
		return sStatus;
	}
	/**
	 * @param sStatus the sStatus to set
	 */
	public void setsStatus(String sStatus) {
		this.sStatus = sStatus;
	}
	/**
	 * @return the sAnaesthetist
	 */
	public String getsAnaesthetist() {
		return sAnaesthetist;
	}
	/**
	 * @param sAnaesthetist the sAnaesthetist to set
	 */
	public void setsAnaesthetist(String sAnaesthetist) {
		this.sAnaesthetist = sAnaesthetist;
	}
	/**
	 * @return the sAnaesthesia
	 */
	public String getsAnaesthesia() {
		return sAnaesthesia;
	}
	/**
	 * @param sAnaesthesia the sAnaesthesia to set
	 */
	public void setsAnaesthesia(String sAnaesthesia) {
		this.sAnaesthesia = sAnaesthesia;
	}
	/**
	 * @return the sProcDesc
	 */
	public String getsProcDesc() {
		return sProcDesc;
	}
	/**
	 * @param sProcDesc the sProcDesc to set
	 */
	public void setsProcDesc(String sProcDesc) {
		this.sProcDesc = sProcDesc;
	}
}
