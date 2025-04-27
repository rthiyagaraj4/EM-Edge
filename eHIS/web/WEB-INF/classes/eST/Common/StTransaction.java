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
2/09/2017				42063			        Chithra             2/09/2017      	     GHL-CRF-0465
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST.Common;

//import eCommon.Common.CommonAdapter;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat; //Added for MOHE-CRF-0167

// Referenced classes of package eST.Common:
//            StAdapter, StRepository

public class StTransaction extends StAdapter
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
	
//added for barcode	
	private ArrayList alBatchRecordsBarcode;
	private ArrayList alDtlRecordsforBarCode;
	private HashMap hmExpRecordsforBarCode;
	private int doc_srl_noforBarCode	= 0;
	private String BarcodeApplicable = "N";
	private String BarcodeEditQtyAppl  = "N";
	private String BarcodeDefaultQtyAppl  = "N";
	private String records_to_delete_for_barcode;
	private ArrayList AddBatchRecords;
	private ArrayList tempalBatchRecordsBarcode;//Added for GHL-CRF-0413
	private ArrayList alMinMaxRecordsforBarcode;
	private HashMap store2DBarcodes ;//Added for MMS-DM-CRF-0174.6
	private String include_expiry_date ="N";//Added for MOHE-CRF-0167
	//Added for GHL-CRF-0413 B.Badmavathi starts
		private ArrayList alBarcodeExp = new ArrayList();
		private ArrayList alItemcodeExp = new ArrayList();
		private ArrayList batchDtl;// adedd for GHL-CRF 0465
		private boolean site_spec_yn = false;
		public ArrayList getAlItemcodeExp() {
		return alItemcodeExp;
		}
		public void setAlItemcodeExp(ArrayList alItemcodeExp) {
			this.alItemcodeExp = alItemcodeExp;
		}
		public ArrayList getAlBarcodeExp() {
			return alBarcodeExp;
		}
		public void setAlBarcodeExp(ArrayList alBarcodeExp) {
			this.alBarcodeExp = alBarcodeExp;
		}
			public boolean isSite_spec_yn() {
				return site_spec_yn;
			}
			public void setSite_spec_yn(boolean site_spec_yn) {
				this.site_spec_yn = site_spec_yn;
			}
	//Added for GHL-CRF-0413 B.Badmavathi ends

	public void setIncludeExpiryDate(String include_exp_date) {//Adding start for MOHE-CRF-0167
			this.include_expiry_date = include_exp_date;
		}
		public String getIncludeExpiryDate() {
			return include_expiry_date;
		}//Adding end for MOHE-CRF-0167
	public void initialize()
	{		
		alBatchRecordsBarcode = new ArrayList(); 
		 //Added for GHL-CRF-0413 starts
		tempalBatchRecordsBarcode = new ArrayList();
		alItemcodeExp = new ArrayList();
		alBarcodeExp = new ArrayList();
		site_spec_yn = false;
		 //Added for GHL-CRF-0413 ends
		alDtlRecordsforBarCode = new ArrayList(); 
		batchDtl=new ArrayList(); //aded for GHL-CRF-0465
		hmExpRecordsforBarCode = new HashMap();  
		doc_srl_noforBarCode	= 0;
		BarcodeApplicable = "N";
		BarcodeEditQtyAppl  = "N";
		BarcodeDefaultQtyAppl  = "N";
		records_to_delete_for_barcode="";
		AddBatchRecords = new ArrayList(); 
		alMinMaxRecordsforBarcode = new ArrayList(); 
		store2DBarcodes =new HashMap();//Added for MMS-DM-CRF-0174.5
	}

	public void clear()
	{	
	 //Added for GHL-CRF-0413 starts
		tempalBatchRecordsBarcode = null;
		alItemcodeExp = null;
		alBarcodeExp = null;
		site_spec_yn = false;
		 //Added for GHL-CRF-0413 ends
		alBatchRecordsBarcode = null;
		alDtlRecordsforBarCode = null;
		hmExpRecordsforBarCode = null;
		doc_srl_noforBarCode	= 0;
		BarcodeApplicable = "N";
		BarcodeEditQtyAppl  = "N";
		BarcodeDefaultQtyAppl  = "N";
		records_to_delete_for_barcode="";
		AddBatchRecords = null; 
		alMinMaxRecordsforBarcode = null;
		batchDtl=null;// added for GHL-CRF-0465
		store2DBarcodes =null;//Added for MMS-DM-CRF-0174.5
	}	
	
