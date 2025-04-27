/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blHcard;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;


public class BillingPrevilageCardMemberLocalBean {
	
	protected String 		PrimaryPatientId									=	"";
	protected String 		AdditionalPatientId									=	"";
	protected String 		EffectiveFrom										=	"";
	protected String 		AdditionalPatientName								=	"";
	protected String 		AdditionalPatientAge								=	"";
	protected String 		AdditionalPatientPriceClasscode						=	"";
	protected String 		AdditionalPatientPriceClassDesc						=	"";
	protected String 		HcardSeqno											=	"";
	protected String 		CardTypeCode										=	"";
	protected String 		PackageCode											=	"";
	
	
	protected ArrayList 	PrevilageCardAdditionalPatientList					=	null;

	/**
	 * @return the primaryPatientId
	 */
	public String getPrimaryPatientId() {
		return PrimaryPatientId;
	}

	/**
	 * @param primaryPatientId the primaryPatientId to set
	 */
	public void setPrimaryPatientId(String primaryPatientId) {
		PrimaryPatientId = primaryPatientId;
	}

	/**
	 * @return the additionalPatientId
	 */
	public String getAdditionalPatientId() {
		return AdditionalPatientId;
	}

	/**
	 * @param additionalPatientId the additionalPatientId to set
	 */
	public void setAdditionalPatientId(String additionalPatientId) {
		AdditionalPatientId = additionalPatientId;
	}

	/**
	 * @return the effectiveFrom
	 */
	public String getEffectiveFrom() {
		return EffectiveFrom;
	}

	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(String effectiveFrom) {
		EffectiveFrom = effectiveFrom;
	}

	/**
	 * @return the additionalPatientName
	 */
	public String getAdditionalPatientName() {
		return AdditionalPatientName;
	}

	/**
	 * @param additionalPatientName the additionalPatientName to set
	 */
	public void setAdditionalPatientName(String additionalPatientName) {
		AdditionalPatientName = additionalPatientName;
	}

	/**
	 * @return the additionalPatientAge
	 */
	public String getAdditionalPatientAge() {
		return AdditionalPatientAge;
	}

	/**
	 * @param additionalPatientAge the additionalPatientAge to set
	 */
	public void setAdditionalPatientAge(String additionalPatientAge) {
		AdditionalPatientAge = additionalPatientAge;
	}

	/**
	 * @return the additionalPatientPriceClasscode
	 */
	public String getAdditionalPatientPriceClasscode() {
		return AdditionalPatientPriceClasscode;
	}

	/**
	 * @param additionalPatientPriceClasscode the additionalPatientPriceClasscode to set
	 */
	public void setAdditionalPatientPriceClasscode(
			String additionalPatientPriceClasscode) {
		AdditionalPatientPriceClasscode = additionalPatientPriceClasscode;
	}

	/**
	 * @return the additionalPatientPriceClassDesc
	 */
	public String getAdditionalPatientPriceClassDesc() {
		return AdditionalPatientPriceClassDesc;
	}

	/**
	 * @param additionalPatientPriceClassDesc the additionalPatientPriceClassDesc to set
	 */
	public void setAdditionalPatientPriceClassDesc(
			String additionalPatientPriceClassDesc) {
		AdditionalPatientPriceClassDesc = additionalPatientPriceClassDesc;
	}

	/**
	 * @return the hcardSeqno
	 */
	public String getHcardSeqno() {
		return HcardSeqno;
	}

	/**
	 * @param hcardSeqno the hcardSeqno to set
	 */
	public void setHcardSeqno(String hcardSeqno) {
		HcardSeqno = hcardSeqno;
	}

	/**
	 * @return the cardTypeCode
	 */
	public String getCardTypeCode() {
		return CardTypeCode;
	}

	/**
	 * @param cardTypeCode the cardTypeCode to set
	 */
	public void setCardTypeCode(String cardTypeCode) {
		CardTypeCode = cardTypeCode;
	}

	/**
	 * @return the previlageCardAdditionalPatientList
	 */
	public ArrayList getPrevilageCardAdditionalPatientList() {
		return PrevilageCardAdditionalPatientList;
	}

	/**
	 * @param previlageCardAdditionalPatientList the previlageCardAdditionalPatientList to set
	 */
	public void setPrevilageCardAdditionalPatientList(
			ArrayList previlageCardAdditionalPatientList) {
		PrevilageCardAdditionalPatientList = previlageCardAdditionalPatientList;
	}
	
	/**
	 * @return the packageCode
	 */
	public String getPackageCode() {
		return PackageCode;
	}

	/**
	 * @param packageCode the packageCode to set
	 */
	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
	}

	/**
	 * clears the bean value
	 */
	public void clearBean()
	{
		PrimaryPatientId									=	"";                                                          
		AdditionalPatientId									=	"";                                                          
		EffectiveFrom										=	"";                                                          
		AdditionalPatientName								=	"";                                                                  
		AdditionalPatientAge								=	"";                                                                  
		AdditionalPatientPriceClasscode						=	"";                                                                          
		AdditionalPatientPriceClassDesc						=	"";                                                                          
		HcardSeqno											=	"";                                                  
		CardTypeCode										=	"";     
		PackageCode											=	"";
		
		PrevilageCardAdditionalPatientList					=	null;
		                                                                                                                                                             
         
   }
	
	
	
	

}
