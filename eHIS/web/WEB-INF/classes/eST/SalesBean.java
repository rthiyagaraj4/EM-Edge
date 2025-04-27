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
22/05/2017				IN064309				Badmavathi B												Store code mismatch for SALES Transaction
26/08/2019              IN071167                B Haribabu                                                  GHL-ICN-0050
30/01/2020      		IN071972            	Haribabu                                AAKH-CRF-0117.2 
22/9/2021		TFS22321			Shazana																	GHL-SCF-1587
24/02/2022				TFS29023 				Mohamed														Common-ICN-0091  
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
 package eST;


//import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import eST.Sales.SalesRemote;
import eST.Sales.SalesHome;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Collections;
import java.util.StringTokenizer;
import eST.Common.StAdapter; 
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
//import eCommon.Common.* ;
import java.text.DecimalFormat ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eST.Common.*;  
import eST.Common.StTransaction;

public class SalesBean extends StHeaderBean implements Serializable{

	private String patient_id;
	private String sal_trn_type;
	private String encounter_id; 
	private String physician_id; 
	private String patient_name;
	private String authorized_by_id;
	private String finalized_yn;  
	private String records_to_delete;
	private String remarks;
	private String billable_trn_yn;
	private String take_home_yn;
	private String chargeable;
	private ArrayList PDocNo = new ArrayList();
	// Added By Shaiju for SRR20056-SCF-6567 on 16/02/2011 starts
	private String PgetDoc_type_code = "";
	private String PgetDoc_Date = "";
	// Added By Shaiju for SRR20056-SCF-6567 on 16/02/2011 ends
	private String PgetStore_codest = "";
	//private String language_id;
	private String stReportid = null;
//	private HashMap		hmExpRecords=new HashMap();
//	private ArrayList	alDtlRecords=new ArrayList();
	private HashMap		hmExpRecords ;
	private ArrayList	alDtlRecords ;
	private int doc_srl_no		= 0;
	public String reportserver	= "";
	//Moved to StHeaderBean  By Shaiju on 08/02/2011
	//public String module_id		= "ST";
	public String ref_no		= "";
	public String report_connect_string = "";
	//public static int count		= 0;
	//private ArrayList	kitDataList = new ArrayList();
	private HashMap		bill_data   = new HashMap();
	private String sales_priority_type = "";
	private String NU_Clinic_code = "";
	private String  practitioner_id= "";
	private String  practitioner_name= "";
	private String Patient_age = "";
	private String Patient_sex = "";
	private String Patient_dob = "";
	private char Patient_dob_DMY ;

	
	
//	private javax.servlet.http.HttpServletRequest request;
//	private javax.servlet.http.HttpServletResponse response;


	public void initialize(){
		super.initialize();
		// added on 22/12
		hmExpRecords=new HashMap();
		alDtlRecords=new ArrayList();
		//kitDataList=new ArrayList();
		doc_srl_no	=	0;
		if(getModuleId().equals("ST")){
			patient_id="";  
			sal_trn_type="";
			encounter_id="";
			physician_id="";
			practitioner_name=""; //03/02/12
		}
		sales_priority_type="";
		patient_name="";
		authorized_by_id=""; 
		finalized_yn="";     
		remarks="";
		records_to_delete="";
		billable_trn_yn = "";
		take_home_yn = "";
		chargeable		= "";
		NU_Clinic_code="";
		practitioner_id="";
	  //practitioner_name="";
		Patient_age="";
		Patient_sex="";
		Patient_dob = "";
		//Patient_dob_DMY;
		// ended...
	}


	public void  clear(){
		super.clear();
		hmExpRecords=new HashMap();  
		alDtlRecords=new ArrayList();
		//kitDataList=new ArrayList();
		doc_srl_no	=	0;
		if(getModuleId().equals("ST")){
			patient_id="";  
			sal_trn_type="";
			encounter_id="";
			physician_id="";
			practitioner_name="";  //03/02/12
		}
		patient_name="";
		authorized_by_id=""; 
		finalized_yn="N";     
		remarks="";
		records_to_delete="";
		billable_trn_yn = "";
		take_home_yn = "";
		chargeable   = "";
		chargeable   = "";
		NU_Clinic_code = "";
		sales_priority_type="";
		practitioner_id="";
		//practitioner_name="";
		Patient_age="";
		Patient_sex="";
		Patient_dob= "";
		//Patient_dob_DMY;
	}

/*	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/

	/*public int getCount(){
		return count++;
	}
	public ArrayList getKitDtlData(){
		return kitDataList;
	}*/
	public HashMap getbill_data(){
		return (HashMap)bill_data;
	
	}
	public void setbill_data(HashMap bill_data){
		this.bill_data=bill_data;
	}

	public void setRemarks(String remarks) {
		 this.remarks= checkForNull(remarks);  
	}

	public String getRemarks( ) {
		 return remarks;
	}
	//Methods Moved to StHeaderBean   By Shaiju on 08/02/2011
	/*
	public void setModuleId(String module_id) {
		 this.module_id= checkForNull(module_id);  
	}

	public String getModuleId( ) {
		 return this.module_id;
	}
	*/

	public void setRefNo(String ref_no) {
		 this.ref_no= checkForNull(ref_no);  
	}

	public String getRefNo( ) {
		 return this.ref_no;
	}

	public void setAuthorized_by_id(String authorized_by_id) {
		 this.authorized_by_id= authorized_by_id;
	}

	public String getAuthorized_by_id( ) {
		 return authorized_by_id;
	}
	
	/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn= finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete= records_to_delete;
	}

	public String getRecords_to_delete( ) {
		 return records_to_delete;
	}

	public void setPatient_id(String patient_id) {
		 this.patient_id = patient_id;
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setSal_trn_type(String sal_trn_type) {
		 this.sal_trn_type = sal_trn_type;
	}

	public String getSal_trn_type( ) {
		
		 return sal_trn_type;
	}
	
	public void setEncounter_id(String encounter_id) {
		 this.encounter_id = encounter_id;
	}

	public String getEncounter_id( ) {
		 return encounter_id;
	}

	public void setPhysician_id(String physician_id) {
		 this.physician_id = physician_id;
	}

	public String getPhysician_id( ) {
		 return physician_id;
	}
	public void setPatient_name(String patient_name) {
		 this.patient_name = patient_name;
	}

	public String getPatient_name() {
		 return patient_name;
	}

	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	public int getDoc_srl_no(){
		return doc_srl_no;
	}

	public void setDoc_srl_no(String doc_srl_no){
		this.doc_srl_no=Integer.parseInt(doc_srl_no);
	}

	public void setBillable_trn_yn(String billable_trn_yn){
		this.billable_trn_yn = billable_trn_yn;
	}

	public String getBillable_trn_yn(){
		return this.billable_trn_yn;
	}

	public void setTake_home_yn(String take_home_yn){
		this.take_home_yn = take_home_yn;
	}

	public String getTake_home_yn(){
		return this.take_home_yn;
	}
	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}


	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	public void setSales_priority_type(String sales_priority_type) {
		 this.sales_priority_type = sales_priority_type;
	}

	public String getSales_priority_type( ) {
		
		 return sales_priority_type;
	}
	public void setNU_Clinic_code(String NU_Clinic_code) {
		 this.NU_Clinic_code = NU_Clinic_code;
	}

	public String getNU_Clinic_code( ) {
		
		 return NU_Clinic_code;
	}

	public void setPractitioner_id(String practitioner_id) {
		 this.practitioner_id = practitioner_id;
	}

	public String getPractitioner_id( ) {
		
		 return practitioner_id;
	}

	public void setPractitioner_name(String practitioner_name) {
	 this.practitioner_name = practitioner_name;
	}

	public String getPractitioner_name( ) {
		 return practitioner_name;
	}


	public void setPatient_age(String Patient_age) {
		 this.Patient_age = Patient_age;
	}

	public String getPatient_age() {		
		 return Patient_age;
	}

	public void setPatient_sex(String Patient_sex) {
		 this.Patient_sex = Patient_sex;
	}

	public String getPatient_sex( ) {		
		 return Patient_sex;
	}


	public void setPatient_dob(String Patient_dob) {
		 this.Patient_dob = Patient_dob;
	}

	public String getPatient_dob( ) {		
		 return Patient_dob;
	}

	public void setPatient_age_DMY(char Patient_dob_DMY) {
		 this.Patient_dob_DMY = Patient_dob_DMY;
	}

	public char getPatient_age_DMY( ) {		
		 return Patient_dob_DMY;
	}






	public void updateDtlRecord(int index, HashMap hmDtlRecord){
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		if (index!=-1){
			mode	=	(String)((HashMap)alDtlRecords.get(index)).get("mode");
		}
		hmDtlRecord.put("mode",mode);
		
		if (index==-1){
			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
//			mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
			alDtlRecords.add(hmDtlRecord);
		}
		else
			alDtlRecords.set(index, hmDtlRecord);
			
	} 

	public HashMap getDtlRecord(int index){
		return (HashMap)alDtlRecords.get(index);
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}

	public void updateExpRecords(int index, Hashtable htExpRecords){
		if (index==-1) {
			index	=	alDtlRecords.size()-1;
		}

		ArrayList alExpRecords	=	(ArrayList)hmExpRecords.get(""+index);
		for (int i=0;i<alExpRecords.size(); i++) {
			HashMap hmExpRecord	=	(HashMap)alExpRecords.get(i);
			hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
//			alExpRecords.set(i,hmExpRecord);//not required.
		}
		for(int i=0;i<alExpRecords.size();)
		{
			if(  ((String)((HashMap)alExpRecords.get(i)).get("QTY")).equals("")   )
			 {	
				HashMap hmAldtlData = (HashMap)alDtlRecords.get(index);
				int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));
				--batch_records;//corrected  by gangadharan on 14/06/2011 against inc#-7385
				hmAldtlData.put("batch_records",""+batch_records);
				alDtlRecords.set(index,hmAldtlData);
				alExpRecords.remove(i); 
			}
			else 
				i++;
		}
		setExpRecords(index, alExpRecords);
	}

	public void setExpRecords(int index, ArrayList alExpRecords){
		if (index==-1) {
			index	=	alDtlRecords.size();
		}
		hmExpRecords.put(""+index,alExpRecords);
	}
	
	public ArrayList getExpRecords(int index){
		return (ArrayList)hmExpRecords.get(""+index);
	}

	public HashMap getExpRecords(){
		return hmExpRecords;
	}

	public String getBLModuleInstalled() throws Exception
	{
		HashMap result = fetchRecord(getStRepositoryValue( "SQL_ST_SAL_CHARGEABLE_YN"));
		String result_yn = (String)result.get("BL_INTERFACE_YN");
		
		return result_yn;


	}

	public void setChargeable(String chargeable){
		this.chargeable = chargeable;
	}

	public String getChargeable()
	{
		return this.chargeable;
	}

	
	public void setAll(Hashtable hashtable) {
		patient_id	=(String)hashtable.get("patient_id");  
		sal_trn_type=(String)hashtable.get("sal_trn_type");  
		setRemarks((String)hashtable.get("remarks"));  
		setEncounter_id(checkForNull((String)hashtable.get("encounter_id"),checkForNull((String)hashtable.get("encounter_ot"))));  
		this.patient_name=(String)hashtable.get("patient_name");  
		authorized_by_id =(String)hashtable.get("authorized_by_id");  
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		records_to_delete=(String)hashtable.get("records_to_delete"); 
		take_home_yn	= checkForNull((String)hashtable.get("discharge_yn"),"N");
		billable_trn_yn	=  checkForNull((String)hashtable.get("chargeable_yn"),"N");
		sales_priority_type	=  checkForNull((String)hashtable.get("sales_priority_type"),"R");
		NU_Clinic_code	=  checkForNull((String)hashtable.get("NU_Clinic_code"));
		NU_Clinic_code	=  checkForNull((String)hashtable.get("NU_Clinic_code"));
		practitioner_name	=  checkForNull((String)hashtable.get("practitioner_name"));
		practitioner_id	=  checkForNull((String)hashtable.get("practitioner_id"));
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
		Patient_age	=  checkForNull((String)hashtable.get("Patient_age")) + checkForNull((String)hashtable.get("Patient_age_DMY"));
		}
		else{
		Patient_age	=  checkForNull((String)hashtable.get("Patient_age"));		
		}
		Patient_sex	=  checkForNull((String)hashtable.get("Patient_sex"));

		String Patient_age_DMY1 = checkForNull((String)hashtable.get("Patient_age_DMY"));

		if(sal_trn_type !=null && sal_trn_type.equals("X")){
		ArrayList alParameters = new  ArrayList();
		alParameters.add((String)hashtable.get("Patient_age"));
		if(Patient_age_DMY1.equals("D"))
		alParameters.add("1");		
		else if(Patient_age_DMY1.equals("M"))
		alParameters.add("30");		
		else if(Patient_age_DMY1.equals("Y"))
		alParameters.add("365");		
		try{
		HashMap	hmRecord	=	fetchRecord("select to_char(trunc(sysdate-(? * ?)),'dd/mm/yyyy') date_of_birth from dual", alParameters);
		Patient_dob = checkForNull((String)hmRecord.get("DATE_OF_BIRTH"));
		}
		catch(Exception e){
		}
		}
		else{
		Patient_dob = checkForNull((String)hashtable.get("Patient_dob"));
		}


		setRecords_to_delete_for_barcode(records_to_delete);//added for barcode

    }
/*
	public ArrayList getEncounterArrayList(String patient_id,String sal_trn_type,String siteId) throws Exception{ 
		String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type};
		if((getModuleId()).equals("ST")){
			//return fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST"),stParameters);
			if(siteId.equals("MC"))
			{
				return fetchRecords("SELECT	encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter WHERE facility_id=? AND patient_id=upper(?) AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09','08') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') order by encounter_id desc",stParameters);
			}
			else
			{
				return fetchRecords("SELECT	encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter WHERE facility_id=? AND patient_id=upper(?) AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') order by encounter_id desc",stParameters);
			}
		}else{
			return fetchRecords(getStRepositoryValue("SELECT	encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter	WHERE facility_id=?	AND	patient_id=upper(?) /*AND ( visit_status	IN ('01', '02',	'04') OR adt_status	='01' )*/	/*and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') order by encounter_id desc"),stParameters);
		}
	}

*/