//added ended	
	
	public String getDoc_type_code_ListOptions(String trn_type, String defaultDoc_type_code){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add( getLanguageId());	 
		return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters), defaultDoc_type_code);
	} 

	public boolean isDocNoAutoGenYN(String doc_type_code) throws Exception{
		return checkForNull((String)fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"),doc_type_code).get("DOC_NUM_GEN_FLAG")).equals("Y");
	}
	public void set2dBarcodeItems(String key,String barcode2D){//Adding start for MMS-DM-CRF-0174.6
	    if(!store2DBarcodes.containsKey(key))
		   store2DBarcodes.put(key,barcode2D);
	}
	public String get2dBarcodeItems(String key){
		String barcode2D ="";
			 if(store2DBarcodes.containsKey(key))
				barcode2D =(String)store2DBarcodes.get(key);

			 return barcode2D;
   }//Adding end for MMS-DM-CRF-0174.6

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
	
	public HashMap getDrugStatus(String [] stParameters)throws Exception{
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap hmReturn	=	new HashMap();

		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ CALL ph_item_drug_link.Ph_St_Drug_Item_Desc_Check(?,?,?,?,?) }");
			callableStatement.setString(1, stParameters[0]);//item_code

			callableStatement.registerOutParameter(2, Types.VARCHAR);	//p_drug_code
			callableStatement.registerOutParameter(3, Types.VARCHAR);	//p_ret_value
			callableStatement.registerOutParameter(4, Types.VARCHAR);	//p_err_mesg 
			callableStatement.registerOutParameter(5, Types.VARCHAR);	//p_drug_desc
			
			callableStatement.execute();
			
			hmReturn.put("p_drug_code",callableStatement.getString(2));
			hmReturn.put("p_ret_value",""+callableStatement.getString(3));
			hmReturn.put("p_err_mesg",""+callableStatement.getString(4));
			hmReturn.put("p_drug_desc",""+callableStatement.getString(5));
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return hmReturn;
	}

	public HashMap getValidDrug(String [] stParameters)throws Exception{
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap hmReturn	=	new HashMap();

		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ CALL ph_item_drug_link.Ph_Valid_Unassigned_Drug_Check(?,?) }");
			callableStatement.setString(1, stParameters[0]);//drug_code
			callableStatement.registerOutParameter(2, Types.VARCHAR);	//p_ret_value
			callableStatement.execute();
			hmReturn.put("p_ret_value",""+callableStatement.getString(2));
		}
		catch(Exception exception){
			
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return hmReturn;
	}

	public HashMap UpdateDrug(String [] stParameters)throws Exception{
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap hmReturn	=	new HashMap();
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ CALL ph_item_drug_link.Ph_St_Create_Item_Drug_Link(?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, stParameters[0]);//ITEM_CODE
			callableStatement.setString(2, stParameters[1]);//DRUG_CODE
			callableStatement.setString(3, stParameters[2]);//STK_UOM
			callableStatement.setString(4, stParameters[3]);//USER
			callableStatement.setString(5, stParameters[4]);//FACILITY 
			callableStatement.setString(6, stParameters[5]);//WSNO  
			callableStatement.setString(7, stParameters[6]);//DRUGITEMSAME
			callableStatement.registerOutParameter(8, Types.VARCHAR);	//ERR_MESG
			callableStatement.execute();
			hmReturn.put("p_err_mesg",""+callableStatement.getString(8));
			connection.commit();
		}
		catch(Exception exception){
			
			connection.rollback();
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return hmReturn;
	}
	

	public String fetchNextDocNo(String doc_type_code) throws Exception {
        HashMap hashmap = fetchRecord(StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), doc_type_code);
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
		HashMap hashmap = fetchRecord(StRepository.getStKeyValue("SQL_ST_ITEM_INTEGER_SELECT"), item_code);
		return (String) hashmap.get("ISSUE_INT_QTY_YN");
	}
	
	public String getPatientName(String patient_id) throws Exception {
        try{
            HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MAN_REQ_PATIENT_SELECT_SINGLE"), patient_id);
            return (String)hashmap.get("PATIENT_NAME");
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }

	public HashMap getPatientDetails(String patient_id) throws Exception {
        try{
            HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MAN_REQ_PATIENT_SELECT_SINGLE_AGE"), patient_id);
            return hashmap;
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }




	public boolean recordExists(String login_facility_id, String material_group_code) throws Exception {
		String stParameters[]={login_facility_id, material_group_code};
		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_COUNT"), stParameters);
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
				hmRecord	=	fetchRecord(getStRepositoryValue(stSQL),alParameters);
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
			HashMap hmRecord	=	fetchRecord(getStRepositoryValue(stSQL),alParameters);
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
			ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ITEM_STORE_SELECT_DIST_FOR_PHY"),store_code);
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
            //flag = fetchRecord(stSQL, stArray).get("INTERNAL_REQUEST_YN").toString().equals("Y");
			String internal_request_yn = checkForNull((String)fetchRecord(stSQL, stArray).get("INTERNAL_REQUEST_YN"),"N");
            flag = internal_request_yn.equals("Y");

        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        return flag;
    }

	public boolean isDocTypePrintAllowed(String doc_type_code) {
        boolean flag = false;
        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT");
            //flag = fetchRecord(stSQL, doc_type_code).get("DOC_PRINT_FLAG").toString().equals("Y");
			String doc_print_flag = checkForNull((String)fetchRecord(stSQL, doc_type_code).get("DOC_PRINT_FLAG"),"N");
            flag = doc_print_flag.equals("Y");
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
            String stKey = (String)iterator.next();
            String stValue = (String)hmReportParameter.get(stKey);
			sbParameter.append(stKey);
			sbParameter.append("=");
			sbParameter.append(stValue);
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
			String stReport_server = checkForNull((String)hmParameters.get("report_server"));
            String stReport_connect_string = checkForNull((String)hmParameters.get("report_connect_string"));
            String stExecutable_name = "";
            String stServer = "";
            String stCopies = "";
//            String stReport_mode = "";
            String stQueue_name = "";
//            String stReport_tool = "";
//            String stStatus = "";
            String stMessage = "";
            String stModule_id = (String)hmReportParameter.get("p_module_id");
            String stReport_id = (String)hmReportParameter.get("p_report_id");
            String stLocation_type = (String)hmParameters.get("location_type");
            String stLocation_code = (String)hmParameters.get("location_code");
            String stFacility_id = (String)hmReportParameter.get("p_facility_id");
            Properties properties = getProperties();
            String stClient_ip_address = checkForNull(properties.getProperty("client_ip_address"));
            String stReport_option = "P";
            String st_app_server_ip = "";

			connection = getConnection();
            
			//callableStatement = connection.prepareCall("{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
			callableStatement = connection.prepareCall("{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
            callableStatement.setString(1, stModule_id);
            callableStatement.setString(2, stReport_id);
            callableStatement.setString(3, stLocation_type);
            callableStatement.setString(4, stLocation_code);
            callableStatement.setString(5, stFacility_id);
            callableStatement.setString(6, stClient_ip_address);
            callableStatement.setString(7, stReport_option);
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.registerOutParameter(11, Types.VARCHAR);
            callableStatement.registerOutParameter(12, Types.VARCHAR);
            callableStatement.registerOutParameter(13, Types.VARCHAR);
            callableStatement.registerOutParameter(14, Types.VARCHAR);
            callableStatement.registerOutParameter(15, Types.VARCHAR);
            callableStatement.registerOutParameter(16, Types.VARCHAR);
			callableStatement.registerOutParameter(17, Types.VARCHAR); // changes for 37658
            callableStatement.execute();
            stExecutable_name = callableStatement.getString(8);
            stServer = callableStatement.getString(9);
            stCopies = callableStatement.getString(10);
	
//            stReport_mode = callableStatement.getString(11);
            stQueue_name = callableStatement.getString(12);
//            stReport_tool = callableStatement.getString(13);
//            stStatus = callableStatement.getString(14);
           stMessage = callableStatement.getString(15);
            st_app_server_ip = callableStatement.getString(16);
            stReport_server = "http://" + st_app_server_ip + stReport_server;
	
		System.err.println("stServer===>"+stServer+"=stCopies"+stCopies+"=stQueue_name"+stQueue_name+"=stMessage"+stMessage+"=st_app_server_ip"+st_app_server_ip+"=stReport_server"+stReport_server);

			if(stQueue_name.startsWith("\\\\\\\\")) {
                String s20 = stQueue_name.substring(4);
                int i = s20.indexOf("\\\\");
                String s21 = s20.substring(0, i);
                String s22 = s20.substring(i + 2);
                String s24 = "\\\\" + s21 + "\\" + s22;
                stQueue_name = s24;
            }

			sbURL.append(stReport_server);
			sbURL.append("?report=");
			sbURL.append(stExecutable_name);
			sbURL.append("+userid=");
			sbURL.append(stReport_connect_string);
			sbURL.append("+server=");
			sbURL.append(stServer);
			sbURL.append("+desname=");
			sbURL.append(stQueue_name);
			sbURL.append("+copies=");
			sbURL.append(stCopies);
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
			pstmt		= connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_SELECT_EXPIRY_WARNING_DAYS"));
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
		/*Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;*/

		HashMap SysdateMinusdays = new HashMap();

	
		try{
			 SysdateMinusdays = fetchRecord("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY')SYSTEMDATE , TO_CHAR(SYSDATE-7,'DD/MM/YYYY') SYSDATEMINUS7 FROM DUAL");
		   }

		catch(Exception e){
			e.printStackTrace();
		}
		finally {
                      try{
							/*closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);*/
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return SysdateMinusdays;
	}



//added for barcode implementation

public boolean isBarCodeApplicable(String facility_id, String trn_type)  throws Exception {
		
		String temp = "";
		String defaultvalue = "";
        boolean flag  = false;

        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_BARCODE_APPL");
          //  String stArray[] = { facility_id, trn_type };

			String stArray[] = {trn_type};

            //flag = fetchRecord(stSQL, stArray).get("BAR_CODE_YN").toString().equals("Y");

			temp = (String)fetchRecord(stSQL, stArray).get("BARCODE_APPL");
			//System.out.println("StTransaction temp==>"+temp);

			defaultvalue = "BARCODE_"+trn_type;

			//System.out.println("StTransaction defaultvalue==>"+defaultvalue);
			if (temp.equals(defaultvalue))
			flag  = true;


			//System.out.println("StTransaction flag==>"+flag);
			}
        catch(Exception exception) {
			flag  = false;
        }
        return flag;
    }



public boolean isBarCodeDefaultQtyApplicable(String facility_id, String trn_type)  throws Exception {
		
		//String temp = "";
		//String defaultvalue = "";
        boolean flag  = false;

        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_BARCODE_DFLTVAL_APPL");
           // String stArray[] = { facility_id, trn_type };
			String stArray[] = {trn_type};
            flag = fetchRecord(stSQL, stArray).get("BARCODE_APPL").toString().equals("DFLTVAL");

			//System.out.println("StTransaction default flag==>"+flag);

			}
        catch(Exception exception) {
			flag  = false;
        }
        return flag;
    }


public boolean isBarCodeEditQtyApplicable(String facility_id, String trn_type)  throws Exception {
		
		//String temp = "";
		//String defaultvalue = "";
        boolean flag  = false;

        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_BARCODE_EDITVAL_APPL");
           // String stArray[] = { facility_id, trn_type };
			 String stArray[] = {trn_type};
            flag = fetchRecord(stSQL, stArray).get("BARCODE_APPL").toString().equals("EDITVAL");

			//System.out.println("StTransaction edit flag==>"+flag);

			}
        catch(Exception exception) {
			flag  = false;
        }
        return flag;
    }



public boolean isCreateGRNApplicable(String facility_id, String trn_type)  throws Exception {
		
		//String temp = "";
		//String defaultvalue = "";
        boolean flag  = false;

        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_ADD_GRN_APPL");
            //String stArray[] = { facility_id, trn_type };
			String stArray[] = {trn_type};
            flag = fetchRecord(stSQL, stArray).get("BARCODE_APPL").toString().equals("ADDGRN");

			System.out.println("StTransaction grn flag==>"+flag);

			}
        catch(Exception exception) {
			flag  = false;
        }
        return flag;
    }



public ArrayList getBarCodeDetailArrayList(String bar_code , String store_code) throws Exception{ 
		
 		ArrayList BarCodeDetail = new ArrayList();
		
		
		try {
			System.out.println("StTransaction bar_code==>"+bar_code);

			String bar_code_new  = "%" + bar_code + "%";
			
			System.out.println("StTransaction bar_code_new==>"+bar_code_new);

			String stParameter[] = { bar_code_new, store_code };

			BarCodeDetail = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_SELECT_FOR_BAR_CODE"),stParameter);
				
	
				//System.out.println("StTransaction BarCodeDetail==>"+BarCodeDetail);
     
        } catch (Exception e) {
            e.printStackTrace();
        } 
		//System.out.println("StTransaction BarCodeDetail1==>"+BarCodeDetail);
		
	return BarCodeDetail ; 
}
		

public ArrayList getItemDetailArrayList(String language_id , String item_code,String store_code) throws Exception{ 
		
 		ArrayList ItemCodeDetail = new ArrayList();
		
		
		try {
			

			String stParameter[] = { language_id, item_code ,store_code};

			//System.out.println("StTransaction stParameter==>"+stParameter[0]+"-"+stParameter[1]);

			ItemCodeDetail = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_SELECT_FOR_BAR_CODE"),stParameter);
				
	
				//System.out.println("StTransaction ItemCodeDetail==>"+ItemCodeDetail);
     
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return ItemCodeDetail ; 
}

public ArrayList getBarCodeBatchDetailArrayList(String language_id,String bar_code) throws Exception{ 
		
 		ArrayList BarCodeDetail = new ArrayList();
		
		
		try {
			String stParameter[] = {language_id,bar_code};

			BarCodeDetail = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE"),stParameter);
				    
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return BarCodeDetail ; 
}

public ArrayList getBarCodeBatchDtlForSalesReturn(String language_id,String bar_code,String store_code) throws Exception{ 
		
 		ArrayList BarCodeDetail = new ArrayList();
		
		
		try {
			String stParameter[] = {language_id,bar_code,store_code};

			BarCodeDetail = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_DTL_EXP_SELECT_FOR_BAR_CODE"),stParameter);
				    
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return BarCodeDetail ; 
}

public ArrayList getBarCodeBatchDtlForIssueReturn(String language_id,String bar_code,String store_code) throws Exception{ 
		
 		ArrayList BarCodeDetail = new ArrayList();
		
		
		try {
			String stParameter[] = {language_id,bar_code,store_code};

			BarCodeDetail = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_EXP_SELECT_FOR_BAR_CODE"),stParameter);
				   
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return BarCodeDetail ; 
}

public HashMap getNewBarCodeRules(String facility_id) throws Exception{ 

		HashMap BarCodeRules = new HashMap();
		
		try {

			BarCodeRules = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_BARCODE_RULES_SELECT_FOR_BAR_CODE"),facility_id);
     
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return BarCodeRules ; 
}

public String getNewBarCode(String facility_id,String store_code,String item_code,String batch_id,String expiry_date,String trade_id,String binlocn_code,String manufacturer_id,String supplier_code,String mrp) throws Exception{ 

		HashMap BarCodeRules = new HashMap();
		String NewBarcodeId ="";
		
		try {
			BarCodeRules = getNewBarCodeRules(facility_id);

			String BarcodeRule = checkForNull((String)BarCodeRules.get("BARCODE_SEQ"));	
			
			StringTokenizer StBarcodeRules = new StringTokenizer(BarcodeRule,"-");	

			while (StBarcodeRules.hasMoreTokens()) {

				String temp = StBarcodeRules.nextToken();

				if(temp.equals("F"))
					NewBarcodeId = NewBarcodeId + facility_id;
				else if(temp.equals("I"))
					NewBarcodeId = NewBarcodeId + item_code;
				else if(temp.equals("B"))
					NewBarcodeId = NewBarcodeId + batch_id;
				else if(temp.equals("E"))
					NewBarcodeId = NewBarcodeId + expiry_date;
				else if(temp.equals("T"))
					NewBarcodeId = NewBarcodeId + trade_id;
				else if(temp.equals("BI"))
					NewBarcodeId = NewBarcodeId + binlocn_code;
				else if(temp.equals("MA"))
					NewBarcodeId = NewBarcodeId + manufacturer_id;
				else if(temp.equals("SU"))
					NewBarcodeId = NewBarcodeId + supplier_code;
				else if(temp.equals("S"))
					NewBarcodeId = NewBarcodeId + store_code;
				else if(temp.equals("MR"))
					NewBarcodeId = NewBarcodeId + mrp;
			}
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return NewBarcodeId; 
}

public boolean isBarCodeApplicableForValidation(String search_str , String trn_type) throws Exception{ 
		
	 	boolean flag  = false;	 	
	try {

		String stParameter[] = { trn_type , search_str  };

		String barcode_appl = (String)fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_BARCODE_VALIDATION_APPL"),stParameter).get("BARCODE_APPL");
		
		if(checkForNull(barcode_appl).equals(search_str))
			flag = true;
		
    } catch (Exception e) {
        e.printStackTrace();
        flag  = false;
    } 
return flag ; 
}
public boolean isBatchExistInSTItemBatch(String item_code,String store_code, String batch_id, String bin_location_code, String expiry_date_or_receipt_date) {
		
		ArrayList alParameters=	new ArrayList();
		//String stSQL=	"";

		try{
			alParameters.add(checkForNull(store_code));
			alParameters.add(checkForNull(item_code));			
			alParameters.add(checkForNull(batch_id));
			alParameters.add(checkForNull(bin_location_code));
			alParameters.add(checkForNull(expiry_date_or_receipt_date));
			HashMap hmRecord	=	fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"),alParameters);
			return	!hmRecord.get("COUNT").toString().equals("0");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}

//Added for GHL-CRF-0413 starts
public void setTempBatchRecords(ArrayList tempalBatchRecordsBarcode){
		this.tempalBatchRecordsBarcode=tempalBatchRecordsBarcode;
	}

	public ArrayList getTempBatchRecords(){
		return tempalBatchRecordsBarcode;
	}
	//Added for GHL-CRF-0413 ends
   public void setBatchRecords(ArrayList alBatchRecords){
		this.alBatchRecordsBarcode=alBatchRecords;
	}

	public ArrayList getBatchRecords(){
		return alBatchRecordsBarcode;
	}
	
	public int getNextDoc_srl_noforBarCode(){
		return ++doc_srl_noforBarCode;
	}

	public void setNextDoc_srl_noforBarCode(int doc_srl_noforBarCode){
		this.doc_srl_noforBarCode =  doc_srl_noforBarCode;
	}
	
	public void updateDtlRecordforBarCode(int index, HashMap hmDtlRecord){
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		if (index!=-1){
			mode	=	(String)((HashMap)alDtlRecordsforBarCode.get(index)).get("mode");
		}
		else if (hmDtlRecord.containsKey("mode")){
			mode = (String)hmDtlRecord.get("mode");
		}
		hmDtlRecord.put("mode",mode);
		
		if (index==-1){
			if (hmDtlRecord.get("ADD").equals("YES"))
			{
			int pdoc_srl_no =  Integer.parseInt((String)hmDtlRecord.get("doc_srl_no"));
			--pdoc_srl_no;

			if(hmDtlRecord.containsKey("query_srl_no") && !((String)hmDtlRecord.get("query_srl_no")).equals(""))
				pdoc_srl_no = Integer.parseInt((String)hmDtlRecord.get("query_srl_no"));
			
			alDtlRecordsforBarCode.set(pdoc_srl_no, hmDtlRecord);

			}
			else{
			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_noforBarCode());
			if(alDtlRecordsforBarCode==null)
			alDtlRecordsforBarCode = new ArrayList();
			alDtlRecordsforBarCode.add(hmDtlRecord);
			}
		}
		else
			alDtlRecordsforBarCode.set(index, hmDtlRecord);
	} 

	public HashMap getDtlRecordforBarCode(int index){
		return (HashMap)alDtlRecordsforBarCode.get(index);
	}

	public ArrayList getDtlRecordsforBarCode(){
		return alDtlRecordsforBarCode;
	}
public void setScannedbatchdtl(String batch_id)// added for GHL-CRF-0465
{
	if(batchDtl==null){//newly added
		batchDtl = new ArrayList();
		}
		this.batchDtl.add(batch_id);
	
}
public ArrayList getScannedbatchdtl(){
	return batchDtl;
}// end  for GHL-CRF-0465
	
	//used only for modify
	public void setalDtlRecordsforBarCode(HashMap alDtlRecords){
		if(alDtlRecordsforBarCode==null){//newly added
		alDtlRecordsforBarCode = new ArrayList();
		}
		this.alDtlRecordsforBarCode.add(alDtlRecords);
	}
	
	public void setalDtlRecordsforBarCode(int index ,HashMap alDtlRecords){
		if(alDtlRecordsforBarCode==null){//newly added
		alDtlRecordsforBarCode = new ArrayList();
		}
		this.alDtlRecordsforBarCode.set(index,alDtlRecords);
	}
	


	public void setAddBatchRecords(ArrayList AddBatchRecords){
		if(AddBatchRecords==null){//newly added
		AddBatchRecords = new ArrayList();
		}
		this.AddBatchRecords = (ArrayList)AddBatchRecords;
	}
	
	public ArrayList getAddBatchRecords(){
		return AddBatchRecords;
	}



	public void updateExpRecordsforBarCode(int index, Hashtable htExpRecords){
		if (index==-1) {
			index	=	alDtlRecordsforBarCode.size()-1;
		}
		ArrayList alExpRecords	=	(ArrayList)hmExpRecordsforBarCode.get(""+index);

		System.out.println("alExpRecords=====1095"+alExpRecords);
		System.out.println("index=====1095"+index);

		int total_checkboxes = Integer.parseInt((String)htExpRecords.get("total_checkboxes"));
		int pindex = Integer.parseInt((String)htExpRecords.get("pindex"));

	for (int i= 0;i< total_checkboxes; i++) { 

		for (int j= 0;j < alExpRecords.size(); j++) {

			HashMap hmExpRecord	=	(HashMap)alExpRecords.get(j);
			
			if (hmExpRecord.get("BATCH_ID").equals(htExpRecords.get("batch_id_"+i)) &&  hmExpRecord.get("EXPIRY_DATE").equals(htExpRecords.get("expiry_date_or_receipt_date_"+i))	&& 	hmExpRecord.get("BIN_LOCATION_CODE").equals(htExpRecords.get("bin_location_code_"+i)) &&  hmExpRecord.get("TRADE_ID").equals(htExpRecords.get("trade_id_"+i)) )
			{	
				if (pindex==-1  &&  hmExpRecord.containsKey("QTY")){
					float qty= 0;
					if(((String)htExpRecords.get("item_qty_"+i)!="" || (String)htExpRecords.get("item_qty_"+i)!= null) && hmExpRecord.containsKey("KIT")){
						 qty = Float.parseFloat(checkForNull((String)hmExpRecord.get("QTY"),"0"));
						 hmExpRecord.remove("KIT");
					}
					else if((String)htExpRecords.get("item_qty_"+i)!="" || (String)htExpRecords.get("item_qty_"+i)!= null){
						 qty = Float.parseFloat(checkForNull((String)hmExpRecord.get("QTY"),"0")) +  Float.parseFloat(checkForNull((String)htExpRecords.get("item_qty_"+i),"0")); 
					}
					else{
						 qty = Float.parseFloat((String)hmExpRecord.get("QTY"));
					}
				hmExpRecord.put("QTY",	""+qty);
				}
				else{
				hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
				}
			}
		}
	}
	
		for(int i=0;i<alExpRecords.size();)
		{	

			if(!((HashMap)alExpRecords.get(i)).containsKey("QTY")){
					HashMap hmAldtlData = (HashMap)alDtlRecordsforBarCode.get(index);
					int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));
					--batch_records;
					hmAldtlData.put("batch_records",""+batch_records);
					alDtlRecordsforBarCode.set(index,hmAldtlData);
					alExpRecords.remove(i); 
			}else{

				if(  ((String)((HashMap)alExpRecords.get(i)).get("QTY")).equals("")   )
				 {	
					HashMap hmAldtlData = (HashMap)alDtlRecordsforBarCode.get(index);
					int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));
					--batch_records;
					hmAldtlData.put("batch_records",""+batch_records);
					alDtlRecordsforBarCode.set(index,hmAldtlData);
					alExpRecords.remove(i); 
					
				}
				else 
					i++;
			}
		}
		setExpRecordsforBarCode(index, alExpRecords);
	}

	public void setExpRecordsforBarCode(int index, ArrayList alExpRecords){
		if (index==-1) {
			if(alDtlRecordsforBarCode==null)
			index	=	0;
			else
			index = alDtlRecordsforBarCode.size();
		}
		if(hmExpRecordsforBarCode==null){
		hmExpRecordsforBarCode = new HashMap();
		System.out.println("hmExpRecordsforBarCode 1041==>"+hmExpRecordsforBarCode);
		}
		hmExpRecordsforBarCode.put(""+index,alExpRecords);
	}
	

	public ArrayList getExpRecordsforBarCode(int index){
		return (ArrayList)hmExpRecordsforBarCode.get(""+index);
	}

	public HashMap getExpRecordsforBarCode(){
		return hmExpRecordsforBarCode;
	}

	


	public void setBarcodeApplicable(String BarcodeApplicable) {
		 this.BarcodeApplicable= checkForNull(BarcodeApplicable,"N");  
	}

	public String getBarcodeApplicable() {
		 return BarcodeApplicable;
	}

	public void setBarcodeDefaultQtyAppl(String BarcodeDefaultQtyAppl) {
		 this.BarcodeDefaultQtyAppl= checkForNull(BarcodeDefaultQtyAppl,"N");  
	}

	public String getBarcodeDefaultQtyAppl() {
		 return BarcodeDefaultQtyAppl;
	}

	public void setBarcodeEditQtyAppl(String BarcodeEditQtyAppl) {
		 this.BarcodeEditQtyAppl= checkForNull(BarcodeEditQtyAppl,"N");  
	}

	public String getBarcodeEditQtyAppl() {
		 return BarcodeEditQtyAppl;
	}



	public void setRecords_to_delete_for_barcode(String records_to_delete_for_barcode) {
		 this.records_to_delete_for_barcode= records_to_delete_for_barcode;
	}

	public String getRecords_to_delete_for_barcode() {
		 return records_to_delete_for_barcode;
	}



	public String getSalePrice(String login_facility_id,String episode_type,String item_code,String trade_id,String batch_id) throws Exception{
	
	HashMap SalesPrice = new HashMap();
	String  sale_price = null; 
	
	 	
	try{
			String stParameter[] = {login_facility_id,episode_type,item_code,trade_id ,batch_id};
			SalesPrice = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),stParameter);
			        
			sale_price	 =  (String)SalesPrice.get("MRP_PRICE");
			if(sale_price == null || sale_price.equals("Error No-->BL9647") || sale_price.equals("Error No-->BL9646"))
			sale_price = "0.00";						
				
	}
    catch(Exception exception){
           	exception.printStackTrace();
    }
        
        return sale_price;
    }

	public HashMap getROL1(String item_code,String store_code){
		HashMap hmRecord = null;
		ArrayList arr = new ArrayList();
		arr.add(item_code);
		arr.add(store_code);
		try{
		hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_STOCK_TRANSFER_ROL"),arr);
		}catch(Exception e){
			e.printStackTrace() ;
		}
		
		return hmRecord;
	}


	public void updateMinMaxRecordsforBarcode(int index, HashMap hmMinMaxRecord){        // Min Max Validation by Rammohan.C 11/8/2006
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");

		if (index!=-1){
			mode	=	(String)((HashMap)alMinMaxRecordsforBarcode.get(index)).get("mode");
		}
		hmMinMaxRecord.put("mode",mode);		
		if (index==-1){
			alMinMaxRecordsforBarcode.add(hmMinMaxRecord);
		}
		else {
			alMinMaxRecordsforBarcode.set(index, hmMinMaxRecord);
		}
	}

	public HashMap getMinMaxRecordforBarcode(int index){	
		return (HashMap)alMinMaxRecordsforBarcode.get(index);
	}

	public ArrayList getMinMaxRecordsforBarcode(){
		return alMinMaxRecordsforBarcode;
	}

	public void setMinMaxRecordsforBarcode(HashMap hmMinMaxRecord){
		this.alMinMaxRecordsforBarcode.add(hmMinMaxRecord);
	}


	public String getDefaultIssueUOMforBarcode(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
		}
		
		if(default_uom.size() > 0)
			default_value = (String)default_uom.get("DEF_ISSUE_UOM");

		return default_value;

	}
	
	public ArrayList getPur_uom_code_ListforBarcode(String parameters,String item_code) throws Exception{
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
		return result;
	}




	/*public String setNumber(String stNumber, int decimalPlaces){
		String returnNumber	=	"0";
		try { 
		String fmt = "0";
		for(int i=0;i<decimalPlaces;i++){
			if(i==0)
				fmt+=".";
			fmt+="0";
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		returnNumber = df.format(Double.parseDouble(stNumber));
				}
		catch (Exception exception) {
		//	exception.printStackTrace();
		}
		return returnNumber;
	}*/

