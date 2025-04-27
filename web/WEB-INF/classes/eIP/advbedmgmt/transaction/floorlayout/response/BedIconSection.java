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
package eIP.advbedmgmt.transaction.floorlayout.response;

/**
 * This is the model class representing the icon section for a bed
 * @author GRamamoorthy
 *
 */
public class BedIconSection {
	
	/**
	 * Data members in this class
	 */
	private String bedNumber = null;
	
	private String knownAllergy = null;
	
	private String billExists = null;
	
	private int futureBookingCount = 0;
	
	private int medicationOverDueCount = 0;
	
	private int abnormalResultCount = 0;
	
	private int publishedResultCount = 0;
	
	private String encounterId = null;
	
	private int ordersCount = 0;

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
	 * @return the knownAllergy
	 */
	public String getKnownAllergy() {
		return knownAllergy;
	}

	/**
	 * @param knownAllergy the knownAllergy to set
	 */
	public void setKnownAllergy(String knownAllergy) {
		this.knownAllergy = knownAllergy;
	}

	/**
	 * @return the billExists
	 */
	public String getBillExists() {
		return billExists;
	}

	/**
	 * @param billExists the billExists to set
	 */
	public void setBillExists(String billExists) {
		this.billExists = billExists;
	}

	/**
	 * @return the futureBookingCount
	 */
	public int getFutureBookingCount() {
		return futureBookingCount;
	}

	/**
	 * @param futureBookingCount the futureBookingCount to set
	 */
	public void setFutureBookingCount(int futureBookingCount) {
		this.futureBookingCount = futureBookingCount;
	}

	/**
	 * @return the medicationOverDueCount
	 */
	public int getMedicationOverDueCount() {
		return medicationOverDueCount;
	}

	/**
	 * @param medicationOverDueCount the medicationOverDueCount to set
	 */
	public void setMedicationOverDueCount(int medicationOverDueCount) {
		this.medicationOverDueCount = medicationOverDueCount;
	}

	/**
	 * @return the abnormalResultCount
	 */
	public int getAbnormalResultCount() {
		return abnormalResultCount;
	}

	/**
	 * @param abnormalResultCount the abnormalResultCount to set
	 */
	public void setAbnormalResultCount(int abnormalResultCount) {
		this.abnormalResultCount = abnormalResultCount;
	}

	/**
	 * @return the publishedResultCount
	 */
	public int getPublishedResultCount() {
		return publishedResultCount;
	}

	/**
	 * @param publishedResultCount the publishedResultCount to set
	 */
	public void setPublishedResultCount(int publishedResultCount) {
		this.publishedResultCount = publishedResultCount;
	}

	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}

	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	/**
	 * @return the ordersCount
	 */
	public int getOrdersCount() {
		return ordersCount;
	}

	/**
	 * @param ordersCount the ordersCount to set
	 */
	public void setOrdersCount(int ordersCount) {
		this.ordersCount = ordersCount;
	}
	
	

}
