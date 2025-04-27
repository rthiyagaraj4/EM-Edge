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
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class OpeningStockExpBean extends StTransaction implements Serializable {

	/** ArrayList to hold all the records*/

	ArrayList expDetailsList = new ArrayList();

   private int nextDocSerialNo	=	1;
	ArrayList resultList = new ArrayList();

	public int getNextDocSerialNo(){
		return nextDocSerialNo++;
	}

	/**
	* Method to check for the dublicate entry in the exp list before adding the records.
	* Assumption made :  always we'll get maximum 10 records...
	* @param Hashtable, all the records in the form of a Hashtable
	* @return boolean, if duplicate exists then true, otherwise false.
	*/

	public boolean isDuplicateInExpList (Hashtable htFormData, String locale) {//Added locale for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015
		boolean result = false;		
		//int iExpDetailsListSize = expDetailsList.size();		
		for(int i=0;i<10;i++) {			
			//String expiry_date_or_receipt_date = (String)htFormData.get("expiry_date_or_receipt_date_"+i);Changed for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015
			String expiry_date_or_receipt_date = com.ehis.util.DateUtils.convertDate((String)htFormData.get("expiry_date_or_receipt_date_"+i),"DMY",locale,"en");
			String batch_id = (String)htFormData.get("batch_id_"+i);
			String bin_location_code = (String)htFormData.get("bin_location_code_"+i);


			if(! ( ((String)htFormData.get("item_qty_"+i)).equals(""))) {
				for(int j=0;j<10;j++) {
					// Checking is not needed for the same index	
					if(i != j && ! ( ((String)htFormData.get("item_qty_"+j)).equals("")) ) {
						//String date_from_list = (String)htFormData.get("expiry_date_or_receipt_date_"+j);Changed for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015
						String date_from_list = com.ehis.util.DateUtils.convertDate((String)htFormData.get("expiry_date_or_receipt_date_"+j),"DMY",locale,"en");
						String batch_id_from_list = (String)htFormData.get("batch_id_"+j);
						String bin_location_code_from_list = (String)htFormData.get("bin_location_code_"+j);	
						if( date_from_list.equals(expiry_date_or_receipt_date) && batch_id_from_list.equals(batch_id) && bin_location_code_from_list.equals(bin_location_code) ) {
							result = true;	
							break;
						}
					}
				}
			}
			if(result == true) {
				break;
			}
		}
		return result;
	}


	/** Method to add the exp detail records for a particulat item detail.
	* @param HashTable, containing one set of exp records, for a particular item detail.
	* Assumption made : Always we'll get maximum 10 records from the form for update.
	*/

	public void setValues (Hashtable htFormData) {

		try {
			int iSerialNumber = Integer.parseInt(((String)(htFormData.get("doc_srl_no"))));

			if(iSerialNumber != -1) {
				ArrayList alTemp = new ArrayList();
				int iExpDetailsListSize = expDetailsList.size();
				for(int i=0;i<iExpDetailsListSize;i++) {
					int iList_serial_no = Integer.parseInt(((String)(((HashMap)expDetailsList.get(i)).get("doc_srl_no"))).trim());

					if(! (iList_serial_no == iSerialNumber) ) {
						/** Add this record to the temporary ArrayList*/
						alTemp.add(expDetailsList.get(i));
					}
				}

				/** To clear all the exp detail records corresponding to the
				modified serial number.*/

				expDetailsList.clear();

				for(int i=0;i<alTemp.size();i++) {
					expDetailsList.add(alTemp.get(i));
				}
				alTemp.clear();
			}
			else{
				iSerialNumber=getNextDocSerialNo();
			}

			/** All the incoming records with valid item quantity has to be added to the list*/

			for(int i=0;i<10;i++) {
				String sItem_qty = (String)(htFormData.get("item_qty_"+i));
				if(sItem_qty != null && ! ( sItem_qty.equals("") ) ) {
					HashMap hmRow = new HashMap();
					hmRow.put("doc_srl_no", Integer.toString(iSerialNumber));
					hmRow.put("batch_id", htFormData.get("batch_id_"+i));
					hmRow.put("expiry_date_or_receipt_date", htFormData.get("expiry_date_or_receipt_date_"+i));
					hmRow.put("bin_location_code", htFormData.get("bin_location_code_"+i));
					hmRow.put("trade_id", htFormData.get("trade_id_"+i));
					hmRow.put("item_qty", htFormData.get("item_qty_"+i));
					hmRow.put("item_code", htFormData.get("item_code"));
					hmRow.put("sale_price", htFormData.get("sale_price_"+i)); //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
					hmRow.put("barcode_id", htFormData.get("barcode_id_"+i)); //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
					expDetailsList.add(hmRow);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	*Method to retrive the list of exp details related to the given Serial Number.
	*@param int, serial number.
	*@return ArrayList of HashMaps, containg the exp details, related to the given
	*        serial Number.
	*/

	public ArrayList getDtlExpList(int srl_no) {
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

	public String getTradeList(String item_code,String trade_id,String language) {
       String [] params={item_code,language};

		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),params),trade_id);
	}
	public String getTradeList(String item_code) {
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),item_code));
	}
	public String getTradeListDflt(String trade_id,String language_id) {
		
		String re = getListOptionTag(getWithoutLangIdListOptionArrayList(getStRepositoryValue("SQL_ST_DEFAULT_TRADE_ID")),trade_id);
		return re;
	}
	/**
	* Method to fetch the bin location detials corresponding to the given store code
	* @param String, Store_code, the key to retrive the bin location details
	* @return String, containing the bin location details, as newline separated.
	*/
	
	public String getBinLocationList(String store_code,String bin_location_code) {
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),store_code),bin_location_code);
	}	

	public String getBinLocationList(String store_code) {
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),store_code));
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
