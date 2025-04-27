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

public class ProductTransferDetailBean extends StTransaction implements Serializable
{
//*   private String store_code="";
//*   private String item_code="";
   private String doc_srl_no="";


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

	public void clear()
    {
        super.clear();


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
