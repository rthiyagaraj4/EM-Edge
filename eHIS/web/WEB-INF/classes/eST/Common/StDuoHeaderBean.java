/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common;

//port eST.Common.StTransaction;
import java.io.Serializable;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StDuoHeaderBean extends StTransaction implements Serializable {

   private String doc_ref;
   private String trn_type;
   private String from_store_code;
   private String to_store_code;
   private String to_store_desc;
   private String from_store_desc;
   private String doc_type_code;
   private String doc_type_desc;
   private String doc_date;
   private String doc_no;
   private String item_class_code;
   private String item_class_desc;
//   private String remarks;
   private String finalize_yn;
   private String authorize_yn;
  // private String language;

   //private boolean isAutoNo;
   private String autono_yn;

//   private String def_doc_type_code;
//   private String def_from_store_code;
//   private String def_to_store_code;

   private String sql_from_store;
   private String sql_to_store;
// private String sql_item_class;
   private String acc_entity_id;

   private String item_class_modify;
   private String doc_date_modify;	
   private HashMap hmStParameter;
 //Added for  NMC-JD-SCF-0174 starts
   private boolean site_alna=false;
   
   public boolean isSite_alna() {
	return site_alna;
}

public void setSite_alna(String site_alna) {
	  if(site_alna.equals("true")){
	this.site_alna = true;}
}
//Added for  NMC-JD-SCF-0174 ends
private ArrayList alDocTypeListOption;
   
 //Added for GHL-CRF-0413 starts
 
   //private ArrayList alStoreCodeListOption;
	
	public void initialize()
	{	
		super.initialize();  //added by ganga


		hmStParameter = new HashMap();
		alDocTypeListOption = new ArrayList( );
//		def_doc_type_code = "";
//        def_from_store_code = "";
//        def_to_store_code ="";
        sql_from_store ="";
        sql_to_store ="";
//      sql_item_class ="";
        acc_entity_id ="";


		doc_ref="";                 
		trn_type="";                
		from_store_code="";              
		to_store_code="";              
		doc_type_code="";           
		doc_date="";                
		doc_no="";                  
		item_class_code="";
		System.out.println("StDuoHeaderBean initialize");


	}

    public void initialize(String trn_type) {
		try { 
	        hmStParameter	=	getStParameter();
			doc_type_code	=	checkForNull((String)hmStParameter.get("DEF_"+trn_type+"_DOC_TYPE_CODE"));
			
			if(doc_type_code.equals("") && trn_type.equals("PRQ"))
			{
				ArrayList aa=new ArrayList();
				aa.add(getLoginFacilityId());
				aa.add(getLanguageId());
			//	doc_type_code=fetchRecord("SELECT   a.DOC_TYPE_CODE DOC_TYPE_CODE FROM st_trn_doc_type a,sy_doc_type_master_lang_vw b,sy_acc_entity_doc_type c WHERE a.facility_id = ? AND a.doc_type_code = b.doc_type_code AND a.trn_type = 'PRQ' AND b.status IS NULL AND a.doc_type_code = c.doc_type_code AND b.language_id = ?",aa).get("DOC_TYPE_CODE").toString();
			doc_type_code=checkForNull((String)(fetchRecord(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT"),aa).get("DOC_TYPE_CODE")));
			}
		

			if (!doc_type_code.equals("")) {
				ArrayList arr_language=new ArrayList();
				arr_language.add(doc_type_code);
				arr_language.add(getLanguageId());
				doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
		    }

			doc_date		=	hmStParameter.get("SYS_DATE").toString();
			doc_ref			=	"";
			doc_no			=	"";
			this.trn_type	=	trn_type;
			initDoc_type_code_List();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
    }

	public boolean hasAllMandatoryValue()throws Exception{
		return ((!from_store_code.equals(""))&&
				(!to_store_code.equals(""))&&
				(!item_class_code.equals(""))&&
				(!doc_type_code.equals(""))&&
				(!(doc_no.equals("")&& !isDocNoAutoGenYN(doc_type_code)) )&&
				(!doc_date.equals("")));
	}

	public void initialize(String trn_type, String doc_type_code, String doc_no, String doc_date, String doc_ref, String from_store_code,String to_store_code,String item_class_code){
		this.doc_type_code	=	doc_type_code;
		this.doc_no = doc_no;
		this.doc_date = doc_date;
		this.doc_ref = doc_ref;
		this.item_class_code= item_class_code;
		this.from_store_code = from_store_code;
		this.to_store_code  =	to_store_code;
		this.trn_type =	trn_type;
		try { 
			if (!doc_type_code.equals("")) {
				ArrayList arr_language=new ArrayList();
				arr_language.add(doc_type_code);
				arr_language.add(getLanguageId());
				doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		initDoc_type_code_List();
    }

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref() {
		 return doc_ref;
	}

	public void setSql_from_store(String sql_from_store) {
		 this.sql_from_store = sql_from_store;
	}

	public String getSql_from_store() {
		 return sql_from_store;
	}

	public void setSql_to_store(String sql_to_store) {
		 this.sql_to_store = sql_to_store;
	}

	public String getSql_to_store() {
		 return sql_to_store;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}
	public void setItem_class_desc(String item_class_desc) {
		 this.item_class_desc = item_class_desc;
	}
	public String getTrn_type() {
		 return trn_type;
	}

	public void setFrom_store_code(String from_store_code) {
		 this.from_store_code = from_store_code;
	}

	public String getFrom_store_code() {
		 return from_store_code;
	}

	public void setTo_store_code(String to_store_code) {
		 this.to_store_code = to_store_code;
	}

	public String getTo_store_code() {
		 return to_store_code;
	}
	public String getItem_class_Desc() {
		return this.item_class_desc;
	}
	public void setTo_store_desc(String to_store_desc) {
		 this.to_store_desc = to_store_desc;
	}

	public void setFrom_store_desc(String from_store_desc) {
		 this.from_store_desc = from_store_desc;
	}

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = checkForNull(item_class_code);
	}

	public String getItem_class_code() {
		 return item_class_code;
	}



	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setFinalize_yn(String finalize_yn) {
		this.finalize_yn = finalize_yn;
	}

	public String getFinalize_yn() {
		return this.finalize_yn;
	}
	
	public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;
	}

	public String getAcc_entity_id() {
		return this.acc_entity_id;
	}
	

	public void setAuthorize_yn(String authorize_yn) {
		this.authorize_yn = authorize_yn;
	}

	public String getAuthorize_yn() {
		return this.authorize_yn;
	}
	/*public void setLanguage(String language) {
		this.language = language;
	}
public String getLanguage() {
		return this.language;
	}*/
	public void setAutono_yn(String autono_yn) {
		this.autono_yn = autono_yn;
	}

	public String getAutono_yn() {
		return this.autono_yn;
	}
	
	public void setDoc_type_code(String s)
    {
        doc_type_code = s;
    }

    public String getDoc_type_code()
    {
        return doc_type_code;
    }

    public void setDoc_date(String doc_date) {
        this.doc_date = doc_date;
    }

    public String getDoc_date() {
        return doc_date;
    }
	
	public String getDoc_type_desc()
    {
		try{
			doc_type_desc = "";
			if(!(doc_type_code.equals(""))){
				ArrayList arr_language=new ArrayList();
				arr_language.add(doc_type_code);
				arr_language.add(getLanguageId());
				doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
			}
		}
		catch(Exception exception ){
			doc_type_desc = "";
			exception.printStackTrace();
		}
		return doc_type_desc;
    }

	public void setDoc_type_desc(String doc_type_desc){
		this.doc_type_desc=doc_type_desc;
	}

	public void initDoc_type_code_List(){
        ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getTrn_type());
        arraylist.add(getLanguageId());
        alDocTypeListOption=getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST_HDR"), arraylist);
	}

	public String getDoc_type_code_List() {
		System.out.println("jkwffkkkkkkkkkkkkkkkk");
		   return getListOptionTag(alDocTypeListOption, getDoc_type_code());
    }
	
	public String getFrom_store_desc() {
		HashMap hm_arr=new HashMap();
		try {
			if(!(getFrom_store_code().equals("")||getFrom_store_code()==null)){
				ArrayList arr_language = new ArrayList();
				arr_language.add(getFrom_store_code());
				arr_language.add(getLanguageId());
				hm_arr=fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT") ,arr_language) ;
			}else
				return "";
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return  checkForNull((String)hm_arr.get("SHORT_DESC"));
    }
	
	 public String getTo_store_desc() {
		 HashMap hm_arr=new HashMap();
		try {
			if(checkForNull(getTrn_type()).equals("PRQ"))
			{
				ArrayList arr_language = new ArrayList();
				arr_language.add(getTo_store_code());
				arr_language.add(getLanguageId());
				//hm_arr=fetchRecord(" SELECT short_desc FROM am_dept_lang_vw WHERE dept_code =? AND language_id LIKE ?", arr_language);
				hm_arr=fetchRecord(getStRepositoryValue("SQL_ST_AM_DEPT_SELECT"), arr_language);
			return  checkForNull((String)hm_arr.get("SHORT_DESC"));
			}
			if(!(checkForNull(getTo_store_code()).equals(""))){
				ArrayList arr_language = new ArrayList();
				arr_language.add(getTo_store_code());
				arr_language.add(getLanguageId());
				hm_arr=fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT"), arr_language);
			}else 
				return "";
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return  checkForNull((String)hm_arr.get("SHORT_DESC"));
    }


	public String getItem_class_desc() {
		String empty="";
		HashMap hm_arr=new HashMap();
		if(!getItem_class_code().equals(""))
		{
		try {
			ArrayList arr_language = new ArrayList();
			arr_language.add(getItem_class_code());
			arr_language.add(getLanguageId());
			
			hm_arr=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SELECT"), arr_language);
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}

		return (String)hm_arr.get("short_desc");
		}
		return empty;
    }

	public String getRequestFromStore() {
		

		String sql =""; 
				System.out.println("sql_from_store=at bean==>"+sql_from_store);
		if(sql_from_store.equals("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS")){
			sql="SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1";
		}else{
			sql=eST.Common.StRepository.getStKeyValue(sql_from_store);
		}
		ArrayList sqlParam = new ArrayList();
		System.out.println("sql_from_store=at +==>"+sql);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getFrom_store_code());
	}

	public String getRequestToStore() {
				
		String sql = eST.Common.StRepository.getStKeyValue(sql_to_store);
		System.out.println("sql_to_store===>"+sql);
		ArrayList sqlParam = new ArrayList();
		sqlParam.add(getLoginById());
		sqlParam.add(getAcc_entity_id());
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());

		return getListValues(sql, sqlParam,getTo_store_code());
	}
	public String getRequestToStore1() {
		ArrayList alParameters =  new ArrayList();				
		try {
			
			if(getFunctionId().equals("ST_REQUEST"))
			{
				alParameters = new ArrayList();
				alParameters.add(login_facility_id);
				alParameters.add(getLanguageId());
				alParameters.add(getFrom_store_code());
				return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE1"), alParameters,checkForNull(getTo_store_code()));
				
			}
			if(getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE"))
			{				
				alParameters = new ArrayList();
				alParameters.add(getLoginById());
				alParameters.add(getAcc_entity_id());
				alParameters.add(login_facility_id);
				alParameters.add(getLanguageId());
				alParameters.add(getFrom_store_code());
				return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_AUTH_AT_REQ_ON_STORE_SELECT"), alParameters,checkForNull(getTo_store_code()));
			
								
			}
			if(getFunctionId().equals("ST_ISSUE_RETURN"))
			{
				alParameters = new ArrayList();
				alParameters.add(getLoginById());
				alParameters.add(getAcc_entity_id());
				alParameters.add(login_facility_id);
				alParameters.add(getLanguageId());
				alParameters.add(getFrom_store_code());
				return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RET_TO_STORE"), alParameters,checkForNull(getTo_store_code()));
				
			}
			if(getFunctionId().equals("ST_STOCK_TRANSFER"))
			{
				alParameters = new ArrayList();
				alParameters.add(getLoginById());
				alParameters.add(getAcc_entity_id());
				alParameters.add(login_facility_id);
				alParameters.add(getLanguageId());
				alParameters.add(getFrom_store_code());
				System.out.println("----------ST_STOCK_TRANSFER"+isSite_alna()+"--------INSIDE ");
				 //Added for  NMC-JD-SCF-0174 starts
				if(isSite_alna())
				{
					System.out.println("SQL_ST_STOCK_TO_STORE_DIFFERENT_FACILITYID--------------->   New  List.........");
					System.out.println(getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_TO_STORE_DIFFERENT_FACILITYID"), alParameters,checkForNull(getTo_store_code())));
					System.out.println("END New List....1");
					return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_TO_STORE_DIFFERENT_FACILITYID"), alParameters,checkForNull(getTo_store_code()));
				}
				else{
					System.out.println("SQL_ST_STOCK_TO_STORE--------------->  Old  List.........");
					System.out.println(getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_TO_STORE"), alParameters,checkForNull(getTo_store_code())));
					System.out.println("END  Old List...2.");
				return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_TO_STORE"), alParameters,checkForNull(getTo_store_code()));}
				 //Added for  NMC-JD-SCF-0174 ends
			}
			if(getFunctionId().equals("ST_PO_REQUEST_FN")){
				alParameters = new ArrayList();
				alParameters.add(getLanguageId());
				alParameters.add(getFrom_store_code());
				return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_MM_STORE_SELECT"), alParameters,checkForNull(getTo_store_code()));
				
			}
			alParameters = new ArrayList();
			alParameters.add(getAcc_entity_id());
			alParameters.add(login_facility_id);
			alParameters.add(getLanguageId());
			alParameters.add(getFrom_store_code());
			//Added for NMC-JD-CRF-0174 starts
			System.out.println("----------SQL_ST_ISSUE_REQ_URG"+isSite_alna()+"--------INSIDE ");
			if(isSite_alna() && trn_type.equals("URG"))
			{
				System.out.println("----------SQL_ST_ISSUE_REQ_URG_TO_STORE2     ----------New List.........");
				System.out.println(getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE2"), alParameters,checkForNull(getTo_store_code())));
				System.out.println("END  New List....3");
				return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE2"), alParameters,checkForNull(getTo_store_code()));
			}
			else{
				System.out.println("----------SQL_ST_ISSUE_REQ_URG_TO_STORE1    ----------Old List.........");
				System.out.println( getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE1"), alParameters,checkForNull(getTo_store_code())));
				System.out.println("END  Old List....4");
			return getListValues(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE1"), alParameters,checkForNull(getTo_store_code()));}
			//Added for NMC-JD-CRF-0174 ends

		}catch (Exception e) {
            e.printStackTrace();
        }
	return "";
	}

	public String getItemClass() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		ArrayList sqlParam = new ArrayList ();
		sqlParam.add(checkForNull(getFrom_store_code()));
		sqlParam.add(checkForNull(getTo_store_code()));
		sqlParam.add(checkForNull(getLanguageId()));
		
		return getListValues(sql, sqlParam,checkForNull(getItem_class_code()));
	}

	public ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
		ArrayList result = new ArrayList();
		if((getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE")||(getFunctionId().equals("ST_ISSUE_REQ_URG"))||(getFunctionId().equals("ST_STOCK_TRANSFER")))&& (getMode().equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			{
			
				String chkParameters[] = {request_by_store,request_on_store,getLanguageId()};
				result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);

			}
			else if (getFunctionId().equals("ST_PO_REQUEST_FN")){
				String chkParameters[] = {request_on_store,getLanguageId()};
			//	result = fetchRecords("SELECT st.item_class_code, mm.short_desc   FROM st_item_class_store st, mm_item_class_lang_vw mm  WHERE st.store_code = ? AND mm.item_class_code = st.item_class_code AND mm.language_id = ? ORDER	BY short_desc",chkParameters);
				result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_STORE_SELECT"),chkParameters);
				
			}else {
				String chkParameters[] = {request_on_store,request_by_store,getLanguageId()};
				result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			}
		
       
        return result;
	}

	/*public void initFrom_store_code_List(String stSQLId){
        ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLoginById());
        alStoreCodeListOption=getListOptionArrayList(getStRepositoryValue(stSQLId), arraylist);
	}

	public String getStore_code_List() {
        return getListOptionTag(alStoreCodeListOption, getStore_code());
    }*/

    public void clear()
    {
        super.clear();
		System.out.println("StDuoHeaderBean clear");
		doc_ref=null;                 
		trn_type=null;                
		from_store_code=null;              
		to_store_code=null;              
		doc_type_code=null;           
		doc_date=null;                
		doc_no=null;                  
		item_class_code=null;
		hmStParameter=null;          
		alDocTypeListOption=null; 
		doc_type_desc = "";
		//alStoreCodeListOption=null;
    }
	public String toString(){
		return
		doc_ref+
		trn_type+
		from_store_code+
		to_store_code+
		doc_type_code+
		doc_date+
		doc_no+
		item_class_code+
		sql_from_store+
		alDocTypeListOption;       
	}
	public ArrayList toArrayListDuo()
	{
	//facility_id, doc_type_code, doc_no, doc_date, doc_ref, store_code, authorized_by_id, finalized_yn, gl_interfaced_yn, trn_type, sale_to_ext_yn, ext_agency_name

		ArrayList ALHdr=new ArrayList();
		try{
		ALHdr.add(getLoginFacilityId());
		ALHdr.add(getDoc_type_code());
	
		if(isDocNoAutoGenYN(getDoc_type_code()))
              setDoc_no(fetchNextDocNo(getDoc_type_code()));

		ALHdr.add(getDoc_no());
		ALHdr.add("1");
		ALHdr.add(getDoc_date());
		ALHdr.add(getDoc_ref());
		ALHdr.add(getFrom_store_code());
		ALHdr.add(getTo_store_code());
		ALHdr.add("Y");//finalized_yn
		ALHdr.add("N");//gl_interfaced_yn
		ALHdr.add(getTrn_type());
		ALHdr.add("N");//entry_completed_yn
		ALHdr.add("");//authorized_by_id
		ALHdr.add("N");//close_req_after_issue_yn
		ALHdr.add("");//remarks
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return ALHdr;

	}
	public String getSysDate()
	{
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());

		HashMap hmResult=new HashMap();
		try{
		hmResult=fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"),alParameters);
		}catch(Exception e)
		{e.printStackTrace();}
		return (String)hmResult.get("SYS_DATE");
	}


	public java.util.HashMap canAuthorize(String from_store_code) { 
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(login_by_id);

			//System.out.println("@@@@@from_store_code-->"+from_store_code);
			//from_store_code = null;

			sqlParameter.add(from_store_code);
		
			return fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_AUTHORIZE_SELECT"),sqlParameter);

		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	//Added for Doc Date Modify
	public void setDoc_DateModify(String doc_date_modify) {
		this.doc_date_modify=doc_date_modify;
	}

	public String getDoc_DateModify() {
		return this.doc_date_modify;
	}									

	public void setItem_ClassModify(String item_class_modify) {
		this.item_class_modify=item_class_modify;
	}

	public String getItem_ClassModify() {
		return this.item_class_modify;
	}								

	public void getDoc_Date_Details() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_STOCK_DOC_DATE_MODIFY_DETAIL"));
            pstmt.setString(1, trn_type);
            resultSet = pstmt.executeQuery();
			String item_class_modify_yn="";
			String doc_date_modify_yn ="";
            while (resultSet != null && resultSet.next()) {
                item_class_modify_yn = resultSet.getString(1);
				doc_date_modify_yn = resultSet.getString(2);
	           }
		
				setItem_ClassModify(item_class_modify_yn);
				setDoc_DateModify(doc_date_modify_yn);
        } 
	catch (Exception e) {
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

	}
	public java.util.ArrayList getOnStores(String req_by_store) {
			ArrayList result		=	new ArrayList();
		
		try {
			
			if(getFunctionId().equals("ST_REQUEST"))
			{
				String chkParameters[] = {login_facility_id,getLanguageId(),req_by_store};
				result = fetchRecords(StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE1"),chkParameters);
				
			}
			if(getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE"))
			{				
				String chkParameters[]={getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),req_by_store};
				result = fetchRecords(StRepository.getStKeyValue("SQL_ST_AUTH_AT_REQ_ON_STORE_SELECT"),chkParameters);
			
								
			}
			if(getFunctionId().equals("ST_ISSUE_RETURN"))
			{
				String chkParameters[]={getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),req_by_store};
				result = fetchRecords(StRepository.getStKeyValue("SQL_ST_ISSUE_RET_TO_STORE"),chkParameters);
				
			}
			if(getFunctionId().equals("ST_STOCK_TRANSFER"))
			{
				String chkParameters[]={getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),req_by_store};
				//Added for NMC-JD-CRF-0174  starts
				if(isSite_alna())
				{
					System.out.println("GetOn Store------new ->SQL_ST_STOCK_TO_STORE_DIFFERENT_FACILITYID");
					result = fetchRecords(StRepository.getStKeyValue("SQL_ST_STOCK_TO_STORE_DIFFERENT_FACILITYID"),chkParameters);
				}
				else
				{
					System.out.println("GetOn Store------old->SQL_ST_STOCK_TO_STORE");
				result = fetchRecords(StRepository.getStKeyValue("SQL_ST_STOCK_TO_STORE"),chkParameters);
				}
				//Added for NMC-JD-CRF-0174  ends
				
			}
			if(getFunctionId().equals("ST_PO_REQUEST_FN"))
			{
				String chkParameters[]={getLanguageId(),req_by_store};
				result = fetchRecords(StRepository.getStKeyValue("SQL_ST_MM_STORE_SELECT"),chkParameters);
				
			}


		}

         
		catch (Exception e) {
            e.printStackTrace();
        }
		
		return result;
	
	}
		
	public java.util.ArrayList getOnIssueStores(String req_on_store) throws Exception
	{
		ArrayList result		=	new ArrayList();
		String chkParameters[]={getAcc_entity_id(),login_facility_id,getLanguageId(),req_on_store};
		//Added for NMC-JD-CRF-0174  starts
		if(isSite_alna()&& trn_type.equals("URG"))
		{
			System.out.println("getOnIssueStores------new ->SQL_ST_ISSUE_REQ_URG_TO_STORE2");
			result= fetchRecords(StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE2"),chkParameters);
		}
		else{
			System.out.println("getOnIssueStores------old ->SQL_ST_ISSUE_REQ_URG_TO_STORE1");
		result = fetchRecords(StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_TO_STORE1"),chkParameters);}
		//Added for NMC-JD-CRF-0174  ends
		return result;
	}
	public String getItemClassDesc()
	{
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		String item_class_desc="";
        try {
			if(!(getItem_class_code().equals(""))){
				connection = getConnection();
				pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_SELECT"));
				pstmt.setString(1, getItem_class_code());
				pstmt.setString(2, getLanguageId());
				resultSet = pstmt.executeQuery();
				while (resultSet != null && resultSet.next()) {
					item_class_desc = resultSet.getString("short_desc");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
		    }
		}
		return item_class_desc;

	}
	
 }