//modified by gangadharan to list the Encounter after the discharge advise is prepared 


	public ArrayList getEncounterArrayList(String patient_id,String sal_trn_type,String siteId) throws Exception{ 
		   
		if((getModuleId()).equals("ST")){
            
			String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type,getLoginFacilityId(),getLoginFacilityId()};
		  	
		    return	fetchRecords("SELECT encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter a WHERE facility_id=? AND patient_id= upper(?) AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') and 'Y' = OR_GET_ACCESS_RULE(?,a.encounter_id,'PH',a.patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'), to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI'), (SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=? and ENCOUNTER_ID=a.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1) ) order by VISIT_ADM_DATE_TIME desc",stParameters);
		
		}else{
            
			String stParameters1[]={getLoginFacilityId(),patient_id,sal_trn_type};

			return fetchRecords(getStRepositoryValue("SELECT	encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter	WHERE facility_id=?	AND	patient_id=upper(?) /*AND ( visit_status	IN ('01', '02',	'04') OR adt_status	='01' )*/	and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') order by encounter_id desc"),stParameters1);
		}
	}




	public String getEncounter_id_List(){
		String stParameters[]={getLoginFacilityId(),getPatient_id(),getSal_trn_type()};
		if((getModuleId()).equals("ST")){
			//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST"), stParameters),getEncounter_id());
			return getListOptionTag(getListOptionArrayList("SELECT	encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter WHERE facility_id=? AND patient_id=upper(?) AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') order by encounter_id desc", stParameters),getEncounter_id());
		}else{
			return getListOptionTag(getListOptionArrayList("SELECT	ENCOUNTER_ID, ENCOUNTER_ID ITISTOPOPULATELISTBOX  FROM PR_ENCOUNTER	WHERE FACILITY_ID=?	AND	PATIENT_ID=UPPER(?) /*AND ( VISIT_STATUS	IN ('01', '02',	'04') OR ADT_STATUS	='01' )*/	AND PATIENT_CLASS= DECODE(?, 'I', 'IP','O','OP','E','EM','D','DC') ORDER BY ENCOUNTER_ID DESC", stParameters),getEncounter_id());
		}
	}

	public ArrayList getEncounterNewArrayList(String patient_id,String encounter_id,String sal_trn_type,String siteId) throws Exception{ 
			String stParameters[]={getLoginFacilityId(),patient_id,encounter_id,sal_trn_type,getLoginFacilityId(),getLoginFacilityId()};
		  	return	fetchRecords("SELECT encounter_id  FROM pr_encounter a WHERE facility_id=? AND patient_id= upper(?) AND encounter_id= ? AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') and 'Y' = OR_GET_ACCESS_RULE(?,a.encounter_id,'PH',a.patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'), to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI'), (SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=? and ENCOUNTER_ID=a.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1) ) order by VISIT_ADM_DATE_TIME desc",stParameters);
	}

	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean
		not required to process exp records..*/
 		return getMessageHashMap(true);	
	}

	public String getSal_trn_type_List() {
        return getStaticListOptionTag("I,InPatient;O,OutPatient;R,Referral;", getSal_trn_type());
    }
	
	public void loadData() throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alDtlRecords = new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());

		/*PE Mahesh 4/23/2010*/
			String bl_install_yn = getBLModuleInstalled();
			String bl_decimal	 = getBlDecimal();
		/*PE*/
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_SAL_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		doc_srl_no		=	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));
		
		setNextDoc_srl_noforBarCode(doc_srl_no);
		
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

		**/
		int no_of_decimals=getNoOfDecimals();
		//String disp_decimal_dtls_yn=getDispDecimalDtlsYN();
	//	String allow_decimals_yn="N";
		
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

		**/
		alParameters	=	new ArrayList();
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());


		hmRecord	=	fetchRecord("SELECT	st.remarks,TO_CHAR(doc_date,'dd/mm/yyyy') doc_date, doc_ref, store_code, st.patient_id, encounter_id, sal_trn_type, DECODE(SAL_TRN_TYPE,'X', st.PATIENT_NAME, mp.patient_name)patient_name , item_class_code,BILLABLE_TRN_YN,TAKE_HOME_YN,LOCN_CODE,PRIORITY,PRACTITIONER_ID , (SELECT PRACTITIONER_NAME FROM am_practitioner_lang_vw a WHERE a.practitioner_id = st.practitioner_id and language_id= ? ) AS PRACTITIONER_NAME , st.AGE, st.SEX ,TO_CHAR(st.date_of_birth,'dd/mm/yyyy') date_of_birth,ST.PRACTITIONER_NAME AS PRACT_NAME FROM ST_SAL_HDR st, mp_patient	mp WHERE mp.patient_id=st.patient_id AND facility_id=? AND doc_type_code=? AND doc_no=?", alParameters);//modified for GHL-SCF-1369
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setStore_code((String)hmRecord.get ("STORE_CODE"));  
		setPatient_id((String)hmRecord.get ("PATIENT_ID"));  
		setSal_trn_type(checkForNull((String)hmRecord.get("SAL_TRN_TYPE")));
		setEncounter_id(checkForNull((String)hmRecord.get("ENCOUNTER_ID")));
		setPatient_name(checkForNull((String)hmRecord.get("PATIENT_NAME")));
		setItem_class_code(checkForNull((String)hmRecord.get("ITEM_CLASS_CODE")));
		setChargeable((String)hmRecord.get("BILLABLE_TRN_YN"));
		setTake_home_yn((String)hmRecord.get("TAKE_HOME_YN"));
		setRemarks(checkForNull((String)hmRecord.get("REMARKS")));  
		setNU_Clinic_code(checkForNull((String)hmRecord.get("LOCN_CODE")));  
		setSales_priority_type(checkForNull((String)hmRecord.get("PRIORITY"),"R"));  
		setSales_priority_type(checkForNull((String)hmRecord.get("PRIORITY"),"R"));  
		setPractitioner_id(checkForNull((String)hmRecord.get("PRACTITIONER_ID")));  
		//setPractitioner_name(checkForNull((String)hmRecord.get("PRACTITIONER_NAME")));  COMMENTED FOR GHL-SCF-1369
		
		if(checkForNull((String)hmRecord.get("SAL_TRN_TYPE")).equals("X")){
		String RemoveLastChar = checkForNull((String)hmRecord.get("AGE"));
		if (RemoveLastChar!=null || RemoveLastChar!= ""){
		int char_at_last =   RemoveLastChar.length();

		String age = RemoveLastChar.substring(0, char_at_last-1);
		char Patient_age_DMY_value = RemoveLastChar.charAt(char_at_last-1);
		
		setPatient_age(age);  
		setPatient_age_DMY(Patient_age_DMY_value); 		
		setPractitioner_name(checkForNull((String)hmRecord.get("PRACT_NAME")));  //ADDED FOR FOR GHL-SCF-1369
		}
		}		
		else{
		setPatient_age(checkForNull((String)hmRecord.get("AGE")));  
		//setPatient_age_DMY(checkForNull((char)hmRecord.get("AGE")));
		setPractitioner_name(checkForNull((String)hmRecord.get("PRACTITIONER_NAME")));  //ADDED FOR FOR GHL-SCF-1369
		}


		setPatient_sex(checkForNull((String)hmRecord.get("SEX"))); 		
		setPatient_dob(checkForNull((String)hmRecord.get("DATE_OF_BIRTH"))); 
		

		alParameters	=	new ArrayList();
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getStore_code());
		alParameters.add(getLanguageId());
		//alParameters.add(getLanguageId());
		//alParameters.add(getLanguageId());
	//	alParameters.add(getLanguageId());
		//ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_DTL_SELECT_MULTIPLE"), alParameters);
		//This query is commented by Mahesh for PE Two language id parameters also commented.
		//ArrayList alRecords	=	fetchRecords("SELECT  nvl(stitem.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,STITEM.EXPIRY_YN EXPIRY_YN, DTL.DOC_SRL_NO,DTL.REMARKS REMARKS_CODE, (SELECT REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE DTL.REMARKS = TRN_REMARKS_CODE AND LANGUAGE_ID = ?) REMARKS,DTL.STOCK_ITEM_YN, ITEM_QTY,SUM (AVAIL_QTY) /* + ITEM_QTY*/ STOCK_AVAILABLE,ROUND ((  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND)),3) UNIT_COST,ROUND (  (  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND))* ITEM_QTY,3) ITEM_SAL_VALUE,PAT_NET_AMT, GROSS_CHARGE_AMT, STSTR.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE = STSTR.DEF_ISSUE_UOM) UOM_DESC,BL_INCL_EXCL_OVERRIDE_REASON P_OVERRIDDEN_ACTION_REASON,BL_INCL_EXCL_OVERRIDE_VALUE P_OVERRIDDEN_EXCL_INCL_IND,(SELECT ACTION_REASON_DESC FROM BL_ACTION_REASON_LANG_VW WHERE ACTION_REASON_CODE = DTL.BL_INCL_EXCL_OVERRIDE_REASON AND LANGUAGE_ID = ?) OVERRIDE_REASON_DESC FROM ST_SAL_DTL DTL, MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,ST_BATCH_SEARCH_LANG_VIEW BSVIEW,ST_ITEM_STORE STSTR WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE = STSTR.ITEM_CODE AND BSVIEW.STORE_CODE = STSTR.STORE_CODE AND DTL.ITEM_CODE = BSVIEW.ITEM_CODE(+) AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND  (DTL.STOCK_ITEM_YN = 'N' OR BSVIEW.STORE_CODE = ?) AND MMITEM.LANGUAGE_ID = BSVIEW.LANGUAGE_ID AND MMITEM.LANGUAGE_ID = ? AND BSVIEW.LANG1 = ? AND BSVIEW.LANG2 = ? GROUP BY DTL.DOC_NO, DTL.ITEM_CODE,MMITEM.SHORT_DESC,STITEM.EXPIRY_YN,DTL.DOC_SRL_NO,DTL.REMARKS,DTL.STOCK_ITEM_YN,ITEM_QTY,ROUND ((  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND)),3),ROUND (  (  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND))* ITEM_QTY,3),PAT_NET_AMT,GROSS_CHARGE_AMT,STSTR.DEF_ISSUE_UOM,BL_INCL_EXCL_OVERRIDE_REASON,BL_INCL_EXCL_OVERRIDE_VALUE,stitem.ALLOW_DECIMALS_YN", alParameters);
		/*PE by Mahesh on 4/23/2010*/
		//ArrayList alRecords	=	fetchRecords("SELECT NVL (STITEM.ALLOW_DECIMALS_YN, 'N') ALLOW_DECIMALS_YN, DTL.DOC_NO,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,STITEM.EXPIRY_YN EXPIRY_YN, DTL.DOC_SRL_NO, DTL.REMARKS REMARKS_CODE,(SELECT REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE DTL.REMARKS = TRN_REMARKS_CODE AND LANGUAGE_ID = ?) REMARKS,DTL.STOCK_ITEM_YN, ITEM_QTY,SUM (BSVIEW.QTY_ON_HAND - BSVIEW.COMMITTED_QTY) STOCK_AVAILABLE,ROUND ((  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE) / DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND) ),3) UNIT_COST,ROUND (  (  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND))* ITEM_QTY,3) ITEM_SAL_VALUE,PAT_NET_AMT, GROSS_CHARGE_AMT, STSTR.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE = STSTR.DEF_ISSUE_UOM) UOM_DESC, BL_INCL_EXCL_OVERRIDE_REASON P_OVERRIDDEN_ACTION_REASON,BL_INCL_EXCL_OVERRIDE_VALUE P_OVERRIDDEN_EXCL_INCL_IND,(SELECT ACTION_REASON_DESC FROM BL_ACTION_REASON_LANG_VW WHERE ACTION_REASON_CODE = DTL.BL_INCL_EXCL_OVERRIDE_REASON AND LANGUAGE_ID = ?) OVERRIDE_REASON_DESC FROM ST_SAL_DTL DTL, MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,ST_ITEM_BATCH BSVIEW,ST_ITEM_STORE STSTR WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE = STSTR.ITEM_CODE AND BSVIEW.STORE_CODE = STSTR.STORE_CODE AND DTL.ITEM_CODE = BSVIEW.ITEM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND (DTL.STOCK_ITEM_YN = 'N' OR BSVIEW.STORE_CODE = ?) AND MMITEM.LANGUAGE_ID = ? GROUP BY DTL.DOC_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC,STITEM.EXPIRY_YN,DTL.DOC_SRL_NO,DTL.REMARKS,DTL.STOCK_ITEM_YN,ITEM_QTY,ROUND ((  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND)),3), ROUND (  (  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND))* ITEM_QTY,3),PAT_NET_AMT,GROSS_CHARGE_AMT,STSTR.DEF_ISSUE_UOM,BL_INCL_EXCL_OVERRIDE_REASON,BL_INCL_EXCL_OVERRIDE_VALUE,STITEM.ALLOW_DECIMALS_YN", alParameters);
		//ArrayList alRecords	=	fetchRecords("SELECT (CASE WHEN MMITEM.GEN_UOM_CODE = STSTR.DEF_ISSUE_UOM THEN 1 ELSE ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE,STSTR.STORE_CODE) END) CONV_FACTOR,NVL (STITEM.ALLOW_DECIMALS_YN, 'N') ALLOW_DECIMALS_YN, DTL.DOC_NO,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,STITEM.EXPIRY_YN EXPIRY_YN, DTL.DOC_SRL_NO, DTL.REMARKS REMARKS_CODE,(SELECT REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE DTL.REMARKS = TRN_REMARKS_CODE AND LANGUAGE_ID = ?) REMARKS, DTL.STOCK_ITEM_YN, ITEM_QTY,SUM (BSVIEW.QTY_ON_HAND - BSVIEW.COMMITTED_QTY) STOCK_AVAILABLE,ROUND ((  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND)),3) UNIT_COST,ROUND (  (  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND))* ITEM_QTY,3) ITEM_SAL_VALUE,PAT_NET_AMT, GROSS_CHARGE_AMT, STSTR.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE = STSTR.DEF_ISSUE_UOM) UOM_DESC,BL_INCL_EXCL_OVERRIDE_REASON P_OVERRIDDEN_ACTION_REASON,BL_INCL_EXCL_OVERRIDE_VALUE P_OVERRIDDEN_EXCL_INCL_IND,(SELECT ACTION_REASON_DESC FROM BL_ACTION_REASON_LANG_VW WHERE ACTION_REASON_CODE = DTL.BL_INCL_EXCL_OVERRIDE_REASON AND LANGUAGE_ID = ?) OVERRIDE_REASON_DESC , (ITEM_QTY * (CASE WHEN MMITEM.GEN_UOM_CODE = STSTR.DEF_ISSUE_UOM THEN 1 ELSE ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE,STSTR.STORE_CODE) END)) TOT_ITEM_QTY FROM     ST_SAL_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,ST_ITEM_BATCH BSVIEW,ST_ITEM_STORE STSTR WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE = STSTR.ITEM_CODE AND BSVIEW.STORE_CODE = STSTR.STORE_CODE AND DTL.ITEM_CODE = BSVIEW.ITEM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND (DTL.STOCK_ITEM_YN = 'N' OR BSVIEW.STORE_CODE = ?) AND MMITEM.LANGUAGE_ID = ? GROUP BY DTL.DOC_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC,STITEM.EXPIRY_YN,DTL.DOC_SRL_NO,DTL.REMARKS,DTL.STOCK_ITEM_YN,ITEM_QTY,ROUND ((  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND)),3),ROUND (  (  DECODE (STSTR.QTY_ON_HAND, 0, 0, STSTR.ITEM_VALUE)/ DECODE (STSTR.QTY_ON_HAND, 0, 1, STSTR.QTY_ON_HAND))* ITEM_QTY,3),PAT_NET_AMT,GROSS_CHARGE_AMT,STSTR.DEF_ISSUE_UOM,BL_INCL_EXCL_OVERRIDE_REASON,BL_INCL_EXCL_OVERRIDE_VALUE,STITEM.ALLOW_DECIMALS_YN,STSTR.STORE_CODE,MMITEM.GEN_UOM_CODE", alParameters);

		/**
		 * @Name - Priya
		 * @Date - 18/05/2010
		 * @Inc# - 
		 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' the above query is modified 
		 */
		int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
		//commented on 18/09/12
		//ArrayList alRecords	=	fetchRecords("SELECT (CASE WHEN MMITEM.GEN_UOM_CODE = STSTR.DEF_ISSUE_UOM THEN 1 ELSE ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE,STSTR.STORE_CODE) END) CONV_FACTOR,NVL (STITEM.ALLOW_DECIMALS_YN, 'N') ALLOW_DECIMALS_YN, DTL.DOC_NO,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,STITEM.EXPIRY_YN EXPIRY_YN, DTL.DOC_SRL_NO, DTL.REMARKS REMARKS_CODE,(SELECT REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE DTL.REMARKS = TRN_REMARKS_CODE AND LANGUAGE_ID = ?) REMARKS, DTL.STOCK_ITEM_YN, ITEM_QTY,SUM (BSVIEW.QTY_ON_HAND - BSVIEW.COMMITTED_QTY) STOCK_AVAILABLE,TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, STSTR.STORE_CODE )) UNIT_COST, (TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, STSTR.STORE_CODE )) * DTL.ITEM_QTY) ITEM_SAL_VALUE,PAT_NET_AMT, GROSS_CHARGE_AMT, STSTR.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = STSTR.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) UOM_DESC,BL_INCL_EXCL_OVERRIDE_REASON P_OVERRIDDEN_ACTION_REASON,BL_INCL_EXCL_OVERRIDE_VALUE P_OVERRIDDEN_EXCL_INCL_IND,(SELECT ACTION_REASON_DESC FROM BL_ACTION_REASON_LANG_VW WHERE ACTION_REASON_CODE = DTL.BL_INCL_EXCL_OVERRIDE_REASON AND LANGUAGE_ID = ?) OVERRIDE_REASON_DESC , (ITEM_QTY * (CASE WHEN MMITEM.GEN_UOM_CODE = STSTR.DEF_ISSUE_UOM THEN 1 ELSE ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE,STSTR.STORE_CODE) END)) TOT_ITEM_QTY,MMITEM.BILLABLE_ITEM_YN BILLABLE_ITEM_YN,NVL(DTL.SALE_REQ_QTY,0) SALE_REQ_QTY FROM     ST_SAL_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,ST_ITEM_BATCH BSVIEW,ST_ITEM_STORE STSTR WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE = STSTR.ITEM_CODE AND BSVIEW.STORE_CODE = STSTR.STORE_CODE AND DTL.ITEM_CODE = BSVIEW.ITEM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND (DTL.STOCK_ITEM_YN = 'N' OR BSVIEW.STORE_CODE = ?) AND MMITEM.LANGUAGE_ID = ? GROUP BY DTL.DOC_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC,STITEM.EXPIRY_YN,DTL.DOC_SRL_NO,DTL.REMARKS,DTL.STOCK_ITEM_YN,ITEM_QTY,PAT_NET_AMT,GROSS_CHARGE_AMT,STSTR.DEF_ISSUE_UOM,BL_INCL_EXCL_OVERRIDE_REASON,BL_INCL_EXCL_OVERRIDE_VALUE,STITEM.ALLOW_DECIMALS_YN,STSTR.STORE_CODE,MMITEM.GEN_UOM_CODE,MMITEM.BILLABLE_ITEM_YN,DTL.SALE_REQ_QTY order by dtl.doc_srl_no", alParameters);
		//Modified by suresh.r on 19-08-2014 against Inc #50616
		//Modified by suresh.r on 13-11-2014 against Inc 52256(Added 2 args to ST_DISPLAY_UNIT_COST)
		ArrayList alRecords	=	fetchRecords("SELECT (CASE WHEN MMITEM.GEN_UOM_CODE = STSTR.DEF_ISSUE_UOM THEN 1 ELSE ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE,STSTR.STORE_CODE) END) CONV_FACTOR,NVL (STITEM.ALLOW_DECIMALS_YN, 'N') ALLOW_DECIMALS_YN, DTL.DOC_NO,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,STITEM.EXPIRY_YN EXPIRY_YN, DTL.DOC_SRL_NO, DTL.REMARKS REMARKS_CODE,(SELECT REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE DTL.REMARKS = TRN_REMARKS_CODE AND LANGUAGE_ID = ?) REMARKS, DTL.STOCK_ITEM_YN, ITEM_QTY,SUM (BSVIEW.QTY_ON_HAND - BSVIEW.COMMITTED_QTY) STOCK_AVAILABLE,TRIM(ST_DISPLAY_UNIT_COST(DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE, STSTR.STORE_CODE )) UNIT_COST, (TRIM(ST_DISPLAY_UNIT_COST(DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE, STSTR.STORE_CODE )) * DTL.ITEM_QTY) ITEM_SAL_VALUE,PAT_NET_AMT, GROSS_CHARGE_AMT, STSTR.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = STSTR.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) UOM_DESC,BL_INCL_EXCL_OVERRIDE_REASON P_OVERRIDDEN_ACTION_REASON,BL_INCL_EXCL_OVERRIDE_VALUE P_OVERRIDDEN_EXCL_INCL_IND,(SELECT ACTION_REASON_DESC FROM BL_ACTION_REASON_LANG_VW WHERE ACTION_REASON_CODE = DTL.BL_INCL_EXCL_OVERRIDE_REASON AND LANGUAGE_ID = ?) OVERRIDE_REASON_DESC , (ITEM_QTY * (CASE WHEN MMITEM.GEN_UOM_CODE = STSTR.DEF_ISSUE_UOM THEN 1 ELSE ST_GET_UOM_CONV_FAC_SING_STR (DTL.ITEM_CODE,STSTR.STORE_CODE) END)) TOT_ITEM_QTY,MMITEM.BILLABLE_ITEM_YN BILLABLE_ITEM_YN,NVL(DTL.SALE_REQ_QTY,0) SALE_REQ_QTY,DTL.USAGE_TYPE,DTL.APPROVAL_NO FROM     ST_SAL_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,ST_ITEM_BATCH BSVIEW,ST_ITEM_STORE STSTR WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE = STSTR.ITEM_CODE AND BSVIEW.STORE_CODE = STSTR.STORE_CODE AND DTL.ITEM_CODE = BSVIEW.ITEM_CODE AND DTL.FACILITY_ID = ? AND DTL.DOC_TYPE_CODE = ? AND DTL.DOC_NO = ? AND (DTL.STOCK_ITEM_YN = 'N' OR BSVIEW.STORE_CODE = ?) AND MMITEM.LANGUAGE_ID = ? GROUP BY DTL.DOC_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC,STITEM.EXPIRY_YN,DTL.DOC_SRL_NO,DTL.REMARKS,DTL.STOCK_ITEM_YN,ITEM_QTY,PAT_NET_AMT,GROSS_CHARGE_AMT,STSTR.DEF_ISSUE_UOM,BL_INCL_EXCL_OVERRIDE_REASON,BL_INCL_EXCL_OVERRIDE_VALUE,STITEM.ALLOW_DECIMALS_YN,STSTR.STORE_CODE,MMITEM.GEN_UOM_CODE,MMITEM.BILLABLE_ITEM_YN,DTL.SALE_REQ_QTY,DTL.USAGE_TYPE,DTL.APPROVAL_NO  order by dtl.doc_srl_no", alParameters);//Modified for for IN:071972
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",setNumber((String)hmRecord.get("ITEM_SAL_VALUE"),noOfDecimalsForCost));
			//hmTemp.put("item_unit_cost",hmRecord.get("UNIT_COST"));
			//Modified by suresh.r on 19-08-2014 against Inc #50616
			hmTemp.put("item_unit_cost",setNumber((String)hmRecord.get("UNIT_COST"),noOfDecimalsForCost));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS")));
			hmTemp.put("remarks_code",checkForNull((String)hmRecord.get("REMARKS_CODE")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

			**/
			if(((String)hmRecord.get("ALLOW_DECIMALS_YN")).equals("Y")){
			//double stock_available = (Double.parseDouble(setNumber((String)hmRecord.get("STOCK_AVAILABLE"),no_of_decimals))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getStore_code()))+Double.parseDouble(setNumber((String)hmRecord.get("ITEM_QTY"),no_of_decimals));
		//	double stock_available = (Double.parseDouble(setNumber((String)hmRecord.get("STOCK_AVAILABLE"),no_of_decimals))/Double.parseDouble((String)hmRecord.get("CONV_FACTOR")))+Double.parseDouble(setNumber((String)hmRecord.get("ITEM_QTY"),no_of_decimals));
			String avilableQTY	=getAvailableQty ((String)hmRecord.get("ITEM_CODE"),getStore_code());
			double stock_available = (Double.parseDouble(setNumber(avilableQTY,no_of_decimals))/Double.parseDouble((String)hmRecord.get("CONV_FACTOR")))+Double.parseDouble(setNumber((String)hmRecord.get("ITEM_QTY"),no_of_decimals));
			hmTemp.put("stock_available",setNumber(""+stock_available,no_of_decimals));
			hmTemp.put("item_qty",setNumber((String)hmRecord.get("ITEM_QTY"),no_of_decimals));
			hmTemp.put("sale_req_qty",setNumber((String)hmRecord.get("SALE_REQ_QTY"),no_of_decimals));
			}else{
				/*PE Mahesh on 4/23/2010*/
			//double stock_available = ((Double.parseDouble((String)hmRecord.get("STOCK_AVAILABLE")))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getStore_code()))+Double.parseDouble((String)hmRecord.get("ITEM_QTY"));
			String avilableQTY	=getAvailableQty ((String)hmRecord.get("ITEM_CODE"),getStore_code());
			double stock_available = ((Double.parseDouble(avilableQTY))/Double.parseDouble((String)hmRecord.get("CONV_FACTOR")))+Double.parseDouble((String)hmRecord.get("ITEM_QTY"));
			hmTemp.put("stock_available",setNumber(""+stock_available,0));
			hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
			hmTemp.put("sale_req_qty",hmRecord.get("SALE_REQ_QTY"));
		
			}
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

			**/

			/** @ before modication
			int stock_available = (( Integer.parseInt((String)hmRecord.get("STOCK_AVAILABLE")))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getStore_code()))+ Integer.parseInt((String)hmRecord.get("ITEM_QTY"));
			hmTemp.put("stock_available",""+stock_available);
			**/
			hmTemp.put("stock_item_yn",hmRecord.get("STOCK_ITEM_YN"));
			//hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("gross_charge_amt",hmRecord.get("GROSS_CHARGE_AMT"));
			hmTemp.put("pat_net_amt",hmRecord.get("PAT_NET_AMT"));
			hmTemp.put("p_overridden_excl_incl_ind",checkForNull((String)hmRecord.get("P_OVERRIDDEN_EXCL_INCL_IND")));
			hmTemp.put("p_overridden_action_reason",checkForNull((String)hmRecord.get("P_OVERRIDDEN_ACTION_REASON")));
			hmTemp.put("bl_incl_excl_override_reason_desc",checkForNull((String)hmRecord.get("OVERRIDE_REASON_DESC")));
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin
			**/
			hmTemp.put("decimal_allowedYN",checkForNull((String)hmRecord.get("ALLOW_DECIMALS_YN"),"N"));
			hmTemp.put("allow_decimals_yn",checkForNull((String)hmRecord.get("ALLOW_DECIMALS_YN"),"N"));
			hmTemp.put("no_of_decimals",""+no_of_decimals);
			hmTemp.put("billable_item_yn",checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N"));
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end
			**/
			if(bl_install_yn.equals("Y") && checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N").equals("Y")){
				//String tot_item_qty = ""+Double.parseDouble((String)hmRecord.get("ITEM_QTY"))* (getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)getStore_code()));
				//HashMap hmBlChargeDtls = (HashMap)getBillingDetail("", "",(String)hmRecord.get("ITEM_CODE"),tot_item_qty,bl_decimal);
				HashMap hmBlChargeDtls = (HashMap)getBillingDetail("", "",(String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("TOT_ITEM_QTY"),bl_decimal);
				hmTemp.put("bl_def_override_excl_incl_ind",hmBlChargeDtls.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"));
				hmTemp.put("pat_paid_amt",checkForNull((String)hmBlChargeDtls.get("PATIENT_PAID_AMT"),"0.0"));
				hmTemp.put("approval_reqd_yn",hmBlChargeDtls.get("BL_APPROVAL_REQD_YN"));
				hmTemp.put("bl_override_allowed_yn",hmBlChargeDtls.get("BL_OVERRIDE_ALLOWED_YN"));
				hmTemp.put("gross_charge_amt",hmBlChargeDtls.get("BL_TOTAL_CHARGE_AMT"));
				hmTemp.put("pat_net_amt",hmBlChargeDtls.get("BL_PATIENT_PAYABLE_AMT"));
			}
			hmTemp.put("usage_type",checkForNull((String)hmRecord.get("USAGE_TYPE")));
			hmTemp.put("approval_no",checkForNull((String)hmRecord.get("APPROVAL_NO")));//Added for IN:071972
			alDtlRecords.add(hmTemp);
			setalDtlRecordsforBarCode(hmTemp);//added for barcode
			//alDtlRecordsforBarCode.add(hmTemp);

			
		}
		
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		//alParameters.add(getLanguageId());
		alRecords	=	fetchRecords("SELECT NVL(ST.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,BATCHVIEW.TRADE_ID, BATCHVIEW.QTY_ON_HAND, BATCHVIEW.USE_AFTER_EXPIRY_YN,	BATCHVIEW.EXPIRY_YN EXPIRY_YN, (BATCHVIEW.AVAIL_QTY+STEXP.SAL_ITEM_QTY)AVAIL_QTY, BATCHVIEW.TRADE_ID_APPLICABLE_YN,	BATCHVIEW.MANUFACTURER_ID, STEXP.SAL_ITEM_QTY QTY, BATCHVIEW.STORE_DESC, BATCHVIEW.TRADE_NAME, BATCHVIEW.NOD NOD, BATCHVIEW.ITEM_DESC, BATCHVIEW.MANUFACTURER_NAME,	 BATCHVIEW.STORE_CODE, BATCHVIEW.SUSPENDED_YN, BATCHVIEW.ITEM_CODE,	BATCHVIEW.BIN_LOCATION_CODE, TO_CHAR(BATCHVIEW.EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_DATE, BATCHVIEW.BIN_DESC, BATCHVIEW.BATCH_ID,BATCHVIEW.BATCH_STATUS BATCH_STATUS,STEXP.BARCODE_ID BARCODE_ID FROM ST_BATCH_SEARCH_LANG_VIEW BATCHVIEW, ST_SAL_DTL_EXP STEXP,ST_ITEM ST WHERE BATCHVIEW.STORE_CODE=STEXP.STORE_CODE AND BATCHVIEW.ITEM_CODE=STEXP.ITEM_CODE AND BATCHVIEW.BATCH_ID=STEXP.BATCH_ID AND BATCHVIEW.BIN_LOCATION_CODE=STEXP.BIN_LOCATION_CODE AND BATCHVIEW.EXPIRY_DATE=STEXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STEXP.FACILITY_ID=? AND STEXP.DOC_TYPE_CODE=? AND STEXP.DOC_NO=? AND BATCHVIEW.LANGUAGE_ID = ? AND BATCHVIEW.LANG1 = ? AND BATCHVIEW.LANG2 = ? /*AND STEXP.DOC_SRL_NO=?*/ AND ST.ITEM_CODE = STEXP.ITEM_CODE", alParameters);
		/*PE Mahesh 4/23/2010*/
		/*for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			alParameters.set(6,(String)hmRecord.get("doc_srl_no"));
			//alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_DTL_EXP_SELECT_MULTIPLE"), alParameters);
			alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_DTL_EXP_SELECT_MULTIPLE"), alParameters);
		for(int j=0;j<alRecords.size();j++){
			HashMap dataList		=		(HashMap)alRecords.get(j);
			if(((String)dataList.get("ALLOW_DECIMALS_YN")).equals("Y")){
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
			dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),no_of_decimals));
			dataList.put("QTY",setNumber((String)dataList.get("QTY"),no_of_decimals));
			}else{
				dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
				dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
				dataList.put("QTY",setNumber((String)dataList.get("QTY"),0));
			}
			alRecords.set(j,dataList);
			}
			hmRecord.put("batch_records",""+alRecords.size());
			hmExpRecords.put(""+i,alRecords);
		
		}*/
		int k = 0;
		ArrayList alRecordsTemp = new ArrayList();
		for (int i=0; i<alDtlRecords.size(); i++) {
			k = 0;
			alRecordsTemp = new ArrayList();
			hmRecord	=	(HashMap)alDtlRecords.get(i);

			for(int j=0;j<alRecords.size();j++){
				HashMap dataList		=		(HashMap)alRecords.get(j);
				if(((String)hmRecord.get("item_code")).equals((String)dataList.get("ITEM_CODE"))){
					++k;
					if(((String)dataList.get("ALLOW_DECIMALS_YN")).equals("Y")){
						dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
						dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),no_of_decimals));
						dataList.put("QTY",setNumber((String)dataList.get("QTY"),no_of_decimals));
					}else{
						dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
						dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
						dataList.put("QTY",setNumber((String)dataList.get("QTY"),0));
					}
					alRecordsTemp.add(dataList);
				}
			}
		
			hmRecord.put("batch_records",""+k);
			hmExpRecords.put(""+i,alRecordsTemp);
			setExpRecordsforBarCode(i,alRecordsTemp); // added for barcode
			//hmExpRecordsforBarCode.put(""+i,alRecordsTemp);

		}


		//System.out.println("alRecords"+alRecords);
		//System.out.println("alDtlRecords"+alDtlRecords);
		/*PE*/
		StringBuffer sb_batch_data=new StringBuffer();
		HashMap	hmExpRecord		= new HashMap();
	for (int j=0; j<alDtlRecords.size(); j++) {
				sb_batch_data = new StringBuffer();
				 hmRecord	=	(HashMap)alDtlRecords.get(j);
				for (int p=0;p<alRecords.size() ;p++ ) {
					hmExpRecord		= (HashMap)alRecords.get(p);

					if(((String)hmRecord.get("item_code")).equals(hmExpRecord.get("ITEM_CODE"))){
						sb_batch_data.append(hmExpRecord.get("TRADE_ID"));
						sb_batch_data.append(";");
						sb_batch_data.append(hmExpRecord.get("BATCH_ID"));
						sb_batch_data.append(";");
						sb_batch_data.append(hmExpRecord.get("EXPIRY_DATE"));
						sb_batch_data.append(";");
						sb_batch_data.append(hmExpRecord.get("BIN_LOCATION_CODE"));
						sb_batch_data.append(";");
//						allow_decimals_yn=getAllowDecimalsYN( connection, (String)hmExpRecord.get("ITEM_CODE"));
						if(((String)hmRecord.get("allow_decimals_yn")).equals("Y") ){
							sb_batch_data.append(setNumber((String)hmExpRecord.get("QTY"),no_of_decimals));
						}else{
							sb_batch_data.append(setNumber((String)hmExpRecord.get("QTY"),0));
						}
						sb_batch_data.append(";");
					}
				}

		if(bl_install_yn.equals("Y") &&				checkForNull((String)hmRecord.get("billable_item_yn"),"N").equals("Y")){
				HashMap hmBlChargeDtls = (HashMap)getBillingDetail("", "",(String)hmRecord.get("item_code"),(String)hmRecord.get("item_qty"),bl_decimal,sb_batch_data.toString());
				hmRecord.put("bl_def_override_excl_incl_ind",hmBlChargeDtls.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"));
				hmRecord.put("pat_paid_amt",checkForNull((String)hmBlChargeDtls.get("PATIENT_PAID_AMT"),"0.0"));
				hmRecord.put("approval_reqd_yn",hmBlChargeDtls.get("BL_APPROVAL_REQD_YN"));
				hmRecord.put("bl_override_allowed_yn",hmBlChargeDtls.get("BL_OVERRIDE_ALLOWED_YN"));
				hmRecord.put("gross_charge_amt",hmBlChargeDtls.get("BL_TOTAL_CHARGE_AMT"));
				hmRecord.put("pat_net_amt",hmBlChargeDtls.get("BL_PATIENT_PAYABLE_AMT"));
			}
				
			alDtlRecords.set(j,hmRecord);
			setalDtlRecordsforBarCode(j,hmRecord);// added for barcode
			//alDtlRecordsforBarCode.set(j,hmRecord);
		}
	}

	public HashMap insert(){
 	//	HashMap hmResult=new HashMap();;
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
//		ArrayList alCommonData	=	new ArrayList();
		ArrayList allanguageData	=	new ArrayList();

		HashMap hmCommonData	=	new HashMap();
		allanguageData.add(getLanguageId());
		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		//System.out.println("747,getPhysician_id() = > "+getPhysician_id());
		//hmCommonData.put("p_ord_practitioner_id",getPhysician_id()	);
		//System.out.println("749,getPhysician_id() = > "+hmCommonData.get("p_ord_practitioner_id"));

		if (getModuleId().equals("ST")){
			if (getSal_trn_type().equals("X")){
			hmCommonData.put("p_ord_practitioner_id",getPractitioner_name());
			}
			else{
			hmCommonData.put("p_ord_practitioner_id",getPractitioner_id());
			}
		}
		else{
		hmCommonData.put("practitioner_id",getPhysician_id());
		hmCommonData.put("p_ord_practitioner_id",getPhysician_id());		
		}

		if(getSal_trn_type().equals("X"))
		{
			hmCommonData.put("practitioner_name",getPractitioner_name()	);
		}
		else
		{
		//Added by Rabbani inc no:26404 on 07/02/12
		  if(getModuleId().equals("OT")){
		  hmCommonData.put("practitioner_id",getPhysician_id());
		   }else{
		   hmCommonData.put("practitioner_id",getPractitioner_id()	);
		  }
		}
		
		int no_of_decimals=getNoOfDecimals();

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getDoc_date());
		alHdrData.add(getDoc_ref());
		alHdrData.add(getStore_code());
		
		alHdrData.add(getAuthorized_by_id());
		alHdrData.add("");//cancel_by_id
		alHdrData.add("");//cancel remarks
		alHdrData.add(getFinalized_yn());
		alHdrData.add("N");//gl_interface
		alHdrData.add("SAL");
		alHdrData.add("N");
		alHdrData.add(getPatient_id());
		alHdrData.add(getEncounter_id());
		alHdrData.add(checkForNull(getSal_trn_type(),"I"));
		alHdrData.add(getRemarks());
		alHdrData.add(getItem_class_code());
		alHdrData.add(getBillable_trn_yn());
		alHdrData.add(getTake_home_yn());
		//alHdrData.add(getTake_home_yn());
		alHdrData.add("");//token_series_code
		alHdrData.add("");//token_serial_no
		if(getSal_trn_type().equals("X"))
			alHdrData.add(this.patient_name);
		else
		alHdrData.add("");
		alHdrData.add(getModuleId());
		alHdrData.add(getRefNo());
		alHdrData.add(getSales_priority_type());
		alHdrData.add(getNU_Clinic_code());
		alHdrData.add(getPatient_age());
		alHdrData.add(getPatient_sex());
		alHdrData.add(getPatient_dob());

		try {
//alDtlRecords
			
			hmCommonData.put("FACILITY_STR_FOR_BL",getLoginFacilityId()+"|"+(String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID"));
			
			//StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");


			StringTokenizer stRecordsToDelete;
			
			if(getBarcodeApplicable().equals("Y")){				
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete_for_barcode(),",");
			}
			else{			
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			}

			//System.out.println("SalesBean---if--alDtlRecords_size--"+getRecords_to_delete_for_barcode());

			int alDtlRecords_size = 0;

			if(getBarcodeApplicable().equals("Y")){

				ArrayList alDtl  = getDtlRecordsforBarCode();

				alDtlRecords_size	=	alDtl.size();
				//System.out.println("SalesBean---if--alDtlRecords_size--"+alDtlRecords_size);
				}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();
				//System.out.println("SalesBean---else--alDtlRecords_size--"+alDtlRecords_size);
			}


			for (int i=0;i<alDtlRecords_size;i++) {
//				if (stRecordsToDelete.hasMoreTokens()) {
				String nextToken = stRecordsToDelete.nextToken();



				HashMap hmDtlRecord	= null;

				//System.out.println("SalesBean-----getBarcodeApplicable--"+getBarcodeApplicable());

				if(getBarcodeApplicable().equals("Y")){
				hmDtlRecord	=	getDtlRecordforBarCode(i);
				//System.out.println("SalesBean---if--hmDtlRecord--"+hmDtlRecord);
				}
				else{	
				hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				//System.out.println("SalesBean---else--hmDtlRecord--"+hmDtlRecord);
				}
				
				
				//HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);

				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					//ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					ArrayList sourceArrayList = null;

				if(getBarcodeApplicable().equals("Y")){
				sourceArrayList	=	getExpRecordsforBarCode(i);
				//System.out.println("SalesBean---if--sourceArrayList--"+sourceArrayList);
				}
				else{	
				sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
				//System.out.println("SalesBean---else--sourceArrayList--"+sourceArrayList);
				}

					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							int batch_srl_no = j+1;
							hmExpRecord.put("batch_srl_no",""+batch_srl_no);	
							alExpData.add(hmExpRecord);
						}
				}
				/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin
				**/
				if( getAllowDecimalsYN((String)hmDtlRecord.get("item_code")).equals("Y") ){
				double mm_trn_qty = (Double.parseDouble(setNumber((String)hmDtlRecord.get("item_qty"),no_of_decimals))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,no_of_decimals));
				}else{
				double mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty"))))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code()));
				hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,0));
				}
				/* @Name - Priya
				* @Date - 18/05/2010
				* @Inc# - 
				* @Desc - As unit cost is derived from the function ST_DISPLAY_COST_DECIMALS the below round up code is commented

				//hmDtlRecord.put("item_unit_cost",setNumber((String)hmDtlRecord.get("item_unit_cost"),3));
				/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end
				**/
				
				/** @ before modification
				int mm_trn_qty = Integer.parseInt((String)hmDtlRecord.get("item_qty"))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code()));
				hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
				**/
				alDtlData.add(hmDtlRecord);
			}
			 String sql_multi_user_chk = "Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
			ArrayList temp;
			String temp_store_code = "";//Added for IN064309
			for(int i=0;i<alExpData.size();i++){
			HashMap hmExpRecord	=	(HashMap)alExpData.get(i);
			if(i==0){
				temp_store_code = (String)hmExpRecord.get("STORE_CODE");//Added for IN064309
			}
			temp=new ArrayList();
			//temp.add(getStore_code()); //curr_store_code
			temp.add((String)hmExpRecord.get("STORE_CODE")); //Modified against IN064309
			temp.add((String)hmExpRecord.get("ITEM_CODE"));	// ITEM_CODE
			temp.add((String)hmExpRecord.get("BATCH_ID"));  //BATCH_ID
			temp.add((String)hmExpRecord.get("BIN_LOCATION_CODE")); //BIN_LOCATION_CODE
			temp.add((String)hmExpRecord.get("EXPIRY_DATE"));	//EXPIRY_DATE
			hmExpRecord.put("modified_date",(String)((HashMap)fetchRecord(sql_multi_user_chk,temp)).get("MODIFIED_DATE"));
			alExpData.set(i,hmExpRecord);
			}
			if(!getStore_code().equals(temp_store_code))
				alHdrData.set(5, temp_store_code);//Added for IN064309
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	hmCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		if((getItemClassBased("SAL").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"SAL");
		}
		return salesMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap delete(){
// 		HashMap hmResult		=	new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		ArrayList allanguageData	=	new ArrayList();
		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);
		//hmCommonData.put("p_ord_practitioner_id",getPhysician_id()	);

		if (getModuleId().equals("ST")){
			if (getSal_trn_type().equals("X")){
			hmCommonData.put("p_ord_practitioner_id",getPractitioner_name());
			}
			else{
			hmCommonData.put("p_ord_practitioner_id",getPractitioner_id());
			}
		}
		else{
		hmCommonData.put("p_ord_practitioner_id",getPhysician_id());		
		}

		try{
		hmCommonData.put("FACILITY_STR_FOR_BL",getLoginFacilityId()+"|"+(String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID"));
		}catch(Exception e){
			e.printStackTrace();
		}
		allanguageData.add(getLanguageId());
		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());

		hmTableData.put("properties",	getProperties());
		hmTableData.put("DATA",			alHdrData);
		hmTableData.put("COMMON_DATA",	hmCommonData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
			
		return salesMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}

	public HashMap modify(){
 	HashMap hmResult=new HashMap();;
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_SAL_RET_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?  AND FINALIZED_YN='Y'",alParam)).get("COUNT"));
		}catch(Exception e){
			hmResult.put("result",false);
			hmResult.put("msgid","OPER_CANCELLED");
			hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
			e.printStackTrace();
			return hmResult;
		}
		if(doc_count>0){
			hmResult.put("result",false);
			hmResult.put("msgid","ST_DOC_NO_FINALIZED_USER");
			hmResult.put("message",getSTMessage(getLanguageId(),"ST_DOC_NO_FINALIZED_USER","ST"));
			return hmResult;
		}
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		ArrayList allanguageData	=	new ArrayList();
		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);
		//hmCommonData.put("p_ord_practitioner_id",getPhysician_id()	);
		hmCommonData.put("practitioner_id",getPractitioner_id()	);
		hmCommonData.put("practitioner_name",getPractitioner_name()	);

		if (getModuleId().equals("ST")){
			if (getSal_trn_type().equals("X")){
			hmCommonData.put("p_ord_practitioner_id",getPractitioner_name());
			}
			else{
			hmCommonData.put("p_ord_practitioner_id",getPractitioner_id());
			}
		}
		else{
		hmCommonData.put("p_ord_practitioner_id",getPhysician_id());		
		}

		allanguageData.add(getLanguageId());
		
		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getDoc_date());
		alHdrData.add(getDoc_ref());
		alHdrData.add(getStore_code());
		alHdrData.add(getAuthorized_by_id());
		alHdrData.add("");//cancel_by_id
		alHdrData.add("");//cancel remarks
		alHdrData.add(getFinalized_yn());
		alHdrData.add("N");//gl_interface
		alHdrData.add("SAL");
		alHdrData.add("N");
		alHdrData.add(getPatient_id());
		alHdrData.add(getEncounter_id());
		alHdrData.add(getSal_trn_type());
		alHdrData.add(getRemarks());
		alHdrData.add(getItem_class_code());
		alHdrData.add(getLoginAtWsNo());
		alHdrData.add(getLoginFacilityId());
		//code for updating billable and takehome...

		alHdrData.add(getChargeable());
		alHdrData.add(getTake_home_yn());
		alHdrData.add(getModuleId());
		alHdrData.add(getPatient_age());
		alHdrData.add(getPatient_sex());
		alHdrData.add(getPatient_dob());
   

		try {
//alDtlRecords
			int no_of_decimals=getNoOfDecimals();
		
		hmCommonData.put("FACILITY_STR_FOR_BL",getLoginFacilityId()+"|"+(String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID"));
			
			//StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			
			StringTokenizer stRecordsToDelete ;
			
			if(getBarcodeApplicable().equals("Y")){				
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete_for_barcode(),",");
			}
			else{			
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			}




			int alDtlRecords_size = 0;

			if(getBarcodeApplicable().equals("Y")){

				ArrayList alDtl  = getDtlRecordsforBarCode();

				alDtlRecords_size	=	alDtl.size();
				//System.out.println("SalesBean-mod--if--alDtlRecords_size--"+alDtlRecords_size);
				}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();
				//System.out.println("SalesBean-mod--else--alDtlRecords_size--"+alDtlRecords_size);
			}



			for (int i=0;i<alDtlRecords_size;i++) {
//				if (stRecordsToDelete.hasMoreTokens()) {
				String nextToken = stRecordsToDelete.nextToken();

				HashMap hmDtlRecord	= null;

				//System.out.println("SalesBean--mod---getBarcodeApplicable--"+getBarcodeApplicable());

				if(getBarcodeApplicable().equals("Y")){
				hmDtlRecord	=	getDtlRecordforBarCode(i);
				//System.out.println("SalesBean--mod-if--hmDtlRecord--"+hmDtlRecord);
				}
				else{	
				hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				//System.out.println("SalesBean--mod-else--hmDtlRecord--"+hmDtlRecord);
				}
				
				//HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);




				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || ((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE")) ){//Modified for IN071167 added delete condition
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
				//	ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);


					ArrayList sourceArrayList = null;

				if(getBarcodeApplicable().equals("Y")){
				sourceArrayList	=	getExpRecordsforBarCode(i);
				//System.out.println("SalesBean--mod-if--sourceArrayList--"+sourceArrayList);
				}
				else{	
				sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
				//System.out.println("SalesBean-mod--else--sourceArrayList--"+sourceArrayList);
				}



					for (int j=0;j<sourceArrayList.size(); j++ ) {
						HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						int batch_srl_no = j+1;
						hmExpRecord.put("batch_srl_no",""+batch_srl_no);
						alExpData.add(hmExpRecord);
					}
				}
				/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin
				**/
				if(getAllowDecimalsYN((String)hmDtlRecord.get("item_code")).equals("Y")){
				double mm_trn_qty = (Double.parseDouble(setNumber((String)hmDtlRecord.get("item_qty"),no_of_decimals))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,no_of_decimals));
				}else{
				double mm_trn_qty = Double.parseDouble((String)hmDtlRecord.get("item_qty"))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code()));
				hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,0));
				}
				/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end
				**/
				/** @ before modification
				double mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
				**/
				alDtlData.add(hmDtlRecord);
			}
			 String sql_multi_user_chk = "Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
			 String temp_store_code = "";//Added for IN064309
			ArrayList temp;
			for(int i=0;i<alExpData.size();i++){
			HashMap hmExpRecord	=	(HashMap)alExpData.get(i);
			if(i==0){
				temp_store_code = (String)hmExpRecord.get("STORE_CODE");//Added for IN064309
			}
			temp=new ArrayList();
			//temp.add(getStore_code()); //curr_store_code
			temp.add((String)hmExpRecord.get("STORE_CODE")); //Modified for //Added for IN064309
			temp.add((String)hmExpRecord.get("ITEM_CODE"));	// ITEM_CODE
			temp.add((String)hmExpRecord.get("BATCH_ID"));  //BATCH_ID
			temp.add((String)hmExpRecord.get("BIN_LOCATION_CODE")); //BIN_LOCATION_CODE
			temp.add((String)hmExpRecord.get("EXPIRY_DATE"));	//EXPIRY_DATE
			hmExpRecord.put("modified_date",(String)((HashMap)fetchRecord(sql_multi_user_chk,temp)).get("MODIFIED_DATE"));
			alExpData.set(i,hmExpRecord);
			}
			//Added for IN064309 starts
			if(!getStore_code().equals(temp_store_code))
				alHdrData.set(5, temp_store_code);
			//Added for IN064309 ends
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	hmCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
					}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return salesMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap salesMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
