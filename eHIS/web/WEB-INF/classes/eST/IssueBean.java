/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
27/04/2018				IN067386				Shazana 													 ML-MMOH-SCF-0979 - Conversion factor live issue 
22/05/2018				67677					Shazana 													 ML-MMOH-SCF-1003	
21/01/2019		        IN067798			    B Haribabu						                             AMRI-CRF-0382 - New filter Authorized date
20/05/2019              IN:069898               B Haribabu                                                   MMS-MD-SCF-0098
19/06/2019              70724                   B Haribabu                                                   NMC-JD-SCF-0016
04/05/2020              IN:072927               Haribabu													 GHL-SCF-1500
2/7/2021				15757					Shazana														Common-ICN-0028
1/7/2022	  			TFS-24350	   			Shazana     												MO-CRF-20173
23/2/2022				TFS27891				Shazana														MO-CRF-20176
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eST;

import eST.Issue.*;
import eST.Common.*;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Properties;
import java.sql.*;

import java.io.Serializable;
//import java.sql.Connection;
import java.util.*;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
//import eCommon.Common.CommonAdapter;
//import eCommon.Common.CommonEJBSessionInterface;
//import javax.ejb.EJBObject;
import javax.servlet.* ;
import javax.servlet.http.*;

//import eST.Issue2.*;
/**
* @Name - Mahesh
* @Date - 20/01/2010
* @Inc# - IN015496
* @Desc - All Interger.parseInt for quantity is changed to Double.parseDouble and variable names are made double
*/


public class IssueBean  extends eST.Common.StDuoHeaderBean implements Serializable{
	private String authorized_by_id; 
	private String finalized_yn;
	private String records_to_delete;
	private String defaultDocType;
	private String remarks; 
	private String hdrRemarks = ""; 
	private String remarks_code = ""; 
	private String close_yn = "N";
	private String acc_entity_id ;
	private String item_class_desc ;

	private String seq_no;
	private String trn_type;
	//private String PDocNo ;
	private ArrayList PDocNo ;

	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
   // private String PgetTrnType = "";
	private String PgetSeqNo = "";
	public String reportserver = "";
	public String report_connect_string = "";
	private String req_fac_id = "";
	private String stReportid = null;
	// Ramana C For the 537.3 3/19/2010
	private double tmpConv=1;
	private double frmtmpConv=1;
	//public static int count = 0;
	private String kit_tmpl_code;

	private HashMap		hmExpRecords=new HashMap();
	private ArrayList	alDtlRecords=new ArrayList();
//	private ArrayList	kitDataList =new ArrayList();
	private ArrayList	alMinMaxRecords=new ArrayList();
	private ArrayList	alDetailRecords=new ArrayList();
	private int doc_srl_no	=	0;
	
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	private String records_to_hold;
	private String hold_yn = "N";
	
/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/
	/*public int getCount(){
		return count++;
	}*/

   public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	/*public ArrayList getKitDtlData(){
		return kitDataList;
	}*/

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
	public void setTempConvFact(double tmpConv){
		this.tmpConv=tmpConv;
	}
	public double getTempConvFact(){
		return tmpConv;
	}
	public void setFrmTempConvFact(double tmpConv){
		this.frmtmpConv=tmpConv;
	}
	public double getFrmTempConvFact(){
		return frmtmpConv;
	}
	public void setRemarks(String remarks) {
		 this.remarks= checkForNull(remarks);
	}

	public String getRemarks( ) {
		 return remarks;
	}
	public void setHdrRemarks(String hdrRemarks) {
		 this.hdrRemarks= checkForNull(hdrRemarks);
	}

	public String getHdrRemarks( ) {
		 return hdrRemarks;
	}
	public void setRemarks_code(String remarks_code) {
		 this.remarks_code= checkForNull(remarks_code);
	}

	public String getRemarks_code( ) {
		 return remarks_code;
	}

	public void setClose_yn(String close_yn) {
		 this.close_yn= close_yn;
	}

	public String getClose_yn( ) {
		 return close_yn;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete= records_to_delete;
	}
	public void setItem_class_desc(String item_class_desc) {
		 this.item_class_desc= item_class_desc;
	}
	public String getRecords_to_delete( ) {
		 return records_to_delete;
	}

	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	public int getDoc_srl_no(){
		return doc_srl_no;
	}
	public String getItem_class_desc( ) {
		 return item_class_desc;
	}
	public void setDoc_srl_no(String doc_srl_no){
		this.doc_srl_no=Integer.parseInt(doc_srl_no);
	}

	/* Default List value population methods*/
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("URG",defaultDocType);
	}

	public void setSeq_no(String seqNo) {
		this.seq_no = seqNo; 
	}
	public String getSeq_no () {
		return this.seq_no;
	}

	public void setTrn_type (String trnType) {
		this.trn_type = trnType;
	}
	public String getTrn_type () {
		return this.trn_type;
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

	public void setReq_Facility_id(String req_fac_id) {
		 this.req_fac_id = req_fac_id;
	}

	public String getReq_Facility_id() {
		 return req_fac_id;
	}
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
      public void setRecords_to_hold(String records_to_hold) {
		 this.records_to_hold= records_to_hold;
	  }
	 
	public String getRecords_to_hold() {
		 return records_to_hold;
	}
	
	public void setHold_yn(String hold_yn) {
		 this.hold_yn= hold_yn;
	}  

	public String getHold_yn( ) {
		 return hold_yn;
	}
	//ends
	/* Methods to retrive all the document type codes related to Issue as well as urgent issue */

	public String getAllIssDocTypeCodes() {
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add("ISS");
		alParameters.add("URG");
		alParameters.add(getLanguageId());
		String result = getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_ALL_ISS_DOC_TYPE_SELECT_LIST"),alParameters),defaultDocType);
		return result;
	}
	//Added for AMRI-CRF-0382 starts
	public ArrayList getAllUrgDocType()  {
		//ArrayList alParameters1=new ArrayList();//15757 //Commented for COMMON-ICN-0060 
		ArrayList result=new ArrayList();
		//alParameters1.add(getLoginFacilityId());
		String langid=getLoginFacilityId();
		String sql="";
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		Connection con 		= null;
		try{
		con = getConnection() ;
		 sql= "select doc_type_code from st_trn_doc_type where facility_id = ? and trn_type = 'URG' ";
		 pstmt = con.prepareStatement(sql ) ;
		 pstmt.setString(1,langid);
		 resultSet = pstmt.executeQuery() ;
			while(resultSet !=null && resultSet.next())
			{ 
				result.add(resultSet.getString( "doc_type_code" ));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{   
			try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(con);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
			
			return result;
			
		}
		
	}
	//Added for AMRI-CRF-0382 starts
	public String getFromStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_QRY_ST_ISSUE_REQ_URG_FROM_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getFrom_store_code());
	}

	public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;	
	}
	
	public String getAcc_entity_id(){
		return this.acc_entity_id;
	}

	public String getToStore() {
		
		String sql = eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_ISSUE_REQ_URG_TO_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getAcc_entity_id());
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		
//		sqlParam.add(getLoginById());
		return getListValues(sql, sqlParam,getTo_store_code());
	}

	public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getFrom_store_code());
		sqlParam.add(getTo_store_code());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public String getAllItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLanguageId());
		return getListValues(sql,sqlParam,"");
	}

	String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}
	//30/07/12
	
	public void setKit_code(String kitcode) {
		this.kit_tmpl_code = kitcode; 
	}
	public String getKit_code() {
		return this.kit_tmpl_code;
	}
	
	
	/*public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public ArrayList getPrintDocNo(){
		return PDocNo;
	}*/

	

