/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
//* pmd 21/02/2005
//*import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class RTVHistoryBean extends StAdapter implements Serializable{

	private String item_code="";
	private String supp_code="";
	private String fm_doc_date="";
	private String to_doc_date="";
	private String finalized_yn="";
	private String store_code="";
	private String replace_on_expiry_yn="";
	//private String language;

	private ArrayList DataList=new ArrayList();


	public String getSupplierList()
		{
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LIST_WT_LANG"),getLanguageId()));
		}
	public String getStore_code_List()
		{
			String chkParameters[] ={getLoginFacilityId(),getLanguageId()};
			return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST_WT_LANG"),chkParameters));
		}

//public void setLanguageId(String language) {
	//	this.language = language;
	//}
//public String getLanguageId() {
	//	return this.language;
	//f}

	public void setItem_code(String item_code) 
		{
		 this.item_code = checkForNull(item_code);
		}
	public String getItem_code( ) 
		{
		 return item_code;
		}
	public void setSupp_code(String supp_code) 
		{
		 this.supp_code = checkForNull(supp_code);
		}
	public String getSupp_code( ) 
		{
		 return supp_code;
		}
	public void setFm_doc_date(String fm_doc_date) 
		{
		 this.fm_doc_date = checkForNull(fm_doc_date);
		}
	public String getFm_doc_date( ) 
		{
		 return fm_doc_date;
		}
	public void setTo_doc_date(String to_doc_date) 
		{
		 this.to_doc_date = checkForNull(to_doc_date);
		}
	public String getTo_doc_date( ) 
		{
		 return to_doc_date;
		}
	public void setFinalized_yn(String finalized_yn) 
		{
		 this.finalized_yn = checkForNull(finalized_yn);
		}
	public String getFinalized_yn( ) 
		{
		 return finalized_yn;
		}
	public void setStore_code(String store_code) 
		{
		 this.store_code = checkForNull(store_code);
		}
	public String getStore_code( ) 
		{
		 return store_code;
		}
	public void setReplace_on_expiry_yn(String replace_on_expiry_yn) 
		{
		 this.replace_on_expiry_yn = checkForNull(replace_on_expiry_yn);
		}
	public String getReplace_on_expiry_yn( ) 
		{
		 return replace_on_expiry_yn;
		}
	public ArrayList getDataList()
		{
		 return DataList ;
		}

	public void loadResultPage() throws Exception {
	 
		ArrayList alParameters=new ArrayList();
		
		alParameters.add(item_code);
		alParameters.add(supp_code);
		alParameters.add(fm_doc_date);
		alParameters.add(to_doc_date);
		alParameters.add(finalized_yn);
		alParameters.add(finalized_yn);
		alParameters.add(replace_on_expiry_yn);
		alParameters.add(replace_on_expiry_yn);
		alParameters.add(store_code);
		
		ArrayList listRecord =new ArrayList();
		try {
			String stSQL=getStRepositoryValue("ST_SQL_RTV_HISTORY");
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
}
