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
import java.util.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;


//		Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class SalesReturnBatchSearchBean extends StTransaction implements Serializable {

	private ArrayList DataList=new ArrayList();
	private ArrayList selectedList;

	private String item_code_from="";
	private String item_code_to="";

	private String store_code="";
	private String sal_trn_type="";

	private String patient_id="";
	private String encounter_id="";
	//private String language_id;

	private String searchFunction="N";
	private String multipleSelect="N";
	private String maxAllowed="1";

	private boolean bSortDesc =false;
	
	/*added for GHL-ICN-0034 START*/
	private String doc_no;
	
	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}
	/*added for GHL-ICN-0034 END*/
	
	public void toggleSort(){
		bSortDesc =!bSortDesc ;
	}

	public boolean getSortDesc(){
		return bSortDesc ;
	}


	public void setMaxAllowed(String maxAllowed) {
		 this.maxAllowed = checkForNull(maxAllowed,"1");
	}

	public String getMaxAllowed( ) {
		 return maxAllowed;
	}

	public void setSearchFunction(String searchFunction) {
		 this.searchFunction = checkForNull(searchFunction,"N");
	}

	public String getSearchFunction( ) {
		 return searchFunction;
	}

	public void setMultipleSelect(String multipleSelect) {
		 this.multipleSelect = checkForNull(multipleSelect,"N");
	}

	public String getMultipleSelect( ) {
		 return multipleSelect;
	}
