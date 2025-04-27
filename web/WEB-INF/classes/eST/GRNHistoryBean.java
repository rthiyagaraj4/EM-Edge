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
08/09/2017				IN064726				Soorya Prakash M	                                    	ML-MMOH-SCF-0767
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
import eST.Common.StRepository;
//import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class GRNHistoryBean extends StAdapter implements Serializable{

	private String item_code="";
	private String supp_code="";
	private String fm_doc_date="";
	private String to_doc_date="";
	private String finalized_yn="";
	private String store_code="";
	private String replace_on_expiry_yn="";
	private String po_no="";
	private String doc_no = "";
	private String ext_doc_no = "";
	//private String language;
	private ArrayList DataList=new ArrayList();

	int no_Of_Decimals_For_Cost=Integer.parseInt(getNoOfDecimalsCost());//Added for SCF-0767

	public String getSupplierList()
		{
		return getListOptionTag(getListOptionArrayList(StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LIST_WT_LANG"),getLanguageId()));
		}
	public String getStore_code_List()
		{

			String chkParameters[] ={getLoginFacilityId(),getLanguageId()};
			return getListOptionTag(getListOptionArrayList(StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST_WT_LANG"),chkParameters));
		}
	
	/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}	*/
		
	public void setItem_code(String item_code) 
		{
		 this.item_code = checkForNull(item_code);
		}
	public String getItem_code( ) 
		{
		 return item_code;
		}
	public void setSupp_code(String supp_code) 
		{
		 this.supp_code = checkForNull(supp_code);
		}
	public String getSupp_code( ) 
		{
		 return supp_code;
		}
	public void setFm_doc_date(String fm_doc_date) 
		{
		 this.fm_doc_date = checkForNull(fm_doc_date);
		}
	public String getFm_doc_date( ) 
		{
		 return fm_doc_date;
		}
	public void setTo_doc_date(String to_doc_date) 
		{
		 this.to_doc_date = checkForNull(to_doc_date);
		}
	public String getTo_doc_date( ) 
		{
		 return to_doc_date;
		}
	public void setFinalized_yn(String finalized_yn) 
		{
		 this.finalized_yn = checkForNull(finalized_yn);
		}
	public String getFinalized_yn( ) 
		{
		 return finalized_yn;
		}
	public void setStore_code(String store_code) 
		{
		 this.store_code = checkForNull(store_code);
		}
	public String getStore_code( ) 
		{
		 return store_code;
		}
	public void setReplace_on_expiry_yn(String replace_on_expiry_yn) 
		{
		 this.replace_on_expiry_yn = checkForNull(replace_on_expiry_yn);
		}
	public String getReplace_on_expiry_yn( ) 
		{
		 return replace_on_expiry_yn;
		}
	public void setPo_no(String po_no) 
		{
		 this.po_no = checkForNull(po_no);
		}
	public String getPo_no( ) 
		{
		 return po_no;
		}
		
		//27/10/11
		public void setDoc_no(String doc_no) 
		{
		 this.doc_no = checkForNull(doc_no);
		}
	public String getDoc_no() 
		{
		 return doc_no;
		} 
		public void setExt_doc_no(String ext_doc_no) 
		{
		 this.ext_doc_no = checkForNull(ext_doc_no);
		}
	public String getExt_doc_no() 
		{
		 return ext_doc_no;
		}
	public ArrayList getDataList()
		{
		 return DataList ;
		}

	public void loadResultPage() throws Exception {
	 
		ArrayList alParameters=new ArrayList();
		//String stSQL = "SELECT  b.item_code, (select f.short_desc from mm_item_lang_vw f where f.item_code = b.item_code and f.language_id = d.language_id) short_desc,b.PUR_UOM_CODE,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = b.pur_uom_code AND language_id = ?) pur_uom_desc,TO_CHAR (a.doc_date, 'DD/MM/RRRR') doc_date, a.po_no,a.doc_no, a.doc_type_code, a.supp_code, b.item_qty_normal, b.item_qty_sample, b.item_qty_bonus,ROUND (b.grn_unit_cost_in_pur_uom, 3) grn_unit_cost_in_pur_uom,ROUND(b.item_qty_bonus + b.item_qty_normal * grn_unit_cost_in_pur_uom,3) grn_val,DECODE (b.replace_on_expiry_yn,       'N', 'No','Y', 'Yes') replace_on_expiry_yn,a.store_code, d.short_name supp_name, e.short_desc store_desc,TO_CHAR (expiry_date_or_receipt_date,'dd/mm/rrrr') expiry_date_or_receipt_date, c.batch_id, a.finalized_yn, (rtv_item_qty_normal + rtv_item_qty_bonus) rtv_dtl , (SELECT COUNT(*) FROM st_repl_grn_rtv_dtl where doc_type_code = a.doc_type_code and doc_no = b.doc_no) grn_rtv_cnt,A.EXT_DOC_NO,A.EXT_DOC_TYPE_CODE,c.grn_item_qty,(c.sale_price*b.pur_uom_conv) sale_price,(c.grn_item_qty*c.sale_price*b.pur_uom_conv) sale_value  FROM st_grn_hdr a,st_grn_dtl b,st_grn_dtl_exp c,ap_supplier_lang_vw d,mm_store_lang_vw e  WHERE  a.facility_id = b.facility_id      AND b.facility_id = c.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_type_code = c.doc_type_code AND a.doc_no = b.doc_no AND a.doc_no = c.doc_no AND a.store_code = c.store_code AND b.item_code = c.item_code AND b.doc_srl_no = c.doc_srl_no AND d.supp_code = a.supp_code AND a.store_code = e.store_code ";

		//String stSQL = "SELECT  b.item_code, (select f.short_desc from mm_item_lang_vw f where f.item_code = b.item_code and f.language_id = d.language_id) short_desc,b.PUR_UOM_CODE,b.pur_uom_conv,g.DEF_ISSUE_UOM,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = b.pur_uom_code AND language_id = ?) pur_uom_desc,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = g.DEF_ISSUE_UOM AND language_id = ?) stk_uom_desc,TO_CHAR (a.doc_date, 'DD/MM/RRRR') doc_date, a.po_no,a.doc_no, a.doc_type_code, a.supp_code, b.item_qty_normal, b.item_qty_sample, b.item_qty_bonus,(b.item_qty_normal*b.pur_uom_conv) item_qty_normal_pur_uom,(b.item_qty_sample*b.pur_uom_conv) item_qty_sample_pur_uom,(b.item_qty_bonus*b.pur_uom_conv) item_qty_bonus_pur_uom,ROUND (b.grn_unit_cost_in_pur_uom, 3) grn_unit_cost_in_pur_uom,ROUND(b.item_qty_bonus + b.item_qty_normal * grn_unit_cost_in_pur_uom,3) grn_val_pur_uom,ROUND (b.grn_unit_cost_in_stk_uom, 3) grn_unit_cost_in_stk_uom,ROUND( (b.item_qty_bonus + b.item_qty_normal)* grn_unit_cost_in_stk_uom,3) grn_val_stk_uom,DECODE (b.replace_on_expiry_yn,       'N', 'No','Y', 'Yes') replace_on_expiry_yn,a.store_code, d.short_name supp_name, e.short_desc store_desc,TO_CHAR (expiry_date_or_receipt_date,'dd/mm/rrrr') expiry_date_or_receipt_date, c.batch_id, a.finalized_yn, (rtv_item_qty_normal + rtv_item_qty_bonus) rtv_dtl , (SELECT COUNT(*) FROM st_repl_grn_rtv_dtl where doc_type_code = a.doc_type_code and doc_no = b.doc_no) grn_rtv_cnt,A.EXT_DOC_NO,A.EXT_DOC_TYPE_CODE,c.grn_item_qty,(c.sale_price*b.pur_uom_conv) sale_price,(c.grn_item_qty*c.sale_price*b.pur_uom_conv) sale_value,(c.grn_item_qty*b.pur_uom_conv)grn_item_qty_pur_uom  FROM st_grn_hdr a,st_grn_dtl b,st_grn_dtl_exp c,ap_supplier_lang_vw d,mm_store_lang_vw e,st_item_store g WHERE  a.facility_id = b.facility_id      AND b.facility_id = c.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_type_code = c.doc_type_code AND a.doc_no = b.doc_no AND a.doc_no = c.doc_no AND a.store_code = c.store_code AND b.item_code = c.item_code AND b.doc_srl_no = c.doc_srl_no AND d.supp_code = a.supp_code AND a.store_code = e.store_code ";
		
		//Modified by Sakti against inc#49354 removed pur_uom_conv multiplication with sale_price
		//String stSQL = "SELECT  b.item_code, (select f.short_desc from mm_item_lang_vw f where f.item_code = b.item_code and f.language_id = d.language_id) short_desc,b.PUR_UOM_CODE,b.pur_uom_conv,g.DEF_ISSUE_UOM,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = b.pur_uom_code AND language_id = ?) pur_uom_desc,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = g.DEF_ISSUE_UOM AND language_id = ?) stk_uom_desc,TO_CHAR (a.doc_date, 'DD/MM/RRRR') doc_date, a.po_no,a.doc_no, a.doc_type_code, a.supp_code, b.item_qty_normal, b.item_qty_sample, b.item_qty_bonus,(b.item_qty_normal*b.pur_uom_conv) item_qty_normal_pur_uom,(b.item_qty_sample*b.pur_uom_conv) item_qty_sample_pur_uom,(b.item_qty_bonus*b.pur_uom_conv) item_qty_bonus_pur_uom,ROUND (b.grn_unit_cost_in_pur_uom, 3) grn_unit_cost_in_pur_uom,ROUND(b.item_qty_bonus + b.item_qty_normal * grn_unit_cost_in_pur_uom,3) grn_val_pur_uom,ROUND (b.grn_unit_cost_in_stk_uom, 3) grn_unit_cost_in_stk_uom,ROUND( (b.item_qty_bonus + b.item_qty_normal)* b.pur_uom_conv * grn_unit_cost_in_stk_uom,3) grn_val_stk_uom,DECODE (b.replace_on_expiry_yn,       'N', 'No','Y', 'Yes') replace_on_expiry_yn,a.store_code, d.short_name supp_name, e.short_desc store_desc,TO_CHAR (expiry_date_or_receipt_date,'dd/mm/rrrr') expiry_date_or_receipt_date, c.batch_id, a.finalized_yn, (rtv_item_qty_normal + rtv_item_qty_bonus) rtv_dtl , (SELECT COUNT(*) FROM st_repl_grn_rtv_dtl where doc_type_code = a.doc_type_code and doc_no = b.doc_no) grn_rtv_cnt,A.EXT_DOC_NO,A.EXT_DOC_TYPE_CODE,c.grn_item_qty,c.sale_price,(c.grn_item_qty*c.sale_price*b.pur_uom_conv) sale_value,(c.grn_item_qty*b.pur_uom_conv)grn_item_qty_pur_uom  FROM st_grn_hdr a,st_grn_dtl b,st_grn_dtl_exp c,ap_supplier_lang_vw d,mm_store_lang_vw e,st_item_store g WHERE  a.facility_id = b.facility_id      AND b.facility_id = c.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_type_code = c.doc_type_code AND a.doc_no = b.doc_no AND a.doc_no = c.doc_no AND a.store_code = c.store_code AND b.item_code = c.item_code AND b.doc_srl_no = c.doc_srl_no AND d.supp_code = a.supp_code AND a.store_code = e.store_code ";
		//Modified by suresh.r on 06-08-2014 against MMS-SCF-0387 changed derivation of grn_unit_cost_in_stk_uom,grn_val_stk_uom
		//Added for SCF-0767 In the existing query only the round off function value(3) is changed in to parameter (no_Of_Decimals_For_Cost)  where we are getting the decimal value from ST_ACC_ENTITY_PARAM
		String stSQL = "SELECT  b.item_code, (select f.short_desc from mm_item_lang_vw f where f.item_code = b.item_code and f.language_id = d.language_id) short_desc,b.PUR_UOM_CODE,b.pur_uom_conv,g.DEF_ISSUE_UOM,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = b.pur_uom_code AND language_id = ?) pur_uom_desc,(SELECT short_desc FROM am_uom_lang_vw  WHERE uom_code = g.DEF_ISSUE_UOM AND language_id = ?) stk_uom_desc,TO_CHAR (a.doc_date, 'DD/MM/RRRR') doc_date, a.po_no,a.doc_no, a.doc_type_code, a.supp_code, b.item_qty_normal, b.item_qty_sample, b.item_qty_bonus,(b.item_qty_normal*b.pur_uom_conv) item_qty_normal_pur_uom,(b.item_qty_sample*b.pur_uom_conv) item_qty_sample_pur_uom,(b.item_qty_bonus*b.pur_uom_conv) item_qty_bonus_pur_uom,ROUND (b.grn_unit_cost_in_pur_uom, "+no_Of_Decimals_For_Cost+") grn_unit_cost_in_pur_uom,ROUND(b.item_qty_bonus + b.item_qty_normal * grn_unit_cost_in_pur_uom,"+no_Of_Decimals_For_Cost+") grn_val_pur_uom,/*ROUND (b.grn_unit_cost_in_stk_uom, "+no_Of_Decimals_For_Cost+")*/ (b.grn_unit_cost_in_pur_uom/b.pur_uom_conv) grn_unit_cost_in_stk_uom,ROUND( (b.item_qty_bonus + b.item_qty_normal)* b.pur_uom_conv * /*grn_unit_cost_in_stk_uom*/ (b.grn_unit_cost_in_pur_uom/b.pur_uom_conv),"+no_Of_Decimals_For_Cost+") grn_val_stk_uom,DECODE (b.replace_on_expiry_yn,       'N', 'No','Y', 'Yes') replace_on_expiry_yn,a.store_code, d.short_name supp_name, e.short_desc store_desc,TO_CHAR (expiry_date_or_receipt_date,'dd/mm/rrrr') expiry_date_or_receipt_date, c.batch_id, a.finalized_yn, (rtv_item_qty_normal + rtv_item_qty_bonus) rtv_dtl , (SELECT COUNT(*) FROM st_repl_grn_rtv_dtl where doc_type_code = a.doc_type_code and doc_no = b.doc_no) grn_rtv_cnt,A.EXT_DOC_NO,A.EXT_DOC_TYPE_CODE,c.grn_item_qty,c.sale_price,(c.grn_item_qty*c.sale_price*b.pur_uom_conv) sale_value,(c.grn_item_qty*b.pur_uom_conv) grn_item_qty_pur_uom, c.image_ref  FROM st_grn_hdr a,st_grn_dtl b,st_grn_dtl_exp c,ap_supplier_lang_vw d,mm_store_lang_vw e,st_item_store g WHERE  a.facility_id = b.facility_id      AND b.facility_id = c.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_type_code = c.doc_type_code AND a.doc_no = b.doc_no AND a.doc_no = c.doc_no AND a.store_code = c.store_code AND b.item_code = c.item_code AND b.doc_srl_no = c.doc_srl_no AND d.supp_code = a.supp_code AND a.store_code = e.store_code"; 
		
		if (checkForNull(to_doc_date).equals("")) {
			String currentdate		=  com.ehis.util.DateUtils.getCurrentDate("DMY",getLanguageId());
			to_doc_date = currentdate;
		}			
		
		/*alParameters.add(getLanguageId());//Added by Rabbani #Inc no:43683(ML-BRU-SCF-1029) on 03-OCT-2013	
		alParameters.add(item_code);
		alParameters.add(doc_no);  //28/10/11
		alParameters.add(ext_doc_no); //28/10/11
		alParameters.add(ext_doc_no);
		alParameters.add(supp_code);
		alParameters.add(fm_doc_date);
		alParameters.add(to_doc_date);
		alParameters.add(finalized_yn);
		alParameters.add(finalized_yn);
		alParameters.add(store_code);
		alParameters.add(po_no);
		alParameters.add(po_no);
		alParameters.add(getLanguageId());
		alParameters.add(replace_on_expiry_yn);
		alParameters.add(replace_on_expiry_yn);
		alParameters.add(replace_on_expiry_yn);*/

		//Modified by Sakti to pass dynamically values for performance issue on 20/05/2014
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());

		if(!(item_code.equals("%"))){
			stSQL = stSQL + " AND b.item_code = ? " ;
			alParameters.add(item_code);
		}
		if(!(doc_no.equals("%"))){
			stSQL = stSQL + " AND a.doc_no = ? " ;
			alParameters.add(doc_no);
		}
		if(!(ext_doc_no.equals(""))){
			stSQL = stSQL + " AND a.ext_doc_no = ? " ;
			alParameters.add(ext_doc_no);
		}
		if(!(supp_code.equals("%"))){
			stSQL = stSQL + " AND a.supp_code = ? " ;
			alParameters.add(supp_code);
		}

		stSQL = stSQL+" AND a.doc_date BETWEEN TO_DATE  (?, 'dd/mm/yyyy') AND  TO_DATE (?, 'dd/mm/yyyy')";
		alParameters.add(fm_doc_date);
		alParameters.add(to_doc_date);
		
		if(!(finalized_yn.equals("A"))){
			stSQL = stSQL + " AND a.finalized_yn = ? " ;
			alParameters.add(finalized_yn);
		}

		if(!(store_code.equals("%"))){
			stSQL = stSQL + " AND a.store_code = ? " ;
			alParameters.add(store_code);
		}
		if(!(po_no.equals(""))){
			stSQL = stSQL + " AND a.po_no = ? " ;
			alParameters.add(po_no);
		}
		if(!(replace_on_expiry_yn.equals("A"))){
			stSQL = stSQL + " AND b.replace_on_expiry_yn = ? " ;
			alParameters.add(replace_on_expiry_yn);
		}
				
		stSQL = stSQL+" AND d.language_id = e.language_id AND  d.language_id = ? AND g.item_code = b.item_code AND g.store_code = c.store_code  ORDER BY b.item_code,short_desc,b.PUR_UOM_CODE,a.doc_no,a.doc_type_code";
		alParameters.add(getLanguageId());
		// Modification ends
								
		ArrayList listRecord =new ArrayList();
		try {
			
		//String stSQL=getStRepositoryValue("ST_SQL_GRN_HISTORY");
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			System.err.println("stSQL Query======206 bean"+stSQL);
			System.err.println("alParameters======207 bean"+alParameters);
			e.printStackTrace() ;
			throw e ;
		} 
	}
}
