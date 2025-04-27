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
21/04/2014				48674			        Suresh R           21/04/2014        Suresh R     Return Reject Confirmation Changes
??
23/05/2016				64266					Badmavathi B										KDAH-SCF-0433
03/06/2018              IN:069375               B Haribabu         03/06/2018        B Haribabu   KDAH-CRF-0514.1
2/11/2021				TFS-12775				Shazana				3/11/2021		Manickam		PMG2021-MOHE-CRF-0001
24/2/2021				TFS-14966				Shazana				24/2/2021						PMG2021-MOHE-CRF-0001
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST.Acknowledgment;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Properties;
import java.util.ArrayList;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="Acknowledgment"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Acknowledgment"
*	local-jndi-name="Acknowledgment"
*	impl-class-name="eST.Acknowledgment.AcknowledgmentManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.Acknowledgment.AcknowledgmentLocal"
*	remote-class="eST.Acknowledgment.AcknowledgmentRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.Acknowledgment.AcknowledgmentLocalHome"
*	remote-class="eST.Acknowledgment.AcknowledgmentHome"
*	generate= "local,remote"
*
*
*/

public class AcknowledgmentManager extends StEJBSessionAdapter{
	//
	//Name - Mahesh
	// Date - 21/01/2010
	// Inc# - IN015496
	// Desc - Double.parseDouble is used where quantities are been used.
	
	HashMap hmSQL;
	HashMap hmReturn;
	HashMap hmData;
	String stSQL;
	Connection connection = null;
	Properties properties = null;
	String adj_doc_type_code = "";
					
