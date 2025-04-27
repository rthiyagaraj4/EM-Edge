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
public class Problem implements java.io.Serializable
{
	  private String sProblemDesc;
	  private String sProblemAccuracy;
	  private String sProblemSevereity;
	  private String sCount;
	  private String sDiagnosisProblem;
	  private String sStatus;
	  private String sPracName;
	  private String sOnsetDate;
	  private String sDateTime;
	  private String sEncounterID;
	  private String scurrenstate;
	  private String sAddedDate;
	/**
	 * @return the sProblemDesc
	 */
	public String getsProblemDesc() {
		return sProblemDesc;
	}
	/**
	 * @param sProblemDesc the sProblemDesc to set
	 */
	public void setsProblemDesc(String sProblemDesc) {
		this.sProblemDesc = sProblemDesc;
	}
	/**
	 * @return the sProblemAccuracy
	 */
	public String getsProblemAccuracy() {
		return sProblemAccuracy;
	}
	/**
	 * @param sProblemAccuracy the sProblemAccuracy to set
	 */
	public void setsProblemAccuracy(String sProblemAccuracy) {
		this.sProblemAccuracy = sProblemAccuracy;
	}
	/**
	 * @return the sProblemSevereity
	 */
	public String getsProblemSevereity() {
		return sProblemSevereity;
	}
	/**
	 * @param sProblemSevereity the sProblemSevereity to set
	 */
	public void setsProblemSevereity(String sProblemSevereity) {
		this.sProblemSevereity = sProblemSevereity;
	}
	/**
	 * @return the sCount
	 */
	public String getsCount() {
		return sCount;
	}
	/**
	 * @param sCount the sCount to set
	 */
	public void setsCount(String sCount) {
		this.sCount = sCount;
	}
	/**
	 * @return the sDiagnosisProblem
	 */
	public String getsDiagnosisProblem() {
		return sDiagnosisProblem;
	}
	/**
	 * @param sDiagnosisProblem the sDiagnosisProblem to set
	 */
	public void setsDiagnosisProblem(String sDiagnosisProblem) {
		this.sDiagnosisProblem = sDiagnosisProblem;
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
	 * @return the sOnsetDate
	 */
	public String getsOnsetDate() {
		return sOnsetDate;
	}
	/**
	 * @param sOnsetDate the sOnsetDate to set
	 */
	public void setsOnsetDate(String sOnsetDate) {
		this.sOnsetDate = sOnsetDate;
	}
	/**
	 * @return the sDateTime
	 */
	public String getsDateTime() {
		return sDateTime;
	}
	/**
	 * @param sDateTime the sDateTime to set
	 */
	public void setsDateTime(String sDateTime) {
		this.sDateTime = sDateTime;
	}
	/**
	 * @return the sEncounterID
	 */
	public String getsEncounterID() {
		return sEncounterID;
	}
	/**
	 * @param sEncounterID the sEncounterID to set
	 */
	public void setsEncounterID(String sEncounterID) {
		this.sEncounterID = sEncounterID;
	}
	/**
	 * @return the scurrenstate
	 */
	public String getScurrenstate() {
		return scurrenstate;
	}
	/**
	 * @param scurrenstate the scurrenstate to set
	 */
	public void setScurrenstate(String scurrenstate) {
		this.scurrenstate = scurrenstate;
	}
	/**
	 * @return the sAddedDate
	 */
	public String getsAddedDate() {
		return sAddedDate;
	}
	/**
	 * @param sAddedDate the sAddedDate to set
	 */
	public void setsAddedDate(String sAddedDate) {
		this.sAddedDate = sAddedDate;
	}
}
