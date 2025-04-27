/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
15/07/2014				43320					Abdul Rabbani	                                    		AMRI-CRF-100019
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 
 package eST;
//import eCommon.Common.CommonAdapter;
//import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.sql.*;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import eST.PhyInvForSpecificItem.*;

import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.util.*;

public class PhyInvForSpecificItemBean extends StTransaction implements Serializable{

	private String facility_id;
	private String item_from;
	private String item_to;
	private String store_code;
	private String temp_phy_id;//for query perpose
	
	private HashMap data_list;
	private HashMap data_list_1;
	private int flag = 0;

	private String checkBoxVals;
	private String spec_phy_inv_id;
	private String remarks;
	private String finalized_yn;
	private String temp_id;
	private String curr_phy_inv_id;
	//private String language_id;
	private String item_class_code; //ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014

	public void clear(){
	item_from = "";
	item_to = "";
	store_code = "";
	item_class_code = "";  //ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014
	data_list = new HashMap();
	}
	
	public void setTemp_phy_id(String temp_phy_id)
	{
		this.temp_phy_id = temp_phy_id;
	}
/*public void setLanguageId(String language_id)
	{
		this.language_id = language_id;
	}
	public String getLanguageId()
	{
		return language_id;
	}*/
	public void clear_data(){
		if(flag == 0)	data_list = new HashMap();
		flag = 1;
	}

//calling when need to clear data_list by using success() method of java script
	public void clear_data_added(){
		data_list = new HashMap();
		flag = 0;
	}

	public void setDefaultParameter(HashMap m) {
		item_from = (String) m.get("item_codeF");
		item_to	= (String) m.get("item_codeT");
		store_code	= (String) m.get("store_code");
		item_class_code = (String)m.get("item_class_code"); //ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014
	}

	public void setFacility_id(String facility_id)
	{
		this.facility_id = facility_id;
	}