/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setItem_code_from(String item_code_from) {
		 this.item_code_from = checkForNull(item_code_from);
	}

	public String getItem_code_from( ) {
		 return item_code_from;
	}

	public void setItem_code_to(String item_code_to) {
		 this.item_code_to = checkForNull(item_code_to);
	}

	public String getItem_code_to( ) {
		 return item_code_to;
	}

	public void setStore_code(String store_code) {
		 this.store_code = checkForNull(store_code);
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setEncounter_id(String encounter_id) {
		 this.encounter_id = checkForNull(encounter_id);
	}

	public String getEncounter_id( ) {
		 return encounter_id;
	}

	public void setPatient_id(String patient_id) {
		 this.patient_id = checkForNull(patient_id);
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setSal_trn_type(String sal_trn_type) {
		 this.sal_trn_type = checkForNull(sal_trn_type);
	}

	public String getSal_trn_type( ) {
		 return sal_trn_type;
	}

	public void loadResultPage(String doc_type_code,String doc_no,String trn_type,String sales_doc_type_code,String sales_doc_no) throws Exception {
	
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
        alParameters.add(getLoginFacilityId());
    	alParameters.add(patient_id);
		alParameters.add(encounter_id);
        alParameters.add(item_code_from);
        alParameters.add(store_code);
        alParameters.add(sal_trn_type);
        alParameters.add(getLanguageId());
        alParameters.add(sales_doc_type_code);
        alParameters.add(sales_doc_no);
        //Added by suresh.r on 28-10-2014 against against Inc 2919 beg
        alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
        //Added by suresh.r on 28-10-2014 against against Inc 2919 end
		/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 
	
		int no_of_decimals=getNoOfDecimals();
		
		/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end
		
			*/ 
		ArrayList listRecord =new ArrayList();
		try {
						
			//String stSQL=getStRepositoryValue("SQL_ST_SALES_RETURN_BATCH_SEARCH_QUERY");
			//String stSQL="SELECT   sde.item_code, mmi.short_desc item_desc, sde.batch_id, sde.bin_location_code bin_location_code,sde.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, TO_CHAR (sde.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_receipt_dt, sde.trade_id, DECODE(sti.trade_id_applicable_yn, 'Y', (SELECT short_name FROM am_trade_name_lang_vw  am_trade_name WHERE trade_id = sde.trade_id AND mmi.language_id = am_trade_name.language_id), sde.trade_id) trade_name, sde.sal_item_qty, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )avail_qty, sde.doc_type_code sal_doc_type_code, sde.doc_no sal_doc_no, sde.doc_srl_no sal_doc_srl_no, TO_CHAR (sdh.doc_date, 'dd/mm/yyyy') sal_doc_date, srexp.bin_location_code ret_bin_locn FROM ST_SAL_DTL_EXP sde, mm_item_lang_vw mmi, ST_ITEM sti, ST_SAL_HDR sdh,          ST_SAL_DTL ssd, mm_bin_location_lang_vw mmb, ST_SAL_RET_DTL_EXP srexp WHERE (sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )) > 0 AND sde.facility_id = ? AND sde.facility_id || '-' || sde.doc_type_code || '-' || sde.doc_no IN (SELECT facility_id || '-' || doc_type_code || '-' || doc_no FROM ST_SAL_HDR WHERE patient_id = ? AND NVL (encounter_id, 0) LIKE NVL (?, '0') AND finalized_yn = 'Y') AND mmi.item_code = sde.item_code AND sde.item_code = sti.item_code AND sde.item_code = ? AND sde.store_code = ? AND mmb.bin_location_code = sde.bin_location_code AND mmb.store_code = sde.store_code AND (    sde.facility_id = ssd.facility_id AND sde.doc_type_code = ssd.doc_type_code AND sde.doc_no = ssd.doc_no AND sde.doc_srl_no = ssd.doc_srl_no) AND sdh.sal_trn_type = ? AND ssd.stock_item_yn = 'Y' AND (    sdh.facility_id = ssd.facility_id AND sdh.doc_type_code = ssd.doc_type_code AND sdh.doc_no = ssd.doc_no) AND mmi.language_id = mmb.language_id AND mmi.language_id = ? AND sde.doc_type_code = ? AND sde.doc_no = ? AND sde.batch_id = srexp.batch_id(+) AND sde.trade_id = srexp.trade_id(+) 	 AND sde.doc_no = srexp.sal_doc_no(+) AND sde.doc_type_code = srexp.sal_doc_type_code(+) AND  TRUNC(sde.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC(srexp.EXPIRY_DATE_OR_RECEIPT_DATE(+)) ORDER BY sdh.added_date";
			//Modified by suresh.r on 28-10-2014 against against Inc 2919
			//String stSQL="SELECT   sde.item_code, mmi.short_desc item_desc, sde.batch_id, sde.bin_location_code bin_location_code,sde.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, TO_CHAR (sde.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_receipt_dt, sde.trade_id, DECODE(sti.trade_id_applicable_yn, 'Y', (SELECT short_name FROM am_trade_name_lang_vw  am_trade_name WHERE trade_id = sde.trade_id AND mmi.language_id = am_trade_name.language_id), sde.trade_id) trade_name, sde.sal_item_qty, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )avail_qty, sde.doc_type_code sal_doc_type_code, sde.doc_no sal_doc_no, sde.doc_srl_no sal_doc_srl_no, TO_CHAR (sdh.doc_date, 'dd/mm/yyyy') sal_doc_date, srexp.bin_location_code ret_bin_locn FROM ST_SAL_DTL_EXP sde, mm_item_lang_vw mmi, ST_ITEM sti, ST_SAL_HDR sdh,          ST_SAL_DTL ssd, mm_bin_location_lang_vw mmb, ST_SAL_RET_DTL_EXP srexp WHERE (sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )) > 0 AND sde.facility_id = ? AND sde.facility_id || '-' || sde.doc_type_code || '-' || sde.doc_no IN (SELECT facility_id || '-' || doc_type_code || '-' || doc_no FROM ST_SAL_HDR WHERE patient_id = ? AND NVL (encounter_id, 0) LIKE NVL (?, '0') AND finalized_yn = 'Y') AND mmi.item_code = sde.item_code AND sde.item_code = sti.item_code AND sde.item_code = ? AND sde.store_code = ? AND mmb.bin_location_code = sde.bin_location_code AND mmb.store_code = sde.store_code AND (    sde.facility_id = ssd.facility_id AND sde.doc_type_code = ssd.doc_type_code AND sde.doc_no = ssd.doc_no AND sde.doc_srl_no = ssd.doc_srl_no) AND sdh.sal_trn_type = ? AND ssd.stock_item_yn = 'Y' AND (    sdh.facility_id = ssd.facility_id AND sdh.doc_type_code = ssd.doc_type_code AND sdh.doc_no = ssd.doc_no) AND mmi.language_id = mmb.language_id AND mmi.language_id = ? AND sde.doc_type_code = ? AND sde.doc_no = ? AND sde.batch_id = srexp.batch_id(+) AND sde.trade_id = srexp.trade_id(+) 	 AND sde.doc_no = srexp.sal_doc_no(+) AND sde.doc_type_code = srexp.sal_doc_type_code(+) AND  TRUNC(sde.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC(srexp.EXPIRY_DATE_OR_RECEIPT_DATE(+)) GROUP BY sde.item_code, mmi.short_desc, sde.batch_id, sde.bin_location_code, sde.bin_location_code, mmb.short_desc,sde.expiry_date_or_receipt_date,sde.trade_id,sde.sal_item_qty,sti.trade_id_applicable_yn,mmi.language_id, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code ) ,sde.doc_type_code, sde.doc_no ,sde.doc_srl_no,sdh.doc_date, sdh.added_date,srexp.bin_location_code,sde.store_code,sde.ret_item_qty ORDER BY sdh.added_date";
			//Added barcode_id for GHL-CRF-0413.5
			setDoc_no(sales_doc_no); // Added for GHL-ICN-0034
			String stSQL="SELECT   sde.item_code, mmi.short_desc item_desc, sde.batch_id, sde.bin_location_code bin_location_code,sde.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, TO_CHAR (sde.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_receipt_dt, sde.trade_id, DECODE(sti.trade_id_applicable_yn, 'Y', (SELECT short_name FROM am_trade_name_lang_vw  am_trade_name WHERE trade_id = sde.trade_id AND mmi.language_id = am_trade_name.language_id), sde.trade_id) trade_name, sde.sal_item_qty, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )avail_qty, sde.doc_type_code sal_doc_type_code, sde.doc_no sal_doc_no, sde.doc_srl_no sal_doc_srl_no, TO_CHAR (sdh.doc_date, 'dd/mm/yyyy') sal_doc_date, srexp.bin_location_code ret_bin_locn,sde.barcode_id  FROM ST_SAL_DTL_EXP sde, mm_item_lang_vw mmi, ST_ITEM sti, ST_SAL_HDR sdh,  ST_SAL_DTL ssd, mm_bin_location_lang_vw mmb, ST_SAL_RET_DTL_EXP srexp WHERE (sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )) > 0 AND sde.facility_id = ? AND sde.facility_id || '-' || sde.doc_type_code || '-' || sde.doc_no IN (SELECT facility_id || '-' || doc_type_code || '-' || doc_no FROM ST_SAL_HDR WHERE patient_id = ? AND NVL (encounter_id, 0) LIKE NVL (?, '0') AND finalized_yn = 'Y') AND mmi.item_code = sde.item_code AND sde.item_code = sti.item_code AND sde.item_code = ? AND sde.store_code = ? AND mmb.bin_location_code = sde.bin_location_code AND mmb.store_code = sde.store_code AND (    sde.facility_id = ssd.facility_id AND sde.doc_type_code = ssd.doc_type_code AND sde.doc_no = ssd.doc_no AND sde.doc_srl_no = ssd.doc_srl_no) AND sdh.sal_trn_type = ? AND ssd.stock_item_yn = 'Y' AND (    sdh.facility_id = ssd.facility_id AND sdh.doc_type_code = ssd.doc_type_code AND sdh.doc_no = ssd.doc_no) AND mmi.language_id = mmb.language_id AND mmi.language_id = ? AND sde.doc_type_code = ? AND sde.doc_no = ? AND sde.batch_id = srexp.batch_id(+) AND sde.trade_id = srexp.trade_id(+) 	 AND sde.doc_no = srexp.sal_doc_no(+) AND sde.doc_type_code = srexp.sal_doc_type_code(+) AND  TRUNC(sde.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC(srexp.EXPIRY_DATE_OR_RECEIPT_DATE(+)) GROUP BY sde.item_code, mmi.short_desc, sde.batch_id, sde.bin_location_code, sde.bin_location_code, mmb.short_desc,sde.expiry_date_or_receipt_date,sde.trade_id,sde.sal_item_qty,sti.trade_id_applicable_yn,mmi.language_id, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code ) ,sde.doc_type_code, sde.doc_no ,sde.doc_srl_no,sdh.doc_date, sdh.added_date,srexp.bin_location_code,sde.store_code,sde.ret_item_qty,sde.barcode_id ORDER BY sdh.added_date";//removed challan_no for GHL-CRF-0499
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 
			for(int i=0;i<listRecord.size();i++){
			HashMap dataList		=		(HashMap)listRecord.get(i);
			if(getAllowDecimalsYN((String)dataList.get("ITEM_CODE")).equals("Y")){
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
			dataList.put("SAL_ITEM_QTY",setNumber((String)dataList.get("SAL_ITEM_QTY"),no_of_decimals));
			}else{
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
			dataList.put("SAL_ITEM_QTY",setNumber((String)dataList.get("SAL_ITEM_QTY"),0));
			//dataList.put("CHALLAN_NO", (String)dataList.get("CHALLAN_NO"));//Added against ghl-crf-0499
			}
			listRecord.set(i,dataList);
			}
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 

			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}


	public ArrayList getDataList(){
		return DataList ;
	}

	public String getTotalAvailableQty(){

		long lQty	=	0;
		for (int i=0; i<DataList.size(); i++) {
			lQty	=lQty+Long.parseLong((String)((HashMap)DataList.get(i)).get("AVAIL_QTY"));
		}
		return ""+lQty;
	}


	public void selectedBatches(String index,String noOfCheckedRecords)
	{
		selectedList=new ArrayList();
		int i=0;
		if(noOfCheckedRecords.equals("1"))
		{
				selectedList.add((HashMap)DataList.get(Integer.parseInt(index)));
		}
		else
		{
			StringTokenizer st=new StringTokenizer (index,"!");
			while(st.hasMoreTokens())
			{
				i=Integer.parseInt(st.nextToken());
				selectedList.add((HashMap)DataList.get(i));
			}
		}
	}

   public ArrayList getSelectedList(){
		return selectedList ;
	}
	public void clear(){
		//super.clear();
		//DataList=new ArrayList();
		selectedList=new ArrayList();
	}
	//added for GHL-CRF-0499 START
		public String getChallanNo(String item_code,String batch_id,String expiry_date,String storeCode){
	Connection connection			 =		null ;
	PreparedStatement pstmt	 =		null ;
	ResultSet resultSet				 =		null ;
	HashMap hmChallan			  = new HashMap();
	ArrayList alParameters	=	new ArrayList();
	String challan_no =	"";
	/*String challNo="";
	String batchid= "";*///commented for 15757
	String consignment_yn = getConsignment_yn(item_code); 
	//setting challan_no to null when item is not a consignment item
	if(consignment_yn.equalsIgnoreCase("N")){
		challan_no="";
		return challan_no;
	}
	//String vmi_batch_id=""; //added for GHL-ICN-0030//commented for 15757  
	try {		
		/*if(batch_id.contains("-")){ // commented for GHL-ICN-0034 - Start
		//added for GHL-ICN-0030 START
		
		//	String[] arrOfStr = batch_id.split("-", 2);
		//	batchid = arrOfStr[0];
		//	challNo =arrOfStr[1];
		connection=getConnection();
				pstmt		= connection.prepareStatement("select VMI_BATCH_ID from st_item_batch where item_code=? and batch_id=? and EXPIRY_DATE_OR_RECEIPT_DATE=TO_DATE(?,'DD/MM/YYYY') and store_code= ? ");
				pstmt.setString(1,item_code);
				pstmt.setString(2,batch_id);
				pstmt.setString(3,expiry_date);
				pstmt.setString(4,storeCode);
				
				
				resultSet	= pstmt.executeQuery() ;
				
				
				
				if(resultSet.next())
					vmi_batch_id=resultSet.getString("VMI_BATCH_ID");
				
				int batch_id_length=vmi_batch_id.length();
				if(batch_id_length>10)
					batch_id_length=10;
				batchid=batch_id.substring(0,batch_id_length);
				challNo=batch_id.substring(batch_id_length+2,batch_id.length());
			 
		}
		else{
			batchid=batch_id;
		}
		challNo = '%'+challNo+'%';*/ //commented for GHL-ICN-0034 - End
		alParameters.add(getDoc_no());//ADDED for GHL-ICN-0034
		alParameters.add(item_code);
		alParameters.add(batch_id); //Modified for GHL-ICN-0034
		alParameters.add(expiry_date);
		alParameters.add(storeCode); //Modified for GHL-ICN-0034
		hmChallan = fetchRecord("SELECT CHALLAN_NO FROM ST_SAL_DTL_EXP WHERE DOC_NO= ? AND  ITEM_CODE= ? AND BATCH_ID= ? AND TRUNC(EXPIRY_DATE_OR_RECEIPT_DATE) = TO_DATE (?,'DD/MM/YYYY') AND STORE_CODE= ? ",alParameters);//modified for GHL-ICN-0034
		challan_no = (String)hmChallan.get("CHALLAN_NO");
	}
	catch ( Exception e ) {
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
	return challan_no;
}

		public String getConsignment_yn(String item_code){
			String consignment_yn		  = "";	
			HashMap consignmentMap			  = new HashMap();
			try{
				consignmentMap = fetchRecord("SELECT CONSIGNMENT_ITEM_YN FROM ST_ITEM WHERE ITEM_CODE = ?",item_code);
			}catch(Exception e){
				consignment_yn = "";
			}
			if(consignmentMap.size() > 0)
				consignment_yn = (String)consignmentMap.get("CONSIGNMENT_ITEM_YN");
			return consignment_yn;
		}
		//added for GHL-CRF-0499 END
}
