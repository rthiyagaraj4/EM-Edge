/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
//import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import eST.GoodsReturnToVendor.*;
import java.io.Serializable;
import java.util.*;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import javax.sql.*;
import javax.servlet.* ;
import javax.servlet.http.*;

import java.text.SimpleDateFormat; 

public class GoodsReturnToVendorBean extends StHeaderBean implements Serializable{

	private String entry_completed_yn;
	private String currency_code;
	private String supp_code;
	private String po_no;
	private String finalized_yn;  
	private String records_to_delete;
	private String receipt_date;
	//private String language_id;
	private String replacement_grn_yn;
	//private String PDocNo = "";
	private ArrayList PDocNo ;
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String stReportid = null;
	public String reportserver = "";
	public String report_connect_string = "";


	private HashMap		hmExpRecords=new HashMap();
	private HashMap		hmExpRecords_temp=new HashMap();
	private ArrayList	alDtlRecords=new ArrayList();
	public double dAvg_unit_cost;
	private HashMap		hmMm_parameter=new HashMap();
	
	private int doc_srl_no	=	0;
	private double tmpConv=1;
	private String manufacturerId="";//added for MO-CRF-20165 START
	private String grnRemarks = ""; 
	private String itemRemarks = "";
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
	
/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/
	public void setTempConvFact(double tmpConv){
		this.tmpConv=tmpConv;
	}
	public double getTempConvFact(){
		return tmpConv;
	}

	public void setReceipt_date(String receipt_date) {
		 this.receipt_date= receipt_date;  
	}

	public String getReceipt_date( ) {
		 return receipt_date;
	}

	public void setPo_no(String po_no) {
		 this.po_no= checkForNull(po_no);
	}

	public String getPo_no( ) {
		 return po_no;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn= finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}
/*	public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete= records_to_delete;
	}

	public String getRecords_to_delete( ) {
		 return records_to_delete;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = checkForNull(entry_completed_yn, "N");
	}

	public String getEntry_completed_yn( ) {
		 return entry_completed_yn;
	}

	public void setCurrency_code(String currency_code) {
		 this.currency_code = checkForNull(currency_code);
	}

	public String getCurrency_code( ) {
		 return currency_code;
	}

	public void setSupp_code(String supp_code) {
		 this.supp_code = checkForNull(supp_code);
	}

	public String getSupp_code( ) {
		 return supp_code;
	}

	public void setReplacement_grn_yn(String replacement_grn_yn) {
		 this.replacement_grn_yn= checkForNull(replacement_grn_yn, "N");
	}

	public String getReplacement_grn_yn() {
		 return replacement_grn_yn;
	}


	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	public int getDoc_srl_no(){
		return doc_srl_no;
	}

	public void setDoc_srl_no(String doc_srl_no){
		this.doc_srl_no=Integer.parseInt(doc_srl_no);
	}
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}

	public void updateDtlRecord(int index, HashMap hmDtlRecord){
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		if (index!=-1){
			mode	=	(String)((HashMap)alDtlRecords.get(index)).get("mode");
		}
		hmDtlRecord.put("mode",mode);
		
		if (index==-1){
			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
//			mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
			alDtlRecords.add(hmDtlRecord);
		}
		else
			alDtlRecords.set(index, hmDtlRecord);
	} 

	public HashMap getDtlRecord(int index){
	
		if(alDtlRecords!=null && alDtlRecords.size()>index)
			return (HashMap)alDtlRecords.get(index);
		else
			return null;
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}

	public String getExpYN(String item_code) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String expiry_yn		  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(getStRepositoryValue("SQL_ST_EXPYN_SELECT"));
			pstmt.setString(1,item_code);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
			  expiry_yn=	resultSet.getString("expiry_yn");
			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}

		return expiry_yn;
	}


	/*public String getExpYN(String item_code) {
		String itemcode="";
		try {
			itemcode=fetchRecord(getStRepositoryValue("SQL_ST_EXPYN_SELECT"), item_code).get("EXPIRY_YN").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return itemcode;
    }*/


	public String getDoc_type_desc(String doc_type_code) {
		String doc_type_desc = "";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(doc_type_code);
			arr_language.add(getLanguageId());
			doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return doc_type_desc;
    }