//end 

	/* code for display UOM -- 04/07/2004 */

	
	public ArrayList getPur_uom_code_List(String parameters,String item_code) throws Exception{
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		//result = fetchRecords("(SELECT   b.eqvl_uom_code eqvl_uom_code, short_desc FROM am_uom_lang_vw a, am_uom_eqvl b WHERE eff_status = 'E' AND pur_uom_yn = 'Y' AND b.eqvl_uom_code = a.uom_code AND b.uom_code = ? AND UPPER(a.language_id) = UPPER(?) UNION SELECT   uom_code, short_desc FROM am_uom_lang_vw WHERE uom_code = ? AND language_id = ?) INTERSECT(SELECT   b.eqvl_uom_code eqvl_uom_code, short_desc FROM am_uom_lang_vw a, am_uom_eqvl b WHERE eff_status = 'E' AND pur_uom_yn = 'Y' AND b.eqvl_uom_code = a.uom_code AND b.uom_code = ? AND UPPER(a.language_id) = UPPER(?) UNION SELECT   uom_code, short_desc FROM am_uom_lang_vw WHERE uom_code = ? AND language_id = ?) ORDER BY short_desc",chkParameters);
		result = fetchRecords(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
			return result;
	}

	public String getPur_uom_code_Modify_List(String uom_code,String parameters,String item_code) throws Exception{
			String chkParameters[] = {checkForNull(uom_code),getLanguageId(),checkForNull(uom_code),getLanguageId(),checkForNull(uom_code),getLanguageId(),item_code};
			
		 		//return getListOptionTag(getListOptionArrayList("(SELECT   b.eqvl_uom_code eqvl_uom_code, short_desc FROM am_uom_lang_vw a, am_uom_eqvl b WHERE eff_status = 'E' AND pur_uom_yn = 'Y' AND b.eqvl_uom_code = a.uom_code AND b.uom_code = ? AND UPPER(a.language_id) = UPPER(?) UNION SELECT   uom_code, short_desc FROM am_uom_lang_vw WHERE uom_code = ? AND language_id = ?) INTERSECT(SELECT   b.eqvl_uom_code eqvl_uom_code, short_desc FROM am_uom_lang_vw a, am_uom_eqvl b WHERE eff_status = 'E' AND pur_uom_yn = 'Y' AND b.eqvl_uom_code = a.uom_code AND b.uom_code = ? AND UPPER(a.language_id) = UPPER(?) UNION SELECT   uom_code, short_desc FROM am_uom_lang_vw WHERE uom_code = ? AND language_id = ?) ORDER BY short_desc",chkParameters),parameters);
					return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters),parameters);
		
	}
	public String getDefaultIssueUOM(String item_code,String store_code) throws Exception {
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

	public String getDefaultUOM(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_REQUEST_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
		}
		
		if(default_uom.size() > 0)
			default_value = (String)default_uom.get("DEF_REQUEST_UOM");

		return default_value;

	}
	//code ends...


	public String getStock_item_yn(String item_code, String store_code) throws Exception{
		return (String)fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_SELECT_FOR_GRN"),new String[]{item_code, store_code}).get("STOCK_ITEM_YN"); //corrected by Sakti Sankar against inc#-720
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
			else{
		
		alDtlRecords.set(index, hmDtlRecord);
	
	
			}
	}

	public HashMap getDtlRecord(int index){
		
		return (HashMap)alDtlRecords.get(index);
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}
	public ArrayList getDetailValues(){
		return alDetailRecords;
	}

	public void updateExpRecords(int index, Hashtable htExpRecords){
		if (index==-1) {
			index	=	alDtlRecords.size()-1;
		}

		ArrayList alExpRecords	= (ArrayList)hmExpRecords.get(""+index);
		HashMap hmExpRecord;
		for (int i=0;i<alExpRecords.size(); i++) {
			hmExpRecord	=	(HashMap)alExpRecords.get(i);
			hmExpRecord.put("TO_BIN_LOCATION_CODE",	htExpRecords.get("to_bin_location_code_"+i));
			hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
			hmExpRecord.put("RET_ITEM_QTY",	"0");
		}
//	 int  recordsize = alExpRecords.size(); 
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

	public void updateMinMaxRecords(int index, HashMap hmMinMaxRecord){        // Min Max Validation by Rammohan.C 11/8/2006
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");

		if (index!=-1){
			mode	=	(String)((HashMap)alMinMaxRecords.get(index)).get("mode");
		}
		hmMinMaxRecord.put("mode",mode);		
		if (index==-1){
//			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
			alMinMaxRecords.add(hmMinMaxRecord);
		}
		else {
			alMinMaxRecords.set(index, hmMinMaxRecord);
		}
	}

	public HashMap getMinMaxRecord(int index){
	
		return (HashMap)alMinMaxRecords.get(index);
	}

	public ArrayList getMinMaxRecords(){
		return alMinMaxRecords;
	}

	public String getBin_location_code_List(String store_code, String bin_location_code){
			ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return 		getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),bin_location_code);
	}

   
	public String getDefaultBinLocationCode(String store_code,String item_code) throws Exception{


		String def_Bin_Loc= "";
		String []stParameters={store_code,item_code};
		HashMap hmResult = new HashMap();

		ArrayList tempAl = fetchRecords(getStRepositoryValue("SQL_ST_DEF_TO_STORE_TO_BIN"),stParameters) ;
        
		if(tempAl.size()>0){
           hmResult = (HashMap)tempAl.get(0) ;
           def_Bin_Loc =  (String)hmResult.get("BIN_LOCATION_CODE") ;

        }else{

		   def_Bin_Loc="";
		}
		

		return def_Bin_Loc;
	}

	public void initialize(){
		super.initialize();
		this.hmExpRecords=new HashMap();  
		this.alDtlRecords=new ArrayList();
		this.alMinMaxRecords=new ArrayList();
		doc_srl_no	=	0;
		authorized_by_id=""; 
		finalized_yn="N";     
		records_to_delete="";
		remarks="";
		hdrRemarks="";
		remarks_code="";
		close_yn="N";
		seq_no = "";
		trn_type = "";
		acc_entity_id = "";
		records_to_hold=""; //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
		hold_yn = "N";      //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014

	}

	public void  clear(){
		super.clear();
		hmExpRecords=null;  
		alDtlRecords=null;
		alMinMaxRecords=null;
		doc_srl_no	=0;
		authorized_by_id=null; 
		finalized_yn=null;     
		records_to_delete=null;
		remarks=null;
		hdrRemarks="";
		remarks_code="";
		close_yn=null;
		seq_no = null;
		trn_type =null;
		acc_entity_id = null;
		 //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
		records_to_hold=null;
		hold_yn = null;
	}

	public void  clearTemp(){
		hmExpRecords=null;  
		alDtlRecords=null;
		alMinMaxRecords=null;
	}

	public void setAll(Hashtable hashtable) {
		setDoc_type_code((String)hashtable.get("doc_type_code"));  
		setDoc_no((String)hashtable.get("doc_no"));  
		setDoc_ref((String)hashtable.get("doc_ref"));  
		setItem_class_code((String)hashtable.get("item_class_code"));  
		setDoc_date((String)hashtable.get("doc_date"));  
		setFrom_store_code((String)hashtable.get("from_store_code"));  
		setTo_store_code((String)hashtable.get("to_store_code"));  
		//setRemarks((String)hashtable.get("remarks"));   
		authorized_by_id =(String)hashtable.get("authorized_by_id");  
		finalized_yn     =(String)hashtable.get("finalize_yn");  
		records_to_delete=(String)hashtable.get("records_to_delete");  
		setClose_yn(checkForNull((String)hashtable.get("close_yn"),"N"));  

		setRecords_to_delete_for_barcode(records_to_delete);//added for barcode
		
		//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
		records_to_hold = checkForNull((String)hashtable.get("records_to_hold"));  
		setHold_yn(checkForNull((String)hashtable.get("hold_yn"),"N")); 
    }

	public HashMap validate() {
		/*processs detail records as required based on Records to be deleted var of dtl bean*/
		/*not required to process exp records..*/
		return getMessageHashMap(true);
	}


	public String getAvailableQty(String item_code) throws Exception {
		String[] param = new String[7];
		param[0] = item_code;
		param[1] = getFrom_store_code();
		param[2] = "0";
		param[3] = "N";
		param[4] = "";
		param[5] = "";
		param[6] = "";
		java.util.HashMap stockValues = getStockAvailabilityStatus(param);
		return (String) stockValues.get("available_stock");
	}


	/**
	* Method to check whether all the data needed to insert has been entered by the user.
	* As of now, it checks for only the to_bin_locaton_code.
	*/

	public HashMap validateData(int i) {
//		boolean result = true;
		ArrayList sourceArrayList;
		HashMap hmExpRecord			;
		String toBinLocationCode	;
		HashMap hmReturn = getMessageHashMap(true);	
//		for (int i=0;i<alDtlRecords.size();i++) {
			sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
			for (int j=0;j<sourceArrayList.size(); j++ ) {
				hmExpRecord			=	(HashMap)sourceArrayList.get(j);
				toBinLocationCode	= (String)hmExpRecord.get("TO_BIN_LOCATION_CODE");
				if(!((String)hmExpRecord.get("QTY")).equals("0")){
					if(toBinLocationCode == null || toBinLocationCode.equals("")) {
						hmReturn.put(MSGID,"TO_BIN_LOC_NOT_BLANK");
						hmReturn.put(RESULT,FALSE);
						hmReturn.put("flag",(String)hmExpRecord.get("ITEM_DESC"));
						return hmReturn;
					}
				}
			}
//		}
		return hmReturn;
	}	
	public void loadData() throws Exception {
		HashMap hmTempFactor = new HashMap();
		Connection connection			=	null;
        PreparedStatement pstmt			=	null;
        ResultSet resultSet				=	null;
		try {
		connection						=	getConnection();
		pstmt							=	connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ISS_HDR_SELECT"));
//		pstmt.setString(1, getReq_Facility_id());Commented By Mahesh on 8/28/2008
		pstmt.setString(1, login_facility_id);
		pstmt.setString(2, getDoc_type_code());
		pstmt.setString(3, getDoc_no());
		pstmt.setString(4, getSeq_no());
		pstmt.setString(5, getLanguageId());
		pstmt.setString(6, getLanguageId());
		pstmt.setString(7, getLanguageId());
		pstmt.setString(8, getLanguageId());

	
        resultSet						=		pstmt.executeQuery();
        if (resultSet != null && resultSet.next()) {
			setDoc_type_code(resultSet.getString("DOC_TYPE_CODE"));
			setDoc_type_desc(resultSet.getString("DOC_TYPE_DESC"));
			setDoc_no(resultSet.getString("DOC_NO"));
			setSeq_no(resultSet.getString("SEQ_NO"));
			setDoc_date(resultSet.getString("DOC_DATE"));
			setDoc_ref(resultSet.getString("DOC_REF"));  
			setFrom_store_code(resultSet.getString("FM_STORE_CODE"));  
			setFrom_store_desc(resultSet.getString("REQ_ON_STORE_DESC"));  
			setTo_store_code(resultSet.getString("TO_STORE_CODE"));
			setTo_store_desc(resultSet.getString("REQ_BY_STORE_DESC"));
			setFinalized_yn(resultSet.getString("FINALIZED_YN"));
			setFinalized_yn(resultSet.getString("GL_INTERFACED_YN"));
			setTrn_type(resultSet.getString("TRN_TYPE"));
			setClose_yn(resultSet.getString("CLOSE_REQ_AFTER_ISSUE_YN"));
			setHdrRemarks(resultSet.getString("REMARKS"));
			setItem_class_code(resultSet.getString("ITEM_CLASS_CODE"));
			setRemarks_code(checkForNull((String)resultSet.getString("REMARKS_CODE")));
		}

		// Loading the detail Data

		//pstmt					=		null;
		//resultSet				=		null;
		 closeResultSet(resultSet);
         closeStatement(pstmt);
		 // pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, ROUND ((  DECODE (stis.qty_on_hand, 0, 0, stis.item_value) / DECODE (stis.qty_on_hand, 0, 1, stis.qty_on_hand) ), 3 ) item_unit_cost, ROUND (  (  DECODE (stis.qty_on_hand, 0, 0, stis.item_value) / DECODE (stis.qty_on_hand, 0, 1, stis.qty_on_hand) ) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) ), 3 ) item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no");

		// pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, ROUND ((  DECODE (stis.qty_on_hand, 0, 0, stis.item_value) / DECODE (stis.qty_on_hand, 0, 1, stis.qty_on_hand) ), 3 ) item_unit_cost, ROUND (  (  DECODE (stis.qty_on_hand, 0, 0, stis.item_value) / DECODE (stis.qty_on_hand, 0, 1, stis.qty_on_hand) ) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) ), 3 ) item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no"); 
		 /**
		 * @Name - Priya
		 * @Date - 02/06/2010
		 * @Inc# - 
		 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' the above query is modified 
		 */
		int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
		 //pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) item_unit_cost, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no");
		
		//commented by Ganga and added below in else condition  for RUT-CRF-0079
		 //pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) item_unit_cost, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no"); 

		 if(isBarCodeApplicableForValidation("VALIDATEBARCODE",getTrn_type())){
			// pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) item_unit_cost, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type,(SELECT short_desc  FROM mm_bin_location_lang_vw  WHERE store_code = hdr.fm_store_code  AND bin_location_code = stis.bin_location_code  AND language_id = itm.language_id) bin_locn_desc, (SELECT short_desc   FROM mm_item_class_lang_vw  WHERE item_class_code = itm.item_class_code  AND language_id = itm.language_id) item_class_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal1_code    AND language_id = itm.language_id) item_anal1_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal2_code  AND language_id = itm.language_id) item_anal2_desc,(SELECT short_desc   FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal3_code  AND language_id = itm.language_id) item_anal3_desc FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY  28,29,30,31,32,7"); 
			//Modified to use ST_DISPLAY_UNIT_COST function instead  ST_DISPLAY_COST_DECIMALS against inc#50521
			//pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE)*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) item_unit_cost, TRIM(ST_DISPLAY_UNIT_COST(DTL.ITEM_CODE)*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type,(SELECT short_desc  FROM mm_bin_location_lang_vw  WHERE store_code = hdr.fm_store_code  AND bin_location_code = stis.bin_location_code  AND language_id = itm.language_id) bin_locn_desc, (SELECT short_desc   FROM mm_item_class_lang_vw  WHERE item_class_code = itm.item_class_code  AND language_id = itm.language_id) item_class_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal1_code    AND language_id = itm.language_id) item_anal1_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal2_code  AND language_id = itm.language_id) item_anal2_desc,(SELECT short_desc   FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal3_code  AND language_id = itm.language_id) item_anal3_desc FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY  28,29,30,31,32,7"); 
			//Modified by suresh.r on 13-11-2014 against Inc 52256
			pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) item_unit_cost, TRIM(ST_DISPLAY_UNIT_COST(DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type,(SELECT short_desc  FROM mm_bin_location_lang_vw  WHERE store_code = hdr.fm_store_code  AND bin_location_code = stis.bin_location_code  AND language_id = itm.language_id) bin_locn_desc, (SELECT short_desc   FROM mm_item_class_lang_vw  WHERE item_class_code = itm.item_class_code  AND language_id = itm.language_id) item_class_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal1_code    AND language_id = itm.language_id) item_anal1_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal2_code  AND language_id = itm.language_id) item_anal2_desc,(SELECT short_desc   FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal3_code  AND language_id = itm.language_id) item_anal3_desc FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and itm.language_id = str.language_id and itm.item_code = stis.item_code and itm.item_code = stis1.item_code and hdr.seq_no = dtl.seq_no  ORDER BY  28,29,30,31,32,7"); 
		 }
		 else{
			// pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) item_unit_cost, TRIM(ST_DISPLAY_COST_DECIMALS (DTL.ITEM_CODE, dtl.STORE_CODE )) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no");
			
			//Modified to use ST_DISPLAY_UNIT_COST function instead  ST_DISPLAY_COST_DECIMALS against inc#50521
			//pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE)*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) item_unit_cost, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE)*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no"); 
			//Modified by suresh.r on 13-11-2014 against Inc 52256
			pstmt					=		connection.prepareStatement("SELECT (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) remarks,dtl.remarks remarks_code, dtl.doc_srl_no, dtl.store_code, str.short_desc store_desc, dtl.item_code, itm.short_desc item_desc, itm.gen_uom_code uom_code, uom.short_desc uom_desc, DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty,dtl.iss_item_qty ) iss_item_qty, dtl.ret_item_qty, dtl.print_label_yn, dtl.stock_item_yn, dtl.authorized_item_qty, stis1.stock_item_yn to_stock_item_yn, uom.uom_code uom_code, dtl.issue_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =dtl.issue_uom AND language_id = itm.language_id)issue_uom_desc, dtl.issue_uom_conv, dtl.issue_uom_qty, stis.reorder_level rol, stis.min_stk_qty msq, stis.qty_on_hand qoh, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) item_unit_cost, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR(DTL.ITEM_CODE, stis.STORE_CODE)) * (DECODE (dtl.iss_item_qty, 0, dtl.authorized_item_qty, dtl.iss_item_qty ) )  item_cost_value, uom1.short_desc stock_uom_desc,dtl.usage_type,dtl.CLOSE_ITEM_YN FROM st_issue_dtl dtl, st_issue_hdr hdr, mm_item_lang_vw itm, am_uom_lang_vw uom, mm_store_lang_vw str, st_item_store stis, st_item_store stis1, am_uom_lang_vw uom1 WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.seq_no = ? AND dtl.item_code = itm.item_code AND itm.gen_uom_code = uom.uom_code AND stis.def_issue_uom = uom1.uom_code AND dtl.store_code = str.store_code AND hdr.to_store_code = stis1.store_code AND stis.store_code = ? AND dtl.item_code = stis.item_code AND dtl.item_code = stis1.item_code AND itm.language_id = uom.language_id AND itm.language_id = uom1.language_id AND itm.language_id = str.language_id AND itm.language_id = ? AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = dtl.facility_id and itm.language_id = str.language_id and itm.item_code = stis.item_code and itm.item_code = stis1.item_code and hdr.seq_no = dtl.seq_no  ORDER BY dtl.doc_srl_no");//added CLOSE_ITEM_YN for MO-CRF-20173  
		 }


//		pstmt.setString(1, getReq_Facility_id());//Commented by Mahesh 8/28/2008
		pstmt.setString(1, getLanguageId());
		pstmt.setString(2, login_facility_id);
		pstmt.setString(3, getDoc_type_code());
		pstmt.setString(4, getDoc_no());
		pstmt.setString(5, getSeq_no());
		pstmt.setString(6, getFrom_store_code());
		pstmt.setString(7, getLanguageId());
	

	    resultSet				=		pstmt.executeQuery();
	
		//ArrayList alDtlData	=		new ArrayList();
		String avilableQTY;

		//int max_srl_no		=		0;

		while (resultSet != null && resultSet.next()) {
			hmTempFactor = new HashMap();
			HashMap hmDtlRecord	=		new HashMap();
			hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			String stDoc_srl_no	=		resultSet.getString("doc_srl_no");
			
			if (doc_srl_no<Integer.parseInt(stDoc_srl_no))
				doc_srl_no		=		Integer.parseInt(stDoc_srl_no);

			hmDtlRecord.put("doc_srl_no",stDoc_srl_no);
			hmDtlRecord.put("store_code",resultSet.getString("store_code"));
			hmDtlRecord.put("store_desc",resultSet.getString("store_desc"));
			hmDtlRecord.put("item_code",resultSet.getString("item_code"));
			hmDtlRecord.put("item_desc",resultSet.getString("item_desc"));
			hmDtlRecord.put("uom_code",resultSet.getString("uom_code"));
			hmDtlRecord.put("uom_desc",resultSet.getString("uom_desc"));
			hmDtlRecord.put("stock_uom_desc",resultSet.getString("stock_uom_desc"));
			hmDtlRecord.put("for_bin_to_store_hidden",resultSet.getString("to_stock_item_yn"));
			//hmDtlRecord.put("iss_item_qty",resultSet.getString("iss_item_qty"));
			hmDtlRecord.put("ret_item_qty",resultSet.getString("ret_item_qty"));
			//hmDtlRecord.put("item_qty",resultSet.getString("authorized_item_qty"));
			hmDtlRecord.put("item_qty",resultSet.getString("iss_item_qty"));
			hmDtlRecord.put("authorized_item_qty",resultSet.getString("authorized_item_qty"));
			//hmDtlRecord.put("item_unit_cost",resultSet.getString("item_unit_cost"));
			hmDtlRecord.put("item_unit_cost",setNumber((String)resultSet.getString("item_unit_cost"),noOfDecimalsForCost));
			hmDtlRecord.put("item_cost_value",setNumber((String)resultSet.getString("item_cost_value"),noOfDecimalsForCost));
			hmDtlRecord.put("print_label_yn",resultSet.getString("print_label_yn"));
			hmDtlRecord.put("stock_item_yn",resultSet.getString("stock_item_yn"));
			hmDtlRecord.put("remarks",checkForNull(resultSet.getString("remarks")));
			hmDtlRecord.put("remarks_code",checkForNull(resultSet.getString("remarks_code")));
			if(getAllowDecimalsYN(resultSet.getString("item_code")).equals("N")){
				hmTempFactor = (HashMap)getConvFactTemp(resultSet.getString("item_code"),getFrom_store_code(),getTo_store_code(),checkForNull(resultSet.getString("issue_uom")));
				hmDtlRecord.put("from_multiples",(String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
				hmDtlRecord.put("to_multiples",(String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				hmDtlRecord.put("batch_multiples",(String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
				hmDtlRecord.put("issue_uom_multiples",(String)hmTempFactor.get("ISSUE_UOM_MULTIPLES"));
				double toStrQty=(Double.parseDouble((String)hmDtlRecord.get("item_qty"))*Double.parseDouble((String)hmTempFactor.get("FROM_STORE_MULTIPLES")))/Double.parseDouble((String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				hmDtlRecord.put("to_str_qty",""+toStrQty);
			}else{
				double toStrQty=(Double.parseDouble(resultSet.getString("iss_item_qty")))/(getTempConvFact());
				hmDtlRecord.put("to_str_qty",""+toStrQty);
			}
			//hmDtlRecord.put("expiry_yn","Y");  // Hardcoded


			avilableQTY				=		getAvailableQty (resultSet.getString("item_code"));
			//int q					=		Integer.parseInt(avilableQTY)/getConvFactTemp((String)resultSet.getString("item_code"),(String) resultSet.getString("store_code"));
			double q					=		Double.parseDouble(avilableQTY)/getConvFactTemp((String)resultSet.getString("item_code"),(String) resultSet.getString("store_code"))+Double.parseDouble(resultSet.getString("iss_item_qty"));
			hmDtlRecord.put("stock_available",""+q);
			hmDtlRecord.put("includeSuspendedBatches","Y");
			//hmDtlRecord.put("item_qty",resultSet.getString("iss_item_qty"));
			//code added for Issue UOM Details....on 4/7/2004
			hmDtlRecord.put("uom_code",checkForNull(resultSet.getString("uom_code")));
			hmDtlRecord.put("issue_uom",checkForNull(resultSet.getString("issue_uom")));
			hmDtlRecord.put("issue_uom_conv",checkForNull(resultSet.getString("issue_uom_conv")));
			hmDtlRecord.put("issue_uom_qty",checkForNull(resultSet.getString("issue_uom_qty")));

			String conver = "";
			int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hmDtlRecord.get("uom_code"), (String)hmDtlRecord.get("issue_uom")}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)hmDtlRecord.get("uom_code"), (String)hmDtlRecord.get("issue_uom"),(String)hmDtlRecord.get("item_code")}).get("COUNT"));
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)hmDtlRecord.get("uom_code"), (String)hmDtlRecord.get("issue_uom"),(String)hmDtlRecord.get("item_code")});
				//conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)hmDtlRecord.get("uom_code")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)hmDtlRecord.get("issue_uom");
				conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSet.getString("uom_desc")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)resultSet.getString("issue_uom_desc");
							
			}else if(am_count!=0){
				String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hmDtlRecord.get("uom_code"), (String)hmDtlRecord.get("issue_uom")}).get("EQVL_VALUE");
				
				//conver=stEqvl_value+" "+(String)hmDtlRecord.get("uom_code")+" = 1 "+(String)hmDtlRecord.get("issue_uom");
				conver=stEqvl_value+" "+(String)resultSet.getString("uom_desc")+" = 1 "+(String)resultSet.getString("issue_uom_desc");
			}else
                //conver="1"+" "+(String)hmDtlRecord.get("uom_code")+" = 1 "+(String)hmDtlRecord.get("issue_uom");
				conver="1"+" "+(String)resultSet.getString("uom_desc")+" = 1 "+(String)resultSet.getString("issue_uom_desc");
				//String stEqvl_value=""+Double.parseDouble((String)stEqvl_value1.get("CONV_FACTOR"));
			hmDtlRecord.put("iss_uom_conv_text",""+conver);
			hmDtlRecord.put("usage_type",checkForNull(resultSet.getString("usage_type"))); //usage_type
			
			 double iss_qty_hold  =  Double.parseDouble(checkForNull((String)resultSet.getString("iss_item_qty"),"0"));
			 double auth_qty_hold  = Double.parseDouble(checkForNull((String)resultSet.getString("authorized_item_qty"),"0"));
			 
			  
			  int retval = Double.compare(iss_qty_hold, auth_qty_hold);
			   
			 
			 if(retval >0 || retval < 0){
		     hmDtlRecord.put("iss_item_hold_yn", "N"); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			 }else{
			hmDtlRecord.put("iss_item_hold_yn", "Y"); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			}
			hmDtlRecord.put("iss_item_hold_chk","N"); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			hmDtlRecord.put("close_item_yn",checkForNull(resultSet.getString("CLOSE_ITEM_YN")));//MO-CRF-20173
			alDtlRecords.add(hmDtlRecord);  
			setalDtlRecordsforBarCode(hmDtlRecord);//added for barcode

	
			/* ===== Start of Min Max details while loading details in Query mode*/
			HashMap hmMinMaxRecord1				=	new HashMap();
			HashMap hmMinMaxRecord2				=	new HashMap();

			hmMinMaxRecord1						=	getMinMaxdetails(resultSet.getString("item_code"),getFrom_store_code());

			String[] strParameters				=	new String[7];
			strParameters[0]					=	(String)resultSet.getString("item_code");
			strParameters[1]					=	getFrom_store_code();
			strParameters[2]					=	"0"; 
			strParameters[3]					=	"N";
			strParameters[4]					=	"";
			strParameters[5]					=	"N";
			strParameters[6]					=	getTo_store_code();
			HashMap hmStockAvailabilityStatus	=	getStockAvailabilityStatus(strParameters);
			//int qty							=	Integer.parseInt((String)hmMinMaxRecord1.get("AVAILABLE_QTY"))+Integer.parseInt(checkForNull(resultSet.getString("issue_uom_qty"),"0")); available_stock
			double avail_stock						=	Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/getConvFactTemp((String)resultSet.getString("item_code"),getFrom_store_code());
			if (hmMinMaxRecord1!= null  )
			{
				//hmMinMaxRecord2.put("frm_store_qty_on_hand",""+qty);
				hmMinMaxRecord2.put("frm_store_qty_on_hand",""+avail_stock);
				hmMinMaxRecord2.put("frm_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			hmMinMaxRecord1.clear();
			hmMinMaxRecord1						=	getMinMaxdetails(resultSet.getString("item_code"),getTo_store_code());
			if (hmMinMaxRecord1!= null  )
			{
				//hmMinMaxRecord2.put("to_store_qty_on_hand",checkForNull((String)hmMinMaxRecord1.get("AVAILABLE_QTY"),"0"));
				hmMinMaxRecord2.put("to_store_qty_on_hand",checkForNull((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),"0"));
				hmMinMaxRecord2.put("to_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			alMinMaxRecords.add(hmMinMaxRecord2); 
			setMinMaxRecordsforBarcode(hmMinMaxRecord2);

			/* ===== End of Min Max details while loading details in Query mode*/

		}

		
		setNextDoc_srl_noforBarCode(doc_srl_no);

		// Loading the exp records..
		HashMap hmRecord;
		ArrayList alParameters				=		new ArrayList();
		ArrayList alRecords;
		HashMap hmExpRecord;
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord						=		(HashMap)alDtlRecords.get(i);
			alParameters.clear();
//			alParameters.add(getReq_Facility_id());//Commented by Mahesh on 8/28/2008
			alParameters.add(login_facility_id);
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add(getSeq_no());
			alParameters.add(hmRecord.get("doc_srl_no"));
			alParameters.add(hmRecord.get("store_code"));
			alParameters.add(hmRecord.get("item_code"));
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alRecords						=		fetchRecords(getStRepositoryValue("SQL_ST_ISS_DTL_EXP_SELECT"), alParameters);
			for(int j=0;j<alRecords.size();j++) {
				hmExpRecord = (HashMap)(alRecords.get(j));
				//hmExpRecord.put("AVAIL_QTY", hmRecord.get("stock_available"));
			}		

			hmExpRecords.put(""+i,alRecords);

			setExpRecordsforBarCode(i,alRecords); // added for barcode    
		}
		} 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
        }
	}

	public HashMap insert(){
		
// 		HashMap hmResult=new HashMap();
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();

		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alCommonData	=	new ArrayList();
		ArrayList allanguageData	=	new ArrayList();

		alCommonData.add(getLoginById()			);
		alCommonData.add(getLoginAtWsNo()		);
		alCommonData.add(getLoginFacilityId()	);
		alCommonData.add(getDoc_type_code());

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add("1");//seq no
//		alHdrData.add(getDoc_date());
		alHdrData.add(com.ehis.util.DateUtils.convertDate(getDoc_date(),"DMY",getLanguageId(),"en"));
		alHdrData.add(getDoc_ref());
		alHdrData.add(getFrom_store_code());
		alHdrData.add(getTo_store_code());
		
		String store_type_flag = getStoreType(getTo_store_code()); // MMS-SCF-0039 [IN:041887] Ganga,This is to verify the to store is Non Stock Store , if yes then No Acknowledgement
		
		if(store_type_flag.equals("N")){ //N for Non Store Store
			
			alHdrData.add(getFinalized_yn().substring(0,1));
			alHdrData.add("N");
		}
		else{
			if(getAckReqd()){
				alHdrData.add("N");
				alHdrData.add(getFinalized_yn().substring(0,1));
			}
			else{
				alHdrData.add(getFinalized_yn().substring(0,1));//finalize
				alHdrData.add("N");//process for acknowledge
			}
		}
		alHdrData.add("N");
		alHdrData.add("URG"); 
		setTrn_type("URG");
		alHdrData.add("Y"); //entry completed ?);
		alHdrData.add(getLoginById());//authorized_by_id
		alHdrData.add(getClose_yn());//close_req_after_issue_yn
		alHdrData.add(getRemarks_code());//remarks
		alHdrData.add(getLoginById()		);
		alHdrData.add(getLoginAtWsNo()		);
		alHdrData.add(getLoginFacilityId()	);
		alHdrData.add(getItem_class_code());
		
		allanguageData.add(getLanguageId());

		try {
			
			//StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			StringTokenizer stRecordsToDelete;

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
			}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();				
			}



			String nextToken	;
			HashMap hmDtlRecord	;
			ArrayList sourceArrayList;
			HashMap hmExpRecord;

			for (int i=0;i<alDtlRecords_size;i++) {
				nextToken	= stRecordsToDelete.nextToken();
				//hmDtlRecord	=	(HashMap) alDtlRecords.get(i);

				if(getBarcodeApplicable().equals("Y")){
					hmDtlRecord	=	getDtlRecordforBarCode(i);
				}
				else{	
					hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				}


				hmDtlRecord.put("store_code",getFrom_store_code());
//				hmDtlRecord.put("stock_item_yn","Y");
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					//sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);

				if(getBarcodeApplicable().equals("Y")){
					sourceArrayList	=	getExpRecordsforBarCode(i);
				}
				else{	
					sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);				
				}

					for (int j=0;j<sourceArrayList.size(); j++ ) {
						hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						hmExpRecord.put("uom_code",hmDtlRecord.get("uom_code"));
						alExpData.add(hmExpRecord);
					}
				}
			
			// Needs to Changed Here 3/22/2010 Rams for 537.3
		
			double frmStrQty = 1.0;
			double toStrQty = 1.0;
			if((getAllowDecimalsYN((String)hmDtlRecord.get("item_code"))).equals("Y")){
			
			frmStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty")))/(Double.parseDouble((String)hmDtlRecord.get("frm_conv_fact")));//Modified for IN067798
			toStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty")))/(Double.parseDouble((String)hmDtlRecord.get("to_conv_fact")));//Modified for IN067798
			}else{
				
				//frmStrQty=(Double.parseDouble((String)hmDtlRecord.get("item_qty"))*Double.parseDouble((String)hmDtlRecord.get("from_multiples")))/(Double.parseDouble((String)hmDtlRecord.get("batch_multiples")));
				//toStrQty=(Double.parseDouble((String)hmDtlRecord.get("item_qty"))*Double.parseDouble((String)hmDtlRecord.get("to_multiples")))/(Double.parseDouble((String)hmDtlRecord.get("batch_multiples")));
				frmStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())); //ADDED FOR ML-MMOH-SCF-0979//Modified for IN067798
				toStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code())); //Modified for IN067798,Modified for 70724 
				
			}

			double mm_trn_qty = Double.parseDouble((String)hmDtlRecord.get("item_qty"));
			hmDtlRecord.put("to_str_qty",setNumber(""+toStrQty,getNoOfDecimals()));

			hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,getNoOfDecimals()));
			
			hmDtlRecord.put("item_qty",setNumber(""+frmStrQty,getNoOfDecimals()));
			
			
			

			
			hmDtlRecord.put("language_id",(String)getLanguageId());
			alDtlData.add(hmDtlRecord);
			}

		hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	alCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			hmTableData.put("VALIDATEBARCODE",	isBarCodeApplicableForValidation("VALIDATEBARCODE","URG"));//added for RUT-CRF-0079
			hmTableData.put("FROM_STORE", getFrom_store_code());  //MO-CRF-20176
			hmSQLMap=stockSQL();


		}
		catch(Exception exception) {
			exception.printStackTrace();
			System.out.println("IssueBean----hmTableData--"+hmTableData);
		}
		if((getItemClassBased("URG").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"URG");
		}
		return issueMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
		//return new HashMap();
	}

	public HashMap modify(){
 		HashMap hmResult=new HashMap();
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			alParam.add(getSeq_no());		 
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_ISSUE_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND SEQ_NO = ? AND (FINALIZED_YN in ('Y','D') OR PROCESS_FOR_ACKNOWLEDGE='Y')",alParam)).get("COUNT"));// Modified for IN:072927
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
		ArrayList alCommonData	=	new ArrayList();
		ArrayList allanguageData	=	new ArrayList();
		ArrayList alUpdReqCmtdQty	=	new ArrayList();
		alCommonData.add(getLoginById()			);
		alCommonData.add(getLoginAtWsNo()		);
		alCommonData.add(getLoginFacilityId()	);
		alCommonData.add(getDoc_type_code());
		alHdrData.add(getLoginFacilityId());
//		alHdrData.add(getReq_Facility_id());//Commented By Mahesh on 8/28/2008
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getSeq_no());		 
//		alHdrData.add(getDoc_date());
		alHdrData.add(com.ehis.util.DateUtils.convertDate(getDoc_date(),"DMY",getLanguageId(),"en"));
		alHdrData.add(getDoc_ref());
		alHdrData.add(getFrom_store_code());
		alHdrData.add(getTo_store_code());
		
		String store_type_flag = getStoreType(getTo_store_code()); // MMS-SCF-0039 [IN:041887] Ganga,This is to verify the to store is Non Stock Store , if yes then No Acknowledgement
		
		if(store_type_flag.equals("N")){ //N for Non Store Store
			
			alHdrData.add(getFinalized_yn().substring(0,1));
			alHdrData.add("N");
		}else{		
			if(getAckReqd()){
				alHdrData.add("N");//finalize
				alHdrData.add(getFinalized_yn().substring(0,1));//process for acknowledge
			}
			else{
				alHdrData.add(getFinalized_yn().substring(0,1));//finalize
				alHdrData.add("N");//process for acknowledge
			}
		}
		
		alHdrData.add("N"); // GL interfaced YN
		alHdrData.add(getTrn_type()); 
		alHdrData.add("Y"); //entry completed 
		alHdrData.add(getLoginById());//authorized_by_id
		alHdrData.add(getClose_yn());//close_req_after_issue_yn
		alHdrData.add(getRemarks_code());//remarks
		alHdrData.add(getLoginById()		);
		alHdrData.add(getLoginAtWsNo()		);
		alHdrData.add(getLoginFacilityId()	);
   		alHdrData.add(getItem_class_code());
		allanguageData.add(getLanguageId());

		try {
			
			//StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			StringTokenizer stRecordsToDelete ;

			if(getBarcodeApplicable().equals("Y")){				
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete_for_barcode(),",");
			}
			else{			
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			}
			
			StringTokenizer stRecordsToHold = null ;
			if(getTrn_type().equals("ISS")){	
				stRecordsToHold	=	new StringTokenizer(getRecords_to_hold(),",");
			}

			int alDtlRecords_size = 0;

			if(getBarcodeApplicable().equals("Y")){
				ArrayList alDtl  = getDtlRecordsforBarCode();
				alDtlRecords_size	=	alDtl.size();				
			}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();			
			}

			String nextToken	;
			String nextToken1	;
			HashMap hmDtlRecord	;
			ArrayList sourceArrayList	;
			HashMap hmExpRecord	;
			for (int i=0;i<alDtlRecords_size;i++) {
				nextToken	= stRecordsToDelete.nextToken();

				//hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				if(getBarcodeApplicable().equals("Y")){
					hmDtlRecord	=	getDtlRecordforBarCode(i);				
				}
				else{	
					hmDtlRecord	=	(HashMap) alDtlRecords.get(i);				
				}


				hmDtlRecord.put("store_code",getFrom_store_code());
				
				//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
				if(getTrn_type().equals("ISS")){
				nextToken1	= stRecordsToHold.nextToken();
				if(nextToken1.equals("Y")) {
					hmDtlRecord.put("hold_yn","Y");
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
					}
				    }else{
					hmDtlRecord.put("hold_yn","N");
				}
			  }
			  System.out.println("hmDtlRecordhmDtlRecord===issue BEan" +hmDtlRecord);
				if(nextToken.equals("Y")) {
					alUpdReqCmtdQty.add(hmDtlRecord);
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
						
					}
					else {
						continue;
					}
				}
				else{
					//sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);

				if(getBarcodeApplicable().equals("Y")){
					sourceArrayList	=	getExpRecordsforBarCode(i);				
				}
				else{	
					sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);				
				}

					for (int j=0;j<sourceArrayList.size(); j++ ) {
						hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						//hmExpRecord.put("DOC_SRL_NO",hmDtlRecord.get("doc_srl_no"));
						hmExpRecord.put("uom_code",hmDtlRecord.get("uom_code"));
						hmExpRecord.put("hold_yn",checkForNull((String) hmDtlRecord.get("hold_yn"),"N")); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014

						alExpData.add(hmExpRecord);
					}
				}
			double frmStrQty = 1.0;
			double mm_trn_qty = 1.0;
			double toStrQty = 1.0;
			if((getAllowDecimalsYN((String)hmDtlRecord.get("item_code"))).equals("Y")){
				frmStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code()));
				mm_trn_qty = (Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")));
				toStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
			}else{
				
				//frmStrQty=(Double.parseDouble((String)hmDtlRecord.get("item_qty"))*Double.parseDouble((String)hmDtlRecord.get("from_multiples")))/(Double.parseDouble((String)hmDtlRecord.get("batch_multiples"))); // commented for issue_qty live issue- ML-MMOH-SCF-0979
				//toStrQty=(Double.parseDouble((String)hmDtlRecord.get("item_qty"))*Double.parseDouble((String)hmDtlRecord.get("to_multiples")))/(Double.parseDouble((String)hmDtlRecord.get("batch_multiples"))); // commented for issue_qty live issue - ML-MMOH-SCF-0979
				
				frmStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")))/(getConvFactTemp1((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())); //MODIFIED FOR ML-MMOH-SCF-1003
				toStrQty=(Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")))/(getConvFactTemp1((String)hmDtlRecord.get("item_code"),(String)getTo_store_code())); //MODIFIED FOR ML-MMOH-SCF-1003
				mm_trn_qty = (Double.parseDouble((String)hmDtlRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmDtlRecord.get("issue_uom_conv")));
			}
		
			hmDtlRecord.put("to_str_qty",setNumber(""+toStrQty,getNoOfDecimals()));
			hmDtlRecord.put("item_qty",setNumber(""+frmStrQty,getNoOfDecimals()));
			//hmDtlRecord.put("item_qty",""+mm_trn_qty);
			hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,getNoOfDecimals()));
			hmDtlRecord.put("language_id",(String)getLanguageId());
			alDtlData.add(hmDtlRecord); 
			}
			
					
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("REQ_DTL_COM_QTY_DATA",	alUpdReqCmtdQty);
			hmTableData.put("COMMON_DATA",	alCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			hmTableData.put("ReqFacilityId",getReq_Facility_id());
			hmTableData.put("VALIDATEBARCODE",	isBarCodeApplicableForValidation("VALIDATEBARCODE",checkForNull(getTrn_type(),"URG")));//added for RUT-CRF-0079
			hmTableData.put("ITEM_HOLD_YN",checkForNull(getHold_yn(),"N")); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
			System.out.println("IssueBean-mod----hmTableData--"+hmTableData);	
		}

		hmSQLMap=stockSQL();



		return issueMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
		//return new HashMap();

	}

	public HashMap issueMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		

		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;
		try
		{

		//eST.Issue.IssueRemote issueremote = null;
			
		/*InitialContext initialcontext = new InitialContext();
		Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_ISSUE"));
		eST.Issue.IssueHome issuehome = (eST.Issue.IssueHome)PortableRemoteObject.narrow(obj1, eST.Issue.IssueHome.class);

		issueremote = issuehome.create(); */
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ISSUE"),eST.Issue.IssueHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();


		switch (functionID) {
			case FUNCTION_INSERT:
				hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				//hmResult = issueremote.insert( hmTableData, hmSQLMap ) ;  
			//hmResult = new eST.Issue2.IssueManager().insert( hmTableData, hmSQLMap ) ;
				break;
			
			case FUNCTION_UPDATE:
			
				hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);

			//	hmResult = issueremote.modify( hmTableData, hmSQLMap ) ; 
			//hmResult = new eST.Issue2.IssueManager().modify( hmTableData, hmSQLMap ) ;
				break;
			
			case FUNCTION_DELETE:
				hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			//	hmResult = issueremote.delete( hmTableData, hmSQLMap ) ; 
			//hmResult = new eST.Issue2.IssueManager().delete( hmTableData, hmSQLMap ) ;
				break;
			
			default:
				hmResult.put( "message", "Invalid Function ID passed to issueMethodCall()") ;
		}
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		if( ((Boolean) hmResult.get("result")).booleanValue() )	{
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		else if( hmResult.get("msgid")!=null  ) {
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST")) ;
		}
		else {
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		}
		hmResult.put( "message",(String) hmResult.get("message")+":"+checkForNull((String)hmResult.get("item_desc"))) ;
			
		
/* SEND TO PRINT ONLINE REPORT STARTS*/		

	        //String doc_no	=	(String)hmResult.get("doc_no");	
	        ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);

			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getFrom_store_code() ;
            //PgetTrnType  = getTrn_type() ; 
			PgetSeqNo = getSeq_no() ;


			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			//uncommented by Rabbani #inc no:39100 on 18/04/2013
			 if(getReq_Facility_id()!=null)
				params.add(getReq_Facility_id());
			else  //Commented By Mahesh on 8/28/2008
				params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
       
			if (getTrn_type().equals( "URG" ))
				stReportid= "STBURGDC";
			else
				stReportid = "STBISSDCSQ";
			//	stReportid = "STBISSDC"; COMMENTED BY GANGA for Particular seq number for the Inc#26560

