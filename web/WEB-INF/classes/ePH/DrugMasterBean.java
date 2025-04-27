/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019	IN068345     Prathyusha	                                     Required changes in item substitute mapping set up
3/2/2020	72190			shazana										SKR-SCF-1312
14/12/2020   IN8219         Prabha	 	   15/12/2020	Manickavasagam J   MMS-DM-CRF-0177
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
13/7/2023      TFS-46322    hariharan                    Ramesh goil            COMMON-ICN-0310
--------------------------------------------------------------------------------------------------------------------
*/
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.servlet.http.HttpServletRequest; //Added for MMS-DM-CRF-0177
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugMaster.*;
import webbeans.eCommon.ConnectionManager;  //Added for MMS-DM-CRF-0177

public class DrugMasterBean extends PhAdapter implements Serializable {

	/* Variable Declarations start */
	protected	String drug_code_gen_rule	=	"";
	protected	String drug_code_and_item	=	"";
	protected	String drug_item_code_link	=	"";
	protected	String drug_to_item_mapping	=	"";
	protected	String stock_yn				=	"";
	protected	String or_yn				=	"";
	protected	String ip_yn				=	"";
	//protected   String sample				=	"";
	//protected	String content_in_pres_base_uom =	"";
	//protected	String restricted_yn			=	"";
	protected	String prescribing_desc			=	"";
	//protected	String genericID				=	"";
	protected	String strEDLCodes			=	"";
	protected	String strEDLDescriptions	=	"";

	protected	ArrayList	drugmastermain		=	new ArrayList();
	protected	ArrayList	characteristics		=	new ArrayList();
	protected	ArrayList	prescribing_det		=	new ArrayList();
	protected	ArrayList	iv_char				=	new ArrayList();
	protected	ArrayList	external_db			=	new ArrayList();
	protected	ArrayList	dispensing			=	new ArrayList();
	protected	ArrayList	inventory			=	new ArrayList();
	protected	ArrayList	trade				=	new ArrayList();
	protected	ArrayList	ageGroup			=	new ArrayList();
	protected	ArrayList sliding_scale	= new ArrayList();
	protected	ArrayList	 sliding_scale_chkd_values	 =	 new ArrayList();
	protected	ArrayList	generic				=	new ArrayList();
	protected	ArrayList	Comp_Fluids			=	new ArrayList();
	//protected	ArrayList	generic_delete		=	new ArrayList();
	protected	ArrayList	mandatory_flds		=	new ArrayList();
	protected	String	refill_yn				=	"";
	protected	String	ph_version				=	"";
	protected   String  category_code			=	"";
	private HashMap SupportDrugs			= new HashMap();//Added for TH-KW-CRF-0007
	private ArrayList SupportdrugList       =new ArrayList();//Added for TH-KW-CRF-0007
	String debug="";
 /* Variable Declarations end */
		
	public DrugMasterBean() {
        try {
            doCommon();
		}catch(Exception e) { e.printStackTrace();}
    }

/* Set and get methods */ 

	public void setVersion(String version)	{
		this.ph_version	=	version;
	}

	public void setRefillYN(String refill_yn)	{
		this.refill_yn	=	refill_yn;
	}

	
	public void setDrugCodeGenRule(String	drug_code_gen_rule)		{
		this.drug_code_gen_rule	=	drug_code_gen_rule;
	}
	
	public void	 setDrugCodeAndItem(String	drug_code_and_item)		{
		this.drug_code_and_item	=	drug_code_and_item;
	}

	public void	 setDrugItemCodeLink(String	drug_item_code_link)	{
		this.drug_item_code_link	=	drug_item_code_link;

	}
	public void	 setDrugItemMapping(String	drug_to_item_mapping)	{
		this.drug_to_item_mapping	=	drug_to_item_mapping;
	}

	public void setStockModuleYN(String stock_yn)	{
		this.stock_yn	=	stock_yn;
	}

	public void setIPModuleYN(String ip_yn)	{
		this.ip_yn	=	ip_yn;
	}

	public void setORModuleYN(String or_yn)	{
		this.or_yn	=	or_yn;
	}

	public void setDrugMastermain(ArrayList drugmastermain)		{
		this.drugmastermain		=	(ArrayList) drugmastermain.clone();
	}
				
	public void setCharacteristics(ArrayList characteristics)	{
		this.characteristics	=	(ArrayList) characteristics.clone();
	}

	public void setPrescription(ArrayList prescribing_det)	{
		this.prescribing_det	=	(ArrayList) prescribing_det.clone();
	}
				
	public void setExternalDB(ArrayList external_db)	{
	  
		this.external_db		=	(ArrayList)	external_db.clone();
		
	}
	public void setCompFluids(ArrayList Comp_Fluids){
		this.Comp_Fluids		=	(ArrayList) Comp_Fluids.clone();
	}
	public void setIVChar(ArrayList iv_char)	{
		this.iv_char			=	(ArrayList)	iv_char.clone();
	}

	public void setDispensing(ArrayList dispensing)	{
		this.dispensing			=	(ArrayList)	dispensing.clone();
	}
	
	public void setInventory(ArrayList inventory)	{
		this.inventory			=	(ArrayList)	inventory.clone();
	}

	public void setAgeGroups(ArrayList ageGroup)	{
		this.ageGroup			=	(ArrayList)	ageGroup.clone();
	}
	public void setTradeNames(ArrayList trade)	{
		this.trade			=	(ArrayList)	trade.clone();
	}
	public void setGenericNames(ArrayList generic)	{
		this.generic		=	(ArrayList)	generic.clone();
	}

	public void setSlidingScale(ArrayList sliding_scale) {
		this.sliding_scale	 =	 (ArrayList) sliding_scale.clone();
	}

	public void setSlidingScaleChkdValues(ArrayList sliding_scale_chkd_values) {
		this.sliding_scale_chkd_values	 =	 (ArrayList) sliding_scale_chkd_values.clone();
	}

	public void setPrescribingDesc(String desc)	{
	this.prescribing_desc	=	desc;
	}
	public void setStrEDLCodes(String strEDLCodes)	{
	this.strEDLCodes	=	strEDLCodes;
	}
	public void setStrEDLDescriptions(String strEDLDescriptions)	{
	this.strEDLDescriptions	=	strEDLDescriptions;
	}

	


/*	public void setGenericId(String generic_id)	{
		this.genericID	=	generic_id;
	}*/

	public String getStrEDLCodes()	{
		return this.strEDLCodes;
	}
	public String getStrEDLDescriptions()	{
		return this.strEDLDescriptions;
	}
	
	public String getVersion()	{
		return this.ph_version;
	}

	public String getPrescribingDesc()	{
		return this.prescribing_desc;
	}

	public String getDrugCodeGenRule()	{	
		return this.drug_code_gen_rule;
	}
	
	public String getDrugCodeAndItem()	{	
		return this.drug_code_and_item;
	}

	public String getDrugItemCodeLink()	{	
		return this.drug_item_code_link;
	}
	public String getDrugDrugItemMapping()	{	
		return this.drug_to_item_mapping;
	}

	public String getStockModuleYN()	{
		return this.stock_yn;
	}

	public String getIPModuleYN()	{
		return this.ip_yn;
	}

	public String getORModuleYN()	{
		return this.or_yn;
	}

	public String getRefillYN()	{
		return this.refill_yn;
	}

	public ArrayList getExternalDB()	{
		return this.external_db;
	}
	public ArrayList getCompFluids(){
		return this.Comp_Fluids;
	}

	public ArrayList getDrugmastermain(){
		return this.drugmastermain;
	}	
	
			
	public ArrayList getCharacteristics()	{
		return this.characteristics;
	}	
	
	public ArrayList getPrescription()	{
		return this.prescribing_det;
	}	

	public ArrayList getIVChar()	{
		return this.iv_char;
	}

	public ArrayList getDispensing()	{
		return this.dispensing;
	}
	
	public ArrayList getInventory()	{
		return this.inventory;
	}

	public ArrayList getAgeGroups()	{
		return this.ageGroup;
	}
	public ArrayList getTradeNames()	{
		return this.trade;
	}

	public ArrayList getGenericNames()	{
		return this.generic;
	}

	public ArrayList getSlidingScaleChkdValues()	{
		return this.sliding_scale_chkd_values;
	}

	public ArrayList getSlidingScale()	{
		return this.sliding_scale;
	}
	public HashMap getSupportDrugs(){//Adding start for TH-KW-CRF-0007
		return SupportDrugs;
	}
	public void setSupportdrugList(String drugcode){
		SupportdrugList.add(drugcode);
	}
	public ArrayList getSupportdrugList(){
		return this.SupportdrugList;
	}
	public void setSupportDrugs(HashMap newSuppDrugs) {
	  if(newSuppDrugs == null)
		  this.SupportDrugs = new HashMap();
		this.SupportDrugs = newSuppDrugs;
  }
  public void setnewSupdrugList(ArrayList drugList){
	  if(drugList ==null)
		  this.SupportdrugList =new ArrayList();
		this.SupportdrugList=drugList;
	}//Adding end for TH-KW-CRF-0007
	
	
/* Set and get methods */ 

/* Over-ridden Adapter methods start here */
    public HashMap validate() throws Exception {
		
        HashMap map                 =   new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;

		
		return map ;
    }