	public String getStore_desc(String store_code) {
		String store_desc="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
			store_desc=fetchRecord(getStRepositoryValue("SQL_ST_OPENING_STOCK_STORE"), arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return store_desc;
    }

	public String getBinLocation_desc(String bin_code) {
		String bin_desc="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(bin_code);
			arr_language.add(getLanguageId());
			bin_desc=fetchRecord(getStRepositoryValue("SQL_ST_BIN_LOCATION_DESC"), arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return bin_desc;
    }

	public void updateExpRecords(int index, Hashtable htExpRecords){
		try { 

					ArrayList alExpRecords	=	new ArrayList();//)hmExpRecords.get(""+index);
					if (index==-1) {
						index	=	alDtlRecords.size()-1;
					}
					alExpRecords	=	(ArrayList)hmExpRecords.get(""+index);
					

				//	int total	=	Integer.parseInt((String)htExpRecords.get("total_checkboxes"));
					double dTotalValue=0;
					int i,totalSelectedRecord=0;
					HashMap hmExpRecord = null;

					for (i=0, totalSelectedRecord=0;i<alExpRecords.size(); i++) {
						totalSelectedRecord++;
						
						if (htExpRecords.get("item_qty_"+i).toString().equals(""))
							continue;
						hmExpRecord	=	(HashMap) alExpRecords.get(i);
						hmExpRecord.put("RTV_ITEM_QTY",		htExpRecords.get("item_qty_"+i));
						dTotalValue=dTotalValue+Double.parseDouble((String)htExpRecords.get("grn_unit_cost_in_pur_uom_"+i));
						alExpRecords.set(i,hmExpRecord);
					}

					//*********batch problem
					ArrayList tempExpRecords = new ArrayList();
					for(int j=0; j<alExpRecords.size(); j++){
//						if( !(((String)((HashMap)alExpRecords.get(j)).get("RTV_ITEM_QTY")).equals("") ||  ((String)((HashMap)alExpRecords.get(j)).get("RTV_ITEM_QTY")).equals("0"))){

						if (!(htExpRecords.get("item_qty_"+j).toString().equals("") || htExpRecords.get("item_qty_"+j).toString().equals("0"))){
						
							tempExpRecords.add(alExpRecords.get(j));
						}
					}

					alExpRecords = tempExpRecords;

					//*********batch problem

					dAvg_unit_cost=(dTotalValue/totalSelectedRecord);
					setExpRecords(index, alExpRecords);
					setExpRecords_temp(index, alExpRecords);
				
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void setExpRecords(int index, ArrayList alExpRecords){
		if (index==-1) {
			index	=	alDtlRecords.size();
		}
		hmExpRecords.put(""+index,alExpRecords);
	}
	
	public ArrayList getExpRecords_temp(int index){
		return (ArrayList)hmExpRecords_temp.get(""+index);
	}
	public void setExpRecords_temp(int index, ArrayList alExpRecords){
		if (index==-1) {
			index	=	alDtlRecords.size();
		}
		hmExpRecords_temp.put(""+index,alExpRecords);
	}

	public ArrayList getExpRecords(int index){
		return (ArrayList)hmExpRecords.get(""+index);
	}

	public HashMap getExpRecords(){
		return hmExpRecords;
	}
	
	public HashMap getMm_parameter(){
		return hmMm_parameter;
	}

	public String getBatchIDFromExpiryDate (String expiry_date) {
		StringBuffer stringBuffer= new StringBuffer(expiry_date);
		stringBuffer.deleteCharAt(5);
		stringBuffer.deleteCharAt(3);
		return stringBuffer.toString();
	}	
	
	public String getTrade_id_List(String item_code,String trade_id) {
		    ArrayList arr_language=new ArrayList();
			arr_language.add(item_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),arr_language),trade_id);
	}
	public String getTrade_id_List(String item_code) {
		   ArrayList arr_language=new ArrayList();
			arr_language.add(item_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),arr_language));
	}

