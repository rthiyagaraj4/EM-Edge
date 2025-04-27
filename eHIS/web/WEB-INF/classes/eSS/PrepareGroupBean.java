/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Prepare Group
*/
package eSS;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.* ;
import javax.servlet.http.*;
import java.util.Hashtable;
import java.util.*;
import javax.servlet.ServletException;
import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eSS.PrepareGroup.PrepareGroupHome;
import eSS.PrepareGroup.PrepareGroupRemote;
import ecis.utils.OnlineReport;


public class PrepareGroupBean extends eSS.Common.SsTransaction implements java.io.Serializable {

	private String doc_ref;
	private String trn_type;
	private String prepare_qty;
	private String store_code;
	private String group_code;
	private String group_desc;
	private String total_cost;
	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String bin_location_code;
	private String facility_id;
	private String tray_no;
	private String finalized_yn;
	private boolean isAutoNo;
	private String acc_entity_id;
	private HttpSession session;
	private ArrayList selectedList;
	private ArrayList ModifySelectedList;
	private ArrayList DataList=new ArrayList();
	private HashMap dataList = new HashMap();
	private String records_to_process = "";
	private ArrayList alSelectedDetails;
	private ArrayList alModifyRecord;

	public PrepareGroupBean() { 
		selectedList	  =	new ArrayList();
		ModifySelectedList	  =	new ArrayList();
		alSelectedDetails = new ArrayList();
		alModifyRecord = new ArrayList();
	}
public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() { 
		 return session;
	}

	/* For default Values ! */
	private String defaultDocType = "";
	private String defaultStoreCode = "";
	private String defaultBinlocnCode = "";
	public void setDefaultDocType (String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}

	public String getDefaultDocType () {
		return this.defaultDocType;
	}

	public void setDefaultStoreCode (String defaultStoreCode) {
		this.defaultStoreCode = defaultStoreCode;
	}

	public String getDefaultStoreCode() {
		return this.defaultStoreCode;
	}
	
	public void setDefaultBinlocnCode (String defaultBinlocnCode) {
		this.defaultBinlocnCode = defaultBinlocnCode;
	}

