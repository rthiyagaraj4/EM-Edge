/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/07/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
---------------------------------------------------------------------------------------------------------
*/


 package eST;   

//import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;


// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class BatchSearchGoodsReturnToVendorBean extends StTransaction implements Serializable {

	private ArrayList DataList=new ArrayList();
	private ArrayList selectedList;

	private String item_code="";
	private String po_no="";
	//private String language_id;

	private String store_code="";
	private String supp_code="";

	private String grn_doc_type_code="";
	private String grn_doc_no="";

	private String searchFunction="N";
	private String multipleSelect="N";
	private String maxAllowed="1";
	//private boolean search=true;
	private boolean bSortDesc =false;

	
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

	public void setGrn_doc_type_code(String grn_doc_type_code) {
		 this.grn_doc_type_code = checkForNull(grn_doc_type_code);
	}

	public String getGrn_doc_type_code( ) {
		 return grn_doc_type_code;
	}

	public void setGrn_doc_no(String grn_doc_no) {
		 this.grn_doc_no = checkForNull(grn_doc_no);
	}

	public String getGrn_doc_no( ) {
		 return grn_doc_no;
	}

	public void setItem_code(String item_code) {
		 this.item_code = checkForNull(item_code);
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setPo_no(String po_no) {
		 this.po_no = checkForNull(po_no);
	}

	public String getPo_no( ) {
		 return po_no;
	}
	/*public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id);
	}

	public String getLanguageId( ) {
		 return language_id;
	} */
	public void setStore_code(String store_code) {
		 this.store_code = checkForNull(store_code);
	}

	public String getStore_code( ) {
		 return store_code;
	}

	
	public String getExpYN() throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String expiry_yn		  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(getStRepositoryValue("SQL_ST_EXPYN_SELECT"));
			pstmt.setString(1,getItem_code());
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



	public void setSupp_code(String supp_code) {
		 this.supp_code = checkForNull(supp_code);
	}
	
	public String getDoc_type_code_ListGRN(){
        ArrayList arraylist = new ArrayList();
		String sql="";
		if(getCustomerID().equals("MC")){
        arraylist.add(getLoginFacilityId());
		sql="SELECT   distinct EXT_DOC_TYPE_CODE, EXT_DOC_TYPE_CODE short_desc FROM st_grn_hdr WHERE facility_id = ? and EXT_DOC_TYPE_CODE is not null ORDER BY 2, 1";
		}else{
		arraylist.add(getLoginFacilityId());
        arraylist.add("GRN");
        arraylist.add(getLanguageId());
		sql=getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST_HDR");
		}
        ArrayList alDocTypeListOption=getListOptionArrayList(sql, arraylist);
		return getListOptionTag(alDocTypeListOption, "");
	}

	public void loadResultPage(String doc_type_code,String doc_no,String trn_type) throws Exception {
	
		ArrayList alParameters=new ArrayList();

		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
		//add parameters for CHALLAN NO
		
		/*ADDED FOR GHL-CRF-0499*/
		/*if(getCustomerID().equals("MC")){
			alParameters.add(item_code);
			 alParameters.add(store_code);
		}*/
		/*ADDED FOR GHL-CRF-0499*/
		
        alParameters.add(getLoginFacilityId());
        alParameters.add(getGrn_doc_type_code().equals("")?"%":getGrn_doc_type_code());
        alParameters.add(getGrn_doc_no().equals("")?"%":getGrn_doc_no());
        alParameters.add(getPo_no().equals("")?"%":getPo_no());
		alParameters.add(supp_code);
        alParameters.add(store_code);
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
        alParameters.add(item_code);
        alParameters.add(getLanguageId());
        alParameters.add(getLanguageId());
        alParameters.add(getLanguageId());
        alParameters.add(getLanguageId());
        alParameters.add(getLanguageId());
      
	ArrayList listRecord =new ArrayList();
		String stSQL="";
		try {
			
			if(getCustomerID().equals("MC")){
			stSQL="SELECT grnexp.item_code, sbv.item_desc, grnexp.batch_id, grnexp.bin_location_code prev_bin_location_code,sbv.expiry_yn expiry_yn,TO_CHAR(sbv.expiry_date,'dd/mm/yyyy') expiry_date, sbv.bin_location_code bin_location_code,  mmb.short_desc bin_location_desc, TO_CHAR(grnexp.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, grnexp.trade_id, sbv.trade_name, grnexp.grn_item_qty, NVL(grnexp.rtv_item_qty,0) rtv_item_qty, grnexp.grn_item_qty-NVL(grnexp.rtv_item_qty,0) ret_qty,grndtl.pur_uom_conv, grndtl.pur_uom_code PUR_UOM_CODE, LEAST(sbv.avail_qty/grndtl.pur_uom_conv,grnexp.grn_item_qty-NVL(grnexp.rtv_item_qty,0)) +ST_COMM_QTY_FOR_DOCNO (?,?,?,?,grnhdr.store_code, sbv.bin_location_code, grnexp.batch_id, grnexp.expiry_date_or_receipt_date,grnexp.item_code,grnhdr.doc_no)avail_qty, grnexp.doc_type_code grn_doc_type_code, grnexp.doc_no grn_doc_no, grndtl.grn_unit_cost_in_pur_uom,grnhdr.po_no, grnexp.doc_srl_no grn_doc_srl_no, TO_CHAR(grnhdr.doc_date,'dd/mm/yyyy') grn_doc_date, a.short_desc,EXT_DOC_TYPE_CODE,EXt_doc_no FROM st_grn_dtl_exp grnexp, st_grn_hdr grnhdr, st_grn_dtl grndtl, st_batch_search_lang_view sbv, mm_bin_location_lang_vw mmb, am_uom a WHERE grnexp.facility_id = ? AND   nvl(grnhdr.EXT_DOC_TYPE_CODE,'X') LIKE ? AND grnexp.doc_type_code =grnhdr.DOC_TYPE_CODE  AND nvl(grnhdr.EXt_doc_no,1) LIKE ?  AND grnexp.doc_no =grnhdr.doc_no  AND NVL(grnhdr.po_no,-1) LIKE ? AND grnhdr.supp_code LIKE ?  AND (grnexp.facility_id = grnhdr.facility_id AND grnexp.doc_type_code = grnhdr.doc_type_code AND grnexp.doc_no = grnhdr.doc_no) AND (grndtl.facility_id = grndtl.facility_id AND grndtl.doc_type_code = grnhdr.doc_type_code AND grndtl.doc_no = grnhdr.doc_no AND grndtl.doc_srl_no = grnexp.doc_srl_no) AND grnhdr.finalized_yn='Y' AND grnhdr.store_code= ? AND (grnexp.grn_item_qty-grnexp.rtv_item_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,grnhdr.store_code, sbv.bin_location_code, grnexp.batch_id, grnexp.expiry_date_or_receipt_date,grnexp.item_code, grnhdr.doc_no)) > 0 AND (grnhdr.store_code=sbv.store_code AND grnexp.item_code=sbv.item_code AND grnexp.batch_id=sbv.batch_id  /*AND grnexp.bin_location_code=sbv.bin_location_code  */AND grnexp.expiry_date_or_receipt_date=sbv.expiry_date ) AND (grnhdr.store_code=mmb.store_code AND sbv.bin_location_code=mmb.bin_location_code) AND grnexp.item_code= ? AND sbv.language_id = mmb.language_id AND sbv.language_id = ? AND DECODE(sbv.lang1,NULL,?,sbv.lang1) = ? AND DECODE(sbv.lang2,NULL,?,sbv.lang2) = ? and a.uom_code = grndtl.pur_uom_code ORDER BY grnhdr.added_date";//added parameter in function (grn.doc.no)-GHL-SCF-1243, removed challan_no for ghl-crf-0499 

			}else{
			//String stSQL=getStRepositoryValue("SQL_ST_RTV_BATCH_SEARCH_QUERY");
			 stSQL="SELECT grnexp.item_code, sbv.item_desc, grnexp.batch_id, grnexp.bin_location_code prev_bin_location_code,sbv.expiry_yn expiry_yn,TO_CHAR(sbv.expiry_date,'dd/mm/yyyy') expiry_date, sbv.bin_location_code bin_location_code,  mmb.short_desc bin_location_desc, TO_CHAR(grnexp.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, grnexp.trade_id, sbv.trade_name, grnexp.grn_item_qty, NVL(grnexp.rtv_item_qty,0) rtv_item_qty, grnexp.grn_item_qty-NVL(grnexp.rtv_item_qty,0) ret_qty,grndtl.pur_uom_conv, grndtl.pur_uom_code PUR_UOM_CODE, LEAST(sbv.avail_qty/grndtl.pur_uom_conv,grnexp.grn_item_qty-NVL(grnexp.rtv_item_qty,0)) + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,grnhdr.store_code, sbv.bin_location_code, grnexp.batch_id, grnexp.expiry_date_or_receipt_date,grnexp.item_code,grnhdr.doc_no) avail_qty, grnexp.doc_type_code grn_doc_type_code, grnexp.doc_no grn_doc_no, grndtl.grn_unit_cost_in_pur_uom,grnhdr.po_no, grnexp.doc_srl_no grn_doc_srl_no, TO_CHAR(grnhdr.doc_date,'dd/mm/yyyy') grn_doc_date, a.short_desc,EXT_DOC_TYPE_CODE,EXt_doc_no FROM st_grn_dtl_exp grnexp, st_grn_hdr grnhdr, st_grn_dtl grndtl, st_batch_search_lang_view sbv, mm_bin_location_lang_vw mmb, am_uom a WHERE grnexp.facility_id = ? AND grnexp.doc_type_code LIKE ? AND grnexp.doc_no LIKE ? AND NVL(grnhdr.po_no,-1) LIKE ? AND grnhdr.supp_code LIKE ?  AND (grnexp.facility_id = grnhdr.facility_id AND grnexp.doc_type_code = grnhdr.doc_type_code AND grnexp.doc_no = grnhdr.doc_no) AND (grndtl.facility_id = grndtl.facility_id AND grndtl.doc_type_code = grnhdr.doc_type_code AND grndtl.doc_no = grnhdr.doc_no AND grndtl.doc_srl_no = grnexp.doc_srl_no) AND grnhdr.finalized_yn='Y' AND grnhdr.store_code= ? AND (grnexp.grn_item_qty-grnexp.rtv_item_qty + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,grnhdr.store_code, sbv.bin_location_code, grnexp.batch_id, grnexp.expiry_date_or_receipt_date,grnexp.item_code,grnhdr.doc_no)) > 0 AND (grnhdr.store_code=sbv.store_code AND grnexp.item_code=sbv.item_code AND grnexp.batch_id=sbv.batch_id  /*AND grnexp.bin_location_code=sbv.bin_location_code  */AND grnexp.expiry_date_or_receipt_date=sbv.expiry_date ) AND (grnhdr.store_code=mmb.store_code AND sbv.bin_location_code=mmb.bin_location_code) AND grnexp.item_code= ? AND sbv.language_id = mmb.language_id AND sbv.language_id = ? AND DECODE(sbv.lang1,NULL,?,sbv.lang1) = ? AND DECODE(sbv.lang2,NULL,?,sbv.lang2) = ? and a.uom_code = grndtl.pur_uom_code ORDER BY grnhdr.added_date";//added parameter in function (grn.doc.no)-GHL-SCF-1243
			}
			/*
			System.out.println("CustomerID...in bean..."+getCustomerID());
			System.out.println("stSQL...in bean..."+stSQL);
			System.out.println("alParameters@@===>..in bean..."+alParameters);
			*/

			listRecord = fetchRecords(stSQL.toString(),alParameters);
			//System.out.println("listRecord===>..in bean..."+listRecord);
			

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
			lQty	= lQty +	Long.parseLong((String)((HashMap)DataList.get(i)).get("AVAIL_QTY"));
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
 //added for GHL-CRF-0499 START 
   //modified for GHL-ICN-0032
	public String getChallanNo(String item_code,String batch_id,String expiry_date, String storeCode){
	Connection connection			 =		null ;
	PreparedStatement pstmt	 =		null ;
	ResultSet resultSet				 =		null ;
	HashMap hmChallan			  = new HashMap();
	ArrayList alParameters	=	new ArrayList();
	String challan_no =	"";
	String challNo="";
	String batchid= "";
	String consignment_yn = getConsignment_yn(item_code); 
	//setting challan_no to null when item is not a consignment item
	if(consignment_yn.equalsIgnoreCase("N")){
		challan_no="";
		return challan_no;
	} 
	//ADDED FOR GHL-ICN-0030 START
	
	String vmi_batch_id="";
	try {		
		if(batch_id.contains("-")){
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
				//ADDED FOR GHL-ICN-0030 END
			//System.out.println("batch id :"+batchid); 
		}
		else{
			batchid=batch_id;
		}
		challNo = '%'+challNo+'%';
		alParameters.add(item_code);
		alParameters.add(vmi_batch_id); //ADDED FOR GHL-ICN-0030 
		alParameters.add(expiry_date);
		alParameters.add(challNo);
		hmChallan = fetchRecord("SELECT CHALLAN_NO FROM XI_TRN_GRN WHERE ITEM_CODE= ? AND BATCH_ID= ? AND TRUNC(EXPIRY_DATE) = TO_DATE (?,'DD/MM/YYYY') AND CHALLAN_NO LIKE ?  ",alParameters);
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
