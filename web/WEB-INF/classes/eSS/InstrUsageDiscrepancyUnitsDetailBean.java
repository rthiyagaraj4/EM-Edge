/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package eSS;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import eSS.Common.SsTransaction;
import eSS.Common.SsRepository;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;
import eCommon.Common.CommonRepository;
import java.util.Properties;
import eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsHome;
import eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsRemote;


public class InstrUsageDiscrepancyUnitsDetailBean extends SsTransaction {

	private String group_code;
	private String tray_no; 
	private String store_code;
	private String group_type_code;
	private String group_desc;
	private String item_code;
	private String item_desc;
	private String defaultStoreCode;
	private String defaultDocType;

	private String doc_type_code;
	private String doc_date;
	private String patient_id;
	private String patient_name;
	private String encounter_id;
	private String discrepancy_type;
	private String discrepancy_qty;
	private String write_off_reason_code;
	private String write_off_reason_desc;
	private String remarks;
	private String records_to_delete;


	private int enteredTrayQty;

	private java.util.ArrayList availableTrays;
	private java.util.ArrayList selectedTrays;
	private java.util.ArrayList oldTrays;
	private java.util.ArrayList DataModifyList;
	private java.util.Hashtable trayDetails;
	private java.util.Hashtable trayQuantityDetails;
	private java.util.ArrayList trayArray;

	private String defStoreCode = "";
	private String defServiceLocationCode = "";
	private String selected_write_off_reason_code = "";
	private String selected_item_code = "";
	private String linenApplicableYN ="";//mmoh-crf-1661
	
	public String getLinenApplicableYN() {
		return linenApplicableYN;
	}

	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//END 
	private HttpSession session;

	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return this.session;
	}
	public InstrUsageDiscrepancyUnitsDetailBean() {
		availableTrays = new java.util.ArrayList();
		selectedTrays = new java.util.ArrayList();
		trayDetails = new java.util.Hashtable();
		trayQuantityDetails = new java.util.Hashtable();
	}

	public void setSelected_item_code(String selected_item_code) {
		
		this.selected_item_code = selected_item_code;
	}

	public String getSelected_item_code() {
		return this.selected_item_code;
	}
	public void setDataModifyList(ArrayList DataModifyList) {
		 this.DataModifyList = DataModifyList;
	}

	public ArrayList getDataModifyList( ) {
		 return DataModifyList;
	}
	public void setSelected_write_off_reason_code(String selected_write_off_reason_code) {
		this.selected_write_off_reason_code = selected_write_off_reason_code;
	}

	public String getSelected_write_off_reason_code() {
		return this.selected_write_off_reason_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
		
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setTray_no(String tray_no) {
		this.tray_no = tray_no;

	}

	public String getTray_no() {	
		return this.tray_no;
	}

	public String getGroup_code() {
		return this.group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
		 
	}

	public void setGroup_type_code(String group_type_code) {
		this.group_type_code = group_type_code;
	}

	public String getGroup_type_code() {
		return this.group_type_code;
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc=  group_desc;
		
	}

	public String getGroup_desc() {
		 return this.group_desc;
	}

	public void setDefaultStoreCode (String defaultStoreCode) {
		this.defaultStoreCode = defaultStoreCode;
	}

	public String getDefaultStoreCode() {
		return this.defaultStoreCode;
	}
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}

	public String getDefaultDocType() {
		return this.defaultDocType;
	}
	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}
	public String getItem_code() {
		 return item_code;
	}
	public String getItem_desc() {
		 return item_desc;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc=  item_desc;
	}
	public void setItem_code(String item_code) {
		 this.item_code =  item_code;
	}
	public String getDiscrepancy_qty() {
		 return discrepancy_qty;
	}

	public void setDiscrepancy_qty(String discrepancy_qty) {
		 this.discrepancy_qty =  checkForNull(discrepancy_qty);
	}
public void setWrite_off_reason_code(String write_off_reason_code) {
		 this.write_off_reason_code =  write_off_reason_code;
	}

	public String getWrite_off_reason_desc() {
		 return write_off_reason_desc;
	}


