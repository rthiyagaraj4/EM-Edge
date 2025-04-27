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

public class SplitBatchDetailBean extends StTransaction implements Serializable
{
   private String doc_srl_no	="";
   private String item_code	="";
   private String batch_id=""; 
   private String bin_location_code="";
   private String item_cost_value="";
   private String remarks="";
   private String stock_uom_code="";
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

	public void setBatch_id(String batch_id) {
		 this.batch_id = batch_id;
	}
	public String getBatch_id() {
		 return batch_id;
	}


	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = bin_location_code;
	}
	public String getBin_location_code() {
		 return bin_location_code;
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
   
   public void setRecords_to_delete(String s)
    {
        records_to_delete = s;
    }
   public String getRecords_to_delete()
    {
        return records_to_delete;
    }

	public void setStock_uom_code(String stock_uom_code) {
		 this.stock_uom_code = stock_uom_code;
	}
	public String getStock_uom_code() {
		 return stock_uom_code;
	}

    public void clear()
    {
        super.clear();
		doc_srl_no="";     
		item_code="";      
		batch_id="";   
		bin_location_code=""; 
		item_cost_value="";
		remarks="";   
		records_to_delete="";
    }
   //commented by Rabbani #Inc no:29973 on 11/05/12
	/*public  void setValues(HashMap StDtl)
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
	}*/
	//Added by Rabbani #Inc no:29973 on 11/05/12
	
	public  void setValues(HashMap StDtl)
	{
	System.out.println("setValues 101=>");
	if(StDtl.get("doc_srl_no").equals("-1")) {
			if (StDtl.get("ADD").equals("YES"))
			{
			int doc_srl_no =  Integer.parseInt((String)StDtl.get("doc_srl_no"));

			//System.out.println("StHeader before doc_srl_no==>"+doc_srl_no);
			--doc_srl_no;
			//System.out.println("StHeader after doc_srl_no==>"+doc_srl_no);
			
			System.out.println("StHeader StDtl==>"+StDtl);

			// System.out.println("StHeader before ALDtl==>"+ALDtl);
			StDtl.put("doc_srl_no",""+getNextDocSerialNo());
			ALDtl.add(StDtl);
			//System.out.println("StHeader after ALDtl==>"+ALDtl);
			
			}else{
			StDtl.put("doc_srl_no",""+getNextDocSerialNo());
			ALDtl.add(StDtl);
			System.out.println("ALDtl splitdetailbean===104==>" +ALDtl);
		}
		}else {
			for (int i=0;i<ALDtl.size() ;i++ ) {
				if (((HashMap)ALDtl.get(i)).get("doc_srl_no").equals(StDtl.get("doc_srl_no"))) {
					ALDtl.set(i,StDtl);
					//System.out.println("ALDtl splitdetailbean=110====>" +ALDtl);
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
        setBatch_id((String)hashtable.get("batch_id"));
        setBin_location_code((String)hashtable.get("bin_location_code"));
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
