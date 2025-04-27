/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.*;
import eST.Common.StAdapter;
import java.io.Serializable;
import eST.Common.StRepository;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import eST.KitTemplate.*;



public class ScheduleAutoRequestBean extends StAdapter implements Serializable {


	
	private String defaultDocType			=	"";
	private String doc_type_code			=	"";
	private String requisition_by_store		=	"";
	private String requisition_on_store		=	"";
	private String schedule_code			=	"";
	private String schedule_desc			=	"";
	private String frequency				=	"";
	private String starting_from			=	"";
	private String auto_authorised			=	"";
	private String eff_status				=	"";
	protected ArrayList applicableSchduleItems		=	null;
	ArrayList associated					=	new ArrayList();
	ArrayList associated_sel				=	new ArrayList();




	public void setDefaultDocType (String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}
	public String getDefaultDocType () {
		return this.defaultDocType;
	}
	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}
	public void setRequisition_by_store(String requisition_by_store) {
		 this.requisition_by_store = requisition_by_store;
	}
	public String getRequisition_by_store() {
		 return requisition_by_store;
	}
	
	public void setRequisition_on_store(String requisition_on_store) {
		 this.requisition_on_store = requisition_on_store;
	}

	public String getRequisition_on_store() {
		 return this.requisition_on_store;
	}
	public void setSchedule_code(String schedule_code) {
		 this.schedule_code = schedule_code;
	}

	public String getSchedule_code() {
		 return this.schedule_code;
	}
	public void setSchedule_desc(String schedule_desc) {
		 this.schedule_desc = schedule_desc;
	}

	public String getSchedule_desc() {
		 return this.schedule_desc;
	}
	public void setFrequency(String frequency) {
		 this.frequency = frequency;
	}

	public String getFrequency() {
		 return this.frequency;
	}
	public void setStarting_from(String starting_from) {
		 this.starting_from = starting_from;
	}

	public String getStarting_from() {
		 return this.starting_from;
	}
	public void setAuto_authorised(String auto_authorised) {
		 this.auto_authorised = auto_authorised;
	}

	public String getAuto_authorised() {
		 return this.auto_authorised;
	}
	public void setEff_status(String eff_status) {
		 this.eff_status = eff_status;
	}

	public String getEff_status() {
		 return this.eff_status;
	}

	public void setApplicableSchduleItems(ArrayList values)	{
		applicableSchduleItems		= (ArrayList)values.clone();
	}
	public ArrayList getApplicableSchduleItems()	{
		return applicableSchduleItems;
	}
	public void setAssociated(ArrayList associated)	{
	associated		= (ArrayList)associated.clone();
	}
	public ArrayList getAssociated()	{
		return associated;
	}
	public void setAssociated_sel(ArrayList associated_sel)	{
	associated_sel		= (ArrayList)associated_sel.clone();
	}
	public ArrayList getAssociated_sel()	{
		return associated_sel;
	}

	public void initialize(){
		super.initialize();
		this.doc_type_code			=	"";
		this.requisition_by_store	=	"";
		
	}
	public void clear(){
		super.clear();
		this.doc_type_code				=	"";
		this.requisition_by_store		=	"";
		this.schedule_desc				=	"";
		this.requisition_on_store		=	"";
		this.frequency					=	"";
		this.starting_from				=	"";
		this.auto_authorised			=	"";
		this.eff_status					=	"";
		this.schedule_code				=	"";
		applicableSchduleItems = new ArrayList();
		associated = new ArrayList();
		associated_sel = new ArrayList();
	}
	public String getDocTypes() {
		String optionValues = null;
		java.util.ArrayList alAutoScheduleRequestDoc = new java.util.ArrayList(5);
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alAutoScheduleRequestDoc.add(login_facility_id);
		alAutoScheduleRequestDoc.add("ISS");
		alAutoScheduleRequestDoc.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"), alAutoScheduleRequestDoc);
		
		if ((doc_type_code != null)) {
			optionValues = getListOptionTag(alOptionValues,getDefaultDocType());
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alAutoScheduleRequestDoc = null;
		alOptionValues = null;
		return optionValues;
	}
	public String getStores() {
		
		
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(getLoginById());
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(StRepository.getStKeyValue("SQL_SCHDULE_REQUEST_BY_STORE_SELECT"), alParam);
		optionValues = getListOptionTag(alOptionValues,getRequisition_by_store());
		alOptionValues = null;
		return optionValues;
				
	}
	public String getItemAnalysis(){
	  return getListOptionTag(getListOptionArrayList(StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"),getLanguageId()));
	}
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
			String chkParameters[] = {request_by_store,request_on_store,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			 return result;
	}
		
	public ArrayList loadItemDetails(String requisition_by_store,String requisition_on_store,String item_class_code,String consignment,String item_analysis_1,String item_analysis_2,String item_analysis_3, String item_desc,String searchby_type,String alpha_code,String item_code)	{
	
	
		ArrayList	appl_items		=	new ArrayList();
		applicableSchduleItems		=	new ArrayList();
		ArrayList alparam			=	new ArrayList();
		 try {
			alparam.add(requisition_by_store);
			alparam.add(getLanguageId());
			if(item_code.equals(""))
			alparam.add("%");
			else
			alparam.add(item_code);
			if(item_class_code.equals(""))
			alparam.add("%");
			else
			alparam.add(item_class_code);
			alparam.add(item_analysis_1);
			alparam.add(item_analysis_1);
			alparam.add(item_analysis_2);
			alparam.add(item_analysis_2);
			alparam.add(item_analysis_3);
			alparam.add(item_analysis_3);
			alparam.add(requisition_on_store);
			if(alpha_code.equals(""))
			alparam.add("%");
			else
			alparam.add(alpha_code);
			if(!item_desc.equals("")){
			if(item_desc.equals(""))
			item_desc="%";
			if(searchby_type.equals("S"))
			alparam.add(item_desc+"%");
			else if(searchby_type.equals("C"))
			alparam.add("%"+item_desc+"%");
			else
			alparam.add("%"+item_desc);
			}
			if(item_desc.equals("")){
			alparam.add("%");
			}
			if(consignment.trim().equals("A")){
			alparam.add("%");
			}else{
				alparam.add(consignment.trim());
			}
			alparam.add(requisition_by_store);
		 appl_items =fetchRecords(StRepository.getStKeyValue("SQL_SCHDULE_ITEMS_LOAD_SELECT"),alparam);
					for (int i=0;i<appl_items.size();i++ )
			{
			HashMap hh=(HashMap)appl_items.get(i);
			applicableSchduleItems.add((String)hh.get("ITEM_CODE"));
			applicableSchduleItems.add((String)hh.get("ITEM_DESC"));
			applicableSchduleItems.add((String)hh.get("FLAG"));
			applicableSchduleItems.add("I");
			if(!associated_sel.contains((String)hh.get("ITEM_CODE"))){
			associated_sel.add((String)hh.get("ITEM_CODE"));
			associated_sel.add((String)hh.get("ITEM_DESC"));
			associated_sel.add((String)hh.get("FLAG"));
			associated_sel.add("I");
			}
			}
			} catch ( Exception e ) {
                e.printStackTrace() ;
           
			}
			return applicableSchduleItems;
	}

	public ArrayList getStoredAssociated()	{
		ArrayList associated	=	new ArrayList();
		ArrayList beanvalues	= getAssociated_sel();
		if(beanvalues.size()!=0)	{
		for(int i=0; i<beanvalues.size(); i=i+4)		{
		String	rec	=	(String)beanvalues.get(i+2);
		String	ad_action	=	(String)beanvalues.get(i+3);
			if(rec.equals("Y") && ad_action.equals("I")  )  {
			associated.add((String)beanvalues.get(i+0));  
			associated.add((String)beanvalues.get(i+1)); 
			associated.add((String)beanvalues.get(i+2));
			associated.add((String)beanvalues.get(i+3)); 
			} else if(ad_action.equals("U")){
			associated.add((String)beanvalues.get(i+0));  
			associated.add((String)beanvalues.get(i+1)); 
			associated.add((String)beanvalues.get(i+2));
			associated.add((String)beanvalues.get(i+3)); 
			}
		}
		}
	return associated;
	}
  public HashMap insert()
    {
	
	    HashMap hmTableData = new HashMap();
        ArrayList alHdrData = new ArrayList();
        ArrayList alHdrRecord = new ArrayList();
	    ArrayList alDtlData= new ArrayList();
	    ArrayList alDtlRecord= null;
		ArrayList LanguageData = new ArrayList();
		LanguageData.add(getLanguageId());
        HashMap hmSQLMap = new HashMap();

		alHdrRecord.add(getLoginFacilityId());
		alHdrRecord.add(getSchedule_code());
		alHdrRecord.add(getSchedule_desc());
        alHdrRecord.add(getRequisition_by_store());
        alHdrRecord.add(getRequisition_on_store());
        alHdrRecord.add(getFrequency());
        alHdrRecord.add(getStarting_from());
        alHdrRecord.add(getAuto_authorised());
		alHdrRecord.add(getEff_status()); 
        alHdrRecord.add(getLoginById());
		alHdrRecord.add(getLoginAtWsNo());
		alHdrRecord.add(getLoginFacilityId());
		alHdrRecord.add(getLoginById());
		alHdrRecord.add(getLoginAtWsNo());
		alHdrRecord.add(getLoginFacilityId());
		alHdrRecord.add(getDoc_type_code());
		alHdrData.add(alHdrRecord);


		ArrayList beanvalues	= getAssociated_sel();
		if(beanvalues.size()!=0)	{
		for(int i=0; i<beanvalues.size(); i=i+4)		{
		String	rec	=	(String)beanvalues.get(i+2);
			if(rec.equals("Y") )  {
				alDtlRecord=new ArrayList();
				alDtlRecord.add(getLoginFacilityId());  
				alDtlRecord.add(getSchedule_code());  
				alDtlRecord.add((String)beanvalues.get(i+0));  
				alDtlRecord.add("E");  
				alDtlRecord.add(getLoginById());
				alDtlRecord.add(getLoginAtWsNo());
				alDtlRecord.add(getLoginFacilityId());
				alDtlRecord.add(getLoginById());
				alDtlRecord.add(getLoginAtWsNo());
				alDtlRecord.add(getLoginFacilityId());
				alDtlData.add(alDtlRecord);
			}
		}
		}
		hmSQLMap.put("hdrInsertSQL",StRepository.getStKeyValue("SQL_SCHDULE_AUTO_REQUEST_HDR_INSERT"));
        hmSQLMap.put("dtlInsertSQL",StRepository.getStKeyValue("SQL_SCHDULE_AUTO_REQUEST_DTL_INSERT"));
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrInsertData", alHdrData);
        hmTableData.put("DtlInsertData", alDtlData);
		hmTableData.put("LanguageData",LanguageData);
        return schduleAutoRequestMethodCall(hmTableData, hmSQLMap, 1);

	
	}


	public void setAll(Hashtable hashtable) {
	setRequisition_by_store((String)hashtable.get("requisition_by_store"));
	setDoc_type_code((String)hashtable.get("doc_type_code"));
	setRequisition_on_store((String)hashtable.get("requisition_on_store"));
	setSchedule_desc((String)hashtable.get("schedule_desc"));
	setFrequency((String)hashtable.get("frequency"));
	setStarting_from((String)hashtable.get("starting_from"));
	setAuto_authorised(checkForNull((String)hashtable.get("auto_authorised"),"N"));

	if((hashtable.get("eff_status")).toString().equals("")){
	setEff_status("D");
	}else{
	setEff_status("E");
	}
	setSchedule_code((String)hashtable.get("schedule_code")); 

	}



	 public HashMap schduleAutoRequestMethodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
			
        try
        {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/KitTemplate",KitTemplateLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			
			if(mode==2)
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			else
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
        catch(Exception exception) {
			exception.printStackTrace() ;
			}
			
			
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
        return hashmapResult;
    }

	public void loadData(String schdule_code){
try{
	ArrayList result = new ArrayList();
	ArrayList chkParameters =new ArrayList();
	chkParameters.add(login_facility_id);
	chkParameters.add(schdule_code.trim());
	result = fetchRecords(StRepository.getStKeyValue("SQL_SCHDULE_AUTO_REQUEST_HDR_SELECT"),chkParameters);
	for(int i=0;i<result.size();i++){
	HashMap data=(HashMap)result.get(i);
	setRequisition_by_store((String)data.get("REQUISITION_BY_STORE"));
	setDoc_type_code((String)data.get("DOC_TYPE_CODE"));
	setRequisition_on_store((String)data.get("REQUISITION_ON_STORE"));
	setSchedule_desc((String)data.get("SCHEDULE_DESC"));
	setFrequency((String)data.get("FREQUENCY"));
	setStarting_from((String)data.get("STARTING_FROM"));
	setAuto_authorised((String)data.get("AUTO_AUTHORISED"));
	setEff_status((String)data.get("EFF_STATUS"));
	setSchedule_code((String)data.get("SCHEDULE_CODE")); 
	setDefaultDocType(getDoc_type_code());
	}
	result = new ArrayList();
	chkParameters =new ArrayList();
	chkParameters.add(login_facility_id);
	chkParameters.add(schdule_code.trim());
	chkParameters.add(getLanguageId());
	result = new ArrayList();
	result = fetchRecords(StRepository.getStKeyValue("SQL_SCHDULE_AUTO_REQUEST_DTL_SELECT"),chkParameters);
	for(int i=0;i<result.size();i++){
	HashMap data=(HashMap)result.get(i);
	if(!associated_sel.contains((String)data.get("ITEM_CODE"))){
		associated_sel.add((String)data.get("ITEM_CODE"));
		associated_sel.add((String)data.get("ITEM_DESC"));
		associated_sel.add((String)data.get("FLAG"));
		associated_sel.add("U");
	}
	}
	}catch(Exception e){
		e.printStackTrace();
	}


	}

	public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			String chkParameters[] = {login_facility_id,getLanguageId(),getRequisition_by_store()};
			ArrayList result = new ArrayList();
			result = fetchRecords(StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE1"),chkParameters);
			return result;
	
	}
	public String getOnStoresQuery() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues,getRequisition_on_store());
		alOptionValues = null;
		return optionValues;
	}

	public String getItemClassesQuery() throws Exception {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getRequisition_by_store());
		alParam.add(getRequisition_on_store());
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues,"");
		alOptionValues = null;
		return optionValues;
		
	}

