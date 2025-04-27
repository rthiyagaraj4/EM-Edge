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

23/07/2019             IN070966                 Haribabu                                                        GHL-SCF-1443 
--------------------------------------------------------------------------------------------------------------------------------------------
 */
package eST;

//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import eCommon.Common.CommonAdapter;
//import eCommon.Common.CommonEJBSessionInterface;
//import javax.ejb.EJBObject;

import eST.Sales.*;
import eST.Common.StHeaderBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.Connection;
//import java.sql.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.* ;
import javax.servlet.http.*;
import webbeans.eCommon.*;



public class StockItemConsumptionBean extends StHeaderBean implements Serializable{

	private String patient_id;
	private String sal_trn_type;
	private String encounter_id;
	private String patient_name;
	private String authorized_by_id;
	private String finalized_yn;  
	private String records_to_delete;
	private String remarks;

	
//	private String trn_type;
	private ArrayList PDocNo=new ArrayList();
//	private String doc_no="";
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	public String reportserver = "";
	public String report_connect_string = "";
	public HashMap dtlRemarks =new HashMap();//Added for TH-KW-CRF-0043
	private Hashtable tempHash =new Hashtable();//Added for TH-KW-CRF-0043
	private String new_con_screen_yn ="N";//Added for TH-KW-CRF-0043
	//public String language_id = "";

//    private String PgetTrnType = "";
// 	private String stReportid = null;

//    javax.servlet.http.HttpSession session ;
	

//	private HashMap		hmExpRecords=new HashMap();
//	private ArrayList	alDtlRecords=new ArrayList();
	private HashMap		hmExpRecords ;
	private ArrayList	alDtlRecords ;
	private double doc_srl_no	=	0;
	public static int count = 0;
	private String kit_tmpl_code; //31/07/12
	//private ArrayList	kitDataList =new ArrayList();

/*	private javax.servlet.http.HttpServletRequest request;
//	private javax.servlet.http.HttpServletResponse response;

	
    public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response;
	}
	public int getCount(){
		return count++;
	}*/

	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
/*	public ArrayList getKitDtlData(){
		return kitDataList;
	}
	
	public void setLanguageId(String language_id) {
		 this.language_id= language_id;
 	}

	public String  getLanguageId( ) {
		 return language_id;
	}*/
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}
	public void setTempHash(Hashtable expHash){
		 this.tempHash = expHash;
	}
    public Hashtable getTempHash(){
		return tempHash;
	}
	public void setdtlRemarks(String item_code,String dtlRemarks){
		this.dtlRemarks.put(item_code,dtlRemarks);
	}
	public HashMap getDtlRemarks(){
		return dtlRemarks;
	}


	public void initialize(){
		super.initialize();
		// added on 22/12
		hmExpRecords=new HashMap();
		alDtlRecords=new ArrayList();
		doc_srl_no	=	0;
		patient_id="";  
		sal_trn_type="";
		encounter_id="";
		patient_name="";
		authorized_by_id=""; 
		finalized_yn="";     
		remarks="";
		records_to_delete="";

		// ended...
	}


	public void  clear(){
		super.clear();
		//hmExpRecords=new HashMap();  
		//alDtlRecords=new ArrayList();
		hmExpRecords=null;  
		alDtlRecords=null;
		doc_srl_no	=	0;
		patient_id=null;  
		sal_trn_type=null;
		encounter_id=null;
		patient_name=null;
		authorized_by_id=null; 
		finalized_yn=null;     
		remarks="";
		records_to_delete=null;
		tempHash =new Hashtable();//Added for TH-KW-CRF-0043
		new_con_screen_yn ="";//Added for TH-KW-CRF-0043
	}

	
	public void setSession(javax.servlet.http.HttpSession session ) {
         //this.session = session ;
	}


	public void setRemarks(String remarks) {
		 this.remarks= checkForNull(remarks);  
	}

	public String getRemarks( ) {
		 return this.remarks;
	}

	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public ArrayList getPrintDocNo(){
		return PDocNo;
	}


	public void setAuthorized_by_id(String authorized_by_id) {
		 this.authorized_by_id= authorized_by_id;
	}

	public String getAuthorized_by_id( ) {
		 return authorized_by_id;
	}

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
//		 this.sal_trn_type = checkForNull(sal_trn_type);
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

	public void setPatient_name(String patient_name) {
		 this.patient_name = patient_name;
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public double getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	public double getDoc_srl_no(){
		return doc_srl_no;
	}

	public void setDoc_srl_no(String doc_srl_no){
		this.doc_srl_no=Double.parseDouble(doc_srl_no);
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
				}

for(int i=0;i<alExpRecords.size();)
		{
			if(  ((String)((HashMap)alExpRecords.get(i)).get("QTY")).equals("")   )
			 {
				HashMap hmAldtlData = (HashMap)alDtlRecords.get(index);
				int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));
				--batch_records;    //added by Rabbani, inc no: 26400 on 27/07/11
				hmAldtlData.put("batch_records",""+batch_records);
				alDtlRecords.set(index,hmAldtlData);
				alExpRecords.remove(i);
				}
			else i++;
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


	
	public void setAll(Hashtable hashtable) {
		patient_id	=(String)hashtable.get("patient_id");  
		sal_trn_type=(String)hashtable.get("sal_trn_type");  
		
		//Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 24-MAY-2013
		String hdr_remarks = "";
		String remars_desc = "";
		String new_con_screen_yn ="";//added for th-kw-crf-0043
		hdr_remarks        = checkForNull((String)hashtable.get("hdr_remarks_code"));
		 remars_desc       = checkForNull((String)hashtable.get("remarks"));
		 if(!hdr_remarks.equals("") && !remars_desc.equals("")){
		    setRemarks(hdr_remarks); 
		   }else{
		    //setRemarks(checkForNull((String)hashtable.get("remarks")));  
		     setRemarks(remars_desc);  
		   }
		setEncounter_id((String)hashtable.get("encounter_id"));  
		patient_name=(String)hashtable.get("patient_name");  
		authorized_by_id =(String)hashtable.get("authorized_by_id");  
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		new_con_screen_yn =(String)hashtable.get("new_con_screen_yn")==null?"":(String)hashtable.get("new_con_screen_yn");
		System.err.println("new_con_screen_yn@@==="+new_con_screen_yn);
		if(new_con_screen_yn.equals("") || new_con_screen_yn.equals("N"))
		  records_to_delete=(String)hashtable.get("records_to_delete");  
		
    }

	public ArrayList getEncounterArrayList(String patient_id,String sal_trn_type,String new_con_screen_yn) throws Exception{ //new_con_screen_yn Added for TH-KW-CRF-0042

		String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type};
		//return fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_2"),stParameters);	

		ArrayList list = new ArrayList();
		try{
		//list = fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_2"),stParameters);	
		if(new_con_screen_yn.equals("N")){
		list = fetchRecords("SELECT	 ENCOUNTER_ID ITISTOPOPULATELISTBOX , ENCOUNTER_ID, TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI')DT_TIME,   RPAD(CLINIC_NAME,15,' ')  CLINIC_NAME ,RPAD(PRACTITIONER_NAME,30,' ') PRACTITIONER_NAME  FROM PR_ENCOUNTER_VW	WHERE FACILITY_ID = ?	AND	PATIENT_ID = upper(?) AND ( VISIT_STATUS != '99' OR ADT_STATUS != '09' ) AND PATIENT_CLASS = DECODE(?,'I','IP','O','OP') ORDER BY ENCOUNTER_ID DESC",stParameters);	
		}else{
		    String Parameters[]={getLoginFacilityId(),patient_id,getLoginFacilityId(),getLoginFacilityId()};
		  	
		    return	fetchRecords("SELECT encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter a WHERE facility_id=? AND patient_id= upper(?)  AND (( a.patient_class = 'OP' and a.visit_status in ('02','03','04','05','06')) Or ( a.patient_class = 'EM' and a.visit_status < '07') OR (( a.patient_class in ('IP','DC') and a.ADT_STATUS  < '08')))  and 'Y' = OR_GET_ACCESS_RULE(?,a.encounter_id,'PH',a.patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'), to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI'), (SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=? and ENCOUNTER_ID=a.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1) ) order by VISIT_ADM_DATE_TIME desc",Parameters);
		}
		}catch(Exception e){
			list = new ArrayList();
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList getEncounter_id_List(){
				
		ArrayList parameters = new ArrayList();
		parameters.add(getLoginFacilityId());
		parameters.add(getPatient_id());

		ArrayList list = new ArrayList();
		try{
		list = fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_2"),parameters);
		}catch(Exception e){
			list = new ArrayList();
			e.printStackTrace();
		}
		return list;
	}
	
	//31/07/12
	public void setKit_code(String kitcode) {
		this.kit_tmpl_code = kitcode; 
	}
	public String getKit_code() {
		return this.kit_tmpl_code;
	}
	

	
	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean
		not required to process exp records..*/
 		return getMessageHashMap(true);	
	}

	public String getSal_trn_type_List() {
        return getStaticListOptionTag("C,Consumption;I,InPatient;O,OutPatient;R,Referral;", getSal_trn_type());
    }
	
	public void loadData() throws Exception{
		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());


		
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_SAL_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		doc_srl_no		=	Double.parseDouble((String)hmRecord.get("MAX_DOC_SRL_NO"));
		
		
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_SAL_HDR_SELECT_SINGLE"), alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setStore_code((String)hmRecord.get ("STORE_CODE"));  
		setPatient_id((String)hmRecord.get ("PATIENT_ID"));  
		setSal_trn_type((String)hmRecord.get("SAL_TRN_TYPE"));
		setEncounter_id((String)hmRecord.get("ENCOUNTER_ID"));
		setPatient_name((String)hmRecord.get("PATIENT_NAME"));
		setItem_class_code(checkForNull((String)hmRecord.get("ITEM_CLASS_CODE")));
		

		alParameters.add(getStore_code());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_DTL_SELECT_MULTIPLE"), alParameters);
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("ITEM_SAL_VALUE"));
			hmTemp.put("item_unit_cost",hmRecord.get("UNIT_COST"));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("stock_available",hmRecord.get("STOCK_AVAILABLE"));
			hmTemp.put("stock_item_yn",hmRecord.get("STOCK_ITEM_YN"));
			hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			alDtlRecords.add(hmTemp);
		}
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		//alParameters.add(getStore_code());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			alParameters.set(6,(String)hmRecord.get("doc_srl_no"));
			alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_DTL_EXP_SELECT_MULTIPLE"), alParameters);
			hmExpRecords.put(""+i,alRecords);
		}


	}

	public HashMap insert(){

	   //System.out.println("StockItemConsumptionBean.java,422");
// 		HashMap hmResult=new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
//		ArrayList alCommonData	=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		ArrayList allanguageData	=	new ArrayList();
		String temp_store_code = "";//Added for IN070966
		HashMap dtl_remarks    =new HashMap();//added for-th-kw-crf-0043
		 dtl_remarks  =getDtlRemarks();
		 String dtlremarks ="";


		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

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
		alHdrData.add(checkForNull(getRemarks()));
		
		alHdrData.add(getItem_class_code());
		alHdrData.add("N"); // Billable
		alHdrData.add("N"); // Discharge
		alHdrData.add("");//token_series_code
		alHdrData.add("");//token_serial_no
		alHdrData.add("");//patient_name
		alHdrData.add("ST");//Module Id
		alHdrData.add("");//Ref No
		alHdrData.add("");//getSales_priority_type
		alHdrData.add("");//NU Clinic Code
		alHdrData.add("");//Patient_age
		alHdrData.add("");//Patient_sex
		alHdrData.add("");//Patient_DOB
   
		allanguageData.add(getLanguageId());

		try {
//alDtlRecords
			
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			System.err.println("getRecords_to_delete() at insert@@=="+getRecords_to_delete());
		//Added for GHL-CRF-0413 starts
			boolean site = false;
			Connection con			= null;  
	        try{
	        	con				= getConnection();		
	        	site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");	
			}
	        catch(Exception ex){
	            ex.printStackTrace();
	        } 
	        finally{
				if(con != null)
					ConnectionManager.returnConnection(con);
			}
			if(site){
				ArrayList alDtl  = getDtlRecordsforBarCode();
				System.err.println("alDtl @@bean===="+alDtl);
				for (int i=0;i<alDtl.size();i++) {
									String nextToken = stRecordsToDelete.nextToken();
									System.err.println("nextToken==="+nextToken);
									HashMap hmDtlRecord	=	(HashMap) alDtl.get(i);
									if(nextToken.equals("Y")) {
										if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
											hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
										}
										else{
											continue;
										}
									}
									else{
										ArrayList sourceArrayList	=	getExpRecordsforBarCode(i);
										System.err.println("sourceArrayList @@bean===="+sourceArrayList);
										if (sourceArrayList!=null) 
											for (int j=0;j<sourceArrayList.size(); j++ ) {
												HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
												//Added for IN070966 start
												if(j==0){
													temp_store_code = (String)hmExpRecord.get("STORE_CODE");
												}
												//Added for IN070966 end
												hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
												alExpData.add(hmExpRecord);
											}
									}
									double mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
									hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
									if(new_con_screen_yn.equals("Y") && dtl_remarks.containsKey((String)hmDtlRecord.get("item_code"))){//Adding start for TH-KW-CRF-0043
									   
									   dtlremarks = (String)dtl_remarks.get((String)hmDtlRecord.get("item_code"));
									   hmDtlRecord.put("remarks",dtlremarks);
									  
								  }//Adding end for TH-KW-CRF-0043
									alDtlData.add(hmDtlRecord);
								}
			}
			else{//Added for GHL-CRF-0413 ends
			for (int i=0;i<alDtlRecords.size();i++) {
//				if (stRecordsToDelete.hasMoreTokens()) {
				String nextToken = stRecordsToDelete.nextToken();
				HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							//Added for IN070966 start
							if(j==0){
								temp_store_code = (String)hmExpRecord.get("STORE_CODE");
							}
							//Added for IN070966 end
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							alExpData.add(hmExpRecord);
						}
				}
				/**
				* @Name - Suri
				* @Date - 19/01/2010
				* @Inc# - IN015496
				* @Desc - Code added to accept decimal values dynamically.
				* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			   */

				double mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
				alDtlData.add(hmDtlRecord);
				}
			}
			//Added for IN070966 start
			if(!getStore_code().equals(temp_store_code))
				alHdrData.set(5, temp_store_code);
			//Added for IN070966 end
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
       // System.out.println("StockItemConsumptionBean.java,523");
		return salesMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap delete(){
// 		HashMap hmResult		=	new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());

		hmTableData.put("properties",	getProperties());
		hmTableData.put("DATA",			alHdrData);
		hmTableData.put("COMMON_DATA",	hmCommonData);

		return salesMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}

	public HashMap modify(){
// 		HashMap hmResult=new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		String temp_store_code = "";//Added for IN070966

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

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
		alHdrData.add(checkForNull(getRemarks()));
		alHdrData.add(getItem_class_code());
		alHdrData.add(getLoginAtWsNo());
		alHdrData.add(getLoginFacilityId());
		alHdrData.add("");//token_series_code
		alHdrData.add("");//token_serial_no
        alHdrData.add("ST");//Module Id
		try {
//alDtlRecords
			
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			for (int i=0;i<alDtlRecords.size();i++) {
//				if (stRecordsToDelete.hasMoreTokens()) {
				String nextToken = stRecordsToDelete.nextToken();
				HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					for (int j=0;j<sourceArrayList.size(); j++ ) {
						HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						//Added for IN070966 start
						if(j==0){
							temp_store_code = (String)hmExpRecord.get("STORE_CODE");
						}
						//Added for IN070966 end
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						alExpData.add(hmExpRecord);
					}
				}
				alDtlData.add(hmDtlRecord);
			}
			//Added for IN070966 start
			if(!getStore_code().equals(temp_store_code))
				alHdrData.set(5, temp_store_code);
			//Added for IN070966 end
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	hmCommonData);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return salesMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap salesMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		//System.out.println("StockItemConsumptionBean.java,627");
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

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_SALES") ,SalesHome.class,getLocalEJB());
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

					//System.out.println("StockItemConsumptionBean.java,690");
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					//Result = salesRemote.insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					//System.out.println("StockItemConsumptionBean.java,696");	
				hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = salesRemote.modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					//System.out.println("StockItemConsumptionBean.java,702");
						hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					//hmResult = salesRemote.delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to salesMethodCall()") ;
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

          

			if( ((Boolean) hmResult.get("result")).booleanValue() ){	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
				//System.out.println("if = > "+hmResult.get("message"));
			}
			else if( hmResult.get("msgid")!=null  )
			{
				//System.out.println("StockItemConsumptionBean.java");
				//System.out.println("#############################");
				//System.out.println(" hmResult.get(msgid) = > "+ hmResult.get( "msgid" ));
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
				//System.out.println("hmResult.get() = > "+hmResult.get("message"));
				//System.out.println("#############################");
			}
			
			else
			{
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
				//System.out.println("else = > "+hmResult.get("message"));
			}

            
		} 
		catch(Exception exception) {
			//System.out.println("Catch block of StockItemConsumptionBean.java");
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( salesRemote != null )
					salesRemote.remove() ;
			}
			catch( Exception exception) {
			
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}

		/* SEND TO PRINT ONLINE REPORT STARTS*/		
	        ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	


			String alertRqdYN = "";
			setPrintDocNo(doc_no);

			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getStore_code() ;
