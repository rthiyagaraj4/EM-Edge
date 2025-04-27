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
13/06/2018					8109						Shazana 													GHL-SCF-1337 - modified sales_doc_date as suggested by Balaraman
--------------------------------------------------------------------------------------------------------------------------------------------
*/

  package eST;  


import java.sql.*;
//import eST.Common.StTransaction;
import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.util.*;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
public class SalesReturnBean extends StHeaderBean implements Serializable{

	private String patient_id;
	private String sal_trn_type;
	private String encounter_id;
	private String patient_name;
//	private String authorized_by_id;
	private String finalized_yn;  
	private String records_to_delete;
	private String remarks;
	private String sales_doc_no;
	private String sales_doc_type_code;
	//private String language_id;
	private boolean	isAutoNo;
	private ArrayList PDocNo = new ArrayList();
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String stReportid = null;
	public String reportserver = "";
	public String report_connect_string = "";
	private HashMap		bill_data   = new HashMap();
	private String NU_Clinic_code = "";
	private ArrayList		alTempExpRecords=new ArrayList();//Added against GHL-CRF-0413.5

//Modified on 22/12
	//private HashMap		hmExpRecords=new HashMap();
	//private ArrayList	alDtlRecords=new ArrayList();
	private HashMap		hmExpRecords;
	private ArrayList	alDtlRecords;
	private ArrayList	alExpRecords_temp;
	private int doc_srl_no	=	0;
	private String billable_trn_yn;
	private String sales_doc_date;//ADDED for ghl-scf-1337
	
//	boolean autoGenerateYN=false;


//	private javax.servlet.http.HttpServletRequest request;
//	private javax.servlet.http.HttpServletResponse response;

//ADDED for ghl-scf-1337
	public String getSales_doc_date() {
		return sales_doc_date;
	}

	public void setSales_doc_date(String sales_doc_date) {
		this.sales_doc_date = sales_doc_date;
	}

	public void initialize(){
		super.initialize();
		hmExpRecords=new HashMap();
		alDtlRecords=new ArrayList();
		patient_id="";  
		sal_trn_type="";
		encounter_id="";
		patient_name="";
//		authorized_by_id=""; 
		finalized_yn="";     
		remarks="";
		records_to_delete="";
		NU_Clinic_code="";
		alTempExpRecords = new ArrayList();//Added against GHL-CRF-0413.5
	}

	public void  clear(){
		super.clear();
		hmExpRecords=new HashMap();  
		alDtlRecords=new ArrayList();
		doc_srl_no	=	0;
		patient_id=null;  
		sal_trn_type=null;
		encounter_id=null;
		patient_name=null;
//		authorized_by_id=null; 
		finalized_yn=null;     
		remarks=null;
		records_to_delete=null;
		NU_Clinic_code="";
		alTempExpRecords = null;//Added against GHL-CRF-0413.5
	}

	/*public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/
	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean setIsAutoNo() {
		return this.isAutoNo;
	}

	public void setRemarks(String remarks) {
		 this.remarks= checkForNull(remarks);  
	}

	public String getRemarks( ) {
		 return remarks;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn= finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}
/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
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
	public void setSalesDocNo(String sales_doc_no) {
		 this.sales_doc_no = sales_doc_no;
	}

	public String getSalesDocNo( ) {
		 return this.sales_doc_no;
	}
	public void setSalesDocTypeCode(String sales_doc_type_code) {
		 this.sales_doc_type_code = sales_doc_type_code;
	}

	public String getSalesDocTypeCode( ) {
		 return this.sales_doc_type_code;
	}

	public void setPatient_name(String patient_name) {
		 this.patient_name = patient_name;
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}
public void setBillable_trn_yn(String billable_trn_yn){
		this.billable_trn_yn = billable_trn_yn;
	}

	public String getBillable_trn_yn(){
		return this.billable_trn_yn;
	}
	public int getDoc_srl_no(){
		return doc_srl_no;
	}

	public void setDoc_srl_no(String doc_srl_no){
		this.doc_srl_no=Integer.parseInt(doc_srl_no);
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

	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("SRT_FINALIZE_ALLOWED_YN").toString();
	}

	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	public void setbill_data(HashMap bill_data){
		
		this.bill_data=bill_data;
	}

	public HashMap getbill_data(){
		return (HashMap)bill_data;
	
	}
	public void setNU_Clinic_code(String NU_Clinic_code) {
		 this.NU_Clinic_code = NU_Clinic_code;
	}

	public String getNU_Clinic_code( ) {
		
		 return NU_Clinic_code;
	}

	//Added by sharanraj against GHL-CRF-0483 starts
	public String getSal_Doc_Chkd() {
		String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("select SAL_DOC_PICKED_YN from st_facility_param WHERE facility_id=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return checkForNull((String)hmRecord.get("SAL_DOC_PICKED_YN"));
	}
	
	//Added by sharanraj against GHL-CRF-0483 ends
	
	public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		Connection connection = null;

		try {
			connection = getConnection();

			// To call the procedure st_stock_availability_status
		

			String[] strParameters = new String[7];

			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";
			strParameters[6] = "";

        
			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);

			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn"));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("item_unit_cost"));
				/* @Name - Priya
				* @Date - 18/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and  assign it to the item_unit_cost key
				*/
			String storeItemUnitCost=getUnitCost(item_code,store_code);
			
			BatchDetails.add(new Double (storeItemUnitCost));
			//BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("store_item_unit_cost")));
		/** @ 
		 CRF_SRR20056-CRF-0537.1 
		 For handle the Decimals in QOH, avail_Qty Modifications begin  
		
		*/ 
			int no_of_decimals=getNoOfDecimals();
			String 	allow_decimals_yn=getAllowDecimalsYN(item_code);
			if(allow_decimals_yn.equals("Y")){
			BatchDetails.add(new Double(setNumber((String)hmStockAvailabilityStatus.get("available_stock"),no_of_decimals)));
			BatchDetails.add(new Double(setNumber((String)hmStockAvailabilityStatus.get("expired_stock"),no_of_decimals)));
			}else{
			BatchDetails.add(new Double(setNumber((String)hmStockAvailabilityStatus.get("available_stock"),0)));
			BatchDetails.add(new Double(setNumber((String)hmStockAvailabilityStatus.get("expired_stock"),0)));
		
			}
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end  
		
			*/ 

