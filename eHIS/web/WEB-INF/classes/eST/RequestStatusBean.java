/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
23/06/2017		IN064596		Badmavathi B									ML-BRU-SCF-1715
22/5/2018		67677			Shazana 										ML-MMOH-SCF-1003
---------------------------------------------------------------------------------------------------------
*/
 package eST;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
//import eCommon.Common.CommonRepository;
import eST.Common.StRepository;
//import eST.Common.StAdapter;
//import eCommon.SingleTableHandler.SingleTableHandlerRemote;
//import eCommon.SingleTableHandler.SingleTableHandlerHome;

public class RequestStatusBean extends eST.Common.StTransaction implements Serializable {
	
	private String doc_type_code;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String item_class_code;
	private String cancelled_remarks;
	private String defaultDocType;
	private String entity_param;
	//private String language_id;
	private java.util.ArrayList alItems;
	//private java.util.ArrayList alCheckedItems;
	//private java.util.HashMap hmRemarks;

	public RequestStatusBean() {
		//alCheckedItems = new java.util.ArrayList();
	//	hmRemarks = new HashMap();
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}
	
	/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		 return (doc_ref==null)?"":doc_ref;
	}

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = item_class_code;
	}

	public String getItem_class_code() {
		 return this.item_class_code;
	}

	public void setCancelled_remarks(String cancelled_remarks) {
		 this.cancelled_remarks = cancelled_remarks;
	}

	public String getCancelled_remarks() {
		 return this.cancelled_remarks;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date() {
		 return this.doc_date;
	}

	public void setRequest_by_store(String request_by_store) {
		 this.request_by_store = request_by_store;
	}

	public String getRequest_by_store() {
		 return request_by_store;
	}

	public void setRequest_on_store(String request_on_store) {
		 this.request_on_store = request_on_store;
	}

	public String getRequest_on_store() {
		 return request_on_store;
	}

	public java.util.ArrayList getAlItems() {
		return this.alItems;
	}

	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}

	public String getEntity_param() {
		return this.entity_param;
	}

	/* Default List value population methods*/
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("ISS",defaultDocType);
	}

	public String getRequestByStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_BY_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,"");
	}

	public String getRequestOnStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_ON_STORE_SELECT_LIST");
		//SQL_ST_REQ_ON_STORE_SELECT
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
//		sqlParam.add(getLanguageId());
//		sqlParam.add(getEntity_param());
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,"");
	}

	public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(request_by_store);
		sqlParam.add(request_on_store);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public String getAllItemClasses() {
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLanguageId());
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST1");
		return getListValues(sql,sqlParam,"");
	}
/*
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) {
        ArrayList itemClasses = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST"));
            pstmt.setString(1, request_by_store);
            pstmt.setString(2, request_on_store);
            pstmt.setString(3, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                itemClasses.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return itemClasses;
	}
	*/

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		//Commented by Rabbani #Inc no :39203 on  18-APR-2013
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
		//Added by Rabbani #Inc no :39203 on  18-APR-2013
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_LIST_FOR_REQ_STATUS"),alParameters),defaultValue);
	}

	public void clear() {
		doc_type_code = "";
		doc_no = "";
		doc_ref = "";
		doc_date = "";
		request_by_store = "";
		request_on_store = "";
		defaultDocType = "";
	}

	public String getRequestStatusList()
	{
		return getStaticListOptionTag(" ,All;E,Request  Entered;W,Authorized at Req. by Store;A,Authorized at Issue Store;P,Partially Issued;C,Fully Issued;L,Closed/Cancelled");
	}

	public java.util.ArrayList getOnStoresRequestStatus(String req_by_store) throws Exception {
			String chkParameters[]={login_facility_id,getLanguageId(),getRequest_by_store()};
			ArrayList result = new ArrayList();
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_ON_STORE_SELECT_LIST"),chkParameters);
			return result;
	
	}
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
			String chkParameters[] = {request_by_store,request_on_store,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			
		 return result;
	}


	public ArrayList getRequestByStore(String requestType) throws Exception{
		String sql= "SELECT   st.store_code, mm.short_desc FROM st_store st, mm_store_lang_vw mm WHERE st.store_code = mm.store_code AND st.req_allowed_yn = 'Y' AND mm.facility_id = ? AND mm.language_id = ? AND mm.external_yn LIKE DECODE (?, 'A', '%', ?)  ORDER BY 2,1";
		java.util.ArrayList result = new java.util.ArrayList ();
		String sqlParam[] = {getLoginFacilityId(),getLanguageId(),requestType,requestType};
		result = fetchRecords(sql,sqlParam);
		return result;
	}

	//Added By Sakti against Inc# - 29421 starts
	public String getAckForReqyn() throws Exception{
		String []stParameters=	{getLoginFacilityId()};
		String ISS_ACK_REQ_YN	=	"N";
		HashMap hmRecord	=	new HashMap();
		try{
			hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_FOR_ISS_ACK_YN"), stParameters);
		}catch(Exception e){
			e.printStackTrace();
			}
			if(hmRecord.size()>0) {
			ISS_ACK_REQ_YN	=	checkForNull((String)hmRecord.get("ISS_ACK_REQ_YN"),"N");
		}
		return ISS_ACK_REQ_YN;
		
	}//Added By Sakti against Inc# - 29421 ends
	//Added by Rabbani #Inc no :40572 (Ref:30075(Bru-HIMS-CRF-116)) on 05-JUN-2013
	public boolean isGRN_No_Applicable(String trn_type)  throws Exception {
		
        boolean flag  = false;

        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_ACPT_GRNNO_BACKORD");
			String stArray[] = {trn_type};
			flag = fetchRecord(stSQL, stArray).get("BARCODE_APPL").toString().equals("ACPT_GRNNO_BACKORD");
			}
           catch(Exception exception) {
			flag  = false;
         }
         return flag;
     }
	 //added by rabbani #Bru-HIMS-CFR-112 on 21-AUG-2013
	  //public Boolean getIssAckReqd(String store_code){Modified by suresh.r on 21-07-2015 against GDOH-SCF-0150
	  public boolean getIssAckReqd(String store_code){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM ST_STORE WHERE STORE_CODE = ?", store_code).get("ISS_ACK_REQ_YN");
		  }catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}

	    //added for ML-MMOH-SCF-1003 START
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
                   conv_fac_temp =  getConvFactTemp(item_code,getRequest_by_store());
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
	}   //added for ML-MMOH-SCF-1003 END
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
	  public String getUOMDesc (String uom_code){
			Connection connection	= null;
	        PreparedStatement pstmt	= null;
	        ResultSet resultSet		= null;	
			String short_desc		= "";
			try {
	            connection	= getConnection() ;
	          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
				pstmt		= connection.prepareStatement( "select SHORT_DESC from am_uom_lang_vw where UOM_CODE=? and  LANGUAGE_ID=?") ;
				pstmt.setString(1,uom_code);
				pstmt.setString(2,getLanguageId());
	            resultSet	= pstmt.executeQuery() ;
				if (resultSet.next()){
					short_desc = resultSet.getString("SHORT_DESC");				
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;			
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection ); 
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
			return short_desc;
		}
}