public HashMap modify(){
        HashMap hmTableData = new HashMap();
        ArrayList alHdrData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        ArrayList alDtlData= new ArrayList();
        ArrayList alUpdDtlData= new ArrayList();
        ArrayList alUpdHdrData = new ArrayList();
        ArrayList alInsDtlData = new ArrayList();
        ArrayList alUpdtDtlData = new ArrayList();
        HashMap hmSQLMap = new HashMap();
		ArrayList beanvalues	= getAssociated_sel();
		
		alHdrData.add(getFrequency());
		alHdrData.add(getStarting_from());
		alHdrData.add(getAuto_authorised());
		alHdrData.add(getEff_status()); 
		alHdrData.add(getLoginById());
		alHdrData.add(getLoginAtWsNo());
		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getSchedule_code());
		alUpdHdrData.add(alHdrData);

		if(beanvalues.size()!=0)	{
		for(int i=0; i<beanvalues.size(); i=i+4)		{
		String	rec	=	(String)beanvalues.get(i+2);
		String	db_action	=	(String)beanvalues.get(i+3);
			if(rec.equals("Y") && db_action.equals("I")  )  {
				alDtlData	= new ArrayList();
				alDtlData.add(getLoginFacilityId());  
				alDtlData.add(getSchedule_code().trim());  
				alDtlData.add((String)beanvalues.get(i+0));  
				alDtlData.add("E");  
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alInsDtlData.add(alDtlData);
			} else if(rec.equals("N") && db_action.equals("U")){
				alUpdDtlData	= new ArrayList();
				alUpdDtlData.add(getLoginFacilityId());
				alUpdDtlData.add(getSchedule_code().trim());
				alUpdDtlData.add((String)beanvalues.get(i+0));  
				alUpdtDtlData.add(alUpdDtlData);
			}
		}
		}
		 

        hmSQLMap.put("hdrUpdateSQL",getStRepositoryValue("SQL_SCHDULE_AUTO_REQUEST_HDR_UPDATE"));
        hmSQLMap.put("dtlUpdateSQL",getStRepositoryValue("SQL_SCHDULE_AUTO_REQUEST_DTL_DELETE"));
        hmSQLMap.put("dtlInsertSQL",getStRepositoryValue("SQL_SCHDULE_AUTO_REQUEST_DTL_INSERT"));
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrUpdateData", alUpdHdrData);
        hmTableData.put("DtlInsertData", alInsDtlData);
        hmTableData.put("DtlUpdateData", alUpdtDtlData);
		hmTableData.put("LanguageData",LanguageData);
        return schduleAutoRequestMethodCall(hmTableData, hmSQLMap, 2);
	}
	public java.util.HashMap canAuthorize(String store_code) { 
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(login_by_id);
			sqlParameter.add(store_code);
			return fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_REQ_AUTHORIZE_SELECT"),sqlParameter);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	
}
