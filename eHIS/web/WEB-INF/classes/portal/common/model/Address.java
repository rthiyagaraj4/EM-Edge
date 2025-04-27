/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.common.model;

/**
 * This class defines all the address attributes required for 
 * Hospital and patient information
 * 
 * @author skrishnared2
 */
public class Address {
	
	/**
	 * Instance Variables
	 */
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String resAreaName;
	private String country;
	private String pincode;
	private String resTownName;
	private String regionName;
	private String countryCode;
	
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		if(addressLine1 != null){
			this.addressLine1 = addressLine1;
		} else {
			this.addressLine1 = "";
		}
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		if(addressLine2 != null){
			this.addressLine2 = addressLine2;
		} else {
			this.addressLine2 = "";
		}
	}
	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}
	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		if(addressLine3 != null){
			this.addressLine3 = addressLine3;
		} else {
			this.addressLine3 = "";
		}
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		if(city != null){
			this.city = city;
		} else {
			this.city = "";
		}
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		if(country != null){
			this.country = country;
		} else {
			this.country = "";
		}
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		if(pincode != null){
			this.pincode = pincode;
		} else {
			this.pincode = "";
		}
	}
	/**
	 * @return the resAreaName
	 */
	public String getResAreaName() {
		return resAreaName;
	}
	/**
	 * @param resAreaName the resAreaName to set
	 */
	public void setResAreaName(String resAreaName) {
		if(resAreaName != null){
			this.resAreaName = resAreaName;
		} else {
			this.resAreaName = "";
		}
	}
	/**
	 * @return the resTownName
	 */
	public String getResTownName() {
		return resTownName;
	}
	/**
	 * @param resTownName the resTownName to set
	 */
	public void setResTownName(String resTownName) {
		if(resTownName != null){
			this.resTownName = resTownName;
		} else {
			this.resTownName = "";
		}
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		if(regionName != null){
			this.regionName = regionName;
		} else {
			this.regionName = "";
		}
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		if(countryCode != null){
			this.countryCode = countryCode;
		} else {
			this.countryCode = "";
		}
	}

}