//		    if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
		    if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				boolean bnTrueFalse ;
				bnTrueFalse = isInternalRequest("ST",stReportid);
				if ( bnTrueFalse &&  isDocTypePrintAllowed(PgetDoc_type_code) ) {
					
						if(alertRqdYN.equals("Y")){							
							hmResult.put("flag",hmResult.get("flag") + "~PY");							
						}else{
							/*OnlineReportPrinting(doc_no);								
								String pdocno = "";
								for(int i=0;i<doc_no.size();i++){									
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}*/
							hmResult.put("flag",hmResult.get("flag") + "~PN");
						}
				}				
			}
		}
		
		catch (Exception e)
		{		
		  e.printStackTrace();
		}

		return hmResult;
	}

/* SEND TO PRINT ONLINE REPORT ENDS*/	


	/*public void doOnlineReportPrinting(String doc_no) {
		try{

			//String reportid = null;


			if (!isInternalRequest("ST",stReportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",stReportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_seq_no",PgetSeqNo);
			//hmReportParameter.put("p_finalized_yn",getFinalized_yn().substring(0,1));


			//if (!isDocTypePrintAllowed(getDoc_type_code())) return;

          //  javax.servlet.http.HttpSession session = request.getSession(false);
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
			
			//String copies = getNoOfCopies(stReportid);
	
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", stReportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", stReportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", stReportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				report2.addParameter("p_seq_no",PgetSeqNo);
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
			String reportid	 = "";
			if ( getTrn_type() .equals( "URG" ))	{
				reportid= "STBURGDC";
			}
			else {
				reportid = "STBISSDC";
			}

			if (!isInternalRequest("ST",reportid)) {
				return;
			}

			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", getFrom_store_code());
			//((StDuoHeaderBean)getStHeaderBean()).getFrom_store_code();

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
	public HashMap stockSQL(){

	HashMap hmSQLMap		=	new HashMap();

//

		hmSQLMap.put("RequestStatusUpdateSQL", getStRepositoryValue("SQL_ST_REQUEST_HDR_ISS_AUTH_UPDATE"));
		hmSQLMap.put("IssueHdrUpdateSQL", getStRepositoryValue("SQL_ST_ISSUE_HDR_UPDATE"));
		String SQL_ST_ISSUE_DTL_QTY_UPDATE="UPDATE st_issue_dtl SET iss_item_qty	= NVL(?,0) , item_unit_cost = ?,item_cost_value = ?,	modified_by_id = ?,	modified_date =	sysdate, modified_at_ws_no = ?,	modified_facility_id = ? , issue_uom = ? ,  issue_uom_conv = ? , issue_uom_qty = ?,remarks=?,usage_type=? WHERE facility_id = ? AND doc_type_code = ? AND doc_no	= ?	AND	seq_no = ? AND doc_srl_no =	?";
	
	//hmSQLMap.put("IssueQtyUpdateSQL", getStRepositoryValue("SQL_ST_ISSUE_DTL_QTY_UPDATE"));
		hmSQLMap.put("IssueQtyUpdateSQL", SQL_ST_ISSUE_DTL_QTY_UPDATE);
		hmSQLMap.put("RequestQtyUpdateSQL", getStRepositoryValue("SQL_ST_REQUEST_DTL_QTY_UPDATE"));
		hmSQLMap.put("RequestStatusSelect", getStRepositoryValue("SQL_ST_REQUEST_STATUS_SELECT"));
		hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_INSERT"));
		hmSQLMap.put("ItemMovSumUpdateSQL", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE"));
		hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_ITEM_TRN_DTL_INSERT"));
		hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));
//		hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
//		hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
		hmSQLMap.put("CommitedQtySelect", getStRepositoryValue("SQL_ST_COMMITTED_QTY_SELECT"));
		hmSQLMap.put("expForDelSQL", getStRepositoryValue("SQL_ST_ISS_EXP_SELECT_FOR_DEL"));
		hmSQLMap.put("expForBlockRel", getStRepositoryValue("SQL_ST_DTL_EXP_SELECT_FOR_BLOCK_REL"));
		//code added on 08/08/2004 
		hmSQLMap.put("InsertDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_INSERT")); 
		hmSQLMap.put("InsertDTLEXPSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_EXP_INSERT")); 
		//code ended....
	

//sql for mgr
	hmSQLMap.put("stSQLHdrUpdate", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_HDR_UPDATE"));
	hmSQLMap.put("stSQLHdrInsert", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_HDR_INSERT"));
	hmSQLMap.put("stSQLHdrDelete", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_HDR_DELETE"));

	hmSQLMap.put("stSQLDtlUpdate", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_UPDATE"));
	hmSQLMap.put("stSQLDtlInsert", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_INSERT"));
	hmSQLMap.put("stSQLDtlDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_DELETE_ALL"));
	hmSQLMap.put("stSQLDtlDelete", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_DELETE"));

	hmSQLMap.put("stSQLExpUpdate", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_EXP_UPDATE"));
	hmSQLMap.put("stSQLExpInsert", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_EXP_INSERT"));
	hmSQLMap.put("stSQLExpDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_EXP_DELETE_ALL"));
	hmSQLMap.put("stSQLExpDelete", getStRepositoryValue("SQL_ST_ISSUE_REQ_URG_DTL_EXP_DELETE"));
															  
	hmSQLMap.put("sql_sy_acc_entity_doc_type_select", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
	hmSQLMap.put("sql_sy_acc_entity_doc_type_update", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
	hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));

    hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
	hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
	hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
	hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
	hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
	hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
	hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS")); 

	hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
	hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
	hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
	hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));

    hmSQLMap.put("SQL_TRADE_ID_APPLICABLE_SELECT", getStRepositoryValue("SQL_TRADE_ID_APPLICABLE_SELECT"));
    hmSQLMap.put("SQL_DFLT_TRADE_ID_SELECT", getStRepositoryValue("SQL_DFLT_TRADE_ID_SELECT"));
	hmSQLMap.put("SQL_ITEM_TRADE_SELECT", getStRepositoryValue("SQL_ITEM_TRADE_SELECT"));
	hmSQLMap.put("SQL_ITEM_CODE_TRADE_ID_INSERT", getStRepositoryValue("SQL_ITEM_CODE_TRADE_ID_INSERT")); 
	hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));
	hmSQLMap.put("SQLBatchBlockRelease", getStRepositoryValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));
	
	hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
	hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
//
	hmSQLMap.put("ItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_ST_STOCK_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
	hmSQLMap.put("ItemMovSumToUpdateSQL", getStRepositoryValue("SQL_ST_STOCK_TRANSFER_TO_ITEM_MOVE_SUMM_UPDATE"));

	hmSQLMap.put("Fm_ST_ItemMovSumFromUpdateSQL", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_FROM_ST"));
	hmSQLMap.put("Fm_NS_ItemMovSumFromUpdateSQL", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_FROM_NS"));
	hmSQLMap.put("To_ST_ItemMovSumFromUpdateSQL", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_TO_ST"));
	hmSQLMap.put("To_NS_ItemMovSumFromUpdateSQL", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_TO_NS"));

	hmSQLMap.put("ItemMovSumInsertSQL_URG", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_INSERT_URG"));
	hmSQLMap.put("Fm_ST_ItemMovSumFromUpdateSQL_URG", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_FROM_ST_URG"));
	hmSQLMap.put("Fm_NS_ItemMovSumFromUpdateSQL_URG", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_FROM_NS_URG"));
	hmSQLMap.put("To_ST_ItemMovSumFromUpdateSQL_URG", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_TO_ST_URG"));
	hmSQLMap.put("To_NS_ItemMovSumFromUpdateSQL_URG", getStRepositoryValue("ST_SQL_ISSUE_ITEM_MOV_SUM_UPDATE_TO_NS_URG"));
	hmSQLMap.put("SQL_ST_ISSUE_REQ_UPDATE_PENDING_REQ_QTY", getStRepositoryValue("SQL_ST_ISSUE_REQ_UPDATE_PENDING_REQ_QTY"));
	hmSQLMap.put("SQL_ST_ISSUE_REQ_UPDATE_COMMITED_REQ_QTY", "UPDATE ST_REQUEST_DTL SET COMMITTED_ITEM_QTY = 0 WHERE DOC_TYPE_CODE = ? AND DOC_NO = ? AND ITEM_CODE = ?");

//d

/*	hmSQLMap.put("FmItemMovSumInsertSQL", getStRepositoryValue("SQL_FM_STOCK_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
	hmSQLMap.put("ToItemMovSumInsertSQL", getStRepositoryValue("SQL_TO_STOCK_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
	hmSQLMap.put("FmItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_FM_STOCK_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
	hmSQLMap.put("ToItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_TO_STOCK_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
*/
    hmSQLMap.put("sql_st_transfer_dtl_exp_select_for_block_rel", getStRepositoryValue("SQL_ST_TRANSFER_DTL_EXP_SELECT_FOR_BLOCK_REL"));
    hmSQLMap.put("sql_st_records_per_trn_select", getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
    hmSQLMap.put("sql_st_store_records_per_trn_select", "SELECT RECORDS_PER_TRN_URG FROM ST_STORE WHERE STORE_CODE=?");//MO-CRF-20176 
	hmSQLMap.put("UpdateSqlfordelete", "update  st_issue_hdr set 	FINALIZED_YN='D', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ?  AND	seq_no = ?");
//added by Rabbani and Ganga #inc no:27426 on 08/08/11
   hmSQLMap.put("sql_st_issue_dtl_for_auth_qty", getStRepositoryValue("SQL_ST_ISSUE_DTL_FOR_AUTH_QTY"));
//ends
   //Added By Rabbani against inc no:31536 on 17/04/2012
   /*update ST_ITEM_STORE & update ST_REQUEST_DTL */ 
         hmSQLMap.put("UpdateItemsqlfordelete", "UPDATE ST_ITEM_STORE SET PENDING_REQ_QTY = PENDING_REQ_QTY -NVL(?,0) WHERE STORE_CODE = ? AND ITEM_CODE = ?"); 
		 hmSQLMap.put("updaterequetdtlfordelete", getStRepositoryValue("SQL_ST_CANCEL_REQUEST_DTL"));
		 //Added by Rabbani # inc no:43945(ML-BRU-SCF-1056) on 08-OCT-2013
         hmSQLMap.put("SQL_UPDATE_DTL_COMMITTED_QTY", "UPDATE st_request_dtl SET   COMMITTED_ITEM_QTY = COMMITTED_ITEM_QTY - NVL(?,0) , modified_by_id = ?,modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? WHERE  item_code=? AND doc_no = ? AND doc_type_code	= ?");
  //ends
		 //added for RUT-CRF-0079	 
		 hmSQLMap.put("SQL_ST_ITEM_BATCH_GET_BARCODE_ID", getStRepositoryValue("SQL_ST_ITEM_BATCH_GET_BARCODE_ID"));

//end sql for mgr
         //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
         hmSQLMap.put("SQL_MAX_ISSUE_SEQ_NO_QUERY", getStRepositoryValue("SQL_ST_REQUEST_SEQ_SELECT"));
		 hmSQLMap.put("UpdateIssueSeqSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_SEQ_NO_UPDATE")); 
		 hmSQLMap.put("sql_st_facility_id_select", getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT")); //Added by Rabbani on 15/04/2014

	return hmSQLMap;

    }

	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		
		if (getTrn_type().equals("ISS")) {
			return checkForNull((String)hmRecord.get("ISS_FINALIZE_ALLOWED_YN"));
		}
		else{
			return checkForNull((String)hmRecord.get("URG_FINALIZE_ALLOWED_YN"));
		}
	}

	public HashMap delete(){
// 		HashMap hmResult		=	new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		 //Added by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
		 ArrayList AlReqUpdateData	=	new ArrayList();
	//	 ArrayList AlReqHdrData		=	new ArrayList(); Commented for unused variables IN063878
		 ArrayList alParam	        =	new ArrayList();
		 int count                  =  0;
		
		HashMap hmCommonData	=	new HashMap();

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getSeq_no());