    public HashMap insert() {
		HashMap map = new HashMap() ;
		//ADDED FOR SKR-SCF-1312
		//HashMap hmTemp				=		new HashMap(); //Commented for common-icn-0048
		ArrayList alTemp			=		new ArrayList();
		String longDesc = "";//added for SKR-SCF-1312
		map.put( "result", new Boolean( false ) ) ;

		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		
        HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
//		DrugMasterHome   home=null;
//		DrugMasterRemote remote=null;
		try {

			if(prescribing_det.size() > 1) {
				if( ((String)prescribing_det.get(4)).equals("")) {
					prescribing_det.remove(5);
					prescribing_det.add(5,"");
				}
			}
			//added for SKR-SCF-1312 START
			//System.out.println("drugmastermain: "+drugmastermain.toString());
			alTemp = getDescFromMM((String) drugmastermain.get(0), getLanguageId()); 
			//String longDesc = alTemp.get(0).toString() ;
			if(alTemp==null || alTemp.isEmpty()){ 
				longDesc = (String) drugmastermain.get(1) ;
			}
			else{
				//longDesc = alTemp.get(0).toString() ;  // SKR-SCF-1691
				longDesc = alTemp.get(1).toString() ;  // SKR-SCF-1691  // Changed to Long description
			} 
          //added for SKR-SCF-1312 END 
            System.err.println("===SKR-SCF-1691 ==="+longDesc+"==drugmastermain"+drugmastermain);
			tabData.put("properties", getProperties() );
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("drugmastermain",drugmastermain);
			tabData.put("characteristics",characteristics);
			tabData.put("prescribing_det",prescribing_det);
			tabData.put("iv_char",iv_char);
			tabData.put("trade",trade);
			tabData.put("ageGroup",ageGroup);
			tabData.put("inventory",inventory);	
			tabData.put("generic",generic);
			tabData.put("supportive",getSupportdrugList());//Added for TH-KW-CRF-0007
			tabData.put("longDesc",longDesc);	//added for SKR-SCF-1312
			if(dispensing.size() <23) {//Increase the Size from 20 to 23 for Bru-HIMS-CRF-405[IN 044830]
				for(int i=0; i<22; i++)	{//Increase the Size from 19 to 22 for Bru-HIMS-CRF-405[IN 044830]
					if(i==0 || i==1 || i==2 || i==5 || i==6 || i==7 || i==14 || i==16 || i==17)
						dispensing.add("N");
					else if(i==15)
						dispensing.add("Y");
					else
						dispensing.add("");
				}
				dispensing.add(19,"");//Added Drug_Indication For ML-BRU-CRF-072[Inc:29938]
			}
			if(external_db.size()==0) {
				external_db.add("");
			}

			tabData.put("external_db",external_db);
			tabData.put("dispensing",dispensing);
			tabData.put("Comp_Fluids",Comp_Fluids);
			tabData.put("sliding_scale_chkd_values",sliding_scale_chkd_values);
			
		//	sqlMap.put( "SQL_PH_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_DRUG_INSERT") );
		//	sqlMap.put("SQL_PH_DRUG_INSERT","INSERT INTO PH_DRUG(DRUG_CODE, DRUG_DESC, IN_FORMULARY_YN, LINK_TO_EXISTING_ITEM, ITEM_CODE, GENERIC_ID, DRUG_CLASS,COMPOUND_DRUG_YN, FORM_CODE, ROUTE_CODE,DRUG_TYPE, SCHEDULE_ID, RESTRICTED_DRUG_YN, TRIAL_DRUG_YN, AFFECTS_PREGNANCY_YN, AFFECTS_BREAST_FEEDING_YN, AFFECTS_LAB_RESULTS_YN, STABILITY_REQD_YN, STABILITY_HRS,PT_COUN_REQD_YN,PRES_BASE_UOM, CALC_DOSG_BY_FREQ_DURN_YN,STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,FRACT_DOSE_ROUND_UP_YN,STOCK_UOM,CONTENT_IN_PRES_BASE_UOM,CALC_DEF_DOSAGE_YN,DISP_ALT_FORM_YN,DISP_MULTI_STRENGTH_YN,PRN_DOSES_PRES_PRD_FILL, PRN_DOSES_CONT_DAILY_FILL, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID_2, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT,HOW_TO_TAKE_TEXT_LOCAL,SPL_INSTR_LABEL_TEXT_ID1,IV_INGREDIENT_YN, IV_FLUID_YN, INFUSE_OVER_VALUE, INFUSE_OVER_DURN_TYPE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,PHYSICAL_FORM,IV_FLUID_FOR_ONCO_YN,DFLT_FLUID_CODE,APPL_PIGGY_BACK_YN,APPL_TO_RECONST_FLUID_YN,APPL_TO_TDM_YN,APPL_TO_VERBAL_ORDER_YN,APPL_FOR_COMPOUNDING_RX_YN,MEDN_ADMN_DTL_REQD_YN,DRUG_INFORMATION,PATIENT_EDUCATION,WEIGHT_REC_APPL_AGE_GROUP,DIAG_REC_APPL,DIAG_SCR_NOTE_TYPE,FRACT_DOSE_APPL_YN,ITEM_IMAGE_FILENAME,VERIFICATION_REQD_YN, EDL_CODES,EDL_REMARKS,ALLOW_MORETHAN_PRES_QTY_YN,PREG_CATEGORY_GROUP_CODE,PREG_CATEGORY_CODE1,PREG_CATEGORY_CODE2,PREG_CATEGORY_CODE3 ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		    //patient_stock_required ADDED FOR  ghl-crf-0482
			sqlMap.put("SQL_PH_DRUG_INSERT","INSERT INTO PH_DRUG(DRUG_CODE, DRUG_DESC, IN_FORMULARY_YN, LINK_TO_EXISTING_ITEM, ITEM_CODE, GENERIC_ID, DRUG_CLASS,COMPOUND_DRUG_YN, FORM_CODE, ROUTE_CODE,DEFAULT_ROUTE_YN,DRUG_TYPE, SCHEDULE_ID, RESTRICTED_DRUG_YN, TRIAL_DRUG_YN, AFFECTS_PREGNANCY_YN, AFFECTS_BREAST_FEEDING_YN, AFFECTS_LAB_RESULTS_YN, STABILITY_REQD_YN, STABILITY_HRS,PT_COUN_REQD_YN,PRES_BASE_UOM, CALC_DOSG_BY_FREQ_DURN_YN,STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,FRACT_DOSE_ROUND_UP_YN,STOCK_UOM,CONTENT_IN_PRES_BASE_UOM,CALC_DEF_DOSAGE_YN,DISP_ALT_FORM_YN,DISP_MULTI_STRENGTH_YN,PRN_DOSES_PRES_PRD_FILL, PRN_DOSES_CONT_DAILY_FILL, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID_2, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT,HOW_TO_TAKE_TEXT_LOCAL,SPL_INSTR_LABEL_TEXT_ID1,IV_INGREDIENT_YN, IV_FLUID_YN, INFUSE_OVER_VALUE, INFUSE_OVER_DURN_TYPE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,PHYSICAL_FORM,IV_FLUID_FOR_ONCO_YN,DFLT_FLUID_CODE,APPL_PIGGY_BACK_YN,APPL_TO_RECONST_FLUID_YN,APPL_TO_TDM_YN,APPL_TO_VERBAL_ORDER_YN,APPL_FOR_COMPOUNDING_RX_YN,MEDN_ADMN_DTL_REQD_YN,DRUG_INFORMATION,PATIENT_EDUCATION,WEIGHT_REC_APPL_AGE_GROUP,DIAG_REC_APPL,DIAG_SCR_NOTE_TYPE,FRACT_DOSE_APPL_YN,ITEM_IMAGE_FILENAME,VERIFICATION_REQD_YN, EDL_CODES,EDL_REMARKS,PREG_CATEGORY_GROUP_CODE, PREG_CATEGORY_CODE1,PREG_CATEGORY_CODE2, PREG_CATEGORY_CODE3, PROMPT_ALERT_PREFERRED_DRUG,  ALLOW_MORETHAN_PRES_QTY_YN,PRINT_LABEL_BASED_ON_QTY_YN,DEFAULT_DOSAGE_BY,NPB_DRUG_YN,DRUG_INDICATION,PREG_EFFECT_FT,PREG_EFFECT_ST,PREG_EFFECT_TT,PREG_WARN_REQ_FT_YN,PREG_WARN_REQ_ST_YN,PREG_WARN_REQ_TT_YN,REISSUE_TYPE_IND,REISSUE_COUNT_BY_IND,REISSUE_COUNT,DEFAULT_DOSAGE_BY_YN,PATIENT_STOCK_REQUIRED,DRUG_SEARCH_BY,DRUG_EXPIRY_ALERT_DAYS,REST_ANTI_JUSTFORM_YN,REST_ANTI_JUSTFORM_DURATION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //parameter DEFAULT_DOSAGE_BY_YN Added for AAKH-CRF-089  ,Added 'DEFAULT_DOSAGE_BY' For SKR-CRF-PHIS-003[IN028182] & Added Drug_Indication For ML-BRU-CRF-072[Inc:29938] //PREG_EFFECT added for RUT-CRF-0063 [IN:029601],//REISSUE_TYPE_IND,REISSUE_COUNT_BY_IND,REISSUE_COUNT Added for Bru-HIMS-CRF-405[IN 044830] //DRUG_SEARCH_BY Added for MMS-DM-CRF-0177
			//DRUG_EXPIRY_ALERT_DAYS Added for TH-KW-CRF-0008 // REST_ANTI_JUSTFORM_YN, REST_ANTI_JUSTFORM_DURATION Added for KDAH-CRF-0610

			sqlMap.put("SQL_PH_EXT_DRUG_INSERT",PhRepository.getPhKeyValue("SQL_PH_EXT_DRUG_INSERT") );
			sqlMap.put( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT") );
			sqlMap.put( "SQL_PH_GENERIC_NAME_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_DRUG_INSERT") );
			sqlMap.put( "SQL_PH_SUPPORTIVE_DRUGS_INSERT","INSERT INTO PH_SUPPORTIVE_DRUGS (PARENT_DRUG_CODE, SUPPORTIVE_DRUG_CODE,DISPLAY_SEQ_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");//Added for TH-KW-CRF-0007
			sqlMap.put( "SQL_PH_TRADE_NAME_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_TRADE_NAME_FOR_DRUG_INSERT") );
		//	sqlMap.put( "SQL_PH_COMP_FLUIDS_DRUG_INSERT","INSERT INTO PH_DRUG_COMPATIBILITY_FLUID(DRUG_CODE,FLUID_CODE,DEFAULT_YN,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			sqlMap.put( "SQL_PH_COMP_FLUIDS_DRUG_INSERT",PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_DRUG_INSERT") );
			sqlMap.put( "SQL_PH_AGE_GROUP_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_AGE_GROUP_FOR_DRUG_INSERT") );
			sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1",PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1") );
			sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT") );
		/*	sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1","DELETE  FROM PH_DRUG_SLIDING_SCALE_TMPL WHERE DRUG_CODE=?");
			sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT","INSERT INTO PH_DRUG_SLIDING_SCALE_TMPL(DRUG_CODE, TEMPLATE_ID,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)"); */

