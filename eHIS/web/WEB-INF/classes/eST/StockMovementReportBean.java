/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//import eCommon.Common.CommonAdapter; 
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class StockMovementReportBean extends StAdapter
    implements Serializable
{
 

	//private String language;
	public String getReportType()
    {
        return getStaticListOptionTag("STBMOVIT,By Item;STBMOVST,By Store");
    }

    public String getStaticListOptionTag(String s, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        StringTokenizer stringtokenizer1;
        String s2;
        String s3;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ";"); stringtokenizer.hasMoreTokens(); stringbuffer.append("<option value=\"" + s2 + "\" " + s3 + ">" + stringtokenizer1.nextToken() + "</option>\n"))
        {
            stringtokenizer1 = new StringTokenizer(stringtokenizer.nextToken(), ",");
            s2 = stringtokenizer1.nextToken();
            s3 = s1.equalsIgnoreCase(s2) ? "selected" : "";
        }

        return stringbuffer.toString();
    }

    public String getStaticListOptionTag(String s)
    {
        return getStaticListOptionTag(s, "");
    }
 
/* public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}*/

	public String getStore_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),getLoginFacilityId()));
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}

    //MOHE-CRF-0084.1 
    public String getRestrictUserAccessStore(){
     	String []stParameters=	{getLoginFacilityId()};
    		HashMap hmRecord	=	null;
    		try{
    			hmRecord	=	(HashMap)fetchRecord("SELECT RESTRICT_USER_ACCESS_STORE_YN FROM	st_facility_param WHERE facility_id=?", stParameters);
    		}catch(Exception e){
    			e.printStackTrace();
    			return "";
    		}
    		return (String)hmRecord.get("RESTRICT_USER_ACCESS_STORE_YN"); 
     	
     } 
   
}