//            PgetTrnType  = getTrn_type() ; 
			


			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());

			try{
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			}
			catch(Exception exception)
			{
				exception.printStackTrace() ;
		
			}
			
	//if (finalized_yn.equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
	//	if (isInternalRequest("ST","STBSTCDC")) {
		//	 doc_no	=	(String)hmResult.get("doc_no");	
	//		doOnlineReportPrinting(doc_no);				
		//}
	//}

		   if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{


				boolean bnTrueFalse ;

                String stReportid = "STBSTCDC" ;

				bnTrueFalse = isInternalRequest("ST",stReportid);


				if ( bnTrueFalse &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{

						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");

						}else{
							//javax.servlet.http.HttpSession session = request.getSession(false);


							/*doOnlineReportPrinting(doc_no);		
							String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}*/
							hmResult.put("flag",hmResult.get("flag") + "~PN");


						}
			    }
			}
		//System.out.println("StockItemConsumptionBean.java,817");
		return hmResult;
	}

	public boolean DocTypePrintAllowed (String PgetDoc_type_code){
		if (isDocTypePrintAllowed(PgetDoc_type_code)) 
			return true;
		else
			return false;
	}

//	public void doOnlineReportPrinting(javax.servlet.http.HttpSession session, String doc_no) {

		/*public void doOnlineReportPrinting(String doc_no) {

		try{


//            javax.servlet.http.HttpSession session = request.getSession(false);

			String reportid = "STBSTCDC";

			//if (!isInternalRequest("ST",reportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());

			//hmReportParameter.put("p_seq_no",PgetSeqNo);
			//javax.servlet.http.HttpSession session = request.getSession(false);


            if ( ! isDocTypePrintAllowed(PgetDoc_type_code) )  return ;
		


			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);

			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);


			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();

			
		}
		catch ( Exception exception) {
			exception.printStackTrace();

		}
	}*/

			public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBSTCDC";
			//String copies = getNoOfCopies(reportid);

			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", "STBSTCDC") ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", "STBSTCDC") ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "STBSALDC";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", getStore_code());

			reportParam.addParameter("p_module_id","ST");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());
			reportParam.addParameter("p_doc_type_code",getDoc_type_code());
	//			reportParam.addParameter("p_fr_st_code",getStore_code());
			reportParam.addParameter("p_doc_no",doc_no);
			reportParam.addParameter("p_fr_date",getDoc_date());
			reportParam.addParameter("p_to_date",getDoc_date());


			onlineReports.add(reportParam) ;
			String ReportOutput = onlineReports.execute( request, response);
		
		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	}