/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DRUG") ) ;
			home  = (DrugMasterHome) PortableRemoteObject.narrow( object, DrugMasterHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.insert( tabData, sqlMap ) ;*/
			String overlap_found_yn=overLapCheck( ageGroup,"I");
			if (overlap_found_yn.startsWith("Y")){
				map.put("flag",overlap_found_yn.substring(1, overlap_found_yn.length()));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message","APP-PH0001 Overlap found between age groups "); 
				return map;
			}

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DRUG"),DrugMasterHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			
			HashMap result=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() ){
				map.put("flag"," ");
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
			}
			else{
				map.put("flag"," ");
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message",(String) result.get( "msgid" )) ;
			}
			
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;

		}
		/*finally {
			try {
			
			} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/

		map.put("flag",debug);
		return map ;
	 }

	public HashMap modify() {
		
		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
		
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		//StringBuffer messages			=	new StringBuffer() ;
		//StringBuffer debug				= new StringBuffer() ;

		try {
			tabData.put("properties", getProperties() );
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("drugmastermain",drugmastermain);
			tabData.put("characteristics",characteristics);
System.err.println("===Drug Master BEan ==="+characteristics);
			tabData.put("prescribing_det",prescribing_det);
			tabData.put("iv_char",iv_char);
			tabData.put("trade",trade);
			tabData.put("inventory",inventory);	
			tabData.put("generic",generic);
			tabData.put("supportive",getSupportdrugList());//Added for TH-KW-CRF-0007

			if(getVersion().equals("PHBASIC")) {
				for(int i=0; i<22; i++){//Increase the Size from 19 to 22 for Bru-HIMS-CRF-405[IN 044830]
					if(i==0 || i==1 || i==2 || i==5 || i==6 || i==7 || i==14 || i==16 || i==17)
						dispensing.add("N");
					else if(i==15)
						dispensing.add("Y");
					else
						dispensing.add("");
				}
				dispensing.add(19,"");//Added Drug_Indication For ML-BRU-CRF-072[Inc:29938]
			}
			if(external_db.size()==0) {
				external_db.add("");
			}
			
			tabData.put("external_db",external_db);
			tabData.put("dispensing",dispensing);
			tabData.put("Comp_Fluids",Comp_Fluids);
			tabData.put("ageGroup",ageGroup);

			tabData.put("sliding_scale_chkd_values",sliding_scale_chkd_values);
		
			sqlMap.put("SQL_PH_EXT_DRUG_UPDATE",PhRepository.getPhKeyValue("SQL_PH_EXT_DRUG_UPDATE"));
			sqlMap.put("SQL_PH_EXT_DRUG_INSERT",PhRepository.getPhKeyValue("SQL_PH_EXT_DRUG_INSERT"));

			sqlMap.put("SQL_DOSAGE_LIMIT_BY_BASE_UPADATE","UPDATE PH_DOSAGE_LIMIT_FOR_AGE_GROUP SET DOSAGE_UNIT = ? WHERE LIMIT_IND='B' AND DRUG_CODE = ? "); // Added for ML-MMOH-CRF-0978
			sqlMap.put("SQL_DOSAGE_LIMIT_BY_STR_UPADATE" ,"UPDATE PH_DOSAGE_LIMIT_FOR_AGE_GROUP SET DOSAGE_UNIT = ? WHERE LIMIT_IND='S' AND DRUG_CODE = ? "); // Added for ML-MMOH-CRF-0978

		//	sqlMap.put( "SQL_PH_DRUG_UPDATE", PhRepository.getPhKeyValue("SQL_PH_DRUG_UPDATE") );//PATIENT_STOCK_REQUIRED ADDED FOR GHL-CRF-0482
				sqlMap.put("SQL_PH_DRUG_UPDATE","UPDATE PH_DRUG SET DRUG_DESC = ?,IN_FORMULARY_YN=?, LINK_TO_EXISTING_ITEM=?, ITEM_CODE=?,ROUTE_CODE=?,DRUG_TYPE = ?, SCHEDULE_ID = ?, RESTRICTED_DRUG_YN = ?, TRIAL_DRUG_YN=?, AFFECTS_PREGNANCY_YN = ?, AFFECTS_BREAST_FEEDING_YN = ?, AFFECTS_LAB_RESULTS_YN = ?, STABILITY_REQD_YN = ?, STABILITY_HRS = ?, PT_COUN_REQD_YN = ?,PRES_BASE_UOM = ?,CALC_DOSG_BY_FREQ_DURN_YN = ?, STRENGTH_VALUE = ?, STRENGTH_UOM = ?, STRENGTH_PER_PRES_UOM = ?, STRENGTH_PER_VALUE_PRES_UOM = ?, PRES_CATG_CODE = ?,  FRACT_DOSE_ROUND_UP_YN = ?,STOCK_UOM = ?, CONTENT_IN_PRES_BASE_UOM = ?,CALC_DEF_DOSAGE_YN =?, DISP_ALT_FORM_YN=?,  DISP_MULTI_STRENGTH_YN = ?, PRN_DOSES_PRES_PRD_FILL = ?, PRN_DOSES_CONT_DAILY_FILL = ?, DISP_AUTH_REQD_YN = ?, DISP_VIA_PRES_ONLY_YN = ?, DISP_AGAINST_DAMAGE_YN = ?, CAUTION_LABEL_TEXT_ID_1 = ?, CAUTION_LABEL_TEXT_ID_2 = ?, SPL_INSTR_LABEL_TEXT_ID = ?,   HOW_TO_TAKE_TEXT = ?,HOW_TO_TAKE_TEXT_LOCAL = ?, SPL_INSTR_LABEL_TEXT_ID1 = ? ,IV_INGREDIENT_YN = ?, IV_FLUID_YN = ?, INFUSE_OVER_VALUE = ?, INFUSE_OVER_DURN_TYPE = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,PHYSICAL_FORM=?,IV_FLUID_FOR_ONCO_YN=?,DFLT_FLUID_CODE=?,APPL_PIGGY_BACK_YN=?,APPL_TO_RECONST_FLUID_YN=?,APPL_TO_TDM_YN=?,APPL_TO_VERBAL_ORDER_YN=?,APPL_FOR_COMPOUNDING_RX_YN=? ,MEDN_ADMN_DTL_REQD_YN=?,DRUG_INFORMATION = ?,PATIENT_EDUCATION = ?,WEIGHT_REC_APPL_AGE_GROUP =?,DIAG_REC_APPL=?,DIAG_SCR_NOTE_TYPE=?,FRACT_DOSE_APPL_YN=?,ITEM_IMAGE_FILENAME = ?  ,VERIFICATION_REQD_YN=?, EDL_CODES=?,EDL_REMARKS=?,ALLOW_MORETHAN_PRES_QTY_YN=?,PREG_CATEGORY_GROUP_CODE =?, PREG_CATEGORY_CODE1 = ?, PREG_CATEGORY_CODE2 = ?, PREG_CATEGORY_CODE3 = ?, PROMPT_ALERT_PREFERRED_DRUG = ?, DEFAULT_ROUTE_YN=?,PRINT_LABEL_BASED_ON_QTY_YN=? ,DEFAULT_DOSAGE_BY=?,NPB_DRUG_YN=?,DRUG_INDICATION=?,PREG_EFFECT_FT=?,PREG_EFFECT_ST=?,PREG_EFFECT_TT=?,PREG_WARN_REQ_FT_YN=?,PREG_WARN_REQ_ST_YN=?,PREG_WARN_REQ_TT_YN=?,REISSUE_TYPE_IND=?,REISSUE_COUNT_BY_IND=?,REISSUE_COUNT=?,DEFAULT_DOSAGE_BY_YN=?,PATIENT_STOCK_REQUIRED=?,DRUG_SEARCH_BY=?,DRUG_EXPIRY_ALERT_DAYS=?, REST_ANTI_JUSTFORM_YN=?, REST_ANTI_JUSTFORM_DURATION=? WHERE DRUG_CODE=?");//added DEFAULT_DOSAGE_BY_YN  for AAKH-CRF-089   //Added 'DEFAULT_DOSAGE_BY' For SKR-CRF-PHIS-003[IN028182] & Added Drug_Indication For ML-BRU-CRF-072[Inc:29938]	//PREG_EFFECT added for RUT-CRF-0063 [IN:029601],//REISSUE_TYPE_IND,REISSUE_COUNT_BY_IND,REISSUE_COUNT Added for Bru-HIMS-CRF-405[IN 044830] //DRUG_SEARCH_BY Added for MMS-DM-CRF-0177//DRUG_EXPIRY_ALERT_DAYS Added for TH-KW-CRF-0008		// REST_ANTI_JUSTFORM_YN, REST_ANTI_JUSTFORM_DURATION Added for KDAH-CRF-0610
					
			sqlMap.put( "SQL_PH_TRADE_NAME_FOR_DRUG_UPDATE", PhRepository.getPhKeyValue("SQL_PH_TRADE_NAME_FOR_DRUG_UPDATE") );
			sqlMap.put( "SQL_PH_GENERIC_NAME_FOR_DRUG_UPDATE", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_DRUG_UPDATE") );
			sqlMap.put( "SQL_PH_COMP_FLUIDS_DRUG_UPDATE", PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_DRUG_UPDATE") );
			sqlMap.put( "SQL_PH_COMP_FLUIDS_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_DRUG_INSERT") );

			sqlMap.put( "SQL_PH_TRADE_NAME_FOR_DRUG_DELETE", PhRepository.getPhKeyValue("SQL_PH_TRADE_NAME_FOR_DRUG_DELETE") );
			sqlMap.put( "SQL_PH_GENERIC_NAME_FOR_DRUG_DELETE", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_DRUG_DELETE") );
			//sqlMap.put( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_DELETE", PhRepository.getPhKeyValue("SQL_PH_INVENTORY_ITEM_FOR_DRUG_DELETE") );

			//sqlMap.put( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT") );
			sqlMap.put( "SQL_PH_GENERIC_NAME_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_DRUG_INSERT") );
            sqlMap.put( "SQL_PH_SUPPORTIVE_DRUG_DELETE", "DELETE FROM PH_SUPPORTIVE_DRUGS WHERE PARENT_DRUG_CODE =?" );//Added for TH-KW-CRF-0007
			sqlMap.put( "SQL_PH_SUPPORTIVE_DRUGS_INSERT","INSERT INTO PH_SUPPORTIVE_DRUGS (PARENT_DRUG_CODE, SUPPORTIVE_DRUG_CODE,DISPLAY_SEQ_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");//Added for TH-KW-CRF-0007
			sqlMap.put( "SQL_PH_TRADE_NAME_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_TRADE_NAME_FOR_DRUG_INSERT") );
			// compatibiliy fluid --
			sqlMap.put( "SQL_PH_COMP_FLUIDS_STATUS_UPDATE", PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_STATUS_UPDATE") );
			sqlMap.put( "SQL_PH_DFLT_FLUID_UPDATE", PhRepository.getPhKeyValue("SQL_PH_DFLT_FLUID_UPDATE") );
			sqlMap.put( "SQL_PH_AGE_GROUP_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_AGE_GROUP_FOR_DRUG_INSERT") );
			sqlMap.put( "SQL_PH_AGE_GROUP_FOR_DRUG_UPDATE", PhRepository.getPhKeyValue("SQL_PH_AGE_GROUP_FOR_DRUG_UPDATE") );
			sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1",PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1") );
			sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT") );
			/*sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1","DELETE  FROM PH_DRUG_SLIDING_SCALE_TMPL WHERE DRUG_CODE=?");
			sqlMap.put("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT","INSERT INTO PH_DRUG_SLIDING_SCALE_TMPL(DRUG_CODE, TEMPLATE_ID,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");*/
		
		
		
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DRUG") ) ;
			home  = (DrugMasterHome) PortableRemoteObject.narrow( object, DrugMasterHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.modify( tabData, sqlMap ) ;*/
			String overlap_found_yn=overLapCheck( ageGroup,"DB");
			if (overlap_found_yn.startsWith("Y")){
				map.put("flag",overlap_found_yn.substring(1, overlap_found_yn.length()));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message","APP-PH0001 Overlap found between age groups "); 
				return map;
			}

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DRUG"),DrugMasterHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;
				
			Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

			HashMap result=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		//	HashMap result =	new HashMap();

			if( ((Boolean) result.get( "result" )).booleanValue() ){
				map.put("flag"," ");
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH" )) ;
			}
			else{
				map.put("flag"," ");
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message",result.get( "msgid" )) ;
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
			try{
				//messages.append( e.getMessage() ) ;
				//map.put( "flag", debug.toString() ) ;
				throw new Exception(e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				//messages.append( ee.getMessage() ) ;
				//map.put( "flag", debug.toString() ) ;
			}
		} 
		//map.put( "message",messages.toString()) ;
		
		return map ;
   }

   public HashMap delete() {

		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", " " );
		return map;
	 }

	public void clear() {
		super.clear() ;
		stock_yn		=	"";
		ip_yn			=	"";
		drugmastermain	=	new ArrayList();
		characteristics	=	new ArrayList();
		prescribing_det	=	new ArrayList();
		dispensing		=	new ArrayList();
		iv_char			=	new ArrayList();
		inventory		=	new ArrayList();
		trade			=	new ArrayList();
		ageGroup		=	new ArrayList();
		
		generic			=	new ArrayList();
		external_db		=	new ArrayList();
		Comp_Fluids		=	new ArrayList();
		sliding_scale	=	new ArrayList();
		SupportdrugList =   new ArrayList();
		SupportDrugs    =   new HashMap(); 
    }

	public void setAll( Hashtable recordSet ) {
		drugmastermain.clear();
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("drug_code"))
			drugmastermain.add(((String)recordSet.get("drug_code"))) ; //0 index in drugmaster array
		if(recordSet.containsKey("drug_desc")) {

			if(drugmastermain.size()==1){
				drugmastermain.add(((String)recordSet.get("drug_desc"))) ; //1 index in drugmaster
			}
			else {
				drugmastermain.set(1,((String)recordSet.get("drug_desc"))) ;//1 index in drugmaster array
			}
		}

		if(recordSet.containsKey("in_formulary_yn"))	{
         	if( ((String)recordSet.get("in_formulary_yn"))!=null && ((String)recordSet.get("in_formulary_yn")).equals(""))
	           drugmastermain.add("N") ;										//2 index in drugmaster array
			else
				drugmastermain.add(((String)recordSet.get("in_formulary_yn"))) ; //2index in drugmaster array
		}

		if(recordSet.containsKey("link_to_existing_item"))	{
			if( ((String)recordSet.get("link_to_existing_item"))!=null && ((String)recordSet.get("link_to_existing_item")).equals(""))
	           drugmastermain.add("N") ;										//3 index in drugmaster array
			else
				drugmastermain.add(((String)recordSet.get("link_to_existing_item"))) ; //3index in drugmaster array
		}

		if( ((String)recordSet.get("link_to_existing_item"))!=null && ((String)recordSet.get("link_to_existing_item")).equals("Y")){
			if(recordSet.containsKey("item_code"))
			   drugmastermain.add(((String)recordSet.get("item_code"))) ;  //4 index in drugmaster array
		}
		else
		   drugmastermain.add("") ;										//4 index in drugmaster array

		if(recordSet.containsKey("generic_id"))
           drugmastermain.add(((String)recordSet.get("generic_id"))) ; //5 index in drugmaster array

		if(recordSet.containsKey("drug_class"))
           drugmastermain.add(((String)recordSet.get("drug_class"))) ;    //6 index in drugmaster array

		if(recordSet.containsKey("compound_drug_yn"))	{
			if( ((String)recordSet.get("compound_drug_yn"))!=null && ((String)recordSet.get("compound_drug_yn")).equals(""))
	           drugmastermain.add("N") ;							//7 index in drugmaster array
			else
				drugmastermain.add(((String)recordSet.get("compound_drug_yn"))) ; //7 index in drugmaster array
         }

		if(recordSet.containsKey("form_code"))
          drugmastermain.add(((String)recordSet.get("form_code"))) ; //8 index in drugmaster array

		if(recordSet.containsKey("route_code"))
           drugmastermain.add(((String)recordSet.get("route_code"))) ; //9 index in drugmaster array

	    if(recordSet.containsKey("prompt_alert_for_preferred_drug")){
			if(((String)recordSet.get("prompt_alert_for_preferred_drug"))!=null && ((String)recordSet.get("prompt_alert_for_preferred_drug")).equals(""))
					drugmastermain.add("N") ;	//10index in drugmaster array
		    else
           drugmastermain.add(((String)recordSet.get("prompt_alert_for_preferred_drug"))) ; //10 index in drugmaster array
		}
		if(recordSet.containsKey("default_route_yn")){ //CRF -0034
			if(((String)recordSet.get("default_route_yn"))!=null && ((String)recordSet.get("default_route_yn")).equals(""))
					drugmastermain.add("N") ;	//11/index in drugmaster array
		    else
           drugmastermain.add(((String)recordSet.get("default_route_yn"))) ; //11 index in drugmaster array
		}
	   if(recordSet.containsKey("content_in_pres_base_uom"))
           dispensing.set(3,(String)recordSet.get("content_in_pres_base_uom")) ;
	  
	  
           drugmastermain.add(checkForNull((String)recordSet.get("drug_search_by"))) ; //12 index in drugmaster array //DRUG_SEARCH_BY Added for MMS-DM-CRF-0177 //Modified for MMS-DM-CRF-0177
	}

    private void doCommon() throws Exception {
	}
    /* Over-ridden Adapter methods end here */

    /* Function specific methods start */

	public HashMap loadIntialValues(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query            = "";
		
		String form_code			= "";
		String form_desc			= "";
		String module_id			= "";

		String	drug_code_gen_rule	=	"";
		String	drug_code_and_item	=	"";
		String	drug_item_code_link	=	"";
		String  drug_to_item_mapping=   "";  
		String  item_image_path=   "";  

		HashMap initialValues		= new HashMap();
		ArrayList	formCode		=	new ArrayList();
		ArrayList	formDesc		=	new ArrayList();

//		Hashtable	schedule		= new Hashtable();
		Hashtable	module			= new Hashtable();
		Hashtable	drug			= new Hashtable();

		try {
			connection  = getConnection() ;
		/******  Load Values for Form of Drug *******************/
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT1");
			pstmt				= null;
			resultSet			= null;
			pstmt				= connection.prepareStatement(sql_query) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet.next()){
				form_code	=	resultSet.getString("FORM_CODE");
				form_desc	=	resultSet.getString("FORM_DESC");
				formCode.add(form_code);
				formDesc.add(form_desc);
			}
			initialValues.put("formCode",formCode);
			initialValues.put("formDesc",formDesc);
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
//		initialValues.put("Form",form);

		/*********** Check for IP,Stock,OR Module Status ***************/
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT11");
			pstmt				= null;
			resultSet			= null;
			pstmt				= connection.prepareStatement(sql_query) ;
			resultSet			=   pstmt.executeQuery();
		
			while(resultSet.next()){
				module_id	=	resultSet.getString("MODULE_ID");
				
				if(module_id.trim().equals("ST")) {
					setStockModuleYN("Y"); 
				}
				else if ((module_id.trim().equals("IP")))	{
					setIPModuleYN("Y");  
				}
				else if ((module_id.trim().equals("OR")))	{
					setORModuleYN("Y");  
				}
			}
	
			initialValues.put("Module",module);
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			/*********** Initialize Drug Code ***************/
			sql_query           =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT12");
			pstmt				= null;
			resultSet			= null;
			pstmt				=	connection.prepareStatement(sql_query) ;
			resultSet			=   pstmt.executeQuery();
		
			while(resultSet.next()){
				drug_code_gen_rule	=	resultSet.getString("DRUG_CODE_GEN_RULE");
				drug_code_and_item	=	resultSet.getString("DRUG_AND_ITEM_CODE_SAME_IND");
				drug_item_code_link	=	resultSet.getString("DRUG_ITEM_CODE_LINK_REQD_YN");
				drug_to_item_mapping=	resultSet.getString("DRUG_TO_ITEM_MAPPING");
				item_image_path=	resultSet.getString("ITEM_IMAGE_PATH")==null?"":resultSet.getString("ITEM_IMAGE_PATH");
				drug.put("drug_code_gen_rule",drug_code_gen_rule);
				drug.put("drug_code_and_item",drug_code_and_item);
				drug.put("drug_item_code_link",drug_item_code_link);
				drug.put("drug_to_item_mapping",drug_to_item_mapping);
				initialValues.put("item_image_path",item_image_path);

			}
		
			setDrugCodeGenRule(drug_code_gen_rule);
			setDrugCodeAndItem(drug_code_and_item);
			setDrugItemCodeLink(drug_item_code_link);
			setDrugItemMapping(drug_to_item_mapping);
		/********************Initialize arraylist of characterisitcs & iv_char *****/
		
			for(int i=0; i<9; i++)	{
				if(i==0 || i==1 || i==7 || i==8){
					iv_char.add(i,"N");
				}
				else if(i==4){
					iv_char.add(i,"S");
				}
				else{ 
					iv_char.add(i,""); 
				}
			}
			closeStatement( pstmt ) ;
			for(int i=0; i<26; i++)	{
				if(i==1 || i==8 || i==14 ||i==15 ||i==16 ||i==17 ||i==18 ||i==20||i==21||i==22||i==23||i==24||1==25||i==26)
					characteristics.add(i,"");
				else
					characteristics.add(i,"N");
			}
			characteristics.add(19,"");
			characteristics.add(26,"");
			characteristics.add(27,"N");// code added for Bru-HIMS-CRF-070 [IN029935] 
			characteristics.add(28,"");// code added for RUT-CRF-0063 [IN:029601]
			characteristics.add(29,"");// code added for RUT-CRF-0063 [IN:029601]
			characteristics.add(30,"");// code added for RUT-CRF-0063 [IN:029601]
			characteristics.add(31,"N");// code added for RUT-CRF-0063 [IN:029601]
			characteristics.add(32,"N");// code added for RUT-CRF-0063 [IN:029601]
			characteristics.add(33,"N");// code added for RUT-CRF-0063 [IN:029601]
			characteristics.add(34,"N");//added for ghl-crf-0482
			characteristics.add(35,"");//Added for TH-KW-CRF-0008


			characteristics.add(36,"N");//added for KDAH-CRF-0610
			characteristics.add(37,""); //added for KDAH-CRF-0610
			closeResultSet( resultSet ) ;

			System.err.println("characteristics@@@initial values==="+characteristics);

		/** For checking the refill yn of facility param  **/
			pstmt		= null;
			resultSet	= null;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT28") ) ;
			pstmt.setString(1,getLoginFacilityId());
			resultSet	= pstmt.executeQuery(); 

			if ( resultSet != null && resultSet.next() ) {
				refill_yn	=	resultSet.getString("refill_yn");
			}
				this.setRefillYN(refill_yn);
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
				es.printStackTrace() ;
			}
		}
		return initialValues;
	}

