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
import eST.Common.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class StockCardReportBean  extends StTransaction    implements Serializable
{
    public String getNature()
    {
        return getStaticListOptionTag("B,Both;E,Enabled;D,Disabled;");
    }


    public String getOrderByItemForStore()
    {
        return getStaticListOptionTag("1,Item Description; 2,Store Code;");
    }
	
	public String getStore_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),getLoginFacilityId()));
	  }
     public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	   }
	   
	   /*public String getTrn_Type_List(){
		return getListOptionTag(getListOptionArrayList("SELECT TRN_TYPE,SHORT_DESC FROM st_trn_type_lang_vw  WHERE  language_id= ? order by short_desc",getLanguageId()));
	   }*/

     
}
