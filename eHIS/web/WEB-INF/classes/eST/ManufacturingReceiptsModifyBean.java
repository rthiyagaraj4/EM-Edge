/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
//import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;

  
public class ManufacturingReceiptsModifyBean extends StHeaderBean implements Serializable { 
	

	
//	private HttpSession session;
	private ArrayList HdrList=new ArrayList() ;
	
	public void setHdrList(ArrayList HdrList) {
		 this.HdrList = HdrList;
	}

	public ArrayList getHdrList( ) {
		 return HdrList;
	}

	

	public void clear(){
			 HdrList.clear();
    }	
	


	/* public HashMap insert()
    {
	    HashMap hashmap = new HashMap();
        HashMap hmDtlScreenData = null;
        HashMap hashmapQry = new HashMap();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylistHdrData = new ArrayList();
        ArrayList arraylistDtlData = new ArrayList();
        ArrayList alDtlListExpRows = new ArrayList();
        ArrayList arraylistDtl= null;
        ArrayList alExpScreenRows= null;
        ArrayList arraylistExp= null;
        ArrayList alDtlListTrnDtl= null;
        ArrayList alDtlListTrnDtlRows= new ArrayList();
		ArrayList alDtlListTrnDtlExp= null;
        ArrayList alDtlListTrnDtlExpRows= new ArrayList();
		ArrayList alDtlListTrnDtlCd= null;
        ArrayList alDtlListTrnDtlCdRows= new ArrayList();
		ArrayList alDtlListTrnDtlExpCd= null;
        ArrayList alDtlListTrnDtlExpRowsCd= new ArrayList();
		ArrayList alDtlListTrnDtlExpBlock= null;
        ArrayList alDtlListTrnDtlExpBlockRows= new ArrayList();
             
		StringTokenizer stringtokenizer = new StringTokenizer(getCheckBoxVals(), ",");
		

	try{
			boolean autoGenerateYN=isDocNoAutoGenYN(getDoc_type_code());
			if(autoGenerateYN)
				doc_no=fetchNextDocNo(getDoc_type_code());
			else
				doc_no=getDoc_no();
			
			HashMap hashmapHdr = (HashMap)DataRecordList.get(Integer.parseInt(getIndex()));
			arraylist.add(getLoginFacilityId());
			arraylist.add(getDoc_type_code());
			arraylist.add(doc_no);
			arraylist.add(getDoc_date());
			arraylist.add(getDoc_ref());
			arraylist.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
			arraylist.add((String)hashmapHdr.get("ITEM_CODE"));
			arraylist.add((String)hashmapHdr.get("REQUEST_QTY"));
			arraylist.add(getExpiry_date());
			arraylist.add(getBatch_id());
			arraylist.add(getBinLocation_code());
			arraylist.add("N");
			arraylist.add("N");
			arraylist.add("MFG");
			if(!((String)hashmapHdr.get("PREPARATION_TYPE")).equals("E"))
				arraylist.add(getStockYn((String)hashmapHdr.get("REQUESTING_STORE_CODE"),(String)hashmapHdr.get("ITEM_CODE")));
			else
				arraylist.add("N");
			
			arraylist.add((String)hashmapHdr.get("PREPARATION_TYPE"));
			arraylist.add((String)hashmapHdr.get("PREPARATION_MODE"));
			arraylist.add((String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
			arraylist.add(checkForNull((String)hashmapHdr.get("PATIENT_ID")));
			arraylist.add(checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
			arraylist.add(checkForNull((String)hashmapHdr.get("UNIT_COST")));
			arraylist.add("");
			arraylist.add(getProcess_loss_percent());
			arraylist.add((String)hashmapHdr.get("REQUEST_QTY"));
			arraylist.add(getLoginById());
			arraylist.add(getLoginAtWsNo());
			arraylist.add(getLoginFacilityId());
			arraylist.add(getLoginById());
			arraylist.add(getLoginAtWsNo());
			arraylist.add(getLoginFacilityId());
			arraylist.add((String)hashmapHdr.get("MFG_REQUEST_NO"));
			arraylistHdrData.add(arraylist);

			
			int srl_no=1;
			for(int i = 0; i < DataDtlList.size(); i++)
			{
				int j=i+1;
				int prep_qty=0;
				float prep_val=0.0f;
				HashMap hashmapDtl = (HashMap)DataDtlList.get(i);
				 if(stringtokenizer.nextToken().equals("N")){
				
					arraylistDtl = new ArrayList();
					arraylistDtl.add(getLoginFacilityId());
					arraylistDtl.add(getDoc_type_code());
					arraylistDtl.add(doc_no);
					arraylistDtl.add(""+j);
					arraylistDtl.add((String)hashmapDtl.get("CHILD_ITEM_CODE"));
					//prep_qty=Integer.parseInt((String)hashmapDtl.get("COMPONENT_QTY"))*Integer.parseInt((String)hashmapHdr.get("REQUEST_QTY"));
					prep_qty=Integer.parseInt((String)hashmapDtl.get("COMPONENT_QTY"))*Integer.parseInt(getComposition_for_qty());
					prep_val=prep_qty*Float.parseFloat((String)hashmapDtl.get("UNIT_COST"));
					arraylistDtl.add(""+prep_qty);
					arraylistDtl.add((String)hashmapDtl.get("UNIT_COST"));
					arraylistDtl.add("Y");
					arraylistDtl.add((String)hashmapDtl.get("MFG_UOM_CODE"));
			
					int trans_qty=Integer.parseInt((String)hashmapHdr.get("REQUEST_QTY"))*Integer.parseInt((String)hashmapDtl.get("COMPONENT_QTY"));
					arraylistDtl.add(""+trans_qty);
			
					double mfg_value=trans_qty*Double.parseDouble((String)hashmapDtl.get("UNIT_COST"));
					arraylistDtl.add(""+mfg_value);
					arraylistDtl.add(getLoginById());
					arraylistDtl.add(getLoginAtWsNo());
					arraylistDtl.add(getLoginFacilityId());
					arraylistDtl.add(getLoginById());
					arraylistDtl.add(getLoginAtWsNo());
					arraylistDtl.add(getLoginFacilityId());
					arraylistDtlData.add(arraylistDtl);

					alDtlListTrnDtl=new ArrayList();
					alDtlListTrnDtl.add(getLoginFacilityId() );
					alDtlListTrnDtl.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
					alDtlListTrnDtl.add((String)hashmapDtl.get("CHILD_ITEM_CODE"));
					alDtlListTrnDtl.add(""+srl_no);
					alDtlListTrnDtl.add(getTrn_type());
					alDtlListTrnDtl.add(getDoc_type_code());
					alDtlListTrnDtl.add(doc_no);
					alDtlListTrnDtl.add(""+j);
					alDtlListTrnDtl.add(getDoc_date());
					alDtlListTrnDtl.add(getDoc_ref());
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add(""+prep_qty);
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add((String)hashmapDtl.get("UNIT_COST"));
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add((String)hashmapDtl.get("MFG_UOM_CODE"));
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("Y");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add(getLoginById());
					alDtlListTrnDtl.add(getLoginAtWsNo() );
					alDtlListTrnDtl.add(getLoginFacilityId() );
					alDtlListTrnDtl.add(getLoginById());
					alDtlListTrnDtl.add(getLoginAtWsNo() );
					alDtlListTrnDtl.add(getLoginFacilityId() );
					alDtlListTrnDtl.add("");
					alDtlListTrnDtl.add("");
					alDtlListTrnDtlRows.add(alDtlListTrnDtl);
					

					hashmapQry.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
					hashmapQry.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
					hashmapQry.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
					hashmapQry.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
					
					if(getFinalized_yn().equals("Y")){
						if(!((String)hashmapHdr.get("PREPARATION_TYPE")).equals("E")){
							alDtlListTrnDtlCd = new ArrayList();
							alDtlListTrnDtlCd.add(hashmapDtl.get("CHILD_ITEM_CODE"));
							alDtlListTrnDtlCd.add(hashmapHdr.get("REQUESTING_STORE_CODE"));
							alDtlListTrnDtlCd.add(getDoc_type_code());
							alDtlListTrnDtlCd.add(""+prep_qty);
							alDtlListTrnDtlCd.add(hashmapDtl.get("UNIT_COST"));
							alDtlListTrnDtlCd.add(""+prep_val);
							alDtlListTrnDtlCd.add(getStockYn((String)hashmapHdr.get("REQUESTING_STORE_CODE"),(String)hashmapDtl.get("CHILD_ITEM_CODE")));//from_stk_item_yn
							alDtlListTrnDtlCd.add(getDoc_date());
							alDtlListTrnDtlCd.add(getLoginById());
							alDtlListTrnDtlCd.add(getLoginAtWsNo() );
							alDtlListTrnDtlCd.add(getLoginFacilityId() );
							//alDtlListTrnDtlCd.add(getStockYn((String)hashmapHdr.get("REQUESTING_STORE_CODE"),(String)hashmapDtl.get("CHILD_ITEM_CODE")));
							alDtlListTrnDtlCdRows.add(alDtlListTrnDtlCd);
						}

					}
					
		
					alExpScreenRows=new ArrayList();
					alExpScreenRows=getDtlExpList(i);
					for (int k=0;k<alExpScreenRows.size();k++) {	
						srl_no++;
						hmDtlScreenData=new HashMap();
						hmDtlScreenData =(HashMap)alExpScreenRows.get(k);
						arraylistExp =new ArrayList();
						arraylistExp.add(getLoginFacilityId());
						arraylistExp.add(getDoc_type_code());
						arraylistExp.add(doc_no);
						arraylistExp.add(""+j);
						arraylistExp.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
						arraylistExp.add((String)hashmapDtl.get("CHILD_ITEM_CODE"));
						arraylistExp.add((String)hmDtlScreenData.get("BATCH_ID"));
						arraylistExp.add((String)hmDtlScreenData.get("BIN_LOCATION_CODE"));
						arraylistExp.add((String)hmDtlScreenData.get("EXPIRY_DATE"));
						arraylistExp.add((String)hmDtlScreenData.get("TRADE_ID"));
						arraylistExp.add((String)hmDtlScreenData.get("QTY"));
						arraylistExp.add(getLoginById());
						arraylistExp.add(getLoginAtWsNo() );
						arraylistExp.add(getLoginFacilityId() );
						arraylistExp.add(getLoginById());
						arraylistExp.add(getLoginAtWsNo() );
						arraylistExp.add(getLoginFacilityId() );
						alDtlListExpRows.add(arraylistExp);

						alDtlListTrnDtlExp=new ArrayList();
						alDtlListTrnDtlExp.add(getLoginFacilityId() );
						alDtlListTrnDtlExp.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
						alDtlListTrnDtlExp.add((String)hashmapDtl.get("CHILD_ITEM_CODE"));
						alDtlListTrnDtlExp.add(""+srl_no);
						alDtlListTrnDtlExp.add(getTrn_type());
						alDtlListTrnDtlExp.add(getDoc_type_code());
						alDtlListTrnDtlExp.add(doc_no);
						alDtlListTrnDtlExp.add(""+j);
						alDtlListTrnDtlExp.add(getDoc_date());
						alDtlListTrnDtlExp.add(getDoc_ref());
						alDtlListTrnDtlExp.add((String)hmDtlScreenData.get("BATCH_ID"));
						alDtlListTrnDtlExp.add((String)hmDtlScreenData.get("EXPIRY_DATE"));
						alDtlListTrnDtlExp.add("-"+(String)hmDtlScreenData.get("QTY"));
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add((String)hashmapDtl.get("UNIT_COST"));
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add((String)hashmapDtl.get("MFG_UOM_CODE"));
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("Y");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add("");
						alDtlListTrnDtlExp.add(getLoginById());
						alDtlListTrnDtlExp.add(getLoginAtWsNo() );
						alDtlListTrnDtlExp.add(getLoginFacilityId() );
						alDtlListTrnDtlExp.add(getLoginById());
						alDtlListTrnDtlExp.add(getLoginAtWsNo() );
						alDtlListTrnDtlExp.add(getLoginFacilityId() );
						alDtlListTrnDtlExp.add((String)hmDtlScreenData.get("BIN_LOCATION_CODE"));
						alDtlListTrnDtlExp.add((String)hmDtlScreenData.get("TRADE_ID"));
						alDtlListTrnDtlExpRows.add(alDtlListTrnDtlExp);

						hashmapQry.put("BatchExistsCheckSQL",getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
						hashmapQry.put("BatchControlInsertSQL",getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
						hashmapQry.put("ItemBatchExistsCheckSQL",getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
						hashmapQry.put("ItemBatchInsertSQL",getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
						hashmapQry.put("ItemBatchStcPosSelectSQL",getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
						hashmapQry.put("ItemBatchDeleteSQL",getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
						hashmapQry.put("ItemBatchUpdateSQL",getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
						
						if(getFinalized_yn().equals("Y")){
							alDtlListTrnDtlExpCd= new ArrayList();
							alDtlListTrnDtlExpCd.add((String)hashmapDtl.get("CHILD_ITEM_CODE"));
							alDtlListTrnDtlExpCd.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
							alDtlListTrnDtlExpCd.add(getDoc_type_code());
							alDtlListTrnDtlExpCd.add("-"+(String)hmDtlScreenData.get("QTY"));
							alDtlListTrnDtlExpCd.add((String)hmDtlScreenData.get("BATCH_ID"));
							alDtlListTrnDtlExpCd.add((String)hmDtlScreenData.get("EXPIRY_DATE"));
							alDtlListTrnDtlExpCd.add((String)hmDtlScreenData.get("TRADE_ID"));
							alDtlListTrnDtlExpCd.add((String)hmDtlScreenData.get("BIN_LOCATION_CODE"));
							alDtlListTrnDtlExpCd.add("Y");//suspended_batch_allowed_yn
							alDtlListTrnDtlExpCd.add("N");//release_batch_yn
							alDtlListTrnDtlExpCd.add(getDoc_date()); // doc_date
							alDtlListTrnDtlExpCd.add(getLoginById());
							alDtlListTrnDtlExpCd.add(getLoginAtWsNo() );
							alDtlListTrnDtlExpCd.add(getLoginFacilityId() );
							alDtlListTrnDtlExpRowsCd.add(alDtlListTrnDtlExpCd);
						}
						else{
							alDtlListTrnDtlExpBlock= new ArrayList();
							alDtlListTrnDtlExpBlock.add(hashmapHdr.get("REQUESTING_STORE_CODE"));
							alDtlListTrnDtlExpBlock.add(hashmapDtl.get("CHILD_ITEM_CODE"));
							alDtlListTrnDtlExpBlock.add((String)hmDtlScreenData.get("BATCH_ID"));
							alDtlListTrnDtlExpBlock.add((String)hmDtlScreenData.get("BIN_LOCATION_CODE"));
							alDtlListTrnDtlExpBlock.add((String)hmDtlScreenData.get("EXPIRY_DATE"));
							alDtlListTrnDtlExpBlock.add((String)hmDtlScreenData.get("QTY"));
							alDtlListTrnDtlExpBlock.add(getLoginById());
							alDtlListTrnDtlExpBlock.add(getLoginAtWsNo() );
							alDtlListTrnDtlExpBlock.add(getLoginFacilityId() );
							alDtlListTrnDtlExpBlockRows.add(alDtlListTrnDtlExpBlock);
						}
					}
				 }
			 }

			ArrayList alCommon	=	new ArrayList();
			alCommon.add(getLoginById());
			alCommon.add(getLoginAtWsNo() );
			alCommon.add(getLoginFacilityId() );
			alCommon.add(getDoc_type_code());

			hashmapQry.put("hdrInsertSQL", getStRepositoryValue("SQL_ST_MAN_RECEIPT_HDR_INSERT"));
			hashmapQry.put("dtlInsertSQL", getStRepositoryValue("SQL_ST_MAN_RECEIPT_DTL_INSERT"));
			hashmapQry.put("expInsertSQL", getStRepositoryValue("SQL_ST_MAN_RECEIPT_EXP_INSERT"));
			hashmapQry.put("ItemTrnDtlInsert", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_COM_INSERT"));
			hashmapQry.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hashmapQry.put("SQLBatchBlockRelease",  eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_FOR_SAL"));
			hashmapQry.put("updateReqHdrSQL", getStRepositoryValue("SQL_ST_MAN_RECEIPT_STATUS_UPDATE"));

			hashmap.put("properties", getProperties());
			hashmap.put("HdrInsertData", arraylistHdrData);
			hashmap.put("DtlInsertData", arraylistDtlData);
			hashmap.put("ExpInsertData", alDtlListExpRows);
			hashmap.put("TrnDtlData",	alDtlListTrnDtlRows);
			hashmap.put("TrnDtlExpData",	alDtlListTrnDtlExpRows);
			if(!((String)hashmapHdr.get("PREPARATION_TYPE")).equals("E")){
			hashmap.put("CommonRoutineDataDtl",	alDtlListTrnDtlCdRows);
			}

			hashmap.put("CommonRoutineDataDtlExp",	alDtlListTrnDtlExpRowsCd);
			hashmap.put("BlockDataDtlExp",	alDtlListTrnDtlExpBlockRows);
			hashmap.put("CommonData",	alCommon);
			hashmap.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
			hashmap.put("PREPARATION_TYPE", (String)hashmapHdr.get("PREPARATION_TYPE"));
			hashmap.put("finalized_yn", getFinalized_yn());

			ArrayList arrlistHdrU=new ArrayList();
			arrlistHdrU.add((String)hashmapHdr.get("MFG_REQUEST_NO"));
			hashmap.put("updateReqHdr",arrlistHdrU);
			
	}
	catch (Exception e){}
        return methodCall(hashmap, hashmapQry, 1);
		//return hashmap;
    }
*/
    public HashMap methodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
		