/*
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = new eST.Sales12.SalesManager().insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					hmResult = new eST.Sales12.SalesManager().modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					hmResult = new eST.Sales12.SalesManager().delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to salesMethodCall()") ;
			}

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		return hmResult;
*/

		HashMap		hmResult	=	new HashMap()	;
//		SalesHome	salesHome		= null ;
		SalesRemote	salesRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			/*InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_SALES") ) ;

			salesHome  = (SalesHome) PortableRemoteObject.narrow( object, SalesHome.class ) ;
			salesRemote = salesHome.create() ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_SALES"),SalesHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass();
			paramArray[1] = hmSQLMap.getClass();
			switch (functionID)
			{
				case FUNCTION_INSERT:
					 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					//hmResult = salesRemote.insert( hmTableData, hmSQLMap ) ;
		            setbill_data(hmResult);
					break;
				
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = salesRemote.modify( hmTableData, hmSQLMap ) ;
					setbill_data(hmResult);
					break;
				
				case FUNCTION_DELETE:
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					//hmResult = salesRemote.delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to salesMethodCall()") ;
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  ){
					hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			}
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

/* SEND TO PRINT ONLINE REPORT STARTS 9/27/2004 */		



	        ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetStore_codest  = getStore_code() ;
			// Added By Shaiju for SRR20056-SCF-6567 on 16/02/2011 starts
			PgetDoc_Date =  getDoc_date();
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getStore_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBSALDC";

			//if (finalized_yn.substring(0,1).equals("Y") && hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()) ||(finalized_yn.substring(0,1).equals("N") && getCustomerID().equals("MC")) )

			if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))

