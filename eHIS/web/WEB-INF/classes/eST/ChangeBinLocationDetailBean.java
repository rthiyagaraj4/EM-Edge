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

public class ChangeBinLocationDetailBean extends StTransaction implements Serializable
{
   private String doc_srl_no="";
//   private String item_code	="";
   private String store_code ="";
   private String item_desc	="";
   private String uom_code	="";
   private String uom		="";
   private String batch_id	="";
   private String trade_id	="";
   private String trade_name="";
   private String adj_item_qty="";
   private String avl_item_qty	="";
   private String old_bin_loc_code	="";
  // private String old_bin_loc_desc	="";
   private String new_bin_loc_code	="";
   private String new_bin_loc_desc	="";

   private String exp_date	="";
   private String records_to_delete="";

   private int nextDocSerialNo	=	1;

   private ArrayList ALDtl=new ArrayList();

   public int getNextDocSerialNo(){
		return nextDocSerialNo++;
	} 

	public void setDoc_srl_no(String doc_srl_no) {
		 this.doc_srl_no= doc_srl_no;
	}
	public String getDoc_srl_no() {
		 return doc_srl_no;
	}

    public void setStore_code(String store_code) {
		 this.store_code= store_code;
	}
	public String getStore_code() {
		 return store_code;
	}
    public void setItem_desc(String item_desc) {
		 this.item_desc= item_desc;
	}
	public String getItem_desc() {
		 return item_desc;
	}
    public void setUom_code(String uom_code) {
		 this.uom_code= uom_code;
	}
	public String getUom_code() {
		 return uom_code;
	}

    public void setUom(String uom) {
		 this.uom= uom;
	}
	public String getUom() {
		 return uom;
	}

    public void setBatch_id(String batch_id) {
		 this.batch_id= batch_id;
	}
	public String getBatch_id() {
		 return batch_id;
	}

    public void setTrade_id(String trade_id) {
		 this.trade_id= trade_id;
	}
	public String getTrade_id() {
		 return trade_id;
	}

    public void setTrade_name(String trade_name) {
		 this.trade_name= trade_name;
	}
	public String getTrade_name() {
		 return trade_name;
	}

    public void setAdj_item_qty(String adj_item_qty) {
		 this.adj_item_qty= adj_item_qty;
	}
	public String getAdj_item_qty() {
		 return adj_item_qty;
	}

    public void setAvl_item_qty(String avl_item_qty) {
		 this.avl_item_qty= avl_item_qty;
	}
	public String getAvl_item_qty() {
		 return avl_item_qty;
	}

    public void setOld_bin_loc_code(String old_bin_loc_code) {
		 this.old_bin_loc_code= old_bin_loc_code;
	}
	public String getOld_bin_loc_code() {
		 return old_bin_loc_code;
	}

	public void setNew_bin_loc_code(String new_bin_loc_code) {
		 this.new_bin_loc_code= new_bin_loc_code;
	}
	public String getNew_bin_loc_code() {
		 return new_bin_loc_code;
	}

    public void setNew_bin_loc_desc(String new_bin_loc_desc) {
		 this.new_bin_loc_desc= new_bin_loc_desc;
	}
	public String getNew_bin_loc_desc() {
		 return new_bin_loc_desc;
	}

	public void setExp_date(String exp_date) {
		 this.exp_date= exp_date;
	}
	public String getExp_date() {
		 return exp_date;
	}

    public void setRecords_to_delete(String s)
    {
        records_to_delete = s;
    }
    public String getRecords_to_delete()
    {
        return records_to_delete;
    }

	public void clear()
    {
        super.clear();
	//	item_code	="";   
		item_desc	="";   
		uom_code	="" ;      
        uom			="" ;  
		batch_id	="";       
		adj_item_qty="";       
		avl_item_qty="";       
		old_bin_loc_code    ="";       
		new_bin_loc_code	="";       
		exp_date	="";       
		records_to_delete="";
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
        setRecords_to_delete((String)hashtable.get("records_to_delete"));
    }

	/* To get item details */

    /*
	public HashMap getItemDetail( String item_code) {
		HashMap hmRecord=new HashMap();
		try {
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAILS"),item_code);
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		return hmRecord;		
	} */	

 }
