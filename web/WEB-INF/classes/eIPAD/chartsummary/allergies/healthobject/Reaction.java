/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.allergies.healthobject;

import java.io.Serializable;

/**
 * @author SaraswathiR 
 *
 */
public class Reaction implements Serializable {
	private String status;
	private String reactionDate;
	private String reactionDesc;
	private String reactionCode;
	private String severeityDesc;
	private String reactionSite;
	private String reactionSerNo;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the reactionDate
	 */
	public String getReactionDate() {
		return reactionDate;
	}
	/**
	 * @param reactiondate the reactionDate to set
	 */
	public void setReactionDate(String reactionDate) {
		this.reactionDate = reactionDate;
	}
	/**
	 * @return the reactionDesc
	 */
	public String getReactionDesc() {
		return reactionDesc;
	}
	/**
	 * @param reactionDesc the reactionDesc to set
	 */
	public void setReactionDesc(String reactionDesc) {
		this.reactionDesc = reactionDesc;
	}
	/**
	 * @return the severeityDesc
	 */
	public String getSevereityDesc() {
		return severeityDesc;
	}
	/**
	 * @param severeityDesc the severeityDesc to set
	 */
	public void setSevereityDesc(String severeityDesc) {
		this.severeityDesc = severeityDesc;
	}
	/**
	 * @return the reactionSite
	 */
	public String getReactionSite() {
		return reactionSite;
	}
	/**
	 * @param reactionSite the reactionSite to set
	 */
	public void setReactionSite(String reactionSite) {
		this.reactionSite = reactionSite;
	}
	/**
	 * @return the reactionSerNo
	 */
	public String getReactionSerNo() {
		return reactionSerNo;
	}
	/**
	 * @param reactionSerNo the reactionSerNo to set
	 */
	public void setReactionSerNo(String reactionSerNo) {
		this.reactionSerNo = reactionSerNo;
	}
	/**
	 * @return the reactionCode
	 */
	public String getReactionCode() {
		return reactionCode;
	}
	/**
	 * @param reactionCode the reactionCode to set
	 */
	public void setReactionCode(String reactionCode) {
		this.reactionCode = reactionCode;
	}
}
