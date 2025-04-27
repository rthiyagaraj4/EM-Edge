/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common;

//import eST.Common.StTransaction;
import java.io.Serializable;
import java.util.*;

public class StDtlBean extends StTransaction implements Serializable
{

   private String doc_srl_no	="";
   private String item_code	="";
   private String adj_item_qty="";
   private String item_unit_cost="";
   private String item_cost_value="";
   private String remarks="";


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
		 this.remarks = remarks;
	}
	public String getRemarks() {
		 return remarks;
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
    }

	public HashMap updateDtlList()
	{
			HashMap hmListItems	=	new HashMap();
		
			hmListItems.put("doc_srl_no",			getDoc_srl_no()		);
			hmListItems.put("item_code",				getItem_code()		);
			hmListItems.put("adj_item_qty",		getAdj_item_qty()	);
			hmListItems.put("item_unit_cost",		getItem_unit_cost()		);
			hmListItems.put("item_cost_value",	getItem_cost_value()		);
			hmListItems.put("remarks",				getRemarks()		);
			
			return hmListItems;
	}
 }
