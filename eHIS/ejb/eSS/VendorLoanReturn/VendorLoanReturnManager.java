/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
06/04/2017	IN063878		Badmavathi B					        		Unused variables
--------------------------------------------------------------------------------------------------------------------
*/
package eSS.VendorLoanReturn;


import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="VendorLoanReturn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="VendorLoanReturn"
*	local-jndi-name="VendorLoanReturn"
*	impl-class-name="eSS.VendorLoanReturn.VendorLoanReturnManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.VendorLoanReturn.VendorLoanReturnLocal"
*	remote-class="eSS.VendorLoanReturn.VendorLoanReturnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.VendorLoanReturn.VendorLoanReturnLocalHome"
*	remote-class="eSS.VendorLoanReturn.VendorLoanReturnHome"
*	generate= "local,remote"
*
*
*/


public class  VendorLoanReturnManager extends SsEJBSessionAdapter {

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL ) {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		ArrayList	alDeleteData=	new ArrayList();		
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		
		Properties	properties	=	null;
		String		stSQL		=	null;

		//HashMap		hmResult	=	new HashMap(); Commented for unused variable IN063878


		hmReturn.put(RESULT,FALSE);
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);		

			alDeleteData		=	(ArrayList)	hmData.get("DeleteData");
			stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
															
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);
			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			
			
			stSQL				=	(String)	hmSQL.get ("HdrDeleteSQL");		
			
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);
			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			connection.commit();
        }
		catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL) {
		Connection	connection	=	null;		
		HashMap hashmapResult	= new HashMap();
		
		HashMap hashmapHDrdata	= new HashMap();
        HashMap hashmapHDrquery = new HashMap();
        
        HashMap hashmapDtldata	= new HashMap();
        HashMap hashmapDtlquery = new HashMap();
        
        HashMap hashmapupdatedata	= new HashMap();
        HashMap hashmapupdatequery = new HashMap();
		HashMap hashmapupdatedata1	= new HashMap();
        HashMap hashmapupdatequery1 = new HashMap();
		
		HashMap hashmapdelROFdata	= new HashMap();
        HashMap hashmapdelROFquery = new HashMap();
		
		HashMap hashmapdelTRAYdata	= new HashMap();
        HashMap hashmapdelTRAYquery = new HashMap();
        
		Properties	properties	=	null;
		
		
		hashmapResult.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			ArrayList arraylistHdrData = (ArrayList)hmData.get("VENDOR_RETURN_HDR_DATA");
			ArrayList arraylistDtlData = (ArrayList)hmData.get("VENDOR_RETURN__DTL_DATA");
			ArrayList arraylistUpdSTData = (ArrayList)hmData.get("GROUP_FOR_STORE_UPDATE_ST_VENDOR_RETURN");
			ArrayList arraylistUpdROFData = (ArrayList)hmData.get("GROUP_FOR_STORE_UPDATE_ROF_VENDOR_RETURN");
			ArrayList arraylistDelROFData = (ArrayList)hmData.get("SS_ROF_DTL_DELEATE_VENDOR_RETURN");
			ArrayList arraylistDelTRAYData = (ArrayList)hmData.get("SS_TRAY_DTL_DELEATE_VENDOR_RETURN"); //IN057334
			
			if(arraylistHdrData.size()>0){				
				String HdrQuery = (String)hmSQL.get("SQL_SS_EXT_RETURN_HDR_INSERT");				
				hashmapHDrdata.put("DATA",arraylistHdrData);
				hashmapHDrquery.put("BATCH_SQL",HdrQuery);
				hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			
			if(arraylistDtlData.size()>0){
				String DtlQuery = (String)hmSQL.get("SQL_SS_EXT_RETURN_DTL_INSERT");
				hashmapDtldata.put("DATA",arraylistDtlData);
				hashmapDtlquery.put("BATCH_SQL",DtlQuery);
				hashmapResult =  operateBatch(connection, hashmapDtldata, hashmapDtlquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			
			if(arraylistUpdSTData.size()>0){
				String updateQuery = (String)hmSQL.get("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ST_VEDOR_RETURN_QTY");
				hashmapupdatedata.put("DATA",arraylistUpdSTData);
				hashmapupdatequery.put("BATCH_SQL",updateQuery);
				hashmapResult =  operateBatch(connection, hashmapupdatedata, hashmapupdatequery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(arraylistUpdROFData.size()>0){
				String updateQuery = (String)hmSQL.get("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ROF_VEDOR_RETURN_QTY");
				hashmapupdatedata1.put("DATA",arraylistUpdROFData);
				hashmapupdatequery1.put("BATCH_SQL",updateQuery);
				hashmapResult =  operateBatch(connection, hashmapupdatedata1, hashmapupdatequery1);
				throwExceptionWhenFailed(hashmapResult);
			}
			
			if(arraylistDelROFData.size()>0){
				String deleteSSTrayQuery = (String)hmSQL.get("SQL_SS_TRAY_DELEATE_FOR_VEDOR_RETURN_QTY");
				hashmapdelTRAYdata.put("DATA",arraylistDelTRAYData);
				hashmapdelTRAYquery.put("BATCH_SQL",deleteSSTrayQuery);
				hashmapResult =  operateBatch(connection, hashmapdelTRAYdata, hashmapdelTRAYquery);
				throwExceptionWhenFailed(hashmapResult);
				
				String deleteROFQuery = (String)hmSQL.get("SQL_SS_ROF_DTL_DELEATE_FOR_VEDOR_RETURN_QTY");
				hashmapdelROFdata.put("DATA",arraylistDelROFData);
				hashmapdelROFquery.put("BATCH_SQL",deleteROFQuery);
				hashmapResult =  operateBatch(connection, hashmapdelROFdata, hashmapdelROFquery);
				throwExceptionWhenFailed(hashmapResult); 
				
				
			}
			connection.commit();			
        }
		catch(Exception exception) {
			try{
                connection.rollback();
                exception.printStackTrace();
            }catch(Exception exception1){
                exception1.printStackTrace();
            }
            hashmapResult.put("result", FALSE);
            hashmapResult.put("msgid", exception.getMessage());
            hashmapResult.put("message", exception.toString());
			
			String message = (String)hashmapResult.get("message");

			if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			{
				hashmapResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
				hashmapResult.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
			}
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hashmapResult;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmData, HashMap hmSQL) {
		Connection	connection	=	null;		
		HashMap hashmapResult	= new HashMap();
		
		HashMap hashmapHDrdata	= new HashMap();
        HashMap hashmapHDrquery = new HashMap();
        
        HashMap hashmapupdatedata	= new HashMap();
        HashMap hashmapupdatequery = new HashMap();
		
		HashMap hashmapupdatedata1	= new HashMap();
        HashMap hashmapupdatequery1 = new HashMap();
		
		HashMap hashmapdelROFdata	= new HashMap();
        HashMap hashmapdelROFquery = new HashMap();
		
		HashMap hashmapdelTRAYdata	= new HashMap();
        HashMap hashmapdelTRAYquery = new HashMap();
		
        
		Properties	properties	=	null;
		
		
		hashmapResult.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			ArrayList arraylistHdrData = (ArrayList)hmData.get("VENDOR_RETURN_HDR_UPDATE_DATA");
			ArrayList arraylistUpdSTData = (ArrayList)hmData.get("GROUP_FOR_STORE_UPDATE_ST_VENDOR_RETURN");
			ArrayList arraylistUpdROFData = (ArrayList)hmData.get("GROUP_FOR_STORE_UPDATE_ROF_VENDOR_RETURN");
			ArrayList arraylistDelROFData = (ArrayList)hmData.get("SS_ROF_DTL_DELEATE_VENDOR_RETURN");
			ArrayList arraylistDelTRAYData= (ArrayList)hmData.get("SS_TRAY_DTL_DELEATE_VENDOR_RETURN");
			if(arraylistHdrData.size()>0){
				String HdrQuery = (String)hmSQL.get("SQL_SS_EXT_RETURN_HDR_UPDATE");
				hashmapHDrdata.put("DATA",arraylistHdrData);
				hashmapHDrquery.put("BATCH_SQL",HdrQuery);
				hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			
			if(arraylistUpdSTData.size()>0){
				String updateQuery = (String)hmSQL.get("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ST_VEDOR_RETURN_QTY");
				hashmapupdatedata.put("DATA",arraylistUpdSTData);
				hashmapupdatequery.put("BATCH_SQL",updateQuery);
				hashmapResult =  operateBatch(connection, hashmapupdatedata, hashmapupdatequery);
				throwExceptionWhenFailed(hashmapResult);
			}
			
			if(arraylistUpdROFData.size()>0){
				String updateQuery = (String)hmSQL.get("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ROF_VEDOR_RETURN_QTY");
				hashmapupdatedata1.put("DATA",arraylistUpdROFData);
				hashmapupdatequery1.put("BATCH_SQL",updateQuery);
				hashmapResult =  operateBatch(connection, hashmapupdatedata1, hashmapupdatequery1);
				throwExceptionWhenFailed(hashmapResult);
			}
			
			if(arraylistDelROFData.size()>0){				
				String deleteSSTrayQuery = (String)hmSQL.get("SQL_SS_TRAY_DELEATE_FOR_VEDOR_RETURN_QTY");
				hashmapdelTRAYdata.put("DATA",arraylistDelTRAYData);
				hashmapdelTRAYquery.put("BATCH_SQL",deleteSSTrayQuery);
				hashmapResult =  operateBatch(connection, hashmapdelTRAYdata, hashmapdelTRAYquery);
				throwExceptionWhenFailed(hashmapResult);
				
				String deleteROFQuery = (String)hmSQL.get("SQL_SS_ROF_DTL_DELEATE_FOR_VEDOR_RETURN_QTY");
				hashmapdelROFdata.put("DATA",arraylistDelROFData);
				hashmapdelROFquery.put("BATCH_SQL",deleteROFQuery);
				hashmapResult =  operateBatch(connection, hashmapdelROFdata, hashmapdelROFquery);
				throwExceptionWhenFailed(hashmapResult); 				
				
			}
			connection.commit();
        }
		catch(Exception exception) {
			try{
                connection.rollback();
                exception.printStackTrace();
            }catch(Exception exception1){
                exception1.printStackTrace();
            }
            hashmapResult.put("result", FALSE);
            hashmapResult.put("msgid", exception.getMessage());
            hashmapResult.put("message", exception.toString());
			
			String message = (String)hashmapResult.get("message");

			if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			{
				hashmapResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
				hashmapResult.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
			}
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hashmapResult;
	}	
}