	public String getDefaultBinlocnCode() {
		return this.defaultBinlocnCode;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref() {
		 return doc_ref;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no;
	}

	public String getTray_no() {
		 return tray_no;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
	}

	public void setPrepare_qty(String prepare_qty) {
		 this.prepare_qty = prepare_qty;
	}

	public String getPrepare_qty() {
		 return prepare_qty;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}

	public void setGroup_code(String group_code) {
		 this.group_code = group_code;
	}
	
	public void setGroup_desc(String group_desc) {
		 this.group_desc = group_desc;
	}

	public String getGroup_code() {
		 return group_code;
	}

	public String getGroup_desc() {
		 return group_desc;
	}

	public void setTotal_cost(String total_cost) {
		 this.total_cost = total_cost;
	}

	public String getTotal_cost() {
		 return total_cost;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}
	
	public String getDoc_date() {
		return doc_date;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = bin_location_code;
	}

	public String getBin_location_code() {
		 return bin_location_code;
	}

	public void setFacility_id(String facility_id) {
		 this.facility_id = facility_id;
	}

	public String getFacility_id() {
		 return facility_id;
	}

	public void setFinalized_yn(String finalized_yn) {
		this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn() {
		return this.finalized_yn;
	}

	public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;	
	}
	
	public String getAcc_entity_id(){
		return this.acc_entity_id;
	}
		
	

// added By Sakti Sankar against BRU-HIMS-CRF-370
	public String getRecords_to_process() {
		return records_to_process;
	}

	public void setRecords_to_process(String records_to_process) {
		this.records_to_process = records_to_process;
	}

	public ArrayList getDataList(){ 
		return DataList ;
	}

	public void setDataList(ArrayList DataList){
		this.DataList = DataList;	
	}

	public ArrayList getSelectedList(){
		return selectedList ;
	}
	public void setSelectedList(ArrayList selectedList){
		this.selectedList = selectedList;
	}
	
	public ArrayList getModifySelectedList(){
		return ModifySelectedList ;
	}
	public void setModifySelectedList(ArrayList ModifySelectedList){
		this.ModifySelectedList = ModifySelectedList;
	}
	
	public void selectedBatches(Hashtable htTrays)
	{
					
			int i=0;
			StringTokenizer st=new StringTokenizer ((String)htTrays.get("index"),"!");
			while(st.hasMoreTokens()) 
			{
				i=Integer.parseInt(st.nextToken());
				
				dataList = new HashMap();
				dataList.put("GROUP_CODE",(String)htTrays.get("group"+i));
				dataList.put("GROUP_DESC",(String)htTrays.get("desc"+i));
				dataList.put("mode","1");
				
				if (! isAlreadySelected((String)htTrays.get("group"+i))) {

					selectedList.add(dataList);
					alSelectedDetails.add((String)htTrays.get("group"+i));
					
				}
				
			}
			
			
			int j=0;
			StringTokenizer ss=new StringTokenizer ((String)htTrays.get("unchecked_index"),"!");
			while(ss.hasMoreTokens()) 
			{
				j=Integer.parseInt(ss.nextToken());
				
				dataList = new HashMap();
				dataList.put("GROUP_CODE",(String)htTrays.get("group"+j));
				dataList.put("GROUP_DESC",(String)htTrays.get("desc"+j));
				dataList.put("mode","1");
							
				
					alSelectedDetails.remove((String)htTrays.get("group"+j));
					selectedList.remove(dataList);
						
			}
}
		//Added against inc#42370
		public void setAlSelectedTrayDetails(String group_code){
			alSelectedDetails.add(group_code);
		}//Added ends
	
		public ArrayList getAlSelectedTrayDetails() { 
			return alSelectedDetails;
		}

		public boolean isAlreadySelected(String groupCode_desc) {
			return alSelectedDetails.contains(groupCode_desc);
		}
		
		public boolean isModifyRecord(String groupCode_groupDesc) {
			return alModifyRecord.contains(groupCode_groupDesc);
		}
//Added ends
	public void clear(){
		super.clear();
		this.doc_ref="";          
		this.trn_type="";         
		this.prepare_qty="";      
		this.store_code="";       
		this.group_code="";       
		this.group_desc="";       
		this.total_cost="";       
		this.doc_type_code="";    
		this.doc_no="";           
		this.bin_location_code="";
		this.facility_id="";      
		this.tray_no="";          
		this.finalized_yn=""; 
		
		if (selectedList!=null) {
			selectedList.clear();
		}
		if (alSelectedDetails!=null) {
			alSelectedDetails.clear();
		}
		if (alModifyRecord!=null) {
			alModifyRecord.clear();
		}
		
	}
	
	public void initialize(){
		super.initialize();
		selectedList=new ArrayList();
		alSelectedDetails = new ArrayList();
		alModifyRecord = new ArrayList();
	}
	public void setAll(Hashtable htRecordSet) {
	
		setMode((String) htRecordSet.get("mode"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setTrn_type((String) htRecordSet.get("trn_type"));
		//setPrepare_qty((String) htRecordSet.get("prepare_qty"));
		setStore_code((String) htRecordSet.get("store_code"));
		//setGroup_code((String) htRecordSet.get("group_code"));
		//setTotal_cost((String) htRecordSet.get("total_cost"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setRecords_to_process((String) htRecordSet.get("records_to_process"));//Added by Sakti against BRU-HIMS_CRF-370
		/*if (htRecordSet.get("bin_location_code") == null) {
			setBin_location_code("");
		}
		else {
			setBin_location_code((String) htRecordSet.get("bin_location_code"));
		}*/
		setFacility_id((String) htRecordSet.get("facility_id"));
		setFinalized_yn(htRecordSet.get("finalize_yn").equals(eSS.Common.SsRepository.getSsKeyValue("YES"))?"Y":"N");
		setIsAutoNo(htRecordSet.get("autono_yn").equals(eSS.Common.SsRepository.getSsKeyValue("YES"))?true:false);

		//setGroup_desc((String) htRecordSet.get("group_desc"));
	}
	
	public String getDocTypes() {
		String optionValues = null;
		//Get the default Document Type Code for the given Document Type
		ArrayList alPrepareGroupDoc = new ArrayList(5);
		ArrayList alOptionValues = new ArrayList();
		alPrepareGroupDoc.add(login_facility_id);
		alPrepareGroupDoc.add("PRE");
		alPrepareGroupDoc.add(getLanguageId());
		//Changed from SQL_SS_PREPARE_GROUP_DOC_TYPE - 1/16/2003
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"), alPrepareGroupDoc);
		if ((doc_type_code != null)) {
			optionValues = getListOptionTag(alOptionValues,getDefaultDocType());
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alPrepareGroupDoc = null;
		alOptionValues = null;
		return optionValues;
	}

	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());

		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues,getDefaultStoreCode());
		alOptionValues = null;
		return optionValues;
	}
	
	//Method to retrieve Default Document Type Code
	
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
            
			callableStatement = connection.prepareCall("{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
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
	// Method to retrieve bin location values
   /* public ArrayList getBinLocationData (String store_code) throws Exception {
        ArrayList binLocationData = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
			//SQL_SS_BIN_LOCATION_SELECT
            pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));			
            pstmt.setString(1, store_code);
			pstmt.setString(2,getLanguageId());
            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                binLocationData.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return binLocationData;
    }*/
	//Added by Sakti against BRU-HIMS-CRF-370
	public String getBinLocation(String dflt_code) {
		

		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();

		alParam.add(getStore_code());
		alParam.add(getLanguageId());
		
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues,dflt_code);
		//alOptionValues = null;

		return optionValues;
		
	}
//Added ends
	public HashMap validateStoreGroupExists() {
		Connection connection = null;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;
		HashMap resultMap = new HashMap();

		int recordExists = -1;
		try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_COUNT"));
				preparedStatement.setString(1, store_code);
				preparedStatement.setString(2, group_code);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					recordExists = resultSet.getInt(1);
				}
				if (recordExists>0) {
					resultMap.put("result", new Boolean(true));
					resultMap.put("message","Group for Store Found !");
				}
				else {
					resultMap.put("result", new Boolean(false));
					resultMap.put("message",getMessage(getLanguageId(),"INVALID_GROUP_FOR_STORE","SS"));
					resultMap.put("msgid","INVALID_GROUP_FOR_STORE");
				}
				/*if (resultSet != null) 
					resultSet.close();
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection!= null) {
					connection.close();
				}*/
		}
		catch (Exception exception) {
			exception.printStackTrace();
			resultMap.put("result", new Boolean(false));
			resultMap.put("message",exception.getMessage());
		}finally{
			try {
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return resultMap;		
	}

	public String validateStoreCode(String store_code) throws Exception {
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
		String store_desc = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"));
            pstmt.setString(1, login_facility_id);
			pstmt.setString(2, store_code);
            resultSet = pstmt.executeQuery();

            if (resultSet != null && resultSet.next()) {
                store_desc = resultSet.getString(2);
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
		finally {
            try{
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
        }
        return store_desc;
    }

	/*public String getTotalCost(String prepare_qty,String group_code) throws Exception {
        Connection connection = null ;
        CallableStatement callableStatement = null;
		String totalCost = null;

		try{
			connection = getConnection();
			callableStatement	=	connection.prepareCall("{ call ? := SS_GET_GROUP_UNIT_COST(?,'0') }");
			callableStatement.registerOutParameter(1, Types.DOUBLE);
			callableStatement.setString (2, group_code);
			callableStatement.execute();
			totalCost =""+(callableStatement.getDouble(1)*Double.parseDouble(prepare_qty));
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return totalCost;
    }*/
	
	public String getTotalCost(String prepare_qty,String group_code) throws Exception {
        Connection connection = null ;
        CallableStatement callableStatement = null;
		String totalCost = null;

		try{
			connection = getConnection();
			callableStatement	=	connection.prepareCall("{ call ? := SS_GET_GROUP_UNIT_COST(?,'0') }");
			callableStatement.registerOutParameter(1, Types.DOUBLE);
			callableStatement.setString (2, group_code);
			callableStatement.execute();
			totalCost =""+(callableStatement.getDouble(1)*Double.parseDouble(prepare_qty));
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return totalCost;
    }
	
	public HashMap validate() {
		Connection connection = null;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success") ;

		int recordExists = -1;
		try {
							
			HashMap defaultROFParameter = getSsAccEntityParam(getAcc_entity_id());

			HashMap defaultROFFacilityParameter = getSSParameter();
			String 	gen_rof_at_pre_yn = (String)defaultROFParameter.get("GEN_ROF_AT_PRE_YN");
			if (gen_rof_at_pre_yn.equals("Y")) {
				String default_rof_type_code = (String)defaultROFParameter.get("DEF_ROF_DOC_TYPE_CODE");

				if (gen_rof_at_pre_yn.equals("Y")) {
				default_rof_type_code = (String)defaultROFFacilityParameter.get("DEF_ROF_DOC_TYPE_CODE");

				}
				if (default_rof_type_code == null) {

						resultMap.put("result", new Boolean(false));
						resultMap.put("msgid","ROF_PARAMETER_NOT_FOUND");
						resultMap.put("message","ROF_PARAMETER_NOT_FOUND");
						defaultROFParameter = null;
						return resultMap;
				}
				defaultROFParameter = null;

				/*if (getFinalized_yn().equals("Y")) {

					HashMap hasValidGroupStore = validateStoreGroupExists();
					if (!((Boolean)hasValidGroupStore.get("result")).booleanValue()) {
						hasValidGroupStore.put("result", new Boolean(false));
						hasValidGroupStore.put("msgid","INVALID_GROUP_FOR_STORE");
						hasValidGroupStore.put("message",getMessage(getLanguageId(),"INVALID_GROUP_FOR_STORE","SS"));
						return hasValidGroupStore;
					}
				}*/
				
				if (default_rof_type_code != null) {

					boolean docNoAutoGen = true; 
					String doc_no_gen_falg = null;
					connection = getConnection();
					preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
					preparedStatement.setString(1, default_rof_type_code);
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						doc_no_gen_falg = resultSet.getString(1);

						
					}
					
					if ((doc_no_gen_falg != null) && (doc_no_gen_falg.equals("N"))) {

						docNoAutoGen = false;
						resultMap.put("result", new Boolean(docNoAutoGen));
						resultMap.put("msgid","ROF_DOC_NO_NOT_AUTO_GEN");
						resultMap.put("message",getMessage(getLanguageId(),"ROF_DOC_NO_NOT_AUTO_GEN","SS"));
					}
					
					setIsAutoNo(docNoAutoGen);

					if (resultSet != null) 
						resultSet.close();
					if (preparedStatement != null) 
						preparedStatement.close();
					if (!docNoAutoGen) {

						return resultMap;
					}
				}
			}
		
			if ((isAutoNo) && (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
														

				isAutoNo=false;

				preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_COUNT"));
				
				preparedStatement.setString(1, login_facility_id);
				preparedStatement.setString(2, doc_type_code);
				preparedStatement.setString(3, doc_no);
				
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {

					recordExists = resultSet.getInt(1);
					

				}
				
				if (recordExists>0) {
					resultMap.put("result", new Boolean(false));
					resultMap.put("msgid","DUPLICATE_DOC_NO");
					resultMap.put("message",getMessage(getLanguageId(),"DUPLICATE_DOC_NO","SS"));
				}
			}
			
		}
		catch (Exception exception) {
			resultMap.put("result", new Boolean(false));
			resultMap.put("message",exception.getMessage());
			exception.printStackTrace();
		}
		finally{
			try {
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		return resultMap;
	}

	
	//ML-MMOHCRF-1827
	public String getLinenApplicableYN() {
		Connection connection		= null;
		String linen_applicable_yn	= "N";
		boolean linenApplicable    = false;
 		try {
				connection = getConnection();

				linenApplicable = eCommon.Common.CommonBean.isSiteSpecific(connection,"SS", "SS_GROUP_TYPE_LINEN"); 

				if(linenApplicable){
					linen_applicable_yn = "Y";
				}else{
					linen_applicable_yn = "N";
				}
				System.err.println("==linen_applicable_yn"+linen_applicable_yn);

			}
			catch (Exception exception) {
				exception.printStackTrace();
			}finally{
			try {
					closeConnection(connection);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return linen_applicable_yn;
	}
	
	public String getGroupTypes(){
		if(getLinenApplicableYN().equalsIgnoreCase("Y")){
			return getStaticListOptionTag("A,---Select--;T,Tray;E,Set;P,Soft Pack;S,Single;L,Linen");  
		}else{
			return getStaticListOptionTag("A,---Select--;T,Tray;E,Set;P,Soft Pack;S,Single;");	
		}
		
	}
	//END of ML-MMOHCRF-1827


	public HashMap isValidDocNo() {
		Connection connection = null;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success") ;

		int recordExists = -1;
		try {
			if ((!isAutoNo) && (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_COUNT"));
				preparedStatement.setString(1, login_facility_id);
				preparedStatement.setString(2, doc_type_code);
				preparedStatement.setString(3, doc_no);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					recordExists = resultSet.getInt(1);
				}
				if (recordExists>0) {
					resultMap.put("result", new Boolean(false));
					resultMap.put("msgid","DUPLICATE_DOC_NO");
					resultMap.put("message",getMessage(getLanguageId(),"DUPLICATE_DOC_NO","SS"));
				}
				/*if (resultSet != null) 
					resultSet.close();
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection!= null) {
					connection.close();
				}*/
			}
		}
		catch (Exception exception) {
			resultMap.put("result", new Boolean(false));
			resultMap.put("message",exception.getMessage());
			exception.printStackTrace();
		}
		finally{
			try {
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return resultMap;
	}

	

	public HashMap insert() {
		

		HashMap hmResult	=	new HashMap();
		HashMap hmTableData	=	new HashMap();
		HashMap hmSQLMap	=	new HashMap();
		
		
		ArrayList	alInsertData=	new ArrayList();
		ArrayList	alInsertHdrData=	new ArrayList();
		ArrayList	alUpdateData	=	new ArrayList();
		StringTokenizer ssRecordsToProcess	=	new StringTokenizer(getRecords_to_process(),",");
		
		int i = 0;
		//HashMap hmRecord	=	new HashMap(); //Comented by sakti as this is unused against inc#48061
		//HashMap hmRecords	=	new HashMap(); //Comented by sakti as this is unused against inc#48061

		Properties properties = getProperties();
		
		hmResult.put("result", new Boolean(false)) ;
		try {
			
			if (!isAutoNo) {
				String next_doc_no = super.fetchNextDocNo(getDoc_type_code()); 
				
				setDoc_no(next_doc_no);
				
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
       // String locale =getLanguageId();
        /*alInsertData.add("S");
        alInsertData.add("1");
		alInsertData.add(getFacility_id().trim());
		alInsertData.add(getDoc_type_code().trim());
		alInsertData.add(getDoc_no().trim());
		alInsertData.add(getDoc_date());
		alInsertData.add(getDoc_ref().trim());
		alInsertData.add(getStore_code().trim());
		
		alInsertData.add(getFinalized_yn().trim());
		alInsertData.add(getTrn_type().trim());
		alInsertData.add(login_by_id.trim());
		alInsertData.add(login_at_ws_no.trim());
		alInsertData.add(login_facility_id.trim());
		alInsertData.add(login_by_id.trim());
		alInsertData.add(login_at_ws_no.trim());
		alInsertData.add(login_facility_id.trim());*/
        
      // added By Sakti Sankar against BRU-HIMS-CRF-370
       
        
        alInsertData.add(getFacility_id().trim());
        alInsertData.add(getDoc_type_code().trim());
    	alInsertData.add(getDoc_no().trim());
    	alInsertData.add(getDoc_date());
    	alInsertData.add(getDoc_ref().trim());
    	alInsertData.add(getStore_code().trim());
    	alInsertData.add(getFinalized_yn().trim());
    	alInsertData.add(getTrn_type().trim());
    	alInsertData.add(login_by_id.trim());
    	alInsertData.add(login_at_ws_no.trim());
    	alInsertData.add(login_facility_id.trim());
    	alInsertData.add(login_by_id.trim());
    	alInsertData.add(login_at_ws_no.trim());
    	alInsertData.add(login_facility_id.trim());
        
        for ( i=0;i<DataList.size() ;i++ ) {
        	if(ssRecordsToProcess.nextToken().equals("Y")){
        	alInsertHdrData.add((HashMap)DataList.get(i));		
			}
		}
               
		//Added ends
		
		//For Updation SQL_SS_UPDATE_DOC_NO
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
		alUpdateData.add(getDoc_type_code());
		hmSQLMap.put("InsertSQL", SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_INSERT"));
		//hmSQLMap.put("InsertDtlSQL", SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_INSERT"));
		//hmSQLMap.put("InsertDtlSQL", "INSERT INTO ss_prepare_dtl(	facility_id,doc_type_code,doc_no,group_code,tray_no,bin_location_code,added_by_id,added_date,added_at_ws_no,added_facility_id,		modified_by_id,	modified_date,modified_at_ws_no,modified_facility_id)VALUES	(?,?,?,?,?,?, ?,SYSDATE,?,?,?,SYSDATE,?,?)");
		hmSQLMap.put("UpdateSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
		hmTableData.put("properties",properties );
		hmTableData.put("InsertCommonData",alInsertData);
		hmTableData.put("InsertData",alInsertHdrData);//Added by Sakti against BRU-HIMS-CRF-370
		hmTableData.put("UpdateData",alUpdateData);

		

		try {
		
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( SsRepository.getSsKeyValue("JNDI_SS_PREPARE_GROUP"),PrepareGroupHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			
			hmResult.put("flag", "Doc No: "+getDoc_no()) ;
			
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}

		//Added by Martin on Thursday, April 17, 2003 11:58:46 AM to include online printing
		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (getFinalized_yn().equals("Y") && isInternalRequest("SS","SSBTRLBL")) {
				doOnlineReportPrinting();				
			}
		}
		
		return hmResult;
	}

	
	public HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alModifyData = new ArrayList();
		ArrayList	alModifyHdrData = new ArrayList();
		Properties properties = getProperties();
		StringTokenizer ssRecordsToProcess	=	new StringTokenizer(getRecords_to_process(),",");

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;

		alModifyData.add(getDoc_date());
		alModifyData.add(getDoc_ref());
		alModifyData.add(getStore_code());
		alModifyData.add(getFinalized_yn());
		alModifyData.add(getTrn_type());
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(getFacility_id());
		alModifyData.add(getDoc_type_code());
		alModifyData.add(new Integer(getDoc_no()));
		
		 // added By Sakti Sankar against BRU-HIMS-CRF-370
		for (int i=0;i<DataList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)DataList.get(i);
			System.out.println("hmRecord"+hmRecord);
			
        	if(ssRecordsToProcess.nextToken().equals("N")) {
        		if( hmRecord.get("mode").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
					continue;
        		else
					hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
        	}
        					
        	alModifyHdrData.add(hmRecord);
		}
       //Added ends

		hmTableData.put("properties",properties);
		hmTableData.put("UpdateData",alModifyData);
		hmTableData.put("UpdateHDRData",alModifyHdrData);
		hmSQLMap.put("UpdateSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_UPDATE"));
		hmSQLMap.put("DtlDeleteSQL", "DELETE FROM ss_prepare_hdr WHERE facility_id = ? AND doc_type_code = ? AND doc_no = ? and group_code=?");
		hmSQLMap.put("InsertSQL", SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_INSERT")); 
		
		
	
		try {
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( SsRepository.getSsKeyValue("JNDI_SS_PREPARE_GROUP"),PrepareGroupHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
		} 
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
			}
			catch(Exception ee) {
				ee.printStackTrace();
				hmResult.put("message", ee.toString()) ;
			}
		}

		//Added by Martin on Thursday, April 17, 2003 11:58:46 AM to include online printing
		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (getFinalized_yn().equals("Y") && isInternalRequest("SS","SSBTRLBL")) {
				System.out.println("Calling Onle Print");
				doOnlineReportPrinting();				
			}
		}
		return hmResult;
	}
	
	public HashMap delete() {
        HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alDeleteData = new ArrayList();
		Properties properties = getProperties();

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;

		alDeleteData.add(getFacility_id());
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(new Integer(getDoc_no()));
		
		hmTableData.put("properties",properties);
		hmTableData.put("DeleteData",alDeleteData);
		hmSQLMap.put("DeleteSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_DELETE"));
	

		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( SsRepository.getSsKeyValue("JNDI_SS_PREPARE_GROUP"),PrepareGroupHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				
			  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
			}
			catch(Exception ee) {
				ee.printStackTrace();
				hmResult.put("message", ee.toString()) ;
			}
		}
		return hmResult	;
    }

	public void loadData() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		
		
		ArrayList alParameters	=	new ArrayList();
		ArrayList listRecord	=	new ArrayList();
		String stSQL			=	"";
		try {
			/*setFacility_id(login_facility_id);
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_SELECT_SINGLE")); 
			preparedStatement.setString(1, getFacility_id());
			preparedStatement.setString(2, getDoc_type_code());
			preparedStatement.setInt(3, Integer.parseInt(getDoc_no()));

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				setDoc_date(resultSet.getString("doc_date"));
				setDoc_ref(resultSet.getString("doc_ref"));
				setPrepare_qty(""+resultSet.getLong("prepare_qty"));
				setStore_code(resultSet.getString("store_code"));
				setGroup_code(resultSet.getString("group_code"));
				setTotal_cost(""+resultSet.getString("total_cost"));
				setBin_location_code(resultSet.getString("bin_location_code"));
				setFinalized_yn(resultSet.getString("finalized_yn"));
				setGroup_desc(resultSet.getString("short_desc"));
			}*/
			 // added By Sakti Sankar against BRU-HIMS-CRF-370
			selectedList = new ArrayList();
			alSelectedDetails = new ArrayList();
			ArrayList	alRecords	=	new ArrayList();
			alParameters.add(getLoginFacilityId());
			alParameters.add(doc_type_code);
			alParameters.add(doc_no);
			stSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_HDR_SELECT_SINGLE");
			listRecord			=		fetchRecords(stSQL.toString(),alParameters);
			for(int i=0;i<listRecord.size();i++){
				HashMap dataList		=		(HashMap)listRecord.get(i);

				dataList.put("GROUP_CODE",(String)dataList.get("GROUP_CODE"));
				//dataList.put("GROUP_DESC",(String)dataList.get("SHORT_DESC"));
				dataList.put("GROUP_DESC",java.net.URLEncoder.encode((String)dataList.get("SHORT_DESC"),"UTF-8"));
				dataList.put("PREPARE_QTY",(String)dataList.get("PREPARE_QTY"));
				dataList.put("BIN_LOCATION_CODE",(String)dataList.get("BIN_LOCATION_CODE"));
				dataList.put("TOTAL_VALUE",(String)dataList.get("TOTAL_COST"));
				dataList.put("mode","2");
				
				alSelectedDetails.add((String)dataList.get("GROUP_CODE"));
				alModifyRecord.add((String)dataList.get("GROUP_CODE"));
				
				alRecords.add(dataList);
				dataList = new HashMap();
				 
			}
			setSelectedList(alRecords);
			
		} 
		catch (Exception e )	{
			e.printStackTrace();
			} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	public String toString() {
		return "	doc_ref = "+ doc_ref + 
		"	trn_type = "+ trn_type+ 
		"	prepare_qty = "+ prepare_qty+
		"	store_code = "+ store_code+
		"	group_code = "+ group_code+
		"	total_cost = "+ total_cost+
		"	doc_type_code = "+ doc_type_code+
		"	doc_date = "+ doc_date+
		"	doc_no = "+ doc_no+
		"	bin_location_code = "+ bin_location_code+
		"	finalized_yn  = "+ finalized_yn+
		"	facility_id = "+ facility_id+
		"	tray_no = "+ tray_no+
		"	isAutoNo = "+ isAutoNo+
		"	mode = "+mode;
	}

    public HashMap apply() {
		HashMap test = null;
		try {
			test = super.apply();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return test;
	}
	
	public void doOnlineReportPrinting() {
		try{
			ArrayList alParameters=new ArrayList(4);
			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add(getGroup_code());
		
        	HashMap hmRecords=fetchRecord(getSsRepositoryValue("SQL_SS_TRAY_DTLS_REPORT_SELECT"),alParameters);
			String from_tray_no = (String)hmRecords.get("FROM_TRAY_NO");
			String to_tray_no = (String)hmRecords.get("TO_TRAY_NO");
            
			String reportid = "SSBTRLBL";
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","SS");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
            hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_fr_group_code",getGroup_code());
            hmReportParameter.put("p_to_group_code",getGroup_code());
            hmReportParameter.put("p_fr_tray_no",from_tray_no);
     		hmReportParameter.put("p_to_tray_no",to_tray_no);
     		hmReportParameter.put("p_language_id",getLanguageId()) ;
            hmReportParameter.put("p_reprint","Y");  
            
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",session.getAttribute("jdbc"));
			hmParameters.put("report_server",session.getAttribute("report_server"));
			hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("location_type","S");
				hmParameters.put("location_code",getStore_code());

			System.out.println("hmParameters"+hmParameters);
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
			

		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	}
	
}