 public ArrayList getDefltTrdId() {
        
        ArrayList alDfltTrdId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
		
			String select_option=getSTMessage(getLanguageId(),"SELECT_OPTION","ST") ;
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alDfltTrdId.add(select_option_legend);
//*			String stDfltTradeId="";
            connection = getConnection();
				
				
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_DEFAULT_TRADE_ID"));
 		    resultSet = pstmt.executeQuery();
			
            while (resultSet != null && resultSet.next()) {
				
alDfltTrdId.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
				
			   }
		    }
			catch (Exception e) {
                      e.printStackTrace();
             } 
		    finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
                   }
				   
          return alDfltTrdId;
	  }
	public String getTrade_id_Default_List(String trade_id) {
		 
		return getListOptionTag(getDefltTrdId(),trade_id);
	}

	public String getBin_location_code_List(String store_code,String bin_location_code) {
		   ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),bin_location_code);
	}	

	public String getBin_location_code_List(String store_code) {
		    ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language));
	}	

	public void  clear(){
		super.clear();
		hmExpRecords=null;  
		hmExpRecords_temp = null;
		alDtlRecords=null;
		doc_srl_no	=	0;
		entry_completed_yn=null;  
        replacement_grn_yn=null;  
		currency_code=null;
		supp_code=null;
		po_no=null; 
		finalized_yn=null;     
		receipt_date=null;
		hmMm_parameter=null;
		records_to_delete=null;
	}

	public void  initialize(){
		super.initialize();
		hmExpRecords=new HashMap();  
		hmExpRecords_temp=new HashMap();  
		alDtlRecords=new ArrayList();
		doc_srl_no	=	0;
		entry_completed_yn="";  
		replacement_grn_yn="";  
		currency_code="";
		supp_code="";
		po_no=""; 
		finalized_yn="";     
		try { 
			receipt_date=getSystemDate();
			hmMm_parameter=fetchRecord(getStRepositoryValue("SQL_MM_PARAMETER_SELECT_SINGLE"),"MM");
		}
		catch (Exception exception) {
			receipt_date="Exception";
			exception.printStackTrace();
		}
		records_to_delete="";
	}

	public void setAll(Hashtable hashtable) {
		setEntry_completed_yn((String)hashtable.get("entry_completed_yn"));  
		//added on 17/07/2004 
		setReplacement_grn_yn((String)hashtable.get("replacement_grn_yn"));  

       //sal_trn_type=(String)hashtable.get("sal_trn_type");  
		setReceipt_date((String)hashtable.get("receipt_date"));  
		setCurrency_code((String)hashtable.get("currency_code"));  
		supp_code=(String)hashtable.get("supp_code");  
		po_no =(String)hashtable.get("po_no");  
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		records_to_delete=(String)hashtable.get("records_to_delete");  

    }

	public String getCurrency_code_List(){
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_SY_FOREIGN_CURRENCY_SELECT_LIST")),getCurrency_code());
	}

	public String getPur_uom_code_List(String defaultValue){
		  ArrayList arr_language=new ArrayList();
		//	arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_AM_UOM_SELECT_FOR_GRN"),arr_language),defaultValue);
	} 

	public String getStock_item_yn(String item_code, String store_code) throws Exception{
		return (String)fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_SELECT_FOR_GRN"),new String[]{item_code, store_code}).get("STOCK_ITEM_YN");
	}

	public String getLabel_reqd_yn(String item_code) throws Exception{
		return (String)fetchRecord(getStRepositoryValue("SQL_ST_LOAD_QUERY"),item_code).get("LABEL_REQD_YN");
	}

	public HashMap validate(){
 		return getMessageHashMap(true);	
	}

	public String getSupp_code_List() {
		ArrayList arr_language=new ArrayList();
			//arr_language.add(getSupp_code());
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),arr_language),getSupp_code());
    }
	
	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167
	
	
	public void loadData() throws Exception{
		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_RTV_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		
		doc_srl_no		=	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_RTV_HDR_SELECT_SINGLE"), alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setStore_code((String)hmRecord.get ("STORE_CODE"));  
		setEntry_completed_yn((String)hmRecord.get ("ENTRY_COMPLETED_YN"));  
		setReplacement_grn_yn((String)hmRecord.get ("RTV_FOR_REPLACEMENT_YN"));  

		
		setCurrency_code((String)hmRecord.get("CURRENCY_CODE"));
		setSupp_code((String)hmRecord.get("SUPP_CODE"));
		setReceipt_date((String)hmRecord.get("RECEIPT_DATE"));
		setPo_no((String)hmRecord.get("PO_NO"));
		setItem_class_code((String)hmRecord.get("ITEM_CLASS_CODE"));

		alParameters.add(0,getSupp_code());
		alParameters.add(0,getSupp_code());
		alParameters.clear();
		alParameters.add(getSupp_code());
		alParameters.add(getSupp_code());
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
		ArrayList alRecords	=	fetchRecords("SELECT dtl.doc_srl_no, dtl.item_code, mmitem.short_desc item_desc, dtl.item_qty_normal, dtl.item_qty_bonus, dtl.item_qty_sample, dtl.item_cost_value, dtl.stock_item_yn, dtl.rtv_unit_cost, am.short_desc gen_uom_desc, am.uom_code, dtl.remarks, DECODE(dtl.item_code,NULL,0, (SELECT SUM(item_qty_normal-NVL(rtv_item_qty_normal,0))+NVL(dtl.item_qty_normal,0) max_returnable_normal FROM st_grn_hdr grnhdr, st_grn_dtl grndtl WHERE grnhdr.facility_id=grndtl.facility_id AND grnhdr.doc_type_code=grndtl.doc_type_code AND grnhdr.doc_no=grndtl.doc_no AND grnhdr.finalized_yn='Y' AND grnhdr.facility_id=dtl.facility_id AND grndtl.item_code=dtl.item_code AND grnhdr.supp_code=?)) max_item_qty_normal, DECODE(dtl.item_code,NULL,0, (SELECT SUM(NVL(item_qty_bonus,0)-NVL(rtv_item_qty_bonus,0)) max_item_qty_bonus FROM st_grn_hdr grnhdr, st_grn_dtl grndtl WHERE grnhdr.facility_id=grndtl.facility_id AND grnhdr.doc_type_code=grndtl.doc_type_code AND grnhdr.doc_no=grndtl.doc_no AND grnhdr.finalized_yn='Y' AND grnhdr.facility_id=dtl.facility_id AND grndtl.item_code=dtl.item_code AND grnhdr.supp_code=?))+NVL(dtl.item_qty_bonus,0) max_item_qty_bonus, am1.short_desc uom_desc,stitem.allow_decimals_yn allow_decimals_yn  /*,(SELECT pur_uom_conv FROM ST_GRN_DTL grndtl WHERE (facility_id, doc_type_code, doc_no, item_code) IN (SELECT facility_id, grn_doc_type_code, grn_doc_no, item_code FROM ST_RTV_DTL_EXP rtvexp WHERE rtvexp.facility_id=dtl.facility_id AND rtvexp.doc_type_code=dtl.doc_type_code AND rtvexp.doc_no=dtl.doc_no AND rtvexp.item_code=dtl.item_code)) pur_uom_conv */FROM st_rtv_dtl dtl, mm_item_lang_vw mmitem, st_item stitem, am_uom_lang_vw am, ST_ITEM_STORE stst, ST_RTV_HDR hdr, am_uom_lang_vw am1 WHERE mmitem.item_code=dtl.item_code AND stitem.item_code=dtl.item_code AND mmitem.gen_uom_code=am.uom_code AND dtl.facility_id=? AND dtl.doc_type_code=? AND dtl.doc_no= ? AND mmitem.language_id = am.language_id AND am.language_id = ?   AND am1.language_id = am.language_id   AND stst.item_code = stitem.item_code   AND hdr.store_code = stst.store_code    AND hdr.doc_no = dtl.DOC_NO    AND hdr.doc_type_code = dtl.doc_type_code  AND am1.uom_code = stst.def_issue_uom order by doc_srl_no", alParameters);
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
			hmTemp.put("item_qty_bonus",checkForNull((String)hmRecord.get("ITEM_QTY_BONUS")));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("item_qty_normal",hmRecord.get("ITEM_QTY_NORMAL"));
			hmTemp.put("item_qty_sample",checkForNull((String)hmRecord.get("ITEM_QTY_SAMPLE")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("max_item_qty_bonus",checkForNull((String)hmRecord.get("MAX_ITEM_QTY_BONUS")));   
			hmTemp.put("max_item_qty_normal",checkForNull((String)hmRecord.get("MAX_ITEM_QTY_NORMAL"))); 
			hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS"))); 
			hmTemp.put("gen_uom_desc",checkForNull((String)hmRecord.get("GEN_UOM_DESC"))); 
            hmTemp.put("allow_deci_yn",checkForNull((String)hmRecord.get("ALLOW_DECIMALS_YN"),"N"));
			hmTemp.put("no_deci", checkForNull((""+getNoOfDecimals()),"0"));

			alDtlRecords.add(hmTemp);
		}

		alParameters.remove(0);
		alParameters.remove(0);
		alParameters.add("%");
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());

		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			alParameters.set(3,(String)hmRecord.get("doc_srl_no"));
			
			alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_RTV_DTL_EXP_SELECT_MULTIPLE"), alParameters);

			/*for (int j=0; j<alRecords.size(); j++) {
				HashMap hmTemp	=	new HashMap();	
				HashMap hmTempRecord=	(HashMap)alRecords.get(j);
				hmTemp.put("item_qty", hmTempRecord.get("ITEM_QTY"));             
				hmTemp.put("trade_id", hmTempRecord.get("TRADE_ID"));                 
				hmTemp.put("expiry_date_or_receipt_date", hmTempRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				hmTemp.put("item_code", hmTempRecord.get("ITEM_CODE"));                
				hmTemp.put("store_code", hmTempRecord.get("STORE_CODE"));               
				hmTemp.put("batch_id", hmTempRecord.get("BATCH_ID"));                 
				hmTemp.put("bin_location_code", hmTempRecord.get("BIN_LOCATION_CODE"));        
				alRecords.set(j, hmTemp);
			}*/

			hmExpRecords.put(""+i,alRecords);
			hmExpRecords_temp.put(""+i,alRecords);
		}
        
	}



	public HashMap insert(){
 		//HashMap hmResult=new HashMap();
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		//ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList languageData		=	new ArrayList();
		//ArrayList alCommonData	=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hmHeader		=	new HashMap();

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		
		hmHeader.put("facility_id",getLoginFacilityId());
		hmHeader.put("doc_type_code", getDoc_type_code());

		hmHeader.put("doc_no", getDoc_no());
		hmHeader.put("doc_date", getDoc_date());
		hmHeader.put("doc_ref", getDoc_ref());
		hmHeader.put("store_code", getStore_code());
		hmHeader.put("finalized_yn", getFinalized_yn());
		hmHeader.put("item_class_code", getItem_class_code());
		hmHeader.put("gl_interfaced_yn", "N");//gl_interface
		hmHeader.put("trn_type", "RTV");
		hmHeader.put("supp_code", getSupp_code());
		hmHeader.put("entry_completed_yn", getEntry_completed_yn());
//added on 17/07/2004
		hmHeader.put("replacement_grn_yn", getReplacement_grn_yn());
   
		languageData.add(getLanguageId());
		try {
//alDtlRecords
				boolean isDocNoAutoGenYN = isDocNoAutoGenYN(getDoc_type_code());
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			for (int i=0;i<alDtlRecords.size();i++) {
				String nextToken = stRecordsToDelete.nextToken();
				HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							alExpData.add(hmExpRecord);
						}
				}
				//hmDtlRecord.put("to_conv_fact",""+getTempConvFact());
				alDtlData.add(hmDtlRecord);
			}
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		hmHeader);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	hmCommonData);
			hmTableData.put("LANGUAGE_DATA",	languageData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));

			hmSQLMap.put("SQL_ST_ITEM_VALUE_SELECT", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SQL_ST_ITEM_MASTER_UPDATE", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_QTY_UPDATE", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
			hmSQLMap.put("SQL_ST_RTV_HDR_INSERT", getStRepositoryValue("SQL_ST_RTV_HDR_INSERT"));
			hmSQLMap.put("SQL_ST_RTV_DTL_INSERT", getStRepositoryValue("SQL_ST_RTV_DTL_INSERT"));
			hmSQLMap.put("SQL_ST_RTV_DTL_EXP_INSERT", getStRepositoryValue("SQL_ST_RTV_DTL_EXP_INSERT"));
			hmSQLMap.put("SQL_ST_BATCH_CONTROL_INSERT", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("SQL_ST_CHECK_ITEM_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_INSERT", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("SQL_ST_GET_ITEM_BATCH_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_DELETE", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_UPDATE", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_BATCH_FOR_RTV"));
			hmSQLMap.put("SQL_ST_GET_MONTH_AND_YEAR", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("SQL_ST_GET_ITEM_STORE_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_RTV"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_RTV"));
			hmSQLMap.put("SQL_ST_CHECK_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_RTV"));
			hmSQLMap.put("SQL_ST_GRN_DTL_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
			hmSQLMap.put("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		if((getItemClassBased("RTV").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"RTV");
		}
		return goodsReturnToVendorMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap delete(){
 		//HashMap hmResult		=	new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		//ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hmHeader		=	new HashMap();

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		hmHeader.put("facility_id",getLoginFacilityId()			);
		hmHeader.put("doc_type_code",getDoc_type_code()		);

		hmHeader.put("doc_no",getDoc_no()	);

		hmTableData.put("properties",	getProperties());
		hmTableData.put("DATA",			hmHeader);
		hmTableData.put("COMMON_DATA",	hmCommonData);

		hmSQLMap.put("SQL_ST_RTV_DTL_EXP_DELETE_ALL",getStRepositoryValue("SQL_ST_RTV_DTL_EXP_DELETE_ALL"));
		hmSQLMap.put("SQL_ST_RTV_DTL_DELETE_ALL"	,getStRepositoryValue("SQL_ST_RTV_DTL_DELETE_ALL"));
		hmSQLMap.put("SQL_ST_RTV_HDR_DELETE"		,getStRepositoryValue("SQL_ST_RTV_HDR_DELETE"));
		hmSQLMap.put("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL"		,getStRepositoryValue("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL"));
		hmSQLMap.put("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE", getStRepositoryValue("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE"));
		hmSQLMap.put("SQL_ST_GRN_DTL_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
		hmSQLMap.put("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));

		return goodsReturnToVendorMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}

	public HashMap modify(){
 		HashMap hmResult=new HashMap();;
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_RTV_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?  AND FINALIZED_YN='Y'",alParam)).get("COUNT"));
		}catch(Exception e){
			hmResult.put("result",false);
			hmResult.put("msgid","OPER_CANCELLED");
			hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
			e.printStackTrace();
			return hmResult;
		}
		if(doc_count>0){
			hmResult.put("result",false);
			hmResult.put("msgid","ST_DOC_NO_FINALIZED_USER");
			hmResult.put("message",getSTMessage(getLanguageId(),"ST_DOC_NO_FINALIZED_USER","ST"));
			return hmResult;
		}
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmData			=	new HashMap();
	//	ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hmHeader		=	new HashMap();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList languageData	=	new ArrayList();

		try { 

			hmCommonData.put("login_by_id",getLoginById()			);
			hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
			hmCommonData.put("login_facility_id",getLoginFacilityId()	);

			hmHeader.put("facility_id",getLoginFacilityId());
			hmHeader.put("doc_type_code",getDoc_type_code());

			hmHeader.put("doc_no",getDoc_no());
			hmHeader.put("doc_date",getDoc_date());
			hmHeader.put("doc_ref",getDoc_ref());
			hmHeader.put("store_code",getStore_code());
			hmHeader.put("finalized_yn",getFinalized_yn());
			hmHeader.put("gl_interfaced_yn","N");
			hmHeader.put("trn_type","RTV");
			hmHeader.put("supp_code",getSupp_code());
			hmHeader.put("currency_code",getCurrency_code());
			hmHeader.put("entry_completed_yn",getEntry_completed_yn());
			//added 0n 19_07_2004
            hmHeader.put("replacement_grn_yn",getReplacement_grn_yn());
			hmHeader.put("receipt_date",getReceipt_date());
			hmHeader.put("po_no",getPo_no());
			languageData.add(getLanguageId());



			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			for (int i=0;i<alDtlRecords.size();i++) {
				String nextToken = stRecordsToDelete.nextToken();
				HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							alExpData.add(hmExpRecord);
						}
				}
				hmDtlRecord.put("to_conv_fact",""+getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code()));
				alDtlData.add(hmDtlRecord);
			}


			hmData.put("properties",	getProperties());
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("COMMON_DATA",hmCommonData);
			hmData.put("LANGUAGE_DATA",	languageData);

			hmSQLMap.put("SQL_ST_ITEM_VALUE_SELECT", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SQL_ST_ITEM_MASTER_UPDATE", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_QTY_UPDATE", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
			hmSQLMap.put("SQL_ST_RTV_HDR_INSERT", getStRepositoryValue("SQL_ST_RTV_HDR_INSERT"));
			hmSQLMap.put("SQL_ST_RTV_DTL_INSERT", getStRepositoryValue("SQL_ST_RTV_DTL_INSERT"));
			hmSQLMap.put("SQL_ST_RTV_DTL_EXP_INSERT", getStRepositoryValue("SQL_ST_RTV_DTL_EXP_INSERT"));
			hmSQLMap.put("SQL_ST_BATCH_CONTROL_INSERT", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("SQL_ST_CHECK_ITEM_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_INSERT", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("SQL_ST_GET_ITEM_BATCH_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_DELETE", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_UPDATE", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_BATCH_FOR_RTV"));
			hmSQLMap.put("SQL_ST_GET_MONTH_AND_YEAR", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("SQL_ST_GET_ITEM_STORE_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_RTV"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_RTV"));
			hmSQLMap.put("SQL_ST_CHECK_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_RTV", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_RTV"));

			hmSQLMap.put("SQL_ST_RTV_HDR_UPDATE"	, getStRepositoryValue("SQL_ST_RTV_HDR_UPDATE"	));
			hmSQLMap.put("SQL_ST_RTV_DTL_UPDATE"	, getStRepositoryValue("SQL_ST_RTV_DTL_UPDATE"	));

			hmSQLMap.put("SQL_ST_RTV_DTL_DELETE"	, getStRepositoryValue("SQL_ST_RTV_DTL_DELETE"	));
			hmSQLMap.put("SQL_ST_RTV_DTL_EXP_DELETE", getStRepositoryValue("SQL_ST_RTV_DTL_EXP_DELETE"));

			hmSQLMap.put("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE", getStRepositoryValue("SQL_ST_RTV_DTL_SELECT_GRN_UPDATE"));
			hmSQLMap.put("SQL_ST_GRN_DTL_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_GRN_DTL_UPDATE_FOR_RTV"));
			hmSQLMap.put("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL", getStRepositoryValue("SQL_ST_RTV_DTL_EXP_SELECT_FOR_BLOCK_REL"));
			hmSQLMap.put("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV", getStRepositoryValue("SQL_ST_GRN_DTL_EXP_UPDATE_FOR_RTV"));
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return goodsReturnToVendorMethodCall(hmData, hmSQLMap, FUNCTION_UPDATE );
	}

	public HashMap getMaxReturnableQty(String stItem_code, String stSupp_code)throws Exception{
		
		return fetchRecord(getStRepositoryValue("SQL_ST_RTV_MAX_RETURNABLE_SELECT"), new String[]{getLoginFacilityId(), stItem_code, stSupp_code,getStore_code()});
	}
	
	public HashMap goodsReturnToVendorMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
/*
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = new eST.GoodsReturnToVendor12.GoodsReturnToVendorManager().insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					hmResult = new eST.GoodsReturnToVendor12.GoodsReturnToVendorManager().modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					hmResult = new eST.GoodsReturnToVendor12.GoodsReturnToVendorManager().delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to goodsReturnToVendorMethodCall()") ;
			}

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

		return hmResult;
*/
		HashMap		hmResult	=	new HashMap()	;
		//GoodsReturnToVendorHome	goodsReceivedNoteHome		= null ;
		GoodsReturnToVendorRemote	goodsReceivedNoteRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			/*InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_GOODS_RETURN_TO_VENDOR") ) ;

			goodsReceivedNoteHome  = (GoodsReturnToVendorHome) PortableRemoteObject.narrow( object, GoodsReturnToVendorHome.class ) ;
			goodsReceivedNoteRemote = goodsReceivedNoteHome.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_GOODS_RETURN_TO_VENDOR"),GoodsReturnToVendorLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			switch (functionID)
			{
				case FUNCTION_INSERT:
					 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

					//hmResult = goodsReceivedNoteRemote.insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);

					//hmResult = goodsReceivedNoteRemote.modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

					//hmResult = goodsReceivedNoteRemote.delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to goodsReturnToVendorMethodCall()") ;
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

			
			// Added for Online Printing on 9/24/2004		
/* SEND TO PRINT ONLINE REPORT STARTS*/		

		//	String doc_no	=	(String)hmResult.get("doc_no");	
		    ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();

			PgetStore_codest  = getStore_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBRTVDC";
		    if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{

						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}
						else{
							/*doOnlineReportPrinting(doc_no);
							String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}*/
							hmResult.put("flag",hmResult.get("flag") + "~PN");
						}
				 }
			}
/* SEND TO PRINT ONLINE REPORT ENDS*/	
		} 
		catch(Exception exception) {
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( goodsReceivedNoteRemote != null )
					goodsReceivedNoteRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 732: "+exception.toString()) ;
			}
		}

/*			if (finalized_yn.equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (isInternalRequest("ST","STBRTVDC")) {
				String doc_no	=	(String)hmResult.get("doc_no");	
				doOnlineReportPrinting(doc_no);				
			}
		}*/

		return hmResult;
	}
	/*public void doOnlineReportPrinting(String doc_no) {
		try{
			String reportid = "STBRTVDC";
			if (!isInternalRequest("ST",reportid)) return;
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			   hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

        //    javax.servlet.http.HttpSession session = request.getSession(false);
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			//hmParameters.put("jdbc",session.getAttribute("jdbc"));
			//hmParameters.put("report_server",session.getAttribute("report_server"));
			//hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());

			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/
	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBRTVDC";
			//String copies = getNoOfCopies(reportid);

			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;

				if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "STBRTVDC";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", getStore_code());
			//((StDuoHeaderBean)getStHeaderBean()).getFrom_store_code();

			reportParam.addParameter("p_module_id","ST");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());
			reportParam.addParameter("p_doc_type_code",getDoc_type_code());
//			reportParam.addParameter("p_fr_st_code",getStore_code());
			reportParam.addParameter("p_doc_no",doc_no);
			reportParam.addParameter("p_fr_date",getDoc_date());
			reportParam.addParameter("p_to_date",getDoc_date());


			onlineReports.add(reportParam) ;
			String ReportOutput = onlineReports.execute( request, response);
		
		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	}
*/
	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("RTV_FINALIZE_ALLOWED_YN").toString();
	}
/*public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1.0;
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		ArrayList alParameters = new ArrayList();
		try {
			
			
			alParameters.add(item_code);
			alParameters.add(store_code);

			 conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT St_Get_Uom_Conv_Fac_Sing_Str(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return conv_fac_temp;
	}*/
	public String getRTVItemClassBased(String trntype)
	{
		String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				//records = fetchRecord("SELECT     ITEM_CLASS_BASED_YN   FROM     st_trn_type_lang_vw   WHERE   TRN_TYPE= ? AND LANGUAGE_ID=?",chkdefaultParameters);
				records = fetchRecord(getStRepositoryValue("SQL_ST_GRN_ITEM_CLASS_BASED_YN"),chkdefaultParameters);
				result=(String)records.get("ITEM_CLASS_BASED_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
public HashMap modifiedTableData(HashMap hmTableData,String trn_type){
		String item_class_code = "";
		int records_per_trn = getRecordsPerTrn(trn_type);
		ArrayList<Integer> alCount =  new ArrayList<Integer>();
		HashMap<String,String> hmTempData = new HashMap<String,String>();
		HashMap<String,String> hmTempExpData = new HashMap<String,String>();
		ArrayList<HashMap> alNewTempDtlData = new ArrayList<HashMap>();
		ArrayList<HashMap> alNewTempDtlExpData = new ArrayList<HashMap>();
		ArrayList<String> alItemClassData = new ArrayList<String>();
		ArrayList<String> alNewItemClassData = new ArrayList<String>();
		ArrayList<HashMap> alItemDtlData = (ArrayList<HashMap>)hmTableData.get("DTL_DATA");
		ArrayList<HashMap> alItemDtlExpData = (ArrayList<HashMap>)hmTableData.get("DTL_EXP_DATA");
	//	ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
	//	HashMap<String,String> hmItemHdrData = (HashMap<String,String>)hmTableData.get("HDR_DATA");
		for(int i=0;i<alItemDtlData.size();i++){
			hmTempData = (HashMap<String,String>)alItemDtlData.get(i);
			try{
				item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
				if(!alItemClassData.contains(item_class_code)){
					alItemClassData.add(item_class_code);
				}
				//alItemClassData.add((String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(4)).get("ITEM_CLASS_CODE"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Collections.sort(alItemClassData);
		for(int i=0;i<alItemClassData.size();i++){
			alNewItemClassData.add(alItemClassData.get(i));
		}
		item_class_code = "";
		for(int i=0;i<alItemClassData.size();i++){
			int k = 0;
			//int count = 0;
			for(int j=0;j<alItemDtlData.size();j++){
				hmTempData = new HashMap<String,String>();
				hmTempData = alItemDtlData.get(j);
				//hmTempExpData = (HashMap<String,String>)alItemDtlExpData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
						//++count;
						if(k>=records_per_trn){
							alCount.add(k);
							k = 0;
							alNewItemClassData.add(item_class_code);
						}
						hmTempData.put("doc_srl_no",""+ (++k));
						alNewTempDtlData.add(alItemDtlData.get(j));
						for(int m=0;m<alItemDtlExpData.size();m++){
							hmTempExpData = new HashMap<String,String>();
							hmTempExpData = alItemDtlExpData.get(m);
							if((hmTempExpData.get("ITEM_CODE")).equals(hmTempData.get("item_code"))){
								hmTempExpData.put("doc_srl_no",""+k);
								alNewTempDtlExpData.add(alItemDtlExpData.get(m));
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			alCount.add(k);
		}
		Collections.sort(alNewItemClassData);
		/*for(int i=0;i<alNewItemClassData.size();i++){
			ArrayList<String> alTemp = new ArrayList<String>();
			for(int j=0;j<alItemHdrData.size();j++){
				alTemp.add(alItemHdrData.get(j));
			}
			alTemp.set(5,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}*/
		//hmTableData.put("InsertDTLData",alNewTempDtlData);
		//hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("DTL_DATA",alNewTempDtlData);
		hmTableData.put("DTL_EXP_DATA",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}

public String getItemByGTIN(String barcode_id)throws Exception{//Addign start for MOHE-CRF-0167
    
	 HashMap itemDetails =new HashMap();
	 LinkedList batchData=new LinkedList();	 
	 HashMap barcodeData = getBarcodeData();
	 String gtin_item="";
	 String temp_expiry_date ="";
	 String temp_batch_id ="";
	 boolean rec_found = false;
	 HashMap BarcodeDetails = new HashMap();

    
	   try{
    
       String gtin = null;
       String batchNumber = null;
       String expiryDate = null;
		String srlNo      =null;

		BarcodeDetails =getBarcodedetails(barcode_id);
		gtin =(String)BarcodeDetails.get("GTIN");
		expiryDate =(String)BarcodeDetails.get("EXPIRY_DATE");
		batchNumber =(String)BarcodeDetails.get("BATCH_ID");
		srlNo =(String)BarcodeDetails.get("SRLNO");

       
		SimpleDateFormat inputFormat = new SimpleDateFormat("yymmdd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date inputDate = inputFormat.parse(expiryDate); 

		String temp_exp_date = outputFormat.format(inputDate);

           System.out.println("new GTIN: " + gtin);
           System.out.println("new Expiry Date: " + expiryDate+"temp_exp_date==="+temp_exp_date);
           System.out.println("new Batch ID: " + batchNumber);

           System.out.println("new GTIN get2DBarcodeItem: " + gtin);
           
		
			ArrayList alParameters	=	new ArrayList(4);
			
			alParameters.add(checkForNull(gtin));
			
            gtin_item =	checkForNull((String)fetchRecord("SELECT B.ITEM_CODE FROM AM_TRADE_NAME A, MM_TRADE_NAME_FOR_ITEM B WHERE MANUFACTURER_ID = ? AND A.TRADE_ID = B.TRADE_ID",alParameters).get("ITEM_CODE"));

		if(barcodeData.containsKey(gtin_item)){
				   batchData = (LinkedList)barcodeData.get(gtin_item);
				   for(int i=0;i<batchData.size();i+=2){
				      temp_expiry_date = (String)batchData.get(i+1);
					  temp_batch_id    = (String)batchData.get(i);
					  if(batchNumber.equals(temp_batch_id) && temp_exp_date.equals(temp_expiry_date)){
						  rec_found =true;
						  break;
					  }
				   }

		}else {
				  batchData  =new LinkedList();
		}
		if(!rec_found){
		   batchData.add(batchNumber);
		   batchData.add(temp_exp_date);
		   itemDetails.put(gtin_item,batchData);
		   setBarcodeData(itemDetails);
		}
	   }
		catch (Exception exception) {
			System.out.println("Exception thrown from get2DBarcodeItem = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		 }

		 return gtin_item;
}//Adding end for MOHE-CRF-0167

}