/*********** Initialize the values for Schedule ***************/
	public ArrayList initializeValues(){
		
		ArrayList schedule		= new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT3") ) ;
			resultSet			= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap scheduleData=new HashMap();
				scheduleData.put( "schedule_id",resultSet.getString( "SCHEDULE_ID" ) ) ;
				scheduleData.put( "schedule_desc",resultSet.getString( "SCHEDULE_DESC" ) ) ;
				schedule.add(scheduleData);
			}

		} catch ( Exception e )	{
			try{
				e.printStackTrace() ;
				throw e ;
			}
				catch(Exception es){ es.printStackTrace();
			}
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return schedule;

	}

/*********** Initialize the values for Prescribing Details TAB***************/
	public HashMap loadPrescribingDetails(){
		
		HashMap PrescribingDetails  = new HashMap();
//		ArrayList	baseunit		= new ArrayList();
		ArrayList	strength		= new ArrayList();
		ArrayList	category		= new ArrayList();
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			
			/*********** Initialize the values for Strength***************/
			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT5") ) ;
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "uom_code",resultSet.getString( "uom_code" ) ) ;
				data.put( "short_desc",resultSet.getString( "short_desc" ) ) ;
				strength.add(data);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		/*********** Initialize the values for Base Unit***************/
		/***Values are loaded by loadBaseUnit Method *******/
		/**************ends*********************************************/		
		/*********** Initialize the values for  Category****************/
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT6") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "drug_catg_code",resultSet.getString( "drug_catg_code" ) ) ;
				data.put( "short_desc",resultSet.getString( "short_desc" ) ) ;
				category.add(data);
			}

			//PrescribingDetails.put( "baseunit",baseunit );
			PrescribingDetails.put( "strength",strength );
			PrescribingDetails.put( "category",category );

		}
		catch ( Exception e )	{
			//PrescribingDetails.put("error",e.toString());
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return PrescribingDetails;
	}

/*********** Initialize the values for Stock Unit ***************/
	public ArrayList loadStockUnit(String base_unit){
		ArrayList stock_unit	= new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT29") ) ;
			pstmt.setString(1,checkForNull(base_unit.trim()));
			pstmt.setString(2,checkForNull(base_unit.trim()));
			resultSet			= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				stock_unit.add(checkForNull(resultSet.getString( "UOM_CODE" )));
				stock_unit.add(checkForNull(resultSet.getString( "SHORT_DESC" )));
			}
		} 
		catch ( Exception e )	{
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return stock_unit;
	}

/*********** Populates the values for Default Fluid List box ***************/
	public ArrayList loadFluids(){
		
		ArrayList dflt_fluids	= new ArrayList();
		Connection connection	= null ;
		Statement stmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			stmt = connection.createStatement( ) ;
			resultSet			= stmt.executeQuery(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT30"));
			while ( resultSet != null && resultSet.next() ) {
				dflt_fluids.add(checkForNull(resultSet.getString( "DRUG_CODE" )));
				dflt_fluids.add(checkForNull(resultSet.getString( "DRUG_DESC" )));
			}
		} 
		catch ( Exception e )	{
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( stmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return dflt_fluids;
	}

/*********** Initialize the values for Dispensing Controls TAB ***************/
	public HashMap loadLabels(){
		HashMap labels			  = new HashMap();		
		ArrayList caution		  = new ArrayList();
		ArrayList spl_instruction = new ArrayList();
		ArrayList spl_instruction2 = new ArrayList();

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			/*********** Initialize the values for Caution***************/
			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT8A") ) ;
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "label_text_id",resultSet.getString( "label_text_id" ) ) ;
				data.put( "label_text_1",resultSet.getString( "label_text_1" ) ) ;
				data.put( "label_text_2",resultSet.getString( "label_text_2" ) ) ;
				data.put( "label_text_1_loc_lang",resultSet.getString( "label_text_1_loc_lang" ) ) ;
				data.put( "label_text_2_loc_lang",resultSet.getString( "label_text_2_loc_lang" ) ) ;
				caution.add(data);
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		
		/*********** Initialize the values for Special Instruction***************/
			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9B") ) ;
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "label_text_id",resultSet.getString( "label_text_id" ) ) ;
				data.put( "label_text_1",resultSet.getString( "label_text_1" ) ) ;
				data.put( "label_text_2",resultSet.getString( "label_text_2" ) ) ;
				data.put( "label_text_1_loc_lang",resultSet.getString( "label_text_1_loc_lang" ) ) ;
				data.put( "label_text_2_loc_lang",resultSet.getString( "label_text_2_loc_lang" ) ) ;
				spl_instruction.add(data);
			}

	// Not Required...   commented by PR Venkatasubbu on 27th Dec 2004.
	// bco'z the two combo's in the form lists the same details.
	// Added by Senthil kumar J on 15/4/2004
	/*********** Initialize the values for Special Instruction2***************/
/*		
		pstmt		= null;
		resultSet	= null;
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9") ) ;
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			HashMap data=new HashMap();
			data.put( "label_text_id",resultSet.getString( "LABEL_TEXT_ID" ) ) ;
			data.put( "label_text_1",resultSet.getString( "LABEL_TEXT_1" ) ) ;
			spl_instruction2.add(data);
			}
	//  ended...	
*/
		}
		catch ( Exception e )	{
			labels.put( "erorr :",e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		labels.put( "caution",caution );
		labels.put( "spl_instruction",spl_instruction );
		labels.put( "spl_instruction2",spl_instruction2 );
		return labels;
}

/************  Populating the base Unit ********/
	public ArrayList loadBaseUnit(String form_code){

		ArrayList	base_unit   = new ArrayList();

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	 uom_code		=	"";
		String	 uom_desc		=	"";
		String   default_uom	=	"";
		try{
			connection			= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT27") ) ;
			pstmt.setString(1,form_code);
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() ) {
				uom_code	=	resultSet.getString("UOM_CODE");
				uom_desc	=	resultSet.getString("SHORT_DESC");
				default_uom	=	resultSet.getString("DFLT_UOM_YN");

				base_unit.add(uom_code);
				base_unit.add(uom_desc);
				base_unit.add(default_uom);
			}
		}
		catch(Exception e){
			base_unit.add(e.toString());
		}
		 finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				base_unit.add(es.toString());
			}
		}
		return base_unit;		
	}

/*************  Populating Route based on Form of Drug *********/
	public ArrayList loadRoute(String form_code){

		ArrayList	route_values  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT2") ) ;
			pstmt.setString(1,form_code);
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() ) {
				route_values.add(resultSet.getString("ROUTE_CODE"));
				route_values.add(resultSet.getString("ROUTE_DESC"));
				route_values.add(checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389]
			}
	
		}
		catch(Exception e){
			System.err.println(e);
		}
		 finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				System.err.println(es);
			}
		}
		return route_values;		
	}
   
   //getting the ItemCode same as the Drug Code in modify mode when in formulary is checked
   public String getItemCode(String drug_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String Item_code="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT_ITEM_CODE")) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				Item_code		=	resultSet.getString("code");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return Item_code;
   }
//getting the drug class for given generic id
	public String getDrugClass(String generic_id){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 drug_class		= "";
		String   generic_name	=	"";
		HashMap	 generic_record	=	null;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT10") ) ;
			pstmt.setString(1,generic_id.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				drug_class		=	resultSet.getString("drug_class");
				generic_name	=	resultSet.getString("generic_name");
			}

			if(!generic_name.equals("") && generic.size()==0)	{
				generic_record	=	new HashMap();
				generic_record.put("generic_id",generic_id);
				generic_record.put("generic_name",generic_name);
				generic_record.put("drug_class",drug_class);
				generic_record.put("disp_seq_no",5+"");
				generic_record.put("flag","I");
				generic_record.put("select","");
				generic.add(generic_record);
			}
		
		}catch(Exception e){
			drug_class=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return drug_class;	
	}

	public String getDrugClassName(String generic_id){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 drug_class		= "";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT10") ) ;
			pstmt.setString(1,generic_id.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				drug_class		=	resultSet.getString("drug_class");
			}
		}
		catch(Exception e){
				drug_class=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return drug_class;	
	}

/***Used to check the drug code is present in OR ***/
	public boolean getDrugStatusInOR(String drug_code){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 drug_name		= "";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_OR_PH_COUNT_CHECK") ) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				drug_name		=	resultSet.getString("ORDER_CATALOG_CODE");
			}
	
		}catch(Exception e){
			drug_name=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		if(drug_name.equals(""))
				return false;
		else 
			return true;
	}
/***Used to check the drug code is present in OR ***/
//getting the EQVL 

	public String getEqvlValue(String uom_code, String eqvl_uom_code){
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 eqvl_value		= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT13") ) ;
			pstmt.setString(1,uom_code.trim());
			pstmt.setString(2,eqvl_uom_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					eqvl_value	=	resultSet.getString("eqvl_value");
			}
			else{
				resultSet	=	null;
				pstmt.setString(1,eqvl_uom_code.trim());
				pstmt.setString(2,uom_code.trim());
				resultSet	= pstmt.executeQuery();	
				if ( resultSet != null && resultSet.next() ) 
					eqvl_value	=	resultSet.getString("eqvl_value");
			}
		}
		catch(Exception e){
			eqvl_value=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return eqvl_value;	
	}