		/*if(mode==2)
		 hashmapResult = new eST.ManufacturingRequest2.AssemblyDetailManager().modify(hashmap, hashmapQuery);
		else
		 hashmapResult = new eST.ManufacturingReceiptT.ManufacturingReceiptManager().insert(hashmap, hashmapQuery);
			*/
       /* try



        {
             ManufacturingReceiptHome manufacturingReceipthome = null;
            ManufacturingReceiptRemote manufacturingReceiptremote = null;
            InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_ST_MANUFACTURING_REQUEST"));
            manufacturingReceipthome = (ManufacturingReceiptHome)PortableRemoteObject.narrow(obj, manufacturingReceiptHome.class);
            manufacturingReceiptremote = manufacturingReceipthome.create();
			if(mode==2)
            hashmapResult = manufacturingReceiptremote.modify(hashmap, hashmapQuery);
			else
			 hashmapResult = manufacturingReceiptremote.insert(hashmap, hashmapQuery);
        }
        catch(Exception exception) { }
        if(((Boolean)hashmap2.get("result")).booleanValue())
            hashmapResult.put("message", replaceNewLineChar(getMessage((String)hashmapResult.get("msgid"))));
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", replaceNewLineChar(getMessage((String)hashmapResult.get("msgid"))));
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));*/
        return hashmapResult;
    }


	public ArrayList getHdrData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_HDR_QUERY");
				listRecord = fetchRecords(stSQL.toString());
				HdrList=listRecord;
				return listRecord;
		} catch ( Exception e )	{
								e.printStackTrace() ;
				throw e ;
		} 
	}

	/*public void getAssemblyTempDtlData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		String [] alParameters;
		String stSQL;
		if(getReq_type().equals("E")){
			alParameters=new String[1] ;
			alParameters[0]=getItem_code();
			stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_ASSMBL_TEMP_DTL_RESULT");
		}
		else{
			alParameters=new String[2] ;
			alParameters[0]=getItem_code();
			alParameters[1]=getReq_store();
			stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_ASSMBL_DTL_RESULT");
		}
		try {
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				DataDtlList=listRecord;
		} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
		} 
	}
*/

}
