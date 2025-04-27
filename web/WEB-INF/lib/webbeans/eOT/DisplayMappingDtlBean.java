/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eOT;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;

public class DisplayMappingDtlBean extends OTAdapter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String operatingFacilityId;
	private String displayStatus;
	private String colorCode;
	List<String> statusCodeList = null; 
	List<String> statusDescList = null;;
	List<String> deleteList = null;
	
	

	public DisplayMappingDtlBean() 
	{
		
	}
	
	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}


	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}


	public String getDisplayStatus() {
		return displayStatus;
	}


	public void setDisplayStatus(String displayStatus) {
		this.displayStatus = displayStatus;
	}


	public String getColorCode() {
		return colorCode;
	}


	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<String> getStatusCodeList() {
		return statusCodeList;
	}


	public void setStatusCodeList(List<String> statusCodeList) {
		this.statusCodeList = statusCodeList;
	}


	public List<String> getStatusDescList() {
		return statusDescList;
	}


	public void setStatusDescList(List<String> statusDescList) {
		this.statusDescList = statusDescList;
	}

	public List<String> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<String> deleteList) {
		this.deleteList = deleteList;
	}
	
	public void addToStatusCodeList(String code)
	{
		if(this.statusCodeList == null)
		{
			statusCodeList = new ArrayList<String>();
		}
		statusCodeList.add(code);
	}
	
	public void addToStatusDescList(String desc)
	{
		if(this.statusDescList == null)
		{
			statusDescList = new ArrayList<String>();
		}
		statusDescList.add(desc);
	}


	public String getCodeString()
	{
		StringBuffer codeString = new StringBuffer();
		
		for(String code : statusCodeList)
		{
			codeString.append(code).append(",");
		}
		return codeString.toString();
	}
	
	public String getDescString()
	{
		StringBuffer descString = new StringBuffer();
		
		for(String desc : statusDescList)
		{
			descString.append(desc).append(",");
		}
		
		return descString.substring(0, descString.length() - 1);
	}
	
	public void setStatusCodeList(String statusCode)
	{
		String [] statusCodeArray = statusCode.split(",");
		this.statusCodeList = Arrays.asList(statusCodeArray);
	}
}
