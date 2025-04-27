/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;

import eCommon.Common.*;
import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.util.*;
import java.sql.* ;

public class AdjustStockDetailBean extends StTransaction implements Serializable
{
   private String doc_srl_no	="";
   private String item_code	="";
   private String item_desc = "";
   private String adj_item_qty="";
   private String item_unit_cost="";
   private String item_cost_value="";
   private String remarks="";
   private String stock_uom_code="";
   private ArrayList ALDtl=new ArrayList();
   private int nextDocSerialNo	=	0;
   private String finalized_yn  = "Y";
   private String records_to_delete;
   private String adjustment_type="P";

	public int getNextDocSerialNo(){
		nextDocSerialNo = nextDocSerialNo + 1;
		return nextDocSerialNo;
	}

	public void setNextDocSerialNo(int maxRec){
		nextDocSerialNo=maxRec;
	}


	public void setDoc_srl_no(String doc_srl_no) {
		 this.doc_srl_no= doc_srl_no;
	}
	public String getDoc_srl_no() {
		 return doc_srl_no;
	}

	public void setItem_code(String item_code) {
		 this.item_code= item_code;
	}
	public String getItem_code() {
		 return item_code;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc= item_desc;
	}
	public String getItem_desc() {
		 return item_desc;
	}

	public void setAdj_item_qty(String adj_item_qty) {
		 this.adj_item_qty = adj_item_qty;
	}
	public String getAdj_item_qty() {
		 return adj_item_qty;
	}


	public void setItem_unit_cost(String item_unit_cost) {
		 //this.item_unit_cost = setNumber(item_unit_cost,3);
		 this.item_unit_cost = item_unit_cost;
	}
	public String getItem_unit_cost() {
		 return item_unit_cost;
	}


	public void setItem_cost_value(String item_cost_value) {
		 //this.item_cost_value = setNumber(item_cost_value, 3);
		 this.item_cost_value = item_cost_value;
	}
	public String getItem_cost_value() {
		 return item_cost_value;
	}


	public void setRemarks(String remarks) {
		 this.remarks = remarks;
	}
	public String getRemarks() {
		 return remarks;
	}
   
   public void setRecords_to_delete(String s)
    {
        records_to_delete = s;
    }
   public String getRecords_to_delete()
    {
        return records_to_delete;
    }

	public void setStock_uom_code(String stock_uom_code) {
		 this.stock_uom_code = stock_uom_code;
	}
	public String getStock_uom_code() {
		 return stock_uom_code;
	}

	public void setFinalized_yn (String p_finalized_yn) {
		finalized_yn = p_finalized_yn;
	}

	public String getFinalized_yn() {
		return finalized_yn;
	}

	public void setAdjustment_type(String adjustment_type) {
		 this.adjustment_type = adjustment_type;
	}
	public String getAdjustment_type() {
		 return adjustment_type;
	}


    public void clear()
    {
        super.clear();
		doc_srl_no="";     
		item_code="";      
		item_desc="";      
		adj_item_qty="";   
		item_unit_cost=""; 
		item_cost_value="";
		remarks="";   
		records_to_delete="";
		adjustment_type="";
    }

	public  void setValues(HashMap StDtl)
	{
			String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");


		if (!(StDtl.get("doc_srl_no").equals("-1"))){
			mode	=	(String)StDtl.get("mode");
		}

		StDtl.put("mode",mode);


		if(StDtl.get("doc_srl_no").equals("-1")){
		  StDtl.put("doc_srl_no","" + getNextDocSerialNo());
		  ALDtl.add(StDtl);
  		 

		}else {


			for (int i=0;i<ALDtl.size() ;i++ ) {
				if (((HashMap)ALDtl.get(i)).get("doc_srl_no").equals(StDtl.get("doc_srl_no"))) {
//					StDtl.put("mode",mode);	
					ALDtl.set(i,StDtl);
					break;
				}
			}
		}

        
	}

