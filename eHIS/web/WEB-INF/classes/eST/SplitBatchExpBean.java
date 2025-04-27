/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import java.io.Serializable;
//import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class SplitBatchExpBean extends StTransaction implements Serializable {

	

	ArrayList expDetailsList = new ArrayList();

   private int nextDocSerialNo	=	1;
//	ArrayList resultList = new ArrayList();

	public int getNextDocSerialNo(){
		return nextDocSerialNo++;
	}


	/** Method to add the exp detail records for a particulat item detail.
	* @param HashTable, containing one set of exp records, for a particular item detail.
	* Assumption made : Always we'll get 10 records from the form for update.
	*/
//commented by Rabbani #Inc no:29973 on 11/05/12
	/*public boolean setValues (Hashtable htFormData) {
		boolean result=true;
		
		try {
			ArrayList alTemp = new ArrayList();
			int iSerialNumber = Integer.parseInt(((String)(htFormData.get("doc_srl_no"))));
			if(iSerialNumber != -1) {
				int iExpDetailsListSize = expDetailsList.size();
					  for(int i=0;i<iExpDetailsListSize;i++) {
							 int iList_serial_no = Integer.parseInt(((String)(((HashMap)expDetailsList.get(i)).get("doc_srl_no"))).trim());
								if( iList_serial_no != iSerialNumber)  {
									 alTemp.add(expDetailsList.get(i));
								}
					}
			 }
			
			HashMap hmRowMessage = new HashMap();
			ArrayList expDetailsListCheck=new ArrayList();
			for(int i=0;i<10;i++) {

				String message="";
				hmRowMessage.put("result",new Boolean (result));
				hmRowMessage.put("message",message);

				String sItem_qty = (String)(htFormData.get("item_qty_"+i));
				if(sItem_qty != null && ! ( sItem_qty.equals("") ) ) {
//					String index =(String)(htFormData.get("doc_srl_no"));


					String [] value={((String)htFormData.get("batch_id_"+i)).trim(),(String)htFormData.get("expiry_date_or_receipt_date_"+i),(String)htFormData.get("bin_location_code_"+i),(String)htFormData.get("trade_id_"+i)};
					String [] key={"batch_id","expiry_date_or_receipt_date","bin_location_code","trade_id"} ;
							
					if(isDuplicateInArrayList(expDetailsListCheck,key,value,Integer.parseInt("-1"))){
						result	=	false; 
					}
					else{
						result	=	true;
						HashMap hmRow = new HashMap();
						hmRow.put("batch_id", ((String)htFormData.get("batch_id_"+i)).trim());
						hmRow.put("expiry_date_or_receipt_date", htFormData.get("expiry_date_or_receipt_date_"+i));
						hmRow.put("bin_location_code", htFormData.get("bin_location_code_"+i));
						hmRow.put("trade_id", htFormData.get("trade_id_"+i));
						hmRow.put("item_qty", htFormData.get("item_qty_"+i));
						hmRow.put("barcode_id", htFormData.get("barcode_id_"+i)); //04/05/12
						expDetailsListCheck.add(hmRow);
					}
				}
			}
			
			if(result){	
				if(expDetailsListCheck.size()>0)
					if(iSerialNumber == -1) {
						iSerialNumber=getNextDocSerialNo();
						for(int k =0; k<expDetailsListCheck.size();k++){
							HashMap hmap = (HashMap)expDetailsListCheck.get(k);
							hmap.put("doc_srl_no", Integer.toString(iSerialNumber));
							expDetailsList.add(hmap);
						}
					}
					else{
							for(int k =0; k<expDetailsListCheck.size();k++){
								HashMap hmap = (HashMap)expDetailsListCheck.get(k);
								hmap.put("doc_srl_no", Integer.toString(iSerialNumber));
								alTemp.add(hmap);
							}
						expDetailsList=alTemp;
					}
				}
			}
			catch(Exception e) {
				result=false;
				expDetailsList.clear();
				
				e.printStackTrace();
			}
			return result;
		}*/
		//Added by Rabbani on 09/05/2012 
		
		
		
		//Added by Rabbani #Inc no:29973 on 11/05/12
		  public boolean setValues (Hashtable htFormData) {
		 boolean result=true;
		try {
		
		//System.out.println("htFormData 223==expban========>"+htFormData);
		
		int iSerialNumber = Integer.parseInt(((String)(htFormData.get("doc_srl_no"))));
		//System.out.println("iSerialNumber 223==expban========>"+iSerialNumber);
		
		int iNumber = Integer.parseInt(((String)(htFormData.get("doc_srl_no"))));
		//System.out.println("iNumber 223==expban========>"+iNumber);
		
		String addmodify ="";
		if(htFormData.containsKey("Add"))
		addmodify = (String)htFormData.get("Add");
		else
		addmodify = (String)htFormData.get("Modify");
        //System.out.println("addmodify 223==expban========>"+addmodify);
		
		if(addmodify.equals("Modify")){
			if(iSerialNumber != -1) {
				ArrayList alTemp = new ArrayList();
				int iExpDetailsListSize = expDetailsList.size();
				for(int i=0;i<iExpDetailsListSize;i++) {
					int iList_serial_no = Integer.parseInt(((String)(((HashMap)expDetailsList.get(i)).get("doc_srl_no"))).trim());
                
					if(! (iList_serial_no == iSerialNumber) ) {
						alTemp.add(expDetailsList.get(i));
					}
				}
				expDetailsList.clear();

				for(int i=0;i<alTemp.size();i++) {
				
					expDetailsList.add(alTemp.get(i));
				}
				alTemp.clear();
			}
			else{
				iSerialNumber=getNextDocSerialNo();
			}

			for(int i=0;i<10;i++) {
				String sItem_qty = (String)(htFormData.get("item_qty_"+i));
				if(sItem_qty != null && ! ( sItem_qty.equals("") ) ) {
					HashMap hmRow = new HashMap();
					hmRow.put("doc_srl_no", Integer.toString(iSerialNumber));
					hmRow.put("item_code",htFormData.get("item_code")) ;
					hmRow.put("batch_id", ((String)htFormData.get("batch_id_"+i)).trim());
						hmRow.put("expiry_date_or_receipt_date", htFormData.get("expiry_date_or_receipt_date_"+i));
						hmRow.put("bin_location_code", htFormData.get("bin_location_code_"+i));
						hmRow.put("trade_id", htFormData.get("trade_id_"+i));
						hmRow.put("item_qty", htFormData.get("item_qty_"+i));
						hmRow.put("barcode_id", htFormData.get("barcode_id_"+i)); //04/05/12
					expDetailsList.add(hmRow);
				}
			}
			//System.out.println("expDetailsList 290==========>"+expDetailsList);
		  }
		  else{

			
			int no_of_batches_entered = Integer.parseInt(((String)(htFormData.get("no_of_batches_entered"))));	
             //System.out.println("no_of_batches_entered===>" +no_of_batches_entered);			
			boolean newBatchFound = false;
			//System.out.println("iSerialNumber=183==>" +iSerialNumber);	
			if(iSerialNumber != -1) {
				HashMap  expDtl  = null;
				float qty = 0;
				float newqty = 0;
				int iExpDetailsListSize = expDetailsList.size();
				//System.out.println("iExpDetailsListSize===>" +iExpDetailsListSize);	
				for (int j=0;j<no_of_batches_entered;j++)						
				{
							  for(int k=0;k<iExpDetailsListSize;k++) {
									expDtl = (HashMap)expDetailsList.get(k);
									//System.out.println("expDtl===>" +expDtl);	
									newBatchFound = false;
									if (((String)expDtl.get("item_code")).equals((String)htFormData.get("item_code")) && expDtl.get("batch_id").equals(htFormData.get("batch_id_"+j)) &&  expDtl.get("expiry_date_or_receipt_date").equals(htFormData.get("expiry_date_or_receipt_date_"+j)) && 	expDtl.get("bin_location_code").equals(htFormData.get("bin_location_code_"+j)) &&  expDtl.get("trade_id").equals(htFormData.get("trade_id_"+j)) && ((String)htFormData.get("ADD1")).equals("YES")) {
										newBatchFound = true;
										break;
									}

							  }
							  //System.out.println("newBatchFound===202==>" +newBatchFound);	
							if (newBatchFound){
							    if (  expDtl.containsKey("item_qty")){
							
								if((String)htFormData.get("item_qty_"+j)!="" || (String)htFormData.get("item_qty_"+j)!= null){
									qty = Float.parseFloat(checkForNull((String)expDtl.get("item_qty"),"0")) ;
									newqty= Float.parseFloat(checkForNull((String)htFormData.get("item_qty_"+j),"0")); 
									qty = qty + newqty; 									
								}else{
								qty = Float.parseFloat(checkForNull((String)expDtl.get("item_qty"),"0")) ;
								}
								 expDtl.put("item_qty",	""+qty);
								}else{
								
								expDtl.put("item_qty",	htFormData.get("item_qty_"+j));
								}
								//System.out.println("expDtl= 245====>" +expDtl);
								//break;
							}
							else{
							if((String)htFormData.get("item_qty_"+j)!="" && (String)htFormData.get("item_qty_"+j)!= null && ((String)htFormData.get("ADD1")).equals("YES")){
								HashMap hmRowMessage = new HashMap();
								 String message="";
				                 hmRowMessage.put("result",new Boolean (result));
				                 hmRowMessage.put("message",message);
								 result	=	true;
								HashMap hmRow = new HashMap();
								hmRow.put("doc_srl_no", Integer.toString(iSerialNumber));
								hmRow.put("item_code",htFormData.get("item_code")); 
								hmRow.put("batch_id", ((String)htFormData.get("batch_id_"+j)).trim());
						        hmRow.put("expiry_date_or_receipt_date", htFormData.get("expiry_date_or_receipt_date_"+j));
						        hmRow.put("bin_location_code", htFormData.get("bin_location_code_"+j));
						        hmRow.put("trade_id", htFormData.get("trade_id_"+j));
						        hmRow.put("item_qty", htFormData.get("item_qty_"+j));
						        hmRow.put("barcode_id", htFormData.get("barcode_id_"+j));  
										expDetailsList.add(hmRow);
										//System.out.println("expDetailsList===238==>" +expDetailsList);	
									}
								} 
				}			
			}
			else{
				iSerialNumber=getNextDocSerialNo();
			}
			
			System.out.println("expDetailsList 371==========>"+expDetailsList);
			//System.out.println("iNumber 371==========>"+iNumber);

			if(iNumber==-1){
			HashMap hmRowMessage = new HashMap();
			    
				
			for(int i=0;i<10;i++) {
			  String message="";
			   hmRowMessage.put("result",new Boolean (result));
				hmRowMessage.put("message",message);
			   result	=	true;
				String sItem_qty = (String)(htFormData.get("item_qty_"+i));
				if(sItem_qty != null && ! ( sItem_qty.equals(""))) {
					HashMap hmRow = new HashMap();
					hmRow.put("doc_srl_no", Integer.toString(iSerialNumber));
					hmRow.put("item_code",htFormData.get("item_code")) ;
					hmRow.put("batch_id", ((String)htFormData.get("batch_id_"+i)).trim());
				    hmRow.put("expiry_date_or_receipt_date", htFormData.get("expiry_date_or_receipt_date_"+i));
				    hmRow.put("bin_location_code", htFormData.get("bin_location_code_"+i));
			    	hmRow.put("trade_id", htFormData.get("trade_id_"+i));
					hmRow.put("item_qty", htFormData.get("item_qty_"+i));
					hmRow.put("barcode_id", htFormData.get("barcode_id_"+i)); //04/05/12
				    expDetailsList.add(hmRow);

				}				
			  }
			}
		 }
		}
		catch(Exception e) {
				result=false;
				//expDetailsList.clear();
				
				e.printStackTrace();
			}
			return result;
		}
					


		

	/*public boolean isDuplicateInArrayList(ArrayList arrayList, String []stKeyFields, String []stValues){
		boolean result=false;
		for (int i=0;i<arrayList.size()&& (!result);i++) {
			//if (exceptionalIndex == i) continue;
			//for (int j=0; j<stKeyFields.length ; j++ ) {
			if (stKeyFields.length >0 ) {
				if ( (((HashMap)arrayList.get(i)).get(stKeyFields[0]).toString()+"`"+((HashMap)arrayList.get(i)).get(stKeyFields[1]).toString()+"`"+((HashMap)arrayList.get(i)).get(stKeyFields[2]).toString()+"`"+((HashMap)arrayList.get(i)).get(stKeyFields[3]).toString()).equals((stValues[0])+"`"+(stValues[1])+"`"+(stValues[2])+"`"+(stValues[3]))) {
					result=true;
					break;
				}
			}
		}
		
		return result;
	}*/

	/** 
	*Method to retrive the list of exp details related to the given Serial Number.
	*@param int, serial number.
	*@return ArrayList of HashMaps, containg the exp details, related to the given
	*        serial Number.
	*/

	public ArrayList getDtlExpList(int srl_no) {
		ArrayList resultList=new ArrayList();
		int size = expDetailsList.size();
		for(int i=0;i<size;i++) {
			int serialNumber = Integer.parseInt((String)(((HashMap)expDetailsList.get(i)).get("doc_srl_no")));
			if(serialNumber == srl_no) {
				resultList.add(expDetailsList.get(i));
			}
		}
		return resultList;
	}

	/**
	* Method to retrive the final ArrayList containing all the exp details.
	* @return ArrayList, List of HashMaps containing all the exp details.
	*/

	public ArrayList toArrayList () {
		return expDetailsList;
	}

	/**
	* Method to fetch the trade details corresponding to the given item code.
	* @param String, the key to retirve the trade details.
	* @return String, containing the trade details as newline separated.
	*/

	public String getTradeList(String item_code,String trade_id,String language_id) {
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(item_code);
		arr_lang.add(language_id);

		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),arr_lang),trade_id);
	}
	public String getTradeList(String item_code,String language_id) {
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(item_code);
		arr_lang.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),arr_lang));
	}
	public String getTradeListDflt(String trade_id,String language_id) {
		
			return getListOptionTag(getWithoutLangIdListOptionArrayList(getStRepositoryValue("SQL_ST_DEFAULT_TRADE_ID")),trade_id);
	}
	/**SQL_ST_DEFAULT_BATCH_ID
	* Method to fetch the bin location detials corresponding to the given store code
	* @param String, Store_code, the key to retrive the bin location details
	* @return String, containing the bin location details, as newline separated.
	*/
	
	public String getBinLocationList(String store_code,String bin_location_code,String language_id) {
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(store_code);
		arr_lang.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_lang),bin_location_code);
	}	

	public String getBinLocationList(String store_code,String language_id) {
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(store_code);
		arr_lang.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_lang));
	}	

	/**
	* Method to retrive the default batch_id from MM_parameter table.
	* @return String, The default_batch_id for a particular item.
	*/

	public String getDefault_batch_id() {

		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_DEFAULT_BATCH_ID"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("DFLT_BATCH_ID");
	}

	public String getDefault_trade_id() {

		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_DEFAULT_TRADE_ID"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("DFLT_TRADE_ID");
	}

	/**
	* Method to create batch id by using the given expiry date.
	* This is just a replacement of '/' with ''.
	* @param String, the expiry date entered
	* @param String, the batch id.
	*/
	
	public String getBatchIDFromExpiryDate (String expiry_date) {
		StringBuffer buffer = new StringBuffer("");
		int start_index = 0;
		int end_index = 0;
		while(expiry_date.indexOf("/") != -1) {
			end_index = expiry_date.indexOf("/");
			buffer.append(expiry_date.substring(start_index,end_index));
			expiry_date = expiry_date.substring(end_index+1);
		}
		buffer.append(expiry_date);
		return buffer.toString();
	}	
	
	public String getDefaultBinLocationCode (String item_code,String store_code,String language_id) 
	{
	//SQL_ST_ITEM_STORE_SELECT
		ArrayList alParameters=new ArrayList();
		alParameters.add(store_code);
		alParameters.add(item_code);
		alParameters.add(language_id);

		HashMap hmResult=new HashMap();
		try{
		hmResult=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_SELECT"),alParameters);
		}catch(Exception e)
		{e.printStackTrace();}
		return (String)hmResult.get("BIN_LOCATION_CODE");
	}

	/**
	* Method to get the stock_uom_code from mm_item table.
	* @param String, the item code, corresponding to that
	* @return String, the stock_uom code for the given item_code.
	*/


	public String getStockUOMCode (String item_code) {
		ArrayList alParameters=new ArrayList();
		alParameters.add(item_code);

		HashMap hmResult=new HashMap();
		try{
			hmResult=fetchRecord(getStRepositoryValue("SQL_ST_STOCK_UOM_CODE_SELECT"),alParameters);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("CODE");
	}
}