public String getWrite_off_reason_code() {
		 return write_off_reason_code;
	}


	public void setWrite_off_reason_desc(String write_off_reason_desc) {
		 this.write_off_reason_desc=  write_off_reason_desc;
	}

	public String getRemarks() {
		 return remarks;
	}
	
	public void setRemarks(String remarks) {
		 this.remarks =  checkForNull(remarks);
	}
	public void initialize(HashMap hmTrayDiscrepancyItem){
		
		setItem_code            (checkForNull(hmTrayDiscrepancyItem.get("item_code").toString()));
		if(hmTrayDiscrepancyItem.containsKey("item_desc")){
			setItem_desc            (checkForNull(hmTrayDiscrepancyItem.get("item_desc").toString()));
		}
		else
		{
			setItem_desc            (checkForNull(hmTrayDiscrepancyItem.get("ITEM_DESC").toString()));
		}

		if(hmTrayDiscrepancyItem.containsKey("write_off_reason_desc")){
			setWrite_off_reason_desc(checkForNull(hmTrayDiscrepancyItem.get("write_off_reason_desc").toString()));
		}
		else
		{
			setWrite_off_reason_desc(checkForNull(hmTrayDiscrepancyItem.get("WRITE_OFF_REASON_DESC").toString()));
		}
		if(hmTrayDiscrepancyItem.containsKey("write_off_reason_code")){
			setWrite_off_reason_code(checkForNull(hmTrayDiscrepancyItem.get("write_off_reason_code").toString()));
		}
		else
		{
			setWrite_off_reason_code(checkForNull(hmTrayDiscrepancyItem.get("WRITE_OFF_REASON_CODE").toString()));
		}
		if(hmTrayDiscrepancyItem.containsKey("remarks")){
			setRemarks              (checkForNull((String)hmTrayDiscrepancyItem.get("remarks")).toString());
		}
		else
		{
			setRemarks              (checkForNull((String)hmTrayDiscrepancyItem.get("REMARKS")).toString());
		}
		setDiscrepancy_qty      (checkForNull((String)hmTrayDiscrepancyItem.get("discrepancy_qty")).toString());
		setDiscrepancy_type     (checkForNull(hmTrayDiscrepancyItem.get("discrepancy_type").toString()));
		setPatient_name			(checkForNull((String)hmTrayDiscrepancyItem.get("patient_name")).toString());
		setPatient_id			(checkForNull((String)hmTrayDiscrepancyItem.get("patient_id")).toString());
		if(hmTrayDiscrepancyItem.containsKey("encounter_id")){
			setEncounter_id			(checkForNull(hmTrayDiscrepancyItem.get("encounter_id").toString()));
		}
		
		if(hmTrayDiscrepancyItem.containsKey("mode")){
		setMode				    (checkForNull(hmTrayDiscrepancyItem.get("mode").toString()));
		}
		
	}
	public void doCommon() {
		try {
			java.util.HashMap defaultParameter = getSSParameter();
			
			defServiceLocationCode = (String) defaultParameter.get("DEF_SERVICE_LOCATION_CODE");
			defStoreCode = (String) defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}	
	}
	public String getItem_code_List(String group_code){

		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(getLanguageId());

		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParameters), getItem_code());
	}
	public void clear() {
		
		group_code = "";
		group_desc="";
		tray_no = ""; 
		store_code = "";
		group_type_code = "";
		records_to_delete="";
		patient_id="";
		remarks="";
		patient_name="";
		encounter_id="";
		discrepancy_qty="";
		discrepancy_type="";
		linenApplicableYN = ""; //mmoh-crf-1661 
	}

