/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
//* pmd 21/02/2005
//*import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class RecalculateItemStockLevel extends StAdapter
    implements Serializable
{
	
	/*private String language_id;

public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/

 
	String p_cons_per;
    String p_lead_days;
    String p_min_stk_days;
	String p_buffer_perc;
	
	void setP_buffer_perc(String p_buffer_perc){
		this.p_buffer_perc=p_buffer_perc;
	}

	String getP_buffer_perc(){
		return this.p_buffer_perc;
	}

	public void clear()
    {
		p_cons_per = "";
		p_lead_days = "";
        p_min_stk_days = "";
		p_buffer_perc ="";
		
    }

	public void setAll(Hashtable hashtable)  {
		p_cons_per = (String)hashtable.get("p_cons_per");
		p_lead_days = (String)hashtable.get("p_lead_days");
        p_min_stk_days = (String)hashtable.get("p_min_stk_days");
		p_buffer_perc =(String)hashtable.get("p_buffer_perc");
    }

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;

		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		alModifyData.add(	p_cons_per    		);
		alModifyData.add(	p_lead_days   		);
		alModifyData.add(	p_min_stk_days		);
		alModifyData.add(	p_buffer_perc 		);

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
			hmTableData.put("LanguageData",LanguageData);
		hmSQLMap.put	( "ModifySQL", getStRepositoryValue("SQL_ST_MACHINE_CODE_UPDATE"));

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	/*
		public void setAll(Hashtable hashtable)
    {
        setP_report_id((String)hashtable.get("p_report_id"));
		setP_fr_st_code((String)hashtable.get("p_fr_st_code")); 
        setP_to_st_code((String)hashtable.get("p_to_st_code")); 
		setP_fm_item_code((String)hashtable.get("p_fm_item_code"));
		setP_to_item_code((String)hashtable.get("p_to_item_code"));
		setP_fm_item_class((String)hashtable.get("p_fm_item_class"));
		setP_to_item_class((String)hashtable.get("p_to_item_class"));
		setP_fr_alp_code((String)hashtable.get("p_fr_alp_code")); 
		setP_to_alp_code((String)hashtable.get("p_to_alp_code")); 
		setP_fr_unit_cost((String)hashtable.get("p_fr_unit_cost"));
		setP_to_unit_cost((String)hashtable.get("p_to_unit_cost"));
		setP_fr_st_val((String)hashtable.get("p_fr_st_val")); 
		setP_to_st_val((String)hashtable.get("p_to_st_val"));
		setP_fr_phy_inv((String)hashtable.get("p_fr_phy_inv"));
		setP_phy_sel((String)hashtable.get("p_phy_sel")); 
		//setP_item_sel((String)hashtable.get("p_item_sel"));
		setP_expiry_sel((String)hashtable.get("p_expiry_sel"));
		setP_report_order((String)hashtable.get("p_report_order"));
		setP_item_anal1((String)hashtable.get("p_item_anal1")); 
		setP_item_anal2((String)hashtable.get("p_item_anal2")); 
		setP_item_anal3((String)hashtable.get("p_item_anal3"));
		setP_abc_sel((String)hashtable.get("p_abc_sel"));*/
	
    public String getReportType()
    {

        return getStaticListOptionTag("A,All Items ;O,Only Changed Item ;NO,Only UnChanged Item;");
    }
     public String getReportOrder()
    {
        return getStaticListOptionTag("I,Item Code;S,Short Description;");
    }
}
