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
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)
30/01/2020      		IN071972            	Haribabu                               						AAKH-CRF-0117.2 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package	eST.Common;
import java.util.*;

final public class StEJBRepository	{

	private	static StEJBRepository	instance ;
	private	int	i=0;

	protected HashMap dataMap ;
//TO BE	REMOVED///////////////////////////////////////////////////////////
	public StEJBRepository(){
		try	{
			dataMap	= new HashMap()	;
			load() ;
		}
		catch (Exception exception)	{
			exception.printStackTrace();
		}
	}
/////////////////////////////////////////////////////////////
/*
	private	StRepository() throws Exception	{
		dataMap	= new HashMap()	;
		load() ;
	}
*/
	public static String getStKeyValue(	String key)	{
		try	{
			if ( instance == null )	{
				instance = new StEJBRepository() ;
				instance.i++;
			}
			return instance.getValue( key );
		}
		catch (Exception exception)	{
			exception.printStackTrace();
		}
		return "Error:(Key not found)";
	}

	public static int getI(){
		return instance.i;
	}

	public static void main( String	args[]){
		try	{
		}
		catch (Exception exception)	{
		}
	}

	private	String getValue( String	key	) throws Exception {
		String value = "" ;
		try	{
			value =	(String) dataMap.get( key )	;
			if ( value == null )
				throw new Exception( key + " : Key not found" )	;
		}
		catch (	Exception exception	) {
			throw new Exception( key + " : Key not found."+exception) ;
		}
		return value ;
	}

	protected void finalize() throws Throwable {
		if ( dataMap !=	null )
			dataMap	= null;
	}