/*update for doc no for audit trail start*/
		ArrayList alUpdateHdrData		=	new ArrayList();
		alUpdateHdrData.add(getLoginById());
		alUpdateHdrData.add(getLoginAtWsNo());
		alUpdateHdrData.add(getLoginFacilityId());
		alUpdateHdrData.add(getLoginFacilityId());
		alUpdateHdrData.add(getDoc_type_code());
		alUpdateHdrData.add(getDoc_no());
		alUpdateHdrData.add(getSeq_no());
		hmTableData.put("ALUPDATEHDRDATA",			alUpdateHdrData);
		
	
/*update for doc no for audit trail end*/

        // update st_request_hdr
		//Added by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
	try{
		alParam.add(getLoginFacilityId());
		alParam.add(getDoc_type_code());
		alParam.add(getDoc_no());
		
		count = Integer.parseInt((String)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_DTL WHERE facility_id =	? AND DOC_TYPE_CODE =? AND DOC_NO = ? and NVL(ISS_ITEM_QTY,0) >0", alParam).get("COUNT"));//Modified for ML-BRU-SCF-2230
	    }catch(Exception e){
		e.printStackTrace();
		count = 0;
	     }
	   if(count>0)
		AlReqUpdateData.add("P");
	   else
		  AlReqUpdateData.add("W");
	  
		AlReqUpdateData.add(getLoginById());
		AlReqUpdateData.add(getLoginAtWsNo());
		AlReqUpdateData.add(getLoginFacilityId());
		
		 if(getReq_Facility_id()!=null)
			AlReqUpdateData.add(getReq_Facility_id());
			else   
		  AlReqUpdateData.add(getLoginFacilityId());
		 
		 AlReqUpdateData.add(getDoc_type_code());
		 AlReqUpdateData.add(getDoc_no());



//Added by Rabbani against inc no :31536 on 08/03/12
//Starts 
       
          HashMap hmDelRecord;
		  ArrayList alitemstoreData = new ArrayList();
		  ArrayList alreqdtldata = new ArrayList();
		  String item_code = null;
		  Connection connection = null;
          PreparedStatement pstmt = null;
          ResultSet resultSet = null;
	      //double pendingItemQty = 0;
		   double commitedItemQty = 0;
		      
		    try {
			int alDtlRecords_size = 0;
			if(getBarcodeApplicable().equals("Y")){
				ArrayList alDtl  = getDtlRecordsforBarCode();
				alDtlRecords_size	=	alDtl.size();				
			}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();			
			}
		   connection = getConnection(); //Common-ICN-0091
		   pstmt = connection.prepareStatement("SELECT hdr.req_by_store_code, dtl.pending_item_qty,dtl.item_code ,dtl.COMMITTED_ITEM_QTY FROM st_request_hdr hdr, st_request_dtl dtl WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_no = ? and hdr.doc_type_code = ? and dtl.item_code = ?");   //Common-ICN-0091
		
		   
		   for (int i=0;i<alDtlRecords_size;i++) {
		   hmDelRecord	=	(HashMap) alDtlRecords.get(i);
		   item_code = (String)hmDelRecord.get("item_code");
		  
               //connection = getConnection();  // Common-ICN-0091
	           //pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQ_DTL_PEND_QTY_SELECT"));
			   //pstmt = connection.prepareStatement("SELECT hdr.req_by_store_code, dtl.pending_item_qty,dtl.item_code ,dtl.COMMITTED_ITEM_QTY FROM st_request_hdr hdr, st_request_dtl dtl WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_no = ? and hdr.doc_type_code = ? and dtl.item_code = ?");  //Common-ICN-0091
	           pstmt.clearParameters();  //Common-ICN-0091
		       pstmt.setString(1, getDoc_no());
	           pstmt.setString(2, getDoc_type_code());
			   pstmt.setString(3, item_code );
	           resultSet = pstmt.executeQuery();
			        while(resultSet != null && resultSet.next()) {
					//String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE");
				   // pendingItemQty = Double.parseDouble(resultSet.getString("PENDING_ITEM_QTY"));	
                     commitedItemQty = Double.parseDouble(resultSet.getString("COMMITTED_ITEM_QTY"));				   
					String itemCode = resultSet.getString("ITEM_CODE");
					//commented   by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
					/*ArrayList alitemdata = new ArrayList();		
					alitemdata.add(pendingItemQty);
					alitemdata.add(reqByStoreCode);
					alitemdata.add(itemCode);
					alitemstoreData.add(alitemdata); */
					
					
					ArrayList aldtldata = new ArrayList();		
					//aldtldata.add(pendingItemQty);
					aldtldata.add(commitedItemQty);
					aldtldata.add(getLoginById());
					aldtldata.add(getLoginAtWsNo());
					aldtldata.add(getLoginFacilityId());
					aldtldata.add(itemCode);
					aldtldata.add(getDoc_no());
					aldtldata.add(getDoc_type_code());
					alreqdtldata.add(aldtldata);
					 
				}
			        closeResultSet(resultSet);  //Common-ICN-0091
				}
				}catch (Exception e) {
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

//ends
        hmTableData.put("ALITEMSTOREDATA",alitemstoreData);
		hmTableData.put("ALREQDTLDATA",alreqdtldata);
		hmTableData.put("properties",	getProperties());
		hmTableData.put("DATA",			alHdrData);
		hmTableData.put("COMMON_DATA",	hmCommonData);
		hmTableData.put("AlReqHdrData",	 AlReqUpdateData);
		hmSQLMap=stockSQL();

		hmSQLMap.put("expForDelSQL", getStRepositoryValue("SQL_ST_ISS_EXP_SELECT_FOR_DEL"));
		hmSQLMap.put("expForBlockRel", getStRepositoryValue("SQL_ST_DTL_EXP_SELECT_FOR_BLOCK_REL"));

		hmSQLMap.put("stSQLHdrDelete", getStRepositoryValue("SQL_ST_ISSUE_HDR_DELETE"));
		hmSQLMap.put("stSQLDtlDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_DTL_DELETE_ALL"));
		hmSQLMap.put("stSQLExpDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_DTL_EXP_DELETE_ALL"));

		hmSQLMap.put("stSQLIssHdrDelete", getStRepositoryValue("SQL_ST_ISSUE_HDR_DELETE"));
		hmSQLMap.put("stSQLIssDtlDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_DTL_DELETE_ALL"));
		hmSQLMap.put("stSQLIssExpDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_DTL_EXP_DELETE_ALL"));
		/*update for doc no for audit trail start*/
		hmSQLMap.put("UpdateSqlfordelete", "update  st_issue_hdr set 	FINALIZED_YN='D', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ?  AND	seq_no = ?");
			