	public ArrayList toArrayList(){



		return ALDtl;
	}

	public HashMap getValues(String doc_srl_no) {


		for (int i=0;i<ALDtl.size() ;i++ ) {
			if (((HashMap)ALDtl.get(i)).get("doc_srl_no").equals(doc_srl_no)) {
 				/* @Name - Priya
				* @Date - 18/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - "mm_trn_qty" & "adj_item_qty" Integer is changed to Double.
				*/
			if(Double.parseDouble(((String)((HashMap)ALDtl.get(i)).get("adj_item_qty")))<0){
			HashMap h=(HashMap)ALDtl.get(i);
			h.put("adj_item_qty",Double.parseDouble(((String)h.get("adj_item_qty")))*(-1)+"");
			h.put("mm_trn_qty",Double.parseDouble(((String)h.get("mm_trn_qty")))*(-1)+"");
			h.put("item_cost_value",Double.parseDouble(((String)h.get("item_cost_value")))*(-1)+"");
			ALDtl.set(i,h);
			}

				return (HashMap)ALDtl.get(i);
			}
		}
		return null;
	}
	 
	public void setAll(Hashtable hashtable) {
        super.setAll(hashtable);

	    setRecords_to_delete((String)hashtable.get("records_to_delete"));
		setFinalized_yn((String)hashtable.get("finalized"));
    }

	//to get item details