	private	void load()	throws Exception {
//Sales related Queries
		dataMap.put("SQL_ST_SAL_HDR_UPDATE_FOR_SAL",	"UPDATE st_sal_hdr SET doc_date = TO_DATE(?,'dd/mm/yyyy') , doc_ref = ? , store_code = ? , authorized_by_id = ? , cancelled_by_id = ? , cancelled_remarks = ? , finalized_yn = ? , gl_interfaced_yn = ? , trn_type = ? , add_qty_sal_yn = ? , patient_id = ? , encounter_id = ? , sal_trn_type = ?, remarks=?, item_class_code=?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ? AND finalized_yn='N'");
		dataMap.put("SQL_ST_SAL_HDR_INSERT_FOR_SAL",	"INSERT INTO st_sal_hdr ( facility_id, doc_type_code, doc_no, doc_date, doc_ref, store_code, authorized_by_id, cancelled_by_id, cancelled_remarks, finalized_yn, gl_interfaced_yn, trn_type, add_qty_sal_yn, patient_id, encounter_id, sal_trn_type, remarks, item_class_code,module_id, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,billable_trn_yn,take_home_yn,patient_name,ref_no,priority,locn_code) VALUES  ( ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ? , ? , ? , SYSDATE , ? , ? , ? , SYSDATE , ? , ? ,?,?,?,? ,?,?)");
		dataMap.put("SQL_ST_SAL_HDR_DELETE_FOR_SAL",	"DELETE FROM st_sal_hdr WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ? AND finalized_yn='N'");
		//18/09/12
		//dataMap.put("SQL_ST_SAL_DTL_UPDATE_FOR_SAL",	"UPDATE st_sal_dtl SET item_code = ? , sal_category = ? , hcp_issue_factor = ? , item_qty = ? , item_sal_value = ? , next_due_date = TO_DATE(?,'dd/mm/yyyy') , stock_item_yn = ? , remarks=?, item_unit_cost =?, item_cost_value=?, item_unit_price=?, GROSS_CHARGE_AMT = ?, PAT_NET_AMT = ?,BL_INCL_EXCL_OVERRIDE_VALUE = ?,BL_INCL_EXCL_OVERRIDE_REASON = ? , take_home_yn = ?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,sale_req_qty=? WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ?");
		
		dataMap.put("SQL_ST_SAL_DTL_UPDATE_FOR_SAL",	"UPDATE st_sal_dtl SET item_code = ? , sal_category = ? , hcp_issue_factor = ? , item_qty = ? , item_sal_value = ? , next_due_date = TO_DATE(?,'dd/mm/yyyy') , stock_item_yn = ? , remarks=?, item_unit_cost =?, item_cost_value=?, item_unit_price=?, GROSS_CHARGE_AMT = ?, PAT_NET_AMT = ?,BL_INCL_EXCL_OVERRIDE_VALUE = ?,BL_INCL_EXCL_OVERRIDE_REASON = ? , take_home_yn = ?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,sale_req_qty=? ,usage_type= ?, APPROVAL_NO=? WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ?");//Modified for for IN:071972
		
		//dataMap.put("SQL_ST_SAL_DTL_INSERT_FOR_SAL",	"INSERT INTO st_sal_dtl ( facility_id, doc_type_code, doc_no, doc_srl_no, item_code, sal_category, hcp_issue_factor, item_qty, item_sal_value, next_due_date, stock_item_yn, remarks, item_unit_cost, item_cost_value, item_unit_price, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ?, ?, ?,  ? , SYSDATE , ? , ? , ? , SYSDATE , ? , ?  )");
		//19/09/12
		//dataMap.put("SQL_ST_SAL_DTL_INSERT_FOR_SAL",	"INSERT INTO st_sal_dtl ( facility_id, doc_type_code, doc_no, doc_srl_no, item_code, sal_category, hcp_issue_factor, item_qty, item_sal_value, next_due_date, stock_item_yn, remarks, item_unit_cost, item_cost_value, item_unit_price, GROSS_CHARGE_AMT, PAT_NET_AMT,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,take_home_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,sale_req_qty ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE , ? , ? , ? , SYSDATE , ? , ? ,? )");
		 
		dataMap.put("SQL_ST_SAL_DTL_INSERT_FOR_SAL",	"INSERT INTO st_sal_dtl ( facility_id, doc_type_code, doc_no, doc_srl_no, item_code, sal_category, hcp_issue_factor, item_qty, item_sal_value, next_due_date, stock_item_yn, remarks, item_unit_cost, item_cost_value, item_unit_price, GROSS_CHARGE_AMT, PAT_NET_AMT,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,take_home_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,sale_req_qty,usage_type,APPROVAL_NO ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE , ? , ? , ? , SYSDATE , ? , ? ,?,?,? )"); //Modified for for IN:071972
		dataMap.put("SQL_ST_SAL_DTL_DELETE_FOR_SAL",	"DELETE FROM st_sal_dtl WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ?");
// added by manish on Wednesday, February 11, 2004 for PH
		dataMap.put("SQL_ST_SAL_DTL_DELETE_FOR_PH",	"DELETE FROM st_sal_dtl WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND item_code IN (@) and doc_srl_no = ?");
// added ends.
		dataMap.put("SQL_ST_SAL_DTL_DELETE_ALL_FOR_SAL",	"DELETE FROM st_sal_dtl WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?");
		
		//modified to add batch_srl_no
		//dataMap.put("SQL_ST_SAL_DTL_EXP_INSERT_FOR_SAL",	"INSERT INTO st_sal_dtl_exp ( facility_id, doc_type_code, doc_no, doc_srl_no, store_code, item_code, batch_id, bin_location_code, expiry_date_or_receipt_date, trade_id, sal_item_qty, ret_item_qty, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ? , ? , SYSDATE , ? , ? , ? , SYSDATE , ? , ?  )");
		//dataMap.put("SQL_ST_SAL_DTL_EXP_INSERT_FOR_SAL",	"INSERT INTO st_sal_dtl_exp ( facility_id, doc_type_code, doc_no, doc_srl_no, store_code, item_code, batch_id, bin_location_code, expiry_date_or_receipt_date, trade_id, sal_item_qty, ret_item_qty, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ,batch_srl_no) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ? , ? , SYSDATE , ? , ? , ? , SYSDATE , ? , ? , ? )");
		//modified to add barcode_id 
		dataMap.put("SQL_ST_SAL_DTL_EXP_INSERT_FOR_SAL",	"INSERT INTO st_sal_dtl_exp ( facility_id, doc_type_code, doc_no, doc_srl_no, store_code, item_code, batch_id, bin_location_code, expiry_date_or_receipt_date, trade_id, sal_item_qty, ret_item_qty, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ,batch_srl_no,barcode_id) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? , TO_DATE(?,'dd/mm/yyyy') , ? , ? , ? , ? , SYSDATE , ? , ? , ? , SYSDATE , ? , ? , ? , ?)");


		dataMap.put("SQL_ST_SAL_DTL_EXP_DELETE_FOR_SAL",	"DELETE FROM st_sal_dtl_exp WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ?");
// added by manish on Wednesday, February 11, 2004 for PH
		dataMap.put("SQL_ST_SAL_DTL_EXP_DELETE_FOR_PH",	"DELETE FROM st_sal_dtl_exp WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND item_code IN (@) and doc_srl_no =  ?");
// added ends.
		dataMap.put("SQL_ST_SAL_DTL_EXP_DELETE_ALL_FOR_SAL",	"DELETE FROM st_sal_dtl_exp WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?");
		dataMap.put("SQL_ST_ITEM_BATCH_FOR_SAL",	"UPDATE st_item_batch SET committed_qty = nvl(committed_qty,0) + ?, modified_by_id=?, modified_date= SYSDATE, modified_at_ws_no=?, modified_facility_id= ? WHERE store_code=? AND  item_code=? AND batch_id=? AND bin_location_code=? AND TRUNC(expiry_date_or_receipt_date)=TO_DATE(?,'dd/mm/yyyy')");
// added by manish on Tuesday, February 17, 2004
		dataMap.put("SQL_ST_ITEM_BATCH_SELECT_SINGLE",	"SELECT committed_qty, qty_on_hand FROM st_item_batch WHERE store_code=? AND  item_code=? AND batch_id=? AND bin_location_code=? AND TRUNC(expiry_date_or_receipt_date)=TO_DATE(?,'dd/mm/yyyy')");
// added ends.
		// Commented for Date Format Exception
		//dataMap.put("SQL_ST_GET_MONTH_AND_YEAR","select	substr(st_get_post_mth_yr(to_char(to_date(sysdate,'dd/mm/yyyy'))),1,2) mm, substr(st_get_post_mth_yr(to_char(to_date(sysdate,'dd/mm/yyyy'))),3,4) yyyy from	dual");
		dataMap.put("SQL_ST_GET_MONTH_AND_YEAR","SELECT  SUBSTR (st_get_post_mth_yr (trunc(SYSDATE)), 1, 2) mm, SUBSTR (st_get_post_mth_yr (trunc(SYSDATE)), 3, 4) yyyy FROM DUAL");

		dataMap.put("SQL_ST_CHECK_SUMMARY_EXISTS","SELECT count(*) count FROM st_item_move_summ	WHERE facility_id =	? AND item_code=? AND store_code = ? AND move_month= ? AND move_year =?");
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT",	"SELECT  COUNT(*) total FROM st_item_move_summ WHERE facility_id = ?  AND item_code = ?  AND store_code = ?  AND move_year = ?  AND move_month = ?");
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_SAL",	"INSERT INTO st_item_move_summ( facility_id, item_code, store_code, move_year, move_month, sal_qty, sal_cost, sal_value, sal_qty_ns, sal_cost_ns, sal_value_ns, month_closing_qty, month_closing_value, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");  
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_SAL", "UPDATE st_item_move_summ SET sal_qty=NVL(sal_qty,0)+?, sal_cost=NVL(sal_cost,0)+?, sal_value=NVL(sal_value,0)+?, sal_qty_ns=NVL(sal_qty_ns,0)+?, sal_cost_ns=NVL(sal_cost_ns,0)+?, sal_value_ns=NVL(sal_value_ns,0)+?, month_closing_qty=NVL(month_closing_qty,0)+?, month_closing_value=NVL(month_closing_value,0)+?, modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=? WHERE facility_id=? AND item_code=? AND store_code=? AND move_year=? AND move_month=?");
		dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_FOR_BLOCK_REL",	"SELECT store_code, item_code, batch_id, bin_location_code, TO_CHAR(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, trade_id, sal_item_qty FROM st_sal_dtl_exp WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? AND doc_srl_no LIKE ?");
		dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_FOR_BLOCK_REL1",	"SELECT store_code, a.item_code item_code, batch_id, bin_location_code, TO_CHAR(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, trade_id, sal_item_qty, b.gen_uom_code gen_uom_code, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO FROM st_sal_dtl_exp a, mm_item b WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? AND doc_srl_no LIKE ? and a.item_code = b.item_code");
// added by manish on Wednesday, February 11, 2004
		dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_FOR_BLOCK_REL_FOR_PH",	"SELECT DOC_SRL_NO,store_code, item_code, batch_id, bin_location_code, TO_CHAR(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, trade_id, sal_item_qty FROM st_sal_dtl_exp WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? AND item_code IN (@) AND DOC_SRL_NO=?");
		dataMap.put("SQL_ST_SAL_DTL_SELECT_COUNT_FOR_PH",	"SELECT count(*) TOTAL FROM st_sal_dtl WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? ");
		dataMap.put("SQL_ST_SAL_HDR_SELECT_COUNT_FOR_PH",	"SELECT count(*) TOTAL FROM st_sal_hdr WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? AND finalized_yn='N'");
		
// added ends.
		dataMap.put("SQL_ST_CHECK_BATCH_EXISTS", "SELECT count (*) count FROM st_batch_control WHERE item_code=? AND batch_id =? AND trunc(expiry_date_or_receipt_date) =to_date(?,'dd/mm/yyyy')");
		
		//dataMap.put("SQL_ST_BATCH_CONTROL_INSERT", "INSERT into	st_batch_control (item_code,	batch_id, expiry_date_or_receipt_date, trade_id, batch_status, discount_perc, added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,	modified_at_ws_no, modified_facility_id) VALUES		(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,sysdate,?,? )");
		//dataMap.put("SQL_ST_BATCH_CONTROL_INSERT", "INSERT into	st_batch_control (item_code,	batch_id, expiry_date_or_receipt_date, trade_id, batch_status, discount_perc, added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,	modified_at_ws_no, modified_facility_id,sale_price,barcode_id,SUPP_CODE) VALUES(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,? )");
		//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
		//dataMap.put("SQL_ST_BATCH_CONTROL_INSERT", "INSERT into	st_batch_control (item_code,	batch_id, expiry_date_or_receipt_date, trade_id, batch_status, discount_perc, added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,	modified_at_ws_no, modified_facility_id,sale_price,barcode_id,supp_code,pur_uom_code,pur_uom_conv) VALUES(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?)");//Commented by suresh.r on 03-01-2014 against KDAH for update batch_cost into st_batch_control
		dataMap.put("SQL_ST_BATCH_CONTROL_INSERT", "INSERT into	st_batch_control (item_code,	batch_id, expiry_date_or_receipt_date, trade_id, batch_status, discount_perc, added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,	modified_at_ws_no, modified_facility_id,sale_price,barcode_id,supp_code,pur_uom_code,pur_uom_conv,batch_cost) VALUES(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?)");//Added by suresh.r on 03-01-2014 against KDAH for update batch_cost into st_batch_control

		dataMap.put("SQL_ST_CHECK_ITEM_BATCH_EXISTS", "SELECT count	(*)	count FROM st_item_batch WHERE store_code=?	AND	item_code=?	AND	batch_id =?	AND	bin_location_code=?	AND	trunc(expiry_date_or_receipt_date) =to_date(?,'dd/mm/yyyy')");

//		dataMap.put("SQL_ST_ITEM_BATCH_INSERT","INSERT into	st_item_batch (store_code, item_code, batch_id,	bin_location_code, expiry_date_or_receipt_date,trade_id, qty_on_hand, replace_on_expiry_yn,added_by_id,	added_date,	added_at_ws_no,	added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		//dataMap.put("SQL_ST_ITEM_BATCH_INSERT","INSERT into st_item_batch (store_code, item_code, batch_id,	bin_location_code, expiry_date_or_receipt_date,trade_id, qty_on_hand, replace_on_expiry_yn, GRN_DOC_TYPE_CODE, GRN_DOC_NO, GRN_DOC_SRL_NO, GRN_UNIT_COST_IN_STK_UOM,LAST_ISSUE_DATE, LAST_RECEIPT_DATE, PO_NO, added_by_id,	added_date,	added_at_ws_no,	added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		//dataMap.put("SQL_ST_ITEM_BATCH_INSERT","INSERT into st_item_batch (store_code, item_code, batch_id,	bin_location_code, expiry_date_or_receipt_date,trade_id, qty_on_hand, replace_on_expiry_yn, GRN_DOC_TYPE_CODE, GRN_DOC_NO, GRN_DOC_SRL_NO, GRN_UNIT_COST_IN_STK_UOM,LAST_ISSUE_DATE, LAST_RECEIPT_DATE, PO_NO, added_by_id,	added_date,	added_at_ws_no,	added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,barcode_id) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
	    //added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
		dataMap.put("SQL_ST_ITEM_BATCH_INSERT","INSERT into st_item_batch (store_code, item_code, batch_id,	bin_location_code, expiry_date_or_receipt_date,trade_id, qty_on_hand, replace_on_expiry_yn, GRN_DOC_TYPE_CODE, GRN_DOC_NO, GRN_DOC_SRL_NO, GRN_UNIT_COST_IN_STK_UOM,LAST_ISSUE_DATE, LAST_RECEIPT_DATE, PO_NO, added_by_id,	added_date,	added_at_ws_no,	added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,barcode_id,pur_uom_code,pur_uom_conv) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?)");
		
		
			
	//	dataMap.put("SQL_ST_GET_ITEM_BATCH_STOCK_POS","SELECT qty_on_hand,suspended_yn,phy_inv_id FROM st_item_batch WHERE store_code=?	 AND  item_code=?  AND	batch_id =?	 AND  bin_location_code=? AND  expiry_date_or_receipt_date =to_date(?,'dd/mm/yyyy')"); commanded for AMS-SCF-0648
		dataMap.put("SQL_ST_GET_ITEM_BATCH_STOCK_POS", "SELECT qty_on_hand,COMMITTED_QTY,suspended_yn,phy_inv_id FROM st_item_batch WHERE store_code=? AND  item_code=?  AND batch_id =? AND  bin_location_code=? AND  expiry_date_or_receipt_date =to_date(?,'dd/mm/yyyy')");// added for AMS-SCF-0648
		dataMap.put("SQL_ST_ITEM_BATCH_DELETE","DELETE FROM	st_item_batch WHERE	store_code=?  AND  item_code=?	AND	 batch_id =?  AND  bin_location_code=? AND	expiry_date_or_receipt_date	=to_date(?,'dd/mm/yyyy')");
//		dataMap.put("SQL_ST_ITEM_BATCH_UPDATE","UPDATE st_item_batch SET qty_on_hand = ? , committed_qty = nvl(committed_qty,0) + nvl(?,0) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')), last_issue_date	= decode (TO_DATE(?,'dd/mm/yyyy'), NULL, last_issue_date, TO_DATE(?,'dd/mm/yyyy'))	, modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id =	?  WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')");
		//commented for barcode_id
		//dataMap.put("SQL_ST_ITEM_BATCH_UPDATE","UPDATE st_item_batch SET qty_on_hand = ? , committed_qty = committed_qty + nvl(?,0) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')), last_issue_date	= decode (TO_DATE(?,'dd/mm/yyyy'), NULL, last_issue_date, TO_DATE(?,'dd/mm/yyyy')), GRN_DOC_TYPE_CODE = ?, GRN_DOC_NO = ?, GRN_DOC_SRL_NO = ?, GRN_UNIT_COST_IN_STK_UOM = ?, modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id =	?  WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')");
		//dataMap.put("SQL_ST_ITEM_BATCH_UPDATE","UPDATE st_item_batch SET qty_on_hand = ? , committed_qty = committed_qty + nvl(?,0) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')), last_issue_date	= decode (TO_DATE(?,'dd/mm/yyyy'), NULL, last_issue_date, TO_DATE(?,'dd/mm/yyyy')), GRN_DOC_TYPE_CODE = ?, GRN_DOC_NO = ?, GRN_DOC_SRL_NO = ?, GRN_UNIT_COST_IN_STK_UOM = ?, modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id =	?  ,barcode_id = nvl(?,barcode_id)  WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')");
		//added by Ganga Monday, November 26, 2012 IN035661	PMG2012-CRF-0012
		dataMap.put("SQL_ST_ITEM_BATCH_UPDATE","UPDATE st_item_batch SET qty_on_hand = ? , committed_qty = committed_qty + nvl(?,0) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')), last_issue_date	= decode (TO_DATE(?,'dd/mm/yyyy'), NULL, last_issue_date, TO_DATE(?,'dd/mm/yyyy')), GRN_DOC_TYPE_CODE = nvl(?,GRN_DOC_TYPE_CODE), GRN_DOC_NO = nvl(?,GRN_DOC_NO), GRN_DOC_SRL_NO = nvl(?,GRN_DOC_SRL_NO), GRN_UNIT_COST_IN_STK_UOM = nvl(?,GRN_UNIT_COST_IN_STK_UOM), modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id =	?, barcode_id = NVL(?,barcode_id) ,pur_uom_code = NVL(?,pur_uom_code) ,pur_uom_conv = NVL(?,pur_uom_conv)  WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')");
		
		
		//dataMap.put("SQL_ST_ITEM_VALUE_SELECT1","select sum(QTY_ON_HAND) qty_on_hand, sum(item_value) item_value FROM st_item_store WHERE item_code = ? group by item_code");
		dataMap.put("SQL_ST_ITEM_VALUE_SELECT1","SELECT SUM (  ST.QTY_ON_HAND * ST_GET_UOM_CONV_FAC_SING_STR (ST.ITEM_CODE,ST.STORE_CODE) ) QTY_ON_HAND, SUM (ST.ITEM_VALUE) ITEM_VALUE FROM ST_ITEM_STORE ST WHERE ST.ITEM_CODE = ?");
		
		
		//dataMap.put("SQL_ST_ITEM_VALUE_SELECT","SELECT SUM(st.QTY_ON_HAND * NVL((SELECT eqvl_value FROM MM_ITEM_UOM_DEFN mid WHERE st.def_issue_uom = mid.eqvl_uom_code AND  mm.gen_uom_code = mid.uom_code AND mid.item_code = st.item_code UNION SELECT eqvl_value FROM am_uom_eqvl WHERE st.def_issue_uom = eqvl_uom_code AND  mm.gen_uom_code = uom_code),1))qty_on_hand , SUM(st.item_value) item_value  FROM st_item_store st, mm_item_lang_vw mm   WHERE st.item_code = ?   AND st.item_code = mm.item_code  AND mm.language_id = ?");
		dataMap.put("SQL_ST_ITEM_VALUE_SELECT","SELECT SUM (  ST.QTY_ON_HAND * ST_GET_UOM_CONV_FAC_SING_STR (ST.ITEM_CODE,ST.STORE_CODE) ) QTY_ON_HAND, SUM (ST.ITEM_VALUE) ITEM_VALUE FROM ST_ITEM_STORE ST WHERE ST.ITEM_CODE = ?");



		//dataMap.put("SQL_ST_ITEM_MASTER_UPDATE", "Update mm_item SET unit_cost = round(?,6),	last_trn_type=?, modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id	= ?	WHERE item_code	= ?");
		/**
		 * @Name - Priya
		 * @Date - 08/06/2010
		 * @Inc# - 
		 * @Desc -    To round up the Unit Cost with the function 'st_get_cost_decimals' the above query is modified 
		 */
		dataMap.put("SQL_ST_ITEM_MASTER_UPDATE", "Update mm_item SET unit_cost = st_get_cost_decimals(?,'N'),	last_trn_type=?, modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id	= ?	WHERE item_code	= ?");
	
		dataMap.put("SQL_ST_GET_ITEM_STORE_STOCK_POS", "SELECT nvl(qty_on_hand,0) qty_on_hand, nvl(item_value,0) item_value, stock_item_yn FROM st_item_store WHERE item_code=? AND store_code=?");

		//dataMap.put("SQL_ST_ITEM_STORE_QTY_UPDATE","UPDATE st_item_store SET bin_location_code = decode (?,NULL,bin_location_code,?) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')) , last_issue_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_issue_date,TO_DATE(?,'dd/mm/yyyy')), pending_req_qty = decode(?,0,pending_req_qty,(pending_req_qty-?)), qty_on_hand = ? , item_value = round(?,3)  ,modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id = ?  WHERE item_code = ? AND store_code = ?");
		/**
		 * @Name - Priya
		 * @Date - 08/06/2010
		 * @Inc# - 
		 * @Desc -    To round up the Unit Cost with the function 'st_get_cost_decimals' the above query is modified 
		 */
		dataMap.put("SQL_ST_ITEM_STORE_QTY_UPDATE","UPDATE st_item_store SET bin_location_code = decode (?,NULL,bin_location_code,?) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')) , last_issue_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_issue_date,TO_DATE(?,'dd/mm/yyyy')), pending_req_qty = decode(?,0,pending_req_qty,(pending_req_qty-?)), qty_on_hand = ? , item_value = st_get_cost_decimals(?,'N')  ,modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id = ?  WHERE item_code = ? AND store_code = ?");
		dataMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_SAL",	"INSERT INTO st_item_trn_dtl(facility_id, store_code, item_code, posted_date, trn_srl_no, trn_type, doc_type_code, doc_no, doc_srl_no, doc_date, doc_ref, batch_id, expiry_date, item_qty_normal, item_unit_cost, item_unit_price, stk_uom_code, stock_item_yn, sal_trn_type, bin_location_code, trade_id, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
		dataMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", "SELECT next_doc_no FROM sy_acc_entity_doc_type WHERE doc_type_code = ?");
		//dataMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", "SELECT ST_SAL_SEQ.NEXTVAL NEXT_DOC_NO FROM DUAL");
		dataMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE", "UPDATE sy_acc_entity_doc_type	SET	next_doc_no=next_doc_no+1, modified_by_id =?, modified_date	=sysdate, modified_at_ws_no	=?,	modified_facility_id =?	WHERE doc_type_code=?");
		dataMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG",	"SELECT	nvl(doc_num_gen_flag,'N') doc_num_gen_flag FROM	sy_acc_entity_doc_type WHERE doc_type_code =?");
//Manufacuring Request
		dataMap.put("SQL_ST_MAN_REQ_HDR_INSERT","INSERT INTO st_mfg_request_hdr  (requesting_store_code,prepare_location_code,preparation_type,preparation_mode,item_code,request_qty,patient_id,encounter_id,MFG_REQUEST_NO,item_desc,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		dataMap.put("SQL_ST_MAN_REQ_DTL_INSERT", "INSERT INTO st_mfg_request_dtl (MFG_REQUEST_NO,child_item_code,component_qty,mfg_uom_code,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		//dataMap.put("SQL_ST_MAN_REQ_DTL_INSERT", "INSERT INTO st_mfg_request_dtl (MFG_REQUEST_NO,child_item_code,component_qty,mfg_uom_code,PRINT_ON_LABEL_YN,SEQ_NO,INSTRN_CODE,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		dataMap.put("SQL_ST_MAN_REQ_HDR_UPDATE","UPDATE  st_mfg_request_hdr  set requesting_store_code=?,prepare_location_code=?,preparation_type=?,preparation_mode=?,request_qty=?,patient_id=?,encounter_id=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,item_desc=? WHERE MFG_REQUEST_NO=? ");
		dataMap.put("SQL_ST_MAN_REQ_DTL_UPDATE","UPDATE  st_mfg_request_dtl set component_qty=?,mfg_uom_code=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where MFG_REQUEST_NO=? AND  child_item_code =? ");
		//dataMap.put("SQL_ST_MAN_REQ_DTL_UPDATE","UPDATE  st_mfg_request_dtl set component_qty=?,mfg_uom_code=?,PRINT_ON_LABEL_YN=?,SEQ_NO=?,INSTRN_CODE=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where MFG_REQUEST_NO=? AND  child_item_code =? ");
		dataMap.put("SQL_ST_MAN_REQ_DTL_DELETE","DELETE	 st_mfg_request_dtl  where MFG_REQUEST_NO=? AND	child_item_code	=? ");
		dataMap.put("SQL_ST_MAN_REQ_DTL_ALL_DELETE","DELETE  st_mfg_request_dtl where MFG_REQUEST_NO=?" );
		dataMap.put("SQL_ST_MAN_REQ_HDR_ALL_DELETE","DELETE  st_mfg_request_hdr  where MFG_REQUEST_NO=? ");
		dataMap.put("SQL_ST_MAN_REQ_MFG_REQUEST_NO","SELECT NVL(MAX(MFG_REQUEST_NO),0) item_seq	FROM st_mfg_request_hdr	");
//Manufacuring Receipt
		dataMap.put("SQL_ST_MAN_RECEIPT_ITEM_MOVE_SUM_INSERT", "INSERT INTO st_item_move_summ (FACILITY_ID,ITEM_CODE,STORE_CODE,MOVE_YEAR,MOVE_MONTH,MONTH_CLOSING_QTY,MONTH_CLOSING_VALUE,MFG_QTY,MFG_COST,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO)VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?)");
//		dataMap.put("SQL_ST_MAN_RECEIPT_ITEM_MOVE_SUM_UPDATE", "UPDATE st_item_move_summ SET MONTH_CLOSING_QTY=?,MONTH_CLOSING_VALUE=?,MFG_QTY=?,MFG_COST=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=? ");  // Modified on 5/30/2006 for updating modification details    // Not used
		dataMap.put("SQL_ST_MAN_RECEIPT_ITEM_MOVE_SUM_UPDATE", "UPDATE st_item_move_summ SET MONTH_CLOSING_QTY=?,MONTH_CLOSING_VALUE=?,MFG_QTY=?,MFG_COST=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=? , modified_facility_id = ?");

//changed by sri on 20/11/04		dataMap.put("SQL_ST_MAN_RECEIPT_HDR_INSERT" ,"INSERT INTO st_mfg_hdr (facility_id ,	doc_type_code  , doc_no	 , doc_date	,	doc_ref	 , store_code ,	item_code ,	item_qty ,	  expiry_date,batch_id	, bin_location_code, finalized_yn ,	 gl_interfaced_yn, trn_type	,stock_item_yn,	preparation_type  ,      preparation_mode	,  prepare_location_code,  patient_id ,	encounter_id, mfg_item_unit_cost, prepare_desc , process_loss_percent, prepare_qty ,MFG_REQUEST_NO,trade_id, added_by_id , added_date ,	added_at_ws_no,	added_facility_id, modified_by_id ,	modified_date ,	modified_at_ws_no, modified_facility_id,mfg_item_cost_value) values (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)	");
		dataMap.put("SQL_ST_MAN_RECEIPT_HDR_INSERT" ,"INSERT INTO ST_MFG_HDR (facility_id ,	doc_type_code  , doc_no	 , doc_date	,	doc_ref	 , store_code ,	item_code ,	item_qty ,	  expiry_date,batch_id	, bin_location_code, finalized_yn ,	 gl_interfaced_yn, trn_type	,stock_item_yn,	preparation_type  ,      preparation_mode	,  prepare_location_code,  patient_id ,	encounter_id, mfg_item_unit_cost, prepare_desc , process_loss_percent, prepare_qty ,MFG_REQUEST_NO,trade_id, added_by_id , added_date ,	added_at_ws_no,	added_facility_id, modified_by_id ,	modified_date ,	modified_at_ws_no, modified_facility_id,mfg_item_cost_value,REMARKS, PACKED_BY, COUNTER_CHECKED_BY,barcode_id,no_of_labels) VALUES (?,?,?,TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?)");
//	dataMap.put("SQL_ST_MAN_RECEIPT_PREP_LOCN_UPDATE" ,"UPDATE ST_PREPARE_LOCATION SET NEXT_BATCH_ID=? where PREPARE_LOCATION_CODE=? and EFF_STATUS = 'E'");  // Modified on 5/30/2006 for updating modification details
		dataMap.put("SQL_ST_MAN_RECEIPT_PREP_LOCN_UPDATE" ,"UPDATE ST_PREPARE_LOCATION SET NEXT_BATCH_ID=?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=? , modified_facility_id = ? where PREPARE_LOCATION_CODE=? and EFF_STATUS = 'E'");

		dataMap.put("SQL_ST_MAN_RECEIPT_DTL_INSERT" ,"INSERT INTO st_mfg_dtl (facility_id  , doc_type_code , doc_no	, doc_srl_no, child_item_code, child_item_qty  , item_unit_cost	 , stock_item_yn  ,mfg_uom_code	, child_item_trans_qty,mfg_cost_value ,added_by_id	,added_date	, added_at_ws_no, added_facility_id,modified_by_id , modified_date , modified_at_ws_no,modified_facility_id			  )values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
		dataMap.put("SQL_ST_MAN_RECEIPT_EXP_INSERT", "INSERT INTO st_mfg_dtl_exp ( FACILITY_ID , DOC_TYPE_CODE , DOC_NO , DOC_SRL_NO , STORE_CODE , ITEM_CODE , BATCH_ID , BIN_LOCATION_CODE , EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID  , ITEM_QTY                       ,added_by_id	,added_date	, added_at_ws_no, added_facility_id,modified_by_id , modified_date , modified_at_ws_no,modified_facility_id			  )values (?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,?,?,sysdate,?,?)");
//		dataMap.put("SQL_ST_MAN_RECEIPT_STATUS_UPDATE", "UPDATE st_mfg_request_hdr SET REQUEST_STATUS='C' WHERE mfg_request_no=? "); // Modified on 5/30/2006 for updating modification details
		dataMap.put("SQL_ST_MAN_RECEIPT_STATUS_UPDATE", "UPDATE st_mfg_request_hdr SET REQUEST_STATUS='C' , MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=? , modified_facility_id = ? WHERE mfg_request_no=?");
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_MFG", "UPDATE st_item_move_summ SET MONTH_CLOSING_QTY=nvl(MONTH_CLOSING_QTY,0)+?,MONTH_CLOSING_VALUE=nvl(MONTH_CLOSING_VALUE,0)+?,MFG_QTY=nvl(MFG_QTY,0)+?,MFG_COST=nvl(MFG_COST,0)+?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=? ,MODIFIED_FACILITY_ID =?  where FACILITY_ID=? AND ITEM_CODE=? AND  STORE_CODE=?  AND MOVE_YEAR=? AND MOVE_MONTH=?  ");
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_MFG"," INSERT INTO st_item_move_summ (FACILITY_ID,ITEM_CODE,STORE_CODE,MOVE_YEAR,MOVE_MONTH,MONTH_CLOSING_QTY,MONTH_CLOSING_VALUE,MFG_QTY,MFG_COST,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
//		dataMap.put("SQL_ST_MFG_HDR_UPDATE","UPDATE st_mfg_hdr SET EXPIRY_DATE=to_date(?,'dd/mm/yyyy'),BATCH_ID=?,BIN_LOCATION_CODE=?,trade_id=?,FINALIZED_YN=?,PREPARE_LOCATION_CODE =?,PATIENT_ID=?,ENCOUNTER_ID=?,PROCESS_LOSS_PERCENT=?,PREPARE_QTY=? ,MFG_ITEM_UNIT_COST=?,mfg_item_cost_value=? ,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? AND MFG_REQUEST_NO=?");  // Modified on 5/30/2006 for updating modification details
		dataMap.put("SQL_ST_MFG_HDR_UPDATE","UPDATE st_mfg_hdr SET EXPIRY_DATE=TO_DATE(?,'dd/mm/yyyy'),BATCH_ID=?,BIN_LOCATION_CODE=?,trade_id=?,FINALIZED_YN=?,PREPARE_LOCATION_CODE =?,PATIENT_ID=?,ENCOUNTER_ID=?,PROCESS_LOSS_PERCENT=?,PREPARE_QTY=? ,MFG_ITEM_UNIT_COST=?,mfg_item_cost_value=? ,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? , REMARKS=?, PACKED_BY=?, COUNTER_CHECKED_BY=?,BARCODE_ID = ?,NO_OF_LABELS = ? WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? AND MFG_REQUEST_NO=?");
		
		 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		dataMap.put("SQL_ST_MFG_HDR_DFLT_UPDATE","UPDATE st_mfg_hdr SET EXPIRY_DATE=TO_DATE(?,'dd/mm/yyyy'),BATCH_ID=?,BIN_LOCATION_CODE=?,trade_id=?,FINALIZED_YN=?,PREPARE_LOCATION_CODE =?,PATIENT_ID=?,ENCOUNTER_ID=?,PROCESS_LOSS_PERCENT=?,PREPARE_QTY=? ,MFG_ITEM_UNIT_COST=?,mfg_item_cost_value=? ,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? , REMARKS=?, PACKED_BY=?, COUNTER_CHECKED_BY=?,BARCODE_ID = ?,NO_OF_LABELS = ? WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=?");
	
		dataMap.put("SQL_ST_MFG_DTL_UPDATE","UPDATE st_mfg_dtl SET CHILD_ITEM_QTY=? ,ITEM_UNIT_COST=?,STOCK_ITEM_YN=?,CHILD_ITEM_TRANS_QTY=?,MFG_COST_VALUE =?,mfg_uom_code=? ,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=? , MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID=?  AND  DOC_TYPE_CODE=? AND DOC_NO=? AND DOC_SRL_NO=? AND CHILD_ITEM_CODE=? ");
		dataMap.put("SQL_ST_MFG_EXP_DELETE","DELETE st_mfg_dtl_exp WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? AND DOC_SRL_NO=?");
		dataMap.put("SQL_ST_MFG_DTL_DELETE","DELETE st_mfg_dtl WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? AND DOC_SRL_NO=?");
		dataMap.put("SQL_ST_MFG_DTL_EXP_SELECT_FOR_BLOCK_REL","select a.*,to_char(a.EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy')EXPIRY_DATE from  st_mfg_dtl_exp a WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? AND DOC_SRL_NO=?");
		dataMap.put("SQL_ST_MFG_EXP_SELECT_ALL_DOC","select a.*,to_char(a.EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy')EXPIRY_DATE from  st_mfg_dtl_exp a WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? ");
		dataMap.put("SQL_ST_MFG_EXP_DELETE_ALL","delete st_mfg_dtl_exp WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? ");
		dataMap.put("SQL_ST_MFG_DTL_DELETE_ALL","delete st_mfg_dtl WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=? ");
		dataMap.put("SQL_ST_MFG_HDR_DELETE_ALL","delete st_mfg_hdr WHERE FACILITY_ID=? AND DOC_TYPE_CODE=? AND DOC_NO=?");
		dataMap.put("SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN","SELECT STOCK_ITEM_YN FROM st_item_store WHERE STORE_CODE=? AND ITEM_CODE=? 	");
		dataMap.put("SQL_ST_MFG_TRN_DTL","INSERT INTO  st_item_trn_dtl (facility_id,store_code , item_code   , posted_date  , trn_srl_no, trn_type   ,doc_type_code,  doc_no  ,doc_srl_no,doc_date ,              doc_ref  , batch_id  ,expiry_date,item_qty_normal,item_unit_cost,stock_item_yn,bin_location_code,trade_id,stk_uom_code,added_by_id,  added_date  ,           added_at_ws_no,         added_facility_id,      modified_by_id ,        modified_date ,         modified_at_ws_no,      modified_facility_id   ) VALUES (?,?,?,sysdate,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		dataMap.put("SQL_ST_MAN_RECEIPT_BATCH_GEN","SELECT AUTO_GEN_BATCH_YN, NEXT_BATCH_ID, BATCH_ID_SERIES FROM ST_PREPARE_LOCATION WHERE PREPARE_LOCATION_CODE = ?");

		// For Sales Return function 

		dataMap.put("SQL_ST_SAL_RET_HDR_INSERT_FOR_SAL_RET", "INSERT INTO  st_sal_ret_hdr(facility_id,doc_type_code,doc_no,doc_date,doc_ref,store_code,finalized_yn,gl_interfaced_yn,trn_type,remarks,item_class_code,module_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,patient_id,encounter_id,sal_trn_type,sales_doc_no,locn_code) VALUES (?,?,?,TO_DATE(?, 'dd/mm/yyyy'),?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,? ) " );
		//dataMap.put("SQL_ST_SAL_RET_DTL_INSERT_FOR_SAL_RET", "INSERT INTO st_sal_ret_dtl( FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO, ITEM_CODE, STOCK_ITEM_YN, ITEM_QTY, ITEM_UNIT_COST, ITEM_COST_VALUE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
		dataMap.put("SQL_ST_SAL_RET_DTL_INSERT_FOR_SAL_RET", "INSERT INTO st_sal_ret_dtl( FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO, ITEM_CODE, STOCK_ITEM_YN, ITEM_QTY, ITEM_UNIT_COST, ITEM_COST_VALUE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, PAT_NET_AMT,GROSS_CHARGE_AMT) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?)");
		dataMap.put("SQL_ST_SAL_RET_DTL_EXP_INSERT_FOR_SAL_RET", "INSERT INTO st_sal_ret_dtl_exp ( FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO, STORE_CODE, ITEM_CODE, BATCH_ID, BIN_LOCATION_CODE, EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID, ITEM_QTY, SAL_DOC_TYPE_CODE, SAL_DOC_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )");
		//dataMap.put("SQL_ST_SAL_DTL_EXP_UPDATE_FOR_SAL_RET", "UPDATE st_sal_dtl_exp SET ret_item_qty = ( NVL(ret_item_qty,0) + ? ) , modified_by_id = ?,	 modified_date = SYSDATE,  modified_at_ws_no = ?,  modified_facility_id	= ? WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? /*AND STORE_CODE = ? */AND ITEM_CODE = ? AND BATCH_ID = ? AND BIN_LOCATION_CODE =  ? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'dd/mm/yyyy')  " ) ;
		dataMap.put("SQL_ST_SAL_DTL_EXP_UPDATE_FOR_SAL_RET", "UPDATE st_sal_dtl_exp SET ret_item_qty = ( NVL(ret_item_qty,0) + ? ) , modified_by_id = ?,	 modified_date = SYSDATE,  modified_at_ws_no = ?,  modified_facility_id	= ? WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? /*AND STORE_CODE = ? */AND ITEM_CODE = ? AND BATCH_ID = ? AND BIN_LOCATION_CODE =  ? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'dd/mm/yyyy') and  doc_srl_no = ? " ) ;
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_SAL_RET", "INSERT INTO st_item_move_summ( facility_id, item_code, store_code, move_year, move_month, srt_qty, srt_cost, srt_value, srt_qty_ns, srt_cost_ns, srt_value_ns, month_closing_qty, month_closing_value, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?) " ) ;
		dataMap.put("SQL_ST_ITEM_MOVE_SUMM_UPDATE_FOR_SAL_RET", "UPDATE st_item_move_summ SET srt_qty=NVL(srt_qty,0)+?, srt_cost=NVL(srt_cost,0)+?, srt_value=NVL(srt_value,0)+?, srt_qty_ns=NVL(srt_qty_ns,0)+?, srt_cost_ns=NVL(srt_cost_ns,0)+?, srt_value_ns=NVL(srt_value_ns,0)+?, month_closing_qty=NVL(month_closing_qty,0)+?, month_closing_value=NVL(month_closing_value,0)+?, modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=? WHERE facility_id=? AND item_code=? AND store_code=? AND move_year=? AND move_month=?");
		//dataMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_SAL_RET",	"INSERT INTO st_item_trn_dtl(facility_id, store_code, item_code, posted_date, trn_srl_no, trn_type, doc_type_code, doc_no, doc_srl_no, doc_date, doc_ref, batch_id, expiry_date, item_qty_normal, item_unit_cost, stk_uom_code, stock_item_yn,  bin_location_code, trade_id, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
        dataMap.put("SQL_ST_ITEM_TRN_DTL_INSERT_FOR_SAL_RET",	"INSERT INTO st_item_trn_dtl(facility_id, store_code, item_code, posted_date, trn_srl_no, trn_type, doc_type_code, doc_no, doc_srl_no, doc_date, doc_ref, batch_id, expiry_date, item_qty_normal, item_unit_cost, stk_uom_code, stock_item_yn,  bin_location_code, trade_id,source_doc_type_code,source_doc_no,source_doc_srl_no,source_doc_date,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?,?,?,?,TO_DATE(?,'dd/mm/yyyy'),?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?) ");
        
		//dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_FOR_SAL_RET_SUM" , "SELECT a.FACILITY_ID FACILITY_ID ,a.SALES_DOC_NO SALES_DOC_NO,b.ITEM_CODE ITEM_CODE,SUM(c.ITEM_QTY) SUM_ITEM_QTY,c.BATCH_ID BATCH_ID,c.BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(c.EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy') EXPIRY_DATE_OR_RECEIPT_DATE FROM ST_SAL_RET_HDR   a ,  ST_SAL_RET_DTL  b , ST_SAL_RET_DTL_EXP  c  WHERE a.FACILITY_ID=b.FACILITY_ID AND b.FACILITY_ID=c.FACILITY_ID AND a.DOC_NO=b.DOC_NO   AND  a.DOC_NO=c.DOC_NO AND b.ITEM_CODE=c.ITEM_CODE AND b.FACILITY_ID=c.FACILITY_ID AND b.DOC_NO=c.DOC_NO AND b.DOC_TYPE_CODE=c.DOC_TYPE_CODE AND b.DOC_SRL_NO=c.DOC_SRL_NO AND b.DOC_SRL_NO = ? AND  b.FACILITY_ID = ?  AND b.DOC_TYPE_CODE = ?  AND a.SALES_DOC_NO= ? GROUP BY  a.SALES_DOC_NO,c.BATCH_ID,b.ITEM_CODE,a.FACILITY_ID ,a.DOC_TYPE_CODE, c.BIN_LOCATION_CODE,c.EXPIRY_DATE_OR_RECEIPT_DATE " );
		dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_FOR_SAL_RET_SUM" , "SELECT a.FACILITY_ID FACILITY_ID ,a.SALES_DOC_NO SALES_DOC_NO,b.ITEM_CODE ITEM_CODE,SUM(c.ITEM_QTY) SUM_ITEM_QTY,c.BATCH_ID BATCH_ID,c.BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(c.EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy') EXPIRY_DATE_OR_RECEIPT_DATE FROM ST_SAL_RET_HDR   a ,  ST_SAL_RET_DTL  b , ST_SAL_RET_DTL_EXP  c  WHERE a.FACILITY_ID=b.FACILITY_ID AND b.FACILITY_ID=c.FACILITY_ID AND a.DOC_NO=b.DOC_NO   AND  a.DOC_NO=c.DOC_NO AND b.ITEM_CODE=c.ITEM_CODE AND b.FACILITY_ID=c.FACILITY_ID AND b.DOC_NO=c.DOC_NO AND b.DOC_TYPE_CODE=c.DOC_TYPE_CODE AND b.DOC_SRL_NO=c.DOC_SRL_NO  AND  b.FACILITY_ID = ?  AND b.DOC_TYPE_CODE = ?  AND a.SALES_DOC_NO= ?  AND b.ITEM_CODE = ? and c.BATCH_ID=?  and  c.EXPIRY_DATE_OR_RECEIPT_DATE =  to_date (?,'dd/mm/yyyy' )   and c.BIN_LOCATION_CODE=? GROUP BY  a.SALES_DOC_NO,c.BATCH_ID,b.ITEM_CODE,a.FACILITY_ID ,a.DOC_TYPE_CODE, c.BIN_LOCATION_CODE,c.EXPIRY_DATE_OR_RECEIPT_DATE " );
		dataMap.put("SQL_ST_SAL_RET_DTL_EXP_UPDATE_FOR_SAL_RET_NEW_QTY","UPDATE st_sal_dtl_exp SET ret_item_qty = ? , modified_by_id = ?, modified_date = SYSDATE,  modified_at_ws_no = ?,  modified_facility_id	= ? WHERE FACILITY_ID = ? AND DOC_NO = ? AND ITEM_CODE = ? AND BATCH_ID = ? AND BIN_LOCATION_CODE =  ? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'dd/mm/yyyy')");
		dataMap.put("SQL_ST_SAL_DTL_EXP_UPDATE_FOR_SAL_RET_QTY","SELECT  e.facility_id facility_id, e.doc_no sales_doc_no,e.item_code item_code, e.SAL_ITEM_QTY SAL_ITEM_QTY,e.batch_id batch_id, e.bin_location_code bin_location_code, TO_CHAR (e.expiry_date_or_receipt_date,'dd/mm/yyyy' ) expiry_date_or_receipt_date  FROM st_sal_hdr d,st_sal_dtl_exp e  WHERE  d.facility_id = e.facility_id  AND d.doc_type_code = e.doc_type_code  AND d.doc_no = e.doc_no   AND d.facility_id = ?  AND d.doc_type_code = ? AND d.doc_no = ?  AND e.item_code= ?");
		
		dataMap.put("SQL_ST_SAL_RET_HDR_DELETE_FOR_SAL_RET", "DELETE FROM st_sal_ret_hdr WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ? " );
		dataMap.put("SQL_ST_SAL_RET_DTL_DELETE_FOR_SAL_RET", "DELETE FROM st_sal_ret_dtl WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ?");
		dataMap.put("SQL_ST_SAL_RET_DTL_DELETE_ALL_FOR_SAL_RET", "DELETE FROM st_sal_ret_dtl WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ? ");
		dataMap.put("SQL_ST_SAL_RET_DTL_EXP_DELETE_FOR_SAL_RET", "DELETE FROM st_sal_ret_dtl_exp WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ? " );
		dataMap.put("SQL_ST_SAL_RET_DTL_EXP_DELETE_ALL_FOR_SAL_RET", "DELETE FROM st_sal_ret_dtl_exp WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ?  " );

		dataMap.put("SQL_ST_SAL_RET_HDR_UPDATE_FOR_SAL_RET",	"UPDATE st_sal_ret_hdr SET doc_ref = ? , finalized_yn = ? , remarks=?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ? ");
		dataMap.put("SQL_ST_SAL_RET_DTL_UPDATE_FOR_SAL_RET",	"UPDATE st_sal_ret_dtl SET item_qty = ? , item_unit_cost=? , item_cost_value=?,  remarks = ? , modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? WHERE facility_id = ?  AND doc_type_code = ?  AND doc_no = ? AND doc_srl_no = ? ");

		dataMap.put("SQL_ST_SAL_DTL_SELECT_UNIT_COST_FOR_SAL_RET",	"SELECT item_unit_cost FROM st_sal_dtl WHERE facility_id=? AND doc_type_code=? AND doc_no=? AND item_code=?");
		dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_TRADE_ID_FOR_SAL_RET",	"SELECT trade_id FROM ST_SAL_DTL_EXP WHERE facility_id=? AND doc_type_code=? AND doc_no=? AND store_code=? AND item_code=? AND batch_id=? AND bin_location_code=? AND TRUNC(expiry_date_or_receipt_date)=TRUNC(TO_DATE(?,'dd/mm/yyyy'))");

		dataMap.put("SQL_ST_SAL_RET_DTL_EXP_SELECT_FOR_BLOCK_REL",	"SELECT store_code, item_code, batch_id, bin_location_code, TO_CHAR(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, trade_id, sal_item_qty FROM st_sal_ret_dtl_exp WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? AND doc_srl_no LIKE ?");

        dataMap.put("SQL_ST_SAL_DTL_SELECT_SAL_RECORD_FOR_SAL_RET",	"SELECT facility_id, sal_doc_type_code, sal_doc_no, store_code, item_code, batch_id,  TO_CHAR(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date,item_qty FROM st_sal_ret_dtl_exp WHERE doc_no=?");
		dataMap.put("SQL_ST_SAL_DTL_EXP_UPDATE_FOR_SAL_RET_DELETE", "UPDATE st_sal_dtl_exp SET ret_item_qty = ( NVL(ret_item_qty,0) + ? ) , modified_by_id = ?,	 modified_date = SYSDATE,  modified_at_ws_no = ?,  modified_facility_id	= ? WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND STORE_CODE = ? AND ITEM_CODE = ? AND BATCH_ID = ? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'dd/mm/yyyy')" ) ;
		dataMap.put("SQL_ST_RECORDS_PER_TRN_SELECT", "SELECT RECORDS_PER_TRN FROM ST_TRN_TYPE WHERE TRN_TYPE=?" ) ;
		//dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_SAL_RET_QTY_CHK",	"SELECT SAL_ITEM_QTY,RET_ITEM_QTY FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = ?  AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND ITEM_CODE = ? AND BATCH_ID = ?  AND BIN_LOCATION_CODE = ? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_dATE(?,'DD/MM/YYYY')");
		//dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_SAL_RET_QTY_CHK",	"SELECT SAL_ITEM_QTY,RET_ITEM_QTY FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = ?  AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND DOC_SRL_NO = ? AND ITEM_CODE = ? AND BATCH_ID = ?  AND BIN_LOCATION_CODE = ? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_dATE(?,'DD/MM/YYYY') ");
		//Modified by suresh.r on 14-08-2014 against AAKH-SCF-0129
		dataMap.put("SQL_ST_SAL_DTL_EXP_SELECT_SAL_RET_QTY_CHK",	"SELECT NVL(SUM(SAL_ITEM_QTY),0) SAL_ITEM_QTY, NVL(SUM(RET_ITEM_QTY),0) RET_ITEM_QTY FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = ?  AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND DOC_SRL_NO = ? AND ITEM_CODE = ? AND BATCH_ID = ?  AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_dATE(?,'DD/MM/YYYY') ");
		//Added by suresh.r on 03-01-2014 against KDAH for update batch_cost into st_batch_control beg
		dataMap.put("SQL_ST_ITEM_BATCH_SELECT_QTY_ONHAND",	"SELECT qty_on_hand  FROM st_item_batch WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= to_date(?,'dd/mm/yyyy')");
		dataMap.put("SQL_ST_BATCH_CONTROL_SELECT_BATCH_COST",	"SELECT  batch_cost FROM st_batch_control  WHERE  item_code = ?	AND	batch_id = ?  AND  trunc(expiry_date_or_receipt_date)	= to_date(?,'dd/mm/yyyy')");
		dataMap.put("SQL_ST_BATCH_CONTROL_UPDATE_FOR_BATCH_COST",	"UPDATE st_batch_control SET batch_cost = ? , last_batch_cost = ? , last_batch_cost_date = sysdate , modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id = ? WHERE  item_code = ?	AND	batch_id = ?  AND  trunc(expiry_date_or_receipt_date)	= to_date(?,'dd/mm/yyyy')");
		//Added by suresh.r on 03-01-2014 against KDAH for update batch_cost into st_batch_control end
		//Added by suresh.r on 28-01-2014 against AMS-CRF-054 beg
		dataMap.put("SQL_ST_CHECK_SAME_BATCH_DIFF_ORGISS_DOCNO_EXISTS",	"SELECT COUNT(1) CNT FROM st_issue_ret_dtl_exp WHERE facility_id = ? AND doc_type_code = ? AND doc_no = ? AND store_code = ? AND item_code = ? AND batch_id = ? AND TRUNC(expiry_date_or_receipt_date)=TO_DATE(?,'dd/mm/yyyy') AND to_bin_location_code = ?");
		dataMap.put("SQL_ST_ISSUE_RETURN_DTL_EXP_SELECT_FOR_BLOCK_REL_DEL",	"SELECT store_code, item_code, batch_id, bin_location_code, TO_CHAR(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, trade_id, item_qty FROM st_issue_ret_dtl_exp WHERE  facility_id=? AND  doc_type_code =? AND doc_no=? AND doc_srl_no LIKE ?");
		//Added by suresh.r on 28-01-2014 against AMS-CRF-054 end
	}
}