			/** @ 		
			Orginal code before modifiCation 

			BatchDetails.add(new Integer((String)hmStockAvailabilityStatus.get("available_stock")));
			BatchDetails.add(new Integer ((String)hmStockAvailabilityStatus.get("expired_stock")));
			*/ 
			
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));

			
		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		finally {
			closeConnection(connection);
		}
		return BatchDetails;
	}


	public void updateDtlRecord(int index, HashMap hmDtlRecord){
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		if (index!=-1){
			mode	=	(String)((HashMap)alDtlRecords.get(index)).get("mode");
		}
		hmDtlRecord.put("mode",mode);
		
		if (index==-1){
			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
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
			String stTempItemQty= (String)htExpRecords.get("item_qty_"+i);
			HashMap hmExpRecord	=	(HashMap)alExpRecords.get(i);
			if(!stTempItemQty.equals(""))
            {
				hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
				hmExpRecord.put("STORE_CODE", getStore_code());
				
				if( hmExpRecord.containsKey("NEW_BIN_LOCATION_CODE") == true )
                {
					hmExpRecord.remove("NEW_BIN_LOCATION_CODE");
					hmExpRecord.put("NEW_BIN_LOCATION_CODE", htExpRecords.get("bin_location_code_"+i));
			    }else{
                    hmExpRecord.put("NEW_BIN_LOCATION_CODE", htExpRecords.get("bin_location_code_"+i));
				}

       		   alExpRecords.set(i,hmExpRecord); 
			}else{
				hmExpRecord.put("QTY","");
				alExpRecords.set(i,hmExpRecord);
			}
		}
		for(int i=0;i<alExpRecords.size();)
		{
			if(  ((String)((HashMap)alExpRecords.get(i)).get("QTY")).equals("")   )
			 {	
				HashMap hmAldtlData = (HashMap)alDtlRecords.get(index);
				int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));
				--batch_records;
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

	

	public void setAll(Hashtable hashtable) {
		patient_id	=(String)hashtable.get("patient_id");  
		sal_trn_type=(String)hashtable.get("sal_trn_type");  
		setRemarks((String)hashtable.get("remarks"));  
		setEncounter_id((String)hashtable.get("encounter_id"));  
		setSalesDocNo((String)hashtable.get("sales_doc_no"));  
		patient_name=(String)hashtable.get("patient_name");  
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		records_to_delete=(String)hashtable.get("records_to_delete");  
		NU_Clinic_code	=  checkForNull((String)hashtable.get("NU_Clinic_code"));
    }


   /*
	public ArrayList getEncounterArrayList(String patient_id,String sal_trn_type,String siteId) throws Exception{ 
		System.out.println("SalesReturnBean.java,patient_id = > "+patient_id+" sal_trn_type = > "+sal_trn_type+" siteId = > "+siteId);
		if(siteId.equals("MC"))
		{
			String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type};
			//return fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST"),stParameters);
			return fetchRecords("SELECT	ENCOUNTER_ID, ENCOUNTER_ID ITISTOPOPULATELISTBOX  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND PATIENT_ID=UPPER(?) AND (VISIT_STATUS NOT IN ('99') OR VISIT_STATUS IS NULL) AND (ADT_STATUS NOT IN ('09','08') OR ADT_STATUS IS NULL) AND PATIENT_CLASS= DECODE(?, 'I', 'IP','O','OP','E','EM','D','DC') ORDER BY ENCOUNTER_ID DESC",stParameters);
		}
		else
		{
			String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type};
			//return fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST"),stParameters);
			return fetchRecords("SELECT	ENCOUNTER_ID, ENCOUNTER_ID ITISTOPOPULATELISTBOX  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND PATIENT_ID=UPPER(?) AND (VISIT_STATUS NOT IN ('99') OR VISIT_STATUS IS NULL) AND (ADT_STATUS NOT IN ('09') OR ADT_STATUS IS NULL) AND PATIENT_CLASS= DECODE(?, 'I', 'IP','O','OP','E','EM','D','DC') ORDER BY ENCOUNTER_ID DESC",stParameters);
		}
	}
	this is commented by gangadharan to modified the query to remove 08 (closed encounter)*/

	public ArrayList getEncounterArrayList(String patient_id,String sal_trn_type,String siteId) throws Exception{ 
	    	//String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type};
			String stParameters[]={getLoginFacilityId(),patient_id,sal_trn_type,getLoginFacilityId(),getLoginFacilityId()};
			//return fetchRecords("SELECT	ENCOUNTER_ID, ENCOUNTER_ID ITISTOPOPULATELISTBOX  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND PATIENT_ID=UPPER(?) AND (VISIT_STATUS NOT IN ('99') OR VISIT_STATUS IS NULL) AND (ADT_STATUS NOT IN ('09') OR ADT_STATUS IS NULL) AND PATIENT_CLASS= DECODE(?, 'I', 'IP','O','OP','E','EM','D','DC') ORDER BY ENCOUNTER_ID DESC",stParameters);
    		return fetchRecords("SELECT  ENCOUNTER_ID, ENCOUNTER_ID ITISTOPOPULATELISTBOX  FROM PR_ENCOUNTER a WHERE FACILITY_ID=? AND PATIENT_ID=UPPER(?) AND (VISIT_STATUS NOT IN ('99') OR VISIT_STATUS IS NULL) AND (ADT_STATUS NOT IN ('09') OR ADT_STATUS IS NULL) AND PATIENT_CLASS= DECODE(?, 'I', 'IP','O','OP','E','EM','D','DC') and 'Y' = OR_GET_ACCESS_RULE(?,a.encounter_id,'PH',a.patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'), to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI'), (SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=? and ENCOUNTER_ID=a.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1) ) order by VISIT_ADM_DATE_TIME desc",stParameters);
		}
	

    public ArrayList getEncounterNewArrayList(String patient_id,String encounter_id,String sal_trn_type,String siteId) throws Exception{ 
			String stParameters[]={getLoginFacilityId(),patient_id,encounter_id,sal_trn_type,getLoginFacilityId(),getLoginFacilityId()};
		    return	fetchRecords("SELECT encounter_id  FROM pr_encounter a WHERE facility_id=? AND patient_id= upper(?) AND encounter_id= ? AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') and 'Y' = OR_GET_ACCESS_RULE(?,a.encounter_id,'PH',a.patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'), to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI'), (SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=? and ENCOUNTER_ID=a.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1) ) order by VISIT_ADM_DATE_TIME desc",stParameters);
        }


	public String getEncounter_id_List(){
		String stParameters[]={getLoginFacilityId(),getPatient_id(),getSal_trn_type()};
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST"), stParameters),getEncounter_id());
		return getListOptionTag(getListOptionArrayList("SELECT	encounter_id, encounter_id ItIsToPopulateListBox  FROM pr_encounter WHERE facility_id=? AND patient_id=upper(?) AND (visit_status NOT IN ('99') or visit_status is null) AND (adt_status NOT IN ('09') or adt_status is null) and patient_class= decode(?, 'I', 'IP','O','OP','E','EM','D','DC') order by encounter_id desc", stParameters),getEncounter_id());
	}

	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean
		not required to process exp records..*/
 		return getMessageHashMap(true);	
	}

	public String getSal_trn_type_List() {
            return getStaticListOptionTag("I,InPatient;O,OutPatient;R,Referral", getSal_trn_type());
		}


    public String getBinLocation_desc(String bin_code) {
		String bin_desc="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(bin_code);
			arr_language.add(getLanguageId());
			bin_desc=fetchRecord(getStRepositoryValue("SQL_ST_BIN_LOCATION_DESC"), arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return bin_desc;
    }

	public java.util.ArrayList calculatePendingQuantity(String facility_id,String patient_id,String encounter_id,String item_code){
		java.util.ArrayList alPendingQty=new  java.util.ArrayList();
	    java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;

        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_RET_CALCULATE_PENDING_QTY"));
			
            pstmt.setString(1, facility_id);
            pstmt.setString(2, patient_id);
            pstmt.setString(3, encounter_id);
            pstmt.setString(4, item_code);
			pstmt.setString(5, getStore_code());


            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String stPendingQty = "" ;
                stPendingQty = resultSet.getString(1);
                alPendingQty.add(stPendingQty);
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
	return alPendingQty;
}

	public HashMap getSalesReturnBatches(HashMap hmParameters)throws Exception{
		String stItem_code				=	(String)hmParameters.get("ITEM_CODE");
		String stPatient_id				=	(String)hmParameters.get("PATIENT_ID");
		String stEncounter_id			=	(String)hmParameters.get("ENCOUNTER_ID");
		String stStore_code				=	(String)hmParameters.get("STORE_CODE");
		String sal_trn_type				=	(String)hmParameters.get("SAL_TRN_TYPE");
		/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begin  
		
			*/ 
			double iTxn_qty					=	Double.parseDouble((String)hmParameters.get("TRN_QTY"));
			double iCount		=	0;
		/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end  
		
			*/

		/** @ before modifaction 
			int iTxn_qty					=	Integer.parseInt((String)hmParameters.get("TRN_QTY"));
			int iCount		=	0;
		*/
		boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");
		int no_of_decimals=getNoOfDecimals();
		
	
		
		HashMap hmReturn	= new HashMap();
		ArrayList alReturn	= new ArrayList();

		try { 
					
			ArrayList alParameters	=	new ArrayList();
            String stFacilityId=getLoginFacilityId();
			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add("SRT");
			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add("SRT");
            alParameters.add(stFacilityId);
			alParameters.add(stPatient_id);
			alParameters.add(stEncounter_id);
			alParameters.add(stItem_code);
			alParameters.add(stStore_code);
			alParameters.add(sal_trn_type);
			alParameters.add(getLanguageId());
			alParameters.add(getSalesDocTypeCode());
			alParameters.add(getSalesDocNo());



			//ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SALES_RETURN_BATCH_SEARCH_QUERY"),alParameters);
			ArrayList alRecords	=	fetchRecords("SELECT  nvl(sti.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN ,sde.item_code, mmi.short_desc item_desc, sde.batch_id, sde.bin_location_code bin_location_code, mmb.short_desc bin_desc, TO_CHAR (sde.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_receipt_dt, sde.trade_id, DECODE(sti.trade_id_applicable_yn, 'Y', (SELECT short_name FROM am_trade_name_lang_vw  am_trade_name WHERE trade_id = sde.trade_id AND mmi.language_id = am_trade_name.language_id), sde.trade_id) trade_name, sde.sal_item_qty, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )avail_qty, sde.doc_type_code sal_doc_type_code, sde.doc_no sal_doc_no, sde.doc_srl_no sal_doc_srl_no, TO_CHAR (sdh.doc_date, 'dd/mm/yyyy') sal_doc_date, srexp.bin_location_code ret_bin_locn FROM ST_SAL_DTL_EXP sde, mm_item_lang_vw mmi, ST_ITEM sti, ST_SAL_HDR sdh,          ST_SAL_DTL ssd, mm_bin_location_lang_vw mmb, ST_SAL_RET_DTL_EXP srexp WHERE (sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )) > 0 AND sde.facility_id = ? AND sde.facility_id || '-' || sde.doc_type_code || '-' || sde.doc_no IN (SELECT facility_id || '-' || doc_type_code || '-' || doc_no FROM ST_SAL_HDR WHERE patient_id = ? AND NVL (encounter_id, 0) LIKE NVL (?, '0') AND finalized_yn = 'Y') AND mmi.item_code = sde.item_code AND sde.item_code = sti.item_code AND sde.item_code = ? AND sde.store_code = ? AND mmb.bin_location_code = sde.bin_location_code AND mmb.store_code = sde.store_code AND (    sde.facility_id = ssd.facility_id AND sde.doc_type_code = ssd.doc_type_code AND sde.doc_no = ssd.doc_no AND sde.doc_srl_no = ssd.doc_srl_no) AND sdh.sal_trn_type = ? AND ssd.stock_item_yn = 'Y' AND (    sdh.facility_id = ssd.facility_id AND sdh.doc_type_code = ssd.doc_type_code AND sdh.doc_no = ssd.doc_no) AND mmi.language_id = mmb.language_id AND mmi.language_id = ? AND sde.doc_type_code = ? AND sde.doc_no = ? AND sde.batch_id = srexp.batch_id(+) AND sde.trade_id = srexp.trade_id(+) 	 AND sde.doc_no = srexp.sal_doc_no(+) AND sde.doc_type_code = srexp.sal_doc_type_code(+) AND  TRUNC(sde.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC(srexp.EXPIRY_DATE_OR_RECEIPT_DATE(+)) ORDER BY sdh.added_date",alParameters);

			for (int i=0;i<alRecords.size();i++ ) {
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begin  
		
			*/ 
				double avail_qty		=	Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end 
		
			*/ 
				/** @ 
			before modification
			int avail_qty		=	Integer.parseInt((String)hmRecord.get("AVAIL_QTY"));
		
			*/ 
				String 	allow_decimals_yn=getAllowDecimalsYN(stItem_code);
				if (iTxn_qty>(iCount+avail_qty)) {
					iCount+=avail_qty;
				/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begin 
		
			*/
				if(allow_decimals_yn.equals("Y")){
				hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
				}else{
				hmRecord.put("QTY",setNumber(""+avail_qty,0));
				}
			/** @ 
				before modification
				hmRecord.put("QTY",""+avail_qty);
		
			*/ 
					alReturn.add(hmRecord);
				}
				else{
					avail_qty=	iTxn_qty-iCount;
					iCount+=avail_qty;
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begin 
		
			*/
				if(allow_decimals_yn.equals("Y")){
				hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
				}else{
				hmRecord.put("QTY",setNumber(""+avail_qty,0));
				}
			/** @ 
				before modification
				hmRecord.put("QTY",""+avail_qty);
		
			*/ 
				alReturn.add(hmRecord);
					break;
				}
			}
			if(iTxn_qty!=iCount){
				hmReturn.put("EXCEPTION","Insufficient Batch Exception"); //InsufficientBatchException(iCount)
				if (bVerifyInsufficientQty) {
					throw new Exception(); //InsufficientBatchException(iCount);
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		hmReturn.put("BATCH_DATA",alReturn);
		return hmReturn;
	}


	public void loadData() throws Exception{
		ArrayList alParameters	=	new ArrayList(6);

		
		alParameters.add(getLoginFacilityId()); 
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_SAL_RET_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		doc_srl_no		=	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));
		/** @ 
		 CRF_SRR20056-CRF-0537.1 
		 For handle the Decimals in QOH, avail_Qty Modifications begin  
		
		*/ 
		
		int no_of_decimals=getNoOfDecimals();
	
	
		/** @ 
		 CRF_SRR20056-CRF-0537.1 
		 For handle the Decimals in QOH, avail_Qty Modifications end  
		
		*/ 
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_SAL_RET_HDR_SELECT_SINGLE"), alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setStore_code((String)hmRecord.get ("STORE_CODE"));  
		setPatient_id((String)hmRecord.get ("PATIENT_ID"));  
		setSal_trn_type((String)hmRecord.get("TRN_TYPE"));
		setEncounter_id((String)hmRecord.get("ENCOUNTER_ID"));
		setPatient_name((String)hmRecord.get("PATIENT_NAME"));
		setRemarks(checkForNull((String)hmRecord.get("REMARKS"),""));
		setItem_class_code(checkForNull((String)hmRecord.get("ITEM_CLASS_CODE")));
		setSal_trn_type(checkForNull((String)hmRecord.get("SAL_TRN_TYPE")));
		setSalesDocNo(checkForNull((String)hmRecord.get("SALES_DOC_NO")));
		setNU_Clinic_code(checkForNull((String)hmRecord.get("LOCN_CODE")));  

		alParameters.clear();

		alParameters.add(checkForNull((String)hmRecord.get("FACILITY_ID")));//ADDED BY GANGA  against the inc#28308
		alParameters.add(checkForNull((String)hmRecord.get("SALES_DOC_TYPE_CODE")));
		alParameters.add(checkForNull((String)hmRecord.get("SALES_DOC_NO")));
		alParameters.add(getLanguageId());//20/06/12
        alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());//ADDED ended 
		alParameters.add(getLanguageId());

		//ArrayList alRecords	=	fetchRecords("SELECT nvl(C.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,C.RETURN_ALLOWED_YN RETURN_ALLOWED_YN, A.DOC_NO, A.DOC_SRL_NO, A.ITEM_CODE, B.SHORT_DESC ITEM_DESC,A.STOCK_ITEM_YN, A.ITEM_QTY, A.ITEM_UNIT_COST, A.ITEM_COST_VALUE,A.PAT_NET_AMT, A.GROSS_CHARGE_AMT, H.DEF_ISSUE_UOM UOM_CODE,D.SHORT_DESC UOM_DESC, A.REMARKS,DECODE(A.STOCK_ITEM_YN,'Y', (SELECT SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = A.FACILITY_ID AND (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, ITEM_CODE) IN (SELECT FACILITY_ID, SAL_DOC_TYPE_CODE,SAL_DOC_NO, ITEM_CODE FROM ST_SAL_RET_DTL_EXP WHERE FACILITY_ID = A.FACILITY_ID AND DOC_TYPE_CODE = A.DOC_TYPE_CODE AND DOC_NO = A.DOC_NO AND ITEM_CODE = A.ITEM_CODE))) /*+ A.ITEM_QTY*/ STOCK_AVAILABLE, E.SALES_DOC_NO, F.DOC_SRL_NO SALES_DOC_SRL_NO,G.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,B.BILLABLE_ITEM_YN FROM ST_SAL_RET_DTL A,MM_ITEM_LANG_VW B,ST_ITEM C,AM_UOM_LANG_VW D,ST_SAL_RET_HDR E,ST_SAL_DTL F,ST_SAL_HDR G,ST_ITEM_STORE H WHERE A.FACILITY_ID = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_NO = ? AND A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND H.DEF_ISSUE_UOM = D.UOM_CODE AND H.ITEM_CODE = A.ITEM_CODE AND H.STORE_CODE = E.STORE_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND F.DOC_NO = E.SALES_DOC_NO AND G.DOC_TYPE_CODE = F.DOC_TYPE_CODE AND G.DOC_NO = F.DOC_NO AND G.MODULE_ID = 'ST' AND F.DOC_SRL_NO = A.DOC_SRL_NO ORDER BY 2", alParameters);
		//ArrayList alRecords	=	fetchRecords("SELECT DISTINCT nvl(C.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,C.RETURN_ALLOWED_YN RETURN_ALLOWED_YN, A.DOC_NO, A.DOC_SRL_NO, A.ITEM_CODE, B.SHORT_DESC ITEM_DESC,A.STOCK_ITEM_YN, A.ITEM_QTY, A.ITEM_UNIT_COST, A.ITEM_COST_VALUE,A.PAT_NET_AMT, A.GROSS_CHARGE_AMT, H.DEF_ISSUE_UOM UOM_CODE,D.SHORT_DESC UOM_DESC, A.REMARKS,DECODE(A.STOCK_ITEM_YN,'Y', (SELECT SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = A.FACILITY_ID AND (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, ITEM_CODE) IN (SELECT FACILITY_ID, SAL_DOC_TYPE_CODE,SAL_DOC_NO, ITEM_CODE FROM ST_SAL_RET_DTL_EXP WHERE FACILITY_ID = A.FACILITY_ID AND DOC_TYPE_CODE = A.DOC_TYPE_CODE AND DOC_NO = A.DOC_NO AND ITEM_CODE = A.ITEM_CODE))) /*+ A.ITEM_QTY*/ STOCK_AVAILABLE, E.SALES_DOC_NO, F.DOC_SRL_NO SALES_DOC_SRL_NO,G.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,B.BILLABLE_ITEM_YN FROM ST_SAL_RET_DTL A,MM_ITEM_LANG_VW B,ST_ITEM C,AM_UOM_LANG_VW D,ST_SAL_RET_HDR E,ST_SAL_DTL F,ST_SAL_HDR G,ST_ITEM_STORE H, ST_SAL_RET_DTL_EXP i WHERE A.FACILITY_ID = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_NO = ? AND A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND H.DEF_ISSUE_UOM = D.UOM_CODE AND H.ITEM_CODE = A.ITEM_CODE AND H.STORE_CODE = E.STORE_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND F.DOC_NO = E.SALES_DOC_NO AND G.DOC_TYPE_CODE = F.DOC_TYPE_CODE AND G.DOC_NO = F.DOC_NO AND G.MODULE_ID = 'ST' AND F.DOC_SRL_NO = A.DOC_SRL_NO  AND G.DOC_TYPE_CODE=I.SAL_DOC_TYPE_CODE AND   A.FACILITY_ID=I.FACILITY_ID AND   A.DOC_TYPE_CODE=I.DOC_TYPE_CODE AND   A.ITEM_CODE=I.ITEM_CODE AND A.DOC_NO=I.DOC_NO AND F.DOC_NO = I.SAL_DOC_NO  AND A.DOC_SRL_NO=I.DOC_SRL_NO  ORDER BY 2", alParameters);
		//commented by ganga against the inc#28308
        //ArrayList alRecords	=	fetchRecords("SELECT DISTINCT nvl(C.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,C.RETURN_ALLOWED_YN RETURN_ALLOWED_YN, A.DOC_NO, A.DOC_SRL_NO, A.ITEM_CODE, B.SHORT_DESC ITEM_DESC,A.STOCK_ITEM_YN, A.ITEM_QTY, A.ITEM_UNIT_COST, A.ITEM_COST_VALUE,A.PAT_NET_AMT, A.GROSS_CHARGE_AMT, H.DEF_ISSUE_UOM UOM_CODE,D.SHORT_DESC UOM_DESC, A.REMARKS,DECODE(A.STOCK_ITEM_YN,'Y', (SELECT SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = ? and DOC_TYPE_CODE = ? and DOC_NO = ?  AND (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, ITEM_CODE) IN (SELECT FACILITY_ID, SAL_DOC_TYPE_CODE,SAL_DOC_NO, ITEM_CODE FROM ST_SAL_RET_DTL_EXP WHERE FACILITY_ID = A.FACILITY_ID AND DOC_TYPE_CODE = A.DOC_TYPE_CODE AND DOC_NO = A.DOC_NO AND ITEM_CODE = A.ITEM_CODE))) /*+ A.ITEM_QTY*/ STOCK_AVAILABLE, E.SALES_DOC_NO, F.DOC_SRL_NO SALES_DOC_SRL_NO,G.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,B.BILLABLE_ITEM_YN FROM ST_SAL_RET_DTL A,MM_ITEM_LANG_VW B,ST_ITEM C,AM_UOM_LANG_VW D,ST_SAL_RET_HDR E,ST_SAL_DTL F,ST_SAL_HDR G,ST_ITEM_STORE H, ST_SAL_RET_DTL_EXP i WHERE A.FACILITY_ID = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_NO = ? AND A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND H.DEF_ISSUE_UOM = D.UOM_CODE AND H.ITEM_CODE = A.ITEM_CODE AND H.STORE_CODE = E.STORE_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND F.DOC_NO = E.SALES_DOC_NO AND G.DOC_TYPE_CODE = F.DOC_TYPE_CODE AND G.DOC_NO = F.DOC_NO AND G.MODULE_ID = 'ST' AND F.DOC_SRL_NO = A.DOC_SRL_NO  AND G.DOC_TYPE_CODE=I.SAL_DOC_TYPE_CODE AND   A.FACILITY_ID=I.FACILITY_ID AND   A.DOC_TYPE_CODE=I.DOC_TYPE_CODE AND   A.ITEM_CODE=I.ITEM_CODE AND A.DOC_NO=I.DOC_NO AND F.DOC_NO = I.SAL_DOC_NO  AND A.DOC_SRL_NO=I.DOC_SRL_NO  ORDER BY 3", alParameters);
		//COMMENTED TO ADDED SOME JOIN CONDITIONS
		ArrayList alRecords	=	fetchRecords("SELECT DISTINCT nvl(C.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,C.RETURN_ALLOWED_YN RETURN_ALLOWED_YN, A.DOC_NO, A.DOC_SRL_NO, A.ITEM_CODE, B.SHORT_DESC ITEM_DESC,A.STOCK_ITEM_YN, A.ITEM_QTY, A.ITEM_UNIT_COST, A.ITEM_COST_VALUE,A.PAT_NET_AMT, A.GROSS_CHARGE_AMT, H.DEF_ISSUE_UOM UOM_CODE,D.SHORT_DESC UOM_DESC, A.REMARKS REMARKS_CODE,DECODE(A.STOCK_ITEM_YN,'Y', (SELECT SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) FROM ST_SAL_DTL_EXP WHERE FACILITY_ID = ? and DOC_TYPE_CODE = ? and DOC_NO = ?  AND (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, ITEM_CODE) IN (SELECT FACILITY_ID, SAL_DOC_TYPE_CODE,SAL_DOC_NO, ITEM_CODE FROM ST_SAL_RET_DTL_EXP WHERE FACILITY_ID = A.FACILITY_ID AND DOC_TYPE_CODE = A.DOC_TYPE_CODE AND DOC_NO = A.DOC_NO AND ITEM_CODE = A.ITEM_CODE))) /*+ A.ITEM_QTY*/ STOCK_AVAILABLE, E.SALES_DOC_NO, F.DOC_SRL_NO SALES_DOC_SRL_NO,G.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,B.BILLABLE_ITEM_YN,(SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE a.remarks = trm.trn_remarks_code AND  trm.language_id = ?) REMARKS FROM ST_SAL_RET_DTL A,MM_ITEM_LANG_VW B,ST_ITEM C,AM_UOM_LANG_VW D,ST_SAL_RET_HDR E,ST_SAL_DTL F,ST_SAL_HDR G,ST_ITEM_STORE H, ST_SAL_RET_DTL_EXP i WHERE A.FACILITY_ID = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_NO = ? AND A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND H.DEF_ISSUE_UOM = D.UOM_CODE AND H.ITEM_CODE = A.ITEM_CODE AND H.STORE_CODE = E.STORE_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND F.FACILITY_ID = E.FACILITY_ID AND F.DOC_NO = E.SALES_DOC_NO AND G.FACILITY_ID = F.FACILITY_ID AND G.DOC_TYPE_CODE = F.DOC_TYPE_CODE AND G.DOC_NO = F.DOC_NO AND F.FACILITY_ID = I.FACILITY_ID AND F.DOC_TYPE_CODE = I.SAL_DOC_TYPE_CODE AND F.DOC_NO = I.SAL_DOC_NO AND G.MODULE_ID = 'ST' AND F.DOC_SRL_NO = A.DOC_SRL_NO AND G.DOC_TYPE_CODE=I.SAL_DOC_TYPE_CODE AND G.DOC_NO=I.SAL_DOC_NO AND G.FACILITY_ID=I.FACILITY_ID AND A.FACILITY_ID=I.FACILITY_ID AND A.DOC_TYPE_CODE=I.DOC_TYPE_CODE AND A.DOC_NO=I.DOC_NO AND A.ITEM_CODE=I.ITEM_CODE AND A.DOC_SRL_NO=I.DOC_SRL_NO ORDER BY 3,4 ", alParameters);

		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
			hmTemp.put("item_unit_cost",hmRecord.get("ITEM_UNIT_COST"));
			hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS")));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("return_allowed_yn",hmRecord.get("RETURN_ALLOWED_YN"));

			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 
			hmTemp.put("no_of_decimals",""+no_of_decimals);
			//hmTemp.put("decimal_allowedYN",getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")));
			hmTemp.put("decimal_allowedYN",(String)hmRecord.get("ALLOW_DECIMALS_YN"));
			hmTemp.put("billable_item_yn",checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N"));
			double stock_available=0;
			if(((String)hmRecord.get("ALLOW_DECIMALS_YN")).equals("Y")){
			 stock_available=(Double.parseDouble(setNumber(checkForNull((String)hmRecord.get("STOCK_AVAILABLE"),"0"),no_of_decimals))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getStore_code()))+Double.parseDouble(setNumber(checkForNull((String)hmRecord.get("ITEM_QTY"),"0"),no_of_decimals));
			 hmTemp.put("stock_available",setNumber(""+stock_available,no_of_decimals));
			 hmTemp.put("item_qty",setNumber((String)hmRecord.get("ITEM_QTY"),no_of_decimals));
			 hmTemp.put("available_qty",setNumber(""+stock_available,no_of_decimals));//Added by suresh.r on 15-10-2014 against Inc 2919
			}else{
			stock_available=(Double.parseDouble(setNumber(checkForNull((String)hmRecord.get("STOCK_AVAILABLE"),"0"),no_of_decimals))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getStore_code()))+Double.parseDouble(setNumber(checkForNull((String)hmRecord.get("ITEM_QTY"),"0"),no_of_decimals));
			 hmTemp.put("stock_available",setNumber(""+stock_available,0));
			 hmTemp.put("item_qty",setNumber((String)hmRecord.get("ITEM_QTY"),0));
			 hmTemp.put("available_qty",setNumber(""+stock_available,0));//Added by suresh.r on 15-10-2014 against Inc 2919
		}
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end 
		
			*/ 
			
			/** @ orginal code 

			hmTemp.put("stock_available",""+stock_available);
			hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
			
			*/
			hmTemp.put("stock_item_yn",hmRecord.get("STOCK_ITEM_YN"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("pat_net_amt",hmRecord.get("PAT_NET_AMT"));
			hmTemp.put("gross_charge_amt",hmRecord.get("GROSS_CHARGE_AMT"));
			hmTemp.put("sales_doc_no",hmRecord.get("SALES_DOC_NO"));
			hmTemp.put("sal_doc_srl_no",hmRecord.get("SALES_DOC_SRL_NO"));
			hmTemp.put("sales_doc_type_code",hmRecord.get("SALES_DOC_TYPE_CODE"));
			hmTemp.put("remarks_code",checkForNull((String)hmRecord.get("REMARKS_CODE")));//20/06/12
			setSalesDocTypeCode(checkForNull((String)hmRecord.get("SALES_DOC_TYPE_CODE")));
			alDtlRecords.add(hmTemp);
		}

		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_no());
		alParameters.add(getDoc_type_code());
		alParameters.add("");
		alParameters.add(getLanguageId());
		
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			alParameters.set(3,(String)hmRecord.get("doc_srl_no"));

            //alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_RET_DTL_EXP_SELECT_MULTIPLE"), alParameters);
            //alRecords	=	fetchRecords("SELECT NVL(STI.ALLOW_DECIMALS_YN,'N')ALLOW_DECIMALS_YN, SRDE.ITEM_CODE,MMI.SHORT_DESC ITEM_DESC, SRDE.BATCH_ID, SRDE.BIN_LOCATION_CODE BIN_LOCATION_CODE ,SRDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE,MMB.SHORT_DESC  BIN_DESC,TO_CHAR(SRDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT , SRDE.TRADE_ID,DECODE(STI.TRADE_ID_APPLICABLE_YN,'Y', (SELECT SHORT_NAME FROM AM_TRADE_NAME_LANG_VW AM_TRADE_NAME WHERE TRADE_ID=SRDE.TRADE_ID AND MMI.LANGUAGE_ID = AM_TRADE_NAME.LANGUAGE_ID),SRDE.TRADE_ID) TRADE_NAME,SRDE.ITEM_QTY QTY, /*SDE.SAL_ITEM_QTY*/(SDE.SAL_ITEM_QTY - NVL (SDE.RET_ITEM_QTY, 0)) AVAIL_QTY, SRDE.SAL_DOC_TYPE_CODE,SRDE.SAL_DOC_NO,TO_CHAR(SDH.DOC_DATE,'DD/MM/YYYY') SAL_DOC_DATE,SDE.DOC_SRL_NO SAL_DOC_SRL_NO FROM ST_SAL_RET_DTL_EXP SRDE,ST_SAL_DTL_EXP SDE,ST_SAL_HDR SDH,MM_ITEM_LANG_VW MMI,MM_BIN_LOCATION_LANG_VW MMB,ST_ITEM STI  WHERE SRDE.FACILITY_ID = ? AND MMI.ITEM_CODE=SRDE.ITEM_CODE AND SRDE.STORE_CODE=MMB.STORE_CODE AND MMB.BIN_LOCATION_CODE=SRDE.BIN_LOCATION_CODE AND SRDE.ITEM_CODE=STI.ITEM_CODE AND SDE.DOC_NO=SRDE.SAL_DOC_NO AND SDE.DOC_TYPE_CODE=SRDE.SAL_DOC_TYPE_CODE AND  SDE.BATCH_ID=SRDE.BATCH_ID AND SDE.ITEM_CODE = SRDE.ITEM_CODE AND /* SDE.BIN_LOCATION_CODE=SRDE.BIN_LOCATION_CODE AND */ SDE.EXPIRY_DATE_OR_RECEIPT_DATE=SRDE.EXPIRY_DATE_OR_RECEIPT_DATE AND SRDE.DOC_NO=? AND SRDE.DOC_TYPE_CODE=? AND SRDE.DOC_SRL_NO=? AND  (SDH.DOC_NO=SDE.DOC_NO AND SDH.DOC_TYPE_CODE = SDE.DOC_TYPE_CODE AND SDH.FACILITY_ID = SDE.FACILITY_ID) AND MMI.LANGUAGE_ID = MMB.LANGUAGE_ID AND MMI.LANGUAGE_ID = ? AND SRDE.ITEM_QTY > 0", alParameters);
			//Modified by suresh.r on 14-08-2014 against AAKH-SCF-0129 
			alRecords	=	fetchRecords("SELECT NVL(STI.ALLOW_DECIMALS_YN,'N')ALLOW_DECIMALS_YN, SRDE.ITEM_CODE,MMI.SHORT_DESC ITEM_DESC, SRDE.BATCH_ID, SRDE.BIN_LOCATION_CODE BIN_LOCATION_CODE ,SRDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE,MMB.SHORT_DESC  BIN_DESC,TO_CHAR(SRDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT , SRDE.TRADE_ID,DECODE(STI.TRADE_ID_APPLICABLE_YN,'Y', (SELECT SHORT_NAME FROM AM_TRADE_NAME_LANG_VW AM_TRADE_NAME WHERE TRADE_ID=SRDE.TRADE_ID AND MMI.LANGUAGE_ID = AM_TRADE_NAME.LANGUAGE_ID),SRDE.TRADE_ID) TRADE_NAME,SRDE.ITEM_QTY QTY, /*SDE.SAL_ITEM_QTY*/(SDE.SAL_ITEM_QTY - NVL (SDE.RET_ITEM_QTY, 0)) AVAIL_QTY, SRDE.SAL_DOC_TYPE_CODE,SRDE.SAL_DOC_NO,TO_CHAR(SDH.DOC_DATE,'DD/MM/YYYY') SAL_DOC_DATE,SDE.DOC_SRL_NO SAL_DOC_SRL_NO FROM ST_SAL_RET_DTL_EXP SRDE,ST_SAL_DTL_EXP SDE,ST_SAL_HDR SDH,MM_ITEM_LANG_VW MMI,MM_BIN_LOCATION_LANG_VW MMB,ST_ITEM STI  WHERE SRDE.FACILITY_ID = ? AND MMI.ITEM_CODE=SRDE.ITEM_CODE AND SRDE.STORE_CODE=MMB.STORE_CODE AND MMB.BIN_LOCATION_CODE=SRDE.BIN_LOCATION_CODE AND SRDE.ITEM_CODE=STI.ITEM_CODE AND SDE.DOC_NO=SRDE.SAL_DOC_NO AND SDE.DOC_TYPE_CODE=SRDE.SAL_DOC_TYPE_CODE AND  SDE.BATCH_ID=SRDE.BATCH_ID AND SDE.ITEM_CODE = SRDE.ITEM_CODE AND  SDE.BIN_LOCATION_CODE=SRDE.BIN_LOCATION_CODE AND  SDE.EXPIRY_DATE_OR_RECEIPT_DATE=SRDE.EXPIRY_DATE_OR_RECEIPT_DATE AND SRDE.DOC_NO=? AND SRDE.DOC_TYPE_CODE=? AND SRDE.DOC_SRL_NO=? AND  (SDH.DOC_NO=SDE.DOC_NO AND SDH.DOC_TYPE_CODE = SDE.DOC_TYPE_CODE AND SDH.FACILITY_ID = SDE.FACILITY_ID) AND MMI.LANGUAGE_ID = MMB.LANGUAGE_ID AND MMI.LANGUAGE_ID = ? AND SRDE.ITEM_QTY > 0", alParameters);
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 
			for(int j=0;j<alRecords.size();j++){
			HashMap dataList		=		(HashMap)alRecords.get(j);
		
		
			 double avail_qty = 0;
			 
			 if(((String) dataList.get("ALLOW_DECIMALS_YN")).equals("Y")){
			   
			 avail_qty =  (Double.parseDouble(setNumber(checkForNull((String)dataList.get("AVAIL_QTY"),"0"),no_of_decimals))/getConvFactTemp((String)dataList.get("ITEM_CODE"),getStore_code()))+Double.parseDouble(setNumber(checkForNull((String)dataList.get("QTY"),"0"),no_of_decimals));
			 
			dataList.put("AVAIL_QTY",setNumber(""+avail_qty,no_of_decimals));
			dataList.put("QTY",setNumber((String)dataList.get("QTY"),no_of_decimals));
			}else{
			  
			 avail_qty =  (Double.parseDouble(setNumber(checkForNull((String)dataList.get("AVAIL_QTY"),"0"),no_of_decimals))/getConvFactTemp((String)dataList.get("ITEM_CODE"),getStore_code()))+Double.parseDouble(setNumber(checkForNull((String)dataList.get("QTY"),"0"),no_of_decimals));
			dataList.put("AVAIL_QTY",setNumber(""+avail_qty,0));
			dataList.put("QTY",setNumber((String)dataList.get("QTY"),0));
				}
			alRecords.set(j,dataList);
			}
			
			hmRecord.put("batch_records",""+alRecords.size());
			hmExpRecords.put(""+i,alRecords);

		
			
		}
	}



	public String getAllItem_class_List() {
		ArrayList arr_language=new ArrayList();
			//arr_language.add(bin_code);
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


	public String getBinLocationList(String store_code,String bin_location_code) {
		ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),bin_location_code);
	}


	public HashMap insert(){

// 		HashMap hmResult=new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		//HashMap hmSQLMap1		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();

		HashMap hmCommonData	=	new HashMap();
		ArrayList allanguageData	=	new ArrayList();
		allanguageData.add(getLanguageId());

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);
		int no_of_decimals=getNoOfDecimals();

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getDoc_date());
		alHdrData.add(getDoc_ref());
		alHdrData.add(getStore_code());

		alHdrData.add(getFinalized_yn());
		alHdrData.add("N");//gl_interface
		alHdrData.add("SRT");
		alHdrData.add(getRemarks());
		alHdrData.add(getItem_class_code());
		alHdrData.add(getPatient_id());
		alHdrData.add(getEncounter_id());
		//added on 12/07/2004 
        alHdrData.add(getSal_trn_type());
		alHdrData.add(getBillable_trn_yn());
		alHdrData.add(getSalesDocNo());
		alHdrData.add(getNU_Clinic_code());
		//alHdrData.add(getLoginById());
		

		try {

//			autoGenerateYN = isAutoNo ;
			if (isAutoNo) {
				String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
				setDoc_no(next_doc_no);
			}

		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
   

		try {
//alDtlRecords
			
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			for (int i=0;i<alDtlRecords.size();i++){
//				if (stRecordsToDelete.hasMoreTokens()) {
				String nextToken = stRecordsToDelete.nextToken();
				HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(nextToken.equals("Y")){
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
						for (int j=0;j<sourceArrayList.size(); j++ ){
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							alExpData.add(hmExpRecord);
						}
				}
				/** @ no_of_decimals=3, decimal_allowedYN=Y

				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications begain 

				**/
				
				
				if(getAllowDecimalsYN((String)hmDtlRecord.get("item_code")).equals("Y")){
				double mm_trn_qty = ((Double.parseDouble(setNumber((String)hmDtlRecord.get("item_qty"),no_of_decimals)))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",""+setNumber(""+mm_trn_qty,no_of_decimals));
				}else{
				double mm_trn_qty = ((Double.parseDouble(setNumber((String)hmDtlRecord.get("item_qty"),0)))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",""+setNumber(""+mm_trn_qty,0));
				
				}

				
				alDtlData.add(hmDtlRecord);
			
			}
			 String sql_multi_user_chk = "Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
			ArrayList temp;
			for(int i=0;i<alExpData.size();i++){
			HashMap hmExpRecord	=	(HashMap)alExpData.get(i);
			temp=new ArrayList();
			temp.add(getStore_code()); //curr_store_code
			temp.add((String)hmExpRecord.get("ITEM_CODE"));	// ITEM_CODE
			temp.add((String)hmExpRecord.get("BATCH_ID"));  //BATCH_ID
			temp.add((String)hmExpRecord.get("BIN_LOCATION_CODE")); //BIN_LOCATION_CODE
			temp.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));	//EXPIRY_DATE
			hmExpRecord.put("modified_date",(String)((HashMap)fetchRecord(sql_multi_user_chk,temp)).get("MODIFIED_DATE"));
			alExpData.set(i,hmExpRecord);
			}
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
		if((getItemClassBased("SRT").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"SRT");
		}
		return  salesReturnMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap delete() {
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

		return salesReturnMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}



public HashMap modify()	{

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
		int no_of_decimals=getNoOfDecimals();
		allanguageData.add(getLanguageId());

		hmCommonData.put("login_by_id",getLoginById());
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo());
		hmCommonData.put("login_facility_id",getLoginFacilityId());

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getDoc_date());
		alHdrData.add(getDoc_ref());
		alHdrData.add(getStore_code());

		alHdrData.add(getFinalized_yn());
		alHdrData.add("N");//gl_interface
		alHdrData.add("SRT");
		alHdrData.add(getRemarks());
		alHdrData.add(getItem_class_code());
		alHdrData.add(getPatient_id());
		alHdrData.add(getEncounter_id());
        alHdrData.add(getSal_trn_type());
		alHdrData.add(getBillable_trn_yn());
		alHdrData.add(getSalesDocNo());

		try {

//alDtlRecords
			StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			for (int i=0;i<alDtlRecords.size();i++) {
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
					for (int j=0;j<sourceArrayList.size(); j++ ){
						HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						hmExpRecord.put("store_code",getStore_code());
						alExpData.add(hmExpRecord);
					}
				}
			/** @ no_of_decimals=3, decimal_allowedYN=Y

				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications begain 

				**/
				//if(checkForNull((String)hmDtlRecord.get("decimal_allowedYN"),"N").equals("Y")){
				if(getAllowDecimalsYN((String)hmDtlRecord.get("item_code")).equals("Y")){
				double mm_trn_qty = ((Double.parseDouble(setNumber((String)hmDtlRecord.get("item_qty"),no_of_decimals)))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,no_of_decimals));
				}else{
			double mm_trn_qty = ((Double.parseDouble(setNumber((String)hmDtlRecord.get("item_qty"),0)))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,0));
				}
				
				/** Before modification

				int mm_trn_qty = ((Integer.parseInt((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getStore_code())));
				hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
			
				**/
				alDtlData.add(hmDtlRecord);

			}
			 String sql_multi_user_chk = "Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
		
			ArrayList temp;
			for(int i=0;i<alExpData.size();i++){
			HashMap hmExpRecord	=	(HashMap)alExpData.get(i);
			temp=new ArrayList();
			temp.add(getStore_code()); //curr_store_code
			temp.add((String)hmExpRecord.get("ITEM_CODE"));	// ITEM_CODE
			temp.add((String)hmExpRecord.get("BATCH_ID"));  //BATCH_ID
			temp.add((String)hmExpRecord.get("BIN_LOCATION_CODE")); //BIN_LOCATION_CODE
			temp.add((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"));	//EXPIRY_DATE
			hmExpRecord.put("modified_date",(String)((HashMap)fetchRecord(sql_multi_user_chk,temp)).get("MODIFIED_DATE"));
			alExpData.set(i,hmExpRecord);
			}
        
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
		return salesReturnMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}


	public HashMap salesReturnMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
/*
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {

			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = new eST.SalesReturn12.SalesReturnManager().insert( hmTableData, hmSQLMap ) ;
					if(autoGenerateYN)
   		              hmResult.put("flag", "Doc No: "+ getDoc_no()) ;
					break;
				
				case FUNCTION_UPDATE:
					hmResult = new eST.SalesReturn12.SalesReturnManager().modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					hmResult = new eST.SalesReturn12.SalesReturnManager().delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to salesReturnMethodCall()") ;
			}

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

		}
		catch(Exception exception) {
			hmResult.put( "message", "" + exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		return hmResult;

        */

		HashMap		hmResult	=	new HashMap()	;

//		eST.SalesReturn.SalesReturnHome		salesReturnHome		= null ;
		eST.SalesReturn.SalesReturnRemote	salesReturnRemote	= null ;

		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			/*InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_SALES_RETURN") ) ;

			salesReturnHome  = (eST.SalesReturn.SalesReturnHome) PortableRemoteObject.narrow( object, eST.SalesReturn.SalesReturnHome.class ) ;
			salesReturnRemote = salesReturnHome.create() ;*/


			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( getStRepositoryValue("JNDI_ST_SALES_RETURN"),eST.SalesReturn.SalesReturnHome.class,getLocalEJB());
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
					//hmResult = salesReturnRemote.insert( hmTableData, hmSQLMap ) ;
					  setbill_data(hmResult);
					break;

				case FUNCTION_UPDATE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = salesReturnRemote.modify( hmTableData, hmSQLMap ) ;
					  setbill_data(hmResult);
					break;

				case FUNCTION_DELETE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				//	hmResult = salesReturnRemote.delete( hmTableData, hmSQLMap ) ;
					break;

				default:
					hmResult.put( "message", "Invalid Function ID passed to salesReturnMethodCall()") ;
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if(((Boolean) hmResult.get("result")).booleanValue())	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
	
/* SEND TO PRINT ONLINE REPORT STARTS 9/28/2004 */		

	        ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getStore_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBSALDC";
			if (finalized_yn.substring(0,1).equals("Y") && hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()) ||(finalized_yn.substring(0,1).equals("N") && getCustomerID().equals("MC")) )
			//if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{				
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}else{

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
			System.out.println("SalesReturnBeans, exception.getMessage() = > "+exception.getMessage());
			System.out.println("SalesReturnBeans, hmTableData = > "+hmTableData);
			//hmResult.put( "message", "Bean : "+exception.getMessage()) ;
			if((exception.getMessage()).contains("BL9146"))//Added for MMS-DM-CRF-192.2 in 03/03/2016 B.Badmavathi Introduced for supporting Billing module for Exception
				hmResult.put( "message", (String)hmResult.get("message")) ;
			else if((exception.getMessage()).contains(": BL"))
				hmResult.put("message",(((String)hmResult.get("msgid")).substring(((String) hmResult.get( "msgid" )).indexOf(":"))+1).replaceFirst(":",""));
				//hmResult.put("message",(String) hmResult.get( "msgid" ));
			else if((exception.getMessage()).contains("Return Qty Cannot be Greater than Dispense Qty"))
				hmResult.put( "message", "Return Qty Cannot be Greater than Sale Qty ") ;
			else
	//			hmResult.put( "message", "Transaction Failed") ;
				hmResult.put( "message", (String)hmResult.get("message")) ;
				exception.printStackTrace() ;
		} 
		finally {
			try {
				if( salesReturnRemote != null )
					salesReturnRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean : "+exception.toString()) ;
			}
		}