    public AcknowledgmentManager(){}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete(HashMap hashmap, HashMap hashmap1)
    {
        return getMessageHashMap(false);
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert(HashMap hmData, HashMap hmSQL1){
        HashMap hashmapHDrdata	= new HashMap();
        HashMap hashmapHDrquery = new HashMap();
        HashMap hashmapResult	= new HashMap();
        HashMap hashmapDtldata	= new HashMap();
        HashMap hashmapDtlquery = new HashMap();
        HashMap hmModDtlData	= new HashMap();
        HashMap hmModDtlQuery	= new HashMap();
        HashMap hmModHdrData	= new HashMap();
        HashMap hmModHdrQuery	= new HashMap();
		ArrayList alAdjHdrData	= new ArrayList();
		ArrayList alAdjDtlData	= new ArrayList();
		ArrayList alAdjExpData	= new ArrayList();
		ArrayList alDtlRecords	= (ArrayList)hmData.get("DTL_DATA");
		ArrayList alCommonData	= (ArrayList)hmData.get("COMMON_DATA");
		ArrayList allanguageData= (ArrayList)hmData.get("LANGUAGE_DATA");
		//String adjHdrInsertSql  = "INSERT	INTO ST_ADJ_HDR(FACILITY_ID, DOC_TYPE_CODE,	DOC_NO,	DOC_DATE,DOC_REF, STORE_CODE, AUTHORIZED_BY_ID, FINALIZED_YN,GL_INTERFACED_YN, TRN_TYPE, SALE_TO_EXT_YN, EXT_AGENCY_NAME,ITEM_CLASS_CODE,INTERNAL_ADJ_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		hmSQL = hmSQL1;
		//System.out.println("AcknowledgementManager.java,hmSQL 1 = > "+hmSQL);
		hmSQL.put("adjHdrInsertSql","INSERT	INTO ST_ADJ_HDR(FACILITY_ID, DOC_TYPE_CODE,	DOC_NO,	DOC_DATE,DOC_REF, STORE_CODE, AUTHORIZED_BY_ID, FINALIZED_YN,GL_INTERFACED_YN, TRN_TYPE, SALE_TO_EXT_YN, EXT_AGENCY_NAME,ITEM_CLASS_CODE,INTERNAL_ADJ_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		//System.out.println("AcknowledgementManager.java,hmSQL 2 = > "+hmSQL);
        hashmapResult.put("result", FALSE);
        try
        {
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
            ArrayList arraylistHdrData = (ArrayList)hmData.get("ACK_HDR_DATA");
			ArrayList arraylistDtlData = (ArrayList)hmData.get("ACK_DTL_DATA");
			ArrayList alModHdrData = (ArrayList)hmData.get("ACK_HDR_MOD_DATA");
			ArrayList alModDtlData = (ArrayList)hmData.get("ACK_DTL_MOD_DATA");
			
			/**
			 * @Name - Priya
			 * @Date - 03/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));

			if(alDtlRecords.size()>0){
				if(alCommonData.get(4).equals("TFR"))
					hashmapResult = modifyStockTransfer(hmData,hmSQL);
				else if(alCommonData.get(4).equals("URG")||alCommonData.get(4).equals("ISS"))
					hashmapResult = updateIssue(hmData,hmSQL);
				else if(alCommonData.get(4).equals("RET"))
					hashmapResult = updateIssueReturn(hmData,hmSQL);
				throwExceptionWhenFailed(hashmapResult);
				if(alModHdrData.size()>0){
					for(int i=0;i<alModHdrData.size();i++){
						if(((String)((ArrayList)alModHdrData.get(i)).get(3)).equals("Y"))
							continue;
						int k		= 0;
						int count	= 0;
						if(((String)((ArrayList)alModHdrData.get(i)).get(3)).equals(com.ehis.util.DateUtils.getCurrentDate("DMY","en")) && ((String)((ArrayList)alModHdrData.get(i)).get(2)).equals("Y"))
							count = Integer.parseInt((String)((HashMap)fetchRecord(connection,"SELECT COUNT(*) COUNT FROM ST_ACKNOWLEDGE_TRN_DTL WHERE DOC_NO = ? AND NVL(TMP_REJECTED_QTY_2,0) > 0",(String)((ArrayList)alModHdrData.get(i)).get(7))).get("COUNT"));
						if(count>0){
							String doc_no		=	"";
							String item_code	=	"";
							ArrayList alParam	=	new ArrayList();
							alParam.add((String)((ArrayList)alModHdrData.get(i)).get(8));
							alParam.add((String)((ArrayList)alModHdrData.get(i)).get(7));
							alParam.add((String)((ArrayList)alModHdrData.get(i)).get((((ArrayList)alModHdrData.get(i)).size())-1));
							//ArrayList alList = fetchRecords(connection,"SELECT STIST.QTY_ON_HAND,STIST.ITEM_VALUE,HDR.ISSUING_STORE STORE_CODE,DTL.FACILITY_ID, DTL.DOC_TYPE_CODE, DTL.DOC_NO, DTL.DOC_SRL_NO, DTL.DOC_DATE,BATCH_ID, TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID, DTL.ITEM_CODE, ISSUE_QTY,RECEIVED_QTY,STIST.STOCK_ITEM_YN,ISSUING_STORE STORE_CODE,STIST.DEF_ISSUE_UOM UOM_CODE,ROUND ((DECODE (STIST.QTY_ON_HAND, 0, 0, STIST.ITEM_VALUE)/ DECODE (STIST.QTY_ON_HAND,0, 1,STIST.QTY_ON_HAND)),3) ITEM_UNIT_COST,DTL.BIN_LOCATION_CODE,NVL(TMP_REJECTED_QTY_2,0) ITEM_QTY FROM ST_ACKNOWLEDGE_TRN_DTL DTL,ST_ACKNOWLEDGE_TRN_HDR HDR,ST_ITEM_STORE STIST WHERE DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND NVL(TMP_REJECTED_QTY_2,0) > 0 AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DTL.DOC_NO = HDR.DOC_NO AND DTL.FACILITY_ID = HDR.FACILITY_ID AND STIST.STORE_CODE = HDR.ISSUING_STORE AND STIST.ITEM_CODE = DTL.ITEM_CODE AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.SEQ_NO  = ? ORDER BY DOC_SRL_NO",alParam);
							/**
							 * @Name - Priya
							 * @Date - 03/06/2010
							 * @Inc# - 
							 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' the above query is modified 
							 */
							 //Added by suresh.r on 21-04-2014 against #Inc 48674 beg
							//ArrayList alList = fetchRecords(connection,"SELECT STIST.QTY_ON_HAND,STIST.ITEM_VALUE,HDR.ISSUING_STORE STORE_CODE,DTL.FACILITY_ID, DTL.DOC_TYPE_CODE, DTL.DOC_NO, DTL.DOC_SRL_NO, DTL.DOC_DATE,BATCH_ID, TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID, DTL.ITEM_CODE, ISSUE_QTY,RECEIVED_QTY,STIST.STOCK_ITEM_YN,ISSUING_STORE STORE_CODE,STIST.DEF_ISSUE_UOM UOM_CODE,TRIM(ST_DISPLAY_COST_DECIMALS (STIST.ITEM_CODE, STIST.STORE_CODE ))  ITEM_UNIT_COST , DTL.BIN_LOCATION_CODE, NVL(TMP_REJECTED_QTY_2,0) ITEM_QTY FROM ST_ACKNOWLEDGE_TRN_DTL DTL,ST_ACKNOWLEDGE_TRN_HDR HDR,ST_ITEM_STORE STIST WHERE DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND NVL(TMP_REJECTED_QTY_2,0) > 0 AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DTL.DOC_NO = HDR.DOC_NO AND DTL.FACILITY_ID = HDR.FACILITY_ID AND STIST.STORE_CODE = HDR.ISSUING_STORE AND STIST.ITEM_CODE = DTL.ITEM_CODE AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.SEQ_NO  = ? ORDER BY DOC_SRL_NO",alParam);
							ArrayList alList =new ArrayList();
							if(alCommonData.get(4).equals("RET")){
								 alList = fetchRecords(connection,"SELECT STIST.QTY_ON_HAND,STIST.ITEM_VALUE,HDR.ISSUING_STORE STORE_CODE,DTL.FACILITY_ID, DTL.DOC_TYPE_CODE, DTL.DOC_NO, DTL.DOC_SRL_NO, DTL.DOC_DATE,BATCH_ID, TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID, DTL.ITEM_CODE, ISSUE_QTY,RECEIVED_QTY,STIST.STOCK_ITEM_YN,ISSUING_STORE STORE_CODE,STIST.DEF_ISSUE_UOM UOM_CODE,TRIM(ST_DISPLAY_COST_DECIMALS (STIST.ITEM_CODE, STIST.STORE_CODE ))  ITEM_UNIT_COST , DTL.BIN_LOCATION_CODE, NVL(TMP_REJECTED_QTY_2,0) ITEM_QTY FROM ST_ACKNOWLEDGE_TRN_DTL DTL,ST_ACKNOWLEDGE_TRN_HDR HDR,ST_ITEM_STORE STIST WHERE DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND NVL(TMP_REJECTED_QTY_2,0) > 0 AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DTL.DOC_NO = HDR.DOC_NO AND DTL.FACILITY_ID = HDR.FACILITY_ID AND STIST.STORE_CODE = HDR.ISSUING_STORE AND STIST.ITEM_CODE = DTL.ITEM_CODE AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.SEQ_NO  = ? ORDER BY DTL.ITEM_CODE",alParam);
							}else{
								 alList = fetchRecords(connection,"SELECT STIST.QTY_ON_HAND,STIST.ITEM_VALUE,HDR.ISSUING_STORE STORE_CODE,DTL.FACILITY_ID, DTL.DOC_TYPE_CODE, DTL.DOC_NO, DTL.DOC_SRL_NO, DTL.DOC_DATE,BATCH_ID, TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID, DTL.ITEM_CODE, ISSUE_QTY,RECEIVED_QTY,STIST.STOCK_ITEM_YN,ISSUING_STORE STORE_CODE,STIST.DEF_ISSUE_UOM UOM_CODE,TRIM(ST_DISPLAY_COST_DECIMALS (STIST.ITEM_CODE, STIST.STORE_CODE ))  ITEM_UNIT_COST , DTL.BIN_LOCATION_CODE, NVL(TMP_REJECTED_QTY_2,0) ITEM_QTY FROM ST_ACKNOWLEDGE_TRN_DTL DTL,ST_ACKNOWLEDGE_TRN_HDR HDR,ST_ITEM_STORE STIST WHERE DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND NVL(TMP_REJECTED_QTY_2,0) > 0 AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DTL.DOC_NO = HDR.DOC_NO AND DTL.FACILITY_ID = HDR.FACILITY_ID AND STIST.STORE_CODE = HDR.ISSUING_STORE AND STIST.ITEM_CODE = DTL.ITEM_CODE AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.SEQ_NO  = ? ORDER BY DOC_SRL_NO",alParam);
							}
							//Added by suresh.r on 21-04-2014 against #Inc 48674 end
							adj_doc_type_code = (String)fetchRecord(connection, "SELECT DEF_ADJ_DOC_TYPE_CODE DOC_TYPE_CODE FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ? AND MATERIAL_GROUP_CODE = 'ALL'", (String)alCommonData.get(2)).get("DOC_TYPE_CODE");
							for(int j=0;j<alList.size();j++){
								HashMap hMap = (HashMap)alList.get(j);
								if(!(doc_no.equals((String)hMap.get("DOC_NO")))){
									ArrayList alAdjHdrTmpData = new ArrayList();
									alAdjHdrTmpData.add(alCommonData.get(2));
									alAdjHdrTmpData.add(adj_doc_type_code);
									alAdjHdrTmpData.add((String)fetchRecord(connection, (String)hmSQL.get("sql_sy_acc_entity_doc_type_select"), adj_doc_type_code).get("NEXT_DOC_NO"));
									alAdjHdrTmpData.add(com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
									alAdjHdrTmpData.add("");
									alAdjHdrTmpData.add((String)hMap.get("STORE_CODE"));
									alAdjHdrTmpData.add("");
									alAdjHdrTmpData.add("Y");
									alAdjHdrTmpData.add("N");
									alAdjHdrTmpData.add("ADJ");
									alAdjHdrTmpData.add("N");
									alAdjHdrTmpData.add("");
									alAdjHdrTmpData.add("");
									alAdjHdrTmpData.add("Y");//Internal Adj
									alAdjHdrTmpData.add(alCommonData.get(0));
									alAdjHdrTmpData.add(alCommonData.get(1));
									alAdjHdrTmpData.add(alCommonData.get(2));
									alAdjHdrTmpData.add(alCommonData.get(0));
									alAdjHdrTmpData.add(alCommonData.get(1));
									alAdjHdrTmpData.add(alCommonData.get(2));
									alAdjHdrData.add(alAdjHdrTmpData);
								}
								if(!(item_code.equals((String)hMap.get("ITEM_CODE")))){
									HashMap hmDtlTmpData = new HashMap();
									alParam = new ArrayList();
									alParam.add((String)hMap.get("ITEM_CODE"));
									alParam.add((String)hMap.get("DOC_NO"));
									alParam.add((String)hMap.get("DOC_TYPE_CODE"));
									alParam.add((String)hMap.get("FACILITY_ID"));
									double mm_trn_qty = Double.parseDouble((String)fetchRecord(connection, "SELECT SUM(NVL(TMP_REJECTED_QTY_2,0)) ITEM_QTY FROM ST_ACKNOWLEDGE_TRN_DTL, ST_ACC_ENTITY_PARAM PA WHERE ITEM_CODE = ? AND DOC_NO = ? AND DOC_TYPE_CODE = ? AND ((PA.TRN_ACROSS_FACILITY_YN = 'Y') OR FACILITY_ID = ?)", alParam).get("ITEM_QTY"));
									double adj_item_qty = mm_trn_qty/(getConvFactTemp((String)hMap.get("ITEM_CODE"),(String)hMap.get("STORE_CODE"),hmSQL,(String)allanguageData.get(0),properties));
									hmDtlTmpData.put("item_code",(String)hMap.get("ITEM_CODE"));
									hmDtlTmpData.put("store_code",(String)hMap.get("STORE_CODE"));
									hmDtlTmpData.put("mm_trn_qty",""+mm_trn_qty);
									hmDtlTmpData.put("adj_item_qty",""+adj_item_qty);
									hmDtlTmpData.put("remarks","");
									hmDtlTmpData.put("language_id",(String)allanguageData.get(0));
									double dtl_trn_val= Double.parseDouble((String)hMap.get("ITEM_UNIT_COST"))*Double.parseDouble(""+adj_item_qty);
									hmDtlTmpData.put("stock_uom_code",(String)hMap.get("UOM_CODE"));
									hmDtlTmpData.put("item_cost_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));
									hmDtlTmpData.put("item_unit_cost",""+(String)hMap.get("ITEM_UNIT_COST"));
									hmDtlTmpData.put("doc_srl_no",""+(++k));
									hmDtlTmpData.put("doc_no",(String)fetchRecord(connection, (String)hmSQL.get("sql_sy_acc_entity_doc_type_select"), adj_doc_type_code).get("NEXT_DOC_NO"));
									alAdjDtlData.add(hmDtlTmpData);
								}
								item_code = (String)hMap.get("ITEM_CODE");
								doc_no	  = (String)hMap.get("DOC_NO");
							}
							item_code = "";
							k=0;
							doc_no = (String)((HashMap)alList.get(0)).get("DOC_NO");
							//Added by suresh.r on 21-04-2014 against #Inc 48674 beg
							if(alCommonData.get(4).equals("RET")){
								alParam.clear();
								alParam.add((String)((ArrayList)alModHdrData.get(i)).get(8));
								alParam.add((String)((ArrayList)alModHdrData.get(i)).get(7));
								alParam.add((String)((ArrayList)alModHdrData.get(i)).get((((ArrayList)alModHdrData.get(i)).size())-1));
								alList = fetchRecords(connection,"SELECT BATCH_ID,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,TRADE_ID, DTL.ITEM_CODE,DTL.BIN_LOCATION_CODE,SUM( NVL (TMP_REJECTED_QTY_2, 0)) ITEM_QTY FROM ST_ACKNOWLEDGE_TRN_DTL DTL,ST_ACKNOWLEDGE_TRN_HDR HDR,ST_ITEM_STORE STIST WHERE DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND NVL (TMP_REJECTED_QTY_2, 0) > 0 AND DTL.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DTL.DOC_NO = HDR.DOC_NO AND DTL.FACILITY_ID = HDR.FACILITY_ID AND STIST.STORE_CODE = HDR.ISSUING_STORE AND STIST.ITEM_CODE = DTL.ITEM_CODE AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.SEQ_NO = ?  GROUP  BY BATCH_ID,EXPIRY_DATE_OR_RECEIPT_DATE,TRADE_ID,DTL.ITEM_CODE,DTL.BIN_LOCATION_CODE,TMP_REJECTED_QTY_2 ORDER BY DTL.ITEM_CODE",alParam);
							}//Added by suresh.r on 21-04-2014 against #Inc 48674 end
							for(int j=0;j<alList.size();j++){
								HashMap hMap = (HashMap)alList.get(j);
								HashMap hmExpTmpData = new HashMap();
								hmExpTmpData.put("bin_location_code",(String)hMap.get("BIN_LOCATION_CODE"));
								hmExpTmpData.put("batch_id",(String)hMap.get("BATCH_ID"));
								hmExpTmpData.put("expiry_date_or_receipt_date",(String)hMap.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
								hmExpTmpData.put("trade_id",(String)hMap.get("TRADE_ID"));
								hmExpTmpData.put("item_qty",""+(String)hMap.get("ITEM_QTY"));
								if((item_code.equals((String)hMap.get("ITEM_CODE"))))
									hmExpTmpData.put("doc_srl_no",""+k);
								else
									hmExpTmpData.put("doc_srl_no",""+(++k));
								hmExpTmpData.put("doc_no",(String)fetchRecord(connection, (String)hmSQL.get("sql_sy_acc_entity_doc_type_select"), adj_doc_type_code).get("NEXT_DOC_NO"));
								item_code = (String)hMap.get("ITEM_CODE");
								alAdjExpData.add(hmExpTmpData);
							}
						}
						generateDocNo(connection,hmData);
					}
					hmData.put("alAdjHdrData",alAdjHdrData);
					hmData.put("alAdjDtlData",alAdjDtlData);
					hmData.put("alAdjExpData",alAdjExpData);
					this.hmData = hmData;
				hashmapResult = insertAdjStock(hmData,hmSQL);
				throwExceptionWhenFailed(hashmapResult);
				ArrayList alTmpModHdrData = new ArrayList();
					if(alAdjHdrData.size()>0){
						for(int i=0;i<alModHdrData.size();i++){
							alTmpModHdrData = (ArrayList)alModHdrData.get(i);
							alTmpModHdrData.set(0,(String)((ArrayList)alAdjHdrData.get(i)).get(1));
							alTmpModHdrData.set(1,(String)((ArrayList)alAdjHdrData.get(i)).get(2));
							alModHdrData.set(i,alTmpModHdrData);
						}
						if(alModHdrData.size()>0){
							String ModHdrQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_TRN_HDR_UPDATE");
							hmModHdrData.put("DATA",alModHdrData);
							hmModHdrQuery.put(BATCH_SQL,ModHdrQuery);
							hashmapResult =  operateBatch(connection, hmModHdrData, hmModHdrQuery);
							throwExceptionWhenFailed(hashmapResult);
						}
					}
				}
				//insertAdjStock(HashMap hmDataValues, HashMap hmSQLValues)
			}
			//System.out.println("arraylistHdrData in ejb ..1.."+arraylistHdrData);
			//System.out.println("arraylistDtlData in ejb .2..."+arraylistDtlData);
			//System.out.println("alModHdrData in ejb ..3.."+alModHdrData);
			//System.out.println("alModDtlData in ejb .4..."+alModDtlData);
			//System.out.println("alRevDtlData in ejb .5..."+(ArrayList)hmData.get("ACK_DTL_REV_DATA"));
			
			
			if(arraylistHdrData.size()>0){
				String HdrQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_TRN_HDR_INSERT");
				hashmapHDrdata.put("DATA",arraylistHdrData);
				hashmapHDrquery.put(BATCH_SQL,HdrQuery);
				//System.out.println("hashmapHDrdata.1.."+hashmapHDrdata);
				//System.out.println("hashmapHDrquery.1.."+hashmapHDrquery);
				hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(arraylistDtlData.size()>0){
				String DtlQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_TRN_DTL_INSERT");
				hashmapDtldata.put("DATA",arraylistDtlData);
				hashmapDtlquery.put(BATCH_SQL,DtlQuery);
				//System.out.println("hashmapDtldata..2."+hashmapDtldata);
				//System.out.println("hashmapDtlquery.2.."+hashmapDtlquery);
				hashmapResult =  operateBatch(connection, hashmapDtldata, hashmapDtlquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(alModHdrData.size()>0){
				String ModHdrQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_TRN_HDR_UPDATE");
				hmModHdrData.put("DATA",alModHdrData);
				hmModHdrQuery.put(BATCH_SQL,ModHdrQuery);
				//System.out.println("alModHdrData..3.."+alModHdrData);
				//System.out.println("ModHdrQuery..3.."+ModHdrQuery);
				hashmapResult =  operateBatch(connection, hmModHdrData, hmModHdrQuery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(alModDtlData.size()>0){
				String ModDtlQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_TRN_DTL_UPDATE");
				hmModDtlData.put("DATA",alModDtlData);
				hmModDtlQuery.put(BATCH_SQL,ModDtlQuery);
				//System.out.println("hmModDtlData..4.."+hmModDtlData);
				//System.out.println("hmModDtlQuery..4.."+hmModDtlQuery);
				hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
				throwExceptionWhenFailed(hashmapResult);
			}

			ArrayList alRevDtlData = (ArrayList)hmData.get("ACK_DTL_REV_DATA");
			if(alRevDtlData.size()>0){
				String ModDtlQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_UPDATE_FLAG");
				hmModDtlData.put("DATA",alRevDtlData);
				hmModDtlQuery.put(BATCH_SQL,ModDtlQuery);
				//System.out.println("hmModDtlData..5.."+hmModDtlData);
				//System.out.println("hmModDtlQuery..5.."+hmModDtlQuery);
				hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(alRevDtlData.size()>0){
				String ModDtlQuery = (String)hmSQL.get("ST_SQL_ST_ACKNOWLEDGE_TRN_HDR_UPDATE_FLAG");
				hmModDtlData.put("DATA",alRevDtlData);
				hmModDtlQuery.put(BATCH_SQL,ModDtlQuery);
				//System.out.println("hmModDtlData..6.."+hmModDtlData);
				//System.out.println("hmModDtlQuery..6.."+hmModDtlQuery);
				hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
				throwExceptionWhenFailed(hashmapResult);
			}

            connection.commit();
            //connection.rollback();
        }
        catch(Exception exception)
        {
            try
            {
                connection.rollback();
                exception.printStackTrace();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
            hashmapResult.put("result", FALSE);
            hashmapResult.put("msgid", exception.getMessage());
            hashmapResult.put("message", exception.toString());
			
			//System.out.println("hashmapResult==323=>" +hashmapResult );
			
			
			String message = (String)hashmapResult.get("message");
			//String msgid = (String)hashmapResult.get("msgid");
			//System.out.println("Ack manager.java,328,message = > "+message+" msgid = > "+msgid);
			if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			{
				hashmapResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
				hashmapResult.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
			}
			else if(message.contains("NEGATIVE_STOCK"))
			{
			    hashmapResult.put(MSGID,"NEGATIVE_STOCK");
				hashmapResult.put(MESSAGE,"NEGATIVE_STOCK");
			}
			//System.out.println("hashmapResult==328=>" +hashmapResult );
        }
        finally
        {
            try
            {
                closeConnection(connection, properties);
            }
            catch(Exception exception3)
            {
                exception3.printStackTrace();
            }
        }
        return hashmapResult;
    }
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify(HashMap hashmap, HashMap hashmapQuery){
       return new HashMap();
    }
	/*
	 * Duplicating the code from Stock Transfer,Issue,Issue Return
	 */
	public HashMap modifyStockTransfer(HashMap hmData, HashMap hmSQLValues){
		//System.out.println("AcknowledgementManager.java, modifyStockTransfer, hmData = > "+hmData);
		//System.out.println("AcknowledgementManager.java, modifyStockTransfer, hmSQLValues = > "+hmSQLValues);
		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);
		hmSQL		= hmSQLValues;
   		//System.out.println("AcknowledgementManager.java, modifyStockTransfer, hmSQL = > "+hmSQL);
		ArrayList alHdrData			=	(ArrayList)hmData.get("HDR_DATA");
		ArrayList alDtlData			=	new ArrayList();
		ArrayList alExpData			=	new ArrayList();
		ArrayList alExpDataUnitcost	=	new ArrayList();
		ArrayList  alExpQty         =  new ArrayList(); //27/12/12
		ArrayList alDtlRecords		=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords		=	(ArrayList)hmData.get("DTL_EXP_DATA");
		ArrayList alAckHdrData		=	(ArrayList)hmData.get("ACK_HDR_DATA");
		ArrayList alCommonData	    = (ArrayList)hmData.get("COMMON_DATA");  //Added by Rabbani #inc no:33205 on 18/06/12
		//System.out.println("alCommonData ===HSSTTR" +alCommonData);

        try{
            //properties = (Properties)hmData.get("properties");
            //connection = getConnection(properties);
            //connection.setAutoCommit(false);
			/**
			 * @Name - Priya
			 * @Date - 03/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			for (int i=0; i<alDtlRecords.size(); i++) {
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				ArrayList alDtlRecord	=	new ArrayList();
				alDtlRecord.add(hmDtlRecord.get("doc_date"));
				alDtlRecord.add(hmDtlRecord.get("doc_srl_no"));
				alDtlRecord.add(hmDtlRecord.get("item_code"));
				alDtlRecord.add(hmDtlRecord.get("item_qty"));
				alDtlRecord.add(hmDtlRecord.get("item_unit_cost"));
				alDtlRecord.add(hmDtlRecord.get("store_code"));
				alDtlRecord.add(hmDtlRecord.get("stock_item_yn"));
				/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
				alDtlRecord.add(setNumber(""+Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble((String)hmDtlRecord.get("item_qty")),noOfDecimalsForCost));
				alDtlRecord.add(hmDtlRecord.get("to_str_qty"));
				alDtlRecord.add(hmDtlRecord.get("mm_trn_qty"));
				alDtlRecord.add(hmDtlRecord.get("doc_no"));
				alDtlRecord.add(hmDtlRecord.get("tmp_item_qty"));
				alDtlData.add(alDtlRecord);
			} 
 
			for (int i=0; i<alExpRecords.size(); i++) {
				HashMap hmExpRecord		=	(HashMap)alExpRecords.get(i);
				//System.out.println("AcknowledgementManager.java,hmExpRecord=HSSTTR===> "+hmExpRecord);
				ArrayList alExpRecord	=	new ArrayList();
				alExpRecord.add(hmExpRecord.get("doc_srl_no"));
				alExpRecord.add(hmExpRecord.get("STORE_CODE"));
				alExpRecord.add(hmExpRecord.get("ITEM_CODE"));
				alExpRecord.add(hmExpRecord.get("BATCH_ID"));
				alExpRecord.add(hmExpRecord.get("BIN_LOCATION_CODE"));
				alExpRecord.add(hmExpRecord.get("EXPIRY_DATE"));
				alExpRecord.add(hmExpRecord.get("TRADE_ID"));
				alExpRecord.add(hmExpRecord.get("ISSUE_QTY"));
				alExpRecord.add(hmExpRecord.get("TO_BIN_LOCATION_CODE"));
				alExpRecord.add(hmExpRecord.get("uom_code"));
				alExpRecord.add(hmExpRecord.get("TO_UOM_CODE"));
				alExpRecord.add(hmExpRecord.get("DOC_NO"));
				alExpRecord.add(hmExpRecord.get("DOC_DATE"));
			  //Added by Rabbani #inc no:33205 on 18/06/12 Stars
			   if(alCommonData.get(6).equals("A")){	
				alExpRecord.add(hmExpRecord.get("RECEIVED_QTY"));
				alExpRecord.add(hmExpRecord.get("REJECTED_QTY"));
				}else{
				alExpRecord.add(hmExpRecord.get("TMP_RECEIVED_QTY_2"));
				alExpRecord.add(hmExpRecord.get("TMP_REJECTED_QTY_2"));
				}
				//ends
				alExpRecord.add(hmExpRecord.get("modified_date"));  //Added by Rabbani #inc no:31269 on 09/04/12 
				//Added by Rabbani   on 27/12/2012 Starts
				 double trn_item_qty = 0.0;
				 if(alCommonData.get(6).equals("A")){
                 trn_item_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"))+ Double.parseDouble(((String)hmExpRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmExpRecord.get("REJECTED_QTY"));				 
				 alExpQty.add(""+trn_item_qty);
				}else{
				 trn_item_qty = Double.parseDouble((String)hmExpRecord.get("TMP_RECEIVED_QTY_2"))+Double.parseDouble(((String)hmExpRecord.get("TMP_REJECTED_QTY_2")).equals("")?"0":(String)hmExpRecord.get("TMP_REJECTED_QTY_2"));
				 alExpQty.add(""+trn_item_qty);
				}
				//alExpDataUnitcost.add(hmExpRecord.get("item_unit_cost"));
				 //Modified by suresh.r on 14-08-2014 against Inc#50616
				 alExpDataUnitcost.add(setNumber((String)hmExpRecord.get("item_unit_cost"),noOfDecimalsForCost));
				alExpData.add(alExpRecord);
			} 
			hmData.put("HDR_DATA",alHdrData);
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("UNIT_COST_DATA",alExpDataUnitcost);
			hmData.put("ACK_HDR_DATA",alAckHdrData);
			hmData.put("AL_REJECT_DATA",alExpQty);
			//System.out.println("AcknowledgementManager.java, modifyStockTransfer, hmData = > "+hmData);
			hmResult=updateStockTransfer(connection, hmData);
			throwExceptionWhenFailed(hmResult);
            //connection.commit();
        }
        catch(Exception exception){
			try{
				//connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
            hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
        }
        
        return hmResult;
    }

	public HashMap updateStockTransfer(Connection connection, HashMap hmData){
				
		int			iHdrLength	=	0	;
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();

		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		ArrayList	allanguageData=	new ArrayList();
		ArrayList	alCommonData=	new ArrayList();
		ArrayList	alAckHdrData=	new ArrayList();
		String      dtl_unit_cost="";
		String      uom_code="";
		String      to_uom_code="";
		String      Store_code="";
		String      to_store_code="";
		boolean isFinalized	=	true;
		String stCurrentItemCodeInCaseOfError=null;
		int rec_high_no = 0;
		//System.out.println("AcknowledgementManager.java, updateStockTransfer, hmData = > "+hmData);
		String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
		ArrayList  hmparam = new ArrayList();    
		String p_from_bin_location_code		= "";
		String p_from_store_code			= ""; 
		String p_to_store_code				= "";
		String p_to_bin_location_code		= "";
		String p_item_code					= ""; 
		String p_batch_id					= ""; 
		String p_expiry_date_or_receipt_date= "";
		String mod_date						="";
		double tmp_qty = 0.0;

		try {
			boolean site = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","MUL_FAC_TFR_BATCH_PRICE_MOVE"); //Added for IN:069375
			String stSQLHdrUpdate	=	(String)hmSQL.get ("stSQLHdrUpdate");
			//String stSQLDtlUpdate	=	(String)hmSQL.get ("stSQLDtlUpdate");
			//String stSQLExpDelete	=	(String)hmSQL.get ("stSQLExpDelete");
			//String stSQLExpInsert	=	(String)hmSQL.get ("stSQLExpInsert");
			//String sql_st_transfer_dtl_exp_select_for_block_rel	=	(String)hmSQL.get ("sql_st_transfer_dtl_exp_select_for_block_rel");   

			alHdrData			=	(ArrayList)	hmData.get("HDR_DATA");
			allanguageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			alCommonData		=	(ArrayList)	hmData.get("COMMON_DATA");
			alAckHdrData		=	(ArrayList)	hmData.get("ACK_HDR_DATA");
			//isFinalized			=	true;//((String)alHdrData.get(7)).equals("Y");
			iHdrLength			=	alHdrData.size();
			Store_code = (String)((ArrayList)alHdrData.get(0)).get(2);
			to_store_code = (String)((ArrayList)alHdrData.get(0)).get(3);
			
			 
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(BATCH_SQL,stSQLHdrUpdate);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			/**
			 * @Name - Priya
			 * @Date - 03/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
//dtl logic
			alDtlData			=	(ArrayList)	hmData.get("DTL_DATA");
			alExpData			=	(ArrayList)hmData.get("DTL_EXP_DATA");
			//System.out.println("alExpData===HSSTTR==533=>" +alExpData);
		   //Added by Rabbani #inc no:31269 on 09/04/12 
		 	String old_dtl_doc_no="";  
			String old_dtl_seq_no="";	
            boolean to_check = true;			
			//ends
			
			for (int i=0;i<alDtlData.size() ;i++ ) {
			
				ArrayList alDtlRecord	= (ArrayList)alDtlData.get(i);
				String dtl_doc_no = (String)alDtlRecord.get(10);	
				String dtl_item_code=(String)alDtlRecord.get(2);
                String dtl_seq_no=(String)alDtlRecord.get(1);					
				String doc_date = (String)alDtlRecord.get(0);
				      Store_code = (String)alDtlRecord.get(5); //Added by Rabbani on 15/04/2014
				alDtlRecord.remove(0);
				String toStrQty		=	(String)alDtlRecord.get(7);
				String mm_trn_qty	=	(String)alDtlRecord.get(8);
				String doc_no		=	(String)alDtlRecord.get(9);
				String tmp_mov_qty	=	(String)alDtlRecord.get(10);
				alDtlRecord.remove(10);
// save the item code in case of error
				stCurrentItemCodeInCaseOfError=(String)alDtlRecord.get(2);

				ArrayList alDeleteExpRecord	=	new ArrayList();

				//alDeleteExpRecord.add(alCommonData.get(2));		//facility_id
				alDeleteExpRecord.add(alCommonData.get(5));		//facility_id
				//alDeleteExpRecord.add(((ArrayList)alAckHdrData.get(0)).get(0));		//facility_id
				alDeleteExpRecord.add(alCommonData.get(3));		//doc_type_code
				alDeleteExpRecord.add(doc_no);		//doc_no
				alDeleteExpRecord.add(alDtlRecord.get(0));//put doc_srl_no at last..

				//ArrayList alRecords1	=	fetchRecords(connection,sql_st_transfer_dtl_exp_select_for_block_rel, alDeleteExpRecord);

                //commented by Rabbani on 18/06/12  no need to delete st_transfer_dtl_exp 
				/*hmArgData.put(DATA,alDeleteExpRecord);
				hmArgSQL.put(DELETE_SQL,stSQLExpDelete);
				hmResult	=	delete(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult); */
				alDtlRecord.remove(7);
				alDtlRecord.remove(7);
				alDtlRecord.remove(7);
				alDtlRecord.add(alCommonData.get(0));		//modified_by_id
				alDtlRecord.add(alCommonData.get(1));		//modified_at_ws_no
				alDtlRecord.add(alCommonData.get(2));		//modified_facility_id
				
				//alDtlRecord.add(alCommonData.get(2));		//fac
				alDtlRecord.add(alCommonData.get(5));		//fac
				//alDtlRecord.add(((ArrayList)alAckHdrData.get(0)).get(0));		//fac
				alDtlRecord.add(alCommonData.get(3));		//doc_type_code
				alDtlRecord.add(doc_no);		//doc_no
				alDtlRecord.add(alDtlRecord.get(0));//put doc_srl_no at last..
				alDtlRecord.remove(0);
				//commented by Rabbani on 18/06/12 no need  to update ST_TRANSFER_DTL
				/*hmArgData.put(DATA,alDtlRecord);
				hmArgSQL.put(UPDATE_SQL,stSQLDtlUpdate);    
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);*/
				
				if(isFinalized) {// mode not equals delete
					HashMap hmParameters = new HashMap();
					hmParameters.put("item_code",alDtlRecord.get(0));//item_code
					hmParameters.put("store_code",Store_code);
					hmParameters.put("to_store_code",to_store_code);
					hmParameters.put("trn_type","TFR");
					hmParameters.put("doc_date",doc_date);
					//hmParameters.put("trn_qty",alDtlRecord.get(1));//item_qty modified by ganga
					//hmParameters.put("trn_qty",mm_trn_qty);
					hmParameters.put("trn_unit_cost",alDtlRecord.get(2));
					dtl_unit_cost=(String)alDtlRecord.get(2);
					//double trn_val= Double.parseDouble((String)alDtlRecord.get(1))*Double.parseDouble((String)alDtlRecord.get(2)); by ganga
					double trn_val= Double.parseDouble(mm_trn_qty)*Double.parseDouble(dtl_unit_cost);
					/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
					//hmParameters.put("fm_trn_value",setNumber(""+trn_val,noOfDecimalsForCost));//value
					hmParameters.put("from_stk_item_yn",alDtlRecord.get(4));//value
					hmParameters.put("to_stk_item_yn","Y");//value
					hmParameters.put("last_receipt_date",doc_date); // doc_date
					hmParameters.put("last_issue_date",doc_date); // doc_date

					hmParameters.put("login_by_id",alCommonData.get(0));
					hmParameters.put("login_at_ws_no",alCommonData.get(1));
					hmParameters.put("login_facility_id",alCommonData.get(2));
					hmParameters.put("to_str_qty",toStrQty);
					hmParameters.put("mm_trn_qty",mm_trn_qty);
					hmParameters.put("mm_trn_qty",mm_trn_qty);
					hmParameters.put("language_id",(String)allanguageData.get(0));
					double fm_str_qty =Double.parseDouble(mm_trn_qty) /(getConvFactTemp((String)alDtlRecord.get(0),Store_code,hmSQL,(String)allanguageData.get(0),properties));
					double dtl_trn_val= Double.parseDouble((String)alDtlRecord.get(2))*Double.parseDouble(""+fm_str_qty);
					/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
					hmParameters.put("trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));
					hmParameters.put("mode","MODE_MODIFY"); //added by ganga on 08/16/2011

					hmParameters.put("trn_qty",""+fm_str_qty); //added by ganga on Thursday, April 19, 2012
					hmParameters.put("fm_trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));


					calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
					
					hmParameters.put("trn_qty",alDtlRecord.get(1));//item_qty modified by ganga
					trn_val= Double.parseDouble((String)alDtlRecord.get(1))*Double.parseDouble((String)alDtlRecord.get(2)); //by ganga
					
					hmParameters.put("trn_value",""+trn_val);
					//hmParameters.remove("to_str_qty");
					hmParameters.put("mm_trn_qty",tmp_mov_qty);
					hmParameters.put("to_mm_trn_qty",mm_trn_qty);
					//dtl_trn_val= Double.parseDouble((String)alDtlRecord.get(2))*Double.parseDouble(mm_trn_qty);
					/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
					hmParameters.put("to_trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));
					//System.out.println("AcknowlegementManager.java, updateStockTransfer, hmParameters = > "+hmParameters);
					insertItemMoveSummaryForTFR (connection, hmParameters);
					rec_high_no = rec_high_no + 1;
				}
				    String exp_doc_no ="";
				    String exp_item_code="";
					for (int j=0; j<alExpData.size(); j++) {
					ArrayList alRecord	=	(ArrayList)alExpData.get(j);
					 exp_doc_no = (String)alRecord.get(11);		
					 exp_item_code	= (String)alRecord.get(2);					 
				    //System.out.println("exp_doc_no===631==>"+exp_doc_no);	
					if (dtl_doc_no.equals(exp_doc_no) && dtl_item_code.equals(exp_item_code)){
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",alRecord.get(1));
					hmParameter.put("item_code",alRecord.get(2));
					hmParameter.put("batch_id",alRecord.get(3));
					hmParameter.put("bin_location_code",alRecord.get(4));
					hmParameter.put("expiry_date_or_receipt_date",alRecord.get(5));
					  tmp_qty = Double.parseDouble(((String)alRecord.get(13)).equals("")?"0":(String)alRecord.get(13))+Double.parseDouble(((String)alRecord.get(14)).equals("")?"0":(String)alRecord.get(14));
					 //System.out.println("tmp_qty====>" +tmp_qty);
					hmParameter.put("trn_qty", ""+tmp_qty);
					hmParameter.put("login_by_id",alCommonData.get(0));
					hmParameter.put("login_at_ws_no",alCommonData.get(1));
					hmParameter.put("login_facility_id",alCommonData.get(2));
					 
				 //Added by Rabbani #inc no:31269 on 05/04/12
				if ((old_dtl_doc_no.equals(dtl_doc_no) && old_dtl_seq_no.equals(dtl_seq_no)) || old_dtl_doc_no.equals("")){
				hmParameter.put("modified_date",(String)alRecord.get(15));   
				}else{
				old_dtl_doc_no = "not_check";
				to_check = false;
				}
				//ends
					alRecord.remove(14);
					hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'R');//false to release the batch..
					throwExceptionWhenFailed(hmResult);
					}
				}
				
			ArrayList alTemp	=	new ArrayList();
			ArrayList unitcost = (ArrayList) hmData.get("UNIT_COST_DATA");
            ArrayList alRejectQty = (ArrayList) hmData.get("AL_REJECT_DATA");			
			for (int k=0,t=0; k<alExpData.size(); k++) {
				alTemp	=	(ArrayList)	alExpData.get(k);	
              // System.out.println("alTemp=====HSSTRN===714====>"+alTemp);				
				exp_doc_no = (String)alTemp.get(11);	
				exp_item_code= (String)alTemp.get(2);
				if (dtl_doc_no.equals(exp_doc_no) && dtl_item_code.equals(exp_item_code)){				
				uom_code	=(String)	alTemp.get(9);
				to_uom_code	=(String)	alTemp.get(10);
// save the item codein case of error
				stCurrentItemCodeInCaseOfError=(String)alTemp.get(2);
				alTemp.remove(9);
				alTemp.remove(9);
				//alTemp.add(0,alCommonData.get(2));
				alTemp.add(0,alCommonData.get(5));
				
				//alTemp.add(0,((ArrayList)alAckHdrData.get(0)).get(0));
				alTemp.add(1,alCommonData.get(3));
				alTemp.add(2,alTemp.get(11));
				alTemp.add(alCommonData.get(0));		//added_by_id
				alTemp.add(alCommonData.get(1));		//added_at_ws_no
				alTemp.add(alCommonData.get(2));		//added_facility_id
				alTemp.add(alCommonData.get(0));		//modified_by_id
				alTemp.add(alCommonData.get(1));		//modified_at_ws_no
				alTemp.add(alCommonData.get(2));		//modified_facility_id
				if(!isFinalized){//Batch blocking logic follows:
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",Store_code);
					hmParameter.put("item_code",alTemp.get(5));
					hmParameter.put("batch_id",alTemp.get(6));
					hmParameter.put("bin_location_code",alTemp.get(7));
					hmParameter.put("expiry_date_or_receipt_date",alTemp.get(8));
					hmParameter.put("trn_qty",""+(String)alTemp.get(10));

					hmParameter.put("login_by_id",alCommonData.get(0));
					hmParameter.put("login_at_ws_no",alCommonData.get(1));
					hmParameter.put("login_facility_id",alCommonData.get(2));
					
					hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B');
					throwExceptionWhenFailed(hmResult);
				}
				if (isFinalized) {

					HashMap hmParameters = new HashMap();
					
					

					hmParameters.put("item_code",alTemp.get(5));//item_code
					hmParameters.put("store_code",Store_code);
					hmParameters.put("to_store_code",to_store_code);
					hmParameters.put("trn_type","TFR");
					//System.out.println("alTemp=====HSSTRN=761=>"+alTemp);
					double trn_qty_temp = Double.parseDouble(checkForNull((String)alTemp.get(14),"0"));
					//System.out.println("trn_qty_temp:=====>" +trn_qty_temp);
					hmParameters.put("trn_qty",""+(String)alTemp.get(14));
					alTemp.remove(14);//Becareful here....
					hmParameters.put("batch_id",alTemp.get(6));
					hmParameters.put("expiry_date_or_receipt_date",alTemp.get(8));
					hmParameters.put("trade_id",alTemp.get(9));
					hmParameters.put("from_bin_location_code",alTemp.get(7));
					hmParameters.put("to_bin_location_code",alTemp.get(11));
					hmParameters.put("suspended_batch_allowed_yn","Y");
					hmParameters.put("release_batch_yn","N");
					hmParameters.put("last_receipt_date",alTemp.get(13)); // doc_date
					hmParameters.put("last_issue_date",alTemp.get(13)); // doc_date
						    
					hmParameters.put("login_by_id",alCommonData.get(0));
					hmParameters.put("login_at_ws_no",alCommonData.get(1));
					hmParameters.put("login_facility_id",alCommonData.get(2));
//			String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
				  hmparam = new ArrayList();
			            
				 p_from_bin_location_code		= checkForNull (hmParameters.get("from_bin_location_code"));
				 p_from_store_code				= checkForNull (hmParameters.get("store_code")); 
				 p_to_store_code					= checkForNull	(hmParameters.get("to_store_code"));
				 p_to_bin_location_code			= checkForNull (hmParameters.get("to_bin_location_code"));
				 p_item_code						= checkForNull (hmParameters.get("item_code")); 
				 p_batch_id						= checkForNull (hmParameters.get("batch_id")); 
				 p_expiry_date_or_receipt_date	= checkForNull (hmParameters.get("expiry_date_or_receipt_date"));
						
						   hmparam.add(p_from_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_from_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
						   							   
						   hmParameters.put("modified_date",mod_date);
						   hmparam = new ArrayList();
						    hmparam.add(p_to_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_to_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
					
						   hmParameters.put("to_modified_date",mod_date);
			
			
					if(trn_qty_temp > 0){
						updateBatchOnLine(connection, hmSQL, hmParameters);
					}
		  // Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here
				ArrayList alFromDtlTrn=new ArrayList();
				
				//System.out.println("alTemp=814===>" +alTemp);
				String fm_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), Store_code).get("FACILITY_ID");
		       
				//alFromDtlTrn.add(alCommonData.get(2));//facility_id
				alFromDtlTrn.add(fm_facility_id);//facility_id
				alFromDtlTrn.add(Store_code);//store_code
				alFromDtlTrn.add(alTemp.get(5));//item_code
				t++;			
				alFromDtlTrn.add(""+t);//trn_srl_no
				alFromDtlTrn.add("TFR");
				alFromDtlTrn.add(alCommonData.get(3));//doc_type_code
				alFromDtlTrn.add(alTemp.get(2));//doc_no
				alFromDtlTrn.add(alTemp.get(3));//doc_srl_no
				alFromDtlTrn.add(alTemp.get(13));//Doc_date
				alFromDtlTrn.add("");//Doc_ref
				alFromDtlTrn.add(alTemp.get(6));//fm_item_batch_id
				alFromDtlTrn.add(alTemp.get(8)); //fm_expiry_date
			     //String  temp_fm_item_qty=  "-"+tmp_qty; //fm_item_qty //commented by Rabbani #INC no:36523 on 29/11/12
				 //Added by Rabbani #INC NO:36523 insert  into  St_item_trn_dtl  item_qty_normal value correctly
			     //String  temp_fm_item_qty=  "-"+trn_qty_temp; //Commented by Rabbani on 27/12/2012
				 String   temp_fm_item_qty =  (String)alRejectQty.get(k); //Added by Rabbani on 27/12/2012
				 double  temp_trn_qty  = Double.parseDouble(checkForNull(temp_fm_item_qty,"0"));
				//System.out.println("temp_trn_qty==tfr==>" +temp_trn_qty);
				alFromDtlTrn.add("-"+temp_fm_item_qty);//12/06/12
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(unitcost.get(k)); //fm_item_unit_cost  --alDtlRecord.get(6) //07/06/12
				alFromDtlTrn.add("");
				alFromDtlTrn.add(uom_code); //fm_stk_uom_code    --alDtlRecord.get(8)
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(to_store_code);
				alFromDtlTrn.add("Y");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(alCommonData.get(0));
				alFromDtlTrn.add(alCommonData.get(1));
				alFromDtlTrn.add(alCommonData.get(2));
				alFromDtlTrn.add(alCommonData.get(0));
				alFromDtlTrn.add(alCommonData.get(1));
				alFromDtlTrn.add(alCommonData.get(2));
				alFromDtlTrn.add("");//sal_trn
				alFromDtlTrn.add(alTemp.get(7));//bin_location_code
				alFromDtlTrn.add(alTemp.get(9));//trade_id 
				
				//System.out.println("alFromDtlTrn======>" +alFromDtlTrn);
			
//         Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here
//		   Insertion of the FROM record into st_item_trn_dtl BEGINS here 
               if(temp_trn_qty > 0){ //Added by Rabbani #inc no:33205 on 18/06/12
			    stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");
			    hmArgData.put(DATA,alFromDtlTrn);
			    hmArgSQL.put(INSERT_SQL,stSQL);
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
                }
//		   Insertion of the FROM record into st_item_trn_dtl ENDS here 


//		  Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here
  			    ArrayList alToDtlTrn=new ArrayList();
				String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), to_store_code).get("FACILITY_ID");
		        
			//	alToDtlTrn.add(alCommonData.get(2));//facility_id
				alToDtlTrn.add(to_facility_id);//facility_id  
				alToDtlTrn.add(to_store_code);//store_code
				alToDtlTrn.add(alTemp.get(5));//item_code
				t++;			
				alToDtlTrn.add(""+t);//trn_srl_no
				alToDtlTrn.add("TFR");
				alToDtlTrn.add(alCommonData.get(3));//doc_type_code
				alToDtlTrn.add(alTemp.get(2));//doc_no
				alToDtlTrn.add(alTemp.get(3));//doc_srl_no
				alToDtlTrn.add(alTemp.get(13));//Doc_date
				alToDtlTrn.add("");//Doc_ref
				alToDtlTrn.add(alTemp.get(6));//fm_item_batch_id
				alToDtlTrn.add(alTemp.get(8)); //fm_expiry_date
				//alToDtlTrn.add(alTemp.get(10)); by ganga
				alToDtlTrn.add(""+trn_qty_temp);
				
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				//alToDtlTrn.add(unitcost.get(i)); //fm_item_unit_cost  --alDtlRecord.get(6)
				alToDtlTrn.add(unitcost.get(k)); //07/06/12
				alToDtlTrn.add("");
				alToDtlTrn.add(to_uom_code); //fm_stk_uom_code    --alDtlRecord.get(8)
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add(Store_code);
				alToDtlTrn.add("Y");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add(alCommonData.get(0));
				alToDtlTrn.add(alCommonData.get(1));
				alToDtlTrn.add(alCommonData.get(2));
				alToDtlTrn.add(alCommonData.get(0));
				alToDtlTrn.add(alCommonData.get(1));
				alToDtlTrn.add(alCommonData.get(2));
				alToDtlTrn.add("");//sal_trn
				alToDtlTrn.add(alTemp.get(11));//bin_location_code
				alToDtlTrn.add(alTemp.get(9));//trade_id 
				
			//	System.out.println("alToDtlTrn===tfr==>" +alToDtlTrn);

//           Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here
//		   Insertion of the TO record into st_item_trn_dtl BEGINS here 
                if(trn_qty_temp > 0){ //12/06/12
				stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");
				hmArgData.put(DATA,alToDtlTrn);
				hmArgSQL.put(INSERT_SQL,stSQL);
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
                 }
//		   Insertion of the To record into st_item_trn_dtl ENDS here 
              //Added for IN:069375 start
                if(site){
                if(!(fm_facility_id.equals(to_facility_id))){
					System.out.println("Heb Huli >> 2");
					System.out.println(alTemp.get(5)+","+alTemp.get(9)+","+alTemp.get(6)+","+alCommonData.get(0)+","+alCommonData.get(1)+","+fm_facility_id+","+to_facility_id);
					CallableStatement callableStatement = null;
					callableStatement	= connection.prepareCall("{ call bl_create_material_batch_price (?,?,?,?,?,?,?,?,?,?,?) }");
					callableStatement.setString(1, (String)alTemp.get(5));
					callableStatement.setString(2, ((String)alTemp.get(9)));
					callableStatement.setString(3, (String)alTemp.get(6));
					callableStatement.setString(4, "");
					callableStatement.setString(5, (String)alCommonData.get(0));
					callableStatement.setString(6, (String)alCommonData.get(1));
					callableStatement.registerOutParameter(7, Types.VARCHAR);
					callableStatement.registerOutParameter(8, Types.VARCHAR);
					callableStatement.registerOutParameter(9, Types.VARCHAR);
					callableStatement.setString(10, (String)fm_facility_id);
					callableStatement.setString(11, (String)to_facility_id);
					callableStatement.execute();
					System.out.println(fm_facility_id.equals(to_facility_id));
					closeStatement(callableStatement);//COMMON-ICN-0118
				}
                }
              //Added for IN:069375 end

				}
				}
			}
			
			//Added by Rabbani #inc no:31269 on 09/04/12
				if(to_check){
				old_dtl_doc_no = dtl_doc_no;
				old_dtl_seq_no = dtl_seq_no;
				}
				 
			  //ends
			
			}
			/*commented by ganga	
				for (int j=0; j<alExpData.size(); j++) {
					ArrayList alRecord	=	(ArrayList)alExpData.get(j);
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",alRecord.get(1));
					hmParameter.put("item_code",alRecord.get(2));
					hmParameter.put("batch_id",alRecord.get(3));
					hmParameter.put("bin_location_code",alRecord.get(4));
					hmParameter.put("expiry_date_or_receipt_date",alRecord.get(5));
					double tmp_qty = Double.parseDouble(((String)alRecord.get(13)).equals("")?"0":(String)alRecord.get(13))+Double.parseDouble(((String)alRecord.get(14)).equals("")?"0":(String)alRecord.get(14));
					hmParameter.put("trn_qty", ""+tmp_qty);
					hmParameter.put("login_by_id",alCommonData.get(0));
					hmParameter.put("login_at_ws_no",alCommonData.get(1));
					hmParameter.put("login_facility_id",alCommonData.get(2));
					alRecord.remove(14);
					hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'R');//false to release the batch..
					throwExceptionWhenFailed(hmResult);
					
				}
			ArrayList alTemp	=	new ArrayList();
			ArrayList unitcost = (ArrayList) hmData.get("UNIT_COST_DATA");
			for (int i=0,t=0; i<alExpData.size(); i++) {
				
				alTemp	=	(ArrayList)	alExpData.get(i);
				uom_code	=(String)	alTemp.get(9);
				to_uom_code	=(String)	alTemp.get(10);
// save the item codein case of error
				stCurrentItemCodeInCaseOfError=(String)alTemp.get(2);
				alTemp.remove(9);
				alTemp.remove(9);
				//alTemp.add(0,alCommonData.get(2));
				alTemp.add(0,alCommonData.get(5));
				
				//alTemp.add(0,((ArrayList)alAckHdrData.get(0)).get(0));
				alTemp.add(1,alCommonData.get(3));
				alTemp.add(2,alTemp.get(11));
				alTemp.add(alCommonData.get(0));		//added_by_id
				alTemp.add(alCommonData.get(1));		//added_at_ws_no
				alTemp.add(alCommonData.get(2));		//added_facility_id
				alTemp.add(alCommonData.get(0));		//modified_by_id
				alTemp.add(alCommonData.get(1));		//modified_at_ws_no
				alTemp.add(alCommonData.get(2));		//modified_facility_id
				if(!isFinalized){//Batch blocking logic follows:
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",Store_code);
					hmParameter.put("item_code",alTemp.get(5));
					hmParameter.put("batch_id",alTemp.get(6));
					hmParameter.put("bin_location_code",alTemp.get(7));
					hmParameter.put("expiry_date_or_receipt_date",alTemp.get(8));
					hmParameter.put("trn_qty",""+(String)alTemp.get(10));

					hmParameter.put("login_by_id",alCommonData.get(0));
					hmParameter.put("login_at_ws_no",alCommonData.get(1));
					hmParameter.put("login_facility_id",alCommonData.get(2));
					
					hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B');
					throwExceptionWhenFailed(hmResult);
				}
				if (isFinalized) {

					HashMap hmParameters = new HashMap();

					hmParameters.put("item_code",alTemp.get(5));//item_code
					hmParameters.put("store_code",Store_code);
					hmParameters.put("to_store_code",to_store_code);
					hmParameters.put("trn_type","TFR");
					double trn_qty_temp = Double.parseDouble(checkForNull((String)alTemp.get(14),"0"));
					hmParameters.put("trn_qty",""+(String)alTemp.get(14));
					alTemp.remove(14);//Becareful here....
					hmParameters.put("batch_id",alTemp.get(6));
					hmParameters.put("expiry_date_or_receipt_date",alTemp.get(8));
					hmParameters.put("trade_id",alTemp.get(9));
					hmParameters.put("from_bin_location_code",alTemp.get(7));
					hmParameters.put("to_bin_location_code",alTemp.get(11));
					hmParameters.put("suspended_batch_allowed_yn","Y");
					hmParameters.put("release_batch_yn","N");
					hmParameters.put("last_receipt_date",alTemp.get(13)); // doc_date
					hmParameters.put("last_issue_date",alTemp.get(13)); // doc_date
						    
					hmParameters.put("login_by_id",alCommonData.get(0));
					hmParameters.put("login_at_ws_no",alCommonData.get(1));
					hmParameters.put("login_facility_id",alCommonData.get(2));
//			String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
				  hmparam = new ArrayList();
			            
				 p_from_bin_location_code		= checkForNull (hmParameters.get("from_bin_location_code"));
				 p_from_store_code				= checkForNull (hmParameters.get("store_code")); 
				 p_to_store_code					= checkForNull	(hmParameters.get("to_store_code"));
				 p_to_bin_location_code			= checkForNull (hmParameters.get("to_bin_location_code"));
				 p_item_code						= checkForNull (hmParameters.get("item_code")); 
				 p_batch_id						= checkForNull (hmParameters.get("batch_id")); 
				 p_expiry_date_or_receipt_date	= checkForNull (hmParameters.get("expiry_date_or_receipt_date"));
						
						   hmparam.add(p_from_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_from_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
						   							   
						   hmParameters.put("modified_date",mod_date);
						   hmparam = new ArrayList();
						    hmparam.add(p_to_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_to_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
					
						   hmParameters.put("to_modified_date",mod_date);
			
			
					if(trn_qty_temp > 0){
						updateBatchOnLine(connection, hmSQL, hmParameters);
					}
		  // Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here
				ArrayList alFromDtlTrn=new ArrayList();
				
				alFromDtlTrn.add(alCommonData.get(2));//facility_id
				alFromDtlTrn.add(Store_code);//store_code
				alFromDtlTrn.add(alTemp.get(5));//item_code
				t++;			
				alFromDtlTrn.add(""+t);//trn_srl_no
				alFromDtlTrn.add("TFR");
				alFromDtlTrn.add(alCommonData.get(3));//doc_type_code
				alFromDtlTrn.add(alTemp.get(2));//doc_no
				alFromDtlTrn.add(alTemp.get(3));//doc_srl_no
				alFromDtlTrn.add(alTemp.get(13));//Doc_date
				alFromDtlTrn.add("");//Doc_ref
				alFromDtlTrn.add(alTemp.get(6));//fm_item_batch_id
				alFromDtlTrn.add(alTemp.get(8)); //fm_expiry_date
				String temp_fm_item_qty="-"+alTemp.get(10); //fm_item_qty
				alFromDtlTrn.add(temp_fm_item_qty);
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(unitcost.get(i)); //fm_item_unit_cost  --alDtlRecord.get(6)
				alFromDtlTrn.add("");
				alFromDtlTrn.add(uom_code); //fm_stk_uom_code    --alDtlRecord.get(8)
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(to_store_code);
				alFromDtlTrn.add("Y");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(alCommonData.get(0));
				alFromDtlTrn.add(alCommonData.get(1));
				alFromDtlTrn.add(alCommonData.get(2));
				alFromDtlTrn.add(alCommonData.get(0));
				alFromDtlTrn.add(alCommonData.get(1));
				alFromDtlTrn.add(alCommonData.get(2));
				alFromDtlTrn.add("");//sal_trn
				alFromDtlTrn.add(alTemp.get(7));//bin_location_code
				alFromDtlTrn.add(alTemp.get(9));//trade_id 

//         Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here
//		   Insertion of the FROM record into st_item_trn_dtl BEGINS here 

			stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");
			hmArgData.put(DATA,alFromDtlTrn);
			hmArgSQL.put(INSERT_SQL,stSQL);
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);

//		   Insertion of the FROM record into st_item_trn_dtl ENDS here 


//		  Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here
  			    ArrayList alToDtlTrn=new ArrayList();
				
				alToDtlTrn.add(alCommonData.get(2));//facility_id
				alToDtlTrn.add(to_store_code);//store_code
				alToDtlTrn.add(alTemp.get(5));//item_code
				t++;			
				alToDtlTrn.add(""+t);//trn_srl_no
				alToDtlTrn.add("TFR");
				alToDtlTrn.add(alCommonData.get(3));//doc_type_code
				alToDtlTrn.add(alTemp.get(2));//doc_no
				alToDtlTrn.add(alTemp.get(3));//doc_srl_no
				alToDtlTrn.add(alTemp.get(13));//Doc_date
				alToDtlTrn.add("");//Doc_ref
				alToDtlTrn.add(alTemp.get(6));//fm_item_batch_id
				alToDtlTrn.add(alTemp.get(8)); //fm_expiry_date
				//alToDtlTrn.add(alTemp.get(10)); by ganga
				alToDtlTrn.add(""+trn_qty_temp);
				
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add(unitcost.get(i)); //fm_item_unit_cost  --alDtlRecord.get(6)
				alToDtlTrn.add("");
				alToDtlTrn.add(to_uom_code); //fm_stk_uom_code    --alDtlRecord.get(8)
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add(Store_code);
				alToDtlTrn.add("Y");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add(alCommonData.get(0));
				alToDtlTrn.add(alCommonData.get(1));
				alToDtlTrn.add(alCommonData.get(2));
				alToDtlTrn.add(alCommonData.get(0));
				alToDtlTrn.add(alCommonData.get(1));
				alToDtlTrn.add(alCommonData.get(2));
				alToDtlTrn.add("");//sal_trn
				alToDtlTrn.add(alTemp.get(11));//bin_location_code
				alToDtlTrn.add(alTemp.get(9));//trade_id 

//           Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here
//		   Insertion of the TO record into st_item_trn_dtl BEGINS here 

			stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");

			hmArgData.put(DATA,alToDtlTrn);
			hmArgSQL.put(INSERT_SQL,stSQL);
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);

//		   Insertion of the To record into st_item_trn_dtl ENDS here 

				}
			
			} */
			ArrayList alTmpExp = new ArrayList();
			
			for(int x=0;x<alExpData.size();x++){
				alTmpExp = (ArrayList)alExpData.get(x);
				//System.out.println("alTmpExp:1 Ack ejb==>" +alTmpExp);
				alTmpExp.remove(12);
				alTmpExp.remove(12);
				alTmpExp.remove(12); //Added by Rabbani #inc no:31269 on 21/03/12 
				//System.out.println("alTmpExp:1135 Ack ejb==>" +alTmpExp); //14/05/12
			}
			//commented by Rabbani on 18/06/12 no need  to insert St_transfer_dtl_exp	
			/*hmArgData.put(DATA,alExpData);
			hmArgSQL.put(BATCH_SQL,stSQLExpInsert);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);*/

		}
		catch (Exception exception) {
			//System.out.println("Exception from AcknowledgementManager.java = >");
			exception.printStackTrace();
			hmResult.put(RESULT,FALSE);
			hmResult.put(MSGID,exception.toString());
			hmResult.put(MESSAGE,exception.getMessage());
			if (exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) {
				hmResult.put("flag",stCurrentItemCodeInCaseOfError+"~"+rec_high_no);
			}
			else if(exception.getMessage().equals("NEGATIVE_STOCK")) {
				hmResult.put(MESSAGE,"NEGATIVE_STOCK");
				hmResult.put("flag",stCurrentItemCodeInCaseOfError+"~"+rec_high_no);
			}
		}
		//hmResult.put("doc_no",doc_no);
		return hmResult;
	}
	public void insertItemMoveSummaryForTFR (Connection connection,HashMap hmParameters) throws Exception {
		//System.out.println("AcknowledgementManager.java,insertItemMoveSummaryForTFR,hmParameters = > "+hmParameters);
		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();
		ArrayList alItemMoveSummRecord	=	new ArrayList();
//		ArrayList alCommonData			=	(ArrayList)	hmData1.get("COMMON_DATA");
		String l_doc_date	= (String)hmParameters.get("doc_date");
		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);
		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));
		//System.out.println("AcknowledgementManager.java,insertItemMoveSummaryForTFR,hmResult = > "+hmResult);
		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");
        /* For From record to be inserted in st_item_move_summ table */
		//Added by Rabbani on 15/04/2014
		String fm_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmParameters.get("store_code")).get("FACILITY_ID");
	     System.out.println("fm_facility_idfm_facility_id stock transfer===>" +fm_facility_id);

		alItemMoveSummRecord.clear();
		//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id
		alItemMoveSummRecord.add(fm_facility_id);      // facility_id
		alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code
		alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

	/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		//nafitive_value_to_zero.add(hmParameters.get("login_facility_id"));      // facility_id
		nafitive_value_to_zero.add(fm_facility_id);      // facility_id
		nafitive_value_to_zero.add(hmParameters.get("item_code"));     // Item code
		nafitive_value_to_zero.add(hmParameters.get("store_code"));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	
		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		//System.out.println("AcknowledgementManager.java,insertItemMoveSummaryForTFR,hmResult = > "+hmResult);

		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {
			alItemMoveSummRecord.clear();
			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));  // facility_id 
            alItemMoveSummRecord.add(fm_facility_id);      // facility_id			
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code      
			alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code     
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);
			//alItemMoveSummRecord.add("-"+hmParameters.get("trn_qty"));  //From Quantity
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //From Quantity
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value")); //month_closing_value = item_cost_value
			} 
			    //Cost value
			//alItemMoveSummRecord.add("-"+hmParameters.get("trn_qty"));      //From Quantity
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));      //From Quantity
			alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));    //Cost value
			//alItemMoveSummRecord.add("-"+hmParameters.get("trn_qty"));      //From out Quantity
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));      //From out Quantity
			alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));    //Cost out value
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

			stSQL	=	(String)hmSQL.get ("FmItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {
			alItemMoveSummRecord.clear();
			//alItemMoveSummRecord.add("-"+hmParameters.get("trn_qty"));  //From Quantity    
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //From Quantity    
			alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));    //Cost value       
			//alItemMoveSummRecord.add("-"+hmParameters.get("trn_qty"));      //From Quantity for month end
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));      //From Quantity for month end
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));  //month_closing_value = item_cost_value
			} 
			   //Cost value       
			//alItemMoveSummRecord.add("-"+hmParameters.get("trn_qty"));      //From out Quantity 
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));      //From out Quantity 
			alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));    //out Cost value       
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 
			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
			alItemMoveSummRecord.add(fm_facility_id);      // facility_id
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
			alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code   
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("FmItemMovSumFromUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}

		/* For To record to be inserted in st_item_move_summ table */
		String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmParameters.get("to_store_code")).get("FACILITY_ID");
        
		alItemMoveSummRecord.clear();
		//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
		alItemMoveSummRecord.add(to_facility_id);      // facility_id  
		alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
		alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // to_store_code   
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		//System.out.println("AcknowledgementManager.java,SummaryExistsCheckSQL,hmResult = > "+hmResult);
		summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {
			alItemMoveSummRecord.clear();
			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
			alItemMoveSummRecord.add(to_facility_id);      // facility_id  
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
			alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // to_store_code   
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);
			//alItemMoveSummRecord.add(hmParameters.get("trn_qty"));      //To Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));      //To Quantity
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("to_mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmParameters.get("to_trn_value")); //month_closing_value = item_cost_value
			} 
			    //Cost value
			//alItemMoveSummRecord.add(hmParameters.get("trn_qty"));      //To Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));      //To Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));    //Cost value
			//alItemMoveSummRecord.add(hmParameters.get("trn_qty"));      //To in Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));      //To in Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));    //in Cost value
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

			stSQL	=	(String)hmSQL.get ("ToItemMovSumInsertSQL");
			//System.out.println("Manager.java,stSQL = > "+stSQL);

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			//System.out.println("Manager.java,hmArgData = > "+hmArgData+" hmArgSQL = > "+hmArgSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			//System.out.println("Manager.java,hmReturn = > "+hmReturn);
			throwExceptionWhenFailed(hmReturn);
		}
		else {     
			alItemMoveSummRecord.clear();
			//alItemMoveSummRecord.add(hmParameters.get("trn_qty"));      //To Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));      //To Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));    //Cost value
			//alItemMoveSummRecord.add(hmParameters.get("trn_qty"));      //To Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));      //To Quantity
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("to_mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmParameters.get("to_trn_value")); //month_closing_value = item_cost_value
			}    //Cost value
			//alItemMoveSummRecord.add(hmParameters.get("trn_qty"));      //To in Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));      //To in Quantity
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));    //in Cost value
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 
			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
			alItemMoveSummRecord.add(to_facility_id);      // facility_id  
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
			alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // store_code   
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ToItemMovSumFromUpdateSQL");
			//System.out.println("Manager.java,stSQL = > "+stSQL);
			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			//System.out.println("Manager.java,hmArgData = > "+hmArgData+" hmArgSQL = > "+hmArgSQL+" hmReturn = > "+hmReturn);
			throwExceptionWhenFailed(hmReturn);

		}

			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		 //stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";

		 stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		//System.out.println("Manager.java,hmArgData = > "+hmArgData+" hmArgSQL = > "+hmArgSQL+" hmReturn = > "+hmReturn);
		throwExceptionWhenFailed(hmReturn);

	}