	public HashMap getItemDetail( String item_code) {
		HashMap hmRecord=new HashMap();
		try {
			hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAILS"),item_code);
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		return hmRecord;		
	}

	public void loadAllItemData(String doc_type_code, String doc_no,String language_id,String facility_id) throws Exception {

	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList DataList = new ArrayList();

		try {
			connection = getConnection() ;
			
			//pstmt = connection.prepareStatement("SELECT   STITM.STORE_CODE, ST.DOC_SRL_NO, ST.ITEM_CODE, (CASE WHEN ST.ADJ_ITEM_QTY < 0 THEN (-1 * ST.ADJ_ITEM_QTY) ELSE ST.ADJ_ITEM_QTY END ) ADJ_ITEM_QTY, ST.ITEM_UNIT_COST, (CASE WHEN ST.ITEM_COST_VALUE < 0 THEN (-1 *  ST.ITEM_COST_VALUE) ELSE ST.ITEM_COST_VALUE END ) ITEM_COST_VALUE,trim(st_display_unit_cost(st.item_code)) item_unit_cost_org, ST.REMARKS REMARKS_CODE, MM_REM.REMARKS_DESC REMARKS, MM.SHORT_DESC ITEM_DESC, MM.GEN_UOM_CODE STOCK_UOM_CODE, AM_UOM.SHORT_DESC UOM, ST_ITEM.EXPIRY_YN, ST_ITEM.BATCH_ID_APPLICABLE_YN, ST_ITEM.TRADE_ID_APPLICABLE_YN, STITM.MIN_STK_QTY, STITM.MAX_STK_QTY, (  SUM (NVL(STBT.QTY_ON_HAND,0) - NVL (COMMITTED_QTY, 0)) + (CASE WHEN ST.ITEM_ADJ_TYPE = 'N' THEN (-1 * NVL(ST.ADJ_ITEM_QTY,0)) ELSE 0 END) ) AVAILABLE_QTY, ST.ITEM_ADJ_TYPE,ALLOW_DECIMALS_YN FROM ST_ADJ_DTL ST, MM_ITEM_LANG_VW MM,ST_ITEM, AM_UOM_LANG_VW AM_UOM,ST_ITEM_STORE STITM,ST_ADJ_HDR STHDR,   ST_ITEM_BATCH STBT, MM_TRN_REMARKS_LANG_VW MM_REM WHERE ST.ITEM_CODE = MM.ITEM_CODE AND ST.ITEM_CODE = ST_ITEM.ITEM_CODE AND MM.GEN_UOM_CODE = AM_UOM.UOM_CODE AND ST.DOC_NO = STHDR.DOC_NO AND ST.DOC_TYPE_CODE = STHDR.DOC_TYPE_CODE AND ST.FACILITY_ID = STHDR.FACILITY_ID AND STITM.ITEM_CODE = ST.ITEM_CODE AND STITM.STORE_CODE = STHDR.STORE_CODE AND ST.FACILITY_ID = ? AND ST.DOC_TYPE_CODE = ? AND ST.DOC_NO = ? AND STBT.ITEM_CODE(+) = STITM.ITEM_CODE AND STBT.STORE_CODE(+) = STITM.STORE_CODE AND MM.LANGUAGE_ID = AM_UOM.LANGUAGE_ID AND MM.LANGUAGE_ID = ? AND MM_REM.LANGUAGE_ID = MM.LANGUAGE_ID AND ST.REMARKS = MM_REM.TRN_REMARKS_CODE AND (USE_AFTER_EXPIRY_YN = 'N'       OR (    EXPIRY_YN = 'Y' AND (   USE_AFTER_EXPIRY_YN = 'Y' OR EXPIRY_DATE_OR_RECEIPT_DATE >= TRUNC (SYSDATE) ))) GROUP BY ST.DOC_SRL_NO, ST.ITEM_CODE,ST.ADJ_ITEM_QTY, ST.ITEM_UNIT_COST, ST.ITEM_COST_VALUE,ST.REMARKS, MM.SHORT_DESC,MM.GEN_UOM_CODE,AM_UOM.SHORT_DESC , ST_ITEM.EXPIRY_YN,ST_ITEM.BATCH_ID_APPLICABLE_YN,ST_ITEM.TRADE_ID_APPLICABLE_YN,STITM.MIN_STK_QTY,STITM.MAX_STK_QTY,STITM.QTY_ON_HAND,STITM.STORE_CODE,MM_REM.REMARKS_DESC,ST.ITEM_ADJ_TYPE,ALLOW_DECIMALS_YN ORDER BY DOC_SRL_NO") ;
			//Modified by suresh.r on 13-11-2014 against Inc 52256(Added 2 args to ST_DISPLAY_UNIT_COST)
			pstmt = connection.prepareStatement("SELECT   STITM.STORE_CODE, ST.DOC_SRL_NO, ST.ITEM_CODE, (CASE WHEN ST.ADJ_ITEM_QTY < 0 THEN (-1 * ST.ADJ_ITEM_QTY) ELSE ST.ADJ_ITEM_QTY END ) ADJ_ITEM_QTY, ST.ITEM_UNIT_COST, (CASE WHEN ST.ITEM_COST_VALUE < 0 THEN (-1 *  ST.ITEM_COST_VALUE) ELSE ST.ITEM_COST_VALUE END ) ITEM_COST_VALUE,trim(st_display_unit_cost(st.item_code,SYSDATE,'CURRENT_STOCK')) item_unit_cost_org, ST.REMARKS REMARKS_CODE, MM_REM.REMARKS_DESC REMARKS, MM.SHORT_DESC ITEM_DESC, MM.GEN_UOM_CODE STOCK_UOM_CODE, AM_UOM.SHORT_DESC UOM, ST_ITEM.EXPIRY_YN, ST_ITEM.BATCH_ID_APPLICABLE_YN, ST_ITEM.TRADE_ID_APPLICABLE_YN, STITM.MIN_STK_QTY, STITM.MAX_STK_QTY, (  SUM (NVL(STBT.QTY_ON_HAND,0) - NVL (COMMITTED_QTY, 0)) + (CASE WHEN ST.ITEM_ADJ_TYPE = 'N' THEN (-1 * NVL(ST.ADJ_ITEM_QTY,0)) ELSE 0 END) ) AVAILABLE_QTY, ST.ITEM_ADJ_TYPE,ALLOW_DECIMALS_YN FROM ST_ADJ_DTL ST, MM_ITEM_LANG_VW MM,ST_ITEM, AM_UOM_LANG_VW AM_UOM,ST_ITEM_STORE STITM,ST_ADJ_HDR STHDR,   ST_ITEM_BATCH STBT, MM_TRN_REMARKS_LANG_VW MM_REM WHERE ST.ITEM_CODE = MM.ITEM_CODE AND ST.ITEM_CODE = ST_ITEM.ITEM_CODE AND MM.GEN_UOM_CODE = AM_UOM.UOM_CODE AND ST.DOC_NO = STHDR.DOC_NO AND ST.DOC_TYPE_CODE = STHDR.DOC_TYPE_CODE AND ST.FACILITY_ID = STHDR.FACILITY_ID AND STITM.ITEM_CODE = ST.ITEM_CODE AND STITM.STORE_CODE = STHDR.STORE_CODE AND ST.FACILITY_ID = ? AND ST.DOC_TYPE_CODE = ? AND ST.DOC_NO = ? AND STBT.ITEM_CODE(+) = STITM.ITEM_CODE AND STBT.STORE_CODE(+) = STITM.STORE_CODE AND MM.LANGUAGE_ID = AM_UOM.LANGUAGE_ID AND MM.LANGUAGE_ID = ? AND MM_REM.LANGUAGE_ID = MM.LANGUAGE_ID AND ST.REMARKS = MM_REM.TRN_REMARKS_CODE AND (USE_AFTER_EXPIRY_YN = 'N'       OR (    EXPIRY_YN = 'Y' AND (   USE_AFTER_EXPIRY_YN = 'Y' OR EXPIRY_DATE_OR_RECEIPT_DATE >= TRUNC (SYSDATE) ))) GROUP BY ST.DOC_SRL_NO, ST.ITEM_CODE,ST.ADJ_ITEM_QTY, ST.ITEM_UNIT_COST, ST.ITEM_COST_VALUE,ST.REMARKS, MM.SHORT_DESC,MM.GEN_UOM_CODE,AM_UOM.SHORT_DESC , ST_ITEM.EXPIRY_YN,ST_ITEM.BATCH_ID_APPLICABLE_YN,ST_ITEM.TRADE_ID_APPLICABLE_YN,STITM.MIN_STK_QTY,STITM.MAX_STK_QTY,STITM.QTY_ON_HAND,STITM.STORE_CODE,MM_REM.REMARKS_DESC,ST.ITEM_ADJ_TYPE,ALLOW_DECIMALS_YN ORDER BY DOC_SRL_NO") ;
			pstmt.setString( 1, facility_id ) ;
			pstmt.setString( 2, doc_type_code ) ;
			pstmt.setString( 3, doc_no ) ;
			pstmt.setString( 4, language_id ) ;

		//String item_adj_type_qty="";

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
				dataRow.put("doc_srl_no",resultSet.getString("doc_srl_no")) ;
				dataRow.put("doc_type_code",doc_type_code) ;
				dataRow.put("doc_no",doc_no);
				dataRow.put("item_code",resultSet.getString("item_code")) ;
				dataRow.put("item_desc",resultSet.getString("item_desc")) ;
			//	if(resultSet.getString("item_adj_type").equals("P")){
				dataRow.put("adj_item_qty",resultSet.getString("adj_item_qty")) ;
				dataRow.put("item_cost_value",resultSet.getString("item_cost_value")) ;
			//	item_adj_type_qty=resultSet.getString("adj_item_qty");
			//	}else{
				//dataRow.put("adj_item_qty",Integer.parseInt(resultSet.getString("adj_item_qty"))*(-1)+"") ;
				//dataRow.put("item_cost_value",Double.parseDouble(resultSet.getString("item_cost_value"))*(-1)+"") ;
			//	item_adj_type_qty=Integer.parseInt(resultSet.getString("adj_item_qty"))*(-1)+"";
			//	}
				
				//Added against inc#50616 to set base unit cost 
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
				double item_cost_value_new=( ((Double.parseDouble((String)resultSet.getString("adj_item_qty"))))*Double.parseDouble((String) resultSet.getString("item_unit_cost_org"))*getConvFactTemp((String)resultSet.getString("item_code"),(String)resultSet.getString("store_code")));
				dataRow.put("item_cost_value",setNumber(""+item_cost_value_new,noOfDecimalsForCost)) ;

				double item_unit_cost_new=( Double.parseDouble((String) resultSet.getString("item_unit_cost_org"))*getConvFactTemp((String)resultSet.getString("item_code"),(String)resultSet.getString("store_code")));
				dataRow.put("item_unit_cost",setNumber(""+item_unit_cost_new,noOfDecimalsForCost)) ;
				//Added ends

				//dataRow.put("item_unit_cost",(String)resultSet.getString("item_unit_cost")) ;
				dataRow.put("item_unit_cost_org",resultSet.getString("item_unit_cost_org")) ;
				dataRow.put("remarks",checkForNull(resultSet.getString("remarks"))) ;
				dataRow.put("remarks_code",checkForNull(resultSet.getString("remarks_code"))) ;
				dataRow.put("stock_uom_code",resultSet.getString("stock_uom_code")) ;
				dataRow.put("uom",resultSet.getString("uom")) ;
				dataRow.put("trade_id_applicable_yn",resultSet.getString("trade_id_applicable_yn")) ;
				dataRow.put("batch_id_applicable_yn",resultSet.getString("batch_id_applicable_yn")) ;
				dataRow.put("expiry_yn",resultSet.getString("expiry_yn")) ;
				dataRow.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ;
				dataRow.put("min_stk_qty",resultSet.getString("min_stk_qty")) ;
				dataRow.put("max_stk_qty",resultSet.getString("max_stk_qty")) ;
				dataRow.put("dec_allowed_yn",resultSet.getString("allow_decimals_yn")) ;
				

				String avilableQTY	=getAvailableQty (resultSet.getString("item_code"),resultSet.getString("store_code"));
				if(((String)resultSet.getString("item_adj_type")).equals("N")){
				/* @Name - Priya
				* @Date - 18/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - "avilableQTY" & "adj_item_qty" Integer is changed to Double.
				*/
				dataRow.put("avl_qty",Double.parseDouble(checkForNull(avilableQTY,"0"))+Double.parseDouble((String)resultSet.getString("adj_item_qty"))+"") ;
			
				}else{
				dataRow.put("avl_qty",avilableQTY) ;
				}
				
				dataRow.put("language_id",language_id) ;
				/* @Name - Priya
				* @Date - 18/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - "mm_trn_qty" & "adj_item_qty" Integer is changed to Double.
				*/
				double mm_trn_qty =(Double.parseDouble(resultSet.getString("adj_item_qty")))*((double)getConvFactTemp((String)resultSet.getString("item_code"),(String)resultSet.getString("store_code")));
				dataRow.put("mm_trn_qty",""+mm_trn_qty);
				dataRow.put("adjustment_type",resultSet.getString("item_adj_type"));
				DataList.add(dataRow);
			
			}						
			
			// Initializing the All detail array list.

			ALDtl = DataList;
System.out.println("ALDtl in detail bean"+ALDtl);


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
public String getAvailableQty(String item_code,String store_code) throws Exception {
		String[] param = new String[7];
		param[0] = item_code;
		param[1] = store_code;
		param[2] = "0";
		param[3] = "N";
		param[4] = "";
		param[5] = "";
		param[6] = "";
		java.util.HashMap stockValues = getStockAvailabilityStatus(param);
		return (String) stockValues.get("available_stock");
	}



 }
