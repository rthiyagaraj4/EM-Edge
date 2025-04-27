/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.LoanAcknowledgement;
import eSS.Common.SsEJBSessionAdapter;
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
*	name="LoanAcknowledgement"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="LoanAcknowledgement"
*	local-jndi-name="LoanAcknowledgement"
*	impl-class-name="eSS.LoanAcknowledgement.LoanAcknowledgementManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.LoanAcknowledgement.LoanAcknowledgementLocal"
*	remote-class="eSS.LoanAcknowledgement.LoanAcknowledgementRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.LoanAcknowledgement.LoanAcknowledgementLocalHome"
*	remote-class="eSS.LoanAcknowledgement.LoanAcknowledgementHome"
*	generate= "local,remote"
*
*
*/

public class LoanAcknowledgementManager extends SsEJBSessionAdapter{
	
	
	HashMap hmSQL;
	HashMap hmReturn;
	HashMap hmData;
	String stSQL;
	Connection connection = null;
	Properties properties = null;
	String adj_doc_type_code = "";
					
    public LoanAcknowledgementManager(){}
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
		//ArrayList alAdjHdrData	= new ArrayList(); // Comented by Sakti as this is unused against inc#48061 
		//ArrayList alAdjDtlData	= new ArrayList();
		//ArrayList alAdjExpData	= new ArrayList();
		ArrayList alDtlRecords	= (ArrayList)hmData.get("DTL_DATA");
		ArrayList alCommonData	= (ArrayList)hmData.get("COMMON_DATA");
		//ArrayList allanguageData= (ArrayList)hmData.get("LANGUAGE_DATA");
		
