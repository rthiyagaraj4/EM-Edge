/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common;

import eST.Common.StTransaction;
import java.io.Serializable;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StHeaderBean extends StTransaction implements Serializable {

	private String doc_ref	="";
    private String trn_type="";
    private String default_doc="";
    private String store_code="";
    private String store_desc="";
    private String doc_type_code="";
    private String doc_type_desc="";
    private String doc_date="";
    private String doc_no="";
    private String sys_date="";
    private String item_class_code="";
	private String item_class_madatory = "";
	//private String language_id = "";
	private String item_class_desc = "";

	private String item_class_modify;
    private String doc_date_modify;	
    private HashMap hmStParameter;
    private ArrayList alDocTypeListOption;
	//Added By Shaiju on 08/02/2011 starts
	private String slateUserId = "";
	public String module_id		= "ST";
	public String function_id		= "";
	// Added By Shaiju on 08/02/2011 Ends
   // private ArrayList alStoreCodeListOption;

	private String stSQLId = "";

	private String getStSQLId () {
		return this.stSQLId;
	}

	public void initialize(String trn_type) {
		try {
	        hmStParameter	=	getStParameter();
		    this.doc_type_code	=	checkForNull((String)hmStParameter.get("DEF_"+getDefault_doc()+"_DOC_TYPE_CODE"));
		    setDoc_type_code(checkForNull((String)hmStParameter.get("DEF_"+getDefault_doc()+"_DOC_TYPE_CODE")));
			if (!doc_type_code.equals("")) {
				ArrayList arr_language=new ArrayList();
				arr_language.add(doc_type_code);
				arr_language.add(getLanguageId());
				doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
		    }
			if (trn_type.equals("GRN")||trn_type.equals("RTV")){
				String tempStore_code		=	checkForNull((String)hmStParameter.get("DEF_STORE_CODE_FOR_REC"));
				if (!tempStore_code.equals("")) {
					store_code=tempStore_code;
					try { 
						HashMap hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),new String[]{getLoginById(), store_code});
						if (trn_type.equals("GRN")){
							if((hmRecord.get("GRN_ALLOWED_YN").toString().equals("Y")||hmRecord.get("GRN_FINALIZE_ALLOWED_YN").toString().equals("Y"))){
							}
							else
								store_code="";
						}
						else if (trn_type.equals("RTV")){
							if((hmRecord.get("RTV_ALLOWED_YN").toString().equals("Y")||hmRecord.get("RTV_FINALIZE_ALLOWED_YN").toString().equals("Y"))){
							}
							else
								store_code="";
						}
					}
					catch (Exception exception) {
							store_code="";
							exception.printStackTrace();
					}
				}
			}

			doc_date		=	hmStParameter.get("SYS_DATE").toString();
			doc_ref			=	"";
			doc_no			=	"";
			this.trn_type	=	trn_type;
			//initDoc_type_code_List();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
    }

	public boolean hasAllMandatoryValue()throws Exception {
		getDoc_Date_Details();

		return ((!checkForNull(store_code).equals(""))&&
				(!checkForNull(doc_type_code).equals(""))&&
				(!(checkForNull(doc_no).equals("")&& !isDocNoAutoGenYN(checkForNull(doc_type_code))) )&&
				(!checkForNull(doc_date).equals("")) &&
				(!(checkForNull(getItem_ClassModify()).equals("Y")	&& checkForNull(item_class_code).equals(""))));

				//(item_class_madatory.equals("Y"))  );
				//(getItem_ClassModify().equals("Y")) );
	}


