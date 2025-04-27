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
19/04/2016				4708					B.Badmavathi									  		GRN Validation removed for UOM for KAUH					
22/4/2021				TFS:14012						Shazana				22/4/2021	   	Manickam			MO-CRF-20165 
2/7/2021				15757					Shazana														Common-ICN-0028
9/2/2022				TFS28606				Shazana												MO-CRF-20178 
23/04/2022		23925				Ramesh Goli			23/04/2022		RAMESH G    		MO-CRF-20171 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eST;

//import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import eST.GoodsReceivedNote.*;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.*;

import javax.servlet.* ;
import javax.servlet.http.*;
import java.util.regex.Pattern;//Added for MMS-DM-CRF-0174.5
import java.util.regex.Matcher;//Added for MMS-DM-CRF-0174.5
import java.text.SimpleDateFormat; 

public class GoodsReceivedNoteBean extends StHeaderBean implements Serializable{

	private String entry_completed_yn="";
	private String currency_code="";
	private String supp_code="";
	private String po_no="";
	private String finalized_yn="";  
	private String remarks; 
	private String records_to_delete="";
	private String receipt_date="";
	private ArrayList PDocNo ;
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String stReportid = null;
	//public String sessionjdbc = "";
	public String reportserver = "";
	public String report_connect_string = "";
	private HashMap		hmExpRecords=new HashMap();
	private ArrayList	alDtlRecords=new ArrayList();
	private HashMap		hmMm_parameter=new HashMap();
	private int doc_srl_no	=	0;
	private double	tmpConv		=	1;
	private String PO_doc_type_code="";
	private int conversion_rate	= 1;

	private ArrayList	alPoRecords;
	private HashMap PoItemDetails;
	private String PONextDelDate="";

	private String do_no="";//bru crf 113
	private String invoice_no="";
	private String invoice_received_by="";
	private String GRN_Mode="";
	private HashMap DoExpRecords;
	private String manufacturerId="";//added for MO-CRF-20165 START
	private String grnRemarks = ""; 
	private String itemRemarks = "";
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
	
   public String getItemRemarks() {
		return itemRemarks;
	}
	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}
public String getGrnRemarks() { 
		return grnRemarks;
	}
	public void setGrnRemarks(String grnRemarks) {
		this.grnRemarks = grnRemarks;
	}
public String getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}//END 

	// private String language;
