/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ReportsStockStatusBean extends StAdapter
    implements Serializable
{
 //private String language;
	
    public ArrayList getArrayCodeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
     //   Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"));
	        preparedstatement.setString(1,getLanguageId());
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
   
/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}
*/
 /*   public String getReportType()
    {
        return getStaticListOptionTag("STBSTKS1,Item Consolidated;STBSTKS2,By Item;STBSTKS3,By Store;STBSTKS4,By Item-Batch;STBSTKS5,By Store-Batch;STBSTKS6,By Store-Bin Location;");
    } */
	public String getReportType()
    {
        return getStaticListOptionTag("STBSTKS1,Item Consolidated;STBSTKS2,By Item Store;STBSTKS3,By Store Batch;STBSTKS4,By Store Bin Location;STBSTKS5,By Store;STBSTKS6,By Item Batch;");
    }

    public String getItemSelection()
    {
        return getStaticListOptionTag("AL,All Items;ZO,Zero Stock Items;LR,Item Less than Reorder Level;LM,Item Less than Minimum Level;IS,Item with Stock;MS,Item Greater than Maximum Level");
    }

    public String getExpirySelection()
    {
        return getStaticListOptionTag("A,All Items;Y,Expiry Items;N,Non Expiry Items");
    }

    public String getStockPostion()
    {
        return getStaticListOptionTag("A,All Stores;Y,Reorderable Stores stock;N,Non Reorderable Stores Stock");
    }

	public String getConsignSelection()
    {
        return getStaticListOptionTag("A,All;Y,Consignment;N,Non Consignment");
    }

	 public String getNatureSelection()
    {
        return getStaticListOptionTag("A,Both;E,Enabled;D,Disabled");
    }
    
	public String getBatchSelection()
    {
        return getStaticListOptionTag("A,All Batches;Y,Suspended Batches;N,Active Batches;");
    }

    
    public String getReportOrder()
    {
        return getStaticListOptionTag("I,Item Code;S,Short Description;V,Item Value;");
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



	public String getStore_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),getLoginFacilityId()));
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE")));
	}

   // public String module_id;
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
