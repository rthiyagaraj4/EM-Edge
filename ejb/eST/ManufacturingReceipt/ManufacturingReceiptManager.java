/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.ManufacturingReceipt;

//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
//import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="ManufacturingReceipt"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ManufacturingReceipt"
*	local-jndi-name="ManufacturingReceipt"
*	impl-class-name="eST.ManufacturingReceipt.ManufacturingReceiptManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ManufacturingReceipt.ManufacturingReceiptLocal"
*	remote-class="eST.ManufacturingReceipt.ManufacturingReceiptRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ManufacturingReceipt.ManufacturingReceiptLocalHome"
*	remote-class="eST.ManufacturingReceipt.ManufacturingReceiptHome"
*	generate= "local,remote"
*
*
*/


public class ManufacturingReceiptManager extends StEJBSessionAdapter
{
//	HashMap	hmReturn;
   
   
   /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap delete(HashMap hmData, HashMap hashmap1)
//        throws RemoteException
    {
		Connection connection = null;
		Properties properties=null;
		eST.Common.ManufacturingReceipts	manufacturingReceiptsT	=	new eST.Common.ManufacturingReceipts();

		HashMap hmResult=new HashMap();
		HashMap	hmHeader=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alData		=	(ArrayList)hmData.get("arDelData");

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmHeader.put("facility_id", alData.get(0));  
			hmHeader.put("doc_type_code", alData.get(1));  
			hmHeader.put("doc_no", alData.get(2));  

			hmData.put("DATA",hmHeader);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));

			hmResult=manufacturingReceiptsT.deleteManufacturingReceipts(connection, hmData);
			throwExceptionWhenFailed(hmResult);
            connection.commit();
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
        }
        finally{
            try{
				closeConnection(connection, properties);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        return hmResult;
	}
   
   /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap modify(HashMap hmData, HashMap hashmapQuery)
//        throws RemoteException
    {
       Connection connection = null;
		Properties properties=null;
		eST.Common.ManufacturingReceipts	manufacturingReceiptsT	=	new eST.Common.ManufacturingReceipts();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		HashMap hmHeader		=	new HashMap();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		//System.out.println("alExpRecords==modify===>" +alExpRecords);

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			
			hmHeader.put("expiry_date",alHdrData.get(0));
			hmHeader.put("batch_id",alHdrData.get(1));
			hmHeader.put("bin_location_code",alHdrData.get(2));
			hmHeader.put("trade_id",alHdrData.get(3));
			hmHeader.put("finalized_yn",alHdrData.get(4));
			hmHeader.put("prepare_location_code",alHdrData.get(5));
			hmHeader.put("patient_id",alHdrData.get(6));
			hmHeader.put("encounter_id",alHdrData.get(7));
			hmHeader.put("process_loss_percent",alHdrData.get(8));
			hmHeader.put("item_qty",alHdrData.get(9));
			hmHeader.put("facility_id",alHdrData.get(10));
			hmHeader.put("doc_type_code",alHdrData.get(11));
			hmHeader.put("doc_no",alHdrData.get(12));
			hmHeader.put("mfg_request_no",checkForNull(alHdrData.get(13)));
			hmHeader.put("store_code",alHdrData.get(14));
			hmHeader.put("item_code",alHdrData.get(15));
			hmHeader.put("doc_date",alHdrData.get(16));
			hmHeader.put("doc_ref",alHdrData.get(17));
			hmHeader.put("mfg_item_unit_cost",alHdrData.get(18));
			hmHeader.put("item_qty",alHdrData.get(9));
			if(((String)alHdrData.get(19)).equals("E"))
				hmHeader.put("stock_item_yn","N");
			else
			hmHeader.put("stock_item_yn",getStockYn(connection,(String)alHdrData.get(14),(String)alHdrData.get(15)));
			hmHeader.put("preparation_type",alHdrData.get(19));
			hmHeader.put("prepare_qty",alHdrData.get(20));
			hmHeader.put("uom_code",alHdrData.get(21));

			hmHeader.put("remarks",alHdrData.get(22));
			//hmHeader.put("counter_by",alHdrData.get(23)); 
           //Added by Rabbani #Inc no:49590 on 11-JUN-2014			
			 hmHeader.put("packed_by",alHdrData.get(23));  
			//hmHeader.put("packed_by",alHdrData.get(24));
			hmHeader.put("counter_by",alHdrData.get(24));
			hmHeader.put("barcode_id",checkForNull(alHdrData.get(25)));  //Added by Rabbani #Inc no:32766 on 18/05/12
			hmHeader.put("no_of_labels",checkForNull(alHdrData.get(26))); //18/05/12
			
			System.out.println("hmHeader==modify06 mangr==>" +hmHeader);
			
			


		//	 int j=0;
			for (int i=0; i<alDtlRecords.size(); i++) {
	//			j=i+1;
				double prep_qty=0;
				double prep_val=0.0;
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				HashMap hmDtlTemp	=	new HashMap();
//				hmDtlTemp.put("doc_srl_no", ""+j);
				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("DOC_SRL_NO"));
				hmDtlTemp.put("child_item_code", hmDtlRecord.get("CHILD_ITEM_CODE"));
				
//---------------------modified on 11/1/2005 to avoid multiplication of the component qty with the compositon qty
//				prep_qty=Integer.parseInt((String)hmDtlRecord.get("COMPONENT_QTY"))*Integer.parseInt((String)alHdrData.get(20));
				//prep_qty=Integer.parseInt((String)hmDtlRecord.get("PREP_QTY"));
				prep_qty=Double.parseDouble((String)hmDtlRecord.get("PREP_QTY"));
//---------------------modification end

				prep_val=prep_qty*Double.parseDouble((String)hmDtlRecord.get("UNIT_COST"));
				hmDtlTemp.put("child_item_qty", ""+hmDtlRecord.get("COMPONENT_QTY"));
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("UNIT_COST"));
				hmDtlTemp.put("stock_item_yn", getStockYn(connection,(String)alHdrData.get(14),(String)hmDtlRecord.get("CHILD_ITEM_CODE")));
				hmDtlTemp.put("mfg_uom_code",checkForNull( hmDtlRecord.get("MFG_UOM_CODE")));
				hmDtlTemp.put("child_item_trans_qty",""+prep_qty);
				hmDtlTemp.put("mfg_cost_value", ""+prep_val);
				hmDtlTemp.put("mode",  hmDtlRecord.get("mode"));
				hmDtlTemp.put("uom_code",  hmDtlRecord.get("UOM_CODE"));
		
				alDtlData.add(hmDtlTemp);

			}

				for (int i=0; i<alExpRecords.size(); i++) {
				HashMap hmExpRecord		=	(HashMap)alExpRecords.get(i);
				//ArrayList alExpTemp		=	new ArrayList();
				HashMap hmExpTemp	=	new HashMap();
				hmExpTemp.put("doc_srl_no",  hmExpRecord.get("doc_srl_no"));
				hmExpTemp.put("store_code", alHdrData.get(5));
				hmExpTemp.put("item_code", hmExpRecord.get("ITEM_CODE"));
				hmExpTemp.put("batch_id", hmExpRecord.get("BATCH_ID"));
				hmExpTemp.put("bin_location_code", hmExpRecord.get("BIN_LOCATION_CODE"));
				hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_DATE"));
				hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));
				hmExpTemp.put("item_qty", hmExpRecord.get("QTY"));
				hmExpTemp.put("uom_code",  hmExpRecord.get("UOM_CODE"));
				hmExpTemp.put("unit_cost",hmExpRecord.get("unit_cost"));
				//hmExpTemp.put("barcode_id",hmExpRecord.get("barcode_id"));

				alExpData.add(hmExpTemp);
				System.out.println("alExpData===modify--212->" +alExpData);
			}
		
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);

			hmResult=manufacturingReceiptsT.updateManufacturingReceipts(connection, hmData);
			throwExceptionWhenFailed(hmResult);

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
             hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
			exception.printStackTrace();
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
        return hmResult;
    }
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert(HashMap hmData, HashMap hashmap1) //throws RemoteException
    {
		Connection connection = null;
		Properties properties=null;
		HashMap auto_gen_batch_id = null;
		String sql = "";
		int next_batch_id=0;

		eST.Common.ManufacturingReceipts	manufacturingReceiptsT	=	new eST.Common.ManufacturingReceipts();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		//System.out.println("alHdrData mangr==insert==>" +alHdrData);
		HashMap hmHeader		=	new HashMap();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList languageData		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		//System.out.println("alExpRecords mangr==insert==>" +alExpRecords);

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmHeader.put("facility_id",alHdrData.get(0));
			hmHeader.put("doc_type_code",alHdrData.get(1));
			hmHeader.put("doc_no",alHdrData.get(2));
			hmHeader.put("doc_date",alHdrData.get(3));
			hmHeader.put("doc_ref",alHdrData.get(4));
			hmHeader.put("store_code",alHdrData.get(5));
			hmHeader.put("item_code",alHdrData.get(6));
			hmHeader.put("item_qty",alHdrData.get(7));
			hmHeader.put("expiry_date",alHdrData.get(8));

//		(Start) change made on 19/11/04	by sri 
		//hmHeader.put("batch_id",alHdrData.get(9));
		if(((String)alHdrData.get(31)).equals("N")){

			hmHeader.put("batch_id",alHdrData.get(9));

		}else{
	
			sql=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_RECEIPT_BATCH_GEN");
			auto_gen_batch_id=fetchRecord(connection,sql,(String)alHdrData.get(16));	

			hmHeader.put("batch_id",(String)auto_gen_batch_id.get("BATCH_ID_SERIES")+(String)auto_gen_batch_id.get("NEXT_BATCH_ID"));
			
			next_batch_id = Integer.parseInt((String)auto_gen_batch_id.get("NEXT_BATCH_ID"));
		/*	hmArgData.put(DATA,alUpdateRequest);
				hmArgSQL.put(UPDATE_SQL,SQL_ST_MAN_RECEIPT_STATUS_UPDATE);
				hmResult	=	update(connection, hmArgData, hmArgSQL);*/


		}
//		(end) change made on 19/11/04	by sri 

			hmHeader.put("bin_location_code",alHdrData.get(10));
			hmHeader.put("finalized_yn",alHdrData.get(11));
			hmHeader.put("gl_interfaced_yn",alHdrData.get(12));
			hmHeader.put("trn_type","MFG");
			hmHeader.put("stock_item_yn",alHdrData.get(13));
			hmHeader.put("preparation_type",alHdrData.get(14));
			hmHeader.put("preparation_mode",alHdrData.get(15));
			hmHeader.put("prepare_location_code",alHdrData.get(16));
			hmHeader.put("patient_id",alHdrData.get(17));
			hmHeader.put("encounter_id",alHdrData.get(18));
			hmHeader.put("mfg_item_unit_cost",alHdrData.get(19));
			hmHeader.put("prepare_desc",alHdrData.get(20));
			hmHeader.put("process_loss_percent",alHdrData.get(21));
			hmHeader.put("prepare_qty",alHdrData.get(22));
			hmHeader.put("mfg_request_no",alHdrData.get(23));
			hmHeader.put("trade_id",alHdrData.get(24));
			hmHeader.put("uom_code",alHdrData.get(25));
			hmHeader.put("packed_by",alHdrData.get(28));  
			hmHeader.put("remarks",alHdrData.get(29));  
			hmHeader.put("counter",alHdrData.get(30));
			hmHeader.put("next_batch_id",next_batch_id+"");
			hmHeader.put("barcode_id",checkForNull(alHdrData.get(32)));  //Added by Rabbani #Inc no:32766 on 18/05/12
			hmHeader.put("no_of_labels",checkForNull(alHdrData.get(33))); //18/05/12
			hmHeader.put("dflt_mfg_mode",checkForNull(alHdrData.get(34))); //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 
			
			System.out.println("hmHeader=mangr====>" +hmHeader);
			
				double parentQty = Double.parseDouble((String)alHdrData.get(22));
			  int j=0;
			for (int i=0; i<alDtlRecords.size(); i++) {
				j=i+1;
				//float prep_qty1=0.f;
				double prep_qty=0.0;
				double prep_val=0.0;
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				HashMap hmDtlTemp	=	new HashMap();
				hmDtlTemp.put("doc_srl_no", ""+j);
				hmDtlTemp.put("child_item_code", hmDtlRecord.get("CHILD_ITEM_CODE"));

				//---------------------modified on 1/12/2004 to avoid multiplication of the component qty with the compositon qty
//				prep_qty1=Integer.parseInt((String)hmDtlRecord.get("COMPONENT_QTY"))*Integer.parseInt((String)alHdrData.get(22));
//				prep_qty =java.lang.Math.round(prep_qty1 / Integer.parseInt((String)alHdrData.get(26)));

				prep_qty=Double.parseDouble((String)hmDtlRecord.get("COMPONENT_QTY"));
				prep_qty = prep_qty * parentQty;
//---------------------modification end

				prep_val=(Double.parseDouble((String)hmDtlRecord.get("PREP_QTY")))*Double.parseDouble((String)hmDtlRecord.get("UNIT_COST"));

/*	MODIFYING TO  add correct values into CHILD ITEM QTY AND CHILD ITEM TRANS QTY	on 10/01/2005 sri	
	hmDtlTemp.put("child_item_qty", ""+hmDtlRecord.get("PREP_QTY")); 
				hmDtlTemp.put("child_item_trans_qty",""+prep_qty);*/

				hmDtlTemp.put("child_item_trans_qty", ""+hmDtlRecord.get("PREP_QTY")); 
				hmDtlTemp.put("child_item_qty",""+prep_qty);
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("UNIT_COST"));
				hmDtlTemp.put("stock_item_yn", getStockYn(connection,(String)alHdrData.get(5),(String)hmDtlRecord.get("CHILD_ITEM_CODE")));
				hmDtlTemp.put("mfg_uom_code",checkForNull( hmDtlRecord.get("MFG_UOM_CODE")));
				hmDtlTemp.put("mfg_cost_value", ""+prep_val);
				hmDtlTemp.put("uom_code",  hmDtlRecord.get("UOM_CODE"));

		
				alDtlData.add(hmDtlTemp);
				/*
				facility_id  , doc_type_code , doc_no	, doc_srl_no, child_item_code, child_item_qty  , item_unit_cost	 , stock_item_yn  ,mfg_uom_code	, child_item_trans_qty,mfg_cost_value ,added_by_id	,added_date	, added_at_ws_no, added_facility_id,modified_by_id , modified_date , modified_at_ws_no,modified_facility_id			
				*/
			}
			/*
			INSERT INTO st_mfg_dtl_exp ( FACILITY_ID , DOC_TYPE_CODE , DOC_NO , DOC_SRL_NO , STORE_CODE , ITEM_CODE , BATCH_ID , BIN_LOCATION_CODE , EXPIRY_DATE_OR_RECEIPT_DATE, TRADE_ID  , ITEM_QTY                       ,added_by_id	,added_date	, added_at_ws_no, added_facility_id,modified_by_id , modified_date , modified_at_ws_no,modified_facility_id			  )values (?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,?,?,sysdate,?,?)"	
			*/
			for (int i=0; i<alExpRecords.size(); i++) {
				HashMap hmExpRecord		=	(HashMap)alExpRecords.get(i);
				System.out.println("hmExpRecord===382=mangr==>" +hmExpRecord);
				//ArrayList alExpTemp		=	new ArrayList();
				HashMap hmExpTemp	=	new HashMap();
				hmExpTemp.put("doc_srl_no", hmExpRecord.get("doc_srl_no"));
				hmExpTemp.put("store_code", alHdrData.get(5));
				hmExpTemp.put("item_code", hmExpRecord.get("ITEM_CODE"));
				hmExpTemp.put("batch_id", hmExpRecord.get("BATCH_ID"));
				hmExpTemp.put("bin_location_code", hmExpRecord.get("BIN_LOCATION_CODE"));
				hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_DATE"));
				hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));
				hmExpTemp.put("item_qty", hmExpRecord.get("QTY"));
				hmExpTemp.put("uom_code",  hmExpRecord.get("UOM_CODE"));
				hmExpTemp.put("unit_cost",hmExpRecord.get("unit_cost"));
				//hmExpTemp.put("barcode_id",hmExpRecord.get("barcode_id")); //15/05/12

				
				alExpData.add(hmExpTemp);
				System.out.println("alExpData==401 mangr=" +alExpData);
			}
		languageData=(ArrayList)hmData.get("LANGUAGE_DATA");
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("LANGUAGE_DATA",languageData);

    
			
			hmResult=manufacturingReceiptsT.insertManufacturingReceipts(connection, hmData);
			throwExceptionWhenFailed(hmResult);
            connection.commit();
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
			exception.printStackTrace();
         }
        finally{
            try{
				closeConnection(connection, properties);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        return hmResult;
       // return hashmapResult;
    
    }
	
	

	

	public  String getStockYn  (Connection connection,String store_code,String item_code){
		String [] params={store_code,item_code};
		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(connection,SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN,params);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("STOCK_ITEM_YN");
	} 

	public ManufacturingReceiptManager(){
//		hmReturn =new HashMap();
		SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN");
		//SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN="SELECT STOCK_ITEM_YN FROM st_item_store WHERE STORE_CODE=? AND ITEM_CODE=? 	";
	}

	
	String SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN;
}
