/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugDetailsBean extends PhAdapter implements Serializable{
 
	protected String drug_code			 ="";
    
	//for characteristics
	protected String DRUG_TYPE					="";   
	protected String SCHEDULED_DRUG_YN			="";
	protected String SCHEDULE_DESC				="";
	protected String RESTRICTED_DRUG_YN			="";
	protected String AFFECTS_PREGNANCY_YN		="";
	protected String AFFECTS_BREAST_FEEDING_YN	="";
	protected String AFFECTS_LAB_RESULTS_YN		="";
	protected String STABILITY_REQD_YN			="";
	protected String STABILITY_HRS				="";
	protected String PATIENT_COUNSELING_REQD    ="";
	protected String TDM_APPLICABLE				="";
	protected String VERBAL_ORDER_APPL_DRNG_MAR ="";
	protected String APPL_FOR_COMPOUNDING_RX    ="";
	protected String DRUG_INFORMATION			="";
	protected String PATIENT_EDUCATION			="";
	protected String PREG_CATEGORY_GROUP_CODE	="";
	protected String PREG_CATEGORY_CODE1		="";
	protected String PREG_CATEGORY_CODE2		="";
	protected String PREG_CATEGORY_CODE3		="";
	 
	private   String generic_name				="";
	//for prescribing details
	protected String PRES_BASE_UOM_DESC				="";
	protected String STRENGTH_VALUE					="";
	protected String STRENGTH_UOM_DESC				="";
	protected String STRENGTH_PER_PRES_UOM			="";
	protected String STRENGTH_PER_VALUE_PRES_UOM	="";
	
	//for dispensing rules
	protected String STOCK_UOM_DESC					="";
	protected String CONTENT_IN_PRES_BASE_UOM		="";
	protected String CALC_DOSG_BY_FREQ_DURN_YN		="";
	protected String FRACT_DOSE_ROUND_UP_YN			="";
	protected String DISP_MULTI_STRENGTH_YN			="";
	protected String IP_FILL_PROCESS				="";
	protected String PRN_DOSES_PRES_PRD_FILL		="";
	protected String PRN_DOSES_CONT_DAILY_FILL		="";
		
	//dispensing controls
	protected String DISP_AUTH_REQD_YN				="";
	protected String DISP_VIA_PRES_ONLY_YN			="";
	protected String DISP_AGAINST_DAMAGE_YN			="";
	
	//labels
	protected String CAUTION_LABEL_TEXT_ID1_DESC	="";
	protected String CAUTION_LABEL_TEXT_ID2_DESC	="";
	protected String SPL_INSTR_LABEL_TEXT_ID_DESC	="";
	protected String HOW_TO_TAKE_TEXT				="";

//for IV Characteristics
	protected String IV_INGREDIENT_YN				="";
	protected String IV_FLUID_YN					="";
	protected String INFUSE_OVER_VALUE				="";
	protected String INFUSE_OVER_DURN_TYPE			="";
	protected ArrayList DiagnosisList			=null;
	protected ArrayList AgeGroupList			=null;
	protected String VERIFICATION_REQD_YN				="";

	String debug = "" ;

/******************  Constructor  *************************************************/
    public DrugDetailsBean() {
        try {
            doCommon();
        }
        catch(Exception e) 
		{
			System.err.println("Exception in constructor"+e.toString()); e.printStackTrace();
		}
    }

/*********** Over-ridden Adapter methods start here *******************************/
	public void clear() {
       super.clear() ;
	}

	private void doCommon() throws Exception {
	}
/******************************************************/
	public void setDebug(String debug){
		this.debug = debug;
	}

	public String getDebug(){
		return debug;
	}
/***********************************************************/
	public void setDRUG_CODE( String drug_code ) {
		if(drug_code==null)
			this.drug_code="";	
		else
			this.drug_code = drug_code  ;
	}

	public String getDRUG_CODE() {

	   return this.drug_code  ;
	 }

/******************** prescribing details  *****************************/
	public void setSTOCK_UOM_DESC( String STOCK_UOM_DESC ) {
	
		if(STOCK_UOM_DESC==null)
			this.STOCK_UOM_DESC="";	
		else
			this.STOCK_UOM_DESC = STOCK_UOM_DESC  ;
	}
	public void setCONTENT_IN_PRES_BASE_UOM( String CONTENT_IN_PRES_BASE_UOM ) {
	
		if(CONTENT_IN_PRES_BASE_UOM==null)
			this.CONTENT_IN_PRES_BASE_UOM="";	
		else
			this.CONTENT_IN_PRES_BASE_UOM = CONTENT_IN_PRES_BASE_UOM  ;
	}
	public void setCALC_DOSG_BY_FREQ_DURN_YN( String CALC_DOSG_BY_FREQ_DURN_YN ) {
	
		if(CALC_DOSG_BY_FREQ_DURN_YN==null)
			this.CALC_DOSG_BY_FREQ_DURN_YN="";	
		else
			this.CALC_DOSG_BY_FREQ_DURN_YN = CALC_DOSG_BY_FREQ_DURN_YN  ;
	}
	public void setFRACT_DOSE_ROUND_UP_YN( String FRACT_DOSE_ROUND_UP_YN ) {
	
		if(FRACT_DOSE_ROUND_UP_YN==null)
			this.FRACT_DOSE_ROUND_UP_YN="";	
		else
			this.FRACT_DOSE_ROUND_UP_YN = FRACT_DOSE_ROUND_UP_YN  ;
	}
	public void setDISP_MULTI_STRENGTH_YN( String DISP_MULTI_STRENGTH_YN ) {

		if(DISP_MULTI_STRENGTH_YN==null)
			this.DISP_MULTI_STRENGTH_YN="";	
		else
			this.DISP_MULTI_STRENGTH_YN = DISP_MULTI_STRENGTH_YN  ;
	}

	public void setIP_FILL_PROCESS( String IP_FILL_PROCESS ) {

		if(IP_FILL_PROCESS==null)
			this.IP_FILL_PROCESS="";	
		else
			this.IP_FILL_PROCESS = IP_FILL_PROCESS  ;
	}
	public void setPRN_DOSES_PRES_PRD_FILL( String PRN_DOSES_PRES_PRD_FILL ) {

		if(PRN_DOSES_PRES_PRD_FILL==null)
			this.PRN_DOSES_PRES_PRD_FILL="";	
		else
			this.PRN_DOSES_PRES_PRD_FILL = PRN_DOSES_PRES_PRD_FILL  ;
	}
	public void setPRN_DOSES_CONT_DAILY_FILL( String PRN_DOSES_CONT_DAILY_FILL ) {

		if(PRN_DOSES_CONT_DAILY_FILL==null)
			this.PRN_DOSES_CONT_DAILY_FILL="";	
		else
			this.PRN_DOSES_CONT_DAILY_FILL = PRN_DOSES_CONT_DAILY_FILL  ;
	}
/*********get() for Prescribing details***********************************************************/

	public String getSTOCK_UOM_DESC(){
		return this.STOCK_UOM_DESC  ;
	}
	public String getCONTENT_IN_PRES_BASE_UOM(){
		return this.CONTENT_IN_PRES_BASE_UOM  ;
	}
	public String getCALC_DOSG_BY_FREQ_DURN_YN(){
		return this.CALC_DOSG_BY_FREQ_DURN_YN  ;
	}
	public String getFRACT_DOSE_ROUND_UP_YN(){
		return this.FRACT_DOSE_ROUND_UP_YN  ;
	}
	public String getDISP_MULTI_STRENGTH_YN(){
		return this.DISP_MULTI_STRENGTH_YN  ;
	}
	public String getIP_FILL_PROCESS(){
		return this.IP_FILL_PROCESS  ;
	}
	public String getPRN_DOSES_PRES_PRD_FILL(){
		return this.PRN_DOSES_PRES_PRD_FILL  ;
	}
	public String getPRN_DOSES_CONT_DAILY_FILL(){
		return this.PRN_DOSES_CONT_DAILY_FILL  ;
	}

	/*************set for Dispensing Controls****************************/
	public void setDISP_AUTH_REQD_YN( String DISP_AUTH_REQD_YN ) {
	
		if(DISP_AUTH_REQD_YN==null)
			this.DISP_AUTH_REQD_YN="";	
		else
			this.DISP_AUTH_REQD_YN = DISP_AUTH_REQD_YN  ;
	}
	public void setDISP_VIA_PRES_ONLY_YN( String DISP_VIA_PRES_ONLY_YN ) {

		if(DISP_VIA_PRES_ONLY_YN==null)
			this.DISP_VIA_PRES_ONLY_YN="";	
		else
			this.DISP_VIA_PRES_ONLY_YN = DISP_VIA_PRES_ONLY_YN  ;
	}
	public void setDISP_AGAINST_DAMAGE_YN( String DISP_AGAINST_DAMAGE_YN ) {

		if(DISP_AGAINST_DAMAGE_YN==null)
			this.DISP_AGAINST_DAMAGE_YN="";	
		else
			this.DISP_AGAINST_DAMAGE_YN = DISP_AGAINST_DAMAGE_YN  ;
	}
	public void setVERIFICATION_REQD_YN( String VERIFICATION_REQD_YN ) {

		if(VERIFICATION_REQD_YN==null)
			this.VERIFICATION_REQD_YN="";	
		else
			this.VERIFICATION_REQD_YN = VERIFICATION_REQD_YN  ;
	}

	/*********get() for Dispensing Controls****************************************/
	public String getVERIFICATION_REQD_YN(){
	return this.VERIFICATION_REQD_YN  ;
	}
	public String getDISP_AUTH_REQD_YN(){
	return this.DISP_AUTH_REQD_YN  ;
	}
	public String getDISP_VIA_PRES_ONLY_YN(){
	return this.DISP_VIA_PRES_ONLY_YN  ;
	}
	public String getDISP_AGAINST_DAMAGE_YN(){
	return this.DISP_AGAINST_DAMAGE_YN  ;
	}

	/*********************   label  **************************************/
	public void setCAUTION_LABEL_TEXT_ID1_DESC( String CAUTION_LABEL_TEXT_ID1_DESC ) {

		if(CAUTION_LABEL_TEXT_ID1_DESC==null)
			this.CAUTION_LABEL_TEXT_ID1_DESC="";	
		else
			this.CAUTION_LABEL_TEXT_ID1_DESC = CAUTION_LABEL_TEXT_ID1_DESC  ;
	}
	public void setCAUTION_LABEL_TEXT_ID2_DESC( String CAUTION_LABEL_TEXT_ID2_DESC ) {

		if(CAUTION_LABEL_TEXT_ID2_DESC==null)
			this.CAUTION_LABEL_TEXT_ID2_DESC="";	
		else
			this.CAUTION_LABEL_TEXT_ID2_DESC = CAUTION_LABEL_TEXT_ID2_DESC  ;
	}
	public void setSPL_INSTR_LABEL_TEXT_ID_DESC( String SPL_INSTR_LABEL_TEXT_ID_DESC ) {

		if(SPL_INSTR_LABEL_TEXT_ID_DESC==null)
			this.SPL_INSTR_LABEL_TEXT_ID_DESC="";	
		else
			this.SPL_INSTR_LABEL_TEXT_ID_DESC = SPL_INSTR_LABEL_TEXT_ID_DESC  ;
	}
	public void setHOW_TO_TAKE_TEXT( String HOW_TO_TAKE_TEXT ) {

		if(HOW_TO_TAKE_TEXT==null)
			this.HOW_TO_TAKE_TEXT="";	
		else
			this.HOW_TO_TAKE_TEXT = HOW_TO_TAKE_TEXT  ;
	}


	/*********get() for label***************************************/
			
	public String getCAUTION_LABEL_TEXT_ID1_DESC(){
	return this.CAUTION_LABEL_TEXT_ID1_DESC  ;
	}
	public String getCAUTION_LABEL_TEXT_ID2_DESC(){
	return this.CAUTION_LABEL_TEXT_ID2_DESC  ;
	}
	public String getSPL_INSTR_LABEL_TEXT_ID_DESC(){
	return this.SPL_INSTR_LABEL_TEXT_ID_DESC  ;
	}
	public String getHOW_TO_TAKE_TEXT(){
	return this.HOW_TO_TAKE_TEXT  ;
	}

	/**************************** IV Charecterstics******************/
	public void setIV_INGREDIENT_YN( String IV_INGREDIENT_YN ) {

		if(IV_INGREDIENT_YN==null)
			this.IV_INGREDIENT_YN="";	
		else
			this.IV_INGREDIENT_YN = IV_INGREDIENT_YN  ;
	}
	public void setIV_FLUID_YN( String IV_FLUID_YN ) {

		if(IV_FLUID_YN==null)
			this.IV_FLUID_YN="";	
		else
			this.IV_FLUID_YN = IV_FLUID_YN  ;
	}
	public void setINFUSE_OVER_VALUE( String INFUSE_OVER_VALUE ) {

		if(INFUSE_OVER_VALUE==null)
			this.INFUSE_OVER_VALUE="";	
		else
			this.INFUSE_OVER_VALUE = INFUSE_OVER_VALUE  ;
	}
	public void setINFUSE_OVER_DURN_TYPE( String INFUSE_OVER_DURN_TYPE ) {

		if(INFUSE_OVER_DURN_TYPE==null)
			this.INFUSE_OVER_DURN_TYPE="";	
		else if(INFUSE_OVER_DURN_TYPE.equals("H"))
			this.INFUSE_OVER_DURN_TYPE = "hrs"  ;
		else
			this.INFUSE_OVER_DURN_TYPE = INFUSE_OVER_DURN_TYPE  ;
	}
	/*********      get() IV Charactericstics ***************************************/
	public String getIV_INGREDIENT_YN(){
	return this.IV_INGREDIENT_YN  ;
	}
	public String getIV_FLUID_YN(){
	return this.IV_FLUID_YN  ;
	}
	public String getINFUSE_OVER_VALUE(){
	return this.INFUSE_OVER_VALUE  ;
	}
	public String getINFUSE_OVER_DURN_TYPE(){
	return this.INFUSE_OVER_DURN_TYPE  ;
	}

	/******************** prescribing details  *****************************/
	public void setPRES_BASE_UOM_DESC( String PRES_BASE_UOM_DESC ) {

		if(PRES_BASE_UOM_DESC==null)
			this.PRES_BASE_UOM_DESC="";	
		else
			this.PRES_BASE_UOM_DESC = PRES_BASE_UOM_DESC  ;
	}
	public void setSTRENGTH_VALUE( String STRENGTH_VALUE ) {

		if(STRENGTH_VALUE==null)
			this.STRENGTH_VALUE="";	
		else
			this.STRENGTH_VALUE = STRENGTH_VALUE  ;
	}
	public void setSTRENGTH_UOM_DESC( String STRENGTH_UOM_DESC ) {

		if(STRENGTH_UOM_DESC==null)
			this.STRENGTH_UOM_DESC="";	
		else
			this.STRENGTH_UOM_DESC = STRENGTH_UOM_DESC  ;
	}
	public void setSTRENGTH_PER_PRES_UOM( String STRENGTH_PER_PRES_UOM ) {

		if(STRENGTH_PER_PRES_UOM==null)
			this.STRENGTH_PER_PRES_UOM="";	
		else
			this.STRENGTH_PER_PRES_UOM = STRENGTH_PER_PRES_UOM  ;
	}
	public void setSTRENGTH_PER_VALUE_PRES_UOM( String STRENGTH_PER_VALUE_PRES_UOM ) {

		if(STRENGTH_PER_VALUE_PRES_UOM==null)
			this.STRENGTH_PER_VALUE_PRES_UOM="";	
		else
			this.STRENGTH_PER_VALUE_PRES_UOM = STRENGTH_PER_VALUE_PRES_UOM  ;
	}
/*********get() for Prescribing details***********************************************************/

	public String getPRES_BASE_UOM_DESC(){
		return this.PRES_BASE_UOM_DESC  ;
	}
	public String getSTRENGTH_VALUE(){
		return this.STRENGTH_VALUE  ;
	}
	public String getSTRENGTH_UOM_DESC(){
		return this.STRENGTH_UOM_DESC  ;
	}
	public String getSTRENGTH_PER_PRES_UOM(){
		return this.STRENGTH_PER_PRES_UOM  ;
	}
	public String getSTRENGTH_PER_VALUE_PRES_UOM(){
		return this.STRENGTH_PER_VALUE_PRES_UOM  ;
	}

/*****************   set for CHARACTERISCTICS************************************/

	public void setDRUG_TYPE( String DRUG_TYPE ) {
		if(DRUG_TYPE==null)
			this.DRUG_TYPE="";	
		else if(DRUG_TYPE.equals("V"))
			this.DRUG_TYPE = "Vaccine Drug"  ;
		else if(DRUG_TYPE.equals("I"))
			this.DRUG_TYPE = "Infection Control Drug"  ;
		else if(DRUG_TYPE.equals("S"))
			this.DRUG_TYPE = "Poisonous Scheduled Drug"  ;
		else
		 this.DRUG_TYPE = "" ;
	}
	public void setSCHEDULED_DRUG_YN( String SCHEDULED_DRUG_YN ) {

		if(SCHEDULED_DRUG_YN==null)
			this.SCHEDULED_DRUG_YN="";	
		else
			this.SCHEDULED_DRUG_YN = SCHEDULED_DRUG_YN  ;
	}
	public void setSCHEDULE_DESC( String SCHEDULE_DESC ) {
		if(SCHEDULE_DESC==null)
			this.SCHEDULE_DESC="";	  
		else
			this.SCHEDULE_DESC = SCHEDULE_DESC  ;
	}
	public void setRESTRICTED_DRUG_YN( String RESTRICTED_DRUG_YN ) {
		if(RESTRICTED_DRUG_YN==null) 
			this.RESTRICTED_DRUG_YN="";	
		else
			this.RESTRICTED_DRUG_YN = RESTRICTED_DRUG_YN  ;
	}
	public void setAFFECTS_PREGNANCY_YN( String AFFECTS_PREGNANCY_YN ) {

		if(AFFECTS_PREGNANCY_YN==null)
			this.AFFECTS_PREGNANCY_YN="";	
		else
			this.AFFECTS_PREGNANCY_YN = AFFECTS_PREGNANCY_YN  ;
	}   
	public void setAFFECTS_BREAST_FEEDING_YN( String AFFECTS_BREAST_FEEDING_YN ) {

		if( AFFECTS_BREAST_FEEDING_YN==null )
			this.AFFECTS_BREAST_FEEDING_YN="";	
		else
			this.AFFECTS_BREAST_FEEDING_YN =AFFECTS_BREAST_FEEDING_YN;// strength_value  ;
	}	
	public void setAFFECTS_LAB_RESULTS_YN( String AFFECTS_LAB_RESULTS_YN ) {

		if(AFFECTS_LAB_RESULTS_YN==null)
			this.AFFECTS_LAB_RESULTS_YN="";	
		else
			this.AFFECTS_LAB_RESULTS_YN = AFFECTS_LAB_RESULTS_YN  ;
	}
	public void setSTABILITY_REQD_YN( String STABILITY_REQD_YN ) {
		if(STABILITY_REQD_YN==null)
			this.STABILITY_REQD_YN="";	
		else
			this.STABILITY_REQD_YN = STABILITY_REQD_YN  ;
	}	
	public void setSTABILITY_HRS (String STABILITY_HRS ) {
		
		if(STABILITY_HRS==null)
			this.STABILITY_HRS="";	
		else
			this.STABILITY_HRS = STABILITY_HRS  ;
	}
	public void setPATIENT_COUNSELING_REQD( String PATIENT_COUNSELING_REQD ) {

		if(PATIENT_COUNSELING_REQD==null)
			this.PATIENT_COUNSELING_REQD="";	
		else
			this.PATIENT_COUNSELING_REQD = PATIENT_COUNSELING_REQD  ;
	}
	public void setTDM_APPLICABLE( String TDM_APPLICABLE ) {

		if(TDM_APPLICABLE==null)
			this.TDM_APPLICABLE="";	
		else
			this.TDM_APPLICABLE = TDM_APPLICABLE  ;
	}
	public void setVERBAL_ORDER_APPL_DRNG_MAR( String VERBAL_ORDER_APPL_DRNG_MAR ) {

		if(VERBAL_ORDER_APPL_DRNG_MAR==null)
			this.VERBAL_ORDER_APPL_DRNG_MAR="";	
		else
			this.VERBAL_ORDER_APPL_DRNG_MAR = VERBAL_ORDER_APPL_DRNG_MAR  ;
	}

	public void setAPPL_FOR_COMPOUNDING_RX( String APPL_FOR_COMPOUNDING_RX ) {

		if(APPL_FOR_COMPOUNDING_RX==null)
			this.APPL_FOR_COMPOUNDING_RX="";	
		else
			this.APPL_FOR_COMPOUNDING_RX = APPL_FOR_COMPOUNDING_RX  ;
	}
	public void setDRUG_INFORMATION( String DRUG_INFORMATION ) {

		if(DRUG_INFORMATION==null)
			this.DRUG_INFORMATION="";	
		else
			this.DRUG_INFORMATION = DRUG_INFORMATION  ;
	}
	public void setPATIENT_EDUCATION( String PATIENT_EDUCATION ) {

		if(PATIENT_EDUCATION==null)
			this.PATIENT_EDUCATION="";	
		else
			this.PATIENT_EDUCATION = PATIENT_EDUCATION  ;
	}
	public void setPREG_CATEGORY_GROUP_CODE( String PREG_CATEGORY_GROUP_CODE ) {

		if(PREG_CATEGORY_GROUP_CODE==null)
			this.PREG_CATEGORY_GROUP_CODE="";	
		else
			this.PREG_CATEGORY_GROUP_CODE = PREG_CATEGORY_GROUP_CODE  ;
	}
	public void setPREG_CATEGORY_CODE1( String PREG_CATEGORY_CODE1 ) {

		if(PREG_CATEGORY_CODE1==null)
			this.PREG_CATEGORY_CODE1="";	
		else
			this.PREG_CATEGORY_CODE1 = PREG_CATEGORY_CODE1  ;
	}
	public void setPREG_CATEGORY_CODE2( String PREG_CATEGORY_CODE2 ) {

		if(PREG_CATEGORY_CODE2==null)
			this.PREG_CATEGORY_CODE2="";	
		else
			this.PREG_CATEGORY_CODE2 = PREG_CATEGORY_CODE2  ;
	}
	public void setPREG_CATEGORY_CODE3( String PREG_CATEGORY_CODE3 ) {

		if(PREG_CATEGORY_CODE3==null)
			this.PREG_CATEGORY_CODE3="";	
		else
			this.PREG_CATEGORY_CODE3 = PREG_CATEGORY_CODE3  ;
	}

/*********** Get Methods Start ********************************************************/
	public String getDRUG_TYPE() {
        return this.DRUG_TYPE  ;
    }
	public String getSCHEDULED_DRUG_YN() {
        return this.SCHEDULED_DRUG_YN  ;
    }
	public String getSCHEDULE_DESC() {
        return this.SCHEDULE_DESC  ;
    }
    public String getRESTRICTED_DRUG_YN() {
        return this.RESTRICTED_DRUG_YN  ;
    }
    public String getAFFECTS_PREGNANCY_YN() {
        return this.AFFECTS_PREGNANCY_YN  ;
    }
    public String getAFFECTS_BREAST_FEEDING_YN (){
        return this.AFFECTS_BREAST_FEEDING_YN ;
    }
	 public String getAFFECTS_LAB_RESULTS_YN (){
        return this.AFFECTS_LAB_RESULTS_YN ;
    }
	 public String getSTABILITY_REQD_YN (){
        return this.STABILITY_REQD_YN ;
    }
	 public String getSTABILITY_HRS (){
        return this.STABILITY_HRS ;
    }
	public String getPATIENT_COUNSELING_REQD (){
        return this.PATIENT_COUNSELING_REQD ;
    }
	public String getTDM_APPLICABLE (){
        return this.TDM_APPLICABLE ;
    }
	public String getVERBAL_ORDER_APPL_DRNG_MAR (){
        return this.VERBAL_ORDER_APPL_DRNG_MAR ;
    }
	public String getAPPL_FOR_COMPOUNDING_RX (){
        return this.APPL_FOR_COMPOUNDING_RX ;
    }
	public String getDRUG_INFORMATION (){
        return this.DRUG_INFORMATION ;
    }
	public String getPATIENT_EDUCATION (){
        return this.PATIENT_EDUCATION ;
    }
	
	public ArrayList getDiagnosisList(){
		return this.DiagnosisList;
	}
	public void setDiagnosisList(ArrayList DiagnosisList){
		this.DiagnosisList = DiagnosisList;
	}
	public ArrayList getAgeGroupList(){
		return this.AgeGroupList;
	}
	public void setAgeGroupList(ArrayList AgeGroupList){
		this.AgeGroupList = AgeGroupList;
	}
	public String getPREG_CATEGORY_GROUP_CODE (){
        return this.PREG_CATEGORY_GROUP_CODE ;
    }
	public String getPREG_CATEGORY_CODE1 (){
        return this.PREG_CATEGORY_CODE1 ;
    }
	public String getPREG_CATEGORY_CODE2 (){
        return this.PREG_CATEGORY_CODE2 ;
    }
	public String getPREG_CATEGORY_CODE3 (){
        return this.PREG_CATEGORY_CODE3 ;
    }
/*********************************************************************************/
	public void getDrugDetails() throws Exception {

		String []stParameters   =   {getDRUG_CODE(), getLanguageId(), getLanguageId(), getLanguageId(), getLanguageId(), getLanguageId()};
		HashMap hmRecord		=   null;
		String sqlQry ="SELECT DRUG_CODE, DRUG_DESC, IN_FORMULARY_YN, LINK_TO_EXISTING_ITEM, ITEM_CODE, GENERIC_ID, GENERIC_NAME, DRUG_CLASS, COMPOUND_DRUG_YN, FORM_CODE, FORM_DESC, ROUTE_CODE, ROUTE_DESC, DRUG_TYPE, SCHEDULE_ID, SCHEDULE_DESC, RESTRICTED_DRUG_YN,TRIAL_DRUG_YN, AFFECTS_PREGNANCY_YN, AFFECTS_BREAST_FEEDING_YN, AFFECTS_LAB_RESULTS_YN, STABILITY_REQD_YN, STABILITY_HRS, PT_COUN_REQD_YN,PRES_BASE_UOM, PRES_BASE_UOM_DESC,CALC_DOSG_BY_FREQ_DURN_YN, STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_UOM_DESC, STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM, PRES_CATG_CODE, PRES_CATG_DESC, STOCK_UOM, STOCK_UOM_DESC, CONTENT_IN_PRES_BASE_UOM, FRACT_DOSE_ROUND_UP_YN,DISP_ALT_FORM_YN, DISP_MULTI_STRENGTH_YN, PRN_DOSES_PRES_PRD_FILL, PRN_DOSES_CONT_DAILY_FILL, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID1_DESC, CAUTION_LABEL_TEXT_ID_2, CAUTION_LABEL_TEXT_ID2_DESC, SPL_INSTR_LABEL_TEXT_ID, SPL_INSTR_LABEL_TEXT_ID1,SPL_INSTR_LABEL_TEXT_ID_DESC, HOW_TO_TAKE_TEXT, IV_INGREDIENT_YN, IV_FLUID_YN, INFUSE_OVER_VALUE, INFUSE_OVER_DURN_TYPE,PHYSICAL_FORM, ORDER_TYPE_CODE, DISCONTINUED_YN, DISCONTINUED_REASON, DISCONTINUED_DATE, DISCONTINUED_BY_ID, TRADE_CODE, MANUFACTURER_ID,PHYSICAL_FORM,CALC_DEF_DOSAGE_YN, IV_FLUID_FOR_ONCO_YN,DFLT_FLUID_CODE,APPL_PIGGY_BACK_YN,APPL_TO_RECONST_FLUID_YN,APPL_TO_TDM_YN, APPL_TO_VERBAL_ORDER_YN, APPL_FOR_COMPOUNDING_RX_YN,HOW_TO_TAKE_TEXT_LOCAL,MEDN_ADMN_DTL_REQD_YN,DRUG_INFORMATION,PATIENT_EDUCATION,WEIGHT_REC_APPL_AGE_GROUP, DIAG_REC_APPL,DIAG_SCR_NOTE_TYPE,DRUG_INFORMATION, PATIENT_EDUCATION,FRACT_DOSE_APPL_YN,ITEM_IMAGE_FILENAME,verification_reqd_yn,EDL_CODES, EDL_REMARKS, ALLOW_MORETHAN_PRES_QTY_YN, PREG_CATEGORY_GROUP_CODE, PREG_CATEGORY_CODE1, PREG_CATEGORY_CODE2, PREG_CATEGORY_CODE3  FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW WHERE DRUG_CODE = ? AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ?";
		//hmRecord    =   fetchRecord(PhRepository.getPhKeyValue( "SQL_PH_DRUG_DETAILS_SELECT1" ), stParameters);
		hmRecord    =   fetchRecord(sqlQry, stParameters);

		setDRUG_TYPE( (String)hmRecord.get ("DRUG_TYPE")  ) ;

		setDebug("::"+(String)hmRecord.get ("DRUG_TYPE")+"::");

		setSCHEDULE_DESC			( (String)hmRecord.get ("SCHEDULE_DESC")  ) ;
		if(getSCHEDULE_DESC().equals("") && getDRUG_TYPE().equals("Y")){
			setSCHEDULED_DRUG_YN		( "N" ) ;
		}
		else if (!getSCHEDULE_DESC().equals("") && getDRUG_TYPE().equals("Y")){
			setSCHEDULED_DRUG_YN		( "Y" ) ;
		}
			
		setRESTRICTED_DRUG_YN		( (String)hmRecord.get ("RESTRICTED_DRUG_YN")  ) ;
		setAFFECTS_PREGNANCY_YN		( (String)hmRecord.get ("AFFECTS_PREGNANCY_YN")  ) ;
		setAFFECTS_BREAST_FEEDING_YN( (String)hmRecord.get ("AFFECTS_BREAST_FEEDING_YN")  ) ;
		setAFFECTS_LAB_RESULTS_YN	( (String)hmRecord.get ("AFFECTS_LAB_RESULTS_YN")  ) ;
		setSTABILITY_REQD_YN		( (String)hmRecord.get ("STABILITY_REQD_YN")  ) ;
		setSTABILITY_HRS			( (String)hmRecord.get ("STABILITY_HRS")  ) ;
		setPATIENT_COUNSELING_REQD  ( (String)hmRecord.get ("PT_COUN_REQD_YN")  ) ;
		setTDM_APPLICABLE			( (String)hmRecord.get ("APPL_TO_TDM_YN")  ) ;
		setVERBAL_ORDER_APPL_DRNG_MAR( (String)hmRecord.get ("APPL_TO_VERBAL_ORDER_YN")  ) ;
		setAPPL_FOR_COMPOUNDING_RX	( (String)hmRecord.get ("APPL_FOR_COMPOUNDING_RX_YN")  ) ;
		setDRUG_INFORMATION			( (String)hmRecord.get ("DRUG_INFORMATION")  ) ;
		setPATIENT_EDUCATION		( (String)hmRecord.get ("PATIENT_EDUCATION")  ) ;
		setPREG_CATEGORY_GROUP_CODE	( (String)hmRecord.get ("PREG_CATEGORY_GROUP_CODE")  ) ;
		setPREG_CATEGORY_CODE1		( (String)hmRecord.get ("PREG_CATEGORY_CODE1")  ) ;
		setPREG_CATEGORY_CODE2		( (String)hmRecord.get ("PREG_CATEGORY_CODE2")  ) ;
		setPREG_CATEGORY_CODE3		( (String)hmRecord.get ("PREG_CATEGORY_CODE3")  ) ;

		/************* prescribing details********************************/
		setPRES_BASE_UOM_DESC			( (String)hmRecord.get ("PRES_BASE_UOM_DESC")  ) ;
		setSTRENGTH_VALUE				( (String)hmRecord.get ("STRENGTH_VALUE")  ) ;
		setSTRENGTH_UOM_DESC			( (String)hmRecord.get ("STRENGTH_UOM_DESC")  ) ;
		setSTRENGTH_PER_PRES_UOM		( (String)hmRecord.get ("STRENGTH_PER_PRES_UOM")  ) ;
		setSTRENGTH_PER_VALUE_PRES_UOM	( (String)hmRecord.get ("STRENGTH_PER_VALUE_PRES_UOM")  ) ;
		/************** dispensing rules  **********************************/
		setSTOCK_UOM_DESC			( (String)hmRecord.get ("STOCK_UOM_DESC")  ) ;
		setCONTENT_IN_PRES_BASE_UOM		( (String)hmRecord.get ("CONTENT_IN_PRES_BASE_UOM")  ) ;
		setCALC_DOSG_BY_FREQ_DURN_YN	( (String)hmRecord.get ("CALC_DOSG_BY_FREQ_DURN_YN")  ) ;
		setFRACT_DOSE_ROUND_UP_YN		( (String)hmRecord.get ("FRACT_DOSE_ROUND_UP_YN")  ) ;
		setDISP_MULTI_STRENGTH_YN		( (String)hmRecord.get ("DISP_MULTI_STRENGTH_YN")  ) ;
		setIP_FILL_PROCESS				( (String)hmRecord.get ("IP_FILL_PROCESS")  ) ;
		setPRN_DOSES_PRES_PRD_FILL		( (String)hmRecord.get ("PRN_DOSES_PRES_PRD_FILL")  ) ;
		setPRN_DOSES_CONT_DAILY_FILL	( (String)hmRecord.get ("PRN_DOSES_CONT_DAILY_FILL")  ) ;
					
		setDISP_AUTH_REQD_YN			( (String)hmRecord.get ("DISP_AUTH_REQD_YN")  ) ;
		setDISP_VIA_PRES_ONLY_YN		( (String)hmRecord.get ("DISP_VIA_PRES_ONLY_YN")  ) ;
		setDISP_AGAINST_DAMAGE_YN		( (String)hmRecord.get ("DISP_AGAINST_DAMAGE_YN")  ) ;
		setVERIFICATION_REQD_YN			( (String)hmRecord.get ("VERIFICATION_REQD_YN")  ) ;

		setCAUTION_LABEL_TEXT_ID1_DESC	( (String)hmRecord.get ("CAUTION_LABEL_TEXT_ID1_DESC")  ) ;
		setCAUTION_LABEL_TEXT_ID2_DESC	( (String)hmRecord.get ("CAUTION_LABEL_TEXT_ID2_DESC")  ) ;
		setSPL_INSTR_LABEL_TEXT_ID_DESC	( (String)hmRecord.get ("SPL_INSTR_LABEL_TEXT_ID_DESC")  ) ;
		setHOW_TO_TAKE_TEXT				( (String)hmRecord.get ("HOW_TO_TAKE_TEXT")  ) ;
		/***********    IV characteristics***********************************/
		setIV_INGREDIENT_YN		( (String)hmRecord.get ("IV_INGREDIENT_YN")  ) ;
		setIV_FLUID_YN			( (String)hmRecord.get ("IV_FLUID_YN")  ) ;
		setINFUSE_OVER_VALUE	( (String)hmRecord.get ("INFUSE_OVER_VALUE")  ) ;
		setINFUSE_OVER_DURN_TYPE( (String)hmRecord.get ("INFUSE_OVER_DURN_TYPE")  ) ;

		generic_name= (String)hmRecord.get("GENERIC_NAME");

		String []Parameters   =   {getDRUG_CODE()};
		ArrayList diag_Record    =   fetchRecords(PhRepository.getPhKeyValue( "SQL_PH_DRUG_DIGNOSIS_SELECT" ), Parameters);
		//hmRecord    =   fetchRecord("SELECT a.term_set_id term_set, short_desc diag_desc FROM ph_drug_eligible_term_code a, MR_TERM_CODE_LANG b WHERE a.drug_code = ? and b.language_id =? AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code ORDER BY a.term_set_id, short_desc", Parameters);
		setDiagnosisList(diag_Record);

		ArrayList alAgeGroupList    =   fetchRecords(PhRepository.getPhKeyValue( "SQL_PH_DRUG_AGE_GROUP_SELECT" ), Parameters);
		setAgeGroupList(alAgeGroupList);
	}

	public String getGenericName(){
		return this.generic_name;
	}
	/*********************************************************************************/
	public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
        
		HashMap hmRecord                    = new HashMap();
        Connection connection               = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        ResultSetMetaData resultSetMetaData = null;
					
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (stParameters!=null){
                for (int index=0; index<stParameters.length ;index++ ){          
                    preparedStatement.setString( index+1, stParameters[index]);
				}
			}
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData   =   resultSet.getMetaData();

            if(resultSet!=null){
				if(resultSetMetaData.getColumnCount()!=2){
					resultSet.next();
					for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ ){
						hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
					}
				}
				else{
					//hmRecord.put(resultSet.getString(1),resultSet.getString(2));
					while(resultSet.next()){
						hmRecord.put(resultSet.getString(1),resultSet.getString(2));
					}
				}
			}
        }
        catch (Exception exception )    {
            System.err.println("Error loading values from database");
            exception.printStackTrace();
            throw exception;
        }
        finally {
            try{
                closeResultSet(resultSet);
                closeStatement(preparedStatement);
                closeConnection(connection);
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
        }
		return hmRecord;
	}
	/***********************************************************************************/
	public ArrayList fetchRecords(String sql, String[] stParameters) throws Exception {
        
		HashMap hmRecord                    = new HashMap();
		ArrayList alAgeGroupList                    = new ArrayList();
        Connection connection               = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        ResultSetMetaData resultSetMetaData = null;
					
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (stParameters!=null){
                for (int index=0; index<stParameters.length ;index++ ){          
                    preparedStatement.setString( index+1, stParameters[index]);
				}
			}
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData   =   resultSet.getMetaData();

            if(resultSet!=null){
				while(resultSet.next()){
					hmRecord = new HashMap();
					for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ ){
						hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
					}
					alAgeGroupList.add(hmRecord);
				}
			}
        }
        catch (Exception exception )    {
            System.err.println("Error loading values from database");
            exception.printStackTrace();
            throw exception;
        }
        finally {
            try{
                closeResultSet(resultSet);
                closeStatement(preparedStatement);
                closeConnection(connection);
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
        }
		return alAgeGroupList;
	}
	/***********************************************************************************/
	public ArrayList getDrugCodeRelatedInfo(String drug_code) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		
		ArrayList record=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISC_DRUG_SELECT3") );
			pstmt.setString(1,drug_code.trim());
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			
			if ( resultSet.next() ){
				record.add(	resultSet.getString("DRUG_CODE"));
				record.add(	resultSet.getString("DRUG_DESC"));
				record.add(	resultSet.getString("GENERIC_NAME"));
				record.add(	resultSet.getString("STRENGTH_VALUE"));
				record.add(	resultSet.getString("ROUTE_DESC"));
				record.add(	resultSet.getString("FORM_DESC"));
				record.add(	resultSet.getString("FORM_CODE"));
				record.add(	resultSet.getString("PRES_BASE_UOM"));
    		}	
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}		
		return record;
	}

