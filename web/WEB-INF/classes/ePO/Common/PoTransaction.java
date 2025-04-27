/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO.Common;

//import eCommon.Common.CommonAdapter;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import ePO.Common.*;

// Referenced classes of package ePO.Common:
//            PoAdapter, PoRepository

public class PoTransaction extends PoAdapter
    implements Serializable
{

	//private ArrayList alBatchRecords = new ArrayList();


//private  String language;
	/*public String setNumber(String stNumber, int decimalPlaces){
		String returnNumber	=	"0";
		try { 
		double number	=	Double.parseDouble(stNumber);

		double power	=	Math.pow(10, decimalPlaces);
		number	=	number*power;
		number	=	Math.round(number);
		number	=	number/Math.pow(10, decimalPlaces);;
		returnNumber	=	""+number;
		}
		catch (Exception exception) {
		//	exception.printStackTrace();
		}
		return returnNumber;
	}*/
//setNumber function modified by Mahesh to avoid displaying Exponential Values like 9.999999999999899E9.....on (10/16/2008)
	
	
	public String getDoc_type_code_ListOptions(String trn_type, String defaultDoc_type_code){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add( getLanguageId());	 
		return getListOptionTag( getListOptionArrayList(getPoRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters), defaultDoc_type_code);
	}

	public boolean isDocNoAutoGenYN(String doc_type_code) throws Exception{
		return checkForNull((String)fetchRecord(ePO.Common.PoRepository.getPoKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"),doc_type_code).get("DOC_NUM_GEN_FLAG")).equals("Y");
	}

	public int isValidDocDate(String doc_date)throws Exception{
		Connection connection = null;
		CallableStatement callableStatement = null;
		int isValidDocDate = -1;
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_VALIDATE_DOC_DATE(?,to_date(?,'dd/MM/yyyy'),?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, doc_date);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.execute();
			isValidDocDate = callableStatement.getInt(3);
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return isValidDocDate;
	}

/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}*/

	public HashMap getStockAvailabilityStatus(String [] stParameters)throws Exception{
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap hmReturn	=	new HashMap();
		try{
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications begin
			
			**/
			
			int no_of_decimals=getNoOfDecimals();
			String  allow_decimals_yn=getAllowDecimalsYN(stParameters[0]);
		
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			
			**/
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ CALL st_stock_availability_status(?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, stParameters[0]);//item_code
			callableStatement.setString(2, stParameters[1]);//store_code
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications begin
			
			**/
			if(allow_decimals_yn.equals("Y") ){
			callableStatement.setDouble(3, Double.parseDouble(setNumber(stParameters[2],no_of_decimals)));//qty_required
			}else{
			callableStatement.setInt(3,new Double (Double.parseDouble(stParameters[2])).intValue()); //qty_required
			}
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			
			**/
			/** @ before modification
			callableStatement.setInt(3, Integer.parseInt(stParameters[2]));//qty_required
			**/
			callableStatement.setString(4, stParameters[3]);//consider_qty_required_yn
			callableStatement.setString(5, stParameters[4]);//effective_date_for_expiry
			callableStatement.setString(6, stParameters[5]);//include_suspended_batch_yn
			callableStatement.setString(7, stParameters[6]);//to_store_code
			callableStatement.registerOutParameter(8, Types.VARCHAR);	//stock_available_yn
			callableStatement.registerOutParameter(9, Types.DOUBLE);	//item_unit_cost
			callableStatement.registerOutParameter(10, Types.DOUBLE);	//store_item_unit_cost
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications begin
			
			**/
	
			callableStatement.registerOutParameter(11, Types.DOUBLE);	//available_stock
			callableStatement.registerOutParameter(12, Types.DOUBLE);	//expired_stock
			callableStatement.registerOutParameter(15, Types.DOUBLE);	//to_qty_on_hand
			
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			
			**/

			/** @ before modification 
			callableStatement.registerOutParameter(11, Types.INTEGER);	//available_stock
			callableStatement.registerOutParameter(12, Types.INTEGER);	//expired_stock
			callableStatement.registerOutParameter(15, Types.INTEGER);	//to_qty_on_hand
			**/
			callableStatement.registerOutParameter(13, Types.VARCHAR);	//stock_item_yn
			callableStatement.registerOutParameter(14, Types.VARCHAR);	//to_stock_item_yn
			callableStatement.registerOutParameter(16, Types.DOUBLE);	//to_store_item_unit_cost
			callableStatement.registerOutParameter(17, Types.VARCHAR);	//to_store_master_bin
			callableStatement.registerOutParameter(18, Types.VARCHAR);	//p_item_store_combn_exists_yn
			callableStatement.registerOutParameter(19, Types.VARCHAR);	//p_msg
			callableStatement.execute();
			
			hmReturn.put("stock_available_yn",callableStatement.getString(8));
			hmReturn.put("item_unit_cost",""+callableStatement.getDouble(9));
			hmReturn.put("store_item_unit_cost",""+callableStatement.getDouble(10));
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			
			**/
			if(allow_decimals_yn.equals("Y")){
			hmReturn.put("available_stock",setNumber(""+callableStatement.getDouble(11),no_of_decimals));
			hmReturn.put("expired_stock",setNumber(""+callableStatement.getDouble(12),no_of_decimals));
			hmReturn.put("to_qty_on_hand",setNumber(""+callableStatement.getDouble(15),no_of_decimals));
			hmReturn.put("allow_decimals_yn",allow_decimals_yn);
			hmReturn.put("no_of_decimals",""+no_of_decimals);
			}else{
			hmReturn.put("available_stock",setNumber(""+callableStatement.getDouble(11),0));
			hmReturn.put("expired_stock",setNumber(""+callableStatement.getDouble(12),0));
			hmReturn.put("to_qty_on_hand",setNumber(""+callableStatement.getDouble(15),0));
			hmReturn.put("allow_decimals_yn","N");
			hmReturn.put("no_of_decimals","0");
			}
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			
			**/
			/** @ before modification 
			hmReturn.put("available_stock",""+callableStatement.getInt(11));
			hmReturn.put("expired_stock",""+callableStatement.getInt(12));
			hmReturn.put("to_qty_on_hand",""+callableStatement.getInt(15));
			**/
			hmReturn.put("stock_item_yn",callableStatement.getString(13));
			hmReturn.put("to_stock_item_yn",callableStatement.getString(14));
			hmReturn.put("to_store_item_unit_cost",""+callableStatement.getDouble(16));
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
			closeConnection(connection);
		}
		return hmReturn;
	}
	

	public String fetchNextDocNo(String doc_type_code) throws Exception {
        HashMap hashmap = fetchRecord(PoRepository.getPoKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), doc_type_code);
        return (String)hashmap.get("NEXT_DOC_NO");
    }

	public String getListValues(String sql, java.util.ArrayList sqlParam, String selectedValue) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues = getListOptionArrayList(sql, sqlParam);
	
		optionValues = getListOptionTag(alOptionValues, selectedValue);
	
		alOptionValues = null;
		return optionValues;
	}	

	public String canAcceptDecimal(String item_code) throws Exception {
		HashMap hashmap = fetchRecord(PoRepository.getPoKeyValue("SQL_ST_ITEM_INTEGER_SELECT"), item_code);
		return (String) hashmap.get("ISSUE_INT_QTY_YN");
	}
	

	public boolean recordExists(String login_facility_id, String material_group_code) throws Exception {
		String stParameters[]={login_facility_id, material_group_code};
		HashMap hmResult = fetchRecord(getPoRepositoryValue("SQL_ST_FACILITY_PARAM_COUNT"), stParameters);
		return !(((String)hmResult.get("TOTAL")).equals("0"));
	} 	

	public boolean isPhysicalInventoryProcessStartedForStore(HashMap hmParameter){
		String facility_id		=(String)hmParameter.get("facility_id");
		String doc_type_code	=(String)hmParameter.get("doc_type_code");
		String doc_no			=(String)hmParameter.get("doc_no");
		String trn_type			=(String)hmParameter.get("trn_type");
		String seq_no			=(String)hmParameter.get("seq_no");

		ArrayList alParameters=	new ArrayList();
		String stSQL=	"";

		try{
			alParameters.add(facility_id);
			alParameters.add(doc_type_code);
			alParameters.add(doc_no);
			alParameters.add(facility_id);
			alParameters.add(doc_type_code);
			alParameters.add(doc_no);
			if(trn_type.equals("PRQ")){
		//		stSQL = "SELECT COUNT (*) TOTAL FROM ST_ITEM_STORE WHERE STORE_CODE IN (SELECT REQ_STORE_CODE STORE_CODE FROM PO_REQUEST_HDR  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?  UNION  SELECT PUR_DEPT_CODE STORE_CODE FROM PO_REQUEST_HDR  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?) AND ITEM_CODE IN (SELECT ITEM_CODE FROM PO_REQUEST_DTL WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?) AND PHY_INV_ID IS NOT NULL";
			stSQL="SQL_ST_ITEM_STORE_COUNT1" ;

			}else{
				stSQL	=	"SQL_ST_ITEM_STORE_SELECT_COUNT_FOR_PHY_"+trn_type;
			}
			if (trn_type.equals("ISS")||trn_type.equals("URG")) {
				stSQL	=	"SQL_ST_ITEM_STORE_SELECT_COUNT_FOR_PHY_ISS";
				alParameters=	new ArrayList();
				alParameters.add(facility_id);
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(seq_no);
				alParameters.add(facility_id);
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(seq_no);
				alParameters.add(facility_id);
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(seq_no);
			}else if (trn_type.equals("REQ")||trn_type.equals("TFR")||trn_type.equals("RET")||trn_type.equals("PRQ")) {
				alParameters.add(facility_id);
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
			}
			HashMap hmRecord	= new HashMap();
		//	if(trn_type.equals("PRQ"))
		//		hmRecord	=	fetchRecord(stSQL,alParameters);
		//	else
				hmRecord	=	fetchRecord(getPoRepositoryValue(stSQL),alParameters);
			return	!hmRecord.get("TOTAL").toString().equals("0");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}
// Added on 5/30/2005 for Physical Inventory check while creating with store and item combination
public boolean isPhysicalInventoryProcessStartedForStore(String Item_code,String Store_code_from, String Store_code_to) {
		
		ArrayList alParameters=	new ArrayList();
		String stSQL=	"";

		try{
			alParameters.add(checkForNull(Item_code));
			alParameters.add(checkForNull(Store_code_from));
			alParameters.add(checkForNull(Store_code_to));
			stSQL	=	"SQL_ST_PHY_INV_COUNT";
			HashMap hmRecord	=	fetchRecord(getPoRepositoryValue(stSQL),alParameters);
			return	!hmRecord.get("TOTAL").toString().equals("0");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}
// End of 5/30/2005 
/*to be removed..*/
	public boolean isPhysicalInventoryProcessStartedForStore(String store_code){
		try{
			ArrayList alRecords	=	fetchRecords(getPoRepositoryValue("SQL_ST_ITEM_STORE_SELECT_DIST_FOR_PHY"),store_code);
			for (int i=0; i<alRecords.size(); i++) {
				HashMap hmRecord	= (HashMap)alRecords.get(i);
				if (hmRecord.get("PHY_INV_ID")!=null) 
					return true;
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
/*to be removed..*/
	public boolean isPhysicalInventoryProcessStartedForStore(String store_code1, String store_code2){
		return isPhysicalInventoryProcessStartedForStore(store_code1) || isPhysicalInventoryProcessStartedForStore(store_code2);
	}

	public boolean isInternalRequest(String module_id, String report_id) {
        boolean flag = false;
        try {
            String stSQL = eMM.Common.MmRepository.getMmKeyValue("SQL_SM_REPORT_SELECT_INTERNAL_REQUEST");
            String stArray[] = {
                module_id, report_id
            };
            flag = fetchRecord(stSQL, stArray).get("INTERNAL_REQUEST_YN").toString().equals("Y");
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        return flag;
    }

	public boolean isDocTypePrintAllowed(String doc_type_code) {
        boolean flag = false;
        try {
            String stSQL = ePO.Common.PoRepository.getPoKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT");
            flag = fetchRecord(stSQL, doc_type_code).get("DOC_PRINT_FLAG").toString().equals("Y");
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        return flag;
    }
/**
*methods for invoking online report thread.
*/
	public String getReportParameter( HashMap hmReportParameter){
		StringBuffer sbParameter	=	new StringBuffer();
        for(Iterator iterator = hmReportParameter.keySet().iterator(); iterator.hasNext();) {
            String poKey = (String)iterator.next();
            String poValue = (String)hmReportParameter.get(poKey);
			sbParameter.append(poKey);
			sbParameter.append("=");
			sbParameter.append(poValue);
			sbParameter.append("+");
		}
		sbParameter.deleteCharAt(sbParameter.length()-1);
		return sbParameter.toString();
	}

    public String getURLString(HashMap hmParameters) {
        Connection connection = null;
		CallableStatement callableStatement = null;
        StringBuffer sbURL = new StringBuffer();

		try {
			HashMap hmReportParameter	=	(HashMap)hmParameters.get("report_parameter");
			String poReport_server = checkForNull((String)hmParameters.get("report_server"));
            String poReport_connect_string = checkForNull((String)hmParameters.get("report_connect_string"));
            String poExecutable_name = "";
            String poServer = "";
            String poCopies = "";
//            String stReport_mode = "";
            String poQueue_name = "";
//            String stReport_tool = "";
//            String stStatus = "";
            String poMessage = "";
            String poModule_id = (String)hmReportParameter.get("p_module_id");
            String poReport_id = (String)hmReportParameter.get("p_report_id");
            String poLocation_type = (String)hmParameters.get("location_type");
            String poLocation_code = (String)hmParameters.get("location_code");
            String poFacility_id = (String)hmReportParameter.get("p_facility_id");
            Properties properties = getProperties();
            String poClient_ip_address = checkForNull(properties.getProperty("client_ip_address"));
            String poReport_option = "P";
            String po_app_server_ip = "";

			connection = getConnection();
            
			callableStatement = connection.prepareCall("{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
            callableStatement.setString(1, poModule_id);
            callableStatement.setString(2, poReport_id);
            callableStatement.setString(3, poLocation_type);
            callableStatement.setString(4, poLocation_code);
            callableStatement.setString(5, poFacility_id);
            callableStatement.setString(6, poClient_ip_address);
            callableStatement.setString(7, poReport_option);
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.registerOutParameter(11, Types.VARCHAR);
            callableStatement.registerOutParameter(12, Types.VARCHAR);
            callableStatement.registerOutParameter(13, Types.VARCHAR);
            callableStatement.registerOutParameter(14, Types.VARCHAR);
            callableStatement.registerOutParameter(15, Types.VARCHAR);
            callableStatement.registerOutParameter(16, Types.VARCHAR);
            callableStatement.execute();
            poExecutable_name = callableStatement.getString(8);
            poServer = callableStatement.getString(9);
            poCopies = callableStatement.getString(10);
//            stReport_mode = callableStatement.getString(11);
            poQueue_name = callableStatement.getString(12);
//            stReport_tool = callableStatement.getString(13);
//            stStatus = callableStatement.getString(14);
           poMessage = callableStatement.getString(15);
            po_app_server_ip = callableStatement.getString(16);
            poReport_server = "http://" + po_app_server_ip + poReport_server;
			
			if(poQueue_name.startsWith("\\\\\\\\")) {
                String s20 = poQueue_name.substring(4);
                int i = s20.indexOf("\\\\");
                String s21 = s20.substring(0, i);
                String s22 = s20.substring(i + 2);
                String s24 = "\\\\" + s21 + "\\" + s22;
                poQueue_name = s24;
            }

			sbURL.append(poReport_server);
			sbURL.append("?report=");
			sbURL.append(poExecutable_name);
			sbURL.append("+userid=");
			sbURL.append(poReport_connect_string);
			sbURL.append("+server=");
			sbURL.append(poServer);
			sbURL.append("+desname=");
			sbURL.append(poQueue_name);
			sbURL.append("+copies=");
			sbURL.append(poCopies);
			sbURL.append("+destype=printer+recursive_load=no+");
			sbURL.append(getReportParameter((HashMap) hmParameters.get("report_parameter")));
       }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try { 
				if(callableStatement != null)
					callableStatement.close();
				if(connection != null)
					closeConnection(connection);
			}
            catch (Exception exception) {
            	exception.printStackTrace();
            }
        }
		return sbURL.toString();
    }
/*methods for invoking online report thread ends.*/


public int getEntityparam_EWDays(String ACC_ENTITY_ID) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String EWDays		  = "";
		int IEWDays = 0;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PoRepository.getPoKeyValue("SQL_ST_SELECT_EXPIRY_WARNING_DAYS"));
			pstmt.setString(1,ACC_ENTITY_ID);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
			EWDays =	resultSet.getString("EXPIRY_WARNING_DAYS");
			IEWDays = Integer.parseInt(EWDays);
			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return IEWDays;
	}

// added by gangadharan for Sysdate and Sysdate minus 7 days for common function 
       public HashMap getSysdateMinusdays() throws Exception{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		HashMap SysdateMinusdays = new HashMap();

	
		try{
			 SysdateMinusdays = fetchRecord("SELECT TO_CHAR(SYSDATE,'DD/MM/RRRR')SYSTEMDATE , TO_CHAR(SYSDATE-7,'DD/MM/RRRR') SYSDATEMINUS7 FROM DUAL");
		   }

		catch(Exception e){
			e.printStackTrace();
		}
		finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return SysdateMinusdays;
	}

	public HashMap getDurationforStartDate() throws Exception{
	 
			  HashMap DurationforStartDate = new HashMap();
		try{	 
			DurationforStartDate =    fetchRecord("SELECT  NVL(DURN_FOR_START_DATE,0)DURN_FOR_START_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY')SYSTEMDATE ,TO_CHAR(SYSDATE-NVL(DURN_FOR_START_DATE,0), 'DD/MM/YYYY') DURATIONFORSTARTDATE  FROM  ST_FACILITY_PARAM   WHERE FACILITY_ID = ? ",getLoginFacilityId());	  	
		   }catch(Exception e){
			e.printStackTrace();
		  }
		  return DurationforStartDate;
		
	  }
	
	public HashMap MMParameters() throws Exception{		
		HashMap hmMm_parameter=fetchRecord(getPoRepositoryValue("SQL_MM_PARAMETER_SELECT_SINGLE"),"MM");
		return hmMm_parameter; 
	}
	
}