public String getStores(String store_code) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_INSTR_USAGE_STORE_SELECT"), alParam);
		
		optionValues = getListOptionTag(alOptionValues,getDefaultStoreCode());
		alOptionValues = null;
		
		return optionValues;
	}

	public String getOwnerStoreCode(String store_code,String tray_no,String group_code) {
		try {
			java.util.ArrayList alParam = new java.util.ArrayList();
			alParam.add(tray_no);
			alParam.add(store_code);
			alParam.add(group_code);
	
			HashMap hmRecord = fetchRecord( getSsRepositoryValue("SQL_SS_INSTR_USAGE_OWNER_STORE_SELECT"),alParam);
			return checkForNull((String) hmRecord.get("OWNER_STORE_CODE"));//added checkForNull for KDAH-SCF-0329
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public String getPatientName(String patient_id) {
		try {
			HashMap hmRecord = fetchRecord(getSsRepositoryValue("SQL_MP_PATIENT_SELECT_SINGLE"),patient_id);
			return checkForNull((String) hmRecord.get("PATIENT_NAME"));
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return "";
		}
	}

	public String getGroupTypes(){
		if(getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y")){//MMOH-CRF-1661  
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;L,Linen;");
		}else{
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;");	
		}
		
	}

	public String getDiscrepancyReasons() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"));
		optionValues = getListOptionTag(alOptionValues,this.selected_write_off_reason_code);
		alOptionValues = null;
		this.selected_write_off_reason_code ="";
		return optionValues;
	}
	public String getWrite_off_reason_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId()), getWrite_off_reason_code());
	}
	public ArrayList getItems() {
		
		java.util.ArrayList alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),group_code);
			
			return alOptionValues;
			
		
	}
	public java.util.Hashtable getTrayDetails() {
		return trayDetails;
	}

	public java.util.ArrayList getAvailableTrays() {
		return availableTrays;
	}
	
	public void loadDetails() {
		
		oldTrays = new java.util.ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String key = null;
		String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DISCREPANCY_DTL_INSTR_USAGE_SELECT");
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,getGroup_code());
			preparedStatement.setString(2,getTray_no());
			preparedStatement.setString(3,getStore_code());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
					String[] detailRecord = formatDiscrepancyDetail(resultSet);
					key = detailRecord[0]+"-"+detailRecord[2];
					trayDetails.put (key,detailRecord);
					availableTrays.add(key);
					oldTrays.add(key);
			}
		}
		catch (Exception exception )	{
			exception.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public java.util.HashMap updateTrayDetails(java.util.Hashtable hash) {
		
		java.util.HashMap resultMap = new java.util.HashMap();
		resultMap.put("result",new Boolean(false));
		String instrument_code = (String) hash.get("item_code");
		setGroup_code ((String) hash.get("group_code"));
		setTray_no ((String) hash.get("tray_no"));
		boolean isEditing = false;
		String editing_key = (String)hash.get("editing_key");

		if (editing_key != null && (trayDetails.get(editing_key) != null)) {
			isEditing = true;
		}
		StringBuffer key = new StringBuffer();
		key.append(hash.get("item_code"));
		key.append('-');
		key.append(hash.get("write_off_reason_code"));
		String[] detailRecord = formatDiscrepancyDetail(hash);

		
		try {
			if ((!isEditing) && (availableTrays.contains(key.toString()))) {
				resultMap.put("msgid","RECORD_ALREADY_EXISTS");
				resultMap.put("message","Cannot duplicate instrument");
				return resultMap;
			}
			// Check for discrepancy quantity - Comment can be removed !
			if (isQtyExceeded(instrument_code)) {
				resultMap.put("msgid","DISCREPANCY_EXCEEDS_ISSUED");
				resultMap.put("message","Quantity Cannot be greater than issued Quantity");
				return resultMap;
			}
			resultMap.put("result",new Boolean(true));
			resultMap.put("msgid","");
			resultMap.put("message","");
			if (!isEditing) {
				availableTrays.add(key.toString());
			}
			trayDetails.put (key.toString(),detailRecord);
			return resultMap;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			resultMap.put("msgid","");
			resultMap.put("message",exception.toString());
			return resultMap;
		}
	}
	
	public boolean isQtyExceeded(String itemCode) {
		boolean result = false; 
		boolean hasRecord = false; 
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_ITEM_DTLS_SELECT");
		int availableQty = -1;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,getGroup_code());
			preparedStatement.setString(2,getTray_no());
			preparedStatement.setString(3,itemCode);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				hasRecord = true; 
				availableQty = resultSet.getInt(2);
			}
			preparedStatement=null;
			resultSet=null;

			if (!hasRecord) {
				sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ITEM_FOR_GROUP_INSTR_USAGE_SELECT");
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,getGroup_code());
				preparedStatement.setString(2,itemCode);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()){
					availableQty = resultSet.getInt(1);
				}
			}

			
			if (availableQty<=0) {
				return true;
			}
			String qty = (String) trayQuantityDetails.get(itemCode);
			int currentQty = 0;
			if (qty != null && qty.length()>0) {
				currentQty = Integer.parseInt(qty.trim());
				currentQty += enteredTrayQty;
				
			}
			else {
				currentQty = enteredTrayQty;				
			}
			
			if (currentQty > availableQty) {
				enteredTrayQty = 0;
				result = true;
				return result;
			}
			trayQuantityDetails.put (itemCode,""+currentQty);
		} 
		catch (Exception exception )	{
		
			exception.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	
		return result;
	}

	public String[] formatDiscrepancyDetail(java.util.Hashtable hash) {
	
		String[] discrepancyInfo = new String[11];
		discrepancyInfo[0] = (String) hash.get("item_code");
		discrepancyInfo[1] = (String) hash.get("item_desc");
		discrepancyInfo[2] = (String) hash.get("write_off_reason_code");
		discrepancyInfo[3] = (String) hash.get("write_off_reason_desc");
		discrepancyInfo[4] = (String) hash.get("remarks");
		discrepancyInfo[5] = (String) hash.get("discrepancy_qty");
		discrepancyInfo[6] = "N"; // is updated
		discrepancyInfo[7] = (String) hash.get("patient_id");
		discrepancyInfo[8] = (String) hash.get("patient_name");
		discrepancyInfo[9] = (String) hash.get("encounter_id");
		discrepancyInfo[10] = "A"; // Used for status
		enteredTrayQty = Integer.parseInt((String) hash.get("discrepancy_qty"));
		return discrepancyInfo;
	}

	public String[] formatDiscrepancyDetail(java.sql.ResultSet resultSet) {
		try {
			String[] discrepancyInfo = new String[11];
			discrepancyInfo[0] = resultSet.getString("item_code");
			discrepancyInfo[1] = resultSet.getString("item_desc");
			discrepancyInfo[2] = resultSet.getString("write_off_reason_code");
			discrepancyInfo[3] = resultSet.getString("write_off_reason_desc");
			discrepancyInfo[4] = resultSet.getString("remarks");
			discrepancyInfo[5] = resultSet.getString("discrepancy_qty");
			discrepancyInfo[6] = "N"; // is updated
			discrepancyInfo[7] = resultSet.getString("patient_id");
			discrepancyInfo[8] = resultSet.getString("patient_name");
			discrepancyInfo[9] = resultSet.getString("encounter_id");
			discrepancyInfo[10] = "O"; // Used for status
			enteredTrayQty = Integer.parseInt((String) discrepancyInfo[5]);
			String itemCode = discrepancyInfo[0];
			if (trayQuantityDetails.containsKey(itemCode)) {
				String existingQty = (String) trayQuantityDetails.get(itemCode);
				existingQty = ""+ (Integer.parseInt(existingQty) + Integer.parseInt(discrepancyInfo[5])); 
				trayQuantityDetails.put (itemCode,existingQty);
			}
			else {
				trayQuantityDetails.put (itemCode,discrepancyInfo[5]);
			}
			return discrepancyInfo;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	public void setEncounter_id(String encounter_id) {
		 this.encounter_id = encounter_id;
	}

	public String getEncounter_id( ) {
		 return encounter_id;
	}
	public void updateSelectedTrays(java.util.Hashtable hash) {
		for (int index=0;index<hash.size();index++) {
			selectedTrays.add(hash.get("selected_tray_"+index));
		}
	}
	public void setPatient_id(String patient_id) {
		 this.patient_id = patient_id;
	}
	public void setPatient_name(String patient_name) {
		 this.patient_name = patient_name;
	}
	public String getPatient_name( ) {
		 return patient_name;
	}
	public String getPatient_id( ) {
		 return patient_id;
	}
	public String getDiscrepancy_type() {
		 return discrepancy_type;
	}
	public void setTrayList(ArrayList trayArray)
	{
		this.trayArray=trayArray;
	}
	public ArrayList getTrayList() {
		 return trayArray;
	}
	public void setDiscrepancy_type(String discrepancy_type) {
		 this.discrepancy_type =  discrepancy_type;
	}
	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete =  records_to_delete;
	}

	public String getRecords_to_delete() {
		 return records_to_delete;
	}
	public void setAll(java.util.Hashtable htResult) {
		
		setStore_code((String)htResult.get("store_code"));
		setGroup_type_code((String)htResult.get("group_type_code"));
		setGroup_code((String)htResult.get("group_code"));
		setTray_no((String)htResult.get("tray_no"));
		setRecords_to_delete((String)htResult.get("records_to_delete"));
		setLanguageId((String)htResult.get("locale"));
		
	}

	public String[] getDetail(String key) {
		if (trayDetails.containsKey(key)) {
			return (String[]) trayDetails.get(key);
		}
		return null;
	}	
		
		
	public HashMap validate(){
		
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,TRUE);
		return hmReturn;


	}

		
	public boolean trayNoExists(String storeCode, String groupCode, String trayNo) {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		int trayCount = -1;
		boolean hasTray = false;
		try {
			setGroup_code(groupCode);
			setStore_code(storeCode);
			setTray_no(trayNo);

			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_INSTR_DISCREPANCY_TRAY_COUNT")); 
			preparedStatement.setString(1, groupCode);
			preparedStatement.setString(2, storeCode);
			preparedStatement.setString(3, trayNo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				trayCount = resultSet.getInt(1);
			}
			if (trayCount > 0) {
				hasTray = true;
				loadDetails();
			}
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
		return hasTray;
	}
/*Added on Monday, May 12, 2003 by Manish*/
	public String getEncounterID(String patient_id) {
		String encounter_id="";
		try { 
			String []stParameters={getLoginFacilityId(),patient_id};
			encounter_id=((HashMap)fetchRecord(getSsRepositoryValue("SQL_PR_ENCOUNTER_SELECT_MAX"),stParameters)).get("ENCOUNTER_ID").toString();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return encounter_id;		
	}
	
public boolean isValidDiscrepancyQty(String group_code, String tray_no, String item_code,String discrepancy_type,String discrepancy_qty) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(new Long(tray_no));
		alParameters.add(item_code);
		alParameters.add(discrepancy_type);
		alParameters.add(new Long(discrepancy_qty));
		return ((HashMap)fetchRecord(getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString().equals("NO_ERROR");
	}
	public String getDiscrepancy_type_List(){
	//	return getStaticListOptionTag("P,Positive;N,Negative");Modified for KDAH-SCF-0329 [IN:057314]
		 String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag( "P,"+ss_labels.getString("eSS.Positive.label")+";N,"+ss_labels.getString("eSS.Negative.label"), getDiscrepancy_type());
	}
	

	
public String getEncounter_id_List(String encounter_id){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getPatient_id());
		return getListOptionTag(getListOptionArrayList("SELECT encounter_id , encounter_id enc_id FROM pr_encounter WHERE facility_id=? AND patient_id=? AND ( visit_status IN ('01', '02', '04') OR adt_status ='01' ) order by encounter_id desc",alParameters), encounter_id);
	}



public ArrayList getEncounterArrayList(String patient_id) throws Exception{ 
		String ssParameters[]={getLoginFacilityId(),patient_id};
		return fetchRecords(getSsRepositoryValue("SQL_PR_ENCOUNTER_SELECT_LIST"),ssParameters);
	}
	
public boolean isItemAndDiscrepancyInArrayList(ArrayList alTrayDiscrepancyList,String group_code, String tray_no, String ssItem_code,String ssWriteOffReasonCode, int exceptionalIndex){
		boolean result		=		false;
		
		for (int i=0;i<alTrayDiscrepancyList.size();i++) {

			HashMap hm		=		new HashMap();
			hm				=		((HashMap)alTrayDiscrepancyList.get(i));
			if (exceptionalIndex == i) continue;
		
			if((hm.containsKey("GROUP_CODE"))&&(hm.containsKey("TRAY_NO"))){
		
			if (exceptionalIndex == i) continue;
			if (( ((String)hm.get("GROUP_CODE")).equals(group_code) ) &&( ((String)hm.get("TRAY_NO")).equals(tray_no) )&&( ((String)hm.get("item_code")).equals(ssItem_code) )&&(((String)hm.get("WRITE_OFF_REASON_CODE")).equals(ssWriteOffReasonCode) )) {
			
					result		=		true;
					break;
			}
				
		}
		else if((hm.containsKey("group_code"))&&(hm.containsKey("tray_no"))){
				
			if (( ((String)hm.get("group_code")).equals(group_code) ) &&( ((String)hm.get("tray_no")).equals(tray_no) )&&( ((String)hm.get("item_code")).equals(ssItem_code) )&&(((String)hm.get("write_off_reason_code")).equals(ssWriteOffReasonCode) )) {
		
				result		=		true;
				break;
			}
				
		}
	}
		return result;
}


public HashMap insert(){

		HashMap		hmTableData				=	new HashMap()	;
		ArrayList	alCommonInsertData		=	new ArrayList()	;

		ArrayList	alDtlInsertData			=	new ArrayList()	;
		ArrayList	alDtlUpdateData			=	new ArrayList()	;
		ArrayList	alTrayDiscrepancyList	=	null			;
		HashMap		hmSQLMap				=	new HashMap()	;
		try { 

			
			alCommonInsertData.add(	getLoginById()			);      
			alCommonInsertData.add(	getLoginAtWsNo()		);    
			alCommonInsertData.add(	getLoginFacilityId()	);
			alCommonInsertData.add(	getLoginById()			);      
			alCommonInsertData.add(	getLoginAtWsNo()		);    
			alCommonInsertData.add(	getLoginFacilityId()	);


			alTrayDiscrepancyList	=	(ArrayList)session.getAttribute("alTrayDiscrepancyList");

			for (int i=0;i<alTrayDiscrepancyList.size();i++ ) {
				HashMap hmRecord1	=	(HashMap)alTrayDiscrepancyList.get(i);
				HashMap hmRecord	=	new HashMap();
				
				
				if(hmRecord1.containsKey("mode")){
					hmRecord1.put("mode","MODE_INSERT");
				}
				else
				{
					hmRecord1.put("mode","MODE_MODIFY");
				}
				if(hmRecord1.get("mode").equals("MODE_INSERT")){
				hmRecord.put("item_code",hmRecord1.get("item_code"));
				if(hmRecord1.containsKey("group_code")){
					hmRecord.put("group_code",hmRecord1.get("group_code"));
				}
				else
				{
					hmRecord.put("group_code",hmRecord1.get("GROUP_CODE"));
				}
				
				if(hmRecord1.containsKey("write_off_reason_code")){
					hmRecord.put("write_off_reason_code",hmRecord1.get("write_off_reason_code"));
				}
				else
				{
					hmRecord.put("write_off_reason_code",hmRecord1.get("WRITE_OFF_REASON_CODE"));
				}
				if(hmRecord1.containsKey("discrepancy_qty")){
					hmRecord.put("discrepancy_qty",hmRecord1.get("discrepancy_qty"));
				}
				else
				{
					hmRecord.put("discrepancy_qty",hmRecord1.get("DISCREPANCY_QTY"));
				}
				if(hmRecord1.containsKey("store_code")){
					hmRecord.put("store_code",hmRecord1.get("store_code"));
				}
				else
				{
					hmRecord.put("store_code",hmRecord1.get("STORE_CODE"));
				}
				if(hmRecord1.containsKey("patient_id")){
				hmRecord.put("patient_id",checkForNull((String)hmRecord1.get("patient_id"),""));
				}
				else
				{
				hmRecord.put("patient_id",checkForNull((String)hmRecord1.get("PATIENT_ID"),""));
				
				}
				if(hmRecord1.containsKey("encounter_id")){
					hmRecord.put("encounter_id",checkForNull((String)hmRecord1.get("encounter_id"),""));
				}
				else
				{
					hmRecord.put("encounter_id",checkForNull((String)hmRecord1.get("ENCOUNTER_ID"),""));
				
				}
				if(hmRecord1.containsKey("remarks")){
				hmRecord.put("remarks",checkForNull((String)hmRecord1.get("remarks"),""));
				}
				else
				{
				hmRecord.put("remarks",checkForNull((String)hmRecord1.get("REMARKS"),""));
				
				}
				if(hmRecord1.containsKey("usage_ind")){
				hmRecord.put("usage_ind",checkForNull((String)hmRecord1.get("usage_ind"),""));
				}
				else
				{
				hmRecord.put("usage_ind",checkForNull((String)hmRecord1.get("USAGE_IND"),""));
				
				}
				hmRecord.put("discrepancy_type",checkForNull((String)hmRecord1.get("discrepancy_type")));
				
				
			
				
				if(hmRecord1.containsKey("tray_no")){
					hmRecord.put("tray_no",hmRecord1.get("tray_no"));
				}
				else
				{
					hmRecord.put("tray_no",hmRecord1.get("TRAY_NO"));
				}
				alDtlInsertData.add(hmRecord);
				}
				else
				{
					hmRecord.put("item_code",hmRecord1.get("item_code"));
					hmRecord.put("group_code",hmRecord1.get("group_code"));
					hmRecord.put("write_off_reason_code",hmRecord1.get("write_off_reason_code"));
					hmRecord.put("discrepancy_qty",hmRecord1.get("discrepancy_qty"));
					hmRecord.put("discrepancy_type",hmRecord1.get("discrepancy_type"));
					hmRecord.put("remarks",hmRecord1.get("remarks"));
					hmRecord.put("patient_id",hmRecord1.get("patient_id"));
					hmRecord.put("store_code",hmRecord1.get("store_code"));
					hmRecord.put("encounter_id",hmRecord1.get("encounter_id"));
					hmRecord.put("usage_ind",hmRecord1.get("usage_ind"));
					hmRecord.put("tray_no",hmRecord1.get("tray_no"));
					alDtlUpdateData.add(hmRecord);
				}
				
				
				
					if( hmRecord1.get("mode").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
						continue;
					else
						hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
			}
			hmSQLMap.put("InsertDTLSQL", SsRepository.getSsKeyValue("SQL_SS_DISCREPANCY_DTL_INSTR_USAGE_INSERT"));
			
			
			hmSQLMap.put( "ModifySQL", getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_UPDATE_FOR_TRD"));
			hmSQLMap.put( "DeleteSQL", getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_DELETE"));
			hmTableData.put( "properties", getProperties() );
			hmTableData.put( "CommonInsertData", alCommonInsertData	);
			hmTableData.put("InsertDTLData", alDtlInsertData);
			hmTableData.put("UpdateDTLData", alDtlUpdateData);
			
		
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return instrTrayDiscrepancyMethodCall(hmTableData, hmSQLMap);
	}
	public HashMap instrTrayDiscrepancyMethodCall(HashMap hmTableData, HashMap hmSQLMap){
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
		
	
	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_INSTRUSAGEDISCREPANCYUNITS"),InstrUsageDiscrepancyUnitsHome.class,getLocalEJB());
	
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();
           

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
					hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;

			else if( hmResult.get("msgid")!=null  )
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		clear();
		return hmResult;
	}
}