/*			if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))*/
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}
						else{
							/*doOnlineReportPrinting(doc_no);				
							String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}
							*/
							hmResult.put("flag",hmResult.get("flag") + "~PN");
						}
				 }
			}
		

/* SEND TO PRINT ONLINE REPORT ENDS*/	
		} 
		catch(Exception exception) {
			System.out.println("SalesBeans.java,1170 = > "+exception.getMessage());
			System.out.println("SalesBeans.java,1171 = > "+hmResult);
			System.out.println("SalesBeans.java,1171 hmTableData= > "+hmTableData);
			if(((String)hmResult.get("message")).contains(": BL"))
			{
				hmResult.put("message",(((String)hmResult.get("msgid")).substring(((String) hmResult.get( "msgid" )).indexOf(":"))+1).replaceFirst(":",""));
				//hmResult.put("message",(String) hmResult.get( "msgid" ));
			}
			else if(((String)hmResult.get("message")).startsWith("BL"))
			{
				 //hmResult.put("message",exception.getMessage());
				 hmResult.put("msgid","");
			}
			else if((exception.getMessage()).contains(": BL"))
			{
				hmResult.put("message",(((String)hmResult.get("msgid")).substring(((String) hmResult.get( "msgid" )).indexOf(":"))+1).replaceFirst(":",""));
				//hmResult.put("message",(String) hmResult.get( "msgid" ));
			}
			else if(exception.getMessage().startsWith("BL"))
			{
				 hmResult.put("message",exception.getMessage());
				 hmResult.put("msgid","");
			}  /* This else if was added by Dinesh T on 2/25/2011 */
			//Added by suresh.r on 23-01-2014 to display errmsg to UI beg
			else if(((String)hmResult.get("message")).contains("Item:") || ((String)hmResult.get("message")).startsWith("ERROR_BL:"))
			{}
			else if((exception.getMessage()).contains("Item:") || (exception.getMessage()).startsWith("ERROR_BL:"))
			{}
			//Added by suresh.r on 23-01-2014 to display errmsg to UI end
			else{
				if(((String)hmResult.get( "msgid" )).contains("INSUFFICIENT_BATCH_QTY")) {
					hmResult.put( "message", getSTMessage(getLanguageId(),"INSUFFICIENT_BATCH_QTY","ST"))  ;
				}
				else if(((String)hmResult.get("message")).contains("NEGATIVE_STOCK"))
				{
					StringTokenizer stkTok = new StringTokenizer((String)hmResult.get("message"),"!~");
					System.out.println("1182 = > "+hmResult.get("message"));
					int i=0;
					String param[] = new String[2];
					while(stkTok.hasMoreTokens())
					{				
						param[i] = stkTok.nextToken();
						System.out.println("1189 = > "+param[i]);
						i++;
					}
					//String[] msg = ((String)hmResult.get("message")).split("!~");
					hmResult.put( "message",getSTMessage(getLanguageId(),"NEGATIVE_STOCK","ST")+" "+param[1]);
				}
				else{
				hmResult.put( "message", "Transaction Failed") ;
			}
			}
			exception.printStackTrace() ;
		} finally {
			try {
				if( salesRemote != null )
					salesRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}
/*	if (finalized_yn.equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
		if (isInternalRequest("ST","STBSALDC")) {
			String doc_no	=	(String)hmResult.get("doc_no");	
			doOnlineReportPrinting(doc_no);				
		}
	}*/

		return hmResult;
	}
	/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			String reportid = "STBSALDC";
			if (!isInternalRequest("ST",reportid)) return;
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;
         //   javax.servlet.http.HttpSession session = request.getSession(false);
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			//hmParameters.put("jdbc",session.getAttribute("jdbc"));
			//hmParameters.put("report_server",session.getAttribute("report_server"));
			//hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
			// Added By Shaiju for SRR20056-SCF-6567 on 16/02/2011 starts
            
			reportid = "STCERTREIM_SRR";

			System.out.println("print allowed..."+isDocTypePrintAllowed(PgetDoc_type_code));
			System.out.println("internal  rep..."+isInternalRequest("ST",reportid));
			System.out.println("PgetStore_codest..."+PgetStore_codest);
			System.out.println("PgetDoc_Date..."+PgetDoc_Date);
			
			hmReportParameter	=	new HashMap();
			
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("P_DOC_DATE",PgetDoc_Date);
			hmReportParameter.put("P_STORE_CODE",PgetStore_codest );
			hmReportParameter.put("p_language_id",getLanguageId());
			
			System.out.println("print allowed..."+isDocTypePrintAllowed(PgetDoc_type_code));
			
         	
			hmParameters	=	new HashMap();
			
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);  //getStore_code() ;

			
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start(); 



			reportid = "STMEDLIST_SRR";

			hmReportParameter	=	new HashMap();
			
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("P_DOC_DATE",PgetDoc_Date);
			hmReportParameter.put("P_STORE_CODE",PgetStore_codest );
			hmReportParameter.put("p_language_id",getLanguageId());
							
         	
			hmParameters	=	new HashMap();
			
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);  //getStore_code() ;

			
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start(); 
			
			
			//Added By Shaiju for SRR20056-SCF-6567 on 16/02/2011 Ends
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/


