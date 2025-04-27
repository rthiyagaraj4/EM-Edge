/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common;

//import java.rmi.RemoteException;
//import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
//import java.util.Properties;
import java.util.HashMap;

public class  ManufacturingRequest extends StEJBSessionAdapter {
	
	public HashMap insertManufacturingRequest(Connection connection, HashMap hmData){
		HashMap hmArgData = new HashMap();
        HashMap hmArgSQL = new HashMap();
        HashMap hashmapResult = new HashMap();
     
		ArrayList alHdrRecordRows=new ArrayList();
		ArrayList alHdrUpdateRecordRows=new ArrayList();
		
		//Added By Sakti Sankar against Inc#34852
		ArrayList	languageData	=	new ArrayList();
		ArrayList doc_no	=	new ArrayList();
		//Added ends
		
		this.mfg_request_no=Integer.parseInt(getExtempItem(connection));
		try {
			  HashMap hmCommon			=	(HashMap)	hmData.get("CommonData");
			  ArrayList arraylistHdrData = (ArrayList)hmData.get("HdrInsertData");
			  ArrayList arraylistDtlData = (ArrayList)hmData.get("DtlInsertData");
			  ArrayList alDtlData	=	new ArrayList();
              if(arraylistHdrData.size()>0 ){
				  
				for (int i=0;i< arraylistHdrData.size();i++ )
				{
					mfg_request_no++;
					HashMap hashmapHdr = (HashMap)arraylistHdrData.get(i);
					ArrayList alHdrRecord=new ArrayList();
					alHdrRecord.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
					alHdrRecord.add((String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
					alHdrRecord.add((String)hashmapHdr.get("PREPARATION_TYPE"));
					alHdrRecord.add((String)hashmapHdr.get("PREPARATION_MODE"));
					alHdrRecord.add((String)hashmapHdr.get("ITEM_CODE"));
					alHdrRecord.add((String)hashmapHdr.get("REQUEST_QTY"));
					alHdrRecord.add(checkForNull((String)hashmapHdr.get("PATIENT_ID")));
					alHdrRecord.add(checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
					//alHdrRecord.add("mfg_request_no",(String)hashmapHdr.get("MFG_REQUEST_NO"));
					alHdrRecord.add(""+mfg_request_no);
					alHdrRecord.add(checkForNull((String)hashmapHdr.get("REMARKS")));
					alHdrRecord.add(hmCommon.get("login_by_id"));
					alHdrRecord.add(hmCommon.get("login_at_ws_no"));
					alHdrRecord.add(hmCommon.get("login_facility_id"));
					alHdrRecord.add(hmCommon.get("login_by_id"));
					alHdrRecord.add(hmCommon.get("login_at_ws_no"));
					alHdrRecord.add(hmCommon.get("login_facility_id"));
					alHdrRecordRows.add(alHdrRecord);
				
					 if(arraylistDtlData.size()>0){
						
							String index=(String)hashmapHdr.get("index");
							for (int k=0;k<arraylistDtlData.size();k++){
								if(index.equals((String)(((HashMap)arraylistDtlData.get(k)).get("index")))){
									ArrayList ALExp	=	new ArrayList();
									HashMap hashmapDtl=(HashMap)arraylistDtlData.get(k);
									ALExp.add(hashmapDtl);
									for (int s=0;s<ALExp.size();s++){
										HashMap hashmap=(HashMap)ALExp.get(s);
										ArrayList ALExpData	=	new ArrayList();
										ALExpData.add(""+""+mfg_request_no);
										ALExpData.add((String)hashmap.get("CHILD_ITEM_CODE"));
										ALExpData.add((String)hashmap.get("COMPONENT_QTY"));
										ALExpData.add((String)hashmap.get("MFG_UOM_CODE"));
										ALExpData.add(hmCommon.get("login_by_id"));
										ALExpData.add(hmCommon.get("login_at_ws_no"));
										ALExpData.add(hmCommon.get("login_facility_id"));
										ALExpData.add(hmCommon.get("login_by_id"));
										ALExpData.add(hmCommon.get("login_at_ws_no"));
										ALExpData.add(hmCommon.get("login_facility_id"));
										alDtlData.add(ALExpData);
									}
								}
							}
						}
					doc_no.add(mfg_request_no);//Added By Sakti Sankar against Inc#34852
				}

				hmArgData.put("DATA",alHdrRecordRows);
				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_HDR_INSERT);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);
						
				hmArgData.put("DATA",alDtlData);
				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_DTL_INSERT);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);
			}
			else{
					if(arraylistDtlData.size()>0){
						for (int i=0;i< arraylistDtlData.size();i++ )				{
							HashMap hashmap = (HashMap)arraylistDtlData.get(i);
							ArrayList ALExpData	=	new ArrayList();
							ALExpData.add((String)hashmap.get("MFG_REQUEST_NO"));
							ALExpData.add((String)hashmap.get("CHILD_ITEM_CODE"));
							ALExpData.add((String)hashmap.get("COMPONENT_QTY"));
							ALExpData.add((String)hashmap.get("MFG_UOM_CODE"));
							ALExpData.add(hmCommon.get("login_by_id"));
							ALExpData.add(hmCommon.get("login_at_ws_no"));
							ALExpData.add(hmCommon.get("login_facility_id"));
							ALExpData.add(hmCommon.get("login_by_id"));
							ALExpData.add(hmCommon.get("login_at_ws_no"));
							ALExpData.add(hmCommon.get("login_facility_id"));
							alDtlData.add(ALExpData);
						}
						hmArgData.put("DATA",alDtlData);
						hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_DTL_INSERT);
						hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hashmapResult);
					}
			}

			ArrayList arrHDrUpdData = (ArrayList)hmData.get("HdrUpdateData");
			if(arrHDrUpdData.size()>0){
				for (int i=0;i< arrHDrUpdData.size();i++ )				{
				HashMap hashmapHdr = (HashMap)arrHDrUpdData.get(i);
						ArrayList alHdrUpdateRecord=new ArrayList();
						alHdrUpdateRecord.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
						alHdrUpdateRecord.add((String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
						alHdrUpdateRecord.add((String)hashmapHdr.get("PREPARATION_TYPE"));
						alHdrUpdateRecord.add((String)hashmapHdr.get("PREPARATION_MODE"));
						alHdrUpdateRecord.add((String)hashmapHdr.get("REQUEST_QTY"));
						alHdrUpdateRecord.add(checkForNull((String)hashmapHdr.get("PATIENT_ID")));
						alHdrUpdateRecord.add(checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
						alHdrUpdateRecord.add(hmCommon.get("login_by_id"));
						alHdrUpdateRecord.add(hmCommon.get("login_at_ws_no"));
						alHdrUpdateRecord.add(hmCommon.get("login_facility_id"));
						alHdrUpdateRecord.add(checkForNull((String)hashmapHdr.get("REMARKS")));
						alHdrUpdateRecord.add((String)hashmapHdr.get("MFG_REQUEST_NO"));
						alHdrUpdateRecordRows.add(alHdrUpdateRecord);
				}

				hmArgData.put("DATA",alHdrUpdateRecordRows);
				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_HDR_UPDATE);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);
			}

			ArrayList arraylistDtlUpdateData=new ArrayList();
			ArrayList arrDtlUpdData = (ArrayList)hmData.get("DtlUpdateData");
			if(arrDtlUpdData.size()>0){
				for (int i=0;i< arrDtlUpdData.size();i++ )				{
					HashMap hashmap = (HashMap)arrDtlUpdData.get(i);
					ArrayList alDtlUpdateRecord=new ArrayList();
					alDtlUpdateRecord.add((String)hashmap.get("COMPONENT_QTY"));
					alDtlUpdateRecord.add((String)hashmap.get("MFG_UOM_CODE"));
					alDtlUpdateRecord.add(hmCommon.get("login_by_id"));
					alDtlUpdateRecord.add(hmCommon.get("login_at_ws_no"));
					alDtlUpdateRecord.add(hmCommon.get("login_facility_id"));
					alDtlUpdateRecord.add((String)hashmap.get("MFG_REQUEST_NO"));
					alDtlUpdateRecord.add((String)hashmap.get("child_item_code"));
					arraylistDtlUpdateData.add(alDtlUpdateRecord);
				}
				hmArgData.put("DATA",arraylistDtlUpdateData);
				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_DTL_UPDATE);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);
			}


			ArrayList arraylistDtlDelete=new ArrayList();
			ArrayList arrDtlDeletedata = (ArrayList)hmData.get("DtlDeleteData");
				if(arrDtlDeletedata.size()>0){
					for (int i=0;i< arrDtlDeletedata.size();i++ )				{
						HashMap hashmapDtl = (HashMap)arrDtlDeletedata.get(i);
						ArrayList alDtlDeleteRecord=new ArrayList();
						alDtlDeleteRecord.add((String)hashmapDtl.get("MFG_REQUEST_NO"));
						alDtlDeleteRecord.add((String)hashmapDtl.get("CHILD_ITEM_CODE"));
						arraylistDtlDelete.add(alDtlDeleteRecord);	
					}
				hmArgData.put("DATA",arraylistDtlDelete);
				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_DTL_DELETE);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);
			}

			ArrayList arrHdrDtlDeletedata = (ArrayList)hmData.get("HdrDtlDeleteData");	
			ArrayList arrHdrDtlDelete = new ArrayList();

		
					
			
			if(arrHdrDtlDeletedata.size()>0){
				for (int i=0;i< arrHdrDtlDeletedata.size();i++ )				{
						HashMap hashmapDtl = (HashMap)arrHdrDtlDeletedata.get(i);
						ArrayList alHDRDtlDeleteRecord=new ArrayList();
						alHDRDtlDeleteRecord.add((String)hashmapDtl.get("mfg_request_no"));
						arrHdrDtlDelete.add(alHDRDtlDeleteRecord);
				}
				hmArgData.put("DATA",arrHdrDtlDelete);
				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_DTL_ALL_DELETE);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);

				hmArgSQL.put(BATCH_SQL,SQL_ST_MAN_REQ_HDR_ALL_DELETE);
				hashmapResult =  operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hashmapResult);
			}

			//Added By Sakti Sankar against Inc#34852 on 19/09/2012
			
			String s  = ""; 
			String s1 = "";
			languageData		=	(ArrayList)	hmData.get("LANGUAGE_DATA");
			
			if(doc_no.size()>1){
				System.out.println("doc_no"+doc_no);
				System.out.println("doc_no size"+doc_no.size());

				
				String locale=(String)languageData.get(0);
				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
				s = getSTMessage((String)languageData.get(0), "DOC_NOS_GEN_FROM", "ST") ;
				
				s1=s+"  "+doc_no.get(0)+" "+common_labels.getString("Common.to.label")+" "+doc_no.get(doc_no.size()-1);
			//}else{ changed for ML-BRU-SCF-1632
			}
			else if(doc_no.size()==1){
				s = getSTMessage((String)languageData.get(0), "DOC_NO", "ST") ;
				s1=s+":  "+doc_no.get(0);
			}
		
			hashmapResult.put("flag",s1);
			//Added ends


		}
		catch (Exception exception) {
			hashmapResult.put(RESULT,FALSE);
			hashmapResult.put(MESSAGE,exception.toString());
			hashmapResult.put(MSGID,exception.getMessage());

			exception.printStackTrace();
		}

		return hashmapResult;
	}

	public String getExtempItem (Connection connection) //throws Exception
		{ 
		String req_extemp_item_seq ;
		try {
				String stSQL=SQL_ST_MAN_REQ_MFG_REQUEST_NO;
				req_extemp_item_seq = fetchRecord(connection,stSQL.toString()).get("ITEM_SEQ").toString();
				return req_extemp_item_seq;
			} catch ( Exception e )	{
				e.printStackTrace() ;
			} 
			return null;
	}

	public ManufacturingRequest(){
		
		SQL_ST_MAN_REQ_HDR_INSERT=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_HDR_INSERT");
		SQL_ST_MAN_REQ_DTL_INSERT=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_DTL_INSERT");
		SQL_ST_MAN_REQ_HDR_UPDATE=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_HDR_UPDATE");
		SQL_ST_MAN_REQ_DTL_UPDATE=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_DTL_UPDATE");
		SQL_ST_MAN_REQ_DTL_DELETE=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_DTL_DELETE");
		SQL_ST_MAN_REQ_DTL_ALL_DELETE=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_DTL_ALL_DELETE");
		SQL_ST_MAN_REQ_HDR_ALL_DELETE=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_HDR_ALL_DELETE");
		SQL_ST_MAN_REQ_MFG_REQUEST_NO=eST.Common.StEJBRepository.getStKeyValue("SQL_ST_MAN_REQ_MFG_REQUEST_NO");
	}
	
	String SQL_ST_MAN_REQ_HDR_INSERT ;
    String SQL_ST_MAN_REQ_DTL_INSERT ;
	String SQL_ST_MAN_REQ_HDR_UPDATE ;
    String SQL_ST_MAN_REQ_DTL_UPDATE;
    String SQL_ST_MAN_REQ_DTL_DELETE;
	String SQL_ST_MAN_REQ_DTL_ALL_DELETE;
	String SQL_ST_MAN_REQ_HDR_ALL_DELETE;
	String SQL_ST_MAN_REQ_MFG_REQUEST_NO;
	int mfg_request_no ;
}
