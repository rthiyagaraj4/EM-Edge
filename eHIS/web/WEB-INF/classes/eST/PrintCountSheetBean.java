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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import eST.PrintCountSheet.*;
public class PrintCountSheetBean extends StAdapter
implements Serializable
{

	String p_report_id;
	String p_fr_st_code;
	String p_to_st_code;
	String p_fm_item_code;
	String p_to_item_code;
	String p_fm_item_class;
	String p_to_item_class;
	String p_fr_alp_code;
	String p_to_alp_code;
	String p_fr_unit_cost;
	String p_to_unit_cost;
	String p_fr_st_val;
	String p_to_st_val;
	String p_fr_phy_inv;
	String p_phy_sel;
	String p_expiry_sel;
	String p_report_order;
	String p_item_anal1;
	String p_item_anal2;
	String p_item_anal3;
	String p_abc_sel;

	String curr_phy_inv_id;
	String p_phy_count_sel;
	ArrayList alTempRecords = new ArrayList();
	

	String p_fr_month;
	String p_fr_year;
	String p_to_month;
	String p_to_year;
	String p_count;
	String p_order_by_qty_value;
	String p_slow_fast_move;

	ArrayList ItemMoveArrayList =  new ArrayList(); 
	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
	String p_fm_bin_code;
	String p_to_bin_code;
	//Added ends

	public void clear()
	{
		p_report_id = "";
		p_fr_st_code = "";
		p_to_st_code = "";
		p_fm_item_code ="";
		p_to_item_code = "";
		p_fm_item_class = "";
		p_to_item_class = "";
		p_fr_alp_code ="";
		p_to_alp_code ="";
		p_fr_unit_cost = "";
		p_to_unit_cost = "";
		p_fr_st_val = "";
		p_to_st_val="";
		p_fr_phy_inv="";
		p_phy_sel = "";
		p_expiry_sel="";
		p_report_order="";
		p_item_anal1 = "";
		p_item_anal2 = "";
		p_item_anal3="";
		p_abc_sel="";
		p_phy_count_sel="";
		curr_phy_inv_id="";

		p_fr_month="";
		p_fr_year="";
		p_to_month="";
		p_to_year="";
		p_count="";
		p_order_by_qty_value="";
		p_slow_fast_move="";
		//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		p_fm_bin_code="";
		p_to_bin_code="";
		//Added ends
	}

	public String getCurr_phy_inv_id_for_rep()
	{
		return this.curr_phy_inv_id;
	}

	public void getCurr_phy_inv_id()
	{
		try
		{
			String s1 = fetchRecord(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_MODE"), getLoginFacilityId()).get("CURR_PHY").toString();
			this.curr_phy_inv_id = s1;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	public void setP_report_id(String s)
	{
		p_report_id = s.toUpperCase();
	}

	public void setP_fr_st_code(String s)
	{
		p_fr_st_code = s.toUpperCase();
	}
	public void setP_to_st_code(String s)
	{
		p_to_st_code = s.toUpperCase();
	}
	public void setP_fm_item_code(String s)
	{
		p_fm_item_code = s.toUpperCase();
	}
	public void setP_to_item_code(String s)
	{
		p_to_item_code = s.toUpperCase();
	}
	public void setP_fm_item_class(String s)
	{
		p_fm_item_class = s.toUpperCase();
	}
	public void setP_to_item_class(String s)
	{
		p_to_item_class = s.toUpperCase();
	}
	public void setP_fr_alp_code(String s)
	{
		p_fr_alp_code = s.toUpperCase();
	}
	public void setP_to_alp_code(String s)
	{
		p_to_alp_code = s.toUpperCase();
	}
	public void setP_fr_unit_cost(String s)
	{
		p_fr_unit_cost = s.toUpperCase();
	}
	public void setP_to_unit_cost(String s)
	{
		p_to_unit_cost = s.toUpperCase();
	}
	public void setP_fr_st_val(String s)
	{
		p_fr_st_val = s.toUpperCase();
	}
	public void setP_to_st_val(String s)
	{
		p_to_st_val = s.toUpperCase();
	}
	public void setP_fr_phy_inv(String s)
	{
		p_fr_phy_inv = s.toUpperCase();
	}
	public void setP_phy_sel(String s)
	{
		p_phy_sel = s.toUpperCase();
	}
	public void setP_expiry_sel(String s)
	{
		p_expiry_sel = s.toUpperCase();
	}
	public void setP_report_order(String s)
	{
		p_report_order = s.toUpperCase();
	}
	public void setP_item_anal1(String s)
	{
		p_item_anal1 = s.toUpperCase();
	}
	public void setP_item_anal2(String s)
	{
		p_item_anal2 = s.toUpperCase();
	}
	public void setP_item_anal3(String s)
	{
		p_item_anal3 = s.toUpperCase();
	}
	public void setP_abc_sel(String s)
	{
		p_abc_sel = s.toUpperCase();
	}
	public void setP_phy_count_sel(String s)
	{
		p_phy_count_sel = s.toUpperCase();
	}

	public void setP_fr_month(String s)
	{
		p_fr_month = s;
	}
	public void setP_fr_year(String s)
	{
		p_fr_year = s;
	}
	public void setP_to_month(String s)
	{
		p_to_month = s;
	}
	public void setP_to_year(String s)
	{
		p_to_year = s;
	}
	public void setP_count(String s)
	{
		p_count = s;
	}
	public void setP_order_by_qty_value(String s)
	{
		p_order_by_qty_value = s.toUpperCase();
	}
	public void setP_slow_fast_move(String s)
	{
		p_slow_fast_move = s.toUpperCase();
	}
	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
	public void setP_fm_bin_code(String s) {
		p_fm_bin_code = s.toUpperCase();
	}

	public void setP_to_bin_code(String s) {
		p_to_bin_code = s.toUpperCase();
	}
	//Added ends
	public void setAll(Hashtable hashtable)
	{	
		System.out.println("hashtable==179==>"+hashtable);
		setP_report_id((String)hashtable.get("p_report_mode"));
		setP_fr_st_code((String)hashtable.get("p_fr_st_code"));
		setP_to_st_code((String)hashtable.get("p_to_st_code"));
		setP_fm_bin_code((String)hashtable.get("p_fm_bin_code"));	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		setP_to_bin_code((String)hashtable.get("p_to_bin_code"));	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
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
		setP_expiry_sel((String)hashtable.get("p_expiry_sel"));
		setP_report_order((String)hashtable.get("p_report_id"));
		setP_item_anal1((String)hashtable.get("p_item_anal1"));
		setP_item_anal2((String)hashtable.get("p_item_anal2"));
		setP_item_anal3((String)hashtable.get("p_item_anal3"));
		setP_abc_sel((String)hashtable.get("p_abc_sel"));
		setP_phy_count_sel((String)hashtable.get("p_phy_count_sel"));

		setP_fr_month((String)hashtable.get("p_fr_month"));
		setP_fr_year((String)hashtable.get("p_fr_year"));
		setP_to_month((String)hashtable.get("p_to_month"));
		setP_to_year((String)hashtable.get("p_to_year"));
		setP_count((String)hashtable.get("p_count"));		
		setP_order_by_qty_value((String)hashtable.get("p_order_by_qty_value"));
		setP_slow_fast_move((String)hashtable.get("p_slow_fast_move"));

		try
		{
			getCurr_phy_inv_id();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	public HashMap insert(){
		ArrayList param_hdr = getArrayCodeListData();

		HashMap hashmap = new HashMap();
		ArrayList arraylist = new ArrayList();
		ArrayList allanguageData	=	new ArrayList();
		HashMap hashmap1 = new HashMap();
		HashMap hmResult = new HashMap();
		ArrayList arraylistSel = new ArrayList();
		String strQuery="";
		HashMap hmRecord = new HashMap();
		try{

			arraylist.add(getLoginFacilityId());
			arraylist.add(curr_phy_inv_id);
			arraylist.add(p_fr_st_code);
			arraylist.add(p_to_st_code);
			arraylist.add(p_fm_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
			arraylist.add(p_to_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
			arraylist.add(p_fm_item_code);
			arraylist.add(p_to_item_code);
			arraylist.add(p_phy_sel);
			arraylist.add(getLoginById());
			arraylist.add(getLoginAtWsNo());
			arraylist.add(getLoginFacilityId());
			arraylist.add(getLoginById());
			arraylist.add(getLoginAtWsNo());
			arraylist.add(getLoginFacilityId());
			arraylist.add(p_fr_phy_inv);
			arraylist.add(p_expiry_sel);
			arraylist.add(p_fm_item_class);
			arraylist.add(p_to_item_class);
			arraylist.add(p_fr_st_val);
			arraylist.add(p_to_st_val);
			arraylist.add(p_fr_unit_cost);
			arraylist.add(p_to_unit_cost);
			arraylist.add(p_item_anal1);
			arraylist.add(p_item_anal2);
			arraylist.add(p_item_anal3);
			arraylist.add(p_abc_sel);
			arraylist.add(p_report_id);
			arraylist.add(p_fr_alp_code);
			arraylist.add(p_to_alp_code);
			allanguageData.add(getLanguageId());
			
			System.out.println("insert arraylist 255 "+arraylist);
	

			hashmap.put("LANGUAGE_DATA",	allanguageData);
			hashmap.put("properties",		getProperties());
			if(param_hdr.size()>0){
				hashmap1.put("InsertParamSQL", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_INSERT_PRINTSHEET"));
				hashmap.put("InsertData", arraylist);
				hashmap.put("param_hdr", param_hdr);
				hashmap1.put("InsertHdrSQL", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR"));
			}
			ArrayList param_update_stitem   = getArrayCodeListUpdateStItem();
			ArrayList add_update			= new ArrayList();
			HashMap ItemMoveHashMap			= null;
			StringBuffer AddPlaceholder		= new StringBuffer();
			
			System.out.println("insert param_update_stitem 268 "+param_update_stitem);
			System.out.println("insert param_update_stitem ItemMoveArrayList 331 "+ItemMoveArrayList);
			
			if(!(p_slow_fast_move.equals(""))){

				for (int i=0;i<ItemMoveArrayList.size();i++ ){					
					AddPlaceholder.append("?,");
					ItemMoveHashMap = (HashMap)ItemMoveArrayList.get(i);
					arraylistSel.add((String)ItemMoveHashMap.get("ITEM_CODE"));
				}
				if(ItemMoveArrayList.size() == 0){
					AddPlaceholder.append("?,");
					arraylistSel.add("");
				}

				AddPlaceholder.deleteCharAt(AddPlaceholder.length()-1);

				arraylistSel.add(p_fr_st_code);
				arraylistSel.add(p_to_st_code);
				arraylistSel.add(p_fm_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				arraylistSel.add(p_to_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				arraylistSel.add(p_fm_item_class);
				arraylistSel.add(p_to_item_class);
				arraylistSel.add(p_fr_alp_code);
				arraylistSel.add(p_to_alp_code);
				arraylistSel.add(p_fr_unit_cost);
				arraylistSel.add(p_to_unit_cost);
				arraylistSel.add(p_fr_phy_inv);
				arraylistSel.add(p_phy_sel);
				arraylistSel.add(p_expiry_sel);
				arraylistSel.add(p_expiry_sel);
				arraylistSel.add(p_item_anal1);
				arraylistSel.add(p_item_anal2);
				arraylistSel.add(p_item_anal3);
				arraylistSel.add(p_abc_sel);
				arraylistSel.add(p_fr_st_val);
				arraylistSel.add(p_to_st_val);

			//	ArrayList add_update = new ArrayList();
				add_update.add(curr_phy_inv_id);
				add_update.add(getLoginById());
				add_update.add(getLoginAtWsNo());
				add_update.add(getLoginFacilityId());
				add_update.add(getLoginFacilityId());


				StringBuffer StBufSql1 = new StringBuffer();
				StringBuffer StBufSql2 = new StringBuffer();
				StringBuffer StBufSql3 = new StringBuffer();
				String StSql1 = "";
				String StSql2 = "";
				String StSql3 = "";

				if(p_phy_count_sel.equals("Z")){
					StSql1 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ZERO_FOR_NORECORD_NEW");
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					hmRecord		= 	(HashMap)fetchRecord(StBufSql1.toString(),arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "norecord");
						hmResult.put("result", false);
						return hmResult;
					}
					StBufSql1.delete(0,StBufSql1.length());
					
					StSql1 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ZERO_FOR_OVERLAP_NEW");
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					hmRecord		= 	(HashMap)fetchRecord(StBufSql1.toString(),arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "overlap");
						hmResult.put("result", false);
						return hmResult;
					}

					StSql2 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_STORE_ZERO_NEW");
					StBufSql2.append(StSql2);
					StBufSql2.replace(StSql2.indexOf('@'),StSql2.indexOf('@')+1,AddPlaceholder.toString());				

					StSql3 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_BATCH_ZERO_NEW");
					StBufSql3.append(StSql3);
					StBufSql3.replace(StSql3.indexOf('@'),StSql3.indexOf('@')+1,AddPlaceholder.toString());
					
					hashmap1.put("Updatestitem", StBufSql2.toString());
					hashmap.put("UpdateData", param_update_stitem);
					hashmap1.put("Updatestbatch", StBufSql3.toString());
				}
				else if(p_phy_count_sel.equalsIgnoreCase("N")){
					
					StSql1 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_NON_ZERO_FOR_NORECORD_NEW");
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					hmRecord		= 	(HashMap)fetchRecord(StBufSql1.toString(),arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "norecord");
						hmResult.put("result", false);
						return hmResult;
					}
					StBufSql1.delete(0,StBufSql1.length());
					
					StSql1 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_NON_ZERO_FOR_OVERLAP_NEW");					
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					hmRecord		= 	(HashMap)fetchRecord(StBufSql1.toString(),arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "overlap");
						hmResult.put("result", false);
						return hmResult;
					}

					StSql2 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_STORE_NON_ZERO_NEW");
					StBufSql2.append(StSql2);
					StBufSql2.replace(StSql2.indexOf('@'),StSql2.indexOf('@')+1,AddPlaceholder.toString());				

					StSql3 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_BATCH_NON_ZERO_NEW");
					StBufSql3.append(StSql3);
					StBufSql3.replace(StSql3.indexOf('@'),StSql3.indexOf('@')+1,AddPlaceholder.toString());
					
					hashmap1.put("Updatestitem", StBufSql2.toString());
					hashmap.put("UpdateData", param_update_stitem);
					hashmap1.put("Updatestbatch", StBufSql3.toString());



				}
				else{										

					StSql1 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ALL_FOR_NORECORD_NEW");					
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					hmRecord		= 	(HashMap)fetchRecord(StBufSql1.toString(),arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "norecord");
						hmResult.put("result", false);
						return hmResult;
					}
					StBufSql1.delete(0,StBufSql1.length());
				
					StSql1 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ALL_FOR_OVERLAP_NEW");
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					hmRecord		= 	(HashMap)fetchRecord(StBufSql1.toString(),arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "overlap");
						hmResult.put("result", false);
						return hmResult;
					}

					StSql2 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_STORE_ALL_NEW");
					StBufSql2.append(StSql2);
					StBufSql2.replace(StSql2.indexOf('@'),StSql2.indexOf('@')+1,AddPlaceholder.toString());				

					StSql3 = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_BATCH_ALL_NEW");
					StBufSql3.append(StSql3);
					StBufSql3.replace(StSql3.indexOf('@'),StSql3.indexOf('@')+1,AddPlaceholder.toString());
					
					hashmap1.put("Updatestitem", StBufSql2.toString());
					hashmap.put("UpdateData", param_update_stitem);
					hashmap1.put("Updatestbatch", StBufSql3.toString());



				}

					hashmap.put("UpdateParamData", add_update);
					hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_PARAM"));

			}else{
				arraylistSel.add(p_fm_item_code);
				arraylistSel.add(p_to_item_code);
				arraylistSel.add(p_fr_st_code);
				arraylistSel.add(p_to_st_code);
				arraylistSel.add(p_fm_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				arraylistSel.add(p_to_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				arraylistSel.add(p_fm_item_class);
				arraylistSel.add(p_to_item_class);
				arraylistSel.add(p_fr_alp_code);
				arraylistSel.add(p_to_alp_code);
				arraylistSel.add(p_fr_unit_cost);
				arraylistSel.add(p_to_unit_cost);
				arraylistSel.add(p_fr_phy_inv);
				arraylistSel.add(p_phy_sel);
				arraylistSel.add(p_expiry_sel);
				arraylistSel.add(p_expiry_sel);
				arraylistSel.add(p_item_anal1);
				arraylistSel.add(p_item_anal2);
				arraylistSel.add(p_item_anal3);
				arraylistSel.add(p_abc_sel);
				arraylistSel.add(p_fr_st_val);
				arraylistSel.add(p_to_st_val);

			//	ArrayList add_update = new ArrayList();
				add_update.add(curr_phy_inv_id);
				add_update.add(getLoginById());
				add_update.add(getLoginAtWsNo());
				add_update.add(getLoginFacilityId());
				add_update.add(getLoginFacilityId());

				if(p_phy_count_sel.equalsIgnoreCase("Z")){
					strQuery = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ZERO_FOR_NORECORD");
					hmRecord		= 	(HashMap)fetchRecord(strQuery,arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "norecord");
						hmResult.put("result", false);
						return hmResult;
					}
					strQuery = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ZERO_FOR_OVERLAP");
					hmRecord		= 	(HashMap)fetchRecord(strQuery,arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "overlap");
						hmResult.put("result", false);
						return hmResult;
					}
					hashmap1.put("Updatestitem", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_STORE_ZERO"));
					hashmap.put("UpdateData", param_update_stitem);
					hashmap1.put("Updatestbatch", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_BATCH_ZERO"));
					hashmap.put("UpdateParamData", add_update);
					hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_PARAM"));
				}
				else if(p_phy_count_sel.equalsIgnoreCase("N")){
										strQuery = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_NON_ZERO_FOR_NORECORD");
					hmRecord = (HashMap)fetchRecord(strQuery,arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "norecord");
						hmResult.put("result", false);
						return hmResult;
					}
					strQuery = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_NON_ZERO_FOR_OVERLAP");
					hmRecord = (HashMap)fetchRecord(strQuery,arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "overlap");
						hmResult.put("result", false);
						return hmResult;
					}
					hashmap1.put("Updatestitem", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_STORE_NON_ZERO"));
					hashmap.put("UpdateData", param_update_stitem);
					hashmap1.put("Updatestbatch", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_BATCH_NON_ZERO"));
					hashmap.put("UpdateParamData", add_update);
					hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_PARAM"));
				}
				else{
					strQuery = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ALL_FOR_NORECORD");
					hmRecord = (HashMap)fetchRecord(strQuery,arraylistSel);
			
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "norecord");
						hmResult.put("result", false);
						return hmResult;
					}
					strQuery = getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_COUNT_ALL_FOR_OVERLAP");
					hmRecord = (HashMap)fetchRecord(strQuery,arraylistSel);
					if(((String)hmRecord.get("COUNT")).equals("0")){
						hmResult.put("flag", "overlap");
						hmResult.put("result", false);
						return hmResult;
					}
					hashmap1.put("Updatestitem", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_STORE_ALL"));
					hashmap.put("UpdateData", param_update_stitem);
					hashmap1.put("Updatestbatch", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_BATCH_ALL"));
					hashmap.put("UpdateParamData", add_update);
					hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_PARAM"));
				}
			}


		System.out.println("hashmap====587===============>"+hashmap);
		System.out.println("hashmap1====587===============>"+hashmap1);

			hmResult	=	dipatchingMethodCall(hashmap, hashmap1);
			hmResult.put("flag", curr_phy_inv_id);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}

		return hmResult;

	}
	public HashMap dipatchingMethodCall(HashMap hashmap, HashMap hashmap1)
	{
		HashMap hashmap2 = new HashMap();
		try
		{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_PRINT_COUNT_SHEET"),eST.PrintCountSheet.PrintCountSheetHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmap1;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmap1.getClass();

			hashmap2 = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		}
		catch(Exception exception) {
		exception.printStackTrace();}

		if(((Boolean)hashmap2.get("result")).booleanValue())
		hashmap2.put( "message", getSTMessage(getLanguageId(),(String) hashmap2.get( "msgid" ),"ST") ) ;
		else
		if(hashmap2.get("msgid") != null)
		hashmap2.put( "message", getSTMessage(getLanguageId(),(String) hashmap2.get( "msgid" ),"ST")) ;
		else
		hashmap2.put("message", replaceNewLineChar((String)hashmap2.get("message")));
		return hashmap2;
	}

	public ArrayList getArrayCodeListData()  {


		System.out.println("getArrayCodeListData");

		ArrayList alRecords_CodeList = null;
		ArrayList alRecords	= new ArrayList();
		this.alTempRecords = new ArrayList();

		this.ItemMoveArrayList =  new ArrayList(); //added for 29974	Bru-HIMS-CRF-099  Wednesday, September 05, 2012 By Ganga
		ArrayList ItemMoveParam =  new ArrayList(); //added for 29974	Bru-HIMS-CRF-099  Wednesday, September 05, 2012 By Ganga

		try{
			ArrayList alParameters_CodeList = new ArrayList();			
			
			if(!(p_slow_fast_move.equals(""))){
				ItemMoveParam.add(p_fm_item_code);
				ItemMoveParam.add(p_to_item_code);
				ItemMoveParam.add(p_fr_st_code);
				ItemMoveParam.add(p_to_st_code);
				ItemMoveParam.add(p_fr_month);
				ItemMoveParam.add(p_fr_year);
				ItemMoveParam.add(p_to_month);
				ItemMoveParam.add(p_to_year);
				ItemMoveParam.add(p_count);

				System.out.println("getArrayCodeListData 536 ItemMoveParam "+ItemMoveParam);

				String ItemMoveSql = "SELECT ITEM_CODE,ITEM_DESC,CONSUMPTION_QTY,CONSUMPTION_VALUE FROM (SELECT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,SUM(-1* (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) CONSUMPTION_QTY,SUM(-1* (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) CONSUMPTION_VALUE FROM ST_ITEM_MOVE_SUMM A,MM_ITEM B WHERE A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE BETWEEN NVL(?,'!') AND NVL(?,'~') AND STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~') AND TO_DATE (MOVE_MONTH || '/' || MOVE_YEAR, 'mm/yyyy')  BETWEEN TO_DATE (?|| '/'||?,'mm/yyyy')  AND TO_DATE (?|| '/'||?,'mm/yyyy')  GROUP BY A.ITEM_CODE,B.SHORT_DESC ";
				
				String OrderByColumn="";
				if(p_order_by_qty_value.equals("Q")){
					if(p_slow_fast_move.equals("F")){
						ItemMoveSql = ItemMoveSql + " order by CONSUMPTION_QTY DESC,B.SHORT_DESC ASC) WHERE ROWNUM <= ?" ;
						OrderByColumn	=  " order by CONSUMPTION_QTY DESC,SHORT_DESC ASC";	
					}	
					else if(p_slow_fast_move.equals("S")){
						ItemMoveSql = ItemMoveSql + " order by CONSUMPTION_QTY ASC,B.SHORT_DESC ASC) WHERE ROWNUM <= ?" ;
						OrderByColumn	=  " order by CONSUMPTION_QTY ASC,SHORT_DESC ASC";
					}
				}
				else if(p_order_by_qty_value.equals("V")){
					if(p_slow_fast_move.equals("F")){
						ItemMoveSql = ItemMoveSql + " order by CONSUMPTION_VALUE DESC,B.SHORT_DESC ASC) WHERE ROWNUM <= ?" ;
						OrderByColumn	=  " order by CONSUMPTION_VALUE DESC,SHORT_DESC ASC";
					}
					else if(p_slow_fast_move.equals("S")){
						ItemMoveSql = ItemMoveSql + " order by CONSUMPTION_VALUE ASC,B.SHORT_DESC ASC) WHERE ROWNUM <= ?" ;
						OrderByColumn	=  " order by CONSUMPTION_VALUE ASC,SHORT_DESC ASC";
					}
				}				
				
				ItemMoveArrayList = (ArrayList)fetchRecords(ItemMoveSql,ItemMoveParam);
		
				HashMap ItemMoveHashMap = null;
				StringBuffer AddPlaceholder	=	new StringBuffer();
				
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(curr_phy_inv_id);
				alParameters_CodeList.add(getLoginById());
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(getLoginById());
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());

				alParameters_CodeList.add(p_fr_month);
				alParameters_CodeList.add(p_fr_year);
				alParameters_CodeList.add(p_to_month);
				alParameters_CodeList.add(p_to_year);
				alParameters_CodeList.add(p_fr_month);
				alParameters_CodeList.add(p_fr_year);
				alParameters_CodeList.add(p_to_month);
				alParameters_CodeList.add(p_to_year);

				for (int i=0;i<ItemMoveArrayList.size();i++ ){					
					AddPlaceholder.append("?,");
					ItemMoveHashMap = (HashMap)ItemMoveArrayList.get(i);
					alParameters_CodeList.add((String)ItemMoveHashMap.get("ITEM_CODE"));
				}
				if(ItemMoveArrayList.size() == 0){
					AddPlaceholder.append("?,");
					alParameters_CodeList.add("");
				}

				AddPlaceholder.deleteCharAt(AddPlaceholder.length()-1);

				alParameters_CodeList.add(p_fr_st_code);
				alParameters_CodeList.add(p_to_st_code);
				alParameters_CodeList.add(p_fm_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				alParameters_CodeList.add(p_to_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				alParameters_CodeList.add(p_fm_item_class);
				alParameters_CodeList.add(p_to_item_class);
				alParameters_CodeList.add(p_fr_alp_code);
				alParameters_CodeList.add(p_to_alp_code);
				alParameters_CodeList.add(p_fr_unit_cost);
				alParameters_CodeList.add(p_to_unit_cost);
				alParameters_CodeList.add(p_fr_phy_inv);
				alParameters_CodeList.add(p_phy_sel);
				alParameters_CodeList.add(p_expiry_sel);
				alParameters_CodeList.add(p_expiry_sel);
				alParameters_CodeList.add(p_item_anal1);
				alParameters_CodeList.add(p_item_anal2);
				alParameters_CodeList.add(p_item_anal3);
				alParameters_CodeList.add(p_abc_sel);
				alParameters_CodeList.add(p_fr_st_val);
				alParameters_CodeList.add(p_to_st_val);
				System.out.println("getArrayCodeListData 718 alParameters_CodeList "+alParameters_CodeList);
				StringBuffer StBufSql1 = new StringBuffer();
				StringBuffer StBufSql2 = new StringBuffer();
				String StSql1 = "";
				String StSql2 = "";

				if(p_phy_count_sel.equals("Z")){

					StSql1 = (String)getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ZERO_NEW");
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					alRecords	= (ArrayList)fetchRecords(StBufSql1.toString(), alParameters_CodeList);
				}else if(p_phy_count_sel.equals("N")){
					
					StSql1 = (String)getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_NON_ZERO_NEW");
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					alRecords	= (ArrayList)fetchRecords(StBufSql1.toString(), alParameters_CodeList);
				}else{					
					StSql1 = (String)getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ALL_NEW");
					StSql1 = StSql1 + OrderByColumn;
					StBufSql1.append(StSql1);
					StBufSql1.replace(StSql1.indexOf('@'),StSql1.indexOf('@')+1,AddPlaceholder.toString());
					alRecords	= (ArrayList)fetchRecords(StBufSql1.toString(), alParameters_CodeList);
				}	
					StSql2	= (String)getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ALL_TEMP");
					//Modified by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
					StSql2  = "SELECT DISTINCT ? FACILITY_ID, ? PHY_INV_ID, ? ADDED_BY_ID,SYSDATE ADDED_DATE, ? ADDED_AT_WS_NO, ? ADDED_FACILITY_ID, ? MODIFIED_BY_ID,SYSDATE MODIFIED_DATE, ? MODIFIED_AT_WS_NO, ? MODIFIED_FACILITY_ID, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE,(SELECT   SUM (  -1  * (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0)))  FROM st_item_move_summ mv  WHERE mv.item_code = a.item_code AND mv.store_code = a.store_code AND TO_DATE (move_month || '/' || move_year, 'mm/yyyy')  BETWEEN TO_DATE (? || '/' || ?, 'mm/yyyy') AND TO_DATE (? || '/' || ?, 'mm/yyyy') )consumption_qty,(SELECT  SUM (  -1 * (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) FROM st_item_move_summ mv  WHERE mv.item_code = a.item_code AND mv.store_code = a.store_code AND TO_DATE (move_month || '/' || move_year, 'mm/yyyy')  BETWEEN TO_DATE (? || '/' || ?, 'mm/yyyy') AND TO_DATE (? || '/' || ? , 'mm/yyyy') )consumption_value FROM ST_ITEM_STORE A, ST_ITEM B,ST_STORE C, MM_ITEM D, st_item_store_bin_locn E WHERE A.ITEM_CODE=B.ITEM_CODE AND A.STORE_CODE=C.STORE_CODE AND A.ITEM_CODE=D.ITEM_CODE AND (A.ITEM_CODE in (@)) AND (C.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND (E.BIN_LOCATION_CODE between NVL(?,'!') and NVL(?,'~')) AND (D.ITEM_CLASS_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND (D.ALPHA_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND (NVL(D.UNIT_COST,0) BETWEEN NVL(?,0) AND NVL(?,999999999999)) AND A.PHY_INV_ID IS NULL AND A.STOCK_ITEM_YN='Y' AND C.VAR_ALLOWED_YN='Y' AND NVL(B.PHY_INV_TYPE,'%') LIKE NVL(?,'%') AND B.PHY_INV_COUNT_PER_YEAR=NVL(?,B.PHY_INV_COUNT_PER_YEAR) AND B.EXPIRY_YN LIKE DECODE(?,'A','%',?) AND NVL(D.ITEM_ANAL1_CODE,'*') = NVL(?,NVL(D.ITEM_ANAL1_CODE,'*')) AND NVL(D.ITEM_ANAL2_CODE,'*') = NVL(?,NVL(D.ITEM_ANAL2_CODE,'*')) AND NVL(D.ITEM_ANAL3_CODE,'*') = NVL(?,NVL(D.ITEM_ANAL3_CODE,'*')) AND B.ABC_CLASS_CODE = NVL(?,B.ABC_CLASS_CODE) AND (NVL(A.ITEM_VALUE,0) BETWEEN NVL(?,0) AND NVL(?,999999999999)) AND A.STORE_CODE = E.STORE_CODE AND A.ITEM_CODE = E.ITEM_CODE AND E.EFF_STATUS='Y'";
					StBufSql2.append(StSql2);
					StBufSql2.replace(StSql2.indexOf('@'),StSql2.indexOf('@')+1,AddPlaceholder.toString());
					this.alTempRecords	= (ArrayList)fetchRecords(StBufSql2.toString(), alParameters_CodeList);

					System.out.println("getArrayCodeListData 745 alParameters_CodeList"+alParameters_CodeList);
					System.out.println("getArrayCodeListData 745 StBufSql2"+StBufSql1.toString());
			}else{

				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(curr_phy_inv_id);
				alParameters_CodeList.add(getLoginById());
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(getLoginById());
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(p_fm_item_code);
				alParameters_CodeList.add(p_to_item_code);
				alParameters_CodeList.add(p_fr_st_code);
				alParameters_CodeList.add(p_to_st_code);
				alParameters_CodeList.add(p_fm_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				alParameters_CodeList.add(p_to_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
				alParameters_CodeList.add(p_fm_item_class);
				alParameters_CodeList.add(p_to_item_class);
				alParameters_CodeList.add(p_fr_alp_code);
				alParameters_CodeList.add(p_to_alp_code);
				alParameters_CodeList.add(p_fr_unit_cost);
				alParameters_CodeList.add(p_to_unit_cost);
				alParameters_CodeList.add(p_fr_phy_inv);
				alParameters_CodeList.add(p_phy_sel);
				alParameters_CodeList.add(p_expiry_sel);
				alParameters_CodeList.add(p_expiry_sel);
				alParameters_CodeList.add(p_item_anal1);
				alParameters_CodeList.add(p_item_anal2);
				alParameters_CodeList.add(p_item_anal3);
				alParameters_CodeList.add(p_abc_sel);
				alParameters_CodeList.add(p_fr_st_val);
				alParameters_CodeList.add(p_to_st_val);
			
				System.out.println("getArrayCodeListData 547");

				if(p_phy_count_sel.equals("Z")){
					alRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ZERO"), alParameters_CodeList);
					this.alTempRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ZERO_TEMP"), alParameters_CodeList);
				}else if(p_phy_count_sel.equals("N")){
					alRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_NON_ZERO"), alParameters_CodeList);
					this.alTempRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_NON_ZERO_TEMP"), alParameters_CodeList);
				}else{
					alRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ALL"), alParameters_CodeList);
					this.alTempRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR_SELECT_ALL_TEMP"), alParameters_CodeList);		
				}
			}
			


			System.out.println("getArrayCodeListData alRecords "+alRecords);

			alRecords_CodeList = new ArrayList();

			for(int i=0;i<alRecords.size();i++)	{
				ArrayList a = new ArrayList();
				HashMap m = (HashMap)alRecords.get(i);
				a.add(m.get("FACILITY_ID"));
				a.add(m.get("PHY_INV_ID"));
				a.add(m.get("ADDED_BY_ID"));
				a.add(m.get("ADDED_AT_WS_NO"));
				a.add(m.get("ADDED_FACILITY_ID"));
				a.add(m.get("MODIFIED_BY_ID"));
				a.add(m.get("MODIFIED_AT_WS_NO"));
				a.add(m.get("MODIFIED_FACILITY_ID"));
				a.add(m.get("STORE_CODE"));
				a.add(m.get("ITEM_CODE"));
				alRecords_CodeList.add(a);
			}
			System.out.println("getArrayCodeListData  477 alRecords_CodeList "+alRecords_CodeList);

		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		return alRecords_CodeList;
	}

	//to update St_item_store
	public ArrayList getArrayCodeListUpdateStItem()  {
		ArrayList alParameters_UpdateStItem = new ArrayList();
		HashMap ItemMoveHashMap = new HashMap();
		alParameters_UpdateStItem.add(curr_phy_inv_id);
		alParameters_UpdateStItem.add(getLoginById());
		alParameters_UpdateStItem.add(getLoginAtWsNo());
		alParameters_UpdateStItem.add(getLoginFacilityId());	
		
		if(!(p_slow_fast_move.equals(""))){
			for (int i=0;i<ItemMoveArrayList.size();i++ ){					
				ItemMoveHashMap = (HashMap)ItemMoveArrayList.get(i);
				alParameters_UpdateStItem.add((String)ItemMoveHashMap.get("ITEM_CODE"));
			}
		}else{
				alParameters_UpdateStItem.add(p_fm_item_code);
				alParameters_UpdateStItem.add(p_to_item_code);
		}


		alParameters_UpdateStItem.add(p_fr_st_code);
		alParameters_UpdateStItem.add(p_to_st_code);
		alParameters_UpdateStItem.add(p_fm_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		alParameters_UpdateStItem.add(p_to_bin_code);	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		alParameters_UpdateStItem.add(p_fm_item_class);
		alParameters_UpdateStItem.add(p_to_item_class);
		alParameters_UpdateStItem.add(p_fr_alp_code);
		alParameters_UpdateStItem.add(p_to_alp_code);
		alParameters_UpdateStItem.add(p_fr_unit_cost);
		alParameters_UpdateStItem.add(p_to_unit_cost);
		alParameters_UpdateStItem.add(p_fr_phy_inv);
		alParameters_UpdateStItem.add(p_phy_sel);
		alParameters_UpdateStItem.add(p_expiry_sel);
		alParameters_UpdateStItem.add(p_expiry_sel);
		alParameters_UpdateStItem.add(p_item_anal1);
		alParameters_UpdateStItem.add(p_item_anal2);
		alParameters_UpdateStItem.add(p_item_anal3);
		alParameters_UpdateStItem.add(p_abc_sel);
		alParameters_UpdateStItem.add(p_fr_st_val);
		alParameters_UpdateStItem.add(p_fr_st_val);
		return alParameters_UpdateStItem;
	}

	public ArrayList getArrayCodeList(){
		ArrayList arraylist = new ArrayList();
		try{
			arraylist=fetchRecords(getStRepositoryValue("SQL_ST_ITEM_ANALYSIS"),getLanguageId());
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		return arraylist;
	}

	public String getReportType()
	{
		return getStaticListOptionTag("STBSTKS1,Item Consolidated;STBSTKS2,By Item;STBSTKS3,By Store Batch;STBSTKS4,By Bin-Store location;STBSTKS5,By Store;STBSTKS6,By Item Batch;");
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

	public String getBatchSelection()
	{
		return getStaticListOptionTag("A,All Batches;Y,Suspended Batches;N,Active Batches;");
	}


	public String getReportOrder()
	{
		return getStaticListOptionTag("I,Item Code;S,Short Description;");
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

	public HashMap validate(){
		HashMap hashmap = new HashMap();
		ArrayList param_hdr = getArrayCodeListData();
		if (param_hdr.size() > 0)
		{
			hashmap.put("result", super.TRUE);
		}//added newly by ganga
		else if(!(p_slow_fast_move.equals("")))
		{
			if(this.alTempRecords.size()==0 && param_hdr.size() == 0){
					hashmap.put("flag", "norecord");
					hashmap.put("result", super.FALSE);
			}
		}//added ended
		else if(this.alTempRecords.size()==0 && param_hdr.size() == 0)
		{
			hashmap.put("result", super.FALSE);
		}else{
			return getMessageHashMap(true);
		}
		return hashmap;
	}

	public String getStore_code_List(){
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),
		arr_language));
	}
	public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}

}