/*update for doc no for audit trail end*/
     //Addded   by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
       hmSQLMap.put("UPDATE_ST_REQUEST_HDR_REQ_STATUS", "update  st_request_hdr set 	REQUEST_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID = ? where facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ? ");

		return issueMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
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
// Added on Thursday, August 05, 2004

		public String getStore_desc(String store_code) {
		String store_desc="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
			store_desc=checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_OPENING_STOCK_STORE"), arr_language).get("SHORT_DESC")) ;

		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return store_desc;
    }
	public String getTo_Store_Bin_desc(String bin_location_code,String to_store_code ) {
		String store_desc="";
		try {
			ArrayList arr_language=new ArrayList();

			arr_language.add(bin_location_code);
			arr_language.add(to_store_code);
			arr_language.add(getLanguageId());
			store_desc=checkForNull((String)fetchRecord("SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW MM_BIN_LOCATION WHERE BIN_LOCATION_CODE = ? AND STORE_CODE=? AND LANGUAGE_ID = ? AND EFF_STATUS='E' ",arr_language ).get("SHORT_DESC"));
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return store_desc;
    }

	public String getItem_class_desc(String item_code) {
		String item_desc="";
		ArrayList arr_language=new ArrayList();
		arr_language.add(item_code);
		arr_language.add(getLanguageId());
		try {
			item_desc=checkForNull((String)(fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SELECT"), arr_language)).get("SHORT_DESC")) ;
			}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return item_desc;
    }
	public String getDoc_type_desc(String doc_type_code) {
		String doc_type_desc = "";
		try {
			ArrayList arr_language=new ArrayList();
		arr_language.add(doc_type_code);
		arr_language.add(getLanguageId());
			doc_type_desc	=checkForNull((String)(	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC")));
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return doc_type_desc;
    }
// End of Thursday, August 05, 2004


//added on 27/08
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
	public HashMap getMinMaxdetails(String  item_code, String store_code)
	{
		HashMap hm = new HashMap();
		try
		{
		 String[] stParameters={""+getConvFactTemp(item_code,store_code),item_code,store_code};
		 hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),stParameters);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return hm;	
	}
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
	public String getShortDesc(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {store_code,item_code,getLanguageId()};
		String short_desc			  = "";	
		HashMap short_des			  = new HashMap();
		try{
			//short_des = fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=(SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?) AND LANGUAGE_ID=?",chkdefaultParameters);
				short_des = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			short_desc = "";
		}
		
		if(short_des.size() > 0)
			short_desc = (String)short_des.get("SHORT_DESC");

		return short_desc;
	}
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
	public java.util.ArrayList getOnStoresIssue(String req_by_store) throws Exception
		
	{
		
			ArrayList result		=	new ArrayList();
			String chkParameters[]={getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),getFrom_store_code()};
			//SELECT DISTINCT stp.store_code, mm.short_desc FROM st_store_parent_store stp,                 mm_store_lang_vw mm,st_store st, st_acc_entity_param pa WHERE mm.eff_status = 'E' AND stp.store_code = mm.store_code AND st.store_code = mm.store_code AND ('2' = ? OR 1 = 1) AND pa.acc_entity_id = ? AND (   (pa.trn_across_facility_yn = 'Y') OR mm.facility_id = ?) AND mm.language_id = ? AND stp.parent_store_code = ? ORDER BY 2 
			result = fetchRecords(StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE"),chkParameters);
			

			return result;
	}
			
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
		String chkParameters[] = {request_on_store,request_by_store,getLanguageId()};
			ArrayList result = new ArrayList();
		
			//result = fetchRecords("SELECT stp.item_class_code, mm.short_desc FROM st_store_parent_store stp, mm_item_class_lang_vw mm WHERE mm.item_class_code = stp.item_class_code AND stp.store_code =? AND stp.parent_store_code =? AND stp.eff_status = 'E'  AND language_id =?",chkParameters);
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);

		 return result;
	}
	
	public String docComitQty(String store_code,String item_code,String doc_no){
		String chkdefaultParameters[]	= {item_code,doc_no};
		int iss_uom_conv				= 0;	
		double iss_uom_qty					= 0;	
		HashMap hmRecord				= new HashMap();
		try{
				//hmRecord = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
				hmRecord = fetchRecord("SELECT ISSUE_UOM_CONV,ISSUE_UOM_QTY FROM ST_ISSUE_DTL WHERE ITEM_CODE = ? AND DOC_NO = ?",chkdefaultParameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(hmRecord.size() > 0){
			iss_uom_conv = Integer.parseInt((String)hmRecord.get("ISSUE_UOM_CONV"));
			iss_uom_qty  = Double.parseDouble((String)hmRecord.get("ISSUE_UOM_QTY"));
			return ""+(iss_uom_conv*iss_uom_qty)/getConvFactTemp(item_code,store_code);
		}

		return "0";
	}
	public String getTrnTypeForRemarks(String doc_no){
		String chkdefaultParameters[]	= {doc_no,getDoc_type_code(),getLoginFacilityId()};
		String result					=	"";
		HashMap hmRecord				= new HashMap();
		try{
			hmRecord = fetchRecord("SELECT TRN_TYPE FROM st_issue_hdr WHERE  DOC_NO = ? AND DOC_TYPE_CODE=? AND FACILITY_ID =?",chkdefaultParameters);
			result = (String)hmRecord.get("TRN_TYPE");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
public Boolean getAckReqd(){
		String ack_reqd = "N";
		String ack_facility_reqd = "N";
		String ack_facility_id  = "";
		try{
			//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013 Starts
			ack_facility_id =  (String)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),getTo_store_code()).get("FACILITY_ID");
			//ack_facility_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISS_ACK_REQ_YN");
			ack_facility_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", ack_facility_id).get("ISS_ACK_REQ_YN");
			if(ack_facility_reqd.equals("Y")){
			 if(getTrn_type().equals("ISS")){
			ack_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM ST_STORE WHERE STORE_CODE = ?", getTo_store_code()).get("ISS_ACK_REQ_YN");
			}
			else if(getTrn_type().equals("") || getTrn_type().equals("URG")){
			ack_reqd = (String)fetchRecord("SELECT URG_ACK_REQ_YN FROM ST_STORE WHERE STORE_CODE = ?", getTo_store_code()).get("URG_ACK_REQ_YN");
			}
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}

public String getStoreType(String store_code){
	String store_type_flag = "";
	try{
		store_type_flag = (String)fetchRecord("select store_type_flag from st_store where store_code=?", store_code).get("STORE_TYPE_FLAG");
	}catch(Exception e){
		e.printStackTrace();
	}
	return checkForNull(store_type_flag);
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
		ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		ArrayList<String> alItemHdrData = (ArrayList<String>)hmTableData.get("HDR_DATA");
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
			for(int j=0;j<alItemDtlData.size();j++){
				hmTempData = new HashMap<String,String>();
				hmTempData = alItemDtlData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
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
		for(int i=0;i<alNewItemClassData.size();i++){
			ArrayList<String> alTemp = new ArrayList<String>();
			for(int j=0;j<alItemHdrData.size();j++){
				alTemp.add(alItemHdrData.get(j));
			}
			alTemp.set(19,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
		//hmTableData.put("InsertDTLData",alNewTempDtlData);
		//hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("HDR_DATA",alNewItemHdrData);
		hmTableData.put("DTL_DATA",alNewTempDtlData);
		hmTableData.put("DTL_EXP_DATA",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}

/**/
	public HashMap<String,String> getConvFactTemp(String item_code,String fm_store_code,String to_store_code,String issue_uom){
		HashMap<String,String> conv_factors = new HashMap<String,String>();
		String conv_fac_fm_temp = "";
		String conv_fac_to_temp = "";
		String conv_fac_issue_uom = "";
		int fm_str_eqvl = 1;
		int fm_str_eqvl_qty = 1;
		int to_str_eqvl = 1;
		int to_str_eqvl_qty = 1;
		int issue_uom_eqvl = 1;
		int issue_uom_eqvl_qty = 1;
		
		int fm_str_eqvl_temp = 1;
		int fm_str_eqvl_qty_temp = 1;
		int to_str_eqvl_temp = 1;
		int to_str_eqvl_qty_temp = 1;
		int issue_uom_eqvl_temp = 1;
		int issue_uom_eqvl_qty_temp = 1;
		try {
			conv_fac_fm_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,fm_store_code}).get("CONV_FACTOR");
			conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
			conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
			conv_fac_issue_uom=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_UOM(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,issue_uom}).get("CONV_FACTOR");
		}catch(Exception e){
			e.printStackTrace();
		}
		if(conv_fac_fm_temp.indexOf("~")!=-1){
			fm_str_eqvl_temp = Integer.parseInt(conv_fac_fm_temp.substring(0,conv_fac_fm_temp.indexOf("~")));
			fm_str_eqvl_qty_temp = Integer.parseInt(conv_fac_fm_temp.substring(conv_fac_fm_temp.indexOf("~")+1,conv_fac_fm_temp.length()));
		}
		if(conv_fac_to_temp.indexOf("~")!=-1){
			to_str_eqvl_temp = Integer.parseInt(conv_fac_to_temp.substring(0,conv_fac_to_temp.indexOf("~")));
			to_str_eqvl_qty_temp = Integer.parseInt(conv_fac_to_temp.substring(conv_fac_to_temp.indexOf("~")+1,conv_fac_to_temp.length()));
		}
		if(conv_fac_issue_uom.indexOf("~")!=-1){
			issue_uom_eqvl_temp = Integer.parseInt(conv_fac_issue_uom.substring(0,conv_fac_issue_uom.indexOf("~")));
			issue_uom_eqvl_qty_temp = Integer.parseInt(conv_fac_issue_uom.substring(conv_fac_issue_uom.indexOf("~")+1,conv_fac_issue_uom.length()));
		}
/**/
		fm_str_eqvl_qty = fm_str_eqvl_qty_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		fm_str_eqvl = fm_str_eqvl_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		to_str_eqvl_qty = to_str_eqvl_qty_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		to_str_eqvl = to_str_eqvl_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		issue_uom_eqvl_qty = issue_uom_eqvl_qty_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
		issue_uom_eqvl = issue_uom_eqvl_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
		int common_lcm = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl));
		int issue_uom_multiple = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl)*issue_uom_eqvl_qty)/issue_uom_eqvl;
		conv_factors.put("FROM_STORE_MULTIPLES",""+(common_lcm*fm_str_eqvl_qty)/fm_str_eqvl);
		conv_factors.put("TO_STORE_MULTIPLES",""+(common_lcm*to_str_eqvl_qty)/to_str_eqvl);
		conv_factors.put("BATCH_QTY_MULTIPLES",""+common_lcm);
		conv_factors.put("ISSUE_UOM_MULTIPLES",""+issue_uom_multiple);
		return conv_factors;
	}
/**/
  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
   public Boolean getPendingIssueSeq() { 
		String []stParameters=	{getLoginFacilityId(),getDoc_type_code(),getDoc_no(),getSeq_no()};
			HashMap hmRecord	=	null;
			try{
				hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ISSUE_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'N' AND FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND SEQ_NO <> ?", stParameters);
			}catch(Exception e){
				e.printStackTrace();
				return true;
			}
			if(!((String)hmRecord.get("COUNT")).equals("0"))
				return true;
			else
				return false;
  }
  //ends 
   //ADDED FOR ML-MMOH-SCF-1003
   public double getConvFactTemp1(String item_code,String store_code){
		
	 	System.out.println("getConvFactTemp1");  
		double conv_fac_temp=1; 
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList alParameters = new ArrayList();
		ArrayList eqlParameters = new ArrayList();
		String gen_uom ="";
		String defult_issue_uom ="";
		String defult_request_uom ="";
		try {
		alParameters.add(item_code);
		alParameters.add(store_code);

		HashMap hmRecord	=	fetchRecord(getStRepositoryValue("ST_GENERATE_REQUEST_DEF_ISSUE_REQUEST_UOM"),alParameters);
		
		gen_uom = (String)hmRecord.get("GEN_UOM_CODE");
		defult_issue_uom = (String)hmRecord.get("DEF_ISSUE_UOM");
		defult_request_uom = (String)hmRecord.get("DEF_REQUEST_UOM");
		System.out.println("gen_uom: "+gen_uom);
		System.out.println("defult_issue_uom: "+defult_issue_uom);
		System.out.println("defult_request_uom: "+defult_request_uom);
		
		if(!gen_uom.equals(defult_request_uom)){
			eqlParameters.add(defult_request_uom);
		    eqlParameters.add(defult_issue_uom);
			conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT"),	eqlParameters).get("eqvl_value"),"1.0"));
			System.out.println("conv_fac_temp in if condn: "+conv_fac_temp);
		}else{
                conv_fac_temp =  getConvFactTemp(item_code,store_code);
                System.out.println("conv_fac_temp in else condn: "+conv_fac_temp);
		}

		 
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
}
