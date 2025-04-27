/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;
import java.util.*;
import java.io.*;
//import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import eMM.Common.* ;
import eCommon.Common.*;
//import eCommon.SingleTableHandler.*;

public class ItemMasterQueryBean extends MmAdapter implements Serializable {
	

	private String item_code="";
	private String short_desc="";
	private String alpha_code="";
	private String item_remarks="";
	private String pur_uom_code="";
	private String category="";
	private String eff_status="";
	private String spl_item="";
	private String ordercolmns="";
	private String trade_id="";
	private String trade_name="";
	private String sole_source="";
	private String ps_item="";
//	private String stock_uom="";
	private String item_analysis_1="";
	private String item_analysis_2="";
	private String item_analysis_3="";
	private String manufacturer="";
	private String Cons_item="";
	private String item_class="";
	private String searchby="";
	private String search_string="";
	private String consignment="";
	private String search_criteria="";
	private boolean search=true;
	private String medical_item_yn="";
	private boolean bSortDesc =false;
//	private String language;
	private ArrayList DataList=new ArrayList();
	
	public void setsearchby(String searchby) {
		 this.searchby = checkForNull(searchby);
	}

	public String getsearchby( ) {
		 return searchby;
	}

	public void setsearch_criteria(String search_criteria) {
		 this.search_criteria = checkForNull(search_criteria);
	}

	public String getsearch_criteria( ) {
		 return search_criteria;
	}

//public void setLanguageId(String language) {
	//	this.language = language;
//}
//public String getLanguageId() {
		//return this.language;
//	}

	public ArrayList getDataList(){
		return DataList ;
	}

	public void toggleSort(){
		bSortDesc =!bSortDesc ;
	}

	public boolean getSortDesc(){
		return bSortDesc ;
	}

	public void setItem_code(String item_code) {
		 this.item_code = checkForNull(item_code);
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setShort_desc(String short_desc) {
		 this.short_desc = checkForNull(short_desc);
	}

	public String getShort_desc( ) {
		 return short_desc;
	}

	public void setUOM(String pur_uom_code) {
		 this.pur_uom_code = checkForNull(pur_uom_code);
	}

	public String getUOM( ) {
		 return pur_uom_code;
	}

	public void setAlpha_code(String alpha_code) {
		 this.alpha_code = checkForNull(alpha_code);
	}

	public String getAlpha_code( ) {
		 return alpha_code;
	}

	public void setCategory(String category) {
		 this.category = checkForNull(category);

	}


	public void setManufacturer(String manufacturer) {
		 this.manufacturer = checkForNull(manufacturer);
	}

	public String getManufacturer( ) {
		 return manufacturer;
	}
	
	public void setCons_item(String Cons_item) {
		 this.Cons_item = checkForNull(Cons_item);
	}

	public String getCons_item( ) {
		 return Cons_item;
	}

	public void setMedical_item_yn(String medical_item_yn) {
		 this.medical_item_yn = checkForNull(medical_item_yn);
	}

	public String getMedical_item_yn( ) {
		 return medical_item_yn;
	}
	
	public void setsole_source(String sole_source) {
		 this.sole_source = checkForNull(sole_source);
	}

	public String getsole_source( ) {
		 return sole_source;
	}
	
	public void setItem_class(String item_class) {
		 this.item_class = checkForNull(item_class);
	}

	public String getItem_class( ) {
		 return item_class;
	}
	
	public void setItem_analysis_1(String item_analysis_1) {
		 this.item_analysis_1 = checkForNull(item_analysis_1);
	}

	public String getItem_analysis_1( ) {
		 return item_analysis_1;
	}
	
	public void setItem_analysis_2(String item_analysis_2) {
		 this.item_analysis_2 = checkForNull(item_analysis_2);
	}

	public String getItem_analysis_2( ) {
		 return item_analysis_2;
	}
	
	public void setItem_analysis_3(String item_analysis_3) {
		 this.item_analysis_3 = checkForNull(item_analysis_3);
	}

	public String getItem_analysis_3( ) {
		 return item_analysis_3;
	}
	
	
	public void setItem_remarks(String item_remarks) {
		 this.item_remarks = checkForNull(item_remarks);
	}

	public void setTrade_id(String trade_id) {
		 this.trade_id = checkForNull(trade_id);
	}

	public void setTrade_name(String trade_name) {
		 this.trade_name = checkForNull(trade_name);
	}
		 
	public String getItem_remarks( ) {
		 return item_remarks;
	}

	public String getTrade_id( ) {
		 return trade_id;
	}

	public String getTrade_name( ) {
		 return trade_name;
	}
			
	public void setOrdercolmns(String ordercolmns) {
		 this.ordercolmns = checkForNull(ordercolmns);
	}

	public String getOrdercolmns() {
		return ordercolmns ;
	}
	public void setSearch_string(String search_string) {
		 this.search_string = checkForNull(search_string);
	}

	public String getSearch_string() {
		 return search_string ;
	}

	public void setSearch(boolean search) {
		 this.search = search;
	}

	public boolean getSearch() {
		 return search ;
	}
	
	public void setConsignment(String consignment) {
		 this.consignment = consignment;
	}

	public String getConsignment() {
		 return consignment ;
	}
	
	public String getCategory( ) {

		 return category;
	}
	
	public void setPs_item(String ps_item) {
		 this.ps_item = checkForNull(ps_item);
	}

	public String getPs_item_yn( ) {
		 return ps_item;
	}
	
	public void setEff_status(String eff_status) {
		 this.eff_status = checkForNull(eff_status);

	}

	public String getEff_status( ) {
		 return eff_status;
	}
 
	public void setSpl_item(String spl_item) {
		 this.spl_item = checkForNull(spl_item);

	}

	public String getSpl_item( ) {
		 return spl_item;
	}


	public String getCategoryList()
	{
		
		return getStaticListOptionTag("A,Inventory;Y,Medical;N,Non Medical;",getCategory());
	}

	public String getSoleSourceList()
	{
		return getStaticListOptionTag("A,All;Y,Sole Source ;N,Non Sole Source ;",getsole_source());
	}

	public String getPSItemsList()
	{
		return getStaticListOptionTag("A,All;Y,PS Items;N,Non PS Items;",getPs_item_yn());
	}
	
	public String getEffStatuslist()
	{
		return getStaticListOptionTag("A,All;E,Enabled;D,Disabled;",getEff_status());
	}

	public String getSplitemList()
	{
		return getStaticListOptionTag("A,All;Y,Yes;N,No;",getSpl_item());
	}

	public String getMFGList()
	{
		return getStaticListOptionTag("A,All;Y,Manufacturing ;N,Non Manufacturing;",getCons_item());
	}

	public String getConsignmentList()
	{
		return getStaticListOptionTag("A,All;Y,Consignment ;N,Non Consignment");
	}
	
	public String YNAList()
	{
		return getStaticListOptionTag("A,All;Y,Yes;N,No;");
	}

	public String getItemClass(){
		//java.util.ArrayList alOptionValues = new java.util.ArrayList();
		ArrayList arr_lang=new ArrayList();
		//arr_lang.add(getLoginFacilityId());
		arr_lang.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_CLASS"),arr_lang),getItem_class());
	}
	public String getItemAnalysis(){
		//java.util.ArrayList alOptionValues = new java.util.ArrayList();
		ArrayList arr_lang=new ArrayList();
		//arr_lang.add(getLoginFacilityId());
		arr_lang.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_ANALYSIS"),arr_lang));
	}
	
	public String getManufacturerList(){
		ArrayList arr_lang=new ArrayList();
		//arr_lang.add(getLoginFacilityId());
		arr_lang.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(MmRepository.getMmKeyValue("SQL_MM_MANUFACTURER_SELECT"),arr_lang));
	}

