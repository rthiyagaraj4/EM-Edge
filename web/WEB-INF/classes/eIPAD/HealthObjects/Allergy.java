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
public class Allergy implements java.io.Serializable
{
  private String sAllergyDesc;
  private String sAllergenDesc;
  private String sOnsetDate;
  private String sStatus;
  private String sReactiondate;
  private String sReactionDesc;
  private String sSevereityDesc;
  private String sReactionSite;
  private String sCount;
/**
 * @return the sAllergyDesc
 */
public String getsAllergyDesc() {
	return sAllergyDesc;
}
/**
 * @param sAllergyDesc the sAllergyDesc to set
 */
public void setsAllergyDesc(String sAllergyDesc) {
	this.sAllergyDesc = sAllergyDesc;
}
/**
 * @return the sAllergenDesc
 */
public String getsAllergenDesc() {
	return sAllergenDesc;
}
/**
 * @param sAllergenDesc the sAllergenDesc to set
 */
public void setsAllergenDesc(String sAllergenDesc) {
	this.sAllergenDesc = sAllergenDesc;
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
 * @return the sReactiondate
 */
public String getsReactiondate() {
	return sReactiondate;
}
/**
 * @param sReactiondate the sReactiondate to set
 */
public void setsReactiondate(String sReactiondate) {
	this.sReactiondate = sReactiondate;
}
/**
 * @return the sReactionDesc
 */
public String getsReactionDesc() {
	return sReactionDesc;
}
/**
 * @param sReactionDesc the sReactionDesc to set
 */
public void setsReactionDesc(String sReactionDesc) {
	this.sReactionDesc = sReactionDesc;
}
/**
 * @return the sSevereityDesc
 */
public String getsSevereityDesc() {
	return sSevereityDesc;
}
/**
 * @param sSevereityDesc the sSevereityDesc to set
 */
public void setsSevereityDesc(String sSevereityDesc) {
	this.sSevereityDesc = sSevereityDesc;
}
/**
 * @return the sReactionSite
 */
public String getsReactionSite() {
	return sReactionSite;
}
/**
 * @param sReactionSite the sReactionSite to set
 */
public void setsReactionSite(String sReactionSite) {
	this.sReactionSite = sReactionSite;
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

}
