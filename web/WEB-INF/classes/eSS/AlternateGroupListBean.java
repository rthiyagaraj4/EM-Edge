/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.*;
import java.io.*;
public class AlternateGroupListBean extends eSS.Common.SsAdapter implements Serializable { 

	private String alternate_group_code;
	private String description;
	private String mode;

	public String getAlternate_group_code() {
		 return alternate_group_code;
	}

	public void setAlternate_group_code(String alternate_group_code) {
		 this.alternate_group_code =  alternate_group_code.toUpperCase();
	}

	public String getDescription() {
		 return description;
	}

	public void setDescription(String description) {
		 this.description =  description;
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getMode() {
		 return mode;
	}

	public void clear(){
		alternate_group_code	="";          
		description	="";          
		mode		="";          
	}

	public boolean isValidAlternateGroupCode(String alternate_group_code) throws Exception{
		return !fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_COUNT_VALID"),alternate_group_code).get("TOTAL").toString().equals("0");
	}

	public boolean isValidGroupCode(String group_code, String group_type) throws Exception{
		String stParameters[]={group_code, group_type};
		return !fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_COUNT_BASED_ON_TYPE"),stParameters).get("TOTAL").toString().equals("0");
	}

	public String getAlternateGroupDescription(String alternate_group_code) throws Exception{
		return fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_SELECT_DESCRIPTION"),alternate_group_code).get("SHORT_DESC").toString();
	}

	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("alternate_group_code",getAlternate_group_code());
		hmReturn.put("description",getDescription());
		hmReturn.put("mode",getMode());
		return hmReturn;
	}

	public boolean isAlternateGroupInArrayList(ArrayList alAlternateGroupList, String stAlternate_group_code){
		boolean result=false;
		for (int i=0;i<alAlternateGroupList.size();i++) {
			if ( ((HashMap)alAlternateGroupList.get(i)).get("alternate_group_code").toString().equals(stAlternate_group_code) ) {
				result=true;
				break;
			}
		}
		return result;
	}
	public void initialize(HashMap hmAlternateGroup){
		setAlternate_group_code	(hmAlternateGroup.get("alternate_group_code").toString()	);
		setDescription			(hmAlternateGroup.get("description").toString()			);
		setMode					(hmAlternateGroup.get("mode").toString()					);
	}
}