/*Code Starts for Issue*/
	public HashMap updateIssue(HashMap hmData, HashMap hmSQLValues){
		PreparedStatement preparedStatement	=	null;
		//ResultSet resultSet =	null;
		HashMap hmResult	=	new HashMap();
		HashMap hmArgData	=	new HashMap();
		HashMap hmArgSQL	=	new HashMap();
		hmResult.put("result", FALSE);
		hmSQL		= hmSQLValues;

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		ArrayList alCommonData	=	(ArrayList)hmData.get("COMMON_DATA");
		//System.out.println("alCommonData HSUGIS/HSRQIS====>" +alCommonData);
		
		ArrayList alData		=	new ArrayList(); 
		ArrayList alTempData	=	new ArrayList(); 
		String from_stk_item_yn =	"";
		String to_stk_item_yn   =	"";
		String dtl_unit_cost	=	"";
   		String sql				=	"";

		String fm_store_code	=	(String)(((HashMap)alDtlRecords.get(0)).get("store_code"));
		String to_store_code	=	(String)(((HashMap)alDtlRecords.get(0)).get("to_store_code"));
		String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
		ArrayList  hmparam = new ArrayList();    
		String p_from_bin_location_code		= "";
		String p_from_store_code			= ""; 
		String p_to_store_code				= "";
		String p_to_bin_location_code		= "";
		String p_item_code					= ""; 
		String p_batch_id					= ""; 
		String p_expiry_date_or_receipt_date= "";
		String mod_date						="";

		int iResult =	0;
		boolean isUpdateSuccessful = true;
		
		/*
			1) st_issue_hdr update
			2) st_issue_dtl update
			3) st_request_dtl update
			4) calculate And update online stock
			5) st_item_move_summ insert
			6) update batch online
			7) st_item_trn_dtl insert
			8) st_request_hdr update
		*/
		String stCurrentItemCodeInCaseOfError=null;

        try {
        	boolean site = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","MUL_FAC_TFR_BATCH_PRICE_MOVE"); //Added for MOHE-CRF-0001
            //properties = (Properties)hmData.get("properties");
            //connection = getConnection(properties);
            //connection.setAutoCommit(false);
			String trn_type = (String)alCommonData.get(4);
			String stSQLHdrUpdate = (String)	hmSQL.get	("IssueHdrUpdateSQL");
            
			 
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(BATCH_SQL,stSQLHdrUpdate);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			/**
			 * @Name - Priya
			 * @Date - 03/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			
			
			sql = (String)	hmSQL.get	("IssueQtyUpdateSQL");

			for (int i=0;i<alDtlRecords.size();i++) {
				alData	=	new ArrayList();
				HashMap hmDtlRecord = (HashMap)(alDtlRecords.get(i));
				//System.out.println("hmDtlRecord====1496==>" +hmDtlRecord);
				if(!(((String)hmDtlRecord.get("mode")).equals("0")) && !(((String)hmDtlRecord.get("mode")).equals("1"))) { 
					alData.add(hmDtlRecord.get("item_qty"));
					alData.add(hmDtlRecord.get("item_unit_cost"));
					alData.add(hmDtlRecord.get("item_cost_value"));
					alData.add(alCommonData.get(0)); // modified_by_id
					alData.add(alCommonData.get(1)); // modified_at_ws_no
					alData.add(alCommonData.get(2)); // modified_facility_id
					alData.add(hmDtlRecord.get("issue_uom"));
					alData.add(hmDtlRecord.get("issue_uom_conv"));
					alData.add(hmDtlRecord.get("issue_uom_qty"));
					
				String remarks =(String)hmDtlRecord.get("remarks");
				if(remarks==null || remarks.equals("null"))
				remarks="";
					alData.add(remarks);
					alData.add(hmDtlRecord.get("facility_id")); // facility_id - Where clause
					alData.add(alCommonData.get(3)); // doc_type_code - Where clause
					alData.add(hmDtlRecord.get("doc_no")); // doc_no - Where clause
					alData.add(hmDtlRecord.get("seq_no")); // seq_no - Where clause
					alData.add(hmDtlRecord.get("doc_srl_no")); // Where clause
					alTempData.add(alData);
				}
			}
			//commented by Rabbani on 18/06/12 no need to update ST_ISSUE_DTL
			/*hmArgData.put(DATA,alTempData);
			hmArgSQL.put(BATCH_SQL,sql);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);*/
			//ends
			
			//code added to Insert newly added  issue records...on 08/08/2004  
			/*
			// Commented By Mahesh on 10/12/2009 as Issue Qty need not to be updated at the time of acknowledgment.
			 This set of code also not required for Acknowledgemet. So commented by Mahesh on 10/12/2009
			sql = (String)	hmSQL.get	("InsertDTLSQL");
			alTempData = new ArrayList();
			for (int i=0;i<alDtlRecords.size();i++) {
				alData	=	new ArrayList();
				HashMap hmDtlRecord = (HashMap)(alDtlRecords.get(i));
				if(((String)hmDtlRecord.get("mode")).equals("1")) { 
					alData.add(alCommonData.get(2));					// facility_id		1
					alData.add(alCommonData.get(3));					// doc_type_code	2
					alData.add(hmDtlRecord.get("doc_no"));					// doc_no			3
					alData.add(hmDtlRecord.get("seq_no"));					// seq_no			4
					alData.add(hmDtlRecord.get("doc_srl_no"));		// doc_srl_no		5
					alData.add(hmDtlRecord.get("store_code"));		// store_code		6
					alData.add(hmDtlRecord.get("item_code"));		// item_code		7
					alData.add(hmDtlRecord.get("item_qty"));		// iss_item_qty		8
					alData.add(hmDtlRecord.get("item_cost_value"));	// item_cost_value	9
					alData.add(hmDtlRecord.get("item_unit_cost"));	// item_unit_cost	10
					alData.add("N"					);				// print_label_yn	11
					alData.add(hmDtlRecord.get("stock_item_yn"));	// stock_item_yn	12
					alData.add(hmDtlRecord.get("item_qty"));		// authorized_item_qty	13
					
					alData.add(alCommonData.get(0));					// added_by_id		14
					alData.add(alCommonData.get(1));					// added_at_ws_no	15
					alData.add(alCommonData.get(2));					// added_facility_id 16
					alData.add(alCommonData.get(0));					// modified_by_id	17
					alData.add(alCommonData.get(1));					// modified_at_ws_no	18
					alData.add(alCommonData.get(2));					// modified_facility_id	19
					alData.add(hmDtlRecord.get("issue_uom"));		// issue_uom			20		
					alData.add(hmDtlRecord.get("issue_uom_conv"));  // issue_uom_conv		21
					alData.add(hmDtlRecord.get("issue_uom_qty"));   // issue_uom_qty		22
					alTempData.add(alData);
				}
			}
			hmArgData.put(DATA,alTempData);
			hmArgSQL.put(BATCH_SQL,sql);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);*/
			alTempData = new ArrayList();
			boolean isFinalized		=	true;
			//added by Rabbani and Ganga #inc no:27426 on 08/08/11 starts
			ArrayList alHdrDataclosereqyn      =  (ArrayList)alHdrData.get(0);
            String close_req_yn      =  (String)alHdrDataclosereqyn.get(4); 
			 
			//ends
			/*if(trn_type.equals("ISS")) {
				//sql = (String)	hmSQL.get	("RequestQtyUpdateSQL");
				//preparedStatement = connection.prepareStatement(sql);
				for (int i=0; i<alDtlRecords.size();i++) {
					alData = new ArrayList ();
					HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
					if(!(((String)hmDtlRecord.get("mode")).equals("0"))) {
						sql = (String)	hmSQLValues.get	("CommitedQtySelect");
						ArrayList alQtyData  = new ArrayList ();
						//alQtyData.add(alCommonData.get(2)); // login_facility_id
						alQtyData.add(alCommonData.get(3)); //doc_type_code
						alQtyData.add(hmDtlRecord.get("doc_no")); //doc_no
						alQtyData.add(hmDtlRecord.get("item_code"));
						HashMap hmQtyValues = fetchRecord(connection,sql,alQtyData);
						int committed_Qty = 0;
						int pending_Qty	 = 0;
						if(hmQtyValues.get("COMMITTED_ITEM_QTY") != null) {
							committed_Qty = Integer.parseInt((String) hmQtyValues.get("COMMITTED_ITEM_QTY"));
						}
						if(hmQtyValues.get("PENDING_ITEM_QTY") != null) {
							pending_Qty = Integer.parseInt((String) hmQtyValues.get("PENDING_ITEM_QTY"));
						}
						int trn_qty =  Integer.parseInt((String)hmDtlRecord.get("to_str_qty"));

						if (isFinalized) 
							committed_Qty = 0;
						else
							committed_Qty = trn_qty ;
						if(pending_Qty - trn_qty < 0 ) {
							pending_Qty = 0;
						}
						else {
							pending_Qty = pending_Qty - trn_qty;
						}
						if (isFinalized )
							alData.add(hmDtlRecord.get("mm_trn_qty"));
						else
							alData.add("0");

						alData.add(""+committed_Qty);

						if (isFinalized )
							alData.add(""+pending_Qty);
						else
							alData.add(hmQtyValues.get("PENDING_ITEM_QTY"));
						alData.add(alCommonData.get(0)); // modified_by_id
						alData.add(alCommonData.get(1)); // modified_at_ws_no
						alData.add(alCommonData.get(2)); // modified_facility_id
						//alData.add(alCommonData.get(2)); // facility_id - Where clause
						alData.add(alCommonData.get(3)); // doc_type_code - Where clause
						alData.add(hmDtlRecord.get("doc_no")); // doc_no - Where clause
						alData.add(hmDtlRecord.get("item_code")); // Where clause
						alTempData.add(alData);
					}
				}
				sql = (String)	hmSQL.get	("RequestQtyUpdateSQL");
				hmArgData.put(DATA,alTempData);
				hmArgSQL.put(BATCH_SQL,sql);
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
			}*/
            HashMap hmItemInfo=new HashMap(); 
			//Added by Rabbani #inc no:31269 on 05/04/12 
		 	String old_dtl_doc_no="";  
			String old_dtl_seq_no="";	
            boolean to_check = true;			
			//System.out.println("alDtlRecords===1602===>"+alDtlRecords);
			//ends
			for (int i=0; i<alDtlRecords.size();i++) {
				HashMap hmDtlRecord = (HashMap)(alDtlRecords.get(i));
				//System.out.println("hmDtlRecord===1319===>"+hmDtlRecord);
					String dtl_doc_no = (String)hmDtlRecord.get("doc_no");
					String dtl_seq_no = (String)hmDtlRecord.get("seq_no");
					String dtl_item_code = (String)hmDtlRecord.get("item_code");
					       fm_store_code = (String)hmDtlRecord.get("store_code");
					
					ArrayList alStkYN		= new ArrayList ();
                    stCurrentItemCodeInCaseOfError=(String)hmDtlRecord.get("item_code");

					alStkYN.add(hmDtlRecord.get("item_code"));			
					alStkYN.add(fm_store_code);//from store code		   
					sql = (String)hmSQL.get("GetStockItemYNFlag");
					HashMap hmStkYN			= fetchRecord(connection, sql, alStkYN);
 					from_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
					alStkYN	=	new ArrayList();
					alStkYN.add(hmDtlRecord.get("item_code"));
					alStkYN.add(to_store_code);//to store code
					hmStkYN					= fetchRecord(connection, sql, alStkYN);
					to_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 

				    if(isFinalized && !(((String)hmDtlRecord.get("mode")).equals("0")) ) {

					double trn_qty				= Double.parseDouble((String)hmDtlRecord.get("tmp_item_qty"));
					double trn_value		= Double.parseDouble((String)hmDtlRecord.get("item_cost_value"));

					HashMap hmParameters = new HashMap();
					hmParameters.put("item_code",hmDtlRecord.get("item_code"));
					hmParameters.put("store_code",fm_store_code);
					hmParameters.put("to_store_code",to_store_code);
					hmParameters.put("trn_type",alCommonData.get(4));
					hmParameters.put("doc_date",hmDtlRecord.get("doc_date"));
					//hmParameters.put("trn_qty",hmDtlRecord.get("item_qty")); by ganga
					//hmParameters.put("trn_qty",hmDtlRecord.get("mm_trn_qty"));
					
					hmParameters.put("trn_unit_cost",hmDtlRecord.get("item_unit_cost"));
					//dtl_unit_cost=(String)hmDtlRecord.get("item_unit_cost");
					//Modified by suresh.r for item_unit_cost logic changes to st_item_trn_dtl table against inc#50521
					dtl_unit_cost=Double.toString(Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))/Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")));
					hmItemInfo.put(hmDtlRecord.get("item_code"),setNumber(dtl_unit_cost,noOfDecimalsForCost));
					//hmParameters.put("fm_trn_value",hmDtlRecord.get("item_cost_value")); //by ganga
					//double trn_val= Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty"))*Double.parseDouble(dtl_unit_cost);
					//hmParameters.put("fm_trn_value",""+trn_val);
					hmParameters.put("from_stk_item_yn","Y");//hmDtlRecord.get("stock_item_yn"));
					hmParameters.put("to_stk_item_yn",to_stk_item_yn);
					hmParameters.put("last_receipt_date",hmDtlRecord.get("doc_date"));
					hmParameters.put("last_issue_date",hmDtlRecord.get("doc_date"));
					hmParameters.put("login_by_id",alCommonData.get(0));
					hmParameters.put("login_at_ws_no",alCommonData.get(1));
					hmParameters.put("login_facility_id",alCommonData.get(2));
					hmParameters.put("to_str_qty",""+hmDtlRecord.get("to_str_qty"));
					hmParameters.put("mm_trn_qty",(String)hmDtlRecord.get("mm_trn_qty"));
					hmParameters.put("language_id",(String)hmDtlRecord.get("language_id"));
					hmParameters.put("mode","MODE_MODIFY"); //added by ganga on 07/06/2011
					//HARDCODED SQL
					//added by manish on Monday, January 26, 2004	
                  //added by Rabbani and Ganga #inc no:27426 on 08/08/11 starts
				  //commented by Rabbani #inc no: 31536 on 16/04/12 Starts
                  /*  double authorized_Qty = 0;
                    if(close_req_yn.equals("Y"))
     				{
                    String stSQL=(String)hmSQL.get("sql_st_issue_dtl_for_auth_qty");
                    ArrayList alauthQty  = new ArrayList ();
						alauthQty.add(alHdrDataclosereqyn.get(10)); //doc_type_code
						alauthQty.add(alHdrDataclosereqyn.get(11)); //doc_no
						alauthQty.add(hmDtlRecord.get("item_code"));
						alauthQty.add(alHdrDataclosereqyn.get(12));//seq_no
						
                        HashMap hmauthValues = fetchRecord(connection,stSQL,alauthQty);
							if(hmauthValues.get("AUTHORIZED_ITEM_QTY") != null) {
							authorized_Qty = Double.parseDouble((String) hmauthValues.get("AUTHORIZED_ITEM_QTY"));
						     }
						
						hmParameters.put("authorized_item_qty",authorized_Qty);
					}*/ //ends 10/04/12
                   // ended		08/08/11	
                    hmParameters.put("close_req_yn",close_req_yn); 				   
                     
					//commented by Rabbani #inc no: 31536 on 16/04/12 Starts
					/*if (to_stk_item_yn.equals("N")) {
						String stSQL=(String)hmSQL.get("SQL_ST_ISSUE_REQ_UPDATE_PENDING_REQ_QTY");
						//"update st_item_store set pending_req_qty=decode(sign(pending_req_qty+?),-1,0,(pending_req_qty+?)) where item_code=? and store_code=?";
						
						ArrayList alParameters1= new ArrayList();
						 //added by Rabbani and Ganga #inc no:27426 on 08/08/11  
						if (close_req_yn.equals("Y"))
						{
                        alParameters1.add("-"+authorized_Qty);
						alParameters1.add("-"+authorized_Qty);
						}else
						{
						alParameters1.add("-"+hmDtlRecord.get("item_qty"));
						alParameters1.add("-"+hmDtlRecord.get("item_qty"));
						}
						alParameters1.add(alCommonData.get(0));
						alParameters1.add(alCommonData.get(1));
						alParameters1.add(alCommonData.get(2));
						alParameters1.add(hmDtlRecord.get("item_code"));
						alParameters1.add(to_store_code);//To store code
						hmArgData.put(DATA,alParameters1);
						hmArgSQL.put(UPDATE_SQL,stSQL);
						HashMap hmRes=update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmRes);
					} */ //16/04/12
					
					double fm_str_qty =Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty")) /(getConvFactTemp((String)hmDtlRecord.get("item_code"),fm_store_code,hmSQL,(String)hmDtlRecord.get("language_id"),properties));
					double dtl_trn_val= Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble(""+fm_str_qty);
					/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
					hmParameters.put("trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));

					hmParameters.put("trn_qty",""+fm_str_qty); //added by ganga on Thursday, April 19, 2012
					hmParameters.put("fm_trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));


					//System.out.println("hmParameters===1412===>"+hmParameters);
					calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
					hmParameters.put("trn_value",hmDtlRecord.get("item_cost_value"));
					hmParameters.remove("to_str_qty");
					hmParameters.put("in_iss_qty", "0");  
					hmParameters.put("in_iss_cost", "0");  
					hmParameters.put("cons_qty", "0");  
					hmParameters.put("cons_cost", "0");  
					hmParameters.put("out_iss_qty_st", "0");  
					hmParameters.put("out_iss_cost_st", "0");  
					hmParameters.put("out_iss_qty_ns", "0");  
					hmParameters.put("out_iss_cost_ns", "0");  

					if(to_stk_item_yn.equals("Y")) {
						hmData.put("out_iss_qty_st", Double.toString(-trn_qty));  
						hmData.put("out_iss_cost_st", Double.toString(-trn_value));  
					}
					else {
						hmData.put("out_iss_qty_ns", Double.toString(-trn_qty));  
						hmData.put("out_iss_cost_ns", Double.toString(-trn_value));  
					}
					hmData.put("trn_qty", Double.toString(-trn_qty));
					hmData.put("trn_value", Double.toString(-trn_value));	
					hmData.put("out_iss_qty_st", "0");  
					hmData.put("out_iss_cost_st", "0");  
					hmData.put("out_iss_qty_ns", "0");  
					hmData.put("out_iss_cost_ns", "0");  

					hmData.put("store_code",to_store_code);//To store code
					hmData.put("trn_qty", Double.toString(trn_qty));
					hmData.put("trn_value", Double.toString(trn_value));	

					hmData.put("in_iss_qty", Double.toString(trn_qty));  
					hmData.put("in_iss_cost", Double.toString(trn_value));  

					if(to_stk_item_yn.equals("N")) {
						hmData.put("cons_qty", Double.toString(-trn_qty));  
						hmData.put("cons_cost", Double.toString(-trn_value));  
					}
					//double dtl_trn_cost = Double.parseDouble(checkForNull((String)hmDtlRecord.get("item_unit_cost"),"0"))/Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty"));
					hmParameters.put("mm_trn_qty",(String)hmDtlRecord.get("tmp_item_qty"));
					hmParameters.put("to_mm_trn_qty",(String)hmDtlRecord.get("mm_trn_qty"));
					//dtl_trn_val= dtl_trn_cost*Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty"));
					/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
					hmParameters.put("to_trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));
					//Added by suresh.r for item_unit_cost logic changes to st_item_move_summ table beg
					/*String item_move_trn_cost;
					item_move_trn_cost=Double.toString(Double.parseDouble((String)hmDtlRecord.get("item_cost_value"))/Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")));
					hmParameters.put("trn_value",item_move_trn_cost);
					item_move_trn_cost=Double.toString(dtl_trn_val/Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")));
					hmParameters.put("to_trn_value",""+setNumber(item_move_trn_cost,noOfDecimalsForCost));*/
					//Added by suresh.r for item_unit_cost logic changes to st_item_move_summ table end
					//System.out.println("hmParameters===1471===>"+hmParameters);
					insertItemMoveSummaryForISS (connection, hmParameters);					
					
				String exp_doc_no ="";
				String exp_seq_no ="";
				String exp_item_code="";
			for(int j=0;j<alExpRecords.size();j++) {
				HashMap hmDtlRecords		= (HashMap)alExpRecords.get(j);
				//System.out.println("hmDtlRecords:=1815=ejb=>" +hmDtlRecords);
				
				 exp_doc_no = (String)hmDtlRecords.get("DOC_NO");
				 exp_seq_no = (String)hmDtlRecords.get("SEQ_NO");
				 exp_item_code = (String)hmDtlRecords.get("ITEM_CODE");
				 //System.out.println("exp_doc_no===1488==>"+exp_doc_no+"=exp_seq_no==>"+exp_seq_no);
				 
				if (dtl_doc_no.equals(exp_doc_no) && dtl_seq_no.equals(exp_seq_no) && dtl_item_code.equals(exp_item_code)){
				HashMap hmBatchRecord	= new HashMap();
				hmBatchRecord.put("store_code", (String)hmDtlRecords.get("STORE_CODE"));
				hmBatchRecord.put("item_code", (String)hmDtlRecords.get("ITEM_CODE"));
				hmBatchRecord.put("batch_id", (String)hmDtlRecords.get("BATCH_ID"));
				hmBatchRecord.put("bin_location_code",checkForNull((String) (String)hmDtlRecords.get("BIN_LOCATION_CODE")));
						
				hmBatchRecord.put("expiry_date_or_receipt_date", (String)hmDtlRecords.get("EXPIRY_DATE"));
				//Added by Rabbani #inc no:33205 on 18/06/12
				double tmp_qty = 0.0;
				if(alCommonData.get(6).equals("A")){
				  tmp_qty = Double.parseDouble((String)hmDtlRecords.get("RECEIVED_QTY"))+Double.parseDouble(((String)hmDtlRecords.get("REJECTED_QTY")).equals("")?"0":(String)hmDtlRecords.get("REJECTED_QTY"));
				}else{
				  tmp_qty = Double.parseDouble((String)hmDtlRecords.get("TMP_RECEIVED_QTY_2"))+Double.parseDouble(((String)hmDtlRecords.get("TMP_REJECTED_QTY_2")).equals("")?"0":(String)hmDtlRecords.get("TMP_REJECTED_QTY_2"));
				}
				hmBatchRecord.put("trn_qty", ""+tmp_qty);
				hmBatchRecord.put("login_by_id",alCommonData.get(0));
				hmBatchRecord.put("login_at_ws_no",alCommonData.get(1));
				hmBatchRecord.put("login_facility_id",alCommonData.get(2));
				//System.out.println("hmBatchRecord===1493===>"+hmBatchRecord);
				//Added by Rabbani #inc no:31269 on 05/04/12
				if ((old_dtl_doc_no.equals(dtl_doc_no) && old_dtl_seq_no.equals(dtl_seq_no)) || old_dtl_doc_no.equals("")){
				//System.out.println("if condition 1765====>");
				hmBatchRecord.put("modified_date",(String)hmDtlRecords.get("modified_date")); //Added by Rabbani #inc no:31269 on 21/03/12 
				}else{
				//System.out.println("else condition 1765====>");
				hmDtlRecords.put("modified_date","");
				old_dtl_doc_no = "not_check";
				to_check = false;
				}
				//ends
				//System.out.println("hmBatchRecord===1850==>"+hmBatchRecord);
				hmResult	=	blockReleaseBatch(connection, hmBatchRecord,hmSQL, 'R');
				throwExceptionWhenFailed(hmResult);
				}	
			}			
			
			//System.out.println("alExpRecords===1856==>"+alExpRecords);
			
			for (int k=0;k<alExpRecords.size();k++) {
				HashMap hmExpRecord = (HashMap)alExpRecords.get(k);
				
				 exp_doc_no = (String)hmExpRecord.get("DOC_NO");
				 exp_seq_no = (String)hmExpRecord.get("SEQ_NO");
				 exp_item_code = (String)hmExpRecord.get("ITEM_CODE");
				 //System.out.println("exp_doc_no===1516==>"+exp_doc_no+"=exp_seq_no==>"+exp_seq_no);
				if (dtl_doc_no.equals(exp_doc_no) && dtl_seq_no.equals(exp_seq_no) && dtl_item_code.equals(exp_item_code)){
				
				//System.out.println("hmExpRecord===1601==>"+hmExpRecord);
				HashMap exp_hmParameters = new HashMap();

				stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				exp_hmParameters.put("item_code",hmExpRecord.get("ITEM_CODE"));
				exp_hmParameters.put("store_code",fm_store_code);
				exp_hmParameters.put("to_store_code",to_store_code);
				exp_hmParameters.put("trn_type",trn_type);
				//Added by Rabbani #inc no:33205 on 18/06/12
				if(alCommonData.get(6).equals("A")){
				exp_hmParameters.put("trn_qty",hmExpRecord.get("RECEIVED_QTY"));  
				}else{
				exp_hmParameters.put("trn_qty",hmExpRecord.get("TMP_RECEIVED_QTY_2"));  
				}
				exp_hmParameters.put("batch_id",hmExpRecord.get("BATCH_ID"));
				exp_hmParameters.put("expiry_date_or_receipt_date",hmExpRecord.get("EXPIRY_DATE"));
				exp_hmParameters.put("trade_id",hmExpRecord.get("TRADE_ID"));
				exp_hmParameters.put("from_bin_location_code",checkForNull((String)hmExpRecord.get("BIN_LOCATION_CODE")));
				String s_to = checkForNull((String) hmExpRecord.get("TO_BIN_LOCATION_CODE"));
				exp_hmParameters.put("to_bin_location_code", s_to);
                 //commented by Rabbani #inc no:29537 on 15/11/11
				//exp_hmParameters.put("suspended_batch_allowed_yn", "N");
				exp_hmParameters.put("suspended_batch_allowed_yn", "Y");
				exp_hmParameters.put("release_batch_yn", "N");
				exp_hmParameters.put("last_receipt_date",hmExpRecord.get("DOC_DATE"));
				exp_hmParameters.put("last_issue_date", hmExpRecord.get("DOC_DATE"));

				exp_hmParameters.put("login_by_id",alCommonData.get(0));
				exp_hmParameters.put("login_at_ws_no",alCommonData.get(1));
				exp_hmParameters.put("login_facility_id",alCommonData.get(2));
			//String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
				  hmparam = new ArrayList();
			            
				 p_from_bin_location_code		= checkForNull (exp_hmParameters.get("from_bin_location_code"));
				 p_from_store_code				= checkForNull (exp_hmParameters.get("store_code")); 
				 p_to_store_code					= checkForNull	(exp_hmParameters.get("to_store_code"));
				 p_to_bin_location_code			= checkForNull (exp_hmParameters.get("to_bin_location_code"));
				 p_item_code						= checkForNull (exp_hmParameters.get("item_code")); 
				 p_batch_id						= checkForNull (exp_hmParameters.get("batch_id")); 
				 p_expiry_date_or_receipt_date	= checkForNull (exp_hmParameters.get("expiry_date_or_receipt_date"));
				 String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), p_to_store_code).get("FACILITY_ID");//added for MOHE-CRF-0001 start
				 String fm_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), p_from_store_code).get("FACILITY_ID");
				 if(site){
		                if(!(fm_facility_id.equals(to_facility_id))){
							CallableStatement callableStatement = null;
							callableStatement	= connection.prepareCall("{ call bl_create_material_batch_price (?,?,?,?,?,?,?,?,?,?,?) }");
							callableStatement.setString(1, (String)hmExpRecord.get("ITEM_CODE"));
							callableStatement.setString(2, (String)hmExpRecord.get("TRADE_ID")); //modified for [TFS ID-14966]
							callableStatement.setString(3, (String)hmExpRecord.get("BATCH_ID"));//END
							callableStatement.setString(4, "");
							callableStatement.setString(5, (String)alCommonData.get(0));
							callableStatement.setString(6, (String)alCommonData.get(1));
							callableStatement.registerOutParameter(7, Types.VARCHAR);
							callableStatement.registerOutParameter(8, Types.VARCHAR);
							callableStatement.registerOutParameter(9, Types.VARCHAR);
							callableStatement.setString(10, (String)fm_facility_id);
							callableStatement.setString(11, (String)to_facility_id);
							callableStatement.execute();
							closeStatement(callableStatement);//COMMON-ICN-0118
						}
		                }//Added for  MOHE-CRF-0001 end
						   hmparam.add(p_from_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_from_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
						   							   
						   exp_hmParameters.put("modified_date",mod_date);
						   hmparam = new ArrayList();
						    hmparam.add(p_to_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_to_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
					
						   exp_hmParameters.put("to_modified_date",mod_date);
						   
						   
			   //Added by Rabbani #inc no:33205 on 18/06/12
			    if(alCommonData.get(6).equals("A")){
				if((Double.parseDouble((String)hmExpRecord.get("RECEIVED_QTY"))) > 0){
				//System.out.println("exp_hmParameters===1944===>"+exp_hmParameters);
					updateBatchOnLine(connection, hmSQL, exp_hmParameters);
				}
				}else{
				if((Double.parseDouble((String)hmExpRecord.get("TMP_RECEIVED_QTY_2"))) > 0){
				//System.out.println("exp_hmParameters===1950===>"+exp_hmParameters);
					updateBatchOnLine(connection, hmSQL, exp_hmParameters);
				}
				}

				//int trn_qty = Integer.parseInt((String)hmExpRecord.get("ISSUE_QTY"));
				// trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"))+ Double.parseDouble(((String)hmExpRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmExpRecord.get("REJECTED_QTY"));
				
				//Added by Rabbani #inc no:33205 on 18/06/12
				if(alCommonData.get(6).equals("A")){
				 trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"))+ Double.parseDouble(((String)hmExpRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmExpRecord.get("REJECTED_QTY"));
				}else{
				 trn_qty = Double.parseDouble(((String)hmExpRecord.get("TMP_RECEIVED_QTY_2")).equals("")?"0":(String)hmExpRecord.get("TMP_RECEIVED_QTY_2"));
				}
				
				exp_hmParameters.put("trn_qty", Double.toString(-trn_qty));						
				exp_hmParameters.put("doc_type_code",alCommonData.get(3));
				exp_hmParameters.put("other_store_code", to_store_code);
				exp_hmParameters.put("doc_no", hmExpRecord.get("DOC_NO"));
				exp_hmParameters.put("doc_srl_no", hmExpRecord.get("doc_srl_no"));
				exp_hmParameters.put("doc_date", hmExpRecord.get("DOC_DATE")); 
				exp_hmParameters.put("doc_ref", ""); 
				exp_hmParameters.put("stk_uom_code", hmExpRecord.get("uom_code"));
				exp_hmParameters.put("stock_item_yn", from_stk_item_yn);
				exp_hmParameters.put("bin_location_code",checkForNull((String)hmExpRecord.get("BIN_LOCATION_CODE")));
				dtl_unit_cost=(String)hmItemInfo.get(hmExpRecord.get("ITEM_CODE"));

				exp_hmParameters.put("item_unit_cost",dtl_unit_cost);	
				exp_hmParameters.put("seq_no",hmExpRecord.get("SEQ_NO"));	
				if(trn_qty>0){
				//System.out.println("exp_hmParameters===1679==>"+exp_hmParameters);
					insertItemTrnDetail(connection, exp_hmParameters, hmSQL, 1);		 				
				}

				sql = (String)hmSQL.get("GetStockItemYNFlag");
				alStkYN	=	new ArrayList();
				alStkYN.add(hmExpRecord.get("ITEM_CODE"));
				alStkYN.add(to_store_code);// To store Code
				
				hmStkYN = new HashMap();				
				hmStkYN					= fetchRecord(connection, sql, alStkYN);
				to_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
				//Added by Rabbani #inc no:33205 on 18/06/12
				if(alCommonData.get(6).equals("A")){
				trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"));
				}else{
				trn_qty = Double.parseDouble(((String)hmExpRecord.get("TMP_RECEIVED_QTY_2")).equals("")?"0":(String)hmExpRecord.get("TMP_RECEIVED_QTY_2"));
				}
				exp_hmParameters.put("stock_item_yn", to_stk_item_yn);
				exp_hmParameters.put("item_unit_cost",dtl_unit_cost);
				exp_hmParameters.put("bin_location_code",checkForNull((String) hmExpRecord.get("TO_BIN_LOCATION_CODE")));

				exp_hmParameters.put("store_code", to_store_code);//To store code
				exp_hmParameters.put("other_store_code", fm_store_code);//From store code
				exp_hmParameters.put("trn_qty", Double.toString(trn_qty));	
				exp_hmParameters.put("stk_uom_code", hmExpRecord.get("TO_UOM_CODE"));
				if(trn_qty > 0 ){
				//System.out.println("exp_hmParameters===1682==>"+exp_hmParameters);
					insertItemTrnDetail(connection, exp_hmParameters, hmSQL, 2);
				}

				if (to_stk_item_yn.equals("N")) {
					exp_hmParameters.put("trn_qty", "-"+Double.toString(trn_qty));
					exp_hmParameters.put("item_unit_cost",dtl_unit_cost);	
					exp_hmParameters.put("trn_type", "CON");
					exp_hmParameters.put("store_code", to_store_code);//To store code
					exp_hmParameters.put("other_store_code", fm_store_code);//From Store code
					exp_hmParameters.put("stk_uom_code", hmExpRecord.get("TO_UOM_CODE"));
					if(trn_qty>0){
					//System.out.println("exp_hmParameters===1711==>"+exp_hmParameters);
						insertItemTrnDetail(connection, exp_hmParameters, hmSQL, 3);		 				
					}
				  }
				}
			}	
			
			
				}
				
				 
				//Added by Rabbani #inc no:31269 on 05/04/12
				if(to_check){
				old_dtl_doc_no = dtl_doc_no;
				old_dtl_seq_no = dtl_seq_no;
				}
			  //ends
			}
			/* To release the batches for the deleted batches
			*/
			//ArrayList alBatchesToBeReleased = new ArrayList ();
			/*commented by ganga
			HashMap hmBatchRecord	= new HashMap();
			HashMap hmDtlRecord		= new HashMap();
			for(int i=0;i<alExpRecords.size();i++) {
				hmDtlRecord		= (HashMap)alExpRecords.get(i);
				hmBatchRecord	= new HashMap();
				hmBatchRecord.put("store_code", (String)hmDtlRecord.get("STORE_CODE"));
				hmBatchRecord.put("item_code", (String)hmDtlRecord.get("ITEM_CODE"));
				hmBatchRecord.put("batch_id", (String)hmDtlRecord.get("BATCH_ID"));
				hmBatchRecord.put("bin_location_code",checkForNull((String) (String)hmDtlRecord.get("BIN_LOCATION_CODE")));
						
				hmBatchRecord.put("expiry_date_or_receipt_date", (String)hmDtlRecord.get("EXPIRY_DATE"));
				double tmp_qty = Double.parseDouble((String)hmDtlRecord.get("RECEIVED_QTY"))+Double.parseDouble(((String)hmDtlRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmDtlRecord.get("REJECTED_QTY"));
				hmBatchRecord.put("trn_qty", ""+tmp_qty);
				hmBatchRecord.put("login_by_id",alCommonData.get(0));
				hmBatchRecord.put("login_at_ws_no",alCommonData.get(1));
				hmBatchRecord.put("login_facility_id",alCommonData.get(2));
				System.out.println("hmBatchRecord===1493===>"+hmBatchRecord);
				hmResult	=	blockReleaseBatch(connection, hmBatchRecord,hmSQL, 'R');
				throwExceptionWhenFailed(hmResult);
			}commented end*/


			/* Code to delete all the batches related to all the dtl records
			*/

			//HashMap		hmDelResult =	new HashMap(); 
			/*ArrayList alDelData = new ArrayList();
			//alDelData.add(alCommonData.get(2)); //facility_id
			alDelData.add(alCommonData.get(3)); //	doc_type_code
			alDelData.add(""); //  doc_no
			alDelData.add(""); //  seq_no
			alDelData.add("1"); // Dummy srl no - to be replaced 

			sql						=	(String)hmSQL.get("stSQLExpDelete");
			for(int i=0;i<alDtlRecords.size();i++) {
				hmDtlRecord = (HashMap)alDtlRecords.get(i);
				if((((String)hmDtlRecord.get("mode")).equals("1"))) {
					continue;
				}
				alDelData.set(1, hmDtlRecord.get("doc_no"));
				alDelData.set(2, hmDtlRecord.get("seq_no"));
				alDelData.set(3, hmDtlRecord.get("doc_srl_no"));
				hmArgData.put(DATA,alDelData);
				hmArgSQL.put(DELETE_SQL,sql);
				hmDelResult	=	delete(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmDelResult);
			}*/
			/* To delete all the detail record which has been marked for deletion
			*/
			for(int i=0;i<alDtlRecords.size();i++) {
				sql = (String)hmSQL.get("stSQLDtlDelete");
				HashMap hmDtlRecord = (HashMap)alDtlRecords.get(i);
				if((((String)hmDtlRecord.get("mode")).equals("0"))) {
					ArrayList alDtlDelData = new ArrayList();
					alDtlDelData.add(alCommonData.get(2)); //facility_id
					alDtlDelData.add(alCommonData.get(3)); //doc_type_code
					alDtlDelData.add(hmDtlRecord.get("doc_no")); //  doc_no
					alDtlDelData.add(hmDtlRecord.get("doc_srl_no"));
					alDtlDelData.add(hmDtlRecord.get("seq_no")); //  seq_no
					
					//commented by Rabbani on 14/06/12 no need to Delete st_issue_dtl
					/*hmArgData.put(DATA,alDtlDelData);
					hmArgSQL.put(DELETE_SQL,sql);
					hmDelResult	=	delete(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmDelResult);*/
				}
			}
			/* To add all new batches
			*/
			//Commented By Mahesh On 9/20/2009
			/*ArrayList alBatchInsertData = new ArrayList ();
			for(int i=0;i<alExpRecords.size();i++) {
				HashMap hmExpRecord = (HashMap)alExpRecords.get(i);
				ArrayList alBatchData = new ArrayList();
				alBatchData.add(hmExpRecord.get("FACILITY_ID")); // facility_id
				alBatchData.add(alCommonData.get(3)); // doc_type_code
				alBatchData.add(hmExpRecord.get("DOC_NO")); // doc_no
				alBatchData.add(hmExpRecord.get("SEQ_NO")); // seq_no
				alBatchData.add(hmExpRecord.get("doc_srl_no")); 
				alBatchData.add(hmExpRecord.get("STORE_CODE")); 
				alBatchData.add(hmExpRecord.get("ITEM_CODE")); 
				alBatchData.add(hmExpRecord.get("BATCH_ID"));
				alBatchData.add(checkForNull((String)hmExpRecord.get("BIN_LOCATION_CODE"))); 
				alBatchData.add(hmExpRecord.get("EXPIRY_DATE")); 
				alBatchData.add(hmExpRecord.get("TRADE_ID")); 
				alBatchData.add(hmExpRecord.get("ISSUE_QTY")); 
				alBatchData.add(checkForNull(hmExpRecord.get("RET_ITEM_QTY"),"0")); 
				alBatchData.add(checkForNull((String)hmExpRecord.get("TO_BIN_LOCATION_CODE"))); 
				alBatchData.add(alCommonData.get(0)); // added_by_id
				alBatchData.add(alCommonData.get(1)); // added_at_ws_no
				alBatchData.add(hmExpRecord.get("FACILITY_ID")); // added_facility_id
				alBatchData.add(alCommonData.get(0)); // modified_by_id
				alBatchData.add(alCommonData.get(1)); // modified_at_ws_no
				alBatchData.add(alCommonData.get(2)); // modified_facility_id

				alBatchInsertData.add(alBatchData);
			}
			sql = (String) hmSQL.get("stSQLExpInsert");
			hmArgData.put(DATA, alBatchInsertData);
			hmArgSQL.put(BATCH_SQL, sql);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);*/ 
			
			/*commented by ganga	
			if(!(isFinalized)) {
				for(int i=0;i<alExpRecords.size();i++) {
					HashMap hmExpRecord = (HashMap)alExpRecords.get(i);
					HashMap hmBatchData = new HashMap();  	
                    stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
					hmBatchData.put("store_code", hmExpRecord.get("STORE_CODE"));
					hmBatchData.put("item_code", hmExpRecord.get("ITEM_CODE"));
					hmBatchData.put("batch_id", hmExpRecord.get("BATCH_ID"));
					hmBatchData.put("bin_location_code",checkForNull((String) hmExpRecord.get("BIN_LOCATION_CODE")));

					hmBatchData.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_DATE"));
					hmBatchData.put("trn_qty", hmExpRecord.get("ISSUE_QTY"));
					hmBatchData.put("login_by_id",alCommonData.get(0));
					hmBatchData.put("login_at_ws_no",alCommonData.get(1));
					hmBatchData.put("login_facility_id",alCommonData.get(2));
					System.out.println("hmBatchData===1592===>"+hmBatchData);
					hmResult	=	blockReleaseBatch(connection, hmBatchData,hmSQL, 'B');
					throwExceptionWhenFailed(hmResult);
				}
			}	 
			System.out.println("alExpRecords===1598==>"+alExpRecords);
			for (int i=0;i<alExpRecords.size();i++) {
				HashMap hmExpRecord = (HashMap)alExpRecords.get(i);
				System.out.println("hmExpRecord===1601==>"+hmExpRecord);
				HashMap hmParameters = new HashMap();

				stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				hmParameters.put("item_code",hmExpRecord.get("ITEM_CODE"));
				hmParameters.put("store_code",fm_store_code);
				hmParameters.put("to_store_code",to_store_code);
				hmParameters.put("trn_type",trn_type);
				hmParameters.put("trn_qty",hmExpRecord.get("RECEIVED_QTY"));
				hmParameters.put("batch_id",hmExpRecord.get("BATCH_ID"));
				hmParameters.put("expiry_date_or_receipt_date",hmExpRecord.get("EXPIRY_DATE"));
				hmParameters.put("trade_id",hmExpRecord.get("TRADE_ID"));
				hmParameters.put("from_bin_location_code",checkForNull((String)hmExpRecord.get("BIN_LOCATION_CODE")));
				String s_to = checkForNull((String) hmExpRecord.get("TO_BIN_LOCATION_CODE"));
				hmParameters.put("to_bin_location_code", s_to);
                 //commented by Rabbani #inc no:29537 on 15/11/11
				//hmParameters.put("suspended_batch_allowed_yn", "N");
				hmParameters.put("suspended_batch_allowed_yn", "Y");
				hmParameters.put("release_batch_yn", "N");
				hmParameters.put("last_receipt_date",hmExpRecord.get("DOC_DATE"));
				hmParameters.put("last_issue_date", hmExpRecord.get("DOC_DATE"));

				hmParameters.put("login_by_id",alCommonData.get(0));
				hmParameters.put("login_at_ws_no",alCommonData.get(1));
				hmParameters.put("login_facility_id",alCommonData.get(2));
			//String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
				  hmparam = new ArrayList();
			            
				 p_from_bin_location_code		= checkForNull (hmParameters.get("from_bin_location_code"));
				 p_from_store_code				= checkForNull (hmParameters.get("store_code")); 
				 p_to_store_code					= checkForNull	(hmParameters.get("to_store_code"));
				 p_to_bin_location_code			= checkForNull (hmParameters.get("to_bin_location_code"));
				 p_item_code						= checkForNull (hmParameters.get("item_code")); 
				 p_batch_id						= checkForNull (hmParameters.get("batch_id")); 
				 p_expiry_date_or_receipt_date	= checkForNull (hmParameters.get("expiry_date_or_receipt_date"));
						
						   hmparam.add(p_from_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_from_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
						   							   
						   hmParameters.put("modified_date",mod_date);
						   hmparam = new ArrayList();
						    hmparam.add(p_to_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_to_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
					
						   hmParameters.put("to_modified_date",mod_date);
			
			
				if((Double.parseDouble((String)hmExpRecord.get("RECEIVED_QTY"))) > 0){
				System.out.println("hmParameters===1656===>"+hmParameters);
					updateBatchOnLine(connection, hmSQL, hmParameters);
				}

				//int trn_qty = Integer.parseInt((String)hmExpRecord.get("ISSUE_QTY"));
				double trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"))+ Double.parseDouble(((String)hmExpRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmExpRecord.get("REJECTED_QTY"));;

				hmParameters.put("trn_qty", Double.toString(-trn_qty));						
				hmParameters.put("doc_type_code",alCommonData.get(3));
				hmParameters.put("other_store_code", to_store_code);
				hmParameters.put("doc_no", hmExpRecord.get("DOC_NO"));
				hmParameters.put("doc_srl_no", hmExpRecord.get("doc_srl_no"));
				hmParameters.put("doc_date", hmExpRecord.get("DOC_DATE")); 
				hmParameters.put("doc_ref", ""); 
				hmParameters.put("stk_uom_code", hmExpRecord.get("uom_code"));
				hmParameters.put("stock_item_yn", from_stk_item_yn);
				hmParameters.put("bin_location_code",checkForNull((String)hmExpRecord.get("BIN_LOCATION_CODE")));
				dtl_unit_cost=(String)hmItemInfo.get(hmExpRecord.get("ITEM_CODE"));

				hmParameters.put("item_unit_cost",dtl_unit_cost);	
				hmParameters.put("seq_no",hmExpRecord.get("SEQ_NO"));	
				if(trn_qty>0){
				System.out.println("hmParameters===1679==>"+hmParameters);
					insertItemTrnDetail(connection, hmParameters, hmSQL, 1);		 				
				}

				sql = (String)hmSQL.get("GetStockItemYNFlag");
				ArrayList alStkYN	=	new ArrayList();
				alStkYN.add(hmExpRecord.get("ITEM_CODE"));
				alStkYN.add(to_store_code);// To store Code

				HashMap hmStkYN					= fetchRecord(connection, sql, alStkYN);
				to_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
				trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"));
				hmParameters.put("stock_item_yn", to_stk_item_yn);
				hmParameters.put("item_unit_cost",dtl_unit_cost);
				hmParameters.put("bin_location_code",checkForNull((String) hmExpRecord.get("TO_BIN_LOCATION_CODE")));

				hmParameters.put("store_code", to_store_code);//To store code
				hmParameters.put("other_store_code", fm_store_code);//From store code
				hmParameters.put("trn_qty", Double.toString(trn_qty));	
				hmParameters.put("stk_uom_code", hmExpRecord.get("TO_UOM_CODE"));
				if(trn_qty > 0 ){
					insertItemTrnDetail(connection, hmParameters, hmSQL, 2);
				}

				if (to_stk_item_yn.equals("N")) {
					hmParameters.put("trn_qty", "-"+Double.toString(trn_qty));
					hmParameters.put("item_unit_cost",dtl_unit_cost);	
					hmParameters.put("trn_type", "CON");
					hmParameters.put("store_code", to_store_code);//To store code
					hmParameters.put("other_store_code", fm_store_code);//From Store code
					hmParameters.put("stk_uom_code", hmExpRecord.get("TO_UOM_CODE"));
					if(trn_qty>0){
					System.out.println("hmParameters===1711==>"+hmParameters);
						insertItemTrnDetail(connection, hmParameters, hmSQL, 3);		 				
					}
				}
			}commented ended*/
			//Comment removed by Badmavathi against ML-BRU-SCF-1555 starts
			ArrayList alHdrData1 = new ArrayList();
			if (isFinalized && trn_type.equals("ISS")) {
				for(int i=0;i<alHdrData.size();i++){
					alHdrData1 = (ArrayList)alHdrData.get(i);
					/*ArrayList alStatusParam = new ArrayList ();
					alStatusParam.add(alCommonData.get(2));//facility id
					alStatusParam.add(alCommonData.get(3));//doc_type_code
					alStatusParam.add(alHdrData1.get(11));//doc_no
					String close_req_yn = (String)alHdrData1.get(4); // close_req_after_issue_yn
					String status  = "";
					sql = (String)	hmSQL.get	("RequestStatusSelect");
					HashMap statusMap = fetchRecord(connection,sql,alStatusParam);
					status  = (String) statusMap.get("STATUS");
					if (status !=null && (!status.equals("1"))) {
						status = status.trim();
						if (status.equals("2")) {
							status = "C";
						}
						else if (status.equals("3")) {
							status = "P";
						}
						if (status.equals("P") && close_req_yn.equals("Y")) {
							status = "L";
						}*/					

						sql = (String)	hmSQLValues.get	("RequestStatusUpdateSQL");
						preparedStatement = connection.prepareStatement(sql);

						alData = new ArrayList();
						//alData.add(status); // request_status
						alData.add(alCommonData.get(0)); // modified_by_id
						alData.add(alCommonData.get(1)); // modified_at_ws_no
						alData.add(alCommonData.get(2)); // modified_facility_id
						//alData.add(alCommonData.get(2)); // facility_id - Where clause
						alData.add(alCommonData.get(3)); // doc_type_code - Where clause
						alData.add(alHdrData1.get(11)); // doc_no - Where clause

						setData(preparedStatement,alData);
						iResult  = preparedStatement.executeUpdate();
						if (iResult<=0) {
							isUpdateSuccessful = false;
						}
						closeStatement(preparedStatement);//COMMON-ICN-0118
						if(!isUpdateSuccessful){
							hmResult.put(RESULT,FALSE);
							hmResult.put(MESSAGE,"FAILED");
							connection.rollback();
							throw new Exception("Update failed in Request header record");
						}
					}
					if (isUpdateSuccessful) {
						connection.commit();
						closeStatement(preparedStatement);//COMMON-ICN-0118
					}
				}
			//}
            connection.commit(); //comment removed ends 
        }
        catch(Exception exception){
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
            hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmResult.put("flag",stCurrentItemCodeInCaseOfError);
			}

        }
		if(!isUpdateSuccessful) {
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,"FAILED");
		}
        //hmResult.put("doc_no",doc_no);
		return hmResult;
    }
	public void insertItemTrnDetail(Connection connection, HashMap hmData, HashMap hmSQL, int srl_no) throws Exception {
		try {
			String l_trn_srl_no = Integer.toString(srl_no);
			ArrayList alTrnDtlList = new ArrayList();
			HashMap	hmArgData				=	new HashMap();
			HashMap	hmArgSQL				=	new HashMap();
			HashMap hmReturn				=	new HashMap();
			
			String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmData.get("store_code")).get("FACILITY_ID"); //Added by Rabbani on 15/04/2014
			
			alTrnDtlList.clear();
			//alTrnDtlList.add(hmData.get("login_facility_id"));
			alTrnDtlList.add(to_facility_id);
			alTrnDtlList.add(hmData.get("store_code"));
			alTrnDtlList.add(hmData.get("item_code"));
			alTrnDtlList.add(l_trn_srl_no);
			alTrnDtlList.add(hmData.get("trn_type"));
			alTrnDtlList.add(hmData.get("doc_type_code"));
			alTrnDtlList.add(hmData.get("doc_no"));
			alTrnDtlList.add(hmData.get("doc_srl_no"));
			alTrnDtlList.add(hmData.get("doc_date"));
			alTrnDtlList.add(hmData.get("doc_ref"));
			alTrnDtlList.add(hmData.get("batch_id"));
			alTrnDtlList.add(hmData.get("expiry_date_or_receipt_date"));
			alTrnDtlList.add(hmData.get("trn_qty"));
			alTrnDtlList.add(hmData.get("item_unit_cost"));
			alTrnDtlList.add(hmData.get("stk_uom_code"));
			alTrnDtlList.add(hmData.get("stock_item_yn"));	  
			alTrnDtlList.add(hmData.get("login_by_id"));
			alTrnDtlList.add(hmData.get("login_at_ws_no"));
			alTrnDtlList.add(hmData.get("login_facility_id"));
			alTrnDtlList.add(hmData.get("login_by_id"));
			alTrnDtlList.add(hmData.get("login_at_ws_no"));
			alTrnDtlList.add(hmData.get("login_facility_id"));
			String s_trn_bin = (String) hmData.get("bin_location_code"); 
			if (s_trn_bin == null){
			alTrnDtlList.add(""); 
			}
			else{
			alTrnDtlList.add(hmData.get("bin_location_code")); 
			}
			alTrnDtlList.add(hmData.get("trade_id"));		  
			alTrnDtlList.add(hmData.get("other_store_code"));	
			String s_seq_no = (String) hmData.get("seq_no"); 
			if (s_seq_no == null){
			alTrnDtlList.add("1"); 
			}
			else{
			alTrnDtlList.add(hmData.get("seq_no")); 
			}
			/*
			//Added for GHL-SCF-1103 starts //Comening start for KDAH-SCF-0446
			ArrayList alTrnDtlNew = new ArrayList();
			alTrnDtlNew.add(to_facility_id);
			alTrnDtlNew.add(hmData.get("doc_type_code"));
			alTrnDtlNew.add(hmData.get("doc_no"));
			alTrnDtlNew.add(hmData.get("item_code"));
			alTrnDtlNew.add(hmData.get("store_code"));
	        alTrnDtlNew.add(hmData.get("batch_id"));
	        alTrnDtlNew.add(hmData.get("expiry_date_or_receipt_date"));
	        if (s_trn_bin == null){
	        	alTrnDtlNew.add(""); 
				}
				else{
					alTrnDtlNew.add(hmData.get("bin_location_code")); 
				}
	    	if (s_seq_no == null){
	    		alTrnDtlNew.add("1"); 
				}
				else{
					alTrnDtlNew.add(hmData.get("seq_no")); 
				}
	    	 alTrnDtlNew.add(hmData.get("trn_type"));//Added against KDAH-SCF-0433
			System.out.println("to_facility_idvalue"+to_facility_id);
			System.out.println("doc_type_codevalue"+hmData.get("doc_type_code"));
			System.out.println("doc_novalue"+hmData.get("doc_no"));
			System.out.println("item_codevalue"+hmData.get("item_code"));
			System.out.println("store_codevalue"+hmData.get("store_code"));
			System.out.println("batch_idvalue"+hmData.get("batch_id"));  
			
			System.out.println("alTrnDtlNew ---> "+alTrnDtlNew);
			
			int chkCount=Integer.parseInt((String)fetchRecord(connection, eST.Common.StRepository.getStKeyValue("SQL_ITEM_TRN_DTL_INSERT_ISSUE_COUNT"), alTrnDtlNew).get("CNT"));
			System.out.println("countvalue"+chkCount);
			if(chkCount==0){*/
				String stSQL	=	(String)	hmSQL.get ("ItemTrnDtlInsertSQL");
				hmArgData.put(DATA,alTrnDtlList);
				hmArgSQL.put(INSERT_SQL,stSQL);									  
				hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			/*}
			else{
				System.out.println("inside else exception has to be thrown");
				hmData.put(RESULT,FALSE);
				hmData.put(MESSAGE,"FAILED");
				throwExceptionWhenFailed(hmData);
			}*/
						//Added for GHL-SCF-1103 ends
		}
		catch (Exception ex) {
			ex.printStackTrace();
			hmData.put("RESULT", FALSE);
			hmData.put(MESSAGE,"Insert failed in ST_ITEM_TRN_DTL record");
			throwExceptionWhenFailed(hmData);
		}
	}