//  Written by Raghunath to check whether stock is installed or not

	public String stockInstallYN()throws Exception {

        String st_install_yn       = "N";
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        int count               = 0;

        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DETAILS_SELECT5") ) ;
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
                count=resultSet.getInt(1);
            }
			if(count==0) 
				st_install_yn="N";
			else st_install_yn="Y";

        }
		catch ( Exception e ) {
            System.err.println( "Error loading values from database" ) ;
            e.printStackTrace() ;
            throw e ;
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
		return st_install_yn;
    }
//to return the FDA Category List when Pregnancy affect is checked 
	public String getFDACategoryDesc(String category_group_code, String category_code)throws Exception {

       
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
      
		String categoryDescription = "";

        try {
            connection = getConnection() ;
           // pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DETAILS_SELECT5") ) ;
			String qryString = "  SELECT CATEGORY_DESC FROM PH_PREGN_CAT_GROUP_DTL_LANG_VW  WHERE CATEGORY_GROUP_CODE = ? AND CATEGORY_CODE = ? AND LANGUAGE_ID = ?";
            pstmt = connection.prepareStatement(qryString ) ;
            pstmt.setString(1,category_group_code) ;
            pstmt.setString(2,category_code) ;
            pstmt.setString(3,getLanguageId()) ;
            resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {
				categoryDescription= checkForNull(resultSet.getString("CATEGORY_DESC"));				
			}
        }
		catch ( Exception e ) {
             e.printStackTrace() ;
            throw e ;
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
		return categoryDescription;
    }
	public String getFDACategoryGroupDesc(String category_group_code)throws Exception {

       
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
      
		String categoryDescription = "";

        try {
            connection = getConnection() ;
           // pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DETAILS_SELECT5") ) ;
			String qryString = "  SELECT CATEGORY_GROUP_DESC FROM PH_PREGN_CAT_GROUP_HDR_LANG_VW  WHERE CATEGORY_GROUP_CODE = ? AND LANGUAGE_ID = ?";
            pstmt = connection.prepareStatement(qryString ) ;
            pstmt.setString(1,category_group_code) ;
            pstmt.setString(2,getLanguageId()) ;
            resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {
				categoryDescription= checkForNull(resultSet.getString("CATEGORY_GROUP_DESC"));				
			}
        }
		catch ( Exception e ) {
             e.printStackTrace() ;
            throw e ;
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
		return categoryDescription;
    }

/*********************************************************************************/
}//class end