/*public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();

		try {
		
		    alParameters.add(item_code);
			alParameters.add(store_code);

		   conv_fac_temp=Double.parseDouble((String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"));
		}	catch(Exception e){
			//e.printStackTrace();
		}
		return conv_fac_temp;
	}*/
	
	//Added by Rabbani #Inc no:30909 on 12/03/12
	//Starts
	public HashMap getDurationforStartDate() throws Exception{
	 
			  HashMap DurationforStartDate = new HashMap();
		try{	 
			DurationforStartDate =    fetchRecord("SELECT  NVL(DURN_FOR_START_DATE,0)DURN_FOR_START_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY')SYSTEMDATE ,TO_CHAR(SYSDATE-NVL(DURN_FOR_START_DATE,0), 'DD/MM/YYYY') DURATIONFORSTARTDATE  FROM  ST_FACILITY_PARAM   WHERE FACILITY_ID = ? ",getLoginFacilityId());	  	
		   }catch(Exception e){
			e.printStackTrace();
		  }
		  return DurationforStartDate;
		
	  }
//ends

public  String getLastCostforBarcode  (String item_code){
		
		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_LAST_COST_SELECT_FOR_ADJ"),item_code);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("LAST_COST");
	}
//Added By Sakti Sankar on 06/03/2013 against Inc# 
//Commented by ganga 
	/*public  String getNoOfCopies  (String reportid){
		String []stParameters=	{reportid,"ST"};
		HashMap hmResult =new HashMap();

		try {
			//hmResult = fetchRecord(getStRepositoryValue("SQL_SM_NO_OF_COPIES_SELECT_FOR_PRINT"),stParameters); GHL-SCF-732 [IN:039503] Repository having new CRF's query.
			hmResult = fetchRecord("select no_of_copies from sm_print_routing where report_id= ? and module_id= ? and rownum<=1" ,stParameters);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("NO_OF_COPIES");
	}*/