//end
	public void insertItemMoveSummaryForISS (Connection connection,HashMap hmParameters) throws Exception {
		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

//		ArrayList alDtlDataFrom			=	new ArrayList();
//        ArrayList alDtlDataTo			=	new ArrayList();

		ArrayList alItemMoveSummRecord	=	new ArrayList();
//		ArrayList alCommonData			=	(ArrayList)	hmData1.get("COMMON_DATA");
		String l_doc_date	= (String)hmParameters.get("doc_date");
		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);

		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));

		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");


        /* For From record to be inserted in st_item_move_summ table */
		 String fm_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmParameters.get("store_code")).get("FACILITY_ID");

		alItemMoveSummRecord.clear();
		//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id
		alItemMoveSummRecord.add(fm_facility_id);      // facility_id
		alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code
		alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		//nafitive_value_to_zero.add(hmParameters.get("login_facility_id"));      // facility_id
		nafitive_value_to_zero.add(fm_facility_id);      // facility_id
		nafitive_value_to_zero.add(hmParameters.get("item_code"));     // Item code
		nafitive_value_to_zero.add(hmParameters.get("store_code"));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {
			alItemMoveSummRecord.clear();
			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));  // facility_id    
			alItemMoveSummRecord.add(fm_facility_id);  // facility_id    
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code      
			alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code     
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //month_closing_qty
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value")); //month_closing_value = item_cost_value
			}  //month_closing_value
			alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //iss_qty   
			alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// iss_cost 
			alItemMoveSummRecord.add("0");      //IN_ISS_QTY, 
			alItemMoveSummRecord.add("0");      //IN_ISS_COST
			if(hmParameters.get("to_stk_item_yn").toString().equals("Y")){
				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  // OUT_ISS_QTY_ST, 
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// OUT_ISS_COST_ST, 
				alItemMoveSummRecord.add("0");// OUT_ISS_QTY_NS, 
				alItemMoveSummRecord.add("0");// OUT_ISS_COST_NS,
			}else{
				alItemMoveSummRecord.add("0");  // OUT_ISS_QTY_ST, 
				alItemMoveSummRecord.add("0");// OUT_ISS_COST_ST, 
				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  // OUT_ISS_QTY_NS, 
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// OUT_ISS_COST_NS,
			}						   
			alItemMoveSummRecord.add("0");// CONS_QTY, 
			alItemMoveSummRecord.add("0");// CONS_COST,
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

			if(hmParameters.get("trn_type").toString().equals("ISS"))
				stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");
			else
				stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL_URG");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}else {
			alItemMoveSummRecord.clear();

			if(hmParameters.get("to_stk_item_yn").toString().equals("Y")){
				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //iss_qty   
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// iss_cost 
				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //month_closing_qty
				/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value")); //month_closing_value = item_cost_value
			} 
				//month_closing_value

				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  // OUT_ISS_QTY_ST, 
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// OUT_ISS_COST_ST,   

				alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
				alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
				alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

				//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
				alItemMoveSummRecord.add(fm_facility_id);      // facility_id  
				alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
				alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code   
				alItemMoveSummRecord.add(l_move_month);
				alItemMoveSummRecord.add(l_move_year);

				if(hmParameters.get("trn_type").toString().equals("ISS"))
					stSQL = (String)hmSQL.get ("Fm_ST_ItemMovSumFromUpdateSQL");
				else
					stSQL = (String)hmSQL.get ("Fm_ST_ItemMovSumFromUpdateSQL_URG");
			}else{
				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //iss_qty   
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// iss_cost 
				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  //month_closing_qty
				/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value")); //month_closing_value = item_cost_value
			} //month_closing_value

				alItemMoveSummRecord.add("-"+hmParameters.get("mm_trn_qty"));  // OUT_ISS_QTY_NS, 
				alItemMoveSummRecord.add("-"+hmParameters.get("trn_value"));// OUT_ISS_COST_NS,   

				alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
				alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
				alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

				//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
				alItemMoveSummRecord.add(fm_facility_id);      // facility_id  
				alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
				alItemMoveSummRecord.add(hmParameters.get("store_code"));    // store_code   
				alItemMoveSummRecord.add(l_move_month);
				alItemMoveSummRecord.add(l_move_year.trim());

				if(hmParameters.get("trn_type").toString().equals("ISS"))
				stSQL = (String)hmSQL.get ("Fm_NS_ItemMovSumFromUpdateSQL");
				else
				stSQL = (String)hmSQL.get ("Fm_NS_ItemMovSumFromUpdateSQL_URG");
			}

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			}
//		}

		/* For To record to be inserted in st_item_move_summ table */
		String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmParameters.get("to_store_code")).get("FACILITY_ID");

		alItemMoveSummRecord.clear();
		//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
		alItemMoveSummRecord.add(to_facility_id);      // facility_id  
		alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
		alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // to_store_code   
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {


			alItemMoveSummRecord.clear();
			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
			alItemMoveSummRecord.add(to_facility_id);      // facility_id  
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
			alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // to_store_code   
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			if(hmParameters.get("to_stk_item_yn").toString().equals("Y"))
			{
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  //month_closing_qty
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("to_mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmParameters.get("to_trn_value")); //month_closing_value = item_cost_value
			} 
			//month_closing_value
			}
			else
			{
			alItemMoveSummRecord.add("0");//hmParameters.get("trn_qty"));  //month_closing_qty
			alItemMoveSummRecord.add("0");//hmParameters.get("trn_value"));//month_closing_value
			}
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  //iss_qty   
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));// iss_cost 
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  //IN_ISS_QTY, 
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value")); //IN_ISS_COST
			alItemMoveSummRecord.add("0");// OUT_ISS_QTY_ST, 
			alItemMoveSummRecord.add("0");// OUT_ISS_COST_ST,  
			alItemMoveSummRecord.add("0");// OUT_ISS_QTY_NS, 
			alItemMoveSummRecord.add("0");// OUT_ISS_COST_NS,

			if(hmParameters.get("to_stk_item_yn").toString().equals("Y"))
			{
			alItemMoveSummRecord.add("0");// CONS_QTY, 
			alItemMoveSummRecord.add("0");// CONS_COST,
			}
			else
			{
			alItemMoveSummRecord.add("-"+hmParameters.get("to_mm_trn_qty"));  // CONS_QTY, 
			alItemMoveSummRecord.add("-"+hmParameters.get("to_trn_value"));// CONS_COST,
			}
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));
			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 


			if(hmParameters.get("trn_type").toString().equals("ISS"))
			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");
			else
			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL_URG");
			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {       ////check 

			alItemMoveSummRecord.clear();

			if(hmParameters.get("to_stk_item_yn").toString().equals("Y"))
			{
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  //iss_qty   
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));// iss_cost 
			if(hmParameters.get("to_stk_item_yn").toString().equals("Y"))
			{
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  //month_closing_qty
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmParameters.get("to_mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmParameters.get("to_trn_value")); //month_closing_value = item_cost_value
			}//month_closing_value
			}
			else
			{
			alItemMoveSummRecord.add("0");//hmParameters.get("trn_qty"));  //month_closing_qty
			alItemMoveSummRecord.add("0");//hmParameters.get("trn_value"));//month_closing_value
			}
