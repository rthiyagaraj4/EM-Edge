package eSS.VendorLoanAck;
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
*	name="VendorLoanAck"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="VendorLoanAck"
*	local-jndi-name="VendorLoanAck"
*	impl-class-name="eSS.VendorLoanAck.VendorLoanAckManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.VendorLoanAck.VendorLoanAckLocal"
*	remote-class="eSS.VendorLoanAck.VendorLoanAckRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.VendorLoanAck.VendorLoanAckLocalHome"
*	remote-class="eSS.VendorLoanAck.VendorLoanAckHome"
*	generate= "local,remote"
*
*
*/

public class VendorLoanAckManager extends SsEJBSessionAdapter{
	
	
	HashMap hmSQL;
	HashMap hmReturn;
	HashMap hmData;
	String stSQL;
	Connection connection = null;
	Properties properties = null;
	String adj_doc_type_code = "";
					
    public VendorLoanAckManager(){}
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
		hmSQL = hmSQL1;
		hashmapResult.put("result", FALSE);
        try
        {
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
            ArrayList arraylistHdrData = (ArrayList)hmData.get("ACK_HDR_DATA");
			ArrayList arraylistDtlData = (ArrayList)hmData.get("ACK_DTL_DATA");
			ArrayList arraylistHdrUpdData = (ArrayList)hmData.get("ACK_HDR_UPDATE_DATA");
		//	ArrayList alPendAckData = (ArrayList)hmData.get("GROUP_FOR_STORE_UPDATE_ACK");
			ArrayList alIssueQtyupdateData	=	(ArrayList)hmData.get("ISSUE_QTY_UPDATE_DATA");
			
			if(arraylistHdrData.size()>0){
				String HdrQuery = (String)hmSQL.get("SS_SQL_SS_EXT_ACK_HDR_INSERT");
				hashmapHDrdata.put("DATA",arraylistHdrData);
				hashmapHDrquery.put("BATCH_SQL",HdrQuery);
				hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(arraylistHdrUpdData.size()>0){
				String HdrUpdQuery = (String)hmSQL.get("SS_SQL_SS_EXT_ACK_HDR_UPDATE");
				hashmapHDrdata.put("DATA",arraylistHdrUpdData);
				hashmapHDrquery.put("BATCH_SQL",HdrUpdQuery);
				hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			if(arraylistDtlData.size()>0){
				String DtlQuery = (String)hmSQL.get("SS_SQL_SS_EXT_ACK_DTL_INSERT");
				hashmapDtldata.put("DATA",arraylistDtlData);
				hashmapDtlquery.put("BATCH_SQL",DtlQuery);
				hashmapResult =  operateBatch(connection, hashmapDtldata, hashmapDtlquery);
				throwExceptionWhenFailed(hashmapResult);
			}
			/*if(alPendAckData.size()>0){
				String ModGroupStoreUpdate = (String)hmSQL.get("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_UNSTERILIZED_QTY");
				hmModDtlData.put("DATA",alPendAckData);
				hmModDtlQuery.put("BATCH_SQL",ModGroupStoreUpdate);
				hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
				throwExceptionWhenFailed(hashmapResult);
			}*/
			if(alIssueQtyupdateData.size()>0){
				String stSQLReqDtlUpdateforissueqty = (String)	hmSQL.get	("stSQLReqDtlUpdateforissueqty");
				hmModDtlData.put("DATA",alIssueQtyupdateData);
				hmModDtlQuery.put("BATCH_SQL",stSQLReqDtlUpdateforissueqty);
				hashmapResult =  operateBatch(connection, hmModDtlData, hmModDtlQuery);
				throwExceptionWhenFailed(hashmapResult);
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
}