/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; d
		this.response=response	;


	}*/
	private boolean site_spec_yn = false;
   	public boolean isSite_spec_yn() {
		return site_spec_yn;
	}
	public void setSite_spec_yn(boolean site_spec_yn) {
		this.site_spec_yn = site_spec_yn;
	}
	public void setRemarks(String remarks) {
		 this.remarks= checkForNull(remarks);
	}

	public String getRemarks( ) {
		 return remarks;
	}
	public void setPO_doc_type_code(String PO_doc_type_code) {
		this.PO_doc_type_code = PO_doc_type_code;
	}
	public String getPO_doc_type_code() {
		return this.PO_doc_type_code;
	}
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

	public void setDo_no(String do_no) {//bru crf 113
		 this.do_no= checkForNull(do_no);
	}

	public String getDo_no( ) {
		 return do_no;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn= finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}

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

	public void setConversion_rate(int conversion_rate) {
		 this.conversion_rate = conversion_rate;
	}

	public int getConversion_rate( ) {
		 return conversion_rate;
	}

	public void setSupp_code(String supp_code) {
		 this.supp_code = checkForNull(supp_code);
	}

	public String getSupp_code( ) {
		 return supp_code;
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

/*public void setJDBC(String sessionjdbc) {
		 this.sessionjdbc= sessionjdbc;

	}

	public String getJDBC( ) {
		 return sessionjdbc;
	}
	*/
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


	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_received_by(String invoice_received_by) {
		this.invoice_received_by = invoice_received_by;
	}
	public String getInvoice_received_by() {
		return invoice_received_by;
	}
	public void setGRN_Mode(String GRN_Mode) {
		this.GRN_Mode = GRN_Mode;
	}
	public String getGRN_Mode() {
		return GRN_Mode;
	}
	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167
	


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
		return (HashMap)alDtlRecords.get(index);
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}

	public String getDoc_type_desc(String doc_type_code) {
		String doc_type_desc = "";
		ArrayList arr_language=new ArrayList();
			arr_language.add(doc_type_code);
			arr_language.add(getLanguageId());
		try {
			doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return doc_type_desc;
    }
	
	public  String getLastPurCost  (String item_code, String store_code){
		
		ArrayList LPCParameters	=	new ArrayList(2);
		LPCParameters.add(checkForNull(store_code));
		LPCParameters.add(checkForNull(item_code));
		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_LAST_COST_SELECT_FOR_GRN"),LPCParameters);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("LAST_GRN_COST");
	} 
//added on 2/8/2006 for alert msg for suspended Batches
	public  String getbatchstatus  (String exp_rec_date, String batch_id, String item_code){
//==========
		String Bstatus ="";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_GRN_ITEM_BATCH_STATUS"));
            pstmt.setString(1, checkForNull(exp_rec_date));
            pstmt.setString(2, checkForNull(batch_id));
            pstmt.setString(3, checkForNull(item_code));
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Bstatus=(String)resultSet.getString("BATCH_STATUS");
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

	return Bstatus;
	}
	
	public String getStore_desc(String store_code) {
		String store_desc="";
		ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
		try {
			store_desc=fetchRecord(getStRepositoryValue("SQL_ST_OPENING_STOCK_STORE"), arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}

		return store_desc;

    }

	public String getBinLocation_desc(String bin_code) {
		String bin_desc="";
		ArrayList arr_language=new ArrayList();
			arr_language.add(bin_code);
			arr_language.add(getLanguageId());
		try {
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
/*		else{
			alExpRecords	=	hmExpRecords.get(""+index);
		}*/
		//for (int i=0;i<10; i++) {
		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("total_records")); i++) {
			if (htExpRecords.get("grn_item_qty_"+i).toString().equals(""))
				continue;
               
			HashMap hmExpRecord	=	new HashMap();
			hmExpRecord.put("store_code",		htExpRecords.get("store_code"));
			hmExpRecord.put("item_code",		htExpRecords.get("item_code"));
			hmExpRecord.put("batch_id",			htExpRecords.get("batch_id_"+i));
			hmExpRecord.put("bin_location_code",htExpRecords.get("bin_location_code_"+i));
			hmExpRecord.put("expiry_date_or_receipt_date",com.ehis.util.DateUtils.convertDate((String)htExpRecords.get("expiry_date_or_receipt_date_"+i),"DMY",getLanguageId(),"en"));
			hmExpRecord.put("trade_id",			htExpRecords.get("trade_id_"+i));
			hmExpRecord.put("grn_item_qty",		htExpRecords.get("grn_item_qty_"+i));
			hmExpRecord.put("expiry_yn",		htExpRecords.get("expiry_yn"+i));
			hmExpRecord.put("sale_price",		checkForNull((String)htExpRecords.get("sale_price_"+i)));
			hmExpRecord.put("gen_uom_desc",		checkForNull((String)htExpRecords.get("gen_uom_desc")));
			hmExpRecord.put("barcode_id",		checkForNull((String)htExpRecords.get("barcode_id_"+i)));
			hmExpRecord.put("by_do",			checkForNull((String)htExpRecords.get("by_do_"+i)));
			hmExpRecord.put("manufactured_date",			checkForNull((String)htExpRecords.get("manufactured_date_"+i)));//added for MO-CRF-20165 
			hmExpRecord.put("fileRef", checkForNull((String)htExpRecords.get("fileRef_"+i))); //23925
			
			alExpRecords.add(hmExpRecord);
		}
		setExpRecords(index, alExpRecords);
			
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
			String optionValues = null;
			java.util.ArrayList alOptionValues = new java.util.ArrayList();
			ArrayList arr_language=new ArrayList();
			arr_language.add(item_code);
			arr_language.add(getLanguageId());
			alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_TRADE_DETAILS"), arr_language);
			alOptionValues.remove(0);
			optionValues = getListOptionTag(alOptionValues,trade_id );
			alOptionValues = null;
			return optionValues;
	//	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),item_code),trade_id);
	}
	
	public String getTrade_id_List(String item_code) {
			String optionValues = null;
			java.util.ArrayList alOptionValues = new java.util.ArrayList();
			alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_TRADE_DETAILS"), item_code);
			alOptionValues.remove(0);
			optionValues = getListOptionTag(alOptionValues );
			alOptionValues = null;
			return optionValues;

	//	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),item_code));
	}

	public String getTrade_id_Default_List(String trade_id) {
		return getListOptionTag(getDefltTrdId(),trade_id);
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
     public ArrayList getDefltTradeId() {
        
        ArrayList alDfltTradeId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
			
	//*		String stDfltTradeId="";
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_DEFAULT_TRADE_ID"));
 		    resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				 String stTempTradeId=resultSet.getString(1);
				 alDfltTradeId.add(stTempTradeId);
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
          return alDfltTradeId;
	  }
	public String getBin_location_code_List(String store_code,String bin_location_code, String item_code) throws Exception{
		ArrayList mmParameters	=	new ArrayList(2);
		mmParameters.add(checkForNull(store_code));
		mmParameters.add(checkForNull(item_code));
//		mmParameters.add(getLanguageIdId());
		
		if( checkForNull(bin_location_code).equals("")  )
		{
			bin_location_code =checkForNull((String)fetchRecord(getStRepositoryValue("SQL_DEFAULT_MM_BIN_LOCATION_SELECT_LIST"),mmParameters).get("BIN_LOCATION_CODE"));
		}
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),new String[]{store_code,item_code,getLanguageId()}),bin_location_code);
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
		alDtlRecords=null;
		doc_srl_no	=	0;
		entry_completed_yn=null;  
		currency_code=null;
		supp_code=null;
		po_no=null; 
		do_no=null; 
		finalized_yn=null;     
		receipt_date=null;
		hmMm_parameter=null;
		records_to_delete=null;
		PO_doc_type_code="";

		alPoRecords = null;
		PoItemDetails = null;
		conversion_rate = 1;
		PONextDelDate="";
		DoExpRecords = null;
		invoice_no = null;
		invoice_received_by = null;
		GRN_Mode=null;
		manufacturerId = null;//added for MO-CRF-20165  
		grnRemarks = null; 
		itemRemarks =null;//end 
		barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
	}

	public void  initialize(){
		super.initialize();
		hmExpRecords=new HashMap();  
		alDtlRecords=new ArrayList();
		doc_srl_no	=	0;
		entry_completed_yn="";  
		currency_code="";
		supp_code="";
		po_no=""; 
		do_no=""; 
		finalized_yn="";   
		remarks="";
		PO_doc_type_code="";
		conversion_rate = 1;
		invoice_no= "";
		invoice_received_by="";
		GRN_Mode="";
		manufacturerId = ""; //added for MO-CRF-20165 start
		grnRemarks = "";
		itemRemarks = "";  //end  

		alPoRecords = new ArrayList();
		PONextDelDate="";
		PoItemDetails = new HashMap();
		DoExpRecords= new HashMap();
		barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
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

	public void doinitialize(){
		doc_srl_no	=	0;
		alDtlRecords=new ArrayList();
		alPoRecords =new ArrayList();
		DoExpRecords= new HashMap();
	}

	public void setAll(Hashtable hashtable) {
		System.out.println("hashtable : "+hashtable);
		setEntry_completed_yn((String)hashtable.get("entry_completed_yn"));  
//		sal_trn_type=(String)hashtable.get("sal_trn_type");  
		setReceipt_date((String)hashtable.get("receipt_date"));  
		setCurrency_code((String)hashtable.get("currency_code"));  
		supp_code=(String)hashtable.get("supp_code");  
		po_no =(String)hashtable.get("po_no");  
		do_no =(String)hashtable.get("do_no");  
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		records_to_delete=(String)hashtable.get("records_to_delete");  
		setConversion_rate(Integer.parseInt(checkForNull((String)hashtable.get("exchangerate"),"1"))); 
		setInvoice_no((String)hashtable.get("invoice_no"));
		setInvoice_received_by((String)hashtable.get("invoice_received_by"));
		setGRN_Mode((String)hashtable.get("grn_mode"));
    }

	public String getCurrency_code_List(){
/*	ArrayList arr_language = new ArrayList();
	arr_language.add(getLanguageId()); */
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_SY_FOREIGN_CURRENCY_SELECT_LIST"),getLanguageId()),getCurrency_code());
	}

	public String getPur_uom_code_List(String uom_code,String item_code){
		//Added by suresh.r on 04-12-2014 against ML-BRU-SCF-1457 beg
		boolean site = isSite_spec_yn();
		String gen_uom_code ="";
		try{
			gen_uom_code = checkForNull((String)fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,checkForNull(item_code)).get("GEN_UOM_CODE"));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		if(site){//Added by B.Badmavathi against KAUH-SCF-0249 STARTS
			String chkParameters[] = {uom_code,getLanguageId(),uom_code,getLanguageId(),uom_code,getLanguageId(),item_code};
			return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters),uom_code);
		}else{//Added by B.Badmavathi against KAUH-SCF-0249 ENDS
		String chkParameters[] = {gen_uom_code,getLanguageId(),gen_uom_code,getLanguageId(),gen_uom_code,getLanguageId(),item_code};
		//Added by suresh.r on 04-12-2014 against ML-BRU-SCF-1457 end
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters),uom_code);
		}

	}
	public ArrayList getPur_uom_code_Lists(String parameters,String item_code) throws Exception{
		
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
			return result;
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
			
/*	ArrayList arr_language = new ArrayList();
	arr_language.add(getLanguageId());
	arr_language.add(getSupp_code());	*/			
return  getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),getLanguageId()),getSupp_code());
}
	

	public void loadData() throws Exception{
		alDtlRecords = new ArrayList();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_GRN_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		doc_srl_no		=	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_GRN_HDR_SELECT_SINGLE"), alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setStore_code((String)hmRecord.get ("STORE_CODE"));  
		setItem_class_code((String)hmRecord.get ("ITEM_CLASS_CODE"));  
		setEntry_completed_yn((String)hmRecord.get ("ENTRY_COMPLETED_YN"));  
		setCurrency_code((String)hmRecord.get("CURRENCY_CODE"));
		setSupp_code((String)hmRecord.get("SUPP_CODE"));
		setReceipt_date((String)hmRecord.get("RECEIPT_DATE"));
		setPo_no((String)hmRecord.get("PO_NO"));		
		setRemarks((String)hmRecord.get("REMARKS_CODE"));
		setConversion_rate(Integer.parseInt(checkForNull((String)hmRecord.get("CONVERSION_RATE"),"1"))); 
		setDo_no((String)hmRecord.get("DO_NO"));
		setInvoice_no(checkForNull((String)hmRecord.get("INVOICE_NO")));
		setInvoice_received_by(checkForNull((String)hmRecord.get("INVOICE_RECD_BY")));
		setGRN_Mode(checkForNull((String)hmRecord.get("GRN_MODE")));
		setGrnRemarks(checkForNull((String)hmRecord.get("REMARKS_DESC"))); //added for MO-CRF-20165 


System.out.println("hmRecord="+hmRecord);



		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getPo_no());
		alParameters.add(getStore_code());
		//	HashMap doc_type_c	=	fetchRecord("select DOC_TYPE_CODE from XI_TRN_GRN where FACILITY_ID=? and DOC_NO=? and STORE_CODE=? ", alParameters);
	
		String interface_po_yn = checkForNull((String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"), getEntity_param())).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
		if(interface_po_yn.equals("Y")){
			HashMap doc_type_c	=	new HashMap();
			try{
			doc_type_c	=	fetchRecord(getStRepositoryValue("SQL_ST_XI_TRN_GRN_SELECT"), alParameters);
			}catch(Exception e){
				e.printStackTrace();
			}
			setPO_doc_type_code(checkForNull((String)doc_type_c.get("DOC_TYPE_CODE")));
		}
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
		//ArrayList alRecords	=	fetchRecords("SELECT DTL.DOC_SRL_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,DTL.ITEM_QTY_NORMAL, DTL.ITEM_QTY_BONUS, DTL.ITEM_QTY_SAMPLE,DTL.ITEM_COST_VALUE, DTL.STOCK_ITEM_YN, DTL.LABEL_REQD_YN,DTL.GRN_UNIT_COST_IN_PUR_UOM, DTL.PUR_UOM_CODE, DTL.PUR_UOM_CONV,DTL.REPLACE_ON_EXPIRY_YN, DTL.GRN_UNIT_COST_IN_STK_UOM,AM.SHORT_DESC GEN_UOM_DESC, AM.UOM_CODE, STITEM.EXPIRY_YN,DTL.NO_OF_LABELS,AM1.SHORT_DESC UOM_DESC,DTL.PO_COST,DTL.PO_DISCOUNT,DTL.PO_TAX,STITEM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN FROM ST_GRN_HDR HDR,ST_GRN_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,AM_UOM_LANG_VW AM1,ST_ITEM_STORE ST WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND AM1.UOM_CODE = ST.DEF_ISSUE_UOM AND ST.ITEM_CODE = DTL.ITEM_CODE AND ST.STORE_CODE = HDR.STORE_CODE AND DTL.FACILITY_ID = HDR.FACILITY_ID AND DTL.DOC_NO = HDR.DOC_NO AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE", alParameters);

		ArrayList alRecords	=	fetchRecords("SELECT DTL.DOC_SRL_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,DTL.ITEM_QTY_NORMAL, DTL.ITEM_QTY_BONUS, DTL.ITEM_QTY_SAMPLE,DTL.ITEM_COST_VALUE, DTL.STOCK_ITEM_YN, DTL.LABEL_REQD_YN,DTL.GRN_UNIT_COST_IN_PUR_UOM, DTL.PUR_UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE =DTL.PUR_UOM_CODE AND LANGUAGE_ID = MMITEM.LANGUAGE_ID)PUR_UOM_DESC, DTL.PUR_UOM_CONV,DTL.REPLACE_ON_EXPIRY_YN, DTL.GRN_UNIT_COST_IN_STK_UOM,AM.SHORT_DESC GEN_UOM_DESC, AM.UOM_CODE, STITEM.EXPIRY_YN,DTL.NO_OF_LABELS,AM1.SHORT_DESC UOM_DESC,DTL.PO_COST,DTL.PO_DISCOUNT,DTL.PO_TAX,STITEM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, dtl.MANUFACTURER_ID , dtl.REMARKS_DESC, dtl.CATALOG_CODE, dtl.MANUFAC_REMARKS_DESC   FROM ST_GRN_HDR HDR,ST_GRN_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,AM_UOM_LANG_VW AM1,ST_ITEM_STORE ST WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND AM1.UOM_CODE = ST.DEF_ISSUE_UOM AND ST.ITEM_CODE = DTL.ITEM_CODE AND ST.STORE_CODE = HDR.STORE_CODE AND DTL.FACILITY_ID = HDR.FACILITY_ID AND DTL.DOC_NO = HDR.DOC_NO AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE", alParameters);//modified for MO-CRF-20165,MANUFAC_REMARKS_DESC added for MO-CRF-20178 
		for (int i=0; i<alRecords.size(); i++) { 
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("replace_on_expiry_yn",hmRecord.get("REPLACE_ON_EXPIRY_YN"));
			hmTemp.put("label_reqd_yn",hmRecord.get("LABEL_REQD_YN"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
			hmTemp.put("item_qty_bonus",checkForNull((String)hmRecord.get("ITEM_QTY_BONUS")));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("item_qty_normal",checkForNull((String)hmRecord.get("ITEM_QTY_NORMAL")));
			hmTemp.put("item_qty_sample",checkForNull((String)hmRecord.get("ITEM_QTY_SAMPLE")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("pur_uom_code",hmRecord.get("PUR_UOM_CODE"));
			hmTemp.put("pur_uom_conv",checkForNull((String)hmRecord.get("PUR_UOM_CONV"),"1"));
			hmTemp.put("grn_unit_cost_in_pur_uom",hmRecord.get("GRN_UNIT_COST_IN_PUR_UOM"));
			hmTemp.put("no_of_labels",checkForNull((String)hmRecord.get("NO_OF_LABELS"),"0"));
			hmTemp.put("gen_uom_desc",checkForNull((String)hmRecord.get("GEN_UOM_DESC")));
			hmTemp.put("po_cost",checkForNull((String)hmRecord.get("PO_COST"),"0"));
			hmTemp.put("po_discount",checkForNull((String)hmRecord.get("PO_DISCOUNT")));
			hmTemp.put("po_tax",checkForNull((String)hmRecord.get("PO_TAX")));
			hmTemp.put("flag",checkForNull((String)hmRecord.get("FLAG"),"Y"));
			hmTemp.put("allow_deci_yn",checkForNull((String)hmRecord.get("ALLOW_DECIMALS_YN"),"N"));
			hmTemp.put("no_deci", checkForNull((""+getNoOfDecimals()),"0"));
			hmTemp.put("pur_uom_conv_id",checkForNull((String)hmRecord.get("PUR_UOM_CONV"),"1"));
			hmTemp.put("manufacturer_id",hmRecord.get("MANUFACTURER_ID")); //added for MO-CRF-20165 START
			hmTemp.put("remarks_desc",hmRecord.get("REMARKS_DESC")); 
			hmTemp.put("catalog_code",checkForNull((String)hmRecord.get("CATALOG_CODE"))); //END 
			hmTemp.put("manufac_remarks",checkForNull((String)hmRecord.get("MANUFAC_REMARKS_DESC")));//MO-CRF-20178 
			
			

			int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE")}).get("COUNT"));
			int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE"),(String)hmRecord.get("ITEM_CODE")}).get("COUNT"));
			if(item_uom_count >0){
			HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty)  conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE"),(String)hmRecord.get("ITEM_CODE")});

			//String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)hmRecord.get("UOM_CODE")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)hmRecord.get("PUR_UOM_CODE");
			String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)hmRecord.get("UOM_DESC")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)hmRecord.get("PUR_UOM_DESC");

			hmTemp.put("pur_uom_conv_id",conver);
			hmTemp.put("pur_uom_conv",checkForNull((String)stEqvl_value1.get("CONV_FACTOR"),"1"));

			}else if(am_count >0){
			String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE")}).get("EQVL_VALUE");
			//String conver=stEqvl_value+" "+(String)hmRecord.get("UOM_CODE")+" = 1 "+(String)hmRecord.get("PUR_UOM_CODE");
			String conver=stEqvl_value+" "+(String)hmRecord.get("UOM_DESC")+" = 1 "+(String)hmRecord.get("PUR_UOM_DESC");
			hmTemp.put("pur_uom_conv_id",conver);
		

			}else{
			//String conver="1 "+(String)hmRecord.get("UOM_CODE")+" = 1 "+(String)hmRecord.get("PUR_UOM_CODE");
			String conver="1 "+(String)hmRecord.get("UOM_DESC")+" = 1 "+(String)hmRecord.get("PUR_UOM_DESC");
			hmTemp.put("pur_uom_conv_id",conver);
			}





/*			long effective_qty=0;
			if (!checkForNull((String)hmRecord.get("ITEM_QTY_NORMAL")).equals("")) {
				effective_qty+=Long.parseLong((String)hmRecord.get("ITEM_QTY_NORMAL"));
			}
			if (!checkForNull((String)hmRecord.get("ITEM_QTY_BONUS")).equals("")) {
				effective_qty+=Long.parseLong((String)hmRecord.get("ITEM_QTY_BONUS"));
			}*/
			alDtlRecords.add(hmTemp);
		}

		//alParameters.add("%");
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
		HashMap hmTempRecord;
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			alParameters.set(3,(String)hmRecord.get("doc_srl_no"));
			alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_GRN_DTL_EXP_SELECT_MULTIPLE"), alParameters);
			for (int j=0; j<alRecords.size(); j++) {
				HashMap hmTemp	=	new HashMap();	
				hmTempRecord=	(HashMap)alRecords.get(j);
				hmTemp.put("grn_item_qty", hmTempRecord.get("GRN_ITEM_QTY"));             
				hmTemp.put("trade_id", hmTempRecord.get("TRADE_ID"));                 
				hmTemp.put("expiry_date_or_receipt_date", hmTempRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				hmTemp.put("item_code", hmTempRecord.get("ITEM_CODE"));                
				hmTemp.put("store_code", hmTempRecord.get("STORE_CODE"));               
				hmTemp.put("batch_id", hmTempRecord.get("BATCH_ID"));                 
				hmTemp.put("bin_location_code", hmTempRecord.get("BIN_LOCATION_CODE"));        
				hmTemp.put("sale_price", checkForNull((String)hmTempRecord.get("SALE_PRICE")));        
				hmTemp.put("gen_uom_desc", (String)hmRecord.get("gen_uom_desc"));    
				hmTemp.put("barcode_id",  checkForNull((String)hmTempRecord.get("BARCODE_ID")));  
				hmTemp.put("manufactured_date",  checkForNull((String)hmTempRecord.get("MANUFACTURED_DATE")));  //added for MO-CRF-20165 
				hmTemp.put("fileRef",  checkForNull((String)hmTempRecord.get("IMAGE_REF")));  //23925
				if(getGRN_Mode().equals("D"))
				hmTemp.put("by_do",		"Y");

				alRecords.set(j, hmTemp);
			}
			hmExpRecords.put(""+i,alRecords);
			System.out.println("modify"+hmExpRecords);
		}

	}



	public HashMap insert(){
 		//HashMap hmResult=new HashMap();;
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		//ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		//ArrayList alCommonData	=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hmHeader		=	new HashMap();
		ArrayList allanguageData	=	new ArrayList(); 
		hmCommonData.put("login_by_id",getLoginById());
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo());
		hmCommonData.put("login_facility_id",getLoginFacilityId());

		hmHeader.put("facility_id",getLoginFacilityId());
		hmHeader.put("doc_type_code", getDoc_type_code());
		hmHeader.put("doc_no", getDoc_no());
		hmHeader.put("doc_date", getDoc_date());
		hmHeader.put("doc_ref", getDoc_ref());
		hmHeader.put("store_code", getStore_code());
		hmHeader.put("item_class_code", getItem_class_code());
		hmHeader.put("finalized_yn", getFinalized_yn());
		hmHeader.put("gl_interfaced_yn", "N");//gl_interface
		hmHeader.put("po_no", getPo_no());
		hmHeader.put("trn_type", "GRN");
		hmHeader.put("supp_code", getSupp_code());
		hmHeader.put("currency_code", getCurrency_code());
		hmHeader.put("entry_completed_yn", getEntry_completed_yn());
		hmHeader.put("receipt_date", com.ehis.util.DateUtils.convertDate(getReceipt_date(),"DMY",getLanguageId(),"en"));
        hmHeader.put("remarks_code", checkForNull(getRemarks(),""));
		hmHeader.put("PO_doc_type_code", getPO_doc_type_code());
		hmHeader.put("conversion_rate", getConversion_rate());
		hmHeader.put("do_no", getDo_no());
		hmHeader.put("invoice_no", getInvoice_no());
		hmHeader.put("invoice_recd_by", getInvoice_received_by());
		hmHeader.put("grn_mode", getGRN_Mode());
		hmHeader.put("grn_remarks_desc", getGrnRemarks());//added for MO-CRF-20165  

		//	getReceipt_date());
		allanguageData.add(getLanguageId());
		try {
//alDtlRecords
			
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			boolean isDocNoAutoGenYN = isDocNoAutoGenYN(getDoc_type_code());
			boolean isPOApplicable	 = isPOApplicable();

			System.out.println("isPOApplicable==insert==>"+isPOApplicable);


			String nextToken	;
			HashMap hmDtlRecord	;
			ArrayList sourceArrayList;
			HashMap hmExpRecord;

			String sale_price_appl_yn	=	((String)fetchRecord("SELECT SALE_PRICE_APPL_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("SALE_PRICE_APPL_YN"));
	 		HashMap hmResult=new HashMap();


		for (int i=0;i<alDtlRecords.size();i++) {
				nextToken	= stRecordsToDelete.nextToken();
				hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));

							if(sale_price_appl_yn.equals("Y") && ((String)hmExpRecord.get("sale_price")).equals("")){//Handle for CRF-113 By ganga 30072
								hmResult.put("result",false);
								hmResult.put("msgid","SALE_PRICE_NOT_BLANK");
								hmResult.put("message",getSTMessage(getLanguageId(),"SALE_PRICE_NOT_BLANK","ST"));
								return hmResult;
							}


							alExpData.add(hmExpRecord);
						}
				}
				//hmDtlRecord.put("to_conv_fact",""+getTempConvFact());
				alDtlData.add(hmDtlRecord);				
			}
			
			

			ArrayList NextDelDateData = new ArrayList();
			
			if(isPOApplicable){
					int po_count=0;
				if(!(getPo_no().equals(""))){

					po_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM PO_ORDER_HDR WHERE PO_NO = ? ",getPo_no())).get("COUNT"));
					if(po_count>0){
					if(!(getPONextDelDate().equals(""))){
						NextDelDateData.add(com.ehis.util.DateUtils.convertDate(getPONextDelDate(),"DMY",getLanguageId(),"en"));					
					}else{
						NextDelDateData.add("");
					}	
						NextDelDateData.add(getPo_no());	
												
					hmTableData.put("NextDelDateData",	NextDelDateData);	
					}
				}
			}

			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		hmHeader);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	hmCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
			hmTableData.put("isPOApplicable", new Boolean(isPOApplicable));
			hmTableData.put("PO_DETAILS",	alPoRecords);
			hmTableData.put("DO_DETAILS",	DoExpRecords);

			hmSQLMap.put("SQL_ST_ITEM_VALUE_SELECT", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SQL_ST_ITEM_MASTER_UPDATE", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
//			hmSQLMap.put("SQL_ST_ITEM_MASTER_PUR_COST_INSERT", getStRepositoryValue("SQL_ST_ITEM_MASTER_PUR_COST_INSERT"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_QTY_UPDATE", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
			hmSQLMap.put("SQL_ST_GRN_HDR_INSERT", getStRepositoryValue("SQL_ST_GRN_HDR_INSERT"));
			hmSQLMap.put("SQL_ST_GRN_DTL_INSERT", getStRepositoryValue("SQL_ST_GRN_DTL_INSERT"));
			hmSQLMap.put("SQL_ST_GRN_DTL_EXP_INSERT", getStRepositoryValue("SQL_ST_GRN_DTL_EXP_INSERT"));
			hmSQLMap.put("SQL_ST_BATCH_CONTROL_INSERT", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("SQL_ST_CHECK_ITEM_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_INSERT", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("SQL_ST_GET_ITEM_BATCH_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_DELETE", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_UPDATE", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_BATCH_FOR_GRN"));
			hmSQLMap.put("SQL_ST_GET_MONTH_AND_YEAR", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("SQL_ST_GET_ITEM_STORE_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_GRN"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_GRN"));
			hmSQLMap.put("SQL_ST_CHECK_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN"));
			hmSQLMap.put("SQL_MM_ITEM_UPDATE_FOR_GRN", getStRepositoryValue("SQL_MM_ITEM_UPDATE_FOR_GRN"));
			hmSQLMap.put("SQL_MM_ITEM_UPDATE_FOR_GRN_LAST_PUR_COST", getStRepositoryValue("SQL_MM_ITEM_UPDATE_FOR_GRN_LAST_PUR_COST"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_UPDATE_FOR_GRN_LAST_PUR_COST", getStRepositoryValue("SQL_ST_ITEM_STORE_UPDATE_FOR_GRN_LAST_PUR_COST"));
			//hmSQLMap.put("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY", "update po_request_dtl set GRN_QTY=?, GRN_UOM=?,GRN_GEN_UOM_QTY=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where FACILITY_ID =? and DOC_NO=? and DOC_SRL_NO=? and DOC_TYPE_CODE=?");
			hmSQLMap.put("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY", getStRepositoryValue("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_REQUEST_DETAIL_GRN_QTY", getStRepositoryValue("SQL_UPDATE_PO_REQUEST_DETAIL_GRN_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_FCY_DTL_GRN_QTY", getStRepositoryValue("SQL_UPDATE_PO_ORDER_FCY_DTL_GRN_QTY"));
			hmSQLMap.put("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS"));
			hmSQLMap.put("SQL_COUNT_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_COUNT_PO_ORDER_UNF_GRN_RECORDS"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_HDR_FOR_NEXT_DEL_DATE", getStRepositoryValue("SQL_UPDATE_PO_ORDER_HDR_FOR_NEXT_DEL_DATE"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_HDR_STATUS", getStRepositoryValue("SQL_UPDATE_PO_ORDER_HDR_STATUS"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_FCY_DTL_STATUS", getStRepositoryValue("SQL_UPDATE_PO_ORDER_FCY_DTL_STATUS"));
		   //Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
			hmSQLMap.put("SQL_MM_ITEM_UPDATE_PUR_UOM", getStRepositoryValue("SQL_MM_ITEM_UPDATE_PUR_UOM"));
			
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_QTY", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_HDR_STATUS", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_HDR_STATUS"));
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_DTL_STATUS", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_DTL_STATUS"));
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_BLOCK_QTY", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_BLOCK_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_UPDATE_PO_ORDER_UNF_GRN_RECORDS"));
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		if((getItemClassBased("GRN").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"GRN");
		}
		System.out.println("hmTableData--828"+hmTableData);
		return goodsReceivedNoteMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap delete(){
 		//HashMap hmResult		=	new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		//ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hmHeader		=	new HashMap();
		
		try{
		boolean isPOApplicable	 = isPOApplicable();

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		hmHeader.put("facility_id",getLoginFacilityId()			);
		hmHeader.put("doc_type_code",getDoc_type_code()		);
		hmHeader.put("doc_no",getDoc_no()	);
		//Added for ML-BRU-SCF-1924 start
		ArrayList alParameters1 = new ArrayList();

		alParameters1.add(getLoginFacilityId());
		alParameters1.add(getDoc_type_code());
		alParameters1.add(getDoc_no());
		int count = Integer.parseInt((String)(((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_PO_COUNT"),alParameters1)).get("CHK")));
		//Added for ML-BRU-SCF-1924 end
		if(isPOApplicable){		
			ArrayList alParameters = new ArrayList();
			ArrayList do_details = new ArrayList();

			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_GRN_HDR_DTL_SELECT_FOR_DO_BATCH_UPDATE"), alParameters);
			
			for(int i=0;i<alRecords.size();i++){
				HashMap hmtemp = (HashMap)alRecords.get(i);
				ArrayList altemp = new ArrayList();
					
					altemp.add(getLoginById());
					altemp.add(getLoginAtWsNo());
					altemp.add(getLoginFacilityId());
					altemp.add((String)hmtemp.get("DO_NO"));
					altemp.add((String)hmtemp.get("ITEM_CODE"));
					altemp.add(getLoginFacilityId());
					altemp.add(getStore_code());
				
				do_details.add(altemp);
				
			}
			if(do_details.size()>0)
			hmTableData.put("DO_DATA",	do_details);		
		}
	

		hmTableData.put("properties",	getProperties());
		hmTableData.put("DATA",			hmHeader);
		hmTableData.put("COMMON_DATA",	hmCommonData);
		hmTableData.put("isPOApplicable", new Boolean(isPOApplicable));
		hmTableData.put("po_no", getPo_no());//Added by suresh.r on 12-05-2015 against ML-BRU-SCF-1573
		hmTableData.put("count", count);//Added for ML-BRU-SCF-1924

		System.out.println("hmTableData"+hmTableData);

		hmSQLMap.put("SQL_ST_GRN_DTL_EXP_DELETE_ALL",getStRepositoryValue("SQL_ST_GRN_DTL_EXP_DELETE_ALL"));
		hmSQLMap.put("SQL_ST_GRN_DTL_DELETE_ALL"	,getStRepositoryValue("SQL_ST_GRN_DTL_DELETE_ALL"));
		hmSQLMap.put("SQL_ST_GRN_HDR_DELETE"		,getStRepositoryValue("SQL_ST_GRN_HDR_DELETE"));
		hmSQLMap.put("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS2"		,getStRepositoryValue("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS2"));
		hmSQLMap.put("SQL_UPDATE_PO_ORDER_UNF_GRN_DO_QTY_IN_DO_BAT1"	,getStRepositoryValue("SQL_UPDATE_PO_ORDER_UNF_GRN_DO_QTY_IN_DO_BAT1"));
		}
		catch (Exception e){
		e.printStackTrace();
		}
		return goodsReceivedNoteMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}

	public HashMap modify(){
 		HashMap hmResult=new HashMap();
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_GRN_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?  AND FINALIZED_YN='Y'",alParam)).get("COUNT"));
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
		HashMap hmData		=	new HashMap();
		//ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hmHeader		=	new HashMap();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList allanguageData	=	new ArrayList();
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
			hmHeader.put("item_class_code", getItem_class_code());
			hmHeader.put("finalized_yn",getFinalized_yn());
			hmHeader.put("gl_interfaced_yn","N");
			hmHeader.put("trn_type","GRN");
			hmHeader.put("supp_code",getSupp_code());
			hmHeader.put("currency_code",getCurrency_code());
			hmHeader.put("entry_completed_yn",getEntry_completed_yn());
			hmHeader.put("receipt_date",com.ehis.util.DateUtils.convertDate(getReceipt_date(),"DMY",getLanguageId(),"en"));
			hmHeader.put("remarks_code",checkForNull(getRemarks(),"")); 
			hmHeader.put("po_no",getPo_no());
			hmHeader.put("PO_doc_type_code", getPO_doc_type_code());
			hmHeader.put("conversion_rate", getConversion_rate());
			hmHeader.put("do_no", getDo_no());
			hmHeader.put("invoice_no", getInvoice_no());
			hmHeader.put("invoice_recd_by", getInvoice_received_by());
			hmHeader.put("grn_remarks_desc", getGrnRemarks());//added for MO-CRF-20165   

			allanguageData.add(getLanguageId());
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			String nextToken	;
			HashMap hmDtlRecord	;
			ArrayList sourceArrayList;
			HashMap hmExpRecord;

			String sale_price_appl_yn	=	((String)fetchRecord("SELECT SALE_PRICE_APPL_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("SALE_PRICE_APPL_YN"));

			for (int i=0;i<alDtlRecords.size();i++) {
				nextToken	= stRecordsToDelete.nextToken();
				hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));

							if(sale_price_appl_yn.equals("Y") && ((String)hmExpRecord.get("sale_price")).equals("")){
								hmResult.put("result",false);
								hmResult.put("msgid","SALE_PRICE_NOT_BLANK");
								hmResult.put("message",getSTMessage(getLanguageId(),"SALE_PRICE_NOT_BLANK","ST"));
								return hmResult;
							}

							alExpData.add(hmExpRecord);
						}
				}
				hmDtlRecord.put("to_conv_fact",""+getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code()));
				alDtlData.add(hmDtlRecord);
			}

			boolean isPOApplicable	 = isPOApplicable();

			System.out.println("isPOApplicable==modify==>"+isPOApplicable);

			ArrayList NextDelDateData = new ArrayList();

			if(isPOApplicable){
						int po_count = 0 ;
				if(!(getPo_no().equals(""))){
						po_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM PO_ORDER_HDR WHERE PO_NO = ? ",getPo_no())).get("COUNT"));
							if(po_count>0){
							if(!(PONextDelDate.equals(""))){
								NextDelDateData.add(com.ehis.util.DateUtils.convertDate(getPONextDelDate(),"DMY",getLanguageId(),"en"));				
							}else{
								NextDelDateData.add(getPONextDelDate());
							}	
								NextDelDateData.add(getPo_no());
						
							hmData.put("NextDelDateData",	NextDelDateData);
							}
				}		
			}




			hmData.put("properties",	getProperties());
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("COMMON_DATA",hmCommonData);
			hmData.put("LANGUAGE_DATA",	allanguageData);
			hmData.put("isPOApplicable", new Boolean(isPOApplicable));
			hmData.put("PO_DETAILS",	alPoRecords);
			hmData.put("DO_DETAILS",	DoExpRecords);


			hmSQLMap.put("SQL_ST_ITEM_VALUE_SELECT", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("SQL_ST_ITEM_MASTER_UPDATE", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_QTY_UPDATE", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
			hmSQLMap.put("SQL_ST_GRN_HDR_INSERT", getStRepositoryValue("SQL_ST_GRN_HDR_INSERT"));
			hmSQLMap.put("SQL_ST_GRN_DTL_INSERT", getStRepositoryValue("SQL_ST_GRN_DTL_INSERT"));
			hmSQLMap.put("SQL_ST_GRN_DTL_EXP_INSERT", getStRepositoryValue("SQL_ST_GRN_DTL_EXP_INSERT"));
			hmSQLMap.put("SQL_ST_BATCH_CONTROL_INSERT", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("SQL_ST_CHECK_ITEM_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_INSERT", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("SQL_ST_GET_ITEM_BATCH_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_DELETE", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_UPDATE", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_BATCH_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_BATCH_FOR_GRN"));
			hmSQLMap.put("SQL_ST_GET_MONTH_AND_YEAR", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("SQL_ST_GET_ITEM_STORE_STOCK_POS", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_GRN"));
			hmSQLMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_GRN"));
			hmSQLMap.put("SQL_ST_CHECK_BATCH_EXISTS", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_GRN"));

			hmSQLMap.put("SQL_ST_GRN_HDR_UPDATE"	, getStRepositoryValue("SQL_ST_GRN_HDR_UPDATE"	));
			hmSQLMap.put("SQL_ST_GRN_DTL_UPDATE"	, getStRepositoryValue("SQL_ST_GRN_DTL_UPDATE"	));
			hmSQLMap.put("SQL_ST_GRN_DTL_DELETE"	, getStRepositoryValue("SQL_ST_GRN_DTL_DELETE"	));
			hmSQLMap.put("SQL_ST_GRN_DTL_EXP_DELETE", getStRepositoryValue("SQL_ST_GRN_DTL_EXP_DELETE"));
			hmSQLMap.put("SQL_MM_ITEM_UPDATE_FOR_GRN", getStRepositoryValue("SQL_MM_ITEM_UPDATE_FOR_GRN"));
			hmSQLMap.put("SQL_MM_ITEM_UPDATE_FOR_GRN_LAST_PUR_COST", getStRepositoryValue("SQL_MM_ITEM_UPDATE_FOR_GRN_LAST_PUR_COST"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_UPDATE_FOR_GRN_LAST_PUR_COST", getStRepositoryValue("SQL_ST_ITEM_STORE_UPDATE_FOR_GRN_LAST_PUR_COST"));
			//	hmSQLMap.put("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY", "update po_request_dtl set GRN_QTY=?, GRN_UOM=?,GRN_GEN_UOM_QTY=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where FACILITY_ID =? and DOC_NO=? and DOC_SRL_NO=? and DOC_TYPE_CODE=?");
			hmSQLMap.put("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY", getStRepositoryValue("SQL_ST_PO_REQUEST_DTL_UPDATE_FOR_GRN_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_REQUEST_DETAIL_GRN_QTY", getStRepositoryValue("SQL_UPDATE_PO_REQUEST_DETAIL_GRN_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_FCY_DTL_GRN_QTY", getStRepositoryValue("SQL_UPDATE_PO_ORDER_FCY_DTL_GRN_QTY"));

			hmSQLMap.put("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_INSERT_PO_ORDER_UNF_GRN_RECORDS"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_UPDATE_PO_ORDER_UNF_GRN_RECORDS"));
			hmSQLMap.put("SQL_COUNT_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_COUNT_PO_ORDER_UNF_GRN_RECORDS"));
			hmSQLMap.put("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS", getStRepositoryValue("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS"));
			hmSQLMap.put("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS1", getStRepositoryValue("SQL_DELETE_PO_ORDER_UNF_GRN_RECORDS1"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_HDR_FOR_NEXT_DEL_DATE", getStRepositoryValue("SQL_UPDATE_PO_ORDER_HDR_FOR_NEXT_DEL_DATE"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_HDR_STATUS", getStRepositoryValue("SQL_UPDATE_PO_ORDER_HDR_STATUS"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_FCY_DTL_STATUS", getStRepositoryValue("SQL_UPDATE_PO_ORDER_FCY_DTL_STATUS"));
			//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
			hmSQLMap.put("SQL_MM_ITEM_UPDATE_PUR_UOM", getStRepositoryValue("SQL_MM_ITEM_UPDATE_PUR_UOM")); 
			
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_QTY", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_HDR_STATUS", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_HDR_STATUS"));
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_DTL_STATUS", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_DTL_STATUS"));
			hmSQLMap.put("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_BLOCK_QTY", getStRepositoryValue("SQL_UPDATE_PO_DELV_ORD_DTL_BAT_GRN_BLOCK_QTY"));
			hmSQLMap.put("SQL_UPDATE_PO_ORDER_UNF_GRN_DO_QTY_IN_DO_BAT1", getStRepositoryValue("SQL_UPDATE_PO_ORDER_UNF_GRN_DO_QTY_IN_DO_BAT1"));
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	
		return goodsReceivedNoteMethodCall(hmData, hmSQLMap, FUNCTION_UPDATE );
	}

	public HashMap goodsReceivedNoteMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
/*
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = new eST.GoodsReceivedNote12.GoodsReceivedNoteManager().insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					hmResult = new eST.GoodsReceivedNote12.GoodsReceivedNoteManager().modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					hmResult = new eST.GoodsReceivedNote12.GoodsReceivedNoteManager().delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to goodsReceivedNoteMethodCall()") ;
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
		//GoodsReceivedNoteHome	goodsReceivedNoteHome		= null ;
	//	GoodsReceivedNoteRemote	goodsReceivedNoteRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
		/*	InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_GOODS_RECEIVED_NOTE") ) ;

			goodsReceivedNoteHome  = (GoodsReceivedNoteHome) PortableRemoteObject.narrow( object, GoodsReceivedNoteHome.class ) ;
			goodsReceivedNoteRemote = goodsReceivedNoteHome.create() ;*/

			

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_GOODS_RECEIVED_NOTE"),GoodsReceivedNoteLocalHome.class,getLocalEJB());
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
					hmResult.put( "message", "Invalid Function ID passed to goodsReceivedNoteMethodCall()") ;
			}
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			System.out.println("hmResult==1086-->"+hmResult);

			if(((Boolean) hmResult.get("result")).booleanValue())	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message"))) ;

			// Added for Online Printing on 9/22/2004		

/* SEND TO PRINT ONLINE REPORT STARTS*/		


	         ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getStore_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBGRNDC";

		    if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())){
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ){
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}
						else{
							/*HashMap hmTemp = new HashMap();
							for (int i=0;i<alDtlRecords.size();i++) {
								hmTemp = (HashMap)alDtlRecords.get(i);
								if(((String)hmTemp.get("label_reqd_yn")).equals("Y")){
									//for(int j=0;j<Integer.parseInt((String)hmTemp.get("no_of_labels"));j++){
										String pdocno = "";
										for(int k=0;k<doc_no.size();k++){
											pdocno=(String)doc_no.get(k);
											doOnlineReportPrintingOfLabel(pdocno,(String)hmTemp.get("item_code"));	
										}
								//doOnlineReportPrintingOfLabel(doc_no,(String)hmTemp.get("item_code"));
									//}
								}
							}
							String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}*/
							//doOnlineReportPrinting(doc_no);	
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
				
			}
 			catch( Exception exception) {
				exception.printStackTrace() ;
				hmResult.put( "message", "Bean 732: "+exception.toString()) ;
			}
		}

		

		/*if (finalized_yn.equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			String doc_no	=	(String)hmResult.get("doc_no");	
			doOnlineReportPrintingOfLabel(doc_no);
			 if (isInternalRequest("ST","STBGRNDC")) {
				doOnlineReportPrinting(doc_no);				
			}
		}*/  


		return hmResult;
	}
	/*public void doOnlineReportPrinting(String doc_no) {
		

		try{
			String reportid = "STBGRNDC";

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
	
			String reportid = "STBGRNDC";
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

	/*public void doOnlineReportPrintingOfLabel(String doc_no,String item_code) {
		try{



			String reportid = "STBITLBL";
			
			//if (!isInternalRequest("ST",reportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_fm_item_code",item_code);
			hmReportParameter.put("p_to_item_code",item_code);
  //          javax.servlet.http.HttpSession session = request.getSession(false);
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","L");
			hmParameters.put("location_code","1");
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

public void doOnlineReportPrintingOfLabel(String doc_no,String item_code,Object request,Object response) {
		try{
	
			String reportid = "STBITLBL";
			
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
				report2.addParameter("p_fm_item_code",item_code);
				report2.addParameter("p_to_item_code",item_code);
				onlineReports.add( report2) ;

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
			String reportid = "STBGRNDC";
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
		return hmRecord.get("GRN_FINALIZE_ALLOWED_YN").toString();
	}

	public boolean isLabelRequired(String stItem_code)throws Exception{
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(stItem_code);
		arr_lang.add(getLanguageId());
		return fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SELECT_SINGLE"),stItem_code).get("LABEL_REQD_YN").toString().equals("Y");
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
	public String getGenItemUOMDesc(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			base_uom = fetchRecord("SELECT MM.GEN_UOM_CODE, AM.SHORT_DESC FROM MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE ITEM_CODE = ? AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = MM.LANGUAGE_ID AND MM.LANGUAGE_ID = ?",chkdefaultParameters);
			//	base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("SHORT_DESC");

		return gen_uom_code;
	}
	public String getGRNItemClassBased(String trntype)
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

	//for handle the PORequest


	private String entity_param;
	private String trn_type;

	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}
	public String getEntity_param() {
		return this.entity_param;
	}
	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}
	public String getTrn_type() {
		return this.trn_type;
	}

	public String getDoc_type_code_List_PO(String po_noq) {
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(po_noq);
		alParameters.add(getLanguageId());
	
		HashMap records			  = new HashMap();
		String result				="";
		try{
			
		records = fetchRecord("select  b.SHORT_DESC SHORT_DESC FROM po_request_hdr a ,sy_doc_type_master_lang_vw b where a.FACILITY_ID=? and a.DOC_NO=? and a.doc_type_code=b.DOC_TYPE_CODE and b.language_id=?",alParameters);
				result=(String)records.get("SHORT_DESC");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;

		
		}
	public String getDoc_type_code_List_PO_create() {
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getEntity_param());
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList("SELECT   a.doc_type_code, b.short_desc FROM st_trn_doc_type a,sy_doc_type_master_lang_vw b,sy_acc_entity_doc_type c,st_acc_entity_param d WHERE a.facility_id = ?  AND a.doc_type_code = b.doc_type_code  AND a.trn_type = 'PRQ' AND d.ACC_ENTITY_ID=? and d.INTERFACE_TO_EXTERNAL_PO_YN='Y' AND b.status IS NULL AND a.doc_type_code = c.doc_type_code  AND b.language_id = ? ORDER BY 2",alParameters),"");
	
	}

/*
	Mahesh
*/
	public void loadPODetailPage(String po_doc_no, String po_doc_type_code) throws Exception{
		HashMap hmRecord = new HashMap();
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(po_doc_type_code);
		alParameters.add(po_doc_no);
		alParameters.add(getLanguageId());
		alParameters.add(po_doc_no);
		alParameters.add(getLoginFacilityId());
		//ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_XI_TRN_GRN_SELECT2"), alParameters);
		ArrayList alRecords	=	fetchRecords("SELECT DTL.DOC_NO,DTL.DOC_SRL_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,DTL.REQ_QTY ITEM_QTY_NORMAL, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE,'0' ITEM_COST_VALUE, STOCK_ITEM_YN, 'N' LABEL_REQD_YN,'0' GRN_UNIT_COST_IN_PUR_UOM, REQ_UOM PUR_UOM_CODE, REQ_GEN_UOM_CONV_FACTOR PUR_UOM_CONV,'N' REPLACE_ON_EXPIRY_YN, '0' GRN_UNIT_COST_IN_STK_UOM,AM.SHORT_DESC GEN_UOM_DESC, AM.UOM_CODE, STITEM.EXPIRY_YN,'0' NO_OF_LABELS, AM1.SHORT_DESC UOM_DESC, '' PO_COST,'' PO_DISCOUNT, '' PO_TAX,'X' FLAG  FROM PO_REQUEST_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,AM_UOM_LANG_VW AM1,ST_ITEM_STORE ST,PO_REQUEST_HDR HDR WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND AM1.UOM_CODE = ST.DEF_ISSUE_UOM AND ST.ITEM_CODE = DTL.ITEM_CODE AND ST.STORE_CODE = HDR.REQ_STORE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND CURR_STATUS = 'P' AND DTL.DOC_NO NOT IN (SELECT DISTINCT REQUEST_NUM  FROM XI_TRN_GRN WHERE REQUEST_NUM = ? AND FACILITY_ID = ?) AND DTL.GRN_QTY <=0 ORDER BY 2", alParameters);
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
			hmTemp.put("replace_on_expiry_yn",hmRecord.get("REPLACE_ON_EXPIRY_YN"));
			hmTemp.put("label_reqd_yn",hmRecord.get("LABEL_REQD_YN"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
			hmTemp.put("item_qty_bonus",checkForNull((String)hmRecord.get("ITEM_QTY_BONUS")));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("item_qty_normal",checkForNull((String)hmRecord.get("ITEM_QTY_NORMAL")));
			hmTemp.put("item_qty_sample",checkForNull((String)hmRecord.get("ITEM_QTY_SAMPLE")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("pur_uom_code",hmRecord.get("PUR_UOM_CODE"));
			hmTemp.put("pur_uom_conv",checkForNull((String)hmRecord.get("PUR_UOM_CONV"), "1"));
			hmTemp.put("grn_unit_cost_in_pur_uom",hmRecord.get("GRN_UNIT_COST_IN_PUR_UOM"));
			hmTemp.put("no_of_labels",checkForNull((String)hmRecord.get("NO_OF_LABELS"),"0"));
			hmTemp.put("gen_uom_desc",checkForNull((String)hmRecord.get("GEN_UOM_DESC")));
			hmTemp.put("po_cost",checkForNull((String)hmRecord.get("PO_COST"),"0"));
			hmTemp.put("po_discount",checkForNull((String)hmRecord.get("PO_DISCOUNT")));
			hmTemp.put("po_tax",checkForNull((String)hmRecord.get("PO_TAX")));
			hmTemp.put("to_conv_fact",""+getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)getStore_code()));
			hmTemp.put("flag",(String)hmRecord.get("FLAG"));

			hmTemp.put("pur_uom_conv_id",checkForNull((String)hmRecord.get("PUR_UOM_CONV"),"1"));

			int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE")}).get("COUNT"));
			int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE"),(String)hmRecord.get("ITEM_CODE")}).get("COUNT"));
			if(item_uom_count >0){
			HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty)  conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE"),(String)hmRecord.get("ITEM_CODE")});
			String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)hmRecord.get("UOM_CODE")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)hmRecord.get("PUR_UOM_CODE");
			hmTemp.put("pur_uom_conv_id",conver);
			hmTemp.put("pur_uom_conv",checkForNull((String)stEqvl_value1.get("CONV_FACTOR"),"1"));

			}else if(am_count > 0){
			String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hmRecord.get("UOM_CODE"), (String)hmRecord.get("PUR_UOM_CODE")}).get("EQVL_VALUE");
			String conver=stEqvl_value+" "+(String)hmRecord.get("UOM_CODE")+" = 1 "+(String)hmRecord.get("PUR_UOM_CODE");
			hmTemp.put("pur_uom_conv_id",conver);
	

			}else{
			String conver="1 "+(String)hmRecord.get("UOM_CODE")+" = 1 "+(String)hmRecord.get("PUR_UOM_CODE");
			hmTemp.put("pur_uom_conv_id",conver);
			}



			alDtlRecords.add(hmTemp);
		}
	}

/*
		public ArrayList getPo_Number_List(String store_code,String supp_code) throws Exception {					
			try{
			ArrayList arr_language = new ArrayList();
			arr_language.add(store_code);
			arr_language.add(supp_code);	
			arr_language.add(getLoginFacilityId());
			ArrayList arraylist = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_PO_NUMBER_SELECT_LIST"), arr_language);
			return arraylist;
			}catch(Exception e){
				throw e;
			}			
		}
		
	public void loadNewPODetails(String po_no,String store_code) throws Exception{
		HashMap hmRecord = new HashMap();
		ArrayList alParameters = new ArrayList();
		alParameters.add(po_no);
		alParameters.add(getLanguageId());
		alParameters.add(store_code);
		alParameters.add(getLoginFacilityId());

		setPo_no(checkForNull(po_no));

		ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_PO_NUMBER_DETAILS_SELECT"), alParameters);
		alDtlRecords.clear();
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));

			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value","0");
			hmTemp.put("order_value",hmRecord.get("ITEM_COST_VALUE"));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			//hmTemp.put("item_qty_normal",checkForNull((String)hmRecord.get("ITEM_QTY_NORMAL")));
			hmTemp.put("item_qty_normal","0");
			hmTemp.put("item_qty_bonus",checkForNull((String)hmRecord.get("ITEM_QTY_BONUS")));
			hmTemp.put("item_qty_sample",checkForNull((String)hmRecord.get("ITEM_QTY_SAMPLE")));
			hmTemp.put("ordered_qty",checkForNull((String)hmRecord.get("ITEM_QTY_NORMAL")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("uom_desc",hmRecord.get("GEN_UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("pur_uom_code",hmRecord.get("PUR_UOM_CODE"));
			hmTemp.put("pur_uom_desc",hmRecord.get("PUR_UOM_DESC"));
			hmTemp.put("pur_uom_conv",checkForNull((String)hmRecord.get("PO_GEN_UOM_CONV_FACTOR"), "1"));
			hmTemp.put("grn_unit_cost_in_pur_uom",hmRecord.get("ITEM_UNIT_COST"));
			hmTemp.put("to_conv_fact",""+getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)getStore_code()));
			hmTemp.put("pur_uom_conv_id",checkForNull((String)hmRecord.get("PO_GEN_UOM_CONV_FACTOR"),"1"));
			hmTemp.put("allow_deci_yn",checkForNull((String)hmRecord.get("ALLOW_DECIMALS_YN"),"N"));
			hmTemp.put("no_deci", checkForNull((""+getNoOfDecimals()),"0"));
			hmTemp.put("currency_code", checkForNull((String)hmRecord.get("CURRENCY_CODE")));		
			hmTemp.put("delivery_date", checkForNull((String)hmRecord.get("DELIVERY_DATE")));				
			hmTemp.put("by_po", "Y");
			
			setCurrency_code(checkForNull((String)hmRecord.get("CURRENCY_CODE")));
			
			alDtlRecords.add(hmTemp);
		}

		System.out.println("alDtlRecords============1478================>"+alDtlRecords);
	}

	
		public void setPODetails(Hashtable htRecords){
			try { 
				
				HashMap hmRecord	=	new HashMap();
				HashMap temp = null;
				int size = alPoRecords.size();

			
				for (int i=0;i<Integer.parseInt((String)htRecords.get("index")); i++) {
					boolean result = true;
					if (htRecords.get("grn_item_qty_"+i).toString().equals(""))
						continue;
					   
					
					hmRecord.put("po_number",		(String)htRecords.get("po_number"));
					hmRecord.put("item_code",		(String)htRecords.get("item_code"));
					hmRecord.put("grn_item_qty",    (String)htRecords.get("grn_item_qty_"+i));
					hmRecord.put("pur_req_no",		(String)htRecords.get("pur_req_no_"+i));
					hmRecord.put("pur_req_facility_id",    (String)htRecords.get("pur_facility_id_"+i));
					hmRecord.put("pur_req_doc_srl_no",		(String)htRecords.get("pur_doc_srl_no_"+i));

					hmRecord.put("po_doc_srl_no",		(String)htRecords.get("po_doc_srl_no_"+i));
					hmRecord.put("pur_unit_code",		(String)htRecords.get("pur_unit_code"));
					hmRecord.put("store_code",		(String)htRecords.get("store_code"));

					
					if(alPoRecords!=null && alPoRecords.size()>0){
					 for(int j=0 ; j<size;j++){
						temp = (HashMap)alPoRecords.get(j);
						if(((String)htRecords.get("item_code")).equals((String)temp.get("item_code"))){
						temp.put("grn_item_qty",(String)htRecords.get("grn_item_qty_"+i));
						temp.put("pur_req_no",		(String)htRecords.get("pur_req_no_"+i));
						temp.put("po_number",		(String)htRecords.get("po_number"));
						temp.put("item_code",		(String)htRecords.get("item_code"));
						temp.put("pur_doc_type_code",		(String)htRecords.get("pur_doc_type_code_"+i));
						temp.put("pur_facility_id",    (String)htRecords.get("pur_facility_id_"+i));
						temp.put("pur_doc_srl_no",		(String)htRecords.get("pur_doc_srl_no_"+i));
						temp.put("po_doc_srl_no",		(String)htRecords.get("po_doc_srl_no_"+i));
						temp.put("pur_unit_code",		(String)htRecords.get("pur_unit_code"));
						temp.put("store_code",		(String)htRecords.get("store_code"));

						alPoRecords.set(j,temp);
						result = false;
						}
					 }
					}else{
					alPoRecords.add(hmRecord);
					result = false;
					}
					if(result){
					alPoRecords.add(hmRecord);
					}
				  }
				System.out.println("alPoRecords======1514============>"+alPoRecords);

			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		*/

		public void setPODetails(ArrayList alPoRecords){
		this.alPoRecords = alPoRecords;
		}
		public ArrayList getPoRecords(){
		return alPoRecords;
		}
		



	/*public void loadPODetailPage(String po_doc_no, String po_doc_type_code) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(po_doc_type_code);
		alParameters.add(po_doc_no);
		
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_XI_TRN_GRN_SELECT_MAX"), alParameters);
	//	HashMap hmRecord=	fetchRecord("SELECT	MAX(doc_srl_no)	max_doc_srl_no FROM	XI_TRN_GRN WHERE facility_id=? AND doc_type_code=? AND doc_no=?", alParameters);
		doc_srl_no		=	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_XI_TRN_GRN_SELECT1"), alParameters);
	//	hmRecord	=	fetchRecord("SELECT	TO_CHAR(doc_date,'dd/mm/yyyy') doc_date, doc_ref, store_code, item_class_code, 'N' finalized_yn,'N' gl_interfaced_yn, '' trn_type,'' supp_code,'' currency_code,'N' entry_completed_yn,  '' receipt_date, '' po_no FROM XI_TRN_GRN WHERE facility_id=? AND doc_type_code=? AND doc_no=? ", alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setStore_code((String)hmRecord.get ("STORE_CODE"));  
		setItem_class_code((String)hmRecord.get ("ITEM_CLASS_CODE"));  
		setEntry_completed_yn((String)hmRecord.get ("ENTRY_COMPLETED_YN"));  
		setCurrency_code((String)hmRecord.get("CURRENCY_CODE"));
		setSupp_code((String)hmRecord.get("SUPP_CODE"));
		setReceipt_date((String)hmRecord.get("RECEIPT_DATE"));
		setPo_no((String)hmRecord.get("PO_NO"));
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(po_doc_type_code);
		alParameters.add(po_doc_no);
		alParameters.add(getLanguageId());
	//	ArrayList alRecords	=	fetchRecords("SELECT dtl.doc_srl_no, dtl.item_code, mmitem.short_desc item_desc,dtl.ITEM_QTY item_qty_normal, '0' item_qty_bonus, '0' item_qty_sample,dtl.item_cost_value, '' stock_item_yn, 'N' label_reqd_yn, dtl.grn_unit_cost_in_pur_uom, dtl.pur_uom_code, dtl.pur_uom_conv,'N' replace_on_expiry_yn,  dtl.grn_unit_cost_in_stk_uom,am.short_desc gen_uom_desc, am.uom_code, stitem.expiry_yn,'0' no_of_labels, am1.short_desc uom_desc, dtl.po_cost, dtl.po_discount, dtl.po_tax FROM XI_TRN_GRN dtl, mm_item_lang_vw mmitem, st_item stitem, am_uom_lang_vw am, am_uom_lang_vw am1, st_item_store st WHERE mmitem.item_code = dtl.item_code AND stitem.item_code = dtl.item_code AND mmitem.gen_uom_code = am.uom_code AND dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND mmitem.language_id = am.language_id  AND mmitem.language_id =? AND am.language_id = am1.language_id AND am1.uom_code = st.def_issue_uom AND st.item_code = dtl.item_code AND st.store_code = dtl.store_code ", alParameters);
		ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_XI_TRN_GRN_SELECT2"), alParameters);
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("replace_on_expiry_yn",hmRecord.get("REPLACE_ON_EXPIRY_YN"));
			hmTemp.put("label_reqd_yn",hmRecord.get("LABEL_REQD_YN"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
			hmTemp.put("item_qty_bonus",checkForNull((String)hmRecord.get("ITEM_QTY_BONUS")));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("item_qty_normal",checkForNull((String)hmRecord.get("ITEM_QTY_NORMAL")));
			hmTemp.put("item_qty_sample",checkForNull((String)hmRecord.get("ITEM_QTY_SAMPLE")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("pur_uom_code",hmRecord.get("PUR_UOM_CODE"));
			hmTemp.put("pur_uom_conv",checkForNull((String)hmRecord.get("PUR_UOM_CONV"), "1"));
			hmTemp.put("grn_unit_cost_in_pur_uom",hmRecord.get("GRN_UNIT_COST_IN_PUR_UOM"));
			hmTemp.put("no_of_labels",checkForNull((String)hmRecord.get("NO_OF_LABELS"),"0"));
			hmTemp.put("gen_uom_desc",checkForNull((String)hmRecord.get("GEN_UOM_DESC")));
			hmTemp.put("po_cost",checkForNull((String)hmRecord.get("PO_COST"),"0"));
			hmTemp.put("po_discount",checkForNull((String)hmRecord.get("PO_DISCOUNT")));
			hmTemp.put("po_tax",checkForNull((String)hmRecord.get("PO_TAX")));
			hmTemp.put("to_conv_fact",""+getConvFactTemp((String)hmRecord.get("item_code"),(String)getStore_code()));

			alDtlRecords.add(hmTemp);
		}

		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(po_doc_type_code);
		alParameters.add(po_doc_no);
		alParameters.add(getLanguageId());
		HashMap hmTempRecord;
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			alParameters.set(3,(String)hmRecord.get("doc_srl_no"));
			alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_XI_TRN_GRN_SELECT3"), alParameters);
		//	alRecords	=	fetchRecords("select grn_item_qty, trade_id, TO_CHAR(EXPIRY_DATE ,'dd/mm/yyyy') expiry_date_or_receipt_date, item_code, store_code, XI_BATCH_ID batch_id,'' bin_location_code,sale_price from XI_TRN_GRN stexp WHERE stexp.facility_id=? AND stexp.doc_type_code=? AND stexp.doc_no=? AND stexp.doc_srl_no=?", alParameters);
			for (int j=0; j<alRecords.size(); j++) {
				HashMap hmTemp	=	new HashMap();	
				hmTempRecord=	(HashMap)alRecords.get(j);
				hmTemp.put("grn_item_qty", hmTempRecord.get("GRN_ITEM_QTY"));             
				hmTemp.put("trade_id", checkForNull((String)hmTempRecord.get("TRADE_ID"),getDefaultTradeID()));                 
				hmTemp.put("expiry_date_or_receipt_date", hmTempRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				hmTemp.put("item_code", hmTempRecord.get("ITEM_CODE"));                
				hmTemp.put("store_code", hmTempRecord.get("STORE_CODE"));               
				hmTemp.put("batch_id", hmTempRecord.get("BATCH_ID"));                 
				hmTemp.put("bin_location_code",getDefaultBinLocationCode((String)hmTempRecord.get("STORE_CODE"),(String)hmTempRecord.get("ITEM_CODE")));        
				hmTemp.put("sale_price", checkForNull((String)hmTempRecord.get("SALE_PRICE")));        
				hmTemp.put("gen_uom_desc", (String)hmRecord.get("gen_uom_desc"));        
				alRecords.set(j, hmTemp);
			}
			hmExpRecords.put(""+i,alRecords);
		}

	}

	public String getDefaultBinLocationCode(String store_code, String item_code) throws Exception{
		ArrayList mmParameters	=	new ArrayList(2);
		mmParameters.add(checkForNull(store_code));
		mmParameters.add(checkForNull(item_code));
					
	String	bin_location_code =checkForNull((String)fetchRecord("select bin_location_code from st_item_store where store_code=? and item_code=?",mmParameters).get("BIN_LOCATION_CODE"));
	
		return bin_location_code;

}
public String getDefaultTradeID() throws Exception{
		
					
	String	trade_id =checkForNull((String)fetchRecord("select DFLT_TRADE_ID from mm_parameter where MODULE_ID=?","MM").get("DFLT_TRADE_ID"));
	
		return trade_id;

}*/
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
		//ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		//HashMap<String,String> hmItemHdrData = (HashMap<String,String>)hmTableData.get("HDR_DATA");
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
							if((hmTempExpData.get("item_code")).equals(hmTempData.get("item_code"))){
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
		hmTableData.put("DTL_DATA",alNewTempDtlData);
		hmTableData.put("DTL_EXP_DATA",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
	
		return hmTableData;
	}

	public String getPurchaseUnitList() {
		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_PO_PURCHASE_UNIT_LIST"),sqlParam),""); 
		
	}

	public String getUOMDesc(String uom_code) throws Exception {

		String uom	  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_UOM_DESC_SELECT"),uom_code);
		}catch(Exception e){
			uom = "";
		}
		
		if(default_uom.size() > 0)
			uom = (String)default_uom.get("SHORT_DESC");

		return uom;

	}
	
	public void setPoItemDetails(HashMap PoItemDetails){
		this.PoItemDetails = PoItemDetails;
	}

	public ArrayList getPoItemDetails(String po_number){
		return (ArrayList)PoItemDetails.get(po_number);
	}

	public HashMap getPoItemDetails(){
		return PoItemDetails;
	}

	public void setPONextDelDate(String PONextDelDate){
		this.PONextDelDate = checkForNull(PONextDelDate);
	}
	
	public String getPONextDelDate(){
		return PONextDelDate;
	}

	public boolean isPOApplicable() throws Exception{
		return checkForNull((String)fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),getEntity_param()).get("PO_INTERFACE_YN")).equals("Y");
	}

	public String getDoNoList(String do_no,String store_code,String mode,String supp_code) {
		ArrayList arr_language=new ArrayList();
			arr_language.add(getLanguageId());
			arr_language.add(store_code);
			arr_language.add(getLoginFacilityId());			
			arr_language.add(checkForNull(supp_code));			

		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){
			return getListOptionTag(getListOptionArrayList("SELECT DISTINCT A.DO_NO CODE,A.DO_NO||'      '||FACILITY_NAME DESCRIPTION FROM PO_DELV_ORD_DTL_BAT A,SM_FACILITY_PARAM_LANG_VW B ,PO_DELV_ORD_HDR C WHERE A.ADDED_FACILITY_ID = B.FACILITY_ID AND B.LANGUAGE_ID = ?  AND A.DO_NO = C.DO_NO AND C.DO_STATUS IN ('FN','PR') AND A.DIST_STORE_CODE=?  AND  A.DIST_FACILITY_ID = ? AND DO_QTY_NORMAL - NVL(GRN_QTY,0) - (SELECT NVL (SUM (NVL (BLOCKED_QTY, 0)), 0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = A.PO_NO  AND ITEM_CODE = A.ITEM_CODE  AND DO_NO=A.DO_NO) > 0  AND C.SUPP_CODE= ?  AND A.PO_NO <> '*A' ORDER BY 1,2",arr_language),do_no);
		}
		else{
			arr_language.add(do_no);
			return getListOptionTag(getListOptionArrayList("SELECT DISTINCT A.DO_NO CODE,A.DO_NO||'      '||FACILITY_NAME DESCRIPTION FROM PO_DELV_ORD_DTL_BAT A,SM_FACILITY_PARAM_LANG_VW B ,PO_DELV_ORD_HDR C WHERE A.ADDED_FACILITY_ID = B.FACILITY_ID AND B.LANGUAGE_ID = ?  AND A.DO_NO = C.DO_NO AND C.DO_STATUS IN ('FN','PR') AND A.DIST_STORE_CODE=?  AND  A.DIST_FACILITY_ID = ?  AND C.SUPP_CODE= ? AND A.DO_NO = ?  ORDER BY 1,2",arr_language),do_no);
		}
	}

	public void setDoExpRecords(HashMap DoExpRecords){
		this.DoExpRecords = DoExpRecords;
	}
	
	public HashMap getDoExpRecords(){
		return DoExpRecords;
	}

	public ArrayList getDoExpRecords(String item_code){
		return (ArrayList)DoExpRecords.get(item_code);
	}

	public String getManufactId(String item_code)
	{
		ArrayList alParameters=new ArrayList();
		ArrayList	alRecords		=	new  ArrayList();		
		alParameters.add(item_code);
		String manufactureId = "";
		try{
			 alRecords	=	fetchRecords("select MANUFACTURER_ID from mm_item where ITEM_CODE= ?", alParameters);
			//System.out.println("alRecords: "+alRecords);  
			 manufactureId =(String) alRecords.get(0);  
				
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("manufactureId: "+manufactureId); 
		return manufactureId;  
	}
	
	public String getManufactDesc(String manufacturerCode)
	{
		ArrayList alParameters=new ArrayList();
		ArrayList	alRecords		=	new  ArrayList();
		alParameters.add(getLanguageId()); 
		alParameters.add(manufacturerCode);
		String manufacturerDesc = "";
		HashMap hmRecord = new HashMap();
		try{
			 alRecords	=	fetchRecords("select SHORT_NAME from am_manufacturer_lang_vw where LANGUAGE_ID = ?  and manufacturer_id= ? ", alParameters);
			//System.out.println("alRecords: "+alRecords);  
			 for (int i=0; i<alRecords.size(); i++) {
				 hmRecord = (HashMap)alRecords.get(i);
				 manufacturerDesc = (String)hmRecord.get("SHORT_NAME"); 
			 }
				
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("manufacturerDesc: "+manufacturerDesc); 
		return manufacturerDesc;   
	}
	
 
	
	public ArrayList getDropDownList(String selectedcode) {  
		ArrayList alParameters=new ArrayList();
		ArrayList	alRecords		=	new  ArrayList();
		alParameters.add(getLanguageId());
		HashMap hmRecord = new HashMap();
	
	/*	HashMap records			  = new HashMap();
	//	String result				="";*///commented for 15757
		ArrayList arrList=new ArrayList();
		
		try{ 
			if(selectedcode=="MANU"){
				alRecords	=	fetchRecords("SELECT manufacturer_id,short_name FROM am_manufacturer_lang_vw am_manufacturer WHERE  eff_status='E' AND language_id = ? ORDER BY short_name", alParameters);
				 for (int i=0; i<alRecords.size(); i++) {
					 hmRecord =(HashMap) alRecords.get(i);  
					 HashMap hmTemp	=	new HashMap();
					 hmTemp.put("code", hmRecord.get("MANUFACTURER_ID")); 
					 hmTemp.put("desc", hmRecord.get("SHORT_NAME")); 
					 arrList.add(hmTemp); 
			}
			 } 
			else if (selectedcode=="CAT"){
				 alRecords	=	fetchRecords("SELECT CATALOG_CODE,LONG_DESC FROM mm_catalog_code WHERE  eff_status='E' ORDER BY LONG_DESC"); //MO-CRF-20178  
				 for (int i=0; i<alRecords.size(); i++) {
					 hmRecord =(HashMap) alRecords.get(i);  
					 HashMap hmTemp	=	new HashMap();
					 hmTemp.put("code", hmRecord.get("CATALOG_CODE")); 
					 hmTemp.put("desc", hmRecord.get("LONG_DESC"));  //MO-CRF-20178
					 arrList.add(hmTemp);  
				 } 
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("arrList: "+arrList);  
		return arrList; 
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