*/
	public String getAllItem_class_List() {
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLanguageId());
		return getListValues(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST1"),arr_language,"");
	}

	public String getSALStore_code_List() {
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		return getListValues(eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_SAL_STORE_SELECT"),alParameters,"");
	}

	public String getAuthorize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("SAL_AUTHORIZE_ALLOWED_YN").toString();
	}
	public String getStore_desc(String store_code) {
		String store_desc="";
		try {
		ArrayList alParameters=new ArrayList();
		alParameters.add(store_code);
		alParameters.add(getLanguageId());
		store_desc=fetchRecord(getStRepositoryValue("SQL_ST_OPENING_STOCK_STORE"), alParameters).get("SHORT_DESC").toString() ;

		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return store_desc;
    }

public String getDoc_type_desc(String doc_type_code) {
		String doc_type_desc = "";
		try {
			ArrayList alParameters=new ArrayList();
		alParameters.add(doc_type_code);
		alParameters.add(getLanguageId());
			doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),alParameters).get("SHORT_DESC").toString();
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

	public ArrayList getBatchStatus(String stItem_code,String stBatch_id,String stExpiry_date) throws Exception{
		

		String chkParameters[] = {stItem_code,stBatch_id,stExpiry_date};
         
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_BATCH_STATUS_SELECT_QUERY"),chkParameters);

		return result;
	}
	
	public String getpatlength () //throws Exception
		{ 
		String patient_id_length ;
		try {
				String stSQL=getStRepositoryValue("SQL_ST_PATIENT_ID_LENGTH");
				patient_id_length = fetchRecord(stSQL.toString()).get("PATIENT_ID_LENGTH").toString();
				return patient_id_length;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				//throw e ;
			} 
			return null;
	}

/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
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
	public String getCONItemClassBased(String trntype)
	{
		String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				
				records = fetchRecord(getStRepositoryValue("SQL_ST_GRN_ITEM_CLASS_BASED_YN"),chkdefaultParameters);
				result=(String)records.get("ITEM_CLASS_BASED_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/*public double getConvFactTemp(String item_code,String store_code){
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
	}*/
	/*public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");

		return gen_uom_code;
	}*/
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
	//	ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
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
	/*Added By Dinesh T for CRF-110, starts*/
	public ArrayList getCustomerId()throws Exception
	{
		return fetchRecords("SELECT CUSTOMER_ID FROM SM_SITE_PARAM");
	}
	/*Added By Dinesh T for CRF-110, ends*/

	public ArrayList getItemStoreList(String store_code)
	{//Adding start for TH-KW-CRF-0043
		Connection connection      = null;
		PreparedStatement pstmt    = null;
        ResultSet resultSet        = null;
		String sql                 = "";
		String item_code           = "";
		int no_of_decimals         = getNoOfDecimals();
		ArrayList records          = new ArrayList();
		
		try{

			connection = getConnection() ;

			sql ="SELECT M.ITEM_CODE,SHORT_DESC,SS.QTY_ON_HAND,SS.DEF_ISSUE_UOM,M.GEN_UOM_CODE,S.EXPIRY_YN,SS.STOCK_ITEM_YN,PHY_INV_ID FROM MM_ITEM_LANG_VW M,ST_ITEM_STORE SS,ST_ITEM S WHERE M.ITEM_CODE =SS.ITEM_CODE AND  M.ITEM_CODE = S.ITEM_CODE AND CONSUMPTION_ALLOWED_YN ='Y' and ss.eff_status ='E' and m.eff_status ='E' AND  SS.STORE_CODE =? AND  M.LANGUAGE_ID =? ";
				
				pstmt =connection.prepareStatement(sql);
				pstmt.setString(1, store_code) ;
			    pstmt.setString(2, language_id);

			resultSet = pstmt.executeQuery() ;

			while(resultSet!=null && resultSet.next()){
				item_code=(String)resultSet.getString("ITEM_CODE");
				String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
                HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(stParameters);
				String avail_stock=Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/getConvFactTemp(item_code,store_code)+"";
				records.add(resultSet.getString("ITEM_CODE"));
				records.add(resultSet.getString("SHORT_DESC"));
				records.add(setNumber(avail_stock,no_of_decimals));
				records.add(resultSet.getString("DEF_ISSUE_UOM"));
				records.add(setNumber(""+getBaseUnitCost(item_code),no_of_decimals));
				records.add(resultSet.getString("GEN_UOM_CODE"));
				records.add(resultSet.getString("EXPIRY_YN"));
				records.add(resultSet.getString("STOCK_ITEM_YN"));
				records.add(resultSet.getString("PHY_INV_ID"));
			}

				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				 es.printStackTrace();
			}
		}
		return records;
	}
public String getUOMDesc(String uom_code) throws Exception {

		String uom	  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_UOM_DESC_SELECT"),uom_code);
		}catch(Exception e){
			uom = "";
		}
		
		if(default_uom.size() > 0)
			uom = (String)default_uom.get("SHORT_DESC");

		return uom;

	}//Adding end for TH-KW-CRF-0043
	
}
   