	public void loadResultPage() throws Exception {
	 
		ArrayList alParameters=new ArrayList();
		alParameters.add(item_code         );
		alParameters.add(short_desc        );
		alParameters.add(alpha_code        );
		alParameters.add(trade_id          );
		alParameters.add(trade_name        );
//		alParameters.add(category          );
		alParameters.add(ps_item           );
		alParameters.add(ps_item           );
		alParameters.add(sole_source       );
		alParameters.add(sole_source	   );
		alParameters.add(manufacturer      );
		alParameters.add(manufacturer      );
		alParameters.add(item_class        );
		alParameters.add(item_class        );
		alParameters.add(item_analysis_1   );
		alParameters.add(item_analysis_1   );
		alParameters.add(item_analysis_2   );
		alParameters.add(item_analysis_2   );
		alParameters.add(item_analysis_3   );
		alParameters.add(item_analysis_3   );
		alParameters.add(item_remarks	   );
		alParameters.add(eff_status		   );
		alParameters.add(eff_status        );
		alParameters.add(spl_item        );
		alParameters.add(spl_item        );
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		
		ArrayList listRecord =new ArrayList();
		try {
			String stSQL=getMmRepositoryValue("SQL_MM_ITEM_MATRIALS_QUERY");
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			DataList=listRecord;
			} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
	}
	
	

	public void ascSort(String stColumnName,int start,int end){
		HashMap hmTemp;
		for (int i=start;i<end; i++ ) {
			for (int j=start;j<end-1; j++ ) {
				if ( ((String)((HashMap)DataList.get(j)).get(stColumnName)).compareTo(((String)((HashMap)DataList.get(j+1)).get(stColumnName)))>0 ) {
					hmTemp	=	(HashMap)DataList.get(j);
					DataList.set(j,(HashMap)DataList.get(j+1));
					DataList.set(j+1,hmTemp);
				}
			}
		}
	}
	public void descSort(String stColumnName,int start,int end){
		HashMap hmTemp;
		for (int i=start;i<end; i++ ) {
			for (int j=start;j<end-1; j++ ) {
				if ( ((String)((HashMap)DataList.get(j)).get(stColumnName)).compareTo(((String)((HashMap)DataList.get(j+1)).get(stColumnName)))<0 ) {
					hmTemp	=	(HashMap)DataList.get(j);
					DataList.set(j,(HashMap)DataList.get(j+1));
					DataList.set(j+1,hmTemp);
				}
			}
		}
	}
}