//			alItemMoveSummRecord.add(hmParameters.get("trn_qty"));  //month_closing_qty
//			alItemMoveSummRecord.add(hmParameters.get("trn_value"));//month_closing_value

			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  // IN_ISS_QTY_ST, 
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));// IN_ISS_COST_ST,   

			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
			alItemMoveSummRecord.add(to_facility_id);      // facility_id  
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
			alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // to_store_code   
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			if(hmParameters.get("trn_type").toString().equals("ISS"))
			stSQL = (String)hmSQL.get ("To_ST_ItemMovSumFromUpdateSQL");
			else
			stSQL = (String)hmSQL.get ("To_ST_ItemMovSumFromUpdateSQL_URG");
			}
			else
			{
			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  //iss_qty   
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));// iss_cost 
			alItemMoveSummRecord.add("0");//hmParameters.get("trn_qty"));  //month_closing_qty
			alItemMoveSummRecord.add("0");//hmParameters.get("trn_value"));//month_closing_value

			alItemMoveSummRecord.add(hmParameters.get("to_mm_trn_qty"));  // IN_ISS_QTY_ST, 
			alItemMoveSummRecord.add(hmParameters.get("to_trn_value"));// IN_ISS_COST_ST,   

			alItemMoveSummRecord.add("-"+hmParameters.get("to_mm_trn_qty"));  // CON_QTY_NS, 
			alItemMoveSummRecord.add("-"+hmParameters.get("to_trn_value"));// CON_COST_NS,

			alItemMoveSummRecord.add(hmParameters.get("login_by_id"));       
			alItemMoveSummRecord.add(hmParameters.get("login_at_ws_no"));    
			alItemMoveSummRecord.add(hmParameters.get("login_facility_id")); 

			//alItemMoveSummRecord.add(hmParameters.get("login_facility_id"));      // facility_id  
			alItemMoveSummRecord.add(to_facility_id);      // facility_id  
			alItemMoveSummRecord.add(hmParameters.get("item_code"));     // Item code    
			alItemMoveSummRecord.add(hmParameters.get("to_store_code"));    // to_store_code   
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			if(hmParameters.get("trn_type").toString().equals("ISS"))
			stSQL = (String)hmSQL.get ("To_NS_ItemMovSumFromUpdateSQL");
			else
			stSQL = (String)hmSQL.get ("To_NS_ItemMovSumFromUpdateSQL_URG");
			}

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		 //stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";

		 stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

	}