//getting the DFLT_IP_FILL_PROCESS
	public String getDefaultIPFillProcess(String form_code){
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String dflt_ip_fill_process = "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT15") ) ;
			pstmt.setString(1,form_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				dflt_ip_fill_process	=	resultSet.getString("dflt_ip_fill_process");
			}
		}catch(Exception e){
			dflt_ip_fill_process=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return dflt_ip_fill_process;	
	}

	public String getItemDescription(String itemCode){
	
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
//		String item_code			=	"";
		String item_description		=	"";
		String item_detail			=	"";
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT26") ) ;
			pstmt.setString(1,itemCode.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				itemCode			=	resultSet.getString("code");
				item_description	=	resultSet.getString("description");
			}
			item_detail	=	itemCode+":"+item_description;

		}catch(Exception e){
			item_detail=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return item_detail;	
	}

	public String getManufacturerName(String trade_id){

	
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		String manufacturer_id		=	"";
		String manufacturer_name	=	"";
		String manufacturer_detail	=	"";
		try{
			

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT24") ) ;
			pstmt.setString(1,trade_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				manufacturer_id		=	resultSet.getString("code");
				manufacturer_name	=	resultSet.getString("description");
			}
			
			manufacturer_detail	=	manufacturer_id+":"+manufacturer_name;
			
		}
		catch(Exception e){
			manufacturer_detail=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return manufacturer_detail;	
	}

	public boolean validateDrugCode(String drug_code)	{
		
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;
		int    count				=	0;
//		boolean result				=	false;
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT23") ) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				count	=	Integer.parseInt(resultSet.getString("TOT_COUNT"));
			}
		
		}catch(Exception e){
			System.err.println("Exception in Validating Drug Code:"+e);
			return false;	
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		if(count > 0)
			return false;	
		else
			return true;
	}

	public ArrayList loadSchedule()	{
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;
		HashMap record				=	null;
		ArrayList schedule			=	new ArrayList();
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT7") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				record.put("schedule_id",resultSet.getString("SCHEDULE_ID"));
				record.put("schedule_desc",resultSet.getString("SCHEDULE_DESC"));
				record.put("disp_auth_reqd_yn",resultSet.getString("DISP_AUTH_REQD_YN"));
				schedule.add(record);
			}
		}
		catch(Exception e){
			System.err.println("Exception in Validating Drug Code:"+e);
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return schedule;
	}

	public boolean loadDrugMasterValues(String drug_code)	{

		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;
		boolean result				=	false;
		HashMap	trade_record		=	null;
		HashMap	agegroup_record		=	null;
		HashMap	generic_record		=	null;
		String categoryDescription  = "";

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_DETAILS_SELECT1") ) ;
			//patient_stock_required added for  ghl-crf-0482
		pstmt				= connection.prepareStatement("SELECT DRUG_CODE, DRUG_DESC, IN_FORMULARY_YN, LINK_TO_EXISTING_ITEM, ITEM_CODE, GENERIC_ID, GENERIC_NAME, DRUG_CLASS, COMPOUND_DRUG_YN, FORM_CODE, FORM_DESC, PH_DRUG_VW.ROUTE_CODE, B.ROUTE_DESC, PROMPT_ALERT_PREFERRED_DRUG, DRUG_TYPE, SCHEDULE_ID, SCHEDULE_DESC, RESTRICTED_DRUG_YN,TRIAL_DRUG_YN, AFFECTS_PREGNANCY_YN, AFFECTS_BREAST_FEEDING_YN, AFFECTS_LAB_RESULTS_YN, STABILITY_REQD_YN, STABILITY_HRS, PT_COUN_REQD_YN,PRES_BASE_UOM, PRES_BASE_UOM_DESC,CALC_DOSG_BY_FREQ_DURN_YN, STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_UOM_DESC, STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM, PRES_CATG_CODE, PRES_CATG_DESC, STOCK_UOM, STOCK_UOM_DESC, CONTENT_IN_PRES_BASE_UOM, FRACT_DOSE_ROUND_UP_YN,DISP_ALT_FORM_YN, DISP_MULTI_STRENGTH_YN, PRN_DOSES_PRES_PRD_FILL, PRN_DOSES_CONT_DAILY_FILL, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID1_DESC, CAUTION_LABEL_TEXT_ID_2, CAUTION_LABEL_TEXT_ID2_DESC, SPL_INSTR_LABEL_TEXT_ID, SPL_INSTR_LABEL_TEXT_ID1,SPL_INSTR_LABEL_TEXT_ID_DESC, HOW_TO_TAKE_TEXT, IV_INGREDIENT_YN, IV_FLUID_YN, INFUSE_OVER_VALUE, INFUSE_OVER_DURN_TYPE,PHYSICAL_FORM, ORDER_TYPE_CODE, DISCONTINUED_YN, DISCONTINUED_REASON, DISCONTINUED_DATE, DISCONTINUED_BY_ID, TRADE_CODE, MANUFACTURER_ID,PHYSICAL_FORM,CALC_DEF_DOSAGE_YN, IV_FLUID_FOR_ONCO_YN,DFLT_FLUID_CODE,APPL_PIGGY_BACK_YN,APPL_TO_RECONST_FLUID_YN,APPL_TO_TDM_YN, APPL_TO_VERBAL_ORDER_YN, APPL_FOR_COMPOUNDING_RX_YN,HOW_TO_TAKE_TEXT_LOCAL,MEDN_ADMN_DTL_REQD_YN,DRUG_INFORMATION,PATIENT_EDUCATION,WEIGHT_REC_APPL_AGE_GROUP, DIAG_REC_APPL,DIAG_SCR_NOTE_TYPE,DRUG_INFORMATION, PATIENT_EDUCATION,FRACT_DOSE_APPL_YN,ITEM_IMAGE_FILENAME,verification_reqd_yn,EDL_CODES, EDL_REMARKS, ALLOW_MORETHAN_PRES_QTY_YN,PREG_CATEGORY_GROUP_CODE, PREG_CATEGORY_CODE1, PREG_CATEGORY_CODE2, PREG_CATEGORY_CODE3,DEFAULT_ROUTE_YN,PRINT_LABEL_BASED_ON_QTY_YN,DEFAULT_DOSAGE_BY,NPB_DRUG_YN,DRUG_INDICATION,PREG_EFFECT_FT,PREG_EFFECT_ST,PREG_EFFECT_TT,PREG_WARN_REQ_FT_YN,PREG_WARN_REQ_ST_YN,PREG_WARN_REQ_TT_YN,REISSUE_TYPE_IND,REISSUE_COUNT_BY_IND,REISSUE_COUNT,B.ROUTE_COLOR, DEFAULT_DOSAGE_BY_YN,PATIENT_STOCK_REQUIRED,DRUG_SEARCH_BY,DRUG_EXPIRY_ALERT_DAYS, REST_ANTI_JUSTFORM_YN, REST_ANTI_JUSTFORM_DURATION FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW,PH_ROUTE_LANG_VW b WHERE DRUG_CODE = ? and  PH_DRUG_VW.ROUTE_CODE=B.ROUTE_CODE and  PH_DRUG_VW.LANG1=B.LANGUAGE_ID AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ?") ;//added DEFAULT_DOSAGE_BY_YN parameter AAKH-CRF-089  //Added 'DEFAULT_DOSAGE_BY' For SKR-CRF-PHIS-003[IN028182] & 'DRUG_INDICATION' For  ML-BRU-CRF-072[Inc:29938] //PREG_EFFECT added for RUT-CRF-0063 [IN:029601],//REISSUE_TYPE_IND,REISSUE_COUNT_BY_IND,REISSUE_COUNT Added for Bru-HIMS-CRF-405[IN 044830] //DRUG_SEARCH_BY Added for MMS-DM-CRF-0177//DRUG_EXPIRY_ALERT_DAYS Added for TH-KW-CRF-0008 // REST_ANTI_JUSTFORM_YN, REST_ANTI_JUSTFORM_DURATION added for KDAH-CRF-0610
			pstmt.setString(1,drug_code.trim());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
			resultSet	= pstmt.executeQuery(); 

			if ( resultSet != null && resultSet.next() ) { 
				result = true;

				// Get all the values of Drug Master Main
				drugmastermain.add(checkForNull(resultSet.getString("DRUG_CODE")));
				drugmastermain.add(checkForNull(resultSet.getString("DRUG_DESC")));
				drugmastermain.add(checkForNull(resultSet.getString("IN_FORMULARY_YN")));
				drugmastermain.add(checkForNull(resultSet.getString("LINK_TO_EXISTING_ITEM")));
				drugmastermain.add(checkForNull(resultSet.getString("ITEM_CODE")));
				drugmastermain.add(checkForNull(""));
				drugmastermain.add(checkForNull(resultSet.getString("GENERIC_ID")));
				drugmastermain.add(checkForNull(resultSet.getString("GENERIC_NAME")));
				drugmastermain.add(checkForNull(resultSet.getString("DRUG_CLASS")));
				drugmastermain.add(resultSet.getString("COMPOUND_DRUG_YN"));
				drugmastermain.add(checkForNull(resultSet.getString("FORM_CODE")));
				drugmastermain.add(checkForNull(resultSet.getString("FORM_DESC")));
				drugmastermain.add(checkForNull(resultSet.getString("ROUTE_CODE")));
				drugmastermain.add(checkForNull(resultSet.getString("ROUTE_DESC")));
				drugmastermain.add(checkForNull(resultSet.getString("PROMPT_ALERT_PREFERRED_DRUG")));
				drugmastermain.add(checkForNull(resultSet.getString("DEFAULT_ROUTE_YN")));// Added For CRF -0034 Default Route check
				drugmastermain.add(checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389]
				drugmastermain.add(checkForNull(resultSet.getString("DRUG_SEARCH_BY"))); //Added for MMS-DM-CRF-0177
				
				setDrugMastermain(drugmastermain);

				// Get & Set All the values of Characteristics
				characteristics.clear();

				characteristics.add(checkForNull(resultSet.getString("DRUG_TYPE")));
				characteristics.add(checkForNull(resultSet.getString("SCHEDULE_ID")));
				characteristics.add(checkForNull(resultSet.getString("RESTRICTED_DRUG_YN")));
				characteristics.add(checkForNull(resultSet.getString("TRIAL_DRUG_YN")));
				characteristics.add(checkForNull(resultSet.getString("AFFECTS_PREGNANCY_YN")));
				characteristics.add(checkForNull(resultSet.getString("AFFECTS_BREAST_FEEDING_YN")));
				characteristics.add(checkForNull(resultSet.getString("AFFECTS_LAB_RESULTS_YN")));
				characteristics.add(checkForNull(resultSet.getString("STABILITY_REQD_YN")));
				characteristics.add(checkForNull(resultSet.getString("STABILITY_HRS")));       
				
				//code added by senthil kumar j on 15/4/2004
				characteristics.add(checkForNull(resultSet.getString("PT_COUN_REQD_YN")));  
				characteristics.add(checkForNull(resultSet.getString("APPL_TO_TDM_YN")));
				characteristics.add(checkForNull(resultSet.getString("APPL_TO_VERBAL_ORDER_YN")));

				//characteristics.add(checkForNull(resultSet.getString("DRUG_DESC")));
				characteristics.add(checkForNull(resultSet.getString("APPL_FOR_COMPOUNDING_RX_YN")));
				characteristics.add(checkForNull(resultSet.getString("MEDN_ADMN_DTL_REQD_YN")));
				//Mahesh
				characteristics.add(checkForNull(resultSet.getString("DRUG_INFORMATION")));		
				characteristics.add(checkForNull(resultSet.getString("PATIENT_EDUCATION")));			
				characteristics.add(checkForNull(resultSet.getString("WEIGHT_REC_APPL_AGE_GROUP")));	
				characteristics.add(checkForNull(resultSet.getString("DIAG_REC_APPL")));				
				characteristics.add(checkForNull(resultSet.getString("DIAG_SCR_NOTE_TYPE")));				
				characteristics.add(checkForNull(resultSet.getString("ITEM_IMAGE_FILENAME")));	
				
	
				//Addes For EDL Classifications

				characteristics.add(checkForNull(resultSet.getString("EDL_CODES")));		
				characteristics.add(checkForNull(resultSet.getString("EDL_REMARKS")));

				//Added for Pregnancy Category Codes on 10/8/2009
				characteristics.add(checkForNull(resultSet.getString("PREG_CATEGORY_GROUP_CODE")));	
				characteristics.add(checkForNull(resultSet.getString("PREG_CATEGORY_CODE1")));	
				characteristics.add(checkForNull(resultSet.getString("PREG_CATEGORY_CODE2")));	
				characteristics.add(checkForNull(resultSet.getString("PREG_CATEGORY_CODE3")));	
				categoryDescription =  getFDACategoryDescription(checkForNull(resultSet.getString("PREG_CATEGORY_GROUP_CODE")),getLanguageId());
				characteristics.add(categoryDescription);	//for category code description
				characteristics.add(checkForNull(resultSet.getString("NPB_DRUG_YN")));	//code added for Bru-HIMS-CRF-070 [IN029935]					
				characteristics.add(checkForNull(resultSet.getString("PREG_EFFECT_FT")));	//Added for PREG_EFFECT For RUT-CRF-0063[29601]	
				characteristics.add(checkForNull(resultSet.getString("PREG_EFFECT_ST")));	//Added for PREG_EFFECT For RUT-CRF-0063[29601]	
				characteristics.add(checkForNull(resultSet.getString("PREG_EFFECT_TT")));	//Added for PREG_EFFECT For RUT-CRF-0063[29601]	
				characteristics.add(checkForNull(resultSet.getString("PREG_WARN_REQ_FT_YN")));	//Added for PREG_EFFECT For RUT-CRF-0063[29601]	
				characteristics.add(checkForNull(resultSet.getString("PREG_WARN_REQ_ST_YN")));	//Added for PREG_EFFECT For RUT-CRF-0063[29601]	
				characteristics.add(checkForNull(resultSet.getString("PREG_WARN_REQ_TT_YN")));	//Added for PREG_EFFECT For RUT-CRF-0063[29601]	
				characteristics.add(checkForNull(resultSet.getString("PATIENT_STOCK_REQUIRED")));	//added for ghl-crf-0482
				characteristics.add(checkForNull(resultSet.getString("DRUG_EXPIRY_ALERT_DAYS")));// 35 Added for TH-KW-CRF-0008

				characteristics.add(checkForNull(resultSet.getString("REST_ANTI_JUSTFORM_YN")));  //added for KDAH-CRF-0610
				characteristics.add(checkForNull(resultSet.getString("REST_ANTI_JUSTFORM_DURATION")));  //37 added for KDAH-CRF-0610

				setCharacteristics(characteristics);
				//setSchedule_Ref(resultSet.getString("SCHEDULE_ID"));

				// Get & Set All the values of Prescribing Details
				prescribing_det.add(checkForNull(resultSet.getString("PRES_BASE_UOM")));
				prescribing_det.add(checkForNull(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")));
				prescribing_det.add(checkForNull(resultSet.getString("STRENGTH_VALUE")));
				prescribing_det.add(checkForNull(resultSet.getString("STRENGTH_UOM")));
				prescribing_det.add(checkForNull(resultSet.getString("STRENGTH_PER_PRES_UOM")));
				prescribing_det.add(checkForNull(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
				prescribing_det.add(checkForNull(resultSet.getString("PRES_CATG_CODE")));
				prescribing_det.add("");
				prescribing_det.add("");
//	Added by raghunath					
				prescribing_det.add(checkForNull(resultSet.getString("STOCK_UOM")));
				prescribing_det.add(checkForNull(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
				prescribing_det.add(checkForNull(resultSet.getString("CALC_DEF_DOSAGE_YN")));
				prescribing_det.add(checkForNull(resultSet.getString("DEFAULT_DOSAGE_BY_YN")));//added DEFAULT_DOSAGE_BY_YN for AAKH-CRF-089
				
				setPrescription(prescribing_det);
				//setBaseUom_Ref(resultSet.getString("PRES_BASE_UOM"));

				// Get and set all the values of dispensing details
				 dispensing.add(checkForNull(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")));//0
/*			
// commented by raghunath to move these two fields from dispensing tab to prescription tab...
				 dispensing.add(checkForNull(resultSet.getString("STOCK_UOM")));
				 dispensing.add(checkForNull(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
*/				dispensing.add(checkForNull(resultSet.getString("DISP_ALT_FORM_YN")));//1
				dispensing.add(checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN")));//2
				dispensing.add(checkForNull(resultSet.getString("PRN_DOSES_PRES_PRD_FILL")));//3
				dispensing.add(checkForNull(resultSet.getString("PRN_DOSES_CONT_DAILY_FILL")));//4
				dispensing.add(checkForNull(resultSet.getString("DISP_AUTH_REQD_YN")));//5
				dispensing.add(checkForNull(resultSet.getString("DISP_VIA_PRES_ONLY_YN")));//6
				dispensing.add(checkForNull(resultSet.getString("DISP_AGAINST_DAMAGE_YN")));//7
				dispensing.add(checkForNull(resultSet.getString("CAUTION_LABEL_TEXT_ID_1")));//8
				dispensing.add(checkForNull(resultSet.getString("CAUTION_LABEL_TEXT_ID_2")));  //9
				dispensing.add(checkForNull(resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")));  //10
				dispensing.add(checkForNull(resultSet.getString("HOW_TO_TAKE_TEXT")));     //11
				dispensing.add(checkForNull(resultSet.getString("HOW_TO_TAKE_TEXT_LOCAL")));//12     
				dispensing.add(checkForNull(resultSet.getString("SPL_INSTR_LABEL_TEXT_ID1")));  //13
				dispensing.add(checkForNull(resultSet.getString("FRACT_DOSE_APPL_YN"))); //14
				dispensing.add("Y"); //15
				dispensing.add(checkForNull(resultSet.getString("ALLOW_MORETHAN_PRES_QTY_YN"))); //16
				dispensing.add(checkForNull(resultSet.getString("PRINT_LABEL_BASED_ON_QTY_YN"))); //18 Added for RUT-CRF-0067 Print label
				dispensing.add(checkForNull(resultSet.getString("DEFAULT_DOSAGE_BY"))); //18 --> //Added 'DEFAULT_DOSAGE_BY' For SKR-CRF-PHIS-003[IN028182]
				dispensing.add(checkForNull(resultSet.getString("DRUG_INDICATION")));//19-->//Added Drug_Indication For ML-BRU-CRF-072[Inc:29938]
				dispensing.add(checkForNull(resultSet.getString("REISSUE_TYPE_IND")));//20-->Added for Bru-HIMS-CRF-405[IN 044830]
				dispensing.add(checkForNull(resultSet.getString("REISSUE_COUNT_BY_IND")));//21-->Added for Bru-HIMS-CRF-405[IN 044830]
				dispensing.add(checkForNull(resultSet.getString("REISSUE_COUNT")));//22-->Added for Bru-HIMS-CRF-405[IN 044830]
				setDispensing(dispensing);				
		/*		setStockUom_Ref(resultSet.getString("STOCK_UOM"));
				setIPFillProcess_Ref(resultSet.getString("IP_FILL_PROCESS"));
				setPRNDosesPrdFill_Ref(resultSet.getString("PRN_DOSES_PRES_PRD_FILL"));
				setPRNDosesCntFill_Ref(resultSet.getString("PRN_DOSES_CONT_DAILY_FILL"));  */

				// Get and set all values for Iv_char
				iv_char.add(0,checkForNull(resultSet.getString("IV_INGREDIENT_YN")));
				iv_char.add(1,checkForNull(resultSet.getString("IV_FLUID_YN")));
				iv_char.add(2,checkForNull(resultSet.getString("INFUSE_OVER_VALUE")));
				iv_char.add(3,checkForNull(resultSet.getString("INFUSE_OVER_DURN_TYPE")));
				iv_char.add(4,checkForNull(resultSet.getString("PHYSICAL_FORM")));
				iv_char.add(5,checkForNull(resultSet.getString("IV_FLUID_FOR_ONCO_YN")));
				iv_char.add(6,checkForNull(resultSet.getString("DFLT_FLUID_CODE")));
				iv_char.add(7,checkForNull(resultSet.getString("APPL_PIGGY_BACK_YN")));
				iv_char.add(8,checkForNull(resultSet.getString("APPL_TO_RECONST_FLUID_YN")));					

				setIVChar(iv_char);
                loadSupportiveDrugs(drug_code.trim());//th-kw-crf-0007
				// Get and set all values for External Drug
				//external_db.add(0,checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID")));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			
			//Values of Trade names
			

			pstmt		= null;
			resultSet	= null;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRADE_NAME_FOR_DRUG_SELECT") ) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 

			while ( resultSet != null && resultSet.next() ) {
				trade_record	=	new HashMap();
				trade_record.put("trade_id",resultSet.getString("TRADE_ID"));
				trade_record.put("trade_name",resultSet.getString("SHORT_DESC1"));
				trade_record.put("manufacturer_id",resultSet.getString("MANUFACTURER_ID"));
				trade_record.put("manufacturer_name",resultSet.getString("SHORT_DESC2"));
				trade_record.put("disp_seq_no",resultSet.getString("DISPLAY_SEQ_NO"));
				trade_record.put("eff_status",resultSet.getString("EFF_STATUS"));
				trade_record.put("flag","DB");
				trade_record.put("trade_image_filename",resultSet.getString("TRADE_IMAGE_FILENAME"));
				trade.add(trade_record);
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;


			pstmt		= null;
			resultSet	= null;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AGE_GROUP_FOR_DRUG_SELECT") ) ;
			//	pstmt				= connection.prepareStatement("SELECT a.AGE_GROUP_CODE AGE_GROUP_CODE, a.SHORT_DESC SHORT_DESC, a.MIN_AGE MIN_AGE, a.MAX_AGE MAX_AGE, a.AGE_UNIT AGE_UNIT,  b.EFF_STATUS EFF_STATUS, Nvl(a.GENDER,'A') GENDER,b.WT_MAND_YN WT_MAND_YN,b.DRUG_APPL_YN DRUG_APPL_YN FROM   AM_AGE_GROUP_LANG_VW a ,PH_DRUG_AGE_GROUP b WHERE a.AGE_GROUP_CODE=b.AGE_GROUP_CODE AND  b.DRUG_CODE =? AND a.LANGUAGE_ID=?"  ) ;
		
			pstmt.setString(1,drug_code.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() ) {
				agegroup_record	=	new HashMap();
				agegroup_record.put("age_group_code",resultSet.getString("AGE_GROUP_CODE"));
				agegroup_record.put("short_desc",resultSet.getString("SHORT_DESC"));
				agegroup_record.put("gender", resultSet.getString("GENDER")==null?"A": resultSet.getString("GENDER"));
				agegroup_record.put("max_age",resultSet.getString("MAX_AGE"));
				agegroup_record.put("age_unit",resultSet.getString("AGE_UNIT"));
				agegroup_record.put("eff_status",resultSet.getString("EFF_STATUS"));
				agegroup_record.put("min_age",resultSet.getString("MIN_AGE"));
				agegroup_record.put("flag","DB");
				agegroup_record.put("eff_status_weight",resultSet.getString("WT_MAND_YN"));
				agegroup_record.put("ht_mand_yn",resultSet.getString("HT_MAND_YN"));
				agegroup_record.put("eff_status_drug_appl",resultSet.getString("DRUG_APPL_YN"));
				ageGroup.add(agegroup_record);
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;


			//Values of Generic names
			pstmt		= null;
			resultSet	= null;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_DRUG_SELECT") ) ;
		//	pstmt				= connection.prepareStatement( "SELECT A.GENERIC_ID,B.GENERIC_NAME,DECODE(B.DRUG_CLASS,'G','General','C','Controlled','N','Narcotics') DRUG_CLASS, DISPLAY_SEQ_NO FROM PH_GENERIC_NAME_FOR_DRUG A,PH_GENERIC_NAME B WHERE A.GENERIC_ID=B.GENERIC_ID AND A.DRUG_CODE=? order by display_seq_no" ) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 

			while ( resultSet != null && resultSet.next() ) {
				generic_record	=	new HashMap();
				generic_record.put("generic_id",resultSet.getString("GENERIC_ID"));
				generic_record.put("generic_name",resultSet.getString("GENERIC_NAME"));
				generic_record.put("drug_class",resultSet.getString("DRUG_CLASS"));
				generic_record.put("disp_seq_no",resultSet.getString("DISPLAY_SEQ_NO"));
				generic_record.put("flag","DB");
				generic.add(generic_record);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return result;
	}

	public boolean updateGeneric(String genericId)	{
		HashMap record			=	null;
		boolean delete_status	=	false;

		if(generic.size()>0)	{
			for(int i=0; i<generic.size(); i++)	{
				record	=	(HashMap)generic.get(i);
				String bean_genericId	=	(String)record.get("generic_id");
				if(bean_genericId.equals(genericId))	{
					delete_status	=	true;
					record.put("flag","D");
				}
			}
		}
		return delete_status;
	}

	public boolean updateTrade(String tradeId)	{
		HashMap record			=	null;
		boolean delete_status	=	false;
        
		if(trade.size()>0)	{
			for(int i=0; i<trade.size(); i++)	{
				record	=	(HashMap)trade.get(i);
				String bean_tradeId	=	(String)record.get("trade_id");
				if(bean_tradeId.equals(tradeId))	{
					delete_status	=	true;
					record.put("flag","D");
				}
			}
		}
		return delete_status;
	}

	public boolean updateInventory(String itemCode)	{
		HashMap record			=	null;
		boolean delete_status	=	false;

		if(inventory.size()>0)	{
			for(int i=0; i<inventory.size(); i++)	{
				record	=	(HashMap)inventory.get(i);
				String bean_itemCode	=	(String)record.get("item_code");
				if(bean_itemCode.equals(itemCode))	{
					delete_status	=	true;
					record.put("flag","D");
				}
			}
		}
		return delete_status;
	}

	public ArrayList sortList( ArrayList recordList, String key ) {
		int keyVal[] = new int[recordList.size()];
		// Take all the keys values and put it in the array
		for(int i=0; i<recordList.size() ; i++) {
			HashMap hashMap = (HashMap) recordList.get(i) ;
			int keydata = Integer.parseInt((String) hashMap.get(key)) ;
			keyVal[i] = keydata ; 
		}

		// sort the key value array
		for(int i=0 ; i< keyVal.length-1 ; i++ ) {
			for(int j=0 ; j< keyVal.length-i-1 ; j++) {
				if( keyVal[j] > keyVal[j+1] ) {
					int temp = keyVal[j] ;
					keyVal[j] = keyVal[j+1] ;
					keyVal[j+1] = temp ;
				}
			}
	}
	// create a sorted ArrayList by picking with the sorted index
	//	String position[] = new String[recordList.size()];
		ArrayList sortedList = new ArrayList();
		for(int i=0 ; i< keyVal.length ; i++ ) {
			sortedList.add( recordList.get(findPosition(recordList, key, keyVal[i])));
		}
		return sortedList ;
	}

	private int findPosition(ArrayList recordList, String key, int keyVal) {

		for(int i=0 ; i<recordList.size() ; i++ ) {
			HashMap dataMap = (HashMap) recordList.get(i) ;
			if( Integer.parseInt( ((String)dataMap.get(key)))==keyVal )
				return i;
		}
		return -1;
	}

	public int getMaxDispNo(String link)	{

		int max_no	=	0;
		ArrayList	data	=	null;
		HashMap		record	=	null;

		if(link.equals("trade_tab"))	{
			data	=	this.getTradeNames();
		}
		else if(link.equals("generic_tab"))	{
			data	=	this.getGenericNames();
		}
		else if(link.equals("weightrecording_tab"))	{
			data	=	this.getAgeGroups();
		}
		for(int i=0; i<data.size(); i++)	{
			record	= (HashMap) data.get(i);
			int tmp_no	= Integer.parseInt((String)record.get("disp_seq_no"));
			if(tmp_no > max_no)
				max_no	= tmp_no;
		}
		return max_no;
	}

	public ArrayList makeInventoryRecord(String uom_code,String uom_desc,String eqvl_uom_code,String strength,String item_code,String item_desc)	{

		/*get the eqvl value**/
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 eqvl_value		= "";
		HashMap	inventory_record	=	null;

		
		try{

			if(uom_code.equals(eqvl_uom_code))	
				eqvl_value		=	"1";
			else	{
				connection			= getConnection() ;
				pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT13") ) ;
				pstmt.setString(1,uom_code.trim());
				pstmt.setString(2,eqvl_uom_code.trim());
				resultSet	= pstmt.executeQuery(); 
				if ( resultSet != null && resultSet.next() ) {
						eqvl_value	=	resultSet.getString("eqvl_value");
				}
				else	{
					resultSet	=	null;
					pstmt.setString(1,eqvl_uom_code.trim());
					pstmt.setString(2,uom_code.trim());
					resultSet	= pstmt.executeQuery();	
					if ( resultSet != null && resultSet.next() ) 
						eqvl_value	=	resultSet.getString("eqvl_value");
				}
			}

			if(!eqvl_value.equals("") && inventory.size()<1)	{
				inventory_record	=	new HashMap();
				inventory_record.put("item_code",item_code);
				inventory_record.put("item_desc",item_desc);
				inventory_record.put("stock_uom_code",uom_code);
				inventory_record.put("stock_uom_desc",uom_desc);
				inventory_record.put("base_uom",eqvl_value);
				inventory_record.put("strength_uom",strength);
				inventory_record.put("flag","I");
				inventory_record.put("select","");
				inventory.add(inventory_record);
			}
		}
		catch(Exception e){
			eqvl_value=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return inventory;
	}

	public String checkOrderable(String drug)	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		String	 drug_code_status		= "N";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_OR_PH_COUNT_CHECK") ) ;
			pstmt.setString(1,drug.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
//				String drug_code			=	resultSet.getString("ORDER_CATALOG_CODE");
				drug_code_status	=	"Y";
			}
		}
		catch(Exception e){
			drug_code_status=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return drug_code_status;
	}
//Mahesh
	public boolean checkExternalProduct()	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		boolean	 result					= false;
		PhDrugDatabaseInterfaceLicense license=new PhDrugDatabaseInterfaceLicense();
		String licensevalue=license.getLicense();
		try{
			
				connection			= getConnection() ;
				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DB_INTERFACE_YN"));
				resultSet	= pstmt.executeQuery(); 
				
				while(resultSet.next()){
					if ( resultSet.getString("DRUG_DB_INTERFACE_YN").equals("Y") && licensevalue.equals("Y")) {
						result		=	true;
					}
				}
		}
		catch(Exception e){
			System.err.println("Error while checking external link ="+e);
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}

		return result;
	}
	
	public ArrayList getDrugDatabase(String drug_code ) {
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		ArrayList drug_database		= new ArrayList();
	//	String sql = "SELECT A.DRUG_CODE, A.PRODUCT_ID, B.PRODUCT_DESC, A.EXT_PROD_DRUG_CODE, A.EFF_STATUS, 'U' DB_ACTION FROM PH_DRUG_EXT_PROD_DRUG A, PH_EXTERNAL_PRODUCT_LANG_VW B WHERE A.DRUG_CODE = ? AND A.PRODUCT_ID = 'FDB' AND A.PRODUCT_ID = B.PRODUCT_ID AND B.LANGUAGE_ID = ? ORDER BY PRODUCT_DESC";

		try{
			connection			= getConnection() ;
		//	pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EXT_DRUG_DB_ACTION"));
			/*SELECT NULL DRUG_CODE,PRODUCT_ID, PRODUCT_DESC, NULL EXT_PROD_DRUG_CODE, 'D' EFF_STATUS , 'I' DB_ACTION FROM PH_EXTERNAL_PRODUCT_LANG_VW PH_EXTERNAL_PRODUCT WHERE PRODUCT_ID NOT IN (SELECT PRODUCT_ID FROM PH_DRUG_EXT_PROD_DRUG WHERE DRUG_CODE = ? ) AND LANGUAGE_ID = ? UNION ALL SELECT A.DRUG_CODE, A.PRODUCT_ID, B.PRODUCT_DESC, A.EXT_PROD_DRUG_CODE, A.EFF_STATUS, 'U' DB_ACTION FROM PH_DRUG_EXT_PROD_DRUG A, PH_EXTERNAL_PRODUCT_LANG_VW B WHERE A.DRUG_CODE = ? AND A.PRODUCT_ID = B.PRODUCT_ID AND B.LANGUAGE_ID = ? ORDER BY PRODUCT_DESC*/
			String sql ="SELECT NULL DRUG_CODE,PRODUCT_ID, PRODUCT_DESC, NULL EXT_PROD_DRUG_CODE, 'D' EFF_STATUS , 'I' DB_ACTION FROM PH_EXTERNAL_PRODUCT_LANG_VW PH_EXTERNAL_PRODUCT WHERE PRODUCT_ID NOT IN (SELECT PRODUCT_ID FROM PH_DRUG_EXT_PROD_DRUG WHERE DRUG_CODE = ? ) AND LANGUAGE_ID = ? AND PRODUCT_ID = (select DRUG_DB_PRODUCT_ID from ph_facility_param where facility_id=?)  UNION ALL SELECT A.DRUG_CODE, A.PRODUCT_ID, B.PRODUCT_DESC, A.EXT_PROD_DRUG_CODE, A.EFF_STATUS, 'U' DB_ACTION FROM PH_DRUG_EXT_PROD_DRUG A, PH_EXTERNAL_PRODUCT_LANG_VW B WHERE A.DRUG_CODE = ? AND A.PRODUCT_ID = B.PRODUCT_ID AND B.LANGUAGE_ID = ? AND A.PRODUCT_ID=(select DRUG_DB_PRODUCT_ID from ph_facility_param where facility_id=?) ORDER BY PRODUCT_DESC";
			pstmt				= connection.prepareStatement(sql);
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLoginFacilityId());
			pstmt.setString(4,drug_code);
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLoginFacilityId());
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() ) {
				drug_database.add(resultSet.getString("PRODUCT_ID"));
				drug_database.add(resultSet.getString("EXT_PROD_DRUG_CODE"));
				drug_database.add(resultSet.getString("EFF_STATUS"));
				drug_database.add(resultSet.getString("DB_ACTION"));
				drug_database.add(resultSet.getString("PRODUCT_DESC"));
			
			}
		}catch(Exception e){
			System.err.println("Error while loading drug database");
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return drug_database;
	}
	//new
	public ArrayList getComps(String drug_code ) {
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		ArrayList Comp_Fluid		= new ArrayList();


		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_DRUG_SELECT"));
			pstmt.setString(1,drug_code);
			pstmt.setString(2,drug_code);
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,drug_code);
			pstmt.setString(5,getLanguageId());
			resultSet	= pstmt.executeQuery(); 

			while ( resultSet != null && resultSet.next() ) {
				Comp_Fluid.add(resultSet.getString("FLUID_CODE"));
				Comp_Fluid.add(resultSet.getString("DEFAULT_YN"));
				Comp_Fluid.add(resultSet.getString("EFF_STATUS"));
				Comp_Fluid.add(resultSet.getString("DB_ACTION"));
				Comp_Fluid.add(resultSet.getString("DEFAULT_INFUSE_OVER_VALUE") ==null?"":resultSet.getString("DEFAULT_INFUSE_OVER_VALUE"));//Added for ML-MMOH-CRF-1223
			}
		}catch(Exception e){
			System.err.println("Error while loading Compatible Fluids");
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return Comp_Fluid;
	}
	public ArrayList loadAgeGroups(){
		
		ArrayList age_group		= new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT32"));
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while ( resultSet != null && resultSet.next() ) {
				age_group.add(checkForNull(resultSet.getString("AGE_GROUP_CODE")));
				age_group.add(checkForNull(resultSet.getString("SHORT_DESC")));
			}
		} 
		catch ( Exception e )	{
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return age_group;
	}
	public ArrayList loadScreenNotes(){
		
		ArrayList screen_notes		= new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT33"));
			pstmt.setString(1,getLanguageId());
			resultSet			= pstmt.executeQuery(); 
			while ( resultSet != null && resultSet.next() ) {
				screen_notes.add(checkForNull(resultSet.getString("CODE")));
				screen_notes.add(checkForNull(resultSet.getString("DESCRIPTION")));
			}
		} 
		catch ( Exception e )	{
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return screen_notes;
	}
	//Mahesh
	public ArrayList getExternalDrugs(String drug_desc ) {
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		ArrayList external_drugs		= new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_SELECT12") ) ;
			drug_desc	= drug_desc +	"%";
			pstmt.setString(1,drug_desc);
			resultSet	= pstmt.executeQuery(); 

			while ( resultSet != null && resultSet.next() ) {
				external_drugs.add(checkForNull(resultSet.getString("DRUG_CODE")));
				external_drugs.add(checkForNull(resultSet.getString("DRUG_DESC")));
			}

		}catch(Exception e){
			System.err.println("Error while loading external drugs");
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return external_drugs;
	}

//  Added on 10/8/2004 for Piggy back checking

	public String getDefaultRouteCode(){
	
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		String dflt_iv_route_code	=	"";
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT31") ) ;
			//pstmt.setString(1,itemCode.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				dflt_iv_route_code	=	resultSet.getString("DFLT_IV_ROUTE_CODE");
			}

//		item_detail	=	itemCode+":"+item_description;

		}
		catch(Exception e){
			dflt_iv_route_code=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return dflt_iv_route_code;	
	}

	public boolean getCompFldStatus(String fluid_code){
		boolean status = false;
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		int countCompFluids			=  0;
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_STATUS_SELECT") ) ;
			pstmt.setString(1,fluid_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				countCompFluids	=	resultSet.getInt("cnt");
			}
			if(countCompFluids > 0) 
				status = true;
			else
				status = false;
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return status;
	}

	public boolean changeCompFldStatus(String fluid_code){
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;

		int ph_drg_comp_fluid		= 0;
		int ph_drg_dflt_fluid		= 0;
		boolean cmpFldUpdateFld		= false;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMP_FLUIDS_STATUS_UPDATE") ) ;
			pstmt.setString(1,login_by_id.trim());
			pstmt.setString(2,login_at_ws_no.trim());
			pstmt.setString(3,login_facility_id.trim());
			pstmt.setString(4,fluid_code.trim());

			ph_drg_comp_fluid = pstmt.executeUpdate() ;
			if(ph_drg_comp_fluid > 0)
				cmpFldUpdateFld = true;
			if(pstmt != null) 
				closeStatement( pstmt ) ;
			if(ph_drg_comp_fluid > 0){
				try{
					pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DFLT_FLUID_UPDATE") ) ;
					pstmt.setString(1,login_by_id.trim());
					pstmt.setString(2,login_at_ws_no.trim());
					pstmt.setString(3,login_facility_id.trim());
					pstmt.setString(4,fluid_code.trim());

					ph_drg_dflt_fluid = pstmt.executeUpdate() ;
					if(ph_drg_dflt_fluid > 0)
						cmpFldUpdateFld = true;
				}
				catch(Exception ein){
					ein.printStackTrace() ;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally {
			try{
//				connection.commit();
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return cmpFldUpdateFld;
	}
// Ends Here of 10/8/2004

	public ArrayList getAgeGroupID()	{
		/*get the eqvl value**/
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		//String	 eqvl_value		= "";
		HashMap	ageGroup1	=	null;
		ArrayList ageGroupID=new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AGE_GROUP_SELECT") ) ;
			//pstmt				= connection.prepareStatement("SELECT AGE_GROUP_CODE, SHORT_DESC, MIN_AGE,MAX_AGE, AGE_UNIT, GENDER FROM AM_AGE_GROUP_lang_vw WHERE  EFF_STATUS ='E' and language_id=?");
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while(resultSet.next()){
				ageGroup1=new HashMap();
				ageGroup1.put("age_group_code",resultSet.getString("AGE_GROUP_CODE"));
				ageGroup1.put("short_desc",resultSet.getString("SHORT_DESC"));
				ageGroup1.put("min_age",resultSet.getString("MIN_AGE"));
				ageGroup1.put("max_age",resultSet.getString("MAX_AGE"));
				ageGroup1.put("age_unit",resultSet.getString("AGE_UNIT"));
				ageGroup1.put("gender", resultSet.getString("GENDER")==null?"A": resultSet.getString("GENDER"));
				ageGroupID.add(ageGroup1);
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return ageGroupID;
	}

	public String overLapCheck(ArrayList ageList,String MD){
		StringBuffer overlap_found_yn = new StringBuffer("N");
		HashMap record = null;
		String select = "", eff_status1="";
		for (int i = 0; i < ageList.size(); i++) {
			record = (HashMap) ageList.get(i);
			select = (String) record.get("select") == null ? "": (String) record.get("select");
			eff_status1="";
			if(MD.equals("DB")){
				if(record.size()==11) { //changed from 10 to 11 for Bru-HIMS-CRF-079 IN[029945] 
					eff_status1 = ((String)record.get("eff_status"));
					if(eff_status1.equals("D")){
						select="N";
					}
					else{
						select="Y";
					}
				}
				else if( select.equals("") && eff_status1.equals("Y") )
					select="Y";
			}
			
			if (select.equals("Y")) {
				String age_code = (String) record.get("age_group_code");
				String short_desc = (String) record.get("short_desc");
				String gender = (String) record.get("gender");
				String max_age = (String) record.get("max_age");
				String age_unit = (String) record.get("age_unit");
				String min_age = (String) record.get("min_age");
				HashMap record1 = null;
				String eff_status2="", select1="", age_code1="",gender1="", short_desc1="" ;
				int min_age_added_age_group = 0;
				int max_age_added_age_group = 0;
				if (age_unit.equals("Y")) { //Age range overlapping check converted from days to Minutes
					min_age_added_age_group = (Integer.parseInt(min_age)) * 365 * 24 * 60;
					max_age_added_age_group = (Integer.parseInt(max_age)) * 365 * 24 * 60;
				} 
				else if (age_unit.equals("M")) { 
					min_age_added_age_group = (Integer.parseInt(min_age)) * 30 * 24 * 60;
					max_age_added_age_group = (Integer.parseInt(max_age)) * 30 * 24 * 60;
				} 
				else if (age_unit.equals("D")) {
					min_age_added_age_group = (Integer.parseInt(min_age)) * 24 * 60;
					max_age_added_age_group = (Integer.parseInt(max_age)) * 24 * 60;
				} 
				else if (age_unit.equals("H")) { //Hours
					min_age_added_age_group = (Integer.parseInt(min_age)) * 60;
					max_age_added_age_group = (Integer.parseInt(max_age)) * 60;
				} 
				else { //Minutes
					min_age_added_age_group = Integer.parseInt(min_age);
					max_age_added_age_group = Integer.parseInt(max_age);
				}
				for (int j = 0; j < ageList.size(); j++) {
			
					record1 = (HashMap) ageList.get(j);
					select1 = (String) record1.get("select") == null ? "" : (String) record1.get("select");
					eff_status2="";
					if(MD.equals("DB")){
						if(record1.size()==11) {//changed from 10 to 11 for Bru-HIMS-CRF-079 IN[029945] 
							eff_status2 = ((String)record1.get("eff_status"));
							if(eff_status2.equals("D")){
								select="N";
							}
							else{
								select="Y";
							}
						}
						else if( select1.equals("") && eff_status2.equals("Y") )
							select1="Y";
					}
					age_code1 = (String) record1.get("age_group_code");
					gender1 = (String) record1.get("gender");
					short_desc1 = (String) record1.get("short_desc");
					if (select1.equals("Y") && (!age_code.equals(age_code1))) {
						if (gender.equals(gender1)) {
							int min_age_sel_age_group = 0;
							int max_age_sel_age_group = 0;
							if (((String) record1.get("age_unit")).equals("Y")) {
								min_age_sel_age_group = (Integer.parseInt(((String) record1.get("min_age")))) * 365* 24 * 60;
								max_age_sel_age_group = (Integer.parseInt(((String) record1.get("max_age")))) * 365* 24 * 60;
							}
							else if (((String) record1.get("age_unit")).equals("M")) {
								min_age_sel_age_group = (Integer.parseInt(((String) record1.get("min_age")))) * 30* 24 * 60;
								max_age_sel_age_group = (Integer.parseInt(((String) record1.get("max_age")))) * 30* 24 * 60;
							} 
							else if (((String) record1.get("age_unit")).equals("D")) {
								min_age_sel_age_group = (Integer.parseInt(((String) record1.get("min_age")))) * 24 * 60;
								max_age_sel_age_group = (Integer.parseInt(((String) record1.get("max_age")))) * 24 * 60;
							} 
							else if (((String) record1.get("age_unit")).equals("H")) {
								min_age_sel_age_group = (Integer.parseInt(((String) record1.get("min_age")))) * 60;
								max_age_sel_age_group = (Integer.parseInt(((String) record1.get("max_age")))) * 60;
							} 
							else {
								min_age_sel_age_group = Integer.parseInt(((String) record1.get("min_age")));
								max_age_sel_age_group = Integer.parseInt(((String) record1.get("max_age")));
							}// else end

							if ((min_age_added_age_group > min_age_sel_age_group && min_age_added_age_group < max_age_sel_age_group) || (max_age_added_age_group > min_age_sel_age_group && max_age_added_age_group < max_age_sel_age_group) || (min_age_sel_age_group > min_age_added_age_group && min_age_sel_age_group < max_age_added_age_group) || (max_age_sel_age_group > min_age_added_age_group && max_age_sel_age_group < max_age_added_age_group)){
								overlap_found_yn =new StringBuffer( "Y").append(short_desc).append(" , ").append(short_desc1);
								break;
							}
						}// ifend gender
					}// if select end
				}
				if (overlap_found_yn.toString().startsWith("Y"))
					break;
			}
		}
		return overlap_found_yn.toString() ;
	}  

	public String getEDLDescriptions(String strEDLCodes){
		/*get the eqvl value**/
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		ArrayList alEDLDescriptions=new ArrayList();
		
		try{
			StringBuffer sbQuery = new StringBuffer(PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_SELECT_PATH"));
			sbQuery.append(strEDLCodes);

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sbQuery.toString()) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while(resultSet.next()){
				alEDLDescriptions.add(resultSet.getString("PATH"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return alEDLDescriptions.toString();
	}

	public ArrayList getSlidingScaleTmpls(){
		ArrayList tmpl_values = new ArrayList();
		Connection connection = null ;
		Statement stmt = null ;
		ResultSet resultSet = null ;
		String sql;

		try {
			connection = getConnection() ;
			stmt =connection.createStatement();
			sql=(String) PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_SELECT1");
			//sql="SELECT TEMPLATE_ID, TEMPLATE_DESC, EFF_STATUS FROM PH_SLIDING_SCALE_TMPL";
			resultSet = stmt.executeQuery(sql);
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					tmpl_values.add( resultSet.getString( "TEMPLATE_ID" ) ) ;
					tmpl_values.add( resultSet.getString( "TEMPLATE_DESC" ) ) ;
					tmpl_values.add( resultSet.getString("EFF_STATUS"));
					// tmpl_values.add( resultSet.getString("N"));															
				}
			}
		}
		catch ( Exception e ) {	
			e.printStackTrace() ;	
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(stmt);
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return tmpl_values;
	} // end function

	public ArrayList getSlidingScaleChkdTmpls(String drug_code){
		ArrayList tmpl_chkd_values = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		Statement stmt = null;
		ResultSet resultSet = null ;
		String sql;

		try {
			connection = getConnection() ;
			//stmt =connection.createStatement();
			sql = (String) PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_SELECT");
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1, (String) drug_code);
			//	sql="SELECT TEMPLATE_ID FROM PH_DRUG_SLIDING_SCALE_TMPL WHERE DRUG_CODE='"+drug_code+"'";
			resultSet = pstmt.executeQuery();
			while ( resultSet.next() ) {
				tmpl_chkd_values.add( resultSet.getString( "TEMPLATE_ID" ) ) ;
			}
			closeResultSet( resultSet ) ;

			//sql="SELECT TEMPLATE_ID FROM PH_SLIDING_SCALE_TMPL WHERE EFF_STATUS='D'";
			sql = (String) PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_SELECT2");
			stmt =connection.createStatement();
			resultSet = stmt.executeQuery(sql);
			while ( resultSet.next() ) {
				if(tmpl_chkd_values.contains(resultSet.getString( "TEMPLATE_ID" )))
					tmpl_chkd_values.remove(resultSet.getString( "TEMPLATE_ID" ));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;	
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ; //common-icn-0029
				stmt.close();
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return tmpl_chkd_values;
	} // end function

	public ArrayList getFDACategoryCodes(String category_code,String locale){
		ArrayList fdaCategoryList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		//Statement stmt = null;
		ResultSet resultSet = null ;
		String sql;
		try {
			connection = getConnection() ;
			//sql = (String) PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_SELECT");
			sql = "SELECT CATEGORY_CODE,CATEGORY_DESC FROM PH_PREGN_CAT_GROUP_DTL_LANG_VW WHERE CATEGORY_GROUP_CODE = ? AND LANGUAGE_ID = ? AND APPLICABLE_YN = ?";
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1, category_code);
			pstmt.setString(2, locale);
			pstmt.setString(3, "Y");
			resultSet = pstmt.executeQuery();
			while ( resultSet.next() ) {
				fdaCategoryList.add( resultSet.getString( "CATEGORY_CODE" ) ) ;
				fdaCategoryList.add( resultSet.getString( "CATEGORY_DESC" ) ) ;
			}					
		}
		catch ( Exception e ) {	
			e.printStackTrace() ;	
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return fdaCategoryList;
	} // end function

	public String getFDACategoryDescription(String category_code,String locale){
		//ArrayList fdaCategoryList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		//Statement stmt = null;
		ResultSet resultSet = null ;
		String sql;
		String categoryDescription = "";
		try {
			connection = getConnection() ;
			//sql = (String) PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_SELECT");
			sql = "SELECT CATEGORY_GROUP_DESC FROM PH_PREGN_CAT_GROUP_HDR_LANG_VW   WHERE CATEGORY_GROUP_CODE = ? AND LANGUAGE_ID = ?";
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1, category_code);
			pstmt.setString(2, locale);
			resultSet = pstmt.executeQuery();

			if  ( resultSet.next() ) {
				categoryDescription = resultSet.getString( "CATEGORY_GROUP_DESC" )  ;
			}					
		}
		catch ( Exception e ) {	
			e.printStackTrace() ;	
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				pstmt.close();
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return categoryDescription;
	} // end function

	public String getExternal_db_legend(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String sql;
		String external_db_legend = "";

		try {
			connection = getConnection() ;
			//sql = (String) PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_SELECT");
			sql = "Select product_desc from ph_external_product_lang_vw where product_id = (select DRUG_DB_PRODUCT_ID from ph_facility_param where facility_id=?) and language_id = ?";
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1, getLoginFacilityId());
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery();
			if  ( resultSet.next() ) {
				external_db_legend = resultSet.getString( "PRODUCT_DESC" )  ;
			}					
		}
		catch ( Exception e ) {	
			e.printStackTrace() ;	
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return external_db_legend;
	}
	//added for GHL-CRF-0548 START
	public String checkForMultiStrength()	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		String	 disp_multi_strength					= "";
		
		try{
			
				connection			= getConnection() ;
				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DISP_MULTI_STRENGTH_YN"));
				resultSet	= pstmt.executeQuery(); 
				
				if(resultSet.next()){
					disp_multi_strength= checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN"));
					if (  disp_multi_strength.equals("Y") ||disp_multi_strength.equals("M") || disp_multi_strength.equals("N")) {
						disp_multi_strength		=	"M";
					}
					else{
						disp_multi_strength		=	"S";
					}
				}
		}
		catch(Exception e){
			System.err.println("Error while fetching from ph_param  ="+e);
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}

		return disp_multi_strength;
	}
	//added for GHL-CRF-0548 END
	
	//modified method for SKR-SCF-1312 START
	public ArrayList getDescFromMM(String item_code,String locale)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String sql;
		//String short_desc = ""; //Commented for common-icn-0048
		//String long_desc = ""; //Commented for common-icn-0048
		ArrayList descList = new ArrayList();

		try {
					connection = getConnection() ;
					sql = "select LONG_DESC , short_desc from MM_ITEM_LANG_VW where item_code=? and LANGUAGE_ID = ?";
					pstmt				= connection.prepareStatement(sql) ;
					pstmt.setString(1, item_code);
					pstmt.setString(2, locale);
					resultSet = pstmt.executeQuery();
				
					if  ( resultSet.next() ) {
						
						descList.add(resultSet.getString( "short_desc"));
						descList.add(resultSet.getString( "LONG_DESC"));
						}					
				}
				
				catch ( Exception e ) {	e.printStackTrace() ;	}
				finally {
								try {
										closeResultSet( resultSet ) ;
										pstmt.close();
										closeConnection( connection );
									}catch(Exception es) {es.printStackTrace();}
							}
							
							
				return descList;
	}
	
	//Added for MMS-DM-CRF-0177
	
	public boolean isSite(HttpServletRequest request,String module_id,String description){
		boolean site=false;
	    Connection con			= null;  
	    try{
	    	con				= ConnectionManager.getConnection(request);		
	    	site = eCommon.Common.CommonBean.isSiteSpecific(con, module_id.trim(),description.trim());
		}
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
		finally{
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		}
		return site;
	}
	
	//Added for MMS-DM-CRF-0177

	public void setSupportDrugDetails(String drug_code){//Adding start for TH-KW-CRF-0007
		Connection con			= null;  
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String  strength  ="";
		String strength_value="";
		ArrayList supDrugDetails = new ArrayList();
		try{
		con = getConnection() ;
		pstmt				= con.prepareStatement("SELECT A.DRUG_CODE, A.DRUG_DESC, A.GENERIC_ID, C.GENERIC_NAME, A.FORM_CODE, B.FORM_DESC, A.PRES_BASE_UOM, D.SHORT_DESC, E.ROUTE_DESC, A.STRENGTH_PER_PRES_UOM,A.STRENGTH_UOM,A.STRENGTH_PER_VALUE_PRES_UOM FROM PH_DRUG A, PH_FORM B, PH_GENERIC_NAME C, AM_UOM D, PH_ROUTE E WHERE A.FORM_CODE=B.FORM_CODE(+)  AND A.GENERIC_ID=C.GENERIC_ID(+) AND A.PRES_BASE_UOM=D.UOM_CODE (+) AND A.ROUTE_CODE =E.ROUTE_CODE(+) AND A.DRUG_CODE=? AND A.DISCONTINUED_YN='N'");
		pstmt.setString(1,drug_code);
				resultSet	= pstmt.executeQuery();
				if  ( resultSet.next() ) {
						
						supDrugDetails.add(resultSet.getString( "DRUG_CODE"));
						supDrugDetails.add(resultSet.getString( "DRUG_DESC"));
						supDrugDetails.add(resultSet.getString( "GENERIC_NAME"));
						supDrugDetails.add(resultSet.getString( "FORM_DESC"));
						supDrugDetails.add(resultSet.getString( "SHORT_DESC"));
						supDrugDetails.add(resultSet.getString( "ROUTE_DESC"));
					if (resultSet.getString("STRENGTH_PER_PRES_UOM")!=null && !(resultSet.getString("STRENGTH_PER_PRES_UOM")).equals("0") ){
						strength=resultSet.getString("STRENGTH_PER_PRES_UOM");
						
						if(strength!=null && !strength.equals("") && Float.parseFloat(strength) <1){
							strength = Float.parseFloat(strength)+"";
						}
						strength_value	= strength+" "+resultSet.getString("STRENGTH_UOM")+" / "+resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")+" "+resultSet.getString("SHORT_DESC");						
					}
					else {
                         strength_value="";
					}
					    supDrugDetails.add(strength_value);
						SupportDrugs.put(resultSet.getString( "DRUG_CODE"),supDrugDetails);
		}
	}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( con );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		
	}

	public void loadSupportiveDrugs(String drug_code)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String sql;
		//ArrayList descList = new ArrayList(); COMMON-ICN-0310

		try {
					connection = getConnection() ;
					sql = "SELECT SUPPORTIVE_DRUG_CODE FROM PH_SUPPORTIVE_DRUGS WHERE PARENT_DRUG_CODE =? ORDER BY DISPLAY_SEQ_NO";
					pstmt				= connection.prepareStatement(sql) ;
					pstmt.setString(1, drug_code);
					resultSet = pstmt.executeQuery();
				
					while( resultSet.next() ) {
						SupportdrugList.add(resultSet.getString( "SUPPORTIVE_DRUG_CODE"));
						setSupportDrugDetails(resultSet.getString( "SUPPORTIVE_DRUG_CODE"));
						//System.err.println("SUPPORTIVE_DRUG_CODE==="+resultSet.getString( "SUPPORTIVE_DRUG_CODE")+"druglist==="+getSupportdrugList()+"supportdrugs==="+getSupportDrugs());
						}					
				}
				catch ( Exception e ) {	e.printStackTrace() ;	}
				finally {
								try {
										closeResultSet( resultSet ) ;
										pstmt.close();
										closeConnection( connection );
									}catch(Exception es) {es.printStackTrace();}
							}
							
	}//Adding end for TH-KW-CRF-0007
	
} 
