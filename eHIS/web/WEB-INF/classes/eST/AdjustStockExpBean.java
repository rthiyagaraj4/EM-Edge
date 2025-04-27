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
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import com.ehis.util.DateUtils;
import webbeans.eCommon.*;

// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class AdjustStockExpBean extends StTransaction implements Serializable {

	/** ArrayList to hold all the records*/

	ArrayList expDetailsList = new ArrayList();
  String Language_id="";
   private int nextDocSerialNo	=	0;
   ArrayList resultList = new ArrayList();

	public int getNextDocSerialNo(){
		nextDocSerialNo=nextDocSerialNo+1;
		return nextDocSerialNo;
	}

	//new method. 07/09/04
	public void SetNextDocSerialNo(int maxno){
		nextDocSerialNo=maxno;
	}

 public String getLanguage_id()
	{
	return  Language_id;
	}
	public void setLanguage_id(String Language_id)
	{
	Language_id= Language_id;
	
	}


  	/** Method to add the exp detail (batch) records for a particulat item detail.
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
				//int sizeOfExpList = expDetailsList.size ();
/*				if(sizeOfExpList > 0) {
					//String SerialNumber = (String)(((HashMap)(expDetailsList.get(sizeOfExpList-1))).get("doc_srl_no"));
				}*/

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
					if(((String)htFormData.get("adjustment_type")).equals("P")){
						hmRow.put("item_qty", htFormData.get("item_qty_"+i));
					}else{
					hmRow.put("item_qty", "-"+htFormData.get("item_qty_"+i));
					}
					hmRow.put("adjustment_type", htFormData.get("adjustment_type"));
					hmRow.put("first",htFormData.get("first")) ;
					hmRow.put("item_code",htFormData.get("item_code")) ;
					hmRow.put("dec_allowed_yn",htFormData.get("dec_allowed_yn")) ;
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

	public String getTradeList(String item_code,String trade_id,String language_id) {
		ArrayList arr_language=new ArrayList();
		arr_language.add(item_code);
		arr_language.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),arr_language),trade_id);
	}
	public String getTradeList(String item_code,String language_id) {
		ArrayList arr_language=new ArrayList();
		arr_language.add(item_code);
		arr_language.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),arr_language));
	}
	public String getTradeListDflt(String trade_id,String language_id) {
		//ArrayList arr_language=new ArrayList();
			//	arr_language.add(language_id);
			return getListOptionTag(getWithoutLangIdListOptionArrayList(getStRepositoryValue("SQL_ST_DEFAULT_TRADE_ID")),trade_id);
	}
	/**
	* Method to fetch the bin location detials corresponding to the given store code
	* @param String, Store_code, the key to retrive the bin location details
	* @return String, containing the bin location details, as newline separated.
	*/
	
	public String getBinLocationList(String store_code,String bin_location_code,String language_id) {
		ArrayList arr_language=new ArrayList();
		arr_language.add(store_code);
		arr_language.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),bin_location_code);
	}	

	public String getBinLocationList(String store_code,String language_id) {
		ArrayList arr_language=new ArrayList();
		arr_language.add(store_code);
		arr_language.add(language_id);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language));
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

	public void loadAllBatchDetails(String doc_type_code, String doc_no, String doc_srl_no, String item_code) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//ArrayList DataList = new ArrayList();

		try {
			connection = getConnection() ;
		//	pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_ADJUST_STOCK_BATCH_SELECT") ) ;
			pstmt = connection.prepareStatement("SELECT TRADE_ID,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY') EXPIRY_DATE,BATCH_ID, EXP.DOC_SRL_NO, BIN_LOCATION_CODE,(CASE WHEN ITEM_QTY < 0 THEN (-1*ITEM_QTY) ELSE ITEM_QTY END) ITEM_QTY,DTL.ITEM_ADJ_TYPE,ST.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN FROM ST_ADJ_DTL_EXP EXP,ST_ADJ_DTL DTL,ST_ITEM ST WHERE EXP.DOC_TYPE_CODE = ?  AND TO_CHAR (EXP.DOC_NO) = ?  AND TO_CHAR (EXP.DOC_SRL_NO) = ?  AND EXP.ITEM_CODE = ?  AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE  AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE  AND DTL.FACILITY_ID = EXP.FACILITY_ID  AND ST.ITEM_CODE=EXP.ITEM_CODE") ;

			
			pstmt.setString( 1, doc_type_code ) ;
			pstmt.setString( 2, doc_no ) ;
			pstmt.setString( 3, doc_srl_no ) ;
			pstmt.setString( 4, item_code ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
				dataRow.put("item_code",item_code) ;
				dataRow.put("trade_id",resultSet.getString("trade_id")) ;
				dataRow.put("expiry_date_or_receipt_date",resultSet.getString("expiry_date")) ;
				dataRow.put("batch_id",resultSet.getString("batch_id")) ;
				dataRow.put("doc_srl_no",resultSet.getString("doc_srl_no")) ;
				dataRow.put("bin_location_code",resultSet.getString("bin_location_code")) ;
				//if(Integer.parseInt(resultSet.getString("item_qty"))<0){
				//dataRow.put("item_qty",Integer.parseInt(resultSet.getString("item_qty"))*(-1)+"") ;
				//dataRow.put("adjustment_type","N") ;
				//}else{
				dataRow.put("item_qty",resultSet.getString("item_qty")) ;
				dataRow.put("adjustment_type",resultSet.getString("item_adj_type")) ;
				dataRow.put("first","Y") ;
				dataRow.put("dec_allowed_yn",resultSet.getString("allow_decimals_yn")) ;
			//	}
				expDetailsList.add(dataRow);
			}									
			// Initializing the batch details array list.

		} 
		catch ( Exception e )	{
			//DataList.add(e.toString());
			e.printStackTrace() ;			
		} 
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace() ;		
			}
		} 
	} 


	/**
	* Method to check for the dublicate entry in the exp list before adding the records.
	* Assumption made :  always we'll get maximum 10 records...
	* @param Hashtable, all the records in the form of a Hashtable
	* @return boolean, if duplicate exists then true, otherwise false.
	*/

	public boolean isDuplicateInExpList (Hashtable htFormData, String locale) {

		boolean result = false;		
	//	int iExpDetailsListSize = expDetailsList.size();		
		for(int i=0;i<10;i++) {			
			String expiry_date_or_receipt_date = DateUtils.convertDate((String)htFormData.get("expiry_date_or_receipt_date_"+i),"DMY",locale,"en");//(String)htFormData.get("expiry_date_or_receipt_date_"+j);
		//	String expiry_date_or_receipt_date = (String)htFormData.get("expiry_date_or_receipt_date_"+i);
			String batch_id = (String)htFormData.get("batch_id_"+i);
			String bin_location_code = (String)htFormData.get("bin_location_code_"+i);

			if(! ( ((String)htFormData.get("item_qty_"+i)).equals(""))) {
				for(int j=0;j<10;j++) {
					// Checking is not needed for the same index	
					if(i != j && ! ( ((String)htFormData.get("item_qty_"+j)).equals("")) ) {
						String date_from_list = (String)htFormData.get("expiry_date_or_receipt_date_"+j);	
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


public boolean isNegativeAdjustmentAllowed (Hashtable htFormData , String store_code , String item_code ,String locale) {
		
		boolean results = false;
		/**
		* @Name - Priya
		* @Date - 20/01/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - "Qty_onhand" is changed from int to double
		*/
		double Qty_onhand = 0;
		
		for(int i=0;i<10;i++) {			
			String expiry_date_or_receipt_date = DateUtils.convertDate((String)htFormData.get("expiry_date_or_receipt_date_"+i),"DMY",locale,"en");//(String)htFormData.get("expiry_date_or_receipt_date_"+j);
		//	String expiry_date_or_receipt_date = (String)htFormData.get("expiry_date_or_receipt_date_"+i);
			String batch_id = (String)htFormData.get("batch_id_"+i);
			String trade_id = (String)htFormData.get("trade_id_"+i);
			String bin_location_code = (String)htFormData.get("bin_location_code_"+i);

			ArrayList alParameters=new ArrayList();
			alParameters.add(store_code);
			alParameters.add(item_code);
			alParameters.add(batch_id);
			alParameters.add(trade_id);
			alParameters.add(expiry_date_or_receipt_date);
			alParameters.add(bin_location_code);
			HashMap hmResult=new HashMap();

			if(! ((String)htFormData.get("item_qty_"+i)).equals("") ){
				try{

					try{
					

						hmResult=fetchRecord(getStRepositoryValue("SQL_ST_STOCK_NEGATIVE_ADJUSTMENT_ALLOWED"),alParameters);
						/**
						* @Name - Priya
						* @Date - 20/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - "Qty_onhand" is changed from int to double
						*/
						Qty_onhand = Double.parseDouble((String)hmResult.get("QTY_ON_HAND"));
					} catch(Exception ex){
						Qty_onhand= 0 ;
					}
					 /**
						* @Name - Priya
						* @Date - 20/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - "item_qty_" is changed from int to double
						*/

					if(  (  Double.parseDouble( (String)htFormData.get("item_qty_"+i) ) + Qty_onhand  ) < 0  )
							results =  true;
				
				}
					catch(Exception e) {

							e.printStackTrace();
					}
			}
				if(results == true) {
						break;
							}
		}
		return results;
	}



public String isBatchIdExits (Hashtable htFormData,String store_code , String item_code,String locale) {
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	String batchexitsid ="";
	boolean result = false;		
	//int iExpDetailsListSize = expDetailsList.size();
	try {
		connection = getConnection() ;
		pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS") ) ;
		for(int i=0;i<10;i++)
		{			
	//	String expiry_date_or_receipt_date = (String)htFormData.get("expiry_date_or_receipt_date_"+i);
		//String batch_id = (String)htFormData.get("batch_id_"+i);
		//String bin_location_code = (String)htFormData.get("bin_location_code_"+i);
		if(! ( ((String)htFormData.get("item_qty_"+i)).equals("")))
		{
			for(int j=0;j<10;j++)
			{
				if(! ( ((String)htFormData.get("item_qty_"+j)).equals("")) )
				{

				//	System.out.println("DATE "+htFormData.get("expiry_date_or_receipt_date_"+j));
				//	System.out.println("getLanguageId() "+getLanguageId());
					String date_from_list = DateUtils.convertDate((String)htFormData.get("expiry_date_or_receipt_date_"+j),"DMY",locale,"en");//(String)htFormData.get("expiry_date_or_receipt_date_"+j);	
					String batch_id_from_list = (String)htFormData.get("batch_id_"+j);
				//	String bin_location_code_from_list = (String)htFormData.get("bin_location_code_"+j);	
			//	System.out.println("date_from_list@@@===>"+date_from_list);
					String result_count ="";
					pstmt.setString( 1, item_code ) ;
					pstmt.setString( 2, batch_id_from_list ) ;
					pstmt.setString( 3, date_from_list ) ;
					resultSet = pstmt.executeQuery() ;
					if(resultSet.next()){
					result_count=(String)resultSet.getString("count");
					}
				closeResultSet( resultSet ) ;

					if ( result_count.equals("0")) 
					{
						batchexitsid =batchexitsid +"$ Expiry Date :"+date_from_list+" Batch ID :"+batch_id_from_list;
						result = true;
					}								
					
				}
			}

		}
		
		if(result == true) 
			{
				break;
			}
		} 
		}
		catch ( Exception e )	{
			
			e.printStackTrace() ;			
		} 
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace() ;		
			}
			}

		return batchexitsid;
		
	}
	


}