/*Issue Return Coding starts from here...*/
	public HashMap updateIssueReturn(HashMap hmDataValues, HashMap hmSQLValues){
		HashMap hmData=(HashMap)hmDataValues;
		hmSQL=hmSQLValues;
		hmReturn	=	new HashMap();
        hmReturn.put(RESULT,FALSE);

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		HashMap		hmItemDtl	=	new HashMap();

		ArrayList   alCommonData = new ArrayList ();
		ArrayList	alHdrData	 =	new ArrayList();
		ArrayList	alDtlData	 =	new ArrayList();
		ArrayList	alExpData	 =	new ArrayList();
		ArrayList	allanguageData	 =	new ArrayList();



		String stCurrentItemCodeInCaseOfError=null;
		String sql,fm_stk_item_yn;

		alCommonData		=	(ArrayList)hmData.get("COMMON_DATA");
		alHdrData           =   (ArrayList)	hmData.get("HDR_DATA");
		alDtlData			=	(ArrayList)	hmData.get("DTL_DATA");
		alExpData			=   (ArrayList)	hmData.get("DTL_EXP_DATA");
		allanguageData		=   (ArrayList)	hmData.get("LANGUAGE_DATA");
		boolean isFinalized	=	true;
		String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
		ArrayList  hmparam = new ArrayList();    
		String p_from_bin_location_code		= "";
		String p_from_store_code			= ""; 
		String p_to_store_code				= "";
		String p_to_bin_location_code		= "";
		String p_item_code					= ""; 
		String p_batch_id					= ""; 
		String p_expiry_date_or_receipt_date= "";
		String mod_date						="";


		try {
			String stSQLHdrUpdate	=	(String)hmSQL.get ("stSQLHdrUpdate");
			//String stSQLDtlUpdate	=	(String)hmSQL.get ("stSQLDtlUpdate");
			//String stSQLExpDelete	=	(String)hmSQL.get ("stSQLExpDelete");
			//String stSqlDtlExpInsert=	(String)hmSQL.get ("DtlExpInsertSQL");

             
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(BATCH_SQL,stSQLHdrUpdate);
			hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			/**
			 * @Name - Priya
			 * @Date - 03/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
 			/*  For HDR Modification Logic Ends here */

			/* For DTL Modification logic Starts here */
		/*Commented by suresh.r on 24-02-2013 against AMS-CRF-0054 beg
		String fm_store_code	=	(String)(((HashMap)alDtlData.get(0)).get("from_store_code"));
		String to_store_code	=	(String)(((HashMap)alDtlData.get(0)).get("to_store_code")); 
		Commented by suresh.r on 24-02-2013 against AMS-CRF-0054 end*/
		      //Added by Rabbani #inc no:31269 on 05/04/12
		       String old_dtl_doc_no="";   
               boolean to_check = true;   			 
			  //String old_dtl_item_code = "";
			  //ends
		
			for (int i=0;i<alDtlData.size() ;i++ ) {
                HashMap hmDtlRecord		= new  HashMap();
				hmDtlRecord	= (HashMap)alDtlData.get(i);
				//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 beg
				String fm_store_code	=	(String)hmDtlRecord.get("from_store_code");
				String to_store_code	=	(String)hmDtlRecord.get("to_store_code");
				//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 end
				String dtl_doc_no = (String)hmDtlRecord.get("doc_no");
				String dtl_item_code=(String)hmDtlRecord.get("item_code");
                stCurrentItemCodeInCaseOfError=(String)hmDtlRecord.get("item_code");

				sql = (String)hmSQL.get("GetStockItemYNFlag");
				ArrayList alStkYN	=	new ArrayList();
				alStkYN.add(hmDtlRecord.get("item_code"));
				alStkYN.add(fm_store_code);
				HashMap hmStkYN		=	fetchRecord(connection, sql, alStkYN);
				fm_stk_item_yn		=	(String)hmStkYN.get("STOCK_ITEM_YN"); 
								
                ArrayList alTempItemData = new ArrayList();

				String stItemCode=(String)hmDtlRecord.get("item_code");

				//alTempItemData.add((String)hmDtlRecord.get("item_unit_cost"));
				alTempItemData.add((String)hmDtlRecord.get("item_unit_cost_trn_dtl")); //Added to pass unit cost as base to st_item_trn_dtl against inc#50521
				alTempItemData.add((String)hmDtlRecord.get("item_cost_value"));
				alTempItemData.add((String)hmDtlRecord.get("uom_code"));

				hmItemDtl.put( stItemCode,alTempItemData);

				//String stSQLIDtlUpdate	  =	(String)hmSQL.get ("TrnIssDtlUpdateSQL");
				//String stSQLIDtlExpUpdate	  =	(String)hmSQL.get ("TrnIssDtlExpUpdateSQL");

				String stSQLDataSelect	  =	(String)hmSQL.get ("SQL_ST_ISSUE_RET_DTL_EXP_SELECT_MULTIPLE");
				ArrayList alParameters = new ArrayList();	
				//fethching data for cross updation
				alParameters.add(alCommonData.get(2));
				alParameters.add((String)hmDtlRecord.get("doc_no"));
				alParameters.add(alCommonData.get(3));
				//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 beg
				//alParameters.add((String)hmDtlRecord.get("doc_srl_no"));
				alParameters.add((String)hmDtlRecord.get("item_code"));
				//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 end
				alParameters.add(allanguageData.get(0));
				alParameters.add(allanguageData.get(0));
				alParameters.add(allanguageData.get(0));
				ArrayList crossUpdateData	=	fetchRecords(connection,stSQLDataSelect, alParameters);
				String item_code = "";
				for (int j=0;j<crossUpdateData.size() ;j++ ) {
					HashMap hmExpRecord=(HashMap)crossUpdateData.get(j);
			  	    /* Updating values for ST_ISSUE_DTL for ret_item_qty BEGINS here */
					ArrayList alTempDtlUpdateFields = new ArrayList();
					//int ret_itm_qty = Integer.parseInt((String)hmExpRecord.get("RECEIVED_QTY"))/getConvFactTemp((String)hmExpRecord.get("ITEM_CODE"),(String)hmExpRecord.get("STORE_CODE"),hmSQL,(String)allanguageData.get(0),properties);
					//int ret_itm_qty = Integer.parseInt(checkForNull((String)hmExpRecord.get("ISS_ITEM_QTY"),(String)hmExpRecord.get("AVAIL_QTY")))/getConvFactTemp((String)hmExpRecord.get("ITEM_CODE"),(String)hmExpRecord.get("STORE_CODE"),hmSQL,(String)allanguageData.get(0),properties);
					double qty = 0;
					if(!(item_code.equals((String)hmExpRecord.get("ITEM_CODE")))){
						for(int k=0;k<alExpData.size();k++){
							HashMap hmTemp = (HashMap)alExpData.get(k);
							if(((String)hmTemp.get("TMP_REJECTED_QTY_1")).equals("")){
								hmTemp.put("TMP_REJECTED_QTY_1","0");
							}
							if(((String)hmTemp.get("ITEM_CODE")).equals((String)hmExpRecord.get("ITEM_CODE")))
								qty = qty + Double.parseDouble(checkForNull((String)hmTemp.get("TMP_REJECTED_QTY_2"),checkForNull((String)hmTemp.get("TMP_REJECTED_QTY_1"),"0")));
						}
						qty = qty/(getConvFactTemp((String)hmExpRecord.get("ITEM_CODE"),(String)hmExpRecord.get("STORE_CODE"),hmSQL,(String)allanguageData.get(0),properties));
						alTempDtlUpdateFields.add("-"+""+qty);
						alTempDtlUpdateFields.add((String)alCommonData.get(0));
						alTempDtlUpdateFields.add((String)alCommonData.get(1));
						alTempDtlUpdateFields.add((String)alCommonData.get(2));
						alTempDtlUpdateFields.add((String)alCommonData.get(2));
						alTempDtlUpdateFields.add((String)hmExpRecord.get("DOC_TYPE_CODE"));
						alTempDtlUpdateFields.add((String)hmExpRecord.get("DOC_NO"));
						alTempDtlUpdateFields.add((String)hmExpRecord.get("SEQ_NO"));
						alTempDtlUpdateFields.add((String)hmExpRecord.get("ITEM_CODE"));
						
						//Commented by Rabbani against inc no:31625 on 08/03/2012
						//hmArgData.put(DATA,alTempDtlUpdateFields);
						//hmArgSQL.put(UPDATE_SQL,stSQLIDtlUpdate);
						
						 /* try{
							hmReturn	=	update(connection, hmArgData, hmArgSQL);
							throwExceptionWhenFailed(hmReturn);
					    }catch(Exception ex) { ex.printStackTrace(); } */
					}
					item_code = (String)hmExpRecord.get("ITEM_CODE");
					/* Updating values for ST_ISSUE_DTL for ret_item_qty ENDS here  */

					/* Updating values for ST_ISSUE_DTL_EXP for ret_item_qty BEGINS here */
					ArrayList alUpdateFields = new ArrayList();
					//alUpdateFields.add("-"+(String)hmExpRecord.get("RECEIVED_QTY"));
					alUpdateFields.add("-"+checkForNull((String)hmExpRecord.get("RECEIVED_QTY"),(String)hmExpRecord.get("AVAIL_QTY")));
					alUpdateFields.add((String)alCommonData.get(0));
					alUpdateFields.add((String)alCommonData.get(1));
					alUpdateFields.add((String)alCommonData.get(2));
					alUpdateFields.add((String)alCommonData.get(2));
					alUpdateFields.add((String)hmExpRecord.get("DOC_TYPE_CODE"));
					alUpdateFields.add((String)hmExpRecord.get("DOC_NO"));
					alUpdateFields.add((String)hmExpRecord.get("SEQ_NO"));
					alUpdateFields.add((String)hmExpRecord.get("ITEM_CODE"));
					alUpdateFields.add((String)hmExpRecord.get("BATCH_ID"));
					alUpdateFields.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
					
					//Commented by Rabbani against inc no:31625 on 08/03/2012
					//hmArgData.put(DATA,alUpdateFields);
					//hmArgSQL.put(UPDATE_SQL,stSQLIDtlExpUpdate);
					/* try{
						hmReturn	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmReturn);
				   }catch(Exception ex) { ex.printStackTrace(); } */

				     /*  Updating values for ST_ISSUE_DTL_EXP for ret_item_qty ENDS here  */
				}
					
					ArrayList alDeleteExpRecord	=	new ArrayList();
					alDeleteExpRecord.add(alCommonData.get(2)); //facility_id
					alDeleteExpRecord.add(alCommonData.get(3)); //doc_type_code
					alDeleteExpRecord.add((String)hmDtlRecord.get("doc_no")); //doc_no
					alDeleteExpRecord.add((String)hmDtlRecord.get("doc_srl_no")); //put doc_srl_no at last..

					ArrayList alCheckData=new ArrayList();
					alCheckData.add(alCommonData.get(2));
					alCheckData.add(alCommonData.get(3));
					alCheckData.add((String)hmDtlRecord.get("doc_no"));
					alCheckData.add((String)hmDtlRecord.get("doc_srl_no"));
                 
				    //ArrayList alRecords11	=	fetchRecords(connection,(String)hmSQL.get("sql_st_issue_ret_dtl_exp_select_for_block_rel"), alCheckData);
                  
					/*for (int j=0; j<alExpData.size(); j++) {
						HashMap hmRecord	=	(HashMap)alExpData.get(j);
						HashMap hmParameter	=	new HashMap();
						hmParameter.put("store_code",fm_store_code);
						hmParameter.put("item_code",hmRecord.get("ITEM_CODE"));
						hmParameter.put("batch_id",hmRecord.get("BATCH_ID"));
						hmParameter.put("bin_location_code",hmRecord.get("ISSUE_TO_BIN_LOCATION_CODE"));
						hmParameter.put("expiry_date_or_receipt_date",hmRecord.get("EXPIRY_DATE"));
						int tmp_qty = Integer.parseInt((String)hmRecord.get("RECEIVED_QTY"))+Integer.parseInt(((String)hmRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmRecord.get("REJECTED_QTY"));
						hmParameter.put("trn_qty", ""+tmp_qty);
						hmParameter.put("login_by_id",alCommonData.get(0));
						hmParameter.put("login_at_ws_no",alCommonData.get(1));
						hmParameter.put("login_facility_id",alCommonData.get(2));
						if (fm_stk_item_yn.equals("Y")){
							hmReturn	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'R'); 
							throwExceptionWhenFailed(hmReturn);
						}
					}*/
						//hmArgData.put(DATA,alDeleteExpRecord);
						//hmArgSQL.put(DELETE_SQL,stSQLExpDelete);
						//hmReturn	=	delete(connection, hmArgData, hmArgSQL);
						//throwExceptionWhenFailed(hmReturn);

					/* All Exp record deleted */
					ArrayList alDtlRecordInst1 = new ArrayList();
					alDtlRecordInst1.add( (String)hmDtlRecord.get("item_qty"));
					alDtlRecordInst1.add( (String)hmDtlRecord.get("item_cost_value") );
					alDtlRecordInst1.add((String)hmDtlRecord.get("remarks")); 
					alDtlRecordInst1.add( (String)alCommonData.get(0));
					alDtlRecordInst1.add((String)alCommonData.get(1));
					alDtlRecordInst1.add((String)alCommonData.get(2));
					//alDtlRecordInst1.add(alCommonData.get(2));
					alDtlRecordInst1.add( ((ArrayList)alHdrData.get(0)).get(7));
					alDtlRecordInst1.add(alCommonData.get(3));
					alDtlRecordInst1.add((String)hmDtlRecord.get("doc_no"));
					alDtlRecordInst1.add((String)hmDtlRecord.get("doc_srl_no"));
					//(String)hmDtlRecord.get("doc_srl_no")
					//commented by Rabbani on 18/06/12 no need to Update st_issue_ret_dtl 
					/*hmArgData.put(DATA,alDtlRecordInst1);
					hmArgSQL.put(UPDATE_SQL,stSQLDtlUpdate);
					hmReturn	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);*/
					//ends
                   

				   if(isFinalized) {

				    alCheckData=new ArrayList();
					alCheckData.add(alCommonData.get(2));
					alCheckData.add(alCommonData.get(3));
					alCheckData.add((String)hmDtlRecord.get("doc_no"));
					alCheckData.add((String)hmDtlRecord.get("doc_srl_no"));
                 
				    //ArrayList alRecords1	=	fetchRecords(connection,(String)hmSQL.get("sql_st_issue_ret_dtl_exp_select_for_block_rel"), alCheckData);
                  
					for (int j=0; j<alExpData.size(); j++) {
					
						HashMap hmRecord	=	(HashMap)alExpData.get(j);
						//System.out.println("hmRecord==3024=HSISRN=>" +hmRecord);
						HashMap hmParameter	=	new HashMap();
						if(((String)hmDtlRecord.get("doc_no")).equals(((String)hmRecord.get("DOC_NO")))&& ((String)hmDtlRecord.get("item_code")).equals((String)hmRecord.get("ITEM_CODE"))){
						hmParameter.put("store_code",fm_store_code);
						hmParameter.put("item_code",hmRecord.get("ITEM_CODE"));
						hmParameter.put("batch_id",hmRecord.get("BATCH_ID"));
						hmParameter.put("bin_location_code",hmRecord.get("ISSUE_TO_BIN_LOCATION_CODE"));
						hmParameter.put("expiry_date_or_receipt_date",hmRecord.get("EXPIRY_DATE"));
					 
				      //Added by Rabbani #inc no:33205 on 18/06/12
				      if(alCommonData.get(6).equals("A")){
				    double tmp_qty = Double.parseDouble(((String)hmRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmRecord.get("RECEIVED_QTY"))+Double.parseDouble(((String)hmRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmRecord.get("REJECTED_QTY"));
				     hmParameter.put("trn_qty", ""+tmp_qty);
				   }else{
				   double tmp_qty = Double.parseDouble(((String)hmRecord.get("TMP_RECEIVED_QTY_2")).equals("")?"0":(String)hmRecord.get("TMP_RECEIVED_QTY_2"))+Double.parseDouble(((String)hmRecord.get("TMP_REJECTED_QTY_2")).equals("")?"0":(String)hmRecord.get("TMP_REJECTED_QTY_2"));
				   hmParameter.put("trn_qty", ""+tmp_qty);
				   }
						
						//hmParameter.put("trn_qty",hmRecord.get("ITEM_QTY"));
						hmParameter.put("login_by_id",alCommonData.get(0));
						hmParameter.put("login_at_ws_no",alCommonData.get(1));
						hmParameter.put("login_facility_id",alCommonData.get(2));
						
						//Added by Rabbani #inc no:31269 on 05/04/12
						 
				if (old_dtl_doc_no.equals(dtl_doc_no) || old_dtl_doc_no.equals("")){
				hmParameter.put("modified_date",(String)hmRecord.get("modified_date"));//Added by Rabbani #inc no:31269 on 21/03/12 
				}else{
				hmRecord.put("modified_date","");
				old_dtl_doc_no = "not_check";
				to_check = false;
				}
				//ends
				//Added by suresh.r on 20-02-2014 against AMS-CRF-0054 beg
				if(((String)fetchRecord(connection, "SELECT ISS_RET_BASED_ON FROM ST_FACILITY_PARAM WHERE FACILITY_ID =?", (String)alCommonData.get(2)).get("ISS_RET_BASED_ON")).equals("I")){
					ArrayList alCheckParam=new ArrayList();
					alCheckParam.add(hmRecord.get("FACILITY_ID"));
					alCheckParam.add(hmRecord.get("DOC_TYPE_CODE"));
					alCheckParam.add(hmRecord.get("DOC_NO"));
					alCheckParam.add(hmRecord.get("STORE_CODE"));
					alCheckParam.add(hmRecord.get("ITEM_CODE"));
					alCheckParam.add(hmRecord.get("BATCH_ID"));
					alCheckParam.add(hmRecord.get("EXPIRY_RECEIPT_DT"));
					alCheckParam.add(hmRecord.get("NEW_BIN_LOCATION_CODE"));
					int chkCount=Integer.parseInt((String)fetchRecord(connection, eST.Common.StEJBRepository.getStKeyValue("SQL_ST_CHECK_SAME_BATCH_DIFF_ORGISS_DOCNO_EXISTS"), alCheckParam).get("CNT"));
					if(chkCount>1){
						hmParameter.put("modified_date","");
					}
				}//Added by suresh.r on 20-02-2014 against AMS-CRF-0054 end
				
						//System.out.println("hmParameter==3062=HSISRN=>" +hmParameter);
						sql = (String)hmSQL.get("GetStockItemYNFlag");
						alStkYN	=	new ArrayList();
						alStkYN.add(hmRecord.get("ITEM_CODE"));
						alStkYN.add(fm_store_code);
						hmStkYN					= fetchRecord(connection, sql, alStkYN);
						fm_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
						if(fm_stk_item_yn.equals("Y")){
							hmReturn	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'R');//false to release the batch..


							throwExceptionWhenFailed(hmReturn);
						}
					}
					}
			  
						/* Setting values and calling OnlineStockUpdate BEGINS here  */

						HashMap hmParameters = new HashMap();

						hmParameters.put("item_code",(String)hmDtlRecord.get("item_code"));
						hmParameters.put("store_code",fm_store_code);
						hmParameters.put("to_store_code",to_store_code);
						hmParameters.put("trn_type","RET");
						hmParameters.put("doc_date",(String)hmDtlRecord.get("doc_date"));
					    //hmParameters.put("trn_qty",(String)hmDtlRecord.get("item_qty"));//by ganga
						//hmParameters.put("trn_qty",hmDtlRecord.get("mm_trn_qty"));	
						hmParameters.put("trn_unit_cost",(String)hmDtlRecord.get("item_unit_cost"));
						//hmParameters.put("fm_trn_value",(String)hmDtlRecord.get("item_cost_value"));
						//double trn_val= Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty"))*Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"));
						//hmParameters.put("fm_trn_value",""+trn_val);
						hmParameters.put("from_stk_item_yn",fm_stk_item_yn);//"Y");
						hmParameters.put("to_stk_item_yn","Y");
						hmParameters.put("last_receipt_date",""); 
						hmParameters.put("last_issue_date","");   
						hmParameters.put("login_by_id",(String)alCommonData.get(0));
						hmParameters.put("login_at_ws_no",(String)alCommonData.get(1));
						hmParameters.put("login_facility_id",(String)alCommonData.get(2));
						hmParameters.put("to_str_qty",hmDtlRecord.get("to_str_qty"));
						hmParameters.put("mm_trn_qty",hmDtlRecord.get("mm_trn_qty"));
						hmParameters.put("language_id",(String)allanguageData.get(0));
						hmDtlRecord.remove("to_str_qty");
						double dtl_trn_val= 0.0;
                        try{
							double fm_str_qty =Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty")) /(getConvFactTemp((String)hmDtlRecord.get("item_code"),fm_store_code,hmSQL,(String)allanguageData.get(0),properties));
							dtl_trn_val= Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble(""+fm_str_qty);
							/**
							 * @Name - Priya
							 * @Date - 03/06/2010
							 * @Inc# - 
							 * @Desc -  To round up with noOfDecimalsForCost 
							 */
							hmParameters.put("trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));
						
							hmParameters.put("trn_qty",""+fm_str_qty); //added by ganga on Thursday, April 19, 2012
							hmParameters.put("fm_trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));

							calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);
							hmParameters.put("trn_value",hmDtlRecord.get("item_cost_value"));
							hmParameters.remove("to_str_qty");
						}catch(Exception exp){
							hmReturn.put("flag",""+i);
					        throw new Exception("NEGATIVE_STOCK");
						}

						/* Setting values and calling OnlineStockUpdate ENDS here  */
						hmParameters.put("mm_trn_qty",hmDtlRecord.get("tmp_item_qty"));
						hmParameters.put("to_mm_trn_qty",(String)hmDtlRecord.get("mm_trn_qty"));
						//dtl_trn_val= Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble((String)hmDtlRecord.get("mm_trn_qty"));
						/**
				 * @Name - Priya
				 * @Date - 03/06/2010
				 * @Inc# - 
				 * @Desc -  To round up with noOfDecimalsForCost 
				 */
						hmParameters.put("to_trn_value",""+setNumber(""+dtl_trn_val,noOfDecimalsForCost));
						//ItemMoveSummaryForIssueReturn (connection,hmData,hmSQL,hmDtlRecord);
						ItemMoveSummaryForIssueReturn (connection,hmData,hmSQL,hmParameters);

					} // if codition for isFinalize 
             
			 String exp_doc_no ="";
			 String exp_item_code="";
			 if(!isFinalized) {
				for (int j=0;j<alExpData.size() ;j++ ) {
                    HashMap hmExpRecordNotfin=(HashMap)alExpData.get(j);
					exp_doc_no = (String)hmExpRecordNotfin.get("DOC_NO");
					exp_item_code = (String)hmExpRecordNotfin.get("ITEM_CODE");
					//System.out.println("dtl_doc_no==2953==>"+dtl_doc_no);
					if (dtl_doc_no.equals(exp_doc_no) && dtl_item_code.equals(exp_item_code)){
					stCurrentItemCodeInCaseOfError=(String)hmExpRecordNotfin.get("ITEM_CODE");
                   /* Again BLOCK new quantity */                
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",fm_store_code);
					hmParameter.put("item_code",(String)hmExpRecordNotfin.get("ITEM_CODE"));
					hmParameter.put("batch_id",(String)hmExpRecordNotfin.get("BATCH_ID"));
					hmParameter.put("bin_location_code",(String)hmExpRecordNotfin.get("ISSUE_TO_BIN_LOCATION_CODE"));
					hmParameter.put("expiry_date_or_receipt_date",(String)hmExpRecordNotfin.get("EXPIRY_RECEIPT_DT"));
					//hmParameter.put("trn_qty",(String)hmExpRecordNotfin.get("RECEIVED_QTY"));
					hmParameter.put("trn_qty",checkForNull((String)hmExpRecordNotfin.get("ISSUE_QTY"),(String)hmExpRecordNotfin.get("AVAIL_QTY")));
					hmParameter.put("login_by_id",(String)alCommonData.get(0));
					hmParameter.put("login_at_ws_no",(String)alCommonData.get(1));
					hmParameter.put("login_facility_id",(String)alCommonData.get(2));

					sql = (String)hmSQL.get("GetStockItemYNFlag");
					alStkYN	=	new ArrayList();
					alStkYN.add(hmExpRecordNotfin.get("ITEM_CODE"));
					alStkYN.add(fm_store_code);
					hmStkYN					= fetchRecord(connection, sql, alStkYN);
					fm_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
					if (fm_stk_item_yn.equals("Y")) {
						hmReturn	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B'); // B for blocking the new quantity
						throwExceptionWhenFailed(hmReturn);
					}
				 }
				}
			} 
			
			if(isFinalized) {
			for (int k=0;k<alExpData.size() ;k++ ) {
				HashMap hmExpRecord=(HashMap)alExpData.get(k);
				exp_doc_no = (String)hmExpRecord.get("DOC_NO");
				exp_item_code = (String)hmExpRecord.get("ITEM_CODE");				
				//System.out.println("hmExpRecord==3187==>"+hmExpRecord);
				if (dtl_doc_no.equals(exp_doc_no) && dtl_item_code.equals(exp_item_code)){
					/* Inside DTL_EXP FOR LOOP Calling the UpdateBatchOnline STARTS here */
				HashMap hmParameters = new HashMap();
				stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				hmParameters.put("item_code",(String)hmExpRecord.get("ITEM_CODE"));//item_code
				hmParameters.put("store_code",fm_store_code);
				hmParameters.put("to_store_code",to_store_code);
				hmParameters.put("trn_type","RET");
				//hmParameters.put("trn_qty",(String)hmExpRecord.get("RECEIVED_QTY"));
				//11/06/12
				if(alCommonData.get(6).equals("A")){
				hmParameters.put("trn_qty",checkForNull((String)hmExpRecord.get("RECEIVED_QTY"),(String)hmExpRecord.get("AVAIL_QTY")));
				}else{
				hmParameters.put("trn_qty",checkForNull((String)hmExpRecord.get("TMP_RECEIVED_QTY_2"),(String)hmExpRecord.get("AVAIL_QTY")));
				}
				hmParameters.put("batch_id",(String)hmExpRecord.get("BATCH_ID"));
				hmParameters.put("expiry_date_or_receipt_date",(String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				hmParameters.put("trade_id",(String)hmExpRecord.get("TRADE_ID"));
				hmParameters.put("to_bin_location_code",(String)hmExpRecord.get("ISSUE_FM_BIN_LOCATION_CODE")); //NEW_BIN_LOCATION_CODE(String)hmExpRecord.get("TO_BIN_LOCATION_CODE")
				hmParameters.put("from_bin_location_code",(String)hmExpRecord.get("ISSUE_TO_BIN_LOCATION_CODE"));
				//commented by Rabbani #inc no:29537 on 15/11/11
				//hmParameters.put("suspended_batch_allowed_yn", "N");
				hmParameters.put("suspended_batch_allowed_yn", "Y");
				hmParameters.put("release_batch_yn","N");
				hmParameters.put("last_receipt_date",""); // doc_date  
				hmParameters.put("last_issue_date",""); // doc_date
				hmParameters.put("login_by_id",(String)alCommonData.get(0));
				hmParameters.put("login_at_ws_no",(String)alCommonData.get(1));
				hmParameters.put("login_facility_id",(String)alCommonData.get(2));
		//	String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
				  hmparam = new ArrayList();
			            
				 p_from_bin_location_code		= checkForNull (hmParameters.get("from_bin_location_code"));
				 p_from_store_code				= checkForNull (hmParameters.get("store_code")); 
				 p_to_store_code					= checkForNull	(hmParameters.get("to_store_code"));
				 p_to_bin_location_code			= checkForNull (hmParameters.get("to_bin_location_code"));
				 p_item_code						= checkForNull (hmParameters.get("item_code")); 
				 p_batch_id						= checkForNull (hmParameters.get("batch_id")); 
				 p_expiry_date_or_receipt_date	= checkForNull (hmParameters.get("expiry_date_or_receipt_date"));
						
						   hmparam.add(p_from_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_from_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
						   							   
						   hmParameters.put("modified_date",mod_date);
						   hmparam = new ArrayList();
						    hmparam.add(p_to_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_to_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
					
						   hmParameters.put("to_modified_date",mod_date);
			
				 //11/06/12
				if(alCommonData.get(6).equals("A")){
				if((Double.parseDouble((String)hmExpRecord.get("RECEIVED_QTY"))) > 0){
					updateBatchOnLine(connection, hmSQL, hmParameters);
				}
				}else{
				if((Double.parseDouble((String)hmExpRecord.get("TMP_RECEIVED_QTY_2"))) > 0){
					updateBatchOnLine(connection, hmSQL, hmParameters);
				}
				}
				/* Inside DTL_EXP FOR LOOP Calling the UpdateBAtchOnline ENDS here */
				/* Setting values(for FORM) and inserting into ST_ITEM_TRN_DTL table BEGINS here */

                ArrayList alTempItmDtl = (ArrayList)hmItemDtl.get((String)hmExpRecord.get("ITEM_CODE")); 
				sql = (String)hmSQL.get("GetStockItemYNFlag");
				 alStkYN	=	new ArrayList();
				alStkYN.add(hmExpRecord.get("ITEM_CODE"));
				alStkYN.add(fm_store_code);
				 hmStkYN					= fetchRecord(connection, sql, alStkYN);
				fm_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
				ArrayList alFromDtlTrn=new ArrayList();
				
				String fm_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), fm_store_code).get("FACILITY_ID");//Added by Rabbani on 15/04/2014
				
				//alFromDtlTrn.add(alCommonData.get(2));//facility_id
				alFromDtlTrn.add(fm_facility_id);//facility_id
				alFromDtlTrn.add(fm_store_code);//From store_code
				alFromDtlTrn.add((String)hmExpRecord.get("ITEM_CODE"));//item_code
				alFromDtlTrn.add(""+1);
				alFromDtlTrn.add("RET");
				alFromDtlTrn.add(alCommonData.get(3));
				alFromDtlTrn.add((String)hmExpRecord.get("RET_DOC_NO"));
				alFromDtlTrn.add((String)hmExpRecord.get("doc_srl_no"));
				alFromDtlTrn.add((String)hmExpRecord.get("DOC_DATE"));
				alFromDtlTrn.add("");
				alFromDtlTrn.add((String)hmExpRecord.get("BATCH_ID"));
				alFromDtlTrn.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				//alFromDtlTrn.add("-"+(String)hmExpRecord.get("RECEIVED_QTY"));
				//11/06/12
				double trn_qty = 0.0;
				if(alCommonData.get(6).equals("A")){
				  trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"))+ Double.parseDouble(((String)hmExpRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmExpRecord.get("REJECTED_QTY"));
				}else{
				  trn_qty = Double.parseDouble(((String)hmExpRecord.get("TMP_RECEIVED_QTY_2")).equals("")?"0":(String)hmExpRecord.get("TMP_RECEIVED_QTY_2"))+ Double.parseDouble(((String)hmExpRecord.get("TMP_REJECTED_QTY_2")).equals("")?"0":(String)hmExpRecord.get("TMP_REJECTED_QTY_2"));
				}
				alFromDtlTrn.add("-"+trn_qty);
				alFromDtlTrn.add((String)alTempItmDtl.get(0)); 
				//alFromDtlTrn.add((String)alTempItmDtl.get(2)); 
				alFromDtlTrn.add((String)hmExpRecord.get("ORG_DOC_TYPE_CODE")); 
				alFromDtlTrn.add((String)hmExpRecord.get("ISS_DOC_NO")); 
				alFromDtlTrn.add((String)hmExpRecord.get("DOC_SRL_NO")); 
				alFromDtlTrn.add((String)hmExpRecord.get("DOC_DATE")); 
                alFromDtlTrn.add(to_store_code); //other store 
				alFromDtlTrn.add(fm_stk_item_yn);//"Y");
				alFromDtlTrn.add((String)hmExpRecord.get("uom_code"));
				alFromDtlTrn.add((String)alCommonData.get(0));
				alFromDtlTrn.add((String)alCommonData.get(1));
				alFromDtlTrn.add((String)alCommonData.get(2));
				alFromDtlTrn.add((String)alCommonData.get(0));
				alFromDtlTrn.add((String)alCommonData.get(1));
				alFromDtlTrn.add((String)alCommonData.get(2));
				// Uncommented   by Rabbani #Inc no:40697(GHL-SCF-750) on  17-JUN-2013
				alFromDtlTrn.add(checkForNull((String)hmExpRecord.get("ISSUE_TO_BIN_LOCATION_CODE")));//fm_bin_location_code
				//Modified on 21/07/2004
				 // Commented   by Rabbani #Inc no:40697(GHL-SCF-750) on  17-JUN-2013
				//alFromDtlTrn.add(checkForNull((String)hmExpRecord.get("NEW_BIN_LOCATION_CODE")));
				alFromDtlTrn.add((String)hmExpRecord.get("TRADE_ID"));//trade_id 
                alFromDtlTrn.add((String)hmExpRecord.get("SEQ_NO"));
                
				//stSQL	= (String)hmSQL.get("TrnDtlInsertSQL");
//Hardcoded by Mahesh on 6/5/2008 because we are not inserting stock uom code properly in the main Transaction..remove once it is through..
				stSQL	= "INSERT INTO ST_ITEM_TRN_DTL(FACILITY_ID,STORE_CODE,ITEM_CODE,POSTED_DATE,TRN_SRL_NO,TRN_TYPE,DOC_TYPE_CODE,DOC_NO,DOC_SRL_NO,DOC_DATE,DOC_REF,BATCH_ID,EXPIRY_DATE,ITEM_QTY_NORMAL,ITEM_UNIT_COST,SOURCE_DOC_TYPE_CODE,SOURCE_DOC_NO,SOURCE_DOC_SRL_NO,SOURCE_DOC_DATE,OTHER_STORE_CODE,STOCK_ITEM_YN,STK_UOM_CODE,ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BIN_LOCATION_CODE, TRADE_ID, SOURCE_SEQ_NO  ) VALUES (?,?,?,SYSDATE,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,? )";
				hmArgData.put(DATA,alFromDtlTrn);
			    hmArgSQL.put(INSERT_SQL,stSQL);
				if(trn_qty>0){
					hmReturn	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}
				if (fm_stk_item_yn.equals("N")) {
					alFromDtlTrn.set(3,""+3);
					//alFromDtlTrn.set(12,hmExpRecord.get("RECEIVED_QTY"));
					alFromDtlTrn.set(12,""+trn_qty);
					alFromDtlTrn.set(4,"CON");
					if(trn_qty > 0){
						hmReturn	=	insert(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmReturn);
					}
				}

			   /* Setting values(for FORM) and inserting into ST_ITEM_TRN_DTL table ENDS here */

			   /* Setting values(for TO) and inserting into ST_ITEM_TRN_DTL table BEGINS here */
                
				ArrayList alToDtlTrn=new ArrayList();
				String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), to_store_code).get("FACILITY_ID");//Added by Rabbani on 15/04/2014
				
				//alToDtlTrn.add(alCommonData.get(2)); //facility_id
				alToDtlTrn.add(to_facility_id); //facility_id
				alToDtlTrn.add(to_store_code); //To store_code
				alToDtlTrn.add((String)hmExpRecord.get("ITEM_CODE"));//item_code
				alToDtlTrn.add(""+2);
				alToDtlTrn.add("RET");
				alToDtlTrn.add(alCommonData.get(3));
				alToDtlTrn.add((String)hmExpRecord.get("RET_DOC_NO"));
				alToDtlTrn.add((String)hmExpRecord.get("doc_srl_no"));
				alToDtlTrn.add((String)hmExpRecord.get("DOC_DATE"));
				alToDtlTrn.add("");
				alToDtlTrn.add((String)hmExpRecord.get("BATCH_ID"));
				alToDtlTrn.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				//alToDtlTrn.add((String)hmExpRecord.get("RECEIVED_QTY"));
				
				//13/06/12
				double trn_qty_rec = 0.0;
				if(alCommonData.get(6).equals("A")){
				  trn_qty_rec = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"));
				   }else{
				  trn_qty_rec = Double.parseDouble(((String)hmExpRecord.get("TMP_RECEIVED_QTY_2")).equals("")?"0":(String)hmExpRecord.get("TMP_RECEIVED_QTY_2"));
				  }
				
				
				//alToDtlTrn.add(""+trn_qty); //13/06/12
				alToDtlTrn.add(""+trn_qty_rec); //13/06/12
				alToDtlTrn.add((String)alTempItmDtl.get(0)); 
				//alToDtlTrn.add((String)alTempItmDtl.get(2)); 

				alToDtlTrn.add((String)hmExpRecord.get("ORG_DOC_TYPE_CODE")); 
				alToDtlTrn.add((String)hmExpRecord.get("ISS_DOC_NO")); 
				alToDtlTrn.add((String)hmExpRecord.get("DOC_SRL_NO")); 
				alToDtlTrn.add((String)hmExpRecord.get("DOC_DATE")); 

                alToDtlTrn.add(fm_store_code); 
				alToDtlTrn.add("Y");
				alToDtlTrn.add((String)hmExpRecord.get("TO_UOM_CODE"));
				alToDtlTrn.add((String)alCommonData.get(0));
				alToDtlTrn.add((String)alCommonData.get(1));
				alToDtlTrn.add((String)alCommonData.get(2));
				alToDtlTrn.add((String)alCommonData.get(0));
				alToDtlTrn.add((String)alCommonData.get(1));
				alToDtlTrn.add((String)alCommonData.get(2));
				//alToDtlTrn.add(checkForNull((String)hmExpRecord.get("ISSUE_FM_BIN_LOCATION_CODE"))); // to_bin_location_code
				//Modified on 21/07/2004
                alToDtlTrn.add(checkForNull((String)hmExpRecord.get("NEW_BIN_LOCATION_CODE"))); 
				alToDtlTrn.add((String)hmExpRecord.get("TRADE_ID"));//trade_id 

                alToDtlTrn.add((String)hmExpRecord.get("SEQ_NO"));
				
				//stSQL	= (String)hmSQL.get("TrnDtlInsertSQL");
				stSQL	= "INSERT INTO ST_ITEM_TRN_DTL(FACILITY_ID,STORE_CODE,ITEM_CODE,POSTED_DATE,TRN_SRL_NO,TRN_TYPE,DOC_TYPE_CODE,DOC_NO,DOC_SRL_NO,DOC_DATE,DOC_REF,BATCH_ID,EXPIRY_DATE,ITEM_QTY_NORMAL,ITEM_UNIT_COST,SOURCE_DOC_TYPE_CODE,SOURCE_DOC_NO,SOURCE_DOC_SRL_NO,SOURCE_DOC_DATE,OTHER_STORE_CODE,STOCK_ITEM_YN,STK_UOM_CODE,ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BIN_LOCATION_CODE, TRADE_ID, SOURCE_SEQ_NO  ) VALUES (?,?,?,SYSDATE,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,? )";
				hmArgData.put(DATA,alToDtlTrn);
			    hmArgSQL.put(INSERT_SQL,stSQL);
				if(trn_qty_rec>0){ //18/06/12
					hmReturn	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}
			   /* Setting values(for TO) and inserting into ST_ITEM_TRN_DTL table BEGINS here */
			   }
			}			   //End of for Loop 

			}

			//Added by Rabbani #inc no:31269 on 05/04/12
				if(to_check){
				//System.out.println("to_check 1920=====>" +to_check);
				old_dtl_doc_no = dtl_doc_no;
				//old_dtl_item_code = dtl_item_code;
				}
			   // System.out.println("dtl_doc_no 3299=====>" +dtl_doc_no);
			   // System.out.println("old_dtl_doc_no 3300====>" +old_dtl_doc_no);
			    //System.out.println("dtl_item_code 3301===>" +dtl_item_code);
			    //ends			

		   } //End of For Loop 
    
			/* For DTL Modification logic ENDS here */		
			/*commented by ganga not required
            ArrayList alTotalExpData1=new ArrayList();
			for (int i=0;i<alExpData.size() ;i++ ) {
	 			HashMap hmExpRecord=(HashMap)alExpData.get(i);
				stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				sql = (String)hmSQL.get("GetStockItemYNFlag");
				ArrayList alStkYN	=	new ArrayList();
				alStkYN.add(hmExpRecord.get("ITEM_CODE"));
				alStkYN.add(fm_store_code);
				HashMap hmStkYN					= fetchRecord(connection, sql, alStkYN);
				fm_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 

				ArrayList alExpDataToIns = new ArrayList() ;

				alExpDataToIns.add(0,(String)alCommonData.get(2));
				alExpDataToIns.add(1,(String)alCommonData.get(3));
				alExpDataToIns.add(2,(String)hmExpRecord.get("RET_DOC_NO"));
				//int intdocNo=i+1;
				//alExpDataToIns.add(3,String.valueOf(intdocNo));
				alExpDataToIns.add(3,(String)hmExpRecord.get("doc_srl_no"));
				alExpDataToIns.add(4,fm_store_code); // Return From store Code
				alExpDataToIns.add(5,(String)hmExpRecord.get("ITEM_CODE"));
				alExpDataToIns.add(6,(String)hmExpRecord.get("BATCH_ID"));
				//need to check 
				alExpDataToIns.add(7,(String)hmExpRecord.get("ISSUE_TO_BIN_LOCATION_CODE")); //By Mahesh
				//alExpDataToIns.add(7,checkForNull((String)hmExpRecord.get("NEW_BIN_LOCATION_CODE")));
				alExpDataToIns.add(8,(String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				alExpDataToIns.add(9,(String)hmExpRecord.get("TRADE_ID"));
				//alExpDataToIns.add(10,(String)hmExpRecord.get("RECEIVED_QTY"));
				alExpDataToIns.add(10,checkForNull((String)hmExpRecord.get("ISSUE_QTY"),(String)hmExpRecord.get("AVAIL_QTY")));

				alExpDataToIns.add(11,(String)alCommonData.get(0));
				alExpDataToIns.add(12,(String)alCommonData.get(1));
				alExpDataToIns.add(13,(String)alCommonData.get(2));
				alExpDataToIns.add(14,(String)alCommonData.get(0));
				alExpDataToIns.add(15,(String)alCommonData.get(1));
				alExpDataToIns.add(16,(String)alCommonData.get(2));

				alExpDataToIns.add(17,(String)hmExpRecord.get("ORG_DOC_TYPE_CODE"));
				alExpDataToIns.add(18,(String)hmExpRecord.get("ISS_DOC_NO"));
				alExpDataToIns.add(19,(String)hmExpRecord.get("SEQ_NO"));

				//alExpDataToIns.add(20,(String)hmExpRecord.get("ISSUE_FM_BIN_LOCATION_CODE"));
				//modified on 21/07/2004
				alExpDataToIns.add(20,(String)hmExpRecord.get("NEW_BIN_LOCATION_CODE"));

				alTotalExpData1.add(alExpDataToIns);
			}
			
            hmArgData.put(DATA,alTotalExpData1);
			hmArgSQL.put(BATCH_SQL,stSqlDtlExpInsert);*/

            //hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
			//throwExceptionWhenFailed(hmReturn);
			/* For DTL EXP Modification logic ENDS here */			
			
            //Code need to be checked from here

          /*commented by ganga
		  if(!isFinalized) {
				for (int i=0;i<alExpData.size() ;i++ ) {
                    HashMap hmExpRecordNotfin=(HashMap)alExpData.get(i);
					stCurrentItemCodeInCaseOfError=(String)hmExpRecordNotfin.get("ITEM_CODE");
                   /* Again BLOCK new quantity                 
					HashMap hmParameter	=	new HashMap();
					hmParameter.put("store_code",fm_store_code);
					hmParameter.put("item_code",(String)hmExpRecordNotfin.get("ITEM_CODE"));
					hmParameter.put("batch_id",(String)hmExpRecordNotfin.get("BATCH_ID"));
					hmParameter.put("bin_location_code",(String)hmExpRecordNotfin.get("ISSUE_TO_BIN_LOCATION_CODE"));
					hmParameter.put("expiry_date_or_receipt_date",(String)hmExpRecordNotfin.get("EXPIRY_RECEIPT_DT"));
					//hmParameter.put("trn_qty",(String)hmExpRecordNotfin.get("RECEIVED_QTY"));
					hmParameter.put("trn_qty",checkForNull((String)hmExpRecordNotfin.get("ISSUE_QTY"),(String)hmExpRecordNotfin.get("AVAIL_QTY")));
					hmParameter.put("login_by_id",(String)alCommonData.get(0));
					hmParameter.put("login_at_ws_no",(String)alCommonData.get(1));
					hmParameter.put("login_facility_id",(String)alCommonData.get(2));

					sql = (String)hmSQL.get("GetStockItemYNFlag");
					ArrayList alStkYN	=	new ArrayList();
					alStkYN.add(hmExpRecordNotfin.get("ITEM_CODE"));
					alStkYN.add(fm_store_code);
					HashMap hmStkYN					= fetchRecord(connection, sql, alStkYN);
					fm_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
					if (fm_stk_item_yn.equals("Y")) {
						hmReturn	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B'); // B for blocking the new quantity
						throwExceptionWhenFailed(hmReturn);
					}
				}
			}commented ended */

		/*commented by ganga not required
		for (int i=0;i<alExpData.size() ;i++ ) {
			HashMap hmExpRecord=(HashMap)alExpData.get(i);
			// Updating values for ST_ISSUE_DTL for ret_item_qty BEGINS here 
			ArrayList alTempDtlUpdateFields = new ArrayList();
			alTempDtlUpdateFields.add((String)hmExpRecord.get("RECEIVED_QTY"));
			alTempDtlUpdateFields.add((String)alCommonData.get(0));
			alTempDtlUpdateFields.add((String)alCommonData.get(1));
			alTempDtlUpdateFields.add((String)alCommonData.get(2));
			alTempDtlUpdateFields.add((String)alCommonData.get(2));
			alTempDtlUpdateFields.add((String)hmExpRecord.get("ORG_DOC_TYPE_CODE"));
			alTempDtlUpdateFields.add((String)hmExpRecord.get("ISS_DOC_NO"));
			alTempDtlUpdateFields.add((String)hmExpRecord.get("SEQ_NO"));
			alTempDtlUpdateFields.add((String)hmExpRecord.get("ITEM_CODE"));
			
			//Commented by Rabbani against inc no:31625 on 08/03/2012
			/* stSQL	= (String)hmSQL.get("TrnIssDtlUpdateSQL");
			hmArgData.put(DATA,alTempDtlUpdateFields);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			try{
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
		   }catch(Exception ex) { ex.printStackTrace(); }

				// Updating values for ST_ISSUE_DTL for ret_item_qty ENDS here  

	            // Updating values for ST_ISSUE_DTL_EXP for ret_item_qty BEGINS here 
			ArrayList alUpdateFields = new ArrayList();
			alUpdateFields.add((String)hmExpRecord.get("RECEIVED_QTY"));
			//alUpdateFields.add(checkForNull((String)hmExpRecord.get("ISSUE_QTY"),(String)hmExpRecord.get("AVAIL_QTY")));
			alUpdateFields.add((String)alCommonData.get(0));
			alUpdateFields.add((String)alCommonData.get(1));
			alUpdateFields.add((String)alCommonData.get(2));
			alUpdateFields.add((String)alCommonData.get(2));
			alUpdateFields.add((String)hmExpRecord.get("ORG_DOC_TYPE_CODE"));
			alUpdateFields.add((String)hmExpRecord.get("ISS_DOC_NO"));
			alUpdateFields.add((String)hmExpRecord.get("SEQ_NO"));
			alUpdateFields.add((String)hmExpRecord.get("ITEM_CODE"));
			alUpdateFields.add((String)hmExpRecord.get("BATCH_ID"));
			alUpdateFields.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
			//Commented by Rabbani against inc no:31625 on 08/03/2012
			/* stSQL	= (String)hmSQL.get("TrnIssDtlExpUpdateSQL");
			hmArgData.put(DATA,alUpdateFields);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		    // Updating values for ST_ISSUE_DTL_EXP for ret_item_qty ENDS here  

		}commented ended*/
		/*COMMENTED BY GANGA
		if(isFinalized) {
			for (int i=0;i<alExpData.size() ;i++ ) {
			    HashMap hmExpRecord=(HashMap)alExpData.get(i);
					/* Inside DTL_EXP FOR LOOP Calling the UpdateBatchOnline STARTS here 
				HashMap hmParameters = new HashMap();
				stCurrentItemCodeInCaseOfError=(String)hmExpRecord.get("ITEM_CODE");
				hmParameters.put("item_code",(String)hmExpRecord.get("ITEM_CODE"));//item_code
				hmParameters.put("store_code",fm_store_code);
				hmParameters.put("to_store_code",to_store_code);
				hmParameters.put("trn_type","RET");
				//hmParameters.put("trn_qty",(String)hmExpRecord.get("RECEIVED_QTY"));
				hmParameters.put("trn_qty",checkForNull((String)hmExpRecord.get("RECEIVED_QTY"),(String)hmExpRecord.get("AVAIL_QTY")));
				hmParameters.put("batch_id",(String)hmExpRecord.get("BATCH_ID"));
				hmParameters.put("expiry_date_or_receipt_date",(String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				hmParameters.put("trade_id",(String)hmExpRecord.get("TRADE_ID"));
				hmParameters.put("to_bin_location_code",(String)hmExpRecord.get("ISSUE_FM_BIN_LOCATION_CODE")); //NEW_BIN_LOCATION_CODE(String)hmExpRecord.get("TO_BIN_LOCATION_CODE")
				hmParameters.put("from_bin_location_code",(String)hmExpRecord.get("ISSUE_TO_BIN_LOCATION_CODE"));
				//commented by Rabbani #inc no:29537 on 15/11/11
				//hmParameters.put("suspended_batch_allowed_yn", "N");
				hmParameters.put("suspended_batch_allowed_yn", "Y");
				hmParameters.put("release_batch_yn","N");
				hmParameters.put("last_receipt_date",""); // doc_date  
				hmParameters.put("last_issue_date",""); // doc_date
				hmParameters.put("login_by_id",(String)alCommonData.get(0));
				hmParameters.put("login_at_ws_no",(String)alCommonData.get(1));
				hmParameters.put("login_facility_id",(String)alCommonData.get(2));
		//	String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
				  hmparam = new ArrayList();
			            
				 p_from_bin_location_code		= checkForNull (hmParameters.get("from_bin_location_code"));
				 p_from_store_code				= checkForNull (hmParameters.get("store_code")); 
				 p_to_store_code					= checkForNull	(hmParameters.get("to_store_code"));
				 p_to_bin_location_code			= checkForNull (hmParameters.get("to_bin_location_code"));
				 p_item_code						= checkForNull (hmParameters.get("item_code")); 
				 p_batch_id						= checkForNull (hmParameters.get("batch_id")); 
				 p_expiry_date_or_receipt_date	= checkForNull (hmParameters.get("expiry_date_or_receipt_date"));
						
						   hmparam.add(p_from_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_from_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
						   							   
						   hmParameters.put("modified_date",mod_date);
						   hmparam = new ArrayList();
						    hmparam.add(p_to_store_code);
						   hmparam.add(p_item_code);
						   hmparam.add(p_batch_id);
						   hmparam.add(p_to_bin_location_code);
						   hmparam.add(p_expiry_date_or_receipt_date);
		                    mod_date = (String)((HashMap)fetchRecord(connection,modified_date,hmparam)).get("MODIFIED_DATE");
					
						   hmParameters.put("to_modified_date",mod_date);
			
			
			

				if((Double.parseDouble((String)hmExpRecord.get("RECEIVED_QTY"))) > 0){
					updateBatchOnLine(connection, hmSQL, hmParameters);
				}
				
				/* Inside DTL_EXP FOR LOOP Calling the UpdateBAtchOnline ENDS here */
				/* Setting values(for FORM) and inserting into ST_ITEM_TRN_DTL table BEGINS here

                ArrayList alTempItmDtl = (ArrayList)hmItemDtl.get((String)hmExpRecord.get("ITEM_CODE")); 
				sql = (String)hmSQL.get("GetStockItemYNFlag");
				ArrayList alStkYN	=	new ArrayList();
				alStkYN.add(hmExpRecord.get("ITEM_CODE"));
				alStkYN.add(fm_store_code);
				HashMap hmStkYN					= fetchRecord(connection, sql, alStkYN);
				fm_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
				ArrayList alFromDtlTrn=new ArrayList();
				
				alFromDtlTrn.add(alCommonData.get(2));//facility_id
				alFromDtlTrn.add(fm_store_code);//From store_code
				alFromDtlTrn.add((String)hmExpRecord.get("ITEM_CODE"));//item_code
				alFromDtlTrn.add(""+1);
				alFromDtlTrn.add("RET");
				alFromDtlTrn.add(alCommonData.get(3));
				alFromDtlTrn.add((String)hmExpRecord.get("RET_DOC_NO"));
				alFromDtlTrn.add((String)hmExpRecord.get("doc_srl_no"));
				alFromDtlTrn.add((String)hmExpRecord.get("DOC_DATE"));
				alFromDtlTrn.add("");
				alFromDtlTrn.add((String)hmExpRecord.get("BATCH_ID"));
				alFromDtlTrn.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				//alFromDtlTrn.add("-"+(String)hmExpRecord.get("RECEIVED_QTY"));
				double trn_qty = Double.parseDouble(((String)hmExpRecord.get("RECEIVED_QTY")).equals("")?"0":(String)hmExpRecord.get("RECEIVED_QTY"))+ Double.parseDouble(((String)hmExpRecord.get("REJECTED_QTY")).equals("")?"0":(String)hmExpRecord.get("REJECTED_QTY"));
				alFromDtlTrn.add("-"+trn_qty);
				alFromDtlTrn.add((String)alTempItmDtl.get(0)); 
				//alFromDtlTrn.add((String)alTempItmDtl.get(2)); 
				alFromDtlTrn.add((String)hmExpRecord.get("ORG_DOC_TYPE_CODE")); 
				alFromDtlTrn.add((String)hmExpRecord.get("ISS_DOC_NO")); 
				alFromDtlTrn.add((String)hmExpRecord.get("DOC_SRL_NO")); 
				alFromDtlTrn.add((String)hmExpRecord.get("DOC_DATE")); 
                alFromDtlTrn.add(to_store_code); //other store 
				alFromDtlTrn.add(fm_stk_item_yn);//"Y");
				alFromDtlTrn.add((String)hmExpRecord.get("uom_code"));
				alFromDtlTrn.add((String)alCommonData.get(0));
				alFromDtlTrn.add((String)alCommonData.get(1));
				alFromDtlTrn.add((String)alCommonData.get(2));
				alFromDtlTrn.add((String)alCommonData.get(0));
				alFromDtlTrn.add((String)alCommonData.get(1));
				alFromDtlTrn.add((String)alCommonData.get(2));
				//alFromDtlTrn.add(checkForNull((String)hmExpRecord.get("ISSUE_TO_BIN_LOCATION_CODE")));//fm_bin_location_code
				//Modified on 21/07/2004
				alFromDtlTrn.add(checkForNull((String)hmExpRecord.get("NEW_BIN_LOCATION_CODE")));
				alFromDtlTrn.add((String)hmExpRecord.get("TRADE_ID"));//trade_id 
                alFromDtlTrn.add((String)hmExpRecord.get("SEQ_NO"));
                
				//stSQL	= (String)hmSQL.get("TrnDtlInsertSQL");
//Hardcoded by Mahesh on 6/5/2008 because we are not inserting stock uom code properly in the main Transaction..remove once it is through..
				stSQL	= "INSERT INTO ST_ITEM_TRN_DTL(FACILITY_ID,STORE_CODE,ITEM_CODE,POSTED_DATE,TRN_SRL_NO,TRN_TYPE,DOC_TYPE_CODE,DOC_NO,DOC_SRL_NO,DOC_DATE,DOC_REF,BATCH_ID,EXPIRY_DATE,ITEM_QTY_NORMAL,ITEM_UNIT_COST,SOURCE_DOC_TYPE_CODE,SOURCE_DOC_NO,SOURCE_DOC_SRL_NO,SOURCE_DOC_DATE,OTHER_STORE_CODE,STOCK_ITEM_YN,STK_UOM_CODE,ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BIN_LOCATION_CODE, TRADE_ID, SOURCE_SEQ_NO  ) VALUES (?,?,?,SYSDATE,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,? )";
				hmArgData.put(DATA,alFromDtlTrn);
			    hmArgSQL.put(INSERT_SQL,stSQL);
				if(trn_qty>0){
					hmReturn	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}
				if (fm_stk_item_yn.equals("N")) {
					alFromDtlTrn.set(3,""+3);
					//alFromDtlTrn.set(12,hmExpRecord.get("RECEIVED_QTY"));
					alFromDtlTrn.set(12,""+trn_qty);
					alFromDtlTrn.set(4,"CON");
					if(trn_qty > 0){
						hmReturn	=	insert(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmReturn);
					}
				}

			   /* Setting values(for FORM) and inserting into ST_ITEM_TRN_DTL table ENDS here */

			   /* Setting values(for TO) and inserting into ST_ITEM_TRN_DTL table BEGINS here 
                
				ArrayList alToDtlTrn=new ArrayList();
				
				alToDtlTrn.add(alCommonData.get(2)); //facility_id
				alToDtlTrn.add(to_store_code); //To store_code
				alToDtlTrn.add((String)hmExpRecord.get("ITEM_CODE"));//item_code
				alToDtlTrn.add(""+2);
				alToDtlTrn.add("RET");
				alToDtlTrn.add(alCommonData.get(3));
				alToDtlTrn.add((String)hmExpRecord.get("RET_DOC_NO"));
				alToDtlTrn.add((String)hmExpRecord.get("doc_srl_no"));
				alToDtlTrn.add((String)hmExpRecord.get("DOC_DATE"));
				alToDtlTrn.add("");
				alToDtlTrn.add((String)hmExpRecord.get("BATCH_ID"));
				alToDtlTrn.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				//alToDtlTrn.add((String)hmExpRecord.get("RECEIVED_QTY"));
				alToDtlTrn.add(""+trn_qty);
				alToDtlTrn.add((String)alTempItmDtl.get(0)); 
				//alToDtlTrn.add((String)alTempItmDtl.get(2)); 

				alToDtlTrn.add((String)hmExpRecord.get("ORG_DOC_TYPE_CODE")); 
				alToDtlTrn.add((String)hmExpRecord.get("ISS_DOC_NO")); 
				alToDtlTrn.add((String)hmExpRecord.get("DOC_SRL_NO")); 
				alToDtlTrn.add((String)hmExpRecord.get("DOC_DATE")); 

                alToDtlTrn.add(fm_store_code); 
				alToDtlTrn.add("Y");
				alToDtlTrn.add((String)hmExpRecord.get("TO_UOM_CODE"));
				alToDtlTrn.add((String)alCommonData.get(0));
				alToDtlTrn.add((String)alCommonData.get(1));
				alToDtlTrn.add((String)alCommonData.get(2));
				alToDtlTrn.add((String)alCommonData.get(0));
				alToDtlTrn.add((String)alCommonData.get(1));
				alToDtlTrn.add((String)alCommonData.get(2));
				//alToDtlTrn.add(checkForNull((String)hmExpRecord.get("ISSUE_FM_BIN_LOCATION_CODE"))); // to_bin_location_code
				//Modified on 21/07/2004
                alToDtlTrn.add(checkForNull((String)hmExpRecord.get("NEW_BIN_LOCATION_CODE"))); 
				alToDtlTrn.add((String)hmExpRecord.get("TRADE_ID"));//trade_id 

                alToDtlTrn.add((String)hmExpRecord.get("SEQ_NO"));
				
				//stSQL	= (String)hmSQL.get("TrnDtlInsertSQL");
				stSQL	= "INSERT INTO ST_ITEM_TRN_DTL(FACILITY_ID,STORE_CODE,ITEM_CODE,POSTED_DATE,TRN_SRL_NO,TRN_TYPE,DOC_TYPE_CODE,DOC_NO,DOC_SRL_NO,DOC_DATE,DOC_REF,BATCH_ID,EXPIRY_DATE,ITEM_QTY_NORMAL,ITEM_UNIT_COST,SOURCE_DOC_TYPE_CODE,SOURCE_DOC_NO,SOURCE_DOC_SRL_NO,SOURCE_DOC_DATE,OTHER_STORE_CODE,STOCK_ITEM_YN,STK_UOM_CODE,ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BIN_LOCATION_CODE, TRADE_ID, SOURCE_SEQ_NO  ) VALUES (?,?,?,SYSDATE,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,TO_DATE(?, 'DD/MM/YYYY') ,?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,? )";
				hmArgData.put(DATA,alToDtlTrn);
			    hmArgSQL.put(INSERT_SQL,stSQL);
				if(trn_qty>0){
					hmReturn	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}
			   /* Setting values(for TO) and inserting into ST_ITEM_TRN_DTL table BEGINS here 
			   } //End of for Loop 

			}  //End of if */

			//connection.commit();
		}
		catch(Exception exception) {
			try {
				//connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmReturn.put("flag",stCurrentItemCodeInCaseOfError);
			}
		}
		return hmReturn;
	}
	public void ItemMoveSummaryForIssueReturn (Connection connection,HashMap hmData,HashMap hmSQL,HashMap hmDtlData) throws Exception 
	{
		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();
        HashMap	hmtempDtlData			=	new HashMap();
        hmtempDtlData					=   hmDtlData ;
		ArrayList alCommonData			=	(ArrayList)	hmData.get("COMMON_DATA");
        ArrayList alHdrData				=	(ArrayList)(((ArrayList)hmData.get("HDR_DATA")).get(0));
		ArrayList alItemMoveSummRecord	=	new ArrayList();

        String stItemCode	   = (String)hmtempDtlData.get("item_code") ;
		String stFromStoreCode = (String)hmtempDtlData.get("store_code") ;
		String stToStoreCode   = (String)hmtempDtlData.get("to_store_code") ;
        /* Check the item for stacable in both the store */

		ArrayList batchDetails = getBatchDetails(connection,stItemCode,stFromStoreCode,stToStoreCode);

		String l_doc_date	= (String)alHdrData.get(0); //doc_date
        alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);
		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));
		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");

        /* For Record to be inserted in st_item_move_summ table */
		String fm_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmtempDtlData.get("store_code")).get("FACILITY_ID");//Added by Rabbani on 15/04/2014

		alItemMoveSummRecord.clear();
		//alItemMoveSummRecord.add(alCommonData.get(2));						// facility_id
		alItemMoveSummRecord.add(fm_facility_id);								// facility_id
		alItemMoveSummRecord.add((String)hmtempDtlData.get("item_code"));       // Item code
		alItemMoveSummRecord.add((String)hmtempDtlData.get("store_code")); // fm store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);
