/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eST.Common.StTransaction;
import java.io.Serializable;
import java.util.*;

public class OpeningStockDetailBean extends StTransaction implements Serializable
{
   private String doc_srl_no	="";
   private String item_code	="";
   private String adj_item_qty="";
   private String item_unit_cost="";
   private String item_cost_value="";
   private String remarks="";
   private String uom_code="";
   private ArrayList ALDtl=new ArrayList();
   private int nextDocSerialNo	=	1;
   private String records_to_delete;

	public int getNextDocSerialNo(){
		return nextDocSerialNo++;
	}

	public void setDoc_srl_no(String doc_srl_no) {
		 this.doc_srl_no= doc_srl_no;
	}
	public String getDoc_srl_no() {
		 return doc_srl_no;
	}


	public void setItem_code(String item_code) {
		 this.item_code= item_code;
	}
	public String getItem_code() {
		 return item_code;
	}

	public void setAdj_item_qty(String adj_item_qty) {
		 this.adj_item_qty = adj_item_qty;
	}
	public String getAdj_item_qty() {
		 return adj_item_qty;
	}


	public void setItem_unit_cost(String item_unit_cost) {
		 this.item_unit_cost = item_unit_cost;
	}
	public String getItem_unit_cost() {
		 return item_unit_cost;
	}


	public void setItem_cost_value(String item_cost_value) {
		 this.item_cost_value = item_cost_value;
	}
	public String getItem_cost_value() {
		 return item_cost_value;
	}


	public void setRemarks(String remarks) {
		if(remarks != null) {
			remarks = remarks.trim();
		}
		this.remarks = remarks;
	}
	public String getRemarks() {
		if(remarks != null) {
			remarks = remarks.trim();
		}
		return remarks;
	}
   
   public void setRecords_to_delete(String s) {
        records_to_delete = s;
   }
   public String getRecords_to_delete()
    {
        return records_to_delete;
    }

	public void setUom_code(String uom_code) {
		 this.uom_code = uom_code;
	}
	public String getUom_code() {
		 return uom_code;
	}

    public void clear()
    {
        super.clear();
		doc_srl_no="";     
		item_code="";      
		adj_item_qty="";   
		item_unit_cost=""; 
		item_cost_value="";
		remarks="";   
		records_to_delete="";
		uom_code="";
    }

	public  void setValues(HashMap StDtl)
	{
		if(StDtl.get("doc_srl_no").equals("-1")) {
			StDtl.put("doc_srl_no",""+getNextDocSerialNo());
			ALDtl.add(StDtl);
		}
		else {
			for (int i=0;i<ALDtl.size() ;i++ ) {
				if (((HashMap)ALDtl.get(i)).get("doc_srl_no").equals(StDtl.get("doc_srl_no"))) {
					ALDtl.set(i,StDtl);
					break;
				}
			}
		}
	}

	public ArrayList toArrayList(){
		return ALDtl;
	}

	public HashMap getValues(String doc_srl_no) {
		for (int i=0;i<ALDtl.size() ;i++ ) {
			if (((HashMap)ALDtl.get(i)).get("doc_srl_no").equals(doc_srl_no)) {
				return (HashMap)ALDtl.get(i);
			}
		}
		return null;
	}
	 
	public void setAll(Hashtable hashtable) {
        super.setAll(hashtable);

     /* setDoc_srl_no((String)hashtable.get("doc_srl_no"));
        setItem_code((String)hashtable.get("item_code"));
        setAdj_item_qty((String)hashtable.get("adj_item_qty"));
        setItem_unit_cost((String)hashtable.get("item_unit_cost"));
        setItem_cost_value((String)hashtable.get("item_cost_value"));
        setRemarks((String)hashtable.get("remarks"));*/

        setRecords_to_delete((String)hashtable.get("records_to_delete"));
    }

	//to get item details

	public HashMap getItemDetail( String item_code) {

		HashMap hmRecord=new HashMap();
		try {
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAILS"),item_code);
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		return hmRecord;		
	}	
 }
