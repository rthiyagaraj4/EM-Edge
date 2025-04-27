/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------
*/
 package eST;

import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class MonthlySummaryReportBean extends StAdapter implements Serializable
{
//private String language; 
	
    public ArrayList getArrayCodeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
//        Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"));
          
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }

/* Transaction type Details */

 /*public ArrayList getTrnTypeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
//        Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRN_TYPE_SELECT_LIST"));
	        preparedstatement.setString(1,getLanguageId());
	        preparedstatement.setString(2,getAcc_entity_id());
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }*/
	public String getTrn_type() throws Exception {	
		try	{
			ArrayList alParameters = new ArrayList();
			alParameters.add(getLanguageId());
			alParameters.add(getAcc_entity_id());
			return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_TYPE_SELECT_LIST"),alParameters));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


   
 /*   public String getReportType()
    {
        return getStaticListOptionTag("STBSTKS1,Item Consolidated;STBSTKS2,By Item;STBSTKS3,By Store;STBSTKS4,By Item-Batch;STBSTKS5,By Store-Batch;STBSTKS6,By Store-Bin Location;");
    } */
	public String getReportType()
    {
        return getStaticListOptionTag("STBMTSM1,Item Class Consolidated;STBMTSM2,Item Consolidated;STBMTSM3,Store-Item;STBMTSM4,Store-Item Class;");
    }

/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}
*/

    public String getReportOption()
    {
        return getStaticListOptionTag("A,Both;Q,Quantity;V,Value;");
    }

    
	

/*
    public String getAutoclavable()
    {
        return getStaticListOptionTag("A,All Items;Y,Autoclavable Only ;N,Non Autoclavable;");
    }

    public String getReorderable()
    {
        return getStaticListOptionTag("A,All Items;Y,Reorderable Only ;N,Non Reorderable;");
    }
*/
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


	public String getStore_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),getLoginFacilityId()));
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE")));
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

/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
}
