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


// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class BatchSearchReplaceGRNBean extends StTransaction implements Serializable {

	private ArrayList DataList=new ArrayList();
	private ArrayList selectedList;

	private String item_code="";
	private String po_no="";
 //   private String language;
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

	public void setStore_code(String store_code) {
		 this.store_code = checkForNull(store_code);
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setSupp_code(String supp_code) {
		 this.supp_code = checkForNull(supp_code);
	}

/*	public void setLanguageId(String language) {
			this.language = language;

		}
	public String getLanguageId() {
			return this.language;
		}
	*/
	public String getDoc_type_code_ListGRN(){
        ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add("RTV");
		arraylist.add( getLanguageId());
        ArrayList alDocTypeListOption=getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST_HDR"), arraylist);
		return getListOptionTag(alDocTypeListOption, "");
	}

	public void loadResultPage() throws Exception {
	
		ArrayList alParameters=new ArrayList();
		alParameters.add(item_code);
		alParameters.add(getGrn_doc_type_code().equals("")?"%":getGrn_doc_type_code());
		alParameters.add(getGrn_doc_no().equals("")?"%":getGrn_doc_no());
		alParameters.add(supp_code);
        alParameters.add(getLoginFacilityId());
        
				
		ArrayList listRecord =new ArrayList();
		try {
			//String stSQL=getStRepositoryValue("SQL_ST_REPLACE_GRN_BATCH_SEARCH");
			/*
			Condition (AND grndtl.item_code = rtvexp.item_code) had been added in the query to fix the duplication of records in RTV Ref Pop up(IN17168)
			*/
			String stSQL= "SELECT distinct rtvdtl.item_code, rtvhdr.store_code, rtvdtl.doc_type_code,        rtvdtl.doc_no, rtvdtl.doc_srl_no, rtvdtl.rtv_repl_qty, rtvdtl.pend_repl_qty, rtvdtl.item_qty_normal,        rtvdtl.rtv_unit_cost, rtvhdr.rtv_for_replacement_yn, mm.short_desc item_desc, sts.short_desc store_desc, am.short_desc pur_uom_desc FROM st_rtv_hdr rtvhdr, st_rtv_dtl rtvdtl, mm_item mm, mm_store sts, st_rtv_dtl_exp rtvexp, st_grn_dtl grndtl, am_uom am WHERE rtvdtl.item_code = (?) AND rtvdtl.doc_type_code LIKE (?) AND rtvdtl.doc_no LIKE (?) AND rtvhdr.supp_code LIKE (?) AND rtvdtl.facility_id = ? AND rtvhdr.rtv_for_replacement_yn = 'Y' AND rtvdtl.doc_no = rtvhdr.doc_no AND rtvdtl.doc_type_code = rtvhdr.doc_type_code AND rtvdtl.item_code = mm.item_code AND rtvhdr.store_code = sts.store_code AND rtvdtl.repl_completed_yn != 'Y' AND rtvdtl.pend_repl_qty > 0 AND finalized_yn = 'Y' AND rtvdtl.facility_id = rtvexp.FACILITY_ID AND rtvdtl.DOC_NO = rtvexp.DOC_NO AND rtvdtl.DOC_type_code = rtvexp.DOC_type_code AND grndtl.doc_no = rtvexp.GRN_DOC_NO    AND grndtl.doc_type_code = rtvexp.GRN_DOC_type_code AND grndtl.item_code =  rtvdtl.item_code AND am.uom_code = grndtl.PUR_UOM_CODE";
			listRecord = fetchRecords(stSQL.toString(),alParameters);
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
}
