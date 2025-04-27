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
25/05/2017				IN063603				B.Badmavathi								      			GHL-CRF-0456
18/01/2021              TFSID:-12813            Haribabu                                                    MOHE-SCF-0070
05/05/2021  	        TFS id:-16404           Haribabu	      05/05/2021	 	 Manickavasagam J          MOHE-SCF-0096
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eST;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
import eMM.Common.* ;
import java.sql.*;
//import eCommon.SingleTableHandler.*;

public class ItemSearchBean extends StAdapter implements Serializable {
	
	private String item_code="";
	private String short_desc="";
	private String alpha_code="";
	private String machine_code="";
	private String spare_part_id="";
	private String abc_analysis="";
	private String category="";
	private String ordercolmns="";
	private String trade_id="";
	private String trade_name="";
	private String sole_source_yn="";
	private String ps_item_yn="";
//	private String language_id="";
//	private String stock_uom="";
	private String item_analysis_1="";
	private String item_analysis_2="";
	private String item_analysis_3="";
	private String manufacturer="";
	private String mfg_item="";
	private String expiry="";
	private String item_class="";
	private String search_string="";
	private String consignment="";
	private String chkitemstorecmb="";
	private String store_code="";
	private String to_store_code="";
	private String item_class_desc="";
	private String store_desc="";
	private String order_by="";
	private String direct_sale="";
	private boolean search=true;
	private String medical_item_yn="";
	private boolean bSortDesc =false;