/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		//nafitive_value_to_zero.add(alCommonData.get(2));      // facility_id
		nafitive_value_to_zero.add(fm_facility_id);      // facility_id
		nafitive_value_to_zero.add((String)hmtempDtlData.get("item_code"));     // Item code
		nafitive_value_to_zero.add((String)hmtempDtlData.get("store_code"));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {
			alItemMoveSummRecord.clear();

			//alItemMoveSummRecord.add(alCommonData.get(2));     //facility code
			alItemMoveSummRecord.add(fm_facility_id);     //facility code
			alItemMoveSummRecord.add((String)hmtempDtlData.get("item_code")); //Item code
			alItemMoveSummRecord.add((String)hmtempDtlData.get("store_code"));      // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));        //Quantity
			alItemMoveSummRecord.add("-"+(String)hmtempDtlData.get("mm_trn_qty"));        //Quantity
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmtempDtlData.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add("-"+(String)hmtempDtlData.get("trn_value")); //month_closing_value = item_cost_value
			}//Cost value
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));		//From Quantity for month end
			alItemMoveSummRecord.add("-"+(String)hmtempDtlData.get("mm_trn_qty"));		//From Quantity for month end
			alItemMoveSummRecord.add("-"+(String)hmtempDtlData.get("trn_value")); //Cost value for month end
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));        //For OUT_RET_QTY_ST
			alItemMoveSummRecord.add("-"+(String)hmtempDtlData.get("mm_trn_qty"));        //For OUT_RET_QTY_ST
            alItemMoveSummRecord.add("-"+(String)hmtempDtlData.get("trn_value")); //For OUT_RET_COST_ST

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
		   
           if(((String)batchDetails.get(5)).equals("Y"))
  			 stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQLST");
		   else
             stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQLNS");
           
			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {

			alItemMoveSummRecord.clear();
		
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));		//From Quantity
			alItemMoveSummRecord.add((String)hmtempDtlData.get("mm_trn_qty"));		//From Quantity
			alItemMoveSummRecord.add((String)hmtempDtlData.get("trn_value")); //Cost value
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));		//From Quantity for month end
			alItemMoveSummRecord.add((String)hmtempDtlData.get("mm_trn_qty"));		//From Quantity for month end
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmtempDtlData.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add((String)hmtempDtlData.get("trn_value")); //month_closing_value = item_cost_value
			}	//Cost value for month end
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));		//For OUT_RET_QTY_ST
			alItemMoveSummRecord.add((String)hmtempDtlData.get("mm_trn_qty"));		//For OUT_RET_QTY_ST
			alItemMoveSummRecord.add((String)hmtempDtlData.get("trn_value")); //For OUT_RET_COST_ST

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			//alItemMoveSummRecord.add(alCommonData.get(2));     // facility_id
			alItemMoveSummRecord.add(fm_facility_id);     // facility_id
			alItemMoveSummRecord.add((String)hmtempDtlData.get("item_code")); // Item code
			alItemMoveSummRecord.add((String)hmtempDtlData.get("store_code")); // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			if(((String)batchDetails.get(5)).equals("Y"))
				stSQL = (String)hmSQL.get("ItemMovSumFromUpdateSQLST");
			else
				stSQL	=	(String)hmSQL.get("ItemMovSumFromUpdateSQLNS");


			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		alItemMoveSummRecord.clear();
		
		 String to_facility_id = (String)fetchRecord(connection, (String)hmSQL.get ("sql_st_facility_id_select"), (String)hmtempDtlData.get("to_store_code")).get("FACILITY_ID");


		//alItemMoveSummRecord.add(alCommonData.get(2));					      // facility_id
		alItemMoveSummRecord.add(to_facility_id);					      // facility_id
		alItemMoveSummRecord.add((String)hmtempDtlData.get("item_code"));     // Item code
		alItemMoveSummRecord.add((String)hmtempDtlData.get("to_store_code")); // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {

			alItemMoveSummRecord.clear();

			//alItemMoveSummRecord.add(alCommonData.get(2));     //facility code
			alItemMoveSummRecord.add(to_facility_id);     //facility code
			alItemMoveSummRecord.add((String)hmtempDtlData.get("item_code")); //Item code
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_store_code"));      // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));        //Quantity
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_mm_trn_qty"));        //Quantity
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmtempDtlData.get("to_mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add((String)hmtempDtlData.get("to_trn_value")); //month_closing_value = item_cost_value
			} //Cost value
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty")); //From Quantity for month end
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_mm_trn_qty")); //From Quantity for month end
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_trn_value")); //Cost value for month end
            //alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));
            alItemMoveSummRecord.add((String)hmtempDtlData.get("to_mm_trn_qty"));
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_trn_value"));

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQLST");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

		}
		else {      
			alItemMoveSummRecord.clear();

			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));        //Quantity
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_mm_trn_qty"));        //Quantity
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_trn_value")); //Cost value
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));        //From Quantity for month end
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_mm_trn_qty"));        //From Quantity for month end
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmtempDtlData.get("to_mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add((String)hmtempDtlData.get("to_trn_value")); //month_closing_value = item_cost_value
			} //Cost value for month end
			//alItemMoveSummRecord.add((String)hmtempDtlData.get("item_qty"));       
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_mm_trn_qty"));       
            alItemMoveSummRecord.add((String)hmtempDtlData.get("to_trn_value"));

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			//alItemMoveSummRecord.add(alCommonData.get(2));							  // facility_id
			alItemMoveSummRecord.add(to_facility_id);							  // facility_id
			alItemMoveSummRecord.add((String)hmtempDtlData.get("item_code"));     // Item code
			alItemMoveSummRecord.add((String)hmtempDtlData.get("to_store_code")); // to store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			if(((String)batchDetails.get(6)).equals("Y"))
				stSQL = (String)hmSQL.get ("ItemMovSumToUpdateSQLST");
			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		 //stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";

		 stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

	}
	public ArrayList getBatchDetails(Connection connection,String item_code, String store_code,String to_store_code )throws Exception {

		ArrayList BatchDetails=new ArrayList();
		try {

			String[] strParameters = new String[7];

			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "Y";
			strParameters[6] = to_store_code ;
			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(connection,strParameters);
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn"));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("item_unit_cost"));
			BatchDetails.add(new Integer ((String)hmStockAvailabilityStatus.get("store_item_unit_cost")));
			BatchDetails.add(new Integer ((String)hmStockAvailabilityStatus.get("available_stock")));
			BatchDetails.add(new Integer ((String)hmStockAvailabilityStatus.get("expired_stock")));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("to_stock_item_yn"));
	
		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		return BatchDetails;
	}

	public double getConvFactTemp(String item_code,String store_code,HashMap hmSQL,String language_id,Properties properties){
			double conv_fac_temp		  = 1.0;	
			HashMap conv_factor		  = new HashMap();
			try{
				//String chkdefaultParameters[] = {getGenItemUOM(item_code,hmSQL,language_id),store_code,item_code,item_code,getGenItemUOM(item_code,hmSQL,language_id),store_code,item_code};
				String chkdefaultParameters[] = {item_code,store_code};

				//conv_factor = fetchRecord(connection,(String)hmSQL.get("SQL_ST_CONV_FACTOR_SELECT"),chkdefaultParameters);
				conv_factor = fetchRecord(connection,"SELECT St_Get_Uom_Conv_Fac_Sing_Str(?,?) CONV_FACTOR FROM DUAL",chkdefaultParameters);
			}catch(Exception e){
				conv_fac_temp = 1.0;
				e.printStackTrace();
			}
			
			if(conv_factor.size() > 0)
				conv_fac_temp = Double.parseDouble((String)conv_factor.get("CONV_FACTOR"));

			return conv_fac_temp;
	}
	
	public String getGenItemUOM(String item_code,HashMap hmSQL,String language_id) throws Exception {
		String chkdefaultParameters[] = {item_code,language_id};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				base_uom = fetchRecord(connection,(String)hmSQL.get("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");
		return gen_uom_code;
	}
	public HashMap getStockAvailabilityStatus(Connection connection,String [] stParameters)throws Exception{
		//Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap hmReturn	=	new HashMap();

		try{
			//connection = getConnection();
			callableStatement	= connection.prepareCall("{ CALL st_stock_availability_status(?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, stParameters[0]);//item_code
			callableStatement.setString(2, stParameters[1]);//store_code
			callableStatement.setLong(3, Long.parseLong(stParameters[2]));//qty_required
			callableStatement.setString(4, stParameters[3]);//consider_qty_required_yn
			callableStatement.setString(5, stParameters[4]);//effective_date_for_expiry
			callableStatement.setString(6, stParameters[5]);//include_suspended_batch_yn
			callableStatement.setString(7, stParameters[6]);//to_store_code
			callableStatement.registerOutParameter(8, Types.VARCHAR);	//stock_available_yn
			callableStatement.registerOutParameter(9, Types.INTEGER);	//item_unit_cost
			callableStatement.registerOutParameter(10, Types.INTEGER);	//store_item_unit_cost
			callableStatement.registerOutParameter(11, Types.INTEGER);	//available_stock
			callableStatement.registerOutParameter(12, Types.INTEGER);	//expired_stock
			callableStatement.registerOutParameter(13, Types.VARCHAR);	//stock_item_yn
			callableStatement.registerOutParameter(14, Types.VARCHAR);	//to_stock_item_yn
			callableStatement.registerOutParameter(15, Types.INTEGER);	//to_qty_on_hand
			callableStatement.registerOutParameter(16, Types.INTEGER);	//to_store_item_unit_cost
			callableStatement.registerOutParameter(17, Types.VARCHAR);	//to_store_master_bin
			callableStatement.registerOutParameter(18, Types.VARCHAR);	//item_Store_combination_exists
			callableStatement.registerOutParameter(19, Types.VARCHAR);	//msg_text
			callableStatement.execute();
			
			hmReturn.put("stock_available_yn",callableStatement.getString(8));
			hmReturn.put("item_unit_cost",""+callableStatement.getLong(9));
			hmReturn.put("store_item_unit_cost",""+callableStatement.getLong(10));
			hmReturn.put("available_stock",""+callableStatement.getLong(11));
			hmReturn.put("expired_stock",""+callableStatement.getLong(12));
			hmReturn.put("stock_item_yn",callableStatement.getString(13));
			hmReturn.put("to_stock_item_yn",callableStatement.getString(14));
			hmReturn.put("to_qty_on_hand",""+callableStatement.getLong(15));
			hmReturn.put("to_store_item_unit_cost",""+callableStatement.getLong(16));
			hmReturn.put("to_store_master_bin",callableStatement.getString(17));
			if (callableStatement.getString(18)!=null &&callableStatement.getString(18).equals("N"))
			{
				throw new Exception (callableStatement.getString(19));
			}
		}
		catch(Exception exception){
				if (!(callableStatement.getString(18)!=null &&callableStatement.getString(18).equals("N")))
				{
					exception.printStackTrace();
				}
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			//closeConnection(connection);
		}
		return hmReturn;
	}
	public void generateDocNo(Connection connection,HashMap hmData) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	languageData;
		//String		stSQL		=	null;

		alCommonData	=	(ArrayList)	hmData.get("COMMON_DATA");
		stSQL			=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
		languageData	=	(ArrayList)	hmData.get("LANGUAGE_DATA");
		String adj_doc_type_code = (String)fetchRecord(connection, "SELECT DEF_ADJ_DOC_TYPE_CODE DOC_TYPE_CODE FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ? AND MATERIAL_GROUP_CODE = 'ALL'", (String)alCommonData.get(2)).get("DOC_TYPE_CODE");
		ArrayList alNextDocNoUpdateData	=	new ArrayList();
		alNextDocNoUpdateData.add(alCommonData.get(0));
		alNextDocNoUpdateData.add(alCommonData.get(1));
		alNextDocNoUpdateData.add(alCommonData.get(2));
		alNextDocNoUpdateData.add(adj_doc_type_code);
		hmArgData.put(DATA,alNextDocNoUpdateData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}
///ADJUST STOCK LOGIC STARTS HERE
	public HashMap insertAdjStock(HashMap hmDataValues, HashMap hmSQLValues){
	
	//System.out.println("insertAdjStock ==4153===");
		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;

		hmReturn	=	new HashMap();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();

		String stCurrentItemCodeInCaseOfError=null;

		hmReturn.put(RESULT,FALSE);
		// Variable to hold the current item description, to display along with the error message.

		String l_curr_item_desc = "";
		try {
			//properties			=	(Properties)	hmData.get("properties");
			//connection			=	getConnection(properties);
			//connection.setAutoCommit(false);

			//Call to the insert header method, to insert the record in st_adj_hdr.

			insertOrUpdateHeader(connection);
			alDtlData	=	(ArrayList)		hmData.get("alAdjDtlData");
			//System.out.println("alDtlData===4175===>" +alDtlData);
			stSQL		=	(String)		hmSQL.get ("DtlAdjInsertSQL");
			//System.out.println("stSQL===4175===>" +stSQL);

			for (int i=0; i<alDtlData.size();i++ ) {
				//Call to the insertDetail method, to insert records in to st_adj_dtl.
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				stCurrentItemCodeInCaseOfError=(String)hmRecord.get("item_code");
				String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");
				l_curr_item_desc = (String) hmRecord.get("item_desc");

// PROBLEM HERE  
				insertOrUpdateDetail(connection, i);
				alExpData	=	(ArrayList)		hmData.get("alAdjExpData");
				//System.out.println("alExpData===4190===>" +alExpData);

				for (int j=0; j<alExpData.size();j++ ) {
					HashMap hmExpRecord	=	(HashMap) alExpData.get(j);
					//System.out.println("hmExpRecord===4190===>" +hmExpRecord);
					if (!doc_srl_no.equals(hmExpRecord.get("doc_srl_no")) ) {
						continue;
					}else if(!((String)hmRecord.get("doc_no")).equals((String)hmExpRecord.get("doc_no")))
						continue;
					
					insertDetailExp(connection, i, j);						
										
				}
			}

			//if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
				//Call to generate Document Number method, to  generate the next document number
				//generateDocNo(connection,hmData);
			//}
			//connection.commit();
        }
		catch(Exception exception) {
			try {
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace();
			}

			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
			hmReturn.put("invalidCode",l_curr_item_desc);

			if ((exception.getMessage().equals("INSUFFICIENT_BATCH_QTY")) || (exception.getMessage().equals("NEGATIVE_STOCK"))) {
				hmReturn.put("flag",stCurrentItemCodeInCaseOfError);
			}
		}
		return hmReturn;
	}
	public void insertOrUpdateHeader(Connection connection) throws Exception {

		HashMap		hmArgData		=	new HashMap();
		HashMap		hmArgSQL		=	new HashMap();
		ArrayList	alHdrData		=	new ArrayList();

		alHdrData					=	(ArrayList)	hmData.get("alAdjHdrData");
		String stSQL				=	(String)	hmSQL.get ("adjHdrInsertSql");

		hmArgData.put(DATA,alHdrData);
		hmArgSQL.put(BATCH_SQL,stSQL);
		hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}

	/**
	* Method to insert the item details. For one header there could be more than one
	* item details.
	* @param int, the index of the corresponding item detail.
	*/

	public void insertOrUpdateDetail(Connection connection, int i) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		//ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();

		String		stSQL		=	null;

		alDtlData		=	(ArrayList)	hmData.get("alAdjDtlData");
		alCommonData	=	(ArrayList)	hmData.get("COMMON_DATA");

		ArrayList	alDtlRecord	=	new ArrayList();
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);
		//System.out.println("@@@@@@@@@hmRecord===>"+hmRecord);
		/**
			 * @Name - Priya
			 * @Date - 03/06/2010
			 * @Inc# - 
			 * @Desc -  To get noOfDecimalsForCost &  round up item_cost_value with noOfDecimalsForCost
			 */
		int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
		hmRecord.put("item_unit_cost",setNumber((String)hmRecord.get("item_unit_cost"),noOfDecimalsForCost));
		hmRecord.put("item_cost_value",setNumber((String)hmRecord.get("item_cost_value"),noOfDecimalsForCost));

			alDtlRecord.add(alCommonData.get(2));
			alDtlRecord.add(adj_doc_type_code);
			alDtlRecord.add((String)hmRecord.get("doc_no"));
			alDtlRecord.add(hmRecord.get("doc_srl_no"));         //doc_srl_no
			alDtlRecord.add(hmRecord.get("item_code"));
			alDtlRecord.add(hmRecord.get("adj_item_qty"));
			alDtlRecord.add(hmRecord.get("item_unit_cost"));
			alDtlRecord.add(hmRecord.get("item_cost_value"));
			alDtlRecord.add(hmRecord.get("remarks"));

			alDtlRecord.add(alCommonData.get(0));
			alDtlRecord.add(alCommonData.get(1));
			alDtlRecord.add(alCommonData.get(2));
			alDtlRecord.add(alCommonData.get(0));
			alDtlRecord.add(alCommonData.get(1));
			alDtlRecord.add(alCommonData.get(2));

			stSQL				=	(String)	hmSQL.get ("DtlAdjInsertSQL");
			hmArgData.put(DATA,alDtlRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			String item_code	= (String)hmRecord.get("item_code");
			String store_code	= (String)hmRecord.get("store_code");
			String trn_type		= "ADJ";
			String trn_qty		= (String)hmRecord.get("adj_item_qty");
			String trn_cost		= (String)hmRecord.get("item_unit_cost");
			String trn_value	= (String)hmRecord.get("item_cost_value");

			ArrayList alData		= new ArrayList ();
			alData.add(item_code);			
			alData.add(store_code);

			HashMap hmResult		= fetchRecord(connection, (String)hmSQL.get ("GetStockItemYNFlag"), alData);
			String stock_item_yn	= (String)hmResult.get("STOCK_ITEM_YN"); 

			HashMap hmParameters = new HashMap();
			hmParameters.put("item_code",item_code);
			hmParameters.put("store_code",store_code);
			hmParameters.put("trn_type",trn_type);
			hmParameters.put("trn_qty",trn_qty);
			hmParameters.put("trn_unit_cost",trn_cost);
			hmParameters.put("trn_value",trn_value);
			hmParameters.put("mm_trn_qty",(String)hmRecord.get("mm_trn_qty"));
			hmParameters.put("language_id",(String)hmRecord.get("language_id"));
			hmParameters.put("from_stk_item_yn",stock_item_yn);
			hmParameters.put("login_by_id",alCommonData.get(0));
			hmParameters.put("login_at_ws_no",alCommonData.get(1));
			hmParameters.put("login_facility_id",alCommonData.get(2));			
			//calculateAndUpdateOnlineStock (connection, hmSQL, hmParameters);


			insertItemMoveSummaryForADJ (connection, i);
	}

	/**
	* Method to insert data in to the batch details. For one item details there could be
	* more than one batches.
	* @param int, the item detail index
	* @param int, the batch index
	*/

	public void insertDetailExp(Connection connection, int i, int j) throws Exception {

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData;
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alExpData	=	new ArrayList();
		String		stSQL		=	null;

		alDtlData		=	(ArrayList)	hmData.get("alAdjDtlData");
		alExpData		=	(ArrayList)	hmData.get("alAdjExpData");
		alCommonData	=	(ArrayList)	hmData.get("COMMON_DATA");
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);
		String doc_srl_no	=	(String)hmRecord.get("doc_srl_no");

		ArrayList	alExpRecord	=	new ArrayList();
		HashMap hmExpRecord	=	(HashMap) alExpData.get(j);
		//hmExpRecord.put("doc_no",(String)hmRecord.get("doc_no"));
		alExpRecord.add(alCommonData.get(2));
		alExpRecord.add(adj_doc_type_code);
		alExpRecord.add((String)hmExpRecord.get("doc_no"));
		alExpRecord.add((String)hmExpRecord.get("doc_srl_no"));//doc_srl_no
		alExpRecord.add((String)hmRecord.get("store_code"));//store_code

		alExpRecord.add(hmRecord.get("item_code"));//refering to dtl record
		alExpRecord.add(hmExpRecord.get("batch_id"));
		alExpRecord.add(hmExpRecord.get("bin_location_code"));
		alExpRecord.add(hmExpRecord.get("expiry_date_or_receipt_date"));
		alExpRecord.add(hmExpRecord.get("trade_id"));
		alExpRecord.add(hmExpRecord.get("item_qty"));
		alExpRecord.add(alCommonData.get(0));
		alExpRecord.add(alCommonData.get(1));
		alExpRecord.add(alCommonData.get(2));
		alExpRecord.add(alCommonData.get(0));
		alExpRecord.add(alCommonData.get(1));
		alExpRecord.add(alCommonData.get(2));
		alExpRecord.add(checkForNull(hmExpRecord.get("barcode_id")));//added for barcode implementation it will be null always

		stSQL				=	(String)	hmSQL.get ("ExpInsertSQL");
		hmArgData.put(DATA,alExpRecord);
		hmArgSQL.put(INSERT_SQL,stSQL);

		hmReturn	=	insert(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

		String batch_id						=	(String)hmExpRecord.get("batch_id");
		String expiry_date_or_receipt_date	=	(String)hmExpRecord.get("expiry_date_or_receipt_date");
		String trade_id						=	(String)hmExpRecord.get("trade_id");
		String bin_location_code			=	(String)hmExpRecord.get("bin_location_code");
		String trn_qty						=	(String)hmExpRecord.get("item_qty");
		String item_code	= (String)hmRecord.get("item_code");
		String store_code	= (String)hmRecord.get("store_code");
		String trn_type		= "ADJ";
		// This is hardcoded as 'y' for time being.
		String suspended_batch_allowed_yn	= "Y";		   


			HashMap hmParamaters = new HashMap();
			hmParamaters.put("item_code",item_code);
			hmParamaters.put("store_code",store_code);
			hmParamaters.put("trn_type",trn_type);
			hmParamaters.put("trn_qty",trn_qty);
			hmParamaters.put("batch_id",batch_id);
			hmParamaters.put("expiry_date_or_receipt_date",expiry_date_or_receipt_date);
			hmParamaters.put("trade_id",trade_id);
			hmParamaters.put("from_bin_location_code",bin_location_code);
			hmParamaters.put("suspended_batch_allowed_yn",suspended_batch_allowed_yn);
			hmParamaters.put("release_batch_yn","N");								  
			hmParamaters.put("login_by_id",alCommonData.get(0));
			hmParamaters.put("login_at_ws_no",alCommonData.get(1));
			hmParamaters.put("login_facility_id",alCommonData.get(2));				  

			//updateBatchOnLine (connection, hmSQL, hmParamaters);					  
			

			/* Insert in to st_item_trn_dtl table*/									  

			String l_trn_srl_no = Integer.toString(j+1);							  
			alExpRecord.clear();
			alExpRecord.add(alCommonData.get(2));
			alExpRecord.add(store_code);
			alExpRecord.add(item_code);
			alExpRecord.add(l_trn_srl_no);
			alExpRecord.add(trn_type);
			alExpRecord.add(adj_doc_type_code); // doc_type_code
			alExpRecord.add((String)hmExpRecord.get("doc_no")); // doc_no
			alExpRecord.add(doc_srl_no);
			alExpRecord.add(com.ehis.util.DateUtils.getCurrentDate("DMY","en")); // doc_date							  
			alExpRecord.add(""); // doc_ref
			alExpRecord.add(batch_id);
			alExpRecord.add(expiry_date_or_receipt_date);
			alExpRecord.add(trn_qty);						// item_qty_normal
			alExpRecord.add(hmRecord.get("item_unit_cost"));						  
			alExpRecord.add(hmRecord.get("stock_uom_code")); // stk_uom_code -  has to be changed
			alExpRecord.add("Y"); // stock_item_yn									  
			alExpRecord.add(alCommonData.get(0));
			alExpRecord.add(alCommonData.get(1));
			alExpRecord.add(alCommonData.get(2));
			alExpRecord.add(alCommonData.get(0));
			alExpRecord.add(alCommonData.get(1));
			alExpRecord.add(alCommonData.get(2));									  
			alExpRecord.add(bin_location_code);
			alExpRecord.add(trade_id);												  
			stSQL	=	(String)	hmSQL.get ("ItemTrnDtlAdjInsertSQL");				  
			hmArgData.put(DATA,alExpRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
	}
	public void insertItemMoveSummaryForADJ (Connection connection, int i) throws Exception {

		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alDtlData				=	new ArrayList();
		ArrayList alItemMoveSummRecord	=	new ArrayList();
		ArrayList alCommonData			=	(ArrayList)	hmData.get("COMMON_DATA");


		alDtlData			=	(ArrayList)	hmData.get("alAdjDtlData");
		HashMap hmRecord	=	(HashMap) alDtlData.get(i);

		String l_doc_date	= com.ehis.util.DateUtils.getCurrentDate("DMY","en"); //doc_date

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);


		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));

		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");
		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
		alItemMoveSummRecord.add(hmRecord.get("item_code"));
		alItemMoveSummRecord.add(hmRecord.get("store_code"));
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(alCommonData.get(2));      // facility_id
		nafitive_value_to_zero.add(hmRecord.get("item_code"));     // Item code
		nafitive_value_to_zero.add(hmRecord.get("store_code"));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	
		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {

			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(hmRecord.get("item_code"));
			alItemMoveSummRecord.add(hmRecord.get("store_code")); // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmRecord.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value")); //month_closing_value = item_cost_value
			}
			
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));

			double adj_item_qty = Double.parseDouble(((String)(hmRecord.get("adj_item_qty"))));
			//int adj_item_qty = Integer.parseInt(((String)(hmRecord.get("mm_trn_qty"))));
			
			if(adj_item_qty >= 0) {
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
			}
			else {
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			}							   				

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			stSQL	=	(String)hmSQL.get ("ItemMovSumAdjInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {
			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
			alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)hmRecord.get("mm_trn_qty"),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value")); //month_closing_value = item_cost_value
			}
			

			//int adj_item_qty = Integer.parseInt(((String)(hmRecord.get("adj_item_qty"))));
			double adj_item_qty = Double.parseDouble(((String)(hmRecord.get("mm_trn_qty"))));

			if(adj_item_qty >= 0) {
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
			}
			else {
				alItemMoveSummRecord.add("0");
				alItemMoveSummRecord.add("0");
				//alItemMoveSummRecord.add(hmRecord.get("adj_item_qty"));
				alItemMoveSummRecord.add(hmRecord.get("mm_trn_qty"));
				alItemMoveSummRecord.add(hmRecord.get("item_cost_value"));
			}
			alItemMoveSummRecord.add(alCommonData.get(0));  // modified_by_id
			alItemMoveSummRecord.add(alCommonData.get(1));  // modified_at_ws_no
			alItemMoveSummRecord.add(alCommonData.get(2));  // modified_facility_id
			alItemMoveSummRecord.add(alCommonData.get(2));  // facility_id
			alItemMoveSummRecord.add(hmRecord.get("item_code"));
			alItemMoveSummRecord.add(hmRecord.get("store_code"));
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumAdjUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}

			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		 //stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";

		 stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

	}
}