/* 9/28/2004 if (finalized_yn.equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			 if (isInternalRequest("ST","STBSRTDC")) {
				String doc_no	=	(String)hmResult.get("doc_no");	
				doOnlineReportPrinting(doc_no);				
			}
		}*/
		return hmResult;

		
	}
	/*
	public void doOnlineReportPrinting(String doc_no) {
				System.out.println("Inside doOnlineReportPrinting() ");
		try{
			String reportid = "STBSRTDC";
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
     //       javax.servlet.http.HttpSession session = request.getSession(false);
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
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBSRTDC";
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
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
/*added doc_date for GHL-SCF-1337, modified for GHL-CRF-0557*/
public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,String item_qty,String batch_str, String doc_date, String sales_doc_no,String sales_doc_srl_no,String sales_doc_typeCode)throws Exception{
		DecimalFormat dfTest = new DecimalFormat("##.00");
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap();
		try{
			item_qty = "-" + item_qty; //MODIFIED FOR GHL-CRF-0557
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "ST");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, doc_date);//added doc_date for GHL-SCF-1337
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, getStore_code());
			/** @ no_of_decimals=3, decimal_allowedYN=Y

				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications begain 

			**/
			
			String allow_decimals_yn=getAllowDecimalsYN(item_code);
			int no_of_decimals=getNoOfDecimals();
			if(allow_decimals_yn.equals("Y")){
			callableStatement.setDouble(9, Double.parseDouble(setNumber(item_qty,no_of_decimals)));
			}else{
			callableStatement.setInt(9, new Double(Double.parseDouble(item_qty)).intValue());
			}
			/** @ no_of_decimals=3, decimal_allowedYN=Y
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end 
			**/

			/** @ before modification 

			callableStatement.setInt(9, Integer.parseInt(item_qty));

			**/
			
			callableStatement.setString(10, batch_str);
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
			callableStatement.setString(42, sales_doc_typeCode);//modified for GHL-CRF-0557
			callableStatement.setString(43, sales_doc_no);//modified for GHL-CRF-0557
			callableStatement.setString(44, sales_doc_srl_no);//modified for GHL-CRF-0557
			callableStatement.setString(45, "N"); //p_discharge_ind
			callableStatement.registerOutParameter(46, Types.VARCHAR); //p_drug_penalty_str Changes done for JD-CRF-0170

			callableStatement.execute();
			/*System.out.println("login_facility_id = > "+login_facility_id);
			System.out.println("patient_id = > "+patient_id);
			System.out.println("encounter_id = > "+encounter_id);
			System.out.println("sal_trn_type = > "+sal_trn_type);
			System.out.println("getDoc_date = > "+getDoc_date());
			System.out.println("item_code = > "+item_code);
			System.out.println("getStore_code = > "+getStore_code());
			System.out.println("Double.parseDouble(setNumber(item_qty,no_of_decimals)) = > "+Double.parseDouble(setNumber(item_qty,no_of_decimals)));
			System.out.println("new Double(Double.parseDouble(item_qty)).intValue() = > "+new Double(Double.parseDouble(item_qty)).intValue());*/
			/*System.out.println("callableStatement.getString(1) = > "+callableStatement.getString(1));
			System.out.println("callableStatement.getString(2) = > "+callableStatement.getString(2));
			System.out.println("callableStatement.getString(3) = > "+callableStatement.getString(3));
			System.out.println("callableStatement.getString(4) = > "+callableStatement.getString(4));
			System.out.println("callableStatement.getString(5) = > "+callableStatement.getString(5));
			System.out.println("callableStatement.getString(6) = > "+callableStatement.getString(6));
			System.out.println("callableStatement.getString(7) = > "+callableStatement.getString(7));
			System.out.println("callableStatement.getString(8) = > "+callableStatement.getString(8));
			System.out.println("callableStatement.getString(9) = > "+callableStatement.getString(9));
			System.out.println("callableStatement.getString(10) = > "+batch_str);*/
			/*System.out.println("callableStatement.getString(11) = > "+callableStatement.getString(11));
			System.out.println("callableStatement.getString(12) = > "+callableStatement.getString(12));
			System.out.println("callableStatement.getString(13) = > "+callableStatement.getString(13));
			System.out.println("callableStatement.getString(14) = > "+callableStatement.getString(14));
			System.out.println("callableStatement.getString(15) = > "+callableStatement.getString(15));
			System.out.println("callableStatement.getString(16) = > "+callableStatement.getString(16));
			System.out.println("callableStatement.getString(17) = > "+callableStatement.getString(17));
			System.out.println("callableStatement.getString(18) = > "+callableStatement.getString(18));
			System.out.println("callableStatement.getString(19) = > "+callableStatement.getString(19));
			System.out.println("callableStatement.getString(20) = > "+callableStatement.getString(20));
			System.out.println("callableStatement.getString(21) = > "+callableStatement.getString(21));
			System.out.println("callableStatement.getString(22) = > "+callableStatement.getString(22));
			System.out.println("callableStatement.getString(23) = > "+callableStatement.getString(23));
			System.out.println("callableStatement.getString(24) = > "+callableStatement.getString(24));
			System.out.println("callableStatement.getString(25) = > "+callableStatement.getString(25));
			System.out.println("callableStatement.getString(26) = > "+callableStatement.getString(26));
			System.out.println("callableStatement.getString(27) = > "+callableStatement.getString(27));
			System.out.println("callableStatement.getString(28) = > "+callableStatement.getString(28));
			System.out.println("callableStatement.getString(29) = > "+callableStatement.getString(29));
			System.out.println("callableStatement.getString(30) = > "+callableStatement.getString(30));
			System.out.println("callableStatement.getString(31) = > "+callableStatement.getString(31));
			System.out.println("callableStatement.getString(32) = > "+callableStatement.getString(32));
			System.out.println("callableStatement.getString(33) = > "+callableStatement.getString(33));
			System.out.println("callableStatement.getString(34) = > "+callableStatement.getString(34));
			System.out.println("callableStatement.getString(35) = > "+callableStatement.getString(35));
			System.out.println("callableStatement.getString(36) = > "+callableStatement.getString(36));
			System.out.println("callableStatement.getString(37) = > "+callableStatement.getString(37));
			System.out.println("callableStatement.getString(38) = > "+callableStatement.getString(38));*/



			
			message.put("daytypecode" , checkForNull((String)callableStatement.getString(11)));
			message.put("daytypedesc" , checkForNull((String)callableStatement.getString(12)));
			message.put("timetypecode" , checkForNull((String)callableStatement.getString(13)));
			message.put("timetypedesc" , checkForNull((String)callableStatement.getString(14)));
			message.put("baseqty" , callableStatement.getFloat(15)+"");
			
			message.put("baserate" , callableStatement.getString(16)+"");
			message.put("addlfactor" ,callableStatement.getString(17)+"");
			message.put("p_base_charge_amt" , callableStatement.getString(18)+"");
			message.put("grosschargeamt" , dfTest.format(Double.parseDouble(callableStatement.getString(19)+"")));
			
			message.put("discountamt" , callableStatement.getString(20)+"");
			message.put("netchargeamt" , dfTest.format(Double.parseDouble(callableStatement.getString(21)+"")));
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