public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBSALDC";
			//String copies = getNoOfCopies(reportid);

			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;

				if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );

			 reportid = "STCERTREIM_SRR";
			if (!isInternalRequest("ST",reportid)) return;
			//ecis.utils.OnlineReports onlineReports 	= null;
			//ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				report2.addParameter("P_DOC_DATE",PgetDoc_Date);
				report2.addParameter("P_STORE_CODE",PgetStore_codest );
				onlineReports.add( report2) ;

				if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );

		    reportid = "STMEDLIST_SRR";
			if (!isInternalRequest("ST",reportid)) return;
			//ecis.utils.OnlineReports onlineReports 	= null;
			//ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				report2.addParameter("P_DOC_DATE",PgetDoc_Date);
				report2.addParameter("P_STORE_CODE",PgetStore_codest );
				onlineReports.add( report2) ;

				if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}


	public String getAllItem_class_List() {
		ArrayList arr_language=new ArrayList();
			//arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return getListValues(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST1"),arr_language,"");
	}

	public String getSALStore_code_List() {
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		return getListValues(eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_SAL_STORE_SELECT"),alParameters,getStore_code());
	}

	public String getAuthorize_allowed_yn(String stStore_code) throws Exception{
		// Changed by Shaiju on 08/02/2011 Starts
		
		String stParameters[]= new String[2];
		if(getModuleId().equals("OT"))
		{
			 stParameters[0]	= getSlateUserId();
			 stParameters[1]	=  stStore_code;
		}
		else
		{
			 stParameters[0]	= getLoginById();
			 stParameters[1]	=  stStore_code;
			 //stParameters[]	=	{getLoginById(), stStore_code};
		}
		// Changed by Shaiju on 08/02/2011 Ends
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("SAL_AUTHORIZE_ALLOWED_YN").toString();
	}

	public HashMap callBillingHdrProcedure(String patient_id,String encounter_id,String sal_trn_type)throws Exception{
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap();
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
			sal_trn_type = "R";
		}
		
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_SAL_HDR_VALIDATIONS (?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, encounter_id);
			callableStatement.setString(4, sal_trn_type);
			callableStatement.setString(5, getDoc_date());
			callableStatement.registerOutParameter(6, Types.VARCHAR);
			callableStatement.registerOutParameter(7, Types.VARCHAR);
			callableStatement.registerOutParameter(8, Types.VARCHAR);
			callableStatement.registerOutParameter(9, Types.VARCHAR);
			callableStatement.execute();
			message.put("error_id" , checkForNull((String)callableStatement.getString(7)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(8)));
			message.put("warning_msg" , checkForNull((String)callableStatement.getString(9)));

			
		}
		catch(Exception exception){
			message.put("error_id" , checkForNull((String)callableStatement.getString(7)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(8)));
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return message;
	}


		public HashMap callBillingItemVadProcedure(String patient_id,String encounter_id,String sal_trn_type,String item_code)throws Exception{
	
	
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap();
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
			sal_trn_type = "R";
		}
				
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_SAL_ITEM_VALIDATIONS (?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?) }");
			//callableStatement.setString(1, (String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID"));