//to be removed
	public void initialize(String trn_type, String doc_type_code, String doc_no, String doc_date, String doc_ref, String store_code) {
		this.doc_type_code	=	doc_type_code;
		this.doc_no			=	doc_no;
		this.store_code		=	store_code;
		this.doc_date		=	doc_date;
		this.doc_ref		=	doc_ref;
		this.trn_type		=	trn_type;
		this.item_class_code = item_class_code;
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

	public void initialize(String trn_type, String doc_type_code, String doc_no, String doc_date, String doc_ref, String store_code , String item_class_code) {
		this.doc_type_code	=	doc_type_code;
		this.doc_no			=	doc_no;
		this.store_code		=	store_code;
		this.doc_date		=	doc_date;
		this.doc_ref		=	doc_ref;
		this.trn_type		=	trn_type;
		this.item_class_code = item_class_code;
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
	
/*	public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id);
		 
	}

	public String getLanguageId() {
	 
		 return language_id;
	}*/

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = checkForNull(item_class_code);
		 }

	public String getItem_class_code() {
		return item_class_code;
	} 

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
	}

	public void setDefault_doc(String default_doc) {
		 this.default_doc = default_doc;
	}

	public String getDefault_doc() {
		 return default_doc;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

    public String getDoc_type_desc() {
		try {
			if(!(doc_type_code.equals(""))){
				ArrayList arr_language=new ArrayList();
				arr_language.add(doc_type_code);
				arr_language.add(getLanguageId());
				doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
			}else{
				doc_type_desc = "";
			}
		}
		catch(Exception exception ) {
			doc_type_desc = "";
			exception.printStackTrace();
		}
		return doc_type_desc;
    }

	public void setDoc_type_desc(String doc_type_desc) {
		this.doc_type_desc=doc_type_desc;
	}
	public void setItem_class_desc(String item_class_desc) {
		 this.item_class_desc = item_class_desc;
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
    public String getStore_desc() {
		store_desc="";
		try {
			if(!(checkForNull(store_code).equals(""))){
				ArrayList arr_language=new ArrayList();
				arr_language.add(checkForNull(store_code));
				arr_language.add(getLanguageId());
				store_desc=fetchRecord(getStRepositoryValue("SQL_ST_OPENING_STOCK_STORE"), arr_language).get("SHORT_DESC").toString() ;
			}
		}
		catch(Exception exception ) {
			store_desc = "";
			exception.printStackTrace();
		}
		return store_desc;
    }

    public void setDoc_type_code(String s) {
        doc_type_code = s;
    }

    public String getDoc_type_code() {
        return doc_type_code;
    }

    public void setDoc_date(String s) {
        doc_date = s;	

    }

    public String getDoc_date() {
        return doc_date;
    }

	public void initDoc_type_code_List() {
		
        ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getTrn_type());	
        arraylist.add(getLanguageId());
	alDocTypeListOption=getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST_HDR"), arraylist);
		
		if (checkForNull(getDoc_type_code()).equals("")) {			
			if(alDocTypeListOption.size()>1)
				setDoc_type_code( ((String[])alDocTypeListOption.get(1))[0] );
			}
	}


	public String getDoc_type_code_List() {
		return getListOptionTag(alDocTypeListOption, getDoc_type_code());
   }

	public void initStore_code_List(String stSQLId) {
		this.stSQLId = stSQLId;
		ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
       //Added By Shaiju on 08/02/2011 Starts
		if(getModuleId().equals("OT"))
		{
			arraylist.add(getSlateUserId()); 
		}
		else
		{
        arraylist.add(getLoginById());
		}
		//Added By Shaiju on 08/02/2011 Ends
        arraylist.add(getLanguageId());
		try {
			
			boolean foundInList=false;
			if (!getMode().equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
				if (trn_type.equals("GRN")){
					ArrayList	alRecords	=	fetchRecords(getStRepositoryValue(stSQLId), arraylist);
					for (int i=0;i<alRecords.size() && (!foundInList) ;i++ ) {
						HashMap hmRecord	=	(HashMap)alRecords.get(i);
						foundInList=(hmRecord.get("STORE_CODE").toString().equals(store_code));
					}
				}
				if (!foundInList) {
					
					store_code		=	(String)fetchRecord(getStRepositoryValue(stSQLId), arraylist).get("STORE_CODE");
			
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}


//        alStoreCodeListOption=getListOptionArrayList(getStRepositoryValue(stSQLId), arraylist);
	}

	public String getStore_code_List() {
		String sql = eST.Common.StRepository.getStKeyValue(getStSQLId());
		
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLoginFacilityId());
		//Added By Shaiju on 08/02/2011 Starts
		if(getModuleId().equals("OT"))
		{
			sqlParam.add(getSlateUserId()); 
		}
		else
		{
		sqlParam.add(getLoginById());
		}
		//Added By Shaiju on 08/02/2011 Ends
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getStore_code());
    }


	public void initialize()
	{
		super.initialize();
		hmStParameter = new HashMap( );
		alDocTypeListOption = new ArrayList( ); 
//		alStoreCodeListOption  = new ArrayList( );
		doc_ref="";
		trn_type="";
		store_code="";

		store_desc="";
		doc_type_code="";
		doc_type_desc="";
		doc_date="";
		doc_no="";
		item_class_code="";
		
		default_doc = "";

	}

    public void clear() {
		
        super.clear();
		doc_ref="";
		trn_type="";
		store_code="";

		store_desc="";
		doc_type_code="";
		doc_type_desc="";
		doc_date="";
		doc_no="";
		item_class_code="";
		
		default_doc = "";
		hmStParameter=null;
		alDocTypeListOption=null;
//		alStoreCodeListOption=null;
    }
	public String toString() {
		return
		doc_ref+
		trn_type+
		store_code+
		store_desc+
		item_class_code+
		doc_type_code+
		doc_date+
		doc_no+
			alDocTypeListOption;
	}

	public ArrayList toArrayListOBS() {
		//facility_id, doc_type_code, doc_no, doc_date, doc_ref, store_code, authorized_by_id, finalized_yn, gl_interfaced_yn, trn_type, sale_to_ext_yn, ext_agency_name
		ArrayList ALHdr=new ArrayList();
		try{
			ALHdr.add(getLoginFacilityId());
			ALHdr.add(getDoc_type_code());
			if(isDocNoAutoGenYN(getDoc_type_code())) {
				setDoc_no(fetchNextDocNo(getDoc_type_code()));
			}
			ALHdr.add(getDoc_no());
			ALHdr.add(getDoc_date());
			ALHdr.add(getDoc_ref());
			ALHdr.add(getStore_code());
			ALHdr.add("");//authorised_by
			ALHdr.add("Y");//finalized_yn
			ALHdr.add("N");//gl_interfaced_yn
			ALHdr.add(getTrn_type());
			ALHdr.add("N");//sale_to_external_yn
			ALHdr.add("");//ext_agency_name
			ALHdr.add(getItem_class_code());
		}
        catch(Exception exception) {
            exception.printStackTrace();
        }
		return ALHdr;
	}


	public ArrayList toArrayListADJ() {
		ArrayList ALHdr=new ArrayList();
		try{
			ALHdr.add(getLoginFacilityId());
			ALHdr.add(getDoc_type_code());
			ALHdr.add(getDoc_no());
			ALHdr.add(getDoc_date());
			ALHdr.add(getDoc_ref());
			ALHdr.add(getStore_code());
			ALHdr.add("");//authorised_by
			ALHdr.add("Y");//finalized_yn
			ALHdr.add("N");//gl_interfaced_yn
			ALHdr.add(getTrn_type());
			ALHdr.add("N");//sale_to_external_yn
			ALHdr.add("");//ext_agency_name
		}
        catch(Exception exception) {
            exception.printStackTrace();
        }
		return ALHdr;
	}



	public String getSysDate() {
/*		
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add("ALL");
	*/
		//HashMap hmResult=new HashMap();

		try {
//			hmResult=fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"),alParameters);
			sys_date=(String)getStParameter().get("SYS_DATE");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sys_date;
	}


	//Added for Doc Date Modify


	public void setItem_class_madatory(String item_class_madatory)
	{
		this.item_class_madatory=item_class_madatory;
	}

	public String getItem_class_madatory()
	{
		return item_class_madatory;
	}

	public String getItemClass() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(checkForNull(getStore_code()));
		sqlParam.add(checkForNull(getStore_code()));
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,checkForNull(getItem_class_code()));
	}

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

	public ArrayList getItemClasses(String request_by_store,String request_on_store)throws Exception {
		String [] stParameters	=	{request_by_store,request_on_store,getLanguageId()};
		return fetchRecords(StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST"),stParameters);
/*		

        ArrayList itemClasses = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST"));
            pstmt.setString(1, request_by_store);
            pstmt.setString(2, request_on_store);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                itemClasses.add(record);
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
            }
			catch(Exception es){
				es.printStackTrace();
            }
        }
        return itemClasses;*/
	}

	
	// Doc Date Modify Ended

	//Added By Shaiju on 08/02/2011 Starts
	
	public void setModuleId(String module_id) {
		 this.module_id= checkForNull(module_id);  
	}

	public String getModuleId( ) {
		 return this.module_id;
	}


//ADDED ON 7/12/2011
public void setfunction_id(String function_id) {
		 this.function_id= checkForNull(function_id);  
	}

	public String getfunction_id( ) {
		 return this.function_id;
	}

//ENDED

	public void setSlateUserId(String slateUserId){
		this.slateUserId = slateUserId;
	}

	public String getSlateUserId()
	{
		return this.slateUserId;
	}


   // Added By Shaiju on 08/02/2011 Ends
 }