/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "STBSRTDC";
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
            //HashMap hashmap = fetchRecord("SELECT	PATIENT_ID FROM ST_DIR_SALE_PATIENT_PARAM WHERE PATIENT_ID =	UPPER(?) AND EFF_STATUS = 'E'", patient_id);
            return (String)hashmap.get("PATIENT_ID");
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }
	/*The getSalesDocNoArrayList() was updated By Dinesh T => added a parameter itemToFilter, as well as added a filter criteria ITEM_CODE LIKE, starts*/
	public ArrayList getSalesDocNoArrayList(String patient_id,String encounter,String sal_trn_type,String sales_doc_type,String itemToFilter) throws Exception{ 
		String stParameters[]={patient_id,getLoginFacilityId(),encounter,sal_trn_type,getStore_code(),sales_doc_type,itemToFilter};
		return fetchRecords("SELECT HDR.DOC_NO SALES_DOC_NO FROM ST_SAL_HDR HDR, ST_SAL_DTL_EXP DTLEXP WHERE HDR.PATIENT_ID = ? AND HDR.FACILITY_ID = ?  AND NVL(HDR.ENCOUNTER_ID,1) = NVL(?,NVL(HDR.ENCOUNTER_ID,1)) AND HDR.SAL_TRN_TYPE = ? AND HDR.STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND SAL_TRN_TYPE != 'C' AND  HDR.DOC_TYPE_CODE = DTLEXP.DOC_TYPE_CODE AND  HDR.DOC_NO = DTLEXP.DOC_NO AND MODULE_ID = 'ST'  AND HDR.DOC_TYPE_CODE=? AND ITEM_CODE LIKE ? HAVING SUM(SAL_ITEM_QTY- NVL(RET_ITEM_QTY,0))>0 GROUP BY HDR.DOC_NO ORDER BY HDR.DOC_NO",stParameters);
		//return fetchRecords(getStRepositoryValue("ST_SQL_SALES_DOC_NO_SELECT"),stParameters);
	}
	/*The getSalesDocNoArrayList() was updated By Dinesh T, ends*/

	public ArrayList getSalesDocTypeArrayList(String[] stParameters) throws Exception{ 
		//String stParameters[]={getLanguageId(),patient_id,itemCode};
		//stParameters[5] = getLanguageId();
		//return fetchRecords("SELECT DISTINCT A.DOC_TYPE_CODE || '!~!' || B.SHORT_DESC DOC_TYPE FROM ST_SAL_HDR A, SY_DOC_TYPE_MASTER_LANG_VW B, ST_SAL_DTL C WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.DOC_NO = C.DOC_NO AND A.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID = ? AND MODULE_ID = 'ST' AND PATIENT_ID = ? AND C.ITEM_CODE LIKE ?",stParameters);
		//return fetchRecords(getStRepositoryValue("ST_SQL_SALES_DOC_NO_SELECT"),stParameters);
		          
		return fetchRecords("SELECT HDR.DOC_TYPE_CODE|| '!~!' ||SYDOC.SHORT_DESC DOC_TYPE FROM ST_SAL_HDR HDR, ST_SAL_DTL_EXP DTLEXP, SY_DOC_TYPE_MASTER_LANG_VW SYDOC WHERE HDR.PATIENT_ID = ? AND HDR.FACILITY_ID = ? AND NVL (HDR.ENCOUNTER_ID, 1) = NVL ('', NVL (HDR.ENCOUNTER_ID, 1)) AND HDR.SAL_TRN_TYPE = ? AND HDR.STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y'AND SAL_TRN_TYPE != 'C'   AND HDR.DOC_TYPE_CODE = DTLEXP.DOC_TYPE_CODE AND HDR.DOC_NO = DTLEXP.DOC_NO AND MODULE_ID = 'ST' AND ITEM_CODE LIKE ? AND SYDOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND SYDOC.LANGUAGE_ID = ? HAVING SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) > 0 GROUP BY HDR.DOC_TYPE_CODE, SYDOC.SHORT_DESC ORDER BY HDR.DOC_TYPE_CODE",stParameters);
	}

	public String getSalesDocNo_List(){
		String stParameters[]={getPatient_id(),getLoginFacilityId(),checkForNull(getEncounter_id(),""),getSal_trn_type(),getStore_code()};
		return getListOptionTag(getListOptionArrayList("SELECT HDR.DOC_NO DOC_NO,HDR.DOC_NO ItIsToPopulateListBox FROM ST_SAL_HDR HDR, ST_SAL_DTL_EXP DTLEXP WHERE HDR.PATIENT_ID = ? AND HDR.FACILITY_ID = ?  AND NVL(HDR.ENCOUNTER_ID,1) = NVL(?,NVL(HDR.ENCOUNTER_ID,1)) AND HDR.SAL_TRN_TYPE = ? AND HDR.STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND SAL_TRN_TYPE != 'C' AND  HDR.DOC_TYPE_CODE = DTLEXP.DOC_TYPE_CODE AND  HDR.DOC_NO = DTLEXP.DOC_NO AND MODULE_ID = 'ST' GROUP BY HDR.DOC_NO ORDER BY HDR.DOC_NO",stParameters),getSalesDocNo());
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("ST_SQL_SALES_DOC_NO_SELECT1"),stParameters),getSalesDocNo());
	}

	public void loadDocNoData(String doc_no,String sales_doc_type) throws Exception{
		try{
			String sal_trn_type = "";
			alDtlRecords	= new ArrayList();
			hmExpRecords	= new HashMap();
			HashMap hmRecord = new HashMap();
			ArrayList alParameters = new ArrayList();
			alParameters.add(getLanguageId());
			alParameters.add(sales_doc_type);
			alParameters.add(doc_no);
			alParameters.add(getLanguageId());
			alParameters.add(doc_no);
			alParameters.add(sales_doc_type);
			String bill_yn = (String)getBLModuleInstalled();

			
			 
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 
				int no_of_decimals=getNoOfDecimals();
				
	
			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end 
		
			*/ 

			//ArrayList alRecords	=	fetchRecords(getStRepositoryValue("ST_SQL_SAL_RET_DOC_NO_SELECT_MULTIPLE"), alParameters);
			//ArrayList alRecords	=	fetchRecords("SELECT DISTINCT nvl(ST.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN, SH.DOC_NO SALES_DOC_NO,SD.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,SH.PATIENT_ID, SH.ENCOUNTER_ID, SH.SAL_TRN_TYPE,NVL(SH.PATIENT_NAME,MP.PATIENT_NAME) PATIENT_NAME, SH.STORE_CODE, SD.ITEM_CODE,SD.STOCK_ITEM_YN, SD.ITEM_QTY, SD.DOC_SRL_NO,SD.DOC_SRL_NO SAL_DOC_SRL_NO,MM.SHORT_DESC ITEM_DESC, ST.EXPIRY_YN, SD.GROSS_CHARGE_AMT,SD.PAT_NET_AMT, SD.ITEM_UNIT_COST, SD.ITEM_COST_VALUE,STITM.DEF_ISSUE_UOM UOM_CODE, AM.SHORT_DESC UOM_DESC,SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) STOCK_AVAILABLE FROM ST_SAL_HDR SH,ST_SAL_DTL SD,MM_ITEM_LANG_VW MM, ST_ITEM ST,ST_ITEM_STORE STITM,AM_UOM_LANG_VW AM,ST_SAL_DTL_EXP STEXP,MP_PATIENT MP WHERE MM.ITEM_CODE = SD.ITEM_CODE AND ST.ITEM_CODE = MM.ITEM_CODE AND SH.DOC_NO = SD.DOC_NO AND SH.DOC_TYPE_CODE = SD.DOC_TYPE_CODE AND STITM.ITEM_CODE = SD.ITEM_CODE AND STITM.STORE_CODE = SH.STORE_CODE AND AM.UOM_CODE = STITM.DEF_ISSUE_UOM AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND SH.DOC_NO = ? AND MM.LANGUAGE_ID = ? AND SH.DOC_TYPE_CODE = (SELECT DOC_TYPE_CODE FROM ST_SAL_HDR WHERE MODULE_ID = ? AND DOC_NO = ?) AND SD.DOC_NO = STEXP.DOC_NO AND SD.DOC_TYPE_CODE = STEXP.DOC_TYPE_CODE AND SD.DOC_SRL_NO = STEXP.DOC_SRL_NO AND SH.PATIENT_ID = MP.PATIENT_ID GROUP BY SH.STORE_CODE,SH.ENCOUNTER_ID,SD.ITEM_CODE,SD.STOCK_ITEM_YN,SD.ITEM_QTY,MM.SHORT_DESC,ST.EXPIRY_YN,SD.GROSS_CHARGE_AMT,SD.PAT_NET_AMT,STITM.DEF_ISSUE_UOM,AM.SHORT_DESC,SD.ITEM_UNIT_COST,SH.PATIENT_NAME,SD.ITEM_COST_VALUE,SD.DOC_SRL_NO,SH.PATIENT_ID,SH.ENCOUNTER_ID,SH.SAL_TRN_TYPE,SH.DOC_NO,SD.DOC_TYPE_CODE,MP.PATIENT_NAME,ALLOW_DECIMALS_YN", alParameters);
			ArrayList alRecords	=	fetchRecords("SELECT NVL (ST.ALLOW_DECIMALS_YN, 'N') ALLOW_DECIMALS_YN, sh.DOC_DATE ,ST.RETURN_ALLOWED_YN RETURN_ALLOWED_YN,SH.DOC_NO SALES_DOC_NO, to_char(sh.DOC_DATE,'DD/MM/YYYY') as SAL_DOC_DATE , SD.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,SH.PATIENT_ID, SH.ENCOUNTER_ID, SH.SAL_TRN_TYPE,NVL (SH.PATIENT_NAME,(SELECT MP.PATIENT_NAME FROM MP_PATIENT MP WHERE MP.PATIENT_ID = SH.PATIENT_ID)) PATIENT_NAME,SH.STORE_CODE, SD.ITEM_CODE, SD.STOCK_ITEM_YN, SD.ITEM_QTY,SD.DOC_SRL_NO, SD.DOC_SRL_NO SAL_DOC_SRL_NO,(SELECT MM.SHORT_DESC FROM MM_ITEM_LANG_VW MM WHERE MM.ITEM_CODE = SD.ITEM_CODE AND LANGUAGE_ID = ?) ITEM_DESC, ST.EXPIRY_YN, SD.GROSS_CHARGE_AMT, SD.PAT_NET_AMT, SD.ITEM_UNIT_COST,SD.ITEM_COST_VALUE, STITM.DEF_ISSUE_UOM UOM_CODE,AM.SHORT_DESC UOM_DESC,(SELECT SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) FROM ST_SAL_DTL_EXP STEXP WHERE STEXP.FACILITY_ID = SD.FACILITY_ID AND STEXP.DOC_TYPE_CODE = SD.DOC_TYPE_CODE AND STEXP.DOC_NO = SD.DOC_NO AND STEXP.DOC_SRL_NO = SD.DOC_SRL_NO) STOCK_AVAILABLE,(SELECT MM.BILLABLE_ITEM_YN FROM MM_ITEM MM WHERE MM.ITEM_CODE = SD.ITEM_CODE ) BILLABLE_ITEM_YN FROM ST_SAL_HDR SH, ST_SAL_DTL SD, ST_ITEM ST, ST_ITEM_STORE STITM, AM_UOM_LANG_VW AM WHERE SH.DOC_TYPE_CODE=? AND ST.ITEM_CODE = SD.ITEM_CODE AND SH.DOC_NO = SD.DOC_NO AND SH.DOC_TYPE_CODE = SD.DOC_TYPE_CODE AND STITM.ITEM_CODE = SD.ITEM_CODE AND STITM.STORE_CODE = SH.STORE_CODE AND AM.UOM_CODE = STITM.DEF_ISSUE_UOM AND SH.DOC_NO = ? AND AM.LANGUAGE_ID = ?  AND SH.DOC_TYPE_CODE = (SELECT DOC_TYPE_CODE FROM ST_SAL_HDR WHERE MODULE_ID = 'ST' AND DOC_NO = ? AND DOC_TYPE_CODE=? )", alParameters);

			for (int i=0; i<alRecords.size(); i++) {
				hmRecord	=	(HashMap)alRecords.get(i);
				HashMap hmTemp			=	new HashMap();
				HashMap hmChargeDtls	=	new HashMap();
				ArrayList alParameters_bat_str = new ArrayList();
				StringBuffer sb_batch_data     = new StringBuffer();
				HashMap hmRecord_batch_str	=	new HashMap();

				
				hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
				hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
				hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
				hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
				hmTemp.put("item_unit_cost",hmRecord.get("ITEM_UNIT_COST"));
				//hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
				hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS")));
				hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
				hmTemp.put("return_allowed_yn",hmRecord.get("RETURN_ALLOWED_YN"));

/*======code added for passing batch string================================*/
					 if(bill_yn.equals("Y")&& checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N").equals("Y")){
						 alParameters_bat_str.add(doc_no);
						 alParameters_bat_str.add(sales_doc_type);
						 alParameters_bat_str.add(hmRecord.get("DOC_SRL_NO"));
						// ArrayList alRecords_batch_str	=	fetchRecords("select TRADE_ID,BATCH_ID,to_char(EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy')EXPIRY_DATE_OR_RECEIPT_DATE,BIN_LOCATION_CODE ,SAL_ITEM_QTY from st_sal_dtl_exp where doc_no =? and doc_type_code =? and doc_srl_no =?", alParameters_bat_str);
		                //	 modified by gangadharan due to reduce the return qty
						 ArrayList alRecords_batch_str	=	fetchRecords("select TRADE_ID,BATCH_ID,to_char(EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy')EXPIRY_DATE_OR_RECEIPT_DATE,BIN_LOCATION_CODE ,(nvl(sal_item_qty,0)-nvl(ret_item_qty,0)) SAL_ITEM_QTY from st_sal_dtl_exp where doc_no =? and doc_type_code =? and doc_srl_no =?", alParameters_bat_str);				
						 
						   for(int m=0;m<alRecords_batch_str.size();m=m+1){

								hmRecord_batch_str = (HashMap)alRecords_batch_str.get(m);
								sb_batch_data.append(hmRecord_batch_str.get("TRADE_ID"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("BATCH_ID"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("BIN_LOCATION_CODE"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("SAL_ITEM_QTY"));					
								sb_batch_data.append(";");
						   }
					 }
/*====ends here=============*/


				/** @ 
				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
				*/ 
				hmTemp.put("no_of_decimals",""+no_of_decimals);
				hmTemp.put("decimal_allowedYN",hmRecord.get("ALLOW_DECIMALS_YN"));
				//hmTemp.put("decimal_allowedYN",getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")));
				
				double stock_available=0;
				if( ((String)hmRecord.get("ALLOW_DECIMALS_YN")).equals("Y")){
				 stock_available = Double.parseDouble(setNumber((String)hmRecord.get("STOCK_AVAILABLE"),no_of_decimals))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("STORE_CODE"));
				 hmTemp.put("stock_available",setNumber(""+stock_available,no_of_decimals));
				 hmTemp.put("item_qty",setNumber(""+stock_available,no_of_decimals));
				}else{
				 stock_available = Double.parseDouble((String)hmRecord.get("STOCK_AVAILABLE"))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("STORE_CODE"));
				 hmTemp.put("stock_available",setNumber(""+stock_available,0));
				 hmTemp.put("item_qty",setNumber(""+stock_available,0));
					}
				/** @ 
				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications end 
				*/ 

				/** @ 
				orginal code

				hmTemp.put("stock_available",""+stock_available);
				hmTemp.put("item_qty",""+stock_available);
			
				*/ 

				hmTemp.put("stock_item_yn",hmRecord.get("STOCK_ITEM_YN"));
				hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
				hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
				hmTemp.put("store_code",hmRecord.get("STORE_CODE"));
				hmTemp.put("patient_name",hmRecord.get("PATIENT_NAME"));
				hmTemp.put("sal_doc_srl_no",hmRecord.get("SAL_DOC_SRL_NO"));
				hmTemp.put("sales_doc_type_code",hmRecord.get("SALES_DOC_TYPE_CODE"));
				hmTemp.put("sales_doc_no",hmRecord.get("SALES_DOC_NO"));
				hmTemp.put("billable_item_yn",checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N"));
				setSalesDocNo(checkForNull((String)hmRecord.get("SALES_DOC_NO")));
				setSalesDocTypeCode(checkForNull((String)hmRecord.get("SALES_DOC_TYPE_CODE")));
				setStore_code((String)hmRecord.get("STORE_CODE"));
				setSales_doc_date(checkForNull((String)hmRecord.get("SAL_DOC_DATE")));//added for ghl-scf-1337
				
				if(((String)hmRecord.get("SAL_TRN_TYPE")).equals("X"))
					sal_trn_type = "R";
				else
					sal_trn_type = (String)hmRecord.get("SAL_TRN_TYPE");

				if(bill_yn.equals("Y")&& checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N").equals("Y")){
					hmChargeDtls	= callItemChargeDtls((String)hmRecord.get("PATIENT_ID"),checkForNull((String)hmRecord.get("ENCOUNTER_ID")),checkForNull(sal_trn_type,"I"),(String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("STOCK_AVAILABLE"),sb_batch_data.toString(),checkForNull((String)hmRecord.get("SAL_DOC_DATE")),null,null,null);//MODIFIED for GHL-SCF-1337 , modified for GHL-CRF-0557

					hmTemp.put("pat_net_amt",""+hmChargeDtls.get("grosschargeamt"));
					hmTemp.put("gross_charge_amt",""+hmChargeDtls.get("netchargeamt"));
				}else{
					hmTemp.put("pat_net_amt","0");
					hmTemp.put("gross_charge_amt","0");
				}
				alDtlRecords.add(hmTemp);
			}

			alParameters.clear();
			alParameters.add(getLoginFacilityId());
			alParameters.add("ST");
			alParameters.add(doc_no);
			alParameters.add(sales_doc_type);
			alParameters.add(doc_no);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add("");
			for (int i=0; i<alDtlRecords.size(); i++) {
				hmRecord	=	(HashMap)alDtlRecords.get(i);
				alParameters.set(8,(String)hmRecord.get("doc_srl_no"));
				alParameters.set(11,(String)hmRecord.get("item_code"));
				//alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_SAL_DTL_EXP_SELECT_MULTIPLE"),alParameters);
				//alRecords	=	fetchRecords(getStRepositoryValue("ST_SQL_SAL_RET_DOC_NO_EXP_SELECT"),alParameters);
				//alRecords	=	fetchRecords("SELECT BATCHVIEW.TRADE_ID, BATCHVIEW.QTY_ON_HAND, BATCHVIEW.USE_AFTER_EXPIRY_YN,	BATCHVIEW.EXPIRY_YN EXPIRY_YN, STEXP.SAL_ITEM_QTY AVAIL_QTY, BATCHVIEW.TRADE_ID_APPLICABLE_YN,	BATCHVIEW.MANUFACTURER_ID, (STEXP.SAL_ITEM_QTY-NVL(STEXP.RET_ITEM_QTY,0)) QTY, BATCHVIEW.STORE_DESC, BATCHVIEW.TRADE_NAME, BATCHVIEW.NOD NOD, BATCHVIEW.ITEM_DESC, BATCHVIEW.MANUFACTURER_NAME,	 BATCHVIEW.STORE_CODE, BATCHVIEW.SUSPENDED_YN, BATCHVIEW.ITEM_CODE,	BATCHVIEW.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE,STEXP.BIN_LOCATION_CODE, TO_CHAR(BATCHVIEW.EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT, BATCHVIEW.BIN_DESC, BATCHVIEW.BATCH_ID,BATCHVIEW.BATCH_STATUS BATCH_STATUS,STEXP.DOC_TYPE_CODE SAL_DOC_TYPE_CODE,STEXP.DOC_NO SAL_DOC_NO FROM ST_BATCH_SEARCH_LANG_VIEW BATCHVIEW, ST_SAL_DTL_EXP STEXP WHERE BATCHVIEW.STORE_CODE=STEXP.STORE_CODE AND BATCHVIEW.ITEM_CODE=STEXP.ITEM_CODE AND BATCHVIEW.BATCH_ID=STEXP.BATCH_ID AND BATCHVIEW.BIN_LOCATION_CODE=STEXP.BIN_LOCATION_CODE AND BATCHVIEW.EXPIRY_DATE=STEXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STEXP.FACILITY_ID=? AND STEXP.DOC_TYPE_CODE=(SELECT DOC_TYPE_CODE FROM ST_SAL_HDR WHERE MODULE_ID = ? AND DOC_NO = ?) AND STEXP.DOC_NO=? AND BATCHVIEW.LANGUAGE_ID = ? AND BATCHVIEW.LANG1 = ? AND BATCHVIEW.LANG2 = ? AND STEXP.DOC_SRL_NO=?",alParameters);
				alRecords	=	fetchRecords("SELECT DISTINCT STEXP.TRADE_ID,BATCHVIEW.QTY_ON_HAND,STITM.USE_AFTER_EXPIRY_YN, STITM.EXPIRY_YN EXPIRY_YN,/*STEXP.SAL_ITEM_QTY*/(STEXP.SAL_ITEM_QTY - NVL (STEXP.RET_ITEM_QTY, 0)) AVAIL_QTY, STITM.TRADE_ID_APPLICABLE_YN,MMITM.MANUFACTURER_ID,(STEXP.SAL_ITEM_QTY - NVL (STEXP.RET_ITEM_QTY, 0)) QTY,MMSTR.SHORT_DESC STORE_DESC, NVL(AMTRD.SHORT_NAME,STEXP.TRADE_ID) TRADE_NAME, TRUNC (STEXP.EXPIRY_DATE_OR_RECEIPT_DATE - SYSDATE) + 1 NOD,MMITM.SHORT_DESC ITEM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW AMMAN WHERE AMMAN.MANUFACTURER_ID = MMITM.MANUFACTURER_ID AND AMMAN.LANGUAGE_ID = MMITM.LANGUAGE_ID) MANUFACTURER_NAME,  STEXP.STORE_CODE, BATCHVIEW.SUSPENDED_YN,STEXP.ITEM_CODE,STEXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE,STEXP.BIN_LOCATION_CODE,TO_CHAR (STEXP.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,  MMBIN.SHORT_DESC BIN_DESC,STEXP.BATCH_ID, /*NVL(BATCHUPD.NEW_BATCH_STATUS,'A') BATCH_STATUS,*/ STEXP.DOC_TYPE_CODE SAL_DOC_TYPE_CODE, STEXP.DOC_NO SAL_DOC_NO  FROM ST_BATCH_SEARCH_LANG_VIEW BATCHVIEW, ST_SAL_DTL_EXP STEXP,ST_ITEM STITM, MM_ITEM_LANG_VW MMITM, MM_STORE_LANG_VW MMSTR,AM_TRADE_NAME_LANG_VW AMTRD,MM_BIN_LOCATION_LANG_VW MMBIN,ST_BATCH_STATUS_UPD_HISTORY BATCHUPD WHERE BATCHVIEW.STORE_CODE(+) = STEXP.STORE_CODE AND BATCHVIEW.ITEM_CODE(+) = STEXP.ITEM_CODE AND BATCHVIEW.BATCH_ID(+) = STEXP.BATCH_ID AND BATCHVIEW.BIN_LOCATION_CODE(+) = STEXP.BIN_LOCATION_CODE AND BATCHVIEW.EXPIRY_DATE(+) = STEXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STEXP.FACILITY_ID = ? AND STEXP.DOC_TYPE_CODE = (SELECT DOC_TYPE_CODE FROM ST_SAL_HDR WHERE MODULE_ID = ? AND DOC_NO = ? AND DOC_TYPE_CODE=?) AND STEXP.DOC_NO = ? AND BATCHVIEW.LANGUAGE_ID(+) = ? AND BATCHVIEW.LANG1(+) = ? AND BATCHVIEW.LANG2(+) = ? AND STEXP.DOC_SRL_NO = ? AND STEXP.ITEM_CODE = STITM.ITEM_CODE AND STEXP.ITEM_CODE = MMITM.ITEM_CODE AND MMITM.LANGUAGE_ID= ? AND STEXP.STORE_CODE = MMSTR.STORE_CODE AND MMITM.LANGUAGE_ID = MMSTR.LANGUAGE_ID AND AMTRD.LANGUAGE_ID(+) = ? AND STEXP.ITEM_CODE = ? AND AMTRD.TRADE_ID(+) = STEXP.TRADE_ID AND MMBIN.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMBIN.BIN_LOCATION_CODE = STEXP.BIN_LOCATION_CODE AND MMBIN.STORE_CODE = STEXP.STORE_CODE AND STEXP.BATCH_ID = BATCHUPD.BATCH_ID(+) AND STEXP.ITEM_CODE = BATCHUPD.ITEM_CODE(+) AND STEXP.EXPIRY_DATE_OR_RECEIPT_DATE = BATCHUPD.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STEXP.TRADE_ID = BATCHUPD.TRADE_ID(+) AND (STEXP.SAL_ITEM_QTY - NVL (STEXP.RET_ITEM_QTY, 0)) > 0",alParameters);
				/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications begain 
		
			*/ 
			//String	allow_decimals_yn="N";
			for(int j=0;j<alRecords.size();j++){
				HashMap dataList		=		(HashMap)alRecords.get(j);
				
				if( getAllowDecimalsYN((String)dataList.get("ITEM_CODE")).equals("Y")){
					dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
					dataList.put("QTY",setNumber((String)dataList.get("QTY"),no_of_decimals));
					dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),no_of_decimals));
				}else{
					dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
					dataList.put("QTY",setNumber((String)dataList.get("QTY"),0));
					dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
				}
				alRecords.set(j,dataList);
			}

			/** @ 
			 CRF_SRR20056-CRF-0537.1 
			 For handle the Decimals in QOH, avail_Qty Modifications end
		
			*/ 


				hmRecord.put("batch_records",""+alRecords.size());
				hmExpRecords.put(""+i,alRecords);
			}

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


	public void loadDocNoDataNew(String doc_no,String sales_doc_type,HashMap hmExp1) throws Exception{
		try{
			String sal_trn_type = "";
			hmExpRecords	= new HashMap();
			//HashMap   hmExpRecords2 = new HashMap(); commented for unused variables by Ganga Thursday, June 27, 2013
			alExpRecords_temp = new ArrayList();
			alDtlRecords	= new ArrayList();
			
			HashMap hmRecord = new HashMap();
			ArrayList alParameters = new ArrayList();

			alParameters.add(getLanguageId());
			alParameters.add(sales_doc_type);
			alParameters.add(doc_no);
			alParameters.add(getLanguageId());
			alParameters.add(doc_no);
			alParameters.add(sales_doc_type);

			String bill_yn = (String)getBLModuleInstalled();

			int no_of_decimals=getNoOfDecimals();
				
			String sql1	=	"SELECT NVL (ST.ALLOW_DECIMALS_YN, 'N') ALLOW_DECIMALS_YN,ST.RETURN_ALLOWED_YN RETURN_ALLOWED_YN, to_char(sh.DOC_DATE,'DD/MM/YYYY') as SAL_DOC_DATE  ,SH.DOC_NO SALES_DOC_NO, SD.DOC_TYPE_CODE SALES_DOC_TYPE_CODE,SH.PATIENT_ID, SH.ENCOUNTER_ID, SH.SAL_TRN_TYPE,NVL (SH.PATIENT_NAME,(SELECT MP.PATIENT_NAME FROM MP_PATIENT MP WHERE MP.PATIENT_ID = SH.PATIENT_ID)) PATIENT_NAME,SH.STORE_CODE, SD.ITEM_CODE, SD.STOCK_ITEM_YN, SD.ITEM_QTY,SD.DOC_SRL_NO, SD.DOC_SRL_NO SAL_DOC_SRL_NO,(SELECT MM.SHORT_DESC FROM MM_ITEM_LANG_VW MM WHERE MM.ITEM_CODE = SD.ITEM_CODE AND LANGUAGE_ID = ?) ITEM_DESC, ST.EXPIRY_YN, SD.GROSS_CHARGE_AMT, SD.PAT_NET_AMT, SD.ITEM_UNIT_COST,SD.ITEM_COST_VALUE, STITM.DEF_ISSUE_UOM UOM_CODE,AM.SHORT_DESC UOM_DESC,(SELECT SUM (SAL_ITEM_QTY - NVL (RET_ITEM_QTY, 0)) FROM ST_SAL_DTL_EXP STEXP WHERE STEXP.FACILITY_ID = SD.FACILITY_ID AND STEXP.DOC_TYPE_CODE = SD.DOC_TYPE_CODE AND STEXP.DOC_NO = SD.DOC_NO AND STEXP.DOC_SRL_NO = SD.DOC_SRL_NO) STOCK_AVAILABLE,(SELECT MM.BILLABLE_ITEM_YN FROM MM_ITEM MM WHERE MM.ITEM_CODE = SD.ITEM_CODE ) BILLABLE_ITEM_YN FROM ST_SAL_HDR SH, ST_SAL_DTL SD, ST_ITEM ST, ST_ITEM_STORE STITM, AM_UOM_LANG_VW AM WHERE SH.DOC_TYPE_CODE=? AND ST.ITEM_CODE = SD.ITEM_CODE AND SH.DOC_NO = SD.DOC_NO AND SH.DOC_TYPE_CODE = SD.DOC_TYPE_CODE AND STITM.ITEM_CODE = SD.ITEM_CODE AND STITM.STORE_CODE = SH.STORE_CODE AND AM.UOM_CODE = STITM.DEF_ISSUE_UOM AND SH.DOC_NO = ? AND AM.LANGUAGE_ID = ?  AND SH.DOC_TYPE_CODE = (SELECT DOC_TYPE_CODE FROM ST_SAL_HDR WHERE MODULE_ID = 'ST' AND DOC_NO = ? AND DOC_TYPE_CODE=? ) AND SD.ITEM_CODE IN ";//added doc_date for GHL-SCF-1337
            
			TreeSet set1 = new TreeSet();

	        for (int j=0;j<hmExp1.size();j++){
	    	 HashMap hmap = (HashMap)hmExp1.get(""+j);
		     set1.add((String)hmap.get("ITEM_CODE"));	

		     alExpRecords_temp.add(hmap);

	         } 

	        Iterator iter = set1.iterator();
	        String whereCond = "(";
	        while (iter.hasNext()) {
	        String str = (String)iter.next();
		    whereCond = whereCond+"'"+str+"',";
	         }
	        whereCond = whereCond.substring(0,whereCond.length()-1) + ")";	 

	        sql1 = sql1 +  whereCond;

			ArrayList alRecords = fetchRecords(sql1,alParameters);

			for (int i=0; i<alRecords.size(); i++) {
				hmRecord	=	(HashMap)alRecords.get(i);

				HashMap hmTemp			=	new HashMap();
				HashMap hmChargeDtls	=	new HashMap();
				//ArrayList alParameters_bat_str = new ArrayList(); commented for unused variables by Ganga Thursday, June 27, 2013
				StringBuffer sb_batch_data     = new StringBuffer();
				HashMap hmRecord_batch_str	=	new HashMap();
				int batch_records1 = 0;
				//HashMap hmExpRecord_batch_qty = null;


				String item_code = (String)hmRecord.get("ITEM_CODE");
		         double item_quantity_int = 0;		 
		         double item_quantity_tot = 0;
	             int y = 0;
		         ArrayList a1 = new ArrayList();

		        for (int k=0;k<hmExp1.size();k++){
		    	 HashMap hmap = (HashMap)hmExp1.get(""+k);		
			 if (item_code.equals((String)hmap.get("ITEM_CODE"))){
				item_quantity_int = item_quantity_int + Double.parseDouble((String)hmap.get("ITEM_QTY"));
				item_quantity_tot = item_quantity_tot + Double.parseDouble((String)hmap.get("SAL_ITEM_QTY"));
				hmap.put("item_qty_"+y++,(String)hmap.get("ITEM_QTY"));
				a1.add(hmap);				
			     }
			 else{
				 y=0;
			     }
				 }
				
				hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
				hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
				hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
				hmTemp.put("item_cost_value",hmRecord.get("ITEM_COST_VALUE"));
				hmTemp.put("item_unit_cost",hmRecord.get("ITEM_UNIT_COST"));
				//hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
				hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS")));
				hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
				hmTemp.put("return_allowed_yn",hmRecord.get("RETURN_ALLOWED_YN"));

 
			//	 if(bill_yn.equals("Y")&& checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N").equals("Y")){
						// alParameters_bat_str.add(doc_no);
						// alParameters_bat_str.add(sales_doc_type);
						// alParameters_bat_str.add(hmRecord.get("DOC_SRL_NO"));

					//	 ArrayList alRecords_batch_str	=	fetchRecords("select TRADE_ID,BATCH_ID,to_char(EXPIRY_DATE_OR_RECEIPT_DATE,'dd/mm/yyyy')EXPIRY_DATE_OR_RECEIPT_DATE,BIN_LOCATION_CODE ,(nvl(sal_item_qty,0)-nvl(ret_item_qty,0)) SAL_ITEM_QTY from st_sal_dtl_exp where doc_no =? and doc_type_code =? and doc_srl_no =?", alParameters_bat_str);				


				 for(int m=0;m<alExpRecords_temp.size();m=m+1){
                   hmRecord_batch_str = (HashMap)alExpRecords_temp.get(m);
                   if (item_code.equals((String)hmRecord_batch_str.get("ITEM_CODE"))){
								
								sb_batch_data.append(hmRecord_batch_str.get("TRADE_ID"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("BATCH_ID"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("EXPIRY_RECEIPT_DT"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("BIN_LOCATION_CODE"));
								sb_batch_data.append(";");
								sb_batch_data.append(hmRecord_batch_str.get("QTY"));					
								sb_batch_data.append(";");
								++batch_records1;
						   }
				  }

			    hmTemp.put("batch_records",""+batch_records1);
				hmTemp.put("no_of_decimals",""+no_of_decimals);
				hmTemp.put("decimal_allowedYN",hmRecord.get("ALLOW_DECIMALS_YN"));
				
				double stock_available=0;
				if( ((String)hmRecord.get("ALLOW_DECIMALS_YN")).equals("Y")){
				 stock_available = Double.parseDouble(setNumber(""+item_quantity_int,no_of_decimals))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("STORE_CODE"));
		                   
				 hmTemp.put("stock_available",setNumber(""+stock_available,no_of_decimals));
				 hmTemp.put("item_qty",setNumber(""+stock_available,no_of_decimals));
				 hmTemp.put("available_qty",setNumber((String)hmRecord.get("STOCK_AVAILABLE"),no_of_decimals));//Added by suresh.r on 15-10-2014 against Inc 2919 
				}else{
				 stock_available = Double.parseDouble(""+item_quantity_int)/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("STORE_CODE"));
                     		
				 hmTemp.put("stock_available",setNumber(""+stock_available,0));				 
				 hmTemp.put("item_qty",setNumber(""+stock_available,0));
				 hmTemp.put("available_qty",setNumber((String)hmRecord.get("STOCK_AVAILABLE"),0));//Added by suresh.r on 15-10-2014 against Inc 2919
					}

				hmTemp.put("stock_item_yn",hmRecord.get("STOCK_ITEM_YN"));
				hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
				hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
				hmTemp.put("store_code",hmRecord.get("STORE_CODE"));
				hmTemp.put("patient_name",hmRecord.get("PATIENT_NAME"));
				hmTemp.put("sal_doc_srl_no",hmRecord.get("SAL_DOC_SRL_NO"));
				hmTemp.put("sales_doc_type_code",hmRecord.get("SALES_DOC_TYPE_CODE"));
				hmTemp.put("sales_doc_no",hmRecord.get("SALES_DOC_NO"));
				hmTemp.put("billable_item_yn",checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N"));

				setSalesDocNo(checkForNull((String)hmRecord.get("SALES_DOC_NO")));
				setSalesDocTypeCode(checkForNull((String)hmRecord.get("SALES_DOC_TYPE_CODE")));
				setStore_code((String)hmRecord.get("STORE_CODE"));
				setSales_doc_date(checkForNull((String)hmRecord.get("SAL_DOC_DATE")));//added for ghl-scf-1337
				if(((String)hmRecord.get("SAL_TRN_TYPE")).equals("X"))
					sal_trn_type = "R";
				else
					sal_trn_type = (String)hmRecord.get("SAL_TRN_TYPE");
				//added for GHL-CRF-0557
				String sal_doc_no=getSalesDocNo();
				String sal_doc_type_code=getSalesDocTypeCode();
				String sales_doc_srl_no = (String)hmRecord.get("SAL_DOC_SRL_NO");
				
			/*	System.out.println("sal_doc_no: "+sal_doc_no);
				System.out.println("sal_doc_type_code: "+sal_doc_type_code);
				System.out.println("sales_doc_srl_no: "+sales_doc_srl_no);*/
				
				if(bill_yn.equals("Y")&& checkForNull((String)hmRecord.get("BILLABLE_ITEM_YN"),"N").equals("Y")){
								
					hmChargeDtls	= callItemChargeDtls((String)hmRecord.get("PATIENT_ID"),checkForNull((String)hmRecord.get("ENCOUNTER_ID")),checkForNull(sal_trn_type,"I"),(String)hmRecord.get("ITEM_CODE"),""+item_quantity_int,sb_batch_data.toString(),checkForNull((String)hmRecord.get("SAL_DOC_DATE")),sal_doc_no,sales_doc_srl_no,sal_doc_type_code);//added for GHL-SCF-1337, modified for GHL-CRF-0557

					hmTemp.put("pat_net_amt",""+hmChargeDtls.get("grosschargeamt"));
					hmTemp.put("gross_charge_amt",""+hmChargeDtls.get("netchargeamt"));
				}else{
					hmTemp.put("pat_net_amt","0");
					hmTemp.put("gross_charge_amt","0");
				}
				alDtlRecords.add(hmTemp);
			//}
				}
			alParameters.clear();
			alParameters.add(getLoginFacilityId());
			alParameters.add("ST");
			alParameters.add(doc_no);
			alParameters.add(sales_doc_type);
			alParameters.add(doc_no);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add("");
			for (int l=0; l<alDtlRecords.size(); l++) {
				hmRecord	=	(HashMap)alDtlRecords.get(l);
				alParameters.set(8,(String)hmRecord.get("doc_srl_no"));
				alParameters.set(11,(String)hmRecord.get("item_code"));
				ArrayList alRecords1	=	fetchRecords("SELECT DISTINCT STEXP.TRADE_ID,BATCHVIEW.QTY_ON_HAND,STITM.USE_AFTER_EXPIRY_YN, STITM.EXPIRY_YN EXPIRY_YN,/*STEXP.SAL_ITEM_QTY*/(STEXP.SAL_ITEM_QTY - NVL (STEXP.RET_ITEM_QTY, 0)) AVAIL_QTY, STITM.TRADE_ID_APPLICABLE_YN,MMITM.MANUFACTURER_ID,(STEXP.SAL_ITEM_QTY - NVL (STEXP.RET_ITEM_QTY, 0)) QTY,MMSTR.SHORT_DESC STORE_DESC, NVL(AMTRD.SHORT_NAME,STEXP.TRADE_ID) TRADE_NAME, TRUNC (STEXP.EXPIRY_DATE_OR_RECEIPT_DATE - SYSDATE) + 1 NOD,MMITM.SHORT_DESC ITEM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW AMMAN WHERE AMMAN.MANUFACTURER_ID = MMITM.MANUFACTURER_ID AND AMMAN.LANGUAGE_ID = MMITM.LANGUAGE_ID) MANUFACTURER_NAME,  STEXP.STORE_CODE, BATCHVIEW.SUSPENDED_YN,STEXP.ITEM_CODE,STEXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE,STEXP.BIN_LOCATION_CODE,TO_CHAR (STEXP.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,  MMBIN.SHORT_DESC BIN_DESC,STEXP.BATCH_ID, /*NVL(BATCHUPD.NEW_BATCH_STATUS,'A') BATCH_STATUS,*/ STEXP.DOC_TYPE_CODE SAL_DOC_TYPE_CODE, STEXP.DOC_NO SAL_DOC_NO,STEXP.DOC_SRL_NO SAL_DOC_SRL_NO  FROM ST_BATCH_SEARCH_LANG_VIEW BATCHVIEW, ST_SAL_DTL_EXP STEXP,ST_ITEM STITM, MM_ITEM_LANG_VW MMITM, MM_STORE_LANG_VW MMSTR,AM_TRADE_NAME_LANG_VW AMTRD,MM_BIN_LOCATION_LANG_VW MMBIN,ST_BATCH_STATUS_UPD_HISTORY BATCHUPD WHERE BATCHVIEW.STORE_CODE(+) = STEXP.STORE_CODE AND BATCHVIEW.ITEM_CODE(+) = STEXP.ITEM_CODE AND BATCHVIEW.BATCH_ID(+) = STEXP.BATCH_ID AND BATCHVIEW.BIN_LOCATION_CODE(+) = STEXP.BIN_LOCATION_CODE AND BATCHVIEW.EXPIRY_DATE(+) = STEXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STEXP.FACILITY_ID = ? AND STEXP.DOC_TYPE_CODE = (SELECT DOC_TYPE_CODE FROM ST_SAL_HDR WHERE MODULE_ID = ? AND DOC_NO = ? AND DOC_TYPE_CODE=?) AND STEXP.DOC_NO = ? AND BATCHVIEW.LANGUAGE_ID(+) = ? AND BATCHVIEW.LANG1(+) = ? AND BATCHVIEW.LANG2(+) = ? AND STEXP.DOC_SRL_NO = ? AND STEXP.ITEM_CODE = STITM.ITEM_CODE AND STEXP.ITEM_CODE = MMITM.ITEM_CODE AND MMITM.LANGUAGE_ID= ? AND STEXP.STORE_CODE = MMSTR.STORE_CODE AND MMITM.LANGUAGE_ID = MMSTR.LANGUAGE_ID AND AMTRD.LANGUAGE_ID(+) = ? AND STEXP.ITEM_CODE = ? AND AMTRD.TRADE_ID(+) = STEXP.TRADE_ID AND MMBIN.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMBIN.BIN_LOCATION_CODE = STEXP.BIN_LOCATION_CODE AND MMBIN.STORE_CODE = STEXP.STORE_CODE AND STEXP.BATCH_ID = BATCHUPD.BATCH_ID(+) AND STEXP.ITEM_CODE = BATCHUPD.ITEM_CODE(+) AND STEXP.EXPIRY_DATE_OR_RECEIPT_DATE = BATCHUPD.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STEXP.TRADE_ID = BATCHUPD.TRADE_ID(+) AND (STEXP.SAL_ITEM_QTY - NVL (STEXP.RET_ITEM_QTY, 0)) > 0",alParameters);
		//Added by suresh.r on 13-10-2014 against Inc 2919 beg
				alRecords=new ArrayList();
				String item_code = (String)hmRecord.get("item_code");
				for (int k=0;k<hmExp1.size();k++){
				    HashMap hmap = (HashMap)hmExp1.get(""+k);		
						 if (item_code.equals((String)hmap.get("ITEM_CODE"))){
							 for(int n=0;n<alRecords1.size();n++){
								HashMap dataList		=		(HashMap)alRecords1.get(n);
								 if (((String)hmap.get("ITEM_CODE")).equals((String)dataList.get("ITEM_CODE")) && ((String)hmap.get("BATCH_ID")).equals((String)dataList.get("BATCH_ID")) && ((String)hmap.get("BIN_LOCATION_CODE")).equals((String)dataList.get("BIN_LOCATION_CODE")) && ((String)hmap.get("EXPIRY_RECEIPT_DT")).equals((String)dataList.get("EXPIRY_RECEIPT_DT"))){
									 dataList.put("QTY",hmap.get("QTY"));
									 dataList.put("TRADE_ID",dataList.get("TRADE_ID"));
									 dataList.put("QTY_ON_HAND",dataList.get("QTY_ON_HAND"));
									 dataList.put("USE_AFTER_EXPIRY_YN",dataList.get("USE_AFTER_EXPIRY_YN"));
									 dataList.put("EXPIRY_YN",dataList.get("EXPIRY_YN"));
									 dataList.put("AVAIL_QTY",dataList.get("AVAIL_QTY"));
									 dataList.put("TRADE_ID_APPLICABLE_YN",dataList.get("TRADE_ID_APPLICABLE_YN"));
									 dataList.put("MANUFACTURER_ID",dataList.get("MANUFACTURER_ID"));
									 dataList.put("STORE_DESC",dataList.get("STORE_DESC"));
									 dataList.put("TRADE_NAME",dataList.get("TRADE_NAME"));
									 dataList.put("NOD",dataList.get("NOD"));
									 dataList.put("ITEM_DESC",dataList.get("ITEM_DESC"));
									 dataList.put("MANUFACTURER_NAME",dataList.get("MANUFACTURER_NAME"));
									 dataList.put("STORE_CODE",dataList.get("STORE_CODE"));
									 dataList.put("SUSPENDED_YN",dataList.get("SUSPENDED_YN"));
									 dataList.put("ITEM_CODE",dataList.get("ITEM_CODE"));
									 dataList.put("NEW_BIN_LOCATION_CODE",dataList.get("NEW_BIN_LOCATION_CODE"));
									 dataList.put("BIN_LOCATION_CODE",dataList.get("BIN_LOCATION_CODE"));
									 dataList.put("EXPIRY_RECEIPT_DT",dataList.get("EXPIRY_RECEIPT_DT"));
									 dataList.put("BIN_DESC",dataList.get("BIN_DESC"));
									 dataList.put("BATCH_ID",dataList.get("BATCH_ID"));
									 dataList.put("SAL_DOC_TYPE_CODE",dataList.get("SAL_DOC_TYPE_CODE"));
									 dataList.put("SAL_DOC_NO",dataList.get("SAL_DOC_NO"));
									 dataList.put("SAL_DOC_SRL_NO",dataList.get("SAL_DOC_SRL_NO"));
									 alRecords.add(dataList);
								 }
								 
						 }
					}
				}
		//Added by suresh.r on 13-10-2014 against Inc 2919 end
			for(int n=0;n<alRecords.size();n++){
				HashMap dataList		=		(HashMap)alRecords.get(n);
				
				if( getAllowDecimalsYN((String)dataList.get("ITEM_CODE")).equals("Y")){
					dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
					dataList.put("QTY",setNumber((String)dataList.get("QTY"),no_of_decimals));
					dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),no_of_decimals));
				}else{
					dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
					dataList.put("QTY",setNumber((String)dataList.get("QTY"),0));
					dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
				}
				alRecords.set(n,dataList);
			}

			//    hmRecord.put("batch_records",""+alRecords.size());

				/* Commented by suresh.r on 14-08-2014 against AAKH-SCF-0129 beg
                 ArrayList hmExpRecords1 = new ArrayList();				 

				  for(int x=0;x<alExpRecords_temp.size();x=x+1){

					    

                         HashMap hmExpRecord_batch_qty = (HashMap)alExpRecords_temp.get(x);

						 System.out.println("hmExpRecord_batch_qty = > "+hmExpRecord_batch_qty);
						 //System.out.println("item_code = > "+item_code);
						 System.out.println("hmExpRecord_batch_qty = > "+(String)hmExpRecord_batch_qty.get("ITEM_CODE"));
					     System.out.println("alRecords.size()==> "+alRecords.size());	

						 String  item_code = (String)hmExpRecord_batch_qty.get("ITEM_CODE");
						 String  batch_id = (String)hmExpRecord_batch_qty.get("BATCH_ID");
						 String  exp_date  =(String)hmExpRecord_batch_qty.get("EXPIRY_RECEIPT_DT");


                  //     if (item_code.equals((String)hmExpRecord_batch_qty.get("ITEM_CODE"))){

						   for(int y=0;y<alRecords.size();y=y+1){
						   HashMap expTemp = (HashMap)alRecords.get(y);

						   if (item_code.equals((String)expTemp.get("ITEM_CODE")) &&  batch_id.equals((String)expTemp.get("BATCH_ID"))  &&	 exp_date.equals((String)expTemp.get("EXPIRY_RECEIPT_DT")) )
						   {
							   expTemp.put("QTY",""+hmExpRecord_batch_qty.get("QTY"));
							   expTemp.put("AVAIL_QTY",""+hmExpRecord_batch_qty.get("QTY"));
							   hmExpRecords1.add(expTemp);
						   }						   
						   }

					//   }
				  }
                
				//hmExpRecords.put(""+l,alRecords);
				//System.out.println("hmExpRecords==> "+hmExpRecords);
				hmExpRecords.put(""+l,hmExpRecords1);
				Commented by suresh.r on 14-08-2014 against AAKH-SCF-0129 end*/
				hmExpRecords.put(""+l,alRecords);//Added by suresh.r on 14-08-2014 against AAKH-SCF-0129
			}

		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


	public HashMap getSalesType(String store_code){
		HashMap hmRecord = null;
		
		try{
			hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT1"),store_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}
	public String getAccessCostDetails()  {
		String cost_yn			  = "";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			//view_cost_yn = fetchRecord("SELECT VIEW_COST_YN FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID=? AND STORE_CODE=?",chkdefaultParameters);
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0)
			cost_yn = (String)view_cost_yn.get("VIEW_COST_YN");
		return cost_yn;
	}

	public String CheckStoreSalesType(String store_code,String sal_trn_type) throws Exception {
		ArrayList alParameters=new ArrayList();
		alParameters.add(store_code);
		//alParameters.add(getLanguageId());
		HashMap result	  = new HashMap();
		String result_string="";
		try{
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
	public String getBLModuleInstalled() throws Exception
	{
		HashMap result = fetchRecord(getStRepositoryValue( "SQL_ST_SAL_CHARGEABLE_YN"));
		String result_yn = (String)result.get("BL_INTERFACE_YN");
		
		return result_yn;
		

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
	public String getSalesDocType(){
		String defaultValue = "";
		return getListOptionTag(getListOptionArrayList("SELECT DISTINCT A.DOC_TYPE_CODE, B.SHORT_DESC FROM ST_SAL_HDR A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND B.LANGUAGE_ID = ? AND MODULE_ID='ST' ",getLanguageId()),defaultValue);
		}
		public String getSalesDocTypeList(){
		return getListOptionTag(getListOptionArrayList("SELECT DISTINCT A.DOC_TYPE_CODE, B.SHORT_DESC ItIsToPopulateListBox FROM ST_SAL_HDR A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE  A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND B.LANGUAGE_ID = ? AND MODULE_ID='ST' ",getLanguageId()),getSalesDocTypeCode());
		
	}
	public String getNursingUnitCodeList() {
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		return getListValues("SELECT nursing_unit_code,  short_desc FROM ip_nursing_unit_lang_vw a ,st_sal_ret_hdr hdr  WHERE  a.facility_id = ?    AND language_id = ?  AND nursing_unit_code =HDR.LOCN_CODE  and HDR.FINALIZED_YN='N'  UNION SELECT clinic_code ,short_desc FROM op_clinic_lang_vw a,st_sal_ret_hdr hdr WHERE a.facility_id = ? AND language_id =? AND clinic_code =HDR.LOCN_CODE and HDR.FINALIZED_YN='N' order by short_desc ",arr_language,"");
	}

	public String getNursingUnitCodeListNew(String fromdate,String todate) {
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(fromdate);
		arr_language.add(todate);
		arr_language.add(getLoginFacilityId());
		arr_language.add(fromdate);
		arr_language.add(todate);
		return getListValues("select clinic_code , short_desc from op_clinic a where facility_id = ?  and exists (select 'Y' from st_sal_ret_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.clinic_code)   union  select nursing_unit_code , short_desc from ip_nursing_unit a where facility_id = ? and exists (select 'Y' from st_sal_ret_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.nursing_unit_code) order by 2",arr_language,"");
	}

	public ArrayList getNursingUnitCodeListNewArr(String fromdate,String todate) throws Exception {
		String [] stParameters	=	{getLoginFacilityId(),fromdate,todate,getLoginFacilityId(),fromdate,todate};
		return fetchRecords("select clinic_code , short_desc from op_clinic a where facility_id = ?  and exists (select 'Y' from st_sal_ret_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.clinic_code)   union  select nursing_unit_code , short_desc from ip_nursing_unit a where facility_id = ? and exists (select 'Y' from st_sal_ret_hdr where doc_date between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and locn_code = a.nursing_unit_code) order by 2",stParameters);
		}


	/*Added By Dinesh T for CRF-110, starts*/
	public ArrayList getCustomerId()throws Exception
	{
		return fetchRecords("SELECT CUSTOMER_ID FROM SM_SITE_PARAM");
	}
	/*Added By Dinesh T for CRF-110, ends*/
	
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
		//Added by suresh.r 07-11-2013 against JD-CRF-156  end
//Added against GHL-CRF-0413.5 starts
	public ArrayList getBatchExpRecords(String patient_id,String encounter_id,String item_code_from,String store_code,String  sal_trn_type)  throws Exception{
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getTrn_type());
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getTrn_type());
		alParameters.add(getLoginFacilityId());
    	alParameters.add(patient_id);
		alParameters.add(encounter_id);
        alParameters.add(item_code_from);
        alParameters.add(store_code);
        alParameters.add(sal_trn_type);
        alParameters.add(getLanguageId());
        alParameters.add(getSalesDocTypeCode());
        alParameters.add(getSalesDocNo());
        alParameters.add(getLoginFacilityId());
        alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getTrn_type());
		System.out.println("alParameters---->@#169"+alParameters);
		int no_of_decimals=getNoOfDecimals();
      ArrayList listRecord	=null;
    try {
		String stSQL="SELECT   sde.item_code, mmi.short_desc item_desc, sde.batch_id, sde.bin_location_code bin_location_code,sde.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, TO_CHAR (sde.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_receipt_dt, sde.trade_id, DECODE(sti.trade_id_applicable_yn, 'Y', (SELECT short_name FROM am_trade_name_lang_vw  am_trade_name WHERE trade_id = sde.trade_id AND mmi.language_id = am_trade_name.language_id), sde.trade_id) trade_name, sde.sal_item_qty, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )avail_qty, sde.doc_type_code sal_doc_type_code, sde.doc_no sal_doc_no, sde.doc_srl_no sal_doc_srl_no, TO_CHAR (sdh.doc_date, 'dd/mm/yyyy') sal_doc_date, srexp.bin_location_code ret_bin_locn,sde.barcode_id FROM ST_SAL_DTL_EXP sde, mm_item_lang_vw mmi, ST_ITEM sti, ST_SAL_HDR sdh,  ST_SAL_DTL ssd, mm_bin_location_lang_vw mmb, ST_SAL_RET_DTL_EXP srexp WHERE (sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code )) > 0 AND sde.facility_id = ? AND sde.facility_id || '-' || sde.doc_type_code || '-' || sde.doc_no IN (SELECT facility_id || '-' || doc_type_code || '-' || doc_no FROM ST_SAL_HDR WHERE patient_id = ? AND NVL (encounter_id, 0) LIKE NVL (?, '0') AND finalized_yn = 'Y') AND mmi.item_code = sde.item_code AND sde.item_code = sti.item_code AND sde.item_code = ? AND sde.store_code = ? AND mmb.bin_location_code = sde.bin_location_code AND mmb.store_code = sde.store_code AND (    sde.facility_id = ssd.facility_id AND sde.doc_type_code = ssd.doc_type_code AND sde.doc_no = ssd.doc_no AND sde.doc_srl_no = ssd.doc_srl_no) AND sdh.sal_trn_type = ? AND ssd.stock_item_yn = 'Y' AND (    sdh.facility_id = ssd.facility_id AND sdh.doc_type_code = ssd.doc_type_code AND sdh.doc_no = ssd.doc_no) AND mmi.language_id = mmb.language_id AND mmi.language_id = ? AND sde.doc_type_code = ? AND sde.doc_no = ? AND sde.batch_id = srexp.batch_id(+) AND sde.trade_id = srexp.trade_id(+) 	 AND sde.doc_no = srexp.sal_doc_no(+) AND sde.doc_type_code = srexp.sal_doc_type_code(+) AND  TRUNC(sde.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC(srexp.EXPIRY_DATE_OR_RECEIPT_DATE(+)) GROUP BY sde.item_code, mmi.short_desc, sde.batch_id, sde.bin_location_code, sde.bin_location_code, mmb.short_desc,sde.expiry_date_or_receipt_date,sde.trade_id,sde.sal_item_qty,sti.trade_id_applicable_yn,mmi.language_id, sde.sal_item_qty - NVL (sde.ret_item_qty, 0)+ ST_COMM_QTY_FOR_DOCNO(?, ?, ?, ?, sde.store_code, srexp.bin_location_code, sde.batch_id, sde.EXPIRY_DATE_OR_RECEIPT_DATE , sde.item_code ) ,sde.doc_type_code, sde.doc_no ,sde.doc_srl_no,sdh.doc_date, sdh.added_date,srexp.bin_location_code,sde.store_code,sde.ret_item_qty,sde.barcode_id ORDER BY sdh.added_date";
    	listRecord = fetchRecords(stSQL.toString(),alParameters);
		System.out.println("alRecords in bean   "+listRecord);
		for(int i=0;i<listRecord.size();i++){
			HashMap dataList		=		(HashMap)listRecord.get(i);
			if(getAllowDecimalsYN((String)dataList.get("ITEM_CODE")).equals("Y")){
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
			dataList.put("SAL_ITEM_QTY",setNumber((String)dataList.get("SAL_ITEM_QTY"),no_of_decimals));
			}else{
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
			dataList.put("SAL_ITEM_QTY",setNumber((String)dataList.get("SAL_ITEM_QTY"),0));
		}
			listRecord.set(i,dataList);
			}
			System.out.println("listRecord---->@#202"+listRecord);
		alTempExpRecords = new ArrayList(listRecord);
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		return listRecord;
	}
	public ArrayList getAlTempExpRecords() {
		return alTempExpRecords;
	}
	public void setAlTempExpRecords(ArrayList alTempExpRecords) {
		this.alTempExpRecords = alTempExpRecords;
	}
}
//Added against GHL-CRF-0413  ends