/*			System.out.println("login_facility_id for ST_BL_SAL_ITEM_VALIDATIONS..... "+login_facility_id);
			System.out.println("patient_id for ST_BL_SAL_ITEM_VALIDATIONS..... "+patient_id);
			System.out.println("encounter_id for ST_BL_SAL_ITEM_VALIDATIONS..... "+encounter_id);
			System.out.println("sal_trn_type for ST_BL_SAL_ITEM_VALIDATIONS..... "+sal_trn_type);
			System.out.println("getDoc_date() for ST_BL_SAL_ITEM_VALIDATIONS..... "+getDoc_date());
			System.out.println("item_code for ST_BL_SAL_ITEM_VALIDATIONS..... "+item_code);*/
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, encounter_id);
			callableStatement.setString(4, sal_trn_type);
			callableStatement.setString(5, getDoc_date());
			callableStatement.setString(6, item_code);
			callableStatement.registerOutParameter(7, Types.VARCHAR);
			callableStatement.registerOutParameter(8, Types.VARCHAR);
			callableStatement.registerOutParameter(9, Types.VARCHAR);
			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.execute();
			message.put("error_id" , checkForNull((String)callableStatement.getString(8)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(9)));
			message.put("warning_msg" , checkForNull((String)callableStatement.getString(10)));
			

			
		}
		catch(Exception exception){
			message.put("error_id" , checkForNull((String)callableStatement.getString(7)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(8)));
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		
		return message;
	
	}

	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,String item_qty)throws Exception{
	

		DecimalFormat dfTest = new DecimalFormat("##.00");
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap();
        StringBuffer sb_batch_data  = new StringBuffer();
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
			sal_trn_type = "R";
		}
		/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications begin
		**/
	
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(item_code);
	
		/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
		**/
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			//select facility_id from mm_store where store_code = 'PHINPS'
			callableStatement.setString(1, login_facility_id+"|"+((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID")));
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "ST");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, getDoc_date());
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, getStore_code());
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			
			**/
			if(allow_decimals_yn.equals("Y")){
			callableStatement.setDouble(9, Double.parseDouble(setNumber(item_qty,no_of_decimals)));
			}else{
			callableStatement.setDouble(9, Double.parseDouble(setNumber(item_qty,0)));
			}
			/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications end
			**/

			/** before modication 
			callableStatement.setInt(9, Integer.parseInt(item_qty)));
			**/
			/*
				By Mahesh
			*/
				eST.Common.StUtilities bean = new eST.Common.StUtilities();
				bean.setLanguageId(getLanguageId());
				bean.setLoginById(getLoginById());//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",getStore_code());
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean.getBatches(hmParameters);
				
				ArrayList alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				HashMap hmExpRecord = new HashMap();
				for (int j=0;j<alBatchRecords.size() ;j++ ) {
					hmExpRecord		= (HashMap)alBatchRecords.get(j);
					sb_batch_data.append(hmExpRecord.get("TRADE_ID"));
					sb_batch_data.append(";");
					sb_batch_data.append(hmExpRecord.get("BATCH_ID"));
					sb_batch_data.append(";");
					sb_batch_data.append(hmExpRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					sb_batch_data.append(";");
					sb_batch_data.append(hmExpRecord.get("BIN_LOCATION_CODE"));
					sb_batch_data.append(";");
					if(allow_decimals_yn.equals("Y") ){
						sb_batch_data.append(setNumber((String)hmExpRecord.get("QTY"),no_of_decimals));
					}else{
						sb_batch_data.append(setNumber((String)hmExpRecord.get("QTY"),0));
					}
					sb_batch_data.append(";");
				}
			callableStatement.setString(10, sb_batch_data.toString());

			/*By Mahesh Ends*/
			//callableStatement.setString(10, ";");
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.FLOAT);
			callableStatement.registerOutParameter(16, Types.FLOAT);
			callableStatement.registerOutParameter(17, Types.FLOAT);
			callableStatement.registerOutParameter(18, Types.FLOAT);
			callableStatement.registerOutParameter(19, Types.FLOAT);
			callableStatement.registerOutParameter(20, Types.FLOAT);
			callableStatement.registerOutParameter(21, Types.FLOAT);
			callableStatement.registerOutParameter(22, Types.FLOAT);
			callableStatement.registerOutParameter(23, Types.FLOAT);
			callableStatement.registerOutParameter(24, Types.FLOAT);
			callableStatement.registerOutParameter(25, Types.FLOAT);
			callableStatement.registerOutParameter(26, Types.FLOAT);
			callableStatement.registerOutParameter(27, Types.FLOAT);
			callableStatement.registerOutParameter(28, Types.FLOAT);
			callableStatement.registerOutParameter(29, Types.VARCHAR);
			callableStatement.registerOutParameter(30, Types.FLOAT);
			callableStatement.registerOutParameter(31, Types.VARCHAR);
			callableStatement.registerOutParameter(32, Types.VARCHAR);
			callableStatement.registerOutParameter(33, Types.VARCHAR);
			callableStatement.registerOutParameter(34, Types.VARCHAR);
			callableStatement.registerOutParameter(35, Types.VARCHAR);
			callableStatement.registerOutParameter(36, Types.VARCHAR);
			callableStatement.registerOutParameter(37, Types.VARCHAR);
			callableStatement.registerOutParameter(38, Types.VARCHAR);
			callableStatement.setString(39, "");
			callableStatement.setString(40, "");
			callableStatement.setString(41, "N");
			callableStatement.setString(42, "");
			callableStatement.setString(43, "");
			callableStatement.setString(44, "");
			callableStatement.setString(45, "N"); //p_discharge_ind
			callableStatement.registerOutParameter(46, Types.VARCHAR); //p_drug_penalty_str Changes done for JD-CRF-0170
						

			callableStatement.execute();
			
			message.put("daytypecode" , checkForNull((String)callableStatement.getString(11)));
			message.put("daytypedesc" , checkForNull((String)callableStatement.getString(12)));
			message.put("timetypecode" , checkForNull((String)callableStatement.getString(13)));
			message.put("timetypedesc" , checkForNull((String)callableStatement.getString(14)));
			message.put("baseqty" , callableStatement.getFloat(15)+"");
			
			message.put("baserate" , callableStatement.getString(16)+"");
			message.put("addlfactor" ,callableStatement.getString(17)+"");
			message.put("basechargeamt" , callableStatement.getString(18)+"");
			message.put("grosschargeamt" , dfTest.format(Double.parseDouble(checkForNull(callableStatement.getString(19),"0")+"")));
			
			message.put("discountamt" , callableStatement.getString(20)+"");
			message.put("netchargeamt" , dfTest.format(Double.parseDouble(checkForNull(callableStatement.getString(21),"0")+"")));
			message.put("discountper" , callableStatement.getString(22)+"");
			message.put("patgrosschargeamt" , callableStatement.getString(23)+"");
			message.put("patdiscamt" , callableStatement.getString(24)+"");
			message.put("patnetamt" , callableStatement.getString(25)+"");
			message.put("custgrosschargeamt" , callableStatement.getString(26)+"");
			message.put("custdiscamt" , callableStatement.getString(27)+"");
			message.put("custnewamt" , callableStatement.getString(28)+"");
			
			message.put("insind" , checkForNull((String)callableStatement.getString(29)));
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
		}
		catch(Exception exception){
			
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		
		return message;
	}
	public String getStore_desc(String store_code) 
	{
		String store_desc="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
			store_desc=fetchRecord(getStRepositoryValue("SQL_ST_OPENING_STOCK_STORE"), arr_language).get("SHORT_DESC").toString() ;
	
			}
		catch(Exception exception )
		{
				exception.printStackTrace();
		}
		return store_desc;
    }

	public String getDoc_type_desc(String doc_type_code) 
	{
		String doc_type_desc = "";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(doc_type_code);
			arr_language.add(getLanguageId());
			doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return doc_type_desc;
    }

	public HashMap getROL(String item_code,String store_code){
		HashMap hmRecord = null;
		ArrayList arr = new ArrayList();
		arr.add(item_code);
		arr.add(store_code);
		try{
			hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_STOCK_TRANSFER_ROL"),arr);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}

	public int getEntityparam_EWDay(String ACC_ENTITY_ID) throws Exception{
		
		int IEWDays = 0;
		try {
				IEWDays = getEntityparam_EWDays(ACC_ENTITY_ID);
			
			}
            
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		
		return IEWDays;
	}
	public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1.0;
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		ArrayList alParameters = new ArrayList();
		try {
			
			
			alParameters.add(item_code);
			alParameters.add(store_code);

			 conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT St_Get_Uom_Conv_Fac_Sing_Str(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return conv_fac_temp;
	}
	/*public void kitTemplateValues(String kit_template_code,String store_code){
		count = 0;
		ArrayList alParams = new ArrayList();
		alParams.add(kit_template_code);
		alParams.add(store_code);
		alParams.add(kit_template_code);
		alParams.add(store_code);
		alParams.add(kit_template_code);
		alParams.add(getLanguageId());
		ArrayList result = new ArrayList();
		try{
			result = fetchRecords(getStRepositoryValue("SQL_ST_KIT_DTL_SELECT"),alParams);
		}catch(Exception e){
			e.printStackTrace();
		}
		kitDataList = result;
	}*/
		public String getSALItemClassBased(String trntype)
	{
		//String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				
				//records = fetchRecord(getStRepositoryValue("SQL_ST_GRN_ITEM_CLASS_BASED_YN"),chkdefaultParameters);
				records = fetchRecord("SELECT ITEM_CLASS_BASED_YN FROM ST_TRN_TYPE WHERE TRN_TYPE = ?",trntype);
				result=(String)records.get("ITEM_CLASS_BASED_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public String getPatientId(String patient_id) throws Exception {
        try{
            HashMap hashmap = fetchRecord(getStRepositoryValue("ST_SQL_DIR_SAL_PATIENT_SELECT"), patient_id);
            return (String)hashmap.get("PATIENT_ID");
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }
	public HashMap getSalesType(String store_code){
		HashMap hmRecord = null;
		
		try{
			hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT1"),store_code);
		}catch(Exception e){
		}
		
		return hmRecord;
	}
	
	// Start Added by Padmapriya 
	
	public HashMap getDfltSalesType(String store_code,String user_id){
		HashMap dflt_sal_type = null;
		ArrayList alParameters=new ArrayList();
		alParameters.add(store_code);
		alParameters.add(user_id);
		
		try{
			dflt_sal_type		=	fetchRecord("SELECT DFLT_SAL_TRN_TYPE FROM ST_USER_ACCESS_FOR_STORE WHERE STORE_CODE = ? and USER_ID = ?",alParameters);
		}catch(Exception e){
		}
		
		return dflt_sal_type;
	}
	
	// End by Padmapriya 
	
	public String CheckStoreSalesType(String store_code,String sal_trn_type) throws Exception {
		ArrayList alParameters=new ArrayList();
		alParameters.add(store_code);
		//alParameters.add(getLanguageId());
		HashMap result	  = new HashMap();
		String result_string="";
		try{
			//result = fetchRecord("SELECT OP_SALE_APPL_YN,REF_SALE_APPL_YN,IP_SALE_APPL_YN from ST_STORE WHERE STORE_CODE=? ",alParameters);
			result = fetchRecord(getStRepositoryValue("SQL_ST_SALES_TYPE_STORE_CMB"),alParameters);
		}catch(Exception e){
			
		}
		if(sal_trn_type.equals("I"))
		{
			result_string=(String)result.get("IP_SALE_APPL_YN");
			if(result_string.equals("Y"))
			{
				result_string="Y";
			}
			else
			{
				result_string="N";
			}
		}
		if(sal_trn_type.equals("O"))
		{
			result_string=(String)result.get("OP_SALE_APPL_YN");
			if(result_string.equals("Y"))
			{
				result_string="Y";
			}
			else
			{
				result_string="N";
			}
		}
		if((sal_trn_type.equals("R"))||(sal_trn_type.equals("R")))
		{
			result_string=(String)result.get("REF_SALE_APPL_YN");
			if(result_string.equals("Y"))
			{
				result_string="Y";
			}
			else
			{
				result_string="N";
			}
		}
		return result_string;
	}
	public HashMap getBillingDetail(String override_excl_incl_ind, String overriden_action_reason,String item_code,String item_qty,String bl_decimal){

		/*System.out.println("override_excl_incl_ind"+override_excl_incl_ind);
		System.out.println("overriden_action_reason"+overriden_action_reason);
		System.out.println("item_code"+item_code);
		System.out.println("item_qty"+item_qty);
		System.out.println("bl_decimal"+bl_decimal);*/
		HashMap hmBlDetail = new HashMap();
		String sal_trn_type = getSal_trn_type();
		String patient_id = getPatient_id();
		String encounter_id = getEncounter_id();
		String episode_id = "";
		String visit_id = "";
		String total_charge_amt ="";
		String patient_payable_amt = "";
		String patient_paid_amt = "";
		String approval_reqd_yn = "";
		String override_allowed_yn = "";
		String error_code ="";		 
		String sys_message_id ="";	
		String error_text = "";		
		Connection connection       = null ;
		CallableStatement cstmt = null ;
		//PreparedStatement pstmt = null;
		//ResultSet rsDecimalPlace= null;
		int decimal_place = Integer.parseInt(bl_decimal);
		String decimalFormatString = "#0";
		//order_Date = order_Date+":00";
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
			sal_trn_type = "R";
		}
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(item_code);



			//callin billing procedure
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(sal_trn_type.equals("O")||sal_trn_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
			cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
			//cstmt.setString( 1, login_facility_id);
			cstmt.setString(1, login_facility_id+"|"+((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID")));			
			cstmt.setString( 2, "ST");	//module id
			cstmt.setString( 3, "");	//
			cstmt.setString( 4, "");	//
			cstmt.setString( 5, sal_trn_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
			cstmt.setString( 6, patient_id); //patient_id
			cstmt.setString( 7, episode_id);  //episode_id
			cstmt.setString( 8, visit_id);  //p_visit_id  
			cstmt.setString( 9, null); //p_dummy1 - null
			cstmt.setString( 10, null); //p_dummy12 - null
			cstmt.setString( 11, "SAL"); //p_transaction_type
			cstmt.setString( 12, com.ehis.util.DateUtils.getCurrentDate("DMYHM","en")+":00"); //p_charge_date_time	--Service Data and time

			cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
			cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
			cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
			cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

			cstmt.setString( 17, item_code);  //p_item_code

			cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
			cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

			cstmt.setString( 20, "S");  //p_serv_panel_ind

			cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

			cstmt.setString( 22,item_qty );  //qty served
			cstmt.setString( 23, null);  //p_charge_amt  

			cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

			cstmt.setString( 25,null );  //p_store_code -- Store Code from where issued
			//cstmt.setString( 25,getStore_code() );  //p_store_code -- Store Code from where issued
			/*
				By Mahesh
			*/
				eST.Common.StUtilities bean = new eST.Common.StUtilities();
				bean.setLanguageId(getLanguageId());
				bean.setLoginById(getLoginById());//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",getStore_code());
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean.getBatches(hmParameters);
				StringBuffer sb_batch_data  = new StringBuffer();
				
				ArrayList alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				HashMap hmExpRecord = new HashMap();

				for (int j=0;j<alBatchRecords.size() ;j++ ) {
					hmExpRecord		= (HashMap)alBatchRecords.get(j);
					sb_batch_data.append(hmExpRecord.get("TRADE_ID"));
					sb_batch_data.append(";");
					sb_batch_data.append(hmExpRecord.get("BATCH_ID"));
					sb_batch_data.append(";");
					sb_batch_data.append(hmExpRecord.get("EXPIRY_DATE"));
					sb_batch_data.append(";");
					sb_batch_data.append(hmExpRecord.get("BIN_LOCATION_CODE"));
					sb_batch_data.append(";");
					if(allow_decimals_yn.equals("Y") ){
						sb_batch_data.append(setNumber((String)hmExpRecord.get("QTY"),no_of_decimals));
					}else{
						sb_batch_data.append(setNumber((String)hmExpRecord.get("QTY"),0));
					}
					sb_batch_data.append(";");
				}
			cstmt.setString(26, sb_batch_data.toString());

			/*By Mahesh Ends*/

			//cstmt.setString( 26, null);  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
			cstmt.setString( 27,null );  //p_oth_disc_perc if any other manual discount is given from transaction
			cstmt.setString( 28, null);  //p_source_doc_ref		null for Sale
			cstmt.setString( 29,null );  //p_source_doc_ref_line	null for Sale

			cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
			cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
			cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
			cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
			cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
			cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
			cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
			cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
			cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
			cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
			cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
			cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
			cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
			cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
			cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
			cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
			cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
			cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

			cstmt.setString( 48,null );  //p_dummy4 (IN OUT )
			cstmt.setString( 49, null);  //p_batch_prices  (IN OUT )
			
			cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
			cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
			cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
			cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

			cstmt.setString( 54,(checkForNull(override_excl_incl_ind)).equals("S")?"":checkForNull(override_excl_incl_ind) );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
			cstmt.setString( 55, checkForNull(overriden_action_reason));  //p_overridden_action_reason		 --- Pass null or any value entered 

			cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
			cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
			cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

			cstmt.execute() ;
			total_charge_amt		=cstmt.getString(36);
			patient_payable_amt		= cstmt.getString(40);
			patient_paid_amt		= cstmt.getString(47);
			if(checkForNull(override_excl_incl_ind).length()==0){
			override_excl_incl_ind	= cstmt.getString(51)==null?"":cstmt.getString(51);
			}
			approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
			override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 

			error_code		= checkForNull(cstmt.getString(56));
			sys_message_id	= checkForNull(cstmt.getString(57));
			error_text		= checkForNull(cstmt.getString(58));
			closeStatement( cstmt ) ;

			/*PE Mahesh 4/23/2010*/
			/*pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet( rsDecimalPlace ) ;*/
			/*PE*/
			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
			}
			if(patient_paid_amt!=null && !patient_paid_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_paid_amt = dfTest.format(Double.parseDouble(patient_paid_amt));
			}
		}
		catch(Exception e){
			error_text = "Error in Proc";
			System.out.println("Sales bean"+e);
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( cstmt ) ;
				//closeStatement( pstmt ) ;
				//closeResultSet( rsDecimalPlace ) ;
				closeConnection( connection );
			}catch(Exception es){
				System.out.println("Sales bean"+es);
			}
		}

		hmBlDetail.put("BL_TOTAL_CHARGE_AMT",total_charge_amt);
		hmBlDetail.put("BL_PATIENT_PAYABLE_AMT",patient_payable_amt);
		hmBlDetail.put("PATIENT_PAID_AMT",patient_paid_amt);
		hmBlDetail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",checkForNull(override_excl_incl_ind).equals("")?"E":override_excl_incl_ind);
		hmBlDetail.put("BL_APPROVAL_REQD_YN",checkForNull(approval_reqd_yn).equals("")?"N":approval_reqd_yn);
		//hmBlDetail.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn.equals("")?"N":override_allowed_yn);
		hmBlDetail.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
		hmBlDetail.put("BL_ERROR_CODE",error_code);
		hmBlDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
		hmBlDetail.put("BL_ERROR_TEXT",error_text);
		hmBlDetail.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);

		return hmBlDetail;
	}
	public HashMap getBillingDetail(String override_excl_incl_ind, String overriden_action_reason,String item_code,String item_qty,String bl_decimal,String sb_batch_data){
		HashMap hmBlDetail = new HashMap();
		String sal_trn_type = getSal_trn_type();
		String patient_id = getPatient_id();
		String encounter_id = getEncounter_id();
		String episode_id = "";
		String visit_id = "";
		String total_charge_amt ="";
		String patient_payable_amt = "";
		String patient_paid_amt = "";
		String approval_reqd_yn = "";
		String override_allowed_yn = "";
		String error_code ="";		 
		String sys_message_id ="";	
		String error_text = "";		
		Connection connection       = null ;
		CallableStatement cstmt = null ;
		//PreparedStatement pstmt = null;
		//ResultSet rsDecimalPlace= null;
		int decimal_place = Integer.parseInt(bl_decimal);
		String decimalFormatString = "#0";
		//order_Date = order_Date+":00";
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
			sal_trn_type = "R";
		}
		//int no_of_decimals=getNoOfDecimals(); commented for unused variables by Ganga Thursday, June 27, 2013
		//String allow_decimals_yn=getAllowDecimalsYN(item_code);commented for unused variables by Ganga Thursday, June 27, 2013



			//callin billing procedure
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(sal_trn_type.equals("O")||sal_trn_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
			cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
			//cstmt.setString( 1, login_facility_id);
			cstmt.setString(1, login_facility_id+"|"+((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", getStore_code())).get("FACILITY_ID")));			cstmt.setString( 2, "ST");	//module id
			cstmt.setString( 3, "");	//
			cstmt.setString( 4, "");	//
			cstmt.setString( 5, sal_trn_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
			cstmt.setString( 6, patient_id); //patient_id
			cstmt.setString( 7, episode_id);  //episode_id
			cstmt.setString( 8, visit_id);  //p_visit_id  
			cstmt.setString( 9, null); //p_dummy1 - null
			cstmt.setString( 10, null); //p_dummy12 - null
			cstmt.setString( 11, "SAL"); //p_transaction_type
			cstmt.setString( 12, com.ehis.util.DateUtils.getCurrentDate("DMYHM","en")+":00"); //p_charge_date_time	--Service Data and time

			cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
			cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
			cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
			cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

			cstmt.setString( 17, item_code);  //p_item_code

			cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
			cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

			cstmt.setString( 20, "S");  //p_serv_panel_ind

			cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

			cstmt.setString( 22,item_qty );  //qty served
			cstmt.setString( 23, null);  //p_charge_amt  

			cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

			cstmt.setString( 25,null );  //p_store_code -- Store Code from where issued
			//cstmt.setString( 25,getStore_code() );  //p_store_code -- Store Code from where issued

			cstmt.setString( 26, sb_batch_data);   
			//cstmt.setString( 26, null);  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
			cstmt.setString( 27,null );  //p_oth_disc_perc if any other manual discount is given from transaction
			cstmt.setString( 28, null);  //p_source_doc_ref		null for Sale
			cstmt.setString( 29,null );  //p_source_doc_ref_line	null for Sale

			cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
			cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
			cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
			cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
			cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
			cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
			cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
			cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
			cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
			cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
			cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
			cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
			cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
			cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
			cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
			cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
			cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
			cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

			cstmt.setString( 48,null );  //p_dummy4 (IN OUT )
			cstmt.setString( 49, null);  //p_batch_prices  (IN OUT )
			
			cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
			cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
			cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
			cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

			cstmt.setString( 54,(checkForNull(override_excl_incl_ind)).equals("S")?"":checkForNull(override_excl_incl_ind) );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
			cstmt.setString( 55, checkForNull(overriden_action_reason));  //p_overridden_action_reason		 --- Pass null or any value entered 

			cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
			cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
			cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

			cstmt.execute() ;
			total_charge_amt		=cstmt.getString(36);
			patient_payable_amt		= cstmt.getString(40);
			patient_paid_amt		= cstmt.getString(47);
			if(checkForNull(override_excl_incl_ind).length()==0){
			override_excl_incl_ind	= cstmt.getString(51)==null?"":cstmt.getString(51);
			}
			approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
			override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 

			error_code		= checkForNull(cstmt.getString(56));
			sys_message_id	= checkForNull(cstmt.getString(57));
			error_text		= checkForNull(cstmt.getString(58));
			closeStatement( cstmt ) ;

			/*PE Mahesh 4/23/2010*/
			/*pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet( rsDecimalPlace ) ;*/
			/*PE*/
			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
			}
			if(patient_paid_amt!=null && !patient_paid_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_paid_amt = dfTest.format(Double.parseDouble(patient_paid_amt));
			}
		}
		catch(Exception e){
			error_text = "Error in Proc";
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( cstmt ) ;
				//closeStatement( pstmt ) ;
				//closeResultSet( rsDecimalPlace ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

		hmBlDetail.put("BL_TOTAL_CHARGE_AMT",total_charge_amt);
		hmBlDetail.put("BL_PATIENT_PAYABLE_AMT",patient_payable_amt);
		hmBlDetail.put("PATIENT_PAID_AMT",patient_paid_amt);
		hmBlDetail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",override_excl_incl_ind.equals("")?"E":override_excl_incl_ind);
		hmBlDetail.put("BL_APPROVAL_REQD_YN",approval_reqd_yn.equals("")?"N":approval_reqd_yn);
		//hmBlDetail.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn.equals("")?"N":override_allowed_yn);
		hmBlDetail.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
		hmBlDetail.put("BL_ERROR_CODE",error_code);
		hmBlDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
		hmBlDetail.put("BL_ERROR_TEXT",error_text);
		hmBlDetail.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
		return hmBlDetail;
	}
	
	public HashMap callBillingCashCounterProcedure(String sal_trn_type){
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap(); 		
		if(sal_trn_type !=null && sal_trn_type.equals("X")){
			sal_trn_type = "R";
		}

		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?) }");
			callableStatement.setString(1, getLoginFacilityId());
			callableStatement.setString(2, sal_trn_type);
			callableStatement.setString(3, getLoginById());
			callableStatement.setString(4, getLoginAtWsNo());
			callableStatement.registerOutParameter(5, Types.VARCHAR);
			callableStatement.registerOutParameter(6, Types.VARCHAR);
			callableStatement.registerOutParameter(7, Types.VARCHAR);
			callableStatement.execute();
			message.put("CASH_COUNTER_CODE" , checkForNull((String)callableStatement.getString(5)));
			message.put("CASHIER_SHIFT" , checkForNull((String)callableStatement.getString(6)));
			message.put("SYS_MESSAGE_ID" , checkForNull((String)callableStatement.getString(7)));			
		}
		catch(Exception exception){
			exception.printStackTrace();
			
		}
		finally{
			try{
				closeStatement(callableStatement);
				closeConnection(connection);
			}catch(Exception e){
			}
		}
		return message;
	}
public HashMap modifiedTableData(HashMap hmTableData,String trn_type){
		String item_class_code = "";
		int records_per_trn = getRecordsPerTrn(trn_type);
		ArrayList<Integer> alCount =  new ArrayList<Integer>();
		HashMap<String,String> hmTempData = new HashMap<String,String>();
		HashMap<String,String> hmTempExpData = new HashMap<String,String>();
		ArrayList<HashMap> alNewTempDtlData = new ArrayList<HashMap>();
		ArrayList<HashMap> alNewTempDtlExpData = new ArrayList<HashMap>();
		ArrayList<String> alItemClassData = new ArrayList<String>();
		ArrayList<String> alNewItemClassData = new ArrayList<String>();
		ArrayList<HashMap> alItemDtlData = (ArrayList<HashMap>)hmTableData.get("DTL_DATA");
		ArrayList<HashMap> alItemDtlExpData = (ArrayList<HashMap>)hmTableData.get("DTL_EXP_DATA");
		//ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		//HashMap<String,String> hmItemHdrData = (HashMap<String,String>)hmTableData.get("HDR_DATA");
		for(int i=0;i<alItemDtlData.size();i++){
			hmTempData = (HashMap<String,String>)alItemDtlData.get(i);
			try{
				item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
				if(!alItemClassData.contains(item_class_code)){
					alItemClassData.add(item_class_code);
				}
				//alItemClassData.add((String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(4)).get("ITEM_CLASS_CODE"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Collections.sort(alItemClassData);
		for(int i=0;i<alItemClassData.size();i++){
			alNewItemClassData.add(alItemClassData.get(i));
		}
		item_class_code = "";
		for(int i=0;i<alItemClassData.size();i++){
			int k = 0;
			//int count = 0;
			for(int j=0;j<alItemDtlData.size();j++){
				hmTempData = new HashMap<String,String>();
				hmTempData = alItemDtlData.get(j);
				//hmTempExpData = (HashMap<String,String>)alItemDtlExpData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
						//++count;
						if(k>=records_per_trn){
							alCount.add(k);
							k = 0;
							alNewItemClassData.add(item_class_code);
						}
						hmTempData.put("doc_srl_no",""+ (++k));
						alNewTempDtlData.add(alItemDtlData.get(j));
						for(int m=0;m<alItemDtlExpData.size();m++){
							hmTempExpData = new HashMap<String,String>();
							hmTempExpData = alItemDtlExpData.get(m);
							if((hmTempExpData.get("ITEM_CODE")).equals(hmTempData.get("item_code"))){
								hmTempExpData.put("doc_srl_no",""+k);
								alNewTempDtlExpData.add(alItemDtlExpData.get(m));
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			alCount.add(k);
		}
		Collections.sort(alNewItemClassData);
		/*for(int i=0;i<alNewItemClassData.size();i++){
			ArrayList<String> alTemp = new ArrayList<String>();
			for(int j=0;j<alItemHdrData.size();j++){
				alTemp.add(alItemHdrData.get(j));
			}
			alTemp.set(5,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}*/
		//hmTableData.put("InsertDTLData",alNewTempDtlData);
		//hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("DTL_DATA",alNewTempDtlData);
		hmTableData.put("DTL_EXP_DATA",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
	
		return hmTableData;
	}
	public String getBlDecimal() throws Exception {
        try{
            HashMap hashmap = fetchRecord("SELECT BLCORE.GET_DECIMAL_PLACE(?) DECIMAL_PLACE FROM DUAL", patient_id);
            return (String)hashmap.get("DECIMAL_PLACE");
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }

		public String getNursingUnitCodeList() {
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		return getListValues("SELECT nursing_unit_code,  short_desc FROM ip_nursing_unit_lang_vw a ,st_sal_hdr hdr  WHERE  a.facility_id = ?    AND language_id = ?  AND nursing_unit_code =HDR.LOCN_CODE  and HDR.FINALIZED_YN='N'  UNION SELECT clinic_code ,short_desc FROM op_clinic_lang_vw a,st_sal_hdr hdr WHERE a.facility_id = ? AND language_id =? AND clinic_code =HDR.LOCN_CODE and HDR.FINALIZED_YN='N' order by short_desc ",arr_language,"");
	}

		public String getNursingUnitCodeListNew(String fromdate,String todate) {
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(fromdate);
		arr_language.add(todate);
		arr_language.add(getLoginFacilityId());
		arr_language.add(fromdate);
		arr_language.add(todate);
		return getListValues("select clinic_code , short_desc from op_clinic a where facility_id = ? and exists (select 'Y' from st_sal_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.clinic_code AND finalized_yn = 'N')   union select nursing_unit_code , short_desc  from ip_nursing_unit a where facility_id = ? and exists (select 'Y' from st_sal_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.nursing_unit_code AND finalized_yn = 'N') order by 2 ",arr_language,"");
	}
		
		public ArrayList getNursingUnitCodeListNewArr(String fromdate,String todate) throws Exception {
		String [] stParameters	=	{getLoginFacilityId(),fromdate,todate,getLoginFacilityId(),fromdate,todate};
		return fetchRecords("select clinic_code , short_desc from op_clinic a where facility_id = ? and exists (select 'Y' from st_sal_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.clinic_code AND finalized_yn = 'N')   union select nursing_unit_code , short_desc  from ip_nursing_unit a where facility_id = ? and exists (select 'Y' from st_sal_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.nursing_unit_code AND finalized_yn = 'N') order by 2 ",stParameters);
		}

	public String getAvailableQty(String item_code,String store_code) throws Exception {
		String[] param = new String[7];
		param[0] = item_code;
		param[1] = store_code;
		param[2] = "0";
		param[3] = "N";
		param[4] = "";
		param[5] = "";
		param[6] = "";
		java.util.HashMap stockValues = getStockAvailabilityStatus(param);
		return (String) stockValues.get("available_stock");
	}
	
	//Added by suresh.r 07-11-2013 against JD-CRF-156  beg
	public String getUserAccCurrEncntrFinDdtlYN(String store_code,String userID) {
		HashMap hashmap=null;
		String disp_curr_encntr_fin_dtl_yn="";
        try{
        	String stParameters[]={store_code, userID};
        	 hashmap= fetchRecord(getStRepositoryValue("SQL_ST_DISP_CURR_ENCNTR_FIN_DTL_YN"), stParameters);
        	 disp_curr_encntr_fin_dtl_yn=checkForNull((String)hashmap.get("DISP_CURR_ENCNTR_FIN_DTL_YN"),"N");
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return disp_curr_encntr_fin_dtl_yn;
    }
	
	public boolean getPolicyExp(String stParameters[]) throws Exception {
        	String facility_id="",encounter_id="",patient_class="",patient_id="";
        	CallableStatement callableStatement = null;
        	Connection connection = null;
        	try{
        		facility_id=stParameters[0];
            	encounter_id=stParameters[1];
            	patient_class=stParameters[2];
            	patient_id=stParameters[3];
    			connection = getConnection();
    			callableStatement	= connection.prepareCall("{ call or_bl_patient_check (?,?,?,?,?,?) }");
    			callableStatement.setString(1, facility_id);
    			callableStatement.setString(2, encounter_id);
    			callableStatement.setString(3, patient_class);
    			callableStatement.registerOutParameter(4, Types.VARCHAR);
    			callableStatement.registerOutParameter(5, Types.VARCHAR);
    			callableStatement.setString(6, patient_id);
    			callableStatement.execute();
    			if(!checkForNull(callableStatement.getString(4)).equals("")){
	    			return false;
    			}
    		}
    		catch(Exception exception){
    			exception.printStackTrace();
    		}
    		finally{
    			try{
    				closeStatement(callableStatement);
    				closeConnection(connection);
    			}catch(Exception e){
    			}
    		}
        	return true;
    }
	//Added by suresh.r 07-11-2013 against JD-CRF-156 end
	//Added by suresh.r #Inc no:45645(JD-CRF-156) on 16-12-2013 beg
	public HashMap getEpisodeVisitID(String encounter_id,String patient_id) {
		HashMap hashmap=null;
	    try{
	    	String stParameters[]={patient_id,encounter_id};
	    	 hashmap= fetchRecord(getStRepositoryValue("SQL_ST_SELECT_EPISODE_VISITID"), stParameters);
	    	 hashmap.put("EPISODE_ID",checkForNull((String)hashmap.get("EPISODE_ID")));
	    	 hashmap.put("OP_EPISODE_VISIT_NUM",checkForNull((String)hashmap.get("OP_EPISODE_VISIT_NUM")));
	    }
	    catch(Exception exception){
	        exception.printStackTrace();
	    }
	    return hashmap;
	}
	//Added by suresh.r #Inc no:45645(JD-CRF-156) on 16-12-2013 end
	
	/*GHL-CRF-0419.2 STARTS*/
	public String restrictChecked() throws Exception{
		
		String checked="N";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try
		{
			con=getConnection();
			stmt=con.prepareStatement("SELECT ORD_REST_OPEN_AE_OP_ENC_YN FROM OR_PARAM");
			rs=stmt.executeQuery();
		
			if(rs!=null && rs.next())
			{
				checked=rs.getString("ORD_REST_OPEN_AE_OP_ENC_YN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeResultSet(rs);  // Common-ICN-0091
			closeStatement(stmt);
			closeConnection(con);
		}
		return checked;
	}
	/*GHL-CRF-0419.2 ENDS*/
	//GHL-SCF-1587 
public ArrayList getBarCodeDetailArrayList1(String bar_code , String store_code) throws Exception{ 

 		ArrayList barcodeDetail = new ArrayList(); 
 		ArrayList arrMatGrpList = new ArrayList();
 		HashMap alTemp	=	new HashMap();
 		 String itemCode	=	"";  
 		 String materialGrpCode = ""; 
 		HashMap records			  = new HashMap();
// 		HashMap records1		  = new HashMap();  // Common-ICN-0091
		
		try {
//			System.out.println("SalesBean bar_code==>"+bar_code);
//			System.out.println("SalesBean store_code==>"+store_code); 
//			String stParameter[] = { bar_code, store_code };   // Common-ICN-0091
			barcodeDetail =getBarCodeBatchDetails(bar_code,store_code);   	
			if(barcodeDetail.size()>0){
				alTemp = (HashMap)barcodeDetail.get(0);
				itemCode = (String)alTemp.get("ITEM_CODE");  
				//String stParameter1[] = { itemCode }; 
			//	materialGrpCode = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_SELECT_FOR_BAR_CODE"),stParameter1);
				records = getMatGrpCode (itemCode);    
				materialGrpCode=(String)records.get("MATERIAL_GROUP_CODE"); 
				if(materialGrpCode!=null && !materialGrpCode.equals("")){
//					String stParameter1[] = { itemCode, materialGrpCode,getLoginById() };    // Common-ICN-0091
					arrMatGrpList = getBatchForMatGrpAccess(itemCode,materialGrpCode,getLoginById());   				
					if(arrMatGrpList==null || arrMatGrpList.size()==0){
						barcodeDetail = new ArrayList();   
					}
					
				}
			}  
			
     
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	return barcodeDetail ;   
}

public ArrayList getBarCodeBatchDetails(String bar_code , String store_code) throws Exception{ 
		ArrayList barcodeDetail = new ArrayList(); 
		HashMap hmRecord					=	new HashMap();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		String sql = "";
		sql   = "SELECT BARCODE_ID,ITEM_CODE,STORE_CODE,BATCH_ID,BIN_LOCATION_CODE, to_char(EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy') EXPIRY_DATE,TRADE_ID,NVL(QTY_ON_HAND,0) QTY_ON_HAND,NVL(COMMITTED_QTY,0) COMMITTED_QTY,NVL(QTY_ON_HAND,0)-NVL(COMMITTED_QTY,0)AVAIL_QTY,SUSPENDED_YN FROM ST_ITEM_BATCH WHERE BARCODE_ID = ?  AND STORE_CODE = ? ";
	
	
	try {
		conn = getConnection();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, bar_code);
		pstm.setString(2, store_code);
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
			hmRecord.put("BARCODE_ID",resultSet.getString("BARCODE_ID")==null?"":resultSet.getString("BARCODE_ID"));
			hmRecord.put("ITEM_CODE", resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE")); 
			hmRecord.put("STORE_CODE", resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE")); 
			hmRecord.put("BATCH_ID", resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID")); 
			hmRecord.put("BIN_LOCATION_CODE", resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE")); 
			hmRecord.put("EXPIRY_DATE", resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE")); 
			hmRecord.put("TRADE_ID", resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID")); 
			hmRecord.put("QTY_ON_HAND", resultSet.getString("QTY_ON_HAND")==null?"":resultSet.getString("QTY_ON_HAND")); 
			hmRecord.put("COMMITTED_QTY", resultSet.getString("COMMITTED_QTY")==null?"":resultSet.getString("COMMITTED_QTY")); 
			hmRecord.put("AVAIL_QTY", resultSet.getString("AVAIL_QTY")==null?"":resultSet.getString("AVAIL_QTY")); 
			hmRecord.put("SUSPENDED_YN", resultSet.getString("SUSPENDED_YN")==null?"":resultSet.getString("SUSPENDED_YN")); 
			barcodeDetail.add(hmRecord);  
		}
 
    } catch (Exception e) {
        e.printStackTrace();
    } 
	finally { //Common-ICN-0091
		closeResultSet(resultSet);
		closeStatement(pstm);
		closeConnection(conn);
	}
	
return barcodeDetail ;   
}

public ArrayList getBatchForMatGrpAccess(String itemCode , String materialGrpCode, String loginId) throws Exception{ 
		String matGrpCode = ""; 
		ArrayList arrMatGrpList = new ArrayList(); 
//		HashMap hmRecord					=	new HashMap();   // Common-ICN-0091
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		String sql = "";
		sql   = "SELECT material_group_code  FROM mm_item WHERE item_code = ? AND material_group_code IN (SELECT material_group_code  FROM MM_USER_MATERIAL_GROUP    WHERE material_group_code = ? and user_id= ? AND EFF_STATUS ='E') ";
		
	try {
		conn = getConnection();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, itemCode);
		pstm.setString(2, materialGrpCode);
		pstm.setString(3, loginId);
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
			matGrpCode = resultSet.getString("material_group_code")==null?"":resultSet.getString("material_group_code");   
			arrMatGrpList.add(matGrpCode); 
		}
 
    } catch (Exception e) {
        e.printStackTrace();
    } 
	finally{ //Common-ICN-0091
		closeResultSet(resultSet);
		closeStatement(pstm);
		closeConnection(conn);
	}
return arrMatGrpList ;   
}

public HashMap getMatGrpCode(String itemCode) throws Exception{ 
//		String matGrpCode = "";   // Common-ICN-0091
//		ArrayList arrMatCodeList = new ArrayList();   // Common-ICN-0091
		HashMap hmRecord					=	new HashMap();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		String sql = "";
		sql   = "SELECT MATERIAL_GROUP_CODE  FROM mm_item WHERE item_code = ? ";
		
	try {
		conn = getConnection();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, itemCode);
		resultSet = pstm.executeQuery(); 
		if(resultSet!=null && resultSet.next()){
			hmRecord.put("MATERIAL_GROUP_CODE",resultSet.getString("MATERIAL_GROUP_CODE")==null?"":resultSet.getString("MATERIAL_GROUP_CODE")); 
			
		//	System.out.println("hmRecord: "+hmRecord);  
		}
 
    } catch (Exception e) {
        e.printStackTrace();
    } 
	finally{  // Common-ICN-0091
			closeResultSet(resultSet);
			closeStatement(pstm);
			closeConnection(conn);
     }
	
return hmRecord ;    
}//GHL-SCF-1587 END

} 