//Added by suresh.r on 23-01-2014 against AMS-CRF-0054 beg
	public String getIssueRetBasedOn() {
		HashMap hashmap=null;
		String iss_ret_based_on="";
      try{
      	 hashmap= fetchRecord(getStRepositoryValue("SQL_ST_ISS_RET_BASED_ON_SELECT"), getLoginFacilityId());
      	 iss_ret_based_on=checkForNull((String)hashmap.get("ISS_RET_BASED_ON"),"D");
      }
      catch(Exception exception){
          exception.printStackTrace();
      }
      return iss_ret_based_on;
  }
	//Added by suresh.r on 23-01-2014 against AMS-CRF-0054 end
	
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014  Starts
	public boolean getMin_Rol_yn(String user_id,String store_code) {
		ArrayList alParameters = new ArrayList();
		String disp_min_rol_yn = "N";
		try {
		           alParameters.add(user_id);
		           alParameters.add(store_code);
		       //disp_min_rol_yn= (String)fetchRecord("SELECT DISP_MIN_ROL_YN FROM st_user_access_for_store WHERE USER_ID = ? AND STORE_CODE = ?",alParameters).get("DISP_MIN_ROL_YN");
		       //Modified by suresh.r on 30-10-2014 against Inc 52170
	           disp_min_rol_yn= checkForNull((String)fetchRecord("SELECT DISP_MIN_ROL_YN FROM st_user_access_for_store WHERE USER_ID = ? AND STORE_CODE = ?",alParameters).get("DISP_MIN_ROL_YN"),"N");
			}catch(Exception e){
				disp_min_rol_yn = "N";
			}
			return disp_min_rol_yn.equals("Y");
		}
		//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
		public boolean getReq_allowed_yn(String user_id,String store_code) {
			String req_allowed_yn= "N";
	        try{
	        	String stParameters[]={user_id,store_code};
	        	 req_allowed_yn = checkForNull((String)fetchRecord("select  REQ_ALLOWED_YN  from  ST_USER_ACCESS_FOR_STORE where user_id=? and store_code=?",stParameters).get("REQ_ALLOWED_YN"),"N");
	        	}
	        catch(Exception e){
	            e.printStackTrace();
				req_allowed_yn = "N";
	        }
	        return req_allowed_yn.equals("Y");
	    }
		//ends