		hmSQL = hmSQL1;
		hashmapResult.put("result", FALSE);
        try
        {
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
            ArrayList arraylistHdrData = (ArrayList)hmData.get("ACK_HDR_DATA");
			ArrayList arraylistDtlData = (ArrayList)hmData.get("ACK_DTL_DATA");
			ArrayList alModHdrData = (ArrayList)hmData.get("ACK_HDR_MOD_DATA");
			//ArrayList alModDtlData = (ArrayList)hmData.get("ACK_DTL_MOD_DATA"); // Comented by Sakti as this is unused against inc#48061
			ArrayList alModTrayDtlData = (ArrayList)hmData.get("ACK_TRAY_DTL_MOD_DATA");
			ArrayList alPendAckData = (ArrayList)hmData.get("GROUP_FOR_STORE_UPDATE_ACK");
			
	

			if(alDtlRecords.size()>0){
				 if(((String)alCommonData.get(4)).equals("ISL"))
						hashmapResult = updateIssueGroup(hmData,hmSQL);
				else if(((String)alCommonData.get(4)).equals("RTL"))
						hashmapResult = updateReturnGroup(hmData,hmSQL);
						throwExceptionWhenFailed(hashmapResult);
				}
						
			if(arraylistHdrData.size()>0){
				String HdrQuery = (String)hmSQL.get("SS_SQL_SS_LOAN_ACKNOWLEDGE_TRN_HDR_INSERT");
				hashmapHDrdata.put("DATA",arraylistHdrData);
				hashmapHDrquery.put("BATCH_SQL",HdrQuery);
				hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(arraylistDtlData.size()>0){
				String DtlQuery = (String)hmSQL.get("SS_SQL_SS_LOAN_ACKNOWLEDGE_TRN_DTL_INSERT");
				hashmapDtldata.put("DATA",arraylistDtlData);
				hashmapDtlquery.put("BATCH_SQL",DtlQuery);
				hashmapResult =  operateBatch(connection, hashmapDtldata, hashmapDtlquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(alModHdrData.size()>0){
				String ModHdrQuery = (String)hmSQL.get("SS_SQL_SS_LOAN_ACKNOWLEDGE_TRN_HDR_UPDATE");
				hmModHdrData.put("DATA",alModHdrData);
				hmModHdrQuery.put("BATCH_SQL",ModHdrQuery);
				hashmapResult =  operateBatch(connection, hmModHdrData, hmModHdrQuery);
				throwExceptionWhenFailed(hashmapResult);
			}
			/*if(alModDtlData.size()>0){
				String ModDtlQuery = (String)hmSQL.get("SS_SQL_SS_ACKNOWLEDGE_TRN_DTL_UPDATE");
				hmModDtlData.put("DATA",alModDtlData);
				hmModDtlQuery.put("BATCH_SQL",ModDtlQuery);
				//System.out.println("hmModDtlData..4.."+hmModDtlData);
				//System.out.println("hmModDtlQuery..4.."+hmModDtlQuery);
				hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
				throwExceptionWhenFailed(hashmapResult);
			}*/
				if(((String)alCommonData.get(4)).equals("ISL")) {
					if(((String)alCommonData.get(6)).equals("A")) {
						if(alModTrayDtlData.size()>0){
						String ModTrayDtlQuery = (String)hmSQL.get("SQL_SS_TRAY_DTL_UPDATE_FROM_LOAN_ACKNOWLEDGE");
						hmModDtlData.put("DATA",alModTrayDtlData);
						hmModDtlQuery.put("BATCH_SQL",ModTrayDtlQuery);
						hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
						throwExceptionWhenFailed(hashmapResult);
						}
					}else if(((String)alCommonData.get(6)).equals("C")) {
						if(alModTrayDtlData.size()>0){
						String ModTrayDtlQuery = (String)hmSQL.get("SQL_SS_TRAY_DTL_UPDATE_FROM_LOAN_CONFIRM");
						hmModDtlData.put("DATA",alModTrayDtlData);
						hmModDtlQuery.put("BATCH_SQL",ModTrayDtlQuery);
						hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
						throwExceptionWhenFailed(hashmapResult);
						}
					}
					if(alPendAckData.size()>0){
						String ModGroupStoreUpdate = (String)hmSQL.get("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK_REDUCE");
						hmModDtlData.put("DATA",alPendAckData);
						hmModDtlQuery.put("BATCH_SQL",ModGroupStoreUpdate);
						hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
						throwExceptionWhenFailed(hashmapResult);
					}
				}else if(((String)alCommonData.get(4)).equals("RTL")) {
						if(alModTrayDtlData.size()>0){
						String ModTrayDtlQuery = (String)hmSQL.get("SQL_SS_TRAY_DTL_UPDATE_FROM_LOAN_CONFIRM");
						hmModDtlData.put("DATA",alModTrayDtlData);
						hmModDtlQuery.put("BATCH_SQL",ModTrayDtlQuery);
						hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
						throwExceptionWhenFailed(hashmapResult);
						}
				}

            connection.commit();
            
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
			
			String message = (String)hashmapResult.get("message");
			//String msgid = (String)hashmapResult.get("msgid");

			if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			{
				hashmapResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
				hashmapResult.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
			}
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



	
/*Code Starts for Issue*/
	public HashMap updateIssueGroup(HashMap hmData, HashMap hmSQLValues){
		//PreparedStatement preparedStatement	=	null;
		//ResultSet resultSet =	null;
		HashMap hmResult	=	new HashMap();
		HashMap hmArgData	=	new HashMap();
		HashMap hmArgSQL	=	new HashMap();
		hmResult.put("result", FALSE);
		hmSQL		= hmSQLValues;

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alIssueQtyupdateData	=	(ArrayList)hmData.get("ISSUE_QTY_UPDATE_DATA");
		ArrayList alCommonData	=	(ArrayList)hmData.get("COMMON_DATA");	
		ArrayList alData		=	new ArrayList(); 
		ArrayList alTempData	=	new ArrayList(); 
		String sql				=	"";

		boolean isUpdateSuccessful = true;
		
	
		//String stCurrentItemCodeInCaseOfError=null;

        try {
			//String trn_type = (String)alCommonData.get(4);
			String stSQLReqDtlUpdate = (String)	hmSQL.get	("stSQLReqDtlUpdate");
			 
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put("BATCH_SQL",stSQLReqDtlUpdate);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

			String stSQLReqDtlUpdateforissueqty = (String)	hmSQL.get	("stSQLReqDtlUpdateforissueqty");
            			 
			hmArgData.put(DATA,alIssueQtyupdateData);
			hmArgSQL.put("BATCH_SQL",stSQLReqDtlUpdateforissueqty);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			
			sql = (String)	hmSQL.get	("IssueDtlUpdateSQL");
			for (int i=0;i<alDtlRecords.size();i++) {
				alData	=	new ArrayList();
				HashMap hmDtlRecord = (HashMap)(alDtlRecords.get(i));
				
					alData.add(hmDtlRecord.get("acknowledge_yn"));
					
					alData.add(alCommonData.get(0)); // modified_by_id
					alData.add(alCommonData.get(1)); // modified_at_ws_no
					alData.add(alCommonData.get(2)); // modified_facility_id
					
					alData.add(hmDtlRecord.get("facility_id")); // facility_id - Where clause
					alData.add(alCommonData.get(3)); // doc_type_code - Where clause
					alData.add(hmDtlRecord.get("doc_no")); // doc_no - Where clause
					alData.add(hmDtlRecord.get("tray_no")); // tray - Where clause
					alData.add(hmDtlRecord.get("issue_group_code")); // issue_group_code - Where clause
					
					alTempData.add(alData);
			}
			
			hmArgData.put(DATA,alTempData);
			hmArgSQL.put("BATCH_SQL",sql);
			hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
		
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
		if(!isUpdateSuccessful) {
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,"FAILED");
		}
        //hmResult.put("doc_no",doc_no);
		return hmResult;
    }
	
/*Issue Return Coding starts from here...*/
	public HashMap updateReturnGroup(HashMap hmDataValues, HashMap hmSQLValues){
		HashMap hmData=(HashMap)hmDataValues;
		hmSQL=hmSQLValues;
		hmReturn	=	new HashMap();
        hmReturn.put(RESULT,FALSE);

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		//HashMap		hmItemDtl	=	new HashMap();

		ArrayList   alCommonData = new ArrayList ();
		ArrayList	alHdrData	 =	new ArrayList();
		ArrayList	alDtlData	 =	new ArrayList();
		//ArrayList	alExpData	 =	new ArrayList();
		ArrayList	allanguageData	 =	new ArrayList();
		ArrayList alData		=	new ArrayList();
		ArrayList alTempData		=	new ArrayList();

		//String stCurrentItemCodeInCaseOfError=null;
		//String sql;

		alCommonData		=	(ArrayList)hmData.get("COMMON_DATA");
		alHdrData           =   (ArrayList)	hmData.get("HDR_DATA");
		alDtlData			=	(ArrayList)	hmData.get("DTL_DATA");
		
		allanguageData		=   (ArrayList)	hmData.get("LANGUAGE_DATA");
		


		try {
			String stSQLHdrUpdate	=	(String)hmSQL.get ("stSQLHdrUpdate");
			String stSQLDtlUpdate	=	(String)hmSQL.get ("stSQLDtlUpdate");
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put("BATCH_SQL",stSQLHdrUpdate);
			hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			//sql = (String)	hmSQL.get	("IssueDtlUpdateSQL");
			for (int i=0;i<alDtlData.size();i++) {
				alData	=	new ArrayList();
				HashMap hmDtlRecord = (HashMap)(alDtlData.get(i));
			
					alData.add(hmDtlRecord.get("acknowledge_yn"));
					
					alData.add(alCommonData.get(0)); // modified_by_id
					alData.add(alCommonData.get(1)); // modified_at_ws_no
					alData.add(alCommonData.get(2)); // modified_facility_id
					
					alData.add(hmDtlRecord.get("facility_id")); // facility_id - Where clause
					alData.add(alCommonData.get(3)); // doc_type_code - Where clause
					alData.add(hmDtlRecord.get("doc_no")); // doc_no - Where clause
					alData.add(hmDtlRecord.get("tray_no")); // doc_no - Where clause
					alData.add(hmDtlRecord.get("return_group_code")); // doc_no - Where clause
					
					alTempData.add(alData);
			}
			
			hmArgData.put(DATA,alTempData);
			hmArgSQL.put("BATCH_SQL",stSQLDtlUpdate);
			hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
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
		}
		return hmReturn;
	}

	
	
}
