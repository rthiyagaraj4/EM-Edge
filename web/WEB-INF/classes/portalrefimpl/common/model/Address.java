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
package portalrefimpl.common.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.PortalConstants;
import portalrefimpl.common.CommonConstants;

/**
 * This model class stores the address details of a person
 * or a hospital/clinic
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Address")
public class Address {

	/**
	 * Data members in this class
	 */
	private List<String> addressLineList;
	private String area;
	private String town;
	private String region;
	private String country;
	private String pincode;
	/*private String resTownName;
	private String regionName;
	private String countryCode;
	private String areaCode;
	private String townCode;
	private String regionCode;*/
	
	/**
	 * @return the addressLineList
	 */
	@XmlElementWrapper(name = "AddressLines")
	@XmlElement(name = "AddressLine")
	public List<String> getAddressLineList() {
		return addressLineList;
	}
	/**
	 * @param addressLineList the addressLineList to set
	 */
	public void setAddressLineList(List<String> addressLineList) {
		this.addressLineList = addressLineList;
	}
	/**
	 * @return the city
	 */
	@XmlElement(name = "Town")
	public String getTown() {
		return town;
	}
	/**
	 * @param town the city to set
	 */
	public void setTown(String town) {
		this.town = town;
	}
	/**
	 * @return the resAreaName
	 */
	@XmlElement(name = "Region")
	public String getRegion() {
		return region;
	}
	/**
	 * @param resAreaName the resAreaName to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the country
	 */
	@XmlElement(name = "Country")
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the pincode
	 */
	@XmlElement(name = "Pincode")
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the resTownName
	 */
	/*public String getResTownName() {
		return resTownName;
	}
	*//**
	 * @param resTownName the resTownName to set
	 *//*
	public void setResTownName(String resTownName) {
		this.resTownName = resTownName;
	}
	*//**
	 * @return the regionName
	 *//*
	public String getRegionName() {
		return regionName;
	}
	*//**
	 * @param regionName the regionName to set
	 *//*
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	*//**
	 * @return the countryCode
	 *//*
	public String getCountryCode() {
		return countryCode;
	}
	*//**
	 * @param countryCode the countryCode to set
	 *//*
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	*//**
	 * @return the areaCode
	 *//*
	public String getAreaCode() {
		return areaCode;
	}
	*//**
	 * @param areaCode the areaCode to set
	 *//*
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	*//**
	 * @return the townCode
	 *//*
	public String getTownCode() {
		return townCode;
	}
	*//**
	 * @param townCode the townCode to set
	 *//*
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}
	*//**
	 * @return the regionCode
	 *//*
	public String getRegionCode() {
		return regionCode;
	}
	*//**
	 * @param regionCode the regionCode to set
	 *//*
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}*/
	
	/**
	 * This method returns the contents of this object
	 * as an xml string
	 * @return
	 */
	public String getXMLString(){
		StringBuffer xmlContentBuff = new StringBuffer();
		// all the address details are enclosed within
		// the address tag
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.ADDRESS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// put all the address lines
		if(addressLineList != null && !addressLineList.isEmpty()){
			xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
					.append(CommonConstants.ADDRESSLINES_XML_TAG)
					.append(PortalConstants.XML_CLOSE_TAG);
			for(String line : addressLineList){
				if(line == null){
					line = "";
				}
				xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
						.append(CommonConstants.ADDRESSLINE_XML_TAG)
						.append(PortalConstants.XML_CLOSE_TAG);
				xmlContentBuff.append(line);
				
				xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
						.append(CommonConstants.ADDRESSLINE_XML_TAG)
						.append(PortalConstants.XML_CLOSE_TAG);
			}
			
			xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
					.append(CommonConstants.ADDRESSLINES_XML_TAG)
					.append(PortalConstants.XML_CLOSE_TAG);
		}
		
		// area name and area code
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.AREANAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempAreaName = region;
		if(tempAreaName == null){
			tempAreaName = "";
		}
		xmlContentBuff.append(tempAreaName);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.AREANAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		/*xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.AREACODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempAreaCode = areaCode;
		if (tempAreaCode == null) {
			tempAreaCode = "";
		}
		xmlContentBuff.append(tempAreaCode);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.AREACODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// town name and town code
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.TOWNNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempTownName = resTownName;
		if (tempTownName == null) {
			tempTownName = "";
		}
		xmlContentBuff.append(tempTownName);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.TOWNNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.TOWNCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempTownCode = townCode;
		if(tempTownCode == null){
			tempTownCode = "";
		}
		xmlContentBuff.append(tempTownCode);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.TOWNCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);*/
		
		// region name and region code
		/*xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.REGIONNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempRegionName = regionName;
		if (tempRegionName == null) {
			tempRegionName = "";
		}
		xmlContentBuff.append(tempRegionName);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.REGIONNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.REGIONCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempRegionCode = regionCode;
		if (tempRegionCode == null) {
			tempRegionCode = "";
		}
		xmlContentBuff.append(tempRegionCode);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.REGIONCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);*/
		
		// city
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.CITY_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempCity = town;
		if (tempCity == null) {
			tempCity = "";
		}
		xmlContentBuff.append(tempCity);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.CITY_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// country and country code
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.COUNTRY_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempCountry = country;
		if (tempCountry == null) {
			tempCountry = "";
		}
		xmlContentBuff.append(tempCountry);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.COUNTRY_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		/*xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.COUNTRYCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempCountryCode = countryCode;
		if (tempCountryCode == null) {
			tempCountryCode = "";
		}
		xmlContentBuff.append(tempCountryCode);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.COUNTRYCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);*/
		
		// pincode
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.PINCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempPinCode = pincode;
		if (tempPinCode == null) {
			tempPinCode = "";
		}
		xmlContentBuff.append(tempPinCode);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.PINCODE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		
		// finally close the address tag
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.ADDRESS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlContentBuff.toString();
	}
	/**
	 * @return the area
	 */
	@XmlElement(name = "Area")
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
}