	public String getStore() throws Exception {	
		try	{
			ArrayList arr_language=new ArrayList();
			arr_language.add(this.facility_id);
			arr_language.add(getLanguageId());
			arr_language.add(getLoginById());
			return getListOptionTag(getListOptionArrayList("SELECT A.STORE_CODE, B.SHORT_DESC FROM ST_STORE A, MM_STORE_LANG_VW B,ST_USER_ACCESS_FOR_STORE UAS WHERE A.STORE_CODE = B.STORE_CODE AND B.EFF_STATUS = 'E' AND B.FACILITY_ID = ? AND B.LANGUAGE_ID = ? AND UAS.USER_ID = ? AND UAS.STORE_CODE = A.STORE_CODE AND UAS.VAR_ALLOWED_YN = 'Y' ORDER BY B.SHORT_DESC",arr_language));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTempphyid() throws Exception {	
		try	{
			return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_TEMP_ID"),this.facility_id));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

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
	
	public void loadData_toHash() {
		try{
		    String item_class = checkForNull(this.item_class_code,"");
			ArrayList alRecords	= new ArrayList();
			ArrayList alParameters = new ArrayList();
			alParameters.add(this.item_from);
			alParameters.add(this.item_to);
			alParameters.add(this.store_code);
			//ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014
			if(!item_class.equals("") && !item_class.equals("%")){
			alParameters.add(this.item_class_code);   
			}
			alParameters.add(getLanguageId());
			HashMap alRec_m = new HashMap();
			//ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014 starts
			if(item_class.equals("") || item_class.equals("%")){
			 alRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_ADDED_ITEM"), alParameters);
			}else{
			   alRecords	= (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_BY_ITEM_CLASS"), alParameters);
               }
			   //ends			   
			   for(int i=0;i<alRecords.size();i++){
				alRec_m = (HashMap)alRecords.get(i);
				String s = (String)alRec_m.get("ITEM_DESC");
				s = s + (String)alRec_m.get("STORE_DESC");
				data_list.put(s,(HashMap)alRecords.get(i));
			}
		}catch(Exception ex){
			ex.printStackTrace(); 
		}	
	}
	public void loadData_toHash_temp_query() {
		try{
			ArrayList alParameters_temp_1 = new ArrayList();
			alParameters_temp_1.add(getLoginFacilityId());
			alParameters_temp_1.add(this.temp_phy_id);
			alParameters_temp_1.add(getLanguageId());
			HashMap alRec_m_temp_1 = new HashMap();
			data_list_1= new HashMap();
			ArrayList alRecords_temp_1 = fetchRecords(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_SELECT_DTL"), alParameters_temp_1);
			for(int i=0;i<alRecords_temp_1.size();i++){
				alRec_m_temp_1 = (HashMap)alRecords_temp_1.get(i);
				String s_1 = (String)alRec_m_temp_1.get("ITEM_DESC");
				s_1 = s_1 + (String)alRec_m_temp_1.get("STORE_DESC");
				data_list_1.put(s_1,(HashMap)alRecords_temp_1.get(i));
			}
		}catch(Exception ex){
			ex.printStackTrace(); 
		}	
	}
	/*public ArrayList get_Data()	{
			try{
					ArrayList data_arr_1 = new ArrayList();
					Collection c1 = data_list_1.values();
					Object[] o1 = c1.toArray();
					for (int j=0; j<o1.length;j++)
					{
						data_arr_1.add(o1[j]);
					}
				return data_arr_1;
			}
		catch(Exception e)
		{
		e.printStackTrace(); 
		}
	return null;
	}*/
//call it when in query more with temp ID
	public void loadData_toHash_temp() {
		try{
			ArrayList alParameters_temp = new ArrayList();
			alParameters_temp.add(getLoginFacilityId());
			alParameters_temp.add(this.temp_phy_id);
			alParameters_temp.add(getLanguageId());
			HashMap alRec_m_temp = new HashMap();
			ArrayList alRecords_temp = fetchRecords(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_SELECT_DTL"), alParameters_temp);
			for(int i=0;i<alRecords_temp.size();i++){
				alRec_m_temp = (HashMap)alRecords_temp.get(i);
				String s = (String)alRec_m_temp.get("ITEM_DESC");
				s = s + (String)alRec_m_temp.get("STORE_DESC");
				data_list.put(s,(HashMap)alRecords_temp.get(i));
			}
		}catch(Exception ex){
			ex.printStackTrace(); 
		}	
	}

	public ArrayList loadData()	{
		try{
			ArrayList data_arr = new ArrayList();
			TreeMap data_tm = new TreeMap();
			data_tm.putAll(data_list);
			//Collection c = data_list.values();
			Collection c = data_tm.values();
			Object[] o = c.toArray();
			for (int j=0; j<o.length;j++){
				data_arr.add(o[j]);
			}
			return data_arr;
		}catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}

	public void setAll(Hashtable hashtable)
    {
		this.remarks = (String)hashtable.get("remarks");
		this.finalized_yn = (String)hashtable.get("finalized_yn"); 
		this.temp_id = (String)hashtable.get("temp_id"); 
		this.checkBoxVals = (String)hashtable.get("checkBoxVals");
		try{
            getCurr_spec_phy_inv_id();
        }catch(Exception exception){
            exception.printStackTrace();
        }
		try{
            getCurr_phy_inv_id();
        }catch(Exception exception){
            exception.printStackTrace();
        }
     }

	public void getCurr_spec_phy_inv_id()
    {
        try{
			String s1 = fetchRecord(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_CURR_SPEC"), getLoginFacilityId()).get("CURR_SPEC_PHY").toString();
			this.spec_phy_inv_id = s1;
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
	
	public HashMap getMax_min_code(){
        try{
			ArrayList add_updat = new ArrayList();
			add_updat.add(getLoginFacilityId());
			add_updat.add(this.temp_phy_id);
			HashMap arr_list = fetchRecord(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_DTL_MAX_MIN"),add_updat);
			return arr_list;
        }catch(Exception exception){
            exception.printStackTrace();
        }
		return null;
    }
	
	public HashMap insert(){
        HashMap hashmap1 = new HashMap();
		HashMap hashmap = new HashMap();
		
		if (!finalized_yn.equals("Y")){
			if (!this.temp_id.equals("")){
				ArrayList arraylist = new ArrayList();
				arraylist.add(this.remarks);
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add(getLoginFacilityId());
				arraylist.add(this.temp_phy_id);
				
				hashmap.put("properties", getProperties());
				hashmap.put("UpdateHdr", arraylist);
				hashmap1.put("UpdateHdrSQL", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_UPDATE_HDR"));

				hashmap1.put("DeleteDtlTempSQL", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_DELETE_DTL_TEMP"));

				ArrayList param_dtl = getArrayList_dtl_no_query();
				hashmap.put("UpdateDtl", param_dtl);
				hashmap1.put("UpdateDtlSQL", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_INSERT_DTL"));
			}else{
				ArrayList arraylist = new ArrayList();
				arraylist.add(getLoginFacilityId());
				arraylist.add(this.remarks);
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add(this.spec_phy_inv_id);
				hashmap.put("properties", getProperties());
				hashmap.put("InsertData", arraylist);
				hashmap1.put("InsertHdrSQL", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_INSERT_HDR"));

				ArrayList param_dtl = getArrayList_dtl_no();
				hashmap.put("param_dtl", param_dtl);
				hashmap1.put("InsertDtlSQL", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_INSERT_DTL"));
		
			//update st_facility_param

				hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_UPDATE_PARAM_SPEC"));
			}
		}//for finalized = yes 
		else{
			if (!this.temp_id.equals("")){
				HashMap max_min_code = getMax_min_code();
					
				ArrayList arraylist = new ArrayList();
	// pmd 19/02/2005
	//			ArrayList arraylist_HDR = new ArrayList();
				
				arraylist.add(getLoginFacilityId());
				arraylist.add(this.curr_phy_inv_id);
				arraylist.add((String)max_min_code.get("MIN_STORE"));
				arraylist.add((String)max_min_code.get("MAX_STORE"));
				arraylist.add((String)max_min_code.get("MIN_ITEM"));
				arraylist.add((String)max_min_code.get("MAX_ITEM"));
				arraylist.add("");
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("R");
				arraylist.add("");
				arraylist.add("");
				hashmap.put("properties", getProperties());
				hashmap1.put("InsertPhyParamSQL", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_INSERT"));
				hashmap.put("InsertPhyParamData", arraylist);

				ArrayList param_hdr = getArrayCodeListData();
				if(param_hdr.size()<1){
					ArrayList alParameters_temp_11 = new ArrayList();
					alParameters_temp_11.add(getLoginFacilityId());
					alParameters_temp_11.add(this.temp_phy_id);
					alParameters_temp_11.add(getLanguageId());
					HashMap alRec_m_temp_11 = new HashMap();
					HashMap data_list_11 = new HashMap();
				//	HashMap data_list_11== new HashMap();
					//data_list_11= new HashMap();
					try
					{
						ArrayList alRecords_temp_11 = fetchRecords(getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_SELECT_DTL"), alParameters_temp_11);
								
						for(int i=0;i<alRecords_temp_11.size();i++){
							alRec_m_temp_11 = (HashMap)alRecords_temp_11.get(i);
							String s_11 = (String)alRec_m_temp_11.get("ITEM_DESC");
							s_11 = s_11 + (String)alRec_m_temp_11.get("STORE_DESC");
							data_list_11.put(s_11,(HashMap)alRecords_temp_11.get(i));
							ArrayList data_arr_11 = new ArrayList();
							Collection c11 = data_list_11.values();
							Object[] o11 = c11.toArray();
							for (int j=0; j<o11.length;j++){
								data_arr_11.add(o11[j]);
							}
							StringTokenizer stringtokenizer_1 = new StringTokenizer(this.checkBoxVals, ",");
							ArrayList alRecords_dtl_no_1 = new ArrayList();
							ArrayList allRecords_arr_1 = data_arr_11;

							for(int k=0;k<allRecords_arr_1.size();k++){
								HashMap one_rec1 = (HashMap)allRecords_arr_1.get(i);
								if(stringtokenizer_1.nextToken().equals("Y")){
									ArrayList alParameters_CodeList1 = new ArrayList();
									alParameters_CodeList1.add(getLoginFacilityId());
									alParameters_CodeList1.add(this.curr_phy_inv_id);
									alParameters_CodeList1.add(getLoginById());
									alParameters_CodeList1.add(getLoginAtWsNo());
									alParameters_CodeList1.add(getLoginFacilityId());
									alParameters_CodeList1.add(getLoginById());
									alParameters_CodeList1.add(getLoginAtWsNo());
									alParameters_CodeList1.add(getLoginFacilityId());
									alParameters_CodeList1.add(one_rec1.get("STORE_CODE"));
									alParameters_CodeList1.add(one_rec1.get("ITEM_CODE"));

									alRecords_dtl_no_1.add(alParameters_CodeList1);
								}
							}
							param_hdr=alRecords_dtl_no_1;
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}

				hashmap.put("param_hdr", param_hdr);
				hashmap1.put("InsertHdrSQL", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR22"));
				

				ArrayList param_update_stitem = getArrayCodeListUpdateStItem();
				hashmap1.put("Updatestitem", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_UPDATE_STORE"));
				hashmap.put("UpdateData", param_update_stitem);
				hashmap1.put("Updatestbatch", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_UPDATE_BATCH"));

				ArrayList add_update = new ArrayList();
				add_update.add(this.curr_phy_inv_id);
				add_update.add(getLoginById());
				add_update.add(getLoginAtWsNo());
				add_update.add(getLoginFacilityId());
				add_update.add(getLoginFacilityId());
				hashmap.put("UpdateParamData", add_update);
				hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_PARAM"));

				hashmap1.put("DeleteDtlTempSQL", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_DELETE_DTL_TEMP"));

				ArrayList add_updat = new ArrayList();
				add_updat.add(this.temp_phy_id);
				add_updat.add(getLoginFacilityId());
				hashmap.put("DeleteHrdData", add_updat);
				hashmap1.put("DeleteHrdSql", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_DELETE_HDR_TEMP"));
			}else{
				ArrayList arraylist = new ArrayList();
				
				arraylist.add(getLoginFacilityId());
				arraylist.add(this.curr_phy_inv_id);
				arraylist.add(this.store_code);
				arraylist.add(this.store_code);
				arraylist.add(this.item_from);
				arraylist.add(this.item_to);
				arraylist.add("");
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add(getLoginById());
				arraylist.add(getLoginAtWsNo());
				arraylist.add(getLoginFacilityId());
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("");
				arraylist.add("R");
				arraylist.add("");
				arraylist.add("");
			
				hashmap.put("properties", getProperties());
				hashmap1.put("InsertPhyParamSQL", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_INSERT"));
				hashmap.put("InsertPhyParamData", arraylist);

				ArrayList param_hdr = getArrayCodeListData();
				hashmap.put("param_hdr", param_hdr);
				hashmap1.put("InsertHdrSQL", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_HDR22"));
				

				ArrayList param_update_stitem = getArrayCodeListUpdateStItem();
				hashmap1.put("Updatestitem", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_UPDATE_STORE"));
				hashmap.put("UpdateData", param_update_stitem);
				hashmap1.put("Updatestbatch", getStRepositoryValue("SQL_ST_PHY_INV_FOR_SPECIFIC_ITEM_UPDATE_BATCH"));

				ArrayList add_update = new ArrayList();
				add_update.add(this.curr_phy_inv_id);
				add_update.add(getLoginById());
				add_update.add(getLoginAtWsNo());
				add_update.add(getLoginFacilityId());
				add_update.add(getLoginFacilityId());
				hashmap.put("UpdateParamData", add_update);
				hashmap1.put("UpdateParam", getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_UPDATE_PARAM"));
			}
		}
        return dipatchingMethodCall(hashmap, hashmap1);
    }

	public ArrayList getArrayCodeListUpdateStItem()  {
		StringTokenizer stringtokenizer = new StringTokenizer(this.checkBoxVals, ",");
		ArrayList alRecords_dtl_no = new ArrayList();
		ArrayList allRecords_arr = loadData();
		try{
			for(int i=0;i<allRecords_arr.size();i++){
				HashMap one_rec = (HashMap)allRecords_arr.get(i);
				if(stringtokenizer.nextToken().equals("Y")){
					ArrayList alParameters_CodeList = new ArrayList();
					alParameters_CodeList.add(this.curr_phy_inv_id);
					alParameters_CodeList.add(getLoginById());
					alParameters_CodeList.add(getLoginAtWsNo());
					alParameters_CodeList.add(getLoginFacilityId());
					alParameters_CodeList.add(one_rec.get("STORE_CODE"));
					alParameters_CodeList.add(one_rec.get("ITEM_CODE"));
					alRecords_dtl_no.add(alParameters_CodeList);
				}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
       return alRecords_dtl_no;
    }

/*public ArrayList getArrayCodeListData_1()  {
	StringTokenizer stringtokenizer = new StringTokenizer(this.checkBoxVals, ",");
		ArrayList alRecords_dtl_no = new ArrayList();
		ArrayList allRecords_arr = get_Data();
		try{
			for(int i=0;i<allRecords_arr.size();i++)	
				{
				HashMap one_rec = (HashMap)allRecords_arr.get(i);
					if(stringtokenizer.nextToken().equals("Y"))
						{
				ArrayList alParameters_CodeList = new ArrayList();
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(this.curr_phy_inv_id);
				alParameters_CodeList.add(getLoginById());
					//alParameters_CodeList.add("SYSDATE");
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(getLoginById());
					//alParameters_CodeList.add("SYSDATE");
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(one_rec.get("STORE_CODE"));
				alParameters_CodeList.add(one_rec.get("ITEM_CODE"));

				alRecords_dtl_no.add(alParameters_CodeList);
						}
				}
			}
		catch(Exception exception){
		   exception.printStackTrace();
			}
       return alRecords_dtl_no;
    }*/
	public ArrayList getArrayCodeListData()  {
		StringTokenizer stringtokenizer = new StringTokenizer(this.checkBoxVals, ",");
		ArrayList alRecords_dtl_no = new ArrayList();
		ArrayList allRecords_arr = loadData();
		try{
			for(int i=0;i<allRecords_arr.size();i++)	
				{
				HashMap one_rec = (HashMap)allRecords_arr.get(i);
					if(stringtokenizer.nextToken().equals("Y"))
						{
				ArrayList alParameters_CodeList = new ArrayList();
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(this.curr_phy_inv_id);
				alParameters_CodeList.add(getLoginById());
					//alParameters_CodeList.add("SYSDATE");
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(getLoginById());
					//alParameters_CodeList.add("SYSDATE");
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(one_rec.get("STORE_CODE"));
				alParameters_CodeList.add(one_rec.get("ITEM_CODE"));

				alRecords_dtl_no.add(alParameters_CodeList);
						}
				}
			}
		catch(Exception exception){
		   exception.printStackTrace();
			}
       return alRecords_dtl_no;
    }

	public void getCurr_phy_inv_id(){
        try{
			String s1 = fetchRecord(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_MODE"), getLoginFacilityId()).get("CURR_PHY").toString();
			this.curr_phy_inv_id = s1;
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

//it will return arrraylist of arraylist to update dtl table with finaliz = no with checked items and in Query mode
public ArrayList getArrayList_dtl_no_query()  {
		StringTokenizer stringtokenizer = new StringTokenizer(this.checkBoxVals, ",");
		ArrayList alRecords_dtl_no = new ArrayList();
		ArrayList allRecords_arr = loadData();
		try{
			for(int i=0;i<allRecords_arr.size();i++)	
				{
				HashMap one_rec = (HashMap)allRecords_arr.get(i);
					if(stringtokenizer.nextToken().equals("Y"))
						{
				ArrayList alParameters_CodeList = new ArrayList();
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(one_rec.get("ITEM_CODE"));
				alParameters_CodeList.add(one_rec.get("STORE_CODE"));
				alParameters_CodeList.add(getLoginById());
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(getLoginById());
				alParameters_CodeList.add(getLoginAtWsNo());
				alParameters_CodeList.add(getLoginFacilityId());
				alParameters_CodeList.add(this.temp_phy_id);

				alRecords_dtl_no.add(alParameters_CodeList);
						}
				}
			}
		catch(Exception exception){
		   exception.printStackTrace();
			}
       return alRecords_dtl_no;
    }

//it will return arrraylist of arraylist for dtl table with finaliz = no with checked items
public ArrayList getArrayList_dtl_no()  {
		StringTokenizer stringtokenizer = new StringTokenizer(this.checkBoxVals, ",");
		ArrayList alRecords_dtl_no = new ArrayList();
		ArrayList allRecords_arr = loadData();
		try{
			for(int i=0;i<allRecords_arr.size();i++)	
				{
				HashMap one_rec = (HashMap)allRecords_arr.get(i);
				if(stringtokenizer.nextToken().equals("Y")){
					ArrayList alParameters_CodeList = new ArrayList();
					alParameters_CodeList.add(getLoginFacilityId());
					alParameters_CodeList.add(one_rec.get("ITEM_CODE"));
					alParameters_CodeList.add(one_rec.get("STORE_CODE"));
					alParameters_CodeList.add(getLoginById());
					alParameters_CodeList.add(getLoginAtWsNo());
					alParameters_CodeList.add(getLoginFacilityId());
					alParameters_CodeList.add(getLoginById());
					alParameters_CodeList.add(getLoginAtWsNo());
					alParameters_CodeList.add(getLoginFacilityId());
					alParameters_CodeList.add(this.spec_phy_inv_id);
					alRecords_dtl_no.add(alParameters_CodeList);
				}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
       return alRecords_dtl_no;
    }

public HashMap dipatchingMethodCall(HashMap hashmap, HashMap hashmap1){
        HashMap hashmap2 = new HashMap();
        try{
          //  PhyInvForSpecificItemHome phyhome = null;
           // eST.PhyInvForSpecificItem.PhyInvForSpecificItemRemote phyremote = null;
          /*  InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_PHYINV_FOR_SPECIFIC_ITEM"));
            phyhome = (PhyInvForSpecificItemHome)PortableRemoteObject.narrow(obj, eST.PhyInvForSpecificItem.PhyInvForSpecificItemHome.class);
            phyremote = phyhome.create();*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_PHYINV_FOR_SPECIFIC_ITEM"),eST.PhyInvForSpecificItem.PhyInvForSpecificItemHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmap1;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmap1.getClass();
			if (!finalized_yn.equals("Y")){
			//for query mode press apply
				if (!this.temp_id.equals("")){
					hashmap2 = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
//hashmap2 = phyremote.modify(hashmap, hashmap1);
				}
			//for create mode press apply
				else{
					hashmap2 = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
// hashmap2 = phyremote.insert(hashmap, hashmap1);
				hashmap2.put("flag",(String)this.spec_phy_inv_id);
				}
			}
			//for finalized = yes
			else{
			//for query mode press apply
				if (!this.temp_id.equals("")){
					hashmap2 = (HashMap)(busObj.getClass().getMethod("modifyYes",paramArray)).invoke(busObj,argArray);
					hashmap2.put("flag",(String)this.curr_phy_inv_id);
					//hashmap2 = phyremote.modifyYes(hashmap, hashmap1);
				}
			//for create mode press apply
				else{
					hashmap2 = (HashMap)(busObj.getClass().getMethod("insertYes",paramArray)).invoke(busObj,argArray);
		           // hashmap2 = phyremote.insertYes(hashmap, hashmap1);
					hashmap2.put("flag",(String)this.curr_phy_inv_id);
				}
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }catch(Exception exception) { 
			exception.printStackTrace();
		}
        
		if(((Boolean)hashmap2.get("result")).booleanValue())
            hashmap2.put("message", getSTMessage(getLanguageId(),(String) hashmap2.get( "msgid" ),"ST") ) ;
        else if(hashmap2.get("msgid") != null)
            hashmap2.put("message", getSTMessage(getLanguageId(),(String) hashmap2.get( "msgid" ),"ST") ) ;
        else
            hashmap2.put("message", replaceNewLineChar((String)hashmap2.get("message")));
        return hashmap2;
}
	
	public HashMap validate(){
        HashMap hashmap = new HashMap();
//        ArrayList arraylist = new ArrayList();
        hashmap.put("result", super.TRUE);
        return hashmap;
    }

	public String getRemarks(){
		String s1 ="";
		ArrayList param_val = new ArrayList();
	    try{
			param_val.add(getLoginFacilityId());
			param_val.add(this.temp_phy_id);
			s1  = fetchRecord(getStRepositoryValue("SQL_ST_PRINT_COUNT_PHY_INV_REMARKS"),param_val).get("REMARKS").toString();
		}catch(Exception exception){
           exception.printStackTrace();
		}
	return s1;
    }
 
}
