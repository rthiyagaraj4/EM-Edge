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
package portalrefimpl.facility;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;

/**
 * This is a helper class for the facility module.
 * This class should have only public static methods
 * @author GRamamoorthy
 *
 */
public class FacilityHelper {

	/**
	 * This method will returns the contents of the address object
	 * like the address lines, area, town etc as a list of string objects
	 * The list will be ordered based on configuration
	 * @param address
	 * @return
	 */
	public static List<String> getAddressContentsAsList(Address address){
		List<String> contentList = new ArrayList<String>();
		
		// first read the configuration which will give the order
		// of data that should be added to the content list
		String configValue = PortalHelper
				.getConfigPropertyValue(FacilityConstants.ADDRESS_CONTENTS_ORDER_PARAM);
		// apply default value if user has not specified it in configuration file
		if(configValue == null || configValue.trim().equals("")){
			configValue = FacilityConstants.DEFAULT_ADDRESS_CONTENTS_ORDER_PARAM;
		}
		StringTokenizer tokenizer = new StringTokenizer(configValue,
				FacilityConstants.ADDRESS_CONTACTDETAILS_ORDER_DELIMITER);
		String tokenValue = null;
		// iterate through the tokens, get the data and add it to the list
		while(tokenizer.hasMoreTokens()){
			tokenValue = tokenizer.nextToken();
			if(FacilityConstants.ADDRESS_LINES_PARAM.equals(tokenValue)){
				List<String> addressLinesList = address.getAddressLineList();
				if(addressLinesList != null){
					for(String addressLine : addressLinesList){
						if(addressLine != null && !addressLine.trim().equals("")){
							contentList.add(addressLine);
						}
					}
					/*contentList.addAll(contentList);*/
				}
			}else if(FacilityConstants.AREA_PARAM.equals(tokenValue)){
				String area = address.getArea();
				if(area != null && area.trim().equals("")){
					contentList.add(area);	
				}
			}else if(FacilityConstants.TOWN_PARAM.equals(tokenValue)){
				String town = address.getTown();
				if(town != null && !town.trim().equals("")){
					contentList.add(town);					
				}
			}else if(FacilityConstants.REGION_PARAM.equals(tokenValue)){
				String region = address.getRegion();
				if(region != null && !region.trim().equals("")){
					contentList.add(region);	
				}
			}else if(FacilityConstants.COUNTRY_PARAM.equals(tokenValue)){
				String country = address.getCountry();
				if(country != null && !country.trim().equals("")){
					contentList.add(country);	
				}
			}else if(FacilityConstants.PINCODE_PARAM.equals(tokenValue)){
				String pincode = address.getPincode();
				if(pincode != null && !pincode.trim().equals("")){
					contentList.add(pincode);	
				}
			}
		}
		
		
		return contentList;
	}
	
	/**
	 * This method will returns the contents of the contact details object
	 * like the telephone lines, fax number, email etc as a list of string objects
	 * The list will be ordered based on configuration
	 * @param contactDetails
	 * @return
	 */
	public static List<String> getContactDetailsAsList(ContactDetails contactDetails){
		List<String> contentList = new ArrayList<String>();
		// first read the configuration which will give the order
		// of data that should be added to the content list
		String configValue = PortalHelper
				.getConfigPropertyValue(FacilityConstants.CONTACTDETAILS_CONTENTS_ORDER_PARAM);
		// apply default value if user has not specified it in configuration file
		if(configValue == null || configValue.trim().equals("")){
			configValue = FacilityConstants.DEFAULT_CONTACTDETAILS_ORDER_PARAM;
		}
		StringTokenizer tokenizer = new StringTokenizer(configValue,
				FacilityConstants.ADDRESS_CONTACTDETAILS_ORDER_DELIMITER);
		String tokenValue = null;
		
		// iterate through the tokens, get the data and add it to the list
		while(tokenizer.hasMoreTokens()){
			tokenValue = tokenizer.nextToken();
			if(FacilityConstants.TELEPHONE_LINES_PARAM.equals(tokenValue)){
				List<String> telephoneNumbers = contactDetails.getTelephoneNumbers();
				if(telephoneNumbers != null){
					for(String telephoneNumber : telephoneNumbers){
						if(telephoneNumber != null && !telephoneNumber.trim().equals("")){
							contentList.add(telephoneNumber);	
						}
					}
				}
				/*contentList.addAll(contactDetails.getTelephoneNumbers());*/
			}else if(FacilityConstants.FAXNUMBER_PARAM.equals(tokenValue)){
				String fax = contactDetails.getFaxNumber();
				if(fax != null && fax.trim().equals("")){
					contentList.add(fax);	
				}
			}else if(FacilityConstants.EMAIL_PARAM.equals(tokenValue)){
				String email = contactDetails.getEmailId();
				if(email != null && !email.trim().equals("")){
					contentList.add(email);	
				}
			}else if(FacilityConstants.WEBSITE_PARAM.equals(tokenValue)){
				String website = contactDetails.getWebsiteId();
				if(website != null && !website.trim().equals("")){
					contentList.add(website);	
				}
			}
		}
		
		return contentList;
	}
	
}