//Adding start for MO-CRF-20166
	public String getIssueHistoryDurn(){
		String issue_history_durn = "";
		try{
			issue_history_durn = (String)fetchRecord("SELECT DURN_FOR_ISS_HISTORY FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("DURN_FOR_ISS_HISTORY");
		}catch(Exception e){
			e.printStackTrace();
		}
		return issue_history_durn;
	}

	public String getStoreDesc(String store_code) {
		String store_desc ="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
			store_desc=fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT") ,arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return store_desc;
    }//Adding end for MO-CRF-20166
//Adding start for MMS-DM-CRF-0174.5 and 174.6
public String barcode2DApplicable(){
			Connection connection	 = null;
			String barcode_2d_applicable_yn ="N";
			boolean is_2d_barcode_appl = false;
			HashMap siteValues =new HashMap();
			String include_exp_date_yn ="N";
        try {
			connection = getConnection();
		
		         is_2d_barcode_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","2D_BARCODE_APPLICABLE");	
				 System.out.println("is_2d_barcode_appl=="+is_2d_barcode_appl);

		if(is_2d_barcode_appl)
			barcode_2d_applicable_yn ="Y";
		if(barcode_2d_applicable_yn.equals("Y")){
                  siteValues =eCommon.Common.CommonBean.getSiteSpecificDetails(connection, "ST","2D_BARCODE_APPLICABLE");	

				  if(siteValues.containsKey("key1"))
					  include_exp_date_yn =(String)siteValues.get("value1");
		}
		 setIncludeExpiryDate(include_exp_date_yn);

		}catch(Exception exception ) {
			exception.printStackTrace();
		}
		return barcode_2d_applicable_yn;
	}

	public String get2DBarcodeItem(String store_code,String barcode_id)throws Exception{//Added for MMS-DM-CRF-0174.5

     String barcode_item ="";
	 String includ_expiry_date =getIncludeExpiryDate();//Added for MOHE-CRF-0167
	 String sql_str = "";//Added for MOHE-CRF-0167
	 HashMap BatchDetails = new HashMap();
	 String gtin = "";
     String batchNumber = "";
     String expiryDate = "";
	 String srlNo ="";
	  store_code =checkForNull(store_code);
            includ_expiry_date =checkForNull(includ_expiry_date);

	   try{
		   
		    //String barcodeData =barcode_id.replace("[GS]","_");
			//barcodeData =barcode_id.replace("[GS]","_");

		BatchDetails =getBarcodedetails(barcode_id);
		gtin =(String)BatchDetails.get("GTIN");
		expiryDate =checkForNull((String)BatchDetails.get("EXPIRY_DATE"));
		batchNumber =(String)BatchDetails.get("BATCH_ID");
		srlNo =(String)BatchDetails.get("SRLNO");
        String temp_exp_date ="";
  if(!expiryDate.equals("")){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yymmdd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date inputDate = inputFormat.parse(expiryDate); 

		 temp_exp_date = outputFormat.format(inputDate);
        System.out.println("new temp_exp_date: "+temp_exp_date); 
  }
		
			
		System.err.println("getIncludeExpiryDate@@==="+includ_expiry_date);
		 if(!store_code.equals(""))
		     sql_str  = " AND store_code = ? ";//Adding end for MOHE-CRF-0167
		if(includ_expiry_date.equals("Y"))
		     sql_str  = sql_str + " AND EXPIRY_DATE=to_date(?,'dd/mm/yyyy') ";//Adding end for MOHE-CRF-0167
		
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(checkForNull(batchNumber));
			if(!store_code.equals(""))
			   alParameters.add(checkForNull(store_code));
			if(includ_expiry_date.equals("Y"))//Added for MOHE-CRF-0167
				alParameters.add(checkForNull(temp_exp_date));
			alParameters.add(checkForNull(gtin));
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			
		
             barcode_item =	checkForNull((String)fetchRecord("SELECT ITEM_CODE FROM ST_BATCH_SEARCH_LANG_VIEW  WHERE	BATCH_ID=?	"+sql_str+" AND	  MANUFACTURER_ID =? AND language_id =? AND lang1 =? AND lang2 = ?",alParameters).get("ITEM_CODE"));
           
	   }
		catch (Exception exception) {
			System.out.println("Exception thrown from get2DBarcodeItem = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		 }

		 return barcode_item;
}

public ArrayList get2DBarcodeBacthes(String store_code,String barcode_id)throws Exception{//Added for MMS-DM-CRF-0174.5

 System.out.println("@@Inside get2DBarcodeBacthes Transaction.java file==="+barcode_id);    
	 
	 Connection connection	 = null;
	 PreparedStatement pstm = null;
     ResultSet resultSet		  = null;
	 HashMap hmRecord					=	new HashMap();
	 ArrayList barcode2dDetail = new ArrayList(); 
	 String sql = "";//Added for MOHE-CRF-0167
	 String includ_expiry_date =getIncludeExpiryDate();//Added for MOHE-CRF-0167
	 HashMap BatchDetails = new HashMap();
	 String gtin = "";
     String batchNumber = "";
     String expiryDate = "";
	 String srlNo ="";
     store_code =checkForNull(store_code);
     includ_expiry_date =checkForNull(includ_expiry_date); 
	   try{
          connection = getConnection();
		 
		BatchDetails =getBarcodedetails(barcode_id);
		gtin =(String)BatchDetails.get("GTIN");
		expiryDate =checkForNull((String)BatchDetails.get("EXPIRY_DATE"));
		batchNumber =(String)BatchDetails.get("BATCH_ID");
		srlNo =(String)BatchDetails.get("SRLNO");
        String temp_exp_date ="";
        if(!expiryDate.equals("")){
		SimpleDateFormat inputFormat = new SimpleDateFormat("yymmdd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date inputDate = inputFormat.parse(expiryDate); 

		 temp_exp_date = outputFormat.format(inputDate);
	}
          

		String sql_str = "";
		if(!store_code.equals(""))
		     sql_str  = " AND store_code = ? ";//Adding end for MOHE-CRF-0167
		if(includ_expiry_date.equals("Y"))
		     sql_str  = sql_str+" AND EXPIRY_DATE=to_date(?,'dd/mm/yyyy') ";//Adding end for MOHE-CRF-0167
			
		sql   = "SELECT BARCODE_ID,ITEM_CODE,STORE_CODE,BATCH_ID,BIN_LOCATION_CODE, to_char(EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE,TRADE_ID,NVL(QTY_ON_HAND,0) QTY_ON_HAND,AVAIL_QTY,SUSPENDED_YN, ITEM_DESC, STORE_DESC, TRADE_ID_APPLICABLE_YN, BIN_DESC, TRADE_NAME, NOD, MANUFACTURER_ID, MANUFACTURER_NAME, EXPIRY_YN , BATCH_STATUS FROM ST_BATCH_SEARCH_LANG_VIEW WHERE BATCH_ID = ? AND MANUFACTURER_ID =? "+sql_str+"  AND LANGUAGE_ID =? AND LANG1 =? AND LANG2 = ? ";
 
          pstm = connection.prepareStatement(sql);			
		pstm.setString(1, checkForNull(batchNumber));
		pstm.setString(2, checkForNull(gtin));
if(!store_code.equals("")){
		pstm.setString(3, store_code);
        
    if(includ_expiry_date.equals("Y")){//Added for MOHE-CRF-0167
        pstm.setString(4, temp_exp_date);
	    pstm.setString(5, getLanguageId());
		pstm.setString(6, getLanguageId());
		pstm.setString(7, getLanguageId());
 }else{
		pstm.setString(4, getLanguageId());
		pstm.setString(5, getLanguageId());
		pstm.setString(6, getLanguageId());
       }
 }else{
	    
		 if(includ_expiry_date.equals("Y")){//Added for MOHE-CRF-0167
				pstm.setString(3, temp_exp_date);
				pstm.setString(4, getLanguageId());
				pstm.setString(5, getLanguageId());
				pstm.setString(6, getLanguageId());
		 }else{
				pstm.setString(3, getLanguageId());
				pstm.setString(4, getLanguageId());
				pstm.setString(5, getLanguageId());
		 }
 }
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
         
			hmRecord.put("BARCODE_ID",barcode_id);
			hmRecord.put("ITEM_CODE", resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE")); 
			hmRecord.put("STORE_CODE", resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE")); 
			hmRecord.put("BATCH_ID", resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID")); 
			hmRecord.put("BIN_LOCATION_CODE", resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE")); 
			hmRecord.put("EXPIRY_DATE", resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE")); 
			hmRecord.put("TRADE_ID", resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID")); 
			hmRecord.put("QTY_ON_HAND", resultSet.getString("QTY_ON_HAND")==null?"":resultSet.getString("QTY_ON_HAND")); 
			//hmRecord.put("COMMITTED_QTY", resultSet.getString("COMMITTED_QTY")==null?"":resultSet.getString("COMMITTED_QTY")); 
			hmRecord.put("AVAIL_QTY", resultSet.getString("AVAIL_QTY")==null?"":resultSet.getString("AVAIL_QTY")); 
			hmRecord.put("SUSPENDED_YN", resultSet.getString("SUSPENDED_YN")==null?"":resultSet.getString("SUSPENDED_YN")); 
			hmRecord.put("ITEM_DESC", resultSet.getString("ITEM_DESC")==null?"":resultSet.getString("ITEM_DESC")); 
			hmRecord.put("STORE_DESC", resultSet.getString("STORE_DESC")==null?"":resultSet.getString("STORE_DESC")); 
			hmRecord.put("TRADE_ID_APPLICABLE_YN", resultSet.getString("TRADE_ID_APPLICABLE_YN")==null?"":resultSet.getString("TRADE_ID_APPLICABLE_YN")); 
			hmRecord.put("BIN_DESC", resultSet.getString("BIN_DESC")==null?"":resultSet.getString("BIN_DESC")); 
			hmRecord.put("TRADE_NAME", resultSet.getString("TRADE_NAME")==null?"":resultSet.getString("TRADE_NAME")); 
			hmRecord.put("NOD", resultSet.getString("NOD")==null?"":resultSet.getString("NOD")); 
			hmRecord.put("MANUFACTURER_ID", resultSet.getString("MANUFACTURER_ID")==null?"":resultSet.getString("MANUFACTURER_ID")); 
			hmRecord.put("MANUFACTURER_NAME", resultSet.getString("MANUFACTURER_NAME")==null?"":resultSet.getString("MANUFACTURER_NAME")); 
			hmRecord.put("EXPIRY_YN", resultSet.getString("EXPIRY_YN")==null?"":resultSet.getString("EXPIRY_YN")); 
			hmRecord.put("BATCH_STATUS", resultSet.getString("BATCH_STATUS")==null?"":resultSet.getString("BATCH_STATUS")); 
             set2dBarcodeItems(resultSet.getString("ITEM_CODE")+"~"+resultSet.getString("BATCH_ID"),barcode_id);
			barcode2dDetail.add(hmRecord);  
		}
           
	   }
		catch (Exception exception) {
			System.out.println("Exception thrown from get2DBarcodeBacthes = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
	} 
	finally { //Common-ICN-0091
		closeResultSet(resultSet);
		closeStatement(pstm);
		closeConnection(connection);
	}
		 return barcode2dDetail;
   }//Adding end for MMS-DM-CRF-0174.5 and 174.6

   public String getGTINItem(String barcode_id)throws Exception{//Added for MOHE-CRF-0167

    HashMap BatchDetails = new HashMap();
	String  gtin         = ""; 
	String  gtin_item         = ""; 
	
	BatchDetails =getBarcodedetails(barcode_id);
		gtin =(String)BatchDetails.get("GTIN")==null?"":(String)BatchDetails.get("GTIN");
     
	   try{
       
			ArrayList alParameters	=	new ArrayList(4);
			
			alParameters.add(checkForNull(gtin));
			
             gtin_item =	checkForNull((String)fetchRecord("SELECT B.ITEM_CODE FROM AM_TRADE_NAME A, MM_TRADE_NAME_FOR_ITEM B WHERE MANUFACTURER_ID = ? AND A.TRADE_ID = B.TRADE_ID",alParameters).get("ITEM_CODE"));

	   }
		catch (Exception exception) {
			System.out.println("Exception thrown from get2DBarcodeItem = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		 }

		 return gtin_item;

   }//Adding end for MOHE-CRF-0167

   public int getGTINItemCount(String barcode_id)throws Exception{//Added for MOHE-CRF-0167

      HashMap BatchDetails = new HashMap();
	  String  gtin         = ""; 
	  String gtin_item     = "";
	  
	  BatchDetails =getBarcodedetails(barcode_id);
	  gtin =(String)BatchDetails.get("GTIN")==null?"":(String)BatchDetails.get("GTIN");
	 int count=0;
	 
     
	   try{
        
       
			ArrayList alParameters	=	new ArrayList(4);
			
			alParameters.add(checkForNull(gtin));
			
             count =	Integer.parseInt(checkForNull((String)fetchRecord("SELECT COUNT(*)GTIN_COUNT FROM AM_TRADE_NAME A, MM_TRADE_NAME_FOR_ITEM B WHERE MANUFACTURER_ID = ? AND A.TRADE_ID = B.TRADE_ID",alParameters).get("GTIN_COUNT")));

	   }
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		 }

		 return count;

   }//Adding end for MOHE-CRF-0167


}