	private ArrayList DataList=new ArrayList();
	private ArrayList KitDataList=new ArrayList();
	private ArrayList itemsearch_param=new ArrayList();
	//Added for GHL-CRF-0456 starts
	private String trn_type="";
		public String getTrn_type() {
		return trn_type;
	}
	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}
	//Added for GHL-CRF-0456 ends
	public ArrayList getDataList(){
		return DataList ;
	}

	public ArrayList getKitDataList(){
		return KitDataList ;
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
	public void setAlpha_code(String alpha_code) {
		 this.alpha_code = checkForNull(alpha_code);
	}

	public String getAlpha_code( ) {
		 return alpha_code;
	}
	
	public void setStore_desc(String store_desc) {
		 this.store_desc = checkForNull(store_desc);
	}
	public void setItem_class_Desc() {
		 this.item_class_desc = checkForNull(item_class_desc);
	}
	public String getStore_desc( ) {
		 return store_desc;
	}

	
	public void setCategory(String category) {
		 this.category = checkForNull(category);
	}

	public String getCategory( ) {
		 return category;
	}
	public void setSpare_part_id(String spare_part_id) {
		 this.spare_part_id = checkForNull(spare_part_id);
	}

	public String getSpare_part_id( ) {
		 return spare_part_id;
	}

	public void setAbc_analysis(String abc_analysis) {
		 this.abc_analysis = checkForNull(abc_analysis);
	}

	public String getAbc_analysis( ) {
		 return abc_analysis;
	}
	public String getItem_class_Desc() {
		return item_class_desc;
	}
	public void setManufacturer(String manufacturer) {
		 this.manufacturer = checkForNull(manufacturer);
	}

	public String getManufacturer( ) {
		 return manufacturer;
	}
	
	public void setMfg_item(String mfg_item) {
		 this.mfg_item = checkForNull(mfg_item);
	}

	public String getMfg_item( ) {
		 return mfg_item;
	}
/*	public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id);
	}

	public String getLanguageId( ) {
		 return language_id;
	}
	*/
	public void setOrderBy(String order_by){
		 this.order_by = checkForNull(order_by);
	}
	public String getOrderBy( ) {
		 return order_by;
	}

	public void setExpiry(String expiry) {
		 this.expiry = checkForNull(expiry);
	}

	public String getExpiry( ) {
		 return expiry;
	}

	public void setMedical_item_yn(String medical_item_yn) {
		 this.medical_item_yn = checkForNull(medical_item_yn);
	}

	public String getMedical_item_yn( ) {
		 return medical_item_yn;
	}
	
	public void setSole_source_yn(String sole_source_yn) {
		 this.sole_source_yn = checkForNull(sole_source_yn);
	}

	public void setStore_code(String store_code) {
		 this.store_code = checkForNull(store_code);
	}

	public String getStore_code( ) {
		 return store_code;
	}
	public void setTo_Store_code(String to_store_code) {
		 this.to_store_code = checkForNull(to_store_code);
	}

	public String getTo_Store_code( ) {
		 return to_store_code;
	}
	public String getSole_source_yn( ) {
		 return sole_source_yn;
	}
	
	public void setPs_item_yn(String ps_item_yn) {
		 this.ps_item_yn = checkForNull(ps_item_yn);
	}

	public String getPs_item_yn( ) {
		 return ps_item_yn;
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
	
	
	public void setMachine_code(String machine_code) {
		 this.machine_code = checkForNull(machine_code);
	}

	public void setTrade_id(String trade_id) {
		 this.trade_id = checkForNull(trade_id);
	}

	public void setTrade_name(String trade_name) {
		 this.trade_name = checkForNull(trade_name);
	}
		 
	public String getMachine_code( ) {
		 return machine_code;
	}
			
	public void setOrdercolmns(String ordercolmns) {
		 this.ordercolmns = checkForNull(ordercolmns);
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
	public void setDirectSale(String direct_sales) {
		 this.direct_sale = direct_sales;
	}
	
	public void setConsignment(String consignment) {
		 this.consignment = consignment;
	}

	public void setitemsearchparam(ArrayList itemsearch_param) {
		 this.itemsearch_param = itemsearch_param;
	}


	public String getConsignment() {
		 return consignment ;
	}
	

	public String getABCAnalysis()
	{
		return getStaticListOptionTag("A,A;B,B;C,C;",getAbc_analysis(),true);
	}

	public String getExpiryList()
	{
		return getStaticListOptionTag("A,All;Y,Expiry Items;N,Non-Expiry Items;",getExpiry());
	}

	public String getCategoryList()
	{
		return getStaticListOptionTag("A,All;Y,Medical;N,Non Medical;",getCategory());
	}

	public String getSoleSourceList()
	{
		return getStaticListOptionTag("A,All;Y,Sole Source ;N,Non Sole Source ;",getSole_source_yn());
	}

	public String getPSItemsList()
	{
		return getStaticListOptionTag("A,All;Y,PS Items;N,Non PS Items;",getPs_item_yn());
	}

	public String getMFGList()
	{
		return getStaticListOptionTag("A,All;Y,Manufacturing ;N,Non Manufacturing;",getMfg_item());
	}

	public String getConsignmentList()
	{
		return getStaticListOptionTag("A,All;Y,Consignment ;N,Non Consignment");
	}
	
	public String YNAList()
	{
		return getStaticListOptionTag("A,All;Y,Yes;N,No;");
	}

	public void setChkItemStoreCombination(String chkitemstorecmb) {
		 this.chkitemstorecmb = checkForNull(chkitemstorecmb);
	}

	public String getChkItemStoreCombination() {
		 return chkitemstorecmb ;
	}

	public String getItemClass(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS"),getLanguageId()));
	}
	public String getItemAnalysis(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"),getLanguageId()));
	}
	
	public String getManufacturerList(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_SEARCH_MANUFACTURER"),getLanguageId()));
	}

	public ArrayList getitemsearchparam( ) {
		 return itemsearch_param;
	}


	public boolean  isSSIVModuleInstalled() throws Exception
		{
		
		HashMap		hmSSIV		=	null;	
		ArrayList	arrSSIV		=	new  ArrayList();
		String		IV			=	"";
		boolean		flag		=	false;

        eMM.MM_license_rights rights = new eMM.MM_license_rights();
		hmSSIV	=	new HashMap();
		hmSSIV.put("IV",checkForNull(rights.getSTboundary()));
		hmSSIV.put("SS",checkForNull(rights.getSSboundary()));
		hmSSIV.put("PO",checkForNull(rights.getPOboundary()));
		arrSSIV.add(hmSSIV);


			int arrLen	=	arrSSIV.size();
			for(int i=0;i<arrLen; i++)
			{
				hmSSIV		=	(HashMap) arrSSIV.get(i);
				IV			=	(String)hmSSIV.get("IV");//"I
			}

			if(IV.equals("I")){
				flag = true;
				
			}else{
				flag = false;
			}

			return flag;

		}
		
	


	public void loadResultPage() throws Exception {

		ArrayList alParameters=new ArrayList();
		alParameters.add(item_code              );
		alParameters.add(short_desc             );
		alParameters.add(alpha_code            );
		alParameters.add(machine_code       );
		alParameters.add(spare_part_id        );
		alParameters.add(trade_id                  );
		alParameters.add(trade_name           );
		alParameters.add(abc_analysis          );
		alParameters.add(abc_analysis          );
		alParameters.add(category                 );
		alParameters.add(category                 );
		alParameters.add(ps_item_yn            );
		alParameters.add(ps_item_yn            );
		alParameters.add(sole_source_yn     );
		alParameters.add(sole_source_yn     );
		alParameters.add(manufacturer         );
		alParameters.add(manufacturer         );
		alParameters.add(mfg_item                );
		alParameters.add(mfg_item                );
		alParameters.add(item_class              );
		alParameters.add(item_class              );
	
		alParameters.add(item_analysis_1   );
		alParameters.add(item_analysis_1   );
		alParameters.add(item_analysis_2   );
		alParameters.add(item_analysis_2   );
		alParameters.add(item_analysis_3   );
		alParameters.add(item_analysis_3   );
		alParameters.add(expiry                      );
		alParameters.add(expiry                      );
		alParameters.add(store_code           );
		if (getChkItemStoreCombination().equals("Y"))
		{
		alParameters.add(to_store_code     );
		}
		alParameters.add(consignment         );
		alParameters.add(consignment         );
		
		//========================================================
		

		ArrayList listRecord =new ArrayList();
		ArrayList item_search_param =new ArrayList();
		try {
				String stSQL = "";
				if ( getitemsearchparam()!=  null   ) // 10/3/2005  by RAM.. used when array parameter is passed for item search 
				{
					item_search_param = getitemsearchparam();
				}
				if(isSSIVModuleInstalled())
					{
							alParameters.add(login_by_id);
							// Modified on 9/30/2005  for calling item search query based upon the function
							if (item_search_param !=  null && item_search_param.size()>0){
								if (item_search_param.get(0).equals("ST_ASSEMBLY_DTL")){
										if(store_code.equals("%")){
										stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_C_INV_FOR_ASSM_DTL")+getOrderBy();
									}else{
										stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_C_INV_FOR_ASSM_DTL_STORE")+getOrderBy();
									}
								}else if(item_search_param.get(0).equals("ST_MANUFACTURING_REQUEST")){
									//alParameters.add(checkForNull((String)item_search_param.get(1)) );
									//alParameters.add(checkForNull((String)item_search_param.get(2)) );
									alParameters.add(((String)item_search_param.get(1)).equals( "A")?"%": (String)item_search_param.get(1)) ;
									alParameters.add(((String)item_search_param.get(2)).equals("A")?"%": (String)item_search_param.get(2)) ;
									stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_C_INV_FOR_MFG_REQ")+getOrderBy();;
								}
							}else{
								if (getChkItemStoreCombination().equals("Y")){ 
									//stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_C_INV_ITM_CMB_CHK")+getOrderBy();
									//stSQL="SELECT	 DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE,A.EXPIRY_YN,B.ALPHA_CODE,B.ITEM_CLASS_CODE,B.SHORT_DESC ITEM_DESC,C.SHORT_DESC ITEM_CLASS_DESC,A.MFG_BASE_QTY,A.MACHINE_CODE,A.MIN_STK_QTY,A.MAX_STK_QTY,B.LONG_DESC,B.PS_ITEM_YN,B.SOLE_SOURCE_YN,B.MANUFACTURER_ID,B.GEN_UOM_CODE,B.UNIT_COST,DECODE (?,NULL, D.SHORT_DESC,J.SHORT_DESC) UOM_DESC,E.SHORT_NAME MANUFACTURE_DESC,A.SPARE_PART_ID,A.MFG_ITEM_YN,A.MEDICAL_ITEM_YN,A.ABC_CLASS_CODE ,A.TRADE_ID_APPLICABLE_YN ,A.BATCH_ID_APPLICABLE_YN,A.CONSIGNMENT_ITEM_YN, D.SHORT_DESC GEN_UOM_DESC,H.DEF_REQUEST_UOM FROM ST_ITEM A,MM_ITEM_LANG_VW B,MM_ITEM_CLASS_LANG_VW C,AM_UOM_LANG_VW D,AM_MANUFACTURER_LANG_VW E,MM_TRADE_NAME_FOR_ITEM F,AM_TRADE_NAME_LANG_VW G,ST_ITEM_STORE H,ST_ITEM_STORE I,AM_UOM_LANG_VW J,ST_ACC_ENTITY_PARAM K WHERE A.ITEM_CODE=B.ITEM_CODE AND B.EFF_STATUS='E'  AND NVL(H.EFF_STATUS,'E') = 'E' AND  B.ITEM_CLASS_CODE=C.ITEM_CLASS_CODE(+) AND B.GEN_UOM_CODE=D.UOM_CODE(+) AND B.MANUFACTURER_ID=E.MANUFACTURER_ID(+) AND A.ITEM_CODE=F.ITEM_CODE(+) AND F.TRADE_ID=G.TRADE_ID(+)  AND A.ITEM_CODE=H.ITEM_CODE(+)	AND A.ITEM_CODE=I.ITEM_CODE(+)	/*AND H.QTY_ON_HAND > 0 */	AND UPPER(A.ITEM_CODE) LIKE	UPPER(NVL(?,'%')) AND UPPER(B.SHORT_DESC) LIKE UPPER(NVL(?,'%')) AND UPPER(B.ALPHA_CODE) LIKE UPPER(NVL(?,'%'))	AND	UPPER(NVL(A.MACHINE_CODE,'%')) LIKE	UPPER(NVL(?,'%'))  AND UPPER(NVL(A.SPARE_PART_ID,'%')) LIKE	UPPER(NVL(?,'%')) AND  UPPER(NVL(F.TRADE_ID,'%'))  LIKE	UPPER(NVL(?,'%'))  AND	UPPER(NVL(G.SHORT_NAME,'%')) LIKE UPPER(NVL(?,'%'))	AND NVL(A.ABC_CLASS_CODE,'%') LIKE	DECODE(?,'','%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE(?,'A','%',?) AND B.PS_ITEM_YN LIKE	DECODE(?,'A','%',?)	AND	B.SOLE_SOURCE_YN LIKE DECODE(?,'A','%',?) AND NVL(B.MANUFACTURER_ID,'%')LIKE DECODE(?,'','%',?)	 AND A.MFG_ITEM_YN LIKE	DECODE(?,'A','%',?)	AND	NVL(B.ITEM_CLASS_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?)	AND	A.EXPIRY_YN	LIKE DECODE(?,'A','%',?) AND NVL(H.STORE_CODE,'%') LIKE	  UPPER(NVL(?,'%'))     AND NVL(I.STORE_CODE,'%') LIKE  UPPER(NVL(?,'%'))	 	AND A.CONSIGNMENT_ITEM_YN LIKE	DECODE(?,'A','%',?)	AND (MATERIAL_GROUP_CODE IN (SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E') ) AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = C.LANGUAGE_ID(+) AND B.LANGUAGE_ID = D.LANGUAGE_ID(+) AND B.LANGUAGE_ID = E.LANGUAGE_ID(+)  AND H.DEF_ISSUE_UOM = J.UOM_CODE(+) AND G.LANGUAGE_ID(+) = ?  AND J.LANGUAGE_ID(+) = ? AND K.ACC_ENTITY_ID = 'ZZ'"+getOrderBy();
									//Modified by sakti against AMS-CRF-0028
									//stSQL="SELECT	 DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE,A.EXPIRY_YN,B.ALPHA_CODE,B.ITEM_CLASS_CODE,B.SHORT_DESC ITEM_DESC,C.SHORT_DESC ITEM_CLASS_DESC,A.MFG_BASE_QTY,A.MACHINE_CODE,A.MIN_STK_QTY,A.MAX_STK_QTY,B.LONG_DESC,B.PS_ITEM_YN,B.SOLE_SOURCE_YN,B.MANUFACTURER_ID,B.GEN_UOM_CODE,B.UNIT_COST,DECODE (?,NULL, D.SHORT_DESC,J.SHORT_DESC) UOM_DESC,E.SHORT_NAME MANUFACTURE_DESC,A.SPARE_PART_ID,A.MFG_ITEM_YN,A.MEDICAL_ITEM_YN,A.ABC_CLASS_CODE ,A.TRADE_ID_APPLICABLE_YN ,A.BATCH_ID_APPLICABLE_YN,A.CONSIGNMENT_ITEM_YN, D.SHORT_DESC GEN_UOM_DESC,H.DEF_REQUEST_UOM,(SELECT nvl(SUM (qty_on_hand),0)  FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code)  qty_on_hand,(SELECT (  nvl(SUM (qty_on_hand),0)- nvl(SUM (committed_qty),0) ) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) available_qty FROM ST_ITEM A,MM_ITEM_LANG_VW B,MM_ITEM_CLASS_LANG_VW C,AM_UOM_LANG_VW D,AM_MANUFACTURER_LANG_VW E,MM_TRADE_NAME_FOR_ITEM F,AM_TRADE_NAME_LANG_VW G,ST_ITEM_STORE H,ST_ITEM_STORE I,AM_UOM_LANG_VW J,ST_ACC_ENTITY_PARAM K WHERE A.ITEM_CODE=B.ITEM_CODE AND B.EFF_STATUS='E'  AND NVL(H.EFF_STATUS,'E') = 'E' AND  B.ITEM_CLASS_CODE=C.ITEM_CLASS_CODE(+) AND B.GEN_UOM_CODE=D.UOM_CODE(+) AND B.MANUFACTURER_ID=E.MANUFACTURER_ID(+) AND A.ITEM_CODE=F.ITEM_CODE(+) AND F.TRADE_ID=G.TRADE_ID(+)  AND A.ITEM_CODE=H.ITEM_CODE(+)	AND A.ITEM_CODE=I.ITEM_CODE(+)	/*AND H.QTY_ON_HAND > 0 */	AND UPPER(A.ITEM_CODE) LIKE	UPPER(NVL(?,'%')) AND UPPER(B.SHORT_DESC) LIKE UPPER(NVL(?,'%')) AND UPPER(B.ALPHA_CODE) LIKE UPPER(NVL(?,'%'))	AND	UPPER(NVL(A.MACHINE_CODE,'%')) LIKE	UPPER(NVL(?,'%'))  AND UPPER(NVL(A.SPARE_PART_ID,'%')) LIKE	UPPER(NVL(?,'%')) AND  UPPER(NVL(F.TRADE_ID,'%'))  LIKE	UPPER(NVL(?,'%'))  AND	UPPER(NVL(G.SHORT_NAME,'%')) LIKE UPPER(NVL(?,'%'))	AND NVL(A.ABC_CLASS_CODE,'%') LIKE	DECODE(?,'','%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE(?,'A','%',?) AND B.PS_ITEM_YN LIKE	DECODE(?,'A','%',?)	AND	B.SOLE_SOURCE_YN LIKE DECODE(?,'A','%',?) AND NVL(B.MANUFACTURER_ID,'%')LIKE DECODE(?,'','%',?)	 AND A.MFG_ITEM_YN LIKE	DECODE(?,'A','%',?)	AND	NVL(B.ITEM_CLASS_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?)	AND	A.EXPIRY_YN	LIKE DECODE(?,'A','%',?) AND NVL(H.STORE_CODE,'%') LIKE	  UPPER(NVL(?,'%'))     AND NVL(I.STORE_CODE,'%') LIKE  UPPER(NVL(?,'%'))	 	AND A.CONSIGNMENT_ITEM_YN LIKE	DECODE(?,'A','%',?)	AND (MATERIAL_GROUP_CODE IN (SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E') ) AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = C.LANGUAGE_ID(+) AND B.LANGUAGE_ID = D.LANGUAGE_ID(+) AND B.LANGUAGE_ID = E.LANGUAGE_ID(+)  AND H.DEF_ISSUE_UOM = J.UOM_CODE(+) AND G.LANGUAGE_ID(+) = ?  AND J.LANGUAGE_ID(+) = ? AND K.ACC_ENTITY_ID = 'ZZ'"+getOrderBy();
									//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
									stSQL="SELECT DISTINCT DECODE (disp_decimal_dtls_yn, 'Y', allow_decimals_yn, 'N' ) allow_decimals_yn, DECODE (disp_decimal_dtls_yn, 'Y', no_of_decimals, 0 ) no_of_decimals, a.item_code, a.expiry_yn, b.alpha_code, b.item_class_code, b.short_desc item_desc, c.short_desc item_class_desc, a.mfg_base_qty, a.machine_code, a.min_stk_qty, a.max_stk_qty, b.long_desc, b.ps_item_yn, b.sole_source_yn, b.manufacturer_id, b.gen_uom_code, b.unit_cost, DECODE (?, NULL, d.short_desc, j.short_desc) uom_desc, e.short_name manufacture_desc, a.spare_part_id, a.mfg_item_yn, a.medical_item_yn, a.abc_class_code, a.trade_id_applicable_yn, a.batch_id_applicable_yn, a.consignment_item_yn, d.short_desc gen_uom_desc, h.def_request_uom, (SELECT NVL (SUM (qty_on_hand), 0) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) qty_on_hand, (SELECT (  NVL (SUM (qty_on_hand), 0) - NVL (SUM (committed_qty), 0) ) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) available_qty, (  NVL (h.max_stk_qty, 0) * st_get_uom_conv_fac_sing_str (h.item_code, h.store_code) ) max_str_qty, (  NVL (h.min_stk_qty, 0) * st_get_uom_conv_fac_sing_str (h.item_code, h.store_code) ) min_str_qty, (  NVL (h.reorder_level, 0) * st_get_uom_conv_fac_sing_str (h.item_code, h.store_code) ) reorder_level FROM st_item a, mm_item_lang_vw b, mm_item_class_lang_vw c, am_uom_lang_vw d, am_manufacturer_lang_vw e, mm_trade_name_for_item f, am_trade_name_lang_vw g, st_item_store h, st_item_store i, am_uom_lang_vw j, st_acc_entity_param k WHERE a.item_code = b.item_code AND b.eff_status = 'E' AND NVL (h.eff_status, 'E') = 'E' AND b.item_class_code = c.item_class_code(+) AND b.gen_uom_code = d.uom_code(+) AND b.manufacturer_id = e.manufacturer_id(+) AND a.item_code = f.item_code(+) AND f.trade_id = g.trade_id(+) AND a.item_code = h.item_code(+) AND a.item_code = i.item_code(+) /*AND H.QTY_ON_HAND > 0 */ AND UPPER (a.item_code) LIKE UPPER (NVL (?, '%')) AND UPPER (b.short_desc) LIKE UPPER (NVL (?, '%')) AND UPPER (b.alpha_code) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (a.machine_code, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (a.spare_part_id, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (f.trade_id, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (g.short_name, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (a.abc_class_code, '%') LIKE DECODE (?, '', '%', ?) AND a.medical_item_yn LIKE DECODE (?, 'A', '%', ?) AND b.ps_item_yn LIKE DECODE (?, 'A', '%', ?) AND b.sole_source_yn LIKE DECODE (?, 'A', '%', ?) AND NVL (b.manufacturer_id, '%') LIKE DECODE (?, '', '%', ?) AND a.mfg_item_yn LIKE DECODE (?, 'A', '%', ?) AND NVL (b.item_class_code, '%') LIKE DECODE (?, '', '%', ?) AND NVL (b.item_anal1_code, '%') LIKE DECODE (?, '', '%', ?) AND NVL (b.item_anal2_code, '%') LIKE DECODE (?, '', '%', ?) AND NVL (b.item_anal3_code, '%') LIKE DECODE (?, '', '%', ?) AND a.expiry_yn LIKE DECODE (?, 'A', '%', ?) AND NVL (h.store_code, '%') LIKE UPPER (NVL (?, '%')) AND NVL (i.store_code, '%') LIKE UPPER (NVL (?, '%')) AND a.consignment_item_yn LIKE DECODE (?, 'A', '%', ?) AND 'Y' = (SELECT 'Y' FROM mm_user_material_group x, mm_material_group y WHERE x.material_group_code = y.material_group_code AND b.material_group_code = x.material_group_code AND x.user_id = ? AND x.eff_status = 'E' AND y.eff_status = 'E') AND b.language_id = ? AND b.language_id = c.language_id(+) AND b.language_id = d.language_id(+) AND b.language_id = e.language_id(+) AND h.def_issue_uom = j.uom_code(+) AND g.language_id(+) = ? AND j.language_id(+) = ? AND k.acc_entity_id = 'ZZ'"+getOrderBy();//Modified for  TFS id:-16404
											
									
											
									ArrayList newallparameters	=	new ArrayList();
									newallparameters.add(getStore_code());
									for(int i=0;i<alParameters.size();i++)
										newallparameters.add(alParameters.get(i));
									alParameters=newallparameters;
									alParameters.add(getLanguageId());
								}/*else if(store_code.equals("%")){
									stSQL = "SELECT DISTINCT A.ITEM_CODE, A.EXPIRY_YN, B.ALPHA_CODE,                 B.ITEM_CLASS_CODE, B.SHORT_DESC ITEM_DESC, (SELECT SHORT_DESC FROM MM_ITEM_CLASS_LANG_VW WHERE B.ITEM_CLASS_CODE =  ITEM_CLASS_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) ITEM_CLASS_DESC,  A.MFG_BASE_QTY, A.MACHINE_CODE, A.MIN_STK_QTY, A.MAX_STK_QTY, B.LONG_DESC, B.PS_ITEM_YN, B.SOLE_SOURCE_YN, B.MANUFACTURER_ID, B.GEN_UOM_CODE, B.UNIT_COST,                 DECODE (?,'%', (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID), I.SHORT_DESC) UOM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW WHERE B.MANUFACTURER_ID = MANUFACTURER_ID AND B.LANGUAGE_ID = LANGUAGE_ID) MANUFACTURE_DESC, A.SPARE_PART_ID, A.MFG_ITEM_YN, A.MEDICAL_ITEM_YN, A.ABC_CLASS_CODE, A.TRADE_ID_APPLICABLE_YN, A.BATCH_ID_APPLICABLE_YN, A.CONSIGNMENT_ITEM_YN, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) GEN_UOM_DESC FROM ST_ITEM A, MM_ITEM_LANG_VW B, MM_TRADE_NAME_FOR_ITEM F, AM_TRADE_NAME_LANG_VW G, ST_ITEM_STORE H, AM_UOM_LANG_VW I WHERE A.ITEM_CODE = B.ITEM_CODE AND B.EFF_STATUS = 'E' AND NVL (H.EFF_STATUS, 'E') = 'E' AND A.ITEM_CODE = F.ITEM_CODE(+) AND F.TRADE_ID = G.TRADE_ID(+) AND A.ITEM_CODE = H.ITEM_CODE(+) AND UPPER (A.ITEM_CODE) LIKE UPPER (NVL (?, '%')) AND UPPER (B.SHORT_DESC) LIKE UPPER (NVL (?, '%')) AND UPPER (B.ALPHA_CODE) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (A.MACHINE_CODE, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (A.SPARE_PART_ID, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (F.TRADE_ID, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (G.SHORT_NAME, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (A.ABC_CLASS_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.PS_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.SOLE_SOURCE_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.MANUFACTURER_ID, '%') LIKE DECODE (?,'', '%',? ) AND A.MFG_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.ITEM_CLASS_CODE, '%') LIKE  DECODE (?, '', '%',?) AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.EXPIRY_YN LIKE DECODE (?, 'A', '%', ?) AND A.CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND (MATERIAL_GROUP_CODE IN ( SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E')) AND B.LANGUAGE_ID = ? AND H.DEF_ISSUE_UOM = I.UOM_CODE(+) AND NVL (DIRECT_SALE_ALLOWED_YN, 'N') = DECODE (?, 'X', 'Y', NVL (DIRECT_SALE_ALLOWED_YN, 'N')) AND G.LANGUAGE_ID(+) = ? AND I.LANGUAGE_ID(+) = ?";
									ArrayList newallparameters	=	new ArrayList();
									newallparameters.add(getStore_code());
									for(int i=0;i<alParameters.size();i++)
										newallparameters.add(alParameters.get(i));
									alParameters=newallparameters;
									alParameters.add(getLanguageId());
									alParameters.add(checkForNull(this.direct_sale,"N"));
									alParameters.remove(alParameters.size()-6);
								}*/else{ 
									//stSQL="SELECT	 DISTINCT  a.item_code,a.expiry_yn,b.alpha_code,b.item_class_code,b.short_desc item_desc,c.short_desc item_class_desc,a.mfg_base_qty,a.machine_code,a.min_stk_qty,a.max_stk_qty,b.long_desc,b.ps_item_yn,b.sole_source_yn,b.manufacturer_id,b.gen_uom_code,b.unit_cost, DECODE (?, '%', d.short_desc,i.short_desc) uom_desc,e.short_name	 manufacture_desc,a.spare_part_id,a.mfg_item_yn,a.medical_item_yn,a.abc_class_code ,a.trade_id_applicable_yn ,a.batch_id_applicable_yn,a.consignment_item_yn, d.short_desc gen_uom_desc FROM st_item a,mm_item_lang_vw	b,mm_item_class_lang_vw	c,am_uom_lang_vw d ,am_manufacturer_lang_vw	e,mm_trade_name_for_item f,am_trade_name_lang_vw g,st_item_store h,am_uom_lang_vw i WHERE a.item_code=b.item_code AND b.eff_status='E'  AND NVL(h.eff_status,'E') = 'E' AND  b.ITEM_CLASS_CODE=c.ITEM_CLASS_CODE(+) AND b.gen_uom_code=d.uom_code(+) AND	b.manufacturer_id=e.manufacturer_id(+) AND a.item_code=f.item_code(+) AND	   f.trade_id=g.trade_id(+)	 AND a.item_code=h.item_code(+)	AND	UPPER(a.item_code) LIKE	UPPER(NVL(?,'%')) AND UPPER(b.short_desc) LIKE UPPER(NVL(?,'%')) AND UPPER(b.alpha_code) LIKE UPPER(NVL(?,'%'))	AND	UPPER(NVL(a.machine_code,'%')) LIKE	UPPER(NVL(?,'%'))  AND UPPER(NVL(a.spare_part_id,'%')) LIKE	UPPER(NVL(?,'%')) AND  UPPER(NVL(f.trade_id,'%'))  LIKE	UPPER(NVL(?,'%'))  AND	UPPER(NVL(g.short_name,'%')) LIKE UPPER(NVL(?,'%'))	 AND NVL(a.abc_class_code,'%') LIKE	DECODE(?,'','%',?) AND a.medical_item_yn LIKE DECODE(?,'A','%',?) AND b.ps_item_yn LIKE	DECODE(?,'A','%',?)	AND	b.sole_source_yn LIKE DECODE(?,'A','%',?) AND NVL(b.manufacturer_id,'%')LIKE DECODE(?,'','%',?)	 AND a.mfg_item_yn LIKE	DECODE(?,'A','%',?)	AND	NVL(b.ITEM_CLASS_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(b.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(b.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(b.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?)	AND	a.expiry_yn	LIKE DECODE(?,'A','%',?) AND NVL(h.store_code,'%') LIKE	  UPPER(NVL(?,'%'))	 AND a.consignment_item_yn LIKE	DECODE(?,'A','%',?)	AND (material_group_code IN (SELECT material_group_code FROM mm_user_material_group WHERE user_id= ?) )  AND b.language_id = ? AND b.language_id = c.language_id(+)  AND b.language_id = d.language_id(+)   AND b.language_id = e.language_id(+)	AND  h.def_issue_uom = i.uom_code(+) AND	NVL(DIRECT_SALE_ALLOWED_YN,'N') = DECODE(?, 'X', 'Y', NVL(DIRECT_SALE_ALLOWED_YN,'N')) AND g.language_id(+) = ?  AND i.language_id(+) = ?"+getOrderBy();	
									//stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_C_INV")+getOrderBy();	
									if(store_code.equals("%")){
										stSQL="SELECT DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE, A.EXPIRY_YN, B.ALPHA_CODE,                 B.ITEM_CLASS_CODE, B.SHORT_DESC ITEM_DESC, (SELECT SHORT_DESC FROM MM_ITEM_CLASS_LANG_VW WHERE B.ITEM_CLASS_CODE =  ITEM_CLASS_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) ITEM_CLASS_DESC,  A.MFG_BASE_QTY, A.MACHINE_CODE, A.MIN_STK_QTY, A.MAX_STK_QTY, B.LONG_DESC, B.PS_ITEM_YN, B.SOLE_SOURCE_YN, B.MANUFACTURER_ID, B.GEN_UOM_CODE, B.UNIT_COST,                 DECODE (?,'%', (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID), I.SHORT_DESC) UOM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW WHERE B.MANUFACTURER_ID = MANUFACTURER_ID AND B.LANGUAGE_ID = LANGUAGE_ID) MANUFACTURE_DESC, A.SPARE_PART_ID, A.MFG_ITEM_YN, A.MEDICAL_ITEM_YN, A.ABC_CLASS_CODE, A.TRADE_ID_APPLICABLE_YN, A.BATCH_ID_APPLICABLE_YN, A.CONSIGNMENT_ITEM_YN, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) GEN_UOM_DESC FROM ST_ITEM A, MM_ITEM_LANG_VW B, MM_TRADE_NAME_FOR_ITEM F, AM_TRADE_NAME_LANG_VW G, ST_ITEM_STORE H, AM_UOM_LANG_VW I,ST_ACC_ENTITY_PARAM J WHERE A.ITEM_CODE = B.ITEM_CODE AND B.EFF_STATUS = 'E' AND NVL (H.EFF_STATUS, 'E') = 'E' AND A.ITEM_CODE = F.ITEM_CODE(+) AND F.TRADE_ID = G.TRADE_ID(+) AND A.ITEM_CODE = H.ITEM_CODE(+) AND A.ITEM_CODE LIKE UPPER (NVL (?, '%')) AND UPPER (B.SHORT_DESC) LIKE UPPER (NVL (?, '%')) AND B.ALPHA_CODE LIKE UPPER (NVL (?, '%')) AND NVL (A.MACHINE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND NVL (A.SPARE_PART_ID, '%') LIKE UPPER (NVL (?, '%')) AND NVL (F.TRADE_ID, '%') LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (G.SHORT_NAME, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (A.ABC_CLASS_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.PS_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.SOLE_SOURCE_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.MANUFACTURER_ID, '%') LIKE DECODE (?,'', '%',? ) AND A.MFG_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.ITEM_CLASS_CODE, '%') LIKE  DECODE (?, '', '%',?) AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.EXPIRY_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (H.STORE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND A.CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND (MATERIAL_GROUP_CODE IN ( SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E')) AND B.LANGUAGE_ID = ? AND H.DEF_ISSUE_UOM = I.UOM_CODE(+) AND NVL (DIRECT_SALE_ALLOWED_YN, 'N') = DECODE (?, 'X', 'Y', NVL (DIRECT_SALE_ALLOWED_YN, 'N')) AND G.LANGUAGE_ID(+) = ? AND I.LANGUAGE_ID(+) = ? AND J.ACC_ENTITY_ID = 'ZZ'"+getOrderBy();
										//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
										//stSQL="SELECT DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE, A.EXPIRY_YN, B.ALPHA_CODE,                 B.ITEM_CLASS_CODE, B.SHORT_DESC ITEM_DESC, (SELECT SHORT_DESC FROM MM_ITEM_CLASS_LANG_VW WHERE B.ITEM_CLASS_CODE =  ITEM_CLASS_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) ITEM_CLASS_DESC,  A.MFG_BASE_QTY, A.MACHINE_CODE, A.MIN_STK_QTY, A.MAX_STK_QTY, B.LONG_DESC, B.PS_ITEM_YN, B.SOLE_SOURCE_YN, B.MANUFACTURER_ID, B.GEN_UOM_CODE, B.UNIT_COST,                 DECODE (?,'%', (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID), I.SHORT_DESC) UOM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW WHERE B.MANUFACTURER_ID = MANUFACTURER_ID AND B.LANGUAGE_ID = LANGUAGE_ID) MANUFACTURE_DESC, A.SPARE_PART_ID, A.MFG_ITEM_YN, A.MEDICAL_ITEM_YN, A.ABC_CLASS_CODE, A.TRADE_ID_APPLICABLE_YN, A.BATCH_ID_APPLICABLE_YN, A.CONSIGNMENT_ITEM_YN, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) GEN_UOM_DESC,(NVL(H.MAX_STK_QTY,0)*ST_GET_UOM_CONV_FAC_SING_STR(h.item_code,h.store_code)) MAX_STR_QTY  ,(NVL(H.MIN_STK_QTY,0) *ST_GET_UOM_CONV_FAC_SING_STR(h.item_code,h.store_code)) MIN_STR_QTY ,(NVL (H.REORDER_LEVEL, 0) * ST_GET_UOM_CONV_FAC_SING_STR (h.item_code,h.store_code)) REORDER_LEVEL FROM ST_ITEM A, MM_ITEM_LANG_VW B, MM_TRADE_NAME_FOR_ITEM F, AM_TRADE_NAME_LANG_VW G, ST_ITEM_STORE H, AM_UOM_LANG_VW I,ST_ACC_ENTITY_PARAM J WHERE A.ITEM_CODE = B.ITEM_CODE AND B.EFF_STATUS = 'E' AND NVL (H.EFF_STATUS, 'E') = 'E' AND A.ITEM_CODE = F.ITEM_CODE(+) AND F.TRADE_ID = G.TRADE_ID(+) AND A.ITEM_CODE = H.ITEM_CODE(+) AND A.ITEM_CODE LIKE UPPER (NVL (?, '%')) AND UPPER (B.SHORT_DESC) LIKE UPPER (NVL (?, '%')) AND B.ALPHA_CODE LIKE UPPER (NVL (?, '%')) AND NVL (A.MACHINE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND NVL (A.SPARE_PART_ID, '%') LIKE UPPER (NVL (?, '%')) AND NVL (F.TRADE_ID, '%') LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (G.SHORT_NAME, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (A.ABC_CLASS_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.PS_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.SOLE_SOURCE_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.MANUFACTURER_ID, '%') LIKE DECODE (?,'', '%',? ) AND A.MFG_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.ITEM_CLASS_CODE, '%') LIKE  DECODE (?, '', '%',?) AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.EXPIRY_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (H.STORE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND A.CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND (MATERIAL_GROUP_CODE IN ( SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E')) AND B.LANGUAGE_ID = ? AND H.DEF_ISSUE_UOM = I.UOM_CODE(+) AND NVL (DIRECT_SALE_ALLOWED_YN, 'N') = DECODE (?, 'X', 'Y', NVL (DIRECT_SALE_ALLOWED_YN, 'N')) AND G.LANGUAGE_ID(+) = ? AND I.LANGUAGE_ID(+) = ? AND J.ACC_ENTITY_ID = 'ZZ'"+getOrderBy();
									}else{
										//stSQL="SELECT DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE, A.EXPIRY_YN, B.ALPHA_CODE,                 B.ITEM_CLASS_CODE, B.SHORT_DESC ITEM_DESC, (SELECT SHORT_DESC FROM MM_ITEM_CLASS_LANG_VW WHERE B.ITEM_CLASS_CODE =  ITEM_CLASS_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) ITEM_CLASS_DESC,  A.MFG_BASE_QTY, A.MACHINE_CODE, A.MIN_STK_QTY, A.MAX_STK_QTY, B.LONG_DESC, B.PS_ITEM_YN, B.SOLE_SOURCE_YN, B.MANUFACTURER_ID, B.GEN_UOM_CODE, B.UNIT_COST,                 DECODE (?,'%', (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID), I.SHORT_DESC) UOM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW WHERE B.MANUFACTURER_ID = MANUFACTURER_ID AND B.LANGUAGE_ID = LANGUAGE_ID) MANUFACTURE_DESC, A.SPARE_PART_ID, A.MFG_ITEM_YN, A.MEDICAL_ITEM_YN, A.ABC_CLASS_CODE, A.TRADE_ID_APPLICABLE_YN, A.BATCH_ID_APPLICABLE_YN, A.CONSIGNMENT_ITEM_YN, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) GEN_UOM_DESC,(SELECT nvl(SUM (qty_on_hand),0)  FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) qty_on_hand,(SELECT (  nvl(SUM (qty_on_hand),0)- nvl(SUM (committed_qty),0) ) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) available_qty FROM ST_ITEM A, MM_ITEM_LANG_VW B, MM_TRADE_NAME_FOR_ITEM F, AM_TRADE_NAME_LANG_VW G, ST_ITEM_STORE H, AM_UOM_LANG_VW I,ST_ACC_ENTITY_PARAM J WHERE A.ITEM_CODE = B.ITEM_CODE AND B.EFF_STATUS = 'E' AND NVL (H.EFF_STATUS, 'E') = 'E' AND A.ITEM_CODE = F.ITEM_CODE(+) AND F.TRADE_ID = G.TRADE_ID(+) AND A.ITEM_CODE = H.ITEM_CODE(+) AND A.ITEM_CODE LIKE UPPER (NVL (?, '%')) AND UPPER (B.SHORT_DESC) LIKE UPPER (NVL (?, '%')) AND B.ALPHA_CODE LIKE UPPER (NVL (?, '%')) AND NVL (A.MACHINE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND NVL (A.SPARE_PART_ID, '%') LIKE UPPER (NVL (?, '%')) AND NVL (F.TRADE_ID, '%') LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (G.SHORT_NAME, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (A.ABC_CLASS_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.PS_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.SOLE_SOURCE_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.MANUFACTURER_ID, '%') LIKE DECODE (?,'', '%',? ) AND A.MFG_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.ITEM_CLASS_CODE, '%') LIKE  DECODE (?, '', '%',?) AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.EXPIRY_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (H.STORE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND A.CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND (MATERIAL_GROUP_CODE IN ( SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E')) AND B.LANGUAGE_ID = ? AND H.DEF_ISSUE_UOM = I.UOM_CODE(+) AND NVL (DIRECT_SALE_ALLOWED_YN, 'N') = DECODE (?, 'X', 'Y', NVL (DIRECT_SALE_ALLOWED_YN, 'N')) AND G.LANGUAGE_ID(+) = ? AND I.LANGUAGE_ID(+) = ? AND J.ACC_ENTITY_ID = 'ZZ'"+getOrderBy();	
									//Added for GHL-CRF-0456 starts	
										if(getTrn_type().equals("SAL"))
											stSQL="SELECT DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE, A.EXPIRY_YN, B.ALPHA_CODE,                 B.ITEM_CLASS_CODE, B.SHORT_DESC ITEM_DESC, (SELECT SHORT_DESC FROM MM_ITEM_CLASS_LANG_VW WHERE B.ITEM_CLASS_CODE =  ITEM_CLASS_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) ITEM_CLASS_DESC,  A.MFG_BASE_QTY, A.MACHINE_CODE, A.MIN_STK_QTY, A.MAX_STK_QTY, B.LONG_DESC, B.PS_ITEM_YN, B.SOLE_SOURCE_YN, B.MANUFACTURER_ID, B.GEN_UOM_CODE, B.UNIT_COST,                 DECODE (?,'%', (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID), I.SHORT_DESC) UOM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW WHERE B.MANUFACTURER_ID = MANUFACTURER_ID AND B.LANGUAGE_ID = LANGUAGE_ID) MANUFACTURE_DESC, A.SPARE_PART_ID, A.MFG_ITEM_YN, A.MEDICAL_ITEM_YN, A.ABC_CLASS_CODE, A.TRADE_ID_APPLICABLE_YN, A.BATCH_ID_APPLICABLE_YN, A.CONSIGNMENT_ITEM_YN, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) GEN_UOM_DESC,(SELECT nvl(SUM (qty_on_hand),0)  FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) qty_on_hand,(SELECT (  nvl(SUM (qty_on_hand),0)- nvl(SUM (committed_qty),0) ) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) available_qty,(NVL(H.MAX_STK_QTY,0)*ST_GET_UOM_CONV_FAC_SING_STR(h.item_code,h.store_code)) MAX_STR_QTY  ,(NVL(H.MIN_STK_QTY,0) *ST_GET_UOM_CONV_FAC_SING_STR(h.item_code,h.store_code)) MIN_STR_QTY ,(NVL (H.REORDER_LEVEL, 0) * ST_GET_UOM_CONV_FAC_SING_STR (h.item_code,h.store_code)) REORDER_LEVEL FROM ST_ITEM A, MM_ITEM_LANG_VW B, MM_TRADE_NAME_FOR_ITEM F, AM_TRADE_NAME_LANG_VW G, ST_ITEM_STORE H, AM_UOM_LANG_VW I,ST_ACC_ENTITY_PARAM J WHERE A.ITEM_CODE = B.ITEM_CODE AND B.EFF_STATUS = 'E' AND NVL (H.EFF_STATUS, 'E') = 'E' AND A.ITEM_CODE = F.ITEM_CODE(+) AND F.TRADE_ID = G.TRADE_ID(+) AND A.ITEM_CODE = H.ITEM_CODE(+) AND A.ITEM_CODE LIKE UPPER (NVL (?, '%')) AND UPPER (B.SHORT_DESC) LIKE UPPER (NVL (?, '%')) AND B.ALPHA_CODE LIKE UPPER (NVL (?, '%')) AND NVL (A.MACHINE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND NVL (A.SPARE_PART_ID, '%') LIKE UPPER (NVL (?, '%')) AND NVL (F.TRADE_ID, '%') LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (G.SHORT_NAME, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (A.ABC_CLASS_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.PS_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.SOLE_SOURCE_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.MANUFACTURER_ID, '%') LIKE DECODE (?,'', '%',? ) AND A.MFG_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.ITEM_CLASS_CODE, '%') LIKE  DECODE (?, '', '%',?) AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.EXPIRY_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (H.STORE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND A.CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND (MATERIAL_GROUP_CODE IN ( SELECT X.MATERIAL_GROUP_CODE FROM MM_USER_MATERIAL_GROUP X,MM_MATERIAL_GROUP_LANG_VW Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E')) AND B.LANGUAGE_ID = ? AND H.DEF_ISSUE_UOM = I.UOM_CODE(+) AND NVL (DIRECT_SALE_ALLOWED_YN, 'N') = DECODE (?, 'X', 'Y', NVL (DIRECT_SALE_ALLOWED_YN, 'N')) AND G.LANGUAGE_ID(+) = ? AND I.LANGUAGE_ID(+) = ? AND J.ACC_ENTITY_ID = 'ZZ' and NVL (h.SALES_ALLOWED_YN, 'Y') NOT IN ('N')"+getOrderBy();
										else if(getTrn_type().equals("CON"))
											stSQL="SELECT DISTINCT DECODE (disp_decimal_dtls_yn, 'Y', allow_decimals_yn, 'N' ) allow_decimals_yn, DECODE (disp_decimal_dtls_yn, 'Y', no_of_decimals, 0 ) no_of_decimals, a.item_code, a.expiry_yn, b.alpha_code, b.item_class_code, b.short_desc item_desc, (SELECT short_desc FROM mm_item_class_lang_vw WHERE b.item_class_code = item_class_code AND b.language_id = language_id) item_class_desc, a.mfg_base_qty, a.machine_code, a.min_stk_qty, a.max_stk_qty, b.long_desc, b.ps_item_yn, b.sole_source_yn, b.manufacturer_id, b.gen_uom_code, b.unit_cost, DECODE (?, '%', (SELECT short_desc FROM am_uom_lang_vw WHERE b.gen_uom_code = uom_code AND b.language_id = language_id), i.short_desc ) uom_desc, (SELECT short_name FROM am_manufacturer_lang_vw WHERE b.manufacturer_id = manufacturer_id AND b.language_id = language_id) manufacture_desc, a.spare_part_id, a.mfg_item_yn, a.medical_item_yn, a.abc_class_code, a.trade_id_applicable_yn, a.batch_id_applicable_yn, a.consignment_item_yn, (SELECT short_desc FROM am_uom_lang_vw WHERE b.gen_uom_code = uom_code AND b.language_id = language_id) gen_uom_desc, (SELECT NVL (SUM (qty_on_hand), 0) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) qty_on_hand, (SELECT (  NVL (SUM (qty_on_hand), 0) - NVL (SUM (committed_qty), 0) ) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) available_qty, (  NVL (h.max_stk_qty, 0) * st_get_uom_conv_fac_sing_str (h.item_code, h.store_code) ) max_str_qty, (  NVL (h.min_stk_qty, 0) * st_get_uom_conv_fac_sing_str (h.item_code, h.store_code) ) min_str_qty, (  NVL (h.reorder_level, 0) * st_get_uom_conv_fac_sing_str (h.item_code, h.store_code) ) reorder_level FROM st_item a, mm_item_lang_vw b, mm_trade_name_for_item f, am_trade_name_lang_vw g, st_item_store h, am_uom_lang_vw i, st_acc_entity_param j WHERE a.item_code = b.item_code AND b.eff_status = 'E' AND NVL (h.eff_status, 'E') = 'E' AND a.item_code = f.item_code(+) AND f.trade_id = g.trade_id(+) AND a.item_code = h.item_code(+) AND a.item_code LIKE UPPER (NVL (?, '%')) AND UPPER (b.short_desc) LIKE UPPER (NVL (?, '%')) AND b.alpha_code LIKE UPPER (NVL (?, '%')) AND NVL (a.machine_code, '%') LIKE UPPER (NVL (?, '%')) AND NVL (a.spare_part_id, '%') LIKE UPPER (NVL (?, '%')) AND NVL (f.trade_id, '%') LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (g.short_name, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (a.abc_class_code, '%') LIKE DECODE (?, '', '%', ?) AND a.medical_item_yn LIKE DECODE (?, 'A', '%', ?) AND b.ps_item_yn LIKE DECODE (?, 'A', '%', ?) AND b.sole_source_yn LIKE DECODE (?, 'A', '%', ?) AND NVL (b.manufacturer_id, '%') LIKE DECODE (?, '', '%', ?) AND a.mfg_item_yn LIKE DECODE (?, 'A', '%', ?) AND NVL (b.item_class_code, '%') LIKE DECODE (?, '', '%', ?) AND NVL (b.item_anal1_code, '%') LIKE DECODE (?, '', '%', ?) AND NVL (b.item_anal2_code, '%') LIKE DECODE (?, '', '%', ?) AND NVL (b.item_anal3_code, '%') LIKE DECODE (?, '', '%', ?) AND a.expiry_yn LIKE DECODE (?, 'A', '%', ?) AND NVL (h.store_code, '%') LIKE UPPER (NVL (?, '%')) AND a.consignment_item_yn LIKE DECODE (?, 'A', '%', ?) AND 'Y' = (SELECT 'Y' FROM mm_user_material_group x, mm_material_group y WHERE x.material_group_code = y.material_group_code AND b.material_group_code = x.material_group_code AND x.user_id = ? AND x.eff_status = 'E' AND y.eff_status = 'E') AND b.language_id = ? AND h.def_issue_uom = i.uom_code(+) AND NVL (direct_sale_allowed_yn, 'N') = DECODE (?, 'X', 'Y', NVL (direct_sale_allowed_yn, 'N') ) AND g.language_id(+) = ? AND i.language_id(+) = ? AND j.acc_entity_id = 'ZZ' AND NVL (h.consumption_allowed_yn, 'Y') NOT IN ('N')"+getOrderBy();//Modified for  TFS id:-16404
										else	
											//Added for GHL-CRF-0456 ends
										stSQL="SELECT DISTINCT DECODE(DISP_DECIMAL_DTLS_YN,'Y',ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,DECODE(DISP_DECIMAL_DTLS_YN,'Y',NO_OF_DECIMALS,0) NO_OF_DECIMALS,A.ITEM_CODE, A.EXPIRY_YN, B.ALPHA_CODE,                 B.ITEM_CLASS_CODE, B.SHORT_DESC ITEM_DESC, (SELECT SHORT_DESC FROM MM_ITEM_CLASS_LANG_VW WHERE B.ITEM_CLASS_CODE =  ITEM_CLASS_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) ITEM_CLASS_DESC,  A.MFG_BASE_QTY, A.MACHINE_CODE, A.MIN_STK_QTY, A.MAX_STK_QTY, B.LONG_DESC, B.PS_ITEM_YN, B.SOLE_SOURCE_YN, B.MANUFACTURER_ID, B.GEN_UOM_CODE, B.UNIT_COST,                 DECODE (?,'%', (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID), I.SHORT_DESC) UOM_DESC, (SELECT SHORT_NAME FROM AM_MANUFACTURER_LANG_VW WHERE B.MANUFACTURER_ID = MANUFACTURER_ID AND B.LANGUAGE_ID = LANGUAGE_ID) MANUFACTURE_DESC, A.SPARE_PART_ID, A.MFG_ITEM_YN, A.MEDICAL_ITEM_YN, A.ABC_CLASS_CODE, A.TRADE_ID_APPLICABLE_YN, A.BATCH_ID_APPLICABLE_YN, A.CONSIGNMENT_ITEM_YN, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE B.GEN_UOM_CODE = UOM_CODE AND B.LANGUAGE_ID = LANGUAGE_ID) GEN_UOM_DESC,(SELECT nvl(SUM (qty_on_hand),0)  FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) qty_on_hand,(SELECT (  nvl(SUM (qty_on_hand),0)- nvl(SUM (committed_qty),0) ) FROM st_item_batch WHERE item_code = h.item_code AND store_code = h.store_code) available_qty,(NVL(H.MAX_STK_QTY,0)*ST_GET_UOM_CONV_FAC_SING_STR(h.item_code,h.store_code)) MAX_STR_QTY  ,(NVL(H.MIN_STK_QTY,0) *ST_GET_UOM_CONV_FAC_SING_STR(h.item_code,h.store_code)) MIN_STR_QTY ,(NVL (H.REORDER_LEVEL, 0) * ST_GET_UOM_CONV_FAC_SING_STR (h.item_code,h.store_code)) REORDER_LEVEL FROM ST_ITEM A, MM_ITEM_LANG_VW B, MM_TRADE_NAME_FOR_ITEM F, AM_TRADE_NAME_LANG_VW G, ST_ITEM_STORE H, AM_UOM_LANG_VW I,ST_ACC_ENTITY_PARAM J WHERE A.ITEM_CODE = B.ITEM_CODE AND B.EFF_STATUS = 'E' AND NVL (H.EFF_STATUS, 'E') = 'E' AND A.ITEM_CODE = F.ITEM_CODE(+) AND F.TRADE_ID = G.TRADE_ID(+) AND A.ITEM_CODE = H.ITEM_CODE(+) AND A.ITEM_CODE LIKE UPPER (NVL (?, '%')) AND UPPER (B.SHORT_DESC) LIKE UPPER (NVL (?, '%')) AND B.ALPHA_CODE LIKE UPPER (NVL (?, '%')) AND NVL (A.MACHINE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND NVL (A.SPARE_PART_ID, '%') LIKE UPPER (NVL (?, '%')) AND NVL (F.TRADE_ID, '%') LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (G.SHORT_NAME, '%')) LIKE UPPER (NVL (?, '%')) AND NVL (A.ABC_CLASS_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.MEDICAL_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.PS_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND B.SOLE_SOURCE_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.MANUFACTURER_ID, '%') LIKE DECODE (?,'', '%',? ) AND A.MFG_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (B.ITEM_CLASS_CODE, '%') LIKE  DECODE (?, '', '%',?) AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE  DECODE (?,'', '%',?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE  DECODE (?,'', '%',?) AND A.EXPIRY_YN LIKE DECODE (?, 'A', '%', ?) AND NVL (H.STORE_CODE, '%') LIKE UPPER (NVL (?, '%')) AND A.CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND 'Y' = ( SELECT 'Y' FROM MM_USER_MATERIAL_GROUP X, mm_material_group Y WHERE X.MATERIAL_GROUP_CODE = Y.MATERIAL_GROUP_CODE and b.material_group_code = X.MATERIAL_GROUP_CODE AND X.USER_ID = ? AND X.EFF_STATUS = 'E' AND Y.EFF_STATUS = 'E') AND B.LANGUAGE_ID = ? AND H.DEF_ISSUE_UOM = I.UOM_CODE(+) AND NVL (DIRECT_SALE_ALLOWED_YN, 'N') = DECODE (?, 'X', 'Y', NVL (DIRECT_SALE_ALLOWED_YN, 'N')) AND G.LANGUAGE_ID(+) = ? AND I.LANGUAGE_ID(+) = ? AND J.ACC_ENTITY_ID = 'ZZ'"+getOrderBy();//Modified for  MOHE-SCF-0070
									}
									ArrayList newallparameters	=	new ArrayList();
									newallparameters.add(getStore_code());
									for(int i=0;i<alParameters.size();i++)
										newallparameters.add(alParameters.get(i));
									alParameters=newallparameters;
									alParameters.add(getLanguageId());
									alParameters.add(checkForNull(this.direct_sale,"N"));
								}
							}
				}else{ 
					// Modified on 5/31/2005 by Ram to include  itemstore combination checking.
					if (item_search_param !=  null && item_search_param.size()>0 ){
						if (item_search_param.get(0).equals("ST_ASSEMBLY_DTL")){
							if(store_code.equals("%")){
							stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_FOR_ASSM_DTL")+getOrderBy();
							}else{
								stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_FOR_ASSM_DTL_STORE")+getOrderBy();
							}
						}else if(item_search_param.get(0).equals("ST_MANUFACTURING_REQUEST")){
							alParameters.add(((String)item_search_param.get(1)).equals( "A")?"%": (String)item_search_param.get(1)) ;
							alParameters.add(((String)item_search_param.get(2)).equals("A")?"%": (String)item_search_param.get(2)) ;

							stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_FOR_MFG_REQ")+getOrderBy();
						
						}
					}else{
						if (getChkItemStoreCombination().equals("Y")){	 
//							stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_ITM_CMB_CHK");
							stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_ITM_CMB_CHK1")+getOrderBy();
							ArrayList newallparameters	=	new ArrayList();
							newallparameters.add(getStore_code());
							for(int i=0;i<alParameters.size();i++)
								newallparameters.add(alParameters.get(i));
							alParameters=newallparameters;
							alParameters.add(getLanguageId());
						}else{	 
							//stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY");		
							if(store_code.equals("%")){
							stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY1")+getOrderBy();
							}else{
								stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY2")+getOrderBy();
							}
							ArrayList newallparameters	=	new ArrayList();
							newallparameters.add(getStore_code());
							for(int i=0;i<alParameters.size();i++)
								newallparameters.add(alParameters.get(i));
							alParameters=newallparameters;
							alParameters.add(getLanguageId());
						}
					}
				}
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
	
	public void ascSort(String stColumnName,int start,int end){
		HashMap hmTemp;
		double curr_value = 0.0;
		double next_val = 0.0;
		//Condition Added by Sakti against AMS-CRF-0028 AND AMRI-CRF-100024 to sort QOH and AVLBL_QTY
		if(stColumnName.equals("QTY_ON_HAND") || stColumnName.equals("AVAILABLE_QTY") || stColumnName.equals("MIN_STR_QTY") || stColumnName.equals("REORDER_LEVEL") || stColumnName.equals("MAX_STR_QTY") ){
			for (int i=start;i<end; i++ ) {
				
				for (int j=start;j<end-1; j++ ) {
					curr_value = Double.parseDouble(( (String)((HashMap)DataList.get(j)).get(stColumnName)));
					next_val =   Double.parseDouble(( (String)((HashMap)DataList.get(j+1)).get(stColumnName)));
					if(curr_value < next_val){
						hmTemp	=	(HashMap)DataList.get(j);
						DataList.set(j,(HashMap)DataList.get(j+1)); 
						DataList.set(j+1,hmTemp);
						}
					}
				}//Added ends
		}else{
			for (int k=start;k<end; k++ ) {
				for (int l=start;l<end-1; l++ ) {
					if ( ( (String)((HashMap)DataList.get(l)).get(stColumnName)).compareTo(((String)((HashMap)DataList.get(l+1)).get(stColumnName)))>0 ) {
						hmTemp	=	(HashMap)DataList.get(l);
						DataList.set(l,(HashMap)DataList.get(l+1));
						DataList.set(l+1,hmTemp);
					}
				}
			}
		}
	}
	public void descSort(String stColumnName,int start,int end){
		HashMap hmTemp;
		double curr_value = 0.0;
		double next_val = 0.0;
		//Condition Added by Sakti against AMS-CRF-0028 AND AMRI-CRF-100024 to sort QOH and AVLBL_QTY
		if(stColumnName.equals("QTY_ON_HAND") || stColumnName.equals("AVAILABLE_QTY") || stColumnName.equals("MIN_STR_QTY") || stColumnName.equals("REORDER_LEVEL") || stColumnName.equals("MAX_STR_QTY") ){
				for (int i=start;i<end; i++ ) {
					
					for (int j=start;j<end-1; j++ ) {
						curr_value = Double.parseDouble(( (String)((HashMap)DataList.get(j)).get(stColumnName)));
						next_val =   Double.parseDouble(( (String)((HashMap)DataList.get(j+1)).get(stColumnName)));
						if(curr_value > next_val){
						
							hmTemp	=	(HashMap)DataList.get(j);
							DataList.set(j,(HashMap)DataList.get(j+1));
							DataList.set(j+1,hmTemp);
							}
						}
					}//Added ends
		}else{
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
	public String getItemClassDesc(String item_class)
	{
		 String	sql				=			getStRepositoryValue("ST_ITEM_SEARCH_ITEM_CLASS_DESC_SELECT");
		 String record			="";
		 Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet resultSet = null;
		
		 if(item_class=="")
		{
			record="";
		}
		else
		{
			try {
				connection = getConnection();
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, item_class);
			  
				resultSet = pstmt.executeQuery();
				while (resultSet != null && resultSet.next()) {
					record =resultSet.getString(1);
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
        }
		
        return record;
	}
	public void getKitTemplateDetails(String kit_code){
		ArrayList alParameters	=	new ArrayList();
		ArrayList listRecords	=	new ArrayList();
		alParameters.add(kit_code);
		alParameters.add(getLanguageId());
		try{
			listRecords	= fetchRecords("SELECT KIT_TEMPLATE_CODE,KIT_TEMPLATE_DESC FROM ST_KIT_TEMPLATE_LANG_VW WHERE UPPER(KIT_TEMPLATE_DESC) LIKE UPPER(?) AND LANGUAGE_ID=? AND EFF_STATUS='E'",alParameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		KitDataList = listRecords;
	}

	/* To populate the SEARCH BY ITEM LIST in the front end list box for ITEM ON 21/10/2011*/
	public String getDflt_search_item() {
		String []stParameters=	{getLoginById(), getStore_code()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT	DFLT_ITEM_SEARCH FROM	st_user_access_for_store WHERE user_id=? and store_code=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("DFLT_ITEM_SEARCH");
	}

	public String getDflt_search_item1() {
		String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT	DFLT_ITEM_SEARCH FROM	st_facility_param WHERE facility_id=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("DFLT_ITEM_SEARCH");
	}



}
